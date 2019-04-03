package com.sorin.idea.iu;

import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dto.Plantillas;
import com.sorin.idea.dto.PlantillasPk;
import com.sorin.idea.dto.TipoProcedimiento;
import com.sorin.idea.exceptions.PlantillasDaoException;
import com.sorin.idea.exceptions.TipoProcedimientoDaoException;
import com.sorin.idea.exceptions.UsuariosPlantillasDaoException;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.servicios.impl.ServicioPlantillasImpl;
import com.sorin.idea.servicios.impl.ServicioTipoProcedimientoImpl;
import com.sorin.idea.servicios.impl.ServicioUsuariosPlantillasImpl;

import hvn.cm.iu.IUException;

public class ControlPerfilUsuario extends BaseIU {

	private static final long serialVersionUID = 8750120845018831545L;
	
	private SelectorIdioma si;
	private ResourceBundle bundle;
	// Paciente
	private LoginForm lf;
	private ControlPacientes cp;
	private boolean editable;
	private String usuario;
	// Procedimiento
	private ProcedimientoDao procdao;
	
	// ListaPlantillas
	private List<SelectItem> listaPlantillas;
	private String selectedPlantilla;
	private List<SelectItem> listaAmbitos;
	private String selectedAmbito;
	private String tituloPlantilla;
	private String descripcionPlantilla;
	
	private boolean actualizaPlantilla = false;
	
	public ControlPerfilUsuario() {
		
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
		} catch (IUException e) {
			logError(this.bundle.getString("info_msg_error_carga_user"));
		}
	}
	
	public void iniciaPerfilUsuario(ActionEvent e) throws IUException, UsuariosPlantillasDaoException, PlantillasDaoException  {
		
		this.lf = (LoginForm) getBean("loginForm");
		this.usuario = lf.getSesionUsuario().getUsuario();
		this.setEditable(true);
		this.cp = (ControlPacientes) getBean("controlPacientes");
		
		if (cp == null) { 
			cp = new ControlPacientes();
		}

		procdao = new ProcedimientoDaoImpl();
		
		ServicioPlantillasImpl servicioPlantillasImpl = new ServicioPlantillasImpl(this.bundle);
		listaPlantillas = servicioPlantillasImpl.obtenerListaPlantillas(this.usuario) ;
		listaAmbitos = servicioPlantillasImpl.obtenerListaAmbitos( Arrays.asList( lf.getAccmods() ) );
	}
	
	public void guardarPlantillas( ActionEvent e ) {
		
		ServicioPlantillasImpl servicioPlantillasImpl = new ServicioPlantillasImpl(this.bundle);
		
		if( Integer.valueOf( this.selectedAmbito ) == 0 ) {
			this.pintaMensaje( 2, this.bundle.getString("info_msg_info_plantilla_seleccionarAmbito"));
			logInfo(this.bundle.getString("info_msg_info_plantilla_seleccionarAmbito") );
			return;
		}
		
		
		if ( actualizaPlantilla == true ) {
			try {
				servicioPlantillasImpl.actualizarPlantilla( Integer.valueOf( selectedPlantilla ), this.descripcionPlantilla, this.tituloPlantilla, Integer.valueOf( this.selectedAmbito ) );
				this.pintaMensaje( 1, this.bundle.getString("info_msg_info_plantilla_update"));
				logInfo(this.bundle.getString("info_msg_info_plantilla_update") );
			}
			catch( PlantillasDaoException ex ) {
				this.pintaMensaje( 1, this.bundle.getString("info_msg_error_plantilla_update"));
				logError(this.bundle.getString("info_msg_error_plantilla_update"));
			}
		}
		else {
			try {
				PlantillasPk plantillasPk = servicioPlantillasImpl.guardarPlantilla( this.descripcionPlantilla, this.tituloPlantilla, Integer.valueOf( this.selectedAmbito ) );
				ServicioUsuariosPlantillasImpl servicioUsuariosPlantillasImpl = new ServicioUsuariosPlantillasImpl();
				servicioUsuariosPlantillasImpl.guardarUsuarioPlantilla(this.usuario, plantillasPk.getIdPlantilla());
				listaPlantillas = servicioPlantillasImpl.obtenerListaPlantillas(this.usuario);
				listaAmbitos    = servicioPlantillasImpl.obtenerListaAmbitos( Arrays.asList( lf.getAccmods() ) );
				this.descripcionPlantilla = "";
				this.tituloPlantilla = "";
				this.pintaMensaje( 1, this.bundle.getString("info_msg_info_plantilla_ok"));
				logInfo(this.bundle.getString("info_msg_info_plantilla_ok") );
			}
			catch( PlantillasDaoException ex ) {
				this.pintaMensaje( 1, this.bundle.getString("info_msg_error_plantilla_update"));
				logError(this.bundle.getString("info_msg_error_plantilla_create")  + " " + ex.getMessage() );
			}
			catch(UsuariosPlantillasDaoException ex2 ) {
				this.pintaMensaje( 1, this.bundle.getString("info_msg_error_plantilla_update"));
				logError(this.bundle.getString("info_msg_error_plantilla_create") + " " + ex2.getMessage() );
			}
		}
	}
	
	public void cambiarPlantilla( ActionEvent e ){
		
		try {
			ServicioPlantillasImpl servicioPlantillasImpl = new ServicioPlantillasImpl(this.bundle);
			Plantillas plantilla = servicioPlantillasImpl.obtenerPlantillas(Integer.valueOf( selectedPlantilla ) );
			
			if( plantilla != null ) {
				actualizaPlantilla = true;
				this.tituloPlantilla      = plantilla.getTituloPlantilla();
				this.descripcionPlantilla = plantilla.getDescripcionPlantilla();
				
				ServicioTipoProcedimientoImpl tipoImpl = new ServicioTipoProcedimientoImpl();
				TipoProcedimiento tipoProcedmiento = tipoImpl.obtenerTipoProcedimiento(plantilla.getTipoProcedimiento() );
				this.setSelectedAmbito( String.valueOf( tipoProcedmiento.getIdTipoProcedimiento() ) );
			}
			else if ( Integer.valueOf( selectedPlantilla ) == 0  ) {
				this.tituloPlantilla = "";
				this.descripcionPlantilla = "";
				actualizaPlantilla = false;
			}
		}
		catch( PlantillasDaoException ex ) {
			this.pintaMensaje( 1, this.bundle.getString("info_msg_error_plantilla_get"));
			logError(this.bundle.getString("info_msg_error_plantilla_get") + " " + ex.getMessage() );
		}
		catch( TipoProcedimientoDaoException ex2 ) {
			this.pintaMensaje( 1, this.bundle.getString("info_msg_error_tipo_procedimiento_get"));
			logError(this.bundle.getString("info_msg_error_tipo_procedimiento_get") + " " + ex2.getMessage() );
		}

	}
	
	public void eliminarPlantilla( ActionEvent e ){
		
		try {
			ServicioPlantillasImpl servicioPlantillasImpl = new ServicioPlantillasImpl(this.bundle);
			servicioPlantillasImpl.eliminarPlantilla( Integer.valueOf( selectedPlantilla ) );
			this.descripcionPlantilla="";
			this.tituloPlantilla="";
			listaPlantillas = servicioPlantillasImpl.obtenerListaPlantillas(this.usuario);
			listaAmbitos    = servicioPlantillasImpl.obtenerListaAmbitos( Arrays.asList( lf.getAccmods() ) );
		}
		catch( PlantillasDaoException ex ) {
			this.pintaMensaje( 1, this.bundle.getString("info_msg_error_plantilla_delete"));
			logError(this.bundle.getString("info_msg_error_plantilla_delete"));
		} catch (UsuariosPlantillasDaoException e1) {
			this.pintaMensaje( 1, this.bundle.getString("info_msg_error_plantilla_delete"));
			logError(this.bundle.getString("info_msg_error_plantilla_delete"));
		}
	}
	
	// GETTERS AND SETTERS
	
	public SelectorIdioma getSi() {
		return si;
	}

	public void setSi(SelectorIdioma si) {
		this.si = si;
	}

	public ResourceBundle getBundle() {
		return bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	public LoginForm getLf() {
		return lf;
	}

	public void setLf(LoginForm lf) {
		this.lf = lf;
	}

	public ControlPacientes getCp() {
		return cp;
	}

	public void setCp(ControlPacientes cp) {
		this.cp = cp;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public ProcedimientoDao getProcdao() {
		return procdao;
	}

	public void setProcdao(ProcedimientoDao procdao) {
		this.procdao = procdao;
	}

	public List<SelectItem> getListaPlantillas() {
		return listaPlantillas;
	}

	public void setListaPlantillas(List<SelectItem> listaPlantillas) {
		this.listaPlantillas = listaPlantillas;
	}

	public String getSelectedPlantilla() {
		return selectedPlantilla;
	}

	public void setSelectedPlantilla(String selectedPlantilla) throws NumberFormatException, PlantillasDaoException {
		this.selectedPlantilla = selectedPlantilla;
	}

	public String getDescripcionPlantilla() {
		return descripcionPlantilla;
	}

	public void setDescripcionPlantilla(String descripcionPlantilla) {
		this.descripcionPlantilla = descripcionPlantilla;
	}

	public String getTituloPlantilla() {
		return tituloPlantilla;
	}

	public void setTituloPlantilla(String tituloPlantilla) {
		this.tituloPlantilla = tituloPlantilla;
	}

	public List<SelectItem> getListaAmbitos() {
		return listaAmbitos;
	}

	public void setListaAmbitos(List<SelectItem> listaAmbitos) {
		this.listaAmbitos = listaAmbitos;
	}

	public String getSelectedAmbito() {
		return selectedAmbito;
	}

	public void setSelectedAmbito(String selectedAmbito) {
		this.selectedAmbito = selectedAmbito;
	}
}

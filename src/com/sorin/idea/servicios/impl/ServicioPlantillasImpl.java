package com.sorin.idea.servicios.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.sorin.idea.dto.ArrAccesoModulos;
import com.sorin.idea.dto.Plantillas;
import com.sorin.idea.dto.PlantillasPk;
import com.sorin.idea.dto.UsuariosPlantillas;
import com.sorin.idea.exceptions.PlantillasDaoException;
import com.sorin.idea.exceptions.UsuariosPlantillasDaoException;
import com.sorin.idea.iu.BaseIU;
import com.sorin.idea.iu.SelectorIdioma;
import com.sorin.idea.jdbc.PlantillasDaoImpl;
import com.sorin.idea.servicios.ServicioPlantillas;

import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

public class ServicioPlantillasImpl extends BaseIU implements ServicioPlantillas {

	private static final long serialVersionUID = 5878965836496099674L;
	
	private SelectorIdioma si;
	private ResourceBundle bundle;
	
	// ListaPlantillas
	private List<SelectItem> listaPlantillas;
	private List<SelectItem> listaAmbitos;
	
	public ServicioPlantillasImpl(){
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
		} catch (IUException e) {
			this.pintaMensaje( Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_rec_pat")+": "+ e.getMessage());
		}
	}
	
	@Override
	public Plantillas obtenerPlantillas( int idPlantilla ) throws PlantillasDaoException {
		PlantillasDaoImpl plantillasDaoImpl = new PlantillasDaoImpl();
		return plantillasDaoImpl.findByPrimaryKey( idPlantilla );
	}
	
	@Override
	public void eliminarPlantilla( int idPlantilla ) throws PlantillasDaoException {
		PlantillasDaoImpl plantillasDaoImpl = new PlantillasDaoImpl();
		PlantillasPk pk = new PlantillasPk();
		pk.setIdPlantilla( idPlantilla );
		plantillasDaoImpl.delete( pk );
	}
	
	@Override
	public PlantillasPk guardarPlantilla( String descripcionPlantilla, String  tituloPlantilla, int idAmbito ) throws PlantillasDaoException {
		PlantillasDaoImpl plantillasDaoImpl = new PlantillasDaoImpl();
		Plantillas plantilla = new Plantillas();
		plantilla.setTipoProcedimiento( idAmbito );
		plantilla.setTituloPlantilla( tituloPlantilla );
		plantilla.setDescripcionPlantilla( descripcionPlantilla );
		return plantillasDaoImpl.insert( plantilla );
	}
	
	@Override
	public void actualizarPlantilla( int idPlantilla, String descripcionPlantilla, String tituloPlantilla, int idAmbito ) throws PlantillasDaoException {
		PlantillasDaoImpl plantillasDaoImpl = new PlantillasDaoImpl();
		PlantillasPk pk = new PlantillasPk();
		pk.setIdPlantilla(  idPlantilla  );
		Plantillas plantilla = new Plantillas();
		plantilla.setIdPlantilla(idPlantilla);
		plantilla.setTipoProcedimiento( idAmbito );
		plantilla.setTituloPlantilla( tituloPlantilla );
		plantilla.setDescripcionPlantilla( descripcionPlantilla );
		plantillasDaoImpl.update( pk, plantilla );
	}
	
	public List<SelectItem> obtenerListaPlantillas( String usuario ) throws UsuariosPlantillasDaoException, PlantillasDaoException{
		
			ServicioUsuariosPlantillasImpl servicioUsuariosPlantillasImpl = new ServicioUsuariosPlantillasImpl();
			List<UsuariosPlantillas> listaUsuarioPlantillas = servicioUsuariosPlantillasImpl.obtenerListadoUsuarioPlantillas( usuario );
			
			listaPlantillas = new ArrayList<SelectItem>();
			SelectItem option = new SelectItem( String.valueOf( 0 ), this.bundle.getString( "tipoProc_NuevaPlantilla" ) );
	        this.listaPlantillas.add(option);
			
			for( UsuariosPlantillas usuariosPlantillas : listaUsuarioPlantillas ) {
				Plantillas plantilla = obtenerPlantillas( usuariosPlantillas.getIdPlantilla() ) ;
				option = new SelectItem( String.valueOf( plantilla.getIdPlantilla() ), plantilla.getTituloPlantilla() );
	            this.listaPlantillas.add(option);
			}
			
			return listaPlantillas;
	}
	
	public List<SelectItem> obtenerListaAmbitos( List<ArrAccesoModulos> listaModulos ) throws PlantillasDaoException, UsuariosPlantillasDaoException {
		
		if( listaModulos != null && listaModulos.size() > 0 ) {
			
			listaAmbitos = new ArrayList<SelectItem>();
			
			SelectItem option = new SelectItem( "0", this.bundle.getString( "tipoProc_Seleccionar" ) );
			listaAmbitos.add(option);
			
			for( ArrAccesoModulos arrAccesoModulos : listaModulos ) {
				
				switch ( arrAccesoModulos.getIdTipoProcedimiento()  ) {
			      case 956:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_Primo_Implante" )  );
						listaAmbitos.add(option);
						continue;
			      case 957:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_Reintervencion" ) );
						listaAmbitos.add(option);
						continue;
			      case 1059:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_Recambio" )  );
						listaAmbitos.add(option);
						continue;
			      case 1060:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_Upgrade" ) );
						listaAmbitos.add(option);
						continue;
			      case 993:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_IntervencionPrevia" ) );
						listaAmbitos.add(option);
						continue;
			      case 1085:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_RecolocacionGenerador" )   );
						listaAmbitos.add(option);
						continue;
			      case 1147:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_Explante" ) );
						listaAmbitos.add(option);
						continue;
			      case 1086:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_RecolocacionElectrodo" )  );
						listaAmbitos.add(option);
						continue;
			      case 1090:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_Reimplante" )  );
						listaAmbitos.add(option);
						continue;
			      case 1061:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_EEF" ) );
						listaAmbitos.add(option);
						continue;
			      case 1062:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_Enfermeria" )  );
						listaAmbitos.add(option);
						continue;
			      case 1068:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_Cardioversion" ) );
						listaAmbitos.add(option);
						continue;
			      case 1066:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_MesaBasculante" ) );
						listaAmbitos.add(option);
						continue;
			      case 1067:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_RegistradorEventos" ) );
						listaAmbitos.add(option);
						continue;
			      case 1063:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_TestATP" )  );
						listaAmbitos.add(option);
						continue;
			      case 1064:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_TestFlecainida" ) );
						listaAmbitos.add(option);
						continue;
			      case 1065:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_TestFlecainida" ) );
						listaAmbitos.add(option);
						continue;
			      case 983:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_SeguimientoDispositivo" )  );
						listaAmbitos.add(option);
						continue;
			      case 1087:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_SeguimientoClinico" ) );
						listaAmbitos.add(option);
						continue;
			      case 1088:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_SeguimientoRegistradorEventos" )  );
						listaAmbitos.add(option);
						continue;
			      case 1089:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_Holter" ) );
						listaAmbitos.add(option);
						continue;
			      case 1091:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_RegistradoEventosExterno" ) );
						listaAmbitos.add(option);
						continue;
			      case 1092:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_TestOrtostatismoActivo" ) );
						listaAmbitos.add(option);
						continue;
			      case 1093:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_ProtocoloSincope" ) );
						listaAmbitos.add(option);
						continue;
			      case 1094:
						option = new SelectItem( String.valueOf( arrAccesoModulos.getIdTipoProcedimiento() ), this.bundle.getString( "tipoProc_RehabilitaciónCardiaca" ) );
						listaAmbitos.add(option);
						continue;
				}
			}
		}
		return listaAmbitos;
	}
}

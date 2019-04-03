package com.sorin.idea.iu;

import java.util.ArrayList;

import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ArrSeccionesDao;
import com.sorin.idea.dao.ArrTablasmaestrasDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrMaestrasPk;
import com.sorin.idea.dto.ArrSecciones;
import com.sorin.idea.dto.ArrTablasmaestras;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.exceptions.ArrMaestrasDaoException;
import com.sorin.idea.exceptions.ArrSeccionesDaoException;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ArrSeccionesDaoImpl;
import com.sorin.idea.jdbc.ArrTablasmaestrasDaoImpl;

import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

public class ControlMaestras extends BaseIU {
	private static final long serialVersionUID = 1L;

	private ArrayList<SelectItem> listaSecciones;
	private ArrayList<SelectItem> listaTablas;
	private Integer seccionSelect = 0;
	private Integer tablaSelect = 0;
	private Integer modDato = 0;
	private String usuario;
	private ArrMaestras[] listaDatos;
	private ArrMaestras datoSelect;
	private ArrMaestrasDao maestrasdao;
	private ArrSeccionesDao seccionesdao;
	private ArrSecciones[] secciones;
	private ArrTablasmaestrasDao tablasmaestrasdao;

	// Tabla de datos de la maestra.
	private HtmlDataTable bindingTabla;
	private Integer pagina_inicial = 1;

	public ControlMaestras() {
		this.iniciaMaestras(null);
	}

	public void iniciaMaestras(ActionEvent e) {
		try {
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
			LoginForm loginform;
			loginform = (LoginForm) getBean("loginForm");
			this.usuario = loginform.getSesionUsuario().getUsuario();
			this.seccionesdao = new ArrSeccionesDaoImpl(this.usuario);
			this.tablasmaestrasdao = new ArrTablasmaestrasDaoImpl(this.usuario);
			this.maestrasdao = new ArrMaestrasDaoImpl(this.usuario);

			this.datoSelect = new ArrMaestras();
			this.listaTablas = new ArrayList<SelectItem>();
			this.listaTablas.add(new SelectItem("0", "(Seleccione tabla)"));
			this.listaSecciones = new ArrayList<SelectItem>();
			this.listaSecciones.add(new SelectItem(0, "(Seleccione sección)"));
			this.secciones = this.seccionesdao.findAll();
			for (int i = 0; i < this.secciones.length; i++)
				this.listaSecciones.add(new SelectItem(this.secciones[i]
						.getCodigo(), this.secciones[i].getNombre()));
		} catch (IUException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Error no se ha podido recuperar los datos del usuario. ");
		} catch (ArrSeccionesDaoException ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"No se han obtenido los datos de las secciones: "
							+ ex.getMessage());
		}

		this.buscaDatos(null);
	}

	public ArrayList<SelectItem> getListaTablas() {
		return listaTablas;
	}

	public void seleccionaSeccion(ActionEvent e) {
		this.listaTablas = new ArrayList<SelectItem>();
		this.listaTablas.add(new SelectItem("0", "(Seleccione tabla)"));
		try {
			if (this.seccionSelect > 0) {
				ArrTablasmaestras[] tablas = tablasmaestrasdao
						.findWhereSeccionEquals(this.seccionSelect);
				if (tablas != null && tablas.length > 0)
					for (ArrTablasmaestras tb : tablas) {
						this.listaTablas.add(new SelectItem(tb.getTipo(), tb
								.getNombre()));
					}
			}
		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Error no se ha podido recuperar la lista de tablas: "
							+ ex.getMessage());
		}
	}

	public void buscaDatos(ActionEvent event) {
		try {
			this.listaDatos = null;
			this.datoSelect = new ArrMaestras();
			this.modDato = 0;
			if (this.tablaSelect != 0)
				this.listaDatos = this.maestrasdao
						.findWhereTipoEquals(this.tablaSelect);
		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Error al buscar los datos." + ex);
		}
	}

	public ArrayList<SelectItem> getListaSecciones() {
		return listaSecciones;
	}

	public void guardaDato(ActionEvent event) {
		try {
			if (this.tablaSelect != null && !this.tablaSelect.equals("0")) {
				if (this.datoSelect != null
						&& !this.datoSelect.getValor().equals("")) {
					this.datoSelect.setTipo(this.tablaSelect);
					this.datoSelect.setActivo(1);
					this.maestrasdao.insert(this.datoSelect);
					this.listaDatos = this.maestrasdao
							.findWhereTipoEquals(this.tablaSelect);
					this.datoSelect = new ArrMaestras();
				} else {
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
							"Debe escribir una descripción.");
				}
			} else {
				this
						.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
								"Debe elegir el tipo de campo en el que quiere insertar un nuevo dato.");
			}

		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Error al guardar el dato." + ex.getMessage());
		}
	}

	public void modificaDato(ActionEvent event) {
		try {
			if (this.datoSelect != null
					&& !this.datoSelect.getValor().equals("")) {
				this.datoSelect.setActivo(1);
				this.maestrasdao.update(this.datoSelect.createPk(),
						this.datoSelect);
				this.listaDatos = this.maestrasdao
						.findWhereTipoEquals(this.tablaSelect);
				this.datoSelect = new ArrMaestras();
				this.modDato = 0;
			} else {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						"Debe escribir una descripción.");
			}

		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Error al modificar el dato." + ex.getMessage());
		}
	}

	public void eliminaDato(ActionEvent event) {
		try {
			if (this.datoSelect.getCodigo() != null
					&& this.datoSelect.getCodigo() > 0) {
				//this.maestrasdao.delete(this.datoSelect.createPk());
				this.datoSelect.setActivo(0);
				this.maestrasdao.update(new ArrMaestrasPk(this.datoSelect.getCodigo()), this.datoSelect);
				this.listaDatos = this.maestrasdao
						.findWhereTipoEquals(this.tablaSelect);
				this.datoSelect = new ArrMaestras();
				this.modDato = 0;
			} else {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						"Debe escribir una descripción.");
			}

		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Error al modificar el dato." + ex.getMessage());
		}
	}

	public void nuevoDato(ActionEvent event) {
		this.datoSelect = new ArrMaestras();
		this.modDato = 0;
	}

	public void lineaSelect(ActionEvent event) {
		int index = this.bindingTabla.getRowIndex();
		this.datoSelect = this.listaDatos[index];
		this.tablaSelect = this.datoSelect.getTipo();
		this.modDato = 1;
	}

	public Integer getTipoSelect() {
		return tablaSelect;
	}

	public void setTipoSelect(Integer tipoSelect) {
		this.tablaSelect = tipoSelect;
	}

	public Integer getModDato() {
		return modDato;
	}

	public void setModDato(Integer modDato) {
		this.modDato = modDato;
	}

	public HtmlDataTable getBindingTabla() {
		return bindingTabla;
	}

	public void setBindingTabla(HtmlDataTable bindingTabla) {
		this.bindingTabla = bindingTabla;
	}

	public Integer getPagina_inicial() {
		return pagina_inicial;
	}

	public void setPagina_inicial(Integer paginaInicial) {
		pagina_inicial = paginaInicial;
	}

	public ArrayList<ArrMaestras> getListaDatos() {
		ArrayList<ArrMaestras> tmp = new ArrayList<ArrMaestras>();
		for (int i = 0; this.listaDatos != null && i < this.listaDatos.length; i++)
			tmp.add(this.listaDatos[i]);
		return tmp;
	}

	public void setListaDatos(ArrMaestras[] listaDatos) {
		this.listaDatos = listaDatos;
	}

	public ArrMaestras getDatoSelect() {
		return datoSelect;
	}

	public void setDatoSelect(ArrMaestras datoSelect) {
		this.datoSelect = datoSelect;
	}

	public Integer getSeccionSelect() {
		return seccionSelect;
	}

	public void setSeccionSelect(Integer seccionSelect) {
		this.seccionSelect = seccionSelect;
	}

	public Integer getTablaSelect() {
		return tablaSelect;
	}

	public void setTablaSelect(Integer tablaSelect) {
		this.tablaSelect = tablaSelect;
	}
	
	public ArrMaestras[] getCaracterProcedencia() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 1 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getHospitalProcedencia() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 2 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getFuncionVentricular() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 3 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getDiagnostico() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 4 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getEnfermeriaTodos() throws ArrMaestrasDaoException{
		return this.maestrasdao.findWhereTipoEquals(5);
	}
	
	public ArrMaestras[] getEnfermeria() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 5 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getPrimerOperador() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 6 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getPrimerOperadorTodos() throws ArrMaestrasDaoException{
		return this.maestrasdao.findWhereTipoEquals(6);
	}
	
	public ArrMaestras[] getSegundoOperador() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 7 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getSegundoOperadorTodos() throws ArrMaestrasDaoException{
		return this.maestrasdao.findWhereTipoEquals(7);
	}
	
	public ArrMaestras[] getAnestesista() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 8 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getAnestesistaTodos() throws ArrMaestrasDaoException{
		return this.maestrasdao.findWhereTipoEquals(8);
	}
	
	public ArrMaestras[] getInteresCientifico() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 9 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getNavegador() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 10 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getEscopia() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 11 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getEcografiaIntracardiaca() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 12 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getRitmoSinusal() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 13 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getConduccionNoNormal() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 14 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getQrsNoNormal() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 15 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getCateteres() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 18 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getCateteresAblacion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 44 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getFuncion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 19 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getLocalizacion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 20 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getViaAcceso() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 21 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getHipersensibilidad() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 22 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getPruebasFarmacologicasFS() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 23 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getResultadosFS() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 42 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getFisiologiaDobleVia() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 24 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getConduccionNodal() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 25 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getFarmacosAV() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 26 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getBloqueo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 27 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getNivelBloqueo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 28 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getPruebasAV() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 40 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getResultadosAV() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 43 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getTipoVia() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 29 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getSentidoConduccion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 30 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getTipoConduccion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 31 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getTipoPeriodo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 32 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getTejidos() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 33 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getFarmacosPR() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 34 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getPuntoEstimulacion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 36 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getModoInduccion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 37 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getInduccionAAVV() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 38 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getFarmacosTAQ() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 39 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getTipoProcedimientos() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 45 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getATPClinico() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 46 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getATPEcg() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 47 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getATPDosis() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 48 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getATPComp() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 49 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getATPTratam() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 50 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getEPIClinico() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 51 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getEPIEcg() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 52 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getFLEClinico() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 53 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getFLEEcg() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 54 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getTestComp() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 55 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getTestTrat() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 56 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getEPIres() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 57 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getFLEres() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 58 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getMorfologias() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 59 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getEmailMensuales() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 60 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getEmailAnuales() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 61 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getServidorCorreo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 62 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getArritmiasLE() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 63 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getProcedimientosLE() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 64 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getAnticoagulanteLE() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 65 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getCaracterLE() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 66 AND ACTIVO =1", null);
	}
	
	public ArrMaestras[] getReferidores() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 67 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getModeloImplantes() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 68 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getSintomas() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 69 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getEtiologia() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 70 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getCardiopatia() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 71 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getViaAccesoImplanteElectrodo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 72 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getZonaCamaraAD() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 73 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getZonaCamaraVD() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 74 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getZonaCamaraVI() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 75 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getZonaEpicardico() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 76 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getCamara() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 77 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getLateralidad() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 78 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getPorcion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 79 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getTipoprocedimiento() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 80 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getMotivoRecambioGen() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 81 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getMotivoRecolocacionGen() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 82 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getMotivoRecambioElec() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 83 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getMotivoRecolocacionElec() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 84 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getTipoComplicacionIntra() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 85 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getTipoComplicacionPost() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 86 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getMotivoExplanteGen() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 87 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getMotivoExplanteElec() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 88 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getLocalizacionGenerador() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 89 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getRitmosTV() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 90 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getRitmosFA() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 91 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getRitmosSA() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 92 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getQRSOtros() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 93 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getConduccionAVOtros() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 94 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getTipoComplicacionSeg() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 95 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getFabricanteGenerador() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 96 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getModoGenerador() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 97 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getConectorADGenerador() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 98 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getConectorVDGenerador() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 99 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getConectorVIGenerador() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 100 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getFabricanteElectrodo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 101 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getPolaridadElectrodo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 102 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getConectorElectrodo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 103 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getFijacionElectrodo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 104 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getBobinaElectrodo() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 105 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getMotivosTerapiaNoApropiada() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 106 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getFabricanteCateter() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 107 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getRobot() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 108 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getTiposMedicacion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 109 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getViaAdminMedicacion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 110 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getFormasPresentacionMedicacion() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 111 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getTiposSeguimientoClinico() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 112 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getMotivosSeguimientoClinico() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 113 AND ACTIVO =1", null);
	}
	public ArrMaestras[] getZonaCamaraSICD() throws ArrMaestrasDaoException{
		return this.maestrasdao.findByDynamicWhere("TIPO = 114 AND ACTIVO =1", null);
	}
}

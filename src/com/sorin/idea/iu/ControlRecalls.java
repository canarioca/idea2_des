package com.sorin.idea.iu;

import hvn.cm.modelo.Mensaje;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.log4j.Logger;

import com.sorin.idea.dao.ArrRegistradorDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dto.RecallDto;
import com.sorin.idea.jdbc.ArrRegistradorDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.util.ExportExcel;

public class ControlRecalls extends BaseIU{

	private static final long serialVersionUID = -2815005343083864824L;
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private String usuario;
	private static Logger logger = Logger.getLogger(ControlCitas.class);
	private LoginForm lf;
	
	private ImpImplanteDao impdao;
	private ArrRegistradorDao regdao;
	
	private ArrayList<RecallDto> lista;
	private HtmlDataTable bindingRecalls;
	private Integer filtroTipo;
	private String filtroModelo;
	private String filtroNumserie;
	private String filtroNumSerieFin;
	private Date fechaini;
	private Date fechafin;
	private boolean consultaRangos;
	
	private Integer pagina_inicial = 1;
	
	public void inicia(ActionEvent e){
		try{
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			
			this.impdao = new ImpImplanteDaoImpl(this.usuario);
			this.regdao = new ArrRegistradorDaoImpl(this.usuario);
			this.lista = new ArrayList<RecallDto>();
			this.limpiar(null); // inicializa filtros
			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_mod")+": "+ e1.getMessage());
		}
	}
	
	public void consulta(ActionEvent e){
		try{
			if(validarFiltros()){
				this.lista.clear();
				// Si no se establece fecha fin, se pone como tope la actual
				if(this.fechafin==null)
					this.setFechafin(new Date());
				if(this.fechaini==null){
					try {	
						// poner fecha inicial por defecto - 01-01-1900
						SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
						this.setFechaini(formatoDelTexto.parse("01-01-1900"));
				     } catch (Exception ex) {
				         ex.printStackTrace();
				     }
				}	
				ArrayList<ArrayList<Object>> res = null;
				if(this.filtroTipo==1) // generadores
					res = this.impdao.getConsultaGeneradores(this.filtroModelo, this.filtroNumserie,this.filtroNumSerieFin, null, this.fechaini, this.fechafin);
				else if(this.filtroTipo==2) // electrodos
					res = this.impdao.getConsultaElectrodos(this.filtroModelo, this.filtroNumserie,this.filtroNumSerieFin, null, this.fechaini, this.fechafin);
				else // registrador de eventos
					res = this.regdao.getConsultaRegEv(this.filtroModelo, this.filtroNumserie,this.filtroNumSerieFin, null, this.fechaini, this.fechafin);
				if(res!=null && res.size()>0)
					convierte(res,this.filtroTipo);
				else 
					this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_consulta"));
				logger.info("("+this.usuario+") Consulta de alertas de seguridad (Tipo de consulta: "+this.filtroTipo+")");
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_consulta")+": "+ e1.getMessage());
			logger.info("("+this.usuario+") Error en consulta de alertas de seguridad (Tipo de consulta: "+this.filtroTipo+"). Motivo: "+e1.getMessage(),e1);
		}
	}

	private boolean validarFiltros(){
		if(this.filtroTipo==null || this.filtroTipo<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("recall_consulta_tipo_warn"));
			return false;
		}
		if((this.filtroModelo==null || this.filtroModelo.equals("")) && (this.filtroNumserie==null || this.filtroNumserie.equals(""))){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("recall_consulta_modelonumserie_warn"));
			return false;
		}
		return true;
	}
	
	public void limpiar(ActionEvent e1){
		this.lista.clear();
		this.filtroModelo = null;
		this.filtroNumserie = null;
		this.filtroNumSerieFin = null;
		this.filtroTipo = 0;
		this.fechaini = null;
		this.fechafin = new Date();
		this.consultaRangos = false;
	}

	public void exportarDatos(ActionEvent e){
		try{
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_Recalls(this.lista);
			logger.info("("+this.usuario+") Exportación de alertas de seguridad desde consulta realizado con éxito");
		}catch(Exception e1){
			logger.error("No se puede generar exportación de datos de consulta de alertas de seguridad. Motivo: "+e1.getMessage(), e1);
			this.pintaMensaje(ERROR, this.bundle.getString("recall_msg_error_exporta_datos")+": "+e1.getMessage());
		}
	}
	
	private void convierte(ArrayList<ArrayList<Object>> res, int tipo){
		this.lista.clear();
		String modelo=null, modeloact = null, nserie=null, nserieact=null;
		Integer estado = null, caracter = null;
		
		if(tipo==1){ // GENERADORES
			for(int i=0;i<res.size();i++){
				modelo = (String)res.get(i).get(0);
				modeloact = (String)res.get(i).get(5);
				nserie = (String)res.get(i).get(1);
				nserieact = (String)res.get(i).get(6);
				if(modelo!=null && modeloact!=null && nserie!=null && nserieact!=null 
						&& modelo.equals(modeloact) && nserie.equals(nserieact))
					this.lista.add(new RecallDto((String)res.get(i).get(0), (String)res.get(i).get(1), (String)res.get(i).get(2),
							(Date)res.get(i).get(3),(String)res.get(i).get(4), (String)res.get(i).get(5), (String)res.get(i).get(6)));
			}
		}else if(tipo==2){ // ELECTRODOS
			// 1. Procesado previo de lista eliminando duplicados de modelo/num.serie para quedarnos con el último estado del material
			ArrayList<ArrayList<Object>> lista = podarLista(res);
			for(int i=0;i<lista.size();i++){
				estado = (Integer) lista.get(i).get(5);
				caracter = (Integer) lista.get(i).get(6);
				if(estado!=null && caracter!=null && ((estado==0 || estado == 1) || (estado==3 && caracter == 2)))
					this.lista.add(new RecallDto((String)lista.get(i).get(0), (String)lista.get(i).get(1), (String)lista.get(i).get(2),
							(Date)lista.get(i).get(3),(String)lista.get(i).get(4), (Integer) lista.get(i).get(5), (Integer) lista.get(i).get(6)));
			}
		}else{ //REGISTRADOR DE EVENTOS
			for(int i=0;i<res.size();i++){
				Date fecha_exp = (Date)res.get(i).get(3);
				if(fecha_exp==null)
					this.lista.add(new RecallDto((String)res.get(i).get(0), (String)res.get(i).get(1), (String)res.get(i).get(2),
							(Date)res.get(i).get(4),(String)res.get(i).get(5)));
			}
		}
	}
	
	private ArrayList<ArrayList<Object>> podarLista(ArrayList<ArrayList<Object>> in){
		ArrayList<ArrayList<Object>> res = new ArrayList<ArrayList<Object>>();
		String modelo = null, nserie = null;
		boolean existe = false;
		for(int i=0;i<in.size();i++){
			existe = false;
			modelo = (String)in.get(i).get(0);
			nserie = (String)in.get(i).get(1);
			for(int j=0;j<res.size();j++)
				if(modelo.equals((String)res.get(j).get(0)) && nserie.equals((String)res.get(j).get(1))){
					existe = true;
					break;
				}
			if(!existe)
				res.add(in.get(i));
		}
		return res;
	}
	
	/************************************
	 ********** GET / SET *************** 
	 ************************************/
	
	public ArrayList<RecallDto> getLista() {
		return lista;
	}

	public void setLista(ArrayList<RecallDto> lista) {
		this.lista = lista;
	}

	public String getFiltroModelo() {
		return filtroModelo;
	}

	public void setFiltroModelo(String filtroModelo) {
		this.filtroModelo = filtroModelo;
	}

	public String getFiltroNumserie() {
		return filtroNumserie;
	}

	public void setFiltroNumserie(String filtroNumserie) {
		this.filtroNumserie = filtroNumserie;
	}

	public Date getFechaini() {
		return fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public Integer getFiltroTipo() {
		return filtroTipo;
	}

	public void setFiltroTipo(Integer filtroTipo) {
		this.filtroTipo = filtroTipo;
	}

	public HtmlDataTable getBindingRecalls() {
		return bindingRecalls;
	}

	public void setBindingRecalls(HtmlDataTable bindingRecalls) {
		this.bindingRecalls = bindingRecalls;
	}

	public Integer getPagina_inicial() {
		return pagina_inicial;
	}

	public void setPagina_inicial(Integer pagina_inicial) {
		this.pagina_inicial = pagina_inicial;
	}

	public String getFiltroNumSerieFin() {
		return filtroNumSerieFin;
	}

	public void setFiltroNumSerieFin(String filtroNumSerieFin) {
		this.filtroNumSerieFin = filtroNumSerieFin;
	}

	public boolean isConsultaRangos() {
		return consultaRangos;
	}

	public void setConsultaRangos(boolean consultaRangos) {
		this.consultaRangos = consultaRangos;
	}
}

package com.sorin.idea.iu;

import hvn.cm.modelo.Mensaje;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;

import com.sorin.idea.dao.EpisodioDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.ProtocolosDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.TestOrtostatismoActivoDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.Protocolos;
import com.sorin.idea.dto.TestOrtostatismoActivo;
import com.sorin.idea.dto.TestOrtostatismoActivoPk;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ProtocolosDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.TestOrtostatismoActivoDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilMapeos;

public class ControlTestOrtostatismo extends BaseIU{

	private static Logger logger = Logger.getLogger(ControlSeguimientosClinicos.class);
	private LoginForm lf;
	private String usuario;
	
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private ControlPacientes cp;
	private ControlMaestras cm;
	
	private TestOrtostatismoActivoDao testdao;
	private TestOrtostatismoActivo test;
	private ArrayList<TestOrtostatismoActivo> lista;
	private HtmlDataTable bindingBuscar;
	
	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ProcedimientoDao procdao;
	
	private EpisodioDao epdao;
	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	private EventoDao evdao;
	private boolean editable;
	
	private ArrMaestras[] enfermeria;
	private ArrMaestras[] primerop;
	
	private String columna = "fecha";
	private boolean ascendente = false;
	
	private ProtocolosDao protdao;
	private ArrayList<Protocolos> listaprot;
	private HtmlDataTable bindingProt;
	
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
			this.setEditable(true);
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) 
				cp = new ControlPacientes();
			
			this.cargaMaestras();
			
			this.testdao = new TestOrtostatismoActivoDaoImpl(this.usuario);
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.setTest(new TestOrtostatismoActivo());
			this.test.setFecha(new Date());
			this.lista = new ArrayList<TestOrtostatismoActivo>();
			this.proc = new Procedimiento();
			this.proc.setFecha(new Date());
			this.protdao = new ProtocolosDaoImpl(this.usuario);
			this.listaprot = new ArrayList<Protocolos>();
			
			this.obtenerTestPaciente();
			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_pat")+": " + e1.getMessage());
		}
	}

	public void obtenerTestPaciente(){
		try{
			// Obtener historico de procedimientos y meterlos en la lista de historicos
			Procedimiento[] prs = this.procdao.findByDynamicWhere(
				"CODIGO =? AND TIPOPROCEDIMIENTO = ?", new Object[] {this.cp.getPacienteSelect().getCodigo(), 1092 });		
				if(prs.length>0){
					for(Procedimiento p:prs){
						TestOrtostatismoActivo test = this.testdao.findByPrimaryKey(p.getIdprocedimiento());
						this.lista.add(test);
					}	
			}	
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar lista de tests de ortostatismo de paciente.  Error: "+ e1.getMessage());
		}
	}
	
	public void cargaMaestras() {
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			this.enfermeria = cm.getEnfermeria();
			this.primerop = cm.getPrimerOperador();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
	}
	
	public void preguarda(ActionEvent e){
		try {
			Episodio[] lista_eps = this.epdao.getEpisodiosPaciente(this.cp.getPacienteSelect().getNhc());
			this.episodios = new ArrayList<EpisodioDto>();
			Evento ev = null;
			Procedimiento[] proc_ep = null;
			for(Episodio ep:lista_eps){
				// Consulta citas y adapta procedimiento
				// Solo carga episodios que tengan cita asociada con estado activo, relativas al tipo de procedimiento y no vinculadas a otro procedimiento
				ev = this.evdao.findByPrimaryKey(ep.getIdevento());
				proc_ep = this.procdao.findWhereIdepisodioEquals(ep.getIdepisodio());
				if(ev!=null && (ev.getProcedimiento()==1092) && ev.getEstado()==1 && proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));	
			}
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_epi")+": "+ e1.getMessage());
		}
	}
	
	public void guardar(ActionEvent e){
		try{
			if(validar()){
				if(this.test.getIdtest()!=null){ // UPDATE
					this.testdao.update(this.test.createPk(), this.test);
					this.proc.setFecha(this.test.getFecha());
					this.procdao.update(new ProcedimientoPk(this.proc.getIdprocedimiento(),this.proc.getTipoprocedimiento()), this.proc);
					this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
					logger.info("("+this.usuario+") Registro de test de ortostatismo activo actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				}else{ // INSERT
					TestOrtostatismoActivoPk testpk = this.testdao.insert(this.test);
					this.proc.setIdprocedimiento(testpk.getIdtest());
					this.proc.setTipoprocedimiento(1092);
					this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
					this.proc.setFecha(this.test.getFecha());
					this.procdao.insert(this.proc);
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
					logger.info("("+this.usuario+") Registro de test de ortostatismo activo insertado con éxito. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Error al guardar/actualizar procedimiento: " + e1.getMessage());
		}
	}
	
	public Integer guardar(TestOrtostatismoActivo test){
		try{
			if(test.getFecha()!=null){
				TestOrtostatismoActivoPk testpk = this.testdao.insert(test);
				Procedimiento proc = new Procedimiento();
				proc.setIdprocedimiento(testpk.getIdtest());
				proc.setTipoprocedimiento(1092);
				proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
				proc.setFecha(test.getFecha());
				this.procdao.insert(proc);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
				logger.info("("+this.usuario+") Registro de test de ortostatismo activo insertado con éxito. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				return testpk.getIdtest();
			}else
				this.pintaMensaje(ERROR, this.bundle.getString("test_orto_msg_warn_guarda_1"));
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Error al guardar procedimiento: " + e1.getMessage());
		}
		return null;
	}
	
	public void editar(TestOrtostatismoActivo test){
		try{
			if(test.getFecha()!=null){
				this.testdao.update(test.createPk(), test);
				Procedimiento proc = this.procdao.findByPrimaryKey(test.getIdtest(), 1092);
				proc.setFecha(test.getFecha());
				this.procdao.update(proc.createPk(), proc);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
				logger.info("("+this.usuario+") Registro de test de ortostatismo activo actualizado con éxito. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
			}else
				this.pintaMensaje(ERROR, this.bundle.getString("test_orto_msg_warn_guarda_1"));
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Error al actualizar procedimiento: " + e1.getMessage());
		}
	}
	
	public void eliminar(ActionEvent e){
		try{
			int auxproc = this.proc.getIdprocedimiento();
			// Delete oncascade - procedimiento -> situacion clinica
			this.testdao.delete(new TestOrtostatismoActivoPk(this.test.getIdtest()));
			this.procdao.delete(this.procpk);	
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Error al eliminar procedimiento: " + e1.getMessage());
		}
	}
	
	public TestOrtostatismoActivo obtenerTest(Integer idtest){
		try{
			TestOrtostatismoActivo test = this.testdao.findByPrimaryKey(idtest);
			this.calcularVariacionValoresConsulta(test);
			return test;
		}catch(Exception e1){
			return null;
		}
	}
	
	public void cargaTestOrtoProtocolo(Integer idproc) throws Exception{
		try {
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {idproc,1092})[0];
			this.procpk = this.proc.createPk();
			this.test = this.testdao.findByPrimaryKey(idproc);
			this.calcularVariacionValoresConsulta(this.test);
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro holter. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	
	public void imprimeInforme(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String jasper = "InformeTestOrtoActivo.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeTestOrto(cp.getPacienteSelect(), this.test, this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				this.nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: " + se.getMessage(),
						"Error generando documento,Motivo: " + se.getMessage());
			} catch (Exception e3) {
			}
		}
		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generación de informe (test Ortostatismo activo). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
	}
	
	public void cargaTestOrto(ActionEvent e) throws Exception {
		this.test = this.lista.get(this.getBindingBuscar().getRowIndex());
		this.calcularVariacionValores(null);
		//this.calcularVariacionTas(null);
		this.proc = this.procdao.findByPrimaryKey(this.test.getIdtest(),1092);
		this.procpk = this.proc.createPk();
		this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
	}

	public void cargaTestOrtoDesdeBarraTemporal(ActionEvent e) throws Exception{
		try {
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),cp.getTipoprocedimiento()})[0];
			this.procpk = this.proc.createPk();
			// 1. Recuperar objeto test
			this.test = this.testdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.calcularVariacionValores(null);
			//this.calcularVariacionTas(null);
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	
	public void cargaTestOrtoConsulta(ActionEvent e) throws Exception{
		try {
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.pacienteSelect.getIdtestorto(),1092})[0];
			this.procpk = this.proc.createPk();
			// 1. Recuperar objeto test
			this.test = this.testdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.calcularVariacionValores(null);
			//this.calcularVariacionTas(null);
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	
	public boolean validar(){
		if(this.test.getFecha()==null){
			this.pintaMensaje(ERROR, this.bundle.getString("test_orto_msg_warn_guarda_1"));
			return false;
		}
		return true;
	}
	
	public void calcularVariacionValores(ActionEvent e){
		try{
			boolean hta = (this.cp.getPacienteSelect().getSitclin().getHta()!=null && this.cp.getPacienteSelect().getSitclin().getHta().equals((short) 1))?true:false;
			if(this.test.getDecTad()!=null && UtilDatos.esNumero(this.test.getDecTad()) 
					&& this.test.getOrtTad()!=null && UtilDatos.esNumero(this.test.getOrtTad())){
				Double decTad = Double.parseDouble(this.test.getDecTad());
				Double ortTad = Double.parseDouble(this.test.getOrtTad());
				this.test.setVarTad(String.valueOf(decTad - ortTad));
				// Calculo de resultado
				this.test.setRes((decTad - ortTad>=10)?1:0);
			}
			if(this.test.getDecTas()!=null && UtilDatos.esNumero(this.test.getDecTas()) 
					&& this.test.getOrtTas()!=null && UtilDatos.esNumero(this.test.getOrtTas())){
				Double decTas = Double.parseDouble(this.test.getDecTas());
				Double ortTas = Double.parseDouble(this.test.getOrtTas());
				this.test.setVarTas(String.valueOf(decTas - ortTas));
				// Calculo de resultado
				if(hta)
					this.test.setRes((decTas - ortTas>=30)?1:this.test.getRes());
				else
					this.test.setRes((decTas - ortTas>=20)?1:this.test.getRes());
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("test_orto_msg_warn_calcula")+": "+ e1.getMessage());
		}
	}
	
	public void calcularVariacionValoresConsulta(TestOrtostatismoActivo test){
		try{
			boolean hta = (this.cp.getPacienteSelect().getSitclin().getHta()!=null && this.cp.getPacienteSelect().getSitclin().getHta().equals((short) 1))?true:false;
			if(test.getDecTad()!=null && UtilDatos.esNumero(test.getDecTad()) 
					&& test.getOrtTad()!=null && UtilDatos.esNumero(test.getOrtTad())){
				Double decTad = Double.parseDouble(test.getDecTad());
				Double ortTad = Double.parseDouble(test.getOrtTad());
				test.setVarTad(String.valueOf(decTad - ortTad));
				// Calculo de resultado
				test.setRes((decTad - ortTad>=10)?1:0);
			}
			if(test.getDecTas()!=null && UtilDatos.esNumero(test.getDecTas()) 
					&& test.getOrtTas()!=null && UtilDatos.esNumero(test.getOrtTas())){
				Double decTas = Double.parseDouble(test.getDecTas());
				Double ortTas = Double.parseDouble(test.getOrtTas());
				test.setVarTas(String.valueOf(decTas - ortTas));
				// Calculo de resultado
				if(hta)
					test.setRes((decTas - ortTas>=30)?1:test.getRes());
				else
					test.setRes((decTas - ortTas>=20)?1:test.getRes());
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("test_orto_msg_warn_calcula")+": "+ e1.getMessage());
		}
	}
	
	public void consultaProtocolos(ActionEvent e){
		try{
			Protocolos[] lista = this.protdao.findWhereCodigoEquals(this.cp.getPacienteSelect().getCodigo());
			this.listaprot.clear();
			for(Protocolos pr:lista)
				this.listaprot.add(pr);
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("prot_modal_msg_error_lista")+": " + e1.getMessage());
		}
	}
	
	public void vincularProtocolo(ActionEvent e){
		try{
			Integer iprt = this.bindingProt.getRowIndex();
			if(iprt != null && iprt >= 0){
				Protocolos prt = this.listaprot.get(iprt);
				ControlProtocolos cpr = (ControlProtocolos) getBean("controlProtocolos");
				int res = cpr.vincularProcedimientoProtocolo(this.proc, prt);
				if(res==0)
					this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("prot_sincope_msg_warn_vinc"));
				else if(res==1)
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("prot_sincope_msg_info_vinc"));
				else if(res==-1)
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_vinc"));
			}
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("prot_modal_msg_error_lista")+": " + e1.getMessage());
		}
	}
	
	public void irProtocolo(ActionEvent e){
		try{
			Integer iprt = this.bindingProt.getRowIndex();
			if(iprt != null && iprt >= 0){
				ControlProtocolos cpr = (ControlProtocolos) getBean("controlProtocolos");
				Protocolos prt = this.listaprot.get(iprt);
				cpr.cargaProtocolo(prt.getIdprotocolo());
			}
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("prot_sincope_msg_error_consulta_2")+": " + e1.getMessage());
		}
	}
	
	/***********************************************
	 ****************** GET / SET ****************** 
	 ***********************************************/
	
	public ArrayList<SelectItem> getPrimerOperador() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.primerop)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getEnfermeras() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.enfermeria)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getTipos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem("1", this.bundle.getString("prot_tipo_op1")));
		return diag;
	}
	
	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public TestOrtostatismoActivo getTest() {
		return test;
	}

	public void setTest(TestOrtostatismoActivo test) {
		this.test = test;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public boolean isAscendente() {
		return ascendente;
	}

	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}

	public ArrayList<TestOrtostatismoActivo> getLista() {
		return lista;
	}

	public void setLista(ArrayList<TestOrtostatismoActivo> lista) {
		this.lista = lista;
	}

	public HtmlDataTable getBindingBuscar() {
		return bindingBuscar;
	}

	public void setBindingBuscar(HtmlDataTable bindingBuscar) {
		this.bindingBuscar = bindingBuscar;
	}

	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public HtmlDataTable getBindingepi() {
		return bindingepi;
	}

	public void setBindingepi(HtmlDataTable bindingepi) {
		this.bindingepi = bindingepi;
	}

	public ArrayList<EpisodioDto> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(ArrayList<EpisodioDto> episodios) {
		this.episodios = episodios;
	}

	public ArrayList<Protocolos> getListaprot() {
		return listaprot;
	}

	public void setListaprot(ArrayList<Protocolos> listaprot) {
		this.listaprot = listaprot;
	}

	public HtmlDataTable getBindingProt() {
		return bindingProt;
	}

	public void setBindingProt(HtmlDataTable bindingProt) {
		this.bindingProt = bindingProt;
	}

}

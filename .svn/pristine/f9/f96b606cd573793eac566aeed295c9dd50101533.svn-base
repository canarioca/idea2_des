package com.sorin.idea.iu;

import hvn.cm.modelo.Mensaje;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jcifs.smb.SmbFile;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.sorin.idea.dao.EpisodioDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.HolterDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.ProtocolosDao;
import com.sorin.idea.dao.RegistradorEventosExtDao;
import com.sorin.idea.dao.SintomasSitclinProcDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Complicacion;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.Holter;
import com.sorin.idea.dto.HolterPk;
import com.sorin.idea.dto.ImpAtp;
import com.sorin.idea.dto.ImpAtpPk;
import com.sorin.idea.dto.ImpChoques;
import com.sorin.idea.dto.ImpChoquesPk;
import com.sorin.idea.dto.ImpEvolucionComplicacion;
import com.sorin.idea.dto.ImpEvolucionComplicacionPk;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.ImpHojaImplanteComplicacionPk;
import com.sorin.idea.dto.ImpHojaImplanteEnf;
import com.sorin.idea.dto.ImpHojaImplanteEnfPk;
import com.sorin.idea.dto.ImpHojaImplantePop;
import com.sorin.idea.dto.ImpHojaImplantePopPk;
import com.sorin.idea.dto.ImpHojaImplanteSop;
import com.sorin.idea.dto.ImpHojaImplanteSopPk;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpImplanteElectrodosPk;
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.ImpZonaPk;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.Protocolos;
import com.sorin.idea.dto.RegistradorEventosExt;
import com.sorin.idea.dto.RegistradorEventosExtPk;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SintomasSitclinProcPk;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.SituacionClinicaProcPk;
import com.sorin.idea.exceptions.HolterDaoException;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.exceptions.SituacionClinicaGeneralDaoException;
import com.sorin.idea.iu.gestor.GestorSmb;
import com.sorin.idea.iu.gestor.SmbDto;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.HolterDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ProtocolosDaoImpl;
import com.sorin.idea.jdbc.RegistradorEventosExtDaoImpl;
import com.sorin.idea.jdbc.SintomasSitclinProcDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilConversorTarjetaEuropea;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilFiles;
import com.sorin.idea.util.UtilMapeos;
import com.sorin.idea.util.UtilReporteInformes;

public class ControlRegEvExt extends BaseIU {

	private static Logger logger = Logger.getLogger(ControlRegEvExt.class);
	private LoginForm lf;
	private String usuario = "";
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private ControlPacientes cp;
	private ControlMaestras cm;
	private String DIR_PACIENTES;
	private String DIR_ESCUCHA_LECTURA_SD;
	private String DIR_ESCUCHA_LECTURA_SD_CLIENTE;
	private String DIR_ESCUCHA_ANALISIS;
	private String DIR_ESCUCHA_ANALISIS_CLIENTE;
	private String ESTACIONES_CLIENTE_LECTURA;
	private String ESTACIONES_CLIENTE;
	private String IP_ESTACION_CLIENTE;
	private Integer TIEMPO_CONSULTA = 59;
	private Properties prop;
	
	private RegistradorEventosExt regevext;
	private RegistradorEventosExtPk regevextpk;
	private RegistradorEventosExtDao regevextdao;
	private HtmlDataTable bindingRegEvExt;
	private HtmlDataTable bindingPdf;
	
	private SituacionClinicaProcDao sitclindao;
	private SituacionClinicaProc sitclin;
	private SituacionClinicaProcPk sitclinpk;
	private SintomasSitclinProcDao sintdao;
	private SituacionClinicaGeneral sgen;
	private boolean modsitclin;
	
	private HtmlDataTable bindingSintomas;
	
	private ArrMaestras[] referidores;
	private ArrMaestras[] enfermeria;
	private ArrMaestras[] enfermeria_todos;
	private ArrMaestras[] primerop;
	private ArrMaestras[] primerop_todos;
	private ArrMaestras[] segundoop;
	private ArrMaestras[] segundoop_todos;
	private ArrMaestras[] sintomas;
	private ArrMaestras[] etiologia;
	private ArrMaestras[] ritmos;
	private ArrMaestras[] ritmostv;
	private ArrMaestras[] ritmosfa;
	private ArrMaestras[] ritmossa;
	private ArrMaestras[] conducciones;
	private ArrMaestras[] conduccionavotros;
	private ArrMaestras[] qrs;
	private ArrMaestras[] qrsotros;
	private ArrMaestras[] cardiopatia;
	
	/**************************/
	private Procedimiento[] proclst;
	private ArrayList<Procedimiento> procs;
	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ProcedimientoDao procdao;
	private HtmlDataTable bindingBuscar;
	/**************************/
	private EpisodioDao epdao;
	private EventoDao evdao;
	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	/**************************/
	
	private boolean editable;
	private String selectedtab;
	private String columna = "fecha";
	private boolean ascendente = false;
	private InfoCentro infocentro;
	private int segundos;
	
	private ProtocolosDao protdao;
	private ArrayList<Protocolos> listaprot;
	private HtmlDataTable bindingProt;
	
	public void iniciaRegEvExt(ActionEvent e) {
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
			lecturaProperties();
			getInfoEstacionCliente();
			this.inicializaTiempo();
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (this.cm == null)
				this.cm = new ControlMaestras();
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			this.cargaMaestras();
			this.setEditable(true);
			this.setSelectedtab("tabIndicacionRegEvExt");// Seleccion de tab -> indicacion (en inserts)
			this.setRegevext(new RegistradorEventosExt());
			this.regevext.setEstado(100);
			this.regevext.setLecturasd(false);
			this.regevext.setFechacolocacion(new Date());
			this.regevextdao = new RegistradorEventosExtDaoImpl(this.usuario);
			
			this.setSitclin(new SituacionClinicaProc());
			this.sitclindao = new SituacionClinicaProcDaoImpl(this.usuario);
			this.sintdao = new SintomasSitclinProcDaoImpl(this.usuario);
			
			this.proc = new Procedimiento();
			this.proc.setFecha(new Date());
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.procpk = new ProcedimientoPk();
			this.setProcs(new ArrayList<Procedimiento>());
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			this.protdao = new ProtocolosDaoImpl(this.usuario);
			this.listaprot = new ArrayList<Protocolos>();
			
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_error_sel_pat"));
			}else{
				this.setProclst(this.procdao.findByDynamicWhere("CODIGO =? AND TIPOPROCEDIMIENTO = ?",
						new Object[] {this.cp.getPacienteSelect().getCodigo(),1091}));	
				for(Procedimiento p:this.proclst)
					this.procs.add(p);
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_rec_pat")+ e1.getMessage());
		}
	}

	public void iniciaRegEvExt2(ActionEvent e){
		this.iniciaRegEvExt(null);
		cargaSituacionClinica();
	}
	
	public void cargaMaestras() {
		try {
			this.referidores = cm.getReferidores();
			this.enfermeria = cm.getEnfermeria();
			this.enfermeria_todos = cm.getEnfermeriaTodos();
			this.primerop = cm.getPrimerOperador();
			this.primerop_todos = cm.getPrimerOperadorTodos();
			this.sintomas = cm.getSintomas();
			this.etiologia = cm.getEtiologia();
			this.ritmos = cm.getRitmoSinusal();
			this.ritmosfa = cm.getRitmosFA();
			this.ritmossa = cm.getRitmosSA();
			this.ritmostv = cm.getRitmosTV();
			this.conducciones = cm.getConduccionNoNormal();
			this.conduccionavotros = cm.getConduccionAVOtros();
			this.qrs = cm.getQrsNoNormal();
			this.qrsotros = cm.getQRSOtros();
			this.cardiopatia = cm.getCardiopatia();		
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_inicio_dmaestras")+ e1.getMessage());
		}
	}

	public void cargaRegEvExt(ActionEvent e) {
		try{
			this.proc = this.procs.get(this.bindingBuscar.getRowIndex());
			this.procpk = this.proc.createPk();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			cargaComponentes();
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			this.setSelectedtab(this.regevext.getEstado()>0?"tabAnalisisRegEvExt":"tabColocacionRegEvExt");// Seleccion de tab -> Analisis (en updates)
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_reg")+ e1.getMessage());
		}
	}

	public void cargaRegEvExtDesdeBarraTemporal(ActionEvent e) throws Exception{
		try {
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),cp.getTipoprocedimiento()})[0];
			this.procpk = this.proc.createPk();
			cargaComponentes();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			this.setSelectedtab(this.regevext.getEstado()>0?"tabAnalisisRegEvExt":"tabColocacionRegEvExt");// Seleccion de tab -> Analisis (en updates)
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro de registrador de eventos externo. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}

	public void cargaRegEvExtConsulta(ActionEvent e) throws Exception{
		try {
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.pacienteSelect.getIdregevext(),1091})[0];
			this.procpk = this.proc.createPk();
			cargaComponentes();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			this.setSelectedtab(this.regevext.getEstado()>0?"tabAnalisisRegEvExt":"tabColocacionRegEvExt");// Seleccion de tab -> Analisis (en updates)
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro de registrador de eventos externo. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	
	public void cargaRegEvExtProtocolo(Integer idproc) throws Exception{
		try {
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {idproc,1091})[0];
			this.procpk = this.proc.createPk();
			cargaSituacionClinica();
			cargaComponentes();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			this.setSelectedtab(this.regevext.getEstado()>0?"tabAnalisisRegEvExt":"tabColocacionRegEvExt");// Seleccion de tab -> Analisis (en updates)
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro de registrador de eventos externo. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	
	private void cargaComponentes() {
		try {
			// 1. Recuperar objeto registrador de eventos externo
			this.regevext = this.regevextdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.regevextpk = this.regevext.createPk();
			// 2. Recuperar SITCLIN
			this.sitclin = this.sitclindao.findByPrimaryKey(this.proc.getIdsitclinica());
			this.sitclinpk = this.sitclin.createPk();
			// 2.1 Sintomas
			SintomasSitclinProc[] sints = this.sintdao.findWhereIdsitclinEquals(this.proc.getIdsitclinica());
			ArrayList<SintomasSitclinProc> sintarray = new ArrayList<SintomasSitclinProc>();
			for (SintomasSitclinProc s : sints)
				sintarray.add(s);
			this.sitclin.setSintomas(sintarray);
			// 2.3 Precarga IC si existe
			this.sitclin.setIc(this.sitclin.getNyha()!=null?true:false);
			// 2.4 Cardiopatia
			this.sitclin.setCardiop(this.sitclin.getCardiopatia()!=null?true:false);
			// 2.4 Cardiopatia Revascularizacion
			this.sitclin.setRevascularizacion(this.sitclin.getRevasc()!= null&& this.sitclin.getRevasc()==1?true:false);
			// 2.5 Cardiopatia Infarto Previo
			this.sitclin.setInfartoprev(this.sitclin.getInfprevio()!=null&& this.sitclin.getInfprevio()==1?true:false);
			// 2.6 Antecedentes - Arritmias Ventriculares
			this.sitclin.setAvent(this.sitclin.getArritmias()!=null&&this.sitclin.getArritmias()>=1?true:false);
			// 2.7 Antecedentes - EEF Previo
			this.sitclin.setEefprev(this.sitclin.getEef()!=null&& this.sitclin.getEef()>=1?true:false);
			// 2.8 Antecedentes booleanos
			cargaAntecedentes();
			// 3. Lectura previa
			this.regevext.setLecturasd(this.regevext.getEstado()!=null && this.regevext.getEstado()>0 && this.regevext.getEstado()!=100?false:true);
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+ e.getMessage());
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
				// Solo carga episodios que tengan cita asociada con estado activo y realtivas al tipo de procedimiento
				ev = this.evdao.findByPrimaryKey(ep.getIdevento());
				proc_ep = this.procdao.findWhereIdepisodioEquals(ep.getIdepisodio());
				if(ev!=null && ev.getProcedimiento()==1091 && ev.getEstado()==1 && proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));
			}
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_epi")+": " + e1.getMessage());
		}
	}
	
	public void guarda(ActionEvent e){
		try{
			Integer epi = this.bindingepi.getRowIndex();
			if(epi != null && epi >= 0){
				this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());
				this.regevext.setIdentevento(this.episodios.get(epi).getIdentev()); // TODO - REVISAR PROCESOS DE INTEGRACION
			}	
			if (this.procpk!=null && this.proc.getIdprocedimiento()!=null) {				
				this.sitclindao.update(this.sitclinpk, this.sitclin);
				guardaComponentesSitclin();
				modificaSituacionClinicaGeneral();
				
				this.regevextdao.update(this.regevextpk, this.regevext);
				this.procdao.update(this.procpk, this.proc);
				
				this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
				logger.info("("+this.usuario+") Registro de registrador de eventos externo actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
			}else{
				// REG. EV. EXT - se crea primero la entrada al DIRECTORIO DE PACIENTES
				this.sitclinpk = this.sitclindao.insert(this.sitclin);
				
				guardaComponentesSitclin();
				modificaSituacionClinicaGeneral();
				this.regevext.setEstado(100);// pendiente de lectura - colocado
				this.regevextpk = this.regevextdao.insert(this.regevext);
				this.regevext.setIdevento(regevextpk.getIdevento());
				
				this.proc.setIdsitclinica(this.sitclinpk.getIdsitclin());
				this.proc.setIdprocedimiento(regevextpk.getIdevento());
				this.proc.setTipoprocedimiento(1091);
				this.proc.setFecha(this.regevext.getFechacolocacion());
				this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
				
				this.procpk = this.procdao.insert(this.proc);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
				logger.info("("+this.usuario+") Registro de registrador de eventos externo insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				if(crearEntradaRepoPacientes()){
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("holter24h_msg_info_creacion_dirpat"));
					logger.info("("+this.usuario+") Entrada en DIRECTORIO DE PACIENTES creada con exito. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				}else{
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("holter24h_msg_error_creacion_dirpat"));
					logger.error("("+this.usuario+") No se puede crear entrada en DIRECTORIO DE PACIENTES. Registro de registrador de eventos externo no insertado. Motivo: no se puede acceder a DIRECTORIO DE PACIENTES");
					this.eliminar(null);// ROLLBACK - SE BORRA REGISTRO HOLTER INSERTADO PREVIAMENTE
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido guardar el registro de registrador de eventos externo. Motivo: " + e1.getMessage(),e1);
		}
	}
	
	private void guardaComponentesSitclin() throws Exception {
		sintdao.delete(new SintomasSitclinProcPk(this.sitclin.getIdsitclin(), null));
		for (SintomasSitclinProc sint : this.sitclin.getSintomas()) {
			if (sint.getIdsintomas()!=null && sint.getIdsintomas().length()>0) {
				sint.setIdsitclin(this.sitclin.getIdsitclin());
				sintdao.insert(sint);
			}
		}
	}
	
	public boolean crearEntradaRepoPacientes(){
		File repo = new File(DIR_PACIENTES);
		if(repo!=null && repo.exists() && repo.isDirectory()){
			// INSERCION DE ENTRADA EN REPOSITORIO DE PACIENTES
			UtilFiles.crearDirectorio(DIR_PACIENTES+"/"+this.cp.pacienteSelect.getCodigo()+"/"+this.regevextpk.getIdevento());
			// comprobacion de escritura
			File f = new File(DIR_PACIENTES+"/"+this.cp.pacienteSelect.getCodigo()+"/"+this.regevextpk.getIdevento());
			return f.exists();
		}else{
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("holter24h_msg_error_creacion_dirpat_1"));
			return false;
		}
	}
	
	public void eliminar(ActionEvent e){
		int auxproc = this.proc.getIdprocedimiento();
		try{
			// Borra datos de repositorio de pacientes - VERIFICAR 
			//File f = new File(DIR_PACIENTES+"/"+this.cp.pacienteSelect.getCodigo()+"/"+this.regevextpk.getIdevento());
			//f.delete();
			this.sintdao.delete(new SintomasSitclinProcPk(this.sitclin.getIdsitclin(), null));
			this.regevextdao.delete(this.regevextpk);
			this.sintdao.delete(new SintomasSitclinProcPk(this.sitclin.getIdsitclin(), null));
			this.sitclindao.delete(this.sitclin.createPk());
			this.procdao.delete(this.procpk);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro de registrador de eventos externo eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_borrado_error_exep")+":  "+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido eliminar el registro:  Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
		}
	}
	
	public void eliminarHisto(ActionEvent e){
		this.proc = this.procs.get(this.bindingBuscar.getRowIndex());
		try{
			this.sitclin = this.sitclindao.findByPrimaryKey(this.proc.getIdsitclinica());
			
			this.sintdao.delete(new SintomasSitclinProcPk(this.sitclin.getIdsitclin(), null));
			this.regevext = this.regevextdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.regevextdao.delete(this.regevext.createPk());
			this.sintdao.delete(new SintomasSitclinProcPk(this.sitclin.getIdsitclin(), null));
			this.sitclindao.delete(this.sitclin.createPk());
			this.procdao.delete(this.proc.createPk());
			this.iniciaRegEvExt(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro de registrador de eventos externo eliminado con éxito. Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_borrado_error_exep")+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido eliminar el registro: Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
		}
	}
	
	public void limpia(ActionEvent e){
		
	}
	
	public void imprimeInforme(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String jasper = "InformeRegEvExt.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeRegExExt(this.cp.pacienteSelect, this.sitclin, this.regevext,this.infocentro,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_impr_gen_doc")+": " + se.getMessage());	
			} catch (Exception e3) {
			}
		}
		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generación de informe (ELR). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + se.getMessage());
			} catch (Exception e2) {
			}
		}
	}

	public void imprimeInformeUnificado(ActionEvent e){
		File fProc = null;
		File fAnalisis = null;
		File copiaFAnalisis = null;
		ArrayList<File> lista = new ArrayList<File>();
		try{
			// 0. Contexto
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
			ServletOutputStream servletOutputStream = response.getOutputStream();
			
			File dirRepo = new File(DIR_PACIENTES+"/"+cp.getPacienteSelect().getCodigo()+"/"+this.regevext.getIdevento());
			// 1. Genera informe de procedimiento
			String pathProc = this.printInforme(null);
			if(pathProc!=null && !pathProc.equals("")){
				fProc = new File(pathProc);
				if(fProc!=null)
					lista.add(fProc);
			}
			// 2. Consulta presencia de informe PDF adjunto
			if(this.regevext.getEstado().equals(3)){ // Estado: Analisis final + informe asociado
				if(compruebaInformePdf()){// Verifica presencia de informe en REPOSITORIO DE PACIENTES
					fAnalisis = this.obtenerInformeAdjunto(dirRepo);
					if(fAnalisis!=null){
						copiaFAnalisis = UtilFiles.copiarInformeAdjunto(dirRepo, req.getRealPath("/reportes/"+req.getRequestedSessionId()+"_"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMddHHmmss")+"_"+fAnalisis.getName()));
						if(copiaFAnalisis!=null)
							lista.add(copiaFAnalisis);
					}	
				}	
			}
			// 3. Merge PDF
			File fMerge = null;
			if(lista.size()>0){
				String nombreFichMerge = req.getRealPath("/reportes/") ;
				fMerge = UtilFiles.mergePDF(lista, req.getRealPath("/reportes/"), req.getRequestedSessionId()+"_"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMddHHmmss")+"_InformeHolter24h.pdf");
			}
			// 4. Descarga
			if(fMerge!=null){
				byte[] descarga = UtilFiles.read(fMerge);
				response.setContentType("application/pdf");
				response.setContentLength(descarga.length);
				response.setHeader("Content-Transfer-Enconding", "binary");
				response.setHeader("Content-disposition", "inline; filename=\"" + fMerge.getName() + "\"");

				servletOutputStream.write(descarga);

				// esta sentencia es extremadamente importante de cara a conseguir que se pueda abrir el archivo
				FacesContext.getCurrentInstance().responseComplete();
			}else{
				this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_merge_file"));
			}
			if(fProc.exists())
				fProc.delete();
			if(copiaFAnalisis.exists())
				copiaFAnalisis.delete();
			if(fMerge.exists())
				fMerge.delete();
		}catch(Exception e1){
			this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + e1.getMessage());
		}
	}

	public String printInforme(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		String path = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String jasper = "InformeRegEvExt.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeRegExExt(this.cp.pacienteSelect, this.sitclin, this.regevext,this.infocentro,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_impr_gen_doc")+": " + se.getMessage());	
			} catch (Exception e3) {
			}
		}
		try {
			path = constructorPDF.generarArchivoPdfFile(FacesContext.getCurrentInstance(),PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generación de informe (ELR). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + se.getMessage());
			} catch (Exception e2) {
			}
		}
		return path;
	}

	public void colocaHolter(ActionEvent e){
		try {
			File f1 = new File(DIR_ESCUCHA_LECTURA_SD_CLIENTE);
			if(f1.exists()){
				// Generacion de TOKEN
				String idevento = "10";// TODO ESTO ES EN PRUEBAS
				String contenido = cp.getPacienteSelect().getCodigo()+"_"+idevento+"_"+cp.getPacienteSelect().getNhc();
				// FORMATO NOMENCLATURA TOKEN: IDEA_IDPACIENTE_IDHOLTER_NHC_TS.txt
				String token = "IDEA_"+cp.getPacienteSelect().getCodigo()+"_"+this.regevext.getIdevento()
						+"_"+cp.getPacienteSelect().getNhc()+"_"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMddHHmmss")+"_0.txt";
				// Borrar directorio de escucha activa DEASECOPE para inicializacion de proceso
				UtilFiles.borrarFiles(new File(DIR_ESCUCHA_LECTURA_SD_CLIENTE));
				// Mover TOKEN a directorio de escucha activa SyneCOM
				UtilFiles.write2File(contenido, DIR_ESCUCHA_LECTURA_SD_CLIENTE+"/"+token);
				File f = new File(DIR_ESCUCHA_LECTURA_SD_CLIENTE+"/"+token);
				if(f.exists()){
					// Actualizacion de estado de registro de holter
					this.regevext.setEstado(0);// Colocado - pendiente de lectura
					this.regevext.setLecturasd(true); // Habilita boton de lectura
					this.regevextdao.update(this.regevextpk, this.regevext);
					logger.info("("+this.usuario+") Colocacion de registro registrador de eventos externo realizada con éxito. IdRegEvExt: "+this.proc.getIdprocedimiento());
					this.pintaMensaje(INFO, this.bundle.getString("holter24h_msg_info_lectura"));
					this.pintaMensaje(AVISO, this.bundle.getString("holter24h_msg_warn_lectura"));
				}else{
					this.regevext.setEstado(-2);// Erroneo. No se puede escribir en directorio de escucha SD
					this.regevextdao.update(this.regevext.createPk(), this.regevext);
					logger.error("("+this.usuario+") Error de lectura de registro registrador de eventos externo. IdRegEvExt: "+this.proc.getIdprocedimiento()+". Error de escritura de TOKEN en directorio escucha de lectura");
					this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_lectura_e2"));
					this.pintaMensaje(ERROR, this.bundle.getString("contacte_admin"));
				}	
			}else{
				this.regevext.setEstado(-1);// Erroneo. No existe directorio de escucha
				this.regevextdao.update(this.regevext.createPk(), this.regevext);
				logger.error("("+this.usuario+") Error de colocacion de registro registrador de eventos externo. IdRegEvExt: "+this.proc.getIdprocedimiento()+". No existe directorio de escucha de lectura");
				this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_lectura_e1"));
				this.pintaMensaje(ERROR, this.bundle.getString("contacte_admin"));
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("holter24h_msg_error_lectura_exepc")+":  "+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido realizar colocacion de holter. Motivo: "+ e1.getMessage());
		}
	}
	
	public void lecturaHolter(ActionEvent e){
		try {
			File f1 = new File(DIR_ESCUCHA_LECTURA_SD_CLIENTE);
			if(f1.exists()){
				// Generacion de TOKEN
				String idevento = "10";// TODO ESTO ES EN PRUEBAS
				String contenido = cp.getPacienteSelect().getCodigo()+"_"+idevento+"_"+cp.getPacienteSelect().getNhc();
				// FORMATO NOMENCLATURA TOKEN: IDEA_IDPACIENTE_IDHOLTER_NHC_TS.txt
				String token = "IDEA_"+cp.getPacienteSelect().getCodigo()+"_"+this.regevext.getIdevento()
						+"_"+cp.getPacienteSelect().getNhc()+"_"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMddHHmmss")+"_1.txt";
				// Borrar directorio de escucha activa SyneCOM para inicializacion de proceso
				UtilFiles.borrarFiles(new File(DIR_ESCUCHA_LECTURA_SD_CLIENTE));
				// Borrar contenido completo del registro de holter en REPOSITORIO PACIENTES para hacer lectura limpia
				UtilFiles.borrarFiles(new File(DIR_PACIENTES+"/"+this.cp.getPacienteSelect().getCodigo()+"/"+this.regevext.getIdevento()));
				// Mover TOKEN a directorio de escucha activa SyneCOM
				UtilFiles.write2File(contenido, DIR_ESCUCHA_LECTURA_SD_CLIENTE+"/"+token);
				File f = new File(DIR_ESCUCHA_LECTURA_SD_CLIENTE+"/"+token);
				if(f.exists()){
					// Actualizacion de estado de registro de holter
					this.regevext.setFechalectura(new Date());
					this.regevext.setEstado(1);// Leido
					this.regevextdao.update(this.regevext.createPk(), this.regevext);
					this.setSelectedtab("tabAnalisisRegEvExt");// Seleccion de tab -> pasa a análisis
					this.regevext.setLecturasd(false); // Deshabilita boton de lectura
					logger.info("("+this.usuario+") Lectura de registro registrador de eventos externo realizada con éxito. IdRegEvExt: "+this.proc.getIdprocedimiento());
					this.pintaMensaje(INFO, this.bundle.getString("holter24h_msg_info_lectura"));
					this.pintaMensaje(AVISO, this.bundle.getString("holter24h_msg_warn_lectura"));
				}else{
					this.regevext.setEstado(-2);// Erroneo. No se puede escribir en directorio de escucha SD
					this.regevextdao.update(this.regevext.createPk(), this.regevext);
					logger.error("("+this.usuario+") Error de lectura de registro registrador de eventos externo. IdRegEvExt: "+this.proc.getIdprocedimiento()+". Error de escritura de TOKEN en directorio escucha de lectura");
					this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_lectura_e2"));
					this.pintaMensaje(ERROR, this.bundle.getString("contacte_admin"));
				}	
			}else{
				this.regevext.setEstado(-1);// Erroneo. No existe directorio de escucha
				this.regevextdao.update(this.regevext.createPk(), this.regevext);
				logger.error("("+this.usuario+") Error de lectura de registro registrador de eventos externo. IdRegEvExt: "+this.proc.getIdprocedimiento()+". No existe directorio de escucha de lectura");
				this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_lectura_e1"));
				this.pintaMensaje(ERROR, this.bundle.getString("contacte_admin"));
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("holter24h_msg_error_lectura_exepc")+":  "+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido realizar lectura de holter. Motivo: "+ e1.getMessage());
		}
	}
	
	public void analisisHolter(ActionEvent e){
		try {
			File f1 = new File(DIR_ESCUCHA_ANALISIS_CLIENTE);
			if(f1.exists()){
				// Generacion de TOKEN
				String idevento = "10";// TODO ESTO ES EN PRUEBAS
				String contenido = cp.getPacienteSelect().getCodigo()+"_"+idevento+"_"+cp.getPacienteSelect().getNhc();		
				// Mover contenido de tarjeta almacenado en repositorio de pacientes hacia directorio de escucha activa EventScope
				// Busqueda de datos de tarjeta de repositorio de pacientes asociado al registro a analizar
				String path_repo = DIR_PACIENTES+"/"+cp.getPacienteSelect().getCodigo()+"/"+this.regevext.getIdevento();
				File dir_repo_pat = new File(DIR_PACIENTES+"/"+cp.getPacienteSelect().getCodigo()+"/"+this.regevext.getIdevento());
				if(dir_repo_pat.exists() && dir_repo_pat.isDirectory()){
					// Obtener nombre de directorio asociado
					String sds = UtilFiles.obtenerDirectorioRegEvExt(dir_repo_pat);
					if(sds!=null){
						// Se asumirá que solo hay un directorio por registro asociado
						// FORMATO NOMENCLATURA TOKEN: IDEA_IDPACIENTE_IDEVENTO_NHC.txt
						String token = "IDEA_"+cp.getPacienteSelect().getCodigo()+"_"+this.regevext.getIdevento()
								+"_"+cp.getPacienteSelect().getNhc()+"_"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMddHHmmss")+"_2.txt";						
						// Borrar directorio de escucha activa SyneSCOPE para inicializacion de proceso
						UtilFiles.borrarFiles(new File(DIR_ESCUCHA_ANALISIS_CLIENTE));
						if(UtilFiles.moverDirectorioLectura(path_repo+"/"+sds, DIR_ESCUCHA_ANALISIS_CLIENTE+"/"+sds)){														
							// Mover TOKEN a directorio de escucha activa SyneSCOPE
							UtilFiles.write2File(contenido, DIR_ESCUCHA_ANALISIS_CLIENTE+"/"+token);
							File f_token = new File(DIR_ESCUCHA_ANALISIS_CLIENTE+"/"+token);
							if(f_token.exists()){
								this.regevext.setFechanalisis(new Date());
								this.regevext.setEstado(2);// En analisis en SyneScope
								this.regevextdao.update(this.regevext.createPk(), this.regevext);
								
								logger.info("("+this.usuario+") Solicitud de análisis de registro registrador de eventos externo realizada con éxito. IdRegEvExt: "+this.proc.getIdprocedimiento());
								this.pintaMensaje(INFO, this.bundle.getString("holter24h_msg_info_analisis"));
								this.pintaMensaje(AVISO, this.bundle.getString("holter24h_msg_warn_analisis"));
							}else{
								this.regevext.setFechanalisis(new Date());
								this.regevext.setEstado(-7);// Error de escritura de token
								this.regevextdao.update(this.regevext.createPk(), this.regevext);
								
								logger.error("("+this.usuario+") Error de analisis de registro de grabadora externa de eventos. IdHolter: "+this.proc.getIdprocedimiento()+". Error de generacion de TOKEN asociado a registro registrador de eventos externo.");
								this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_analisis_e7"));
								this.pintaMensaje(ERROR, this.bundle.getString("contacte_admin"));
							}
						}else{						
							this.regevext.setFechanalisis(new Date());
							this.regevext.setEstado(-4);// Error de traslado de ficheros hacia directorio EventSCOPE
							this.regevextdao.update(this.regevext.createPk(), this.regevext);
							logger.error("("+this.usuario+") Error de analisis de registro de grabadora externa de eventos. IdRegEvExt: "+this.proc.getIdprocedimiento()+". Error de traslado de ficheros de registro hacia EventScope.");
							this.pintaMensaje(ERROR, this.bundle.getString("regevext_msg_error_analisis_e4"));
							this.pintaMensaje(ERROR, this.bundle.getString("contacte_admin"));
						}
					}else{
						this.regevext.setEstado(-6);// Error de obtencion de directorio repositorio de pacientes. No hay contenidos de tarjetas asociados
						this.regevextdao.update(this.regevext.createPk(), this.regevext);
						logger.error("("+this.usuario+") Error de analisis de registro de grabadora externa de eventos. IdRegEvExt: "+this.proc.getIdprocedimiento()+". No hay contenidos de tarjetas asociados al registro.");
						this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_analisis_e6"));
						this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_analisis_e6_1"));
					}
				}else{
					this.regevext.setEstado(-5);// Error de obtencion de directorio repositorio de pacientes. No existe asociado
					this.regevextdao.update(this.regevext.createPk(), this.regevext);
					logger.error("("+this.usuario+") Error de analisis de registro de grabadora externa de eventos. IdRegEvExt: "+this.proc.getIdprocedimiento()+". No existe directorio asociado a registro de grabadora externa de eventos en repositorio de pacientes");
					this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_analisis_e5"));
					this.pintaMensaje(ERROR, this.bundle.getString("contacte_admin"));
				}
			}else{
				this.regevext.setEstado(-3);// Erroneo. No existe directorio de escucha
				this.regevextdao.update(this.regevext.createPk(), this.regevext);
				logger.error("("+this.usuario+") Error de analisis de registro registrador de eventos externo. IdRegEvExt: "+this.proc.getIdprocedimiento()+". No existe directorio de escucha de análisis");
				this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_analisis_e3"));
				this.pintaMensaje(ERROR, this.bundle.getString("contacte_admin"));
			}
			
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("holter24h_msg_error_lectura_exepc")+":  "+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido realizar analisis de registrador de eventos externo. Motivo: "+ e1.getMessage(),e1);
		}
	}
	
	public void verificaInfoRepositorio(ActionEvent e){
		try{
			File dir_repo_pat = new File(DIR_PACIENTES+"/"+cp.getPacienteSelect().getCodigo()+"/"+this.regevext.getIdevento());
			if(dir_repo_pat.exists()){
				this.pintaMensaje(INFO, this.bundle.getString("holter24h_verifica_info_repo_ok"));
				logger.info("("+this.usuario+") Solicitud de verificación de registro registrador de eventos externo realizada con éxito. IdRegEvExt: "+this.proc.getIdprocedimiento());
			}else{
				this.pintaMensaje(ERROR, this.bundle.getString("holter24h_verifica_info_repo_ko"));
				logger.error("("+this.usuario+") Solicitud de verificación de registro registrador de eventos externo errónea. No existe contenido de tarjeta asociado en repositorio. IdRegEvExt: "+this.proc.getIdprocedimiento());
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("holter24h_msg_error_creacion_dirpat_1")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Solicitud de verificación de registro registrador de eventos externo erróneo. No existe conectividad con repositorio de pacientes. Motivo: "+ e1.getMessage(),e1);
		}
	}
	
	public void integra(ActionEvent e){
		// TODO - PENDIENTE DE NECESIDADES DE CADA CENTRO
	}
	/**
	 * Descarga en una pestaña adicional el informe generado en REPOSITORIO PACIENTES
	 * @param e
	 */
	public void descargar(ActionEvent e){
		try{			
			// CASO DIR PACIENTES LOCAL - CONEXION DIRECTA FILE
			File dir_repo_pat = new File(DIR_PACIENTES+"/"+cp.getPacienteSelect().getCodigo()+"/"+this.regevext.getIdevento());
			if(dir_repo_pat.exists() && dir_repo_pat.isDirectory()){
				File f = obtenerInformeAdjunto(dir_repo_pat);
				if(f!=null && f.exists()){
					ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
					HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
					HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
					String sesionID = req.getRequestedSessionId();
					
					ServletOutputStream servletOutputStream = response.getOutputStream();
					
					// CASO DIR PACIENTES LOCAL
					byte[] descarga = UtilFiles.read(f);
					
					response.setContentType("application/pdf");
					response.setContentLength(descarga.length);
					response.setHeader("Content-Transfer-Enconding", "binary");
					response.setHeader("Content-disposition", "inline; filename=\""+f.getName()+"\"");

					servletOutputStream.write(descarga);

					// Esta sentencia es extremadamente importante de cara a conseguir que se pueda abrir el archivo
					FacesContext.getCurrentInstance().responseComplete();
					logger.info("("+this.usuario+") Descarga de informe adjunto de registro de registrador de eventos externo en ubicación local. IdHolter: "+this.regevext.getIdevento());
				}else
					this.pintaMensaje(AVISO, "No hay informes adjuntos para este registro.");
				
				
			// CASO DIR PACIENTES EN RED - CONECTOR SAMBA
			/*GestorSmb gsmb = new GestorSmb();
			ArrayList<SmbDto> filesSmb = gsmb.getFilesFromDir("pacientes/"+cp.getPacienteSelect().getCodigo()+"/"+this.regevext.getIdevento(),"PDF");
			if(filesSmb!=null){
				if(filesSmb.size()>0){
					ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
					HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
					HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
					String sesionID = req.getRequestedSessionId();
					
					ServletOutputStream servletOutputStream = response.getOutputStream();
					
					byte[] descarga = UtilFiles.obtenerContenido(filesSmb.get(0).getsFile());						
					
					response.setContentType("application/pdf");
					response.setContentLength(descarga.length);
					response.setHeader("Content-Transfer-Enconding", "binary");
					response.setHeader("Content-disposition", "inline; filename=\""+filesSmb.get(0).getsFile().getName()+"\"");
					
					servletOutputStream.write(descarga);

					// Esta sentencia es extremadamente importante de cara a conseguir que se pueda abrir el archivo
					FacesContext.getCurrentInstance().responseComplete();
					logger.info("("+this.usuario+") Descarga de informe adjunto de registro de registrador de eventos externo en ubicación local. IdRegEvExt: "+this.regevext.getIdevento());
				}else
					this.pintaMensaje(AVISO, this.bundle.getString("holter24h_msg_error_desc_nodata"));
				*/	
			}else{
				this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_desc_1"));
				logger.error("("+this.usuario+") No se puede acceder a directorio de pacientes. Motivo: Error de lectura o no existencia del mismo");
			}	
		}catch(Exception e1){
			this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_desc_excep")+": "+e1.getMessage());
			logger.error("("+this.usuario+") Error al descargar informe adjunto de registro de registrador de eventos externo. Motivo: "+e1.getMessage(),e1);
		}
	}
	
	private File obtenerInformeAdjunto(File dir_repo){
		for(File f:dir_repo.listFiles())
			if(f.getName().toUpperCase().endsWith("PDF"))
				return f;
		return null;
	}
	
	public boolean compruebaInformePdf(){
		try{			
			// CASO DIR PACIENTES LOCAL - CONEXION DIRECTA FILE
			File dir_repo_pat = new File(DIR_PACIENTES+"/"+cp.getPacienteSelect().getCodigo()+"/"+this.regevext.getIdevento());
			if(dir_repo_pat.exists() && dir_repo_pat.isDirectory()){
				File f = obtenerInformeAdjunto(dir_repo_pat);
				if(f!=null && f.exists()){
					return true;
				}else
					return false;
			}else{
				this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_desc_pdf"));
				return false;
			}
				
			/*// CASO DIR PACIENTES EN RED - CONECTOR SAMBA
			GestorSmb gsmb = new GestorSmb();
			ArrayList<SmbDto> filesSmb = gsmb.getFilesFromDir("pacientes/"+cp.getPacienteSelect().getCodigo()+"/"+this.holter.getIdholter(),"PDF");
			if(filesSmb!=null){
				if(filesSmb.size()>0){
					return true;
				}else
					return false;	
			}else{
				this.pintaMensaje(ERROR, "No se puede acceder a directorio de pacientes. Motivo: Error de lectura o no existencia del mismo");
				return false;
			}*/
		}catch(Exception e1){
			this.pintaMensaje(ERROR, this.bundle.getString("holter24h_msg_error_desc_pdf_1")+": "+e1.getMessage());
			return false;
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
	
	public void addSintoma(ActionEvent e) {
		this.sitclin.getSintomas().add(new SintomasSitclinProc());
	}

	public void delSintoma(ActionEvent e) {
		this.sitclin.getSintomas().remove(this.bindingSintomas.getRowIndex());
	}
	
	public void controlSintomas(ActionEvent e){
		int dup=0;
		for(SintomasSitclinProc s:this.sitclin.getSintomas()){
			if(s.getIdsintomas()!=null && s.getIdsintomas().equals(this.sitclin.getSintomas().get(this.bindingSintomas.getRowIndex()).getIdsintomas()))
				dup++;						
			if(dup>1){
				// Duplicado
				this.sitclin.getSintomas().remove(this.bindingSintomas.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sitclin_sintoma_dup"));
				break;
			}
		}
	}
	
	private void cargaAntecedentes() {
		this.sitclin.setAnteinsrenal((this.sitclin.getInsrenal() != null)
				&& (this.sitclin.getInsrenal() == 1) ? true : false);
		this.sitclin.setAntefa((this.sitclin.getAntfa() != null)
				&& (this.sitclin.getAntfa() == 1) ? true : false);
		this.sitclin.setAntediab((this.sitclin.getDiabetes() != null)
				&& (this.sitclin.getDiabetes() == 1) ? true : false);
		this.sitclin.setAntehipertens((this.sitclin.getHipertension() != null)
				&& (this.sitclin.getHipertension() == 1) ? true : false);
		this.sitclin.setAnteHTA((this.sitclin.getHta() != null)
				&& (this.sitclin.getHta() == 1) ? true : false);
		this.sitclin.setAntefam((this.sitclin.getMuertesubita() != null)
				&& (this.sitclin.getMuertesubita() == 1) ? true : false);
		this.sitclin.setAntetabaq((this.sitclin.getTabaquismo() != null)
				&& (this.sitclin.getTabaquismo() == 1) ? true : false);
		this.sitclin.setAntehipercol((this.sitclin.getHipercolest() != null)
				&& (this.sitclin.getHipercolest() == 1) ? true : false);
		this.sitclin.setAnteacv((this.sitclin.getAcv() != null)
				&& (this.sitclin.getAcv() == 1) ? true : false);
		this.sitclin.setAnteTrasplanteCardiaco((this.sitclin.getTrasplantecardiaco() != null)
				&& (this.sitclin.getTrasplantecardiaco() == 1) ? true : false);
		this.sitclin.setAnteAIT((this.sitclin.getAit() != null)
				&& (this.sitclin.getAit() == 1) ? true : false);
		this.sitclin.setAnteEPOC((this.sitclin.getEpoc() != null)
				&& (this.sitclin.getEpoc() == 1) ? true : false);
		this.sitclin.setAnteSAHS((this.sitclin.getSahs() != null)
				&& (this.sitclin.getSahs() == 1) ? true : false);
		this.sitclin.setAnteCPAP((this.sitclin.getCpap() != null)
				&& (this.sitclin.getCpap() == 1) ? true : false);
		this.sitclin.setAnteNeoplasia((this.sitclin.getNeoplasia() != null)
				&& (this.sitclin.getNeoplasia() == 1) ? true : false);	
		this.sitclin.setAnteSincope((this.sitclin.getSincope() != null)
				&& (this.sitclin.getSincope() == 1) ? true : false);
		this.sitclin.setAnteParadaCardiaca((this.sitclin.getParadacardiaca() != null)
				&& (this.sitclin.getParadacardiaca() == 1) ? true : false);
		this.sitclin.setEnfarterios((this.sitclin.getEnfart()!=null)&&(this.sitclin.getEnfart()==1) ? true:false);
		this.sitclin.setAnteflutter(this.sitclin.getFlutter()!=null && this.sitclin.getFlutter()==1?true:false);
	}
	
	/**
	 * Metodo para precargar situacion clinica general en el bloque de situacion clinica de procedimiento
	 * Solo se invocara cuando se haga un nuevo registro
	 * @param e
	 */
	private void cargaSituacionClinica(){
		try {
			SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
			this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());			
			this.sitclin.setFevi(sgen.getFevi()!=null?sgen.getFevi():null);
			this.sitclin.setFuncionventricular(sgen.getFuncionventricular()!=null?sgen.getFuncionventricular():null);
			this.sitclin.setNyha(sgen.getNyha()!=null?sgen.getNyha():null);
			this.sitclin.setIc(sgen.getNyha()!=null&&sgen.getNyha()>0?true:false);
			this.sgen.setIc(sgen.getNyha()!=null&&sgen.getNyha()>0?true:false);
			this.sitclin.setCardiop(sgen.getCardiopatia()!=null?true:false);
			this.sgen.setCardiop(sgen.getCardiopatia()!=null?true:false);
			this.sitclin.setCardiopatia(sgen.getCardiopatia()!=null?sgen.getCardiopatia():null);
			this.sitclin.setOtra(sgen.getOtra()!=null?sgen.getOtra():null);
			this.sitclin.setAevolucion(sgen.getAevolucion()!=null?sgen.getAevolucion():null);
			this.sitclin.setRevasc(sgen.getRevasc()!=null?sgen.getRevasc():null);
			this.sitclin.setRevascularizacion((sgen.getRevasc()!=null && sgen.getRevasc()==1)?true:false);
			this.sgen.setRevascularizacion((sgen.getRevasc()!=null && sgen.getRevasc()==1)?true:false);
			this.sitclin.setInfprevio(sgen.getInfprevio()!=null?sgen.getInfprevio():null);
			this.sitclin.setInfartoprev((sgen.getInfprevio()!=null && sgen.getInfprevio()==1)?true:false);
			this.sgen.setInfartoprev((sgen.getInfprevio()!=null && sgen.getInfprevio()==1)?true:false);
			this.sitclin.setAnio(sgen.getAnio()!=null?sgen.getAnio():null);
			this.sitclin.setLocalizacion(sgen.getLocalizacion()!=null?sgen.getLocalizacion():null);
			this.sitclin.setArritmias(sgen.getArritmias()!=null?sgen.getArritmias():null);
			this.sitclin.setAvent(sgen.getArritmias()!=null&&sgen.getArritmias()>0?true:false);
			this.sgen.setAvent(sgen.getArritmias()!=null&&sgen.getArritmias()>0?true:false);
			this.sitclin.setEef(sgen.getEef()!=null?sgen.getEef():null);
			this.sitclin.setEefprev((sgen.getEef()!=null && sgen.getEef()>0)?true:false);
			this.sgen.setEefprev((sgen.getEef()!=null && sgen.getEef()>0)?true:false);
			this.sitclin.setInsrenal(sgen.getInsrenal()!=null?sgen.getInsrenal():null);
			this.sitclin.setAnteinsrenal(sgen.getInsrenal()!=null&&sgen.getInsrenal()==1?true:false);
			this.sgen.setAnteinsrenal(sgen.getInsrenal()!=null&&sgen.getInsrenal()==1?true:false);
			this.sitclin.setAntfa(sgen.getAntfa()!=null?sgen.getAntfa():null);
			this.sitclin.setAntefa(sgen.getAntfa()!=null&&sgen.getAntfa()==1?true:false);
			this.sgen.setAntefa(sgen.getAntfa()!=null&&sgen.getAntfa()==1?true:false);
			this.sitclin.setDiabetes(sgen.getDiabetes()!=null?sgen.getDiabetes():null);
			this.sitclin.setAntediab(sgen.getDiabetes()!=null&&sgen.getDiabetes()==1?true:false);
			this.sgen.setAntediab(sgen.getDiabetes()!=null&&sgen.getDiabetes()==1?true:false);
			this.sitclin.setHta(sgen.getHta()!=null?sgen.getHta():null);
			this.sitclin.setAnteHTA(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.sgen.setAnteHTA(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.sitclin.setHipercolest(sgen.getHta()!=null?sgen.getHta():null);
			this.sitclin.setAntehipercol(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.sgen.setAntehipercol(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.sitclin.setMuertesubita(sgen.getMuertesubita()!=null?sgen.getMuertesubita():null);
			this.sitclin.setAntefam(sgen.getMuertesubita()!=null&&sgen.getMuertesubita()==1?true:false);
			this.sgen.setAntefam(sgen.getMuertesubita()!=null&&sgen.getMuertesubita()==1?true:false);
			this.sitclin.setTabaquismo(sgen.getTabaquismo()!=null?sgen.getTabaquismo():null);
			this.sitclin.setAntetabaq(sgen.getTabaquismo()!=null&&sgen.getTabaquismo()==1?true:false);
			this.sgen.setAntetabaq(sgen.getTabaquismo()!=null&&sgen.getTabaquismo()==1?true:false);
			this.sitclin.setDislipemia(sgen.getDislipemia()!=null?sgen.getDislipemia():null);
			this.sitclin.setAnteDislipemia(sgen.getDislipemia()!=null&&sgen.getDislipemia()==1?true:false);
			this.sgen.setAnteDislipemia(sgen.getDislipemia()!=null&&sgen.getDislipemia()==1?true:false);
			this.sitclin.setAcv(sgen.getAcv()!=null?sgen.getAcv():null);
			this.sitclin.setAnteacv(sgen.getAcv()!=null&&sgen.getAcv()==1?true:false);
			this.sgen.setAnteacv(sgen.getAcv()!=null&&sgen.getAcv()==1?true:false);
			this.sitclin.setTrasplantecardiaco(sgen.getTrasplantecardiaco()!=null?sgen.getTrasplantecardiaco():null);
			this.sitclin.setAnteTrasplanteCardiaco(sgen.getTrasplantecardiaco()!=null&&sgen.getTrasplantecardiaco()==1?true:false);
			this.sgen.setAnteTrasplanteCardiaco(sgen.getTrasplantecardiaco()!=null&&sgen.getTrasplantecardiaco()==1?true:false);
			this.sitclin.setAit(sgen.getAit()!=null?sgen.getAit():null);
			this.sitclin.setAnteAIT(sgen.getAit()!=null&&sgen.getAit()==1?true:false);
			this.sgen.setAnteAIT(sgen.getAit()!=null&&sgen.getAit()==1?true:false);
			this.sitclin.setEpoc(sgen.getEpoc()!=null?sgen.getEpoc():null);
			this.sitclin.setAnteEPOC(sgen.getEpoc()!=null&&sgen.getEpoc()==1?true:false);
			this.sgen.setAnteEPOC(sgen.getEpoc()!=null&&sgen.getEpoc()==1?true:false);
			this.sitclin.setSahs(sgen.getSahs()!=null?sgen.getSahs():null);
			this.sitclin.setAnteSAHS(sgen.getSahs()!=null&&sgen.getSahs()==1?true:false);
			this.sgen.setAnteSAHS(sgen.getSahs()!=null&&sgen.getSahs()==1?true:false);
			this.sitclin.setTiposahs(sgen.getTiposahs()!=null?sgen.getTiposahs():null);
			this.sitclin.setAhi(sgen.getAhi()!=null?sgen.getAhi():null);
			this.sitclin.setCpap(sgen.getCpap()!=null?sgen.getCpap():null);
			this.sitclin.setAnteCPAP(sgen.getCpap()!=null&&sgen.getCpap()==1?true:false);
			this.sgen.setAnteCPAP(sgen.getCpap()!=null&&sgen.getCpap()==1?true:false);
			this.sitclin.setNeoplasia(sgen.getNeoplasia()!=null?sgen.getNeoplasia():null);
			this.sitclin.setAnteNeoplasia(sgen.getNeoplasia()!=null&&sgen.getNeoplasia()==1?true:false);
			this.sgen.setAnteNeoplasia(sgen.getNeoplasia()!=null&&sgen.getNeoplasia()==1?true:false);
			this.sitclin.setTiponeoplasia(sgen.getTiponeoplasia()!=null?sgen.getTiponeoplasia():null);
			this.sitclin.setAfectiroidea(sgen.getAfectiroidea()!=null?sgen.getAfectiroidea():null);
			this.sitclin.setNeuromediados(sgen.getNeuromediados()!=null?sgen.getNeuromediados():null);
			this.sitclin.setSincope(sgen.getSincope()!=null?sgen.getSincope():null);
			this.sitclin.setAnteSincope(sgen.getSincope()!=null&&sgen.getSincope()==1?true:false);
			this.sgen.setAnteSincope(sgen.getSincope()!=null&&sgen.getSincope()==1?true:false);
			this.sitclin.setParadacardiaca(sgen.getParadacardiaca()!=null?sgen.getParadacardiaca():null);
			this.sitclin.setAnteParadaCardiaca(sgen.getParadacardiaca()!=null&&sgen.getParadacardiaca()==1?true:false);
			this.sgen.setAnteParadaCardiaca(sgen.getParadacardiaca()!=null&&sgen.getParadacardiaca()==1?true:false);
			this.sitclin.setEnfarterios(sgen.getEnfart()!=null&&sgen.getEnfart()==1?true:false);
			this.sitclin.setAi(sgen.getAi()!=null?sgen.getAi():null);
			this.sitclin.setAi2(sgen.getAi2()!=null?sgen.getAi2():null);
			this.sitclin.setAnteflutter(sgen.getFlutter()!=null&&sgen.getFlutter()==1?true:false);
			this.sitclin.setAlergias(sgen.getAlergias()!=null?sgen.getAlergias():null);
		} catch (Exception e1) {
			logger.error("("+this.usuario+") No se puede recuperar situacion clínica general de paciente. Motivo: "+ e1.fillInStackTrace());		
		}
	}
	/**
	 * Metodo para modificar si procede el bloque de situacion clinica general de paciente
	 * si se detectan cambios en la situacion clinica de procedimiento.
	 */
	private void modificaSituacionClinicaGeneral(){
		// La fecha de procedimiento debe ser mayor o igual que la fecha de modificacion de scg. 
		// En otro caso, no se actualiza
		if(this.sgen.getFechamod()==null || UtilFechas.dateDiff(this.proc.getFecha(), this.sgen.getFechamod())>=0 ){		
			if(this.modsitclin){
				logger.info("("+this.usuario+") Se han detectado cambios en la situación clínica de procedimiento. Se procederá a actualizar la situación clínica general de paciente");
				// Cambio en FEVI o Funcion Ventricular
				if(((this.sgen.getFevi()!=null)&&!(this.sgen.getFevi().equals(this.sitclin.getFevi()))) 
						|| ((this.sgen.getFuncionventricular()!=null) &&!(this.sgen.getFuncionventricular().equals(this.sitclin.getFuncionventricular())))){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFevi(this.sitclin.getFevi());
					this.sgen.setFuncionventricular(this.sitclin.getFuncionventricular());
				}
				if(this.sgen.getFevi()==null && this.sitclin.getFevi()!=null){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFevi(this.sitclin.getFevi());
				}
				if(this.sgen.getFuncionventricular()==null && this.sitclin.getFuncionventricular()!=null){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFuncionventricular(this.sitclin.getFuncionventricular());
				}		
				this.sgen.setFechamod(this.proc.getFecha());// Actualizacion de fecha de modificacion de scg
				// Actualizar situacion clinica
				SituacionClinicaGeneralDao sitclindao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				try {
					sitclindao.update(this.sgen.createPk(), this.sgen);
					// Actualizar el objeto cp.pacienteSelect - situacionclinicageneral
					//cp.pacienteSelect.setSitclin(sgen);
					cp.getPacienteSelect().setSitclin(this.sgen);
				} catch (SituacionClinicaGeneralDaoException e) {
					logger.error("("+this.usuario+") Error al actualizar situacion clinica general de paciente. Motivo: "+e.fillInStackTrace());
				}
			}	
		}	
	}
	
	public void ordenaFEVI(ActionEvent e){
		try{
			int fevi = Integer.valueOf(this.sitclin.getFevi());
			if(fevi>50)
				this.sitclin.setFuncionventricular(1);
			else if(fevi>=41 && fevi<=50)
				this.sitclin.setFuncionventricular(2);
			else if(fevi>=36 && fevi<=40)
				this.sitclin.setFuncionventricular(3);
			else if(fevi>=31 && fevi<=35)
				this.sitclin.setFuncionventricular(4);
			else
				this.sitclin.setFuncionventricular(5);
			this.modsitclin = true;
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_sitclin_fe")+":  "+ e1.getMessage());
			this.sitclin.setFevi(null);
		}	
	}
	public void resetFEVI(ActionEvent e){
		this.modsitclin = true;
		this.sitclin.setFevi(null);
		if((this.sitclin.getFuncionventricular()==0 || this.sitclin.getFuncionventricular()==6))
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,this.bundle.getString("info_msg_warn_sitclin_fevi"));
	}
	public void cambiaCardiopatiaEtiologia(ActionEvent e) {
		if (!(this.getSitclin().getCardiopatia().equals(923))) {
			if (this.getSitclin().getCardiopatia().equals(913))
				this.getSitclin().setEtiologia(891);
			else if (this.getSitclin().getCardiopatia().equals(914))
				this.getSitclin().setEtiologia(895);
			else if (this.getSitclin().getCardiopatia().equals(915))
				this.getSitclin().setEtiologia(907);
			else if (this.getSitclin().getCardiopatia().equals(916))
				this.getSitclin().setEtiologia(906);
			else if (this.getSitclin().getCardiopatia().equals(917))
				this.getSitclin().setEtiologia(891);
			else if (this.getSitclin().getCardiopatia().equals(918))
				this.getSitclin().setEtiologia(909);
			else if (this.getSitclin().getCardiopatia().equals(919))
				this.getSitclin().setEtiologia(897);
			else if (this.getSitclin().getCardiopatia().equals(920)
					|| this.getSitclin().getCardiopatia().equals(921)
					|| this.getSitclin().getCardiopatia().equals(922))
				this.getSitclin().setEtiologia(892);
			else
				this.getSitclin().setEtiologia(891);
			this.getSitclin().setOtra("");	
		}
		this.modsitclin = true;
		this.sgen.setCardiop(this.sitclin.isCardiop());
		this.sgen.setCardiopatia(this.sitclin.getCardiopatia());
		this.sgen.setOtra(this.sitclin.getOtra());
	}
	/****** controles booleanos -short ****/
	public void anteInsRenal(ActionEvent e) {
		this.sitclin.setInsrenal((short) (this.sitclin.isAnteinsrenal() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setInsrenal(this.sitclin.getInsrenal());
		this.sgen.setAnteinsrenal(this.sitclin.isAnteinsrenal());
	}

	public void anteFA(ActionEvent e) {
		this.sitclin.setAntfa((short) (this.sitclin.isAntefa() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAntfa(this.sitclin.getAntfa());
		this.sgen.setAntefa(this.sitclin.isAntefa());
	}

	public void anteFlutter(ActionEvent e) {
		this.sitclin.setFlutter((short) (this.sitclin.isAnteflutter() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setFlutter(this.sitclin.getFlutter());
		this.sgen.setAnteflutter(this.sitclin.isAnteflutter());
	}

	public void anteDiab(ActionEvent e) {
		this.sitclin.setDiabetes((short) (this.sitclin.isAntediab() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setDiabetes(this.sitclin.getDiabetes());
		this.sgen.setAntediab(this.sitclin.isAntediab());
	}

	public void anteHipertens(ActionEvent e) {
		this.sitclin.setHipertension((short) (this.sitclin.isAnteHTA() ? 1 : 0));
		this.sitclin.setHta((short) (this.sitclin.isAnteHTA() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setHta(this.sitclin.getHipertension());
		this.sgen.setAnteHTA(this.sitclin.isAnteHTA());
	}

	public void anteFam(ActionEvent e) {
		this.sitclin.setMuertesubita((short) (this.sitclin.isAntefam() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setMuertesubita(this.sitclin.getMuertesubita());
		this.sgen.setAntefam(this.sitclin.isAntefam());
	}

	public void anteTabaq(ActionEvent e) {
		this.sitclin.setTabaquismo((short) (this.sitclin.isAntetabaq() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setTabaquismo(this.sitclin.getTabaquismo());
		this.sgen.setAntetabaq(this.sitclin.isAntetabaq());
	}

	public void anteHipercoles(ActionEvent e) {
		this.sitclin.setHipercolest((short) (this.sitclin.isAntehipercol() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setDislipemia(this.sitclin.getHipercolest());
		this.sgen.setAnteDislipemia(this.sitclin.isAnteDislipemia());
	}

	public void anteACV(ActionEvent e) {
		this.sitclin.setAcv((short) (this.sitclin.isAnteacv() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAcv(this.sitclin.getAcv());
		this.sgen.setAnteacv(this.sitclin.isAnteacv());
	}
	
	public void reVasc(ActionEvent e) {
		this.sitclin.setRevasc((short) (this.sitclin.isRevascularizacion() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setRevasc(this.sitclin.getRevasc());
		this.sgen.setRevascularizacion(this.sitclin.isRevascularizacion());
	}

	public void infPrevio(ActionEvent e) {
		this.sitclin.setInfprevio((short) (this.sitclin.isInfartoprev() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setInfprevio(this.sitclin.getInfprevio());
		this.sgen.setInfartoprev(this.sitclin.isInfartoprev());
		// Actualizacion de valores de infarto previo si false
		if (!(this.sitclin.isInfartoprev())) {
			this.sitclin.setAnio(null);
			this.sgen.setAnio(this.sitclin.getAnio());
			this.sitclin.setLocalizacion(null);
			this.sgen.setLocalizacion(this.sitclin.getLocalizacion());
		}		
	}

	public void cambiaAnosEvolucion(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAevolucion(this.sitclin.getAevolucion());
	}

	public void cambiaAnosInfPrevio(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAnio(this.sitclin.getAnio());
	}

	public void cambiaLocalizacion(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setLocalizacion(this.sitclin.getLocalizacion());
	}

	public void cambiaAIT(ActionEvent e) {
		this.sitclin.setAit((short) (this.sitclin.isAnteAIT() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAit(this.sitclin.getAit());
		this.sgen.setAnteAIT(this.sitclin.isAnteAIT());
	}

	public void cambiaEPOC(ActionEvent e) {
		this.sitclin.setEpoc((short) (this.sitclin.isAnteEPOC() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setEpoc(this.sitclin.getEpoc());
		this.sgen.setAnteEPOC(this.sitclin.isAnteEPOC());
	}

	public void cambiaSAHS(ActionEvent e) {
		this.sitclin.setSahs((short) (this.sitclin.isAnteSAHS() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setSahs(this.sitclin.getSahs());
		this.sgen.setAnteSAHS(this.sitclin.isAnteSAHS());
		if(!(this.sitclin.isAnteSAHS())){
			this.sitclin.setTiposahs(null);
			this.sgen.setTiposahs(this.sitclin.getTiposahs());
			this.sitclin.setCpap(null);
			this.sgen.setCpap(this.sitclin.getCpap());
			this.sitclin.setAnteCPAP(false);			
			this.sitclin.setAhi(null);
			this.sgen.setAhi(this.sitclin.getAhi());
		}
		this.sgen.setAnteCPAP(this.sitclin.isAnteCPAP());
	}

	public void cambiaTipoSAHS(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setTiposahs(this.sitclin.getTiposahs());
	}

	public void cambiaNeoplasia(ActionEvent e) {
		this.sitclin.setNeoplasia((short) (this.sitclin.isAnteNeoplasia() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setNeoplasia(this.sitclin.getNeoplasia());
		this.sgen.setAnteNeoplasia(this.sitclin.isAnteNeoplasia());
		if(!(this.sitclin.isAnteNeoplasia())){
			this.sitclin.setTiponeoplasia(null);
			this.sgen.setTiponeoplasia(this.sitclin.getTiponeoplasia());
		}		
	}

	public void cambiaTipoNeoplasia(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setTiponeoplasia(this.sitclin.getTiponeoplasia());
	}
	public void cambiaAlergias(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAlergias(this.sitclin.getAlergias());
	}

	public void cambiaCPAP(ActionEvent e) {
		this.sitclin.setCpap((short) (this.sitclin.isAnteCPAP() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setCpap(this.sitclin.getCpap());
		this.sgen.setAnteCPAP(this.sitclin.isAnteCPAP());
	}

	public void anteTCardiaco(ActionEvent e) {
		this.sitclin.setTrasplantecardiaco((short) (this.sitclin.isAnteTrasplanteCardiaco() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setTrasplantecardiaco(this.sitclin.getTrasplantecardiaco());
		this.sgen.setAnteTrasplanteCardiaco(this.sitclin.isAnteTrasplanteCardiaco());
	}

	public void cambiaSincope(ActionEvent e){
		this.sitclin.setSincope((short) (this.sitclin.isAnteSincope()?1:0));
		this.modsitclin = true;
		this.sgen.setSincope(this.sitclin.getSincope());
		this.sgen.setAnteSincope(this.sitclin.isAnteSincope());
	}

	public void cambiaParadaCardiaca(ActionEvent e){
		this.sitclin.setParadacardiaca((short)(this.sitclin.isAnteParadaCardiaca()?1:0));
		this.modsitclin = true;
		this.sgen.setParadacardiaca(this.sitclin.getParadacardiaca());
		this.sgen.setAnteParadaCardiaca(this.sitclin.isAnteParadaCardiaca());
	}

	public void cambiaArritmiasVentriculares(ActionEvent e){
		if(!this.sitclin.isAvent()){
			this.sitclin.setArritmias(null);
			this.sgen.setArritmias(this.sitclin.getArritmias());	
		}	
		this.sgen.setAvent(this.sitclin.isAvent());
		this.modsitclin = true;
	}

	public void cambiaArrVent(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setArritmias(this.sitclin.getArritmias());
	}

	public void cambiaEefPrevio(ActionEvent e){
		if(!this.sitclin.isEefprev()){
			this.sitclin.setEef(null);
			this.sgen.setEef(this.sitclin.getEef());			
		}
		this.sgen.setEefprev(this.sitclin.isEefprev());
		this.modsitclin = true;
	}

	public void cambiaEEF(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setEef(this.sitclin.getEef());
	}

	public void cambiaIC(ActionEvent e){
		if(!(this.sitclin.isIc())){
			this.sitclin.setNyha(null);
			this.sgen.setNyha(this.sitclin.getNyha());			
		}	
		this.sgen.setIc(this.sitclin.isIc());
		this.modsitclin = true;
	}

	public void cambiaNYHA(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setNyha(this.sitclin.getNyha());
	}

	public void cambiaAfecTiroidea(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAfectiroidea(this.sitclin.getAfectiroidea());
	}

	public void cambiaNeurologicos(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setNeuromediados(this.sitclin.getNeuromediados());
	}

	public void cambiaEnfArt(ActionEvent e){
		this.sitclin.setEnfart(this.sitclin.isEnfarterios()?1:0);
		this.modsitclin = true;
		this.sgen.setEnfart(this.sitclin.getEnfart());
	}

	public void cambiaAI(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAi(this.sitclin.getAi());
	}

	public void cambiaAI2(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAi2(this.sitclin.getAi2());
	}
	
	/****** controles booleanos -short ****/
	
	public void lecturaProperties() {
		try {
			this.prop = new Properties();
			InputStream is = ControlRegEvExt.class.getResourceAsStream("regevext.properties");
			this.prop.load(is);
			this.DIR_PACIENTES = this.prop.getProperty("dir.pacientes");
			this.DIR_ESCUCHA_LECTURA_SD = this.prop.getProperty("dir.eventscope");			
			this.DIR_ESCUCHA_ANALISIS = this.prop.getProperty("dir.eventscope");
			this.ESTACIONES_CLIENTE = this.prop.getProperty("ips.analisis");
			this.ESTACIONES_CLIENTE_LECTURA = this.prop.getProperty("ips.lectura");			
			is.close();
			Properties p = new Properties();
			is = ControlRegEvExt.class.getResourceAsStream("labels.properties");
			p.load(is);
			is.close();
			this.infocentro = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
						p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"));
		} catch (Exception e) {
			this.pintaMensaje(ERROR, "Error. No es posible inicializar fichero de propiedades. Motivo: "+e.getMessage());
		}	
	}
	
	public void getInfoEstacionCliente(){
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();	
		this.IP_ESTACION_CLIENTE = req.getRemoteAddr();
		this.DIR_ESCUCHA_ANALISIS_CLIENTE = setDirectorioEscuchaAnalisis();
		this.DIR_ESCUCHA_LECTURA_SD_CLIENTE = setDirectorioEscuchaLectura();
	}
	
	public String setDirectorioEscuchaAnalisis(){
		String[] ips = this.ESTACIONES_CLIENTE.split("_");
		for(int i=0;i<ips.length;i++){
			if(ips[i].equals(this.IP_ESTACION_CLIENTE))
				return "\\\\"+ips[i]+"\\"+this.DIR_ESCUCHA_ANALISIS;
		}
		return null;
	}
	
	public String setDirectorioEscuchaLectura(){
		String[] ips = this.ESTACIONES_CLIENTE_LECTURA.split("_");
		for(int i=0;i<ips.length;i++){
			if(ips[i].equals(this.IP_ESTACION_CLIENTE))
				return "\\\\"+ips[i]+"\\"+this.DIR_ESCUCHA_LECTURA_SD;
		}
		return null;
	}
	/**
	 * Mecanismo de poll para consulta de PDF asociado
	 * @return
	 */
	public String getTiempo(){
		if(this.regevext.isIniciado()){
			String time = "";
			if(this.segundos == 0){
				// Consulta existencia de fichero
				if(this.compruebaInformePdf()){
					try{
						this.regevext.setEstado(3);// Con informe asociado
						this.regevextdao.update(this.regevext.createPk(), this.regevext);
					}catch(Exception e1){
						e1.printStackTrace();
						logger.error("("+this.usuario+") No se puede actualizar estado de regisro de holter. Motivo: "+ e1.getMessage());
					}
				}
				this.inicializaTiempo();
				this.segundos--;
			}else
				this.segundos--;		
			time = "0" + (this.segundos+1);			
			return "Tiempo estimado para el próxima consulta de informes adjuntos: " + time + " segundos.";
		}
		else
			return "";
	}
	
	private void inicializaTiempo(){
		this.segundos = TIEMPO_CONSULTA;
	}
	
	
	/***********************************
	 ********** GET / SET **************
	 ***********************************/
	
	public ArrayList<SelectItem> getReferidores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_referidor")));
		for (ArrMaestras ref : this.referidores)
			diag.add(new SelectItem(ref.getValor(), ref.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getEnfermeras() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.enfermeria)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getEnfermerasTodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.enfermeria_todos)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getPrimerOperador() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.primerop)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getPrimerOperadorTodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.primerop_todos)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getSegundoOperador() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.segundoop)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getSegundoOperadorTodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.segundoop_todos)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getSintomas() {
		ArrayList<SelectItem> sintomas = new ArrayList<SelectItem>();
		sintomas.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.sintomas)
			sintomas.add(new SelectItem(procedimiento.getValor(), procedimiento
					.getValor()));
		return sintomas;
	}
	
	public ArrayList<SelectItem> getEtiologia() {
		ArrayList<SelectItem> et = new ArrayList<SelectItem>();
		et.add(new SelectItem("00", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.etiologia)
			et.add(new SelectItem(procedimiento.getCodigo().toString(),
					procedimiento.getValor()));
		return et;
	}

	public ArrayList<SelectItem> getRitmos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado")));
		for (ArrMaestras diagnostico : this.ritmos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getRitmostv() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado")));
		for (ArrMaestras diagnostico : this.ritmostv)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getRitmosfa() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado")));
		for (ArrMaestras diagnostico : this.ritmosfa)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getRitmossa() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado")));
		for (ArrMaestras diagnostico : this.ritmossa)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getConducciones() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado")));
		for (ArrMaestras diagnostico : this.conducciones)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getConduccionavotros() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado")));
		for (ArrMaestras diagnostico : this.conduccionavotros)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getQrs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado")));
		for (ArrMaestras diagnostico : this.qrs)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getQrsotros() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", this.bundle.getString("no_especificado")));
		for (ArrMaestras diagnostico : this.qrsotros)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getCardiopatia() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("00", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras cardio : this.cardiopatia)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio
					.getValor()));
		return cp;
	}

	public ArrayList<SelectItem> getTipos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem("1", this.bundle.getString("prot_tipo_op1")));
		return diag;
	}
	
	public HtmlDataTable getBindingepi() {
		return bindingepi;
	}

	public void setBindingepi(HtmlDataTable bindingepi) {
		this.bindingepi = bindingepi;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public SituacionClinicaProc getSitclin() {
		return sitclin;
	}

	public void setSitclin(SituacionClinicaProc sitclin) {
		this.sitclin = sitclin;
	}

	public HtmlDataTable getBindingSintomas() {
		return bindingSintomas;
	}

	public void setBindingSintomas(HtmlDataTable bindingSintomas) {
		this.bindingSintomas = bindingSintomas;
	}

	public ArrayList<EpisodioDto> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(ArrayList<EpisodioDto> episodios) {
		this.episodios = episodios;
	}

	public RegistradorEventosExt getRegevext() {
		return regevext;
	}

	public void setRegevext(RegistradorEventosExt regevext) {
		this.regevext = regevext;
	}

	public HtmlDataTable getBindingRegEvExt() {
		return bindingRegEvExt;
	}

	public void setBindingRegEvExt(HtmlDataTable bindingRegEvExt) {
		this.bindingRegEvExt = bindingRegEvExt;
	}

	public HtmlDataTable getBindingBuscar() {
		return bindingBuscar;
	}

	public void setBindingBuscar(HtmlDataTable bindingBuscar) {
		this.bindingBuscar = bindingBuscar;
	}

	public String getSelectedtab() {
		return selectedtab;
	}

	public void setSelectedtab(String selectedtab) {
		this.selectedtab = selectedtab;
	}

	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public ArrayList<Procedimiento> getProcs() {
		return procs;
	}

	public void setProcs(ArrayList<Procedimiento> procs) {
		this.procs = procs;
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

	public Procedimiento[] getProclst() {
		return proclst;
	}

	public void setProclst(Procedimiento[] proclst) {
		this.proclst = proclst;
	}

	public String getDIR_ESCUCHA_ANALISIS_CLIENTE() {
		return DIR_ESCUCHA_ANALISIS_CLIENTE;
	}

	public void setDIR_ESCUCHA_ANALISIS_CLIENTE(String dIR_ESCUCHA_ANALISIS_CLIENTE) {
		DIR_ESCUCHA_ANALISIS_CLIENTE = dIR_ESCUCHA_ANALISIS_CLIENTE;
	}

	public String getDIR_ESCUCHA_LECTURA_SD_CLIENTE() {
		return DIR_ESCUCHA_LECTURA_SD_CLIENTE;
	}

	public void setDIR_ESCUCHA_LECTURA_SD_CLIENTE(
			String dIR_ESCUCHA_LECTURA_SD_CLIENTE) {
		DIR_ESCUCHA_LECTURA_SD_CLIENTE = dIR_ESCUCHA_LECTURA_SD_CLIENTE;
	}

	public HtmlDataTable getBindingPdf() {
		return bindingPdf;
	}

	public void setBindingPdf(HtmlDataTable bindingPdf) {
		this.bindingPdf = bindingPdf;
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

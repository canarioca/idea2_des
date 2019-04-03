package com.sorin.idea.iu;

import java.io.File;
import java.io.InputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.sorin.idea.dao.ArrCardioversionDao;
import com.sorin.idea.dao.DocHL7InformesDao;
import com.sorin.idea.dao.EpisodioDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.PacienteDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.SintomasSitclinProcDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dao.UsuarioDao;
import com.sorin.idea.dto.ArrAcceso;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrCardioversionPk;
import com.sorin.idea.dto.ArrEstudio;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Complicacion;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.SegClinComplicaciones;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SintomasSitclinProcPk;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.SituacionClinicaProcPk;
import com.sorin.idea.exceptions.ArrCardioversionDaoException;
import com.sorin.idea.exceptions.SituacionClinicaGeneralDaoException;
import com.sorin.idea.jdbc.ArrCardioversionDaoImpl;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.jdbc.SintomasSitclinProcDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.GestorFTPInforme;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilMapeos;

import hvn.apl.evomed.dto.DocHl7Dto;
import hvn.apl.evomed.ssh.UtilesTerminalSsh;
import hvn.apl.evomed.ssh.exception.SshException;
import hvn.apl.jProyecto2010.modelo.servicios.dto.SesionUsuarioDto;
import hvn.cm.dao.DAOException;
import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

public class ControlCardioversion extends BaseIU {

	private static Logger logger = Logger.getLogger(ControlCardioversion.class);
	private java.sql.Connection conn;
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private ControlMaestras cm;
	private ArrCardioversion cv;
	private ArrCardioversion[] cvslist;
	private ArrayList<ArrCardioversion> cvs;
	private ArrCardioversionDao cvdao;
	private ArrCardioversionPk cvpk;
	private ControlPacientes cp;
	private LoginForm lf;
	private HtmlDataTable bindingHistorico;
	private HtmlDataTable bindingHistoricoCv;
	private String columna = "fecha";
	private boolean ascendente = false;
	
	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	private PacienteDao pacientedao = new PacienteDao();
	private String usuario = "";
	private InfoCentro infocentro;
	/**************************/
	private Procedimiento[] proclst;
	private ArrayList<Procedimiento> procs;
	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ProcedimientoDao procdao;
	private HtmlDataTable bindingBuscar;
	
	private SituacionClinicaProc stclin;
	private SituacionClinicaProcDao stclindao;
	private SintomasSitclinProcDao sintdao;
	
	private SituacionClinicaGeneral sgen;
	private SituacionClinicaGeneralDao sgendao;
	private HtmlDataTable bindingSintomas;
	private boolean modsitclin;
	
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
	private EpisodioDao epdao;
	private EventoDao evdao;
	
	private boolean editable;

	private ControlComplicaciones cc;
	private ComplicacionesPacientes compac;
	private ComplicacionesPacientes currentItemComp;
	private HtmlDataTable bindingComplicacionesProc;
	private ArrayList<ComplicacionesPacientes> listacompl;
	private boolean editableProc;
	
	public ControlCardioversion() {
	}

	public void iniciaCardioversion(ActionEvent e) {
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
			
			this.cc = (ControlComplicaciones) getBean("controlComplicaciones");
			if(this.cc == null)
				this.cc = new ControlComplicaciones();
			this.cc.inicia(null); // importante
			
			lecturaProperties();
			this.cargaMaestras();
			this.cv = new ArrCardioversion();
			this.cvpk = new ArrCardioversionPk();
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			this.setEditable(true);
			this.proc = new Procedimiento();
			this.proc.setFecha(new Date());
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.procpk = new ProcedimientoPk();
			this.procs = new ArrayList<Procedimiento>();
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			this.cvdao = new ArrCardioversionDaoImpl(lf.getSesionUsuario().getUsuario());
			this.stclin = new SituacionClinicaProc();
			this.stclindao = new SituacionClinicaProcDaoImpl(this.usuario);
			this.sintdao = new SintomasSitclinProcDaoImpl(this.usuario);
			this.sgendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
			
			this.compac = new ComplicacionesPacientes();
			this.compac.setFechaini(this.cv.getFecha());
			this.compac.setTipo(1);
			this.setEditableProc(false);
			this.currentItemComp = new ComplicacionesPacientes();
			this.listacompl = new ArrayList<ComplicacionesPacientes>();
			
			cargaSituacionClinica();
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_error_sel_pat"));
			} else {
				
				this.proclst = this.procdao.findByDynamicWhere("CODIGO =? AND TIPOPROCEDIMIENTO = ?",
						new Object[] {this.cp.getPacienteSelect().getCodigo(),1068});	
				if(this.proclst != null)
					for(Procedimiento p:this.proclst)
						this.procs.add(p);
				
				//this.cvs = new ArrayList<ArrCardioversion>();
				this.cv.setCodigoPaciente(this.cp.getPacienteSelect().getCodigo());
				/*this.cvslist = this.cvdao.findWhereCodigoPacienteEquals(this.cv
						.getCodigoPaciente());
				if (this.cvslist != null)
					for (int i = 0; i < this.cvslist.length; i++)
						this.cvs.add(this.cvslist[i]);*/
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_rec_pat")+": "+ e1.getMessage());
		}
	}

	public void cargaMaestras() {
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
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
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
	}

	public void cargaUltimoCV() {
		this.cv = this.cvs.get(0);
	}

	public void cargaCardioversion_OLD(ActionEvent e) {
		Integer fila = this.bindingHistorico.getRowIndex();
		this.cv = this.cvs.get(fila);
		this.cvpk = this.cv.createPk();
	}
	public void cargaCardioversion(ActionEvent e) {
		try{
			this.proc = this.procs.get(this.bindingHistorico.getRowIndex());
			this.procpk = this.proc.createPk();
			this.cv = this.cvdao.findByPrimaryKey(this.proc.getCodigo(), this.proc.getIdprocedimiento());
			this.cvpk = this.cv.createPk();
			cargaComponentes();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());			
		}
	}
	public void cargaCardioversionDesdeBarraTemporal(ActionEvent e) {
		try{
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
							new Object[] {cp.getNumeroprocedimientobarratemporal(),1068})[0];
			this.procpk = this.proc.createPk();
			this.cv = this.cvdao.findByPrimaryKey(this.proc.getCodigo(), this.proc.getIdprocedimiento());
			this.cvpk = this.cv.createPk();
			cargaComponentes();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			logger.info("("+this.usuario+") Consulta de registro (Cardioversión). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Cardioversión). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	public void cargaCardioversionConsulta(ActionEvent e) {
		try{
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
							new Object[] {cp.getPacienteSelect().getIdcv(),1068})[0];
			this.procpk = this.proc.createPk();
			this.cv = this.cvdao.findByPrimaryKey(this.proc.getCodigo(), this.proc.getIdprocedimiento());
			this.cvpk = this.cv.createPk();
			cargaComponentes();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			logger.info("("+this.usuario+") Consulta de registro (Cardioversión). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Cardioversión). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	
	public void limpia(ActionEvent e) {
		this.cv = new ArrCardioversion();
		this.cv.setCodigoPaciente(this.cp.getPacienteSelect().getCodigo());
		this.cvpk = new ArrCardioversionPk();
	}
	
	public void preguarda(ActionEvent e) {
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
				if(ev!=null && ev.getProcedimiento()==1068 && ev.getEstado()==1 && proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));
			}			
		} catch (Exception e1) {
			this.pintaMensaje(3,this.bundle.getString("info_msg_error_carga_epi")+": "+ e1.getMessage());
		}
		/*try {
			this.episodios = new ArrayList<EpisodioDto>();
			this.episodios = (ArrayList<EpisodioDto>) this.pacientedao
				.getEpisodios(this.cp.getPacienteSelect()
						.getNhc());
			this.episodios.addAll((ArrayList<EpisodioDto>) this.pacientedao
					.getEpisodiosHospitalizacion(this.cp.getPacienteSelect()
							.getNhc()));
		} catch (DAOException e1) {
			this.pintaMensaje(3,
					"No se han podido obtener los episodios de hospitalización del paciente: "
							+ e1.getMessage());
		}*/
	}

	public void guarda(ActionEvent e) {
		
		Integer epi = this.bindingepi.getRowIndex();
		if(epi != null && epi >= 0){
			this.cv.setEpisodio(this.episodios.get(epi).getNumicu());
			this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());
		}			
		boolean existe = false;
		try {
			//this.conn.setAutoCommit(false);
			if (this.cv.getFecha() == null) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_guarda_error_fecha"));
			} else {
				if (this.cv.getNcv() == null || this.cv.getNcv().length() != 5)
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("info_msg_guarda_error_nproc")+" "+ ((this.cv.getFecha().getYear() + 1900) + "").substring(2) + " "+this.bundle.getString("info_msg_guarda_error_nproc_1"));
				else {
					ArrCardioversion[] ests = this.cvdao.findByDynamicWhere(" ncv = ?", new Object[] { this.cv.getNcv() });
					if (ests != null && ests.length > 0)
						if (this.cv.getCodigoCardioversion() == null) {
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_guarda_error_nproc_prev"));
							existe = true;
						} else if (!ests[0].getCodigoCardioversion().equals(
								this.cv.getCodigoCardioversion())) {
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
									this.bundle.getString("info_msg_guarda_error_nproc_prev"));
							existe = true;
						}
					if (!existe) {
						if (this.cv.getCodigoCardioversion() != null){
							this.stclindao.update(new SituacionClinicaProcPk(this.stclin.getIdsitclin()), this.stclin);
							this.proc.setFecha(this.cv.getFecha());
							this.procdao.update(this.proc.createPk(), this.proc);
							guardaComponentesSitClin();
							modificaSituacionClinicaGeneral();
							this.cvdao.update(this.cv.createPk(), this.cv);
							//escribeEnClinica(false);
							this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
							logger.info("("+this.usuario+") Registro de Cardioversion actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
						}else {
							SituacionClinicaProcPk stpk = this.stclindao.insert(this.stclin);
							this.stclin.setIdsitclin(stpk.getIdsitclin());
							guardaComponentesSitClin();
							modificaSituacionClinicaGeneral();
							this.cvpk = this.cvdao.insert(this.cv);
							this.cv.setCodigoCardioversion(this.cvpk.getCodigoCardioversion());
							this.cv.setAnocv(1900 + UtilFechas.StringToDate(UtilFechas.getFechaActual()).getYear());
							//escribeEnClinica(true);
							this.proc.setFecha(this.cv.getFecha());
							this.proc.setIdprocedimiento(this.cv.getCodigoCardioversion());
							this.proc.setTipoprocedimiento(1068);
							this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
							this.proc.setIdsitclinica(this.stclin.getIdsitclin());
							this.procpk = this.procdao.insert(this.proc);							
							logger.info("("+this.usuario+") Registro de Cardioversion insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
						}
						//cp.precarga(null);
						this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
					}
				}
			}
			
		} catch (ArrCardioversionDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error intentando guardar los datos: "+ e1.getMessage());
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error intentando guardar los datos: "+ e1.getMessage());
		}
	}

	private void guardaComponentesSitClin() throws Exception {
		sintdao.delete(new SintomasSitclinProcPk(this.stclin.getIdsitclin(), null));
		for (SintomasSitclinProc sint : this.stclin.getSintomas()) {
			if (sint.getIdsintomas() != null && sint.getIdsintomas().length() > 0) {
				sint.setIdsitclin(this.stclin.getIdsitclin());
				sintdao.insert(sint);
			}
		}
		this.stclin.setFecha(this.cv.getFecha());
	}

	public void imprimeInforme(ActionEvent e) {
		if (this.cv.getCodigoCardioversion() == null) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_warn_imprimir"));
		} else {
			ConstructorPdf constructorPDF = new ConstructorPdf();
			String PathFicheroXml = "";
			GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

			try {
				PathFicheroXml = generadorXML.imprimeInformeCV(this.cv,this.cp.pacienteSelect,this.infocentro,this.stclin,this.bundle, this.listacompl);
			} catch (Exception se) {
				logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error generando documento,motivo: "
									+ se.getMessage(),
							"Error generando documento,Motivo: "
									+ se.getMessage());
				} catch (Exception e3) {
				}
			}

			try {
				constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml,"CVARRITMIAS.jasper");
				logger.info("("+this.usuario+") Generación de informe (Cardioversión). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
			} catch (Exception se) {
				logger.error("("+this.usuario+") Error imprimiendo documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error imprimiendo documento,motivo: "
									+ se.getMessage(),
							"Error imprimiendo documento,Motivo: "
									+ se.getMessage());
				} catch (Exception e2) {
				}
			}
		}
	}
	public void eliminarCardioversion(ActionEvent e){
		int auxproc = this.proc.getIdprocedimiento();
		try{
			// Borra en cascada el ECG asociado a la mesa
			this.cvdao.delete(this.cvpk);
			this.procdao.delete(this.procpk);
			this.iniciaCardioversion(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro de Cardioversion eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_borrado_error_exep")+":  "+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido eliminar el registro:  Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
		}
	}

	public void guardaComplicacion(ActionEvent e){
		this.compac.setIdpaciente(this.cp.getPacienteSelect().getCodigo());
		this.compac.setIdprocedimiento(this.proc.getIdprocedimiento());
		this.compac.setTipoprocedimiento(this.proc.getTipoprocedimiento());
		this.compac.setIdrelacion(6);
		cc.addItemComplicacion(this.compac);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacompl.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacompl.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.compac = new ComplicacionesPacientes();
		this.compac.setFechaini(this.cv.getFecha());
		this.compac.setTipo(1);
	}
	
	public void preEditarProc(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		ComplicacionesPacientes aux = this.getListacompl().get(this.bindingComplicacionesProc.getRowIndex());	
		this.currentItemComp.setIdcompac(aux.getIdcompac());
		this.currentItemComp.setIdpaciente(aux.getIdpaciente());
		this.currentItemComp.setTipo(aux.getTipo());
		this.currentItemComp.setTipoprocedimiento(aux.getTipoprocedimiento());
		this.currentItemComp.setIdprocedimiento(aux.getIdprocedimiento());
		this.currentItemComp.setComplicacion(aux.getComplicacion());
		this.currentItemComp.setComplicacion1(aux.getComplicacion1());
		this.currentItemComp.setComplicacionOtra(aux.getComplicacionOtra());
		this.currentItemComp.setIdrelacion(aux.getIdrelacion());
		this.currentItemComp.setIdlugar(aux.getIdlugar());
		this.currentItemComp.setFechaini(aux.getFechaini());
		this.currentItemComp.setFechafin(aux.getFechafin());
		this.currentItemComp.setResuelta(aux.getResuelta());
		this.currentItemComp.setResueltaOtros(aux.getResueltaOtros());
		this.currentItemComp.setTratamiento(aux.getTratamiento());
		this.currentItemComp.setTratamientoDescr(aux.getTratamientoDescr());
		this.currentItemComp.setTratamientoTipo(aux.getTratamientoTipo());
		this.currentItemComp.setIngreso(aux.getIngreso());
		this.currentItemComp.setDescripcion(aux.getDescripcion());
		this.currentItemComp.setFechaProc(aux.getFechaProc());
		this.setEditableProc(true);
	}
	
	public void actualizaItemComplicacion(ActionEvent e){
		cc.editItemComplicacion(this.currentItemComp);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacompl.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacompl.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.currentItemComp = new ComplicacionesPacientes();
	}
	
	public void cancelarItemComplicacion(ActionEvent e){
		this.setEditableProc(false);
	}
	
	public void delItemComplicacion(ActionEvent e){
		Integer pos = this.bindingComplicacionesProc.getRowIndex();
		ComplicacionesPacientes item = this.listacompl.get(pos);
		cc.delItemComplicacion(item);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacompl.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacompl.add(cpac);
	}
	
	public void limpiarComp(ActionEvent e){
		this.compac = new ComplicacionesPacientes();
		this.compac.setFechaini(this.cv.getFecha());
		this.compac.setTipo(1);
	}
	
	public void sortHistorico(final String columna, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				ArrCardioversion c1 = (ArrCardioversion) o1;
				ArrCardioversion c2 = (ArrCardioversion) o2;
				try {
					if (columna == null) {
						return 0;
					}
					if (columna.equals("codigo")) {
						return ascending ? c1.getCodigoCardioversion()
								.compareTo(c2.getCodigoCardioversion()) : c2
								.getCodigoCardioversion().compareTo(
										c1.getCodigoCardioversion());
					} else if (columna.equals("fecha")) {
						return ascending ? c1.getFecha().compareTo(
								c2.getFecha()) : c2.getFecha().compareTo(
								c1.getFecha());
					} else
						return 0;
				} catch (Exception ex) {
					return 0;
				}
			}
		};
		Collections.sort(this.cvs, comparator);
	}

	public ArrCardioversion getCv() {
		return cv;
	}

	public void setCv(ArrCardioversion cv) {
		this.cv = cv;
	}

	public ArrayList<ArrCardioversion> getCvs() {
		sortHistorico(this.columna, this.ascendente);
		return cvs;
	}

	public void setCvs(ArrayList<ArrCardioversion> cvs) {
		this.cvs = cvs;
	}

	public HtmlDataTable getBindingHistorico() {
		return bindingHistorico;
	}

	public void setBindingHistorico(HtmlDataTable bindingHistorico) {
		this.bindingHistorico = bindingHistorico;
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

	public ArrayList<EpisodioDto> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(ArrayList<EpisodioDto> episodios) {
		this.episodios = episodios;
	}

	public HtmlDataTable getBindingepi() {
		return bindingepi;
	}

	public void setBindingepi(HtmlDataTable bindingepi) {
		this.bindingepi = bindingepi;
	}

	public PacienteDao getPacientedao() {
		return pacientedao;
	}

	public void setPacientedao(PacienteDao pacientedao) {
		this.pacientedao = pacientedao;
	}
	
	static private String getRemoteFileName(long handle) {

		String remotePath = null;
		String remoteFileName = null;

		remotePath = "00000000" + Long.toHexString(handle);
		remotePath = remotePath.substring(remotePath.length() - 8, remotePath.length());
		remoteFileName = remotePath.substring(6, 8);

		return remoteFileName.toUpperCase();
	}

	static private String getRemotePath(long handle) {

		String remotePath = null;

		remotePath = "00000000" + Long.toHexString(handle);
		remotePath = remotePath.substring(remotePath.length() - 8, remotePath.length());
		remotePath = remotePath.substring(0, 2) + "/"+ remotePath.substring(2, 4) + "/" + remotePath.substring(4, 6);

		return remotePath.toUpperCase();
	}

	public void escribeEnClinica(boolean nuevo) throws Exception {
		DocHl7Dto consultaNueva = new DocHl7Dto();
		String path = printFichero();
		if (nuevo) {
			Integer numHandle;
			try {
				numHandle = UtilesTerminalSsh.getSiguienteID("SGHANINFEXT",
						true);
			} catch (SshException ex) {
				numHandle = -1;
			}
			consultaNueva.setHandle(numHandle);

			Integer numDocHl7Informes;
			try {
				numDocHl7Informes = UtilesTerminalSsh.getSiguienteID(
						"SGCODINFEXT", true);
			} catch (SshException ex) {
				numDocHl7Informes = -1;
			}
			consultaNueva.setIdinfor(numDocHl7Informes);
			consultaNueva.setIdinforext("" + this.cv.getNcv());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.cv.getEpisodio() != null && this.cv.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.cv.getEpisodio());
			else
				consultaNueva.setEpisodio("0");
			UsuarioDao usDao = new UsuarioDao();
        	SesionUsuarioDto ses = new SesionUsuarioDto();
        	ses.setLogin(this.usuario);
			String doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
			consultaNueva.setRedactor(doctor);
			consultaNueva.setResponprime(doctor);
			consultaNueva.setServicio("QCAR");
			Timestamp fecT = UtilFechas.dateToTimestamp(this.cv.getFecha());
			consultaNueva.setFcreacion(fecT);
			Time t = new Time(fecT.getTime());
			consultaNueva.setHcreacion(t);
			consultaNueva.setIdtipodoc(55);
			consultaNueva.setIdsubti("ARR02");
			enviaInformeFTP(consultaNueva, true, path);

		} else {
			Timestamp fecT = UtilFechas.dateToTimestamp(this.cv.getFecha());
			Time t = new Time(fecT.getTime());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.cv.getEpisodio() != null && this.cv.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.cv.getEpisodio());
			else
				consultaNueva.setEpisodio("0");
			UsuarioDao usDao = new UsuarioDao();
        	SesionUsuarioDto ses = new SesionUsuarioDto();
        	ses.setLogin(this.usuario);
			String doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
			consultaNueva.setRedactor(doctor);
			consultaNueva.setResponprime(doctor);
			consultaNueva.setResponsegun(doctor);
			consultaNueva.setServicio("QCAR");
			consultaNueva.setIdinforext("" + this.cv.getNcv());
			consultaNueva.setIdsubti("ARR02");
			consultaNueva.setIdtipodoc(55);
			consultaNueva.setFmodificacion(fecT);
			consultaNueva.setHmodificacion(t);
			enviaInformeFTP(consultaNueva, false, path);
		}
	}
	
	public void enviaInformeFTP(DocHl7Dto item, boolean nuevo, String path) {
		logInfo("Inicio de ControlConsulta.enviaInformeFTP");
		boolean seguir = true;
		try {
			if (nuevo) {
				DocHL7InformesDao docHL7InformesDao = new DocHL7InformesDao(this.usuario);
				docHL7InformesDao.añadirDocHL7Informes(item);
			} else {
				try{
					DocHL7InformesDao docHL7InformesDao = new DocHL7InformesDao(this.usuario);
					item.setHandle(new Integer(docHL7InformesDao
						.modificarDocHL7InformesIdExt(item)));
				}catch (Exception e) {
					//escribeEnClinica(true);
					seguir = false;
				}
			}

			if(seguir){
				String pathFTP = "";

				pathFTP = "/" + getRemotePath(item.getHandle()) + "/"
					+ getRemoteFileName(item.getHandle());

				if (GestorFTPInforme.enviarFicheroFTP(path, pathFTP) == 1) {
					File ficheroLocal = new File(path);
					ficheroLocal.delete();
				}
			}

		} catch (Exception ex) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error guardando informe. Motivo: "
						+ ex.getMessage());
		}
		logInfo("Fin de ControlConsulta.enviaInformeFTP");
	}
	
	public String printFichero() {
		String path = "";
		if (this.cv.getCodigoCardioversion() == null) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,"Guarde los datos para poder imprimirlos");
		} else {
			ConstructorPdf constructorPDF = new ConstructorPdf();
			String PathFicheroXml = "";
			GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

			try {
				PathFicheroXml = generadorXML.imprimeInformeCV(this.cv,
						this.cp.pacienteSelect,this.infocentro,this.stclin,this.bundle,this.listacompl);
			} catch (Exception se) {
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error generando documento,motivo: "+ se.getMessage(),
							"Error generando documento,Motivo: "+ se.getMessage());
				} catch (Exception e3) {
				}
			}

			try {
				path = constructorPDF.generarArchivoPdfFile(FacesContext.getCurrentInstance(), 
						PathFicheroXml, "CVARRITMIAS.jasper");
			} catch (Exception se) {
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error imprimiendo documento,motivo: "+ se.getMessage(),
							"Error imprimiendo documento,Motivo: "+ se.getMessage());
				} catch (Exception e2) {
				}
			}
		}
		return path;
	}

	public void lecturaProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
		p.load(is);
		is.close();
		this.infocentro = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
					p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"));
	}

	/**
	 * Metodo para precargar situacion clinica general en el bloque de situacion clinica de procedimiento
	 * Solo se invocara cuando se haga un nuevo registro
	 */
	private void cargaSituacionClinica(){
		try {
			SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
			this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());			
			this.stclin.setFevi(sgen.getFevi()!=null?sgen.getFevi():null);
			this.stclin.setFuncionventricular(sgen.getFuncionventricular()!=null?sgen.getFuncionventricular():null);
			this.stclin.setNyha(sgen.getNyha()!=null?sgen.getNyha():null);
			this.stclin.setIc(sgen.getNyha()!=null&&sgen.getNyha()>0?true:false);
			this.sgen.setIc(sgen.getNyha()!=null&&sgen.getNyha()>0?true:false);
			this.stclin.setCardiop(sgen.getCardiopatia()!=null?true:false);
			this.sgen.setCardiop(sgen.getCardiopatia()!=null?true:false);
			this.stclin.setCardiopatia(sgen.getCardiopatia()!=null?sgen.getCardiopatia():null);
			this.stclin.setOtra(sgen.getOtra()!=null?sgen.getOtra():null);
			this.stclin.setAevolucion(sgen.getAevolucion()!=null?sgen.getAevolucion():null);
			this.stclin.setRevasc(sgen.getRevasc()!=null?sgen.getRevasc():null);
			this.stclin.setRevascularizacion((sgen.getRevasc()!=null && sgen.getRevasc()==1)?true:false);
			this.sgen.setRevascularizacion((sgen.getRevasc()!=null && sgen.getRevasc()==1)?true:false);
			this.stclin.setInfprevio(sgen.getInfprevio()!=null?sgen.getInfprevio():null);
			this.stclin.setInfartoprev((sgen.getInfprevio()!=null && sgen.getInfprevio()==1)?true:false);
			this.sgen.setInfartoprev((sgen.getInfprevio()!=null && sgen.getInfprevio()==1)?true:false);
			this.stclin.setAnio(sgen.getAnio()!=null?sgen.getAnio():null);
			this.stclin.setLocalizacion(sgen.getLocalizacion()!=null?sgen.getLocalizacion():null);
			this.stclin.setArritmias(sgen.getArritmias()!=null?sgen.getArritmias():null);
			this.stclin.setAvent(sgen.getArritmias()!=null&&sgen.getArritmias()>0?true:false);
			this.sgen.setAvent(sgen.getArritmias()!=null&&sgen.getArritmias()>0?true:false);
			this.stclin.setEef(sgen.getEef()!=null?sgen.getEef():null);
			this.stclin.setEefprev((sgen.getEef()!=null && sgen.getEef()>0)?true:false);
			this.sgen.setEefprev((sgen.getEef()!=null && sgen.getEef()>0)?true:false);
			this.stclin.setInsrenal(sgen.getInsrenal()!=null?sgen.getInsrenal():null);
			this.stclin.setAnteinsrenal(sgen.getInsrenal()!=null&&sgen.getInsrenal()==1?true:false);
			this.sgen.setAnteinsrenal(sgen.getInsrenal()!=null&&sgen.getInsrenal()==1?true:false);
			this.stclin.setAntfa(sgen.getAntfa()!=null?sgen.getAntfa():null);
			this.stclin.setAntefa(sgen.getAntfa()!=null&&sgen.getAntfa()==1?true:false);
			this.sgen.setAntefa(sgen.getAntfa()!=null&&sgen.getAntfa()==1?true:false);
			this.stclin.setDiabetes(sgen.getDiabetes()!=null?sgen.getDiabetes():null);
			this.stclin.setAntediab(sgen.getDiabetes()!=null&&sgen.getDiabetes()==1?true:false);
			this.sgen.setAntediab(sgen.getDiabetes()!=null&&sgen.getDiabetes()==1?true:false);
			this.stclin.setHta(sgen.getHta()!=null?sgen.getHta():null);
			this.stclin.setAnteHTA(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.sgen.setAnteHTA(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.stclin.setHipercolest(sgen.getHta()!=null?sgen.getHta():null);
			this.stclin.setAntehipercol(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.sgen.setAntehipercol(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.stclin.setMuertesubita(sgen.getMuertesubita()!=null?sgen.getMuertesubita():null);
			this.stclin.setAntefam(sgen.getMuertesubita()!=null&&sgen.getMuertesubita()==1?true:false);
			this.sgen.setAntefam(sgen.getMuertesubita()!=null&&sgen.getMuertesubita()==1?true:false);
			this.stclin.setTabaquismo(sgen.getTabaquismo()!=null?sgen.getTabaquismo():null);
			this.stclin.setAntetabaq(sgen.getTabaquismo()!=null&&sgen.getTabaquismo()==1?true:false);
			this.sgen.setAntetabaq(sgen.getTabaquismo()!=null&&sgen.getTabaquismo()==1?true:false);
			this.stclin.setDislipemia(sgen.getDislipemia()!=null?sgen.getDislipemia():null);
			this.stclin.setAnteDislipemia(sgen.getDislipemia()!=null&&sgen.getDislipemia()==1?true:false);
			this.sgen.setAnteDislipemia(sgen.getDislipemia()!=null&&sgen.getDislipemia()==1?true:false);
			this.stclin.setAcv(sgen.getAcv()!=null?sgen.getAcv():null);
			this.stclin.setAnteacv(sgen.getAcv()!=null&&sgen.getAcv()==1?true:false);
			this.sgen.setAnteacv(sgen.getAcv()!=null&&sgen.getAcv()==1?true:false);
			this.stclin.setTrasplantecardiaco(sgen.getTrasplantecardiaco()!=null?sgen.getTrasplantecardiaco():null);
			this.stclin.setAnteTrasplanteCardiaco(sgen.getTrasplantecardiaco()!=null&&sgen.getTrasplantecardiaco()==1?true:false);
			this.sgen.setAnteTrasplanteCardiaco(sgen.getTrasplantecardiaco()!=null&&sgen.getTrasplantecardiaco()==1?true:false);
			this.stclin.setAit(sgen.getAit()!=null?sgen.getAit():null);
			this.stclin.setAnteAIT(sgen.getAit()!=null&&sgen.getAit()==1?true:false);
			this.sgen.setAnteAIT(sgen.getAit()!=null&&sgen.getAit()==1?true:false);
			this.stclin.setEpoc(sgen.getEpoc()!=null?sgen.getEpoc():null);
			this.stclin.setAnteEPOC(sgen.getEpoc()!=null&&sgen.getEpoc()==1?true:false);
			this.sgen.setAnteEPOC(sgen.getEpoc()!=null&&sgen.getEpoc()==1?true:false);
			this.stclin.setSahs(sgen.getSahs()!=null?sgen.getSahs():null);
			this.stclin.setAnteSAHS(sgen.getSahs()!=null&&sgen.getSahs()==1?true:false);
			this.sgen.setAnteSAHS(sgen.getSahs()!=null&&sgen.getSahs()==1?true:false);
			this.stclin.setTiposahs(sgen.getTiposahs()!=null?sgen.getTiposahs():null);
			this.stclin.setAhi(sgen.getAhi()!=null?sgen.getAhi():null);
			this.stclin.setCpap(sgen.getCpap()!=null?sgen.getCpap():null);
			this.stclin.setAnteCPAP(sgen.getCpap()!=null&&sgen.getCpap()==1?true:false);
			this.sgen.setAnteCPAP(sgen.getCpap()!=null&&sgen.getCpap()==1?true:false);
			this.stclin.setNeoplasia(sgen.getNeoplasia()!=null?sgen.getNeoplasia():null);
			this.stclin.setAnteNeoplasia(sgen.getNeoplasia()!=null&&sgen.getNeoplasia()==1?true:false);
			this.sgen.setAnteNeoplasia(sgen.getNeoplasia()!=null&&sgen.getNeoplasia()==1?true:false);
			this.stclin.setTiponeoplasia(sgen.getTiponeoplasia()!=null?sgen.getTiponeoplasia():null);
			this.stclin.setAfectiroidea(sgen.getAfectiroidea()!=null?sgen.getAfectiroidea():null);
			this.stclin.setNeuromediados(sgen.getNeuromediados()!=null?sgen.getNeuromediados():null);
			this.stclin.setSincope(sgen.getSincope()!=null?sgen.getSincope():null);
			this.stclin.setAnteSincope(sgen.getSincope()!=null&&sgen.getSincope()==1?true:false);
			this.sgen.setAnteSincope(sgen.getSincope()!=null&&sgen.getSincope()==1?true:false);
			this.stclin.setParadacardiaca(sgen.getParadacardiaca()!=null?sgen.getParadacardiaca():null);
			this.stclin.setAnteParadaCardiaca(sgen.getParadacardiaca()!=null&&sgen.getParadacardiaca()==1?true:false);
			this.sgen.setAnteParadaCardiaca(sgen.getParadacardiaca()!=null&&sgen.getParadacardiaca()==1?true:false);
			this.stclin.setEnfarterios(sgen.getEnfart()!=null&&sgen.getEnfart()==1?true:false);
			this.stclin.setAi(sgen.getAi()!=null?sgen.getAi():null);
			this.stclin.setAi2(sgen.getAi2()!=null?sgen.getAi2():null);
			this.stclin.setAnteflutter(sgen.getFlutter()!=null&&sgen.getFlutter()==1?true:false);
			this.stclin.setAlergias(sgen.getAlergias()!=null?sgen.getAlergias():null);
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
				if(this.sgen.getFevi()!=null && (!(this.sgen.getFevi().equals(this.stclin.getFevi())) 
						|| !(this.sgen.getFuncionventricular().equals(this.stclin.getFuncionventricular())))){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFevi(this.stclin.getFevi());
					this.sgen.setFuncionventricular(this.stclin.getFuncionventricular());
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
	
	private void cargaAntecedentes() {
		this.stclin.setAnteinsrenal((this.stclin.getInsrenal() != null)
				&& (this.stclin.getInsrenal() == 1) ? true : false);
		this.stclin.setAntefa((this.stclin.getAntfa() != null)
				&& (this.stclin.getAntfa() == 1) ? true : false);
		this.stclin.setAntediab((this.stclin.getDiabetes() != null)
				&& (this.stclin.getDiabetes() == 1) ? true : false);
		this.stclin.setAntehipertens((this.stclin.getHipertension() != null)
				&& (this.stclin.getHipertension() == 1) ? true : false);
		this.stclin.setAnteHTA((this.stclin.getHta() != null)
				&& (this.stclin.getHta() == 1) ? true : false);
		this.stclin.setAntefam((this.stclin.getMuertesubita() != null)
				&& (this.stclin.getMuertesubita() == 1) ? true : false);
		this.stclin.setAntetabaq((this.stclin.getTabaquismo() != null)
				&& (this.stclin.getTabaquismo() == 1) ? true : false);
		this.stclin.setAntehipercol((this.stclin.getHipercolest() != null)
				&& (this.stclin.getHipercolest() == 1) ? true : false);
		this.stclin.setAnteacv((this.stclin.getAcv() != null)
				&& (this.stclin.getAcv() == 1) ? true : false);
		this.stclin.setAnteTrasplanteCardiaco((this.stclin.getTrasplantecardiaco() != null)
				&& (this.stclin.getTrasplantecardiaco() == 1) ? true : false);
		this.stclin.setAnteAIT((this.stclin.getAit() != null)
				&& (this.stclin.getAit() == 1) ? true : false);
		this.stclin.setAnteEPOC((this.stclin.getEpoc() != null)
				&& (this.stclin.getEpoc() == 1) ? true : false);
		this.stclin.setAnteSAHS((this.stclin.getSahs() != null)
				&& (this.stclin.getSahs() == 1) ? true : false);
		this.stclin.setAnteCPAP((this.stclin.getCpap() != null)
				&& (this.stclin.getCpap() == 1) ? true : false);
		this.stclin.setAnteNeoplasia((this.stclin.getNeoplasia() != null)
				&& (this.stclin.getNeoplasia() == 1) ? true : false);	
		this.stclin.setAnteSincope((this.stclin.getSincope() != null)
				&& (this.stclin.getSincope() == 1) ? true : false);
		this.stclin.setAnteParadaCardiaca((this.stclin.getParadacardiaca() != null)
				&& (this.stclin.getParadacardiaca() == 1) ? true : false);
		this.stclin.setEnfarterios((this.stclin.getEnfart()!=null)
				&&(this.stclin.getEnfart()==1) ? true:false);
		this.stclin.setAnteflutter(this.stclin.getFlutter()!=null && this.stclin.getFlutter()==1?true:false);
	}
	
	private void cargaComponentes() {
		try {	
			// 2. Recuperar Situacion Clinica
			this.stclin = this.stclindao.findByPrimaryKey(this.proc.getIdsitclinica());
			// 2.1 Sintomas
			SintomasSitclinProc[] sints = sintdao.findWhereIdsitclinEquals(this.proc.getIdsitclinica());
			ArrayList<SintomasSitclinProc> sintarray = new ArrayList<SintomasSitclinProc>();
			for (SintomasSitclinProc s : sints)
				sintarray.add(s);
			this.stclin.setSintomas(sintarray);
			// 2.3 Precarga IC si existe
			this.stclin.setIc(this.stclin.getNyha()!= null?true:false);
			// 2.4 Cardiopatia
			this.stclin.setCardiop(this.stclin.getCardiopatia()!=null?true:false);
			// 2.4 Cardiopatia Revascularizacion
			this.stclin.setRevascularizacion(this.stclin.getRevasc()!= null
					&& this.stclin.getRevasc()==1?true:false);
			// 2.5 Cardiopatia Infarto Previo
			this.stclin.setInfartoprev(this.stclin.getInfprevio()!=null
					&& this.stclin.getInfprevio()== 1?true:false);
			// 2.6 Antecedentes - Arritmias Ventriculares
			this.stclin.setAvent(this.stclin.getArritmias()!=null
					&& this.stclin.getArritmias()>= 1?true:false);
			// 2.7 Antecedentes - EEF Previo
			this.stclin.setEefprev(this.stclin.getEef()!= null
					&& this.stclin.getEef()>=1?true:false);
			// 2.8 Antecedentes booleanos
			cargaAntecedentes();
			// 3. Complicaciones procedimiento
			cc.obtenerComplicacionesPacienteProc(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
			for(ComplicacionesPacientes cpac:cc.getListacompacproc())
				this.listacompl.add(cpac);
			// 4. Inicializacion de complicaciones
			this.compac.setFechaini(this.cv.getFecha());
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_sitclin_rec")+": "+ e.getMessage());
			logger.error("("+this.usuario+") Error al obtener datos de procedimiento: " + e.getMessage(),e);
		}
	}

	/******************************************************************
	 * 					Controles de formulario
	 * ****************************************************************
	 */
	public void addSintoma(ActionEvent e) {
		this.stclin.getSintomas().add(new SintomasSitclinProc());
	}

	public void delSintoma(ActionEvent e) {
		this.stclin.getSintomas().remove(this.bindingSintomas.getRowIndex());
	}

	public void controlSintomas(ActionEvent e){
		int dup=0;
		for(SintomasSitclinProc s:this.stclin.getSintomas()){
			if(s.getIdsintomas()!=null 
					&& s.getIdsintomas().equals(this.stclin.getSintomas().get(this.bindingSintomas.getRowIndex()).getIdsintomas()))
				dup++;						
			if(dup>1){
				this.stclin.getSintomas().remove(this.bindingSintomas.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sitclin_sintoma_dup"));
				break;
			}
		}
	}
	
	public void ordenaFEVI(ActionEvent e){
		try{
			int fevi = Integer.valueOf(this.stclin.getFevi());
			if(fevi>50)
				this.stclin.setFuncionventricular(1);
			else if(fevi>=41 && fevi<=50)
				this.stclin.setFuncionventricular(2);
			else if(fevi>=36 && fevi<=40)
				this.stclin.setFuncionventricular(3);
			else if(fevi>=31 && fevi<=35)
				this.stclin.setFuncionventricular(4);
			else
				this.stclin.setFuncionventricular(5);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_warn_sitclin_fe")+": " + e1.getMessage());
			this.stclin.setFevi(null);
		}	
	}

	public void resetFEVI(ActionEvent e){
		this.stclin.setFevi(null);
		if((this.stclin.getFuncionventricular()==0 || this.stclin.getFuncionventricular()==6))
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sitclin_fevi"));
	}
	
	public void cambiaCardiopatiaEtiologia(ActionEvent e) {
		if (!(this.getStclin().getCardiopatia().equals(923))) {
			if (this.getStclin().getCardiopatia().equals(913))
				this.getStclin().setEtiologia(891);
			else if (this.getStclin().getCardiopatia().equals(914))
				this.getStclin().setEtiologia(895);
			else if (this.getStclin().getCardiopatia().equals(915))
				this.getStclin().setEtiologia(907);
			else if (this.getStclin().getCardiopatia().equals(916))
				this.getStclin().setEtiologia(906);
			else if (this.getStclin().getCardiopatia().equals(917))
				this.getStclin().setEtiologia(891);
			else if (this.getStclin().getCardiopatia().equals(918))
				this.getStclin().setEtiologia(909);
			else if (this.getStclin().getCardiopatia().equals(919))
				this.getStclin().setEtiologia(897);
			else if (this.getStclin().getCardiopatia().equals(920)
					|| this.getStclin().getCardiopatia().equals(921)
					|| this.getStclin().getCardiopatia().equals(922))
				this.getStclin().setEtiologia(892);
			else
				this.getStclin().setEtiologia(891);
			this.getStclin().setOtra("");	
		}
		this.modsitclin = true;
		this.sgen.setCardiop(this.stclin.isCardiop());
		this.sgen.setCardiopatia(this.stclin.getCardiopatia());
		this.sgen.setOtra(this.stclin.getOtra());
	}

	public void reVasc(ActionEvent e) {
		this.stclin.setRevasc((short) (this.stclin.isRevascularizacion() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setRevasc(this.stclin.getRevasc());
		this.sgen.setRevascularizacion(this.stclin.isRevascularizacion());
	}

	public void infPrevio(ActionEvent e) {
		this.stclin.setInfprevio((short) (this.stclin.isInfartoprev() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setInfprevio(this.stclin.getInfprevio());
		this.sgen.setInfartoprev(this.stclin.isInfartoprev());
		// Actualizacion de valores de infarto previo si false
		if (!(this.stclin.isInfartoprev())) {
			this.stclin.setAnio(null);
			this.sgen.setAnio(this.stclin.getAnio());
			this.stclin.setLocalizacion(null);
			this.sgen.setLocalizacion(this.stclin.getLocalizacion());
		}		
	}

	public void cambiaAnosEvolucion(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAevolucion(this.stclin.getAevolucion());
	}

	public void cambiaAnosInfPrevio(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAnio(this.stclin.getAnio());
	}

	public void cambiaLocalizacion(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setLocalizacion(this.stclin.getLocalizacion());
	}

	public void anteInsRenal(ActionEvent e) {
		this.stclin.setInsrenal((short) (this.stclin.isAnteinsrenal() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setInsrenal(this.stclin.getInsrenal());
		this.sgen.setAnteinsrenal(this.stclin.isAnteinsrenal());
	}

	public void anteFA(ActionEvent e) {
		this.stclin.setAntfa((short) (this.stclin.isAntefa() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAntfa(this.stclin.getAntfa());
		this.sgen.setAntefa(this.stclin.isAntefa());
	}

	public void anteFlutter(ActionEvent e) {
		this.stclin.setFlutter((short) (this.stclin.isAnteflutter() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setFlutter(this.stclin.getFlutter());
		this.sgen.setAnteflutter(this.stclin.isAnteflutter());
	}

	public void anteDiab(ActionEvent e) {
		this.stclin.setDiabetes((short) (this.stclin.isAntediab() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setDiabetes(this.stclin.getDiabetes());
		this.sgen.setAntediab(this.stclin.isAntediab());
	}

	public void anteHipertens(ActionEvent e) {
		this.stclin.setHipertension((short) (this.stclin.isAnteHTA() ? 1 : 0));
		this.stclin.setHta((short) (this.stclin.isAnteHTA() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setHta(this.stclin.getHipertension());
		this.sgen.setAnteHTA(this.stclin.isAnteHTA());
	}

	public void anteFam(ActionEvent e) {
		this.stclin.setMuertesubita((short) (this.stclin.isAntefam() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setMuertesubita(this.stclin.getMuertesubita());
		this.sgen.setAntefam(this.stclin.isAntefam());
	}

	public void anteTabaq(ActionEvent e) {
		this.stclin.setTabaquismo((short) (this.stclin.isAntetabaq() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setTabaquismo(this.stclin.getTabaquismo());
		this.sgen.setAntetabaq(this.stclin.isAntetabaq());
	}

	public void anteHipercoles(ActionEvent e) {
		this.stclin.setHipercolest((short) (this.stclin.isAntehipercol() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setDislipemia(this.stclin.getHipercolest());
		this.sgen.setAnteDislipemia(this.stclin.isAnteDislipemia());
	}

	public void anteACV(ActionEvent e) {
		this.stclin.setAcv((short) (this.stclin.isAnteacv() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAcv(this.stclin.getAcv());
		this.sgen.setAnteacv(this.stclin.isAnteacv());
	}

	public void cambiaAIT(ActionEvent e) {
		this.stclin.setAit((short) (this.stclin.isAnteAIT() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAit(this.stclin.getAit());
		this.sgen.setAnteAIT(this.stclin.isAnteAIT());
	}

	public void cambiaEPOC(ActionEvent e) {
		this.stclin.setEpoc((short) (this.stclin.isAnteEPOC() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setEpoc(this.stclin.getEpoc());
		this.sgen.setAnteEPOC(this.stclin.isAnteEPOC());
	}

	public void cambiaSAHS(ActionEvent e) {
		this.stclin.setSahs((short) (this.stclin.isAnteSAHS() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setSahs(this.stclin.getSahs());
		this.sgen.setAnteSAHS(this.stclin.isAnteSAHS());
		if(!(this.stclin.isAnteSAHS())){
			this.stclin.setTiposahs(null);
			this.sgen.setTiposahs(this.stclin.getTiposahs());
			this.stclin.setCpap(null);
			this.sgen.setCpap(this.stclin.getCpap());
			this.stclin.setAnteCPAP(false);			
			this.stclin.setAhi(null);
			this.sgen.setAhi(this.stclin.getAhi());
		}
		this.sgen.setAnteCPAP(this.stclin.isAnteCPAP());
	}

	public void cambiaTipoSAHS(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setTiposahs(this.stclin.getTiposahs());
	}

	public void cambiaNeoplasia(ActionEvent e) {
		this.stclin.setNeoplasia((short) (this.stclin.isAnteNeoplasia() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setNeoplasia(this.stclin.getNeoplasia());
		this.sgen.setAnteNeoplasia(this.stclin.isAnteNeoplasia());
		if(!(this.stclin.isAnteNeoplasia())){
			this.stclin.setTiponeoplasia(null);
			this.sgen.setTiponeoplasia(this.stclin.getTiponeoplasia());
		}		
	}

	public void cambiaTipoNeoplasia(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setTiponeoplasia(this.stclin.getTiponeoplasia());
	}

	public void cambiaAlergias(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAlergias(this.stclin.getAlergias());
	}

	public void cambiaCPAP(ActionEvent e) {
		this.stclin.setCpap((short) (this.stclin.isAnteCPAP() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setCpap(this.stclin.getCpap());
		this.sgen.setAnteCPAP(this.stclin.isAnteCPAP());
	}

	public void anteTCardiaco(ActionEvent e) {
		this.stclin.setTrasplantecardiaco((short) (this.stclin.isAnteTrasplanteCardiaco() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setTrasplantecardiaco(this.stclin.getTrasplantecardiaco());
		this.sgen.setAnteTrasplanteCardiaco(this.stclin.isAnteTrasplanteCardiaco());
	}

	public void cambiaSincope(ActionEvent e){
		this.stclin.setSincope((short) (this.stclin.isAnteSincope()?1:0));
		this.modsitclin = true;
		this.sgen.setSincope(this.stclin.getSincope());
		this.sgen.setAnteSincope(this.stclin.isAnteSincope());
	}

	public void cambiaParadaCardiaca(ActionEvent e){
		this.stclin.setParadacardiaca((short)(this.stclin.isAnteParadaCardiaca()?1:0));
		this.modsitclin = true;
		this.sgen.setParadacardiaca(this.stclin.getParadacardiaca());
		this.sgen.setAnteParadaCardiaca(this.stclin.isAnteParadaCardiaca());
	}

	public void cambiaArritmiasVentriculares(ActionEvent e){
		if(!this.stclin.isAvent()){
			this.stclin.setArritmias(null);
			this.sgen.setArritmias(this.stclin.getArritmias());	
		}	
		this.sgen.setAvent(this.stclin.isAvent());
		this.modsitclin = true;
	}

	public void cambiaArrVent(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setArritmias(this.stclin.getArritmias());
	}

	public void cambiaEefPrevio(ActionEvent e){
		if(!this.stclin.isEefprev()){
			this.stclin.setEef(null);
			this.sgen.setEef(this.stclin.getEef());			
		}
		this.sgen.setEefprev(this.stclin.isEefprev());
		this.modsitclin = true;
	}

	public void cambiaEEF(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setEef(this.stclin.getEef());
	}

	public void cambiaIC(ActionEvent e){
		if(!(this.stclin.isIc())){
			this.stclin.setNyha(null);
			this.sgen.setNyha(this.stclin.getNyha());			
		}	
		this.sgen.setIc(this.stclin.isIc());
		this.modsitclin = true;
	}

	public void cambiaNYHA(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setNyha(this.stclin.getNyha());
	}

	public void cambiaAfecTiroidea(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAfectiroidea(this.stclin.getAfectiroidea());
	}

	public void cambiaNeurologicos(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setNeuromediados(this.stclin.getNeuromediados());
	}

	public void cambiaEnfArt(ActionEvent e){
		this.stclin.setEnfart(this.stclin.isEnfarterios()?1:0);
		this.modsitclin = true;
		this.sgen.setEnfart(this.stclin.getEnfart());
	}

	public void cambiaAI(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAi(this.stclin.getAi());
	}

	public void cambiaAI2(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAi2(this.stclin.getAi2());
	}

	/*****************************************
	 * 			GET / SET
	 ******************************************/
	public HtmlDataTable getBindingHistoricoCv() {
		return bindingHistoricoCv;
	}

	public void setBindingHistoricoCv(HtmlDataTable bindingHistoricoCv) {
		this.bindingHistoricoCv = bindingHistoricoCv;
	}

	public ArrayList<Procedimiento> getProcs() {
		return procs;
	}

	public void setProcs(ArrayList<Procedimiento> procs) {
		this.procs = procs;
	}
	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public SituacionClinicaProc getStclin() {
		return stclin;
	}

	public void setStclin(SituacionClinicaProc stclin) {
		this.stclin = stclin;
	}

	public HtmlDataTable getBindingSintomas() {
		return bindingSintomas;
	}

	public void setBindingSintomas(HtmlDataTable bindingSintomas) {
		this.bindingSintomas = bindingSintomas;
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
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.ritmos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getRitmostv() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.ritmostv)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getRitmosfa() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.ritmosfa)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getRitmossa() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.ritmossa)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getConducciones() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.conducciones)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getConduccionavotros() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.conduccionavotros)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getQrs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.qrs)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getQrsotros() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "NO ESPECIFICADO"));
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

	public ComplicacionesPacientes getCompac() {
		return compac;
	}

	public void setCompac(ComplicacionesPacientes compac) {
		this.compac = compac;
	}

	public ComplicacionesPacientes getCurrentItemComp() {
		return currentItemComp;
	}

	public void setCurrentItemComp(ComplicacionesPacientes currentItemComp) {
		this.currentItemComp = currentItemComp;
	}

	public HtmlDataTable getBindingComplicacionesProc() {
		return bindingComplicacionesProc;
	}

	public void setBindingComplicacionesProc(HtmlDataTable bindingComplicacionesProc) {
		this.bindingComplicacionesProc = bindingComplicacionesProc;
	}

	public ArrayList<ComplicacionesPacientes> getListacompl() {
		return listacompl;
	}

	public void setListacompl(ArrayList<ComplicacionesPacientes> listacompl) {
		this.listacompl = listacompl;
	}

	public boolean isEditableProc() {
		return editableProc;
	}

	public void setEditableProc(boolean editableProc) {
		this.editableProc = editableProc;
	}
}

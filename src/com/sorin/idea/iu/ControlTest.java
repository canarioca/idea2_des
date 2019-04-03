package com.sorin.idea.iu;

import java.io.File;
import java.io.InputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;

import com.sorin.idea.dao.ArrEnfActDao;
import com.sorin.idea.dao.ArrEnfDao;
import com.sorin.idea.dao.ArrEnfIntroductoresDao;
import com.sorin.idea.dao.ArrEstudioCateterDao;
import com.sorin.idea.dao.ArrEstudioDao;
import com.sorin.idea.dao.ArrListaEsperaDao;
import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ArrTestAtpDao;
import com.sorin.idea.dao.ArrTestAtpEcgDao;
import com.sorin.idea.dao.ArrTestEpiDao;
import com.sorin.idea.dao.ArrTestEpiEcgDao;
import com.sorin.idea.dao.ArrTestFleDao;
import com.sorin.idea.dao.ArrTestFleEcgDao;
import com.sorin.idea.dao.DocHL7InformesDao;
import com.sorin.idea.dao.EpisodioDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.UsuarioDao;
import com.sorin.idea.dto.ArrEnf;
import com.sorin.idea.dto.ArrEnfAct;
import com.sorin.idea.dto.ArrEnfIntroductores;
import com.sorin.idea.dto.ArrEnfPk;
import com.sorin.idea.dto.ArrEstudio;
import com.sorin.idea.dto.ArrEstudioCateter;
import com.sorin.idea.dto.ArrEstudioCateterPk;
import com.sorin.idea.dto.ArrListaEspera;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrTestAtp;
import com.sorin.idea.dto.ArrTestAtpPk;
import com.sorin.idea.dto.ArrTestEpi;
import com.sorin.idea.dto.ArrTestEpiPk;
import com.sorin.idea.dto.ArrTestFle;
import com.sorin.idea.dto.ArrTestFlePk;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.exceptions.ArrEnfActDaoException;
import com.sorin.idea.exceptions.ArrEnfDaoException;
import com.sorin.idea.exceptions.ArrEnfIntroductoresDaoException;
import com.sorin.idea.exceptions.ArrEstudioCateterDaoException;
import com.sorin.idea.exceptions.ArrEstudioDaoException;
import com.sorin.idea.exceptions.ArrMaestrasDaoException;
import com.sorin.idea.exceptions.ArrTestAtpDaoException;
import com.sorin.idea.exceptions.ArrTestAtpEcgDaoException;
import com.sorin.idea.exceptions.ArrTestEpiDaoException;
import com.sorin.idea.exceptions.ArrTestEpiEcgDaoException;
import com.sorin.idea.exceptions.ArrTestFleDaoException;
import com.sorin.idea.exceptions.ArrTestFleEcgDaoException;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.jdbc.ArrEnfActDaoImpl;
import com.sorin.idea.jdbc.ArrEnfDaoImpl;
import com.sorin.idea.jdbc.ArrEnfIntroductoresDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioCateterDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioDaoImpl;
import com.sorin.idea.jdbc.ArrListaEsperaDaoImpl;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ArrTestAtpDaoImpl;
import com.sorin.idea.jdbc.ArrTestAtpEcgDaoImpl;
import com.sorin.idea.jdbc.ArrTestEpiDaoImpl;
import com.sorin.idea.jdbc.ArrTestEpiEcgDaoImpl;
import com.sorin.idea.jdbc.ArrTestFleDaoImpl;
import com.sorin.idea.jdbc.ArrTestFleEcgDaoImpl;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
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

public class ControlTest extends BaseIU {
	private static Logger logger = Logger.getLogger(ControlTest.class);
	private LoginForm lf;
	private SelectorIdioma si;
	private ResourceBundle bundle;
	protected final Integer ESTADO_REALIZADO = 3;
	protected final Integer ESTADO_ACTIVO = 1;
	//tipo 1: Test Flecanida, tipo 2: Test ATP, tipo 3: Test Epi, tipo 4: enfermeria
	private final static Integer TIPO_FLE = 1;
	private final static Integer TIPO_ATP = 2;
	private final static Integer TIPO_EPI = 3;
	private final static Integer TIPO_ENF = 4;
	private ArrTestAtp atp;
	private ArrayList<ArrTestAtp> atps;
	private ArrTestEpi epi;
	private ArrayList<ArrTestEpi> epis;
	private ArrTestFle fle;
	private ArrayList<ArrTestFle> fles;
	private ArrTestAtpPk atppk;
	private ArrTestEpiPk epipk;
	private ArrTestFlePk flepk;
	private ArrTestAtpDao atpdao;
	private ArrTestEpiDao epidao;
	private ArrTestFleDao fledao;
	private ArrTestAtpEcgDao atpecgdao;
	private ArrTestEpiEcgDao epiecgdao;
	private ArrTestFleEcgDao fleecgdao;
	private ArrEnfIntroductoresDao introdao;
	private ArrEnfActDao actdao;
	private ArrEstudioCateterDao catdao;
	
	private HtmlDataTable bindingATP;
	private HtmlDataTable bindingEpi;
	private HtmlDataTable bindingFle;
	
	private HtmlDataTable bindingHistoricoATP;
	private HtmlDataTable bindingHistoricoEpi;
	private HtmlDataTable bindingHistoricoFle;
	
	private ArrEnf enf;
	private ArrayList<ArrEnf> enfs;
	private ArrEnfPk enfpk;
	private ArrEnfDao enfdao;
	private HtmlDataTable bindingEnf;
	
	private ControlMaestras cm;
	private ArrMaestras[] atpclinico;
	private ArrMaestras[] atpecg;
	private ArrMaestras[] epiclinico;
	private ArrMaestras[] epiecg;
	private ArrMaestras[] fleclinico;
	private ArrMaestras[] fleecg;
	private ArrMaestras[] atpdosis;
	private ArrMaestras[] atpcomp;
	private ArrMaestras[] atptrat;
	private ArrMaestras[] complica;
	private ArrMaestras[] tratam;
	private ArrMaestras[] epires;
	private ArrMaestras[] fleres;

	private ControlPacientes cp;
	private String usuario;
	private InfoCentro infocentro;
	/**************************/
	private Procedimiento[] proclstatp;
	private Procedimiento[] proclstepi;
	private Procedimiento[] proclstfle;
	private ArrayList<Procedimiento> procsatp;
	private ArrayList<Procedimiento> procsepi;
	private ArrayList<Procedimiento> procsfle;
	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ProcedimientoDao procdao;
	private HtmlDataTable bindingBuscar;
	/**************************/
	private EpisodioDao epdao;
	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	private HtmlDataTable bindingatp;
	private HtmlDataTable bindingfle;
	private EventoDao evdao;
	
	private boolean editable;
	
	public ControlTest() {
		if(cm == null)
			this.iniciaTest(null);
	}
	
	public void iniciaTest(ActionEvent e) {
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
			this.lf = (LoginForm) getBean("loginForm");
			//loginform = (LoginForm) getBean("loginForm");
			this.usuario = this.lf.getSesionUsuario().getUsuario();
			this.setEditable(true);
			this.proc = new Procedimiento();
			this.proc.setFecha(new Date());
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.procpk = new ProcedimientoPk();
			this.procsatp = new ArrayList<Procedimiento>();
			this.procsepi = new ArrayList<Procedimiento>();
			this.procsfle = new ArrayList<Procedimiento>();
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			
			this.atp = new ArrTestAtp();
			this.epi = new ArrTestEpi();
			this.fle = new ArrTestFle();
			this.enf = new ArrEnf();
			this.atpdao = new ArrTestAtpDaoImpl(this.usuario);
			this.epidao = new ArrTestEpiDaoImpl(this.usuario);
			this.fledao = new ArrTestFleDaoImpl(this.usuario);
			this.catdao = new ArrEstudioCateterDaoImpl(this.usuario);
			this.atpecgdao = new ArrTestAtpEcgDaoImpl(this.usuario);
			this.epiecgdao = new ArrTestEpiEcgDaoImpl(this.usuario);
			this.fleecgdao = new ArrTestFleEcgDaoImpl(this.usuario);
			this.introdao = new ArrEnfIntroductoresDaoImpl();
			this.actdao = new ArrEnfActDaoImpl();
			this.enfdao = new ArrEnfDaoImpl(this.usuario);
			this.atppk = new ArrTestAtpPk();
			this.epipk = new ArrTestEpiPk();
			this.flepk = new ArrTestFlePk();
			this.enfpk = new ArrEnfPk();
			this.cargaMaestras();
			this.bindingATP = new HtmlDataTable();
			this.bindingEpi = new HtmlDataTable();
			this.bindingFle = new HtmlDataTable();
			this.bindingEnf = new HtmlDataTable();
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_error_sel_pat"));
			} else {
				this.proclstatp = this.procdao.findByDynamicWhere("CODIGO =? AND TIPOPROCEDIMIENTO = ?",
						new Object[] {this.cp.getPacienteSelect().getCodigo(),1063});	
				if(this.proclstatp != null)
					for(Procedimiento p:this.proclstatp)
						this.procsatp.add(p);
				this.proclstepi = this.procdao.findByDynamicWhere("CODIGO =? AND TIPOPROCEDIMIENTO = ?",
						new Object[] {this.cp.getPacienteSelect().getCodigo(),1064});	
				if(this.proclstepi != null)
					for(Procedimiento p:this.proclstepi)
						this.procsepi.add(p);
				this.proclstfle = this.procdao.findByDynamicWhere("CODIGO =? AND TIPOPROCEDIMIENTO = ?",
						new Object[] {this.cp.getPacienteSelect().getCodigo(),1065});	
				if(this.proclstfle != null)
					for(Procedimiento p:this.proclstfle)
						this.procsfle.add(p);
				
				this.atps = new ArrayList<ArrTestAtp>();
				this.epis = new ArrayList<ArrTestEpi>();
				this.fles = new ArrayList<ArrTestFle>();
				this.enfs = new ArrayList<ArrEnf>();
				this.atp.setCodigoPaciente(this.cp.getPacienteSelect().getCodigo());
				this.epi.setCodigoPaciente(this.cp.getPacienteSelect().getCodigo());
				this.fle.setCodigoPaciente(this.cp.getPacienteSelect().getCodigo());
				this.enf.setIdPaciente(this.cp.getPacienteSelect().getCodigo());
				/*ArrTestAtp[] atplst = this.atpdao
						.findWhereCodigoPacienteEquals(this.atp
								.getCodigoPaciente());
				ArrTestEpi[] epilst = this.epidao
						.findWhereCodigoPacienteEquals(this.epi
								.getCodigoPaciente());
				ArrTestFle[] flelst = this.fledao
				.findWhereCodigoPacienteEquals(this.fle
						.getCodigoPaciente());*/
				ArrEnf[] enflst = this.enfdao.findWhereIdPacienteEquals(this.enf.getIdPaciente());
				/*if (atplst != null)
					for (int i = 0; i < atplst.length; i++)
						this.atps.add(atplst[i]);
				if (epilst != null)
					for (int i = 0; i < epilst.length; i++)
						this.epis.add(epilst[i]);
				if (flelst != null)
					for (int i = 0; i < flelst.length; i++)
						this.fles.add(flelst[i]);*/
				if (enflst != null)
					for (int i = 0; i < enflst.length; i++)
						this.enfs.add(enflst[i]);
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
			this.atpclinico = cm.getATPClinico();
			this.atpecg = cm.getATPEcg();
			this.fleclinico = cm.getFLEClinico();
			this.fleecg = cm.getFLEEcg();
			this.epiclinico = cm.getEPIClinico();
			this.epiecg = cm.getEPIEcg();
			this.atpdosis = cm.getATPDosis();
			this.atpcomp = cm.getATPComp();
			this.atptrat = cm.getATPTratam();
			this.complica = cm.getTestComp();
			this.tratam = cm.getTestTrat();
			this.epires = cm.getEPIres();
			this.fleres = cm.getFLEres();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
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
				if(ev!=null && ev.getEstado()==1 
						&& (ev.getProcedimiento()==1063 || ev.getProcedimiento()==1064 || ev.getProcedimiento()==1065) && proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));
			}
		} catch (Exception e1) {
			this.pintaMensaje(3,
					this.bundle.getString("info_msg_error_carga_epi")+": "+ e1.getMessage());
		}		
	}
	
	public void guardaATP(ActionEvent e) {
		try {
			if(this.atp.getFecha() != null){
				Integer epi = this.bindingatp.getRowIndex();
				if(epi != null && epi >= 0)
					this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());
				if (this.atp.getCodigoTest() == null) {
					
					this.atppk = this.atpdao.insert(this.atp);
					this.atp.setCodigoTest(this.atppk.getCodigoTest());
					this.atp.getEcgdto().setIdtest(this.atp.getCodigoTest());
					this.atpecgdao.insert(this.atp.getEcgdto());
					//escribeEnClinica(true, this.atp.getCodigoTest(), this.atp.getFecha(), TIPO_ATP);
					this.proc.setFecha(this.atp.getFecha());
					this.proc.setIdprocedimiento(this.atp.getCodigoTest());
					this.proc.setTipoprocedimiento(1063);
					this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
					this.procpk = this.procdao.insert(this.proc);
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
					logger.info("("+this.usuario+") Registro Test ATP insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				}else{
					this.proc.setFecha(this.atp.getFecha());
					this.procdao.update(this.proc.createPk(), this.proc);
					this.atpdao.update(this.atppk, this.atp);
					this.atpecgdao.update(this.atp.getEcgdto().createPk(), this.atp.getEcgdto());
					//escribeEnClinica(false, this.atp.getCodigoTest(), this.atp.getFecha(), TIPO_ATP);
					this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
					logger.info("("+this.usuario+") Registro Test ATP actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				}
				//cp.precarga(null);
				//this.pintaMensaje(Mensaje.SEVERIDAD_INFO, "Test almacenado correctamente");
			}
			else{
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_guarda_error_fecha"));
			}
			//this.updateListaEspera();
		} catch (ArrTestAtpDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error: " + e1.getMessage());
		} catch (ArrTestAtpEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error: " + e1.getMessage());
		} catch (ProcedimientoDaoException e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error: " + e1.getMessage());
		}
	}

	public void guardaEPI(ActionEvent e) {
		try {
			if(this.epi.getFecha() != null){
				Integer epi = this.bindingepi.getRowIndex();
				if(epi != null && epi >= 0)
					this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());
				if (this.epi.getCodigoTest() == null) {
					this.epipk = this.epidao.insert(this.epi);
					this.epi.setCodigoTest(this.epipk.getCodigoTest());
					this.epi.getEcgdto().setIdtest(this.epi.getCodigoTest());
					this.epiecgdao.insert(this.epi.getEcgdto());
					//escribeEnClinica(true, this.epi.getCodigoTest(), this.epi.getFecha(), TIPO_EPI);
					this.proc.setFecha(this.epi.getFecha());
					this.proc.setIdprocedimiento(this.epi.getCodigoTest());
					this.proc.setTipoprocedimiento(1064);
					this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
					this.procpk = this.procdao.insert(this.proc);
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
					logger.info("("+this.usuario+") Registro Test Epinefrina insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				}else{
					this.proc.setFecha(this.epi.getFecha());
					this.procdao.update(this.proc.createPk(), this.proc);
					this.epidao.update(this.epipk, this.epi);
					this.epiecgdao.update(this.epi.getEcgdto().createPk(), this.epi.getEcgdto());
					//escribeEnClinica(false, this.epi.getCodigoTest(), this.epi.getFecha(), TIPO_EPI);
					this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
					logger.info("("+this.usuario+") Registro Test Epinefrina actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				}
				//cp.precarga(null);
				//this.pintaMensaje(Mensaje.SEVERIDAD_INFO, "Test almacenado correctamente");
			}
			else{
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_guarda_error_fecha"));
			}
			//this.updateListaEspera();
		} catch (ArrTestEpiDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error: " + e1.getMessage());
		} catch (ArrTestEpiEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " +e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error: " + e1.getMessage());
		} catch (ProcedimientoDaoException e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error: " + e1.getMessage());
		}
	}
	
	public void guardaFle(ActionEvent e) {
		try {
			if(this.fle.getFecha() != null){
				Integer epi = this.bindingfle.getRowIndex();
				if(epi != null && epi >= 0)
					this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());
				if (this.fle.getCodigoTest() == null) {
					this.flepk = this.fledao.insert(this.fle);
					this.fle.setCodigoTest(this.flepk.getCodigoTest());
					this.fle.getEcgdto().setIdtest(this.fle.getCodigoTest());
					this.fleecgdao.insert(this.fle.getEcgdto());
					//escribeEnClinica(true, this.fle.getCodigoTest(), this.fle.getFecha(), TIPO_FLE);
					this.proc.setFecha(this.fle.getFecha());
					this.proc.setIdprocedimiento(this.fle.getCodigoTest());
					this.proc.setTipoprocedimiento(1065);
					this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
					this.procpk = this.procdao.insert(this.proc);
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
					logger.info("("+this.usuario+") Registro Test Flecainida insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				}else{
					this.proc.setFecha(this.fle.getFecha());
					this.procdao.update(this.proc.createPk(), this.proc);
					this.fledao.update(this.flepk, this.fle);
					this.fleecgdao.update(this.fle.getEcgdto().createPk(), this.fle.getEcgdto());
					//escribeEnClinica(false, this.fle.getCodigoTest(), this.fle.getFecha(), TIPO_FLE);
					this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
					logger.info("("+this.usuario+") Registro Test Flecainida actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				}
				//cp.precarga(null);
				//this.pintaMensaje(Mensaje.SEVERIDAD_INFO, "Test almacenado correctamente");
			}
			else{
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_guarda_error_fecha"));
			}
			//this.updateListaEspera();
		} catch (ArrTestFleDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error: " + e1.getMessage());
		} catch (ArrTestFleEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error: " + e1.getMessage());
		} catch (ProcedimientoDaoException e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error: " + e1.getMessage());
		}
	}
	
	private void updateListaEspera(){
		try{
			ArrListaEsperaDao ledao = new ArrListaEsperaDaoImpl(this.usuario);
			ArrListaEspera[] les = ledao.findWhereCodigoPacienteEquals(this.cp.getPacienteSelect().getCodigo());
			if (les != null && les.length > 0) {
				if (les.length == 1) {
					ArrListaEspera le = les[0];
					le.setEstado(ESTADO_REALIZADO);
					ledao.update(le.createPk(), le);
				} else {
					for (ArrListaEspera le : les)
						if (le.getEstado() == ESTADO_ACTIVO) {
							le.setEstado(ESTADO_REALIZADO);
							ledao.update(le.createPk(), le);
						}
				}
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO,"Lista de espera actualizada con éxito");
			}
		}catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "No se ha podido actualizar la lista de espera");
		}
	}
	
	public void guardaCateteres(){
		try {
			this.catdao.delete(new ArrEstudioCateterPk(this.enf.getIdRegistro()));
			for (ArrEstudioCateter cateter : this.enf.getCats()) {
				cateter.setIdenfermeria(this.enf.getIdRegistro());
				catdao.insert(cateter);
			}
		} catch (ArrEstudioCateterDaoException e) {
			this.pintaMensaje(3,"No se han guardado los catéteres: " + e.getMessage());
		}
	}

	public void guardaEnf(ActionEvent e) {
		try {
			if(this.enf.getFecha() != null){
				ArrEstudioDao eefdao = new ArrEstudioDaoImpl(this.usuario);
				ArrEstudio[] estudios = eefdao.findByDynamicWhere("FECHA = STR_TO_DATE('" + UtilFechas.dateToString(this.enf.getFecha()) + "','%d/%m/%Y') AND IDPACIENTE = ?", new Object[]{this.enf.getIdPaciente()});
				if(estudios != null && estudios.length > 0)
					this.enf.setIdeef(estudios[0].getIdestudio());
				if (this.enf.getIdRegistro() == null) {
					this.enfpk = this.enfdao.insert(this.enf);
					this.enf.setIdRegistro(this.enfpk.getIdRegistro());
					for(int i=0;i<this.enf.getCats().size();i++)
						this.enf.getCats().get(i).setIdenfermeria(this.enfpk.getIdRegistro());
					this.guardaCateteres();
					this.introdao.delete(this.enfpk.getIdRegistro());
					for(int i=0;i<this.enf.getIntroductores().size();i++){
						this.enf.getIntroductores().get(i).setIdReg(this.enfpk.getIdRegistro());
						this.introdao.insert(this.enf.getIntroductores().get(i));
					}
					this.actdao.delete(this.enfpk.getIdRegistro());
					for(int i=0;i<this.enf.getActs().size();i++){
						if(this.enf.getActs().get(i).getAct() != null){
							this.enf.getActs().get(i).setIdRegistro(this.enfpk.getIdRegistro());
							this.actdao.insert(this.enf.getActs().get(i));
						}
					}
					//escribeEnClinica(true, this.enf.getIdRegistro(), this.enf.getFecha(), TIPO_ENF);
				}else{
					this.introdao.delete(this.enfpk.getIdRegistro());
					this.actdao.delete(this.enfpk.getIdRegistro());
					this.enfdao.update(this.enfpk, this.enf);
					this.guardaCateteres();
					for(int i=0;i<this.enf.getIntroductores().size();i++){
						this.enf.getIntroductores().get(i).setIdReg(this.enfpk.getIdRegistro());
						this.introdao.insert(this.enf.getIntroductores().get(i));
					}
					for(int i=0;i<this.enf.getActs().size();i++){
						if(this.enf.getActs().get(i).getAct() != null){
							this.enf.getActs().get(i).setIdRegistro(this.enfpk.getIdRegistro());
							this.actdao.insert(this.enf.getActs().get(i));
						}
					}
					//escribeEnClinica(false, this.enf.getIdRegistro(), this.enf.getFecha(), TIPO_ENF);
				}
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
			}
			else{
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, "Debe introducir la fecha del estudio asociado");
			}
		} catch (ArrEnfDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
		} catch (ArrEstudioDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
		} catch (ArrEnfIntroductoresDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
		} catch (ArrEnfActDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
		}
	}
	
	public void cargaATP_OLD(ActionEvent e){
		Integer fila = this.bindingATP.getRowIndex();
		this.atp = this.atps.get(fila);
		this.atppk = this.atp.createPk();
		try {
			this.atp.setEcgdto(this.atpecgdao.findByPrimaryKey(this.atp.getCodigoTest()));
		} catch (ArrTestAtpEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		}
	}
	public void cargaATP(ActionEvent e){	
		try {
			this.proc = this.procsatp.get(this.bindingATP.getRowIndex());
			this.procpk = this.proc.createPk();
			this.atp = this.atpdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.atppk = this.atp.createPk();
			this.atp.setEcgdto(this.atpecgdao.findByPrimaryKey(this.atp.getCodigoTest()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
		} catch (ArrTestAtpEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		} catch (ArrTestAtpDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		}
	}
	public void cargaATPDesdeBarraTemporal(ActionEvent e){	
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),1063})[0];
			this.procpk = this.proc.createPk();
			this.atp = this.atpdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.atppk = this.atp.createPk();
			this.atp.setEcgdto(this.atpecgdao.findByPrimaryKey(this.atp.getCodigoTest()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Test ATP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ArrTestAtpEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test ATP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ArrTestAtpDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test ATP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test ATP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	public void cargaATPConsulta(ActionEvent e){	
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getPacienteSelect().getIdatp(),1063})[0];
			this.procpk = this.proc.createPk();
			this.atp = this.atpdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.atppk = this.atp.createPk();
			this.atp.setEcgdto(this.atpecgdao.findByPrimaryKey(this.atp.getCodigoTest()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Test ATP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ArrTestAtpEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test ATP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ArrTestAtpDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test ATP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test ATP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	
	public void eliminaATP(ActionEvent e){
		/*Integer fila = this.bindingATP.getRowIndex();
		this.atp = this.atps.get(fila);
		this.atppk = this.atp.createPk();*/
		this.proc = this.procsatp.get(this.bindingATP.getRowIndex());
		int auxproc = this.proc.getIdprocedimiento();
		try {
			this.atp = this.atpdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.procdao.delete(this.proc.createPk());
			this.atpdao.delete(this.atp.createPk());
			this.iniciaTest(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			logger.info("("+this.usuario+") Registro Test ATP eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		} catch (ArrTestAtpDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test ATP. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test ATP. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		}
	}
	public void eliminaATPInterno(ActionEvent e){
		/*Integer fila = this.bindingATP.getRowIndex();
		this.atp = this.atps.get(fila);
		this.atppk = this.atp.createPk();*/
		//this.proc = this.procsatp.get(this.bindingATP.getRowIndex());
		int auxproc = this.proc.getIdprocedimiento();
		try {
			//this.atp = this.atpdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.procdao.delete(this.proc.createPk());
			this.atpdao.delete(this.atp.createPk());
			this.iniciaTest(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			logger.info("("+this.usuario+") Registro Test ATP eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		} catch (ArrTestAtpDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test ATP. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test ATP. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		}
	}
	
	public void cargaEpi_OLD(ActionEvent e){
		Integer fila = this.bindingEpi.getRowIndex();
		this.epi = this.epis.get(fila);
		this.epipk = this.epi.createPk();
		try {
			this.epi.setEcgdto(this.epiecgdao.findByPrimaryKey(this.epi.getCodigoTest()));
		} catch (ArrTestEpiEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		}
	}
	public void cargaEpi(ActionEvent e){
		try {
			this.proc = this.procsepi.get(this.bindingEpi.getRowIndex());
			this.procpk = this.proc.createPk();
			this.epi = this.epidao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.epipk = this.epi.createPk();
			this.epi.setEcgdto(this.epiecgdao.findByPrimaryKey(this.epi.getCodigoTest()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
		} catch (ArrTestEpiEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		} catch (ArrTestEpiDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		}
	}
	public void cargaEpiDesdeBarraTemporal(ActionEvent e){
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),1064})[0];
			this.procpk = this.proc.createPk();
			this.epi = this.epidao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.epipk = this.epi.createPk();
			this.epi.setEcgdto(this.epiecgdao.findByPrimaryKey(this.epi.getCodigoTest()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Test Epinefrina). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ArrTestEpiEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Epinefrina). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ArrTestEpiDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Epinefrina). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Epinefrina). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	public void cargaEpiConsulta(ActionEvent e){
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getPacienteSelect().getIdepi(),1064})[0];
			this.procpk = this.proc.createPk();
			this.epi = this.epidao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.epipk = this.epi.createPk();
			this.epi.setEcgdto(this.epiecgdao.findByPrimaryKey(this.epi.getCodigoTest()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Test Epinefrina). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ArrTestEpiEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Epinefrina). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ArrTestEpiDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Epinefrina). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Epinefrina). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	public void eliminaEpi(ActionEvent e){
		/*Integer fila = this.bindingEpi.getRowIndex();
		this.epi = this.epis.get(fila);
		this.epipk = this.epi.createPk();*/
		this.proc = this.procsepi.get(this.bindingEpi.getRowIndex());
		int auxproc = this.proc.getIdprocedimiento();
		try {
			this.procdao.delete(this.proc.createPk());
			this.epidao.delete(this.epi.createPk());
			this.iniciaTest(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			logger.info("("+this.usuario+") Registro Test Epinefrina eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		} catch (ArrTestEpiDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test Epinefrina. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test Epinefrina. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		}
	}
	public void eliminaEpiInterno(ActionEvent e){
		/*Integer fila = this.bindingEpi.getRowIndex();
		this.epi = this.epis.get(fila);
		this.epipk = this.epi.createPk();*/
		//this.proc = this.procsepi.get(this.bindingEpi.getRowIndex());
		int auxproc = this.proc.getIdprocedimiento();
		try {
			this.procdao.delete(this.proc.createPk());
			this.epidao.delete(this.epi.createPk());
			this.iniciaTest(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			logger.info("("+this.usuario+") Registro Test Epinefrina eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		} catch (ArrTestEpiDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test Epinefrina. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test Epinefrina. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		}
	}
	
	public void cargaFle(ActionEvent e){
		try {
			this.proc = this.procsfle.get(this.bindingFle.getRowIndex());
			this.procpk = this.proc.createPk();
			this.fle = this.fledao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.flepk = this.fle.createPk();
			this.fle.setEcgdto(this.fleecgdao.findByPrimaryKey(this.fle.getCodigoTest()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
		} catch (ArrTestFleEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		} catch (ArrTestFleDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		}
	}
	public void cargaFleDesdeBarraTemporal(ActionEvent e){
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),1065})[0];
			this.procpk = this.proc.createPk();
			this.fle = this.fledao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.flepk = this.fle.createPk();
			this.fle.setEcgdto(this.fleecgdao.findByPrimaryKey(this.fle.getCodigoTest()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Test Flecainida). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ArrTestFleEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Flecainida). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ArrTestFleDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Flecainida). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Flecainida). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	public void cargaFleConsulta(ActionEvent e){
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getPacienteSelect().getIdfle(),1065})[0];
			this.procpk = this.proc.createPk();
			this.fle = this.fledao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.flepk = this.fle.createPk();
			this.fle.setEcgdto(this.fleecgdao.findByPrimaryKey(this.fle.getCodigoTest()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Test Flecainida). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ArrTestFleEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Flecainida). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ArrTestFleDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Flecainida). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Test Flecainida). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	
	public void eliminaFle(ActionEvent e){
		//Integer fila = this.bindingFle.getRowIndex();
		//this.fle = this.fles.get(fila);
		//this.flepk = this.fle.createPk();
		this.proc = this.procsfle.get(this.bindingFle.getRowIndex());
		int auxproc = this.proc.getIdprocedimiento();
		try {
			this.procdao.delete(this.proc.createPk());
			this.fledao.delete(this.fle.createPk());
			this.iniciaTest(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			logger.info("("+this.usuario+") Registro Test Flecainida eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		} catch (ArrTestFleDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test Flecainida. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test Flecainida. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		}
	}
	public void eliminaFleInterno(ActionEvent e){
		//Integer fila = this.bindingFle.getRowIndex();
		//this.fle = this.fles.get(fila);
		//this.flepk = this.fle.createPk();
		//this.proc = this.procsfle.get(this.bindingFle.getRowIndex());
		int auxproc = this.proc.getIdprocedimiento();
		try {
			this.procdao.delete(this.proc.createPk());
			this.fledao.delete(this.fle.createPk());
			this.iniciaTest(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			logger.info("("+this.usuario+") Registro Test Flecainida eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		} catch (ArrTestFleDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test Flecainida. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error eliminando el test Flecainida. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+"Motivo: " + e1.getMessage());
		}
	}
	
	public void cargaEnf(ActionEvent e){
		Integer fila = this.bindingEnf.getRowIndex();
		this.enf = this.enfs.get(fila);
		this.enfpk = this.enf.createPk();
		ArrEnfIntroductores[] introductores;
		ArrEnfAct[] acts;
		ArrEstudioCateter[] cats;
		try {
			introductores = this.introdao.findWhereIdRegEquals(this.enfpk.getIdRegistro());
			ArrayList<ArrEnfIntroductores> introarr = new ArrayList<ArrEnfIntroductores>();
			for(int i=0;i<introductores.length;i++)
				introarr.add(introductores[i]);
			this.enf.setIntroductores(introarr);
			
			acts = this.actdao.findWhereIdRegistroEquals(this.enfpk.getIdRegistro());
			ArrayList<ArrEnfAct> actarr = new ArrayList<ArrEnfAct>();
			for(int i=0;i<acts.length;i++)
				actarr.add(acts[i]);
			this.enf.setActs(actarr);
			
			cats = catdao.findWhereIdenfermeriaEquals(this.enf.getIdRegistro());
			ArrayList<ArrEstudioCateter> catarray = new ArrayList<ArrEstudioCateter>();
			for (ArrEstudioCateter cat : cats)
				catarray.add(cat);
			this.enf.setCats(catarray);
			if (this.enf.getCats() == null)
				this.enf.setCats(new ArrayList<ArrEstudioCateter>());
		} catch (ArrEnfIntroductoresDaoException e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		} catch (ArrEstudioCateterDaoException e2) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_reg")+": " + e2.getMessage());
		} catch (ArrEnfActDaoException e2) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_reg")+": " + e2.getMessage());
		}
	}
	
	public void imprimeATP(ActionEvent e){
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

		try {
			PathFicheroXml = generadorXML.imprimeATP(this.atp,
					this.cp.pacienteSelect,this.infocentro, this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+se.getMessage());
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}

		construyePDF("testEEFATP.jasper", PathFicheroXml);
		logger.info("("+this.usuario+") Generación de informe (Test ATP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
	}
	
	public void imprimeEPI(ActionEvent e){
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

		try {
			PathFicheroXml = generadorXML.imprimeEPI(this.epi,
					this.cp.pacienteSelect,this.infocentro, this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+se.getMessage());
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}
		construyePDF("testEEF.jasper", PathFicheroXml);
		logger.info("("+this.usuario+") Generación de informe (Test Epinefrina). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
	}
	
	public void imprimeFLE(ActionEvent e){
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

		try {
			PathFicheroXml = generadorXML.imprimeFLE(this.fle,
					this.cp.pacienteSelect,this.infocentro, this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+se.getMessage());
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}
		construyePDF("testEEF.jasper", PathFicheroXml);
		logger.info("("+this.usuario+") Generación de informe (Test Flecainida). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
	}
	
	public void printEnfermeria(ActionEvent e){
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

		try {
			ArrEstudioDao eefdao = new ArrEstudioDaoImpl(this.usuario);
			ArrMaestrasDao maedao = new ArrMaestrasDaoImpl(this.usuario);
			
			PathFicheroXml = generadorXML.imprimeENF(this.enf,
					this.cp.pacienteSelect, maedao.findByPrimaryKey(eefdao.findByPrimaryKey(this.enf.getIdeef()).getDiagnostico()).getValor(),this.bundle);
		} catch (Exception se) {
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}
		construyePDF("InformeENF.jasper", PathFicheroXml);
	}
	
	private void construyePDF(String jasper, String path){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), path, jasper);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento, motivo: "+se.getMessage());
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
	
	static private String getRemoteFileName(long handle) {

		String remotePath = null;
		String remoteFileName = null;

		remotePath = "00000000" + Long.toHexString(handle);
		remotePath = remotePath.substring(remotePath.length() - 8, remotePath
				.length());
		remoteFileName = remotePath.substring(6, 8);

		return remoteFileName.toUpperCase();
	}

	static private String getRemotePath(long handle) {

		String remotePath = null;

		remotePath = "00000000" + Long.toHexString(handle);
		remotePath = remotePath.substring(remotePath.length() - 8, remotePath
				.length());
		remotePath = remotePath.substring(0, 2) + "/"
				+ remotePath.substring(2, 4) + "/" + remotePath.substring(4, 6);

		return remotePath.toUpperCase();
	}
	
	public String printFichero(Integer tipo) {
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext
				.getCurrentInstance());
		String path = "", jasper = "";
		try {
			switch (tipo) {
			case 1:
				PathFicheroXml = generadorXML.imprimeFLE(this.fle,
						this.cp.pacienteSelect,this.infocentro, this.bundle);
				jasper = "testEEF.jasper";
				break;
			case 2:
				PathFicheroXml = generadorXML.imprimeATP(this.atp,
						this.cp.pacienteSelect,this.infocentro, this.bundle);
				jasper = "testEEFATP.jasper";
				break;
			case 3:
				PathFicheroXml = generadorXML.imprimeEPI(this.epi,
						this.cp.pacienteSelect,this.infocentro, this.bundle);
				jasper = "testEEF.jasper";
				break;
			case 4:
				ArrEstudioDao eefdao = new ArrEstudioDaoImpl(this.usuario);
				ArrMaestrasDao maedao = new ArrMaestrasDaoImpl(this.usuario);
				PathFicheroXml = generadorXML.imprimeENF(this.enf,
						this.cp.pacienteSelect, maedao.findByPrimaryKey(eefdao.findByPrimaryKey(this.enf.getIdeef()).getDiagnostico()).getValor(),this.bundle);
				jasper = "InformeEnf.jasper";
				break;
			default:
				break;
			}
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
				this.bundle.getString("info_msg_error_impr_gen_doc")+": " + se.getMessage());
		}

		try {
			path = constructorPDF.generarArchivoPdfFile(FacesContext.getCurrentInstance(), PathFicheroXml, jasper);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
				this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + se.getMessage());
		}
		return path;
	}

	public void escribeEnClinica(boolean nuevo, Integer idexterna, Date fecha, Integer tipo)  {
		try {
			DocHl7Dto consultaNueva = new DocHl7Dto();
			String path = printFichero(tipo);
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
				consultaNueva.setIdinforext("" + idexterna);
				consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
				consultaNueva.setIdpetic("0");
				consultaNueva.setEpisodio("0");
				UsuarioDao usDao = new UsuarioDao();
	        	SesionUsuarioDto ses = new SesionUsuarioDto();
	        	ses.setLogin(this.usuario);
				String doctor;
				doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
				consultaNueva.setRedactor(doctor);
				consultaNueva.setResponprime(doctor);
				consultaNueva.setServicio("QCAR");
				Timestamp fecT = UtilFechas.dateToTimestamp(fecha);
				consultaNueva.setFcreacion(fecT);
				Time t = new Time(fecT.getTime());
				consultaNueva.setHcreacion(t);
				consultaNueva.setIdtipodoc(47);
				consultaNueva.setIdsubti("ARR01");
				enviaInformeFTP(consultaNueva, true, path, idexterna, fecha, tipo);
			} else {
				Timestamp fecT = UtilFechas.dateToTimestamp(fecha);
				Time t = new Time(fecT.getTime());
				consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
				consultaNueva.setIdpetic("0");
				consultaNueva.setEpisodio("0");
				UsuarioDao usDao = new UsuarioDao();
	        	SesionUsuarioDto ses = new SesionUsuarioDto();
	        	ses.setLogin(this.usuario);
				String doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
				consultaNueva.setRedactor(doctor);
				consultaNueva.setResponprime(doctor);
				consultaNueva.setResponsegun(doctor);
				consultaNueva.setServicio("QCAR");
				consultaNueva.setIdinforext("" + idexterna);
				consultaNueva.setIdsubti("ARR01");
				consultaNueva.setIdtipodoc(47);
				consultaNueva.setFmodificacion(fecT);
				consultaNueva.setHmodificacion(t);
				enviaInformeFTP(consultaNueva, false, path, idexterna, fecha, tipo);
			}
		} catch (DAOException e) {
			this.pintaMensaje(3, "Error imprimiendo informe a Estación Clínica: " + e.getMessage());
		}
	}
	
	public void enviaInformeFTP(DocHl7Dto item, boolean nuevo, String path, Integer idexterna, Date fecha, Integer tipo) {
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
					//escribeEnClinica(true, idexterna, fecha, tipo);
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

	public ArrayList<SelectItem> getAtpclinico() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.atpclinico)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
/*		diag.add(new SelectItem("1", "Sospecha WPW"));
		diag.add(new SelectItem("2", "Post-ablación VAC"))
		diag.add(new SelectItem("3", "Screening familiar"));
	*/	return diag;
	}

	public ArrayList<SelectItem> getAtpecg() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.atpecg)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "Preexcitación inaparente"))
		diag.add(new SelectItem("2", "ECG normal"));
		*/return diag;
	}

	public ArrayList<SelectItem> getEpiclinico() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.epiclinico)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "Síncope"));
		diag.add(new SelectItem("2", "Parada cardiaca por FV"));
		diag.add(new SelectItem("3", "Screening familiar"))
		diag.add(new SelectItem("4", "AF muerte súbita"));
		diag.add(new SelectItem("5", "Otro"));
		*/return diag;
	}

	public ArrayList<SelectItem> getEpiecg() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.epiecg)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "ECG anormal"));
		diag.add(new SelectItem("2", "ECG normal"))
	*/	return diag;
	}
	
	public ArrayList<SelectItem> getFleclinico() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.fleclinico)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "Síncope"));
		diag.add(new SelectItem("3", "Screening familiar"));
		diag.add(new SelectItem("4", "AF muerte súbita"));
		diag.add(new SelectItem("5", "Otro"))
		*/return diag;
	}

	public ArrayList<SelectItem> getFleecg() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.fleecg)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "ECG anormal tipo II"));
		diag.add(new SelectItem("2", "ECG anormal tipo III"));
		diag.add(new SelectItem("3", "ECG normal"));
		*/return diag;
	}

	public ArrayList<SelectItem> getIntervalos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem("1", "RR"));
		diag.add(new SelectItem("2", "PR"));
		diag.add(new SelectItem("3", "QRS"));
		diag.add(new SelectItem("4", "QT"));
		diag.add(new SelectItem("5", "QTc"));
		return diag;
	}

	public ArrayList<SelectItem> getQrs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem("1", "Normal"));
		diag.add(new SelectItem("2", "BRD"));
		diag.add(new SelectItem("3", "BRI"));
		diag.add(new SelectItem("4", "BRD+HAI (HPI)"));
		diag.add(new SelectItem("5", "BIRD"));
		diag.add(new SelectItem("6", "HAI"));
		diag.add(new SelectItem("7", "HPI"));
		return diag;
	}
	
	public ArrayList<SelectItem> getQrsfle() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem("1", "Normal"));
		diag.add(new SelectItem("2", "BRD"));
		diag.add(new SelectItem("3", "BIRD"));
		diag.add(new SelectItem("4", "HAI"));
		diag.add(new SelectItem("5", "HPI"));
		return diag;
	}

	public ArrayList<SelectItem> getAtpdosis() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.atpdosis)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "Positivo (Preexcitación ventricular)"));
		diag.add(new SelectItem("2", "Dudoso (paro sinusal sin preexcitación)"));
		diag.add(new SelectItem("3", "Negativo (Bloqueo AV sin preexcitación)"))
		*/return diag;
	}

	public ArrayList<SelectItem> getAtpcomplica() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.atpcomp)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "No"));
		diag.add(new SelectItem("2", "Fibrilación auricular"));
		diag.add(new SelectItem("3", "Broncoespasmo"));
		diag.add(new SelectItem("4", "Síncope"))
		diag.add(new SelectItem("5", "Otras"));
		*/return diag;
	}

	public ArrayList<SelectItem> getAtptratam() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.atptrat)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "No"));
		diag.add(new SelectItem("2", "Eufilina"));
		diag.add(new SelectItem("3", "Cardioversión eléctrica"))
		*/return diag;
	}

	public ArrayList<SelectItem> getEpicomplica() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.complica)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "No"));
		diag.add(new SelectItem("2", "Taquicardia ventricular polimórfica"));
		diag.add(new SelectItem("3", "Fibrilación ventricular"));
		diag.add(new SelectItem("4", "Bloqueo AV"))
		diag.add(new SelectItem("5", "Otras"));
		*/return diag;
	}

	public ArrayList<SelectItem> getEpitratam() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.tratam)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*diag.add(new SelectItem("1", "No"));
		diag.add(new SelectItem("2", "MP Transitorio"))
		diag.add(new SelectItem("3", "Desfibrilación"));
		*/return diag;
	}
	
	public ArrayList<SelectItem> getEpires() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.epires)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*<f:selectItem itemLabel="Negativo" itemValue="1" />
			<f:selectItem itemLabel="LQT1" itemValue="2" />
			<f:selectItem itemLabel="LQT2" itemValue="3" />
			<f:selectItem itemLabel="TV polimórfica" itemValue="4" />
		*/return diag;
	}
	
	public ArrayList<SelectItem> getFleres() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.fleres)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		/*<f:selectItem itemLabel="Negativo" itemValue="1" />
	<f:selectItem itemLabel="Positivo" itemValue="2" />
	<f:selectItem itemLabel="Sugestivo" itemValue="3" />
		*/return diag;
	}
	
	

	public ArrTestAtp getAtp() {
		return atp;
	}

	public void setAtp(ArrTestAtp atp) {
		this.atp = atp;
	}

	public ArrayList<ArrTestAtp> getAtps() {
		return atps;
	}

	public void setAtps(ArrayList<ArrTestAtp> atps) {
		this.atps = atps;
	}

	public ArrTestEpi getEpi() {
		return epi;
	}

	public void setEpi(ArrTestEpi epi) {
		this.epi = epi;
	}

	public ArrayList<ArrTestEpi> getEpis() {
		return epis;
	}

	public void setEpis(ArrayList<ArrTestEpi> epis) {
		this.epis = epis;
	}

	public HtmlDataTable getBindingATP() {
		return bindingATP;
	}

	public void setBindingATP(HtmlDataTable bindingATP) {
		this.bindingATP = bindingATP;
	}

	public HtmlDataTable getBindingEpi() {
		return bindingEpi;
	}

	public void setBindingEpi(HtmlDataTable bindingEpi) {
		this.bindingEpi = bindingEpi;
	}

	public ArrTestFle getFle() {
		return fle;
	}

	public void setFle(ArrTestFle fle) {
		this.fle = fle;
	}

	public ArrayList<ArrTestFle> getFles() {
		return fles;
	}

	public void setFles(ArrayList<ArrTestFle> fles) {
		this.fles = fles;
	}

	public HtmlDataTable getBindingFle() {
		return bindingFle;
	}

	public void setBindingFle(HtmlDataTable bindingFle) {
		this.bindingFle = bindingFle;
	}

	public ArrEnf getEnf() {
		return enf;
	}

	public void setEnf(ArrEnf enf) {
		this.enf = enf;
	}

	public ArrayList<ArrEnf> getEnfs() {
		return enfs;
	}

	public void setEnfs(ArrayList<ArrEnf> enfs) {
		this.enfs = enfs;
	}

	public HtmlDataTable getBindingEnf() {
		return bindingEnf;
	}

	public void setBindingEnf(HtmlDataTable bindingEnf) {
		this.bindingEnf = bindingEnf;
	}

	public String getResultadofle(){
		if(this.fle != null && this.fle.getResultado() > 0)
			for(ArrMaestras mae : this.fleres)
				if(this.fle.getResultado().equals(mae.getCodigo()))
					return mae.getValor();
			return "";
	}
	
	public String getComplicafle(){
		if(this.fle != null && this.fle.getComplica() > 0)
			for(ArrMaestras mae : this.complica)
				if(this.fle.getComplica().equals(mae.getCodigo()))
					return mae.getValor();
			return "";
	}
	
	public String getDosis1epi(){
		if(this.epi != null && this.epi.getDosis1() > 0)
			for(ArrMaestras mae : this.epires)
				if(this.epi.getDosis1().equals(mae.getCodigo()))
					return mae.getValor();
			return "";
	}
	
	public String getComplicaepi(){
		if(this.epi != null && this.epi.getComplica() > 0)
			for(ArrMaestras mae : this.complica)
				if(this.epi.getComplica().equals(mae.getCodigo()))
					return mae.getValor();
			return "";	
	}
	
	public String getComplicaatp(){
		if(this.atp != null && this.atp.getComplica() > 0)
			for(ArrMaestras mae : this.atpcomp)
				if(this.atp.getComplica().equals(mae.getCodigo()))
					return mae.getValor();
			return "";	
	}

	public boolean isAsociado() {
		return (this.enf != null && this.enf.getIdeef() != null);
	}

	public HtmlDataTable getBindingHistoricoATP() {
		return bindingHistoricoATP;
	}

	public void setBindingHistoricoATP(HtmlDataTable bindingHistoricoATP) {
		this.bindingHistoricoATP = bindingHistoricoATP;
	}

	public HtmlDataTable getBindingHistoricoEpi() {
		return bindingHistoricoEpi;
	}

	public void setBindingHistoricoEpi(HtmlDataTable bindingHistoricoEpi) {
		this.bindingHistoricoEpi = bindingHistoricoEpi;
	}

	public HtmlDataTable getBindingHistoricoFle() {
		return bindingHistoricoFle;
	}

	public void setBindingHistoricoFle(HtmlDataTable bindingHistoricoFle) {
		this.bindingHistoricoFle = bindingHistoricoFle;
	}
	public void lecturaProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
		p.load(is);
		is.close();
		this.infocentro = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
					p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"));
	}

	public ArrayList<Procedimiento> getProcsatp() {
		return procsatp;
	}

	public void setProcsatp(ArrayList<Procedimiento> procsatp) {
		this.procsatp = procsatp;
	}

	public ArrayList<Procedimiento> getProcsepi() {
		return procsepi;
	}

	public void setProcsepi(ArrayList<Procedimiento> procsepi) {
		this.procsepi = procsepi;
	}

	public ArrayList<Procedimiento> getProcsfle() {
		return procsfle;
	}

	public void setProcsfle(ArrayList<Procedimiento> procsfle) {
		this.procsfle = procsfle;
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

	public HtmlDataTable getBindingatp() {
		return bindingatp;
	}

	public void setBindingatp(HtmlDataTable bindingatp) {
		this.bindingatp = bindingatp;
	}

	public HtmlDataTable getBindingfle() {
		return bindingfle;
	}

	public void setBindingfle(HtmlDataTable bindingfle) {
		this.bindingfle = bindingfle;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}
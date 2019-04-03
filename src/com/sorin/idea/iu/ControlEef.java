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

import hvn.apl.evomed.dto.DocHl7Dto;
import hvn.apl.evomed.ssh.UtilesTerminalSsh;
import hvn.apl.evomed.ssh.exception.SshException;
import hvn.apl.jProyecto2010.modelo.servicios.dto.SesionUsuarioDto;
import hvn.cm.dao.DAOException;
import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.pdfbox.pdfviewer.ArrayEntry;

import com.sorin.idea.correo.GestorCorreo;
import com.sorin.idea.dao.ArrAblacionComplicaDao;
import com.sorin.idea.dao.ArrConducPfDao;
import com.sorin.idea.dao.ArrConduccEcDao;
import com.sorin.idea.dao.ArrEnfActDao;
import com.sorin.idea.dao.ArrEnfDao;
import com.sorin.idea.dao.ArrEnfIntroductoresDao;
import com.sorin.idea.dao.ArrEstudioAblacionDao;
import com.sorin.idea.dao.ArrEstudioAnestDao;
import com.sorin.idea.dao.ArrEstudioCatAplDao;
import com.sorin.idea.dao.ArrEstudioCatUsoDao;
import com.sorin.idea.dao.ArrEstudioCateterDao;
import com.sorin.idea.dao.ArrEstudioComplicacionesDao;
import com.sorin.idea.dao.ArrEstudioConduccavDao;
import com.sorin.idea.dao.ArrEstudioDao;
import com.sorin.idea.dao.ArrEstudioEcgDao;
import com.sorin.idea.dao.ArrEstudioEnfDao;
import com.sorin.idea.dao.ArrEstudioIntentoDao;
import com.sorin.idea.dao.ArrEstudioNprocDao;
import com.sorin.idea.dao.ArrEstudioPeriodoDao;
import com.sorin.idea.dao.ArrEstudioPopDao;
import com.sorin.idea.dao.ArrEstudioResultadoDao;
import com.sorin.idea.dao.ArrEstudioSinusalDao;
import com.sorin.idea.dao.ArrEstudioSopDao;
import com.sorin.idea.dao.ArrEstudioTaquiDao;
import com.sorin.idea.dao.ArrEstudioViasDao;
import com.sorin.idea.dao.ArrListaEsperaDao;
import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ArrSinusalPfDao;
import com.sorin.idea.dao.CateterDao;
import com.sorin.idea.dao.Codigosgs128Dao;
import com.sorin.idea.dao.ComplicacionesPacientesDao;
import com.sorin.idea.dao.DocHL7InformesDao;
import com.sorin.idea.dao.EpisodioDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.PacienteDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.ProtocolosDao;
import com.sorin.idea.dao.SintomasSitclinProcDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dao.UsuarioDao;
import com.sorin.idea.dto.ArrAblacionComplica;
import com.sorin.idea.dto.ArrAblacionComplicaPk;
import com.sorin.idea.dto.ArrConducPf;
import com.sorin.idea.dto.ArrConducPfPk;
import com.sorin.idea.dto.ArrConduccEc;
import com.sorin.idea.dto.ArrConduccEcPk;
import com.sorin.idea.dto.ArrEnf;
import com.sorin.idea.dto.ArrEnfAct;
import com.sorin.idea.dto.ArrEnfIntroductores;
import com.sorin.idea.dto.ArrEnfPk;
import com.sorin.idea.dto.ArrEstudio;
import com.sorin.idea.dto.ArrEstudioAblacion;
import com.sorin.idea.dto.ArrEstudioAblacionPk;
import com.sorin.idea.dto.ArrEstudioAnest;
import com.sorin.idea.dto.ArrEstudioAnestPk;
import com.sorin.idea.dto.ArrEstudioCatApl;
import com.sorin.idea.dto.ArrEstudioCatUso;
import com.sorin.idea.dto.ArrEstudioCatUsoPk;
import com.sorin.idea.dto.ArrEstudioCateter;
import com.sorin.idea.dto.ArrEstudioCateterPk;
import com.sorin.idea.dto.ArrEstudioComplicaciones;
import com.sorin.idea.dto.ArrEstudioComplicacionesPk;
import com.sorin.idea.dto.ArrEstudioConduccav;
import com.sorin.idea.dto.ArrEstudioConduccavPk;
import com.sorin.idea.dto.ArrEstudioEcg;
import com.sorin.idea.dto.ArrEstudioEcgPk;
import com.sorin.idea.dto.ArrEstudioEnf;
import com.sorin.idea.dto.ArrEstudioEnfPk;
import com.sorin.idea.dto.ArrEstudioIntento;
import com.sorin.idea.dto.ArrEstudioIntentoPk;
import com.sorin.idea.dto.ArrEstudioNproc;
import com.sorin.idea.dto.ArrEstudioNprocPk;
import com.sorin.idea.dto.ArrEstudioPeriodo;
import com.sorin.idea.dto.ArrEstudioPeriodoPk;
import com.sorin.idea.dto.ArrEstudioPk;
import com.sorin.idea.dto.ArrEstudioPop;
import com.sorin.idea.dto.ArrEstudioPopPk;
import com.sorin.idea.dto.ArrEstudioResultado;
import com.sorin.idea.dto.ArrEstudioSinusal;
import com.sorin.idea.dto.ArrEstudioSinusalPk;
import com.sorin.idea.dto.ArrEstudioSop;
import com.sorin.idea.dto.ArrEstudioSopPk;
import com.sorin.idea.dto.ArrEstudioTaqui;
import com.sorin.idea.dto.ArrEstudioTaquiPk;
import com.sorin.idea.dto.ArrEstudioVias;
import com.sorin.idea.dto.ArrEstudioViasPk;
import com.sorin.idea.dto.ArrListaEspera;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrSinusalPf;
import com.sorin.idea.dto.ArrSinusalPfPk;
import com.sorin.idea.dto.Cateter;
import com.sorin.idea.dto.CateterPk;
import com.sorin.idea.dto.Codigosgs128;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.ImpHojaImplanteEnf;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.Protocolos;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SintomasSitclinProcPk;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.SituacionClinicaProcPk;
import com.sorin.idea.exceptions.ArrAblacionComplicaDaoException;
import com.sorin.idea.exceptions.ArrEnfActDaoException;
import com.sorin.idea.exceptions.ArrEnfDaoException;
import com.sorin.idea.exceptions.ArrEnfIntroductoresDaoException;
import com.sorin.idea.exceptions.ArrEstudioAblacionDaoException;
import com.sorin.idea.exceptions.ArrEstudioCatAplDaoException;
import com.sorin.idea.exceptions.ArrEstudioCatUsoDaoException;
import com.sorin.idea.exceptions.ArrEstudioCateterDaoException;
import com.sorin.idea.exceptions.ArrEstudioDaoException;
import com.sorin.idea.exceptions.ArrEstudioEnfDaoException;
import com.sorin.idea.exceptions.ArrEstudioResultadoDaoException;
import com.sorin.idea.exceptions.ArrEstudioTaquiDaoException;
import com.sorin.idea.exceptions.CateterDaoException;
import com.sorin.idea.exceptions.ComplicacionesPacientesDaoException;
import com.sorin.idea.exceptions.SituacionClinicaGeneralDaoException;
import com.sorin.idea.jdbc.ArrAblacionComplicaDaoImpl;
import com.sorin.idea.jdbc.ArrConducPfDaoImpl;
import com.sorin.idea.jdbc.ArrConduccEcDaoImpl;
import com.sorin.idea.jdbc.ArrEnfActDaoImpl;
import com.sorin.idea.jdbc.ArrEnfDaoImpl;
import com.sorin.idea.jdbc.ArrEnfIntroductoresDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioAblacionDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioAnestDaoImpl;

import com.sorin.idea.jdbc.ArrEstudioCatAplDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioCatUsoDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioCateterDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioComplicacionesDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioConduccavDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioEcgDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioEnfDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioIntentoDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioNprocDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioPeriodoDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioPopDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioResultadoDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioSinusalDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioSopDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioTaquiDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioViasDaoImpl;
import com.sorin.idea.jdbc.ArrListaEsperaDaoImpl;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ArrSinusalPfDaoImpl;
import com.sorin.idea.jdbc.CateterDaoImpl;
import com.sorin.idea.jdbc.Codigosgs128DaoImpl;
import com.sorin.idea.jdbc.ComplicacionesPacientesDaoImpl;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ProtocolosDaoImpl;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.jdbc.SintomasSitclinProcDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.AbordajeAblaciones;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.GestorCodigoBarras;
import com.sorin.idea.util.GestorFTPInforme;
import com.sorin.idea.util.ImplanteSeguimientoBean;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilMapeos;

public class ControlEef extends BaseIU {
	protected final Integer ESTADO_REALIZADO = 3;
	protected final Integer ESTADO_ACTIVO = 1;
	private static Logger logger = Logger.getLogger(ControlEef.class);
	private LoginForm lf;
	private java.sql.Connection conn;
	private SelectorIdioma si;
	private ResourceBundle bundle;

	private ArrEstudio eef;
	private ArrayList<ArrEstudio> eefs;
	private ArrEstudio[] eeflst;
	private ArrEstudioPk eefpk;
	private ArrEstudioDao eefdao;
	private ArrEstudioDao eefdaotr;

	private String columna = "fecha";
	private boolean ascendente = false;
	private HtmlDataTable bindingBuscar;
	private HtmlDataTable binenf;
	private HtmlDataTable binpop;
	private HtmlDataTable binsop;
	private HtmlDataTable binanest;
	private HtmlDataTable binlsttaq;
	private HtmlDataTable binlstabl;
	
	private HtmlDataTable bindingHistoricoEef;

	private ControlPacientes cp;

	private ControlMaestras cm;
	private ArrMaestras[] diagnosticos;
	private ArrMaestras[] enfermeria;
	private ArrMaestras[] enfermeria_todos;
	private ArrMaestras[] primerop;
	private ArrMaestras[] primerop_todos;
	private ArrMaestras[] segundoop;
	private ArrMaestras[] segundoop_todos;
	private ArrMaestras[] anestesista;
	private ArrMaestras[] anestesista_todos;
	private ArrMaestras[] interes;
	private ArrMaestras[] navegador;
	private ArrMaestras[] robot;
	private ArrMaestras[] ecografia;
	private ArrMaestras[] ritmos;
	private ArrMaestras[] conducciones;
	private ArrMaestras[] qrs;
	private ArrMaestras[] cateteres;
	private ArrMaestras[] cateteresAblacion;
	private ArrMaestras[] funciones;
	private ArrMaestras[] localcateter;
	private ArrMaestras[] viascateter;
	private ArrMaestras[] hipersensibilidad;
	private ArrMaestras[] pruebasfs;
	private ArrMaestras[] fisiologias;
	private ArrMaestras[] conduccionnodal;
	private ArrMaestras[] farmacosav;
	private ArrMaestras[] bloqueos;
	private ArrMaestras[] nivelbloqueo;
	private ArrMaestras[] tipovia;
	private ArrMaestras[] sentidos;
	private ArrMaestras[] tipoconduccion;
	private ArrMaestras[] tipoperiodos;
	private ArrMaestras[] tejidos;
	private ArrMaestras[] farmacospr;
	private ArrMaestras[] puntoestimula;
	private ArrMaestras[] modoinduccion;
	private ArrMaestras[] induccionaavv;
	private ArrMaestras[] farmacostaqui;
	private ArrMaestras[] pruebasav;
	private ArrMaestras[] resultadosfs;
	private ArrMaestras[] resultadosav;
	private ArrMaestras[] tipoProcedimientos;
	private ArrMaestras[] morfologias;
	private ArrMaestras[] fabcat;

	private ArrEstudioEnfDao enfdao;
	private ArrEstudioEnfDao enfdaotr;
	private ArrEstudioPopDao popdao;
	private ArrEstudioPopDao popdaotr;
	private ArrEstudioSopDao sopdao;
	private ArrEstudioSopDao sopdaotr;
	private ArrEstudioAnestDao anestdao;
	private ArrEstudioAnestDao anestdaotr;
	private ArrEstudioNprocDao nprocdao;
	private ArrEstudioNprocDao nprocdaotr;
	private ArrEstudioEcgDao ecgdao;
	private ArrEstudioEcgDao ecgdaotr;
	private ArrEstudioComplicacionesDao compdao;
	private ArrEstudioComplicacionesDao compdaotr;
	private ArrEstudioIntentoDao intdao;
	private ArrEstudioIntentoDao intdaotr;
	private ArrEstudioCateterDao catdao;
	private ArrEstudioCateterDao catdaotr;
	private ArrEstudioPeriodoDao prdao;
	private ArrEstudioPeriodoDao prdaotr;
	private ArrEstudioSinusalDao sindao;
	private ArrEstudioSinusalDao sindaotr;
	private ArrSinusalPfDao sinpfdao;
	private ArrSinusalPfDao sinpfdaotr;
	private ArrEstudioViasDao viasdao;
	private ArrEstudioViasDao viasdaotr;
	private ArrEstudioConduccavDao cavdao;
	private ArrEstudioConduccavDao cavdaotr;
	private ArrConducPfDao cavpfdao;
	private ArrConducPfDao cavpfdaotr;
	private ArrConduccEcDao cavecdao;
	private ArrConduccEcDao cavecdaotr;
	private ArrEstudioTaquiDao taqdao;
	private ArrEstudioTaquiDao taqdaotr;
	private ArrEstudioAblacionDao abldao;
	private ArrEstudioAblacionDao abldaotr;
	private ArrEstudioResultadoDao resdao;
	private ArrEstudioResultadoDao resdaotr;
	private ArrAblacionComplicaDao ablcompdao;
	private ArrAblacionComplicaDao ablcompdaotr;
	private String usuario;

	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	private PacienteDao pacientedao;
	
	private Integer minutos;
	private Integer segundos;
	
	private InfoCentro infocentro;
	/**************************/
	private Procedimiento[] proclst;
	private ArrayList<Procedimiento> procs;
	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ProcedimientoDao procdao;
	private ProcedimientoDao procdaotr;
	/**************************/
	/** Registro Enfermeria ***/
	private ArrEnf enf;
	private ArrayList<ArrEnf> enfs;
	private ArrEnfPk enfpk;
	private ArrEnfDao enfermeriadao;
	private ArrEnfDao enfermeriadaotr;
	private HtmlDataTable bindingEnf;	
	private ArrEnfIntroductoresDao introdao;
	private ArrEnfIntroductoresDao introdaotr;
	private ArrEnfActDao actdao;
	private ArrEnfActDao actdaotr;
	private ArrEstudioCateterDao catdiagdao;
	private ArrEstudioCateterDao catdiagdaotr;
	/**************************/
	/** Indicacion ***/
	private SituacionClinicaProcDao sitclindao;
	private SituacionClinicaProcDao sitclindaotr;
	private SituacionClinicaProc sitclin;
	private SituacionClinicaProcPk sitclinpk;
	private HtmlDataTable bindingSintomas;
	private SituacionClinicaGeneral sgen;
	private SintomasSitclinProcDao sintdao;
	private SintomasSitclinProcDao sintdaotr;
	private boolean modsitclin;
	/**************************/
	private Cateter[] cats_abl;
	private Cateter[] cats_diag;
	private Cateter[] catdiag2;
	private Cateter[] catdiag;
	private Cateter[] cateef;
	private CateterDao cdao;
	private ArrEstudioCatUsoDao catusodao;
	private ArrEstudioCatUsoDao catusodaotr;
	private ArrEstudioCatAplDao apldao;
	private ArrEstudioCatAplDao apldaotr;
	
	private HtmlDataTable bindingCatDiag;
	private boolean modavcatdiag;
	
	private Cateter nuevocat;
	private int idviaaux;
	
	private EpisodioDao epdao;
	private EventoDao evdao;
	private boolean usaLector;
	private Codigosgs128Dao gs128dao;
	private boolean nuevocateter;
	private Integer lineanuevo;
	
	private boolean editable;
	private Integer TAQUIARR_AUR;
	
	private ControlComplicaciones cc;
	private ComplicacionesPacientesDao compacdao;
	private ComplicacionesPacientes compacDiag;
	
	private ComplicacionesPacientes currentItemComp;
	private ArrAblacionComplica currentItemAblComp;
	private HtmlDataTable bindingComplicacionesDiagProc;
	//private ArrayList<ComplicacionesPacientes> listacompldiag;
	private boolean editableProc;
	private boolean editableAblProc;
	
	private ProtocolosDao protdao;
	private ArrayList<Protocolos> listaprot;
	private HtmlDataTable bindingProt;
	
	public ControlEef() {
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			/*LoginForm loginform;
			loginform = (LoginForm) getBean("loginForm");*/
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = this.lf.getSesionUsuario().getUsuario();
			this.eef = new ArrEstudio();
			this.inicializaTiempo();
			lecturaProperties();
			//this.conn = ResourceManager.getConnection();
			this.setEditable(true);
			this.cc = (ControlComplicaciones) getBean("controlComplicaciones");
			if(this.cc == null)
				this.cc = new ControlComplicaciones();
			this.cc.inicia(null); // importante
			this.enfdao = new ArrEstudioEnfDaoImpl(this.usuario);
			this.popdao = new ArrEstudioPopDaoImpl(this.usuario);
			this.sopdao = new ArrEstudioSopDaoImpl(this.usuario);
			this.anestdao = new ArrEstudioAnestDaoImpl(this.usuario);
			this.nprocdao = new ArrEstudioNprocDaoImpl(this.usuario);
			this.ecgdao = new ArrEstudioEcgDaoImpl(this.usuario);
			this.compdao = new ArrEstudioComplicacionesDaoImpl(this.usuario);
			this.intdao = new ArrEstudioIntentoDaoImpl(this.usuario);
			this.catdao = new ArrEstudioCateterDaoImpl(this.usuario);
			this.prdao = new ArrEstudioPeriodoDaoImpl(this.usuario);
			this.sindao = new ArrEstudioSinusalDaoImpl(this.usuario);
			this.sinpfdao = new ArrSinusalPfDaoImpl(this.usuario);
			this.viasdao = new ArrEstudioViasDaoImpl(this.usuario);
			this.cavdao = new ArrEstudioConduccavDaoImpl(this.usuario);
			this.cavpfdao = new ArrConducPfDaoImpl(this.usuario);
			this.cavecdao = new ArrConduccEcDaoImpl(this.usuario);
			this.taqdao = new ArrEstudioTaquiDaoImpl(this.usuario);
			this.abldao = new ArrEstudioAblacionDaoImpl(this.usuario);
			this.resdao = new ArrEstudioResultadoDaoImpl(this.usuario);
			this.ablcompdao = new ArrAblacionComplicaDaoImpl(this.usuario);
			this.compacdao = new ComplicacionesPacientesDaoImpl(this.usuario);
			this.pacientedao = new PacienteDao();
			this.gs128dao = new Codigosgs128DaoImpl(this.usuario);
			this.episodios = new ArrayList<EpisodioDto>();
			this.bindingepi = new HtmlDataTable();
			this.cdao = new CateterDaoImpl(this.usuario);
			this.catusodao = new ArrEstudioCatUsoDaoImpl(this.usuario);
			this.apldao = new ArrEstudioCatAplDaoImpl(this.usuario);
			if(this.diagnosticos == null)
				this.cargaMaestras(null);
			this.introdao = new ArrEnfIntroductoresDaoImpl();
			this.actdao = new ArrEnfActDaoImpl();
			this.enfermeriadao = new ArrEnfDaoImpl(this.usuario);
			this.bindingEnf = new HtmlDataTable();
			this.enfs = new ArrayList<ArrEnf>();
			this.enf = new ArrEnf();
			this.nuevocat = new Cateter();
			this.sitclindao = new SituacionClinicaProcDaoImpl(this.usuario);
			this.sitclin = new SituacionClinicaProc();
			this.sintdao = new SintomasSitclinProcDaoImpl(this.usuario);
			//this.aux = new ArrayList<ArrEstudioCatDiag>();
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			this.compacDiag = new ComplicacionesPacientes();
			this.compacDiag.setFechaini(this.eef.getFecha());
			this.compacDiag.setTipo(1);
			this.protdao = new ProtocolosDaoImpl(this.usuario);
			this.listaprot = new ArrayList<Protocolos>();
			
			this.setEditableProc(false);
			this.setEditableAblProc(false);
			this.currentItemComp = new ComplicacionesPacientes();
			this.currentItemAblComp = new ArrAblacionComplica();
			//this.listacompldiag = new ArrayList<ComplicacionesPacientes>();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_carga_user")+": "+ e1.getMessage());
		}
	}

	public void iniciaEef(ActionEvent e) {
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			/*LoginForm loginform;
			loginform = (LoginForm) getBean("loginForm");*/
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = this.lf.getSesionUsuario().getUsuario();
			this.setEditable(true);
			this.proc = new Procedimiento();
			this.proc.setFecha(new Date());
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.procpk = new ProcedimientoPk();
			this.procs = new ArrayList<Procedimiento>();
			this.eef = new ArrEstudio();
			this.inicializaTiempo();
			this.enfdao = new ArrEstudioEnfDaoImpl(this.usuario);
			this.popdao = new ArrEstudioPopDaoImpl(this.usuario);
			this.sopdao = new ArrEstudioSopDaoImpl(this.usuario);
			this.anestdao = new ArrEstudioAnestDaoImpl(this.usuario);
			this.nprocdao = new ArrEstudioNprocDaoImpl(this.usuario);
			this.ecgdao = new ArrEstudioEcgDaoImpl(this.usuario);
			this.compdao = new ArrEstudioComplicacionesDaoImpl(this.usuario);
			this.intdao = new ArrEstudioIntentoDaoImpl(this.usuario);
			this.catdao = new ArrEstudioCateterDaoImpl(this.usuario);
			this.prdao = new ArrEstudioPeriodoDaoImpl(this.usuario);
			this.sindao = new ArrEstudioSinusalDaoImpl(this.usuario);
			this.sinpfdao = new ArrSinusalPfDaoImpl(this.usuario);
			this.viasdao = new ArrEstudioViasDaoImpl(this.usuario);
			this.cavdao = new ArrEstudioConduccavDaoImpl(this.usuario);
			this.cavpfdao = new ArrConducPfDaoImpl(this.usuario);
			this.cavecdao = new ArrConduccEcDaoImpl(this.usuario);
			this.taqdao = new ArrEstudioTaquiDaoImpl(this.usuario);
			this.abldao = new ArrEstudioAblacionDaoImpl(this.usuario);
			this.resdao = new ArrEstudioResultadoDaoImpl(this.usuario);
			this.eefdao = new ArrEstudioDaoImpl(this.usuario);
			this.eefpk = new ArrEstudioPk();
			this.cdao = new CateterDaoImpl(this.usuario);
			this.catusodao = new ArrEstudioCatUsoDaoImpl(this.usuario);
			this.nuevocat = new Cateter();
			this.sitclindao = new SituacionClinicaProcDaoImpl(this.usuario);
			this.sitclin = new SituacionClinicaProc();
			this.sintdao = new SintomasSitclinProcDaoImpl(this.usuario);
			this.apldao = new ArrEstudioCatAplDaoImpl(this.usuario);
			this.compacdao = new ComplicacionesPacientesDaoImpl(this.usuario);
			this.protdao = new ProtocolosDaoImpl(this.usuario);
			this.listaprot = new ArrayList<Protocolos>();
			// this.cargaMaestras();
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_error_sel_pat"));
			} else {
				this.proclst = this.procdao.findByDynamicWhere("CODIGO =? AND TIPOPROCEDIMIENTO = ?",
						new Object[] {this.cp.getPacienteSelect().getCodigo(),1061});	
				if(this.proclst != null && this.proclst.length>0){
					for(Procedimiento p:this.proclst)
						this.procs.add(p);
					// Ordenacion de array de procedimientos: orden de mayor a menor
					Collections.sort(this.procs, new Comparator() {
						public int compare(Object o1, Object o2) {
							Procedimiento e1 = (Procedimiento) o1;
							Procedimiento e2 = (Procedimiento) o2;
							if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())<=0) {
								return 1;
							} else if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())>0) {
								return -1;
							} else {
								return 0;
							}
						}
					});
					// Obtener valor de ultimo n proc si procede
					ArrEstudio ultimoEF = this.eefdao.findByPrimaryKey(this.procs.get(0).getIdprocedimiento());
					if(ultimoEF!=null){
						this.eef.getNproc().setIdproc(2); // premarcado -> Otro
						this.eef.setEefanterior(ultimoEF.getNestudio()!=null?ultimoEF.getNestudio():"");
					}
				}
				this.eefs = new ArrayList<ArrEstudio>();
				this.eef.setIdpaciente(this.cp.getPacienteSelect().getCodigo());
				
				// inicializo el número de procedimiento
				//this.eef.getNproc().setNumproc((this.eefs.size() + 1) + ""); // FRR: esto siempre da uno porque el this.eefs se inicializa a vacio siempre
				this.eef.getNproc().setNumproc((this.proclst.length + 1) + "");
				this.eef.getTaquicardidto().setNumtaqui(this.eef.getLsttaquicardias().size() + 1);
				this.eef.getAblaciondto().setSustrato(this.eef.getAblaciones().size() + 1);
				
				this.introdao = new ArrEnfIntroductoresDaoImpl();
				this.actdao = new ArrEnfActDaoImpl();
				this.enfermeriadao = new ArrEnfDaoImpl(this.usuario);
				this.bindingEnf = new HtmlDataTable();
				this.enfs = new ArrayList<ArrEnf>();
				this.enf = new ArrEnf();
				this.enf.setIdPaciente(this.cp.getPacienteSelect().getCodigo());
				//this.aux = new ArrayList<ArrEstudioCatDiag>();
				cargaCateteres();
				cargaSituacionClinica();
				
				this.cc = (ControlComplicaciones) getBean("controlComplicaciones");
				if(this.cc == null)
					this.cc = new ControlComplicaciones();
				this.cc.inicia(null); // importante
				
				this.compacDiag = new ComplicacionesPacientes();
				this.compacDiag.setFechaini(this.eef.getFecha());
				this.compacDiag.setTipo(1);
				this.setEditableProc(false);
				this.setEditableAblProc(false);
				this.currentItemComp = new ComplicacionesPacientes();
				this.currentItemAblComp = new ArrAblacionComplica();
				//this.listacompldiag = new ArrayList<ComplicacionesPacientes>();
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_pat")+": "+ e1.getMessage());
		}
	}

	public void cargaMaestras(ActionEvent e) {
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			this.diagnosticos = cm.getDiagnostico();
			this.enfermeria = cm.getEnfermeria();
			this.enfermeria_todos = cm.getEnfermeriaTodos();
			this.primerop = cm.getPrimerOperador();
			this.primerop_todos = cm.getPrimerOperadorTodos();
			this.segundoop = cm.getSegundoOperador();
			this.segundoop_todos = cm.getSegundoOperadorTodos();
			this.anestesista = cm.getAnestesista();
			this.anestesista_todos = cm.getAnestesistaTodos();
			this.interes = cm.getInteresCientifico();
			this.navegador = cm.getNavegador();
			this.robot = cm.getRobot();
			this.ecografia = cm.getEcografiaIntracardiaca();
			this.ritmos = cm.getRitmoSinusal();
			this.conducciones = cm.getConduccionNoNormal();
			this.qrs = cm.getQrsNoNormal();
			this.cateteres = cm.getCateteres();
			this.cateteresAblacion = cm.getCateteresAblacion();
			this.funciones = cm.getFuncion();
			this.localcateter = cm.getLocalizacion();
			this.viascateter = cm.getViaAcceso();
			this.hipersensibilidad = cm.getHipersensibilidad();
			this.pruebasfs = cm.getPruebasFarmacologicasFS();
			this.fisiologias = cm.getFisiologiaDobleVia();
			this.conduccionnodal = cm.getConduccionNodal();
			this.farmacosav = cm.getFarmacosAV();
			this.bloqueos = cm.getBloqueo();
			this.nivelbloqueo = cm.getNivelBloqueo();
			this.tipovia = cm.getTipoVia();
			this.sentidos = cm.getSentidoConduccion();
			this.tipoconduccion = cm.getTipoConduccion();
			this.tipoperiodos = cm.getTipoPeriodo();
			this.tejidos = cm.getTejidos();
			this.farmacospr = cm.getFarmacosPR();
			this.puntoestimula = cm.getPuntoEstimulacion();
			this.modoinduccion = cm.getModoInduccion();
			this.induccionaavv = cm.getInduccionAAVV();
			this.farmacostaqui = cm.getFarmacosTAQ();
			this.pruebasav = cm.getPruebasAV();
			this.resultadosfs = cm.getResultadosFS();
			this.resultadosav = cm.getResultadosAV();
			this.tipoProcedimientos = cm.getTipoProcedimientos();
			this.morfologias = cm.getMorfologias();
			this.fabcat = cm.getFabricanteCateter();
			this.obtenerTaquiarritmiaAur();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
	}

	public void obtenerTaquiarritmiaAur(){
		for(ArrMaestras am:this.diagnosticos)
			if(am.getValor().toUpperCase().equals("TAQUIARRITMIA AURICULAR"))
				this.setTAQUIARR_AUR(am.getCodigo());
	}
	
	public void cambiaDiagnostico(ActionEvent e){
		if(!this.eef.getDiagnostico().equals(this.TAQUIARR_AUR)){
			this.eef.setTipoDiag1(null);
			this.eef.setTipoDiag2(null);
		}
	}
	
	public void cargaCateteres(){
		try{
			this.cats_diag = this.cdao.findWhereTipoEquals(1);
			this.cats_abl = this.cdao.findWhereTipoEquals(2);
			this.catdiag2 = this.cdao.findAll();
			this.catdiag = this.cdao.findWhereActivoEquals(1);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_dmaestras_cats")+": "+ e1.getMessage());
		}
	}
	
	public void cargaUltimoEEF() {
		this.eef = this.eefs.get(0);
		this.eefpk = this.eef.createPk();
		cargaComponentes();
	}

	public void cargaEstudio_OLD(ActionEvent e) {
		Integer fila = this.bindingBuscar.getRowIndex();
		this.eef = this.eefs.get(fila);
		this.eefpk = this.eef.createPk();
		cargaComponentes();
	}
	public void cargaEstudio(ActionEvent e) {
		try{
			//Integer fila = this.bindingBuscar.getRowIndex();
			this.proc = this.procs.get(this.bindingBuscar.getRowIndex());
			this.procpk = this.proc.createPk();
			this.eef = this.eefdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.eefpk = this.eef.createPk();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			cargaComponentes();
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
		}
	}
	public void cargaEstudioDesdeBarraTemporal(ActionEvent e) {
		try{
			//Integer fila = this.bindingBuscar.getRowIndex();
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),1061})[0];
			this.procpk = this.proc.createPk();
			this.eef = this.eefdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.eefpk = this.eef.createPk();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			cargaComponentes();
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			logger.info("("+this.usuario+") Consulta de registro (EEF). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (EEF) ID:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}
	}
	public void cargaEstudioConsulta(ActionEvent e){
		try{
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getPacienteSelect().getIdeef(),1061})[0];
			this.procpk = this.proc.createPk();
			this.eef = this.eefdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.eefpk = this.eef.createPk();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			cargaComponentes();
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			logger.info("("+this.usuario+") Consulta de registro (EEF). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (EEF) ID:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}
	}
	public void cargaEstudioProtocolo(Integer idproc){
		try{
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {idproc,1061})[0];
			this.procpk = this.proc.createPk();
			this.eef = this.eefdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.eefpk = this.eef.createPk();
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			cargaComponentes();
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			logger.info("("+this.usuario+") Consulta de registro (EEF). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (EEF) ID:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}
	}
	public void nuevoEstudio(ActionEvent e) {
		this.eef = new ArrEstudio();
		this.eef.setIdpaciente(this.cp.getPacienteSelect().getCodigo());
		this.eefpk = new ArrEstudioPk();
		this.sitclin = new SituacionClinicaProc();
		this.cargaSituacionClinica();	
	}

	public void preguardaEstudio(ActionEvent e) {
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
				if(ev!=null && ev.getProcedimiento()==1061 && ev.getEstado()==1 && proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));
			}
		} catch (Exception e1) {
			this.pintaMensaje(3,
					this.bundle.getString("info_msg_error_carga_epi")+": "+ e1.getMessage());
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

	public void guardaEstudio(ActionEvent e) {
		try {
			conn = ResourceManager.getConnection();
			this.eefdaotr = new ArrEstudioDaoImpl(conn,this.usuario);
			this.ecgdaotr = new ArrEstudioEcgDaoImpl(conn,this.usuario);
			this.enfdaotr = new ArrEstudioEnfDaoImpl(conn,this.usuario);
			this.popdaotr = new ArrEstudioPopDaoImpl(conn,this.usuario);
			this.sopdaotr = new ArrEstudioSopDaoImpl(conn,this.usuario);
			this.anestdaotr = new ArrEstudioAnestDaoImpl(conn,this.usuario);
			this.nprocdaotr = new ArrEstudioNprocDaoImpl(conn,this.usuario);
			this.compdaotr = new ArrEstudioComplicacionesDaoImpl(conn,this.usuario);
			this.intdaotr = new ArrEstudioIntentoDaoImpl(conn,this.usuario);
			this.abldaotr = new ArrEstudioAblacionDaoImpl(conn,this.usuario);
			this.ablcompdaotr = new ArrAblacionComplicaDaoImpl(conn,this.usuario);
			this.resdaotr = new ArrEstudioResultadoDaoImpl(conn,this.usuario);
			this.prdaotr = new ArrEstudioPeriodoDaoImpl(conn,this.usuario);
			this.sindaotr = new ArrEstudioSinusalDaoImpl(conn,this.usuario);
			this.sinpfdaotr = new ArrSinusalPfDaoImpl(conn,this.usuario);
			this.viasdaotr = new ArrEstudioViasDaoImpl(conn,this.usuario);
			this.cavdaotr = new ArrEstudioConduccavDaoImpl(conn,this.usuario);
			this.cavpfdaotr = new ArrConducPfDaoImpl(conn,this.usuario);
			this.cavecdaotr = new ArrConduccEcDaoImpl(conn,this.usuario);
			this.taqdaotr = new ArrEstudioTaquiDaoImpl(conn,this.usuario);
			this.catusodaotr = new ArrEstudioCatUsoDaoImpl(conn,this.usuario);
			this.procdaotr = new ProcedimientoDaoImpl(conn,this.usuario);
			this.sitclindaotr = new SituacionClinicaProcDaoImpl(conn,this.usuario);
			this.sintdaotr = new SintomasSitclinProcDaoImpl(conn,this.usuario);
			this.introdaotr = new ArrEnfIntroductoresDaoImpl(conn);
			this.actdaotr = new ArrEnfActDaoImpl(conn);
			this.enfermeriadaotr = new ArrEnfDaoImpl(conn, this.usuario);
			
			conn.setAutoCommit(false);
			Integer epi = this.bindingepi.getRowIndex();
			if(epi != null && epi >= 0){
				this.eef.setEpisodio(this.episodios.get(epi).getNumicu());
				this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());
			}				
			preparaHoras();
			boolean existe = false;
			if (this.eef.getDiagnostico() == null || this.eef.getFecha() == null) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_guarda_1"));
			}else if(!validaFormulario()){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_guarda_2"));			
			}else if(!validarCateteresDiagnosticos()){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_guarda_2"));			
			} else {
				if (this.eef.getNestudio() == null || this.eef.getNestudio().length() != 5)
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("info_msg_guarda_error_nproc")+" " + ((this.eef.getFecha().getYear() + 1900) + "").substring(2) + " "+this.bundle.getString("info_msg_guarda_error_nproc_1"));
				else {
					ArrEstudio[] ests = this.eefdao.findByDynamicWhere(" nestudio = ?", new Object[] { this.eef.getNestudio() });
					if (ests != null && ests.length > 0)
						if (this.eef.getIdestudio() == null) {
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_nproc_prev"));
							existe = true;
						} else if (!ests[0].getIdestudio().equals(this.eef.getIdestudio())) {
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_nproc_prev"));
							existe = true;
						}
					if((this.eef.getDiagnostico() < 1 && (this.lf.getAcceso().getIdrolacceso()==1 || this.lf.getAcceso().getIdrolacceso()==2)))
						this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_guarda_3"));
					if (!existe) {
						if (this.eefpk != null && this.eefpk.getIdestudio() != null) {
							this.proc.setFecha(this.eef.getFecha());
							this.procdaotr.update(this.proc.createPk(), this.proc);
							this.eefdaotr.update(this.eefpk, this.eef);
							this.sitclindaotr.update(this.sitclin.createPk(), this.sitclin);
							this.guardaComponentes();
							this.guardaEnf();
							this.guardaComponentesSitClin();
							modificaSituacionClinicaGeneral();
							//escribeEnClinica(false);
							// Operacion para actualizar la barra temporal de paciente
							//cp.precarga(null);
							this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
							this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
							logger.info("("+this.usuario+") Registro de Estudio EF actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
						} else {
							this.eefpk = this.eefdaotr.insert(this.eef);
							this.eef.setIdestudio(this.eefpk.getIdestudio());
							this.sitclinpk = this.sitclindaotr.insert(this.sitclin);
							this.sitclin.setIdsitclin(this.sitclinpk.getIdsitclin());
							this.guardaComponentes();
							this.guardaEnf();
							this.guardaComponentesSitClin();
							modificaSituacionClinicaGeneral();
							//escribeEnClinica(true);
							//cp.precarga(null);
							this.proc.setFecha(this.eef.getFecha());
							this.proc.setIdprocedimiento(this.eef.getIdestudio());
							this.proc.setTipoprocedimiento(1061);
							this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
							this.proc.setIdsitclinica(this.sitclin.getIdsitclin());
							this.procpk = this.procdaotr.insert(this.proc);
							this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
							logger.info("("+this.usuario+") Registro de Estudio EF insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
						}
						ArrEnfDao enfdao = new ArrEnfDaoImpl(this.usuario);
						ArrEnf[] enfermerias = enfdao
								.findByDynamicWhere("FECHA = STR_TO_DATE('" + UtilFechas
								.dateToString(this.eef.getFecha())
								+ "','%d/%m/%Y') AND ID_PACIENTE = ? AND ID_EEF IS NULL",
								new Object[] { this.eef.getIdpaciente() });
						if (enfermerias != null && enfermerias.length > 0) {
							ArrEnf enf = enfermerias[0];
							enf.setIdeef(this.eef.getIdestudio());
							enfdao.update(enf.createPk(), enf);
							this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("eef_msg_info_guarda_regenf"));
							//logger.info("Registro de enfermería actualizado con el número de estudio");
						}
						//ArrListaEsperaDao ledao = new ArrListaEsperaDaoImpl(this.usuario);
						ArrListaEsperaDao ledao = new ArrListaEsperaDaoImpl(conn,this.usuario);
						ArrListaEspera[] les = ledao.findWhereCodigoPacienteEquals(this.eef.getIdpaciente());
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
							this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("eef_msg_info_edit_le"));
						}
						conn.commit();
					}
				}
			}
		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_guarda_error_exep")+": " + ex.getMessage());
			logger.error("("+this.usuario+") No se ha podido guardar el estudio: " + ex.getMessage(),ex);
			if(conn!=null){
				try{
					conn.rollback();
				}catch(Exception e2){
					logger.error("("+this.usuario+") No se ha podido guardar el estudio. Error: "+ ex.getMessage());	
				}
			}
		} finally{
			try{
				if(conn!=null)
					conn.close();
			}catch(Exception e1){
				logger.error("("+this.usuario+") No se ha podido guardar el estudio. Error: "+ e1.getMessage());	
			}
		}
	}

	private void guardaComponentesSitClin() throws Exception {
		sintdaotr.delete(new SintomasSitclinProcPk(this.sitclin.getIdsitclin(), null));
		// validar que no haya de valor 0
		for (SintomasSitclinProc sint : this.sitclin.getSintomas()) {
			if (sint.getIdsintomas() != null && sint.getIdsintomas().length() > 0) {
				sint.setIdsitclin(this.sitclin.getIdsitclin());
				sintdaotr.insert(sint);
			}
		}
		this.sitclin.setFecha(this.eef.getFecha());
	}
	
	private void preparaHoras() {
		// Validador de horas?
		if(!this.eef.getHllegadah().equals("") && !this.eef.getHllegadam().equals(""))
			this.eef.setHllegada(UtilFechas.adaptaHoras(this.eef.getHllegadah()) + UtilFechas.adaptaHoras(this.eef.getHllegadam()));
		if(!this.eef.getHablacionh().equals("") && !this.eef.getHablacionm().equals(""))
			this.eef.setHablacion(UtilFechas.adaptaHoras(this.eef.getHablacionh()) + UtilFechas.adaptaHoras(this.eef.getHablacionm()));
		if(!this.eef.getHpuncionh().equals("") && !this.eef.getHpuncionm().equals(""))
			this.eef.setHpuncion(UtilFechas.adaptaHoras(this.eef.getHpuncionh()) + UtilFechas.adaptaHoras(this.eef.getHpuncionm()));
		if(!this.eef.getHcateterh().equals("") && !this.eef.getHcateterm().equals(""))
			this.eef.setHcateter(UtilFechas.adaptaHoras(this.eef.getHcateterh()) + UtilFechas.adaptaHoras(this.eef.getHcateterm()));
		if(!this.eef.getHsalidah().equals("") && !this.eef.getHsalidam().equals(""))
			this.eef.setHsalida(UtilFechas.adaptaHoras(this.eef.getHsalidah()) + UtilFechas.adaptaHoras(this.eef.getHsalidam()));	
	}

	private void cargaComponentes() {
		try {			
			cargaDatosSitClin();
			ArrEstudioEnf[] enfermeras = enfdao.findWhereIdestudioEquals(this.eef.getIdestudio());
			ArrayList<ArrEstudioEnf> enfarray = new ArrayList<ArrEstudioEnf>();
			for (ArrEstudioEnf enf : enfermeras){
				enf.setLectura(1);
				enfarray.add(enf);
			}
			this.eef.setEnfermeras(enfarray);

			ArrEstudioPop[] pops = popdao.findWhereIdestudioEquals(this.eef.getIdestudio());
			ArrayList<ArrEstudioPop> poparray = new ArrayList<ArrEstudioPop>();
			for (ArrEstudioPop pop : pops){
				pop.setLectura(1);
				poparray.add(pop);
			}	
			this.eef.setPoperador(poparray);

			ArrEstudioSop[] sops = sopdao.findWhereIdestudioEquals(this.eef.getIdestudio());
			ArrayList<ArrEstudioSop> soparray = new ArrayList<ArrEstudioSop>();
			for (ArrEstudioSop sop : sops){
				sop.setLectura(1);
				soparray.add(sop);
			}
			this.eef.setSoperador(soparray);
			
			ArrEstudioAnest[] anests = anestdao.findWhereIdestudioEquals(this.eef.getIdestudio());
			ArrayList<ArrEstudioAnest> anestarray = new ArrayList<ArrEstudioAnest>();
			for (ArrEstudioAnest an : anests){
				an.setLectura(1);
				anestarray.add(an);
			}
			this.eef.setAnest(anestarray);
			
			this.eef.setNproc(nprocdao.findByPrimaryKey(this.eef.getIdestudio()));

			if (this.eef.getEcgb())
				this.eef.setEcgdto(ecgdao.findByPrimaryKey(this.eef.getIdestudio()));
			if (this.eef.getEcgdto() == null)
				this.eef.setEcgdto(new ArrEstudioEcg());
			if (this.eef.getComplicacionesb()){
				this.eef.setComplicacionesdto(compdao.findByPrimaryKey(this.eef.getIdestudio()));
				// Carga complicaciones diagnosticas
				cc.obtenerComplicacionesPacienteProc(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
				for(ComplicacionesPacientes cpac:cc.getListacompacproc())
					if(cpac.getIdrelacion().equals(7))
						this.eef.getComplicacionesdto().getListacompldiag().add(cpac);
			}
				
			if (this.eef.getComplicacionesdto() == null)
				this.eef.setComplicacionesdto(new ArrEstudioComplicaciones());
			if (this.eef.getAblacion() == 1)
				this.eef.setIntentodto(intdao.findByPrimaryKey(this.eef.getIdestudio()));
			if (this.eef.getIntentodto() == null)
				this.eef.setIntentodto(new ArrEstudioIntento());

			/*if (this.eef.getCateteresb()) {
				ArrEstudioCateter[] cats = catdao
						.findWhereIdestudioEquals(this.eef.getIdestudio());
				ArrayList<ArrEstudioCateter> catarray = new ArrayList<ArrEstudioCateter>();
				for (ArrEstudioCateter cat : cats)
					catarray.add(cat);
				this.eef.setCateterdto(catarray);
			}
			if (this.eef.getCateterdto() == null)
				this.eef.setCateterdto(new ArrayList<ArrEstudioCateter>());
*/
			if (this.eef.getPeriodosb()) {
				ArrEstudioPeriodo[] prs = prdao.findWhereIdestudioEquals(this.eef.getIdestudio());
				ArrayList<ArrEstudioPeriodo> prarray = new ArrayList<ArrEstudioPeriodo>();
				for (ArrEstudioPeriodo pr : prs)
					prarray.add(pr);
				this.eef.setPeriodosdto(prarray);
			}
			if (this.eef.getPeriodosdto() == null)
				this.eef.setPeriodosdto(new ArrayList<ArrEstudioPeriodo>());

			if (this.eef.getSinusalb()) {
				this.eef.setSinusaldto(sindao.findByPrimaryKey(this.eef.getIdestudio()));
				if (this.eef.getSinusaldto() != null) {
					ArrSinusalPf[] sins = sinpfdao.findWhereIdfuncionEquals(this.eef.getIdestudio());
					ArrayList<ArrSinusalPf> sinarray = new ArrayList<ArrSinusalPf>();
					for (ArrSinusalPf sin : sins)
						sinarray.add(sin);
					this.eef.getSinusaldto().setPruebas(sinarray);
				}
			}
			if (this.eef.getSinusaldto() == null)
				this.eef.setSinusaldto(new ArrEstudioSinusal());

			if (this.eef.getViasb()) {
				ArrEstudioVias[] vias = viasdao.findWhereIdestudioEquals(this.eef.getIdestudio());
				ArrayList<ArrEstudioVias> viaarray = new ArrayList<ArrEstudioVias>();
				for (ArrEstudioVias via : vias)
					viaarray.add(via);
				this.eef.setViasdto(viaarray);
			}
			if (this.eef.getViasdto() == null)
				this.eef.setViasdto(new ArrayList<ArrEstudioVias>());

			if (this.eef.getConduccionb()) {
				this.eef.setConducciondto(cavdao.findByPrimaryKey(this.eef.getIdestudio()));
				if (this.eef.getConducciondto() != null) {
					ArrConducPf[] pfcs = cavpfdao.findWhereIdconduccavEquals(this.eef.getIdestudio());
					ArrayList<ArrConducPf> pfcsarray = new ArrayList<ArrConducPf>();
					for (ArrConducPf pfc : pfcs)
						pfcsarray.add(pfc);
					this.eef.getConducciondto().setPruebas(pfcsarray);
					ArrConduccEc[] ecs = cavecdao.findWhereIdconduccavEquals(this.eef.getIdestudio());
					ArrayList<ArrConduccEc> ecsarray = new ArrayList<ArrConduccEc>();
					for (ArrConduccEc ec : ecs)
						ecsarray.add(ec);
					this.eef.getConducciondto().setEstim(ecsarray);
				}
			}
			if (this.eef.getConducciondto() == null)
				this.eef.setConducciondto(new ArrEstudioConduccav());

			if (this.eef.getTaquicardiasb())
				this.verTaqui(null);
			if (this.eef.getLsttaquicardias() != null && this.eef.getLsttaquicardias().size() > 0) {
				this.eef.setTaquicardidto(this.eef.getLsttaquicardias().get(0));
			} else {
				this.eef.setTaquicardidto(new ArrEstudioTaqui());
				this.eef.getTaquicardidto().setNumtaqui(this.eef.getLsttaquicardias().size() + 1);
			}

			// Carga cateteres 
			ArrEstudioCatUso[] cats;
			cats = catusodao.findWhereIdeefEquals(this.eef.getIdestudio());
			ArrayList<ArrEstudioCatUso> catdiagarray = new ArrayList<ArrEstudioCatUso>();
			ArrayList<Cateter> cateef = new ArrayList<Cateter>();
			for(ArrEstudioCatUso cat : cats){
				Cateter c = cdao.findByPrimaryKey(cat.getIdcateter());
				cat.setModelo(c.getModelo());
				cat.setTipo(c.getTipo());
				cat.setMuestrabarcode(false);
				cat.setEnergia(c.getEnergia()!=null?c.getEnergia():0);
				catdiagarray.add(cat);
				if(cat.getTipo()==2)
					cateef.add(c);
			}				
			this.eef.setListacats(catdiagarray);
			if(this.eef.getListacats() == null)
				this.eef.setListacats(new ArrayList<ArrEstudioCatUso>());
			this.eef.setAux(cateef);
			
			if (this.eef.getAblacion() == 2)
				this.verAblacion(null);
			if (this.eef.getAblaciones() != null && this.eef.getAblaciones().size() > 0) {
				this.eef.setAblaciondto(this.eef.getAblaciones().get(0));
				this.eef.getAblaciondto().getCompacAbl().setFechaini(this.eef.getFecha());
				//this.eef.setResultadodto(this.eef.getResultados().get(this.eef.getResultados().size() - 1));
			} else {
				this.eef.setAblaciondto(new ArrEstudioAblacion());
				//this.eef.setResultadodto(new ArrEstudioResultado());
				this.eef.getAblaciondto().setSustrato(this.eef.getAblaciones().size() + 1);
				this.eef.getAblaciondto().getCompacAbl().setFechaini(this.eef.getFecha());
				//this.eef.getResultadodto().setSustrato(this.eef.getAblaciones().size() + 1);
			}
			
			// Carga de Registro de enfermeria
			this.enf = this.enfermeriadao.findWhereIdEefEquals(this.eef.getIdestudio());
			// control de nulo 
			if(this.enf!=null){
				this.enfpk = this.enf.createPk();
				ArrEnfIntroductores[] introductores;
				ArrEnfAct[] acts;
				//ArrEstudioCateter[] cats;
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
			}else{
				this.enf = new ArrEnf();
				this.enf.setIdPaciente(this.cp.getPacienteSelect().getCodigo());
			}
			/*cats = catdao.findWhereIdenfermeriaEquals(this.enf.getIdRegistro());
			ArrayList<ArrEstudioCateter> catarray = new ArrayList<ArrEstudioCateter>();
			for (ArrEstudioCateter cat : cats)
				catarray.add(cat);
			this.enf.setCats(catarray);
			if (this.enf.getCats() == null)
				this.enf.setCats(new ArrayList<ArrEstudioCateter>());*/
			// 7. Inicializacion de complicaciones
			this.compacDiag.setFechaini(this.eef.getFecha());
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_carga_reg")+": "+ e.getMessage());
		}
	}
	private void cargaDatosSitClin(){
		try{
			this.sitclin = this.sitclindao.findByPrimaryKey(this.proc.getIdsitclinica());
			this.sitclinpk = this.sitclin.createPk();
			// 2.1 Sintomas
			SintomasSitclinProc[] sints = sintdao.findWhereIdsitclinEquals(this.proc.getIdsitclinica());
			ArrayList<SintomasSitclinProc> sintarray = new ArrayList<SintomasSitclinProc>();
			for (SintomasSitclinProc s : sints)
				sintarray.add(s);
			this.sitclin.setSintomas(sintarray);
			// 2.3 Precarga IC si existe
			this.sitclin.setIc(this.sitclin.getNyha() != null ? true : false);
			// 2.4 Cardiopatia
			this.sitclin.setCardiop(this.sitclin.getCardiopatia()!=null?true:false);
			// 2.4 Cardiopatia Revascularizacion
			this.sitclin.setRevascularizacion(this.sitclin.getRevasc() != null
					&& this.sitclin.getRevasc() == 1 ? true : false);
			// 2.5 Cardiopatia Infarto Previo
			this.sitclin.setInfartoprev(this.sitclin.getInfprevio() != null
					&& this.sitclin.getInfprevio() == 1 ? true : false);
			// 2.6 Antecedentes - Arritmias Ventriculares
			this.sitclin.setAvent(this.sitclin.getArritmias() != null
					&& this.sitclin.getArritmias() >= 1 ? true : false);
			// 2.7 Antecedentes - EEF Previo
			this.sitclin.setEefprev(this.sitclin.getEef() != null
					&& this.sitclin.getEef() >= 1 ? true : false);
			// 2.8 Antecedentes booleanos
			cargaAntecedentes();
		}catch(Exception e){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_sitclin_rec")+": "+ e.getMessage());
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
		this.sitclin.setAnteflutter((this.sitclin.getFlutter() != null) && (this.sitclin.getFlutter() == 1) ? true : false);
	}
	
	private void guardaComponentes() throws Exception {
		enfdaotr.delete(new ArrEstudioEnfPk(this.eef.getIdestudio()));
		for (ArrEstudioEnf enfermera : this.eef.getEnfermeras()) {
			if(enfermera.getIdenfermera() != null && enfermera.getIdenfermera().length() > 0){
				enfermera.setIdestudio(this.eef.getIdestudio());
				enfdaotr.insert(enfermera);
			}			
		}

		popdaotr.delete(new ArrEstudioPopPk(this.eef.getIdestudio()));
		for (ArrEstudioPop operador : this.eef.getPoperador()) {
			if(operador.getIdoperador() != null && operador.getIdoperador().length() > 0){
				operador.setIdestudio(this.eef.getIdestudio());
				popdaotr.insert(operador);
			}
		}

		sopdaotr.delete(new ArrEstudioSopPk(this.eef.getIdestudio()));
		for (ArrEstudioSop operador : this.eef.getSoperador()) {
			if(operador.getIdoperador() != null && operador.getIdoperador().length() > 0){
				operador.setIdestudio(this.eef.getIdestudio());
				sopdaotr.insert(operador);
			}
		}

		anestdaotr.delete(new ArrEstudioAnestPk(this.eef.getIdestudio()));
		for (ArrEstudioAnest operador : this.eef.getAnest()) {
			if(operador.getIdanestesista() != null && operador.getIdanestesista().length() > 0){
				operador.setIdestudio(this.eef.getIdestudio());
				anestdaotr.insert(operador);
			}
		}
		
		if (this.eef.getNproc().getIdestudio() == null) {
			this.eef.getNproc().setIdestudio(this.eef.getIdestudio());
			nprocdaotr.insert(this.eef.getNproc());
		} else {
			nprocdaotr.update(new ArrEstudioNprocPk(this.eef.getIdestudio()),	this.eef.getNproc());
		}

		if (this.eef.getEcgb()) {
			if (this.eef.getEcgdto().getIdestudio() == null) {
				this.eef.getEcgdto().setIdestudio(this.eef.getIdestudio());
				ecgdaotr.insert(this.eef.getEcgdto());
			} else {
				ecgdaotr.update(new ArrEstudioEcgPk(this.eef.getIdestudio()), this.eef.getEcgdto());
			}
		}else
			ecgdaotr.delete(new ArrEstudioEcgPk(this.eef.getIdestudio()));

		if (this.eef.getComplicacionesb()) {
			if (this.eef.getComplicacionesdto().getIdestudio() == null) {
				this.eef.getComplicacionesdto().setIdestudio(this.eef.getIdestudio());
				compdaotr.insert(this.eef.getComplicacionesdto());
			} else {
				compdaotr.update(new ArrEstudioComplicacionesPk(this.eef.getIdestudio()), this.eef.getComplicacionesdto());
			}
		}else
			compdaotr.delete(new ArrEstudioComplicacionesPk(this.eef.getIdestudio()));

		if (this.eef.getAblacion() == 1) {
			if (this.eef.getIntentodto().getIdestudio() == null) {
				this.eef.getIntentodto().setIdestudio(this.eef.getIdestudio());
				intdaotr.insert(this.eef.getIntentodto());
			} else {
				intdaotr.update(new ArrEstudioIntentoPk(this.eef.getIdestudio()),	this.eef.getIntentodto());
			}
			ablcompdaotr.delete(this.eef.getIdestudio());
			resdaotr.delete(this.eef.getIdestudio());
			abldaotr.delete(this.eef.getIdestudio());
			
		}

		if (this.eef.getPeriodosb()) {
			this.prdaotr.delete(new ArrEstudioPeriodoPk(this.eef.getIdestudio()));
			for (ArrEstudioPeriodo pr : this.eef.getPeriodosdto()) {
				pr.setIdestudio(this.eef.getIdestudio());
				prdaotr.insert(pr);
			}
		}else
			prdaotr.delete(new ArrEstudioPeriodoPk(this.eef.getIdestudio()));

		if (this.eef.getSinusalb()) {
			if (this.eef.getSinusaldto().getIdestudio() == null) {
				this.eef.getSinusaldto().setIdestudio(this.eef.getIdestudio());
				sindaotr.insert(this.eef.getSinusaldto());
				sinpfdaotr.delete(new ArrSinusalPfPk(this.eef.getIdestudio()));
				for (ArrSinusalPf prueba : this.eef.getSinusaldto().getPruebas()) {
					prueba.setIdfuncion(this.eef.getIdestudio());
					sinpfdaotr.insert(prueba);
				}
			} else {
				sindaotr.update(new ArrEstudioSinusalPk(this.eef.getIdestudio()), this.eef.getSinusaldto());
				sinpfdaotr.delete(new ArrSinusalPfPk(this.eef.getIdestudio()));
				for (ArrSinusalPf prueba : this.eef.getSinusaldto().getPruebas()) {
					prueba.setIdfuncion(this.eef.getIdestudio());
					sinpfdaotr.insert(prueba);
				}
			}
		}else{
			sinpfdaotr.delete(new ArrSinusalPfPk(this.eef.getIdestudio()));
			sindaotr.delete(new ArrEstudioSinusalPk(this.eef.getIdestudio()));
		}

		if (this.eef.getViasb()) {
			viasdaotr.delete(new ArrEstudioViasPk(this.eef.getIdestudio()));
			for (ArrEstudioVias via : this.eef.getViasdto()) {
				via.setIdestudio(this.eef.getIdestudio());
				viasdaotr.insert(via);
			}
		}else
			viasdaotr.delete(new ArrEstudioViasPk(this.eef.getIdestudio()));

		if (this.eef.getConduccionb()) {
			if (this.eef.getConducciondto().getIdestudio() == null) {
				this.eef.getConducciondto().setIdestudio(this.eef.getIdestudio());
				cavdaotr.insert(this.eef.getConducciondto());
				cavpfdaotr.delete(new ArrConducPfPk(this.eef.getIdestudio()));
				cavecdaotr.delete(new ArrConduccEcPk(this.eef.getIdestudio()));
				for (ArrConducPf prueba : this.eef.getConducciondto().getPruebas()) {
					prueba.setIdconduccav(this.eef.getIdestudio());
					cavpfdaotr.insert(prueba);
				}
				for (ArrConduccEc estim : this.eef.getConducciondto().getEstim()) {
					estim.setIdconduccav(this.eef.getIdestudio());
					cavecdaotr.insert(estim);
				}
			} else {
				cavdaotr.update(new ArrEstudioConduccavPk(this.eef.getIdestudio()), this.eef.getConducciondto());
				cavpfdaotr.delete(new ArrConducPfPk(this.eef.getIdestudio()));
				cavecdaotr.delete(new ArrConduccEcPk(this.eef.getIdestudio()));
				for (ArrConducPf prueba : this.eef.getConducciondto().getPruebas()) {
					prueba.setIdconduccav(this.eef.getIdestudio());
					cavpfdaotr.insert(prueba);
				}
				for (ArrConduccEc estim : this.eef.getConducciondto().getEstim()) {
					estim.setIdconduccav(this.eef.getIdestudio());
					cavecdaotr.insert(estim);
				}
			}
		}else{
			cavecdaotr.delete(new ArrConduccEcPk(this.eef.getIdestudio()));
			cavpfdaotr.delete(new ArrConducPfPk(this.eef.getIdestudio()));
			cavdaotr.delete(new ArrEstudioConduccavPk(this.eef.getIdestudio()));
		}

		if (this.eef.getTaquicardiasb()) {
			if (this.eef.getTaquicardidto().getIdtaqui() == null) {
				this.eef.getTaquicardidto().setIdestudio(this.eef.getIdestudio());
				ArrEstudioTaquiPk taqpk = new ArrEstudioTaquiPk();
				taqpk = taqdaotr.insert(this.eef.getTaquicardidto());
				this.eef.getTaquicardidto().setIdtaqui(taqpk.getIdtaqui());
				this.eef.getLsttaquicardias().add(this.eef.getTaquicardidto());
			} else {
				taqdaotr.update(this.eef.getTaquicardidto().createPk(), this.eef.getTaquicardidto());
			}
		}else
			taqdaotr.delete(this.eef.getIdestudio());

		this.guardaCateteresEef();
		
		if (this.eef.getAblacion() == 2) {
			if(this.eef.getAblaciondto().getSustrato()!=null && this.eef.getAblaciondto().getSustrato()>0
					&& this.eef.getAblaciondto().getResultadodto().getIdres()!=null && this.eef.getAblaciondto().getResultadodto().getIdres()>0){
				boolean apls = true; // control de aplicaciones
				if(this.eef.getAblaciondto().getIdnodo()!=null && this.eef.getAblaciondto().getIdnodo()>=1){
					if(this.eef.getAblaciondto().getLista()!=null && this.eef.getAblaciondto().getLista().size()>0 ){
						for(AbordajeAblaciones abor:this.eef.getAblaciondto().getLista()){
							if(abor.getListacats()!=null && abor.getListacats().size()>0){
								for(ArrEstudioCatApl apl:abor.getListacats())
									if(apl.getIdcatuso()==null || apl.getIdcatuso().equals("")){
										this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_apls_cats"));
										apls = false;
										break;
									}
							}else{
								this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_cats_via_abord_noinfo_2"));
								apls = false;
								break;
							}
						}
					}else{
						this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_cats_via_abord_noinfo"));
						apls = false;
					}
				}
				if(apls){
					if (this.eef.getAblaciondto().getIdablacion() == null) {
						this.eef.getAblaciondto().setIdestudio(this.eef.getIdestudio());
						ArrEstudioAblacionPk ablpk = new ArrEstudioAblacionPk();
						ablpk = abldaotr.insert(this.eef.getAblaciondto());
						this.eef.getAblaciondto().setIdablacion(ablpk.getIdablacion());
						this.eef.getAblaciondto().getResultadodto().setIdestudio(this.eef.getIdestudio());
						this.eef.getAblaciondto().getResultadodto().setIdablacion(ablpk.getIdablacion());
						resdaotr.insert(this.eef.getAblaciondto().getResultadodto());
						this.eef.getAblaciones().add(this.eef.getAblaciondto());
					} else {
						abldaotr.update(this.eef.getAblaciondto().createPk(),this.eef.getAblaciondto());
						resdaotr.update(this.eef.getAblaciondto().getResultadodto().createPk(),this.eef.getAblaciondto().getResultadodto());
						for(ArrAblacionComplica comps:this.eef.getAblaciondto().getListacomplicacion())
							ablcompdaotr.update(comps.createPk(),comps);
					}
				}
			}else{
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_guarda_abl_sust_res"));
			}
			intdaotr.delete(new ArrEstudioIntentoPk(this.eef.getIdestudio()));
		}
		//this.guardaCateteresEef();
	}
	
	public void guardaEnf() {
		try {
			this.enf.setFecha(this.eef.getFecha());
			/*ArrEstudioDao eefdao = new ArrEstudioDaoImpl(this.usuario);
			ArrEstudio[] estudios = eefdao.findByDynamicWhere("FECHA = STR_TO_DATE('" + UtilFechas.dateToString(this.enf.getFecha()) + "','%d/%m/%Y') AND IDPACIENTE = ?", new Object[]{this.enf.getIdPaciente()});
			if(estudios != null && estudios.length > 0)
				this.enf.setIdeef(estudios[0].getIdestudio());
			*/
			this.enf.setIdeef(this.eef.getIdestudio());
			if (this.enf.getIdRegistro() == null) { // INSERT
				this.enfpk = this.enfermeriadaotr.insert(this.enf);
				this.enf.setIdRegistro(this.enfpk.getIdRegistro());
				for(int i=0;i<this.enf.getCats().size();i++)
					this.enf.getCats().get(i).setIdenfermeria(this.enfpk.getIdRegistro());
				//this.guardaCateteres();
				this.introdaotr.delete(this.enfpk.getIdRegistro());
				for(int i=0;i<this.enf.getIntroductores().size();i++){
					this.enf.getIntroductores().get(i).setIdReg(this.enfpk.getIdRegistro());
					this.introdaotr.insert(this.enf.getIntroductores().get(i));
				}
				this.actdaotr.delete(this.enfpk.getIdRegistro());
				for(int i=0;i<this.enf.getActs().size();i++){
					if(this.enf.getActs().get(i).getAct() != null){
						this.enf.getActs().get(i).setIdRegistro(this.enfpk.getIdRegistro());
						this.actdaotr.insert(this.enf.getActs().get(i));
					}
				}
				//escribeEnClinica(true, this.enf.getIdRegistro(), this.enf.getFecha(), TIPO_ENF);
			}else{ // UPDATE
				this.introdaotr.delete(this.enfpk.getIdRegistro());
				this.actdaotr.delete(this.enfpk.getIdRegistro());
				this.enfermeriadaotr.update(this.enfpk, this.enf);
				//this.guardaCateteres();
				for(int i=0;i<this.enf.getIntroductores().size();i++){
					this.enf.getIntroductores().get(i).setIdReg(this.enfpk.getIdRegistro());
					this.introdaotr.insert(this.enf.getIntroductores().get(i));
				}
				for(int i=0;i<this.enf.getActs().size();i++){
					if(this.enf.getActs().get(i).getAct() != null){
						this.enf.getActs().get(i).setIdRegistro(this.enfpk.getIdRegistro());
						this.actdaotr.insert(this.enf.getActs().get(i));						
					}
				}
				//escribeEnClinica(false, this.enf.getIdRegistro(), this.enf.getFecha(), TIPO_ENF);
			}
		} catch (ArrEnfDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_error_guarda_enf")+": " + e1.getMessage());
		} catch (ArrEnfIntroductoresDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_error_guarda_enf_introd")+": " + e1.getMessage());
		} catch (ArrEnfActDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_error_guarda_enf_act")+": " + e1.getMessage());
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
			this.pintaMensaje(3, this.bundle.getString("eef_msg_error_guarda_cats")+": " + e.getMessage());
		}
	}
	public void guardaCateteresEef(){
		try {
			ArrEstudioCatUsoPk cpk = null;
			this.catusodaotr.delete(this.eef.getIdestudio()); 
			for (ArrEstudioCatUso cateter : this.eef.getListacats()) {
				cateter.setIdeef(this.eef.getIdestudio());
				cpk = catusodaotr.insert(cateter);
				if(cateter.getIdcatuso()==null)
					cateter.setIdcatuso(cpk.getIdcatuso());
				// FRR: esto provoca un BUG cuando se guardan dos cateteres del mismo tipo ya que hace que en la asigancion
				// la query siempre coge el primer registro y asigna a todos los registros iguales el mismo PK en lista (no en BD)
				//cateter.setIdcatuso(catusodao.findByDynamicWhere("IDEEF = ? AND IDCATETER = ? ", new Object[] {cateter.getIdeef(),cateter.getIdcateter()})[0].getIdcatuso());
			}
		} catch (ArrEstudioCatUsoDaoException e) {
			this.pintaMensaje(3, this.bundle.getString("eef_msg_error_guarda_cats")+": " + e.getMessage());
		}
	}


	public void guardaTaquicardia(ActionEvent e) {
		try {
			this.guardaEstudio(null);
			if (this.eef.getIdestudio() != null) {
				if (this.eef.getTaquicardidto().getIdtaqui() == null) {
					this.eef.getTaquicardidto().setIdestudio(this.eef.getIdestudio());
					ArrEstudioTaquiPk taqpk = new ArrEstudioTaquiPk();
					taqpk = taqdao.insert(this.eef.getTaquicardidto());
					this.eef.getTaquicardidto().setIdtaqui(taqpk.getIdtaqui());
					this.eef.getLsttaquicardias().add(this.eef.getTaquicardidto());
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("eef_msg_info_guarda_taqui"));
				} else {
					taqdao.update(this.eef.getTaquicardidto().createPk(), this.eef.getTaquicardidto());
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("eef_msg_info_edit_taqui"));
				}
			}
		} catch (ArrEstudioTaquiDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_guarda_taqui")+": " + e1.getMessage());
		}
	}

	public void borraTaquicardia(ActionEvent e) {
		if (this.eef.getTaquicardidto().getIdtaqui() != null) {
			try {
				taqdao.delete(this.eef.getTaquicardidto().createPk());
				this.verTaqui(null);
				if (this.eef.getLsttaquicardias() != null && this.eef.getLsttaquicardias().size() > 0) {
					this.eef.setTaquicardidto(this.eef.getLsttaquicardias().get(this.eef.getLsttaquicardias().size() - 1));
				} else {
					this.eef.setTaquicardidto(new ArrEstudioTaqui());
					this.eef.getTaquicardidto().setNumtaqui(this.eef.getLsttaquicardias().size() + 1);
				}
			} catch (ArrEstudioTaquiDaoException e1) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("eef_msg_error_borra_taqui")+": " + e1.getMessage());
			}
		}
	}

	public void addTaqui(ActionEvent e) {
		this.eef.setTaquicardidto(new ArrEstudioTaqui());
		Integer numero = 0;
		if (this.eef.getLsttaquicardias() == null || this.eef.getLsttaquicardias().size() == 0)
			numero = 1;
		else
			numero = this.eef.getLsttaquicardias().get(this.eef.getLsttaquicardias().size() - 1).getNumtaqui() + 1;
		this.eef.getTaquicardidto().setNumtaqui(numero);
		this.eef.getTaquicardidto().setIdestudio(this.eef.getIdestudio());
	}

	public void verTaqui(ActionEvent e) {
		try {
			ArrEstudioTaqui taqs[] = taqdao.findWhereIdestudioEquals(this.eef.getIdestudio()==null?0:this.eef.getIdestudio());
			ArrayList<ArrEstudioTaqui> taquis = new ArrayList<ArrEstudioTaqui>();
			for (int i = 0; i < taqs.length; i++)
				taquis.add(taqs[i]);
			this.eef.setLsttaquicardias(taquis);
		} catch (ArrEstudioTaquiDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_ver_taqui")+": "+ e1.getMessage());
		}
	}

	public void cargaTaqui(ActionEvent e) {
		this.eef.setTaquicardidto(this.eef.getLsttaquicardias().get(this.binlsttaq.getRowIndex()));
	}

	public void guardaAblacion(ActionEvent e) {
		try {
			/*if (this.eef.getIdestudio() == null)
				this.guardaEstudio(null);*/
			this.guardaEstudio(null);
			if (this.eef.getIdestudio() != null){
				// control de campos minimos: sustrato y resultado
				if(this.eef.getAblaciondto().getSustrato()!=null && this.eef.getAblaciondto().getSustrato()>0
						&& this.eef.getAblaciondto().getResultadodto().getIdres()!=null && this.eef.getAblaciondto().getResultadodto().getIdres()>0){
					boolean apls = true; // control de aplicaciones
					if(this.eef.getAblaciondto().getIdnodo()!=null && this.eef.getAblaciondto().getIdnodo()>=1){
						if(this.eef.getAblaciondto().getLista()!=null && this.eef.getAblaciondto().getLista().size()>0 ){
							for(AbordajeAblaciones abor:this.eef.getAblaciondto().getLista()){
								if(abor.getListacats()!=null && abor.getListacats().size()>0){
									for(ArrEstudioCatApl apl:abor.getListacats())
										if(apl.getIdcatuso()==null || apl.getIdcatuso().equals("")){
											this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_apls_cats"));
											apls = false;
											break;
										}
								}else{
									this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_cats_via_abord_noinfo_2"));
									apls = false;
									break;
								}
							}
						}else{
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_cats_via_abord_noinfo"));
							apls = false;
						}
					}
					if(apls){
						if (this.eef.getAblaciondto().getIdablacion() == null) {
							this.eef.getAblaciondto().setIdestudio(this.eef.getIdestudio());
							ArrEstudioAblacionPk ablpk = new ArrEstudioAblacionPk();
							//Inserto la ablación
							ablpk = abldao.insert(this.eef.getAblaciondto());
							this.eef.getAblaciondto().setIdablacion(ablpk.getIdablacion());
							this.eef.getAblaciondto().getResultadodto().setIdestudio(this.eef.getIdestudio());
							this.eef.getAblaciondto().getResultadodto().setIdablacion(ablpk.getIdablacion());
							//Inserto el resultado
							resdao.insert(this.eef.getAblaciondto().getResultadodto());
							// Inserto complicaciones asociadas
							//this.eef.getAblaciondto().getComplicacion().setIdestudio(this.eef.getIdestudio());
							//this.eef.getAblaciondto().getComplicacion().setIdablacion(ablpk.getIdablacion());
							//Inserto la complicación
							//ablcompdao.insert(this.eef.getAblaciondto().getComplicacion());
							this.eef.getAblaciones().add(this.eef.getAblaciondto());
							// Insercion de relacion de cateteres
							guardaCateteresAblacion();
							this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("eef_msg_info_guarda_abl"));					
						} else {
							//Actualizo las 4 partes de la ablación
							abldao.update(this.eef.getAblaciondto().createPk(), this.eef.getAblaciondto());
							resdao.update(this.eef.getAblaciondto().getResultadodto().createPk(), this.eef.getAblaciondto().getResultadodto());
							for(ArrAblacionComplica comps:this.eef.getAblaciondto().getListacomplicacion())
								ablcompdao.update(comps.createPk(), comps);
							//ablcompdao.update(this.eef.getAblaciondto().getComplicacion().createPk(), this.eef.getAblaciondto().getComplicacion());
							guardaCateteresAblacion();
							this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("eef_msg_info_edit_abl"));
						}
					}
				}else{
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_guarda_abl_sust_res"));
				}
			}
		} catch (ArrEstudioAblacionDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_guarda_abl")+": " + e1.getMessage());
		} catch (ArrEstudioResultadoDaoException e2) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_guarda_abl_res")+": " + e2.getMessage());
		} catch (ArrAblacionComplicaDaoException e3) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("eef_msg_error_guarda_abl_comp")+": " + e3.getMessage());
		}
	}
	
	public void borraAblacion(ActionEvent e) {
		if (this.eef.getAblaciondto().getIdablacion() != null) {
			try {
				for(ArrAblacionComplica comps:this.eef.getAblaciondto().getListacomplicacion())
					ablcompdao.delete(comps.createPk());
				//ablcompdao.delete(this.eef.getAblaciondto().getComplicacion().createPk());
				resdao.delete(this.eef.getAblaciondto().getResultadodto().createPk());
				apldao.delete(this.eef.getAblaciondto().getIdablacion());
				abldao.delete(this.eef.getAblaciondto().createPk());
				this.verAblacion(null);
				if (this.eef.getAblaciones() != null && this.eef.getAblaciones().size() > 0) {
					this.eef.setAblaciondto(this.eef.getAblaciones().get(this.eef.getAblaciones().size() - 1));
					//this.eef.setResultadodto(this.eef.getResultados().get(this.eef.getResultados().size() - 1));
				} else {
					this.eef.setAblaciondto(new ArrEstudioAblacion());
					//this.eef.setResultadodto(new ArrEstudioResultado());
					this.eef.getAblaciondto().setSustrato(this.eef.getAblaciones().size() + 1);
					//this.eef.getResultadodto().setSustrato(this.eef.getAblaciones().size() + 1);
				}
			} catch (ArrEstudioAblacionDaoException e1) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("eef_msg_error_borra_abl")+": " + e1.getMessage());
			} catch (ArrEstudioResultadoDaoException e1) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("eef_msg_error_borra_abl")+": " + e1.getMessage());
			} catch (ArrAblacionComplicaDaoException e3) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("eef_msg_error_borra_abl")+": " + e3.getMessage());
			} catch (ArrEstudioCatAplDaoException e4) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("eef_msg_error_borra_abl")+": " + e4.getMessage());
			}
		}
	}

	public void addAblacion(ActionEvent e) {
		this.eef.setAblaciondto(new ArrEstudioAblacion());
		Integer numero = 0;
		if (this.eef.getAblaciones() == null || this.eef.getAblaciones().size() == 0)
			numero = 1;
		else{
			numero = this.eef.getAblaciones().get(this.eef.getAblaciones().size() - 1).getSustrato() + 1;
			if(numero <= this.eef.getAblaciones().size()) numero = this.eef.getAblaciones().size() + 1; 
		}
		this.eef.getAblaciondto().setSustrato(numero);
		this.eef.getAblaciondto().setIdestudio(this.eef.getIdestudio());
		this.eef.getAblaciondto().getCompacAbl().setFechaini(this.eef.getFecha());
	}

	public void verAblacion(ActionEvent e) {
		try {
			if(this.eef.getIdestudio()!=null){
				ArrEstudioAblacion ablas[] = abldao.findWhereIdestudioEquals(this.eef.getIdestudio());
				ArrayList<ArrEstudioAblacion> ablaciones = new ArrayList<ArrEstudioAblacion>();
				for (int i = 0; i < ablas.length; i++){
					ArrAblacionComplica[] comps = this.ablcompdao.findByDynamicWhere("IDESTUDIO=? AND IDABLACION=?", new Object[]{ablas[i].getIdestudio(), ablas[i].getIdablacion()});
					ArrayList<ArrAblacionComplica> listaComAbl = new ArrayList<ArrAblacionComplica>();
					for(ArrAblacionComplica cmp:comps){
						if(cmp.getIdcompac()!=null){ // control para migraciones previas
							ArrAblacionComplica item = new ArrAblacionComplica();
							item.setCompabl(cmp.getCompabl());
							item.setIdablacion(cmp.getIdablacion());
							item.setIdcompac(cmp.getIdcompac());
							item.setIdcomplicacion(cmp.getIdcomplicacion());
							item.setIdcomplicacion2(cmp.getIdcomplicacion2());
							item.setIdestudio(cmp.getIdestudio());
							item.setIdlugar(cmp.getIdlugar());
							item.setIdmuerte(cmp.getIdmuerte());
							item.setIdprocedimiento(cmp.getIdprocedimiento());
							item.setOtros(cmp.getOtros());
							ComplicacionesPacientes compac = this.compacdao.findByPrimaryKey(item.getIdcompac());
							item.setCompabl(compac!=null?compac:new ComplicacionesPacientes());
							listaComAbl.add(item);
						}
					}
					ablas[i].setListacomplicacion(listaComAbl);
					//ablas[i].setComplicacion(this.ablcompdao.findByPrimaryKey(ablas[i].getIdestudio(), ablas[i].getIdablacion()));
					ablas[i].setResultadodto(this.resdao.findByPrimaryKey(ablas[i].getIdestudio(), ablas[i].getIdablacion()));
					// Insercion de cateteres asociados - aplicaciones
					//ablas[i].setListapls(cargaListaCateteresAblacion(ablas[i].getIdablacion()));
					//ablaciones.add(ablas[i]);
					ablas[i].setLista(cargaListaAplicaciones(ablas[i].getIdablacion()));
					ablaciones.add(ablas[i]);
					
				}
				this.eef.setAblaciones(ablaciones);				
			}
			/*ArrEstudioResultado res[] = resdao.findWhereIdestudioEquals(this.eef.getIdestudio());
			ArrayList<ArrEstudioResultado> resultados = new ArrayList<ArrEstudioResultado>();
			for (int i = 0; i < res.length; i++)
				resultados.add(res[i]);
			this.eef.setResultados(resultados);*/
		} catch (ArrEstudioAblacionDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_ver_abl")+": "+ e1.getMessage());
		} catch (ArrEstudioResultadoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_ver_abl")+": "+ e1.getMessage());
		} catch (ArrAblacionComplicaDaoException e3) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_ver_abl")+": "+ e3.getMessage());
		} catch (ComplicacionesPacientesDaoException e3) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_ver_abl")+": "+ e3.getMessage());
		}

	}

	public ArrayList<ArrEstudioCatApl> cargaListaCateteresAblacion(Integer idabl){
		ArrayList<ArrEstudioCatApl> res = new ArrayList<ArrEstudioCatApl>();
		try{
			ArrEstudioCatApl[] apls = this.apldao.findWhereIdablacionEquals(idabl);
			if(apls!=null && apls.length>0){
				for(ArrEstudioCatApl item:apls){
					ArrEstudioCatUso aux = buscaItem(item.getIdcatuso());
					if(aux!=null){
						item.setEnergia(aux.getEnergia());
						item.setModelo(aux.getModelo());
						res.add(item);
					}
				}
			}
			return res;
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_ver_cats_abl")+": "+ e1.getMessage());
			return res;
		}
	}
	public ArrayList<AbordajeAblaciones> cargaListaAplicaciones(Integer idabl){
		ArrayList<AbordajeAblaciones> res = new ArrayList<AbordajeAblaciones>();
		try{
			ArrEstudioCatApl[] apls = this.apldao.findWhereIdablacionEquals(idabl);
			if(apls!=null && apls.length>0)				
				creaListaAplicacionesAbordaje(apls,res);
			return res;
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_ver_cats_abl")+": "+ e1.getMessage());
			return res;
		}
	}
	
	public void cargaAblacion(ActionEvent e) {
		//try {
			this.eef.setAblaciondto(this.eef.getAblaciones().get(this.binlstabl.getRowIndex()));
			this.eef.getAblaciondto().getCompacAbl().setFechaini(this.eef.getFecha());
			//this.eef.setResultadodto(resdao.findByPrimaryKey(this.eef.getAblaciondto().getIdestudio(), this.eef.getAblaciondto().getIdablacion()));
		/*} catch (ArrEstudioResultadoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"No se ha podido obtener los datos de los resultados: "
							+ e1.getMessage());
		}*/
	}
	public void creaListaAplicacionesAbordaje(ArrEstudioCatApl[] apls, ArrayList<AbordajeAblaciones> res){
		//res.add(new AbordajeAblaciones(apls[0].getIdvia()));// inicializacion de la iteracion 
		//res.get(0).getListacats().add(apls[0]);// inicializacion de la iteracion		
		for(ArrEstudioCatApl apl:apls){
			int pos = buscaItemLista(apl.getIdvia(),res);
			if(pos!=-1){
				ArrEstudioCatUso aux = buscaItem(apl.getIdcatuso());
				if(aux!=null){
					apl.setEnergia(aux.getEnergia());
					apl.setModelo(aux.getModelo());
					res.get(pos).getListacats().add(apl);
				}	
			}else{
				res.add(new AbordajeAblaciones(apl.getIdvia()));
				ArrEstudioCatUso aux = buscaItem(apl.getIdcatuso());
				if(aux!=null){
					apl.setEnergia(aux.getEnergia());
					apl.setModelo(aux.getModelo());
					res.get(res.size()-1).getListacats().add(apl);
				}
			}	 
		}	
	}
	public int buscaItemLista(Integer idvia,ArrayList<AbordajeAblaciones> lista){
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).getIdvia().equals(idvia))
				return i;
		}
		return -1;
	}
	public ArrEstudioCatUso buscaItem(Integer idcatuso){
		for(ArrEstudioCatUso i:this.eef.getListacats()){
			if(i.getIdcatuso().equals(idcatuso))
				return i;
		}
		return null;
	}
	public ArrEstudioCatUso buscaItem2(Integer idcat) throws ArrEstudioCatUsoDaoException{
		for(ArrEstudioCatUso i:this.eef.getListacats()){
			if(i.getIdcateter().equals(idcat)){
				// Si no encuentra el cateter, hay que meter el cateter en cat_uso y luego devolverlo en el return
				return this.catusodao.findByDynamicWhere("IDEEF = ? AND IDCATETER = ? ", new Object[] {i.getIdeef(),i.getIdcateter()})[0];
			}
		}
		return null;
	}
	public void guardaCateteresAblacion(){
		try{
			apldao.delete(this.eef.getAblaciondto().getIdablacion());
			// 1. Volcado de cateteres a objeto listaApl
			this.eef.getAblaciondto().getListapls().clear();
			for(AbordajeAblaciones ab:this.eef.getAblaciondto().getLista()){
				for(ArrEstudioCatApl apl:ab.getListacats()){
					if(apl.getIdcateteruso()!=null)
						apl.setIdcatuso(buscaItem2(apl.getIdcateteruso()).getIdcatuso());
					else
						apl.setIdcatuso(apl.getIdcatuso());
					this.eef.getAblaciondto().getListapls().add(apl);
				}					
			}
			// 2. Insercion
			for(ArrEstudioCatApl ap:this.eef.getAblaciondto().getListapls()){
				ap.setIdablacion(this.eef.getAblaciondto().getIdablacion());
				apldao.insert(ap);
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_guarda_cats")+": "+ e1.getMessage());
		}
	}
	
	public void guardaComplicacionDiag(ActionEvent e){
		// previo - guardar estudio
		this.guardaEstudio(null);
		this.compacDiag.setIdpaciente(this.cp.getPacienteSelect().getCodigo());
		this.compacDiag.setIdprocedimiento(this.proc.getIdprocedimiento());
		this.compacDiag.setTipoprocedimiento(this.proc.getTipoprocedimiento());
		this.compacDiag.setIdrelacion(7);
		cc.addItemComplicacion(this.compacDiag);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.eef.getComplicacionesdto().getListacompldiag().clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			if(cpac.getIdrelacion().equals(7))
				this.eef.getComplicacionesdto().getListacompldiag().add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.compacDiag = new ComplicacionesPacientes();
		this.compacDiag.setFechaini(this.eef.getFecha());
		this.compacDiag.setTipo(1);
	}
	
	public void guardaComplicacionAbl(ActionEvent e){
		// previo - guardar estudio
		//this.guardaEstudio(null);
		try{
			if(!compruebaDuplicadoComAbl(this.eef.getAblaciondto().getCompacAbl().getComplicacion(),this.eef.getAblaciondto().getListacomplicacion())){
				this.eef.getAblaciondto().getCompacAbl().setIdpaciente(this.cp.getPacienteSelect().getCodigo());
				this.eef.getAblaciondto().getCompacAbl().setIdprocedimiento(this.proc.getIdprocedimiento());
				this.eef.getAblaciondto().getCompacAbl().setTipoprocedimiento(this.proc.getTipoprocedimiento());
				this.eef.getAblaciondto().getCompacAbl().setIdrelacion(1);
				Integer idcompac = cc.addItemComplicacionEEF(this.eef.getAblaciondto().getCompacAbl());
				cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
				
				// Guardar item arr_ablacion_complica
				this.eef.getAblaciondto().getComplicacion().setIdcompac(idcompac);
				this.eef.getAblaciondto().getComplicacion().setIdablacion(this.eef.getAblaciondto().getIdablacion());
				this.eef.getAblaciondto().getComplicacion().setIdestudio(this.eef.getAblaciondto().getIdestudio());
				this.eef.getAblaciondto().getComplicacion().setIdcomplicacion(this.eef.getAblaciondto().getCompacAbl().getComplicacion());
				this.ablcompdao.insert(this.eef.getAblaciondto().getComplicacion());
				
				this.eef.getAblaciondto().getListacomplicacion().clear();
				ArrAblacionComplica[] listacomps = this.ablcompdao.findByDynamicWhere("IDESTUDIO=? AND IDABLACION=?", new Object[]{this.eef.getAblaciondto().getIdestudio(),this.eef.getAblaciondto().getIdablacion()});
				for(ArrAblacionComplica cpac:listacomps){
					ComplicacionesPacientes compac = this.compacdao.findByPrimaryKey(cpac.getIdcompac());
					cpac.setCompabl(compac);
					this.eef.getAblaciondto().getListacomplicacion().add(cpac);
				}
				// reinicia el objeto con los datos maestros de este formulario
				this.eef.getAblaciondto().setCompacAbl(new ComplicacionesPacientes());
				this.eef.getAblaciondto().getCompacAbl().setTipo(1);
				this.eef.getAblaciondto().getCompacAbl().setFechaini(this.eef.getFecha());
			}else{
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_guarda_comp_abl_dup"));
			}
			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_guarda_comp_abl")+": "+ e1.getMessage());
		}
	}
	
	public boolean compruebaDuplicadoComAbl(Integer idcomp, ArrayList<ArrAblacionComplica> comps){
		for(ArrAblacionComplica c:comps)
			if(idcomp.equals(c.getIdcomplicacion()))
				return true;
		return false;
	}
	
	public boolean compruebaDuplicadoEditComAbl(Integer idcomp, ArrayList<ArrAblacionComplica> comps){
		int cont = 0;
		for(ArrAblacionComplica c:comps)
			if(idcomp.equals(c.getCompabl().getComplicacion()))
				cont++;
		if(cont>1)
			return true;
		return false;
	}
	
	public void preEditarProc(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		ComplicacionesPacientes aux = this.eef.getComplicacionesdto().getListacompldiag().get(this.bindingComplicacionesDiagProc.getRowIndex());	
		this.currentItemComp.setIdcompac(aux.getIdcompac());
		this.currentItemComp.setIdpaciente(aux.getIdpaciente());
		this.currentItemComp.setTipo(aux.getTipo());
		this.currentItemComp.setTipoprocedimiento(aux.getTipoprocedimiento());
		this.currentItemComp.setIdprocedimiento(aux.getIdprocedimiento());
		this.currentItemComp.setComplicacion(aux.getComplicacion());
		this.currentItemComp.setComplicacion1(aux.getComplicacion1());
		this.currentItemComp.setComplicacion2(aux.getComplicacion2());
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
	
	public void preEditarAblProc(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		ArrAblacionComplica aux = this.eef.getAblaciondto().getListacomplicacion().get(this.eef.getAblaciondto().getBindingComplicacionesAblProc().getRowIndex());	
		this.currentItemAblComp.setCompabl(aux.getCompabl());
		this.currentItemAblComp.setIdablacion(aux.getIdablacion());
		this.currentItemAblComp.setIdcompac(aux.getIdcompac());
		this.currentItemAblComp.setIdcomplicacion(aux.getCompabl().getComplicacion());
		this.currentItemAblComp.setIdcomplicacion2(aux.getIdcomplicacion2());
		this.currentItemAblComp.setIdestudio(aux.getIdestudio());
		this.currentItemAblComp.setIdlugar(aux.getIdlugar());
		this.currentItemAblComp.setIdmuerte(aux.getIdmuerte());
		this.currentItemAblComp.setIdprocedimiento(aux.getIdprocedimiento());
		this.currentItemAblComp.setOtros(aux.getOtros());
		
		this.setEditableAblProc(true);
	}
	
	public void actualizaItemComplicacion(ActionEvent e){
		cc.editItemComplicacion(this.currentItemComp);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.eef.getComplicacionesdto().getListacompldiag().clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.eef.getComplicacionesdto().getListacompldiag().add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.currentItemComp = new ComplicacionesPacientes();
	}
	
	public void actualizaItemComplicacionAbl(ActionEvent e){
		try{
			Integer idprev = this.currentItemAblComp.getIdcomplicacion();
			this.currentItemAblComp.setIdcomplicacion(this.currentItemAblComp.getCompabl().getComplicacion());
			if(!compruebaDuplicadoEditComAbl(this.currentItemAblComp.getIdcomplicacion(), this.eef.getAblaciondto().getListacomplicacion())){
				cc.editItemComplicacion(this.currentItemAblComp.getCompabl());
				cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
				this.ablcompdao.update(new ArrAblacionComplicaPk(this.currentItemAblComp.getIdestudio(),this.currentItemAblComp.getIdablacion(),idprev),this.currentItemAblComp);
				this.currentItemAblComp = new ArrAblacionComplica();
			}else{
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("compli_msg_warn_edit_dup"));
				this.currentItemAblComp.setIdcomplicacion(idprev);
				this.currentItemAblComp.getCompabl().setComplicacion(idprev);
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("compli_msg_warn_edit")+": " + e1.getMessage());
		}
	}
	
	public void cancelarItemComplicacion(ActionEvent e){
		this.setEditableProc(false);
	}
	
	public void cancelarItemComplicacionAbl(ActionEvent e){
		this.setEditableAblProc(false);
	}
	
	public void delItemComplicacion(ActionEvent e){
		Integer pos = this.bindingComplicacionesDiagProc.getRowIndex();
		ComplicacionesPacientes item = this.eef.getComplicacionesdto().getListacompldiag().get(pos);
		cc.delItemComplicacion(item);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.eef.getComplicacionesdto().getListacompldiag().clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			if(cpac.getIdrelacion().equals(7))
				this.eef.getComplicacionesdto().getListacompldiag().add(cpac);
	}
	
	public void delItemComplicacionAbl(ActionEvent e){
		try{
			int pos = this.eef.getAblaciondto().getBindingComplicacionesAblProc().getRowIndex();
			ArrAblacionComplica item = this.eef.getAblaciondto().getListacomplicacion().get(pos);
			cc.delItemComplicacion(item.getCompabl());
			cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
			ablcompdao.delete(item.createPk());
			this.eef.getAblaciondto().getListacomplicacion().remove(pos);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("compli_msg_error_borrar")+": " + e1.getMessage());
		}
		
	}
	
	public void limpiarComp(ActionEvent e){
		this.compacDiag = new ComplicacionesPacientes();
		this.compacDiag.setFechaini(this.eef.getFecha());
		this.compacDiag.setTipo(1);
	}
	
	public void limpiarCompAbl(ActionEvent e){
		this.eef.getAblaciondto().setCompacAbl(new ComplicacionesPacientes());
		this.eef.getAblaciondto().getCompacAbl().setTipo(1);
		
	}
	
	public void printEstudio(ActionEvent e) {
		if (this.eef.getIdestudio() == null) {
			this.guardaEstudio(e);
		}
		// Validacion de formulario
		validaFormulario();
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

		try {
			PathFicheroXml = generadorXML.imprimeInformeEEF(this.eef,
					this.cp.pacienteSelect,this.infocentro,this.sitclin,this.enf,this.bundle);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
				this.bundle.getString("info_msg_error_impr_gen_doc")+": " + se.getMessage());
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: " + se.getMessage());
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml, "InformeEEF.jasper");
			logger.info("("+this.usuario+") Generación de informe (Estudio EF). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
				this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + se.getMessage());
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: " + se.getMessage());
		}
	}
	
	public void printEnfermeria(ActionEvent e){
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

		try {
			//ArrEstudioDao eefdao = new ArrEstudioDaoImpl(this.usuario);
			ArrMaestrasDao maedao = new ArrMaestrasDaoImpl(this.usuario);
			
			PathFicheroXml = generadorXML.imprimeENF(this.enf,
					this.cp.pacienteSelect, maedao.findByPrimaryKey(this.eefdao.findByPrimaryKey(this.enf.getIdeef()).getDiagnostico()).getValor(), this.bundle);
		} catch (Exception se) {
			try {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("info_msg_error_impr_gen_doc")+": " + se.getMessage());
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}
		ConstructorPdf constructorPDF = new ConstructorPdf();
		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml, "InformeENF.jasper");
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento, motivo: "+se.getMessage());
			try {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + se.getMessage());
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo documento,motivo: "
								+ se.getMessage(),
						"Error imprimiendo documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e2) {
			}
		}
	}
	
	public String printFichero() {
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String path = "";
		try {
			PathFicheroXml = generadorXML.imprimeInformeEEF(this.eef,
					this.cp.pacienteSelect,this.infocentro,this.sitclin,this.enf,this.bundle);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_impr_gen_doc")+": "+ se.getMessage());
			logger.error("("+this.usuario+") Error generando documento,Motivo: " + se.getMessage());
		}

		try {
			path = constructorPDF.generarArchivoPdfFile(FacesContext.getCurrentInstance(), PathFicheroXml, "InformeEEF.jasper");
			logger.info("("+this.usuario+") Generación de informe (Estudio EF). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + se.getMessage());
			logger.error("("+this.usuario+") Error generando documento,Motivo: " + se.getMessage());
		}
		return path;
	}
	
	public void eliminaEstudio(ActionEvent e){
		Integer fila = this.bindingBuscar.getRowIndex();
		this.proc = this.procs.get(fila); 
		//this.eef = this.eefs.get(fila);
		int auxproc = this.proc.getIdprocedimiento();
		try {
			this.eef = this.eefdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.sopdao.delete(new ArrEstudioSopPk(this.eef.getIdestudio()));
			this.popdao.delete(new ArrEstudioPopPk(this.eef.getIdestudio()));
			this.anestdao.delete(new ArrEstudioAnestPk(this.eef.getIdestudio()));
			this.taqdao.delete(this.eef.getIdestudio());
			this.enfdao.delete(new ArrEstudioEnfPk(this.eef.getIdestudio()));
			this.viasdao.delete(new ArrEstudioViasPk(this.eef.getIdestudio()));
			this.resdao.delete(this.eef.getIdestudio());
			this.nprocdao.delete(new ArrEstudioNprocPk(this.eef.getIdestudio()));
			this.prdao.delete(new ArrEstudioPeriodoPk(this.eef.getIdestudio()));
			this.sinpfdao.delete(new ArrSinusalPfPk(this.eef.getIdestudio()));
			this.cavpfdao.delete(new ArrConducPfPk(this.eef.getIdestudio()));
			this.cavecdao.delete(new ArrConduccEcPk(this.eef.getIdestudio()));
			this.catusodao.delete(this.eef.getIdestudio());
			this.eefdao.delete(this.eef.createPk());
			//this.sitclindao.delete(this.sitclin.createPk());
			this.procdao.delete(this.proc.createPk());
			// borrar registro enfermeria
			this.iniciaEef(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(1, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro Estudio EF eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido eliminar el registro:  Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
		}
	}
	public void eliminarEstudioInterno(ActionEvent e){
		//Integer fila = this.bindingBuscar.getRowIndex();
		//this.proc = this.procs.get(fila); 
		//this.eef = this.eefs.get(fila);
		int auxproc = this.proc.getIdprocedimiento();
		try {
			//this.eef = this.eefdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.sopdao.delete(new ArrEstudioSopPk(this.eef.getIdestudio()));
			this.popdao.delete(new ArrEstudioPopPk(this.eef.getIdestudio()));
			this.taqdao.delete(this.eef.getIdestudio());
			this.enfdao.delete(new ArrEstudioEnfPk(this.eef.getIdestudio()));
			this.viasdao.delete(new ArrEstudioViasPk(this.eef.getIdestudio()));
			this.resdao.delete(this.eef.getIdestudio());
			this.nprocdao.delete(new ArrEstudioNprocPk(this.eef.getIdestudio()));
			this.prdao.delete(new ArrEstudioPeriodoPk(this.eef.getIdestudio()));
			this.sinpfdao.delete(new ArrSinusalPfPk(this.eef.getIdestudio()));
			this.cavpfdao.delete(new ArrConducPfPk(this.eef.getIdestudio()));
			this.cavecdao.delete(new ArrConduccEcPk(this.eef.getIdestudio()));
			this.eefdao.delete(this.eef.createPk());
			this.procdao.delete(this.proc.createPk());
			this.iniciaEef(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(1, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro Estudio EF eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido eliminar el registro:  Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
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
	
	public void addSintoma(ActionEvent e){
		this.sitclin.getSintomas().add(new SintomasSitclinProc());
	}
	public void delSintoma(ActionEvent e){
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
	public void addEnf(ActionEvent e) {
		this.eef.getEnfermeras().add(new ArrEstudioEnf());
	}

	public void delEnf(ActionEvent e) {
		this.eef.getEnfermeras().remove(this.binenf.getRowIndex());
	}
	public void editEnf(ActionEvent e) {
		this.eef.getEnfermeras().get(this.binenf.getRowIndex()).setLectura(this.eef.getEnfermeras().get(this.binenf.getRowIndex()).getLectura()==1?0:1);
	}
	public void controlEnf(ActionEvent e){
		int dup=0;
		for(ArrEstudioEnf s:this.eef.getEnfermeras()){
			if(s.getIdenfermera().equals(this.eef.getEnfermeras().get(this.binenf.getRowIndex()).getIdenfermera()))
				dup++;			
			if(dup>1){
				// Duplicado
				this.eef.getEnfermeras().remove(this.binenf.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_enf_dupl"));
				break;
			}
		}
	}

	public void addPop(ActionEvent e) {
		this.eef.getPoperador().add(new ArrEstudioPop());
	}

	public void delPop(ActionEvent e) {
		this.eef.getPoperador().remove(this.binpop.getRowIndex());
	}
	public void editPop(ActionEvent e) {
		this.eef.getPoperador().get(this.binpop.getRowIndex()).setLectura(this.eef.getPoperador().get(this.binpop.getRowIndex()).getLectura()==1?0:1);
	}
	public void controlPop(ActionEvent e){
		int dup=0;
		for(ArrEstudioPop s:this.eef.getPoperador()){
			if(s.getIdoperador().equals(this.eef.getPoperador().get(this.binpop.getRowIndex()).getIdoperador()))
				dup++;			
			if(dup>1){
				// Duplicado
				this.eef.getPoperador().remove(this.binpop.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_pop_dupl"));
				break;
			}
		}
	}

	public void addSop(ActionEvent e) {
		this.eef.getSoperador().add(new ArrEstudioSop());
	}

	public void delSop(ActionEvent e) {
		this.eef.getSoperador().remove(this.binsop.getRowIndex());
	}
	public void editSop(ActionEvent e) {
		this.eef.getSoperador().get(this.binsop.getRowIndex()).setLectura(this.eef.getSoperador().get(this.binsop.getRowIndex()).getLectura()==1?0:1);
	}
	public void controlSop(ActionEvent e){
		int dup=0;
		for(ArrEstudioSop s:this.eef.getSoperador()){
			if(s.getIdoperador().equals(this.eef.getSoperador().get(this.binsop.getRowIndex()).getIdoperador()))
				dup++;			
			if(dup>1){
				// Duplicado
				this.eef.getSoperador().remove(this.binsop.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sop_dupl"));
				break;
			}
		}
	}
	public void addAnest(ActionEvent e) {
		this.eef.getAnest().add(new ArrEstudioAnest());
	}

	public void delAnest(ActionEvent e) {
		this.eef.getAnest().remove(this.binanest.getRowIndex());
	}
	public void editAnest(ActionEvent e) {
		this.eef.getAnest().get(this.binanest.getRowIndex()).setLectura(this.eef.getAnest().get(this.binanest.getRowIndex()).getLectura()==1?0:1);
	}
	public void controlAnest(ActionEvent e){
		int dup=0;
		for(ArrEstudioAnest s:this.eef.getAnest()){
			if(s.getIdanestesista().equals(this.eef.getAnest().get(this.binanest.getRowIndex()).getIdanestesista()))
				dup++;			
			if(dup>1){
				// Duplicado
				this.eef.getAnest().remove(this.binanest.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_ane_dupl"));
				break;
			}
		}
	}

	public void addCateter(ActionEvent e){
		this.eef.getListacats().add(new ArrEstudioCatUso());
		//this.eef.getAux().add(new Cateter());	
	}	
	public void delCateter(ActionEvent e){
		this.eef.getListacats().remove(this.bindingCatDiag.getRowIndex());
		//this.eef.getAux().remove(this.bindingCatDiag.getRowIndex());
		// proceso de quitarlo de eef.aux
	}
	public void cambiaModeloCateter(ActionEvent e){
		String modcat = this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).getModelo();
		Cateter cat = null;
		try {
			cat = this.cdao.findWhereModeloEquals(modcat)[0];
			this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setIdcateter(cat.getIdcateter());
			this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setTipo(cat.getTipo());
			this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setEnergia(cat.getEnergia()!=null?cat.getEnergia():0);
			if(cat.getTipo()==2)
				this.eef.getAux().add(cat);// lista de modelos de cateteres del eef	
		} catch (Exception e1) {
			//e1.printStackTrace();
			this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setIdcateter(0);
			this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setModelo("");
			this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setTipo(0);
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_add_cat"));
		}
	}
	public void lecturaModeloCateter(ActionEvent e){
		try{
			this.setUsaLector(true);
			ArrayList<String> lecturas = GestorCodigoBarras.lectura(this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).getBarcode());
			//Cateter[] cat = this.cdao.findWhereGs128Equals(lecturas.get(0));
			this.setLineanuevo(this.bindingCatDiag.getRowIndex());// indice para insertar nuevo
			Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("TIPO = ? AND CODIGO = ?", new Object[]{3,lecturas.get(0)});
			Cateter cat = null;
			if(codigos!=null && codigos.length>0)
				cat  = this.cdao.findByPrimaryKey(codigos[0].getIdmaterial());
			
			if(cat!=null/*cat.length>0*/){
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setIdcateter(cat.getIdcateter());
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setModelo(cat.getModelo());
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setLote(lecturas.get(1));
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setDefectuoso(0);
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setTipo(cat.getTipo());	
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setMuestrabarcode(false);
				if(cat.getTipo()==2)
					this.eef.getAux().add(cat);// lista de modelos de cateteres del eef	
			}else{
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setBarcode("");
				this.nuevocat.setGs128(lecturas.get(0));
				this.setNuevocateter(true); // variable de apertura de modalPanel
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_add_lectura_cat"));
			}
			
			/*String gs128 = this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).getBarcode().substring(0, 16).substring(2, 16);		
			Cateter[] cat = this.cdao.findWhereGs128Equals(gs128);
			if(cat.length>0){
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setIdcateter(cat[0].getIdcateter());
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setModelo(cat[0].getModelo());
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setDefectuoso(0);
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setTipo(cat[0].getTipo());	
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setMuestrabarcode(false);
			}else{
				this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setBarcode("");
				this.pintaMensaje(
					Mensaje.SEVERIDAD_AVISO,
						"No se han encontrado coincidencias para el catéter.");
			}*/			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("eef_msg_error_cons_cat")+": "+ e1.getMessage());
		}
	}
	public void cambiaModeloCateterAblacion(ActionEvent e){
		String modelo = this.eef.getAblaciondto().getListapls().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getModelo();
		for(ArrEstudioCatUso c:this.eef.getListacats()){
			if(c.getModelo().equals(modelo)){
				this.eef.getAblaciondto().getListapls().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).setIdcatuso(c.getIdcatuso());
				this.eef.getAblaciondto().getListapls().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).setEnergia(c.getEnergia());
				controlAplicacion(null);
				break;		
			}		
		}
		/*String modelo = this.eef.getAblaciondto().getListapls().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getModelo();
		for(ArrEstudioCatUso c:this.eef.getListacats()){
			if(c.getModelo().equals(modelo)){
				this.eef.getAblaciondto().getListapls().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).setIdcatuso(c.getIdcatuso());
				this.eef.getAblaciondto().getListapls().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).setEnergia(c.getEnergia());
				controlAplicacion(null);
				break;		
			}		
		}*/
	}
	/*public void cambiaModeloCatDiag(ActionEvent e){
		String modcat = this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).getModelo();
		Cateter cat = null;
		try {
			cat = this.cdao.findWhereModeloEquals(modcat)[0];
			this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).setIdcateter(cat.getIdcateter());
			this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).setTipo(cat.getTipo());
		} catch (Exception e1) {
			//e1.printStackTrace();
			this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).setIdcateter(0);
			this.eef.getLcatdiag().get(
					this.getBindingCatDiag().getRowIndex()).setModelo("");
			this.eef.getLcatdiag().get(
					this.getBindingCatDiag().getRowIndex()).setTipo(0);
			this.pintaMensaje(
					Mensaje.SEVERIDAD_ERROR,
					"Es necesario especificar un modelo de cateter válido");
		}
	}*/
	/*public void lecturaModeloCatDiag(ActionEvent e){
		try{
			String gs128 = this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).getBarcode().substring(0, 16).substring(2, 16);		
			Cateter[] cat = this.cdao.findWhereGs128Equals(gs128);
			if(cat.length>0){
				this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).setIdcateter(cat[0].getIdcateter());
				this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).setModelo(cat[0].getModelo());
				this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).setDefectuoso(0);
				this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).setTipo(cat[0].getTipodiagnostico());			
			}else{
				this.eef.getLcatdiag().get(this.getBindingCatDiag().getRowIndex()).setBarcode("");
				this.pintaMensaje(
						Mensaje.SEVERIDAD_AVISO,
						"No se han encontrado coincidencias para el dispositivo.");
			}			
		}catch(Exception e1){
			this.pintaMensaje(
					Mensaje.SEVERIDAD_ERROR,
					"No se pueden recuperar cateteres del sistema. Error: "
							+ e1.getMessage());
		}
	}*/
	
	
	public void lecturaLoteCateter(ActionEvent e){
		ArrayList<String> lecturas = GestorCodigoBarras.lectura(this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).getLote());
		if(lecturas.get(1)!=null)
			this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setLote(lecturas.get(1));
		//this.setUsaLector(false);
	}
	
	public void delLote(ActionEvent e){
		this.eef.getListacats().get(this.bindingCatDiag.getRowIndex()).setLote(null);
	}
	
	public void addAplicacion(ActionEvent e){
		this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().add(new ArrEstudioCatApl(this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getIdvia()));
	}
	public void addAbordaje(ActionEvent e){
		boolean ex=false;
		for(AbordajeAblaciones ab:this.eef.getAblaciondto().getLista()){
			if(this.getIdviaaux() == ab.getIdvia()){
				this.pintaMensaje(ERROR, this.bundle.getString("eef_msg_warn_cat_abord"));
				ex = true;
			}	
		}
		if(!ex)
			this.eef.getAblaciondto().getLista().add(new AbordajeAblaciones(this.getIdviaaux()));
		this.idviaaux = 0;
		//this.eef.getAux().add(new Cateter());
	}
	public void delAplicacion(ActionEvent e){
		//this.eef.getAblaciondto().getListapls().remove(this.eef.getAblaciondto().getBindingApls().getRowIndex());
		this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().remove(this.eef.getAblaciondto().getBindingAbordajes().getRowIndex());
	}
	public void delAbordaje(ActionEvent e){
		this.eef.getAblaciondto().getLista().remove(this.eef.getAblaciondto().getBindingApls().getRowIndex());
	}
	public void controlAplicacion(ActionEvent e){
		int dup=0;
		for(ArrEstudioCatApl ap:this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats()){
			if(((ap.getIdcatuso()!=null && ap.getIdcatuso().equals(this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().get(this.eef.getAblaciondto().getBindingAbordajes().getRowIndex()).getIdcatuso())
					||ap.getIdcateteruso()!=null && ap.getIdcateteruso().equals(this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().get(this.eef.getAblaciondto().getBindingAbordajes().getRowIndex()).getIdcateteruso()))
					&& (ap.getIdvia()!=null && ap.getIdvia().equals(this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().get(this.eef.getAblaciondto().getBindingAbordajes().getRowIndex()).getIdvia()))))
				dup++;			
			if(dup>1){
				// Duplicado
				this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().remove(this.eef.getAblaciondto().getBindingApls().getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_cat_abl_dupl"));
				break;
			}
		}
		/*int dup=0;
		for(ArrEstudioCatApl ap:this.eef.getAblaciondto().getListapls()){
			if((ap.getIdcatuso()!=null && ap.getIdcatuso().equals(this.eef.getAblaciondto().getListapls().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getIdcatuso()))
					&& (ap.getIdvia()!=null && ap.getIdvia().equals(this.eef.getAblaciondto().getListapls().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getIdvia())))
				dup++;			
			if(dup>1){
				// Duplicado
				this.eef.getAblaciondto().getListapls().remove(this.eef.getAblaciondto().getBindingApls().getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,
						"Cateter de ablación duplicado: se eliminará de la lista para evitar incongruencias en la información a registrar.");
				break;
			}
		}*/
	}
	public void cambiaModeloCateterAblacionAplicacion(ActionEvent e){
		String modelo = this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().get(this.eef.getAblaciondto().getBindingAbordajes().getRowIndex()).getModelo();
		// controlar duplicados en el cambio de modelo
		for(ArrEstudioCatUso c:this.eef.getListacats()){
			if(c.getModelo().equals(modelo)){
				this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().get(this.eef.getAblaciondto().getBindingAbordajes().getRowIndex()).setIdcatuso(c.getIdcatuso());
				this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().get(this.eef.getAblaciondto().getBindingAbordajes().getRowIndex()).setEnergia(c.getEnergia());
				this.eef.getAblaciondto().getLista().get(this.eef.getAblaciondto().getBindingApls().getRowIndex()).getListacats().get(this.eef.getAblaciondto().getBindingAbordajes().getRowIndex()).setIdcateteruso(c.getIdcateter());
				controlAplicacion(null);
				break;		
			}		
		}	
	}
	public ArrayList<SelectItem> getCatdiag() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (Cateter ref : this.catdiag)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}
	public ArrayList<SelectItem> getCatdiag2() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (Cateter ref : this.catdiag2)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}
	public ArrayList<SelectItem> getCateef() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("eef_msg_info_cat_selecciona")));
		for (Cateter ref : this.eef.getAux())
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}
	public ArrayList<SelectItem> getFabcat() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.fabcat)
			e.add(new SelectItem(el.getCodigo(),
					el.getValor()));
		return e;
	}
	public void cargarModelosCateter(ActionEvent e) {
		if (this.isModavcatdiag())
			this.setModavcatdiag(false);
		else
			this.setModavcatdiag(true);
	}
	/*public void insertarCateterEef(ActionEvent e){
		if(this.aux.get(this.bindingCatDiag.getRowIndex()).getTipo().equals(1)){// diagnostico
			ArrEstudioCatDiag elem = new ArrEstudioCatDiag();
			elem.setTipo(this.aux.get(this.bindingCatDiag.getRowIndex()).getTipo());
			elem.setIdcateter(this.aux.get(this.bindingCatDiag.getRowIndex()).getIdcateter());
			elem.setModelo(this.aux.get(this.bindingCatDiag.getRowIndex()).getModelo());
			elem.setDefectuoso(this.aux.get(this.bindingCatDiag.getRowIndex()).getDefectuoso());
			elem.setIdloc(this.aux.get(this.bindingCatDiag.getRowIndex()).getIdloc());
			elem.setIdvia(this.aux.get(this.bindingCatDiag.getRowIndex()).getIdvia());
			this.eef.getLcatdiag().add(elem);
		}else{// ablacion
			try {
				Cateter[] cat = cdao.findWhereIdcateterEquals(this.aux.get(this.bindingCatDiag.getRowIndex()).getIdcateter());
				this.eef.getListacats().add(cat[0]);
			} catch (CateterDaoException e1) {
				e1.printStackTrace();
			}	
		}
		this.aux = new ArrayList<ArrEstudioCatDiag>();
	}*/
	
	public void insertarNuevoCateter(ActionEvent e){
		logger.info("("+this.usuario+") Iniciando acción insertar cateter");
		if(this.nuevocat.getGs128().length()<=0 || this.nuevocat.getModelo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_add"));
			logger.error("("+this.usuario+") No se puede insertar cateter. Es necesario especificar codigo GS1-128 y modelo al cateter");
		}else if(this.nuevocat.getTipo()==null || this.nuevocat.getTipo().equals(0)){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_add_cat"));
			logger.error("("+this.usuario+") No se puede insertar cateter. Es necesario especificar tipo de cateter");
		}else{
			try{
				//Cateter[] aux =this.cdao.findByDynamicWhere("MODELO=? OR GS128=?",new Object[]{this.nuevocat.getModelo(),this.nuevocat.getGs128()});
				Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("TIPO = ? AND CODIGO = ?", new Object[]{3,this.nuevocat.getGs128()});
				Cateter aux = null;
				if(codigos!=null && codigos.length>0)
					aux  = this.cdao.findByPrimaryKey(codigos[0].getIdmaterial());
				
				if(aux!=null/*aux.length>0*/){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_dupl"));
					logger.error("("+this.usuario+") No se puede insertar cateter. Elemento existente en el sistema");
				}else{
					this.nuevocat.setActivo(1);
					CateterPk catpk = this.cdao.insert(this.nuevocat);
					// INSERTAR CODIGOS GS128
					Codigosgs128 gs128 = new Codigosgs128();
					gs128.setCodigo(this.nuevocat.getGs128());
					gs128.setTipo(3);
					gs128.setIdmaterial(catpk.getIdcateter());
					this.gs128dao.insert(gs128);
					this.nuevocat.getCodigos().add(gs128);
					// Recarga de modelos con el nuevo insertado
					cargaCateteres();
					// Actualiza valor en lista el nuevo cateter
					this.eef.getListacats().get(this.getLineanuevo()).setIdcateter(catpk.getIdcateter());
					this.eef.getListacats().get(this.getLineanuevo()).setModelo(this.nuevocat.getModelo());
					this.eef.getListacats().get(this.getLineanuevo()).setDefectuoso(0);
					this.eef.getListacats().get(this.getLineanuevo()).setTipo(this.nuevocat.getTipo());	
					this.eef.getListacats().get(this.getLineanuevo()).setMuestrabarcode(false);		
								
					// Notificacion por mail
					GestorCorreo gc = new GestorCorreo();
					gc.sendMailToAdminCat(this.nuevocat, this.infocentro.getCentro(), this.usuario, 1);
					//NotificacionMaterial obj = new NotificacionMaterial();
					//obj.notificaMaterialGenerador(this.nuevomodelogen, this.nuevoreferenciagen, this.nuevofabricantegen, this.nuevotipogen, this.nuevomodogen, this.conectoravgen, this.conectorvdgen, this.conectorvigen, this.rf?"1":"0", this.mri?"1":"0",this.nombre_centro , this.nuevogs1gen);
					logger.info("("+this.usuario+") Cateter- Modelo:"+this.nuevocat.getModelo()+". GS1-128: "+this.nuevocat.getGs128()+" insertado con éxito en el sistema");
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("mat_msg_info_add"));
					this.setLineanuevo(null);
				}
				this.nuevocat = new Cateter();
			}catch(Exception e1){
				this.pintaMensaje(
						Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_error_add")+": "+ e1.getMessage());
				logger.error("("+this.usuario+") No se puede insertar cateter. Error: "+ e1.getMessage());				
			}
		}
		this.setNuevocateter(false);
	}
	
	public void cancelarNuevoCateter(ActionEvent e){
		this.nuevocat = new Cateter();
		this.setNuevocateter(false);
	}
	
	public void actualizaNuevoMaterial(ActionEvent e){
		if(this.isNuevocateter())
			this.setNuevocateter(false);
	}
	
	public void lecturaGs128Cateter(ActionEvent e){
		if(this.nuevocat.getGs128().length()>=16)// codigo GS1-128
			this.nuevocat.setGs128(this.nuevocat.getGs128().substring(0, 16).substring(2, 16));
		if(this.nuevocat.getGs128().length()!=14)
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
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
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_warn_sitclin_fe")+": "+ e1.getMessage());
			this.sitclin.setFevi(null);
		}	
	}
	public void resetFEVI(ActionEvent e){
		this.modsitclin = true;
		this.sitclin.setFevi(null);
		if((this.sitclin.getFuncionventricular()==0 || this.sitclin.getFuncionventricular()==6))
			this.pintaMensaje(
				Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sitclin_fevi"));
	}
	/******************************/
	
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
	public void cambiaCardiopatiaEtiologia(ActionEvent e) {
		if (!(this.sitclin.getCardiopatia().equals(923))) {
			this.sitclin.setOtra("");	
		}
		this.modsitclin = true;
		this.sgen.setCardiop(this.sitclin.isCardiop());
		this.sgen.setCardiopatia(this.sitclin.getCardiopatia());
		this.sgen.setOtra(this.sitclin.getOtra());
	}
	public void cambiaTipoablacion(ActionEvent e){
		if(this.nuevocat.getTipoablacion()!=null){
			if(this.nuevocat.getTipoablacion().equals(1)||this.nuevocat.getTipoablacion().equals(2)
					||this.nuevocat.getTipoablacion().equals(3)||this.nuevocat.getTipoablacion().equals(7)
					||this.nuevocat.getTipoablacion().equals(9) ||this.nuevocat.getTipoablacion().equals(10)
					||this.nuevocat.getTipoablacion().equals(11))
				this.nuevocat.setEnergia(1);//RF
			else if(this.nuevocat.getTipoablacion().equals(6))
				this.nuevocat.setEnergia(3);//laser
			else if(this.nuevocat.getTipoablacion().equals(0)||this.nuevocat.getTipoablacion().equals(8))
				this.nuevocat.setEnergia(0);//ninguna
			else
				this.nuevocat.setEnergia(2);//crioablacion
		}
	}
	/******************************/
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
		}else{
			
		}	
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

	public HtmlDataTable getBindingBuscar() {
		return bindingBuscar;
	}

	public void setBindingBuscar(HtmlDataTable bindingBuscar) {
		this.bindingBuscar = bindingBuscar;
	}

	public ArrEstudio getEef() {
		return eef;
	}

	public void setEef(ArrEstudio eef) {
		this.eef = eef;
	}

	public ArrayList<ArrEstudio> getEefs() {
		return eefs;
	}

	public HtmlDataTable getBinenf() {
		return binenf;
	}

	public void setBinenf(HtmlDataTable binenf) {
		this.binenf = binenf;
	}

	public HtmlDataTable getBinpop() {
		return binpop;
	}

	public void setBinpop(HtmlDataTable binpop) {
		this.binpop = binpop;
	}

	public HtmlDataTable getBinsop() {
		return binsop;
	}

	public void setBinsop(HtmlDataTable binsop) {
		this.binsop = binsop;
	}

	public ArrayList<SelectItem> getDiagnosticos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_diagnostico")));
		for (ArrMaestras diagnostico : this.diagnosticos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getEnfermeras() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.enfermeria)
			diag.add(new SelectItem(diagnostico.getValor(),
					diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getEnfermerasTodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.enfermeria_todos)
			diag.add(new SelectItem(diagnostico.getValor(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getPrimerOperador() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_personal")));
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
		diag.add(new SelectItem("", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.segundoop)
			diag.add(new SelectItem(diagnostico.getValor(),
					diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getSegundoOperadorTodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.segundoop_todos)
			diag.add(new SelectItem(diagnostico.getValor(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getAnestesista() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.anestesista)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getAnestesistaTodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.anestesista_todos)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getIntereses() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.interes)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getNavegadores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("-1", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.navegador)
			diag.add(new SelectItem(diagnostico.getCodigo(), diagnostico
					.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getRobot() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("-1", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.robot)
			diag.add(new SelectItem(diagnostico.getCodigo(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getEcografias() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.ecografia)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getRitmos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.ritmos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getConducciones() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.conducciones)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getQrs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.qrs)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getTipos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem("1", this.bundle.getString("prot_tipo_op1")));
		return diag;
	}
	
	public ArrayList<ArrMaestras> autocompletarCateteres(Object suggest) {
		String pref = (String) suggest;
		ArrayList<ArrMaestras> result = new ArrayList<ArrMaestras>();

		for (ArrMaestras elem : this.cateteres) {
			if ((elem.getValor().toUpperCase().startsWith(pref.toUpperCase()))) {
				result.add(elem);
			}
		}
		return result;
	}

	public ArrayList<ArrMaestras> autocompletarCateteresAblacion(Object suggest) {
		String pref = (String) suggest;
		ArrayList<ArrMaestras> result = new ArrayList<ArrMaestras>();

		for (ArrMaestras elem : this.cateteresAblacion) {
			if ((elem.getValor().toUpperCase().startsWith(pref.toUpperCase()))) {
				result.add(elem);
			}
		}
		return result;
	}

	public ArrayList<ArrMaestras> autocompletarMarcaCat(Object suggest) {
		String pref = (String) suggest;
		ArrayList<ArrMaestras> result = new ArrayList<ArrMaestras>();

		for (ArrMaestras elem : this.funciones) {
			if ((elem.getValor().toUpperCase().startsWith(pref.toUpperCase()))) {
				result.add(elem);
			}
		}
		return result;
	}

	public ArrayList<ArrMaestras> autocompletarLocalCat(Object suggest) {
		String pref = (String) suggest;
		ArrayList<ArrMaestras> result = new ArrayList<ArrMaestras>();

		for (ArrMaestras elem : this.localcateter) {
			if ((elem.getValor().toUpperCase().startsWith(pref.toUpperCase()))) {
				result.add(elem);
			}
		}
		return result;
	}
	public ArrayList<SelectItem> getLocalcateter() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.localcateter)
			diag.add(new SelectItem(diagnostico.getCodigo(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getViascateter() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.viascateter)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getHipersensibilidad() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.hipersensibilidad)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getPruebasfs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.pruebasfs)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getFisiologias() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.fisiologias)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getConduccionnodal() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.conduccionnodal)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<ArrMaestras> autocompletarFarmacosav(Object suggest) {
		String pref = (String) suggest;
		ArrayList<ArrMaestras> result = new ArrayList<ArrMaestras>();

		for (ArrMaestras elem : this.farmacosav) {
			if ((elem.getValor().toUpperCase().startsWith(pref.toUpperCase()))) {
				result.add(elem);
			}
		}
		return result;
	}

	public ArrayList<SelectItem> getBloqueos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.bloqueos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getNivelbloqueo() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.nivelbloqueo)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getTipovia() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.tipovia)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getSentidos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.sentidos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getTipoconduccion() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.tipoconduccion)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getTipoperiodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.tipoperiodos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<ArrMaestras> autocompletarTejidos(Object suggest) {
		String pref = (String) suggest;
		ArrayList<ArrMaestras> result = new ArrayList<ArrMaestras>();

		for (ArrMaestras elem : this.tejidos) {
			if ((elem.getValor().toUpperCase().startsWith(pref.toUpperCase()))) {
				result.add(elem);
			}
		}
		return result;
	}

	public ArrayList<SelectItem> getFarmacospr() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.farmacospr)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getPuntoestimula() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.puntoestimula)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getModoinduccion() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.modoinduccion)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getInduccionaavv() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.induccionaavv)
			diag.add(new SelectItem(diagnostico.getCodigo(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getFarmacostaqui() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		for (ArrMaestras diagnostico : this.farmacostaqui)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getPruebasav() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.pruebasav)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getResultadosfs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.resultadosfs)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getResultadosav() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.resultadosav)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getTipoProcedimientos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.tipoProcedimientos)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),
					procedimiento.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getMorfologias() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.morfologias)
			diag.add(new SelectItem(procedimiento.getCodigo().toString(),
					procedimiento.getValor()));
		return diag;
	}

	public HtmlDataTable getBinlsttaq() {
		return binlsttaq;
	}

	public void setBinlsttaq(HtmlDataTable binlsttaq) {
		this.binlsttaq = binlsttaq;
	}

	public HtmlDataTable getBinlstabl() {
		return binlstabl;
	}

	public void setBinlstabl(HtmlDataTable binlstabl) {
		this.binlstabl = binlstabl;
	}

	public ArrayList<EpisodioDto> getEpisodios() {
		return episodios;
	}

	public HtmlDataTable getBindingepi() {
		return bindingepi;
	}

	public void setBindingepi(HtmlDataTable bindingepi) {
		this.bindingepi = bindingepi;
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
			consultaNueva.setIdinforext("" + this.eef.getIdestudio());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.eef.getEpisodio() != null && this.eef.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.eef.getEpisodio());
			else
				consultaNueva.setEpisodio("0");
			UsuarioDao usDao = new UsuarioDao();
        	SesionUsuarioDto ses = new SesionUsuarioDto();
        	ses.setLogin(this.usuario);
			String doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
			consultaNueva.setRedactor(doctor);
			consultaNueva.setResponprime(doctor);
			consultaNueva.setServicio("QCAR");
			Timestamp fecT = UtilFechas.dateToTimestamp(this.eef.getFecha());
			consultaNueva.setFcreacion(fecT);
			Time t = new Time(fecT.getTime());
			consultaNueva.setHcreacion(t);
			consultaNueva.setIdtipodoc(47);
			consultaNueva.setIdsubti("ARR01");
			enviaInformeFTP(consultaNueva, true, path);

		} else {
			Timestamp fecT = UtilFechas.dateToTimestamp(this.eef.getFecha());
			Time t = new Time(fecT.getTime());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.eef.getEpisodio() != null && this.eef.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.eef.getEpisodio());
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
			consultaNueva.setIdinforext("" + this.eef.getIdestudio());
			consultaNueva.setIdsubti("ARR01");
			consultaNueva.setIdtipodoc(47);
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
	
	public boolean getIsEEP(){
		if(this.eef != null && this.eef.getTaquicardidto() != null){
			if(this.eef.getTaquicardidto().getIdn1() != null && this.eef.getTaquicardidto().getInduccion() != null
					&& (this.eef.getTaquicardidto().getInduccion() == 3 || this.eef.getTaquicardidto().getInduccion() == 4)
					&& this.eef.getTaquicardidto().getIdn1() == 7 || this.eef.getTaquicardidto().getIdn1() == 8)
				return true;
			if(this.eef.getTaquicardidto().getInduccion() != null && this.eef.getTaquicardidto().getInduccion() == 2)
				return true;
		}
		return false;
	}

	public ArrayList<SelectItem> getTipoTaquicardias() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem("1", this.bundle.getString("eef_taqui_t1")));
		diag.add(new SelectItem("2", this.bundle.getString("eef_taqui_t2")));
		diag.add(new SelectItem("3", this.bundle.getString("eef_taqui_t3")));
		diag.add(new SelectItem("4", this.bundle.getString("eef_taqui_t4")));
		diag.add(new SelectItem("5", this.bundle.getString("eef_taqui_t5")));
		diag.add(new SelectItem("6", this.bundle.getString("eef_taqui_t6")));
		diag.add(new SelectItem("7", this.bundle.getString("eef_taqui_t7")));
		diag.add(new SelectItem("8", this.bundle.getString("eef_taqui_t8")));
		return diag;
	}
	
	public ArrayList<SelectItem> getTipoTaquicardiasN2() {
		ArrayList<SelectItem> diag = null;
		switch (this.eef.getTaquicardidto().getIdn1()) {
		case 1:
			diag = new ArrayList<SelectItem>();
			diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
			diag.add(new SelectItem("1", this.bundle.getString("eef_taqui_t1_op1")));
			diag.add(new SelectItem("2", this.bundle.getString("eef_taqui_t1_op2")));
			break;
		case 2:
			diag = new ArrayList<SelectItem>();
			diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
			diag.add(new SelectItem("1", this.bundle.getString("eef_taqui_t2_op1")));
			diag.add(new SelectItem("2", this.bundle.getString("eef_taqui_t2_op2")));
			diag.add(new SelectItem("3", this.bundle.getString("eef_taqui_t2_op3")));
			diag.add(new SelectItem("4", this.bundle.getString("eef_taqui_t2_op4")));
			break;
		case 4:
			diag = new ArrayList<SelectItem>();
			diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
			diag.add(new SelectItem("1", this.bundle.getString("eef_taqui_t4_op1")));
			diag.add(new SelectItem("2", this.bundle.getString("eef_taqui_t4_op2")));
			diag.add(new SelectItem("3", this.bundle.getString("eef_taqui_t4_op3")));
			diag.add(new SelectItem("4", this.bundle.getString("eef_taqui_t4_op4")));
			break;
		case 5:
			diag = new ArrayList<SelectItem>();
			diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
			diag.add(new SelectItem("1", this.bundle.getString("eef_taqui_t5_op1")));
			diag.add(new SelectItem("2", this.bundle.getString("eef_taqui_t5_op2")));
			diag.add(new SelectItem("3", this.bundle.getString("eef_taqui_t5_op3")));
			break;
		case 7:
			diag = new ArrayList<SelectItem>();
			diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
			diag.add(new SelectItem("1", this.bundle.getString("eef_taqui_t7_op1")));
			diag.add(new SelectItem("2", this.bundle.getString("eef_taqui_t7_op2")));
			break;
		default:
			break;
		}
		return diag;
	}
	
	public ArrayList<SelectItem> getTipoTaquicardiasN3() {
		ArrayList<SelectItem> diag = null;
		if(this.eef.getTaquicardidto().getIdn1() == 2 && this.eef.getTaquicardidto().getIdn2() == 4){
			diag = new ArrayList<SelectItem>();
			diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
			diag.add(new SelectItem("1", this.bundle.getString("eef_taqui_t2_op4_op1")));
			diag.add(new SelectItem("2", this.bundle.getString("eef_taqui_t2_op4_op2")));
		}
		else if(this.eef.getTaquicardidto().getIdn1() == 7 && this.eef.getTaquicardidto().getIdn2() == 2){
			diag = new ArrayList<SelectItem>();
			diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
			diag.add(new SelectItem("1", this.bundle.getString("eef_taqui_t7_op2_op1")));
			diag.add(new SelectItem("2", this.bundle.getString("eef_taqui_t7_op2_op2")));
			diag.add(new SelectItem("3", this.bundle.getString("eef_taqui_t7_op2_op3")));
		}
		return diag;
	}
	
	public String getTiempo(){
		//ExternalContext actual = FacesContext.getCurrentInstance().getExternalContext();
		//if(actual != null && actual.getRequestPathInfo().equals("/ventanas/eef/eef.jsp")){
			if(this.eef.isIniciado()){
				String time = "";
				if(this.minutos == 0 /*&& this.segundos == 0*/){
					//this.guardaEstudio(null);// deshabilitado por mejoras
					this.inicializaTiempo();
					this.minutos--;
				}else{
					/*if(this.segundos == 0){
						this.minutos--;
						this.segundos = 59;
					}else{*/
						//this.segundos--;
					//}
					this.minutos--;
				}
				time = "0" + (this.minutos+1); //+ ":";
				/*if(this.segundos < 10)
					time += "0" + this.segundos;
				else
					time += this.segundos;*/
				return this.bundle.getString("tiempo_guardado")+": " + time + this.bundle.getString("minutos")+" .";
			}
			else
				return "";
		/*}else{
			return "";
		}*/
	}
	
	public void anuladiag(ActionEvent e){
		if(this.eef != null)
			this.eef = new ArrEstudio();
		this.inicializaTiempo();
	}
	
	private void inicializaTiempo(){
		this.minutos = 9;
		this.segundos = 59;
	}

	public HtmlDataTable getBindingHistoricoEef() {
		return bindingHistoricoEef;
	}

	public void setBindingHistoricoEef(HtmlDataTable bindingHistoricoEef) {
		this.bindingHistoricoEef = bindingHistoricoEef;
	}
	public void lecturaProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
		p.load(is);
		is.close();
		this.infocentro = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
					p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"));
	}

	public ArrayList<Procedimiento> getProcs() {
		return procs;
	}

	public void setProcs(ArrayList<Procedimiento> procs) {
		this.procs = procs;
	}
	
	public void controlSinusalPf(ActionEvent e){
		int dup=0;
		for(ArrSinusalPf s:this.eef.getSinusaldto().getPruebas()){
			if(s.getPrueba().equals(this.eef.getSinusaldto().getPruebas().get(this.eef.getSinusaldto().getBinsin().getRowIndex()).getPrueba())
					&& s.getResultado().equals(this.eef.getSinusaldto().getPruebas().get(this.eef.getSinusaldto().getBinsin().getRowIndex()).getResultado())){
				dup++;		
			}	
			if(dup>1){
				// Duplicado
				//this.setSintomasDuplicados(true);
				this.eef.getSinusaldto().getPruebas().remove(this.eef.getSinusaldto().getBinsin().getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_pfarm_dupl"));
				break;
			}
		}
	}
	public void controlCAVEstimulacion(ActionEvent e){
		int dup=0;
		for(ArrConduccEc s:this.eef.getConducciondto().getEstim()){
			if(s.getConduc().equals(this.eef.getConducciondto().getEstim().get(this.eef.getConducciondto().getBinestim().getRowIndex()).getConduc())){
				dup++;		
			}	
			if(dup>1){
				// Duplicado
				this.eef.getConducciondto().getEstim().remove(this.eef.getConducciondto().getBinestim().getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_cav_ec_dupl"));
				break;
			}
		}
	}
	public void controlCAVPf(ActionEvent e){
		int dup=0;
		for(ArrConducPf s:this.eef.getConducciondto().getPruebas()){
			if(s.getPrueba().equals(this.eef.getConducciondto().getPruebas().get(this.eef.getConducciondto().getBinpru().getRowIndex()).getPrueba())
					&& s.getResultado().equals(this.eef.getConducciondto().getPruebas().get(this.eef.getConducciondto().getBinpru().getRowIndex()).getResultado())){
				dup++;		
			}	
			if(dup>1){
				// Duplicado
				this.eef.getConducciondto().getPruebas().remove(this.eef.getConducciondto().getBinpru().getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_cav_pfarma_dupl"));
				break;
			}
		}
	}
	public void controlVias(ActionEvent e){
		int dup=0;
		for(ArrEstudioVias s:this.eef.getViasdto()){
			if(s.getIdvia().equals(this.eef.getViasdto().get(this.eef.getBinvias().getRowIndex()).getIdvia())){
				dup++;		
			}	
			if(dup>1){
				// Duplicado
				this.eef.getViasdto().remove(this.eef.getBinvias().getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_vacc_dupl"));
				break;
			}
		}
	}
	
	/**
	 * Funcion para validar formulario EEF a guardar. Control de inconsistencia de información a guardar
	 * @return
	 */
	private boolean validaFormulario(){
		boolean res = true;
		/*
		 * 1. Control duplicado operadores
		 * 		Evitar duplicados sin especificar de Enf, Pop y Sop.
		 * 		Los duplicados con nombre especificado se corrigen en tiempo de insercion de formulario
		 */
		int dup = 0;
		// Enf
		for(ArrEstudioEnf e:this.eef.getEnfermeras()){
			if(e.getIdenfermera().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_enf_noinfo"));
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_enf_dupl"));
				res = false;
			}		
		}
		dup = 0;
		// Pop
		for(ArrEstudioPop e:this.eef.getPoperador()){
			if(e.getIdoperador().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_pop_noinfo"));
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_pop_dupl"));
				res = false;
			}		
		}
		dup = 0;
		// Sop
		for(ArrEstudioSop e:this.eef.getSoperador()){
			if(e.getIdoperador().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_sop_noinfo"));
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_sop_dupl"));
				res = false;
			}		
		}
		dup = 0;
		// Anestesistas
		for(ArrEstudioAnest e:this.eef.getAnest()){
			if(e.getIdanestesista().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_ane_noinfo"));
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_ane_dupl"));
				res = false;
			}		
		}
		/*
		 * 2. Control duplicado Funcion Sinusal/Pruebas farmacologicas
		 * 		Evitar duplicados sin especificar o .
		 */
		dup=0;
		for(ArrSinusalPf s:this.eef.getSinusaldto().getPruebas()){
			if(s.getPrueba()==0 && s.getResultado().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_fsin_pfarma_noinfo"));
			}				
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_fsin_pfarma_dupl"));
				res = false;
			}
		}
		/*
		 * 3. Control Taquicardias
		 * 		Evitar entradas sin especificar -> induccion. En otro caso no genera el informe adecuadamente
		 */
		for(ArrEstudioTaqui tq:this.eef.getLsttaquicardias()){
			if(tq.getInduccion()==null || tq.getInduccion()==0)
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_taq_ind_noinfo"));
		}
		/*
		 * 4. Control Periodos refractarios
		 * 		Evitar entradas sin especificar -> Tipo Periodo. En otro caso no genera el informe adecuadamente
		 */
		for(ArrEstudioPeriodo pr:this.eef.getPeriodosdto()){
			if(pr.getIdtipo()==null || pr.getIdtipo()==0)
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_pref_tipo_noinfo"));
		}
		/*
		 * 5. Control ECG
		 * 		Warning de no rellenado de Conduccion AV/QRS -> No normal
		 */
		if(this.eef.getEcgdto().getIdconduccionno()!=null && this.eef.getEcgdto().getIdconduccionno()==0 && this.eef.getEcgdto().getIdconduccion()==1)
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_ecg_cav_noinfo"));
		if(this.eef.getEcgdto().getIdqrsno()!=null && this.eef.getEcgdto().getIdqrsno()==0 && this.eef.getEcgdto().getIdqrs()==1)
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_ecg_qrs_noinfo"));
		/*
		 * 6. Control Conduccion AV
		 * 		Warning de no rellenado de Estimulacion continua 
		 */
		dup=0;
		for(ArrConduccEc s:this.eef.getConducciondto().getEstim()){
			if(s.getConduc()==0){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_cav_ec_noinfo"));
			}				
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_cav_ec_dupl_1"));
				res = false;
			}
		}
		/*
		 * 7. Control Conduccion AV
		 * 		Warning de no rellenado de Prueba Farmacologica 
		 */
		dup=0;
		for(ArrConducPf s:this.eef.getConducciondto().getPruebas()){
			if(s.getPrueba()==0 && s.getResultado().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_cav_pfarma_noinfo"));
			}				
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_cav_pfarma_dupl_1"));
				res = false;
			}
		}
		/*
		 * 8. Control Vias Accesorias
		 * 		Warning de no rellenado de vias accesorias 
		 */
		dup=0;
		for(ArrEstudioVias s:this.eef.getViasdto()){
			if(s.getIdvia()==0){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_vacc_noinfo"));
			}				
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_vacc_dupl_1"));
				res = false;
			}
		}
		/*
		 * 9. Control Sintomas
		 * 		Warning de no rellenado de vias accesorias 
		 */
		dup=0;
		for(SintomasSitclinProc s:this.sitclin.getSintomas()){
			if(s.getIdsintomas()==null || s.getIdsintomas().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_sint_noinfo"));
			}				
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_sint_dupl"));
				res = false;
				break;
			}
		}
		
		return res;	
	}
	private boolean validarCateteresDiagnosticos(){
		/*
		 * Control Duplicado Cateteres Diagnosticos
		 */
		int dup=0;
		for(ArrEstudioCatUso s:this.eef.getListacats()){
			if(s.getIdcateter()==null ||s.getIdcateter()==0){
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_cats_noinfo"));
				return false;
			}				
			for(int i=0;i<this.eef.getListacats().size();i++){
				if(s.getIdcateter().equals(this.eef.getListacats().get(i).getIdcateter())
					&& s.getIdlocalizacion()!=null
					&& s.getIdlocalizacion().equals(this.eef.getListacats().get(i).getIdlocalizacion())){
					dup++;		
				}	
				if(dup>1){
					// Duplicado
					this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_cats_dupl"));
					return false;
				}
			}
			
			dup=0;
		}
		for(ArrEstudioCatApl s:this.eef.getAblaciondto().getListapls()){
			if(s.getIdcatuso()==null ||s.getIdcatuso()==0
					|| s.getIdvia()==null || s.getIdvia()==0){
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_cats_via_abord_noinfo"));
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Funcion de control de campos de formulario no rellenados. Se genera un Warning
	 */
	private void generaWarnings(){
		
	}

	public HtmlDataTable getBinanest() {
		return binanest;
	}

	public void setBinanest(HtmlDataTable binanest) {
		this.binanest = binanest;
	}

	public HtmlDataTable getBindingEnf() {
		return bindingEnf;
	}

	public void setBindingEnf(HtmlDataTable bindingEnf) {
		this.bindingEnf = bindingEnf;
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

	public Cateter[] getCats_abl() {
		return cats_abl;
	}

	public void setCats_abl(Cateter[] cats_abl) {
		this.cats_abl = cats_abl;
	}

	public Cateter[] getCats_diag() {
		return cats_diag;
	}

	public void setCats_diag(Cateter[] cats_diag) {
		this.cats_diag = cats_diag;
	}

	public HtmlDataTable getBindingCatDiag() {
		return bindingCatDiag;
	}

	public void setBindingCatDiag(HtmlDataTable bindingCatDiag) {
		this.bindingCatDiag = bindingCatDiag;
	}

	public boolean isModavcatdiag() {
		return modavcatdiag;
	}

	public void setModavcatdiag(boolean modavcatdiag) {
		this.modavcatdiag = modavcatdiag;
	}

	public Cateter getNuevocat() {
		return nuevocat;
	}

	public void setNuevocat(Cateter nuevocat) {
		this.nuevocat = nuevocat;
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

	public SituacionClinicaGeneral getSgen() {
		return sgen;
	}

	public void setSgen(SituacionClinicaGeneral sgen) {
		this.sgen = sgen;
	}

	public int getIdviaaux() {
		return idviaaux;
	}

	public void setIdviaaux(int idviaaux) {
		this.idviaaux = idviaaux;
	}
	
	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public boolean isUsaLector() {
		return usaLector;
	}

	public void setUsaLector(boolean usaLector) {
		this.usaLector = usaLector;
	}

	public boolean isNuevocateter() {
		return nuevocateter;
	}

	public void setNuevocateter(boolean nuevocateter) {
		this.nuevocateter = nuevocateter;
	}

	public Integer getLineanuevo() {
		return lineanuevo;
	}

	public void setLineanuevo(Integer lineanuevo) {
		this.lineanuevo = lineanuevo;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Integer getTAQUIARR_AUR() {
		return TAQUIARR_AUR;
	}

	public void setTAQUIARR_AUR(Integer tAQUIARR_AUR) {
		TAQUIARR_AUR = tAQUIARR_AUR;
	}

	public ComplicacionesPacientes getCompacDiag() {
		return compacDiag;
	}

	public void setCompacDiag(ComplicacionesPacientes compacDiag) {
		this.compacDiag = compacDiag;
	}

	public ComplicacionesPacientes getCurrentItemComp() {
		return currentItemComp;
	}

	public void setCurrentItemComp(ComplicacionesPacientes currentItemComp) {
		this.currentItemComp = currentItemComp;
	}

	public HtmlDataTable getBindingComplicacionesDiagProc() {
		return bindingComplicacionesDiagProc;
	}

	public void setBindingComplicacionesDiagProc(
			HtmlDataTable bindingComplicacionesDiagProc) {
		this.bindingComplicacionesDiagProc = bindingComplicacionesDiagProc;
	}

	public boolean isEditableProc() {
		return editableProc;
	}

	public void setEditableProc(boolean editableProc) {
		this.editableProc = editableProc;
	}

	public ArrAblacionComplica getCurrentItemAblComp() {
		return currentItemAblComp;
	}

	public void setCurrentItemAblComp(ArrAblacionComplica currentItemAblComp) {
		this.currentItemAblComp = currentItemAblComp;
	}

	public boolean isEditableAblProc() {
		return editableAblProc;
	}

	public void setEditableAblProc(boolean editableAblProc) {
		this.editableAblProc = editableAblProc;
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

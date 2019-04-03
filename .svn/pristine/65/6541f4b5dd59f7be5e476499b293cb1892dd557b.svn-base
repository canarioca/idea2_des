package com.sorin.idea.iu;


import hvn.cm.modelo.Mensaje;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.richfaces.component.html.HtmlDataGrid;

import com.sorin.idea.correo.GestorCorreo;
import com.sorin.idea.dao.Codigosgs128Dao;
import com.sorin.idea.dao.ComplicacionDao;
import com.sorin.idea.dao.ComplicacionesPacientesDao;
import com.sorin.idea.dao.ElectrodosDao;
import com.sorin.idea.dao.EpisodioDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dao.GenvaloresfabricaDao;
import com.sorin.idea.dao.ImpAtpDao;
import com.sorin.idea.dao.ImpChoquesDao;
import com.sorin.idea.dao.ImpEvolucionComplicacionDao;
import com.sorin.idea.dao.ImpEvolucionDao;
import com.sorin.idea.dao.ImpGeneradorDao;
import com.sorin.idea.dao.ImpHojaImplanteComplicacionDao;
import com.sorin.idea.dao.ImpHojaImplanteDao;
import com.sorin.idea.dao.ImpHojaImplanteEnfDao;
import com.sorin.idea.dao.ImpHojaImplantePopDao;
import com.sorin.idea.dao.ImpHojaImplanteSopDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.ImpImplanteElectrodosDao;
import com.sorin.idea.dao.ImpIndicacionDao;
import com.sorin.idea.dao.ImpMedIntraDao;
import com.sorin.idea.dao.ImpSintomasDao;
import com.sorin.idea.dao.ImpZonaDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.SegSeguimientoDao;
import com.sorin.idea.dao.SegSistemaDao;
import com.sorin.idea.dao.SintomasSitclinProcDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dto.ArrEstudioEnf;
import com.sorin.idea.dto.ArrEstudioPop;
import com.sorin.idea.dto.ArrEstudioSop;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrSinusalPf;
import com.sorin.idea.dto.Codigosgs128;
import com.sorin.idea.dto.Complicacion;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.ElectrodosPk;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.GeneradorPk;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.ImpAtp;
import com.sorin.idea.dto.ImpAtpPk;
import com.sorin.idea.dto.ImpChoques;
import com.sorin.idea.dto.ImpChoquesPk;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpEvolucionComplicacion;
import com.sorin.idea.dto.ImpEvolucionComplicacionPk;
import com.sorin.idea.dto.ImpEvolucionPk;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpGeneradorPk;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.ImpHojaImplanteComplicacionPk;
import com.sorin.idea.dto.ImpHojaImplanteEnf;
import com.sorin.idea.dto.ImpHojaImplanteEnfPk;
import com.sorin.idea.dto.ImpHojaImplantePk;
import com.sorin.idea.dto.ImpHojaImplantePop;
import com.sorin.idea.dto.ImpHojaImplantePopPk;
import com.sorin.idea.dto.ImpHojaImplanteSop;
import com.sorin.idea.dto.ImpHojaImplanteSopPk;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpImplanteElectrodosPk;
import com.sorin.idea.dto.ImpImplantePk;
import com.sorin.idea.dto.ImpIndicacion;
import com.sorin.idea.dto.ImpIndicacionPk;
import com.sorin.idea.dto.ImpMedIntra;
import com.sorin.idea.dto.ImpSintomas;
import com.sorin.idea.dto.ImpSintomasPk;
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.ImpZonaPk;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.SegSeguimiento;
import com.sorin.idea.dto.SegSistema;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SintomasSitclinProcPk;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.SituacionClinicaProcPk;
import com.sorin.idea.exceptions.ElectrodosDaoException;
import com.sorin.idea.exceptions.GeneradorDaoException;
import com.sorin.idea.exceptions.ImpImplanteDaoException;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.exceptions.SituacionClinicaGeneralDaoException;
import com.sorin.idea.jdbc.Codigosgs128DaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesPacientesDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.GenvaloresfabricaDaoImpl;
import com.sorin.idea.jdbc.ImpAtpDaoImpl;
import com.sorin.idea.jdbc.ImpChoquesDaoImpl;
import com.sorin.idea.jdbc.ImpEvolucionComplicacionDaoImpl;
import com.sorin.idea.jdbc.ImpEvolucionDaoImpl;
import com.sorin.idea.jdbc.ImpGeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteComplicacionDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteEnfDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplantePopDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteSopDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteElectrodosDaoImpl;
import com.sorin.idea.jdbc.ImpIndicacionDaoImpl;
import com.sorin.idea.jdbc.ImpMedIntraDaoImpl;
import com.sorin.idea.jdbc.ImpSintomasDaoImpl;
import com.sorin.idea.jdbc.ImpZonaDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.jdbc.SegSeguimientoDaoImpl;
import com.sorin.idea.jdbc.SegSistemaDaoImpl;
import com.sorin.idea.jdbc.SintomasSitclinProcDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.notificacion.NotificacionMaterial;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.GestorCodigoBarras;
import com.sorin.idea.util.GestorFTPInforme;
import com.sorin.idea.util.ImplanteSeguimientoBean;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.TarjetaMP;
import com.sorin.idea.util.UtilConversorTarjetaEuropea;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilMapeos;
import com.sorin.idea.util.UtilReporteInformes;
import com.sorin.idea.util.UtilReporteRegistroDAI;

public class ControlImplantes extends BaseIU {

	private static Logger logger = Logger.getLogger(ControlImplantes.class);
	private LoginForm lf;
	private java.sql.Connection conn; 
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private Integer IDVIA = 924;
	private Integer IDLATERALIDAD = 951;
	private Integer IDZONA_SICD;// a particularizar por centro
	private Integer IDZONA_AD = 930;
	private Integer IDZONA_VD = 937;
	private Integer IDVIRTUAL;
	private Electrodos IDSICD;
	
	private String usuario="";
	private ControlPacientes cp;
	private ControlSeguimientos cseg;
	private ControlMaestras cm;
	private HtmlDataTable bindingElec;
	private HtmlDataTable bindingGen;
	private HtmlDataTable bindingCompliIntra;
	private HtmlDataTable bindingCompliPost;
	// private HtmlDataTable bindingZona;
	// private HtmlDataTable bindingZonaV;
	private HtmlDataTable bindingAtpZona;
	protected HtmlDataTable bindingChoques;
	protected HtmlDataTable bindingSeguimientos;

	private boolean actualizacion;
	private boolean recambioGen;
	private boolean recolocacionGen;
	private boolean explanteGen;

	private String tipoprocedimiento;
	private boolean previoimp;
	private boolean completado;

	private int secactivacion;
	private boolean estimfrenica;
	private int optint;

	/***************************************************/
	private Procedimiento[] proclst;
	private Procedimiento[] lstprocsseg;
	private ArrayList<ImplanteSeguimientoBean> procs;
	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ProcedimientoDao procdao;
	private HtmlDataTable bindingBuscar;

	private ImpImplanteDao impdao;
	private ImpImplante impl;
	private ImpImplantePk implpk;
	private SituacionClinicaProcDao hinddao;
	private SituacionClinicaProc hind;
	private SituacionClinicaProcPk hindpk;
	private ImpHojaImplantePk himppk;
	private ImpHojaImplante himp;
	private ImpHojaImplanteDao himpdao;
	private ImpEvolucionPk hevpk;
	private ImpEvolucion hev;
	private ImpEvolucionDao hevdao;

	private SintomasSitclinProcDao sintdao;
	private ImpHojaImplantePopDao popdao;
	private ImpHojaImplanteSopDao sopdao;
	private ImpHojaImplanteEnfDao enfdao;
	private ImpGeneradorDao gendao;
	private ImpImplanteElectrodosDao impelecdao;
	private ImpGenerador impgendao;
	private ImpZonaDao zonadao;
	private ImpAtpDao atpdao;
	private ImpChoquesDao choquedao;
	private ArrayList<ImpZonaPk> listazonapk;
	private ArrayList<ImpAtpPk> listaatppk;
	private ArrayList<ImpChoquesPk> listachoquespk;
	private SegSeguimientoDao segdao;

	private GeneradorDao g;
	private Generador[] generadores;
	private ArrayList<ImpGenerador> listagenerador;
	private ArrayList<ImpGenerador> listageneradorexp;
	private ArrayList<ImpGenerador> listageneradorexptarjeta;
	private ImpGeneradorPk genpk;
	private ImpGeneradorPk genexppk;
	private ElectrodosDao e;
	private Electrodos[] electrodos;
	private ArrayList<ImpImplanteElectrodos> listaelectrodos;
	private ArrayList<ImpImplanteElectrodosPk> listaelectrodospk;
	private ArrayList<ImpImplanteElectrodos> listaelectrodosexp;
	private ArrayList<ImpImplanteElectrodosPk> listaelectrodosexppk;
	private ArrayList<ImpImplanteElectrodos> listaelectrodosexptarjeta;
	private ImpImplanteElectrodos currentItemElectrodos;
	private ImpImplanteElectrodos currentItemElectrodosBackUp;
	private ImpImplanteElectrodos currentItemElectrodosEliminar;
	private ImpImplanteElectrodos currentItemElectrodosEliminarBackUp;
	private ImpMedIntraDao medintradao;
	

	private ComplicacionDao compdao;
	private Complicacion[] complicacionesintra;
	private Complicacion[] complicacionespost;
	private ArrayList<ImpHojaImplanteComplicacion> listacomplicacionesintra;
	private ArrayList<ImpEvolucionComplicacion> listacomplicacionespost;
	private ImpHojaImplanteComplicacionDao compintradao;
	private ImpEvolucionComplicacionDao comppostdao;

	private ArrayList<SelectItem> lcompintraquir;
	private ArrayList<SelectItem> lcompintraarr;
	private ArrayList<SelectItem> lcompintratmp;
	private ArrayList<SelectItem> lcompintraresp;
	private ArrayList<SelectItem> lcompintramuerte;

	private ArrayList<SelectItem> lcomppostelect;
	private ArrayList<SelectItem> lcomppostarr;
	private ArrayList<SelectItem> lcompposttmp;
	private ArrayList<SelectItem> lcomppostresp;
	private ArrayList<SelectItem> lcomppostmuerte;

	private ArrMaestras[] tipoproc;
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
	private ArrMaestras[] localizaciongen;
	private ArrMaestras[] viaaccesoimplante;
	private ArrMaestras[] camara;
	private ArrMaestras[] lateralidad;
	private ArrMaestras[] zonacamaraad;
	private ArrMaestras[] zonacamaravd;
	private ArrMaestras[] zonacamaravi;
	private ArrMaestras[] zonacamarasicd;
	private ArrMaestras[] zonaepicardico;
	private ArrMaestras[] porcion;
	private ArrMaestras[] mrecambiogen;
	private ArrMaestras[] mrecolocaciongen;
	private ArrMaestras[] mexplantegen;
	private ArrMaestras[] mrecambioelec;
	private ArrMaestras[] mrecolocacionelec;
	private ArrMaestras[] mexplanteelec;
	private ArrMaestras[] tipocomplicacion;
	private ArrMaestras[] tipocomplicacionpost;
	private ArrMaestras[] hprocedencia;
	private ArrMaestras[] modogen;
	private ArrMaestras[] modogen2;
	private ArrMaestras[] motivosterapianoapropiada;
	
	private ArrMaestras[] fabgen;
	private ArrMaestras[] cadgen;
	private ArrMaestras[] cvdgen;
	private ArrMaestras[] cvigen;
	private ArrMaestras[] fabelec;
	private ArrMaestras[] polelec;
	private ArrMaestras[] conelec;
	private ArrMaestras[] fijaelec;
	private ArrMaestras[] bobelec;
	
	private HtmlDataTable binEnf;
	private HtmlDataTable binPop;
	private HtmlDataTable binSop;
	private HtmlDataTable bindingSintomas;
	private String columna = "fecha";
	private boolean ascendente = false;

	private boolean avzona;
	private boolean modgen;
	private boolean modelec;
	private HtmlDataGrid bindingGrid;
	private boolean tarjetaeuropea;
	private boolean elecdisfexp;
	private boolean elecdisfaband;
	private boolean elecfunc;
	private int tipogen;
	private String modogenini;
	private boolean intprevia;
	private String barCodeGen;
	private InfoCentro infocentro;
	private Date backupFecha;
	private boolean upgrade;
	private boolean recolocacion;
	private boolean sintomasDuplicados;
	private SituacionClinicaGeneral sgen;
	private boolean modsitclin;
	private boolean cambioGen;
	private boolean esSorin;
	
	private Generador[] generadores2;
	private Electrodos[] electrodos2;
	
	private ControlMaterial cmat;
	private Generador nuevogen;
	private Electrodos nuevoelec;
	/******************************/
	/******************************/
	
	private int LONGITUD_GS128 = 34;
	private boolean usaLector;
	private EpisodioDao epdao;
	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	private EventoDao evdao;
	
	//////////////////
	private ArrayList<SelectItem> vectorinicial;
	private ArrayList<SelectItem> vectorfinal; 
	private Date fechaimplante;
	private String selectedtab;
	
	private Codigosgs128Dao gs128dao;
	private GenvaloresfabricaDao genfabdao;
	private boolean ngen;
	private boolean nelec;
	private Integer lineanuevogen;
	private Integer lineanuevoelec;
	
	private Integer tipoprocmanual;
	
	private boolean editable;
	
	private ControlComplicaciones cc;
	private ComplicacionesPacientes compac;
	private ComplicacionesPacientes compacpost;
	private ComplicacionesPacientes currentItemComp;
	private ComplicacionesPacientes currentItemCompPost;
	private HtmlDataTable bindingComplicacionesImpProc;
	private HtmlDataTable bindingComplicacionesImpProcPost;
	private ArrayList<ComplicacionesPacientes> listacomp;
	private ArrayList<ComplicacionesPacientes> listacomppost;
	private boolean editableImpProc;
	private boolean editableImpEvProc;
	
	public ControlImplantes() {

	}

	public void iniciaImplantes(ActionEvent e) {
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			//this.conn = ResourceManager.getConnection();
			this.episodios = new ArrayList<EpisodioDto>();
			this.setEditable(true);
			lecturaProperties();
			this.cargaMaestras();
			this.cargaGeneradores();
			this.cargaElectrodos();
			this.cargaComplicacionesIntra();
			this.cargaComplicacionesPost();
			this.setImpl(new ImpImplante());
			this.impl.setFechaimplante(new Date());		
			this.setBackupFecha(this.impl.getFechaimplante());
			this.setProc(new Procedimiento());
			this.proc.setFecha(new Date());
			this.setTipoprocmanual(0);
			this.fechaimplante = new Date();
			this.setHimp(new ImpHojaImplante());
			this.setHind(new SituacionClinicaProc());
			this.setHev(new ImpEvolucion());
			this.cargaRecomendaciones(null);
			// por defecto - parametros generales
			this.setTipogen(0);
			this.setListagenerador(new ArrayList<ImpGenerador>());
			this.setListageneradorexp(new ArrayList<ImpGenerador>());
			this.setListaelectrodos(new ArrayList<ImpImplanteElectrodos>());
			this.setListaelectrodospk(new ArrayList<ImpImplanteElectrodosPk>());
			this.setListaelectrodosexp(new ArrayList<ImpImplanteElectrodos>());
			this.setListaelectrodosexppk(new ArrayList<ImpImplanteElectrodosPk>());
			this.setListacomplicacionesintra(new ArrayList<ImpHojaImplanteComplicacion>());
			this.setListacomplicacionespost(new ArrayList<ImpEvolucionComplicacion>());
			this.setListazonapk(new ArrayList<ImpZonaPk>());
			this.setListaatppk(new ArrayList<ImpAtpPk>());
			this.setListachoquespk(new ArrayList<ImpChoquesPk>());
			this.impdao = new ImpImplanteDaoImpl(this.usuario);
			this.implpk = new ImpImplantePk();
			this.hinddao = new SituacionClinicaProcDaoImpl(this.usuario);
			this.hindpk = new SituacionClinicaProcPk();
			this.himpdao = new ImpHojaImplanteDaoImpl(this.usuario);
			this.himppk = new ImpHojaImplantePk();
			this.hevdao = new ImpEvolucionDaoImpl(this.usuario);
			this.hevpk = new ImpEvolucionPk();
			this.medintradao = new ImpMedIntraDaoImpl(this.usuario);
			this.sintdao = new SintomasSitclinProcDaoImpl(this.usuario);
			this.popdao = new ImpHojaImplantePopDaoImpl(this.usuario);
			this.sopdao = new ImpHojaImplanteSopDaoImpl(this.usuario);
			this.enfdao = new ImpHojaImplanteEnfDaoImpl(this.usuario);
			this.gendao = new ImpGeneradorDaoImpl(this.usuario);
			this.impelecdao = new ImpImplanteElectrodosDaoImpl(this.usuario);
			this.zonadao = new ImpZonaDaoImpl(this.usuario);
			this.atpdao = new ImpAtpDaoImpl(this.usuario);
			this.setChoquedao(new ImpChoquesDaoImpl(this.usuario));
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.gs128dao = new Codigosgs128DaoImpl(this.usuario);
			this.genfabdao = new GenvaloresfabricaDaoImpl(this.usuario);
			this.procpk = new ProcedimientoPk();
			this.setActualizacion(false);
			this.setRecambioGen(false);
			this.setRecolocacionGen(false);
			this.setExplanteGen(false);
			this.setIntprevia(true);
			this.compac = new ComplicacionesPacientes();
			this.compac.setFechaini(this.impl.getFechaimplante());
			this.compac.setTipo(1);
			this.compacpost = new ComplicacionesPacientes();
			this.compacpost.setFechaini(this.impl.getFechaimplante());
			this.compacpost.setTipo(2);
			this.setEditableImpProc(false);
			this.currentItemComp = new ComplicacionesPacientes();
			this.currentItemCompPost = new ComplicacionesPacientes();
			this.listacomp = new ArrayList<ComplicacionesPacientes>();
			this.listacomppost = new ArrayList<ComplicacionesPacientes>();
			this.compintradao = new ImpHojaImplanteComplicacionDaoImpl(this.usuario);
			this.comppostdao = new ImpEvolucionComplicacionDaoImpl(this.usuario);
			this.setCurrentItemElectrodos(new ImpImplanteElectrodos());
			this.setCurrentItemElectrodosEliminar(new ImpImplanteElectrodos());
			this.cambioGen = false;
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			// OBTENCION ID ELECTRODO VIRTUAL - CASO LEADLESS
			Electrodos[] virtual = this.e.findByDynamicWhere("MODELO = ? AND FABRICANTE = ?", new Object[]{"LEADLESS","VIRTUAL"});
			if(virtual!=null && virtual.length>0)
				IDVIRTUAL =virtual[0].getIdelectrodo();
			virtual = null;
			// OBTENCION ID ELECTRODO SICD - CASO SUBCUTANEO
			Electrodos[] sicd = this.e.findByDynamicWhere("CONECTOR = ?", new Object[]{"SQ1"});
			if(sicd!=null && sicd.length>0)
				IDSICD =sicd[0];
			sicd = null;
			// OBTENCION DE ZONA CAMARA SUBCUTANEO
			for(ArrMaestras a:this.zonacamarasicd)
				if(a.getValor().toUpperCase().startsWith("PARAE"))
					IDZONA_SICD = a.getCodigo();
			// Seleccion de tab -> indicacion (en inserts)
			this.setSelectedtab("tabIndicacionImplantes");
			// opcional centros!
			//this.impl.setNproc(obtenerNProc());
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_error_sel_pat"));
			} else {
			}
			this.cmat = (ControlMaterial) getBean("controlMaterial");
			if(cmat == null){
				cmat = new ControlMaterial();				
			}		
			else{
			}
			cmat.iniciaMaterial(null);
			this.cc = (ControlComplicaciones) getBean("controlComplicaciones");
			if(this.cc == null)
				this.cc = new ControlComplicaciones();
			this.cc.inicia(null); // importante
			this.nuevogen = new Generador();
			this.nuevoelec = new Electrodos();
			this.cseg = (ControlSeguimientos) getBean("controlSeguimientos");
			if (cseg == null)
				cseg = new ControlSeguimientos();
			else {
			}
			cseg.iniciaSeguimientos(null);
			this.procs = new ArrayList<ImplanteSeguimientoBean>();
			// this.proclst =
			// this.procdao.findWhereCodigoEquals(cp.getPacienteSelect().getCodigo());
			this.proclst = this.procdao.findByDynamicWhere(
							"CODIGO =? AND (TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?  OR TIPOPROCEDIMIENTO = ?  OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?)",
							new Object[] {this.cp.getPacienteSelect().getCodigo(),956,957,993,1059,1060,1085,1147,1086,1090});
			this.lstprocsseg = this.procdao.findByDynamicWhere(
					"CODIGO =? AND (TIPOPROCEDIMIENTO = ?)", new Object[] {this.cp.getPacienteSelect().getCodigo(), 983 });
			this.segdao = new SegSeguimientoDaoImpl(this.usuario);
			if (this.proclst != null) {
				// Previo extraccion de idimpl de los procedimientos de seguimiento
				Integer[] posicionSeg = new Integer[this.lstprocsseg.length];
				for (int i = 0; i < this.lstprocsseg.length; i++) {
					SegSeguimiento segs = this.segdao.findByPrimaryKey(this.lstprocsseg[i].getIdprocedimiento());
					posicionSeg[i] = segs.getIdimpl();
				}
				SegSistemaDao segsisdao = new SegSistemaDaoImpl(this.usuario);
				for (int i = 0; i < this.proclst.length; i++) {
					ImplanteSeguimientoBean aux = new ImplanteSeguimientoBean();
					aux.setImplante(this.proclst[i]);
					// Obtencion de comentarios hev, ev y sitclin
					ImpImplante implante = this.impdao.findByPrimaryKey(this.proclst[i].getIdprocedimiento());
					ImpHojaImplante hoja_imp = this.himpdao.findByPrimaryKey(implante.getIdhojaimp());
					ImpEvolucion evol = this.hevdao.findByPrimaryKey(implante.getIdev());
					SituacionClinicaProc st = this.hinddao.findByPrimaryKey(this.proclst[i].getIdsitclinica());
					
					aux.setComentarios_imp(hoja_imp.getComentarios()!=null && !hoja_imp.getComentarios().equals("")?hoja_imp.getComentarios():null);
					aux.setComentarios_ev(evol.getComentarios()!=null && !evol.getComentarios().equals("")?evol.getComentarios():null);
					aux.setComentarios_sitclin(st.getComentarios()!=null && !st.getComentarios().equals("")?st.getComentarios():null);
					// Primer Operador
					ImpHojaImplantePop[] pops = this.popdao.findWhereIdhojaimpEquals(implante.getIdhojaimp());
					for(ImpHojaImplantePop op:pops){
						if(op.getIdop()!=null && !op.getIdop().equals("0"))
							aux.setOperador(aux.getOperador()!=null?aux.getOperador()+","+op.getIdop():op.getIdop());
					}		
					
					aux.setTipoimplante(String.valueOf(this.proclst[i].getTipoprocedimiento()));
					aux.setFechaimplante(this.proclst[i].getFecha());
					for (int j = 0; j < posicionSeg.length; j++) {
						if (this.proclst[i].getIdprocedimiento().equals(posicionSeg[j])){
							ImplanteSeguimientoBean seg = new ImplanteSeguimientoBean();
							seg.setImplante(this.lstprocsseg[j]);
							SegSeguimiento sg = this.segdao.findByPrimaryKey(this.lstprocsseg[j].getIdprocedimiento());
							SegSistema sg_sist = segsisdao.findByPrimaryKey(sg.getIdsistema());
							seg.setComentarios_seg(sg_sist.getComentarios()!=null && !sg_sist.getComentarios().equals("")?sg_sist.getComentarios():null);
							seg.setComentarios_seg_internos(sg.getComentarios()!=null && !sg.getComentarios().equals("")?sg.getComentarios():null);
							seg.setOperador(sg.getOperador()!=null&&!sg.getOperador().equals("0")?sg.getOperador():"");
							aux.getSeguimientos().add(seg);
							//aux.getSeguimientos().add(this.lstprocsseg[j]);
						}
							
					}
					GenericosDto gendto = obtenerTipoDispositivo(this.proclst[i].getIdprocedimiento());
					if(gendto!=null){
						aux.setModelo(gendto.getTmpString1());
						aux.setDispositivo(gendto.getTmpString2());
					}
					this.procs.add(aux);
				}
				// ORDENACION ARRAY PROCS
				Collections.sort(this.procs, new Comparator() {
					public int compare(Object o1, Object o2) {
						ImplanteSeguimientoBean e1 = (ImplanteSeguimientoBean) o1;
						ImplanteSeguimientoBean e2 = (ImplanteSeguimientoBean) o2;
						if (UtilFechas.dateDiff(e1.getFechaimplante(), e2.getFechaimplante())>0) {
							return 1;
						} else if (UtilFechas.dateDiff(e1.getFechaimplante(), e2.getFechaimplante())<=0) {
							return -1;
						} else {
							return 0;
						}
					}
				});
				if (this.proclst.length > 0) {
					this.setPrevioimp(true);
				} else
					this.setPrevioimp(false);					
									
			} else {
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_pat")+": "+ e1.getMessage());
		}
	}

	public void iniciaImplantes2(ActionEvent e) {
		this.iniciaImplantes(null);
		cargaSituacionClinica();
		// Precarga items de POP, SOP, y ENF
		this.himp.getPoperador().add(new ImpHojaImplantePop());
		this.himp.getSoperador().add(new ImpHojaImplanteSop());
		this.himp.getEnfermeras().add(new ImpHojaImplanteEnf());
		if (this.proclst.length > 0) {
			this.setPrevioimp(true);
			this.setCompletado(false);
			this.setIntprevia(false);
			cargaUltimoSistema();
		} else {
			this.setPrevioimp(false);
			this.setIntprevia(true);
			// Precarga inicial de listas: generador y electrodo para criterios de usabilidad
			this.listagenerador.add(new ImpGenerador());
			this.listaelectrodos.add(new ImpImplanteElectrodos());
			// Precarga sintoma por defecto en bloque Situacion Clinica Procedimiento
			this.getHind().getSintomas().add(new SintomasSitclinProc());
		}

	}

	public String obtenerNProc(){
		try{
			ImpImplante imp = this.impdao.getLastNProc();
			return String.valueOf(Integer.parseInt(imp.getNproc())+1);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_generar_nproc")+": "+ e1.getMessage());
			return "";
		}
	}
	
	public void cargaMaestras() {
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			this.tipoproc = cm.getTipoprocedimiento();
			this.enfermeria = cm.getEnfermeria();
			this.enfermeria_todos = cm.getEnfermeriaTodos();
			this.primerop = cm.getPrimerOperador();
			this.primerop_todos = cm.getPrimerOperadorTodos();
			this.segundoop = cm.getSegundoOperador();
			this.segundoop_todos = cm.getSegundoOperadorTodos();
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
			this.localizaciongen = cm.getLocalizacionGenerador();
			this.viaaccesoimplante = cm.getViaAccesoImplanteElectrodo();
			this.camara = cm.getCamara();
			this.lateralidad = cm.getLateralidad();
			this.zonacamaraad = cm.getZonaCamaraAD();
			this.zonacamaravd = cm.getZonaCamaraVD();
			this.zonacamaravi = cm.getZonaCamaraVI();
			this.zonaepicardico = cm.getZonaEpicardico();
			this.zonacamarasicd = cm.getZonaCamaraSICD();
			this.porcion = cm.getPorcion();
			this.mrecambiogen = cm.getMotivoRecambioGen();
			this.mrecolocaciongen = cm.getMotivoRecolocacionGen();
			this.mexplantegen = cm.getMotivoExplanteGen();
			this.mrecambioelec = cm.getMotivoRecambioElec();
			this.mrecolocacionelec = cm.getMotivoRecolocacionElec();
			this.mexplanteelec = cm.getMotivoExplanteElec();
			this.tipocomplicacion = cm.getTipoComplicacionIntra();
			this.tipocomplicacionpost = cm.getTipoComplicacionPost();
			this.hprocedencia = cm.getHospitalProcedencia();
			this.modogen = cm.getModoGenerador();
			this.motivosterapianoapropiada = cm.getMotivosTerapiaNoApropiada();
			this.fabgen = cm.getFabricanteGenerador();
			this.cadgen = cm.getConectorADGenerador();
			this.cvdgen = cm.getConectorVDGenerador();
			this.cvigen = cm.getConectorVIGenerador();
			this.fabelec = cm.getFabricanteElectrodo();
			this.polelec = cm.getPolaridadElectrodo();
			this.conelec = cm.getConectorElectrodo();
			this.fijaelec = cm.getFijacionElectrodo();
			this.bobelec = cm.getBobinaElectrodo();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
	}

	public void cargaGeneradores() {
		try {
			this.g = new GeneradorDaoImpl(this.usuario);
			// carga solo generadores activos
			this.generadores = this.g.findWhereActivoEquals(1);//insert
			this.generadores2 = this.g.findAll();//update
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}

	public void cargaElectrodos() {
		try {
			this.e = new ElectrodosDaoImpl(this.usuario);
			// carga solo electrodos activos
			this.electrodos = this.e.findWhereActivoEquals(1);//insert
			this.electrodos2 = this.e.findAll();//update
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}

	public void cargaComplicacionesIntra() {
		try {
			this.compdao = new ComplicacionDaoImpl(this.usuario);
			this.setComplicacionesintra(this.compdao.findWhereCaracterEquals(1));
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_compl")+": "+ e1.getMessage());
		}
	}

	public void cargaComplicacionesPost() {
		try {
			this.compdao = new ComplicacionDaoImpl(this.usuario);
			this.setComplicacionespost(this.compdao.findWhereCaracterEquals(2));
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_compl")+": "+ e1.getMessage());
		}
	}

	public void cargaImplante(ActionEvent e) throws Exception {
		this.proc = this.procs.get(this.getBindingBuscar().getRowIndex()).getImplante();
		this.procpk = this.proc.createPk();
		this.setActualizacion(true);
		if (this.proc.getTipoprocedimiento() == 993)
			this.setIntprevia(true);
		else
			this.setIntprevia(false);
		this.setTipoprocmanual(this.proc.getTipoprocedimiento());
		this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
		cargaComponentes();
		//cc.obtenerComplicacionesPacienteProc(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		if(this.sgen==null){
			SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
			this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
		}
		this.fechaimplante = this.impl.getFechaimplante();
		// Seleccion de tab -> Hoja de Implante (en updates)
		this.setSelectedtab("tabHojaImplanteImplantes");
	}
	public void cargaImplanteDesdeBarra(ActionEvent e) throws Exception{
		//this.proc = this.procs.get(this.getBindingBuscar().getRowIndex()).getImplante();
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),cp.getTipoprocedimiento()})[0];
			this.procpk = this.proc.createPk();
			this.setActualizacion(true);
			if (this.proc.getTipoprocedimiento() == 993)
				this.setIntprevia(true);
			else
				this.setIntprevia(false);
			this.setTipoprocmanual(this.proc.getTipoprocedimiento());
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			cargaComponentes();
			//cc.obtenerComplicacionesPacienteProc(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			this.fechaimplante = this.impl.getFechaimplante();	
			// Seleccion de tab -> Hoja de Implante (en updates)
			this.setSelectedtab("tabHojaImplanteImplantes");
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_consulta_sel")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	public void cargaImplanteConsulta(ActionEvent e) throws Exception{
		//this.proc = this.procs.get(this.getBindingBuscar().getRowIndex()).getImplante();
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.pacienteSelect.getIdimp(),cp.pacienteSelect.getTipoproc()})[0];
			this.procpk = this.proc.createPk();
			this.setActualizacion(true);
			if (this.proc.getTipoprocedimiento() == 993)
				this.setIntprevia(true);
			else
				this.setIntprevia(false);
			this.setTipoprocmanual(this.proc.getTipoprocedimiento());
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			cargaComponentes();
			//cc.obtenerComplicacionesPacienteProc(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
			if(this.sgen==null){
				SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				this.sgen = sitclingendao.findByPrimaryKey(this.cp.getPacienteSelect().getCodigo());						
			}
			this.fechaimplante = this.impl.getFechaimplante();
			// Seleccion de tab -> Hoja de Implante (en updates)
			this.setSelectedtab("tabHojaImplanteImplantes");
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_consulta_sel")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	/*public void cargaNumeroProc(ActionEvent e){
		// Pone fecha, tipo procedimiento y numero de proc en modalpanel de barra temporal
		
		System.out.println(this.getNumeroprocedimientobarratemporal());
		this.setEsImplante(false);
		for(Procedimiento p:this.proclst)
			if(p.getIdprocedimiento().equals(this.getNumeroprocedimientobarratemporal())){
				this.setEsImplante(true);
				System.out.println("IMPLANTE");
				break;
			}
				
		
	}*/

	private void cargaUltimoSistema() {
		// Es un proceso de intervencion con implantes ya existentes - Reintervenciones debe precargar solamente el sistema implantado y no toda la informacion de implante previa Generador + Electrodos implantados
		this.setActualizacion(false);
		try {
			//Integer fila = this.proclst[this.proclst.length - 1].getIdprocedimiento();
			Integer fila = null;
			ArrayList<Procedimiento> prs = new ArrayList<Procedimiento>();
			for(Procedimiento p:this.proclst)
				prs.add(p);
			// obtener ultimo sistema implantado
			Collections.sort(prs, new Comparator() {
				public int compare(Object o1, Object o2) {
					Procedimiento e1 = (Procedimiento) o1;
					Procedimiento e2 = (Procedimiento) o2;
					if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())>0) {
						return 1;
					} else if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())<=0) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			
			fila = prs.get(prs.size()-1).getIdprocedimiento();
			
			ImpImplante imp = this.impdao.findByPrimaryKey(fila);
			ImpGenerador[] gens = gendao.findWhereIdhojaimpEquals(imp.getIdhojaimp());
			ArrayList<ImpGenerador> genarray = new ArrayList<ImpGenerador>();
			ArrayList<ImpGenerador> genarrayexp = new ArrayList<ImpGenerador>();

			for (int i = 0; i < gens.length; i++) {
				if (gens[i].getMotivoexplante() == null) {
					//Generador aux = this.generadores2[(gens[i].getIdgenerador()) - 1];
					Generador aux = this.g.findByPrimaryKey(gens[i].getIdgenerador());
					// busqueda directa por bd - IMPLEMENTAR
					gens[i].setModelo(String.valueOf(aux.getIdgenerador()));
					gens[i].setNombremodelo(aux.getModelo());
					gens[i].setModo(aux.getModo()!=null?aux.getModo():"");
					gens[i].setRf((aux.getRf() != null) && (aux.getRf() == 1) ? "Si" : "No");
					gens[i].setMricomp((aux.getMri() != null) && (aux.getMri() == 1) ? "Si" : "No");
					gens[i].setMuestrabarcode(false);
					gens[i].setFabricante(aux.getFabricante()!=null?aux.getFabricante():"");
					genarray.add(gens[i]);
					this.setTipogen(Integer.parseInt(aux.getTipo()));
					this.setModogenini(aux.getModo());
				}
			}
			this.setListageneradorexp(genarrayexp);
			this.setListagenerador(genarray);
			if(this.listagenerador.size()>0){//FRR
				this.getListagenerador().get(0).setIdhojaimp(null);
				this.getListagenerador().get(0).setIdimpgenerador(null);
				this.genpk = this.listagenerador.get(0).createPk();
			}
			
			// this.genexppk = this.listageneradorexp.get(0).createPk();

			ImpImplanteElectrodos[] elecs = this.impelecdao.findWhereIdhojaimpEquals(imp.getIdhojaimp());
			ArrayList<ImpImplanteElectrodos> els = new ArrayList<ImpImplanteElectrodos>();
			ArrayList<ImpImplanteElectrodos> elsexp = new ArrayList<ImpImplanteElectrodos>();
			for (ImpImplanteElectrodos i : elecs) {
				if (((i.getEstado() != 2) || (i.getEstado() != 3))
						&& (i.getCaracter() != 1)) {
					// ImpImplanteElectrodos eexp = new
					// ImpImplanteElectrodos(i);
					// elsexp.add(eexp);					
					i.setIdaux(i.getIdimpelectrodos());
					i.setIdhojaimp(null);
					i.setIdevolucion(null);
					i.setIdimpelectrodos(null);
					// Poner a 0 los valores de programacion y umbrales
					i.setOndarpEv("");
					i.setUmbralvEv("");
					i.setUmbralmsEv("");
					i.setImpohmEv("");
					i.setImpmsEv("");
					i.setImpvEv("");
					i.setDurimpulso("");
					i.setVoltaje("");
					i.setSensibilidad("");
					Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, i.getIdelectrodo());
					i.setNombremodelo(auxelec.getModelo());
					i.setMuestrabarcode(false);
					i.setConector(auxelec.getConector()!=null?auxelec.getConector():"");
					i.setFabricante(auxelec.getFabricante()!=null?auxelec.getFabricante():"");
					i.setPolaridad(auxelec.getPolaridad()!=null?auxelec.getPolaridad():"");
					i.setVdd(auxelec.getConector()!=null&&auxelec.getConector().equals("IS-1 BIF")?true:false);
					i.setVddprev(auxelec.getConector()!=null&&auxelec.getConector().equals("IS-1 BIF")?true:false);
					i.setIdelectrodoprev(i.getIdelectrodo());
					i.setNserieprev(i.getNumserie());
					i.setAbordajetexto(this.componerNombreAbordaje(i));
					els.add(i);
					this.listaelectrodospk.add(i.createPk());
					// this.listaelectrodosexppk.add(eexp.createPk());
					/*
					 * if(((i.getEstado()==2)||(i.getEstado()==3))&&(i.getCaracter
					 * ()==2)) this.setElecdisfexp(true); else
					 * if(i.getEstado()==1) this.setElecdisfaband(true); else
					 * if(i.getEstado() == 0) this.setElecfunc(true);
					 */
				}
			}
			this.setListaelectrodos(els);
			this.setListaelectrodosexp(elsexp);
			this.setListaelectrodosexppk(new ArrayList<ImpImplanteElectrodosPk>());
			// HABRIA QUE CARGAR LA ULTIMA SITUACION CLINICA ACTUALIZADA DEL MAESTRO
			// HAY QUE PRECARGA SI ES RESPONDEDOR O NO - IMPLANTE PREVIO O ULTIMO SEGUIMIENTO
			// TODO
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("imp_dispositivos_msg_warn_sist_anterior")+": "+ e.getMessage());
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
						&& (ev.getProcedimiento()==956 ||ev.getProcedimiento()==957 || ev.getProcedimiento()==1059 || ev.getProcedimiento()==1060 || ev.getProcedimiento()==993 || ev.getProcedimiento()==1085 || ev.getProcedimiento()==1086 || ev.getProcedimiento()==1147)
						&& proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));
			}
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_epi")+": "+ e1.getMessage());
		}		
	}
	
	public void guarda(ActionEvent e) {
		try {
			//conn.setAutoCommit(false);
			if (!validaGenerador())
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_guarda_obl"));
			else if(!numSerieGeneradorEnUso())// Se aplica esta validacion solo si se detecta un cambio de generador
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_guarda_enuso"));					
			else if(!validaElectrodos())
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_guarda_elecs"));			
			else if(!validaFormulario())
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_continuar"));
			else if(!validaNProc())
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,  this.bundle.getString("info_msg_warn_continuar"));
			else {
				Integer epi = this.bindingepi.getRowIndex();
				if(epi != null && epi >= 0)
					this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());				
				if (this.procpk != null && this.proc.getIdprocedimiento() != null) {
					// UPDATE
					this.proc.setFecha(this.impl.getFechaimplante());
					this.hind.setFecha(this.impl.getFechaimplante());
					this.hinddao.update(this.hindpk, this.hind);
					// Update Sintomas
					guardaComponentesHind();
					modificaSituacionClinicaGeneral();
					preparaHoras();
					this.himpdao.update(this.himppk, this.himp);
					// Update Enf, Pop, Sop, Complicaciones Intra
					guardaComponentesHimp();
					// Update de Generador -> NO DEBE PERMITIRSE ACTUALIZAR EL MODELO DE GENERADOR
					for(ImpGenerador g:this.listagenerador)
						this.gendao.delete(g.createPk());
					for(ImpGenerador g:this.listageneradorexp)
						this.gendao.delete(g.createPk());
					this.guardaGenerador();	
					//this.gendao.update(this.genpk, this.listagenerador.get(0));
					// Update Electrodos - PELIGROSO PORQUE BORRA EL SISTEMA ANTERIOR Y PONE EL NUEVO ESPECIFICADO
					/*for (ImpImplanteElectrodosPk ielec : this.listaelectrodospk)
						this.impelecdao.delete(ielec);
					this.listaelectrodospk.clear();*/
					// Se opta por borrar el sistema recuperado de electrodos y guardar el nuevo especificado.
					for (ImpImplanteElectrodos ielec : this.listaelectrodos)
						this.impelecdao.delete(ielec.createPk());
					for(ImpImplanteElectrodos ielec : this.listaelectrodosexp)
						this.impelecdao.delete(ielec.createPk());
					this.listaelectrodospk.clear();
					for (int i = 0; i < this.listaelectrodos.size(); i++) {
						this.listaelectrodos.get(i).setIdhojaimp(this.himp.getIdhojaimp());
						this.listaelectrodos.get(i).setIdevolucion(this.hev.getIdev());
						this.listaelectrodospk.add(this.impelecdao.insert(this.listaelectrodos.get(i)));
						this.listaelectrodos.get(i).setIdimpelectrodos(this.listaelectrodospk.get(i).getIdimpelectrodos());
						//this.impelecdao.update(this.listaelectrodos.get(i).createPk(),this.listaelectrodos.get(i));
					}
					this.hevdao.update(this.hevpk, this.hev);
					// Update Zonas, Atp, Choques, Complicaciones Post
					guardaComponentesHev();
					// this.zonadao.update(this.listazonapk.get(i),
					// this.hev.getZonas().get(i));
					this.impdao.update(this.implpk, this.impl);
					this.proc.setFecha(this.impl.getFechaimplante());
					// Si usuario especifica tipo de procedimiento, prevalece el manual frente al automatico
					if(this.tipoprocmanual!=null && this.tipoprocmanual!=0)
						this.proc.setTipoprocedimiento(this.tipoprocmanual);
					this.procdao.update(this.procpk, this.proc);
					this.actualizaDatosElectrodos();
					// Operacion para actualizar la barra temporal de paciente
					//cp.precarga(null);
					//this.conn.commit();
					this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
					logger.info("("+this.usuario+") Registro de Implante actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				} else {
					// INSERT
					this.proc.setFecha(this.impl.getFechaimplante());
					// HIND -> guardar sintomas
					this.hindpk = this.hinddao.insert(this.hind);
					this.hind.setIdsitclin(this.hindpk.getIdsitclin());
					this.guardaComponentesHind();
					modificaSituacionClinicaGeneral();
					// HIMP -> guardar Pop, Sop, Enf, Generador,
					// ListaElectrodos, Compli Intra
					preparaHoras();
					this.himppk = this.himpdao.insert(this.himp);
					this.himp.setIdhojaimp(this.himppk.getIdhojaimp());
					this.impl.setIdhojaimp(this.himp.getIdhojaimp());
					this.guardaComponentesHimp();
					// Generador
					this.guardaGenerador();
					// HEV -> guardar Compli Post, Zonas, Atp, Choques, etc...
					this.hevpk = this.hevdao.insert(this.hev);
					this.hev.setIdev(this.hevpk.getIdev());
					this.impl.setIdev(this.hev.getIdev());
					this.guardaComponentesHev();
					// Guardar Lista electrodos -> Tiene que existir idhojaimp + idev
					this.guardaElectrodos();
					this.implpk = this.impdao.insert(this.impl);
					this.impl.setIdimplante(this.implpk.getIdimplante());

					if (this.isPrevioimp()) {// Control de asignacion de tipo de procedimiento
						if(this.listagenerador.size()==0 && this.listageneradorexp.size()>0)
							this.proc.setTipoprocedimiento(1147);// Explante
						else{
							if(this.isRecambioGen()){
								if(this.isUpgrade())
									this.proc.setTipoprocedimiento(1060);// Upgrade
								else 
									this.proc.setTipoprocedimiento(1059);// Recambio
							}else{
								if(this.isRecolocacionGen())
									this.proc.setTipoprocedimiento(1085);// Recolocacion Generador
								else if(this.isRecolocacion())
									this.proc.setTipoprocedimiento(1086);// Recolocacion electrodo
								else
									this.proc.setTipoprocedimiento(957);// Reintervencion
							}	
						}							
					} else {
						if (this.himp.isIntervencionprevia())
							this.proc.setTipoprocedimiento(993);// IntervencionPrevia 
						else
							this.proc.setTipoprocedimiento(956);// Primoimplante
						this.actualizacion = true;
					}
					this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
					
					this.actualizaDatosElectrodos();
					this.proc.setIdprocedimiento(this.impl.getIdimplante());
					this.proc.setIdsitclinica(this.hind.getIdsitclin());
					// Si usuario especifica tipo de procedimiento, prevalece el manual frente al automatico
					if(this.tipoprocmanual!=null && this.tipoprocmanual!=0)
						this.proc.setTipoprocedimiento(this.tipoprocmanual);
					else
						this.setTipoprocmanual(this.proc.getTipoprocedimiento());
					this.procpk = this.procdao.insert(this.proc);
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
					this.setCompletado(true);
					this.cambioGen = false; // se pone para el caso en que se haga una actualizacion desde un implante. para reiniciar el valor y que no sale el control de numserie y generador en uso					
					
					//escribeEnClinica();
					//this.conn.commit();
					logger.info("("+this.usuario+") Registro de Implante insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
					// Operacion para actualizar la barra temporal de paciente
					//cp.precarga(null);
				}
			}
		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_guarda_error_exep")+": " + ex.getMessage());
			logger.error("("+this.usuario+") Error al guardar/actualizar implante: " + ex.getMessage());
			// ROLLBACK
		}
	}

	private void guardaComponentesHind() throws Exception {
		sintdao.delete(new SintomasSitclinProcPk(this.hind.getIdsitclin(), null));
		for (SintomasSitclinProc sint : this.hind.getSintomas()) {
			if (sint.getIdsintomas() != null && sint.getIdsintomas().length() > 0) {
				sint.setIdsitclin(this.hind.getIdsitclin());
				sintdao.insert(sint);
			}
		}
		this.hind.setFecha(this.impl.getFechaimplante());
	}

	private void guardaComponentesHimp() throws Exception {
		// HIMP/Enf
		enfdao.delete(new ImpHojaImplanteEnfPk(this.himp.getIdhojaimp(), null));
		for (ImpHojaImplanteEnf enf : this.himp.getEnfermeras()) {
			if (enf.getIdenf() != null && enf.getIdenf().length() > 0) {
				enf.setIdhojaimp(this.himp.getIdhojaimp());
				enfdao.insert(enf);
			}
		}
		// HIMP/Pop
		popdao.delete(new ImpHojaImplantePopPk(this.himp.getIdhojaimp(), null));
		for (ImpHojaImplantePop pop : this.himp.getPoperador()) {
			if (pop.getIdop() != null && pop.getIdop().length() > 0) {
				pop.setIdhojaimp(this.himp.getIdhojaimp());
				popdao.insert(pop);
			}
		}
		// HIMP/Sop
		sopdao.delete(new ImpHojaImplanteSopPk(this.himp.getIdhojaimp(), null));
		for (ImpHojaImplanteSop sop : this.himp.getSoperador()) {
			if (sop.getIdop() != null && sop.getIdop().length() > 0) {
				sop.setIdhojaimp(this.himp.getIdhojaimp());
				sopdao.insert(sop);
			}
		}
		// HIMP/Complicaciones Intra
		compintradao.delete(new ImpHojaImplanteComplicacionPk(this.himp.getIdhojaimp(), null));
		for (ImpHojaImplanteComplicacion comp : this.listacomplicacionesintra) {
			if (comp.getIdcompl() == null)
				comp.setIdcompl(25);// Otras complicaciones
			comp.setIdhojaimp(this.himp.getIdhojaimp());
			compintradao.insert(comp);
		}
		// MEDICACION INTRA PROCEDIMIENTO
		medintradao.delete(this.himp.getMedintra().createPk());
		this.himp.getMedintra().setIdhojaimp(this.himp.getIdhojaimp());
		medintradao.insert(this.himp.getMedintra());
	}

	private void guardaComponentesHev() throws Exception {
		// Complicaciones Post
		comppostdao.delete(new ImpEvolucionComplicacionPk(null, this.hev.getIdev()));
		for (ImpEvolucionComplicacion comp : this.listacomplicacionespost) {
			if (comp.getIdcompl() == null)
				comp.setIdcompl(70);
			comp.setIdev(this.hev.getIdev());
			comppostdao.insert(comp);
		}
		// Zonas + Atps y Choques
		for (ImpAtpPk atpk : this.listaatppk)
			this.atpdao.delete(atpk);
		for (ImpChoquesPk chpk : this.listachoquespk)
			this.choquedao.delete(chpk);
		for (ImpZonaPk zpk : this.listazonapk)
			this.zonadao.delete(zpk);
		// PROCESO DE ACTUALIZACION
		this.listazonapk.clear();
		this.listaatppk.clear();
		this.listachoquespk.clear();

		for (ImpZona z : this.hev.getZonas()) {
			z.setIdev(this.getHev().getIdev());
			ImpZonaPk zpk = this.zonadao.insert(z);
			z.setIdzona(zpk.getIdzona());
			this.listazonapk.add(zpk);
			for (ImpAtp a : z.getAtps()) {
				a.setIdzona(z.getIdzona());
				ImpAtpPk apk = this.atpdao.insert(a);
				a.setIdatp(apk.getIdatp());
				this.listaatppk.add(apk);
			}
			if (z.getChqs().size() > 0 && (z.getChqs().get(0).getEnergia() != null)) {
				for (ImpChoques ch : z.getChqs()) {
					ch.setIdzona(z.getIdzona());
					ImpChoquesPk chpk = this.choquedao.insert(ch);
					ch.setIdzona(chpk.getIdch());
					this.listachoquespk.add(chpk);
				}
			}
		}
	}

	public void guardaComplicacionIntra(ActionEvent e){
		this.compac.setIdpaciente(this.cp.getPacienteSelect().getCodigo());
		this.compac.setIdprocedimiento(this.proc.getIdprocedimiento());
		this.compac.setTipoprocedimiento(this.proc.getTipoprocedimiento());
		this.compac.setIdrelacion(2);
		cc.addItemComplicacion(this.compac);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacomp.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			if(cpac.getTipo().equals(1))
				this.listacomp.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.compac = new ComplicacionesPacientes();
		this.compac.setFechaini(this.impl.getFechaimplante());
		this.compac.setTipo(1);
	}
	
	public void guardaComplicacionPost(ActionEvent e){
		this.compacpost.setIdpaciente(this.cp.getPacienteSelect().getCodigo());
		this.compacpost.setIdprocedimiento(this.proc.getIdprocedimiento());
		this.compacpost.setTipoprocedimiento(this.proc.getTipoprocedimiento());
		this.compacpost.setIdrelacion(2);
		cc.addItemComplicacion(this.compacpost);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacomppost.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			if(!cpac.getTipo().equals(1))
				this.listacomppost.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.compacpost = new ComplicacionesPacientes();
		this.compacpost.setFechaini(this.impl.getFechaimplante());
		this.compacpost.setTipo(2);
	}
	
	private void guardaGenerador() throws Exception {
		for (ImpGenerador g : this.listagenerador) {
			g.setIdhojaimp(this.himp.getIdhojaimp());
			ImpGeneradorPk gpk = this.gendao.insert(g);
			g.setIdimpgenerador(gpk.getIdimpgenerador());
		}
		for (ImpGenerador g : this.listageneradorexp) {
			g.setIdhojaimp(this.himp.getIdhojaimp());
			ImpGeneradorPk gpk = this.gendao.insert(g);
			g.setIdimpgenerador(gpk.getIdimpgenerador());
		}
	}

	private void guardaElectrodos() throws Exception {
		for (ImpImplanteElectrodos e : this.listaelectrodos) {
			e.setIdhojaimp(this.himp.getIdhojaimp());
			e.setIdevolucion(this.hev.getIdev());
			e.setFechaimplante(e.getFechaimplante()!=null?e.getFechaimplante():this.proc.getFecha());
			ImpImplanteElectrodosPk epk = this.impelecdao.insert(e);
			e.setIdimpelectrodos(epk.getIdimpelectrodos());
			this.listaelectrodospk.add(epk);
		}
		for (ImpImplanteElectrodos e : this.listaelectrodosexp) {
			e.setIdhojaimp(this.himp.getIdhojaimp());
			e.setIdevolucion(this.hev.getIdev());
			ImpImplanteElectrodosPk epk = this.impelecdao.insert(e);
			e.setIdimpelectrodos(epk.getIdimpelectrodos());
		}
	}
	
	private void actualizaDatosElectrodos(){
		try{
			boolean advddact = false;
			for(ImpImplanteElectrodos impel:this.listaelectrodos){
				if(!(impel.isVdd() && impel.getCamara()==948) 
						|| ((impel.isVdd() && impel.getCamara()==948)) && !advddact){// condicion para no actualizar el VDD de AD en caso de serlo. Si no, se crea un nuevo item duplicado
					ImpImplanteElectrodos[] els = this.impelecdao.findByDynamicWhere("IDELECTRODO=? AND NUMSERIE=?", new Object[]{impel.getIdelectrodoprev(),impel.getNserieprev()});
					if(els!=null && els.length>0){
						for(ImpImplanteElectrodos e:els){
							if(e.getIdimpelectrodos()!=impel.getIdimpelectrodos()){
								// SE OBTIENE EL ELECTRODO PREVIO TB
								Electrodos electrodo = this.e.findByPrimaryKey(e.getIdelectrodo());
								e.setVdd(electrodo!=null && electrodo.getConector()!=null && electrodo.getConector().equals("IS-1 BIF")?true:false);
								e.setIdelectrodo(impel.getIdelectrodo());
								e.setNumserie(impel.getNumserie());
								e.setCamara(e.isVdd() && e.getCamara()==948?e.getCamara():impel.getCamara());// Si es AD- VDD el que hay que modificar, no le cambiamos la camara y no se actualizara
								e.setVia(impel.getVia());
								e.setLateralidad(impel.getLateralidad());
								e.setPorcion(impel.getPorcion());
								e.setZonacamara(impel.getZonacamara());								
								if(impel.isF_modificada())
									e.setFechaimplante(impel.getFechaimplante());
								if((!impel.isVdd() && !e.isVdd()))
									this.impelecdao.update(new ImpImplanteElectrodosPk(e.getIdimpelectrodos()), e);
								else if(!impel.isVdd() && e.isVdd() && e.getCamara()==949)
									this.impelecdao.update(new ImpImplanteElectrodosPk(e.getIdimpelectrodos()), e);
								else if(impel.isVdd() && e.isVdd()&& e.getCamara()!=948)
									this.impelecdao.update(new ImpImplanteElectrodosPk(e.getIdimpelectrodos()), e);
								else if(impel.isVdd() && e.isVdd() && e.getCamara()==948){
									advddact = true;
									this.impelecdao.update(new ImpImplanteElectrodosPk(e.getIdimpelectrodos()), e);
								}else if(impel.isVdd() && !e.isVdd())
									this.impelecdao.update(new ImpImplanteElectrodosPk(e.getIdimpelectrodos()), e);
								logger.info("("+this.usuario+") Item electrodo actualizado en seguimientos asociados a registro:  Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
							}
						}
						impel.setF_modificada(false);// actualizamos estado para proximas acciones 
					}else{ // nuevo electrodo
						// hay que encontrar los seguimientos del implante
						SegSeguimiento[] segs = this.segdao.findByDynamicWhere("IDIMPL = ?", new Object[]{this.impl.getIdimplante()});
						if(segs!=null && segs.length>0){
							for(SegSeguimiento sg:segs){
								ImpImplanteElectrodos nuevo = new ImpImplanteElectrodos();
								nuevo.setCaracter(0);
								nuevo.setIdelectrodo(impel.getIdelectrodo());
								nuevo.setNumserie(impel.getNumserie());
								nuevo.setCamara(impel.getCamara());
								nuevo.setZonacamara(impel.getZonacamara());
								nuevo.setVia(impel.getVia());
								nuevo.setLateralidad(impel.getLateralidad());
								nuevo.setPorcion(impel.getPorcion());
								nuevo.setFechaimplante(impel.getFechaimplante());
								nuevo.setIdhojaimp(null);
								nuevo.setIdseg(sg.getIdseg());
								nuevo.setIdevolucion(sg.getIdev());
								this.impelecdao.insert(nuevo);
								logger.info("("+this.usuario+") Nuevo item electrodo insertado en seguimientos asociados a registro:  Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
							}
						}
					}
				}
			}
			// Control de borrado en UPDATE. Se borran sólo de procedimientos de UPDATE aquellos que han sido marcados.
			if(this.proc.getIdprocedimiento()!=null){
				for(ImpImplanteElectrodos impel : this.listaelectrodosexp){
					ImpImplanteElectrodos[] els = this.impelecdao.findByDynamicWhere("IDELECTRODO=? AND NUMSERIE=?", new Object[]{impel.getIdelectrodoprev(),impel.getNserieprev()});
					if(els!=null && els.length>0)
						for(ImpImplanteElectrodos e:els){
							this.impelecdao.delete(e.createPk());
							logger.info("("+this.usuario+") Item electrodo eliminado en seguimientos asociados a registro:  Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
						}							
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(ERROR, this.bundle.getString("imp_dispositivos_msg_error_edit_elecs")+": "+e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido actualizar sistema de electrodos del registro:  Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
		}
	}

	public void actualizaFechaImpElectrodo(ActionEvent e){
		this.listaelectrodos.get(this.bindingElec.getRowIndex()).setF_modificada(true);
	}
	
	public void preEditarImpProc(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		ComplicacionesPacientes aux = this.getListacomp().get(this.bindingComplicacionesImpProc.getRowIndex());	
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
		this.setEditableImpProc(true);
	}
	
	public void preEditarImpProcEv(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		ComplicacionesPacientes aux = this.getListacomppost().get(this.bindingComplicacionesImpProcPost.getRowIndex());	
		this.currentItemCompPost.setIdcompac(aux.getIdcompac());
		this.currentItemCompPost.setIdpaciente(aux.getIdpaciente());
		this.currentItemCompPost.setTipo(aux.getTipo());
		this.currentItemCompPost.setTipoprocedimiento(aux.getTipoprocedimiento());
		this.currentItemCompPost.setIdprocedimiento(aux.getIdprocedimiento());
		this.currentItemCompPost.setComplicacion(aux.getComplicacion());
		this.currentItemCompPost.setComplicacion1(aux.getComplicacion1());
		this.currentItemCompPost.setComplicacionOtra(aux.getComplicacionOtra());
		this.currentItemCompPost.setIdrelacion(aux.getIdrelacion());
		this.currentItemCompPost.setIdlugar(aux.getIdlugar());
		this.currentItemCompPost.setFechaini(aux.getFechaini());
		this.currentItemCompPost.setFechafin(aux.getFechafin());
		this.currentItemCompPost.setResuelta(aux.getResuelta());
		this.currentItemCompPost.setResueltaOtros(aux.getResueltaOtros());
		this.currentItemCompPost.setTratamiento(aux.getTratamiento());
		this.currentItemCompPost.setTratamientoDescr(aux.getTratamientoDescr());
		this.currentItemCompPost.setTratamientoTipo(aux.getTratamientoTipo());
		this.currentItemCompPost.setIngreso(aux.getIngreso());
		this.currentItemCompPost.setDescripcion(aux.getDescripcion());
		this.currentItemCompPost.setFechaProc(aux.getFechaProc());
		this.setEditableImpEvProc(true);
	}
	
	public void actualizaItemComplicacionIntra(ActionEvent e){
		cc.editItemComplicacion(this.currentItemComp);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacomp.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			if(cpac.getTipo().equals(1))
				this.listacomp.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.currentItemComp = new ComplicacionesPacientes();
	}
	
	public void actualizaItemComplicacionPost(ActionEvent e){
		cc.editItemComplicacion(this.currentItemCompPost);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacomppost.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			if(!cpac.getTipo().equals(1))
				this.listacomppost.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.currentItemCompPost = new ComplicacionesPacientes();
	}
	
	public void cancelarItemComplicacion(ActionEvent e){
		this.setEditableImpProc(false);
		this.setEditableImpEvProc(false);
		this.currentItemCompPost = new ComplicacionesPacientes();
		this.currentItemComp = new ComplicacionesPacientes();
	}
	
	public void delItemComplicacionIntra(ActionEvent e){
		Integer pos = this.bindingComplicacionesImpProc.getRowIndex();
		ComplicacionesPacientes item = this.listacomp.get(pos);
		cc.delItemComplicacion(item);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacomp.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			if(cpac.getTipo().equals(1))
				this.listacomp.add(cpac);
	}
	
	public void delItemComplicacionEv(ActionEvent e){
		Integer pos = this.bindingComplicacionesImpProcPost.getRowIndex();
		ComplicacionesPacientes item = this.listacomppost.get(pos);
		cc.delItemComplicacion(item);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacomppost.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			if(!cpac.getTipo().equals(1))
				this.listacomppost.add(cpac);
	}
	
	public void limpiarComp(ActionEvent e){
		this.compac = new ComplicacionesPacientes();
		this.compac.setFechaini(this.impl.getFechaimplante());
		this.compac.setTipo(1);
	}
	
	private void cargaComponentes() {
		try {
			// 1. Recuperar objeto Implante
			this.impl = this.impdao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.implpk = this.impl.createPk();
			this.impl.setInterprev((this.impl.getIntervencionprevia() != null && this.impl.getIntervencionprevia() == 1) ? true : false);

			//this.setBackupFecha(this.impl.getFechaimplante());
			// 2. Recuperar HIND
			this.hind = this.hinddao.findByPrimaryKey(this.proc.getIdsitclinica());
			this.hindpk = this.hind.createPk();
			// 2.1 Sintomas
			SintomasSitclinProc[] sints = sintdao.findWhereIdsitclinEquals(this.proc.getIdsitclinica());
			ArrayList<SintomasSitclinProc> sintarray = new ArrayList<SintomasSitclinProc>();
			for (SintomasSitclinProc s : sints)
				sintarray.add(s);
			this.hind.setSintomas(sintarray);
			// 2.3 Precarga IC si existe
			this.hind.setIc(this.hind.getNyha() != null ? true : false);
			// 2.4 Cardiopatia
			this.hind.setCardiop(this.hind.getCardiopatia()!=null?true:false);
			// 2.4 Cardiopatia Revascularizacion
			this.hind.setRevascularizacion(this.hind.getRevasc() != null && this.hind.getRevasc() == 1 ? true : false);
			// 2.5 Cardiopatia Infarto Previo
			this.hind.setInfartoprev(this.hind.getInfprevio() != null && this.hind.getInfprevio() == 1 ? true : false);
			// 2.6 Antecedentes - Arritmias Ventriculares
			this.hind.setAvent(this.hind.getArritmias() != null && this.hind.getArritmias() >= 1 ? true : false);
			// 2.7 Antecedentes - EEF Previo
			this.hind.setEefprev(this.hind.getEef() != null && this.hind.getEef() >= 1 ? true : false);
			// 2.8 Antecedentes booleanos
			cargaAntecedentes();
			// 3. Recuperar HIMP
			this.himp = this.himpdao.findByPrimaryKey(this.impl.getIdhojaimp());
			this.himppk = this.himp.createPk();
			cargaHoras();
			// 3.1 Carga Enfermeras
			ImpHojaImplanteEnf[] enfermeras = enfdao.findWhereIdhojaimpEquals(this.impl.getIdhojaimp());
			ArrayList<ImpHojaImplanteEnf> enfarray = new ArrayList<ImpHojaImplanteEnf>();
			for (ImpHojaImplanteEnf enf : enfermeras){
				enf.setLectura(1);
				enfarray.add(enf);
			}
			this.himp.setEnfermeras(enfarray);
			// 3.2 Carga Pop
			ImpHojaImplantePop[] pops = popdao.findWhereIdhojaimpEquals(this.impl.getIdhojaimp());
			ArrayList<ImpHojaImplantePop> poparray = new ArrayList<ImpHojaImplantePop>();
			for (ImpHojaImplantePop p : pops){
				p.setLectura(1);
				poparray.add(p);
			}
			this.himp.setPoperador(poparray);
			// 3.3 Carga Sop
			ImpHojaImplanteSop[] sops = sopdao.findWhereIdhojaimpEquals(this.impl.getIdhojaimp());
			ArrayList<ImpHojaImplanteSop> soparray = new ArrayList<ImpHojaImplanteSop>();
			for (ImpHojaImplanteSop s : sops){
				s.setLectura(1);
				soparray.add(s);
			}
			this.himp.setSoperador(soparray);
			// 3.4 Carga Generador
			ImpGenerador[] gens = gendao.findWhereIdhojaimpEquals(this.himp.getIdhojaimp());
			ArrayList<ImpGenerador> genarray = new ArrayList<ImpGenerador>();
			ArrayList<ImpGenerador> genarrayexptarjeta = new ArrayList<ImpGenerador>();

			for (int i = 0; i < gens.length; i++) {
				if (gens[i].getMotivoexplante() == null) {
					//Generador aux = this.generadores2[(gens[i].getIdgenerador()) - 1];
					Generador aux = this.g.findByPrimaryKey(gens[i].getIdgenerador());
					gens[i].setModelo(String.valueOf(aux.getIdgenerador()));
					gens[i].setNombremodelo(aux.getModelo());
					gens[i].setModo(aux.getModo());
					gens[i].setRf((aux.getRf() != null) && (aux.getRf() == 1) ? "Si" : "No");
					gens[i].setMricomp((aux.getMri() != null) && (aux.getMri() == 1) ? "Si" : "No");
					gens[i].setMuestrabarcode(false);
					gens[i].setFabricante(aux.getFabricante()!=null?aux.getFabricante():"");
					genarray.add(gens[i]);
					this.setTipogen(Integer.parseInt(aux.getTipo()));
					this.setModogenini(aux.getModo());
				} else {// Se mete en la lista para generar la tarjeta europea de mp
					genarrayexptarjeta.add(gens[i]);
				}
			}
			this.setListagenerador(genarray);
			if(this.listagenerador.size()>0)//FRR
				this.genpk = this.listagenerador.get(0).createPk();
			this.setListageneradorexptarjeta(genarrayexptarjeta);
			// 3.5 Complicaciones intra
			ImpHojaImplanteComplicacion[] cintras = compintradao.findWhereIdhojaimpEquals(this.himp.getIdhojaimp());
			ArrayList<ImpHojaImplanteComplicacion> cintarray = new ArrayList<ImpHojaImplanteComplicacion>();
			for (ImpHojaImplanteComplicacion c : cintras) {
				Complicacion auxcompintra = obtenerComplicacion(
						this.complicacionesintra, c.getIdcompl());
				c.setTipocomp(auxcompintra.getTipo());
				cintarray.add(c);
			}
			this.setListacomplicacionesintra(cintarray);
			// 3.6 Test Induccion
			this.himp.setTesti((this.himp.getTestind() != null && this.himp.getTestind() == 1) ? true : false);
			// 3.7 Medicacion intra-operatoria
			ImpMedIntra[] mintras = this.medintradao.findWhereIdhojaimpEquals(this.himp.getIdhojaimp());
			if(mintras!=null && mintras.length>0)
				this.himp.setMedintra(mintras[0]);
			// 4. Recuperar HEV
			this.hev = this.hevdao.findByPrimaryKey(this.impl.getIdev());
			this.hevpk = this.hev.createPk();
			// 4.1 Complicaciones post
			ImpEvolucionComplicacion[] cposts = comppostdao.findWhereIdevEquals(this.hev.getIdev());
			ArrayList<ImpEvolucionComplicacion> cpostarray = new ArrayList<ImpEvolucionComplicacion>();
			for (ImpEvolucionComplicacion c : cposts) {
				c.setTipocomp(obtenerComplicacion(this.complicacionespost,c.getIdcompl()).getTipo());
				cpostarray.add(c);
			}
			this.setListacomplicacionespost(cpostarray);
			// 4.2 Zonas + ATP + CHOQUES
			ImpZona[] zonas = zonadao.findWhereIdevEquals(this.impl.getIdev());
			ArrayList<ImpZona> zonaarray = new ArrayList<ImpZona>();
			for (ImpZona z : zonas) {
				ImpAtp[] atps = atpdao.findWhereIdzonaEquals(z.getIdzona());
				ImpChoques[] chqs = choquedao.findWhereIdzonaEquals(z.getIdzona());
				this.listazonapk.add(z.createPk());
				ArrayList<ImpAtp> atparray = new ArrayList<ImpAtp>();
				ArrayList<ImpChoques> chqarray = new ArrayList<ImpChoques>();
				for (ImpAtp atp : atps) {
					atparray.add(atp);
					this.listaatppk.add(atp.createPk());
				}
				z.setAtps(atparray);
				z.setNumatpini(String.valueOf(atparray.size()));
				for (ImpChoques ch : chqs) {
					chqarray.add(ch);
					this.listachoquespk.add(ch.createPk());
				}
				z.setChqs(chqarray);
				if (chqarray.size() > 0)
					z.setChoqini(true);
				else {// hay que inicializarlo para posibles actualizaciones
					z.getChqs().add(new ImpChoques("1"));
					z.setChoqini(false);
				}
				zonaarray.add(z);
			}
			// Ordenar el arraylist para presentar adecuadamente. En bbdd se ordena acorde a como vaya llegando, pero hay que presentar la lista ordenada
			// adecuadamente: TV1..TV5-FV. En otro caso, da errores de presentacion y actualizacion
			Collections.sort(zonaarray, new Comparator() {
				public int compare(Object o1, Object o2) {
					ImpZona e1 = (ImpZona) o1;
					ImpZona e2 = (ImpZona) o2;
					int codigo1 = Integer.parseInt(e1.getFcPpm());
					int codigo2 = Integer.parseInt(e2.getFcPpm());
					if (codigo1 > codigo2) {
						return 1;
					} else if (codigo1 < codigo2) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			this.hev.setZonas(zonaarray);
			// 4.2 MP Dependiente
			this.hev.setMpdep((this.hev.getMpdependiente() != null) && (this.hev.getMpdependiente() == 1) ? true : false);
			// 4.3 Seguimiento remoto
			this.hev.setSegrem((this.hev.getSegremoto() != null) && (this.hev.getSegremoto() == 1) ? true : false);
			// 4.4 MEV
			this.hev.setMinestvent((this.hev.getMev() != null) && (this.hev.getMev() == 1) ? true : false);
			// 4.5 Intervalos Dinamicos
			if (this.hev.getIavmax() != null || this.hev.getIavmin() != null)
				this.hev.setIavdinamico(true);
			else
				this.hev.setIavdinamico(false);
			// 4.6 Terapia entregada (si DAI)
			if (this.hev.getAtp() != null || this.hev.getChoques() != null || this.hev.getTodasefec() != null)
				this.hev.setTerapiaentregada(true);
			else
				this.hev.setTerapiaentregada(false);
			// 4.7 Terapia entregada - ATP
			this.hev.setTeratp((this.hev.getAtp() != null) && (this.hev.getAtp() == 1) ? true : false);
			this.hev.setTerapiaefecatp((this.hev.getTerefecatp() != null) && (this.hev.getTerefecatp() == 1) ? true : false);
			// 4.8 Terapia entregada - Choques
			this.hev.setTerchoques((this.hev.getChoques() != null) && (this.hev.getChoques() == 1) ? true : false);
			this.hev.setTerapiaefecchoques((this.hev.getTereefecchoq() != null) && (this.hev.getTereefecchoq() == 1) ? true : false);
			// 4.9 Alg prev FA
			this.hev.setPrevfa((this.hev.getAlgprevfa() != null) && (this.hev.getAlgprevfa() == 1) ? true : false);
			// 4.10 Histeresis
			this.hev.setHist((this.hev.getValorHisteresis() != null) && (!(this.hev.getValorHisteresis().equals("")) ? true : false));
			// 4.11 Estimulacion frenica
			this.hev.setEstimfren((this.hev.getUmbralEstimfren() != null) && (this.hev.getUmbralEstimfren().length() > 0) ? true : false);
			// 4.12 Episodios
			this.hev.setEpisodios((this.hev.getNumepisodios() != null && this.hev.getNumepisodios().length() > 0) ? true : false);
			// 5. Lista electrodos
			ImpImplanteElectrodos[] elecs = this.impelecdao.findWhereIdevolucionEquals(this.impl.getIdev());
			ArrayList<ImpImplanteElectrodos> els = new ArrayList<ImpImplanteElectrodos>();
			ArrayList<ImpImplanteElectrodos> elsexptarjeta = new ArrayList<ImpImplanteElectrodos>();

			for (ImpImplanteElectrodos i : elecs) {
				// Solo debe cargar los electrodos activos o expl-aban parcialmente. Los extraidos completamente no
				if (((i.getEstado() != 2) || (i.getEstado() != 3)) && (i.getCaracter() != 1)) {					
					i.setEstimfrenok((i.getEstimfren() != null) && (!(i.getEstimfren().equals("")) ? true : false));					
					Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, i.getIdelectrodo());
					i.setNombremodelo(auxelec.getModelo());
					i.setMuestrabarcode(false);
					i.setConector(auxelec.getConector()!=null?auxelec.getConector():"");
					i.setFabricante(auxelec.getFabricante()!=null?auxelec.getFabricante():"");
					i.setPolaridad(auxelec.getPolaridad()!=null?auxelec.getPolaridad():"");
					i.setVdd(auxelec.getConector()!=null&&auxelec.getConector().equals("IS-1 BIF")?true:false);
					i.setVddprev(auxelec.getConector()!=null&&auxelec.getConector().equals("IS-1 BIF")?true:false);
					i.setPrevio(true);
					i.setIdelectrodoprev(i.getIdelectrodo());
					i.setNserieprev(i.getNumserie());
					i.setAbordajetexto(this.componerNombreAbordaje(i));
					this.listaelectrodospk.add(i.createPk());
					els.add(i);
				} else {
					elsexptarjeta.add(i);
				}
			}
			this.setListaelectrodos(els);
			this.setListaelectrodosexptarjeta(elsexptarjeta);
			// 6. complicaciones pacientes
			cc.obtenerComplicacionesPacienteProc(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
			for(ComplicacionesPacientes cpac:cc.getListacompacproc()){
				if(cpac.getTipo().equals(1))
					this.listacomp.add(cpac);
				else
					this.listacomppost.add(cpac);
			}
			// 7. Inicializacion de complicaciones
			this.compac.setFechaini(this.impl.getFechaimplante());
			this.compacpost.setFechaini(this.impl.getFechaimplante());
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("imp_dispositivos_msg_error_ver_sistema")+": "+ e.getMessage());
		}
	}

	public void eliminarImplante(ActionEvent e){
		int auxproc = this.proc.getIdprocedimiento();
		try{		
			// Delete oncascade - procedimiento -> situacion clinica
			this.sintdao.delete(new SintomasSitclinProcPk(this.hind.getIdsitclin(), null));
			this.enfdao.delete(new ImpHojaImplanteEnfPk(this.himp.getIdhojaimp(), null));
			this.popdao.delete(new ImpHojaImplantePopPk(this.himp.getIdhojaimp(), null));
			this.sopdao.delete(new ImpHojaImplanteSopPk(this.himp.getIdhojaimp(), null));
			this.compintradao.delete(new ImpHojaImplanteComplicacionPk(this.himp.getIdhojaimp(), null));
			for(ImpGenerador g:this.listagenerador)
				this.gendao.delete(g.createPk());
			if(this.listageneradorexptarjeta!=null)
				for(ImpGenerador g:this.listageneradorexptarjeta)
					this.gendao.delete(g.createPk());
			for(ImpImplanteElectrodosPk epk:this.listaelectrodospk)
				this.impelecdao.delete(epk);
			if(this.listaelectrodosexptarjeta!=null)
				for(ImpImplanteElectrodos epk:this.listaelectrodosexptarjeta)
					this.impelecdao.delete(epk.createPk());
			// Esto se borra al eliminar generador o electrodos
			this.himpdao.delete(this.himppk);
			
			for(ImpAtpPk atppk:this.listaatppk)
				this.atpdao.delete(atppk);
			for(ImpChoquesPk chpk:this.listachoquespk)
				this.choquedao.delete(chpk);
			for(ImpZonaPk zpk:this.listazonapk)
				this.zonadao.delete(zpk);
			
			this.comppostdao.delete(new ImpEvolucionComplicacionPk(null, this.hev.getIdev()));
			
			this.hevdao.delete(this.hevpk);
			
			this.impdao.delete(this.implpk);
			this.procdao.delete(this.procpk);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro de implante eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido eliminar el registro:  Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
		}
	}

	public void compruebaFechas(ActionEvent e) {
		if(this.impl.getFechaimplante()==null){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_act_fechas"));
			//this.impl.setFechaimplante(this.getBackupFecha());
		}		
		else{
			for (Procedimiento p : this.proclst) {
				if (UtilFechas.dateDiff(this.impl.getFechaimplante(), p.getFecha()) < 0){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_act_fechas_impl_prev"));
					//this.impl.setFechaimplante(this.getBackupFecha());
					break;	
				}
			}
			for (Procedimiento p : this.lstprocsseg) {
				if (UtilFechas.dateDiff(this.impl.getFechaimplante(), p.getFecha()) < 0){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_act_fechas_impl_segs"));
					//this.impl.setFechaimplante(this.getBackupFecha());
					break;	
				}
			}
			this.compac.setFechaini(this.impl.getFechaimplante());
			this.compacpost.setFechaini(this.impl.getFechaimplante());
		}
		// actualizacion fechas de implante electrodos
		if(/*this.previoimp==false ||*/ (this.proc!=null && this.proc.getTipoprocedimiento()!=null
				/*&& (this.proc.getTipoprocedimiento().equals(956) || this.proc.getTipoprocedimiento().equals(993))*/)){		
			// se actualizan solo aquellos cuya fecha de implante coincide con la fecha de implante previa al cambio 
			for(ImpImplanteElectrodos el:this.listaelectrodos){
				if(el.getFechaimplante()!=null && el.getFechaimplante().equals(this.fechaimplante)){
					el.setFechaimplante(this.impl.getFechaimplante());
					el.setF_modificada(true);
				}		
			}
			this.fechaimplante = this.impl.getFechaimplante();// actualiza por si hay varios cambios para recoger el ultimo
		}else if(this.previoimp==false){
			for(ImpImplanteElectrodos el:this.listaelectrodos){
				el.setFechaimplante(this.impl.getFechaimplante());
				el.setF_modificada(true);		
			}
		}else if(this.proc.getIdprocedimiento()==null){// insert del resto de procedimientos
			for(ImpImplanteElectrodos el:this.listaelectrodos){
				if(el.isPrevio()){
					el.setFechaimplante(this.impl.getFechaimplante());
					el.setF_modificada(true);
				}
					
			}
		}// los UPDATE de otros procs. que no sean PRIMOIMPL o INT.PREVIA no se cambian las fechas de impl. de electrodos cuando cambia la del implante.	
	}

	private Complicacion obtenerComplicacion(Complicacion[] l, Integer i) {
		for (Complicacion c : l) {
			if (c.getIdcompl() == i) {
				return c;
			}
		}
		return null;
	}

	private void cargaAntecedentes() {
		this.hind.setAnteinsrenal((this.hind.getInsrenal() != null)
				&& (this.hind.getInsrenal() == 1) ? true : false);
		this.hind.setAntefa((this.hind.getAntfa() != null)
				&& (this.hind.getAntfa() == 1) ? true : false);
		this.hind.setAntediab((this.hind.getDiabetes() != null)
				&& (this.hind.getDiabetes() == 1) ? true : false);
		this.hind.setAntehipertens((this.hind.getHipertension() != null)
				&& (this.hind.getHipertension() == 1) ? true : false);
		this.hind.setAnteHTA((this.hind.getHta() != null)
				&& (this.hind.getHta() == 1) ? true : false);
		this.hind.setAntefam((this.hind.getMuertesubita() != null)
				&& (this.hind.getMuertesubita() == 1) ? true : false);
		this.hind.setAntetabaq((this.hind.getTabaquismo() != null)
				&& (this.hind.getTabaquismo() == 1) ? true : false);
		this.hind.setAntehipercol((this.hind.getHipercolest() != null)
				&& (this.hind.getHipercolest() == 1) ? true : false);
		this.hind.setAnteacv((this.hind.getAcv() != null)
				&& (this.hind.getAcv() == 1) ? true : false);
		this.hind.setAnteTrasplanteCardiaco((this.hind.getTrasplantecardiaco() != null)
				&& (this.hind.getTrasplantecardiaco() == 1) ? true : false);
		this.hind.setAnteAIT((this.hind.getAit() != null)
				&& (this.hind.getAit() == 1) ? true : false);
		this.hind.setAnteEPOC((this.hind.getEpoc() != null)
				&& (this.hind.getEpoc() == 1) ? true : false);
		this.hind.setAnteSAHS((this.hind.getSahs() != null)
				&& (this.hind.getSahs() == 1) ? true : false);
		this.hind.setAnteCPAP((this.hind.getCpap() != null)
				&& (this.hind.getCpap() == 1) ? true : false);
		this.hind.setAnteNeoplasia((this.hind.getNeoplasia() != null)
				&& (this.hind.getNeoplasia() == 1) ? true : false);	
		this.hind.setAnteSincope((this.hind.getSincope() != null)
				&& (this.hind.getSincope() == 1) ? true : false);
		this.hind.setAnteParadaCardiaca((this.hind.getParadacardiaca() != null)
				&& (this.hind.getParadacardiaca() == 1) ? true : false);
		this.hind.setEnfarterios((this.hind.getEnfart()!=null)&&(this.hind.getEnfart()==1) ? true:false);
		this.hind.setAnteflutter((this.hind.getFlutter() != null) && (this.hind.getFlutter() == 1) ? true : false);
	}
	
	public void imprimeInformeEspecifico(ActionEvent e) {
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String jasper = null;
		if (this.getTipogen() == 1 || this.getTipogen() == 3 || this.getTipogen() == 5) {
			// Generar Tarjeta Europea de MP
			jasper = "TarjetaEuropeaPortadorMP-Todos.jasper";
			try {
				TarjetaMP tmp = preparaTarjetaEuropea();
				PathFicheroXml = generadorXML.imprimeInformeTarjetaEuropea(tmp,
						this.cp.pacienteSelect);
			} catch (Exception se) {
				logger.error("("+this.usuario+") Error generando documento (Tarjeta Europea MP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());
				try {
					nuevoMensaje(formulario.getId(),
							Mensaje.SEVERIDAD_ERROR,
							"Error generando documento,motivo: " + se.getMessage(),
							"Error generando documento,Motivo: " + se.getMessage());
				} catch (Exception e3) {
				}
			}
		} else if (this.getTipogen() == 2 || this.getTipogen() == 4 || this.getTipogen() == 6) {
			// Generar Registro DAI
			jasper = "RegistroDAI.jasper";
			try {
				UtilReporteRegistroDAI util = preparaRegistroDai();
				PathFicheroXml = generadorXML.imprimeInformeRegistroDAI(this.himp, this.hind, this.hev, util, this.cp.pacienteSelect,this.infocentro, this.listacomp);
			} catch (Exception se) {
				logger.error("("+this.usuario+") Error generando documento (Registro DAI). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());
				try {
					nuevoMensaje(formulario.getId(),
							Mensaje.SEVERIDAD_ERROR,
							"Error generando documento,motivo: " + se.getMessage(),
							"Error generando documento,Motivo: " + se.getMessage());
				} catch (Exception e3) {
				}
			}
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml, jasper);
			if(jasper.equals("RegistroDAI.jasper"))
				logger.info("("+this.usuario+") Generación de informe (Registro DAI). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
			else
				logger.info("("+this.usuario+") Generación de informe (Tarjeta Europea MP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento (RegistroDAI/Tarjeta Europea MP). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}

	}

	public void imprimeInforme(ActionEvent e) {
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String jasper = "InformeImplante.jasper";
		try {
			UtilReporteInformes util = preparaReporteInforme();
			PathFicheroXml = generadorXML.imprimeInformeImplante(this.impl, this.hind, this.himp, this.hev, this.cp.pacienteSelect, 
					util,this.infocentro,this.listaelectrodos,this.listacomplicacionesintra,this.listacomplicacionespost,this.bundle);
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
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generación de informe (Implante). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
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
	/**
	 * Evento para generar informe de suministro 
	 * Un informe (triplicado) por cada tipo de material de distinto fabricante
	 * @param e
	 */
	public void imprimeInformeSuministro(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String jasper = "InformeSuministroGlobal.jasper";
		//Se pasa todo al generador XML y ahi se discrimina por fabricante		
		try {
			UtilReporteInformes util = preparaReporteInforme();
			PathFicheroXml = generadorXML.imprimeInformeSuministro(this.cp.pacienteSelect,this.listagenerador,
					this.listaelectrodos,this.himp.getPoperador(),this.proc,this.hev,this.himp,this.hind,util);
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
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generación de informe (Implante). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
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
	public String printInforme() {
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String path = "";
		String jasper = "InformeImplante.jasper";
		try {
			UtilReporteInformes util = preparaReporteInforme();
			PathFicheroXml = generadorXML.imprimeInformeImplante(this.impl,this.hind, this.himp, this.hev, this.cp.pacienteSelect,
					util,this.infocentro,this.listaelectrodos,this.listacomplicacionesintra,this.listacomplicacionespost,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: " + se.getMessage(),
						"Error generando documento,Motivo: " + se.getMessage());
			} catch (Exception e3) {
			}
		}
		try {
			path = constructorPDF.generarArchivoPdfFile(FacesContext.getCurrentInstance(), PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generación de informe (Implante). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
		return path;
	}

	private UtilReporteInformes preparaReporteInforme() {
		UtilReporteInformes util = new UtilReporteInformes();
		if (this.getTipogen() == 1)
			util.setTipodispositivo("Marcapasos");
		else if (this.getTipogen() == 2)
			util.setTipodispositivo("Desfibrilador");
		else if (this.getTipogen() == 3)
			util.setTipodispositivo("CRT");
		else if (this.getTipogen() == 4)
			util.setTipodispositivo("CRT/DAI");
		else if (this.getTipogen() == 5)
			util.setTipodispositivo("Marcapasos sin cable");
		else if (this.getTipogen() == 6)
			util.setTipodispositivo("DAI Subcutáneo");
		else
			util.setTipodispositivo("");
		
		if(this.proc.getTipoprocedimiento()==956)
			util.setTipoprocedimiento("Primoimplante de dispositivo");
		else if(this.proc.getTipoprocedimiento()==957)
			util.setTipoprocedimiento("Reintervención");
		else if(this.proc.getTipoprocedimiento()==1059)
			util.setTipoprocedimiento("Recambio");
		else if(this.proc.getTipoprocedimiento()==1060)
			util.setTipoprocedimiento("Upgrade");
		else if(this.proc.getTipoprocedimiento()==993)
			util.setTipoprocedimiento("Intervención previa");
		else if(this.proc.getTipoprocedimiento()==1085)
			util.setTipoprocedimiento("Recolocación Generador");
		else if(this.proc.getTipoprocedimiento()==1086)
			util.setTipoprocedimiento("Recolocación Electrodo");
		else if(this.proc.getTipoprocedimiento()==1147)
			util.setTipoprocedimiento("Explante");
		else if(this.proc.getTipoprocedimiento()==1090)
			util.setTipoprocedimiento("Reimplante");
		else
			util.setTipoprocedimiento("");

		for (SelectItem i : this.getRitmos()) {
			if (i.getValue().toString().equals(this.hind.getRitmo().toString())) {
				util.setRitmo(i.getLabel());
				break;
			}
		}
		if(this.hind.getRitmo2()!=null){
			for (SelectItem i : this.getRitmossa()) {
				if (i.getValue().toString().equals(this.hind.getRitmo2().toString())) {
					util.setRitmo2(i.getLabel());
					break;
				}
			}
			if(util.getRitmo2()==null)
				for (SelectItem i : this.getRitmosfa()) {
					if (i.getValue().toString().equals(this.hind.getRitmo2().toString())) {
						util.setRitmo2(i.getLabel());
						break;
					}
				}
			if(util.getRitmo2()==null)
				for (SelectItem i : this.getRitmostv()) {
					if (i.getValue().toString().equals(this.hind.getRitmo2().toString())) {
						util.setRitmo2(i.getLabel());
						break;
					}
				}
		}
		
		for (SelectItem i : this.getConducciones()) {
			if (i.getValue().toString().equals(this.hind.getConducav().toString())) {
				util.setConduccionav(i.getLabel());
				break;
			}
		}
		for (SelectItem i : this.getQrs()) {
			if (i.getValue().toString().equals(this.hind.getQrs().toString())) {
				util.setConduccionqrs(i.getLabel());
				break;
			}
		}
		if(this.hind.getCardiopatia()!=null)
			for (SelectItem i : this.getCardiopatia()) {
				if (i.getValue().toString().equals(this.hind.getCardiopatia().toString())) {
					util.setCardiopatia(i.getLabel());
					break;
				}
			}
		
		String pops = "";
		for (ImpHojaImplantePop s : this.himp.getPoperador()) {
			pops = pops + s.getIdop() + ", ";
		}
		if(pops.length()>0)
			pops = pops.substring(0,pops.length()-2);
		util.setPrimeroperador(pops);
		String sops = "";
		for (ImpHojaImplanteSop s : this.himp.getSoperador()) {
			sops = sops + s.getIdop() + ", ";
		}
		if(sops.length()>0)
			sops = sops.substring(0, sops.length()-2);
		util.setSegundooperador(sops);
		String enf = "";
		for (ImpHojaImplanteEnf s : this.himp.getEnfermeras()) {
			enf = enf + s.getIdenf() + ", ";
		}
		if(enf.length()>0)
			enf = enf.substring(0,enf.length()-2);
		util.setEnfermeria(enf);
		String selecs = "";
		if(this.listagenerador.size()>0){
			Generador g = null;
			try {
				g = this.g.findByPrimaryKey(this.listagenerador.get(0).getIdgenerador());
			} catch (GeneradorDaoException e1) {					
				e1.printStackTrace();
			}
			if(g!=null){
				util.setModelogen(g.getModelo());
				util.setFabricantegen(g.getFabricante());
				selecs = this.bundle.getString("imp_dispositivos_reporte_gen")+": " + g.getFabricante() + " " + g.getModelo();
				util.setMri(g.getMri()!=null && g.getMri()==1?true:false);
				util.setRf(g.getRf()!=null && g.getRf()==1?true:false);
			}
			util.setNumseriegen(this.listagenerador.get(0).getNumserie());
			selecs = selecs + ". "+this.bundle.getString("imp_dispositivos_reporte_gen_ns")+": " + this.listagenerador.get(0).getNumserie() + "\n";
			// Localizacion generador
			if(this.tipogen!=5){
				if(this.tipogen==6){
					for (SelectItem i : this.getLocalizaciongensicd()) {
						if (i.getValue().toString().equals(this.listagenerador.get(0).getLocalizacion().toString())) {
							util.setLocalizaciongen(!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():" "+this.bundle.getString("no_especificada")+".");
							selecs = selecs + this.bundle.getString("imp_dispositivos_reporte_gen_loc")+": " + (!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():" "+this.bundle.getString("no_especificada")+".") + "\n\n";
							break;
						}
					}
				}else{
					for (SelectItem i : this.getLocalizaciongen()) {
						if (i.getValue().toString().equals(this.listagenerador.get(0).getLocalizacion().toString())) {
							util.setLocalizaciongen(!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():" no especificada.");
							selecs = selecs + this.bundle.getString("imp_dispositivos_reporte_gen_loc")+": " + (!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():" "+this.bundle.getString("no_especificada")+".") + "\n\n";
							break;
						}
					}
				}
			}else{// Localizacion generador MPLeadless
				for (SelectItem i : this.getZonacamaravd()) {
					if (i.getValue().toString().equals(this.listagenerador.get(0).getLocalizacion().toString())) {
						util.setLocalizaciongen(!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():" "+this.bundle.getString("no_especificada")+".");
						selecs = selecs + this.bundle.getString("imp_dispositivos_reporte_gen_loc")+": " + (!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():" "+this.bundle.getString("no_especificada")+".") + "\n\n";
						break;
					}
				}
			}
			if(this.hev.getModogen()!=null)
				for (SelectItem i : this.getModogen()) {
					if (i.getValue().toString().equals(this.hev.getModogen().toString())) {
						util.setModogen(!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():null);
						break;
					}
				}
			// motivos de recambio
			if(this.listagenerador.get(0).getMotivorecambio()!=null)
				for (SelectItem i : this.getMrecambiogen()) {
					if (i.getValue().toString().equals(this.listagenerador.get(0).getMotivorecambio().toString())) {
						util.setMotivorecambiogen(!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():null);
						break;
					}
				}
			// motivos de recolocacion
			if(this.listagenerador.get(0).getMotivorecolocacion()!=null)
				for (SelectItem i : this.getMrecolocaciongen()) {
					if (i.getValue().toString().equals(this.listagenerador.get(0).getMotivorecolocacion().toString())) {
						util.setMotivorecolocaciongen(!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():null);
						break;
					}
				}
			// motivos de explante
			// TODO
		}else
			util.setTipodispositivo("");
		
		for (ImpImplanteElectrodos e : this.listaelectrodos) {
			String zona = "";
			Electrodos el = null;
			try {
				el = this.e.findByPrimaryKey(e.getIdelectrodo());
			} catch (ElectrodosDaoException e1) {
				e1.printStackTrace();
			}
			if(el!=null){
				if (e.getCamara().equals(948)) {// AD
					util.setModeloelectrodoad(el.getModelo());
					if(e.getZonacamara()!=null)
						for (SelectItem cam : this.getZonacamaraad()) {
							if (cam.getValue().toString().equals(e.getZonacamara().toString())) {
								zona = cam.getLabel();
								break;
							}
						}
					else
						zona = this.bundle.getString("imp_dispositivos_reporte_elec_zona_noesp");
					selecs = selecs + this.bundle.getString("imp_dispositivos_reporte_elec_ad")+": "
							+ el.getFabricante()!=null?el.getFabricante():""+ " "+ el.getModelo() + "." + " "+this.bundle.getString("imp_dispositivos_reporte_gen_ns")+": " 
									+ (e.getNumserie() != null ? e.getNumserie() : "no especificado") + " en " + zona
							+ "\n";
					//break;
				} else if (e.getCamara().equals(949)) {
					util.setModeloelectrodovd(el.getModelo());
					if(e.getZonacamara()!=null)
						for (SelectItem cam : this.getZonacamaravd()) {
							if (cam.getValue().toString().equals(e.getZonacamara().toString())) {
								zona = cam.getLabel();
								break;
							}
						}
					else
						zona = this.bundle.getString("imp_dispositivos_reporte_elec_zona_noesp");
					selecs = selecs + this.bundle.getString("imp_dispositivos_reporte_elec_vd")+": "
							+ el.getFabricante()!=null?el.getFabricante():"" + " " + el.getModelo() + "." + " "+this.bundle.getString("imp_dispositivos_reporte_gen_ns")+": " 
									+ (e.getNumserie() != null ? e.getNumserie() : "no especificado") + " en " + zona
							+ "\n";
					//break;
				} else if (e.getCamara().equals(950)) {
					util.setModeloelectrodovi(el.getModelo());
					if(e.getZonacamara()!=null)
						for (SelectItem cam : this.getZonacamaravi()) {
							if (cam.getValue().toString().equals(e.getZonacamara().toString())) {
								zona = cam.getLabel();
								break;
							}
						}
					else
						zona = this.bundle.getString("imp_dispositivos_reporte_elec_zona_noesp");
					selecs = selecs + this.bundle.getString("imp_dispositivos_reporte_elec_vi")+": "
							+ el.getFabricante()!=null?el.getFabricante():"" + " " + el.getModelo() + "." + " "+this.bundle.getString("imp_dispositivos_reporte_gen_ns")+": "
									+ (e.getNumserie() != null ? e.getNumserie() : "no especificado") + " en " + zona
							+ "\n";
					//break;
				}// FALTA LA AURICULA IZQUIERDA
			}
		}
		util.setInfoelecs(selecs);
		util.setInfosistema(selecs);
		return util;
	}

	private UtilReporteRegistroDAI preparaRegistroDai() {
		UtilReporteRegistroDAI util = new UtilReporteRegistroDAI();
		util.setHospitalprocedencia(cp.getPacienteSelect().getHprocedencia().toString());
		util.setFechaimplante(this.proc.getFecha());
		
		if(this.proc.getTipoprocedimiento()==956){
			util.setPrimoimplante(true);util.setRecambio(false);
		}else if(this.proc.getTipoprocedimiento()==1059 || this.proc.getTipoprocedimiento()==1060 ){
			util.setPrimoimplante(false);util.setRecambio(true);
			if(this.proc.getTipoprocedimiento()==1060)
				util.setMotivorecambio("3");
			else if(this.listagenerador.size()>0 && this.listagenerador.get(0).getMotivorecambio()!=null){
				if(this.listagenerador.get(0).getMotivorecambio()==960)
					util.setMotivorecambio("1");
				else if(this.listagenerador.get(0).getMotivorecambio()==1094)
					util.setMotivorecambio("2");
				else if(this.listagenerador.get(0).getMotivorecambio()==1093)
					util.setMotivorecambio("3");
			}
		}else
			util.setPrimoimplante(false);util.setRecambio(false);
			
		for (SelectItem i : this.getRitmos()) {
			if (i.getValue().toString().equals(this.hind.getRitmo().toString())) {
				util.setRitmo(i.getLabel());
				break;
			}
		}
		for (SelectItem i : this.getQrs()) {
			if (i.getValue().toString().equals(this.hind.getQrs().toString())) {
				util.setQrs(i.getLabel());
				break;
			}
		}
		for (SelectItem i : this.getHprocedencia()) {
			if (i.getValue().toString().equals(cp.getPacienteSelect().getHprocedencia().toString())) {
				util.setHospitalprocedencia(i.getLabel());
				break;
			}
		}
		
		for (ImpGenerador g : this.listagenerador) {
			if (g.getMotivorecambio() != null)
				util.setRecambio(true);
			if (g.getMotivoexplante() == null && (g.getLocalizacion() == 986 || g.getLocalizacion() == 987))
				util.setLocalizacion("1");
			if (g.getMotivoexplante() == null && (g.getLocalizacion() == 988 || g.getLocalizacion() == 989))
				util.setLocalizacion("2");
			if (g.getMotivoexplante() == null) {
				Generador auxgen = UtilConversorTarjetaEuropea.buscaGenerador(this.generadores, g.getIdgenerador());
				util.setInfogen(auxgen.getFabricante() + " " + auxgen.getModelo() + " Num.Serie:" + g.getNumserie());
				util.setModoBasico(auxgen.getModo()!=null?auxgen.getModo():null);
			}
		}
		String auxInfoElec = "";
		for (ImpImplanteElectrodos e : this.listaelectrodos) {
			if (e.getCamara() == 948)
				util.setAd(true);
			else if (e.getCamara() == 949)
				util.setVd(true);
			else if (e.getCamara() == 950)
				util.setVi(true);
			if (e.getEstado() == 0) {// Solo metemos los electrodos activos
				Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos, e.getIdelectrodo());
				auxInfoElec = auxInfoElec + auxelec.getFabricante() + " " + auxelec.getModelo() + " "+this.bundle.getString("imp_dispositivos_reporte_gen_ns")+":" + e.getNumserie()
						+ "\n";
				util.setInfoelecs(auxInfoElec);
				// Electrodos Previos
				util.setElecprev("1");
			} else if (((e.getEstado() == 2) || (e.getEstado() == 3)) && (e.getCaracter() == 2)) {
				// Electrodos Previos
				util.setElecdisfexp("1");
			} else if (e.getEstado() == 1)
				// Electrodos Previos
				util.setElecdisfaban("1");
		}

		// FECHA IMPLANTE SI OTROS -> Coger fecha de implante de DAI anterior
		if (this.proc.getIdprocedimiento() - 1 > 0 && this.proclst.length > 1) {
			List<Procedimiento> lista_procs = Arrays.asList(this.proclst);
			// Ordenar DESC
			Collections.sort(lista_procs, new Comparator() {
				public int compare(Object o1, Object o2) {
					Procedimiento e1 = (Procedimiento) o1;
					Procedimiento e2 = (Procedimiento) o2;
					if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())>0) {
						return 1;
					} else if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())<=0) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for(int i=0;i<lista_procs.size();i++){
				if(!lista_procs.get(i).getTipoprocedimiento().equals(1147) && !lista_procs.get(i).getTipoprocedimiento().equals(957)
						&& !lista_procs.get(i).getTipoprocedimiento().equals(1085) && !lista_procs.get(i).getTipoprocedimiento().equals(1086)){
					util.setFechaimplanteprevio(lista_procs.get(i).getFecha());
					break;
				}
			}
			/*for (int i = 0; i < this.proclst.length; i++) {
				if (this.proclst[i].getIdprocedimiento().equals(this.proc.getIdprocedimiento())) {
					if (i > 0)
						util.setFechaimplanteprevio(this.proclst[i - 1].getFecha());
					break;
				}
			}*/
		}

		/*util.setC1((this.listacomplicacionesintra.size() == 0) ? "1" : "");
		util.setC2("");util.setC3("");util.setC4("");util.setC5("");util.setC6("");util.setC7("");
		for(ImpHojaImplanteComplicacion c:this.listacomplicacionesintra){
			if(c.getIdcompl()==16)
				util.setC4("1");//Neumotorax - revisar si se quita la clase respiratoria
			else if(c.getIdcompl()>=18 && c.getIdcompl()<=24 )
				util.setC2("1");// Muerte
			else if(c.getIdcompl()==123)
				util.setC3("1");// Taponamiento Cardiaco
			else if(c.getIdcompl()==124)
				util.setC5("1");// Diseccion SC
			else if(c.getIdcompl()==125)
				util.setC7("1");// Situacion Suboptima VI
			else 
				util.setC6("1");// Otras
		}*/
		// FALTAN POR DEFINIR EL RESTO
		for (ImpHojaImplanteComplicacion c : this.listacomplicacionesintra) {
			if (c.getIdcompl() == 16)
				util.setC4("1");
		}
		return util;
	}

	private TarjetaMP preparaTarjetaEuropea() {
		TarjetaMP tmp = new TarjetaMP();
		// Buscar fecha de primer implante - de MP o de generador en general
		// Se buscara el PRIMOIMPLANTE sea el generador que sea - REVISAR
		for(Procedimiento p:this.proclst){
			if(p.getTipoprocedimiento().equals(956)){
				tmp.setFechaprimerimplante(p.getFecha());
				break;
			}
		}
		if(tmp.getFechaprimerimplante()==null)// Comprobacion segunda. Caso primoimplante + generacion de informe. No se mete aun en proclst
			if(this.proc.getTipoprocedimiento()==956)
				tmp.setFechaprimerimplante(this.proc.getFecha());	
		
		if(this.hind.getSintomas().size()>0)
			tmp.setSintprim((this.hind.getSintomas().get(0) != null) ? UtilConversorTarjetaEuropea
					.codigoSintoma(this.hind.getSintomas().get(0).getIdsintomas(),this.hind.getRitmo(),this.hind.getRitmo2())
					: "");
		else if(this.hind.getRitmo()!=null && this.hind.getRitmo2()!=null && (tmp.getSintprim()==null || tmp.getSintprim().equals(""))){// verificar BRADICARDIA
			tmp.setSintprim(UtilConversorTarjetaEuropea.codigoSintoma(null,this.hind.getRitmo(),this.hind.getRitmo2()));
		}
		if(this.hind.getSintomas().size()>1)
			tmp.setSintsec((this.hind.getSintomas().get(1) != null) ? UtilConversorTarjetaEuropea
					.codigoSintoma(this.hind.getSintomas().get(1).getIdsintomas(),this.hind.getRitmo(),this.hind.getRitmo2())
					: "");
		else if(this.hind.getRitmo()!=null && this.hind.getRitmo2()!=null && (tmp.getSintsec()==null || tmp.getSintsec().equals(""))
				&& (tmp.getSintprim()!=null && !tmp.getSintprim().equals("B3"))){// verificar BRADICARDIA
			tmp.setSintsec(UtilConversorTarjetaEuropea.codigoSintoma(null,this.hind.getRitmo(),this.hind.getRitmo2()));
		}
		// ETIOLOGIA
		tmp.setEtioprim(UtilConversorTarjetaEuropea.codigoEtiologia(this.hind.getCardiopatia(),this.hind.getNeuromediados(),this.hind.isAnteTrasplanteCardiaco(),this.hind.isInfartoprev()));
		// ECG
		int anchura=0;int r2=0;int c2=0;int q2=0;
		if(this.hind.getAnchuraqrs().length()>0)
			anchura = Integer.valueOf(this.hind.getAnchuraqrs());
		if(this.hind.getRitmo2()!=null)
			r2=this.hind.getRitmo2();
		if(this.hind.getConducav2()!=null)
			c2 = this.hind.getConducav2();
		if(this.hind.getQrs2()!=null)
			q2 = this.hind.getQrs2();
		tmp.setEcgprim(UtilConversorTarjetaEuropea.codigoECG(this.hind.getRitmo(), r2, this.hind.getConducav(),c2, this.hind.getQrs(), q2, anchura));
		
		// Etiologia + ECG secundario -> no lo ponemos ya que no tiene sentido porque ECG1 y Etiologia1 se forman a partir de una combinacion unica de parametros. si cambian, cambiaran los primeros valores
		tmp.setDependientemp(this.hev.getMpdependiente() != null && this.hev.getMpdependiente() == 1 ? 1 : 0);
		// CENTRO MP
		String pops = "";
		for (ImpHojaImplantePop s : this.himp.getPoperador()) {
			pops = pops + s.getIdop() + ", ";
		}
		tmp.setDoctor(pops);

		tmp.setFrecgen((this.hev.getFmin() != null) ? this.hev.getFmin() : "");
		tmp.setModogen((this.hev.getModogen() != null ? UtilConversorTarjetaEuropea.cambiaModoGen(this.hev.getModogen()) : ""));
		for (ImpGenerador g : this.listagenerador) {			
			if (g.getMotivoexplante() == null) {
				tmp.setNumseriegen(g.getNumserie());
				Generador auxgen = UtilConversorTarjetaEuropea.buscaGenerador(this.generadores2, g.getIdgenerador());
				tmp.setModelogen(auxgen.getModelo());
				tmp.setFabgen(auxgen.getFabricante());
				// Carga codigos de recambio/recolocacion si existe
				if(g.getMotivorecambio()!=null)
					tmp.setMotivoexpgen(UtilConversorTarjetaEuropea.codigoMotivoGeneradorRetirado(g.getMotivorecambio()));
				if(g.getMotivorecolocacion()!=null)
					tmp.setMotivoexpgen(UtilConversorTarjetaEuropea.codigoMotivoGeneradorRetirado(g.getMotivorecolocacion()));
				break;
			}
		}
		// Fecha implante generador
		// Si es Primoimplante,Intervencion previa,Recambio o Upgrade -> this.proc.getFecha
		// Si no lo es, hay que buscar la fecha de implante del ultimo primoimp,intprev,recambio o upgrade
		if(this.proc.getTipoprocedimiento().equals(1085) || this.proc.getTipoprocedimiento().equals(1086)
				|| this.proc.getTipoprocedimiento().equals(957)
				|| this.proc.getTipoprocedimiento().equals(1147)){
			tmp.setFechaimpgen(buscaFechaUltimoImplante());
		}else
			tmp.setFechaimpgen(this.proc.getFecha());
		// EXPLANTE GENERADOR
		if (this.listageneradorexp != null) {
			for (ImpGenerador g : this.listageneradorexp) {
				if (g.getMotivoexplante() != null) {
					tmp.setMotivoexpgen(tmp.getMotivoexpgen()==null?UtilConversorTarjetaEuropea.codigoMotivoGeneradorRetirado(g.getMotivoexplante()):tmp.getMotivoexpgen());
					Generador auxgen = UtilConversorTarjetaEuropea.buscaGenerador(this.generadores2,g.getIdgenerador());
					tmp.setModelogenexp(auxgen.getModelo());
					tmp.setFabgenexp(auxgen.getFabricante());
					tmp.setFechaexplante(this.proc.getFecha());
					tmp.setModogenexp(g.getModo());
					tmp.setNumseriegenexp(g.getNumserie());
					tmp.setFechaimpgenexp(buscaImplanteGenExp(g).getFechaimplante());
					break;
				}
			}
		}
		if (this.isActualizacion() && this.listageneradorexptarjeta != null)
			for (ImpGenerador g : this.listageneradorexptarjeta) {
				if (g.getMotivoexplante() != null) {
					tmp.setMotivoexpgen(tmp.getMotivoexpgen()==null?UtilConversorTarjetaEuropea.codigoMotivoGeneradorRetirado(g.getMotivoexplante()):tmp.getMotivoexpgen());
					Generador auxgen = UtilConversorTarjetaEuropea.buscaGenerador(this.generadores2,g.getIdgenerador());
					tmp.setModelogenexp(auxgen.getModelo());
					tmp.setFabgenexp(auxgen.getFabricante());
					tmp.setFechaexplante(this.proc.getFecha());
					tmp.setModogenexp(g.getModo());
					tmp.setNumseriegenexp(g.getNumserie());
					tmp.setFechaimpgenexp(buscaImplanteGenExp(g).getFechaimplante());
					break;
				}
			}
		boolean vd = false, vi = false;
		String auxDurImpAD = null, auxDurImpVD = null, auxDurImpVI = null;
		for (ImpImplanteElectrodos e : this.listaelectrodos) {
			if ((e.getMotivoexaband() == null || e.getMotivoexaband()==0 || e.getMotivoexaband()==-2147483648) && e.getCamara() == 948 && e.isVdd()==false) {// AD
				tmp.setFechaimpea(e.getFechaimplante());
				Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, e.getIdelectrodo());
				tmp.setFabea(auxelec.getFabricante());
				tmp.setModeloea(auxelec.getModelo());
				tmp.setNumserieea(e.getNumserie());
				auxDurImpAD = e.getDurimpulso();
				if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
					tmp.setIsea(true);
				if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
					tmp.setUnibiea(1);
				else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
					tmp.setUnibiea(0);
				if(e.getMotivorecambio()!=null)
					tmp.setMotivoexpea(UtilConversorTarjetaEuropea.codigoMotivoElectrodoRetirado(e.getMotivorecambio()));
			} else if ((e.getMotivoexaband() == null || e.getMotivoexaband()==0 || e.getMotivoexaband()==-2147483648) && e.getCamara() == 949) { // VD
				tmp.setFechaimpev(e.getFechaimplante());
				Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, e.getIdelectrodo());
				tmp.setFabev(auxelec.getFabricante());
				tmp.setModeloev(auxelec.getModelo());
				tmp.setNumserieev(e.getNumserie());
				auxDurImpVD = e.getDurimpulso();
				vd = true;
				if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
					tmp.setIsev(true);
				if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
					tmp.setUnibiev(1);
				else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
					tmp.setUnibiev(0);
				if(e.getMotivorecambio()!=null)
					tmp.setMotivoexpev(UtilConversorTarjetaEuropea.codigoMotivoElectrodoRetirado(e.getMotivorecambio()));
			} else if ((e.getMotivoexaband() == null || e.getMotivoexaband()==0 || e.getMotivoexaband()==-2147483648) && e.getCamara() == 949) {
				auxDurImpVI = e.getDurimpulso();
				vi = true;
			}
		}
		// Duracion Impulso Generador
		if (vd)
			tmp.setDurimpgen(auxDurImpVD);
		else if (vi && !vd)
			tmp.setDurimpgen(auxDurImpVI);
		else
			tmp.setDurimpgen(auxDurImpAD);

		// EXPLANTES PARCIALES/ABANDONOS ELECTRODOS
		for (ImpImplanteElectrodos e : this.listaelectrodos) {
			if ((e.getMotivoexaband() != null && (e.getEstado() != null && e.getEstado()>0)) && e.getCamara() == 948 && e.isVdd()==false) {// AD
				//tmp.setFechaimpeaexp(buscaFechaImplanteEaEvExp(e));
				tmp.setFechaimpeaexp(e.getFechaimplante());
				Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, e.getIdelectrodo());
				tmp.setFabeaexp(auxelec.getFabricante());
				tmp.setModeloeaexp(auxelec.getModelo());
				tmp.setNumserieeaexp(e.getNumserie());
				tmp.setFechaexplante(this.proc.getFecha());
				if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
					tmp.setIseaexp(true);
				if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
					tmp.setUnibieaexp(1);
				else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
					tmp.setUnibieaexp(0);
				if(e.getMotivoexaband()!=null)
					tmp.setMotivoexpea(tmp.getMotivoexpea()==null?UtilConversorTarjetaEuropea.codigoMotivoElectrodoRetirado(e.getMotivoexaband()):tmp.getMotivoexpea());
			} else if ((e.getMotivoexaband() != null && (e.getEstado() != null && e.getEstado()>0)) && e.getCamara() == 949) { // VD
				tmp.setFechaimpeevxp(e.getFechaimplante());
				Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, e.getIdelectrodo());
				tmp.setFabevexp(auxelec.getFabricante());
				tmp.setModeloevexp(auxelec.getModelo());
				tmp.setNumserieevexp(e.getNumserie());
				tmp.setFechaexplante(this.proc.getFecha());
				if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
					tmp.setIsevexp(true);
				if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
					tmp.setUnibievexp(1);
				else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
					tmp.setUnibievexp(0);
				if(e.getMotivoexaband()!=null)
					tmp.setMotivoexpev(tmp.getMotivoexpev()==null?UtilConversorTarjetaEuropea.codigoMotivoElectrodoRetirado(e.getMotivoexaband()):tmp.getMotivoexpev());
			} else if ((e.getMotivoexaband() == null || e.getMotivoexaband()==0 || e.getMotivoexaband()==-2147483648) && e.getCamara() == 949) {
				auxDurImpVI = e.getDurimpulso();
				vi = true;
			}
		}
		// EXPLANTES COMPLETOS ELECTRODOS
		if (this.listaelectrodosexp != null) {
			for (ImpImplanteElectrodos e : this.listaelectrodosexp) {
				if (e.getEstado() != 0 && e.getCamara() == 948 && e.isVdd()==false) {// AD
					//tmp.setFechaimpeaexp(buscaFechaImplanteEaEvExp(e));
					tmp.setFechaimpeaexp(e.getFechaimplante());
					Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, e.getIdelectrodo());
					tmp.setFabeaexp(auxelec.getFabricante());
					tmp.setModeloeaexp(auxelec.getModelo());
					tmp.setNumserieeaexp(e.getNumserie());
					tmp.setFechaexplante(this.proc.getFecha());
					if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
						tmp.setIseaexp(true);
					if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
						tmp.setUnibieaexp(1);
					else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
						tmp.setUnibieaexp(0);
					if(e.getMotivoexaband()!=null)
						tmp.setMotivoexpea(tmp.getMotivoexpea()==null?UtilConversorTarjetaEuropea.codigoMotivoElectrodoRetirado(e.getMotivoexaband()):tmp.getMotivoexpea());
				} else if (e.getEstado() != 0 && e.getCamara() == 949) { // VD
					//tmp.setFechaimpeevxp(buscaFechaImplanteEaEvExp(e));
					tmp.setFechaimpeevxp(e.getFechaimplante());
					Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, e.getIdelectrodo());
					tmp.setFabevexp(auxelec.getFabricante());
					tmp.setModeloevexp(auxelec.getModelo());
					tmp.setNumserieevexp(e.getNumserie());
					tmp.setFechaexplante(this.proc.getFecha());
					if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
						tmp.setIsevexp(true);
					if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
						tmp.setUnibievexp(1);
					else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
						tmp.setUnibievexp(0);
					if(e.getMotivoexaband()!=null)
						tmp.setMotivoexpev(tmp.getMotivoexpev()==null?UtilConversorTarjetaEuropea.codigoMotivoElectrodoRetirado(e.getMotivoexaband()):tmp.getMotivoexpev());
				} else if (e.getEstado() != 0 && e.getCamara() == 949) {

				}
			}
		}
		if (this.isActualizacion() && this.listaelectrodosexptarjeta != null) {
			for (ImpImplanteElectrodos e : this.listaelectrodosexptarjeta) {
				if (e.getEstado() != 0 && e.getCamara() == 948 && e.isVdd()==false) {// AD
					//tmp.setFechaimpeaexp(buscaFechaImplanteEaEvExp(e));
					tmp.setFechaimpeaexp(e.getFechaimplante());
					Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, e.getIdelectrodo());
					tmp.setFabeaexp(auxelec.getFabricante());
					tmp.setModeloeaexp(auxelec.getModelo());
					tmp.setNumserieeaexp(e.getNumserie());
					tmp.setFechaexplante(this.proc.getFecha());
					if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
						tmp.setIseaexp(true);
					if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
						tmp.setUnibieaexp(1);
					else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
						tmp.setUnibieaexp(0);
					if(e.getMotivoexaband()!=null)
						tmp.setMotivoexpea(tmp.getMotivoexpea()==null?UtilConversorTarjetaEuropea.codigoMotivoElectrodoRetirado(e.getMotivoexaband()):tmp.getMotivoexpea());
				} else if (e.getEstado() != 0 && e.getCamara() == 949) { // VD
					//tmp.setFechaimpeevxp(buscaFechaImplanteEaEvExp(e));
					tmp.setFechaimpeevxp(e.getFechaimplante());
					Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(this.electrodos2, e.getIdelectrodo());
					tmp.setFabevexp(auxelec.getFabricante());
					tmp.setModeloevexp(auxelec.getModelo());
					tmp.setNumserieevexp(e.getNumserie());
					tmp.setFechaexplante(this.proc.getFecha());
					if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
						tmp.setIsevexp(true);
					if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
						tmp.setUnibievexp(1);
					else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
						tmp.setUnibievexp(0);
					if(e.getMotivoexaband()!=null)
						tmp.setMotivoexpev(tmp.getMotivoexpev()==null?UtilConversorTarjetaEuropea.codigoMotivoElectrodoRetirado(e.getMotivoexaband()):tmp.getMotivoexpev());
				} else if (e.getEstado() != 0 && e.getCamara() == 949) {

				}
			}
		}
		tmp.setHospital(this.infocentro.getCentro());
		tmp.setDirhosp(this.infocentro.getDireccion());
		tmp.setCiudadhosp(this.infocentro.getCiudad());
		tmp.setTfnohosp(this.infocentro.getTelefono());
		
		return tmp;
	}

	private Date buscaFechaUltimoImplante(){
		Date res = this.proc.getFecha();// inicializa a fecha del procedimiento
		for(Procedimiento p:this.proclst){
			if(p.getTipoprocedimiento().equals(956)||p.getTipoprocedimiento().equals(1059)
					||p.getTipoprocedimiento().equals(1060)||p.getTipoprocedimiento().equals(993)){
				if(UtilFechas.dateDiff(p.getFecha(),res)<=0)
					res = p.getFecha();					
			}
		}
		return res;
	}
	
	private ImpImplante buscaImplanteGenExp(ImpGenerador gexp) {
		try {
			ImpGenerador[] gens = this.gendao.findByDynamicWhere("IDGENERADOR =? AND NUMSERIE = ?",
					new Object[] { gexp.getIdgenerador(), gexp.getNumserie() });
			// Asumiendo numero de serie
			ImpImplante[] imps = this.impdao.findWhereIdhojaimpEquals(gens[0].getIdhojaimp());
			return imps[0];
		} catch (Exception e) {
			return null;
		}

	}

	private Date buscaFechaImplanteEaEvExp(ImpImplanteElectrodos eaexp) {
		try {
			ImpImplanteElectrodos[] els = this.impelecdao.findByDynamicWhere("IDELECTRODO =? AND NUMSERIE = ?",
					new Object[] { eaexp.getIdelectrodo(),eaexp.getNumserie() });
			// Asumiendo numero de serie
			ImpImplante[] imps = this.impdao.findWhereIdhojaimpEquals(els[0].getIdhojaimp());
			return imps[0].getFechaimplante();
		} catch (Exception e) {
			return null;
		}
	}

	public GenericosDto obtenerTipoDispositivo(int idproc){
		try{
			GeneradorDao gendao = new GeneradorDaoImpl();
			ArrayList<ArrayList<Object>> gens = gendao.getGeneradorProcedimiento(idproc);
			GenericosDto res = new GenericosDto();
			if(gens.size()>0){				
				res.setTmpString1(gens.get(0).get(0));//Modelo
				//res.setTmpString1("modelo");
				res.setTmpString2((String)gens.get(0).get(1));//Tipo
			}	
			return res;
		}catch(Exception ex){
			pintaMensaje(3, this.bundle.getString("info_msg_error_rec_sistema")+": " + ex.getMessage());
			logger.error("("+this.usuario+") Error obteniendo registros en barra temporal - Motivo:"+ex.getMessage());
			return null;
		}
	}
	/****** controles booleanos -short ****/
	public void anteInsRenal(ActionEvent e) {
		this.hind.setInsrenal((short) (this.hind.isAnteinsrenal() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setInsrenal(this.hind.getInsrenal());
		this.sgen.setAnteinsrenal(this.hind.isAnteinsrenal());
	}

	public void anteFA(ActionEvent e) {
		this.hind.setAntfa((short) (this.hind.isAntefa() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAntfa(this.hind.getAntfa());
		this.sgen.setAntefa(this.hind.isAntefa());
	}

	public void anteFlutter(ActionEvent e) {
		this.hind.setFlutter((short) (this.hind.isAnteflutter() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setFlutter(this.hind.getFlutter());
		this.sgen.setAnteflutter(this.hind.isAnteflutter());
	}

	public void anteDiab(ActionEvent e) {
		this.hind.setDiabetes((short) (this.hind.isAntediab() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setDiabetes(this.hind.getDiabetes());
		this.sgen.setAntediab(this.hind.isAntediab());
	}

	public void anteHipertens(ActionEvent e) {
		this.hind.setHipertension((short) (this.hind.isAnteHTA() ? 1 : 0));
		this.hind.setHta((short) (this.hind.isAnteHTA() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setHta(this.hind.getHipertension());
		this.sgen.setAnteHTA(this.hind.isAnteHTA());
	}

	public void anteFam(ActionEvent e) {
		this.hind.setMuertesubita((short) (this.hind.isAntefam() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setMuertesubita(this.hind.getMuertesubita());
		this.sgen.setAntefam(this.hind.isAntefam());
	}

	public void anteTabaq(ActionEvent e) {
		this.hind.setTabaquismo((short) (this.hind.isAntetabaq() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setTabaquismo(this.hind.getTabaquismo());
		this.sgen.setAntetabaq(this.hind.isAntetabaq());
	}

	public void anteHipercoles(ActionEvent e) {
		this.hind.setHipercolest((short) (this.hind.isAntehipercol() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setDislipemia(this.hind.getHipercolest());
		this.sgen.setAnteDislipemia(this.hind.isAnteDislipemia());
	}

	public void anteACV(ActionEvent e) {
		this.hind.setAcv((short) (this.hind.isAnteacv() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAcv(this.hind.getAcv());
		this.sgen.setAnteacv(this.hind.isAnteacv());
	}

	public void reVasc(ActionEvent e) {
		this.hind.setRevasc((short) (this.hind.isRevascularizacion() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setRevasc(this.hind.getRevasc());
		this.sgen.setRevascularizacion(this.hind.isRevascularizacion());
	}

	public void infPrevio(ActionEvent e) {
		this.hind.setInfprevio((short) (this.hind.isInfartoprev() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setInfprevio(this.hind.getInfprevio());
		this.sgen.setInfartoprev(this.hind.isInfartoprev());
		// Actualizacion de valores de infarto previo si false
		if (!(this.hind.isInfartoprev())) {
			this.hind.setAnio(null);
			this.sgen.setAnio(this.hind.getAnio());
			this.hind.setLocalizacion(null);
			this.sgen.setLocalizacion(this.hind.getLocalizacion());
		}		
	}

	public void cambiaAnosEvolucion(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAevolucion(this.hind.getAevolucion());
	}

	public void cambiaAnosInfPrevio(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAnio(this.hind.getAnio());
	}

	public void cambiaLocalizacion(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setLocalizacion(this.hind.getLocalizacion());
	}

	public void testIndHojaImp(ActionEvent e) {
		this.himp.setTestind((short) (this.himp.isTesti() ? 1 : 0));
		// Actualizacion de valores de test induccion si false
		if (!(this.himp.isTesti())) {
			this.himp.setEnergiatest(null);
			this.himp.setImptest(null);
			this.himp.setNumchoqtest(null);
			this.himp.setPolaridadTest(null);
			this.himp.setTestindDesfib(null);
			this.himp.setTestindEfectivo(null);
		}
	}

	public void mDep(ActionEvent e) {
		this.hev.setMpdependiente((short) (this.hev.isMpdep() ? 1 : 0));
	}

	public void segRem(ActionEvent e) {
		this.hev.setSegremoto((short) (this.hev.isSegrem() ? 1 : 0));
	}

	public void minEstVent(ActionEvent e) {
		this.hev.setMev((short) (this.hev.isMinestvent() ? 1 : 0));
	}

	public void terapiaAtp(ActionEvent e) {
		this.hev.setAtp((short) (this.hev.isTeratp() ? 1 : 0));
	}

	public void terapiaChoques(ActionEvent e) {
		this.hev.setChoques((short) (this.hev.isTerchoques() ? 1 : 0));
	}

	public void terapiaEfectivaATP(ActionEvent e) {
		this.hev.setTerefecatp((short) (this.hev.isTerapiaefecatp() ? 1 : 0));
	}

	public void terapiaEfectivaChoques(ActionEvent e) {
		this.hev.setTereefecchoq((short) (this.hev.isTerapiaefecchoques() ? 1 : 0));
	}

	public void algPrevFA(ActionEvent e) {
		this.hev.setAlgprevfa((short) (this.hev.isPrevfa() ? 1 : 0));
	}

	public void cambiaAIT(ActionEvent e) {
		this.hind.setAit((short) (this.hind.isAnteAIT() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAit(this.hind.getAit());
		this.sgen.setAnteAIT(this.hind.isAnteAIT());
	}

	public void cambiaEPOC(ActionEvent e) {
		this.hind.setEpoc((short) (this.hind.isAnteEPOC() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setEpoc(this.hind.getEpoc());
		this.sgen.setAnteEPOC(this.hind.isAnteEPOC());
	}

	public void cambiaSAHS(ActionEvent e) {
		this.hind.setSahs((short) (this.hind.isAnteSAHS() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setSahs(this.hind.getSahs());
		this.sgen.setAnteSAHS(this.hind.isAnteSAHS());
		if(!(this.hind.isAnteSAHS())){
			this.hind.setTiposahs(null);
			this.sgen.setTiposahs(this.hind.getTiposahs());
			this.hind.setCpap(null);
			this.sgen.setCpap(this.hind.getCpap());
			this.hind.setAnteCPAP(false);			
			this.hind.setAhi(null);
			this.sgen.setAhi(this.hind.getAhi());
		}
		this.sgen.setAnteCPAP(this.hind.isAnteCPAP());
	}

	public void cambiaTipoSAHS(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setTiposahs(this.hind.getTiposahs());
	}

	public void cambiaNeoplasia(ActionEvent e) {
		this.hind.setNeoplasia((short) (this.hind.isAnteNeoplasia() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setNeoplasia(this.hind.getNeoplasia());
		this.sgen.setAnteNeoplasia(this.hind.isAnteNeoplasia());
		if(!(this.hind.isAnteNeoplasia())){
			this.hind.setTiponeoplasia(null);
			this.sgen.setTiponeoplasia(this.hind.getTiponeoplasia());
		}		
	}

	public void cambiaTipoNeoplasia(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setTiponeoplasia(this.hind.getTiponeoplasia());
	}

	public void cambiaAlergias(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAlergias(this.hind.getAlergias());
	}

	public void cambiaCPAP(ActionEvent e) {
		this.hind.setCpap((short) (this.hind.isAnteCPAP() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setCpap(this.hind.getCpap());
		this.sgen.setAnteCPAP(this.hind.isAnteCPAP());
	}

	public void cambiaIntervencionPrevia(ActionEvent e) {
		this.impl.setIntervencionprevia((short) (this.impl.isInterprev() ? 1: 0));
	}

	public void anteTCardiaco(ActionEvent e) {
		this.hind.setTrasplantecardiaco((short) (this.hind.isAnteTrasplanteCardiaco() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setTrasplantecardiaco(this.hind.getTrasplantecardiaco());
		this.sgen.setAnteTrasplanteCardiaco(this.hind.isAnteTrasplanteCardiaco());
	}

	public void cambiaSincope(ActionEvent e){
		this.hind.setSincope((short) (this.hind.isAnteSincope()?1:0));
		this.modsitclin = true;
		this.sgen.setSincope(this.hind.getSincope());
		this.sgen.setAnteSincope(this.hind.isAnteSincope());
	}

	public void cambiaParadaCardiaca(ActionEvent e){
		this.hind.setParadacardiaca((short)(this.hind.isAnteParadaCardiaca()?1:0));
		this.modsitclin = true;
		this.sgen.setParadacardiaca(this.hind.getParadacardiaca());
		this.sgen.setAnteParadaCardiaca(this.hind.isAnteParadaCardiaca());
	}

	public void cambiaArritmiasVentriculares(ActionEvent e){
		if(!this.hind.isAvent()){
			this.hind.setArritmias(null);
			this.sgen.setArritmias(this.hind.getArritmias());	
		}	
		this.sgen.setAvent(this.hind.isAvent());
		this.modsitclin = true;
	}

	public void cambiaArrVent(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setArritmias(this.hind.getArritmias());
	}

	public void cambiaEefPrevio(ActionEvent e){
		if(!this.hind.isEefprev()){
			this.hind.setEef(null);
			this.sgen.setEef(this.hind.getEef());			
		}
		this.sgen.setEefprev(this.hind.isEefprev());
		this.modsitclin = true;
	}

	public void cambiaEEF(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setEef(this.hind.getEef());
	}
	public void cambiaHisteresis(ActionEvent e){
		if(!(this.hev.isHist()))
			this.hev.setValorHisteresis(null);
	}

	public void cambiaIC(ActionEvent e){
		if(!(this.hind.isIc())){
			this.hind.setNyha(null);
			this.sgen.setNyha(this.hind.getNyha());			
		}	
		this.sgen.setIc(this.hind.isIc());
		this.modsitclin = true;
	}

	public void cambiaNYHA(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setNyha(this.hind.getNyha());
	}

	public void cambiaAfecTiroidea(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAfectiroidea(this.hind.getAfectiroidea());
	}

	public void cambiaNeurologicos(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setNeuromediados(this.hind.getNeuromediados());
	}

	public void cambiaEnfArt(ActionEvent e){
		this.hind.setEnfart(this.hind.isEnfarterios()?1:0);
		this.modsitclin = true;
		this.sgen.setEnfart(this.hind.getEnfart());
	}

	public void cambiaAI(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAi(this.hind.getAi());
	}

	public void cambiaAI2(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAi2(this.hind.getAi2());
	}

	/****** controles booleanos -short ****/
	public HtmlDataTable getBindingElec() {
		return bindingElec;
	}

	public void setBindingElec(HtmlDataTable bindingElec) {
		this.bindingElec = bindingElec;
	}

	public HtmlDataTable getBindingGen() {
		return bindingGen;
	}

	public void setBindingGen(HtmlDataTable bindingGen) {
		this.bindingGen = bindingGen;
	}

	public void addGenerador(ActionEvent e) {
		this.getListagenerador().add(new ImpGenerador());
		if (this.getListagenerador().size() > 0)
			this.setExplanteGen(false);
		this.cambioGen = true;
	}

	public void delGenerador(ActionEvent e) {
		//int previo = this.getTipogen();
		if (this.isPrevioimp()
				/*&& !(this.isActualizacion())*/
				&& this.getListageneradorexp().size() < this.getListagenerador().size()) {
			if(this.isActualizacion())
				this.getListagenerador().get(this.bindingGen.getRowIndex()).setMotivoexplante(0);
			// Se mete en la lista de explantados
			this.getListageneradorexp().add(this.getListagenerador().get(this.bindingGen.getRowIndex()));
			this.genexppk = this.listageneradorexp.get(0).createPk();
			
				
		}
		this.getListagenerador().remove(this.bindingGen.getRowIndex());
		if (this.getListagenerador().size() == 0){
			this.setExplanteGen(true);
			/*if(previo!=1)
				this.setTipogen(0);*/
		}
			
	}

	public void addElectrodos(ActionEvent e) {
		ImpImplanteElectrodos n = new ImpImplanteElectrodos();
		n.setPrevio(true);
		if (this.isPrevioimp() && (!(this.isActualizacion())))
			n.setRecambio(true);
		n.setFechaimplante(this.impl.getFechaimplante());
		this.getListaelectrodos().add(n);
		this.currentItemElectrodos = new ImpImplanteElectrodos();
		this.currentItemElectrodosBackUp = new ImpImplanteElectrodos();
	}

	public void actualizaDatosUmbrales(ActionEvent e){
		this.listaelectrodos.get(this.bindingElec.getRowIndex()).setOndarpEv(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getOndarpImp());
		this.listaelectrodos.get(this.bindingElec.getRowIndex()).setUmbralvEv(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getUmbralvImp());
		this.listaelectrodos.get(this.bindingElec.getRowIndex()).setUmbralmsEv(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getUmbralmsImp());
		this.listaelectrodos.get(this.bindingElec.getRowIndex()).setImpohmEv(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getImpohmImp());
		this.listaelectrodos.get(this.bindingElec.getRowIndex()).setImpvEv(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getImpvImp());
		this.listaelectrodos.get(this.bindingElec.getRowIndex()).setImpmsEv(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getImpmsImp());
	}
	
	public void delElectrodos(ActionEvent e) {
		// this.getListaelectrodos().get(this.bindingElec.getRowIndex()).setEliminar(true);		
		// CONTROL VDD
		// Hay que buscar el electrodo auuricular asociado y asignarle el numero de serie. Electrodo adyacente en lista
		/*if(this.bindingElec.getRowIndex()+1<this.listaelectrodos.size()){// comprueba si hay mas elementos en la lista
			// comprobar si el electrodo adyacente es auricular de VDD
			if(this.listaelectrodos.get(this.bindingElec.getRowIndex()+1).getTipoelectrodo().startsWith(String.valueOf(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getIdelectrodo()))){
				//if(this.getListaelectrodos().get(this.bindingElec.getRowIndex()).getIdelectrodo()!=null && this.impl.getIdimplante()!=null)
				//	this.getListaelectrodosexp().add(this.getListaelectrodos().get(this.bindingElec.getRowIndex()+1));	
				this.getListaelectrodos().remove(this.bindingElec.getRowIndex()+1);
			}
			actualizaListaElectrodos();
		}*/
		// Solo se meten electrodos en lista de explantados si es UPDATE para eliminarlos en el UPDATE - control de VDD
		if(this.getListaelectrodos().get(this.bindingElec.getRowIndex()).getIdelectrodo()!=null && this.impl.getIdimplante()!=null){
			if(this.getListaelectrodos().get(this.bindingElec.getRowIndex()).isVdd()){
				// busca pareja AD (VDD). Lo quita de la listaelectroso y lo introduce en listaelectrodosexp
				borraListaElectrodosExpVDD();
			}
			this.getListaelectrodosexp().add(this.getListaelectrodos().get(this.bindingElec.getRowIndex()));
		}			
		this.getListaelectrodos().remove(this.bindingElec.getRowIndex());
		//actualizaListaElectrodos(this.bindingElec.getRowIndex());
		borraListaElectrodosVDD();	
		this.currentItemElectrodos = new ImpImplanteElectrodos();
		this.currentItemElectrodosBackUp = new ImpImplanteElectrodos();
	}

	public void addComplicacionIntra(ActionEvent e) {
		this.getListacomplicacionesintra().add(new ImpHojaImplanteComplicacion());
	}

	public void delComplicacionIntra(ActionEvent e) {
		this.getListacomplicacionesintra().remove(this.bindingCompliIntra.getRowIndex());
	}

	public void addComplicacionPost(ActionEvent e) {
		this.getListacomplicacionespost().add(new ImpEvolucionComplicacion());
	}

	public void delComplicacionPost(ActionEvent e) {
		this.getListacomplicacionespost().remove(this.bindingCompliPost.getRowIndex());
	}

	public void addZona(ActionEvent e) {
		// Se permite la carga desde TV1.. TV5 y FV
		// Orden de carga: FV -> TV1 -> TV2 ->...->TV5
		if (this.hev.getZonas().size() == 0)
			this.hev.getZonas().add(new ImpZona("FV"));
		else if ((this.hev.getZonas().size() >= 1)
				&& (this.hev.getZonas().size() < 6))
			this.hev.getZonas().add(0, new ImpZona("TVn"));
	}

	public void delZona(ActionEvent e) {
		if (this.getBindingGrid().getRowIndex() != this.hev.getZonas().size() - 1
				|| this.hev.getZonas().size() == 1) {
			this.hev.getZonas().remove(this.getBindingGrid().getRowIndex());
			actualizaTipoZona();
		}
	}

	public void addSintoma(ActionEvent e) {
		this.hind.getSintomas().add(new SintomasSitclinProc());
	}

	public void delSintoma(ActionEvent e) {
		this.hind.getSintomas().remove(this.bindingSintomas.getRowIndex());
	}
	
	public void controlSintomas(ActionEvent e){
		//this.setSintomasDuplicados(false);
		int dup=0;
		for(SintomasSitclinProc s:this.hind.getSintomas()){
			if(s.getIdsintomas()!=null && s.getIdsintomas().equals(this.hind.getSintomas().get(this.bindingSintomas.getRowIndex()).getIdsintomas())){
				dup++;		
			}	
			if(dup>1){
				// Duplicado
				this.hind.getSintomas().remove(this.bindingSintomas.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sitclin_sintoma_dup"));
				break;
			}
		}
	}

	public void addEnf(ActionEvent e) {
		this.himp.getEnfermeras().add(new ImpHojaImplanteEnf());
	}

	public void delEnf(ActionEvent e) {
		this.himp.getEnfermeras().remove(this.binEnf.getRowIndex());
	}

	public void editEnf(ActionEvent e) {
		this.himp.getEnfermeras().get(this.binEnf.getRowIndex()).setLectura(this.himp.getEnfermeras().get(this.binEnf.getRowIndex()).getLectura()==1?0:1);
	}

	public void controlEnf(ActionEvent e){
		int dup=0;
		for(ImpHojaImplanteEnf s:this.himp.getEnfermeras()){
			if(s.getIdenf().equals(this.himp.getEnfermeras().get(this.binEnf.getRowIndex()).getIdenf()))
				dup++;			
			if(dup>1){
				// Duplicado
				this.himp.getEnfermeras().remove(this.binEnf.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_enf_dupl"));
				break;
			}
		}
	}

	public void addPop(ActionEvent e) {
		this.himp.getPoperador().add(new ImpHojaImplantePop());
	}

	public void delPop(ActionEvent e) {
		this.himp.getPoperador().remove(this.binPop.getRowIndex());
	}

	public void editPop(ActionEvent e) {
		this.himp.getPoperador().get(this.binPop.getRowIndex()).setLectura(this.himp.getPoperador().get(this.binPop.getRowIndex()).getLectura()==1?0:1);
	}

	public void controlPop(ActionEvent e){
		int dup=0;
		for(ImpHojaImplantePop s:this.himp.getPoperador()){
			if(s.getIdop().equals(this.himp.getPoperador().get(this.binPop.getRowIndex()).getIdop()))
				dup++;			
			if(dup>1){
				// Duplicado
				this.himp.getPoperador().remove(this.binPop.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_pop_dupl"));
				break;
			}
		}
	}

	public void addSop(ActionEvent e) {
		this.himp.getSoperador().add(new ImpHojaImplanteSop());
	}

	public void delSop(ActionEvent e) {
		this.himp.getSoperador().remove(this.binSop.getRowIndex());
	}

	public void editSop(ActionEvent e) {
		this.himp.getSoperador().get(this.binSop.getRowIndex()).setLectura(this.himp.getSoperador().get(this.binSop.getRowIndex()).getLectura()==1?0:1);
	}

	public void controlSop(ActionEvent e){
		int dup=0;
		for(ImpHojaImplanteSop s:this.himp.getSoperador()){
			if(s.getIdop().equals(this.himp.getSoperador().get(this.binSop.getRowIndex()).getIdop()))
				dup++;			
			if(dup>1){
				// Duplicado
				this.himp.getSoperador().remove(this.binSop.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sop_dupl"));
				break;
			}
		}
	}
	public void controlCompIntra(ActionEvent e){
		int dup=0;
		for(ImpHojaImplanteComplicacion s:this.listacomplicacionesintra){
			if(s.getIdcompl() == this.listacomplicacionesintra.get(this.bindingCompliIntra.getRowIndex()).getIdcompl())
				dup++;
			if(dup>1){
				// Duplicado
				this.listacomplicacionesintra.remove(this.bindingCompliIntra.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_dupl"));
				break;
			}
		}
	}	
	public void controlCompIntraTipo(ActionEvent e){
		int dup_otra=0;
		for(ImpHojaImplanteComplicacion s:this.listacomplicacionesintra){
			if(s.getTipocomp()!=null && s.getTipocomp().equals("972")){
				dup_otra++;
			}
			if(dup_otra>1){
				// Dulpicado otra
				this.listacomplicacionesintra.remove(this.bindingCompliIntra.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_dupl"));
				break;
			}
		}
	}
	public void controlCompPost(ActionEvent e){
		int dup=0;
		for(ImpEvolucionComplicacion s:this.listacomplicacionespost){
			if(s.getIdcompl() == this.listacomplicacionespost.get(this.bindingCompliPost.getRowIndex()).getIdcompl())
				dup++;
			if(dup>1){
				// Duplicado
				this.listacomplicacionespost.remove(this.bindingCompliPost.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_dupl"));
				break;
			}
		}
	}
	public void controlCompPostTipo(ActionEvent e){
		int dup_otra=0;
		for(ImpEvolucionComplicacion s:this.listacomplicacionespost){
			if(s.getTipocomp()!=null && s.getTipocomp().equals("978")){
				dup_otra++;
			}
			if(dup_otra>1){
				// Dulpicado otra
				this.listacomplicacionespost.remove(this.bindingCompliPost.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_dupl"));
				break;
			}
		}
	}

	public void componerTextoAbordaje(ActionEvent e) {

	}
	public void lecturaCodigoBarrasGenerador(ActionEvent e) {
		try {
			if(this.listagenerador.size()>0){
				this.setUsaLector(true);
				this.g = new GeneradorDaoImpl();
				// Tratamiento de codigo GS1-128 
				this.setLineanuevogen(this.getBindingGen().getRowIndex());// indice para insertar nuevo
				int tipoGenPrev = this.getTipogen();
				ArrayList<String> lecturas = GestorCodigoBarras.lectura(this.listagenerador.get(this.getBindingGen().getRowIndex()).getBarcode());
				// Busqueda en tabla: codigogs128 y recuperar generador
				Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("TIPO = ? AND CODIGO = ?", new Object[]{1,lecturas.get(0)});
				Generador gen = null;
				if(codigos!=null && codigos.length>0)
					gen = this.g.findByPrimaryKey(codigos[0].getIdmaterial());
				
				if(gen!=null /*gen.length>0*/){
					this.setTipogen(Integer.valueOf(gen.getTipo()));
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setIdgenerador(gen.getIdgenerador());
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setNombremodelo(gen.getModelo());
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setModelo(String.valueOf(gen.getIdgenerador()));
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setModo(gen.getModo()!=null?gen.getModo():"");
					//this.listagenerador.get(this.getBindingGen().getRowIndex()).setNumserie(numserie);
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setNumserie(lecturas.get(1));
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setFabricante(gen.getFabricante()!=null?gen.getFabricante():"");
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setMuestrabarcode(false);
					if(gen.getRf()!=null)
						if (gen.getRf() == 1)
							this.listagenerador.get(this.getBindingGen().getRowIndex()).setRf("Si");
						else
							this.listagenerador.get(this.getBindingGen().getRowIndex()).setRf("No");
					else
						this.listagenerador.get(this.getBindingGen().getRowIndex()).setRf("");
					if(gen.getMri()!=null)
						if (gen.getMri() == 1)
							this.listagenerador.get(this.getBindingGen().getRowIndex()).setMricomp("Si");
						else
							this.listagenerador.get(this.getBindingGen().getRowIndex()).setMricomp("No");
					else
						this.listagenerador.get(this.getBindingGen().getRowIndex()).setMricomp("");
					
					this.setRecambioGen(true);
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setBarcode("");
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setMuestrabarcode(false);
					// LEADLESS 
					// Se eliminar el sistema de electrodos actual y se mete uno virtual
					// Se asigna el mismo num.serie del generador al electrodo virtual
					if(this.getTipogen()==5){
						if(tipoGenPrev!=5 && tipoGenPrev!=0){
							// hay que meter todos los electrodos previos en listaelectrodosexp
							for(ImpImplanteElectrodos el:this.listaelectrodos)
								this.listaelectrodosexp.add(el);
						}
						this.listaelectrodos.clear();
						this.listaelectrodos.add(new ImpImplanteElectrodos());
						this.listaelectrodos.get(0).setNumserie(this.listagenerador.get(this.getBindingGen().getRowIndex()).getNumserie());
						this.listaelectrodos.get(0).setCamara(0);
						this.listaelectrodos.get(0).setIdelectrodo(IDVIRTUAL);// se asigna el electrodo virtual
						this.listaelectrodos.get(0).setNombremodelo("VIRTUAL");
					}
					if(this.getTipogen()==6){
						// Verifica que no exista un electrodo S-ICD. Si no lo encuentra en el sistema de electrodos, lo incluye. Si lo encuentra, no hace nada
						if(!existeElectrodoSICD()){
							if(tipoGenPrev!=0)// en primoimplantes siempre hay un item de electrodo precargado
								this.listaelectrodos.add(new ImpImplanteElectrodos());
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setIdelectrodo(IDSICD.getIdelectrodo());// se asigna el electrodo SCID
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setCamara(-1);
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setNombremodelo(IDSICD.getModelo());
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setBarcode("");
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setConector(IDSICD.getConector());
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setFabricante(IDSICD.getFabricante());
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setVdd(false);
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setMuestrabarcode(false);
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setLateralidad(951);
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setZonacamara(IDZONA_SICD);
							this.listaelectrodos.get(this.listaelectrodos.size()-1).setEstado(0);
							this.componerNombreAbordaje(this.listaelectrodos.get(this.listaelectrodos.size()-1));
						}
						// Marcar por defecto test de induccion
						this.himp.setTesti(true);
						this.testIndHojaImp(null);
					}
					// LEADLESS 2. Si previamente es LEADLESS y se cambia por otro tipo de generador, se quita el electrodo virtual
					if(tipoGenPrev==5 && !(Integer.valueOf(gen.getTipo()).equals(5))){
						this.listaelectrodosexp.add(this.listaelectrodos.get(0));// se incluye el leadless en la lista de explantados para tareas de actualizacion
						this.listaelectrodos.clear();
						this.listaelectrodospk.clear();			
					}
					// SCID - EXPLANTES. Habría que hacer una explantación concreta del electrodo. Por eso no lo quitamos como el LEADLESS
				}else{
					this.listagenerador.get(this.getBindingGen().getRowIndex()).setBarcode("");
					this.nuevogen.setGs128(lecturas.get(0));
					this.setNgen(true); // variable de apertura de modalPanel
					this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("mat_mag_warn_consulta_vacia"));		
				}					
			}
			else
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("imp_dispositivos_msg_warn_add_gen"));
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
			this.listagenerador.get(this.getBindingGen().getRowIndex()).setBarcode("");
			
		}
	}
	
	public void cambiaModeloGen2(ActionEvent e) {
		String modgen = this.listagenerador.get(this.getBindingGen().getRowIndex()).getNombremodelo();
		int gen=0;
		try {
			gen = this.g.findWhereModeloEquals(modgen)[0].getIdgenerador();
		} catch (Exception e1) {
			e1.printStackTrace();
			this.listagenerador.get(this.getBindingGen().getRowIndex()).setIdgenerador(0);
			this.listagenerador.get(this.getBindingGen().getRowIndex()).setNombremodelo("");
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_consulta_gen"));
		}
		int tipoGenPrev = this.getTipogen();
		if (gen > 0) {
			Generador aux = null;
			try{
				aux = this.g.findByPrimaryKey(gen);
			}catch(Exception ex){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_consulta_gen"));
			}
			// Precarga valores asociados al modelo del generador en el objeto
			// HojaImplante
			this.setTipogen(Integer.valueOf(aux.getTipo()));
			
			if(esUpgrade(tipoGenPrev,this.modogenini,aux))
				this.setUpgrade(true);
			else
				this.setUpgrade(false);
			
			this.modogenini = aux.getModo();//Actualiza variable modogen ini para comprobacion de upgrade;
			this.listagenerador.get(this.getBindingGen().getRowIndex()).setIdgenerador(aux.getIdgenerador());
			this.listagenerador.get(this.getBindingGen().getRowIndex()).setModo(aux.getModo());
			this.listagenerador.get(this.getBindingGen().getRowIndex()).setNombremodelo(aux.getModelo());
			this.listagenerador.get(this.getBindingGen().getRowIndex()).setFabricante(aux.getFabricante()!=null?aux.getFabricante():"");
			this.listagenerador.get(this.getBindingGen().getRowIndex()).setMuestrabarcode(false);
			if (aux.getRf()!=null && aux.getRf() == 1)
				this.listagenerador.get(this.getBindingGen().getRowIndex()).setRf("Si");
			else
				this.listagenerador.get(this.getBindingGen().getRowIndex()).setRf("No");

			if (aux.getMri()!=null && aux.getMri() == 1)
				this.listagenerador.get(this.getBindingGen().getRowIndex()).setMricomp("Si");
			else
				this.listagenerador.get(this.getBindingGen().getRowIndex()).setMricomp("No");
			this.setRecambioGen(true);
			this.cambioGen = true;
			// CONTROL DE MP LEADLESS TIPO = 5
			if(Integer.valueOf(aux.getTipo()).equals(5)){
				if(tipoGenPrev!=5 && tipoGenPrev!=0){
					// hay que meter todos los electrodos previos en listaelectrodosexp
					for(ImpImplanteElectrodos el:this.listaelectrodos)
						this.listaelectrodosexp.add(el);
				}
				this.listaelectrodos.clear();// validar
				ImpImplanteElectrodos el_virtual = new ImpImplanteElectrodos();
				// Buscar el id del electrodo virtual
				el_virtual.setIdelectrodo(IDVIRTUAL);// se asigna el electrodo virtual
				el_virtual.setNombremodelo("VIRTUAL");
				el_virtual.setNumserie(this.listagenerador.get(this.getBindingGen().getRowIndex()).getNumserie());
				el_virtual.setCamara(0);// leadless
				this.listaelectrodos.add(el_virtual);
			}
			if(this.getTipogen()==6){
				// Verifica que no exista un electrodo S-ICD. Si no lo encuentra en el sistema de electrodos, lo incluye. Si lo encuentra, no hace nada
				if(!existeElectrodoSICD()){
					if(tipoGenPrev!=0)// en primoimplantes siempre hay un item de electrodo precargado
						this.listaelectrodos.add(new ImpImplanteElectrodos());
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setIdelectrodo(IDSICD.getIdelectrodo());// se asigna el electrodo SCID
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setCamara(-1);
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setNombremodelo(IDSICD.getModelo());
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setBarcode("");
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setConector(IDSICD.getConector());
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setFabricante(IDSICD.getFabricante());
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setVdd(false);
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setMuestrabarcode(false);
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setLateralidad(951);
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setZonacamara(IDZONA_SICD);
					this.listaelectrodos.get(this.listaelectrodos.size()-1).setEstado(0);
					this.componerNombreAbordaje(this.listaelectrodos.get(this.listaelectrodos.size()-1));
				}
				// Marcar por defecto test de induccion
				this.himp.setTesti(true);
				this.testIndHojaImp(null);
			}
			// LEADLESS 2. Si previamente es LEADLESS y se cambia por otro tipo de generador, se quita el electrodo virtual
			if(tipoGenPrev==5 && !(Integer.valueOf(aux.getTipo()).equals(5))){
				this.listaelectrodosexp.add(this.listaelectrodos.get(0));// se incluye el leadless en la lista de explantados para tareas de actualizacion
				this.listaelectrodos.clear();
				this.listaelectrodospk.clear();			
			}				
		}
	}
	
	public boolean existeElectrodoSICD(){
		for(ImpImplanteElectrodos e:this.listaelectrodos)
			if(e.getIdelectrodo()!=null && e.getIdelectrodo().equals(IDSICD.getIdelectrodo())&& e.getEstado()!=null && e.getEstado()==0)
				return true;
		return false;
	}
	
	public boolean esUpgrade(int prevgen,String modogenprev, Generador actgen){
		// 1. Comprobacion por cambio de dispositivo
		int tipogenact = Integer.parseInt(actgen.getTipo());
		if(prevgen<tipogenact)
			return true;
		else if(prevgen==tipogenact){// comprobacion de modos de fabrica
			if(modogenprev!=null && (modogenprev.startsWith("TRICAMERAL") || modogenprev.startsWith("CRT")||modogenprev.startsWith("DDDRV")))
				return false;
			else if(modogenprev!=null && (modogenprev.startsWith("DDD") && (actgen.getModo().startsWith("TRICAMERAL")||actgen.getModo().startsWith("CRT")||modogenprev.startsWith("DDDRV"))))
				return true;
			else if( modogenprev!=null && (modogenprev.startsWith("VDD") && (actgen.getModo().startsWith("TRICAMERAL")||actgen.getModo().startsWith("CRT")||modogenprev.startsWith("DDDRV")
					||actgen.getModo().startsWith("DDD"))))	
				return true;
			else if(modogenprev!=null &&(modogenprev.startsWith("VVI")||modogenprev.startsWith("AAI")||modogenprev.startsWith("AAI"))
					&& (actgen.getModo().startsWith("TRICAMERAL")||actgen.getModo().startsWith("CRT")||modogenprev.startsWith("DDDRV")
							|| actgen.getModo().startsWith("DDD") || actgen.getModo().startsWith("VDD")))
				return true;
			else
				return false;
		}else{// Downgrade -> Recambio
			return false;
		}	
	}
	public void lecturaNumeroSerieGen(ActionEvent e){
		ArrayList<String> lecturas = GestorCodigoBarras.lectura(this.listagenerador.get(this.getBindingGen().getRowIndex()).getNumserie());
		if(lecturas.get(1)!=null)
			this.listagenerador.get(this.getBindingGen().getRowIndex()).setNumserie(lecturas.get(1));	
		if(this.getTipogen()==5)// MP LEADLESS - Asigna el numero de serie del generador al electrodo virtual
			this.listaelectrodos.get(0).setNumserie(this.listagenerador.get(this.getBindingGen().getRowIndex()).getNumserie());
		this.cambioGen = true;
	}
	
	public void delNumSerieGen(ActionEvent e){
		this.listagenerador.get(this.getBindingGen().getRowIndex()).setNumserie(null);
	}
	
	public void lecturaCodigoBarrasElectrodo(ActionEvent e){
		try{
			if(this.listaelectrodos.size()>0){
				this.e = new ElectrodosDaoImpl();
				this.setLineanuevoelec(this.getBindingElec().getRowIndex());// indice para insertar nuevo
				ArrayList<String> lecturas = GestorCodigoBarras.lectura(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getBarcode());								
				Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("TIPO = ? AND CODIGO = ?", new Object[]{2,lecturas.get(0)});
				Electrodos els = null;
				if(codigos!=null && codigos.length>0)
					els = this.e.findByPrimaryKey(codigos[0].getIdmaterial());
					
				if(els!=null /*els.length>0*/){
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setNombremodelo(els.getModelo());
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setIdelectrodo(els.getIdelectrodo());
					//this.listaelectrodos.get(this.bindingElec.getRowIndex()).setNumserie(numserie);
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setNumserie(lecturas.get(1));
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setBarcode("");
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setMuestrabarcode(false);
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setConector(els.getConector()!=null?els.getConector():"");
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setFabricante(els.getFabricante()!=null?els.getFabricante():"");
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setVdd(false); // inicialmente false. Si luego se verifica que es VDD, se pasa a true
					// Control SICD
					if(els.getConector()!=null && els.getConector().equals("SQ1"))
						this.listaelectrodos.get(this.bindingElec.getRowIndex()).setCamara(-1);
					// Control VDD - Solo deja meterlo si NO existe uno previo o hay abandonados o explantados parcialmente
					if(els.getConector()!=null && els.getConector().equals("IS-1 BIF") ){
						if(!existeElectrodoVDD()){
							this.listaelectrodos.get(this.bindingElec.getRowIndex()).setVdd(true);
							ImpImplanteElectrodos ad = new ImpImplanteElectrodos();
							ad.setNombremodelo(els.getModelo()+"(Auricular)");
							ad.setIdelectrodo(els.getIdelectrodo());
							ad.setNumserie(lecturas.get(1));
							ad.setBarcode("");
							ad.setMuestrabarcode(false);
							ad.setConector(els.getConector()!=null?els.getConector():"");
							ad.setFabricante(els.getFabricante()!=null?els.getFabricante():"");
							//ad.setTipoelectrodo(String.valueOf(els[0].getIdelectrodo())+"-"+lecturas.get(1));
							ad.setTipoelectrodo("VDD");
							ad.setCamara(948);//Auricular
							ad.setVdd(true);
							this.listaelectrodos.add(ad);
						}else{
							this.listaelectrodos.remove(this.bindingElec.getRowIndex());
							this.pintaMensaje(AVISO, this.bundle.getString("imp_dispositivos_msg_warn_vdd_previo"));
						}					
					}else
						actualizaListaElectrodosVDD(this.bindingElec.getRowIndex());
				}else{
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("no_coincidencias_sistema"));
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setBarcode("");
					this.setNelec(true);
					this.nuevoelec.setGs128(lecturas.get(0));
				}
					
			}else
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("imp_dispositivos_msg_warn_add_elec"));
		}catch(Exception e1){
			this.listaelectrodos.get(this.bindingElec.getRowIndex()).setBarcode("");
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}
	
	public void lecturaNumeroSerieElectrodo(ActionEvent e){
		ArrayList<String> lecturas = GestorCodigoBarras.lectura(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getNumserie());
		if(lecturas.get(1)!=null)
			this.listaelectrodos.get(this.bindingElec.getRowIndex()).setNumserie(lecturas.get(1));
		// Control VDD -  Hay que buscar el electrodo auricular asociado y asignarle el numero de serie. Electrodo adyacente en lista
		if(this.listaelectrodos.get(this.bindingElec.getRowIndex()).isVdd()){
			for(ImpImplanteElectrodos el:this.listaelectrodos){
				if(el.isVdd() && el.getEstado().equals(0)){
					el.setNumserie(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getNumserie());
				}
			}
		}
	}
	
	public void delNumSerieElec(ActionEvent e){
		this.listaelectrodos.get(this.bindingElec.getRowIndex()).setNumserie(null);
		// Control VDD - Hay que buscar el electrodo auuricular asociado y asignarle el numero de serie. Electrodo adyacente en lista
		if(this.listaelectrodos.get(this.bindingElec.getRowIndex()).isVdd()){
			for(ImpImplanteElectrodos el:this.listaelectrodos){
				if(el.isVdd() && el.getEstado().equals(0)){
					el.setNumserie(null);
				}
			}
		}
	}
	
	public void cambiaCamaraElectrodo(ActionEvent e){
		this.currentItemElectrodos.setVia(IDVIA);
		this.currentItemElectrodos.setLateralidad(IDLATERALIDAD);
		if(this.currentItemElectrodos.getCamara().equals(948)){//AD
			this.currentItemElectrodos.setZonacamara(IDZONA_AD);
		}else if(this.currentItemElectrodos.getCamara().equals(949)){//VD
			this.currentItemElectrodos.setZonacamara(IDZONA_VD);
		}
	}

	public void lecturaElectrodo2(ActionEvent e){
		try{
			//Electrodos[] els = this.e.findWhereIdelectrodoEquals(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getIdelectrodo());
			Electrodos[] els = this.e.findWhereModeloEquals(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getNombremodelo());
			if(els.length>0){
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setNombremodelo(els[0].getModelo());
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setIdelectrodo(els[0].getIdelectrodo());
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setBarcode("");
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setMuestrabarcode(false);
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setConector(els[0].getConector()!=null?els[0].getConector():"");
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setFabricante(els[0].getFabricante()!=null?els[0].getFabricante():"");
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setVdd(false); // inicialmente false. Si luego se verifica que es VDD, se pasa a true
				// Control SICD
				if(els[0].getConector()!=null && els[0].getConector().equals("SQ1"))
					this.listaelectrodos.get(this.bindingElec.getRowIndex()).setCamara(-1);
				// Control VDD - Solo deja meterlo si NO existe uno previo o hay abandonados o explantados parcialmente
				if(els[0].getConector()!=null && els[0].getConector().equals("IS-1 BIF") ){
					if(!existeElectrodoVDD()){
						this.listaelectrodos.get(this.bindingElec.getRowIndex()).setVdd(true);
						// Se impone que el VDD- VD sea VD
						this.listaelectrodos.get(this.bindingElec.getRowIndex()).setCamara(949);
						this.listaelectrodos.get(this.bindingElec.getRowIndex()).setVia(this.IDVIA);
						this.listaelectrodos.get(this.bindingElec.getRowIndex()).setLateralidad(IDLATERALIDAD);
						this.listaelectrodos.get(this.bindingElec.getRowIndex()).setZonacamara(IDZONA_VD);
						ImpImplanteElectrodos ad = new ImpImplanteElectrodos();
						ad.setNombremodelo(els[0].getModelo()+"(Auricular)");
						ad.setIdelectrodo(els[0].getIdelectrodo());
						//ad.setNumserie(null);
						ad.setNumserie(this.listaelectrodos.get(this.bindingElec.getRowIndex()).getNumserie());
						ad.setBarcode("");
						ad.setMuestrabarcode(false);
						ad.setConector(els[0].getConector()!=null?els[0].getConector():"");
						ad.setFabricante(els[0].getFabricante()!=null?els[0].getFabricante():"");
						//ad.setTipoelectrodo(String.valueOf(els[0].getIdelectrodo())+"-");
						ad.setTipoelectrodo("VDD");
						ad.setCamara(948);//Auricular
						ad.setVdd(true);
						this.listaelectrodos.add(ad);
					}else{
						this.listaelectrodos.remove(this.bindingElec.getRowIndex());
						this.pintaMensaje(AVISO, this.bundle.getString("imp_dispositivos_msg_warn_vdd_previo"));
					}					
				}else
					actualizaListaElectrodosVDD(this.bindingElec.getRowIndex());											
			}else{
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setIdelectrodo(0);
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setBarcode("");
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setNombremodelo("");
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setConector("");
				this.listaelectrodos.get(this.bindingElec.getRowIndex()).setFabricante("");
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_mag_warn_consulta_vacia"));
				
			}
		}catch(Exception ex){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ ex.getMessage());
		}
	}

	public void actualizaListaElectrodos(int pos){
		ArrayList<Integer> ids = new ArrayList<Integer>();
		for(int i=0;i<this.listaelectrodos.size();i++){			
			if(this.listaelectrodos.get(i).getTipoelectrodo()!=null){
				String[] id_str = this.listaelectrodos.get(i).getTipoelectrodo().split("-");
				Integer id = Integer.parseInt(id_str[0]);
				for(int j=0;j<this.listaelectrodos.size();j++){
					if(this.listaelectrodos.get(j).getIdelectrodo().equals(id) && j==pos){// Solo se introduce si coinciden y es el electrodo modificado o borrado
						ids.add(i);
						break;
					}	
				}
			}
		}
		for(int i:ids)
			this.listaelectrodos.remove(i);
	}
	
	public void actualizaListaElectrodosVDD(int pos){
		int cont = 0, posi =0;
		for(int i=0;i<this.listaelectrodos.size();i++){
			if(this.listaelectrodos.get(i).isVdd() && this.listaelectrodos.get(i).getEstado().equals(0)){
				posi = i;
				cont++;
			}		
		}
		if(cont>0 && cont<2){
			//this.updateremovead = new ImpImplanteElectrodos();
			// Se marca apuntando al AD que se elimina del VDD para en UPDATE eliminarlo de BD
			//this.updateremovead.setIdimpelectrodos(this.listaelectrodos.get(posi).getIdimpelectrodos());
			// si es update se mete el AD-VDD en listaelectrodosexp para borrarlo luego
			if(this.impl.getIdimplante()!=null)
				this.listaelectrodosexp.add(this.listaelectrodos.get(posi));
			this.listaelectrodos.remove(posi);
		}
			
	}
	
	public void borraListaElectrodosVDD(){
		int cont = 0, posi =0;
		for(int i=0;i<this.listaelectrodos.size();i++){
			if(this.listaelectrodos.get(i).isVdd() && this.listaelectrodos.get(i).getEstado().equals(0)){
				posi = i;
				cont++;
			}		
		}
		if(cont>0 && cont<2 && this.listaelectrodos.get(posi).isVdd())
			this.listaelectrodos.remove(posi);
	}
	
	public void borraListaElectrodosExpVDD(){
		for(int i=0;i<this.listaelectrodos.size();i++){
			if(this.listaelectrodos.get(i).isVdd() && this.listaelectrodos.get(i).getEstado().equals(0) && this.listaelectrodos.get(i).getCamara().equals(948)){
				this.listaelectrodosexp.add(this.listaelectrodos.get(i));
				this.listaelectrodos.remove(i);	
			}		
		}
	}
	
	public boolean existeElectrodoVDD(){
		for(ImpImplanteElectrodos e:this.listaelectrodos)
			if(e.isVdd() && (e.getEstado().equals(0)))
				return true;
		return false;
	}
	
	public void cambiaLocalizacionGen(ActionEvent e) {
		if (this.listageneradorexp.size() <= 0)
			this.setRecolocacionGen(true);
	}

	public void cargaATPZona(ActionEvent e) {
		int prev = this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().size();
		int act = Integer.parseInt(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getNumatpini());
		if (act > prev) {// Añade tantos como la diferencia entre ambos
			for (int i = 0; i < (act - prev); i++) {
				this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().add(new ImpAtp("ATP" + String.valueOf(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().size() + 1)));
			}
		} else if (act < prev) {// Elimina tantos como la diferencia entre ambos
			for (int i = 0; i < (prev - act); i++) {
				this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().remove(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().size() - 1);
			}
		}
	}

	/**
	 * Metodo para ordenar la tabla zonas cuando se produce una nueva insercion
	 * en la misma
	 * 
	 * @param e
	 */
	public void gestionaZona(ActionEvent e) {
		// Validar formato de numero adecuado
		try {
			int fc = Integer.valueOf(this.hev.getZonas()
					.get(this.getBindingGrid().getRowIndex()).getFcPpm());
			this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).setFcMs(String.valueOf(60000 / fc));
			
			for (int i = 0; i < this.hev.getZonas().size(); i++) {
				if (Integer.valueOf(this.hev.getZonas().get(i).getFcPpm()) > fc) {
					// en este punto, se elimina la posicion escogida (que es la que hay que reubicar)
					// y se coloca en la posicion i. Con el shift, la superior corre a la derecha
					ImpZona aux = this.hev.getZonas().get(this.getBindingGrid().getRowIndex());
					aux.setTipo("TV" + String.valueOf(i));
					this.hev.getZonas().add(i, aux);
					// eliminar la posicion escogida previa
					if (this.getBindingGrid().getRowIndex() == 0 || this.getBindingGrid().getRowIndex() < i)
						this.hev.getZonas().remove(this.getBindingGrid().getRowIndex());
					else if (this.getBindingGrid().getRowIndex() > i)
						this.hev.getZonas().remove(this.getBindingGrid().getRowIndex() + 1);
					actualizaTipoZona();
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}
	public void gestionaZonaMs(ActionEvent e) {
		// Validar formato de numero adecuado
		try {
			int fc = Integer.valueOf(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getFcMs());
			this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).setFcPpm(String.valueOf(60000 / fc));
			
			for (int i = 0; i < this.hev.getZonas().size(); i++) {
				if (Integer.valueOf(this.hev.getZonas().get(i).getFcMs()) < fc) {
					// en este punto, se elimina la posicion escogida (que es la que hay que reubicar)
					// y se coloca en la posicion i. Con el shift, la superior corre a la derecha
					ImpZona aux = this.hev.getZonas().get(this.getBindingGrid().getRowIndex());
					aux.setTipo("TV" + String.valueOf(i));
					this.hev.getZonas().add(i, aux);
					// eliminar la posicion escogida previa
					if (this.getBindingGrid().getRowIndex() == 0 || this.getBindingGrid().getRowIndex() < i)
						this.hev.getZonas().remove(this.getBindingGrid().getRowIndex());
					else if (this.getBindingGrid().getRowIndex() > i)
						this.hev.getZonas().remove(this.getBindingGrid().getRowIndex() + 1);
					actualizaTipoZona();
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
	}

	private void actualizaTipoZona() {
		for (int i = 0; i < this.hev.getZonas().size() - 1; i++) {
			this.hev.getZonas().get(i).setTipo("TV" + String.valueOf(i + 1));
		}
	}

	public void addChoque(ActionEvent e) {
		// condiciones: no mas de 8 choques. Energia minima siempre primero en la lista
		if (numeroChoquesZona(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs()) < 8)
			this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().add(new ImpChoques("1"));
		else
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_add_choques"));
	}

	public void delChoque(ActionEvent e) {
		this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().remove(this.bindingChoques.getRowIndex());
	}

	public void cambiaNumeroChoques(ActionEvent e) {
		int numchqact = numeroChoquesZona(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs());
		if (numchqact > 8) {
			this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().get(this.bindingChoques.getRowIndex()).setNumch("0");
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_add_choques"));
		}
	}

	private int numeroChoquesZona(ArrayList<ImpChoques> lst) {
		try {
			int r = 0;
			for (ImpChoques ch : lst)
				r = r + Integer.valueOf(ch.getNumch());
			return r;
		} catch (Exception e) {
			return -1;
		}
	}

	// PENDIENTE
	public void cambiaEnergiaChoques(ActionEvent e) {
		int enact = Integer.valueOf(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().get(this.bindingChoques.getRowIndex()).getEnergia());
		//System.out.println(this.bindingChoques.getRowIndex());
		for (int i = 0; i < this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().size(); i++) {
			if (Integer.valueOf(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().get(i).getEnergia()) > enact) {
				ImpChoques aux = this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().get(this.bindingChoques.getRowIndex());
				this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().add(i, aux);
				//System.out.println("i" + i + "RowIndex" + this.bindingChoques.getRowIndex());
				if (this.bindingChoques.getRowIndex() == 0)
					this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().remove(this.bindingChoques.getRowIndex());
				else if (this.bindingChoques.getRowIndex() < i)
					this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().remove(this.bindingChoques.getRowIndex());
				else if (this.bindingChoques.getRowIndex() > i)
					this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().remove(this.bindingChoques.getRowIndex() + 1);
				break;
			}
		}
		ImpChoques aux = this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().get(this.bindingChoques.getRowIndex());
		this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().add(aux);
		this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().remove(this.bindingChoques.getRowIndex());
	}

	public void cargarAvanzadosZona(ActionEvent e) {
		if (this.isAvzona())
			this.setAvzona(false);
		else
			this.setAvzona(true);
	}
	public void cargarModelosGenerador(ActionEvent e) {
		if (this.isModgen())
			this.setModgen(false);
		else
			this.setModgen(true);
	}
	public void cargarModelosElectrodos(ActionEvent e) {
		if (this.isModelec())
			this.setModelec(false);
		else
			this.setModelec(true);
	}

	public void controlNumEpisodios(ActionEvent e) {
		try {
			this.hev.setNumepitsv("0");
			this.hev.setNumepitv("0");
			this.hev.setNumepifv("0");
			this.hev.setNumepinosost("0");
			this.hev.setNumepiotros(this.hev.getNumepisodios());
		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_episodios"));
		}
	}

	public void cambiaNumEpisodios(ActionEvent e) {
		try {
			// Los items que esten vacios se ponen a 0. Los que no, a su valor
			// escrito
			if (this.hev.getNumepitsv() == null
					|| this.hev.getNumepitsv().length() == 0)
				this.hev.setNumepitsv("0");
			if (this.hev.getNumepitv() == null
					|| this.hev.getNumepitv().length() == 0)
				this.hev.setNumepitv("0");
			if (this.hev.getNumepifv() == null
					|| this.hev.getNumepifv().length() == 0)
				this.hev.setNumepifv("0");
			if (this.hev.getNumepinosost() == null
					|| this.hev.getNumepinosost().length() == 0)
				this.hev.setNumepinosost("0");
			if (this.hev.getNumepiotros() == null
					|| this.hev.getNumepiotros().length() == 0)
				this.hev.setNumepiotros("0");
			// Actualizacion de valores y calculo
			int total = 0;
			int tsv = (this.hev.getNumepitsv().length() > 0) ? Integer.parseInt(this.hev.getNumepitsv()) : 0;
			int tv = (this.hev.getNumepitv().length() > 0) ? Integer.parseInt(this.hev.getNumepitv()) : 0;
			int fv = (this.hev.getNumepifv().length() > 0) ? Integer.parseInt(this.hev.getNumepifv()) : 0;
			int nosos = (this.hev.getNumepinosost().length() > 0) ? Integer.parseInt(this.hev.getNumepinosost()) : 0;
			int otros = (this.hev.getNumepiotros().length() > 0) ? Integer.parseInt(this.hev.getNumepiotros()) : 0;
			total = total + tsv + tv + fv + nosos + otros;
			this.hev.setNumepisodios(String.valueOf(total));
		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_episodios"));
		}
	}
	public void ordenaFEVI(ActionEvent e){
		try{
			int fevi = Integer.valueOf(this.hind.getFevi());
			if(fevi>50)
				this.hind.setFuncionventricular(1);
			else if(fevi>=41 && fevi<=50)
				this.hind.setFuncionventricular(2);
			else if(fevi>=36 && fevi<=40)
				this.hind.setFuncionventricular(3);
			else if(fevi>=31 && fevi<=35)
				this.hind.setFuncionventricular(4);
			else
				this.hind.setFuncionventricular(5);
			this.modsitclin = true;
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_warn_sitclin_fe")+": " + e1.getMessage());
			this.hind.setFevi(null);
		}	
	}
	public void resetFEVI(ActionEvent e){
		this.modsitclin = true;
		this.hind.setFevi(null);
		if((this.hind.getFuncionventricular()==0 || this.hind.getFuncionventricular()==6)
				&& (this.getTipogen()==2 || this.getTipogen()==4))
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sitclin_fevi"));
	}
	

	private void preparaHoras() {
		if (this.himp.getHllegadah()!=null && !this.himp.getHllegadah().equals("")
				&& this.himp.getHllegadam()!=null &&!(this.himp.getHllegadam().equals("")))
			this.himp.setHllegada(UtilFechas.adaptaHoras(this.himp.getHllegadah())
					+ UtilFechas.adaptaHoras(this.himp.getHllegadam()));
		if (this.himp.getHinicioh()!=null && !this.himp.getHinicioh().equals("")
				&& this.himp.getHiniciom()!=null && !(this.himp.getHiniciom().equals("")))
			this.himp.setHinicio(UtilFechas.adaptaHoras(this.himp.getHinicioh())
					+ UtilFechas.adaptaHoras(this.himp.getHiniciom()));
		if (this.himp.getHfinh()!=null && !this.himp.getHfinh().equals("")
				&& this.himp.getHfinm()!=null && !(this.himp.getHfinm().equals("")))
			this.himp.setHfin(UtilFechas.adaptaHoras(this.himp.getHfinh()) 
					+ UtilFechas.adaptaHoras(this.himp.getHfinm()));
		if (this.himp.getHsalidah()!=null && !this.himp.getHsalidah().equals("")
				&& this.himp.getHsalidam()!=null && !(this.himp.getHsalidam().equals("")))
			this.himp.setHsalida(UtilFechas.adaptaHoras(this.himp.getHsalidah())
					+ UtilFechas.adaptaHoras(this.himp.getHsalidam()));
	}

	private void cargaHoras() {
		if (this.himp.getHllegada() != null) {
			this.himp.setHllegadah(this.himp.getHllegada().substring(0, 2));
			this.himp.setHllegadam(this.himp.getHllegada().substring(2, 4));
		}
		if (this.himp.getHinicio() != null) {
			this.himp.setHinicioh(this.himp.getHinicio().substring(0, 2));
			this.himp.setHiniciom(this.himp.getHinicio().substring(2, 4));
		}
		if (this.himp.getHfin() != null) {
			this.himp.setHfinh(this.himp.getHfin().substring(0, 2));
			this.himp.setHfinm(this.himp.getHfin().substring(2, 4));
		}
		if (this.himp.getHsalida() != null) {
			this.himp.setHsalidah(this.himp.getHsalida().substring(0, 2));
			this.himp.setHsalidam(this.himp.getHsalida().substring(2, 4));
		}
	}

	public void cambiaEtiologiaCardiopatia(ActionEvent e) {
		if (this.getHind().getEtiologia().equals(891))
			this.getHind().setCardiopatia(913);
		else if ((this.getHind().getEtiologia() > 891 && this.getHind()
				.getEtiologia() <= 894)
				|| (this.getHind().getEtiologia() > 897 && this.getHind()
						.getEtiologia() <= 904)
				|| this.getHind().getEtiologia().equals(911)
				|| this.getHind().getEtiologia().equals(912)
				|| this.getHind().getEtiologia().equals(905)
				|| this.getHind().getEtiologia().equals(908))
			this.getHind().setCardiopatia(923);
		else if (this.getHind().getEtiologia().equals(895)
				|| this.getHind().getEtiologia().equals(896))
			this.getHind().setCardiopatia(914);
		else if (this.getHind().getEtiologia().equals(897))
			this.getHind().setCardiopatia(919);
		else if (this.getHind().getEtiologia().equals(909)
				|| this.getHind().getEtiologia().equals(910))
			this.getHind().setCardiopatia(918);
		else if (this.getHind().getEtiologia().equals(906))
			this.getHind().setCardiopatia(916);
		else if (this.getHind().getEtiologia().equals(907))
			this.getHind().setCardiopatia(915);

	}

	public void cambiaCardiopatiaEtiologia(ActionEvent e) {
		if (!(this.getHind().getCardiopatia().equals(923))) {
			if (this.getHind().getCardiopatia().equals(913))
				this.getHind().setEtiologia(891);
			else if (this.getHind().getCardiopatia().equals(914))
				this.getHind().setEtiologia(895);
			else if (this.getHind().getCardiopatia().equals(915))
				this.getHind().setEtiologia(907);
			else if (this.getHind().getCardiopatia().equals(916))
				this.getHind().setEtiologia(906);
			else if (this.getHind().getCardiopatia().equals(917))
				this.getHind().setEtiologia(891);
			else if (this.getHind().getCardiopatia().equals(918))
				this.getHind().setEtiologia(909);
			else if (this.getHind().getCardiopatia().equals(919))
				this.getHind().setEtiologia(897);
			else if (this.getHind().getCardiopatia().equals(920)
					|| this.getHind().getCardiopatia().equals(921)
					|| this.getHind().getCardiopatia().equals(922))
				this.getHind().setEtiologia(892);
			else
				this.getHind().setEtiologia(891);
			this.getHind().setOtra("");	
		}
		this.modsitclin = true;
		this.sgen.setCardiop(this.hind.isCardiop());
		this.sgen.setCardiopatia(this.hind.getCardiopatia());
		this.sgen.setOtra(this.hind.getOtra());
	}

	public void cambiarAbordajeElectrodoCancelar(ActionEvent e) {
		this.currentItemElectrodos.setVia(this.currentItemElectrodosBackUp.getVia());
		this.currentItemElectrodos.setLateralidad(this.currentItemElectrodosBackUp.getLateralidad());
		this.currentItemElectrodos.setCamara(this.currentItemElectrodosBackUp.getCamara());
		this.currentItemElectrodos.setZonacamara(this.currentItemElectrodosBackUp.getZonacamara());
		this.currentItemElectrodos.setPorcion(this.currentItemElectrodosBackUp.getPorcion());
		this.currentItemElectrodos.setAbordajetexto(componerNombreAbordaje(this.currentItemElectrodos));
		this.setCurrentItemElectrodos(new ImpImplanteElectrodos());
	}

	public void cambiarAbordajeElectrodoIncluir(ActionEvent e) {
		//System.out.println(this.currentItemElectrodos.getEstado());
		this.currentItemElectrodos.setAbordajetexto(componerNombreAbordaje(this.currentItemElectrodos));
		if (!(this.isActualizacion()) && ((this.isPrevioimp()))){
			this.currentItemElectrodos.setCambiaabordaje(true);
			if(!this.currentItemElectrodos.isRecambio())
				this.setRecolocacion(true);
		}		
		this.setCurrentItemElectrodos(new ImpImplanteElectrodos());
	}

	private String componerNombreAbordaje(ImpImplanteElectrodos e) {
		String res = "";
		if(e.getConector()!=null && e.getConector().equals("SQ1")){
			if(e.getZonacamara()!=null)
				res = res + this.getNombreZonaCamara(e.getZonacamara())+ " ";
			if (e.getLateralidad() != null)
				res = res + this.getNombreLateralidad(e.getLateralidad());
			return res;
		} 
		if (e.getVia() != null) {
			res = res + this.getNombreVia(e.getVia()) + " ";
			if (e.getVia().equals(929)) {// EPICARDICO
				if (e.getZonacamara() != null)
					res = res + " mediante "
							+ (e.getZonacamara()==null?"":this.getNombreZonaCamara(e.getZonacamara()));
				if (e.getCamara() != null)
					res = res + " a " + this.getNombreCamara(e.getCamara());
			} else {
				if (e.getLateralidad() != null)
					res = res + this.getNombreLateralidad(e.getLateralidad())
							+ " ";
				if (e.getCamara() != null && e.getCamara() != 950 && e.getCamara()!=-1) // AD o VD
					res = res + "a "
							+ (e.getZonacamara()==null?"":this.getNombreZonaCamara(e.getZonacamara()))
							+ " de " + this.getNombreCamara(e.getCamara());
				else if (e.getCamara() != null && e.getCamara() == 950 && e.getCamara()!=-1)
					res = res + "a porcion "
							+ (e.getPorcion()==null?"":this.getNombrePorcion(e.getPorcion())) + " de "
							+ (e.getZonacamara()==null?"":this.getNombreZonaCamara(e.getZonacamara()))
							+ " de " + this.getNombreCamara(e.getCamara());
			}
		}
		return res;
	}

	private String getNombreVia(int id) {	
		for (ArrMaestras v : this.viaaccesoimplante) {
			if (v.getCodigo().equals(id)) {
				return v.getValor();
			}
		}
		return "";
	}

	private String getNombreLateralidad(int id) {
		for (ArrMaestras v : this.lateralidad) {
			if (v.getCodigo().equals(id)) {
				return v.getValor();
			}
		}
		return "";
	}

	private String getNombreZonaCamara(int id) {
		for (ArrMaestras v : this.zonacamaraad) {
			if (v.getCodigo().equals(id)) {
				return v.getValor();
			}
		}
		for (ArrMaestras v : this.zonacamaravd) {
			if (v.getCodigo().equals(id)) {
				return v.getValor();
			}
		}
		for (ArrMaestras v : this.zonacamaravi) {
			if (v.getCodigo().equals(id)) {
				return v.getValor();
			}
		}
		for (ArrMaestras v : this.zonaepicardico) {
			if (v.getCodigo().equals(id)) {
				return v.getValor();
			}
		}
		for (ArrMaestras v : this.zonacamarasicd) {
			if (v.getCodigo().equals(id)) {
				return v.getValor();
			}
		}
		return "";
	}

	private String getNombreCamara(int id) {
		for (ArrMaestras v : this.camara) {
			if (v.getCodigo().equals(id)) {
				return v.getValor();
			}
		}
		return "";
	}

	private String getNombrePorcion(int id) {
		for (ArrMaestras v : this.porcion) {
			if (v.getCodigo().equals(id)) {
				return v.getValor();
			}
		}
		return "";
	}

	public void accionesElectrodo(ActionEvent e) {
		/*
		 * A - Si explante parcial || extraccion parcial || abandono ->
		 * currentItem permanece en el sistema -> se actualiza el sistema actual
		 * (estado + caracter + motivo) -> cambiar aspecto de presentacion en
		 * tabla B - Si explante completo || extraccion completo -> currentItem
		 * se elimina del sistema -> se inserta en listaelectrodosexp
		 */
		// Control VDD
		if(this.getCurrentItemElectrodosEliminar().isVdd()){
			// buscar el auricular
			for(ImpImplanteElectrodos el:this.listaelectrodos){
				if(el.isVdd() && el.getCamara().equals(948)){
					el.setEstado(this.getCurrentItemElectrodosEliminar().getEstado());
					el.setCaracter(this.getCurrentItemElectrodosEliminar().getCaracter());
				}
			}
		}
		if (this.getCurrentItemElectrodosEliminar().getEstado() != 1
				&& this.getCurrentItemElectrodosEliminar().getCaracter() == 1) {
			// Caso B
			// 1. Modificar estado electrodo (estado + caracter + motivo) en
			// lista del sistema previo
			/*
			 * for(ImpImplanteElectrodos el:this.listaelectrodosexp){
			 * if(this.getCurrentItemElectrodos
			 * ().getIdaux().equals(el.getIdimpelectrodos())){
			 * el.setEstado(this.getCurrentItemElectrodos().getEstado());
			 * el.setCaracter(this.getCurrentItemElectrodos().getCaracter());
			 * el.
			 * setMotivoexaband(this.getCurrentItemElectrodos().getMotivoexaband
			 * ()); break; } }
			 */
			// 1. Insertar en lista electrodos explantados
			this.listaelectrodosexp.add(this.currentItemElectrodosEliminar);
			this.listaelectrodosexppk.add(this.currentItemElectrodosEliminar.createPk());
			// 2. Eliminar electrodo del sistema actual
			this.listaelectrodos.remove(this.currentItemElectrodosEliminar);
			// Actualizar estado de currentItemElectrodos
			// this.setCurrentItemElectrodos(new ImpImplanteElectrodos());
			
			// Control VDD - replicar estado al eletrodo auricular si existe
			if(this.getCurrentItemElectrodosEliminar().isVdd()){
				// buscar el auricular
				for(ImpImplanteElectrodos el:this.listaelectrodos){
					if(el.isVdd() && el.getCamara().equals(948)){
						this.listaelectrodosexp.add(el);
						this.listaelectrodosexppk.add(el.createPk());
						this.listaelectrodos.remove(el);
						break;
					}
				}
			}
		}
		this.setCurrentItemElectrodosEliminar(new ImpImplanteElectrodos());
		// Caso A
		// No hay que hacer nada ya que el evento actualiza la tabla
		// y el estado del electrodo se ha actualizado ya
	}

	public void accionesElectrodoCancelar(ActionEvent e) {
		this.currentItemElectrodosEliminar.setEstado(this.currentItemElectrodosEliminarBackUp.getEstado());
		this.currentItemElectrodosEliminar.setCaracter(this.currentItemElectrodosEliminarBackUp.getCaracter());
		this.currentItemElectrodosEliminar.setMotivoexaband(this.currentItemElectrodosEliminarBackUp.getMotivoexaband());
		this.setCurrentItemElectrodosEliminar(new ImpImplanteElectrodos());
		this.setCurrentItemElectrodosEliminarBackUp(new ImpImplanteElectrodos());
	}

	public void cambiarEstadoElectrodo(ActionEvent e) {
		if (this.getListaelectrodos().get(this.bindingElec.getRowIndex()).getEstado() == 2
				|| this.getListaelectrodos().get(this.bindingElec.getRowIndex()).getEstado() == 3)
			this.getListaelectrodos().get(this.bindingElec.getRowIndex()).setCaracter(2);
	}
	private boolean validaElectrodos(){
		for(ImpImplanteElectrodos e:this.listaelectrodos){
			if(e.getCamara()==null || e.getCamara()==0 && !(e.getIdelectrodo().equals(IDVIRTUAL)) && !(e.getIdelectrodo().equals(IDSICD.getIdelectrodo()))){
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("imp_dispositivos_msg_warn_add_elec_cam"));
				return false;
			}	
			else if(e.getIdelectrodo()==null||e.getIdelectrodo()==0){
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("imp_dispositivos_msg_warn_add_elec_mode"));
				return false;
			}				
			else if(e.getNumserie()==null || e.getNumserie().length()<=0){
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("imp_dispositivos_msg_warn_add_elec_nserie"));
				return false;
			}				
		}	
		return true;
	}
	private boolean validaGenerador(){
		if(this.listagenerador.size() <= 0 && !this.isPrevioimp())
			return false; 
		for(ImpGenerador g:this.listagenerador){
			if(/*g.getModelo()==null*/g.getIdgenerador()==null||g.getIdgenerador()==0)// control modelo
				return false;
			else if(g.getNumserie()==null || g.getNumserie().length()<=0)// control num.serie
				return false;
		}		
		return true;
	}

	/**
	 * Metodo para comprobar la duplicidad de un numero de serie sobre un modelo de generador determinado
	 * @param modelo
	 * @return
	 */
	private boolean numSerieGeneradorEnUso(){		
		if(this.cambioGen){
			ImpGenerador[] gens = null; 
			Generador aux = null;
			try{
				for(ImpGenerador g:this.listagenerador){
					// Busca generadores implantados con mismo numero de serie que los implantados en el sistema actual
					gens = this.gendao.findWhereNumserieEquals(g.getNumserie());
					if(gens!=null && gens.length>0){
						// Verificar que haya concidencia de modelo
						for(ImpGenerador gn:gens){
							aux = this.g.findByPrimaryKey(gn.getIdgenerador());
							if(aux!=null && (aux.getIdgenerador().equals(g.getIdgenerador())))
								/*if(!this.previoimp )// Caso primoimplante o intervencion previa. No puede existir pareja Modelo/Num.Serie previo
									return false;
								else{// comprobacion de Modelo/Num.serie esta asociado al mismo paciente
									
								}*/
								return false;
							// control caso decubito: Recambio o Upgrade y queda el mismo generador y num. serie
						}					
					}		
				}
			}catch(Exception e){
				return false;
			}	
			return true;
		}else	
			return true;
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
			this.hind.setFevi(sgen.getFevi()!=null?sgen.getFevi():null);
			this.hind.setFuncionventricular(sgen.getFuncionventricular()!=null?sgen.getFuncionventricular():null);
			this.hind.setNyha(sgen.getNyha()!=null?sgen.getNyha():null);
			this.hind.setIc(sgen.getNyha()!=null&&sgen.getNyha()>0?true:false);
			this.sgen.setIc(sgen.getNyha()!=null&&sgen.getNyha()>0?true:false);
			this.hind.setCardiop(sgen.getCardiopatia()!=null?true:false);
			this.sgen.setCardiop(sgen.getCardiopatia()!=null?true:false);
			this.hind.setCardiopatia(sgen.getCardiopatia()!=null?sgen.getCardiopatia():null);
			this.hind.setOtra(sgen.getOtra()!=null?sgen.getOtra():null);
			this.hind.setAevolucion(sgen.getAevolucion()!=null?sgen.getAevolucion():null);
			this.hind.setRevasc(sgen.getRevasc()!=null?sgen.getRevasc():null);
			this.hind.setRevascularizacion((sgen.getRevasc()!=null && sgen.getRevasc()==1)?true:false);
			this.sgen.setRevascularizacion((sgen.getRevasc()!=null && sgen.getRevasc()==1)?true:false);
			this.hind.setInfprevio(sgen.getInfprevio()!=null?sgen.getInfprevio():null);
			this.hind.setInfartoprev((sgen.getInfprevio()!=null && sgen.getInfprevio()==1)?true:false);
			this.sgen.setInfartoprev((sgen.getInfprevio()!=null && sgen.getInfprevio()==1)?true:false);
			this.hind.setAnio(sgen.getAnio()!=null?sgen.getAnio():null);
			this.hind.setLocalizacion(sgen.getLocalizacion()!=null?sgen.getLocalizacion():null);
			this.hind.setArritmias(sgen.getArritmias()!=null?sgen.getArritmias():null);
			this.hind.setAvent(sgen.getArritmias()!=null&&sgen.getArritmias()>0?true:false);
			this.sgen.setAvent(sgen.getArritmias()!=null&&sgen.getArritmias()>0?true:false);
			this.hind.setEef(sgen.getEef()!=null?sgen.getEef():null);
			this.hind.setEefprev((sgen.getEef()!=null && sgen.getEef()>0)?true:false);
			this.sgen.setEefprev((sgen.getEef()!=null && sgen.getEef()>0)?true:false);
			this.hind.setInsrenal(sgen.getInsrenal()!=null?sgen.getInsrenal():null);
			this.hind.setAnteinsrenal(sgen.getInsrenal()!=null&&sgen.getInsrenal()==1?true:false);
			this.sgen.setAnteinsrenal(sgen.getInsrenal()!=null&&sgen.getInsrenal()==1?true:false);
			this.hind.setAntfa(sgen.getAntfa()!=null?sgen.getAntfa():null);
			this.hind.setAntefa(sgen.getAntfa()!=null&&sgen.getAntfa()==1?true:false);
			this.sgen.setAntefa(sgen.getAntfa()!=null&&sgen.getAntfa()==1?true:false);
			this.hind.setDiabetes(sgen.getDiabetes()!=null?sgen.getDiabetes():null);
			this.hind.setAntediab(sgen.getDiabetes()!=null&&sgen.getDiabetes()==1?true:false);
			this.sgen.setAntediab(sgen.getDiabetes()!=null&&sgen.getDiabetes()==1?true:false);
			this.hind.setHta(sgen.getHta()!=null?sgen.getHta():null);
			this.hind.setAnteHTA(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.sgen.setAnteHTA(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.hind.setHipercolest(sgen.getHta()!=null?sgen.getHta():null);
			this.hind.setAntehipercol(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.sgen.setAntehipercol(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			this.hind.setMuertesubita(sgen.getMuertesubita()!=null?sgen.getMuertesubita():null);
			this.hind.setAntefam(sgen.getMuertesubita()!=null&&sgen.getMuertesubita()==1?true:false);
			this.sgen.setAntefam(sgen.getMuertesubita()!=null&&sgen.getMuertesubita()==1?true:false);
			this.hind.setTabaquismo(sgen.getTabaquismo()!=null?sgen.getTabaquismo():null);
			this.hind.setAntetabaq(sgen.getTabaquismo()!=null&&sgen.getTabaquismo()==1?true:false);
			this.sgen.setAntetabaq(sgen.getTabaquismo()!=null&&sgen.getTabaquismo()==1?true:false);
			this.hind.setDislipemia(sgen.getDislipemia()!=null?sgen.getDislipemia():null);
			this.hind.setAnteDislipemia(sgen.getDislipemia()!=null&&sgen.getDislipemia()==1?true:false);
			this.sgen.setAnteDislipemia(sgen.getDislipemia()!=null&&sgen.getDislipemia()==1?true:false);
			this.hind.setAcv(sgen.getAcv()!=null?sgen.getAcv():null);
			this.hind.setAnteacv(sgen.getAcv()!=null&&sgen.getAcv()==1?true:false);
			this.sgen.setAnteacv(sgen.getAcv()!=null&&sgen.getAcv()==1?true:false);
			this.hind.setTrasplantecardiaco(sgen.getTrasplantecardiaco()!=null?sgen.getTrasplantecardiaco():null);
			this.hind.setAnteTrasplanteCardiaco(sgen.getTrasplantecardiaco()!=null&&sgen.getTrasplantecardiaco()==1?true:false);
			this.sgen.setAnteTrasplanteCardiaco(sgen.getTrasplantecardiaco()!=null&&sgen.getTrasplantecardiaco()==1?true:false);
			this.hind.setAit(sgen.getAit()!=null?sgen.getAit():null);
			this.hind.setAnteAIT(sgen.getAit()!=null&&sgen.getAit()==1?true:false);
			this.sgen.setAnteAIT(sgen.getAit()!=null&&sgen.getAit()==1?true:false);
			this.hind.setEpoc(sgen.getEpoc()!=null?sgen.getEpoc():null);
			this.hind.setAnteEPOC(sgen.getEpoc()!=null&&sgen.getEpoc()==1?true:false);
			this.sgen.setAnteEPOC(sgen.getEpoc()!=null&&sgen.getEpoc()==1?true:false);
			this.hind.setSahs(sgen.getSahs()!=null?sgen.getSahs():null);
			this.hind.setAnteSAHS(sgen.getSahs()!=null&&sgen.getSahs()==1?true:false);
			this.sgen.setAnteSAHS(sgen.getSahs()!=null&&sgen.getSahs()==1?true:false);
			this.hind.setTiposahs(sgen.getTiposahs()!=null?sgen.getTiposahs():null);
			this.hind.setAhi(sgen.getAhi()!=null?sgen.getAhi():null);
			this.hind.setCpap(sgen.getCpap()!=null?sgen.getCpap():null);
			this.hind.setAnteCPAP(sgen.getCpap()!=null&&sgen.getCpap()==1?true:false);
			this.sgen.setAnteCPAP(sgen.getCpap()!=null&&sgen.getCpap()==1?true:false);
			this.hind.setNeoplasia(sgen.getNeoplasia()!=null?sgen.getNeoplasia():null);
			this.hind.setAnteNeoplasia(sgen.getNeoplasia()!=null&&sgen.getNeoplasia()==1?true:false);
			this.sgen.setAnteNeoplasia(sgen.getNeoplasia()!=null&&sgen.getNeoplasia()==1?true:false);
			this.hind.setTiponeoplasia(sgen.getTiponeoplasia()!=null?sgen.getTiponeoplasia():null);
			this.hind.setAfectiroidea(sgen.getAfectiroidea()!=null?sgen.getAfectiroidea():null);
			this.hind.setNeuromediados(sgen.getNeuromediados()!=null?sgen.getNeuromediados():null);
			this.hind.setSincope(sgen.getSincope()!=null?sgen.getSincope():null);
			this.hind.setAnteSincope(sgen.getSincope()!=null&&sgen.getSincope()==1?true:false);
			this.sgen.setAnteSincope(sgen.getSincope()!=null&&sgen.getSincope()==1?true:false);
			this.hind.setParadacardiaca(sgen.getParadacardiaca()!=null?sgen.getParadacardiaca():null);
			this.hind.setAnteParadaCardiaca(sgen.getParadacardiaca()!=null&&sgen.getParadacardiaca()==1?true:false);
			this.sgen.setAnteParadaCardiaca(sgen.getParadacardiaca()!=null&&sgen.getParadacardiaca()==1?true:false);
			this.hind.setEnfarterios(sgen.getEnfart()!=null&&sgen.getEnfart()==1?true:false);
			this.hind.setAi(sgen.getAi()!=null?sgen.getAi():null);
			this.hind.setAi2(sgen.getAi2()!=null?sgen.getAi2():null);
			this.hind.setAnteflutter(sgen.getFlutter()!=null&&sgen.getFlutter()==1?true:false);
			this.hind.setAlergias(sgen.getAlergias()!=null?sgen.getAlergias():null);
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
				if(this.sgen.getFevi()!=null && (!(this.sgen.getFevi().equals(this.hind.getFevi())) 
						|| (this.sgen.getFuncionventricular()!=null && !(this.sgen.getFuncionventricular().equals(this.hind.getFuncionventricular()))))){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFevi(this.hind.getFevi());
					this.sgen.setFuncionventricular(this.hind.getFuncionventricular());
				}
				if(this.sgen.getFevi()==null && this.hind.getFevi()!=null){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFevi(this.hind.getFevi());
				}
				if(this.sgen.getFuncionventricular()==null && this.hind.getFuncionventricular()!=null){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFuncionventricular(this.hind.getFuncionventricular());
				}
				this.sgen.setFechamod(this.proc.getFecha());// Actualizacion de fecha de modificacion de scg
				// Actualizar situacion clinica
				SituacionClinicaGeneralDao sitclindao = new SituacionClinicaGeneralDaoImpl(this.usuario);
				try {
					sitclindao.update(this.sgen.createPk(), this.sgen);
					// Actualizar el objeto cp.pacienteSelect - situacionclinicageneral
					cp.getPacienteSelect().setSitclin(this.sgen);
				} catch (SituacionClinicaGeneralDaoException e) {
					logger.error("("+this.usuario+") Error al actualizar situacion clinica general de paciente. Motivo: "+e.fillInStackTrace());
				}
			}	
		}else{
			
		}	
	}
	
	public void escribeEnClinica(){
		String path = printInforme();
		logger.info("Inicio de envío de informe a sistema externo");
		try{
			String pathFTP = "";
			DateTime dt = new DateTime();
	        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
			pathFTP = "/"+this.cp.getPacienteSelect().getNhc()+"_"+"Informe_Implante_"+dt.toString(fmt)+".pdf";

			if (GestorFTPInforme.enviarFicheroFTP(path, pathFTP) == 1) {
				File ficheroLocal = new File(path);
				ficheroLocal.delete();
			}else{
				logger.error("Error en envío informe a FTP. ");
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error guardando informe en sistema externo. Por favor contacte con el administrador del sistema. ");
			}
		}catch(Exception ex){
			logger.error("Error en envío informe a FTP. Motivo: "+ex.fillInStackTrace());
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error guardando informe en sistema externo. Motivo: "
					+ ex.getMessage());
		}
	}
	
	

	public HtmlDataTable getBindingCompliPost() {
		return bindingCompliPost;
	}

	public void setBindingCompliPost(HtmlDataTable bindingCompliPost) {
		this.bindingCompliPost = bindingCompliPost;
	}
	public void insertarNuevoGenerador(ActionEvent e){
		logger.info("("+this.usuario+") Iniciando acción insertar generador");
		if(this.nuevogen.getGs128().length()<=0 || this.nuevogen.getModelo().length()<=0 || this.nuevogen.getModelo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_gen"));
			logger.error("("+this.usuario+") No se puede insertar generador. Es necesario especificar codigo GS1-128 y modelo al generador");
		}			
		else{
			try{
				//Generador[] aux =this.g.findByDynamicWhere("MODELO=? OR GS128=?",new Object[]{this.nuevogen.getModelo(),this.nuevogen.getGs128()});
				this.g = new GeneradorDaoImpl(this.usuario);
				Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("TIPO = ? AND CODIGO = ?", new Object[]{1,this.nuevogen.getGs128()});
				Generador gen = null;
				if(codigos!=null && codigos.length>0)
					gen = this.g.findByPrimaryKey(codigos[0].getIdmaterial());
				
				if(gen!=null/*aux.length>0*/){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_dupl"));
					logger.error("("+this.usuario+") No se puede insertar generador. Elemento existente en el sistema");
				}else{
					this.nuevogen.setRf(this.nuevogen.isRfb()?(short)1:(short)0);
					this.nuevogen.setMri(this.nuevogen.isMrib()?(short)1:(short)0);
					this.nuevogen.setActivo(1);
					
					GeneradorPk genpk = this.g.insert(this.nuevogen);
					
					// INSERTAR VALORES DE PROGRAMACION DE FABRICA
					this.nuevogen.getGenfab().setIdgenerador(genpk.getIdgenerador());
					this.genfabdao.insert(this.nuevogen.getGenfab());
					// INSERTAR CODIGOS GS128
					Codigosgs128 gs128 = new Codigosgs128();
					gs128.setCodigo(this.nuevogen.getGs128());
					gs128.setTipo(1);
					gs128.setIdmaterial(genpk.getIdgenerador());
					this.gs128dao.insert(gs128);
					this.nuevogen.getCodigos().add(gs128);
					// Actualiza valor en lista el nuevo generador
					this.setTipogen(Integer.valueOf(this.nuevogen.getTipo()));
					this.listagenerador.get(this.getLineanuevogen()).setIdgenerador(this.nuevogen.getIdgenerador());
					this.listagenerador.get(this.getLineanuevogen()).setNombremodelo(this.nuevogen.getModelo());
					this.listagenerador.get(this.getLineanuevogen()).setModelo(String.valueOf(this.nuevogen.getIdgenerador()));
					this.listagenerador.get(this.getLineanuevogen()).setModo(this.nuevogen.getModo()!=null?this.nuevogen.getModo():"");
					//this.listagenerador.get(this.getBindingGen().getRowIndex()).setNumserie(numserie);
					//this.listagenerador.get(this.getLineanuevogen()).setNumserie(lecturas.get(1));
					this.listagenerador.get(this.getLineanuevogen()).setFabricante(this.nuevogen.getFabricante()!=null?this.nuevogen.getFabricante():"");
					this.listagenerador.get(this.getLineanuevogen()).setMuestrabarcode(false);
					if(this.nuevogen.getRf()!=null)
						if (this.nuevogen.getRf() == 1)
							this.listagenerador.get(this.getLineanuevogen()).setRf("Si");
						else
							this.listagenerador.get(this.getLineanuevogen()).setRf("No");
					else
						this.listagenerador.get(this.getLineanuevogen()).setRf("");
					if(this.nuevogen.getMri()!=null)
						if (this.nuevogen.getMri() == 1)
							this.listagenerador.get(this.getLineanuevogen()).setMricomp("Si");
						else
							this.listagenerador.get(this.getLineanuevogen()).setMricomp("No");
					else
						this.listagenerador.get(this.getLineanuevogen()).setMricomp("");
					
					//this.setRecambioGen(true);
					this.listagenerador.get(this.getLineanuevogen()).setBarcode("");
					this.listagenerador.get(this.getLineanuevogen()).setMuestrabarcode(false);
					
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("mat_msg_info_add"));
					cargaGeneradores();
					this.setLineanuevogen(null);
					// Notificacion por mail
					GestorCorreo gc = new GestorCorreo();
					gc.sendMailToAdminGen(this.nuevogen, this.infocentro.getCentro(), this.usuario, 1);
					//NotificacionMaterial obj = new NotificacionMaterial();
					//obj.notificaMaterialGenerador(this.nuevomodelogen, this.nuevoreferenciagen, this.nuevofabricantegen, this.nuevotipogen, this.nuevomodogen, this.conectoravgen, this.conectorvdgen, this.conectorvigen, this.rf?"1":"0", this.mri?"1":"0",this.nombre_centro , this.nuevogs1gen);
					logger.info("("+this.usuario+") Generador- Modelo:"+this.nuevogen.getModelo()+". GS1-128: "+this.nuevogen.getGs128()+" insertado con éxito en el sistema");
				}
				this.nuevogen = new Generador();
				this.setNgen(false);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("mat_msg_error_add")+": "+ e1.getMessage());
				logger.error("("+this.usuario+") No se puede insertar generador. Error: "+ e1.getMessage());				
			}
		}	
	}
	public void cancelarNuevoGenerador(ActionEvent e){
		this.nuevogen = new Generador();
		this.setNgen(false);
	}
	public void insertarNuevoElectrodo(ActionEvent e){
		logger.info("("+this.usuario+") Iniciando acción insertar electrodo");		
		if(this.nuevoelec.getGs128().length()<=0 || this.nuevoelec.getModelo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_add"));
			logger.error("("+this.usuario+") No se puede insertar electrodo. Es necesario especificar codigo GS1-128 y modelo al electrodo");
		}			
		else{
			try{
				//Electrodos[] aux =this.e.findByDynamicWhere("MODELO=? OR GS128=?",new Object[]{this.nuevoelec.getModelo(),this.nuevoelec.getGs128()});
				this.e = new ElectrodosDaoImpl(this.usuario);
				Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("TIPO = ? AND CODIGO = ?", new Object[]{2,this.nuevoelec.getGs128()});
				Electrodos aux = null;
				if(codigos!=null && codigos.length>0)
					aux = this.e.findByPrimaryKey(codigos[0].getIdmaterial());
				if(aux!=null/*aux.length>0*/){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_dupl"));
					logger.error("("+this.usuario+") No se puede insertar electrodo. Elemento existente en el sistema");
				}else{
					this.nuevoelec.setActivo(1);
					ElectrodosPk elpk = this.e.insert(this.nuevoelec);
					// INSERTAR CODIGOS GS128
					Codigosgs128 gs128 = new Codigosgs128();
					gs128.setCodigo(this.nuevoelec.getGs128());
					gs128.setTipo(2);
					gs128.setIdmaterial(elpk.getIdelectrodo());
					this.gs128dao.insert(gs128);
					this.nuevoelec.getCodigos().add(gs128);
					// Actualiza lista electrodos 
					this.listaelectrodos.get(this.getLineanuevoelec()).setNombremodelo(this.nuevoelec.getModelo());
					this.listaelectrodos.get(this.getLineanuevoelec()).setIdelectrodo(this.nuevoelec.getIdelectrodo());
					//this.listaelectrodos.get(this.bindingElec.getRowIndex()).setNumserie(numserie);
					//this.listaelectrodos.get(this.getLineanuevoelec()).setNumserie(lecturas.get(1));
					this.listaelectrodos.get(this.getLineanuevoelec()).setBarcode("");
					this.listaelectrodos.get(this.getLineanuevoelec()).setMuestrabarcode(false);
					this.listaelectrodos.get(this.getLineanuevoelec()).setConector(this.nuevoelec.getConector()!=null?this.nuevoelec.getConector():"");
					this.listaelectrodos.get(this.getLineanuevoelec()).setFabricante(this.nuevoelec.getFabricante()!=null?this.nuevoelec.getFabricante():"");
					this.listaelectrodos.get(this.getLineanuevoelec()).setVdd(false); // inicialmente false. Si luego se verifica que es VDD, se pasa a true
					// Control SICD
					if(this.nuevoelec.getConector()!=null && this.nuevoelec.getConector().equals("SQ1")){
						this.listaelectrodos.get(this.getLineanuevoelec()).setCamara(-1);
						this.listaelectrodos.get(this.getLineanuevoelec()).setVdd(false);
						this.listaelectrodos.get(this.getLineanuevoelec()).setLateralidad(951);
						this.listaelectrodos.get(this.getLineanuevoelec()).setZonacamara(IDZONA_SICD);
						this.listaelectrodos.get(this.getLineanuevoelec()).setEstado(0);
						this.componerNombreAbordaje(this.listaelectrodos.get(this.getLineanuevoelec()));
					}	
					// Control VDD - Solo deja meterlo si NO existe uno previo o hay abandonados o explantados parcialmente
					if(this.nuevoelec.getConector()!=null && this.nuevoelec.getConector().equals("IS-1 BIF") ){
						if(!existeElectrodoVDD()){
							this.listaelectrodos.get(this.getLineanuevoelec()).setVdd(true);
							ImpImplanteElectrodos ad = new ImpImplanteElectrodos();
							ad.setNombremodelo(this.nuevoelec.getModelo()+"(Auricular)");
							ad.setIdelectrodo(this.nuevoelec.getIdelectrodo());
							//ad.setNumserie(lecturas.get(1));
							ad.setBarcode("");
							ad.setMuestrabarcode(false);
							ad.setConector(this.nuevoelec.getConector()!=null?this.nuevoelec.getConector():"");
							ad.setFabricante(this.nuevoelec.getFabricante()!=null?this.nuevoelec.getFabricante():"");
							//ad.setTipoelectrodo(String.valueOf(els[0].getIdelectrodo())+"-"+lecturas.get(1));
							ad.setTipoelectrodo("VDD");
							ad.setCamara(948);//Auricular
							ad.setVdd(true);
							this.listaelectrodos.add(ad);
						}else{
							this.listaelectrodos.remove(this.getLineanuevoelec());
							this.pintaMensaje(AVISO, this.bundle.getString("imp_dispositivos_msg_warn_vdd_previo"));
						}					
					}else
						actualizaListaElectrodosVDD(this.getLineanuevoelec());
					
					
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("mat_msg_info_add"));
					cargaElectrodos();
					this.setLineanuevoelec(null);
					// Notificacion por mail
					GestorCorreo gc = new GestorCorreo();
					gc.sendMailToAdminElec(this.nuevoelec, this.infocentro.getCentro(), this.usuario, 1);
					//NotificacionMaterial obj = new NotificacionMaterial();
					//obj.notificaMaterialElectrodo(this.nuevomodeloelec,this.nuevoreferenciaelec,this.nuevofabricanteelec,this.nuevopolaridadelec, 
					//		this.nuevofijacionelec, this.nuevoconectorelec, this.nuevobobinaelec,this.nombre_centro,this.nuevonummodeloelec,this.nuevogs128elec);
					logger.info("("+this.usuario+") Electrodo- Modelo:"+this.nuevoelec.getModelo()+". GS1-128: "+this.nuevoelec.getGs128()+" insertado con éxito en el sistema");
				}
				this.nuevoelec = new Electrodos();
				this.setNelec(false);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("mat_msg_error_add")+": "+ e1.getMessage());
				logger.error("("+this.usuario+") No se puede insertar electrodo. Error: "+ e1.getMessage());	
			}	
		}
	}
	public void cancelarNuevoElectrodo(ActionEvent e){
		this.nuevoelec = new Electrodos();
		this.setNelec(false);
	}
	
	public void actualizaNuevoGen(ActionEvent e){
		if(this.isNgen())
			this.setNgen(false);
	}
	public void actualizaNuevoElec(ActionEvent e){
		if(this.isNelec())
			this.setNelec(false);
	}
	public void lecturaGs128Generador(ActionEvent e){
		if(this.nuevogen.getGs128().length()>=16)// codigo GS1-128
			this.nuevogen.setGs128(this.nuevogen.getGs128().substring(0, 16).substring(2, 16));
		if(this.nuevogen.getGs128().length()!=14)
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
	}
	public void lecturaGs128Electrodo(ActionEvent e){
		if(this.nuevoelec.getGs128().length()>=16)// codigo GS1-128
			this.nuevoelec.setGs128(this.nuevoelec.getGs128().substring(0, 16).substring(2, 16));
		if(this.nuevoelec.getGs128().length()!=14)
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
	}
	
	public ArrayList<SelectItem> getTipoproc() {
		ArrayList<SelectItem> pr = new ArrayList<SelectItem>();
		for (ArrMaestras procedimiento : this.tipoproc)
			pr.add(new SelectItem(procedimiento.getCodigo().toString(), procedimiento.getValor()));
		return pr;
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
		//diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
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

	public ArrayList<SelectItem> getLocalizaciongen() {
		ArrayList<SelectItem> loc = new ArrayList<SelectItem>();
		loc.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras l : this.localizaciongen)
			if(!l.getValor().toUpperCase().contains("AXILAR"))
				loc.add(new SelectItem(l.getCodigo().toString(), l.getValor()));
		return loc;
	}
	
	public ArrayList<SelectItem> getLocalizaciongensicd() {
		ArrayList<SelectItem> loc = new ArrayList<SelectItem>();
		loc.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras l : this.localizaciongen)
			if(l.getValor().toUpperCase().contains("AXILAR"))
				loc.add(new SelectItem(l.getCodigo().toString(), l.getValor()));
		return loc;
	}

	/*public ArrayList<SelectItem> getGeneradores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (com.sorin.idea.dto.Generador ref : this.generadores)
			diag.add(new SelectItem(String.valueOf(ref.getIdgenerador()), ref
					.getModelo()));
		return diag;
	}*/
	public ArrayList<SelectItem> getGeneradores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (com.sorin.idea.dto.Generador ref : this.generadores)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}
	public ArrayList<SelectItem> getGeneradores2() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (com.sorin.idea.dto.Generador ref : this.generadores2)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}

	/*public ArrayList<SelectItem> getElectrodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (com.sorin.idea.dto.Electrodos ref : this.electrodos)
			diag.add(new SelectItem(String.valueOf(ref.getIdelectrodo()), ref
					.getModelo()));
		return diag;
	}*/
	public ArrayList<SelectItem> getElectrodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (com.sorin.idea.dto.Electrodos ref : this.electrodos)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}
	public ArrayList<SelectItem> getElectrodos2() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (com.sorin.idea.dto.Electrodos ref : this.electrodos2)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}

	public ArrayList<SelectItem> getComplicacionesintra() {
		ArrayList<SelectItem> cint = new ArrayList<SelectItem>();
		cint.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (com.sorin.idea.dto.Complicacion ref : this.complicacionesintra)
			cint.add(new SelectItem(String.valueOf(ref.getIdcompl()), ref
					.getClase()));
		return cint;
	}

	public ArrayList<SelectItem> getSintomas() {
		ArrayList<SelectItem> sintomas = new ArrayList<SelectItem>();
		sintomas.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.sintomas)
			sintomas.add(new SelectItem(procedimiento.getValor(), procedimiento
					.getValor()));
		return sintomas;
	}

	public ArrayList<SelectItem> getViaaccesoimplante() {
		ArrayList<SelectItem> vias = new ArrayList<SelectItem>();
		vias.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.viaaccesoimplante)
			vias.add(new SelectItem(procedimiento.getCodigo(), procedimiento
					.getValor()));
		return vias;
	}

	public ArrayList<SelectItem> getCamara() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.camara)
			c.add(new SelectItem(procedimiento.getCodigo(), procedimiento
					.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getLateralidad() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.lateralidad)
			c.add(new SelectItem(procedimiento.getCodigo(), procedimiento
					.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getZonacamaraad() {
		ArrayList<SelectItem> zad = new ArrayList<SelectItem>();
		zad.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.zonacamaraad)
			zad.add(new SelectItem(procedimiento.getCodigo(), procedimiento
					.getValor()));
		return zad;
	}

	public ArrayList<SelectItem> getZonacamaravd() {
		ArrayList<SelectItem> zvd = new ArrayList<SelectItem>();
		zvd.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.zonacamaravd)
			zvd.add(new SelectItem(procedimiento.getCodigo(), procedimiento
					.getValor()));
		return zvd;
	}

	public ArrayList<SelectItem> getZonacamaravi() {
		ArrayList<SelectItem> zvi = new ArrayList<SelectItem>();
		zvi.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.zonacamaravi)
			zvi.add(new SelectItem(procedimiento.getCodigo(), procedimiento
					.getValor()));
		return zvi;
	}

	public ArrayList<SelectItem> getZonaepicardico() {
		ArrayList<SelectItem> epi = new ArrayList<SelectItem>();
		epi.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.zonaepicardico)
			epi.add(new SelectItem(procedimiento.getCodigo(), procedimiento
					.getValor()));
		return epi;
	}
	
	public ArrayList<SelectItem> getZonacamarasicd() {
		ArrayList<SelectItem> epi = new ArrayList<SelectItem>();
		epi.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.zonacamarasicd)
			epi.add(new SelectItem(procedimiento.getCodigo(), procedimiento
					.getValor()));
		return epi;
	}

	public ArrayList<SelectItem> getPorcion() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.porcion)
			c.add(new SelectItem(procedimiento.getCodigo(), procedimiento
					.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getMrecambiogen() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.mrecambiogen)
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getMrecambioelec() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.mrecambioelec)
			c.add(new SelectItem(m.getCodigo().toString().toString(), m
					.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getMrecolocaciongen() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.mrecolocaciongen)
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getMrecolocacionelec() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.mrecolocacionelec)
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getMexplantegen() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.mexplantegen)
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getMexplanteelec() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.mexplanteelec)
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		return c;
	}
	public ArrayList<SelectItem> getHprocedencia() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", "No especificado"));
		for (ArrMaestras m : this.hprocedencia)
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getTipocomplicacion() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.tipocomplicacion)
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getTipocomplicacionpost() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.tipocomplicacionpost)
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getLcompintraquir() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesintra) {
			if (m.getTipo().equals("967"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcompintraarr() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesintra) {
			if (m.getTipo().equals("968"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcompintratmp() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesintra) {
			if (m.getTipo().equals("969"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcompintraresp() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesintra) {
			if (m.getTipo().equals("970"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcompintramuerte() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesintra) {
			if (m.getTipo().equals("971"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcomppostelect() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionespost) {
			if (m.getTipo().equals("975"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcomppostarr() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionespost) {
			if (m.getTipo().equals("973"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcompposttmp() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionespost) {
			if (m.getTipo().equals("974"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcomppostresp() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionespost) {
			if (m.getTipo().equals("976"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcomppostmuerte() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionespost) {
			if (m.getTipo().equals("977"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getEnfermeras() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", "(Seleccione personal)"));
		for (ArrMaestras diagnostico : this.enfermeria)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getEnfermerasTodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "(Seleccione personal)"));
		for (ArrMaestras diagnostico : this.enfermeria_todos)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getPrimerOperador() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", "(Seleccione personal)"));
		for (ArrMaestras diagnostico : this.primerop)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getPrimerOperadorTodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "(Seleccione personal)"));
		for (ArrMaestras diagnostico : this.primerop_todos)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getSegundoOperador() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", "(Seleccione personal)"));
		for (ArrMaestras diagnostico : this.segundoop)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getSegundoOperadorTodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "(Seleccione personal)"));
		for (ArrMaestras diagnostico : this.segundoop_todos)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getModogen() {
		ArrayList<SelectItem> m = new ArrayList<SelectItem>();
		m.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras mg : this.modogen){
			if(this.tipogen==1 || this.tipogen==3){
				if(UtilMapeos.esModoValidoMPS(this.modogenini, mg.getValor()))
					m.add(new SelectItem(mg.getCodigo(), mg.getValor()));
			}else if(this.tipogen==2 || this.tipogen==4){
				if(UtilMapeos.esModoValidoDAI(this.modogenini, mg.getValor(),this.tipogen))
					m.add(new SelectItem(mg.getCodigo(), mg.getValor()));
			}else if(this.tipogen==5)
				if(mg.getValor().toUpperCase().equals("SSI"))
					m.add(new SelectItem(mg.getCodigo(), mg.getValor()));
		}
		return m;
	}
	public ArrayList<SelectItem> getModogen2() {
		ArrayList<SelectItem> m = new ArrayList<SelectItem>();
		m.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras mg : this.modogen)
			m.add(new SelectItem(mg.getCodigo(), mg
					.getValor()));
		return m;
	}
	public ArrayList<SelectItem> getMotivosterapianoapropiada() {
		ArrayList<SelectItem> m = new ArrayList<SelectItem>();
		m.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras mg : this.motivosterapianoapropiada)
			m.add(new SelectItem(mg.getCodigo(), mg
					.getValor()));
		return m;
	}

	public ArrayList<SelectItem> getFabgen() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.fabgen)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getCadgen() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.cadgen)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getCvdgen() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.cvdgen)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getCvigen() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.cvigen)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getFabelec() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.fabelec)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getPolelec() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.polelec)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getConelec() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.conelec)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getFijaelec() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.fijaelec)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getBobelec() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.bobelec)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}

	public String getTipoprocedimiento() {
		return tipoprocedimiento;
	}

	public void setTipoprocedimiento(String tipoprocedimiento) {
		this.tipoprocedimiento = tipoprocedimiento;
	}

	public boolean isPrevioimp() {
		return previoimp;
	}

	public void setPrevioimp(boolean previoimp) {
		this.previoimp = previoimp;
	}

	public int getTipogen() {
		return tipogen;
	}

	public void setTipogen(int tipogen) {
		this.tipogen = tipogen;
	}

	public boolean isRecambioGen() {
		return recambioGen;
	}

	public void setRecambioGen(boolean recambioGen) {
		this.recambioGen = recambioGen;
	}

	public boolean isRecolocacionGen() {
		return recolocacionGen;
	}

	public void setRecolocacionGen(boolean recolocacionGen) {
		this.recolocacionGen = recolocacionGen;
	}

	public HtmlDataTable getBindingCompliIntra() {
		return bindingCompliIntra;
	}

	public void setBindingCompliIntra(HtmlDataTable bindingCompliIntra) {
		this.bindingCompliIntra = bindingCompliIntra;
	}

	public int getSecactivacion() {
		return secactivacion;
	}

	public void setSecactivacion(int secactivacion) {
		this.secactivacion = secactivacion;
	}

	public boolean isEstimfrenica() {
		return estimfrenica;
	}

	public void setEstimfrenica(boolean estimfrenica) {
		this.estimfrenica = estimfrenica;
	}

	public HtmlDataTable getBindingAtpZona() {
		return bindingAtpZona;
	}

	public void setBindingAtpZona(HtmlDataTable bindingAtpZona) {
		this.bindingAtpZona = bindingAtpZona;
	}

	public int getOptint() {
		return optint;
	}

	public void setOptint(int optint) {
		this.optint = optint;
	}

	public HtmlDataGrid getBindingGrid() {
		return bindingGrid;
	}

	public void setBindingGrid(HtmlDataGrid bindingGrid) {
		this.bindingGrid = bindingGrid;
	}

	public HtmlDataTable getBindingSintomas() {
		return bindingSintomas;
	}

	public void setBindingSintomas(HtmlDataTable bindingSintomas) {
		this.bindingSintomas = bindingSintomas;
	}

	public ImpHojaImplante getHimp() {
		return himp;
	}

	public void setHimp(ImpHojaImplante himp) {
		this.himp = himp;
	}

	public SituacionClinicaProc getHind() {
		return hind;
	}

	public void setHind(SituacionClinicaProc hind) {
		this.hind = hind;
	}

	public void setElectrodos(com.sorin.idea.dto.Electrodos[] electrodos) {
		this.electrodos = electrodos;
	}

	public HtmlDataTable getBinEnf() {
		return binEnf;
	}

	public void setBinEnf(HtmlDataTable binEnf) {
		this.binEnf = binEnf;
	}

	public HtmlDataTable getBinPop() {
		return binPop;
	}

	public void setBinPop(HtmlDataTable binPop) {
		this.binPop = binPop;
	}

	public HtmlDataTable getBinSop() {
		return binSop;
	}

	public void setBinSop(HtmlDataTable binSop) {
		this.binSop = binSop;
	}

	public ImpEvolucion getHev() {
		return hev;
	}

	public void setHev(ImpEvolucion hev) {
		this.hev = hev;
	}

	public boolean isAvzona() {
		return avzona;
	}

	public void setAvzona(boolean avzona) {
		this.avzona = avzona;
	}

	public ArrayList<ImpGenerador> getListagenerador() {
		return listagenerador;
	}

	public void setListagenerador(ArrayList<ImpGenerador> listagenerador) {
		this.listagenerador = listagenerador;
	}

	public ArrayList<ImpImplanteElectrodos> getListaelectrodos() {
		return listaelectrodos;
	}

	public void setListaelectrodos(
			ArrayList<ImpImplanteElectrodos> listaelectrodos) {
		this.listaelectrodos = listaelectrodos;
	}

	public boolean isTarjetaeuropea() {
		return tarjetaeuropea;
	}

	public void setTarjetaeuropea(boolean tarjetaeuropea) {
		this.tarjetaeuropea = tarjetaeuropea;
	}

	public void setComplicacionesintra(
			com.sorin.idea.dto.Complicacion[] complicacionesintra) {
		this.complicacionesintra = complicacionesintra;
	}

	public com.sorin.idea.dto.Complicacion[] getComplicacionespost() {
		return complicacionespost;
	}

	public void setComplicacionespost(
			com.sorin.idea.dto.Complicacion[] complicacionespost) {
		this.complicacionespost = complicacionespost;
	}

	public ArrayList<ImpHojaImplanteComplicacion> getListacomplicacionesintra() {
		return listacomplicacionesintra;
	}

	public void setListacomplicacionesintra(
			ArrayList<ImpHojaImplanteComplicacion> listacomplicacionesintra) {
		this.listacomplicacionesintra = listacomplicacionesintra;
	}

	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public ImpImplante getImpl() {
		return impl;
	}

	public void setImpl(ImpImplante impl) {
		this.impl = impl;
	}

	public ImpImplanteDao getImpdao() {
		return impdao;
	}

	public void setImpdao(ImpImplanteDao impdao) {
		this.impdao = impdao;
	}

	public ImpHojaImplanteDao getHimpdao() {
		return himpdao;
	}

	public void setHimpdao(ImpHojaImplanteDao himpdao) {
		this.himpdao = himpdao;
	}

	public ProcedimientoDao getProcdao() {
		return procdao;
	}

	public void setProcdao(ProcedimientoDao procdao) {
		this.procdao = procdao;
	}

	public ImpEvolucionDao getHevdao() {
		return hevdao;
	}

	public void setHevdao(ImpEvolucionDao hevdao) {
		this.hevdao = hevdao;
	}

	public SintomasSitclinProcDao getSintdao() {
		return sintdao;
	}

	public void setSintdao(SintomasSitclinProcDao sintdao) {
		this.sintdao = sintdao;
	}

	public ImpHojaImplantePopDao getPopdao() {
		return popdao;
	}

	public void setPopdao(ImpHojaImplantePopDao popdao) {
		this.popdao = popdao;
	}

	public ImpHojaImplanteEnfDao getEnfdao() {
		return enfdao;
	}

	public void setEnfdao(ImpHojaImplanteEnfDao enfdao) {
		this.enfdao = enfdao;
	}

	public ImpHojaImplanteSopDao getSopdao() {
		return sopdao;
	}

	public void setSopdao(ImpHojaImplanteSopDao sopdao) {
		this.sopdao = sopdao;
	}

	public ImpImplanteElectrodosDao getImpelecdao() {
		return impelecdao;
	}

	public void setImpelecdao(ImpImplanteElectrodosDao impelecdao) {
		this.impelecdao = impelecdao;
	}

	public ImpZonaDao getZonadao() {
		return zonadao;
	}

	public void setZonadao(ImpZonaDao zonadao) {
		this.zonadao = zonadao;
	}

	public ImpAtpDao getAtpdao() {
		return atpdao;
	}

	public void setAtpdao(ImpAtpDao atpdao) {
		this.atpdao = atpdao;
	}

	public Procedimiento[] getProclst() {
		return proclst;
	}

	public void setProclst(Procedimiento[] proclst) {
		this.proclst = proclst;
	}

	public HtmlDataTable getBindingBuscar() {
		return bindingBuscar;
	}

	public void setBindingBuscar(HtmlDataTable bindingBuscar) {
		this.bindingBuscar = bindingBuscar;
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

	public ImpGenerador getImpgendao() {
		return impgendao;
	}

	public void setImpgendao(ImpGenerador impgendao) {
		this.impgendao = impgendao;
	}

	public ImpGeneradorDao getGendao() {
		return gendao;
	}

	public void setGendao(ImpGeneradorDao gendao) {
		this.gendao = gendao;
	}

	public ImpGeneradorPk getGenpk() {
		return genpk;
	}

	public void setGenpk(ImpGeneradorPk genpk) {
		this.genpk = genpk;
	}

	public ArrayList<ImpImplanteElectrodosPk> getListaelectrodospk() {
		return listaelectrodospk;
	}

	public void setListaelectrodospk(
			ArrayList<ImpImplanteElectrodosPk> listaelectrodospk) {
		this.listaelectrodospk = listaelectrodospk;
	}

	public ArrayList<ImpZonaPk> getListazonapk() {
		return listazonapk;
	}

	public void setListazonapk(ArrayList<ImpZonaPk> listazonapk) {
		this.listazonapk = listazonapk;
	}

	public ArrayList<ImpAtpPk> getListaatppk() {
		return listaatppk;
	}

	public void setListaatppk(ArrayList<ImpAtpPk> listaatppk) {
		this.listaatppk = listaatppk;
	}

	public ArrayList<ImpChoquesPk> getListachoquespk() {
		return listachoquespk;
	}

	public void setListachoquespk(ArrayList<ImpChoquesPk> listachoquespk) {
		this.listachoquespk = listachoquespk;
	}

	public ImpChoquesDao getChoquedao() {
		return choquedao;
	}

	public void setChoquedao(ImpChoquesDao choquedao) {
		this.choquedao = choquedao;
	}

	public boolean isActualizacion() {
		return actualizacion;
	}

	public void setActualizacion(boolean actualizacion) {
		this.actualizacion = actualizacion;
	}

	public ArrayList<ImpEvolucionComplicacion> getListacomplicacionespost() {
		return listacomplicacionespost;
	}

	public void setListacomplicacionespost(
			ArrayList<ImpEvolucionComplicacion> listacomplicacionespost) {
		this.listacomplicacionespost = listacomplicacionespost;
	}

	public ImpHojaImplanteComplicacionDao getCompintradao() {
		return compintradao;
	}

	public void setCompintradao(ImpHojaImplanteComplicacionDao compintradao) {
		this.compintradao = compintradao;
	}

	public ImpEvolucionComplicacionDao getComppostdao() {
		return comppostdao;
	}

	public void setComppostdao(ImpEvolucionComplicacionDao comppostdao) {
		this.comppostdao = comppostdao;
	}

	public HtmlDataTable getBindingChoques() {
		return bindingChoques;
	}

	public void setBindingChoques(HtmlDataTable bindingChoques) {
		this.bindingChoques = bindingChoques;
	}

	public boolean isExplanteGen() {
		return explanteGen;
	}

	public void setExplanteGen(boolean explanteGen) {
		this.explanteGen = explanteGen;
	}

	public ArrayList<ImpGenerador> getListageneradorexp() {
		return listageneradorexp;
	}

	public void setListageneradorexp(ArrayList<ImpGenerador> listageneradorexp) {
		this.listageneradorexp = listageneradorexp;
	}

	public ArrayList<ImpImplanteElectrodos> getListaelectrodosexp() {
		return listaelectrodosexp;
	}

	public void setListaelectrodosexp(
			ArrayList<ImpImplanteElectrodos> listaelectrodosexp) {
		this.listaelectrodosexp = listaelectrodosexp;
	}

	public ArrayList<ImpImplanteElectrodosPk> getListaelectrodosexppk() {
		return listaelectrodosexppk;
	}

	public void setListaelectrodosexppk(
			ArrayList<ImpImplanteElectrodosPk> listaelectrodosexppk) {
		this.listaelectrodosexppk = listaelectrodosexppk;
	}

	public ImpImplanteElectrodos getCurrentItemElectrodos() {
		return currentItemElectrodos;
	}

	public void setCurrentItemElectrodos(
			ImpImplanteElectrodos currentItemElectrodos) {
		this.currentItemElectrodos = currentItemElectrodos;
	}

	public boolean isCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	public HtmlDataTable getBindingSeguimientos() {
		return bindingSeguimientos;
	}

	public void setBindingSeguimientos(HtmlDataTable bindingSeguimientos) {
		this.bindingSeguimientos = bindingSeguimientos;
	}

	public ArrayList<ImplanteSeguimientoBean> getProcs() {
		return procs;
	}

	public void setProcs(ArrayList<ImplanteSeguimientoBean> procs) {
		this.procs = procs;
	}

	public ImpImplanteElectrodos getCurrentItemElectrodosEliminar() {
		return currentItemElectrodosEliminar;
	}

	public void setCurrentItemElectrodosEliminar(
			ImpImplanteElectrodos currentItemElectrodosEliminar) {
		this.currentItemElectrodosEliminar = currentItemElectrodosEliminar;
	}

	public ArrayList<ImpGenerador> getListageneradorexptarjeta() {
		return listageneradorexptarjeta;
	}

	public void setListageneradorexptarjeta(
			ArrayList<ImpGenerador> listageneradorexptarjeta) {
		this.listageneradorexptarjeta = listageneradorexptarjeta;
	}

	public ArrayList<ImpImplanteElectrodos> getListaelectrodosexptarjeta() {
		return listaelectrodosexptarjeta;
	}

	public void setListaelectrodosexptarjeta(
			ArrayList<ImpImplanteElectrodos> listaelectrodosexptarjeta) {
		this.listaelectrodosexptarjeta = listaelectrodosexptarjeta;
	}

	public boolean isElecdisfexp() {
		return elecdisfexp;
	}

	public void setElecdisfexp(boolean elecdisfexp) {
		this.elecdisfexp = elecdisfexp;
	}

	public boolean isElecdisfaband() {
		return elecdisfaband;
	}

	public void setElecdisfaband(boolean elecdisfaband) {
		this.elecdisfaband = elecdisfaband;
	}

	public boolean isElecfunc() {
		return elecfunc;
	}

	public void setElecfunc(boolean elecfunc) {
		this.elecfunc = elecfunc;
	}

	public ImpImplanteElectrodos getCurrentItemElectrodosBackUp() {
		return currentItemElectrodosBackUp;
	}

	public void setCurrentItemElectrodosBackUp(ImpImplanteElectrodos currentItemElectrodosBackUp) {
		this.currentItemElectrodosBackUp = new ImpImplanteElectrodos();
		this.currentItemElectrodosBackUp.setVia(currentItemElectrodosBackUp.getVia());
		this.currentItemElectrodosBackUp.setLateralidad(currentItemElectrodosBackUp.getLateralidad());
		this.currentItemElectrodosBackUp.setCamara(currentItemElectrodosBackUp.getCamara());
		this.currentItemElectrodosBackUp.setZonacamara(currentItemElectrodosBackUp.getZonacamara());
		this.currentItemElectrodosBackUp.setPorcion(currentItemElectrodosBackUp.getPorcion());
	}

	public ImpImplanteElectrodos getCurrentItemElectrodosEliminarBackUp() {
		return currentItemElectrodosEliminarBackUp;
	}

	public void setCurrentItemElectrodosEliminarBackUp(ImpImplanteElectrodos currentItemElectrodosEliminarBackUp) {
		this.currentItemElectrodosEliminarBackUp = new ImpImplanteElectrodos();
		this.currentItemElectrodosEliminarBackUp.setEstado(currentItemElectrodosEliminarBackUp.getEstado());
		this.currentItemElectrodosEliminarBackUp.setCaracter(currentItemElectrodosEliminarBackUp.getCaracter());
		this.currentItemElectrodosEliminarBackUp.setMotivoexaband(currentItemElectrodosEliminarBackUp.getMotivoexaband());
	}

	public boolean isIntprevia() {
		return intprevia;
	}

	public void setIntprevia(boolean intprevia) {
		this.intprevia = intprevia;
	}

	public String getBarCodeGen() {
		return barCodeGen;
	}

	public void setBarCodeGen(String barCodeGen) {
		this.barCodeGen = barCodeGen;
	}

	public boolean isModgen() {
		return modgen;
	}

	public void setModgen(boolean modgen) {
		this.modgen = modgen;
	}

	public boolean isModelec() {
		return modelec;
	}

	public void setModelec(boolean modelec) {
		this.modelec = modelec;
	}
	public void lecturaProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
		p.load(is);
		is.close();
		this.infocentro = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
					p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"));
	}

	public Date getBackupFecha() {
		return backupFecha;
	}

	public void setBackupFecha(Date backupFecha) {
		this.backupFecha = backupFecha;
	}

	public boolean isSintomasDuplicados() {
		return sintomasDuplicados;
	}

	public void setSintomasDuplicados(boolean sintomasDuplicados) {
		this.sintomasDuplicados = sintomasDuplicados;
	}

	public boolean isUpgrade() {
		return upgrade;
	}

	public void setUpgrade(boolean upgrade) {
		this.upgrade = upgrade;
	}

	public boolean isRecolocacion() {
		return recolocacion;
	}

	public void setRecolocacion(boolean recolocacion) {
		this.recolocacion = recolocacion;
	}
	
	private boolean validaNProc(){
		if(this.impl.getNproc()==null && this.impl.getNproc().length()<1){
			this.pintaMensaje(ERROR, this.bundle.getString("info_msg_guarda_error_nproc_noesp"));
			return false;
		}
		try{
			ImpImplante[] imps = this.impdao.findByDynamicWhere(" NPROC = ?", new Object[] { this.impl.getNproc() });
			if(imps!=null && imps.length>0 && this.impl.getIdimplante()==null){
				this.pintaMensaje(ERROR, this.bundle.getString("info_msg_guarda_error_nproc_prev"));
				return false;
			}
			return true;
		}catch(Exception e){
			this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_generar_nproc_exepc")+": "+e.getMessage());
			return false;
		}
	}
	
	/**
	 * Funcion para validar formulario Implante a guardar. Control de inconsistencia de información a guardar
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
		for(ImpHojaImplanteEnf e:this.himp.getEnfermeras()){
			if(e.getIdenf().equals("0")){
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
		for(ImpHojaImplantePop e:this.himp.getPoperador()){
			if(e.getIdop().equals("0")){
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
		for(ImpHojaImplanteSop e:this.himp.getSoperador()){
			if(e.getIdop().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("eef_msg_warn_sop_noinfo"));
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("eef_msg_warn_sop_dupl"));
				res = false;
			}		
		}
		dup = 0;
		// Complicaciones intra
		for(ImpHojaImplanteComplicacion e:this.listacomplicacionesintra){
			if((e.getIdcompl()==null && (e.getOtra()==null ||e.getOtra().equals(""))) || (e.getIdcompl()!=null && e.getIdcompl()==0)){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_intra_noinfo"));
				//res = false;
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_compl_intra_dupl"));
				res = false;
			}
			if(e.getTipocomp()==null || e.getTipocomp().equals("0")){// control de complicaciones sin tipo asignado
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_intra_noinfo"));
				res = false;
			}
		}
		// Complicaciones POST
		dup = 0;
		for(ImpEvolucionComplicacion e:this.listacomplicacionespost){
			if((e.getIdcompl()==null && (e.getOtra()==null ||e.getOtra().equals(""))) || (e.getIdcompl()!=null && e.getIdcompl()==0)){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_post_noinfo"));
				//res = false;
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_compl_post_dupl"));
				res = false;
			}
			if(e.getTipocomp()==null || e.getTipocomp().equals("0")){// control de complicaciones sin tipo asignado
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_post_noinfo"));
				res = false;
			}
		}		
		// Sintomas
		dup = 0;
		for(SintomasSitclinProc s:this.hind.getSintomas()){
			if(s.getIdsintomas()==null ||s.getIdsintomas().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sitclin_sintoma_noinfo"));
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_sitclin_sintoma_duplic"));
				res = false;
			}		
		}
		// Zonas (Si DAI). Control de escritura fc
		for(ImpZona z:this.hev.getZonas()){
			if(z.getFcMs().equals("") || z.getFcPpm().equals("")){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_zonas_noinfo"));
				res = false;
			}		
		}
		return res;	
	}

	public String getModogenini() {
		return modogenini;
	}

	public void setModogenini(String modogenini) {
		this.modogenini = modogenini;
	}

	public Generador getNuevogen() {
		return nuevogen;
	}

	public void setNuevogen(Generador nuevogen) {
		this.nuevogen = nuevogen;
	}

	public Electrodos getNuevoelec() {
		return nuevoelec;
	}

	public void setNuevoelec(Electrodos nuevoelec) {
		this.nuevoelec = nuevoelec;
	}

	public boolean isUsaLector() {
		return usaLector;
	}

	public void setUsaLector(boolean usaLector) {
		this.usaLector = usaLector;
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
	
	public void cambiaConjunto(ActionEvent e){
		
	}
	
	private String obtenerConectorVi(){
		if(this.listaelectrodos!=null)
			for(ImpImplanteElectrodos e:this.listaelectrodos){
				if(e.getCamara().equals(950) && e.getEstado().equals(0))
					return e.getConector();
			}
		return null;
	}
	private String obtenerPolaridadVi(){
		if(this.listaelectrodos!=null)
			for(ImpImplanteElectrodos e:this.listaelectrodos){
				if(e.getCamara().equals(950) && e.getEstado().equals(0))
					return e.getPolaridad();
			}
		return null;
	}
	private Integer obtenerVectorVi1(){
		if(this.listaelectrodos!=null)
			for(ImpImplanteElectrodos e:this.listaelectrodos){
				if(e.getCamara().equals(950) && e.getEstado().equals(0))
					return e.getVectorvi1();
			}
		return null;
	}
	// Precarga de conjunto de valores de vectores de estimulacion de VI
	
	public ArrayList<SelectItem> getVectorinicial() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		// Control inicial de conector de electrodo VI
		String conector_vi = obtenerConectorVi();
		String pol_vi = obtenerPolaridadVi();
		if(conector_vi!=null && !conector_vi.equals("")){
			if(conector_vi.equals("IS-4")){
				e.add(new SelectItem(1, "VI1"));
				e.add(new SelectItem(2, "VI2"));
				e.add(new SelectItem(3, "VI3"));
				e.add(new SelectItem(4, "VI4"));
			}else if(conector_vi.equals("IS-1")){
				e.add(new SelectItem(5, "VI punta"));
				if(pol_vi!=null && !pol_vi.equals("")){
					if(pol_vi.equals("BI"))
						e.add(new SelectItem(6, "VI anillo"));
				}else
					e.add(new SelectItem(6, "VI anillo"));
			}
		}else{ // sin valor de conector -> carga todas
			e.add(new SelectItem(1, "VI1"));
			e.add(new SelectItem(2, "VI2"));
			e.add(new SelectItem(3, "VI3"));
			e.add(new SelectItem(4, "VI4"));
			e.add(new SelectItem(5, "VI punta"));
			if(pol_vi!=null && !pol_vi.equals("")){
				if(pol_vi.equals("BI"))
					e.add(new SelectItem(6, "VI anillo"));
			}else
				e.add(new SelectItem(6, "VI anillo"));
		}
		e.add(new SelectItem(7, "VD punta"));
		e.add(new SelectItem(8, "VD anillo"));
		if(this.getTipogen()==4)
			e.add(new SelectItem(9, "VD bobina"));
		e.add(new SelectItem(10, "Carcasa"));
		e.add(new SelectItem(-1, "Desconocido"));
		return e;
	}
	
	public ArrayList<SelectItem> getVectorfinal(){
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		Integer vector1 = obtenerVectorVi1();
		String conector_vi = obtenerConectorVi();
		String pol_vi = obtenerPolaridadVi();
		if(vector1!=null){
			if(vector1>=1 && vector1<=6){ // carga de valores de Vd + VI
				for(int i=1;i<=6;i++){
					if(i!=vector1){
						if(i<=4 && vector1<=4)
							if((conector_vi!=null && !conector_vi.equals("") && conector_vi.equals("IS-4"))
									|| conector_vi==null || conector_vi.equals(""))
								e.add(new SelectItem(i, "VI"+i));
						if(i==5 && vector1>4)
							if(conector_vi!=null && conector_vi.equals("IS-1") || conector_vi==null || conector_vi.equals(""))
								e.add(new SelectItem(5, "VI punta"));
						if(i==6 && vector1>4)
							if((conector_vi!=null && conector_vi.equals("IS-1") && pol_vi!=null && pol_vi.equals("BI")) 
									|| pol_vi==null || pol_vi.equals(""))
								e.add(new SelectItem(6, "VI anillo"));
					}
				}
				e.add(new SelectItem(7, "VD punta"));
				if(pol_vi!=null && pol_vi.equals("BI"))
					e.add(new SelectItem(8, "VD anillo"));
				else
					e.add(new SelectItem(8, "VD anillo"));
				if(this.getTipogen()==4)
					e.add(new SelectItem(9, "VD bobina"));
				e.add(new SelectItem(10, "Carcasa"));
			}else if(vector1>=7 && vector1<=10){// carga de valores de Vi
				if(conector_vi!=null && !conector_vi.equals("")){
					if(conector_vi.equals("IS-4")){
						e.add(new SelectItem(1, "VI1"));
						e.add(new SelectItem(2, "VI2"));
						e.add(new SelectItem(3, "VI3"));
						e.add(new SelectItem(4, "VI4"));
					}else if(conector_vi.equals("IS-1")){
						e.add(new SelectItem(5, "VI punta"));
						if(pol_vi!=null && !pol_vi.equals("")){
							if(pol_vi.equals("BI"))
								e.add(new SelectItem(6, "VI anillo"));
						}else
							e.add(new SelectItem(6, "VI anillo"));
					}
				}else{ // sin valor de conector -> carga todas pero separando opciones. Si se ha cogido opcion VIi, debe solo poder
					e.add(new SelectItem(1, "VI1"));
					e.add(new SelectItem(2, "VI2"));
					e.add(new SelectItem(3, "VI3"));
					e.add(new SelectItem(4, "VI4"));
					e.add(new SelectItem(5, "VI punta"));
					if(pol_vi!=null && !pol_vi.equals("")){
						if(pol_vi.equals("BI"))
							e.add(new SelectItem(6, "VI anillo"));
					}else
						e.add(new SelectItem(6, "VI anillo"));
				}
			}	
		}
		e.add(new SelectItem(-1, "Desconocido"));
		return e;
	}

	public String getSelectedtab() {
		return selectedtab;
	}

	public void setSelectedtab(String selectedtab) {
		this.selectedtab = selectedtab;
	}
	
	public void cargaRecomendaciones(ActionEvent e){
		if(this.previoimp){// recambio
			this.hev.setRecomendaciones("- COMPRESIÓN SOBRE EL APÓSITO 1 HORA POSTINTERVENCIÓN." +
					"\n- HIELO LOCAL 20  MINUTOS CADA 4 HORAS DURANTE 24 HORAS RESPETANDO SUEÑO NOCTURNO." +
					"\n- EVITAR ELEVAR  EL BRAZO IZQUIERDO  DURANTE 48 H." +
					"\n- CURA DIARIA DE LA HERIDA QUIRÚRGICA CON BETADINE. CUBRIR CON APÓSITO TRAS CADA CURA." +
					"\n- PAUTAR ANALGESIA  DURANTE 24 H." +
					"\n- PROFILAXIS ANTIBIOTICA YA REALIZADA." +
					"\n- REMITIR A CONSULTA DE MARCAPASOS (PLANTA xª) ANTES DE SER DADO DE ALTA HOSPITALARIA." +
					"\n- SE RETIRARÁN LAS GRAPAS EN CONSULTA DE MCP EN 7 DIAS.");
		}else{// primo implante
			this.hev.setRecomendaciones("- COMPRESIÓN SOBRE EL APÓSITO LA PRIMERA HORA POSTINTERVENCIÓN." +
					"\n- HIELO LOCAL 20  MINUTOS CADA 4 HORAS DURANTE 24 HORAS RESPETANDO SUEÑO NOCTURNO." +
					"\n- EVITAR ELEVAR  EL BRAZO IZQUIERDO  DURANTE 48 H." +
					"\n- CURA DIARIA DE LA HERIDA QUIRÚRGICA CON BETADINE. CUBRIR CON APÓSITO TRAS CADA CURA." +
					"\n- PAUTAR ANALGESIA ( METAMIZOL O PARACETAMOL)." +
					"\n- PROFILAXIS ANTIBIOTICA YA REALIZADA." +
					"\n- REMITIR A  CONSULTA DE MCP ANTES DEL ALTA HOSPITALARIA." +
					"\n- SE RETIRARÁN LAS GRAPAS EN CONSULTA DE MCP EN 7 DIAS.");
		}
	}

	public boolean isNgen() {
		return ngen;
	}

	public void setNgen(boolean ngen) {
		this.ngen = ngen;
	}

	public boolean isNelec() {
		return nelec;
	}

	public void setNelec(boolean nelec) {
		this.nelec = nelec;
	}

	public Integer getLineanuevogen() {
		return lineanuevogen;
	}

	public void setLineanuevogen(Integer lineanuevogen) {
		this.lineanuevogen = lineanuevogen;
	}

	public Integer getLineanuevoelec() {
		return lineanuevoelec;
	}

	public void setLineanuevoelec(Integer lineanuevoelec) {
		this.lineanuevoelec = lineanuevoelec;
	}

	public Integer getTipoprocmanual() {
		return tipoprocmanual;
	}

	public void setTipoprocmanual(Integer tipoprocmanual) {
		this.tipoprocmanual = tipoprocmanual;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public ComplicacionesPacientes getCompac() {
		return compac;
	}

	public void setCompac(ComplicacionesPacientes compac) {
		this.compac = compac;
	}

	public ArrayList<ComplicacionesPacientes> getListacomp() {
		return listacomp;
	}

	public void setListacomp(ArrayList<ComplicacionesPacientes> listacomp) {
		this.listacomp = listacomp;
	}

	public HtmlDataTable getBindingComplicacionesImpProc() {
		return bindingComplicacionesImpProc;
	}

	public void setBindingComplicacionesImpProc(
			HtmlDataTable bindingComplicacionesImpProc) {
		this.bindingComplicacionesImpProc = bindingComplicacionesImpProc;
	}

	public ComplicacionesPacientes getCurrentItemComp() {
		return currentItemComp;
	}

	public void setCurrentItemComp(ComplicacionesPacientes currentItemComp) {
		this.currentItemComp = currentItemComp;
	}

	public boolean isEditableImpProc() {
		return editableImpProc;
	}

	public void setEditableImpProc(boolean editableImpProc) {
		this.editableImpProc = editableImpProc;
	}

	public ComplicacionesPacientes getCompacpost() {
		return compacpost;
	}

	public void setCompacpost(ComplicacionesPacientes compacpost) {
		this.compacpost = compacpost;
	}

	public HtmlDataTable getBindingComplicacionesImpProcPost() {
		return bindingComplicacionesImpProcPost;
	}

	public void setBindingComplicacionesImpProcPost(
			HtmlDataTable bindingComplicacionesImpProcPost) {
		this.bindingComplicacionesImpProcPost = bindingComplicacionesImpProcPost;
	}

	public ArrayList<ComplicacionesPacientes> getListacomppost() {
		return listacomppost;
	}

	public void setListacomppost(ArrayList<ComplicacionesPacientes> listacomppost) {
		this.listacomppost = listacomppost;
	}

	public boolean isEditableImpEvProc() {
		return editableImpEvProc;
	}

	public void setEditableImpEvProc(boolean editableImpEvProc) {
		this.editableImpEvProc = editableImpEvProc;
	}

	public ComplicacionesPacientes getCurrentItemCompPost() {
		return currentItemCompPost;
	}

	public void setCurrentItemCompPost(ComplicacionesPacientes currentItemCompPost) {
		this.currentItemCompPost = currentItemCompPost;
	}

}

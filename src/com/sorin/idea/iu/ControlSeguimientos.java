package com.sorin.idea.iu;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.ResourceBundle;

import hvn.cm.modelo.Mensaje;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.apache.myfaces.custom.schedule.ScheduleMouseEvent;
import org.apache.myfaces.custom.schedule.model.DefaultScheduleEntry;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.jsflot.components.FlotChartRendererData;
import org.jsflot.xydata.XYDataList;
import org.jsflot.xydata.XYDataPoint;
import org.jsflot.xydata.XYDataSetCollection;
import org.richfaces.component.html.HtmlDataGrid;

import com.sorin.idea.dao.AgendaDao;
import com.sorin.idea.dao.AgendacitaDao;
import com.sorin.idea.dao.ComplicacionDao;
import com.sorin.idea.dao.ElectrodosDao;
import com.sorin.idea.dao.EpisodioDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dao.ImpAtpDao;
import com.sorin.idea.dao.ImpChoquesDao;
import com.sorin.idea.dao.ImpEvolucionDao;
import com.sorin.idea.dao.ImpGeneradorDao;
import com.sorin.idea.dao.ImpHojaImplantePopDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.ImpImplanteElectrodosDao;
import com.sorin.idea.dao.ImpZonaDao;
import com.sorin.idea.dao.InformesDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.SegBloqueosDao;
import com.sorin.idea.dao.SegComplicacionesDao;
import com.sorin.idea.dao.SegObservacionesDaiDao;
import com.sorin.idea.dao.SegObservacionesMpDao;
import com.sorin.idea.dao.SegPorestimulacionDao;
import com.sorin.idea.dao.SegSeguimientoDao;
import com.sorin.idea.dao.SegSintomasDao;
import com.sorin.idea.dao.SegSistemaDao;
import com.sorin.idea.dao.SegSituacionclinicaDao;
import com.sorin.idea.dao.SintomasSitclinProcDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dto.Agenda;
import com.sorin.idea.dto.Agendacita;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Complicacion;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.EpisodioPk;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.EventoPk;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpAtp;
import com.sorin.idea.dto.ImpAtpPk;
import com.sorin.idea.dto.ImpChoques;
import com.sorin.idea.dto.ImpChoquesPk;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpEvolucionComplicacion;
import com.sorin.idea.dto.ImpEvolucionComplicacionPk;
import com.sorin.idea.dto.ImpEvolucionPk;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.ImpHojaImplanteComplicacionPk;
import com.sorin.idea.dto.ImpHojaImplanteEnf;
import com.sorin.idea.dto.ImpHojaImplantePop;
import com.sorin.idea.dto.ImpHojaImplanteSop;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpImplanteElectrodosPk;
import com.sorin.idea.dto.ImpSintomas;
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.ImpZonaPk;
import com.sorin.idea.dto.Informes;
import com.sorin.idea.dto.InformesPk;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.SegBloqueos;
import com.sorin.idea.dto.SegBloqueosPk;
import com.sorin.idea.dto.SegComplicaciones;
import com.sorin.idea.dto.SegComplicacionesPk;
import com.sorin.idea.dto.SegObservacionesDai;
import com.sorin.idea.dto.SegObservacionesDaiPk;
import com.sorin.idea.dto.SegObservacionesMp;
import com.sorin.idea.dto.SegObservacionesMpPk;
import com.sorin.idea.dto.SegPorestimulacion;
import com.sorin.idea.dto.SegPorestimulacionPk;
import com.sorin.idea.dto.SegSeguimiento;
import com.sorin.idea.dto.SegSeguimientoPk;
import com.sorin.idea.dto.SegSintomas;
import com.sorin.idea.dto.SegSintomasPk;
import com.sorin.idea.dto.SegSistema;
import com.sorin.idea.dto.SegSistemaPk;
import com.sorin.idea.dto.SegSituacionclinica;
import com.sorin.idea.dto.SegSituacionclinicaPk;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SintomasSitclinProcPk;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.SituacionClinicaProcPk;
import com.sorin.idea.exceptions.ElectrodosDaoException;
import com.sorin.idea.exceptions.EventoDaoException;
import com.sorin.idea.exceptions.GeneradorDaoException;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.exceptions.SituacionClinicaGeneralDaoException;
import com.sorin.idea.jdbc.AgendaDaoImpl;
import com.sorin.idea.jdbc.AgendacitaDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpAtpDaoImpl;
import com.sorin.idea.jdbc.ImpChoquesDaoImpl;
import com.sorin.idea.jdbc.ImpEvolucionDaoImpl;
import com.sorin.idea.jdbc.ImpGeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplantePopDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteElectrodosDaoImpl;
import com.sorin.idea.jdbc.ImpZonaDaoImpl;
import com.sorin.idea.jdbc.InformesDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.SegBloqueosDaoImpl;
import com.sorin.idea.jdbc.SegComplicacionesDaoImpl;
import com.sorin.idea.jdbc.SegObservacionesDaiDaoImpl;
import com.sorin.idea.jdbc.SegObservacionesMpDaoImpl;
import com.sorin.idea.jdbc.SegPorestimulacionDaoImpl;
import com.sorin.idea.jdbc.SegSeguimientoDaoImpl;
import com.sorin.idea.jdbc.SegSintomasDaoImpl;
import com.sorin.idea.jdbc.SegSistemaDaoImpl;
import com.sorin.idea.jdbc.SegSituacionclinicaDaoImpl;
import com.sorin.idea.jdbc.SintomasSitclinProcDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.EstadisticasBasicas;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.GestorNomenclatura;
import com.sorin.idea.util.ImplanteSeguimientoBean;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.NotasPreviasBean;
import com.sorin.idea.util.PreconsultaBean;
import com.sorin.idea.util.UtilAgenda;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilFiles;
import com.sorin.idea.util.UtilMapeos;
import com.sorin.idea.util.UtilReporteInformes;

public class ControlSeguimientos extends BaseIU {

	private static Logger logger = Logger.getLogger(ControlSeguimientos.class);
	private LoginForm lf;
	private String usuario="";
	private ControlPacientes cp;
	private ControlImplantes cimp;
	private ControlMaestras cm;
	private SelectorIdioma si;
	private ResourceBundle bundle;
	
	private Properties prop;
	private int TAM_HUECO;
	private int TOTAL_HUECOS;
	private int HUECO_SEG_MPS;
	private int HUECO_SEG_DAI;
	private int HUECO_SEG_CRTP;
	private int HUECO_SEG_CRTD;
	private int WORKING_INI;
	private int WORKING_FIN;
	private boolean pleno;
	
	private ArrayList<Date> huecoslibresdiarios;
	private ArrayList<Date> huecosdisponibles;

	private Procedimiento[] lstprocs;
	private Procedimiento[] lstprocsseg;
	private ProcedimientoDao procdao;

	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ArrayList<Procedimiento> procs;
	private SegSeguimiento seg;
	private SegSeguimientoDao segdao;
	private SegSeguimientoPk segpk;
	private SituacionClinicaProc sitclin;
	private SituacionClinicaProcDao sitclindao;
	private SituacionClinicaProcPk sitclinpk;
	
	private SegSistema sist;
	private SegSistemaDao sistdao;
	private SegSistemaPk sistpk;
	private SegBloqueos bloq;
	private SegBloqueosDao bloqdao;
	private SegBloqueosPk bloqpk;
	private SegPorestimulacion por;
	private SegPorestimulacionDao pordao;
	private SegPorestimulacionPk porpk;
	private SegObservacionesMp obsmp;
	private SegObservacionesMpDao obsmpdao;
	private SegObservacionesMpPk obsmppk;
	private SegObservacionesDai obsdai;
	private SegObservacionesDaiDao obsdaidao;
	private SegObservacionesDaiPk obsdaipk;
	private ImpEvolucion hev;// La programacion sera un objeto evolucion de implante
	private ImpEvolucionDao hevdao;
	private ImpEvolucionPk hevpk;

	private SintomasSitclinProcDao sintsegdao;
	private ImpImplanteDao impdao;
	private ImpImplante[] listaimpl;

	private ArrayList<ImpGenerador> listagenerador;
	private ImpGeneradorDao gendao;
	private ArrayList<ImpImplanteElectrodos> listaelectrodosseg;
	private ArrayList<ImpImplanteElectrodosPk> listaelectrodospk;
	private ImpImplanteElectrodosDao impelecdao;

	private GeneradorDao generadoresdao;
	private Generador[] generadores;
	private ElectrodosDao electrodosdao;
	private Electrodos[] electrodos;
	private ImpEvolucion[] evoluciones;
	private ImpEvolucionDao evodao;
	private ImpZonaDao zonadao;
	private ImpAtpDao atpdao;
	private ImpChoquesDao choquedao;
	private ArrayList<ImpZonaPk> listazonapk;
	private ArrayList<ImpAtpPk> listaatppk;
	private ArrayList<ImpChoquesPk> listachoquespk;

	private ComplicacionDao compdao;
	private Complicacion[] complicacionesseg;
	private ArrayList<SegComplicaciones> listacomplicaciones;
	private SegComplicacionesDao compsegdao;
	private ArrayList<SelectItem> lcompsegtec;
	private ArrayList<SelectItem> lcompsegarr;
	private ArrayList<SelectItem> lcompsegproc;
	private ArrayList<SelectItem> lcompsegresp;
	private ArrayList<SelectItem> lcompsegmuerte;

	private HtmlDataTable bindingGen;
	private HtmlDataTable bindingElec;
	private HtmlDataTable bindingComplicaciones;
	private HtmlDataTable bindingSintomas;
	private HtmlDataGrid bindingGrid;
	private HtmlDataTable bindingChoques;

	private ArrMaestras[] tipoproc;
	private ArrMaestras[] localizaciongen;
	private ArrMaestras[] sintomas;
	private ArrMaestras[] ritmos;
	private ArrMaestras[] ritmostv;
	private ArrMaestras[] ritmosfa;
	private ArrMaestras[] ritmossa;
	private ArrMaestras[] conducciones;
	private ArrMaestras[] conduccionavotros;
	private ArrMaestras[] qrs;
	private ArrMaestras[] qrsotros;
	private ArrMaestras[] cardiopatia;
	private ArrMaestras[] tipocomplicacion;
	private ArrMaestras[] viaaccesoimplante;
	private ArrMaestras[] camara;
	private ArrMaestras[] lateralidad;
	private ArrMaestras[] zonacamaraad;
	private ArrMaestras[] zonacamaravd;
	private ArrMaestras[] zonacamaravi;
	private ArrMaestras[] zonacamarasicd;
	private ArrMaestras[] zonaepicardico;
	private ArrMaestras[] porcion;
	private ArrMaestras[] modogen;
	private ArrMaestras[] primerop;
	private ArrMaestras[] enfop;
	private ArrMaestras[] motivosterapianoapropiada;
	
	private String columna = "fecha";
	private boolean ascendente = false;
	private HtmlDataTable bindingBuscar;

	// Variables de control general
	private boolean segRem;
	private boolean minEstVent;
	private int tipogen;
	private String modogenini;
	private boolean avzona;
	private int optint;
	private boolean segprevio;
	private boolean cablea;
	private boolean cablev;
	private boolean actualizacion;
	private boolean previmp;
	private int idimp;
	private boolean completado;
	private boolean reintervencion;
	private InfoCentro infocentro;
	private boolean hayVI;
	private SituacionClinicaGeneral sgen;
	private boolean modsitclin;
	//private String modogenini;
	
	private Informes inf;
	private InformesDao infdao;
	
	private EpisodioDao epdao;
	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	
	private Evento evento;
	private Episodio episodio;
	private Agenda agenda;
	private EventoDao evdao;
	private AgendaDao agdao;
	private AgendacitaDao agcitadao;
	private String duracion_evento;
	
	/**************************
	 * ESTADISTICAS************
	 **************************/
	private FlotChartRendererData chartDataSitClinFevi;
	private FlotChartRendererData chartDataBatV;
	private FlotChartRendererData chartDataBatImp;
	private FlotChartRendererData chartDataElecOndaRP;
	private FlotChartRendererData chartDataElecUmbralV;
	private FlotChartRendererData chartDataElecImpedancia;
	private FlotChartRendererData chartDataElecDurImp;
	private FlotChartRendererData chartDataElecAmpl;
	private FlotChartRendererData chartDataElecSens;
	XYDataList valoressitclinfevi;
	XYDataList valoresbatv;
	XYDataList valoresbatimp;
	ArrayList<XYDataList> valoreselecondarp;
	ArrayList<XYDataList> valoreselecumbralv;
	ArrayList<XYDataList> valoreselecimpedancia;
	ArrayList<XYDataList> valoreselecdurimp;
	ArrayList<XYDataList> valoreselecampl;
	ArrayList<XYDataList> valoreselecsens;
	private boolean adicionales;
	
	//////////////////
	private ArrayList<SelectItem> vectorinicial;
	private ArrayList<SelectItem> vectorfinal; 
	private ArrayList<NotasPreviasBean> notasprevias;
	private HtmlDataTable bindingNotasPrevias;
	private Integer pagina_inicial = 1;
	
	private boolean editable;
	private boolean muestraModalNuevoSeg;
	private ArrayList<Procedimiento> listanuevosseg;
	private ArrayList<Procedimiento> listaseg;
	private HtmlDataTable bindingNuevosSeg;
	
	private ControlComplicaciones cc;
	private ComplicacionesPacientes compac;
	private ComplicacionesPacientes currentItemComp;
	private HtmlDataTable bindingComplicacionesSegProc;
	private ArrayList<ComplicacionesPacientes> listacomp;
	private boolean editableSegProc;
	
	public void iniciaSeguimientos(ActionEvent e) {
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			this.setEditable(true);
			this.cargaMaestras();
			this.cargaGeneradores();
			this.cargaElectrodos();
			lecturaProperties();
			this.huecosdisponibles = new ArrayList<Date>();
			this.huecoslibresdiarios = new ArrayList<Date>();
			this.setHayVI(false);
			this.setProc(new Procedimiento());
			this.setSeg(new SegSeguimiento());
			this.seg.setFecha(new Date());
			this.setSitclin(new SituacionClinicaProc());
			this.setSist(new SegSistema());
			this.setBloq(new SegBloqueos());
			this.setPor(new SegPorestimulacion());
			this.setObsmp(new SegObservacionesMp());
			this.setObsdai(new SegObservacionesDai());
			this.setListacomplicaciones(new ArrayList<SegComplicaciones>());
			this.cargaComplicacionesSeg();
			this.setHev(new ImpEvolucion());
			this.setTipogen(1);
			this.setCablea(false);
			this.setCablev(false);
			this.setSegprevio(false);
			this.setActualizacion(false);
			this.setReintervencion(false);
			this.setCompletado(false);
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			this.agdao = new AgendaDaoImpl(this.usuario);
			this.evento = new Evento();
			this.evento.setHora_ini("00");
			this.evento.setMin_ini("00");
			this.episodio = new Episodio();
			this.agenda = this.agdao.findByPrimaryKey(1);
			this.agenda.getModel().setMode(0);// vista diaria
			this.agenda.getSchedule().setWorkingStartHour(this.WORKING_INI);
			this.agenda.getSchedule().setWorkingEndHour(this.WORKING_FIN);
			// Obtencion de informacion de huecos general
			if(this.agenda.getSchedule().getWorkingEndHour() > this.agenda.getSchedule().getWorkingStartHour())
				this.TOTAL_HUECOS = (this.agenda.getSchedule().getWorkingEndHour() - this.agenda.getSchedule().getWorkingStartHour())*60/this.TAM_HUECO;
			else
				this.TOTAL_HUECOS = 20;// al voleo -- revisar 
			this.agcitadao = new AgendacitaDaoImpl(this.usuario);
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,
						"No ha seleccionado paciente o no se ha podido recuperar.");
			} else {
			}
			this.cimp = (ControlImplantes) getBean("controlImplantes");
			if(cimp==null)
				cimp = new ControlImplantes();
			else{		
			}
			this.cc = (ControlComplicaciones) getBean("controlComplicaciones");
			if(this.cc == null)
				this.cc = new ControlComplicaciones();
			this.cc.inicia(null); // importante
			
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.procpk = new ProcedimientoPk();
			this.impdao = new ImpImplanteDaoImpl(this.usuario);
			this.gendao = new ImpGeneradorDaoImpl(this.usuario);
			this.generadoresdao = new GeneradorDaoImpl(this.usuario);
			this.impelecdao = new ImpImplanteElectrodosDaoImpl(this.usuario);
			this.electrodosdao = new ElectrodosDaoImpl(this.usuario);
			this.setListaelectrodospk(new ArrayList<ImpImplanteElectrodosPk>());
			this.evodao = new ImpEvolucionDaoImpl(this.usuario);			
			this.zonadao = new ImpZonaDaoImpl(this.usuario);
			this.atpdao = new ImpAtpDaoImpl(this.usuario);
			this.choquedao = new ImpChoquesDaoImpl(this.usuario);
			this.setListazonapk(new ArrayList<ImpZonaPk>());
			this.setListaatppk(new ArrayList<ImpAtpPk>());
			this.setListachoquespk(new ArrayList<ImpChoquesPk>());
			this.sitclinpk = new SituacionClinicaProcPk();
			this.sitclindao = new SituacionClinicaProcDaoImpl(this.usuario);
			this.sistpk = new SegSistemaPk();
			this.sistdao = new SegSistemaDaoImpl(this.usuario);
			this.bloqpk = new SegBloqueosPk();
			this.bloqdao = new SegBloqueosDaoImpl(this.usuario);
			this.porpk = new SegPorestimulacionPk();
			this.pordao = new SegPorestimulacionDaoImpl(this.usuario);
			this.obsmppk = new SegObservacionesMpPk();
			this.obsmpdao = new SegObservacionesMpDaoImpl(this.usuario);
			this.obsdaipk = new SegObservacionesDaiPk();
			this.obsdaidao = new SegObservacionesDaiDaoImpl(this.usuario);
			this.compsegdao = new SegComplicacionesDaoImpl(this.usuario);
			this.sintsegdao = new SintomasSitclinProcDaoImpl(this.usuario);
			this.hevdao = new ImpEvolucionDaoImpl(this.usuario);
			this.segdao = new SegSeguimientoDaoImpl(this.usuario);
			this.inf = new Informes();
			this.infdao = new InformesDaoImpl(this.usuario);
			this.episodios = new ArrayList<EpisodioDto>();
			this.compac = new ComplicacionesPacientes();
			this.compac.setFechaini(this.seg.getFecha());
			this.compac.setTipo(1);
			this.setEditableSegProc(false);
			this.currentItemComp = new ComplicacionesPacientes();
			this.listacomp = new ArrayList<ComplicacionesPacientes>();
			this.procs = new ArrayList<Procedimiento>();
			//this.lstsegs = new ArrayList<UtilListaSeguimientos>();
			this.lstprocs = this.procdao.findByDynamicWhere(
							"CODIGO =? AND (TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?)",
							new Object[] {this.cp.getPacienteSelect().getCodigo(),956,957,993,1059,1060,1085,1086,1147,1090});
			// Lista de procesos de seguimiento
			this.lstprocsseg = this.procdao.findByDynamicWhere("CODIGO =? AND (TIPOPROCEDIMIENTO = ?)",
					new Object[] {this.cp.getPacienteSelect().getCodigo(),983 });
			this.listaseg = new ArrayList<Procedimiento>();
			this.listanuevosseg = new ArrayList<Procedimiento>();
			for(int i=0;i<this.lstprocsseg.length;i++){
				this.procs.add(this.lstprocsseg[i]);
				this.listaseg.add(this.lstprocsseg[i]);
				this.setSegprevio(true);
			}
			if (this.lstprocs.length > 0) {
				this.setPrevimp(true);
				this.recuperaSistema();
			} else
				this.setPrevimp(false);
			cargaSituacionClinica();
			// inicializa charts de estadistica
			if(this.valoressitclinfevi!=null)
				this.valoressitclinfevi.clear();
			if(this.valoresbatimp!=null)
				this.valoresbatimp.clear();
			if(this.valoresbatv!=null)
				this.valoresbatv.clear();
			if(this.valoreselecondarp!=null)
				this.valoreselecondarp.clear();
			if(this.valoreselecimpedancia!=null)
				this.valoreselecimpedancia.clear();
			if(this.valoreselecumbralv!=null)
				this.valoreselecumbralv.clear();
			if(this.valoreselecdurimp!=null)
				this.valoreselecdurimp.clear();
			if(this.valoreselecampl!=null)
				this.valoreselecampl.clear();
			if(this.valoreselecsens!=null)
				this.valoreselecsens.clear();
			this.setAdicionales(false);
			// Genera estadisticas iniciales: bateria y electrodos
			this.generarEstadisticasSitClin(null);
			this.generarEstadisticasBateria(null);
			this.generarEstadisticasElectrodos(null);
			// cargar notas previas
			this.notasprevias = new ArrayList<NotasPreviasBean>();
			if(cp.getPacienteSelect().getCodigo()!=null){
				ArrayList<ArrayList<Object>> notas_prev_seg = this.procdao.getComentariosProcSeg(this.cp.getPacienteSelect().getCodigo());
				ArrayList<ArrayList<Object>> notas_prev_imp = this.procdao.getComentariosProcImp(this.cp.getPacienteSelect().getCodigo());
				// Solo se introduciran notas donde los comentarios sean no nulos y no vacios
				for(int i=0;i<notas_prev_imp.size();i++){
					String c1 = (String)notas_prev_imp.get(i).get(1);
					String c2 = (String)notas_prev_imp.get(i).get(2);
					if(c1!=null || c2!=null){
						this.notasprevias.add(new NotasPreviasBean((Date)notas_prev_imp.get(i).get(0),(Integer)notas_prev_imp.get(i).get(3)
								,(String)notas_prev_imp.get(i).get(1),(String)notas_prev_imp.get(i).get(2)));
					}
				}
				for(int i=0;i<notas_prev_seg.size();i++){
					String c1 = (String)notas_prev_seg.get(i).get(1);
					String c2 = (String)notas_prev_seg.get(i).get(2);
					if(c1!=null || c2!=null){
						this.notasprevias.add(new NotasPreviasBean((Date)notas_prev_seg.get(i).get(0),(Integer)notas_prev_seg.get(i).get(3)
								,(String)notas_prev_seg.get(i).get(1),(String)notas_prev_seg.get(i).get(2)));
					}		
				}
				// Ordenacion por fecha descendente
				Collections.sort(this.notasprevias, new Comparator() {
					public int compare(Object o1, Object o2) {
						NotasPreviasBean e1 = (NotasPreviasBean) o1;
						NotasPreviasBean e2 = (NotasPreviasBean) o2;
						if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())<=0) {
							return 1;
						} else if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())>0) {
							return -1;
						} else {
							return 0;
						}
					}
				});
			}	
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_pat")+": "+ e1.getMessage());
			logger.info("("+this.usuario+") Error iniciando bean seguimientos. Motivo: "+e1.getMessage(),e1);
		}
	}

	public void cargaMaestras() {
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			this.tipoproc = cm.getTipoprocedimiento();
			this.sintomas = cm.getSintomas();
			this.ritmos = cm.getRitmoSinusal();
			this.ritmosfa = cm.getRitmosFA();
			this.ritmossa = cm.getRitmosSA();
			this.ritmostv = cm.getRitmosTV();
			this.conducciones = cm.getConduccionNoNormal();
			this.conduccionavotros = cm.getConduccionAVOtros();
			this.qrs = cm.getQrsNoNormal();
			this.qrsotros = cm.getQRSOtros();
			this.cardiopatia = cm.getCardiopatia();
			// OJO - AHORA PRECARGA LAS POST-OPERATORIO
			this.tipocomplicacion = cm.getTipoComplicacionSeg();
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
			this.modogen = cm.getModoGenerador();
			this.primerop = cm.getPrimerOperador();
			this.enfop = cm.getEnfermeria();
			this.motivosterapianoapropiada = cm.getMotivosTerapiaNoApropiada();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
	}

	public void cargaGeneradores() {
		try {
			this.generadoresdao = new GeneradorDaoImpl(this.usuario);
			this.generadores = this.generadoresdao.findAll();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}

	public void cargaElectrodos() {
		try {
			this.electrodosdao = new ElectrodosDaoImpl(this.usuario);
			this.electrodos = this.electrodosdao.findAll();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}

	public void cargaComplicacionesSeg() {
		try {
			this.compdao = new ComplicacionDaoImpl(this.usuario);
			this.setComplicacionesseg(this.compdao.findWhereCaracterEquals(3));
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_compl")+": "+ e1.getMessage());
		}
	}

	public String getNumeroSeguimientos(){
		try{
			if(this.cp!=null && this.cp.getPacienteSelect()!=null){
				this.setMuestraModalNuevoSeg(false);
				this.listanuevosseg.clear();
				Procedimiento[] prs = this.procdao.findByDynamicWhere("CODIGO = ? AND TIPOPROCEDIMIENTO = ?",
						new Object[] {this.cp.getPacienteSelect().getCodigo(),983});
				if(prs.length>this.listaseg.size()){
					this.setMuestraModalNuevoSeg(true);
					// Obtiene el nuevo seguimiento
					for(Procedimiento p:prs){
						if(!esNuevoSeguimiento(p))
							this.listanuevosseg.add(p);
					}
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("seg_disp_msg_error_cons_numeros")+": "+ e1.getMessage());
		}
		return "";
	}

	private boolean esNuevoSeguimiento(Procedimiento p){
		for(Procedimiento pr:this.listaseg)
			if(p.getIdprocedimiento().equals(pr.getIdprocedimiento()))
				return true;
		// se inserta en la lista de procedimientos de seguimeintos actuales para evitar que salte de nuevo el modal panel
		this.listaseg.add(p);
		return false;
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
				if(ev!=null && ev.getProcedimiento()==983 && ev.getEstado()==1 && proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));
			}
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_epi")+": "+ e1.getMessage());
		}		
	}
	
	public void guarda(ActionEvent e) {
		try {
			if(!validaFormulario()){
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_continuar"));
			} else{
				Integer epi = this.bindingepi.getRowIndex();
				if(epi != null && epi >= 0)
					this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());
				if (this.procpk != null && this.proc.getIdprocedimiento() != null) {
					this.proc.setFecha(this.seg.getFecha());
					// UPDATE
					this.sitclin.setFecha(this.seg.getFecha());
					this.sitclindao.update(this.sitclinpk, this.sitclin);
					this.guardaComponentesSitClin();
					modificaSituacionClinicaGeneral();
					this.sistdao.update(this.sistpk, this.sist);
					this.pordao.update(this.porpk, this.por);
					this.bloqdao.update(this.bloqpk, this.bloq);
					if(this.tipogen == 1){
						this.obsmpdao.update(this.obsmppk, this.obsmp);
					}else if(this.tipogen == 2 || this.tipogen==4){
						this.obsdaidao.update(this.obsdaipk, this.obsdai);
					}
					this.hevdao.update(this.hevpk, this.hev);
					
					guardaComponentesHev();
					// Complicaciones - PENDIENTE DE DEFINICION
					guardaComplicacionesSeguimiento();
					// electrodos
					for(int i=0;i<this.listaelectrodosseg.size();i++){
						this.listaelectrodosseg.get(i).setIdseg(this.seg.getIdseg());
						this.listaelectrodosseg.get(i).setIdevolucion(this.hev.getIdev());
						this.impelecdao.update(this.listaelectrodosseg.get(i).createPk(),this.listaelectrodosseg.get(i));
					}

					this.segdao.update(this.segpk, this.seg);
					
					this.procdao.update(this.procpk, this.proc);					
					// Evento - proximo seguimiento
					this.crearEventoSeguimiento(null);
					// Operacion para actualizar la barra temporal de paciente
					//cp.precarga(null);
					this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
					logger.info("("+this.usuario+") Registro de Seguimiento actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
				} else {
					// INSERT
					this.proc.setFecha(this.seg.getFecha());
					// 1. Situacion clinica - Guardar sintomas
					this.sitclinpk = this.sitclindao.insert(this.sitclin);
					this.sitclin.setIdsitclin(this.sitclinpk.getIdsitclin());
					modificaSituacionClinicaGeneral();
					this.guardaComponentesSitClin();
					// 2. Sistema
					this.sistpk = this.sistdao.insert(this.sist);
					this.sist.setIdsistema(this.sistpk.getIdsistema());
					this.seg.setIdsistema(this.sistpk.getIdsistema());
					// 3. Porcentaje estimulacion
					this.porpk = this.pordao.insert(this.por);
					this.por.setIdporestim(this.porpk.getIdporestim());
					this.seg.setIdporestim(this.porpk.getIdporestim());
					// 4. Bloqueos
					this.bloqpk = this.bloqdao.insert(this.bloq);
					this.bloq.setIdbloqueo(this.bloqpk.getIdbloqueo());
					this.seg.setIdbloqueo(this.bloqpk.getIdbloqueo());
					// 5. Observaciones MP | ObservacionesDAI
					if(this.tipogen == 1){// MP
						this.obsmppk = this.obsmpdao.insert(this.obsmp);
						this.obsmp.setIdobsmp(this.obsmppk.getIdobsmp());
						this.seg.setIdobsmp(this.obsmppk.getIdobsmp());
						this.seg.setIdobsdai(null);
					}else if(this.tipogen == 2 || this.tipogen==4){// DAI o DAI+CRT
						this.obsdaipk = this.obsdaidao.insert(this.obsdai);
						this.obsdai.setIdobsdai(this.obsdaipk.getIdobsdai());
						this.seg.setIdobsdai(this.obsdaipk.getIdobsdai());
						this.seg.setIdobsmp(null);
					}
					// 6. Programacion
					// 6.1 Hojas de programacion
					this.hevpk = this.hevdao.insert(this.hev);
					this.hev.setIdev(this.hevpk.getIdev());
					this.seg.setIdev(this.hevpk.getIdev());
					guardaComponentesHev();
					
					this.seg.setIdimpl(this.getIdimp());
					this.segpk = this.segdao.insert(this.seg);
					this.seg.setIdseg(this.segpk.getIdseg());
					// 7. Complicaciones
					guardaComplicacionesSeguimiento();
					// 8. Electrodos - hay que ponerlos al final para referirlos al IdSeg de Seguimientos
					guardaElectrodos();
					// 9 . Evento - proximo seguimiento
					this.crearEventoSeguimiento(null);
					this.proc.setIdepisodio(this.episodio.getIdepisodio());
					
					this.proc.setFecha(this.seg.getFecha());
					this.proc.setIdprocedimiento(this.seg.getIdseg());
					this.proc.setTipoprocedimiento(983);// Codigo Tipo procedimiento - Seguimiento
					this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
					this.proc.setIdsitclinica(this.sitclin.getIdsitclin());
					this.procpk = this.procdao.insert(this.proc);
					this.setCompletado(true);
					
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
					logger.info("("+this.usuario+") Registro de Seguimiento insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
					this.listaseg.add(this.proc);// incremento para diferenciar la creacion de seguimientos de manera manual y automatica
					// Operacion para actualizar la barra temporal de paciente
					//cp.precarga(null);
					// Control de Reintervencion - Busca si en la lista de complicaciones ha habido alguna indicacion de reintervencion
					for(SegComplicaciones c:this.listacomplicaciones)
						if(c.getResultado().equals("3")){
							this.setReintervencion(true);
							break;
						}	
				}
			}			
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_guarda_error_exep")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede guardar el registro. Error: "+ e1.getMessage());
		}
	}
	private void guardaElectrodos() throws Exception{
		for(ImpImplanteElectrodos e:this.listaelectrodosseg){
			e.setIdhojaimp(null);
			e.setIdevolucion(this.hev.getIdev());
			e.setIdseg(this.seg.getIdseg());
			ImpImplanteElectrodosPk epk = this.impelecdao.insert(e);
			e.setIdimpelectrodos(epk.getIdimpelectrodos());
		}
	}
	private void guardaComponentesSitClin() throws Exception{
		sintsegdao.delete(new SintomasSitclinProcPk(this.sitclin.getIdsitclin(),null));
		for(SintomasSitclinProc sint:this.sitclin.getSintomas()){
			if(sint.getIdsintomas()!=null && sint.getIdsintomas().length() >0){
				sint.setIdsitclin(this.sitclin.getIdsitclin());
				this.sintsegdao.insert(sint);
			}
		}
		this.sitclin.setFecha(this.seg.getFecha());
	}
	private void guardaComponentesHev() throws Exception{
		// Zonas + Atps y Choques
		for(ImpAtpPk atpk:this.listaatppk)
			this.atpdao.delete(atpk);
		for(ImpChoquesPk chpk:this.listachoquespk)
			this.choquedao.delete(chpk);
		for(ImpZonaPk zpk:this.listazonapk)
			this.zonadao.delete(zpk);	
		
		for(ImpZona z:this.hev.getZonas()){
			z.setIdev(this.getHev().getIdev());
			ImpZonaPk zpk = this.zonadao.insert(z);
			z.setIdzona(zpk.getIdzona());
			for(ImpAtp a:z.getAtps()){
				a.setIdzona(z.getIdzona());
				ImpAtpPk apk = this.atpdao.insert(a);
				a.setIdatp(apk.getIdatp());
			}
			if(z.getChqs().size()>0 && (z.getChqs().get(0).getEnergia()!=null)){
				for(ImpChoques ch:z.getChqs()){
					ch.setIdzona(z.getIdzona());
					ImpChoquesPk chpk = this.choquedao.insert(ch);
					ch.setIdzona(chpk.getIdch());
				}
			}	
		}
	}
	private void guardaComplicacionesSeguimiento() throws Exception{
		compsegdao.delete(new SegComplicacionesPk(null,this.seg.getIdseg()));
		for(SegComplicaciones comp:this.listacomplicaciones){
			if(comp.getIdcomp()==null)
				comp.setIdcomp(121);
			comp.setIdseg(this.seg.getIdseg());
			compsegdao.insert(comp);
		}
	}
	public void compruebaImplantes() {
		try {
			this.cp = (ControlPacientes) getBean("controlPacientes");
			this.procdao = new ProcedimientoDaoImpl();
			Procedimiento[] lstprocsaux = null;
			lstprocsaux = this.procdao.findByDynamicWhere(
							"CODIGO =? AND (TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?)",
							new Object[] {this.cp.getPacienteSelect().getCodigo(),956, 957, 993});
			if (lstprocsaux.length > 0) {
				this.setPrevimp(true);
			} else
				this.setPrevimp(false);
		} catch (Exception e1) {

		}
	}
	public void cargaSeguimiento(ActionEvent e){
		//this.proc = this.procs.get(this.getBindingBuscar().getRowIndex());
		//this.proc = cimp.getProcs().get(cimp.getBindingBuscar().getRowIndex()).getSeguimientos().get(cimp.getBindingSeguimientos().getRowIndex());
		this.proc = cimp.getProcs().get(cimp.getBindingBuscar().getRowIndex()).getSeguimientos().get(cimp.getBindingSeguimientos().getRowIndex()).getImplante();
		this.procpk = this.proc.createPk();
		this.setActualizacion(true);
		cargaComponentes();
		cargaEpisodioEventoProxSeguimiento(null);
		this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
	}
	public void cargaSeguimientoDesdeBarraTemporal(ActionEvent e) throws ProcedimientoDaoException{
		try{
			//this.proc = this.procs.get(this.getBindingBuscar().getRowIndex());
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),983})[0];
			this.procpk = this.proc.createPk();
			this.setActualizacion(true);
			cargaComponentes();
			cargaEpisodioEventoProxSeguimiento(null);
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Seguimiento). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_proc_asoc")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Seguimiento). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
		
	}
	public void cargaNuevoSeguimiento(ActionEvent e){
		this.proc = this.listanuevosseg.get(this.getBindingNuevosSeg().getRowIndex());
		this.procpk = this.proc.createPk();
		this.setActualizacion(true);
		cargaComponentes();
		cargaEpisodioEventoProxSeguimiento(null);
		this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
		this.setMuestraModalNuevoSeg(false);
		logger.info("("+this.usuario+") Consulta de registro (Seguimiento). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
	}
	
	public void guardaComplicacion(ActionEvent e){
		this.compac.setIdpaciente(this.cp.getPacienteSelect().getCodigo());
		this.compac.setIdprocedimiento(this.proc.getIdprocedimiento());
		this.compac.setTipoprocedimiento(this.proc.getTipoprocedimiento());
		this.compac.setIdrelacion(3);
		cc.addItemComplicacion(this.compac);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacomp.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacomp.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.compac = new ComplicacionesPacientes();
		this.compac.setFechaini(this.seg.getFecha());
		this.compac.setTipo(1);
	}
	
	public void preEditarSegProc(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		ComplicacionesPacientes aux = this.getListacomp().get(this.bindingComplicacionesSegProc.getRowIndex());	
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
		this.setEditableSegProc(true);
	}
	
	public void actualizaItemComplicacion(ActionEvent e){
		cc.editItemComplicacion(this.currentItemComp);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacomp.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacomp.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.currentItemComp = new ComplicacionesPacientes();
	}
	
	public void cancelarItemComplicacion(ActionEvent e){
		this.setEditableSegProc(false);
	}
	
	public void delItemComplicacion(ActionEvent e){
		Integer pos = this.bindingComplicacionesSegProc.getRowIndex();
		ComplicacionesPacientes item = this.listacomp.get(pos);
		cc.delItemComplicacion(item);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacomp.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacomp.add(cpac);
	}
	
	public void limpiarComp(ActionEvent e){
		this.compac = new ComplicacionesPacientes();
		this.compac.setFechaini(this.seg.getFecha());
		this.compac.setTipo(1);
	}
	
	private void cargaComponentes(){
		try{
			// this.proc.getIdprocedimiento() = id de seguimiento
			// A partir de el, encontramos el implante asociado
			SegSeguimiento[] segs = this.segdao.findWhereIdsegEquals(this.proc.getIdprocedimiento());
			this.setSeg(segs[0]);
			this.segpk = this.seg.createPk();
			this.seg.setSegrem((this.seg.getRemoto()!=null && this.seg.getRemoto()==1)?true:false);
			
			ImpImplante imp = this.impdao.findByPrimaryKey(segs[0].getIdimpl());
			
			ArrayList<Procedimiento> prs = new ArrayList<Procedimiento>();
			for(Procedimiento p:this.lstprocs)
				prs.add(p);
			// obtener ultimo sistema implantado para obtener datos de fecha de implante efectiva del sistema
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
			
			Date fimp_efectiva =obtenerFechaImplanteEfectivo(prs,this.proc.getFecha());
			recuperaGenerador(imp, fimp_efectiva);
			//recuperaElectrodos(segs[0].getIdseg(),2);
			ImpImplanteElectrodos[] elecs = this.impelecdao.findWhereIdsegEquals(this.seg.getIdseg());
			ArrayList<ImpImplanteElectrodos> els = new ArrayList<ImpImplanteElectrodos>();
			for (ImpImplanteElectrodos i : elecs){				
				// Solo debe cargar los electrodos activos o expl-aban parcialmente. Los extraidos completamente no
				if(((i.getEstado()!=2)||(i.getEstado()!=3))&&(i.getCaracter()!=1)){			
					i.setEstimfrenok((i.getEstimfren()!=null)&&(!(i.getEstimfren().equals(""))?true:false));
					i.setNombremodelo(String.valueOf(i.getIdelectrodo()));
					Electrodos e = this.electrodosdao.findByPrimaryKey(i.getIdelectrodo());
					i.setConector(e.getConector()!=null?e.getConector():"");
					i.setFabricante(e.getFabricante()!=null?e.getFabricante():"");
					i.setPolaridad(e.getPolaridad()!=null?e.getPolaridad():"");
					i.setVdd(e.getConector()!=null&&e.getConector().equals("IS-1 BIF")?true:false);
					i.setAbordajetexto(this.componerNombreAbordaje(i));
					els.add(i);	
					this.listaelectrodospk.add(i.createPk());
					if(i.getCamara()==950)// Si hay VI, se activa el flag de estimulacion frenica en sistema
						this.setHayVI(true);
				}
			}		
			this.setListaelectrodosseg(els);
			
			this.setSitclin(this.sitclindao.findByPrimaryKey(this.proc.getIdsitclinica()));
			this.sitclinpk = this.sitclin.createPk();
			SintomasSitclinProc[] sints = sintsegdao.findWhereIdsitclinEquals(this.sitclin.getIdsitclin());
			ArrayList<SintomasSitclinProc> sintarray = new ArrayList<SintomasSitclinProc>();
			for (SintomasSitclinProc s : sints)
				sintarray.add(s);
			this.sitclin.setSintomas(sintarray);
			organizaSituacionClinica();
			
			this.setSist(this.sistdao.findByPrimaryKey(segs[0].getIdsistema()));
			this.sistpk = this.sist.createPk();
			// EOL-ERI
			if(this.sist.getEol()!=null&&this.sist.getEol()==1)
				this.sist.setAuxeoleri(1);
			else if(this.sist.getEri()!=null&&this.sist.getEri()==1)
				this.sist.setAuxeoleri(2);
			else
				this.sist.setAuxeoleri(0);
			
			this.setPor(this.pordao.findByPrimaryKey(segs[0].getIdporestim()));
			this.porpk = this.por.createPk();
			this.setBloq(this.bloqdao.findByPrimaryKey(segs[0].getIdbloqueo()));
			this.bloqpk = this.bloq.createPk();
			this.bloq.setBav((this.bloq.getBav1()!=null || this.bloq.getBav2()!=null || this.bloq.getBav3()!=null)&&(this.bloq.getBav1().length()>0 || this.bloq.getBav2().length()>0
					|| this.bloq.getBav3().length()>0)?true:false);
			if(segs[0].getIdobsmp()!=null){
				this.setObsmp(this.obsmpdao.findByPrimaryKey(segs[0].getIdobsmp()));
				this.obsmppk = this.obsmp.createPk();
				this.obsmp.setArritmiaau((this.obsmp.getArrau()!=null && this.obsmp.getArrau()==1?true:false));
				this.obsmp.setArritmiav((this.obsmp.getArrvent()!=null && this.obsmp.getArrvent()==1)?true:false);
				this.obsmp.setEpisodiosruido((this.obsmp.getEpiruido()!=null && this.obsmp.getEpiruido()==1)?true:false);
				this.obsmp.setCambiomodoarritmiaau((this.obsmp.getCambiomodoarrau()!=null && this.obsmp.getCambiomodoarrau()==1)?true:false);
			}	
			if(segs[0].getIdobsdai()!=null){
				this.setObsdai(this.obsdaidao.findByPrimaryKey(segs[0].getIdobsdai()));
				this.obsdaipk = this.obsdai.createPk();
				this.obsdai.setTeratp((this.obsdai.getAtp()!=null && this.obsdai.getAtp()==1)?true:false);
				this.obsdai.setTerapiaefecatp((this.obsdai.getTodasefecatp()!=null && this.obsdai.getTodasefecatp()==1)?true:false);
				this.obsdai.setTerchoques((this.obsdai.getChoq()!=null && this.obsdai.getChoq()==1)?true:false);
				this.obsdai.setTerapiaefecchoq((this.obsdai.getTodasefectchoq()!=null && this.obsdai.getTodasefectchoq()==1)?true:false);
				this.obsdai.setTerapiaentregada((this.obsdai.isTeratp() || this.obsdai.isTerchoques()
						|| this.obsdai.getTodasapropiadas()!=null)?true:false);
				this.obsdai.setEpisodiosruido((this.obsdai.getEpiruido()!=null && this.obsdai.getEpiruido()==1)?true:false);
				/*this.obsdai.setArritmias((this.obsdai.getNumepisodios()!=null && this.obsdai.getNumepisodios().length()>0
						|| (this.obsdai.isTeratp()) || (this.obsdai.isEpisodiosruido()))?true:false);*/
				if(((this.obsdai.getNumepisodios()!=null && this.obsdai.getNumepisodios().length()>0)
						|| (this.obsdai.isTeratp()) ||(this.obsdai.isTerchoques()) ||(this.obsdai.isEpisodiosruido())))
						this.obsdai.setArritmias(true);
				else
					this.obsdai.setArritmias(false);
			}
				
			this.setHev(this.evodao.findWhereIdevEquals(segs[0].getIdev())[0]);
			this.hevpk = this.hev.createPk();
			// Recuperar zonas - atp y choques
			recuperaZonas(segs[0].getIdev());
			organizaProgramacion();		
			// Complicaciones
			SegComplicaciones[] cintras = compsegdao.findWhereIdsegEquals(this.seg.getIdseg());
			ArrayList<SegComplicaciones> cintarray = new ArrayList<SegComplicaciones>();
			for (SegComplicaciones c : cintras) {
				Complicacion auxcompintra = obtenerComplicacion(this.complicacionesseg, c.getIdcomp());
					c.setTipocomp(auxcompintra.getTipo());
					cintarray.add(c);
			}
			this.setListacomplicaciones(cintarray);
			
			// Obtencion de referencia de informe de seguimiento integrado de prog. o mon. remota almacenado si procede
			// busca por tipoprocedimiento, idprocedimiento y origen != 1 (IDEA)
			Informes[] informes = this.infdao.findByDynamicWhere("IDPROCEDIMIENTO = ? AND TIPOPROCEDIMIENTO = ? AND ORIGEN <> ?", new Object[]{this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento(),1});
			if(informes!=null && informes.length>0)
				this.inf = informes[0];
			else
				this.inf = null;
				
			//this.inf = this.infdao.findByPrimaryKey(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
			
			if(this.inf!=null){
				this.seg.setInformeadj(true);			
			}else
				this.seg.setInformeadj(false);
			
			// 6. complicaciones pacientes
			cc.obtenerComplicacionesPacienteProc(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
			for(ComplicacionesPacientes cpac:cc.getListacompacproc())
				this.listacomp.add(cpac);
			// 7. inicializa complicaciones
			this.compac.setFechaini(this.seg.getFecha());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_sistema")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Seguimiento) - Datos de seguimiento.  Error: "+ e1.getMessage(),e1);
		}
	}
	private Complicacion obtenerComplicacion(Complicacion[] l, Integer i) {
		for (Complicacion c : l) {
			if (c.getIdcompl() == i) {
				return c;
			}
		}
		return null;
	}
	public void recuperaSistema() {
		// Pregunta si hay seguimiento previo
		try {
			// 1. Recuperar Generador - Siempre del ultimo implante ya que en en seguimiento no se toca nada ahi
			// NOTA: La fecha de implante del generador en caso de ser una reintervención, recolocacion de generador o el electrodo hay que tenerla controlada. 
			// 		 Deberia ser las de un primo, recambio, upgrade o reimplante
			Integer fila = null;
			ArrayList<Procedimiento> prs = new ArrayList<Procedimiento>();
			for(Procedimiento p:this.lstprocs)
				prs.add(p);
			// obtener ultimo sistema implantado acorde a la fecha correspondiente del registro actual
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
			Date fimp_efectiva =obtenerFechaImplanteEfectivo(prs, new Date());
			
			ImpImplante imp = this.impdao.findByPrimaryKey(fila);
			this.setIdimp(imp.getIdimplante());
			recuperaGenerador(imp, fimp_efectiva);
			/*
			 * 1. Recuperar electrodos/Programacion - Si hay seguimiento previo:
			 * - Si hay reintervencion determinar si el ultimo implante es
			 * anterior/posterior al ultimo seguimiento. -> Si ultimo implante
			 * es ANTERIOR A ultimo seguimiento -> carga ultimo seguimiento ->
			 * Si no -> carga ultimo implante - Si no hay reintervencion ->
			 * carga ultimo seguimiento - Si NO hay seguimiento previo -> ultimo
			 * implante
			 */
			if (this.isSegprevio()) {
				SegSeguimiento sg = buscaSeguimientosEnImplante(imp.getIdimplante());
				if(sg!=null){
					// Existen seguimientos del ultimo implante y NO hay reintervencion posterior -> Cargar ultimo seguimiento
					recuperaElectrodos(sg.getIdseg(),2);
					this.setHev(this.evodao.findWhereIdevEquals(sg.getIdev())[0]);
					this.getHev().setIdev(null);
					// Recuperar zonas - atp y choques
					recuperaZonas(sg.getIdev());
					organizaProgramacion();
				}else{
					// No existen seguimientos sobre el ultimo implante (es una reintervencion) -> Cargar ultimo implante
					// Se puede comprobar por fechas: FechaImplante (reintervencion) > Fecha Ultimo seguimiento o fecha implante referido por el ultimo seguimiento
					recuperaElectrodos(imp.getIdhojaimp(),1);
					// Recupera Programacion
					this.setHev(this.evodao.findWhereIdevEquals(imp.getIdev())[0]);
					this.getHev().setIdev(null);
					// Recuperar zonas - atp y choques
					recuperaZonas(imp.getIdev());
					organizaProgramacion();
				}
			} else {
				// No hay seguimiento previo - carga info de ultimo implante de paciente
				recuperaElectrodos(imp.getIdhojaimp(),1);
				// Recupera Programacion
				this.setHev(this.evodao.findWhereIdevEquals(imp.getIdev())[0]);
				this.getHev().setIdev(null);
				// Recuperar zonas - atp y choques
				recuperaZonas(imp.getIdev());
				organizaProgramacion();
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_sistema")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Seguimiento) - Datos de sistema implantado.  Error: "+ e1.getMessage(),e1);
		}
	}
	/**
	 * Metodo para buscar la fecha del ultimo implante efectivo asociado al dispositivo del que se hace un seguimiento.
	 * Un implante efectivo será aquel que haya implicado un primoimplante, recambio, upgrade o reimplante ya que supone un cambio efectivo
	 * Las recolocaciones y reintervenciones no se consideran de este tipo
	 * La lista de procedimientos se pasa de antiguo a más nuevo - orden ascencente
	 * @return
	 */
	private Date obtenerFechaImplanteEfectivo(ArrayList<Procedimiento> prs, Date fecha_proc){
		for(int i=prs.size()-1;i>=0;i--){
			if((prs.get(i).getTipoprocedimiento()==956 || prs.get(i).getTipoprocedimiento()==1059 
					|| prs.get(i).getTipoprocedimiento()==1060 || prs.get(i).getTipoprocedimiento()==1090)
					&& UtilFechas.dateDiff(fecha_proc, prs.get(i).getFecha())>=0)
				return prs.get(i).getFecha();
		}
		return null;
	}

	private SegSeguimiento buscaSeguimientosEnImplante(Integer id) throws Exception{
		SegSeguimiento[] segs = this.segdao.findWhereIdimplEquals(id);
		if(segs.length>0){
			return segs[segs.length -1];
		}else
			return null;
	}
	private void recuperaGenerador(ImpImplante imp, Date fechaimpef) {
		try {
			ImpGenerador[] gens = gendao.findWhereIdhojaimpEquals(imp.getIdhojaimp());
			ArrayList<ImpGenerador> genarray = new ArrayList<ImpGenerador>();
			for (int i = 0; i < gens.length; i++) {
				if (gens[i].getMotivoexplante() == null) {
					//Generador aux = this.generadores[(gens[i].getIdgenerador()) - 1];
					Generador aux = this.generadoresdao.findByPrimaryKey(gens[i].getIdgenerador());
					gens[i].setModelo(String.valueOf(aux.getIdgenerador()));
					gens[i].setModo(aux.getModo());
					gens[i].setRf((aux.getRf() != null) && (aux.getRf() == 1) ? "Si" : "No");
					gens[i].setMricomp((aux.getMri() != null) && (aux.getMri() == 1) ? "Si" : "No");
					gens[i].setNombremodelo(aux.getModelo());
					gens[i].setFabricante(aux.getFabricante()!=null?aux.getFabricante():"");
					gens[i].setFechaimplante(fechaimpef);
					genarray.add(gens[i]);
					this.setTipogen(Integer.parseInt(aux.getTipo()));
					this.seg.setFabricante(UtilMapeos.mapeoNombreFabricante(aux.getFabricante()));
					this.setModogenini(aux.getModo());
				}
			}
			this.setListagenerador(genarray);
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_sistema")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Seguimiento) - Generador.  Error: "+ e1.getMessage(),e1);
		}
	}

	private void recuperaElectrodos(Integer id,int codigo) {
		try {
			ImpImplanteElectrodos[] elecs = null;
			if(codigo == 1){ // Implante
				elecs = this.impelecdao.findWhereIdhojaimpEquals(id);
			}else if(codigo ==2){
				elecs = this.impelecdao.findWhereIdsegEquals(id);
			}	
			ArrayList<ImpImplanteElectrodos> els = new ArrayList<ImpImplanteElectrodos>();
			for (ImpImplanteElectrodos i : elecs) {
				if (((i.getEstado() != 2) || (i.getEstado() != 3)) && (i.getCaracter() != 1)) {			
					i.setIdaux(i.getIdimpelectrodos());
					i.setIdhojaimp(null);
					i.setIdevolucion(null);
					i.setIdimpelectrodos(null);	
					i.setNombremodelo(String.valueOf(i.getIdelectrodo()));
					Electrodos e = this.electrodosdao.findByPrimaryKey(i.getIdelectrodo());
					i.setConector(e.getConector()!=null?e.getConector():"");
					i.setFabricante(e.getFabricante()!=null?e.getFabricante():"");
					i.setPolaridad(e.getPolaridad()!=null?e.getPolaridad():"");
					i.setVdd(e.getConector()!=null&&e.getConector().equals("IS-1 BIF")?true:false);
					i.setAbordajetexto(this.componerNombreAbordaje(i));
					els.add(i);
					this.listaelectrodospk.add(i.createPk());
					if(i.getCamara()==950)// Si hay VI, se activa el flag de estimulacion frenica en sistema
						this.setHayVI(true);
				}
			}
			this.setListaelectrodosseg(els);
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_sistema")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Seguimiento) - Electrodos.  Error: "+ e1.getMessage(),e1);
		}
	}

	private void recuperaZonas(Integer id) {
		try {
			ImpZona[] zonas = zonadao.findWhereIdevEquals(id);
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
			// Ordenar el arraylist para presentar adecuadamente. En bbdd se
			// ordena acorde
			// a como vaya llegando, pero hay que presentar la lista ordenada
			// adecuadamente: TV1..TV5-FV. En otro caso, da errores de
			// presentacion y actualizacion
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
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_sistema")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Seguimiento) - Zonas de terapia.  Error: "+ e1.getMessage(),e1);
		}
	}

	private void organizaProgramacion() {
		// 4.2 MP Dependiente
		this.hev.setMpdep((this.hev.getMpdependiente() != null)
				&& (this.hev.getMpdependiente() == 1) ? true : false);
		// 4.3 Seguimiento remoto
		this.hev.setSegrem((this.hev.getSegremoto() != null)
				&& (this.hev.getSegremoto() == 1) ? true : false);
		// 4.4 MEV
		this.hev.setMinestvent((this.hev.getMev() != null)
				&& (this.hev.getMev() == 1) ? true : false);
		// 4.5 Intervalos Dinamicos
		if (this.hev.getIavmax() != null || this.hev.getIavmin() != null)
			this.hev.setIavdinamico(true);
		else
			this.hev.setIavdinamico(false);
		// 4.9 Alg prev FA
		this.hev.setPrevfa((this.hev.getAlgprevfa() != null)
				&& (this.hev.getAlgprevfa() == 1) ? true : false);
		// 4.10 Histeresis
		this.hev.setHist((this.hev.getValorHisteresis() != null)
				&& (!(this.hev.getValorHisteresis().equals("")) ? true : false));
		// 4.11 Estimulacion frenica
		this.hev.setEstimfren((this.hev.getUmbralEstimfren() != null)
				&& (this.hev.getUmbralEstimfren().length() > 0) ? true : false);
	}
	private void organizaSituacionClinica(){
		this.sitclin.setIc(this.sitclin.getNyha()!=null?true:false);
		this.sitclin.setCardiop(this.sitclin.getCardiopatia()!=null?true:false);
		this.sitclin.setRevascularizacion((this.sitclin.getRevasc()!=null && this.sitclin.getRevasc()==1)?true:false);
		this.sitclin.setInfartoprev((this.sitclin.getInfprevio()!=null && this.sitclin.getInfprevio()==1)?true:false);
		
		this.sitclin.setAnteacv((this.sitclin.getAcv()!=null && this.sitclin.getAcv()==1)?true:false);
		this.sitclin.setAnteAIT((this.sitclin.getAit()!=null && this.sitclin.getAit()==1)?true:false);
		this.sitclin.setAnteEPOC((this.sitclin.getEpoc()!=null && this.sitclin.getEpoc()==1)?true:false);
		this.sitclin.setAnteSAHS((this.sitclin.getSahs()!=null && this.sitclin.getSahs()==1)?true:false);
		this.sitclin.setAnteCPAP((this.sitclin.getCpap()!=null && this.sitclin.getCpap()==1)?true:false);
		this.sitclin.setAnteAlcohol((this.sitclin.getIngalcoholica()!=null && this.sitclin.getIngalcoholica()==1)?true:false);
		this.sitclin.setAntediab((this.sitclin.getDiabetes()!=null && this.sitclin.getDiabetes()==1)?true:false);
		this.sitclin.setAnteDislipemia((this.sitclin.getDislipemia()!=null && this.sitclin.getDislipemia()==1)?true:false);
		this.sitclin.setAnteHTA((this.sitclin.getHta()!=null && this.sitclin.getHta()==1)?true:false);
		this.sitclin.setAnteinsrenal((this.sitclin.getInsrenal()!=null && this.sitclin.getInsrenal()==1)?true:false);
		this.sitclin.setAnteNeoplasia((this.sitclin.getNeoplasia()!=null && this.sitclin.getNeoplasia()==1)?true:false);
		this.sitclin.setAntetabaq((this.sitclin.getTabaquismo()!=null && this.sitclin.getTabaquismo()==1)?true:false);
		// Faltaria por poner la nueva situacion clinica -> Neuromediados
		this.sitclin.setAnteTrasplanteCardiaco((this.sitclin.getTrasplantecardiaco()!=null && this.sitclin.getTrasplantecardiaco()==1)?true:false);
		this.sitclin.setAnteSincope((this.sitclin.getSincope() != null)
				&& (this.sitclin.getSincope() == 1) ? true : false);
		this.sitclin.setAnteParadaCardiaca((this.sitclin.getParadacardiaca() != null)
				&& (this.sitclin.getParadacardiaca() == 1) ? true : false);
		this.sitclin.setAnteflutter((this.sitclin.getFlutter() != null) && (this.sitclin.getFlutter() == 1) ? true : false);
	}
	public void compruebaFechas(ActionEvent e) {
		if(this.seg.getFecha()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_act_fechas"));
		else{
			for (Procedimiento p : this.lstprocsseg) {
				if (UtilFechas.dateDiff(this.seg.getFecha(), p.getFecha()) < 0){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_act_fechas_impl_segs"));
					break;	
				}
			}
			for (Procedimiento p : this.lstprocs) {
				if (UtilFechas.dateDiff(this.seg.getFecha(), p.getFecha()) < 0){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_act_fechas_impl_prev"));
					break;	
				}
			}
			this.compac.setFechaini(this.seg.getFecha());
		}	
	}
	public void eliminarSeguimiento(ActionEvent e){
		int auxproc = this.proc.getIdprocedimiento();
		try{
			this.sintsegdao.delete(new SintomasSitclinProcPk(this.sitclin.getIdsitclin(), null));
			for(ImpImplanteElectrodosPk epk:this.listaelectrodospk)
				this.impelecdao.delete(epk);
			this.sistdao.delete(this.sistpk);
			this.bloqdao.delete(this.bloqpk);
			this.obsmpdao.delete(this.obsmppk);
			this.obsdaidao.delete(this.obsdaipk);
			this.pordao.delete(this.porpk);
			
			for(ImpAtpPk atppk:this.listaatppk)
				this.atpdao.delete(atppk);
			for(ImpChoquesPk chpk:this.listachoquespk)
				this.choquedao.delete(chpk);
			for(ImpZonaPk zpk:this.listazonapk)
				this.zonadao.delete(zpk);
			
			this.hevdao.delete(this.hevpk);
			this.compsegdao.delete(new SegComplicacionesPk(null,this.seg.getIdseg()));
			this.segdao.delete(this.segpk);
			// borrar informe INTEGRADO DE PROG. o MON. REMOTA asociado si existe 
			Informes[] informes = this.infdao.findByDynamicWhere("IDPROCEDIMIENTO = ? AND TIPOPROCEDIMIENTO = ? AND ORIGEN <> ?", new Object[]{this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento(),1});
			if(informes!=null && informes.length>0)
				this.infdao.delete(new InformesPk(informes[0].getIdinf()));// se coje el informes[0] porque solo hay una fuente de integracion externa para los seguimientos por ahora: prog. o remota
			//this.infdao.delete(new InformesPk(this.procpk.getIdprocedimiento(),983));
			// borrar evento (prox. seguimiento) asociado si existe
			this.evdao.delete(new EventoPk(this.evento.getIdevento()));
			this.procdao.delete(this.procpk);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro de seguimiento eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_borrado_error_exep")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido eliminar el registro:  Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
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
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_warn_sitclin_fe")+": "+ e1.getMessage());
		}	
	}
	public void resetFEVI(ActionEvent e){
		this.sitclin.setFevi(null);
		this.modsitclin = true;
	}
	
	public void imprimeInforme(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String jasper = "InformeSeguimiento.jasper";
		try {
			UtilReporteInformes util = preparaReporteInforme();
			PathFicheroXml = generadorXML.imprimeInformeSeguimiento(this.seg,this.sitclin,this.hev,this.sist, 
								this.cp.pacienteSelect,util,this.infocentro,this.listaelectrodosseg,this.obsmp,this.obsdai,this.por,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: " + se.getMessage(),
						"Error generando documento,Motivo: " + se.getMessage());
			} catch (Exception e3) {
			}
		}
		try{
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generación de informe (Seguimiento). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo informe. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
	}
	
	
	public void descargar(ActionEvent e){
		try{			
			// Habria que poner alguna marca por si hay informe adjunto. En BD por ejemplo
			File f = new File(this.inf.getRuta());
			if(f.exists()){
				ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
				HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
				HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
				String sesionID = req.getRequestedSessionId();
				
				ServletOutputStream servletOutputStream = response.getOutputStream();
				
				//byte[] descarga = UtilFiles.read(f);
				String str_encoded = UtilFiles.file2String(f);
				byte[] descarga = Base64.decodeBase64(str_encoded.getBytes());
				
				response.setContentType("application/pdf");
				response.setContentLength(descarga.length);
				response.setHeader("Content-Transfer-Enconding", "binary");
				response.setHeader("Content-disposition", "inline; filename=\"" + f.getName() + "\"");

				servletOutputStream.write(descarga);

				// esta sentencia es extremadamente importante de cara a conseguir que se pueda abrir el archivo
				FacesContext.getCurrentInstance().responseComplete();
				logger.info("("+this.usuario+") Descarga de informe adjunto de Seguimientos en ubicación local. ID_envio: "+this.inf.getIdprocedimiento());
			}else
				this.pintaMensaje(AVISO, this.bundle.getString("seg_disp_msg_warn_descarga_informes"));	
		}catch(Exception e1){
			this.pintaMensaje(ERROR, this.bundle.getString("seg_disp_msg_error_descarga_informes")+": "+e1.getMessage());
			logger.error("("+this.usuario+") Error al descargar informe de seguimiento. Motivo: "+e1.getMessage(),e1);
		}
	}
	
	private UtilReporteInformes preparaReporteInforme(){
		UtilReporteInformes util = new UtilReporteInformes();
		if(this.getTipogen()==1)
			util.setTipodispositivo("Marcapasos");
		else if(this.getTipogen()==2)
			util.setTipodispositivo("Desfibrilador");
		else if(this.getTipogen()==3)
			util.setTipodispositivo("CRT");
		else if(this.getTipogen()==4)
			util.setTipodispositivo("CRT/DAI");
		else if (this.getTipogen() == 5)
			util.setTipodispositivo("Marcapasos sin cable");
		else if (this.getTipogen() == 6)
			util.setTipodispositivo("DAI Subcutáneo");
		else
			util.setTipodispositivo("");
				
		for(SelectItem i:this.getRitmos()){
			if(i.getValue().toString().equals(this.sitclin.getRitmo().toString())){
				util.setRitmo(i.getLabel());
				break;
			}			
		}
		for(SelectItem i:this.getConducciones()){
			if(i.getValue().toString().equals(this.sitclin.getConducav().toString())){
				util.setConduccionav(i.getLabel());
				break;
			}			
		}
		for(SelectItem i:this.getQrs()){
			if(i.getValue().toString().equals(this.sitclin.getQrs().toString())){
				util.setConduccionqrs(i.getLabel());
				break;
			}				
		}
		if(this.sitclin.getCardiopatia()!=null)
			for(SelectItem i:this.getCardiopatia()){
				if(i.getValue().toString().equals(this.sitclin.getCardiopatia().toString())){
					util.setCardiopatia(i.getLabel());
					break;
				}			
			}
		if(this.seg.getOperador()!=null)
			for(SelectItem i:this.getPrimerop()){
				if(i.getValue().toString().equals(this.seg.getOperador().toString())){
					util.setPrimeroperador(i.getLabel());
					break;
				}			
			}
		String selecs="";
		if(this.listagenerador.size()>0){
			Generador g = null;
			try {
				g = this.generadoresdao.findByPrimaryKey(this.listagenerador.get(0).getIdgenerador());
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
			util.setFechaimplantegen(this.listagenerador.get(0).getFechaimplante());
			selecs = selecs + ". "+this.bundle.getString("imp_dispositivos_reporte_gen_ns")+": " + this.listagenerador.get(0).getNumserie() + "\n";
			// Localizacion generador 
			if(this.tipogen!=5){
				for (SelectItem i : this.getLocalizaciongen()) {
					if (i.getValue().toString().equals(this.listagenerador.get(0).getLocalizacion().toString())) {
						util.setLocalizaciongen(!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():" "+this.bundle.getString("no_especificada")+".");
						selecs = selecs + this.bundle.getString("imp_dispositivos_reporte_gen_loc")+": " + (!i.getLabel().equals(this.bundle.getString("seleccione_opcion"))?i.getLabel():" "+this.bundle.getString("no_especificada")+".") + "\n\n";
						break;
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
		}else
			util.setTipodispositivo("");
		
		for(ImpImplanteElectrodos e:this.listaelectrodosseg){
			String zona = "";
			Electrodos el = null;
			try {
				el = this.electrodosdao.findByPrimaryKey(e.getIdelectrodo());
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
					selecs = selecs
							+ this.bundle.getString("imp_dispositivos_reporte_elec_ad")+": "
							+ el.getFabricante()!=null?el.getFabricante():""
							+ " "
							+ el.getModelo()
							+ "."
							+ " "+this.bundle.getString("imp_dispositivos_reporte_gen_ns")+": "
							+ (e.getNumserie() != null ? e.getNumserie()
									: this.bundle.getString("no_especificado")) + " en " + zona
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
					selecs = selecs
							+ this.bundle.getString("imp_dispositivos_reporte_elec_vd")+": "
							+ el.getFabricante()!=null?el.getFabricante():""
							+ " "
							+ el.getModelo()
							+ "."
							+ " "+this.bundle.getString("imp_dispositivos_reporte_gen_ns")+": "
							+ (e.getNumserie() != null ? e.getNumserie()
									: this.bundle.getString("no_especificado")) + " en " + zona
							+ "\n";
					//break;
				} else if (e.getCamara().equals(950)) {
					util.setModeloelectrodovi(el.getModelo());
					if(e.getZonacamara()!=null)
						for (SelectItem cam : this.getZonacamaravi()) {
							if (cam.getValue().toString()
									.equals(e.getZonacamara().toString())) {
								zona = cam.getLabel();
								break;
							}
						}
					else
						zona = this.bundle.getString("imp_dispositivos_reporte_elec_zona_noesp");
					selecs = selecs
							+ this.bundle.getString("imp_dispositivos_reporte_elec_vi")+": "
							+ el.getFabricante()!=null?el.getFabricante():""
							+ " "
							+ el.getModelo()
							+ "."
							+ " "+this.bundle.getString("imp_dispositivos_reporte_gen_ns")+": "
							+ (e.getNumserie() != null ? e.getNumserie()
									: this.bundle.getString("no_especificado")) + " en " + zona
							+ "\n";
					//break;
				}// FALTA LA AURICULA IZQUIERDA
				zona = null;
			}
		}	
		util.setInfoelecs(selecs);
		util.setInfosistema(selecs);
		return util;
	}
	/****** controles booleanos -short ****/
	public void seguimientoRemoto(ActionEvent e) {
		this.seg.setRemoto((short) (this.seg.isSegrem() ? 1 : 0));
	}

	public void mDep(ActionEvent e) {
		this.hev.setMpdependiente((short) (this.hev.isMpdep() ? 1 : 0));
	}

	public void sitClinRevasc(ActionEvent e) {
		this.sitclin.setRevasc((short) (this.sitclin.isRevascularizacion() ? 1: 0));
		this.sgen.setRevasc(this.sitclin.getRevasc());
		this.sgen.setRevascularizacion(this.sitclin.isRevascularizacion());
		this.modsitclin = true;
	}

	public void sitClinInfPrev(ActionEvent e) {
		this.sitclin.setInfprevio((short) (this.sitclin.isInfartoprev() ? 1 : 0));
		this.sgen.setInfprevio(this.sitclin.getInfprevio());
		this.sgen.setInfartoprev(this.sitclin.isInfartoprev());
		// Actualizacion de valores de infarto previo si false
		if (!(this.sitclin.isInfartoprev())) {
			this.sitclin.setAnio(null);
			this.sgen.setAnio(this.sitclin.getAnio());
			this.sitclin.setLocalizacion(null);
			this.sgen.setLocalizacion(this.sitclin.getLocalizacion());
		}
		this.modsitclin = true;
	}

	public void cambiaAnosEvolucion(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAevolucion(this.sitclin.getAevolucion());
	}
	public void cambiaAnioInfPrevio(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setAnio(this.sitclin.getAnio());
	}

	public void cambiaLocalizacion(ActionEvent e){
		this.modsitclin = true;
		this.sgen.setLocalizacion(this.sitclin.getLocalizacion());
	}

	public void anteFA(ActionEvent e) {
		this.sitclin.setAntfa((short) (this.sitclin.isAntefa() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setAntfa(this.sitclin.getAntfa());
	}

	public void anteFlutter(ActionEvent e) {
		this.sitclin.setFlutter((short) (this.sitclin.isAnteflutter() ? 1 : 0));
		this.modsitclin = true;
		this.sgen.setFlutter(this.sitclin.getFlutter());
	}

	public void cambiaHTA(ActionEvent e) {
		this.sitclin.setHta((short) (this.sitclin.isAnteHTA() ? 1 : 0));
		this.sgen.setHta(this.sitclin.getHta());
		this.sgen.setAnteHTA(this.sitclin.isAnteHTA());
		this.modsitclin = true;
	}

	public void cambiaDiabetes(ActionEvent e) {
		this.sitclin.setDiabetes((short) (this.sitclin.isAntediab() ? 1 : 0));
		this.sgen.setDiabetes(this.sitclin.getDiabetes());
		this.sgen.setAntediab(this.sitclin.isAntediab());
		this.modsitclin = true;
	}

	public void cambiaDislipemia(ActionEvent e) {
		this.sitclin.setDislipemia((short) (this.sitclin.isAnteDislipemia() ? 1: 0));
		this.sgen.setDislipemia(this.sitclin.getDislipemia());
		this.sgen.setAnteDislipemia(this.sitclin.isAnteDislipemia());
		this.modsitclin = true;
	}

	public void cambiaTabaquismo(ActionEvent e) {
		this.sitclin.setTabaquismo((short) (this.sitclin.isAntetabaq() ? 1: 0));
		this.sgen.setTabaquismo(this.sitclin.getTabaquismo());
		this.sgen.setAntetabaq(this.sitclin.isAntetabaq());
		this.modsitclin = true;
	}

	public void cambiaAlcohol(ActionEvent e) {
		this.sitclin.setIngalcoholica((short) (this.sitclin.isAnteAlcohol() ? 1: 0));
		this.sgen.setIngalcoholica(this.sitclin.getIngalcoholica());
		this.sgen.setAnteAlcohol(this.sitclin.isAnteAlcohol());
		this.modsitclin = true;
	}

	public void cambiaACV(ActionEvent e) {
		this.sitclin.setAcv((short) (this.sitclin.isAnteacv() ? 1 : 0));
		this.sgen.setAcv(this.sitclin.getAcv());
		this.sgen.setAnteacv(this.sitclin.isAnteacv());
		this.modsitclin = true;
	}

	public void cambiaAIT(ActionEvent e) {
		this.sitclin.setAit((short) (this.sitclin.isAnteAIT() ? 1 : 0));
		this.sgen.setAit(this.sitclin.getAit());
		this.sgen.setAnteAIT(this.sitclin.isAnteAIT());
		this.modsitclin = true;
	}

	public void cambiaEPOC(ActionEvent e) {
		this.sitclin.setEpoc((short) (this.sitclin.isAnteEPOC() ? 1 : 0));
		this.sgen.setEpoc(this.sitclin.getEpoc());
		this.sgen.setAnteEPOC(this.sitclin.isAnteEPOC());
		this.modsitclin = true;
	}

	public void cambiaSAHS(ActionEvent e) {
		this.sitclin.setSahs((short) (this.sitclin.isAnteSAHS() ? 1 : 0));
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
		this.modsitclin = true;
	}

	public void cambiaInsRenal(ActionEvent e) {
		this.sitclin.setInsrenal((short) (this.sitclin.isAnteinsrenal() ? 1 : 0));
		this.sgen.setInsrenal(this.sitclin.getInsrenal());
		if(!(this.sitclin.isAnteinsrenal())){
			this.sitclin.setInsrenal(null);
			this.sgen.setInsrenal(this.sitclin.getInsrenal());
		}	
		this.sgen.setAnteinsrenal(this.sitclin.isAnteinsrenal());
		this.modsitclin = true;
	}

	public void cambiaNeoplasia(ActionEvent e) {
		this.sitclin.setNeoplasia((short) (this.sitclin.isAnteNeoplasia() ? 1: 0));
		this.sgen.setNeoplasia(this.sitclin.getNeoplasia());
		if(!(this.sitclin.isAnteNeoplasia())){
			this.sitclin.setTiponeoplasia(null);
			this.sgen.setTiponeoplasia(this.sitclin.getTiponeoplasia());
		}		
		this.sgen.setAnteNeoplasia(this.sitclin.isAnteNeoplasia());
		this.modsitclin = true;
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
		this.sgen.setCpap(this.sitclin.getCpap());
		this.sgen.setAnteCPAP(this.sitclin.isAnteCPAP());
		this.modsitclin = true;
	}

	public void cambiaCambioModoArritmiaAu(ActionEvent e) {
		this.obsmp.setCambiomodoarrau((short) (this.obsmp.isCambiomodoarritmiaau() ? 1 : 0));
	}

	public void cambiaTerapiaAtp(ActionEvent e) {
		this.obsdai.setAtp((short) (this.obsdai.isTeratp() ? 1 : 0));
	}

	public void cambiaTerapiaEfectivaATP(ActionEvent e) {
		this.obsdai.setTodasefecatp((short) (this.obsdai.isTerapiaefecatp() ? 1 : 0));
	}

	public void cambiaTerapiaChoques(ActionEvent e) {
		this.obsdai.setChoq((short) (this.obsdai.isTerchoques() ? 1 : 0));
	}

	public void cambiaTerapiaEfectivaChoques(ActionEvent e) {
		this.obsdai.setTodasefectchoq((short) (this.obsdai.isTerapiaefecchoq() ? 1 : 0));
	}

	public void cambiaSegRem(ActionEvent e) {
		this.hev.setSegremoto((short) (this.hev.isSegrem() ? 1 : 0));
	}

	public void cambiaMinEstVent(ActionEvent e) {
		this.hev.setMev((short) (this.hev.isMinestvent() ? 1 : 0));
	}

	public void cambiaAlgPrevFA(ActionEvent e) {
		this.hev.setAlgprevfa((short) (this.hev.isPrevfa() ? 1 : 0));
	}

	public void cambiaEpisodiosRuidoMP(ActionEvent e) {
		this.obsmp.setEpiruido((short) (this.obsmp.isEpisodiosruido() ? 1 : 0));
	}

	public void cambiaEpisodiosRuidoDAI(ActionEvent e) {
		this.obsdai.setEpiruido((short) (this.obsdai.isEpisodiosruido() ? 1 : 0));
	}

	public void cambiaBAV(ActionEvent e){
		if(!(this.bloq.isBav())){
			this.bloq.setBav1(null);
			this.bloq.setBav2(null);
			this.bloq.setBav3(null);
		}
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

	public void cambiaEOLERI(ActionEvent e){
		if(this.sist.getAuxeoleri()==1){
			this.sist.setEol((short)1);
			this.sist.setEri(null);
		}else{
			this.sist.setEri((short)1);
			this.sist.setEol(null);
		}	
	}

	public void delEOLERI(ActionEvent e){
		if(this.sist.getAuxeoleri()==1 || this.sist.getAuxeoleri()==2){
			this.sist.setEol(null);
			this.sist.setEri(null);
			this.sist.setAuxeoleri(0);
		}
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

	public void cambiaAS(ActionEvent e){
		try{
			Integer as = Integer.parseInt(this.por.getPoras());			
			this.por.setPorap(as<=100?String.valueOf(100 - as):"0");
			this.por.setPoras(as>100?"100":this.por.getPoras());
		}catch(Exception e1){
			this.por.setPoras("0");
			this.por.setPorap("100");
		}	
	}

	public void cambiaAP(ActionEvent e){
		try{
			Integer ap = Integer.parseInt(this.por.getPorap());
			this.por.setPoras(ap<=100?String.valueOf(100 - ap):"0");
			this.por.setPorap(ap>100?"100":this.por.getPorap());
		}catch(Exception e1){
			this.por.setPorap("0");
			this.por.setPoras("100");
		}	
	}

	public void cambiaVS(ActionEvent e){
		try{
			Integer vs = Integer.parseInt(this.por.getPorvs());
			this.por.setPorvp(vs<=100?String.valueOf(100 - vs):"0");
			this.por.setPorvs(vs>100?"100":this.por.getPorvs());
		}catch(Exception e1){
			this.por.setPorvs("0");
			this.por.setPorvp("100");
		}	
	}

	public void cambiaVP(ActionEvent e){
		try{
			Integer vp = Integer.parseInt(this.por.getPorvp());
			this.por.setPorvs(vp<=100?String.valueOf(100 - vp):"0");
			this.por.setPorvp(vp>100?"100":this.por.getPorvp());
		}catch(Exception e1){
			this.por.setPorvp("0");
			this.por.setPorvs("100");
		}	
	}

	public void cambiaHisteresis(ActionEvent e){
		if(!(this.hev.isHist()))
			this.hev.setValorHisteresis(null);
	}

	/****** **************************** ****/
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
					cp.pacienteSelect.setSitclin(sgen);
				} catch (SituacionClinicaGeneralDaoException e) {
					logger.error("("+this.usuario+") Error al actualizar situacion clinica general de paciente. Motivo: "+e.fillInStackTrace());
				}
			}	
		}else{
			
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
			if(s.getIdsintomas()!=null && s.getIdsintomas().equals(this.sitclin.getSintomas().get(this.bindingSintomas.getRowIndex()).getIdsintomas())){
				dup++;		
			}	
			if(dup>1){
				// Duplicado
				this.sitclin.getSintomas().remove(this.bindingSintomas.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sitclin_sintoma_dup"));
				break;
			}
		}
	}

	public void addComplicaciones(ActionEvent e) {
		this.getListacomplicaciones().add(new SegComplicaciones());
	}

	public void delComplicaciones(ActionEvent e) {
		this.getListacomplicaciones().remove(this.getBindingComplicaciones().getRowIndex());
	}

	public void addZona(ActionEvent e) {
		// Se permite la carga desde TV1.. TV5 y FV
		// Orden de carga: FV -> TV1 -> TV2 ->...->TV5
		if (this.hev.getZonas().size() == 0)
			this.hev.getZonas().add(new ImpZona("FV"));
		else if ((this.hev.getZonas().size() >= 1) && (this.hev.getZonas().size() < 6))
			this.hev.getZonas().add(0, new ImpZona("TVn"));
	}

	public void delZona(ActionEvent e) {
		if (this.getBindingGrid().getRowIndex() != this.hev.getZonas().size() - 1 || this.hev.getZonas().size() == 1) {
			this.hev.getZonas().remove(this.getBindingGrid().getRowIndex());
			actualizaTipoZona();
		}
	}

	private void actualizaTipoZona() {
		for (int i = 0; i < this.hev.getZonas().size() - 1; i++) {
			this.hev.getZonas().get(i).setTipo("TV" + String.valueOf(i + 1));
		}
	}

	public void cargarAvanzadosZona(ActionEvent e) {
		if (this.isAvzona())
			this.setAvzona(false);
		else
			this.setAvzona(true);
	}

	public void gestionaZona(ActionEvent e) {
		// Validar formato de numero adecuado
		try {
			int fc = Integer.valueOf(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getFcPpm());
			this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).setFcMs(String.valueOf(60000 / fc));
			for (int i = 0; i < this.hev.getZonas().size(); i++) {
				// " - Frec Actual: "+this.getListazonas().get(i).getFrec1());
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
			//System.out.println(ex.getLocalizedMessage());
		}
	}
	public void gestionaZonaMs(ActionEvent e) {
		// Validar formato de numero adecuado
		try {
			int fc = Integer.valueOf(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getFcMs());
			this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).setFcPpm(String.valueOf(60000 / fc));
			for (int i = 0; i < this.hev.getZonas().size(); i++) {
				// " - Frec Actual: "+this.getListazonas().get(i).getFrec1());
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
			//System.out.println(ex.getLocalizedMessage());
		}
	}

	public void cargaATPZona(ActionEvent e) {
		int prev = this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().size();
		int act = Integer.parseInt(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getNumatpini());
		if (act > prev) {// Añade tantos como la diferencia entre ambos
			for (int i = 0; i < (act - prev); i++) {
				this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().add(new ImpAtp("ATP"+ String.valueOf(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().size() + 1)));
			}
		} else if (act < prev) {// Elimina tantos como la diferencia entre ambos
			for (int i = 0; i < (prev - act); i++) {
				this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().remove(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getAtps().size() - 1);
			}
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
		for (int i = 0; i < this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().size(); i++) {
			if (Integer.valueOf(this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().get(i).getEnergia()) > enact) {
				ImpChoques aux = this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().get(this.bindingChoques.getRowIndex());
				this.hev.getZonas().get(this.getBindingGrid().getRowIndex()).getChqs().add(i, aux);
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

	public void cambiaCardiopatia(ActionEvent e) {
		if (!(this.sitclin.getCardiopatia().equals(914))) {
			this.sitclin.setRevasc((short) 0);
			this.sgen.setRevasc(this.sitclin.getRevasc());
			this.sitclin.setRevascularizacion(false);
			this.sitclin.setInfprevio((short) 0);
			this.sgen.setInfprevio(this.sitclin.getInfprevio());
			this.sitclin.setInfartoprev(false);
			this.sitclin.setAnio(null);
			this.sgen.setAnio(this.sitclin.getAnio());
			this.sitclin.setLocalizacion(0);
			this.sgen.setLocalizacion(this.sitclin.getLocalizacion());
		}
		this.sgen.setCardiop(this.sitclin.isCardiop());
		this.sgen.setInfartoprev(this.sitclin.isInfartoprev());
		this.sgen.setRevascularizacion(this.sitclin.isRevascularizacion());
	}

	public void controlNumEpisodios(ActionEvent e) {
		try {
			this.obsdai.setNumepitsv("0");
			this.obsdai.setNumepitv("0");
			this.obsdai.setNumepifv("0");
			this.obsdai.setNumepinosost("0");
			this.obsdai.setNumepinoesp(this.obsdai.getNumepisodios());
		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_episodios"));
		}
	}

	public void cambiaNumEpisodios(ActionEvent e) {
		try {
			// Los items que esten vacios se ponen a 0. Los que no, a su valor escrito
			if (this.obsdai.getNumepitsv() == null || this.obsdai.getNumepitsv().length() == 0)
				this.obsdai.setNumepitsv("0");
			if (this.obsdai.getNumepitv() == null || this.obsdai.getNumepitv().length() == 0)
				this.obsdai.setNumepitv("0");
			if (this.obsdai.getNumepifv() == null || this.obsdai.getNumepifv().length() == 0)
				this.obsdai.setNumepifv("0");
			if (this.obsdai.getNumepinosost() == null || this.obsdai.getNumepinosost().length() == 0)
				this.obsdai.setNumepinosost("0");
			if (this.obsdai.getNumepinoesp() == null || this.obsdai.getNumepinoesp().length() == 0)
				this.obsdai.setNumepinoesp("0");
			// Actualizacion de valores y calculo
			int total = 0;
			int tsv = (this.obsdai.getNumepitsv().length() > 0) ? Integer.parseInt(this.obsdai.getNumepitsv()) : 0;
			int tv = (this.obsdai.getNumepitv().length() > 0) ? Integer.parseInt(this.obsdai.getNumepitv()) : 0;
			int fv = (this.obsdai.getNumepifv().length() > 0) ? Integer.parseInt(this.obsdai.getNumepifv()) : 0;
			int nosos = (this.obsdai.getNumepinosost().length() > 0) ? Integer.parseInt(this.obsdai.getNumepinosost()) : 0;
			int otros = (this.obsdai.getNumepinoesp().length() > 0) ? Integer.parseInt(this.obsdai.getNumepinoesp()) : 0;
			total = total + tsv + tv + fv + nosos + otros;
			this.obsdai.setNumepisodios(String.valueOf(total));
		} catch (Exception ex) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("imp_dispositivos_msg_warn_episodios"));
		}
	}

	private String componerNombreAbordaje(ImpImplanteElectrodos e) {
		String res = "";
		if(e.getConector()!=null && e.getConector().equals("SQ1")){
			if(e.getZonacamara()!=null)
				res = res + this.getNombreZonaCamara(e.getZonacamara())+" ";
			if (e.getLateralidad() != null)
				res = res + this.getNombreLateralidad(e.getLateralidad());
			return res;
		} 
		if (e.getVia() != null) {
			res = res + this.getNombreVia(e.getVia()) + " ";
			if (e.getVia().equals(929)) {// EPICARDICO
				if (e.getZonacamara() != null)
					res = res + " mediante " + this.getNombreZonaCamara(e.getZonacamara());
				if (e.getCamara() != null){
					res = res + " a " + this.getNombreCamara(e.getCamara());
					if(e.getCamara()==948)
						this.setCablea(true);
					else if(e.getCamara()==949)
						this.setCablev(true);
				}			
			} else {
				if (e.getLateralidad() != null)
					res = res + this.getNombreLateralidad(e.getLateralidad())
							+ " ";
				if (e.getCamara() != null && e.getCamara() != 950 && e.getCamara()!=-1){// AD o VD
					res = res + "a "
							+ (e.getZonacamara()!=null?this.getNombreZonaCamara(e.getZonacamara()):"")
							+ " de " + this.getNombreCamara(e.getCamara());
					if(e.getCamara()==948)
						this.setCablea(true);
					else if(e.getCamara()==949)
						this.setCablev(true);
				}else if (e.getCamara() != null && e.getCamara() == 950 && e.getCamara()!=-1){
					res = res + "a porcion "
							+ (e.getPorcion()!=null?this.getNombrePorcion(e.getPorcion()):"") + " de "
							+ (e.getZonacamara()!=null?this.getNombreZonaCamara(e.getZonacamara()):"")
							+ " de " + this.getNombreCamara(e.getCamara());
					this.setCablev(true);
				}	
			}
		}else{
			if(e.getCamara() != null){
				if(e.getCamara()==948)
					this.setCablea(true);
				else if(e.getCamara()==949 || e.getCamara()==950)
					this.setCablev(true);
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
				//this.setCablea(true);
				return v.getValor();
			}
		}
		for (ArrMaestras v : this.zonacamaravd) {
			if (v.getCodigo().equals(id)) {
				//this.setCablev(true);
				return v.getValor();
			}
		}
		for (ArrMaestras v : this.zonacamaravi) {
			if (v.getCodigo().equals(id)) {
				//this.setCablev(true);
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
	public void controlComp(ActionEvent e){
		int dup=0;
		for(SegComplicaciones s:this.listacomplicaciones){
			if(s.getIdcomp() == this.listacomplicaciones.get(this.bindingComplicaciones.getRowIndex()).getIdcomp())
				dup++;
			if(dup>1){
				// Duplicado
				this.listacomplicaciones.remove(this.bindingComplicaciones.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_dupl"));
				break;
			}
		}
	}
	
	public void controlCompTipo(ActionEvent e){
		int dup_otra=0;
		for(SegComplicaciones s:this.listacomplicaciones){
			if(s.getTipocomp()!=null && s.getTipocomp().equals("1091")){
				dup_otra++;
			}
			if(dup_otra>1){
				// Dulpicado otra
				this.listacomplicaciones.remove(this.bindingComplicaciones.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_dupl"));
				break;
			}
		}
	}
	
	public void avanza3Meses(ActionEvent e){
		if(this.seg.getFechaproximoseg()==null)
			this.seg.setFechaproximoseg(new Date());
		this.seg.setFechaproximoseg(UtilFechas.sumaDuracion(this.seg.getFechaproximoseg(), 3, "mes"));
	}
	public void avanza6Meses(ActionEvent e){
		if(this.seg.getFechaproximoseg()==null)
			this.seg.setFechaproximoseg(new Date());
		this.seg.setFechaproximoseg(UtilFechas.sumaDuracion(this.seg.getFechaproximoseg(), 6, "mes"));
	}
	public void avanza12Meses(ActionEvent e){
		if(this.seg.getFechaproximoseg()==null)
			this.seg.setFechaproximoseg(new Date());
		this.seg.setFechaproximoseg(UtilFechas.sumaDuracion(this.seg.getFechaproximoseg(), 12, "mes"));
	}
	
	/**
	 * Carga episodio /evento del proximo seguimiento establecido en el seguimiento actual
	 * @param e
	 */
	public void cargaEpisodioEventoProxSeguimiento(ActionEvent e){
		try{
			if(this.proc.getIdepisodio()!=null){
				Episodio ep = this.epdao.findByPrimaryKey(this.proc.getIdepisodio());
				if(ep.getIdevento()!=null){
					this.evento = this.evdao.findByPrimaryKey(ep.getIdevento());
					if(this.evento!=null){
						this.evento.setHora_ini(UtilFechas.getHora(this.evento.getFechaini()));
						this.evento.setMin_ini(UtilFechas.getMinuto(this.evento.getFechaini()));
						calcularDuracion(this.evento);
					}else
						this.evento = new Evento();					
				}else
					this.evento = new Evento();
			}			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("seg_disp_msg_error_carga_prox_seg_carga_ev")+": " + e1.getMessage());
			logger.error("No se puede recuperar evento y episodio. Motivo: "+e1.getMessage(),e1);
		}
	}
	
	public void crearEventoSeguimiento(ActionEvent e){
		try{
			if(this.seg.getFechaproximoseg()!=null){
				// La vinculación entre un Procedimiento/evento es por medio de la entidad EPISODIO.
				// VINCULACIÓN EPISODIO-EVENTO, PROCEDIMIENTO-EPISODIO
				// Crear EPISODIO, crear EVENTO y asociarlos al procedimiento.
				if(eventoValido()){
					if(this.evento.getIdevento()!=null){// UPDATE
						this.seg.setFechaproximoseg(UtilFechas.sumaDuracion(this.seg.getFechaproximoseg(), Integer.valueOf(this.evento.getHora_ini()), "h"));//horas
						this.seg.setFechaproximoseg(UtilFechas.sumaDuracion(this.seg.getFechaproximoseg(), Integer.valueOf(this.evento.getMin_ini()), "min"));//horas
						this.evento.setFechaini(this.seg.getFechaproximoseg());
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.evento.getDuracion(), "min"));
						this.evento.setIdusuario(this.usuario);
						this.evdao.update(new EventoPk(this.evento.getIdevento()), this.evento);
						this.pintaMensaje(INFO, this.bundle.getString("seg_disp_msg_info_edit_prox_seg_ev"));
						logger.info("("+this.usuario+") Evento actualizado con éxito en el sistema. IdEvento: "+this.evento.getIdevento());
					}else{//INSERT
						this.evento.setProcedimiento(983);
						this.evento.setEstado(1);
						this.evento.setFechaasignacion(new Date());
						this.evento.setIdpaciente(this.cp.getPacienteSelect().getNhc());
						this.evento.setNombre(this.cp.getPacienteSelect().getNombre());
						this.evento.setApellido1(this.cp.getPacienteSelect().getApellid1());
						this.evento.setApellido2(this.cp.getPacienteSelect().getApellid2());
						this.evento.setCodigo(this.cp.getPacienteSelect().getCodigo());
						this.evento.setIdusuario(this.usuario);
						// Adaptar horas
						this.seg.setFechaproximoseg(UtilFechas.sumaDuracion(this.seg.getFechaproximoseg(), Integer.valueOf(this.evento.getHora_ini()), "h"));//horas
						this.seg.setFechaproximoseg(UtilFechas.sumaDuracion(this.seg.getFechaproximoseg(), Integer.valueOf(this.evento.getMin_ini()), "min"));//horas
						this.evento.setFechaini(this.seg.getFechaproximoseg());
						//this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.evento.getDuracion(), "min"));
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), calcularDuracionSeguimiento(), "min"));
						this.evento.setIdentificador(GestorNomenclatura.generaIdentificador("EV", 983, this.evento.getFechaini(), this.cp.getPacienteSelect().getNhc(),this.tipogen));
						this.evento.setSolicitante(this.usuario);// A REVISAR - PENDIENTE MODULO DE RECURSOS
						
						EventoPk evpk = this.evdao.insert(this.evento);
						Agendacita agcit = new Agendacita();
						agcit.setIdagenda(this.agenda.getIdagenda());
						agcit.setIdevento(evpk.getIdevento());
						this.agcitadao.insert(agcit);
						this.episodio = new Episodio();
						this.episodio.setCodigopaciente(this.cp.getPacienteSelect().getCodigo());
						this.episodio.setFechaini(this.evento.getFechaini());
						this.episodio.setFechafin(this.evento.getFechafin());
						this.episodio.setIdevento(this.evento.getIdevento());
						this.episodio.setIdpaciente(this.cp.getPacienteSelect().getNhc());
						this.episodio.setIdentificador(GestorNomenclatura.generaIdentificador("EPI", 983,this.episodio.getFechaini(), this.episodio.getIdpaciente(),this.tipogen));
						EpisodioPk epk = this.epdao.insert(this.episodio);
						this.episodio.setIdepisodio(epk.getIdepisodio());// importante para asignacion de idepisodio en this.proc posteriormente
						this.pintaMensaje(INFO, this.bundle.getString("seg_disp_msg_info_guarda_prox_seg_ev"));
						//logger.info("("+this.usuario+") Evento creado con éxito en el sistema. IdEvento: "+evpk.getIdevento());
					}
					this.pintaMensaje(INFO, this.bundle.getString("seg_disp_msg_info_guarda_prox_seg_ev_res"));
				}else
					this.pintaMensaje(ERROR, this.bundle.getString("seg_disp_msg_warn_guarda_prox_seg"));	
			}
			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_evento_guarda")+": "+ e1.getMessage());
			logger.error("No se puede crear/actualizar evento en el sistema. Motivo: "+e1.getMessage(),e1);
		}
	}
	
	private int calcularDuracionSeguimiento(){
		if(this.tipogen==1 || this.tipogen ==5)
			return this.TAM_HUECO * this.HUECO_SEG_MPS;
		else if(this.tipogen==2 || this.tipogen ==6)
			return this.TAM_HUECO * this.HUECO_SEG_DAI;
		else if(this.tipogen==3)
			return this.TAM_HUECO * this.HUECO_SEG_CRTP;
		else if(this.tipogen==4)
			return this.TAM_HUECO * this.HUECO_SEG_CRTD;
		else return 0;
	}
	
	private int calcularHuecosSeguimiento(){
		if(this.tipogen==1 || this.tipogen ==5)
			return this.HUECO_SEG_MPS;
		else if(this.tipogen==2 || this.tipogen ==6)
			return this.HUECO_SEG_DAI;
		else if(this.tipogen==3)
			return this.HUECO_SEG_CRTP;
		else if(this.tipogen==4)
			return this.HUECO_SEG_CRTD;
		else return 0;
	}
	
	private boolean eventoValido(){
		if(this.evento.getDuracion()==null || this.evento.getDuracion()<=0){
			this.pintaMensaje(ERROR, this.bundle.getString("seg_disp_msg_valida_evento_dur"));
			return false;
		}else if(this.evento.getHora_ini()==null){
			this.pintaMensaje(ERROR, this.bundle.getString("seg_disp_msg_valida_evento_hini"));
			return false;
		}else if(this.evento.getMin_ini()==null){
			this.pintaMensaje(ERROR, this.bundle.getString("seg_disp_msg_valida_evento_mini"));
			return false;
		}
		return true;
			
	}
	
	public void eventosDiarios(ActionEvent e){
		try{
			this.huecoslibresdiarios.clear();
			this.huecosdisponibles.clear();
			this.setPleno(false);
			
			this.agenda.getDiarios().clear();
			this.agenda.getModel().setSelectedDate(this.seg.getFechaproximoseg());
			// set hora y minuto inicio
			this.evento.setHora_ini("00");
			this.evento.setMin_ini("00");
			// obtener numero de huecos segun seguimiento
			this.evento.setHuecos(this.calcularHuecosSeguimiento());
			// Se adapta la fecha al inicio del working hour de la agenda
			this.seg.getFechaproximoseg().setHours(this.agenda.getSchedule().getWorkingStartHour());
			this.seg.getFechaproximoseg().setMinutes(0);
			this.seg.getFechaproximoseg().setSeconds(0);
			UtilAgenda.crearListaHuecosDiario(this.huecosdisponibles, this.TOTAL_HUECOS, this.TAM_HUECO, this.seg.getFechaproximoseg());
			
			Evento[] evs = this.evdao.getNumtotalEventosFecha(this.seg.getFechaproximoseg(), UtilFechas.addDate(this.seg.getFechaproximoseg(),1), 1);			
			for(Evento ev:evs){				
				this.agenda.getEventos().add(ev);
				cargaEventoModelo(ev,this.agenda);
				this.agenda.getDiarios().add(ev);	
				// Poner como hora, min inicio el maximo si existe. En otro caso, 08.00
			}
			//if(evs.length>0){
				List<Evento> lista_evs = Arrays.asList(evs);				
				// Se ordena primero la lista de eventos por fecha de inicio
				Collections.sort(lista_evs, new Comparator() {
					public int compare(Object o1, Object o2) {
						Evento e1 = (Evento) o1;
						Evento e2 = (Evento) o2;
						if (UtilFechas.dateDiff(e1.getFechaini(), e2.getFechaini())>0) {
							return 1;
						} else if (UtilFechas.dateDiff(e1.getFechaini(), e2.getFechaini())<=0) {
							return -1;
						} else {
							return 0;
						}
					}
				});
				// Se carga en un objeto ArrayList<Date> las fechas de los eventos actuales que ocupan huecos
				// Sabiendo el tamaño de hueco y el numero de huecos que ocupa, se puede obtener sus fechas
				ArrayList<Date> m1 = new ArrayList<Date>();
				for(Evento ev:lista_evs){	
					ev.setHuecos(UtilAgenda.calculaNumeroHuecosEvento(ev.getFechaini(), ev.getFechafin(),this.TAM_HUECO));// Calculo de duracion de hueco/evento
					if(ev.getEstado()==1)// solo mete las citas activas. Las canceladas no deben ocupar hueco
						UtilAgenda.insertaHuecos(m1, ev.getHuecos(), ev.getFechaini(),this.TAM_HUECO);
				}
				// Elimina del array los huecos ocupados por eventos diarios. Se marcan a a null
				UtilAgenda.marcarHorasOcupadas(this.huecosdisponibles, m1);
				this.huecoslibresdiarios = UtilAgenda.obtenerFranjasLibres(this.huecosdisponibles, this.evento.getHuecos());
				// Por defecto escoge el primer hueco libre
				if(this.huecoslibresdiarios.size()>0){
					this.evento.setFechaini(this.huecoslibresdiarios.get(0));
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.evento.getHuecos() * this.TAM_HUECO, "min"));
					this.calcularDuracion(this.evento);
					this.evento.setHora_ini(String.valueOf(this.evento.getFechaini().getHours()));
					this.evento.setMin_ini(String.valueOf(this.evento.getFechaini().getMinutes()));
				}else{
					this.pintaMensaje(AVISO, this.bundle.getString("citas_msg_warn_hueco_selec_ocupado"));
					this.setPleno(true);
					this.evento = new Evento();
				}
				
				// Una vez ordenado, se obtiene la fecha final del ultimo evento
				//return lista_evs.get(lista_evs.size()-1).getFechafin();
				// Debe obtener el primer hueco libre
				//this.seg.setFechaproximoseg(lista_evs.get(lista_evs.size()-1).getFechafin());
				//this.evento.setHora_ini(String.valueOf(this.seg.getFechaproximoseg().getHours()));
				//this.evento.setMin_ini(String.valueOf(this.seg.getFechaproximoseg().getMinutes()));
			/*}else{
				// no hay procedimientos para ese dia. Se asigna el primer hueco de la fecha especificada			
				this.seg.getFechaproximoseg().setHours(this.agenda.getSchedule().getWorkingStartHour());
				this.seg.getFechaproximoseg().setMinutes(0);
				this.seg.getFechaproximoseg().setSeconds(0);
				this.evento.setHora_ini(String.valueOf(this.agenda.getSchedule().getWorkingStartHour()));
				this.evento.setMin_ini("00");
			}*/
			//this.evento.setDuracion(this.calcularDuracionSeguimiento());
			this.agenda.getModel().refresh();
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_cons_agenda")+": " + e1.getMessage());
			logger.info("("+this.usuario+") No puede inicilizarse agenda compartida. Motivo: "+e1.getMessage(),e1);
		}
	}

	public void cargaEventoModelo(Evento e,Agenda a)throws Exception{
		DefaultScheduleEntry item = new DefaultScheduleEntry();
		item.setId(String.valueOf(e.getIdevento()));
		item.setStartTime(e.getFechaini());
		item.setEndTime(e.getFechafin());
		item.setDescription(e.getDescripcion());
		item.setTitle(mapeoTipoProcedimiento(e.getProcedimiento()));
		item.setSubtitle(mapeoEstado(e.getEstado()));
		if(UtilFechas.esEventoDiario(e.getFechaini(), e.getFechafin()))
			item.setAllDay(true);
		a.getModel().addEntry(item);
	}
	
	public void calcularDuracion(Evento e){
		if(e.getFechaini()!=null && e.getFechafin()!=null){
			if(e.getFechaini().equals(e.getFechafin()) && (!e.getDuracion().equals(0)))
				e.setFechafin(UtilFechas.sumaDuracion(e.getFechaini(), e.getDuracion(), "min"));	
			else if(e.getFechaini().equals(e.getFechafin())&& e.getDuracion()==null)
				e.setDuracion(0);
			else if(!e.getFechaini().equals(e.getFechafin())){
				// control de fechaini>=fechafin
				if(UtilFechas.dateDiff(e.getFechafin(), e.getFechaini())<0){
					e.setFechaini(e.getFechafin());// Se pone como fecha inicial la fecha final para evitar incongruencias
					e.setDuracion(0);
				}else{
					// ditancia = fechafin - fechaini (min)
					Long l = UtilFechas.cantidadTotalMinutos(e.getFechaini(), e.getFechafin());
					e.setDuracion(l.intValue());
					if(l==1439)// 1 dia completo
						e.setTododia(true);
				}				
			}
		}
	}
	
	private String mapeoTipoProcedimiento(Integer i){
		switch(i){
			case 0: return "No especificado";
			case 1: return "Otro";
			case 956: return "Implante dispositivo";
			case 1059: return "Recambio dispositivo";
			case 1060: return "Upgrade dispositivo";
			case 1085: return "Recolocación Generador";
			case 1086: return "Recolocación Electrodo";
			case 1147: return "Explante dispositivo";
			case 1061: return "Estudio EF";
			case 1068: return "Cardioversión eléctrica";
			case 1066: return "Mesa basculante";
			case 1067: return "Registrador de eventos";
			case 1063: return "Test ATP";
			case 1064: return "Test Epinefrina";
			case 1065: return "Test Flecainida";
			case 983: return "Seguimiento";
			default: return "No especificado";
		}
	}
	private String mapeoEstado(Integer i){
		switch(i){
			case 0: return "ANULADA";
			case 1: return "ASIGNADA";	
			case 2: return "VENCIDA";
			default: return "NO ESPECIFICADO";
		}
	}
	
	public void generarEstadisticasSitClin(ActionEvent e){
		try{
			// Se hace un muestreo hasta la fecha actual de consulta 
			Date fecha_muestreo = (this.proc!=null && this.proc.getFecha()!=null)?this.proc.getFecha():new Date();
			ArrayList<ArrayList<Object>> res = this.sitclindao.getEstadisticasFEVI(this.cp.getPacienteSelect().getCodigo(), fecha_muestreo);		
			this.setChartDataSitClinFevi(null);
			this.pintaGraficaSitClin(res);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("seg_disp_msg_genera_est_sitclin")+": "+e1.getCause().toString());
			logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString(),e1);
		}
	}
	
	public void generarEstadisticasBateria(ActionEvent e){
		try{
			// Hay que buscar por idimpgen y NO por el modelo. El modelo de generador puede usarse en varios implantes ya que la tabla generador contiene modelos genericos
			// mientras que ImpGenerador contiene implantes concretos de modelos generales.
			// Hay que coger de la lista el generador actual (no recambio, no recolocado y no explantado)
			Integer idimpgen = null;
			if(this.getListagenerador()!=null){
				if(this.getListagenerador().size()>0)
					idimpgen = this.getListagenerador().get(0).getIdimpgenerador();// se coge el primero de la lista que es el activo
				ArrayList<ArrayList<Object>> res = this.segdao.getEstadisticasSeguimiento(this.cp.getPacienteSelect().getCodigo(),idimpgen);
				this.setChartDataBatV(null);
				this.setChartDataBatImp(null);
				this.pintaGraficaBat(res);
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("seg_disp_msg_genera_est_bateria")+": "+e1.getCause().toString());
			logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString(),e1);
		}
	}
	
	public void generarEstadisticasElectrodos(ActionEvent e){
		try{
			// Se hace un muestreo hasta la fecha actual de consulta y solo sobre los electrodos del momento activos
			Date fecha_muestreo = (this.proc!=null && this.proc.getFecha()!=null)?this.proc.getFecha():new Date();			
			ArrayList<ArrayList<Object>> res = this.segdao.getEstadisticasElectrodosSeguimiento(this.cp.getPacienteSelect().getCodigo(),fecha_muestreo);		
			
			this.setChartDataElecOndaRP(null);
			this.setChartDataElecImpedancia(null);
			this.setChartDataElecUmbralV(null);
			this.setChartDataElecDurImp(null);
			this.setChartDataElecAmpl(null);
			this.setChartDataElecSens(null);
			
			this.pintaGraficaElectrodos(res);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("seg_disp_msg_genera_est_elecs")+": "+e1.getCause().toString());
			logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString(),e1);
		}
	}
	
	public void pintaGraficaSitClin(ArrayList<ArrayList<Object>> res){
		XYDataList l_fevi = new XYDataList();
		String v1 = null;//fevi
		Date d=null;
		for(int i=0;i<res.size();i++){
			// Eje: XY. X -> fechas, Y -> valores de fevi	
			d = (Date)res.get(i).get(0);
			v1 = (String)res.get(i).get(1);
			if(v1!=null && !v1.equals("") && UtilDatos.esNumero(v1)){// Solo se añaden a la lista de estadistica aquellas valores no nulos			
				XYDataPoint item = new XYDataPoint(d.getTime(),Double.parseDouble(v1.trim()));
				l_fevi.addDataPoint(item);
			}	
		}	
		this.setChartDataSitClinFevi(new FlotChartRendererData());
		if(this.valoressitclinfevi!=null)
			this.valoressitclinfevi.clear();
		this.valoressitclinfevi = l_fevi;
		this.ordenaLista(this.valoressitclinfevi.getDataPointList());
	}
	
	public void pintaGraficaBat(ArrayList<ArrayList<Object>> res){
		XYDataList l_v = new XYDataList();
		XYDataList l_imp = new XYDataList();
		// Los valores de bateria interesantes son: 1 (Voltaje),2 (Impedancia),3(F.magnetica).
		// Hay que tomar también las fechas: 0 (Date)
		String v1 = null, v2= null;
		Date d=null;
		for(int i=0;i<res.size();i++){
			// Eje: XY. X -> fechas, Y -> valores de voltaje	
			d = (Date)res.get(i).get(0);
			v1 = (String)res.get(i).get(1);
			v2 = (String)res.get(i).get(2);
			if(v1!=null && !v1.equals("") && UtilDatos.esNumero(v1)){// Solo se añaden a la lista de estadistica aquellas valores no nulos			
				XYDataPoint item = new XYDataPoint(d.getTime(),Double.parseDouble(v1.trim()));
				l_v.addDataPoint(item);
			}
			if(v2!=null && !v2.equals("") && UtilDatos.esNumero(v2)){// Solo se añaden a la lista de estadistica aquellas valores no nulos			
				XYDataPoint item = new XYDataPoint(d.getTime(),Double.parseDouble(v2.trim()));
				l_imp.addDataPoint(item);
			}
		}	
		this.setChartDataBatV(new FlotChartRendererData());
		this.setChartDataBatImp(new FlotChartRendererData());
		if(this.valoresbatv!=null)
			this.valoresbatv.clear();
		if(this.valoresbatimp!=null)
			this.valoresbatimp.clear();
		this.valoresbatv = l_v;
		this.valoresbatimp = l_imp;
		this.ordenaLista(this.valoresbatv.getDataPointList());
		this.ordenaLista(this.valoresbatimp.getDataPointList());
	}
	
	public void pintaGraficaElectrodos(ArrayList<ArrayList<Object>> res){
		// un XYDataList por cada electrodo activo del sistema
		// Los diferenciasmos por el NS y el IDElectrodo
		ArrayList<XYDataList> listaelorp = new ArrayList<XYDataList>();
		ArrayList<XYDataList> listaelumbv = new ArrayList<XYDataList>();
		ArrayList<XYDataList> listaelimp = new ArrayList<XYDataList>();
		ArrayList<XYDataList> listaeldurimp = new ArrayList<XYDataList>();
		ArrayList<XYDataList> listaelampl = new ArrayList<XYDataList>();
		ArrayList<XYDataList> listaelsens = new ArrayList<XYDataList>();
		XYDataList l = null;
		Integer v1 = null;
		String v2= null,v3=null,v5=null,v6=null,v7=null,v8=null,v9=null;
		Integer v4 = null;
		Date d=null;
		int pos = -1;
		for(int i=0;i<res.size();i++){
			d = (Date)res.get(i).get(0);//fecha proc
			v1 = (Integer)res.get(i).get(1);//camara
			v2 = (String)res.get(i).get(2);// nserie
			v4 = (Integer)res.get(i).get(3);// idelectrodo
			v3 = (String)res.get(i).get(4);//onda rp
			v5 = (String)res.get(i).get(5);//umbral v
			v6 = (String)res.get(i).get(7);//impedancia
			v7 = (String)res.get(i).get(8);//dur.imp
			v8 = (String)res.get(i).get(9);//amplitud
			v9 = (String)res.get(i).get(10);//sensibilidad
			
			// ondarp
			this.gestionLista(1,listaelorp, d, v3, v4, v1, v2);
			// impedancia
			this.gestionLista(2,listaelimp, d, v6, v4, v1, v2);
			// umbral v
			this.gestionLista(3,listaelumbv, d, v5, v4, v1, v2);
			// duracion impulso
			this.gestionLista(4,listaeldurimp, d, v7, v4, v1, v2);
			// amplitud
			this.gestionLista(5,listaelampl, d, v8, v4, v1, v2);
			//sensibilidad
			this.gestionLista(6,listaelsens, d, v9, v4, v1, v2);
		}
		
		this.setChartDataElecOndaRP(new FlotChartRendererData());
		this.setChartDataElecImpedancia(new FlotChartRendererData());
		this.setChartDataElecUmbralV(new FlotChartRendererData());
		this.setChartDataElecDurImp(new FlotChartRendererData());
		this.setChartDataElecAmpl(new FlotChartRendererData());
		this.setChartDataElecSens(new FlotChartRendererData());
		if(this.valoreselecondarp!=null)
			this.valoreselecondarp.clear();
		if(this.valoreselecimpedancia!=null)
			this.valoreselecimpedancia.clear();
		if(this.valoreselecumbralv!=null)
			this.valoreselecumbralv.clear();
		if(this.valoreselecdurimp!=null)
			this.valoreselecdurimp.clear();
		if(this.valoreselecampl!=null)
			this.valoreselecampl.clear();
		if(this.valoreselecsens!=null)
			this.valoreselecsens.clear();
		
		this.valoreselecondarp = listaelorp;
		this.valoreselecimpedancia = listaelimp;
		this.valoreselecumbralv = listaelumbv;
		this.valoreselecdurimp = listaeldurimp;
		this.valoreselecampl = listaelampl;
		this.valoreselecsens = listaelsens;
	}
	
	private void gestionLista(int tipo,ArrayList<XYDataList> lista, Date fecha, String valor,Integer idel, Integer cam, String ns){		
		XYDataList l = null;
		int pos = -1;
		// busca lista asociada por idelectrodo + ns. Si no la encuentra, crea una lista nueva
		pos = this.buscaLista(lista, idel, cam, ns);						
		if(pos!=-1)
			l = lista.get(pos);
		else{ // crea un nuevo item de lista XY
			l = new XYDataList();	
			l.setColor(ns+"("+String.valueOf(idel)+")");
			l.setLabel(this.mapeoCamara(cam));
			lista.add(l);
		}		
		if(valor!=null && !valor.equals("") && UtilDatos.esNumero(valor)){ 
			XYDataPoint item = new XYDataPoint(fecha.getTime(),Double.parseDouble(valor.trim()));
			l.addDataPoint(item);
		}	
	}
	
	private int buscaLista(ArrayList<XYDataList> lista, Integer idel, Integer cam, String ns){
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).getColor().equals(ns+"("+String.valueOf(idel)+")"))
				return i;
		}
		return -1;
	}
	
	private void ordenaLista(List<XYDataPoint> lista){
		Collections.sort(lista, new Comparator() {
			public int compare(Object o1, Object o2) {
				XYDataPoint p1 = (XYDataPoint) o1;
				XYDataPoint p2 = (XYDataPoint) o2;
				Long e1 = (Long) p1.getX();
				Long e2 = (Long) p2.getX();
				if (e1 > e2) {
					return 1;
				} else if (e1 < e2) {
					return -1;
				} else {
					return 0;
				}
			}
		});
	}
	
	public void mostrarEstadisticas(ActionEvent e){
		if(this.isAdicionales())
			this.setAdicionales(false);
		else
			this.setAdicionales(true);
	}
	
	private String mapeoCamara(Integer i){
		if(i==948)
			return "AD";
		else if(i==949)
			return "VD";
		else if(i==950)
			return "VI";
		else
			return "";
	}
	
	public ArrayList<SelectItem> getGeneradores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_modelo")));
		for (Generador ref : this.generadores)
			diag.add(new SelectItem(String.valueOf(ref.getIdgenerador()), ref
					.getModelo()));
		return diag;
	}

	public ArrayList<SelectItem> getElectrodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_modelo")));
		for (com.sorin.idea.dto.Electrodos ref : this.electrodos)
			diag.add(new SelectItem(String.valueOf(ref.getIdelectrodo()), ref
					.getModelo()));
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
	public ArrayList<SelectItem> getLocalizaciongen() {
		ArrayList<SelectItem> loc = new ArrayList<SelectItem>();
		loc.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras l : this.localizaciongen)
			loc.add(new SelectItem(l.getCodigo().toString(),
					l.getValor()));
		return loc;
	}
	public ArrayList<SelectItem> getTipocomplicacion() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.tipocomplicacion)
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		return c;
	}

	public ArrayList<SelectItem> getLcompsegtec() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesseg) {
			if (m.getTipo().equals("1088"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcompsegarr() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesseg) {
			if (m.getTipo().equals("1086"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcompsegproc() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesseg) {
			if (m.getTipo().equals("1087"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcompsegresp() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesseg) {
			if (m.getTipo().equals("1089"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}

	public ArrayList<SelectItem> getLcompsegmuerte() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicacion m : this.complicacionesseg) {
			if (m.getTipo().equals("1090"))
				c.add(new SelectItem(m.getIdcompl(), m.getClase()));
		}
		return c;
	}
	public ArrayList<SelectItem> getModogen() {
		ArrayList<SelectItem> m = new ArrayList<SelectItem>();
		m.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		/*for (ArrMaestras mg : this.modogen)
			m.add(new SelectItem(mg.getCodigo(), mg.getValor()));*/
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
			// TODO - S-ICD
		}
		return m;
	}
	public ArrayList<SelectItem> getTipoproc(){
		ArrayList<SelectItem> pr = new ArrayList<SelectItem>();
		for (ArrMaestras procedimiento:this.tipoproc)
			pr.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));
		return pr;
	}
	public ArrayList<SelectItem> getPrimerop() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.primerop)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getEnfop() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_personal")));
		for (ArrMaestras diagnostico : this.enfop)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getMotivosterapianoapropiada() {
		ArrayList<SelectItem> m = new ArrayList<SelectItem>();
		m.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras mg : this.motivosterapianoapropiada)
			m.add(new SelectItem(mg.getCodigo(), mg
					.getValor()));
		return m;
	}
	
	public SegPorestimulacion getPor() {
		return por;
	}

	public void setPor(SegPorestimulacion por) {
		this.por = por;
	}

	public HtmlDataTable getBindingGen() {
		return bindingGen;
	}

	public void setBindingGen(HtmlDataTable bindingGen) {
		this.bindingGen = bindingGen;
	}

	public HtmlDataTable getBindingElec() {
		return bindingElec;
	}

	public void setBindingElec(HtmlDataTable bindingElec) {
		this.bindingElec = bindingElec;
	}

	public HtmlDataTable getBindingComplicaciones() {
		return bindingComplicaciones;
	}

	public void setBindingComplicaciones(HtmlDataTable bindingComplicaciones) {
		this.bindingComplicaciones = bindingComplicaciones;
	}

	public HtmlDataTable getBindingSintomas() {
		return bindingSintomas;
	}

	public void setBindingSintomas(HtmlDataTable bindingSintomas) {
		this.bindingSintomas = bindingSintomas;
	}

	public SegSeguimiento getSeg() {
		return seg;
	}

	public void setSeg(SegSeguimiento seg) {
		this.seg = seg;
	}

	public SituacionClinicaProc getSitclin() {
		return sitclin;
	}

	public void setSitclin(SituacionClinicaProc sitclin) {
		this.sitclin = sitclin;
	}

	public SegSistema getSist() {
		return sist;
	}

	public void setSist(SegSistema sist) {
		this.sist = sist;
	}

	public SegBloqueos getBloq() {
		return bloq;
	}

	public void setBloq(SegBloqueos bloq) {
		this.bloq = bloq;
	}

	public SegObservacionesMp getObsmp() {
		return obsmp;
	}

	public void setObsmp(SegObservacionesMp obsmp) {
		this.obsmp = obsmp;
	}

	public SegObservacionesDai getObsdai() {
		return obsdai;
	}

	public void setObsdai(SegObservacionesDai obsdai) {
		this.obsdai = obsdai;
	}

	public Complicacion[] getComplicacionesseg() {
		return complicacionesseg;
	}

	public void setComplicacionesseg(Complicacion[] complicacionesseg) {
		this.complicacionesseg = complicacionesseg;
	}

	public ArrayList<SegComplicaciones> getListacomplicaciones() {
		return listacomplicaciones;
	}

	public void setListacomplicaciones(
			ArrayList<SegComplicaciones> listacomplicaciones) {
		this.listacomplicaciones = listacomplicaciones;
	}

	public ImpEvolucion getHev() {
		return hev;
	}

	public void setHev(ImpEvolucion hev) {
		this.hev = hev;
	}

	public boolean isSegRem() {
		return segRem;
	}

	public void setSegRem(boolean segRem) {
		this.segRem = segRem;
	}

	public boolean isMinEstVent() {
		return minEstVent;
	}

	public void setMinEstVent(boolean minEstVent) {
		this.minEstVent = minEstVent;
	}

	public int getTipogen() {
		return tipogen;
	}

	public void setTipogen(int tipogen) {
		this.tipogen = tipogen;
	}

	public HtmlDataGrid getBindingGrid() {
		return bindingGrid;
	}

	public void setBindingGrid(HtmlDataGrid bindingGrid) {
		this.bindingGrid = bindingGrid;
	}

	public boolean isAvzona() {
		return avzona;
	}

	public void setAvzona(boolean avzona) {
		this.avzona = avzona;
	}

	public HtmlDataTable getBindingChoques() {
		return bindingChoques;
	}

	public void setBindingChoques(HtmlDataTable bindingChoques) {
		this.bindingChoques = bindingChoques;
	}

	public int getOptint() {
		return optint;
	}

	public void setOptint(int optint) {
		this.optint = optint;
	}

	public ArrayList<ImpGenerador> getListagenerador() {
		return listagenerador;
	}

	public void setListagenerador(ArrayList<ImpGenerador> listagenerador) {
		this.listagenerador = listagenerador;
	}

	public ImpGeneradorDao getGendao() {
		return gendao;
	}

	public void setGendao(ImpGeneradorDao gendao) {
		this.gendao = gendao;
	}

	public ImpImplanteDao getImpdao() {
		return impdao;
	}

	public void setImpdao(ImpImplanteDao impdao) {
		this.impdao = impdao;
	}

	public ImpImplante[] getListaimpl() {
		return listaimpl;
	}

	public void setListaimpl(ImpImplante[] listaimpl) {
		this.listaimpl = listaimpl;
	}

	public boolean isSegprevio() {
		return segprevio;
	}

	public void setSegprevio(boolean segprevio) {
		this.segprevio = segprevio;
	}

	public ProcedimientoDao getProcdao() {
		return procdao;
	}

	public void setProcdao(ProcedimientoDao procdao) {
		this.procdao = procdao;
	}

	public ComplicacionDao getCompdao() {
		return compdao;
	}

	public void setCompdao(ComplicacionDao compdao) {
		this.compdao = compdao;
	}

	public GeneradorDao getGeneradoresdao() {
		return generadoresdao;
	}

	public void setGeneradoresdao(GeneradorDao generadoresdao) {
		this.generadoresdao = generadoresdao;
	}

	public void setGeneradores(Generador[] generadores) {
		this.generadores = generadores;
	}

	public ArrayList<ImpImplanteElectrodosPk> getListaelectrodospk() {
		return listaelectrodospk;
	}

	public void setListaelectrodospk(ArrayList<ImpImplanteElectrodosPk> listaelectrodospk) {
		this.listaelectrodospk = listaelectrodospk;
	}

	public ElectrodosDao getElectrodosdao() {
		return electrodosdao;
	}

	public void setElectrodosdao(ElectrodosDao electrodosdao) {
		this.electrodosdao = electrodosdao;
	}

	public void setElectrodos(Electrodos[] electrodos) {
		this.electrodos = electrodos;
	}

	public ImpImplanteElectrodosDao getImpelecdao() {
		return impelecdao;
	}

	public void setImpelecdao(ImpImplanteElectrodosDao impelecdao) {
		this.impelecdao = impelecdao;
	}

	public ArrayList<ImpImplanteElectrodos> getListaelectrodosseg() {
		return listaelectrodosseg;
	}

	public void setListaelectrodosseg(
			ArrayList<ImpImplanteElectrodos> listaelectrodosseg) {
		this.listaelectrodosseg = listaelectrodosseg;
	}

	public boolean isCablea() {
		return cablea;
	}

	public void setCablea(boolean cablea) {
		this.cablea = cablea;
	}

	public boolean isCablev() {
		return cablev;
	}

	public void setCablev(boolean cablev) {
		this.cablev = cablev;
	}

	public boolean isActualizacion() {
		return actualizacion;
	}

	public void setActualizacion(boolean actualizacion) {
		this.actualizacion = actualizacion;
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

	public ImpChoquesDao getChoquedao() {
		return choquedao;
	}

	public void setChoquedao(ImpChoquesDao choquedao) {
		this.choquedao = choquedao;
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

	public boolean isPrevimp() {
		return previmp;
	}

	public void setPrevimp(boolean previmp) {
		this.previmp = previmp;
	}

	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public ProcedimientoPk getProcpk() {
		return procpk;
	}

	public void setProcpk(ProcedimientoPk procpk) {
		this.procpk = procpk;
	}

	public SituacionClinicaProcDao getSitclindao() {
		return sitclindao;
	}

	public void setSitclindao(SituacionClinicaProcDao sitclindao) {
		this.sitclindao = sitclindao;
	}

	public SituacionClinicaProcPk getSitclinpk() {
		return sitclinpk;
	}

	public void setSitclinpk(SituacionClinicaProcPk sitclinpk) {
		this.sitclinpk = sitclinpk;
	}

	public SegSeguimientoDao getSegdao() {
		return segdao;
	}

	public void setSegdao(SegSeguimientoDao segdao) {
		this.segdao = segdao;
	}

	public SegSeguimientoPk getSegpk() {
		return segpk;
	}

	public void setSegpk(SegSeguimientoPk segpk) {
		this.segpk = segpk;
	}

	public SegSistemaDao getSistdao() {
		return sistdao;
	}

	public void setSistdao(SegSistemaDao sistdao) {
		this.sistdao = sistdao;
	}

	public SegSistemaPk getSistpk() {
		return sistpk;
	}

	public void setSistpk(SegSistemaPk sistpk) {
		this.sistpk = sistpk;
	}

	public SegBloqueosDao getBloqdao() {
		return bloqdao;
	}

	public void setBloqdao(SegBloqueosDao bloqdao) {
		this.bloqdao = bloqdao;
	}

	public SegBloqueosPk getBloqpk() {
		return bloqpk;
	}

	public void setBloqpk(SegBloqueosPk bloqpk) {
		this.bloqpk = bloqpk;
	}

	public SegPorestimulacionDao getPordao() {
		return pordao;
	}

	public void setPordao(SegPorestimulacionDao pordao) {
		this.pordao = pordao;
	}

	public SegPorestimulacionPk getPorpk() {
		return porpk;
	}

	public void setPorpk(SegPorestimulacionPk porpk) {
		this.porpk = porpk;
	}

	public SegObservacionesMpDao getObsmpdao() {
		return obsmpdao;
	}

	public void setObsmpdao(SegObservacionesMpDao obsmpdao) {
		this.obsmpdao = obsmpdao;
	}

	public SegObservacionesMpPk getObsmppk() {
		return obsmppk;
	}

	public void setObsmppk(SegObservacionesMpPk obsmppk) {
		this.obsmppk = obsmppk;
	}

	public SegObservacionesDaiDao getObsdaidao() {
		return obsdaidao;
	}

	public void setObsdaidao(SegObservacionesDaiDao obsdaidao) {
		this.obsdaidao = obsdaidao;
	}

	public SegObservacionesDaiPk getObsdaipk() {
		return obsdaipk;
	}

	public void setObsdaipk(SegObservacionesDaiPk obsdaipk) {
		this.obsdaipk = obsdaipk;
	}

	public ImpEvolucionDao getHevdao() {
		return hevdao;
	}

	public void setHevdao(ImpEvolucionDao hevdao) {
		this.hevdao = hevdao;
	}

	public ImpEvolucionPk getHevpk() {
		return hevpk;
	}

	public void setHevpk(ImpEvolucionPk hevpk) {
		this.hevpk = hevpk;
	}

	public SegComplicacionesDao getCompsegdao() {
		return compsegdao;
	}

	public void setCompsegdao(SegComplicacionesDao compsegdao) {
		this.compsegdao = compsegdao;
	}

	public SintomasSitclinProcDao getSintsegdao() {
		return sintsegdao;
	}

	public void setSintsegdao(SintomasSitclinProcDao sintsegdao) {
		this.sintsegdao = sintsegdao;
	}

	public int getIdimp() {
		return idimp;
	}

	public void setIdimp(int idimp) {
		this.idimp = idimp;
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

	public ArrayList<Procedimiento> getProcs() {
		return procs;
	}

	public void setProcs(ArrayList<Procedimiento> procs) {
		this.procs = procs;
	}

	public Procedimiento[] getLstprocsseg() {
		return lstprocsseg;
	}

	public void setLstprocsseg(Procedimiento[] lstprocsseg) {
		this.lstprocsseg = lstprocsseg;
	}

	public boolean isCompletado() {
		return completado;
	}

	public void setCompletado(boolean completado) {
		this.completado = completado;
	}

	public boolean isReintervencion() {
		return reintervencion;
	}

	public void setReintervencion(boolean reintervencion) {
		this.reintervencion = reintervencion;
	}
	public void nada(ActionEvent e){
		System.out.println(this.reintervencion);
		for(SegComplicaciones c:this.listacomplicaciones)
			if(c.getResultado().equals("3")){
				this.setReintervencion(true);
				System.out.println("REINTERVENCION");
				break;
			}
	}
	public void lecturaProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
		p.load(is);
		is.close();
		this.prop = new Properties();
		is = ControlCitas.class.getResourceAsStream("agenda.properties");
		this.prop.load(is);
		this.TAM_HUECO = Integer.parseInt(this.prop.getProperty("hueco.duracion"));
		this.HUECO_SEG_MPS = Integer.parseInt(this.prop.getProperty("hueco.seg.mps"));
		this.HUECO_SEG_DAI = Integer.parseInt(this.prop.getProperty("hueco.seg.dai"));
		this.HUECO_SEG_CRTP = Integer.parseInt(this.prop.getProperty("hueco.seg.crtp"));
		this.HUECO_SEG_CRTD = Integer.parseInt(this.prop.getProperty("hueco.seg.crtd"));
		this.WORKING_INI = Integer.parseInt(this.prop.getProperty("working.inicio"));
		this.WORKING_FIN = Integer.parseInt(this.prop.getProperty("working.fin"));
		is.close();
		this.infocentro = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
					p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"));
	}

	public boolean isHayVI() {
		return hayVI;
	}

	public void setHayVI(boolean hayVI) {
		this.hayVI = hayVI;
	}
	/**
	 * Funcion para validar formulario EEF a guardar. Control de inconsistencia de información a guardar
	 * @return
	 */
	private boolean validaFormulario(){
		boolean res = true;
		int dup = 0;
		// Complicaciones intra
		for(SegComplicaciones e:this.listacomplicaciones){
			if((e.getIdcomp()==null && (e.getOtra()==null ||e.getOtra().equals(""))) || (e.getIdcomp()!=null && e.getIdcomp()==0)){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_seg_noinfo"));
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_compl_seg_dupl"));
				res = false;
			}
			if(e.getTipocomp()==null || e.getTipocomp().equals("0")){// control de complicaciones sin tipo asignado
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_seg_noinfo"));
				res = false;
			}
		}
		// Sintomas
		dup = 0;
		for(SintomasSitclinProc s:this.sitclin.getSintomas()){
			if(s.getIdsintomas()==null ||s.getIdsintomas().equals("0")){
				dup++;
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_sitclin_sintoma_noinfo"));
			}
			if(dup>1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_sitclin_sintoma_duplic"));
				res = false;
			}		
		}	
		return res;	
	}

	public Informes getInf() {
		return inf;
	}

	public void setInf(Informes inf) {
		this.inf = inf;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public String getDuracion_evento() {
		return duracion_evento;
	}

	public void setDuracion_evento(String duracion_evento) {
		this.duracion_evento = duracion_evento;
	}

	public Episodio getEpisodio() {
		return episodio;
	}

	public void setEpisodio(Episodio episodio) {
		this.episodio = episodio;
	}

	public void setChartDataBatV(FlotChartRendererData chartDataBatV) {
		this.chartDataBatV = chartDataBatV;
	}
	public XYDataSetCollection getChartDataBatV() {
        XYDataSetCollection collection = new XYDataSetCollection();
       if(this.valoresbatv!=null)
    	   collection.addDataList(this.valoresbatv);	       
        return collection;
	}

	public void setChartDataBatImp(FlotChartRendererData chartDataBatImp) {
		this.chartDataBatImp = chartDataBatImp;
	}
	
	public XYDataSetCollection getChartDataBatImp() {
        XYDataSetCollection collection = new XYDataSetCollection();
       if(this.valoresbatimp!=null)
    	   collection.addDataList(this.valoresbatimp);	       
        return collection;
	}

	public void setChartDataElecOndaRP(FlotChartRendererData chartDataElecOndaRP) {
		this.chartDataElecOndaRP = chartDataElecOndaRP;
	}
	
	public XYDataSetCollection getChartDataElecOndaRP() {
		XYDataSetCollection collection = new XYDataSetCollection();
	    if(this.valoreselecondarp!=null)
		   for(XYDataList item:this.valoreselecondarp)
		      collection.addDataList(item);
	    return collection;
	}

	public XYDataSetCollection getChartDataElecUmbralV() {
		XYDataSetCollection collection = new XYDataSetCollection();
	    if(this.valoreselecumbralv!=null)
		   for(XYDataList item:this.valoreselecumbralv)
		      collection.addDataList(item);
	    return collection;
	}
	
	public void setChartDataElecUmbralV(FlotChartRendererData chartDataElecUmbralV) {
		this.chartDataElecUmbralV = chartDataElecUmbralV;
	}

	public XYDataSetCollection getChartDataElecImpedancia() {
		XYDataSetCollection collection = new XYDataSetCollection();
	    if(this.valoreselecimpedancia!=null)
		   for(XYDataList item:this.valoreselecimpedancia)
		      collection.addDataList(item);
	    return collection;
	}
	
	public void setChartDataElecImpedancia(FlotChartRendererData chartDataElecImpedancia) {
		this.chartDataElecImpedancia = chartDataElecImpedancia;
	}

	public XYDataSetCollection getChartDataElecDurImp() {
		XYDataSetCollection collection = new XYDataSetCollection();
	    if(this.valoreselecdurimp!=null)
		   for(XYDataList item:this.valoreselecdurimp)
		      collection.addDataList(item);
	    return collection;
	}
	
	public void setChartDataElecDurImp(FlotChartRendererData chartDataElecDurImp) {
		this.chartDataElecDurImp = chartDataElecDurImp;
	}

	public XYDataSetCollection getChartDataElecAmpl() {
		XYDataSetCollection collection = new XYDataSetCollection();
	    if(this.valoreselecampl!=null)
		   for(XYDataList item:this.valoreselecampl)
		      collection.addDataList(item);
	    return collection;
	}
	
	public void setChartDataElecAmpl(FlotChartRendererData chartDataElecAmpl) {
		this.chartDataElecAmpl = chartDataElecAmpl;
	}

	public XYDataSetCollection getChartDataElecSens() {
		XYDataSetCollection collection = new XYDataSetCollection();
	    if(this.valoreselecsens!=null)
		   for(XYDataList item:this.valoreselecsens)
		      collection.addDataList(item);
	    return collection;
	}
	
	public void setChartDataElecSens(FlotChartRendererData chartDataElecSens) {
		this.chartDataElecSens = chartDataElecSens;
	}

	public XYDataSetCollection getChartDataSitClinFevi() {
        XYDataSetCollection collection = new XYDataSetCollection();
       if(this.valoressitclinfevi!=null)
    	   collection.addDataList(this.valoressitclinfevi);	       
        return collection;
	}

	public void setChartDataSitClinFevi(FlotChartRendererData chartDataSitClinFevi) {
		this.chartDataSitClinFevi = chartDataSitClinFevi;
	}

	public boolean isAdicionales() {
		return adicionales;
	}

	public void setAdicionales(boolean adicionales) {
		this.adicionales = adicionales;
	}

	private String obtenerConectorVi(){
		if(this.listaelectrodosseg!=null)
			for(ImpImplanteElectrodos e:this.listaelectrodosseg){
				if(e.getCamara().equals(950) && e.getEstado().equals(0))
					return e.getConector();
			}
		return null;
	}
	private String obtenerPolaridadVi(){
		if(this.listaelectrodosseg!=null)
			for(ImpImplanteElectrodos e:this.listaelectrodosseg){
				if(e.getCamara().equals(950) && e.getEstado().equals(0))
					return e.getPolaridad();
			}
		return null;
	}
	private Integer obtenerVectorVi1(){
		if(this.listaelectrodosseg!=null)
			for(ImpImplanteElectrodos e:this.listaelectrodosseg){
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

	public boolean isPleno() {
		return pleno;
	}

	public void setPleno(boolean pleno) {
		this.pleno = pleno;
	}

	public ArrayList<NotasPreviasBean> getNotasprevias() {
		return notasprevias;
	}

	public void setNotasprevias(ArrayList<NotasPreviasBean> notasprevias) {
		this.notasprevias = notasprevias;
	}

	public HtmlDataTable getBindingNotasPrevias() {
		return bindingNotasPrevias;
	}

	public void setBindingNotasPrevias(HtmlDataTable bindingNotasPrevias) {
		this.bindingNotasPrevias = bindingNotasPrevias;
	}

	public Integer getPagina_inicial() {
		return pagina_inicial;
	}

	public void setPagina_inicial(Integer pagina_inicial) {
		this.pagina_inicial = pagina_inicial;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isMuestraModalNuevoSeg() {
		return muestraModalNuevoSeg;
	}

	public void setMuestraModalNuevoSeg(boolean muestraModalNuevoSeg) {
		this.muestraModalNuevoSeg = muestraModalNuevoSeg;
	}

	public HtmlDataTable getBindingNuevosSeg() {
		return bindingNuevosSeg;
	}

	public void setBindingNuevosSeg(HtmlDataTable bindingNuevosSeg) {
		this.bindingNuevosSeg = bindingNuevosSeg;
	}

	public ArrayList<Procedimiento> getListanuevosseg() {
		return listanuevosseg;
	}

	public void setListanuevosseg(ArrayList<Procedimiento> listanuevosseg) {
		this.listanuevosseg = listanuevosseg;
	}
/*
	public String getModogenini() {
		return modogenini;
	}

	public void setModogenini(String modogenini) {
		this.modogenini = modogenini;
	}*/

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

	public HtmlDataTable getBindingComplicacionesSegProc() {
		return bindingComplicacionesSegProc;
	}

	public void setBindingComplicacionesSegProc(
			HtmlDataTable bindingComplicacionesSegProc) {
		this.bindingComplicacionesSegProc = bindingComplicacionesSegProc;
	}

	public ArrayList<ComplicacionesPacientes> getListacomp() {
		return listacomp;
	}

	public void setListacomp(ArrayList<ComplicacionesPacientes> listacomp) {
		this.listacomp = listacomp;
	}

	public boolean isEditableSegProc() {
		return editableSegProc;
	}

	public void setEditableSegProc(boolean editableSegProc) {
		this.editableSegProc = editableSegProc;
	}

	public String getModogenini() {
		return modogenini;
	}

	public void setModogenini(String modogenini) {
		this.modogenini = modogenini;
	}
}

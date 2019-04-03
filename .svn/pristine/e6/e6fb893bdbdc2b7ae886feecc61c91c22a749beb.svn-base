package com.sorin.idea.iu;

import hvn.cm.dao.DAOException;
import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;
import hvn.cm.utiles.UtilFechas;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.faces.FacesException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.jsflot.components.FlotChartRendererData;
import org.jsflot.xydata.XYDataList;
import org.jsflot.xydata.XYDataPoint;
import org.jsflot.xydata.XYDataSetCollection;
import org.richfaces.component.html.HtmlDataGrid;
import org.richfaces.component.html.HtmlTree;
import org.richfaces.event.NodeSelectedEvent;
import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import com.sorin.idea.dao.ArrAnualCentroDao;
import com.sorin.idea.dao.ArrAnualLabDao;
import com.sorin.idea.dao.ArrAnualSubstratosDao;
import com.sorin.idea.dao.ArrAnualTecnicasDao;
import com.sorin.idea.dao.ArrCardioversionDao;
import com.sorin.idea.dao.ArrDatosMesDao;
import com.sorin.idea.dao.ArrEstudioDao;
import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ArrMesasDao;
import com.sorin.idea.dao.ArrPacientesDao;
import com.sorin.idea.dao.ArrRegistradorDao;
import com.sorin.idea.dao.ArrTestAtpDao;
import com.sorin.idea.dao.ArrTestEpiDao;
import com.sorin.idea.dao.ArrTestFleDao;
import com.sorin.idea.dao.ComplicacionesDao;
import com.sorin.idea.dao.ComplicacionesPacientesDao;
import com.sorin.idea.dao.ConsultasDao;
import com.sorin.idea.dao.HolterDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.RegistradorEventosExtDao;
import com.sorin.idea.dao.RegistradoreventosDao;
import com.sorin.idea.dao.SegSeguimientoDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dto.ArrAccesoModulos;
import com.sorin.idea.dto.ArrAnual;
import com.sorin.idea.dto.ArrAnualCentro;
import com.sorin.idea.dto.ArrAnualLab;
import com.sorin.idea.dto.ArrAnualSubstratos;
import com.sorin.idea.dto.ArrAnualTecnicas;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrDatosMes;
import com.sorin.idea.dto.ArrDatosMesPk;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Complicaciones;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.DatoEstAnual;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.Registradoreventos;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.exceptions.ArrAnualCentroDaoException;
import com.sorin.idea.exceptions.ArrAnualLabDaoException;
import com.sorin.idea.exceptions.ArrAnualSubstratosDaoException;
import com.sorin.idea.exceptions.ArrAnualTecnicasDaoException;
import com.sorin.idea.exceptions.ArrDatosMesDaoException;
import com.sorin.idea.exceptions.ArrMaestrasDaoException;
import com.sorin.idea.exceptions.ArrPacientesDaoException;
import com.sorin.idea.exceptions.ComplicacionesDaoException;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.exceptions.SituacionClinicaGeneralDaoException;
import com.sorin.idea.jdbc.ArrAnualCentroDaoImpl;
import com.sorin.idea.jdbc.ArrAnualLabDaoImpl;
import com.sorin.idea.jdbc.ArrAnualSubstratosDaoImpl;
import com.sorin.idea.jdbc.ArrAnualTecnicasDaoImpl;
import com.sorin.idea.jdbc.ArrCardioversionDaoImpl;
import com.sorin.idea.jdbc.ArrDatosMesDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioDaoImpl;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ArrMesasDaoImpl;
import com.sorin.idea.jdbc.ArrPacientesDaoImpl;
import com.sorin.idea.jdbc.ArrRegistradorDaoImpl;
import com.sorin.idea.jdbc.ArrTestAtpDaoImpl;
import com.sorin.idea.jdbc.ArrTestEpiDaoImpl;
import com.sorin.idea.jdbc.ArrTestFleDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesPacientesDaoImpl;
import com.sorin.idea.jdbc.HolterDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.RegistradorEventosExtDaoImpl;
import com.sorin.idea.jdbc.RegistradoreventosDaoImpl;
import com.sorin.idea.jdbc.SegSeguimientoDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.util.ConstructorExcel;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.ConstructorRtf;
import com.sorin.idea.util.CriterioSeleccion;
import com.sorin.idea.util.EstadisticasBasicas;
import com.sorin.idea.util.ExportExcel;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilCodifi;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilMapeos;

public class ControlEstadisticas extends BaseIU{

	private static Logger logger = Logger.getLogger(ControlEstadisticas.class);
	private LoginForm lf;
	private static final Integer INFORME_MENSUAL = 1;
	private static final Integer INFORME_ANUAL = 2;
	private String usuario;
	private SelectorIdioma si;
	private ResourceBundle bundle;
	
	private Integer maxanio = new Date().getYear() + 1901;
	private ArrDatosMes datosmes = new ArrDatosMes();
	private ArrDatosMesDao datosmesdao = new ArrDatosMesDaoImpl();
	private ArrayList<SelectItem> meses;
	private ControlMaestras cm;
	private ArrAnual anual = new ArrAnual();
	private ArrAnualCentroDao centrodao = new ArrAnualCentroDaoImpl();
	private ArrAnualLabDao labdao = new ArrAnualLabDaoImpl();
	private ArrAnualTecnicasDao tecdao = new ArrAnualTecnicasDaoImpl();
	private ArrAnualSubstratosDao susdao = new ArrAnualSubstratosDaoImpl();
	//mmb
	private ArrayList<DatoEstAnual> lstEstAnuales = new ArrayList<DatoEstAnual>();
	HtmlDataTable lstb = new HtmlDataTable();
	Integer mesMarcado;
	String descriMesMarcado;
	
	private ConsultasDao consdao = new ConsultasDao("consultor");
	
	//mmb
	// FRR
	/***************************/
	private int tipoconsulta;
	private String restexto;
	private ProcedimientoDao procdao;
	private SituacionClinicaGeneralDao sitclindao;
	
	private HtmlDataGrid bindingGrid;
	private HtmlDataGrid bindingGridCriterios;
	private TreeNode rootNode = null;
    private List<String> selectedNodeChildren = new ArrayList<String>();    
    private List<String> selectedParams;
    private List<String> selectedParamsKeys;
    private ArrayList<CriterioSeleccion> selectedCriteria;
    private String nodeTitle;
    private Properties p_est;
	private Properties c_est;
	private boolean cImp;
	private boolean cEF;
	private boolean cDemo;
	private boolean cSitclin;
	
	private ArrMaestras[] cardiopatia;
	private ArrMaestras[] modo;
	private ArrMaestras[] fabricante;
	
	/*****************************/
	/**********ESTADISTICA BASICA****************/
	private Date fechaini_gen;
	private Date fechafin_gen;
	private boolean est_gen;
	private ArrayList<EstadisticasBasicas> genprocs;
	private HtmlDataTable bindingGenProcs;
	private ArrayList<EstadisticasBasicas> gensegsrem;
	private HtmlDataTable bindingGenSegsRem;
	private ArrayList<EstadisticasBasicas> gensegs;
	private HtmlDataTable bindingGenSegs;
	private ArrayList<EstadisticasBasicas> genpatsexo;
	private HtmlDataTable bindingGenPatSexo;
	private ArrayList<EstadisticasBasicas> genpatcar;
	private HtmlDataTable bindingGenPatCar;
	private ArrayList<EstadisticasBasicas> genprocscomp;
	private HtmlDataTable bindingGenProcsComp;
	private ArrayList<EstadisticasBasicas> gentipocomp;
	private HtmlDataTable bindingGenTipoComp;
	
	private Date fechaini_mesa;
	private Date fechafin_mesa;
	private boolean est_mesa;
	private ArrayList<EstadisticasBasicas> mesares;
	private HtmlDataTable bindingMesaRes;
	/*private ArrayList<EstadisticasBasicas> mesantg;
	private HtmlDataTable bindingMesaNtg;*/
	private Date fechaini_reg;
	private Date fechafin_reg;
	private boolean est_reg;
	private ArrayList<EstadisticasBasicas> regind;
	private HtmlDataTable bindingRegInd;
	private ArrayList<EstadisticasBasicas> regmot;
	private HtmlDataTable bindingRegMot;
	private ArrayList<EstadisticasBasicas> regfab;
	private HtmlDataTable bindingRegFab;
	private ArrayList<EstadisticasBasicas> regcomp;
	private HtmlDataTable bindingRegComp;
	private ArrayList<EstadisticasBasicas> regcomptipo;
	private HtmlDataTable bindingRegCompTipo;
	private boolean est_holter;
	private Date fechaini_holter;
	private Date fechafin_holter;
	private ArrayList<EstadisticasBasicas> holdiagfin;
	private HtmlDataTable bindingHolDiagFin;
	private boolean est_regevext;
	private Date fechaini_regevext;
	private Date fechafin_regevext;
	private ArrayList<EstadisticasBasicas> regevextdiagfin;
	private HtmlDataTable bindingRegEvExtDiagFin;
	private Date fechaini_cv;
	private Date fechafin_cv;
	private boolean est_cv;
	private ArrayList<EstadisticasBasicas> cvind;
	private HtmlDataTable bindingCvInd;
	private ArrayList<EstadisticasBasicas> cvres;
	private HtmlDataTable bindingCvRes;
	private ArrayList<EstadisticasBasicas> cvabl;
	private HtmlDataTable bindingCvAbl;
	private ArrayList<EstadisticasBasicas> cvtipo;
	private HtmlDataTable bindingCvTipo;
	private ArrayList<EstadisticasBasicas> cvcomp;
	private HtmlDataTable bindingCvComp;
	private ArrayList<EstadisticasBasicas> cvcomptipo;
	private HtmlDataTable bindingCvCompTipo;
	private Date fechaini_test;
	private Date fechafin_test;
	private boolean est_test;
	private ArrayList<EstadisticasBasicas> testatp1;
	private HtmlDataTable bindingTestAtp1;
	/*private ArrayList<EstadisticasBasicas> testatp2;
	private HtmlDataTable bindingTestAtp2;*/
	private ArrayList<EstadisticasBasicas> testepi;
	private HtmlDataTable bindingTestEpi;
	private ArrayList<EstadisticasBasicas> testfle;
	private HtmlDataTable bindingTestFle;
	private Date fechaini_eef;
	private Date fechafin_eef;
	private boolean est_eef;
	private ArrayList<EstadisticasBasicas> eefcar;
	private HtmlDataTable bindingEefCar;
	private ArrayList<EstadisticasBasicas> eefdiag;
	private HtmlDataTable bindingEefDiag;
	/*private ArrayList<EstadisticasBasicas> eefproc;
	private HtmlDataTable bindingEefProc;*/
	private ArrayList<EstadisticasBasicas> eefint;
	private HtmlDataTable bindingEefInt;
	private ArrayList<EstadisticasBasicas> eefablsust;
	private HtmlDataTable bindingEefAblSust;
	private ArrayList<EstadisticasBasicas> eefablres;
	private HtmlDataTable bindingEefAblRes;
	private ArrayList<EstadisticasBasicas> eefcompdiag;
	private HtmlDataTable bindingEefCompDiag;
	private ArrayList<EstadisticasBasicas> eefcompabl;
	private HtmlDataTable bindingEefCompAbl;
	private ArrayList<EstadisticasBasicas> eefcompdiagtipo;
	private HtmlDataTable bindingEefCompDiagTipo;
	private ArrayList<EstadisticasBasicas> eefcompabltipo;
	private HtmlDataTable bindingEefCompAblTipo;
	private Date fechaini_imp;
	private Date fechafin_imp;
	private boolean est_imp;
	private ArrayList<EstadisticasBasicas> impproc;
	private HtmlDataTable bindingImpProc;
	private ArrayList<EstadisticasBasicas> impreintproc;
	private HtmlDataTable bindingImpReintProc;
	private ArrayList<EstadisticasBasicas> impaefab;
	private HtmlDataTable bindingImpAEFab;
	private ArrayList<EstadisticasBasicas> impaetipo;
	private HtmlDataTable bindingImpAETipo;
	private ArrayList<EstadisticasBasicas> impbefab;
	private HtmlDataTable bindingImpBEFab;
	private ArrayList<EstadisticasBasicas> impbetipo;
	private HtmlDataTable bindingImpBETipo;	
	private ArrayList<EstadisticasBasicas> impritmo;
	private HtmlDataTable bindingImpRitmo;
	private ArrayList<EstadisticasBasicas> impcav;
	private HtmlDataTable bindingImpCav;
	private ArrayList<EstadisticasBasicas> impqrs;
	private HtmlDataTable bindingImpQrs;
	private ArrayList<EstadisticasBasicas> impcomp;
	private HtmlDataTable bindingImpComp;
	private ArrayList<EstadisticasBasicas> impcomptipo;
	private HtmlDataTable bindingImpCompTipo;
	
	private String resgen1; // total procs
	private String resgen2;
	private String resgen3;
	private String resgen4;
	private String resgen5;
	//private String resgen6;
	private String resgen7;
	//private String resgen8;
	private Integer totalCompNoAsig;
	private String resmesa1; // total mesas
	//private String resmesa2;
	private String resreg1; // total registrador
	//private String resreg2;
	private String rescv1; // total de cv
	//private String rescv2;
	//private String rescv3;
	private String restest1; // total atps
	private String restest2; // total fle
	private String restest3; // total epi
	//private String restest4;
	private String reseef1; // total de eef
	//private String reseef2;
	//private String reseef3;
	//private String reseef4;
	//private String reseef5;// total de ablaciones
	//private String reseef6;
	//private String reseef7;
	private String resimp1;
	private String resimp2;
	private String resimp3;
	private String resimp4;
	private String resimp5;
	private String resimp6;
	private String resimp7;
	private String reshol1; // total diagnosticos fin
	private String resregevext1; // total diagnosticos fin
	
	private ArrPacientesDao pacdao;
	private ArrMesasDao mesadao;
	private ArrRegistradorDao regdao;
	private ArrCardioversionDao cvdao;
	private ArrTestAtpDao testatpdao;
	private ArrTestEpiDao testepidao;
	private ArrTestFleDao testfledao;
	private ArrEstudioDao eefdao;
	private ImpImplanteDao impdao;
	private HolterDao holdao;
	private RegistradorEventosExtDao regevextdao;
	private ArrMaestrasDao maestrasdao;
	private ComplicacionesPacientesDao compacdao;
	private ComplicacionesDao compdao;
	
	private FlotChartRendererData chartDataGen;
	private FlotChartRendererData chartDataTest;
	private FlotChartRendererData chartDataMesa;
	private FlotChartRendererData chartDataReg;
	private FlotChartRendererData chartDataCv;
	private FlotChartRendererData chartDataEef;
	private FlotChartRendererData chartDataImp;
	private FlotChartRendererData chartDataHol;
	private FlotChartRendererData chartDataRegEvExt;
	ArrayList<XYDataList> valores;
	/****************************************/
	private FlotChartRendererData chartDataGenProc;
	ArrayList<XYDataList> valoresgenproc;
	private FlotChartRendererData chartDataGenSexo;
	ArrayList<XYDataList> valoresgensexo;
	private FlotChartRendererData chartDataGenCarProc;
	ArrayList<XYDataList> valorescarproc;
	private FlotChartRendererData chartDataGenSegs;
	ArrayList<XYDataList> valoressegs;
	private FlotChartRendererData chartDataGenProcComp;
	ArrayList<XYDataList> valoresgenproccomp;
	private FlotChartRendererData chartDataGenTipoComp;
	ArrayList<XYDataList> valoresgentipocomp;
	private FlotChartRendererData chartDataEefReal;
	ArrayList<XYDataList> valoreseefreal;
	private FlotChartRendererData chartDataEefDiag;
	ArrayList<XYDataList> valoreseefdiag;
	private FlotChartRendererData chartDataEefAblNo;
	ArrayList<XYDataList> valoreseefablno;
	private FlotChartRendererData chartDataEefSust;
	ArrayList<XYDataList> valoreseefsust;
	private FlotChartRendererData chartDataEefCompDiag;
	ArrayList<XYDataList> valoreseefcompdiag;
	private FlotChartRendererData chartDataEefCompAbl;
	ArrayList<XYDataList> valoreseefcompabl;
	private FlotChartRendererData chartDataEefCompTipoDiag;
	ArrayList<XYDataList> valoreseefcomptipodiag;
	private FlotChartRendererData chartDataEefCompTipoAbl;
	ArrayList<XYDataList> valoreseefcomptipoabl;
	private FlotChartRendererData chartDataCvInd;
	ArrayList<XYDataList> valorescvind;
	private FlotChartRendererData chartDataCvExito;
	ArrayList<XYDataList> valorescvexito;
	private FlotChartRendererData chartDatacvAbl;
	ArrayList<XYDataList> valorescvabl;
	private FlotChartRendererData chartDatacvTipo;
	ArrayList<XYDataList> valorescvtipo;
	private FlotChartRendererData chartDatacvComp;
	ArrayList<XYDataList> valorescvcomp;
	private FlotChartRendererData chartDatacvCompTipo;
	ArrayList<XYDataList> valorescvcomptipo;
	private FlotChartRendererData chartDataEefRes;
	ArrayList<XYDataList> valoreseefres;
	private FlotChartRendererData chartDataRegInd;
	ArrayList<XYDataList> valoresregind;
	private FlotChartRendererData chartDataRegDiag;
	ArrayList<XYDataList> valoresregdiag;
	private FlotChartRendererData chartDataRegFab;
	ArrayList<XYDataList> valoresregfab;
	private FlotChartRendererData chartDataRegComp;
	ArrayList<XYDataList> valoresregcomp;
	private FlotChartRendererData chartDataRegCompTipo;
	ArrayList<XYDataList> valoresregcomptipo;
	private FlotChartRendererData chartDataHolDiagFin;
	ArrayList<XYDataList> valoresholdiagfin;
	private FlotChartRendererData chartDataRegEvExtDiagFin;
	ArrayList<XYDataList> valoresregevextdiagfin;
	private FlotChartRendererData chartDataAtpRes;
	ArrayList<XYDataList> valoresatpres;
	private FlotChartRendererData chartDataEpiRes;
	ArrayList<XYDataList> valoresepires;
	private FlotChartRendererData chartDataFleRes;
	ArrayList<XYDataList> valoresfleres;
	private FlotChartRendererData chartDataMesaRes;
	ArrayList<XYDataList> valoresmesares;
	private FlotChartRendererData chartDataImpDisp;
	ArrayList<XYDataList> valoresimpdisp;
	private FlotChartRendererData chartDataImpReintDisp;
	ArrayList<XYDataList> valoresimpreintdisp;
	private FlotChartRendererData chartDataImpProc;
	ArrayList<XYDataList> valoresimpproc;
	private FlotChartRendererData chartDataImpReintProc;
	ArrayList<XYDataList> valoresimpreintproc;
	private FlotChartRendererData chartDataImpBeFabTipo;
	ArrayList<XYDataList> valoresimpbefabtipo;
	private FlotChartRendererData chartDataImpBeTipoFab;
	ArrayList<XYDataList> valoresimpbetipofab;
	private FlotChartRendererData chartDataImpAeFabTipo;
	ArrayList<XYDataList> valoresimpaefabtipo;
	private FlotChartRendererData chartImpAeTipoFab;
	ArrayList<XYDataList> valoresimpaetipofab;
	private FlotChartRendererData chartDataImpRitmo;
	ArrayList<XYDataList> valoresimpritmo;
	private FlotChartRendererData chartDataImpCav;
	ArrayList<XYDataList> valoresimpcav;
	private FlotChartRendererData chartDataImpQrs;
	ArrayList<XYDataList> valoresimpqrs;
	private FlotChartRendererData chartDataImpSegDisp;
	ArrayList<XYDataList> valoressegdisp;
	private FlotChartRendererData chartDataImpComp;
	ArrayList<XYDataList> valoresimpcomp;
	private FlotChartRendererData chartDataImpCompTipo;
	ArrayList<XYDataList> valoresimpcomptipo;
	/****************************************/
	/********** ablacion anual **************/
	private Integer ID_VIAS_COND_ANTEROGRADA;
	private Integer ID_VIAS_COND_RETROGRADA;
	private Integer ID_VIAS_COND_RETROGRADA_TO;
	private Integer ID_VIAS_COND_BIDIRECCIONAL;
	private Integer ID_NAV_NO;
	private Integer ID_TAQUIARR_AU;
	/****************************************/
	
	public void iniciaEstadisticas(ActionEvent e){
		try{
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = this.lf.getSesionUsuario().getUsuario();
			this.cm = new ControlMaestras();
			iniciaMaestras();
			this.procdao = new ProcedimientoDaoImpl("consulta");
			this.sitclindao = new SituacionClinicaGeneralDaoImpl("consulta");
			this.pacdao = new ArrPacientesDaoImpl("consulta");
			this.mesadao = new ArrMesasDaoImpl("consulta");
			this.regdao = new ArrRegistradorDaoImpl("consulta");
			this.cvdao = new ArrCardioversionDaoImpl("consulta");
			this.testatpdao = new ArrTestAtpDaoImpl("consulta");
			this.testfledao = new ArrTestFleDaoImpl("consulta");
			this.testepidao = new ArrTestEpiDaoImpl("consulta");
			this.eefdao = new ArrEstudioDaoImpl("consulta");
			this.impdao = new ImpImplanteDaoImpl("consulta");
			this.holdao = new HolterDaoImpl("consulta");
			this.regevextdao = new RegistradorEventosExtDaoImpl("consulta");
			this.maestrasdao = new ArrMaestrasDaoImpl("consulta");
			this.compacdao = new ComplicacionesPacientesDaoImpl("consulta");
			this.compdao = new ComplicacionesDaoImpl("consulta");
			this.p_est = new Properties();
			this.c_est = new Properties();
			this.selectedParams = new ArrayList<String>();
			this.selectedParamsKeys = new ArrayList<String>();
			this.selectedCriteria = new ArrayList<CriterioSeleccion>();
			lecturaProperties();
			this.setEst_gen(false);
			this.genprocs = new ArrayList<EstadisticasBasicas>();
			this.gensegs = new ArrayList<EstadisticasBasicas>();
			this.gensegsrem = new ArrayList<EstadisticasBasicas>();
			this.genpatsexo = new ArrayList<EstadisticasBasicas>();
			this.genpatcar = new ArrayList<EstadisticasBasicas>();
			this.genprocscomp = new ArrayList<EstadisticasBasicas>();
			this.gentipocomp = new ArrayList<EstadisticasBasicas>();
			this.setResgen1("");
			this.setResgen2("");
			this.setResgen3("");
			this.setResgen4("");
			this.setResgen5("");
			//this.setResgen6("");
			this.setResgen7("");//this.setResgen8("");
			this.setEst_mesa(false);
			this.mesares = new ArrayList<EstadisticasBasicas>();
			//this.mesantg = new ArrayList<EstadisticasBasicas>();
			this.setResmesa1("");
			//this.setResmesa2("");
			this.setEst_reg(false);
			this.regind = new ArrayList<EstadisticasBasicas>();
			this.regmot = new ArrayList<EstadisticasBasicas>();
			this.regfab = new ArrayList<EstadisticasBasicas>();
			this.regcomp = new ArrayList<EstadisticasBasicas>();
			this.regcomptipo = new ArrayList<EstadisticasBasicas>();
			this.setResreg1("");
			//this.setResreg2("");
			this.setEst_test(false);
			this.testatp1 = new ArrayList<EstadisticasBasicas>();
			//this.testatp2 = new ArrayList<EstadisticasBasicas>();
			this.testepi = new ArrayList<EstadisticasBasicas>();
			this.testfle = new ArrayList<EstadisticasBasicas>();
			this.setRestest1("");this.setRestest2("");this.setRestest3("");
			//this.setRestest4("");
			this.setEst_cv(false);
			this.cvind = new ArrayList<EstadisticasBasicas>();
			this.cvres = new ArrayList<EstadisticasBasicas>();
			this.cvabl = new ArrayList<EstadisticasBasicas>();
			this.cvtipo = new ArrayList<EstadisticasBasicas>();
			this.cvcomp = new ArrayList<EstadisticasBasicas>();
			this.cvcomptipo = new ArrayList<EstadisticasBasicas>();
			this.setRescv1("");
			this.setEst_eef(false);
			this.eefcar = new ArrayList<EstadisticasBasicas>();
			this.eefdiag = new ArrayList<EstadisticasBasicas>();
			//this.eefproc = new ArrayList<EstadisticasBasicas>();
			this.eefint = new ArrayList<EstadisticasBasicas>();
			this.eefablsust = new ArrayList<EstadisticasBasicas>();
			this.eefablres = new ArrayList<EstadisticasBasicas>();
			this.eefcompabl = new ArrayList<EstadisticasBasicas>();
			this.eefcompabltipo = new ArrayList<EstadisticasBasicas>();
			this.eefcompdiag = new ArrayList<EstadisticasBasicas>();
			this.eefcompdiagtipo = new ArrayList<EstadisticasBasicas>();
			this.setReseef1("");
			//this.setReseef2("");this.setReseef3("");
			//this.setReseef4("");
			//this.setReseef5("");
			//this.setReseef6("");
			//this.setReseef7("");
			this.setEst_imp(false);
			this.impproc = new ArrayList<EstadisticasBasicas>();
			this.impreintproc = new ArrayList<EstadisticasBasicas>();
			this.impaefab = new ArrayList<EstadisticasBasicas>();
			this.impaetipo = new ArrayList<EstadisticasBasicas>();
			this.impbefab = new ArrayList<EstadisticasBasicas>();
			this.impbetipo = new ArrayList<EstadisticasBasicas>();			
			this.impritmo = new ArrayList<EstadisticasBasicas>();
			this.impcav = new ArrayList<EstadisticasBasicas>();
			this.impqrs = new ArrayList<EstadisticasBasicas>();
			this.impcomp = new ArrayList<EstadisticasBasicas>();
			this.impcomptipo = new ArrayList<EstadisticasBasicas>();
			this.setResimp1("");this.setResimp2("");this.setResimp3("");
			this.setResimp4("");this.setResimp5("");this.setResimp6("");
			this.setResimp7("");
			this.setEst_holter(false);
			this.holdiagfin = new ArrayList<EstadisticasBasicas>();
			this.setReshol1("");
			this.regevextdiagfin = new ArrayList<EstadisticasBasicas>();
			this.setResregevext1("");
			//createPieModel();
		}catch(Exception ex){
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_inicio_mod")+": "+ex.getMessage());
			logger.error("Error al iniciar control de estadisticas. Motivo: "+ex.fillInStackTrace());
		}
	}
	public void iniciaMaestras(){
		try {
			this.cardiopatia = cm.getCardiopatia();
			this.modo = cm.getModoGenerador();
			this.fabricante = cm.getFabricanteGenerador();
		} catch (ArrMaestrasDaoException e) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+e.getMessage());
			logger.error("Error al iniciar control de estadisticas - control maestras. Motivo: "+e.fillInStackTrace());
		}
	}
	
	
	public void recargaLineasTotales(ActionEvent e){
		try {
			for (DatoEstAnual item: lstEstAnuales)
				item.iniTotal();
			
		}catch(Exception ex){
			this.pintaMensaje(3, "Error cargando resumen de datos, motivo: "+ex.getMessage());
		}
		
	}
	
	public void iniMesMarcado(ActionEvent e){
		try {
			if (this.mesMarcado != null){
				switch(this.mesMarcado){
				case 0:this.descriMesMarcado = "Enero";break;
				case 1:this.descriMesMarcado = "Febrero";break;
				case 2:this.descriMesMarcado = "Marzo";break;
				case 3:this.descriMesMarcado = "Abril";break;
				case 4:this.descriMesMarcado = "Mayo";break;
				case 5:this.descriMesMarcado = "Junio";break;
				case 6:this.descriMesMarcado = "Julio";break;
				case 7:this.descriMesMarcado = "Agosto";break;
				case 8:this.descriMesMarcado = "Septiembre";break;
				case 9:this.descriMesMarcado = "Octubre";break;
				case 10:this.descriMesMarcado = "Noviembre";break;
				case 11:this.descriMesMarcado = "Diciembre";break;
				
				}
			}
		}catch(Exception ex){
			this.pintaMensaje(3, "Error seleccionando mes, motivo: "+ex.getMessage());
		}
	}
	
	public void limpiaAnual(ActionEvent e){
		this.mesMarcado = null;
		this.descriMesMarcado = null;
		try {
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
			this.cm = (ControlMaestras) getBean("controlMaestras");
		} catch (IUException e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
		
		if (cm == null)
			cm = new ControlMaestras();
		
		try {	
			obtenDatosAnuales();
		} catch (Exception e1) {
			this.pintaMensaje(3, "No se pueden obtener los datos anuales: " + e1.getMessage());
		}
		this.anual = new ArrAnual();
		this.recargaAnual(null);
	}
	
	
	
	
	public void generaExcelEstadisticas(ActionEvent e){
	
		try {
			ArrayList<DatoEstAnual> lstEst = new ArrayList<DatoEstAnual>();
			lstEst.add(new DatoEstAnual("EEF-Dcos",consdao.getEstadisticaN1(this.getDatosmes().getAnio(),502)));
			lstEst.add(new DatoEstAnual("EEF-Dco+Abl",consdao.getEstadisticaN1(this.getDatosmes().getAnio(),504)));
			lstEst.add(new DatoEstAnual("EEF DCOS TOTAL",consdao.getEstadisticaN1Sumas(lstEst.get(0).getValor(),lstEst.get(1).getValor())));
			lstEst.add(new DatoEstAnual("EEF-Ablacion",consdao.getEstadisticaN1(this.getDatosmes().getAnio(),503)));
			lstEst.add(new DatoEstAnual("Ablaciones",consdao.getEstadisticaN1Sumas(lstEst.get(1).getValor(),lstEst.get(3).getValor())));
			lstEst.add(new DatoEstAnual("EEF Total",consdao.getEstadisticaN1Sumas(lstEst.get(0).getValor(),lstEst.get(1).getValor(),lstEst.get(4).getValor())));
			lstEst.add(new DatoEstAnual("Días trabajados",consdao.getEstadisticaN3(this.getDatosmes().getAnio())));
			lstEst.add(new DatoEstAnual("Nº días/2 pacientes",consdao.getEstadisticaN15(this.getDatosmes().getAnio(),2)));
			lstEst.add(new DatoEstAnual("Nº Días 2 ABL",consdao.getEstadisticaN16(this.getDatosmes().getAnio(),3)));
			lstEst.add(new DatoEstAnual("Dias Ablacion",consdao.getEstadisticaN4(this.getDatosmes().getAnio())));
			lstEst.add(new DatoEstAnual("nº Procedimientos",consdao.getEstadisticaN1Sumas(lstEst.get(0).getValor(),lstEst.get(1).getValor(),lstEst.get(4).getValor())));
			lstEst.add(new DatoEstAnual("NAVX",consdao.getEstadisticaN5(this.getDatosmes().getAnio(),2)));
			lstEst.add(new DatoEstAnual("CARTO",consdao.getEstadisticaN5(this.getDatosmes().getAnio(),1)));
			lstEst.add(new DatoEstAnual("Navegadores",consdao.getEstadisticaN1Sumas(lstEst.get(11).getValor(),lstEst.get(12).getValor())));
			lstEst.add(new DatoEstAnual("% Navegadores",consdao.getEstadisticaPorcentajes(lstEst.get(10).getValor(),lstEst.get(13).getValor())));
			lstEst.add(new DatoEstAnual("Transeptal",consdao.getEstadisticaN6(this.getDatosmes().getAnio(),6)));
			lstEst.add(new DatoEstAnual("Epicardico",consdao.getEstadisticaN6(this.getDatosmes().getAnio(),7)));
			lstEst.add(new DatoEstAnual("Crioablación",consdao.getEstadisticaN7(this.getDatosmes().getAnio(),2)));
			lstEst.add(new DatoEstAnual("Pediátricos < 16",consdao.getEstadisticaN8(this.getDatosmes().getAnio(),16)));
			lstEst.add(new DatoEstAnual("Pediátricos < 14",consdao.getEstadisticaN8(this.getDatosmes().getAnio(),14)));
			lstEst.add(new DatoEstAnual("EIC",consdao.getEstadisticaN9(this.getDatosmes().getAnio(),1)));
			lstEst.add(new DatoEstAnual("Holter Insertable",this.getLstEstAnuales().get(1).getValor()));
			lstEst.add(new DatoEstAnual("CVE",consdao.getEstadisticaN10(this.getDatosmes().getAnio())));
			lstEst.add(new DatoEstAnual("Mesas Basculante",this.getLstEstAnuales().get(0).getValor()));
			lstEst.add(new DatoEstAnual("ATP",consdao.getEstadisticaN11(this.getDatosmes().getAnio())));
			lstEst.add(new DatoEstAnual("Proca/Fleca",consdao.getEstadisticaN12(this.getDatosmes().getAnio())));
			lstEst.add(new DatoEstAnual("Adrenalina",consdao.getEstadisticaN13(this.getDatosmes().getAnio())));
			lstEst.add(new DatoEstAnual("Test FAA total",consdao.getEstadisticaN1Sumas(lstEst.get(24).getValor(),lstEst.get(25).getValor(),lstEst.get(26).getValor())));
			lstEst.add(new DatoEstAnual("Recambio",consdao.getEstadisticaN14(this.getDatosmes().getAnio(),2)));
			lstEst.add(new DatoEstAnual("PrimoImplante",consdao.getEstadisticaN14(this.getDatosmes().getAnio(),1)));
			lstEst.add(new DatoEstAnual("crtp Total",consdao.getEstadisticaN1Sumas(lstEst.get(28).getValor(),lstEst.get(29).getValor())));
			lstEst.add(new DatoEstAnual("%Ablación",consdao.getEstadisticaPorcentajes(lstEst.get(6).getValor(),lstEst.get(9).getValor())));
			lstEst.add(new DatoEstAnual("Días 3 pacientes",consdao.getEstadisticaN16(this.getDatosmes().getAnio(),3)));
			
			
			
			
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(lstEst);
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
				this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}
	}
	public void cambiaAnoMes(ActionEvent e){
		try {
			obtenDatosAnuales();
			this.mesMarcado =null;
			this.descriMesMarcado ="";
			
		}catch(Exception ex){
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_estadisticas")+": " +ex.getMessage());
		}
		
	}
	
	private void obtenDatosAnuales() throws Exception{
		if (this.datosmes.getAnio() == null || this.datosmes.getAnio() == 0)
			throw new Exception("Debe indicar un mes valido");
		
		lstEstAnuales = new ArrayList<DatoEstAnual>();
		lstEstAnuales.add(new DatoEstAnual("Mesas basculantes"));
		lstEstAnuales.add(new DatoEstAnual("Holter insertable"));
		
		ArrDatosMes[] lst =  this.datosmesdao.findByDynamicWhere("anio = "+this.datosmes.getAnio()+" order by anio,mes",null);
		if (lst != null && lst.length>0){
			for (int i=0;i<lst.length;i++){
				lstEstAnuales.get(0).valor[i] = UtilCodifi.parserInteger(lst[i].getMesasmes());
				lstEstAnuales.get(1).valor[i] = UtilCodifi.parserInteger(lst[i].getRiemes());
			}
			lstEstAnuales.get(0).iniTotal();
			lstEstAnuales.get(1).iniTotal();
		}
	}
	
	private void persisteDatosMes(ArrDatosMes registro) throws Exception{
		//Lo busco. Si no existe lo inserto, si no lo updateo
		ArrDatosMes item = this.datosmesdao.findByPrimaryKey(new ArrDatosMesPk(registro.getMes(),registro.getAnio()));
		if (item == null){
			this.datosmesdao.insert(registro);
		}
		else {
			this.datosmesdao.update(new ArrDatosMesPk(registro.getMes(),registro.getAnio()), registro);
		}
		
	}
	
	private void guardaDatosAnuales() throws Exception{
		ArrDatosMes objeto = null;
		if (this.datosmes.getAnio() == null || this.datosmes.getAnio() == 0)
			throw new Exception("Debe indicar un mes valido");

		for (int i=0;i<12;i++){
			persisteDatosMes(new ArrDatosMes(this.datosmes.getAnio(),i,lstEstAnuales.get(0).valor[i],lstEstAnuales.get(1).valor[i]));
		}
	}
	
	
	public void guardaDatosAnuales(ActionEvent e){
		try {
			guardaDatosAnuales();
			this.pintaMensaje(1, "Datos guardados correctamente");
		}catch(Exception ex){
			this.pintaMensaje(3, "Error guardando datos, motivo: "+ex.getMessage());
		}
	}
	
	public void limpiaMensual(ActionEvent e){
		try {
			LoginForm loginform;
			loginform = (LoginForm) getBean("loginForm");
			this.usuario = loginform.getSesionUsuario().getUsuario();
			
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
			this.cm = (ControlMaestras) getBean("controlMaestras");
			
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
		} catch (IUException e1) {
			this.pintaMensaje(3, "No se pueden obtener los datos maestros: " + e1.getMessage());
		}
		if (cm == null)
			cm = new ControlMaestras();
		this.datosmes = new ArrDatosMes();
		meses = new ArrayList<SelectItem>();
		meses.add(new SelectItem("0", "(Seleccione mes)"));
		meses.add(new SelectItem("1","Enero"));
		meses.add(new SelectItem("2","Febrero"));
		meses.add(new SelectItem("3","Marzo"));
		meses.add(new SelectItem("4","Abril"));
		meses.add(new SelectItem("5","Mayo"));
		meses.add(new SelectItem("6","Junio"));
		meses.add(new SelectItem("7","Julio"));
		meses.add(new SelectItem("8","Agosto"));
		meses.add(new SelectItem("9","Septiembre"));
		meses.add(new SelectItem("10","Octubre"));
		meses.add(new SelectItem("11","Noviembre"));
		meses.add(new SelectItem("12","Diciembre"));
		this.anual = new ArrAnual();
		this.recargaAnual(null);
	}
	
	private void cargaValoresMaestros(){
		try{
			this.maestrasdao = new ArrMaestrasDaoImpl("consulta");
			ArrMaestras[] vias_sentido = this.maestrasdao.findWhereTipoEquals(30);
			for(ArrMaestras m:vias_sentido){
				if(m.getValor().toUpperCase().contains("ANTER"))
					ID_VIAS_COND_ANTEROGRADA = m.getCodigo();
				else if(m.getValor().toUpperCase().contains("BIDIRECCIO"))
					ID_VIAS_COND_BIDIRECCIONAL = m.getCodigo();
				else if(m.getValor().toUpperCase().contains("OCULT"))
					ID_VIAS_COND_RETROGRADA = m.getCodigo();
				else if(m.getValor().toUpperCase().contains("TO"))
					ID_VIAS_COND_RETROGRADA_TO = m.getCodigo();
			}
			ArrMaestras[] navs = this.maestrasdao.findWhereTipoEquals(10);
			for(ArrMaestras m:navs)
				if(m.getValor().toUpperCase().equals("NO"))
					ID_NAV_NO = m.getCodigo();
			ArrMaestras[] diag = this.maestrasdao.findWhereTipoEquals(4);
			for(ArrMaestras m:diag)
				if(m.getValor().toUpperCase().equals("TAQUIARRITMIA AURICULAR"))
					ID_TAQUIARR_AU = m.getCodigo();
		}catch(Exception e){
			this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+e.getMessage());
			logger.error("No se pueden cargar valores maestros para consulta. Motivo: "+e.getMessage(), e);
		}
	}
	
	public void guardaResumenMes(ActionEvent e){
		try {
			if(!this.datosmes.getMes().equals("0")){
				datosmesdao.delete(this.datosmes.createPk());
				datosmesdao.insert(this.datosmes);
				this.pintaMensaje(1, "Datos estadísticos almacenados");
			}else{
				this.pintaMensaje(2, "Por favor, introduzca un mes");
			}
		} catch (ArrDatosMesDaoException e1) {
			this.pintaMensaje(3, "Ha ocurrido un error en base de datos. " + e1.getMessage());
		}
	}
	
	public void recargaDatosMes(ActionEvent e){
		if(!this.datosmes.getMes().equals("0"))
			try {
				ArrDatosMes tmp = this.datosmes;
				tmp = this.datosmesdao.findByPrimaryKey(this.datosmes.createPk());
				if(tmp != null)
					this.datosmes = tmp;
			} catch (ArrDatosMesDaoException e1) {
				this.pintaMensaje(3, "Ha ocurrido un error en base de datos. " + e1.getMessage());
			}
	}
	
	public void imprimeResumenMes(ActionEvent e){
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext
				.getCurrentInstance());

		try {
			String nombremes = "";
			for(SelectItem m : meses)
				if(this.datosmes.getMes().equals(m.getValue()))
					nombremes = m.getLabel();
			PathFicheroXml = generadorXML.imprimeResumenMes(this.datosmes, nombremes);
		} catch (Exception se) {
			try {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error generando documento,Motivo: " + se.getMessage());
			} catch (Exception e3) {
			}
		}
		construyePDF("EEFmes.jasper", PathFicheroXml);
	}
	//mmb
	public void imprimeResumenMesAnio(ActionEvent e){
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext
				.getCurrentInstance());

		try {
			if (this.mesMarcado == null) throw new Exception("Debe indicar un mes");
			
			this.datosmes = new ArrDatosMes(this.datosmes.getAnio(),new Integer(this.mesMarcado+1), this.getLstEstAnuales().get(0).valor[this.mesMarcado], this.getLstEstAnuales().get(1).valor[this.mesMarcado]);
			this.datosmes.setMesastot(this.getLstEstAnuales().get(0).iniSubTotal(this.mesMarcado).toString());
			this.datosmes.setRietot(this.getLstEstAnuales().get(1).iniSubTotal(this.mesMarcado).toString());
			
			PathFicheroXml = generadorXML.imprimeResumenMes(this.datosmes, this.descriMesMarcado);
		} catch (Exception se) {
			try {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error generando documento,Motivo: " + se.getMessage());
			} catch (Exception e3) {
			}
		}
		construyePDF("EEFmes.jasper", PathFicheroXml);
	}
	
	public void enviaInformeMesAnio(ActionEvent e){
		this.guardaResumenMes(e);
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext
				.getCurrentInstance());

		try {
			if (this.mesMarcado == null) throw new Exception("Debe indicar un mes");
			
			this.datosmes = new ArrDatosMes(this.datosmes.getAnio(),new Integer(this.mesMarcado+1), this.getLstEstAnuales().get(0).valor[this.mesMarcado], this.getLstEstAnuales().get(1).valor[this.mesMarcado]);
			this.datosmes.setMesastot(this.getLstEstAnuales().get(0).iniSubTotal(this.mesMarcado).toString());
			this.datosmes.setRietot(this.getLstEstAnuales().get(1).iniSubTotal(this.mesMarcado).toString());
			
			PathFicheroXml = generadorXML.imprimeResumenMes(this.datosmes, this.descriMesMarcado);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error generando documento,Motivo: " + se.getMessage());
		}
		String path = construyePDFFile("EEFmes.jasper", PathFicheroXml);
		this.sendMail(path, this.INFORME_MENSUAL);
	}
	
	
	
	
	public void guardaAnual(ActionEvent e){
		try {
			centrodao.delete(this.anual.getCentro().createPk());
			labdao.delete(this.anual.getLab().createPk());
			tecdao.delete(this.anual.getTec().createPk());
			centrodao.insert(this.anual.getCentro());
			labdao.insert(this.anual.getLab());
			tecdao.insert(this.anual.getTec());
			
			ArrAnualSubstratos comentarios = new ArrAnualSubstratos();
			comentarios.setAnio(this.anual.getAnio());
			comentarios.setCampo1(this.anual.getCav().getCampo34());
			comentarios.setCampo2(this.anual.getFa().getCampo34());
			comentarios.setCampo3(this.anual.getFta().getCampo34());
			comentarios.setCampo4(this.anual.getIct().getCampo34());
			comentarios.setCampo5(this.anual.getTaf().getCampo34());
			comentarios.setCampo6(this.anual.getTin().getCampo34());
			comentarios.setCampo7(this.anual.getTvi().getCampo34());
			comentarios.setCampo8(this.anual.getTviam().getCampo34());
			comentarios.setCampo9(this.anual.getTvnoiam().getCampo34());
			comentarios.setCampo10(this.anual.getVacc().getCampo34());
			susdao.delete(comentarios.createPk());
			susdao.insert(comentarios);
			
			this.pintaMensaje(1, this.bundle.getString("abl_anual_msg_info_guarda"));
		} catch (ArrAnualCentroDaoException e1) {
			this.pintaMensaje(3, this.bundle.getString("abl_anual_msg_error_guarda")+": " + e1.getMessage());
		} catch (ArrAnualLabDaoException e1) {
			this.pintaMensaje(3, this.bundle.getString("abl_anual_msg_error_guarda")+": " + e1.getMessage());
		} catch (ArrAnualTecnicasDaoException e1) {
			this.pintaMensaje(3, this.bundle.getString("abl_anual_msg_error_guarda")+": " + e1.getMessage());
		} catch (ArrAnualSubstratosDaoException e1) {
			this.pintaMensaje(3, this.bundle.getString("abl_anual_msg_error_guarda")+": " + e1.getMessage());
		}
	}
	
	public void recargaAnual(ActionEvent e){
		try {
			Integer anio = this.anual.getAnio();
			this.anual = new ArrAnual(anio);
			this.anual.setCentro(centrodao.findByPrimaryKey(anio));
			if(this.anual.getCentro().getAnio() == null){
				this.anual.setCentro(centrodao.findByMaxAnio());
				this.anual.getCentro().setAnio(anio);
				this.anual.setLab(labdao.findByMaxAnio());
				this.anual.getLab().setAnio(anio);
				this.anual.setTec(tecdao.findByMaxAnio());
				this.anual.getTec().setAnio(anio);
			}else{
				this.anual.setLab(labdao.findByPrimaryKey(anio));
				this.anual.setTec(tecdao.findByPrimaryKey(anio));
			}
			// BUSQUEDA DATOS MAESTROS
			cargaValoresMaestros();
			this.anual.setFa(cargaConsultas(anio, ArrAnual.FIBRILACION_AURICULAR));
			this.anual.setCav(cargaConsultas(anio, ArrAnual.NODO_AV));
			this.anual.setFta(cargaConsultas(anio, ArrAnual.FLUTER_AURICULAR));
			this.anual.setTaf(cargaConsultas(anio, ArrAnual.TA_FOCAL));
			this.anual.setTin(cargaConsultas(anio, ArrAnual.TIN));
			this.anual.setTvi(cargaConsultas(anio, ArrAnual.TV_FOCAL));
			this.anual.setTviam(cargaConsultas(anio, ArrAnual.TV_IAM));
			this.anual.setTvnoiam(cargaConsultas(anio, ArrAnual.TV_NOIAM));
			this.anual.setVacc(cargaConsultas(anio, ArrAnual.VIA_ACCESORIA));
			this.anual.setIct(cargaConsultas(anio, ArrAnual.FLUTER_AURICULAR_ICT));
			
			ArrAnualSubstratos comentarios = new ArrAnualSubstratos();
			comentarios = susdao.findByPrimaryKey(this.anual.getAnio());
			
			this.anual.getCav().setCampo34(comentarios.getCampo1());
			this.anual.getFa().setCampo34(comentarios.getCampo2());
			this.anual.getFta().setCampo34(comentarios.getCampo3());
			this.anual.getIct().setCampo34(comentarios.getCampo4());
			this.anual.getTaf().setCampo34(comentarios.getCampo5());
			this.anual.getTin().setCampo34(comentarios.getCampo6());
			this.anual.getTvi().setCampo34(comentarios.getCampo7());
			this.anual.getTviam().setCampo34(comentarios.getCampo8());
			this.anual.getTvnoiam().setCampo34(comentarios.getCampo9());
			this.anual.getVacc().setCampo34(comentarios.getCampo10());
			
		} catch (ArrAnualCentroDaoException e1) {
			this.pintaMensaje(3, this.bundle.getString("abl_anual_msg_error_guarda")+": " + e1.getMessage());
		} catch (ArrAnualLabDaoException e1) {
			this.pintaMensaje(3, this.bundle.getString("abl_anual_msg_error_guarda")+": " + e1.getMessage());
		} catch (ArrAnualTecnicasDaoException e1) {
			this.pintaMensaje(3, this.bundle.getString("abl_anual_msg_error_guarda")+": " + e1.getMessage());
		} catch (DAOException e1) {
			this.pintaMensaje(3, this.bundle.getString("abl_anual_msg_error_guarda")+": " + e1.getMessage());
		} catch (ArrAnualSubstratosDaoException e1) {
			this.pintaMensaje(3, this.bundle.getString("abl_anual_msg_error_guarda")+": " + e1.getMessage());
		}
	}
	
	private ArrAnualSubstratos cargaConsultas(Integer anio, Integer ablacion) throws DAOException{
		ArrAnualSubstratos sbs = new ArrAnualSubstratos(anio, ablacion);
		//pacientes
		sbs.setCampo1(this.consdao.getPacientesAblacion(anio, ablacion));
		//procedimientos
		sbs.setCampo2(this.consdao.getProcedimientosAblacion(anio, ablacion));
		//exitos
		sbs.setCampo3(this.consdao.getProcedimientosAblacionExito(anio, ablacion));
		//cateter
		//sbs.setCampo4(this.consdao.getCateteresAblacion(anio, ablacion, "8MM"));
		//sbs.setCampo5(this.consdao.getCateteresAblacion(anio, ablacion, "IRRIGA"));
		//sbs.setCampo6(this.consdao.getCateteresAblacion(anio, ablacion, "CRIO"));
		sbs.setCampo35(this.consdao.getCateteresAblacion(anio, ablacion, "1"));// 4MM
		sbs.setCampo4(this.consdao.getCateteresAblacion(anio, ablacion, "2"));// 8MM
		sbs.setCampo5(this.consdao.getCateteresAblacion(anio, ablacion, "3"));// IRRIGADO ESTANDAR
		sbs.setCampo6(this.consdao.getCateteresAblacion(anio, ablacion, "4"));// CRIOABLACION
		sbs.setCampo36(this.consdao.getCateteresAblacion(anio, ablacion, "9"));// IRRIGADO DE CONTACTO
		sbs.setCampo7(this.consdao.getOtrosCateteresAblacion(anio, ablacion));
		//sbs.setCampo8(this.consdao.getCateteresAblacion(anio, ablacion, cateter));
		sbs.setCampo8(this.consdao.getOtrosCateteresAblacionNombres(anio, ablacion));
		//complicaciones
		sbs.setCampo9(this.consdao.getComplicacionesAblacion(anio, ablacion, 1));
		sbs.setCampo10(this.consdao.getComplicacionesAblacion(anio, ablacion, 2));
		sbs.setCampo11(this.consdao.getComplicacionesAblacion(anio, ablacion, 3));
		sbs.setCampo12(this.consdao.getComplicacionesAblacion(anio, ablacion, 4));
		sbs.setCampo13(this.consdao.getComplicacionesAblacion(anio, ablacion, 5));
		sbs.setCampo14(this.consdao.getComplicacionesAblacion(anio, ablacion, 6));
		sbs.setCampo15(this.consdao.getComplicacionesAblacion(anio, ablacion, 7));
		sbs.setCampo16(this.consdao.getComplicacionesAblacion(anio, ablacion, 8));
		sbs.setCampo17(this.consdao.getComplicacionesAblacion(anio, ablacion, 9));
		sbs.setCampo18(this.consdao.getComplicacionesAblacion(anio, ablacion, 10));
		sbs.setCampo19(this.consdao.getOtrasComplicacionesAblacion(anio, ablacion));
		//muertes
		sbs.setCampo20(this.consdao.getMuertesAblacion(anio, ablacion));
		sbs.setCampo21(this.consdao.getMuertesConComplicacionAblacion(anio, ablacion));
		// Datos adicionales
		sbs.setCampo37(this.consdao.getCasosPediatricos(anio, ablacion));
		sbs.setCampo38(this.consdao.getCasosNavegador(anio, ablacion,ID_NAV_NO));
		sbs.setCampo39(this.consdao.getCasosSinFluoroscopia(anio, ablacion));
		switch (ablacion) {
		//Vias accesorias
		case 9:
			sbs.setCampo22(this.consdao.getVacAblacion(anio, ablacion,1));
			sbs.setCampo23(this.consdao.getVacAblacion(anio, ablacion,2));
			sbs.setCampo24(this.consdao.getVacAblacion(anio, ablacion,3));
			sbs.setCampo25(this.consdao.getVacAblacion(anio, ablacion,4));
			sbs.setCampo26(this.consdao.getVacAblacionExito(anio, ablacion,1));
			sbs.setCampo27(this.consdao.getVacAblacionExito(anio, ablacion,2));
			sbs.setCampo28(this.consdao.getVacAblacionExito(anio, ablacion,3));
			sbs.setCampo29(this.consdao.getVacAblacionExito(anio, ablacion,4));
			// Conducciones
			sbs.setCampo30(this.consdao.getVacTotal(anio, ablacion));
			sbs.setCampo31(this.consdao.getVacConducciones(anio, ablacion, ID_VIAS_COND_ANTEROGRADA)); // CONDUCCION ANTEROGRADA
			String oculta = this.consdao.getVacConducciones(anio, ablacion, ID_VIAS_COND_RETROGRADA);
			String solo_to = this.consdao.getVacConducciones(anio, ablacion, ID_VIAS_COND_RETROGRADA_TO);
			Integer res = 0;
			if(oculta!=null && solo_to!=null && UtilDatos.esNumero(oculta) && UtilDatos.esNumero(solo_to))
				res = Integer.valueOf(oculta) + Integer.valueOf(solo_to);			
			sbs.setCampo32(String.valueOf(res)); // CONDUCCION RETROGRADA =  OCULTAS + SOLO TO
			sbs.setCampo33(this.consdao.getVacConducciones(anio, ablacion, ID_VIAS_COND_BIDIRECCIONAL)); // CONDUCCION BIDIRECCIONAL
			// Acceso Vias izquierdas
			sbs.setCampo40(this.consdao.getVacAblacionAccesoIzquierdas(anio, ablacion,4));// RETROAORTICA -> ARTERIAL FEMORAL (HVN:M.ALV)
			sbs.setCampo41(this.consdao.getVacAblacionAccesoIzquierdas(anio, ablacion,6));// TRANSEPTAL
			sbs.setCampo42(this.consdao.getVacAblacionAccesoIzquierdas(anio, ablacion,7));// EPICARDICO/SENO CORONARIO
			break;
		//TAF
		case 4:
			sbs.setCampo22(this.consdao.getTafAblacion(anio, ablacion,1));
			sbs.setCampo23(this.consdao.getTafAblacion(anio, ablacion,3));
			sbs.setCampo24(this.consdao.getTafAblacionExito(anio, ablacion,1));
			sbs.setCampo25(this.consdao.getTafAblacionExito(anio, ablacion,3));
			break;
		//FTA
		case 2:
			sbs.setCampo22(this.consdao.getFtaAblacion(anio, ablacion,2));
			sbs.setCampo23(this.consdao.getFtaAblacion(anio, ablacion,4));
			sbs.setCampo24(this.consdao.getFtaAblacionExito(anio, ablacion,2));
			sbs.setCampo25(this.consdao.getFtaAblacionExito(anio, ablacion,4));
			sbs.setCampo26(this.consdao.getFtaAblacionTipo(anio, ablacion,1));
			sbs.setCampo27(this.consdao.getFtaAblacionTipo(anio, ablacion,2));
			sbs.setCampo28(this.consdao.getFtaAblacionTipo(anio, ablacion,3));
			sbs.setCampo29(this.consdao.getFtaAblacionTipo(anio, ablacion,4));
			break;
		//TVI /TV Focal
		case 8:
			sbs.setCampo22(this.consdao.getTviAblacion(anio, ablacion,1));
			sbs.setCampo23(this.consdao.getTviAblacion(anio, ablacion,2));
			sbs.setCampo24(this.consdao.getTviAblacion(anio, ablacion,3));
			sbs.setCampo25(this.consdao.getTviAblacion(anio, ablacion,4));
			sbs.setCampo30(this.consdao.getTviAblacion(anio, ablacion,7)); // arteria pulmonar
			sbs.setCampo31(this.consdao.getTviAblacion(anio, ablacion,8)); // raiz aortica
			sbs.setCampo32(this.consdao.getTviAblacion(anio, ablacion,9)); // epicardio / seno coronario
			sbs.setCampo26(this.consdao.getTviAblacionExito(anio, ablacion,1));
			sbs.setCampo27(this.consdao.getTviAblacionExito(anio, ablacion,2));
			sbs.setCampo28(this.consdao.getTviAblacionExito(anio, ablacion,3));
			sbs.setCampo29(this.consdao.getTviAblacionExito(anio, ablacion,4));
			sbs.setCampo33(this.consdao.getTviAblacionExito(anio, ablacion,7));
			sbs.setCampo40(this.consdao.getTviAblacionExito(anio, ablacion,8));
			sbs.setCampo41(this.consdao.getTviAblacionExito(anio, ablacion,9));
			break;
		//TVIAM
		case 6:
			sbs.setCampo22(this.consdao.getTVIAMAblacion(anio, ablacion,1));
			sbs.setCampo23(this.consdao.getTVIAMAblacionExito(anio, ablacion,1));
			sbs.setCampo24(this.consdao.getTVIAMAblacion(anio, ablacion,0));
			sbs.setCampo25(this.consdao.getTVIAMAblacionExito(anio, ablacion,0));
			// Acceso
			sbs.setCampo26(this.consdao.getTVIAMAcceso(anio, ablacion,4));// ENDOCARDICO RETROAORTICO
			sbs.setCampo27(this.consdao.getTVIAMAcceso(anio, ablacion,6));// ENDOCARDICO TRANSEPTAL
			sbs.setCampo28(this.consdao.getTVIAMAcceso(anio, ablacion,7));// EPICARDICO
			sbs.setCampo29(this.consdao.getTVIAMAcceso(anio, ablacion,8));// EPICARDICO + ENDOCARDICO
			break;
		//TVInoAM
		case 7:
			sbs.setCampo22(this.consdao.getTVNOIAMAblacion(anio, ablacion,1));
			sbs.setCampo23(this.consdao.getTVNOIAMAblacionExito(anio, ablacion,1));
			sbs.setCampo24(this.consdao.getTVNOIAMAblacion(anio, ablacion,2));
			sbs.setCampo25(this.consdao.getTVNOIAMAblacionExito(anio, ablacion,2));
			sbs.setCampo26(this.consdao.getTVNOIAMAblacion(anio, ablacion,3));
			sbs.setCampo27(this.consdao.getTVNOIAMAblacionExito(anio, ablacion,3));
			sbs.setCampo28(this.consdao.getTVNOIAMAblacion(anio, ablacion,5));
			sbs.setCampo29(this.consdao.getTVNOIAMAblacionExito(anio, ablacion,5));
			sbs.setCampo30(this.consdao.getTVNOIAMAblacion(anio, ablacion,4));
			sbs.setCampo31(this.consdao.getTVNOIAMAblacionExito(anio, ablacion,4));
			sbs.setCampo32(this.consdao.getTVNOIAMAblacion(anio, ablacion,9)); // M Hipertrofica
			sbs.setCampo33(this.consdao.getTVNOIAMAblacionExito(anio, ablacion,9)); // M Hipertrofica exito
			sbs.setCampo44(this.consdao.getTVNOIAMAblacion(anio, ablacion,10)); // C. Congenita
			sbs.setCampo45(this.consdao.getTVNOIAMAblacionExito(anio, ablacion,10)); // C. Congenita exito
			// Acceso
			sbs.setCampo40(this.consdao.getTVNOIAMAcceso(anio, ablacion,4));// ENDOCARDICO RETROAORTICO
			sbs.setCampo41(this.consdao.getTVNOIAMAcceso(anio, ablacion,6));// ENDOCARDICO TRANSEPTAL
			sbs.setCampo42(this.consdao.getTVNOIAMAcceso(anio, ablacion,7));// EPICARDICO
			sbs.setCampo43(this.consdao.getTVNOIAMAcceso(anio, ablacion,8));// EPICARDICO + ENDOCARDICO
			break;
		//FA
		case 1:
			sbs.setCampo22(this.consdao.getFaAblacion(anio, ablacion,2));
			sbs.setCampo23(this.consdao.getFaAblacion(anio, ablacion,1));
			/*sbs.setCampo26(this.consdao.getFaAblacionAbordajeExito(anio, ablacion,1));
			sbs.setCampo31(this.consdao.getFaAblacionAbordajeExito(anio, ablacion,2));
			sbs.setCampo32(this.consdao.getFaAblacionAbordajeExito(anio, ablacion,3));
			sbs.setCampo33(this.consdao.getFaAblacionAbordajeExito(anio, ablacion,4));*/
			sbs.setCampo26(this.consdao.getFaAblacion(anio, ablacion,1));
			sbs.setCampo31(this.consdao.getFaAblacion(anio, ablacion,2));
			sbs.setCampo32(this.consdao.getFaAblacion(anio, ablacion,3));
			sbs.setCampo33(this.consdao.getFaAblacion(anio, ablacion,4));
			sbs.setCampo24(this.consdao.getFaAblacionAbordajeExito(anio, ablacion,1));
			sbs.setCampo25(this.consdao.getFaAblacionAbordajeExito(anio, ablacion,2));
			sbs.setCampo27(this.consdao.getFaAblacionAbordajeExito(anio, ablacion,3));
			sbs.setCampo28(this.consdao.getFaAblacionAbordajeExito(anio, ablacion,4));
			//complicaciones
			sbs.setCampo29(this.consdao.getComplicacionesAblacion(anio, ablacion,11));
			sbs.setCampo30(this.consdao.getComplicacionesAblacion(anio, ablacion,12));
			// Datos adicionales
			sbs.setCampo41(this.consdao.getCasosConEcoIntra(anio, ablacion));
			// Sustratos - campo 42, 43, 44
			sbs.setCampo42(this.consdao.getFaAblacionSustrato(anio, ablacion, ID_TAQUIARR_AU, 1)); // FA PAROXISTICA
			sbs.setCampo43(this.consdao.getFaAblacionSustrato(anio, ablacion, ID_TAQUIARR_AU, 2)); // FA PERSISTENTE
			sbs.setCampo44(this.consdao.getFaAblacionSustrato(anio, ablacion, ID_TAQUIARR_AU, 3)); // FA PERSISTENTE LARGA DURACION
			// Cateteres especiales
			sbs.setCatLaser(this.consdao.getCateteresAblacion(anio, ablacion, "6")); // LASER
			sbs.setCatRFFasica(this.consdao.getCateteresAblacion(anio, ablacion, "10")); // CIRCULAR RF FASICA
			sbs.setCatRFIrrig(this.consdao.getCateteresAblacion(anio, ablacion, "11")); // CIRCULAR RF IRRIGADA
			break;
		default:
			break;
		}
		
		return sbs;
	}
	
	public void imprimeAnual(ActionEvent e){
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext
				.getCurrentInstance());

		try {
			PathFicheroXml = generadorXML.imprimeAblacionAnual(this.anual, this.bundle);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_impr_gen_doc")+": " + se.getMessage());
		}
		construyePDF("AblacionAnual.jasper", PathFicheroXml);
		//construyeRTF("AblacionAnual.jasper", PathFicheroXml);		
		logger.info("("+this.usuario+") Generación de informe (FORMULARIO ABLACION ANUAL)");
	}
	
	private void construyePDF(String jasper, String path){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), path, jasper);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + se.getMessage());
		}
	}
	private String construyePDFFile(String jasper, String path){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		try {
			return constructorPDF.generarArchivoPdfFile(FacesContext.getCurrentInstance(), path, jasper);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + se.getMessage());
			return "";
		}
	}
	private void construyeRTF(String jasper, String path) {
	    ConstructorRtf constructorRtf = new ConstructorRtf();
	    try{
	      constructorRtf.generarArchivoRtf(FacesContext.getCurrentInstance(), path, jasper, "", "Formulario Ablacion Anual");
	    } catch (Exception se) {
	      logger.error("(" + this.usuario + ") Error imprimiendo documento, motivo: " + se.getMessage());
	      try {
	        nuevoMensaje(this.formulario.getId(), 3, 
	          "Error imprimiendo documento,motivo: " + 
	          se.getMessage(), 
	          "Error imprimiendo documento,Motivo: " + 
	          se.getMessage());
	      }
	      catch (Exception localException1) {
	      }
	    }
	}
	
	public void imprimeAnualExcel(ActionEvent e){	
		construyeExcel();		
		logger.info("("+this.usuario+") Generación de informe (FORMULARIO ABLACION ANUAL)");
	}
	private void construyeExcel(){
		ConstructorExcel constructorExcel = new ConstructorExcel();
		try {
			constructorExcel.generarArchivoExcel(FacesContext.getCurrentInstance(), this.anual);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_impr_pdf_doc")+": " + se.getMessage());
		}
	}
	public void enviaInforme(ActionEvent e){
		this.guardaResumenMes(e);
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext
				.getCurrentInstance());

		try {
			String nombremes = "";
			for(SelectItem m : meses)
				if(this.datosmes.getMes().equals(m.getValue()))
					nombremes = m.getLabel();
			PathFicheroXml = generadorXML.imprimeResumenMes(this.datosmes, nombremes);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error generando documento,Motivo: " + se.getMessage());
		}
		String path = construyePDFFile("EEFmes.jasper", PathFicheroXml);
		this.sendMail(path, this.INFORME_MENSUAL);
	}
	
	public void enviaInformeAnual(ActionEvent e){
		this.guardaAnual(e);
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext
				.getCurrentInstance());

		try {
			PathFicheroXml = generadorXML.imprimeAblacionAnual(this.anual, this.bundle);
		} catch (Exception se) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error generando documento,Motivo: " + se.getMessage());
		}
		String path = construyePDFFile("AblacionAnual.jasper", PathFicheroXml);
		// FRR: funcionalidad comentada
		this.pintaMensaje(Mensaje.SEVERIDAD_INFO, "Funcionalidad de envío por email deshabilitada");
		//this.sendMail(path, this.INFORME_ANUAL);
	}
	
	/**
	 * Enviar el correo de las estadisticas
	 * @param path Ruta del pdf
	 * @param tipo 1 = mensual, 2 = anual
	 */
	private void sendMail(String path, Integer tipo) {
		String smtp = null;
		boolean existe = false;

		try {
			// Preparo el adjunto
			BodyPart adjunto = new MimeBodyPart();
			File f = new File(path);
			if (f.exists()) {
				adjunto.setDataHandler(new DataHandler(new FileDataSource(path)));
				existe = true;
			} else {
				pintaMensaje(Mensaje.SEVERIDAD_ERROR, "No existe el informe");
			}

			if (existe) {
				smtp = cm.getServidorCorreo()[0].getValor();

				// Dirección del host smtp
				Properties props = new Properties();
				props.put("mail.smtp.host", smtp);

				// obtenemos una sesión por defecto con la dirección anterior
				Session session = Session.getDefaultInstance(props, null);
				session.setDebug(false);

				// Escribo el texto del mensaje
				BodyPart texto = new MimeBodyPart();

				if(tipo == this.INFORME_MENSUAL){
					texto.setContent(
							"Estimado compa&ntilde;ero/a, <br /><br />"
							+ "Adjunto te remito el informe de actividad " +
							" mensual de "+this.datosmes.getMes()+" de "+this.datosmes.getAnio()+
							" de la unidad de arritmias de nuestro hospital. <br />"
							+ "			<b>Saludos</b> <br />" +
							"			<b>Unidad de Arritmias </b> <br />" +
							"			<b>Cardiolog&iacute;a, Hospital Virgen de las Nieves.</b> <br />",
						"text/html");
					adjunto.setFileName("estadisticas-"+this.datosmes.getMes()+".pdf");
				}else{
					texto.setContent(
							"Estimado compa&ntilde;ero/a, <br /><br />"
							+ "Adjunto te remito el informe de actividad de ablaci&oacute;n " +
							" anual de "+this.datosmes.getAnio()+
							" de la unidad de arritmias de nuestro hospital. <br />"
							+ "			<b>Saludos</b> <br />" +
							"			<b>Unidad de Arritmias </b> <br />" +
							"			<b>Cardiolog&iacute;a, Hospital Virgen de las Nieves.</b> <br />",
						"text/html");
					//poner el año
					adjunto.setFileName("registro-arritmias-ablacion-"+this.anual.getAnio()+".pdf");
				}

				// Juntamos mensaje con adjunto
				MimeMultipart multiParte = new MimeMultipart();
				multiParte.addBodyPart(texto);
				multiParte.addBodyPart(adjunto);

				// Creamos un mensaje
				MimeMessage msg = new MimeMessage(session);

				// Se indica el remitente y el destinatario
				InternetAddress addressFrom = new InternetAddress("Arritmias_cardiacas");
				msg.setFrom(addressFrom);
				
				ArrMaestras[] dest;
				if(tipo == this.INFORME_MENSUAL){
					dest = cm.getEmailMensuales();
					msg.setSubject("Envio de informe de estadistica mensual");
				}else{
					dest = cm.getEmailAnuales();
					msg.setSubject("Envio de informe de ablaciones");
				}
				if (dest != null && dest.length > 0) {
					InternetAddress[] address = new InternetAddress[dest.length];
					for (int i = 0; i < dest.length; i++)
						address[i] = new InternetAddress(dest[i].getValor());
					msg.addRecipients(Message.RecipientType.TO, address);
				}

				/*InternetAddress[] addressTo = new InternetAddress[1];
				addressTo[0] = new InternetAddress(correo);
				msg.setRecipients(Message.RecipientType.TO, addressTo);*/

				// Se configura el Asunto y la fecha de envío
				msg.setSentDate(new Date());

				// Se escribe el mensaje y se indica del tipo que es
				msg.setContent(multiParte);

				// Enviamos el email
				Transport.send(msg);
				
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, "El informe ha sido enviado.");
				f.delete();
			}
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "No se ha podido enviar el correo: " + e.getMessage());
		}
	}


	public Integer getMaxanio() {
		return maxanio;
	}

	public ArrDatosMes getDatosmes() {
		return datosmes;
	}

	public void setDatosmes(ArrDatosMes datosmes) {
		this.datosmes = datosmes;
	}

	public ArrayList<SelectItem> getMeses() {
		return meses;
	}

	public ArrAnual getAnual() {
		return anual;
	}

	public void setAnual(ArrAnual anual) {
		this.anual = anual;
	}

	public ArrayList<DatoEstAnual> getLstEstAnuales() {
		return lstEstAnuales;
	}

	public void setLstEstAnuales(ArrayList<DatoEstAnual> lstEstAnuales) {
		this.lstEstAnuales = lstEstAnuales;
	}
	public HtmlDataTable getLstb() {
		return lstb;
	}
	public void setLstb(HtmlDataTable lstb) {
		this.lstb = lstb;
	}

	public Integer getMesMarcado() {
		return mesMarcado;
	}

	public void setMesMarcado(Integer mesMarcado) {
		this.mesMarcado = mesMarcado;
	}

	public String getDescriMesMarcado() {
		return descriMesMarcado;
	}

	public void setDescriMesMarcado(String descriMesMarcado) {
		this.descriMesMarcado = descriMesMarcado;
	}
	/*************************/
	public void generarEstadisticasGenerales(ActionEvent e){
		if(this.getFechaini_gen()==null || this.getFechafin_gen()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_warn_ver"));
		else
			try {
				// Se controla la generacion acorde a los modulos asociados a instancia
				this.setEst_gen(true);
				
				ArrayList<ArrayList<Object>> pacs = pacdao.getEstadisticasPaciente();
				estGenPacientes(pacs);
				this.setChartDataGenSexo(null);
				pintaGraficaGenPatSexo(null);
				this.setChartDataGenCarProc(null);
				pintaGraficaGenPatCar(null);
				
				ArrayList<ArrayList<Object>> procs = procdao.getNumtotalProcedimientos(this.getFechaini_gen(), this.getFechafin_gen());
				ComplicacionesPacientes[] comps = compacdao.findByDynamicWhere("FECHAINI BETWEEN ? AND ?", new Object[]{this.getFechaini_gen(), this.getFechafin_gen()});
				estGenTotalProcs(procs,comps);
				this.setChartDataGenProc(null);
				pintaGraficaGenProc(null);
				this.setChartDataGenProcComp(null);
				pintaGraficaGenProcComp(null);
				this.setChartDataGenTipoComp(null);
				pintaGraficaGenTipoComp(null);
				
				List<ArrAccesoModulos> listaModulos = Arrays.asList( this.lf.getAccmods() );
				for( ArrAccesoModulos arrAccesoModulos : listaModulos ) {
					if( arrAccesoModulos.getIdTipoProcedimiento() == 956 ){
						ArrayList<ArrayList<Object>> segs = procdao.getNumtotalSeguimientos(this.getFechaini_gen(), this.getFechafin_gen());
						estGenSeguimientos(segs);
						this.setChartDataGenSegs(null);
						pintaGraficaGenSegsRem(null);
					}
				}
				
				//this.setChartDataGen(null);				
			} catch (Exception e1) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver")+": "+e1.getCause().toString());
				logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString());
				e1.printStackTrace();
			} 	
	}
	private void estGenTotalProcs(ArrayList<ArrayList<Object>> procs, ComplicacionesPacientes[] comps){
		Frequency f = new Frequency();
		Frequency f_pat = new Frequency();
		for(int i=0;i<procs.size();i++){			
			f.addValue((Integer)procs.get(i).get(1));
			f_pat.addValue((Integer)procs.get(i).get(2));
		}
		Frequency f_comp = new Frequency();
		Frequency f_comp_proc = new Frequency();
		Frequency f_comp_tipo = new Frequency();
		Frequency f_comp_tipo_reg = new Frequency();
		Frequency f_comp_tipo_imp = new Frequency();
		Frequency f_comp_tipo_imp_r = new Frequency();
		Frequency f_comp_tipo_eef = new Frequency();
		Frequency f_comp_tipo_cve = new Frequency();
		this.totalCompNoAsig = 0;
		for(ComplicacionesPacientes cp:comps){
			f_comp.addValue(cp.getComplicacion());
			if(cp.getTipo()!=null)
				f_comp_tipo.addValue(cp.getTipo());
			if(cp.getTipoprocedimiento()!=null){
				f_comp_proc.addValue(cp.getTipoprocedimiento());
				if(cp.getTipoprocedimiento()==1067)
					f_comp_tipo_reg.addValue(cp.getTipo());
				else if(cp.getTipoprocedimiento()==1061)
					f_comp_tipo_eef.addValue(cp.getTipo());
				else if(cp.getTipoprocedimiento()==956 || cp.getTipoprocedimiento()==1059 
						|| cp.getTipoprocedimiento()==1060 || cp.getTipoprocedimiento()==1090)
					f_comp_tipo_imp.addValue(cp.getTipo());
				else if(cp.getTipoprocedimiento()==957 || cp.getTipoprocedimiento()==1085 
						|| cp.getTipoprocedimiento()==1086 || cp.getTipoprocedimiento()==1147)
					f_comp_tipo_imp_r.addValue(cp.getTipo());
				else if(cp.getTipoprocedimiento()==1068)
					f_comp_tipo_cve.addValue(cp.getTipo());
			}else
				this.totalCompNoAsig++;
		}
		this.getGenprocs().clear();
		this.getGenprocscomp().clear();
		this.getGentipocomp().clear();
		
		List<ArrAccesoModulos> listaModulos = Arrays.asList( this.lf.getAccmods() );
		
		for( ArrAccesoModulos arrAccesoModulos : listaModulos ) {
			
			// CONTROL POR MODULOS PERMITIDOS
			if( arrAccesoModulos.getIdTipoProcedimiento() == 1063 ){
				EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("proc_label_test_gen"),f.getCount(1063)+f.getCount(1064)+f.getCount(1065),Double.isNaN(f.getPct(1063)+f.getPct(1064)+f.getPct(1065))?0:Math.rint(((f.getPct(1063)+f.getPct(1064)+f.getPct(1065))*100)*100)/100);
				this.getGenprocs().add(eb1);
			}
			if( arrAccesoModulos.getIdTipoProcedimiento() == 1066){
				EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("proc_label_mesa"),f.getCount(1066),Double.isNaN(f.getPct(1066))?0:Math.rint((f.getPct(1066)*100)*100)/100);
				this.getGenprocs().add(eb4);
			}
			if( arrAccesoModulos.getIdTipoProcedimiento() == 1067 ){
				EstadisticasBasicas eb5 = new EstadisticasBasicas(this.bundle.getString("proc_1067"),f.getCount(1067),Double.isNaN(f.getPct(1067))?0:Math.rint((f.getPct(1067)*100)*100)/100);
				this.getGenprocs().add(eb5);
				EstadisticasBasicas ebComp = new EstadisticasBasicas(this.bundle.getString("proc_1067"),f_comp_proc.getCount(1067),Double.isNaN(f_comp_proc.getPct(1067))?0:Math.rint((f_comp_proc.getPct(1067)*100)*100)/100,f_comp_tipo_reg.getCount(1),Double.isNaN(f_comp_tipo_reg.getPct(1))?0:Math.rint((f_comp_tipo_reg.getPct(1)*100)*100)/100,f_comp_tipo_reg.getCount(2),Double.isNaN(f_comp_tipo_reg.getPct(2))?0:Math.rint((f_comp_tipo_reg.getPct(2)*100)*100)/100,f_comp_tipo_reg.getCount(3),Double.isNaN(f_comp_tipo_reg.getPct(3))?0:Math.rint((f_comp_tipo_reg.getPct(3)*100)*100)/100);
				this.getGenprocscomp().add(ebComp);
			}
			if( arrAccesoModulos.getIdTipoProcedimiento() == 1061 ){
				EstadisticasBasicas eb6 = new EstadisticasBasicas(this.bundle.getString("proc_label_eef_abl"),f.getCount(1061),Double.isNaN(f.getPct(1061))?0:Math.rint((f.getPct(1061)*100)*100)/100);
				this.getGenprocs().add(eb6);
				EstadisticasBasicas ebComp = new EstadisticasBasicas(this.bundle.getString("proc_label_eef_abl"),f_comp_proc.getCount(1061),Double.isNaN(f_comp_proc.getPct(1061))?0:Math.rint((f_comp_proc.getPct(1061)*100)*100)/100,f_comp_tipo_eef.getCount(1),Double.isNaN(f_comp_tipo_eef.getPct(1))?0:Math.rint((f_comp_tipo_eef.getPct(1)*100)*100)/100,f_comp_tipo_eef.getCount(2),Double.isNaN(f_comp_tipo_eef.getPct(2))?0:Math.rint((f_comp_tipo_eef.getPct(2)*100)*100)/100,f_comp_tipo_eef.getCount(3),Double.isNaN(f_comp_tipo_eef.getPct(3))?0:Math.rint((f_comp_tipo_eef.getPct(3)*100)*100)/100);
				this.getGenprocscomp().add(ebComp);
			}
			if( arrAccesoModulos.getIdTipoProcedimiento() == 1068 ){
				EstadisticasBasicas eb7 = new EstadisticasBasicas(this.bundle.getString("proc_1068"),f.getCount(1068),Double.isNaN(f.getPct(1068))?0:Math.rint((f.getPct(1068)*100)*100)/100);
				this.getGenprocs().add(eb7);
				EstadisticasBasicas ebComp = new EstadisticasBasicas(this.bundle.getString("proc_1068"),f_comp_proc.getCount(1068),Double.isNaN(f_comp_proc.getPct(1068))?0:Math.rint((f_comp_proc.getPct(1068)*100)*100)/100,f_comp_tipo_cve.getCount(1),Double.isNaN(f_comp_tipo_cve.getPct(1))?0:Math.rint((f_comp_tipo_cve.getPct(1)*100)*100)/100,f_comp_tipo_cve.getCount(2),Double.isNaN(f_comp_tipo_cve.getPct(2))?0:Math.rint((f_comp_tipo_cve.getPct(2)*100)*100)/100,f_comp_tipo_cve.getCount(3),Double.isNaN(f_comp_tipo_cve.getPct(3))?0:Math.rint((f_comp_tipo_cve.getPct(3)*100)*100)/100);
				this.getGenprocscomp().add(ebComp);
			}
			if( arrAccesoModulos.getIdTipoProcedimiento() == 956 ){
				EstadisticasBasicas eb8 = new EstadisticasBasicas(this.bundle.getString("proc_label_imp_general"),f.getCount(956)+f.getCount(1059)+f.getCount(1060)+f.getCount(1090),Double.isNaN(f.getPct(956)+f.getPct(1059)+f.getPct(1060)+f.getPct(1090))?0:Math.rint(((f.getPct(956)+f.getPct(1059)+f.getPct(1060)+f.getPct(1090))*100)*100)/100);
				EstadisticasBasicas eb9 = new EstadisticasBasicas(this.bundle.getString("proc_label_reint"),f.getCount(957)+f.getCount(1085)+f.getCount(1086)+f.getCount(1147),Double.isNaN(f.getPct(957)+f.getPct(1085)+f.getPct(1086)+f.getPct(1147))?0:Math.rint(((f.getPct(957)+f.getPct(1085)+f.getPct(1086)+f.getPct(1147))*100)*100)/100);
				this.getGenprocs().add(eb8);
				this.getGenprocs().add(eb9);
				EstadisticasBasicas ebComp = new EstadisticasBasicas(this.bundle.getString("proc_label_imp_general"),f_comp_proc.getCount(956)+f_comp_proc.getCount(1059)+f_comp_proc.getCount(1060)+f_comp_proc.getCount(1090),Double.isNaN(f_comp_proc.getPct(956)+f_comp_proc.getPct(1059)+f_comp_proc.getPct(1060)+f_comp_proc.getPct(1090))?0:Math.rint(((f_comp_proc.getPct(956)+f_comp_proc.getPct(1059)+f_comp_proc.getPct(1060)+f_comp_proc.getPct(1090))*100)*100)/100,f_comp_tipo_imp.getCount(1),Double.isNaN(f_comp_tipo_imp.getPct(1))?0:Math.rint((f_comp_tipo_imp.getPct(1)*100)*100)/100,f_comp_tipo_imp.getCount(2),Double.isNaN(f_comp_tipo_imp.getPct(2))?0:Math.rint((f_comp_tipo_imp.getPct(2)*100)*100)/100,f_comp_tipo_imp.getCount(3),Double.isNaN(f_comp_tipo_imp.getPct(3))?0:Math.rint((f_comp_tipo_imp.getPct(3)*100)*100)/100);
				this.getGenprocscomp().add(ebComp);
				EstadisticasBasicas ebCompR = new EstadisticasBasicas(this.bundle.getString("proc_label_reint"),f_comp_proc.getCount(957)+f_comp_proc.getCount(1085)+f_comp_proc.getCount(1086)+f_comp_proc.getCount(1147),Double.isNaN(f_comp_proc.getPct(957)+f_comp_proc.getPct(1085)+f_comp_proc.getPct(1086)+f_comp_proc.getPct(1147))?0:Math.rint(((f_comp_proc.getPct(957)+f_comp_proc.getPct(1085)+f_comp_proc.getPct(1086)+f_comp_proc.getPct(1147))*100)*100)/100,f_comp_tipo_imp_r.getCount(1),Double.isNaN(f_comp_tipo_imp_r.getPct(1))?0:Math.rint((f_comp_tipo_imp_r.getPct(1)*100)*100)/100,f_comp_tipo_imp_r.getCount(2),Double.isNaN(f_comp_tipo_imp_r.getPct(2))?0:Math.rint((f_comp_tipo_imp_r.getPct(2)*100)*100)/100,f_comp_tipo_imp_r.getCount(3),Double.isNaN(f_comp_tipo_imp_r.getPct(3))?0:Math.rint((f_comp_tipo_imp_r.getPct(3)*100)*100)/100);
				this.getGenprocscomp().add(ebCompR);
			}
			if( arrAccesoModulos.getIdTipoProcedimiento() == 1089 ){
				EstadisticasBasicas eb10 = new EstadisticasBasicas(this.bundle.getString("proc_label_holter"),f.getCount(1089),Double.isNaN(f.getPct(1089))?0:Math.rint((f.getPct(1089)*100)*100)/100);
				this.getGenprocs().add(eb10);
			}
			if( arrAccesoModulos.getIdTipoProcedimiento() == 1091 ){
				EstadisticasBasicas eb11 = new EstadisticasBasicas(this.bundle.getString("proc_1091"),f.getCount(1091),Double.isNaN(f.getPct(1091))?0:Math.rint((f.getPct(1091)*100)*100)/100);
				this.getGenprocs().add(eb11);
			}
		}
		

		EstadisticasBasicas ebCompTotal = new EstadisticasBasicas(this.bundle.getString("est_basic_total"),f_comp_proc.getCount(1067)+f_comp_proc.getCount(1061)+f_comp_proc.getCount(1068)+f_comp_proc.getCount(956)+f_comp_proc.getCount(1059)+f_comp_proc.getCount(1060)+f_comp_proc.getCount(1090)+f_comp_proc.getCount(957)+f_comp_proc.getCount(1085)+f_comp_proc.getCount(1086)+f_comp_proc.getCount(1147),
				Double.isNaN(f_comp_proc.getPct(1067)+f_comp_proc.getPct(1068)+f_comp_proc.getPct(1061)+f_comp_proc.getPct(956)+f_comp_proc.getPct(1059)+f_comp_proc.getPct(1060)+f_comp_proc.getPct(1090)+f_comp_proc.getPct(957)+f_comp_proc.getPct(1085)+f_comp_proc.getPct(1086)+f_comp_proc.getPct(1147))?0:Math.rint(((f_comp_proc.getPct(1067)+f_comp_proc.getPct(1068)+f_comp_proc.getPct(1061)+f_comp_proc.getPct(956)+f_comp_proc.getPct(1059)+f_comp_proc.getPct(1060)+f_comp_proc.getPct(1090)+f_comp_proc.getPct(957)+f_comp_proc.getPct(1085)+f_comp_proc.getPct(1086)+f_comp_proc.getPct(1147))*100)*100)/100,
						f_comp_tipo_reg.getCount(1)+f_comp_tipo_cve.getCount(1)+f_comp_tipo_eef.getCount(1)+f_comp_tipo_imp.getCount(1)+f_comp_tipo_imp_r.getCount(1),Double.isNaN(f_comp_tipo_reg.getPct(1)+f_comp_tipo_cve.getPct(1)+f_comp_tipo_eef.getPct(1)+f_comp_tipo_imp.getPct(1)+f_comp_tipo_imp_r.getPct(1))?0:Math.rint(((f_comp_tipo_reg.getPct(1)+f_comp_tipo_cve.getPct(1)+f_comp_tipo_eef.getPct(1)+f_comp_tipo_imp.getPct(1)+f_comp_tipo_imp_r.getPct(1))*100)*100)/100,
								f_comp_tipo_reg.getCount(2)+f_comp_tipo_cve.getCount(2)+f_comp_tipo_eef.getCount(2)+f_comp_tipo_imp.getCount(2)+f_comp_tipo_imp_r.getCount(2),Double.isNaN(f_comp_tipo_reg.getPct(2)+f_comp_tipo_cve.getPct(2)+f_comp_tipo_eef.getPct(2)+f_comp_tipo_imp.getPct(2)+f_comp_tipo_imp_r.getPct(2))?0:Math.rint(((f_comp_tipo_reg.getPct(2)+f_comp_tipo_cve.getPct(2)+f_comp_tipo_eef.getPct(2)+f_comp_tipo_imp.getPct(2)+f_comp_tipo_imp_r.getPct(2))*100)*100)/100,
										f_comp_tipo_reg.getCount(3)+f_comp_tipo_cve.getCount(3)+f_comp_tipo_eef.getCount(3)+f_comp_tipo_imp.getCount(3)+f_comp_tipo_imp_r.getCount(3),Double.isNaN(f_comp_tipo_reg.getPct(3)+f_comp_tipo_cve.getPct(3)+f_comp_tipo_eef.getPct(3)+f_comp_tipo_imp.getPct(3)+f_comp_tipo_imp_r.getPct(3))?0:Math.rint(((f_comp_tipo_reg.getPct(3)+f_comp_tipo_cve.getPct(3)+f_comp_tipo_eef.getPct(3)+f_comp_tipo_imp.getPct(3)+f_comp_tipo_imp_r.getPct(3))*100)*100)/100);
		this.getGenprocscomp().add(ebCompTotal);
		
		
		EstadisticasBasicas ebTipoComp1 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_1"),f_comp_tipo.getCount(1),f_comp_tipo.getPct(1)*100);
		EstadisticasBasicas ebTipoComp2 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_2"),f_comp_tipo.getCount(2),f_comp_tipo.getPct(2)*100);
		EstadisticasBasicas ebTipoComp3 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_3"),f_comp_tipo.getCount(3),f_comp_tipo.getPct(3)*100);
		EstadisticasBasicas ebTipoCompTotal = new EstadisticasBasicas(this.bundle.getString("est_basic_total"),f_comp_tipo.getCount(1)+f_comp_tipo.getCount(2)+f_comp_tipo.getCount(3),(f_comp_tipo.getPct(1)+f_comp_tipo.getPct(2)+f_comp_tipo.getPct(3))*100);
		this.getGentipocomp().add(ebTipoComp1);this.getGentipocomp().add(ebTipoComp2);this.getGentipocomp().add(ebTipoComp3);this.getGentipocomp().add(ebTipoCompTotal);
		//EstadisticasBasicas eb2 = new EstadisticasBasicas("Test Farmacológicos EPI",f.getCount(1064),f.getPct(1064)*100);
		//EstadisticasBasicas eb3 = new EstadisticasBasicas("Test Farmacológicos FLE",f.getCount(1065),f.getPct(1065)*100);
		//EstadisticasBasicas eb10 = new EstadisticasBasicas("Total",f.getSumFreq(),1*100);
		//this.getGenprocs().add(eb2);this.getGenprocs().add(eb3);
		//this.getGenprocs().add(eb10);	
		this.setResgen1(String.valueOf(f.getSumFreq()));
		this.setResgen3(String.valueOf((float)f.getSumFreq()/(float)f_pat.getUniqueCount()));
	}
	private void estGenSeguimientos(ArrayList<ArrayList<Object>> segs){
		Frequency f = new Frequency();
		Frequency f_rem = new Frequency();
		for(int i=0;i<segs.size();i++){			
			f.addValue((String)segs.get(i).get(2));
			if(segs.get(i).get(3)==null)
				f_rem.addValue(false);
			else
				f_rem.addValue((Boolean)segs.get(i).get(3));
		}
		this.getGensegs().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_1"),f.getCount("1"),Double.isNaN(f.getPct("1"))?0:Math.rint(((f.getPct("1")*100))*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_2"),f.getCount("2"),Double.isNaN(f.getPct("2"))?0:Math.rint(((f.getPct("2")*100))*100)/100);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_3"),f.getCount("3"),Double.isNaN(f.getPct("3"))?0:Math.rint(((f.getPct("3")*100))*100)/100);
		EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_4"),f.getCount("4"),Double.isNaN(f.getPct("4"))?0:Math.rint(((f.getPct("4")*100))*100)/100);
		//EstadisticasBasicas eb5 = new EstadisticasBasicas("Total",f.getSumFreq(),1*100);
		this.getGensegs().add(eb1);this.getGensegs().add(eb2);this.getGensegs().add(eb3);
		this.getGensegs().add(eb4);//this.getGensegs().add(eb5);
		this.setResgen4(String.valueOf(f.getSumFreq()));
		this.getGensegsrem().clear();
		EstadisticasBasicas eb11 = new EstadisticasBasicas(this.bundle.getString("seg_disp_tipo_seg_pres_op1"),f_rem.getCount(false),Double.isNaN(f_rem.getPct(false))?0:Math.rint(((f_rem.getPct(false))*100)*100)/100 );
		EstadisticasBasicas eb12 = new EstadisticasBasicas(this.bundle.getString("seg_disp_tipo_seg_pres_op2"),f_rem.getCount(true),Double.isNaN(f_rem.getPct(true))?0:Math.rint(((f_rem.getPct(true))*100)*100)/100);
		this.getGensegsrem().add(eb11);this.getGensegsrem().add(eb12);
	}
	private void estGenSeguimientosDisp(ArrayList<ArrayList<Object>> segs){
		Frequency f = new Frequency();
		for(int i=0;i<segs.size();i++){			
			f.addValue((String)segs.get(i).get(2));
		}
		this.getGensegs().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_1"),f.getCount("1"),Double.isNaN(f.getPct("1"))?0:Math.rint((f.getPct("1")*100)*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_2"),f.getCount("2"),Double.isNaN(f.getPct("2"))?0:Math.rint((f.getPct("2")*100)*100)/100);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_3"),f.getCount("3"),Double.isNaN(f.getPct("3"))?0:Math.rint((f.getPct("3")*100)*100)/100);
		EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_4"),f.getCount("4"),Double.isNaN(f.getPct("4"))?0:Math.rint((f.getPct("4")*100)*100)/100);
		//EstadisticasBasicas eb5 = new EstadisticasBasicas("Total",f.getSumFreq(),1*100);
		this.getGensegs().add(eb1);this.getGensegs().add(eb2);this.getGensegs().add(eb3);
		this.getGensegs().add(eb4);//this.getGensegs().add(eb5);	
		this.setResgen4(String.valueOf(f.getSumFreq()));
	}
	private void estGenPacientes(ArrayList<ArrayList<Object>> pacs) throws Exception{		
		DescriptiveStatistics stats = new DescriptiveStatistics();
		//Frequency f_edad = new Frequency();
		Frequency f_sexo = new Frequency();
		Frequency f_caracter = new Frequency();
		for(int i=0;i<pacs.size();i++){
			if((Date)pacs.get(i).get(0)!=null)// control de fecha de nacimiento
				stats.addValue((Integer)UtilFechas.getEdad((Date)pacs.get(i).get(0)));
			if((Integer)pacs.get(i).get(1)!=null)
				f_sexo.addValue((Integer)pacs.get(i).get(1));
			if((Integer)pacs.get(i).get(2)!=null)
				f_caracter.addValue((Integer)pacs.get(i).get(2));
		}
		this.getGenpatsexo().clear();
		this.setResgen5(String.valueOf(Math.rint((stats.getMean())*100)/100)+" "+this.bundle.getString("anios")+".");
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("masculino"),f_sexo.getCount(1),Double.isNaN(f_sexo.getPct(1))?0: Math.rint((f_sexo.getPct(1)*100)*100)/100 );
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("femenino"),f_sexo.getCount(2),Double.isNaN(f_sexo.getPct(2))?0:Math.rint((f_sexo.getPct(2)*100)*100)/100);
		//EstadisticasBasicas eb3 = new EstadisticasBasicas("Total",f_sexo.getSumFreq(),1*100);
		this.getGenpatsexo().add(eb1);this.getGenpatsexo().add(eb2);//this.getGenpatsexo().add(eb3);
		this.setResgen7(String.valueOf(f_sexo.getSumFreq()));
		this.getGenpatcar().clear();
		ArrMaestras[] carproc = maestrasdao.findWhereTipoEquals(1);
		for(int i=0;i<carproc.length;i++){
			if(carproc[i].getValor()!=null){
				EstadisticasBasicas item = new EstadisticasBasicas(carproc[i].getValor(),f_caracter.getCount(carproc[i].getCodigo()),Double.isNaN(f_caracter.getPct(carproc[i].getCodigo()))?0:Math.rint((f_caracter.getPct(carproc[i].getCodigo())*100)*100)/100  );
				this.genpatcar.add(item);
			}	
		}
		EstadisticasBasicas item = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_caracter.getCount(0),Double.isNaN(f_caracter.getPct(0))?0:Math.rint((f_caracter.getPct(0)*100)*100)/100 );
		this.genpatcar.add(item);
	}
	
	public void generarEstadisticasMesaBasculante(ActionEvent e){
		if(this.getFechaini_mesa()==null || this.getFechafin_mesa()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_warn_ver"));
		else
			try{
				ArrayList<ArrayList<Object>> mesas = mesadao.getEstadisticasMesas(this.getFechaini_mesa(), this.getFechafin_mesa());
				generaEstadisticasMesa(mesas);
				this.setEst_mesa(true);
				this.setChartDataMesa(null);
				this.setChartDataMesaRes(null);
				pintaGraficaMesaRes(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver")+": "+e1.getCause().toString());
				logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString());
			}
	}
	private void generaEstadisticasMesa(ArrayList<ArrayList<Object>> mesas){
		Frequency f_res = new Frequency();
		Frequency f_pos_ntg = new Frequency();
		Frequency f_neg_ntg = new Frequency();
		for(int i=0;i<mesas.size();i++){
			f_res.addValue((Integer)mesas.get(i).get(0));
			if(mesas.get(i).get(0).equals(1))
				f_pos_ntg.addValue((Integer)mesas.get(i).get(1));
			else if(mesas.get(i).get(0).equals(0))
				f_neg_ntg.addValue((Integer)mesas.get(i).get(1));
		}
		this.getMesares().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("mesa_tab3_res_op1"),f_res.getCount(1),Double.isNaN(f_res.getPct(1))?0:Math.rint((f_res.getPct(1)*100)*100/100),f_pos_ntg.getCount(1),Double.isNaN(f_pos_ntg.getPct(1))?0:Math.rint((f_pos_ntg.getPct(1)*100)*100/100),0,0);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("mesa_tab3_res_op0"),f_res.getCount(0),Double.isNaN(f_res.getPct(0))?0:Math.rint((f_res.getPct(0)*100)*100/100),f_neg_ntg.getCount(1),Double.isNaN(f_neg_ntg.getPct(1))?0:Math.rint((f_neg_ntg.getPct(1)*100)*100/100),0,0);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_res.getCount(-1),Double.isNaN(f_res.getPct(-1))?0:Math.rint((f_res.getPct(-1)*100)*100/100),0,0,0,0);
		//EstadisticasBasicas eb3 = new EstadisticasBasicas("Total",f_res.getSumFreq(),1*100);
		this.getMesares().add(eb1);this.getMesares().add(eb2);this.getMesares().add(eb3);
		/*this.getMesantg().clear();
		EstadisticasBasicas eb11 = new EstadisticasBasicas("Si",f_ntg.getCount(1),f_ntg.getPct(1)*100);
		EstadisticasBasicas eb22 = new EstadisticasBasicas("No",f_ntg.getCount(0),f_ntg.getPct(0)*100);
		//EstadisticasBasicas eb33 = new EstadisticasBasicas("Total",f_ntg.getSumFreq(),1*100);
		this.getMesantg().add(eb11);this.getMesantg().add(eb22);//this.getMesantg().add(eb33);	*/	
	}
	public void generarEstadisticasRegistrador(ActionEvent e){
		if(this.getFechaini_reg()==null || this.getFechafin_reg()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_warn_ver"));
		else
			try{
				ArrayList<ArrayList<Object>> regs = regdao.getEstadisticasRegistrador(this.getFechaini_reg(), this.getFechafin_reg());
				ArrayList<ArrayList<Object>> compReg = compacdao.getComplicacionesTipoProc(4, this.getFechaini_reg(), this.getFechafin_reg());
				generaEstadisticasRegistrador(regs,compReg);
				this.setEst_reg(true);
				this.setChartDataReg(null);
				this.setChartDataRegInd(null);
				pintaGraficaRegInd(null);
				this.setChartDataRegDiag(null);
				pintaGraficaRegMot(null);
				this.setChartDataRegFab(null);
				pintaGraficaRegFab(null);
				this.setChartDataRegComp(null);
				pintaGraficaRegComp(null);
				this.setChartDataRegCompTipo(null);
				pintaGraficaRegCompTipo(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver")+": "+e1.getCause().toString());
				logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString());
			}
	}
	private void generaEstadisticasRegistrador(ArrayList<ArrayList<Object>> regs, ArrayList<ArrayList<Object>> comp) throws Exception{
		Frequency f_ind = new Frequency();
		Frequency f_diag = new Frequency();
		Frequency f_mod = new Frequency();
		Frequency f_comp = new Frequency();
		Frequency f_comp_tipo = new Frequency();
		String fab = null;
		for(int i=0;i<regs.size();i++){
			f_ind.addValue((Integer)regs.get(i).get(0));
			f_diag.addValue((Integer)regs.get(i).get(1));
			fab = (String) regs.get(i).get(4);
			if(fab!=null)
				f_mod.addValue(fab);
		}
		this.getRegind().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("regev_tab1_reg_ind_op1"),f_ind.getCount(1),Double.isNaN(f_ind.getPct(1))?0:Math.rint((f_ind.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("regev_tab1_reg_ind_op2"),f_ind.getCount(2),Double.isNaN(f_ind.getPct(2))?0:Math.rint((f_ind.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("regev_tab1_reg_ind_op3"),f_ind.getCount(3),Double.isNaN(f_ind.getPct(3))?0:Math.rint((f_ind.getPct(3)*100)*100)/100);
		EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("regev_tab1_reg_ind_op4"),f_ind.getCount(4),Double.isNaN(f_ind.getPct(4))?0:Math.rint((f_ind.getPct(4)*100)*100)/100);
		EstadisticasBasicas eb5 = new EstadisticasBasicas(this.bundle.getString("regev_tab1_reg_ind_op5"),f_ind.getCount(5),Double.isNaN(f_ind.getPct(5))?0:Math.rint((f_ind.getPct(5)*100)*100)/100);
		EstadisticasBasicas eb6 = new EstadisticasBasicas(this.bundle.getString("regev_tab1_reg_ind_op6"),f_ind.getCount(6),Double.isNaN(f_ind.getPct(6))?0:Math.rint((f_ind.getPct(6)*100)*100)/100);
		EstadisticasBasicas eb7 = new EstadisticasBasicas(this.bundle.getString("regev_tab1_reg_ind_op7"),f_ind.getCount(7),Double.isNaN(f_ind.getPct(7))?0:Math.rint((f_ind.getPct(7)*100)*100)/100);
		EstadisticasBasicas eb8 = new EstadisticasBasicas(this.bundle.getString("regev_tab1_reg_ind_op8"),f_ind.getCount(8),Double.isNaN(f_ind.getPct(8))?0:Math.rint((f_ind.getPct(8)*100)*100)/100);
		EstadisticasBasicas eb9 = new EstadisticasBasicas(this.bundle.getString("regev_tab1_reg_ind_op9"),f_ind.getCount(9),Double.isNaN(f_ind.getPct(9))?0:Math.rint((f_ind.getPct(9)*100)*100)/100);
		EstadisticasBasicas eb10 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_ind.getCount(0),Double.isNaN(f_ind.getPct(0))?0:Math.rint((f_ind.getPct(0)*100)*100)/100);
		//EstadisticasBasicas eb11 = new EstadisticasBasicas("Total",f_ind.getSumFreq(),1*100);
		this.getRegind().add(eb1);this.getRegind().add(eb2);this.getRegind().add(eb3);this.getRegind().add(eb4);
		this.getRegind().add(eb5);this.getRegind().add(eb6);this.getRegind().add(eb7);this.getRegind().add(eb8);
		this.getRegind().add(eb9);this.getRegind().add(eb10);//this.getRegind().add(eb11);
		this.getRegmot().clear();
		EstadisticasBasicas eb11_1 = new EstadisticasBasicas(this.bundle.getString("regev_tab5_exp_motivo_op1"),f_diag.getCount(1),Double.isNaN(f_diag.getPct(1))?0:Math.rint((f_diag.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb22 = new EstadisticasBasicas(this.bundle.getString("regev_tab5_exp_motivo_op2"),f_diag.getCount(2),Double.isNaN(f_diag.getPct(2))?0:Math.rint((f_diag.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb33 = new EstadisticasBasicas(this.bundle.getString("regev_tab5_exp_motivo_op3"),f_diag.getCount(3),Double.isNaN(f_diag.getPct(3))?0:Math.rint((f_diag.getPct(3)*100)*100)/100);
		EstadisticasBasicas eb44 = new EstadisticasBasicas(this.bundle.getString("regev_tab5_exp_motivo_op4"),f_diag.getCount(4),Double.isNaN(f_diag.getPct(4))?0:Math.rint((f_diag.getPct(4)*100)*100)/100);
		EstadisticasBasicas eb55 = new EstadisticasBasicas(this.bundle.getString("regev_tab5_exp_motivo_op5"),f_diag.getCount(5),Double.isNaN(f_diag.getPct(5))?0:Math.rint((f_diag.getPct(5)*100)*100)/100);
		EstadisticasBasicas eb66 = new EstadisticasBasicas(this.bundle.getString("regev_tab5_exp_motivo_op6"),f_diag.getCount(6),Double.isNaN(f_diag.getPct(6))?0:Math.rint((f_diag.getPct(6)*100)*100)/100);
		EstadisticasBasicas eb77 = new EstadisticasBasicas(this.bundle.getString("regev_tab5_exp_motivo_op7"),f_diag.getCount(7),Double.isNaN(f_diag.getPct(7))?0:Math.rint((f_diag.getPct(7)*100)*100)/100);
		EstadisticasBasicas eb88 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_diag.getCount(0),Double.isNaN(f_diag.getPct(0))?0:Math.rint((f_diag.getPct(0)*100)*100)/100);
		//EstadisticasBasicas eb99 = new EstadisticasBasicas("Total",f_diag.getSumFreq(),1*100);
		this.getRegmot().add(eb11_1);this.getRegmot().add(eb22);this.getRegmot().add(eb33);this.getRegmot().add(eb44);
		this.getRegmot().add(eb55);this.getRegmot().add(eb66);this.getRegmot().add(eb77);this.getRegmot().add(eb88);
		//this.getRegmot().add(eb99);
		this.getRegfab().clear();
		EstadisticasBasicas ebmod1 = new EstadisticasBasicas("MEDTRONIC", f_mod.getCount("MEDTRONIC"),Double.isNaN(f_diag.getPct("MEDTRONIC"))?0:Math.rint((f_diag.getPct("MEDTRONIC")*100)*100)/100);
		EstadisticasBasicas ebmod2 = new EstadisticasBasicas("SAINT JUDE MEDICAL", f_mod.getCount("SAINT JUDE MEDICAL"),Double.isNaN(f_diag.getPct("MEDTRONIC"))?0:Math.rint((f_diag.getPct("SAINT JUDE MEDICAL")*100)*100)/100);
		EstadisticasBasicas ebmod3 = new EstadisticasBasicas(this.bundle.getString("desconocido"), f_mod.getCount("IDEA"),Double.isNaN(f_diag.getPct("IDEA"))?0:Math.rint((f_diag.getPct("IDEA")*100)*100)/100);
		this.getRegfab().add(ebmod1);this.getRegfab().add(ebmod2);this.getRegfab().add(ebmod3);
		// COMPLICACIONES
		for(int i=0;i<comp.size();i++){
			if((Integer)comp.get(i).get(0)!=null)
				f_comp.addValue((Integer)comp.get(i).get(0));
			if((Integer)comp.get(i).get(1)!=null)
				f_comp_tipo.addValue((Integer)comp.get(i).get(1));
		}
		this.getRegcomp().clear();
		//Complicaciones[] comps = compdao.findWhereAmbitoEquals(3); 
		Complicaciones[] comps = compdao.findByDynamicWhere("AMBITO = ? OR AMBITO = ?", new Object[]{0,3});
		for(int i=0;i<comps.length;i++){
			if(comps[i].getNombre()!=null){
				EstadisticasBasicas item = new EstadisticasBasicas(comps[i].getNombre(),f_comp.getCount(comps[i].getIdcomplicacion()),Double.isNaN(f_comp.getPct(comps[i].getIdcomplicacion()))?0:Math.rint((f_comp.getPct(comps[i].getIdcomplicacion())*100)*100)/100  );
				this.regcomp.add(item);
			}	
		}
		EstadisticasBasicas eb50 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_comp_tipo.getCount(0),Double.isNaN(f_comp_tipo.getPct(0))?0:Math.rint((f_comp_tipo.getPct(0)*100)*100)/100);
		EstadisticasBasicas eb51 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_1"),f_comp_tipo.getCount(1),Double.isNaN(f_comp_tipo.getPct(1))?0:Math.rint((f_comp_tipo.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb52 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_2"),f_comp_tipo.getCount(2),Double.isNaN(f_comp_tipo.getPct(2))?0:Math.rint((f_comp_tipo.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb53 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_3"),f_comp_tipo.getCount(3),Double.isNaN(f_comp_tipo.getPct(3))?0:Math.rint((f_comp_tipo.getPct(3)*100)*100)/100);
		this.getRegcomptipo().add(eb50);this.getRegcomptipo().add(eb51);this.getRegcomptipo().add(eb52);this.getRegcomptipo().add(eb53);
	}
	public void generarEstadisticasHolter(ActionEvent e){
		if(this.getFechaini_holter()==null || this.getFechafin_holter()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_warn_ver"));
		else
			try{
				ArrayList<ArrayList<Object>> holters = holdao.getEstadisticasHolter(this.getFechaini_holter(), this.getFechafin_holter());
				generaEstadisticasHolter(holters);
				this.setEst_holter(true);
				this.setChartDataHol(null);
				this.setChartDataHolDiagFin(null);
				pintaGraficaHolDiagFin(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver")+": "+e1.getCause().toString());
				logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString());
			}
	}
	private void generaEstadisticasHolter(ArrayList<ArrayList<Object>> holters){
		Frequency f_diag_fin = new Frequency();
		for(int i=0;i<holters.size();i++){
			if(holters.get(i).get(0)!=null)
				f_diag_fin.addValue((Integer)holters.get(i).get(0));
			else
				f_diag_fin.addValue((Integer)0); // los nulos se contabilizan como no especificados
		}
		this.getHoldiagfin().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_diag_fin.getCount(0),Double.isNaN(f_diag_fin.getPct(0))?0:Math.rint((f_diag_fin.getPct(0)*100)*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("holter24h_tab2_col_diag_ini_op1"),f_diag_fin.getCount(1),Double.isNaN(f_diag_fin.getPct(1))?0:Math.rint((f_diag_fin.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("holter24h_tab2_col_diag_ini_op2"),f_diag_fin.getCount(2),Double.isNaN(f_diag_fin.getPct(2))?0:Math.rint((f_diag_fin.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("holter24h_tab2_col_diag_ini_op3"),f_diag_fin.getCount(3),Double.isNaN(f_diag_fin.getPct(3))?0:Math.rint((f_diag_fin.getPct(3)*100)*100)/100);
		EstadisticasBasicas eb5 = new EstadisticasBasicas(this.bundle.getString("holter24h_tab2_col_diag_ini_op4"),f_diag_fin.getCount(4),Double.isNaN(f_diag_fin.getPct(4))?0:Math.rint((f_diag_fin.getPct(4)*100)*100)/100);
		this.getHoldiagfin().add(eb1);this.getHoldiagfin().add(eb2);this.getHoldiagfin().add(eb3);this.getHoldiagfin().add(eb4);this.getHoldiagfin().add(eb5);
	}
	public void generarEstadisticasRegEvExt(ActionEvent e){
		if(this.getFechaini_regevext()==null || this.getFechafin_regevext()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_warn_ver"));
		else
			try{
				ArrayList<ArrayList<Object>> regevexts = regevextdao.getEstadisticasRegEvExt(this.getFechaini_regevext(), this.getFechafin_regevext());
				generaEstadisticasRegEvExt(regevexts);
				this.setEst_regevext(true);
				this.setChartDataRegEvExt(null);
				this.setChartDataRegEvExtDiagFin(null);
				pintaGraficaRegEvExtDiagFin(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver")+": "+e1.getCause().toString());
				logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString());
			}
	}
	private void generaEstadisticasRegEvExt(ArrayList<ArrayList<Object>> regevexts){
		Frequency f_diag_fin = new Frequency();
		for(int i=0;i<regevexts.size();i++){
			if(regevexts.get(i).get(0)!=null)
				f_diag_fin.addValue((Integer)regevexts.get(i).get(0));
			else
				f_diag_fin.addValue((Integer)0); // los nulos se contabilizan como no especificados
		}
		this.getRegevextdiagfin().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_diag_fin.getCount(0),Double.isNaN(f_diag_fin.getPct(0))?0:Math.rint((f_diag_fin.getPct(0)*100)*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("elr_tab2_col_diag_ini_op1"),f_diag_fin.getCount(1),Double.isNaN(f_diag_fin.getPct(1))?0:Math.rint((f_diag_fin.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("elr_tab2_col_diag_ini_op2"),f_diag_fin.getCount(2),Double.isNaN(f_diag_fin.getPct(2))?0:Math.rint((f_diag_fin.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("elr_tab2_col_diag_ini_op3"),f_diag_fin.getCount(3),Double.isNaN(f_diag_fin.getPct(3))?0:Math.rint((f_diag_fin.getPct(3)*100)*100)/100);
		EstadisticasBasicas eb5 = new EstadisticasBasicas(this.bundle.getString("elr_tab2_col_diag_ini_op4"),f_diag_fin.getCount(4),Double.isNaN(f_diag_fin.getPct(4))?0:Math.rint((f_diag_fin.getPct(4)*100)*100)/100);
		this.getRegevextdiagfin().add(eb1);this.getRegevextdiagfin().add(eb2);this.getRegevextdiagfin().add(eb3);this.getRegevextdiagfin().add(eb4);this.getRegevextdiagfin().add(eb5);
	}
	public void generarEstadisticasCv(ActionEvent e){
		if(this.getFechaini_cv()==null || this.getFechafin_cv()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_warn_ver"));
		else
			try{
				ArrayList<ArrayList<Object>> cvs = cvdao.getEstadisticasCv(this.getFechaini_cv(), this.getFechafin_cv());
				ArrayList<ArrayList<Object>> compCVE = compacdao.getComplicacionesTipoProc(6, this.getFechaini_cv(), this.getFechafin_cv());
				generaEstadisticasCv(cvs,compCVE);
				this.setEst_cv(true);
				this.setChartDataCv(null);
				this.setChartDataCvInd(null);
				pintaGraficaCvIndicacion(null);
				this.setChartDataCvExito(null);
				pintaGraficaCvResultado(null);
				this.setChartDatacvAbl(null);
				pintaGraficaCvAblacion(null);
				this.setChartDatacvTipo(null);
				pintaGraficaCvTipo(null);
				this.setChartDatacvComp(null);
				pintaGraficaCvComp(null);
				this.setChartDatacvCompTipo(null);
				pintaGraficaCvCompTipo(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver")+": "+e1.getCause().toString());
				logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString());
			}
	} 
	private void generaEstadisticasCv(ArrayList<ArrayList<Object>> cvs, ArrayList<ArrayList<Object>> comp) throws Exception{
		Frequency f_ind_fib = new Frequency();
		Frequency f_ind_fla = new Frequency();
		Frequency f_ind_flt = new Frequency();
		Frequency f_abl = new Frequency();
		Frequency f_exito = new Frequency();
		Frequency f_tipo = new Frequency();
		Frequency f_comp = new Frequency();
		Frequency f_comp_tipo = new Frequency();
		for(int i=0;i<cvs.size();i++){
			if((Integer)cvs.get(i).get(0)!=null)
				f_ind_fib.addValue((Integer)cvs.get(i).get(0));
			if((Integer)cvs.get(i).get(1)!=null)
				f_ind_fla.addValue((Integer)cvs.get(i).get(1));
			if((Integer)cvs.get(i).get(2)!=null)
				f_ind_flt.addValue((Integer)cvs.get(i).get(2));
			if((Integer)cvs.get(i).get(3)!=null)
				f_abl.addValue((Integer)cvs.get(i).get(3));
			if((Integer)cvs.get(i).get(4)!=null)
				f_exito.addValue((Integer)cvs.get(i).get(4));
			if((Integer)cvs.get(i).get(5)!=null)
				f_tipo.addValue((Integer)cvs.get(i).get(5));
		}
		this.getCvind().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("cve_tab1_ind_op1"),f_ind_fib.getCount(1),Double.isNaN(f_ind_fib.getPct(1))?0:Math.rint((f_ind_fib.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("cve_tab1_ind_op2"),f_ind_fla.getCount(1),Double.isNaN(f_ind_fla.getPct(1))?0:Math.rint((f_ind_fla.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("cve_tab1_ind_op3"),f_ind_flt.getCount(1),Double.isNaN(f_ind_flt.getPct(1))?0:Math.rint((f_ind_flt.getPct(1)*100)*100)/100);
		//EstadisticasBasicas eb4 = new EstadisticasBasicas("Total",f_ind_fib.getCount(4),f_ind_fib.getPct(4)*100);
		this.getCvind().add(eb1);this.getCvind().add(eb2);this.getCvind().add(eb3);
		this.getCvabl().clear();
		EstadisticasBasicas eb21 = new EstadisticasBasicas(this.bundle.getString("cve_tab1_abl_op1"),f_abl.getCount(1),Double.isNaN(f_abl.getPct(1))?0:Math.rint((f_abl.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb22 = new EstadisticasBasicas(this.bundle.getString("cve_tab1_abl_op0"),f_abl.getCount(0),Double.isNaN(f_abl.getPct(0))?0:Math.rint((f_abl.getPct(0)*100)*100)/100);
		//EstadisticasBasicas eb23 = new EstadisticasBasicas("Total",f_abl.getSumFreq(),1*100);
		//EstadisticasBasicas eb4 = new EstadisticasBasicas("Total",f_ind_fib.getCount(4),f_ind_fib.getPct(4)*100);
		this.getCvabl().add(eb21);this.getCvabl().add(eb22);//this.getCvabl().add(eb23);
		this.getCvres().clear();
		EstadisticasBasicas eb31 = new EstadisticasBasicas(this.bundle.getString("cve_tab2_exitofinal_op1"),f_exito.getCount(1),Double.isNaN(f_exito.getPct(1))?0:Math.rint((f_exito.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb32 = new EstadisticasBasicas(this.bundle.getString("cve_tab2_exitofinal_op0"),f_exito.getCount(0),Double.isNaN(f_exito.getPct(0))?0:Math.rint((f_exito.getPct(0)*100)*100)/100);
		//EstadisticasBasicas eb33 = new EstadisticasBasicas("Total",f_exito.getSumFreq(),1*100);
		this.getCvres().add(eb31);this.getCvres().add(eb32);//this.getCvres().add(eb33);	
		
		EstadisticasBasicas eb40 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_tipo.getCount(0),Double.isNaN(f_tipo.getPct(0))?0:Math.rint((f_tipo.getPct(0)*100)*100)/100);
		EstadisticasBasicas eb41 = new EstadisticasBasicas(this.bundle.getString("cve_tab2_tipoproc_op1"),f_tipo.getCount(1),Double.isNaN(f_tipo.getPct(1))?0:Math.rint((f_tipo.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb42 = new EstadisticasBasicas(this.bundle.getString("cve_tab2_tipoproc_op2"),f_tipo.getCount(2),Double.isNaN(f_tipo.getPct(2))?0:Math.rint((f_tipo.getPct(2)*100)*100)/100);
		this.getCvtipo().add(eb40);this.getCvtipo().add(eb41);this.getCvtipo().add(eb42);
		// GESTION COMPLICACIONES CVE
		for(int i=0;i<comp.size();i++){
			if((Integer)comp.get(i).get(0)!=null)
				f_comp.addValue((Integer)comp.get(i).get(0));
			if((Integer)comp.get(i).get(1)!=null)
				f_comp_tipo.addValue((Integer)comp.get(i).get(1));
		}
		this.getCvcomp().clear();
		//Complicaciones[] comps = compdao.findWhereAmbitoEquals(5); 
		Complicaciones[] comps = compdao.findByDynamicWhere("AMBITO = ? OR AMBITO = ?", new Object[]{0,5});
		for(int i=0;i<comps.length;i++){
			if(comps[i].getNombre()!=null){
				EstadisticasBasicas item = new EstadisticasBasicas(comps[i].getNombre(),f_comp.getCount(comps[i].getIdcomplicacion()),Double.isNaN(f_comp.getPct(comps[i].getIdcomplicacion()))?0:Math.rint((f_comp.getPct(comps[i].getIdcomplicacion())*100)*100)/100  );
				this.cvcomp.add(item);
			}	
		}
		EstadisticasBasicas eb50 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_comp_tipo.getCount(0),Double.isNaN(f_comp_tipo.getPct(0))?0:Math.rint((f_comp_tipo.getPct(0)*100)*100)/100);
		EstadisticasBasicas eb51 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_1"),f_comp_tipo.getCount(1),Double.isNaN(f_comp_tipo.getPct(1))?0:Math.rint((f_comp_tipo.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb52 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_2"),f_comp_tipo.getCount(2),Double.isNaN(f_comp_tipo.getPct(2))?0:Math.rint((f_comp_tipo.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb53 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_3"),f_comp_tipo.getCount(3),Double.isNaN(f_comp_tipo.getPct(3))?0:Math.rint((f_comp_tipo.getPct(3)*100)*100)/100);
		this.getCvcomptipo().add(eb50);this.getCvcomptipo().add(eb51);this.getCvcomptipo().add(eb52);this.getCvcomptipo().add(eb53);
	}
	public void generarEstadisticasTest(ActionEvent e){
		if(this.getFechaini_test()==null || this.getFechafin_test()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_warn_ver"));
		else
			try{
				ArrayList<ArrayList<Object>> atps = testatpdao.getEstadisticasATP(this.getFechaini_test(), this.getFechafin_test());
				ArrayList<ArrayList<Object>> epis = testepidao.getEstadisticasEPI(this.getFechaini_test(), this.getFechafin_test());
				ArrayList<ArrayList<Object>> fles = testfledao.getEstadisticasFLE(this.getFechaini_test(), this.getFechafin_test());		
				generaEstadisticasTest_ATP(atps);
				generaEstadisticasTest_EPI(epis);
				generaEstadisticasTest_FLE(fles);
				this.setEst_test(true);
				this.setChartDataTest(null);
				this.setChartDataAtpRes(null);
				pintaGraficaTestAtp1(null);
				this.setChartDataEpiRes(null);
				pintaGraficaTestEpi(null);
				this.setChartDataFleRes(null);
				pintaGraficaTestFle(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver")+": "+e1.getCause().toString());
				logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString());
			}
	} 
	private void generaEstadisticasTest_ATP(ArrayList<ArrayList<Object>> atps){
		Frequency f_d1 = new Frequency();
		Frequency f_d2 = new Frequency();		
		for(int i=0;i<atps.size();i++){
			f_d1.addValue((Integer)atps.get(i).get(0));
			if(!atps.get(i).get(0).equals(540))// Si la 1 dosis es positiva, no cuenta la segunda - VALIDAR
				f_d2.addValue((Integer)atps.get(i).get(1));			
		}
		this.getTestatp1().clear();
		float total = f_d1.getCount(540)+f_d2.getCount(540)+f_d2.getCount(541)+f_d2.getCount(542)+f_d1.getCount(0)+f_d2.getCount(0);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("testfarma_atp_tab_res_op1"),f_d1.getCount(540),Double.isNaN(f_d1.getPct(540))?0:Math.rint((f_d1.getPct(540)*100)*100)/100,f_d2.getCount(540),Double.isNaN(f_d2.getPct(540))?0:Math.rint((f_d2.getPct(540)*100)*100)/100,f_d1.getCount(540)+f_d2.getCount(540),Double.isNaN(((float)(f_d1.getCount(540)+f_d2.getCount(540))/total))?0:Math.rint((((float)(f_d1.getCount(540)+f_d2.getCount(540))/total)*100)*100)/100);
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("testfarma_atp_tab_res_op2"),f_d1.getCount(541),Double.isNaN(f_d1.getPct(541))?0:Math.rint((f_d1.getPct(541)*100)*100)/100,f_d2.getCount(541),Double.isNaN(f_d2.getPct(541))?0:Math.rint((f_d2.getPct(541)*100)*100)/100,f_d2.getCount(541),Double.isNaN(((float)(f_d2.getCount(541))/total))?0:Math.rint((((float)(f_d2.getCount(541))/total)*100)*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("testfarma_atp_tab_res_op3"),f_d1.getCount(542),Double.isNaN(f_d1.getPct(542))?0:Math.rint((f_d1.getPct(542)*100)*100)/100,f_d2.getCount(542),Double.isNaN(f_d2.getPct(542))?0:Math.rint((f_d2.getPct(542)*100)*100)/100,f_d2.getCount(542),Double.isNaN(((float)(f_d2.getCount(542))/total))?0:Math.rint((((float)(f_d2.getCount(542))/total)*100)*100)/100);
		EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_d1.getCount(0),Double.isNaN(f_d1.getPct(0))?0:Math.rint((f_d1.getPct(0)*100)*100)/100,f_d2.getCount(0),Double.isNaN(f_d2.getPct(0))?0:Math.rint((f_d2.getPct(0)*100)*100)/100,f_d1.getCount(0)+f_d2.getCount(0),Double.isNaN(((float)(f_d1.getCount(0)+f_d2.getCount(0))/total))?0:Math.rint((((float)(f_d1.getCount(0)+f_d2.getCount(0))/total)*100)*100)/100);
		
		//EstadisticasBasicas eb5 = new EstadisticasBasicas("Total",f_d1.getSumFreq(),1*100);
		this.getTestatp1().add(eb3);this.getTestatp1().add(eb1);this.getTestatp1().add(eb2);
		this.getTestatp1().add(eb4);//this.getTestatp1().add(eb5);
		this.setRestest1(String.valueOf(f_d1.getSumFreq()));
		/*this.getTestatp2().clear();
		EstadisticasBasicas eb11 = new EstadisticasBasicas("Dudoso",f_d2.getCount(541),f_d2.getPct(541)*100);
		EstadisticasBasicas eb22 = new EstadisticasBasicas("Negativo",f_d2.getCount(542),f_d2.getPct(542)*100);
		EstadisticasBasicas eb33 = new EstadisticasBasicas("Positivo",f_d2.getCount(540),f_d2.getPct(540)*100);
		EstadisticasBasicas eb44 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_d2.getCount(0),f_d2.getPct(0)*100);
		//EstadisticasBasicas eb55 = new EstadisticasBasicas("Total",f_d2.getSumFreq(),1*100);
		this.getTestatp2().add(eb11);this.getTestatp2().add(eb22);this.getTestatp2().add(eb33);
		this.getTestatp2().add(eb44);//this.getTestatp2().add(eb55);
		this.setRestest1(String.valueOf(f_d2.getSumFreq()));*/
	}
	private void generaEstadisticasTest_EPI(ArrayList<ArrayList<Object>> epis){
		Frequency f_res = new Frequency();		
		for(int i=0;i<epis.size();i++){
			f_res.addValue((Integer)epis.get(i).get(0));			
		}
		this.getTestepi().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("testfarma_epi_res_op1"),f_res.getCount(560),Double.isNaN(f_res.getPct(560))?0:Math.rint((f_res.getPct(560)*100)*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("testfarma_epi_res_op2"),f_res.getCount(561),Double.isNaN(f_res.getPct(561))?0:Math.rint((f_res.getPct(561)*100)*100)/100);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("testfarma_epi_res_op3"),f_res.getCount(559),Double.isNaN(f_res.getPct(559))?0:Math.rint((f_res.getPct(559)*100)*100)/100);
		EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("testfarma_epi_res_op4"),f_res.getCount(562),Double.isNaN(f_res.getPct(562))?0:Math.rint((f_res.getPct(562)*100)*100)/100);
		EstadisticasBasicas eb5 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_res.getCount(0),Double.isNaN(f_res.getPct(0))?0:Math.rint((f_res.getPct(0)*100)*100)/100);
		//EstadisticasBasicas eb6 = new EstadisticasBasicas("Total",f_res.getSumFreq(),1*100);
		this.getTestepi().add(eb4);this.getTestepi().add(eb1);this.getTestepi().add(eb2);
		this.getTestepi().add(eb3);this.getTestepi().add(eb5);//this.getTestepi().add(eb6);
		this.setRestest2(String.valueOf(f_res.getSumFreq()));
	}
	private void generaEstadisticasTest_FLE(ArrayList<ArrayList<Object>> fles){
		Frequency f_res = new Frequency();		
		for(int i=0;i<fles.size();i++){
			f_res.addValue((Integer)fles.get(i).get(0));			
		}
		this.getTestfle().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("testfarma_fle_res_op1"),f_res.getCount(565),Double.isNaN(f_res.getPct(565))?0:Math.rint((f_res.getPct(565)*100)*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("testfarma_fle_res_op2"),f_res.getCount(563),Double.isNaN(f_res.getPct(563))?0:Math.rint((f_res.getPct(563)*100)*100)/100);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("testfarma_fle_res_op3"),f_res.getCount(564),Double.isNaN(f_res.getPct(564))?0:Math.rint((f_res.getPct(564)*100)*100)/100);
		EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_res.getCount(0),Double.isNaN(f_res.getPct(0))?0:Math.rint((f_res.getPct(0)*100)*100)/100);
		//EstadisticasBasicas eb5 = new EstadisticasBasicas("Total",f_res.getSumFreq(),1*100);
		this.getTestfle().add(eb3);this.getTestfle().add(eb1);this.getTestfle().add(eb2);
		this.getTestfle().add(eb4);//this.getTestfle().add(eb5);
		this.setRestest3(String.valueOf(f_res.getSumFreq()));
	}
	public void generarEstadisticasEef(ActionEvent e){
		if(this.getFechaini_eef()==null || this.getFechafin_eef()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_warn_ver"));
		else
			try{
				ArrayList<ArrayList<Object>> eefs = eefdao.getEstadisticasEef(this.getFechaini_eef(), this.getFechafin_eef());
				ArrayList<ArrayList<Object>> eefs_int = eefdao.getEstadisticasEefIntentos(this.getFechaini_eef(), this.getFechafin_eef());
				ArrayList<ArrayList<Object>> eefs_abl = eefdao.getEstadisticasEefAblaciones(this.getFechaini_eef(), this.getFechafin_eef());
				ArrayList<ArrayList<Object>> compEefAbl = compacdao.getComplicacionesTipoProc(1, this.getFechaini_eef(), this.getFechafin_eef());
				ArrayList<ArrayList<Object>> compEefDiag = compacdao.getComplicacionesTipoProc(7, this.getFechaini_eef(), this.getFechafin_eef());
				generaEstadisticasEef(eefs,eefs_int,eefs_abl,compEefDiag,compEefAbl);
				this.setEst_eef(true);
				this.setChartDataEef(null);
				this.setChartDataEefReal(null);
				pintaGraficaEefCar(null);
				this.setChartDataEefDiag(null);
				pintaGraficaEefDiag(null);
				this.setChartDataEefAblNo(null);
				pintaGraficaEefIntento(null);
				this.setChartDataEefSust(null);
				pintaGraficaEefAblSust(null);
				this.setChartDataEefRes(null);
				pintaGraficaEefAblRes(null);
				this.setChartDataEefCompDiag(null);
				pintaGraficaEefCompDiag(null);
				this.setChartDataEefCompAbl(null);
				pintaGraficaEefCompAbl(null);
				this.setChartDataEefCompTipoDiag(null);
				pintaGraficaEefCompTipoDiag(null);
				this.setChartDataEefCompTipoAbl(null);
				pintaGraficaEefCompTipoAbl(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver")+": "+e1.getCause().toString());
				logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString());
			}
	} 
	private void generaEstadisticasEef(ArrayList<ArrayList<Object>> eefs, ArrayList<ArrayList<Object>> eefs_int,
			ArrayList<ArrayList<Object>> eefs_abls, ArrayList<ArrayList<Object>> compEefDiag, ArrayList<ArrayList<Object>> compEefAbl) throws Exception{
		Frequency f_diag = new Frequency();
		Frequency f_proc = new Frequency();
		Frequency f_a = new Frequency();
		Frequency f_comp_diag = new Frequency();
		Frequency f_comp_abl = new Frequency();
		Frequency f_comp_tipo_diag = new Frequency();
		Frequency f_comp_tipo_abl = new Frequency();
		for(int i=0;i<eefs.size();i++){
			if((Integer)eefs.get(i).get(0)!=null)
				f_diag.addValue((Integer)eefs.get(i).get(0));
			if((Integer)eefs.get(i).get(1)!=null)
				f_proc.addValue((Integer)eefs.get(i).get(1));
			if((Integer)eefs.get(i).get(2)!=null)
				f_a.addValue((Integer)eefs.get(i).get(2));
		}
		this.getEefcar().clear();
		EstadisticasBasicas eb01 = new EstadisticasBasicas(this.bundle.getString("eef_estadist_abl_con"),f_a.getCount(2),Double.isNaN(f_a.getPct(2))?0:Math.rint((f_a.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb02 = new EstadisticasBasicas(this.bundle.getString("eef_estadist_abl_inte"),f_a.getCount(1),Double.isNaN(f_a.getPct(1))?0:Math.rint((f_a.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb03 = new EstadisticasBasicas(this.bundle.getString("eef_estadist_abl_sin"),f_a.getCount(0),Double.isNaN(f_a.getPct(0))?0:Math.rint((f_a.getPct(0)*100)*100)/100);
		//EstadisticasBasicas eb04 = new EstadisticasBasicas("Total",f_a.getSumFreq(),100);
		this.getEefcar().add(eb03);this.getEefcar().add(eb02);this.getEefcar().add(eb01);//this.getEefcar().add(eb04);
		this.setReseef1(String.valueOf(f_diag.getSumFreq()));
		this.getEefdiag().clear();
		EstadisticasBasicas eb1 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op28"),f_diag.getCount(28),Double.isNaN(f_diag.getPct(28))?0:Math.rint((f_diag.getPct(28)*100)*100)/100);
		EstadisticasBasicas eb2 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op29"),f_diag.getCount(29),Double.isNaN(f_diag.getPct(29))?0:Math.rint((f_diag.getPct(29)*100)*100)/100);
		EstadisticasBasicas eb3 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op30"),f_diag.getCount(30),Double.isNaN(f_diag.getPct(30))?0:Math.rint((f_diag.getPct(30)*100)*100)/100);
		EstadisticasBasicas eb4 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op31"),f_diag.getCount(31),Double.isNaN(f_diag.getPct(31))?0:Math.rint((f_diag.getPct(31)*100)*100)/100);
		EstadisticasBasicas eb5 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op32"),f_diag.getCount(32),Double.isNaN(f_diag.getPct(32))?0:Math.rint((f_diag.getPct(32)*100)*100)/100);
		EstadisticasBasicas eb6 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op33"),f_diag.getCount(33),Double.isNaN(f_diag.getPct(33))?0:Math.rint((f_diag.getPct(33)*100)*100)/100);
		EstadisticasBasicas eb7 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op881"),f_diag.getCount(881),Double.isNaN(f_diag.getPct(881))?0:Math.rint((f_diag.getPct(881)*100)*100)/100);
		EstadisticasBasicas eb8 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op34"),f_diag.getCount(34),Double.isNaN(f_diag.getPct(34))?0:Math.rint((f_diag.getPct(34)*100)*100)/100);
		EstadisticasBasicas eb9 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op35"),f_diag.getCount(35),Double.isNaN(f_diag.getPct(35))?0:Math.rint((f_diag.getPct(35)*100)*100)/100);
		EstadisticasBasicas eb10 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op36"),f_diag.getCount(36),Double.isNaN(f_diag.getPct(36))?0:Math.rint((f_diag.getPct(36)*100)*100)/100);
		EstadisticasBasicas eb11 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op37"),f_diag.getCount(37),Double.isNaN(f_diag.getPct(37))?0:Math.rint((f_diag.getPct(37)*100)*100)/100);
		EstadisticasBasicas eb12 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_diag.getCount(0),Double.isNaN(f_diag.getPct(0))?0:Math.rint((f_diag.getPct(0)*100)*100)/100);
		EstadisticasBasicas eb13 = new EstadisticasBasicas(this.bundle.getString("eef_diag_op1210"),f_diag.getCount(1210),Double.isNaN(f_diag.getPct(1210))?0:Math.rint((f_diag.getPct(1210)*100)*100)/100);
		this.getEefdiag().add(eb1);this.getEefdiag().add(eb2);this.getEefdiag().add(eb3);this.getEefdiag().add(eb4);
		this.getEefdiag().add(eb5);this.getEefdiag().add(eb6);this.getEefdiag().add(eb7);this.getEefdiag().add(eb8);
		this.getEefdiag().add(eb9);this.getEefdiag().add(eb10);this.getEefdiag().add(eb11);this.getEefdiag().add(eb12);
		this.getEefdiag().add(eb13);
		/*this.getEefproc().clear();
		EstadisticasBasicas eb21 = new EstadisticasBasicas("Diagnóstico",f_proc.getCount(502),f_proc.getPct(502)*100);
		EstadisticasBasicas eb22 = new EstadisticasBasicas("Terapéutico",f_proc.getCount(503),f_proc.getPct(503)*100);
		EstadisticasBasicas eb23 = new EstadisticasBasicas("Diagnóstico/Terapéutico",f_proc.getCount(504),f_proc.getPct(504)*100);
		this.getEefproc().add(eb21);this.getEefproc().add(eb22);this.getEefproc().add(eb23);*/
		// intento ablacion
		Frequency f_int = new Frequency();
		for(int i=0;i<eefs_int.size();i++){
			if((Integer)eefs_int.get(i).get(0)!=null)
				f_int.addValue((Integer)eefs_int.get(i).get(0));
		}
		this.getEefint().clear();
		EstadisticasBasicas eb31 = new EstadisticasBasicas(this.bundle.getString("eef_tab_intabl_op1"),f_int.getCount(1),Double.isNaN(f_int.getPct(1))?0:Math.rint((f_int.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb32 = new EstadisticasBasicas(this.bundle.getString("eef_tab_intabl_op2"),f_int.getCount(2),Double.isNaN(f_int.getPct(2))?0:Math.rint((f_int.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb33 = new EstadisticasBasicas(this.bundle.getString("eef_tab_intabl_op3"),f_int.getCount(3),Double.isNaN(f_int.getPct(3))?0:Math.rint((f_int.getPct(3)*100)*100)/100);
		EstadisticasBasicas eb34 = new EstadisticasBasicas(this.bundle.getString("eef_tab_intabl_op4"),f_int.getCount(4),Double.isNaN(f_int.getPct(4))?0:Math.rint((f_int.getPct(4)*100)*100)/100);
		EstadisticasBasicas eb35 = new EstadisticasBasicas(this.bundle.getString("eef_tab_intabl_op5"),f_int.getCount(5),Double.isNaN(f_int.getPct(5))?0:Math.rint((f_int.getPct(5)*100)*100)/100);
		EstadisticasBasicas eb36 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_int.getCount(0),Double.isNaN(f_int.getPct(0))?0:Math.rint((f_int.getPct(0)*100)*100)/100);
		//EstadisticasBasicas eb37 = new EstadisticasBasicas("Total",f_int.getSumFreq(),1*100);
		this.getEefint().add(eb31);this.getEefint().add(eb32);this.getEefint().add(eb33);this.getEefint().add(eb34);
		this.getEefint().add(eb35);this.getEefint().add(eb36);//this.getEefint().add(eb37);
		// ablaciones realizadas
		Frequency f_sust = new Frequency();
		Frequency f_res = new Frequency();
		Frequency f_abls = new Frequency();
		for(int i=0;i<eefs_abls.size();i++){
			if((Integer)eefs_abls.get(i).get(0)!=null)
				f_sust.addValue((Integer)eefs_abls.get(i).get(0));
			if((Integer)eefs_abls.get(i).get(1)!=null)
				f_res.addValue((Integer)eefs_abls.get(i).get(1));
			if((Integer)eefs_abls.get(i).get(2)!=null)
				f_abls.addValue((Integer)eefs_abls.get(i).get(2));
		}
		//this.setReseef5(String.valueOf(f_abls.getSumFreq()));
		this.getEefablsust().clear();
		EstadisticasBasicas eb41 = new EstadisticasBasicas(this.bundle.getString("eef_abl_sust_1"),f_sust.getCount(1),Double.isNaN(f_sust.getPct(1))?0:Math.rint((f_sust.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb42 = new EstadisticasBasicas(this.bundle.getString("eef_abl_sust_2"),f_sust.getCount(2),Double.isNaN(f_sust.getPct(2))?0:Math.rint((f_sust.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb43 = new EstadisticasBasicas(this.bundle.getString("eef_abl_sust_3"),f_sust.getCount(3),Double.isNaN(f_sust.getPct(3))?0:Math.rint((f_sust.getPct(3)*100)*100)/100);
		EstadisticasBasicas eb44 = new EstadisticasBasicas(this.bundle.getString("eef_abl_sust_4"),f_sust.getCount(4),Double.isNaN(f_sust.getPct(4))?0:Math.rint((f_sust.getPct(4)*100)*100)/100);
		EstadisticasBasicas eb45 = new EstadisticasBasicas(this.bundle.getString("eef_abl_sust_5"),f_sust.getCount(5),Double.isNaN(f_sust.getPct(5))?0:Math.rint((f_sust.getPct(5)*100)*100)/100);
		EstadisticasBasicas eb46 = new EstadisticasBasicas(this.bundle.getString("eef_abl_sust_6"),f_sust.getCount(6),Double.isNaN(f_sust.getPct(6))?0:Math.rint((f_sust.getPct(6)*100)*100)/100);
		EstadisticasBasicas eb47 = new EstadisticasBasicas(this.bundle.getString("eef_abl_sust_7"),f_sust.getCount(7),Double.isNaN(f_sust.getPct(7))?0:Math.rint((f_sust.getPct(7)*100)*100)/100);
		EstadisticasBasicas eb48 = new EstadisticasBasicas(this.bundle.getString("eef_abl_sust_8"),f_sust.getCount(8),Double.isNaN(f_sust.getPct(8))?0:Math.rint((f_sust.getPct(8)*100)*100)/100);
		EstadisticasBasicas eb49 = new EstadisticasBasicas(this.bundle.getString("eef_abl_sust_9"),f_sust.getCount(9),Double.isNaN(f_sust.getPct(9))?0:Math.rint((f_sust.getPct(9)*100)*100)/100);
		EstadisticasBasicas eb40 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_sust.getCount(0),Double.isNaN(f_sust.getPct(0))?0:Math.rint((f_sust.getPct(0)*100)*100)/100);
		this.getEefablsust().add(eb41);this.getEefablsust().add(eb42);this.getEefablsust().add(eb43);this.getEefablsust().add(eb44);
		this.getEefablsust().add(eb45);this.getEefablsust().add(eb46);this.getEefablsust().add(eb47);this.getEefablsust().add(eb48);
		this.getEefablsust().add(eb49);this.getEefablsust().add(eb40);
		this.getEefablres().clear();
		EstadisticasBasicas eb51 = new EstadisticasBasicas(this.bundle.getString("eef_tab_abl_tab_res_op1"),f_res.getCount(1),Double.isNaN(f_res.getPct(1))?0:Math.rint((f_res.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb52 = new EstadisticasBasicas(this.bundle.getString("eef_tab_abl_tab_res_op2"),f_res.getCount(2),Double.isNaN(f_res.getPct(2))?0:Math.rint((f_res.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb53 = new EstadisticasBasicas(this.bundle.getString("eef_tab_abl_tab_res_op3"),f_res.getCount(3),Double.isNaN(f_res.getPct(3))?0:Math.rint((f_res.getPct(3)*100)*100)/100);
		EstadisticasBasicas eb54 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_res.getCount(0),Double.isNaN(f_res.getPct(0))?0:Math.rint((f_res.getPct(0)*100)*100)/100);
		this.getEefablres().add(eb51);this.getEefablres().add(eb53);this.getEefablres().add(eb52);this.getEefablres().add(eb54);
		// GESTION COMPLICACIONES 
		// 1. DIAGNOSTICAS
		for(int i=0;i<compEefDiag.size();i++){
			if((Integer)compEefDiag.get(i).get(0)!=null)
				f_comp_diag.addValue((Integer)compEefDiag.get(i).get(0));
			if((Integer)compEefDiag.get(i).get(1)!=null)
				f_comp_tipo_diag.addValue((Integer)compEefDiag.get(i).get(1));
		}
		this.getEefcompdiag().clear();
		//Complicaciones[] comps = compdao.findWhereAmbitoEquals(2);
		Complicaciones[] comps = compdao.findByDynamicWhere("AMBITO = ? OR AMBITO = ?", new Object[]{0,2});
		for(int i=0;i<comps.length;i++){
			if(comps[i].getNombre()!=null){
				EstadisticasBasicas item = new EstadisticasBasicas(comps[i].getNombre(),f_comp_diag.getCount(comps[i].getIdcomplicacion()),Double.isNaN(f_comp_diag.getPct(comps[i].getIdcomplicacion()))?0:Math.rint((f_comp_diag.getPct(comps[i].getIdcomplicacion())*100)*100)/100  );
				this.eefcompdiag.add(item);
			}	
		}
		EstadisticasBasicas ebCompDiag0 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_comp_tipo_diag.getCount(0),Double.isNaN(f_comp_tipo_diag.getPct(0))?0:Math.rint((f_comp_tipo_diag.getPct(0)*100)*100)/100);
		EstadisticasBasicas ebCompDiag1 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_1"),f_comp_tipo_diag.getCount(1),Double.isNaN(f_comp_tipo_diag.getPct(1))?0:Math.rint((f_comp_tipo_diag.getPct(1)*100)*100)/100);
		EstadisticasBasicas ebCompDiag2 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_2"),f_comp_tipo_diag.getCount(2),Double.isNaN(f_comp_tipo_diag.getPct(2))?0:Math.rint((f_comp_tipo_diag.getPct(2)*100)*100)/100);
		EstadisticasBasicas ebCompDiag3 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_3"),f_comp_tipo_diag.getCount(3),Double.isNaN(f_comp_tipo_diag.getPct(3))?0:Math.rint((f_comp_tipo_diag.getPct(3)*100)*100)/100);
		this.getEefcompdiagtipo().add(ebCompDiag0);this.getEefcompdiagtipo().add(ebCompDiag1);this.getEefcompdiagtipo().add(ebCompDiag2);this.getEefcompdiagtipo().add(ebCompDiag3);
		// 2. ABLACION
		for(int i=0;i<compEefAbl.size();i++){
			if((Integer)compEefAbl.get(i).get(0)!=null)
				f_comp_abl.addValue((Integer)compEefAbl.get(i).get(0));
			if((Integer)compEefAbl.get(i).get(1)!=null)
				f_comp_tipo_abl.addValue((Integer)compEefAbl.get(i).get(1));
		}
		this.getEefcompabl().clear();
		//comps = compdao.findWhereAmbitoEquals(1); 
		compdao.findByDynamicWhere("AMBITO = ? OR AMBITO = ?", new Object[]{0,1});
		for(int i=0;i<comps.length;i++){
			if(comps[i].getNombre()!=null){
				EstadisticasBasicas item = new EstadisticasBasicas(comps[i].getNombre(),f_comp_abl.getCount(comps[i].getIdcomplicacion()),Double.isNaN(f_comp_abl.getPct(comps[i].getIdcomplicacion()))?0:Math.rint((f_comp_abl.getPct(comps[i].getIdcomplicacion())*100)*100)/100  );
				this.eefcompabl.add(item);
			}	
		}
		EstadisticasBasicas ebCompAbl0 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_comp_tipo_abl.getCount(0),Double.isNaN(f_comp_tipo_abl.getPct(0))?0:Math.rint((f_comp_tipo_abl.getPct(0)*100)*100)/100);
		EstadisticasBasicas ebCompAbl1 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_1"),f_comp_tipo_abl.getCount(1),Double.isNaN(f_comp_tipo_abl.getPct(1))?0:Math.rint((f_comp_tipo_abl.getPct(1)*100)*100)/100);
		EstadisticasBasicas ebCompAbl2 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_2"),f_comp_tipo_abl.getCount(2),Double.isNaN(f_comp_tipo_abl.getPct(2))?0:Math.rint((f_comp_tipo_abl.getPct(2)*100)*100)/100);
		EstadisticasBasicas ebCompAbl3 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_3"),f_comp_tipo_abl.getCount(3),Double.isNaN(f_comp_tipo_abl.getPct(3))?0:Math.rint((f_comp_tipo_abl.getPct(3)*100)*100)/100);
		this.getEefcompabltipo().add(ebCompAbl0);this.getEefcompabltipo().add(ebCompAbl1);this.getEefcompabltipo().add(ebCompAbl2);this.getEefcompabltipo().add(ebCompAbl3);
	}
	public void generarEstadisticasImplantes(ActionEvent e){
		if(this.getFechaini_imp()==null || this.getFechafin_imp()==null)
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_warn_ver"));
		else
			try{
				ArrayList<ArrayList<Object>> impls = impdao.getEstadisticasImplantes(this.getFechaini_imp(), this.getFechafin_imp());
				ArrayList<ArrayList<Object>> segs = procdao.getNumtotalSeguimientos(this.getFechaini_imp(), this.getFechafin_imp());				
				ArrayList<ArrayList<Object>> compImp = compacdao.getComplicacionesTipoProc(2, this.getFechaini_imp(), this.getFechafin_imp());
				generaEstadisticasImplantes(impls,compImp);
				estGenSeguimientosDisp(segs);
				this.setEst_imp(true);
				this.setChartDataImpDisp(null);
				this.setChartDataImpProc(null);
				this.setChartDataImpSegDisp(null);
				this.setChartDataImpBeFabTipo(null);
				this.setChartDataImpBeTipoFab(null);
				this.setChartDataImpAeFabTipo(null);
				this.setChartImpAeTipoFab(null);
				this.setChartDataImpRitmo(null);
				this.setChartDataImpCav(null);
				this.setChartDataImpQrs(null);
				this.setChartDataImpComp(null);
				this.setChartDataImpCompTipo(null);
				
				pintaGraficaImpProcsDisp(null);
				pintaGraficaImpProcsTipo(null);
				pintaGraficaImpReintProcsDisp(null);
				pintaGraficaImpReintProcsTipo(null);
				pintaGraficaGenSegs(null);
				pintaGraficaImpBeFab(null);
				pintaGraficaImpBeFab2(null);
				pintaGraficaImpAeFab(null);
				pintaGraficaImpAeFab2(null);
				pintaGraficaImpRitmo(null);
				pintaGraficaImpQrs(null);
				pintaGraficaImpCav(null);
				pintaGraficaImpComp(null);
				pintaGraficaImpCompTipo(null);
				
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver")+": "+e1.getCause().toString());
				logger.error("Error al generar estadísticas. Motivo: "+e1.getCause().toString());
			}
	} 
	private void generaEstadisticasImplantes(ArrayList<ArrayList<Object>> impls, ArrayList<ArrayList<Object>> comp) throws Exception{
		Frequency f_mp_proc = new Frequency();
		Frequency f_mp_proc_r = new Frequency();
		Frequency f_dai_proc = new Frequency();
		Frequency f_dai_proc_r = new Frequency();
		Frequency f_crtp_proc = new Frequency();
		Frequency f_crtp_proc_r = new Frequency();
		Frequency f_crtd_proc = new Frequency();
		Frequency f_crtd_proc_r = new Frequency();
		Frequency f_tipo_sg_ae = new Frequency();
		Frequency f_tipo_md_ae = new Frequency();
		Frequency f_tipo_sj_ae = new Frequency();
		Frequency f_tipo_bs_ae = new Frequency();
		Frequency f_tipo_bi_ae = new Frequency();
		Frequency f_tipo_vi_ae = new Frequency();
		Frequency f_tipo_sg_be = new Frequency();
		Frequency f_tipo_md_be = new Frequency();
		Frequency f_tipo_sj_be = new Frequency();
		Frequency f_tipo_bs_be = new Frequency();
		Frequency f_tipo_bi_be = new Frequency();
		Frequency f_tipo_vi_be = new Frequency();
		
		Frequency f_tipo_desc_be = new Frequency();
		Frequency f_tipo_desc_ae = new Frequency();
		
		Frequency f_ritmo = new Frequency();
		Frequency f_qrs = new Frequency();
		Frequency f_cav = new Frequency();
		
		Frequency f_comp = new Frequency();
		Frequency f_comp_tipo = new Frequency();
		
		Integer tipoProc = null;
		for(int i=0;i<impls.size();i++){
			tipoProc = (Integer)impls.get(i).get(0);
			if(impls.get(i).get(3)!=null && (impls.get(i).get(3).equals("1") || impls.get(i).get(3).equals("3") || impls.get(i).get(3).equals("5"))){
				if(tipoProc.equals(956) || tipoProc.equals(1059) || tipoProc.equals(1060) || tipoProc.equals(1090)){
					if(impls.get(i).get(3).equals("1") || impls.get(i).get(3).equals("5"))
						f_mp_proc.addValue((Integer)impls.get(i).get(0));
					else
						f_crtp_proc.addValue((Integer)impls.get(i).get(0));
					if(impls.get(i).get(2).equals("SORIN GROUP"))
						f_tipo_sg_be.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("MEDTRONIC"))
						f_tipo_md_be.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("SAINT JUDE"))
						f_tipo_sj_be.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("BOSTON SCIENTIFIC")||impls.get(i).get(2).equals("GUIDANT"))
						f_tipo_bs_be.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("BIOTRONIK"))
						f_tipo_bi_be.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("DESCONOCIDO"))
						f_tipo_desc_be.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("VITATRON"))
						f_tipo_vi_be.addValue((String)impls.get(i).get(1));
				}else{
					if(impls.get(i).get(3).equals("1") || impls.get(i).get(3).equals("5"))
						f_mp_proc_r.addValue((Integer)impls.get(i).get(0));
					else
						f_crtp_proc_r.addValue((Integer)impls.get(i).get(0));
				}
			}else if(impls.get(i).get(3)!=null && (impls.get(i).get(3).equals("2") || impls.get(i).get(3).equals("4") || impls.get(i).get(3).equals("6"))){
				if(tipoProc.equals(956) || tipoProc.equals(1059) || tipoProc.equals(1060) || tipoProc.equals(1090)){
					if(impls.get(i).get(3).equals("2") || impls.get(i).get(3).equals("6"))
						f_dai_proc.addValue((Integer)impls.get(i).get(0));
					else
						f_crtd_proc.addValue((Integer)impls.get(i).get(0));
					if(impls.get(i).get(2).equals("SORIN GROUP"))
						f_tipo_sg_ae.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("MEDTRONIC"))
						f_tipo_md_ae.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("SAINT JUDE"))
						f_tipo_sj_ae.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("BOSTON SCIENTIFIC")||impls.get(i).get(2).equals("GUIDANT"))
						f_tipo_bs_ae.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("BIOTRONIK"))
						f_tipo_bi_ae.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("DESCONOCIDO"))
						f_tipo_desc_ae.addValue((String)impls.get(i).get(1));
					else if(impls.get(i).get(2).equals("VITATRON"))
						f_tipo_vi_ae.addValue((String)impls.get(i).get(1));
				}else{
					if(impls.get(i).get(3).equals("2") || impls.get(i).get(3).equals("6"))
						f_dai_proc_r.addValue((Integer)impls.get(i).get(0));
					else
						f_crtd_proc_r.addValue((Integer)impls.get(i).get(0));
				}
			}
			if(impls.get(i).get(4)!=null)
				f_ritmo.addValue((Integer)impls.get(i).get(4));
			if(impls.get(i).get(5)!=null)
				f_cav.addValue((Integer)impls.get(i).get(5));
			if(impls.get(i).get(6)!=null)
				f_qrs.addValue((Integer)impls.get(i).get(6));		
		}
		this.getImpproc().clear();
		long totalprocs = f_mp_proc.getCount(956)+f_dai_proc.getCount(956)+f_crtp_proc.getCount(956)+f_crtd_proc.getCount(956)
				+f_mp_proc.getCount(1059)+f_dai_proc.getCount(1059)+f_crtp_proc.getCount(1059)+f_crtd_proc.getCount(1059)
				+f_mp_proc.getCount(1060)+f_dai_proc.getCount(1060)+f_crtp_proc.getCount(1060)+f_crtd_proc.getCount(1060)
				+f_mp_proc.getCount(1090)+f_dai_proc.getCount(1090)+f_crtp_proc.getCount(1090)+f_crtd_proc.getCount(1090)
				+f_mp_proc.getCount(1085)+f_dai_proc.getCount(1085)+f_crtp_proc.getCount(1085)+f_crtd_proc.getCount(1085)
				+f_mp_proc.getCount(1086)+f_dai_proc.getCount(1086)+f_crtp_proc.getCount(1086)+f_crtd_proc.getCount(1086)
				+f_mp_proc.getCount(957)+f_dai_proc.getCount(957)+f_crtp_proc.getCount(957)+f_crtd_proc.getCount(957)
				+f_mp_proc.getCount(1147)+f_dai_proc.getCount(1147)+f_crtp_proc.getCount(1147)+f_crtd_proc.getCount(1147);
		long totalprocsImpl = f_mp_proc.getCount(956)+f_dai_proc.getCount(956)+f_crtp_proc.getCount(956)+f_crtd_proc.getCount(956)
				+f_mp_proc.getCount(1059)+f_dai_proc.getCount(1059)+f_crtp_proc.getCount(1059)+f_crtd_proc.getCount(1059)
				+f_mp_proc.getCount(1060)+f_dai_proc.getCount(1060)+f_crtp_proc.getCount(1060)+f_crtd_proc.getCount(1060)
				+f_mp_proc.getCount(1090)+f_dai_proc.getCount(1090)+f_crtp_proc.getCount(1090)+f_crtd_proc.getCount(1090);
		long totalprocsReint = f_mp_proc.getCount(1085)+f_dai_proc.getCount(1085)+f_crtp_proc.getCount(1085)+f_crtd_proc.getCount(1085)
				+f_mp_proc.getCount(1086)+f_dai_proc.getCount(1086)+f_crtp_proc.getCount(1086)+f_crtd_proc.getCount(1086)
				+f_mp_proc.getCount(957)+f_dai_proc.getCount(957)+f_crtp_proc.getCount(957)+f_crtd_proc.getCount(957)
				+f_mp_proc.getCount(1147)+f_dai_proc.getCount(1147)+f_crtp_proc.getCount(1147)+f_crtd_proc.getCount(1147);
		
		float p_prim = (float)(f_mp_proc.getCount(956)+f_dai_proc.getCount(956)+f_crtp_proc.getCount(956)+f_crtd_proc.getCount(956))/(float)totalprocs;
		float p_rec = (float)(f_mp_proc.getCount(1059)+f_dai_proc.getCount(1059)+f_crtp_proc.getCount(1059)+f_crtd_proc.getCount(1059))/(float)totalprocs;
		float p_upg = (float)(f_mp_proc.getCount(1060)+f_dai_proc.getCount(1060)+f_crtp_proc.getCount(1060)+f_crtd_proc.getCount(1060))/(float)totalprocs;
		float p_reimp = (float)(f_mp_proc.getCount(1090)+f_dai_proc.getCount(1090)+f_crtp_proc.getCount(1090)+f_crtd_proc.getCount(1090))/(float)totalprocs;
		float p_reint = (float)(f_mp_proc.getCount(957)+f_dai_proc.getCount(957)+f_crtp_proc.getCount(957)+f_crtd_proc.getCount(957))/(float)totalprocs;
		float p_recgen = (float)(f_mp_proc.getCount(1085)+f_dai_proc.getCount(1085)+f_crtp_proc.getCount(1085)+f_crtd_proc.getCount(1085))/(float)totalprocs;
		float p_recele = (float)(f_mp_proc.getCount(1086)+f_dai_proc.getCount(1086)+f_crtp_proc.getCount(1086)+f_crtd_proc.getCount(1086))/(float)totalprocs;
		float p_expl = (float)(f_mp_proc.getCount(1147)+f_dai_proc.getCount(1147)+f_crtp_proc.getCount(1147)+f_crtd_proc.getCount(1147))/(float)totalprocs;
		
		float p_prim_imp = (float)(f_mp_proc.getCount(956)+f_dai_proc.getCount(956)+f_crtp_proc.getCount(956)+f_crtd_proc.getCount(956))/(float)totalprocsImpl;
		float p_rec_imp = (float)(f_mp_proc.getCount(1059)+f_dai_proc.getCount(1059)+f_crtp_proc.getCount(1059)+f_crtd_proc.getCount(1059))/(float)totalprocsImpl;
		float p_upg_imp = (float)(f_mp_proc.getCount(1060)+f_dai_proc.getCount(1060)+f_crtp_proc.getCount(1060)+f_crtd_proc.getCount(1060))/(float)totalprocsImpl;
		float p_reimp_imp = (float)(f_mp_proc.getCount(1090)+f_dai_proc.getCount(1090)+f_crtp_proc.getCount(1090)+f_crtd_proc.getCount(1090))/(float)totalprocsImpl;
		
		float p_reint_r = (float)(f_mp_proc.getCount(957)+f_dai_proc.getCount(957)+f_crtp_proc.getCount(957)+f_crtd_proc.getCount(957))/(float)totalprocsReint;
		float p_recgen_r = (float)(f_mp_proc.getCount(1085)+f_dai_proc.getCount(1085)+f_crtp_proc.getCount(1085)+f_crtd_proc.getCount(1085))/(float)totalprocsReint;
		float p_recele_r = (float)(f_mp_proc.getCount(1086)+f_dai_proc.getCount(1086)+f_crtp_proc.getCount(1086)+f_crtd_proc.getCount(1086))/(float)totalprocsReint;
		float p_expl_r = (float)(f_mp_proc.getCount(1147)+f_dai_proc.getCount(1147)+f_crtp_proc.getCount(1147)+f_crtd_proc.getCount(1147))/(float)totalprocsReint;
		
		/*
		EstadisticasBasicas eb01 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_1"),f_mp_proc.getCount(956),Double.isNaN(f_mp_proc.getPct(956))?0:Math.rint((f_mp_proc.getPct(956)*100)*100)/100,f_mp_proc.getCount(1059),Double.isNaN(f_mp_proc.getPct(1059))?0:Math.rint((f_mp_proc.getPct(1059)*100)*100)/100,f_mp_proc.getCount(1060),Double.isNaN(f_mp_proc.getPct(1060))?0:Math.rint((f_mp_proc.getPct(1060)*100)*100)/100,f_mp_proc.getCount(1090),Double.isNaN(f_mp_proc.getPct(1090))?0:Math.rint((f_mp_proc.getPct(1090)*100)*100)/100,f_mp_proc.getCount(1147),Double.isNaN(f_mp_proc.getPct(1147))?0:Math.rint((f_mp_proc.getPct(1147)*100)*100)/100,f_mp_proc.getCount(1085),Double.isNaN(f_mp_proc.getPct(1085))?0:Math.rint((f_mp_proc.getPct(1085)*100)*100)/100,f_mp_proc.getCount(1086),Double.isNaN(f_mp_proc.getPct(1086))?0:Math.rint((f_mp_proc.getPct(1086)*100)*100)/100,f_mp_proc.getCount(957),Double.isNaN(f_mp_proc.getPct(957))?0:Math.rint((f_mp_proc.getPct(957)*100)*100)/100,f_mp_proc.getCount(956)+f_mp_proc.getCount(1059)+f_mp_proc.getCount(1060)+f_mp_proc.getCount(1090)+f_mp_proc.getCount(1085)+f_mp_proc.getCount(1086)+f_mp_proc.getCount(1147)+f_mp_proc.getCount(957),0);
		EstadisticasBasicas eb02 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_2"),f_dai_proc.getCount(956),Double.isNaN(f_dai_proc.getPct(956))?0:Math.rint((f_dai_proc.getPct(956)*100)*100)/100,f_dai_proc.getCount(1059),Double.isNaN(f_dai_proc.getPct(1059))?0:Math.rint((f_dai_proc.getPct(1059)*100)*100)/100,f_dai_proc.getCount(1060),Double.isNaN(f_dai_proc.getPct(1060))?0:Math.rint((f_dai_proc.getPct(1060)*100)*100)/100,f_dai_proc.getCount(1090),Double.isNaN(f_dai_proc.getPct(1090))?0:Math.rint((f_dai_proc.getPct(1090)*100)*100)/100,f_dai_proc.getCount(1147),Double.isNaN(f_dai_proc.getPct(1147))?0:Math.rint((f_dai_proc.getPct(1147)*100)*100)/100,f_dai_proc.getCount(1085),Double.isNaN(f_dai_proc.getPct(1085))?0:Math.rint((f_dai_proc.getPct(1085)*100)*100)/100,f_dai_proc.getCount(1086),Double.isNaN(f_dai_proc.getPct(1086))?0:Math.rint((f_dai_proc.getPct(1086)*100)*100)/100,f_dai_proc.getCount(957),Double.isNaN(f_dai_proc.getPct(957))?0:Math.rint((f_dai_proc.getPct(957)*100)*100)/100,f_dai_proc.getCount(956)+f_dai_proc.getCount(1059)+f_dai_proc.getCount(1060)+f_dai_proc.getCount(1090)+f_dai_proc.getCount(1085)+f_dai_proc.getCount(1086)+f_dai_proc.getCount(1147)+f_dai_proc.getCount(957),0);
		EstadisticasBasicas eb03 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_3"),f_crtp_proc.getCount(956),Double.isNaN(f_crtp_proc.getPct(956))?0:Math.rint((f_crtp_proc.getPct(956)*100)*100)/100,f_crtp_proc.getCount(1059),Double.isNaN(f_crtp_proc.getPct(1059))?0:Math.rint((f_crtp_proc.getPct(1059)*100)*100)/100,f_crtp_proc.getCount(1060),Double.isNaN(f_crtp_proc.getPct(1060))?0:Math.rint((f_crtp_proc.getPct(1060)*100)*100)/100,f_crtp_proc.getCount(1090),Double.isNaN(f_crtp_proc.getPct(1090))?0:Math.rint((f_crtp_proc.getPct(1090)*100)*100)/100,f_crtp_proc.getCount(1147),Double.isNaN(f_crtp_proc.getPct(1147))?0:Math.rint((f_crtp_proc.getPct(1147)*100)*100)/100,f_crtp_proc.getCount(1085),Double.isNaN(f_crtp_proc.getPct(1085))?0:Math.rint((f_crtp_proc.getPct(1085)*100)*100)/100,f_crtp_proc.getCount(1086),Double.isNaN(f_crtp_proc.getPct(1086))?0:Math.rint((f_crtp_proc.getPct(1086)*100)*100)/100,f_crtp_proc.getCount(957),Double.isNaN(f_crtp_proc.getPct(957))?0:Math.rint((f_crtp_proc.getPct(957)*100)*100)/100,f_crtp_proc.getCount(956)+f_crtp_proc.getCount(1059)+f_crtp_proc.getCount(1060)+f_crtp_proc.getCount(1090)+f_crtp_proc.getCount(1085)+f_crtp_proc.getCount(1086)+f_crtp_proc.getCount(1147)+f_crtp_proc.getCount(957),0);
		EstadisticasBasicas eb04 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_4"),f_crtd_proc.getCount(956),Double.isNaN(f_crtd_proc.getPct(956))?0:Math.rint((f_crtd_proc.getPct(956)*100)*100)/100,f_crtd_proc.getCount(1059),Double.isNaN(f_crtd_proc.getPct(1059))?0:Math.rint((f_crtd_proc.getPct(1059)*100)*100)/100,f_crtd_proc.getCount(1060),Double.isNaN(f_crtd_proc.getPct(1060))?0:Math.rint((f_crtd_proc.getPct(1060)*100)*100)/100,f_crtd_proc.getCount(1090),Double.isNaN(f_crtd_proc.getPct(1090))?0:Math.rint((f_crtd_proc.getPct(1090)*100)*100)/100,f_crtd_proc.getCount(1147),Double.isNaN(f_crtd_proc.getPct(1147))?0:Math.rint((f_crtd_proc.getPct(1147)*100)*100)/100,f_crtd_proc.getCount(1085),Double.isNaN(f_crtd_proc.getPct(1085))?0:Math.rint((f_crtd_proc.getPct(1085)*100)*100)/100,f_crtd_proc.getCount(1086),Double.isNaN(f_crtd_proc.getPct(1086))?0:Math.rint((f_crtd_proc.getPct(1086)*100)*100)/100,f_crtd_proc.getCount(957),Double.isNaN(f_crtd_proc.getPct(957))?0:Math.rint((f_crtd_proc.getPct(957)*100)*100)/100,f_crtd_proc.getCount(956)+f_crtd_proc.getCount(1059)+f_crtd_proc.getCount(1060)+f_crtd_proc.getCount(1090)+f_crtd_proc.getCount(1085)+f_crtd_proc.getCount(1086)+f_crtd_proc.getCount(1147)+f_crtd_proc.getCount(957),0);
		EstadisticasBasicas eb05 = new EstadisticasBasicas(this.bundle.getString("est_basic_total"),f_mp_proc.getCount(956)+f_dai_proc.getCount(956)+f_crtp_proc.getCount(956)+f_crtd_proc.getCount(956),Double.isNaN(p_prim)?0:Math.rint((p_prim*100)*100)/100,f_mp_proc.getCount(1059)+f_dai_proc.getCount(1059)+f_crtp_proc.getCount(1059)+f_crtd_proc.getCount(1059),Double.isNaN(p_rec)?0:Math.rint((p_rec*100)*100)/100,f_mp_proc.getCount(1060)+f_dai_proc.getCount(1060)+f_crtp_proc.getCount(1060)+f_crtd_proc.getCount(1060),Double.isNaN(p_upg)?0:Math.rint((p_upg*100)*100)/100, f_mp_proc.getCount(1090)+f_dai_proc.getCount(1090)+f_crtp_proc.getCount(1090)+f_crtd_proc.getCount(1090),Double.isNaN(p_reimp)?0:Math.rint((p_reimp*100)*100)/100, f_mp_proc.getCount(1147)+f_dai_proc.getCount(1147)+f_crtp_proc.getCount(1147)+f_crtd_proc.getCount(1147),Double.isNaN(p_expl)?0:Math.rint((p_expl*100)*100)/100, f_mp_proc.getCount(1085)+f_dai_proc.getCount(1085)+f_crtp_proc.getCount(1085)+f_crtd_proc.getCount(1085),Double.isNaN(p_recgen)?0:Math.rint((p_recgen*100)*100)/100, f_mp_proc.getCount(1086)+f_dai_proc.getCount(1086)+f_crtp_proc.getCount(1086)+f_crtd_proc.getCount(1086),Double.isNaN(p_recele)?0:Math.rint((p_recele*100)*100)/100,  f_mp_proc.getCount(957)+f_dai_proc.getCount(957)+f_crtp_proc.getCount(957)+f_crtd_proc.getCount(957),Double.isNaN(p_reint)?0:Math.rint((p_reint*100)*100)/100,totalprocs,0);
		*/
		EstadisticasBasicas eb01 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_1"),f_mp_proc.getCount(956),Double.isNaN(f_mp_proc.getPct(956))?0:Math.rint((f_mp_proc.getPct(956)*100)*100)/100,f_mp_proc.getCount(1059),Double.isNaN(f_mp_proc.getPct(1059))?0:Math.rint((f_mp_proc.getPct(1059)*100)*100)/100,f_mp_proc.getCount(1060),Double.isNaN(f_mp_proc.getPct(1060))?0:Math.rint((f_mp_proc.getPct(1060)*100)*100)/100,f_mp_proc.getCount(1090),Double.isNaN(f_mp_proc.getPct(1090))?0:Math.rint((f_mp_proc.getPct(1090)*100)*100)/100, f_mp_proc.getCount(956)+f_mp_proc.getCount(1059)+f_mp_proc.getCount(1060)+f_mp_proc.getCount(1090),0);
		EstadisticasBasicas eb02 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_2"),f_dai_proc.getCount(956),Double.isNaN(f_dai_proc.getPct(956))?0:Math.rint((f_dai_proc.getPct(956)*100)*100)/100,f_dai_proc.getCount(1059),Double.isNaN(f_dai_proc.getPct(1059))?0:Math.rint((f_dai_proc.getPct(1059)*100)*100)/100,f_dai_proc.getCount(1060),Double.isNaN(f_dai_proc.getPct(1060))?0:Math.rint((f_dai_proc.getPct(1060)*100)*100)/100,f_dai_proc.getCount(1090),Double.isNaN(f_dai_proc.getPct(1090))?0:Math.rint((f_dai_proc.getPct(1090)*100)*100)/100, f_dai_proc.getCount(956)+f_dai_proc.getCount(1059)+f_dai_proc.getCount(1060)+f_dai_proc.getCount(1090),0);
		EstadisticasBasicas eb03 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_3"),f_crtp_proc.getCount(956),Double.isNaN(f_crtp_proc.getPct(956))?0:Math.rint((f_crtp_proc.getPct(956)*100)*100)/100,f_crtp_proc.getCount(1059),Double.isNaN(f_crtp_proc.getPct(1059))?0:Math.rint((f_crtp_proc.getPct(1059)*100)*100)/100,f_crtp_proc.getCount(1060),Double.isNaN(f_crtp_proc.getPct(1060))?0:Math.rint((f_crtp_proc.getPct(1060)*100)*100)/100,f_crtp_proc.getCount(1090),Double.isNaN(f_crtp_proc.getPct(1090))?0:Math.rint((f_crtp_proc.getPct(1090)*100)*100)/100, f_crtp_proc.getCount(956)+f_crtp_proc.getCount(1059)+f_crtp_proc.getCount(1060)+f_crtp_proc.getCount(1090),0);
		EstadisticasBasicas eb04 = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_4"),f_crtd_proc.getCount(956),Double.isNaN(f_crtd_proc.getPct(956))?0:Math.rint((f_crtd_proc.getPct(956)*100)*100)/100,f_crtd_proc.getCount(1059),Double.isNaN(f_crtd_proc.getPct(1059))?0:Math.rint((f_crtd_proc.getPct(1059)*100)*100)/100,f_crtd_proc.getCount(1060),Double.isNaN(f_crtd_proc.getPct(1060))?0:Math.rint((f_crtd_proc.getPct(1060)*100)*100)/100,f_crtd_proc.getCount(1090),Double.isNaN(f_crtd_proc.getPct(1090))?0:Math.rint((f_crtd_proc.getPct(1090)*100)*100)/100, f_crtd_proc.getCount(956)+f_crtd_proc.getCount(1059)+f_crtd_proc.getCount(1060)+f_crtd_proc.getCount(1090),0);
		EstadisticasBasicas eb05 = new EstadisticasBasicas(this.bundle.getString("est_basic_total"),f_mp_proc.getCount(956)+f_dai_proc.getCount(956)+f_crtp_proc.getCount(956)+f_crtd_proc.getCount(956),Double.isNaN(p_prim_imp)?0:Math.rint((p_prim_imp*100)*100)/100,f_mp_proc.getCount(1059)+f_dai_proc.getCount(1059)+f_crtp_proc.getCount(1059)+f_crtd_proc.getCount(1059),Double.isNaN(p_rec_imp)?0:Math.rint((p_rec_imp*100)*100)/100,f_mp_proc.getCount(1060)+f_dai_proc.getCount(1060)+f_crtp_proc.getCount(1060)+f_crtd_proc.getCount(1060),Double.isNaN(p_upg_imp)?0:Math.rint((p_upg_imp*100)*100)/100, f_mp_proc.getCount(1090)+f_dai_proc.getCount(1090)+f_crtp_proc.getCount(1090)+f_crtd_proc.getCount(1090),Double.isNaN(p_reimp_imp)?0:Math.rint((p_reimp_imp*100)*100)/100,totalprocsImpl,0);
		
		EstadisticasBasicas eb01r = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_1"),f_mp_proc_r.getCount(957),Double.isNaN(f_mp_proc_r.getPct(957))?0:Math.rint((f_mp_proc_r.getPct(957)*100)*100)/100,f_mp_proc_r.getCount(1085),Double.isNaN(f_mp_proc_r.getPct(1085))?0:Math.rint((f_mp_proc_r.getPct(1085)*100)*100)/100,f_mp_proc_r.getCount(1086),Double.isNaN(f_mp_proc_r.getPct(1086))?0:Math.rint((f_mp_proc_r.getPct(1086)*100)*100)/100,f_mp_proc_r.getCount(1147),Double.isNaN(f_mp_proc_r.getPct(1147))?0:Math.rint((f_mp_proc_r.getPct(1147)*100)*100)/100, f_mp_proc_r.getCount(957)+f_mp_proc_r.getCount(1085)+f_mp_proc_r.getCount(1086)+f_mp_proc_r.getCount(1147),0);
		EstadisticasBasicas eb02r = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_2"),f_dai_proc_r.getCount(957),Double.isNaN(f_dai_proc_r.getPct(957))?0:Math.rint((f_dai_proc_r.getPct(957)*100)*100)/100,f_dai_proc_r.getCount(1085),Double.isNaN(f_dai_proc_r.getPct(1085))?0:Math.rint((f_dai_proc_r.getPct(1085)*100)*100)/100,f_dai_proc_r.getCount(1086),Double.isNaN(f_dai_proc_r.getPct(1086))?0:Math.rint((f_dai_proc_r.getPct(1086)*100)*100)/100,f_dai_proc_r.getCount(1147),Double.isNaN(f_dai_proc_r.getPct(1147))?0:Math.rint((f_dai_proc_r.getPct(1147)*100)*100)/100, f_dai_proc_r.getCount(957)+f_dai_proc_r.getCount(1085)+f_dai_proc_r.getCount(1086)+f_dai_proc_r.getCount(1147),0);
		EstadisticasBasicas eb03r = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_3"),f_crtp_proc_r.getCount(957),Double.isNaN(f_crtp_proc_r.getPct(957))?0:Math.rint((f_crtp_proc_r.getPct(957)*100)*100)/100,f_crtp_proc_r.getCount(1085),Double.isNaN(f_crtp_proc_r.getPct(1085))?0:Math.rint((f_crtp_proc_r.getPct(1085)*100)*100)/100,f_crtp_proc_r.getCount(1086),Double.isNaN(f_crtp_proc_r.getPct(1086))?0:Math.rint((f_crtp_proc_r.getPct(1086)*100)*100)/100,f_crtp_proc_r.getCount(1147),Double.isNaN(f_crtp_proc_r.getPct(1147))?0:Math.rint((f_crtp_proc_r.getPct(1147)*100)*100)/100, f_crtp_proc_r.getCount(957)+f_crtp_proc_r.getCount(1085)+f_crtp_proc_r.getCount(1086)+f_crtp_proc_r.getCount(1147),0);
		EstadisticasBasicas eb04r = new EstadisticasBasicas(this.bundle.getString("imp_dispositivos_tipo_4"),f_crtd_proc_r.getCount(957),Double.isNaN(f_crtd_proc_r.getPct(957))?0:Math.rint((f_crtd_proc_r.getPct(957)*100)*100)/100,f_crtd_proc_r.getCount(1085),Double.isNaN(f_crtd_proc_r.getPct(1085))?0:Math.rint((f_crtd_proc_r.getPct(1085)*100)*100)/100,f_crtd_proc_r.getCount(1086),Double.isNaN(f_crtd_proc_r.getPct(1086))?0:Math.rint((f_crtd_proc_r.getPct(1086)*100)*100)/100,f_crtd_proc_r.getCount(1147),Double.isNaN(f_crtd_proc_r.getPct(1147))?0:Math.rint((f_crtd_proc_r.getPct(1147)*100)*100)/100, f_crtd_proc_r.getCount(957)+f_crtd_proc_r.getCount(1085)+f_crtd_proc_r.getCount(1086)+f_crtd_proc_r.getCount(1147),0);
		EstadisticasBasicas eb05r = new EstadisticasBasicas(this.bundle.getString("est_basic_total"),f_mp_proc_r.getCount(957)+f_dai_proc_r.getCount(957)+f_crtp_proc_r.getCount(957)+f_crtd_proc_r.getCount(957),Double.isNaN(p_reint_r)?0:Math.rint((p_reint_r*100)*100)/100,f_mp_proc_r.getCount(1085)+f_dai_proc_r.getCount(1085)+f_crtp_proc_r.getCount(1085)+f_crtd_proc_r.getCount(1085),Double.isNaN(p_recgen_r)?0:Math.rint((p_recgen_r*100)*100)/100,f_mp_proc_r.getCount(1086)+f_dai_proc_r.getCount(1086)+f_crtp_proc_r.getCount(1086)+f_crtd_proc_r.getCount(1086),Double.isNaN(p_recele_r)?0:Math.rint((p_recele_r*100)*100)/100, f_mp_proc_r.getCount(1147)+f_dai_proc_r.getCount(1147)+f_crtp_proc_r.getCount(1147)+f_crtd_proc_r.getCount(1147),Double.isNaN(p_expl_r)?0:Math.rint((p_expl_r*100)*100)/100,totalprocsReint,0);
		
		// sumatorios
		long totalImplMps = f_mp_proc.getCount(956) + f_mp_proc.getCount(1059) + f_mp_proc.getCount(1060) + f_mp_proc.getCount(1090);
		long totalReintMps = f_mp_proc_r.getCount(957) + f_mp_proc_r.getCount(1085) + f_mp_proc_r.getCount(1086) + f_mp_proc_r.getCount(1147);
		eb01.setSuma1(totalImplMps);
		eb01r.setSuma1(totalReintMps);
		long totalImplDai = f_dai_proc.getCount(956) + f_dai_proc.getCount(1059) + f_dai_proc.getCount(1060) + f_dai_proc.getCount(1090);
		long totalReintDai = f_dai_proc_r.getCount(957) + f_dai_proc_r.getCount(1085) + f_dai_proc_r.getCount(1086) + f_dai_proc_r.getCount(1147);
		eb02.setSuma1(totalImplDai);
		eb02r.setSuma1(totalReintDai);
		long totalImplCRTP = f_crtp_proc.getCount(956) + f_crtp_proc.getCount(1059) + f_crtp_proc.getCount(1060) + f_crtp_proc.getCount(1090);
		long totalReintCRTP = f_crtp_proc_r.getCount(957) + f_crtp_proc_r.getCount(1085) + f_crtp_proc_r.getCount(1086) + f_crtp_proc_r.getCount(1147);
		eb03.setSuma1(totalImplCRTP);
		eb03r.setSuma1(totalReintCRTP);
		long totalImplCRTD = f_crtd_proc.getCount(956) + f_crtd_proc.getCount(1059) + f_crtd_proc.getCount(1060) + f_crtd_proc.getCount(1090);
		long totalReintCRTD = f_crtd_proc_r.getCount(957) + f_crtd_proc_r.getCount(1085) + f_crtd_proc_r.getCount(1086) + f_crtd_proc_r.getCount(1147);
		eb04.setSuma1(totalImplCRTD);
		eb04r.setSuma1(totalReintCRTD);
		
		long totalImpl = totalImplMps + totalImplDai + totalImplCRTP + totalImplCRTD;
		long totalReint = totalReintMps + totalReintDai + totalReintCRTP + totalReintCRTD;
		eb05.setSuma1(totalImpl);
		eb05r.setSuma1(totalReint);
		
		this.getImpproc().add(eb01);this.getImpproc().add(eb02);this.getImpproc().add(eb03);this.getImpproc().add(eb04);this.getImpproc().add(eb05);
		this.getImpreintproc().add(eb01r);this.getImpreintproc().add(eb02r);this.getImpreintproc().add(eb03r);this.getImpreintproc().add(eb04r);this.getImpreintproc().add(eb05r);
		
		// ALTA ENERGIA
		this.getImpaefab().clear();
		long totalae = f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR")+f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR")+f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR")+f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR")+f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR")+f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR")
				+ f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR")+f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR")+f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR")+f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR")+f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR")+f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR")
				+ f_tipo_sg_ae.getCount("DDDRV")+f_tipo_md_ae.getCount("DDDRV")+f_tipo_sj_ae.getCount("DDDRV")+f_tipo_bs_ae.getCount("DDDRV")+f_tipo_bi_ae.getCount("DDDRV")+f_tipo_vi_ae.getCount("DDDRV");
		long total_sg = f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR") + f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR") + f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR") + f_tipo_sg_ae.getCount("DDDRV");
		long total_md = f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR") + f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR") + f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR") + f_tipo_md_ae.getCount("DDDRV");
		long total_sj = f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR") + f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR") + f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR") + f_tipo_sj_ae.getCount("DDDRV");
		long total_bs = f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR") + f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR") + f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR") + f_tipo_bs_ae.getCount("DDDRV");
		long total_bi = f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR") + f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR") + f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR") + f_tipo_bi_ae.getCount("DDDRV");
		long total_vit = f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+ f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR") + f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR") + f_tipo_vi_ae.getCount("DDDRV");
		EstadisticasBasicas eb11 = new EstadisticasBasicas("Sorin Group",f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR"))/(float)total_sg))?0:Math.rint((((float)(f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR"))/(float)total_sg)*100)*100)/100,f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR"))/(float)total_sg))?0:Math.rint((((float)(f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR"))/(float)total_sg)*100)*100)/100,f_tipo_sg_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_sg_ae.getCount("DDDRV"))/(float)total_sg))?0:Math.rint((((float)(f_tipo_sg_ae.getCount("DDDRV"))/(float)total_sg)*100)*100)/100,total_sg,0);
		EstadisticasBasicas eb12 = new EstadisticasBasicas("Medtronic",f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR"))/(float)total_md))?0:Math.rint((((float)(f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR"))/(float)total_md)*100)*100)/100,f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR"))/(float)total_md))?0:Math.rint((((float)(f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR"))/(float)total_md)*100)*100)/100,f_tipo_md_ae.getCount("DDDRV"),Double.isNaN((((float)(f_tipo_md_ae.getCount("DDDRV"))/(float)total_md)*100))?0:Math.rint((((float)(f_tipo_md_ae.getCount("DDDRV"))/(float)total_md)*100)*100)/100,total_md,0);
		EstadisticasBasicas eb13 = new EstadisticasBasicas("Boston Scientific",f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR"))/(float)total_bs))?0:Math.rint((((float)(f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR"))/(float)total_bs)*100)*100)/100,f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR"))/(float)total_bs))?0:Math.rint((((float)(f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR"))/(float)total_bs)*100)*100)/100,f_tipo_bs_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_bs_ae.getCount("DDDRV"))/(float)total_bs))?0:Math.rint((((float)(f_tipo_bs_ae.getCount("DDDRV"))/(float)total_bs)*100)*100)/100,total_bs,0);
		EstadisticasBasicas eb14 = new EstadisticasBasicas("Saint Jude Medical",f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR"))/(float)total_sj))?0:Math.rint((((float)(f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR"))/(float)total_sj)*100)*100)/100,f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR"))/(float)total_sj))?0:Math.rint((((float)(f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR"))/(float)total_sj)*100)*100)/100,f_tipo_sj_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_sj_ae.getCount("DDDRV"))/(float)total_sj))?0:Math.rint((((float)(f_tipo_sj_ae.getCount("DDDRV"))/(float)total_sj)*100)*100)/100,total_sj,0);
		EstadisticasBasicas eb15 = new EstadisticasBasicas("Biotronik",f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR"))/(float)total_bi))?0:Math.rint((((float)(f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR"))/(float)total_bi)*100)*100)/100,f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR"))/(float)total_bi))?0:Math.rint((((float)(f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR"))/(float)total_bi)*100)*100)/100,f_tipo_bi_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_bi_ae.getCount("DDDRV"))/(float)total_bi))?0:Math.rint((((float)(f_tipo_bi_ae.getCount("DDDRV"))/(float)total_bi)*100)*100)/100,total_bi,0);
		EstadisticasBasicas eb17 = new EstadisticasBasicas("Vitatron",f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"))/(float)total_vit))?0:Math.rint((((float)(f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"))/(float)total_vit)*100)*100)/100,f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"))/(float)total_vit))?0:Math.rint((((float)(f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"))/(float)total_vit)*100)*100)/100,f_tipo_vi_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_vi_ae.getCount("DDDRV"))/(float)total_vit))?0:Math.rint((((float)(f_tipo_vi_ae.getCount("DDDRV"))/(float)total_vit)*100)*100)/100,total_vit,0);
		EstadisticasBasicas eb16 = new EstadisticasBasicas(this.bundle.getString("est_basic_total"),
				f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR")+f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR")+f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR")+f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR")+f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR")+f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR")+f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR")+f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR")+f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR")+f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR")+f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"))/(float)totalae))?0:Math.rint(((((float)(f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR")+f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR")+f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR")+f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR")+f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR")+f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"))/(float)totalae)*100))*100)/100,
				f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR")+f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR")+f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR")+f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR")+f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR")+f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR")+f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR")+f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR")+f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR")+f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR")+f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"))/(float)totalae))?0:Math.rint(((((float)(f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR")+f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR")+f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR")+f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR")+f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR")+f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"))/(float)totalae)*100))*100)/100,
				f_tipo_sg_ae.getCount("DDDRV")+f_tipo_md_ae.getCount("DDDRV")+f_tipo_sj_ae.getCount("DDDRV")+f_tipo_bs_ae.getCount("DDDRV")+f_tipo_bi_ae.getCount("DDDRV")+f_tipo_vi_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_sg_ae.getCount("DDDRV")+f_tipo_md_ae.getCount("DDDRV")+f_tipo_bs_ae.getCount("DDDRV")+f_tipo_sj_ae.getCount("DDDRV"))+f_tipo_bi_ae.getCount("DDDRV")+f_tipo_vi_ae.getCount("DDDRV"))/(float)totalae)?0:Math.rint(((((float)(f_tipo_sg_ae.getCount("DDDRV")+f_tipo_md_ae.getCount("DDDRV")+f_tipo_bs_ae.getCount("DDDRV")+f_tipo_sj_ae.getCount("DDDRV"))+f_tipo_bi_ae.getCount("DDDRV")+f_tipo_vi_ae.getCount("DDDRV"))/(float)totalae*100))*100)/100,
				totalae,0);
		this.getImpaefab().add(eb11);this.getImpaefab().add(eb12);this.getImpaefab().add(eb13);this.getImpaefab().add(eb14);
		this.getImpaefab().add(eb15);this.getImpaefab().add(eb17);this.getImpaefab().add(eb16);		
		
		this.getImpaetipo().clear();
		long total_vi = f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR")+f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR")+f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR")+f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR")+f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR")+f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR");
		long total_dr = f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR")+f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR")+f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR")+f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR")+f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR")+f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR");
		long total_crtd = f_tipo_sg_ae.getCount("DDDRV")+f_tipo_md_ae.getCount("DDDRV")+f_tipo_bs_ae.getCount("DDDRV")+f_tipo_sj_ae.getCount("DDDRV")+f_tipo_bi_ae.getCount("DDDRV")+f_tipo_vi_ae.getCount("DDDRV");
		EstadisticasBasicas eb21 = new EstadisticasBasicas("VR",f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR"))/(float)total_vi))?0:Math.rint((((float)(f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR"))/(float)total_vi)*100)*100)/100,f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR"))/(float)total_vi))?0:Math.rint((((float)(f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR"))/(float)total_vi)*100)*100)/100,f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR"))/(float)total_vi))?0:Math.rint((((float)(f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR"))/(float)total_vi)*100)*100)/100,f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR"))/(float)total_vi))?0:Math.rint((((float)(f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR"))/(float)total_vi)*100)*100)/100,f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR"))/(float)total_vi))?0:Math.rint((((float)(f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR"))/(float)total_vi)*100)*100)/100,f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"),Double.isNaN(((float)(f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"))/(float)total_vi))?0:Math.rint((((float)(f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"))/(float)total_vi)*100)*100)/100,               f_tipo_sg_ae.getCount("VDD")+f_tipo_sg_ae.getCount("VDDR")+f_tipo_sg_ae.getCount("VVI")+f_tipo_sg_ae.getCount("VVIR")+f_tipo_md_ae.getCount("VDD")+f_tipo_md_ae.getCount("VDDR")+f_tipo_md_ae.getCount("VVI")+f_tipo_md_ae.getCount("VVIR")+f_tipo_bs_ae.getCount("VDD")+f_tipo_bs_ae.getCount("VDDR")+f_tipo_bs_ae.getCount("VVI")+f_tipo_bs_ae.getCount("VVIR")+f_tipo_sj_ae.getCount("VDD")+f_tipo_sj_ae.getCount("VDDR")+f_tipo_sj_ae.getCount("VVI")+f_tipo_sj_ae.getCount("VVIR")+f_tipo_bi_ae.getCount("VDD")+f_tipo_bi_ae.getCount("VDDR")+f_tipo_bi_ae.getCount("VVI")+f_tipo_bi_ae.getCount("VVIR")+f_tipo_vi_ae.getCount("VDD")+f_tipo_vi_ae.getCount("VDDR")+f_tipo_vi_ae.getCount("VVI")+f_tipo_vi_ae.getCount("VVIR"),0);
		EstadisticasBasicas eb22 = new EstadisticasBasicas("DR",f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR"))/(float)total_dr))?0:Math.rint((((float)(f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR"))/(float)total_dr)*100)*100)/100,f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR"))/(float)total_dr))?0:Math.rint((((float)(f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR"))/(float)total_dr)*100)*100)/100,f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR"))/(float)total_dr))?0:Math.rint((((float)(f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR"))/(float)total_dr)*100)*100)/100,f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR"))/(float)total_dr))?0:Math.rint((((float)(f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR"))/(float)total_dr)*100)*100)/100,f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR"))/(float)total_dr))?0:Math.rint((((float)(f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR"))/(float)total_dr)*100)*100)/100,f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"),Double.isNaN(((float)(f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"))/(float)total_dr))?0:Math.rint((((float)(f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"))/(float)total_dr)*100)*100)/100,               f_tipo_sg_ae.getCount("DDD")+f_tipo_sg_ae.getCount("DDDR")+f_tipo_md_ae.getCount("DDD")+f_tipo_md_ae.getCount("DDDR")+f_tipo_bs_ae.getCount("DDD")+f_tipo_bs_ae.getCount("DDDR")+f_tipo_sj_ae.getCount("DDD")+f_tipo_sj_ae.getCount("DDDR")+f_tipo_bi_ae.getCount("DDD")+f_tipo_bi_ae.getCount("DDDR")+f_tipo_vi_ae.getCount("DDD")+f_tipo_vi_ae.getCount("DDDR"),0);
		EstadisticasBasicas eb23 = new EstadisticasBasicas("CRTD",f_tipo_sg_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_sg_ae.getCount("DDDRV"))/(float)total_crtd))?0:Math.rint((((float)(f_tipo_sg_ae.getCount("DDDRV"))/(float)total_crtd)*100)*100)/100,f_tipo_md_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_md_ae.getCount("DDDRV"))/(float)total_crtd))?0:Math.rint((((float)(f_tipo_md_ae.getCount("DDDRV"))/(float)total_crtd)*100)*100)/100,f_tipo_bs_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_bs_ae.getCount("DDDRV"))/(float)total_crtd))?0:Math.rint((((float)(f_tipo_bs_ae.getCount("DDDRV"))/(float)total_crtd)*100)*100)/100,f_tipo_sj_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_sj_ae.getCount("DDDRV"))/(float)total_crtd))?0:Math.rint((((float)(f_tipo_sj_ae.getCount("DDDRV"))/(float)total_crtd)*100)*100)/100,f_tipo_bi_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_vi_ae.getCount("DDDRV"))/(float)total_crtd))?0:Math.rint((((float)(f_tipo_vi_ae.getCount("DDDRV"))/(float)total_crtd)*100)*100)/100,f_tipo_vi_ae.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_vi_ae.getCount("DDDRV"))/(float)total_crtd))?0:Math.rint((((float)(f_tipo_vi_ae.getCount("DDDRV"))/(float)total_crtd)*100)*100)/100,             f_tipo_sg_ae.getCount("DDDRV")+f_tipo_md_ae.getCount("DDDRV")+f_tipo_bs_ae.getCount("DDDRV")+f_tipo_sj_ae.getCount("DDDRV")+f_tipo_bi_ae.getCount("DDDRV")+f_tipo_vi_ae.getCount("DDDRV"),0);
		EstadisticasBasicas eb24 = new EstadisticasBasicas(
				this.bundle.getString("est_basic_total"),total_sg,Double.isNaN(((float)(total_sg)/(float)totalae))?0:Math.rint((((float)(total_sg)/(float)totalae)*100)*100)/100,
				total_md,Double.isNaN((((float)total_md)/(float)totalae))?0:Math.rint(((((float)total_md)/(float)totalae)*100)*100)/100,
				total_bs,Double.isNaN((((float)total_bs)/(float)totalae))?0:Math.rint(((((float)total_bs)/(float)totalae)*100)*100)/100,
				total_sj,Double.isNaN((((float)total_sj)/(float)totalae))?0:Math.rint(((((float)total_sj)/(float)totalae)*100)*100)/100,
				total_bi,Double.isNaN((((float)total_bi)/(float)totalae))?0:Math.rint(((((float)total_bi)/(float)totalae)*100)*100)/100,
				total_vi,Double.isNaN((((float)total_vi)/(float)totalae))?0:Math.rint(((((float)total_vi)/(float)totalae)*100)*100)/100,
				totalae,0);		
		this.getImpaetipo().add(eb21);this.getImpaetipo().add(eb22);this.getImpaetipo().add(eb23);this.getImpaetipo().add(eb24);
		
		// BAJA ENERGIA
		this.getImpbefab().clear();
		long totalbe = f_tipo_sg_be.getCount("VDD")+f_tipo_sg_be.getCount("VDDR")+f_tipo_md_be.getCount("VDD")+f_tipo_md_be.getCount("VDDR")+f_tipo_bs_be.getCount("VDD")+f_tipo_bs_be.getCount("VDDR")+f_tipo_sj_be.getCount("VDD")+f_tipo_sj_be.getCount("VDDR")+f_tipo_bi_be.getCount("VDD")+f_tipo_bi_be.getCount("VDDR")+f_tipo_vi_be.getCount("VDD")+f_tipo_vi_be.getCount("VDDR")
				+ f_tipo_sg_be.getCount("DDD")+f_tipo_sg_be.getCount("DDDR")+f_tipo_md_be.getCount("DDD")+f_tipo_md_be.getCount("DDDR")+f_tipo_bs_be.getCount("DDD")+f_tipo_bs_be.getCount("DDDR")+f_tipo_sj_be.getCount("DDD")+f_tipo_sj_be.getCount("DDDR")+f_tipo_bi_be.getCount("DDD")+f_tipo_bi_be.getCount("DDDR")+f_tipo_vi_be.getCount("DDD")+f_tipo_vi_be.getCount("DDDR")
				+ f_tipo_sg_be.getCount("DDDRV")+f_tipo_md_be.getCount("DDDRV")+f_tipo_sj_be.getCount("DDDRV")+f_tipo_bs_be.getCount("DDDRV")+f_tipo_bi_be.getCount("DDDRV")+f_tipo_vi_be.getCount("DDDRV")
				+ f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("SSIR") + f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("SSIR")
				+ f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("SSIR") + f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("SSIR")
				+ f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("SSIR")+ f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("SSIR")
				+ f_tipo_sg_be.getCount("VVI")+f_tipo_sg_be.getCount("VVIR") + f_tipo_md_be.getCount("VVI")+f_tipo_md_be.getCount("VVIR")
				+ f_tipo_bs_be.getCount("VVI")+f_tipo_bs_be.getCount("VVIR") + f_tipo_sj_be.getCount("VVI")+f_tipo_sj_be.getCount("VVIR")
				+ f_tipo_bi_be.getCount("VVI")+f_tipo_bi_be.getCount("VVIR")+ f_tipo_vi_be.getCount("VVI")+f_tipo_vi_be.getCount("VVIR");
		long total_sg_be = f_tipo_sg_be.getCount("VDD")+f_tipo_sg_be.getCount("VDDR") + f_tipo_sg_be.getCount("DDD")+f_tipo_sg_be.getCount("DDDR") + f_tipo_sg_be.getCount("DDDRV")+f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("SSIR")+f_tipo_sg_be.getCount("VVI")+f_tipo_sg_be.getCount("VVIR");
		long total_md_be = f_tipo_md_be.getCount("VDD")+f_tipo_md_be.getCount("VDDR") + f_tipo_md_be.getCount("DDD")+f_tipo_md_be.getCount("DDDR") + f_tipo_md_be.getCount("DDDRV")+f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("SSIR")+f_tipo_md_be.getCount("VVI")+f_tipo_md_be.getCount("VVIR");
		long total_sj_be = f_tipo_sj_be.getCount("VDD")+f_tipo_sj_be.getCount("VDDR") + f_tipo_sj_be.getCount("DDD")+f_tipo_sj_be.getCount("DDDR") + f_tipo_sj_be.getCount("DDDRV")+f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("SSIR")+f_tipo_sj_be.getCount("VVI")+f_tipo_sj_be.getCount("VVIR");
		long total_bs_be = f_tipo_bs_be.getCount("VDD")+f_tipo_bs_be.getCount("VDDR") + f_tipo_bs_be.getCount("DDD")+f_tipo_bs_be.getCount("DDDR") + f_tipo_bs_be.getCount("DDDRV")+f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("SSIR")+f_tipo_bs_be.getCount("VVI")+f_tipo_bs_be.getCount("VVIR");
		long total_bi_be = f_tipo_bi_be.getCount("VDD")+f_tipo_bi_be.getCount("VDDR") + f_tipo_bi_be.getCount("DDD")+f_tipo_bi_be.getCount("DDDR") + f_tipo_bi_be.getCount("DDDRV")+f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("SSIR")+f_tipo_bi_be.getCount("VVI")+f_tipo_bi_be.getCount("VVIR");	
		long total_vi_be = f_tipo_vi_be.getCount("VDD")+f_tipo_vi_be.getCount("VDDR") + f_tipo_vi_be.getCount("DDD")+f_tipo_vi_be.getCount("DDDR") + f_tipo_vi_be.getCount("DDDRV")+f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("SSIR")+f_tipo_vi_be.getCount("VVI")+f_tipo_vi_be.getCount("VVIR");
		EstadisticasBasicas eb31 = new EstadisticasBasicas("Sorin Group",f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("VVI"),Double.isNaN(f_tipo_sg_be.getPct("SSI")+f_tipo_sg_be.getPct("VVI"))?0:Math.rint(((f_tipo_sg_be.getPct("SSI")+f_tipo_sg_be.getPct("VVI"))*100)*100)/100,f_tipo_sg_be.getCount("SSIR")+f_tipo_sg_be.getCount("VVIR"),Double.isNaN(f_tipo_sg_be.getPct("SSIR")+f_tipo_sg_be.getPct("VVIR"))?0:Math.rint(((f_tipo_sg_be.getPct("SSIR")+f_tipo_sg_be.getPct("VVIR"))*100)*100)/100,f_tipo_sg_be.getCount("VDD"),Double.isNaN(f_tipo_sg_be.getPct("VDD"))?0:Math.rint((f_tipo_sg_be.getPct("VDD")*100)*100)/100,f_tipo_sg_be.getCount("VDDR"),Double.isNaN(f_tipo_sg_be.getPct("VDDR"))?0:Math.rint((f_tipo_sg_be.getPct("VDDR")*100)*100)/100,f_tipo_sg_be.getCount("DDD"),Double.isNaN(f_tipo_sg_be.getPct("DDD"))?0:Math.rint((f_tipo_sg_be.getPct("DDD")*100)*100)/100,f_tipo_sg_be.getCount("DDDR"),Double.isNaN(f_tipo_sg_be.getPct("DDDR"))?0:Math.rint((f_tipo_sg_be.getPct("DDDR")*100)*100)/100,f_tipo_sg_be.getCount("DDDRV"),Double.isNaN(f_tipo_sg_be.getPct("DDDRV"))?0:Math.rint((f_tipo_sg_be.getPct("DDDRV")*100)*100)/100,total_sg_be,0);		
		EstadisticasBasicas eb32 = new EstadisticasBasicas("Medtronic",f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("VVI"),Double.isNaN(f_tipo_md_be.getPct("SSI")+f_tipo_md_be.getPct("VVI"))?0:Math.rint(((f_tipo_md_be.getPct("SSI")+f_tipo_md_be.getPct("VVI"))*100)*100)/100,f_tipo_md_be.getCount("SSIR")+f_tipo_md_be.getCount("VVIR"),Double.isNaN(f_tipo_md_be.getPct("SSIR")+f_tipo_md_be.getPct("VVIR"))?0:Math.rint(((f_tipo_md_be.getPct("SSIR")+f_tipo_md_be.getPct("VVIR"))*100)*100)/100,f_tipo_md_be.getCount("VDD"),Double.isNaN(f_tipo_md_be.getPct("VDD"))?0:Math.rint((f_tipo_md_be.getPct("VDD")*100)*100)/100,f_tipo_md_be.getCount("VDDR"),Double.isNaN(f_tipo_md_be.getPct("VDDR"))?0:Math.rint((f_tipo_md_be.getPct("VDDR")*100)*100)/100,f_tipo_md_be.getCount("DDD"),Double.isNaN(f_tipo_md_be.getPct("DDD"))?0:Math.rint((f_tipo_md_be.getPct("DDD")*100)*100)/100,f_tipo_md_be.getCount("DDDR"),Double.isNaN(f_tipo_md_be.getPct("DDDR"))?0:Math.rint((f_tipo_md_be.getPct("DDDR")*100)*100)/100,f_tipo_md_be.getCount("DDDRV"),Double.isNaN(f_tipo_md_be.getPct("DDDRV"))?0:Math.rint((f_tipo_md_be.getPct("DDDRV")*100)*100)/100,total_md_be,0);
		EstadisticasBasicas eb33 = new EstadisticasBasicas("Boston Scientific",f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("VVI"),Double.isNaN(f_tipo_bs_be.getPct("SSI")+f_tipo_bs_be.getPct("VVI"))?0:Math.rint(((f_tipo_bs_be.getPct("SSI")+f_tipo_bs_be.getPct("VVI"))*100)*100)/100,f_tipo_bs_be.getCount("SSIR")+f_tipo_bs_be.getCount("VVIR"),Double.isNaN(f_tipo_bs_be.getPct("SSIR")+f_tipo_bs_be.getPct("VVIR"))?0:Math.rint(((f_tipo_bs_be.getPct("SSIR")+f_tipo_bs_be.getPct("VVIR"))*100)*100)/100,f_tipo_bs_be.getCount("VDD"),Double.isNaN(f_tipo_bs_be.getPct("VDD"))?0:Math.rint((f_tipo_bs_be.getPct("VDD")*100)*100)/100,f_tipo_bs_be.getCount("VDDR"),Double.isNaN(f_tipo_bs_be.getPct("VDDR"))?0:Math.rint((f_tipo_bs_be.getPct("VDDR")*100)*100)/100,f_tipo_bs_be.getCount("DDD"),Double.isNaN(f_tipo_bs_be.getPct("DDD"))?0:Math.rint((f_tipo_bs_be.getPct("DDD")*100)*100)/100,f_tipo_bs_be.getCount("DDDR"),Double.isNaN(f_tipo_bs_be.getPct("DDDR"))?0:Math.rint((f_tipo_bs_be.getPct("DDDR")*100)*100)/100,f_tipo_bs_be.getCount("DDDRV"),Double.isNaN(f_tipo_bs_be.getPct("DDDRV"))?0:Math.rint((f_tipo_bs_be.getPct("DDDRV")*100)*100)/100,total_bs_be,0);
		EstadisticasBasicas eb34 = new EstadisticasBasicas("Saint Jude Medical",f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("VVI"),Double.isNaN(f_tipo_sj_be.getPct("SSI")+f_tipo_sj_be.getPct("VVI"))?0:Math.rint(((f_tipo_sj_be.getPct("SSI")+f_tipo_sj_be.getPct("VVI"))*100)*100)/100,f_tipo_sj_be.getCount("SSIR")+f_tipo_sj_be.getCount("VVIR"),Double.isNaN(f_tipo_sj_be.getPct("SSIR")+f_tipo_sj_be.getPct("VVSIR"))?0:Math.rint(((f_tipo_sj_be.getPct("SSIR")+f_tipo_sj_be.getPct("VVIR"))*100)*100)/100,f_tipo_sj_be.getCount("VDD"),Double.isNaN(f_tipo_sj_be.getPct("VDD"))?0:Math.rint((f_tipo_sj_be.getPct("VDD")*100)*100)/100,f_tipo_sj_be.getCount("VDDR"),Double.isNaN(f_tipo_sj_be.getPct("VDDR"))?0:Math.rint((f_tipo_sj_be.getPct("VDDR")*100)*100)/100,f_tipo_sj_be.getCount("DDD"),Double.isNaN(f_tipo_sj_be.getPct("DDD"))?0:Math.rint((f_tipo_sj_be.getPct("DDD")*100)*100)/100,f_tipo_sj_be.getCount("DDDR"),Double.isNaN(f_tipo_sj_be.getPct("DDDR"))?0:Math.rint((f_tipo_sj_be.getPct("DDDR")*100)*100)/100,f_tipo_sj_be.getCount("DDDRV"),Double.isNaN(f_tipo_sj_be.getPct("DDDRV"))?0:Math.rint((f_tipo_sj_be.getPct("DDDRV")*100)*100)/100,total_sj_be,0);
		EstadisticasBasicas eb35 = new EstadisticasBasicas("Biotronik",f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("VVI"),Double.isNaN(f_tipo_bi_be.getPct("SSI")+f_tipo_bi_be.getPct("VVI"))?0:Math.rint(((f_tipo_bi_be.getPct("SSI")+f_tipo_bi_be.getPct("VVI"))*100)*100)/100,f_tipo_bi_be.getCount("SSIR")+f_tipo_bi_be.getCount("VVIR"),Double.isNaN(f_tipo_bi_be.getPct("SSIR")+f_tipo_bi_be.getPct("VVIR"))?0:Math.rint(((f_tipo_bi_be.getPct("SSIR")+f_tipo_bi_be.getPct("VVIR"))*100)*100)/100,f_tipo_bi_be.getCount("VDD"),Double.isNaN(f_tipo_bi_be.getPct("VDD"))?0:Math.rint((f_tipo_bi_be.getPct("VDD")*100)*100)/100,f_tipo_bi_be.getCount("VDDR"),Double.isNaN(f_tipo_bi_be.getPct("VDDR"))?0:Math.rint((f_tipo_bi_be.getPct("VDDR")*100)*100)/100,f_tipo_bi_be.getCount("DDD"),Double.isNaN(f_tipo_bi_be.getPct("DDD"))?0:Math.rint((f_tipo_bi_be.getPct("DDD")*100)*100)/100,f_tipo_bi_be.getCount("DDDR"),Double.isNaN(f_tipo_bi_be.getPct("DDDR"))?0:Math.rint((f_tipo_bi_be.getPct("DDDR")*100)*100)/100,f_tipo_bi_be.getCount("DDDRV"),Double.isNaN(f_tipo_bi_be.getPct("DDDRV"))?0:Math.rint((f_tipo_bi_be.getPct("DDDRV")*100)*100)/100,total_bi_be,0);
		EstadisticasBasicas eb37 = new EstadisticasBasicas("Vitatron",f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("VVI"),Double.isNaN(f_tipo_vi_be.getPct("SSI")+f_tipo_vi_be.getPct("VVI"))?0:Math.rint(((f_tipo_vi_be.getPct("SSI")+f_tipo_vi_be.getPct("VVI"))*100)*100)/100,f_tipo_vi_be.getCount("SSIR")+f_tipo_vi_be.getCount("VVIR"),Double.isNaN(f_tipo_vi_be.getPct("SSIR")+f_tipo_vi_be.getPct("VVIR"))?0:Math.rint(((f_tipo_vi_be.getPct("SSIR")+f_tipo_vi_be.getPct("VVIR"))*100)*100)/100,f_tipo_vi_be.getCount("VDD"),Double.isNaN(f_tipo_vi_be.getPct("VDD"))?0:Math.rint((f_tipo_vi_be.getPct("VDD")*100)*100)/100,f_tipo_vi_be.getCount("VDDR"),Double.isNaN(f_tipo_vi_be.getPct("VDDR"))?0:Math.rint((f_tipo_vi_be.getPct("VDDR")*100)*100)/100,f_tipo_vi_be.getCount("DDD"),Double.isNaN(f_tipo_vi_be.getPct("DDD"))?0:Math.rint((f_tipo_vi_be.getPct("DDD")*100)*100)/100,f_tipo_vi_be.getCount("DDDR"),Double.isNaN(f_tipo_vi_be.getPct("DDDR"))?0:Math.rint((f_tipo_vi_be.getPct("DDDR")*100)*100)/100,f_tipo_vi_be.getCount("DDDRV"),Double.isNaN(f_tipo_vi_be.getPct("DDDRV"))?0:Math.rint((f_tipo_vi_be.getPct("DDDRV")*100)*100)/100,total_vi_be,0);
		EstadisticasBasicas eb36 = new EstadisticasBasicas(this.bundle.getString("est_basic_total"),
				f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("VVI")+f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("VVI")+f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("VVI")+f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("VVI")+f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("VVI")+f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("VVI"),Double.isNaN(((float)(f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("VVI")+f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("VVI")+f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("VVI")+f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("VVI")+f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("VVI")+f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("VVI"))/(float)totalbe))?0:Math.rint((((float)(f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("VVI")+f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("VVI")+f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("VVI")+f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("VVI")+f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("VVI")+f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("VVI"))/(float)totalbe)*100)*100)/100,
				f_tipo_sg_be.getCount("SSIR")+f_tipo_sg_be.getCount("VVIR")+f_tipo_md_be.getCount("SSIR")+f_tipo_md_be.getCount("VVIR")+f_tipo_bs_be.getCount("SSIR")+f_tipo_bs_be.getCount("VVIR")+f_tipo_sj_be.getCount("SSIR")+f_tipo_sj_be.getCount("VVIR")+f_tipo_bi_be.getCount("SSIR")+f_tipo_bi_be.getCount("VVIR")+f_tipo_vi_be.getCount("SSIR")+f_tipo_vi_be.getCount("VVIR"),Double.isNaN(((float)(f_tipo_sg_be.getCount("SSIR")+f_tipo_sg_be.getCount("VVIR")+f_tipo_md_be.getCount("SSIR")+f_tipo_md_be.getCount("VVIR")+f_tipo_bs_be.getCount("SSIR")+f_tipo_bs_be.getCount("VVIR")+f_tipo_sj_be.getCount("SSIR")+f_tipo_sj_be.getCount("VVIR")+f_tipo_bi_be.getCount("SSIR")+f_tipo_bi_be.getCount("VVIR")+f_tipo_vi_be.getCount("SSIR")+f_tipo_vi_be.getCount("VVIR"))/(float)totalbe))?0:Math.rint((((float)(f_tipo_sg_be.getCount("SSIR")+f_tipo_sg_be.getCount("VVIR")+f_tipo_md_be.getCount("SSIR")+f_tipo_md_be.getCount("VVIR")+f_tipo_bs_be.getCount("SSIR")+f_tipo_bs_be.getCount("VVIR")+f_tipo_sj_be.getCount("SSIR")+f_tipo_sj_be.getCount("VVIR")+f_tipo_bi_be.getCount("SSIR")+f_tipo_bi_be.getCount("VVIR")+f_tipo_vi_be.getCount("SSIR")+f_tipo_vi_be.getCount("VVIR"))/(float)totalbe)*100)*100)/100,
				f_tipo_sg_be.getCount("VDD")+f_tipo_md_be.getCount("VDD")+f_tipo_bs_be.getCount("VDD")+f_tipo_sj_be.getCount("VDD")+f_tipo_bi_be.getCount("VDD")+f_tipo_vi_be.getCount("VDD"),Double.isNaN(((float)(f_tipo_sg_be.getCount("VDD")+f_tipo_md_be.getCount("VDD")+f_tipo_bs_be.getCount("VDD")+f_tipo_sj_be.getCount("VDD")+f_tipo_bi_be.getCount("VDD")+f_tipo_vi_be.getCount("VDD"))/(float)totalbe))?0:Math.rint((((float)(f_tipo_sg_be.getCount("VDD")+f_tipo_md_be.getCount("VDD")+f_tipo_bs_be.getCount("VDD")+f_tipo_sj_be.getCount("VDD")+f_tipo_bi_be.getCount("VDD")+f_tipo_vi_be.getCount("VDD"))/(float)totalbe)*100)*100)/100,
				f_tipo_sg_be.getCount("VDDR")+f_tipo_md_be.getCount("VDDR")+f_tipo_bs_be.getCount("VDDR")+f_tipo_sj_be.getCount("VDDR")+f_tipo_bi_be.getCount("VDDR")+f_tipo_vi_be.getCount("VDDR"),Double.isNaN(((float)(f_tipo_sg_be.getCount("VDDR")+f_tipo_md_be.getCount("VDDR")+f_tipo_bs_be.getCount("VDDR")+f_tipo_sj_be.getCount("VDDR")+f_tipo_bi_be.getCount("VDDR")+f_tipo_vi_be.getCount("VDDR"))/(float)totalbe))?0:Math.rint((((float)(f_tipo_sg_be.getCount("VDDR")+f_tipo_md_be.getCount("VDDR")+f_tipo_bs_be.getCount("VDDR")+f_tipo_sj_be.getCount("VDDR")+f_tipo_bi_be.getCount("VDDR")+f_tipo_vi_be.getCount("VDDR"))/(float)totalbe)*100)*100)/100,
				f_tipo_sg_be.getCount("DDD")+f_tipo_md_be.getCount("DDD")+f_tipo_bs_be.getCount("DDD")+f_tipo_sj_be.getCount("DDD")+f_tipo_bi_be.getCount("DDD")+f_tipo_vi_be.getCount("DDD"),Double.isNaN(((float)(f_tipo_sg_be.getCount("DDD")+f_tipo_md_be.getCount("DDD")+f_tipo_bs_be.getCount("DDD")+f_tipo_sj_be.getCount("DDD")+f_tipo_bi_be.getCount("DDD")+f_tipo_vi_be.getCount("DDD"))/(float)totalbe))?0:Math.rint((((float)(f_tipo_sg_be.getCount("DDD")+f_tipo_md_be.getCount("DDD")+f_tipo_bs_be.getCount("DDD")+f_tipo_sj_be.getCount("DDD")+f_tipo_bi_be.getCount("DDD")+f_tipo_vi_be.getCount("DDD"))/(float)totalbe)*100)*100)/100,
				f_tipo_sg_be.getCount("DDDR")+f_tipo_md_be.getCount("DDDR")+f_tipo_bs_be.getCount("DDDR")+f_tipo_sj_be.getCount("DDDR")+f_tipo_bi_be.getCount("DDDR")+f_tipo_vi_be.getCount("DDDR"),Double.isNaN(((float)(f_tipo_sg_be.getCount("DDDR")+f_tipo_md_be.getCount("DDDR")+f_tipo_bs_be.getCount("DDDR")+f_tipo_sj_be.getCount("DDDR")+f_tipo_bi_be.getCount("DDDR")+f_tipo_vi_be.getCount("DDDR"))/(float)totalbe))?0:Math.rint((((float)(f_tipo_sg_be.getCount("DDDR")+f_tipo_md_be.getCount("DDDR")+f_tipo_bs_be.getCount("DDDR")+f_tipo_sj_be.getCount("DDDR")+f_tipo_bi_be.getCount("DDDR")+f_tipo_vi_be.getCount("DDDR"))/(float)totalbe)*100)*100)/100,
				f_tipo_sg_be.getCount("DDDRV")+f_tipo_md_be.getCount("DDDRV")+f_tipo_bs_be.getCount("DDDRV")+f_tipo_sj_be.getCount("DDDRV")+f_tipo_bi_be.getCount("DDDRV")+f_tipo_vi_be.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_sg_be.getCount("DDDRV")+f_tipo_md_be.getCount("DDDRV")+f_tipo_bs_be.getCount("DDDRV")+f_tipo_sj_be.getCount("DDDRV")+f_tipo_bi_be.getCount("DDDRV")+f_tipo_vi_be.getCount("DDDRV"))/(float)totalbe))?0:Math.rint((((float)(f_tipo_sg_be.getCount("DDDRV")+f_tipo_md_be.getCount("DDDRV")+f_tipo_bs_be.getCount("DDDRV")+f_tipo_sj_be.getCount("DDDRV")+f_tipo_bi_be.getCount("DDDRV")+f_tipo_vi_be.getCount("DDDRV"))/(float)totalbe)*100)*100)/100,
				totalbe,0);
		this.getImpbefab().add(eb31);this.getImpbefab().add(eb32);this.getImpbefab().add(eb33);this.getImpbefab().add(eb34);
		this.getImpbefab().add(eb35);this.getImpbefab().add(eb37);this.getImpbefab().add(eb36);	
		
		this.getImpbetipo().clear();
		long total_ssi = f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("VVI")+f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("VVI")+f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("VVI")+f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("VVI")+f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("VVI")+f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("VVI");
		long total_ssir = f_tipo_sg_be.getCount("SSIR")+f_tipo_sg_be.getCount("VVIR")+f_tipo_md_be.getCount("SSIR")+f_tipo_md_be.getCount("VVIR")+f_tipo_bs_be.getCount("SSIR")+f_tipo_bs_be.getCount("VVIR")+f_tipo_sj_be.getCount("SSIR")+f_tipo_sj_be.getCount("VVIR")+f_tipo_bi_be.getCount("SSIR")+f_tipo_bi_be.getCount("VVIR")+f_tipo_vi_be.getCount("SSIR")+f_tipo_vi_be.getCount("VVIR");
		long total_vdd =  f_tipo_sg_be.getCount("VDD")+f_tipo_md_be.getCount("VDD")+f_tipo_bs_be.getCount("VDD")+f_tipo_sj_be.getCount("VDD")+f_tipo_bi_be.getCount("VDD")+f_tipo_vi_be.getCount("VDD");
		long total_vddr =  f_tipo_sg_be.getCount("VDDR")+f_tipo_md_be.getCount("VDDR")+f_tipo_bs_be.getCount("VDDR")+f_tipo_sj_be.getCount("VDDR")+f_tipo_bi_be.getCount("VDDR")+f_tipo_vi_be.getCount("VDDR");
		long total_ddd =  f_tipo_sg_be.getCount("DDD")+f_tipo_md_be.getCount("DDD")+f_tipo_bs_be.getCount("DDD")+f_tipo_sj_be.getCount("DDD")+f_tipo_bi_be.getCount("DDD"+f_tipo_vi_be.getCount("DDD"));
		long total_dddr =  f_tipo_sg_be.getCount("DDDR")+f_tipo_md_be.getCount("DDDR")+f_tipo_bs_be.getCount("DDDR")+f_tipo_sj_be.getCount("DDDR")+f_tipo_bi_be.getCount("DDDR")+f_tipo_vi_be.getCount("DDDR");
		long total_dddrv =  f_tipo_sg_be.getCount("DDDRV")+f_tipo_md_be.getCount("DDDRV")+f_tipo_bs_be.getCount("DDDRV")+f_tipo_sj_be.getCount("DDDRV")+f_tipo_bi_be.getCount("DDDRV")+f_tipo_vi_be.getCount("DDDRV");
			
		EstadisticasBasicas eb41 = new EstadisticasBasicas("SSI",f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("VVI"),Double.isNaN(((float)(f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("VVI"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_sg_be.getCount("SSI")+f_tipo_sg_be.getCount("VVI"))/(float)total_ssi)*100)*100)/100,f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("VVI"),Double.isNaN(((float)(f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("VVI"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_md_be.getCount("SSI")+f_tipo_md_be.getCount("VVI"))/(float)total_ssi)*100)*100)/100,f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("VVI"),Double.isNaN(((float)(f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("VVI"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_bs_be.getCount("SSI")+f_tipo_bs_be.getCount("VVI"))/(float)total_ssi)*100)*100)/100,f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("VVI"),Double.isNaN(((float)(f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("VVI"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_sj_be.getCount("SSI")+f_tipo_sj_be.getCount("VVI"))/(float)total_ssi)*100)*100)/100,f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("VVI"),Double.isNaN(((float)(f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("VVI"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_bi_be.getCount("SSI")+f_tipo_bi_be.getCount("VVI"))/(float)total_ssi)*100)*100)/100,      f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("VVI"),Double.isNaN(((float)(f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("VVI"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_vi_be.getCount("SSI")+f_tipo_vi_be.getCount("VVI"))/(float)total_ssi)*100)*100)/100,                total_ssi,0);
		EstadisticasBasicas eb42 = new EstadisticasBasicas("SSIR",f_tipo_sg_be.getCount("SSIR")+f_tipo_sg_be.getCount("VVIR"),Double.isNaN(((float)(f_tipo_sg_be.getCount("SSIR")+f_tipo_sg_be.getCount("VVIR"))/(float)total_ssir))?0:Math.rint((((float)(f_tipo_sg_be.getCount("SSIR")+f_tipo_sg_be.getCount("VVIR"))/(float)total_ssir)*100)*100)/100,f_tipo_md_be.getCount("SSIR")+f_tipo_md_be.getCount("VVIR"),Double.isNaN(((float)(f_tipo_md_be.getCount("SSIR")+f_tipo_md_be.getCount("VVIR"))/(float)total_ssir))?0:Math.rint((((float)(f_tipo_md_be.getCount("SSIR")+f_tipo_md_be.getCount("VVIR"))/(float)total_ssir)*100)*100)/100,f_tipo_bs_be.getCount("SSIR")+f_tipo_bs_be.getCount("VVIR"),Double.isNaN(((float)(f_tipo_bs_be.getCount("SSIR")+f_tipo_bs_be.getCount("VVIR"))/(float)total_ssir))?0:Math.rint((((float)(f_tipo_bs_be.getCount("SSIR")+f_tipo_bs_be.getCount("VVIR"))/(float)total_ssir)*100)*100)/100,f_tipo_sj_be.getCount("SSIR")+f_tipo_sj_be.getCount("VVIR"),Double.isNaN(((float)(f_tipo_sj_be.getCount("SSIR")+f_tipo_sj_be.getCount("VVIR"))/(float)total_ssir))?0:Math.rint((((float)(f_tipo_sj_be.getCount("SSIR")+f_tipo_sj_be.getCount("VVIR"))/(float)total_ssir)*100)*100)/100,f_tipo_bi_be.getCount("SSIR")+f_tipo_bi_be.getCount("VVIR"),Double.isNaN(((float)(f_tipo_bi_be.getCount("SSIR")+f_tipo_bi_be.getCount("VVIR"))/(float)total_ssir))?0:Math.rint((((float)(f_tipo_bi_be.getCount("SSIR")+f_tipo_bi_be.getCount("VVIR"))/(float)total_ssir)*100)*100)/100,      f_tipo_vi_be.getCount("SSIR")+f_tipo_vi_be.getCount("VVIR"),Double.isNaN(((float)(f_tipo_vi_be.getCount("SSIR")+f_tipo_vi_be.getCount("VVIR"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_vi_be.getCount("SSIR")+f_tipo_vi_be.getCount("VVIR"))/(float)total_ssi)*100)*100)/100,  total_ssir,0);
		EstadisticasBasicas eb43 = new EstadisticasBasicas("VDD",f_tipo_sg_be.getCount("VDD"),Double.isNaN(((float)(f_tipo_sg_be.getCount("VDD"))/(float)total_vdd))?0:Math.rint((((float)(f_tipo_sg_be.getCount("VDD"))/(float)total_vdd)*100)*100)/100,f_tipo_md_be.getCount("VDD"),Double.isNaN(((float)(f_tipo_md_be.getCount("VDD"))/(float)total_vdd))?0:Math.rint((((float)(f_tipo_md_be.getCount("VDD"))/(float)total_vdd)*100)*100)/100,f_tipo_bs_be.getCount("VDD"),Double.isNaN(((float)(f_tipo_bs_be.getCount("VDD"))/(float)total_vdd))?0:Math.rint((((float)(f_tipo_bs_be.getCount("VDD"))/(float)total_vdd)*100)*100)/100,f_tipo_sj_be.getCount("VDD"),Double.isNaN(((float)(f_tipo_sj_be.getCount("VDD"))/(float)total_vdd))?0:Math.rint((((float)(f_tipo_sj_be.getCount("VDD"))/(float)total_vdd)*100)*100)/100,f_tipo_bi_be.getCount("VDD"),Double.isNaN(((float)(f_tipo_bi_be.getCount("VDD"))/(float)total_vdd))?0:Math.rint((((float)(f_tipo_bi_be.getCount("VDD"))/(float)total_vdd)*100)*100)/100,     f_tipo_vi_be.getCount("VDD"),Double.isNaN(((float)(f_tipo_vi_be.getCount("VDD"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_vi_be.getCount("VDD"))/(float)total_ssi)*100)*100)/100,      total_vdd,0);
		EstadisticasBasicas eb44 = new EstadisticasBasicas("VDDR",f_tipo_sg_be.getCount("VDDR"),Double.isNaN(((float)(f_tipo_sg_be.getCount("VDDR"))/(float)total_vddr))?0:Math.rint((((float)(f_tipo_sg_be.getCount("VDDR"))/(float)total_vddr)*100)*100)/100,f_tipo_md_be.getCount("VDDR"),Double.isNaN(((float)(f_tipo_md_be.getCount("VDDR"))/(float)total_vddr))?0:Math.rint((((float)(f_tipo_md_be.getCount("VDDR"))/(float)total_vddr)*100)*100)/100,f_tipo_bs_be.getCount("VDDR"),Double.isNaN(((float)(f_tipo_bs_be.getCount("VDDR"))/(float)total_vddr))?0:Math.rint((((float)(f_tipo_bs_be.getCount("VDDR"))/(float)total_vddr)*100)*100)/100,f_tipo_sj_be.getCount("VDDR"),Double.isNaN(((float)(f_tipo_sj_be.getCount("VDDR"))/(float)total_vddr))?0:Math.rint((((float)(f_tipo_sj_be.getCount("VDDR"))/(float)total_vddr)*100)*100)/100,f_tipo_bi_be.getCount("VDDR"),Double.isNaN(((float)(f_tipo_bi_be.getCount("VDDR"))/(float)total_vddr))?0:Math.rint((((float)(f_tipo_bi_be.getCount("VDDR"))/(float)total_vddr)*100)*100)/100,          f_tipo_vi_be.getCount("VDDR"),Double.isNaN(((float)(f_tipo_vi_be.getCount("VDDR"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_vi_be.getCount("VDDR"))/(float)total_ssi)*100)*100)/100,             total_vddr,0);
		EstadisticasBasicas eb45 = new EstadisticasBasicas("DDD",f_tipo_sg_be.getCount("DDD"),Double.isNaN(((float)(f_tipo_sg_be.getCount("DDD"))/(float)total_ddd))?0:Math.rint((((float)(f_tipo_sg_be.getCount("DDD"))/(float)total_ddd)*100)*100)/100,f_tipo_md_be.getCount("DDD"),Double.isNaN(((float)(f_tipo_md_be.getCount("DDD"))/(float)total_ddd))?0:Math.rint((((float)(f_tipo_md_be.getCount("DDD"))/(float)total_ddd)*100)*100)/100,f_tipo_bs_be.getCount("DDD"),Double.isNaN(((float)(f_tipo_bs_be.getCount("DDD"))/(float)total_ddd))?0:Math.rint((((float)(f_tipo_bs_be.getCount("DDD"))/(float)total_ddd)*100)*100)/100,f_tipo_sj_be.getCount("DDD"),Double.isNaN(((float)(f_tipo_sj_be.getCount("DDD"))/(float)total_ddd))?0:Math.rint((((float)(f_tipo_sj_be.getCount("DDD"))/(float)total_ddd)*100)*100)/100,f_tipo_bi_be.getCount("DDD"),Double.isNaN(((float)(f_tipo_bi_be.getCount("DDD"))/(float)total_ddd))?0:Math.rint((((float)(f_tipo_bi_be.getCount("DDD"))/(float)total_ddd)*100)*100)/100,        f_tipo_vi_be.getCount("DDD"),Double.isNaN(((float)(f_tipo_vi_be.getCount("DDD"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_vi_be.getCount("DDD"))/(float)total_ssi)*100)*100)/100,               total_ddd,0);
		EstadisticasBasicas eb46 = new EstadisticasBasicas("DDDR",f_tipo_sg_be.getCount("DDDR"),Double.isNaN(((float)(f_tipo_sg_be.getCount("DDDR"))/(float)total_dddr))?0:Math.rint((((float)(f_tipo_sg_be.getCount("DDDR"))/(float)total_dddr)*100)*100)/100,f_tipo_md_be.getCount("DDDR"),Double.isNaN(((float)(f_tipo_md_be.getCount("DDDR"))/(float)total_dddr))?0:Math.rint((((float)(f_tipo_md_be.getCount("DDDR"))/(float)total_dddr)*100)*100)/100,f_tipo_bs_be.getCount("DDDR"),Double.isNaN(((float)(f_tipo_bs_be.getCount("DDDR"))/(float)total_dddr))?0:Math.rint((((float)(f_tipo_bs_be.getCount("DDDR"))/(float)total_dddr)*100)*100)/100,f_tipo_sj_be.getCount("DDDR"),Double.isNaN(((float)(f_tipo_sj_be.getCount("DDDR"))/(float)total_dddr))?0:Math.rint((((float)(f_tipo_sj_be.getCount("DDDR"))/(float)total_dddr)*100)*100)/100,f_tipo_bi_be.getCount("DDDR"),Double.isNaN(((float)(f_tipo_bi_be.getCount("DDDR"))/(float)total_dddr))?0:Math.rint((((float)(f_tipo_bi_be.getCount("DDDR"))/(float)total_dddr)*100)*100)/100,  f_tipo_vi_be.getCount("DDDR"),Double.isNaN(((float)(f_tipo_vi_be.getCount("DDDR"))/(float)total_ssi))?0:Math.rint((((float)(f_tipo_vi_be.getCount("DDDR"))/(float)total_ssi)*100)*100)/100,   total_dddr,0);
		EstadisticasBasicas eb47 = new EstadisticasBasicas("DDDRV",f_tipo_sg_be.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_sg_be.getCount("DDDRV"))/(float)total_dddrv))?0:Math.rint((((float)(f_tipo_sg_be.getCount("DDDRV"))/(float)total_dddrv)*100)*100)/100,f_tipo_md_be.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_md_be.getCount("DDDRV"))/(float)total_dddrv))?0:Math.rint((((float)(f_tipo_md_be.getCount("DDDRV"))/(float)total_dddrv)*100)*100)/100,f_tipo_bs_be.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_bs_be.getCount("DDDRV"))/(float)total_dddrv))?0:Math.rint((((float)(f_tipo_bs_be.getCount("DDDRV"))/(float)total_dddrv)*100)*100)/100,f_tipo_sj_be.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_sj_be.getCount("DDDRV"))/(float)total_dddrv))?0:Math.rint((((float)(f_tipo_sj_be.getCount("DDDRV"))/(float)total_dddrv)*100)*100)/100,f_tipo_bi_be.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_bi_be.getCount("DDDRV"))/(float)total_dddrv))?0:Math.rint((((float)(f_tipo_bi_be.getCount("DDDRV"))/(float)total_dddrv)*100)*100)/100,            f_tipo_vi_be.getCount("DDDRV"),Double.isNaN(((float)(f_tipo_vi_be.getCount("DDDRV"))/(float)total_dddrv))?0:Math.rint((((float)(f_tipo_vi_be.getCount("DDDRV"))/(float)total_dddrv)*100)*100)/100,    total_dddrv,0);
		
		EstadisticasBasicas eb48 = new EstadisticasBasicas(
				this.bundle.getString("est_basic_total"),total_sg_be,Double.isNaN(((float)(total_sg_be)/(float)totalbe))?0:Math.rint((((float)(total_sg_be)/(float)totalbe)*100)*100)/100,
				total_md_be,Double.isNaN((((float)total_md_be)/(float)totalbe))?0:Math.rint(((((float)total_md_be)/(float)totalbe)*100)*100)/100,
				total_bs_be,Double.isNaN((((float)total_bs_be)/(float)totalbe))?0:Math.rint(((((float)total_bs_be)/(float)totalbe)*100)*100)/100,
				total_sj_be,Double.isNaN((((float)total_sj_be)/(float)totalbe))?0:Math.rint(((((float)total_sj_be)/(float)totalbe)*100)*100)/100,
				total_bi_be,Double.isNaN((((float)total_bi_be)/(float)totalbe))?0:Math.rint(((((float)total_bi_be)/(float)totalbe)*100)*100)/100,
				total_vi_be,Double.isNaN((((float)total_vi_be)/(float)totalbe))?0:Math.rint(((((float)total_vi_be)/(float)totalbe)*100)*100)/100,
				totalbe,0);		
		this.getImpbetipo().add(eb41);this.getImpbetipo().add(eb42);this.getImpbetipo().add(eb43);this.getImpbetipo().add(eb44);
		this.getImpbetipo().add(eb45);this.getImpbetipo().add(eb46);this.getImpbetipo().add(eb47);this.getImpbetipo().add(eb48);
		
		this.getImpritmo().clear();
		ArrMaestras[] ritmos = maestrasdao.findWhereTipoEquals(13);
		for(int i=0;i<ritmos.length;i++){
			EstadisticasBasicas item = new EstadisticasBasicas(ritmos[i].getValor(),f_ritmo.getCount(ritmos[i].getCodigo()),Double.isNaN(f_ritmo.getPct(ritmos[i].getCodigo()))?0:Math.rint((f_ritmo.getPct(ritmos[i].getCodigo())*100)*100)/100);
			this.impritmo.add(item);
		}
		EstadisticasBasicas item_ritmo = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_ritmo.getCount(0),Double.isNaN(f_ritmo.getPct(0))?0:Math.rint((f_ritmo.getPct(0)*100)*100)/100);
		this.impritmo.add(item_ritmo);
		
		this.getImpcav().clear();
		ArrMaestras[] cavs = maestrasdao.findWhereTipoEquals(14);
		for(int i=0;i<cavs.length;i++){
			EstadisticasBasicas item_cav = new EstadisticasBasicas(cavs[i].getValor(),f_cav.getCount(cavs[i].getCodigo()),Double.isNaN(f_cav.getPct(cavs[i].getCodigo()))?0:Math.rint((f_cav.getPct(cavs[i].getCodigo())*100)*100)/100);
			this.impcav.add(item_cav);
		}
		EstadisticasBasicas item_cavnoesp = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_cav.getCount(0),Double.isNaN(f_cav.getPct(0))?0:Math.rint((f_cav.getPct(0)*100)*100)/100);
		this.impcav.add(item_cavnoesp);
		
		this.getImpqrs().clear();
		ArrMaestras[] qrss = maestrasdao.findWhereTipoEquals(15);
		for(int i=0;i<qrss.length;i++){
			EstadisticasBasicas item_qrs = new EstadisticasBasicas(qrss[i].getValor(),f_qrs.getCount(qrss[i].getCodigo()),Double.isNaN(f_qrs.getPct(qrss[i].getCodigo()))?0:Math.rint((f_qrs.getPct(qrss[i].getCodigo())*100)*100)/100);
			this.impqrs.add(item_qrs);
		}
		EstadisticasBasicas item_qrsnoesp = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_qrs.getCount(0),Double.isNaN(f_qrs.getPct(0))?0:Math.rint((f_qrs.getPct(0)*100)*100)/100);
		this.impqrs.add(item_qrsnoesp);
		// COMPLICACIONES
		for(int i=0;i<comp.size();i++){
			if((Integer)comp.get(i).get(0)!=null)
				f_comp.addValue((Integer)comp.get(i).get(0));
			if((Integer)comp.get(i).get(1)!=null)
				f_comp_tipo.addValue((Integer)comp.get(i).get(1));
		}
		this.getImpcomp().clear();
		//Complicaciones[] comps = compdao.findWhereAmbitoEquals(3);
		Complicaciones[] comps = compdao.findByDynamicWhere("AMBITO = ? OR AMBITO = ?", new Object[]{0,3});
		for(int i=0;i<comps.length;i++){
			if(comps[i].getNombre()!=null){
				EstadisticasBasicas item = new EstadisticasBasicas(comps[i].getNombre(),f_comp.getCount(comps[i].getIdcomplicacion()),Double.isNaN(f_comp.getPct(comps[i].getIdcomplicacion()))?0:Math.rint((f_comp.getPct(comps[i].getIdcomplicacion())*100)*100)/100  );
				this.impcomp.add(item);
			}	
		}
		EstadisticasBasicas eb50 = new EstadisticasBasicas(this.bundle.getString("no_especificado"),f_comp_tipo.getCount(0),Double.isNaN(f_comp_tipo.getPct(0))?0:Math.rint((f_comp_tipo.getPct(0)*100)*100)/100);
		EstadisticasBasicas eb51 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_1"),f_comp_tipo.getCount(1),Double.isNaN(f_comp_tipo.getPct(1))?0:Math.rint((f_comp_tipo.getPct(1)*100)*100)/100);
		EstadisticasBasicas eb52 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_2"),f_comp_tipo.getCount(2),Double.isNaN(f_comp_tipo.getPct(2))?0:Math.rint((f_comp_tipo.getPct(2)*100)*100)/100);
		EstadisticasBasicas eb53 = new EstadisticasBasicas(this.bundle.getString("compli_tipo_3"),f_comp_tipo.getCount(3),Double.isNaN(f_comp_tipo.getPct(3))?0:Math.rint((f_comp_tipo.getPct(3)*100)*100)/100);
		this.getImpcomptipo().add(eb50);this.getImpcomptipo().add(eb51);this.getImpcomptipo().add(eb52);this.getImpcomptipo().add(eb53);
	}
	
	public void pintaGraficaGenProc(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getGenprocs()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataGenProc(new FlotChartRendererData());
		this.chartDataGenProc.setTitle(this.bundle.getString("est_basic_gen_bean_proc_total"));
		this.chartDataGenProc.setWidth("550");
		this.chartDataGenProc.setHeight("250");
		this.chartDataGenProc.setChartType("pie");
		if(this.valoresgenproc!=null)
			this.valoresgenproc.clear();
		this.valoresgenproc = listaesta;
	}
	public void pintaGraficaGenSegs(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getGensegs()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpSegDisp(new FlotChartRendererData());
		this.chartDataImpSegDisp.setTitle(this.bundle.getString("est_basic_gen_bean_impseg"));
		this.chartDataImpSegDisp.setWidth("450");
		this.chartDataImpSegDisp.setHeight("250");
		if(this.valoressegdisp!=null)
			this.valoressegdisp.clear();
		this.valoressegdisp = listaesta;
	}
	public void pintaGraficaGenProcComp(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getGenprocscomp()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataGenProcComp(new FlotChartRendererData());
		this.chartDataGenProcComp.setTitle(this.bundle.getString("compli_proc_title"));
		this.chartDataGenProcComp.setWidth("550");
		this.chartDataGenProcComp.setHeight("250");
		this.chartDataGenProcComp.setChartType("pie");
		if(this.valoresgenproccomp!=null)
			this.valoresgenproccomp.clear();
		this.valoresgenproccomp = listaesta;
	}
	public void pintaGraficaGenTipoComp(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getGentipocomp()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataGenTipoComp(new FlotChartRendererData());
		this.chartDataGenTipoComp.setTitle(this.bundle.getString("compli_est_tipo"));
		this.chartDataGenTipoComp.setWidth("550");
		this.chartDataGenTipoComp.setHeight("250");
		this.chartDataGenTipoComp.setChartType("pie");
		if(this.valoresgentipocomp!=null)
			this.valoresgentipocomp.clear();
		this.valoresgentipocomp = listaesta;
	}
	public void pintaGraficaGenSegsRem(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getGensegsrem()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataGenSegs(new FlotChartRendererData());
		this.chartDataGenSegs.setTitle(this.bundle.getString("est_basic_imp_bean_segtipo"));
		this.chartDataGenSegs.setWidth("550");
		this.chartDataGenSegs.setHeight("250");
		if(this.valoressegs!=null)
			this.valoressegs.clear();
		this.valoressegs = listaesta;
	}
	public void pintaGraficaGenPatSexo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getGenpatsexo()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataGenSexo(new FlotChartRendererData());
		this.chartDataGenSexo.setTitle(this.bundle.getString("pat_consulta_sexo"));
		this.chartDataGenSexo.setWidth("550");
		this.chartDataGenSexo.setHeight("250");
		if(this.valoresgensexo!=null)
			this.valoresgensexo.clear();
		this.valoresgensexo = listaesta;
	}
	public void pintaGraficaGenPatCar(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getGenpatcar()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataGenCarProc(new FlotChartRendererData());
		this.chartDataGenCarProc.setTitle(this.bundle.getString("pat_demograficos_msg_4"));
		this.chartDataGenCarProc.setWidth("550");
		this.chartDataGenCarProc.setHeight("250");
		if(this.valorescarproc!=null)
			this.valorescarproc.clear();
		this.valorescarproc = listaesta;
	}
	public void pintaGraficaEefCar(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getEefcar()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEefReal(new FlotChartRendererData());
		this.chartDataEefReal.setTitle(this.bundle.getString("est_basic_eef_bean_realizados"));
		this.chartDataEefReal.setWidth("550");
		if(this.valoreseefreal!=null)
			this.valoreseefreal.clear();
		this.valoreseefreal = listaesta;
	}
	public void pintaGraficaEefDiag(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getEefdiag()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEefDiag(new FlotChartRendererData());
		this.chartDataEefDiag.setTitle(this.bundle.getString("eef_tab_plantilla_diagn"));
		this.chartDataEefDiag.setWidth("850");
		if(this.valoreseefdiag!=null)
			this.valoreseefdiag.clear();
		this.valoreseefdiag = listaesta;
	}
	public void pintaGraficaEefIntento(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getEefint()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEefAblNo(new FlotChartRendererData());
		this.chartDataEefAblNo.setTitle(this.bundle.getString("est_basic_eef_bean_inte_abl"));
		this.chartDataEefAblNo.setWidth("550");
		if(this.valoreseefablno!=null)
			this.valoreseefablno.clear();
		this.valoreseefablno = listaesta;
	}
	public void pintaGraficaEefAblSust(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getEefablsust()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEefSust(new FlotChartRendererData());
		this.chartDataEefSust.setTitle(this.bundle.getString("est_basic_eef_bean_abl_sust"));
		this.chartDataEefSust.setWidth("800");
		if(this.valoreseefsust!=null)
			this.valoreseefsust.clear();
		this.valoreseefsust = listaesta;
	}
	public void pintaGraficaEefAblRes(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getEefablres()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEefRes(new FlotChartRendererData());
		this.chartDataEefRes.setTitle(this.bundle.getString("est_basic_eef_bean_abl_res"));
		this.chartDataEefRes.setWidth("550");
		if(this.valoreseefres!=null)
			this.valoreseefres.clear();
		this.valoreseefres = listaesta;
	}
	public void pintaGraficaEefCompDiag(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getEefcompdiag()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEefCompDiag(new FlotChartRendererData());
		this.chartDataEefCompDiag.setTitle(this.bundle.getString("compli_proc_eef_diag_title"));
		this.chartDataEefCompDiag.setWidth("550");
		if(this.valoreseefcompdiag!=null)
			this.valoreseefcompdiag.clear();
		this.valoreseefcompdiag = listaesta;
	}
	public void pintaGraficaEefCompAbl(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getEefcompabl()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEefCompAbl(new FlotChartRendererData());
		this.chartDataEefCompAbl.setTitle(this.bundle.getString("compli_proc_eef_abl_title"));
		this.chartDataEefCompAbl.setWidth("650");
		if(this.valoreseefcompabl!=null)
			this.valoreseefcompabl.clear();
		this.valoreseefcompabl = listaesta;
	}
	public void pintaGraficaEefCompTipoDiag(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getEefcompdiagtipo()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEefCompTipoDiag(new FlotChartRendererData());
		this.chartDataEefCompTipoDiag.setTitle(this.bundle.getString("compli_est_tipo"));
		this.chartDataEefCompTipoDiag.setWidth("550");
		if(this.valoreseefcomptipodiag!=null)
			this.valoreseefcomptipodiag.clear();
		this.valoreseefcomptipodiag = listaesta;
	}
	public void pintaGraficaEefCompTipoAbl(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getEefcompabltipo()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEefCompTipoAbl(new FlotChartRendererData());
		this.chartDataEefCompTipoAbl.setTitle(this.bundle.getString("compli_est_tipo"));
		this.chartDataEefCompTipoAbl.setWidth("550");
		if(this.valoreseefcomptipoabl!=null)
			this.valoreseefcomptipoabl.clear();
		this.valoreseefcomptipoabl = listaesta;
	}
	public void pintaGraficaImpProcsDisp(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Este hay que hacerlo de otra manera ya que la disposicion de la grafica es diferente presentando el total
		for(int i=0;i<this.getImpproc().size()-1;i++){
			XYDataList l = new XYDataList();
			//XYDataPoint item = new XYDataPoint(0, this.getImpproc().get(i).getNumero9());
			XYDataPoint item = new XYDataPoint(0, this.getImpproc().get(i).getNumero5());
			l.addDataPoint(item);
			l.setLabel(this.getImpproc().get(i).getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpDisp(new FlotChartRendererData());
		this.chartDataImpDisp.setTitle(this.bundle.getString("est_basic_imp_bean_tipodispimp"));
		this.chartDataImpDisp.setWidth("550");
		if(this.valoresimpdisp!=null)
			this.valoresimpdisp.clear();
		this.valoresimpdisp = listaesta;
	}
	public void pintaGraficaImpReintProcsDisp(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Este hay que hacerlo de otra manera ya que la disposicion de la grafica es diferente presentando el total
		for(int i=0;i<this.getImpreintproc().size()-1;i++){
			XYDataList l = new XYDataList();
			//XYDataPoint item = new XYDataPoint(0, this.getImpproc().get(i).getNumero9());
			XYDataPoint item = new XYDataPoint(0, this.getImpreintproc().get(i).getNumero5());
			l.addDataPoint(item);
			l.setLabel(this.getImpreintproc().get(i).getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpReintDisp(new FlotChartRendererData());
		this.chartDataImpReintDisp.setTitle(this.bundle.getString("est_basic_imp_bean_tipodispimp"));
		this.chartDataImpReintDisp.setWidth("550");
		if(this.valoresimpreintdisp!=null)
			this.valoresimpreintdisp.clear();
		this.valoresimpreintdisp = listaesta;
	}
	public void pintaGraficaImpProcsTipo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Aqui solo interesa el ultimo item de la lisya impproc
		XYDataList l = new XYDataList();
		XYDataPoint item = new XYDataPoint(0, this.getImpproc().get(4).getNumero());
		l.addDataPoint(item);
		l.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_prim"));
		listaesta.add(l);
		XYDataList l1 = new XYDataList();
		XYDataPoint item1 = new XYDataPoint(0, this.getImpproc().get(4).getNumero2());
		l1.addDataPoint(item1);
		l1.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_recam"));
		listaesta.add(l1);
		XYDataList l2 = new XYDataList();
		XYDataPoint item2 = new XYDataPoint(0, this.getImpproc().get(4).getNumero3());
		l2.addDataPoint(item2);
		l2.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_upgrd"));
		listaesta.add(l2);	
		XYDataList l3 = new XYDataList();
		XYDataPoint item3 = new XYDataPoint(0, this.getImpproc().get(4).getNumero4());
		l3.addDataPoint(item3);
		l3.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_reimpl"));
		listaesta.add(l3);	
		/*XYDataList l4 = new XYDataList();
		XYDataPoint item4 = new XYDataPoint(0, this.getImpproc().get(4).getNumero5());
		l4.addDataPoint(item4);
		l4.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_expl"));
		listaesta.add(l4);
		XYDataList l5 = new XYDataList();
		XYDataPoint item5 = new XYDataPoint(0, this.getImpproc().get(4).getNumero6());
		l5.addDataPoint(item5);
		l5.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_recolgen"));
		listaesta.add(l5);
		XYDataList l6 = new XYDataList();
		XYDataPoint item6 = new XYDataPoint(0, this.getImpproc().get(4).getNumero7());
		l6.addDataPoint(item6);
		l6.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_recolelec"));
		listaesta.add(l6);
		XYDataList l7 = new XYDataList();
		XYDataPoint item7 = new XYDataPoint(0, this.getImpproc().get(4).getNumero8());
		l7.addDataPoint(item7);
		l7.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_reinter"));
		listaesta.add(l7);*/
		
		this.setChartDataImpProc(new FlotChartRendererData());
		this.chartDataImpProc.setTitle(this.bundle.getString("est_basic_imp_bean_dispimptipos"));
		this.chartDataImpProc.setWidth("550");
		if(this.valoresimpproc!=null)
			this.valoresimpproc.clear();
		this.valoresimpproc = listaesta;
	}
	public void pintaGraficaImpReintProcsTipo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Aqui solo interesa el ultimo item de la lisya impproc
		XYDataList l = new XYDataList();
		XYDataPoint item = new XYDataPoint(0, this.getImpreintproc().get(4).getNumero());
		l.addDataPoint(item);
		l.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_reinter"));
		listaesta.add(l);
		XYDataList l1 = new XYDataList();
		XYDataPoint item1 = new XYDataPoint(0, this.getImpreintproc().get(4).getNumero2());
		l1.addDataPoint(item1);
		l1.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_recolgen"));
		listaesta.add(l1);
		XYDataList l2 = new XYDataList();
		XYDataPoint item2 = new XYDataPoint(0, this.getImpreintproc().get(4).getNumero3());
		l2.addDataPoint(item2);
		l2.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_recolelec"));
		listaesta.add(l2);	
		XYDataList l3 = new XYDataList();
		XYDataPoint item3 = new XYDataPoint(0, this.getImpreintproc().get(4).getNumero4());
		l3.addDataPoint(item3);
		l3.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_expl"));
		listaesta.add(l3);	
		/*XYDataList l4 = new XYDataList();
		XYDataPoint item4 = new XYDataPoint(0, this.getImpproc().get(4).getNumero5());
		l4.addDataPoint(item4);
		l4.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_expl"));
		listaesta.add(l4);
		XYDataList l5 = new XYDataList();
		XYDataPoint item5 = new XYDataPoint(0, this.getImpproc().get(4).getNumero6());
		l5.addDataPoint(item5);
		l5.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_recolgen"));
		listaesta.add(l5);
		XYDataList l6 = new XYDataList();
		XYDataPoint item6 = new XYDataPoint(0, this.getImpproc().get(4).getNumero7());
		l6.addDataPoint(item6);
		l6.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_recolelec"));
		listaesta.add(l6);
		XYDataList l7 = new XYDataList();
		XYDataPoint item7 = new XYDataPoint(0, this.getImpproc().get(4).getNumero8());
		l7.addDataPoint(item7);
		l7.setLabel(this.bundle.getString("est_basic_imp_bean_dispimptipos_reinter"));
		listaesta.add(l7);*/
		
		this.setChartDataImpReintProc(new FlotChartRendererData());
		this.chartDataImpReintProc.setTitle(this.bundle.getString("est_basic_imp_bean_dispimptipos"));
		this.chartDataImpReintProc.setWidth("550");
		if(this.valoresimpreintproc!=null)
			this.valoresimpreintproc.clear();
		this.valoresimpreintproc = listaesta;
	}
	public void pintaGraficaImpBeFab(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Este hay que hacerlo de otra manera ya que la disposicion de la grafica es diferente presetnado el total
		for(int i=0;i<this.getImpbefab().size()-1;i++){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, this.getImpbefab().get(i).getNumero8());
			l.addDataPoint(item);
			l.setLabel(this.getImpbefab().get(i).getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpBeFabTipo(new FlotChartRendererData());
		this.chartDataImpBeFabTipo.setTitle(this.bundle.getString("est_basic_imp_bean_tipo_baja_ener"));
		this.chartDataImpBeFabTipo.setWidth("550");
		if(this.valoresimpbefabtipo!=null)
			this.valoresimpbefabtipo.clear();
		this.valoresimpbefabtipo = listaesta;
	}
	public void pintaGraficaImpBeFab2(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Este hay que hacerlo de otra manera ya que la disposicion de la grafica es diferente presetnado el total
		for(int i=0;i<this.getImpbetipo().size()-1;i++){
			XYDataList l = new XYDataList();
			//XYDataPoint item = new XYDataPoint(0, this.getImpbetipo().get(i).getNumero6());
			XYDataPoint item = new XYDataPoint(0, this.getImpbetipo().get(i).getNumero7());
			l.addDataPoint(item);
			l.setLabel(this.getImpbetipo().get(i).getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpBeTipoFab(new FlotChartRendererData());
		this.chartDataImpBeTipoFab.setTitle(this.bundle.getString("est_basic_imp_bean_tipo_baja_ener"));
		this.chartDataImpBeTipoFab.setWidth("550");
		if(this.valoresimpbetipofab!=null)
			this.valoresimpbetipofab.clear();
		this.valoresimpbetipofab = listaesta;
	}
	public void pintaGraficaImpBeTipo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Aqui solo interesa el ultimo item de la lisya impproc
		XYDataList l = new XYDataList();
		XYDataPoint item = new XYDataPoint(0, this.getImpbefab().get(5).getNumero());
		l.addDataPoint(item);
		l.setLabel("SSI");
		listaesta.add(l);
		XYDataList l1 = new XYDataList();
		XYDataPoint item1 = new XYDataPoint(0, this.getImpbefab().get(5).getNumero2());
		l1.addDataPoint(item1);
		l1.setLabel("SSIR");
		listaesta.add(l1);
		XYDataList l2 = new XYDataList();
		XYDataPoint item2 = new XYDataPoint(0, this.getImpbefab().get(5).getNumero3());
		l2.addDataPoint(item2);
		l2.setLabel("VDD");
		listaesta.add(l2);
		XYDataList l3 = new XYDataList();
		XYDataPoint item3 = new XYDataPoint(0, this.getImpbefab().get(5).getNumero4());
		l3.addDataPoint(item3);
		l3.setLabel("VDDR");
		listaesta.add(l3);		
		XYDataList l4 = new XYDataList();
		XYDataPoint item4 = new XYDataPoint(0, this.getImpbefab().get(5).getNumero5());
		l4.addDataPoint(item4);
		l4.setLabel("DDD");
		listaesta.add(l4);		
		XYDataList l5 = new XYDataList();
		XYDataPoint item5 = new XYDataPoint(0, this.getImpbefab().get(5).getNumero6());
		l5.addDataPoint(item5);
		l5.setLabel("DDDR");
		listaesta.add(l5);		
		XYDataList l6 = new XYDataList();
		XYDataPoint item6 = new XYDataPoint(0, this.getImpbefab().get(5).getNumero7());
		l6.addDataPoint(item6);
		l6.setLabel("CRTP");
		listaesta.add(l6);
		this.setChartDataImp(new FlotChartRendererData());
		this.chartDataImp.setTitle(this.bundle.getString("est_basic_imp_bean_tipo_disp_fab"));
		this.chartDataImp.setWidth("550");
		if(this.valores!=null)
			this.valores.clear();
		this.valores = listaesta;
	}
	public void pintaGraficaImpBeTipo2(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Aqui solo interesa el ultimo item de la lisya impproc
		XYDataList l = new XYDataList();
		XYDataPoint item = new XYDataPoint(0, this.getImpbetipo().get(7).getNumero());
		l.addDataPoint(item);
		l.setLabel("Sorin Group");
		listaesta.add(l);
		XYDataList l1 = new XYDataList();
		XYDataPoint item1 = new XYDataPoint(0, this.getImpbetipo().get(7).getNumero2());
		l1.addDataPoint(item1);
		l1.setLabel("Medtronic");
		listaesta.add(l1);
		XYDataList l2 = new XYDataList();
		XYDataPoint item2 = new XYDataPoint(0, this.getImpbetipo().get(7).getNumero3());
		l2.addDataPoint(item2);
		l2.setLabel("Boston Scientific");
		listaesta.add(l2);
		XYDataList l3 = new XYDataList();
		XYDataPoint item3 = new XYDataPoint(0, this.getImpbetipo().get(7).getNumero4());
		l3.addDataPoint(item3);
		l3.setLabel("Saint Jude Medical");
		listaesta.add(l3);		
		XYDataList l4 = new XYDataList();
		XYDataPoint item4 = new XYDataPoint(0, this.getImpbetipo().get(7).getNumero5());
		l4.addDataPoint(item4);
		l4.setLabel("Biotronik");
		listaesta.add(l4);				
		this.setChartDataImp(new FlotChartRendererData());
		this.chartDataImp.setTitle(this.bundle.getString("est_basic_imp_bean_fab"));
		this.chartDataImp.setWidth("550");
		if(this.valores!=null)
			this.valores.clear();
		this.valores = listaesta;
	}
	public void pintaGraficaImpAeFab(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Este hay que hacerlo de otra manera ya que la disposicion de la grafica es diferente presetnado el total
		for(int i=0;i<this.getImpaefab().size()-1;i++){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, this.getImpaefab().get(i).getNumero4());
			l.addDataPoint(item);
			l.setLabel(this.getImpaefab().get(i).getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpAeFabTipo(new FlotChartRendererData());
		this.chartDataImpAeFabTipo.setTitle(this.bundle.getString("est_basic_imp_bean_tipo_alta_ener"));
		this.chartDataImpAeFabTipo.setWidth("550");
		if(this.valoresimpaefabtipo!=null)
			this.valoresimpaefabtipo.clear();
		this.valoresimpaefabtipo = listaesta;
	}
	public void pintaGraficaImpAeFab2(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Este hay que hacerlo de otra manera ya que la disposicion de la grafica es diferente presetnado el total
		for(int i=0;i<this.getImpaetipo().size()-1;i++){
			XYDataList l = new XYDataList();
			//XYDataPoint item = new XYDataPoint(0, this.getImpaetipo().get(i).getNumero6());
			XYDataPoint item = new XYDataPoint(0, this.getImpaetipo().get(i).getNumero7());
			l.addDataPoint(item);
			l.setLabel(this.getImpaetipo().get(i).getTipo());
			listaesta.add(l);
		}
		this.setChartImpAeTipoFab(new FlotChartRendererData());
		this.chartImpAeTipoFab.setTitle(this.bundle.getString("est_basic_imp_bean_tipo_alta_ener"));
		this.chartImpAeTipoFab.setWidth("550");
		if(this.valoresimpaetipofab!=null)
			this.valoresimpaetipofab.clear();
		this.valoresimpaetipofab = listaesta;
	}
	public void pintaGraficaImpAeTipo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Aqui solo interesa el ultimo item de la lisya impproc
		XYDataList l = new XYDataList();
		XYDataPoint item = new XYDataPoint(0, this.getImpaefab().get(5).getNumero());
		l.addDataPoint(item);
		l.setLabel("VR");
		listaesta.add(l);
		XYDataList l1 = new XYDataList();
		XYDataPoint item1 = new XYDataPoint(0, this.getImpaefab().get(5).getNumero2());
		l1.addDataPoint(item1);
		l1.setLabel("DR");
		listaesta.add(l1);
		XYDataList l2 = new XYDataList();
		XYDataPoint item2 = new XYDataPoint(0, this.getImpaefab().get(5).getNumero3());
		l2.addDataPoint(item2);
		l2.setLabel("CRTD");
		listaesta.add(l2);
		
		this.setChartDataImp(new FlotChartRendererData());
		this.chartDataImp.setTitle(this.bundle.getString("est_basic_imp_bean_tipo_disp_fab"));
		this.chartDataImp.setWidth("550");
		if(this.valores!=null)
			this.valores.clear();
		this.valores = listaesta;
	}
	public void pintaGraficaImpAeTipo2(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		// Aqui solo interesa el ultimo item de la lisya impproc
		XYDataList l = new XYDataList();
		XYDataPoint item = new XYDataPoint(0, this.getImpaetipo().get(3).getNumero());
		l.addDataPoint(item);
		l.setLabel("Sorin Group");
		listaesta.add(l);
		XYDataList l1 = new XYDataList();
		XYDataPoint item1 = new XYDataPoint(0, this.getImpaetipo().get(3).getNumero2());
		l1.addDataPoint(item1);
		l1.setLabel("Medtronic");
		listaesta.add(l1);
		XYDataList l2 = new XYDataList();
		XYDataPoint item2 = new XYDataPoint(0, this.getImpaetipo().get(3).getNumero3());
		l2.addDataPoint(item2);
		l2.setLabel("Boston Scientific");
		listaesta.add(l2);
		XYDataList l3 = new XYDataList();
		XYDataPoint item3 = new XYDataPoint(0, this.getImpaetipo().get(3).getNumero4());
		l3.addDataPoint(item3);
		l3.setLabel("Saint Jude Medical");
		listaesta.add(l3);		
		XYDataList l4 = new XYDataList();
		XYDataPoint item4 = new XYDataPoint(0, this.getImpaetipo().get(3).getNumero5());
		l4.addDataPoint(item4);
		l4.setLabel("Biotronik");
		listaesta.add(l4);				
		this.setChartDataImp(new FlotChartRendererData());
		this.chartDataImp.setTitle(this.bundle.getString("est_basic_imp_bean_fab"));
		this.chartDataImp.setWidth("550");
		if(this.valores!=null)
			this.valores.clear();
		this.valores = listaesta;
	}
	public void pintaGraficaImpRitmo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getImpritmo()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpRitmo(new FlotChartRendererData());
		this.chartDataImpRitmo.setTitle(this.bundle.getString("sc_ecg_ritmo"));
		this.chartDataImpRitmo.setWidth("650");
		if(this.valoresimpritmo!=null)
			this.valoresimpritmo.clear();
		this.valoresimpritmo = listaesta;
	}
	public void pintaGraficaImpCav(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getImpcav()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpCav(new FlotChartRendererData());
		this.chartDataImpCav.setTitle(this.bundle.getString("sc_ecg_cav"));
		this.chartDataImpCav.setWidth("550");
		if(this.valoresimpcav!=null)
			this.valoresimpcav.clear();
		this.valoresimpcav = listaesta;
	}
	public void pintaGraficaImpQrs(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getImpqrs()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpQrs(new FlotChartRendererData());
		this.chartDataImpQrs.setTitle(this.bundle.getString("sc_ecg_qrs"));
		this.chartDataImpQrs.setWidth("650");
		this.chartDataImpQrs.setHeight("400");
		if(this.valoresimpqrs!=null)
			this.valoresimpqrs.clear();
		this.valoresimpqrs = listaesta;
	}
	public void pintaGraficaImpComp(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getImpcomp()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpComp(new FlotChartRendererData());
		this.chartDataImpComp.setTitle(this.bundle.getString("compli_proc_title"));
		this.chartDataImpComp.setWidth("650");
		this.chartDataImpComp.setHeight("400");
		if(this.valoresimpcomp!=null)
			this.valoresimpcomp.clear();
    	this.valoresimpcomp = listaesta;
	}
	public void pintaGraficaImpCompTipo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getImpcomptipo()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataImpCompTipo(new FlotChartRendererData());
		this.chartDataImpCompTipo.setTitle(this.bundle.getString("compli_est_tipo"));
		this.chartDataImpCompTipo.setWidth("650");
		this.chartDataImpCompTipo.setHeight("350");
		if(this.valoresimpcomptipo!=null)
			this.valoresimpcomptipo.clear();
    	this.valoresimpcomptipo = listaesta;
	}
	public void pintaGraficaMesaRes(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getMesares()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataMesaRes(new FlotChartRendererData());
		this.chartDataMesaRes.setTitle(this.bundle.getString("mesa_tab3_res_title"));
		if(this.valoresmesares!=null)
			this.valoresmesares.clear();
		this.valoresmesares = listaesta;
	}
	public void pintaGraficaRegInd(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getRegind()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataRegInd(new FlotChartRendererData());
		this.chartDataRegInd.setTitle(this.bundle.getString("regev_tab1_reg_ind"));
		if(this.valoresregind!=null)
			this.valoresregind.clear();
		this.valoresregind = listaesta;
	}
	public void pintaGraficaRegMot(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getRegmot()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}	
		this.setChartDataRegDiag(new FlotChartRendererData());
		this.chartDataRegDiag.setTitle(this.bundle.getString("regev_tab5_exp_motivo"));
		if(this.valoresregdiag!=null)
			this.valoresregdiag.clear();
		this.valoresregdiag = listaesta;
	}
	public void pintaGraficaRegFab(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getRegfab()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}	
		this.setChartDataRegFab(new FlotChartRendererData());
		this.chartDataRegFab.setTitle(this.bundle.getString("est_basic_tab_regev_fabricante"));
		if(this.valoresregfab!=null)
			this.valoresregfab.clear();
		this.valoresregfab = listaesta;
	}
	public void pintaGraficaRegComp(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getRegcomp()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataRegComp(new FlotChartRendererData());
		this.chartDataRegComp.setTitle(this.bundle.getString("compli_proc_title"));
		this.chartDataRegComp.setWidth("650");
		this.chartDataRegComp.setHeight("400");
		if(this.valoresregcomp!=null)
			this.valoresregcomp.clear();
    	this.valoresregcomp = listaesta;
	}
	public void pintaGraficaRegCompTipo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getRegcomptipo()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataRegCompTipo(new FlotChartRendererData());
		this.chartDataRegCompTipo.setTitle(this.bundle.getString("compli_est_tipo"));
		this.chartDataRegCompTipo.setWidth("650");
		this.chartDataRegCompTipo.setHeight("350");
		if(this.valoresregcomptipo!=null)
			this.valoresregcomptipo.clear();
    	this.valoresregcomptipo = listaesta;
	}
	public void pintaGraficaHolDiagFin(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getHoldiagfin()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}	
		this.setChartDataHolDiagFin(new FlotChartRendererData());
		this.chartDataHolDiagFin.setTitle(this.bundle.getString("holter24h_tab3_ana_diag_fin"));
		if(this.valoresholdiagfin!=null)
			this.valoresholdiagfin.clear();
		this.valoresholdiagfin = listaesta;
	}
	public void pintaGraficaRegEvExtDiagFin(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getRegevextdiagfin()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}	
		this.setChartDataRegEvExtDiagFin(new FlotChartRendererData());
		this.chartDataRegEvExtDiagFin.setTitle(this.bundle.getString("elr_tab3_ana_diag_fin"));
		if(this.valoresregevextdiagfin!=null)
			this.valoresregevextdiagfin.clear();
		this.valoresregevextdiagfin = listaesta;
	}
	public void pintaGraficaTestAtp1(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getTestatp1()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero3());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataAtpRes(null);	
		this.setChartDataAtpRes(new FlotChartRendererData());
		this.chartDataAtpRes.setTitle(this.bundle.getString("est_basic_bean_test_atp"));
		if(this.valoresatpres!=null)
			this.valoresatpres.clear();
		this.valoresatpres = listaesta;
	}
	public void pintaGraficaTestFle(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getTestfle()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataFleRes(new FlotChartRendererData());
		this.chartDataFleRes.setTitle(this.bundle.getString("est_basica_bean_test_fle"));
		if(this.valoresfleres!=null)
			this.valoresfleres.clear();
		this.valoresfleres = listaesta;
	}
	public void pintaGraficaTestEpi(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getTestepi()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataEpiRes(new FlotChartRendererData());
		this.chartDataEpiRes.setTitle(this.bundle.getString("est_basica_bean_test_epi"));
		if(this.valoresepires!=null)
			this.valoresepires.clear();
		this.valoresepires = listaesta;
	}
	public void pintaGraficaCvIndicacion(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getCvind()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataCvInd(new FlotChartRendererData());
		this.chartDataCvInd.setTitle(this.bundle.getString("est_basic_tab_cve_indicacion"));
		this.chartDataCvInd.setWidth("550");
		this.chartDataCvInd.setHeight("250");
		if(this.valorescvind!=null)
			this.valorescvind.clear();
		this.valorescvind = listaesta;
	}
	public void pintaGraficaCvResultado(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getCvres()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDataCvExito(new FlotChartRendererData());
		this.chartDataCvExito.setTitle(this.bundle.getString("est_basic_tab_cve_resultado"));
		this.chartDataCvExito.setWidth("550");
		this.chartDataCvExito.setHeight("250");
		if(this.valorescvexito!=null)
			this.valorescvexito.clear();
    	this.valorescvexito = listaesta;
	}
	public void pintaGraficaCvAblacion(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getCvabl()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDatacvAbl(new FlotChartRendererData());
		this.chartDatacvAbl.setTitle(this.bundle.getString("est_basic_tab_cve_ablacion"));
		this.chartDatacvAbl.setWidth("550");
		this.chartDatacvAbl.setHeight("250");
		if(this.valorescvabl!=null)
			this.valorescvabl.clear();
    	this.valorescvabl = listaesta;
	}
	public void pintaGraficaCvTipo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getCvtipo()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDatacvTipo(new FlotChartRendererData());
		this.chartDatacvTipo.setTitle(this.bundle.getString("est_basic_tab_cve_tipoproc"));
		this.chartDatacvTipo.setWidth("550");
		this.chartDatacvTipo.setHeight("250");
		if(this.valorescvtipo!=null)
			this.valorescvtipo.clear();
    	this.valorescvtipo = listaesta;
	}
	public void pintaGraficaCvComp(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getCvcomp()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDatacvComp(new FlotChartRendererData());
		this.chartDatacvComp.setTitle(this.bundle.getString("compli_proc_title"));
		this.chartDatacvComp.setWidth("650");
		this.chartDatacvComp.setHeight("350");
		if(this.valorescvcomp!=null)
			this.valorescvcomp.clear();
    	this.valorescvcomp = listaesta;
	}
	public void pintaGraficaCvCompTipo(ActionEvent e){
		ArrayList<XYDataList> listaesta = new ArrayList<XYDataList>();
		for(EstadisticasBasicas i:this.getCvcomptipo()){
			XYDataList l = new XYDataList();
			XYDataPoint item = new XYDataPoint(0, i.getNumero());
			l.addDataPoint(item);
			l.setLabel(i.getTipo());
			listaesta.add(l);
		}
		this.setChartDatacvCompTipo(new FlotChartRendererData());
		this.chartDatacvCompTipo.setTitle(this.bundle.getString("compli_est_tipo"));
		this.chartDatacvCompTipo.setWidth("650");
		this.chartDatacvCompTipo.setHeight("350");
		if(this.valorescvcomptipo!=null)
			this.valorescvcomptipo.clear();
    	this.valorescvcomptipo = listaesta;
	}
	public void generaEstadistica(ActionEvent e){
		if(this.selectedParamsKeys.size()>0){
			
			if(this.cImp){
				generaConsulta1();
			}
			if(this.cEF){
				generaConsulta1();
			}
			if(this.cDemo){
				generaConsulta1();
			}
			if(this.cSitclin && !this.cImp && !this.cEF){// consulta generica de pacientes sin filtro de procedidmineot
				generaConsultaSitclinGeneral();
			}
		}else{
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("est_basic_msg_error_ver_2"));
		}
		
	}
	public void generaConsultaSitclinGeneral(){
		try {
			SituacionClinicaGeneral[] stcl = this.sitclindao.findAll();
			analizaResultadosSitclin(stcl);
			System.out.println();
		} catch (SituacionClinicaGeneralDaoException e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver_3")+": "+e.fillInStackTrace());
			logger.error("No se puede generar la consulta. Motivo: "+e.fillInStackTrace());
			e.printStackTrace();
		}
	}
	
	
	public void generaConsulta1(){
		try {
			Procedimiento[] prs = this.procdao.findAll();
			Frequency f = new Frequency();
			for(Procedimiento p:prs){
				 f.addValue(new Integer(p.getTipoprocedimiento()));
			}
			String res = "Total procedimientos: "+prs.length+"\n"
					+"EEF: "+f.getCount(1061)+"\n"
					+"Primo implantes: "+f.getCount(956);
			this.setRestexto(res);
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("est_basic_msg_error_ver_3")+": "+e1.fillInStackTrace());
			logger.error("No se puede generar la consulta. Motivo: "+e1.fillInStackTrace());
			e1.printStackTrace();
		}
	}
	/**
	 * Metodo para analizar y devolver en pantalla resultados de analisis de Situacion clinica general
	 * @param st
	 */
	public void analizaResultadosSitclin(SituacionClinicaGeneral[] st){		
		Frequency f_nyha = new Frequency();
		Frequency f_cardio = new Frequency();
		Frequency f_insrenal = new Frequency();
		for(SituacionClinicaGeneral s:st){
			for(String s1:this.selectedParamsKeys){
				if(s1.equals("3.3") && s.getNyha()!=null){// NYHA - vble discreta
					f_nyha.addValue(s.getNyha());
				}else if(s1.equals("3.4")&& s.getCardiopatia()!=null){ // Cardiopatia - vble discreta
					f_cardio.addValue(s.getCardiopatia());
				}else if(s1.equals("3.5")&& s.getInsrenal()!=null){ // Ins renal - vble discreta
					f_insrenal.addValue(s.getInsrenal());
				}
			}
		}
	}

	public int getTipoconsulta() {
		return tipoconsulta;
	}

	public void setTipoconsulta(int tipoconsulta) {
		this.tipoconsulta = tipoconsulta;
	}


	public String getRestexto() {
		return restexto;
	}


	public void setRestexto(String restexto) {
		this.restexto = restexto;
	}
	
	public void delParam(ActionEvent e){
		this.selectedParams.remove(this.bindingGrid.getRowIndex());
		actualizaTipoconsulta();
	}
	// Gestion Tree
	private void addNodes(String path, TreeNode node, Properties properties) {
        boolean end = false;
        int counter = 1;
        
        while (!end) {
            String key = path != null ? path + '.' + counter : String.valueOf(counter);

            String value = properties.getProperty(key);
            if (value != null) {
                TreeNodeImpl nodeImpl = new TreeNodeImpl();
                nodeImpl.setData(value);
                node.addChild(new Integer(counter), nodeImpl);
                addNodes(key, nodeImpl, properties);
                counter++;
            } else {
                end = true;
            }
        }
    }
    
    private void loadTree() {
        try {
          rootNode = new TreeNodeImpl();
          addNodes(null, rootNode, this.p_est);          
        } catch (Exception e) {
            throw new FacesException(e.getMessage(), e);
        } 
    }
    
    public void processSelection(NodeSelectedEvent event) {
        HtmlTree tree = (HtmlTree) event.getComponent();
        nodeTitle = (String) tree.getRowData();
        selectedNodeChildren.clear();
        //this.selectedParams.clear();
        //this.selectedParamsKeys.clear();
        TreeNode currentNode = tree.getModelTreeNode(tree.getRowKey());
        if(currentNode.isLeaf()){
            selectedNodeChildren.add((String)currentNode.getData());
            this.selectedParams.add((String) currentNode.getData());
            this.selectedParamsKeys.add(this.c_est.getProperty((String) currentNode.getData()));
            actualizaTipoconsulta();
        }else{
            Iterator<Map.Entry<Object, TreeNode>> it = currentNode.getChildren();
            while (it!=null &&it.hasNext()){
                Map.Entry<Object, TreeNode> entry = it.next();
                selectedNodeChildren.add(entry.getValue().getData().toString()); 
            }
        }
    }   
    private void actualizaTipoconsulta(){
    	this.cImp=false;this.cEF = false;this.cDemo=false;this.cSitclin=false;
    	for(String s:this.selectedParamsKeys){
			if(s.startsWith("1.1"))
				this.cImp=true;
			else if(s.startsWith("1.2"))
				this.cEF = true;
			else if(s.startsWith("2"))
				this.cDemo = true;
			else if(s.startsWith("3"))
				this.cSitclin = true;
		}
    }
    public TreeNode getTreeNode() {
        if (rootNode == null) {
            loadTree();
        }       
        return rootNode;
    }   
    public String getNodeTitle() {
        return nodeTitle;
    }
    public void setNodeTitle(String nodeTitle) {
        this.nodeTitle = nodeTitle;
    }
 // Gestion Tree
    public void cargaCriterios(ActionEvent e){
    	String valor = this.selectedParams.get(this.bindingGrid.getRowIndex());    	
    	this.selectedCriteria.add(new CriterioSeleccion(this.c_est.getProperty(valor),valor));
    }
    public void delCriterio(ActionEvent e){
    	this.selectedCriteria.remove(this.bindingGridCriterios.getRowIndex());
    }
    public void lecturaProperties() throws Exception {
		//Properties p = new Properties();
		InputStream is = ControlEstadisticas.class.getResourceAsStream("p_estadisticos.properties");
		//p.load(is);
		this.p_est.load(is);
		is.close();
		is = ControlEstadisticas.class.getResourceAsStream("relacion_estadisticos.properties");
		//p.load(is);
		this.c_est.load(is);
		is.close();
	}


	public List<String> getSelectedParams() {
		return selectedParams;
	}


	public void setSelectedParams(List<String> selectedParams) {
		this.selectedParams = selectedParams;
	}


	public HtmlDataGrid getBindingGrid() {
		return bindingGrid;
	}


	public void setBindingGrid(HtmlDataGrid bindingGrid) {
		this.bindingGrid = bindingGrid;
	}


	public List<String> getSelectedParamsKeys() {
		return selectedParamsKeys;
	}


	public void setSelectedParamsKeys(List<String> selectedParamsKeys) {
		this.selectedParamsKeys = selectedParamsKeys;
	}


	public ArrayList<CriterioSeleccion> getSelectedCriteria() {
		return selectedCriteria;
	}


	public void setSelectedCriteria(ArrayList<CriterioSeleccion> selectedCriteria) {
		this.selectedCriteria = selectedCriteria;
	}


	public HtmlDataGrid getBindingGridCriterios() {
		return bindingGridCriterios;
	}


	public void setBindingGridCriterios(HtmlDataGrid bindingGridCriterios) {
		this.bindingGridCriterios = bindingGridCriterios;
	}
	public ArrayList<SelectItem> getCardiopatia() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras cardio : this.cardiopatia)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio
					.getValor()));
		return cp;
	}
	public ArrayList<SelectItem> getModo() {
		ArrayList<SelectItem> m = new ArrayList<SelectItem>();
		m.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras mg : this.modo)
			m.add(new SelectItem(mg.getCodigo(), mg
					.getValor()));
		return m;
	}
	public ArrayList<SelectItem> getFabricante() {
		ArrayList<SelectItem> m = new ArrayList<SelectItem>();
		m.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras mg : this.fabricante)
			m.add(new SelectItem(mg.getCodigo(), mg
					.getValor()));
		return m;
	}
	public Date getFechaini_gen() {
		return fechaini_gen;
	}
	public void setFechaini_gen(Date fechaini_gen) {
		this.fechaini_gen = fechaini_gen;
	}
	public Date getFechafin_gen() {
		return fechafin_gen;
	}
	public void setFechafin_gen(Date fechafin_gen) {
		this.fechafin_gen = fechafin_gen;
	}
	public boolean isEst_gen() {
		return est_gen;
	}
	public void setEst_gen(boolean est_gen) {
		this.est_gen = est_gen;
	}
	public String getResgen5() {
		return resgen5;
	}
	public void setResgen5(String resgen5) {
		this.resgen5 = resgen5;
	}
	public String getResgen1() {
		return resgen1;
	}
	public void setResgen1(String resgen1) {
		this.resgen1 = resgen1;
	}
	public String getResgen2() {
		return resgen2;
	}
	public void setResgen2(String resgen2) {
		this.resgen2 = resgen2;
	}
	public String getResgen3() {
		return resgen3;
	}
	public void setResgen3(String resgen3) {
		this.resgen3 = resgen3;
	}
	public String getResgen4() {
		return resgen4;
	}
	public void setResgen4(String resgen4) {
		this.resgen4 = resgen4;
	}
	public String getResgen7() {
		return resgen7;
	}
	public void setResgen7(String resgen7) {
		this.resgen7 = resgen7;
	}
	/*public String getResgen6() {
		return resgen6;
	}
	public void setResgen6(String resgen6) {
		this.resgen6 = resgen6;
	}*/
	/*public String getResgen8() {
		return resgen8;
	}
	public void setResgen8(String resgen8) {
		this.resgen8 = resgen8;
	}*/
	public String getResmesa1() {
		return resmesa1;
	}
	public void setResmesa1(String resmesa1) {
		this.resmesa1 = resmesa1;
	}
	/*public String getResmesa2() {
		return resmesa2;
	}
	public void setResmesa2(String resmesa2) {
		this.resmesa2 = resmesa2;
	}*/
	public Date getFechaini_mesa() {
		return fechaini_mesa;
	}
	public void setFechaini_mesa(Date fechaini_mesa) {
		this.fechaini_mesa = fechaini_mesa;
	}
	public Date getFechafin_mesa() {
		return fechafin_mesa;
	}
	public void setFechafin_mesa(Date fechafin_mesa) {
		this.fechafin_mesa = fechafin_mesa;
	}
	public boolean isEst_mesa() {
		return est_mesa;
	}
	public void setEst_mesa(boolean est_mesa) {
		this.est_mesa = est_mesa;
	}
	public Date getFechaini_reg() {
		return fechaini_reg;
	}
	public void setFechaini_reg(Date fechaini_reg) {
		this.fechaini_reg = fechaini_reg;
	}
	public Date getFechafin_reg() {
		return fechafin_reg;
	}
	public void setFechafin_reg(Date fechafin_reg) {
		this.fechafin_reg = fechafin_reg;
	}
	public boolean isEst_reg() {
		return est_reg;
	}
	public void setEst_reg(boolean est_reg) {
		this.est_reg = est_reg;
	}
	public String getResreg1() {
		return resreg1;
	}
	public void setResreg1(String resreg1) {
		this.resreg1 = resreg1;
	}
	/*public String getResreg2() {
		return resreg2;
	}
	public void setResreg2(String resreg2) {
		this.resreg2 = resreg2;
	}*/
	public Date getFechaini_cv() {
		return fechaini_cv;
	}
	public void setFechaini_cv(Date fechaini_cv) {
		this.fechaini_cv = fechaini_cv;
	}
	public Date getFechafin_cv() {
		return fechafin_cv;
	}
	public void setFechafin_cv(Date fechafin_cv) {
		this.fechafin_cv = fechafin_cv;
	}
	public boolean isEst_cv() {
		return est_cv;
	}
	public void setEst_cv(boolean est_cv) {
		this.est_cv = est_cv;
	}
	public String getRescv1() {
		return rescv1;
	}
	public void setRescv1(String rescv1) {
		this.rescv1 = rescv1;
	}
	/*public String getRescv2() {
		return rescv2;
	}
	public void setRescv2(String rescv2) {
		this.rescv2 = rescv2;
	}
	public String getRescv3() {
		return rescv3;
	}
	public void setRescv3(String rescv3) {
		this.rescv3 = rescv3;
	}*/
	public Date getFechaini_test() {
		return fechaini_test;
	}
	public void setFechaini_test(Date fechaini_test) {
		this.fechaini_test = fechaini_test;
	}
	public Date getFechafin_test() {
		return fechafin_test;
	}
	public void setFechafin_test(Date fechafin_test) {
		this.fechafin_test = fechafin_test;
	}
	public boolean isEst_test() {
		return est_test;
	}
	public void setEst_test(boolean est_test) {
		this.est_test = est_test;
	}
	public String getRestest1() {
		return restest1;
	}
	public void setRestest1(String restest1) {
		this.restest1 = restest1;
	}
	public String getRestest2() {
		return restest2;
	}
	public void setRestest2(String restest2) {
		this.restest2 = restest2;
	}
	public String getRestest3() {
		return restest3;
	}
	public void setRestest3(String restest3) {
		this.restest3 = restest3;
	}
	/*public String getRestest4() {
		return restest4;
	}
	public void setRestest4(String restest4) {
		this.restest4 = restest4;
	}*/
	public Date getFechaini_eef() {
		return fechaini_eef;
	}
	public void setFechaini_eef(Date fechaini_eef) {
		this.fechaini_eef = fechaini_eef;
	}
	public Date getFechafin_eef() {
		return fechafin_eef;
	}
	public void setFechafin_eef(Date fechafin_eef) {
		this.fechafin_eef = fechafin_eef;
	}
	public boolean isEst_eef() {
		return est_eef;
	}
	public void setEst_eef(boolean est_eef) {
		this.est_eef = est_eef;
	}
	public String getReseef1() {
		return reseef1;
	}
	public void setReseef1(String reseef1) {
		this.reseef1 = reseef1;
	}
	/*public String getReseef2() {
		return reseef2;
	}
	public void setReseef2(String reseef2) {
		this.reseef2 = reseef2;
	}
	public String getReseef3() {
		return reseef3;
	}
	public void setReseef3(String reseef3) {
		this.reseef3 = reseef3;
	}
	public String getReseef4() {
		return reseef4;
	}
	public void setReseef4(String reseef4) {
		this.reseef4 = reseef4;
	}*/
	/*public String getReseef5() {
		return reseef5;
	}
	public void setReseef5(String reseef5) {
		this.reseef5 = reseef5;
	}*/
	/*public String getReseef6() {
		return reseef6;
	}
	public void setReseef6(String reseef6) {
		this.reseef6 = reseef6;
	}
	public String getReseef7() {
		return reseef7;
	}
	public void setReseef7(String reseef7) {
		this.reseef7 = reseef7;
	}*/
	public Date getFechaini_imp() {
		return fechaini_imp;
	}
	public void setFechaini_imp(Date fechaini_imp) {
		this.fechaini_imp = fechaini_imp;
	}
	public Date getFechafin_imp() {
		return fechafin_imp;
	}
	public void setFechafin_imp(Date fechafin_imp) {
		this.fechafin_imp = fechafin_imp;
	}
	public boolean isEst_imp() {
		return est_imp;
	}
	public void setEst_imp(boolean est_imp) {
		this.est_imp = est_imp;
	}
	public String getResimp1() {
		return resimp1;
	}
	public void setResimp1(String resimp1) {
		this.resimp1 = resimp1;
	}
	public String getResimp2() {
		return resimp2;
	}
	public void setResimp2(String resimp2) {
		this.resimp2 = resimp2;
	}
	public String getResimp3() {
		return resimp3;
	}
	public void setResimp3(String resimp3) {
		this.resimp3 = resimp3;
	}
	public String getResimp4() {
		return resimp4;
	}
	public void setResimp4(String resimp4) {
		this.resimp4 = resimp4;
	}
	public String getResimp5() {
		return resimp5;
	}
	public void setResimp5(String resimp5) {
		this.resimp5 = resimp5;
	}
	public String getResimp6() {
		return resimp6;
	}
	public void setResimp6(String resimp6) {
		this.resimp6 = resimp6;
	}
	public String getResimp7() {
		return resimp7;
	}
	public void setResimp7(String resimp7) {
		this.resimp7 = resimp7;
	}
	
	public HtmlDataTable getBindingGenProcs() {
		return bindingGenProcs;
	}
	public void setBindingGenProcs(HtmlDataTable bindingGenProcs) {
		this.bindingGenProcs = bindingGenProcs;
	}
	public ArrayList<EstadisticasBasicas> getGenprocs() {
		return genprocs;
	}
	public void setGenprocs(ArrayList<EstadisticasBasicas> genprocs) {
		this.genprocs = genprocs;
	}
	public ArrayList<EstadisticasBasicas> getGensegs() {
		return gensegs;
	}
	public void setGensegs(ArrayList<EstadisticasBasicas> gensegs) {
		this.gensegs = gensegs;
	}
	public HtmlDataTable getBindingGenSegs() {
		return bindingGenSegs;
	}
	public void setBindingGenSegs(HtmlDataTable bindingGenSegs) {
		this.bindingGenSegs = bindingGenSegs;
	}
	public ArrayList<EstadisticasBasicas> getGenpatsexo() {
		return genpatsexo;
	}
	public void setGenpatsexo(ArrayList<EstadisticasBasicas> genpatsexo) {
		this.genpatsexo = genpatsexo;
	}
	public HtmlDataTable getBindingGenPatSexo() {
		return bindingGenPatSexo;
	}
	public void setBindingGenPatSexo(HtmlDataTable bindingGenPatSexo) {
		this.bindingGenPatSexo = bindingGenPatSexo;
	}
	public ArrayList<EstadisticasBasicas> getTestatp1() {
		return testatp1;
	}
	public void setTestatp1(ArrayList<EstadisticasBasicas> testatp1) {
		this.testatp1 = testatp1;
	}
	public HtmlDataTable getBindingTestAtp1() {
		return bindingTestAtp1;
	}
	public void setBindingTestAtp1(HtmlDataTable bindingTestAtp1) {
		this.bindingTestAtp1 = bindingTestAtp1;
	}
	/*public ArrayList<EstadisticasBasicas> getTestatp2() {
		return testatp2;
	}
	public void setTestatp2(ArrayList<EstadisticasBasicas> testatp2) {
		this.testatp2 = testatp2;
	}
	public HtmlDataTable getBindingTestAtp2() {
		return bindingTestAtp2;
	}
	public void setBindingTestAtp2(HtmlDataTable bindingTestAtp2) {
		this.bindingTestAtp2 = bindingTestAtp2;
	}*/
	public ArrayList<EstadisticasBasicas> getTestepi() {
		return testepi;
	}
	public void setTestepi(ArrayList<EstadisticasBasicas> testepi) {
		this.testepi = testepi;
	}
	public HtmlDataTable getBindingTestEpi() {
		return bindingTestEpi;
	}
	public void setBindingTestEpi(HtmlDataTable bindingTestEpi) {
		this.bindingTestEpi = bindingTestEpi;
	}
	public ArrayList<EstadisticasBasicas> getTestfle() {
		return testfle;
	}
	public void setTestfle(ArrayList<EstadisticasBasicas> testfle) {
		this.testfle = testfle;
	}
	public HtmlDataTable getBindingTestFle() {
		return bindingTestFle;
	}
	public void setBindingTestFle(HtmlDataTable bindingTestFle) {
		this.bindingTestFle = bindingTestFle;
	}
	public ArrayList<EstadisticasBasicas> getRegind() {
		return regind;
	}
	public void setRegind(ArrayList<EstadisticasBasicas> regind) {
		this.regind = regind;
	}
	public HtmlDataTable getBindingRegInd() {
		return bindingRegInd;
	}
	public void setBindingRegInd(HtmlDataTable bindingRegInd) {
		this.bindingRegInd = bindingRegInd;
	}
	public ArrayList<EstadisticasBasicas> getRegmot() {
		return regmot;
	}
	public void setRegmot(ArrayList<EstadisticasBasicas> regmot) {
		this.regmot = regmot;
	}
	public HtmlDataTable getBindingRegMot() {
		return bindingRegMot;
	}
	public void setBindingRegMot(HtmlDataTable bindingRegMot) {
		this.bindingRegMot = bindingRegMot;
	}
	public ArrayList<EstadisticasBasicas> getMesares() {
		return mesares;
	}
	public void setMesares(ArrayList<EstadisticasBasicas> mesares) {
		this.mesares = mesares;
	}
	public HtmlDataTable getBindingMesaRes() {
		return bindingMesaRes;
	}
	public void setBindingMesaRes(HtmlDataTable bindingMesaRes) {
		this.bindingMesaRes = bindingMesaRes;
	}
	/*public ArrayList<EstadisticasBasicas> getMesantg() {
		return mesantg;
	}
	public void setMesantg(ArrayList<EstadisticasBasicas> mesantg) {
		this.mesantg = mesantg;
	}
	public HtmlDataTable getBindingMesaNtg() {
		return bindingMesaNtg;
	}
	public void setBindingMesaNtg(HtmlDataTable bindingMesaNtg) {
		this.bindingMesaNtg = bindingMesaNtg;
	}*/
	public ArrayList<EstadisticasBasicas> getEefdiag() {
		return eefdiag;
	}
	public void setEefdiag(ArrayList<EstadisticasBasicas> eefdiag) {
		this.eefdiag = eefdiag;
	}
	public HtmlDataTable getBindingEefDiag() {
		return bindingEefDiag;
	}
	public void setBindingEefDiag(HtmlDataTable bindingEefDiag) {
		this.bindingEefDiag = bindingEefDiag;
	}
	/*public ArrayList<EstadisticasBasicas> getEefproc() {
		return eefproc;
	}
	public void setEefproc(ArrayList<EstadisticasBasicas> eefproc) {
		this.eefproc = eefproc;
	}
	public HtmlDataTable getBindingEefProc() {
		return bindingEefProc;
	}
	public void setBindingEefProc(HtmlDataTable bindingEefProc) {
		this.bindingEefProc = bindingEefProc;
	}*/
	public ArrayList<EstadisticasBasicas> getEefint() {
		return eefint;
	}
	public void setEefint(ArrayList<EstadisticasBasicas> eefint) {
		this.eefint = eefint;
	}
	public HtmlDataTable getBindingEefInt() {
		return bindingEefInt;
	}
	public void setBindingEefInt(HtmlDataTable bindingEefInt) {
		this.bindingEefInt = bindingEefInt;
	}
	public ArrayList<EstadisticasBasicas> getEefablsust() {
		return eefablsust;
	}
	public void setEefablsust(ArrayList<EstadisticasBasicas> eefablsust) {
		this.eefablsust = eefablsust;
	}
	public HtmlDataTable getBindingEefAblSust() {
		return bindingEefAblSust;
	}
	public void setBindingEefAblSust(HtmlDataTable bindingEefAblSust) {
		this.bindingEefAblSust = bindingEefAblSust;
	}
	public ArrayList<EstadisticasBasicas> getEefablres() {
		return eefablres;
	}
	public void setEefablres(ArrayList<EstadisticasBasicas> eefablres) {
		this.eefablres = eefablres;
	}
	public HtmlDataTable getBindingEefAblRes() {
		return bindingEefAblRes;
	}
	public void setBindingEefAblRes(HtmlDataTable bindingEefAblRes) {
		this.bindingEefAblRes = bindingEefAblRes;
	}
	public ArrayList<EstadisticasBasicas> getCvind() {
		return cvind;
	}
	public void setCvind(ArrayList<EstadisticasBasicas> cvind) {
		this.cvind = cvind;
	}
	public HtmlDataTable getBindingCvInd() {
		return bindingCvInd;
	}
	public void setBindingCvInd(HtmlDataTable bindingCvInd) {
		this.bindingCvInd = bindingCvInd;
	}
	public ArrayList<EstadisticasBasicas> getCvres() {
		return cvres;
	}
	public void setCvres(ArrayList<EstadisticasBasicas> cvres) {
		this.cvres = cvres;
	}
	public HtmlDataTable getBindingCvRes() {
		return bindingCvRes;
	}
	public void setBindingCvRes(HtmlDataTable bindingCvRes) {
		this.bindingCvRes = bindingCvRes;
	}
	public ArrayList<EstadisticasBasicas> getCvabl() {
		return cvabl;
	}
	public void setCvabl(ArrayList<EstadisticasBasicas> cvabl) {
		this.cvabl = cvabl;
	}
	public HtmlDataTable getBindingCvAbl() {
		return bindingCvAbl;
	}
	public void setBindingCvAbl(HtmlDataTable bindingCvAbl) {
		this.bindingCvAbl = bindingCvAbl;
	}

	 public XYDataSetCollection getChartSeries() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valores!=null)
		        for(XYDataList item:this.valores)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesGenProc() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresgenproc!=null)
		        for(XYDataList item:this.valoresgenproc)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesGenSegs() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoressegs!=null)
		        for(XYDataList item:this.valoressegs)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesGenSexo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresgensexo!=null)
		        for(XYDataList item:this.valoresgensexo)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesGenCarProc() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valorescarproc!=null)
		        for(XYDataList item:this.valorescarproc)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesGenProcComp() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresgenproccomp!=null)
		        for(XYDataList item:this.valoresgenproccomp)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesGenTipoComp() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresgentipocomp!=null)
		        for(XYDataList item:this.valoresgentipocomp)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEefReal() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoreseefreal!=null)
		        for(XYDataList item:this.valoreseefreal)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEefDiag() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoreseefdiag!=null)
		        for(XYDataList item:this.valoreseefdiag)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEefAblNo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoreseefablno!=null)
		        for(XYDataList item:this.valoreseefablno)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEefSust() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoreseefsust!=null)
		        for(XYDataList item:this.valoreseefsust)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEefRes() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoreseefres!=null)
		        for(XYDataList item:this.valoreseefres)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEefCompDiag() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoreseefcompdiag!=null)
		        for(XYDataList item:this.valoreseefcompdiag)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEefCompAbl() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoreseefcompabl!=null)
		        for(XYDataList item:this.valoreseefcompabl)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEefCompDiagTipo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoreseefcomptipodiag!=null)
		        for(XYDataList item:this.valoreseefcomptipodiag)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEefCompAblTipo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoreseefcomptipoabl!=null)
		        for(XYDataList item:this.valoreseefcomptipoabl)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesCvInd() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valorescvind!=null)
		        for(XYDataList item:this.valorescvind)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesCvExito() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valorescvexito!=null)
		        for(XYDataList item:this.valorescvexito)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesCvAbl() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valorescvabl!=null)
		        for(XYDataList item:this.valorescvabl)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesCvTipo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valorescvtipo!=null)
		        for(XYDataList item:this.valorescvtipo)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesCvComp() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valorescvcomp!=null)
		        for(XYDataList item:this.valorescvcomp)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesCvCompTipo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valorescvcomptipo!=null)
		        for(XYDataList item:this.valorescvcomptipo)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesRegInd() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresregind!=null)
		        for(XYDataList item:this.valoresregind)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesRegDiag() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresregdiag!=null)
		        for(XYDataList item:this.valoresregdiag)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesRegFab() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresregfab!=null)
		        for(XYDataList item:this.valoresregfab)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesRegComp() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresregcomp!=null)
		        for(XYDataList item:this.valoresregcomp)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesRegCompTipo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresregcomptipo!=null)
		        for(XYDataList item:this.valoresregcomptipo)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesHolDiagFin() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresholdiagfin!=null)
		        for(XYDataList item:this.valoresholdiagfin)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesRegEvExtDiagFin() {
	       XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresregevextdiagfin!=null)
		        for(XYDataList item:this.valoresregevextdiagfin)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesAtpRes() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresatpres!=null)
		        for(XYDataList item:this.valoresatpres)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesEpiRes() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresepires!=null)
		        for(XYDataList item:this.valoresepires)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesFleRes() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresfleres!=null)
		        for(XYDataList item:this.valoresfleres)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesMesaRes() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresmesares!=null)
		        for(XYDataList item:this.valoresmesares)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpDisp() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpdisp!=null)
		        for(XYDataList item:this.valoresimpdisp)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpReintDisp() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpreintdisp!=null)
		        for(XYDataList item:this.valoresimpreintdisp)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpProc() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpproc!=null)
		        for(XYDataList item:this.valoresimpproc)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpReintProc() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpreintproc!=null)
		        for(XYDataList item:this.valoresimpreintproc)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpSegDisp() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoressegdisp!=null)
		        for(XYDataList item:this.valoressegdisp)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpBeFabTipo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpbefabtipo!=null)
		        for(XYDataList item:this.valoresimpbefabtipo)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpBeTipoFab() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpbetipofab!=null)
		        for(XYDataList item:this.valoresimpbetipofab)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpAeFabTipo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpaefabtipo!=null)
		        for(XYDataList item:this.valoresimpaefabtipo)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpAeTipoFab() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpaetipofab!=null)
		        for(XYDataList item:this.valoresimpaetipofab)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpRitmo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpritmo!=null)
		        for(XYDataList item:this.valoresimpritmo)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpCav() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpcav!=null)
		        for(XYDataList item:this.valoresimpcav)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpQrs() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpqrs!=null)
		        for(XYDataList item:this.valoresimpqrs)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpComp() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpcomp!=null)
		        for(XYDataList item:this.valoresimpcomp)
		        	collection.addDataList(item);
	        return collection;
	 }
	 public XYDataSetCollection getChartSeriesImpCompTipo() {
	        XYDataSetCollection collection = new XYDataSetCollection();
	       if(this.valoresimpcomptipo!=null)
		        for(XYDataList item:this.valoresimpcomptipo)
		        	collection.addDataList(item);
	        return collection;
	 }
	public FlotChartRendererData getChartDataGen() {
		return chartDataGen;
	}
	public void setChartDataGen(FlotChartRendererData chartDataGen) {
		this.chartDataGen = chartDataGen;
	}
	public FlotChartRendererData getChartDataTest() {
		return chartDataTest;
	}
	public void setChartDataTest(FlotChartRendererData chartDataTest) {
		this.chartDataTest = chartDataTest;
	}
	public FlotChartRendererData getChartDataMesa() {
		return chartDataMesa;
	}
	public void setChartDataMesa(FlotChartRendererData chartDataMesa) {
		this.chartDataMesa = chartDataMesa;
	}
	public FlotChartRendererData getChartDataReg() {
		return chartDataReg;
	}
	public void setChartDataReg(FlotChartRendererData chartDataReg) {
		this.chartDataReg = chartDataReg;
	}
	public FlotChartRendererData getChartDataCv() {
		return chartDataCv;
	}
	public void setChartDataCv(FlotChartRendererData chartDataCv) {
		this.chartDataCv = chartDataCv;
	}
	public FlotChartRendererData getChartDataEef() {
		return chartDataEef;
	}
	public void setChartDataEef(FlotChartRendererData chartDataEef) {
		this.chartDataEef = chartDataEef;
	}
	public FlotChartRendererData getChartDataImp() {
		return chartDataImp;
	}
	public void setChartDataImp(FlotChartRendererData chartDataImp) {
		this.chartDataImp = chartDataImp;
	}
	public ArrayList<EstadisticasBasicas> getEefcar() {
		return eefcar;
	}
	public void setEefcar(ArrayList<EstadisticasBasicas> eefcar) {
		this.eefcar = eefcar;
	}
	public HtmlDataTable getBindingEefCar() {
		return bindingEefCar;
	}
	public void setBindingEefCar(HtmlDataTable bindingEefCar) {
		this.bindingEefCar = bindingEefCar;
	}
	public ArrayList<EstadisticasBasicas> getGenpatcar() {
		return genpatcar;
	}
	public void setGenpatcar(ArrayList<EstadisticasBasicas> genpatcar) {
		this.genpatcar = genpatcar;
	}
	public HtmlDataTable getBindingGenPatCar() {
		return bindingGenPatCar;
	}
	public void setBindingGenPatCar(HtmlDataTable bindingGenPatCar) {
		this.bindingGenPatCar = bindingGenPatCar;
	}
	public ArrayList<EstadisticasBasicas> getGensegsrem() {
		return gensegsrem;
	}
	public void setGensegsrem(ArrayList<EstadisticasBasicas> gensegsrem) {
		this.gensegsrem = gensegsrem;
	}
	public HtmlDataTable getBindingGenSegsRem() {
		return bindingGenSegsRem;
	}
	public void setBindingGenSegsRem(HtmlDataTable bindingGenSegsRem) {
		this.bindingGenSegsRem = bindingGenSegsRem;
	}
	public ArrayList<EstadisticasBasicas> getImpproc() {
		return impproc;
	}
	public void setImpproc(ArrayList<EstadisticasBasicas> impproc) {
		this.impproc = impproc;
	}
	public HtmlDataTable getBindingImpProc() {
		return bindingImpProc;
	}
	public void setBindingImpProc(HtmlDataTable bindingImpProc) {
		this.bindingImpProc = bindingImpProc;
	}
	public ArrayList<EstadisticasBasicas> getImpaefab() {
		return impaefab;
	}
	public void setImpaefab(ArrayList<EstadisticasBasicas> impaefab) {
		this.impaefab = impaefab;
	}
	public HtmlDataTable getBindingImpAEFab() {
		return bindingImpAEFab;
	}
	public void setBindingImpAEFab(HtmlDataTable bindingImpAEFab) {
		this.bindingImpAEFab = bindingImpAEFab;
	}
	public ArrayList<EstadisticasBasicas> getImpritmo() {
		return impritmo;
	}
	public void setImpritmo(ArrayList<EstadisticasBasicas> impritmo) {
		this.impritmo = impritmo;
	}
	public HtmlDataTable getBindingImpRitmo() {
		return bindingImpRitmo;
	}
	public void setBindingImpRitmo(HtmlDataTable bindingImpRitmo) {
		this.bindingImpRitmo = bindingImpRitmo;
	}
	public ArrayList<EstadisticasBasicas> getImpcav() {
		return impcav;
	}
	public void setImpcav(ArrayList<EstadisticasBasicas> impcav) {
		this.impcav = impcav;
	}
	public HtmlDataTable getBindingImpCav() {
		return bindingImpCav;
	}
	public void setBindingImpCav(HtmlDataTable bindingImpCav) {
		this.bindingImpCav = bindingImpCav;
	}
	public ArrayList<EstadisticasBasicas> getImpqrs() {
		return impqrs;
	}
	public void setImpqrs(ArrayList<EstadisticasBasicas> impqrs) {
		this.impqrs = impqrs;
	}
	public HtmlDataTable getBindingImpQrs() {
		return bindingImpQrs;
	}
	public void setBindingImpQrs(HtmlDataTable bindingImpQrs) {
		this.bindingImpQrs = bindingImpQrs;
	}
	public ArrayList<EstadisticasBasicas> getImpaetipo() {
		return impaetipo;
	}
	public void setImpaetipo(ArrayList<EstadisticasBasicas> impaetipo) {
		this.impaetipo = impaetipo;
	}
	public HtmlDataTable getBindingImpAETipo() {
		return bindingImpAETipo;
	}
	public void setBindingImpAETipo(HtmlDataTable bindingImpAETipo) {
		this.bindingImpAETipo = bindingImpAETipo;
	}
	public ArrayList<EstadisticasBasicas> getImpbefab() {
		return impbefab;
	}
	public void setImpbefab(ArrayList<EstadisticasBasicas> impbefab) {
		this.impbefab = impbefab;
	}
	public HtmlDataTable getBindingImpBEFab() {
		return bindingImpBEFab;
	}
	public void setBindingImpBEFab(HtmlDataTable bindingImpBEFab) {
		this.bindingImpBEFab = bindingImpBEFab;
	}
	public ArrayList<EstadisticasBasicas> getImpbetipo() {
		return impbetipo;
	}
	public void setImpbetipo(ArrayList<EstadisticasBasicas> impbetipo) {
		this.impbetipo = impbetipo;
	}
	public HtmlDataTable getBindingImpBETipo() {
		return bindingImpBETipo;
	}
	public void setBindingImpBETipo(HtmlDataTable bindingImpBETipo) {
		this.bindingImpBETipo = bindingImpBETipo;
	}
	public FlotChartRendererData getChartDataGenProc() {
		return chartDataGenProc;
	}
	public void setChartDataGenProc(FlotChartRendererData chartDataGenProc) {
		this.chartDataGenProc = chartDataGenProc;
	}
	public FlotChartRendererData getChartDataGenSexo() {
		return chartDataGenSexo;
	}
	public void setChartDataGenSexo(FlotChartRendererData chartDataGenSexo) {
		this.chartDataGenSexo = chartDataGenSexo;
	}
	public FlotChartRendererData getChartDataGenCarProc() {
		return chartDataGenCarProc;
	}
	public void setChartDataGenCarProc(FlotChartRendererData chartDataGenCarProc) {
		this.chartDataGenCarProc = chartDataGenCarProc;
	}
	public FlotChartRendererData getChartDataGenSegs() {
		return chartDataGenSegs;
	}
	public void setChartDataGenSegs(FlotChartRendererData chartDataGenSegs) {
		this.chartDataGenSegs = chartDataGenSegs;
	}
	public FlotChartRendererData getChartDataEefReal() {
		return chartDataEefReal;
	}
	public void setChartDataEefReal(FlotChartRendererData chartDataEefReal) {
		this.chartDataEefReal = chartDataEefReal;
	}
	public FlotChartRendererData getChartDataEefDiag() {
		return chartDataEefDiag;
	}
	public void setChartDataEefDiag(FlotChartRendererData chartDataEefDiag) {
		this.chartDataEefDiag = chartDataEefDiag;
	}
	public FlotChartRendererData getChartDataEefAblNo() {
		return chartDataEefAblNo;
	}
	public void setChartDataEefAblNo(FlotChartRendererData chartDataEefAblNo) {
		this.chartDataEefAblNo = chartDataEefAblNo;
	}
	public FlotChartRendererData getChartDataEefSust() {
		return chartDataEefSust;
	}
	public void setChartDataEefSust(FlotChartRendererData chartDataEefSust) {
		this.chartDataEefSust = chartDataEefSust;
	}
	public FlotChartRendererData getChartDataEefRes() {
		return chartDataEefRes;
	}
	public void setChartDataEefRes(FlotChartRendererData chartDataEefRes) {
		this.chartDataEefRes = chartDataEefRes;
	}
	public FlotChartRendererData getChartDataCvInd() {
		return chartDataCvInd;
	}
	public void setChartDataCvInd(FlotChartRendererData chartDataCvInd) {
		this.chartDataCvInd = chartDataCvInd;
	}
	public FlotChartRendererData getChartDataCvExito() {
		return chartDataCvExito;
	}
	public void setChartDataCvExito(FlotChartRendererData chartDataCvExito) {
		this.chartDataCvExito = chartDataCvExito;
	}
	public FlotChartRendererData getChartDatacvAbl() {
		return chartDatacvAbl;
	}
	public void setChartDatacvAbl(FlotChartRendererData chartDatacvAbl) {
		this.chartDatacvAbl = chartDatacvAbl;
	}
	public FlotChartRendererData getChartDataRegInd() {
		return chartDataRegInd;
	}
	public void setChartDataRegInd(FlotChartRendererData chartDataRegInd) {
		this.chartDataRegInd = chartDataRegInd;
	}
	public FlotChartRendererData getChartDataRegDiag() {
		return chartDataRegDiag;
	}
	public void setChartDataRegDiag(FlotChartRendererData chartDataRegDiag) {
		this.chartDataRegDiag = chartDataRegDiag;
	}
	public FlotChartRendererData getChartDataAtpRes() {
		return chartDataAtpRes;
	}
	public void setChartDataAtpRes(FlotChartRendererData chartDataAtpRes) {
		this.chartDataAtpRes = chartDataAtpRes;
	}
	public FlotChartRendererData getChartDataEpiRes() {
		return chartDataEpiRes;
	}
	public void setChartDataEpiRes(FlotChartRendererData chartDataEpiRes) {
		this.chartDataEpiRes = chartDataEpiRes;
	}
	public FlotChartRendererData getChartDataFleRes() {
		return chartDataFleRes;
	}
	public void setChartDataFleRes(FlotChartRendererData chartDataFleRes) {
		this.chartDataFleRes = chartDataFleRes;
	}
	public FlotChartRendererData getChartDataMesaRes() {
		return chartDataMesaRes;
	}
	public void setChartDataMesaRes(FlotChartRendererData chartDataMesaRes) {
		this.chartDataMesaRes = chartDataMesaRes;
	}
	public FlotChartRendererData getChartDataImpDisp() {
		return chartDataImpDisp;
	}
	public void setChartDataImpDisp(FlotChartRendererData chartDataImpDisp) {
		this.chartDataImpDisp = chartDataImpDisp;
	}
	public FlotChartRendererData getChartDataImpProc() {
		return chartDataImpProc;
	}
	public void setChartDataImpProc(FlotChartRendererData chartDataImpProc) {
		this.chartDataImpProc = chartDataImpProc;
	}
	public FlotChartRendererData getChartDataImpBeFabTipo() {
		return chartDataImpBeFabTipo;
	}
	public void setChartDataImpBeFabTipo(FlotChartRendererData chartDataImpBeFabTipo) {
		this.chartDataImpBeFabTipo = chartDataImpBeFabTipo;
	}
	public FlotChartRendererData getChartDataImpBeTipoFab() {
		return chartDataImpBeTipoFab;
	}
	public void setChartDataImpBeTipoFab(FlotChartRendererData chartDataImpBeTipoFab) {
		this.chartDataImpBeTipoFab = chartDataImpBeTipoFab;
	}
	public FlotChartRendererData getChartDataImpAeFabTipo() {
		return chartDataImpAeFabTipo;
	}
	public void setChartDataImpAeFabTipo(FlotChartRendererData chartDataImpAeFabTipo) {
		this.chartDataImpAeFabTipo = chartDataImpAeFabTipo;
	}
	public FlotChartRendererData getChartImpAeTipoFab() {
		return chartImpAeTipoFab;
	}
	public void setChartImpAeTipoFab(FlotChartRendererData chartImpAeTipoFab) {
		this.chartImpAeTipoFab = chartImpAeTipoFab;
	}
	public FlotChartRendererData getChartDataImpRitmo() {
		return chartDataImpRitmo;
	}
	public void setChartDataImpRitmo(FlotChartRendererData chartDataImpRitmo) {
		this.chartDataImpRitmo = chartDataImpRitmo;
	}
	public FlotChartRendererData getChartDataImpCav() {
		return chartDataImpCav;
	}
	public void setChartDataImpCav(FlotChartRendererData chartDataImpCav) {
		this.chartDataImpCav = chartDataImpCav;
	}
	public FlotChartRendererData getChartDataImpQrs() {
		return chartDataImpQrs;
	}
	public void setChartDataImpQrs(FlotChartRendererData chartDataImpQrs) {
		this.chartDataImpQrs = chartDataImpQrs;
	}
	public FlotChartRendererData getChartDataImpSegDisp() {
		return chartDataImpSegDisp;
	}
	public void setChartDataImpSegDisp(FlotChartRendererData chartDataImpSegDisp) {
		this.chartDataImpSegDisp = chartDataImpSegDisp;
	}
	public ArrayList<EstadisticasBasicas> getCvtipo() {
		return cvtipo;
	}
	public void setCvtipo(ArrayList<EstadisticasBasicas> cvtipo) {
		this.cvtipo = cvtipo;
	}
	public HtmlDataTable getBindingCvTipo() {
		return bindingCvTipo;
	}
	public void setBindingCvTipo(HtmlDataTable bindingCvTipo) {
		this.bindingCvTipo = bindingCvTipo;
	}
	public FlotChartRendererData getChartDatacvTipo() {
		return chartDatacvTipo;
	}
	public void setChartDatacvTipo(FlotChartRendererData chartDatacvTipo) {
		this.chartDatacvTipo = chartDatacvTipo;
	}
	public FlotChartRendererData getChartDatacvComp() {
		return chartDatacvComp;
	}
	public void setChartDatacvComp(FlotChartRendererData chartDatacvComp) {
		this.chartDatacvComp = chartDatacvComp;
	}
	public FlotChartRendererData getChartDatacvCompTipo() {
		return chartDatacvCompTipo;
	}
	public void setChartDatacvCompTipo(FlotChartRendererData chartDatacvCompTipo) {
		this.chartDatacvCompTipo = chartDatacvCompTipo;
	}
	public ArrayList<EstadisticasBasicas> getCvcomp() {
		return cvcomp;
	}
	public void setCvcomp(ArrayList<EstadisticasBasicas> cvcomp) {
		this.cvcomp = cvcomp;
	}
	public HtmlDataTable getBindingCvComp() {
		return bindingCvComp;
	}
	public void setBindingCvComp(HtmlDataTable bindingCvComp) {
		this.bindingCvComp = bindingCvComp;
	}
	public ArrayList<EstadisticasBasicas> getCvcomptipo() {
		return cvcomptipo;
	}
	public void setCvcomptipo(ArrayList<EstadisticasBasicas> cvcomptipo) {
		this.cvcomptipo = cvcomptipo;
	}
	public HtmlDataTable getBindingCvCompTipo() {
		return bindingCvCompTipo;
	}
	public void setBindingCvCompTipo(HtmlDataTable bindingCvCompTipo) {
		this.bindingCvCompTipo = bindingCvCompTipo;
	}
	public Date getFechaini_holter() {
		return fechaini_holter;
	}
	public void setFechaini_holter(Date fechaini_holter) {
		this.fechaini_holter = fechaini_holter;
	}
	public Date getFechafin_holter() {
		return fechafin_holter;
	}
	public void setFechafin_holter(Date fechafin_holter) {
		this.fechafin_holter = fechafin_holter;
	}
	public ArrayList<EstadisticasBasicas> getHoldiagfin() {
		return holdiagfin;
	}
	public void setHoldiagfin(ArrayList<EstadisticasBasicas> holdiagfin) {
		this.holdiagfin = holdiagfin;
	}
	public HtmlDataTable getBindingHolDiagFin() {
		return bindingHolDiagFin;
	}
	public void setBindingHolDiagFin(HtmlDataTable bindingHolDiagFin) {
		this.bindingHolDiagFin = bindingHolDiagFin;
	}
	public boolean isEst_holter() {
		return est_holter;
	}
	public void setEst_holter(boolean est_holter) {
		this.est_holter = est_holter;
	}
	public FlotChartRendererData getChartDataHolDiagFin() {
		return chartDataHolDiagFin;
	}
	public void setChartDataHolDiagFin(FlotChartRendererData chartDataHolDiagFin) {
		this.chartDataHolDiagFin = chartDataHolDiagFin;
	}
	public FlotChartRendererData getChartDataHol() {
		return chartDataHol;
	}
	public void setChartDataHol(FlotChartRendererData chartDataHol) {
		this.chartDataHol = chartDataHol;
	}
	public String getReshol1() {
		return reshol1;
	}
	public void setReshol1(String reshol1) {
		this.reshol1 = reshol1;
	}
	public ArrayList<EstadisticasBasicas> getRegfab() {
		return regfab;
	}
	public void setRegfab(ArrayList<EstadisticasBasicas> regfab) {
		this.regfab = regfab;
	}
	public HtmlDataTable getBindingRegFab() {
		return bindingRegFab;
	}
	public void setBindingRegFab(HtmlDataTable bindingRegFab) {
		this.bindingRegFab = bindingRegFab;
	}
	public FlotChartRendererData getChartDataRegFab() {
		return chartDataRegFab;
	}
	public void setChartDataRegFab(FlotChartRendererData chartDataRegFab) {
		this.chartDataRegFab = chartDataRegFab;
	}
	public boolean isEst_regevext() {
		return est_regevext;
	}
	public void setEst_regevext(boolean est_regevext) {
		this.est_regevext = est_regevext;
	}
	public Date getFechaini_regevext() {
		return fechaini_regevext;
	}
	public void setFechaini_regevext(Date fechaini_regevext) {
		this.fechaini_regevext = fechaini_regevext;
	}
	public Date getFechafin_regevext() {
		return fechafin_regevext;
	}
	public void setFechafin_regevext(Date fechafin_regevext) {
		this.fechafin_regevext = fechafin_regevext;
	}
	public ArrayList<EstadisticasBasicas> getRegevextdiagfin() {
		return regevextdiagfin;
	}
	public void setRegevextdiagfin(ArrayList<EstadisticasBasicas> regevextdiagfin) {
		this.regevextdiagfin = regevextdiagfin;
	}
	public HtmlDataTable getBindingRegEvExtDiagFin() {
		return bindingRegEvExtDiagFin;
	}
	public void setBindingRegEvExtDiagFin(HtmlDataTable bindingRegEvExtDiagFin) {
		this.bindingRegEvExtDiagFin = bindingRegEvExtDiagFin;
	}
	public String getResregevext1() {
		return resregevext1;
	}
	public void setResregevext1(String resregevext1) {
		this.resregevext1 = resregevext1;
	}
	public FlotChartRendererData getChartDataRegEvExt() {
		return chartDataRegEvExt;
	}
	public void setChartDataRegEvExt(FlotChartRendererData chartDataRegEvExt) {
		this.chartDataRegEvExt = chartDataRegEvExt;
	}
	public FlotChartRendererData getChartDataRegEvExtDiagFin() {
		return chartDataRegEvExtDiagFin;
	}
	public void setChartDataRegEvExtDiagFin(FlotChartRendererData chartDataRegEvExtDiagFin) {
		this.chartDataRegEvExtDiagFin = chartDataRegEvExtDiagFin;
	}
	public ArrayList<EstadisticasBasicas> getImpreintproc() {
		return impreintproc;
	}
	public void setImpreintproc(ArrayList<EstadisticasBasicas> impreintproc) {
		this.impreintproc = impreintproc;
	}
	public HtmlDataTable getBindingImpReintProc() {
		return bindingImpReintProc;
	}
	public void setBindingImpReintProc(HtmlDataTable bindingImpReintProc) {
		this.bindingImpReintProc = bindingImpReintProc;
	}
	public FlotChartRendererData getChartDataImpReintDisp() {
		return chartDataImpReintDisp;
	}
	public void setChartDataImpReintDisp(FlotChartRendererData chartDataImpReintDisp) {
		this.chartDataImpReintDisp = chartDataImpReintDisp;
	}
	public FlotChartRendererData getChartDataImpReintProc() {
		return chartDataImpReintProc;
	}
	public void setChartDataImpReintProc(FlotChartRendererData chartDataImpReintProc) {
		this.chartDataImpReintProc = chartDataImpReintProc;
	}
	public ArrayList<EstadisticasBasicas> getEefcompdiag() {
		return eefcompdiag;
	}
	public void setEefcompdiag(ArrayList<EstadisticasBasicas> eefcompdiag) {
		this.eefcompdiag = eefcompdiag;
	}
	public HtmlDataTable getBindingEefCompDiag() {
		return bindingEefCompDiag;
	}
	public void setBindingEefCompDiag(HtmlDataTable bindingEefCompDiag) {
		this.bindingEefCompDiag = bindingEefCompDiag;
	}
	public ArrayList<EstadisticasBasicas> getEefcompabl() {
		return eefcompabl;
	}
	public void setEefcompabl(ArrayList<EstadisticasBasicas> eefcompabl) {
		this.eefcompabl = eefcompabl;
	}
	public HtmlDataTable getBindingEefCompAbl() {
		return bindingEefCompAbl;
	}
	public void setBindingEefCompAbl(HtmlDataTable bindingEefCompAbl) {
		this.bindingEefCompAbl = bindingEefCompAbl;
	}
	public ArrayList<EstadisticasBasicas> getEefcompdiagtipo() {
		return eefcompdiagtipo;
	}
	public void setEefcompdiagtipo(ArrayList<EstadisticasBasicas> eefcompdiagtipo) {
		this.eefcompdiagtipo = eefcompdiagtipo;
	}
	public HtmlDataTable getBindingEefCompDiagTipo() {
		return bindingEefCompDiagTipo;
	}
	public void setBindingEefCompDiagTipo(HtmlDataTable bindingEefCompDiagTipo) {
		this.bindingEefCompDiagTipo = bindingEefCompDiagTipo;
	}
	public ArrayList<EstadisticasBasicas> getEefcompabltipo() {
		return eefcompabltipo;
	}
	public void setEefcompabltipo(ArrayList<EstadisticasBasicas> eefcompabltipo) {
		this.eefcompabltipo = eefcompabltipo;
	}
	public HtmlDataTable getBindingEefCompAblTipo() {
		return bindingEefCompAblTipo;
	}
	public void setBindingEefCompAblTipo(HtmlDataTable bindingEefCompAblTipo) {
		this.bindingEefCompAblTipo = bindingEefCompAblTipo;
	}
	public FlotChartRendererData getChartDataEefCompDiag() {
		return chartDataEefCompDiag;
	}
	public void setChartDataEefCompDiag(FlotChartRendererData chartDataEefCompDiag) {
		this.chartDataEefCompDiag = chartDataEefCompDiag;
	}
	public FlotChartRendererData getChartDataEefCompAbl() {
		return chartDataEefCompAbl;
	}
	public void setChartDataEefCompAbl(FlotChartRendererData chartDataEefCompAbl) {
		this.chartDataEefCompAbl = chartDataEefCompAbl;
	}
	public FlotChartRendererData getChartDataEefCompTipoDiag() {
		return chartDataEefCompTipoDiag;
	}
	public void setChartDataEefCompTipoDiag(
			FlotChartRendererData chartDataEefCompTipoDiag) {
		this.chartDataEefCompTipoDiag = chartDataEefCompTipoDiag;
	}
	public FlotChartRendererData getChartDataEefCompTipoAbl() {
		return chartDataEefCompTipoAbl;
	}
	public void setChartDataEefCompTipoAbl(
			FlotChartRendererData chartDataEefCompTipoAbl) {
		this.chartDataEefCompTipoAbl = chartDataEefCompTipoAbl;
	}
	public ArrayList<EstadisticasBasicas> getImpcomp() {
		return impcomp;
	}
	public void setImpcomp(ArrayList<EstadisticasBasicas> impcomp) {
		this.impcomp = impcomp;
	}
	public HtmlDataTable getBindingImpComp() {
		return bindingImpComp;
	}
	public void setBindingImpComp(HtmlDataTable bindingImpComp) {
		this.bindingImpComp = bindingImpComp;
	}
	public ArrayList<EstadisticasBasicas> getImpcomptipo() {
		return impcomptipo;
	}
	public void setImpcomptipo(ArrayList<EstadisticasBasicas> impcomptipo) {
		this.impcomptipo = impcomptipo;
	}
	public HtmlDataTable getBindingImpCompTipo() {
		return bindingImpCompTipo;
	}
	public void setBindingImpCompTipo(HtmlDataTable bindingImpCompTipo) {
		this.bindingImpCompTipo = bindingImpCompTipo;
	}
	public FlotChartRendererData getChartDataImpComp() {
		return chartDataImpComp;
	}
	public void setChartDataImpComp(FlotChartRendererData chartDataImpComp) {
		this.chartDataImpComp = chartDataImpComp;
	}
	public FlotChartRendererData getChartDataImpCompTipo() {
		return chartDataImpCompTipo;
	}
	public void setChartDataImpCompTipo(FlotChartRendererData chartDataImpCompTipo) {
		this.chartDataImpCompTipo = chartDataImpCompTipo;
	}
	public ArrayList<EstadisticasBasicas> getRegcomp() {
		return regcomp;
	}
	public void setRegcomp(ArrayList<EstadisticasBasicas> regcomp) {
		this.regcomp = regcomp;
	}
	public HtmlDataTable getBindingRegComp() {
		return bindingRegComp;
	}
	public void setBindingRegComp(HtmlDataTable bindingRegComp) {
		this.bindingRegComp = bindingRegComp;
	}
	public ArrayList<EstadisticasBasicas> getRegcomptipo() {
		return regcomptipo;
	}
	public void setRegcomptipo(ArrayList<EstadisticasBasicas> regcomptipo) {
		this.regcomptipo = regcomptipo;
	}
	public HtmlDataTable getBindingRegCompTipo() {
		return bindingRegCompTipo;
	}
	public void setBindingRegCompTipo(HtmlDataTable bindingRegCompTipo) {
		this.bindingRegCompTipo = bindingRegCompTipo;
	}
	public FlotChartRendererData getChartDataRegComp() {
		return chartDataRegComp;
	}
	public void setChartDataRegComp(FlotChartRendererData chartDataRegComp) {
		this.chartDataRegComp = chartDataRegComp;
	}
	public FlotChartRendererData getChartDataRegCompTipo() {
		return chartDataRegCompTipo;
	}
	public void setChartDataRegCompTipo(FlotChartRendererData chartDataRegCompTipo) {
		this.chartDataRegCompTipo = chartDataRegCompTipo;
	}
	public ArrayList<EstadisticasBasicas> getGenprocscomp() {
		return genprocscomp;
	}
	public void setGenprocscomp(ArrayList<EstadisticasBasicas> genprocscomp) {
		this.genprocscomp = genprocscomp;
	}
	public HtmlDataTable getBindingGenProcsComp() {
		return bindingGenProcsComp;
	}
	public void setBindingGenProcsComp(HtmlDataTable bindingGenProcsComp) {
		this.bindingGenProcsComp = bindingGenProcsComp;
	}
	public FlotChartRendererData getChartDataGenProcComp() {
		return chartDataGenProcComp;
	}
	public void setChartDataGenProcComp(FlotChartRendererData chartDataGenProcComp) {
		this.chartDataGenProcComp = chartDataGenProcComp;
	}
	public ArrayList<EstadisticasBasicas> getGentipocomp() {
		return gentipocomp;
	}
	public void setGentipocomp(ArrayList<EstadisticasBasicas> gentipocomp) {
		this.gentipocomp = gentipocomp;
	}
	public HtmlDataTable getBindingGenTipoComp() {
		return bindingGenTipoComp;
	}
	public void setBindingGenTipoComp(HtmlDataTable bindingGenTipoComp) {
		this.bindingGenTipoComp = bindingGenTipoComp;
	}
	public FlotChartRendererData getChartDataGenTipoComp() {
		return chartDataGenTipoComp;
	}
	public void setChartDataGenTipoComp(FlotChartRendererData chartDataGenTipoComp) {
		this.chartDataGenTipoComp = chartDataGenTipoComp;
	}
	public Integer getTotalCompNoAsig() {
		return totalCompNoAsig;
	}
	public void setTotalCompNoAsig(Integer totalCompNoAsig) {
		this.totalCompNoAsig = totalCompNoAsig;
	}
}

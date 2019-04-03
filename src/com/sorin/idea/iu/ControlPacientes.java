package com.sorin.idea.iu;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
import org.richfaces.component.html.HtmlDataTable;

import com.sorin.idea.dao.ArrCardioversionDao;
import com.sorin.idea.dao.ArrEstudioDao;
import com.sorin.idea.dao.ArrListaEsperaDao;
import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ArrMesasDao;
import com.sorin.idea.dao.ArrPacienteDao;
import com.sorin.idea.dao.ArrPacienteHcardioDao;
import com.sorin.idea.dao.ArrPacienteHclinDao;
import com.sorin.idea.dao.ArrPacientesDao;
import com.sorin.idea.dao.ArrRegistradorDao;
import com.sorin.idea.dao.ArrTestAtpDao;
import com.sorin.idea.dao.ArrTestEpiDao;
import com.sorin.idea.dao.ArrTestFleDao;
import com.sorin.idea.dao.ComplicacionesDao;
import com.sorin.idea.dao.ComplicacionesPacientesDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dao.HolterDao;
import com.sorin.idea.dao.ImpGeneradorDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.PacienteDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.ProtocolosDao;
import com.sorin.idea.dao.RegistradorEventosExtDao;
import com.sorin.idea.dao.SegSeguimientoClinicoDao;
import com.sorin.idea.dao.SegSeguimientoRegEventosDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.TestOrtostatismoActivoDao;
import com.sorin.idea.dto.ArrAccesoModulos;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrEstudio;
import com.sorin.idea.dto.ArrListaEspera;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrMesas;
import com.sorin.idea.dto.ArrRegistrador;
import com.sorin.idea.dto.ArrTestAtp;
import com.sorin.idea.dto.ArrTestEpi;
import com.sorin.idea.dto.ArrTestFle;
import com.sorin.idea.dto.Complicaciones;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.Holter;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ModeloBdu;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.RegistradorEventosExt;
import com.sorin.idea.dto.SegSeguimientoClinico;
import com.sorin.idea.dto.SegSeguimientoRegEventos;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaGeneralPk;
import com.sorin.idea.dto.TestOrtostatismoActivo;
import com.sorin.idea.exceptions.ArrListaEsperaDaoException;
import com.sorin.idea.exceptions.ArrMaestrasDaoException;
import com.sorin.idea.jdbc.ArrCardioversionDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioDaoImpl;
import com.sorin.idea.jdbc.ArrListaEsperaDaoImpl;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ArrMesasDaoImpl;
import com.sorin.idea.jdbc.ArrPacienteHcardioDaoImpl;
import com.sorin.idea.jdbc.ArrPacienteHclinDaoImpl;
import com.sorin.idea.jdbc.ArrPacientesDaoImpl;
import com.sorin.idea.jdbc.ArrRegistradorDaoImpl;
import com.sorin.idea.jdbc.ArrTestAtpDaoImpl;
import com.sorin.idea.jdbc.ArrTestEpiDaoImpl;
import com.sorin.idea.jdbc.ArrTestFleDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesPacientesDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.HolterDaoImpl;
import com.sorin.idea.jdbc.ImpGeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ProtocolosDaoImpl;
import com.sorin.idea.jdbc.RegistradorEventosExtDaoImpl;
import com.sorin.idea.jdbc.SegSeguimientoClinicoDaoImpl;
import com.sorin.idea.jdbc.SegSeguimientoRegEventosDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.TestOrtostatismoActivoDaoImpl;
import com.sorin.idea.util.ConsentimientoBean;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.ExportExcel;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.ProcedimientosClinicos;
import com.sorin.idea.util.UtilConversorTarjetaEuropea;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilSituacionClinica;

import hvn.cm.dao.DAOException;
import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

public class ControlPacientes extends BaseIU {

	private static final long serialVersionUID = 1L;
	private static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
	private static Logger logger = Logger.getLogger(ControlPacientes.class);

	private LoginForm lf;
	private String usuario;
	private String nombreusuario;
	private ArrAccesoModulos[] usermods;
	private SelectorIdioma si;
	private ResourceBundle bundle;
	ArrayList<PacienteAplDto> lstPacientes = new ArrayList();
	String situacion = "D";
	String checkbudape;
	ModeloBdu modeloBdu = new ModeloBdu();
	HtmlDataTable tablaBindingBusqueda = new HtmlDataTable();
	PacienteAplDto filtro = new PacienteAplDto();
	PacienteAplDto pacienteSelect = new PacienteAplDto();
	ArrayList<PacienteAplDto> listaPacientes = new ArrayList<PacienteAplDto>();
	private Integer modPaci = 0;
	private PacienteDao gp = new PacienteDao();
	private ArrPacienteDao arrpacientedao;
	private ArrPacientesDao patdao;

	// Busqueda de pacientes.
	private org.apache.myfaces.component.html.ext.HtmlDataTable bindingTabla;
	private int filaMarcada;
	private Integer pagina_inicial = 1;
	private String columna = "apellido1";
	private boolean ascendente = true;

	private ControlMaestras cm;
	private ArrMaestras[] caracter;
	private ArrMaestras[] hospital;
	private ArrMaestras[] funcion;
	
	private ArrMaestras[] arritmiasle;
	private ArrMaestras[] procedimientosle;
	private ArrMaestras[] caracterle;
	private ArrMaestras[] anticoagulantele;
	private ArrMaestras[] operadoresle;
	
	private ArrMaestras[] cardiopatia;

	private ArrListaEsperaDao ledao;
	private ArrayList<ArrListaEspera> lstespera;
	private Integer leselec;
	private ArrListaEspera regselec;
	
	/*********************/
	 private ArrayList<ProcedimientosClinicos> listproc;
	 private String json;
	 private String jsonstart;
	 private String jsonend;
	 private Generador[] generadores;
	 private int numeroprocedimientobarratemporal;
	private String tipoprocedimientobarratemporal;
	private String fechaprocedimientobarratemporal;
	private String infoprocedimientobarratemporal;
	private String modeloprocedimientobarratemporal;
	private String dispprocedimientobarratemporal;
	private boolean esImplante;
	private int tipoprocedimiento;
	private SituacionClinicaGeneral sitclin;
	private SituacionClinicaGeneralPk sitclinpk;
	private HtmlDataTable bindingSintomas;
	
	/**********************/
	
	private int tipoinforme;
	private InfoCentro infocentro;
	
	private ProcedimientoDao procdao;
	private ArrEstudioDao eefdao;
	private ArrMesasDao mesadao;
	private ArrRegistradorDao regdao;
	private ArrTestAtpDao atpdao;
	private ArrTestEpiDao epidao;
	private ArrTestFleDao fledao;
	private ArrCardioversionDao cvdao;
	private ImpImplanteDao idao;
	private ImpGeneradorDao igdao;
	private SegSeguimientoClinicoDao segclindao;
	private SegSeguimientoRegEventosDao segregevdao;
	private HolterDao holterdao;
	private RegistradorEventosExtDao regevextdao;
	private TestOrtostatismoActivoDao testortodao;
	private ComplicacionesDao compdao;
	private ComplicacionesPacientesDao compacdao;
	private ProtocolosDao protdao;
	
	private ControlMedicacion cmed;
	private ConsentimientoBean consmps;
	private ConsentimientoBean consdai;
	private ConsentimientoBean consrec;
	private ConsentimientoBean conshol;
	private ConsentimientoBean constran;
	private ConsentimientoBean consexp;
	private ConsentimientoBean consmri;
	
	private boolean verComplicaciones;
	
	/*******/
    private boolean booleanPrimoImplante = false ;
    private boolean booleanReintervencion = false ;
    private boolean booleanRecambioDispositivo = false ;
    private boolean booleanUpgradeDispositivo = false ;
    private boolean booleanRecolocacionGenerador = false  ;
    private boolean booleanRecolocacionElectrodo= false  ;
    private boolean booleanReimplante = false ;
    private boolean booleanExplanteDispositivo = false ;
    private boolean booleanEEF = false ;
    private boolean booleanCardioversi�nElectrica = false  ;
    private boolean booleanMesa= false   ;
    private boolean booleanRegistradorEventos= false ;
    private boolean booleanTestATP= false ;
    private boolean booleanTestEpinefrina= false ;
    private boolean booleanTestFlecainida= false ;
    private boolean booleanSeguimientoDispositivo= false ;
    private boolean booleanSeguimientoCl�nico= false ;
    private boolean booleanSeguimientoRegistradorEventos= false ;
    private boolean booleanHolter = false  ;
    private boolean booleanRegistradorEventosExterno = false  ;
    private boolean booleanListaEspera = false;
	private boolean booleanTestOrto = false;
	private boolean booleanProtocolos = false;
	
	/**
	 * Constructor de la clase donde se inicializa todas las listas de selecci�n
	 * de la aplicaci�n.
	 */
	public ControlPacientes() {
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			// almacenamos los datos del usuario.
			//LoginForm loginform;
			//loginform = (LoginForm) getBean("loginForm");
			//this.usuario = loginform.getSesionUsuario().getUsuario();
			//this.nombreusuario = UtilDatos.obtenerNombreUsuario(loginform.getSesionUsuario());
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getAcceso().getUsuario();
			this.nombreusuario = UtilDatos.obtenerNombreUsuario(lf.getAcceso());
			//this.usermods = loginform.getAccmods();
			this.usermods = lf.getAccmods();
			this.arrpacientedao = new ArrPacienteDao(this.usuario);
			this.patdao = new ArrPacientesDaoImpl(this.usuario);
			this.lstespera = new ArrayList<ArrListaEspera>();
			this.ledao = new ArrListaEsperaDaoImpl(this.usuario);
			this.regselec = new ArrListaEspera();
			this.regselec.setIngreso(new Date());
			this.setSitclin(new SituacionClinicaGeneral());
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			
			lecturaProperties();
			
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.eefdao = new ArrEstudioDaoImpl(this.usuario);
			this.mesadao = new ArrMesasDaoImpl(this.usuario);
			this.regdao = new ArrRegistradorDaoImpl(this.usuario);
			this.atpdao = new ArrTestAtpDaoImpl(this.usuario);
			this.epidao = new ArrTestEpiDaoImpl(this.usuario);
			this.fledao = new ArrTestFleDaoImpl(this.usuario);
			this.cvdao = new ArrCardioversionDaoImpl(this.usuario);
			this.idao = new ImpImplanteDaoImpl(this.usuario);
			this.igdao = new ImpGeneradorDaoImpl(this.usuario);
			this.segclindao = new SegSeguimientoClinicoDaoImpl(this.usuario);
			this.segregevdao = new SegSeguimientoRegEventosDaoImpl(this.usuario);
			this.holterdao = new HolterDaoImpl(this.usuario);
			this.regevextdao = new RegistradorEventosExtDaoImpl(this.usuario);
			this.testortodao = new TestOrtostatismoActivoDaoImpl(this.usuario);
			this.compdao = new ComplicacionesDaoImpl(this.usuario);
			this.compacdao = new ComplicacionesPacientesDaoImpl(this.usuario);
			this.protdao = new ProtocolosDaoImpl(this.usuario);
			this.consmps = new ConsentimientoBean();
			this.consdai = new ConsentimientoBean();
			this.consrec = new ConsentimientoBean();
			this.conshol = new ConsentimientoBean();
			this.constran = new ConsentimientoBean();
			this.consmri = new ConsentimientoBean();
			this.consexp = new ConsentimientoBean();
		} catch (IUException e) {
			logError(this.bundle.getString("info_msg_error_carga_user"));
		}
	}
	
	public void iniciar(ActionEvent e ){
		this.inicia();
		try {
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
			if(this.modPaci==1)
				precarga(null);
		} catch (IUException e1) {
			this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_inicio_mod"));
		}
	}

	public void inicia() {
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			this.caracter = cm.getCaracterProcedencia();
			this.hospital = cm.getHospitalProcedencia();
			this.funcion = cm.getFuncionVentricular();
			this.arritmiasle = cm.getArritmiasLE();
			this.procedimientosle = cm.getProcedimientosLE();
			this.caracterle = cm.getCaracterLE();
			this.anticoagulantele = cm.getAnticoagulanteLE();
			this.cardiopatia = cm.getCardiopatia();
			this.operadoresle = cm.getPrimerOperador();
			cargaGeneradores();
			
			if ( lf!= null && lf.getAccmods() != null ) {
				List<ArrAccesoModulos> listaModulos = Arrays.asList( lf.getAccmods() );
				for( ArrAccesoModulos arrAccesoModulos : listaModulos ) {
					accesoModulos(arrAccesoModulos.getIdTipoProcedimiento());
				}
			}
			
			// Score CHADVASC
			if(this.pacienteSelect.getCodigo()!=null){
				int scor = -1;
				if(this.pacienteSelect.getEdad()!=null)
					scor = UtilSituacionClinica.calcularScoreCHADSVASC(this.pacienteSelect.getSitclin().getNyha(), this.pacienteSelect.getSitclin().getFuncionventricular(), this.pacienteSelect.getSitclin().getHta(), this.pacienteSelect.getEdad()!=null?Integer.parseInt(this.pacienteSelect.getEdad()):null, this.pacienteSelect.getSitclin().getDiabetes(), this.pacienteSelect.getSitclin().getAcv(), this.pacienteSelect.getSitclin().getAit(), this.pacienteSelect.getSitclin().getEnfart(), this.pacienteSelect.getSexo());						
				this.pacienteSelect.getSitclin().setScorechadsvasc(scor);
				this.pacienteSelect.getSitclin().setScorechadsvascporcent(UtilSituacionClinica.obtenerRiesgoIctus(scor));
				
			}
		} catch (ArrMaestrasDaoException e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_inicio_dmaestras"));
		} catch (IUException e) {
			this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_inicio_mod"));
		}
	}
	
	// -------------------------------------------------------------------------------------------------

	public void seleccionaPacienteBdu(ActionEvent e) {

		try {
			filtro = lstPacientes.get(tablaBindingBusqueda.getRowIndex());
			/*filtro = new PacienteAplDto(lstPacientes.get(tablaBindingBusqueda
					.getRowIndex()));
			filtro.setNhc(gp.getPacientesByNUHSA(filtro.getNuhsa()));*/
		} catch (Exception ex) {
			this.pintaMensaje(3,
					this.bundle.getString("pat_msg_error_consulta_lista")+":" + ex.getMessage());
		}
	}

	// -------------------------------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	public void buscaPacientePorApellidosBdu(ActionEvent e) {
		try {
			lstPacientes = new ArrayList();
			/*lstPacientes = (ArrayList) modeloBdu
					.buscaPacienteBduPorPacienteDto(filtro, FacesContext
							.getCurrentInstance());*/
			PacienteDao gp = new PacienteDao();
			this.lstPacientes = gp.getPacientesByFiltro_Conciliado(filtro);
			if(this.lstPacientes.size() == 0)
				this.lstPacientes = gp.getPacientesByFiltro_NoConc(filtro);
			checkbudape = "javascript:Richfaces.hideModalPanel('acceso');javascript:Richfaces.showModalPanel('busqueda');";

		} catch (Exception ex) {
			this.pintaMensaje(3, this.bundle.getString("pat_msg_error_consulta_bdu")+":" + ex.getMessage());
			checkbudape = "javascript:Richfaces.hideModalPanel('acceso')";
		}
	}

	// -------------------------------------------------------------------------------------------------

	@SuppressWarnings("unchecked")
	public void buscaPacientePorNifBdu(ActionEvent e) {
		try {
			lstPacientes = new ArrayList();
			/*lstPacientes = (ArrayList) modeloBdu.buscaPacienteBduPorNIF(filtro,
					FacesContext.getCurrentInstance());*/
			PacienteDao gp = new PacienteDao();
			try{
				Integer nif = new Integer(this.filtro.getDni());
			}catch (Exception e1) {
				throw new Exception("Introduzca el DNI sin letra");
			}
			this.lstPacientes = gp.getPacientesByFiltro_Conciliado(filtro);
			if(this.lstPacientes.size() == 0)
				this.lstPacientes = gp.getPacientesByFiltro_NoConc(filtro);
			checkbudape = "javascript:Richfaces.hideModalPanel('acceso');javascript:Richfaces.showModalPanel('busqueda');";
		} catch (Exception ex) {
			this.pintaMensaje(3, this.bundle.getString("pat_msg_error_consulta_bdu")+":" + ex.getMessage());
			checkbudape = "javascript:Richfaces.hideModalPanel('acceso')";
		}

	}

	@SuppressWarnings("unchecked")
	public void buscaPacientePorNSSBdu(ActionEvent e) {
		try {
			lstPacientes = new ArrayList();
			lstPacientes = (ArrayList) modeloBdu.buscaPacienteBduPorNSS(filtro,
					FacesContext.getCurrentInstance());
			checkbudape = "javascript:Richfaces.hideModalPanel('acceso');javascript:Richfaces.showModalPanel('busqueda');";
		} catch (Exception ex) {
			this.pintaMensaje(3, this.bundle.getString("pat_msg_error_consulta_bdu")+":" + ex.getMessage());
			checkbudape = "javascript:Richfaces.hideModalPanel('acceso')";
		}

	}

	@SuppressWarnings("unchecked")
	public void buscaPacientePorNUHSABdu(ActionEvent e) {
		try {
			lstPacientes = new ArrayList();
			lstPacientes = (ArrayList) modeloBdu.buscaPacienteBduPorNUHSA(
					filtro, FacesContext.getCurrentInstance());
			checkbudape = "javascript:Richfaces.hideModalPanel('acceso');javascript:Richfaces.showModalPanel('busqueda');";
		} catch (Exception ex) {
			this.pintaMensaje(3, this.bundle.getString("pat_msg_error_consulta_bdu")+":" + ex.getMessage());
			checkbudape = "javascript:Richfaces.hideModalPanel('acceso')";
		}

	}

	// -------------------------------------------------------------------------------------------------

	/**
	 * Evento que busca los datos de un pacinte registrado en el hospital.
	 */
	public void buscaPacientePorNhc(ActionEvent event) {
		lstPacientes = new ArrayList<PacienteAplDto>();
		try {
			String aux = this.filtro.getNhc();			
			if(existePaciente_NHC(aux)){
				this.pintaMensaje(ERROR, this.bundle.getString("pat_msg_warn_consulta_nhc_1")+" "+this.filtro.getNhc()+" "+this.bundle.getString("pat_msg_warn_consulta_nhc_1_1"));
			}else{
				this.filtro = gp.getPacientesByNHC_Conciliado(aux);
				if (this.filtro == null || this.filtro.getNombre().equals(""))
					this.filtro = gp.getPacientesByNHC_NoConc(aux);
				// a�adimos la letra al DNI si tiene registrado el n�mero de DNI.
				if (this.filtro.getDni() != null && !this.filtro.getDni().equals("")) {
					if (!this.filtro.getDni().startsWith("-"))
						this.filtro.setDni(nifFromDni(Integer.parseInt(this.filtro.getDni())));
				}
			}
		} catch (Exception e) {
			this.pintaMensaje(3, this.bundle.getString("pat_msg_error_consulta_clinica")+":" + e.getMessage());
		}
	}

	public boolean existePaciente_NHC(String nhc){
		try{
			return this.patdao.findWhereNhcEquals(nhc).length>0?true:false;
		}catch(Exception ex){
			logger.error("("+this.usuario+") Error en b�squeda duplicado paciente por NHC. NHC: "+nhc);
			return true;// devuelve true para evitar que se puedan meter duplicados...
		}
	}
	/**
	 * Evento que limpia el contenido del paciente nuevo.
	 * 
	 * @param e
	 */
	public void limpiarPacienteNuevo(ActionEvent e) {
		// Limpia la barra temporal
		this.json="";
		// Limpiamos los datos del paciente nuevo
		this.filtro = new PacienteAplDto();
		this.pacienteSelect = new PacienteAplDto();
		// Indicamo que no ya no hay una posible modificaci�n de los datos del
		// paciente.
		this.modPaci = 0;
		this.lstespera = new ArrayList<ArrListaEspera>();
		this.consmps = new ConsentimientoBean();
		this.consdai = new ConsentimientoBean();
		this.consrec = new ConsentimientoBean();
		try {
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);
		} catch (IUException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	public void limpiarPacienteSelect(ActionEvent event) {
		// Limpia la barra temporal
		this.json="";
		// limpiamos los datos de los citerios de selecci�n para la b�squeda de
		// pacientes.
		this.filtro = new PacienteAplDto();
		// Limpiamos la lista de pacientes buscados.
		this.listaPacientes = new ArrayList<PacienteAplDto>();
		this.pagina_inicial = 1;
		try {
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
		} catch (IUException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/*----------------------------------------------------------------------------------------------*/

	/**
	 * Evento que busca los pacientes registrados en la aplicaci�n seg�n los
	 * criterios introducidos.
	 */
	public void buscaPacientes(ActionEvent event) {
		try {
			if(this.filtro.getTipoproc()==0 && (this.filtro.getFechaproc()!=null||this.filtro.getFechaprocfin()!=null||this.filtro.getNproc().length()>0))
				this.pintaMensaje(ERROR, this.bundle.getString("pat_msg_warn_consulta_tipo_proc"));
			else{
				if(this.filtro.getFechaprocfin()==null && this.filtro.getFechaproc()!=null)
					this.filtro.setFechaprocfin(new Date());				
				
				this.listaPacientes = this.arrpacientedao.buscaPacientes(this.filtro);
				logger.info("("+this.usuario+") Buscando paciente "+this.filtro.getNhc());
				if(this.listaPacientes.size()==0)
					this.pintaMensaje(INFO, this.bundle.getString("pat_msg_warn_consulta_no_res"));
			}	
		} catch (DAOException e) {
			this.pintaMensaje(3, this.bundle.getString("pat_msg_error_consulta_generico")+": " + e.getMessage());
			logger.error("("+this.usuario+") Error a la hora de buscar el paciente "+this.filtro.getNhc()+" - "+ e.getMessage());
		}
	}
	/**
	 * Evento que busca los pacientes registrados en la aplicaci�n 
	 * a partir de una fecha de procedimiento introducida.
	 */
	public void buscaPacientesPorFechaProcedimiento(ActionEvent event) {
		try {
			this.listaPacientes = this.arrpacientedao.buscaPacientes(this.filtro);
			logger.info("("+this.usuario+") Buscando paciente "+this.filtro.getNhc());
			if(this.listaPacientes.size()==0)
				this.pintaMensaje(INFO, this.bundle.getString("pat_msg_warn_consulta_no_res"));
		} catch (DAOException e) {
			this.pintaMensaje(3, this.bundle.getString("pat_msg_error_consulta_generico")+":" + e.getMessage());
			logger.error("("+this.usuario+") Error a la hora de buscar el paciente "+this.filtro.getNhc()+" - "+ e.getMessage());
		}
	}

	/**
	 * Evento que busca los pacientes registrados en la aplicaci�n seg�n los
	 * criterios introducidos.
	 */
	public void guardarPaciente(ActionEvent event) {
		try {
			// FRR - Funcionalidad. Limite N pacientes
			/*if(this.arrpacientedao.obtenerNumPaciente()>30)
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,
						"Se ha superado el l�mite de pacientes para versi�n DEMO");*/
			//else{
				if (this.filtro == null || this.filtro.getNombre() == null
						|| this.filtro.getNombre().length() == 0 
						|| this.filtro.getNhc().length()==0
						/*|| this.filtro.getDni() == null
						|| this.filtro.getDni().length() == 0*/)
					this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("pat_msg_warn_guarda"));
				else {
					if (this.modPaci == 0) {
						if (!this.arrpacientedao.existePaciente(this.filtro)) {
							Integer codigo = (this.arrpacientedao.insertarPaciente(this.filtro));
							this.filtro.setCodigo(codigo);
							logger.info("("+this.usuario+") Insertando nuevo paciente. Id Paciente:"+this.filtro.getCodigo());
							/*ArrListaEspera le = new ArrListaEspera();
							le.setCodigoPaciente(codigo);
							le.setEstado(1);
							le.setIngreso(UtilFechas.StringToDate(UtilFechas.getFechaActual()));
							this.ledao.insert(le);*/
						} else{
							//this.filtro.setCodigo(this.arrpacientedao.obtienePaciente(this.filtro));
							//this.arrpacientedao.modificaPaciente(this.filtro);
							this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("pat_msg_warn_guarda_prev"));
							logger.info("("+this.usuario+") Actualizando paciente. Id Paciente:"+this.filtro.getCodigo());
						}
					} else {
						if (!this.arrpacientedao.existePaciente(this.filtro)) {
							Integer codigo = (this.arrpacientedao.insertarPaciente(this.filtro));
							this.filtro.setCodigo(codigo);
							logger.info("("+this.usuario+") Insertando nuevo paciente. Id Paciente:"+this.filtro.getCodigo());
							/*ArrListaEspera le = new ArrListaEspera();
							le.setCodigoPaciente(codigo);
							le.setEstado(1);
							le.setIngreso(UtilFechas.StringToDate(UtilFechas.getFechaActual()));
							this.ledao.insert(le);*/
						} else{
							if(this.filtro.getCodigo() == null)
								this.filtro.setCodigo(this.arrpacientedao.obtienePaciente(this.filtro));
							this.arrpacientedao.modificaPaciente(this.filtro);
							logger.info("("+this.usuario+") Actualizando paciente. Id Paciente:"+this.filtro.getCodigo());
						}
					}

					if (this.filtro.getCodigo() != null) {
						this.modPaci = 1;
						
						this.filtro.getHcardio().setIdpaciente(this.filtro.getCodigo());
						this.filtro.getHclin().setIdpaciente(this.filtro.getCodigo());
						ArrPacienteHcardioDao hcardiodao = new ArrPacienteHcardioDaoImpl(this.usuario);
						ArrPacienteHclinDao hclindao = new ArrPacienteHclinDaoImpl(this.usuario);
						hcardiodao.delete(this.filtro.getHcardio().createPk());
						hcardiodao.insert(this.filtro.getHcardio());
						hclindao.delete(this.filtro.getHclin().createPk());
						hclindao.insert(this.filtro.getHclin());
						
						this.filtro.getSitclin().setIdpaciente(this.filtro.getCodigo());
						//this.filtro.getSitclin().setFechamod(null);
						if(this.filtro.getSitclin().getFechacreacion()==null)
							this.filtro.getSitclin().setFechacreacion(new Date());
						SituacionClinicaGeneralDao sitclindao = new SituacionClinicaGeneralDaoImpl(this.usuario);
						sitclindao.delete(this.filtro.getSitclin().createPk());
						sitclindao.insert(this.filtro.getSitclin());
						// Score CHADVASC
						int scor = -1;
						if(this.pacienteSelect.getEdad()!=null)
							scor = UtilSituacionClinica.calcularScoreCHADSVASC(this.pacienteSelect.getSitclin().getNyha(), this.pacienteSelect.getSitclin().getFuncionventricular(), this.pacienteSelect.getSitclin().getHta(), this.pacienteSelect.getEdad()!=null?Integer.parseInt(this.pacienteSelect.getEdad()):null, this.pacienteSelect.getSitclin().getDiabetes(), this.pacienteSelect.getSitclin().getAcv(), this.pacienteSelect.getSitclin().getAit(), this.pacienteSelect.getSitclin().getEnfart(), this.pacienteSelect.getSexo());						
						this.pacienteSelect.getSitclin().setScorechadsvasc(scor);
						this.pacienteSelect.getSitclin().setScorechadsvascporcent(UtilSituacionClinica.obtenerRiesgoIctus(scor));
						
						ArrListaEspera filtrole = new ArrListaEspera();
						filtrole.setCodigoPaciente(this.filtro.getCodigo());
						filtrole.setIngreso(null);
						filtrole.setIngresomax(null);
						Integer a = null;
						filtrole.setEdadmin(a);
						filtrole.setEdadmax(null);
						this.lstespera = this.ledao.findWhereFiltro(filtrole);
						this.pacienteSelect = this.filtro;
						precarga(null);
						this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("pat_msg_info_guarda"));
						logger.info("("+this.usuario+") Paciente insertado/actualizado con �xito. Id Paciente:"+this.filtro.getCodigo());
					}else{
						this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("pat_msg_error_guarda"));
						logger.error("("+this.usuario+") El paciente no ha sido almacenado/actualizado correctamente. Id Paciente: "+this.filtro.getCodigo());
					}
				}
			//}
			
			//if (this.filtro == null || this.filtro.getNombre() == null
			//		|| this.filtro.getNombre().length() == 0
					/*|| this.filtro.getDni() == null
					|| this.filtro.getDni().length() == 0*//*)*/
			/*	this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,
						"Faltan datos del paciente");
			else {
				if (this.modPaci == 0) {
					if (!this.arrpacientedao.existePaciente(this.filtro)) {
						Integer codigo = (this.arrpacientedao
								.insertarPaciente(this.filtro));
						this.filtro.setCodigo(codigo);
						*//*ArrListaEspera le = new ArrListaEspera();
						le.setCodigoPaciente(codigo);
						le.setEstado(1);
						le.setIngreso(UtilFechas.StringToDate(UtilFechas.getFechaActual()));
						this.ledao.insert(le);*/
					
			/*		} else{
						this.filtro.setCodigo(this.arrpacientedao.obtienePaciente(this.filtro));
						this.arrpacientedao.modificaPaciente(this.filtro);
					}
				} else {
					if (!this.arrpacientedao.existePaciente(this.filtro)) {
						Integer codigo = (this.arrpacientedao.insertarPaciente(this.filtro));
						this.filtro.setCodigo(codigo);
						*//*ArrListaEspera le = new ArrListaEspera();
						le.setCodigoPaciente(codigo);
						le.setEstado(1);
						le.setIngreso(UtilFechas.StringToDate(UtilFechas.getFechaActual()));
						this.ledao.insert(le);*/
				/*	} else{
						this.filtro.setCodigo(this.arrpacientedao.obtienePaciente(this.filtro));
						this.arrpacientedao.modificaPaciente(this.filtro);
					}
				}

				if (this.filtro.getCodigo() != null) {
					this.modPaci = 1;
					this.filtro.getHcardio().setIdpaciente(
							this.filtro.getCodigo());
					this.filtro.getHclin().setIdpaciente(
							this.filtro.getCodigo());
					ArrPacienteHcardioDao hcardiodao = new ArrPacienteHcardioDaoImpl(
							this.usuario);
					ArrPacienteHclinDao hclindao = new ArrPacienteHclinDaoImpl(
							this.usuario);
					hcardiodao.delete(this.filtro.getHcardio().createPk());
					hcardiodao.insert(this.filtro.getHcardio());
					hclindao.delete(this.filtro.getHclin().createPk());
					hclindao.insert(this.filtro.getHclin());
					ArrListaEspera filtrole = new ArrListaEspera();
					filtrole.setCodigoPaciente(this.filtro.getCodigo());
					filtrole.setIngreso(null);
					filtrole.setIngresomax(null);
					Integer a = null;
					filtrole.setEdadmin(a);
					filtrole.setEdadmax(null);
					this.lstespera = this.ledao.findWhereFiltro(filtrole);
					this.pacienteSelect = this.filtro;
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO,
							"Paciente almacenado con �xito");
				}else{
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						"El paciente no ha sido almacenado correctamente.");
				}
			}*/
		} catch (Exception e) {
			this.pintaMensaje(3, this.bundle.getString("pat_msg_error_guarda_excep")+":" + e.getMessage());
			logger.error("("+this.usuario+") Error al guardar el paciente."+ e.getMessage()+". Usuario("+this.usuario+")");
		}
	}

	/**
	 * Evento que busca los pacientes registrados en la aplicaci�n seg�n los
	 * criterios introducidos.
	 */
	public void eliminarPaciente(ActionEvent event) {
		try {
			this.arrpacientedao.eliminaPaciente(this.pacienteSelect);
			this.pacienteSelect = new PacienteAplDto();
			this.filtro = new PacienteAplDto();
			this.modPaci = 0;
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("pat_msg_info_borrar"));
			logger.info("("+this.usuario+") Paciente borrado con �xito. Usuario("+this.usuario+")");
		} catch (DAOException e) {
			this.pintaMensaje(3, this.bundle.getString("pat_msg_error_borrar_excep")+": " + e.getMessage());
			logger.error("("+this.usuario+") Error al borrar el paciente."+ e.getMessage()+". Usuario("+this.usuario+")");
		}
	}

	/**
	 * Evento que obtiene el paciente seleccionado en la tabla del apartado de
	 * consulta de pacientes.
	 */
	public void obtenLinea(ActionEvent e) {
		try {
			this.filaMarcada = this.bindingTabla.getRowIndex();
			this.filtro = this.listaPacientes.get(this.filaMarcada);
			this.pacienteSelect = this.listaPacientes.get(this.filaMarcada);
			this.modPaci = 1;
			// Logica par determinar si hay seguimientos y hablitar la pesta�a en el menu vertical o no
			ControlSeguimientos cseg = (ControlSeguimientos) getBean("controlSeguimientos");
			if (cseg == null) {
				cseg = new ControlSeguimientos();
				cseg.iniciaSeguimientos(null);
			} else {
			}
			cseg.compruebaImplantes();
			
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);
			
			ArrPacienteHcardioDao hcardiodao = new ArrPacienteHcardioDaoImpl(this.usuario);
			ArrPacienteHclinDao hclindao = new ArrPacienteHclinDaoImpl(this.usuario);
			this.filtro.setHcardio(hcardiodao.findByPrimaryKey(this.filtro.getCodigo()));
			this.filtro.setHclin(hclindao.findByPrimaryKey(this.filtro.getCodigo()));
			this.pacienteSelect.setHcardio(this.filtro.getHcardio());
			this.pacienteSelect.setHclin(this.filtro.getHclin());
			
			SituacionClinicaGeneralDao sitclindao = new SituacionClinicaGeneralDaoImpl(this.usuario);
			this.filtro.setSitclin(sitclindao.findByPrimaryKey(this.filtro.getCodigo()));
			organizaSitClin();
			this.pacienteSelect.setSitclin(this.filtro.getSitclin());
			// Calculo del score chadvasc
			int scor = -1;
			if(this.pacienteSelect.getEdad()!=null)
				scor = UtilSituacionClinica.calcularScoreCHADSVASC(this.pacienteSelect.getSitclin().getNyha(), this.pacienteSelect.getSitclin().getFuncionventricular(), this.pacienteSelect.getSitclin().getHta(), this.pacienteSelect.getEdad()!=null?Integer.parseInt(this.pacienteSelect.getEdad()):null, this.pacienteSelect.getSitclin().getDiabetes(), this.pacienteSelect.getSitclin().getAcv(), this.pacienteSelect.getSitclin().getAit(), this.pacienteSelect.getSitclin().getEnfart(), this.pacienteSelect.getSexo());						
			this.pacienteSelect.getSitclin().setScorechadsvasc(scor);
			this.pacienteSelect.getSitclin().setScorechadsvascporcent(UtilSituacionClinica.obtenerRiesgoIctus(scor));
			// Calculo de dosis de escopia acumulada
			ArrayList<ArrayList<Object>> dosisEef = this.procdao.getDosisEscopiaAcumuladaEEF(this.pacienteSelect.getCodigo());
			ArrayList<ArrayList<Object>> dosisImpl = this.procdao.getDosisEscopiaAcumuladaImplantes(this.pacienteSelect.getCodigo());
			this.pacienteSelect.setDosisEscopiaAcum(UtilSituacionClinica.obtenerDosisEscopiaAcumulada(dosisEef, dosisImpl));
			
			ArrListaEspera filtrole = new ArrListaEspera();
			filtrole.setCodigoPaciente(this.pacienteSelect.getCodigo());
			filtrole.setIngreso(null);
			filtrole.setIngresomax(null);
			Integer a = null;
			filtrole.setEdadmin(a);
			filtrole.setEdadmax(null);
			this.lstespera = this.ledao.findWhereFiltro(filtrole);
			precarga(null);
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+": "+ ex.getMessage());
		}
	}

	public void precarga(ActionEvent e){
		try{
			this.listproc = new ArrayList<ProcedimientosClinicos>();
						
			ControlTest ct = (ControlTest) getBean("controlTest");
			if (ct == null)
				ct = new ControlTest();
			ct.iniciaTest(null);
			setBean("controlTest",ct);
			
			ControlMesas cms = (ControlMesas) getBean("controlMesas");
			if (cms == null)
				cms = new ControlMesas();
			cms.iniciaMesas(null);
			setBean("controlMesas",cms);
					
			ControlRegistrador cr = (ControlRegistrador) getBean("controlRegistrador");
			if (cr == null)
				cr = new ControlRegistrador();
			cr.iniciaRegistradores(null);
			setBean("controlRegistrador",cr);
				
			ControlEef ce = (ControlEef) getBean("controlEef");
			if (ce == null)
				ce = new ControlEef();
			ce.iniciaEef(null);
			setBean("controlEef", ce);
			
			ControlCardioversion cv = (ControlCardioversion) getBean("controlCardioversion");
			if (cv == null)
				cv = new ControlCardioversion();
			cv.iniciaCardioversion(null);
			setBean("controlCardioversion", cv);
	
			ControlImplantes cimp = (ControlImplantes) getBean("controlImplantes");
			if(cimp==null)
				cimp = new ControlImplantes();
			cimp.iniciaImplantes(null);
			cimp.setBean("controlImplantes", cimp);
			
			ControlSeguimientosClinicos csegclin = (ControlSeguimientosClinicos) getBean("controlSeguimientosClinicos");
			if(csegclin==null)
				csegclin = new ControlSeguimientosClinicos();
			csegclin.inicia(null);
			csegclin.setBean("controlSeguimientosClinicos", csegclin);
			
			ControlSeguimientosRegEventos csegev = (ControlSeguimientosRegEventos) getBean("controlSeguimientosRegEventos");
			if(csegev==null)
				csegev = new ControlSeguimientosRegEventos();
			csegev.inicia(null);
			csegev.setBean("controlSeguimientosRegEventos", csegev);
			
			ControlHolter cholter = (ControlHolter) getBean("controlHolter");
			if(cholter==null)
				cholter = new ControlHolter();
			cholter.iniciaHolter(null);
			cholter.setBean("controlHolter", cholter);
			
			ControlRegEvExt cregevext = (ControlRegEvExt) getBean("controlRegEvExt");
			if(cregevext==null)
				cregevext = new ControlRegEvExt();
			cregevext.iniciaRegEvExt(null);
			cregevext.setBean("controlRegEvExt", cregevext);
			
			ControlTestOrtostatismo ctestorto = (ControlTestOrtostatismo) getBean("controlTestOrtostatismo");
			if(ctestorto==null)
				ctestorto = new ControlTestOrtostatismo();
			ctestorto.inicia(null);
			ctestorto.setBean("controlTestOrtostatismo", ctestorto);
			
			ControlComplicaciones ccomps = (ControlComplicaciones) getBean("controlComplicaciones");
			if(ccomps==null)
				ccomps = new ControlComplicaciones();
			ccomps.inicia(null);
			ccomps.setBean("controlComplicaciones", ccomps);
			
			ControlProtocolos cpr = (ControlProtocolos) getBean("controlProtocolos");
			if (cpr == null)
				cpr = new ControlProtocolos();
			cpr.inicia(null);
			setBean("controlProtocolos", cpr);
			
			ControlRehabilitacionCardiaca crc = (ControlRehabilitacionCardiaca) getBean("controlRehabilitacionCardiaca");
			if (crc == null)
				crc = new ControlRehabilitacionCardiaca();
			crc.iniciaRehabilitacionCardiaca(null);
			setBean("controlRehabilitacionCardiaca", crc);
			
			ProcedimientoDao procdao = new ProcedimientoDaoImpl();
			Procedimiento[] prs = procdao.findWhereCodigoEquals(this.pacienteSelect.getCodigo());
			ArrayList<Procedimiento> prsimp = new ArrayList<Procedimiento>();	
			boolean implante=false;
			// nuevoPaciente:resumenclinicapaciente:numeroprocedimiento - backup
			GenericosDto auxgen;
			String comentarios=null;
			ArrMaestrasDao maestrasdao = new ArrMaestrasDaoImpl(this.usuario);
			
			List<ArrAccesoModulos> listaModulos = Arrays.asList( this.usermods );
			
			for(Procedimiento p:prs){
				comentarios="";
				
				for( ArrAccesoModulos arrAccesoModulos : listaModulos ) {
					
					if( p.getTipoprocedimiento().equals(956) && arrAccesoModulos.getIdTipoProcedimiento() == 956){
						// Se obtiene como dato: MODELO,TIPODISPOSITIVO,NUMSERIE
						comentarios = obtenerSistemaGeneradorImplante(p.getIdprocedimiento());
						auxgen = obtenerTipoDispositivo(p.getIdprocedimiento());
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_956")+"</div><img src='/idea/img/iconos/dispositivo.png' style='width:22px; height:22px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_956")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"!"+auxgen.getTmpString2()+"!"+auxgen.getTmpString1()+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",956,comentarios));
						prsimp.add(p);
						implante =true;
					}
					else if( p.getTipoprocedimiento().equals(957) && arrAccesoModulos.getIdTipoProcedimiento() == 957 ){
						// Se obtiene como dato: MODELO,TIPODISPOSITIVO,NUMSERIE
						comentarios = obtenerSistemaGeneradorImplante(p.getIdprocedimiento());
						auxgen = obtenerTipoDispositivo(p.getIdprocedimiento());
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_957")+"</div><img src='/idea/img/iconos/Skalpell.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_957")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"!"+auxgen.getTmpString2()+"!"+auxgen.getTmpString1()+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",957,comentarios));
						prsimp.add(p);
						implante =true;
					}
					else if(p.getTipoprocedimiento().equals(983) && arrAccesoModulos.getIdTipoProcedimiento() == 983 ) {
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_983")+"</div><img src='/idea/img/iconos/LastThreeMonths.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_983")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",983,comentarios));
					}
					else if(p.getTipoprocedimiento().equals(993) && arrAccesoModulos.getIdTipoProcedimiento() == 993 ){
						// Se obtiene como dato: MODELO,TIPODISPOSITIVO,NUMSERIE
						comentarios = obtenerSistemaGeneradorImplante(p.getIdprocedimiento());
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_993")+"</div><img src='/idea/img/iconos/Skalpell.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_993")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",993,comentarios));									
						prsimp.add(p);
						implante =true;
					}
					else if(p.getTipoprocedimiento().equals(1085) && arrAccesoModulos.getIdTipoProcedimiento() == 1085 ){
						// Se obtiene como dato: MODELO,TIPODISPOSITIVO,NUMSERIE
						comentarios = obtenerSistemaGeneradorImplante(p.getIdprocedimiento());
						auxgen = obtenerTipoDispositivo(p.getIdprocedimiento());
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1085")+"</div><img src='/idea/img/iconos/Skalpell.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1085")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"!"+auxgen.getTmpString2()+"!"+auxgen.getTmpString1()+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1085,comentarios));									
						prsimp.add(p);
						implante =true;
					}
					else if(p.getTipoprocedimiento().equals(1086) && arrAccesoModulos.getIdTipoProcedimiento() == 1086 ){
						// Se obtiene como dato: MODELO,TIPODISPOSITIVO,NUMSERIE
						comentarios = obtenerSistemaGeneradorImplante(p.getIdprocedimiento());
						auxgen = obtenerTipoDispositivo(p.getIdprocedimiento());
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1086")+"</div><img src='/idea/img/iconos/Skalpell.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1086")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"!"+auxgen.getTmpString2()+"!"+auxgen.getTmpString1()+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1086,comentarios));									
						prsimp.add(p);
						implante =true;
					}
					else if(p.getTipoprocedimiento().equals(1059) && arrAccesoModulos.getIdTipoProcedimiento() == 1059 ){
						// Se obtiene como dato: MODELO,TIPODISPOSITIVO,NUMSERIE
						comentarios = obtenerSistemaGeneradorImplante(p.getIdprocedimiento());
						auxgen = obtenerTipoDispositivo(p.getIdprocedimiento());
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1059")+"</div><img src='/idea/img/iconos/dispositivo.png' style='width:22px; height:22px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1059")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"!"+auxgen.getTmpString2()+"!"+auxgen.getTmpString1()+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1059,comentarios));									
						prsimp.add(p);
						implante =true;
					}
					else if(p.getTipoprocedimiento().equals(1060) && arrAccesoModulos.getIdTipoProcedimiento() == 1060 ){
						// Se obtiene como dato: MODELO,TIPODISPOSITIVO,NUMSERIE
						comentarios = obtenerSistemaGeneradorImplante(p.getIdprocedimiento());
						auxgen = obtenerTipoDispositivo(p.getIdprocedimiento());
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("barra_temp_proc_1060")+"</div><img src='/idea/img/iconos/dispositivo.png' style='width:22px; height:22px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1060")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"!"+auxgen.getTmpString2()+"!"+auxgen.getTmpString1()+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1060,comentarios));									
						prsimp.add(p);
						implante =true;
					}
					else if(p.getTipoprocedimiento().equals(1147) && arrAccesoModulos.getIdTipoProcedimiento() == 1147 ){
						// Se obtiene como dato: MODELO,TIPODISPOSITIVO,NUMSERIE
						comentarios = obtenerSistemaGeneradorImplante(p.getIdprocedimiento());
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1147")+"</div><img src='/idea/img/iconos/Skalpell.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1147")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1147,comentarios));									
						prsimp.add(p);
						implante =true;
					}
					else if(p.getTipoprocedimiento().equals(1090) && arrAccesoModulos.getIdTipoProcedimiento()  == 1090 ){
						// Se obtiene como dato: MODELO,TIPODISPOSITIVO,NUMSERIE
						comentarios = obtenerSistemaGeneradorImplante(p.getIdprocedimiento());
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1090")+"</div><img src='/idea/img/iconos/dispositivo.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1090")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1090,comentarios));									
						prsimp.add(p);
						implante =true;
					}
					else if(p.getTipoprocedimiento().equals(1067) && arrAccesoModulos.getIdTipoProcedimiento() == 1067 ){
						// Se obtiene como dato: explante diagnostico
						ArrRegistrador reg = this.regdao.findByPrimaryKey(p.getIdprocedimiento());
						if(reg!=null){
							comentarios = this.bundle.getString("pat_msg_precarga_resultado")+": ";
							if(reg.getExplanteDiagnostico().equals(1))
								comentarios = comentarios + this.bundle.getString("regev_tab5_exp_motivo_op1")+".";
							else if(reg.getExplanteDiagnostico().equals(2))
								comentarios = comentarios + this.bundle.getString("regev_tab5_exp_motivo_op2")+".";
							else if(reg.getExplanteDiagnostico().equals(3))
								comentarios = comentarios + this.bundle.getString("regev_tab5_exp_motivo_op3")+".";
							else if(reg.getExplanteDiagnostico().equals(4))
								comentarios = comentarios + this.bundle.getString("regev_tab5_exp_motivo_op4")+".";
							else if(reg.getExplanteDiagnostico().equals(5))
								comentarios = comentarios + this.bundle.getString("regev_tab5_exp_motivo_op5")+".";
							else if(reg.getExplanteDiagnostico().equals(6))
								comentarios = comentarios + this.bundle.getString("regev_tab5_exp_motivo_op6")+".";
							else if(reg.getExplanteDiagnostico().equals(7))
								comentarios = comentarios + this.bundle.getString("regev_tab5_exp_motivo_op7")+".";				
							else if(reg.getExplanteDiagnostico().equals(0))
								comentarios = comentarios + this.bundle.getString("no_especificado")+".";
						}
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1067")+"</div><img src='/idea/img/iconos/ViewResults.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1067")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1067,comentarios));									
					}
					else if(p.getTipoprocedimiento().equals(1068) && arrAccesoModulos.getIdTipoProcedimiento() == 1068 ){
						// Se obtiene como dato: resultado cv
						ArrCardioversion cvers = this.cvdao.findByPrimaryKey(p.getCodigo(), p.getIdprocedimiento());
						if(cvers!=null)
							comentarios = this.bundle.getString("pat_msg_precarga_resultado")+": "+(cvers.getIdexitofinal()!=null?(cvers.getIdexitofinal()==0?this.bundle.getString("pat_msg_precarga_fracaso")+".":this.bundle.getString("pat_msg_precarga_exito")+"."):" "+this.bundle.getString("no_especificado")+".");
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1068")+"</div><img src='/idea/img/iconos/shock.png' style='width:28px; height:28px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1068")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1068,comentarios));														
					}
					else if(p.getTipoprocedimiento().equals(1066) && arrAccesoModulos.getIdTipoProcedimiento() == 1066 ){
						// Se obtiene como dato: resultado 
						ArrMesas mesa = this.mesadao.findByPrimaryKey(p.getIdprocedimiento());
						if(mesa!=null)
							comentarios = this.bundle.getString("pat_msg_precarga_resultado")+": "+(mesa.getResN1()!=null || mesa.getResN1()==-1?(mesa.getResN1()==0?this.bundle.getString("mesa_tab3_res_op0")+".":this.bundle.getString("mesa_tab3_res_op1")+"."):" "+this.bundle.getString("no_especificado")+".");
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1066")+"</div><img src='/idea/img/iconos/mesabasc.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1066")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1066,comentarios));													
					}
					else if(p.getTipoprocedimiento().equals(1063) && arrAccesoModulos.getIdTipoProcedimiento() == 1063 ){
						// Se obtiene como dato: resultado1 y resultado 2
						ArrTestAtp atp = this.atpdao.findByPrimaryKey(p.getIdprocedimiento());
						if(atp!=null){
							comentarios = this.bundle.getString("pat_msg_precarga_test_atp_1dosis")+": "+(atp.getDosis1()!=null && atp.getDosis1()!=0?maestrasdao.findByPrimaryKey(atp.getDosis1()).getValor()+".":" "+this.bundle.getString("no_especificado")+".");
							comentarios = comentarios + "\n"+this.bundle.getString("pat_msg_precarga_test_atp_2dosis")+": "+(atp.getDosis2()!=null && atp.getDosis2()!=0?maestrasdao.findByPrimaryKey(atp.getDosis2()).getValor()+".":" "+this.bundle.getString("no_especificado")+".");
						}
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1063")+"</div><img src='/idea/img/iconos/Pills.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1063")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1063,comentarios));														
					}
					else if(p.getTipoprocedimiento().equals(1064) && arrAccesoModulos.getIdTipoProcedimiento() == 1064 ){
						// Se obtiene como dato: resultado1 y resultado 2
						ArrTestEpi epi = this.epidao.findByPrimaryKey(p.getIdprocedimiento());
						if(epi!=null){
							comentarios = this.bundle.getString("pat_msg_precarga_test_atp_1dosis")+": "+(epi.getDosis1()!=null && epi.getDosis1()!=0?maestrasdao.findByPrimaryKey(epi.getDosis1()).getValor()+".":" "+this.bundle.getString("no_especificado")+".");					
						}
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1064")+"</div><img src='/idea/img/iconos/Pills.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1064")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1064,comentarios));														
					}
					else if(p.getTipoprocedimiento().equals(1065) && arrAccesoModulos.getIdTipoProcedimiento() == 1065 ){
						// Se obtiene como dato: resultado1 y resultado 2
						ArrTestFle fle = this.fledao.findByPrimaryKey(p.getIdprocedimiento());
						if(fle!=null){
							comentarios = this.bundle.getString("pat_msg_precarga_resultado")+": "+(fle.getResultado()!=null && fle.getResultado()!=0?maestrasdao.findByPrimaryKey(fle.getResultado()).getValor()+".":" "+this.bundle.getString("no_especificado")+".");
						}
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1065")+"</div><img src='/idea/img/iconos/Pills.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1065")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1065,comentarios));														
					}
					else if(p.getTipoprocedimiento().equals(1061) && arrAccesoModulos.getIdTipoProcedimiento() == 1061){
						// Se obtiene como dato: diagnostico EEF
						ArrEstudio eef = this.eefdao.findByPrimaryKey(p.getIdprocedimiento());
						if(eef!=null)
							comentarios = this.bundle.getString("eef_tab_plantilla_diagn")+": "+ (eef.getDiagnostico()!=null && eef.getDiagnostico()!=0?maestrasdao.findByPrimaryKey(eef.getDiagnostico()).getValor()+".":" "+this.bundle.getString("no_especificado")+".");
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1061")+"</div><img src='/idea/img/iconos/hearticon.png' style='width:32px; height:32px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1061")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1061,comentarios));														
					}
					else if(p.getTipoprocedimiento().equals(1087) && arrAccesoModulos.getIdTipoProcedimiento() == 1087 ){
						SegSeguimientoClinico segclin = this.segclindao.findByPrimaryKey(p.getIdprocedimiento());
						if(segclin!=null)
							comentarios = this.bundle.getString("segclin_tab2_datos_res")+": "+ (segclin.getResultados()!=null && segclin.getResultados()!=null?segclin.getResultados()+".":"");
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1087")+"</div><img src='/idea/img/iconos/BandAid.png' style='width:24px; height:24px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1087")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1087,comentarios));														
					}
					else if(p.getTipoprocedimiento().equals(1088) && arrAccesoModulos.getIdTipoProcedimiento() == 1088 ){
						SegSeguimientoRegEventos segev = this.segregevdao.findByPrimaryKey(p.getIdprocedimiento());
						if(segev!=null)
							comentarios = this.bundle.getString("segregev_tab2_datos_obs")+": "+ (segev.getObservaciones()!=null?segev.getObservaciones()+".":"");
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_label_segregev")+"</div><img src='/idea/img/iconos/segregev.png' style='width:24px; height:24px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1088")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1088,comentarios));														
					}
					else if(p.getTipoprocedimiento().equals(1089) && arrAccesoModulos.getIdTipoProcedimiento() == 1089){
						Holter holter = this.holterdao.findByPrimaryKey(p.getIdprocedimiento());
						if(holter!=null)
							comentarios = this.bundle.getString("segregev_tab2_datos_obs")+": "+ (holter.getComentariosAna()!=null?holter.getComentariosAna()+".":"");
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1089")+"</div><img src='/idea/img/iconos/holter.png' style='width:24px; height:24px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1089")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1089,comentarios));														
					}
					else if(p.getTipoprocedimiento().equals(1091) && arrAccesoModulos.getIdTipoProcedimiento() == 1091 ){
						RegistradorEventosExt regevext = this.regevextdao.findByPrimaryKey(p.getIdprocedimiento());
						if(regevext!=null)
							comentarios = this.bundle.getString("segregev_tab2_datos_obs")+": "+ (regevext.getComentariosAna()!=null?regevext.getComentariosAna()+".":"");
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1091")+"</div><img src='/idea/img/iconos/regevext.png' style='width:24px; height:24px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1091")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1091,comentarios));														
					}
					else if(p.getTipoprocedimiento().equals(1092) && arrAccesoModulos.getIdTipoProcedimiento() == 1092 ){
						TestOrtostatismoActivo test = this.testortodao.findByPrimaryKey(p.getIdprocedimiento());
						if(test!=null)
							comentarios = this.bundle.getString("test_orto_coment")+": "+ (test.getComentarios()!=null?test.getComentarios()+".":"");
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1092")+"</div><img src='/idea/img/iconos/bpm.png' style='width:24px; height:24px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1092")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1092,comentarios));														
					}else if(p.getTipoprocedimiento().equals(1093) && arrAccesoModulos.getIdTipoProcedimiento() == 1093){
						this.pacienteSelect.setProtocolo(true);
					}
					else if(p.getTipoprocedimiento().equals(1094) && arrAccesoModulos.getIdTipoProcedimiento() == 1094){ // && this.usermods.getTestOrto()==1
						this.listproc.add(new ProcedimientosClinicos(p.getFecha(),"<div>"+this.bundle.getString("proc_1094")+"</div><img src='/idea/img/iconos/bpm.png' style='width:24px; height:24px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+p.getIdprocedimiento()+"!"+this.bundle.getString("barra_temp_proc_1094")+"!"+UtilFechas.dateToStringSinSeparador(p.getFecha())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1094,comentarios));
					}
				}
			}
			// Las complicaciones se meten como procedimiento clinico de tipo = 1 dentro de la lista
			// Obtener complicaciones de paciente
			ComplicacionesPacientes[] listaComps = this.obtenerComplicacionesPaciente(this.pacienteSelect.getCodigo());
			if(listaComps!=null && this.verComplicaciones){
				for(ComplicacionesPacientes c:listaComps){
					if(c.getResuelta()!=null && c.getResuelta().equals(0))
						this.listproc.add(new ProcedimientosClinicos(c.getFechaini(),"<div>"+c.getNombreComplicacion()+"</div><img src='/idea/img/iconos/complicacion.png' style='width:24px; height:24px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+c.getIdcompac()+"!"+this.bundle.getString("barra_temp_proc_1")+"!"+UtilFechas.dateToStringSinSeparador(c.getFechaini())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1,""));														
					else if(c.getResuelta()!=null && c.getResuelta().equals(1))
						this.listproc.add(new ProcedimientosClinicos(c.getFechaini(),"<div>"+c.getNombreComplicacion()+"</div><img src='/idea/img/iconos/complicacionRes.png' style='width:24px; height:24px;' onclick=javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').value='"+c.getIdcompac()+"!"+this.bundle.getString("barra_temp_proc_1")+"!"+UtilFechas.dateToStringSinSeparador(c.getFechaini())+"';javascript:document.getElementById('nuevoPaciente:numeroprocedimiento').focus()>",1,""));														
					
				}
			}
			
			String str="";
			for(ProcedimientosClinicos pc:this.listproc)
				str = str + pc.getStart()+"--"+pc.getContent()+"_";
			//Gson gson = new Gson();
			//this.json = gson.toJson(this.listproc);
			if(!str.equals(""))
				this.json = str.substring(0,str.length()-1);
			else
				this.json = str;
			// Obtencion de la primera y ultima fecha de procedimientos para centrar barra temporal
			// hay que ordenar el array listproc
			Collections.sort(this.listproc, new Comparator() {
				public int compare(Object o1, Object o2) {
					ProcedimientosClinicos e1 = (ProcedimientosClinicos) o1;
					ProcedimientosClinicos e2 = (ProcedimientosClinicos) o2;
					if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())>0) {
						return 1;
					} else if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())<=0) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			this.jsonstart = "";
			this.jsonend = "";
			if(this.listproc.size()>0){
				DateFormat DF = new SimpleDateFormat("yyyy/MM/dd");
				this.jsonstart = UtilDatos.formateaJSON(DF.format(UtilFechas.sumarRestarDiasFecha(this.listproc.get(0).getFecha(), -1)));
				this.jsonend = UtilDatos.formateaJSON(DF.format(UtilFechas.sumarRestarDiasFecha(this.listproc.get(this.listproc.size()-1).getFecha(), 1))) ;
			}
			//this.json.replaceAll("\u003c", "<");
			//System.out.println(this.json);
			//this.json.replaceAll("\u003e", ">");
			//System.out.println(str);
			if(prsimp.size()>0 && implante){
				//ImpImplanteDao impdao = new ImpImplanteDaoImpl();
				ImpImplante imp = this.idao.findByPrimaryKey(prsimp.get(prsimp.size()-1).getIdprocedimiento());
				//ImpGeneradorDao gendao = new ImpGeneradorDaoImpl();
				ImpGenerador[] cc = this.igdao.findWhereIdhojaimpEquals(imp.getIdhojaimp());
				if(cc.length>0){
					//ImpGenerador gen = gendao.findWhereIdhojaimpEquals(imp.getIdhojaimp())[0];
					ImpGenerador gen = cc[0];					
					Generador aux = UtilConversorTarjetaEuropea.buscaGenerador(this.generadores, gen.getIdgenerador());
					if(aux.getTipo().equals("1")|| aux.getTipo().equals("3"))
						this.pacienteSelect.setMp(true);
					else if(aux.getTipo().equals("2") || aux.getTipo().equals("4") || aux.getTipo().equals("6"))
						this.pacienteSelect.setDai(true);
					else if(aux.getTipo().equals("5"))
						this.pacienteSelect.setMp_leadless(true);
				}	
			}
		}catch(Exception ex){
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+": " + ex.getMessage());
			logger.error("("+this.usuario+") Error obteniendo registros en barra temporal - Motivo:"+ex.getMessage());
		}
	}
	
	public void cambiaVistaLineaTemporal(ActionEvent e){
		this.precarga(null);
	}
	
	public GenericosDto obtenerTipoDispositivo(int idproc){
		try{
			GeneradorDao gendao = new GeneradorDaoImpl();
			ArrayList<ArrayList<Object>> gens = gendao.getGeneradorProcedimiento(idproc);
			GenericosDto res = new GenericosDto();
			//res.setTmpString1(gens.get(0).get(0));//Modelo
			//res.getTmpString1().replaceAll(" ","");// Se quitan los espacios en blanco para correcto funcionamiento
			res.setTmpString1("modelo");
			if(gens.size()>0){
				String tipo = (String)gens.get(0).get(1);
				if(tipo.equals("1"))
					res.setTmpString2(this.bundle.getString("imp_dispositivos_tipo_1"));//Tipo
				else if(tipo.equals("2"))
					res.setTmpString2(this.bundle.getString("imp_dispositivos_tipo_2"));//Tipo
				else if(tipo.equals("3"))
					res.setTmpString2(this.bundle.getString("imp_dispositivos_tipo_3"));//Tipo
				else if(tipo.equals("4"))
					res.setTmpString2(this.bundle.getString("imp_dispositivos_tipo_4"));//Tipo
				else if(tipo.equals("5"))
					res.setTmpString2(this.bundle.getString("imp_dispositivos_tipo_5"));//Tipo
				else if(tipo.equals("6"))
					res.setTmpString2(this.bundle.getString("imp_dispositivos_tipo_6"));//Tipo
				else
					res.setTmpString2(this.bundle.getString("imp_dispositivos_tipo_desc"));//Tipo
			}else
				res.setTmpString2("");//Resolucion BUG
			return res;
		}catch(Exception ex){
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+": "+ ex.getMessage());
			logger.error("("+this.usuario+") Error obteniendo registros en barra temporal - Motivo:"+ex.getMessage());
			return null;
		}
	}
	
	public void obtenLineaeef(ActionEvent e) {
		try {
			this.obtenLinea(null);
			// Primero Medicacion y luego EEF para evitar error de consulta
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);			
			ControlEef ce = (ControlEef) getBean("controlEef");
			if (ce == null)
				ce = new ControlEef();
			ce.iniciaEef(null);
			//ce.cargaUltimoEEF();
			ce.cargaEstudioConsulta(null);
			setBean("controlEef", ce);	
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}

	public void obtenLineadai(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlDesfibriladores cd = (ControlDesfibriladores) getBean("controlDesfibriladores");
			if (cd == null)
				cd = new ControlDesfibriladores();
			cd.iniciaDesfibriladores(null);
			cd.cargaUltimoDai();
			setBean("controlDesfibriladores", cd);
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}

	public void obtenLineacv(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlCardioversion cv = (ControlCardioversion) getBean("controlCardioversion");
			if (cv == null)
				cv = new ControlCardioversion();
			cv.iniciaCardioversion(null);
			//cv.cargaUltimoCV();
			cv.cargaCardioversionConsulta(null);
			setBean("controlCardioversion", cv);
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	public void obtenLineaReg(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlRegistrador cr = (ControlRegistrador) getBean("controlRegistrador");
			if (cr == null)
				cr = new ControlRegistrador();
			cr.iniciaRegistradores(null);
			//cv.cargaUltimoCV();
			cr.cargaRegistradorConsulta(null);
			setBean("controlRegistrador", cr);
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	public void obtenLineaMesa(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlMesas cm = (ControlMesas) getBean("controlMesas");
			if (cm == null)
				cm = new ControlMesas();
			cm.iniciaMesas(null);
			cm.cargaMesaConsulta(null);
			//cv.cargaUltimoCV();
			setBean("controlMesas", cm);
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	public void obtenLineaTestAtp(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlTest cm = (ControlTest) getBean("controlTest");
			if (cm == null)
				cm = new ControlTest();
			cm.iniciaTest(null);
			cm.cargaATPConsulta(null);
			//cv.cargaUltimoCV();
			setBean("controlTest", cm);
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	public void obtenLineaTestEpi(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlTest cm = (ControlTest) getBean("controlTest");
			if (cm == null)
				cm = new ControlTest();
			cm.iniciaTest(null);
			cm.cargaEpiConsulta(null);
			//cv.cargaUltimoCV();
			setBean("controlTest", cm);
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	public void obtenLineaTestFle(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlTest cm = (ControlTest) getBean("controlTest");
			if (cm == null)
				cm = new ControlTest();
			cm.iniciaTest(null);
			cm.cargaFleConsulta(null);
			//cv.cargaUltimoCV();
			setBean("controlTest", cm);
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	public void obtenLineaImplante(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlImplantes ci = (ControlImplantes) getBean("controlImplantes");
			if (ci == null)
				ci = new ControlImplantes();
			ci.iniciaImplantes(null);
			ci.cargaImplanteConsulta(null);
			setBean("controlImplantes", ci);
			this.cmed = (ControlMedicacion) getBean("controlMedicacion");
			if(cmed==null)
				cmed = new ControlMedicacion();
			cmed.iniciaMedicacion(null);
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	public void obtenLineaSegClin(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlSeguimientosClinicos csc = (ControlSeguimientosClinicos) getBean("controlSeguimientosClinicos");
			if (csc == null)
				csc = new ControlSeguimientosClinicos();
			csc.inicia(null);
			csc.cargaSegClinConsulta(null);
			setBean("controlSeguimientosClinicos", csc);
			
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	public void obtenLineaSegRegEv(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlSeguimientosRegEventos csc = (ControlSeguimientosRegEventos) getBean("controlSeguimientosRegEventos");
			if (csc == null)
				csc = new ControlSeguimientosRegEventos();
			csc.inicia(null);
			csc.cargaSegRegEvConsulta(null);
			setBean("controlSeguimientosRegEventos", csc);
			
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}

	public void obtenLineaHolter(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlHolter csc = (ControlHolter) getBean("controlHolter");
			if (csc == null)
				csc = new ControlHolter();
			csc.iniciaHolter(null);
			csc.cargaHolterConsulta(null);
			setBean("controlHolter", csc);
			
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	public void obtenLineaRegEvExt(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlRegEvExt csc = (ControlRegEvExt) getBean("controlRegEvExt");
			if (csc == null)
				csc = new ControlRegEvExt();
			csc.iniciaRegEvExt(null);
			csc.cargaRegEvExtConsulta(null);
			setBean("controlRegEvExt", csc);
			
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	public void obtenLineaTestOrto(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlTestOrtostatismo csc = (ControlTestOrtostatismo) getBean("controlTestOrtostatismo");
			if (csc == null)
				csc = new ControlTestOrtostatismo();
			csc.inicia(null);
			csc.cargaTestOrtoConsulta(null);
			setBean("controlTestOrtostatismo", csc);
			
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	/**
	 * Transicion a formulario desde la linea Temporal del paciente
	 * 
	 * @param e
	 */
	public void obtenLineaRehabilitacionCardiaca(ActionEvent e) {
		try {
			this.obtenLinea(null);
			ControlRehabilitacionCardiaca csc = (ControlRehabilitacionCardiaca) getBean("controlRehabilitacionCardiaca");
			if (csc == null)
				csc = new ControlRehabilitacionCardiaca();
			csc.iniciaRehabilitacionCardiaca(null);
			csc.cargaRehabilitacionCardiaca(null);
			setBean("controlTestOrtostatismo", csc);
			
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	public void cambiaEstado(ActionEvent e) {
		try {
			for (ArrListaEspera le : lstespera)
				if (le.getCodigoLe().equals(this.leselec)) {
					this.ledao.update(le.createPk(), le);
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("pat_msg_info_edit_le_estado"));
				}
		} catch (ArrListaEsperaDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("pat_msg_error_edit_le_estado")+": " + e1.getMessage());
		}
	}

	public void limpiaregistrole(ActionEvent e) {
		this.regselec = new ArrListaEspera();
		this.regselec.setIngreso(new Date());
	}

	public void guardaLe(ActionEvent e) {
		try {
			if(this.regselec.getCodigoPaciente() != null && this.regselec.getCodigoPaciente() > 0){
				this.ledao.update(this.regselec.createPk(),this.regselec);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
			}else{
				this.regselec.setCodigoPaciente(this.pacienteSelect.getCodigo());
				this.ledao.insert(this.regselec);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
				ArrListaEspera filtrole = new ArrListaEspera();
				filtrole.setCodigoPaciente(this.pacienteSelect.getCodigo());
				filtrole.setIngreso(null);
				filtrole.setIngresomax(null);
				Integer a = null;
				filtrole.setEdadmin(a);
				filtrole.setEdadmax(null);
				this.lstespera = this.ledao.findWhereFiltro(filtrole);
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
		}
	}

	public void sortPacientes(final String columna, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				PacienteAplDto c1 = (PacienteAplDto) o1;
				PacienteAplDto c2 = (PacienteAplDto) o2;
				try {
					if (columna == null) {
						return 0;
					}
					if (columna.equals("nhc")) {
						return ascending ? c1.getNhc().trim().compareTo(
								c2.getNhc().trim()) : c2.getNhc().trim().compareTo(c1.getNhc().trim());
					} else if (columna.equals("apellido1")) {
						return ascending ? c1.getApellid1().trim().compareTo(
								c2.getApellid1().trim()) : c2.getApellid1().trim().compareTo(c1.getApellid1().trim());
					} else if (columna.equals("nombre")) {
						return ascending ? c1.getNombre().trim().compareTo(
								c2.getNombre().trim()) : c2.getNombre().trim().compareTo(c1.getNombre().trim());
					} else
						return 0;
				} catch (Exception ex) {
					return 0;
				}
			}
		};
		Collections.sort(this.listaPacientes, comparator);
	}

	/**
	 * Devuelve un NIF completo a partir de un DNI. Es decir, a�ade la letra del
	 * NIF
	 * 
	 * @param dni
	 *            dni al que se quiere a�adir la letra del NIF
	 * @return NIF completo.
	 */
	public static String nifFromDni(int dni) {
		return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
	}
	
	public void modregistrole(ActionEvent e){
		if(leselec != null && leselec >= 0)
			for(ArrListaEspera le : this.lstespera)
				if(le.getCodigoLe().equals(this.leselec))
					this.regselec = le;
			
	}
	
	public void limpiaSituacionClinica(ActionEvent e){
		
	}
	
	/**
	 * Evento para generar informes especificos de paciente
	 * @param e
	 */
	public void generaInformeProcedimientosPaciente(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(
				FacesContext.getCurrentInstance());
		String jasper = null;
		jasper = "InformeResumenProcedimientosPaciente.jasper";
		try {
			// habria que ordenar por fechas descendentes el array de procedimientos
			Collections.sort(this.listproc, new Comparator() {
				public int compare(Object o1, Object o2) {
					ProcedimientosClinicos e1 = (ProcedimientosClinicos) o1;
					ProcedimientosClinicos e2 = (ProcedimientosClinicos) o2;
					return e2.getFecha().compareTo(e1.getFecha());							
				}
			});
			PathFicheroXml = generadorXML.imprimeInformeResumenProcedimientosPaciente(
					this.pacienteSelect,this.listproc,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento (Resumen procedimientos paciente).  Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(
						formulario.getId(),
						Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}
		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generaci�n de informe (Resumen procedimientos paciente). Id Paciente: "+this.pacienteSelect.getCodigo());
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
	}

	/**
	 * Evento para generar informes especificos de paciente
	 * @param e
	 */
	public void generaInformeConsentimientoDAI(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(
				FacesContext.getCurrentInstance());
		String jasper = null;
		jasper = "InformeConsentimientoImplanteDAI.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeConsentimiento(this.pacienteSelect, this.infocentro,this.consdai,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento (Consentimiento Implante DAI). Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(
						formulario.getId(),
						Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generaci�n de informe (Consentimiento Implante DAI). Id Paciente: "+this.pacienteSelect.getCodigo());				
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
		this.consdai = new ConsentimientoBean();
	}
	
	public void generaInformeConsentimientoMPS(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(
				FacesContext.getCurrentInstance());
		String jasper = null;
		jasper = "InformeConsentimientoImplanteMPS.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeConsentimiento(this.pacienteSelect, this.infocentro,this.consmps,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento (Consentimiento Implante MPS). Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(
						formulario.getId(),
						Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generaci�n de informe (Consentimiento Implante MPS). Id Paciente: "+this.pacienteSelect.getCodigo());				
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
		this.consmps = new ConsentimientoBean();
	}
	
	public void generaInformeConsentimientoREC(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(
				FacesContext.getCurrentInstance());
		String jasper = null;
		jasper = "InformeConsentimientoImplanteRecambio.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeConsentimientoImpREC(this.pacienteSelect, this.infocentro,this.consrec,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento (Consentimiento RECAMBIO). Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(
						formulario.getId(),
						Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generaci�n de informe (Consentimiento RECAMBIO). Id Paciente: "+this.pacienteSelect.getCodigo());				
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
		this.consrec = new ConsentimientoBean();
	}
	
	public void generaInformeConsentimientoTRANS(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String jasper = null;
		jasper = "InformeConsentimientoImplanteMPSTrans.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeConsentimiento(this.pacienteSelect, this.infocentro,this.constran,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento (Consentimiento MPS TRANSITORIO). Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(formulario.getId(),Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "+ se.getMessage(),"Error generando documento,Motivo: "+ se.getMessage());
			} catch (Exception e3) {
			}
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generaci�n de informe (Consentimiento MPS TRANSITORIO). Id Paciente: "+this.pacienteSelect.getCodigo());				
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
		this.constran = new ConsentimientoBean();
	}
	
	public void generaInformeConsentimientoHOLTER(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(
				FacesContext.getCurrentInstance());
		String jasper = null;
		jasper = "InformeConsentimientoImplanteHOLTER.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeConsentimiento(this.pacienteSelect, this.infocentro,this.conshol,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento (Consentimiento HOLTER). Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(formulario.getId(),Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "+ se.getMessage(),"Error generando documento,Motivo: "+ se.getMessage());
			} catch (Exception e3) {
			}
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generaci�n de informe (Consentimiento HOLTER). Id Paciente: "+this.pacienteSelect.getCodigo());				
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
		this.conshol = new ConsentimientoBean();
	}
	
	public void generaInformeConsentimientoMRI(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(
				FacesContext.getCurrentInstance());
		String jasper = null;
		jasper = "InformeConsentimientoMRI.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeConsentimiento(this.pacienteSelect, this.infocentro,this.consmri,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento (Consentimiento MRI). Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(formulario.getId(),Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "+ se.getMessage(),"Error generando documento,Motivo: "+ se.getMessage());
			} catch (Exception e3) {
			}
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generaci�n de informe (Consentimiento MRI). Id Paciente: "+this.pacienteSelect.getCodigo());				
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
		this.consmri = new ConsentimientoBean();
	}
	
	public void generaInformeConsentimientoEXP(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(
				FacesContext.getCurrentInstance());
		String jasper = null;
		jasper = "InformeConsentimientoExplante.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeConsentimiento(this.pacienteSelect, this.infocentro,this.consexp,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento (Consentimiento explante). Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(formulario.getId(),Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "+ se.getMessage(),"Error generando documento,Motivo: "+ se.getMessage());
			} catch (Exception e3) {
			}
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generaci�n de informe (Consentimiento explante). Id Paciente: "+this.pacienteSelect.getCodigo());				
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
		this.consexp = new ConsentimientoBean();
	}
	
	public void limpiaConsentimiento(ActionEvent e){
		this.consmps = new ConsentimientoBean();
		this.consdai = new ConsentimientoBean();
		this.consrec = new ConsentimientoBean();
		this.constran = new ConsentimientoBean();
		this.consexp = new ConsentimientoBean();
		this.conshol = new ConsentimientoBean();
		this.consmri = new ConsentimientoBean();
	}
	
	/**
	 * Evento para generar informes especificos de paciente
	 * @param e
	 */
	public void generaInformeResumenHC(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(
				FacesContext.getCurrentInstance());
		String jasper = null;
		jasper = "InformeResumenHCPaciente.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeResumenHC(this.pacienteSelect,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento (Resumen HC paciente). Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());
			try {
				nuevoMensaje(
						formulario.getId(),
						Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: "
								+ se.getMessage(),
						"Error generando documento,Motivo: "
								+ se.getMessage());
			} catch (Exception e3) {
			}
		}

		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generaci�n de informe (Resumen HC paciente). Id Paciente: "+this.pacienteSelect.getCodigo());				
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Paciente: "+this.pacienteSelect.getCodigo()+". Motivo: "+ se.getMessage());	
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}		
	}
	
	public String obtenerSistemaGeneradorImplante(Integer idproc){
		String res = "";
		try{
			ImpImplante imp = this.idao.findByPrimaryKey(idproc);
			ImpGenerador[] cc = this.igdao.findWhereIdhojaimpEquals(imp.getIdhojaimp());
			if(cc.length>0){
				Generador aux = UtilConversorTarjetaEuropea.buscaGenerador(this.generadores, cc[0].getIdgenerador());				
				if(aux.getTipo().equals("1"))
					res = "Marcapasos ";
				else if(aux.getTipo().equals("2"))
					res = "Desfibrilador ";
				else if(aux.getTipo().equals("3"))
					res = "CRT-P ";
				else if(aux.getTipo().equals("4"))
					res = "CRT-D ";
				else if(aux.getTipo().equals("5"))
					res = "MP Sin cables ";
				else if(aux.getTipo().equals("6"))
					res = "Desfibrilador subcut�neo ";
				res = res + aux.getModelo() + " ("+aux.getFabricante()+"). N.Serie: "+cc[0].getNumserie();
			}
		}catch(Exception e){
			logger.error("No se puede obtener el sistema implantado (precarga)", e);
			this.pintaMensaje(ERROR, this.bundle.getString("pat_msg_error_ver_sistema"));
		}
		
		return res;
	}
	
	public ComplicacionesPacientes[] obtenerComplicacionesPaciente(Integer idpat){
		try{
			String res = "";
			ComplicacionesPacientes[] comps = this.compacdao.findWhereIdpacienteEquals(idpat);
			for(ComplicacionesPacientes c:comps){
				Complicaciones cmp = this.compdao.findByPrimaryKey(c.getComplicacion());
				c.setNombreComplicacion(cmp.getNombre());
				if(c.getResuelta()!=null && c.getResuelta().equals(0))
					res = res + cmp.getNombre()+",";
			}
			if(res.endsWith(",") && res.length()>0)
				res = res.substring(0,res.length()-1);
			this.pacienteSelect.setResumenCompl(res);
			return comps;
		}catch(Exception e1){
			return null;
		}
	}
	
	public void exportarDatos(ActionEvent e){
		try{
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_Pacientes(listaPacientes);
			logger.info("("+this.usuario+") Exportaci�n de pacientes desde consulta realizado con �xito");
		}catch(Exception e1){
			logger.error("No se puede generar exportaci�n de datos de consulta de pacientes. Motivo: "+e1.getMessage(), e1);
			this.pintaMensaje(ERROR, this.bundle.getString("pat_msg_error_exporta_datos")+": "+e1.getMessage());
		}
	}
	
	/*--------------------------------------------*/
	/* M�TODOS SET Y GET */
	/*--------------------------------------------*/

	public ArrayList<PacienteAplDto> getLstPacientes() {
		return lstPacientes;
	}

	public void setLstPacientes(ArrayList<PacienteAplDto> lstPacientes) {
		this.lstPacientes = lstPacientes;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getCheckbudape() {

		return checkbudape;
	}

	public PacienteAplDto getFiltro() {
		return filtro;
	}

	public void setFiltro(PacienteAplDto filtro) {
		this.filtro = filtro;
	}

	public HtmlDataTable getTablaBindingBusqueda() {
		return tablaBindingBusqueda;
	}

	public void setTablaBindingBusqueda(HtmlDataTable tablaBindingBusqueda) {
		this.tablaBindingBusqueda = tablaBindingBusqueda;
	}

	public PacienteAplDto getPacienteSelect() {
		return pacienteSelect;
	}

	public void setPacienteSelect(PacienteAplDto pacienteSelect) {
		this.pacienteSelect = pacienteSelect;
	}

	public org.apache.myfaces.component.html.ext.HtmlDataTable getBindingTabla() {
		return bindingTabla;
	}

	public void setBindingTabla(
			org.apache.myfaces.component.html.ext.HtmlDataTable bindingTabla) {
		this.bindingTabla = bindingTabla;
	}

	public ArrayList<PacienteAplDto> getListaPacientes() {
		sortPacientes(columna, ascendente);
		return listaPacientes;
	}

	public void setListaPacientes(ArrayList<PacienteAplDto> listaPacientes) {
		this.listaPacientes = listaPacientes;
	}

	public Integer getPagina_inicial() {
		return pagina_inicial;
	}

	public void setPagina_inicial(Integer paginaInicial) {
		pagina_inicial = paginaInicial;
	}

	public Integer getModPaci() {
		return modPaci;
	}

	public void setModPaci(Integer modPaci) {
		this.modPaci = modPaci;
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

	public ArrayList<SelectItem> getCaracter() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.caracter)
			diag.add(new SelectItem(diagnostico.getCodigo(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getHospital() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_hospital")));
		for (ArrMaestras diagnostico : this.hospital)
			diag.add(new SelectItem(diagnostico.getCodigo(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getAutocompletarFV() {
		ArrayList<SelectItem> tmp = new ArrayList<SelectItem>();
		for (int i = 0; i < this.funcion.length; i++)
			tmp.add(new SelectItem(this.funcion[i].getCodigo(), this.funcion[i]
					.getValor()));
		return tmp;
	}

	public ArrayList<ArrMaestras> autocompletarFV(Object suggest) {
		String pref = (String) suggest;
		ArrayList<ArrMaestras> result = new ArrayList<ArrMaestras>();

		for (ArrMaestras elem : this.funcion) {
			if ((elem.getValor().toUpperCase().contains(pref.toUpperCase()))) {
				result.add(elem);
			}
		}

		return result;
	}
	
	public ArrayList<SelectItem> getArritmiasle() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("-", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.arritmiasle)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getProcedimientosle() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("-", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.procedimientosle)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getCaracterle() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("-", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.caracterle)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getAnticoagulantesle() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("-", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.anticoagulantele)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getOperadoresle() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.operadoresle)
			diag.add(new SelectItem(diagnostico.getCodigo(), diagnostico
					.getValor()));
		return diag;
	}

	public ArrayList<SelectItem> getOperadores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.operadoresle)
			diag.add(new SelectItem(diagnostico.getValor(), diagnostico
					.getValor()));
		return diag;
	}
	
	public ArrayList<ArrListaEspera> getLstespera() {
		return lstespera;
	}

	public void setLstespera(ArrayList<ArrListaEspera> lstespera) {
		this.lstespera = lstespera;
	}

	public Integer getLeselec() {
		return leselec;
	}

	public void setLeselec(Integer leselec) {
		this.leselec = leselec;
	}

	public ArrListaEspera getRegselec() {
		return regselec;
	}

	public void setRegselec(ArrListaEspera regselec) {
		this.regselec = regselec;
	}

	public ArrayList<ProcedimientosClinicos> getListproc() {
		return listproc;
	}

	public void setListproc(ArrayList<ProcedimientosClinicos> listproc) {
		this.listproc = listproc;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	public void cargaGeneradores() {
		try {
			GeneradorDao g = new GeneradorDaoImpl();
			g = new GeneradorDaoImpl();
			this.generadores = g.findAll();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}

	public int getNumeroprocedimientobarratemporal() {
		return numeroprocedimientobarratemporal;
	}

	public void setNumeroprocedimientobarratemporal(
			int numeroprocedimientobarratemporal) {
		this.numeroprocedimientobarratemporal = numeroprocedimientobarratemporal;
	}

	public String getTipoprocedimientobarratemporal() {
		return tipoprocedimientobarratemporal;
	}

	public void setTipoprocedimientobarratemporal(
			String tipoprocedimientobarratemporal) {
		this.tipoprocedimientobarratemporal = tipoprocedimientobarratemporal;
	}

	public String getFechaprocedimientobarratemporal() {
		return fechaprocedimientobarratemporal;
	}

	public void setFechaprocedimientobarratemporal(
			String fechaprocedimientobarratemporal) {
		this.fechaprocedimientobarratemporal = fechaprocedimientobarratemporal;
	}
	public void cargaNumeroProc(ActionEvent e){
		// Pone fecha, tipo procedimiento y numero de proc en modalpanel de barra temporal
		if(this.getInfoprocedimientobarratemporal().length()>0){
			String[] str = this.getInfoprocedimientobarratemporal().split("!");
			this.setTipoprocedimientobarratemporal(str[1]);
			this.setNumeroprocedimientobarratemporal(Integer.valueOf(str[0]));
			this.setFechaprocedimientobarratemporal(str[2].substring(6, 8)+"-"+str[2].substring(4,6)+"-"+str[2].substring(0, 4));
			// Modelo y tipo dispositivo si es implante
			if(str.length>3 && str[3]!=null)
				this.setDispprocedimientobarratemporal(str[3]);
			if(str.length>3 && str[4]!=null)
				this.setModeloprocedimientobarratemporal(str[4]);
			
			//System.out.println(this.getNumeroprocedimientobarratemporal());
			/*if(!(this.getTipoprocedimientobarratemporal().equals("Seguimiento")))
				this.setEsImplante(true);
			else
				this.setEsImplante(false);*/
			
			if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_983")))
				this.setTipoprocedimiento(983);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_956")))
				this.setTipoprocedimiento(956);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_993")))
				this.setTipoprocedimiento(993);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_957")))
				this.setTipoprocedimiento(957);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1059")))
				this.setTipoprocedimiento(1059);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1060")))
				this.setTipoprocedimiento(1060);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1085")))
				this.setTipoprocedimiento(1085);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1086")))
				this.setTipoprocedimiento(1086);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1061")))
				this.setTipoprocedimiento(1061);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1068")))
				this.setTipoprocedimiento(1068);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1067")))
				this.setTipoprocedimiento(1067);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1066")))
				this.setTipoprocedimiento(1066);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1063")))
				this.setTipoprocedimiento(1063);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1064")))
				this.setTipoprocedimiento(1064);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1065")))
				this.setTipoprocedimiento(1065);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1147")))
				this.setTipoprocedimiento(1147);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1087")))
				this.setTipoprocedimiento(1087);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1088")))
				this.setTipoprocedimiento(1088);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1089")))
				this.setTipoprocedimiento(1089);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1090")))
				this.setTipoprocedimiento(1090);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1091")))
				this.setTipoprocedimiento(1091);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1092")))
				this.setTipoprocedimiento(1092);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1")))
				this.setTipoprocedimiento(1);
			else if(this.getTipoprocedimientobarratemporal().equals(this.bundle.getString("barra_temp_proc_1094")))
				this.setTipoprocedimiento(1094);
			/*if(this.getTipoprocedimientobarratemporal().equals("Seguimiento"))
				this.setTipoprocedimiento(983);
			else if(this.getTipoprocedimientobarratemporal().equals("Primoimplante"))
				this.setTipoprocedimiento(956);
			else if(this.getTipoprocedimientobarratemporal().equals("IntervencionPrevia"))
				this.setTipoprocedimiento(993);
			else if(this.getTipoprocedimientobarratemporal().equals("Reintervencion"))
				this.setTipoprocedimiento(957);
			else if(this.getTipoprocedimientobarratemporal().equals("Recambio"))
				this.setTipoprocedimiento(1059);
			else if(this.getTipoprocedimientobarratemporal().equals("Upgrade"))
				this.setTipoprocedimiento(1060);
			else if(this.getTipoprocedimientobarratemporal().equals("RecolocacionGenerador"))
				this.setTipoprocedimiento(1085);
			else if(this.getTipoprocedimientobarratemporal().equals("RecolocacionElectrodo"))
				this.setTipoprocedimiento(1086);
			else if(this.getTipoprocedimientobarratemporal().equals("EEF"))
				this.setTipoprocedimiento(1061);
			else if(this.getTipoprocedimientobarratemporal().equals("Cardioversion"))
				this.setTipoprocedimiento(1068);
			else if(this.getTipoprocedimientobarratemporal().equals("RegistradorEventos"))
				this.setTipoprocedimiento(1067);
			else if(this.getTipoprocedimientobarratemporal().equals("MesaBasculante"))
				this.setTipoprocedimiento(1066);
			else if(this.getTipoprocedimientobarratemporal().equals("TestATP"))
				this.setTipoprocedimiento(1063);
			else if(this.getTipoprocedimientobarratemporal().equals("TestEpinefrina"))
				this.setTipoprocedimiento(1064);
			else if(this.getTipoprocedimientobarratemporal().equals("TestFlecainida"))
				this.setTipoprocedimiento(1065);
			else if(this.getTipoprocedimientobarratemporal().equals("Explante"))
				this.setTipoprocedimiento(1147);
			else if(this.getTipoprocedimientobarratemporal().equals("SeguimientoClinico"))
				this.setTipoprocedimiento(1087);
			else if(this.getTipoprocedimientobarratemporal().equals("SeguimientoRegistrador"))
				this.setTipoprocedimiento(1088);
			else if(this.getTipoprocedimientobarratemporal().equals("Holter"))
				this.setTipoprocedimiento(1089);
			else if(this.getTipoprocedimientobarratemporal().equals("Reimplante"))
				this.setTipoprocedimiento(1090);
			else if(this.getTipoprocedimientobarratemporal().equals("RegistradorEventosExterno"))
				this.setTipoprocedimiento(1091);*/
		}
	}

	public String getInfoprocedimientobarratemporal() {
		return infoprocedimientobarratemporal;
	}

	public void setInfoprocedimientobarratemporal(
			String infoprocedimientobarratemporal) {
		this.infoprocedimientobarratemporal = infoprocedimientobarratemporal;
	}

	public boolean isEsImplante() {
		return esImplante;
	}

	public void setEsImplante(boolean esImplante) {
		this.esImplante = esImplante;
	}

	public int getTipoprocedimiento() {
		return tipoprocedimiento;
	}

	public void setTipoprocedimiento(int tipoprocedimiento) {
		this.tipoprocedimiento = tipoprocedimiento;
	}

	public SituacionClinicaGeneral getSitclin() {
		return sitclin;
	}

	public void setSitclin(SituacionClinicaGeneral sitclin) {
		this.sitclin = sitclin;
	}

	public HtmlDataTable getBindingSintomas() {
		return bindingSintomas;
	}

	public void setBindingSintomas(HtmlDataTable bindingSintomas) {
		this.bindingSintomas = bindingSintomas;
	}
	/****** controles booleanos -short ****/
	public void cambiaIC(ActionEvent e){
		if(!(this.filtro.getSitclin().isIc()))
			this.filtro.getSitclin().setNyha(null);
	}
	public void reVasc(ActionEvent e) {
		this.filtro.getSitclin().setRevasc((short) (this.filtro.getSitclin().isRevascularizacion() ? 1 : 0));
	}
	public void infPrevio(ActionEvent e) {
		this.filtro.getSitclin().setInfprevio((short) (this.filtro.getSitclin().isInfartoprev() ? 1 : 0));
		// Actualizacion de valores de infarto previo si false
		if (!(this.filtro.getSitclin().isInfartoprev())) {
			this.filtro.getSitclin().setAnio(null);
			this.filtro.getSitclin().setLocalizacion(null);
		}
	}
	public void cambiaArritmiasVentriculares(ActionEvent e){
		if(!this.filtro.getSitclin().isAvent())
			this.filtro.getSitclin().setArritmias(null);
	}
	public void cambiaEefPrevio(ActionEvent e){
		if(!this.filtro.getSitclin().isEefprev())
			this.filtro.getSitclin().setEef(null);
	}
	public void anteInsRenal(ActionEvent e) {
		this.filtro.getSitclin().setInsrenal((short) (this.filtro.getSitclin().isAnteinsrenal() ? 1 : 0));
	}

	public void anteFA(ActionEvent e) {
		this.filtro.getSitclin().setAntfa((short) (this.filtro.getSitclin().isAntefa() ? 1 : 0));
		// Recalcula Score de Chadvasc si es true
		if(this.filtro.getSitclin().isAntefa()){
			int scor = -1;
			if(this.pacienteSelect.getEdad()!=null)
				scor = UtilSituacionClinica.calcularScoreCHADSVASC(this.pacienteSelect.getSitclin().getNyha(), this.pacienteSelect.getSitclin().getFuncionventricular(), this.pacienteSelect.getSitclin().getHta(), this.pacienteSelect.getEdad()!=null?Integer.parseInt(this.pacienteSelect.getEdad()):null, this.pacienteSelect.getSitclin().getDiabetes(), this.pacienteSelect.getSitclin().getAcv(), this.pacienteSelect.getSitclin().getAit(), this.pacienteSelect.getSitclin().getEnfart(), this.pacienteSelect.getSexo());						
			this.pacienteSelect.getSitclin().setScorechadsvasc(scor);
			this.pacienteSelect.getSitclin().setScorechadsvascporcent(UtilSituacionClinica.obtenerRiesgoIctus(scor));
		}
	}

	public void anteFlutter(ActionEvent e) {
		this.filtro.getSitclin().setFlutter((short) (this.filtro.getSitclin().isAnteflutter() ? 1 : 0));		
	}
	
	public void anteDiab(ActionEvent e) {
		this.filtro.getSitclin().setDiabetes((short) (this.filtro.getSitclin().isAntediab() ? 1 : 0));
	}
	public void anteHTA(ActionEvent e) {
		this.filtro.getSitclin().setHta((short) (this.filtro.getSitclin().isAnteHTA() ? 1 : 0));
	}

	public void anteFam(ActionEvent e) {
		this.filtro.getSitclin().setMuertesubita((short) (this.filtro.getSitclin().isAntefam() ? 1 : 0));
	}

	public void anteTabaq(ActionEvent e) {
		this.filtro.getSitclin().setTabaquismo((short) (this.filtro.getSitclin().isAntetabaq() ? 1 : 0));
	}

	public void anteHipercoles(ActionEvent e) {
		this.filtro.getSitclin().setDislipemia((short) (this.filtro.getSitclin().isAntehipercol() ? 1 : 0));
	}

	public void anteACV(ActionEvent e) {
		this.filtro.getSitclin().setAcv((short) (this.filtro.getSitclin().isAnteacv() ? 1 : 0));
	}
	public void anteTCardiaco(ActionEvent e) {
		this.filtro.getSitclin().setTrasplantecardiaco((short) (this.filtro.getSitclin().isAnteTrasplanteCardiaco() ? 1 : 0));
	}
	public void cambiaAIT(ActionEvent e) {
		this.filtro.getSitclin().setAit((short) (this.filtro.getSitclin().isAnteAIT() ? 1 : 0));
	}
	public void cambiaEPOC(ActionEvent e) {
		this.filtro.getSitclin().setEpoc((short) (this.filtro.getSitclin().isAnteEPOC() ? 1 : 0));
	}

	public void cambiaSAHS(ActionEvent e) {
		this.filtro.getSitclin().setSahs((short) (this.filtro.getSitclin().isAnteSAHS() ? 1 : 0));
		if(!(this.filtro.getSitclin().isAnteSAHS())){
			this.filtro.getSitclin().setTiposahs(null);
			this.filtro.getSitclin().setCpap(null);
			this.filtro.getSitclin().setAnteCPAP(false);
			this.filtro.getSitclin().setAhi(null);
		}
	}
	public void cambiaNeoplasia(ActionEvent e) {
		this.filtro.getSitclin().setNeoplasia((short) (this.filtro.getSitclin().isAnteNeoplasia() ? 1 : 0));
		if(!(this.filtro.getSitclin().isAnteNeoplasia()))
			this.filtro.getSitclin().setTiponeoplasia(null);
	}

	public void cambiaCPAP(ActionEvent e) {
		this.filtro.getSitclin().setCpap((short) (this.filtro.getSitclin().isAnteCPAP() ? 1 : 0));
	}
	public void cambiaSincope(ActionEvent e){
		this.filtro.getSitclin().setSincope((short) (this.filtro.getSitclin().isAnteSincope() ? 1 : 0));
	}
	public void cambiaParadaCardiaca(ActionEvent e){
		this.filtro.getSitclin().setParadacardiaca((short) (this.filtro.getSitclin().isAnteParadaCardiaca() ? 1 : 0));
	}
	public void cambiaExitus(ActionEvent e){
		this.filtro.getSitclin().setExitus(this.filtro.getSitclin().isExit() ? 1 : 0);
		if(!this.filtro.getSitclin().isExit()){
			this.filtro.getSitclin().setExitdesc(false);
			this.filtro.getSitclin().setExitusfecha(null);
		}
	}
	public void cambiaExitusDesconocido(ActionEvent e){
		this.filtro.getSitclin().setExitusfechadesc(this.filtro.getSitclin().isExitdesc() ? 1 : 0);
	}
	public void cambiaEnfArt(ActionEvent e){
		this.filtro.getSitclin().setEnfart(this.filtro.getSitclin().isEnfarterios() ? 1 : 0);
	}
		
	/**************************************/
	public ArrayList<SelectItem> getCardiopatia() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras cardio : this.cardiopatia)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio
					.getValor()));
		return cp;
	}
	public void ordenaFEVI(ActionEvent e){
		try{
			int fevi = Integer.valueOf(this.filtro.getSitclin().getFevi());
			if(fevi>50)
				this.filtro.getSitclin().setFuncionventricular(1);
			else if(fevi>=41 && fevi<=50)
				this.filtro.getSitclin().setFuncionventricular(2);
			else if(fevi>=36 && fevi<=40)
				this.filtro.getSitclin().setFuncionventricular(3);
			else if(fevi>=31 && fevi<=35)
				this.filtro.getSitclin().setFuncionventricular(4);
			else
				this.filtro.getSitclin().setFuncionventricular(5);
		}catch(Exception e1){
			this.pintaMensaje(
					Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_sitclin_fe")+": " + e1.getMessage());
		}	
	}
	public void resetFEVI(ActionEvent e){
		this.filtro.getSitclin().setFevi(null);
	}
	public ArrayList<SelectItem> getModulos() {
		
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		
		List<ArrAccesoModulos> listaModulos = Arrays.asList(this.usermods);
		
		for ( ArrAccesoModulos arrAccesoModulos : listaModulos ) {
			 
			if( arrAccesoModulos.getIdTipoProcedimiento() == 1061)
				diag.add(new SelectItem(1, this.bundle.getString("proc_label_eef_abl")));
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 1068)
				diag.add(new SelectItem(2, this.bundle.getString("proc_label_cv")));
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 1067 ||
					 arrAccesoModulos.getIdTipoProcedimiento() == 1091 )
				diag.add(new SelectItem(3, this.bundle.getString("proc_label_regev")));
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 1066 )
				diag.add(new SelectItem(4, this.bundle.getString("proc_label_mesa")));
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 1063 ){
				diag.add(new SelectItem(5, this.bundle.getString("proc_1063")));
			}
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 1064 ){
				diag.add(new SelectItem(6, this.bundle.getString("proc_1064")));
			}
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 1065 ){
				diag.add(new SelectItem(7, this.bundle.getString("proc_1065")));
			}
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 956 ) {
				diag.add(new SelectItem(8, this.bundle.getString("proc_label_imp_general")));
			}
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 1089 )
				diag.add(new SelectItem(11, this.bundle.getString("proc_label_holter")));
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 1091 )
				diag.add(new SelectItem(12, this.bundle.getString("proc_label_elr")));
			else if( arrAccesoModulos.getIdTipoProcedimiento() == 1092 )
				diag.add(new SelectItem(13, this.bundle.getString("proc_label_test_orto")));
		}
		
		return diag;
	}
	private void organizaSitClin(){
		this.filtro.getSitclin().setIc((this.filtro.getSitclin().getNyha() != null)? true : false);
		this.filtro.getSitclin().setCardiop(this.filtro.getSitclin().getCardiopatia()!=null?true:false);
		this.filtro.getSitclin().setRevascularizacion(this.filtro.getSitclin().getRevasc()!=null 
				&& this.filtro.getSitclin().getRevasc()==1?true:false);
		this.filtro.getSitclin().setInfartoprev(this.filtro.getSitclin().getInfprevio()!=null 
				&& this.filtro.getSitclin().getInfprevio()==1?true:false);
		this.filtro.getSitclin().setAnteinsrenal((this.filtro.getSitclin().getInsrenal() != null)
				&& (this.filtro.getSitclin().getInsrenal() == 1) ? true : false);
		this.filtro.getSitclin().setAntefa((this.filtro.getSitclin().getAntfa() != null)
				&& (this.filtro.getSitclin().getAntfa() == 1) ? true : false);
		this.filtro.getSitclin().setAntediab((this.filtro.getSitclin().getDiabetes() != null)
				&& (this.filtro.getSitclin().getDiabetes() == 1) ? true : false);
		this.filtro.getSitclin().setAnteHTA((this.filtro.getSitclin().getHta() != null)
				&& (this.filtro.getSitclin().getHta() == 1) ? true : false);
		this.filtro.getSitclin().setAntefam((this.filtro.getSitclin().getMuertesubita() != null)
				&& (this.filtro.getSitclin().getMuertesubita() == 1) ? true : false);
		this.filtro.getSitclin().setAntetabaq((this.filtro.getSitclin().getTabaquismo() != null)
				&& (this.filtro.getSitclin().getTabaquismo() == 1) ? true : false);
		this.filtro.getSitclin().setAntehipercol((this.filtro.getSitclin().getDislipemia() != null)
				&& (this.filtro.getSitclin().getDislipemia() == 1) ? true : false);
		this.filtro.getSitclin().setAnteacv((this.filtro.getSitclin().getAcv() != null)
				&& (this.filtro.getSitclin().getAcv() == 1) ? true : false);
		this.filtro.getSitclin().setAnteTrasplanteCardiaco((this.filtro.getSitclin().getTrasplantecardiaco() != null)
				&& (this.filtro.getSitclin().getTrasplantecardiaco() == 1) ? true : false);
		this.filtro.getSitclin().setAnteAIT((this.filtro.getSitclin().getAit() != null)
				&& (this.filtro.getSitclin().getAit() == 1) ? true : false);
		this.filtro.getSitclin().setAnteEPOC((this.filtro.getSitclin().getEpoc() != null)
				&& (this.filtro.getSitclin().getEpoc() == 1) ? true : false);
		this.filtro.getSitclin().setAnteSAHS((this.filtro.getSitclin().getSahs() != null)
				&& (this.filtro.getSitclin().getSahs() == 1) ? true : false);
		this.filtro.getSitclin().setAnteCPAP((this.filtro.getSitclin().getCpap() != null)
				&& (this.filtro.getSitclin().getCpap() == 1) ? true : false);
		this.filtro.getSitclin().setAnteNeoplasia((this.filtro.getSitclin().getNeoplasia() != null)
				&& (this.filtro.getSitclin().getNeoplasia() == 1) ? true : false);
		this.filtro.getSitclin().setAnteSincope((this.filtro.getSitclin().getSincope() != null)
				&& (this.filtro.getSitclin().getSincope() == 1) ? true : false);
		this.filtro.getSitclin().setAnteParadaCardiaca((this.filtro.getSitclin().getParadacardiaca() != null)
				&& (this.filtro.getSitclin().getParadacardiaca() == 1) ? true : false);
		this.filtro.getSitclin().setEnfarterios((this.filtro.getSitclin().getEnfart()!=null)
				&&(this.filtro.getSitclin().getEnfart()==1)?true:false);
		this.filtro.getSitclin().setAnteflutter((this.filtro.getSitclin().getFlutter()!=null)
				&&(this.filtro.getSitclin().getFlutter()==1)?true:false);
	}

	public String getModeloprocedimientobarratemporal() {
		return modeloprocedimientobarratemporal;
	}

	public void setModeloprocedimientobarratemporal(
			String modeloprocedimientobarratemporal) {
		this.modeloprocedimientobarratemporal = modeloprocedimientobarratemporal;
	}

	public String getDispprocedimientobarratemporal() {
		return dispprocedimientobarratemporal;
	}

	public void setDispprocedimientobarratemporal(
			String dispprocedimientobarratemporal) {
		this.dispprocedimientobarratemporal = dispprocedimientobarratemporal;
	}

	public int getTipoinforme() {
		return tipoinforme;
	}

	public void setTipoinforme(int tipoinforme) {
		this.tipoinforme = tipoinforme;
	}
	
	public void lecturaProperties() {
		try{
			Properties p = new Properties();
			InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
			p.load(is);
			is.close();
			this.infocentro = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
						p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"),p.getProperty("servicio"));
		}catch(Exception ex){
			logger.error("No se puede leer fichero de propiedades - labels.porperties", ex);
		}
		
	}
	
	private boolean accesoModulos(Integer i){
		switch(i){
			case 956: return this.booleanPrimoImplante = true ;
			case 957: return this.booleanReintervencion = true ;
			case 1059: return this.booleanRecambioDispositivo = true ;
			case 1060: return this.booleanUpgradeDispositivo = true ;
			case 1085: return this.booleanRecolocacionGenerador  = true ;
			case 1086: return this.booleanRecolocacionElectrodo = true ;
			case 1090: return this.booleanReimplante = true ;
			case 1147: return this.booleanExplanteDispositivo = true ;
			case 1061: return this.booleanEEF = true ;
			case 1068: return this.booleanCardioversi�nElectrica  = true ;
			case 1066: return this.booleanMesa  = true ;
			case 1067: return this.booleanRegistradorEventos = true ;
			case 1063: return this.booleanTestATP = true ;
			case 1064: return this.booleanTestEpinefrina = true ;
			case 1065: return this.booleanTestFlecainida = true ;
			case 983: return this.booleanSeguimientoDispositivo = true ;
			case 1087: return this.booleanSeguimientoCl�nico = true ;
			case 1088: return this.booleanSeguimientoRegistradorEventos = true ;
			case 1089: return this.booleanHolter  = true ;
			case 1091: return this.booleanRegistradorEventosExterno  = true ;
			case 1092: return this.booleanTestOrto  = true ;
			case 1093: return this.booleanProtocolos  = true ;
			case 9999: return this.booleanListaEspera  = true ;
			default: return false;
		}
	}

	public String getJsonstart() {
		return jsonstart;
	}

	public void setJsonstart(String jsonstart) {
		this.jsonstart = jsonstart;
	}

	public String getJsonend() {
		return jsonend;
	}

	public void setJsonend(String jsonend) {
		this.jsonend = jsonend;
	}

	public ConsentimientoBean getConsmps() {
		return consmps;
	}

	public void setConsmps(ConsentimientoBean consmps) {
		this.consmps = consmps;
	}

	public ConsentimientoBean getConsdai() {
		return consdai;
	}

	public void setConsdai(ConsentimientoBean consdai) {
		this.consdai = consdai;
	}

	public ConsentimientoBean getConsrec() {
		return consrec;
	}

	public void setConsrec(ConsentimientoBean consrec) {
		this.consrec = consrec;
	}

	public ConsentimientoBean getConshol() {
		return conshol;
	}

	public void setConshol(ConsentimientoBean conshol) {
		this.conshol = conshol;
	}

	public ConsentimientoBean getConstran() {
		return constran;
	}

	public void setConstran(ConsentimientoBean constran) {
		this.constran = constran;
	}

	public ConsentimientoBean getConsexp() {
		return consexp;
	}

	public void setConsexp(ConsentimientoBean consexp) {
		this.consexp = consexp;
	}

	public ConsentimientoBean getConsmri() {
		return consmri;
	}

	public void setConsmri(ConsentimientoBean consmri) {
		this.consmri = consmri;
	}

	public Boolean getVerComplicaciones() {
		return verComplicaciones;
	}

	public void setVerComplicaciones(Boolean verComplicaciones) {
		this.verComplicaciones = verComplicaciones;
	}

	public boolean isBooleanPrimoImplante() {
		return booleanPrimoImplante;
	}

	public void setBooleanPrimoImplante(boolean booleanPrimoImplante) {
		this.booleanPrimoImplante = booleanPrimoImplante;
	}

	public boolean isBooleanReintervencion() {
		return booleanReintervencion;
	}

	public void setBooleanReintervencion(boolean booleanReintervencion) {
		this.booleanReintervencion = booleanReintervencion;
	}

	public boolean isBooleanRecambioDispositivo() {
		return booleanRecambioDispositivo;
	}

	public void setBooleanRecambioDispositivo(boolean booleanRecambioDispositivo) {
		this.booleanRecambioDispositivo = booleanRecambioDispositivo;
	}

	public boolean isBooleanUpgradeDispositivo() {
		return booleanUpgradeDispositivo;
	}

	public void setBooleanUpgradeDispositivo(boolean booleanUpgradeDispositivo) {
		this.booleanUpgradeDispositivo = booleanUpgradeDispositivo;
	}

	public boolean isBooleanExplanteDispositivo() {
		return booleanExplanteDispositivo;
	}

	public void setBooleanExplanteDispositivo(boolean booleanExplanteDispositivo) {
		this.booleanExplanteDispositivo = booleanExplanteDispositivo;
	}

	public boolean isBooleanEEF() {
		return booleanEEF;
	}

	public void setBooleanEEF(boolean booleanEEF) {
		this.booleanEEF = booleanEEF;
	}

	public boolean isBooleanCardioversi�nElectrica() {
		return booleanCardioversi�nElectrica;
	}

	public void setBooleanCardioversi�nElectrica(boolean booleanCardioversi�nElectrica) {
		this.booleanCardioversi�nElectrica = booleanCardioversi�nElectrica;
	}

	public boolean isBooleanMesa() {
		return booleanMesa;
	}

	public void setBooleanMesa(boolean booleanMesa) {
		this.booleanMesa = booleanMesa;
	}

	public boolean isBooleanRegistradorEventos() {
		return booleanRegistradorEventos;
	}

	public void setBooleanRegistradorEventos(boolean booleanRegistradorEventos) {
		this.booleanRegistradorEventos = booleanRegistradorEventos;
	}

	public boolean isBooleanTestATP() {
		return booleanTestATP;
	}

	public void setBooleanTestATP(boolean booleanTestATP) {
		this.booleanTestATP = booleanTestATP;
	}

	public boolean isBooleanTestEpinefrina() {
		return booleanTestEpinefrina;
	}

	public void setBooleanTestEpinefrina(boolean booleanTestEpinefrina) {
		this.booleanTestEpinefrina = booleanTestEpinefrina;
	}

	public boolean isBooleanTestFlecainida() {
		return booleanTestFlecainida;
	}

	public void setBooleanTestFlecainida(boolean booleanTestFlecainida) {
		this.booleanTestFlecainida = booleanTestFlecainida;
	}

	public boolean isBooleanSeguimientoDispositivo() {
		return booleanSeguimientoDispositivo;
	}

	public void setBooleanSeguimientoDispositivo(boolean booleanSeguimientoDispositivo) {
		this.booleanSeguimientoDispositivo = booleanSeguimientoDispositivo;
	}

	public boolean isBooleanSeguimientoCl�nico() {
		return booleanSeguimientoCl�nico;
	}

	public void setBooleanSeguimientoCl�nico(boolean booleanSeguimientoCl�nico) {
		this.booleanSeguimientoCl�nico = booleanSeguimientoCl�nico;
	}

	public boolean isBooleanSeguimientoRegistradorEventos() {
		return booleanSeguimientoRegistradorEventos;
	}

	public void setBooleanSeguimientoRegistradorEventos(boolean booleanSeguimientoRegistradorEventos) {
		this.booleanSeguimientoRegistradorEventos = booleanSeguimientoRegistradorEventos;
	}

	public boolean isBooleanHolter() {
		return booleanHolter;
	}

	public void setBooleanHolter(boolean booleanHolter) {
		this.booleanHolter = booleanHolter;
	}

	public boolean isBooleanRegistradorEventosExterno() {
		return booleanRegistradorEventosExterno;
	}

	public void setBooleanRegistradorEventosExterno(boolean booleanRegistradorEventosExterno) {
		this.booleanRegistradorEventosExterno = booleanRegistradorEventosExterno;
	}

	public boolean isBooleanListaEspera() {
		return booleanListaEspera;
	}

	public void setBooleanListaEspera(boolean booleanListaEspera) {
		this.booleanListaEspera = booleanListaEspera;
	}

	public boolean isBooleanTestOrto() {
		return booleanTestOrto;
	}

	public void setBooleanTestOrto(boolean booleanTestOrto) {
		this.booleanTestOrto = booleanTestOrto;
	}

	public boolean isBooleanRecolocacionGenerador() {
		return booleanRecolocacionGenerador;
	}

	public void setBooleanRecolocacionGenerador(boolean booleanRecolocacionGenerador) {
		this.booleanRecolocacionGenerador = booleanRecolocacionGenerador;
	}

	public boolean isBooleanRecolocacionElectrodo() {
		return booleanRecolocacionElectrodo;
	}

	public void setBooleanRecolocacionElectrodo(boolean booleanRecolocacionElectrodo) {
		this.booleanRecolocacionElectrodo = booleanRecolocacionElectrodo;
	}

	public boolean isBooleanReimplante() {
		return booleanReimplante;
	}

	public void setBooleanReimplante(boolean booleanReimplante) {
		this.booleanReimplante = booleanReimplante;
	}

	public boolean isBooleanProtocolos() {
		return booleanProtocolos;
	}

	public void setBooleanProtocolos(boolean booleanProtocolos) {
		this.booleanProtocolos = booleanProtocolos;
	}
}
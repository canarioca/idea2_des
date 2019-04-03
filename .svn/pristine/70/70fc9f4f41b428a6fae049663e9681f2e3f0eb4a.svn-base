package com.sorin.idea.iu;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javax.el.ExpressionFactory;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import hvn.cm.dao.DAOException;
import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.apache.myfaces.custom.datalist.HtmlDataList;
import org.apache.myfaces.custom.schedule.HtmlSchedule;
import org.apache.myfaces.custom.schedule.ScheduleMouseEvent;
import org.apache.myfaces.custom.schedule.model.DefaultScheduleEntry;
import org.apache.myfaces.custom.schedule.model.ScheduleEntry;
import org.apache.myfaces.custom.schedule.model.ScheduleModel;
import org.apache.myfaces.custom.schedule.model.SimpleScheduleModel;
import org.richfaces.component.html.HtmlDataGrid;

import com.sorin.idea.util.UtilAgenda;
import com.sorin.idea.dao.AgendaDao;
import com.sorin.idea.dao.AgendacitaDao;
import com.sorin.idea.dao.ArrAccesoDao;
import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ArrPacienteDao;
import com.sorin.idea.dao.ArrPacientesDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.PacienteDao;
import com.sorin.idea.dto.Agenda;
import com.sorin.idea.dto.AgendaDto;
import com.sorin.idea.dto.AgendaPk;
import com.sorin.idea.dto.Agendacita;
import com.sorin.idea.dto.AgendacitaPk;
import com.sorin.idea.dto.ArrAcceso;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.EventoPk;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.exceptions.AgendaDaoException;
import com.sorin.idea.exceptions.AgendacitaDaoException;
import com.sorin.idea.exceptions.ArrAccesoDaoException;
import com.sorin.idea.exceptions.EventoDaoException;
import com.sorin.idea.jdbc.AgendaDaoImpl;
import com.sorin.idea.jdbc.AgendacitaDaoImpl;
import com.sorin.idea.jdbc.ArrAccesoDaoImpl;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ArrPacientesDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.GestorNomenclatura;
import com.sorin.idea.util.ImplanteSeguimientoBean;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilMapeos;
import com.sorin.idea.util.UtilReporteInformes;

public class ControlCitas extends BaseIU{

	private static final long serialVersionUID = -2815005343083864824L;
	//private java.sql.Connection conn;
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private String usuario;
	private static Logger logger = Logger.getLogger(ControlCitas.class);
	private LoginForm lf;
	
	private int LIMITE_INFERIOR = -120;
	private int LIMITE_SUPERIOR = 120;
	private int TAM_HUECO;
	private int HUECO_EEF;
	private int HUECO_CV;
	private int HUECO_MESA;
	private int HUECO_REG;
	private int HUECO_ATP;
	private int HUECO_EPI;
	private int HUECO_FLE;
	private int HUECO_SEG_MPS;
	private int HUECO_SEG_DAI;
	private int HUECO_SEG_CRTP;
	private int HUECO_SEG_CRTD;
	private int HUECO_IMP_MPS;
	private int HUECO_IMP_DAI;
	private int HUECO_IMP_CRTP;
	private int HUECO_IMP_CRTD;
	private int HUECO_REINTERVENCION;
	private int HUECO_REC_GEN;
	private int HUECO_REC_ELE;
	private int HUECO_HOLTER_24H;
	private int HUECO_REGEVEXT;
	private int HUECO_EXPLANTE;
	private int HUECO_SEG_CLIN;
	private int TOTAL_HUECOS;
	private int GENERAL_INI;
	private int GENERAL_FIN;
	private int WORKING_INI;
	private int WORKING_FIN;
	private boolean pleno;
	
	private Properties prop;
	private ArrayList<Date> huecoslibresdiarios;
	private ArrayList<Date> huecosdisponibles;
	private HtmlDataGrid bindingGridHuecos;
	
	private ArrAccesoDao accdao;
	private ArrMaestrasDao mdao;
	private EventoDao evdao;
	private Evento[] evs;
	private Evento[] evs_comp;
	
	private Agenda agenda;
	private Agenda personal;
	private HtmlDataTable bindingEventosDiarios;
	private HtmlDataList bindingAgendas;
	
	private AgendaDao agdao;
	private ArrayList<Agenda> agendausers;
	private ArrayList<Agenda> agendas_disp;
	private ScheduleModel model2;
	private HtmlSchedule schedule2;
	
	private AgendacitaDao agevdao;
	
	private DefaultScheduleEntry nuevoevento;
	private ScheduleEntry aux;
	
	private boolean otrocal;
	private int tamlist;
	
	private String fecha_actual;
	
	private Evento evento;	
	
	private Boolean editar;
	private Boolean agpersonal;
	
	private String columna = "fechaevento";
	private boolean ascendente = true;
	
	private Evento info;
	private PacienteAplDto filtro;
	private ArrayList<PacienteAplDto> listapats;
	private HtmlDataTable bindingPacientes;
	private Integer pagina_inicial_pat=1;
	
	public void iniciaCitas(ActionEvent e){
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			lecturaProperties();
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			this.accdao = new ArrAccesoDaoImpl(this.usuario);
			this.mdao = new ArrMaestrasDaoImpl(this.usuario);
			this.agdao = new AgendaDaoImpl(this.usuario);
			this.agevdao = new AgendacitaDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			
			this.agenda = new Agenda();
			this.agenda.getModel().setSelectedDate(new Date());
			this.personal = new Agenda();
			this.agendas_disp = new ArrayList<Agenda>();
			// Carga de todas las agendas disponibles en lateral
			Agenda[] agendas = this.agdao.findAll();
			for(Agenda a:agendas){
				if(a.getVisibilidad().equals(1))
					this.agendas_disp.add(a);
				else if(a.getVisibilidad().equals(0) && a.getIdusuario().equals(this.usuario))
					this.agendas_disp.add(a);
			}			
			existeAgPersonal();// flag de agenda personal - true si el usuario logado tiene agenda personal
			if(this.agpersonal){// POR DEFECTO, SE INICIA LA AGENDA PERSONAL
				seleccionaAgendaPersonal(null);
			}else{// POR DEFECTO, SE INICIA LA AGENDA COMPARTIDA SIEMPRE
				this.agenda = this.agdao.findByPrimaryKey(1);
				iniciaAgendaCompartida(new Date());
			}
			// Inicializacion de valores horarios para agenda
			this.actualizaValoresAgenda();
			//this.fecha_actual = new Date().toLocaleString(); 
			this.fecha_actual = UtilFechas.getFechaStringFormato(this.agenda.getModel().getSelectedDate(), "dd/MM/yyyy");
			// Obtencion de informacion de huecos general
			if(this.agenda.getSchedule().getWorkingEndHour() > this.agenda.getSchedule().getWorkingStartHour())
				this.TOTAL_HUECOS = (this.agenda.getSchedule().getWorkingEndHour() - this.agenda.getSchedule().getWorkingStartHour())*60/this.TAM_HUECO;
			else
				this.TOTAL_HUECOS = 20;// al voleo -- revisar 
			
			this.huecosdisponibles = new ArrayList<Date>();
			this.huecoslibresdiarios = new ArrayList<Date>();
			
			this.model2 = new SimpleScheduleModel();
			this.model2.setMode(ScheduleModel.WORKWEEK);
			this.model2.setSelectedDate(new Date());
			this.schedule2 = new HtmlSchedule();
			this.schedule2.setVisibleStartHour(7);
			this.schedule2.setWorkingStartHour(8);
			this.schedule2.setWorkingEndHour(14);
			this.schedule2.setVisibleEndHour(15);

			//cargarEventosTest();
			//cargarEventosDiarios();
			this.nuevoevento = new DefaultScheduleEntry();
			this.aux = new DefaultScheduleEntry();
			
			this.evento = new Evento();
			this.evento.setFechaini(new Date());
			this.evento.setFechafin(new Date());
			this.evento.setEstado(1);// por defecto -> ASIGNADA
			this.evento.setTipo(1); // por defecto -> CITACION
			this.setEditar(false);//popup evento bloqueado de inicio
			this.info = new Evento();
			this.filtro = new PacienteAplDto();
			this.listapats = new ArrayList<PacienteAplDto>();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_cons_exepc")+": "+ e1.getMessage());
		}	
	}
	
	public void seleccionaAgendaCompartida(ActionEvent e){
		try {
			this.agenda = this.agdao.findByPrimaryKey(1);
			iniciaAgendaCompartida(this.agenda.getModel().getSelectedDate());
		} catch (AgendaDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_cons_agenda")+": "+ e1.getMessage());
		}
	}
	
	public void seleccionaAgendaPersonal(ActionEvent e){
		try {			
			this.agenda.setUser(lf.getSesionUsuario());
			this.agenda.setComparar(true);
			iniciaAgendaUsers();
			/*if(this.personal.getIdagenda()!=null){
				this.agenda = this.personal;
				this.agenda.setUser(lf.getSesionUsuario());
				this.agenda.setComparar(true);
				iniciaAgendaUsers();
			}else
				this.pintaMensaje(ERROR, "No disponde de agenda asignada. Si dese disponer de una agenda, acceda a Crear Agenda");	*/	
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_cons_agenda")+": "+ e1.getMessage());
		}	
	}
	
	public void seleccionaAgenda(ActionEvent e){
		try{
			this.agenda = this.agendas_disp.get(this.bindingAgendas.getRowIndex());
			this.agenda.getDiarios().clear();
			Evento[] evs = this.evdao.getNumtotalEventosFecha(UtilFechas.addDate(new Date(),LIMITE_INFERIOR), UtilFechas.addDate(new Date(),LIMITE_SUPERIOR), this.agenda.getIdagenda());			
			for(Evento ev:evs){				
				this.agenda.getEventos().add(ev);
				cargaEventoModelo(ev,this.agenda);
				// Calculo de duracion de hueco
				ev.setHuecos(UtilAgenda.calculaNumeroHuecosEvento(ev.getFechaini(), ev.getFechafin(),this.TAM_HUECO));
				// Obtencion de tipo de generador si procede
				ev.setTipogen(UtilMapeos.obtenerTipoGeneradorEvento(ev.getIdentificador()));
				// Conversior previa - quitarle la parte de hh:mm:ss y comprar solo fecha
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // IMPORTANTE - MYSQL
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // ORACLE
			    if(sdf.parse(sdf.format(ev.getFechaini())).equals(sdf.parse(sdf.format(new Date()))))
					this.agenda.getDiarios().add(ev);
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_cons_agenda")+": "+ e1.getMessage());
		}
	}
	
	public void seleccionaPaciente(ActionEvent e){
		if(!this.listapats.get(this.bindingPacientes.getRowIndex()).isSeleccion()){
			this.listapats.get(this.bindingPacientes.getRowIndex()).setSeleccion(false);
			this.filtro = new PacienteAplDto();
			this.evento.setNombre(null);
			this.evento.setApellido1(null);
			this.evento.setApellido2(null);
			this.evento.setIdpaciente(null);
			this.evento.setCodigo(null);
		}else{
			// Limpia paciente seleccionado previamente
			for(PacienteAplDto p:this.listapats)
				if(p!=this.listapats.get(this.bindingPacientes.getRowIndex()))
					p.setSeleccion(false);
			// Selecciona actual
			this.listapats.get(this.bindingPacientes.getRowIndex()).setSeleccion(true);
			this.evento.setNombre(this.listapats.get(this.bindingPacientes.getRowIndex()).getNombre());
			this.evento.setApellido1(this.listapats.get(this.bindingPacientes.getRowIndex()).getApellid1());
			this.evento.setApellido2(this.listapats.get(this.bindingPacientes.getRowIndex()).getApellid2());
			this.evento.setIdpaciente(this.listapats.get(this.bindingPacientes.getRowIndex()).getNhc());
			this.evento.setCodigo(this.listapats.get(this.bindingPacientes.getRowIndex()).getCodigo());
			this.filtro.setSeleccion(true);
		}
	}
	
	public void existeAgPersonal(){
		try{
			Agenda[] agds = agdao.findWhereIdusuarioEquals(lf.getAcceso().getUsuario());
			if(agds.length>0){
				this.agpersonal = true;
				//this.personal = agds[0];
				this.agenda = agds[0];
			}else{
				this.agpersonal = false;
				//this.personal = new Agenda();
			}			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_cons_agenda")+": "+ e1.getMessage());
		}
	}
	
	public void cambiaFormatoPresentacion(ActionEvent e){
		//this.model2.setMode(this.agenda.getModel().getMode());
		this.agenda.getModel().refresh();
		/*if(!this.agenda.getTipoagenda().equals(0))// AGENDA PERSONAL
			for(Agenda a:this.agendausers){
				a.getModel().setMode(this.agenda.getModel().getMode());
				a.getModel().refresh();
			}*/				
		//this.model2.refresh();
	}
	/**
	 * Metodo para inicializar/actualizar la agenda compartida
	 */
	public void iniciaAgendaCompartida(Date d){
		try{
			//Agendacita[] agev = this.agevdao.findWhereIdagendaEquals(1);// La idagenda = 1 es la agenda compartida por defecto
			// Cargar los eventos por encima y por debajo de los dias especificados en LIMITE_INFERIOR y LIMITE_SUPERIOR respectivamente
			this.agenda.getDiarios().clear();
			Evento[] evs = this.evdao.getNumtotalEventosFecha(UtilFechas.addDate(d,LIMITE_INFERIOR), UtilFechas.addDate(new Date(),LIMITE_SUPERIOR), 1);			
			for(Evento e:evs){				
				this.agenda.getEventos().add(e);
				cargaEventoModelo(e,this.agenda);
				// Calculo de duracion de hueco
				e.setHuecos(UtilAgenda.calculaNumeroHuecosEvento(e.getFechaini(), e.getFechafin(),this.TAM_HUECO));
				// Obtencion de tipo de generador si procede
				e.setTipogen(UtilMapeos.obtenerTipoGeneradorEvento(e.getIdentificador()));
				// Conversior previa - quitarle la parte de hh:mm:ss y comprar solo fecha
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // IMPORTANTE - MYSQL
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // ORACLE
			    if(sdf.parse(sdf.format(e.getFechaini())).equals(sdf.parse(sdf.format(d))))
					this.agenda.getDiarios().add(e);
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_cons_agenda")+": "+ e1.getMessage());
			logger.info("("+this.usuario+") No puede inicilizarse agenda compartida. Motivo: "+e1.getMessage(),e1);
		}
	}
	
	/**
	 * Metodo para inicializar las agendas del resto de usuarios
	 * de la aplicacion.
	 * No se incluira la agenda del usuario actual logado
	 */
	public void iniciaAgendaUsers(){
		// Inicio agenda user logado
		try{
			//Agendacita[] agev = this.agevdao.findWhereIdagendaEquals(this.agenda.getIdagenda());
			// Cargar los eventos por encima y por debajo de los dias especificados en LIMITE_INFERIOR y LIMITE_SUPERIOR respectivamente
			this.agenda.getDiarios().clear();
			Evento[] evs = this.evdao.getNumtotalEventosFecha(UtilFechas.addDate(new Date(),LIMITE_INFERIOR), UtilFechas.addDate(new Date(),LIMITE_SUPERIOR), this.agenda.getIdagenda());			
			for(Evento e:evs){				
				this.agenda.getEventos().add(e);
				cargaEventoModelo(e,this.agenda);
				// Calculo de duracion de hueco
				e.setHuecos(UtilAgenda.calculaNumeroHuecosEvento(e.getFechaini(), e.getFechafin(),this.TAM_HUECO));
				// Obtencion de tipo de generador si procede
				e.setTipogen(UtilMapeos.obtenerTipoGeneradorEvento(e.getIdentificador()));
				// Conversior previa - quitarle la parte de hh:mm:ss y comprar solo fecha
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // IMPORTANTE - MYSQL
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // ORACLE
			    if(sdf.parse(sdf.format(e.getFechaini())).equals(sdf.parse(sdf.format(new Date()))))
					this.agenda.getDiarios().add(e);
			}
			/*this.evs = this.evdao.findWhereIdusuarioEquals(lf.getSesionUsuario().getUsuario());
			for(Evento e:this.evs)
				this.agenda.getEventos().add(e);*/
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_cons_agenda")+": "+ e1.getMessage());
		}
		// Recuperar usuarios de la aplicacion
		/*this.agendausers = new ArrayList<Agenda>();
		//this.agendausers.add(this.agenda);
		try {
			ArrAcceso[] users = this.accdao.findAll();			
			for(ArrAcceso u:users){
				if(!u.getUsuario().equals(this.usuario)){
					Agenda[] ag = this.agdao.findWhereIdusuarioEquals(u.getUsuario());
					if(ag.length>0){
						Agendacita[] agev = this.agevdao.findWhereIdagendaEquals(ag[0].getIdagenda());
						for(Agendacita it:agev){
							Evento ev = this.evdao.findByPrimaryKey(it.getIdevento());
							ag[0].getEventos().add(ev);
							cargaEventoModelo(ev,ag[0]);
						}
						ag[0].setUser(u);				
					}
					this.agendausers.add(ag[0]);
									
				}
				this.evs = null;
			}
			this.tamlist = this.agendausers.size();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"No se pueden inicializar agendas de usuarios. Error: "
							+ e1.getMessage());
		}*/
	}
	public void cambiaFecha(ValueChangeEvent e){
		this.agenda.getModel().setSelectedDate((Date)e.getNewValue());
		if(this.agendausers!=null)
			for(Agenda a:this.agendausers)
				a.getModel().setSelectedDate(this.agenda.getModel().getSelectedDate());		
		//this.fecha_actual = this.agenda.getModel().getSelectedDate().toLocaleString();
		this.fecha_actual = UtilFechas.getFechaStringFormato(this.agenda.getModel().getSelectedDate(), "dd/MM/yyyy");
		// Debe actualizar la lista de eventos diarios y el contenido de la lista de eventos para la fecha concreta especificada
		this.iniciaAgendaCompartida(this.agenda.getModel().getSelectedDate());
		this.agenda.getModel().refresh();
		//System.out.println(this.agenda.getModel().getSelectedDate());
	}
	
	public void cargaEventoModelo(Evento e,Agenda a)throws Exception{
		DefaultScheduleEntry item = new DefaultScheduleEntry();
		//item.setId(RandomStringUtils.randomNumeric(32));
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
	
	
	private String mapeoTipoProcedimiento(Integer i){
		switch(i){
			case 0: return "No especificado";
			case 1: return "Otro";
			case 956: return "Implante dispositivo";
			case 957: return "Reintervención";
			case 1059: return "Recambio dispositivo";
			case 1060: return "Upgrade dispositivo";
			case 1085: return "Recolocación de generador";
			case 1086: return "Recolocación de electrodo";
			case 1090: return "Reimplante de generador";
			case 1147: return "Explante dispositivo";
			case 1061: return "Estudio EF";
			case 1068: return "Cardioversión eléctrica";
			case 1066: return "Mesa basculante";
			case 1067: return "Registrador de eventos";
			case 1063: return "Test ATP";
			case 1064: return "Test Epinefrina";
			case 1065: return "Test Flecainida";
			case 983: return "Seguimiento de dispositivo";
			case 1087: return "Seguimiento clínico";
			case 1088: return "Seguimiento de registrador de eventos";
			case 1089: return "Holter 24h";
			case 1091: return "Registrador de eventos externo";
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
	/**
	 * IMPORTANTE:
	 * OJO. TODOS LOS SCHEDULEENTRY TIENEN QUE TENER UN ID ASIGNADO
	 */
	public void cargarEventosDiarios(){
		// debe cargar los eventos en agenda
		// debe cargar los eventos en la lista de eventos de la fecha seleccionada
	}
	
	public void scheduleClicked(ScheduleMouseEvent event){
        StringBuffer buffer = new StringBuffer();
        switch (event.getEventType()){
	        case ScheduleMouseEvent.SCHEDULE_BODY_CLICKED:
	            this.setEditar(true);
	        	//this.evento = new Evento();
	        	this.evento.setProcedimiento(0);// inicializacion
	        	this.evento.setFechaini(this.obtenerPrimerHuecoDisponible(event.getClickedDate()));
				// por defecto se pone a un hueco
				this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO, "min"));
				this.evento.setEstado(1);// por defecto -> ASIGNADA
	        	this.agenda.getSchedule().getModel().setSelectedDate(event.getClickedDate());
	            break;
	        case ScheduleMouseEvent.SCHEDULE_HEADER_CLICKED:
	        	this.agenda.getSchedule().getModel().setSelectedDate(event.getClickedDate());	  
	        	break;
	        case ScheduleMouseEvent.SCHEDULE_ENTRY_CLICKED:
	            this.setEditar(true);
	        	this.aux = event.getSchedule().getSubmittedEntry();// esta SI la coje. Resolucion de BUG
				try {
					this.evento = this.evdao.findByPrimaryKey(Integer.valueOf(this.aux.getId()));				
					calcularDuracion(this.evento);
					// Calculo de duracion de hueco
					this.evento.setHuecos(UtilAgenda.calculaNumeroHuecosEvento(this.evento.getFechaini(), this.evento.getFechafin(),this.TAM_HUECO));
					// Obtencion de tipo de generador si procede
					this.evento.setTipogen(UtilMapeos.obtenerTipoGeneradorEvento(this.evento.getIdentificador()));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (EventoDaoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            break;
	        default:
	            buffer.append("no schedule mouse events registered");
        }
       
       // System.out.println(buffer.toString());
    }
	
	public String scheduleAction(){
		if(this.aux!=null)
			System.out.println(this.aux.getTitle());
		return "irCitas";
	}
	
	public void guardarAgenda(ActionEvent e){
		try{
			if(this.personal.getNombre()!=null && !this.personal.getNombre().equals("")
					&& this.personal.getTipoagenda()!=null && !this.personal.getTipoagenda().equals(-1)
					&& this.personal.getVisibilidad()!=null){				
				if(this.personal.getIdagenda()!=null){//UPDATE
					this.personal.setNombre(this.personal.getNombre().toUpperCase());
					this.personal.setIdusuario(this.personal.getTipoagenda().equals(1)?lf.getAcceso().getUsuario():null);
					this.personal.setFechamod(new Date());
					this.agdao.update(new AgendaPk(this.personal.getIdagenda()), this.personal);
					this.pintaMensaje(INFO, this.bundle.getString("citas_msg_info_agenda_edit"));
					logger.info("("+this.usuario+") Agenda personal actualizada en el sistema. IdAgenda: "+this.personal.getIdagenda());
				}else{//INSERT
					this.personal.setNombre(this.personal.getNombre().toUpperCase());
					this.personal.setFechacreacion(new Date());
					this.personal.setIdusuario(this.personal.getTipoagenda().equals(1)?lf.getAcceso().getUsuario():null);
					AgendaPk agpk = this.agdao.insert(this.personal);
					// insercion en lista de agendas disponibles
					this.agendas_disp.add(this.personal);
					this.pintaMensaje(INFO, this.bundle.getString("citas_msg_info_agenda_guarda"));
					logger.info("("+this.usuario+") Nueva agenda creada en el sistema. IdAgenda: "+agpk.getIdagenda());
				}
				this.agenda = this.personal;
				this.personal = new Agenda();
			}else
				this.pintaMensaje(ERROR, this.bundle.getString("citas_msg_warn_agenda_guarda"));
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_agenda_guarda")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede crear/actualizar agenda. Error: "+ e1.getMessage(),e1);
		}
	}

	public void editarAgenda(ActionEvent e){
		try{
			if(this.agenda.getNombre()!=null && !this.agenda.getNombre().equals("")
					&& this.agenda.getTipoagenda()!=null && !this.agenda.getTipoagenda().equals(-1)){
				this.agenda.setFechamod(new Date());
				this.agdao.update(new AgendaPk(this.agenda.getIdagenda()), this.agenda);
				this.pintaMensaje(INFO, this.bundle.getString("citas_msg_info_agenda_edit"));
				logger.info("("+this.usuario+") Agenda actualizada en el sistema. IdAgenda: "+this.agenda.getIdagenda());
			}else
				this.pintaMensaje(ERROR, this.bundle.getString("citas_msg_warn_agenda_guarda"));
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_agenda_guarda")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede actualizar agenda. Error: "+ e1.getMessage(),e1);
		}
	}
	
	public void preguardaNuevoEvento(ActionEvent e){
		/*if(this.evento.getIdpaciente()!=null)
			this.buscaPacientePorNhc(null);*/
		this.info.setNombre(this.evento.getNombre());
		this.info.setIdpaciente(this.evento.getIdpaciente());
		this.info.setApellido1(this.evento.getApellido1());
		this.info.setApellido2(this.evento.getApellido2());
		this.info.setFechaini(this.evento.getFechaini());
		this.info.setProcedimiento(this.evento.getProcedimiento());
	}
	
	public void insertarNuevoEvento(ActionEvent e){		
		try{
			if(!this.evento.getProcedimiento().equals(0)){
				this.evento.setIdusuario(this.usuario);
				this.evento.setSolicitante(lf.getAcceso().getUsuario());
				this.evento.setEstado(1); //activa
				this.evento.setTipo(1);
				this.evento.setFechaasignacion(new Date());
				// Generacion de identificador IDEA
				this.evento.setIdentificador(GestorNomenclatura.generaIdentificador("EV", this.evento.getProcedimiento(), this.evento.getFechaini(),this.evento.getIdpaciente(), this.evento.getTipogen()));
				// Actualizacion de fechafin - duracion
				calcularDuracion(this.evento);
				
				EventoPk evpk = this.evdao.insert(this.evento);
				this.agenda.getEventos().add(this.evento);
				
				Agendacita agcita = new Agendacita();
				agcita.setIdagenda(this.agenda.getIdagenda());
				agcita.setIdevento(evpk.getIdevento());
				this.agevdao.insert(agcita);
				
				this.nuevoevento.setId(String.valueOf(evpk.getIdevento()));// Como id de evento se asigna el PK de Evento - Unívoco y autoincremental
				this.nuevoevento.setTitle(mapeoTipoProcedimiento(Integer.valueOf(this.evento.getProcedimiento())));
				this.nuevoevento.setSubtitle("ASIGNADA");
				this.nuevoevento.setDescription(this.evento.getDescripcion());
				this.nuevoevento.setStartTime(this.evento.getFechaini());
				this.nuevoevento.setEndTime(this.evento.getFechafin());
				if(this.evento.isTododia())
					this.nuevoevento.setAllDay(true);
				this.iniciaAgendaCompartida(new Date());
				//this.agenda.getModel().addEntry(this.nuevoevento);
				this.agenda.getModel().refresh();
				//this.nuevoevento = new DefaultScheduleEntry();
				// Actualizar lista de eventos diarios si procede
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // IMPORTANTE - MYSQL
				//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // ORACLE
			    if(sdf.parse(sdf.format(this.evento.getFechaini())).equals(sdf.parse(sdf.format(new Date()))))
					this.agenda.getDiarios().add(this.evento);			
				
				this.evento = new Evento();
				this.evento.setFechaini(new Date());
				this.evento.setFechafin(new Date());
				this.evento.setEstado(1);// por defecto -> ASIGNADA
				// actualizacion huecos
				this.huecosdisponibles.clear();
				this.huecoslibresdiarios.clear();
				
				this.setEditar(false);
				this.info = new Evento();
				this.pintaMensaje(INFO, this.bundle.getString("citas_msg_info_evento_guarda"));
				logger.info("("+this.usuario+") Nuevo evento insertado en agenda. IdEvento: "+evpk.getIdevento()+". IdAgenda: "+this.agenda.getIdagenda());
			}else{
				this.pintaMensaje(ERROR, this.bundle.getString("citas_msg_warn_evento_guarda"));
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_evento_guarda")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede insertar evento en agenda. Error: "+ e1.getMessage(),e1);
		}
	}
	
	
	public void editarEvento(ActionEvent e){
		try{
			if(!this.evento.getProcedimiento().equals(0)){
				calcularDuracion(this.evento);
				this.evdao.update(new EventoPk(this.evento.getIdevento()), this.evento);
				cargaEventoModelo(this.evento,this.agenda);
				//this.agenda.getModel().removeEntry(this.aux);// se elimina el antiguo
				//Si es un evento diario --> debe actualizarse también en la información de la lista: diarios
				for(Evento item:this.agenda.getDiarios())
					if(item.getIdevento().equals(this.evento.getIdevento())){
						this.agenda.getDiarios().remove(item);
						this.agenda.getDiarios().add(this.evento);
						break;
					}
				this.agenda.getModel().refresh();
				
				this.evento = new Evento();//Refresco para modalPanel
				this.evento.setFechaini(new Date());
				this.evento.setFechafin(new Date());
				
				this.setEditar(false);
				logger.info("("+this.usuario+") Evento actualizado con éxito en agenda. IdEvento: IdAgenda: "+this.agenda.getIdagenda());
				this.pintaMensaje(INFO, this.bundle.getString("citas_msg_info_evento_edit"));
			}else{
				this.pintaMensaje(ERROR, this.bundle.getString("citas_msg_warn_evento_guarda"));
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_evento_edit")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede editar evento en agenda. Error: "+ e1.getMessage(),e1);
		}
	}
	public void eliminarEvento(ActionEvent event){
        if (this.agenda.getModel() == null)
            return;
        // Borrado de evento en BD, de modelo Y DE LISTA EVENTOS DIARIOS SI CORRESPONDE
        try {
        	for(Evento item:this.agenda.getDiarios())
				if(item.getIdevento().equals(Integer.valueOf(this.agenda.getModel().getSelectedEntry().getId()))){
					this.agenda.getDiarios().remove(item);
					break;
				}
			this.evdao.delete(new EventoPk(Integer.valueOf(this.agenda.getModel().getSelectedEntry().getId())));
			this.agevdao.delete(new AgendacitaPk(this.agenda.getIdagenda(),Integer.valueOf(this.agenda.getModel().getSelectedEntry().getId())));
			this.agenda.getModel().removeSelectedEntry();
	        this.agenda.getModel().refresh();
	        this.setEditar(false);
	        this.pintaMensaje(INFO, this.bundle.getString("citas_msg_info_evento_borrar"));
			logger.info("("+this.usuario+") Evento eliminado de agenda. IdAgenda: "+this.agenda.getIdagenda());
		} catch (NumberFormatException e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_evento_borrar")+": "+ e.getMessage());
			logger.error("("+this.usuario+") No se puede eliminar evento en agenda. Error: "+ e.getMessage(),e);
		} catch (EventoDaoException e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_evento_borrar")+": "+ e.getMessage());
			logger.error("("+this.usuario+") No se puede eliminar evento en agenda. Error: "+ e.getMessage(),e);
		} catch (AgendacitaDaoException e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_evento_borrar")+": "+ e.getMessage());
			logger.error("("+this.usuario+") No se puede eliminar evento en agenda. Error: "+ e.getMessage(),e);
		}
    }
	public void irHoy(ActionEvent e){
		this.agenda.getModel().setSelectedDate(new Date());
		//this.fecha_actual = this.agenda.getModel().getSelectedDate().toLocaleString();
		this.fecha_actual = UtilFechas.getFechaStringFormato(this.agenda.getModel().getSelectedDate(), "dd/MM/yyyy");
		// Debe actualizar la lista de eventos diarios y el contenido de la lista de eventos para la fecha concreta especificada
		this.iniciaAgendaCompartida(this.agenda.getModel().getSelectedDate());
		this.model2.setSelectedDate(new Date());
		this.agenda.getModel().refresh();
		this.model2.refresh();
	}
	
	public void calcularDuracion(Evento e){
		if(e.getFechaini()!=null && e.getFechafin()!=null){
			if(e.isTododia()){
				setAllDay(e);
			}else if(e.getFechaini().equals(e.getFechafin()) && (!e.getDuracion().equals(0)))
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
	
	public static void setAllDay(Evento e){
		Calendar cal_ini = Calendar.getInstance();
		cal_ini.setTime(e.getFechaini());
		cal_ini.set(Calendar.HOUR_OF_DAY,00);
		cal_ini.set(Calendar.MINUTE,00);
		cal_ini.set(Calendar.SECOND,00);
		cal_ini.set(Calendar.MILLISECOND,0);
		Calendar cal_fin = Calendar.getInstance();
		cal_fin.setTime(e.getFechafin());
		cal_fin.set(Calendar.HOUR_OF_DAY,23);
		cal_fin.set(Calendar.MINUTE,59);
		cal_fin.set(Calendar.SECOND,59);
		cal_fin.set(Calendar.MILLISECOND,999);
		e.setFechaini(cal_ini.getTime());
		e.setFechafin(cal_fin.getTime());
	}
	
	public void sortEventos(final String columna, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				Evento c1 = (Evento) o1;
				Evento c2 = (Evento) o2;
				try {
					if (columna == null) {
						return 0;
					}
					if (columna.equals("fechaevento")) {
						return ascending ? c1.getFechaini().compareTo(c2.getFechaini()) : c2.getFechaini().compareTo(c1.getFechaini());
					} else
						return 0;
				} catch (Exception ex) {
					return 0;
				}
			}
		};
		Collections.sort(this.agenda.getDiarios(), comparator);
	}
	/**
	 * Genera informe de eventos diarios
	 * @param e
	 */
	public void generaInformeDiario(ActionEvent e){
		try{
			Date fecha_fin = UtilFechas.sumarRestarDiasFecha(this.agenda.getModel().getSelectedDate(), 1);
			//Evento[] evs = this.evdao.findByDynamicWhere("FECHAINI >= ? AND FECHAFIN <=?", new Object[]{this.agenda.getModel().getSelectedDate(),fecha_fin}); 
			Evento[] evs = this.evdao.getNumtotalEventosFecha(this.agenda.getModel().getSelectedDate(), fecha_fin, this.agenda.getIdagenda());
			generaInforme(evs,"DIARIO",UtilFechas.getFechaStringFormato(this.agenda.getModel().getSelectedDate(), "dd-MM-yyyy"),null,null);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
				this.bundle.getString("citas_msg_error_informes")+": "+ e1.getMessage());
		}	
	}
	
	public void generaInformeSemanal(ActionEvent e){
		try{
			Date f_ini = UtilFechas.getInicioSemana(this.agenda.getModel().getSelectedDate());
			Date f_fin = UtilFechas.getFinSemana(this.agenda.getModel().getSelectedDate());					
			//Evento[] evs = this.evdao.findByDynamicWhere("FECHAINI >= ? AND FECHAFIN <=?", new Object[]{f_ini,f_fin}); 			
			Evento[] evs = this.evdao.getNumtotalEventosFecha(f_ini, f_fin, this.agenda.getIdagenda());
			generaInforme(evs,"SEMANAL",null,"Semana del "+UtilFechas.getDiaMes(f_ini)+" al "+UtilFechas.getDiaMes(f_fin)+" de "+UtilFechas.getMesString(f_ini)+" de "+UtilFechas.anioToString(this.agenda.getModel().getSelectedDate()),null);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_informes")+": "+ e1.getMessage());
		}
	}
	
	public void generaInformeMensual(ActionEvent e){
		try{
			//Evento[] evs = this.evdao.findByDynamicWhere("FECHAINI >= ? AND FECHAFIN <=?", new Object[]{UtilFechas.getInicioMes(this.agenda.getModel().getSelectedDate()),UtilFechas.getFinMes(this.agenda.getModel().getSelectedDate())});
			Evento[] evs = this.evdao.getNumtotalEventosFecha(UtilFechas.getInicioMes(this.agenda.getModel().getSelectedDate()), UtilFechas.getFinMes(this.agenda.getModel().getSelectedDate()), this.agenda.getIdagenda());
			generaInforme(evs,"MENSUAL",null,null,UtilFechas.getMesString(this.agenda.getModel().getSelectedDate())+" "+UtilFechas.anioToString(this.agenda.getModel().getSelectedDate()));
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("citas_msg_error_informes")+": "+ e1.getMessage());
		}
	}
	
	public void generaInforme(Evento[] eventos, String tipo,String dia, String semana, String mes){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(
				FacesContext.getCurrentInstance());
		String jasper = "InformeEventos.jasper";
		try {			
			PathFicheroXml = generadorXML.imprimeInformeEventos(eventos, this.agenda, lf.getAcceso(),tipo,dia,semana,mes,this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Motivo: "+ se.getMessage());			
			try {
				this.nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: " + se.getMessage(),
						"Error generando documento,Motivo: " + se.getMessage());
			} catch (Exception e3) {
			}
		}
		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),
					PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generación de informe (Eventos)");
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Motivo: "+ se.getMessage());			
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}

	}
	
	public void addCalendario(ActionEvent e){
		// metodo para obtener los eventos del calendario del usuario escogido
	}
	
	public Integer calculaNumeroHuecosEvento(Date start, Date fin){
		try{
	        float minutos = (fin.getTime() - start.getTime())/ 60000; // 1000 * 60 * 60 
	        Float num_huecos = minutos / this.TAM_HUECO;        
	        // Se aplica redondeo. Si esta por encima del tamaño de hueco se toma un hueco mas.
	        return (int)Math.round(num_huecos);
		}catch(Exception e){
			
		}
		return 0;
	}
	
	public void adaptaHuecosAgenda(ActionEvent e){
		// Aqui hay que reorganizar y recalcular en funcion del nuevo tamaño
		// la duracion en huecos de los eventos
		for(Evento ev:this.agenda.getEventos()){
			// Calculo de duracion de hueco
			ev.setHuecos(UtilAgenda.calculaNumeroHuecosEvento(ev.getFechaini(), ev.getFechafin(),this.TAM_HUECO));
		}
		this.actualizaValoresProperties(null);// para guardar el nuevo valor de duracion de hueco
	}
	
	public Date obtenerPrimerHuecoDisponible(Date fecha){
		try{
			// Obtenemos los eventos diarios de la fecha señalada. De 0 a 24h especificados
			// Se adapta el filtro de consulta de horas
			fecha.setHours(0);
			fecha.setMinutes(0);
			fecha.setSeconds(0);
			Date end = UtilFechas.sumarRestarDiasFecha(fecha, 1);
			Evento[] evs = this.evdao.getNumtotalEventosFecha(fecha, end, this.agenda.getIdagenda());
			List<Evento> lista_evs = Arrays.asList(evs);
			if(evs.length>0){				
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
				//if(this.agenda.isGestionhuecos())
				//	this.cargaListaHuecosDisponiblesDiarios(fecha, lista_evs);
				// Una vez ordenado, se obtiene la fecha final del ultimo evento
				return lista_evs.get(lista_evs.size()-1).getFechafin();
			}else{
				// no hay procedimientos para ese dia. Se asigna el primer hueco de la fecha especificada			
				fecha.setHours(this.agenda.getSchedule().getWorkingStartHour());
				fecha.setMinutes(0);
				fecha.setSeconds(0);
				return fecha;
			}
		}catch(Exception e){
			this.pintaMensaje(ERROR, this.bundle.getString("citas_msg_error_hueco_selec")+": "+e.getMessage());
		}			
		return new Date();		
	}
	
	public List<Evento> obtenerListaEventosDiarios(Date fecha){
		try{
			// Obtenemos los eventos diarios de la fecha señalada. De 0 a 24h especificados
			// Se adapta el filtro de consulta de horas
			Date f = new Date();
			f.setDate(fecha.getDate());
			f.setHours(0);
			f.setMinutes(0);
			f.setSeconds(0);
			Date end = UtilFechas.sumarRestarDiasFecha(f, 1);
			Evento[] evs = this.evdao.getNumtotalEventosFecha(f, end, this.agenda.getIdagenda());
			List<Evento> lista_evs = Arrays.asList(evs);
			if(evs.length>0){				
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
			}
			return lista_evs;
		}catch(Exception e){
			this.pintaMensaje(ERROR, this.bundle.getString("citas_msg_error_evento_rec_lista_diarios")+": "+e.getMessage());
			return null;
		}
	}
	
	public void cambiaProcedimientoEvento(ActionEvent e){
		if(this.agenda.isGestionhuecos()){
			if(this.evento.getProcedimiento()!=null){			
				if(this.evento.getProcedimiento().equals(983)){
					if(this.evento.getTipogen().equals(1) || this.evento.getTipogen().equals(5)){
						this.evento.setHuecos(this.HUECO_SEG_MPS);
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_SEG_MPS, "min"));
					}else if(this.evento.getTipogen().equals(2) || this.evento.getTipogen().equals(6)){
						this.evento.setHuecos(this.HUECO_SEG_DAI);
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_SEG_DAI, "min"));
					}else if(this.evento.getTipogen().equals(3)){
						this.evento.setHuecos(this.HUECO_SEG_CRTP);
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_SEG_CRTP, "min"));
					}else if(this.evento.getTipogen().equals(4)){
						this.evento.setHuecos(this.HUECO_SEG_CRTD);
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_SEG_CRTD, "min"));
					}
					if(this.evento.getTipogen()!=0)
						this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(956) || this.evento.getProcedimiento().equals(1059) 
						|| this.evento.getProcedimiento().equals(1060) || this.evento.getProcedimiento().equals(1090)){
					if(this.evento.getTipogen().equals(1) || this.evento.getTipogen().equals(5)){
						this.evento.setHuecos(this.HUECO_IMP_MPS);
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_IMP_MPS, "min"));
					}else if(this.evento.getTipogen().equals(2) || this.evento.getTipogen().equals(6)){
						this.evento.setHuecos(this.HUECO_IMP_DAI);
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_IMP_DAI, "min"));
					}else if(this.evento.getTipogen().equals(3)){
						this.evento.setHuecos(this.HUECO_IMP_CRTP);
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_IMP_CRTP, "min"));
					}else if(this.evento.getTipogen().equals(4)){
						this.evento.setHuecos(this.HUECO_IMP_CRTD);
						this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_IMP_CRTD, "min"));
					}
					if(this.evento.getTipogen()!=0)
						this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(957)){
					this.evento.setHuecos(this.HUECO_REINTERVENCION);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_REINTERVENCION, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1147)){
					this.evento.setHuecos(this.HUECO_EXPLANTE);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_EXPLANTE, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1085)){
					this.evento.setHuecos(this.HUECO_REC_GEN);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_REC_GEN, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1086)){
					this.evento.setHuecos(this.HUECO_REC_ELE);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_REC_ELE, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1061)){
					this.evento.setHuecos(this.HUECO_EEF);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_EEF, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1068)){
					this.evento.setHuecos(this.HUECO_CV);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_CV, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1066)){
					this.evento.setHuecos(this.HUECO_MESA);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_MESA, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1067)){
					this.evento.setHuecos(this.HUECO_REG);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_REG, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1063)){
					this.evento.setHuecos(this.HUECO_ATP);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_ATP, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1064)){
					this.evento.setHuecos(this.HUECO_EPI);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_EPI, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1065)){
					this.evento.setHuecos(this.HUECO_FLE);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_FLE, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1089)){
					this.evento.setHuecos(this.HUECO_HOLTER_24H);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_HOLTER_24H, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1091)){
					this.evento.setHuecos(this.HUECO_REGEVEXT);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_REGEVEXT, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}else if(this.evento.getProcedimiento().equals(1087)){
					this.evento.setHuecos(this.HUECO_SEG_CLIN);
					this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.TAM_HUECO * this.HUECO_SEG_CLIN, "min"));
					this.evento.setTipogen(0); // actualiza para optimizacion en selector de evento de formulario
					this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
				}
				calcularDuracion(this.evento);
			}
		}	
	}
	
	public void actualizaValoresProperties(ActionEvent e){
		try{
			this.prop.setProperty("hueco.duracion", String.valueOf(this.TAM_HUECO));
			
			this.prop.setProperty("general.inicio", String.valueOf(this.GENERAL_INI));
			this.prop.setProperty("general.fin", String.valueOf(this.GENERAL_FIN));
			this.prop.setProperty("working.inicio", String.valueOf(this.WORKING_INI));
			this.prop.setProperty("working.fin", String.valueOf(this.WORKING_FIN));
			this.actualizaValoresAgenda();
			
			this.prop.store(new FileOutputStream("agenda.properties"), "actualizacion");
			logger.info("("+this.usuario+") Fichero de propiedades actualizado con éxito.");
		}catch(Exception e1){
			this.pintaMensaje(ERROR, this.bundle.getString("citas_msg_error_edit_valores")+": "+e1.getMessage());
			logger.error("("+this.usuario+") Error actualizando valores de properties. Motivo: "+ e1.getMessage());
		}
	}
	
	public void actualizaValoresAgenda(){
		this.agenda.getSchedule().setVisibleStartHour(this.GENERAL_INI);
		this.agenda.getSchedule().setVisibleEndHour(this.GENERAL_FIN);
		this.agenda.getSchedule().setWorkingStartHour(this.WORKING_INI);
		this.agenda.getSchedule().setWorkingEndHour(this.WORKING_FIN);
	}
	
	public void cargaListaHuecosDisponiblesDiarios(Date fecha){
		this.huecoslibresdiarios.clear();
		this.huecosdisponibles.clear();
		this.pleno = false;
		// Se adapta la fecha al inicio del working hour de la agenda
		fecha.setHours(this.agenda.getSchedule().getWorkingStartHour());
		fecha.setMinutes(0);
		fecha.setSeconds(0);
		UtilAgenda.crearListaHuecosDiario(this.huecosdisponibles, this.TOTAL_HUECOS, this.TAM_HUECO, fecha);
		// Se obtiene la lista de eventos de la fecha seleccionada
		List<Evento> lista_evs = obtenerListaEventosDiarios(fecha);
		// Se carga en un objeto ArrayList<Date> las fechas de los eventos actuales que ocupan huecos
		// Sabiendo el tamaño de hueco y el numero de huecos que ocupa, se puede obtener sus fechas
		ArrayList<Date> m1 = new ArrayList<Date>();
		for(Evento ev:lista_evs){	
			ev.setHuecos(UtilAgenda.calculaNumeroHuecosEvento(ev.getFechaini(), ev.getFechafin(),this.TAM_HUECO));// Calculo de duracion de hueco/evento
			if(ev.getEstado()==1)// solo mete las citas activas. Las canceladas no deben ocupar hueco
				this.insertaHuecos(m1, ev.getHuecos(), ev.getFechaini());
		}
		// Elimina del array los huecos ocupados por eventos diarios. Se marcan a a null
		UtilAgenda.marcarHorasOcupadas(this.huecosdisponibles, m1);
		this.huecoslibresdiarios = UtilAgenda.obtenerFranjasLibres(this.huecosdisponibles, this.evento.getHuecos());
		if(this.huecoslibresdiarios.size()>0){// Por defecto escoge el primer hueco libre
			this.evento.setFechaini(this.huecoslibresdiarios.get(0));
			this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.evento.getHuecos() * this.TAM_HUECO, "min"));
			this.calcularDuracion(this.evento);
		}else{
			this.pintaMensaje(AVISO, this.bundle.getString("citas_msg_warn_hueco_selec_ocupado"));
			this.setPleno(true);
		}	
	}
	
	public void avanza1Dia(ActionEvent e){
		this.evento.setFechaini(UtilFechas.sumarRestarDiasFecha(this.evento.getFechaini(), 1));
		this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
	}
	
	public void retrocede1Dia(ActionEvent e){
		this.evento.setFechaini(UtilFechas.sumarRestarDiasFecha(this.evento.getFechaini(), -1));
		this.cargaListaHuecosDisponiblesDiarios(this.evento.getFechaini());
	}
	
	public void insertaHuecos(ArrayList<Date> m1, int numhuecos, Date start){
		for(int i=0;i<numhuecos;i++)
			m1.add(UtilFechas.sumaDuracion(start, this.TAM_HUECO*i, "min"));		
	}
	
	public void selHueco(ActionEvent e){
		this.evento.setFechaini(this.huecoslibresdiarios.get(this.bindingGridHuecos.getRowIndex()));
		this.evento.setFechafin(UtilFechas.sumaDuracion(this.evento.getFechaini(), this.evento.getHuecos() * this.TAM_HUECO, "min"));
		this.calcularDuracion(this.evento);
	}
	
	public void cierraVentanaHueco(ActionEvent e){
		this.huecosdisponibles.clear();
		this.huecoslibresdiarios.clear();
		 this.setEditar(false);
	}
	
	/*public void buscaPacientePorNhc(ActionEvent e){
		try {
			ArrPacientesDao patdao = new ArrPacientesDaoImpl(this.usuario);
			ArrPacientes[] pat = patdao.findWhereNhcEquals(this.evento.getIdpaciente());
			if(pat!=null && pat.length>0){
				this.evento.setIdpaciente(pat[0].getNhc());
				this.evento.setNombre(pat[0].getNombre());
				this.evento.setApellido1(pat[0].getApellid1());
				this.evento.setApellido2(pat[0].getApellid2());
				this.evento.setCodigo(pat[0].getCodigo());
			}
		} catch (Exception e1) {
			this.pintaMensaje(ERROR, "No se pueden recuperar pacientes del sistema. Motivo: "+e1.getMessage());
		}
	}
	
	public void buscaPacientePorNhc_2(ActionEvent e){
		try {
			ArrPacientesDao patdao = new ArrPacientesDaoImpl(this.usuario);
			ArrPacientes[] pats = patdao.findWhereNhcEquals(this.filtro.getNhc());
			if(pats!=null && pats.length>0){
				for(ArrPacientes p:pats)
					this.listapats.add(p);
			}else
				this.pintaMensaje(INFO, "No se han encontrado coincidencias para los filtros especificados.");
		} catch (Exception e1) {
			this.pintaMensaje(ERROR, "No se pueden recuperar pacientes del sistema. Motivo: "+e1.getMessage());
		}
	}
	
	public void buscaPacientePorCIP(ActionEvent e){
		try {
			ArrPacientesDao patdao = new ArrPacientesDaoImpl(this.usuario);
			ArrPacientes[] pats = patdao.findWhereNuhsaEquals(this.filtro.getNuhsa());
			if(pats!=null && pats.length>0){
				for(ArrPacientes p:pats)
					this.listapats.add(p);
			}else
				this.pintaMensaje(INFO, "No se han encontrado coincidencias para los filtros especificados.");
		} catch (Exception e1) {
			this.pintaMensaje(ERROR, "No se pueden recuperar pacientes del sistema. Motivo: "+e1.getMessage());
		}
	}*/
	
	public void buscarPacientes(ActionEvent e){
		try {
			ArrPacienteDao patdao = new ArrPacienteDao(this.usuario);
			this.filtro.setNproc("");
			this.filtro.setTipoproc(0);
			this.listapats = patdao.buscaPacientes(this.filtro);
			if(this.listapats.size()==0)
				this.pintaMensaje(INFO, this.bundle.getString("info_msg_warn_consulta"));	
		} catch (Exception e1) {
			this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_rec_pats")+": "+e1.getMessage());
			e1.printStackTrace();
		}
	}
	
	public void limpiar(ActionEvent e){
		this.listapats.clear();
		this.filtro = new PacienteAplDto();
		this.evento.setIdpaciente(null);
		this.evento.setNombre(null);
		this.evento.setApellido1(null);
		this.evento.setApellido2(null);
	}
	
	public void lecturaProperties() {
		try {
			this.prop = new Properties();
			InputStream is = ControlCitas.class.getResourceAsStream("agenda.properties");
			this.prop.load(is);
			this.TAM_HUECO = Integer.parseInt(this.prop.getProperty("hueco.duracion"));
			this.HUECO_EEF = Integer.parseInt(this.prop.getProperty("hueco.eef"));
			this.HUECO_CV = Integer.parseInt(this.prop.getProperty("hueco.cv"));
			this.HUECO_MESA = Integer.parseInt(this.prop.getProperty("hueco.mes"));
			this.HUECO_REG = Integer.parseInt(this.prop.getProperty("hueco.reg"));
			this.HUECO_ATP = Integer.parseInt(this.prop.getProperty("hueco.atp"));
			this.HUECO_EPI = Integer.parseInt(this.prop.getProperty("hueco.epi"));
			this.HUECO_FLE = Integer.parseInt(this.prop.getProperty("hueco.fle"));
			this.HUECO_IMP_MPS = Integer.parseInt(this.prop.getProperty("hueco.imp.mps"));
			this.HUECO_IMP_DAI = Integer.parseInt(this.prop.getProperty("hueco.imp.dai"));
			this.HUECO_IMP_CRTP = Integer.parseInt(this.prop.getProperty("hueco.imp.crtp"));
			this.HUECO_IMP_CRTD = Integer.parseInt(this.prop.getProperty("hueco.imp.crtd"));
			this.HUECO_SEG_MPS = Integer.parseInt(this.prop.getProperty("hueco.seg.mps"));
			this.HUECO_SEG_DAI = Integer.parseInt(this.prop.getProperty("hueco.seg.dai"));
			this.HUECO_SEG_CRTP = Integer.parseInt(this.prop.getProperty("hueco.seg.crtp"));
			this.HUECO_SEG_CRTD = Integer.parseInt(this.prop.getProperty("hueco.seg.crtd"));
			this.HUECO_REINTERVENCION = Integer.parseInt(this.prop.getProperty("hueco.reint"));
			this.HUECO_EXPLANTE = Integer.parseInt(this.prop.getProperty("hueco.exp"));
			this.HUECO_REC_GEN = Integer.parseInt(this.prop.getProperty("hueco.recol.gen"));
			this.HUECO_REC_ELE = Integer.parseInt(this.prop.getProperty("hueco.recol.ele"));
			this.HUECO_HOLTER_24H = Integer.parseInt(this.prop.getProperty("hueco.holter"));
			this.HUECO_REGEVEXT = Integer.parseInt(this.prop.getProperty("hueco.regevext"));
			this.HUECO_SEG_CLIN = Integer.parseInt(this.prop.getProperty("hueco.seg.clin"));
			this.GENERAL_INI = Integer.parseInt(this.prop.getProperty("general.inicio"));
			this.GENERAL_FIN = Integer.parseInt(this.prop.getProperty("general.fin"));
			this.WORKING_INI = Integer.parseInt(this.prop.getProperty("working.inicio"));
			this.WORKING_FIN = Integer.parseInt(this.prop.getProperty("working.fin"));
			is.close();
		} catch (Exception e) {
			this.pintaMensaje(ERROR, "Error. No es posible inicializar fichero de propiedades. Motivo: "+e.getMessage());
		}	
	}
	
	
	/********* GET/SET*******************************/
	public DefaultScheduleEntry getNuevoevento() {
		return nuevoevento;
	}

	public void setNuevoevento(DefaultScheduleEntry nuevoevento) {
		this.nuevoevento = nuevoevento;
	}

	public ScheduleEntry getAux() {
		return aux;
	}

	public void setAux(ScheduleEntry aux) {
		this.aux = aux;
	}

	public ScheduleModel getModel2() {
		return model2;
	}

	public void setModel2(ScheduleModel model2) {
		this.model2 = model2;
	}

	public HtmlSchedule getSchedule2() {
		return schedule2;
	}

	public void setSchedule2(HtmlSchedule schedule2) {
		this.schedule2 = schedule2;
	}

	public boolean isOtrocal() {
		return otrocal;
	}

	public void setOtrocal(boolean otrocal) {
		this.otrocal = otrocal;
	}

	public Agenda getAgenda() {
		sortEventos(columna, ascendente);
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public ArrayList<Agenda> getAgendausers() {
		return agendausers;
	}

	public void setAgendausers(ArrayList<Agenda> agendausers) {
		this.agendausers = agendausers;
	}

	public int getTamlist() {
		return tamlist;
	}

	public void setTamlist(int tamlist) {
		this.tamlist = tamlist;
	}

	public String getFecha_actual() {
		return fecha_actual;
	}

	public void setFecha_actual(String fecha_actual) {
		this.fecha_actual = fecha_actual;
	}

	public HtmlDataTable getBindingEventosDiarios() {
		return bindingEventosDiarios;
	}

	public void setBindingEventosDiarios(HtmlDataTable bindingEventosDiarios) {
		this.bindingEventosDiarios = bindingEventosDiarios;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}
	
	public Boolean getAgpersonal() {
		return agpersonal;
	}

	public void setAgpersonal(Boolean agpersonal) {
		this.agpersonal = agpersonal;
	}

	public Agenda getPersonal() {
		return personal;
	}

	public void setPersonal(Agenda personal) {
		this.personal = personal;
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

	public ArrayList<Agenda> getAgendas_disp() {
		return agendas_disp;
	}

	public void setAgendas_disp(ArrayList<Agenda> agendas_disp) {
		this.agendas_disp = agendas_disp;
	}

	public HtmlDataList getBindingAgendas() {
		return bindingAgendas;
	}

	public void setBindingAgendas(HtmlDataList bindingAgendas) {
		this.bindingAgendas = bindingAgendas;
	}

	public int getTAM_HUECO() {
		return TAM_HUECO;
	}

	public void setTAM_HUECO(int tAM_HUECO) {
		TAM_HUECO = tAM_HUECO;
	}

	public int getHUECO_EEF() {
		return HUECO_EEF;
	}

	public void setHUECO_EEF(int hUECO_EEF) {
		HUECO_EEF = hUECO_EEF;
	}

	public int getHUECO_CV() {
		return HUECO_CV;
	}

	public void setHUECO_CV(int hUECO_CV) {
		HUECO_CV = hUECO_CV;
	}

	public int getHUECO_MESA() {
		return HUECO_MESA;
	}

	public void setHUECO_MESA(int hUECO_MESA) {
		HUECO_MESA = hUECO_MESA;
	}

	public int getHUECO_REG() {
		return HUECO_REG;
	}

	public void setHUECO_REG(int hUECO_REG) {
		HUECO_REG = hUECO_REG;
	}

	public int getHUECO_ATP() {
		return HUECO_ATP;
	}

	public void setHUECO_ATP(int hUECO_ATP) {
		HUECO_ATP = hUECO_ATP;
	}

	public int getHUECO_EPI() {
		return HUECO_EPI;
	}

	public void setHUECO_EPI(int hUECO_EPI) {
		HUECO_EPI = hUECO_EPI;
	}

	public int getHUECO_FLE() {
		return HUECO_FLE;
	}

	public void setHUECO_FLE(int hUECO_FLE) {
		HUECO_FLE = hUECO_FLE;
	}

	public int getHUECO_SEG_MPS() {
		return HUECO_SEG_MPS;
	}

	public void setHUECO_SEG_MPS(int hUECO_SEG_MPS) {
		HUECO_SEG_MPS = hUECO_SEG_MPS;
	}

	public int getHUECO_SEG_DAI() {
		return HUECO_SEG_DAI;
	}

	public void setHUECO_SEG_DAI(int hUECO_SEG_DAI) {
		HUECO_SEG_DAI = hUECO_SEG_DAI;
	}

	public int getHUECO_SEG_CRTP() {
		return HUECO_SEG_CRTP;
	}

	public void setHUECO_SEG_CRTP(int hUECO_SEG_CRTP) {
		HUECO_SEG_CRTP = hUECO_SEG_CRTP;
	}

	public int getHUECO_SEG_CRTD() {
		return HUECO_SEG_CRTD;
	}

	public void setHUECO_SEG_CRTD(int hUECO_SEG_CRTD) {
		HUECO_SEG_CRTD = hUECO_SEG_CRTD;
	}

	public int getHUECO_IMP_MPS() {
		return HUECO_IMP_MPS;
	}

	public void setHUECO_IMP_MPS(int hUECO_IMP_MPS) {
		HUECO_IMP_MPS = hUECO_IMP_MPS;
	}

	public int getHUECO_IMP_DAI() {
		return HUECO_IMP_DAI;
	}

	public void setHUECO_IMP_DAI(int hUECO_IMP_DAI) {
		HUECO_IMP_DAI = hUECO_IMP_DAI;
	}

	public int getHUECO_IMP_CRTP() {
		return HUECO_IMP_CRTP;
	}

	public void setHUECO_IMP_CRTP(int hUECO_IMP_CRTP) {
		HUECO_IMP_CRTP = hUECO_IMP_CRTP;
	}

	public int getHUECO_IMP_CRTD() {
		return HUECO_IMP_CRTD;
	}

	public void setHUECO_IMP_CRTD(int hUECO_IMP_CRTD) {
		HUECO_IMP_CRTD = hUECO_IMP_CRTD;
	}

	public int getHUECO_REINTERVENCION() {
		return HUECO_REINTERVENCION;
	}

	public void setHUECO_REINTERVENCION(int hUECO_REINTERVENCION) {
		HUECO_REINTERVENCION = hUECO_REINTERVENCION;
	}

	public int getHUECO_REC_GEN() {
		return HUECO_REC_GEN;
	}

	public void setHUECO_REC_GEN(int hUECO_REC_GEN) {
		HUECO_REC_GEN = hUECO_REC_GEN;
	}

	public int getHUECO_REC_ELE() {
		return HUECO_REC_ELE;
	}

	public void setHUECO_REC_ELE(int hUECO_REC_ELE) {
		HUECO_REC_ELE = hUECO_REC_ELE;
	}

	public int getHUECO_EXPLANTE() {
		return HUECO_EXPLANTE;
	}

	public void setHUECO_EXPLANTE(int hUECO_EXPLANTE) {
		HUECO_EXPLANTE = hUECO_EXPLANTE;
	}

	/*public ArrayList<Date> getHuecoslibresdiarios() {
		return huecoslibresdiarios;
	}*/
	
	public ArrayList<String> getHuecoslibresdiarios() {
		ArrayList<String> diag = new ArrayList<String>();
		for (Date ref : this.huecoslibresdiarios){
			diag.add(new String(ref.getHours()+":"+ref.getMinutes()));
		}		
		return diag;
	}

	public void setHuecoslibresdiarios(ArrayList<Date> huecoslibresdiarios) {
		this.huecoslibresdiarios = huecoslibresdiarios;
	}

	public ArrayList<Date> getHuecosdisponibles() {
		return huecosdisponibles;
	}

	public void setHuecosdisponibles(ArrayList<Date> huecosdisponibles) {
		this.huecosdisponibles = huecosdisponibles;
	}

	/*public ArrayList<String> getHuecoslibresdiariosstr() {
		return huecoslibresdiariosstr;
	}*/
	
	public ArrayList<String> getHuecoslibresdiariosstr() {
		ArrayList<String> diag = new ArrayList<String>();
		for (Date ref : this.huecoslibresdiarios){
			diag.add(new String(ref.getHours()+":"+ref.getMinutes()));
		}		
		return diag;
	}

	public HtmlDataGrid getBindingGridHuecos() {
		return bindingGridHuecos;
	}

	public void setBindingGridHuecos(HtmlDataGrid bindingGridHuecos) {
		this.bindingGridHuecos = bindingGridHuecos;
	}

	public int getGENERAL_INI() {
		return GENERAL_INI;
	}

	public void setGENERAL_INI(int gENERAL_INI) {
		GENERAL_INI = gENERAL_INI;
	}

	public int getGENERAL_FIN() {
		return GENERAL_FIN;
	}

	public void setGENERAL_FIN(int gENERAL_FIN) {
		GENERAL_FIN = gENERAL_FIN;
	}

	public int getWORKING_INI() {
		return WORKING_INI;
	}

	public void setWORKING_INI(int wORKING_INI) {
		WORKING_INI = wORKING_INI;
	}

	public int getWORKING_FIN() {
		return WORKING_FIN;
	}

	public void setWORKING_FIN(int wORKING_FIN) {
		WORKING_FIN = wORKING_FIN;
	}

	public boolean isPleno() {
		return pleno;
	}

	public void setPleno(boolean pleno) {
		this.pleno = pleno;
	}

	public Evento getInfo() {
		return info;
	}

	public void setInfo(Evento info) {
		this.info = info;
	}

	public PacienteAplDto getFiltro() {
		return filtro;
	}

	public void setFiltro(PacienteAplDto filtro) {
		this.filtro = filtro;
	}

	public ArrayList<PacienteAplDto> getListapats() {
		return listapats;
	}

	public void setListapats(ArrayList<PacienteAplDto> listapats) {
		this.listapats = listapats;
	}

	public HtmlDataTable getBindingPacientes() {
		return bindingPacientes;
	}

	public void setBindingPacientes(HtmlDataTable bindingPacientes) {
		this.bindingPacientes = bindingPacientes;
	}

	public Integer getPagina_inicial_pat() {
		return pagina_inicial_pat;
	}

	public void setPagina_inicial_pat(Integer pagina_inicial_pat) {
		this.pagina_inicial_pat = pagina_inicial_pat;
	}

	public int getHUECO_HOLTER_24H() {
		return HUECO_HOLTER_24H;
	}

	public void setHUECO_HOLTER_24H(int hUECO_HOLTER_24H) {
		HUECO_HOLTER_24H = hUECO_HOLTER_24H;
	}

	public ArrayList<SelectItem> getProcedimientos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		if(this.lf.getAccmods().getEef()!=null && this.lf.getAccmods().getEef()==1)
			diag.add(new SelectItem("1061", this.bundle.getString("proc_label_eef_abl")));
		if(this.lf.getAccmods().getImplante()!=null && this.lf.getAccmods().getImplante()==1){
			diag.add(new SelectItem("956", this.bundle.getString("proc_956")));
			diag.add(new SelectItem("1059", this.bundle.getString("proc_1059")));
			diag.add(new SelectItem("1060", this.bundle.getString("proc_1060")));
			diag.add(new SelectItem("1085", this.bundle.getString("proc_1085")));
			diag.add(new SelectItem("1086", this.bundle.getString("proc_1086")));
			diag.add(new SelectItem("1147", this.bundle.getString("proc_label_exp_2")));
			diag.add(new SelectItem("957", this.bundle.getString("proc_957")));
			diag.add(new SelectItem("983", this.bundle.getString("proc_983")));
			diag.add(new SelectItem("1090", this.bundle.getString("proc_1090")));
			diag.add(new SelectItem("1087", this.bundle.getString("proc_1087")));
		}
		if(this.lf.getAccmods().getRegistrador()!=null && this.lf.getAccmods().getRegistrador()==1){
			diag.add(new SelectItem("1067", this.bundle.getString("proc_1067")));
			diag.add(new SelectItem("1088", this.bundle.getString("proc_1088")));
		}
		if(this.lf.getAccmods().getCv()!=null && this.lf.getAccmods().getCv()==1)
			diag.add(new SelectItem("1068", this.bundle.getString("proc_1068")));
		if(this.lf.getAccmods().getMesa()!=null && this.lf.getAccmods().getMesa()==1)
			diag.add(new SelectItem("1066", this.bundle.getString("proc_1066")));
		if(this.lf.getAccmods().getHolter()!=null && this.lf.getAccmods().getHolter()==1)
			diag.add(new SelectItem("1089", this.bundle.getString("proc_1089")));
		if(this.lf.getAccmods().getElr()!=null && this.lf.getAccmods().getElr()==1)
			diag.add(new SelectItem("1091", this.bundle.getString("proc_1091")));
		if(this.lf.getAccmods().getTest()!=null && this.lf.getAccmods().getTest()==1){
			diag.add(new SelectItem("1063", this.bundle.getString("proc_1063")));
			diag.add(new SelectItem("1064", this.bundle.getString("proc_1064")));
			diag.add(new SelectItem("1065", this.bundle.getString("proc_1065")));
		}
		diag.add(new SelectItem("1", this.bundle.getString("proc_1")));	
		return diag;
	}

	public int getHUECO_REGEVEXT() {
		return HUECO_REGEVEXT;
	}

	public void setHUECO_REGEVEXT(int hUECO_REGEVEXT) {
		HUECO_REGEVEXT = hUECO_REGEVEXT;
	}

	public int getHUECO_SEG_CLIN() {
		return HUECO_SEG_CLIN;
	}

	public void setHUECO_SEG_CLIN(int hUECO_SEG_CLIN) {
		HUECO_SEG_CLIN = hUECO_SEG_CLIN;
	}

}

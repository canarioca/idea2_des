package com.sorin.idea.iu;

import hvn.cm.modelo.Mensaje;

import java.util.ArrayList;
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
import com.sorin.idea.dao.SintomasSitclinProcDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Complicacion;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.SegClinComplicaciones;
import com.sorin.idea.dto.SegSeguimientoClinicoPk;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SintomasSitclinProcPk;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.SituacionClinicaProcPk;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.exceptions.SituacionClinicaGeneralDaoException;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.SintomasSitclinProcDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilMapeos;

public class ControlRehabilitacion extends BaseIU{

	private static Logger logger = Logger.getLogger(ControlRehabilitacion.class);
	private LoginForm lf;
	private String usuario;
	
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private ControlPacientes cp;
	private ControlMaestras cm;
	
	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ProcedimientoDao procdao;
	
	private SituacionClinicaProc stclin;
	private SituacionClinicaProcDao stclindao;
	private SintomasSitclinProcDao sintdao;
	
	private SituacionClinicaGeneral sgen;
	private SituacionClinicaGeneralDao sgendao;
	
	private HtmlDataTable bindingSintomas;
	
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
	
	private boolean modsitclin;
	
	private String columna = "fecha";
	private boolean ascendente = false;
	
	/*************************/
	private EpisodioDao epdao;
	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	private EventoDao evdao;
	
	private boolean editable;
	
	private ControlComplicaciones cc;
	private ComplicacionesPacientes compac;
	private ComplicacionesPacientes currentItemComp;
	private HtmlDataTable bindingComplicaciones;
	private ArrayList<ComplicacionesPacientes> listacompl;
	
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
			
			this.cc = (ControlComplicaciones) getBean("controlComplicaciones");
			if(this.cc == null)
				this.cc = new ControlComplicaciones();
			this.cc.inicia(null); // importante
			
			this.proc = new Procedimiento();
			this.proc.setFecha(new Date());
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.procpk = new ProcedimientoPk();
			
			this.stclin = new SituacionClinicaProc();
			this.stclindao = new SituacionClinicaProcDaoImpl(this.usuario);
			this.sintdao = new SintomasSitclinProcDaoImpl(this.usuario);
			this.sgendao = new SituacionClinicaGeneralDaoImpl(this.usuario);
			
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			
			this.cargaMaestras();
			this.cargaSituacionClinica();
			
		} catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_pat")+": " + e1.getMessage());
		}
	}
	
	public void cargaMaestras() {
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
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
				if(ev!=null && ev.getProcedimiento()==1094 && ev.getEstado()==1 && proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));
				
			}
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_epi")+": "+ e1.getMessage());
		}
	}
	
	public void guarda(ActionEvent e){
		// TODO
	}
	
	private void guardaComponentesSitClin() throws Exception {
		sintdao.delete(new SintomasSitclinProcPk(this.stclin.getIdsitclin(), null));
		for (SintomasSitclinProc sint : this.stclin.getSintomas()) {
			if (sint.getIdsintomas() != null && sint.getIdsintomas().length() > 0) {
				sint.setIdsitclin(this.stclin.getIdsitclin());
				sintdao.insert(sint);
			}
		}
		//this.stclin.setFecha(); // TODO
	}
	
	public void eliminar(ActionEvent e){
		try{
			int auxproc = this.proc.getIdprocedimiento();
			// Delete oncascade - procedimiento -> situacion clinica
			this.sintdao.delete(new SintomasSitclinProcPk(this.stclin.getIdsitclin(), null));
			this.stclindao.delete(new SituacionClinicaProcPk(this.stclin.getIdsitclin()));
			//this.segdao.delete(new SegSeguimientoClinicoPk(this.seg.getIdsegclin()));
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
	
	public void imprimeInforme(ActionEvent e){
		//TODO
	}
	
	public void cargaRehabCard(ActionEvent e) throws Exception {
		// TODO
	}
	public void cargaRehabCardDesdeBarraTemporal(ActionEvent e) throws Exception{
		try {
			// TODO
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	
	public void cargaRehabCardConsulta(ActionEvent e) throws Exception{
		try {
			// TODO
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
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
			this.stclin.setRevascularizacion(this.stclin.getRevasc()!= null && this.stclin.getRevasc()==1?true:false);
			// 2.5 Cardiopatia Infarto Previo
			this.stclin.setInfartoprev(this.stclin.getInfprevio()!=null && this.stclin.getInfprevio()== 1?true:false);
			// 2.6 Antecedentes - Arritmias Ventriculares
			this.stclin.setAvent(this.stclin.getArritmias()!=null && this.stclin.getArritmias()>= 1?true:false);
			// 2.7 Antecedentes - EEF Previo
			this.stclin.setEefprev(this.stclin.getEef()!= null && this.stclin.getEef()>=1?true:false);
			// 2.8 Antecedentes booleanos
			cargaAntecedentes();	
			// 3. Recuperar complicaciones
			// TODO
			
			// 4. complicaciones pacientes
			cc.obtenerComplicacionesPacienteProc(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
			for(ComplicacionesPacientes cpac:cc.getListacompacproc())
				this.listacompl.add(cpac);
			// 5. inicializa complicaciones
			//this.compac.setFechaini(this.seg.getFecha()); // TODO
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_sitclin_rec")+": "+ e.getMessage());
			logger.error("("+this.usuario+") Error al obtener datos de procedimiento: " + e.getMessage(),e);
		}
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
				if(((this.sgen.getFevi()!=null)&&!(this.sgen.getFevi().equals(this.stclin.getFevi()))) 
						|| ((this.sgen.getFuncionventricular()!=null) &&!(this.sgen.getFuncionventricular().equals(this.stclin.getFuncionventricular())))){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFevi(this.stclin.getFevi());
					this.sgen.setFuncionventricular(this.stclin.getFuncionventricular());
				}
				if(this.sgen.getFevi()==null && this.stclin.getFevi()!=null){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFevi(this.stclin.getFevi());
				}
				if(this.sgen.getFuncionventricular()==null && this.stclin.getFuncionventricular()!=null){
					this.sgen.setFechamodfevi(this.proc.getFecha());// Actualizacion de fecha de modificacion de fv		
					this.sgen.setFuncionventricular(this.stclin.getFuncionventricular());
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
		this.stclin.setAnteflutter(this.stclin.getFlutter()!=null 
				&& this.stclin.getFlutter()==1?true:false);
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
			this.modsitclin = true;
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_warn_sitclin_fe")+": " + e1.getMessage());
			this.stclin.setFevi(null);
		}	
	}
	
	public void resetFEVI(ActionEvent e){
		this.modsitclin = true;
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
	
	/***************************************
	 *************** GET / SET ************* 
	 ***************************************/
	
	public ArrayList<SelectItem> getSintomas() {
		ArrayList<SelectItem> sintomas = new ArrayList<SelectItem>();
		sintomas.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras procedimiento : this.sintomas)
			sintomas.add(new SelectItem(procedimiento.getValor(), procedimiento.getValor()));
		return sintomas;
	}
	
	public ArrayList<SelectItem> getRitmos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.ritmos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getRitmostv() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.ritmostv)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getRitmosfa() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.ritmosfa)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getRitmossa() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.ritmossa)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getConducciones() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.conducciones)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getConduccionavotros() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.conduccionavotros)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getQrs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.qrs)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getQrsotros() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", this.bundle.getString("no_especificado").toUpperCase()));
		for (ArrMaestras diagnostico : this.qrsotros)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getCardiopatia() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("00", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras cardio : this.cardiopatia)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio.getValor()));
		return cp;
	}
	
	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public SituacionClinicaProc getStclin() {
		return stclin;
	}

	public void setStclin(SituacionClinicaProc stclin) {
		this.stclin = stclin;
	}

	public SituacionClinicaGeneral getSgen() {
		return sgen;
	}

	public void setSgen(SituacionClinicaGeneral sgen) {
		this.sgen = sgen;
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

	public ComplicacionesPacientes getCurrentItemComp() {
		return currentItemComp;
	}

	public void setCurrentItemComp(ComplicacionesPacientes currentItemComp) {
		this.currentItemComp = currentItemComp;
	}

	public HtmlDataTable getBindingComplicaciones() {
		return bindingComplicaciones;
	}

	public void setBindingComplicaciones(
			HtmlDataTable bindingComplicaciones) {
		this.bindingComplicaciones = bindingComplicaciones;
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

	public HtmlDataTable getBindingSintomas() {
		return bindingSintomas;
	}

	public void setBindingSintomas(HtmlDataTable bindingSintomas) {
		this.bindingSintomas = bindingSintomas;
	}

	public ArrayList<ComplicacionesPacientes> getListacompl() {
		return listacompl;
	}

	public void setListacompl(ArrayList<ComplicacionesPacientes> listacompl) {
		this.listacompl = listacompl;
	}
}

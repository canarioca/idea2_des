package com.sorin.idea.iu;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageStringIterator;

import com.sorin.idea.dao.ArrPacienteHcardioDao;
import com.sorin.idea.dao.ArrPacienteHclinDao;
import com.sorin.idea.dao.ArrPacientesDao;
import com.sorin.idea.dao.ElectrodosDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dao.ImpEvolucionDao;
import com.sorin.idea.dao.ImpGeneradorDao;
import com.sorin.idea.dao.ImpHojaImplanteDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.ImpImplanteElectrodosDao;
import com.sorin.idea.dao.IntElectrodosDao;
import com.sorin.idea.dao.IntImplantesDao;
import com.sorin.idea.dao.IntPacientesDao;
import com.sorin.idea.dao.IntPendientesDao;
import com.sorin.idea.dao.IntegracionesInformesDao;
import com.sorin.idea.dao.IntegradorRegistrosDao;
import com.sorin.idea.dao.PacienteDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dto.ArrPacienteHcardio;
import com.sorin.idea.dto.ArrPacienteHclin;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.ArrPacientesPk;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpEvolucionPk;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplantePk;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpImplantePk;
import com.sorin.idea.dto.IntElectrodos;
import com.sorin.idea.dto.IntElectrodosPk;
import com.sorin.idea.dto.IntImplantes;
import com.sorin.idea.dto.IntImplantesPk;
import com.sorin.idea.dto.IntPacientes;
import com.sorin.idea.dto.IntPacientesPk;
import com.sorin.idea.dto.IntPendientes;
import com.sorin.idea.dto.IntPendientesPk;
import com.sorin.idea.dto.IntegracionesInformes;
import com.sorin.idea.dto.IntegracionesInformesPk;
import com.sorin.idea.dto.IntegradorRegistros;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.SituacionClinicaProcPk;
import com.sorin.idea.integracion.programadores.LogicaIntegracionProgramadores;
import com.sorin.idea.jdbc.ArrPacienteHcardioDaoImpl;
import com.sorin.idea.jdbc.ArrPacienteHclinDaoImpl;
import com.sorin.idea.jdbc.ArrPacientesDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpEvolucionDaoImpl;
import com.sorin.idea.jdbc.ImpGeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteElectrodosDaoImpl;
import com.sorin.idea.jdbc.IntElectrodosDaoImpl;
import com.sorin.idea.jdbc.IntImplantesDaoImpl;
import com.sorin.idea.jdbc.IntPacientesDaoImpl;
import com.sorin.idea.jdbc.IntPendientesDaoImpl;
import com.sorin.idea.jdbc.IntegracionesInformesDaoImpl;
import com.sorin.idea.jdbc.IntegradorRegistrosDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.GestorHL7;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilFiles;

public class ControlIntegraciones extends BaseIU{

	private static Logger logger = Logger.getLogger(ControlIntegraciones.class);
	
	private LoginForm lf;
	private String usuario="";
	private SelectorIdioma si;
	private ResourceBundle bundle;
	
	private java.sql.Connection conn;
	
	private IntPendientesDao intpenddao;
	private IntPacientesDao intpatdao;
	private IntImplantesDao intimpdao;
	private IntElectrodosDao intelesdao;
	private GeneradorDao gendao;
	private ElectrodosDao elecdao;
	
	private IntPendientes currentItemGenerador;
	private IntElectrodos currentItemElectrodos;
	
	private IntPendientes intpend;
	private ArrayList<IntPendientes> pends;
	private Generador[] generadores;
	private Electrodos[] electrodos;
	
	private HtmlDataTable bindingElectrodos;
	private HtmlDataTable bindingIntegraciones;
	private HtmlDataTable bindingPacientesCoincidentes;
	private HtmlDataTable bindingGeneradoresCoincidentes;
	private HtmlDataTable bindingElectrodosCoincidentes;
	
	private Integer pagina_inicial = 1;
	private Integer pagina_inicial_gen = 1;
	private Integer pagina_inicial_elec = 1;
	private Integer pagina_inicial_logs = 1;
	private Integer pagina_inicial_regint = 1;
	
	private ArrPacientesDao patdao;
	private SituacionClinicaGeneralDao sitclindao;
	private ArrPacienteHcardioDao hcardiodao;
	private ArrPacienteHclinDao hclindao;
	
	private ProcedimientoDao procdao;
	private SituacionClinicaProcDao sitclinprocdao;
	private ImpImplanteDao impimpdao;
	private ImpHojaImplanteDao himpdao;
	private ImpEvolucionDao hevdao;
	private ImpGeneradorDao impgendao;
	private ImpImplanteElectrodosDao impelecdao;
	
	private IntegracionesInformesDao logdao;
	private IntegracionesInformes[] logs;
	private IntegracionesInformes filtro;
	private ArrayList<IntegracionesInformes> listalogs;
	private HtmlDataTable bindingLogs;
	
	private IntegradorRegistrosDao regintdao;
	private IntegradorRegistros[] regints;
	private IntegradorRegistros regfiltro;
	private ArrayList<IntegradorRegistros> listaregs;
	private HtmlDataTable bindingRegInt;
	
	public void inicia(ActionEvent e){
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
		
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			
			this.intpenddao = new IntPendientesDaoImpl(this.conn,this.usuario);
			this.intpatdao = new IntPacientesDaoImpl(this.conn,this.usuario);
			this.intimpdao = new IntImplantesDaoImpl(this.conn,this.usuario);
			this.intelesdao = new IntElectrodosDaoImpl(this.conn,this.usuario);
			this.gendao = new GeneradorDaoImpl(this.conn,this.usuario);
			this.elecdao = new ElectrodosDaoImpl(this.conn,this.usuario);
			this.patdao = new ArrPacientesDaoImpl(this.conn,this.usuario);
			this.currentItemGenerador = new IntPendientes();
			this.currentItemElectrodos = new IntElectrodos();
			
			this.sitclindao = new SituacionClinicaGeneralDaoImpl(this.conn,this.usuario);
			this.hcardiodao = new ArrPacienteHcardioDaoImpl(this.conn,this.usuario);
			this.hclindao = new ArrPacienteHclinDaoImpl(this.conn,this.usuario);
			
			this.procdao = new ProcedimientoDaoImpl(this.conn,this.usuario);
			this.impimpdao = new ImpImplanteDaoImpl(this.conn,this.usuario);
			this.sitclinprocdao = new SituacionClinicaProcDaoImpl(this.conn,this.usuario);
			this.himpdao = new ImpHojaImplanteDaoImpl(this.conn,this.usuario);
			this.hevdao = new ImpEvolucionDaoImpl(this.conn,this.usuario);
			this.impgendao = new ImpGeneradorDaoImpl(this.conn,this.usuario);
			this.impelecdao = new ImpImplanteElectrodosDaoImpl(this.conn,this.usuario);
			
			this.intpend = new IntPendientes();
			this.pends = new ArrayList<IntPendientes>();
			
			// Carga la solicitudes pendientes al iniciar 
			this.consultaIntegraciones(null);
			this.cargaGeneradores();
			this.cargaElectrodos();
			
			this.logdao = new IntegracionesInformesDaoImpl(this.usuario);
			this.listalogs = new ArrayList<IntegracionesInformes>();
			this.filtro = new IntegracionesInformes();
			this.filtro.setFechaini(new Date());
			this.filtro.setFechafin(UtilFechas.addDate(new Date(), 1));
			this.cargaLogs();
			
			this.regintdao = new IntegradorRegistrosDaoImpl();
			this.listaregs = new ArrayList<IntegradorRegistros>();
			this.regfiltro = new IntegradorRegistros();
			this.regfiltro.setFechaini(new Date());
			this.regfiltro.setFechafin(UtilFechas.addDate(new Date(), 1));
			this.cargaRegistrosIntegrador();
			
		} catch (Exception e1) {
			logger.info("Error iniciando managed bean ControlIntegraciones. Motivo: "+e1.getMessage(),e1);
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_mod")+": "+ e1.getMessage());
		}
	}
	
	/*public void descarga(ActionEvent e){
		try{
			//String path = this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getOruPath();
			String path = "C:/SORIN_IDEA/INTEGRACION/ORU/Archive.rar";
			
			File f = new File(path);
			
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance()
					.getExternalContext().getRequest();
			HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance()
					.getExternalContext().getResponse();
			String sesionID = req.getRequestedSessionId();
			
			ServletOutputStream servletOutputStream = response
					.getOutputStream();
			
			byte[] descarga = UtilFiles.read(f);
			
			response.setContentType("application/x-rar-compressed");
			response.setContentLength(descarga.length);
			response.setHeader("Content-Transfer-Enconding", "binary");
			response.setHeader("Content-disposition", "inline; filename=\""
					+ f.getName() + "\"");

			servletOutputStream.write(descarga);

			// esta sentencia es extremadamente importante de cara a conseguir
			// que se pueda abrir el
			// archivo
			FacesContext.getCurrentInstance().responseComplete();
			
		}catch(Exception e1){
			this.pintaMensaje(ERROR, "No se puede descargar el fichero. Motivo: "+e1.getMessage());
			
			
		}
	}*/
	/**
	 * Carga registros de actividad de integración de IDEA con la fecha actual
	 */
	public void cargaLogs(){
		try{
			//this.logs = this.logdao.findAll();	
			this.logs = this.logdao.findByDynamicWhere("FECHARX >=? AND FECHARX<=?", new Object[]{new Date(),UtilFechas.addDate(new Date(), 1)});		
			for(IntegracionesInformes item:this.logs){
				if(item.getModelo()==null)
					item.setModelo(this.bundle.getString("no_especificado"));
				if(item.getNserie()==null)
					item.setNserie(this.bundle.getString("no_especificado"));
				if(item.getNombreAps()==null)
					item.setNombreAps(this.bundle.getString("no_especificado"));
				if(item.getEstado()==-1)
					item.setError(item.getError()+(item.getNombrefichero()!=null?"\n"+this.bundle.getString("nomnre_fichero")+":"+item.getNombrefichero():""));
				this.listalogs.add(item);
			}			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("integra_reg_error_rec_datos")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar logs de integración de sistema", e1);
		}
	}
	/**
	 * Carga registros de actividad de INTEGRADOR hacia IDEA con la fecha actual
	 */
	public void cargaRegistrosIntegrador(){
		try{
			//this.regints = this.regintdao.findAll();
			this.regints = this.regintdao.findByDynamicWhere("FECHAHORARX >=? AND FECHAHORARX<=?", new Object[]{new Date(),UtilFechas.addDate(new Date(), 1)});
			for(IntegradorRegistros item:this.regints){
				if(item.getModelo()==null)
					item.setModelo(this.bundle.getString("no_especificado"));
				if(item.getNserie()==null)
					item.setNserie(this.bundle.getString("no_especificado"));
				if(item.getNombrefichero()==null)
					item.setNombrefichero(this.bundle.getString("no_especificado"));
				this.listaregs.add(item);
			}			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("integra_reg_error_rec_datos")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar logs de actividad de integrador de subsistema de integración de seguimientos", e1);
		}
	}
	
	public void consultarLogs(ActionEvent e){
		this.listalogs.clear();
		try{
			if(this.filtro.getFechaini()==null && this.filtro.getFechafin()==null 
					&& (this.filtro.getIdsistema()==null || this.filtro.getIdsistema().equals(0))
					&& (this.filtro.getEstado() == null ||  this.filtro.getEstado().equals(2)))
				cargaLogs();
			else{// Busqueda por parametros
				String wheresql = "";
				int contador = 0;
				Object[] params = new Object[5];
				if(this.filtro.getFechaini()!=null){
					wheresql = wheresql + " FECHARX >= ? AND";
					params[contador] = this.filtro.getFechaini();
					contador++;
				}		
				if(this.filtro.getFechafin()!=null){
					wheresql = wheresql + " FECHARX <= ? AND";
					params[contador] = this.filtro.getFechafin();
					contador++;
				}					
				if(this.filtro.getIdsistema()!=null && !this.filtro.getIdsistema().equals(0)){
					wheresql = wheresql + " IDSISTEMA=? AND";
					params[contador] = Integer.valueOf(this.filtro.getIdsistema());
					contador++;
				}					
				if(this.filtro.getEstado()!=null && !this.filtro.getEstado().equals(2)){
					wheresql = wheresql + " ESTADO=? AND";
					params[contador] = Integer.valueOf(this.filtro.getEstado());
					contador++;
				}
				// OPTIMIZAR
				Object[] obj = new Object[contador];
				for(int i=0;i<contador;i++)
					obj[i] = params[i];				
				//Quitar el ultimo AND para formatear adecuadamente el WHERE
				wheresql = wheresql.substring(0,wheresql.length()-3);
				this.logs = this.logdao.findByDynamicWhere(wheresql,obj);
				for(IntegracionesInformes item:this.logs){
					if(item.getModelo()==null)
						item.setModelo(this.bundle.getString("no_especificado"));
					if(item.getNserie()==null)
						item.setNserie(this.bundle.getString("no_especificado"));
					if(item.getNombreAps()==null)
						item.setNombreAps(this.bundle.getString("no_especificado"));
					if(item.getEstado()==-1)
						item.setError(item.getError()+(item.getNombrefichero()!=null?"\n"+this.bundle.getString("nomnre_fichero")+":"+item.getNombrefichero():""));
					this.listalogs.add(item);
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("integra_reg_error_rec_datos")+": "+ e1.getMessage());
		}
	}
	
	public void consultarRegistrosIntegracion(ActionEvent e){
		this.listaregs.clear();
		try{
			if(this.regfiltro.getFechaini()==null && this.regfiltro.getFechafin()==null 
					&& (this.regfiltro.getSistema()==null || this.regfiltro.getSistema().equals(0))
					&& (this.regfiltro.getEstado() == null ||  this.regfiltro.getEstado().equals(2)))
				cargaLogs();
			else{// Busqueda por parametros
				String wheresql = "";
				int contador = 0;
				Object[] params = new Object[5];
				if(this.regfiltro.getFechaini()!=null){
					wheresql = wheresql + " FECHAHORARX >= ? AND";
					params[contador] = this.filtro.getFechaini();
					contador++;
				}		
				if(this.regfiltro.getFechafin()!=null){
					wheresql = wheresql + " FECHAHORARX <= ? AND";
					params[contador] = this.filtro.getFechafin();
					contador++;
				}					
				if(this.regfiltro.getSistema()!=null && !this.regfiltro.getSistema().equals(0)){
					wheresql = wheresql + " SISTEMA=? AND";
					params[contador] = Integer.valueOf(this.regfiltro.getSistema());
					contador++;
				}					
				if(this.regfiltro.getEstado()!=null && !this.regfiltro.getEstado().equals(2)){
					wheresql = wheresql + " ESTADO=? AND";
					params[contador] = Integer.valueOf(this.regfiltro.getEstado());
					contador++;
				}
				// OPTIMIZAR
				Object[] obj = new Object[contador];
				for(int i=0;i<contador;i++)
					obj[i] = params[i];				
				//Quitar el ultimo AND para formatear adecuadamente el WHERE
				wheresql = wheresql.substring(0,wheresql.length()-3);
				this.regints = this.regintdao.findByDynamicWhere(wheresql,obj);
				for(IntegradorRegistros item:this.regints){
					if(item.getModelo()==null)
						item.setModelo(this.bundle.getString("no_especificado"));
					if(item.getNserie()==null)
						item.setNserie(this.bundle.getString("no_especificado"));
					if(item.getEstado()==-1)
						item.setError(item.getError()+(item.getNombrefichero()!=null?"\n"+this.bundle.getString("nomnre_fichero")+":"+item.getNombrefichero():""));
					this.listaregs.add(item);
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("integra_reg_error_rec_datos")+": "+ e1.getMessage());
		}
	}
	
	public void limpiarLogs(ActionEvent e){
		this.logs = null;
		this.listalogs.clear();
		this.filtro = new IntegracionesInformes();
	}
	
	public void limpiarRegistrosIntegrador(ActionEvent e){
		this.regints = null;
		this.listaregs.clear();
		this.regfiltro = new IntegradorRegistros();
	}
	
	public void guardar(ActionEvent e){
		try{
			if(validarIntegracion() ){
				
				//this.conn = ResourceManager.getConnection();
				//this.conn.setAutoCommit(false);
				// 1. Verificar si existe paciente seleccionado.
				PacienteAplDto candidato = this.obtenerPacienteSeleccionado(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat());
				
				ArrPacientes paciente = null;
				Integer codigo_pat=null;
				if(candidato==null){// 1.2 Si no existe, mapeamos a tipo paciente e insertamos.
					paciente = new ArrPacientes();
					paciente.setNhc(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat().getNhc());
					paciente.setNombre(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat().getNombre().toUpperCase());
					paciente.setApellid1(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat().getApellidos().toUpperCase());
					paciente.setApellid2(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat().getApellido2().toUpperCase());
					paciente.setSexo(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat().getSexo());
					paciente.setFechanaci(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat().getFechanacimiento());
					paciente.setAVoid(0);
					codigo_pat = guardarPaciente(paciente);
				}else{// 1.1 Si existe, no insertamos paciente. Obtenemos el codigo de paciente seleccionado de la lista
					codigo_pat = this.obtenerPacienteSeleccionado(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat()).getCodigo();
				}			
				// 2. Mapeo de sistema a Procedimiento de implante -> Verificar si es primoimplante, intervención previa o recambio/upgrade
				ImpHojaImplante himp = new ImpHojaImplante();
				ImpHojaImplantePk himpk = this.himpdao.insert(himp);
				
				ImpGenerador impgen = new ImpGenerador();
				impgen.setIdhojaimp(himpk.getIdhojaimp());
				impgen.setIdgenerador(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getIdgensel());
				impgen.setNumserie(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getNumserieg());
				impgen.setLocalizacion(0);
				this.impgendao.insert(impgen);
				
				ImpEvolucion hev = new ImpEvolucion();
				ImpEvolucionPk hevpk = this.hevdao.insert(hev);
				
				for(IntElectrodos el:this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls()){
					ImpImplanteElectrodos elec = new ImpImplanteElectrodos();
					elec.setIdhojaimp(himpk.getIdhojaimp());
					elec.setIdevolucion(hevpk.getIdev());
					elec.setNumserie(el.getNserie());
					elec.setIdelectrodo(el.getIdelecsel());
					elec.setCaracter(0);
					elec.setCamara(el.getCamara());
					elec.setFechaimplante(el.getFechaimplante());
					this.impelecdao.insert(elec);
				}				
				
				ImpImplante impl = new ImpImplante();
				impl.setFechaimplante(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getFechaimplante());
				impl.setIdhojaimp(himpk.getIdhojaimp());
				impl.setIdev(hevpk.getIdev());
				ImpImplantePk impimpk = this.impimpdao.insert(impl);
				
				SituacionClinicaProc scp = new SituacionClinicaProc();
				SituacionClinicaProcPk scpk = this.sitclinprocdao.insert(scp);
				
				Procedimiento proc = new Procedimiento();
				proc.setFecha(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getFechaimplante());
				proc.setCodigo(codigo_pat);
				proc.setIdsitclinica(scpk.getIdsitclin());
				proc.setIdprocedimiento(impimpk.getIdimplante());
				proc.setIntegrado(0);
				// REVISAR
				proc.setTipoprocedimiento(956);// PRIMO / INTERV. PREVIA/RECAMBIO/UPGRADE?
				this.procdao.insert(proc); 
				// a. Recuperacion de log de solicitud de integracion
				IntegracionesInformes[] sols = this.logdao.findWhereIdintegracionEquals(this.pends.get(this.bindingIntegraciones.getRowIndex()).getIdintegracion());
				IntegracionesInformes sol = null;
				if(sols!=null && sols.length>0)
					sol = sols[0];
				
				// 3. Insercion de ORU.
				// 3.1 Recuperacion de mensaje almacenado en servidor
				File f_oru = new File(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getOruPath());
				if(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getOruPath()!=null && f_oru.exists()){
					String oru = UtilFiles.file2String(f_oru);
					if(oru!=null && !oru.equals("")){
						ORU_R01 oruMsg = GestorHL7.obtenerORU(oru);
						int res = LogicaIntegracionProgramadores.creaNuevoSeguimiento(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getNumserieg()
								, codigo_pat
								, oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll()
								, UtilFechas.dateHL7StringToDateString(oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr7_ObservationDateTime().getTime().getValue())
								, oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr4_UniversalServiceIdentifier().getCe1_Identifier().getValue().equals("REMOTO")?true:false);
						if(res==1){
							// insercion con exito
							// 4. Actualizar estado de registro de integracion a integrado
							this.pends.get(this.bindingIntegraciones.getRowIndex()).setEstado(1);
							this.pends.get(this.bindingIntegraciones.getRowIndex()).setFechamod(new Date());
							this.intpenddao.update(new IntPendientesPk(this.pends.get(this.bindingIntegraciones.getRowIndex()).getIdintegracion()), this.pends.get(this.bindingIntegraciones.getRowIndex()));
							//this.conn.commit();
							this.pends.remove(this.bindingIntegraciones.getRowIndex());// actualizar lista
							this.pintaMensaje(INFO, this.bundle.getString("integra_reg_info_guarda_solicitud"));
							logger.info("("+this.usuario+") Solicitud de integración insertada con éxito en el sistema");
							// 5. Actualizar estado de log de solicitud. Se pone a integrado con exito
							sol.setEstado(1);
							this.logdao.update(new IntegracionesInformesPk(sol.getIdintegraciones()), sol);
							this.pintaMensaje(INFO, this.bundle.getString("info_msg_editar_info"));
							logger.info("("+this.usuario+") Log de integración actualizado con éxito en el sistema");
						}else{
							logger.error("Error en almacenamiento de ORU en tabla Seguimiento.");
							this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_error_guarda_solicitud_1"));
							// 5. Actualizar estado de log de solicitud.
							sol.setEstado(-1);
							sol.setError(this.bundle.getString("integra_reg_error_e1"));
							this.logdao.update(new IntegracionesInformesPk(sol.getIdintegraciones()), sol);
							this.pintaMensaje(INFO, this.bundle.getString("info_msg_editar_info"));
							logger.info("("+this.usuario+") Log de integración actualizado con éxito en el sistema");
						}						
					}else{
						logger.error("No se ha encontrado ORU asociado en sistema de almacenamiento de servidor. No se integrará el seguimiento asociado.");
						this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_error_guarda_solicitud"));
						// 5. Actualizar estado de log de solicitud.
						sol.setEstado(-1);
						sol.setError(this.bundle.getString("integra_reg_error_e2"));
						this.logdao.update(new IntegracionesInformesPk(sol.getIdintegraciones()), sol);
						this.pintaMensaje(INFO, this.bundle.getString("info_msg_editar_info"));
						logger.info("("+this.usuario+") Log de integración actualizado con éxito en el sistema");
					}	
				}else{
					logger.error("No se ha encontrado ORU asociado en sistema de almacenamiento de servidor. No se integrará el seguimiento asociado.");
					this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_error_guarda_solicitud"));
					// 5. Actualizar estado de log de solicitud.
					sol.setEstado(-1);
					sol.setError(this.bundle.getString("integra_reg_error_e2"));
					this.logdao.update(new IntegracionesInformesPk(sol.getIdintegraciones()), sol);
					this.pintaMensaje(INFO, this.bundle.getString("info_msg_editar_info"));
					logger.info("("+this.usuario+") Log de integración actualizado con éxito en el sistema");
				}						
			}else
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("integra_reg_warn_guarda_solicitud"));
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("integra_reg_error_guarda_solicitud_2")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede guardar solicitud de integracion", e1);
		}finally {
		   /* if (this.conn != null) {
		        try {
					this.conn.close();
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
		    }*/
		}
	}
	
	private Integer guardarPaciente(ArrPacientes pat){
		try{
			ArrPacientesPk patpk = this.patdao.insert(pat);
			SituacionClinicaGeneral sc = new SituacionClinicaGeneral();
			sc.setFechacreacion(new Date());
			sc.setIdpaciente(patpk.getCodigo());
			this.sitclindao.insert(sc);
			ArrPacienteHcardio hc = new ArrPacienteHcardio();
			hc.setIdpaciente(patpk.getCodigo());
			this.hcardiodao.insert(hc);
			ArrPacienteHclin hclin = new ArrPacienteHclin();
			hclin.setIdpaciente(patpk.getCodigo());
			this.hclindao.insert(hclin);
			return patpk!=null?patpk.getCodigo():null;
		}catch(Exception e){
			logger.error("Error guardando solicitud paciente. Motivo: "+e.getMessage(), e);
			return null;
		}
	}
	
	public void consultaIntegraciones(ActionEvent e){
		try{
			this.pends.clear();
			IntPendientes[] ps = this.intpenddao.findWhereEstadoEquals(0);// solo las pendientes
			for(IntPendientes p:ps){
				IntPacientes pat = this.intpatdao.findByPrimaryKey(p.getIdintegracion()); 
				this.obtenerPacientesCoincidentes(pat);
				p.setPat(pat);
				IntImplantes imp = this.intimpdao.findByPrimaryKey(p.getIdintegracion());
				this.obtenerGeneradoresCoincidentes(imp);
				p.setImp(imp);
				IntElectrodos[] els = this.intelesdao.findWhereIdintegracionEquals(p.getIdintegracion());
				for(IntElectrodos el:els){
					this.obtenerElectrodosCoincidentes(el);
					el.setModelo(el.getModelo().substring(0,el.getModelo().length()-1));// se quita el ultimo elemento (iterador i) para no confundir el modelo
					el.setNserie(el.getNserie().substring(0,el.getNserie().length()-1));// se quita el ultimo elemento (iterador i) para no confundir el numero de serie
					p.getEls().add(el);
				}					
				this.pends.add(p);
			}		
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("integra_reg_error_ver_solicitud")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se pueden cargar solicitudes de integracion", e1);
		}
	}
	
	public void obtenerPacientesCoincidentes(IntPacientes filtro){
		try{
			PacienteDao patdao = new PacienteDao();
			filtro.setCoinc(patdao.getPacientesByNombreApellidos(filtro));
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("integra_reg_error_e4")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede encontrar pacientes coincidentes", e1);
		}
	}
	
	public PacienteAplDto obtenerPacienteSeleccionado(IntPacientes filtro){
		for(PacienteAplDto p:filtro.getCoinc()){
			if(p.isSeleccion())
				return p;
		}
		return null;
	}
	
	public Generador obtenerGeneradorSeleccionado(IntImplantes filtro){
		for(Generador p:filtro.getGencoinc()){
			if(p.isSeleccion())
				return p;
		}
		return null;
	}
	
	public Electrodos obtenerElectrodoSeleccionado(IntElectrodos filtro){
		for(Electrodos p:filtro.getElecs()){
			if(p.isSeleccion())
				return p;
		}
		return null;
	}
	
	public void obtenerGeneradoresCoincidentes(IntImplantes filtro){
		try{
			Generador[] coinc = this.gendao.findByDynamicWhere(
							"MODELO LIKE '"+filtro.getModelog().substring(0,filtro.getModelog().length()-5)+"%' AND FABRICANTE = ?",
							new Object[] {filtro.getFabricanteg()});
			if(coinc!=null && coinc.length>0){
				for(Generador g:coinc)
					filtro.getGencoinc().add(g);
			}			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("integra_reg_error_e5")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede encontrar generadores coincidentes", e1);
		}
	}
	
	public void obtenerElectrodosCoincidentes(IntElectrodos filtro){
		try{
			Electrodos[] coinc = this.elecdao.findByDynamicWhere(
							"MODELO LIKE '"+filtro.getModelo().substring(0,3)+"%' AND FABRICANTE = ?",
							new Object[] {filtro.getFabricante()!=null?filtro.getFabricante():""});
			if(coinc!=null && coinc.length>0){
				for(Electrodos e:coinc)
					filtro.getElecs().add(e);
			}			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("integra_reg_error_e6")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede encontrar generadores coincidentes", e1);
		}
	}
	
	public void eliminar(ActionEvent e){
		try{	
			// Obtencion de log de integracion
			// a. Recuperacion de log de solicitud de integracion
			IntegracionesInformes[] sols = this.logdao.findWhereIdintegracionEquals(this.pends.get(this.bindingIntegraciones.getRowIndex()).getIdintegracion());
			IntegracionesInformes sol = null;
			if(sols!=null && sols.length>0){
				sol = sols[0];
				// 5. Actualizar estado de log de solicitud. 
				sol.setEstado(-7);// BORRADA DEL SISTEMA
				this.logdao.update(new IntegracionesInformesPk(sol.getIdintegraciones()), sol);
				this.pintaMensaje(INFO, this.bundle.getString("info_msg_editar_info"));
				logger.info("("+this.usuario+") Log de integración actualizado con éxito en el sistema");
			}
			// Se elimina el ORU en local:
			File f_delete = new File(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getOruPath());
			if(f_delete.exists())
				f_delete.delete();
			this.intimpdao.delete(new IntImplantesPk(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getIdintegracion()));
			this.intpatdao.delete(new IntPacientesPk(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat().getIdintegracion()));
			for(IntElectrodos el:this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls())
				this.intelesdao.delete(new IntElectrodosPk(el.getIdintegracion(),el.getModelo(),el.getNserie()));
			this.intpenddao.delete(new IntPendientesPk(this.pends.get(this.bindingIntegraciones.getRowIndex()).getIdintegracion()));
			this.pends.remove(this.bindingIntegraciones.getRowIndex());
			this.pintaMensaje(INFO, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro de solicitud de integración eliminado con éxito del sistema");
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_borrado_error_exep")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede eliminar registro. Motivo: "+e1.getMessage(), e1);
		}
	}
	
	
	private boolean validarIntegracion(){
		return (validaDemograficos(this.pends.get(this.bindingIntegraciones.getRowIndex()).getPat()) 
				&& validaSistemaGenerador(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp()) 
				&& validaFechas(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp())
				&& validaSistemaElectrodos(this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls()));
	}
	private boolean validaDemograficos(IntPacientes pat){
		//1. Verificar si hay pacientes coincidentes y varios marcados
		if(pat.getCoinc().size()>0){
			int i = 0;
			for(PacienteAplDto p:pat.getCoinc()){
				if(p.isSeleccion())
					i++;
				if(i>1){
					this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_pacientes"));
					return false;
				}
			}
			if(i==1)
				return true;// Se asume el paciente seleccionado. Este tiene el resto de campos validados
		}
		if(pat.getNombre()==null || pat.getNombre().equals("")){
			this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_pacientes_nombre"));
			return false;
		}
		if(pat.getApellidos()==null || pat.getApellidos().equals("")){
			this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_pacientes_ap1"));
			return false;
		}
		if(pat.getNhc()==null || pat.getNhc().equals("")){
			this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_pacientes_nhc"));
			return false;
		}else{
			try{
				ArrPacientes[] p = this.patdao.findWhereNhcEquals(pat.getNhc());
				if(p!=null && p.length>0){
					this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_pacientes_nhc_espe"));
					return false;
				}
			}catch(Exception e){
				e.fillInStackTrace();
				return false;
			}
		}
		
		return true;
	}
	private boolean validaSistemaGenerador(IntImplantes imp){
		int i = 0;
		if(imp.getGencoinc().size()>0){			
			for(Generador p:imp.getGencoinc()){
				if(p.isSeleccion())
					i++;
				if(i>1){
					this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_gen_dupl"));
					return false;
				}
			}
		}	
		if(imp.getIdgensel()==null || imp.getIdgensel()==0){
			this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_gen_nosel"));
			return false;
		}
		
		if(imp.getNumserieg()==null || imp.getNumserieg().equals("")){
			this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_gen_numserie"));
			return false;
		}
		if(imp.getFechaimplante()==null){
			this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_gen_fimp"));
			return false;
		}
		//if(UtilFechas.dateDiff( date2))	
		return true;
	}
	private boolean validaSistemaElectrodos(ArrayList<IntElectrodos> els){
		for(IntElectrodos e:els){
			int i = 0;
			if(e.getElecs().size()>0){				
				for(Electrodos p:e.getElecs()){
					if(p.isSeleccion())
						i++;
					if(i>1){
						this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_ele_dupl"));
						return false;
					}					
				}
			}
			if(e.getIdelecsel()==null || e.getIdelecsel()==0){
				this.pintaMensaje(AVISO, this.bundle.getString("integra_reg_warn_add_ele_nosel"));
				e.setIdelecsel(193); // Electrodo desconocido
				//return false;
			}
			if(e.getNserie()==null || e.getNserie().equals("")){
				this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_ele_numserie"));
				return false;
			}
		}
		return true;
	}
	
	private boolean validaFechas(IntImplantes imp){		
		if(UtilFechas.dateDiff(imp.getFechaseg(), imp.getFechaimplante())>=0)
			return true;
		else
			this.pintaMensaje(ERROR, this.bundle.getString("integra_reg_warn_add_fechas"));
		return false;
		/*try{
			File f_oru = new File(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getOruPath());
			if(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getOruPath()!=null
					&& f_oru.exists()){
				String oru = UtilFiles.file2String(f_oru);
				if(oru!=null && !oru.equals("")){
					ORU_R01 oruMsg = GestorHL7.obtenerORU(oru);
					String fechaseg = oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr7_ObservationDateTime().getTime().getValue();	
					Date fseg = UtilFechas.StringToDateFormato(fechaseg,"yyyyMMdd");
					if(UtilFechas.dateDiff(fseg, imp.getFechaimplante())>=0)
						return true;
					else
						this.pintaMensaje(ERROR, "Error en validación de registro. La fecha de implante no puede ser mayor que la fecha de seguimiento.");
				}else{
					logger.error("Error en almacenamiento de ORU en tabla Seguimiento.");
					this.pintaMensaje(ERROR, "Error en inserción de registro de seguimiento.");
				}						
			}else{
				logger.error("No se ha encontrado ORU asociado en sistema de almacenamiento de servidor. No se integrará el seguimiento asociado.");
				this.pintaMensaje(ERROR, "No se ha encontrado ORU asociado en sistema de almacenamiento de servidor. No se integrará el seguimiento asociado.");
			}	
		}catch(Exception e){
			logger.error("No se ha encontrado ORU asociado en sistema de almacenamiento de servidor. No se integrará el seguimiento asociado.", e);
			this.pintaMensaje(ERROR, "No se ha encontrado ORU asociado en sistema de almacenamiento de servidor. No se integrará el seguimiento asociado.");			
		}
		return false;*/
	}
	
	public void mostrarGeneradores(ActionEvent e){
		if(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().isMostrargen())
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().setMostrargen(false);
		else
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().setMostrargen(true);
	}
	public void mostrarElectrodos(ActionEvent e){
		if(this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).isMostrarelec())
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).setMostrarelec(false);
		else
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).setMostrarelec(true);		
	}
	
	public void cambiaModeloGenSel(ActionEvent e){
		try{
			int gen=0;
			gen = this.gendao.findWhereModeloEquals(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getModelogensel())[0].getIdgenerador();
			if(gen>0)
				this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().setIdgensel(gen);			
		}catch(Exception e1){
			e1.printStackTrace();
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().setModelogensel(null);
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().setIdgensel(0);
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("integra_reg_warn_gen_modelo_valido"));
		}
	}
	
	public void cambiaModeloElecSel(ActionEvent e){
		try{
			int elec=0;
			elec = this.elecdao.findWhereModeloEquals(this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).getModeloelecsel())[0].getIdelectrodo();
			if(elec>0)
				this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).setIdelecsel(elec);
		}catch(Exception e1){
			e1.printStackTrace();
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).setModeloelecsel(null);
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).setIdelecsel(0);
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("integra_reg_warn_ele_modelo_valido"));
		}
	}
	
	public void cargaGeneradores() {
		try {
			this.gendao = new GeneradorDaoImpl(this.usuario);
			this.generadores = this.gendao.findAll();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}
	public void cargaElectrodos() {
		try {
			this.elecdao = new ElectrodosDaoImpl(this.usuario);
			this.electrodos = this.elecdao.findAll();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}
	
	public void cambiaSeleccionGen(ActionEvent e){
		if(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().isSeleccion()){
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().setSeleccion(false);
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().setIdgensel(null);
		}else{
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().setSeleccion(true);
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().setIdgensel(this.pends.get(this.bindingIntegraciones.getRowIndex()).getImp().getGencoinc().get(this.bindingGeneradoresCoincidentes.getRowIndex()).getIdgenerador());
		}		
	}
	
	public void cambiaSeleccionElec(ActionEvent e){
		if(this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).isSeleccion()){
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).setSeleccion(false);
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).setIdelecsel(null);
		}else{
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).setSeleccion(false);
			this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).setIdelecsel(this.pends.get(this.bindingIntegraciones.getRowIndex()).getEls().get(this.bindingElectrodos.getRowIndex()).getElecs().get(this.bindingElectrodosCoincidentes.getRowIndex()).getIdelectrodo());
		}		
	}
	
	public ArrayList<SelectItem> getGeneradores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("", "(Seleccione modelo)"));
		for (Generador ref : this.generadores)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}
	public ArrayList<SelectItem> getElectrodos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("", "(Seleccione modelo)"));
		for (com.sorin.idea.dto.Electrodos ref : this.electrodos)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}
	
	public IntPendientes getIntpend() {
		return intpend;
	}
	public void setIntpend(IntPendientes intpend) {
		this.intpend = intpend;
	}

	public HtmlDataTable getBindingElectrodos() {
		return bindingElectrodos;
	}

	public void setBindingElectrodos(HtmlDataTable bindingElectrodos) {
		this.bindingElectrodos = bindingElectrodos;
	}

	public HtmlDataTable getBindingIntegraciones() {
		return bindingIntegraciones;
	}

	public void setBindingIntegraciones(HtmlDataTable bindingIntegraciones) {
		this.bindingIntegraciones = bindingIntegraciones;
	}

	public ArrayList<IntPendientes> getPends() {
		return pends;
	}

	public void setPends(ArrayList<IntPendientes> pends) {
		this.pends = pends;
	}

	public HtmlDataTable getBindingPacientesCoincidentes() {
		return bindingPacientesCoincidentes;
	}

	public void setBindingPacientesCoincidentes(
			HtmlDataTable bindingPacientesCoincidentes) {
		this.bindingPacientesCoincidentes = bindingPacientesCoincidentes;
	}

	public Integer getPagina_inicial() {
		return pagina_inicial;
	}

	public void setPagina_inicial(Integer pagina_inicial) {
		this.pagina_inicial = pagina_inicial;
	}

	public Integer getPagina_inicial_gen() {
		return pagina_inicial_gen;
	}

	public void setPagina_inicial_gen(Integer pagina_inicial_gen) {
		this.pagina_inicial_gen = pagina_inicial_gen;
	}

	public IntPendientes getCurrentItemGenerador() {
		return currentItemGenerador;
	}

	public void setCurrentItemGenerador(IntPendientes currentItemGenerador) {
		this.currentItemGenerador = currentItemGenerador;
	}

	public IntElectrodos getCurrentItemElectrodos() {
		return currentItemElectrodos;
	}

	public void setCurrentItemElectrodos(IntElectrodos currentItemElectrodos) {
		this.currentItemElectrodos = currentItemElectrodos;
	}

	public HtmlDataTable getBindingGeneradoresCoincidentes() {
		return bindingGeneradoresCoincidentes;
	}

	public void setBindingGeneradoresCoincidentes(
			HtmlDataTable bindingGeneradoresCoincidentes) {
		this.bindingGeneradoresCoincidentes = bindingGeneradoresCoincidentes;
	}

	public HtmlDataTable getBindingElectrodosCoincidentes() {
		return bindingElectrodosCoincidentes;
	}

	public void setBindingElectrodosCoincidentes(
			HtmlDataTable bindingElectrodosCoincidentes) {
		this.bindingElectrodosCoincidentes = bindingElectrodosCoincidentes;
	}

	public Integer getPagina_inicial_elec() {
		return pagina_inicial_elec;
	}

	public void setPagina_inicial_elec(Integer pagina_inicial_elec) {
		this.pagina_inicial_elec = pagina_inicial_elec;
	}

	public HtmlDataTable getBindingLogs() {
		return bindingLogs;
	}

	public void setBindingLogs(HtmlDataTable bindingLogs) {
		this.bindingLogs = bindingLogs;
	}

	public IntegracionesInformes[] getLogs() {
		return logs;
	}

	public void setLogs(IntegracionesInformes[] logs) {
		this.logs = logs;
	}

	public Integer getPagina_inicial_logs() {
		return pagina_inicial_logs;
	}

	public void setPagina_inicial_logs(Integer pagina_inicial_logs) {
		this.pagina_inicial_logs = pagina_inicial_logs;
	}

	public ArrayList<IntegracionesInformes> getListalogs() {
		return listalogs;
	}

	public void setListalogs(ArrayList<IntegracionesInformes> listalogs) {
		this.listalogs = listalogs;
	}

	public IntegracionesInformes getFiltro() {
		return filtro;
	}

	public void setFiltro(IntegracionesInformes filtro) {
		this.filtro = filtro;
	}

	public IntegradorRegistros getRegfiltro() {
		return regfiltro;
	}

	public void setRegfiltro(IntegradorRegistros regfiltro) {
		this.regfiltro = regfiltro;
	}

	public ArrayList<IntegradorRegistros> getListaregs() {
		return listaregs;
	}

	public void setListaregs(ArrayList<IntegradorRegistros> listaregs) {
		this.listaregs = listaregs;
	}

	public HtmlDataTable getBindingRegInt() {
		return bindingRegInt;
	}

	public void setBindingRegInt(HtmlDataTable bindingRegInt) {
		this.bindingRegInt = bindingRegInt;
	}

	public Integer getPagina_inicial_regint() {
		return pagina_inicial_regint;
	}

	public void setPagina_inicial_regint(Integer pagina_inicial_regint) {
		this.pagina_inicial_regint = pagina_inicial_regint;
	}
}
package com.sorin.idea.iu;

import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.sorin.idea.dao.ArrAccesoDao;
import com.sorin.idea.dao.ArrAccesoModulosDao;
import com.sorin.idea.dao.ArrAccesoPrivDao;
import com.sorin.idea.dao.IntPendientesDao;
import com.sorin.idea.dto.ArrAcceso;
import com.sorin.idea.dto.ArrAccesoModulos;
import com.sorin.idea.dto.ArrAccesoPk;
import com.sorin.idea.dto.ArrAccesoPriv;
import com.sorin.idea.dto.IntPendientes;
import com.sorin.idea.jdbc.ArrAccesoDaoImpl;
import com.sorin.idea.jdbc.ArrAccesoModulosDaoImpl;
import com.sorin.idea.jdbc.ArrAccesoPrivDaoImpl;
import com.sorin.idea.jdbc.IntPendientesDaoImpl;
import com.sorin.idea.util.GestorClaves;
import com.sorin.idea.util.UtilFechas;

import hvn.cm.modelo.Mensaje;


public class LoginForm extends BaseIU {
	private static final long serialVersionUID = 1L;
	public Integer ADMINISTRADOR = 1;
	public Integer USUARIO = 2;
	private ArrAcceso sesionUsuario = new ArrAcceso();
	public String navegacion = "irInicio";
	private String idSesionInicial = "";
	public boolean accesoLogin = false;
	private String hora;
	private String opcion = "1";
	private ArrAcceso acceso;
	private ArrAccesoModulos[] accmods;
	private String login;
	private String pass;
	
	private Integer nodo;
	private Object[] nodos;
	/****************/
	private static Logger logger = Logger.getLogger(LoginForm.class);
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private int CADUCIDAD;
	private int INTENTOS;
	private int LONGITUD;
	private Properties prop;
	private boolean cambiopass;
	private String pass2;
	private String nuevapass;
	private String confnuevapass;
	private IntPendientes[] pend;
	/****************/
	public LoginForm() {
		super();
		sesionUsuario = new ArrAcceso();
		// logica de inicio de log de eventos
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource("log4j.properties");
		PropertyConfigurator.configure(url);
		//PropertyConfigurator.configure("log4j.properties");
		//ControlAplicacion controlAplicacion;
		try {
			/*ContextoFaces ctxf = new ContextoFaces((ContextoWeb) getContexto()
					.getContextoBase());
			controlAplicacion = (ControlAplicacion) ctxf
					.getBean("controlAplicacion");
			if (controlAplicacion == null) {
				controlAplicacion = new ControlAplicacion();
				setBean("controlAplicacion", controlAplicacion);
			}*/
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			lecturaProperties();
			this.login = "";
			this.pass = "";
			ArrayList<Boolean> nodosal = new ArrayList<Boolean>();
			nodosal.add(false);
			nodosal.add(false);
			nodosal.add(false);
			nodosal.add(false);
			nodosal.add(false);
			nodosal.add(false);
			nodosal.add(false);
			nodosal.add(false);
			this.nodos = nodosal.toArray();
		} catch (Exception ex) {
			//controlAplicacion = new ControlAplicacion();
		}
	}

	public String acnAutenticarUsuario() {
		boolean check = false;
		try {
			/*this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);*/
			ArrAccesoDao oncoaccesodao = new ArrAccesoDaoImpl("login");
			//this.acceso = oncoaccesodao.findByPrimaryUsuarioPass(this.login, this.pass);
			//this.acceso = oncoaccesodao.findByPrimaryUsuarioPass(this.login, GestorClaves.getStringMessageDigest(this.pass,GestorClaves.SHA1));
			this.acceso = oncoaccesodao.findByPrimaryKey(this.login);
			if(acceso != null && acceso.getUsuario() != null && acceso.getUsuario().length() > 0){
				// 0. Comprobacion de cuenta activa
				if(this.acceso.getActivo().equals(0)){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
							this.bundle.getString("login_msg_error_1"));
					logger.error("Error accediendo a la aplicación. Motivo: Usuario -"+this.login+"- Cuenta no activa en el sistema.");	
					this.accesoLogin = false;
				}
				// 1. Comprobacion contraseña
				else if(!this.acceso.getPass().equals(GestorClaves.getStringMessageDigest(this.pass,GestorClaves.SHA1))){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
							this.bundle.getString("login_msg_error_2"));
					logger.error("Error accediendo a la aplicación. Motivo: Usuario -"+this.login+"- contraseña errónea. Intentos restantes: "+String.valueOf(this.acceso.getContador()-1)+".");
					if(this.acceso.getContador()>0)
						this.acceso.setContador(this.acceso.getContador()-1);
					else
						this.acceso.setContador(0);
					oncoaccesodao.update(new ArrAccesoPk(this.acceso.getUsuario()), this.acceso);
					this.accesoLogin = false;
				}
				// 2. Comprobacion de revocacion
				else if(!validarCaducidad(this.acceso)){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
							this.bundle.getString("login_msg_error_3"));
					logger.error("Error accediendo a la aplicación. Motivo: Usuario -"+this.login+"- contraseña expirada.");
					this.accesoLogin = false;
				}
				// 3. comprobacion intentos
				else if(!validarIntentos(this.acceso)){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
							this.bundle.getString("login_msg_error_4"));
					logger.error("Error accediendo a la aplicación. Motivo: Usuario -"+this.login+"- máximo número de intentos realizados.");
					this.accesoLogin = false;
				}else	
					this.accesoLogin = true;
			}else{
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("login_msg_error_5"));
				logger.error("Error accediendo a la aplicación, motivo: Usuario -"+this.login+"- no tiene permisos para acceder a la aplicación");
				this.accesoLogin = false;
			}
				
			
			/*check = AutenticaUsuarioHVN.isUsuarioHVN(login,pass);
			
			AutenticaUsuarioHVN au = new AutenticaUsuarioHVN();

			if (!check) {
				this.accesoLogin = false;
				this
						.nuevoMensaje(
								this.getFormulario().getId(),
								Mensaje.SEVERIDAD_ERROR,
								"Error accediendo a la aplicación, motivo: Usuario/Contraseña no válido",
								"Error accediendo a la aplicación, motivo; Usuario/Contraseña no válido");
			}

			else { // El usuario tiene credenciales en DA
				sesionUsuario = gestorAcceso.iniAplicacionUsuario(this.login, this.pass,
						((HttpServletRequest) FacesContext.getCurrentInstance()
								.getExternalContext().getRequest())
								.getRemoteAddr(),
						((HttpServletRequest) FacesContext.getCurrentInstance()
								.getExternalContext().getRequest())
								.getRequestedSessionId());
*/
				if (accesoLogin) {
					// Actualizacion de fecha de ultimo acceso
					this.acceso.setFechaultacc(new Date());
					oncoaccesodao.update(new ArrAccesoPk(this.acceso.getUsuario()), this.acceso);
					// Obtencion de dias restantes para revocacion de clave
					this.acceso.setDiasrev((int)UtilFechas.dateDiff(this.acceso.getFecharev(), new Date()));
					// Obtencion de privilegios de usuario
					ArrAccesoModulosDao accmoddao = new ArrAccesoModulosDaoImpl();
					this.accmods = accmoddao.findWhereUsuarioEquals(this.acceso.getUsuario() );
					ArrAccesoPrivDao accprivdao = new ArrAccesoPrivDaoImpl();
					ArrAccesoPriv priv = accprivdao.findByPrimaryKey(this.acceso.getIdrolacceso());
					this.acceso.setPrivs(priv);
					// Comprobar integraicones pendientes
					IntPendientesDao intpenddao = new IntPendientesDaoImpl();
					this.pend = intpenddao.findWhereEstadoEquals(0);
					
					
					sesionUsuario.setUsuario(this.login);
					this.setIdSesionInicial(this.getsesionCliente());
					ControlPacientes cp = (ControlPacientes) getBean("controlPacientes");
					if (cp == null)
						cp = new ControlPacientes();
					cp.inicia();
					setBean("controlPacientes", cp);
					
					ControlEef ceef = (ControlEef) getBean("controlEef");
					if (ceef == null)
						ceef = new ControlEef();
					ceef.cargaMaestras(null);
					setBean("controlEef", ceef);
					
					ControlSeguimientos cseg = (ControlSeguimientos) getBean("controlSeguimientos");
					if(cseg == null)
						cseg = new ControlSeguimientos();				
					setBean("controlSeguimientos",cseg);
					
					ControlIntegraciones cint = (ControlIntegraciones) getBean("controlIntegraciones");
					if(cint==null)
						cint = new ControlIntegraciones();
					setBean("controlIntegraciones",cint);
					
					ControlMedicacion cmed = (ControlMedicacion) getBean("controlMedicacion");
					if(cmed==null)
						cmed = new ControlMedicacion();
					setBean("controlMedicacion",cmed);
					
					logger.info("Usuario "+this.getLogin()+" logado en el sistema");
					
					return "irConsultaPacientes";
				} else {
					
					return "recarga";
				}
			//}
		} catch (Exception ex) {
			this.accesoLogin = false;
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("login_msg_error") + ex.getMessage());
			return "recarga";
		}
		//return "recarga";
	}

	public String acnCerrarSesion() {
		cerrarSesion();

		return "irIndex";
	}

	private void matarSesion() {
		HttpSession httpSession = (HttpSession) FacesContext
				.getCurrentInstance().getExternalContext().getSession(true);
		httpSession.invalidate();
	}

	/**
	 * Anula la sesion actual de forma que sea necesario autenticarse
	 */
	public void cerrarSesion() {
		// Invalidamos la autenticacion
		try {
			matarSesion();
			logAviso("Autenticacion SESION CERRADA");
			logger.info("("+this.login+") Sesión finalizada");
		} catch (Exception ex) {

		}
	}

	/**
	 * Anula la sesion actual de forma que sea necesario autenticarse
	 */
	public void cerrarSesion(ActionEvent e) {
		// Invalidamos la autenticacion
		try {
			matarSesion();

			logAviso("Autenticacion SESION CERRADA");
		} catch (Exception ex) {

		}
	}

	public String acnLimpiarCampos() {
		sesionUsuario = new ArrAcceso();
		this.login = "";
		this.pass = "";
		return "recarga";
	}

	public void cambiarClaveUsuario(ActionEvent e){
		try{
			lecturaProperties();
			ArrAccesoDao accdao = new ArrAccesoDaoImpl(this.login);
			int val = GestorClaves.validadorClave(this.getNuevapass(), this.LONGITUD);
			if(!this.acceso.getPass().equals(GestorClaves.getStringMessageDigest(this.getPass2(),GestorClaves.SHA1))){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("login_pass_err_1"));
				this.limpiarCampos(null);
			}else if(!this.getNuevapass().equals(this.getConfnuevapass())){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("login_pass_err_2"));
				this.limpiarCampos(null);
			}else if(val==-1){
				this.pintaMensaje(ERROR, this.bundle.getString("login_pass_err_3"));
				this.limpiarCampos(null);
			}else if(val ==-2){
				this.pintaMensaje(ERROR, this.bundle.getString("login_pass_err_4")+" " +this.LONGITUD+" "+this.bundle.getString("login_pass_err_4_1"));
				this.limpiarCampos(null);
			}else if(this.acceso.getPass().equals(GestorClaves.getStringMessageDigest(this.getPass2(),GestorClaves.SHA1))
					&&this.getNuevapass().equals(this.getConfnuevapass())){
				this.acceso.setPass(GestorClaves.getStringMessageDigest(this.getConfnuevapass(),GestorClaves.SHA1));
				this.acceso.setContador(this.INTENTOS);
				this.acceso.setFecharev(UtilFechas.sumarRestarDiasFecha(new Date(), this.CADUCIDAD));
				this.acceso.setDiasrev((int)UtilFechas.dateDiff(this.acceso.getFecharev(), new Date()));
				accdao.update(new ArrAccesoPk(this.acceso.getUsuario()), this.acceso);
				this.limpiarCampos(null);
				this.pintaMensaje(INFO, this.bundle.getString("login_pass_msg"));
				logger.info("("+this.login+") Ha cambiado su contraseña. Se ha reiniciado el número de intentos y la fecha de revocación.");
			}else{
				this.pintaMensaje(ERROR, this.bundle.getString("login_pass_err_5"));
				this.limpiarCampos(null);
			}	
			//this.setCambiopass(false);
		}catch(Exception e1){
			logger.info("("+this.login+") Error en cambio de contraseña. Motivo: "+e1.getMessage());
			this.pintaMensaje(ERROR, this.bundle.getString("login_pass_err_5")+this.bundle.getString("motivo")+": "+e1.getMessage());
			this.limpiarCampos(null);
			//this.setCambiopass(false);
		}
	}
	public void cambiaClave(ActionEvent e){
		if(this.isCambiopass())
			this.setCambiopass(false);
		else
			this.setCambiopass(true);
	}
	public void limpiarCampos(ActionEvent e){
		this.setPass2(null);
		this.setNuevapass(null);
		this.setConfnuevapass(null);
	}
	
	public String getsesionCliente() {
		return ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getRequestedSessionId();
	}

	public ArrAcceso getSesionUsuario() {
		return sesionUsuario;
	}

	public void setSesionUsuario(ArrAcceso usuario) {
		this.sesionUsuario = usuario;
	}

	public String getNavegacion() {
		return navegacion;
	}

	public void setNavegacion(String navegacion) {
		this.navegacion = navegacion;
	}

	public String getIdSesionInicial() {
		return idSesionInicial;
	}

	public void setIdSesionInicial(String idSesionInicial) {
		this.idSesionInicial = idSesionInicial;
	}

	public boolean isAccesoLogin() {
		return accesoLogin;
	}

	public void setAccesoLogin(boolean accesoLogin) {
		this.accesoLogin = accesoLogin;
	}

	public String getHora() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return sdf.format(cal.getTime());
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public ArrAcceso getAcceso() {
		return acceso;
	}

	public void setAcceso(ArrAcceso acceso) {
		this.acceso = acceso;
	}

	public Integer getAdministrador() {
		return ADMINISTRADOR;
	}

	public Integer getUsuario() {
		return USUARIO;
	}

	public Integer getNodo() {
		return nodo;
	}

	public void setNodo(Integer nodo) {
		this.nodo = nodo;
	}

	public void expande(ActionEvent e){
		if(nodo != null)
			this.nodos[nodo] = true;
		nodo = null;
	}
	
	public void colapsa(ActionEvent e){
		if(nodo != null)
			this.nodos[nodo] = false;
		nodo = null;
	}

	public Object[] getNodos() {
		return nodos;
	}

	public String getFinSesion(){
		try{
			ExternalContext ctx = FacesContext.getCurrentInstance().getExternalContext();
			if(ctx != null && ctx.getSession(false) != null)
				((HttpSession) ctx.getSession(false)).invalidate();
		}catch (Exception e) {}
		return "";
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public ArrAccesoModulos[] getAccmods() {
		return accmods;
	}

	public void setAccmods(ArrAccesoModulos[] accmods) {
		this.accmods = accmods;
	}

	public boolean validarCaducidad(ArrAcceso user){
		//System.out.println(UtilFechas.dateDiff(user.getFecharev(), new Date()));
		return UtilFechas.dateDiff(user.getFecharev(), new Date())<0?false:true;
	}
	/*
	 * Si el numero de intentos es <=0 --> Denegar entrada
	 */
	public boolean validarIntentos(ArrAcceso user){
		return user.getContador()<=0?false:true;
	}
	
	public void lecturaProperties() {
		try {
			this.prop = new Properties();
			InputStream is = ControlAccesos.class.getResourceAsStream("users.properties");
			this.prop.load(is);
			this.CADUCIDAD = (Integer.parseInt(this.prop.getProperty("caducidad")));
			this.INTENTOS = (Integer.parseInt(this.prop.getProperty("intentos")));
			this.LONGITUD = (Integer.parseInt(this.prop.getProperty("longitud")));
			is.close();
		} catch (Exception e) {
			this.pintaMensaje(ERROR, "Error. No es posible inicializar fichero de propiedades. Motivo: "+e.getMessage());
		}	
	}
	
	public boolean isCambiopass() {
		return cambiopass;
	}

	public void setCambiopass(boolean cambiopass) {
		this.cambiopass = cambiopass;
	}

	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getNuevapass() {
		return nuevapass;
	}

	public void setNuevapass(String nuevapass) {
		this.nuevapass = nuevapass;
	}

	public String getConfnuevapass() {
		return confnuevapass;
	}

	public void setConfnuevapass(String confnuevapass) {
		this.confnuevapass = confnuevapass;
	}

	public int getLONGITUD() {
		return LONGITUD;
	}

	public void setLONGITUD(int lONGITUD) {
		LONGITUD = lONGITUD;
	}

	public IntPendientes[] getPend() {
		return pend;
	}

	public void setPend(IntPendientes[] pend) {
		this.pend = pend;
	}

	
	
	
}

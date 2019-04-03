package com.sorin.idea.iu;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;

import com.sorin.idea.dao.ArrAccesoDao;
import com.sorin.idea.dao.ArrAccesoModulosDao;
import com.sorin.idea.dao.ArrAccesoPrivDao;
import com.sorin.idea.dao.UsuarioDao;
import com.sorin.idea.dto.ArrAcceso;
import com.sorin.idea.dto.ArrAccesoModulos;
import com.sorin.idea.dto.ArrAccesoModulosPk;
import com.sorin.idea.dto.ArrAccesoPk;
import com.sorin.idea.dto.ArrAccesoPriv;
import com.sorin.idea.dto.TipoProcedimiento;
import com.sorin.idea.exceptions.ArrAccesoDaoException;
import com.sorin.idea.jdbc.ArrAccesoDaoImpl;
import com.sorin.idea.jdbc.ArrAccesoModulosDaoImpl;
import com.sorin.idea.jdbc.ArrAccesoPrivDaoImpl;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.jdbc.TipoProcedimientoDaoImpl;
import com.sorin.idea.util.GestorClaves;
import com.sorin.idea.util.UtilFechas;

import hvn.apl.jProyecto2010.modelo.servicios.dto.SesionUsuarioDto;
import hvn.cm.dao.DAOException;
import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

public class ControlAccesos extends BaseIU {

	/**
	 * 
	 */
	private static Logger logger = Logger.getLogger(ControlAccesos.class);
	private static final long serialVersionUID = -2815005343083864824L;
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private String usuario;
	private ArrayList<SesionUsuarioDto> usuarios = new ArrayList<SesionUsuarioDto>();
	private HtmlDataTable iuTablaUsuarios = new HtmlDataTable();
	private ArrAccesoDao accesoDao;
	private ArrAccesoModulos accmod;
	private ArrAccesoModulosDao accmoddao;
	private boolean existe = false;
	private ArrAcceso acceso;

	private SesionUsuarioDto criterioBusqueda = new SesionUsuarioDto();
	
	/***********/
	private ArrAcceso criterio;
	private ArrayList<ArrAcceso> users;
	private HtmlDataTable bindingUsers;
	private Properties prop;
	private int LONGITUD_MINIMA;
	private int CADUCIDAD;
	private int INTENTOS;
	private boolean modpass;
	/***********/
	
	private Integer pagina_inicial = 1;
	
	private ArrAccesoPrivDao privdao;
	private ArrAccesoPriv[] privs;
	private HtmlDataTable bindingPrivs;

	public ControlAccesos() {
		try {
			// almacenamos los datos del usuario y del paciente seleccionado.
			LoginForm loginform;
			loginform = (LoginForm) getBean("loginForm");
			//this.conn = ResourceManager.getConnection();
			this.acceso = new ArrAcceso();
			this.accmod = new ArrAccesoModulos();
			this.usuario = loginform.getSesionUsuario().getUsuario();
			this.accesoDao = new ArrAccesoDaoImpl(this.usuario);
			this.accmoddao = new ArrAccesoModulosDaoImpl(this.usuario);
			this.users = new ArrayList<ArrAcceso>();
			this.criterio = new ArrAcceso();
			this.privdao = new ArrAccesoPrivDaoImpl(this.usuario);
			this.privs = this.privdao.findAll();
			lecturaProperties();
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("user_msg_err_1")+". "+ e.getMessage());
		}
	}

	public void guardarUsuario(ActionEvent event) {
		try {
			if (this.acceso.getUsuario() != null
					&& !this.acceso.getUsuario().equals("")
					&& this.acceso.getIdrolacceso() > 0) {
				//conn.setAutoCommit(false);
				ArrAcceso ex = accesoDao.findByPrimaryKey(this.acceso.getUsuario());
				if(ex!=null)
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("user_msg_guarda_1"));
				else{
					if(this.acceso.getPass() == null || this.acceso.getPass().length() == 0)
						this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("user_msg_guarda_2"));
					else{
						int val = GestorClaves.validadorClave(this.acceso.getPass(), this.LONGITUD_MINIMA);
						if(val==0){
							this.acceso.setNombre(this.acceso.getNombre().toUpperCase());
							this.acceso.setApellido1(this.acceso.getApellido1().toUpperCase());
							this.acceso.setApellido2(this.acceso.getApellido2().toUpperCase());
							this.acceso.setPass(GestorClaves.getStringMessageDigest(this.acceso.getPass(), GestorClaves.SHA1));
							// Establecimiento de vigencia de clave
							this.acceso.setFecharev(UtilFechas.sumarRestarDiasFecha(new Date(),this.CADUCIDAD));
							// Establecimiento de num. intentos
							this.acceso.setContador(this.INTENTOS);
							// Activando cuenta de usuario
							this.acceso.setActivo(1);
							this.accesoDao.insert(acceso);
							
							this.accmod.setUsuario(this.acceso.getUsuario());
							
							TipoProcedimientoDaoImpl tipoProcedimientoDaoImpl = new TipoProcedimientoDaoImpl();
							List<TipoProcedimiento> listaProcedimientos = Arrays.asList( tipoProcedimientoDaoImpl.findAll() );
							
							for( TipoProcedimiento tipoProcediimento : listaProcedimientos ) {
								this.accmod.setIdTipoProcedimiento( tipoProcediimento.getIdTipoProcedimiento() );
								this.accmoddao.insert(accmod);
							}
					
							this.pintaMensaje(INFO, this.bundle.getString("user_msg_guarda_3"));		
							logger.info("("+this.usuario+") Creación de nuevo usuario en el sistema. Usuario: "+this.acceso);
						}else if(val==-1)
							this.pintaMensaje(ERROR, this.bundle.getString("user_msg_guarda_4"));
						else if(val ==-2)
							this.pintaMensaje(ERROR, this.bundle.getString("user_msg_guarda_5")+" "+this.LONGITUD_MINIMA+" "+this.bundle.getString("user_msg_guarda_5_1"));
						
					}				
				}
				/*this.pintaMensaje(Mensaje.SEVERIDAD_INFO, "Usuario "
					+ this.acceso.getUsuario() + " guardado correctamente.");*/
				this.acceso = new ArrAcceso();
				this.existe = false;
				//conn.commit();
			} else {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("user_msg_guarda_6"));
			}
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("user_msg_guarda_7")+": "+ e.toString());
		}
	}

	/**
	 * Activa cuenta de usuario en el sistema
	 * @param event
	 */
	public void activaUsuario(ActionEvent event) {
		try {
			this.users.get(this.bindingUsers.getRowIndex()).setActivo(1);
			this.accesoDao.update(new ArrAccesoPk(this.users.get(this.bindingUsers.getRowIndex()).getUsuario()), this.users.get(this.bindingUsers.getRowIndex()));
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("user_msg_activa_1"));
			logger.info("Usuario: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+" reactivado en el sistema");
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("user_msg_activa_2")+": "+ e.toString());
			logger.error("Usuario: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+" no reactivado en el sistema. Motivo: "+e.getMessage(),e);
		}
	}

	/**
	 * Desactiva cuenta de usuario en el sistema
	 * @param event
	 */
	public void desactivaUsuario(ActionEvent event) {
		try {
			this.users.get(this.bindingUsers.getRowIndex()).setActivo(0);
			this.accesoDao.update(new ArrAccesoPk(this.users.get(this.bindingUsers.getRowIndex()).getUsuario()), this.users.get(this.bindingUsers.getRowIndex()));
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("user_msg_borra_1"));
			logger.info("Usuario: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+" desactivado del sistema");
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("user_msg_borra_2")+": "+ e.toString());
			logger.error("Usuario: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+" no desactivado del sistema. Motivo: "+e.getMessage(),e);
		}
	}

	/**
	 * Elimina cuenta de usuario en el sistema
	 * @param event
	 */
	public void eliminaUsuario(ActionEvent event) {
		try {
			this.accesoDao.delete(new ArrAccesoPk(this.users.get(this.bindingUsers.getRowIndex()).getUsuario()));
			this.accmoddao.delete(new ArrAccesoModulosPk(this.users.get(this.bindingUsers.getRowIndex()).getUsuario()));
			this.users.remove(this.bindingUsers.getRowIndex());
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("user_msg_borra_3"));
			logger.info("Usuario: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+" eliminado del sistema");
		} catch (Exception e) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("user_msg_borra_4")+": "+ e.getMessage());
			logger.error("Usuario: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+" no eliminado del sistema. Motivo: "+e.getMessage(),e);
		}
	}

	public void limpiaUsuario(ActionEvent event) {
		this.usuarios = new ArrayList<SesionUsuarioDto>();
		this.criterioBusqueda = new SesionUsuarioDto();
		this.acceso = new ArrAcceso();
		this.criterio = new ArrAcceso();
		this.users.clear();
	}

	public void buscaUsuarios(ActionEvent event) {
		this.acceso = new ArrAcceso();
		if (this.criterioBusqueda != null && this.criterioBusqueda.getLogin() != null
				&& !this.criterioBusqueda.getLogin().equals("")) {
			try {
				this.existe = false;
				this.acceso = this.accesoDao.findByPrimaryKey(this.criterioBusqueda.getLogin());
				if(this.acceso == null || this.acceso.getUsuario() == null){
					this.acceso = new ArrAcceso();
					this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("user_msg_busca_1"));
				}
				else
					this.existe = true;
			} catch (ArrAccesoDaoException e) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("user_msg_busca_2")+": " + e.getMessage());
			}
		}else{
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("user_msg_busca_3"));
		}
	}

	public void consultaUsuarios(ActionEvent event) {
		//this.acceso = new ArrAcceso();
		try{
			logger.info("("+this.usuario+") Consulta de usuarios del sistema.");
			this.users.clear();
			ArrAcceso[] lista = null;
			if(this.criterio == null || 
					((this.criterio.getUsuario() == null || this.criterio.getUsuario().equals(""))
					&& (this.criterio.getNombre()==null || this.criterio.getNombre().equals(""))
					&& (this.criterio.getApellido1()==null || this.criterio.getApellido1().equals(""))
					&& (this.criterio.getIdrolacceso()==null || this.criterio.getIdrolacceso().equals(0))
					&& (this.criterio.getActivo()==null || this.criterio.getActivo().equals(-1)))){
				lista = this.accesoDao.findAll();
			}else{
				String wheresql = "";
				int contador = 0;
				Object[] params = new Object[5];
				if(this.criterio.getUsuario()!=null && this.criterio.getUsuario().length()>0){
					wheresql = wheresql + " USUARIO LIKE ? AND";
					params[contador] = "%"+this.criterio.getUsuario()+"%";
					contador++;
				}
				if(this.criterio.getNombre()!=null && this.criterio.getNombre().length()>0){
					wheresql = wheresql + " NOMBRE LIKE ? AND";
					params[contador] = "%"+this.criterio.getNombre()+"%";
					contador++;
				}
				if(this.criterio.getApellido1()!=null && this.criterio.getApellido1().length()>0){
					wheresql = wheresql + " APELLIDO1 LIKE ? AND";
					params[contador] = "%"+this.criterio.getApellido1()+"%";
					contador++;
				}
				if(this.criterio.getIdrolacceso()!=null && this.criterio.getIdrolacceso()>0){
					wheresql = wheresql + " IDROLACCESO = ? AND";
					params[contador] = this.criterio.getIdrolacceso();
					contador++;
				}
				if(this.criterio.getActivo()!=null && this.criterio.getActivo()>=0){
					wheresql = wheresql + " ACTIVO = ? AND";
					params[contador] = this.criterio.getActivo();
					contador++;
				}
				Object[] obj = new Object[contador];
				for(int i=0;i<contador;i++)
					obj[i] = params[i];				
				//Quitar el ultimo AND para formatear adecuadamente el WHERE
				wheresql = wheresql.substring(0,wheresql.length()-3);
				lista = this.accesoDao.findByDynamicWhere(wheresql,obj);
			}
			if(lista.length>0)
				for(ArrAcceso us:lista)
					this.users.add(us);
			else
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_consulta"));
			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("user_msg_busca_2")+": " + e1.getMessage());
			logger.info("Error consultando usuarios del sistema. Motivo: "+e1.getMessage(),e1);
		}
	}
	public void modificarUsuario(ActionEvent e){
		try{
			// codificacion de clave
			boolean test = true;
			if(this.users.get(this.bindingUsers.getRowIndex()).getModpass()!=null
					&& !this.users.get(this.bindingUsers.getRowIndex()).getModpass().equals("")){
				int val = GestorClaves.validadorClave(this.users.get(this.bindingUsers.getRowIndex()).getModpass(), this.LONGITUD_MINIMA);
				if(val==0){
					this.users.get(this.bindingUsers.getRowIndex()).setPass(GestorClaves.getStringMessageDigest(this.users.get(this.bindingUsers.getRowIndex()).getModpass(),GestorClaves.SHA1));
					// actualizacion de parametros -intentos y revocacion
					this.users.get(this.bindingUsers.getRowIndex()).setContador(this.INTENTOS);
					this.users.get(this.bindingUsers.getRowIndex()).setFecharev(UtilFechas.sumarRestarDiasFecha(new Date(), this.CADUCIDAD));
					this.users.get(this.bindingUsers.getRowIndex()).setActivo(1);// Reactivacion de cuenta de usuario
					logger.info("("+this.usuario+") Modificando datos de cuenta de usuario del sistema: contraseña. Usuario: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+".");
				}else if(val==-1){
					this.pintaMensaje(ERROR, this.bundle.getString("user_msg_guarda_4"));
					test = false;
					logger.error("("+this.usuario+") Datos de cuenta de usuario del sistema: contraseña. Usuario: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+". Motivo: contiene caracteres no permitidos (sólo válidos caracteres ASCII)");
				}else if(val ==-2){
					this.pintaMensaje(ERROR, this.bundle.getString("user_msg_guarda_5")+" "+this.LONGITUD_MINIMA+" "+this.bundle.getString("user_msg_guarda_5_1"));
					test = false;
					logger.error("("+this.usuario+") Datos de cuenta de usuario del sistema: contraseña. Usuario: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+". Motivo: debe tener una longitud mínima de "+this.LONGITUD_MINIMA+" caracteres.");
				}
			}
			if(test){
				this.users.get(this.bindingUsers.getRowIndex()).setActivo(1);// Reactivacion de cuenta de usuario
				this.accesoDao.update(new ArrAccesoPk(this.users.get(this.bindingUsers.getRowIndex()).getUsuario()), this.users.get(this.bindingUsers.getRowIndex()));
				this.pintaMensaje(INFO, this.bundle.getString("user_msg_edit_1")+": "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+" "+this.bundle.getString("user_msg_edit_1_1"));
				logger.info("("+this.usuario+") Datos de cuenta de usuario del sistema modificados correctamente. Usuario modificado: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario());
			}
						
		}catch(Exception e1){
			logger.error("("+this.usuario+") Datos de cuenta de usuario del sistema. Usuario modificado: "+this.users.get(this.bindingUsers.getRowIndex()).getUsuario()+". Motivo: "+e1.getMessage());			
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("user_msg_edit_2")+": " + e1.getMessage());
		}
	}
	public void resetPassUsuario(ActionEvent e){
		if(this.isModpass())
			this.setModpass(false);
		else
			this.setModpass(true);
	}
	
	public void modificarPrivilegios(ActionEvent e){
		try{
			if(this.privs[this.bindingPrivs.getRowIndex()].getEdicion()!=null 
					&& this.privs[this.bindingPrivs.getRowIndex()].getEdicion().equals(2)){
				if(this.privs[this.bindingPrivs.getRowIndex()].getTiempoedicion()==null || this.privs[this.bindingPrivs.getRowIndex()].getTiempoedicion()<=0){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("user_msg_priv_1"));
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("user_msg_priv_2"));
					this.privs[this.bindingPrivs.getRowIndex()].setTiempoedicion(10);
				}		
			}
			if(this.privs[this.bindingPrivs.getRowIndex()].getTiempoedicion()!=null 
					&& this.privs[this.bindingPrivs.getRowIndex()].getEdicion().equals(1)){
				this.privs[this.bindingPrivs.getRowIndex()].setTiempoedicion(-1);
			}
			this.privdao.update(this.privs[this.bindingPrivs.getRowIndex()].createPk(), this.privs[this.bindingPrivs.getRowIndex()]);
			logger.info("("+this.usuario+") Privilegios modificados correctamente en el sistema");
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("user_msg_priv_3"));
		}catch(Exception e1){
			logger.error("("+this.usuario+") Privilegios de tipo de usuario de sistema. Motivo: "+e1.getMessage());			
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("user_msg_priv_4")+": " + e1.getMessage());
		}
	}
	
	public ArrayList<SesionUsuarioDto> getUsuarios() {
		return usuarios;
	}

	public void setIuTablaUsuarios(HtmlDataTable iuTablaUsuarios) {
		this.iuTablaUsuarios = iuTablaUsuarios;
	}

	public HtmlDataTable getIuTablaUsuarios() {
		return iuTablaUsuarios;
	}

	public void setCriterioBusqueda(SesionUsuarioDto criterioBusqueda) {
		this.criterioBusqueda = criterioBusqueda;
	}

	public SesionUsuarioDto getCriterioBusqueda() {
		return criterioBusqueda;
	}

	public boolean isExiste() {
		return existe;
	}

	public void setExiste(boolean existe) {
		this.existe = existe;
	}

	public ArrAcceso getAcceso() {
		return acceso;
	}

	public void setAcceso(ArrAcceso acceso) {
		this.acceso = acceso;
	}

	public ArrayList<ArrAcceso> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<ArrAcceso> users) {
		this.users = users;
	}

	public HtmlDataTable getBindingUsers() {
		return bindingUsers;
	}

	public void setBindingUsers(HtmlDataTable bindingUsers) {
		this.bindingUsers = bindingUsers;
	}

	public ArrAcceso getCriterio() {
		return criterio;
	}

	public void setCriterio(ArrAcceso criterio) {
		this.criterio = criterio;
	}
	public void lecturaProperties() {
		try {
			this.prop = new Properties();
			InputStream is = ControlAccesos.class.getResourceAsStream("users.properties");
			this.prop.load(is);
			this.LONGITUD_MINIMA = Integer.parseInt(this.prop.getProperty("longitud"));
			this.setCADUCIDAD(Integer.parseInt(this.prop.getProperty("caducidad")));
			this.setINTENTOS(Integer.parseInt(this.prop.getProperty("intentos")));
			is.close();
		} catch (Exception e) {
			this.pintaMensaje(ERROR, "Error. No es posible inicializar fichero de propiedades. Motivo: "+e.getMessage());
		}	
	}

	public int getCADUCIDAD() {
		return CADUCIDAD;
	}

	public void setCADUCIDAD(int cADUCIDAD) {
		CADUCIDAD = cADUCIDAD;
	}

	public int getINTENTOS() {
		return INTENTOS;
	}

	public void setINTENTOS(int iNTENTOS) {
		INTENTOS = iNTENTOS;
	}

	public int getLONGITUD_MINIMA() {
		return LONGITUD_MINIMA;
	}

	public void setLONGITUD_MINIMA(int lONGITUD_MINIMA) {
		LONGITUD_MINIMA = lONGITUD_MINIMA;
	}

	public boolean isModpass() {
		return modpass;
	}

	public void setModpass(boolean modpass) {
		this.modpass = modpass;
	}

	public Integer getPagina_inicial() {
		return pagina_inicial;
	}

	public void setPagina_inicial(Integer pagina_inicial) {
		this.pagina_inicial = pagina_inicial;
	}

	public ArrAccesoPriv[] getPrivs() {
		return privs;
	}

	public void setPrivs(ArrAccesoPriv[] privs) {
		this.privs = privs;
	}

	public HtmlDataTable getBindingPrivs() {
		return bindingPrivs;
	}

	public void setBindingPrivs(HtmlDataTable bindingPrivs) {
		this.bindingPrivs = bindingPrivs;
	}

}

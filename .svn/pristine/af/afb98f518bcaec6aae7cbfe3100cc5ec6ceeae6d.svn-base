package com.sorin.idea.iu;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.ResourceBundle;

import hvn.cm.modelo.Mensaje;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.sorin.idea.correo.GestorCorreo;
import com.sorin.idea.dao.CateterDao;
import com.sorin.idea.dao.Codigosgs128Dao;
import com.sorin.idea.dao.ElectrodosDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dao.GenvaloresfabricaDao;
import com.sorin.idea.dao.RegistradoreventosDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Cateter;
import com.sorin.idea.dto.CateterPk;
import com.sorin.idea.dto.Codigosgs128;
import com.sorin.idea.dto.Codigosgs128Pk;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.ElectrodosPk;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.GeneradorPk;
import com.sorin.idea.dto.Genvaloresfabrica;
import com.sorin.idea.dto.GenvaloresfabricaPk;
import com.sorin.idea.dto.Registradoreventos;
import com.sorin.idea.dto.RegistradoreventosPk;
import com.sorin.idea.exceptions.Codigosgs128DaoException;
import com.sorin.idea.jdbc.CateterDaoImpl;
import com.sorin.idea.jdbc.Codigosgs128DaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.GenvaloresfabricaDaoImpl;
import com.sorin.idea.jdbc.RegistradoreventosDaoImpl;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.notificacion.NotificacionMaterial;
import com.sorin.idea.util.ExportExcel;
import com.sorin.idea.util.InfoCentro;

public class ControlMaterial extends BaseIU{

	private static Logger logger = Logger.getLogger(ControlMaterial.class);
	//private java.sql.Connection conn;
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private LoginForm lf;
	private String usuario="";
	private ControlMaestras cm;
	private HtmlDataTable bindingGenerador;
	private HtmlDataTable bindingElectrodo;
	private HtmlDataTable bindingCateter;
	private HtmlDataTable bindingRegEventos;
	private HtmlDataTable bindingGeneradorGs128;
	private HtmlDataTable bindingElectrodoGs128;
	private HtmlDataTable bindingCateterGs128;
	private HtmlDataTable bindingRegEventosGs128;
	private GeneradorDao g;
	private Generador[] generadores;
	private ElectrodosDao e;
	private Electrodos[] electrodos;
	
	private Generador gen;
	private Generador nuevogen;
	private Electrodos el;
	private Electrodos nuevoel;
	
	private Cateter cat;
	private Cateter nuevocat;
	private Cateter[] cats;
	private CateterDao catdao;
	
	private Registradoreventos reg;
	private Registradoreventos nuevoreg;
	private Registradoreventos[] regs;
	private RegistradoreventosDao regdao;
	
	private Integer pagina_inicial = 1;
	private Integer pagina_inicial_elec = 1;
	private Integer pagina_inicial_cat = 1;
	private Integer pagina_inicial_reg = 1;
	private String columna = "apellido1";
	private boolean ascendente = true;
	
	private boolean rf;
	private boolean mri;
	
	private ArrMaestras[] fabgen;
	private ArrMaestras[] modogen;
	private ArrMaestras[] cadgen;
	private ArrMaestras[] cvdgen;
	private ArrMaestras[] cvigen;
	private ArrMaestras[] fabelec;
	private ArrMaestras[] polelec;
	private ArrMaestras[] conelec;
	private ArrMaestras[] fijaelec;
	private ArrMaestras[] bobelec;
	private ArrMaestras[] fabcat;
	private ArrMaestras[] tipoabl;
	private ArrMaestras[] tipocurvadiag;
	
	private Generador currentItemGenerador;
	private Generador currentItemGeneradorBackup;
	private Electrodos currentItemElectrodo;
	private Electrodos currentItemElectrodoBackup;
	private Cateter currentItemCateter;
	private Cateter currentItemCateterBackup;
	private Registradoreventos currentItemRegistrador;
	private Registradoreventos currentItemRegistradorBackup;
	
	private Codigosgs128Dao gs128dao;
	
	private String nombre_centro;
	
	private Integer totalgen;
	private Integer totalelec;
	private Integer totalcat;
	private Integer totalreg;
	
	private GenvaloresfabricaDao genfabdao;
	
	public void iniciaMaterial(ActionEvent e){
		try{
			//this.obtenerConexion();
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			this.g = new GeneradorDaoImpl(/*this.conn,*/this.usuario);
			this.e = new ElectrodosDaoImpl(/*this.conn,*/this.usuario);
			this.catdao = new CateterDaoImpl(/*this.conn,*/this.usuario);
			this.regdao = new RegistradoreventosDaoImpl(this.usuario);
			this.gs128dao = new Codigosgs128DaoImpl(this.usuario);
			this.genfabdao = new GenvaloresfabricaDaoImpl(this.usuario);
			this.generadores = null;
			this.electrodos = null;
			this.cats = null;
			this.regs = null;
			this.gen = new Generador();
			this.nuevogen = new Generador();
			this.el = new Electrodos();
			this.nuevoel = new Electrodos();
			this.cat = new Cateter();
			this.nuevocat = new Cateter();
			this.reg = new Registradoreventos();
			this.nuevoreg = new Registradoreventos();
			this.cargaMaestras();
			this.setCurrentItemGenerador(new Generador());
			this.setCurrentItemElectrodo(new Electrodos());
			this.setCurrentItemCateter(new Cateter());
			this.setCurrentItemRegistrador(new Registradoreventos());
			this.totalgen = 0;
			this.totalelec = 0;
			this.totalcat = 0;
			this.totalreg = 0;
			lecturaProperties();
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_mod")+": "+ e1.getMessage());
		}
	}
	public void cargaMaestras() {
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			this.fabgen = cm.getFabricanteGenerador();
			this.modogen = cm.getModoGenerador();
			this.cadgen = cm.getConectorADGenerador();
			this.cvdgen = cm.getConectorVDGenerador();
			this.cvigen = cm.getConectorVIGenerador();
			this.fabelec = cm.getFabricanteElectrodo();
			this.polelec = cm.getPolaridadElectrodo();
			this.conelec = cm.getConectorElectrodo();
			this.fijaelec = cm.getFijacionElectrodo();
			this.bobelec = cm.getBobinaElectrodo();
			this.fabcat = cm.getFabricanteCateter();
		} catch (Exception e1) {
			this.pintaMensaje(
					Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
	}
	public void addGenerador(ActionEvent e){
		logger.info("("+this.usuario+") Iniciando acción insertar generador");
		if(this.nuevogen.getGs128().length()<=0 || this.nuevogen.getModelo().length()<=0 
				|| this.nuevogen.getModo().length()<=0 || this.nuevogen.getFabricante()==null || this.nuevogen.getFabricante().equals("")){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_gen"));
			logger.error("("+this.usuario+") No se puede insertar generador. Es necesario especificar codigo GS1-128, modelo, modo y fabricante al generador");
		}else{
			try{
				//Generador[] aux =this.g.findByDynamicWhere("MODELO=? OR GS128=?",new Object[]{this.nuevogen.getModelo(),this.nuevogen.getGs128()});
				Codigosgs128[] aux = this.gs128dao.findByDynamicWhere("CODIGO=? AND TIPO=?", new Object[]{this.nuevogen.getGs128(),1});
				if(aux.length>0){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_warn_dupl"));
					logger.error("("+this.usuario+") No se puede insertar generador. Elemento existente en el sistema");
				}else{
					this.nuevogen.setActivo(1);
					this.nuevogen.setRf(this.rf?(short)1:(short)0);
					this.nuevogen.setMri(this.mri?(short)1:(short)0);
					this.nuevogen.setModelo(this.nuevogen.getModelo().toUpperCase());
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
					// Notificacion de material
					GestorCorreo gc = new GestorCorreo();
					gc.sendMailToAdminGen(this.nuevogen, this.nombre_centro, this.usuario, 1);
					//NotificacionMaterial obj = new NotificacionMaterial();
					//obj.notificaMaterialGenerador(this.nuevomodelogen, this.nuevoreferenciagen, this.nuevofabricantegen, this.nuevotipogen, this.nuevomodogen, this.conectoravgen, this.conectorvdgen, this.conectorvigen, this.rf?"1":"0", this.mri?"1":"0",this.nombre_centro , this.nuevogs1gen);
					logger.info("("+this.usuario+") Generador- Modelo:"+this.nuevogen.getModelo()+". GS1-128: "+this.nuevogen.getGs128()+" insertado con éxito en el sistema");
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("mat_msg_info_add"));
					this.nuevogen = new Generador();
				}
				this.limpiarGeneradores(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_error_add")+": "+ e1.getMessage());
				logger.error("("+this.usuario+") No se puede insertar generador. Error: "+ e1.getMessage());				
			}
		}	
	}
	public void addElectrodo(ActionEvent e){
		logger.info("("+this.usuario+") Iniciando acción insertar electrodo");		
		if(this.nuevoel.getGs128().length()<=0 || this.nuevoel.getModelo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_warn_add"));
			logger.error("("+this.usuario+") No se puede insertar electrodo. Es necesario especificar codigo GS1-128 y modelo al electrodo");
		}			
		else{
			try{
				//Electrodos[] aux =this.e.findByDynamicWhere("MODELO=? OR GS128=?",new Object[]{this.nuevoel.getModelo(),this.nuevoel.getGs128()});
				Codigosgs128[] aux = this.gs128dao.findByDynamicWhere("CODIGO=? AND TIPO=?", new Object[]{this.nuevoel.getGs128(),2});
				if(aux.length>0){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_warn_dupl"));
					logger.error("("+this.usuario+") No se puede insertar electrodo. Elemento existente en el sistema");
				}else{
					this.nuevoel.setActivo(1);
					this.nuevoel.setModelo(this.nuevoel.getModelo().toUpperCase());
					ElectrodosPk elpk = this.e.insert(this.nuevoel);
					// INSERTAR CODIGOS GS128
					Codigosgs128 gs128 = new Codigosgs128();
					gs128.setCodigo(this.nuevoel.getGs128());
					gs128.setTipo(2);
					gs128.setIdmaterial(elpk.getIdelectrodo());
					this.gs128dao.insert(gs128);
					this.nuevoel.getCodigos().add(gs128);
					// Notificacion de material
					GestorCorreo gc = new GestorCorreo();
					gc.sendMailToAdminElec(this.nuevoel, this.nombre_centro, this.usuario, 1);
					//NotificacionMaterial obj = new NotificacionMaterial();
					/*obj.notificaMaterialElectrodo(this.nuevomodeloelec,this.nuevoreferenciaelec,this.nuevofabricanteelec,this.nuevopolaridadelec, 
							this.nuevofijacionelec, this.nuevoconectorelec, this.nuevobobinaelec,this.nombre_centro,this.nuevonummodeloelec,this.nuevogs128elec);*/
					logger.info("("+this.usuario+") Electrodo- Modelo:"+this.nuevoel.getModelo()+". GS1-128: "+this.nuevoel.getGs128()+" insertado con éxito en el sistema");
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("mat_msg_info_add"));
					this.nuevoel = new Electrodos();					
				}
				this.limpiarElectrodos(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_error_add")+": "+ e1.getMessage());
				logger.error("("+this.usuario+") No se puede insertar electrodo. Error: "+ e1.getMessage());	
			}	
		}
	}
	public void addCateter(ActionEvent e){
		logger.info("("+this.usuario+") Iniciando acción insertar cateter");		
		if(this.nuevocat.getGs128().length()<=0 || this.nuevocat.getModelo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_warn_add"));
			logger.error("("+this.usuario+") No se puede insertar cateter. Es necesario especificar codigo GS1-128 y modelo al cateter");
		}			
		else{
			try{
				//Cateter[] aux =this.catdao.findByDynamicWhere("MODELO=? OR GS128=?",new Object[]{this.nuevocat.getModelo(),this.nuevocat.getGs128()});
				Codigosgs128[] aux = this.gs128dao.findByDynamicWhere("CODIGO=? AND TIPO=?", new Object[]{this.nuevocat.getGs128(),3});
				if(aux.length>0){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_warn_dupl"));
					logger.error("("+this.usuario+") No se puede insertar cateter. Elemento existente en el sistema");
				}else{										
					this.nuevocat.setActivo(1);
					this.nuevocat.setModelo(this.nuevocat.getModelo().toUpperCase());
					CateterPk catpk = this.catdao.insert(this.nuevocat);
					// INSERTAR CODIGOS GS128
					Codigosgs128 gs128 = new Codigosgs128();
					gs128.setCodigo(this.nuevocat.getGs128());
					gs128.setTipo(3);
					gs128.setIdmaterial(catpk.getIdcateter());
					this.gs128dao.insert(gs128);
					this.nuevocat.getCodigos().add(gs128);
					// Notificacion de material
					GestorCorreo gc = new GestorCorreo();
					gc.sendMailToAdminCat(this.nuevocat, this.nombre_centro, this.usuario, 1);
					/*NotificacionMaterial obj = new NotificacionMaterial();
					obj.notificaMaterialElectrodo(this.nuevomodeloelec,this.nuevoreferenciaelec,this.nuevofabricanteelec,this.nuevopolaridadelec, 
							this.nuevofijacionelec, this.nuevoconectorelec, this.nuevobobinaelec,this.nombre_centro,this.nuevonummodeloelec,this.nuevogs128elec);*/
					logger.info("("+this.usuario+") Cateter - Modelo:"+this.nuevocat.getModelo()+". GS1-128: "+this.nuevocat.getGs128()+" insertado con éxito en el sistema");
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("mat_msg_info_add"));
					this.nuevocat = new Cateter();
					limpiarCateteres(null);
				}
				this.limpiarCateteres(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_error_add")+": "+ e1.getMessage());
				logger.error("("+this.usuario+") No se puede insertar cateter. Error: "+ e1.getMessage());	
			}	
		}
	}
	
	public void addRegistrador(ActionEvent e){
		logger.info("("+this.usuario+") Iniciando acción insertar registrador de eventos");		
		if(this.nuevoreg.getNuevocodigo().length()<=0 || this.nuevoreg.getModelo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_warn_add"));
			logger.error("("+this.usuario+") No se puede insertar registrador de eventos. Es necesario especificar codigo GS1-128 y modelo.");
		}			
		else{
			try{
				//Registradoreventos[] aux =this.regdao.findByDynamicWhere("MODELO=? OR GS128=?",new Object[]{this.nuevoreg.getModelo(),this.nuevoreg.getNuevocodigo()});
				Codigosgs128[] aux = this.gs128dao.findByDynamicWhere("CODIGO=? AND TIPO=?", new Object[]{this.nuevoreg.getNuevocodigo(),4});
				if(aux.length>0){
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_warn_dupl"));
					logger.error("("+this.usuario+") No se puede insertar material. Elemento existente en el sistema");
				}else{										
					this.nuevoreg.setActivo(1);
					this.nuevoreg.setModelo(this.nuevoreg.getModelo().toUpperCase());
					RegistradoreventosPk regpk = this.regdao.insert(this.nuevoreg);
					// INSERTAR CODIGOS GS128
					Codigosgs128 gs128 = new Codigosgs128();
					gs128.setCodigo(this.nuevoreg.getNuevocodigo());
					gs128.setTipo(4);
					gs128.setIdmaterial(regpk.getIdregistrador());
					this.gs128dao.insert(gs128);
					this.nuevoreg.getCodigos().add(gs128);
					// Notificacion de material
					GestorCorreo gc = new GestorCorreo();
					gc.sendMailToAdminRegEv(this.nuevoreg, this.nombre_centro, this.usuario, 1);
					//NotificacionMaterial obj = new NotificacionMaterial();
					//obj.notificaMaterialElectrodo(this.nuevomodeloelec,this.nuevoreferenciaelec,this.nuevofabricanteelec,this.nuevopolaridadelec, 
					//		this.nuevofijacionelec, this.nuevoconectorelec, this.nuevobobinaelec,this.nombre_centro,this.nuevonummodeloelec,this.nuevogs128elec);
					logger.info("("+this.usuario+") Registrador de eventos - Modelo:"+this.nuevoreg.getModelo()+". GS1-128: "+this.nuevoreg.getNuevocodigo()+" insertado con éxito en el sistema");
					this.nuevoreg = new Registradoreventos();
					limpiarRegistradores(null);
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("mat_msg_info_add"));
				}
				this.limpiarRegistradores(null);
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_error_add")+": "+ e1.getMessage());
				logger.error("("+this.usuario+") No se puede insertar registrador de eventos. Error: "+ e1.getMessage());	
			}	
		}
	}
	
	public void guardaGS128Material(ArrayList<Codigosgs128> lista, Integer idmat, Integer tipo){
		try{
			// 1. BORRAR ANTERIORES
			// 1.1 recuperar los anteriores
			Codigosgs128[] previos = this.gs128dao.findByDynamicWhere("IDMATERIAL = ? AND TIPO = ?", new Object[]{idmat,tipo});
			for(Codigosgs128 cod:previos)
				this.gs128dao.delete(new Codigosgs128Pk(cod.getIdmaterial(),cod.getTipo(),cod.getCodigo()));			
			// 2. GUARDAR LOS REFERENCIADOS EN LA LISTA	
			for(Codigosgs128 cod:lista)
				this.gs128dao.insert(cod);
		}catch(Exception e1){
			logger.error("("+this.usuario+") No se puede guardar códigos gs128 asociados a material. Error: "+ e1.getMessage());
		}
	}
	
	public void consultarGenerador(ActionEvent e){
		this.generadores = null;
		try{
			if(this.gen.getModelo().length()<=0 && this.gen.getCodigo().length()<=0 
				&& (this.gen.getTipo()==null || this.gen.getTipo().equals(""))
				&& (this.gen.getFabricante() == null ||  this.gen.getFabricante().equals(""))
				&& (this.gen.getActivo()==null || this.gen.getActivo().equals(2)))
				cargaGeneradores();
			else{// Busqueda por parametros
				String wheresql = "";
				int contador = 0;
				Object[] params = new Object[5];
				if(this.gen.getModelo()!=null && this.gen.getModelo().length()>0){
					wheresql = wheresql + " MODELO LIKE ? AND";
					params[contador] = "%"+this.gen.getModelo()+"%";
					contador++;
				}		
				if(this.gen.getCodigo()!=null && this.gen.getCodigo().length()>0){
					wheresql = wheresql + " CODIGO LIKE ? AND";
					params[contador] = "%"+this.gen.getCodigo()+"%";
					contador++;
				}					
				if(this.gen.getTipo()!=null && !this.gen.getTipo().equals("")){
					wheresql = wheresql + " TIPO=? AND";
					params[contador] = Integer.valueOf(this.gen.getTipo());
					contador++;
				}					
				if(this.gen.getFabricante()!=null && !this.gen.getFabricante().equals("")){
					wheresql = wheresql + " FABRICANTE=? AND";
					params[contador] = this.gen.getFabricante();
					contador++;
				}
				if(this.gen.getActivo()!=null && !this.gen.getActivo().equals(2)){
					wheresql = wheresql + " ACTIVO=? AND";
					params[contador] = this.gen.getActivo();
					contador++;
				}
				// OPTIMIZAR
				Object[] obj = new Object[contador];
				for(int i=0;i<contador;i++)
					obj[i] = params[i];				
				//Quitar el ultimo AND para formatear adecuadamente el WHERE
				wheresql = wheresql.substring(0,wheresql.length()-3);
				this.generadores = this.g.findByDynamicWhere(wheresql,obj);
				// adaptar valores de rf + mri
				for(Generador g:this.generadores){
					if(g.getRf()!=null && g.getRf().equals((short)1))
						g.setRfb(true);
					if(g.getMri()!=null && g.getMri().equals((short)1))
						g.setMrib(true);
					this.obtenerCodigosGenerador(g);
					g.setGenfab(this.obtenerValoresFabricaGenerador(g));
				}
				this.totalgen = this.generadores.length;
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_consulta")+": "+ e1.getMessage());
		}
	}
	public void consultarElectrodos(ActionEvent e){
		this.electrodos = null;
		try{
			if(this.el.getModelo().length()<=0 && this.el.getCodigo().length()<=0
					&& (this.el.getFabricante()==null || this.el.getFabricante().equals(""))
					&& (this.el.getActivo()==null || this.el.getActivo().equals(2)))
				cargaElectrodos();
			else{// Busqueda por parametros
				String wheresql = "";
				int contador = 0;
				Object[] params = new Object[4];
				if(this.el.getModelo()!=null && this.el.getModelo().length()>0){
					wheresql = wheresql + " MODELO  LIKE ? AND";
					params[contador] = "%"+this.el.getModelo()+"%";
					contador++;
				}		
				if(this.el.getCodigo()!=null && this.el.getCodigo().length()>0){
					wheresql = wheresql + " CODIGO LIKE ? AND";
					params[contador] = "%"+this.el.getCodigo()+"%";
					contador++;
				}										
				if(this.el.getFabricante()!=null && !this.el.getFabricante().equals("")){
					wheresql = wheresql + " FABRICANTE=? AND";
					params[contador] = this.el.getFabricante();
					contador++;
				}
				if(this.el.getActivo()!=null && !this.el.getActivo().equals(2)){
					wheresql = wheresql + " ACTIVO=? AND";
					params[contador] = this.el.getActivo();
					contador++;
				}
				// OPTIMIZAR
				Object[] obj = new Object[contador];
				for(int i=0;i<contador;i++)
					obj[i] = params[i];				
				//Quitar el ultimo AND para formatear adecuadamente el WHERE
				wheresql = wheresql.substring(0,wheresql.length()-3);
				this.electrodos = this.e.findByDynamicWhere(wheresql,obj);
				// adaptar valores de rf + mri
				for(Electrodos el:this.electrodos)
					this.obtenerCodigosElectrodo(el);
				this.totalelec = this.electrodos.length;
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_consulta")+": "+ e1.getMessage());
		}
	}
	public void consultarCateteres(ActionEvent e){
		this.cats = null;
		try{
			/*if(this.conn.isClosed()){
				this.obtenerConexion();
				System.out.println("Obtener otra conexion");
			}*/
			if(this.cat.getModelo().length()<=0 && this.cat.getReferencia().length()<=0
					&& (this.cat.getFabricante()==null || this.cat.getFabricante().equals(0)) 
					&& (this.cat.getTipo()== null || this.cat.getTipo().equals(0))
					&& (this.cat.getActivo()==null || this.cat.getActivo().equals(2)))
				cargaCateteres();
			else{// Busqueda por parametros
				String wheresql = "";
				int contador = 0;
				Object[] params = new Object[5];
				if(this.cat.getModelo()!=null && this.cat.getModelo().length()>0){
					wheresql = wheresql + " MODELO LIKE ? AND";
					params[contador] = "%"+this.cat.getModelo()+"%";
					contador++;
				}		
				if(this.cat.getReferencia()!=null && this.cat.getReferencia().length()>0){
					wheresql = wheresql + " REFERENCIA LIKE ? AND";
					params[contador] = "%"+this.cat.getReferencia()+"%";
					contador++;
				}										
				if(this.cat.getFabricante()!=null && !this.cat.getFabricante().equals(0)){
					wheresql = wheresql + " FABRICANTE=? AND";
					params[contador] = this.cat.getFabricante();
					contador++;
				}
				if(this.cat.getTipo()!=null && !this.cat.getTipo().equals(0)){
					wheresql = wheresql + " TIPO=? AND";
					params[contador] = this.cat.getTipo();
					contador++;
				}
				if(this.cat.getActivo()!=null && !this.cat.getActivo().equals(2)){
					wheresql = wheresql + " ACTIVO=? AND";
					params[contador] = this.cat.getActivo();
					contador++;
				}
				// OPTIMIZAR
				Object[] obj = new Object[contador];
				for(int i=0;i<contador;i++)
					obj[i] = params[i];				
				//Quitar el ultimo AND para formatear adecuadamente el WHERE
				wheresql = wheresql.substring(0,wheresql.length()-3);
				this.cats = this.catdao.findByDynamicWhere(wheresql,obj);
				// adaptar valores de rf + mri
				for(Cateter c:this.cats)
					this.obtenerCodigosCateter(c);
				this.totalcat = this.cats.length;
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_consulta")+": "+ e1.getMessage());
		}
	}
	
	public void consultarRegEventos(ActionEvent e){
		this.regs = null;
		try{
			if(this.reg.getModelo().length()<=0 && this.reg.getReferencia().length()<=0
					&& (this.reg.getFabricante()==null || this.reg.getFabricante().equals("0")) 
					&& (this.reg.getActivo()==null || this.reg.getActivo().equals(2)))
				cargaRegistradores();
			else{// Busqueda por parametros
				String wheresql = "";
				int contador = 0;
				Object[] params = new Object[5];
				if(this.reg.getModelo()!=null && this.reg.getModelo().length()>0){
					wheresql = wheresql + " MODELO LIKE ? AND";
					params[contador] = "%"+this.reg.getModelo()+"%";
					contador++;
				}		
				if(this.reg.getReferencia()!=null && this.reg.getReferencia().length()>0){
					wheresql = wheresql + " REFERENCIA LIKE ? AND";
					params[contador] = "%"+this.reg.getReferencia()+"%";
					contador++;
				}										
				if(this.reg.getFabricante()!=null && !this.reg.getFabricante().equals("0")){
					wheresql = wheresql + " FABRICANTE=? AND";
					params[contador] = this.reg.getFabricante();
					contador++;
				}
				if(this.reg.getActivo()!=null && !this.reg.getActivo().equals(2)){
					wheresql = wheresql + " ACTIVO=? AND";
					params[contador] = this.reg.getActivo();
					contador++;
				}
				// OPTIMIZAR
				Object[] obj = new Object[contador];
				for(int i=0;i<contador;i++)
					obj[i] = params[i];				
				//Quitar el ultimo AND para formatear adecuadamente el WHERE
				wheresql = wheresql.substring(0,wheresql.length()-3);
				this.regs = this.regdao.findByDynamicWhere(wheresql,obj);
				// adaptar valores de rf + mri
				for(Registradoreventos ev:this.regs){
					if(ev.getRf()!=null && ev.getRf().equals(1))
						ev.setRf_bol(true);
					if(ev.getMri()!=null && ev.getMri().equals(1))
						ev.setMri_bol(true);
					this.obtenerCodigosRegistrador(ev);
				}
				this.totalreg = this.regs.length;
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_consulta")+": "+ e1.getMessage());
		}
	}
	
	public void activadesactivaGenerador(ActionEvent e){
		try{
			this.generadores[this.bindingGenerador.getRowIndex()].setActivo(this.generadores[this.bindingGenerador.getRowIndex()].getActivo()==null 
					|| this.generadores[this.bindingGenerador.getRowIndex()].getActivo().equals(0)?1:0);
			this.g.update(new GeneradorPk(this.generadores[this.bindingGenerador.getRowIndex()].getIdgenerador()), this.generadores[this.bindingGenerador.getRowIndex()]);
			this.pintaMensaje(INFO, this.bundle.getString("mat_msg_info_estado"));
			logger.info("("+this.usuario+") Estado de generador modificado en el sistema. IdGenerador: "+this.generadores[this.bindingGenerador.getRowIndex()].getIdgenerador());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_accion")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede cambiar estado de generador. Error: "+ e1.getMessage());
		}
	}

	public void activadesactivaElectrodo(ActionEvent e){
		try{
			this.electrodos[this.bindingElectrodo.getRowIndex()].setActivo(this.electrodos[this.bindingElectrodo.getRowIndex()].getActivo()==null 
					|| this.electrodos[this.bindingElectrodo.getRowIndex()].getActivo().equals(0)?1:0);
			System.out.println(this.electrodos[this.bindingElectrodo.getRowIndex()].getModelo());
			this.e.update(new ElectrodosPk(this.electrodos[this.bindingElectrodo.getRowIndex()].getIdelectrodo()), this.electrodos[this.bindingElectrodo.getRowIndex()]);
			this.pintaMensaje(INFO, this.bundle.getString("mat_msg_info_estado"));
			logger.info("("+this.usuario+") Estado de electrodo modificado en el sistema. IdElectrodo: "+this.electrodos[this.bindingElectrodo.getRowIndex()].getIdelectrodo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_accion")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede cambiar estado de electrodo. Error: "+ e1.getMessage());
		}
	}

	public void activadesactivaCateter(ActionEvent e){
		try{
			this.cats[this.bindingCateter.getRowIndex()].setActivo(this.cats[this.bindingCateter.getRowIndex()].getActivo()==null 
					|| this.cats[this.bindingCateter.getRowIndex()].getActivo().equals(0)?1:0);
			this.catdao.update(new CateterPk(this.cats[this.bindingCateter.getRowIndex()].getIdcateter()), this.cats[this.bindingCateter.getRowIndex()]);
			this.pintaMensaje(INFO, this.bundle.getString("mat_msg_info_estado"));
			logger.info("("+this.usuario+") Estado de cateter modificado en el sistema. IdCateter: "+this.cats[this.bindingCateter.getRowIndex()].getIdcateter());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_accion")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede cambiar estado de cateter. Error: "+ e1.getMessage());
		}
	}
	
	public void activadesactivaRegistrador(ActionEvent e){
		try{
			this.regs[this.bindingRegEventos.getRowIndex()].setActivo(this.regs[this.bindingRegEventos.getRowIndex()].getActivo()==null 
					|| this.regs[this.bindingRegEventos.getRowIndex()].getActivo().equals(0)?1:0);
			this.regdao.update(new RegistradoreventosPk(this.regs[this.bindingRegEventos.getRowIndex()].getIdregistrador()), this.regs[this.bindingRegEventos.getRowIndex()]);
			this.pintaMensaje(INFO, this.bundle.getString("mat_msg_info_estado"));
			logger.info("("+this.usuario+") Estado de registrador de eventos modificado en el sistema. IdRegistrador: "+this.regs[this.bindingRegEventos.getRowIndex()].getIdregistrador());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_accion")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede cambiar estado de registrador de eventos. Error: "+ e1.getMessage());
		}
	}

	public void lecturaGs128Generador(ActionEvent e){
		if(this.nuevogen.getGs128().length()>=16)// codigo GS1-128
			this.nuevogen.setGs128(this.nuevogen.getGs128().substring(0, 16).substring(2, 16));
		if(this.nuevogen.getGs128().length()!=14)
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
	}
	public void lecturaGs128Generador2(ActionEvent e){
		this.currentItemGenerador.setCodigovalido(true);
		if(this.currentItemGenerador.getNuevocodigo().length()>=16){// codigo GS1-128			
			this.currentItemGenerador.setNuevocodigo(this.currentItemGenerador.getNuevocodigo().substring(0, 16).substring(2, 16));	
		}	
		if(this.currentItemGenerador.getNuevocodigo().length()!=14){
			this.currentItemGenerador.setCodigovalido(false);
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
		}
		/*if(this.currentItemGenerador.getGs128().length()>=16)// codigo GS1-128
			this.currentItemGenerador.setGs128(this.currentItemGenerador.getGs128().substring(0, 16).substring(2, 16));
		if(this.currentItemGenerador.getGs128().length()!=14)
			this.pintaMensaje(AVISO, "El código GS-128 no dispone de un formato válido.");*/
	}
	public void lecturaGs128Electrodo(ActionEvent e){
		if(this.nuevoel.getGs128().length()>=16)// codigo GS1-128
			this.nuevoel.setGs128(this.nuevoel.getGs128().substring(0, 16).substring(2, 16));
		if(this.nuevoel.getGs128().length()!=14)
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
		/*String previo = this.nuevogs128elec;
		if(previo.length()==34)// codigo GS1-128
			this.setNuevogs128elec(previo.substring(0, 16).substring(10, 15));*/
	}
	public void lecturaGs128Electrodo2(ActionEvent e){
		this.currentItemElectrodo.setCodigovalido(true);
		if(this.currentItemElectrodo.getNuevocodigo().length()>=16){// codigo GS1-128			
			this.currentItemElectrodo.setNuevocodigo(this.currentItemElectrodo.getNuevocodigo().substring(0, 16).substring(2, 16));	
		}	
		if(this.currentItemElectrodo.getNuevocodigo().length()!=14){
			this.currentItemElectrodo.setCodigovalido(false);
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
		}
		/*if(this.currentItemElectrodo.getGs128().length()>=16)// codigo GS1-128
			this.currentItemElectrodo.setGs128(this.currentItemElectrodo.getGs128().substring(0, 16).substring(2, 16));
		if(this.currentItemElectrodo.getGs128().length()!=14)
			this.pintaMensaje(AVISO, "El código GS-128 no dispone de un formato válido.");*/
		/*String previo = this.nuevogs128elec;
		if(previo.length()==34)// codigo GS1-128
			this.setNuevogs128elec(previo.substring(0, 16).substring(10, 15));*/
	}
	public void lecturaGs128Cateter(ActionEvent e){
		if(this.nuevocat.getGs128().length()>=16)// codigo GS1-128
			this.nuevocat.setGs128(this.nuevocat.getGs128().substring(0, 16).substring(2, 16));
		if(this.nuevocat.getGs128().length()!=14)
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
	}
	public void lecturaGs128Cateter2(ActionEvent e){
		this.currentItemCateter.setCodigovalido(true);
		if(this.currentItemCateter.getNuevocodigo().length()>=16){// codigo GS1-128			
			this.currentItemCateter.setNuevocodigo(this.currentItemCateter.getNuevocodigo().substring(0, 16).substring(2, 16));	
		}	
		if(this.currentItemCateter.getNuevocodigo().length()!=14){
			this.currentItemCateter.setCodigovalido(false);
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
		}
		/*if(this.currentItemCateter.getGs128().length()>=16)// codigo GS1-128
			this.currentItemCateter.setGs128(this.currentItemCateter.getGs128().substring(0, 16).substring(2, 16));
		if(this.currentItemCateter.getGs128().length()!=14)
			this.pintaMensaje(AVISO, "El código GS-128 no dispone de un formato válido.");*/
	}
	public void lecturaGs128Registrador(ActionEvent e){
		if(this.nuevoreg.getNuevocodigo().length()>=16)// codigo GS1-128
			this.nuevoreg.setNuevocodigo(this.nuevoreg.getNuevocodigo().substring(0, 16).substring(2, 16));
		if(this.nuevoreg.getNuevocodigo().length()!=14)
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
	}
	public void lecturaGS128Registrador(ActionEvent e){
		this.currentItemRegistrador.setCodigovalido(true);
		if(this.currentItemRegistrador.getNuevocodigo().length()>=16){// codigo GS1-128			
			this.currentItemRegistrador.setNuevocodigo(this.currentItemRegistrador.getNuevocodigo().substring(0, 16).substring(2, 16));	
		}	
		if(this.currentItemRegistrador.getNuevocodigo().length()!=14){
			this.currentItemRegistrador.setCodigovalido(false);
			this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128"));
		}
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
	public void cambiaTipoablacionEdit(ActionEvent e){
		if(this.currentItemCateter.getTipoablacion()!=null){
			if(this.currentItemCateter.getTipoablacion().equals(1)||this.currentItemCateter.getTipoablacion().equals(2)
					||this.currentItemCateter.getTipoablacion().equals(3)||this.currentItemCateter.getTipoablacion().equals(7)
					||this.currentItemCateter.getTipoablacion().equals(9) ||this.currentItemCateter.getTipoablacion().equals(10)
					||this.currentItemCateter.getTipoablacion().equals(11))
				this.currentItemCateter.setEnergia(1);//RF
			else if(this.currentItemCateter.getTipoablacion().equals(6))
				this.currentItemCateter.setEnergia(3);//laser
			else if(this.currentItemCateter.getTipoablacion().equals(0)||this.currentItemCateter.getTipoablacion().equals(8))
				this.currentItemCateter.setEnergia(0);//ninguna
			else
				this.currentItemCateter.setEnergia(2);//crioablacion
		}
	}
	public void cargaGeneradores() {
		try {
			this.setGeneradores(this.g.findAll());
			// adaptar valores de rf + mri
			for(Generador g:this.generadores){
				if(g.getRf()!=null && g.getRf().equals((short)1))
					g.setRfb(true);
				if(g.getMri()!=null && g.getMri().equals((short)1))
					g.setMrib(true);
				this.obtenerCodigosGenerador(g);
				g.setGenfab(this.obtenerValoresFabricaGenerador(g));
			}
			this.totalgen = this.generadores.length;
			if(this.generadores.length==0)
				this.pintaMensaje(INFO, this.bundle.getString("mat_msg_warn_nomaterial_gen"));
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
		}
	}
	public void cargaElectrodos() {
		try {
			this.setElectrodos(this.e.findAll());
			this.totalelec = this.electrodos.length;
			for(Electrodos e:this.electrodos)
				this.obtenerCodigosElectrodo(e);
			if(this.electrodos.length==0)
				this.pintaMensaje(INFO, this.bundle.getString("mat_msg_warn_nomaterial_elec"));
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
		}
	}
	public void cargaCateteres() {
		try {
			this.setCats(this.catdao.findAll());
			for(Cateter ca:this.cats)
				this.obtenerCodigosCateter(ca);
			this.totalcat = this.cats.length;
			if(this.cats.length==0)
				this.pintaMensaje(INFO, this.bundle.getString("mat_msg_warn_nomaterial_cat"));
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
		}
	}
	public void cargaRegistradores() {
		try {
			this.setRegs(this.regdao.findAll());
			for(Registradoreventos ev:this.regs){
				if(ev.getRf()!=null && ev.getRf().equals(1))
					ev.setRf_bol(true);
				if(ev.getMri()!=null && ev.getMri().equals(1))
					ev.setMri_bol(true);
				this.obtenerCodigosRegistrador(ev);
			}
			this.totalreg = this.regs.length;
			if(this.regs.length==0)
				this.pintaMensaje(INFO, this.bundle.getString("mat_msg_warn_nomaterial_regev"));
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
		}
	}
	
	public void obtenerCodigosGenerador(Generador g){
		try{
			Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("IDMATERIAL = ? AND TIPO = ?", new Object[]{g.getIdgenerador(),1});
			for(Codigosgs128 cd:codigos)
				g.getCodigos().add(cd);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_gs128_cons")+": "+ e1.getMessage());
		}
	}
	
	public void obtenerCodigosElectrodo(Electrodos e){
		try{
			Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("IDMATERIAL = ? AND TIPO = ?", new Object[]{e.getIdelectrodo(),2});
			for(Codigosgs128 cd:codigos)
				e.getCodigos().add(cd);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_gs128_cons")+": "+ e1.getMessage());
		}
	}
	
	public void obtenerCodigosCateter(Cateter c){
		try{
			Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("IDMATERIAL = ? AND TIPO = ?", new Object[]{c.getIdcateter(),3});
			for(Codigosgs128 cd:codigos)
				c.getCodigos().add(cd);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_gs128_cons")+": "+ e1.getMessage());
		}
	}
	
	public void obtenerCodigosRegistrador(Registradoreventos ev){
		try{
			Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("IDMATERIAL = ? AND TIPO = ?", new Object[]{ev.getIdregistrador(),4});
			for(Codigosgs128 cd:codigos)
				ev.getCodigos().add(cd);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_gs128_cons")+": "+ e1.getMessage());
		}
	}
	
	public Genvaloresfabrica obtenerValoresFabricaGenerador(Generador g){
		try{
			Genvaloresfabrica fab = this.genfabdao.findByPrimaryKey(g.getIdgenerador());
			if(fab!=null)
				return fab;
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_warn_gen_valores_fabrica")+": "+ e1.getMessage());
		}
		return new Genvaloresfabrica();
	}
	
	public void addGs128Generador(ActionEvent e){
		if(this.currentItemGenerador.getNuevocodigo()!=null
				&& this.currentItemGenerador.isCodigovalido()){
			// 1. Comprobacion previa de codigo
			Codigosgs128 ex = null;
			try {
				ex = this.gs128dao.findByPrimaryKey(this.currentItemGenerador.getIdgenerador(), 1, this.currentItemGenerador.getNuevocodigo());
				if(ex!=null)
					this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128_add"));
				else{
					Codigosgs128 cod = new Codigosgs128();
					cod.setCodigo(this.currentItemGenerador.getNuevocodigo());
					cod.setTipo(1);
					cod.setIdmaterial(this.currentItemGenerador.getIdgenerador());
					this.currentItemGenerador.getCodigos().add(cod);
				}
			} catch (Codigosgs128DaoException e1) {
				this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_gs128_cons_2")+": "+e1.getMessage());
			}		
		}
		// limpiar para empezar de nuevo
		this.currentItemGenerador.setNuevocodigo(null);
		this.currentItemGenerador.setCodigovalido(false);
	}
	
	public void delGs128Generador(ActionEvent e){
		this.currentItemGenerador.getCodigos().remove(this.bindingGeneradorGs128.getRowIndex());
	}
	
	public void addGs128Electrodo(ActionEvent e){
		if(this.currentItemElectrodo.getNuevocodigo()!=null
				&& this.currentItemElectrodo.isCodigovalido()){
			Codigosgs128 ex = null;
			try {
				ex = this.gs128dao.findByPrimaryKey(this.currentItemElectrodo.getIdelectrodo(), 2, this.currentItemElectrodo.getNuevocodigo());
				if(ex!=null)
					this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128_add"));
				else{
					Codigosgs128 cod = new Codigosgs128();
					cod.setCodigo(this.currentItemElectrodo.getNuevocodigo());
					cod.setTipo(2);
					cod.setIdmaterial(this.currentItemElectrodo.getIdelectrodo());
					this.currentItemElectrodo.getCodigos().add(cod);
				}
			} catch (Codigosgs128DaoException e1) {
				this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_gs128_cons_2")+": "+e1.getMessage());
			}
		}
		// limpiar para empezar de nuevo
		this.currentItemElectrodo.setNuevocodigo(null);
		this.currentItemElectrodo.setCodigovalido(false);
	}
	
	public void delGs128Electrodo(ActionEvent e){
		this.currentItemElectrodo.getCodigos().remove(this.bindingElectrodoGs128.getRowIndex());
	}
	
	public void addGs128Cateter(ActionEvent e){
		if(this.currentItemCateter.getNuevocodigo()!=null
				&& this.currentItemCateter.isCodigovalido()){
			Codigosgs128 ex = null;
			try {
				ex = this.gs128dao.findByPrimaryKey(this.currentItemCateter.getIdcateter(), 3, this.currentItemCateter.getNuevocodigo());
				if(ex!=null)
					this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128_add"));
				else{
					Codigosgs128 cod = new Codigosgs128();
					cod.setCodigo(this.currentItemCateter.getNuevocodigo());
					cod.setTipo(3);
					cod.setIdmaterial(this.currentItemCateter.getIdcateter());
					this.currentItemCateter.getCodigos().add(cod);
				}
			} catch (Codigosgs128DaoException e1) {
				this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_gs128_cons_2")+": "+e1.getMessage());
			}
		}
		// limpiar para empezar de nuevo
		this.currentItemCateter.setNuevocodigo(null);
		this.currentItemCateter.setCodigovalido(false);
	}
	
	public void delGs128Cateter(ActionEvent e){
		this.currentItemCateter.getCodigos().remove(this.bindingCateterGs128.getRowIndex());
	}
	
	public void addGs128Registrador(ActionEvent e){
		if(this.currentItemRegistrador.getNuevocodigo()!=null
				&& this.currentItemRegistrador.isCodigovalido()){	
			Codigosgs128 ex = null;
			try {
				ex = this.gs128dao.findByPrimaryKey(this.currentItemRegistrador.getIdregistrador(), 4, this.currentItemRegistrador.getNuevocodigo());
				if(ex!=null)
					this.pintaMensaje(AVISO, this.bundle.getString("info_msg_error_gs128_add"));
				else{
					Codigosgs128 cod = new Codigosgs128();
					cod.setCodigo(this.currentItemRegistrador.getNuevocodigo());
					cod.setTipo(4);
					cod.setIdmaterial(this.currentItemRegistrador.getIdregistrador());
					this.currentItemRegistrador.getCodigos().add(cod);
				}
			} catch (Codigosgs128DaoException e1) {
				this.pintaMensaje(ERROR, this.bundle.getString("info_msg_error_gs128_cons_2")+": "+e1.getMessage());
			}
		}
		// limpiar para empezar de nuevo
		this.currentItemRegistrador.setNuevocodigo(null);
		this.currentItemRegistrador.setCodigovalido(false);
	}
	
	public void delGs128Registrador(ActionEvent e){
		this.currentItemRegistrador.getCodigos().remove(this.bindingRegEventosGs128.getRowIndex());
	}
	
	/*public void limpiarFormulario(ActionEvent e){		
		this.rf = false;
		this.mri = false;		
		this.generadores = null;
		this.electrodos = null;
		this.cats = null;
		this.regs = null;
		this.gen = new Generador();
		this.nuevogen = new Generador();
		this.el = new Electrodos();
		this.nuevoel = new Electrodos();
		this.nuevocat = new Cateter();
		this.cat = new Cateter();
		this.reg = new Registradoreventos();
		this.nuevoreg = new Registradoreventos();
		this.totalcat = 0;
		this.totalelec = 0;
		this.totalgen = 0;
		this.totalreg = 0;
	}*/
	
	public void limpiarGeneradores(ActionEvent e){
		this.rf = false;
		this.mri = false;		
		this.generadores = null;
		this.gen = new Generador();
		this.nuevogen = new Generador();
	}
	
	public void limpiarElectrodos(ActionEvent e){
		this.electrodos = null;
		this.el = new Electrodos();
		this.nuevoel = new Electrodos();
	}
	
	public void limpiarCateteres(ActionEvent e){
		this.cats = null;
		this.nuevocat = new Cateter();
		this.cat = new Cateter();
	}
	
	public void limpiarRegistradores(ActionEvent e){
		this.regs = null;
		this.reg = new Registradoreventos();
		this.nuevoreg = new Registradoreventos();
	}
	
	public void cambiarGeneradorIncluir(ActionEvent e){
		// Hay que obtener el id del generador a modificar y actualizarlo
		if(/*this.currentItemGenerador.getGs128().length()<=0 || */this.currentItemGenerador.getModelo().length()<=0 || this.currentItemGenerador.getModo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_gen_2"));
			logger.error("("+this.usuario+") No se puede actualizar generador. Es necesario especificar modelo al generador");
		}else{
			try{
				this.currentItemGenerador.setRf(this.currentItemGenerador.isRfb()?(short)1:(short)0);
				this.currentItemGenerador.setMri(this.currentItemGenerador.isMrib()?(short)1:(short)0);
				this.g.update(new GeneradorPk(this.currentItemGenerador.getIdgenerador()), this.currentItemGenerador);
				// Verifica si existe valores de fabrica asociados a generador. Si existe - UPDATE. Si no, INSERT
				if(this.currentItemGenerador.getGenfab().getIdgenerador()==null){
					this.currentItemGenerador.getGenfab().setIdgenerador(this.currentItemGenerador.getIdgenerador());
					this.genfabdao.insert(this.currentItemGenerador.getGenfab());
				}else
					this.genfabdao.update(new GenvaloresfabricaPk(this.currentItemGenerador.getIdgenerador()), this.currentItemGenerador.getGenfab());
				this.guardaGS128Material(this.currentItemGenerador.getCodigos(), this.currentItemGenerador.getIdgenerador(), 1);
				// Notificacion por mail
				GestorCorreo gc = new GestorCorreo();
				gc.sendMailToAdminGen(this.currentItemGenerador, this.nombre_centro, this.usuario, 2);
				this.setCurrentItemGenerador(new Generador());
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("info_msg_editar_info"));
			}catch(Exception e1){
				this.setCurrentItemGenerador(new Generador());
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_accion")+": "+ e1.getMessage());
			}
		}	
	}
	public void cambiarGeneradorCancelar(ActionEvent e){
		this.currentItemGenerador.setModelo(this.currentItemGeneradorBackup.getModelo());
		this.currentItemGenerador.setTipo(this.currentItemGeneradorBackup.getTipo());
		this.currentItemGenerador.setFabricante(this.currentItemGeneradorBackup.getFabricante());
		this.currentItemGenerador.setNumeromodelo(this.currentItemGeneradorBackup.getNumeromodelo());
		this.currentItemGenerador.setModelo(this.currentItemGeneradorBackup.getModelo());
		this.currentItemGenerador.setCodigo(this.currentItemGeneradorBackup.getCodigo());
		this.currentItemGenerador.setGs128(this.currentItemGeneradorBackup.getGs128());
		this.currentItemGenerador.setModo(this.currentItemGeneradorBackup.getModo());
		this.currentItemGenerador.setConectorad(this.currentItemGeneradorBackup.getConectorad());
		this.currentItemGenerador.setConectorvd(this.currentItemGeneradorBackup.getConectorvd());
		this.currentItemGenerador.setConectorvi(this.currentItemGeneradorBackup.getConectorvi());
		this.currentItemGenerador.setConectorvcs(this.currentItemGeneradorBackup.getConectorvcs());
		this.currentItemGenerador.setIdrx(this.currentItemGeneradorBackup.getIdrx());
		this.currentItemGenerador.setRf(this.currentItemGeneradorBackup.getRf());
		this.currentItemGenerador.setMri(this.currentItemGeneradorBackup.getMri());
		this.currentItemGenerador.setCodigos(this.currentItemGeneradorBackup.getCodigos());
		this.currentItemGenerador.setGenfab(this.currentItemGeneradorBackup.getGenfab());
		this.setCurrentItemGenerador(new Generador());
	}
	public void cambiarElectrodoIncluir(ActionEvent e){
		// Hay que obtener el id del generador a modificar y actualizarlo
		if(/*this.currentItemElectrodo.getGs128().length()<=0 || */this.currentItemElectrodo.getModelo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_add_2"));
			logger.error("("+this.usuario+") No se puede actualizar electrodo. Es necesario especificar modelo al electrodo");
		}else{
			try{
				this.e.update(new ElectrodosPk(this.currentItemElectrodo.getIdelectrodo()), this.currentItemElectrodo);
				this.guardaGS128Material(this.currentItemElectrodo.getCodigos(), this.currentItemElectrodo.getIdelectrodo(), 2);
				// Notificacion por mail
				GestorCorreo gc = new GestorCorreo();
				gc.sendMailToAdminElec(this.currentItemElectrodo, this.nombre_centro, this.usuario, 2);
				this.setCurrentItemElectrodo(new Electrodos());
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("info_msg_editar_info"));
			}catch(Exception e1){
				this.setCurrentItemElectrodo(new Electrodos());
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_accion")+": "+ e1.getMessage());
			}
		}
	}
	public void cambiarElectrodoCancelar(ActionEvent e){
		this.currentItemElectrodo.setModelo(this.currentItemElectrodoBackup.getModelo());
		this.currentItemElectrodo.setFabricante(this.currentItemElectrodoBackup.getFabricante());
		this.currentItemElectrodo.setNumeromodelo(this.currentItemElectrodoBackup.getNumeromodelo());		
		this.currentItemElectrodo.setModelo(this.currentItemElectrodoBackup.getModelo());
		this.currentItemElectrodo.setCodigo(this.currentItemElectrodoBackup.getCodigo());
		this.currentItemElectrodo.setGs128(this.currentItemElectrodoBackup.getGs128());
		this.currentItemElectrodo.setConector(this.currentItemElectrodoBackup.getConector());
		this.currentItemElectrodo.setPolaridad(this.currentItemElectrodoBackup.getPolaridad());
		this.currentItemElectrodo.setFijacion(this.currentItemElectrodoBackup.getFijacion());
		this.currentItemElectrodo.setBobina(this.currentItemElectrodoBackup.getBobina());
		this.currentItemElectrodo.setCodigos(this.currentItemElectrodoBackup.getCodigos());
		this.setCurrentItemElectrodo(new Electrodos());
	}

	public void cambiarCateterIncluir(ActionEvent e){
		if(/*this.currentItemCateter.getGs128().length()<=0 ||*/ this.currentItemCateter.getModelo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_add_2"));
			logger.error("("+this.usuario+") No se puede actualizar cateter. Es necesario especificar modelo al cateter");
		}else{
			try{
				this.catdao.update(new CateterPk(this.currentItemCateter.getIdcateter()), this.currentItemCateter);
				this.guardaGS128Material(this.currentItemCateter.getCodigos(), this.currentItemCateter.getIdcateter(), 3);
				// Notificacion por mail
				GestorCorreo gc = new GestorCorreo();
				gc.sendMailToAdminCat(this.currentItemCateter, this.nombre_centro, this.usuario, 2);
				this.setCurrentItemCateter(new Cateter());
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("info_msg_editar_info"));
			}catch(Exception e1){
				this.setCurrentItemCateter(new Cateter());
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_accion")+": "+ e1.getMessage());
			}
		}	
	}
	public void cambiarCateterCancelar(ActionEvent e){
		/*this.currentItemCateter.setModelo(this.currentItemCateterBackup.getModelo());
		this.currentItemCateter.setFabricante(this.currentItemCateterBackup.getFabricante());
		this.currentItemElectrodo.setNumeromodelo(this.currentItemElectrodoBackup.getNumeromodelo());		
		this.currentItemElectrodo.setModelo(this.currentItemElectrodoBackup.getModelo());
		this.currentItemElectrodo.setCodigo(this.currentItemElectrodoBackup.getCodigo());
		this.currentItemElectrodo.setGs128(this.currentItemElectrodoBackup.getGs128());
		this.currentItemElectrodo.setConector(this.currentItemElectrodoBackup.getConector());
		this.currentItemElectrodo.setPolaridad(this.currentItemElectrodoBackup.getPolaridad());
		this.currentItemElectrodo.setFijacion(this.currentItemElectrodoBackup.getFijacion());
		this.currentItemElectrodo.setBobina(this.currentItemElectrodoBackup.getBobina());*/
		this.currentItemCateter.setCodigos(this.currentItemCateter.getCodigos());
		this.setCurrentItemCateter(new Cateter());
	}
	public void cambiarRegEvIncluir(ActionEvent e){
		if(this.currentItemRegistrador.getModelo().length()<=0){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("mat_msg_warn_add_2"));
			logger.error("("+this.usuario+") No se puede actualizar cateter. Es necesario especificar Modelo al cateter");
		}else{
			try{
				this.currentItemRegistrador.setRf(this.currentItemRegistrador.isRf_bol()?1:0);
				this.currentItemRegistrador.setMri(this.currentItemRegistrador.isMri_bol()?1:0);
				this.regdao.update(new RegistradoreventosPk(this.currentItemRegistrador.getIdregistrador()), this.currentItemRegistrador);
				this.guardaGS128Material(this.currentItemRegistrador.getCodigos(), this.currentItemRegistrador.getIdregistrador(), 4);
				// Notificacion por mail
				GestorCorreo gc = new GestorCorreo();
				gc.sendMailToAdminRegEv(this.currentItemRegistrador, this.nombre_centro, this.usuario, 2);
				this.setCurrentItemRegistrador(new Registradoreventos());
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO,this.bundle.getString("info_msg_editar_info"));
			}catch(Exception e1){
				this.setCurrentItemRegistrador(new Registradoreventos());
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_accion")+": "+ e1.getMessage());
			}
		}
	}
	public void cambiarRegEvCancelar(ActionEvent e){
		this.currentItemRegistrador.setModelo(this.currentItemRegistradorBackup.getModelo());
		this.currentItemRegistrador.setFabricante(this.currentItemRegistradorBackup.getFabricante());
		this.currentItemRegistrador.setModelo(this.currentItemRegistradorBackup.getModelo());
		this.currentItemRegistrador.setRf(this.currentItemRegistradorBackup.getRf());
		this.currentItemRegistrador.setMri(this.currentItemRegistradorBackup.getMri());
		this.currentItemRegistrador.setCodigos(this.currentItemRegistradorBackup.getCodigos());
		this.setCurrentItemRegistrador(new Registradoreventos());
	}
	
	public void exportarGeneradores(ActionEvent e){
		try{
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_Mat_Gen(this.generadores);
			logger.info("("+this.lf.getAcceso().getUsuario()+") Exportación de registros - Material: Generadores - Excel");
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede obtener datos exportados - Generador. Motivo: "+e1.getMessage(),e1);
		}
	}
	
	public void exportarElectrodos(ActionEvent e){
		try{
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_Mat_Ele(this.electrodos);
			logger.info("("+this.lf.getAcceso().getUsuario()+") Exportación de registros - Material: Electrodos - Excel");
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede obtener datos exportados - Electrodos. Motivo: "+e1.getMessage(),e1);
		}
	}
	
	public void exportarCateteres(ActionEvent e){
		try{
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_Mat_Cat(this.cats);
			logger.info("("+this.lf.getAcceso().getUsuario()+") Exportación de registros - Material: Cateteres - Excel");
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede obtener datos exportados - Cateteres. Motivo: "+e1.getMessage(),e1);
		}
	}
	
	public void exportarRegEventos(ActionEvent e){
		try{
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_Mat_RegEv(this.regs);
			logger.info("("+this.lf.getAcceso().getUsuario()+") Exportación de registros - Material: Registrador Eventos - Excel");
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede obtener datos exportados - Registrador Eventos. Motivo: "+e1.getMessage(),e1);
		}
	}
	
	/************************************************************
	 **************************** GET / SET *********************
	 ************************************************************/
	
	public ArrayList<SelectItem> getFabgen() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.fabgen)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getModogen() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.modogen)
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
	public ArrayList<SelectItem> getFabcat() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.fabcat)
			e.add(new SelectItem(el.getCodigo(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getTipoabl() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.tipoabl)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public ArrayList<SelectItem> getTipocurvadiag() {
		ArrayList<SelectItem> e = new ArrayList<SelectItem>();
		e.add(new SelectItem("", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras el : this.tipocurvadiag)
			e.add(new SelectItem(el.getValor(),
					el.getValor()));
		return e;
	}
	public void lecturaProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
		p.load(is);
		is.close();
		this.nombre_centro = p.getProperty("centro");
	}
	
	/*public void obtenerConexion(){
		try {
			this.conn = ResourceManager.getConnection();
		} catch (SQLException e1) {
			this.pintaMensaje(
					Mensaje.SEVERIDAD_ERROR,
					"No se puede obtener conexion con BD. Error: "
							+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede obtener conexion con BD. Error: "+ e1.getMessage());
		}
	}*/
	
	public void actualizarDaos(){
		//this.catdao.
	}
	
	public HtmlDataTable getBindingGenerador() {
		return bindingGenerador;
	}

	public void setBindingGenerador(HtmlDataTable bindingGenerador) {
		this.bindingGenerador = bindingGenerador;
	}

	public HtmlDataTable getBindingElectrodo() {
		return bindingElectrodo;
	}

	public void setBindingElectrodo(HtmlDataTable bindingElectrodo) {
		this.bindingElectrodo = bindingElectrodo;
	}
	public Generador[] getGeneradores() {
		return generadores;
	}
	public void setGeneradores(Generador[] generadores) {
		this.generadores = generadores;
	}
	public Electrodos[] getElectrodos() {
		return electrodos;
	}
	public void setElectrodos(Electrodos[] electrodos) {
		this.electrodos = electrodos;
	}
	public Integer getPagina_inicial() {
		return pagina_inicial;
	}
	public void setPagina_inicial(Integer pagina_inicial) {
		this.pagina_inicial = pagina_inicial;
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
	public boolean isRf() {
		return rf;
	}
	public void setRf(boolean rf) {
		this.rf = rf;
	}
	public boolean isMri() {
		return mri;
	}
	public void setMri(boolean mri) {
		this.mri = mri;
	}
	public Integer getPagina_inicial_elec() {
		return pagina_inicial_elec;
	}
	public void setPagina_inicial_elec(Integer pagina_inicial_elec) {
		this.pagina_inicial_elec = pagina_inicial_elec;
	}
	public Generador getCurrentItemGenerador() {
		return currentItemGenerador;
	}
	public void setCurrentItemGenerador(Generador currentItemGenerador) {
		this.currentItemGenerador = currentItemGenerador;
	}
	public Generador getCurrentItemGeneradorBackup() {
		return currentItemGeneradorBackup;
	}
	public void setCurrentItemGeneradorBackup(Generador currentItemGeneradorBackup) {
		this.currentItemGeneradorBackup = currentItemGeneradorBackup;
	}
	public Electrodos getCurrentItemElectrodo() {
		return currentItemElectrodo;
	}
	public void setCurrentItemElectrodo(Electrodos currentItemElectrodo) {
		this.currentItemElectrodo = currentItemElectrodo;
	}
	public Electrodos getCurrentItemElectrodoBackup() {
		return currentItemElectrodoBackup;
	}
	public void setCurrentItemElectrodoBackup(Electrodos currentItemElectrodoBackup) {
		this.currentItemElectrodoBackup = currentItemElectrodoBackup;
	}
	public Cateter getCat() {
		return cat;
	}
	public void setCat(Cateter cat) {
		this.cat = cat;
	}
	public Cateter getCurrentItemCateter() {
		return currentItemCateter;
	}
	public void setCurrentItemCateter(Cateter currentItemCateter) {
		this.currentItemCateter = currentItemCateter;
	}
	public Cateter getCurrentItemCateterBackup() {
		return currentItemCateterBackup;
	}
	public void setCurrentItemCateterBackup(Cateter currentItemCateterBackup) {
		this.currentItemCateterBackup = currentItemCateterBackup;
	}
	public Cateter[] getCats() {
		return cats;
	}
	public void setCats(Cateter[] cats) {
		this.cats = cats;
	}
	public Cateter getNuevocat() {
		return nuevocat;
	}
	public void setNuevocat(Cateter nuevocat) {
		this.nuevocat = nuevocat;
	}
	public HtmlDataTable getBindingCateter() {
		return bindingCateter;
	}
	public void setBindingCateter(HtmlDataTable bindingCateter) {
		this.bindingCateter = bindingCateter;
	}
	public Integer getPagina_inicial_cat() {
		return pagina_inicial_cat;
	}
	public void setPagina_inicial_cat(Integer pagina_inicial_cat) {
		this.pagina_inicial_cat = pagina_inicial_cat;
	}
	public Generador getGen() {
		return gen;
	}
	public void setGen(Generador gen) {
		this.gen = gen;
	}
	public Generador getNuevogen() {
		return nuevogen;
	}
	public void setNuevogen(Generador nuevogen) {
		this.nuevogen = nuevogen;
	}
	public Electrodos getEl() {
		return el;
	}
	public void setEl(Electrodos el) {
		this.el = el;
	}
	public Electrodos getNuevoel() {
		return nuevoel;
	}
	public void setNuevoel(Electrodos nuevoel) {
		this.nuevoel = nuevoel;
	}
	public HtmlDataTable getBindingRegEventos() {
		return bindingRegEventos;
	}
	public void setBindingRegEventos(HtmlDataTable bindingRegEventos) {
		this.bindingRegEventos = bindingRegEventos;
	}
	public Registradoreventos getReg() {
		return reg;
	}
	public void setReg(Registradoreventos reg) {
		this.reg = reg;
	}
	public Registradoreventos getNuevoreg() {
		return nuevoreg;
	}
	public void setNuevoreg(Registradoreventos nuevoreg) {
		this.nuevoreg = nuevoreg;
	}
	public Registradoreventos[] getRegs() {
		return regs;
	}
	public void setRegs(Registradoreventos[] regs) {
		this.regs = regs;
	}
	public Integer getPagina_inicial_reg() {
		return pagina_inicial_reg;
	}
	public void setPagina_inicial_reg(Integer pagina_inicial_reg) {
		this.pagina_inicial_reg = pagina_inicial_reg;
	}
	public Registradoreventos getCurrentItemRegistrador() {
		return currentItemRegistrador;
	}
	public void setCurrentItemRegistrador(Registradoreventos currentItemRegistrador) {
		this.currentItemRegistrador = currentItemRegistrador;
	}
	public Registradoreventos getCurrentItemRegistradorBackup() {
		return currentItemRegistradorBackup;
	}
	public void setCurrentItemRegistradorBackup(
			Registradoreventos currentItemRegistradorBackup) {
		this.currentItemRegistradorBackup = currentItemRegistradorBackup;
	}
	public HtmlDataTable getBindingRegEventosGs128() {
		return bindingRegEventosGs128;
	}
	public void setBindingRegEventosGs128(HtmlDataTable bindingRegEventosGs128) {
		this.bindingRegEventosGs128 = bindingRegEventosGs128;
	}
	public Integer getTotalgen() {
		return totalgen;
	}
	public void setTotalgen(Integer totalgen) {
		this.totalgen = totalgen;
	}
	public Integer getTotalelec() {
		return totalelec;
	}
	public void setTotalelec(Integer totalelec) {
		this.totalelec = totalelec;
	}
	public Integer getTotalcat() {
		return totalcat;
	}
	public void setTotalcat(Integer totalcat) {
		this.totalcat = totalcat;
	}
	public Integer getTotalreg() {
		return totalreg;
	}
	public void setTotalreg(Integer totalreg) {
		this.totalreg = totalreg;
	}
	public HtmlDataTable getBindingGeneradorGs128() {
		return bindingGeneradorGs128;
	}
	public void setBindingGeneradorGs128(HtmlDataTable bindingGeneradorGs128) {
		this.bindingGeneradorGs128 = bindingGeneradorGs128;
	}
	public HtmlDataTable getBindingElectrodoGs128() {
		return bindingElectrodoGs128;
	}
	public void setBindingElectrodoGs128(HtmlDataTable bindingElectrodoGs128) {
		this.bindingElectrodoGs128 = bindingElectrodoGs128;
	}
	public HtmlDataTable getBindingCateterGs128() {
		return bindingCateterGs128;
	}
	public void setBindingCateterGs128(HtmlDataTable bindingCateterGs128) {
		this.bindingCateterGs128 = bindingCateterGs128;
	}
	
}

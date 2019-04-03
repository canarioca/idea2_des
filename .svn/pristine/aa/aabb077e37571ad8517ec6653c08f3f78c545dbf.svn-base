package com.sorin.idea.iu;

import hvn.cm.modelo.Mensaje;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.richfaces.component.html.HtmlDataGrid;

import com.sorin.idea.dao.ComplicacionesDao;
import com.sorin.idea.dao.ComplicacionesPacientesDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dto.ArrAccesoModulos;
import com.sorin.idea.dto.Complicacion;
import com.sorin.idea.dto.Complicaciones;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.ComplicacionesPacientesPk;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.exceptions.ComplicacionesPacientesDaoException;
import com.sorin.idea.jdbc.ComplicacionesDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesPacientesDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.util.ImplanteSeguimientoBean;
import com.sorin.idea.util.UtilFechas;


public class ControlComplicaciones extends BaseIU{
	
	private static Logger logger = Logger.getLogger(ControlComplicaciones.class);
	private LoginForm lf;
	private String usuario;
	
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private ControlPacientes cp;
	
	private HtmlDataTable bindingComplicaciones;
	private HtmlDataTable bindingComplicacionesNoRes;
	private HtmlDataGrid bindingPrevios;
	
	private String columna = "fecha";
	private boolean ascendente = false;
	
	private ComplicacionesDao compdao;
	private Complicaciones[] complicaciones;
	private ComplicacionesPacientesDao compacdao;
	private ComplicacionesPacientes compli;
	private ArrayList<ComplicacionesPacientes> listacompac;
	private ArrayList<ComplicacionesPacientes> listacompacnores;
	private ArrayList<ComplicacionesPacientes> listacompacproc;
	
	private ComplicacionesPacientes[] listacompl;
	
	private ComplicacionesPacientes currentCompl;
	private ComplicacionesPacientes currentComplProc;
	private Integer idcompotra;
	private Integer idarritmias;
	private Integer idhematoma;
	private Integer idarritmiasCVE;
	private Integer idhematomaCVE;
	private Integer idBavEEFDiag;
	private Integer idEmbEEFDiag;
	private Integer idDerrPerEEFDiag;
	private Integer idTEPEEFDiag;
	private Integer idVascEEFDiag;
	
	private boolean editable;
	private boolean selProc;
	private Integer selTipoProc;
	
	private ProcedimientoDao procdao;
	private ArrayList<Procedimiento> listaprocsdisp;
	private ArrayList<Procedimiento> procSel;
	
	/*************************/
	
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
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) 
				cp = new ControlPacientes();
			
			this.compdao = new ComplicacionesDaoImpl(this.usuario);
			this.compacdao = new ComplicacionesPacientesDaoImpl(this.usuario);
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			
			this.compli = new ComplicacionesPacientes();
			this.compli.setIdrelacion(0);
			this.currentCompl = new ComplicacionesPacientes();
			this.listacompac = new ArrayList<ComplicacionesPacientes>();
			this.listacompacnores = new ArrayList<ComplicacionesPacientes>();
			this.listacompacproc = new ArrayList<ComplicacionesPacientes>();
			this.listaprocsdisp = new ArrayList<Procedimiento>();
			this.setSelTipoProc(0);
			
			this.cargaComplicaciones();
			this.obtenerComplicacionesPaciente();
			
			this.setSelProc(false);
			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_pat")+": " + e1.getMessage());
		}
	}
	
	/**
	 * Va a cargar las complicaciones en funcion de los modulos que tenga habilitados
	 *  Ámbito = 0 -> comun
	 *  Ámbito = 1 -> EEF
	 *  Ámbito = 2 -> EEF
	 *  Ámbito = 3 -> Implante de dispositivo + Reg. Eventos
	 *  Ámbito = 5 -> CVE
 	 */
	public void cargaComplicaciones() {
		try {
			this.complicaciones = this.compdao.findAll();
			// obtener el id de otras complicaciones: item general y comun
			for(Complicaciones c:this.complicaciones){
				if(c.getAmbito().equals(0))
					this.idcompotra = c.getIdcomplicacion();
				if(c.getNombre().toUpperCase().startsWith("ARRITMIAS") && c.getAmbito().equals(3))
					this.idarritmias = c.getIdcomplicacion();
				if(c.getNombre().toUpperCase().startsWith("ARRITMIAS") && c.getAmbito().equals(5))
					this.idarritmiasCVE = c.getIdcomplicacion();
				if(c.getNombre().toUpperCase().startsWith("HEMATO") && c.getAmbito().equals(3))
					this.idhematoma = c.getIdcomplicacion();
				if(c.getNombre().toUpperCase().startsWith("HEMATO") && c.getAmbito().equals(5))
					this.idhematomaCVE = c.getIdcomplicacion();
				if(c.getNombre().toUpperCase().startsWith("BLOQ") && c.getNombre().toUpperCase().contains("AV")  && c.getAmbito().equals(2))
					this.idBavEEFDiag = c.getIdcomplicacion();
				if(c.getNombre().toUpperCase().startsWith("EMBO") && c.getAmbito().equals(2))
					this.idEmbEEFDiag = c.getIdcomplicacion();
				if(c.getNombre().toUpperCase().startsWith("DERR") && c.getAmbito().equals(2))
					this.idDerrPerEEFDiag = c.getIdcomplicacion();
				if(c.getNombre().toUpperCase().startsWith("TEP") && c.getAmbito().equals(2))
					this.idTEPEEFDiag = c.getIdcomplicacion();
				if(c.getNombre().toUpperCase().startsWith("VASC") && c.getAmbito().equals(2))
					this.idVascEEFDiag = c.getIdcomplicacion();
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_compl")+": "+ e1.getMessage());
		}
	}
	
	public void obtenerComplicacionesPaciente(){
		try{
			String res = "";
			this.listacompac.clear();
			this.listacompacnores.clear();
			ComplicacionesPacientes[] comps = this.compacdao.findWhereIdpacienteEquals(cp.getPacienteSelect().getCodigo());
			Procedimiento pr = null;
			for(ComplicacionesPacientes c:comps){
				pr = this.procdao.findByPrimaryKey(c.getIdprocedimiento(), c.getTipoprocedimiento());
				if(pr!=null)
					c.setFechaProc(pr.getFecha());
				this.listacompac.add(c);
				if(c.getResuelta()!=null && c.getResuelta().equals(0)){
					Complicaciones cmp = this.compdao.findByPrimaryKey(c.getComplicacion());
					res = res + cmp.getNombre()+",";
					this.listacompacnores.add(c);
				}
			}
			if(res.endsWith(",") && res.length()>0)
				res = res.substring(0,res.length()-1);
			this.cp.getPacienteSelect().setResumenCompl(res);
		}catch(Exception e1){
			
		}
	}
	
	public void obtenerComplicacionesPacienteProc(Integer idproc, Integer tipoproc){
		try{
			this.listacompacproc.clear();
			ComplicacionesPacientes[] comps = this.compacdao.findByDynamicWhere("IDPACIENTE = ? AND IDPROCEDIMIENTO = ? AND TIPOPROCEDIMIENTO = ?",
					new Object[]{cp.getPacienteSelect().getCodigo(), idproc, tipoproc});
			for(ComplicacionesPacientes c:comps)
				this.listacompacproc.add(c);
		}catch(Exception e1){
			
		}
	}
	
	public void obtenerComplicacionesPacienteProc(Integer codigo, Integer idproc, Integer tipoproc){
		try{
			this.listacompacproc.clear();
			ComplicacionesPacientes[] comps = this.compacdao.findByDynamicWhere("IDPACIENTE = ? AND IDPROCEDIMIENTO = ? AND TIPOPROCEDIMIENTO = ?",
					new Object[]{codigo, idproc, tipoproc});
			for(ComplicacionesPacientes c:comps)
				this.listacompacproc.add(c);
		}catch(Exception e1){
			
		}
	}
	
	public void addItemComplicacion(ActionEvent e){
		try{
			if(validar(this.compli)){
				this.compli.setIdpaciente(cp.getPacienteSelect().getCodigo());
				this.compacdao.insert(this.compli);
				this.listacompac.add(this.compli);
				if(this.compli.getResuelta()!=null && this.compli.getResuelta().equals(0))
					this.listacompacnores.add(this.compli);
				this.compli = new ComplicacionesPacientes();
				this.obtenerComplicacionesPaciente();
				cp.precarga(null);// se llama a precarga para actualizar datos de linea temporal
				logger.info("("+this.usuario+") Inserción de nueva complicación para paciente. Id Paciente: "+cp.getPacienteSelect().getCodigo());
				this.pintaMensaje(INFO, this.bundle.getString("compli_msg_info_add"));
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("compli_msg_error_add")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en inserción de nueva complicacion. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}	
	}
	
	public void addItemComplicacion(ComplicacionesPacientes c){
		try{
			if(validar(c)){
				this.compacdao.insert(c);
				this.listacompac.add(c);
				this.listacompacproc.add(c);
				if(c.getResuelta()!=null && c.getResuelta().equals(0))
					this.listacompacnores.add(c);
				this.obtenerComplicacionesPaciente(); 
				logger.info("("+this.usuario+") Inserción de nueva complicación para paciente. Id Paciente: "+cp.getPacienteSelect().getCodigo());
				this.pintaMensaje(INFO, this.bundle.getString("compli_msg_info_add"));
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("compli_msg_error_add")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en inserción de nueva complicacion. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}	
	}
	
	public Integer addItemComplicacionEEF(ComplicacionesPacientes c){
		try{
			if(validar(c)){
				ComplicacionesPacientesPk cpk = this.compacdao.insert(c);
				this.listacompac.add(c);
				this.listacompacproc.add(c);
				if(c.getResuelta()!=null && c.getResuelta().equals(0))
					this.listacompacnores.add(c);
				this.obtenerComplicacionesPaciente(); 
				logger.info("("+this.usuario+") Inserción de nueva complicación para paciente. Id Paciente: "+cp.getPacienteSelect().getCodigo());
				this.pintaMensaje(INFO, this.bundle.getString("compli_msg_info_add"));
				return cpk.getIdcompac();
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("compli_msg_error_add")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en inserción de nueva complicacion. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
		return null;
	}
	
	public void editItemComplicacion(ActionEvent e){
		try{
			if(validar(this.currentCompl)){
				if(this.currentCompl.getResuelta()!=null && this.currentCompl.getResuelta().equals(0))
					this.currentCompl.setFechafin(null);
				this.compacdao.update(new ComplicacionesPacientesPk(this.currentCompl.getIdcompac()),this.currentCompl);
				this.obtenerComplicacionesPaciente();// Recuperacion de lista completa asociada a paciente
				cp.precarga(null);// se llama a precarga para actualizar datos de linea temporal
				this.setEditable(false);
				logger.info("("+this.usuario+") Complicación actualizada con éxito. Id Paciente: "+cp.getPacienteSelect().getCodigo());
				this.pintaMensaje(INFO, this.bundle.getString("compli_msg_info_edit"));
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("compli_msg_error_edit")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en actualización de complicación de paciente. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	
	public void editItemComplicacion(ComplicacionesPacientes cpac){
		try{
			if(validar(cpac)){
				if(cpac.getResuelta()!=null && cpac.getResuelta().equals(0))
					cpac.setFechafin(null);
				this.compacdao.update(new ComplicacionesPacientesPk(cpac.getIdcompac()),cpac);
				this.obtenerComplicacionesPaciente();// Recuperacion de lista completa asociada a paciente
				logger.info("("+this.usuario+") Complicación actualizada con éxito. Id Paciente: "+cp.getPacienteSelect().getCodigo());
				this.pintaMensaje(INFO, this.bundle.getString("compli_msg_info_edit"));
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("compli_msg_error_edit")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en actualización de complicación de paciente. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	
	public void delItemComplicacion(ActionEvent e){
		try {
			Integer pos = this.bindingComplicaciones.getRowIndex();
			this.compacdao.delete(new ComplicacionesPacientesPk(this.listacompac.get(pos).getIdcompac()));
			this.listacompac.remove(pos);
			this.obtenerComplicacionesPaciente();
			cp.precarga(null);// se llama a precarga para actualizar datos de linea temporal
			this.pintaMensaje(INFO, this.bundle.getString("compli_msg_info_borra"));
			logger.info("("+this.usuario+") Complicación eliminada con éxito del sistema. Id Paciente: "+cp.getPacienteSelect().getCodigo());
		} catch (ComplicacionesPacientesDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("compli_msg_error_borrar")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en borrado complicación. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	
	public void delItemComplicacion(ComplicacionesPacientes compac){
		try {
			this.compacdao.delete(new ComplicacionesPacientesPk(compac.getIdcompac()));
			this.obtenerComplicacionesPaciente();
			this.pintaMensaje(INFO, this.bundle.getString("compli_msg_info_borra"));
			logger.info("("+this.usuario+") Complicación eliminada con éxito del sistema. Id Paciente: "+cp.getPacienteSelect().getCodigo());
		} catch (ComplicacionesPacientesDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("compli_msg_error_borrar")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en borrado complicación. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	
	public boolean validar(ComplicacionesPacientes c){
		if(c.getComplicacion()==null || c.getComplicacion()<=0){
			this.pintaMensaje(ERROR, this.bundle.getString("compli_msg_warn_guarda_1"));
			return false;
		}
		if(c.getTipo()==null || c.getTipo()<=0){
			this.pintaMensaje(ERROR, this.bundle.getString("compli_msg_warn_guarda_2"));
			return false;
		}
		if(c.getResuelta()==null || c.getTipo()<=0){
			this.pintaMensaje(ERROR, this.bundle.getString("compli_msg_warn_guarda_3"));
			return false;
		}
		if(c.getFechaini()==null){
			this.pintaMensaje(ERROR, this.bundle.getString("compli_msg_warn_guarda_4"));
			return false;
		}
		return true;
	}
	
	public void limpiar(ActionEvent e){
		this.compli = new ComplicacionesPacientes();
	}
	
	public void cancelarItemComplicacion(ActionEvent e){
		this.setEditable(false);
	}
	
	public void preEditar(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		ComplicacionesPacientes aux = this.getListacompac().get(this.bindingComplicaciones.getRowIndex());	
		this.currentCompl.setIdcompac(aux.getIdcompac());
		this.currentCompl.setIdpaciente(aux.getIdpaciente());
		this.currentCompl.setTipo(aux.getTipo());
		this.currentCompl.setIdprocedimiento(aux.getIdprocedimiento());
		this.currentCompl.setTipoprocedimiento(aux.getTipoprocedimiento());
		this.currentCompl.setComplicacion(aux.getComplicacion());
		this.currentCompl.setComplicacion1(aux.getComplicacion1());
		this.currentCompl.setComplicacion2(aux.getComplicacion2());
		this.currentCompl.setComplicacionOtra(aux.getComplicacionOtra());
		this.currentCompl.setIdrelacion(aux.getIdrelacion());
		this.currentCompl.setIdlugar(aux.getIdlugar());
		this.currentCompl.setFechaini(aux.getFechaini());
		this.currentCompl.setFechafin(aux.getFechafin());
		this.currentCompl.setResuelta(aux.getResuelta());
		this.currentCompl.setResueltaOtros(aux.getResueltaOtros());
		this.currentCompl.setTratamiento(aux.getTratamiento());
		this.currentCompl.setTratamientoDescr(aux.getTratamientoDescr());
		this.currentCompl.setTratamientoTipo(aux.getTratamientoTipo());
		this.currentCompl.setIngreso(aux.getIngreso());
		this.currentCompl.setDescripcion(aux.getDescripcion());
		this.currentCompl.setFechaProc(aux.getFechaProc());
		this.setEditable(true);
	}

	public ComplicacionesPacientes preEditar(ComplicacionesPacientes aux){
		ComplicacionesPacientes res = new ComplicacionesPacientes();
		res.setIdcompac(aux.getIdcompac());
		res.setIdpaciente(aux.getIdpaciente());
		res.setTipo(aux.getTipo());
		res.setIdprocedimiento(aux.getIdprocedimiento());
		res.setTipoprocedimiento(aux.getTipoprocedimiento());
		res.setComplicacion(aux.getComplicacion());
		res.setComplicacion1(aux.getComplicacion1());
		res.setComplicacion2(aux.getComplicacion2());
		res.setComplicacionOtra(aux.getComplicacionOtra());
		res.setIdrelacion(aux.getIdrelacion());
		res.setIdlugar(aux.getIdlugar());
		res.setFechaini(aux.getFechaini());
		res.setFechafin(aux.getFechafin());
		res.setResuelta(aux.getResuelta());
		res.setResueltaOtros(aux.getResueltaOtros());
		res.setTratamiento(aux.getTratamiento());
		res.setTratamientoDescr(aux.getTratamientoDescr());
		res.setTratamientoTipo(aux.getTratamientoTipo());
		res.setIngreso(aux.getIngreso());
		res.setDescripcion(aux.getDescripcion());
		res.setFechaProc(aux.getFechaProc());
		return res;
	}
	
	public void preEditarNoRes(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		ComplicacionesPacientes aux = this.getListacompacnores().get(this.bindingComplicacionesNoRes.getRowIndex());	
		this.currentCompl.setIdcompac(aux.getIdcompac());
		this.currentCompl.setIdpaciente(aux.getIdpaciente());
		this.currentCompl.setTipo(aux.getTipo());
		this.currentCompl.setIdprocedimiento(aux.getIdprocedimiento());
		this.currentCompl.setTipoprocedimiento(aux.getTipoprocedimiento());
		this.currentCompl.setComplicacion(aux.getComplicacion());
		this.currentCompl.setComplicacion1(aux.getComplicacion1());
		this.currentCompl.setComplicacion2(aux.getComplicacion2());
		this.currentCompl.setComplicacionOtra(aux.getComplicacionOtra());
		this.currentCompl.setIdrelacion(aux.getIdrelacion());
		this.currentCompl.setIdlugar(aux.getIdlugar());
		this.currentCompl.setFechaini(aux.getFechaini());
		this.currentCompl.setFechafin(aux.getFechafin());
		this.currentCompl.setResuelta(aux.getResuelta());
		this.currentCompl.setResueltaOtros(aux.getResueltaOtros());
		this.currentCompl.setTratamiento(aux.getTratamiento());
		this.currentCompl.setTratamientoDescr(aux.getTratamientoDescr());
		this.currentCompl.setTratamientoTipo(aux.getTratamientoTipo());
		this.currentCompl.setIngreso(aux.getIngreso());
		this.currentCompl.setDescripcion(aux.getDescripcion());
		this.currentCompl.setFechaProc(aux.getFechaProc());
		this.setEditable(true);
	}
	
	public void obtenerProcedimientosPaciente(ActionEvent e){
		try{
			// 1. Se obtiene la referencia del objeto complicacion a editar
			this.currentComplProc = this.preEditar(this.getListacompac().get(this.bindingComplicaciones.getRowIndex()));
			// 2. Se cargan los datos asociados
			this.listaprocsdisp.clear();
			Procedimiento[] procs = this.procdao.findWhereCodigoEquals(cp.getPacienteSelect().getCodigo());
			for(Procedimiento p:procs){
				if(this.lf.getAccmods().getEef()!=null && this.lf.getAccmods().getEef().equals(1) && p.getTipoprocedimiento().equals(1061))
					this.listaprocsdisp.add(p);
				if(this.lf.getAccmods().getImplante()!=null && this.lf.getAccmods().getImplante().equals(1) 
						&& (p.getTipoprocedimiento().equals(993) || p.getTipoprocedimiento().equals(956) 
								|| p.getTipoprocedimiento().equals(957) || p.getTipoprocedimiento().equals(1059) 
								|| p.getTipoprocedimiento().equals(1060) || p.getTipoprocedimiento().equals(1090) 
								|| p.getTipoprocedimiento().equals(1085) || p.getTipoprocedimiento().equals(1086) 
								|| p.getTipoprocedimiento().equals(1147) || p.getTipoprocedimiento().equals(983)))
					this.listaprocsdisp.add(p);
				if(this.lf.getAccmods().getCv()!=null && this.lf.getAccmods().getCv().equals(1) && p.getTipoprocedimiento().equals(1068))
					this.listaprocsdisp.add(p);
				if(this.lf.getAccmods().getRegistrador()!=null && this.lf.getAccmods().getRegistrador().equals(1) 
						&& (p.getTipoprocedimiento().equals(1067) || p.getTipoprocedimiento().equals(1088)))
					this.listaprocsdisp.add(p);
				if(p.getTipoprocedimiento().equals(1087))
					this.listaprocsdisp.add(p);
			}
			// 3. Ordenacion de procedimiento temporalmente: mas reciente a mas antiguo
			Collections.sort(this.listaprocsdisp, new Comparator() {
				public int compare(Object o1, Object o2) {
					Procedimiento e1 = (Procedimiento) o1;
					Procedimiento e2 = (Procedimiento) o2;
					if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())<=0) {
						return 1;
					} else if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())>0) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			this.setSelProc(true);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("compli_msg_error_consulta_proc")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en consulta de procedimientos de paciente. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	
	public void selProc(ActionEvent e){
		try{
			Procedimiento cpat = this.listaprocsdisp.get(this.bindingPrevios.getRowIndex());
			this.currentComplProc.setIdprocedimiento(cpat.getIdprocedimiento());
			this.currentComplProc.setTipoprocedimiento(cpat.getTipoprocedimiento());
			this.compacdao.update(this.currentComplProc.createPk(), this.currentComplProc);
			this.obtenerComplicacionesPaciente();// Recuperacion de lista completa asociada a paciente
			this.pintaMensaje(INFO, this.bundle.getString("compli_edit_proc_sel_info"));
			logger.info("("+this.usuario+") Procedimiento asociado con éxito a la complicación. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". IdComplicacion: "+this.currentCompl.getIdcompac()+". IdProcedimiento: "+cpat.getIdprocedimiento());
			this.currentComplProc = new ComplicacionesPacientes();
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("compli_edit_proc_sel_error")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en asociación de procedimientos a complicación. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	
	public void deselProc(ActionEvent e){
		try{
			// 1. Se obtiene la referencia del objeto complicacion a editar
			this.currentComplProc = this.preEditar(this.getListacompac().get(this.bindingComplicaciones.getRowIndex()));
			this.currentComplProc.setIdprocedimiento(null);
			this.currentComplProc.setTipoprocedimiento(null);
			this.compacdao.update(this.currentComplProc.createPk(), this.currentComplProc);
			this.obtenerComplicacionesPaciente();// Recuperacion de lista completa asociada a paciente
			this.pintaMensaje(INFO, this.bundle.getString("compli_edit_proc_desel_info"));
			logger.info("("+this.usuario+") Procedimiento desasociado con éxito de la complicación. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". IdComplicacion: "+this.currentCompl.getIdcompac());
			this.currentComplProc = new ComplicacionesPacientes();
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("compli_edit_proc_desel_error")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en desasociación de complicación a procedimiento. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	
	/******************************************************************
	 * 					Controles de formulario
	 * ****************************************************************
	 */
	
	public void addComplicaciones(ActionEvent e) {
		this.getListacompac().add(new ComplicacionesPacientes());
	}

	public void delComplicaciones(ActionEvent e) {
		this.getListacompac().remove(this.getBindingComplicaciones().getRowIndex());
	}
	
	public void controlComp(ActionEvent e){
		int dup=0;
		for(ComplicacionesPacientes s:this.listacompac){
			if(s.getComplicacion() == this.listacompac.get(this.bindingComplicaciones.getRowIndex()).getComplicacion())
				dup++;
			if(dup>1){
				// Duplicado
				this.listacompac.remove(this.bindingComplicaciones.getRowIndex());
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("info_msg_warn_compl_dupl"));
				break;
			}
		}
	}

	/*
	 * ****************************************************************
	 * ************************ GET/SET *****************************
	 * **************************************************************
	 */
	
	public ArrayList<SelectItem> getModulosDisponibles(){
		ArrayList<SelectItem> mods = new ArrayList<SelectItem>();
		mods.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		if(this.lf.getAccmods().getEef()!=null && this.lf.getAccmods().getEef().equals(1)){
			//mods.add(new SelectItem(1, "EEF-Ablación"));
			mods.add(new SelectItem(7, "EEF-Diagnóstico"));
		}		
		if(this.lf.getAccmods().getImplante()!=null && this.lf.getAccmods().getImplante().equals(1)){
			mods.add(new SelectItem(2, "Implante de dispositivo"));
			mods.add(new SelectItem(3, "Seguimiento de dispositivo"));
		}
		if(this.lf.getAccmods().getRegistrador()!=null && this.lf.getAccmods().getRegistrador().equals(1)){
			mods.add(new SelectItem(4, "Registrador de eventos"));
			mods.add(new SelectItem(5, "Seguimiento de registrador de eventos"));
		}
		if(this.lf.getAccmods().getCv()!=null && this.lf.getAccmods().getCv().equals(1))
			mods.add(new SelectItem(6, "CVE"));
		return mods;
	}
	
	public ArrayList<SelectItem> getComplicacionesTodas() {
		ArrayList<SelectItem> compl = new ArrayList<SelectItem>();
		compl.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicaciones c : this.complicaciones){
			if(c.getAmbito().equals(3) 
					&& ((lf.getAccmods().getImplante()!=null && lf.getAccmods().getImplante().equals(1))
							|| (lf.getAccmods().getRegistrador()!=null && lf.getAccmods().getRegistrador().equals(1))))
				compl.add(new SelectItem(c.getIdcomplicacion(), c.getNombre()));
			else if((c.getAmbito().equals(1) || c.getAmbito().equals(2)) 
					&& lf.getAccmods().getEef()!=null && lf.getAccmods().getEef().equals(1))
				compl.add(new SelectItem(c.getIdcomplicacion(), c.getNombre()));
			else if(c.getAmbito().equals(5) && (lf.getAccmods().getCv()!=null && lf.getAccmods().getCv().equals(1)))
				compl.add(new SelectItem(c.getIdcomplicacion(), c.getNombre()));
			if(c.getAmbito().equals(0))
				compl.add(new SelectItem(c.getIdcomplicacion(), c.getNombre()));
		}
			
		return compl;
	}
	
	public ArrayList<SelectItem> getComplicacionesEefTodas() {
		ArrayList<SelectItem> compl = new ArrayList<SelectItem>();
		compl.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicaciones c : this.complicaciones)
			if(c.getAmbito().equals(1) || c.getAmbito().equals(2) || c.getAmbito().equals(0))
				compl.add(new SelectItem(c.getIdcomplicacion(), c.getNombre()));
		return compl;
	}
	
	public ArrayList<SelectItem> getComplicacionesEefAbl() {
		ArrayList<SelectItem> compl = new ArrayList<SelectItem>();
		compl.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicaciones c : this.complicaciones)
			if(c.getAmbito().equals(1) || c.getAmbito().equals(0))
				compl.add(new SelectItem(c.getIdcomplicacion(), c.getNombre()));
		return compl;
	}
	
	public ArrayList<SelectItem> getComplicacionesEefDiag() {
		ArrayList<SelectItem> compl = new ArrayList<SelectItem>();
		compl.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicaciones c : this.complicaciones)
			if(c.getAmbito().equals(2) || c.getAmbito().equals(0))
				compl.add(new SelectItem(c.getIdcomplicacion(), c.getNombre()));
		return compl;
	}
	
	public ArrayList<SelectItem> getComplicacionesImpl() {
		ArrayList<SelectItem> compl = new ArrayList<SelectItem>();
		compl.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicaciones c : this.complicaciones)
			if(c.getAmbito().equals(3) || c.getAmbito().equals(0))
				compl.add(new SelectItem(c.getIdcomplicacion(), c.getNombre()));
		return compl;
	}
	
	public ArrayList<SelectItem> getComplicacionesCve() {
		ArrayList<SelectItem> compl = new ArrayList<SelectItem>();
		compl.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Complicaciones c : this.complicaciones)
			if(c.getAmbito().equals(5) || c.getAmbito().equals(0))
				compl.add(new SelectItem(c.getIdcomplicacion(), c.getNombre()));
		return compl;
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

	public Complicaciones[] getComplicaciones() {
		return complicaciones;
	}

	public void setComplicaciones(Complicaciones[] complicaciones) {
		this.complicaciones = complicaciones;
	}

	public HtmlDataTable getBindingComplicaciones() {
		return bindingComplicaciones;
	}

	public void setBindingComplicaciones(HtmlDataTable bindingComplicaciones) {
		this.bindingComplicaciones = bindingComplicaciones;
	}

	public HtmlDataGrid getBindingPrevios() {
		return bindingPrevios;
	}

	public void setBindingPrevios(HtmlDataGrid bindingPrevios) {
		this.bindingPrevios = bindingPrevios;
	}

	public ArrayList<ComplicacionesPacientes> getListacompac() {
		return listacompac;
	}

	public void setListacompac(ArrayList<ComplicacionesPacientes> listacompac) {
		this.listacompac = listacompac;
	}

	public ComplicacionesPacientes getCurrentCompl() {
		return currentCompl;
	}

	public void setCurrentCompl(ComplicacionesPacientes currentCompl) {
		this.currentCompl = currentCompl;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public ComplicacionesPacientes getCompli() {
		return compli;
	}

	public void setCompli(ComplicacionesPacientes compli) {
		this.compli = compli;
	}

	public ComplicacionesPacientes[] getListacompl() {
		return listacompl;
	}

	public void setListacompl(ComplicacionesPacientes[] listacompl) {
		this.listacompl = listacompl;
	}

	public Integer getIdcompotra() {
		return idcompotra;
	}

	public void setIdcompotra(Integer idcompotra) {
		this.idcompotra = idcompotra;
	}

	public Integer getIdarritmias() {
		return idarritmias;
	}

	public void setIdarritmias(Integer idarritmias) {
		this.idarritmias = idarritmias;
	}

	public Integer getIdhematoma() {
		return idhematoma;
	}

	public void setIdhematoma(Integer idhematoma) {
		this.idhematoma = idhematoma;
	}

	public ArrayList<ComplicacionesPacientes> getListacompacnores() {
		return listacompacnores;
	}

	public void setListacompacnores(ArrayList<ComplicacionesPacientes> listacompacnores) {
		this.listacompacnores = listacompacnores;
	}

	public HtmlDataTable getBindingComplicacionesNoRes() {
		return bindingComplicacionesNoRes;
	}

	public void setBindingComplicacionesNoRes(HtmlDataTable bindingComplicacionesNoRes) {
		this.bindingComplicacionesNoRes = bindingComplicacionesNoRes;
	}

	public ArrayList<ComplicacionesPacientes> getListacompacproc() {
		return listacompacproc;
	}

	public void setListacompacproc(ArrayList<ComplicacionesPacientes> listacompacproc) {
		this.listacompacproc = listacompacproc;
	}

	public boolean isSelProc() {
		return selProc;
	}

	public void setSelProc(boolean selProc) {
		this.selProc = selProc;
	}

	public ArrayList<Procedimiento> getListaprocsdisp() {
		return listaprocsdisp;
	}

	public void setListaprocsdisp(ArrayList<Procedimiento> listaprocsdisp) {
		this.listaprocsdisp = listaprocsdisp;
	}

	public ArrayList<Procedimiento> getProcSel() {
		return procSel;
	}

	public void setProcSel(ArrayList<Procedimiento> procSel) {
		this.procSel = procSel;
	}

	public ComplicacionesPacientes getCurrentComplProc() {
		return currentComplProc;
	}

	public void setCurrentComplProc(ComplicacionesPacientes currentComplProc) {
		this.currentComplProc = currentComplProc;
	}

	public Integer getIdarritmiasCVE() {
		return idarritmiasCVE;
	}

	public void setIdarritmiasCVE(Integer idarritmiasCVE) {
		this.idarritmiasCVE = idarritmiasCVE;
	}

	public Integer getIdhematomaCVE() {
		return idhematomaCVE;
	}

	public void setIdhematomaCVE(Integer idhematomaCVE) {
		this.idhematomaCVE = idhematomaCVE;
	}

	public Integer getIdBavEEFDiag() {
		return idBavEEFDiag;
	}

	public void setIdBavEEFDiag(Integer idBavEEFDiag) {
		this.idBavEEFDiag = idBavEEFDiag;
	}

	public Integer getIdEmbEEFDiag() {
		return idEmbEEFDiag;
	}

	public void setIdEmbEEFDiag(Integer idEmbEEFDiag) {
		this.idEmbEEFDiag = idEmbEEFDiag;
	}

	public Integer getIdDerrPerEEFDiag() {
		return idDerrPerEEFDiag;
	}

	public void setIdDerrPerEEFDiag(Integer idDerrPerEEFDiag) {
		this.idDerrPerEEFDiag = idDerrPerEEFDiag;
	}

	public Integer getIdTEPEEFDiag() {
		return idTEPEEFDiag;
	}

	public void setIdTEPEEFDiag(Integer idTEPEEFDiag) {
		this.idTEPEEFDiag = idTEPEEFDiag;
	}

	public Integer getIdVascEEFDiag() {
		return idVascEEFDiag;
	}

	public void setIdVascEEFDiag(Integer idVascEEFDiag) {
		this.idVascEEFDiag = idVascEEFDiag;
	}

	public Integer getSelTipoProc() {
		return selTipoProc;
	}

	public void setSelTipoProc(Integer selTipoProc) {
		this.selTipoProc = selTipoProc;
	}

	
}

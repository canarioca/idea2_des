package com.sorin.idea.iu;

import hvn.cm.modelo.Mensaje;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;

import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.ProtSincopeAltaDao;
import com.sorin.idea.dao.ProtSincopeDao;
import com.sorin.idea.dao.ProtSincopeValCardDao;
import com.sorin.idea.dao.ProtocolosDao;
import com.sorin.idea.dao.ProtocolosProcedimientosDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProtSincope;
import com.sorin.idea.dto.ProtSincopeAlta;
import com.sorin.idea.dto.ProtSincopePk;
import com.sorin.idea.dto.ProtSincopeValCard;
import com.sorin.idea.dto.Protocolos;
import com.sorin.idea.dto.ProtocolosPk;
import com.sorin.idea.dto.ProtocolosProcedimientos;
import com.sorin.idea.dto.TestOrtostatismoActivo;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ProtSincopeAltaDaoImpl;
import com.sorin.idea.jdbc.ProtSincopeDaoImpl;
import com.sorin.idea.jdbc.ProtSincopeValCardDaoImpl;
import com.sorin.idea.jdbc.ProtocolosDaoImpl;
import com.sorin.idea.jdbc.ProtocolosProcedimientosDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.ProcedimientosClinicos;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;

public class ControlProtocolos extends BaseIU{

	private static Logger logger = Logger.getLogger(ControlSeguimientosClinicos.class);
	private LoginForm lf;
	private String usuario;
	
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private ControlPacientes cp;
	private ControlTestOrtostatismo ctest;
	
	private ProtocolosDao protdao;
	private Protocolos protocolo;
	private ArrayList<Protocolos> lista;
	private ProtocolosProcedimientosDao protproddao;
	private HtmlDataTable bindingBuscarSincope;
	
	private ProtSincope prSincope;
	private ProtSincopeDao protsincdao;
	private ProtSincopeAltaDao prscpaltadao;
	private ProtSincopeValCardDao prscpvcardao;
	
	private ProcedimientoDao procdao;
	private Procedimiento proc;
	
	private boolean editable;
	private String columna = "fecha";
	private boolean ascendente = false;
	
	private ArrayList<ProcedimientosClinicos> listprocsinc;
	private String json;
	private String jsonstart;
	private String jsonend;
	
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
			
			this.protdao = new ProtocolosDaoImpl(this.usuario);
			this.protproddao = new ProtocolosProcedimientosDaoImpl(this.usuario);
			this.protsincdao = new ProtSincopeDaoImpl(this.usuario);
			this.prscpaltadao = new ProtSincopeAltaDaoImpl(this.usuario);
			this.prscpvcardao = new ProtSincopeValCardDaoImpl(this.usuario);
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) 
				cp = new ControlPacientes();
			
			this.ctest = (ControlTestOrtostatismo) getBean("controlTestOrtostatismo");
			if(ctest == null)
				ctest = new ControlTestOrtostatismo();
			
			this.protocolo = new Protocolos();
			this.protocolo.setFechacreacion(new Date());
			this.proc = new Procedimiento();
			this.proc.setFecha(new Date());
			this.prSincope = new ProtSincope();
			this.prSincope.getAlta().setFechaAlta(new Date());
			this.prSincope.getTestOrto().setFecha(new Date());
			this.lista = new ArrayList<Protocolos>();
			this.listprocsinc = new ArrayList<ProcedimientosClinicos>();
			this.json = "";
			this.jsonend = "";
			this.jsonstart = "";
			this.setEditable(true);
			
			this.obtenerProtocolosPaciente(cp.getPacienteSelect().getCodigo());
			
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_rec_pat")+": " + e1.getMessage());
		}
	}
	
	public void obtenerProtocolosPaciente(Integer codigo){
		try{
			Protocolos[] prts = this.protdao.findWhereCodigoEquals(codigo);
			for(Protocolos protocolo:prts){
				// obtencion de procedimientos asociados
				ProtocolosProcedimientos[] prs = this.protproddao.findWhereIdprotocoloEquals(protocolo.getIdprotocolo());
				if(prs!=null){
					for(ProtocolosProcedimientos item:prs){
						protocolo.getProtprocs().add(item);
						Procedimiento p = this.procdao.findByPrimaryKey(item.getIdprocedimiento(), item.getTipoprocedimiento());
						if(p!=null)
							protocolo.getProcs().add(p);
					}
					this.lista.add(protocolo);
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
		}
	}
	
	public void guardaProtSincope(ActionEvent e){
		try{
			if(validarPrSincope()){
				if(this.prSincope.getIdprotsincope()!=null){ // UPDATE
					this.prscpaltadao.update(this.prSincope.getAlta().createPk(), this.prSincope.getAlta());
					this.prscpvcardao.update(this.prSincope.getValcar().createPk(), this.prSincope.getValcar());
					this.protsincdao.update(this.prSincope.createPk(), this.prSincope);
					this.proc.setFecha(this.prSincope.getAlta().getFechaAlta());
					this.procdao.update(this.proc.createPk(), this.proc);
					this.protocolo.setFechacreacion(this.prSincope.getAlta().getFechaAlta());
					this.protdao.update(this.protocolo.createPk(), this.protocolo);
					//this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.procedimiento.getFecha()));
					// Actualizacion - Test ortostatismo
					if(this.prSincope.getAlta().getPrdiaginiAltaTestort()!=null 
							&& this.prSincope.getAlta().getPrdiaginiAltaTestort()==1 && this.prSincope.getTestOrto()!=null){
						this.prSincope.getTestOrto().setFecha(this.prSincope.getAlta().getFechaAlta());
						ctest.editar(this.prSincope.getTestOrto());
					}
					this.precargaSincope();
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
					logger.info("("+this.usuario+") Registro de Protocolo de Sincope actualizado. Id Protocolo:"+this.protocolo.getIdprotocolo()+", Id Paciente: "+this.protocolo.getCodigo());
				}else{ // INSERT
					ProtSincopePk prsincpk = this.protsincdao.insert(this.prSincope);
					this.prSincope.getAlta().setIdprotsincope(prsincpk.getIdprotsincope());
					this.prscpaltadao.insert(this.prSincope.getAlta());
					this.prSincope.getValcar().setIdprotsincope(prsincpk.getIdprotsincope());
					this.prscpvcardao.insert(this.prSincope.getValcar());
					// Procedimiento de sincope 
					this.proc = new Procedimiento();
					this.proc.setCodigo(cp.getPacienteSelect().getCodigo());
					this.proc.setFecha(this.prSincope.getAlta().getFechaAlta());
					this.proc.setIdprocedimiento(prsincpk.getIdprotsincope());
					this.proc.setTipoprocedimiento(1093);
					this.procdao.insert(this.proc);
					// Protocolo
					this.protocolo.setFechacreacion(this.prSincope.getAlta().getFechaAlta());
					this.protocolo.setCodigo(cp.getPacienteSelect().getCodigo());
					this.protocolo.setEstado(1);
					this.protocolo.setTipo(1); // SINCOPE
					ProtocolosPk prpk = this.protdao.insert(this.protocolo);
					// Tabla relacional: protocolo - procedimientos
					// Se inserta la asociada al procedimiento: protocolo sincope
					ProtocolosProcedimientos protproc = new ProtocolosProcedimientos();
					protproc.setIdprocedimiento(prsincpk.getIdprotsincope());
					protproc.setTipoprocedimiento(1093);
					protproc.setIdprotocolo(prpk.getIdprotocolo());
					this.protproddao.insert(protproc);
					
					this.protocolo.getProtprocs().add(protproc);
					this.protocolo.getProcs().add(this.proc); // TODO - ¿ESTA BIEN HECHO ASI?
					
					// Guarda - Test Ortostatismo activo si procede
					if(this.prSincope.getAlta().getPrdiaginiAltaTestort()!=null 
							&& this.prSincope.getAlta().getPrdiaginiAltaTestort()==1 && this.prSincope.getTestOrto()!=null){
						this.prSincope.getTestOrto().setFecha(this.prSincope.getAlta().getFechaAlta());
						Integer idtest = ctest.guardar(this.prSincope.getTestOrto());
						if(idtest!=null){
							ProtocolosProcedimientos protproctest = new ProtocolosProcedimientos();
							protproctest.setIdprocedimiento(idtest);
							protproctest.setTipoprocedimiento(1092); // test ortostatismo
							protproctest.setIdprotocolo(prpk.getIdprotocolo());
							this.protproddao.insert(protproctest);
							// Se incluye dentro de la lista de procedimientos del protocolo
							this.protocolo.getProtprocs().add(protproctest);
							Procedimiento pr = this.procdao.findByPrimaryKey(idtest, 1092);
							if(pr!=null)
								this.protocolo.getProcs().add(pr);
						}
					}
					// Actualiza linea temporal
					this.precargaSincope();
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
					logger.info("("+this.usuario+") Registro de Protocolo de Sincope insertado con éxito. Id Protocolo:"+this.protocolo.getIdprotocolo()+", Id Paciente: "+this.protocolo.getCodigo());
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Error al guardar/actualizar protocolo: " + e1.getMessage());
		}
	}
	/**
	 * Borra el registro de protocolo junto con sus relaciones de procedimiento.
	 * En ningun caso borra los procedimientos asociados. Estos deben ser eliminados uno a uno del sistema
	 * @param e
	 */
	public void eliminarProtSincope(ActionEvent e){
		try{
			int auxproc = this.protocolo.getIdprotocolo();
			this.prscpvcardao.delete(this.prSincope.getValcar().createPk());
			this.prscpaltadao.delete(this.prSincope.getAlta().createPk());
			this.protsincdao.delete(this.prSincope.createPk());
			for(ProtocolosProcedimientos pr:this.protocolo.getProtprocs())
				this.protproddao.delete(pr.createPk());
			this.protdao.delete(this.protocolo.createPk());
			this.procdao.delete(this.proc.createPk());
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Protocolo eliminado con éxito. Id Protocolo:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Error al eliminar protocolo: " + e1.getMessage());
		}
	}
	
	public void imprimirProtSincope(ActionEvent e){
		ConstructorPdf constructorPDF = new ConstructorPdf();
		String PathFicheroXml = "";
		GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
		String jasper = "InformeProtocoloSincope.jasper";
		try {
			PathFicheroXml = generadorXML.imprimeInformeProtocoloSincope(cp.getPacienteSelect(), this.protocolo, this.prSincope, this.bundle);
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				this.nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error generando documento,motivo: " + se.getMessage(),
						"Error generando documento,Motivo: " + se.getMessage());
			} catch (Exception e3) {
			}
		}
		try {
			constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),PathFicheroXml, jasper);
			logger.info("("+this.usuario+") Generación de informe (Protocolo Sincope). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (Exception se) {
			logger.error("("+this.usuario+") Error imprimiendo documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());			
			try {
				nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
						"Error imprimiendo informe,motivo: " + se.getMessage(),
						"Error imprimiendo informe,Motivo: " + se.getMessage());
			} catch (Exception e2) {
			}
		}
	}
	
	public void cargaProtocoloSincope(ActionEvent e){
		try{
			this.protocolo = this.lista.get(this.bindingBuscarSincope.getRowIndex());
			this.prSincope = this.obtenerProtocoloSincope(this.protocolo.getIdprotocolo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Protocolo:"+this.protocolo.getIdprotocolo()+" Error: "+ e1.getMessage());
		}
	}
	/**
	 * Desde barra temporal interna de procedimiento - TODO
	 * @param e
	 */
	public void cargaProtocoloSincopeDesdeBarraTemporal(ActionEvent e){
		try{
			this.protocolo = this.lista.get(this.bindingBuscarSincope.getRowIndex());
			this.prSincope = this.obtenerProtocoloSincope(this.protocolo.getIdprotocolo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Protocolo:"+this.protocolo.getIdprotocolo()+" Error: "+ e1.getMessage());
		}
	}

	public void cargaProtocolo(Integer idproc){
		try{
			this.protocolo = this.protdao.findByPrimaryKey(idproc);
			ProtocolosProcedimientos[] prs = this.protproddao.findWhereIdprotocoloEquals(this.protocolo.getIdprotocolo());
			if(prs!=null){
				for(ProtocolosProcedimientos item:prs){
					this.protocolo.getProtprocs().add(item);
					Procedimiento p = this.procdao.findByPrimaryKey(item.getIdprocedimiento(), item.getTipoprocedimiento());
					if(p!=null)
						this.protocolo.getProcs().add(p);
				}
			}
			if(this.protocolo.getTipo()==1)
				this.prSincope = this.obtenerProtocoloSincope(this.protocolo.getIdprotocolo());
			logger.info("("+this.usuario+") Consulta de protocolo. Id Protocolo:"+this.protocolo.getIdprotocolo());
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("prot_sincope_msg_error_consulta_2")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el protocolo. Error: "+ e1.getMessage());
		}
	}
	
	private boolean validarPrSincope(){
		if(this.protocolo.getFechacreacion()==null){
			this.pintaMensaje(ERROR, this.bundle.getString("prot_sincope_msg_warn_guarda_1"));
			return false;
		}
		return true;
	}
	
	private ProtSincope obtenerProtocoloSincope(Integer idprotocolo){
		try{
			ProtSincope sinc = null;
			TestOrtostatismoActivo testOrt = null;
			this.listprocsinc.clear();
			ProtocolosProcedimientos[] prs = this.protproddao.findByDynamicWhere("IDPROTOCOLO = ? ", new Object[]{idprotocolo});
			Procedimiento proc = null;
			if(prs!=null && prs.length>0){
				for(ProtocolosProcedimientos pr:prs){
					proc = this.procdao.findByPrimaryKey(pr.getIdprocedimiento(), pr.getTipoprocedimiento());
					if(pr.getTipoprocedimiento()==1093){
						sinc = this.protsincdao.findByPrimaryKey(pr.getIdprocedimiento());
						if(sinc!=null){
							ProtSincopeAlta sincAlta = this.prscpaltadao.findByPrimaryKey(sinc.getIdprotsincope());
							sinc.setAlta(sincAlta);
							ProtSincopeValCard valcar = this.prscpvcardao.findByPrimaryKey(sinc.getIdprotsincope());
							sinc.setValcar(valcar);
							// Alta
							this.listprocsinc.add(new ProcedimientosClinicos(sincAlta.getFechaAlta(),"<div>"+this.bundle.getString("proc_1093_alta")+"</div><img src='/idea/img/iconos/alta.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1093_alta")+"!"+UtilFechas.dateToStringSinSeparador(sincAlta.getFechaAlta())+"'>",1093,null));
							// Analitica
							if(sinc.getAnaFecha()!=null && sinc.getAnaRealizada()!=null && sinc.getAnaRealizada()==1)
								this.listprocsinc.add(new ProcedimientosClinicos(sinc.getAnaFecha(),"<div>"+this.bundle.getString("proc_1093_ana")+"</div><img src='/idea/img/iconos/analitica.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1093_ana")+"!"+UtilFechas.dateToStringSinSeparador(sinc.getAnaFecha())+"'>",1093,null));
							// Resultados
							if(sinc.getResFecha()!=null)
								this.listprocsinc.add(new ProcedimientosClinicos(sinc.getResFecha(),"<div>"+this.bundle.getString("proc_1093_res")+"</div><img src='/idea/img/iconos/formularios.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1093_res")+"!"+UtilFechas.dateToStringSinSeparador(sinc.getResFecha())+"'>",1093,null));
						}else
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg"));
					}else if(pr.getTipoprocedimiento()==1092){
						testOrt = ctest.obtenerTest(pr.getIdprocedimiento());
						this.listprocsinc.add(new ProcedimientosClinicos(testOrt.getFecha(),"<div>"+this.bundle.getString("proc_1092")+"</div><img src='/idea/img/iconos/bpm.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1092")+"!"+UtilFechas.dateToStringSinSeparador(testOrt.getFecha())+"'>",1092,null));
					}else if(pr.getTipoprocedimiento()==1089){
						this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1089")+"</div><img src='/idea/img/iconos/holter.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1089")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1089,null));
					}else if(pr.getTipoprocedimiento()==1091){
						this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1091")+"</div><img src='/idea/img/iconos/regevext.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1091")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1091,null));
					}else if(pr.getTipoprocedimiento()==1067){
						this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1067")+"</div><img src='/idea/img/iconos/ViewResults.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1067")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1067,null));
					}else if(pr.getTipoprocedimiento()==1066){
						this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1066")+"</div><img src='/idea/img/iconos/mesabasc.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1066")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1066,null));
					}else if(pr.getTipoprocedimiento()==1061){
						this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1061")+"</div><img src='/idea/img/iconos/hearticon.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1061")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1061,null));
					}
				}
				if(sinc!=null)
					sinc.setTestOrto(testOrt!=null?testOrt:new TestOrtostatismoActivo());
			}
			// PROCESADO DE PROCEDIMIENTOS RECUPERADOS
			String str="";
			for(ProcedimientosClinicos pc:this.listprocsinc)
				str = str + pc.getStart()+"--"+pc.getContent()+"_";
			
			this.json = ((!str.equals(""))?str.substring(0,str.length()-1):str);
			
			Collections.sort(this.listprocsinc, new Comparator() {
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
			if(this.listprocsinc.size()>0){
				DateFormat DF = new SimpleDateFormat("yyyy/MM/dd");
				this.jsonstart = UtilDatos.formateaJSON(DF.format(UtilFechas.sumarRestarDiasFecha(this.listprocsinc.get(0).getFecha(), -1)));
				this.jsonend = UtilDatos.formateaJSON(DF.format(UtilFechas.sumarRestarDiasFecha(this.listprocsinc.get(this.listprocsinc.size()-1).getFecha(), 1))) ;
			}
			this.calculaFactorRiesgo(sinc);
			this.calculaOrientacionDiagnostica(sinc);
			return sinc;
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Protocolo: "+idprotocolo+" Error: "+ e1.getMessage());
		}
		return null;
	}
	
	public void precargaSincope(){
		try{
			this.listprocsinc.clear();
			Procedimiento proc = null;
			for(ProtocolosProcedimientos pr:this.protocolo.getProtprocs()){
				proc = this.procdao.findByPrimaryKey(pr.getIdprocedimiento(), pr.getTipoprocedimiento());
				if(pr.getTipoprocedimiento()==1093){
					if(this.prSincope!=null){
						// Alta
						this.listprocsinc.add(new ProcedimientosClinicos(this.prSincope.getAlta().getFechaAlta(),"<div>"+this.bundle.getString("proc_1093_alta")+"</div><img src='/idea/img/iconos/alta.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1093_alta")+"!"+UtilFechas.dateToStringSinSeparador(this.prSincope.getAlta().getFechaAlta())+"'>",1093,null));
						// Analitica
						if(this.prSincope.getAnaFecha()!=null && this.prSincope.getAnaRealizada()!=null && this.prSincope.getAnaRealizada()==1)
							this.listprocsinc.add(new ProcedimientosClinicos(this.prSincope.getAnaFecha(),"<div>"+this.bundle.getString("proc_1093_ana")+"</div><img src='/idea/img/iconos/analitica.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1093_ana")+"!"+UtilFechas.dateToStringSinSeparador(this.prSincope.getAnaFecha())+"'>",1093,null));
						// Resultados
						if(this.prSincope.getResFecha()!=null)
							this.listprocsinc.add(new ProcedimientosClinicos(this.prSincope.getResFecha(),"<div>"+this.bundle.getString("proc_1093_res")+"</div><img src='/idea/img/iconos/formularios.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1093_res")+"!"+UtilFechas.dateToStringSinSeparador(this.prSincope.getResFecha())+"'>",1093,null));
					}else
						this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg"));
				}else if(pr.getTipoprocedimiento()==1092){
					this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1092")+"</div><img src='/idea/img/iconos/bpm.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1092")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1092,null));
				}else if(pr.getTipoprocedimiento()==1089){
					this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1089")+"</div><img src='/idea/img/iconos/holter.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1089")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1089,null));
				}else if(pr.getTipoprocedimiento()==1091){
					this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1091")+"</div><img src='/idea/img/iconos/regevext.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1091")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1091,null));
				}else if(pr.getTipoprocedimiento()==1067){
					this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1067")+"</div><img src='/idea/img/iconos/ViewResults.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1067")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1067,null));
				}else if(pr.getTipoprocedimiento()==1066){
					this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1066")+"</div><img src='/idea/img/iconos/mesabasc.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1066")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1066,null));
				}else if(pr.getTipoprocedimiento()==1061){
					this.listprocsinc.add(new ProcedimientosClinicos(proc.getFecha(),"<div>"+this.bundle.getString("proc_1061")+"</div><img src='/idea/img/iconos/hearticon.png' style='width:32px; height:32px;'!"+this.bundle.getString("barra_temp_proc_1061")+"!"+UtilFechas.dateToStringSinSeparador(proc.getFecha())+"'>",1061,null));
				}
			}
			// PROCESADO DE PROCEDIMIENTOS RECUPERADOS
			String str="";
			for(ProcedimientosClinicos pc:this.listprocsinc)
				str = str + pc.getStart()+"--"+pc.getContent()+"_";
			
			this.json = ((!str.equals(""))?str.substring(0,str.length()-1):str);
			
			Collections.sort(this.listprocsinc, new Comparator() {
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
			if(this.listprocsinc.size()>0){
				DateFormat DF = new SimpleDateFormat("yyyy/MM/dd");
				this.jsonstart = UtilDatos.formateaJSON(DF.format(UtilFechas.sumarRestarDiasFecha(this.listprocsinc.get(0).getFecha(), -1)));
				this.jsonend = UtilDatos.formateaJSON(DF.format(UtilFechas.sumarRestarDiasFecha(this.listprocsinc.get(this.listprocsinc.size()-1).getFecha(), 1))) ;
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Protocolo: "+this.protocolo.getIdprotocolo()+" Error: "+ e1.getMessage());
		}
	}
	
	public void calculaFactorRiesgo(ActionEvent e){
		this.calculaFactorRiesgo(this.prSincope);
	}
	
	public void calculaFactorRiesgo(ProtSincope sinc){
		try{
			sinc.setPerfilRiesgo(0);
			int cont = 0;
			if(sinc.getValcar().getSincopeDecB()!=null && sinc.getValcar().getSincopeDecB().equals(true))
				cont++;
			if(sinc.getValcar().getSincopePicoB()!=null && sinc.getValcar().getSincopePicoB().equals(true))
				cont++;
			if(sinc.getValcar().getAfMsB()!=null && sinc.getValcar().getAfMsB().equals(true))
				cont++;
			if(sinc.getValcar().getPalpitacionesB()!=null && sinc.getValcar().getPalpitacionesB().equals(true))
				cont++;
			if(sinc.getValcar().getDolorToracicoB()!=null && sinc.getValcar().getDolorToracicoB().equals(true))
				cont++;
			// Calculo de perfil
			if(cont<=1)
				sinc.setPerfilRiesgo(1);
			else if(cont>1 && cont<=3)
				sinc.setPerfilRiesgo(2);
			else
				sinc.setPerfilRiesgo(3);
		}catch(Exception e1){
			pintaMensaje(3, this.bundle.getString("prot_sincope_msg_error_calcula_factor_riesg")+ e1.getMessage());
		}
	}
	
	public void calculaOrientacionDiagnostica(ActionEvent e){
		this.calculaOrientacionDiagnostica(this.prSincope);
	}
	
	public void calculaOrientacionDiagnostica(ProtSincope sinc){
		try{
			sinc.setOrientacionDiag(1); // inicializacion
			int cont = 0;
			// Fase 1: Calculo de alta
			if(sinc.getAlta().getPreciAltaAgloB().equals(true) || sinc.getAlta().getPreciAltaAlcoholB().equals(true) || sinc.getAlta().getPreciAltaAyunoB().equals(true)
					|| sinc.getAlta().getPreciAltaCalorB().equals(true) || sinc.getAlta().getPreciAltaEmbB().equals(true) || sinc.getAlta().getPreciAltaEmocionB().equals(true)
					|| sinc.getAlta().getPreciAltaOrtoB().equals(true) || sinc.getAlta().getPreciAltaPostB().equals(true) || sinc.getAlta().getPreciAltaSitB().equals(true)
					|| sinc.getAlta().getPreciAltaVenopB().equals(true))
				cont++;
			if(sinc.getAlta().getProdAltaCefalB().equals(true) || sinc.getAlta().getProdAltaDolorabB().equals(true) || sinc.getAlta().getProdAltaDolortorB().equals(true)
					|| sinc.getAlta().getProdAltaFaltaaireB().equals(true) || sinc.getAlta().getProdAltaFatigaB().equals(true) || sinc.getAlta().getProdAltaFrioB().equals(true)
					|| sinc.getAlta().getProdAltaHipervB().equals(true) || sinc.getAlta().getProdAltaMareoB().equals(true) || sinc.getAlta().getProdAltaNauseaB().equals(true)
					|| sinc.getAlta().getProdAltaPalidezB().equals(true) || sinc.getAlta().getProdAltaPalpB().equals(true) || sinc.getAlta().getProdAltaSudorB().equals(true)
					|| sinc.getAlta().getProdAltaVisionB().equals(true))
				cont++;
			// Recuento Fase 1
			if(cont>=2)
				sinc.setOrientacionDiag(2);
			// Fase 2: Calculo de Valoracion cardiaca
			if((sinc.getValcar().getCardioEstruct()!=null && sinc.getValcar().getCardioEstruct()==1)
					|| (sinc.getValcar().getAntIsqIcc()!=null && sinc.getValcar().getAntIsqIcc()==1)
					|| (sinc.getValcar().getEcgAnormal()!=null && sinc.getValcar().getEcgAnormal()>1))
				sinc.setOrientacionDiag(1);
			if((sinc.getValcar().getHallBav()!=null && sinc.getValcar().getHallBav()==1)
					|| (sinc.getValcar().getHallBr()!=null && sinc.getValcar().getHallBr()==1)
					|| (sinc.getValcar().getHallBradi()!=null && sinc.getValcar().getHallBradi()==1)
					|| (sinc.getValcar().getHallDisec()!=null && sinc.getValcar().getHallDisec()==1)
					|| (sinc.getValcar().getHallEcg()!=null && sinc.getValcar().getHallEcg()==1)
					|| (sinc.getValcar().getHallEmbol()!=null && sinc.getValcar().getHallEmbol()==1)
					|| (sinc.getValcar().getHallEsten()!=null && sinc.getValcar().getHallEsten()==1)
					|| (sinc.getValcar().getHallHtapulm()!=null && sinc.getValcar().getHallHtapulm()==1)
					|| (sinc.getValcar().getHallMix()!=null && sinc.getValcar().getHallMix()==1)
					|| (sinc.getValcar().getHallMpdai()!=null && sinc.getValcar().getHallMpdai()==1)
					|| (sinc.getValcar().getHallTsv()!=null && sinc.getValcar().getHallTsv()==1)
					|| (sinc.getValcar().getHallTvns()!=null && sinc.getValcar().getHallTvns()==1))
				sinc.setOrientacionDiag(3);
		}catch(Exception e1){
			pintaMensaje(3, this.bundle.getString("prot_sincope_msg_error_calcula_orient_diag")+ e1.getMessage());
		}
	}
	
	public void verTestOrto(ActionEvent e){
		try {
			// obtener idprocedimiento
			ProtocolosProcedimientos protproc = obtenerIdProc(1092);
			if(protproc!=null){
				ControlTestOrtostatismo cr = (ControlTestOrtostatismo) getBean("controlTestOrtostatismo");
				cr.cargaTestOrtoProtocolo(protproc.getIdprocedimiento()); 
				setBean("controlTestOrtostatismo", cr);
			}else
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_consulta"));
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	public void desvincularTestOrto(ActionEvent e){
		try{
			ProtocolosProcedimientos protproc = obtenerIdProc(1092);
			if(protproc!=null){
				this.protocolo.getProtprocs().remove(protproc);
				// borrar entrada asociada al protocolo
				this.protproddao.delete(protproc.createPk());
				this.prSincope.getAlta().setPrdiaginiAltaTestort(0);
				this.guardaProtSincope(null);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("prot_sincope_msg_info_desvinc"));
			}else 
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc_2"));
		}catch(Exception e1){
			pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc")+ e1.getMessage());
		}
	}
	
	public void verHolter(ActionEvent e){
		try {
			// obtener idprocedimiento
			ProtocolosProcedimientos protproc = obtenerIdProc(1089);
			if(protproc!=null){
				ControlHolter cr = (ControlHolter) getBean("controlHolter");
				cr.cargaHolterProtocolo(protproc.getIdprocedimiento()); 
				setBean("controlHolter", cr);
			}else
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_consulta"));
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	public void desvincularHolter(ActionEvent e){
		try{
			ProtocolosProcedimientos protproc = obtenerIdProc(1089);
			if(protproc!=null){
				this.protocolo.getProtprocs().remove(protproc);
				// borrar entrada asociada al protocolo
				this.protproddao.delete(protproc.createPk());
				this.prSincope.setPdiagMonitorizacion(0);
				this.guardaProtSincope(null);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("prot_sincope_msg_info_desvinc"));
			}else 
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc_2"));
		}catch(Exception e1){
			pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc")+ e1.getMessage());
		}
	}
	
	public void verELR(ActionEvent e){
		try {
			// obtener idprocedimiento
			ProtocolosProcedimientos protproc = obtenerIdProc(1091);
			if(protproc!=null){
				ControlRegEvExt cr = (ControlRegEvExt) getBean("controlRegEvExt");
				cr.cargaRegEvExtProtocolo(protproc.getIdprocedimiento()); 
				setBean("controlRegEvExt", cr);
			}else
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_consulta"));
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	public void desvincularELR(ActionEvent e){
		try{
			ProtocolosProcedimientos protproc = obtenerIdProc(1091);
			if(protproc!=null){
				this.protocolo.getProtprocs().remove(protproc);
				// borrar entrada asociada al protocolo
				this.protproddao.delete(protproc.createPk());
				this.prSincope.setPdiagElr(0);
				this.guardaProtSincope(null);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("prot_sincope_msg_info_desvinc"));
			}else 
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc_2"));
		}catch(Exception e1){
			pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc")+ e1.getMessage());
		}
	}
	
	public void verMesa(ActionEvent e){
		try {
			// obtener idprocedimiento
			ProtocolosProcedimientos protproc = obtenerIdProc(1066);
			if(protproc!=null){
				ControlMesas cr = (ControlMesas) getBean("controlMesas");
				cr.cargaMesaProtocolo(protproc.getIdprocedimiento()); 
				setBean("controlMesas", cr);
			}else
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_consulta"));
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	public void desvincularMesa(ActionEvent e){
		try{
			ProtocolosProcedimientos protproc = obtenerIdProc(1066);
			if(protproc!=null){
				this.protocolo.getProtprocs().remove(protproc);
				// borrar entrada asociada al protocolo
				this.protproddao.delete(protproc.createPk());
				this.prSincope.setPdiagMesab(0);
				this.guardaProtSincope(null);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("prot_sincope_msg_info_desvinc"));
			}else 
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc_2"));
		}catch(Exception e1){
			pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc")+ e1.getMessage());
		}
	}
	
	public void verILR(ActionEvent e){
		try {
			// obtener idprocedimiento
			ProtocolosProcedimientos protproc = obtenerIdProc(1067);
			if(protproc!=null){
				ControlRegistrador cr = (ControlRegistrador) getBean("controlRegistrador");
				cr.cargaRegistradorProtocolo(protproc.getIdprocedimiento()); 
				setBean("controlRegistrador", cr);
			}else
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_consulta"));
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	public void desvincularILR(ActionEvent e){
		try{
			ProtocolosProcedimientos protproc = obtenerIdProc(1067);
			if(protproc!=null){
				this.protocolo.getProtprocs().remove(protproc);
				// borrar entrada asociada al protocolo
				this.protproddao.delete(protproc.createPk());
				this.prSincope.setPdiagIlr(0);
				this.guardaProtSincope(null);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("prot_sincope_msg_info_desvinc"));
			}else 
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc_2"));
		}catch(Exception e1){
			pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc")+ e1.getMessage());
		}
	}
	
	public void verEEF(ActionEvent e){
		try {
			// obtener idprocedimiento
			ProtocolosProcedimientos protproc = obtenerIdProc(1061);
			if(protproc!=null){
				ControlEef cr = (ControlEef) getBean("controlEef");
				cr.cargaEstudioProtocolo(protproc.getIdprocedimiento()); 
				setBean("controlEef", cr);
			}else
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_consulta"));
		} catch (Exception ex) {
			pintaMensaje(3, this.bundle.getString("pat_msg_error_ver")+ ex.getMessage());
		}
	}
	
	public void desvincularEEF(ActionEvent e){
		try{
			ProtocolosProcedimientos protproc = obtenerIdProc(1061);
			if(protproc!=null){
				this.protocolo.getProtprocs().remove(protproc);
				// borrar entrada asociada al protocolo
				this.protproddao.delete(protproc.createPk());
				this.prSincope.setPdiagEef(0);
				this.guardaProtSincope(null);
				this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("prot_sincope_msg_info_desvinc"));
			}else 
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc_2"));
		}catch(Exception e1){
			pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_desvinc")+ e1.getMessage());
		}
	}
	
	private ProtocolosProcedimientos obtenerIdProc(Integer tipoproc){
		for(ProtocolosProcedimientos pr:this.protocolo.getProtprocs())
			if(pr.getTipoprocedimiento().equals(tipoproc))
				return pr;
		return null;
	}
	
	public int vincularProcedimientoProtocolo(Procedimiento proc, Protocolos prot){
		try{
			// TODO - ¿PUEDEN VINCULARSE VARIOS PROCEDIMIENTOS DE UN MISMO TIPO AL PROCEDIMIENTO?
			// SE ASUME EN PRINCIPIO QUE SI, PERO HABRIA QUE INCLUIR LA LÓGICA DE SELECCIÓN DE MULTIPLES PROCEDIMIENTOS DE UN MISMO TIPO EN FORMULARIO DE PROTOCOLO
			ProtocolosProcedimientos prtprc = new ProtocolosProcedimientos();
			prtprc.setIdprocedimiento(proc.getIdprocedimiento());
			prtprc.setTipoprocedimiento(proc.getTipoprocedimiento());
			prtprc.setIdprotocolo(prot.getIdprotocolo());
			
			ProtocolosProcedimientos ex = this.protproddao.findByPrimaryKey(prtprc.getIdprotocolo(), prtprc.getIdprocedimiento(), prtprc.getTipoprocedimiento());
			if(ex!=null)
				return 0;
			else{
				this.protproddao.insert(prtprc);
				// Actualiza protocolo - Valor de prueba diagnostica realizada
				if(prot.getTipo()!=null && prot.getTipo()==1){
					ProtSincope sinc = obtenerProtocoloSincope(prot.getIdprotocolo());
					if(proc.getTipoprocedimiento()==1061)
						sinc.setPdiagEef(1);
					else if(proc.getTipoprocedimiento()==1089)
						sinc.setPdiagMonitorizacion(1);
					else if(proc.getTipoprocedimiento()==1066)
						sinc.setPdiagMesab(1);
					else if(proc.getTipoprocedimiento()==1067)
						sinc.setPdiagIlr(1);
					else if(proc.getTipoprocedimiento()==1066)
						sinc.setPdiagMesab(1);
					else if(proc.getTipoprocedimiento()==1091)
						sinc.setPdiagElr(1);
					else if(proc.getTipoprocedimiento()==1092){
						sinc.getAlta().setPrdiaginiAltaTestort(1);
						this.prscpaltadao.update(sinc.getAlta().createPk(), sinc.getAlta());
					}
					this.protsincdao.update(sinc.createPk(), sinc);
				}
				logger.error("("+this.usuario+") Registro vinculado con exito al protocolo. Id Protocolo: "+prot.getIdprotocolo()+". IdProcedimiento: "+proc.getIdprocedimiento()+". TipoProcedimiento: "+proc.getTipoprocedimiento());
				return 1;
			}
		}catch(Exception e1){
			logger.error("("+this.usuario+") No se puede vincular registro al protocolo. Id Protocolo: "+prot.getIdprotocolo()+". IdProcedimiento: "+proc.getIdprocedimiento()+". TipoProcedimiento: "+proc.getTipoprocedimiento()+". Error: "+ e1.getMessage());
			return -1;
		}
	}
	
	/**************************************************
	 ********************** GET / SET *****************
	 **************************************************/
	
	public ArrayList<SelectItem> getTipos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem("1", this.bundle.getString("prot_tipo_op1")));
		return diag;
	}
	
	public ArrayList<Protocolos> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Protocolos> lista) {
		this.lista = lista;
	}

	public Protocolos getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Protocolos protocolo) {
		this.protocolo = protocolo;
	}

	public ProtSincope getPrSincope() {
		return prSincope;
	}

	public void setPrSincope(ProtSincope prSincope) {
		this.prSincope = prSincope;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public HtmlDataTable getBindingBuscarSincope() {
		return bindingBuscarSincope;
	}

	public void setBindingBuscarSincope(HtmlDataTable bindingBuscarSincope) {
		this.bindingBuscarSincope = bindingBuscarSincope;
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

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
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

	public ArrayList<ProcedimientosClinicos> getListprocsinc() {
		return listprocsinc;
	}

	public void setListprocsinc(ArrayList<ProcedimientosClinicos> listprocsinc) {
		this.listprocsinc = listprocsinc;
	}
}

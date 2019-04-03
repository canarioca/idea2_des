package com.sorin.idea.iu;

import hvn.apl.evomed.dto.DocHl7Dto;
import hvn.apl.evomed.ssh.UtilesTerminalSsh;
import hvn.apl.evomed.ssh.exception.SshException;
import hvn.apl.jProyecto2010.modelo.servicios.dto.SesionUsuarioDto;
import hvn.cm.dao.DAOException;
import hvn.cm.modelo.Mensaje;

import java.io.File;
import java.io.InputStream;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.sorin.idea.dao.ArrRegistradorDao;
import com.sorin.idea.dao.ArrRegistradorEcgDao;
import com.sorin.idea.dao.Codigosgs128Dao;
import com.sorin.idea.dao.DocHL7InformesDao;
import com.sorin.idea.dao.EpisodioDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.PacienteDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.ProtocolosDao;
import com.sorin.idea.dao.RegistradoreventosDao;
import com.sorin.idea.dao.SegSeguimientoRegEventosDao;
import com.sorin.idea.dao.UsuarioDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrRegistrador;
import com.sorin.idea.dto.ArrRegistradorPk;
import com.sorin.idea.dto.Codigosgs128;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.Protocolos;
import com.sorin.idea.dto.Registradoreventos;
import com.sorin.idea.dto.SegSeguimientoRegEventos;
import com.sorin.idea.exceptions.ArrRegistradorDaoException;
import com.sorin.idea.exceptions.ArrRegistradorEcgDaoException;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.jdbc.ArrRegistradorDaoImpl;
import com.sorin.idea.jdbc.ArrRegistradorEcgDaoImpl;
import com.sorin.idea.jdbc.Codigosgs128DaoImpl;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ProtocolosDaoImpl;
import com.sorin.idea.jdbc.RegistradoreventosDaoImpl;
import com.sorin.idea.jdbc.SegSeguimientoRegEventosDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.GestorCodigoBarras;
import com.sorin.idea.util.GestorFTPInforme;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.RegistradorSeguimientosBean;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilMapeos;

public class ControlRegistrador extends BaseIU {
	private static Logger logger = Logger.getLogger(ControlRegistrador.class);
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private ArrRegistrador registrador;
	private ArrRegistradorPk registradorpk;
	private Integer puntuacion = 0;
	private boolean comprobar = false;

	private ArrayList<ArrRegistrador> registradores;
	private ArrRegistrador[] registradoreslst;
	
	private ArrMaestras[] referidores;
	private ArrMaestras[] modeloImplantes;
	
	private ArrRegistradorDao registradordao;
	private ArrRegistradorEcgDao registradorecgdao;
	
	private ControlPacientes cp;
	private LoginForm lf;
	private HtmlDataTable bindingHistorico;
	private HtmlDataTable bindingHistoricoRegistrador;
	private String columna = "fecha";
	private boolean ascendente = false;
	
	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	private PacienteDao pacientedao = new PacienteDao();
	private String usuario = "";
	private InfoCentro infocentro;
	
	/**************************/
	private Procedimiento[] proclst;
	private ArrayList<Procedimiento> procs;
	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ProcedimientoDao procdao;
	private HtmlDataTable bindingBuscar;
	/**************************/
	private EpisodioDao epdao;
	private EventoDao evdao;
	/**************************/
	private ArrayList<RegistradorSeguimientosBean> lista;
	private SegSeguimientoRegEventosDao segregdao;
	private HtmlDataTable bindingRegistrador;
	private HtmlDataTable bindingSeguimientos;
	
	private RegistradoreventosDao regdao;
	private Registradoreventos[] regs;
	private Registradoreventos[] regs2;
	private boolean modreg;
	private Codigosgs128Dao gs128dao;
	private boolean nuevoreg;
	
	private boolean editable;
	
	private ControlComplicaciones cc;
	private ComplicacionesPacientes compac;
	private ComplicacionesPacientes currentItemComp;
	private HtmlDataTable bindingComplicacionesProc;
	private ArrayList<ComplicacionesPacientes> listacompl;
	private boolean editableProc;
	
	private ProtocolosDao protdao;
	private ArrayList<Protocolos> listaprot;
	private HtmlDataTable bindingProt;
	
	public void iniciaRegistradores(ActionEvent e) {
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
			lecturaProperties();
			ControlMaestras cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			
			this.cc = (ControlComplicaciones) getBean("controlComplicaciones");
			if(this.cc == null)
				this.cc = new ControlComplicaciones();
			this.cc.inicia(null); // importante
			
			this.setEditable(true);
			this.proc = new Procedimiento();
			this.proc.setFecha(new Date());
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.procpk = new ProcedimientoPk();
			this.procs = new ArrayList<Procedimiento>();
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			this.regdao = new RegistradoreventosDaoImpl(this.usuario);
			this.gs128dao = new Codigosgs128DaoImpl(this.usuario);
			
			this.registrador = new ArrRegistrador();
			this.registradorpk = new ArrRegistradorPk();
			this.referidores = cm.getReferidores();
			this.modeloImplantes = cm.getModeloImplantes();
			this.puntuacion = 0;
			this.comprobar = false;
			this.registradores = new ArrayList<ArrRegistrador>();			
			this.registradordao = new ArrRegistradorDaoImpl(this.usuario);
			this.registradorecgdao = new ArrRegistradorEcgDaoImpl();
			this.segregdao = new SegSeguimientoRegEventosDaoImpl(this.usuario);
			this.lista = new ArrayList<RegistradorSeguimientosBean>();
			
			this.compac = new ComplicacionesPacientes();
			this.compac.setFechaini(this.registrador.getFecha());
			this.compac.setTipo(1);
			this.setEditableProc(false);
			this.currentItemComp = new ComplicacionesPacientes();
			this.listacompl = new ArrayList<ComplicacionesPacientes>();
			this.protdao = new ProtocolosDaoImpl(this.usuario);
			this.listaprot = new ArrayList<Protocolos>();
			
			this.cargaRegistradores();
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,
					this.bundle.getString("info_msg_error_sel_pat"));
			}else{
				this.proclst = this.procdao.findByDynamicWhere("CODIGO =? AND TIPOPROCEDIMIENTO = ?",
								new Object[] {this.cp.getPacienteSelect().getCodigo(),1067});	
				if(this.proclst != null)
					for(Procedimiento p:this.proclst){
						this.procs.add(p);
						// 1. Obtencion de procedimientos de Registrador + Seguimientos asociados
						RegistradorSeguimientosBean item = new RegistradorSeguimientosBean();
						ArrRegistrador reg = this.registradordao.findByPrimaryKey(p.getIdprocedimiento());
						item.setReg(reg);
						SegSeguimientoRegEventos[] segs_reg =  this.segregdao.findWhereIdregeventosEquals(reg.getIdRegistrador());
						for(SegSeguimientoRegEventos s:segs_reg)
							item.getSegs().add(s);
						this.lista.add(item);
					}
				this.registrador.setIdPaciente(this.cp.getPacienteSelect().getCodigo());
				/*this.registradoreslst = this.registradordao.findWhereIdPacienteEquals(this.registrador.getIdPaciente());
				if (this.registradoreslst != null)
					for (ArrRegistrador m : this.registradoreslst)
						this.registradores.add(m);*/
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_rec_pat")+": "+ e1.getMessage());
		}
	}
	
	public void cargaRegistradores() {
		try {
			// carga solo generadores activos
			this.regs = this.regdao.findWhereActivoEquals(1);//insert
			this.regs2 = this.regdao.findAll();//update
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_consulta_2")+": "+ e1.getMessage());
		}
	}
	
	public void limpia(ActionEvent e) {
		try {
			this.registrador =  new ArrRegistrador();
			this.registradorpk = new ArrRegistradorPk();
			this.registrador.setIdPaciente(this.cp.getPacienteSelect().getCodigo());
			
			this.puntuacion = 0;
			this.comprobar = false;
			this.registradores =  new ArrayList<ArrRegistrador>();
		}catch(Exception ex){
			this.pintaMensaje(3,
					"Error limpiando datos");
		}
		
	}
	
	public void preguarda(ActionEvent e) {
		try {
			Episodio[] lista_eps = this.epdao.getEpisodiosPaciente(this.cp.getPacienteSelect().getNhc());
			this.episodios = new ArrayList<EpisodioDto>();
			Evento ev = null;
			Procedimiento[] proc_ep = null;
			for(Episodio ep:lista_eps){
				// Consulta citas y adapta procedimiento
				// Solo carga episodios que tengan cita asociada con estado activo y realtivas al tipo de procedimiento
				ev = this.evdao.findByPrimaryKey(ep.getIdevento());
				proc_ep = this.procdao.findWhereIdepisodioEquals(ep.getIdepisodio());
				if(ev!=null && ev.getProcedimiento()==1067 && ev.getEstado()==1 && proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));
			}
		} catch (Exception e1) {
			this.pintaMensaje(3,this.bundle.getString("info_msg_error_carga_epi")+": "+ e1.getMessage());
		}
		/*try {
			this.episodios = new ArrayList<EpisodioDto>();
			this.episodios = (ArrayList<EpisodioDto>) this.pacientedao
				.getEpisodios(this.cp.getPacienteSelect().getNhc());
			this.episodios.addAll((ArrayList<EpisodioDto>) this.pacientedao
				.getEpisodiosHospitalizacion(this.cp.getPacienteSelect().getNhc()));
		} catch (DAOException e1) {
			this.pintaMensaje(3,
				"No se han podido obtener los episodios de hospitalización del paciente: "
							+ e1.getMessage());
		}*/
	}
	
	public void guarda(ActionEvent e) {
		Integer epi = this.bindingepi.getRowIndex();
		
		if(epi != null && epi >= 0){
			this.registrador.setEpisodio(this.episodios.get(epi).getNumicu());
			this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());
		}
			
		boolean existe = false;
		try {
			if (this.registrador.getFecha() == null) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_fecha"));
			} else {
				if (this.registrador.getNproc() == null || this.registrador.getNproc().length() != 5)
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						this.bundle.getString("info_msg_guarda_error_nproc")+" "
								+ ((this.registrador.getFecha().getYear() + 1900) + "").substring(2) + " "+this.bundle.getString("info_msg_guarda_error_nproc_1"));
				else if(this.registrador.getIdmodeloreg()==null || this.registrador.getIdmodeloreg().equals(0)){
					this.pintaMensaje(ERROR, this.bundle.getString("regev_msg_warn_add"));
				}
				else {
					ArrRegistrador[] ests = this.registradordao.findByDynamicWhere(
							" nproc = ?", new Object[] { this.registrador.getNproc() });
					if (ests != null && ests.length > 0)
						if (this.registrador.getIdRegistrador() == null) {
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_nproc_prev"));
							existe = true;
						} else if (!ests[0].getIdRegistrador().equals(this.registrador.getIdRegistrador())) {
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_nproc_prev"));
							existe = true;
						} 
					if (!existe) {
						if (this.registrador.getIdRegistrador() != null){
							this.proc.setFecha(this.registrador.getFecha());
							this.procdao.update(this.proc.createPk(), this.proc);
							this.registradordao.update(this.registrador.createPk(), this.registrador);
							this.registradorecgdao.update(this.registrador.getEcgdto().createPk(), this.registrador.getEcgdto());
							//escribeEnClinica(false);
							this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
							this.pintaMensaje(INFO, this.bundle.getString("info_msg_editar_info"));
							logger.info("("+this.usuario+") Registro de Registrador de Eventos actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
						}else {
							this.registradorpk = this.registradordao.insert(this.registrador);
							this.registrador.setIdRegistrador(this.registradorpk.getIdRegistrador());
							this.registrador.getEcgdto().setIdRegistrador(this.registrador.getIdRegistrador());
							this.registradorecgdao.insert(this.registrador.getEcgdto());
							//escribeEnClinica(true);
							this.proc.setFecha(this.registrador.getFecha());
							this.proc.setIdprocedimiento(this.registrador.getIdRegistrador());
							this.proc.setTipoprocedimiento(1067);
							this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
							this.procpk = this.procdao.insert(this.proc);
							this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
							logger.info("("+this.usuario+") Registro de Registrador de Eventos insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
						}
						//cp.precarga(null);
						//this.pintaMensaje(Mensaje.SEVERIDAD_INFO,"Datos almacenados con éxito");
					}
				}
			}
		} catch (ArrRegistradorDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_guarda_error_exep")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error intentando guardar los datos: "+ e1.getMessage());
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_guarda_error_exep")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error intentando guardar los datos: "+ e1.getMessage());
		}
	}
	
	public void imprimeInforme(ActionEvent e) {
		if (this.registrador.getIdRegistrador() == null) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_imprimir"));
		} else {
			ConstructorPdf constructorPDF = new ConstructorPdf();
			String PathFicheroXml = "";
			GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

			try {
				PathFicheroXml = generadorXML.imprimeInformeRegistrador(this.registrador,
						this.cp.pacienteSelect, this.getPuntuacion(),this.infocentro, this.bundle);
			} catch (Exception se) {
				logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error generando documento,motivo: "+ se.getMessage(),
							"Error generando documento,Motivo: "+ se.getMessage());
				} catch (Exception e3) {
				}
			}

			try {
				constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml,"InformeRegistrador.jasper");
				logger.info("("+this.usuario+") Generación de informe (Registrador de eventos). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
			} catch (Exception se) {
				logger.error("("+this.usuario+") Error imprimiendo documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error imprimiendo documento,motivo: "+ se.getMessage(),
							"Error imprimiendo documento,Motivo: "+ se.getMessage());
				} catch (Exception e2) {
				}
			}
		}
	}
	public void eliminarRegistrador(ActionEvent e){
		int auxproc = this.proc.getIdprocedimiento();
		try{
			// Borra en cascada el ECG asociado a la mesa
			this.registradordao.delete(this.registradorpk);
			this.procdao.delete(this.procpk);
			this.iniciaRegistradores(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro de Registrador de eventos eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+":  "+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido eliminar el registro:  Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
		}
	}
	
	public void lecturaCodigoBarrasReg(ActionEvent e){
		try{
			ArrayList<String> lecturas = GestorCodigoBarras.lectura(this.registrador.getBarcode());
			Codigosgs128[] codigos = this.gs128dao.findByDynamicWhere("TIPO = ? AND CODIGO = ?", new Object[]{4,lecturas.get(0)});
			Registradoreventos reg = null;
			if(codigos!=null && codigos.length>0)
				reg = this.regdao.findByPrimaryKey(codigos[0].getIdmaterial());
			if(reg!=null){
				this.registrador.setIdmodeloreg(reg.getIdregistrador());
				this.registrador.setImplanteModelo(reg.getModelo());
				this.registrador.setNserie(lecturas.get(1));
				this.registrador.setMuestrabarcode(false);
			}else{
				this.registrador.setBarcode("");
				this.setNuevoreg(true); // variable de apertura de modalPanel
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,this.bundle.getString("mat_mag_warn_consulta_vacia"));	
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
				this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
			this.registrador.setBarcode("");
		}
	}
	
	public void lecturaCodigoBarrasNumSerie(ActionEvent e){
		ArrayList<String> lecturas = GestorCodigoBarras.lectura(this.registrador.getNserie());
		if(lecturas.get(1)!=null)
			this.registrador.setNserie(lecturas.get(1));	
	}
	
	public void cambiaModeloReg(ActionEvent e){
		try{
			String modgen = this.registrador.getImplanteModelo();
			Registradoreventos aux = null;
			try {
				aux = this.regdao.findWhereModeloEquals(modgen)[0];
			} catch (Exception e1) {
				e1.printStackTrace();
				this.registrador.setIdRegistrador(0);
				this.registrador.setImplanteModelo("");
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("mat_msg_warn_consulta_regev"));
			}
			if(aux!=null){
				this.registrador.setIdmodeloreg(aux.getIdregistrador());
				this.registrador.setImplanteModelo(aux.getModelo());
				this.registrador.setMuestrabarcode(false);
			}else{
				this.registrador.setBarcode("");
				//this.setNgen(true); // variable de apertura de modalPanel
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("mat_mag_warn_consulta_vacia"));
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
				this.bundle.getString("mat_mag_warn_consulta_error")+": "+e1.getMessage());
		}
	}
	
	public void cargarModelosReg(ActionEvent e) {
		if (this.isModreg())
			this.setModreg(false);
		else
			this.setModreg(true);
	}
	
	public void delNumSerieReg(ActionEvent e){
		this.registrador.setNserie(null);
	}
	
	static private String getRemoteFileName(long handle) {

		String remotePath = null;
		String remoteFileName = null;

		remotePath = "00000000" + Long.toHexString(handle);
		remotePath = remotePath.substring(remotePath.length() - 8, remotePath
				.length());
		remoteFileName = remotePath.substring(6, 8);

		return remoteFileName.toUpperCase();
	}

	static private String getRemotePath(long handle) {

		String remotePath = null;

		remotePath = "00000000" + Long.toHexString(handle);
		remotePath = remotePath.substring(remotePath.length() - 8, remotePath
				.length());
		remotePath = remotePath.substring(0, 2) + "/"
				+ remotePath.substring(2, 4) + "/" + remotePath.substring(4, 6);

		return remotePath.toUpperCase();
	}

	public void escribeEnClinica(boolean nuevo) throws Exception {
		DocHl7Dto consultaNueva = new DocHl7Dto();
		String path = printFichero();
		if (nuevo) {
			Integer numHandle;
			try {
				numHandle = UtilesTerminalSsh.getSiguienteID("SGHANINFEXT",
						true);
			} catch (SshException ex) {
				numHandle = -1;
			}
			consultaNueva.setHandle(numHandle);

			Integer numDocHl7Informes;
			try {
				numDocHl7Informes = UtilesTerminalSsh.getSiguienteID(
						"SGCODINFEXT", true);
			} catch (SshException ex) {
				numDocHl7Informes = -1;
			}
			consultaNueva.setIdinfor(numDocHl7Informes);
			consultaNueva.setIdinforext("" + this.registrador.getIdRegistrador());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.registrador.getEpisodio() != null && this.registrador.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.registrador.getEpisodio());
			else
				consultaNueva.setEpisodio("0");
			UsuarioDao usDao = new UsuarioDao();
        	SesionUsuarioDto ses = new SesionUsuarioDto();
        	ses.setLogin(this.usuario);
			String doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
			consultaNueva.setRedactor(doctor);
			consultaNueva.setResponprime(doctor);
			consultaNueva.setServicio("QCAR");
			Timestamp fecT = UtilFechas.dateToTimestamp(this.registrador.getFecha());
			consultaNueva.setFcreacion(fecT);
			Time t = new Time(fecT.getTime());
			consultaNueva.setHcreacion(t);
			consultaNueva.setIdtipodoc(57);
			consultaNueva.setIdsubti("ARR04");
			enviaInformeFTP(consultaNueva, true, path);

		} else {
			Timestamp fecT = UtilFechas.dateToTimestamp(this.registrador.getFecha());
			Time t = new Time(fecT.getTime());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.registrador.getEpisodio() != null && this.registrador.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.registrador.getEpisodio());
			else
				consultaNueva.setEpisodio("0");
			UsuarioDao usDao = new UsuarioDao();
        	SesionUsuarioDto ses = new SesionUsuarioDto();
        	ses.setLogin(this.usuario);
			String doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
			consultaNueva.setRedactor(doctor);
			consultaNueva.setResponprime(doctor);
			consultaNueva.setResponsegun(doctor);
			consultaNueva.setServicio("QCAR");
			consultaNueva.setIdinforext("" + this.registrador.getIdRegistrador());
			consultaNueva.setIdsubti("ARR04");
			consultaNueva.setIdtipodoc(57);
			consultaNueva.setFmodificacion(fecT);
			consultaNueva.setHmodificacion(t);
			enviaInformeFTP(consultaNueva, false, path);
		}
	}
	
	public void enviaInformeFTP(DocHl7Dto item, boolean nuevo, String path) {
		logInfo("Inicio de ControlConsulta.enviaInformeFTP");
		boolean seguir = true;
		try {
			if (nuevo) {
				DocHL7InformesDao docHL7InformesDao = new DocHL7InformesDao(this.usuario);
				docHL7InformesDao.añadirDocHL7Informes(item);
			} else {
				try{
					DocHL7InformesDao docHL7InformesDao = new DocHL7InformesDao(this.usuario);
					item.setHandle(new Integer(docHL7InformesDao
						.modificarDocHL7InformesIdExt(item)));
				}catch (Exception e) {
					//escribeEnClinica(true);
					seguir = false;
				}
			}

			if(seguir){
				String pathFTP = "";

				pathFTP = "/" + getRemotePath(item.getHandle()) + "/"
					+ getRemoteFileName(item.getHandle());

				if (GestorFTPInforme.enviarFicheroFTP(path, pathFTP) == 1) {
					File ficheroLocal = new File(path);
					ficheroLocal.delete();
				}
			}

		} catch (Exception ex) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error guardando informe. Motivo: "
						+ ex.getMessage());
		}
		logInfo("Fin de ControlConsulta.enviaInformeFTP");
	}
	
	public String printFichero() {
		String path = "";
		if (this.registrador.getIdRegistrador() == null) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_imprimir"));
		} else {
			ConstructorPdf constructorPDF = new ConstructorPdf();
			String PathFicheroXml = "";
			GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

			try {
				PathFicheroXml = generadorXML.imprimeInformeRegistrador(this.registrador,
						this.cp.pacienteSelect, this.getPuntuacion(),this.infocentro, this.bundle);
			} catch (Exception se) {
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error generando documento,motivo: "+ se.getMessage(),
							"Error generando documento,Motivo: "+ se.getMessage());
				} catch (Exception e3) {
				}
			}

			try {
				path = constructorPDF.generarArchivoPdfFile(FacesContext.getCurrentInstance(), 
						PathFicheroXml, "InformeRegistrador.jasper");
			} catch (Exception se) {
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error imprimiendo documento,motivo: "+ se.getMessage(),
							"Error imprimiendo documento,Motivo: "+ se.getMessage());
				} catch (Exception e2) {
				}
			}
		}
		return path;
	}
	
	public void cargaMesa(ActionEvent e){
		Integer fila = this.bindingHistorico.getRowIndex();
		this.registrador =  this.registradores.get(fila);
		this.registradorpk = this.registrador.createPk();
		this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
		this.calculaPuntuacion(e);
		try {
			this.registrador.setEcgdto(this.registradorecgdao.findByPrimaryKey(this.registradorpk.getIdRegistrador()));
		} catch (ArrRegistradorEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Se ha producido un error obteniendo los datos de la mesa: " + e1.getMessage());
		}
	}
	public void cargaRegistrador(ActionEvent e){
		try {
			this.proc = this.procs.get(this.bindingHistorico.getRowIndex());
			this.procpk = this.proc.createPk();
			this.registrador = this.registradordao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.registrador.setMuestrabarcode(false);
			this.registradorpk = this.registrador.createPk();
			this.calculaPuntuacion(e);
			this.registrador.setEcgdto(this.registradorecgdao.findByPrimaryKey(this.registradorpk.getIdRegistrador()));
			this.cargaComplicacionesProc();
			this.compac.setFechaini(this.registrador.getFecha());
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
		} catch (ArrRegistradorDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());	
		} catch (ArrRegistradorEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());	
		}
	}
	public void cargaRegistradorDesdeBarraTemporal(ActionEvent e){
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),1067})[0];
			this.procpk = this.proc.createPk();
			this.registrador = this.registradordao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.registrador.setMuestrabarcode(false);
			this.registradorpk = this.registrador.createPk();
			this.calculaPuntuacion(e);
			this.registrador.setEcgdto(this.registradorecgdao.findByPrimaryKey(this.registradorpk.getIdRegistrador()));
			this.cargaComplicacionesProc();
			this.compac.setFechaini(this.registrador.getFecha());
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro . Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ArrRegistradorDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());	
			logger.error("("+this.usuario+") No se puede recuperar el registro . Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ArrRegistradorEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro . Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	public void cargaRegistradorConsulta(ActionEvent e){
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getPacienteSelect().getIdreg(),1067})[0];
			this.procpk = this.proc.createPk();
			this.registrador = this.registradordao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.registrador.setMuestrabarcode(false);
			this.registradorpk = this.registrador.createPk();
			this.calculaPuntuacion(e);
			this.registrador.setEcgdto(this.registradorecgdao.findByPrimaryKey(this.registradorpk.getIdRegistrador()));
			this.cargaComplicacionesProc();
			this.compac.setFechaini(this.registrador.getFecha());
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro . Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ArrRegistradorDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());	
			logger.error("("+this.usuario+") No se puede recuperar el registro . Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ArrRegistradorEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro . Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	
	public void cargaRegistradorProtocolo(Integer idproc){
		try {
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {idproc,1067})[0];
			this.procpk = this.proc.createPk();
			this.registrador = this.registradordao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.registrador.setMuestrabarcode(false);
			this.registradorpk = this.registrador.createPk();
			this.calculaPuntuacion(null);
			this.registrador.setEcgdto(this.registradorecgdao.findByPrimaryKey(this.registradorpk.getIdRegistrador()));
			this.cargaComplicacionesProc();
			this.compac.setFechaini(this.registrador.getFecha());
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro . Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ArrRegistradorDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());	
			logger.error("("+this.usuario+") No se puede recuperar el registro . Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ArrRegistradorEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro . Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+" Error: "+ e1.getMessage());
		}
	}
	
	public void cargaComplicacionesProc(){
		cc.obtenerComplicacionesPacienteProc(this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacompl.add(cpac);
	}
	
	public void calculaPuntuacion(ActionEvent e){
		if(this.registrador != null && this.registrador.getCardiopatia() != null && this.registrador.getCardiopatia() == 0)
			this.puntuacion = puntuacionNoCardiopatia();
		else if(this.registrador != null && this.registrador.getCardiopatia() != null && this.registrador.getCardiopatia() == 1)
			this.puntuacion = puntuacionSiCardiopatia();
		else
			this.puntuacion = 0;
		if (this.puntuacion != null)
			this.comprobar = true;
	}
	
	public void reiniciaResultadoCardio(ActionEvent e){
		this.registrador.setSheldonA(-1);
		this.registrador.setSheldonB(-1);
		this.registrador.setSheldonC(-1);
		this.registrador.setSheldonD(-1);
		this.registrador.setSheldonE(-1);
		this.registrador.setSheldonF(-1);
		this.registrador.setSheldonG(-1);
		
		this.calculaPuntuacion(e);
		this.comprobar = false;
	}
	
	public void reiniciaResultadon1(ActionEvent e){
		this.registrador.setResN2(-1);
		}
	
	public void reiniciaResultadon2(ActionEvent e){
		
	}
	
	public void guardaComplicacion(ActionEvent e){
		this.compac.setIdpaciente(this.cp.getPacienteSelect().getCodigo());
		this.compac.setIdprocedimiento(this.proc.getIdprocedimiento());
		this.compac.setTipoprocedimiento(this.proc.getTipoprocedimiento());
		this.compac.setIdrelacion(4);
		cc.addItemComplicacion(this.compac);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacompl.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacompl.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.compac = new ComplicacionesPacientes();
		this.compac.setFechaini(this.registrador.getFecha());
		this.compac.setTipo(1);
	}
	
	public void preEditarProc(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		ComplicacionesPacientes aux = this.getListacompl().get(this.bindingComplicacionesProc.getRowIndex());	
		this.currentItemComp.setIdcompac(aux.getIdcompac());
		this.currentItemComp.setIdpaciente(aux.getIdpaciente());
		this.currentItemComp.setTipo(aux.getTipo());
		this.currentItemComp.setTipoprocedimiento(aux.getTipoprocedimiento());
		this.currentItemComp.setIdprocedimiento(aux.getIdprocedimiento());
		this.currentItemComp.setComplicacion(aux.getComplicacion());
		this.currentItemComp.setComplicacion1(aux.getComplicacion1());
		this.currentItemComp.setComplicacionOtra(aux.getComplicacionOtra());
		this.currentItemComp.setIdrelacion(aux.getIdrelacion());
		this.currentItemComp.setIdlugar(aux.getIdlugar());
		this.currentItemComp.setFechaini(aux.getFechaini());
		this.currentItemComp.setFechafin(aux.getFechafin());
		this.currentItemComp.setResuelta(aux.getResuelta());
		this.currentItemComp.setResueltaOtros(aux.getResueltaOtros());
		this.currentItemComp.setTratamiento(aux.getTratamiento());
		this.currentItemComp.setTratamientoDescr(aux.getTratamientoDescr());
		this.currentItemComp.setTratamientoTipo(aux.getTratamientoTipo());
		this.currentItemComp.setIngreso(aux.getIngreso());
		this.currentItemComp.setDescripcion(aux.getDescripcion());
		this.currentItemComp.setFechaProc(aux.getFechaProc());
		this.setEditableProc(true);
	}
	
	public void actualizaItemComplicacion(ActionEvent e){
		cc.editItemComplicacion(this.currentItemComp);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacompl.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacompl.add(cpac);
		// reinicia el objeto con los datos maestros de este formulario
		this.currentItemComp = new ComplicacionesPacientes();
	}
	
	public void cancelarItemComplicacion(ActionEvent e){
		this.setEditableProc(false);
	}
	
	public void delItemComplicacion(ActionEvent e){
		Integer pos = this.bindingComplicacionesProc.getRowIndex();
		ComplicacionesPacientes item = this.listacompl.get(pos);
		cc.delItemComplicacion(item);
		cc.obtenerComplicacionesPacienteProc(this.cp.getPacienteSelect().getCodigo(), this.proc.getIdprocedimiento(), this.proc.getTipoprocedimiento());
		this.listacompl.clear();
		for(ComplicacionesPacientes cpac:cc.getListacompacproc())
			this.listacompl.add(cpac);
	}
	
	public void limpiarComp(ActionEvent e){
		this.compac = new ComplicacionesPacientes();
		this.compac.setFechaini(this.registrador.getFecha());
		this.compac.setTipo(1);
	}
	
	public void sortHistorico(final String columna, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				ArrRegistrador c1 = (ArrRegistrador) o1;
				ArrRegistrador c2 = (ArrRegistrador) o2;
				try {
					if (columna == null) {
						return 0;
					}
					if (columna.equals("codigo")) {
						return ascending ? c1.getNproc()
								.compareTo(c2.getNproc()) : c2
								.getNproc().compareTo(c1.getNproc());
					} else if (columna.equals("fecha")) {
						return ascending ? c1.getFecha().compareTo(
								c2.getFecha()) : c2.getFecha().compareTo(
								c1.getFecha());
					} else
						return 0;
				} catch (Exception ex) {
					return 0;
				}
			}
		};
		Collections.sort(this.registradores, comparator);
	}

	public void consultaProtocolos(ActionEvent e){
		try{
			Protocolos[] lista = this.protdao.findWhereCodigoEquals(this.cp.getPacienteSelect().getCodigo());
			this.listaprot.clear();
			for(Protocolos pr:lista)
				this.listaprot.add(pr);
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("prot_modal_msg_error_lista")+": " + e1.getMessage());
		}
	}
	
	public void vincularProtocolo(ActionEvent e){
		try{
			Integer iprt = this.bindingProt.getRowIndex();
			if(iprt != null && iprt >= 0){
				Protocolos prt = this.listaprot.get(iprt);
				ControlProtocolos cpr = (ControlProtocolos) getBean("controlProtocolos");
				int res = cpr.vincularProcedimientoProtocolo(this.proc, prt);
				if(res==0)
					this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("prot_sincope_msg_warn_vinc"));
				else if(res==1)
					this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("prot_sincope_msg_info_vinc"));
				else if(res==-1)
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("prot_sincope_msg_error_vinc"));
			}
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("prot_modal_msg_error_lista")+": " + e1.getMessage());
		}
	}
	
	public void irProtocolo(ActionEvent e){
		try{
			Integer iprt = this.bindingProt.getRowIndex();
			if(iprt != null && iprt >= 0){
				ControlProtocolos cpr = (ControlProtocolos) getBean("controlProtocolos");
				Protocolos prt = this.listaprot.get(iprt);
				cpr.cargaProtocolo(prt.getIdprotocolo());
			}
		}catch(Exception e1){
			this.pintaMensaje(3, this.bundle.getString("prot_sincope_msg_error_consulta_2")+": " + e1.getMessage());
		}
	}
	
	public ArrRegistrador getRegistrador() {
		return registrador;
	}

	public void setRegistrador(ArrRegistrador reg) {
		this.registrador =  reg;
	}

	public Integer getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	public boolean getComprobar() {
		return comprobar;
	}

	private Integer puntuacionNoCardiopatia(){
		Integer pt = 0;
		if(this.registrador.getSheldonA() != null && this.registrador.getSheldonA() == 1)
			pt -= 5;
		if(this.registrador.getSheldonB() != null && this.registrador.getSheldonB() == 1)
			pt -= 4;
		if(this.registrador.getSheldonC() != null && this.registrador.getSheldonC() == 1)
			pt -= 3;
		if(this.registrador.getSheldonD() != null && this.registrador.getSheldonD() == 1)
			pt -= 2;
		if(this.registrador.getSheldonE() != null && this.registrador.getSheldonE() == 1)
			pt += 1;
		if(this.registrador.getSheldonF() != null && this.registrador.getSheldonF() == 1)
			pt += 2;
		if(this.registrador.getSheldonG() != null && this.registrador.getSheldonG() == 1)
			pt += 3;
		return pt;
	}
	
	private Integer puntuacionSiCardiopatia(){
		Integer pt = 0;
		if(this.registrador.getSheldonA() != null && this.registrador.getSheldonA() == 1)
			pt += 3;
		if(this.registrador.getSheldonB() != null && this.registrador.getSheldonB() == 1)
			pt += 1;
		if(this.registrador.getSheldonC() != null && this.registrador.getSheldonC() == 1)
			pt -= 1;
		if(this.registrador.getSheldonD() != null && this.registrador.getSheldonD() == 1)
			pt -= 2;
		if(this.registrador.getSheldonE() != null && this.registrador.getSheldonE() == 1)
			pt -= 2;
		if(this.registrador.getSheldonF() != null && this.registrador.getSheldonF() == 1)
			pt -= 2;
		return pt;
	}
	
	public ArrayList<SelectItem> getReferidores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_referidor")));
		for (ArrMaestras ref : this.referidores)
			diag.add(new SelectItem(ref.getValor(), ref.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getModeloImplantes() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("", this.bundle.getString("seleccione_modelo")));
		for (ArrMaestras ref : this.modeloImplantes)
			diag.add(new SelectItem(ref.getValor(), ref.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getTipos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem("1", this.bundle.getString("prot_tipo_op1")));
		return diag;
	}

	public ArrayList<EpisodioDto> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(ArrayList<EpisodioDto> episodios) {
		this.episodios = episodios;
	}

	public HtmlDataTable getBindingepi() {
		return bindingepi;
	}

	public void setBindingepi(HtmlDataTable bindingepi) {
		this.bindingepi = bindingepi;
	}

	public HtmlDataTable getBindingHistorico() {
		return bindingHistorico;
	}

	public void setBindingHistorico(HtmlDataTable bindingHistorico) {
		this.bindingHistorico = bindingHistorico;
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

	public ArrayList<ArrRegistrador> getRegistradores() {
		sortHistorico(this.columna, this.ascendente);
		return registradores;
	}

	public void setRegistradores(ArrayList<ArrRegistrador> reg) {
		this.registradores =  reg;
	}

	public HtmlDataTable getBindingHistoricoRegistrador() {
		return bindingHistoricoRegistrador;
	}

	public void setBindingHistoricoRegistrador(
			HtmlDataTable bindingHistoricoRegistrador) {
		this.bindingHistoricoRegistrador = bindingHistoricoRegistrador;
	}
	public void lecturaProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
		p.load(is);
		is.close();
		this.infocentro = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
					p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"));
	}

	public HtmlDataTable getBindingBuscar() {
		return bindingBuscar;
	}

	public void setBindingBuscar(HtmlDataTable bindingBuscar) {
		this.bindingBuscar = bindingBuscar;
	}

	public ArrayList<Procedimiento> getProcs() {
		return procs;
	}

	public void setProcs(ArrayList<Procedimiento> procs) {
		this.procs = procs;
	}
	
	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public ArrayList<RegistradorSeguimientosBean> getLista() {
		return lista;
	}

	public void setLista(ArrayList<RegistradorSeguimientosBean> lista) {
		this.lista = lista;
	}

	public HtmlDataTable getBindingRegistrador() {
		return bindingRegistrador;
	}

	public void setBindingRegistrador(HtmlDataTable bindingRegistrador) {
		this.bindingRegistrador = bindingRegistrador;
	}

	public HtmlDataTable getBindingSeguimientos() {
		return bindingSeguimientos;
	}

	public void setBindingSeguimientos(HtmlDataTable bindingSeguimientos) {
		this.bindingSeguimientos = bindingSeguimientos;
	}

	public void setRegs(Registradoreventos[] regs) {
		this.regs = regs;
	}

	public boolean isModreg() {
		return modreg;
	}

	public void setModreg(boolean modreg) {
		this.modreg = modreg;
	}

	public void setRegs2(Registradoreventos[] regs2) {
		this.regs2 = regs2;
	}
	
	public ArrayList<SelectItem> getRegs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		for (Registradoreventos ref : this.regs)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}
	public ArrayList<SelectItem> getRegs2() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		for (Registradoreventos ref : this.regs2)
			diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}

	public boolean isNuevoreg() {
		return nuevoreg;
	}

	public void setNuevoreg(boolean nuevoreg) {
		this.nuevoreg = nuevoreg;
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

	public HtmlDataTable getBindingComplicacionesProc() {
		return bindingComplicacionesProc;
	}

	public void setBindingComplicacionesProc(HtmlDataTable bindingComplicacionesProc) {
		this.bindingComplicacionesProc = bindingComplicacionesProc;
	}

	public ArrayList<ComplicacionesPacientes> getListacompl() {
		return listacompl;
	}

	public void setListacompl(ArrayList<ComplicacionesPacientes> listacompl) {
		this.listacompl = listacompl;
	}

	public boolean isEditableProc() {
		return editableProc;
	}

	public void setEditableProc(boolean editableProc) {
		this.editableProc = editableProc;
	}

	public ArrayList<Protocolos> getListaprot() {
		return listaprot;
	}

	public void setListaprot(ArrayList<Protocolos> listaprot) {
		this.listaprot = listaprot;
	}

	public HtmlDataTable getBindingProt() {
		return bindingProt;
	}

	public void setBindingProt(HtmlDataTable bindingProt) {
		this.bindingProt = bindingProt;
	}
	
}

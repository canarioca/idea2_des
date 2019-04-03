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
import java.util.ArrayList;
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

import com.sorin.idea.dao.ArrMesasDao;
import com.sorin.idea.dao.ArrMesasEcgDao;
import com.sorin.idea.dao.DocHL7InformesDao;
import com.sorin.idea.dao.EpisodioDao;
import com.sorin.idea.dao.EventoDao;
import com.sorin.idea.dao.PacienteDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.ProtocolosDao;
import com.sorin.idea.dao.UsuarioDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrMesas;
import com.sorin.idea.dto.ArrMesasPk;
import com.sorin.idea.dto.Episodio;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.Protocolos;
import com.sorin.idea.exceptions.ArrMesasDaoException;
import com.sorin.idea.exceptions.ArrMesasEcgDaoException;
import com.sorin.idea.jdbc.ArrMesasDaoImpl;
import com.sorin.idea.jdbc.ArrMesasEcgDaoImpl;
import com.sorin.idea.jdbc.EpisodioDaoImpl;
import com.sorin.idea.jdbc.EventoDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ProtocolosDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.GestorFTPInforme;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilMapeos;

public class ControlMesas extends BaseIU {
	private static Logger logger = Logger.getLogger(ControlMesas.class);
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private ArrMesas mesa;
	private ArrMesasPk mesapk;
	private Integer puntuacion = 0;
	private boolean comprobar = false;

	private ArrayList<ArrMesas> mesas;
	private ArrMesas[] mesaslst;
	
	private ArrMaestras[] referidores;
	
	private ArrMesasDao mesadao;
	private ArrMesasEcgDao mesaecgdao;
	
	private ControlPacientes cp;
	private LoginForm lf;
	private HtmlDataTable bindingHistorico;
	private HtmlDataTable bindingHistoricoMesas;
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
	
	private boolean editable;
	
	private ProtocolosDao protdao;
	private ArrayList<Protocolos> listaprot;
	private HtmlDataTable bindingProt;
	
	public void iniciaMesas(ActionEvent e) {
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
			this.setEditable(true);
			this.proc = new Procedimiento();
			this.proc.setFecha(new Date());
			this.procdao = new ProcedimientoDaoImpl(this.usuario);
			this.procpk = new ProcedimientoPk();
			this.procs = new ArrayList<Procedimiento>();
			this.epdao = new EpisodioDaoImpl(this.usuario);
			this.evdao = new EventoDaoImpl(this.usuario);
			
			this.mesa = new ArrMesas();
			this.mesapk = new ArrMesasPk();
			this.referidores = cm.getReferidores();
			this.puntuacion = 0;
			this.comprobar = false;
			this.mesas = new ArrayList<ArrMesas>();	
			this.mesadao = new ArrMesasDaoImpl(this.usuario);
			this.mesaecgdao = new ArrMesasEcgDaoImpl();
			this.protdao = new ProtocolosDaoImpl(this.usuario);
			this.listaprot = new ArrayList<Protocolos>();
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,
						this.bundle.getString("info_msg_error_sel_pat"));
			}else{
				this.proclst = this.procdao.findByDynamicWhere("CODIGO =? AND TIPOPROCEDIMIENTO = ?",
						new Object[] {this.cp.getPacienteSelect().getCodigo(),1066});	
				if(this.proclst != null)
					for(Procedimiento p:this.proclst)
						this.procs.add(p);
				this.mesa.setIdPaciente(this.cp.getPacienteSelect().getCodigo());
				/*this.mesaslst = this.mesadao.findWhereIdPacienteEquals(this.mesa.getIdPaciente());
				if (this.mesaslst != null)
					for (ArrMesas m : this.mesaslst)
						this.mesas.add(m);*/
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_rec_pat")+": "+ e1.getMessage());
		}
	}
	
	public void limpia(ActionEvent e) {
		this.mesa = new ArrMesas();
		this.mesapk = new ArrMesasPk();
		this.mesa.setIdPaciente(this.cp.getPacienteSelect().getCodigo());
		this.puntuacion = 0;
		this.comprobar = false;
		this.mesas = new ArrayList<ArrMesas>();
	}
	
	public void preguarda(ActionEvent e) {
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
				if(ev!=null && ev.getProcedimiento()==1066 && ev.getEstado()==1 && proc_ep.length==0)
					this.episodios.add(new EpisodioDto(ep.getIdpaciente(),ep.getIdentificador(),ep.getFechaini(),ep.getFechafin(),ep.getUnidadfuncional(),ep.getTipo(),ep.getIdepisodio(),ev.getIdentificador(),UtilMapeos.mapeoTipoProcedimiento(ev.getProcedimiento())));
				
			}
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_error_carga_epi")+": "+ e1.getMessage());
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
			this.mesa.setEpisodio(this.episodios.get(epi).getNumicu());
			this.proc.setIdepisodio(this.episodios.get(epi).getIdEpisodio());
		}			
		boolean existe = false;
		try {
			if (this.mesa.getFecha() == null) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Introduzca la fecha");
			} else {
				if (this.mesa.getNproc() == null || this.mesa.getNproc().length() != 5)
					this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
							this.bundle.getString("info_msg_guarda_error_nproc")+" "
								+ ((this.mesa.getFecha().getYear() + 1900) + "").substring(2) + " "+this.bundle.getString("info_msg_guarda_error_nproc_1"));
				else {
					ArrMesas[] ests = this.mesadao.findByDynamicWhere(
							" nproc = ?", new Object[] { this.mesa.getNproc() });
					if (ests != null && ests.length > 0)
						if (this.mesa.getIdMesa() == null) {
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
									this.bundle.getString("info_msg_guarda_error_nproc_prev"));
							existe = true;
						} else if (!ests[0].getIdMesa().equals(this.mesa.getIdMesa())) {
							this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
									this.bundle.getString("info_msg_guarda_error_nproc_prev"));
							existe = true;
						}
					if (!existe) {
						if (this.mesa.getIdMesa() != null){
							this.proc.setFecha(this.mesa.getFecha());
							this.procdao.update(this.proc.createPk(), this.proc);
							this.mesadao.update(this.mesa.createPk(), this.mesa);
							this.mesaecgdao.update(this.mesa.getEcgdto().createPk(), this.mesa.getEcgdto());
							//escribeEnClinica(false);
							this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
							this.pintaMensaje(INFO, this.bundle.getString("info_msg_editar_info"));
							logger.info("("+this.usuario+") Registro mesa basculante actualizado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
						}else {
							this.mesapk = this.mesadao.insert(this.mesa);
							this.mesa.setIdMesa(this.mesapk.getIdMesa());
							this.mesa.getEcgdto().setIdmesa(this.mesa.getIdMesa());
							this.mesaecgdao.insert(this.mesa.getEcgdto());
							//escribeEnClinica(true);
							this.proc.setFecha(this.mesa.getFecha());
							this.proc.setIdprocedimiento(this.mesa.getIdMesa());
							this.proc.setTipoprocedimiento(1066);
							this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
							this.procpk = this.procdao.insert(this.proc);
							this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_guarda"));
							logger.info("("+this.usuario+") Registro mesa basculante insertado. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
						}
						//cp.precarga(null);
						//this.pintaMensaje(Mensaje.SEVERIDAD_INFO,"Datos almacenados con éxito");
					}
				}
			}
		} catch (ArrMesasDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_guarda_error_exep")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error intentando guardar los datos: "+ e1.getMessage());
		} catch (Exception e1) {
			this.pintaMensaje(3, this.bundle.getString("info_msg_guarda_error_exep")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Se ha producido un error intentando guardar los datos: "+ e1.getMessage());
		}
	}
	
	public void imprimeInforme(ActionEvent e) {
		if (this.mesa.getIdMesa() == null) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_imprimir"));
		} else {
			ConstructorPdf constructorPDF = new ConstructorPdf();
			String PathFicheroXml = "";
			GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

			try {
				PathFicheroXml = generadorXML.imprimeInformeMesa(this.mesa,
						this.cp.pacienteSelect, this.getPuntuacion(),this.infocentro,this.bundle);
				constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml,"InformeMesas.jasper");
				logger.info("("+this.usuario+") Generación de informe (Mesa basculante). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
			} catch (Exception se) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_impr_gen_doc")+": "+ se.getMessage());
				logger.error("("+this.usuario+") Error generando documento. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo()+". Motivo: "+ se.getMessage());
			}
		}
	}
	
	public void eliminarMesa(ActionEvent e){
		int auxproc = this.proc.getIdprocedimiento();
		try{
			// Borra en cascada el ECG asociado a la mesa
			this.mesadao.delete(this.mesapk);
			this.procdao.delete(this.procpk);
			this.iniciaMesas(null);
			// Actualiza para quitar el evento de la barra temporal
			cp.precarga(null);
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_borrado"));
			logger.info("("+this.usuario+") Registro de Mesa basculante eliminado con éxito. Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se ha podido eliminar el registro:  Id Procedimiento:"+auxproc+", Id Paciente: "+this.cp.getPacienteSelect().getCodigo()+". Motivo: "+ e1.getMessage());
		}
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
			consultaNueva.setIdinforext("" + this.mesa.getIdMesa());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.mesa.getEpisodio() != null && this.mesa.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.mesa.getEpisodio());
			else
				consultaNueva.setEpisodio("0");
			UsuarioDao usDao = new UsuarioDao();
        	SesionUsuarioDto ses = new SesionUsuarioDto();
        	ses.setLogin(this.usuario);
			String doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
			consultaNueva.setRedactor(doctor);
			consultaNueva.setResponprime(doctor);
			consultaNueva.setServicio("QCAR");
			Timestamp fecT = UtilFechas.dateToTimestamp(this.mesa.getFecha());
			consultaNueva.setFcreacion(fecT);
			Time t = new Time(fecT.getTime());
			consultaNueva.setHcreacion(t);
			consultaNueva.setIdtipodoc(57);
			consultaNueva.setIdsubti("ARR04");
			enviaInformeFTP(consultaNueva, true, path);

		} else {
			Timestamp fecT = UtilFechas.dateToTimestamp(this.mesa.getFecha());
			Time t = new Time(fecT.getTime());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.mesa.getEpisodio() != null && this.mesa.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.mesa.getEpisodio());
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
			consultaNueva.setIdinforext("" + this.mesa.getIdMesa());
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
		if (this.mesa.getIdMesa() == null) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_warn_imprimir"));
		} else {
			ConstructorPdf constructorPDF = new ConstructorPdf();
			String PathFicheroXml = "";
			GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

			try {
				PathFicheroXml = generadorXML.imprimeInformeMesa(this.mesa,
						this.cp.pacienteSelect, this.getPuntuacion(),this.infocentro,this.bundle);
				path = constructorPDF.generarArchivoPdfFile(FacesContext.getCurrentInstance(), PathFicheroXml, "InformeMesas.jasper");
			} catch (Exception se) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_impr_gen_doc")+": "+ se.getMessage());
			}
		}
		return path;
	}
	
	public void cargaMesa_OLD(ActionEvent e){
		Integer fila = this.bindingHistorico.getRowIndex();
		this.mesa = this.mesas.get(fila);
		this.mesapk = this.mesa.createPk();
		this.calculaPuntuacion(e);
		try {
			this.mesa.setEcgdto(this.mesaecgdao.findByPrimaryKey(this.mesapk.getIdMesa()));
		} catch (ArrMesasEcgDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		}
	}
	public void cargaMesa(ActionEvent e){
		try{
			this.proc = this.procs.get(this.bindingHistorico.getRowIndex());
			this.procpk = this.proc.createPk();
			this.mesa = this.mesadao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.mesapk = this.mesa.createPk();
			this.calculaPuntuacion(e);
			this.mesa.setEcgdto(this.mesaecgdao.findByPrimaryKey(this.mesapk.getIdMesa()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
		}
	}
	public void cargaMesaDesdeBarraTemporal(ActionEvent e){
		try{
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),1066})[0];
			this.procpk = this.proc.createPk();
			this.mesa = this.mesadao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.mesapk = this.mesa.createPk();
			this.calculaPuntuacion(e);
			this.mesa.setEcgdto(this.mesaecgdao.findByPrimaryKey(this.mesapk.getIdMesa()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Mesa basculante). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Mesa basculante) ID:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}
	}
	public void cargaMesaConsulta(ActionEvent e){
		try{
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getPacienteSelect().getIdmesa(),1066})[0];
			this.procpk = this.proc.createPk();
			this.mesa = this.mesadao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.mesapk = this.mesa.createPk();
			this.calculaPuntuacion(e);
			this.mesa.setEcgdto(this.mesaecgdao.findByPrimaryKey(this.mesapk.getIdMesa()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Mesa basculante). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Mesa basculante) ID:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}
	}
	public void cargaMesaProtocolo(Integer idproc){
		try{
			//this.proc = this.procdao.findWhereIdprocedimientoEquals(cp.getNumeroprocedimientobarratemporal())[0];
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {idproc,1066})[0];
			this.procpk = this.proc.createPk();
			this.mesa = this.mesadao.findByPrimaryKey(this.proc.getIdprocedimiento());
			this.mesapk = this.mesa.createPk();
			this.calculaPuntuacion(null);
			this.mesa.setEcgdto(this.mesaecgdao.findByPrimaryKey(this.mesapk.getIdMesa()));
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro (Mesa basculante). Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": " + e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro (Mesa basculante) ID:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}
	}
	public void calculaPuntuacion(ActionEvent e){
		if(this.mesa != null && this.mesa.getCardiopatia() != null && this.mesa.getCardiopatia() == 0)
			this.puntuacion = puntuacionNoCardiopatia();
		else if(this.mesa != null && this.mesa.getCardiopatia() != null && this.mesa.getCardiopatia() == 1)
			this.puntuacion = puntuacionSiCardiopatia();
		else
			this.puntuacion = 0;
		if (this.puntuacion != null)
			this.comprobar = true;
	}
	
	public void reiniciaResultadoCardio(ActionEvent e){
		this.mesa.setSheldonA(-1);
		this.mesa.setSheldonB(-1);
		this.mesa.setSheldonC(-1);
		this.mesa.setSheldonD(-1);
		this.mesa.setSheldonE(-1);
		this.mesa.setSheldonF(-1);
		this.mesa.setSheldonG(-1);
		this.calculaPuntuacion(e);
		this.comprobar = false;
	}
	
	public void reiniciaResultadon1(ActionEvent e){
		this.mesa.setResN2(-1);
		this.mesa.setResN3(-1);
		this.mesa.setResTiempo("");
	}
	
	public void reiniciaResultadon2(ActionEvent e){
		this.mesa.setResN3(-1);
		this.mesa.setResTiempo("");
	}
	
	public void sortHistorico(final String columna, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				ArrMesas c1 = (ArrMesas) o1;
				ArrMesas c2 = (ArrMesas) o2;
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
		Collections.sort(this.mesas, comparator);
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
	
	public ArrMesas getMesa() {
		return mesa;
	}

	public void setMesa(ArrMesas mesa) {
		this.mesa = mesa;
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
		if(this.mesa.getSheldonA() != null && this.mesa.getSheldonA() == 1)
			pt -= 5;
		if(this.mesa.getSheldonB() != null && this.mesa.getSheldonB() == 1)
			pt -= 4;
		if(this.mesa.getSheldonC() != null && this.mesa.getSheldonC() == 1)
			pt -= 3;
		if(this.mesa.getSheldonD() != null && this.mesa.getSheldonD() == 1)
			pt -= 2;
		if(this.mesa.getSheldonE() != null && this.mesa.getSheldonE() == 1)
			pt += 1;
		if(this.mesa.getSheldonF() != null && this.mesa.getSheldonF() == 1)
			pt += 2;
		if(this.mesa.getSheldonG() != null && this.mesa.getSheldonG() == 1)
			pt += 3;
		return pt;
	}
	
	private Integer puntuacionSiCardiopatia(){
		Integer pt = 0;
		if(this.mesa.getSheldonA() != null && this.mesa.getSheldonA() == 1)
			pt += 3;
		if(this.mesa.getSheldonB() != null && this.mesa.getSheldonB() == 1)
			pt += 1;
		if(this.mesa.getSheldonC() != null && this.mesa.getSheldonC() == 1)
			pt -= 1;
		if(this.mesa.getSheldonD() != null && this.mesa.getSheldonD() == 1)
			pt -= 2;
		if(this.mesa.getSheldonE() != null && this.mesa.getSheldonE() == 1)
			pt -= 2;
		if(this.mesa.getSheldonF() != null && this.mesa.getSheldonF() == 1)
			pt -= 2;
		return pt;
	}
	
	public ArrayList<SelectItem> getReferidores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_referidor")));
		for (ArrMaestras ref : this.referidores)
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

	public ArrayList<ArrMesas> getMesas() {
		sortHistorico(this.columna, this.ascendente);
		return mesas;
	}

	public void setMesas(ArrayList<ArrMesas> mesas) {
		this.mesas = mesas;
	}

	public HtmlDataTable getBindingHistoricoMesas() {
		return bindingHistoricoMesas;
	}

	public void setBindingHistoricoMesas(HtmlDataTable bindingHistoricoMesas) {
		this.bindingHistoricoMesas = bindingHistoricoMesas;
	}
	public void lecturaProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
		p.load(is);
		is.close();
		this.infocentro = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
					p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"));
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

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
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

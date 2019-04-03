package com.sorin.idea.iu;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.log4j.Logger;

import com.sorin.idea.convertidores.ConvertidorRCNutricionista;
import com.sorin.idea.convertidores.ConvertidorRCPsicologia;
import com.sorin.idea.convertidores.ConvertidorRCRehabilitador;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dto.NutricionistaDTO;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.PsicologaDTO;
import com.sorin.idea.dto.RcNutricion;
import com.sorin.idea.dto.RcNutricionPk;
import com.sorin.idea.dto.RcPsicoApoyoSocial;
import com.sorin.idea.dto.RcPsicoCalidadSueno;
import com.sorin.idea.dto.RcPsicoEstadoCivil;
import com.sorin.idea.dto.RcPsicoFamilia;
import com.sorin.idea.dto.RcPsicoNivelEstudios;
import com.sorin.idea.dto.RcPsicoNivelIrritabilidad;
import com.sorin.idea.dto.RcPsicoNivelSatisfaccion;
import com.sorin.idea.dto.RcPsicoRelacionSueno;
import com.sorin.idea.dto.RcPsicoRelacionSuenoPk;
import com.sorin.idea.dto.RcPsicoSituacionEconomica;
import com.sorin.idea.dto.RcPsicoSituacionLaboral;
import com.sorin.idea.dto.RcPsicoVidaSexual;
import com.sorin.idea.dto.RcPsicologia;
import com.sorin.idea.dto.RcPsicologiaPk;
import com.sorin.idea.dto.RcRehaNivelEducativo;
import com.sorin.idea.dto.RcRehaProbArticulares;
import com.sorin.idea.dto.RcRehaProbCognitivos;
import com.sorin.idea.dto.RcRehaProbSensoriales;
import com.sorin.idea.dto.RcRehabilitacionCardiaca;
import com.sorin.idea.dto.RcRehabilitacionCardiacaPk;
import com.sorin.idea.dto.RcRehabilitador;
import com.sorin.idea.dto.RcRehabilitadorPk;
import com.sorin.idea.dto.RehabiliatadorDTO;
import com.sorin.idea.dto.RehabilitacionCardiacaDTO;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.exceptions.RcNutricionDaoException;
import com.sorin.idea.exceptions.RcPsicoRelacionSuenoDaoException;
import com.sorin.idea.exceptions.RcPsicologiaDaoException;
import com.sorin.idea.exceptions.RcRehabilitacionCardiacaDaoException;
import com.sorin.idea.exceptions.RcRehabilitadorDaoException;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.servicios.impl.ServicioProcedimientoImpl;
import com.sorin.idea.servicios.impl.ServicioRCNutricionImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoApoyoSocialImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoCalidadSuenoImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoEstadoCivilImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoFamiliaImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoNivelEstudiosImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoNivelIrritabilidadImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoNivelSatisfaccionImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoRelacionSuenoImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoSituacionEconomicaImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoSituacionLaboralImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicoVidaSexualImpl;
import com.sorin.idea.servicios.impl.ServicioRCPsicologiaImpl;
import com.sorin.idea.servicios.impl.ServicioRCRehaNivelEducativoImpl;
import com.sorin.idea.servicios.impl.ServicioRCRehaProbArticularesImpl;
import com.sorin.idea.servicios.impl.ServicioRCRehaProbCognitivosImpl;
import com.sorin.idea.servicios.impl.ServicioRCRehaProbSensorialesImpl;
import com.sorin.idea.servicios.impl.ServicioRCRehabilitadorImpl;
import com.sorin.idea.servicios.impl.ServicioRehabilitacionCardiacaImpl;
import com.sorin.idea.util.UtilDatos;

import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

public class ControlRehabilitacionCardiaca extends BaseIU {
	
	private static final long serialVersionUID = -9124682645981585801L;
	
	private static Logger logger = Logger.getLogger(ControlRehabilitacionCardiaca.class);
	
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private RehabilitacionCardiacaDTO rehabilitacionCardiacaDTO;
	private RehabiliatadorDTO rehabilitadorDTO;
	private PsicologaDTO psicologaDTO;
	private NutricionistaDTO nutricionistaDTO;
	
	// Paciente
	private LoginForm lf;
	private ControlPacientes cp;
	private boolean editable;
	private String usuario;
	
	// Procedimiento
	private Procedimiento proc;
	private ProcedimientoPk procpk;
	private ProcedimientoDao procdao;
	
	private boolean controlVentanaClick = false;
	
	RcRehabilitacionCardiaca rcRehabilitacionCardiaca = new RcRehabilitacionCardiaca();
	
	
	public ControlRehabilitacionCardiaca() {
		
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
		} catch (IUException e) {
			logError(this.bundle.getString("info_msg_error_carga_user"));
		}
	}
	
	public void iniciaRehabilitacionCardiaca(ActionEvent e) throws IUException, RcRehabilitadorDaoException, RcPsicologiaDaoException, RcNutricionDaoException {
		
		if ( lf == null ) {
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			this.setEditable(true);
			this.cp = (ControlPacientes) getBean("controlPacientes");
			
			if (cp == null) { 
				cp = new ControlPacientes();
			}		
		}
		
		this.proc = new Procedimiento();
		this.proc.setFecha( new Date() );
		this.proc.setTipoprocedimiento( 1094 );
		this.proc.setCodigo(this.cp.getPacienteSelect().getCodigo());
		this.proc.setIdsitclinica( null );
		
		procdao = new ProcedimientoDaoImpl();
		
		if ( !this.controlVentanaClick ) {
			this.rehabilitacionCardiacaDTO = new RehabilitacionCardiacaDTO();
			this.rehabilitacionCardiacaDTO.nutricionistaDTO = new NutricionistaDTO();
			this.rehabilitacionCardiacaDTO.psicologaDTO = new PsicologaDTO();
			this.rehabilitacionCardiacaDTO.rehabilitadorDTO = new RehabiliatadorDTO();
			this.rcRehabilitacionCardiaca.setIdRcProcedimiento(0);
		}
		
		obtenerProblemasArticulares( this.rcRehabilitacionCardiaca.getIdRcRehabilitador() );
		obtenerProblemasCognitivos( this.rcRehabilitacionCardiaca.getIdRcRehabilitador() );
		obtenerProblemasSensoriales( this.rcRehabilitacionCardiaca.getIdRcRehabilitador() );
		obtenerNivelEducativo( this.rcRehabilitacionCardiaca.getIdRcRehabilitador() );
		
		obtenerEstadoCivil( this.rcRehabilitacionCardiaca.getIdRcPsicologia() ); 
		obtenerCalidadSueno( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
		obtenerNivelEstudios( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
		obtenerSituacionLaboral( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
		obtenerSituacionEconomica( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
		obtenerApoyoSocial( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
		obtenerFamilia( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
		obtenerNivelSatisfaccion( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
		obtenerNivelIrritabilidad( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
		obtenerNivelVidaSexual( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
	}
	
	public void cargarRehabilitacionCardiaca() throws RcRehabilitadorDaoException, RcPsicologiaDaoException, RcNutricionDaoException {
		
		if ( this.cp.getPacienteSelect().getCodigo() != null ) {

			this.controlVentanaClick = true;
			
			this.rehabilitacionCardiacaDTO.idProcedimiento = this.rcRehabilitacionCardiaca.getIdRcProcedimiento();
			
			// Tab Rehabilitador
			ServicioRCRehabilitadorImpl servicioRCRehabilitadorImpl = new ServicioRCRehabilitadorImpl();
			RcRehabilitador rcRehabilitador = servicioRCRehabilitadorImpl.buscar( this.rcRehabilitacionCardiaca.getIdRcRehabilitador() );
			
			if( rcRehabilitador != null ) {
				this.rehabilitacionCardiacaDTO.setRehabilitadorDTO( ConvertidorRCRehabilitador.convertirRCRehabilitadorDTO(rcRehabilitador) );
			}
			
			// Tab Psicologia
			ServicioRCPsicologiaImpl servicioPsicologia = new ServicioRCPsicologiaImpl();
			RcPsicologia rcPsicologia = servicioPsicologia.buscar( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
			
			if( rcPsicologia != null ) {
				this.rehabilitacionCardiacaDTO.setPsicologaDTO( ConvertidorRCPsicologia.convertirRCPsicologiaDTO(rcPsicologia) );
			}
			
			// Tab Nutricionista
			ServicioRCNutricionImpl servicioRCNutricionImpl = new ServicioRCNutricionImpl();
			RcNutricion rcNutricion = servicioRCNutricionImpl.buscar( this.rcRehabilitacionCardiaca.getIdRcNutricion() );
			
			if( rcNutricion != null ) {
				this.rehabilitacionCardiacaDTO.setNutricionistaDTO( ConvertidorRCNutricionista.convertirRCNutricionistaDTO(rcNutricion) );
			}
		} 
		
	}
	
	public void eliminar( ActionEvent e ) throws RcRehabilitadorDaoException, RcPsicologiaDaoException, RcNutricionDaoException, RcRehabilitacionCardiacaDaoException, RcPsicoRelacionSuenoDaoException {
		
		ServicioRehabilitacionCardiacaImpl servicio = new ServicioRehabilitacionCardiacaImpl();
		RcRehabilitacionCardiaca rcRehabilitacionCardiaca = servicio.obtenerRC( this.rcRehabilitacionCardiaca.getIdRcProcedimiento() );
		
		if ( rcRehabilitacionCardiaca != null ) {
			
			RcRehabilitacionCardiaca dto = new RcRehabilitacionCardiaca();
			dto.setIdRcProcedimiento( this.rcRehabilitacionCardiaca.getIdRcProcedimiento() );
			
			RcRehabilitadorPk pkRehabilitador = new RcRehabilitadorPk();
			pkRehabilitador.setIdRcRehabilitador(  this.rcRehabilitacionCardiaca.getIdRcPsicologia()  );
			
			RcPsicologiaPk pkPsicologia = new RcPsicologiaPk();
			pkPsicologia.setIdRcPsicologia( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
			
			RcNutricionPk pkNutricion = new RcNutricionPk();
			pkNutricion.setIdRcNutricion( this.rcRehabilitacionCardiaca.getIdRcNutricion() );
			
			
			dto.setIdRcRehabilitador( pkRehabilitador.getIdRcRehabilitador() );
			dto.setIdRcPsicologia( pkPsicologia.getIdRcPsicologia() );
			dto.setIdRcNutricion(pkNutricion.getIdRcNutricion());
			
			RcRehabilitacionCardiacaPk rcRehabilitacionCardiacaPk = new RcRehabilitacionCardiacaPk();
			rcRehabilitacionCardiacaPk.setIdRcProcedimiento( this.rcRehabilitacionCardiaca.getIdRcProcedimiento() );
			
			servicio.eliminarRC(rcRehabilitacionCardiacaPk);
			
			ServicioRCRehabilitadorImpl servicioRCRehabilitadorImpl = new ServicioRCRehabilitadorImpl();
			servicioRCRehabilitadorImpl.eliminar( pkRehabilitador );
			ServicioRCNutricionImpl servicioRCNutricionImpl = new ServicioRCNutricionImpl();
			servicioRCNutricionImpl.eliminar( pkNutricion );
			ServicioRCPsicologiaImpl servicioRCPsicologiaImpl = new ServicioRCPsicologiaImpl();
			servicioRCPsicologiaImpl.eliminar( pkPsicologia );
			
			ServicioRCPsicoRelacionSuenoImpl servicioRCPsicoRelacionSuenoImpl = new ServicioRCPsicoRelacionSuenoImpl();
			RcPsicoRelacionSuenoPk rcPsicoRelacionSuenoPk = new RcPsicoRelacionSuenoPk();
			List<RcPsicoRelacionSueno> listaRS = servicioRCPsicoRelacionSuenoImpl.obtenerRelacionSueno( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
			
			if( listaRS != null ) {
				rcPsicoRelacionSuenoPk.setIdRcPsicologia( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
				for( RcPsicoRelacionSueno rcPsicoRelacionSueno : listaRS ) {
					rcPsicoRelacionSuenoPk.setIdCalidadSueno( rcPsicoRelacionSueno.getIdCalidadSueno() );
					servicioRCPsicoRelacionSuenoImpl.eliminarRelacionSueno( rcPsicoRelacionSuenoPk );
				}
			}
				
		}
	}
	
	public void cargaRehabilitacionCardiaca(ActionEvent e) throws IUException, RcRehabilitacionCardiacaDaoException {
		
		try {
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.pacienteSelect.getIdRehabilitacionCardiaca(),1094})[0];
			this.procpk = this.proc.createPk();
			// 1. Recuperar objeto test
			ServicioRehabilitacionCardiacaImpl servicio = new ServicioRehabilitacionCardiacaImpl();
			this.rcRehabilitacionCardiaca = servicio.obtenerRC(this.proc.getIdprocedimiento());
			//this.calcularVariacionTas(null);
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	
	
	public void cargaRehabilitacionCardiacaDesdeBarraTemporal(ActionEvent e) throws IUException, RcRehabilitadorDaoException, RcPsicologiaDaoException, RcNutricionDaoException, RcRehabilitacionCardiacaDaoException {
		try {
			this.proc = this.procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND TIPOPROCEDIMIENTO = ?",
					new Object[] {cp.getNumeroprocedimientobarratemporal(),cp.getTipoprocedimiento()})[0];
			this.procpk = this.proc.createPk();
			// 1. Recuperar objeto test
			ServicioRehabilitacionCardiacaImpl servicio = new ServicioRehabilitacionCardiacaImpl();
			this.rcRehabilitacionCardiaca = servicio.obtenerRC(this.proc.getIdprocedimiento());
			//this.calcularVariacionTas(null);
			this.setEditable(UtilDatos.procedimientoEditable(this.lf.getAcceso(), this.proc.getFecha()));
			
			cargarRehabilitacionCardiaca();
			iniciaRehabilitacionCardiaca(e);
			this.controlVentanaClick = false;
			
			logger.info("("+this.usuario+") Consulta de registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+", Id Paciente: "+this.proc.getCodigo());
		} catch (ProcedimientoDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_reg")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") No se puede recuperar el registro. Id Procedimiento:"+this.proc.getIdprocedimiento()+" Error: "+ e1.getMessage());
		}		
	}
	
	public void guardarRehabilitacionCardiaca( ActionEvent e ) {
		
		try {
			// REHABILITADOR
			RcRehabilitador rcRehabilitador = ConvertidorRCRehabilitador.convertirRCRehabilitador( this.rcRehabilitacionCardiaca.getIdRcRehabilitador(), this.rehabilitacionCardiacaDTO.rehabilitadorDTO );
			// PSICOLOGIA
			RcPsicologia rcPsicologia = ConvertidorRCPsicologia.convertirRCPsicologia( this.rcRehabilitacionCardiaca.getIdRcPsicologia(), this.rehabilitacionCardiacaDTO.psicologaDTO );
			// NUTRICIONISTA
			RcNutricion rcNutricion = ConvertidorRCNutricionista.convertirRcNutricion(  this.rcRehabilitacionCardiaca.getIdRcNutricion(), this.rehabilitacionCardiacaDTO.nutricionistaDTO  );
			
			ServicioRehabilitacionCardiacaImpl servicio = new ServicioRehabilitacionCardiacaImpl();
			RcRehabilitacionCardiaca  rcRehabilitacionCardiaca = servicio.obtenerRC( this.rcRehabilitacionCardiaca.getIdRcProcedimiento() );
		
			if ( rcRehabilitacionCardiaca == null ) { 
				
				RcRehabilitacionCardiaca rcRehabilitacionCardiacaDTO = new RcRehabilitacionCardiaca();
				rcRehabilitacionCardiacaDTO.setIdRcProcedimiento( this.rcRehabilitacionCardiaca.getIdRcProcedimiento() );
				
				ServicioRCRehabilitadorImpl servicioRCRehabilitadorImpl = new ServicioRCRehabilitadorImpl();
				RcRehabilitadorPk pkRehabilitador = servicioRCRehabilitadorImpl.guardar( rcRehabilitador );
				
				ServicioRCPsicologiaImpl servicioRCPsicologiaImpl = new ServicioRCPsicologiaImpl();
				RcPsicologiaPk pkPsicologia = servicioRCPsicologiaImpl.guardar( rcPsicologia );
				
				ServicioRCNutricionImpl servicioRCNutricionImpl = new ServicioRCNutricionImpl();
				RcNutricionPk pkNutricion = servicioRCNutricionImpl.guardar( rcNutricion );
				
				rcRehabilitacionCardiacaDTO.setIdRcRehabilitador( pkRehabilitador.getIdRcRehabilitador() );
				rcRehabilitacionCardiacaDTO.setIdRcPsicologia( pkPsicologia.getIdRcPsicologia() );
				rcRehabilitacionCardiacaDTO.setIdRcNutricion(pkNutricion.getIdRcNutricion());
				
				RcRehabilitacionCardiacaPk rcRehabilitacionCardiacaPk = servicio.guardarRC( rcRehabilitacionCardiacaDTO );
				this.rcRehabilitacionCardiaca.setIdRcProcedimiento( rcRehabilitacionCardiacaPk.getIdRcProcedimiento() );
				this.rcRehabilitacionCardiaca.setIdRcNutricion( pkNutricion.getIdRcNutricion() );
				this.rcRehabilitacionCardiaca.setIdRcPsicologia( pkPsicologia.getIdRcPsicologia() );
				this.rcRehabilitacionCardiaca.setIdRcRehabilitador( pkRehabilitador.getIdRcRehabilitador() );
				
				ServicioRCPsicoRelacionSuenoImpl servicioRCPsicoRelacionSuenoImpl = new ServicioRCPsicoRelacionSuenoImpl();
				for ( String calidadSueno : this.rehabilitacionCardiacaDTO.psicologaDTO.selectedCalidadSueno ) {
					RcPsicoRelacionSueno rcPsicoRelacionSueno = new RcPsicoRelacionSueno();
					rcPsicoRelacionSueno.setIdCalidadSueno( new Long( calidadSueno ) );
					rcPsicoRelacionSueno.setIdRcPsicologia( pkPsicologia.getIdRcPsicologia() );
					servicioRCPsicoRelacionSuenoImpl.guardarCalidadSueno( rcPsicoRelacionSueno );
				}
				
				ServicioProcedimientoImpl servicioProcedimientoImpl = new ServicioProcedimientoImpl();
				this.proc.setIdprocedimiento( rcRehabilitacionCardiacaPk.getIdRcProcedimiento() );
				servicioProcedimientoImpl.guardarProcedimiento( this.proc );
				
				pintaMensaje(1, this.bundle.getString("info_msg_ok_rehabilitacion_cardiaca"));
				logger.info("("+this.usuario+") El regustro se ha guardado correctamente");
			}
			else {
				RcRehabilitacionCardiaca rcRehabilitacionCardiacaDTO = new RcRehabilitacionCardiaca();
				rcRehabilitacionCardiacaDTO.setIdRcProcedimiento( this.rcRehabilitacionCardiaca.getIdRcProcedimiento() );
				
				ServicioRCRehabilitadorImpl servicioRCRehabilitadorImpl = new ServicioRCRehabilitadorImpl();
				RcRehabilitadorPk pkRehabilitador = new RcRehabilitadorPk();
				pkRehabilitador.setIdRcRehabilitador(  this.rcRehabilitacionCardiaca.getIdRcPsicologia()  );
				servicioRCRehabilitadorImpl.actualizar( pkRehabilitador, rcRehabilitador );
				
				ServicioRCPsicologiaImpl servicioRCPsicologiaImpl = new ServicioRCPsicologiaImpl();
				RcPsicologiaPk pkPsicologia = new RcPsicologiaPk();
				pkPsicologia.setIdRcPsicologia( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
				servicioRCPsicologiaImpl.actualizar( pkPsicologia, rcPsicologia );
				
				ServicioRCNutricionImpl servicioRCNutricionImpl = new ServicioRCNutricionImpl();
				RcNutricionPk pkNutricion = new RcNutricionPk();
				pkNutricion.setIdRcNutricion( this.rcRehabilitacionCardiaca.getIdRcNutricion() );
				servicioRCNutricionImpl.actualizar( pkNutricion, rcNutricion );
				
				rcRehabilitacionCardiacaDTO.setIdRcRehabilitador( pkRehabilitador.getIdRcRehabilitador() );
				rcRehabilitacionCardiacaDTO.setIdRcPsicologia( pkPsicologia.getIdRcPsicologia() );
				rcRehabilitacionCardiacaDTO.setIdRcNutricion(pkNutricion.getIdRcNutricion());
				
				RcRehabilitacionCardiacaPk rcRehabilitacionCardiacaPk = new RcRehabilitacionCardiacaPk();
				rcRehabilitacionCardiacaPk.setIdRcProcedimiento( this.rcRehabilitacionCardiaca.getIdRcProcedimiento() );
				
				servicio.updateRC( rcRehabilitacionCardiacaPk, rcRehabilitacionCardiacaDTO );
				
				ServicioRCPsicoRelacionSuenoImpl servicioRCPsicoRelacionSuenoImpl = new ServicioRCPsicoRelacionSuenoImpl();
				RcPsicoRelacionSuenoPk rcPsicoRelacionSuenoPk = new RcPsicoRelacionSuenoPk();
				List<RcPsicoRelacionSueno> listaRS = servicioRCPsicoRelacionSuenoImpl.obtenerRelacionSueno( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
				
				if( listaRS != null ) {
					rcPsicoRelacionSuenoPk.setIdRcPsicologia( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
					for( RcPsicoRelacionSueno rcPsicoRelacionSueno : listaRS ) {
						rcPsicoRelacionSuenoPk.setIdCalidadSueno( rcPsicoRelacionSueno.getIdCalidadSueno() );
						servicioRCPsicoRelacionSuenoImpl.eliminarRelacionSueno( rcPsicoRelacionSuenoPk );
					}
				}
				
				for( String rcPsicoRelacionSueno : this.rehabilitacionCardiacaDTO.psicologaDTO.selectedCalidadSueno ) {
					RcPsicoRelacionSueno dto = new RcPsicoRelacionSueno();
					dto.setIdCalidadSueno( new Long( rcPsicoRelacionSueno ) );
					dto.setIdRcPsicologia( this.rcRehabilitacionCardiaca.getIdRcPsicologia() );
					servicioRCPsicoRelacionSuenoImpl.guardarCalidadSueno( dto );
				}
				
				pintaMensaje(1, this.bundle.getString("info_msg_update_rehabilitacion_cardiaca"));
				logger.info("("+this.usuario+") El regustro se ha actualizado correctamente");
			}
		}  catch (RcRehabilitadorDaoException e1) {
			pintaMensaje(3, this.bundle.getString("info_msg_error_rehabilitacion_cardiaca_rehabilitador")+": " + e1.getMessage());
			logger.error("("+this.usuario+") Error obteniendo registros en barra temporal - Motivo:"+e1.getMessage());
		} catch (RcPsicologiaDaoException e2) {
			pintaMensaje(3, this.bundle.getString("info_msg_error_rehabilitacion_cardiaca_psicologia")+": " + e2.getMessage());
			logger.error("("+this.usuario+") Error obteniendo registros en barra temporal - Motivo:"+e2.getMessage());
		} catch (RcPsicoRelacionSuenoDaoException e3) {
			pintaMensaje(3, this.bundle.getString("info_msg_error_rehabilitacion_cardiaca_lista_suenos")+": " + e3.getMessage());
			logger.error("("+this.usuario+") Error obteniendo registros en barra temporal - Motivo:"+e3.getMessage());
		} catch (RcNutricionDaoException e4) {
			pintaMensaje(3, this.bundle.getString("info_msg_error_rehabilitacion_cardiaca_nutricionista")+": " + e4.getMessage());
			logger.error("("+this.usuario+") Error obteniendo registros en barra temporal - Motivo:"+e4.getMessage());
		}		
	}
	
	/**
	 * Metodo que informa la seccion del radioButton del estado civil de Psicologia
	 */
	private void obtenerProblemasArticulares( long idRehabilitador ) {
		ServicioRCRehaProbArticularesImpl servicioRCRehaProbArticularesImpl = new ServicioRCRehaProbArticularesImpl();
		List<RcRehaProbArticulares> listaRCRehaProbArticulares = servicioRCRehaProbArticularesImpl.obtenerListadoProbArticulares();
		RcRehaProbArticulares rcArticular = servicioRCRehaProbArticularesImpl.obtenerProbArticularSeleccionadoDelPaciente( idRehabilitador );
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedProbArticulares = rcArticular == null ? "" :  String.valueOf( rcArticular.getIdProblemaArticular() );
		else
			this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedProbArticulares = "";
		
		this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemProbArticulares = new ArrayList<SelectItem>();
		
		for ( RcRehaProbArticulares rcRehaProbArticulares : listaRCRehaProbArticulares) {
			try {
				SelectItem option = new SelectItem( String.valueOf( rcRehaProbArticulares.getIdProblemaArticular() ), this.bundle.getString( rcRehaProbArticulares.getNombreProblema() ) );
				this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemProbArticulares.add(option);
            
			}catch( Exception e ) {
    			System.out.println("Error al cargar el resourceBoundle de propiedades");
    		}
        }
	}
	
	/**
	 * Metodo que informa la seccion del radioButton del estado civil de Psicologia
	 */
	private void obtenerProblemasCognitivos( long idRehabilitador ) {
		ServicioRCRehaProbCognitivosImpl servicioRCRehaProbCognitivosImpl = new ServicioRCRehaProbCognitivosImpl();
		List<RcRehaProbCognitivos> listaRCRehaProbCognitivos = servicioRCRehaProbCognitivosImpl.obtenerListadoProbCognitivos();
		RcRehaProbCognitivos rcCognitivo = servicioRCRehaProbCognitivosImpl.obtenerProbCognitivoSeleccionadoDelPaciente(idRehabilitador);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedProbCognitivos = rcCognitivo == null ? "" :  String.valueOf( rcCognitivo.getIdProblemaCognitivo() );
		else
			this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedProbCognitivos = "";
		
		this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemProbCognitivos = new ArrayList<SelectItem>();
		
		for ( RcRehaProbCognitivos rcRehaProbCognitivos : listaRCRehaProbCognitivos) {
        	SelectItem option = new SelectItem( String.valueOf( rcRehaProbCognitivos.getIdProblemaCognitivo() ),  this.bundle.getString( rcRehaProbCognitivos.getNombreProblema() ) );
            this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemProbCognitivos.add(option);
        }
	}
	
	
	/**
	 * Metodo que informa la seccion del radioButton del estado civil de Psicologia
	 */
	private void obtenerProblemasSensoriales( long idRehabilitador ) {
		ServicioRCRehaProbSensorialesImpl servicioRCRehaProbSensorialesImpl = new ServicioRCRehaProbSensorialesImpl();
		List<RcRehaProbSensoriales> listaRCRehaProbSensoriales = servicioRCRehaProbSensorialesImpl.obtenerListadoProbSensoriales();
		RcRehaProbSensoriales rcSensoriales = servicioRCRehaProbSensorialesImpl.obtenerProbSensorialesSeleccionadoDelPaciente(idRehabilitador);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedProbSensoriales = rcSensoriales == null ? "" :  String.valueOf( rcSensoriales.getIdProblemaSensorial() );
		else
			this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedProbSensoriales = "";
			
		this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemProbSensoriales = new ArrayList<SelectItem>();
		
		for ( RcRehaProbSensoriales rcRehaProbSensoriales : listaRCRehaProbSensoriales) {
        	SelectItem option = new SelectItem( String.valueOf( rcRehaProbSensoriales.getIdProblemaSensorial() ), this.bundle.getString( rcRehaProbSensoriales.getNombreProblema() ) );
            this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemProbSensoriales.add(option);
        }
	}
	
	/**
	 * Metodo que informa la seccion del radioButton del estado civil de Psicologia
	 */
	private void obtenerNivelEducativo( long idRehabilitador ) {
		ServicioRCRehaNivelEducativoImpl servicioRCRehaNivelEducativoImpl = new ServicioRCRehaNivelEducativoImpl();
		List<RcRehaNivelEducativo> listaRCRehaNivelEducativo = servicioRCRehaNivelEducativoImpl.obtenerListadoNivelEducativo();
		RcRehaNivelEducativo rcNivelEducativo = servicioRCRehaNivelEducativoImpl.obtenerProbSensorialesSeleccionadoDelPaciente( idRehabilitador );
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedNivelEducativo = rcNivelEducativo == null ? "" :  String.valueOf( rcNivelEducativo.getIdNivelEducativo() );
		else 
			this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedNivelEducativo = "";
			
		this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemNivelEducativo = new ArrayList<SelectItem>();
		
		for ( RcRehaNivelEducativo rcRehaNivelEducativo : listaRCRehaNivelEducativo) {
        	SelectItem option = new SelectItem( String.valueOf( rcRehaNivelEducativo.getIdNivelEducativo() ),  this.bundle.getString( rcRehaNivelEducativo.getNombreNivel() ) );
            this.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemNivelEducativo.add(option);
        }
	}
	
	
	/**
	 * Metodo que informa la seccion del radioButton del estado civil de Psicologia
	 */
	private void obtenerEstadoCivil( long idPsicologia ) {
		ServicioRCPsicoEstadoCivilImpl servicioEstadoCivilImpl = new ServicioRCPsicoEstadoCivilImpl();
		List<RcPsicoEstadoCivil> listaEstadoCivil = servicioEstadoCivilImpl.obtenerListadoEstadoCivil();
		RcPsicoEstadoCivil rcPsicoEstadoCivil = servicioEstadoCivilImpl.obtenerEstadoCivilSeleccionadoDelPaciente(idPsicologia);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedEstadoCivil = rcPsicoEstadoCivil == null ? "" :  String.valueOf( rcPsicoEstadoCivil.getIdEstadoCivil() );
		else
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedEstadoCivil = "";
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemEstadoCivil = new ArrayList<SelectItem>();
		
		for ( RcPsicoEstadoCivil estadoCivil : listaEstadoCivil) {
        	SelectItem option = new SelectItem( String.valueOf( estadoCivil.getIdEstadoCivil() ), this.bundle.getString( estadoCivil.getEstado() ) );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemEstadoCivil.add(option);
        }
	}
	
	/**
	 * Metodo que informa la seccion del radioButton del nivel de estudios de Psicologia
	 */
	private void obtenerNivelEstudios( long idPsicologia ) {
		ServicioRCPsicoNivelEstudiosImpl servicioNivelEstudiosImpl = new ServicioRCPsicoNivelEstudiosImpl();
		List<RcPsicoNivelEstudios> listaNivelEstudios = servicioNivelEstudiosImpl.obtenerListadoNivelEstudios();
		RcPsicoNivelEstudios rcPsicoNivelEstudios = servicioNivelEstudiosImpl.obtenerEstadoCivilSeleccionadoDelPaciente(idPsicologia);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedNivelEstudios = rcPsicoNivelEstudios == null ? "" :  String.valueOf( rcPsicoNivelEstudios.getIdNivelEstudios() );
		else
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedNivelEstudios = "";
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemNivelEstudios = new ArrayList<SelectItem>();
		
		for ( RcPsicoNivelEstudios nivelEstudios : listaNivelEstudios) {
        	SelectItem option = new SelectItem( String.valueOf( nivelEstudios.getIdNivelEstudios() ), this.bundle.getString( nivelEstudios.getEstudio() )  );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemNivelEstudios.add(option);
        }
	}
	
	/**
	 * Metodo que informa la seccion del radioButton de la situacion laboral de Psicologia
	 */
	private void obtenerSituacionLaboral( long idPsicologia ) {
		ServicioRCPsicoSituacionLaboralImpl servicioSituacionLaboralImpl = new ServicioRCPsicoSituacionLaboralImpl();
		List<RcPsicoSituacionLaboral> listaSituacionLaboral = servicioSituacionLaboralImpl.obtenerListadoSituacionLaboral();
		RcPsicoSituacionLaboral rcPsicoSituacionLaboral = servicioSituacionLaboralImpl.obtenerSituacionLaboralSeleccionadoDelPaciente(idPsicologia);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedSituacionLaboral = rcPsicoSituacionLaboral == null ? "" :  String.valueOf( rcPsicoSituacionLaboral.getIdSituacionLaboral() );
		else
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedSituacionLaboral = "";
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemSituacionLaboral = new ArrayList<SelectItem>();
		
		for ( RcPsicoSituacionLaboral psicoSituacionLaboral : listaSituacionLaboral) {
        	SelectItem option = new SelectItem( String.valueOf( psicoSituacionLaboral.getIdSituacionLaboral() ), this.bundle.getString( psicoSituacionLaboral.getSituacion() ) );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemSituacionLaboral.add(option);
        }
	}
	
	/**
	 * Metodo que informa la seccion del radioButton de la situacion economica de Psicologia
	 */
	private void obtenerSituacionEconomica( long idPsicologia ) {
		ServicioRCPsicoSituacionEconomicaImpl servicioSituacionEconomicaImpl = new ServicioRCPsicoSituacionEconomicaImpl();
		List<RcPsicoSituacionEconomica> listaSituacionEconomica = servicioSituacionEconomicaImpl.obtenerListadoSituacionEconomica();
		RcPsicoSituacionEconomica rcPsicoSituacionEconomica = servicioSituacionEconomicaImpl.obtenerSituacionEconomicaSeleccionadoDelPaciente(idPsicologia);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedSituacionEconomica = rcPsicoSituacionEconomica == null ? "" :  String.valueOf( rcPsicoSituacionEconomica.getIdSituacionEconomica() );
		else
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedSituacionEconomica = "";
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemSituacionEconomica = new ArrayList<SelectItem>();
		
		for ( RcPsicoSituacionEconomica situacionEconomica : listaSituacionEconomica) {
        	SelectItem option = new SelectItem( String.valueOf( situacionEconomica.getIdSituacionEconomica() ), this.bundle.getString(  situacionEconomica.getSituacion() ) );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemSituacionEconomica.add(option);
        }
	}
	
	/**
	 * Metodo que informa la seccion del radioButton del apoyo social de Psicologia
	 */
	private void obtenerApoyoSocial( long idPsicologia ) {
		ServicioRCPsicoApoyoSocialImpl servicioApoyoSocialaImpl = new ServicioRCPsicoApoyoSocialImpl();
		List<RcPsicoApoyoSocial> listaApoyoSociala = servicioApoyoSocialaImpl.obtenerListadoApoyoSocial();
		RcPsicoApoyoSocial rcPsicoApoyoSocial = servicioApoyoSocialaImpl.obtenerApoyoSocialSeleccionadoDelPaciente(idPsicologia);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedApoyoSocial = rcPsicoApoyoSocial == null ? "" :  String.valueOf( rcPsicoApoyoSocial.getIdApoyoSocial() );
		else
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedApoyoSocial = "";
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemApoyoSocial = new ArrayList<SelectItem>();
		
		for ( RcPsicoApoyoSocial apoyoSocial : listaApoyoSociala) {
        	SelectItem option = new SelectItem( String.valueOf( apoyoSocial.getIdApoyoSocial() ), this.bundle.getString( apoyoSocial.getTipo() ) );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemApoyoSocial.add(option);
        }
	}
	
	
	/**
	 * Metodo que informa la seccion del radioButton del apoyo social de Psicologia
	 */
	private void obtenerFamilia( long idPsicologia ) {
		ServicioRCPsicoFamiliaImpl servicioFamiliaaImpl = new ServicioRCPsicoFamiliaImpl();
		List<RcPsicoFamilia> listaFamilia = servicioFamiliaaImpl.obtenerListadoFamilia();
		RcPsicoFamilia rcPsicoFamilia = servicioFamiliaaImpl.obtenerFamiliaSeleccionadoDelPaciente(idPsicologia);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedFamilia = rcPsicoFamilia == null ? "" :  String.valueOf( rcPsicoFamilia.getIdFamilia() );
		else
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedFamilia = "";
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemFamilia = new ArrayList<SelectItem>();
		
		for ( RcPsicoFamilia familia : listaFamilia) {
        	SelectItem option = new SelectItem( String.valueOf( familia.getIdFamilia() ), this.bundle.getString( familia.getTipo() ) );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemFamilia.add(option);
        }
	}
	
	/**
	 *  Metodo que informa la seccion del checkBox de calidad del sueño de Psicologia
	 */
	private void obtenerCalidadSueno( long idPsicologia ) {
		ServicioRCPsicoCalidadSuenoImpl calidadSuenoImpl = new ServicioRCPsicoCalidadSuenoImpl();
		ServicioRCPsicoRelacionSuenoImpl servicioPsicoRelacionSueno = new ServicioRCPsicoRelacionSuenoImpl();
		List<RcPsicoCalidadSueno> listaCalidadSueno = calidadSuenoImpl.obtenerListadoCalidadSueno();
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectedCalidadSueno = new ArrayList<String>();
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemCalidadSueno = new ArrayList<SelectItem>();
		
		if ( this.controlVentanaClick ) {
			// Seteamos los valores que tienen relacion del sueño
		   	List<RcPsicoRelacionSueno> listaRelacionSueno = servicioPsicoRelacionSueno.obtenerRelacionSueno( idPsicologia );
		   	for( RcPsicoRelacionSueno relacionSueno : listaRelacionSueno ) {
			   this.rehabilitacionCardiacaDTO.psicologaDTO.selectedCalidadSueno.add( String.valueOf( relacionSueno.getIdCalidadSueno() ) );
		   	}
		}
        
        for ( RcPsicoCalidadSueno rcPsicoCalidadSueno : listaCalidadSueno) {
        	SelectItem option = new SelectItem( String.valueOf( rcPsicoCalidadSueno.getIdCalidadSueno() ), this.bundle.getString(  rcPsicoCalidadSueno.getTipo() ) );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemCalidadSueno.add(option);
        }
	}
	
	/**
	 *  Metodo que informa la seccion del checkBox de Nivel de Irritabilidad de Psicologia
	 */
	private void obtenerNivelIrritabilidad( long idPsicologia ) {
		
		ServicioRCPsicoNivelIrritabilidadImpl servicioNivelIrritabilidadImpl = new ServicioRCPsicoNivelIrritabilidadImpl();
		List<RcPsicoNivelIrritabilidad> listaNivelIrritabilidad = servicioNivelIrritabilidadImpl.obtenerListadoNivelIrritabilidad();
		RcPsicoNivelIrritabilidad rcPsicoNivelIrritabilidad = servicioNivelIrritabilidadImpl.obtenerNivelIrritabilidadSeleccionadoDelPaciente(idPsicologia);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedNivelIrritabilidad = rcPsicoNivelIrritabilidad == null ? "" :  String.valueOf( rcPsicoNivelIrritabilidad.getIdNivelIrritabilidad() );
		else
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedNivelIrritabilidad = "";
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemNivelIrritabilidad = new ArrayList<SelectItem>();
		
		for ( RcPsicoNivelIrritabilidad nivelIrritabilidad : listaNivelIrritabilidad) {
        	SelectItem option = new SelectItem( String.valueOf( nivelIrritabilidad.getIdNivelIrritabilidad() ), this.bundle.getString( nivelIrritabilidad.getTipo() ) );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemNivelIrritabilidad.add(option);
        }
		
	}
	
	/**
	 *  Metodo que informa la seccion del checkBox de Nivel de Irritabilidad de Psicologia
	 */
	private void obtenerNivelSatisfaccion( long idPsicologia ) {
		
		ServicioRCPsicoNivelSatisfaccionImpl servicioNivelSatisfaccionImpl = new ServicioRCPsicoNivelSatisfaccionImpl();
		List<RcPsicoNivelSatisfaccion> listaSatisfaccion = servicioNivelSatisfaccionImpl.obtenerListadoNivelSatisfaccion();
		RcPsicoNivelSatisfaccion rcPsicoNivelSatisfaccion = servicioNivelSatisfaccionImpl.obtenerNivelSatisfaccionSeleccionadoDelPaciente(idPsicologia);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedNivelSatisfaccion = rcPsicoNivelSatisfaccion == null ? "" :  String.valueOf( rcPsicoNivelSatisfaccion.getIdNivelSatisfaccion() );
		else
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedNivelSatisfaccion = "";
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemNivelSatisfaccion = new ArrayList<SelectItem>();
		
		for ( RcPsicoNivelSatisfaccion nivelSatisfaccion : listaSatisfaccion) {
        	SelectItem option = new SelectItem( String.valueOf( nivelSatisfaccion.getIdNivelSatisfaccion() ), this.bundle.getString( nivelSatisfaccion.getTipo() ) );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemNivelSatisfaccion.add(option);
        }
		
	}
	
	/**
	 *  Metodo que informa la seccion del checkBox de Vida Sexual de Psicologia
	 */
	private void obtenerNivelVidaSexual( long idPsicologia ) {
		
		ServicioRCPsicoVidaSexualImpl servicioNivelVidaSexualImpl = new ServicioRCPsicoVidaSexualImpl();
		List<RcPsicoVidaSexual> listaVidaSexual = servicioNivelVidaSexualImpl.obtenerListadoVidaSexual();
		RcPsicoVidaSexual rcPsicoVidaSexual = servicioNivelVidaSexualImpl.obtenerVidaSexualSeleccionadoDelPaciente(idPsicologia);
		
		if ( this.controlVentanaClick )
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedVidaSexual = rcPsicoVidaSexual == null ? "" :  String.valueOf( rcPsicoVidaSexual.getIdVidaSexual() );
		else
			this.rehabilitacionCardiacaDTO.psicologaDTO.selectedVidaSexual = "";
		
		this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemVidaSexual = new ArrayList<SelectItem>();
		
		for ( RcPsicoVidaSexual vidaSexual : listaVidaSexual) {
        	SelectItem option = new SelectItem( String.valueOf( vidaSexual.getIdVidaSexual() ), this.bundle.getString( vidaSexual.getTipo() ) );
            this.rehabilitacionCardiacaDTO.psicologaDTO.selectItemVidaSexual.add(option);
        }
	}
	
	
	// GETTERS AND SETTERS
	public RehabilitacionCardiacaDTO getRehabilitacionCardiacaDTO() {
		return rehabilitacionCardiacaDTO;
	}

	public void setRehabilitacionCardiacaDTO(RehabilitacionCardiacaDTO rehabilitacionCardiacaDTO) {
		this.rehabilitacionCardiacaDTO = rehabilitacionCardiacaDTO;
	}

	public SelectorIdioma getSi() {
		return si;
	}

	public void setSi(SelectorIdioma si) {
		this.si = si;
	}

	public ResourceBundle getBundle() {
		return bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	public RehabiliatadorDTO getRehabilitadorDTO() {
		return rehabilitadorDTO;
	}

	public void setRehabilitadorDTO(RehabiliatadorDTO rehabilitadorDTO) {
		this.rehabilitadorDTO = rehabilitadorDTO;
	}

	public PsicologaDTO getPsicologaDTO() {
		return psicologaDTO;
	}

	public void setPsicologaDTO(PsicologaDTO psicologaDTO) {
		this.psicologaDTO = psicologaDTO;
	}

	public NutricionistaDTO getNutricionistaDTO() {
		return nutricionistaDTO;
	}

	public void setNutricionistaDTO(NutricionistaDTO nutricionistaDTO) {
		this.nutricionistaDTO = nutricionistaDTO;
	}

	public LoginForm getLf() {
		return lf;
	}

	public void setLf(LoginForm lf) {
		this.lf = lf;
	}

	public ControlPacientes getCp() {
		return cp;
	}

	public void setCp(ControlPacientes cp) {
		this.cp = cp;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}

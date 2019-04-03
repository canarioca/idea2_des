package com.sorin.idea.integracion.canal.logica;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.log4j.Logger;

import com.sorin.idea.dao.ArrAblacionComplicaDao;
import com.sorin.idea.dao.ArrCardioversionDao;
import com.sorin.idea.dao.ArrConducPfDao;
import com.sorin.idea.dao.ArrConduccEcDao;
import com.sorin.idea.dao.ArrEnfDao;
import com.sorin.idea.dao.ArrEstudioAblacionDao;
import com.sorin.idea.dao.ArrEstudioCatAplDao;
import com.sorin.idea.dao.ArrEstudioCatUsoDao;
import com.sorin.idea.dao.ArrEstudioCateterDao;
import com.sorin.idea.dao.ArrEstudioComplicacionesDao;
import com.sorin.idea.dao.ArrEstudioConduccavDao;
import com.sorin.idea.dao.ArrEstudioDao;
import com.sorin.idea.dao.ArrEstudioEcgDao;
import com.sorin.idea.dao.ArrEstudioEnfDao;
import com.sorin.idea.dao.ArrEstudioIntentoDao;
import com.sorin.idea.dao.ArrEstudioNprocDao;
import com.sorin.idea.dao.ArrEstudioPeriodoDao;
import com.sorin.idea.dao.ArrEstudioPopDao;
import com.sorin.idea.dao.ArrEstudioResultadoDao;
import com.sorin.idea.dao.ArrEstudioSinusalDao;
import com.sorin.idea.dao.ArrEstudioSopDao;
import com.sorin.idea.dao.ArrEstudioTaquiDao;
import com.sorin.idea.dao.ArrEstudioViasDao;
import com.sorin.idea.dao.ArrListaEsperaDao;
import com.sorin.idea.dao.ArrMesasDao;
import com.sorin.idea.dao.ArrMesasEcgDao;
import com.sorin.idea.dao.ArrPacienteHcardioDao;
import com.sorin.idea.dao.ArrPacienteHclinDao;
import com.sorin.idea.dao.ArrPacientesDao;
import com.sorin.idea.dao.ArrRegistradorDao;
import com.sorin.idea.dao.ArrRegistradorEcgDao;
import com.sorin.idea.dao.ArrSinusalPfDao;
import com.sorin.idea.dao.ArrTestAtpDao;
import com.sorin.idea.dao.ArrTestAtpEcgDao;
import com.sorin.idea.dao.ArrTestFleDao;
import com.sorin.idea.dao.ArrTestFleEcgDao;
import com.sorin.idea.dao.ImpAtpDao;
import com.sorin.idea.dao.ImpChoquesDao;
import com.sorin.idea.dao.ImpEvolucionComplicacionDao;
import com.sorin.idea.dao.ImpEvolucionDao;
import com.sorin.idea.dao.ImpGeneradorDao;
import com.sorin.idea.dao.ImpHojaImplanteComplicacionDao;
import com.sorin.idea.dao.ImpHojaImplanteDao;
import com.sorin.idea.dao.ImpHojaImplanteEnfDao;
import com.sorin.idea.dao.ImpHojaImplantePopDao;
import com.sorin.idea.dao.ImpHojaImplanteSopDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.ImpImplanteElectrodosDao;
import com.sorin.idea.dao.ImpZonaDao;
import com.sorin.idea.dao.PlanMedGenDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.SegBloqueosDao;
import com.sorin.idea.dao.SegComplicacionesDao;
import com.sorin.idea.dao.SegObservacionesDaiDao;
import com.sorin.idea.dao.SegObservacionesMpDao;
import com.sorin.idea.dao.SegPorestimulacionDao;
import com.sorin.idea.dao.SegSeguimientoDao;
import com.sorin.idea.dao.SegSeguimientoRegEventosDao;
import com.sorin.idea.dao.SegSistemaDao;
import com.sorin.idea.dao.SintomasSitclinProcDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dto.*;
import com.sorin.idea.integracion.canal.AblacionEF;
import com.sorin.idea.integracion.canal.Bloqueo;
import com.sorin.idea.integracion.canal.CV;
import com.sorin.idea.integracion.canal.CateterEF;
import com.sorin.idea.integracion.canal.Choques;
import com.sorin.idea.integracion.canal.Complicaciones;
import com.sorin.idea.integracion.canal.ComplicacionesEF;
import com.sorin.idea.integracion.canal.ConduccionAVEF;
import com.sorin.idea.integracion.canal.ECGEF;
import com.sorin.idea.integracion.canal.Electrodo;
import com.sorin.idea.integracion.canal.EnfermeriaEF;
import com.sorin.idea.integracion.canal.EstimulacionContinuaEF;
import com.sorin.idea.integracion.canal.EstudioEF;
import com.sorin.idea.integracion.canal.Evolucion;
import com.sorin.idea.integracion.canal.FuncionSinusalEF;
import com.sorin.idea.integracion.canal.FuncionSinusalPfEF;
import com.sorin.idea.integracion.canal.Generador;
import com.sorin.idea.integracion.canal.HojaImplante;
import com.sorin.idea.integracion.canal.IntentoAblacionEF;
import com.sorin.idea.integracion.canal.ListaEspera;
import com.sorin.idea.integracion.canal.Mesa;
import com.sorin.idea.integracion.canal.ObservacionDAI;
import com.sorin.idea.integracion.canal.ObservacionMP;
import com.sorin.idea.integracion.canal.Paciente;
import com.sorin.idea.integracion.canal.PeriodoRefractarioEF;
import com.sorin.idea.integracion.canal.Personal;
import com.sorin.idea.integracion.canal.PlanMedicacion;
import com.sorin.idea.integracion.canal.PorEstimulacion;
import com.sorin.idea.integracion.canal.PruebasFarmaEF;
import com.sorin.idea.integracion.canal.Registrador;
import com.sorin.idea.integracion.canal.SeguimientoRegistrador;
import com.sorin.idea.integracion.canal.Sintoma;
import com.sorin.idea.integracion.canal.Sistema;
import com.sorin.idea.integracion.canal.SituacionClinica;
import com.sorin.idea.integracion.canal.TaquicardiaEF;
import com.sorin.idea.integracion.canal.TestATP;
import com.sorin.idea.integracion.canal.TestFLE;
import com.sorin.idea.integracion.canal.ViaAccesoriaEF;
import com.sorin.idea.integracion.canal.Zona;
import com.sorin.idea.jdbc.ArrAblacionComplicaDaoImpl;
import com.sorin.idea.jdbc.ArrCardioversionDaoImpl;
import com.sorin.idea.jdbc.ArrConducPfDaoImpl;
import com.sorin.idea.jdbc.ArrConduccEcDaoImpl;
import com.sorin.idea.jdbc.ArrEnfDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioAblacionDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioCatAplDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioCatUsoDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioCateterDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioComplicacionesDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioConduccavDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioEcgDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioEnfDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioIntentoDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioNprocDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioPeriodoDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioPopDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioResultadoDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioSinusalDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioSopDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioTaquiDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioViasDaoImpl;
import com.sorin.idea.jdbc.ArrListaEsperaDaoImpl;
import com.sorin.idea.jdbc.ArrMesasDaoImpl;
import com.sorin.idea.jdbc.ArrMesasEcgDaoImpl;
import com.sorin.idea.jdbc.ArrPacienteHcardioDaoImpl;
import com.sorin.idea.jdbc.ArrPacienteHclinDaoImpl;
import com.sorin.idea.jdbc.ArrPacientesDaoImpl;
import com.sorin.idea.jdbc.ArrRegistradorDaoImpl;
import com.sorin.idea.jdbc.ArrRegistradorEcgDaoImpl;
import com.sorin.idea.jdbc.ArrSinusalPfDaoImpl;
import com.sorin.idea.jdbc.ArrTestAtpDaoImpl;
import com.sorin.idea.jdbc.ArrTestAtpEcgDaoImpl;
import com.sorin.idea.jdbc.ArrTestFleDaoImpl;
import com.sorin.idea.jdbc.ArrTestFleEcgDaoImpl;
import com.sorin.idea.jdbc.ImpAtpDaoImpl;
import com.sorin.idea.jdbc.ImpChoquesDaoImpl;
import com.sorin.idea.jdbc.ImpEvolucionComplicacionDaoImpl;
import com.sorin.idea.jdbc.ImpEvolucionDaoImpl;
import com.sorin.idea.jdbc.ImpGeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteComplicacionDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteEnfDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplantePopDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteSopDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteElectrodosDaoImpl;
import com.sorin.idea.jdbc.ImpZonaDaoImpl;
import com.sorin.idea.jdbc.PlanMedGenDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.jdbc.SegBloqueosDaoImpl;
import com.sorin.idea.jdbc.SegComplicacionesDaoImpl;
import com.sorin.idea.jdbc.SegObservacionesDaiDaoImpl;
import com.sorin.idea.jdbc.SegObservacionesMpDaoImpl;
import com.sorin.idea.jdbc.SegPorestimulacionDaoImpl;
import com.sorin.idea.jdbc.SegSeguimientoDaoImpl;
import com.sorin.idea.jdbc.SegSeguimientoRegEventosDaoImpl;
import com.sorin.idea.jdbc.SegSistemaDaoImpl;
import com.sorin.idea.jdbc.SintomasSitclinProcDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.UtilFechas;


public class LogicaIntegracion {

	private static Logger logger = Logger.getLogger(LogicaIntegracion.class);
	protected java.sql.Connection conn;
	
	private ArrPacientesDao patdao;
	private SituacionClinicaGeneralDao sitclindao;
	private SituacionClinicaProcDao sitclinprocdao;
	private SintomasSitclinProcDao sintdao;
	private ProcedimientoDao procdao;
	private ImpImplanteDao impdao;
	private ImpHojaImplanteDao himpdao;
	private ImpGeneradorDao gendao;
	private ImpImplanteElectrodosDao elecdao;
	private ImpEvolucionDao hevdao;
	private ImpHojaImplantePopDao popdao;
	private ImpHojaImplanteSopDao sopdao;
	private ImpHojaImplanteEnfDao enfdao;
	private ImpZonaDao zonadao;
	private ImpAtpDao atpdao;
	private ImpChoquesDao choqdao;
	private ImpHojaImplanteComplicacionDao compintdao;
	private ImpEvolucionComplicacionDao comppostdao;
	
	private ArrEstudioDao estdao;
	private ArrEstudioEcgDao est_ecgdao;
	private ArrEstudioEnfDao est_enfdao;
	private ArrEstudioPopDao est_opdao;
	private ArrEstudioSopDao est_sopdao;
	private ArrEstudioNprocDao est_nprocdao;
	private ArrEstudioComplicacionesDao est_compdao;
	private ArrEstudioIntentoDao est_intdao;
	private ArrEstudioCateterDao est_catdao;
	private ArrEstudioPeriodoDao est_prdao;
	private ArrEstudioSinusalDao est_sindao;
	private ArrSinusalPfDao est_sinpfdao;
	private ArrEstudioViasDao est_viasdao;
	private ArrEstudioConduccavDao est_cavdao;
	private ArrConducPfDao est_cavpfdao;
	private ArrConduccEcDao est_cavecdao;
	private ArrEstudioTaquiDao est_taqdao;
	private ArrEstudioAblacionDao est_abldao;
	private ArrEstudioResultadoDao est_resdao;
	private ArrAblacionComplicaDao est_ablcompdao; 
	private ArrPacienteHcardioDao hcardiodao;
	private ArrPacienteHclinDao hclindao;
	private ArrEstudioCatUsoDao catusodao;
	private ArrEstudioCatAplDao catapldao;
	
	private ArrEnfDao renfdao;
	
	private ArrCardioversionDao cvdao;
	private ArrMesasDao mesadao;
	private ArrMesasEcgDao mesaecgdao;
	private ArrRegistradorDao regdao;
	private ArrRegistradorEcgDao regecgdao;
	
	private SegSeguimientoDao segdao;
	private SegSistemaDao sistdao;
	private SegBloqueosDao bloqdao;
	private SegPorestimulacionDao porestimdao;
	private SegObservacionesMpDao obsmpdao;
	private SegObservacionesDaiDao obsdaidao;
	private SegComplicacionesDao compdao;
	
	private ArrTestFleDao testfledao;
	private ArrTestFleEcgDao testfleecgdao;
	private ArrTestAtpDao testatpdao;
	private ArrTestAtpEcgDao testatpecgdao;
	
	private PlanMedGenDao pgdao;
	
	private SegSeguimientoRegEventosDao segregdao;
	private ArrListaEsperaDao ledao;
	
	public LogicaIntegracion(){
		try {
			this.conn = ResourceManager.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.patdao = new ArrPacientesDaoImpl(this.conn,"integracion");
		this.sitclindao = new SituacionClinicaGeneralDaoImpl(this.conn,"integracion");
		//this.procdao = new ProcedimientoDaoImpl(this.conn);
		this.procdao = new ProcedimientoDaoImpl(this.conn,"integracion");
		
		this.impdao = new ImpImplanteDaoImpl(this.conn,"integracion");
		this.sitclinprocdao = new SituacionClinicaProcDaoImpl(this.conn,"integracion");
		this.sintdao = new SintomasSitclinProcDaoImpl(this.conn,"integracion");
		this.himpdao = new ImpHojaImplanteDaoImpl(this.conn,"integracion");
		this.popdao = new ImpHojaImplantePopDaoImpl(this.conn,"integracion");
		this.sopdao = new ImpHojaImplanteSopDaoImpl(this.conn,"integracion");
		this.enfdao = new ImpHojaImplanteEnfDaoImpl(this.conn,"integracion");
		this.hevdao = new ImpEvolucionDaoImpl(this.conn,"integracion");
		this.zonadao = new ImpZonaDaoImpl(this.conn,"integracion");
		this.atpdao = new ImpAtpDaoImpl(this.conn,"integracion");
		this.choqdao = new ImpChoquesDaoImpl(this.conn,"integracion");
		this.gendao = new ImpGeneradorDaoImpl(this.conn,"integracion");
		this.elecdao = new ImpImplanteElectrodosDaoImpl(this.conn,"integracion");
		this.estdao = new ArrEstudioDaoImpl(this.conn,"integracion");
		this.est_ecgdao = new ArrEstudioEcgDaoImpl(this.conn,"integracion");
		this.est_enfdao = new ArrEstudioEnfDaoImpl(this.conn,"integracion");
		this.est_opdao = new ArrEstudioPopDaoImpl(this.conn,"integracion");
		this.est_sopdao = new ArrEstudioSopDaoImpl(this.conn,"integracion");
		this.est_nprocdao = new ArrEstudioNprocDaoImpl(this.conn,"integracion");
		this.est_compdao = new ArrEstudioComplicacionesDaoImpl(this.conn,"integracion");
		this.est_intdao = new ArrEstudioIntentoDaoImpl(this.conn,"integracion");
		this.est_catdao = new ArrEstudioCateterDaoImpl(this.conn,"integracion");
		this.est_prdao = new ArrEstudioPeriodoDaoImpl(this.conn,"integracion");
		this.est_sindao = new ArrEstudioSinusalDaoImpl(this.conn,"integracion");
		this.est_sinpfdao = new ArrSinusalPfDaoImpl(this.conn,"integracion");
		this.est_viasdao = new ArrEstudioViasDaoImpl(this.conn,"integracion");
		this.est_cavdao = new ArrEstudioConduccavDaoImpl(this.conn,"integracion");
		this.est_cavpfdao = new ArrConducPfDaoImpl(this.conn,"integracion");
		this.est_cavecdao = new ArrConduccEcDaoImpl(this.conn,"integracion");
		this.est_taqdao = new ArrEstudioTaquiDaoImpl(this.conn,"integracion");
		this.est_abldao = new ArrEstudioAblacionDaoImpl(this.conn,"integracion");
		this.est_resdao = new ArrEstudioResultadoDaoImpl(this.conn,"integracion");
		this.est_ablcompdao = new ArrAblacionComplicaDaoImpl(this.conn,"integracion");
		this.cvdao = new ArrCardioversionDaoImpl(this.conn,"integracion");
		this.mesadao = new ArrMesasDaoImpl(this.conn,"integracion");
		this.mesaecgdao = new ArrMesasEcgDaoImpl(this.conn,"integracion");
		this.regdao = new ArrRegistradorDaoImpl(this.conn,"integracion");
		this.regecgdao = new ArrRegistradorEcgDaoImpl(this.conn,"integracion");
		this.segdao = new SegSeguimientoDaoImpl(this.conn,"integracion");
		this.sistdao = new SegSistemaDaoImpl(this.conn,"integracion");
		this.bloqdao = new SegBloqueosDaoImpl(this.conn,"integracion");
		this.porestimdao = new SegPorestimulacionDaoImpl(this.conn,"integracion");
		this.obsmpdao = new SegObservacionesMpDaoImpl(this.conn,"integracion");
		this.obsdaidao = new SegObservacionesDaiDaoImpl(this.conn,"integracion");
		this.compdao = new SegComplicacionesDaoImpl(this.conn,"integracion");
		this.testfledao = new ArrTestFleDaoImpl(this.conn,"integracion");
		this.testfleecgdao = new ArrTestFleEcgDaoImpl(this.conn,"integracion");
		this.hcardiodao = new ArrPacienteHcardioDaoImpl(this.conn,"integracion");
		this.hclindao = new ArrPacienteHclinDaoImpl(this.conn,"integracion");
		this.testatpdao = new ArrTestAtpDaoImpl(this.conn,"integracion");
		this.testatpecgdao = new ArrTestAtpEcgDaoImpl(this.conn,"integracion");
		this.compintdao = new ImpHojaImplanteComplicacionDaoImpl(this.conn,"integracion");
		this.comppostdao = new ImpEvolucionComplicacionDaoImpl(this.conn,"integracion");
		this.catapldao = new ArrEstudioCatAplDaoImpl(this.conn,"integracion");
		this.catusodao = new ArrEstudioCatUsoDaoImpl(this.conn,"integracion");
		this.pgdao = new PlanMedGenDaoImpl(this.conn,"integracion");
		this.segregdao = new SegSeguimientoRegEventosDaoImpl(this.conn,"integracion");
		this.ledao = new ArrListaEsperaDaoImpl(this.conn,"integracion");
		this.renfdao = new ArrEnfDaoImpl(this.conn,"intergacion");
	}
	/**
	 * Metodo para insertar un nuevo paciente en el sistema y situacion clinica general asociada
	 * @param pat
	 * @return int > 0 si ok
	 * 		   int = 0 si existe paciente
	 * 		   int =-1 si ausencia de nhc
	 * 		   int =-2 si ausencia de nombre
	 * 		   int=-3 si ausencia de fechanac
	 * 		   int=-4 si error de conversion
	 * 		   int=-5 si error interno en insercion en bbdd
	 */
	public int insertarPaciente(Paciente pat, SituacionClinica st){
		
		try{
			/*
			 * 1. Control previo: NHC, Nombre, FechaNac presente
			 */
			if(pat.getNhc()==null || pat.getNhc().length()<=0)
				return -1;
			else if(pat.getNombre()==null || pat.getNombre().length()<=0)
				return -2;
			/*else if(pat.getFechanaci()==null || pat.getFechanaci().toString().length()<=0)
				return -3;*/
			else{
				ArrPacientes paciente = TipoConversor.convierte2PatIdea(pat);
				SituacionClinicaGeneral sitclin = TipoConversor.convierte2SitClinGenIdea(st);
				if(paciente!=null){
					try{
						//Control duplicado de NHC
						ArrPacientes[] nhcs = this.patdao.findWhereNhcEquals(pat.getNhc());
						if(nhcs.length>0){
							logger.error("Error de integración de nuevo paciente con NHC: "+pat.getNhc()+". Motivo: paciente ya existente en el sistema (NHC)");
							return 0;
						}else{
							this.conn.setAutoCommit(false);
							ArrPacientesPk patpk = this.patdao.insert(paciente);
							if(patpk!=null){
								logger.info("Paciente con NHC: "+pat.getNhc()+" insertado con éxito en el sistema.");
								// Insercion de Situacion Clinica General si procede
								sitclin.setIdpaciente(patpk.getCodigo());//Asignacion de idpaciente
								SituacionClinicaGeneralPk sitclinpk = this.sitclindao.insert(sitclin);
								// A ELEIMINAR CUANDO QUITEMOS HCARDIO Y HCLIN								
								this.hcardiodao.insert(new ArrPacienteHcardio(patpk.getCodigo()));
								this.hclindao.insert(new ArrPacienteHclin(patpk.getCodigo()));
								
								this.conn.commit();
								if(sitclinpk!=null)
									return patpk.getCodigo();
								else{//Error en insercion de situacion clinica - rollback
									logger.error("Error de integración de nuevo paciente con NHC: "+pat.getNhc()+". Motivo: error de inserción de Situacion Clinica General");
									this.patdao.delete(patpk);//rollback
									return -5;
								}					
							}else{
								logger.error("Error de integración de nuevo paciente con NHC: "+pat.getNhc()+". Motivo: error inserción en BBDD");
								return -5;
							}	
						}									
					}catch(Exception e){
						logger.error("Error de integración de nuevo paciente con NHC: "+pat.getNhc()+". Motivo: "+e.getMessage(),e);
						return -5;
					}finally {
					    if (this.conn != null) {
					        this.conn.close();
					    }
					}
				}else
					return -4;		
			}
		}catch(Exception e){
			e.fillInStackTrace();
			return -5;
		}

	}
	/**
	 * Metodo para insertar un EF en el sistema
	 * @param nhc
	 * @param fecha
	 * @param sitclin
	 * @param estudio
	 * @param ecg
	 * @param fsinusal
	 * @param taqs
	 * @param cav
	 * @param vias
	 * @param pers
	 * @param comp
	 * @param intento
	 * @param abls
	 * @return
	 */
	public int insertarEF(String nhc, Date fecha, SituacionClinica sitclin, EstudioEF estudio, ECGEF ecg,
			FuncionSinusalEF fsinusal, TaquicardiaEF[] taqs, ConduccionAVEF cav, ViaAccesoriaEF[] vias,
			PeriodoRefractarioEF[] pers, ComplicacionesEF comp, IntentoAblacionEF intento, AblacionEF[] abls, 
			CateterEF[] cats, EnfermeriaEF renf ){
		
		try{
			if(estudio.getNestudio().equals("036-2008"))
				System.out.println("Aqui");
			
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else{
				SituacionClinicaProc indicacion = TipoConversor.convierte2SitClinProcIdea(sitclin);
				if(sitclin.getSintomas()!=null &&sitclin.getSintomas().length>0){
					ArrayList<SintomasSitclinProc> sints = new ArrayList<SintomasSitclinProc>();
					for(Sintoma s:sitclin.getSintomas()){
						SintomasSitclinProc item_sint = new SintomasSitclinProc();
						item_sint.setIdsintomas(s.getSintoma());
						sints.add(item_sint);
					}
					indicacion.setSintomas(sints);
				}
				// Estudio
				ArrEstudio est = TipoConversor.convierte2EFIdea(estudio);
				ArrEstudioNproc est_nproc = null;
				if(estudio.getNproc()!=null){
					est_nproc = TipoConversor.convierte2EFNProcIdea(estudio.getNproc());
					est.setNproc(est_nproc);
				}
				//Pop
				if(estudio.getPrimeroperador()!=null && estudio.getPrimeroperador().length>0){
					ArrayList<ArrEstudioPop> pop = new ArrayList<ArrEstudioPop>();
					for(Personal p:estudio.getPrimeroperador()){
						ArrEstudioPop op = new ArrEstudioPop();
						op.setIdoperador(p.getNombre());
						pop.add(op);
					}
					est.setPoperador(pop);
				}
				//Sop
				if(estudio.getSegundooperador()!=null && estudio.getSegundooperador().length>0){
					ArrayList<ArrEstudioSop> sop = new ArrayList<ArrEstudioSop>();
					for(Personal p:estudio.getSegundooperador()){
						ArrEstudioSop op = new ArrEstudioSop();
						op.setIdoperador(p.getNombre());
						sop.add(op);
					}
					est.setSoperador(sop);
				}
				//Enf
				if(estudio.getEnfermeria()!=null && estudio.getEnfermeria().length>0){
					ArrayList<ArrEstudioEnf> enf = new ArrayList<ArrEstudioEnf>();
					for(Personal p:estudio.getEnfermeria()){
						ArrEstudioEnf op = new ArrEstudioEnf();
						op.setIdenfermera(p.getNombre());
						enf.add(op);
					}
					est.setEnfermeras(enf);
				}
				//ECG
				ArrEstudioEcg est_ecg = null;
				if(ecg!=null){
					est_ecg = TipoConversor.convierte2EFECGIdea(ecg);
					est.setEcgdto(est_ecg);
					est.setEcg(1);
				}		
				ArrEstudioSinusal est_sin=null;
				if(fsinusal!=null){
					est_sin = TipoConversor.convierte2EFFSinusal(fsinusal);
					//PF
					if(fsinusal.getPruebasfarmacologica()!=null && fsinusal.getPruebasfarmacologica().length>0){
						ArrayList<ArrSinusalPf> sin_pf = new ArrayList<ArrSinusalPf>();
						for(FuncionSinusalPfEF pf:fsinusal.getPruebasfarmacologica()){
							ArrSinusalPf item_pf = TipoConversor.convierte2EFFSinusalPf(pf);
							sin_pf.add(item_pf);
						}
						est_sin.setPruebas(sin_pf);
					}
					est.setSinusaldto(est_sin);
					est.setSinusal(1);
				}				
				if(taqs!=null && taqs.length>0){
					ArrayList<ArrEstudioTaqui> tqs = new ArrayList<ArrEstudioTaqui>(); 
					for(TaquicardiaEF t:taqs){
						ArrEstudioTaqui item_taqui = TipoConversor.convierte2EFTaq(t);
						tqs.add(item_taqui);
					}
					est.setTaquicardias(1);
					est.setLsttaquicardias(tqs);
				}
				ArrEstudioConduccav est_cav = new ArrEstudioConduccav();
				if(cav!=null){
					est_cav = TipoConversor.convierte2EFCavIdea(cav);
					if(cav.getPruebasfarma()!=null&&cav.getPruebasfarma().length>0){
						ArrayList<ArrConducPf> cav_pf = new ArrayList<ArrConducPf>();
						for(PruebasFarmaEF p:cav.getPruebasfarma()){
							ArrConducPf item_pf = TipoConversor.convierte2EFFSinusalPfIdea(p);
							cav_pf.add(item_pf);
						}
						est_cav.setPruebas(cav_pf);
					}
					if(cav.getEstimulacioncontinua()!=null&&cav.getEstimulacioncontinua().length>0){
						ArrayList<ArrConduccEc> cav_ec = new ArrayList<ArrConduccEc>();
						for(EstimulacionContinuaEF e:cav.getEstimulacioncontinua()){
							ArrConduccEc item_ec = TipoConversor.convierte2EFEstcontinuaIdea(e);
							cav_ec.add(item_ec);
						}
						est_cav.setEstim(cav_ec);
					}
					est.setConducciondto(est_cav);
					est.setConduccion(1);
				}
				if(vias!=null && vias.length>0){
					ArrayList<ArrEstudioVias> est_vias = new ArrayList<ArrEstudioVias>();
					for(ViaAccesoriaEF v:vias){
						ArrEstudioVias item_via = TipoConversor.convierte2EFViasIdea(v);
						est_vias.add(item_via);
					}
					est.setViasdto(est_vias);
					est.setVias(1);
				}
				if(pers!=null && pers.length>0){
					ArrayList<ArrEstudioPeriodo> est_per = new ArrayList<ArrEstudioPeriodo>();
					for(PeriodoRefractarioEF p:pers){
						ArrEstudioPeriodo per = TipoConversor.convierte2EFPeriodoIdea(p);
						est_per.add(per);
					}
					est.setPeriodosdto(est_per);
					est.setPeriodos(1);
				}
				ArrEstudioComplicaciones est_comp = null;
				if(comp!=null){
					est_comp = TipoConversor.convierte2EFComplicacionesIdea(comp);
					est.setComplicacionesdto(est_comp);
					est.setComplicaciones(1);
				}		
				ArrEstudioIntento est_intento = null;
				if(intento!=null){
					est_intento = TipoConversor.convierte2EFIntentoIdea(intento);
					est.setIntentodto(est_intento);
					est.setAblacion(1);
				}
				ArrayList<ArrEstudioAblacion> est_abl = new ArrayList<ArrEstudioAblacion>();
				ArrayList<ArrEstudioCatUso> cateteres_abl = new ArrayList<ArrEstudioCatUso>();
				ArrayList<ArrEstudioCatUso> cateteres = new ArrayList<ArrEstudioCatUso>();
				if(abls!=null && abls.length>0){
					for(AblacionEF a:abls){
						ArrEstudioAblacion ab = TipoConversor.convierte2EFAblacionIdea(a);
						//ArrAblacionComplica ab_comp = TipoConversor.convierte2EFAblCompliacionIdea(a.getComplicacion());
						//ArrEstudioResultado ab_res = TipoConversor.convierte2EFAblResultadoIdea(a.getResultado());
						ab.setComplicacion(a.getComplicacion()!=null?TipoConversor.convierte2EFAblCompliacionIdea(a.getComplicacion()):null);
						ab.setResultadodto(a.getResultado()!=null?TipoConversor.convierte2EFAblResultadoIdea(a.getResultado()):null);
						est_abl.add(ab);
						// Incluir cateteres de ablacion en cateteres en uso
						if(a.getCateterabl()!=null){
							for(CateterEF c:a.getCateterabl()){
								ArrEstudioCatUso cat_uso = TipoConversor.convierte2EFCatererEnUso(c);
								cateteres_abl.add(cat_uso);
								cateteres.add(cat_uso);
								// Crear lista de aplicaciones
								ArrEstudioCatApl apl = TipoConversor.convierte2EFCatererApl(c);
								apl.setIdcateteruso(cat_uso.getIdcateter());
								ab.getListapls().add(apl);
							}
						}
					}
					est.setAblaciones(est_abl);
					est.setAblacion(2);
				}	
				// Cateteres diagnosticos
				if(cats!=null){
					for(CateterEF c:cats){
						ArrEstudioCatUso cat_uso = TipoConversor.convierte2EFCatererEnUso(c);
						cateteres.add(cat_uso);
					}
				}
				est.setListacats(cateteres);
				// Enfermeria
				ArrEnf enf = null;
				if(renf!=null)
					enf = TipoConversor.convierte2Enfermeria(renf);				
				// INSERCION EN BBD
				try{
					this.conn.setAutoCommit(false);
					Procedimiento proc = new Procedimiento();
					proc.setFecha(fecha);
					proc.setTipoprocedimiento(1061);// id procedimeinto EF
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de EF para paciente: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					est.setFecha(fecha);// requisito de almacenamiento
					est.setIdpaciente(pat[0].getCodigo());
					// 0. Guarda indicacion
					SituacionClinicaProcPk sitclinpk = this.sitclinprocdao.insert(indicacion);
					indicacion.setIdsitclin(sitclinpk.getIdsitclin());
					// 0.1 Guarda sintomas
					guardaComponentesHind(indicacion);
					// 1. Guarda estudio
					ArrEstudioPk estpk = this.estdao.insert(est);
					est.setIdestudio(estpk.getIdestudio());
					// 2. Guarda componentes
					guardaComponentesEF(est,cateteres_abl,enf);
					// Guarda procedimiento
					proc.setIdprocedimiento(estpk.getIdestudio());
					proc.setIdsitclinica(indicacion.getIdsitclin());
					procdao.insert(proc);
					this.conn.commit();
					logger.info("Procedimiento EF("+est.getNestudio()+") integrado con éxito en el sistema. ");
					return 1;				
				}catch(Exception e){
					logger.error("Error en integración de EF("+est.getNestudio()+"). Motivo: "+e.fillInStackTrace(),e);
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}		
			}
		}catch(Exception e){
			logger.error("Error en integración de EF. Motivo: "+e.getMessage(),e);
			e.fillInStackTrace();
			return -5;
		}
	}
	private void guardaComponentesEF(ArrEstudio eef, ArrayList<ArrEstudioCatUso> cats_abl, ArrEnf enf) throws Exception{		
		// Enfermeria
		est_enfdao.delete(new ArrEstudioEnfPk(eef.getIdestudio()));
		for (ArrEstudioEnf enfermera : eef.getEnfermeras()) {
			if(enfermera.getIdenfermera() != null && enfermera.getIdenfermera().length() > 0){
				enfermera.setIdestudio(eef.getIdestudio());
				est_enfdao.insert(enfermera);
			}			
		}
		// Primer operador
		est_opdao.delete(new ArrEstudioPopPk(eef.getIdestudio()));
		for (ArrEstudioPop operador : eef.getPoperador()) {
			if(operador.getIdoperador() != null && operador.getIdoperador().length() > 0){
				operador.setIdestudio(eef.getIdestudio());
				est_opdao.insert(operador);
			}
		}
		// Segundo operador
		est_sopdao.delete(new ArrEstudioSopPk(eef.getIdestudio()));
		for (ArrEstudioSop operador : eef.getSoperador()) {
			if(operador.getIdoperador() != null && operador.getIdoperador().length() > 0){
				operador.setIdestudio(eef.getIdestudio());
				est_sopdao.insert(operador);
			}
		}
		// N proc
		if (eef.getNproc()!=null&&eef.getNproc().getIdestudio() == null) {
			eef.getNproc().setIdestudio(eef.getIdestudio());
			eef.getNproc().setIdproc(eef.getIdestudio());
			est_nprocdao.insert(eef.getNproc());
		} 
		// ECG
		if (eef.getEcgdto()!=null&&eef.getEcgdto().getIdestudio() == null) {
			eef.getEcgdto().setIdestudio(eef.getIdestudio());
			est_ecgdao.insert(eef.getEcgdto());
		}
		// Complicaciones
		if (eef.getComplicacionesdto()!=null&&eef.getComplicacionesdto().getIdestudio() == null) {
			eef.getComplicacionesdto().setIdestudio(eef.getIdestudio());
			est_compdao.insert(eef.getComplicacionesdto());
		}
		// Intento ablacion
		if (eef.getIntentodto()!=null&&eef.getIntentodto().getIdestudio() == null) {
			eef.getIntentodto().setIdestudio(eef.getIdestudio());
			est_intdao.insert(eef.getIntentodto());
		}
		// Periodos
		if(eef.getPeriodosdto()!=null){
			est_prdao.delete(new ArrEstudioPeriodoPk(eef.getIdestudio()));
			for (ArrEstudioPeriodo pr : eef.getPeriodosdto()) {
				pr.setIdestudio(eef.getIdestudio());
				est_prdao.insert(pr);
			}
		}		
		// Funcion Sinusal
		if (eef.getSinusaldto()!=null&&eef.getSinusaldto().getIdestudio() == null) {
			eef.getSinusaldto().setIdestudio(eef.getIdestudio());
			est_sindao.insert(eef.getSinusaldto());
			est_sinpfdao.delete(new ArrSinusalPfPk(eef.getIdestudio()));
			for (ArrSinusalPf prueba : eef.getSinusaldto().getPruebas()) {
				prueba.setIdfuncion(eef.getIdestudio());
				est_sinpfdao.insert(prueba);
			}
		}
		// Vias accesorias
		if(eef.getViasdto()!=null){
			est_viasdao.delete(new ArrEstudioViasPk(eef.getIdestudio()));
			for (ArrEstudioVias via : eef.getViasdto()) {
				via.setIdestudio(eef.getIdestudio());
				est_viasdao.insert(via);
			}
		}	
		// Conduccion AV
		if (eef.getConducciondto()!=null&&eef.getConducciondto().getIdestudio() == null) {
			eef.getConducciondto().setIdestudio(eef.getIdestudio());
			est_cavdao.insert(eef.getConducciondto());
			est_cavpfdao.delete(new ArrConducPfPk(eef.getIdestudio()));
			est_cavecdao.delete(new ArrConduccEcPk(eef.getIdestudio()));
			for (ArrConducPf prueba : eef.getConducciondto().getPruebas()) {
				prueba.setIdconduccav(eef.getIdestudio());
				est_cavpfdao.insert(prueba);
			}
			for (ArrConduccEc estim : eef.getConducciondto().getEstim()) {
				estim.setIdconduccav(eef.getIdestudio());
				est_cavecdao.insert(estim);
			}
		}
		// Taquicardias
		if(eef.getLsttaquicardias().size()>0){
			for(ArrEstudioTaqui tq:eef.getLsttaquicardias()){
				tq.setIdestudio(eef.getIdestudio());
				ArrEstudioTaquiPk taqpk = new ArrEstudioTaquiPk();
				taqpk = est_taqdao.insert(tq);
				//eef.getTaquicardidto().setIdtaqui(taqpk.getIdtaqui());
				//eef.getLsttaquicardias().add(eef.getTaquicardidto());			
			}
		}
		// Cateteres en uso
		// a. Diagnostico + Ablacion
		for (ArrEstudioCatUso cateter : eef.getListacats()) {
			cateter.setIdeef(eef.getIdestudio());
			ArrEstudioCatUsoPk cpk = catusodao.insert(cateter);
			if(cateter.getIdcatuso()==null)
				cateter.setIdcatuso(cpk.getIdcatuso());
		}
		// Ablacion
		if(eef.getAblaciones().size()>0){
			for(ArrEstudioAblacion ab:eef.getAblaciones()){
				ab.setIdestudio(eef.getIdestudio());
				ArrEstudioAblacionPk ablpk = new ArrEstudioAblacionPk();
				ablpk = est_abldao.insert(ab);
				ab.setIdablacion(ablpk.getIdablacion());
				ab.getResultadodto().setIdestudio(eef.getIdestudio());
				ab.getResultadodto().setIdablacion(ablpk.getIdablacion());
				est_resdao.insert(ab.getResultadodto());
				ab.getComplicacion().setIdablacion(ablpk.getIdablacion());
				ab.getComplicacion().setIdestudio(ablpk.getIdestudio());
				est_ablcompdao.insert(ab.getComplicacion());
				/*ArrAblacionComplica comp = new ArrAblacionComplica();
				comp.setIdestudio(ablpk.getIdestudio());
				comp.setIdablacion(ablpk.getIdablacion());
				est_ablcompdao.insert(comp);*/
				//est_ablcompdao.insert(ab.getComplicacion());
				//eef.getAblaciones().add(eef.getAblaciondto());
				// Aplicaciones - cateter
				// a) asigna el idcatuso de la lista de cateteres 
				completaAplicaciones(cats_abl,ab.getListapls());
				for(ArrEstudioCatApl ap:ab.getListapls()){
					ap.setIdablacion(ab.getIdablacion());
					catapldao.insert(ap);
				}	
			}
		}	
		// Enfermeria
		if(enf!=null){
			enf.setFecha(eef.getFecha());
			enf.setIdeef(eef.getIdestudio());
			enf.setIdPaciente(eef.getIdpaciente());
			renfdao.insert(enf);
		}
	}
	
	public void completaAplicaciones(ArrayList<ArrEstudioCatUso> cats, ArrayList<ArrEstudioCatApl> apls){
		for(ArrEstudioCatUso c:cats){
			for(ArrEstudioCatApl ap:apls)
				if(c.getIdcateter()==ap.getIdcateteruso()){
					ap.setIdcateteruso(c.getIdcatuso());
					ap.setIdcatuso(c.getIdcatuso());
					break;
				}	
		}
	}
	
	public int insertarCV(String nhc,Date fecha,CV c) {
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else{
				ArrCardioversion cv = TipoConversor.convierte2CVIdea(c);
				// INSERCION EN BBDD
				try{
					this.conn.setAutoCommit(false);					
					
					Procedimiento proc = new Procedimiento();
					proc.setFecha(fecha);
					proc.setTipoprocedimiento(1068);// id procedimeinto CV
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de EF para paciente: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					cv.setCodigoPaciente(pat[0].getCodigo());
					cv.setFecha(fecha);
					ArrCardioversionPk cvpk = this.cvdao.insert(cv);
					
					// Guarda procedimiento
					proc.setIdprocedimiento(cvpk.getCodigoCardioversion());
					//proc.setIdsitclinica(indicacion.getIdsitclin());
					procdao.insert(proc);
					this.conn.commit();
					logger.info("Procedimiento CV integrado con éxito en le sistema. ");
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de CV. Motivo: "+e.fillInStackTrace());
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception e){
			e.fillInStackTrace();
			return -5;
		}	
	}
	/**
	 * Metodo para insertar un nuevo registro de implante en el sistema
	 * @param nhc
	 * @param indicacion
	 * @param gen
	 * @param els
	 * @param hojaimp
	 * @param evolucion
	 * @return
	 *  
	 */
	public int insertarImplante(String nhc,int tipo,Date fecha,SituacionClinica sitclin,Generador gen,Electrodo[] els,HojaImplante hojaimp,Evolucion evolucion,String nproc) {
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else if(!validaTipoProcedimiento(tipo))
				return -4;
			else if(tipo!=956)
				return insertarImplanteOtros(nhc,tipo,fecha,sitclin,gen,els,hojaimp,evolucion,nproc);
			else{
				// CONVERSION DE TIPOS DE DATOS
				SituacionClinicaProc indicacion = TipoConversor.convierte2SitClinProcIdea(sitclin);
				if(sitclin.getSintomas()!=null &&sitclin.getSintomas().length>0){
					ArrayList<SintomasSitclinProc> sints = new ArrayList<SintomasSitclinProc>();
					for(Sintoma s:sitclin.getSintomas()){
						SintomasSitclinProc item_sint = new SintomasSitclinProc();
						item_sint.setIdsintomas(s.getSintoma());
						sints.add(item_sint);
					}
					indicacion.setSintomas(sints);
				}
				ImpGenerador impgen = TipoConversor.convierte2GeneradorIdea(gen);
				//logger.info("Modelo Generador: "+gen.getModelo());
				ArrayList<ImpImplanteElectrodos> impelec = new ArrayList<ImpImplanteElectrodos>();
				if(els!=null)
					for(Electrodo e:els)
						impelec.add(TipoConversor.convierte2ElectrodoIdea(e));
				ImpHojaImplante himp = TipoConversor.convierte2HojaImplanteIdea(hojaimp);
				if(hojaimp.getPrimeroperador()!=null && hojaimp.getPrimeroperador().length>0){
					ArrayList<ImpHojaImplantePop> pop = new ArrayList<ImpHojaImplantePop>();
					for(Personal p:hojaimp.getPrimeroperador()){
						ImpHojaImplantePop item_pop = new ImpHojaImplantePop();
						item_pop.setIdop(p.getNombre());
						pop.add(item_pop);
					}
					himp.setPoperador(pop);
				}
				if(hojaimp.getSegundooperador()!=null&&hojaimp.getSegundooperador().length>0){
					ArrayList<ImpHojaImplanteSop> sop = new ArrayList<ImpHojaImplanteSop>();
					for(Personal p:hojaimp.getSegundooperador()){
						ImpHojaImplanteSop item_sop = new ImpHojaImplanteSop();
						item_sop.setIdop(p.getNombre());
						sop.add(item_sop);
					}	
					himp.setSoperador(sop);
				}
				if(hojaimp.getEnfermeria()!=null&&hojaimp.getEnfermeria().length>0){
					ArrayList<ImpHojaImplanteEnf> enf = new ArrayList<ImpHojaImplanteEnf>();
					for(Personal p:hojaimp.getEnfermeria()){
						ImpHojaImplanteEnf item_enf = new ImpHojaImplanteEnf();
						item_enf.setIdenf(p.getNombre());
						enf.add(item_enf);
					}	
					himp.setEnfermeras(enf);
				}
				ArrayList<ImpHojaImplanteComplicacion> comps_intra = new ArrayList<ImpHojaImplanteComplicacion>();
				if(hojaimp.getComplicaciones()!=null&&hojaimp.getComplicaciones().length>0){
					for(Complicaciones c: hojaimp.getComplicaciones()){
						ImpHojaImplanteComplicacion item_comp = TipoConversor.convierte2ComplicacionHojaImpIdea(c);
						comps_intra.add(item_comp);
					}
				}
				ImpEvolucion hev = TipoConversor.convierte2EvolucionIdea(evolucion);
				if(evolucion.getZonas()!=null&&evolucion.getZonas().length>0){
					ArrayList<ImpZona> zonas = new ArrayList<ImpZona>();
					for(int i=0;i<evolucion.getZonas().length;i++){
						ImpZona zn = TipoConversor.convierte2ZonaIdea(evolucion.getZonas()[i]);
						zonas.add(zn);
						ArrayList<ImpAtp> atps = new ArrayList<ImpAtp>();
						ArrayList<ImpChoques> choques = new ArrayList<ImpChoques>();					
						if(evolucion.getZonas()[i].getAtp1()!=null){
							ImpAtp atp1 = TipoConversor.convierte2AtpIdea(evolucion.getZonas()[i].getAtp1());
							atps.add(atp1);
						}
						if(evolucion.getZonas()[i].getAtp2()!=null){
							ImpAtp atp2 = TipoConversor.convierte2AtpIdea(evolucion.getZonas()[i].getAtp2());
							atps.add(atp2);
						}
						if(evolucion.getZonas()[i].getChoques()!=null){
							for(Choques ch:evolucion.getZonas()[i].getChoques()){
								ImpChoques c = TipoConversor.convierte2ChoqueIdea(ch);
								choques.add(c);
							}
						}
						//zn.setAtps(atps);
						//zn.setChqs(choques);				
						zonas.get(i).setAtps(atps);
						zonas.get(i).setChqs(choques);					
					}				
					hev.setZonas(zonas);
				}
				ArrayList<ImpEvolucionComplicacion> comps_post = new ArrayList<ImpEvolucionComplicacion>();				
				if(evolucion.getComplicaciones()!=null&&evolucion.getComplicaciones().length>0){
					for(Complicaciones c: evolucion.getComplicaciones()){
						ImpEvolucionComplicacion item_comp = TipoConversor.convierte2ComplicacionEvolucionIdea(c);
						comps_post.add(item_comp);
					}
				}
				// INICIO DE ALMACENAMIENTO
				try{
					this.conn.setAutoCommit(false);					
					Procedimiento proc = new Procedimiento();
					ImpImplante imp = new ImpImplante();
					imp.setFechaimplante(fecha);
					imp.setNproc(nproc);
					proc.setFecha(fecha);
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					// Guarda indicacion
					SituacionClinicaProcPk sitclinpk = this.sitclinprocdao.insert(indicacion);
					indicacion.setIdsitclin(sitclinpk.getIdsitclin());
					// Guarda sintomas
					guardaComponentesHind(indicacion);
					// Guarda HojaImplante
					ImpHojaImplantePk himppk = this.himpdao.insert(himp);
					himp.setIdhojaimp(himppk.getIdhojaimp());
					imp.setIdhojaimp(himppk.getIdhojaimp());
					guardaComponentesHimp(himp);
					// Guarda complicaciones intra					
					if(comps_intra.size()>0)
						for (ImpHojaImplanteComplicacion comp : comps_intra) {
							if (comp.getIdcompl() == null || comp.getIdcompl()==0)
								comp.setIdcompl(25);// Otras complicaciones
							comp.setIdhojaimp(himp.getIdhojaimp());
							this.compintdao.insert(comp);
						}					
					// Guarda generador
					impgen.setIdhojaimp(himppk.getIdhojaimp());// clave foranea con imphojaimplante
					ImpGeneradorPk genpk = this.gendao.insert(impgen);
					impgen.setIdimpgenerador(genpk.getIdimpgenerador());
					// Guarda Evolucion
					ImpEvolucionPk hevpk = this.hevdao.insert(hev);
					hev.setIdev(hevpk.getIdev());
					imp.setIdev(hevpk.getIdev());
					guardaComponentesHev(hev);
					// Guarda electrodos
					for(ImpImplanteElectrodos e:impelec){
						e.setIdhojaimp(himppk.getIdhojaimp());
						e.setIdevolucion(hevpk.getIdev());
						ImpImplanteElectrodosPk impelecpk = this.elecdao.insert(e);
						e.setIdimpelectrodos(impelecpk.getIdimpelectrodos());
					}	
					// Guarda complicaciones post					
					if(comps_post.size()>0)
						for (ImpEvolucionComplicacion comp : comps_post) {
							if (comp.getIdcompl() == null || comp.getIdcompl()==0)
								comp.setIdcompl(25);// Otras complicaciones
							comp.setIdev(hev.getIdev());
							this.comppostdao.insert(comp);
						}
					
					// Guarda implante
					ImpImplantePk imppk = this.impdao.insert(imp);
					imp.setIdimplante(imppk.getIdimplante());
					// Guarda procedimiento
					// Hay que ver el tipo de procedimiento en IDEA
					Procedimiento[] aux = this.procdao.findByDynamicWhere("CODIGO =? AND (TIPOPROCEDIMIENTO = ?)", new Object[] {
									proc.getCodigo(), 956 });
					if(aux!=null && aux.length>0 && tipo==956)
						proc.setTipoprocedimiento(1059);// Ya existe un primoimplante -> Recambio
					else
						proc.setTipoprocedimiento(tipo);
					
					proc.setIdprocedimiento(imp.getIdimplante());
					proc.setIdsitclinica(indicacion.getIdsitclin());
					procdao.insert(proc);
					this.conn.commit();
					logger.info("Procedimiento de tipo "+tipo+" integrado con éxito en el sistema. NHC: "+nhc+". Fecha Procedimiento: "+fecha);
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de procedimiento de tipo "+tipo+". NHC: "+nhc+". Fecha Procedimiento: "+fecha+". Motivo: "+e.getMessage(),e);
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception ex){
			return -5;
		}
	}
	/**
	 * Metodo para insertar un nuevo registro de implante en el sistema
	 * @param nhc
	 * @param indicacion
	 * @param gen
	 * @param els
	 * @param hojaimp
	 * @param evolucion
	 * @return
	 *  
	 */
	public int insertarImplanteOtros(String nhc,int tipo,Date fecha,SituacionClinica sitclin,Generador gen,Electrodo[] els,HojaImplante hojaimp,Evolucion evolucion,String nproc) {
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else if(!validaTipoProcedimiento(tipo))
				return -4;
			else{
				// CONVERSION DE TIPOS DE DATOS
				SituacionClinicaProc indicacion = TipoConversor.convierte2SitClinProcIdea(sitclin);
				if(sitclin.getSintomas()!=null && sitclin.getSintomas()!=null &&sitclin.getSintomas().length>0){
					ArrayList<SintomasSitclinProc> sints = new ArrayList<SintomasSitclinProc>();
					for(Sintoma s:sitclin.getSintomas()){
						SintomasSitclinProc item_sint = new SintomasSitclinProc();
						item_sint.setIdsintomas(s.getSintoma());
						sints.add(item_sint);
					}
					indicacion.setSintomas(sints);
				}
				ImpGenerador impgen = TipoConversor.convierte2GeneradorIdea(gen);
					
				if(nproc.equals("056-2005"))
					System.out.println("AQUI");
				
				ImpHojaImplante himp = TipoConversor.convierte2HojaImplanteIdea(hojaimp);
				if(hojaimp.getPrimeroperador()!=null && hojaimp.getPrimeroperador().length>0){
					ArrayList<ImpHojaImplantePop> pop = new ArrayList<ImpHojaImplantePop>();
					for(Personal p:hojaimp.getPrimeroperador()){
						ImpHojaImplantePop item_pop = new ImpHojaImplantePop();
						item_pop.setIdop(p.getNombre());
						pop.add(item_pop);
					}
					himp.setPoperador(pop);
				}
				if(hojaimp.getSegundooperador()!=null&&hojaimp.getSegundooperador().length>0){
					ArrayList<ImpHojaImplanteSop> sop = new ArrayList<ImpHojaImplanteSop>();
					for(Personal p:hojaimp.getSegundooperador()){
						ImpHojaImplanteSop item_sop = new ImpHojaImplanteSop();
						item_sop.setIdop(p.getNombre());
						sop.add(item_sop);
					}	
					himp.setSoperador(sop);
				}
				if(hojaimp.getEnfermeria()!=null&&hojaimp.getEnfermeria().length>0){
					ArrayList<ImpHojaImplanteEnf> enf = new ArrayList<ImpHojaImplanteEnf>();
					for(Personal p:hojaimp.getEnfermeria()){
						ImpHojaImplanteEnf item_enf = new ImpHojaImplanteEnf();
						item_enf.setIdenf(p.getNombre());
						enf.add(item_enf);
					}	
					himp.setEnfermeras(enf);
				}
				ArrayList<ImpHojaImplanteComplicacion> comps_intra = new ArrayList<ImpHojaImplanteComplicacion>();
				if(hojaimp.getComplicaciones()!=null&&hojaimp.getComplicaciones().length>0){
					for(Complicaciones c: hojaimp.getComplicaciones()){
						ImpHojaImplanteComplicacion item_comp = TipoConversor.convierte2ComplicacionHojaImpIdea(c);
						comps_intra.add(item_comp);
					}
				}
				ImpEvolucion hev = TipoConversor.convierte2EvolucionIdea(evolucion);
				if(evolucion.getZonas()!=null&&evolucion.getZonas().length>0){
					ArrayList<ImpZona> zonas = new ArrayList<ImpZona>();
					for(int i=0;i<evolucion.getZonas().length;i++){
						ImpZona zn = TipoConversor.convierte2ZonaIdea(evolucion.getZonas()[i]);
						zonas.add(zn);
						ArrayList<ImpAtp> atps = new ArrayList<ImpAtp>();
						ArrayList<ImpChoques> choques = new ArrayList<ImpChoques>();					
						if(evolucion.getZonas()[i].getAtp1()!=null){
							ImpAtp atp1 = TipoConversor.convierte2AtpIdea(evolucion.getZonas()[i].getAtp1());
							atps.add(atp1);
						}
						if(evolucion.getZonas()[i].getAtp2()!=null){
							ImpAtp atp2 = TipoConversor.convierte2AtpIdea(evolucion.getZonas()[i].getAtp2());
							atps.add(atp2);
						}
						if(evolucion.getZonas()[i].getChoques()!=null){
							for(Choques ch:evolucion.getZonas()[i].getChoques()){
								ImpChoques c = TipoConversor.convierte2ChoqueIdea(ch);
								choques.add(c);
							}
						}
						//zn.setAtps(atps);
						//zn.setChqs(choques);				
						zonas.get(i).setAtps(atps);
						zonas.get(i).setChqs(choques);					
					}				
					hev.setZonas(zonas);
				}
				ArrayList<ImpEvolucionComplicacion> comps_post = new ArrayList<ImpEvolucionComplicacion>();				
				if(evolucion.getComplicaciones()!=null&&evolucion.getComplicaciones().length>0){
					for(Complicaciones c: evolucion.getComplicaciones()){
						ImpEvolucionComplicacion item_comp = TipoConversor.convierte2ComplicacionEvolucionIdea(c);
						comps_post.add(item_comp);
					}
				}
				// INICIO DE ALMACENAMIENTO
				try{
					this.conn.setAutoCommit(false);					
					Procedimiento proc = new Procedimiento();
					ImpImplante imp = new ImpImplante();
					imp.setFechaimplante(fecha);
					imp.setNproc(nproc);
					proc.setFecha(fecha);
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					
					// Recuperar sistema de electrodos del ultimo implnate/seguimiento
					ImpImplanteElectrodos[] sist_elec = null;
					Procedimiento[] prsimp = procdao.findByDynamicWhere("CODIGO=? AND FECHA <=? AND (TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? ) ORDER BY FECHA DESC",
							new Object[]{pat[0].getCodigo(),fecha,956,957,993,1059,1060,1085});
					int idelecimp = 0;
					if(prsimp.length>0){//Obtener ultimo sistema por comparacion de fecha
						// Sistema - ultimo implante hasta la fecha de seguimiento			
						//idimpgen = prsimp[0].getIdprocedimiento();
						idelecimp = impdao.findWhereIdimplanteEquals(prsimp[0].getIdprocedimiento())[0].getIdhojaimp();									
					}else if(prsimp.length==0){
						logger.info("No se puede crear un recambio sin implante previo");
						return -1;
					}					
					// Obtener sistema electrodos
					if(idelecimp>0)
						sist_elec = elecdao.findWhereIdhojaimpEquals(idelecimp);
					
					// Comparacion de electrodos
					// Se asume que todo debe venir con NS y MODELO asociado
					
					ArrayList<ImpImplanteElectrodos> sist_impelec = new ArrayList<ImpImplanteElectrodos>();
					if(els!=null && els.length>0){
						for(Electrodo e: els){
							sist_impelec.add(TipoConversor.convierte2ElectrodoIdea(e));
							/*if(e.getNserie()!=null && e.getNserie().length()>0 && !e.getNserie().equals("")){
								sist_impelec.add(TipoConversor.convierte2ElectrodoIdea(e));
								// encuentra en sist_elec y vacialo de la lista
								// TODO
							}else{// electrodo presente en el sistema
								  // busqueda por camara
								int pos_sist = obtenerElementoElectrodoCamara(e, sist_elec);
								if(pos_sist!=-1){
									ImpImplanteElectrodos aux = sist_elec[pos_sist];
									aux.setIdhojaimp(null);aux.setIdevolucion(null);aux.setIdimpelectrodos(null);
									e.setNserie(aux.getNumserie());
									e.setModelo(String.valueOf(aux.getIdelectrodo()));
									e.setEstado(0);
									e.setVia(aux.getVia());
									e.setLateralidad(aux.getLateralidad());
									e.setZonacamara(e.getZonacamara());
									e.setPorcion(aux.getPorcion());
									e.setFechaimplante(aux.getFechaimplante());
									sist_impelec.add(TipoConversor.convierte2ElectrodoIdea(e));
								}
							}*/
						}
					}else{ // No se informa de sistema de electrodos. Se deberia poner el ultimo sistema asociado
						for(ImpImplanteElectrodos e:sist_elec){
							ImpImplanteElectrodos cp = new ImpImplanteElectrodos();
							cp.setAbordajetexto(e.getAbordajetexto());
							cp.setCamara(e.getCamara());
							cp.setCaracter(e.getCaracter());							
							cp.setEstado(e.getEstado());
							cp.setFechaimplante(e.getFechaimplante());
							cp.setFechamod(e.getFechamod());
							cp.setIdelectrodo(e.getIdelectrodo());
							cp.setIdevolucion(e.getIdevolucion());
							cp.setIdhojaimp(e.getIdhojaimp());
							cp.setIdimpelectrodos(null);// para evitar problemas de guardado
							cp.setIdseg(e.getIdseg());
							cp.setVia(e.getVia());
							cp.setLateralidad(e.getLateralidad());
							cp.setZonacamara(e.getZonacamara());
							cp.setPorcion(e.getPorcion());
							cp.setNumserie(e.getNumserie());
							cp.setTipoelectrodo(e.getTipoelectrodo());
							sist_impelec.add(cp);
						}		
					}					
					
					// Guarda indicacion
					SituacionClinicaProcPk sitclinpk = this.sitclinprocdao.insert(indicacion);
					indicacion.setIdsitclin(sitclinpk.getIdsitclin());
					// Guarda sintomas
					guardaComponentesHind(indicacion);
					// Guarda HojaImplante
					ImpHojaImplantePk himppk = this.himpdao.insert(himp);
					himp.setIdhojaimp(himppk.getIdhojaimp());
					imp.setIdhojaimp(himppk.getIdhojaimp());
					guardaComponentesHimp(himp);
					// Guarda complicaciones intra					
					if(comps_intra.size()>0)
						for (ImpHojaImplanteComplicacion comp : comps_intra) {
							if (comp.getIdcompl() == null)
								comp.setIdcompl(25);// Otras complicaciones
							comp.setIdhojaimp(himp.getIdhojaimp());
							this.compintdao.insert(comp);
						}
					
					// Guarda generador
					impgen.setIdhojaimp(himppk.getIdhojaimp());// clave foranea con imphojaimplante
					ImpGeneradorPk genpk = this.gendao.insert(impgen);
					impgen.setIdimpgenerador(genpk.getIdimpgenerador());
					// Guarda Evolucion
					ImpEvolucionPk hevpk = this.hevdao.insert(hev);
					hev.setIdev(hevpk.getIdev());
					imp.setIdev(hevpk.getIdev());
					guardaComponentesHev(hev);
					// Guarda electrodos
					for(ImpImplanteElectrodos e:sist_impelec){
						e.setIdhojaimp(himppk.getIdhojaimp());
						e.setIdevolucion(hevpk.getIdev());
						ImpImplanteElectrodosPk impelecpk = this.elecdao.insert(e);
						e.setIdimpelectrodos(impelecpk.getIdimpelectrodos());
					}	
					// Guarda complicaciones post					
					if(comps_post.size()>0)
						for (ImpEvolucionComplicacion comp : comps_post) {
							if (comp.getIdcompl() == null)
								comp.setIdcompl(25);// Otras complicaciones
							comp.setIdev(hev.getIdev());
							this.comppostdao.insert(comp);
						}
					// Guarda implante
					ImpImplantePk imppk = this.impdao.insert(imp);
					imp.setIdimplante(imppk.getIdimplante());
					// Guarda procedimiento
					// Hay que ver el tipo de procedimiento en IDEA
					Procedimiento[] aux = this.procdao.findByDynamicWhere("CODIGO =? AND (TIPOPROCEDIMIENTO = ?)", new Object[] {
									proc.getCodigo(), 956 });
					if(aux!=null && aux.length>0 && tipo==956)
						proc.setTipoprocedimiento(1059);// Ya existe un primoimplante -> Recambio
					else
						proc.setTipoprocedimiento(tipo);
					
					proc.setIdprocedimiento(imp.getIdimplante());
					proc.setIdsitclinica(indicacion.getIdsitclin());
					procdao.insert(proc);
					this.conn.commit();
					logger.info("Procedimiento de tipo "+tipo+" integrado con éxito en el sistema. NHC: "+nhc+". Fecha Procedimiento: "+fecha);
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de procedimiento de tipo "+tipo+". NHC: "+nhc+". Fecha Procedimiento: "+fecha+". Motivo: "+e.getMessage(),e);
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception ex){
			return -5;
		}
	}
	private int obtenerElementoElectrodo(Electrodo e1, ImpImplanteElectrodos[] lista){
		for(int i=0;i<lista.length;i++){
			if(lista[i].getNumserie().equals(e1.getNserie()))
				return i;
		}
		return -1;
	}
	private int obtenerElementoElectrodoCamara(Electrodo e1, ImpImplanteElectrodos[] lista){
		for(int i=0;i<lista.length;i++){
			if(lista[i].getCamara() == e1.getCamara())
				return i;
		}
		return -1;
	}
	
	private void guardaComponentesHind(SituacionClinicaProc hind) throws Exception {
		sintdao.delete(new SintomasSitclinProcPk(hind.getIdsitclin(), null));
		for (SintomasSitclinProc sint : hind.getSintomas()) {
			if (sint.getIdsintomas() != null
					&& sint.getIdsintomas().length() > 0) {
				sint.setIdsitclin(hind.getIdsitclin());
				sintdao.insert(sint);
			}
		}
	}
	
	private void guardaComponentesHimp(ImpHojaImplante himp) throws Exception {
		// HIMP/Enf
		enfdao.delete(new ImpHojaImplanteEnfPk(himp.getIdhojaimp(), null));
		for (ImpHojaImplanteEnf enf : himp.getEnfermeras()) {
			if (enf.getIdenf() != null && enf.getIdenf().length() > 0) {
				enf.setIdhojaimp(himp.getIdhojaimp());
				enfdao.insert(enf);
			}
		}
		// HIMP/Pop
		popdao.delete(new ImpHojaImplantePopPk(himp.getIdhojaimp(), null));
		for (ImpHojaImplantePop pop : himp.getPoperador()) {
			if (pop.getIdop() != null && pop.getIdop().length() > 0) {
				pop.setIdhojaimp(himp.getIdhojaimp());
				popdao.insert(pop);
			}
		}
		// HIMP/Sop
		sopdao.delete(new ImpHojaImplanteSopPk(himp.getIdhojaimp(), null));
		for (ImpHojaImplanteSop sop : himp.getSoperador()) {
			if (sop.getIdop() != null && sop.getIdop().length() > 0) {
				sop.setIdhojaimp(himp.getIdhojaimp());
				sopdao.insert(sop);
			}
		}
	}
	private void guardaComponentesHev(ImpEvolucion hev) throws Exception {		
		// Zonas + Atps y Choques
		/*for (ImpAtpPk atpk : this.listaatppk)
			this.atpdao.delete(atpk);
		for (ImpChoquesPk chpk : this.listachoquespk)
			this.choqdao.delete(chpk);
		for (ImpZonaPk zpk : this.listazonapk)
			this.zonadao.delete(zpk);*/
		for (ImpZona z : hev.getZonas()) {
			z.setIdev(hev.getIdev());
			ImpZonaPk zpk = this.zonadao.insert(z);
			z.setIdzona(zpk.getIdzona());
			for (ImpAtp a : z.getAtps()) {
				a.setIdzona(z.getIdzona());
				ImpAtpPk apk = this.atpdao.insert(a);
				a.setIdatp(apk.getIdatp());
			}
			if (z.getChqs().size() > 0
					&& (z.getChqs().get(0).getEnergia() != null)) {
				for (ImpChoques ch : z.getChqs()) {
					ch.setIdzona(z.getIdzona());
					ImpChoquesPk chpk = this.choqdao.insert(ch);
					ch.setIdzona(chpk.getIdch());
				}
			}
		}
	}
	private boolean validaTipoProcedimiento(int tipo){
		return (tipo==956 || tipo==957 || tipo==1059 || tipo==1060 || tipo==993 || tipo==1085 || tipo==1147)?true:false;
	}
	
	
	public int insertarSeguimiento(String nhc, Date fecha, int tiposeg, int motivonopr,
			boolean remoto, String op, Date fechaprox, int caracterprox,
			SituacionClinica sitclin, Electrodo[] els, Sistema sistema, Bloqueo bloqueo, PorEstimulacion porestim,
			ObservacionMP obsmp, ObservacionDAI obsdai, Evolucion evolucion, Complicaciones[] comps,
			String nseg, String com){
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else{
				// CONVERSION DE TIPOS DE DATOS
				SituacionClinicaProc indicacion = TipoConversor.convierte2SitClinProcIdea(sitclin);
				if(sitclin.getSintomas()!=null && sitclin.getSintomas().length>0){
					ArrayList<SintomasSitclinProc> sints = new ArrayList<SintomasSitclinProc>();
					for(Sintoma s:sitclin.getSintomas()){
						SintomasSitclinProc item_sint = new SintomasSitclinProc();
						item_sint.setIdsintomas(s.getSintoma());
						sints.add(item_sint);
					}
					indicacion.setSintomas(sints);
				}
				SegSistema seg_sist = null;
				if(sistema!=null)		
					seg_sist = TipoConversor.convierte2SistemaIdea(sistema);
				SegBloqueos seg_bloqueo = null;
				if(bloqueo!=null)
					seg_bloqueo = TipoConversor.convierte2BloqueoIdea(bloqueo);
				SegPorestimulacion seg_por = null;
				if(porestim!=null)
					seg_por = TipoConversor.convierte2PorEstimIdea(porestim);
				SegObservacionesMp seg_obsmp = null;
				if(obsmp!=null)
					seg_obsmp = TipoConversor.convierte2ObsMpIdea(obsmp);
				SegObservacionesDai seg_obsdai = null;
				if(obsdai!=null)
					seg_obsdai = TipoConversor.convierte2ObsDaiIdea(obsdai);
				
				// CONTROL DE AUSENCIA DE ELECTRODOS
				// 1. Si no se recibe nada, se buscara el último sistema de electrodos del implante al que pertenece
				// 2. Si vienen electrodos informados, no se hace nada		
				ArrayList<ImpImplanteElectrodos> impelec = new ArrayList<ImpImplanteElectrodos>();
				if(els!=null && els.length>0){
					for(Electrodo e:els)
						impelec.add(TipoConversor.convierte2ElectrodoIdea(e));
				}else{
					// Recuperar sistema de electrodos del ultimo implante/seguimiento
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					int codigo_pat = 0;
					if(pat.length>0)
						codigo_pat = pat[0].getCodigo();
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					ImpImplanteElectrodos[] sist_elec = null;
					Procedimiento[] prsimp = procdao.findByDynamicWhere("CODIGO=? AND FECHA <=? AND (TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? ) ORDER BY FECHA DESC",
							new Object[]{codigo_pat,fecha,956,957,993,1059,1060,1085});
					int idelecimp = 0;
					if(prsimp.length>0){//Obtener ultimo sistema por comparacion de fecha
						// Sistema - ultimo implante hasta la fecha de seguimiento			
						idelecimp = impdao.findWhereIdimplanteEquals(prsimp[0].getIdprocedimiento())[0].getIdhojaimp();									
					}else if(prsimp.length==0){
						logger.info("No se puede crear un seguimiento sin implante previo");
						return -1;
					}							
					if(idelecimp>0)// Obtener sistema electrodos
						sist_elec = elecdao.findWhereIdhojaimpEquals(idelecimp);
					if(sist_elec!=null){
						for(ImpImplanteElectrodos e:sist_elec){
							ImpImplanteElectrodos cp = new ImpImplanteElectrodos();
							cp.setAbordajetexto(e.getAbordajetexto());
							cp.setCamara(e.getCamara());
							cp.setCaracter(e.getCaracter());							
							cp.setEstado(e.getEstado());
							cp.setFechaimplante(e.getFechaimplante());
							cp.setFechamod(e.getFechamod());
							cp.setIdelectrodo(e.getIdelectrodo());
							cp.setIdevolucion(e.getIdevolucion());
							cp.setIdhojaimp(e.getIdhojaimp());
							cp.setIdimpelectrodos(null);// para evitar problemas de guardado
							cp.setIdseg(e.getIdseg());
							cp.setVia(e.getVia());
							cp.setLateralidad(e.getLateralidad());
							cp.setZonacamara(e.getZonacamara());
							cp.setPorcion(e.getPorcion());
							cp.setNumserie(e.getNumserie());
							cp.setTipoelectrodo(e.getTipoelectrodo());
							impelec.add(cp);
						}
					}
				}
				
				ImpEvolucion hev = null;
				if(evolucion!=null){
					hev = TipoConversor.convierte2EvolucionIdea(evolucion);
					if(evolucion.getZonas()!=null&&evolucion.getZonas().length>0){
						ArrayList<ImpZona> zonas = new ArrayList<ImpZona>();
						for(int i=0;i<evolucion.getZonas().length;i++){
							ImpZona zn = TipoConversor.convierte2ZonaIdea(evolucion.getZonas()[i]);
							zonas.add(zn);
							ArrayList<ImpAtp> atps = new ArrayList<ImpAtp>();
							ArrayList<ImpChoques> choques = new ArrayList<ImpChoques>();					
							if(evolucion.getZonas()[i].getAtp1()!=null){
								ImpAtp atp1 = TipoConversor.convierte2AtpIdea(evolucion.getZonas()[i].getAtp1());
								atps.add(atp1);
							}
							if(evolucion.getZonas()[i].getAtp2()!=null){
								ImpAtp atp2 = TipoConversor.convierte2AtpIdea(evolucion.getZonas()[i].getAtp2());
								atps.add(atp2);
							}
							if(evolucion.getZonas()[i].getChoques()!=null){
								for(Choques ch:evolucion.getZonas()[i].getChoques()){
									ImpChoques c = TipoConversor.convierte2ChoqueIdea(ch);
									choques.add(c);
								}
							}
							//zn.setAtps(atps);
							//zn.setChqs(choques);				
							zonas.get(i).setAtps(atps);
							zonas.get(i).setChqs(choques);					
						}				
						hev.setZonas(zonas);
					}
				}
				ArrayList<SegComplicaciones> comps_seg = null;
				if(comps != null && comps.length>0){
					comps_seg = new ArrayList<SegComplicaciones>();
					for(Complicaciones c:comps){
						SegComplicaciones comp = new SegComplicaciones();
						comp.setIdcomp(c.getIdcomplicacion());
						comp.setResultado(c.getResultado());
						comp.setActitud(c.getActitud());
						comp.setOtra(c.getOtra());
						comps_seg.add(comp);
					}
				}
				// PROCEDIMIENTO GUARDAR
				try{
					this.conn.setAutoCommit(false);					
					Procedimiento proc = new Procedimiento();
					proc.setFecha(fecha);
					proc.setTipoprocedimiento(983);
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					// Guarda indicacion
					SituacionClinicaProcPk sitclinpk = this.sitclinprocdao.insert(indicacion);
					indicacion.setIdsitclin(sitclinpk.getIdsitclin());
					// Guarda sintomas
					guardaComponentesHind(indicacion);
					SegSeguimiento seg = new SegSeguimiento();
					seg.setFecha(fecha);				
					seg.setRemoto(remoto?(short) 1:(short) 0);
					seg.setTiposeguimiento(tiposeg!=-2147483648?tiposeg:0);
					seg.setMotivonoprog(motivonopr!=-2147483648?motivonopr:0);
					seg.setOperador(op!=null&&op.length()>0?op:null);
					seg.setCaracterproximo(caracterprox!=-2147483648?caracterprox:0);
					seg.setFechaproximoseg(fechaprox);
					seg.setComentarios(com);
					// NSEG - Aun no implementado
					// busqueda de generador asociado
					Procedimiento[] prsimp = procdao.findByDynamicWhere("CODIGO=? AND FECHA <=? AND (TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? ) ORDER BY FECHA DESC",
							new Object[]{pat[0].getCodigo(),fecha,956,957,993,1059,1060,1085});
					Procedimiento[] prsseg = procdao.findByDynamicWhere("CODIGO=? AND FECHA <=? AND TIPOPROCEDIMIENTO=? ORDER BY FECHA DESC",
							new Object[]{pat[0].getCodigo(),fecha,983});
					
					int idimpgen=0;int idelecimp = 0;int idelecseg = 0;int idimp=0;
					if(prsimp.length>0 && prsseg.length>0){//Obtener ultimo sistema por comparacion de fecha
						if(UtilFechas.dateDiff(prsimp[0].getFecha(), prsseg[0].getFecha())>=0){	// Sistema - ultimo implante hasta la fecha de seguimiento			
							//idimpgen = prsimp[0].getIdprocedimiento();
							idimpgen = impdao.findWhereIdimplanteEquals(prsimp[0].getIdprocedimiento())[0].getIdhojaimp();
							idelecimp = idimpgen;
							idimp = impdao.findWhereIdimplanteEquals(prsimp[0].getIdprocedimiento())[0].getIdimplante();
						}else{ // Sistema - ultimo seguimiento hasta la fecha de seguimiento
							SegSeguimiento sg = segdao.findByPrimaryKey(prsseg[0].getIdprocedimiento());
							ImpImplante imp = impdao.findByPrimaryKey(sg.getIdimpl());
							idimpgen = imp.getIdhojaimp();
							idelecseg = prsseg[0].getIdprocedimiento();
							idimp = imp.getIdimplante();
						}			
					}else if(prsimp.length==0 && prsseg.length==0){
						logger.info("No se puede crear un seguimiento sin implante previo");
						return -1;
					}				
					else if(prsimp.length==0 && prsseg.length>=0){//Sistema - Ultimo seguimiento
						SegSeguimiento sg = segdao.findByPrimaryKey(prsseg[0].getIdprocedimiento());
						ImpImplante imp = impdao.findByPrimaryKey(sg.getIdimpl());
						idimpgen = imp.getIdhojaimp();
						idelecseg = prsseg[0].getIdprocedimiento();
						idimp = imp.getIdimplante();
					}else{// Sistema - ultimo implante
						idimpgen = impdao.findWhereIdimplanteEquals(prsimp[0].getIdprocedimiento())[0].getIdhojaimp();
						idelecimp = idimpgen;
						idimp = impdao.findWhereIdimplanteEquals(prsimp[0].getIdprocedimiento())[0].getIdimplante();
					}
					// fin busqueda generador asociado
					// MAÑA MMESEGUER - ASIGNAR COMENTARIOS DE SEGUIMIENTO A LOS DE SISTEMA PARA QUE SEAN GENERALES
					seg_sist.setComentarios(seg.getComentarios());// externos
					seg.setComentarios(null);//interno
					///////////////////
					SegSistemaPk sistpk = this.sistdao.insert(seg_sist);
					seg.setIdsistema(sistpk.getIdsistema());
					// bloqueos
					if(seg_bloqueo==null)
						seg_bloqueo = new SegBloqueos();			
					SegBloqueosPk blpk = this.bloqdao.insert(seg_bloqueo);
					seg.setIdbloqueo(blpk.getIdbloqueo());
					// Porcentajes de estimulacion
					if(seg_por==null)
						seg_por = new SegPorestimulacion();					
					SegPorestimulacionPk pepk = this.porestimdao.insert(seg_por);
					seg.setIdporestim(pepk.getIdporestim());
					// Evolucion - programacion
					ImpEvolucionPk evpk = this.hevdao.insert(hev);
					seg.setIdev(evpk.getIdev());
					guardaComponentesHev(hev);
					
					//obsdai
					if(seg_obsdai!=null){
						SegObservacionesDaiPk obsdaipk = this.obsdaidao.insert(seg_obsdai);
						seg.setIdobsdai(obsdaipk.getIdobsdai());
					}
					//obsmp
					if(seg_obsmp!=null){
						SegObservacionesMpPk obsmppk = this.obsmpdao.insert(seg_obsmp);
						seg.setIdobsmp(obsmppk.getIdobsmp());
					}
					
					seg.setIdimpl(idimp);
					SegSeguimientoPk segpk = this.segdao.insert(seg);
					
					// Guarda electrodos
					for(ImpImplanteElectrodos e:impelec){
						e.setIdhojaimp(null);
						e.setIdseg(segpk.getIdseg());
						e.setIdevolucion(evpk.getIdev());
						ImpImplanteElectrodosPk impelecpk = this.elecdao.insert(e);
						e.setIdimpelectrodos(impelecpk.getIdimpelectrodos());
					}	
					// Guarda complicaciones					
					if(comps_seg!=null && comps_seg.size()>0)
						for (SegComplicaciones comp : comps_seg) {
							if (comp.getIdcomp() == null)
								comp.setIdcomp(25);// Otras complicaciones
							comp.setIdseg(segpk.getIdseg());
							this.compdao.insert(comp);
						}					
					proc.setIdprocedimiento(segpk.getIdseg());
					proc.setIdsitclinica(indicacion.getIdsitclin());
					this.procdao.insert(proc);
					this.conn.commit();
					logger.info("Procedimiento de tipo Seguimiento integrado con éxito en el sistema. NHC: "+nhc+". Fecha Procedimiento: "+fecha);
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de procedimiento de tipo Seguimiento. NHC: "+nhc+". Fecha Procedimiento: "+fecha+". Motivo: "+e.getMessage(),e);
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception e){
			return -5;
		}
	}
	public int insertarMesa(String nhc,Date fecha,SituacionClinica sitclin,ECGEF ecg, Mesa m){
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else{
				// CONVERSION DE TIPOS DE DATOS
				/*SituacionClinicaProc indicacion = TipoConversor.convierte2SitClinProcIdea(sitclin);
				if(sitclin.getSintomas().length>0){
					ArrayList<SintomasSitclinProc> sints = new ArrayList<SintomasSitclinProc>();
					for(Sintoma s:sitclin.getSintomas()){
						SintomasSitclinProc item_sint = new SintomasSitclinProc();
						item_sint.setIdsintomas(s.getSintoma());
						sints.add(item_sint);
					}
					indicacion.setSintomas(sints);
				}*/
				ArrMesas mesa = null;
				if(m!=null)
					mesa = TipoConversor.convierte2MesaIdea(m);
					
				ArrMesasEcg m_ecg = null;
				if(ecg!=null)
					m_ecg = TipoConversor.convierte2MesaECGIdea(ecg);

				// INICIO DE ALMACENAMIENTO
				try{
					this.conn.setAutoCommit(false);					
					Procedimiento proc = new Procedimiento();
					mesa.setFecha(fecha);
					proc.setFecha(fecha);
					proc.setTipoprocedimiento(1066);
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					// Guarda indicacion
					//SituacionClinicaProcPk sitclinpk = this.sitclinprocdao.insert(indicacion);
					//indicacion.setIdsitclin(sitclinpk.getIdsitclin());
					// Guarda Mesa
					mesa.setIdPaciente(pat[0].getCodigo());
					ArrMesasPk mesapk = this.mesadao.insert(mesa);
					m_ecg.setIdmesa(mesapk.getIdMesa());
					this.mesaecgdao.insert(m_ecg);
					// Guarda procedimiento
					//proc.setIdsitclinica(indicacion.getIdsitclin());
					proc.setIdprocedimiento(mesapk.getIdMesa());
					procdao.insert(proc);
					this.conn.commit();
					logger.info("Procedimiento de tipo Mesa Basculante integrado con éxito en el sistema. ");
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de procedimiento de tipo Mesa Basculante. Motivo: "+e.fillInStackTrace());
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception e){
			return -5;
		}
	}
	public int insertarRegistrador(String nhc,Date fecha,SituacionClinica sitclin,ECGEF ecg, Registrador r){
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else{
				// CONVERSION DE TIPOS DE DATOS
				/*SituacionClinicaProc indicacion = TipoConversor.convierte2SitClinProcIdea(sitclin);
				if(sitclin.getSintomas().length>0){
					ArrayList<SintomasSitclinProc> sints = new ArrayList<SintomasSitclinProc>();
					for(Sintoma s:sitclin.getSintomas()){
						SintomasSitclinProc item_sint = new SintomasSitclinProc();
						item_sint.setIdsintomas(s.getSintoma());
						sints.add(item_sint);
					}
					indicacion.setSintomas(sints);
				}*/
				ArrRegistrador reg = null;
				if(r!=null)
					reg = TipoConversor.convierte2RegistradorIdea(r);
					
				ArrRegistradorEcg r_ecg = null;
				if(ecg!=null)
					r_ecg = TipoConversor.convierte2RegistradorECGIdea(ecg);

				// INICIO DE ALMACENAMIENTO
				try{
					this.conn.setAutoCommit(false);					
					Procedimiento proc = new Procedimiento();
					reg.setFecha(fecha);
					proc.setFecha(fecha);
					proc.setTipoprocedimiento(1067);
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					// Guarda indicacion
					//SituacionClinicaProcPk sitclinpk = this.sitclinprocdao.insert(indicacion);
					//indicacion.setIdsitclin(sitclinpk.getIdsitclin());
					// Guarda Mesa
					reg.setIdPaciente(pat[0].getCodigo());
					ArrRegistradorPk regpk = this.regdao.insert(reg);
					r_ecg.setIdRegistrador(regpk.getIdRegistrador());
					this.regecgdao.insert(r_ecg);
					// Guarda procedimiento
					//proc.setIdsitclinica(indicacion.getIdsitclin());
					proc.setIdprocedimiento(regpk.getIdRegistrador());
					procdao.insert(proc);
					this.conn.commit();
					logger.info("Procedimiento de tipo Registrador de eventos integrado con éxito en el sistema. ");
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de procedimiento de tipo Registrador de eventos. Motivo: "+e.fillInStackTrace());
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception e){
			return -5;
		}
	}
	public int insertarTestFLE(String nhc,Date fecha,SituacionClinica sitclin,ECGEF ecg,TestFLE t){
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else{
				// CONVERSION DE TIPOS DE DATOS
				/*
				SituacionClinicaProc indicacion = TipoConversor.convierte2SitClinProcIdea(sitclin);
				if(sitclin.getSintomas().length>0){
					ArrayList<SintomasSitclinProc> sints = new ArrayList<SintomasSitclinProc>();
					for(Sintoma s:sitclin.getSintomas()){
						SintomasSitclinProc item_sint = new SintomasSitclinProc();
						item_sint.setIdsintomas(s.getSintoma());
						sints.add(item_sint);
					}
					indicacion.setSintomas(sints);
				}*/
				ArrTestFle test = null;
				if(t!=null)
					test = TipoConversor.convierte2TestFLEIdea(t);
				ArrTestFleEcg t_ecg = null;
				if(ecg!=null)
					t_ecg = TipoConversor.convierte2TestFLEECGIdea(ecg);
	
				// INICIO DE ALMACENAMIENTO
				try{
					this.conn.setAutoCommit(false);					
					Procedimiento proc = new Procedimiento();
					test.setFecha(fecha);
					proc.setFecha(fecha);
					proc.setTipoprocedimiento(1065);
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					// Guarda indicacion
					//SituacionClinicaProcPk sitclinpk = this.sitclinprocdao.insert(indicacion);
					//indicacion.setIdsitclin(sitclinpk.getIdsitclin());
					// Guarda Test
					test.setCodigoPaciente(pat[0].getCodigo());
					ArrTestFlePk testpk = this.testfledao.insert(test);
					t_ecg.setIdtest(testpk.getCodigoTest());
					this.testfleecgdao.insert(t_ecg);
					// Guarda procedimiento
					//proc.setIdsitclinica(indicacion.getIdsitclin());
					proc.setIdprocedimiento(testpk.getCodigoTest());
					procdao.insert(proc);
					this.conn.commit();
					logger.info("Procedimiento de tipo Test Flecainida integrado con éxito en el sistema. ");
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de procedimiento de tipo Test Flecainida. Motivo: "+e.fillInStackTrace());
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception e){
			return -5;
		}
	}
	public int insertarTestATP(String nhc,Date fecha,SituacionClinica sitclin,ECGEF ecg,TestATP t){
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else{
				// CONVERSION DE TIPOS DE DATOS
				/*
				SituacionClinicaProc indicacion = TipoConversor.convierte2SitClinProcIdea(sitclin);
				if(sitclin.getSintomas().length>0){
					ArrayList<SintomasSitclinProc> sints = new ArrayList<SintomasSitclinProc>();
					for(Sintoma s:sitclin.getSintomas()){
						SintomasSitclinProc item_sint = new SintomasSitclinProc();
						item_sint.setIdsintomas(s.getSintoma());
						sints.add(item_sint);
					}
					indicacion.setSintomas(sints);
				}*/
				ArrTestAtp test = null;
				if(t!=null)
					test = TipoConversor.convierte2TestATPIdea(t);
				ArrTestAtpEcg t_ecg = null;
				if(ecg!=null)
					t_ecg = TipoConversor.convierte2TestATPECGIdea(ecg);
	
				// INICIO DE ALMACENAMIENTO
				try{
					this.conn.setAutoCommit(false);					
					Procedimiento proc = new Procedimiento();
					test.setFecha(fecha);
					proc.setFecha(fecha);
					proc.setTipoprocedimiento(1063);
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					// Guarda indicacion
					//SituacionClinicaProcPk sitclinpk = this.sitclinprocdao.insert(indicacion);
					//indicacion.setIdsitclin(sitclinpk.getIdsitclin());
					// Guarda Test
					test.setCodigoPaciente(pat[0].getCodigo());
					ArrTestAtpPk testpk = this.testatpdao.insert(test);
					t_ecg.setIdtest(testpk.getCodigoTest());
					this.testatpecgdao.insert(t_ecg);
					// Guarda procedimiento
					//proc.setIdsitclinica(indicacion.getIdsitclin());
					proc.setIdprocedimiento(testpk.getCodigoTest());
					procdao.insert(proc);
					this.conn.commit();
					logger.info("Procedimiento de tipo Test ATP integrado con éxito en el sistema. NHC:"+nhc);
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de procedimiento de tipo Test ATP. Motivo: "+e.fillInStackTrace());
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception e){
			return -5;
		}
	}
	
	public int insertarPlanMedicacion(String nhc, PlanMedicacion[] planes){
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else{
				// Conversion
				ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
				if(pat.length<=0){
					logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
					return -2;
				}
				ArrayList<PlanMedGen> lista = new ArrayList<PlanMedGen>();
				for(PlanMedicacion p:planes){
					PlanMedGen pmed = TipoConversor.convierte2PlanMedGenIdea(p);
					pmed.setIdpaciente(pat[0].getCodigo());
					pmed.setEstado(1);// Los ponemos todos activos por defecto
					lista.add(pmed);
				}
				// INICIO DE ALMACENAMIENTO
				try{
					this.conn.setAutoCommit(false);					
					// Guarda Lista de planes de medicación
					for(PlanMedGen p:lista)
						this.pgdao.insert(p);					
					this.conn.commit();
					logger.info("Plan de Medicacion integrado con éxito en el sistema. NHC:"+nhc);
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de PLAN DE MEDICACION. Motivo: "+e.fillInStackTrace());
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception e){
			return -5;
		}
	}
	
	public int insertarSeguimientoRegistrador(String nhc,Date fecha,SituacionClinica sitclin,SeguimientoRegistrador seg){
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(fecha==null || fecha.toString().length()<=0)
				return -3;
			else{
				// Conversion
				SituacionClinicaProc st = TipoConversor.convierte2SitClinProcIdea(sitclin);
				SegSeguimientoRegEventos seg_reg = TipoConversor.convierte2SegRegEventos(seg);				
				// INICIO DE ALMACENAMIENTO
				try{
					this.conn.setAutoCommit(false);					
					// Guarda situacion clinica
					Procedimiento proc = new Procedimiento();
					proc.setFecha(fecha);
					proc.setTipoprocedimiento(1088);
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						proc.setCodigo(pat[0].getCodigo());
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					// Busqueda de implante asociado. Se busca procedimientos de reg. de eventos anteriores a la fecha suministrada. 
					// El mas proximo a la fecha del seguimiento, sera el implante asociado
					Procedimiento[] procs = procdao.findByDynamicWhere("CODIGO=? AND FECHA <=? AND TIPOPROCEDIMIENTO=? ORDER BY FECHA DESC",
							new Object[]{pat[0].getCodigo(),fecha,1067});
					if(procs!=null && procs.length>0)
						seg_reg.setIdregeventos(procs[0].getIdprocedimiento());
					// TODO - REVISAR PORISIBLIDAD DE DEVOLVER ERROR EN CASO DE NO ENCONTRAR IMPLANTE DE REGISTRADOR...
					// Guarda indicacion
					SituacionClinicaProcPk sitclinpk = this.sitclinprocdao.insert(st);
					st.setIdsitclin(sitclinpk.getIdsitclin());
					// Guarda seguimiento
					SegSeguimientoRegEventosPk segregpk = this.segregdao.insert(seg_reg);
					// Guarda procedimiento
					proc.setIdsitclinica(st.getIdsitclin());
					proc.setIdprocedimiento(segregpk.getIdseg());
					this.procdao.insert(proc);
					this.conn.commit();
					logger.info("Seguimiento de Registrador de Eventos integrado con éxito en el sistema. NHC:"+nhc);
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de Seguimiento de Registrador de Eventos. Motivo: "+e.fillInStackTrace(),e);
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception e){
			return -5;
		}
	}
	
	public int insertarListaEspera(String nhc,ListaEspera le){
		try{
			if(nhc==null || nhc.length()<=0)
				return -1;
			else if(le==null )
				return -3;
			else{
				// Conversion
				ArrListaEspera item = TipoConversor.convierte2ListaEsperaIdea(le);
				// INICIO DE ALMACENAMIENTO
				try{
					this.conn.setAutoCommit(false);										
					ArrPacientes[] pat = this.patdao.findWhereNhcEquals(nhc);
					if(pat.length>0)
						item.setCodigoPaciente(pat[0].getCodigo());
					else{
						logger.error("Error de integración de nuevo paciente con NHC: "+nhc+". Motivo: no existe paciente con ese NHC asignado");
						return -2;			
					}
					this.ledao.insert(item);
					this.conn.commit();
					logger.info("Elemento de Lista de espera integrado con éxito en el sistema. NHC:"+nhc);
					return 1;
				}catch(Exception e){
					logger.error("Error en integración de Elemento de Lista de espera. Motivo: "+e.fillInStackTrace(),e);
					this.conn.rollback();
					return -5;
				}finally {
				    if (this.conn != null) {
				        this.conn.close();
				    }
				}
			}
		}catch(Exception e){
			return -5;
		}
	}
	
}

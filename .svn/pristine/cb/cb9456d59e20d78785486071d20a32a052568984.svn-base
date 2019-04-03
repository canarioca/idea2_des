package com.sorin.idea.integracion.canal.logica;

import java.util.Date;

import com.sorin.idea.dto.ArrAblacionComplica;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrConducPf;
import com.sorin.idea.dto.ArrConduccEc;
import com.sorin.idea.dto.ArrEnf;
import com.sorin.idea.dto.ArrEstudio;
import com.sorin.idea.dto.ArrEstudioAblacion;
import com.sorin.idea.dto.ArrEstudioCatApl;
import com.sorin.idea.dto.ArrEstudioCatUso;
import com.sorin.idea.dto.ArrEstudioComplicaciones;
import com.sorin.idea.dto.ArrEstudioConduccav;
import com.sorin.idea.dto.ArrEstudioEcg;
import com.sorin.idea.dto.ArrEstudioIntento;
import com.sorin.idea.dto.ArrEstudioNproc;
import com.sorin.idea.dto.ArrEstudioPeriodo;
import com.sorin.idea.dto.ArrEstudioResultado;
import com.sorin.idea.dto.ArrEstudioSinusal;
import com.sorin.idea.dto.ArrEstudioTaqui;
import com.sorin.idea.dto.ArrEstudioVias;
import com.sorin.idea.dto.ArrListaEspera;
import com.sorin.idea.dto.ArrMesas;
import com.sorin.idea.dto.ArrMesasEcg;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.ArrRegistrador;
import com.sorin.idea.dto.ArrRegistradorEcg;
import com.sorin.idea.dto.ArrSinusalPf;
import com.sorin.idea.dto.ArrTestAtp;
import com.sorin.idea.dto.ArrTestAtpEcg;
import com.sorin.idea.dto.ArrTestFle;
import com.sorin.idea.dto.ArrTestFleEcg;
import com.sorin.idea.dto.ImpAtp;
import com.sorin.idea.dto.ImpChoques;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpEvolucionComplicacion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.PlanMedGen;
import com.sorin.idea.dto.SegBloqueos;
import com.sorin.idea.dto.SegComplicaciones;
import com.sorin.idea.dto.SegObservacionesDai;
import com.sorin.idea.dto.SegObservacionesMp;
import com.sorin.idea.dto.SegPorestimulacion;
import com.sorin.idea.dto.SegSeguimientoRegEventos;
import com.sorin.idea.dto.SegSistema;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.integracion.canal.AblacionEF;
import com.sorin.idea.integracion.canal.Atp;
import com.sorin.idea.integracion.canal.Bloqueo;
import com.sorin.idea.integracion.canal.CV;
import com.sorin.idea.integracion.canal.CateterEF;
import com.sorin.idea.integracion.canal.Choques;
import com.sorin.idea.integracion.canal.ComplicacionAblacionEF;
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
import com.sorin.idea.integracion.canal.NProcEF;
import com.sorin.idea.integracion.canal.ObservacionDAI;
import com.sorin.idea.integracion.canal.ObservacionMP;
import com.sorin.idea.integracion.canal.Paciente;
import com.sorin.idea.integracion.canal.PeriodoRefractarioEF;
import com.sorin.idea.integracion.canal.PlanMedicacion;
import com.sorin.idea.integracion.canal.PorEstimulacion;
import com.sorin.idea.integracion.canal.PruebasFarmaEF;
import com.sorin.idea.integracion.canal.Registrador;
import com.sorin.idea.integracion.canal.ResultadoAblacionEF;
import com.sorin.idea.integracion.canal.SeguimientoRegistrador;
import com.sorin.idea.integracion.canal.Sistema;
import com.sorin.idea.integracion.canal.SituacionClinica;
import com.sorin.idea.integracion.canal.TaquicardiaEF;
import com.sorin.idea.integracion.canal.TestATP;
import com.sorin.idea.integracion.canal.TestFLE;
import com.sorin.idea.integracion.canal.ViaAccesoriaEF;
import com.sorin.idea.integracion.canal.Zona;

public class TipoConversor {

	/**
	 * Metodo para convertir de paciente WS a paciente IDEA
	 * @param pat
	 * @return paciente completo
	 * 		   Si error de conversion, null
	 */
	public static ArrPacientes convierte2PatIdea(Paciente pat){
		ArrPacientes paciente = new ArrPacientes();
		try{
			paciente.setNhc(pat.getNhc());
			paciente.setNuhsa(pat.getNuhsa()!=null&&pat.getNuhsa().length()>0?pat.getNuhsa():null);
			paciente.setNombre(pat.getNombre());
			paciente.setApellid1(pat.getApellido1()!=null&&pat.getApellido1().length()>0?pat.getApellido1():null);
			paciente.setApellid2(pat.getApellido2()!=null&&pat.getApellido2().length()>0?pat.getApellido2():null);
			paciente.setSexo(String.valueOf(pat.getSexo()).length()>0&&pat.getSexo()>0?pat.getSexo():0);
			paciente.setFechanaci(pat.getFechanaci()!=null&&pat.getFechanaci().toString().length()>0?pat.getFechanaci():null);
			paciente.setDni(pat.getDni()!=null&&pat.getDni().length()>0?pat.getDni():null);
			paciente.setNss1(pat.getNss1()!=null&&pat.getNss1().length()>0?pat.getNss1():null);
			paciente.setDireccion(pat.getDireccion()!=null&&pat.getDireccion().length()>0?pat.getDireccion():null);
			paciente.setPoblacion(pat.getPoblacion()!=null&&pat.getPoblacion().length()>0?pat.getPoblacion():null);
			paciente.setProvincia(pat.getProvincia()!=null&&pat.getProvincia().length()>0?pat.getProvincia():null);
			paciente.setPais(pat.getPais()!=null&&pat.getPais().length()>0?pat.getPais():null);
			paciente.setCp(pat.getCp()!=null&&pat.getCp().length()>0?pat.getCp():null);
			paciente.setEstado(pat.getEstado()!=null&&pat.getEstado().length()>0?pat.getEstado():null);
			paciente.setTelefono1(pat.getTelefono1()!=null&&pat.getTelefono1().length()>0?pat.getTelefono1():null);
			paciente.setTelefono2(pat.getTelefono2()!=null&&pat.getTelefono2().length()>0?pat.getTelefono2():null);
			paciente.setCorreo(pat.getCorreo()!=null&&pat.getCorreo().length()>0?pat.getCorreo():null);
			paciente.setProcedencia(String.valueOf(pat.getProcedencia()).length()>0&&pat.getProcedencia()!=-2147483648?pat.getProcedencia():0);
			paciente.setHprocedencia(String.valueOf(pat.getHprocedencia()).length()>0&&pat.getHprocedencia()!=-2147483648?pat.getHprocedencia():0);
			paciente.setAVoid(0);
			paciente.setIdfusion(null);
		}catch(Exception e){
			return null;
		}		
		return paciente;		
	}
	/**
	 * Metodo para convertir tipo Situacion clinica WS a Situacion Clinica General IDEA
	 * @param st
	 * @return objeto situacion clinica completo
	 * 		   null si fallo
	 */
	public static SituacionClinicaGeneral convierte2SitClinGenIdea(SituacionClinica st){
		SituacionClinicaGeneral sitclin = new SituacionClinicaGeneral();
		try{
			sitclin.setFevi(st.getFevi()!=null&&st.getFevi().length()>0?st.getFevi():null);
			sitclin.setFuncionventricular(String.valueOf(st.getFuncionventricular()).length()>0&&st.getFuncionventricular()!=-2147483648?st.getFuncionventricular():null);
			sitclin.setNyha(String.valueOf(st.getNyha()).length()>0&&st.getNyha()!=-2147483648?st.getNyha():null);
			sitclin.setCardiopatia(String.valueOf(st.getCardiopatia()).length()>0&&st.getCardiopatia()!=-2147483648?st.getCardiopatia():null);
			sitclin.setAevolucion(st.getAevolucion()!=null&&st.getAevolucion().length()>0?st.getAevolucion():null);
			sitclin.setOtra(st.getOtra()!=null&&st.getOtra().length()>0?st.getOtra():null);
			sitclin.setRevasc(st.getRevascularizacion()?(short)1:(short)0);
			sitclin.setInfprevio(st.getInfartoprevio()?(short)1:(short)0);
			sitclin.setAnio(st.getAnio()!=null&&st.getAnio().length()>0?st.getAnio():null);
			sitclin.setLocalizacion(String.valueOf(st.getLocalizacion()).length()>0&&st.getLocalizacion()!=-2147483648?st.getLocalizacion():null);
			sitclin.setArritmias(String.valueOf(st.getArritmias()).length()>0&&st.getArritmias()!=-2147483648?st.getArritmias():null);
			sitclin.setEef(String.valueOf(st.getEef()).length()>0&&st.getEef()!=-2147483648?st.getEef():null);
			sitclin.setHta(st.getHta()?(short) 1:(short) 0);
			sitclin.setDislipemia(st.getDislipemia()?(short) 1:(short) 0);
			sitclin.setDiabetes(st.getDiabetes()?(short) 1:(short) 0);
			sitclin.setTabaquismo(st.getTabaquismo()?(short) 1:(short) 0);
			sitclin.setIngalcoholica(st.getIngalcoholica()?(short) 1:(short) 0);
			sitclin.setAcv(st.getAcv()?(short) 1:(short) 0);
			sitclin.setAit(st.getAit()?(short) 1:(short) 0);
			sitclin.setEpoc(st.getEpoc()?(short) 1:(short) 0);
			sitclin.setSahs(st.getSahs()?(short) 1:(short) 0);
			sitclin.setTiposahs(String.valueOf(st.getTiposahs()).length()>0&&st.getTiposahs()!=-2147483648?st.getTiposahs():null);
			sitclin.setAhi(st.getAhi()!=null&&st.getAhi().length()>0?st.getAhi():null);
			sitclin.setCpap(st.getCpap()?(short) 1:(short) 0);
			sitclin.setInsrenal(st.getInsrenal()?(short) 1:(short) 0);
			sitclin.setTipoinsrenal(String.valueOf(st.getTipoinsrenal()).length()>0&&st.getTipoinsrenal()!=-2147483648?st.getTipoinsrenal():null);
			sitclin.setNeoplasia(st.getNeoplasia()?(short) 1:(short) 0);
			sitclin.setTiponeoplasia(st.getTiponeoplasia()!=null&&st.getTiponeoplasia().length()>0?st.getTiponeoplasia():null);
			sitclin.setAfectiroidea(String.valueOf(st.getAfectiroidea()).length()>0&&st.getAfectiroidea()!=-2147483648?st.getAfectiroidea():null);
			sitclin.setAntfa(st.getFa()?(short) 1:(short) 0);
			sitclin.setMuertesubita(st.getMuertesubita()?(short) 1:(short) 0);
			sitclin.setNeuromediados(String.valueOf(st.getNeuromediados()).length()>0&&st.getNeuromediados()!=-2147483648?st.getNeuromediados():null);
			sitclin.setTrasplantecardiaco(st.getTrasplantecardiaco()?(short) 1:(short) 0);
			sitclin.setSincope(st.getSincope()?(short) 1:(short) 0);
			sitclin.setParadacardiaca(st.getParadacardiaca()?(short) 1:(short) 0);
			sitclin.setFechacreacion(new Date());
			sitclin.setComentarios(st.getComentarios()!=null?st.getComentarios():null);
			sitclin.setExitus(st.getExitus()==1?1:null);
			sitclin.setExitusfecha(st.getFechaexitus()!=null?st.getFechaexitus():null);
			sitclin.setFlutter(st.getFlutter()?(short)1:(short)0);
			sitclin.setAlergias(st.getAlergias()!=null?st.getAlergias():null);
		}catch(Exception e){
			return null;
		}
		return sitclin;
	}
	/**
	 * Metodo para convertir tipo Situacion clinica WS a Situacion Clinica Procedimiento IDEA
	 * @param st
	 * @return objeto situacion clinica completo
	 * 		   null si fallo
	 */
	public static SituacionClinicaProc convierte2SitClinProcIdea(SituacionClinica st){
		SituacionClinicaProc sitclin = new SituacionClinicaProc();
		try{
			sitclin.setRitmo(String.valueOf(st.getRitmo()).length()>0&&st.getRitmo()!=-2147483648?st.getRitmo():0);
			sitclin.setRitmo2(String.valueOf(st.getRitmo2()).length()>0&&st.getRitmo2()!=-2147483648?st.getRitmo2():0);
			sitclin.setConducav(String.valueOf(st.getCav()).length()>0&&st.getCav()!=-2147483648?st.getCav():0);
			sitclin.setConducav2(String.valueOf(st.getCav2()).length()>0&&st.getCav2()!=-2147483648?st.getCav2():0);
			sitclin.setQrs(String.valueOf(st.getQrs()).length()>0&&st.getQrs()!=-2147483648?st.getQrs():0);
			sitclin.setQrs2(String.valueOf(st.getQrs2()).length()>0&&st.getQrs2()!=-2147483648?st.getQrs2():0);
			sitclin.setAnchuraqrs(String.valueOf(st.getAnchuraqrs()).length()>0&&st.getAnchuraqrs()!=-2147483648?String.valueOf(st.getAnchuraqrs()):null);						
			sitclin.setFevi(st.getFevi()!=null&&st.getFevi().length()>0?st.getFevi():null);
			sitclin.setFuncionventricular(String.valueOf(st.getFuncionventricular()).length()>0&&st.getFuncionventricular()!=-2147483648?st.getFuncionventricular():null);
			sitclin.setNyha(String.valueOf(st.getNyha()).length()>0&&st.getNyha()!=-2147483648?st.getNyha():null);
			sitclin.setCardiopatia(String.valueOf(st.getCardiopatia()).length()>0&&st.getCardiopatia()!=-2147483648?st.getCardiopatia():null);
			sitclin.setAevolucion(st.getAevolucion()!=null&&st.getAevolucion().length()>0?st.getAevolucion():null);
			sitclin.setOtra(st.getOtra()!=null&&st.getOtra().length()>0?st.getOtra():null);
			sitclin.setRevasc(st.getRevascularizacion()?(short)1:(short)0);
			sitclin.setInfprevio(st.getInfartoprevio()?(short)1:(short)0);
			sitclin.setAnio(st.getAnio()!=null&&st.getAnio().length()>0?st.getAnio():null);
			sitclin.setLocalizacion(String.valueOf(st.getLocalizacion()).length()>0&&st.getLocalizacion()!=-2147483648?st.getLocalizacion():null);
			sitclin.setArritmias(String.valueOf(st.getArritmias()).length()>0&&st.getArritmias()!=-2147483648?st.getArritmias():null);
			sitclin.setEef(String.valueOf(st.getEef()).length()>0&&st.getEef()!=-2147483648?st.getEef():null);
			sitclin.setHta(st.getHta()?(short) 1:(short) 0);
			sitclin.setDislipemia(st.getDislipemia()?(short) 1:(short) 0);
			sitclin.setDiabetes(st.getDiabetes()?(short) 1:(short) 0);
			sitclin.setTabaquismo(st.getTabaquismo()?(short) 1:(short) 0);
			sitclin.setIngalcoholica(st.getIngalcoholica()?(short) 1:(short) 0);
			sitclin.setAcv(st.getAcv()?(short) 1:(short) 0);
			sitclin.setAit(st.getAit()?(short) 1:(short) 0);
			sitclin.setEpoc(st.getEpoc()?(short) 1:(short) 0);
			sitclin.setSahs(st.getSahs()?(short) 1:(short) 0);
			sitclin.setTiposahs(String.valueOf(st.getTiposahs()).length()>0&&st.getTiposahs()!=-2147483648?st.getTiposahs():null);
			sitclin.setAhi(st.getAhi()!=null&&st.getAhi().length()>0?st.getAhi():null);
			sitclin.setCpap(st.getCpap()?(short) 1:(short) 0);
			sitclin.setInsrenal(st.getInsrenal()?(short) 1:(short) 0);
			sitclin.setTipoinsrenal(String.valueOf(st.getTipoinsrenal()).length()>0&&st.getTipoinsrenal()!=-2147483648?st.getTipoinsrenal():null);
			sitclin.setNeoplasia(st.getNeoplasia()?(short) 1:(short) 0);
			sitclin.setTiponeoplasia(st.getTiponeoplasia()!=null&&st.getTiponeoplasia().length()>0?st.getTiponeoplasia():null);
			sitclin.setAfectiroidea(String.valueOf(st.getAfectiroidea()).length()>0&&st.getAfectiroidea()!=-2147483648?st.getAfectiroidea():null);
			sitclin.setAntfa(st.getFa()?(short) 1:(short) 0);
			sitclin.setMuertesubita(st.getMuertesubita()?(short) 1:(short) 0);
			sitclin.setNeuromediados(String.valueOf(st.getNeuromediados()).length()>0&&st.getNeuromediados()!=-2147483648?st.getNeuromediados():null);
			sitclin.setTrasplantecardiaco(st.getTrasplantecardiaco()?(short) 1:(short) 0);
			sitclin.setSincope(st.getSincope()?(short) 1:(short) 0);
			sitclin.setParadacardiaca(st.getParadacardiaca()?(short) 1:(short) 0);
			sitclin.setComentarios(st.getComentarios()!=null?st.getComentarios():null);
		}catch(Exception e){
			return null;
		}
		return sitclin;
	}
	public static ImpGenerador convierte2GeneradorIdea(Generador gen){
		ImpGenerador impgen = new ImpGenerador();
		try{
			// Si se desconoce el modelo de generador, se pone desconocido
			impgen.setIdgenerador(gen.getModelo()!=null&&gen.getModelo().length()>0?Integer.valueOf(gen.getModelo()):10);
			impgen.setNumserie(gen.getNserie()!=null&&gen.getNserie().length()>0?gen.getNserie():"");
			impgen.setLocalizacion(String.valueOf(gen.getLocalizacion()).length()>0&&gen.getLocalizacion()!=-2147483648?gen.getLocalizacion():null);
			impgen.setMotivorecambio(String.valueOf(gen.getMrecambio()).length()>0&&gen.getMrecambio()!=-2147483648?gen.getMrecambio():null);
			impgen.setMotivorecolocacion(String.valueOf(gen.getMrecolocacion()).length()>0&&gen.getMrecolocacion()!=-2147483648?gen.getMrecolocacion():null);
			impgen.setMotivoexplante(String.valueOf(gen.getMexplante()).length()>0&&gen.getMexplante()!=-2147483648?gen.getMexplante():null);
		}catch(Exception e){
			return null;
		}
		return impgen;
	}
	public static ImpImplanteElectrodos convierte2ElectrodoIdea(Electrodo e){
		ImpImplanteElectrodos impelec = new ImpImplanteElectrodos();
		try{
			// Si se desconoce el modelo de electrodo, se pone desconocido
			impelec.setIdelectrodo(e.getModelo()!=null&&e.getModelo().length()>0?Integer.parseInt(e.getModelo()):193);
			impelec.setNumserie(e.getNserie()!=null&&e.getNserie().length()>0?e.getNserie():null);
			impelec.setMotivorecambio(String.valueOf(e.getMrecambio()).length()>0&&e.getMrecambio()!=-2147483648?e.getMrecambio():null);
			impelec.setMotivorecolocacion(String.valueOf(e.getMrecolocacion()).length()>0&&e.getMrecolocacion()!=-2147483648?e.getMrecolocacion():null);
			impelec.setMotivoexaband(String.valueOf(e.getMexplante()).length()>0&&e.getMexplante()!=-2147483648?e.getMexplante():null);
			impelec.setOndarpImp(e.getOndarpimp()!=null&&e.getOndarpimp().length()>0?e.getOndarpimp():null);
			impelec.setUmbralvImp(e.getUmbralvimp()!=null&&e.getUmbralvimp().length()>0?e.getUmbralvimp():null);
			impelec.setUmbralmsImp(e.getUmbralmsimp()!=null&&e.getUmbralmsimp().length()>0?e.getUmbralmsimp():null);
			impelec.setSlewrate(e.getSlewrate()!=null&&e.getSlewrate().length()>0?e.getSlewrate():null);
			impelec.setImpohmImp(e.getImpohmimp()!=null&&e.getImpohmimp().length()>0?e.getImpohmimp():null);
			impelec.setImpmsImp(e.getImpmsimp()!=null&&e.getImpmsimp().length()>0?e.getImpmsimp():null);
			impelec.setImpvImp(e.getImpvimp()!=null&&e.getImpvimp().length()>0?e.getImpvimp():null);
			impelec.setEstimfren(e.getEstimfrenica()!=null&&e.getEstimfrenica().length()>0?e.getEstimfrenica():null);
			impelec.setOndarpEv(e.getOndarpev()!=null&&e.getOndarpev().length()>0?e.getOndarpev():null);
			impelec.setUmbralvEv(e.getUmbralvev()!=null&&e.getUmbralvev().length()>0?e.getUmbralvev():null);
			impelec.setUmbralmsEv(e.getUmbralmsev()!=null&&e.getUmbralmsev().length()>0?e.getUmbralmsev():null);
			impelec.setImpohmEv(e.getImpohmev()!=null&&e.getImpohmev().length()>0?e.getImpohmev():null);
			impelec.setImpmsEv(e.getImpmsev()!=null&&e.getImpmsev().length()>0?e.getImpmsev():null);
			impelec.setImpvEv(e.getImpvev()!=null&&e.getImpvev().length()>0?e.getImpvev():null);
			impelec.setDurimpulso(e.getDurimpulso()!=null&&e.getDurimpulso().length()>0?e.getDurimpulso():null);
			impelec.setVoltaje(e.getVoltaje()!=null&&e.getVoltaje().length()>0?e.getVoltaje():null);
			impelec.setSensibilidad(e.getSensibilidad()!=null&&e.getSensibilidad().length()>0?e.getSensibilidad():null);
			impelec.setPoldeteccion(e.getPoldeteccion()!=null&&e.getPoldeteccion().length()>0?e.getPoldeteccion():null);
			impelec.setPolestimulacion(e.getPolestimulacion()!=null&&e.getPolestimulacion().length()>0?e.getPolestimulacion():null);
			impelec.setCapturaauto(String.valueOf(e.getCapturaauto()).length()>0?(short)e.getCapturaauto():null);
			impelec.setVia(String.valueOf(e.getVia()).length()>0&&e.getVia()!=-2147483648?e.getVia():null);
			impelec.setLateralidad(String.valueOf(e.getLateralidad()).length()>0&&e.getLateralidad()!=-2147483648?e.getLateralidad():null);
			impelec.setCamara(String.valueOf(e.getCamara()).length()>0&&e.getCamara()!=-2147483648?e.getCamara():null);
			impelec.setZonacamara(String.valueOf(e.getZonacamara()).length()>0&&e.getZonacamara()!=-2147483648?e.getZonacamara():null);
			impelec.setPorcion(String.valueOf(e.getPorcion()).length()>0&&e.getPorcion()!=-2147483648?e.getPorcion():null);
			impelec.setEstado(String.valueOf(e.getEstado()).length()>0?e.getEstado():null);
			impelec.setCaracter(String.valueOf(e.getCaracter()).length()>0?e.getCaracter():null);	
			impelec.setFechaimplante(e.getFechaimplante()!=null?e.getFechaimplante():null);
			if(e.getVdd() && e.getCamara()==948)
				impelec.setTipoelectrodo("VDD");
		}catch(Exception ex){
			return null;
		}
		return impelec;
	}
	public static ImpHojaImplante convierte2HojaImplanteIdea(HojaImplante hi){
		ImpHojaImplante himp = new ImpHojaImplante();
		try{
			himp.setImplantador(String.valueOf(hi.getImplantador()).length()>0&&hi.getImplantador()!=-2147483648?hi.getImplantador():null);
			himp.setTestind(hi.getTestinduccion()?(short)1:(short)0);
			himp.setEnergiatest(hi.getTestinduccion_energia()!=null&&hi.getTestinduccion_energia().length()>0?hi.getTestinduccion_energia():null);
			himp.setImptest(hi.getTestinduccion_impedancia()!=null&&hi.getTestinduccion_impedancia().length()>0?hi.getTestinduccion_impedancia():null);
			himp.setNumchoqtest(hi.getTestinduccion_numchoques()!=null&&hi.getTestinduccion_numchoques().length()>0?hi.getTestinduccion_numchoques():null);
			himp.setPrioridad(String.valueOf(hi.getPrioridad()).length()>0&&hi.getPrioridad()!=-2147483648?hi.getPrioridad():null);
			himp.setTescopia(hi.getTescopia()!=null&&hi.getTescopia().length()>0?hi.getTescopia():null);
			himp.setHllegada(hi.getHllegada()!=null&&hi.getHllegada().length()>0?hi.getHllegada():null);
			himp.setHinicio(hi.getHinicio()!=null&&hi.getHinicio().length()>0?hi.getHinicio():null);
			himp.setHfin(hi.getHfin()!=null&&hi.getHfin().length()>0?hi.getHfin():null);
			himp.setHsalida(hi.getHsalida()!=null&&hi.getHsalida().length()>0?hi.getHsalida():null);
			himp.setLugarimp(String.valueOf(hi.getLugarimplante()).length()>0&&hi.getLugarimplante()!=-2147483648?hi.getLugarimplante():null);
			himp.setTanestesia(String.valueOf(hi.getTanestesia()).length()>0&&hi.getTanestesia()!=-2147483648?hi.getTanestesia():null);
			himp.setTindicacion(String.valueOf(hi.getTipoindicacion()).length()>0&&hi.getTipoindicacion()!=-2147483648?hi.getTipoindicacion():null);	
			himp.setComentarios(hi.getComentarios());
		}catch(Exception e){
			return null;
		}
		return himp;
	}
	public static ImpEvolucion convierte2EvolucionIdea(Evolucion ev){
		ImpEvolucion hev = new ImpEvolucion();
		try{
			hev.setModogen(String.valueOf(ev.getModogen()).length()>0&&ev.getModogen()!=-2147483648?ev.getModogen():null);
			hev.setFbasica(ev.getFbasica()!=null&&ev.getFbasica().length()>0?ev.getFbasica():null);
			hev.setSegremoto(ev.getSegremoto()?(short)1:(short)0);
			hev.setMev(ev.getMev()?(short)1:(short)0);
			hev.setMpdependiente(ev.getMpdependiente()?(short)1:(short)0);
			hev.setIavdetec(ev.getIavdetectado()!=null&&ev.getIavdetectado().length()>0?ev.getIavdetectado():null);
			hev.setIavestim(ev.getIavestimulado()!=null&&ev.getIavestimulado().length()>0?ev.getIavestimulado():null);
			hev.setIavmax(ev.getIavmax()!=null&&ev.getIavmax().length()>0?ev.getIavmax():null);
			hev.setIavmin(ev.getIavmin()!=null&&ev.getIavmin().length()>0?ev.getIavmin():null);
			hev.setSactivacion(String.valueOf(ev.getSecactivacion()).length()>0&&ev.getSecactivacion()!=-2147483648?ev.getSecactivacion():null);
			hev.setUmbralEstimfren(ev.getEstimfrenica()!=null&&ev.getEstimfrenica().length()>0?ev.getEstimfrenica():null);
			hev.setAtp(ev.getAtp()?(short)1:(short)0);
			hev.setNumteratp(ev.getNumatp()!=null&&ev.getNumatp().length()>0?ev.getNumatp():null);
			hev.setTerefecatp(ev.getTefectatp()?(short)1:(short)0);
			hev.setChoques(ev.getChoques()?(short)1:(short)0);
			hev.setNumchoque(ev.getNumchoques()!=null&&ev.getNumchoques().length()>0?ev.getNumchoques():null);
			hev.setTereefecchoq(ev.getTefectchoques()?(short)1:(short)0);
			hev.setEnergiachoque(ev.getUltchoque_energia()!=null&&ev.getUltchoque_energia().length()>0?ev.getUltchoque_energia():null);
			hev.setImpchoque(ev.getUltchoque_imp()!=null&&ev.getUltchoque_imp().length()>0?ev.getUltchoque_imp():null);
			hev.setTcargachoque(ev.getUltchoque_tcarga()!=null&&ev.getUltchoque_tcarga().length()>0?ev.getUltchoque_tcarga():null);
			hev.setTodasefec(String.valueOf(ev.getTodasefectivas()).length()>0&&ev.getTodasefectivas()!=-2147483648?ev.getTodasefectivas():null);
			hev.setFmax(ev.getFmax()!=null&&ev.getFmax().length()>0?ev.getFmax():null);
			hev.setFmin(ev.getFmin()!=null&&ev.getFmin().length()>0?ev.getFmin():null);
			hev.setValorHisteresis(ev.getValor_histeresis()!=null&&ev.getValor_histeresis().length()>0?ev.getValor_histeresis():null);
			hev.setAlgprevfa(ev.getAlgprevfa()?(short)1:(short)0);
			hev.setAmpPostch(ev.getAmp_postchoque()!=null&&ev.getAmp_postchoque().length()>0?ev.getAmp_postchoque():null);
			hev.setDurpulsoPostch(ev.getDurpulso_postchoque()!=null&&ev.getDurpulso_postchoque().length()>0?ev.getDurpulso_postchoque():null);
			hev.setFrecPostch(ev.getFrec_postchoque()!=null&&ev.getFrec_postchoque().length()>0?ev.getFrec_postchoque():null);
			hev.setDurPostch(ev.getDur_postchoque()!=null&&ev.getDur_postchoque().length()>0?ev.getDur_postchoque():null);
			hev.setConfch(String.valueOf(ev.getConfchoque()).length()>0&&ev.getConfchoque()!=-2147483648?ev.getConfchoque():null);
			hev.setFechaalta(ev.getFechaalta()!=null?ev.getFechaalta():null);
			hev.setMedicoalta(ev.getMedicoalta()!=null&&ev.getMedicoalta().length()>0?ev.getMedicoalta():null);
			hev.setMotivoalta(ev.getMotivoalta()!=-2147483648?ev.getMotivoalta():0);
			hev.setTipoalta(ev.getTipoalta()!=-2147483648?ev.getTipoalta():0);
			hev.setCompatiblemri(String.valueOf(ev.getComp_mri()).length()>0&&ev.getComp_mri()!=-2147483648?ev.getComp_mri():null);
			hev.setNumepisodios(ev.getNumepisodios_total()!=null&&ev.getNumepisodios_total().length()>0?ev.getNumepisodios_total():null);
			hev.setNumepitsv(ev.getNumepisodios_tsv()!=null&&ev.getNumepisodios_tsv().length()>0?ev.getNumepisodios_tsv():null);
			hev.setNumepitv(ev.getNumepisodios_tv()!=null&&ev.getNumepisodios_tv().length()>0?ev.getNumepisodios_tv():null);
			hev.setNumepifv(ev.getNumepisodios_fv()!=null&&ev.getNumepisodios_fv().length()>0?ev.getNumepisodios_fv():null);
			hev.setNumepinosost(ev.getNumepisodios_nosost()!=null&&ev.getNumepisodios_nosost().length()>0?ev.getNumepisodios_nosost():null);
			hev.setNumepiotros(ev.getNumepisodios_noesp()!=null&&ev.getNumepisodios_noesp().length()>0?ev.getNumepisodios_noesp():null);
			hev.setComentarios(ev.getComentarios());	
		}catch(Exception e){
			return null;
		}
		return hev;
	}
	public static ImpZona convierte2ZonaIdea(Zona z){
		ImpZona zona = new ImpZona();
		try{
			zona.setTipo(z.getTipozona()!=null&&z.getTipozona().length()>0?z.getTipozona():null);
			zona.setFcMs(z.getFcms()!=null&&z.getFcms().length()>0?z.getFcms():null);
			zona.setFcPpm(z.getFcppm()!=null&&z.getFcppm().length()>0?z.getFcppm():null);
		}catch(Exception e){
			return null;
		}
		return zona;
	}
	public static ImpAtp convierte2AtpIdea(Atp a){
		ImpAtp atp = new ImpAtp();
		try{
			atp.setTipo(a.getTipo()!=null&&a.getTipo().length()>0?a.getTipo():null);
			atp.setNumsec(a.getNumsec()!=null&&a.getNumsec().length()>0?a.getNumsec():null);
			atp.setCiclosec(a.getCiclosec()!=null&&a.getCiclosec().length()>0?a.getCiclosec():null);
			atp.setAcoplamiento(a.getAcoplamiento()!=null&&a.getAcoplamiento().length()>0?a.getAcoplamiento():null);
			atp.setDecremento(a.getDecremento()!=null&&a.getDecremento().length()>0?a.getDecremento():null);			
		}catch(Exception e){
			return null;
		}
		return atp;
	}
	public static ImpChoques convierte2ChoqueIdea(Choques c){
		ImpChoques ch = new ImpChoques();
		try{
			ch.setTipo(c.getTipo()!=null&&c.getTipo().length()>0?c.getTipo():null);
			ch.setNumch(c.getNum()!=null&&c.getNum().length()>0?c.getNum():null);
			ch.setEnergia(c.getEnergia()!=null&&c.getEnergia().length()>0?c.getEnergia():null);
		}catch(Exception e){
			return null;
		}
		return ch;
	}
	public static ArrEstudio convierte2EFIdea(EstudioEF est){
		ArrEstudio estudio = new ArrEstudio();
		try{
			estudio.setMotivo(est.getMotivo()!=null&&est.getMotivo().length()>0?est.getMotivo():null);
			estudio.setHallazgos(est.getHallazgos()!=null&&est.getHallazgos().length()>0?est.getHallazgos():null);
			estudio.setDiagnostico(String.valueOf(est.getDiagnostico()).length()>0&&est.getDiagnostico()!=-2147483648?est.getDiagnostico():null);
			estudio.setAnestesista(String.valueOf(est.getAnestesista()).length()>0&&est.getAnestesista()!=-2147483648?est.getAnestesista():null);
			estudio.setInteres(String.valueOf(est.getInteres()).length()>0&&est.getInteres()!=-2147483648?est.getInteres():null);
			estudio.setNavegador(String.valueOf(est.getNavegador()).length()>0&&est.getNavegador()!=-2147483648?est.getNavegador():null);
			estudio.setEscopia(String.valueOf(est.getEscopia()).length()>0&&est.getEscopia()!=-2147483648?est.getEscopia():null);
			estudio.setEcografia(String.valueOf(est.getEcografia()).length()>0&&est.getEcografia()!=-2147483648?est.getEcografia():null);
			estudio.setTescopia(est.getTescopia()!=null&&est.getTescopia().length()>0?est.getTescopia():null);
			estudio.setTipoProcedimiento(String.valueOf(est.getTipo()).length()>0&&est.getTipo()!=-2147483648?est.getTipo():null);
			estudio.setHllegada(est.getHllegada()!=null&&est.getHllegada().length()>0?est.getHllegada():null);
			estudio.setHpuncion(est.getHpuncion()!=null&&est.getHpuncion().length()>0?est.getHpuncion():null);
			estudio.setHablacion(est.getHablacion()!=null&&est.getHablacion().length()>0?est.getHablacion():null);
			estudio.setHcateter(est.getHretirada()!=null&&est.getHretirada().length()>0?est.getHretirada():null);
			estudio.setHsalida(est.getHsalida()!=null&&est.getHsalida().length()>0?est.getHsalida():null);
			estudio.setEefanterior(est.getEefanterior()!=null&&est.getEefanterior().length()>0?est.getEefanterior():null);	
			estudio.setComent_vias(est.getComentariosvia()!=null?est.getComentariosvia():null);
			estudio.setComent_periodos(est.getComentariospref()!=null?est.getComentariospref():null);
			estudio.setNestudio(est.getNestudio()!=null&&est.getNestudio().length()>0?est.getNestudio():null);
			estudio.setTipoDiag1(String.valueOf(est.getTipodiag1()).length()>0&&est.getTipodiag1()!=-2147483648?est.getTipodiag1():null);
			estudio.setTipoDiag2(String.valueOf(est.getTipodiag2()).length()>0&&est.getTipodiag2()!=-2147483648?est.getTipodiag2():null);
		}catch(Exception e){
			return null;
		}
		return estudio;
	}
	public static ArrEstudioEcg convierte2EFECGIdea(ECGEF e){
		ArrEstudioEcg ecg = new ArrEstudioEcg();
		try{
			ecg.setIdritmo(String.valueOf(e.getRitmo()).length()>0&&e.getRitmo()!=-2147483648?e.getRitmo():null);
			ecg.setIdconduccion(String.valueOf(e.getConduccion()).length()>0&&e.getConduccion()!=-2147483648?e.getConduccion():null);
			ecg.setIdconduccionno(String.valueOf(e.getConduccionno()).length()>0&&e.getConduccionno()!=-2147483648?e.getConduccionno():null);
			ecg.setIdqrs(String.valueOf(e.getQrs_cond()).length()>0&&e.getQrs_cond()!=-2147483648?e.getQrs_cond():null);
			ecg.setIdqrsno(String.valueOf(e.getQrsno()).length()>0&&e.getQrsno()!=-2147483648?e.getQrsno():null);
			//Morfologia
			ecg.setRr(e.getRr()!=null&&e.getRr().length()>0?e.getRr():null);
			ecg.setPr(e.getPr()!=null&&e.getPr().length()>0?e.getPr():null);
			ecg.setQrs(e.getQrs()!=null&&e.getQrs().length()>0?e.getQrs():null);
			ecg.setQt(e.getQt()!=null&&e.getQt().length()>0?e.getQt():null);
			ecg.setComentarios(e.getComentarios()!=null?e.getComentarios():null);
		}catch(Exception ex){
			return null;
		}
		return ecg;
	}
	public static ArrEstudioSinusal convierte2EFFSinusal(FuncionSinusalEF fsinusal){
		ArrEstudioSinusal fsin = new ArrEstudioSinusal();
		try{
			fsin.setCiclo(fsinusal.getCiclo()!=null&&fsinusal.getCiclo().length()>0?fsinusal.getCiclo():null);
			fsin.setTrns(fsinusal.getTrns()!=null&&fsinusal.getTrns().length()>0?fsinusal.getTrns():null);
			fsin.setTrnsc(fsinusal.getTrnsc()!=null&&fsinusal.getTrnsc().length()>0?fsinusal.getTrnsc():null);
			fsin.setTrt(fsinusal.getTrt()!=null&&fsinusal.getTrt().length()>0?fsinusal.getTrt():null);
			fsin.setTcsa(fsinusal.getTcsa()!=null&&fsinusal.getTcsa().length()>0?fsinusal.getTcsa():null);
			fsin.setCiclo(fsinusal.getCiclo()!=null&&fsinusal.getCiclo().length()>0?fsinusal.getCiclo():null);
			fsin.setHiper(String.valueOf(fsinusal.getHiper()).length()>0&&fsinusal.getHiper()!=-2147483648?fsinusal.getHiper():null);
			fsin.setFrecatro(fsinusal.getFrecatro()!=null&&fsinusal.getFrecatro().length()>0?fsinusal.getFrecatro():null);
			fsin.setFrecint(fsinusal.getFrecint()!=null&&fsinusal.getFrecint().length()>0?fsinusal.getFrecint():null);
			fsin.setPausa(fsinusal.getPausa()!=null&&fsinusal.getPausa().length()>0?fsinusal.getPausa():null);
			fsin.setComentarios(fsinusal.getComentarios()!=null?fsinusal.getComentarios():null);
		}catch(Exception e){
			return null;
		}
		return fsin;
	}
	public static ArrSinusalPf convierte2EFFSinusalPf(FuncionSinusalPfEF pf){
		ArrSinusalPf prueba = new ArrSinusalPf();
		try{
			prueba.setPrueba(String.valueOf(pf.getPrueba()).length()>0&&pf.getPrueba()!=-2147483648?pf.getPrueba():null);
			prueba.setResultado(pf.getResultado()!=null&&pf.getResultado().length()>0?pf.getResultado():null);			
		}catch(Exception e){
			return null;
		}
		return prueba;
	}
	public static ArrEstudioTaqui convierte2EFTaq(TaquicardiaEF tq){
		ArrEstudioTaqui taq = new ArrEstudioTaqui();
		try{
			taq.setNumtaqui(String.valueOf(tq.getNumtaqui()).length()>0&&tq.getNumtaqui()!=-2147483648?tq.getNumtaqui():null);
			taq.setInduccion(String.valueOf(tq.getInduccion()).length()>0&&tq.getInduccion()!=-2147483648?tq.getInduccion():null);
			taq.setTaquiindu(String.valueOf(tq.getTaquiindu()).length()>0&&tq.getTaquiindu()!=-2147483648?tq.getTaquiindu():null);
			taq.setNumnoclin(tq.getNumnoclin()!=null&&tq.getNumnoclin().length()>0?tq.getNumnoclin():null);
			taq.setComportamiento(tq.getComportamiento()!=null&&String.valueOf(tq.getComportamiento()).length()>0?Integer.valueOf(tq.getComportamiento()):null);
			taq.setIdn1(String.valueOf(tq.getIdn1()).length()>0&&tq.getIdn1()!=-2147483648?tq.getIdn1():0);
			taq.setIdn2(String.valueOf(tq.getIdn2()).length()>0&&tq.getIdn2()!=-2147483648?tq.getIdn2():0);
			taq.setIdn3(String.valueOf(tq.getIdn3()).length()>0&&tq.getIdn3()!=-2147483648?tq.getIdn3():0);
			taq.setPuntoest(String.valueOf(tq.getPuntoestimulacion()).length()>0&&tq.getPuntoestimulacion()!=-2147483648?tq.getPuntoestimulacion():0);
			taq.setModoind(String.valueOf(tq.getModoinduccion()).length()>0&&tq.getModoinduccion()!=-2147483648?tq.getModoinduccion():0);
			taq.setProtocolo(String.valueOf(tq.getProtocolo()).length()>0&&tq.getProtocolo()!=-2147483648?tq.getProtocolo():null);
			taq.setLctren(tq.getLctren()!=null&&tq.getLctren().length()>0?tq.getLctren():null);
			taq.setNextra(tq.getNextra()!=null&&tq.getNextra().length()>0?tq.getNextra():null);
			taq.setAavv(String.valueOf(tq.getAavv()).length()>0&&tq.getAavv()!=-2147483648?tq.getAavv():null);
			taq.setFarmacos(tq.getFarmacos()!=null&&tq.getFarmacos().length()>0?tq.getFarmacos():null);
			taq.setValorind(tq.getValorind()!=null&&tq.getValorind().length()>0?tq.getValorind():null);
			taq.setPuntoest2(String.valueOf(tq.getPuntoest2()).length()>0&&tq.getPuntoest2()!=-2147483648?tq.getPuntoest2():0);
			taq.setModoind2(String.valueOf(tq.getModoind2()).length()>0&&tq.getModoind2()!=-2147483648?tq.getModoind2():0);
			taq.setValorind2(tq.getValorind2()!=null&&tq.getValorind2().length()>0?tq.getValorind2():null);
			taq.setLongciclo(tq.getLongciclo()!=null&&tq.getLongciclo().length()>0?tq.getLongciclo():null);
			taq.setMorfologia(String.valueOf(tq.getMorfologia()).length()>0&&tq.getMorfologia()!=-2147483648?tq.getMorfologia():null);	
			taq.setComentarios(tq.getComentarios()!=null?tq.getComentarios():null);
		}catch(Exception e){
			return null;
		}
		return taq;
	}
	public static ArrEstudioConduccav convierte2EFCavIdea(ConduccionAVEF c){
		ArrEstudioConduccav cav = new ArrEstudioConduccav();
		try{
			cav.setAh(c.getAh()!=null&&c.getAh().length()>0?c.getAh():null);
			cav.setHv(c.getHv()!=null&&c.getHv().length()>0?c.getHv():null);
			cav.setFisiologia(String.valueOf(c.getFisiologia()).length()>0&&c.getFisiologia()!=-2147483648?c.getFisiologia():null);
			cav.setHv2(String.valueOf(c.getHv2()).length()>0&&c.getHv2()!=-2147483648?c.getHv2():null);	
			cav.setComentarios(c.getComentarios()!=null?c.getComentarios():null);
		}catch(Exception e){
			return null;
		}
		return cav;
	}
	public static ArrConduccEc convierte2EFEstcontinuaIdea(EstimulacionContinuaEF est){
		ArrConduccEc ec = new ArrConduccEc();
		try{
			ec.setConduc(String.valueOf(est.getConduccion()).length()>0&&est.getConduccion()!=-2147483648?est.getConduccion():null);
			ec.setFarmaco(est.getFarmaco()!=null&&est.getFarmaco().length()>0?est.getFarmaco():null);
			ec.setBloqueo(String.valueOf(est.getBloqueo()).length()>0&&est.getBloqueo()!=-2147483648?est.getBloqueo():null);
			ec.setNviel(String.valueOf(est.getNviel()).length()>0&&est.getNviel()!=-2147483648?Integer.valueOf(est.getNviel()):null);
			ec.setMs(est.getMs()!=null&&est.getMs().length()>0?est.getMs():null);			
		}catch(Exception e){
			return null;
		}
		return ec;
	}
	public static ArrConducPf convierte2EFFSinusalPfIdea(PruebasFarmaEF pf){
		ArrConducPf prueba = new ArrConducPf();
		try{
			prueba.setPrueba(String.valueOf(pf.getPrueba()).length()>0&&pf.getPrueba()!=-2147483648?pf.getPrueba():null);
			prueba.setResultado(pf.getResultado()!=null&&pf.getResultado().length()>0?pf.getResultado():null);			
		}catch(Exception e){
			return null;
		}
		return prueba;
	}
	public static ArrEstudioVias convierte2EFViasIdea(ViaAccesoriaEF v){
		ArrEstudioVias via = new ArrEstudioVias();
		try{
			via.setIdvia(String.valueOf(v.getIdvia()).length()>0&&v.getIdvia()!=-2147483648?v.getIdvia():null);
			via.setIdsentido(String.valueOf(v.getSentido()).length()>0&&v.getSentido()!=-2147483648?v.getSentido():null);
			via.setIdtipo(String.valueOf(v.getTipo()).length()>0&&v.getTipo()!=-2147483648?v.getTipo():null);
			via.setCa(v.getCa()!=null&&v.getCa().length()>0?v.getCa():null);
			via.setCr(v.getCr()!=null&&v.getCr().length()>0?v.getCr():null);
			via.setRr(v.getRr()!=null&&v.getRr().length()>0?v.getRr():null);
			via.setIdloc(String.valueOf(v.getIdloc()).length()>0&&v.getIdloc()!=-2147483648?v.getIdloc():null);
			via.setLocs(v.getLocs()!=null&&v.getLocs().length()>0?v.getLocs():null);
		}catch(Exception e){
			return null;
		}
		return via;
	}
	public static ArrEstudioPeriodo convierte2EFPeriodoIdea(PeriodoRefractarioEF p){
		ArrEstudioPeriodo periodo = new ArrEstudioPeriodo();
		try{
			periodo.setIdtipo(String.valueOf(p.getTipo()).length()>0&&p.getTipo()!=-2147483648?p.getTipo():null);
			periodo.setIdtejido(p.getTejido()!=null&&p.getTejido().length()>0?p.getTejido():null);
			periodo.setIds1(p.getS1()!=null&&p.getS1().length()>0?p.getS1():null);
			periodo.setRef(p.getRef()!=null&&p.getRef().length()>0?p.getRef():null);
			periodo.setIdfarmaco(String.valueOf(p.getFarmaco()).length()>0&&p.getFarmaco()!=-2147483648?p.getFarmaco():null);			
		}catch(Exception e){
			return null;
		}
		return periodo;	
	}
	public static ArrEstudioComplicaciones convierte2EFComplicacionesIdea(ComplicacionesEF c){
		ArrEstudioComplicaciones comp = new ArrEstudioComplicaciones();
		try{
			comp.setEdiagnostico(String.valueOf(c.getEdiagnostico()).length()>0&&c.getEdiagnostico()!=-2147483648?c.getEdiagnostico():0);
			comp.setProcedimiento(String.valueOf(c.getProcedimiento()).length()>0&&c.getProcedimiento()!=-2147483648?c.getProcedimiento():0);
			comp.setIdprocedimiento(String.valueOf(c.getIdprocedimiento()).length()>0&&c.getIdprocedimiento()!=-2147483648?c.getIdprocedimiento():0);
			comp.setIdprocedimienton2(String.valueOf(c.getIdprocedimienton2()).length()>0&&c.getIdprocedimienton2()!=-2147483648?c.getIdprocedimienton2():0);
			comp.setIdprocedimienton3(String.valueOf(c.getIdprocedimienton3()).length()>0&&c.getIdprocedimienton3()!=-2147483648?c.getIdprocedimienton3():0);
			comp.setIdprocedimienton4(String.valueOf(c.getIdprocedimienton4()).length()>0&&c.getIdprocedimienton4()!=-2147483648?c.getIdprocedimienton4():0);
			comp.setComentarios(c.getComentarios()!=null&&c.getComentarios().length()>0?c.getComentarios():null);			
		}catch(Exception e){
			return null;
		}
		return comp;
	}
	public static ArrEstudioIntento convierte2EFIntentoIdea(IntentoAblacionEF i){
		ArrEstudioIntento intento = new ArrEstudioIntento();
		try{
			intento.setIdnivel1(String.valueOf(i.getIdnivel1()).length()>0&&i.getIdnivel1()!=-2147483648?i.getIdnivel1():0);
			intento.setIdnivel2(String.valueOf(i.getIdnivel2()).length()>0&&i.getIdnivel2()!=-2147483648?i.getIdnivel2():0);
			intento.setIdnivel3(String.valueOf(i.getIdnivel3()).length()>0&&i.getIdnivel3()!=-2147483648?i.getIdnivel3():0);
			intento.setOtros(i.getOtros()!=null&&i.getOtros().length()>0?i.getOtros():null);			
		}catch(Exception e){
			return null;
		}
		return intento;
	}
	public static ArrEstudioAblacion convierte2EFAblacionIdea(AblacionEF a){
		ArrEstudioAblacion ab = new ArrEstudioAblacion();
		try{
			ab.setSustrato(String.valueOf(a.getSustrato()).length()>0&&a.getSustrato()!=-2147483648?a.getSustrato():null);
			ab.setIdabordaje(String.valueOf(a.getAbordaje()).length()>0&&a.getAbordaje()!=-2147483648?a.getAbordaje():null);
			ab.setIdenergia(String.valueOf(a.getEnergia()).length()>0&&a.getEnergia()!=-2147483648?a.getEnergia():null);
			ab.setTradio(a.getTradio()!=null&&a.getTradio().length()>0?a.getTradio():null);
			ab.setTcrio(a.getTcrio()!=null&&a.getTcrio().length()>0?a.getTcrio():null);
			ab.setIdnodo(String.valueOf(a.getIdnodo()).length()>0&&a.getIdnodo()!=-2147483648?a.getIdnodo():null);
			ab.setIddcha(String.valueOf(a.getIddcha()).length()>0&&a.getIddcha()!=-2147483648?a.getIddcha():null);
			ab.setIdparasep(String.valueOf(a.getIdparasep()).length()>0&&a.getIdparasep()!=-2147483648?String.valueOf(a.getIdparasep()):null);
			ab.setIdizda(String.valueOf(a.getIdizda()).length()>0&&a.getIdizda()!=-2147483648?a.getIdizda():null);
			ab.setIdepi(String.valueOf(a.getIdepi()).length()>0&&a.getIdepi()!=-2147483648?a.getIdepi():null);
			ab.setIdfluter(String.valueOf(a.getIdfluter()).length()>0&&a.getIdfluter()!=-2147483648?a.getIdfluter():null);
			ab.setIdfibri(String.valueOf(a.getIdfibri()).length()>0&&a.getIdfibri()!=-2147483648?a.getIdfibri():null);
			ab.setIdsegmen(String.valueOf(a.getIdsegmen()).length()>0&&a.getIdsegmen()!=-2147483648?a.getIdsegmen():null);
			ab.setIdtv(String.valueOf(a.getIdtv()).length()>0&&a.getIdtv()!=-2147483648?a.getIdtv():null);
			ab.setIdiam(String.valueOf(a.getIdiam()).length()>0&&a.getIdiam()!=-2147483648?a.getIdiam():null);
			ab.setIdconvenc(String.valueOf(a.getIdconvenc()).length()>0&&a.getIdconvenc()!=-2147483648?a.getIdconvenc():null);
			ab.setIdnoiam(String.valueOf(a.getIdnoiam()).length()>0&&a.getIdnoiam()!=-2147483648?a.getIdnoiam():null);
			ab.setIddavd(String.valueOf(a.getIddavd()).length()>0&&a.getIddavd()!=-2147483648?a.getIddavd():null);
			ab.setOtro(a.getOtro()!=null&&a.getOtro().length()>0?a.getOtro():null);
			ab.setOtratv(a.getOtratv()!=null&&a.getOtratv().length()>0?a.getOtratv():null);
			ab.setCateter(a.getCateter()!=null&&a.getCateter().length()>0?a.getCateter():null);	
			ab.setComentarios(a.getComentarios()!=null?a.getComentarios():null);
		}catch(Exception e){
			System.out.println(e.getStackTrace());
			return null;
		}
		return ab;
	}
	public static ArrEstudioNproc convierte2EFNProcIdea(NProcEF np){
		ArrEstudioNproc nproc = new ArrEstudioNproc();
		try{
			nproc.setIdproc(String.valueOf(np.getIdproc()).length()>0&&np.getIdproc()!=-2147483648?np.getIdproc():null);
			nproc.setNumproc(np.getNumproc()!=null&&np.getNumproc().length()>0?np.getNumproc():null);
			nproc.setIdmotivo(String.valueOf(np.getIdmotivo()).length()>0&&np.getIdmotivo()!=-2147483648?np.getIdmotivo():null);
			nproc.setIdeef(String.valueOf(np.getEef()).length()>0&&np.getEef()!=-2147483648?np.getEef():null);
		}catch(Exception e){
			return null;
		}
		return nproc;
	}
	public static ArrAblacionComplica convierte2EFAblCompliacionIdea(ComplicacionAblacionEF c){
		ArrAblacionComplica ab_comp = new ArrAblacionComplica();
		try{
			ab_comp.setIdprocedimiento(String.valueOf(c.getIdprocedimiento()).length()>0&&c.getIdprocedimiento()!=-2147483648?c.getIdprocedimiento():null);
			ab_comp.setIdlugar(String.valueOf(c.getIdlugar()).length()>0&&c.getIdlugar()!=-2147483648?c.getIdlugar():null);
			ab_comp.setIdcomplicacion(String.valueOf(c.getIdtipo()).length()>0&&c.getIdtipo()!=-2147483648?c.getIdtipo():null);
			ab_comp.setIdmuerte(String.valueOf(c.getIdmuerte()).length()>0&&c.getIdmuerte()!=-2147483648?c.getIdmuerte():null);
			ab_comp.setOtros(c.getOtra()!=null&&c.getOtra().length()>0?c.getOtra():null);
		}catch(Exception e){
			return null;
		}
		return ab_comp;
	}
	public static ArrEstudioResultado convierte2EFAblResultadoIdea(ResultadoAblacionEF c){
		ArrEstudioResultado ab_res = new ArrEstudioResultado();
		try{
			ab_res.setIdres(String.valueOf(c.getIdres()).length()>0&&c.getIdres()!=-2147483648?c.getIdres():0);
			ab_res.setIdtin(String.valueOf(c.getIdtin()).length()>0&&c.getIdtin()!=-2147483648?c.getIdtin():0);
			ab_res.setIdparcial(String.valueOf(c.getIdparcial()).length()>0&&c.getIdparcial()!=-2147483648?c.getIdparcial():null);
			ab_res.setIdtam(String.valueOf(c.getIdtam()).length()>0&&c.getIdtam()!=-2147483648?c.getIdtam():null);
			ab_res.setIdfa(String.valueOf(c.getIdfa()).length()>0&&c.getIdfa()!=-2147483648?c.getIdfa():null);
			ab_res.setIdiam(String.valueOf(c.getIdiam()).length()>0&&c.getIdiam()!=-2147483648?c.getIdiam():null);
			ab_res.setIdnoiam(String.valueOf(c.getIdnoiam()).length()>0&&c.getIdnoiam()!=-2147483648?c.getIdnoiam():null);
			ab_res.setVac(String.valueOf(c.getVac()).length()>0&&c.getVac()!=-2147483648?c.getVac():null);
			ab_res.setTaf(String.valueOf(c.getTaf()).length()>0&&c.getTaf()!=-2147483648?c.getTaf():null);
			ab_res.setTvi(String.valueOf(c.getTvi()).length()>0&&c.getTvi()!=-2147483648?c.getTvi():null);		
		}catch(Exception e){
			return null;
		}
		return ab_res;
	}
	public static ArrEstudioCatUso convierte2EFCatererEnUso(CateterEF c){
		ArrEstudioCatUso cat = new ArrEstudioCatUso();
		try{
			cat.setIdcateter(String.valueOf(c.getIdcateter()).length()>0&&c.getIdcateter()!=-2147483648?c.getIdcateter():null);
			cat.setIdvia(String.valueOf(c.getIdviadiag()).length()>0&&c.getIdviadiag()!=-2147483648?c.getIdviadiag():0);
			cat.setIdlocalizacion(String.valueOf(c.getIdlocalizaciondiag()).length()>0&&c.getIdlocalizaciondiag()!=-2147483648?c.getIdlocalizaciondiag():0);
			cat.setLote(c.getLote()!=null?c.getLote():null);
			cat.setReutilizado(String.valueOf(c.getReutilizado()).length()>0&&c.getReutilizado()!=-2147483648?c.getReutilizado():0);
		}catch(Exception e){
			return null;
		}
		return cat;
	}
	public static ArrEstudioCatApl convierte2EFCatererApl(CateterEF c){
		ArrEstudioCatApl cat = new ArrEstudioCatApl();
		try{
			cat.setIdvia(String.valueOf(c.getIdviaabl()).length()>0&&c.getIdviaabl()!=-2147483648?c.getIdviaabl():0);
			cat.setTiempo(c.getTiempoapl()!=null?c.getTiempoapl():null);
			cat.setPotencia(c.getPotenciaapl()!=null?c.getPotenciaapl():null);
			cat.setImpedancia(c.getImpapl()!=null?c.getImpapl():null);
		}catch(Exception e){
			return null;
		}
		return cat;
	}
	public static ArrCardioversion convierte2CVIdea(CV c){
		ArrCardioversion cv = new ArrCardioversion();
		try{
			cv.setFibrilacion(String.valueOf(c.getFibrilacion()).length()>0&&c.getFibrilacion()!=-2147483648?c.getFibrilacion():0);
			cv.setFluteratipico(String.valueOf(c.getFluteratipico()).length()>0&&c.getFluteratipico()!=-2147483648?c.getFluteratipico():0);
			cv.setFlutertipico(String.valueOf(c.getFlutertipico()).length()>0&&c.getFlutertipico()!=-2147483648?c.getFlutertipico():0);
			cv.setIdprocedencia(String.valueOf(c.getIdprocedencia()).length()>0&&c.getIdprocedencia()!=-2147483648?c.getIdprocedencia():2);
			cv.setCveno(String.valueOf(c.getCveprevia()).length()>0&&c.getCveprevia()==0?c.getCveprevia():0);
			cv.setCvesi(String.valueOf(c.getCveprevia()).length()>0&&c.getCveprevia()==1?c.getCveprevia():0);
			cv.setCvenumero(c.getCvenumero()!=null&&c.getCvenumero().length()>0?c.getCvenumero():null);
			cv.setCveeficaz(String.valueOf(c.getCveeficaz()).length()>0&&c.getCveeficaz()!=-2147483648?c.getCveeficaz():0);
			cv.setIdablacion(String.valueOf(c.getAblacion()).length()>0&&c.getAblacion()!=-2147483648?c.getAblacion():-1);
			cv.setNyha(c.getNyha()!=null&&c.getNyha().length()>0?c.getNyha():null);
			cv.setIdcardiopatia(String.valueOf(c.getCardiopatia()).length()>0&&c.getCardiopatia()!=-2147483648?c.getCardiopatia():-1);
			cv.setHta(String.valueOf(c.getHta()).length()>0&&c.getHta()!=-2147483648?c.getHta():0);
			cv.setEpoc(String.valueOf(c.getEpoc()).length()>0&&c.getEpoc()!=-2147483648?c.getEpoc():0);
			cv.setMpdefinitivo(String.valueOf(c.getMpdefinitivo()).length()>0&&c.getMpdefinitivo()!=-2147483648?c.getMpdefinitivo():0);
			cv.setAcv(String.valueOf(c.getAcv()).length()>0&&c.getAcv()!=-2147483648?c.getAcv():0);
			cv.setDiabetes(String.valueOf(c.getDiabetes()).length()>0&&c.getDiabetes()!=-2147483648?c.getDiabetes():0);
			cv.setIdablacion(String.valueOf(c.getAblacion()).length()>0&&c.getAblacion()!=-2147483648?c.getAblacion():0);
			cv.setIdtabaco(String.valueOf(c.getIdtabaco()).length()>0&&c.getIdtabaco()!=-2147483648?c.getIdtabaco():-1);
			cv.setDigoxina(String.valueOf(c.getDigoxina()).length()>0&&c.getDigoxina()!=-2147483648?c.getDigoxina():0);
			cv.setAmiod(String.valueOf(c.getAmiod()).length()>0&&c.getAmiod()!=-2147483648?c.getAmiod():0);
			cv.setSotalol(String.valueOf(c.getSotalol()).length()>0&&c.getSotalol()!=-2147483648?c.getSotalol():0);
			cv.setIeca(String.valueOf(c.getIeca()).length()>0&&c.getIeca()!=-2147483648?c.getIeca():0);
			cv.setBbloq(String.valueOf(c.getBbloq()).length()>0&&c.getBbloq()!=-2147483648?c.getBbloq():0);
			cv.setAas(String.valueOf(c.getAas()).length()>0&&c.getAas()!=-2147483648?c.getAas():0);
			cv.setClasei(String.valueOf(c.getClasei()).length()>0&&c.getClasei()!=-2147483648?c.getClasei():0);
			cv.setAraii(String.valueOf(c.getAraii()).length()>0&&c.getAraii()!=-2147483648?c.getAraii():0);
			cv.setDronedarona(String.valueOf(c.getDronedarona()).length()>0&&c.getDronedarona()!=-2147483648?c.getDronedarona():0);
			cv.setAntca(String.valueOf(c.getAntca()).length()>0&&c.getAntca()!=-2147483648?c.getAntca():0);
			cv.setDiureticos(String.valueOf(c.getDiureticos()).length()>0&&c.getDiureticos()!=-2147483648?c.getDiureticos():0);
			cv.setIdduracion(String.valueOf(c.getIdduracion()).length()>0&&c.getIdduracion()!=-2147483648?c.getIdduracion():-1);
			cv.setFe(c.getFe()!=null&&c.getFe().length()>0?c.getFe():null);
			cv.setAl(c.getAl()!=null&&c.getAl().length()>0?c.getAl():null);
			cv.setOtroseco(c.getOtroseco()!=null&&c.getOtroseco().length()>0?c.getOtroseco():null);
			cv.setAvta(String.valueOf(c.getAvta()).length()>0&&c.getAvta()!=-2147483648?c.getAvta():0);
			cv.setEte(String.valueOf(c.getEte()).length()>0&&c.getEte()!=-2147483648?c.getEte():0);
			cv.setIdexitofinal(String.valueOf(c.getExitofinal()).length()>0&&c.getExitofinal()!=-2147483648?c.getExitofinal():-1);
			cv.setIdcomplicacion(String.valueOf(c.getIdcomplicacion()).length()>0&&c.getIdcomplicacion()!=-2147483648?c.getIdcomplicacion():-1);
			cv.setComplicacion(c.getComplicacion()!=null&&c.getComplicacion().length()>0?c.getComplicacion():null);
			cv.setExitotrans(String.valueOf(c.getExitotrans()).length()>0&&c.getExitotrans()!=-2147483648?c.getExitotrans():0);
			cv.setNumexitotrans(c.getNumexitotrans()!=null&&c.getNumexitotrans().length()>0?c.getNumexitotrans():null);
			cv.setDuracionextrans(c.getDuracionextrans()!=null&&c.getDuracionextrans().length()>0?c.getDuracionextrans():null);
			cv.setEnergiaextrans(c.getEnergiaextrans()!=null&&c.getEnergiaextrans().length()>0?c.getEnergiaextrans():null);
			cv.setSec1(c.getSec1()!=null&&c.getSec1().length()>0?c.getSec1():null);
			cv.setIdsec1(String.valueOf(c.getIdsec1()).length()>0&&c.getIdsec1()!=-2147483648?c.getIdsec1():0);
			cv.setSec2(c.getSec2()!=null&&c.getSec2().length()>0?c.getSec2():null);
			cv.setIdsec2(String.valueOf(c.getIdsec2()).length()>0&&c.getIdsec2()!=-2147483648?c.getIdsec2():0);
			cv.setSec3(c.getSec3()!=null&&c.getSec3().length()>0?c.getSec3():null);
			cv.setIdsec3(String.valueOf(c.getIdsec3()).length()>0&&c.getIdsec3()!=-2147483648?c.getIdsec3():0);
			cv.setSec4(c.getSec4()!=null&&c.getSec4().length()>0?c.getSec4():null);
			cv.setIdsec4(String.valueOf(c.getIdsec4()).length()>0&&c.getIdsec4()!=-2147483648?c.getIdsec4():0);
			cv.setSec5(c.getSec5()!=null&&c.getSec5().length()>0?c.getSec5():null);
			cv.setIdsec5(String.valueOf(c.getIdsec5()).length()>0&&c.getIdsec5()!=-2147483648?c.getIdsec5():0);
			cv.setParches(String.valueOf(c.getParches()).length()>0&&c.getParches()!=-2147483648?c.getParches():0);
			cv.setAtropina(String.valueOf(c.getAtropina()).length()>0&&c.getAtropina()!=-2147483648?c.getAtropina():0);
			cv.setEstimtmpext(String.valueOf(c.getEstimtmpext()).length()>0&&c.getEstimtmpext()!=-2147483648?c.getEstimtmpext():0);
			cv.setBbalta(String.valueOf(c.getBbalta()).length()>0&&c.getBbalta()!=-2147483648?c.getBbalta():0);
			cv.setAvtaalta(String.valueOf(c.getAvtalta()).length()>0&&c.getAvtalta()!=-2147483648?c.getAvtalta():0);
			cv.setAraalta(String.valueOf(c.getAraalta()).length()>0&&c.getAraalta()!=-2147483648?c.getAraalta():0);
			cv.setAmiodaronaalta(String.valueOf(c.getAmiodaronaalta()).length()>0&&c.getAmiodaronaalta()!=-2147483648?c.getAmiodaronaalta():0);
			cv.setClaseialta(String.valueOf(c.getClaseialta()).length()>0&&c.getClaseialta()!=-2147483648?c.getClaseialta():0);
			cv.setDronedaronaalta(String.valueOf(c.getDronedaronaalta()).length()>0&&c.getDronedaronaalta()!=-2147483648?c.getDronedaronaalta():0);
			cv.setSolatololalta(String.valueOf(c.getSolatololalta()).length()>0&&c.getSolatololalta()!=-2147483648?c.getSolatololalta():0);
			cv.setIecaalta(String.valueOf(c.getIeacalta()).length()>0&&c.getIeacalta()!=-2147483648?c.getIeacalta():0);
			cv.setOtrosalta(String.valueOf(c.getOtroalta()).length()>0&&c.getOtroalta()!=-2147483648?c.getOtroalta():0);
			cv.setAnocv(String.valueOf(c.getAnocv()).length()>0&&c.getAnocv()!=-2147483648?c.getAnocv():0);
			cv.setTipocardio(c.getTipocardio()!=null&&c.getTipocardio().length()>0?c.getTipocardio():null);
			cv.setOtrosmedalta(c.getOtrosmedalta()!=null&&c.getOtrosmedalta().length()>0?c.getOtrosmedalta():null);
			cv.setNcv(c.getNcv()!=null&&c.getNcv().length()>0?c.getNcv():null);
			cv.setTipoprocedimiento(c.getTipoprocedimiento());
			cv.setComentarios(c.getComentarios()!=null?c.getComentarios():null);
		}catch(Exception e){
			return null;
		}
		return cv;
	}
	public static SegSistema convierte2SistemaIdea(Sistema s){
		SegSistema sistema = new SegSistema();
		try{
			sistema.setVoltaje(s.getVoltaje()!=null&&s.getVoltaje().length()>0?s.getVoltaje():null);
			sistema.setImpedancia(s.getImpedancia()!=null&&s.getImpedancia().length()>0?s.getImpedancia():null);
			sistema.setFmagnetica(s.getFmagnetica()!=null&&s.getFmagnetica().length()>0?s.getFmagnetica():null);
			sistema.setUltchqenergia(s.getUltimochqenergia()!=null&&s.getUltimochqenergia().length()>0?s.getUltimochqenergia():null);
			sistema.setUltchqimpedancia(s.getUltimochqimpedancia()!=null&&s.getUltimochqimpedancia().length()>0?s.getUltimochqimpedancia():null);
			sistema.setUltchqtcarga(s.getUltimochqtcarga()!=null&&s.getUltimochqtcarga().length()>0?s.getUltimochqtcarga():null);
			sistema.setUltchqfecha(s.getUltimochqfecha()!=null?s.getUltimochqfecha():null);
			sistema.setEri(s.getEri()?(short)1:(short)0);
			sistema.setEol(s.getEol()?(short)1:(short)0);			
			return sistema;
		}catch(Exception e){
			return null;
		}
	}
	public static SegBloqueos convierte2BloqueoIdea(Bloqueo b){
		SegBloqueos bl = new SegBloqueos();
		try{
			bl.setBav1(b.getBav1()!=null&&b.getBav1().length()>0?b.getBav1():null);
			bl.setBav2(b.getBav2()!=null&&b.getBav2().length()>0?b.getBav2():null);
			bl.setBav3(b.getBav3()!=null&&b.getBav3().length()>0?b.getBav3():null);
			return bl;
		}catch(Exception e){
			return null;
		}
	}
	public static SegPorestimulacion convierte2PorEstimIdea(PorEstimulacion p){
		SegPorestimulacion pr = new SegPorestimulacion();
		try{
			pr.setPorap(p.getPorap()!=null&&p.getPorap().length()>0?p.getPorap():null);
			pr.setPoras(p.getPoras()!=null&&p.getPoras().length()>0?p.getPoras():null);
			pr.setPorvp(p.getPorvp()!=null&&p.getPorvp().length()>0?p.getPorvp():null);
			pr.setPorvs(p.getPorvs()!=null&&p.getPorvs().length()>0?p.getPorvs():null);
			pr.setTiempofa(p.getTiempofa()!=null&&p.getTiempofa().length()>0?p.getTiempofa():null);
			return pr;
		}catch(Exception e){
			return null;
		}
	}
	public static SegObservacionesMp convierte2ObsMpIdea(ObservacionMP o){
		SegObservacionesMp obs = new SegObservacionesMp();
		try{
			obs.setArrau(o.getArrau()?(short)1:(short)0);
			obs.setNumarrau(o.getNumarrau()!=null&&o.getNumarrau().length()>0?o.getNumarrau():null);
			obs.setCambiomodoarrau(o.getCambiomodoarrau()?(short)1:(short)0);
			obs.setNumcambiomodoarrau(o.getNumcambiomodoarrau()!=null&&o.getNumcambiomodoarrau().length()>0?o.getNumcambiomodoarrau():null);
			obs.setArrvent(o.getArrvent()?(short)1:(short)0);
			obs.setNumarrv(o.getNumarrvent()!=null&&o.getNumarrvent().length()>0?o.getNumarrvent():null);
			obs.setEpiruido(o.getEpiruido()?(short)1:(short)0);			
			return obs;
		}catch(Exception e){
			return null;
		}
	}
	public static SegObservacionesDai convierte2ObsDaiIdea(ObservacionDAI o){
		SegObservacionesDai obs = new SegObservacionesDai();
		try{
			obs.setNumepisodios(o.getNumepisodios_total()!=null&&o.getNumepisodios_total().length()>0?o.getNumepisodios_total():null);		
			obs.setNumepitsv(o.getNumepisodios_tsv()!=null&&o.getNumepisodios_tsv().length()>0?o.getNumepisodios_tsv():null);
			obs.setNumepitv(o.getNumepisodios_tv()!=null&&o.getNumepisodios_tv().length()>0?o.getNumepisodios_tv():null);
			obs.setNumepifv(o.getNumepisodios_fv()!=null&&o.getNumepisodios_fv().length()>0?o.getNumepisodios_fv():null);
			obs.setNumepinosost(o.getNumepisodios_nosost()!=null&&o.getNumepisodios_nosost().length()>0?o.getNumepisodios_nosost():null);
			obs.setNumepinoesp(o.getNumepisodios_noesp()!=null&&o.getNumepisodios_noesp().length()>0?o.getNumepisodios_noesp():null);
			obs.setAtp(o.getAtp()?(short)1:(short)0);
			obs.setNumteratp(o.getNumatp()!=null&&o.getNumatp().length()>0?o.getNumatp():null);
			obs.setTodasefecatp(o.getTefectatp()?(short)1:(short)0);
			obs.setChoq(o.getChoques()?(short)1:(short)0);
			obs.setNumterchoq(o.getNumchoques()!=null&&o.getNumchoques().length()>0?o.getNumchoques():null);
			obs.setTodasefectchoq(o.getTefectchoques()?(short)1:(short)0);
			obs.setUltchoqenergia(o.getUltchoque_energia()!=null&&o.getUltchoque_energia().length()>0?o.getUltchoque_energia():null);
			obs.setUltchoqtcarga(o.getUltchoque_tcarga()!=null&&o.getUltchoque_tcarga().length()>0?o.getUltchoque_tcarga():null);
			obs.setUltchoqimpedancia(o.getUltchoque_imp()!=null&&o.getUltchoque_imp().length()>0?o.getUltchoque_imp():null);
			obs.setTodasapropiadas(String.valueOf(o.getTodasefectivas()).length()>0&&o.getTodasefectivas()!=-2147483648?o.getTodasefectivas():0);
			obs.setEpiruido(o.getEpiruido()?(short)1:(short)0);
			return obs;
		}catch(Exception e){
			return null;
		}
	}
	public static SegComplicaciones convierte2ComplicacionIdea(Complicaciones c){
		SegComplicaciones comp = new SegComplicaciones();
		try{
			comp.setIdcomp(String.valueOf(c.getIdcomplicacion()).length()>0&&c.getIdcomplicacion()!=-2147483648?c.getIdcomplicacion():0);
			comp.setActitud(c.getActitud()!=null&&c.getActitud().length()>0?c.getActitud():null);
			comp.setResultado(c.getResultado()!=null&&c.getResultado().length()>0?c.getResultado():null);
			comp.setOtra(c.getOtra()!=null&&c.getOtra().length()>0?c.getOtra():null);
			return comp;
		}catch(Exception e){
			return null;
		}
	}
	public static ImpHojaImplanteComplicacion convierte2ComplicacionHojaImpIdea(Complicaciones c){
		ImpHojaImplanteComplicacion comp = new ImpHojaImplanteComplicacion();
		try{
			comp.setIdcompl(String.valueOf(c.getIdcomplicacion()).length()>0&&c.getIdcomplicacion()!=-2147483648?c.getIdcomplicacion():0);
			comp.setActitud(c.getActitud()!=null&&c.getActitud().length()>0?c.getActitud():null);
			comp.setResultado(c.getResultado()!=null&&c.getResultado().length()>0?c.getResultado():null);
			comp.setOtra(c.getOtra()!=null&&c.getOtra().length()>0?c.getOtra():null);
			return comp;
		}catch(Exception e){
			return null;
		}
	}
	public static ImpEvolucionComplicacion convierte2ComplicacionEvolucionIdea(Complicaciones c){
		ImpEvolucionComplicacion comp = new ImpEvolucionComplicacion();
		try{
			comp.setIdcompl(String.valueOf(c.getIdcomplicacion()).length()>0&&c.getIdcomplicacion()!=-2147483648?c.getIdcomplicacion():0);
			comp.setActitud(c.getActitud()!=null&&c.getActitud().length()>0?c.getActitud():null);
			comp.setResultado(c.getResultado()!=null&&c.getResultado().length()>0?c.getResultado():null);
			comp.setOtra(c.getOtra()!=null&&c.getOtra().length()>0?c.getOtra():null);
			return comp;
		}catch(Exception e){
			return null;
		}
	}
	public static ArrMesas convierte2MesaIdea(Mesa m){
		ArrMesas mesa = new ArrMesas();
		try{
			mesa.setFecha(m.getFecha()!=null?m.getFecha():null);
			mesa.setReferidor(m.getReferidor()!=null&&m.getReferidor().length()>0?m.getReferidor():null);
			mesa.setIndicacion(String.valueOf(m.getIndicacion()).length()>0&&m.getIndicacion()!=-2147483648?m.getIndicacion():null);
			mesa.setEpiPrevios(String.valueOf(m.getEpi_previos()).length()>0&&m.getEpi_previos()!=-2147483648?m.getEpi_previos():null);
			mesa.setOpEnf(m.getOp_enfermeria()!=null&&m.getOp_enfermeria().length()>0?m.getOp_enfermeria():null);
			mesa.setComentarios(m.getComentarios()!=null&&m.getComentarios().length()>0?m.getComentarios():null);
			mesa.setComplicaciones(m.getComplicaciones()!=null&&m.getComplicaciones().length()>0?m.getComplicaciones():"");
			mesa.setResN1(String.valueOf(m.getResn1()).length()>0&&m.getResn1()!=-2147483648?m.getResn1():null);
			mesa.setResN2(String.valueOf(m.getResn2()).length()>0&&m.getResn2()!=-2147483648?m.getResn2():null);
			mesa.setResN3(String.valueOf(m.getResn3()).length()>0&&m.getResn3()!=-2147483648?m.getResn3():null);
			mesa.setResTiempo(m.getRestiempo()!=null&&m.getRestiempo().length()>0?m.getRestiempo():null);
			mesa.setCardiopatia(String.valueOf(m.getCardiopatia()).length()>0&&m.getCardiopatia()!=-2147483648?m.getCardiopatia():null);
			mesa.setSheldonA(String.valueOf(m.getSheldon_a()).length()>0&&m.getSheldon_a()!=-2147483648?m.getSheldon_a():null);
			mesa.setSheldonB(String.valueOf(m.getSheldon_b()).length()>0&&m.getSheldon_b()!=-2147483648?m.getSheldon_b():null);
			mesa.setSheldonC(String.valueOf(m.getSheldon_c()).length()>0&&m.getSheldon_c()!=-2147483648?m.getSheldon_c():null);
			mesa.setSheldonD(String.valueOf(m.getSheldon_d()).length()>0&&m.getSheldon_d()!=-2147483648?m.getSheldon_d():null);
			mesa.setSheldonE(String.valueOf(m.getSheldon_e()).length()>0&&m.getSheldon_e()!=-2147483648?m.getSheldon_e():null);
			mesa.setSheldonF(String.valueOf(m.getSheldon_f()).length()>0&&m.getSheldon_f()!=-2147483648?m.getSheldon_f():null);
			mesa.setSheldonG(String.valueOf(m.getSheldon_g()).length()>0&&m.getSheldon_g()!=-2147483648?m.getSheldon_g():null);
			mesa.setComplicacionesSn(String.valueOf(m.getComplicacionessn()).length()>0&&m.getComplicacionessn()!=-2147483648?m.getComplicacionessn():0);
			mesa.setComplicaciones(m.getComplicaciones()!=null?m.getComplicaciones():"");
			//mesa.setIndicacionOtra(String.valueOf(m.getIndicacionotra()).length()>0&&m.getIndicacionotra()!=-2147483648?m.getIndicacionotra():null);
			mesa.setOpMed(m.getOp_medico()!=null&&m.getOp_medico().length()>0?m.getOp_medico():null);
			mesa.setEpiSin(String.valueOf(m.getEpisin()).length()>0&&m.getEpisin()!=-2147483648?m.getEpisin():null);
			mesa.setNtg(String.valueOf(m.getNtg()).length()>0&&m.getNtg()!=-2147483648?m.getNtg():null);		
			mesa.setNproc(m.getNmesa()!=null&&m.getNmesa().length()>0?m.getNmesa():null);
			return mesa;
		}catch(Exception e){
			return null;
		}
	}
	public static ArrMesasEcg convierte2MesaECGIdea(ECGEF e){
		ArrMesasEcg ecg = new ArrMesasEcg();
		try{
			ecg.setIdritmo(String.valueOf(e.getRitmo()).length()>0&&e.getRitmo()!=-2147483648?e.getRitmo():null);
			ecg.setIdconduccion(String.valueOf(e.getConduccion()).length()>0&&e.getConduccion()!=-2147483648?e.getConduccion():null);
			ecg.setIdconduccionno(String.valueOf(e.getConduccionno()).length()>0&&e.getConduccionno()!=-2147483648?e.getConduccionno():null);
			ecg.setIdqrs(String.valueOf(e.getQrs_cond()).length()>0&&e.getQrs_cond()!=-2147483648?e.getQrs_cond():null);
			ecg.setIdqrsno(String.valueOf(e.getQrsno()).length()>0&&e.getQrsno()!=-2147483648?e.getQrsno():null);
			//Morfologia
			ecg.setRr(e.getRr()!=null&&e.getRr().length()>0?e.getRr():null);
			ecg.setPr(e.getPr()!=null&&e.getPr().length()>0?e.getPr():null);
			ecg.setQrs(e.getQrs()!=null&&e.getQrs().length()>0?e.getQrs():null);
			ecg.setQt(e.getQt()!=null&&e.getQt().length()>0?e.getQt():null);
			//ecg.setQtc(e.getQtc()!=null&&e.getQtc().length()>0?e.getQtc():null);	No se encuentra..
		}catch(Exception ex){
			return null;
		}
		return ecg;
	}
	public static ArrRegistrador convierte2RegistradorIdea(Registrador r){
		ArrRegistrador reg = new ArrRegistrador();
		try{
			reg.setFecha(r.getFecha()!=null?r.getFecha():null);
			reg.setReferidor(r.getReferidor()!=null&&r.getReferidor().length()>0?r.getReferidor():null);
			reg.setIndicacion(String.valueOf(r.getIndicacion()).length()>0&&r.getIndicacion()!=-2147483648?r.getIndicacion():0);
			reg.setIndicacionsincope(String.valueOf(r.getIndicacionsincope()).length()>0&&r.getIndicacionsincope()!=-2147483648?r.getIndicacionsincope():0);
			reg.setIndicacionsincopen(String.valueOf(r.getIndicacionsincopen()).length()>0&&r.getIndicacionsincopen()!=-2147483648?r.getIndicacionsincopen():0);
			reg.setOpMed(r.getOp_medico()!=null&&r.getOp_medico().length()>0?r.getOp_medico():null);
			reg.setOpEnf(r.getOp_enfermeria()!=null&&r.getOp_enfermeria().length()>0?r.getOp_enfermeria():null);
			reg.setImplanteSala(r.getImplante_sala()!=null&&r.getImplante_sala().length()>0?r.getImplante_sala():null);
			reg.setImplanteModelo(r.getImplante_modelo()!=null&&r.getImplante_modelo().length()>0?r.getImplante_modelo():null);
			reg.setImplanteZona(r.getImplante_zona()!=null&&r.getImplante_zona().length()>0?Integer.valueOf(r.getImplante_zona()):0);
			reg.setCardiopatia(String.valueOf(r.getCardiopatia()).length()>0&&r.getCardiopatia()!=-2147483648?r.getCardiopatia():-1);
			reg.setSheldonA(String.valueOf(r.getSheldon_a()).length()>0&&r.getSheldon_a()!=-2147483648?r.getSheldon_a():null);
			reg.setSheldonB(String.valueOf(r.getSheldon_b()).length()>0&&r.getSheldon_b()!=-2147483648?r.getSheldon_b():null);
			reg.setSheldonC(String.valueOf(r.getSheldon_c()).length()>0&&r.getSheldon_c()!=-2147483648?r.getSheldon_c():null);
			reg.setSheldonD(String.valueOf(r.getSheldon_d()).length()>0&&r.getSheldon_d()!=-2147483648?r.getSheldon_d():null);
			reg.setSheldonE(String.valueOf(r.getSheldon_e()).length()>0&&r.getSheldon_e()!=-2147483648?r.getSheldon_e():null);
			reg.setSheldonF(String.valueOf(r.getSheldon_f()).length()>0&&r.getSheldon_f()!=-2147483648?r.getSheldon_f():null);
			reg.setSheldonG(String.valueOf(r.getSheldon_g()).length()>0&&r.getSheldon_g()!=-2147483648?r.getSheldon_g():null);
			reg.setResN1(String.valueOf(r.getResn1()).length()>0&&r.getResn1()!=-2147483648?r.getResn1():null);
			reg.setResN2(String.valueOf(r.getResn2()).length()>0&&r.getResn2()!=-2147483648?r.getResn2():null);
			reg.setExplanteFecha(r.getExplante_fecha()!=null?r.getExplante_fecha():null);
			reg.setExplanteOpEnf(r.getExplante_op_enf()!=null&&r.getExplante_op_enf().length()>0?r.getExplante_op_enf():null);
			reg.setExplanteOpmed(r.getExplante_op_med()!=null&&r.getExplante_op_med().length()>0?r.getExplante_op_med():null);
			reg.setExplanteDiagnostico(String.valueOf(r.getExplante_diag()).length()>0&&r.getExplante_diag()!=-2147483648?r.getExplante_diag():0);
			reg.setComentarios(r.getComentarios()!=null&&r.getComentarios().length()>0?r.getComentarios():null);
			reg.setComplicaciones(r.getComplicaciones()!=null&&r.getComplicaciones().length()>0?r.getComplicaciones():"");
			reg.setNproc(r.getNregistrador()!=null&&r.getNregistrador().length()>0?r.getNregistrador():null);
			reg.setNserie(r.getNserie()!=null&&r.getNserie().length()>0?r.getNserie():null);
			reg.setIdmodeloreg(r.getIdmodeloreg()>0 && r.getIdmodeloreg()!=-2147483648?r.getIdmodeloreg():null);
			return reg;
		}catch(Exception ex){
			return null;
		}
	}
	public static ArrRegistradorEcg convierte2RegistradorECGIdea(ECGEF e){
		ArrRegistradorEcg ecg = new ArrRegistradorEcg();
		try{
			ecg.setIdritmo(String.valueOf(e.getRitmo()).length()>0&&e.getRitmo()!=-2147483648?e.getRitmo():null);
			ecg.setIdconduccion(String.valueOf(e.getConduccion()).length()>0&&e.getConduccion()!=-2147483648?e.getConduccion():null);
			ecg.setIdconduccionno(String.valueOf(e.getConduccionno()).length()>0&&e.getConduccionno()!=-2147483648?e.getConduccionno():null);
			ecg.setIdqrs(String.valueOf(e.getQrs_cond()).length()>0&&e.getQrs_cond()!=-2147483648?e.getQrs_cond():null);
			ecg.setIdqrsno(String.valueOf(e.getQrsno()).length()>0&&e.getQrsno()!=-2147483648?e.getQrsno():null);
			//Morfologia
			ecg.setRr(e.getRr()!=null&&e.getRr().length()>0?e.getRr():null);
			ecg.setPr(e.getPr()!=null&&e.getPr().length()>0?e.getPr():null);
			ecg.setQrs(e.getQrs()!=null&&e.getQrs().length()>0?e.getQrs():null);
			ecg.setQt(e.getQt()!=null&&e.getQt().length()>0?e.getQt():null);
		}catch(Exception ex){
			return null;
		}
		return ecg;
	}
	public static ArrTestFle convierte2TestFLEIdea(TestFLE t){
		ArrTestFle test = new ArrTestFle();
		try{
			test.setClinico(String.valueOf(t.getMclinico()).length()>0&&t.getMclinico()!=-2147483648?t.getMclinico():0);
			test.setEcg(String.valueOf(t.getMecg()).length()>0&&t.getMecg()!=-2147483648?t.getMecg():0);
			test.setIntervalos(String.valueOf(t.getIntervalos()).length()>0&&t.getIntervalos()!=-2147483648?t.getIntervalos():0);
			test.setQrs(String.valueOf(t.getQrs()).length()>0&&t.getQrs()!=-2147483648?t.getQrs():0);
			test.setComplica(String.valueOf(t.getComplicacion()).length()>0&&t.getComplicacion()!=-2147483648?t.getComplicacion():0);
			test.setComplicaotr(t.getComplicacion_otra()!=null?t.getComplicacion_otra():null);
			test.setTratam(String.valueOf(t.getTratamiento()).length()>0&&t.getTratamiento()!=-2147483648?t.getTratamiento():0);
			test.setFecha(t.getFecha()!=null?t.getFecha():null);
			test.setResultado(String.valueOf(t.getResultado()).length()>0&&t.getResultado()!=-2147483648?t.getResultado():0);
			test.setV1(String.valueOf(t.getV1()).length()>0&&t.getV1()!=-2147483648?t.getV1():0);
			test.setV2(String.valueOf(t.getV2()).length()>0&&t.getV2()!=-2147483648?t.getV2():0);
			test.setNproc(t.getNtest());
		}catch(Exception ex){
			return null;
		}
		return test;
	}
	public static ArrTestFleEcg convierte2TestFLEECGIdea(ECGEF e){
		ArrTestFleEcg ecg = new ArrTestFleEcg();
		try{
			ecg.setIdritmo(String.valueOf(e.getRitmo()).length()>0&&e.getRitmo()!=-2147483648?e.getRitmo():null);
			ecg.setIdconduccion(String.valueOf(e.getConduccion()).length()>0&&e.getConduccion()!=-2147483648?e.getConduccion():null);
			ecg.setIdconduccionno(String.valueOf(e.getConduccionno()).length()>0&&e.getConduccionno()!=-2147483648?e.getConduccionno():null);
			ecg.setIdqrs(String.valueOf(e.getQrs_cond()).length()>0&&e.getQrs_cond()!=-2147483648?e.getQrs_cond():null);
			ecg.setIdqrsno(String.valueOf(e.getQrsno()).length()>0&&e.getQrsno()!=-2147483648?e.getQrsno():null);
			//Morfologia
			ecg.setRr(e.getRr()!=null&&e.getRr().length()>0?e.getRr():null);
			ecg.setPr(e.getPr()!=null&&e.getPr().length()>0?e.getPr():null);
			ecg.setQrs(e.getQrs()!=null&&e.getQrs().length()>0?e.getQrs():null);
			ecg.setQt(e.getQt()!=null&&e.getQt().length()>0?e.getQt():null);
		}catch(Exception ex){
			return null;
		}
		return ecg;
	}
	public static ArrTestAtp convierte2TestATPIdea(TestATP t){
		ArrTestAtp test = new ArrTestAtp();
		try{
			test.setClinico(String.valueOf(t.getMclinico()).length()>0&&t.getMclinico()!=-2147483648?t.getMclinico():0);
			test.setEcg(String.valueOf(t.getMecg()).length()>0&&t.getMecg()!=-2147483648?t.getMecg():0);
			test.setIntervalos(String.valueOf(t.getIntervalos()).length()>0&&t.getIntervalos()!=-2147483648?t.getIntervalos():0);
			test.setQrs(String.valueOf(t.getQrs()).length()>0&&t.getQrs()!=-2147483648?t.getQrs():0);
			test.setComplica(String.valueOf(t.getComplicacion()).length()>0&&t.getComplicacion()!=-2147483648?t.getComplicacion():0);
			test.setComplicaotr(t.getComplicacion_otra()!=null?t.getComplicacion_otra():null);
			test.setTratam(String.valueOf(t.getTratamiento()).length()>0&&t.getTratamiento()!=-2147483648?t.getTratamiento():0);
			test.setFecha(t.getFecha()!=null?t.getFecha():null);
			test.setDosis1(String.valueOf(t.getDosis1()).length()>0&&t.getDosis1()!=-2147483648?t.getDosis1():0);
			test.setDosis2(String.valueOf(t.getDosis2()).length()>0&&t.getDosis2()!=-2147483648?t.getDosis2():0);
			//test.setResultado(String.valueOf(t.getResultado()).length()>0&&t.getResultado()!=-2147483648?t.getResultado():null);
			//test.setV1(String.valueOf(t.getV1()).length()>0&&t.getV1()!=-2147483648?t.getV1():null);
			//test.setV2(String.valueOf(t.getV2()).length()>0&&t.getV2()!=-2147483648?t.getV2():null);
			test.setNproc(test.getNproc());
			
		}catch(Exception ex){
			return null;
		}
		return test;
	}
	public static ArrTestAtpEcg convierte2TestATPECGIdea(ECGEF e){
		ArrTestAtpEcg ecg = new ArrTestAtpEcg();
		try{
			ecg.setIdritmo(String.valueOf(e.getRitmo()).length()>0&&e.getRitmo()!=-2147483648?e.getRitmo():null);
			ecg.setIdconduccion(String.valueOf(e.getConduccion()).length()>0&&e.getConduccion()!=-2147483648?e.getConduccion():null);
			ecg.setIdconduccionno(String.valueOf(e.getConduccionno()).length()>0&&e.getConduccionno()!=-2147483648?e.getConduccionno():null);
			ecg.setIdqrs(String.valueOf(e.getQrs_cond()).length()>0&&e.getQrs_cond()!=-2147483648?e.getQrs_cond():null);
			ecg.setIdqrsno(String.valueOf(e.getQrsno()).length()>0&&e.getQrsno()!=-2147483648?e.getQrsno():null);
			//Morfologia
			ecg.setRr(e.getRr()!=null&&e.getRr().length()>0?e.getRr():null);
			ecg.setPr(e.getPr()!=null&&e.getPr().length()>0?e.getPr():null);
			ecg.setQrs(e.getQrs()!=null&&e.getQrs().length()>0?e.getQrs():null);
			ecg.setQt(e.getQt()!=null&&e.getQt().length()>0?e.getQt():null);
		}catch(Exception ex){
			return null;
		}
		return ecg;
	}
	
	public static PlanMedGen convierte2PlanMedGenIdea(PlanMedicacion p){
		PlanMedGen plan = new PlanMedGen();
		try{
			plan.setIdmedgen(String.valueOf(p.getIdmedgen()).length()>0&&p.getIdmedgen()!=-2147483648?p.getIdmedgen():null);
			plan.setIdmedcom(String.valueOf(p.getIdmedcom()).length()>0&&p.getIdmedcom()!=-2147483648?p.getIdmedcom():null);
			plan.setDosis(p.getDosis()!=null?p.getDosis():null);
			plan.setUnidad(p.getUnidad()!=null?p.getUnidad():null);
			plan.setFrecuencia(p.getFrecuencia()!=null?p.getFrecuencia():null);
			plan.setAdministracion(p.getAdministracion()!=null?p.getAdministracion():null);
			plan.setIdvia(String.valueOf(p.getIdvia()).length()>0&&p.getIdvia()!=-2147483648?p.getIdvia():null);
			plan.setFechaprescripcion(p.getFechaprescripcion()!=null?p.getFechaprescripcion():null);
			plan.setFechainicio(p.getFechainicio()!=null?p.getFechainicio():null);
			plan.setFechamod(p.getFechamod()!=null?p.getFechamod():null);
			plan.setFechasuspension(p.getFechasuspension()!=null?p.getFechasuspension():null);
			plan.setMotivosuspension(p.getMotivosuspension()!=null?p.getMotivosuspension():null);
			plan.setEstado(String.valueOf(p.getEstado()).length()>0&&p.getEstado()!=-2147483648?p.getEstado():null);
			plan.setPrescriptor(p.getPrescriptor()!=null?p.getPrescriptor():null);
			plan.setComentarios(p.getComentarios()!=null?p.getComentarios():null);
		}catch(Exception e){
			return null;
		}
		return plan;
	}
	
	public static SegSeguimientoRegEventos convierte2SegRegEventos(SeguimientoRegistrador r){
		SegSeguimientoRegEventos seg = new SegSeguimientoRegEventos();
		try{
			seg.setFecha(r.getFecha());
			seg.setOperadorMedico(r.getOp_medico()!=null?r.getOp_medico():null);
			seg.setOperadorEnfermeria(r.getOp_enfermeria()!=null?r.getOp_enfermeria():null);
			seg.setMotivo(r.getMotivo()!=-2147483648?r.getMotivo():0);
			seg.setRemoto(r.getRemoto()!=-2147483648?r.getRemoto():0);
			seg.setTiposeguimiento(r.getTiposeguimiento()!=-2147483648?r.getTiposeguimiento():0);
			seg.setActivacion(r.getActivacion()!=-2147483648?r.getActivacion():-1);
			seg.setEstadobateria(r.getEstadobateria()!=-2147483648?r.getEstadobateria():0);
			seg.setEvRitmosinusal(r.getEv_sinusal()!=-2147483648?r.getEv_sinusal():0);
			seg.setEvPausa(r.getEv_pausa()!=-2147483648?r.getEv_pausa():0);
			seg.setEvBav(r.getEv_bav()!=-2147483648?r.getEv_bav():0);
			seg.setEvTpsv(r.getEv_tpsv()!=-2147483648?r.getEv_tpsv():0);
			seg.setEvTv(r.getEv_tv()!=-2147483648?r.getEv_tv():0);
			seg.setEvFv(r.getEv_fv()!=-2147483648?r.getEv_fv():0);
			seg.setEvOtros(r.getEv_otros()!=-2147483648?r.getEv_otros():0);
			seg.setTiempoFa(r.getTiempofa()!=null?r.getTiempofa():null);
			seg.setObservaciones(r.getObservaciones()!=null?r.getObservaciones():null);
			seg.setComentariosInternos(r.getComentarios()!=null?r.getComentarios():null);
		}catch(Exception e){
			return null;
		}
		return seg;
	}
	public static ArrListaEspera convierte2ListaEsperaIdea(ListaEspera le){
		ArrListaEspera item = new ArrListaEspera();
		try{
			item.setIngreso(le.getIngreso()!=null?le.getIngreso():null);
			item.setArritmia(le.getArritmia()!=null?le.getArritmia():null);
			item.setNotas(le.getNotas()!=null?le.getNotas():null);
			item.setCaracter(le.getCaracter()!=null?le.getCaracter():null);
			item.setCardiopatia(le.getCardiopatia()!=null?le.getCardiopatia():null);
			item.setAnestesia(le.getAnestesia()!=null?le.getAnestesia():null);
			item.setProcedimiento(le.getProcedimiento()!=null?le.getProcedimiento():null);
			item.setTratamiento1(le.getTratamiento()!=null?le.getTratamiento():null);
			item.setEstado(le.getEstado()!=-2147483648?le.getEstado():null);
			item.setReclamacion(le.getReclamacion()!=null?le.getReclamacion():null);
			item.setIncluidopor(le.getIncluidopor()!=-2147483648?le.getIncluidopor():0);
		}catch(Exception e){
			return null;
		}
		return item;
	}
	
	public static ArrEnf convierte2Enfermeria(EnfermeriaEF e){
		ArrEnf enf = new ArrEnf();
		try{
			enf.setPeso(e.getPeso());
			enf.setTalla(e.getTalla());
			enf.setTalleg1(e.getTallag1());
			enf.setTalleg2(e.getTallag2());
			enf.setFclleg(e.getFclleg());
			enf.setTafin1(e.getTafin1());
			enf.setTafin2(e.getTafin2());
			enf.setFcfin(e.getFcfin());
			enf.setTataq1(e.getTataq1());
			enf.setTataq2(e.getTataq2());
			enf.setFctaq(e.getFctaq());
			enf.setCalibre1(e.getCalibre1());
			enf.setMiembro(e.getMiembro());
			enf.setPlanta(e.getPlanta()!=-2147483648?e.getPlanta():null);
			enf.setNumero(e.getNumero());
			enf.setCalibre2(e.getCalibre2());
			enf.setDiagnos(e.getDiagnos());
			enf.setPuncion(e.getPuncion()!=-2147483648?e.getPuncion():null);
			enf.setMaterial(e.getMaterial());
			enf.setVesical(e.getVesical());
			enf.setOtros(e.getOtros());
			enf.setVascular(e.getVascular()!=null?e.getVascular():"00000000");
			enf.setHemostasia(e.getHemostasia()!=-2147483648?e.getHemostasia():null);
			enf.setVendaje(e.getVendaje()!=-2147483648?e.getVendaje():null);
			enf.setZona(e.getZona()!=-2147483648?e.getZona():null);
			enf.setSuero(e.getSuero());
			enf.setHeparina(e.getHeparina());
			enf.setSedacion(e.getSedacion()!=null?e.getSedacion():"000");
			enf.setFarmacos(e.getFarmacos());
			enf.setCv(e.getCv()!=-2147483648?e.getCv():null);
			enf.setCv1(e.getCv1());
			enf.setCv2(e.getCv2());
			enf.setCv3(e.getCv3());
			enf.setCv4(e.getCv4());
			enf.setMotivo(e.getMotivo()!=-2147483648?e.getMotivo():null);
			enf.setExito(e.getExito()!=-2147483648?e.getExito():null);
			enf.setObserv(e.getObserv());
			enf.setDestino(e.getDestino());
			enf.setFecha(e.getFecha());
			enf.setHemostr(e.getHemostr());
			enf.setDiuresis(e.getDiuresis());
			enf.setCuidados(e.getCuidados());
			enf.setInr(e.getInr());
			enf.setHemostasiav(e.getHemostasiav()!=-2147483648?e.getHemostasiav():null);
			enf.setHemostrv(e.getHemostrv());
		}catch(Exception ex){
			return null;
		}
		return enf;
	}
	
}

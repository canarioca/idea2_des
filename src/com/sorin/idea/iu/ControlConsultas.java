package com.sorin.idea.iu;

import hvn.cm.modelo.Mensaje;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.sorin.idea.dao.ArrCardioversionDao;
import com.sorin.idea.dao.ArrDesfibriladorDao;
import com.sorin.idea.dao.ArrEstudioAblacionDao;
import com.sorin.idea.dao.ArrEstudioDao;
import com.sorin.idea.dao.ArrEstudioIntentoDao;
import com.sorin.idea.dao.ArrEstudioTaquiDao;
import com.sorin.idea.dao.ArrEstudioViasDao;
import com.sorin.idea.dao.ArrMesasDao;
import com.sorin.idea.dao.ArrPacienteDao;
import com.sorin.idea.dao.ArrPacientesDao;
import com.sorin.idea.dao.ArrRegistradorDao;
import com.sorin.idea.dao.ArrTestAtpDao;
import com.sorin.idea.dao.ArrTestEpiDao;
import com.sorin.idea.dao.ArrTestFleDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dao.HolterDao;
import com.sorin.idea.dao.ImpEvolucionDao;
import com.sorin.idea.dao.ImpGeneradorDao;
import com.sorin.idea.dao.ImpHojaImplanteDao;
import com.sorin.idea.dao.ImpHojaImplanteEnfDao;
import com.sorin.idea.dao.ImpHojaImplantePopDao;
import com.sorin.idea.dao.ImpHojaImplanteSopDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.RegistradorEventosExtDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrDesfibrilador;
import com.sorin.idea.dto.ArrEstudio;
import com.sorin.idea.dto.ArrEstudioAblacion;
import com.sorin.idea.dto.ArrEstudioIntento;
import com.sorin.idea.dto.ArrEstudioTaqui;
import com.sorin.idea.dto.ArrEstudioVias;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrMesas;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.ArrRegistrador;
import com.sorin.idea.dto.ArrTestAtp;
import com.sorin.idea.dto.ArrTestEpi;
import com.sorin.idea.dto.ArrTestFle;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplanteEnf;
import com.sorin.idea.dto.ImpHojaImplantePop;
import com.sorin.idea.dto.ImpHojaImplanteSop;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.exceptions.ImpHojaImplanteEnfDaoException;
import com.sorin.idea.jdbc.ArrCardioversionDaoImpl;
import com.sorin.idea.jdbc.ArrDesfibriladorDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioAblacionDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioIntentoDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioTaquiDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioViasDaoImpl;
import com.sorin.idea.jdbc.ArrMesasDaoImpl;
import com.sorin.idea.jdbc.ArrPacientesDaoImpl;
import com.sorin.idea.jdbc.ArrRegistradorDaoImpl;
import com.sorin.idea.jdbc.ArrTestAtpDaoImpl;
import com.sorin.idea.jdbc.ArrTestEpiDaoImpl;
import com.sorin.idea.jdbc.ArrTestFleDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.HolterDaoImpl;
import com.sorin.idea.jdbc.ImpEvolucionDaoImpl;
import com.sorin.idea.jdbc.ImpGeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteEnfDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplantePopDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteSopDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.RegistradorEventosExtDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.EstadisticasImplanteBean;
import com.sorin.idea.util.ExportExcel;

public class ControlConsultas extends BaseIU{

	private SelectorIdioma si;
	private ResourceBundle bundle;
	
	private ArrTestAtpDao atpdao;
	private ArrTestEpiDao epidao;
	private ArrTestFleDao fledao;
	private ArrCardioversionDao cvdao;
	private ArrEstudioDao eefdao;
	private ArrEstudioViasDao viasdao;
	private ArrEstudioTaquiDao taquidao;
	private ArrDesfibriladorDao daidao;
	private ArrPacienteDao pacientedao;
	
	private ArrTestAtp testAtp;
	private ArrTestEpi testEpi;
	private ArrTestFle testFle;
	private ArrCardioversion cv;
	private ArrEstudio eef;
	private ArrEstudioIntento intento;
	private ArrEstudioAblacion ablacion;
	private ArrDesfibrilador dai;
	
	/*************************************/
	
	private int tipodispositivo;
	
	private ArrPacientesDao patsdao;
	private Procedimiento proc;
	private ProcedimientoDao procdao;
	private ImpImplanteDao impdao;
	private ImpHojaImplanteDao himpdao;
	private ImpEvolucionDao evodao;
	private SituacionClinicaProcDao sitclindao;
	private ImpGeneradorDao gendao;
	private GeneradorDao gdao;
	private ImpHojaImplanteEnfDao enfdao;
	private ImpHojaImplantePopDao popdao;
	private ImpHojaImplanteSopDao sopdao;
	private GeneradorDao g;
	private Generador[] generadores;
	
	private ArrRegistradorDao regdao;
	private int filtroregind;
	private ArrMesasDao mesadao;
	private int filtromesares;
	private HolterDao holdao;
	private int filtroholdiag;
	private RegistradorEventosExtDao regevextdao;
	private int filtroregevextdiag;
	
	private Date fechaini;
	private Date fechafin;
	private Date fechaini_imp;
	private Date fechafin_imp;
	private Date fechaini_eef;
	private Date fechafin_eef;
	private Date fechaini_test;
	private Date fechafin_test;
	private Date fechaini_cv;
	private Date fechafin_cv;
	private Date fechaini_reg;
	private Date fechafin_reg;
	private Date fechaini_hol;
	private Date fechafin_hol;
	private Date fechaini_regevext;
	private Date fechafin_regevext;
	
	private int filtroritmo;
	private int filtrocav;
	private int filtroqrs;
	private String filtromodelo;
	private int filtromodo;
	private String filtrofab;
	
	private ControlMaestras cm;
	private ArrMaestras[] tipoproc;
	private ArrMaestras[] ritmos;
	private ArrMaestras[] conducciones;
	private ArrMaestras[] qrs;
	private ArrMaestras[] cardiopatia;
	private ArrMaestras[] modogen;
	private ArrMaestras[] hproc;
	private ArrMaestras[] caracterproc;
	private ArrMaestras[] pop;
	private ArrMaestras[] fabricantes;
	/*************************************/
	
	public ControlConsultas() {
		inicia(null);
	}
	
	public void inicia(ActionEvent e){
		this.cargaMaestras();
		this.atpdao = new ArrTestAtpDaoImpl("consulta");
		this.epidao = new ArrTestEpiDaoImpl("consulta");
		this.fledao = new ArrTestFleDaoImpl("consulta");
		this.cvdao = new ArrCardioversionDaoImpl("consulta");
		this.eefdao = new ArrEstudioDaoImpl("consulta");
		this.viasdao = new ArrEstudioViasDaoImpl("consulta");
		this.taquidao = new ArrEstudioTaquiDaoImpl("consulta");
		this.pacientedao = new ArrPacienteDao("consulta");
		this.daidao = new ArrDesfibriladorDaoImpl("consulta");
		
		this.testAtp = new ArrTestAtp();
		this.testEpi = new ArrTestEpi();
		this.testFle = new ArrTestFle();
		this.cv = new ArrCardioversion();
		this.eef = new ArrEstudio();
		this.intento = new ArrEstudioIntento();
		this.ablacion = new ArrEstudioAblacion();
		this.dai = new ArrDesfibrilador();
		
		this.patsdao = new ArrPacientesDaoImpl();
		this.proc = new Procedimiento();
		this.procdao = new ProcedimientoDaoImpl("consulta");
		this.impdao = new ImpImplanteDaoImpl("consulta");
		this.himpdao = new ImpHojaImplanteDaoImpl("consulta");
		this.evodao = new ImpEvolucionDaoImpl("consulta");
		this.sitclindao = new SituacionClinicaProcDaoImpl("consulta");
		this.gendao = new ImpGeneradorDaoImpl("consulta");
		this.gdao = new GeneradorDaoImpl("consulta");
		this.enfdao = new ImpHojaImplanteEnfDaoImpl("consulta");
		this.popdao = new ImpHojaImplantePopDaoImpl("consulta");
		this.sopdao = new ImpHojaImplanteSopDaoImpl("consulta");
		this.g = new GeneradorDaoImpl("consulta");
		cargaGeneradores();
		
		this.regdao = new ArrRegistradorDaoImpl("consulta");
		this.mesadao = new ArrMesasDaoImpl("consulta");
		this.holdao = new HolterDaoImpl("consulta");
		this.regevextdao = new RegistradorEventosExtDaoImpl("consulta");
		
		try{
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
		}catch(Exception e1){
			// TODO 
		}
	}
	
	public void cargaMaestras(){
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			this.tipoproc = cm.getTipoprocedimiento();
			this.ritmos = cm.getRitmoSinusal();
			this.conducciones = cm.getConduccionNoNormal();
			this.qrs = cm.getQrsNoNormal();
			this.cardiopatia = cm.getCardiopatia();
			this.modogen = cm.getModoGenerador();
			this.caracterproc = cm.getCaracterProcedencia();
			this.hproc = cm.getHospitalProcedencia();
			this.pop = cm.getPrimerOperador();
			this.fabricantes = cm.getFabricanteGenerador();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
	}
	
	public void generaEstadisticasTest(ActionEvent e){
		// FRR - V DEMO
		/*this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
				"Funcionalidad deshabilitada para versión DEMO");*/
		try {
			// Si no se establece fecha fin, se pone como tope la actual
			if(this.fechafin_test==null)
				this.setFechafin_test(new Date());
			if(this.fechaini_test==null){
				try {	
					// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini_test(formatoDelTexto.parse("01-01-1900"));
				 } catch (Exception ex) {
					 ex.printStackTrace();
				   }
			}	
			List<Map> pacienteAtp = null, pacienteEpi = null, pacienteFle = null;
			String nhcs = "";
			//Busca pacientes con filtro en atp
			ArrayList<ArrayList<Object>> resatp = this.atpdao.getEstadisticas(this.getFechaini_test(), this.getFechafin_test(),this.testAtp);
			if(resatp.size() > 0){
				nhcs = "(";
				for(ArrayList<Object> test : resatp){
					nhcs += "'"+test.get(0).toString()+"'" + ",";
				}
				nhcs = nhcs.substring(0, nhcs.length()-1) + ")";
				pacienteAtp = this.pacientedao.getEstadisticas(nhcs);
			}
			//Busca pacientes con filtro en epi
			ArrayList<ArrayList<Object>> resepi = this.epidao.getEstadisticas(this.getFechaini_test(), this.getFechafin_test(),this.testEpi);
			if(resepi.size() > 0){
				nhcs = "(";
				for(ArrayList<Object> test : resepi){
					nhcs += "'"+test.get(0).toString()+"'" + ",";
				}
				nhcs = nhcs.substring(0, nhcs.length()-1) + ")";
				pacienteEpi = this.pacientedao.getEstadisticas(nhcs);
			}
			//Busca pacientes con filtro en fle
			ArrayList<ArrayList<Object>> resfle = this.fledao.getEstadisticas(this.getFechaini_test(), this.getFechafin_test(),this.testFle);
			if(resfle.size() > 0){
				nhcs = "(";
				for(ArrayList<Object> test : resfle){
					nhcs += "'"+test.get(0).toString()+"'" + ",";
				}
				nhcs = nhcs.substring(0, nhcs.length()-1) + ")";
				pacienteFle = this.pacientedao.getEstadisticas(nhcs);
			}
			
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(pacienteAtp, resatp, pacienteEpi, resepi, pacienteFle, resfle);
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
				this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}
		
	}
	
	public void generaEstadisticasCv(ActionEvent e){
		// FRR - V DEMO
		/*this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
			"Funcionalidad deshabilitada para versión DEMO");*/
		try {
			// Si no se establece fecha fin, se pone como tope la actual
			if(this.fechafin_cv==null)
				this.setFechafin_cv(new Date());
			if(this.fechaini_cv==null){
				try {	
				// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini_cv(formatoDelTexto.parse("01-01-1900"));
				 } catch (Exception ex) {
				      ex.printStackTrace();
			    }
			}	
			List<Map> paciente = null;
			String nhcs = "";
			//Busca pacientes con filtro en cv
			ArrCardioversion[] rescv = this.cvdao.getEstadisticas(this.getFechaini_cv(), this.getFechafin_cv(),this.cv);
			if(rescv.length > 0){
				nhcs = "(";
				for(ArrCardioversion test : rescv){
					nhcs += "'"+test.getNhc()+"'" + ",";
				}
				nhcs = nhcs.substring(0, nhcs.length()-1) + ")";
				paciente = this.pacientedao.getEstadisticas(nhcs);
			}
			
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(paciente, rescv);
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}
		
	}
	
	public void generaEstadisticasDai(ActionEvent e){
		// FRR - V DEMO
		/*this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
				"Funcionalidad deshabilitada para versión DEMO");*/
		try {
			List<Map> paciente = null;
			String nhcs = "";
			//Busca pacientes con filtro en dai
			ArrDesfibrilador[] resdai = this.daidao.getEstadisticas(this.dai);
			if(resdai.length > 0){
				nhcs = "(";
				for(ArrDesfibrilador test : resdai){
					nhcs += test.getCodigoPaciente() + ",";
				}
				nhcs = nhcs.substring(0, nhcs.length()-1) + ")";
				paciente = this.pacientedao.getEstadisticas(nhcs);
			}
			
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(paciente, resdai);
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}
		
	}
	
	public void generaEstadisticasEef(ActionEvent e){
		// FRR - V DEMO
		/*this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
				"Funcionalidad deshabilitada para versión DEMO");*/
		try{
			// Si no se establece fecha fin, se pone como tope la actual
			if(this.fechafin_eef==null)
				this.setFechafin_eef(new Date());
			if(this.fechaini_eef==null){
				try {	
					// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini_eef(formatoDelTexto.parse("01-01-1900"));
				 } catch (Exception ex) {
				       ex.printStackTrace();
			    }
			}				
			List<Map> paciente = null;
			List<Map> pacienteVias = null;
			List<Map> pacienteTaq = null;
			String nhcs = "", eefs = "";
			if(eef.getHllegadah() != null && eef.getHllegadah().length() > 0 && eef.getHllegadam() != null && eef.getHllegadam().length() > 0){
				if(new Integer(eef.getHllegadah()) > new Integer(eef.getHllegadam()))
					throw new Exception("El rango de edades es incorrecto");
			}
			//Busca pacientes con filtro en eef
			if(this.eef.getEscopia() == 1)
				this.ablacion = null;
			if(this.eef.getEscopia() == 2)
				this.intento = null;
			ArrayList<ArrayList<Object>> reseef = this.eefdao.getEstadisticas(this.getFechaini_eef(), this.getFechafin_eef(),this.eef, this.intento, this.ablacion);
			ArrayList<ArrayList<Object>> reseefcompabl = null;
			if(this.eef.getEscopia() == 2)
				reseefcompabl = this.eefdao.getComplicacionesAblacion(this.getFechaini_eef(), this.getFechafin_eef(),this.eef, this.ablacion);
			
			if(reseef.size() > 0){
				nhcs = "(";
				eefs = "(";
				for(ArrayList<Object> eef : reseef){
					nhcs += (eef.get(0)!=null?"'"+eef.get(0).toString()+"'":"'0'") + ",";
					//nhcs += eef.get(0).toString() + ",";
					eefs += eef.get(24).toString() + ",";
				}
				nhcs = nhcs.substring(0, nhcs.length()-1) + ")";
				eefs = eefs.substring(0, eefs.length()-1) + ")";
				paciente = this.pacientedao.getEstadisticas(nhcs);
			}
			
			ArrayList<ArrayList<Object>> resvias = this.viasdao.getEstadisticas(nhcs, eefs);
			ArrayList<ArrayList<Object>> restaq = this.taquidao.getEstadisticas(nhcs, eefs);
			
			if(resvias.size() > 0){
				nhcs = "(";
				for(ArrayList<Object> via : resvias){
					nhcs += (via.get(0)!=null?"'"+via.get(0).toString()+"'":"'0'") + ",";
					//nhcs += via.get(0).toString() + ",";
				}
				nhcs = nhcs.substring(0, nhcs.length()-1) + ")";
				pacienteVias = this.pacientedao.getEstadisticas(nhcs);
			}
			
			if(restaq.size() > 0){
				nhcs = "(";
				for(ArrayList<Object> taq : restaq){
					nhcs += (taq.get(0)!=null?"'"+taq.get(0).toString()+"'":"'0'") + ",";
					//nhcs += taq.get(0).toString() + ",";
				}
				nhcs = nhcs.substring(0, nhcs.length()-1) + ")";
				pacienteTaq = this.pacientedao.getEstadisticas(nhcs);
			}
			
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(paciente, reseef, this.eef.getEscopia(), resvias, restaq, pacienteVias, pacienteTaq, reseefcompabl);
			// frr - reestablecimiento de parametro. Si no, error
			if(this.eef.getEscopia() == 1)
				this.ablacion = new ArrEstudioAblacion();
			if(this.eef.getEscopia() == 2)
				this.intento = new ArrEstudioIntento();
			//this.ablacion = new ArrEstudioAblacion();
			//this.intento = new ArrEstudioIntento();
		}catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}
		
	}
	
	public void generaEstadisticasRegistrador(ActionEvent e){
		try{			
			// Si no se establece fecha fin, se pone como tope la actual
			if(this.fechafin_reg==null)
				this.setFechafin_reg(new Date());
			if(this.fechaini_reg==null){
				try {	
					// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini_reg(formatoDelTexto.parse("01-01-1900"));
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			}	
			
			ArrayList<ArrayList<Object>> reg_res = regdao.getEstadisticas(this.fechaini_reg, this.fechafin_reg, this.getFiltroregind());
			
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_Reg(reg_res);
			
			/*Procedimiento[] prs = this.procdao.findByDynamicWhere(
						"FECHA >=? AND FECHA <= ? AND (TIPOPROCEDIMIENTO = ? )",
						new Object[] {this.getFechaini(),this.getFechafin(),1067});			
			// Obtencion Situacion Clinica + Pacientes
			//ArrayList<SituacionClinicaProc> sitclinlist = new ArrayList<SituacionClinicaProc>();
			//SituacionClinicaProc auxsitclin = null;
			ArrayList<ArrPacientes> pacientes = new ArrayList<ArrPacientes>();
			ArrPacientes auxpat = null;
			ArrayList<ArrRegistrador> regs = new ArrayList<ArrRegistrador>();
			ArrRegistrador auxreg = null;
			for(Procedimiento p:prs){
				//auxsitclin = this.sitclindao.findByPrimaryKey(p.getIdsitclinica());
				//sitclinlist.add(auxsitclin);
				auxpat = this.patsdao.findByPrimaryKey(p.getCodigo());
				pacientes.add(auxpat);
				auxreg = this.regdao.findByPrimaryKey(p.getIdprocedimiento());
				regs.add(auxreg);
			}
			ArrayList<EstadisticasImplanteBean> resfin = obtenerHProcCaracter(pacientes);						
							
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(pacientes,prs, regs,resfin);
			*/	
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}		
	}
	public void generaEstadisticasMesa(ActionEvent e){
		try{			
			// Si no se establece fecha fin, se pone como tope la actual
			if(this.fechafin==null)
				this.setFechafin(new Date());
			if(this.fechaini==null){
				try {	
					// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini(formatoDelTexto.parse("01-01-1900"));
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			}	
			if(this.getFiltromesares()==2)
				this.setFiltromesares(0);
			else if(this.getFiltromesares()==0)
				this.setFiltromesares(-1);
			ArrayList<ArrayList<Object>> mesa_res = mesadao.getEstadisticas(this.fechaini, this.fechafin, this.getFiltromesares());
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_Mesa(mesa_res);
			
			/*
			Procedimiento[] prs = this.procdao.findByDynamicWhere(
					"FECHA >=? AND FECHA <= ? AND (TIPOPROCEDIMIENTO = ? )",
					new Object[] {this.getFechaini(),this.getFechafin(),1066});
			
			// Obtencion Situacion Clinica + Pacientes
			//ArrayList<SituacionClinicaProc> sitclinlist = new ArrayList<SituacionClinicaProc>();
			//SituacionClinicaProc auxsitclin = null;
			ArrayList<ArrPacientes> pacientes = new ArrayList<ArrPacientes>();
			ArrPacientes auxpat = null;
			ArrayList<ArrMesas> mesas = new ArrayList<ArrMesas>();
			ArrMesas auxmesa = null;
			for(Procedimiento p:prs){
				//auxsitclin = this.sitclindao.findByPrimaryKey(p.getIdsitclinica());
				//sitclinlist.add(auxsitclin);
				auxpat = this.patsdao.findByPrimaryKey(p.getCodigo());
				pacientes.add(auxpat);
				auxmesa = this.mesadao.findByPrimaryKey(p.getIdprocedimiento());
				mesas.add(auxmesa);
			}
			ArrayList<EstadisticasImplanteBean> resfin = obtenerHProcCaracter(pacientes);						
					
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_(pacientes,prs,mesas,resfin);
			*/		
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}		
		
	}
	public void generaEstadisticasHolter(ActionEvent e){
		try{			
			// Si no se establece fecha fin, se pone como tope la actual
			if(this.fechafin_hol==null)
				this.setFechafin_hol(new Date());
			if(this.fechaini_hol==null){
				try {	
					// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini_hol(formatoDelTexto.parse("01-01-1900"));
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			}				
			ArrayList<ArrayList<Object>> hol_res = holdao.getEstadisticas(this.fechaini_hol, this.fechafin_hol, this.getFiltroholdiag());
			
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_Hol(hol_res);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}		
	}
	public void generaEstadisticasRegEvExt(ActionEvent e){
		try{			
			// Si no se establece fecha fin, se pone como tope la actual
			if(this.fechafin_regevext==null)
				this.setFechafin_regevext(new Date());
			if(this.fechaini_regevext==null){
				try {	
					// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini_regevext(formatoDelTexto.parse("01-01-1900"));
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			}				
			ArrayList<ArrayList<Object>> regevext_res = regevextdao.getEstadisticas(this.fechaini_regevext, this.fechafin_regevext, this.getFiltroregevextdiag());
			
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_RegEvExt(regevext_res);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}		
	}
	public void generarEstadisticasImplantes(ActionEvent e){
		if(this.tipodispositivo==1)
			generaEstadisticasImplanteBradi(1,3,5);
		else if(this.tipodispositivo==2)
			generaEstadisticasImplanteTaqui(2,4,6);
		else if(this.tipodispositivo==3)
			generaEstadisticasImplanteTaqui(3,4,0);// se usa el modelo de taqui que es mas completo
		else if(this.tipodispositivo==4)
			generaEstadisticasImplanteBradi(1,5,0);
		else if(this.tipodispositivo==5)
			generaEstadisticasImplanteTaqui(2,6,0);
		else if(this.tipodispositivo==6)
			generaEstadisticasImplanteBradi(3,0,0);
		else if(this.tipodispositivo==7)
			generaEstadisticasImplanteTaqui(4,0,0);
		else if(this.tipodispositivo==0)
			generaEstadisticasImplanteTodos();
		else
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, "Debe indicar un tipo de dispositivo para generar estadísticas");
			
	}
	public void generaEstadisticasImplanteBradi(int tipo1, int tipo2, int tipo3){
		try{					
			// Si no se establece fecha fin, se pone como tope la actual
			if(this.fechafin_imp==null)
				this.setFechafin_imp(new Date());
			if(this.fechaini_imp==null){
				try {	
					// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini_imp(formatoDelTexto.parse("01-01-1900"));
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			}
			ArrayList<ArrayList<Object>> res_imp_br = this.impdao.getEstadisticasBradi(this.proc.getTipoprocedimiento(), this.getFiltroritmo(), this.getFiltrocav(), this.getFiltroqrs(), this.getFiltromodo(), this.getFiltromodelo(), this.getFiltrofab(),this.getFechaini_imp(),this.getFechafin_imp(),String.valueOf(tipo1),String.valueOf(tipo2),String.valueOf(tipo3));
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(res_imp_br,1);
			
			
			/*** Filtro de procedimiento **/
			/*Procedimiento[] resprocmp;
			if(this.proc.getTipoprocedimiento()==0){
				resprocmp = this.procdao.findByDynamicWhere(
						"FECHA >=? AND FECHA <= ? AND (TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?  OR TIPOPROCEDIMIENTO = ?  OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?)",
						new Object[] {this.getFechaini(),this.getFechafin(),956, 957, 993,1059,1060,1085,1147 });
			}else{
				resprocmp = this.procdao.findByDynamicWhere(
						"FECHA >=? AND FECHA <= ? AND (TIPOPROCEDIMIENTO = ? )",
						new Object[] {this.getFechaini(),this.getFechafin(),this.proc.getTipoprocedimiento()});
			}
								
			ArrayList<ImpImplante> implist = new ArrayList<ImpImplante>();
			for(Procedimiento p:resprocmp)
				implist.add(this.impdao.findByPrimaryKey(p.getIdprocedimiento()));			
			
			
			ArrayList<ImpHojaImplante> himplist = new ArrayList<ImpHojaImplante>();
			for(ImpImplante i:implist)
				himplist.add(this.himpdao.findByPrimaryKey(i.getIdhojaimp()));
			
			ArrayList<ImpGenerador> impgenlist = new ArrayList<ImpGenerador>();
			ImpGenerador[] igen = new ImpGenerador[1];
			for(ImpHojaImplante hi:himplist){
				igen = this.gendao.findWhereIdhojaimpEquals(hi.getIdhojaimp());
				impgenlist.add(igen[0]);
			}
			// Obtencion ImpGenerador = MP + Generador			
			Generador gen = null;
			ArrayList<ImpGenerador> resimpgenlist = new ArrayList<ImpGenerador>();
			ArrayList<Generador> gens = new ArrayList<Generador>();
			for(ImpGenerador g:impgenlist){
				gen = this.gdao.findByPrimaryKey(g.getIdgenerador());
				if(gen.getTipo().equals(String.valueOf(tipo1)) || gen.getTipo().equals(String.valueOf(tipo2))){
					resimpgenlist.add(g);
					gens.add(gen);
				}				
			}		
			// Obtencion Himp
			//ArrayList<ImpHojaImplante> reshimp = new ArrayList<ImpHojaImplante>();
			himplist.clear();// reutilizacion lista ImpHojaImlante. Se vacia y se rellena con los valores que interesan
			ImpHojaImplante auxhimp = null;
			for(ImpGenerador g:resimpgenlist){
				auxhimp = this.himpdao.findByPrimaryKey(g.getIdhojaimp());
				//reshimp.add(auxhimp);
				himplist.add(auxhimp);
			}
			// Obtencion Implantes
			implist.clear();// reutilizacion lista ImpImlante. Se vacia y se rellena con los valores que interesan
			ImpImplante[] auximp = new ImpImplante[1];
			for(ImpHojaImplante hi:himplist){
				auximp = this.impdao.findWhereIdhojaimpEquals(hi.getIdhojaimp());
				implist.add(auximp[0]);
			}
			// Obtencion Evolucion + Procedimiento
			ArrayList<ImpEvolucion> evlist = new ArrayList<ImpEvolucion>();
			ImpEvolucion auxevo = null;
			ArrayList<Procedimiento> prlist = new ArrayList<Procedimiento>();
			Procedimiento[] auxpr = new Procedimiento[1];
			for(ImpImplante im:implist){
				auxevo = this.evodao.findByPrimaryKey(im.getIdev());
				auxpr = this.procdao.findWhereIdprocedimientoEquals(im.getIdimplante());
				prlist.add(auxpr[0]);
				evlist.add(auxevo);
			}
			// Obtencion Situacion Clinica + Pacientes
			ArrayList<SituacionClinicaProc> sitclinlist = new ArrayList<SituacionClinicaProc>();
			SituacionClinicaProc auxsitclin = null;
			ArrayList<ArrPacientes> pacientes = new ArrayList<ArrPacientes>();
			ArrPacientes auxpat = null;
			for(Procedimiento p:prlist){
				auxsitclin = this.sitclindao.findByPrimaryKey(p.getIdsitclinica());
				sitclinlist.add(auxsitclin);
				auxpat = this.patsdao.findByPrimaryKey(p.getCodigo());
				pacientes.add(auxpat);
			}
			ArrayList<EstadisticasImplanteBean> auxestadistica = preparaEstadisticaImplante(sitclinlist,prlist,himplist,evlist,pacientes);
					
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(pacientes,sitclinlist,himplist,evlist,resimpgenlist,gens,prlist, auxestadistica,tipo1);
			*/
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}	
	}
	public void generaEstadisticasImplanteTaqui(int tipo1, int tipo2, int tipo3){
		try{
			if(this.fechafin_imp==null)
				this.setFechafin_imp(new Date());
			if(this.fechaini_imp==null){
				try {	
					// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini_imp(formatoDelTexto.parse("01-01-1900"));
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			}
			ArrayList<ArrayList<Object>> res_imp_tq = this.impdao.getEstadisticasTaqui(this.proc.getTipoprocedimiento(), this.getFiltroritmo(), this.getFiltrocav(), this.getFiltroqrs(), this.getFiltromodo(), this.getFiltromodelo(), this.getFiltrofab(),this.getFechaini_imp(),this.getFechafin_imp(),String.valueOf(tipo1),String.valueOf(tipo2),String.valueOf(tipo3));
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(res_imp_tq,2);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}
	}
	public void generaEstadisticasImplanteTodos(){
		try{
			if(this.fechafin_imp==null)
				this.setFechafin_imp(new Date());
			if(this.fechaini_imp==null){
				try {	
					// poner fecha inicial por defecto - 01-01-1900
					SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");     
					this.setFechaini_imp(formatoDelTexto.parse("01-01-1900"));
			     } catch (Exception ex) {
			         ex.printStackTrace();
			     }
			}
			ArrayList<ArrayList<Object>> res_imp_1 = this.impdao.getEstadisticasTaqui(this.proc.getTipoprocedimiento(), this.getFiltroritmo(), this.getFiltrocav(), this.getFiltroqrs(), this.getFiltromodo(), this.getFiltromodelo(), this.getFiltrofab(),this.getFechaini_imp(),this.getFechafin_imp(),"1","3","5");
			ArrayList<ArrayList<Object>> res_imp_2 = this.impdao.getEstadisticasTaqui(this.proc.getTipoprocedimiento(), this.getFiltroritmo(), this.getFiltrocav(), this.getFiltroqrs(), this.getFiltromodo(), this.getFiltromodelo(), this.getFiltrofab(),this.getFechaini_imp(),this.getFechafin_imp(),"2","4","6");
			//ArrayList<ArrayList<Object>> res_imp_3 = this.impdao.getEstadisticasTaqui(this.proc.getTipoprocedimiento(), this.getFiltroritmo(), this.getFiltrocav(), this.getFiltroqrs(), this.getFiltromodo(), this.getFiltromodelo(), this.getFiltrofab(),this.getFechaini_imp(),this.getFechafin_imp(),"5","6");
			// Union de listas
			ArrayList<ArrayList<Object>> res = new ArrayList<ArrayList<Object>>();
			res.addAll(res_imp_1);
			res.addAll(res_imp_2);
			//res.addAll(res_imp_3);
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel(res,3);
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("info_msg_error_estadisticas")+": " + e1.getMessage());
		}
	}
	public ArrayList<EstadisticasImplanteBean> obtenerHProcCaracter(ArrayList<ArrPacientes> pacientes){
		ArrayList<EstadisticasImplanteBean> resfin = new ArrayList<EstadisticasImplanteBean>();
		EstadisticasImplanteBean res = null;
		for(int j=0;j<pacientes.size();j++){
			res = new EstadisticasImplanteBean();
			for (SelectItem i : this.getCaracterproc()) {
				if (i.getValue().toString().equals(pacientes.get(j).getProcedencia().toString())) {
					res.setCaracterproc(i.getLabel());
					resfin.add(res);
					//resfin.get(j).setCaracterproc(i.getLabel());
					break;
				}
			}
			for (SelectItem i : this.getHproc()) {
				if (i.getValue().toString().equals(pacientes.get(j).getHprocedencia().toString())) {
					res.setHospitalproc(i.getLabel());
					resfin.add(res);					
					//resfin.get(j).setHospitalproc(i.getLabel());
					break;
				}
			}
		}
		return resfin;
	}
	
	public ArrayList<EstadisticasImplanteBean> preparaEstadisticaImplante(ArrayList<SituacionClinicaProc> sc, 
			ArrayList<Procedimiento> prs, ArrayList<ImpHojaImplante> himps, ArrayList<ImpEvolucion> evlist,
			ArrayList<ArrPacientes> pacientes){
		ArrayList<EstadisticasImplanteBean> resfin = new ArrayList<EstadisticasImplanteBean>();			
		EstadisticasImplanteBean res = null;
		for(SituacionClinicaProc sitclin:sc){
			res = new  EstadisticasImplanteBean();
			for (SelectItem i : this.getRitmos()) {
				if (i.getValue().toString().equals(sitclin.getRitmo().toString())) {
					res.setRitmo(i.getLabel());
					break;
				}
			}
			for (SelectItem i : this.getConducciones()) {
				if (i.getValue().toString()
						.equals(sitclin.getConducav().toString())) {
					res.setConduccionav(i.getLabel());
					break;
				}
			}
			for (SelectItem i : this.getQrs()) {
				if (i.getValue().toString().equals(sitclin.getQrs().toString())) {
					res.setQrs(i.getLabel());
					break;
				}
			}
			if(sitclin.getCardiopatia()!=null)
				for (SelectItem i : this.getCardiopatia()) {
					if (i.getValue().toString()
							.equals(sitclin.getCardiopatia().toString())) {
						res.setCardiopatia(i.getLabel());
						break;
					}
				}
			if(sitclin.getAfectiroidea()!=null)
				if(sitclin.getAfectiroidea()==1)
					res.setAfectiroidea(this.bundle.getString("sc_antecedentes_nc_tir_msg_2"));
				else if(sitclin.getAfectiroidea()==2)
					res.setAfectiroidea(this.bundle.getString("sc_antecedentes_nc_tir_msg_3"));
				else
					res.setAfectiroidea("");
			if(sitclin.getNeuromediados()!=null)
				if(sitclin.getNeuromediados()==1)
					res.setNeuromediados(this.bundle.getString("sc_antecedentes_nc_neur_msg_2"));
				else if(sitclin.getNeuromediados()==2)
					res.setNeuromediados(this.bundle.getString("sc_antecedentes_nc_neur_msg_3"));
				else if(sitclin.getNeuromediados()==3)
					res.setNeuromediados(this.bundle.getString("sc_antecedentes_nc_neur_msg_4"));
				else
					res.setNeuromediados("");
			if(sitclin.getFuncionventricular()!=null)
				if(sitclin.getFuncionventricular()==1)
					res.setFuncionventricular(">50");
				else if(sitclin.getFuncionventricular()==2)
					res.setFuncionventricular("41-50");
				else if(sitclin.getFuncionventricular()==3)
					res.setFuncionventricular("36-40");
				else if(sitclin.getFuncionventricular()==4)
					res.setFuncionventricular("31-35");
				else if(sitclin.getFuncionventricular()==5)
					res.setFuncionventricular("<30");
				else
					res.setFuncionventricular("");
			
			resfin.add(res);
		}
		for(int j=0;j<prs.size();j++){
			for (SelectItem i : this.getTipoproc()) {
				if (i.getValue().toString().equals(prs.get(j).getTipoprocedimiento().toString())) {
					resfin.get(j).setTipoproc(i.getLabel());
					break;
				}
			}
		}
		String enf="",pop="",sop="";
		for(int j=0;j<himps.size();j++){
			try {
				enf="";pop="";sop="";
				ImpHojaImplanteEnf[] enflist = this.enfdao.findWhereIdhojaimpEquals(himps.get(j).getIdhojaimp());
				for(ImpHojaImplanteEnf e:enflist){
					enf = enf + e.getIdenf()+"\n";
				}
				ImpHojaImplantePop[] poplist = this.popdao.findWhereIdhojaimpEquals(himps.get(j).getIdhojaimp());
				for(ImpHojaImplantePop e:poplist){
					pop = pop + e.getIdop()+"\n";
				}
				ImpHojaImplanteSop[] soplist = this.sopdao.findWhereIdhojaimpEquals(himps.get(j).getIdhojaimp());
				for(ImpHojaImplanteSop e:soplist){
					sop = sop + e.getIdop()+"\n";
				}
				resfin.get(j).setEnf(enf);
				resfin.get(j).setPop(pop);
				resfin.get(j).setSop(sop);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		for(int j=0;j<evlist.size();j++){
			for (SelectItem i : this.getModogen()) {
				if (i.getValue().toString().equals(evlist.get(j).getModogen().toString())) {
					resfin.get(j).setModo(i.getLabel());
					break;
				}
			}
		}
		for(int j=0;j<pacientes.size();j++){
			for (SelectItem i : this.getCaracterproc()) {
				if (i.getValue().toString().equals(pacientes.get(j).getProcedencia().toString())) {
					resfin.get(j).setCaracterproc(i.getLabel());
					break;
				}
			}
			for (SelectItem i : this.getHproc()) {
				if (i.getValue().toString().equals(pacientes.get(j).getHprocedencia().toString())) {
					resfin.get(j).setHospitalproc(i.getLabel());
					break;
				}
			}
		}
		return resfin;
	}
	public void cargaGeneradores() {
		try {
			this.g = new GeneradorDaoImpl("consulta");
			this.generadores = this.g.findAll();
		} catch (Exception e1) {
			this.pintaMensaje(
					Mensaje.SEVERIDAD_ERROR,
					"No se pueden recuperar generadores. Error: "
							+ e1.getMessage());
		}
	}
	public ArrayList<SelectItem> getRitmos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("-1", "(Seleccione opción)"));
		//diag.add(new SelectItem("0", "NO ESPECIFICADO"));
		diag.add(new SelectItem("-1", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.ritmos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getConducciones() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("-1", "(Seleccione opción)"));
		//diag.add(new SelectItem("0", "NO ESPECIFICADO"));
		diag.add(new SelectItem("-1", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.conducciones)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		
		return diag;
	}
	public ArrayList<SelectItem> getQrs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("-1", this.bundle.getString("seleccione_opcion")));
		//diag.add(new SelectItem("0", "NO ESPECIFICADO"));
		diag.add(new SelectItem("-1", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras diagnostico : this.qrs)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	public ArrayList<SelectItem> getCardiopatia() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras cardio : this.cardiopatia)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio
					.getValor()));
		return cp;
	}
	public ArrayList<SelectItem> getTipoproc() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras cardio : this.tipoproc)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio
					.getValor()));
		return cp;
	}
	public ArrayList<SelectItem> getModogen() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("0", "(Seleccion opción)"));
		for (ArrMaestras cardio : this.modogen)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio
					.getValor()));
		return cp;
	}
	public ArrayList<SelectItem> getCaracterproc() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("0", ""));
		for (ArrMaestras cardio : this.caracterproc)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio
					.getValor()));
		return cp;
	}
	public ArrayList<SelectItem> getHproc() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("0", ""));
		for (ArrMaestras cardio : this.hproc)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio
					.getValor()));
		return cp;
	}
	public ArrayList<SelectItem> getPop() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras cardio : this.pop)
			cp.add(new SelectItem(cardio.getCodigo().toString(), cardio
					.getValor()));
		return cp;
	}
	public ArrayList<SelectItem> getGeneradores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (Generador ref : this.generadores)
			if(ref.getTipo()!=null && (ref.getTipo().equals("1")|| ref.getTipo().equals("3")))
				diag.add(new SelectItem(ref.getModelo(), ref.getModelo()));
		return diag;
	}
	public ArrayList<SelectItem> getFabricantes() {
		ArrayList<SelectItem> cp = new ArrayList<SelectItem>();
		cp.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras cardio : this.fabricantes)
			cp.add(new SelectItem(cardio.getValor(), cardio.getValor()));
		return cp;
	}
	
	public ArrTestAtp getTestAtp() {
		return testAtp;
	}

	public void setTestAtp(ArrTestAtp testAtp) {
		this.testAtp = testAtp;
	}

	public ArrTestEpi getTestEpi() {
		return testEpi;
	}

	public void setTestEpi(ArrTestEpi testEpi) {
		this.testEpi = testEpi;
	}

	public ArrTestFle getTestFle() {
		return testFle;
	}

	public void setTestFle(ArrTestFle testFle) {
		this.testFle = testFle;
	}

	public ArrCardioversion getCv() {
		return cv;
	}

	public void setCv(ArrCardioversion cv) {
		this.cv = cv;
	}

	public ArrEstudio getEef() {
		return eef;
	}

	public void setEef(ArrEstudio eef) {
		this.eef = eef;
	}

	public ArrEstudioIntento getIntento() {
		return intento;
	}

	public void setIntento(ArrEstudioIntento intento) {
		this.intento = intento;
	}

	public ArrEstudioAblacion getAblacion() {
		return ablacion;
	}

	public void setAblacion(ArrEstudioAblacion ablacion) {
		this.ablacion = ablacion;
	}

	public ArrDesfibrilador getDai() {
		return dai;
	}

	public void setDai(ArrDesfibrilador dai) {
		this.dai = dai;
	}

	public Procedimiento getProc() {
		return proc;
	}

	public void setProc(Procedimiento proc) {
		this.proc = proc;
	}

	public Date getFechaini() {
		return fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}

	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public int getFiltroritmo() {
		return filtroritmo;
	}

	public void setFiltroritmo(int filtroritmo) {
		this.filtroritmo = filtroritmo;
	}

	public int getFiltrocav() {
		return filtrocav;
	}

	public void setFiltrocav(int filtrocav) {
		this.filtrocav = filtrocav;
	}

	public int getFiltroqrs() {
		return filtroqrs;
	}

	public void setFiltroqrs(int filtroqrs) {
		this.filtroqrs = filtroqrs;
	}

	

	public int getFiltromodo() {
		return filtromodo;
	}

	public void setFiltromodo(int filtromodo) {
		this.filtromodo = filtromodo;
	}

	public String getFiltromodelo() {
		return filtromodelo;
	}

	public void setFiltromodelo(String filtromodelo) {
		this.filtromodelo = filtromodelo;
	}

	public int getTipodispositivo() {
		return tipodispositivo;
	}

	public void setTipodispositivo(int tipodispositivo) {
		this.tipodispositivo = tipodispositivo;
	}

	public Date getFechaini_imp() {
		return fechaini_imp;
	}

	public void setFechaini_imp(Date fechaini_imp) {
		this.fechaini_imp = fechaini_imp;
	}

	public Date getFechafin_imp() {
		return fechafin_imp;
	}

	public void setFechafin_imp(Date fechafin_imp) {
		this.fechafin_imp = fechafin_imp;
	}

	public String getFiltrofab() {
		return filtrofab;
	}

	public void setFiltrofab(String filtrofab) {
		this.filtrofab = filtrofab;
	}

	public int getFiltroregind() {
		return filtroregind;
	}

	public void setFiltroregind(int filtroregind) {
		this.filtroregind = filtroregind;
	}

	public int getFiltromesares() {
		return filtromesares;
	}

	public void setFiltromesares(int filtromesares) {
		this.filtromesares = filtromesares;
	}

	public Date getFechaini_eef() {
		return fechaini_eef;
	}

	public void setFechaini_eef(Date fechaini_eef) {
		this.fechaini_eef = fechaini_eef;
	}

	public Date getFechafin_eef() {
		return fechafin_eef;
	}

	public void setFechafin_eef(Date fechafin_eef) {
		this.fechafin_eef = fechafin_eef;
	}

	public Date getFechaini_test() {
		return fechaini_test;
	}

	public void setFechaini_test(Date fechaini_test) {
		this.fechaini_test = fechaini_test;
	}

	public Date getFechafin_test() {
		return fechafin_test;
	}

	public void setFechafin_test(Date fechafin_test) {
		this.fechafin_test = fechafin_test;
	}

	public Date getFechaini_cv() {
		return fechaini_cv;
	}

	public void setFechaini_cv(Date fechaini_cv) {
		this.fechaini_cv = fechaini_cv;
	}

	public Date getFechafin_cv() {
		return fechafin_cv;
	}

	public void setFechafin_cv(Date fechafin_cv) {
		this.fechafin_cv = fechafin_cv;
	}

	public Date getFechaini_reg() {
		return fechaini_reg;
	}

	public void setFechaini_reg(Date fechaini_reg) {
		this.fechaini_reg = fechaini_reg;
	}

	public Date getFechafin_reg() {
		return fechafin_reg;
	}

	public void setFechafin_reg(Date fechafin_reg) {
		this.fechafin_reg = fechafin_reg;
	}

	public Date getFechaini_hol() {
		return fechaini_hol;
	}

	public void setFechaini_hol(Date fechaini_hol) {
		this.fechaini_hol = fechaini_hol;
	}

	public Date getFechafin_hol() {
		return fechafin_hol;
	}

	public void setFechafin_hol(Date fechafin_hol) {
		this.fechafin_hol = fechafin_hol;
	}

	public int getFiltroholdiag() {
		return filtroholdiag;
	}

	public void setFiltroholdiag(int filtroholdiag) {
		this.filtroholdiag = filtroholdiag;
	}

	public Date getFechaini_regevext() {
		return fechaini_regevext;
	}

	public void setFechaini_regevext(Date fechaini_regevext) {
		this.fechaini_regevext = fechaini_regevext;
	}

	public Date getFechafin_regevext() {
		return fechafin_regevext;
	}

	public void setFechafin_regevext(Date fechafin_regevext) {
		this.fechafin_regevext = fechafin_regevext;
	}

	public int getFiltroregevextdiag() {
		return filtroregevextdiag;
	}

	public void setFiltroregevextdiag(int filtroregevextdiag) {
		this.filtroregevextdiag = filtroregevextdiag;
	}

	
}

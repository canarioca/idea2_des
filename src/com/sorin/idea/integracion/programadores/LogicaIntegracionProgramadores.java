package com.sorin.idea.integracion.programadores;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import com.sorin.idea.dao.ArrPacientesDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dao.ImpAtpDao;
import com.sorin.idea.dao.ImpChoquesDao;
import com.sorin.idea.dao.ImpEvolucionDao;
import com.sorin.idea.dao.ImpGeneradorDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.ImpImplanteElectrodosDao;
import com.sorin.idea.dao.ImpZonaDao;
import com.sorin.idea.dao.InformesDao;
import com.sorin.idea.dao.IntElectrodosDao;
import com.sorin.idea.dao.IntImplantesDao;
import com.sorin.idea.dao.IntPacientesDao;
import com.sorin.idea.dao.IntPendientesDao;
import com.sorin.idea.dao.IntegracionesInformesDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.SegBloqueosDao;
import com.sorin.idea.dao.SegObservacionesDaiDao;
import com.sorin.idea.dao.SegObservacionesMpDao;
import com.sorin.idea.dao.SegPorestimulacionDao;
import com.sorin.idea.dao.SegSeguimientoDao;
import com.sorin.idea.dao.SegSistemaDao;
import com.sorin.idea.dao.SituacionClinicaGeneralDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpAtp;
import com.sorin.idea.dto.ImpAtpPk;
import com.sorin.idea.dto.ImpChoques;
import com.sorin.idea.dto.ImpChoquesPk;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpEvolucionPk;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpImplanteElectrodosPk;
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.ImpZonaPk;
import com.sorin.idea.dto.Informes;
import com.sorin.idea.dto.IntElectrodos;
import com.sorin.idea.dto.IntImplantes;
import com.sorin.idea.dto.IntPacientes;
import com.sorin.idea.dto.IntPendientes;
import com.sorin.idea.dto.IntPendientesPk;
import com.sorin.idea.dto.IntegracionesInformes;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProcedimientoPk;
import com.sorin.idea.dto.SegBloqueos;
import com.sorin.idea.dto.SegBloqueosPk;
import com.sorin.idea.dto.SegObservacionesDai;
import com.sorin.idea.dto.SegObservacionesDaiPk;
import com.sorin.idea.dto.SegObservacionesMp;
import com.sorin.idea.dto.SegObservacionesMpPk;
import com.sorin.idea.dto.SegPorestimulacion;
import com.sorin.idea.dto.SegPorestimulacionPk;
import com.sorin.idea.dto.SegSeguimiento;
import com.sorin.idea.dto.SegSeguimientoPk;
import com.sorin.idea.dto.SegSistema;
import com.sorin.idea.dto.SegSistemaPk;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.SituacionClinicaProcPk;
import com.sorin.idea.iu.ControlAccesos;
import com.sorin.idea.iu.ControlSeguimientos;
import com.sorin.idea.jdbc.ArrPacientesDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpAtpDaoImpl;
import com.sorin.idea.jdbc.ImpChoquesDaoImpl;
import com.sorin.idea.jdbc.ImpEvolucionDaoImpl;
import com.sorin.idea.jdbc.ImpGeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteElectrodosDaoImpl;
import com.sorin.idea.jdbc.ImpZonaDaoImpl;
import com.sorin.idea.jdbc.InformesDaoImpl;
import com.sorin.idea.jdbc.IntElectrodosDaoImpl;
import com.sorin.idea.jdbc.IntImplantesDaoImpl;
import com.sorin.idea.jdbc.IntPacientesDaoImpl;
import com.sorin.idea.jdbc.IntPendientesDaoImpl;
import com.sorin.idea.jdbc.IntegracionesInformesDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.jdbc.SegBloqueosDaoImpl;
import com.sorin.idea.jdbc.SegObservacionesDaiDaoImpl;
import com.sorin.idea.jdbc.SegObservacionesMpDaoImpl;
import com.sorin.idea.jdbc.SegPorestimulacionDaoImpl;
import com.sorin.idea.jdbc.SegSeguimientoDaoImpl;
import com.sorin.idea.jdbc.SegSistemaDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaGeneralDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.GestorHL7;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilFiles;
import com.sorin.idea.util.UtilMapeos;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v25.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.segment.OBX;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageStringIterator;


public class LogicaIntegracionProgramadores {

	private static Logger logger = Logger.getLogger(LogicaIntegracionProgramadores.class);
	private static String PATH_HL7;
	private static String PATH_INFORMES_SEG;
	private static Properties prop;
	
	private static java.sql.Connection conn;
	
	private static ImpGeneradorDao gendao;
	private static ImpImplanteElectrodosDao impelecdao;
	private static ImpImplanteDao impdao;
	private static GeneradorDao generadordao;
	private static Conversor conv;
	
	private static InformesDao infdao;
	
	
	public LogicaIntegracionProgramadores(){
		//this.gendao = new ImpGeneradorDaoImpl("Integracion");
		//this.impelecdao = new ImpImplanteElectrodosDaoImpl("Integracion");
		//this.impdao = new ImpImplanteDaoImpl("Integracion");
		lecturaProperties();
	}
	
	public static String test(String oru){
		logger.info("Rx: "+oru);
		return "OK PAKITO!!";
	}
	
	public String procesaORU(ORU_R01 oruMsg, ADT_A01 adtMsg){
		String ack="";
		String respuesta="";// nueva version SID
		try {
			List<ORU_R01_OBSERVATION> lista = oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll();
			String infogen = oruMsg.getPATIENT_RESULT().getPATIENT().getPID().getPid3_PatientIdentifierList(0).getIDNumber().getValue();
			String tiposeg = oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr4_UniversalServiceIdentifier().getIdentifier().getValue();
			String numseriegen = GestorHL7.obtenerValorOBX("720899",lista); 
			String modelo = GestorHL7.obtenerValorOBX("720898",lista);
			String mnf = GestorHL7.obtenerValorOBX("720900",lista);
			String fechaseg = oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr7_ObservationDateTime().getTime().getValue();
			String idmsg = oruMsg.getMSH().getMessageControlID().getValue();
			boolean remoto = (oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr4_UniversalServiceIdentifier().getCe1_Identifier().getValue().equals("REMOTO")?true:false);
			// Obtencion de sistema: manufacturer + remota
			Integer idsistema = UtilMapeos.getSistema(mnf, remoto);
			logger.info("Integraci�n de Procedimiento de Seguimiento. Info Generador - "+infogen+". Tipo de seguimiento: "+tiposeg+". Fecha: "+fechaseg+". ID Mensaje: "+idmsg);
			int codigo = existeSeguimiento(modelo,numseriegen,fechaseg,mnf);
			String fecha=UtilFechas.getFechaStringFormato(new Date(), "yyyyMMdd");
			// Pre escritura ACK
			ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+fecha+"||ACK^R01|"+idmsg+"|P|2.5|"+"\rMSA|AE|"+idmsg+"|";
			respuesta = "310";
			/*if(codigo==0){ //CASO 1
				ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+fecha+"||ACK^R01|"+idmsg+"|P|2.5|"+"MSA|AE|"+idmsg+"|Error en integracion de evento seguimiento. Existen registros de seguimiento para la fecha especificada|";
				logger.error("No se puede integrar procedimiento de seguimiento.");
			}else */if(codigo==-1){
				//ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+fecha+"||ACK^R01|"+idmsg+"|P|2.5|"+"MSA|AE|"+idmsg+"|Error en integracion de evento seguimiento. No existe el generador con info "+infogen+"|";
				//logger.error("No se puede integrar procedimiento de seguimiento. No existe el generador con info "+infogen);
				// TODO CASOS 2.1 y 2.2 - gestion de ADT_A04
				if(Validador.validarDemograficos(adtMsg)){
					//if(Validador.validarSistemaImplantado(oruMsg)){
						// CREAR SOLICITUDES DE PACIENTE, IMPLANTE Y SEGUIMIENTO
						int resp = procesaSolicitudIntegracion(adtMsg,oruMsg);
						if(resp == 0){
							ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+fecha+"||ACK^R01|"+idmsg+"|P|2.5|"+"\rMSA|AA|"+idmsg+"|0|";
							respuesta = "312";
							logger.info("Solicitud de integraci�n creada correctamente.");
						}else{
							/*
							 * r = -111 -> Error de conexion con BD
							 * r = -112 -> Error de insercion de ORU en local
							 * r = -113 -> Error interno de insercion de solicitud
							 */
							ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+fecha+"||ACK^R01|"+idmsg+"|P|2.5|"+"\rMSA|AE|"+idmsg+"|"+resp+"|";
							respuesta = conversorValores(String.valueOf(resp));
							logger.error("No se puede crear solicitud de seguimiento. Motivo: "+resp);
						}
						// controlar error de insercion de solicitudes (-3)
					/*}else{
						ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+fecha+"||ACK^R01|"+idmsg+"|P|2.5|"+"\rMSA|AR|"+idmsg+"|-2|";
						logger.error("No se puede crear solicitud de seguimiento. Datos de sistema implantado insuficientes.");
					}*/
				}else{
					ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+fecha+"||ACK^R01|"+idmsg+"|P|2.5|"+"\rMSA|AR|"+idmsg+"|-1|";
					respuesta = "305";
					logger.error("No se puede crear solicitud de seguimiento. Datos demogr�ficos insuficientes.");
					insertaLogIntegracion(idsistema,UtilFechas.StringToDateFormato(fechaseg, "yyyyMMdd"),null,null,modelo,numseriegen,null,-4,"Datos demogr�ficos insuficientes para crear solicitud",null);
				}
			}else{// Crear nuevo seguimiento - CASO 1
				int r = creaNuevoSeguimiento(numseriegen,codigo,lista,UtilFechas.dateHL7StringToDateString(fechaseg),remoto);
				if(r != 1){
					/*
					 * r = -100 -> Error de conexion con BD
					 * r = -101 -> No existe implante asociado
					 * r = -102 -> Error interno de almacenamiento
					 */
					ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+fecha+"||ACK^R01|"+idmsg+"|P|2.5|"+"\rMSA|AE|"+idmsg+"|"+String.valueOf(r)+"|";
					respuesta = conversorValores(String.valueOf(r));
					logger.error("No se puede integrar procedimiento de seguimiento. Error de insercion interno");
					insertaLogIntegracion(idsistema,UtilFechas.StringToDateFormato(fechaseg, "yyyyMMdd"),null,null,modelo,numseriegen,null,-2,"Error de inserci�n de registro en IDEA",null);
				}else{
					ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+fecha+"||ACK^R01|"+idmsg+"|P|2.5|"+"\rMSA|AA|"+idmsg+"|1|";
					respuesta = "311";
					logger.info("Integraci�n de Procedimiento de Seguimiento finalizada con exito");
					insertaLogIntegracion(idsistema,UtilFechas.StringToDateFormato(fechaseg, "yyyyMMdd"),null,null,modelo,numseriegen,null,1,null,null);
				}	
			}		
		}catch (HL7Exception e) {
			logger.error("Error de procesamiento de ORU_R01. Motivo: "+e.getMessage(),e);
			ack = ack+"-5|";
			respuesta = "309";
			e.printStackTrace();
		}catch(Exception e){
			logger.error("Error de procesamiento. Motivo: "+e.getMessage(),e);
			ack = ack+"-6|";
			respuesta = "308";
			e.printStackTrace();
		}
		//return ack;
		return respuesta;
	}
	public String procesaACK(ACK ack_msg){
		String ack="";
		try{
			// 1. Obtencion de par�metros
			String fecha=UtilFechas.getFechaStringFormato(new Date(), "yyyyMMdd");
			String sistema = ack_msg.getMSH().getMsh4_SendingFacility().getHd1_NamespaceID().getValue();
			Integer idsistema = Integer.parseInt(ack_msg.getMSH().getMsh4_SendingFacility().getHd2_UniversalID().getValue());
			String nombre_fichero=ack_msg.getMSH().getMsh10_MessageControlID().getValue();
			Date fecha_rx=ack_msg.getMSH().getMsh7_DateTimeOfMessage().getTime().getValueAsCalendar().getTime();
			String nombre_aps=ack_msg.getMSH().getMsh6_ReceivingFacility().getHd1_NamespaceID().getValue();
			String nhc=ack_msg.getMSH().getMsh6_ReceivingFacility().getHd2_UniversalID().getValue();
			String modelo=ack_msg.getMSH().getMsh5_ReceivingApplication().getHd1_NamespaceID().getValue();
			String nserie=ack_msg.getMSH().getMsh5_ReceivingApplication().getHd2_UniversalID().getValue();
			String desc_error = ack_msg.getERR().getErr3_HL7ErrorCode().getCwe2_Text().getValue();
			// 2. Insercion en BD
			insertaLogIntegracion(idsistema,fecha_rx,nhc,nombre_aps,modelo,nserie,nombre_fichero,-1,desc_error,null);
		}catch (HL7Exception e) {
			logger.error("Error de procesamiento de ACK. Motivo: "+e.getMessage(),e);
			e.printStackTrace();
		}catch(Exception e){
			logger.error("Error de procesamiento. Motivo: "+e.getMessage(),e);
			e.printStackTrace();
		}
		return ack;
	}
	public static void insertaLogIntegracion(Integer idsistema, Date fecha_rx,String nhc, String naps,String modelo, String nserie, String nomfich,Integer estado,String error, Integer idintegracion){
		try{
			IntegracionesInformesDao intdao = new IntegracionesInformesDaoImpl("integracion");
			IntegracionesInformes obj = new IntegracionesInformes();
			obj.setIdsistema(idsistema);
			obj.setFecharx(new Date());
			obj.setFecharegistro(fecha_rx);
			obj.setNhc(nhc);
			obj.setNombreAps(naps);
			obj.setModelo(modelo);
			obj.setNserie(nserie);
			obj.setNombrefichero(nomfich);
			obj.setEstado(estado);
			// Especificacion de mesnaje de error segun estado
			String msg_error=null;
			if(estado!=null){
				if(estado.equals(-1))
					msg_error=error;
				else if(estado.equals(-2))
					msg_error="ERROR EN INSERCI�N DE REGISTRO EN IDEA";
				else if(estado.equals(-3))
					msg_error="ERROR EN INSERCI�N DE SOLICITUD DE INTEGRACION EN IDEA";
				else if(estado.equals(-4))
					msg_error="ERROR EN INSERCI�N DE REGISTRO/SOLICITUD EN IDEA. DATOS DEMOGR�FICOS INSUFICIENTES";
				else if(estado.equals(-5))
					msg_error="ERROR EN INSERCI�N DE REGISTRO EN IDEA";
				else if(estado.equals(-6))
					msg_error="ERROR INTERNO IDEA";
			}
			obj.setError(msg_error);
			obj.setIdintegracion(idintegracion);
			intdao.insert(obj);
			logger.info("Log de integracion insertado con �xito en el sistema.");			
		}catch(Exception e1){
			logger.error("Error de isnerci�n de log de integracion. Motivo: "+e1.getMessage(),e1);
			e1.printStackTrace();
		}
	}
	
	/**
	 * Metodo para gestionar la insercion de solicitudes pendientes de integraci�n en IDEA
	 * @param adt
	 * @param oru
	 * @return
	 */
	public static int procesaSolicitudIntegracion(ADT_A01 adt, ORU_R01 oru){				
		try {
			conn = ResourceManager.getConnection();
		} catch (SQLException e) {
			logger.error("Error en creaci�n de solicitud de seguimiento. Motivo: "+e.getMessage(),e);
			return -111;
		}
		IntPendientesDao soldao = new IntPendientesDaoImpl(conn,"integracion");
		IntPacientesDao patdao = new IntPacientesDaoImpl(conn,"integracion");
		IntImplantesDao impdao = new IntImplantesDaoImpl(conn,"integracion");
		IntElectrodosDao elsdao = new IntElectrodosDaoImpl(conn,"integracion");	
		
		IntPendientes pend = new IntPendientes();
		IntPacientes pat = new IntPacientes();
		IntImplantes imp = new IntImplantes();
		
		try{			
			conn.setAutoCommit(false);				
			pend.setEstado(0);
			pend.setFecharx(new Date());
			
			// PROCESADO ADT
			String valor = adt.getPID().getPatientName(0).getGivenName().getValue();// nombre
			if(valor!=null && !valor.equals(""))
				pat.setNombre(valor);
			valor = adt.getPID().getPatientName(0).getFamilyName().getSurname().getValue();// apellidos
			if(valor!=null && !valor.equals(""))
				pat.setApellidos(valor);
			String fnac_str = adt.getPID().getDateTimeOfBirth().getTime().getValue();
			if(fnac_str!=null && !fnac_str.equals("")){
				Date fnac = UtilFechas.StringToDateFormato(fnac_str,"yyyyMMdd");// fechanacimiento
				if(fnac!=null)
					pat.setFechanacimiento(fnac);			
			}			
			// Sexo
			pat.setSexo(GestorHL7.obtenerSexo(adt.getPID().getAdministrativeSex().getValue()));
			// PROCESADO ORU - SISTEMA IMPLANTADO
			String fimp = GestorHL7.obtenerValorOBX("720901", oru.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll());
			imp.setFechaimplante(fimp!=null?UtilFechas.StringToDateFormato(fimp, "yyyyMMdd"):null);
				
			imp.setModelog(GestorHL7.obtenerValorOBX("720898",oru.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll()));
			imp.setNumserieg(GestorHL7.obtenerValorOBX("720899",oru.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll()));
			imp.setFabricanteg(GestorHL7.obtenerFabricante(GestorHL7.obtenerValorOBX("720900",oru.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll())));

			String fechaseg = GestorHL7.obtenerValorOBX("721025",oru.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll());
			imp.setFechaseg(UtilFechas.StringToDateFormato(fechaseg, "yyyyMMdd"));
			
			ArrayList<IntElectrodos> els = componerSistemaElectrodos(oru.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll());		
			/*
			 *  Procesado seguimiento:
			 * 	- Guardar ORU en PATH_HL7
			 *  - Insertar referencia de path en BD. Se asocia en el campo de IntImplante
			 */
			String path = PATH_HL7+"/"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMddhhmmssSSSSSS")+"_"+imp.getModelog()+"_"+imp.getNumserieg()+".hl7";
			UtilFiles.write2File(oru.toString(), path);
			File f = new File(path);
			imp.setOruPath(path);				
			if(!f.exists()){
				logger.error("No se ha almacenado la referencia de ORU en sistema local.");
				return -112;
			}
			
			IntPendientesPk intpk = soldao.insert(pend);
			pend.setIdintegracion(intpk.getIdintegracion());
			
			pat.setIdintegracion(intpk.getIdintegracion());
			patdao.insert(pat);
			
			imp.setIdintegracion(intpk.getIdintegracion());
			impdao.insert(imp);
			
			for(IntElectrodos e:els){
				/*String fechaimpel = GestorHL7.obtenerValorOBX("720964",oru.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll());
				if(fechaimpel!=null)
					e.setFechaimplante(UtilFechas.StringToDateFormato(fechaimpel, "yyyyMMdd"));*/
				e.setIdintegracion(intpk.getIdintegracion());
				elsdao.insert(e);
			}
			/*
			 * Procesado de log de integracion de seguimiento
			 */
			boolean remoto = (oru.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr4_UniversalServiceIdentifier().getCe1_Identifier().getValue().equals("REMOTO")?true:false);
			Integer idsistema = UtilMapeos.getSistema(GestorHL7.obtenerValorOBX("720900",oru.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll()), remoto);
			insertaLogIntegracion(idsistema,imp.getFechaseg(),null,pat.getNombre()+" "+pat.getApellidos(),imp.getModelog(),imp.getNumserieg(),null,0,null,pend.getIdintegracion());
			
			conn.commit();
			logger.info("Solicitud de integraci�n insertada con �xito en el sistema.");
			return 0;
			
		}catch(Exception e){
			logger.error("Error de procesamiento de solicitud de integraci�n. Motivo: "+e.getMessage(),e);
			e.printStackTrace();
			// TODO
			//insertaLogIntegracion(idsistema,imp.getFechaseg(),null,pat.getNombre()+" "+pat.getApellidos(),imp.getModelog(),imp.getNumserieg(),null,-3,null,pend.getIdintegracion());
			return -113;
		}finally {
		    if (conn != null) {
		    	//System.out.println("Cierrra coenexion");
		    	try {
					conn.close();	        	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
	}
	
	private static ArrayList<IntElectrodos> componerSistemaElectrodos(List<ORU_R01_OBSERVATION> lista){
		int i = 1;
		ArrayList<IntElectrodos> els = new ArrayList<IntElectrodos>();
		String modelo=null,nserie=null,fab = null,fecha_str=null;
		int camara = 0, status = 0;
		IntElectrodos e = null;
		// FECHAS DE IMPLANTE ELECTRODOS - BORRAR
		//ArrayList<String> fechas_imp_el = GestorHL7.obtenerValoresOBX("720964",lista);
		while(i !=-1){
			modelo = GestorHL7.obtenerValorOBX("720961",String.valueOf(i), lista);
			nserie = GestorHL7.obtenerValorOBX("720962",String.valueOf(i), lista);
			fab = GestorHL7.obtenerFabricante(GestorHL7.obtenerValorOBX("720963",String.valueOf(i), lista));
			camara = GestorHL7.obtenerCamaraElectrodo(GestorHL7.obtenerValorOBX("720966",String.valueOf(i), lista));
			status = GestorHL7.obtenerStatusElectrodo(GestorHL7.obtenerValorOBX("720970",String.valueOf(i), lista));
			fecha_str = GestorHL7.obtenerValorOBX("720964",String.valueOf(i), lista);
			if((modelo!=null && !modelo.equals(""))
					|| (nserie!=null && !nserie.equals(""))){
				e = new IntElectrodos();
				e.setCamara(camara);
				e.setModelo(modelo+i);
				e.setFabricante(fab);
				e.setNserie(nserie+i); // para evitar problemas de insercion en bd. En vista se quitara la ultima posicion i
				e.setEstado(status);
				/*if(fechas_imp_el.size()>0 && fechas_imp_el.get(i-1)!=null)
					e.setFechaimplante(UtilFechas.StringToDateFormato(fechas_imp_el.get(i-1), "yyyyMMdd"));*/
				e.setFechaimplante(fecha_str!=null && !fecha_str.equals("")?UtilFechas.StringToDateFormato(fecha_str, "yyyyMMdd"):null);		
				els.add(e);
				i++;
			}else
				i=-1;	
		}
		/*while(i !=-1){
			modelo = GestorHL7.obtenerValorOBX("720961",String.valueOf(i), lista);
			nserie = GestorHL7.obtenerValorOBX("720962",String.valueOf(i), lista);
			fab = GestorHL7.obtenerFabricante(GestorHL7.obtenerValorOBX("720963",String.valueOf(i), lista));
			camara = GestorHL7.obtenerCamaraElectrodo(GestorHL7.obtenerValorOBX("720966",String.valueOf(i), lista));
			status = GestorHL7.obtenerStatusElectrodo(GestorHL7.obtenerValorOBX("720970",String.valueOf(i), lista));
			if((modelo!=null && !modelo.equals(""))
					|| (nserie!=null && !nserie.equals(""))){
				e = new IntElectrodos();
				e.setCamara(camara);
				e.setModelo(modelo);
				e.setFabricante(fab);
				e.setNserie(nserie);
				e.setEstado(status);
				els.add(e);
				i++;
			}else
				i=-1;	
		}*/
		return els;
	}
	
	
	public static String recibeHl7(String in){
		String ack="";
		String oru="";
		/* Es necesario reparsear el string del mensaje HL7 recibido
		 * ya que da problemas con saltos de linea. El proceso consiste en
		 * pasar el string rx a Stream y con una clase de HAPI reparsearlo 
		 * a string. Esto ofrece un string adecuado para parsearlo a objeto HAPI
		 */
		//Declaramos el InputStream
		InputStream inputStream=null;		 
		//Creamos un StringBuffer pasando como parametro el String a convertir.
		StringBuffer StringBuffer1 = new StringBuffer(in);
		try {
			inputStream = new ByteArrayInputStream(StringBuffer1.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Hl7InputStreamMessageStringIterator iter2 = new Hl7InputStreamMessageStringIterator(inputStream); 
		while (iter2.hasNext()) {
		 	oru = iter2.next();
		}	
		HapiContext context = new DefaultHapiContext();
		Parser p = context.getGenericParser();
		Message hapiMsg=null;
		try {
		  // The parse method performs the actual parsing
		    hapiMsg = p.parse(oru);
		}catch(Exception e) {
			e.printStackTrace();
		}
		ORU_R01 oruMsg = (ORU_R01)hapiMsg;
		try {
			List<ORU_R01_OBSERVATION> lista = oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll();
			String infogen = oruMsg.getPATIENT_RESULT().getPATIENT().getPID().getPid3_PatientIdentifierList(0).getIDNumber().getValue();
			String tiposeg = oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr4_UniversalServiceIdentifier().getIdentifier().getValue();
			String numseriegen = GestorHL7.obtenerValorOBX("720899",lista);
			String modelo = GestorHL7.obtenerValorOBX("720898",lista);
			String mnf = GestorHL7.obtenerValorOBX("720900",lista);
			String fechaseg = oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr7_ObservationDateTime().getTime().getValue();
			String idmsg = oruMsg.getMSH().getMessageControlID().getValue();
			boolean remoto = (oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBR().getObr4_UniversalServiceIdentifier().getCe1_Identifier().getValue().equals("REMOTO")?true:false);
			logger.info("Integraci�n de Procedimiento de Seguimiento. Info Generador - "+infogen+". Tipo de seguimiento: "+tiposeg+". Fecha: "+fechaseg+". ID Mensaje: "+idmsg);
			int codigo = existeSeguimiento(modelo,numseriegen,fechaseg,mnf);
			if(codigo==0){
				ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMdd")+"||ACK^R01|"+idmsg+"|P|2.5|"+"MSA|AE|"+idmsg+"|Error en integracion de evento seguimiento. Existen registros de seguimiento para la fecha especificada|";
				logger.error("No se puede integrar procedimiento de seguimiento.");
			}else if(codigo==-1){
				ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMdd")+"||ACK^R01|"+idmsg+"|P|2.5|"+"MSA|AE|"+idmsg+"|Error en integracion de evento seguimiento. No existe el generador con info "+infogen+"|";
				logger.error("No se puede integrar procedimiento de seguimiento");
			}
			else{// Crear nuevo seguimiento
				int r = creaNuevoSeguimiento(numseriegen,codigo,lista,UtilFechas.dateHL7StringToDateString(fechaseg),remoto);
				if(r != 1){
					ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMdd")+"||ACK^R01|"+idmsg+"|P|2.5|"+"MSA|AE|"+idmsg+"|Error en integracion de evento seguimiento. Error de insercion interno|";
					logger.error("No se puede integrar procedimiento de seguimiento");
				}else{
					System.out.println(codigo);
					ack="MSH|^~\\*|PROGRAMADOR|CLINICA|IDEA|CLINICA|"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMdd")+"||ACK^R01|"+idmsg+"|P|2.5|"+"MSA|AA|"+idmsg+"|Evento seguimiento integrado con exito|";
					logger.info("Integraci�n de Procedimiento de Seguimiento finalizada con exito");
				}	
			}		
		} catch (HL7Exception e) {
			logger.error("Error de procesamiento de ORU_R01. Motivo: "+e.fillInStackTrace());
			e.printStackTrace();
		}catch(Exception e){
			logger.error("Error de procesamiento. Motivo: "+e.fillInStackTrace());
			e.printStackTrace();
		}
		return ack;
	}
	public static int creaNuevoSeguimiento(String nsgen,int idpat,List<ORU_R01_OBSERVATION> lista,String fechaseg,boolean remoto){
		lecturaProperties();
		// obtencion de conexion 
		try {
			conn = ResourceManager.getConnection();
		} catch (SQLException e) {
			logger.error("Error en creaci�n de seguimiento importado. Motivo: "+e.getMessage(),e);
			return -100;
		}
		// Buscar ultimo sistema desde la fecha especificada hacia atras
		ProcedimientoDao procdao = new ProcedimientoDaoImpl(conn,"integracion");
		SegSeguimientoDao segdao = new SegSeguimientoDaoImpl(conn,"integracion");
		impdao = new ImpImplanteDaoImpl(conn,"integracion");
		gendao = new ImpGeneradorDaoImpl(conn,"integracion");
		impelecdao = new ImpImplanteElectrodosDaoImpl(conn,"integracion");
		generadordao = new GeneradorDaoImpl(conn,"integrador");
		infdao = new InformesDaoImpl(conn,"integrador");
		conv = new Conversor();
		ImpImplanteElectrodos[] sist_elec = null;
		try{
			conn.setAutoCommit(false);
			Procedimiento[] prsimp = procdao.findByDynamicWhere("CODIGO=? AND FECHA <=? AND (TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=?) ORDER BY FECHA DESC",
					new Object[]{idpat,fechaseg,956,957,993,1059,1060,1085,1086,1090});
			Procedimiento[] prsseg = procdao.findByDynamicWhere("CODIGO=? AND FECHA <=? AND TIPOPROCEDIMIENTO=? ORDER BY FECHA DESC",
					new Object[]{idpat,fechaseg,983});
			
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
				return -101;
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
			// Obtener Sistema - generador
			ImpGenerador[] sist_gen = gendao.findWhereIdhojaimpEquals(idimpgen);
			// Obtener tipo de generador
			Generador gen = generadordao.findByPrimaryKey(sist_gen[0].getIdgenerador());
			String fab = GestorHL7.obtenerValorOBX("720900",lista);
			// Obtener sistema electrodos
			if(idelecimp>0)
				sist_elec = impelecdao.findWhereIdhojaimpEquals(idelecimp);
			else if(idelecseg>0)
				sist_elec = impelecdao.findWhereIdsegEquals(prsseg[0].getIdprocedimiento());
			// Obtener Tipo de generador
			String tipogen = gen.getTipo();
			
			/******************* PROCEDIMIENTO GUARDAR ********************************/	
			SegSeguimiento seg = new SegSeguimiento();
			seg.setFecha(UtilFechas.StringToDate2(fechaseg));
			//**************** Presencial o Remoto ****************************
			if(remoto)
				seg.setRemoto((short) 1);
			//**************** Carga valores de electrodo ****************************
			if(sist_elec.length>0)
				cargaValoresElectrodo(sist_elec,lista);
			//**************** Carga valores de bateria ****************************
			SegSistema sist = new SegSistema();
			cargaValoresBateria(sist,lista);
			SegSistemaDao sistdao = new SegSistemaDaoImpl(conn,"integracion");
			SegSistemaPk sistpk = sistdao.insert(sist);
			seg.setIdsistema(sistpk.getIdsistema());
			//**************** Carga valores de programacion ****************************
			ImpEvolucion prog = new ImpEvolucion();
			cargaValoresProgramacion(prog,lista);
			ImpEvolucionDao progdao = new ImpEvolucionDaoImpl(conn,"integracion");
			ImpEvolucionPk prgpk = progdao.insert(prog);
			seg.setIdev(prgpk.getIdev());
			
			ImpZonaDao zonadao = new ImpZonaDaoImpl(conn,"integracion");
			ImpChoquesDao choquedao = new ImpChoquesDaoImpl(conn,"integracion");
			ImpAtpDao atpdao = new ImpAtpDaoImpl(conn,"integracion");
			for (ImpZona z : prog.getZonas()) {
				z.setIdev(prog.getIdev());
				ImpZonaPk zpk = zonadao.insert(z);
				z.setIdzona(zpk.getIdzona());
				for (ImpAtp a : z.getAtps()) {
					a.setIdzona(z.getIdzona());
					ImpAtpPk apk = atpdao.insert(a);
					a.setIdatp(apk.getIdatp());
				}
				if (z.getChqs().size() > 0
						&& (z.getChqs().get(0).getEnergia() != null)) {
					for (ImpChoques ch : z.getChqs()) {
						ch.setIdzona(z.getIdzona());
						ImpChoquesPk chpk = choquedao.insert(ch);
						ch.setIdzona(chpk.getIdch());
					}
				}
			}
			//**************** Carga valores de Porcentajes de Estimulacion ****************************
			SegPorestimulacion porstim = new SegPorestimulacion();
			cargaPorcentajesEstimulacion(porstim, lista );
			SegPorestimulacionDao pordao = new SegPorestimulacionDaoImpl(conn,"integracion");
			SegPorestimulacionPk porpk = pordao.insert(porstim);
			seg.setIdporestim(porpk.getIdporestim());
			//**************** Carga valores de Bloqueos AV ****************************
			SegBloqueos bl = new SegBloqueos();
			cargaBAVs(bl,lista);
			SegBloqueosDao bldao = new SegBloqueosDaoImpl(conn,"integracion");
			SegBloqueosPk blpk = bldao.insert(bl);
			seg.setIdbloqueo(blpk.getIdbloqueo());
			
			//**************** Carga valores de Observaciones MP/DAI ****************************
			if(gen.getTipo().equals("1")|| gen.getTipo().equals("3")|| gen.getTipo().equals("5")){
				SegObservacionesMp obsmp = new SegObservacionesMp();
				cargaValoresObservacionMP(obsmp,lista);
				SegObservacionesMpDao obsmpdao = new SegObservacionesMpDaoImpl(conn,"Integracion");
				SegObservacionesMpPk obsmppk = obsmpdao.insert(obsmp);
				seg.setIdobsmp(obsmppk.getIdobsmp());
			}else if(gen.getTipo().equals("2")|| gen.getTipo().equals("4")|| gen.getTipo().equals("6")){
				SegObservacionesDai obsdai = new SegObservacionesDai();
				cargaValoresObservacionDAI(obsdai,lista,fab);
				SegObservacionesDaiDao obsdaidao = new SegObservacionesDaiDaoImpl(conn,"Integracion");
				SegObservacionesDaiPk obsdaipk = obsdaidao.insert(obsdai);
				seg.setIdobsdai(obsdaipk.getIdobsdai());
			}
			/*if(tipogen.equals("CWE[MP]")){
				SegObservacionesMp obsmp = new SegObservacionesMp();
				SegObservacionesMpDao obsmpdao = new SegObservacionesMpDaoImpl("Integracion");
				SegObservacionesMpPk obsmppk = obsmpdao.insert(obsmp);
				seg.setIdobsmp(obsmppk.getIdobsmp());
			}else if(tipogen.equals("CWE[DAI]")){
				SegObservacionesDai obsdai = new SegObservacionesDai();
				SegObservacionesDaiDao obsdaidao = new SegObservacionesDaiDaoImpl("Integracion");
				SegObservacionesDaiPk obsdaipk = obsdaidao.insert(obsdai);
				seg.setIdobsdai(obsdaipk.getIdobsdai());
			}*/
			
			seg.setIdimpl(idimp);
			SegSeguimientoPk segpk = segdao.insert(seg);
			// Guardar estado de electrodos
			for(ImpImplanteElectrodos e:sist_elec){
				e.setIdimpelectrodos(null);
				e.setIdhojaimp(null);
				e.setIdevolucion(prog.getIdev());
				e.setIdseg(segpk.getIdseg());
				ImpImplanteElectrodosPk epk = impelecdao.insert(e);
				e.setIdimpelectrodos(epk.getIdimpelectrodos());
			}	
			Procedimiento prc = new Procedimiento();
			prc.setCodigo(idpat);
			prc.setIntegrado(0);
			prc.setFecha(UtilFechas.StringToDate2(fechaseg));
			prc.setTipoprocedimiento(983);
			prc.setIdprocedimiento(seg.getIdseg());
			// Importar Situacion Clinica general
			SituacionClinicaProc sitclin = new SituacionClinicaProc();
			cargaSituacionClinica(idpat,sitclin);
			SituacionClinicaProcDao sitclindao = new SituacionClinicaProcDaoImpl(conn,"integracion");
			SituacionClinicaProcPk sitclinpk = sitclindao.insert(sitclin);
			prc.setIdsitclinica(sitclinpk.getIdsitclin());
			
			ProcedimientoPk procpk = procdao.insert(prc);
			
			//**************** Guarda informe PDF asociado si procede ****************************
			String str_b64 = GestorHL7.obtenerValorOBX_ED("18750-0",lista);
			if(str_b64!=null){
				str_b64 = str_b64.substring(27, str_b64.length()-1);
				//byte[] decodedBytes = Base64.decodeBase64(str_b64.getBytes());
				String path = PATH_INFORMES_SEG+"/"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMddhhmmssSSSSSS")+"_"+gen.getModelo()+"_"+nsgen+".txt";
				UtilFiles.write2File(str_b64, path);
				File f = new File(path);
				if(f.exists()){
					Informes inf = new Informes();
					inf.setIdprocedimiento(procpk.getIdprocedimiento());
					inf.setTipoprocedimiento(procpk.getTipoprocedimiento());
					inf.setCodigo(idpat);
					inf.setRuta(path);
					inf.setDescripcion("Informe de Seguimiento");
					inf.setOrigen(2);// PROVISIONAL PARA QUE SEA VISIBLE
					inf.setFechacreacion(new Date());
					inf.setEstado(1);// ACTIVO POR DEFECTO
					ArrPacientesDao patdao = new ArrPacientesDaoImpl("integracion");
					ArrPacientes pat = patdao.findByPrimaryKey(idpat);
					inf.setIdinforme(String.valueOf(inf.getTipoprocedimiento())+"_"+pat.getNhc()+"_"+UUID.randomUUID());
					inf.setIdepisodio(null);
					infdao.insert(inf);
					logger.info("Informe de procedimiento de seguimiento almacenado. IDProcedimiento: "+procpk.getIdprocedimiento()+" . TipoProcedimiento: "+procpk.getTipoprocedimiento());
				}else
					logger.error("No se puede almacenar informe de seguimiento adjunto. IDProcedimiento: "+procpk.getIdprocedimiento()+" . TipoProcedimiento: "+procpk.getTipoprocedimiento());			
			}else
				logger.info("No existe informe adjunto asociado");
			
			conn.commit();
			return 1;
		}catch(Exception e){
			logger.error("Error en creaci�n de seguimiento importado. Motivo: "+e.getMessage(),e);
			return -102;
		}finally {
		    if (conn != null) {
		    	//System.out.println("Cierrra coenexion");
		    	try {
					conn.close();	        	
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		}
	} 
	/**
	 * Operacion para verificar si un seguimiento existe en el sistema.
	 * Devolvera integer. Si resultado = 0, existe el seguimiento para esa fecha -> CONTROLAR
	 * 					  Si resultado = -1. No existe sistema implantado en IDEA: Modelo/Num.Serie
	 * 					  Si resultado mayor de 0, es el idpaciente para insertar el nuevo seguimiento 
	 * @param nsgen
	 * @param fechaseg
	 * @return 
	 */
	public static int existeSeguimiento(String modelo, String nsgen, String fechaseg,String mnf){		
		int codigo = 0;int aux=0;
		try{
			ImpGeneradorDao impgendao = new ImpGeneradorDaoImpl();
			ImpGenerador[] gen  = impgendao.findWhereNumserieEquals(nsgen);// busca implante de generador con numero de serie especificado
			GeneradorDao gendao = new GeneradorDaoImpl();
			conv = new Conversor();
			// es necesario comprobat tb el modelo y num.serie para evitar inconsistencias de datos.
			// Al menos modelo y fabricante
			if(gen.length>0){// Existen implantes con ese num.serie
				// Se verifica que el num.serie coincide con el modelo especificado y el registrado en IDEA.
				Generador[] generadores = gendao.findWhereIdgeneradorEquals(gen[0].getIdgenerador());// obtener datos de generador
				boolean existe = false;
				for(Generador g:generadores){
					mnf = conv.convFabricante(mnf);
					if(mnf.equals(g.getFabricante())){// comprobamos por el nombre del fabricante
						// TB podemos comprobar por nombres de modelo RX Y ALMACENADO EN BD: Ej: Distancia de Levensthein
						existe = true;
						break;
					}				
				}
				if(existe){
					ProcedimientoDao procdao = new ProcedimientoDaoImpl();
					ImpImplanteDao impdao = new ImpImplanteDaoImpl();
					for(ImpGenerador g:gen){
						// Obtener el objeto implante asociado para obtener su ID
						ImpImplante[] imp = impdao.findWhereIdhojaimpEquals(g.getIdhojaimp());
						if(imp.length>0){	
							for(ImpImplante i:imp){
								SegSeguimientoDao segdao = new SegSeguimientoDaoImpl();
								// comprobar si hay seguimiento asociado con la misma fecha
								//System.out.println(i.getIdimplante()+"____"+UtilFechas.dateHL7StringToDateString(fechaseg));
								SegSeguimiento[] seg = segdao.findByDynamicWhere("IDIMPL =? AND FECHA=?",
										new Object[]{i.getIdimplante(),UtilFechas.dateHL7StringToDateString(fechaseg)});
								if(seg.length>0){
									logger.error("Existen seguimientos para la fecha: "+UtilFechas.StringToDate(fechaseg)+" del dispositivo: "+nsgen);
									//aux = i.getIdimplante();
									//return 0;
								}
								aux = i.getIdimplante();
							}			
						}else{// Caso raro de incosistencia de datos en bbdd
							logger.info("No existe implante generador con numero de serie: "+nsgen);
							return -1;
						}			
					}	
					// Si llega aqui, es que no hay seguimiento previo en bbd
					// Sacar del objeto implante el id paciente asociado. Recordar que el seguimiento y el implante estan relacionados por el idimplante
					// Solo hay un procedimiento con un id procedimiento y un tipo de procedimiento asociado
					codigo = procdao.findByDynamicWhere("IDPROCEDIMIENTO =? AND (TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=? OR TIPOPROCEDIMIENTO=?)",
							new Object[]{aux,956,957,993,1059,1060,1085})[0].getCodigo();
					return codigo;
				}else{
					logger.info("No existe generador con numero de serie: "+nsgen+" y modelo: "+modelo);
					return -1;
				}										
			}else{
				logger.info("No existe generador con numero de serie: "+nsgen);
				return -1;
			}			
		}catch(Exception e){
			logger.error("Error en consulta de seguimiento. Motivo: "+e.getMessage(),e);
			return -1;
		}
	}
	/**
	 * Metodo para cargar en electrodos valores rx desde el ORU_R01
	 * @param listaelec
	 * @param lista
	 */
	private static void cargaValoresElectrodo(ImpImplanteElectrodos[] listaelec, List<ORU_R01_OBSERVATION> lista){
		for(ImpImplanteElectrodos e:listaelec){
			if(e.getCamara()==948){// AD							
				e.setOndarpEv(GestorHL7.obtenerValorOBX("722048",lista));// OndaRP				
				e.setUmbralvEv(GestorHL7.obtenerValorOBX("722176",lista));// Umbral V
				e.setUmbralmsEv(GestorHL7.obtenerValorOBX("722240",lista));// Umbral ms
				e.setImpohmEv(GestorHL7.obtenerValorOBX("722432",lista));	// Impedancia Ohm				
				e.setDurimpulso(GestorHL7.obtenerValorOBX("730048",lista));// Duracion Impulso
				e.setVoltaje(GestorHL7.obtenerValorOBX("729984",lista));// Voltaje
				e.setSensibilidad(GestorHL7.obtenerValorOBX("729536",lista));// Sensibilidad
				e.setPoldeteccion(conv.convPolaridad(GestorHL7.obtenerValorOBX("729600",lista)));// Pol. deteccion
				e.setPolestimulacion(conv.convPolaridad(GestorHL7.obtenerValorOBX("730112",lista)));// Pol. estimulacion
				e.setIdseg(null);
				e.setIdimpelectrodos(null);
			}else if(e.getCamara()==949){// VD
				e.setOndarpEv(GestorHL7.obtenerValorOBX("722052",lista));// OndaRP				
				e.setUmbralvEv(GestorHL7.obtenerValorOBX("722177",lista));// Umbral V
				e.setUmbralmsEv(GestorHL7.obtenerValorOBX("722241",lista));// Umbral ms
				e.setImpohmEv(GestorHL7.obtenerValorOBX("722433",lista));	// Impedancia Ohm				
				e.setDurimpulso(GestorHL7.obtenerValorOBX("730049",lista));// Duracion Impulso
				e.setVoltaje(GestorHL7.obtenerValorOBX("729985",lista));// Voltaje
				e.setSensibilidad(GestorHL7.obtenerValorOBX("729537",lista));// Sensibilidad
				e.setPoldeteccion(conv.convPolaridad(GestorHL7.obtenerValorOBX("729601",lista)));// Pol. deteccion
				e.setPolestimulacion(conv.convPolaridad(GestorHL7.obtenerValorOBX("730113",lista)));// Pol. estimulacion
				e.setIdseg(null);
				e.setIdimpelectrodos(null);
			}else if(e.getCamara()==950){// VI
				e.setOndarpEv(GestorHL7.obtenerValorOBX("722060",lista));// OndaRP				
				e.setUmbralvEv(GestorHL7.obtenerValorOBX("722179",lista));// Umbral V
				e.setUmbralmsEv(GestorHL7.obtenerValorOBX("722243",lista));// Umbral ms
				e.setImpohmEv(GestorHL7.obtenerValorOBX("722435",lista));	// Impedancia Ohm				
				e.setDurimpulso(GestorHL7.obtenerValorOBX("730051",lista));// Duracion Impulso
				e.setVoltaje(GestorHL7.obtenerValorOBX("729987",lista));// Voltaje
				e.setSensibilidad(GestorHL7.obtenerValorOBX("729539",lista));// Sensibilidad
				e.setPoldeteccion(conv.convPolaridad(GestorHL7.obtenerValorOBX("729603",lista)));// Pol. deteccion
				e.setPolestimulacion(conv.convPolaridad(GestorHL7.obtenerValorOBX("730115",lista)));// Pol. estimulacion
				e.setIdseg(null);
				e.setIdimpelectrodos(null);
			}		
		}		
	}
	/**
	 * Metodo para cargar valores de bateria rx de ORU_R01
	 * @param sist
	 * @param lista
	 */
	private static void cargaValoresBateria(SegSistema sist, List<ORU_R01_OBSERVATION> lista){
		sist.setVoltaje(GestorHL7.obtenerValorOBX("721344",lista));
		sist.setImpedancia(GestorHL7.obtenerValorOBX("721408",lista));
		// ESPECIFICAR: ULTIMO CHOQUE EN DAI - tiempo de carga ...
		sist.setTiempoeri(GestorHL7.obtenerValorOBX("721600",lista));
	}
	/**
	 * Metodo para cargar valores de programacion rx de ORU_R01
	 * @param prg
	 * @param lista
	 */
	private static void cargaValoresProgramacion(ImpEvolucion prg , List<ORU_R01_OBSERVATION> lista){
		// Hay que hacer la correspondencia con los valores internos de BD y los recibidos
		prg.setModogen(conv.convModoProg((GestorHL7.obtenerValorOBX("730752",lista))));//Modo estimulacion
		prg.setFmax(GestorHL7.obtenerValorOBX("731200",lista));//Frec max
		prg.setFmin(GestorHL7.obtenerValorOBX("730880",lista));//Frec min
		prg.setFbasica(prg.getFmin());
		if(GestorHL7.obtenerValorOBX("730944",lista)!=null){// Histeresis
			prg.setHist(true);
			prg.setHisteresis((short)1);
			prg.setValorHisteresis(GestorHL7.obtenerValorOBX("730944",lista));
		}
		// Intervalos AV
		prg.setIavdetec(GestorHL7.obtenerValorOBX("731264",lista));
		prg.setIavestim(GestorHL7.obtenerValorOBX("731328",lista));
		// Zonas - ATP y choques
		prg.setZonas(obtenerZonas(lista));
		
	}
	/**
	 * Metodo para cargar Porcentajes Estimulaci�n del ORU
	 * @param por
	 * @param lista
	 */
	private static void cargaPorcentajesEstimulacion(SegPorestimulacion por, List<ORU_R01_OBSERVATION> lista ){
		por.setPorap(GestorHL7.obtenerValorOBX("737520",lista));//AP
		por.setPorvp(GestorHL7.obtenerValorOBX("737536",lista));//VP
		por.setTiempofa(GestorHL7.obtenerValorOBX("737696",lista));//Tiempo FA
		// Gestion AS-VS, AS-VP, AP-VS, AP-VP
		String apvp = GestorHL7.obtenerValorOBX("737552",lista);// apvp
		String apvs = GestorHL7.obtenerValorOBX("737584",lista);// apvs
		String asvp = GestorHL7.obtenerValorOBX("737568",lista);// asvp
		String asvs = GestorHL7.obtenerValorOBX("737600",lista);// asvs
		// Calculo AS
		por.setPoras(por.getPoras()!=null?por.getPoras():calcularPorcentajes(asvs,asvp));
		// Calculo AP
		por.setPorap(por.getPorap()!=null?por.getPorap():calcularPorcentajes(apvs,apvp));
		// Calculo VS
		por.setPorvs(por.getPorvs()!=null?por.getPorvs():calcularPorcentajes(asvs,apvs));
		// Calculo VP
		por.setPorvp(por.getPorvp()!=null?por.getPorvp():calcularPorcentajes(asvp,apvp));
	}
	/**
	 * Metodo para cargar Bloqueos AV (BAV) del ORU
	 * @param bloq
	 * @param lista
	 */
	private static void cargaBAVs(SegBloqueos bloq, List<ORU_R01_OBSERVATION> lista){
		// TODO VERIFICAR VALORES
	}
	
	/**
	 * Metodo para cargar valores de Observaciones MP del ORU
	 * @param obs
	 * @param lista
	 */
	private static void cargaValoresObservacionMP(SegObservacionesMp obs , List<ORU_R01_OBSERVATION> lista){
		// cambios de modo
		String ncm = GestorHL7.obtenerValorOBX("737744",lista);
		if(ncm!=null){
			obs.setNumcambiomodoarrau(ncm);
			obs.setCambiomodoarrau((short) 1);
		}
		String eps = null;
		// Numero arritmias auriculares - Episodios TSV
		eps = obtenerNumEpisodios("CWE[Epis_SVT^SVT]",lista);
		if(eps!=null){
			obs.setArrau((short) 1);
			obs.setNumarrau(eps!=null?eps:null);
		}
		// Numero arritmias auriculares - Episodios AT^AF
		eps = obtenerNumEpisodios("CWE[Epis_ATAF^AT/AF]",lista);
		if(eps!=null){
			obs.setArrau((short) 1);
			// Se cuentan los anteriores de TSV
			int prev = 0;
			if(obs.getNumarrau()!=null){
				prev = Integer.parseInt(obs.getNumarrau());
				eps = String.valueOf(Integer.parseInt(eps) + prev);
			}	
			obs.setNumarrau(eps!=null?eps:null);
		}
		// Numero arritmias ventriculares - Episodios TV
		eps = obtenerNumEpisodios("CWE[Epis_VT^VT]",lista);
		if(eps!=null){
			obs.setArrvent((short) 1);
			obs.setNumarrv(eps!=null?eps:null);
		}		
	}
	/**
	 * Metodo para cargar Observaciones DAI del ORU
	 * @param obs
	 * @param lista
	 */
	private static void cargaValoresObservacionDAI(SegObservacionesDai obs , List<ORU_R01_OBSERVATION> lista, String fabricante){
		String numteratp = GestorHL7.obtenerValorOBX("737904",lista);
		if(numteratp!=null && !numteratp.equals("") && !numteratp.equals("0")){
			obs.setNumteratp(numteratp);// Terapias ATP entregadas
			obs.setAtp((short) 1);
		}else
			obs.setAtp((short) 0);
		String numterch = GestorHL7.obtenerValorOBX("737840",lista);
		if(numterch!=null && !numterch.equals("") && !numterch.equals("0")){
			obs.setNumterchoq(numterch);// Terapias Choques entregadas
			obs.setChoq((short) 1);
		}else
			obs.setChoq((short) 0);
			
		String eps = null;
		// Episodios VF
		eps = obtenerNumEpisodios("CWE[Epis_VF^VF]",lista);
		obs.setNumepifv(eps!=null?eps:null);
		// Episodios TV
		eps = obtenerNumEpisodios("CWE[Epis_VT^VT]",lista);
		obs.setNumepitv(eps!=null?eps:null);
		// Episodios TSV
		eps = obtenerNumEpisodios("CWE[Epis_SVT^SVT]",lista);
		obs.setNumepitsv(eps!=null?eps:null);
		// Episodsio AT^AF
		eps = obtenerNumEpisodios("CWE[Epis_ATAF^AT/AF]]",lista);
		int prev = 0;
		if(eps!=null){
			prev = Integer.parseInt(obs.getNumepitsv());
			eps = String.valueOf(Integer.parseInt(eps) + prev);
			obs.setNumepitsv(eps!=null?eps:null);
		}
		// Episodios No sostenidos - Seg�n fabricante
		eps = obtenerNumEpisodios(GestorHL7.obtenerCodeEpiNoSost(fabricante),lista);
		obs.setNumepinosost(eps!=null?eps:null);
		// Episodios Otros
		eps = obtenerNumEpisodios("CWE[Epis_Other^Other]",lista);
		obs.setNumepinoesp(eps!=null?eps:null);
	}
	private static String obtenerNumEpisodios(String tipoepi , List<ORU_R01_OBSERVATION> lista){
		OBX obx = null;
		obx = GestorHL7.obtenerOBX("737952",tipoepi,lista);
		if(obx!=null){
			//System.out.println(obx.getObx4_ObservationSubID().getValue());
			return GestorHL7.obtenerValorOBX("738000",obx.getObx4_ObservationSubID().getValue(),lista);
		}else
			return null;
	}
	/**
	 * Metodo para precargar situacion clinica general en el bloque de situacion clinica de procedimiento
	 * Solo se invocara cuando se haga un nuevo registro
	 * @param e
	 */
	private static void cargaSituacionClinica(int idpat, SituacionClinicaProc sitclin){
		try {
			SituacionClinicaGeneralDao sitclingendao = new SituacionClinicaGeneralDaoImpl("Integracion");
			SituacionClinicaGeneral sgen = sitclingendao.findByPrimaryKey(idpat);			
			sitclin.setFevi(sgen.getFevi()!=null?sgen.getFevi():null);
			sitclin.setFuncionventricular(sgen.getFuncionventricular()!=null?sgen.getFuncionventricular():null);
			sitclin.setNyha(sgen.getNyha()!=null?sgen.getNyha():null);
			sitclin.setIc(sgen.getNyha()!=null&&sgen.getNyha()>0?true:false);
			//sgen.setIc(sgen.getNyha()!=null&&sgen.getNyha()>0?true:false);
			sitclin.setCardiop(sgen.getCardiopatia()!=null?true:false);
			//sgen.setCardiop(sgen.getCardiopatia()!=null?true:false);
			sitclin.setCardiopatia(sgen.getCardiopatia()!=null?sgen.getCardiopatia():null);
			sitclin.setAevolucion(sgen.getAevolucion()!=null?sgen.getAevolucion():null);
			sitclin.setRevasc(sgen.getRevasc()!=null?sgen.getRevasc():null);
			sitclin.setRevascularizacion((sgen.getRevasc()!=null && sgen.getRevasc()==1)?true:false);
			//sgen.setRevascularizacion((sgen.getRevasc()!=null && sgen.getRevasc()==1)?true:false);
			sitclin.setInfprevio(sgen.getInfprevio()!=null?sgen.getInfprevio():null);
			sitclin.setInfartoprev((sgen.getInfprevio()!=null && sgen.getInfprevio()==1)?true:false);
			//sgen.setInfartoprev((sgen.getInfprevio()!=null && sgen.getInfprevio()==1)?true:false);
			sitclin.setAnio(sgen.getAnio()!=null?sgen.getAnio():null);
			sitclin.setLocalizacion(sgen.getLocalizacion()!=null?sgen.getLocalizacion():null);
			sitclin.setArritmias(sgen.getArritmias()!=null?sgen.getArritmias():null);
			sitclin.setAvent(sgen.getArritmias()!=null&&sgen.getArritmias()>0?true:false);
			//sgen.setAvent(sgen.getArritmias()!=null&&sgen.getArritmias()>0?true:false);
			sitclin.setEef(sgen.getEef()!=null?sgen.getEef():null);
			sitclin.setEefprev((sgen.getEef()!=null && sgen.getEef()>0)?true:false);
			//sgen.setEefprev((sgen.getEef()!=null && sgen.getEef()>0)?true:false);
			sitclin.setInsrenal(sgen.getInsrenal()!=null?sgen.getInsrenal():null);
			sitclin.setAnteinsrenal(sgen.getInsrenal()!=null&&sgen.getInsrenal()==1?true:false);
			//sgen.setAnteinsrenal(sgen.getInsrenal()!=null&&sgen.getInsrenal()==1?true:false);
			sitclin.setAntfa(sgen.getAntfa()!=null?sgen.getAntfa():null);
			sitclin.setAntefa(sgen.getAntfa()!=null&&sgen.getAntfa()==1?true:false);
			//sgen.setAntefa(sgen.getAntfa()!=null&&sgen.getAntfa()==1?true:false);
			sitclin.setDiabetes(sgen.getDiabetes()!=null?sgen.getDiabetes():null);
			sitclin.setAntediab(sgen.getDiabetes()!=null&&sgen.getDiabetes()==1?true:false);
			//sgen.setAntediab(sgen.getDiabetes()!=null&&sgen.getDiabetes()==1?true:false);
			sitclin.setHta(sgen.getHta()!=null?sgen.getHta():null);
			sitclin.setAnteHTA(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			//sgen.setAnteHTA(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			sitclin.setHipercolest(sgen.getHta()!=null?sgen.getHta():null);
			sitclin.setAntehipercol(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			//sgen.setAntehipercol(sgen.getHta()!=null&&sgen.getHta()==1?true:false);
			sitclin.setMuertesubita(sgen.getMuertesubita()!=null?sgen.getMuertesubita():null);
			sitclin.setAntefam(sgen.getMuertesubita()!=null&&sgen.getMuertesubita()==1?true:false);
			//sgen.setAntefam(sgen.getMuertesubita()!=null&&sgen.getMuertesubita()==1?true:false);
			sitclin.setTabaquismo(sgen.getTabaquismo()!=null?sgen.getTabaquismo():null);
			sitclin.setAntetabaq(sgen.getTabaquismo()!=null&&sgen.getTabaquismo()==1?true:false);
			//sgen.setAntetabaq(sgen.getTabaquismo()!=null&&sgen.getTabaquismo()==1?true:false);
			sitclin.setDislipemia(sgen.getDislipemia()!=null?sgen.getDislipemia():null);
			sitclin.setAnteDislipemia(sgen.getDislipemia()!=null&&sgen.getDislipemia()==1?true:false);
			//sgen.setAnteDislipemia(sgen.getDislipemia()!=null&&sgen.getDislipemia()==1?true:false);
			sitclin.setAcv(sgen.getAcv()!=null?sgen.getAcv():null);
			sitclin.setAnteacv(sgen.getAcv()!=null&&sgen.getAcv()==1?true:false);
			//sgen.setAnteacv(sgen.getAcv()!=null&&sgen.getAcv()==1?true:false);
			sitclin.setTrasplantecardiaco(sgen.getTrasplantecardiaco()!=null?sgen.getTrasplantecardiaco():null);
			sitclin.setAnteTrasplanteCardiaco(sgen.getTrasplantecardiaco()!=null&&sgen.getTrasplantecardiaco()==1?true:false);
			//sgen.setAnteTrasplanteCardiaco(sgen.getTrasplantecardiaco()!=null&&sgen.getTrasplantecardiaco()==1?true:false);
			sitclin.setAit(sgen.getAit()!=null?sgen.getAit():null);
			sitclin.setAnteAIT(sgen.getAit()!=null&&sgen.getAit()==1?true:false);
			//sgen.setAnteAIT(sgen.getAit()!=null&&sgen.getAit()==1?true:false);
			sitclin.setEpoc(sgen.getEpoc()!=null?sgen.getEpoc():null);
			sitclin.setAnteEPOC(sgen.getEpoc()!=null&&sgen.getEpoc()==1?true:false);
			//sgen.setAnteEPOC(sgen.getEpoc()!=null&&sgen.getEpoc()==1?true:false);
			sitclin.setSahs(sgen.getSahs()!=null?sgen.getSahs():null);
			sitclin.setAnteSAHS(sgen.getSahs()!=null&&sgen.getSahs()==1?true:false);
			//sgen.setAnteSAHS(sgen.getSahs()!=null&&sgen.getSahs()==1?true:false);
			sitclin.setTiposahs(sgen.getTiposahs()!=null?sgen.getTiposahs():null);
			sitclin.setAhi(sgen.getAhi()!=null?sgen.getAhi():null);
			sitclin.setCpap(sgen.getCpap()!=null?sgen.getCpap():null);
			sitclin.setAnteCPAP(sgen.getCpap()!=null&&sgen.getCpap()==1?true:false);
			//sgen.setAnteCPAP(sgen.getCpap()!=null&&sgen.getCpap()==1?true:false);
			sitclin.setNeoplasia(sgen.getNeoplasia()!=null?sgen.getNeoplasia():null);
			sitclin.setAnteNeoplasia(sgen.getNeoplasia()!=null&&sgen.getNeoplasia()==1?true:false);
			//sgen.setAnteNeoplasia(sgen.getNeoplasia()!=null&&sgen.getNeoplasia()==1?true:false);
			sitclin.setTiponeoplasia(sgen.getTiponeoplasia()!=null?sgen.getTiponeoplasia():null);
			sitclin.setAfectiroidea(sgen.getAfectiroidea()!=null?sgen.getAfectiroidea():null);
			sitclin.setNeuromediados(sgen.getNeuromediados()!=null?sgen.getNeuromediados():null);
			sitclin.setSincope(sgen.getSincope()!=null?sgen.getSincope():null);
			sitclin.setAnteSincope(sgen.getSincope()!=null&&sgen.getSincope()==1?true:false);
			//sgen.setAnteSincope(sgen.getSincope()!=null&&sgen.getSincope()==1?true:false);
			sitclin.setParadacardiaca(sgen.getParadacardiaca()!=null?sgen.getParadacardiaca():null);
			sitclin.setAnteParadaCardiaca(sgen.getParadacardiaca()!=null&&sgen.getParadacardiaca()==1?true:false);
			//sgen.setAnteParadaCardiaca(sgen.getParadacardiaca()!=null&&sgen.getParadacardiaca()==1?true:false);
		} catch (Exception e1) {
			logger.error("(Integracion) No se puede recuperar situacion cl�nica general de paciente. Motivo: "+ e1.fillInStackTrace());		
		}
	}
	
	/**
	 * Metodo para
	 * @param lista
	 * @return
	 */
	private static ArrayList<ImpZona> obtenerZonas(List<ORU_R01_OBSERVATION> lista){
		ArrayList<ImpZona> zonas = new ArrayList<ImpZona>();
		ArrayList<ImpZona> res = new ArrayList<ImpZona>();
		// 1. encontrar numero de apariciones de codigo 731648 (declaracion de zona de terapia)
		// y crear zona asociada
		ArrayList<String> tipozona = new ArrayList<String>();
		ArrayList<String> fcms = new ArrayList<String>();
		// Lista de listas para asociar los choques
		ArrayList<ArrayList<ImpChoques>> lstchoq = new ArrayList<ArrayList<ImpChoques>>();
		int numzona = 0;int fcppm=0;
		for(ORU_R01_OBSERVATION r:lista){
			if(r.getOBX().getObx4_ObservationSubID().getValue()!=null
					&& !r.getOBX().getObx4_ObservationSubID().getValue().isEmpty()){
				numzona = Integer.parseInt(r.getOBX().getObx4_ObservationSubID().getValue());
				//System.out.println(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue());
				if(numzona>0 && zonas.size()<numzona)
					zonas.add(new ImpZona());
				
				if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals("731648")){
					//System.out.println(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					if(!r.getOBX().getObx5_ObservationValue()[0].getData().toString().equals("CWE[FV^FV]")){
						zonas.get(numzona-1).setTipo("TV");
					}else{
						zonas.get(numzona-1).setTipo("FV");
					}
				}
				else if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals("731840")){
					zonas.get(numzona-1).setFcMs(r.getOBX().getObx5_ObservationValue()[0].getData().toString());					
					fcppm = (int) (60000/Double.parseDouble(r.getOBX().getObx5_ObservationValue()[0].getData().toString()));
					zonas.get(numzona-1).setFcPpm(String.valueOf(fcppm));
				}
				else if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals("732097")){
					ImpAtp atp = new ImpAtp();
					//System.out.println(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					atp.setTipo(conv.convTipoATP(r.getOBX().getObx5_ObservationValue()[0].getData().toString()));
					zonas.get(numzona-1).getAtps().add(atp);
				}
				else if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals("732098")){
					ImpAtp atp = new ImpAtp();
					atp.setTipo(conv.convTipoATP(r.getOBX().getObx5_ObservationValue()[0].getData().toString()));
					zonas.get(numzona-1).getAtps().add(atp);
				}
				else if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals("732161")){
					zonas.get(numzona-1).getAtps().get(0).setNumsec(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
				}
				else if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals("732162")){
					zonas.get(numzona-1).getAtps().get(1).setNumsec(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
				}
				else if(Integer.valueOf(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue())>=732225
						&& Integer.valueOf(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue())<=732234){
					if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().endsWith("25")){
						zonas.get(numzona -1).getChqs().get(0).setEnergia(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					}else{
						ImpChoques ch = new ImpChoques();
						ch.setEnergia(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
						zonas.get(numzona -1).getChqs().add(ch);
					}		
				}
				else if(Integer.valueOf(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue())>=732289
						&& Integer.valueOf(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue())<=732298){
					if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().endsWith("89")){
						zonas.get(numzona -1).getChqs().get(0).setNumch(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					}else if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().endsWith("90")){
						zonas.get(numzona -1).getChqs().get(1).setNumch(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					}else if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().endsWith("91")){
						zonas.get(numzona -1).getChqs().get(2).setNumch(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					}else if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().endsWith("92")){
						zonas.get(numzona -1).getChqs().get(3).setNumch(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					}else if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().endsWith("93")){
						zonas.get(numzona -1).getChqs().get(4).setNumch(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					}else{
						zonas.get(numzona -1).getChqs().get(5).setNumch(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					}		
				}
			}
			
		}
		// Procesado zonas. Solo entran las que tienen definido Fc y tipo
		for(int i=0;i<zonas.size();i++){
			if((zonas.get(i).getFcMs()!=null && !zonas.get(i).getFcMs().equals("")) 
					||(zonas.get(i).getFcPpm() != null && !zonas.get(i).getFcPpm().equals("")))
				res.add(zonas.get(i));
		}
		return res;	
	}
	
	public static String calcularPorcentajes(String d1, String d2){
		Double res = null;
		DecimalFormat formato2d = new DecimalFormat("#.##");
		try{
			if(d1!=null)
				res = Double.parseDouble(d1);
			if(d2!=null)
				res = res + Double.parseDouble(d2);
			if(res!=null)
				return String.valueOf(formato2d.format(res));
		}catch(Exception e){
			logger.error("Error de obtencion de porcentajes de estimulacion. Motivo: "+e.getMessage());
		}
		return null;
	}
	
	public String conversorValores(String codigo){
		if(codigo!=null && !codigo.equals("")){
			if(codigo.equals("-100"))
				return "302";
				//logger.error("No se puede crear seguimiento. Error de conexi�n con BD.");
			else if(codigo.equals("-101"))
				return "303";
				//logger.error("No se puede crear seguimiento. No existe implante asociado.");
			else if(codigo.equals("-102"))
				return "304";
				//logger.error("No se puede crear seguimiento. Error interno en EHR.");
			else if(codigo.equals("-1"))
				return "305";
				//logger.error("No se puede crear solicitud. Datos demogr�ficos insuficientes.");
			else if(codigo.equals("-111"))
				return "306";
				//logger.error("No se puede crear solicitud. Error de conexi�n con BD.");
			else if(codigo.equals("-112"))
				return "307";
				//logger.error("No se puede crear solicitud. Error de inserci�n de ORU en sistema EHR.");
			else if(codigo.equals("-113"))
				return "308";
				//logger.error("No se puede crear solicitud. Error interno en EHR.");
			else if(codigo.equals("-5"))
				return "309";
				//logger.error("Error en EHR. Error de procesamiento de mensaje HL7 recibido.");
			else if(codigo.equals("-6"))
				return "310";
				//logger.error("Error en EHR. Error de procesamiento interno");
		}
		return null;
	}
	
	public static void lecturaProperties() {
		try {
			prop = new Properties();
			InputStream is = LogicaIntegracionProgramadores.class.getResourceAsStream("integracion.properties");
			prop.load(is);
			PATH_HL7 = prop.getProperty("dir_oru");
			PATH_INFORMES_SEG = prop.getProperty("dir_informes_seguimientos");
			is.close();
		} catch (Exception e) {
			logger.error("No se puede iniciar fichero:  integracion.properties. Motivo: "+e.getMessage(),e);
		}	
	}
	
}

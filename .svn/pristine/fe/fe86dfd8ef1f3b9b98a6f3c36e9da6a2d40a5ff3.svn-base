package com.sorin.idea.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.ResourceBundle;

import hvn.cm.dao.DAOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ComplicacionDao;
import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dto.ImpEvolucionComplicacion;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.ProtSincope;
import com.sorin.idea.dto.Protocolos;
import com.sorin.idea.dto.SegClinComplicaciones;
import com.sorin.idea.dto.SegSeguimientoClinico;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.TestOrtostatismoActivo;
import com.sorin.idea.iu.ControlMaterial;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.util.UtilFechas;

public class ReporteProtocoloSincope {

	private static Logger logger = Logger.getLogger(ReporteProtocoloSincope.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	
	private Protocolos protocolo;
	private ProtSincope sincope;
	private ResourceBundle bundle;
	
	public ReporteProtocoloSincope(String path, PacienteAplDto pacienteSelect, 
			Protocolos protocolo,ProtSincope sincope, ResourceBundle bundle){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.sincope = sincope;
		this.protocolo = protocolo;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	
	public void GeneraArchivoPlantilla(){
		Element root = new Element("PROTOCOLO_SINCOPE");
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy");
		try{
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
	        
	        root.addContent(new Element("Fnac").setText(this.paciente.getFechaNaci()!=null?sdf.format(this.paciente.getFechaNaci()):null));
			root.addContent(new Element("Edad").setText(this.paciente.getEdad()));
			if(this.paciente.getSexo()!= null){
				if(this.paciente.getSexo().toString().equals("1"))
					root.addContent(new Element("Sexo").setText(this.bundle.getString("masculino")));
				else 
					root.addContent(new Element("Sexo").setText(this.bundle.getString("femenino")));
			}else
				root.addContent(new Element("Sexo").setText(null));	
			root.addContent(new Element("Paciente").setText(this.paciente.getNombreCompleto()));
			// Separacion nombre , apellido 1, apellido 2
			root.addContent(new Element("Nombre").setText(this.paciente.getNombre()));
			root.addContent(new Element("Apellido1").setText(this.paciente.getApellid1()));
			root.addContent(new Element("Apellido2").setText(this.paciente.getApellid2()));
			// NHC
			root.addContent(new Element("NHC").setText(this.paciente.getNhc()));
			//IdPaciente
			root.addContent(new Element("NICA").setText(this.paciente.getNuhsa()));
			//DNI
			root.addContent(new Element("DNI").setText(this.paciente.getDni()));
			// NSS
			root.addContent(new Element("NSS").setText(this.paciente.getNss1()));
			//Direccion
			root.addContent(new Element("Direccion").setText(this.paciente.getDireccion()));
			//Poblacion
			root.addContent(new Element("Ciudad").setText(this.paciente.getPoblacion()));
			//Provincia
			root.addContent(new Element("Provincia").setText(this.paciente.getProvincia()));
			//telefono
			root.addContent(new Element("Telefono").setText(this.paciente.getTelefono1()));
			// codigo postal
			root.addContent(new Element("CodigoPostal").setText(this.paciente.getCp()));
			// pais
			root.addContent(new Element("Pais").setText(this.paciente.getPais()));
	        
			// Datos Protocolo
			root.addContent(new Element("FechaInicio").setText(UtilFechas.getFechaStringFormato(this.protocolo.getFechacreacion(), "dd/MM/yyyy")));
			String estado = "";
			if(this.protocolo.getEstado()!=null){
				switch (this.protocolo.getEstado()) {
					case 0:
						estado = this.bundle.getString("prot_sincope_estado_op0");
						break;
					case 1:
						estado = this.bundle.getString("prot_sincope_estado_op1");
						break;
					case 2:
						estado = this.bundle.getString("prot_sincope_estado_op2");
						break;
					default:
						estado = "";
						break;
				}
			}
			root.addContent(new Element("Estado").setText(estado));
			// Perfil de riesgo
			String perfilRiesgo = "";
			if(this.sincope.getPerfilRiesgo()!=null){
				switch (this.sincope.getPerfilRiesgo()) {
					case 1:
						perfilRiesgo = this.bundle.getString("prot_sincope_perfil_riesgo_op1");
						break;
					case 2:
						perfilRiesgo = this.bundle.getString("prot_sincope_perfil_riesgo_op2");
						break;
					case 3:
						perfilRiesgo = this.bundle.getString("prot_sincope_perfil_riesgo_op3");
						break;
					default:
						perfilRiesgo = "";
						break;
				}
			}
			root.addContent(new Element("PerfilRiesgo").setText(perfilRiesgo));
			// Orientación diagnóstica
			String orientacion = "";
			if(this.sincope.getOrientacionDiag()!=null){
				switch (this.sincope.getOrientacionDiag()) {
					case 1:
						orientacion = this.bundle.getString("prot_sincope_orientacion_diag_op1");
						break;
					case 2:
						orientacion = this.bundle.getString("prot_sincope_orientacion_diag_op2");
						break;
					case 3:
						orientacion = this.bundle.getString("prot_sincope_orientacion_diag_op3");
						break;
					default:
						orientacion = "";
						break;
				}
			}
			root.addContent(new Element("OrientacionDiagnostica").setText(orientacion));
			// Alta
			root.addContent(new Element("AltaFecha").setText(this.sincope.getAlta().getFechaAlta()!=null?UtilFechas.getFechaStringFormato(this.sincope.getAlta().getFechaAlta(), "dd/MM/yyyy"):null));
			if(this.sincope.getAlta().getPerdcono()!=null)
				root.addContent(new Element("AltaPerdCono").setText((this.sincope.getAlta().getPerdcono()==1)?"1":"0"));
			if(this.sincope.getAlta().getRecesp()!=null)
				root.addContent(new Element("AltaRecEsp").setText((this.sincope.getAlta().getRecesp()==1)?"1":"0"));
			if(this.sincope.getAlta().getPrimepi()!=null)
				root.addContent(new Element("AltaPrimEpi").setText((this.sincope.getAlta().getPrimepi()==1)?"1":"0"));
			root.addContent(new Element("AltaNumEpiPrev").setText((this.sincope.getAlta().getNumepiprev()!=null)?this.sincope.getAlta().getNumepiprev():null));
			root.addContent(new Element("AltaPrimerEpiMesAnio").setText((this.sincope.getAlta().getPrimerepi()!=null)?this.sincope.getAlta().getPrimerepi():null));
			if(this.sincope.getAlta().getPreciAltaCalor()!=null)
				root.addContent(new Element("AltaPrecipCalor").setText((this.sincope.getAlta().getPreciAltaCalor()==1)?"1":"0"));
			if(this.sincope.getAlta().getPreciAltaOrto()!=null)
				root.addContent(new Element("AltaPrecipOrto").setText((this.sincope.getAlta().getPreciAltaOrto()==1)?"1":"0"));
			if(this.sincope.getAlta().getPreciAltaAlcohol()!=null)
				root.addContent(new Element("AltaPrecipAlcohol").setText((this.sincope.getAlta().getPreciAltaAlcohol()==1)?"1":"0"));
			if(this.sincope.getAlta().getPreciAltaEmocion()!=null)
				root.addContent(new Element("AltaPrecipEmocion").setText((this.sincope.getAlta().getPreciAltaEmocion()==1)?"1":"0"));
			if(this.sincope.getAlta().getPreciAltaAyuno()!=null)
				root.addContent(new Element("AltaPrecipAyuno").setText((this.sincope.getAlta().getPreciAltaAyuno()==1)?"1":"0"));
			if(this.sincope.getAlta().getPreciAltaAglo()!=null)
				root.addContent(new Element("AltaPrecipAglo").setText((this.sincope.getAlta().getPreciAltaAglo()==1)?"1":"0"));
			if(this.sincope.getAlta().getPreciAltaPost()!=null)
				root.addContent(new Element("AltaPrecipPost").setText((this.sincope.getAlta().getPreciAltaPost()==1)?"1":"0"));
			if(this.sincope.getAlta().getPreciAltaVenop()!=null)
				root.addContent(new Element("AltaPrecipVenop").setText((this.sincope.getAlta().getPreciAltaVenop()==1)?"1":"0"));
			if(this.sincope.getAlta().getPreciAltaSit()!=null)
				root.addContent(new Element("AltaPrecipSit").setText((this.sincope.getAlta().getPreciAltaSit()==1)?"1":"0"));
			if(this.sincope.getAlta().getPreciAltaEmb()!=null)
				root.addContent(new Element("AltaPrecipEmb").setText((this.sincope.getAlta().getPreciAltaEmb()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaMareo()!=null)
				root.addContent(new Element("AltaProdMareo").setText((this.sincope.getAlta().getProdAltaMareo()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaVision()!=null)
				root.addContent(new Element("AltaProdVision").setText((this.sincope.getAlta().getProdAltaVision()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaNausea()!=null)
				root.addContent(new Element("AltaProdNausea").setText((this.sincope.getAlta().getProdAltaNausea()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaPalidez()!=null)
				root.addContent(new Element("AltaProdPalidez").setText((this.sincope.getAlta().getProdAltaPalidez()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaDolorab()!=null)
				root.addContent(new Element("AltaProdDolorAb").setText((this.sincope.getAlta().getProdAltaDolorab()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaPalp()!=null)
				root.addContent(new Element("AltaProdPalp").setText((this.sincope.getAlta().getProdAltaPalp()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaHiperv()!=null)
				root.addContent(new Element("AltaProdHiperv").setText((this.sincope.getAlta().getProdAltaHiperv()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaFatiga()!=null)
				root.addContent(new Element("AltaProdFatiga").setText((this.sincope.getAlta().getProdAltaFatiga()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaSudor()!=null)
				root.addContent(new Element("AltaProdSudor").setText((this.sincope.getAlta().getProdAltaSudor()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaFaltaaire()!=null)
				root.addContent(new Element("AltaProdFaltaAire").setText((this.sincope.getAlta().getProdAltaFaltaaire()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaFrio()!=null)
				root.addContent(new Element("AltaProdFrio").setText((this.sincope.getAlta().getProdAltaFrio()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaCefal()!=null)
				root.addContent(new Element("AltaProdCefal").setText((this.sincope.getAlta().getProdAltaCefal()==1)?"1":"0"));
			if(this.sincope.getAlta().getProdAltaDolortor()!=null)
				root.addContent(new Element("AltaProdDolorTor").setText((this.sincope.getAlta().getProdAltaDolortor()==1)?"1":"0"));
			if(this.sincope.getAlta().getPrdiaginiAltaHc()!=null)
				root.addContent(new Element("AltaPDiagIniHc").setText((this.sincope.getAlta().getPrdiaginiAltaHc()==1)?"1":"0"));
			if(this.sincope.getAlta().getPrdiaginiAltaSc()!=null)
				root.addContent(new Element("AltaPDiagIniSc").setText((this.sincope.getAlta().getPrdiaginiAltaSc()==1)?"1":"0"));
			String res_sc = "";
			if(this.sincope.getAlta().getPrdiaginiAltaScRes()!=null){
				switch (this.sincope.getAlta().getPrdiaginiAltaScRes()) {
					case 0:
						res_sc = this.bundle.getString("prot_sincope_alta_pdiag_ini_masaje_sen_car_res_0");
						break;
					case 1:
						res_sc = this.bundle.getString("prot_sincope_alta_pdiag_ini_masaje_sen_car_res_1");
						break;
					default:
						res_sc = "";
						break;
				}
			}
			root.addContent(new Element("AltaPDiagIniScRes").setText(res_sc));
			root.addContent(new Element("AltaOperador").setText(this.sincope.getAlta().getOperador()!=null?this.sincope.getAlta().getOperador():null));
			
			if(this.sincope.getAlta().getPrdiaginiAltaTestort()!=null)
				root.addContent(new Element("AltaPDiagIniTestOrt").setText((this.sincope.getAlta().getPrdiaginiAltaTestort()==1)?"1":"0"));
			
			// Datos test
			root.addContent(new Element("AltaPDiagIniTestOrt_Fecha").setText(UtilFechas.getFechaStringFormato(this.sincope.getTestOrto().getFecha(), "dd/MM/yyyy")));
			root.addContent(new Element("AltaPDiagIniTestOrt_DEC_TAD").setText(this.sincope.getTestOrto().getDecTad()));
			root.addContent(new Element("AltaPDiagIniTestOrt_DEC_TAS").setText(this.sincope.getTestOrto().getDecTas()));
			root.addContent(new Element("AltaPDiagIniTestOrt_DEC_FC").setText(this.sincope.getTestOrto().getDecFc()));
			root.addContent(new Element("AltaPDiagIniTestOrt_ORT_TAD").setText(this.sincope.getTestOrto().getOrtTad()));
			root.addContent(new Element("AltaPDiagIniTestOrt_ORT_TAS").setText(this.sincope.getTestOrto().getOrtTas()));
			root.addContent(new Element("AltaPDiagIniTestOrt_ORT_FC").setText(this.sincope.getTestOrto().getOrtFc()));
			root.addContent(new Element("AltaPDiagIniTestOrt_VAR_TAD").setText(this.sincope.getTestOrto().getVarTad()));
			root.addContent(new Element("AltaPDiagIniTestOrt_VAR_TAS").setText(this.sincope.getTestOrto().getVarTas()));
			String res = "";
			if(this.sincope.getTestOrto().getRes()!=null)
				res =(this.sincope.getTestOrto().getRes().equals(1))?this.bundle.getString("test_orto_resultado_pos"):this.bundle.getString("test_orto_resultado_neg");
			root.addContent(new Element("AltaPDiagIniTestOrt_Resultado").setText(res));
			root.addContent(new Element("AltaPDiagIniTestOrt_Operador").setText(this.sincope.getTestOrto().getOperador()));
			root.addContent(new Element("AltaPDiagIniTestOrt_Enfermeria").setText(this.sincope.getTestOrto().getEnfermeria()));
			root.addContent(new Element("AltaPDiagIniTestOrt_Comentarios").setText(this.sincope.getTestOrto().getComentarios()));
			
			root.addContent(new Element("AltaComentarios").setText((this.sincope.getAlta().getComentarios()!=null)?this.sincope.getAlta().getComentarios():null));
			// Analitica
			if(this.sincope.getAnaRealizada()!=null)
				root.addContent(new Element("AnaliticaRealizada").setText((this.sincope.getAnaRealizada()==1)?"1":"0"));
			root.addContent(new Element("AnaliticaFecha").setText(this.sincope.getAnaFecha()!=null?UtilFechas.getFechaStringFormato(this.sincope.getAnaFecha(), "dd/MM/yyyy"):null));
			root.addContent(new Element("AnaliticaHemoglobina").setText((this.sincope.getAnaHemoglobina()!=null)?this.sincope.getAnaHemoglobina():null));
			root.addContent(new Element("AnaliticaDDimero").setText((this.sincope.getAnaDdimero()!=null)?this.sincope.getAnaDdimero():null));
			root.addContent(new Element("AnaliticaLactato").setText((this.sincope.getAnaLactato()!=null)?this.sincope.getAnaLactato():null));
			root.addContent(new Element("AnaliticaComentarios").setText((this.sincope.getAnaComentarios()!=null)?this.sincope.getAnaComentarios():null));		
			// Pruebas Diagnosticas
			if(this.sincope.getPdiagMonitorizacion()!=null){
				root.addContent(new Element("PDiagMonitorizacion").setText((this.sincope.getPdiagMonitorizacion()==1)?"1":"0"));
				root.addContent(new Element("PDiagMonitorizacionRes").setText((this.sincope.getPdiagMonitorizacionRes()!=null)?this.sincope.getPdiagMonitorizacionRes():null));
			}
			if(this.sincope.getPdiagElr()!=null){
				root.addContent(new Element("PDiagElr").setText((this.sincope.getPdiagElr()==1)?"1":"0"));
				root.addContent(new Element("PDiagElrRes").setText((this.sincope.getPdiagElrRes()!=null)?this.sincope.getPdiagElrRes():null));
			}	
			if(this.sincope.getPdiagMesab()!=null){
				root.addContent(new Element("PDiagMesab").setText((this.sincope.getPdiagMesab()==1)?"1":"0"));
				root.addContent(new Element("PDiagMesabRes").setText((this.sincope.getPdiagMesabRes()!=null)?this.sincope.getPdiagMesabRes():null));
			}
			if(this.sincope.getPdiagEcografia()!=null){
				root.addContent(new Element("PDiagEcografia").setText((this.sincope.getPdiagEcografia()==1)?"1":"0"));
				root.addContent(new Element("PDiagEcografiaRes").setText((this.sincope.getPdiagEcografiaRes()!=null)?this.sincope.getPdiagEcografiaRes():null));
			}
			if(this.sincope.getPdiagPesfuerzo()!=null){
				root.addContent(new Element("PDiagPesfuerzo").setText((this.sincope.getPdiagPesfuerzo()==1)?"1":"0"));
				root.addContent(new Element("PDiagPesfuerzoRes").setText((this.sincope.getPdiagPesfuerzoRes()!=null)?this.sincope.getPdiagPesfuerzoRes():null));
			}
			if(this.sincope.getPdiagIlr()!=null){
				root.addContent(new Element("PDiagIlr").setText((this.sincope.getPdiagIlr()==1)?"1":"0"));
				root.addContent(new Element("PDiagIlrRes").setText((this.sincope.getPdiagIlrRes()!=null)?this.sincope.getPdiagIlrRes():null));
			}
			if(this.sincope.getPdiagEcgcont()!=null){
				root.addContent(new Element("PDiagEcgcont").setText((this.sincope.getPdiagEcgcont()==1)?"1":"0"));
				root.addContent(new Element("PDiagEcgcontRes").setText((this.sincope.getPdiagEcgcontRes()!=null)?this.sincope.getPdiagEcgcontRes():null));
			}
			if(this.sincope.getPdiagEef()!=null){
				root.addContent(new Element("PDiagEef").setText((this.sincope.getPdiagEef()==1)?"1":"0"));
				root.addContent(new Element("PDiagEefRes").setText((this.sincope.getPdiagEefRes()!=null)?this.sincope.getPdiagEefRes():null));
			}
			if(this.sincope.getPdiagRxtorax()!=null){
				root.addContent(new Element("PDiagRxtorax").setText((this.sincope.getPdiagRxtorax()==1)?"1":"0"));
				root.addContent(new Element("PDiagRxtoraxRes").setText((this.sincope.getPdiagRxtoraxRes()!=null)?this.sincope.getPdiagRxtoraxRes():null));
			}
			if(this.sincope.getPdiagTaccer()!=null){
				root.addContent(new Element("PDiagTaccer").setText((this.sincope.getPdiagTaccer()==1)?"1":"0"));
				root.addContent(new Element("PDiagTaccerRes").setText((this.sincope.getPdiagTaccerRes()!=null)?this.sincope.getPdiagTaccerRes():null));
			}
			if(this.sincope.getPdiagTactor()!=null){
				root.addContent(new Element("PDiagTactor").setText((this.sincope.getPdiagTactor()==1)?"1":"0"));
				root.addContent(new Element("PDiagTactorRes").setText((this.sincope.getPdiagTactorRes()!=null)?this.sincope.getPdiagTactorRes():null));
			}
			if(this.sincope.getPdiagAngiotac()!=null){
				root.addContent(new Element("PDiagAngiotac").setText((this.sincope.getPdiagAngiotac()==1)?"1":"0"));
				root.addContent(new Element("PDiagAngiotacRes").setText((this.sincope.getPdiagAngiotacRes()!=null)?this.sincope.getPdiagAngiotacRes():null));
			}
			// Valoracion cardiaca
			root.addContent(new Element("ValCardFecha").setText(this.sincope.getValcar().getFecha()!=null?UtilFechas.getFechaStringFormato(this.sincope.getValcar().getFecha(), "dd/MM/yyyy"):null));
			if(this.sincope.getValcar().getSincopePico()!=null)
				root.addContent(new Element("ValCardSincPico").setText((this.sincope.getValcar().getSincopePico()==1)?"1":"0"));
			if(this.sincope.getValcar().getSincopeDec()!=null)
				root.addContent(new Element("ValCardSincDec").setText((this.sincope.getValcar().getSincopeDec()==1)?"1":"0"));
			if(this.sincope.getValcar().getAfMs()!=null)
				root.addContent(new Element("ValCardAFMS").setText((this.sincope.getValcar().getAfMs()==1)?"1":"0"));
			if(this.sincope.getValcar().getPalpitaciones()!=null)
				root.addContent(new Element("ValCardPalpitaciones").setText((this.sincope.getValcar().getPalpitaciones()==1)?"1":"0"));
			if(this.sincope.getValcar().getDolorToracico()!=null)
				root.addContent(new Element("ValCardDolorToracico").setText((this.sincope.getValcar().getDolorToracico()==1)?"1":"0"));
			if(this.sincope.getValcar().getCardioEstruct()!=null)
				root.addContent(new Element("ValCardCardioEstruct").setText((this.sincope.getValcar().getCardioEstruct()==1)?"1":"0"));
			if(this.sincope.getValcar().getAntIsqIcc()!=null)
				root.addContent(new Element("ValCardAntIsqIcc").setText((this.sincope.getValcar().getAntIsqIcc()==1)?"1":"0"));
			String ecg_anormal = "";
			if(this.sincope.getValcar().getEcgAnormal()!=null){
				switch (this.sincope.getValcar().getEcgAnormal()) {
					case 1:
						ecg_anormal = this.bundle.getString("prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op1");
						break;
					case 2:
						ecg_anormal = this.bundle.getString("prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op2");
						break;
					case 3:
						ecg_anormal = this.bundle.getString("prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op3");
						break;
					case 4:
						ecg_anormal = this.bundle.getString("prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op4");
						break;
					case 5:
						ecg_anormal = this.bundle.getString("prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op5");
						break;
					case 6:
						ecg_anormal = this.bundle.getString("prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op6");
						break;
					case 7:
						ecg_anormal = this.bundle.getString("prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op7");
						break;
					case 8:
						ecg_anormal = this.bundle.getString("prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op8");
						break;
					case 9:
						ecg_anormal = this.bundle.getString("prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op9");
						break;
					default:
						ecg_anormal = "";
						break;
				}
			}
			root.addContent(new Element("ValCardEcgAnormal").setText(ecg_anormal));
			if(this.sincope.getValcar().getHallBradi()!=null)
				root.addContent(new Element("ValCardHallBradi").setText((this.sincope.getValcar().getHallBradi()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallBr()!=null)
				root.addContent(new Element("ValCardHallBr").setText((this.sincope.getValcar().getHallBr()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallTsv()!=null)
				root.addContent(new Element("ValCardHallTsv").setText((this.sincope.getValcar().getHallTsv()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallTvns()!=null)
				root.addContent(new Element("ValCardHallTvns").setText((this.sincope.getValcar().getHallTvns()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallMpdai()!=null)
				root.addContent(new Element("ValCardHallMpdai").setText((this.sincope.getValcar().getHallMpdai()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallEcg()!=null)
				root.addContent(new Element("ValCardHallEcg").setText((this.sincope.getValcar().getHallEcg()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallEsten()!=null)
				root.addContent(new Element("ValCardHallEsten").setText((this.sincope.getValcar().getHallEsten()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallHtapulm()!=null)
				root.addContent(new Element("ValCardHallHtapulm").setText((this.sincope.getValcar().getHallHtapulm()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallEmbol()!=null)
				root.addContent(new Element("ValCardHallEmbol").setText((this.sincope.getValcar().getHallEmbol()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallDisec()!=null)
				root.addContent(new Element("ValCardHallDisec").setText((this.sincope.getValcar().getHallDisec()==1)?"1":"0"));
			if(this.sincope.getValcar().getHallMix()!=null)
				root.addContent(new Element("ValCardHallMix").setText((this.sincope.getValcar().getHallMix()==1)?"1":"0"));
			root.addContent(new Element("ValCardComentarios").setText((this.sincope.getValcar().getComentarios()!=null)?this.sincope.getValcar().getComentarios():null));
			root.addContent(new Element("ValCardOperador").setText((this.sincope.getValcar().getOperador()!=null)?this.sincope.getValcar().getOperador():null));	
			// Decision clinica
			root.addContent(new Element("ResFecha").setText(this.sincope.getResFecha()!=null?UtilFechas.getFechaStringFormato(this.sincope.getResFecha(), "dd/MM/yyyy"):null));
			String diag_fin = "";
			if(this.sincope.getResDiagfin()!=null){
				switch (this.sincope.getResDiagfin()) {
					case 1:
						diag_fin = this.bundle.getString("prot_sincope_res_diag_final_op1");
						break;
					case 2:
						diag_fin = this.bundle.getString("prot_sincope_res_diag_final_op2");
						break;
					case 3:
						diag_fin = this.bundle.getString("prot_sincope_res_diag_final_op3");
						break;
					case 4:
						diag_fin = this.bundle.getString("prot_sincope_res_diag_final_op4");
						break;
					default:
						diag_fin = "";
						break;
				}
			}
			root.addContent(new Element("ResDiagFin").setText(diag_fin));
			
			String decision_clin = "";
			if(this.sincope.getResDiagfin()!=null){
				switch (this.sincope.getResDiagfin()) {
					case 1:
						decision_clin = this.bundle.getString("prot_sincope_res_decision_clin_op1");
						break;
					case 2:
						decision_clin = this.bundle.getString("prot_sincope_res_decision_clin_op2");
						break;
					case 3:
						decision_clin = this.bundle.getString("prot_sincope_res_decision_clin_op3");
						break;
					case 4:
						decision_clin = this.bundle.getString("prot_sincope_res_decision_clin_op4");
						break;
					case 5:
						decision_clin = this.bundle.getString("prot_sincope_res_decision_clin_op5");
						break;
					default:
						decision_clin = "";
						break;
				}
			}
			root.addContent(new Element("ResDecisClin").setText(decision_clin));
			root.addContent(new Element("ResComentarios").setText((this.sincope.getResComentarios()!=null)?this.sincope.getResComentarios():null));
			root.addContent(new Element("ResOperador").setText((this.sincope.getResOperador()!=null)?this.sincope.getResOperador():null));
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Protocolo de Sincope. Motivo: "+e.getMessage(),e);
		}
		Document doc = new Document(root);
		try {
			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			// XMLOutputter out= new XMLOutputter();
			FileOutputStream file = new FileOutputStream(pathFichero);
			out.output(doc, file);
			file.flush();
			file.close();
			//out.output(doc, System.out);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Protocolo de Sincope. Motivo: "+e.getMessage(),e);
		}
	}
}

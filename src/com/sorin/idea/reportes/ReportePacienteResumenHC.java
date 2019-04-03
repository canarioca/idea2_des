package com.sorin.idea.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.ResourceBundle;

import hvn.cm.dao.DAOException;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ComplicacionDao;
import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dao.ElectrodosDao;
import com.sorin.idea.dao.ImpHojaImplanteComplicacionDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpEvolucionComplicacion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteComplicacionDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilReporteInformes;

public class ReportePacienteResumenHC {

	private static Logger logger = Logger.getLogger(ReportePacienteResumenHC.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	private ResourceBundle bundle;
	
	public ReportePacienteResumenHC(String path, PacienteAplDto pacienteSelect, ResourceBundle bundle){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	public void GeneraArchivoPlanilla(){
		Element root = new Element("SITUACIONCLINICA");
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy");
		
		try{
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
			//root.addContent(new Element("Fnac").setText(this.paciente.getFechaNaciString()));
			root.addContent(new Element("Fnac").setText(this.paciente.getFechaNaci()!=null?sdf.format(this.paciente.getFechaNaci()):null));
			root.addContent(new Element("Edad").setText(this.paciente.getEdad()));
			if(this.paciente.getSexo()!= null){
				if(this.paciente.getSexo().toString().equals("1"))
					root.addContent(new Element("Sexo").setText(this.bundle.getString("masculino")));
				else 
					root.addContent(new Element("Sexo").setText(this.bundle.getString("femenino")));
			}else{
				root.addContent(new Element("Sexo").setText(null));
			}
			root.addContent(new Element("Paciente").setText(this.paciente.getNombreCompleto()));
			root.addContent(new Element("Nombre").setText(this.paciente.getNombre()));
			root.addContent(new Element("Apellido1").setText(this.paciente.getApellid1()));
			root.addContent(new Element("Apellido2").setText(this.paciente.getApellid2()));
			
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
			
			ArrMaestrasDao maestrasdao = new ArrMaestrasDaoImpl("consultor");
			
			//this.sc.getFuncionventricular()!=null?maestrasdao.findByPrimaryKey(this.sc.getFuncionventricular()).getValor():null)
			
			//FEVI
			root.addContent(new Element("FEVI").setText(this.paciente.getSitclin().getFevi()));
			//Funcion ventricular
			if(this.paciente.getSitclin().getFuncionventricular()!=null){
				if(this.paciente.getSitclin().getFuncionventricular()==1)
					root.addContent(new Element("FuncionVentricular").setText(this.bundle.getString("sc_fvent_op1").toUpperCase()));
				else if(this.paciente.getSitclin().getFuncionventricular()==2)
					root.addContent(new Element("FuncionVentricular").setText("41-50%"));
				else if(this.paciente.getSitclin().getFuncionventricular()==3)
					root.addContent(new Element("FuncionVentricular").setText("36-40%"));
				else if(this.paciente.getSitclin().getFuncionventricular()==4)
					root.addContent(new Element("FuncionVentricular").setText("31-35%"));
				else if(this.paciente.getSitclin().getFuncionventricular()==5)
					root.addContent(new Element("FuncionVentricular").setText(this.bundle.getString("sc_fvent_op5").toUpperCase()));
				else if(this.paciente.getSitclin().getFuncionventricular()==6)
					root.addContent(new Element("FuncionVentricular").setText(this.bundle.getString("sc_feyec_msg_5").toUpperCase()));
				else
					root.addContent(new Element("FuncionVentricular").setText(this.bundle.getString("sc_feyec_msg_4").toUpperCase()));
			}else{
				root.addContent(new Element("FuncionVentricular"));
			}
			// AI -mm
			root.addContent(new Element("AImm").setText(this.paciente.getSitclin().getAi()));
			// AI Dilatacion
			if(this.paciente.getSitclin().getAi2()!=null){
				if(this.paciente.getSitclin().getAi2()==1)
					root.addContent(new Element("AIDilatacion").setText(this.bundle.getString("sc_ai_msg_4").toUpperCase()));
				else if(this.paciente.getSitclin().getAi2()==2)
					root.addContent(new Element("AIDilatacion").setText(this.bundle.getString("sc_ai_msg_5").toUpperCase()));
				else if(this.paciente.getSitclin().getAi2()==3)
					root.addContent(new Element("AIDilatacion").setText(this.bundle.getString("sc_ai_msg_6").toUpperCase()));
				else
					root.addContent(new Element("AIDilatacion").setText(this.bundle.getString("sc_ai_msg_3").toUpperCase()));
			}else{
				root.addContent(new Element("AIDilatacion"));
			}
			// IC- NYHA
			if(this.paciente.getSitclin().getNyha()!=null){
				if(this.paciente.getSitclin().getNyha()==1)
					root.addContent(new Element("NYHA").setText("I"));
				else if(this.paciente.getSitclin().getNyha()==2)
					root.addContent(new Element("NYHA").setText("II"));
				else if(this.paciente.getSitclin().getNyha()==3)
					root.addContent(new Element("NYHA").setText("III"));
				else if(this.paciente.getSitclin().getNyha()==4)
					root.addContent(new Element("NYHA").setText("IV"));			
			}else
				root.addContent(new Element("NYHA"));
			// Cardiopatia
			root.addContent(new Element("Cardiopatia").setText(this.paciente.getSitclin().getCardiopatia()!=null?maestrasdao.findByPrimaryKey(this.paciente.getSitclin().getCardiopatia()).getValor():null));
			// A.Evolucion
			root.addContent(new Element("AEvolucion").setText((this.paciente.getSitclin().getAevolucion()!=null)?this.paciente.getSitclin().getAevolucion().toString():null));	
			//Revascularizacion
			root.addContent(new Element("Revascularizacion").setText((this.paciente.getSitclin().getRevasc()!=null && this.paciente.getSitclin().getRevasc()==1)?"1":null));	
			//Infarto previo
			root.addContent(new Element("Infartoprevio").setText((this.paciente.getSitclin().getInfprevio()!=null && this.paciente.getSitclin().getInfprevio()==1)?"1":null));		
			//Anio infarto previo
			root.addContent(new Element("AInfarto").setText((this.paciente.getSitclin().getAnio()!=null && this.paciente.getSitclin().getAnio().length()>0)?this.paciente.getSitclin().getAnio().toString():null));			
			// Arritmias ventriculares
			if(this.paciente.getSitclin().getArritmias()!=null){
				if(this.paciente.getSitclin().getNyha()==1)
					root.addContent(new Element("ArrVent").setText(this.bundle.getString("sc_antecedentes_arritmias_msg_2")));
				else if(this.paciente.getSitclin().getNyha()==2)
					root.addContent(new Element("ArrVent").setText(this.bundle.getString("sc_antecedentes_arritmias_msg_3")));
				else if(this.paciente.getSitclin().getNyha()==3)
					root.addContent(new Element("ArrVent").setText(this.bundle.getString("sc_antecedentes_arritmias_msg_4")));
				else if(this.paciente.getSitclin().getNyha()==4)
					root.addContent(new Element("ArrVent").setText(this.bundle.getString("sc_antecedentes_arritmias_msg_5")));			
			}else
				root.addContent(new Element("ArrVent"));
			// EEF previo - arritmia inducida
			if(this.paciente.getSitclin().getEef()!=null){
				if(this.paciente.getSitclin().getNyha()==1)
					root.addContent(new Element("EefPrev").setText(this.bundle.getString("sc_antecedentes_eef_msg_3")));
				else if(this.paciente.getSitclin().getNyha()==2)
					root.addContent(new Element("EefPrev").setText(this.bundle.getString("sc_antecedentes_eef_msg_4")));
				else if(this.paciente.getSitclin().getNyha()==3)
					root.addContent(new Element("EefPrev").setText(this.bundle.getString("sc_antecedentes_eef_msg_5")));
				else if(this.paciente.getSitclin().getNyha()==4)
					root.addContent(new Element("EefPrev").setText(this.bundle.getString("sc_antecedentes_eef_msg_6")));			
			}else
				root.addContent(new Element("EefPrev"));
			// Antecendentes cardiologicos
			root.addContent(new Element("InsRenal").setText((this.paciente.getSitclin().getInsrenal()!=null&&this.paciente.getSitclin().getInsrenal()==1)?"1":null));	
			root.addContent(new Element("FA").setText((this.paciente.getSitclin().getAntfa()!=null&&this.paciente.getSitclin().getAntfa()==1)?"1":null));	
			root.addContent(new Element("Diabetes").setText((this.paciente.getSitclin().getDiabetes()!=null&&this.paciente.getSitclin().getDiabetes()==1)?"1":null));	
			root.addContent(new Element("HTA").setText((this.paciente.getSitclin().getHta()!=null&&this.paciente.getSitclin().getHta()==1)?"1":null));	
			root.addContent(new Element("MuerteSubita").setText((this.paciente.getSitclin().getMuertesubita()!=null&&this.paciente.getSitclin().getMuertesubita()==1)?"1":null));	
			root.addContent(new Element("Tabaquismo").setText((this.paciente.getSitclin().getTabaquismo()!=null&&this.paciente.getSitclin().getTabaquismo()==1)?"1":null));	
			root.addContent(new Element("Dislipemia").setText((this.paciente.getSitclin().getDislipemia()!=null&&this.paciente.getSitclin().getDislipemia()==1)?"1":null));	
			root.addContent(new Element("ACV").setText((this.paciente.getSitclin().getAcv()!=null&&this.paciente.getSitclin().getAcv()==1)?"1":null));	
			root.addContent(new Element("TransplanteCardiaco").setText((this.paciente.getSitclin().getTrasplantecardiaco()!=null&&this.paciente.getSitclin().getTrasplantecardiaco()==1)?"1":null));	
			root.addContent(new Element("AIT").setText((this.paciente.getSitclin().getAit()!=null&&this.paciente.getSitclin().getAit()==1)?"1":null));	
			root.addContent(new Element("Sincope").setText((this.paciente.getSitclin().getSincope()!=null&&this.paciente.getSitclin().getSincope()==1)?"1":null));	
			root.addContent(new Element("ParadaCardiaca").setText((this.paciente.getSitclin().getParadacardiaca()!=null&&this.paciente.getSitclin().getParadacardiaca()==1)?"1":null));	
			root.addContent(new Element("EnfArt").setText((this.paciente.getSitclin().getEnfart()!=null&&this.paciente.getSitclin().getEnfart()==1)?"1":null));	
			// Antecedentes no cardiologicos
			root.addContent(new Element("EPOC").setText((this.paciente.getSitclin().getEpoc()!=null&&this.paciente.getSitclin().getEpoc()==1)?"1":null));	
			root.addContent(new Element("SAHS").setText((this.paciente.getSitclin().getSahs()!=null&&this.paciente.getSitclin().getSahs()==1)?"1":null));	
			if(this.paciente.getSitclin().getTiposahs()!=null){
				if(this.paciente.getSitclin().getTiposahs()==1)
					root.addContent(new Element("TipoSAHS").setText(this.bundle.getString("sc_antecedentes_nc_sahs_msg_3")));
				else if(this.paciente.getSitclin().getTiposahs()==2)
					root.addContent(new Element("TipoSAHS").setText(this.bundle.getString("sc_antecedentes_nc_sahs_msg_4")));
				else if(this.paciente.getSitclin().getTiposahs()==3)
					root.addContent(new Element("TipoSAHS").setText(this.bundle.getString("sc_antecedentes_nc_sahs_msg_5")));
				else if(this.paciente.getSitclin().getTiposahs()==4)
					root.addContent(new Element("TipoSAHS").setText(this.bundle.getString("sc_antecedentes_nc_sahs_msg_6")));
				else
					root.addContent(new Element("TipoSAHS"));
			}else
				root.addContent(new Element("TipoSAHS"));
			root.addContent(new Element("CPAP").setText((this.paciente.getSitclin().getCpap()!=null&&this.paciente.getSitclin().getCpap()==1)?"1":null));	
			root.addContent(new Element("Neoplasia").setText((this.paciente.getSitclin().getNeoplasia()!=null&&this.paciente.getSitclin().getNeoplasia()==1)?"1":null));	
			root.addContent(new Element("TipoNeoplasia").setText((this.paciente.getSitclin().getTiponeoplasia()!=null?this.paciente.getSitclin().getTiponeoplasia():null)));	
			
			if(this.paciente.getSitclin().getAfectiroidea()!=null){
				if(this.paciente.getSitclin().getAfectiroidea()==1)
					root.addContent(new Element("AfecTiroidea").setText(this.bundle.getString("sc_antecedentes_nc_tir_msg_2")));
				else if(this.paciente.getSitclin().getAfectiroidea()==2)
					root.addContent(new Element("AfecTiroidea").setText(this.bundle.getString("sc_antecedentes_nc_tir_msg_3")));
				else
					root.addContent(new Element("AfecTiroidea"));
			}else
				root.addContent(new Element("AfecTiroidea"));
			
			if(this.paciente.getSitclin().getNeuromediados()!=null){
				if(this.paciente.getSitclin().getNeuromediados()==1)
					root.addContent(new Element("Neuromediados").setText(this.bundle.getString("sc_antecedentes_nc_neur_msg_2")));
				else if(this.paciente.getSitclin().getNeuromediados()==2)
					root.addContent(new Element("Neuromediados").setText(this.bundle.getString("sc_antecedentes_nc_neur_msg_3")));
				else if(this.paciente.getSitclin().getNeuromediados()==3)
					root.addContent(new Element("Neuromediados").setText(this.bundle.getString("sc_antecedentes_nc_neur_msg_4")));
				else
					root.addContent(new Element("Neuromediados"));
			}else
				root.addContent(new Element("Neurologicos"));
			
			root.addContent(new Element("Comentarios").setText((this.paciente.getSitclin().getComentarios()!=null?this.paciente.getSitclin().getComentarios():null)));	
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte HC. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Reporte HC. Motivo: "+e.getMessage(),e);
		}
		
	}
}

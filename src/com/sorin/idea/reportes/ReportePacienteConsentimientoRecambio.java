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
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteComplicacionDaoImpl;
import com.sorin.idea.util.ConsentimientoBean;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilReporteInformes;

public class ReportePacienteConsentimientoRecambio {

	private static Logger logger = Logger.getLogger(ReportePacienteConsentimientoRecambio.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	
	private InfoCentro infocentro;
	private ConsentimientoBean cons;
	private ResourceBundle bundle;
	
	public ReportePacienteConsentimientoRecambio(String path, PacienteAplDto pacienteSelect, InfoCentro infocentro,ConsentimientoBean cons, ResourceBundle bundle){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.infocentro = infocentro;
		this.cons = cons;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	public void GeneraArchivoPlanilla(){
		Element root = new Element("CONSENTIMIENTORECAMBIO");
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
			//Direccion
			root.addContent(new Element("Direccion").setText(this.paciente.getDireccion()));
			//Poblacion
			root.addContent(new Element("Ciudad").setText(this.paciente.getPoblacion()));
			//Provincia
			root.addContent(new Element("Provincia").setText(this.paciente.getProvincia()));
			//telefono
			root.addContent(new Element("Telefono").setText(this.paciente.getTelefono()));
			
			// centro
			root.addContent(new Element("Centro").setText(this.infocentro.getCentro()));
			// poblacion centro
			root.addContent(new Element("CiudadCentro").setText(this.infocentro.getCiudad()));
			// servicio
			root.addContent(new Element("Servicio").setText(this.infocentro.getServicio()));
			// nombre doctor
			root.addContent(new Element("Doctor").setText(this.cons.getDoctor()));
			// Num. Colegiado
			root.addContent(new Element("NumCol").setText(this.cons.getNumcolegiado()));
			// Rep. Legal - nombre
			root.addContent(new Element("RepLegalNombre").setText(this.cons.getRepleg_nombre()));
			// Rep. Legal - apellido1
			root.addContent(new Element("RepLegalAp1").setText(this.cons.getRepleg_ap1()));
			// Rep. Legal - apellido2
			root.addContent(new Element("RepLegalAp2").setText(this.cons.getRepleg_ap2()));
			// Rep. Legal - DNI
			root.addContent(new Element("RepLegalDNI").setText(this.cons.getRepleg_dni()));
			// Riesgos
			root.addContent(new Element("Riesgos").setText(this.cons.getRiesgos()));
			// Riesgos
			root.addContent(new Element("Indicacion").setText(this.cons.getIndicacion()));
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte Consentimiento Recambio. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Reporte Consentimiento Recambio. Motivo: "+e.getMessage(),e);
		}
		
	}
}

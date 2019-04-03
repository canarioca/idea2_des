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
import com.sorin.idea.dto.SegClinComplicaciones;
import com.sorin.idea.dto.SegSeguimientoClinico;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.TestOrtostatismoActivo;
import com.sorin.idea.iu.ControlMaterial;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.util.UtilFechas;

public class ReporteTestOrto {

	private static Logger logger = Logger.getLogger(ReporteTestOrto.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	
	private TestOrtostatismoActivo test;
	private ResourceBundle bundle;
	
	public ReporteTestOrto(String path, PacienteAplDto pacienteSelect, 
			TestOrtostatismoActivo test, ResourceBundle bundle){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.test = test;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	
	public void GeneraArchivoPlantilla(){
		Element root = new Element("TEST_ORTO");
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
	        
			// Datos test
			root.addContent(new Element("Fecha").setText(UtilFechas.getFechaStringFormato(this.test.getFecha(), "dd/MM/yyyy")));
			
			root.addContent(new Element("DEC_TAD").setText(this.test.getDecTad()));
			root.addContent(new Element("DEC_TAS").setText(this.test.getDecTas()));
			root.addContent(new Element("DEC_FC").setText(this.test.getDecFc()));
			
			root.addContent(new Element("ORT_TAD").setText(this.test.getOrtTad()));
			root.addContent(new Element("ORT_TAS").setText(this.test.getOrtTas()));
			root.addContent(new Element("ORT_FC").setText(this.test.getOrtFc()));
			
			root.addContent(new Element("VAR_TAD").setText(this.test.getVarTad()));
			root.addContent(new Element("VAR_TAS").setText(this.test.getVarTas()));
			String res = "";
			if(this.test.getRes()!=null)
				res =(this.test.getRes().equals(1))?this.bundle.getString("test_orto_resultado_pos"):this.bundle.getString("test_orto_resultado_neg");
			root.addContent(new Element("Resultado").setText(res));
			
			root.addContent(new Element("Operador").setText(this.test.getOperador()));
			root.addContent(new Element("Enfermeria").setText(this.test.getEnfermeria()));
			root.addContent(new Element("Comentarios").setText(this.test.getComentarios()));
			
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Test Ortostatismo Activo. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Test Ortostatismo Activo. Motivo: "+e.getMessage(),e);
		}
	}
}

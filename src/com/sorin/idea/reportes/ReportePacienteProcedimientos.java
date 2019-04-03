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
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.ProcedimientosClinicos;
import com.sorin.idea.util.UtilReporteInformes;

public class ReportePacienteProcedimientos {

	private static Logger logger = Logger.getLogger(ReportePacienteProcedimientos.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	
	private ArrayList<ProcedimientosClinicos> listaprocs;
	private ResourceBundle bundle;
	
	
	public ReportePacienteProcedimientos(String path, PacienteAplDto pacienteSelect,ArrayList<ProcedimientosClinicos> prs, ResourceBundle bundle){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.listaprocs = prs;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	public void GeneraArchivoPlanilla(){
		Element root = new Element("PROCEDIMIENTOS");
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
			
			// Lista procedimientos
			ArrMaestrasDao maestrasdao = new ArrMaestrasDaoImpl("consultor");
			for(ProcedimientosClinicos p:this.listaprocs){
				Element el = new Element("Procedimiento");
				String tipoproc =null;
				if(p.getTipoproc().equals(956))
					tipoproc = this.bundle.getString("proc_956");
				else if(p.getTipoproc().equals(957))
					tipoproc = this.bundle.getString("proc_957");
				else if(p.getTipoproc().equals(1059))
					tipoproc = this.bundle.getString("proc_1059");
				else if(p.getTipoproc().equals(1060))
					tipoproc = this.bundle.getString("proc_1060");
				else if(p.getTipoproc().equals(993))
					tipoproc = this.bundle.getString("proc_993");
				else if(p.getTipoproc().equals(1085))
					tipoproc = this.bundle.getString("proc_1085");
				else if(p.getTipoproc().equals(1086))
					tipoproc = this.bundle.getString("proc_1086");
				else if(p.getTipoproc().equals(1090))
					tipoproc = this.bundle.getString("proc_1090");
				else if(p.getTipoproc().equals(1147))
					tipoproc = this.bundle.getString("proc_label_exp_2");
				else if(p.getTipoproc().equals(1061))
					tipoproc = this.bundle.getString("proc_label_eef_abl");
				else if(p.getTipoproc().equals(1068))
					tipoproc = this.bundle.getString("proc_1068");
				else if(p.getTipoproc().equals(1066))
					tipoproc = this.bundle.getString("proc_1066");
				else if(p.getTipoproc().equals(1067))
					tipoproc = this.bundle.getString("proc_1067");
				else if(p.getTipoproc().equals(1063))
					tipoproc = this.bundle.getString("proc_1063");
				else if(p.getTipoproc().equals(1064))
					tipoproc = this.bundle.getString("proc_1064");
				else if(p.getTipoproc().equals(1065))
					tipoproc = this.bundle.getString("proc_1065");
				else if(p.getTipoproc().equals(983))
					tipoproc = this.bundle.getString("proc_983");
				else if(p.getTipoproc().equals(1087))
					tipoproc = this.bundle.getString("proc_1087");
				else if(p.getTipoproc().equals(1089))
					tipoproc = this.bundle.getString("proc_1089");
				else if(p.getTipoproc().equals(1091))
					tipoproc = this.bundle.getString("proc_1091");
				
				el.addContent(new Element("TipoProcedimiento").setText(tipoproc));
				el.addContent(new Element("Fecha").setText(p.getFecha()!=null?sdf.format(p.getFecha()):null));
				el.addContent(new Element("Comentarios").setText(p.getObs()));
				
				root.addContent(el);
			}	
				
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte Procedimientos. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Reporte Procedimientos. Motivo: "+e.getMessage(),e);
		}
		
	}
}

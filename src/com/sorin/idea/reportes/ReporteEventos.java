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
import com.sorin.idea.dto.Agenda;
import com.sorin.idea.dto.ArrAcceso;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Evento;
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
import com.sorin.idea.iu.ControlMaterial;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteComplicacionDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.ProcedimientosClinicos;
import com.sorin.idea.util.UtilReporteInformes;

public class ReporteEventos {

	private static Logger logger = Logger.getLogger(ReporteEventos.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	
	private Evento[] eventos;
	private Agenda agenda;
	private ArrAcceso usuario;
	private String tipo;
	private String dia;
	private String semana;
	private String mes;
	private ResourceBundle bundle;
	
	public ReporteEventos(String path, Evento[] eventos, Agenda agenda, ArrAcceso usuario, String tipo, String dia, String semana, String mes, ResourceBundle bundle){
		this.pathFichero = path;		
		this.eventos = eventos;
		this.agenda = agenda;
		this.usuario = usuario;
		this.tipo = tipo;
		this.dia = dia;
		this.semana = semana;
		this.mes = mes;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	public void GeneraArchivoPlanilla(){
		Element root = new Element("EVENTOS");
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		try{
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
			
	        root.addContent(new Element("Usuario").setText(this.usuario.getUsuario()));
	        root.addContent(new Element("TipoInforme").setText(this.tipo));
	        root.addContent(new Element("NombreAgenda").setText(this.agenda.getNombre()));
	        
	        root.addContent(new Element("Dia").setText(this.dia));
	        root.addContent(new Element("Semana").setText(this.semana));
	        root.addContent(new Element("Mes").setText(this.mes));
	        
			// Lista eventos
			ArrMaestrasDao maestrasdao = new ArrMaestrasDaoImpl("consultor");
			for(Evento e:this.eventos){
				Element el = new Element("Procedimiento");
				String tipoproc =null;
				if(e.getProcedimiento().equals(956))
					tipoproc = this.bundle.getString("proc_956");
				else if(e.getProcedimiento().equals(957))
					tipoproc = this.bundle.getString("proc_957");
				else if(e.getProcedimiento().equals(1059))
					tipoproc = this.bundle.getString("proc_1059");
				else if(e.getProcedimiento().equals(1060))
					tipoproc = this.bundle.getString("proc_1060");
				else if(e.getProcedimiento().equals(993))
					tipoproc = this.bundle.getString("proc_993");
				else if(e.getProcedimiento().equals(1085))
					tipoproc = this.bundle.getString("proc_1085");
				else if(e.getProcedimiento().equals(1086))
					tipoproc = this.bundle.getString("proc_1086");
				else if(e.getProcedimiento().equals(1147))
					tipoproc = this.bundle.getString("proc_label_exp_2");
				else if(e.getProcedimiento().equals(1090))
					tipoproc = this.bundle.getString("proc_1090");
				else if(e.getProcedimiento().equals(1061))
					tipoproc = this.bundle.getString("proc_label_eef_abl");
				else if(e.getProcedimiento().equals(1068))
					tipoproc = this.bundle.getString("proc_1068");
				else if(e.getProcedimiento().equals(1066))
					tipoproc = this.bundle.getString("proc_1066");
				else if(e.getProcedimiento().equals(1067))
					tipoproc = this.bundle.getString("proc_1067");
				else if(e.getProcedimiento().equals(1088))
					tipoproc = this.bundle.getString("proc_1088");
				else if(e.getProcedimiento().equals(1063))
					tipoproc = this.bundle.getString("proc_1063");
				else if(e.getProcedimiento().equals(1064))
					tipoproc = this.bundle.getString("proc_1064");
				else if(e.getProcedimiento().equals(1065))
					tipoproc = this.bundle.getString("proc_1065");
				else if(e.getProcedimiento().equals(983))
					tipoproc = this.bundle.getString("proc_983");
				else if(e.getProcedimiento().equals(1087))
					tipoproc = this.bundle.getString("proc_1087");
				else if(e.getProcedimiento().equals(1089))
					tipoproc = this.bundle.getString("proc_1089");
				else if(e.getProcedimiento().equals(1091))
					tipoproc = this.bundle.getString("proc_1091");
				
				el.addContent(new Element("TipoProcedimiento").setText(tipoproc));
				el.addContent(new Element("FechaInicio").setText(e.getFechaini()!=null?sdf.format(e.getFechaini()):null));
				el.addContent(new Element("FechaFin").setText(e.getFechafin()!=null?sdf.format(e.getFechafin()):null));
				el.addContent(new Element("NHC").setText(e.getIdpaciente()!=null?e.getIdpaciente():null));
				el.addContent(new Element("Nombre").setText(e.getNombre()!=null?e.getNombre():null));
				el.addContent(new Element("Apellido1").setText(e.getApellido1()!=null?e.getApellido1():null));
				el.addContent(new Element("Apellido2").setText(e.getApellido2()!=null?e.getApellido2():null));
				el.addContent(new Element("IdCita").setText(e.getIdentificador()!=null?e.getIdentificador():null));
				el.addContent(new Element("Descripcion").setText(e.getDescripcion()!=null?e.getDescripcion():null));
				
				root.addContent(el);
			}	
				
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte Eventos Citación. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Reporte Eventos Citación. Motivo: "+e.getMessage(),e);
		}
		
	}
}

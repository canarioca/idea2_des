package com.sorin.idea.reportes;

import hvn.cm.dao.DAOException;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dao.ElectrodosDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplantePop;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.util.Suministro;
import com.sorin.idea.util.UtilReporteInformes;

public class ReporteSuministro {

	private static Logger logger = Logger.getLogger(ReporteSuministro.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	
	private ArrayList<ImpGenerador> gens;
	private ArrayList<ImpImplanteElectrodos> elecs;
	private ArrayList<ImpHojaImplantePop> poperador;
	private Procedimiento proc;
	private ImpEvolucion hev;
	private ImpHojaImplante himp;
	private SituacionClinicaProc hind;
	private UtilReporteInformes report;
	
	
	public ReporteSuministro(String path,
			PacienteAplDto pacienteSelect,
			ArrayList<ImpGenerador> listagenerador,
			ArrayList<ImpImplanteElectrodos> listaelectrodos,
			ArrayList<ImpHojaImplantePop> poperador,Procedimiento proc,ImpEvolucion hev, ImpHojaImplante himp,SituacionClinicaProc hind,UtilReporteInformes rep) {
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.gens = listagenerador;
		this.elecs = listaelectrodos;
		this.proc = proc;
		this.poperador = poperador;
		this.hev = hev;
		this.himp = himp;
		this.report = rep;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}


	public void GeneraArchivoPlantilla() {
		Element raiz = new Element("SUMINISTROS");
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy");
		GeneradorDao gendao = new GeneradorDaoImpl("informes");
		ElectrodosDao eldao = new ElectrodosDaoImpl("informes");
		
		try{
			File fg = new File(req.getRealPath(rutaImagen));
	        raiz.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
	        
	        // TODO para cada instalacion
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		Document doc = new Document(raiz);
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
			logger.error("Error generando fichero XML para informe - Reporte Suministro. Motivo: "+e.getMessage(),e);
		}
		
	}
	
	private String getTipoGenerador(String d){
		if(d!=null){
			if(d.equals("1"))
				return "MARCAPASOS";
			else if(d.equals("2"))
				return "DAI";
			else if(d.equals("3"))
				return "CRT-P";
			else if(d.equals("4"))
				return "CRT-D";
			else
				return "";
		}
		return "";
	}
}

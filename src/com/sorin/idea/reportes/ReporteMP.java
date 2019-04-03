package com.sorin.idea.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dto.ArrTestAtp;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.util.TarjetaMP;

import hvn.cm.dao.DAOException;

public class ReporteMP {

	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	
	private String modelo;
	private String numserie;
	private String comentarios;
	private Date fecha;
	private String med;
	
	private TarjetaMP tarjeta;
	
	public ReporteMP(String path, PacienteAplDto pacienteSelect, String modelo, String serie, String com, Date fecha, String med) {
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.modelo = modelo;
		this.numserie = serie;
		this.comentarios = com;
		this.fecha = fecha;
		this.med = med;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	
	public ReporteMP(String path, PacienteAplDto pacienteSelect, TarjetaMP tr){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.tarjeta = tr;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	
	public void GeneraArchivoPlanilla() {
		ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
		Element root = new Element("Marcapasos");

		try {
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
			root.addContent(new Element("Fecha").setText(new Date().toLocaleString()));
			root.addContent(new Element("Edad").setText(this.paciente.getEdad()));
			root.addContent(new Element("Nombre").setText(this.paciente.getNombreCompleto()));
			root.addContent(new Element("NHC").setText(this.paciente.getNhc()));

			if(this.modelo != null)
				root.addContent(new Element("modelomp").setText(this.modelo));
			else
				root.addContent(new Element("modelomp").setText("No se ha especificado modelo de marcapasos"));
			if(this.numserie != null)
				root.addContent(new Element("numeroserie").setText(this.numserie));
			else
				root.addContent(new Element("numeroserie").setText("No se ha especificado número de serie"));
			if(this.comentarios != null)
				root.addContent(new Element("comentarios").setText(this.comentarios));
			else
				root.addContent(new Element("comentarios").setText(" "));
			if(this.fecha != null)
				root.addContent(new Element("fechaimplante").setText(this.fecha.toLocaleString()));
			else
				root.addContent(new Element("fechaimplante").setText("No se ha especificado fecha de implante"));
			if(this.med != null)
				root.addContent(new Element("medico").setText(this.med));
			else
				root.addContent(new Element("medico").setText("No se ha especificado implantador"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Document doc = new Document(root);

		try {
			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			// XMLOutputter out= new XMLOutputter();
			FileOutputStream file = new FileOutputStream(pathFichero);
			out.output(doc, file);
			file.flush();
			file.close();
			// out.output(doc, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void GeneraArchivoPlanilla2() {
		ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
		Element root = new Element("TarjetaMP");
		
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		try {
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
			root.addContent(new Element("Fecha").setText(sdf.format(new Date())));
			root.addContent(new Element("Edad").setText(this.paciente.getEdad()));
			root.addContent(new Element("Nombre").setText(this.paciente.getNombreCompleto()));
			root.addContent(new Element("Direccion").setText(this.paciente.getDireccion()));
			root.addContent(new Element("Ciudad").setText(this.paciente.getPoblacion()));
			root.addContent(new Element("CodigoPostal").setText(this.paciente.getCp()));
			root.addContent(new Element("Pais").setText(this.paciente.getPais()));
			root.addContent(new Element("Telefono").setText(this.paciente.getTelefono1()));
			// cambio formato YYYY-MM-DD
			root.addContent(new Element("FechaNacimiento").setText(sdf.format(this.paciente.getFechaNaci())));
			// tratarlo 1 F, 2 M
			if(this.paciente.getSexo()!= null){
				if(this.paciente.getSexo().toString().equals("1"))
					root.addContent(new Element("Sexo").setText("M"));
				else 
					root.addContent(new Element("Sexo").setText("F"));
			}else{
				root.addContent(new Element("Sexo").setText("U"));
			}
			root.addContent(new Element("NHC").setText(this.paciente.getNhc()));
			root.addContent(new Element("DNI").setText(this.paciente.getDni()));

			if(this.tarjeta.getFechaprimerimplante() != null)
				root.addContent(new Element("FechaPrimerImplante").setText(sdf.format(this.tarjeta.getFechaprimerimplante())));
			if(this.tarjeta.getSintprim() != null)
				root.addContent(new Element("Sintoma1").setText(this.tarjeta.getSintprim()));
			if(this.tarjeta.getSintsec() != null)
				root.addContent(new Element("Sintoma2").setText(this.tarjeta.getSintsec()));
			if(this.tarjeta.getEcgprim() != null)
				root.addContent(new Element("ECG1").setText(this.tarjeta.getEcgprim()));
			if(this.tarjeta.getEcgsec() != null)
				root.addContent(new Element("ECG2").setText(this.tarjeta.getEcgsec()));
			if(this.tarjeta.getEtioprim() != null)
				root.addContent(new Element("Etiologia1").setText(this.tarjeta.getEtioprim()));
			if(this.tarjeta.getEtiosec() != null)
				root.addContent(new Element("Etiologia2").setText(this.tarjeta.getEtiosec()));
			if(this.tarjeta.getDependientemp() >= 0)
				root.addContent(new Element("DependienteMP").setText(String.valueOf(this.tarjeta.getDependientemp())));
			if(this.tarjeta.getDoctor() != null)
				root.addContent(new Element("Doctor").setText(this.tarjeta.getDoctor()));
			if(this.tarjeta.getHospital() != null)
				root.addContent(new Element("Hospital").setText(this.tarjeta.getHospital()));
			if(this.tarjeta.getDirhosp() != null)
				root.addContent(new Element("DireccionHospital").setText(this.tarjeta.getDirhosp()));
			if(this.tarjeta.getCiudadhosp() != null)
				root.addContent(new Element("CiudadHospital").setText(this.tarjeta.getCiudadhosp()));
			if(this.tarjeta.getTfnohosp() != null)
				root.addContent(new Element("TelefonoHospital").setText(this.tarjeta.getTfnohosp()));
			
			root.addContent(new Element("PaisHospital").setText("ES"));
			
			if(this.tarjeta.getFrecgen() != null)
				root.addContent(new Element("FrecMinima").setText(this.tarjeta.getFrecgen()));
			if(this.tarjeta.getModogen() != null)
				root.addContent(new Element("ModoEstimulacion").setText(this.tarjeta.getModogen()));
			if(this.tarjeta.getDurimpgen() != null)
				root.addContent(new Element("DuracionImp").setText(this.tarjeta.getDurimpgen()));
			if(this.tarjeta.getFechaimpgen() != null)
				root.addContent(new Element("FechaImplante").setText(sdf.format(this.tarjeta.getFechaimpgen())));
			if(this.tarjeta.getFabgen() != null)
				root.addContent(new Element("Fabricante").setText(this.tarjeta.getFabgen()));
			if(this.tarjeta.getModelogen() != null)
				root.addContent(new Element("Modelo").setText(this.tarjeta.getModelogen()));
			if(this.tarjeta.getNumseriegen() != null)
				root.addContent(new Element("NumSerie").setText(this.tarjeta.getNumseriegen()));
			
			
			if(this.tarjeta.getFechaimpea() != null)
				root.addContent(new Element("FechaImplanteEA").setText(sdf.format(this.tarjeta.getFechaimpea())));
			if(this.tarjeta.getFabea() != null)
				root.addContent(new Element("FabricanteEA").setText(this.tarjeta.getFabea()));
			if(this.tarjeta.getModeloea() != null)
				root.addContent(new Element("ModeloEA").setText(this.tarjeta.getModeloea()));
			if(this.tarjeta.getNumserieea() != null)
				root.addContent(new Element("NumSerieEA").setText(this.tarjeta.getNumserieea()));
			
			if(this.tarjeta.getIsea())
				root.addContent(new Element("IS1EA").setText("1"));
			else
				root.addContent(new Element("IS1EA").setText("0"));
			
			if(this.tarjeta.getUnibiea()==1){
				root.addContent(new Element("UniEA").setText("1"));
				root.addContent(new Element("BiEA").setText("0"));
			}else{
				root.addContent(new Element("UniEA").setText("0"));
				root.addContent(new Element("BiEA").setText("1"));
			}
			
			if(this.tarjeta.getFechaimpev() != null)
				root.addContent(new Element("FechaImplanteEV").setText(sdf.format(this.tarjeta.getFechaimpev())));
			if(this.tarjeta.getFabev() != null)
				root.addContent(new Element("FabricanteEV").setText(this.tarjeta.getFabev()));
			if(this.tarjeta.getModeloev() != null)
				root.addContent(new Element("ModeloEV").setText(this.tarjeta.getModeloev()));
			if(this.tarjeta.getNumserieev() != null)
				root.addContent(new Element("NumSerieEV").setText(this.tarjeta.getNumserieev()));
			
			if(this.tarjeta.getIsev())
				root.addContent(new Element("IS1EV").setText("1"));
			else
				root.addContent(new Element("IS1EV").setText("0"));
			
			if(this.tarjeta.getUnibiev()==1){
				root.addContent(new Element("UniEV").setText("1"));
				root.addContent(new Element("BiEV").setText("0"));
			}else{
				root.addContent(new Element("UniEV").setText("0"));
				root.addContent(new Element("BiEV").setText("1"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		Document doc = new Document(root);

		try {
			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			// XMLOutputter out= new XMLOutputter();
			FileOutputStream file = new FileOutputStream(pathFichero);
			out.output(doc, file);
			file.flush();
			file.close();
			// out.output(doc, System.out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

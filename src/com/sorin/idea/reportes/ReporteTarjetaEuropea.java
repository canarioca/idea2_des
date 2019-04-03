package com.sorin.idea.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;

import hvn.cm.dao.DAOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpIndicacion;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.TarjetaMP;

public class ReporteTarjetaEuropea {

	private static Logger logger = Logger.getLogger(ReporteTarjetaEuropea.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	
	private TarjetaMP tarjeta;
	
	public ReporteTarjetaEuropea(String path, PacienteAplDto pacienteSelect,TarjetaMP tr){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.tarjeta = tr;
		
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	public void GeneraArchivoPlanilla(){
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
			root.addContent(new Element("FechaNacimiento").setText(this.paciente.getFechaNaci()!=null?sdf.format(this.paciente.getFechaNaci()):null));
			// tratarlo 1 F, 2 M
			if(this.paciente.getSexo()!= null){
				if(this.paciente.getSexo().toString().equals("1"))
					root.addContent(new Element("Sexo").setText("M"));
				else 
					root.addContent(new Element("Sexo").setText("F"));
			}else{
				root.addContent(new Element("Sexo").setText("U"));
			}
			//root.addContent(new Element("NHC").setText(this.paciente.getNhc()));
			//root.addContent(new Element("DNI").setText(this.paciente.getDni()));
			root.addContent(new Element("NHC").setText(this.paciente.getNss1()));
			root.addContent(new Element("DNI").setText(this.paciente.getNhc()));

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
			
			if(this.tarjeta.getIsea()){
				root.addContent(new Element("IS1EA").setText("1"));
				if(this.tarjeta.getUnibiea()==1){
					root.addContent(new Element("UniEA").setText("1"));
					root.addContent(new Element("BiEA").setText("0"));
				}else if(this.tarjeta.getUnibiea()==0){
					root.addContent(new Element("UniEA").setText("0"));
					root.addContent(new Element("BiEA").setText("1"));
				}
			}	
			else
				root.addContent(new Element("IS1EA").setText("0"));
			

			if(this.tarjeta.getFechaimpev() != null)
				root.addContent(new Element("FechaImplanteEV").setText(sdf.format(this.tarjeta.getFechaimpev())));
			if(this.tarjeta.getFabev() != null)
				root.addContent(new Element("FabricanteEV").setText(this.tarjeta.getFabev()));
			if(this.tarjeta.getModeloev() != null)
				root.addContent(new Element("ModeloEV").setText(this.tarjeta.getModeloev()));
			if(this.tarjeta.getNumserieev() != null)
				root.addContent(new Element("NumSerieEV").setText(this.tarjeta.getNumserieev()));
			
			if(this.tarjeta.getIsev()){
				root.addContent(new Element("IS1EV").setText("1"));
				if(this.tarjeta.getUnibiev()==1){
					root.addContent(new Element("UniEV").setText("1"));
					root.addContent(new Element("BiEV").setText("0"));
				}else if(this.tarjeta.getUnibiev()==0){
						root.addContent(new Element("UniEV").setText("0"));
						root.addContent(new Element("BiEV").setText("1"));
				}
			}	
			else
				root.addContent(new Element("IS1EV").setText("0"));
			
			
			/************* BLOQUE EXPLANTES *******************/
			if(this.tarjeta.getFechaexplante() != null)
				root.addContent(new Element("FechaExplante").setText(sdf.format(this.tarjeta.getFechaexplante())));
			
			if(this.tarjeta.getMotivoexpgen() != null)
				root.addContent(new Element("MotivoExplanteGen").setText(this.tarjeta.getMotivoexpgen()));
			if(this.tarjeta.getFechaimpgenexp() != null)
				root.addContent(new Element("FechaImplanteGenExplante").setText(sdf.format(this.tarjeta.getFechaimpgenexp())));
			if(this.tarjeta.getFabgenexp() != null)
				root.addContent(new Element("FabricanteGenExplante").setText(this.tarjeta.getFabgenexp()));
			if(this.tarjeta.getModogenexp() != null)
				root.addContent(new Element("ModoEstimGenExplante").setText(this.tarjeta.getModogenexp()));
			if(this.tarjeta.getModelogenexp() != null)
				root.addContent(new Element("ModeloGenExplante").setText(this.tarjeta.getModelogenexp()));
			if(this.tarjeta.getNumseriegenexp() != null)
				root.addContent(new Element("NumSerieGenExplante").setText(this.tarjeta.getNumseriegenexp()));
			
			
			if(this.tarjeta.getMotivoexpea() != null)
				root.addContent(new Element("MotivoExplanteEA").setText(this.tarjeta.getMotivoexpea()));
			if(this.tarjeta.getFechaimpeaexp() != null)
				root.addContent(new Element("FechaImplanteEAExplante").setText(sdf.format(this.tarjeta.getFechaimpeaexp())));
			if(this.tarjeta.getFabeaexp() != null)
				root.addContent(new Element("FabricanteEAExplante").setText(this.tarjeta.getFabeaexp()));
			if(this.tarjeta.getModeloeaexp() != null)
				root.addContent(new Element("ModeloEAExplante").setText(this.tarjeta.getModeloeaexp()));
			if(this.tarjeta.getNumserieeaexp() != null)
				root.addContent(new Element("NumSerieEAExplante").setText(this.tarjeta.getNumserieeaexp()));
			
			if(this.tarjeta.isIseaexp()){
				root.addContent(new Element("IS1EAExplante").setText("1"));
				if(this.tarjeta.getUnibieaexp()==1){
					root.addContent(new Element("UniEAExplante").setText("1"));
					root.addContent(new Element("BiEAExplante").setText("0"));
				}else if(this.tarjeta.getUnibieaexp()==0){
					root.addContent(new Element("UniEAExplante").setText("0"));
					root.addContent(new Element("BiEAExplante").setText("1"));
				}
			}	
			else
				root.addContent(new Element("IS1EAExplante").setText("0"));
				
			if(this.tarjeta.getMotivoexpea() != null)
				root.addContent(new Element("MotivoExplanteEV").setText(this.tarjeta.getMotivoexpev()));
			if(this.tarjeta.getFechaimpeevxp() != null)
				root.addContent(new Element("FechaImplanteEVExplante").setText(sdf.format(this.tarjeta.getFechaimpeevxp())));
			if(this.tarjeta.getFabevexp() != null)
				root.addContent(new Element("FabricanteEVExplante").setText(this.tarjeta.getFabevexp()));
			if(this.tarjeta.getModeloevexp() != null)
				root.addContent(new Element("ModeloEVExplante").setText(this.tarjeta.getModeloevexp()));
			if(this.tarjeta.getNumserieevexp() != null)
				root.addContent(new Element("NumSerieEVExplante").setText(this.tarjeta.getNumserieevexp()));
			
			if(this.tarjeta.isIsevexp()){
				root.addContent(new Element("IS1EVExplante").setText("1"));
				if(this.tarjeta.getUnibievexp()==1){
					root.addContent(new Element("UniEVExplante").setText("1"));
					root.addContent(new Element("BiEVExplante").setText("0"));
				}else if(this.tarjeta.getUnibievexp()==0){
					root.addContent(new Element("UniEVExplante").setText("0"));
					root.addContent(new Element("BiEVExplante").setText("1"));
				}
			}
			else
				root.addContent(new Element("IS1EVExplante").setText("0"));	
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Tarjeta Europea Portador de MPS. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Tarjeta Europea Portador de MPS. Motivo: "+e.getMessage(),e);
		}
	}
	
}

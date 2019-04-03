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
import com.sorin.idea.iu.ControlMaterial;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.util.UtilFechas;

public class ReporteSeguimientoClinico {

	private static Logger logger = Logger.getLogger(ReporteSeguimientoClinico.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	
	private SituacionClinicaProc sc;
	private SegSeguimientoClinico seg;
	private ArrayList<SegClinComplicaciones> comps;
	private ResourceBundle bundle;
	
	public ReporteSeguimientoClinico(String path, PacienteAplDto pacienteSelect, 
			SituacionClinicaProc sc, SegSeguimientoClinico seg, ArrayList<SegClinComplicaciones> comps,ResourceBundle bundle){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.sc = sc;
		this.seg = seg;
		this.comps = comps;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	
	public void GeneraArchivoPlantilla(){
		Element root = new Element("SEGUIMIENTOCLINICO");
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy");
		ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
		try{
			ArrMaestrasDao maestrasdao = new ArrMaestrasDaoImpl("");
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
	        
			// SITUACION CLÍNICA
			//Sintomas
			String sint = "";
			for(SintomasSitclinProc s:this.sc.getSintomas()){
				sint = sint + s.getIdsintomas()+", ";
			}
			if(sint.length()>0)
				sint = sint.substring(0, sint.length()-2);
			root.addContent(new Element("Sintoma").setText(sint));
			//Ritmo basal
			root.addContent(new Element("Ritmobasal").setText(this.sc.getRitmo()!=null && this.sc.getRitmo()!=0?maestrasdao.findByPrimaryKey(this.sc.getRitmo()).getValor():null));
			// Ritmo 2
			root.addContent(new Element("Ritmobasal2").setText(this.sc.getRitmo2()!=null && this.sc.getRitmo2()!=0?maestrasdao.findByPrimaryKey(this.sc.getRitmo2()).getValor():null));
			//conduccion av
			root.addContent(new Element("Conduccionav").setText(this.sc.getConducav()!=null && this.sc.getConducav()!=0?maestrasdao.findByPrimaryKey(this.sc.getConducav()).getValor():null));
			//conduccion qrs
			root.addContent(new Element("Qrs").setText(this.sc.getQrs()!=null && this.sc.getQrs()!=0?maestrasdao.findByPrimaryKey(this.sc.getQrs()).getValor():null));
			//anchura qrs
			root.addContent(new Element("Anchuraqrs").setText((this.sc.getAnchuraqrs()!=null)?this.sc.getAnchuraqrs().toString():null));
			//nyha
			if(this.sc.getNyha()!=null){
				if(this.sc.getNyha()==1)
					root.addContent(new Element("Nyha").setText("I"));
				else if(this.sc.getNyha()==2)
					root.addContent(new Element("Nyha").setText("II"));
				else if(this.sc.getNyha()==3)
					root.addContent(new Element("Nyha").setText("III"));
				else if(this.sc.getNyha()==4)
					root.addContent(new Element("Nyha").setText("IV"));
				else
					root.addContent(new Element("Nyha"));
			}else{
				root.addContent(new Element("Nyha"));
			}
			//cardiopatia
			root.addContent(new Element("Cardiopatia").setText(this.sc.getCardiopatia()!=null && this.sc.getCardiopatia()!=0?maestrasdao.findByPrimaryKey(this.sc.getCardiopatia()).getValor():null));
			//aevolucion
			root.addContent(new Element("AEvolucion").setText((this.sc.getAevolucion()!=null)?this.sc.getAevolucion().toString():null));	
			//revascularizacion
			root.addContent(new Element("Revascularizacion").setText((this.sc.getRevasc()!=null && this.sc.getRevasc()==1)?"1":null));	
			//infarto previo
			root.addContent(new Element("Infartoprevio").setText((this.sc.getInfprevio()!=null && this.sc.getInfprevio()==1)?"1":null));		
			//anio infarto previo
			root.addContent(new Element("AInfarto").setText((this.sc.getAnio()!=null && this.sc.getAnio().length()>0)?this.sc.getAnio().toString():null));			
			// Antecedentes 
			Short comp = 1;// mysql
			root.addContent(new Element("HTA").setText(this.sc.getHta()!=null && this.sc.getHta().equals(comp)?"1":null));
			root.addContent(new Element("Dislipemia").setText(this.sc.getDislipemia()!=null && this.sc.getDislipemia().equals(comp)?"1":null));
			root.addContent(new Element("Diabetes").setText(this.sc.getDiabetes()!=null && this.sc.getDiabetes().equals(comp)?"1":null));
			root.addContent(new Element("Tabaquismo").setText(this.sc.getTabaquismo()!=null && this.sc.getTabaquismo().equals(comp)?"1":null));
			root.addContent(new Element("Alcohol").setText(this.sc.getIngalcoholica()!=null && this.sc.getIngalcoholica().equals(comp)?"1":null));
			root.addContent(new Element("ACV").setText(this.sc.getAcv()!=null && this.sc.getAcv().equals(comp)?"1":null));
			root.addContent(new Element("AIT").setText(this.sc.getAit()!=null && this.sc.getAit().equals(comp)?"1":null));
			root.addContent(new Element("EPOC").setText(this.sc.getEpoc()!=null && this.sc.getEpoc().equals(comp)?"1":null));
			root.addContent(new Element("SAHS").setText(this.sc.getSahs()!=null && this.sc.getSahs().equals(comp)?"1":null));
			String tiposahs=null;
			if(this.sc.getTiposahs()!=null){				
				if(this.sc.getTiposahs().equals(1))
					tiposahs = this.bundle.getString("sc_antecedentes_nc_sahs_msg_3");
				else if(this.sc.getTiposahs().equals(2))
					tiposahs = this.bundle.getString("sc_antecedentes_nc_sahs_msg_4");
				else if(this.sc.getTiposahs().equals(3))
					tiposahs = this.bundle.getString("sc_antecedentes_nc_sahs_msg_5");
				else if(this.sc.getTiposahs().equals(4))
					tiposahs = this.bundle.getString("sc_antecedentes_nc_sahs_msg_6");
			}
			root.addContent(new Element("TipoSAHS").setText(tiposahs));
			root.addContent(new Element("InsRenal").setText(this.sc.getInsrenal()!=null && this.sc.getInsrenal().equals(comp)?"1":null));
			root.addContent(new Element("Neoplasia").setText(this.sc.getNeoplasia()!=null && this.sc.getNeoplasia().equals(comp)?"1":null));
			root.addContent(new Element("TipoNeopladia").setText(this.sc.getTiponeoplasia()!=null?this.sc.getTiponeoplasia():null));
			String afec_tir=null;
			if(this.sc.getAfectiroidea()!=null){
				if(this.sc.getAfectiroidea().equals(1))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_tir_msg_2");
				else if(this.sc.getAfectiroidea().equals(2))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_tir_msg_3");
			}
			root.addContent(new Element("AfecTiroidea").setText(afec_tir));
						
			root.addContent(new Element("FA").setText(this.sc.getAntfa()!=null && this.sc.getAntfa().equals(comp)?"1":null));
			root.addContent(new Element("MuerteSubita").setText(this.sc.getMuertesubita()!=null && this.sc.getMuertesubita().equals(comp)?"1":null));
			String neuro=null;
			if(this.sc.getNeuromediados()!=null){
				if(this.sc.getNeuromediados().equals(1))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_neur_msg_2");
				else if(this.sc.getNeuromediados().equals(2))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_neur_msg_3");
				else if(this.sc.getNeuromediados().equals(3))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_neur_msg_4");
			}
			root.addContent(new Element("Neuromediados").setText(neuro));
						
			root.addContent(new Element("TransplanteCardiaco").setText(this.sc.getTrasplantecardiaco()!=null && this.sc.getTrasplantecardiaco().equals(comp)?"1":null));
			root.addContent(new Element("ParadaCardiaca").setText(this.sc.getParadacardiaca()!=null && this.sc.getParadacardiaca().equals(comp)?"1":null));
			root.addContent(new Element("Sincope").setText(this.sc.getSincope()!=null && this.sc.getSincope().equals(comp)?"1":null));
			root.addContent(new Element("EnfermedadArterial").setText(this.sc.getEnfart()!=null && this.sc.getEnfart().equals(comp)?"1":null));
			// FEVI
			root.addContent(new Element("FEVI").setText(this.sc.getFevi()!=null?this.sc.getFevi():null));
			// FUNCION VENTRICULAR
			String funcion=null;
			if(this.sc.getFuncionventricular()!=null){
				if(this.sc.getFuncionventricular().equals(1))
					funcion = this.bundle.getString("sc_fvent_op1");
				else if(this.sc.getFuncionventricular().equals(2))
					funcion = "41-50%";
				else if(this.sc.getFuncionventricular().equals(3))
					funcion = "36-40%";
				else if(this.sc.getFuncionventricular().equals(4))
					funcion = "31-35%";
				else if(this.sc.getFuncionventricular().equals(5))
					funcion = this.bundle.getString("sc_fvent_op5");
				else if(this.sc.getFuncionventricular().equals(6))
					funcion = this.bundle.getString("sc_feyec_msg_5");
				else if(this.sc.getFuncionventricular().equals(0))
					funcion = this.bundle.getString("sc_feyec_msg_4");
			}
			root.addContent(new Element("FuncionVentricular").setText(funcion));
			
			// DATOS SEGUIMIENTO
			root.addContent(new Element("Fecha").setText(UtilFechas.getFechaStringFormato(this.seg.getFecha(), "dd/MM/yyyy")));
			
			String tiposeg = null;
			String motivos = null;
			if(this.seg.getTiposeg()!=null && this.seg.getTiposeg()!=0)
				tiposeg = maestrasdao.findByPrimaryKey(this.seg.getTiposeg()).getValor();
			if(this.seg.getMotivo()!=null && this.seg.getMotivo()!=0)
				motivos = maestrasdao.findByPrimaryKey(this.seg.getMotivo()).getValor();
			root.addContent(new Element("TipoSeguimiento").setText(tiposeg));
			root.addContent(new Element("Motivos").setText(motivos));
			
			String prog = null;
			if(this.seg.getProgramado()!=null){
				if(this.seg.getTiposeg().equals(1))
					prog = this.bundle.getString("segclin_prog");
				else if(this.seg.getTiposeg().equals(0))
					prog = this.bundle.getString("segclin_no_prog");
				else 
					prog = "";
			}
			root.addContent(new Element("Programado").setText(prog));
			
			root.addContent(new Element("Observaciones").setText(this.seg.getObservaciones()));
			root.addContent(new Element("Resultados").setText(this.seg.getResultados()));
			root.addContent(new Element("Comentarios").setText(this.seg.getComentarios()));
			
			root.addContent(new Element("Medico").setText(this.seg.getOpmed()!=null?this.seg.getOpmed():null));
			root.addContent(new Element("Enfermeria").setText(this.seg.getOpenf()!=null?this.seg.getOpenf():null));
			
			// COMPLICACIONES
			String compl = "",aux="";
			root.addContent(new Element("HayComplicaciones").setText(this.comps.size()>0?"1":"0"));
			ComplicacionDao compdao = new ComplicacionDaoImpl("consultor");
			for(SegClinComplicaciones c:this.comps){
				if(c.getIdcomp()!=null){
					Element el = new Element("Complicacion");
					if(c.getOtra()!=null && !c.getOtra().equals(""))
						aux = c.getOtra();
					else
						aux = compdao.findByPrimaryKey(c.getIdcomp()).getClase();
					compl = compl + aux +", ";
					el.addContent(new Element("Tipo").setText((aux)));
					root.addContent(el);
				}
			}
			root.addContent(new Element("ResumenComplicaciones").setText(!compl.equals("")?compl.substring(0,compl.length()-2):null));
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Seguimiento Clínico. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Seguimiento Clínico. Motivo: "+e.getMessage(),e);
		}
	}
}

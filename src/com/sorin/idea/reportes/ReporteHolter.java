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
import com.sorin.idea.dto.ArrRegistrador;
import com.sorin.idea.dto.Holter;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpEvolucionComplicacion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteComplicacionDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilMapeos;
import com.sorin.idea.util.UtilReporteInformes;

public class ReporteHolter {

	private static Logger logger = Logger.getLogger(ReporteHolter.class);
	PacienteAplDto paciente = new PacienteAplDto();
	Holter holter = new Holter();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	private InfoCentro centro;
	private SituacionClinicaProc hind;
	private ResourceBundle bundle;
	
	public ReporteHolter(String pathFichero, Holter holter, PacienteAplDto paciente, InfoCentro c, SituacionClinicaProc ind, ResourceBundle bundle) {
		this.paciente = paciente;
		this.holter = holter;
		this.pathFichero = pathFichero;
		this.centro = c;
		this.hind = ind;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	
	public void GeneraArchivoPlanilla() {
		ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
		Element root = new Element("HOLTER");
		try{
			File fg = new File(req.getRealPath(rutaImagen));
			java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy");
		    root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
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
			root.addContent(new Element("Centro").setText(this.centro.getCentro()));
			root.addContent(new Element("Paciente").setText(this.paciente.getNombreCompleto()));
			// Separacion nombre , apellido 1, apellido 2
			root.addContent(new Element("Nombre").setText(this.paciente.getNombre()));
			root.addContent(new Element("Apellido1").setText(this.paciente.getApellid1()));
			root.addContent(new Element("Apellido2").setText(this.paciente.getApellid2()));			
			root.addContent(new Element("NHC").setText(this.paciente.getNhc()));			
			root.addContent(new Element("NICA").setText(this.paciente.getNuhsa()));//IdPaciente			
			root.addContent(new Element("DNI").setText(this.paciente.getDni()));
			root.addContent(new Element("NSS").setText(this.paciente.getNss1()));
			root.addContent(new Element("Direccion").setText(this.paciente.getDireccion()));
			root.addContent(new Element("Ciudad").setText(this.paciente.getPoblacion()));
			root.addContent(new Element("Provincia").setText(this.paciente.getProvincia()));
			root.addContent(new Element("Telefono").setText(this.paciente.getTelefono1()));
			root.addContent(new Element("CodigoPostal").setText(this.paciente.getCp()));
			root.addContent(new Element("Pais").setText(this.paciente.getPais()));
			root.addContent(new Element("HProcedencia").setText(this.paciente.getHprocedencia()!=null && this.paciente.getHprocedencia()!=0?maedao.findByPrimaryKey(this.paciente.getHprocedencia()).getValor():null));
			root.addContent(new Element("CProcedencia").setText(this.paciente.getProcedencia()!=null && this.paciente.getProcedencia()!=0?maedao.findByPrimaryKey(this.paciente.getProcedencia()).getValor():null));
			
			root.addContent(new Element("NProc").setText(this.holter.getNproc()!=null?this.holter.getNproc():null));
			
			root.addContent(new Element("FechaColocacion").setText(this.holter.getFechacolocacion()!=null?sdf.format(this.holter.getFechacolocacion()):null));
			root.addContent(new Element("FechaLectura").setText(this.holter.getFechalectura()!=null?sdf.format(this.holter.getFechalectura()):null));
			root.addContent(new Element("FechaRetirada").setText(this.holter.getFecharetirada()!=null?sdf.format(this.holter.getFecharetirada()):null));
			root.addContent(new Element("FechaAnalisis").setText(this.holter.getFechanalisis()!=null?sdf.format(this.holter.getFechanalisis()):null));
			
			root.addContent(new Element("ComentariosCol").setText(this.holter.getComentariosCol()!=null?this.holter.getComentariosCol():null));
			root.addContent(new Element("ComentariosAna").setText(this.holter.getComentariosAna()!=null?this.holter.getComentariosAna():null));
			root.addContent(new Element("Recomendaciones").setText(this.holter.getRecomendaciones()!=null?this.holter.getRecomendaciones():null));
			
			root.addContent(new Element("Referidor").setText(this.holter.getReferidor()!=null?this.holter.getReferidor():null));
			root.addContent(new Element("Enf_Colocacion").setText(this.holter.getColocacionEnf()!=null?this.holter.getColocacionEnf():null));
			root.addContent(new Element("Med_Colocacion").setText(this.holter.getColocacionMed()!=null?this.holter.getColocacionMed():null));
			root.addContent(new Element("Enf_Retirada").setText(this.holter.getRetiradaEnf()!=null?this.holter.getRetiradaEnf():null));
			root.addContent(new Element("Med_Retirada").setText(this.holter.getRetiradaMed()!=null?this.holter.getRetiradaMed():null));
			root.addContent(new Element("Med_Analisis").setText(this.holter.getAnalisisMed()!=null?this.holter.getAnalisisMed():null));
			
			String diag_ini = null;
			if(this.holter.getDiagnosticoini()!=null){
				switch (this.holter.getDiagnosticoini()) {
					case 1:
						diag_ini = this.bundle.getString("holter24h_tab2_col_diag_ini_op1");
						break;
					case 2:
						diag_ini = this.bundle.getString("holter24h_tab2_col_diag_ini_op2");
						break;
					case 3:
						diag_ini = this.bundle.getString("holter24h_tab2_col_diag_ini_op3");
						break;
					case 4:
						diag_ini = (this.holter.getDiaginiotro()!=null?this.holter.getDiaginiotro():this.bundle.getString("holter24h_tab2_col_diag_ini_op4"));
						break;
					default:
						diag_ini = "";
						break;
				}
			}
			root.addContent(new Element("DiagIni").setText(diag_ini));
			
			String diag_fin = null;
			if(this.holter.getDiagnosticofin()!=null){
				switch (this.holter.getDiagnosticofin()) {
					case 1:
						diag_fin = this.bundle.getString("holter24h_tab2_ana_diag_fin_op1");
						break;
					case 2:
						diag_fin = this.bundle.getString("holter24h_tab2_ana_diag_fin_op2");
						break;
					case 3:
						diag_fin = this.bundle.getString("holter24h_tab2_ana_diag_fin_op3");
						break;
					case 4:
						diag_fin = (this.holter.getDiagfinotro()!=null?this.holter.getDiagfinotro():this.bundle.getString("holter24h_tab2_ana_diag_fin_op4"));
						break;
					default:
						diag_fin = "";
						break;
				}
			}
			root.addContent(new Element("DiagFin").setText(diag_fin));
				
			String estado = null;
			if(this.holter.getEstado()!=null){
				if(this.holter.getEstado()<2)
					estado = "0";
				else
					estado = "1";
			}
			root.addContent(new Element("Estado").setText(estado));
			///////////////////////////// SITUACION CLINICA PROCEDIMIENTO
			//Sintomas
			String sint = "";
			for(SintomasSitclinProc s:this.hind.getSintomas()){
				sint = sint + s.getIdsintomas()+", ";
			}
			if(sint.length()>0)
				sint = sint.substring(0, sint.length()-2);
			root.addContent(new Element("Sintoma").setText(sint));
			//Ritmo basal
			root.addContent(new Element("Ritmobasal").setText(this.hind.getRitmo()!=null && this.hind.getRitmo()!=0?maedao.findByPrimaryKey(this.hind.getRitmo()).getValor():null));
			// Ritmo 2
			root.addContent(new Element("Ritmobasal2").setText(this.hind.getRitmo2()!=null && this.hind.getRitmo2()!=0?maedao.findByPrimaryKey(this.hind.getRitmo2()).getValor():null));
			//conduccion av
			root.addContent(new Element("Conduccionav").setText(this.hind.getConducav()!=null && this.hind.getConducav()!=0?maedao.findByPrimaryKey(this.hind.getConducav()).getValor():null));
			//conduccion av -2
			root.addContent(new Element("Conduccionav2").setText(this.hind.getConducav2()!=null && this.hind.getConducav2()!=0?maedao.findByPrimaryKey(this.hind.getConducav2()).getValor():null));
			//conduccion qrs
			root.addContent(new Element("Qrs").setText(this.hind.getQrs()!=null && this.hind.getQrs()!=0?maedao.findByPrimaryKey(this.hind.getQrs()).getValor():null));
			//conduccion qrs -2 
			root.addContent(new Element("Qrs2").setText(this.hind.getQrs2()!=null && this.hind.getQrs2()!=0?maedao.findByPrimaryKey(this.hind.getQrs2()).getValor():null));
			//anchura qrs
			root.addContent(new Element("Anchuraqrs").setText((this.hind.getAnchuraqrs()!=null)?this.hind.getAnchuraqrs().toString():null));
			//nyha
			if(this.hind.getNyha()!=null){
				if(this.hind.getNyha()==1)
					root.addContent(new Element("Nyha").setText("I"));
				else if(this.hind.getNyha()==2)
					root.addContent(new Element("Nyha").setText("II"));
				else if(this.hind.getNyha()==3)
					root.addContent(new Element("Nyha").setText("III"));
				else if(this.hind.getNyha()==4)
					root.addContent(new Element("Nyha").setText("IV"));
				else
					root.addContent(new Element("Nyha"));
			}else{
				root.addContent(new Element("Nyha"));
			}
			//cardiopatia
			root.addContent(new Element("Cardiopatia").setText(this.hind.getCardiopatia()!=null?
					maedao.findByPrimaryKey(this.hind.getCardiopatia()).getValor():null));
			//aevolucion
			root.addContent(new Element("AEvolucion").setText((this.hind.getAevolucion()!=null)?this.hind.getAevolucion().toString():null));	
			//revascularizacion
			root.addContent(new Element("Revascularizacion").setText((this.hind.getRevasc()!=null && this.hind.getRevasc()==1)?"1":null));	
			//infarto previo
			root.addContent(new Element("Infartoprevio").setText((this.hind.getInfprevio()!=null && this.hind.getInfprevio()==1)?"1":null));		
			//anio infarto previo
			root.addContent(new Element("AInfarto").setText((this.hind.getAnio()!=null && this.hind.getAnio().length()>0)?this.hind.getAnio().toString():null));			
			
			Short comp = 1;// mysql
			// Antecedentes 
			root.addContent(new Element("HTA").setText(this.hind.getHta()!=null && this.hind.getHta().equals(comp)?"1":null));
			root.addContent(new Element("Dislipemia").setText(this.hind.getDislipemia()!=null && this.hind.getDislipemia().equals(comp)?"1":null));
			root.addContent(new Element("Diabetes").setText(this.hind.getDiabetes()!=null && this.hind.getDiabetes().equals(comp)?"1":null));
			root.addContent(new Element("Tabaquismo").setText(this.hind.getTabaquismo()!=null && this.hind.getTabaquismo().equals(comp)?"1":null));
			root.addContent(new Element("Alcohol").setText(this.hind.getIngalcoholica()!=null && this.hind.getIngalcoholica().equals(comp)?"1":null));
			root.addContent(new Element("ACV").setText(this.hind.getAcv()!=null && this.hind.getAcv().equals(comp)?"1":null));
			root.addContent(new Element("AIT").setText(this.hind.getAit()!=null && this.hind.getAit().equals(comp)?"1":null));
			root.addContent(new Element("EPOC").setText(this.hind.getEpoc()!=null && this.hind.getEpoc().equals(comp)?"1":null));
			root.addContent(new Element("SAHS").setText(this.hind.getSahs()!=null && this.hind.getSahs().equals(comp)?"1":null));
			String tiposahs=null;
			if(this.hind.getTiposahs()!=null){				
				if(this.hind.getTiposahs().equals(1))
					tiposahs = this.bundle.getString("sc_antecedentes_nc_sahs_msg_3");
				else if(this.hind.getTiposahs().equals(2))
					tiposahs = this.bundle.getString("sc_antecedentes_nc_sahs_msg_4");
				else if(this.hind.getTiposahs().equals(3))
					tiposahs = this.bundle.getString("sc_antecedentes_nc_sahs_msg_5");
				else if(this.hind.getTiposahs().equals(4))
					tiposahs = this.bundle.getString("sc_antecedentes_nc_sahs_msg_6");
			}
			root.addContent(new Element("TipoSAHS").setText(tiposahs));
			root.addContent(new Element("InsRenal").setText(this.hind.getInsrenal()!=null && this.hind.getInsrenal().equals(comp)?"1":null));
			root.addContent(new Element("Neoplasia").setText(this.hind.getNeoplasia()!=null && this.hind.getNeoplasia().equals(comp)?"1":null));
			root.addContent(new Element("TipoNeopladia").setText(this.hind.getTiponeoplasia()!=null?this.hind.getTiponeoplasia():null));
			String afec_tir=null;
			if(this.hind.getAfectiroidea()!=null){
				if(this.hind.getAfectiroidea().equals(1))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_tir_msg_2");
				else if(this.hind.getAfectiroidea().equals(2))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_tir_msg_3");
			}
			root.addContent(new Element("AfecTiroidea").setText(afec_tir));
			
			root.addContent(new Element("FA").setText(this.hind.getAntfa()!=null && this.hind.getAntfa().equals(comp)?"1":null));
			root.addContent(new Element("MuerteSubita").setText(this.hind.getMuertesubita()!=null && this.hind.getMuertesubita().equals(comp)?"1":null));
			String neuro=null;
			if(this.hind.getNeuromediados()!=null){
				if(this.hind.getNeuromediados().equals(1))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_neur_msg_2");
				else if(this.hind.getNeuromediados().equals(2))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_neur_msg_3");
				else if(this.hind.getNeuromediados().equals(3))
					afec_tir = this.bundle.getString("sc_antecedentes_nc_neur_msg_4");
			}
			root.addContent(new Element("Neuromediados").setText(neuro));
			
			root.addContent(new Element("TransplanteCardiaco").setText(this.hind.getTrasplantecardiaco()!=null && this.hind.getTrasplantecardiaco().equals(comp)?"1":null));
			root.addContent(new Element("ParadaCardiaca").setText(this.hind.getParadacardiaca()!=null && this.hind.getParadacardiaca().equals(comp)?"1":null));
			root.addContent(new Element("Sincope").setText(this.hind.getSincope()!=null && this.hind.getSincope().equals(comp)?"1":null));
			root.addContent(new Element("EnfermedadArterial").setText(this.hind.getEnfart()!=null && this.hind.getEnfart().equals(comp)?"1":null));
			// FEVI
			root.addContent(new Element("FEVI").setText(this.hind.getFevi()!=null?this.hind.getFevi():null));
			// FUNCION VENTRICULAR
			String funcion=null;
			if(this.hind.getFuncionventricular()!=null){
				if(this.hind.getFuncionventricular().equals(1))
					funcion = this.bundle.getString("sc_fvent_op1");
				else if(this.hind.getFuncionventricular().equals(2))
					funcion = "41-50%";
				else if(this.hind.getFuncionventricular().equals(3))
					funcion = "36-40%";
				else if(this.hind.getFuncionventricular().equals(4))
					funcion = "31-35%";
				else if(this.hind.getFuncionventricular().equals(5))
					funcion = this.bundle.getString("sc_fvent_op5");
				else if(this.hind.getFuncionventricular().equals(6))
					funcion = this.bundle.getString("sc_feyec_msg_5");
				else if(this.hind.getFuncionventricular().equals(0))
					funcion = this.bundle.getString("sc_feyec_msg_4");
			}
			root.addContent(new Element("FuncionVentricular").setText(funcion));
			
			Document doc = new Document(root);

			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			// XMLOutputter out= new XMLOutputter();
			FileOutputStream file = new FileOutputStream(pathFichero);
			out.output(doc, file);
			file.flush();
			file.close();
			// out.output(doc, System.out);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte Holter 24h. Motivo: "+e.getMessage(),e);
		}
	}
}

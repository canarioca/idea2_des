package com.sorin.idea.reportes;

import hvn.cm.dao.DAOException;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilFechas;

public class ReporteCV {
	
	private static Logger logger = Logger.getLogger(ReporteCV.class);
	PacienteAplDto paciente = new PacienteAplDto();
	ArrCardioversion car = new ArrCardioversion();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	private InfoCentro centro;
	private SituacionClinicaProc sc;
	private ResourceBundle bundle;
	private ArrayList<ComplicacionesPacientes> listacomps;

	public ReporteCV(String path, ArrCardioversion car,
			PacienteAplDto pacienteSelect,InfoCentro c,SituacionClinicaProc sitclin,ResourceBundle bundle, ArrayList<ComplicacionesPacientes> listacomp) {
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.car = car;
		this.centro = c;
		this.sc = sitclin;
		this.bundle = bundle;
		this.listacomps = listacomp;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}

	public void GeneraArchivoPlanilla() {
		Element root = new Element("CV");
		try{
			ArrMaestrasDao maestrasdao = new ArrMaestrasDaoImpl("");
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
	        root.addContent(new Element("Centro").setText(this.centro.getCentro()));
			root.addContent(new Element("cv").setText(this.car.getNcv()!=null?this.car.getNcv():null));
			//root.addContent(new Element("Fecha").setText(this.car.getFechaStr()));
			root.addContent(new Element("Fecha").setText(UtilFechas.getFechaStringFormato(this.car.getFecha(), "dd-MM-yyyy")));
			root.addContent(new Element("Edad").setText(this.paciente.getEdad()));
			if(this.paciente.getSexo()!= null){
				if(this.paciente.getSexo().toString().equals("1"))
					root.addContent(new Element("Sexo").setText(this.bundle.getString("masculino")));
				else 
					root.addContent(new Element("Sexo").setText(this.bundle.getString("femenino")));
			}else
				root.addContent(new Element("Sexo").setText(null));	
			root.addContent(new Element("Nombre").setText(this.paciente.getNombreCompleto()));
			root.addContent(new Element("NHC").setText(this.paciente.getNhc()));
			root.addContent(new Element("NUHSA").setText(this.paciente.getNuhsa()!=null?this.paciente.getNuhsa():""));
			
			root.addContent(new Element("Fibrilacion").setText(this.car.getFibrilacion()!=null?this.car.getFibrilacion().toString():null));
			root.addContent(new Element("Flutera").setText(this.car.getFluteratipico()!=null?this.car.getFluteratipico().toString():null));
			root.addContent(new Element("Flutert").setText(this.car.getFlutertipico()!=null?this.car.getFlutertipico().toString():null));
			root.addContent(new Element("Procedencia").setText(this.car.getIdprocedencia()!=null?this.car.getIdprocedencia().toString():null));
			root.addContent(new Element("CVENo").setText(this.car.getCveno()!=null?this.car.getCveno().toString():null));
			root.addContent(new Element("CVESi").setText(this.car.getCvesi()!=null?this.car.getCvesi().toString():null));
			root.addContent(new Element("CVEEficaz").setText(this.car.getCveeficaz()!=null?this.car.getCveeficaz().toString():null));
			root.addContent(new Element("CVENumero").setText(this.car.getCvenumero()!=null?this.car.getCvenumero().toString():null));
			root.addContent(new Element("Ablacion").setText(this.car.getIdablacion()!=null?this.car.getIdablacion().toString():null));
			/*root.addContent(new Element("NYHA").setText(this.car.getNyha()));
			root.addContent(new Element("Cardiopatia").setText(this.car.getIdcardiopatia().toString()));
			root.addContent(new Element("Tipocardio").setText(this.car.getTipocardio()));
			root.addContent(new Element("Tabaco").setText(this.car.getIdtabaco().toString()));
			root.addContent(new Element("HTA").setText(this.car.getHta().toString()));
			root.addContent(new Element("Epoc").setText(this.car.getEpoc().toString()));
			root.addContent(new Element("MP").setText(this.car.getMpdefinitivo().toString()));
			root.addContent(new Element("ACV").setText(this.car.getAcv().toString()));
			root.addContent(new Element("Diabetes").setText(this.car.getDiabetes().toString()));*/
			root.addContent(new Element("FAFLT").setText(this.car.getIdduracion()!=null?this.car.getIdduracion().toString():null));
			/*root.addContent(new Element("Digoxina1").setText(this.car.getDigoxina().toString()));
			root.addContent(new Element("Bbloq1").setText(this.car.getBbloq().toString()));
			root.addContent(new Element("Antca1").setText(this.car.getAntca().toString()));
			root.addContent(new Element("Amiod1").setText(this.car.getAmiod().toString()));
			root.addContent(new Element("AAS1").setText(this.car.getAas().toString()));
			root.addContent(new Element("Dronedarona1").setText(this.car.getDronedarona().toString()));
			root.addContent(new Element("Sotalol1").setText(this.car.getSotalol().toString()));
			root.addContent(new Element("Clasei1").setText(this.car.getClasei().toString()));
			root.addContent(new Element("Diureticos1").setText(this.car.getDiureticos().toString()));
			root.addContent(new Element("IECA1").setText(this.car.getIeca().toString()));
			root.addContent(new Element("ARA1").setText(this.car.getAraii().toString()));
			root.addContent(new Element("FE").setText(this.car.getFe().toString()));
			root.addContent(new Element("AI").setText(this.car.getAl().toString()));
			root.addContent(new Element("Otrosecocardio").setText(this.car.getOtroseco()));*/
			root.addContent(new Element("AVTAK").setText(this.car.getAvta()!=null?this.car.getAvta().toString():null));
			root.addContent(new Element("ETE").setText(this.car.getEte()!=null?this.car.getEte().toString():null));
			root.addContent(new Element("Otrostto").setText(this.car.getOtrostto()));
			root.addContent(new Element("Exitof").setText(this.car.getIdexitofinal().toString()));
			for(ComplicacionesPacientes cps:this.listacomps){
				// TODO
			}
			root.addContent(new Element("Complicacion").setText(this.car.getIdcomplicacion().toString()));
			root.addContent(new Element("Complicacionstr").setText(this.car.getComplicacion()));
			root.addContent(new Element("Exitot").setText(this.car.getExitotrans().toString()));
			root.addContent(new Element("Nexitot").setText(this.car.getNumexitotrans().toString()));
			root.addContent(new Element("Duracion").setText(this.car.getDuracionextrans().toString()));
			root.addContent(new Element("Energia").setText(this.car.getEnergiaextrans().toString()));
			root.addContent(new Element("Sec1").setText(this.car.getSec1()));
			root.addContent(new Element("Sec2").setText(this.car.getSec2()));
			root.addContent(new Element("Sec3").setText(this.car.getSec3()));
			root.addContent(new Element("Sec4").setText(this.car.getSec4()));
			root.addContent(new Element("Sec5").setText(this.car.getSec5()));
			root.addContent(new Element("Sec1_1").setText(this.car.getIdsec1().toString()));
			root.addContent(new Element("Sec2_1").setText(this.car.getIdsec2().toString()));
			root.addContent(new Element("Sec3_1").setText(this.car.getIdsec3().toString()));
			root.addContent(new Element("Sec4_1").setText(this.car.getIdsec4().toString()));
			root.addContent(new Element("Sec5_1").setText(this.car.getIdsec5().toString()));
			root.addContent(new Element("Parches").setText(this.car.getParches().toString()));
			root.addContent(new Element("Atropina").setText(this.car.getAtropina().toString()));
			root.addContent(new Element("Estim").setText(this.car.getEstimtmpext().toString()));
			root.addContent(new Element("Bbloq2").setText(this.car.getBbalta().toString()));
			root.addContent(new Element("Amiodarona2").setText(this.car.getAmiodaronaalta().toString()));
			root.addContent(new Element("Sotalol2").setText(this.car.getSolatololalta().toString()));
			root.addContent(new Element("AVTAK2").setText(this.car.getAvtaalta().toString()));
			root.addContent(new Element("Clasei2").setText(this.car.getClaseialta().toString()));
			root.addContent(new Element("IECA2").setText(this.car.getIecaalta().toString()));
			root.addContent(new Element("ARA2").setText(this.car.getAraalta().toString()));
			root.addContent(new Element("Dronedarona2").setText(this.car.getDronedaronaalta().toString()));
			root.addContent(new Element("Otros2").setText(this.car.getOtrosalta().toString()));

			root.addContent(new Element("Tipoprocedimiento").setText(this.car.getTipoprocedimiento().toString()));
			root.addContent(new Element("Comentarios").setText(this.car.getComentarios()!=null?this.car.getComentarios().toString():null));
			
			// SITUACION CLÍNICA
			//Sintomas
			String sint = "";
			for(SintomasSitclinProc s:this.sc.getSintomas())
				sint = sint + s.getIdsintomas()+", ";
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
			}else
				root.addContent(new Element("Nyha"));
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
					funcion = " "+this.bundle.getString("sc_fvent_op1");
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
						
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte CVE. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Reporte Cardioversión eléctrica. Motivo: "+e.getMessage(),e);
		}
	}
}

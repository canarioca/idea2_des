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
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteComplicacionDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilMapeos;
import com.sorin.idea.util.UtilReporteInformes;

public class ReporteImplante {

	private static Logger logger = Logger.getLogger(ReporteImplante.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	
	private ImpImplante implante;
	private ImpHojaImplante himp;
	private SituacionClinicaProc hind;
	private ImpEvolucion hev;
	private UtilReporteInformes report;
	private InfoCentro centro;
	private ArrayList<ImpImplanteElectrodos> elecs;
	private ArrMaestras[] viaaccesoimplante;
	private ArrMaestras[] zonacamaraad;
	private ArrMaestras[] zonacamaravd;
	private ArrMaestras[] zonacamaravi;
	private ArrMaestras[] zonaepicardico;
	private ArrMaestras[] zonacamarasicd;
	private ArrMaestras[] porcion;
	private ArrayList<ImpHojaImplanteComplicacion> listacint;
	private ArrayList<ImpEvolucionComplicacion> listacpost;
	private ResourceBundle bundle;
	
	public ReporteImplante(String path, PacienteAplDto pacienteSelect,ImpImplante impl, SituacionClinicaProc ind, ImpHojaImplante him, 
			ImpEvolucion hevo,UtilReporteInformes rep,InfoCentro c,ArrayList<ImpImplanteElectrodos> els,
			ArrayList<ImpHojaImplanteComplicacion> compintra, ArrayList<ImpEvolucionComplicacion> comppost, ResourceBundle bundle){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.implante = impl;
		this.hind = ind;
		this.himp = him;
		this.hev = hevo;
		this.centro = c;
		this.elecs = els;
		this.report = rep;
		this.listacint = compintra;
		this.listacpost = comppost;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	public void GeneraArchivoPlanilla(){
		Element root = new Element("IMPLANTE");
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("dd-MM-yyyy");
		ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
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
			root.addContent(new Element("Centro").setText(this.centro.getCentro()));
			root.addContent(new Element("Paciente").setText(this.paciente.getNombreCompleto()));
			// Separacion nombre , apellido 1, apellido 2
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
			// codigo postal
			root.addContent(new Element("CodigoPostal").setText(this.paciente.getCp()));
			// pais
			root.addContent(new Element("Pais").setText(this.paciente.getPais()));
						
			//Tipoprocedimiento
			root.addContent(new Element("Tipoprocedimiento").setText(this.report.getTipoprocedimiento()));
			//Fechaprocedimiento
			root.addContent(new Element("Fechaprocedimiento").setText(sdf.format(this.implante.getFechaimplante())));
			// Numero de procedimiento
			root.addContent(new Element("NProc").setText(this.implante.getNproc()!=null?this.implante.getNproc():null));
			// Prevencion primaria - secundaria
			String tind = null;
			if(this.himp.getTindicacion()!=null){
				if(this.himp.getTindicacion().equals(0))
					tind =this.bundle.getString("imp_dispositivos_tab_himp_tipo_indicacion_prim");
				else if(this.himp.getTindicacion().equals(1))
					tind = this.bundle.getString("imp_dispositivos_tab_himp_tipo_indicacion_sec");
				else if(this.himp.getTindicacion().equals(2))
					tind = this.bundle.getString("imp_dispositivos_tab_himp_tipo_indicacion_desc");
			}
			root.addContent(new Element("Prevencion").setText(tind));
			//Fechaprocedimientoanterior
			//Sintomas
			String sint = "";
			for(SintomasSitclinProc s:this.hind.getSintomas()){
				sint = sint + s.getIdsintomas()+", ";
			}
			if(sint.length()>0)
				sint = sint.substring(0, sint.length()-2);
			root.addContent(new Element("Sintoma").setText(sint));
			//Ritmo basal
			root.addContent(new Element("Ritmobasal").setText(this.report.getRitmo()));
			// Ritmo 2
			root.addContent(new Element("Ritmobasal2").setText(this.report.getRitmo2()));
			//conduccion av
			root.addContent(new Element("Conduccionav").setText(this.report.getConduccionav()));
			//conduccion qrs
			root.addContent(new Element("Qrs").setText(this.report.getConduccionqrs()));
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
			root.addContent(new Element("Cardiopatia").setText(this.report.getCardiopatia()));
			//aevolucion
			root.addContent(new Element("AEvolucion").setText((this.hind.getAevolucion()!=null)?this.hind.getAevolucion().toString():null));	
			//revascularizacion
			root.addContent(new Element("Revascularizacion").setText((this.hind.getRevasc()!=null && this.hind.getRevasc()==1)?"1":null));	
			//infarto previo
			root.addContent(new Element("Infartoprevio").setText((this.hind.getInfprevio()!=null && this.hind.getInfprevio()==1)?"1":null));		
			//anio infarto previo
			root.addContent(new Element("AInfarto").setText((this.hind.getAnio()!=null && this.hind.getAnio().length()>0)?this.hind.getAnio().toString():null));			
			//tipo dispositivo
			root.addContent(new Element("TipoDispositivo").setText(this.report.getTipodispositivo()));	
			//modelo generador
			root.addContent(new Element("Modelogenerador").setText(this.report.getModelogen()));
			//localizaciongenerador
			root.addContent(new Element("Localizaciongenerador").setText(this.report.getLocalizaciongen()));
			// numero de serie generador
			root.addContent(new Element("NumSerieGenerador").setText(this.report.getNumseriegen()));
			//fabricante generador
			root.addContent(new Element("FabricanteGenerador").setText(this.report.getFabricantegen()));			
			root.addContent(new Element("MRIGenerador").setText(this.report.isMri()?"Si":"No"));
			root.addContent(new Element("RFGenerador").setText(this.report.isRf()?"Si":"No"));
			//modeloelectrodoad
			root.addContent(new Element("Modeloelectrodoad").setText(this.report.getModeloelectrodoad()));
			//modeloelectrodoi
			root.addContent(new Element("Modeloelectrodoai").setText(this.report.getModeloelectrodoai()));
			//modeloelectrodovd
			root.addContent(new Element("Modeloelectrodovd").setText(this.report.getModeloelectrodovd()));
			//modeloelectrodovi
			root.addContent(new Element("Modeloelectrodovi").setText(this.report.getModeloelectrodovi()));
			// Pruebas sistema electrodos
			root.addContent(new Element("InfoElectrodos").setText(this.report.getInfoelecs()));
			// Pruebas sistema completo
			root.addContent(new Element("InfoSistema").setText(this.report.getInfosistema()));
			// Motivos de recambio generador
			root.addContent(new Element("MRecambioGen").setText(this.report.getMotivorecambiogen()));
			// Motivos de recolocacion generador
			root.addContent(new Element("MRecolocacionGen").setText(this.report.getMotivorecolocaciongen()));
			//primeroperador
			root.addContent(new Element("PrimerOperador").setText(!this.report.getPrimeroperador().equals("0")?this.report.getPrimeroperador():null));
			//segundooperador
			root.addContent(new Element("SegundoOperador").setText(!this.report.getSegundooperador().equals("0")?this.report.getSegundooperador():null));
			//enfermeria	
			root.addContent(new Element("Enfermeria").setText(!this.report.getEnfermeria().equals("0")?this.report.getEnfermeria():null));
			//Horas
			if(this.himp.getHllegada()!=null){
				root.addContent(new Element("HLlegada").setText(this.himp.getHllegada().substring(0,2)+":"+this.himp.getHllegada().substring(2,4)));				
			}
			if(this.himp.getHinicio()!=null){
				root.addContent(new Element("HInicio").setText(this.himp.getHinicio().substring(0,2)+":"+this.himp.getHinicio().substring(2,4)));				
			}
			if(this.himp.getHfin()!=null){
				root.addContent(new Element("HFin").setText(this.himp.getHfin().substring(0,2)+":"+this.himp.getHfin().substring(2,4)));
			}
			if(this.himp.getHsalida()!=null){
				root.addContent(new Element("HSalida").setText(this.himp.getHsalida().substring(0,2)+":"+this.himp.getHsalida().substring(2,4)));
			}
			root.addContent(new Element("Duracion").setText(this.himp.getDuracion()));
			//tipoanestesia
			if(this.himp.getTanestesia()!=null){
				if(this.himp.getTanestesia()==1)
					root.addContent(new Element("Tipoanestesia").setText(this.bundle.getString("imp_dispositivos_tab_himp_anest_tipo_op1").toLowerCase()));
				else if(this.himp.getTanestesia()==2)
					root.addContent(new Element("Tipoanestesia").setText(this.bundle.getString("imp_dispositivos_tab_himp_anest_tipo_op2").toLowerCase()));
				else if(this.himp.getTanestesia()==3)
					root.addContent(new Element("Tipoanestesia").setText(this.bundle.getString("imp_dispositivos_tab_himp_anest_tipo_op3").toLowerCase()));
				else
					root.addContent(new Element("Tipoanestesia").setText(null));
			}	
			//tescopia
			root.addContent(new Element("Tescopia").setText(this.himp.getTescopia()!=null && !this.himp.getTescopia().equals("")?this.himp.getTescopia():null));
			//Lugar de implante
			if(this.himp.getLugarimp()!=null){
				if(this.himp.getLugarimp()==1)
					root.addContent(new Element("LugarImplante").setText(this.bundle.getString("imp_dispositivos_tab_himp_lugar_imp_op1")));
				else if(this.himp.getLugarimp()==2)
					root.addContent(new Element("LugarImplante").setText(this.bundle.getString("imp_dispositivos_tab_himp_lugar_imp_op2")));
				else
					root.addContent(new Element("LugarImplante").setText(null));
			}else
				root.addContent(new Element("LugarImplante").setText(null));
			// Medicación intra procedimiento
			if(this.himp.getMedintra()!=null){
				String profAntibio = null;
				if(this.himp.getMedintra().getProfiAntibio()!=null){
					switch(this.himp.getMedintra().getProfiAntibio()){
						case 1: profAntibio = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antibio_op1");break;
						case 2: profAntibio = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antibio_op2");break;
						case 3: profAntibio = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antibio_op3");break;
						case 4: profAntibio = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antibio_op4") 
									+ (this.himp.getMedintra().getProfiAntibioOtra()!=null?". "+this.himp.getMedintra().getProfiAntibioOtra():"");break;
						default: profAntibio = "";break;
					}
				}
				root.addContent(new Element("ProfilaxisAntibiotica").setText(profAntibio));
				
				String anticoag = null;
				if(this.himp.getMedintra().getAnticoag()!=null){
					switch(this.himp.getMedintra().getAnticoag()){
						case 1: anticoag = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_op1");break;
						case 2: anticoag = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_op2");break;
						case 3: anticoag = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_op3");break;
						case 4: anticoag = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_op4");break;
						case 5: anticoag = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_op5");break;
						case 6: anticoag = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_op6");break;
						case 8: anticoag = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_op8");break;
						case 7: anticoag = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_op7") 
									+ (this.himp.getMedintra().getAnticoagOtra()!=null?". "+this.himp.getMedintra().getAnticoagOtra():"");break;
						default: anticoag = "";
					}
				}
				root.addContent(new Element("Anticoagulante").setText(anticoag));
				
				String retirada = null;
				if(this.himp.getMedintra().getAnticoagRetirada()!=null){
					switch(this.himp.getMedintra().getAnticoagRetirada()){
						case 1: retirada = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_retirada_op1");break;
						case 2: retirada = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_retirada_op2");break;
						case 3: retirada = this.bundle.getString("imp_dispositivos_tab_himp_med_intra_antcoag_retirada_op3");break;
						default: retirada = "";break;
					}
				}
				root.addContent(new Element("RetiradaAnticoagulante").setText(retirada));
				root.addContent(new Element("INR").setText(this.himp.getMedintra().getInr()!=null?this.himp.getMedintra().getInr():null));
			}
			//comentariosintra
			root.addContent(new Element("Comentariosintra").setText((this.himp.getComentarios()!=null && this.himp.getComentarios().length()>0)?this.himp.getComentarios().toString():null));					
			// comentarios post
			root.addContent(new Element("Comentariospost").setText((this.hev.getComentarios()!=null && this.hev.getComentarios().length()>0)?this.hev.getComentarios().toString():null));
			// modo programado generador
			root.addContent(new Element("ModoGenerador").setText((this.report.getModogen()!=null && this.report.getModogen().length()>0)?this.report.getModogen().toString():null));
			// frecuencia basica
			root.addContent(new Element("Fbasica").setText(this.hev.getFbasica()!=null?this.hev.getFbasica():null));		
			// Frecuencia maxima
			root.addContent(new Element("FrecuenciaMaxima").setText(this.hev.getFmax()));
			// Frecuencia basica
			root.addContent(new Element("FrecuenciaReposo").setText(this.hev.getFmin()));
			// Frecuencia histeresis
			root.addContent(new Element("Histeresis").setText(this.hev.getValorHisteresis()!=null?this.hev.getValorHisteresis():null));
			// Intervalos AV
			root.addContent(new Element("IAVDetectado").setText(this.hev.getIavdetec()!=null?this.hev.getIavdetec():null));
			root.addContent(new Element("IAVEstimulado").setText(this.hev.getIavestim()!=null?this.hev.getIavestim():null));
			root.addContent(new Element("IAVMax").setText(this.hev.getIavmax()!=null?this.hev.getIavmax():null));
			root.addContent(new Element("IAVMin").setText(this.hev.getIavmin()!=null?this.hev.getIavmin():null));			
			// Secuencia de activacion
			String secac="";
			if(this.hev.getSactivacion()!=null){
				if(this.hev.getSactivacion().equals(1))
					secac = this.bundle.getString("imp_dispositivos_tab_ev_prog_sec_act_op1");
				else if(this.hev.getSactivacion().equals(2))
					secac = this.bundle.getString("imp_dispositivos_tab_ev_prog_sec_act_op2");
				else if(this.hev.getSactivacion().equals(3))
					secac = this.bundle.getString("imp_dispositivos_tab_ev_prog_sec_act_op3");
				else if(this.hev.getSactivacion().equals(4))
					secac = this.bundle.getString("imp_dispositivos_tab_ev_prog_sec_act_op4");
				else if(this.hev.getSactivacion().equals(5))
					secac = this.bundle.getString("imp_dispositivos_tab_ev_prog_sec_act_op5");
				else
					secac = "";
			}
			root.addContent(new Element("SecActivacion").setText(secac));
			// Estimulacion post-choque
			root.addContent(new Element("AmplitudPostChoque").setText(this.hev.getAmpPostch()!=null?this.hev.getAmpPostch():null));
			root.addContent(new Element("FrecuenciaPostChoque").setText(this.hev.getFrecPostch()!=null?this.hev.getFrecPostch():null));
			root.addContent(new Element("DuracionPostChoque").setText(this.hev.getDurPostch()!=null?this.hev.getDurPostch():null));
			root.addContent(new Element("DuracionImpulsoPostChoque").setText(this.hev.getDurpulsoPostch()!=null?this.hev.getDurpulsoPostch():null));
			
			// Test induccion - inducido
			root.addContent(new Element("TestInduccion").setText((this.himp.isTesti())?"1":"0"));			
			// Test induccion - energia choque
			root.addContent(new Element("TestEnergia").setText((this.himp.getEnergiatest()!=null && this.himp.getEnergiatest().length()>0)?this.himp.getEnergiatest().toString():null));
			// Test induccion - impedancia choque
			root.addContent(new Element("TestImpedancia").setText((this.himp.getImptest()!=null && this.himp.getImptest().length()>0)?this.himp.getImptest().toString():null));
			// Tratamiento previo electrodos VDD. Se obtiene la medida de onda P y se asigna como elemento adicional al electrodo en VD
			String ondap_vdd = UtilMapeos.obtenerOndaPVDD_EvSeg(this.elecs);
			String poldet_vdd = UtilMapeos.obtenerPolDetVDD_EvSeg(this.elecs);			
			// Lista electrodos
			ArrMaestrasDao maestrasdao = new ArrMaestrasDaoImpl("consultor");
			ElectrodosDao elecdao = new ElectrodosDaoImpl("consultor");
			for(ImpImplanteElectrodos e:this.elecs){
				if(!(e.isVdd() && e.getCamara()==948) && e.getEstado()==0){// Los abandonados, explantados, extraidos no entran
					Element el = new Element("Electrodo");
					el.addContent(new Element("Modelo").setText(e.getNombremodelo()!=null?e.getNombremodelo():null));
					el.addContent(new Element("NumSerie").setText(e.getNumserie()!=null?e.getNumserie():null));
					el.addContent(new Element("Fabricante").setText((elecdao.findByPrimaryKey(e.getIdelectrodo()).getFabricante())));
					if(e.getVia()!=null && e.getVia()>0)
						el.addContent(new Element("Via").setText((maestrasdao.findByPrimaryKey(e.getVia()).getValor())));				
					if(e.getLateralidad()!=null && e.getLateralidad()>0)
						el.addContent(new Element("Lateralidad").setText((maestrasdao.findByPrimaryKey(e.getLateralidad()).getValor())));
					if(e.getCamara()!=null && e.getCamara()>0)
						el.addContent(new Element("Camara").setText((maestrasdao.findByPrimaryKey(e.getCamara()).getValor())));
					if(e.getZonacamara()!=null && e.getZonacamara()>0)
						el.addContent(new Element("Zona").setText((maestrasdao.findByPrimaryKey(e.getZonacamara()).getValor())));		
					if(e.getPorcion()!=null && e.getPorcion()>0)
						el.addContent(new Element("Porcion").setText((maestrasdao.findByPrimaryKey(e.getPorcion()).getValor())));
					el.addContent(new Element("Ondarp").setText(e.getOndarpEv()!=null?e.getOndarpEv():null));
					el.addContent(new Element("Impedancia").setText(e.getImpohmEv()!=null?e.getImpohmEv():null));
					el.addContent(new Element("UmbralV").setText(e.getUmbralvEv()!=null?e.getUmbralvEv():null));
					el.addContent(new Element("Umbralms").setText(e.getUmbralmsEv()!=null?e.getUmbralmsEv():null));
					el.addContent(new Element("DurImp").setText(e.getDurimpulso()!=null?e.getDurimpulso():null));
					el.addContent(new Element("Voltaje").setText(e.getVoltaje()!=null?e.getVoltaje():null));
					// valores programacion/umbrales hoja de implante
					el.addContent(new Element("Ondarp_Himp").setText(e.getOndarpImp()!=null?e.getOndarpImp():null));
					el.addContent(new Element("Impedancia_Himp").setText(e.getImpohmImp()!=null?e.getImpohmImp():null));
					el.addContent(new Element("Impedanciams_Himp").setText(e.getImpmsImp()!=null?e.getImpmsImp():null));
					el.addContent(new Element("UmbralV_Himp").setText(e.getUmbralvImp()!=null?e.getUmbralvImp():null));
					el.addContent(new Element("Umbralms_Himp").setText(e.getUmbralmsImp()!=null?e.getUmbralmsImp():null));
					el.addContent(new Element("SlewRate").setText(e.getSlewrate()!=null?e.getSlewrate():null));
					if(e.getPoldeteccion()!=null)
						el.addContent(new Element("PolDet").setText(e.getPoldeteccion().equals("0")?"Monopolar":"Bipolar"));
					if(e.getPolestimulacion()!=null)
						el.addContent(new Element("PolEst").setText(e.getPolestimulacion().equals("0")?"Monopolar":"Bipolar"));
					if(e.getCapturaauto()!=null)
						el.addContent(new Element("CapAuto").setText(e.getCapturaauto().equals((short) 0)?"Si":"No"));
					el.addContent(new Element("VDD").setText(e.isVdd() && e.getCamara()!=null && e.getCamara()==948?"Si":null));
					el.addContent(new Element("OndarpVDD").setText(ondap_vdd!=null?ondap_vdd:null));
					if(poldet_vdd!=null)
						el.addContent(new Element("PolDetVDD").setText(poldet_vdd.equals("0")?"Monopolar":"Bipolar"));
					el.addContent(new Element("FechaImplante").setText(e.getFechaimplante()!=null?sdf.format(e.getFechaimplante()):null));
					// control de electrodo subcutaneo
					el.addContent(new Element("SICD").setText(e.getConector()!=null && e.getConector().equals("SQ1")?"1":"0"));	
					root.addContent(el);
				}	
			}	
			// Numero total de electrodos
			if(this.elecs!=null)
				root.addContent(new Element("NumeroElectrodos").setText(String.valueOf(this.elecs.size())));
			else
				root.addContent(new Element("NumeroElectrodos").setText(null));
			// Gestion Complicaciones
			String compl = "",aux="";
			// Complicaciones intra
			root.addContent(new Element("HayComplicacionesIntra").setText(this.listacint.size()>0?"1":"0"));
			// Lista complicaciones intra
			ComplicacionDao compdao = new ComplicacionDaoImpl("consultor");
			for(ImpHojaImplanteComplicacion c:this.listacint){
				Element el = new Element("ComplicacionIntra");
				aux = compdao.findByPrimaryKey(c.getIdcompl()).getClase();
				compl = compl + aux +", ";
				el.addContent(new Element("Tipo").setText((aux)));
				root.addContent(el);
			}
			// Complicaciones post
			root.addContent(new Element("HayComplicacionesPost").setText(this.listacpost.size()>0?"1":"0"));
			// Lista complicaciones intra
			for(ImpEvolucionComplicacion c:this.listacpost){
				Element el = new Element("ComplicacionPost");
				aux = compdao.findByPrimaryKey(c.getIdcompl()).getClase();
				compl = compl + aux +", ";
				el.addContent(new Element("Tipo").setText((aux)));
				root.addContent(el);
			}
			/*String res = null;
			if(!compl.equals(""))
				res = compl.substring(0,compl.length()-2);
			System.out.println(res);
			root.addContent(new Element("ResumenComplicaciones").setText(res));*/
			root.addContent(new Element("ResumenComplicaciones").setText(!compl.equals("")?compl.substring(0,compl.length()-2):null));
			// Motivo alta
			if(this.hev.getMotivoalta()!=null){
				if(this.hev.getMotivoalta()==1)
					root.addContent(new Element("MotivoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_motivo_op1")));
				else if(this.hev.getMotivoalta()==2)
					root.addContent(new Element("MotivoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_motivo_op2")));
				else if(this.hev.getMotivoalta()==3)
					root.addContent(new Element("MotivoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_motivo_op3")));
				else if(this.hev.getMotivoalta()==4)
					root.addContent(new Element("MotivoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_motivo_op4")));
				else if(this.hev.getMotivoalta()==5)
					root.addContent(new Element("MotivoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_motivo_op5")));
				else if(this.hev.getMotivoalta()==6)
					root.addContent(new Element("MotivoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_motivo_op6")));
				else
					root.addContent(new Element("MotivoAlta"));
			}else
				root.addContent(new Element("MotivoAlta"));	
			// Fecha alta
			root.addContent(new Element("FechaAlta").setText(this.hev.getFechaalta()!=null?sdf.format(this.hev.getFechaalta()):null));
			// Tipo alta
			if(this.hev.getTipoalta()!=null){
				if(this.hev.getTipoalta()==1)
					root.addContent(new Element("TipoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_tipo_op1")));
				else if(this.hev.getTipoalta()==2)
					root.addContent(new Element("TipoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_tipo_op2")));
				else if(this.hev.getTipoalta()==3)
					root.addContent(new Element("TipoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_tipo_op3")));
				else if(this.hev.getTipoalta()==4)
					root.addContent(new Element("TipoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_tipo_op4")));
				else if(this.hev.getTipoalta()==5)
					root.addContent(new Element("TipoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_tipo_op5")));
				else if(this.hev.getTipoalta()==6)
					root.addContent(new Element("TipoAlta").setText(this.bundle.getString("imp_dispositivos_tab_ev_alta_tipo_op6")));
				else
					root.addContent(new Element("TipoAlta"));
			}else
				root.addContent(new Element("TipoAlta"));
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
			
			// PROGRAMACION
			// Zonas de programacion
			for(ImpZona z:this.hev.getZonas()){
				Element zona = new Element("ZonaTerapia");
				zona.addContent(new Element("Tipo").setText(z.getTipo()!=null?z.getTipo():null));
				zona.addContent(new Element("Frecuencia").setText(z.getFcPpm()!=null?z.getFcPpm():null));
				zona.addContent(new Element("ATP").setText(z.getAtps().size()>0?this.bundle.getString("eef_reporte_msg_zonas_si"):this.bundle.getString("eef_reporte_msg_zonas_no")));
				zona.addContent(new Element("Choque").setText(z.getChqs().size()>0?this.bundle.getString("eef_reporte_msg_zonas_si"):this.bundle.getString("eef_reporte_msg_zonas_no")));
				root.addContent(zona);
			}
			// RECOMENDACIONES
			root.addContent(new Element("Recomendaciones").setText(this.hev.getRecomendaciones()!=null?this.hev.getRecomendaciones():null));	
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte Implante. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Reporte Implante. Motivo: "+e.getMessage(),e);
		}
		
	}
}

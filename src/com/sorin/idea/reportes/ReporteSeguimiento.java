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
import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dao.ElectrodosDao;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpSintomas;
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.SegObservacionesDai;
import com.sorin.idea.dto.SegObservacionesMp;
import com.sorin.idea.dto.SegPorestimulacion;
import com.sorin.idea.dto.SegSeguimiento;
import com.sorin.idea.dto.SegSintomas;
import com.sorin.idea.dto.SegSistema;
import com.sorin.idea.dto.SegSituacionclinica;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilMapeos;
import com.sorin.idea.util.UtilReporteInformes;

public class ReporteSeguimiento {

	private static Logger logger = Logger.getLogger(ReporteSeguimiento.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	
	private SegSeguimiento seg;
	private SituacionClinicaProc sitclin;
	private SegSistema sist;
	private ImpEvolucion hev;
	private UtilReporteInformes report;
	private InfoCentro centro;
	private ArrayList<ImpImplanteElectrodos> elecs;
	private SegObservacionesMp obsmp;
	private SegObservacionesDai obsdai;
	private SegPorestimulacion por;
	private ResourceBundle bundle;
	
	public ReporteSeguimiento(String path, PacienteAplDto pacienteSelect,SegSeguimiento s, SituacionClinicaProc sc, ImpEvolucion hevo,SegSistema st,UtilReporteInformes rep,InfoCentro c,ArrayList<ImpImplanteElectrodos> els
			,SegObservacionesMp obsmp, SegObservacionesDai obsdai, SegPorestimulacion por, ResourceBundle bundle){
		
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.hev = hevo;
		this.seg = s;
		this.sitclin = sc;
		this.sist = st;
		this.report = rep;
		this.centro = c;
		this.elecs = els;
		this.obsmp = obsmp;
		this.obsdai = obsdai;
		this.por = por;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	public void GeneraArchivoPlanilla(){
		Element root = new Element("SEGUIMIENTO");
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
			// Separacion nombre , apellido 1, apellido 2
			root.addContent(new Element("Nombre").setText(this.paciente.getNombre()));
			root.addContent(new Element("Apellido1").setText(this.paciente.getApellid1()));
			root.addContent(new Element("Apellido2").setText(this.paciente.getApellid2()));
			
			root.addContent(new Element("Centro").setText(this.centro.getCentro()));
			
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
			//Tipo seguimiento
			root.addContent(new Element("TipoSeguimiento").setText((this.seg.getTiposeguimiento().equals(0)?this.bundle.getString("seg_disp_tipo_seg_op0"):this.bundle.getString("seg_disp_tipo_seg_op1"))));
			//Remoto
			root.addContent(new Element("Remoto").setText((this.seg.getRemoto()!=null && this.seg.getRemoto()==1)?"true":"false"));
			//Motivo no programado
			//Responsable
			root.addContent(new Element("Responsable").setText((this.seg.getOperador()!=null)?this.seg.getOperador():""));
			//Enfermeria
			root.addContent(new Element("Enfermeria").setText((this.seg.getOperadorenf()!=null)?this.seg.getOperadorenf():""));
			
			//Fecha seguimiento
			root.addContent(new Element("FechaSeguimiento").setText(sdf.format(this.seg.getFecha())));
			//Fecha proximo
			root.addContent(new Element("FechaProximoSeguimiento").setText((this.seg.getFechaproximoseg()!=null)?sdf.format(this.seg.getFechaproximoseg()):""));		
			//Caracter proximo
			if(this.seg.getCaracterproximo()!=null && this.seg.getCaracterproximo()==1){
				root.addContent(new Element("TipoProximoSeguimiento").setText(this.bundle.getString("seg_disp_tipo_seg_pres_op1")));
			}else if (this.seg.getCaracterproximo()!=null && this.seg.getCaracterproximo()==2)
				root.addContent(new Element("TipoProximoSeguimiento").setText(this.bundle.getString("seg_disp_tipo_seg_pres_op2")));
			
			String sint = "";
			for(SintomasSitclinProc s:this.sitclin.getSintomas()){
				sint = sint + s.getIdsintomas()+", ";
			}
			if(sint.length()>0)
				sint = sint.substring(0, sint.length()-2);
			root.addContent(new Element("Sintoma").setText(sint));
			//Ritmo basal
			root.addContent(new Element("Ritmobasal").setText(this.report.getRitmo()));
			//conduccion av
			root.addContent(new Element("Conduccionav").setText(this.report.getConduccionav()));
			//conduccion qrs
			root.addContent(new Element("Qrs").setText(this.report.getConduccionqrs()));
			//anchura qrs
			root.addContent(new Element("Anchuraqrs").setText((this.sitclin.getAnchuraqrs()!=null)?this.sitclin.getAnchuraqrs().toString():null));
			//nyha
			if(this.sitclin.getNyha()!=null){
				if(this.sitclin.getNyha()==1)
					root.addContent(new Element("Nyha").setText("I"));
				else if(this.sitclin.getNyha()==2)
					root.addContent(new Element("Nyha").setText("II"));
				else if(this.sitclin.getNyha()==3)
					root.addContent(new Element("Nyha").setText("III"));
				else if(this.sitclin.getNyha()==4)
					root.addContent(new Element("Nyha").setText("IV"));
				else
					root.addContent(new Element("Nyha"));
			}else{
				root.addContent(new Element("Nyha"));
			}
			//cardiopatia
			root.addContent(new Element("Cardiopatia").setText(this.report.getCardiopatia()));
			//aevolucion
			root.addContent(new Element("AEvolucion").setText((this.sitclin.getAevolucion()!=null)?this.sitclin.getAevolucion().toString():null));	
			//revascularizacion
			root.addContent(new Element("Revascularizacion").setText((this.sitclin.getRevasc()!=null && this.sitclin.getRevasc()==1)?"1":null));	
			//infarto previo
			root.addContent(new Element("Infartoprevio").setText((this.sitclin.getInfprevio()!=null && this.sitclin.getInfprevio()==1)?"1":null));		
			//anio infarto previo
			root.addContent(new Element("AInfarto").setText((this.sitclin.getAnio()!=null && this.sitclin.getAnio().length()>0)?this.sitclin.getAnio().toString():null));			
			
			// Pruebas sistema completo
			root.addContent(new Element("InfoSistema").setText(this.report.getInfosistema()));
			// Bateria
			root.addContent(new Element("VoltajeBateria").setText(this.sist.getVoltaje()));
			root.addContent(new Element("ImpedanciaBateria").setText(this.sist.getImpedancia()));
			root.addContent(new Element("FrecMagneticaBateria").setText(this.sist.getFmagnetica()));
			root.addContent(new Element("UltChoqueFecha").setText((this.sist.getUltchqfecha()!=null)?sdf.format(this.sist.getUltchqfecha()):null));
			root.addContent(new Element("UltChoqueEnergia").setText((this.sist.getUltchqenergia()!=null)?this.sist.getUltchqenergia():null));
			root.addContent(new Element("UltChoqueImp").setText((this.sist.getUltchqimpedancia()!=null)?this.sist.getUltchqimpedancia():null));	
			root.addContent(new Element("UltChoqueTiempo").setText((this.sist.getUltchqtcarga()!=null)?this.sist.getUltchqtcarga():null));	
			if(this.sist.getEol()!=null)
				root.addContent(new Element("EOL").setText((this.sist.getEol().equals(1))?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_no")));	
			if(this.sist.getEri()!=null)
				root.addContent(new Element("ERI").setText((this.sist.getEri().equals(1))?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_no")));	
			
			// modo programado generador
			root.addContent(new Element("ModoGenerador").setText((this.report.getModogen()!=null && this.report.getModogen().length()>0)?this.report.getModogen().toString():null));
			// Numero total de electrodos
			if(this.elecs!=null)
				root.addContent(new Element("NumeroElectrodos").setText(String.valueOf(this.elecs.size())));			
			// Tratamiento previo electrodos VDD. Se obtiene la medida de onda P y se asigna como elemento adicional al electrodo en VD
			String ondap_vdd = UtilMapeos.obtenerOndaPVDD_EvSeg(this.elecs);
			String poldet_vdd = UtilMapeos.obtenerPolDetVDD_EvSeg(this.elecs);		
			// Lista electrodos
			ArrMaestrasDao maestrasdao = new ArrMaestrasDaoImpl("consultor");
			ElectrodosDao edao = new ElectrodosDaoImpl("consultor");
			for(ImpImplanteElectrodos e:this.elecs){
				if(!(e.isVdd() && e.getCamara()==948) && e.getEstado()==0){
					Element el = new Element("Electrodo");
					el.addContent(new Element("Modelo").setText(edao.findByPrimaryKey(e.getIdelectrodo()).getModelo()));
					el.addContent(new Element("NumSerie").setText(e.getNumserie()!=null?e.getNumserie():null));
					el.addContent(new Element("Fabricante").setText((edao.findByPrimaryKey(e.getIdelectrodo()).getFabricante())));
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
					el.addContent(new Element("SICD").setText(e.getConector().equals("SQ1")?"1":"0"));
					root.addContent(el);
				}	
			}		
			// Generador
			root.addContent(new Element("ModeloGenerador").setText(this.report.getModelogen()));
			root.addContent(new Element("FabricanteGenerador").setText(this.report.getFabricantegen()));
			root.addContent(new Element("NumSerieGenerador").setText(this.report.getNumseriegen()));
			root.addContent(new Element("MRIGenerador").setText(this.report.isMri()?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_no")));
			root.addContent(new Element("RFGenerador").setText(this.report.isRf()?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_no")));
			root.addContent(new Element("FechaImplanteGenerador").setText((this.report.getFechaimplantegen()!=null)?sdf.format(this.report.getFechaimplantegen()):null));
			//tipo dispositivo
			root.addContent(new Element("TipoDispositivo").setText(this.report.getTipodispositivo()));
			// Frecuencia basal
			root.addContent(new Element("FrecuenciaBasal").setText(this.hev.getFbasica()));
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
			root.addContent(new Element("IVV").setText(this.hev.getIvv()!=null?this.hev.getIvv():null));
			// Estimulacion post-choque
			root.addContent(new Element("AmplitudPostChoque").setText(this.hev.getAmpPostch()!=null?this.hev.getAmpPostch():null));
			root.addContent(new Element("FrecuenciaPostChoque").setText(this.hev.getFrecPostch()!=null?this.hev.getFrecPostch():null));
			root.addContent(new Element("DuracionPostChoque").setText(this.hev.getDurPostch()!=null?this.hev.getDurPostch():null));
			root.addContent(new Element("DuracionImpulsoPostChoque").setText(this.hev.getDurpulsoPostch()!=null?this.hev.getDurpulsoPostch():null));
			
			// MP Dependiente
			if(this.hev.getMpdependiente()!=null)
				root.addContent(new Element("MPDependiente").setText(this.hev.getMpdependiente()==1?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_no")));
			// MEV
			if(this.hev.getMev()!=null)
				root.addContent(new Element("MEV").setText(this.hev.getMev()==1?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_no")));
			// Porcentajes de estimulacion
			if(this.por!=null){
				root.addContent(new Element("AS").setText(this.por.getPoras()!=null?this.por.getPoras():null));
				root.addContent(new Element("AP").setText(this.por.getPorap()!=null?this.por.getPorap():null));
				root.addContent(new Element("VS").setText(this.por.getPorvs()!=null?this.por.getPorvs():null));
				root.addContent(new Element("VP").setText(this.por.getPorvp()!=null?this.por.getPorvp():null));
				root.addContent(new Element("TiempoFA").setText(this.por.getTiempofa()!=null?this.por.getTiempofa():null));
			}
			// Observaciones MP
			if(this.obsmp!=null){
				root.addContent(new Element("NumArrA").setText(this.obsmp.getNumarrau()));
				root.addContent(new Element("NumArrV").setText(this.obsmp.getNumarrv()));
				root.addContent(new Element("NumCambioModo").setText(this.obsmp.getNumcambiomodoarrau()));
			}
			// Observaciones DAI
			if(this.obsdai!=null){
				root.addContent(new Element("NumEpiFV").setText(this.obsdai.getNumepifv()));
				root.addContent(new Element("NumEpiTV").setText(this.obsdai.getNumepitv()));
				root.addContent(new Element("NumEpiTSV").setText(this.obsdai.getNumepitsv()));
				root.addContent(new Element("NumEpiNoSost").setText(this.obsdai.getNumepinosost()));
				root.addContent(new Element("NumEpiOtros").setText(this.obsdai.getNumepinoesp()));
				root.addContent(new Element("TerapiaATP").setText(this.obsdai.getAtp()!=null&&this.obsdai.getAtp().equals(1)?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):null));
				root.addContent(new Element("NumTerapiasATP").setText(this.obsdai.getNumteratp()!=null?this.obsdai.getNumteratp():null));
				root.addContent(new Element("TerapiaChoque").setText(this.obsdai.getChoq()!=null&&this.obsdai.getChoq().equals(1)?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):null));
				root.addContent(new Element("NumTerapiasChoque").setText(this.obsdai.getNumterchoq()!=null?this.obsdai.getNumterchoq():null));
				root.addContent(new Element("EpiRuido").setText(this.obsdai.getEpiruido()!=null&&this.obsdai.getEpiruido().equals(1)?this.bundle.getString("seg_disp_reporte_epi_ruido"):null));
				if(this.obsdai.getTodasapropiadas()!=null){
					root.addContent(new Element("TodasApropiadas").setText(this.obsdai.getTodasapropiadas().equals(1)?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_no")));
				}
				
			}
			// Zonas de programacion
			for(ImpZona z:this.hev.getZonas()){
				Element zona = new Element("ZonaTerapia");
				zona.addContent(new Element("Tipo").setText(z.getTipo()!=null?z.getTipo():null));
				zona.addContent(new Element("Frecuencia").setText(z.getFcPpm()!=null?z.getFcPpm():null));
				zona.addContent(new Element("ATP").setText(z.getAtps().size()>0?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_no")));
				zona.addContent(new Element("Choque").setText(z.getChqs().size()>0?this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_si"):this.bundle.getString("seg_disp_tab_datos_sistema_bat_rrt_no")));
				root.addContent(zona);
			}
			// Comentarios
			root.addContent(new Element("Comentarios").setText(this.sist.getComentarios()!=null&&!this.sist.getComentarios().equals("")?this.sist.getComentarios():null));
		}catch(Exception e1){
			logger.error("Error generando fichero XML para informe - Reporte Seguimiento de dispositivo. Motivo: "+e1.getMessage(),e1);
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
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte Seguimiento de dispositivo. Motivo: "+e1.getMessage(),e1);
		}
	}
}

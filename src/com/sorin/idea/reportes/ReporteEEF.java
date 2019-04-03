package com.sorin.idea.reportes;

import hvn.cm.dao.DAOException;
import hvn.mod.properties.CargaParametros;

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

import com.sorin.idea.dao.ArrEstudioAblacionDao;
import com.sorin.idea.dao.ArrEstudioCatAplDao;
import com.sorin.idea.dao.ArrEstudioTaquiDao;
import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.CateterDao;
import com.sorin.idea.dao.ComplicacionesDao;
import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dto.ArrAblacionComplica;
import com.sorin.idea.dto.ArrConduccEc;
import com.sorin.idea.dto.ArrDesfibrilador;
import com.sorin.idea.dto.ArrEnf;
import com.sorin.idea.dto.ArrEnfIntroductores;
import com.sorin.idea.dto.ArrEstudio;
import com.sorin.idea.dto.ArrEstudioAblacion;
import com.sorin.idea.dto.ArrEstudioCatApl;
import com.sorin.idea.dto.ArrEstudioCatUso;
import com.sorin.idea.dto.ArrEstudioPeriodo;
import com.sorin.idea.dto.ArrEstudioPop;
import com.sorin.idea.dto.ArrEstudioSop;
import com.sorin.idea.dto.ArrEstudioTaqui;
import com.sorin.idea.dto.ArrEstudioVias;
import com.sorin.idea.dto.Complicaciones;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.SituacionClinicaGeneral;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.iu.ControlEef;
import com.sorin.idea.iu.ControlMaestras;
import com.sorin.idea.jdbc.ArrEstudioAblacionDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioCatAplDaoImpl;
import com.sorin.idea.jdbc.ArrEstudioTaquiDaoImpl;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.CateterDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesDaoImpl;
import com.sorin.idea.util.AbordajeAblaciones;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilFechas;

public class ReporteEEF {

	private static Logger logger = Logger.getLogger(ReporteEEF.class);
	PacienteAplDto paciente = new PacienteAplDto();
	ArrEstudio eef = new ArrEstudio();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	private InfoCentro centro;
	private SituacionClinicaProc hind;
	private ArrEnf enf;
	private ResourceBundle bundle;
	
	private int idCompBAV;
	private int idCompEMB;
	private int idCompDERR;
	private int idCompTEP;
	private int idCompVAS;

	public ReporteEEF(String path, ArrEstudio eef, PacienteAplDto pacienteSelect, InfoCentro c, SituacionClinicaProc sitclin,ArrEnf enf, ResourceBundle bundle) {
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.eef = eef;
		this.centro = c;
		this.hind = sitclin;
		this.enf = enf;
		this.bundle = bundle;
		this.obtenerDatosComplDiag();
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}

	public void GeneraArchivoPlanilla() {
		try {
			String compAblacion = "";
			ArrMaestrasDao maestrasdao = new ArrMaestrasDaoImpl("consultor");
			ComplicacionesDao cdao = new ComplicacionesDaoImpl("consultor");
	/******DATOS GENERALES DEL ESTUDIO********/		
			ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
			Element root = new Element("Listado");
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
	        root.addContent(new Element("Centro").setText(this.centro.getCentro()));
			root.addContent(new Element("nestudio").setText(this.eef
					.getNestudio()));
			root.addContent(new Element("festudio").setText(UtilFechas.getFechaStringFormato(this.eef.getFecha(), "dd-MM-yyyy")));
			root.addContent(new Element("paciente").setText(this.paciente.getNombreCompleto()));
			root.addContent(new Element("fnaci").setText(this.paciente.getFechaNaci()!=null?UtilFechas.getFechaStringFormato(this.paciente.getFechaNaci(), "dd-MM-yyyy"):""));
			root.addContent(new Element("edad").setText(this.paciente.getEdad()));
			root.addContent(new Element("nhc").setText(this.paciente.getNhc()));
			root.addContent(new Element("nuhsa").setText(this.paciente.getNuhsa()));

			// Separacion nombre , apellido 1, apellido 2
			root.addContent(new Element("Nombre").setText(this.paciente.getNombre()));
			root.addContent(new Element("Apellido1").setText(this.paciente.getApellid1()));
			root.addContent(new Element("Apellido2").setText(this.paciente.getApellid2()));
									
			root.addContent(new Element("motivo").setText(this.eef.getMotivo()));
			String caracteristicas = "";
			
			if(this.eef.getNavegador()!=-1){
				String nav = maestrasdao.findByPrimaryKey(this.eef.getNavegador()).getValor();
				caracteristicas += (nav!=null && !nav.equals("") && !nav.equals("NO"))?this.bundle.getString("eef_reporte_msg_navegador")+" ("+maestrasdao
						.findByPrimaryKey(this.eef.getNavegador()).getValor()+"). ":"";	
			}			
			if (this.eef.getEscopia() == 1)
				caracteristicas += this.bundle.getString("eef_reporte_msg_escopia_no")+". ";
			if (this.eef.getEcografia() == 1)
				caracteristicas += this.bundle.getString("eef_reporte_msg_ecografia")+". ";
			if (this.eef.getAngiografia() == 1)
				caracteristicas += this.bundle.getString("eef_reporte_msg_angiografia")+". ";
			if(this.eef.getRobot()!=-1){
				String rob = maestrasdao.findByPrimaryKey(this.eef.getRobot()).getValor();
				caracteristicas += (rob!=null && !rob.equals("") && !rob.equals("NO"))?this.bundle.getString("eef_reporte_msg_robot")+" ("+maestrasdao
						.findByPrimaryKey(this.eef.getRobot()).getValor()+"). ":"";
			}					
			root.addContent(new Element("caracteristicas").setText(caracteristicas));
			root.addContent(new Element("inicio").setText(this.eef.getHllegadah()+ ":" + this.eef.getHllegadam()));
			root.addContent(new Element("fin").setText(this.eef.getHsalidah()+ ":" + this.eef.getHsalidam()));
			/*root.addContent(new Element("fin").setText(this.eef.getHcateterh()
					+ ":" + this.eef.getHcateterm()));*/
			root.addContent(new Element("duracion").setText(this.eef.getDuracion()));
			root.addContent(new Element("escopia").setText(this.eef.getTescopia()));
			root.addContent(new Element("recomendaciones").setText(this.eef.getRecomendaciones()));
	
			/******DATOS DEL ECG********/
			if (this.eef.getEcgb()) {
				if(this.eef.getEcgdto().getIdritmo()!=null && this.eef.getEcgdto().getIdritmo() > 0)
					root.addContent(new Element("ritmo").setText(maestrasdao.findByPrimaryKey(this.eef.getEcgdto().getIdritmo()).getValor().toLowerCase()));
				else
					root.addContent(new Element("ritmo").setText(" "));
				String cav = "";
				if(this.eef.getEcgdto().getIdconduccion()!=null && this.eef.getEcgdto().getIdconduccion() > 0){
					if (this.eef.getEcgdto().getIdconduccion() == 2)
						cav = this.bundle.getString("eef_tab_ecg_normal");
					else{
						if(this.eef.getEcgdto().getIdconduccionno()!=0)
							cav = maestrasdao.findByPrimaryKey(this.eef.getEcgdto().getIdconduccionno()).getValor().toLowerCase();
						else
							cav=this.bundle.getString("eef_tab_ecg_no_normal");
					}		
				}else
					cav = " ";
				root.addContent(new Element("cav").setText(cav));
				String qrs = "";
				if(this.eef.getEcgdto().getIdqrs()!=null && this.eef.getEcgdto().getIdqrs() > 0){
					if (this.eef.getEcgdto().getIdqrs() == 2)
						qrs = this.bundle.getString("eef_tab_ecg_normal");
					else{
						if(this.eef.getEcgdto().getIdqrsno()!=0)
							qrs = maestrasdao.findByPrimaryKey(
								this.eef.getEcgdto().getIdqrsno()).getValor();
						else
							qrs = this.bundle.getString("eef_tab_ecg_no_normal");
					}		
				}else
					qrs = " ";
				root.addContent(new Element("qrsecg").setText(qrs));
				root.addContent(new Element("rr").setText(this.eef.getEcgdto().getRr()));
				root.addContent(new Element("pr").setText(this.eef.getEcgdto().getPr()));
				root.addContent(new Element("qrs").setText(this.eef.getEcgdto().getQrs()));
				root.addContent(new Element("qt").setText(this.eef.getEcgdto().getQt()));
				root.addContent(new Element("qtc").setText(this.eef.getEcgdto().getQtc()));
				root.addContent(new Element("comentarios_ecg").setText(this.eef.getEcgdto().getComentarios()));
			} else {
				root.addContent(new Element("ritmo").setText(""));
				root.addContent(new Element("cav").setText(""));
				root.addContent(new Element("qrsecg").setText(""));
				root.addContent(new Element("rr").setText(""));
				root.addContent(new Element("pr").setText(""));
				root.addContent(new Element("qrs").setText(""));
				root.addContent(new Element("qt").setText(""));
				root.addContent(new Element("qtc").setText(""));
				root.addContent(new Element("comentarios_ecg").setText(null));
			}

	/******DATOS DE CONDUCCION********/
			if (this.eef.getConduccionb()) {
				root.addContent(new Element("ah").setText(this.eef.getConducciondto().getAh()));
				root.addContent(new Element("hv").setText(this.eef.getConducciondto().getHv()));

				String per = "";
				if (this.eef.getConducciondto().getEstim().size() == 2) {
					per = this.bundle.getString("eef_reporte_msg_cav_per_cond")+". ";
					String tipo = maestrasdao.findByPrimaryKey(
							this.eef.getConducciondto().getEstim().get(0).getConduc()).getValor();
					if (tipo.startsWith("ANTE")) {
						per += this.bundle.getString("eef_reporte_msg_cav_per_cond_ante")+" "
								+ this.eef.getConducciondto().getEstim().get(0).getMs() + " "+this.bundle.getString("eef_reporte_msg_cav_per_cond_ms")+". ";
						per += this.bundle.getString("eef_reporte_msg_cav_per_cond_ret")+" "
								+ this.eef.getConducciondto().getEstim().get(1).getMs() + " "+this.bundle.getString("eef_reporte_msg_cav_per_cond_ms")+". ";
					} else {
						per += this.bundle.getString("eef_reporte_msg_cav_per_cond_ante")+" "
								+ this.eef.getConducciondto().getEstim().get(1).getMs() + " "+this.bundle.getString("eef_reporte_msg_cav_per_cond_ms")+". ";
						per += this.bundle.getString("eef_reporte_msg_cav_per_cond_ret")+" "
								+ this.eef.getConducciondto().getEstim().get(0).getMs() + " "+this.bundle.getString("eef_reporte_msg_cav_per_cond_ms")+". ";
					}
				}
				root.addContent(new Element("refrac").setText(per));
				root.addContent(new Element("comcav").setText(this.eef.getConducciondto().getComentarios()!=null && !this.eef.getConducciondto().getComentarios().equals("")?this.eef.getConducciondto().getComentarios():""));
			} else {
				root.addContent(new Element("ah").setText(""));
				root.addContent(new Element("hv").setText(""));
				root.addContent(new Element("refrac").setText(""));
				root.addContent(new Element("comcav").setText(""));
			}

	/******DATOS DE VIAS ACCESORIAS********/
			if (this.eef.getViasb()) {
				String vias = "";
				for (ArrEstudioVias via : this.eef.getViasdto()) {
					if(via.getIdloc() != null && via.getIdloc() > 0){
						String local = "";
						String[] locs;
						switch (via.getIdloc()) {
						case 1:
							local = this.bundle.getString("eef_tab_vacc_loc_op1").toLowerCase();
							if(via.getLocs()!=null && !via.getLocs().equals("")){
								locs = via.getLocs().split(",");
								for (String l : locs)
									if (l.equals("1"))
										local += " "+this.bundle.getString("eef_tab_vacc_loc_op1_op1").toLowerCase();
									else if (l.equals("2"))
										local += " "+this.bundle.getString("eef_tab_vacc_loc_op1_op2").toLowerCase();
									else if (l.equals("3"))
										local += " "+this.bundle.getString("eef_tab_vacc_loc_op1_op3").toLowerCase();
							}
							break;
						case 2:
							local = this.bundle.getString("eef_tab_vacc_loc_op2").toLowerCase();
							if(via.getLocs()!=null && !via.getLocs().equals("")){
								locs = via.getLocs().split(",");
								for (String l : locs)
									if (l.equals("1"))
										local += " "+this.bundle.getString("eef_tab_vacc_loc_op2_op1").toLowerCase();
									else if (l.equals("2"))
										local += " "+this.bundle.getString("eef_tab_vacc_loc_op2_op2").toLowerCase();
									else if (l.equals("3"))
										local += " "+this.bundle.getString("eef_tab_vacc_loc_op2_op3").toLowerCase();
							}	
							break;
						case 3:
							local = this.bundle.getString("eef_tab_vacc_loc_op3").toLowerCase();
							if(via.getLocs()!=null && !via.getLocs().equals("")){
								switch (new Integer(via.getLocs())) {
								case 1:
									local += " "+this.bundle.getString("eef_tab_vacc_loc_op3_op1").toLowerCase();
									break;
								case 2:
									local += " "+this.bundle.getString("eef_tab_vacc_loc_op3_op2").toLowerCase();
									break;
								case 3:
									local += " "+this.bundle.getString("eef_tab_vacc_loc_op3_op3").toLowerCase();
									break;
								case 4:
									local += " "+this.bundle.getString("eef_tab_vacc_loc_op3_op4").toLowerCase();
									break;
								case 5:
									local += " "+this.bundle.getString("eef_tab_vacc_loc_op3_op5").toLowerCase();
									break;
								}
							}
							break;
						case 4:
							local = this.bundle.getString("eef_tab_vacc_loc_op4").toLowerCase();
							if(via.getLocs()!=null && !via.getLocs().equals("")){
								switch (new Integer(via.getLocs())) {
								case 1:
									local += " "+this.bundle.getString("eef_tab_vacc_loc_op4_op1");
									break;
								case 2:
									local += " "+this.bundle.getString("eef_tab_vacc_loc_op4_op2");
									break;
								}
							}
							break;
						default:
							break;
						}
						vias += this.bundle.getString("eef_reporte_msg_vacc_enun1")+" ";
						if(via.getIdvia()!=null && via.getIdvia().intValue()>0)
							vias += maestrasdao.findByPrimaryKey(via.getIdvia()).getValor().toLowerCase();
						if(via.getIdsentido()!=null && via.getIdsentido().intValue()>0)
							vias += " "+this.bundle.getString("eef_reporte_msg_vacc_enun2")+" "
									+ maestrasdao.findByPrimaryKey(via.getIdsentido()).getValor().toLowerCase();
						if(via.getIdtipo()!=null && via.getIdtipo().intValue()>0)
							vias += " "+ maestrasdao.findByPrimaryKey(via.getIdtipo()).getValor().toLowerCase();
						
						vias += ", "+this.bundle.getString("eef_reporte_msg_vacc_enun3")+" " + local + ".";
						if((via.getCa() != null && via.getCa().length() > 0) || (via.getCr() != null && via.getCr().length() > 0)){
							vias += " "+this.bundle.getString("eef_reporte_msg_vacc_enun4")+" ";
							if(via.getCa() != null && via.getCa().length() > 0){
								vias += " "+this.bundle.getString("eef_reporte_msg_vacc_enun5")+" " + via.getCa() + " "+this.bundle.getString("eef_reporte_msg_vacc_enun6");
								if(via.getCr() != null && via.getCr().length() > 0)
									vias += " "+this.bundle.getString("eef_reporte_msg_vacc_enun7");
							}
							if(via.getCr() != null && via.getCr().length() > 0)
								vias += " "+this.bundle.getString("eef_reporte_msg_vacc_enun8")+" " + via.getCr() + " "+this.bundle.getString("eef_reporte_msg_vacc_enun6")+".";
							vias += "\n\r";
						}
					}
				}
				root.addContent(new Element("via").setText(vias));
				root.addContent(new Element("comentarios_via").setText(this.eef.getComent_vias()));
			} else {
				root.addContent(new Element("via").setText(""));
			}

	/******DATOS DE PERIODO SINUSAL********/
			if (this.eef.getSinusalb()) {
				String sinusal = "";
				if (this.eef.getSinusaldto().getCiclo() != null
						&& !this.eef.getSinusaldto().getCiclo().isEmpty())
					sinusal += this.bundle.getString("eef_tab_fsin_ciclosin")+": "
							+ this.eef.getSinusaldto().getCiclo() + this.bundle.getString("eef_tab_fsin_ms")+".     ";
				if (this.eef.getSinusaldto().getTrns() != null
						&& !this.eef.getSinusaldto().getTrns().isEmpty())
					sinusal += this.bundle.getString("eef_tab_fsin_trns")+": " + this.eef.getSinusaldto().getTrns()
							+ this.bundle.getString("eef_tab_fsin_ms")+".     ";
				if (this.eef.getSinusaldto().getTrnsc() != null
						&& !this.eef.getSinusaldto().getTrnsc().isEmpty())
					sinusal += this.bundle.getString("eef_tab_fsin_trnsc")+": " + this.eef.getSinusaldto().getTrnsc()
							+ this.bundle.getString("eef_tab_fsin_ms")+".     ";
				if (this.eef.getSinusaldto().getTrt() != null
						&& !this.eef.getSinusaldto().getTrt().isEmpty())
					sinusal += this.bundle.getString("eef_tab_fsin_trt")+": " + this.eef.getSinusaldto().getTrt()
							+ this.bundle.getString("eef_tab_fsin_ms")+".     ";
				if (this.eef.getSinusaldto().getTcsa() != null
						&& !this.eef.getSinusaldto().getTcsa().isEmpty())
					sinusal += this.bundle.getString("eef_tab_fsin_tcsa")+": " + this.eef.getSinusaldto().getTcsa()
							+ this.bundle.getString("eef_tab_fsin_ms")+".     ";
				root.addContent(new Element("sinusal").setText(sinusal));
				root.addContent(new Element("comsinusal").setText(this.eef.getSinusaldto().getComentarios()!=null && !this.eef.getSinusaldto().getComentarios().equals("")?this.eef.getSinusaldto().getComentarios():""));
			} else {
				root.addContent(new Element("sinusal").setText(""));
				root.addContent(new Element("comsinusal").setText(""));
			}

	/******DATOS DE TAQUICARDIAS********/
			String tipoTaq = "";
			String comtq="";
			if(this.eef.getTaquicardiasb()){
				String taquis = "";
				String longitud = "", morfologia = "";
				ArrEstudioTaquiDao taqdao = new ArrEstudioTaquiDaoImpl("consultor");
				ArrEstudioTaqui taqs[] = taqdao.findWhereIdestudioEquals(this.eef.getIdestudio());
				for(ArrEstudioTaqui ta : taqs){
					if(ta.getInduccion()!=null){
						if(ta.getInduccion() == 1) 
							taquis += this.bundle.getString("eef_reporte_msg_taq_ind_no")+".";
						else if(ta.getInduccion() == 2)
							taquis += this.bundle.getString("eef_reporte_msg_taq_ind_no_cons")+".";
						else{
							if(ta.getInduccion() == 3){
								taquis += this.bundle.getString("eef_reporte_msg_taq_ind_si");
								if(ta.getModoind() != 0)
									taquis += " "+this.bundle.getString("eef_reporte_msg_taq_ind_si_pest_1")+" " + maestrasdao.findByPrimaryKey(ta.getPuntoest()).getValor().toLowerCase() + " "+this.bundle.getString("eef_reporte_msg_taq_ind_si_pest_2")+" " + maestrasdao.findByPrimaryKey(ta.getModoind())
									.getValor().toLowerCase();
								if(ta.getLongciclo() != null && ta.getLongciclo().length() > 0)
									taquis += ", "+this.bundle.getString("eef_reporte_msg_taq_ind_si_longcic")+" " + ta.getLongciclo() + " "+this.bundle.getString("eef_reporte_msg_taq_ind_si_longcic_ms");
								if(ta.getMorfologia() != null && ta.getMorfologia() > 0)
									taquis += " "+this.bundle.getString("eef_reporte_msg_taq_ind_si_morfo")+" " + maestrasdao.findByPrimaryKey(ta.getMorfologia()).getValor().toLowerCase().substring(3);
							}else if(ta.getInduccion() == 4)
								taquis += this.bundle.getString("eef_reporte_msg_taq_ind_esp");
							taquis += " "+this.bundle.getString("eef_reporte_msg_taq_enun1")+" ";
							if(ta.getTaquiindu()!=null&&ta.getTaquiindu() == 1) taquis += this.bundle.getString("eef_tab_taq_tab_taq_taquiindu_op1").toLowerCase();
							if(ta.getTaquiindu()!=null&&ta.getTaquiindu() == 2) taquis += this.bundle.getString("eef_tab_taq_tab_taq_taquiindu_op2").toLowerCase();
							if(ta.getComportamiento()!=null&&ta.getComportamiento() == 1) taquis += " "+this.bundle.getString("eef_tab_taq_tab_taq_comport_op1").toLowerCase();
							else if(ta.getComportamiento()!=null&&ta.getComportamiento() == 2) taquis += " "+this.bundle.getString("eef_tab_taq_tab_taq_comport_op2").toLowerCase();
							else if(ta.getComportamiento()!=null&&ta.getComportamiento() == 3) taquis += " "+this.bundle.getString("eef_tab_taq_tab_taq_comport_op3").toLowerCase();
							else if(ta.getComportamiento()!=null&&ta.getComportamiento() == 4) taquis += " "+this.bundle.getString("eef_tab_taq_tab_taq_comport_op4").toLowerCase();
							
							/*if(ta.getInduccion() == 3)
								taquis += longitud + morfologia;*/
							
							switch (ta.getIdn1()) {
							case 1:
								tipoTaq += " - "+this.bundle.getString("eef_taqui_t1").toLowerCase();
								taquis += " "+this.bundle.getString("eef_taqui_t1").toLowerCase();
								switch (ta.getIdn2()) {
								case 1:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t1_op1").toLowerCase();
									taquis += " "+this.bundle.getString("eef_taqui_t1_op1").toLowerCase();
									break;
								case 2:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t1_op2").toLowerCase();
									taquis += " "+this.bundle.getString("eef_taqui_t1_op2").toLowerCase();
									break;
								default:
									break;
								}
								break;
							case 2:
								tipoTaq += " - "+this.bundle.getString("eef_taqui_t2").toLowerCase();
								taquis += " "+this.bundle.getString("eef_taqui_t2").toLowerCase();
								switch (ta.getIdn2()) {
								case 1:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t2_op1");
									taquis += " "+this.bundle.getString("eef_taqui_t2_op1");
									break;
								case 2:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t2_op2");
									taquis += " "+this.bundle.getString("eef_taqui_t2_op2");
									break;
								case 3:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t2_op3");
									taquis += " "+this.bundle.getString("eef_taqui_t2_op3");
									break;
								case 4:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t2_op4");
									taquis += " "+this.bundle.getString("eef_taqui_t2_op4");
									break;
								default:
									break;
								}
								break;
							case 3:
								tipoTaq += " - "+this.bundle.getString("eef_taqui_t3_2");
								taquis += " "+this.bundle.getString("eef_taqui_t3_2");
								break;
							case 4:
								tipoTaq += " - "+this.bundle.getString("eef_taqui_t4");
								taquis += " "+this.bundle.getString("eef_taqui_t4");
								switch (ta.getIdn2()) {
								case 1:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t4_op1").toLowerCase();
									taquis += " "+this.bundle.getString("eef_taqui_t4_op1").toLowerCase();
									break;
								case 2:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t4_op2").toLowerCase();
									taquis += " "+this.bundle.getString("eef_taqui_t4_op2").toLowerCase();
									break;
								case 3:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t4_op3").toLowerCase();
									taquis += " "+this.bundle.getString("eef_taqui_t4_op3").toLowerCase();
									break;
								case 4:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t4_op4").toLowerCase();
									taquis += " "+this.bundle.getString("eef_taqui_t4_op4").toLowerCase();
									break;
								default:
									break;
								}
								break;
							case 5:
								tipoTaq += " - "+this.bundle.getString("eef_taqui_t5").toLowerCase();
								taquis += " "+this.bundle.getString("eef_taqui_t5").toLowerCase();
								switch (ta.getIdn2()) {
								case 1:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t5_op1").toLowerCase();
									taquis += " "+this.bundle.getString("eef_taqui_t5_op1").toLowerCase();
									break;
								case 2:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t5_op2").toLowerCase();
									taquis += " "+this.bundle.getString("eef_taqui_t5_op2").toLowerCase();
									break;
								case 3:
									tipoTaq += " "+this.bundle.getString("eef_taqui_t5_op3").toLowerCase();
									taquis += " "+this.bundle.getString("eef_taqui_t5_op3").toLowerCase();
									break;
								default:
									break;
								}
								break;
							case 6:
								tipoTaq += " - "+this.bundle.getString("eef_taqui_t6_2");
								taquis += " "+this.bundle.getString("eef_taqui_t6_2");
								break;
							case 7:
								taquis += " "+this.bundle.getString("eef_taqui_t7_2");
								switch (ta.getIdn2()) {
								case 1:
									taquis += " "+this.bundle.getString("eef_taqui_t7_op1").toLowerCase();
									break;
								case 2:
									taquis += " "+this.bundle.getString("eef_taqui_t7_op2").toLowerCase();
									break;
								default:
									break;
								}
								break;
							case 8:
								taquis += " "+this.bundle.getString("eef_taqui_t8");
								break;
							}
								
						}
					}
					//taquis += "\n\r";
					comtq = ta.getComentarios()!=null&&ta.getComentarios().length()>0?". "+ta.getComentarios()+". "+comtq:comtq+"";
					taquis += comtq+"\n\r";
					comtq= "";
				}
				root.addContent(new Element("taqui").setText(taquis));
				root.addContent(new Element("comentarios_taqui").setText(comtq));
			}else{
				root.addContent(new Element("taqui").setText(""));
			}
			
			root.addContent(new Element("hallazgos").setText(this.eef.getHallazgos()));
			
			// FRR - MEJORAS DE CONTROL DE NULL POINTER
			String diagnosticos = "";
			if(this.eef.getDiagnostico()!=null && !this.eef.getDiagnostico().equals(0)){
				diagnosticos = maedao.findByPrimaryKey(this.eef.getDiagnostico()).getValor()+". ";
				String tipodiag1 = null;
				if(this.eef.getTipoDiag1()!=null && this.eef.getTipoDiag1()>0){				
					if(this.eef.getTipoDiag1().equals(1)){
						diagnosticos+= this.bundle.getString("eef_tab_plantilla_diagn_tipo_op1");
						if(this.eef.getTipoDiag2()!=null && this.eef.getTipoDiag2()>0){
							if(this.eef.getTipoDiag2().equals(1))
								diagnosticos+= " "+this.bundle.getString("eef_tab_plantilla_diagn_tipo_op1_op1");
							else if(this.eef.getTipoDiag2().equals(2))
								diagnosticos+= " "+this.bundle.getString("eef_tab_plantilla_diagn_tipo_op1_op2");
						}
					}else if(this.eef.getTipoDiag1().equals(2)){
						diagnosticos+= this.bundle.getString("eef_tab_plantilla_diagn_tipo_op2");
					}else if(this.eef.getTipoDiag1().equals(3)){
						diagnosticos+= this.bundle.getString("eef_tab_plantilla_diagn_tipo_op3");
						if(this.eef.getTipoDiag2()!=null && this.eef.getTipoDiag2()>0){
							if(this.eef.getTipoDiag2().equals(1))
								diagnosticos+= " "+this.bundle.getString("eef_tab_plantilla_diagn_tipo_op3_op1");
							else if(this.eef.getTipoDiag2().equals(2))
								diagnosticos+= " "+this.bundle.getString("eef_tab_plantilla_diagn_tipo_op3_op2");
							else if(this.eef.getTipoDiag2().equals(3))
								diagnosticos+= " "+this.bundle.getString("eef_tab_plantilla_diagn_tipo_op3_op3");
						}
					}	
				}
				
				if(diagnosticos.equals("TAQUICARDIA PAROXÍSTICA SUPRAVENTRICULAR") || 
						diagnosticos.equals("TAQUICARDIA SUPRAVENTRICULAR INCESANTE") ||
						diagnosticos.equals("SÍNDROME DE WPW") /*||
						diagnosticos.equals("TAQUIARRITMIA AURICULAR")*/){
					if(tipoTaq != null && tipoTaq.length()>0)
						diagnosticos += tipoTaq.substring(2);
				}
				//root.addContent(new Element("diagnosticos").setText(diagnosticos.charAt(0) + diagnosticos.substring(1).toLowerCase()));
				root.addContent(new Element("diagnosticos").setText(diagnosticos));
			}else
				root.addContent(new Element("diagnosticos").setText(null));
			
			/*String diagnosticos = maedao.findByPrimaryKey(this.eef.getDiagnostico()).getValor();
			if(diagnosticos.equals("TAQUICARDIA PAROXÍSTICA SUPRAVENTRICULAR") || 
					diagnosticos.equals("TAQUICARDIA SUPRAVENTRICULAR INCESANTE") ||
					diagnosticos.equals("SÍNDROME DE WPW") ||
					diagnosticos.equals("TAQUIARRITMIA AURICULAR")){
				if(tipoTaq != null && tipoTaq.length()>0)
					diagnosticos += tipoTaq.substring(2);
			}
			
			root.addContent(new Element("diagnosticos").setText(diagnosticos.charAt(0) + diagnosticos.substring(1).toLowerCase()));*/
			
	/******DATOS DE ABLACION REALIZADA********/
			String comabl="";
			if(this.eef.getAblacion() == 2){
				String ablaciones = "";
				for(int i=0;i< this.eef.getAblaciones().size();i++){
					ArrEstudioAblacion abl = this.eef.getAblaciones().get(i);				
					ablaciones += this.bundle.getString("eef_reporte_msg_abl_acceso")+" ";
					if(abl.getLista().size()>0){
						int j = 0;
						for(AbordajeAblaciones apl:abl.getLista()){
							if(j>0/*ablaciones.length()>16*/)
								ablaciones += ", "+obtenerViaAccesoAbl(apl.getIdvia());
								//ablaciones += ", "+maestrasdao.findByPrimaryKey(apl.getIdvia()).getValor().toLowerCase();
							else
								ablaciones +=obtenerViaAccesoAbl(apl.getIdvia());
								//ablaciones += maestrasdao.findByPrimaryKey(apl.getIdvia()).getValor().toLowerCase();
							j++;
						}
					}else
						ablaciones+=" "+this.bundle.getString("no_especificado").toLowerCase()+" ";
					/*switch (abl.getIdabordaje()) {
					case 1:
						ablaciones += "venoso femoral";
						break;
					case 2:
						ablaciones += "venoso braquial";
						break;
					case 3:
						ablaciones += "venoso yugular/subclavia";
						break;
					case 4:
						ablaciones += "arterial femoral";
						break;
					case 5:
						ablaciones += "foramen ovale";
						break;
					case 6:
						ablaciones += "transeptal";
						break;
					case 7:
						ablaciones += "epicárdico";
						break;
					}*/
					ablaciones += " "+this.bundle.getString("eef_reporte_msg_abl_accion")+" ";
					String exito = "";
					switch (abl.getIdnodo()) {
					case 1:
						ablaciones += this.bundle.getString("eef_abl_sust_1").toLowerCase();
						switch (this.eef.getAblaciondto().getResultadodto().getIdtin()){
						case 1:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_1_1").toLowerCase();
							break;
						case 2:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_1_2");
							break;
						case 3:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_1_3").toLowerCase();
							break;
						default:
							exito = "";
						}
						break;
					case 2:
						ablaciones += this.bundle.getString("eef_abl_sust_2");
						switch (this.eef.getAblaciondto().getResultadodto().getIdtin()){
						case 1:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_2_1");
							break;
						case 2:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_2_2");
							break;
						default:
							exito = "";
						}
						break;
					case 3:
						ablaciones += this.bundle.getString("eef_abl_sust_3");
						switch (this.eef.getAblaciondto().getResultadodto().getIdtin()){
						case 1:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_3_1").toLowerCase();
							break;
						case 2:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_3_2");
							break;
						default:
							exito = "";
						}
						break;
					case 4:
						ablaciones += this.bundle.getString("eef_abl_sust_4");
						switch (this.eef.getAblaciondto().getResultadodto().getIdtin()){
						case 1:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_4_1");
							break;
						default:
							exito = "";
						}
						break;
					case 5:
						ablaciones += this.bundle.getString("eef_abl_sust_5");
						switch (this.eef.getAblaciondto().getResultadodto().getIdtin()){
						case 1:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_5_1");
							break;
						case 2:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_5_2");
							break;
						case 3: 
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_5_3");
							break;
						case 4:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_5_4");
							break;
						default:
							exito = "";
						}
						break;
					case 6:
						ablaciones += this.bundle.getString("eef_abl_sust_6");
						switch (this.eef.getAblaciondto().getResultadodto().getIdtin()){
						case 1:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_6_1");
							break;
						case 2:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_6_2");
							break;
						default:
							exito = "";
						}
						break;
					case 7:
						ablaciones += this.bundle.getString("eef_abl_sust_7");
						switch (this.eef.getAblaciondto().getResultadodto().getIdtin()){
						case 1:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_7_1");
							break;
						case 2:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_7_2");
							break;
						default:
							exito = "";
						}
						break;
					case 8:
						ablaciones += this.bundle.getString("eef_abl_sust_8_1");
						switch (this.eef.getAblaciondto().getResultadodto().getIdtin()){
						case 1:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_8_1").toLowerCase();
							break;
						default:
							exito = "";
						}
						break;
					case 9:
						ablaciones += this.bundle.getString("eef_abl_sust_9");
						switch (this.eef.getAblaciondto().getResultadodto().getIdtin()){
						case 1:
							exito = " "+this.bundle.getString("eef_tab_abl_tab_res_op1_9_1");
							break;
						default:
							exito = "";
						}
						break;
					}
					//Integer res = this.eef.getAblaciondto().getResultadodto().getIdres();
					Integer res = abl.getResultadodto().getIdres();
					if(res != null && res > 0){ 
						ablaciones += " "+this.bundle.getString("eef_reporte_msg_abl_res")+" ";
						switch (res) {
						case 1:
							ablaciones += this.bundle.getString("eef_tab_abl_tab_res_op1").toLowerCase()+"" + exito;
							break;
						case 2:
							ablaciones += this.bundle.getString("eef_tab_abl_tab_res_op2").toLowerCase();
							break;
						case 3:
							ablaciones += this.bundle.getString("eef_tab_abl_tab_res_op3").toLowerCase();
							if(abl.getResultadodto().getIdparcial()!=null){
								switch (abl.getResultadodto().getIdparcial()/*this.eef.getAblaciondto().getResultadodto().getIdparcial()*/){
								case 1:
									ablaciones += " "+this.bundle.getString("eef_tab_abl_tab_res_op3_op1");
									break;
								case 2:
									ablaciones += " "+this.bundle.getString("eef_tab_abl_tab_res_op3_op2");
									break;
								case 3:
									ablaciones += " "+this.bundle.getString("eef_tab_abl_tab_res_op3_op3").toLowerCase();
									break;
								case 4:
									ablaciones += " "+this.bundle.getString("eef_tab_abl_tab_res_op3_op4").toLowerCase(); 
									break;
								}
							}							
							break;
						}
					}
					if(abl.getIdenergia() != null && abl.getIdenergia() > 0){
						ablaciones += ", "+this.bundle.getString("eef_reporte_msg_abl_apl_energ")+" ";
						switch (abl.getIdenergia()) {
						case 1:
							ablaciones += this.bundle.getString("eef_reporte_msg_abl_apl_energ_rad");
							break;
						case 2:
							ablaciones += this.bundle.getString("eef_reporte_msg_abl_apl_energ_crio");
							break;
						case 3:
							ablaciones += this.bundle.getString("eef_reporte_msg_abl_apl_energ_radcrio");
							break;
						}
						ablaciones += " "+this.bundle.getString("eef_reporte_msg_abl_apl_durante")+" ";
						switch (abl.getIdenergia()) {
						case 1:
							ablaciones += abl.getTradio() + "s.";
							break;
						case 2:
							ablaciones += abl.getTcrio() + "s.";
							break;
						case 3:
							ablaciones += abl.getTradio() + "s y " + abl.getTcrio() + "s.";
							break;
						}
					}
					
					if(abl.getListacomplicacion()!=null && abl.getListacomplicacion().size()>0 
							/*&& abl.getListacomplicacion().get(0).getIdprocedimiento() != null && abl.getListacomplicacion().get(0).getIdprocedimiento() > 0
							&& abl.getListacomplicacion().get(0).getIdcomplicacion() != null && abl.getListacomplicacion().get(0).getIdcomplicacion() > 0
							this.eef.getAblaciondto().getComplicacion().getIdprocedimiento() != null && this.eef.getAblaciondto().getComplicacion().getIdprocedimiento() > 0
							&& this.eef.getAblaciondto().getComplicacion().getIdcomplicacion() != null && this.eef.getAblaciondto().getComplicacion().getIdcomplicacion() > 0 */){
						for(ArrAblacionComplica comp:abl.getListacomplicacion()){
							Complicaciones itemComp = cdao.findByPrimaryKey(comp.getIdcomplicacion());
							if(itemComp!=null){
								if(comp.getIdprocedimiento()!=null && comp.getIdprocedimiento()>0){
									compAblacion += this.bundle.getString("eef_tab_abl_tac_compl_relacion_con")+" ";
									switch (comp.getIdprocedimiento()) {
										case 1:
											compAblacion += this.bundle.getString("eef_tab_abl_tac_compl_op1").toLowerCase();
											if(comp.getIdlugar()!=null && comp.getIdlugar()>0)
												switch(comp.getIdlugar()){						
													case 1:
														compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op1").toLowerCase();
														break;
													case 2:
														compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op2").toLowerCase();
														break;
													case 3:
														compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op3").toLowerCase();
														break;
													case 4:
														compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op4").toLowerCase();
														break;
													case 5:
														compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op5").toLowerCase();
														break;
												}
											break;
										case 2:
											compAblacion += this.bundle.getString("eef_tab_abl_tac_compl_op2").toLowerCase();
											break;
									}
								}else
									compAblacion +=this.bundle.getString("eef_reporte_msg_abl_compl");
								// tipo de complicacion
								compAblacion += " "+itemComp.getNombre().toUpperCase();
								if(comp.getIdmuerte()!=null && comp.getIdmuerte() == 1)
									compAblacion += ", "+this.bundle.getString("eef_reporte_msg_abl_compl_muerte");
								compAblacion += ". ";
							}
						}
						
						
							/*compAblacion += this.bundle.getString("eef_tab_abl_tac_compl_relacion_con");
							switch (this.eef.getAblaciondto().getComplicacion().getIdprocedimiento()) {
							case 1:
								compAblacion += this.bundle.getString("eef_tab_abl_tac_compl_op1").toLowerCase();
								if(this.eef.getAblaciondto().getComplicacion().getIdlugar() != null)
								switch(this.eef.getAblaciondto().getComplicacion().getIdlugar()){						
								case 1:
									compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op1").toLowerCase();
									break;
								case 2:
									compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op2").toLowerCase();
									break;
								case 3:
									compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op3").toLowerCase();
									break;
								case 4:
									compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op4").toLowerCase();
									break;
								case 5:
									compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_lugar_op5").toLowerCase();
									break;
								}
								break;
							case 2:
								compAblacion += this.bundle.getString("eef_tab_abl_tac_compl_op2").toLowerCase();
								break;
							}
							compAblacion += " "+this.bundle.getString("eef_reporte_msg_abl_compl");
							switch (this.eef.getAblaciondto().getComplicacion().getIdcomplicacion()){
							case 1:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op1");
								break;
							case 2:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op2");
								break;
							case 3:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op3");
								break;
							case 4:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op1").toLowerCase();
								break;
							case 5:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op5").toLowerCase();
								break;
							case 6:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op6").toLowerCase();
								break;
							case 7:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op7");
								break;
							case 8:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op8");
								break;
							case 9:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op9");
								break;
							case 10:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op10");
								break;
							case 11:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op11");
								break;
							case 12:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_mayores_op12").toLowerCase();
								break;
							case 13:
								compAblacion += " " + this.eef.getAblaciondto().getComplicacion().getOtros();
								break;
							case 14:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_menores_op1").toLowerCase();
								break;
							case 15:
								compAblacion += " "+this.bundle.getString("eef_tab_abl_tac_compl_menores_op2").toLowerCase();
								break;
							}
							if(this.eef.getAblaciondto().getComplicacion().getIdmuerte()!=null && this.eef.getAblaciondto().getComplicacion().getIdmuerte() == 1)
								compAblacion += ", "+this.bundle.getString("eef_reporte_msg_abl_compl_muerte");
							compAblacion += ".";*/
							//ablaciones += compAblacion;
					}
					//ablaciones += "\n\r";
					comabl = abl.getComentarios()!=null&&abl.getComentarios().length()>0?". "+abl.getComentarios()+". "+comabl:comabl+"";
					ablaciones += comabl+"\n\r";
					comabl="";				
				}	
				root.addContent(new Element("ablacion").setText(ablaciones));
				root.addContent(new Element("comentarios_ablacion").setText(comabl));
			}else{
				root.addContent(new Element("ablacion").setText(""));
			}
			
	/******DATOS DE COMPLICACIONES********/
			if (this.eef.getComplicacionesb()) {
				String comp = "";
				if(this.eef.getComplicacionesdto().getListacompldiag().size()>1)
					comp += this.bundle.getString("eef_reporte_msg_compl_diag_en2")+" ";
				else if(this.eef.getComplicacionesdto().getListacompldiag().size()==1)
					comp += this.bundle.getString("eef_reporte_msg_compl_diag_en1")+": ";
				for(ComplicacionesPacientes cpac:this.eef.getComplicacionesdto().getListacompldiag()){
					Complicaciones itemComp = cdao.findByPrimaryKey(cpac.getComplicacion());	
					if(itemComp.getIdcomplicacion()==idCompBAV){
						comp += " "+itemComp.getNombre();
						if(cpac.getComplicacion1()!=null){
							switch(cpac.getComplicacion1()){						
							case 1:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op1_op1");
								break;
							case 2:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op1_op2");
								if(cpac.getComplicacion2()!=null && cpac.getComplicacion2() == 1)
									comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op1_op2_op1");
								break;
							}
						}
					}else if(itemComp.getIdcomplicacion()==idCompEMB){
						comp += " "+itemComp.getNombre().toLowerCase();
						if(cpac.getComplicacion1()!=null){
							switch(cpac.getComplicacion1()){						
							case 1:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op1");
								break;
							case 2:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op2");
								break;
							case 3:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op3");
								break;
							case 4:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op4");
								break;
							case 5:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op5");
								break;
							case 6:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op6").toLowerCase();
								break;
							case 7:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op7").toLowerCase();
								break;
							}
						}	
					}else if(itemComp.getIdcomplicacion()==idCompDERR){
						comp += " "+itemComp.getNombre();
						if(cpac.getComplicacion1()!=null){
							switch(cpac.getComplicacion1()){						
							case 1:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op3_op1").toLowerCase();
								break;
							case 2:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op3_op2").toLowerCase();
								if(cpac.getComplicacion2()!=null && cpac.getComplicacion2() == 1)
									comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op3_op2_op1");
								break;
							}
						}
					}else if(itemComp.getIdcomplicacion()==idCompTEP){
						comp += " "+itemComp.getNombre();
						if(cpac.getComplicacion1()!=null && cpac.getComplicacion1() == 1)
							comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op4_op1");
					}else if(itemComp.getIdcomplicacion()==idCompVAS){
						comp += " "+itemComp.getNombre().toLowerCase();
						if(cpac.getComplicacion1()!=null){
							switch(cpac.getComplicacion1()){						
							case 1:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op1");
								break;
							case 2:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op2");
								if(cpac.getComplicacion2()!=null && cpac.getComplicacion2() == 1)
									comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op2_op1");
								break;
							case 3:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op3").toLowerCase();
								break;
							case 4:
								comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op4").toLowerCase();
								if(cpac.getComplicacion2()!=null){
									switch(cpac.getComplicacion2()){						
									case 1:
										comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op4_op1");
										break;
									case 2:
										comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op4_op2");
										break;
									}
								}						
								break;
							}
						}		
					}else{
						comp += " "+itemComp.getNombre().toLowerCase();
						if(cpac.getComplicacionOtra()!=null)
							comp += " "+cpac.getComplicacionOtra();
					}
					comp +=", ";
				}
				comp = comp.substring(0,comp.length()-2);
				/*switch (this.eef.getComplicacionesdto().getIdprocedimiento()) {
				case 1:
					comp += this.bundle.getString("eef_tab_compdiag_tipo_op1");
					if(this.eef.getComplicacionesdto().getIdprocedimienton2()!=null){
						switch(this.eef.getComplicacionesdto().getIdprocedimienton2()){						
						case 1:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op1_op1");
							break;
						case 2:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op1_op2");
							if(this.eef.getComplicacionesdto().getIdprocedimienton3()!=null && this.eef.getComplicacionesdto().getIdprocedimienton3() == 1)
								comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op1_op2_op1");
							break;
						}
					}					
					break;
				case 2:
					comp += this.bundle.getString("eef_tab_compdiag_tipo_op2").toLowerCase();
					if(this.eef.getComplicacionesdto().getIdprocedimienton2()!=null){
						switch(this.eef.getComplicacionesdto().getIdprocedimienton2()){						
						case 1:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op1");
							break;
						case 2:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op2");
							break;
						case 3:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op3");
							break;
						case 4:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op4");
							break;
						case 5:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op5");
							break;
						case 6:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op6").toLowerCase();
							break;
						case 7:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op2_op7").toLowerCase();
							break;
						}
					}	
					break;
				case 3:
					comp += this.bundle.getString("eef_tab_compdiag_tipo_op3").toLowerCase();
					if(this.eef.getComplicacionesdto().getIdprocedimienton2()!=null){
						switch(this.eef.getComplicacionesdto().getIdprocedimienton2()){						
						case 1:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op3_op1").toLowerCase();
							break;
						case 2:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op3_op2").toLowerCase();
							if(this.eef.getComplicacionesdto().getIdprocedimienton3()!=null && this.eef.getComplicacionesdto().getIdprocedimienton3() == 1)
								comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op3_op2_op1");
							break;
						}
					}					
					break;
				case 4:
					comp += this.bundle.getString("eef_tab_compdiag_tipo_op4");
					if(this.eef.getComplicacionesdto().getIdprocedimienton2()!=null && this.eef.getComplicacionesdto().getIdprocedimienton2() == 1)
						comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op4_op1");
					break;
				case 5:
					comp += this.bundle.getString("eef_tab_compdiag_tipo_op5").toLowerCase();
					if(this.eef.getComplicacionesdto().getIdprocedimienton2()!=null){
						switch(this.eef.getComplicacionesdto().getIdprocedimienton2()){						
						case 1:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op1");
							break;
						case 2:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op2");
							if(this.eef.getComplicacionesdto().getIdprocedimienton3()!=null && this.eef.getComplicacionesdto().getIdprocedimienton3() == 1)
								comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op2_op1");
							break;
						case 3:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op3").toLowerCase();
							break;
						case 4:
							comp += " "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op4").toLowerCase();
							if(this.eef.getComplicacionesdto().getIdprocedimienton3()!=null){
								switch(this.eef.getComplicacionesdto().getIdprocedimienton3()){						
								case 1:
									comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op4_op1");
									break;
								case 2:
									comp += " - "+this.bundle.getString("eef_tab_compdiag_tipo_op5_op4_op2");
									break;
								}
							}						
							break;
						}
					}					
					break;
				case 6:
					comp += this.bundle.getString("eef_tab_compdiag_tipo_op6");
					break;
				case 7:
					comp += this.bundle.getString("eef_tab_compdiag_tipo_op7").toLowerCase();
					break;
				case 8:
					comp += this.bundle.getString("eef_tab_compdiag_tipo_op8").toLowerCase();
					break;
				default:
					comp = this.bundle.getString("eef_reporte_msg_compl_no");
					break;
				}*/
				if(this.eef.getComplicacionesdto().getIdprocedimienton4()!=null && this.eef.getComplicacionesdto().getIdprocedimienton4() == 1)
					comp += ", "+this.bundle.getString("eef_reporte_msg_abl_compl_muerte");				
				if(this.eef.getComplicacionesdto().getComentarios()!=null && !this.eef.getComplicacionesdto().getComentarios().equals(""))
					comp += ". "+this.eef.getComplicacionesdto().getComentarios();
				comp += ".";
				if(compAblacion.length() > 0)
					comp += "\n" + compAblacion;
				root.addContent(new Element("complicaciones").setText(comp));
			} else {
				String comp = this.bundle.getString("eef_reporte_msg_compl_no_2")+".";
				if(compAblacion.length() > 0)
					comp += "\n" + compAblacion;
				root.addContent(new Element("complicaciones").setText(comp));
			}

			String operadores = "";
			if(this.eef.getPoperador() != null)
				for(ArrEstudioPop op1 : this.eef.getPoperador())
					operadores += op1.getIdoperador() + "     ";
			if(this.eef.getSoperador() != null)
				for(ArrEstudioSop op2 : this.eef.getSoperador())
					operadores += op2.getIdoperador() + "     ";
			root.addContent(new Element("operador1").setText(operadores));
			//root.addContent(new Element("operador2").setText(this.eef.getSoperador() != null
				//	&& this.eef.getSoperador().size() > 0 ? this.eef.getSoperador().get(0).getIdoperador() : " "));
			
	/******DATOS DE PERIODOS REFRACTARIOS********/
			if(this.eef.getPeriodosb()){
				if(this.eef.getPeriodosdto().size()>0)
					root.addContent(new Element("hayp").setText("1"));
				else
					root.addContent(new Element("hayp").setText("0"));
				for(ArrEstudioPeriodo periodo : this.eef.getPeriodosdto()){
					Element per = new Element("periodo");
					if(periodo.getIdtipo()!=null && periodo.getIdtipo().intValue()>0)
						per.addContent(new Element("tipo").setText(maestrasdao.findByPrimaryKey(periodo.getIdtipo()).getValor()));
					per.addContent(new Element("tejido").setText(periodo.getIdtejido()));
					per.addContent(new Element("farmaco").setText(periodo.getIdfarmaco() != null && periodo.getIdfarmaco() > 0?maestrasdao.findByPrimaryKey(periodo.getIdfarmaco()).getValor():""));
					per.addContent(new Element("s1").setText(periodo.getIds1()));
					per.addContent(new Element("valor").setText(periodo.getRef()));
					root.addContent(per);
				}
				root.addContent(new Element("comentarios_pr").setText(this.eef.getComent_periodos()));
			}
			else
				root.addContent(new Element("hayp").setText("0"));
			//root.addContent(periodos);
			
			
			/******DATOS DE CATETERES********/
			String cats = "";String tipo="";String via="",localizacion="";
			ArrEstudioCatAplDao catapldao = new ArrEstudioCatAplDaoImpl();
			for(ArrEstudioCatUso c: this.eef.getListacats()){
				/*Element el = new Element("cateter");
				el.addContent(new Element("modelo").setText(c.getModelo()!=null&&c.getModelo().length()>0?c.getModelo():""));
				el.addContent(new Element("tipo").setText("Diagnóstico"));
				el.addContent(new Element("localizacion").setText(c.getIdlocalizacion()!=0?maestrasdao.findByPrimaryKey(c.getIdlocalizacion())
						.getValor().toLowerCase():""));
				el.addContent(new Element("via").setText(c.getIdvia()!=0?maestrasdao.findByPrimaryKey(c.getIdvia())
						.getValor().toLowerCase():""));
				root.addContent(el);*/
				if(c.getTipo()!=null && c.getTipo()==1){
					tipo = "DIAGNOSTICO";
					via = (c.getIdvia()!=null&&c.getIdvia()!=0?maestrasdao.findByPrimaryKey(c.getIdvia()).getValor().toLowerCase():this.bundle.getString("no_especificada"));
					localizacion = (c.getIdlocalizacion()!=null&&c.getIdlocalizacion()!=0?"de "+maestrasdao.findByPrimaryKey(c.getIdlocalizacion()).getValor().toLowerCase():" "+this.bundle.getString("no_especificada"));
					cats+="\n "+this.bundle.getString("eef_reporte_msg_cat_tipo_diag")+" ("+(c.getModelo()!=null&&c.getModelo().length()>0?c.getModelo()+")":this.bundle.getString("eef_reporte_msg_cat_noesp"))+" "+this.bundle.getString("eef_reporte_msg_cat_abord_1")+" "+via+" "+this.bundle.getString("eef_reporte_msg_cat_abord_2")+" "+localizacion+".";
				}					
				else if(c.getTipo()!=null && c.getTipo()==2){
					tipo ="ABLACION";
					ArrEstudioCatApl[] capl = catapldao.findWhereIdcatusoEquals(c.getIdcatuso());
					//via = obtenerViaAccesoAbl(catapldao.findWhereIdcatusoEquals(c.getIdcatuso())[0].getIdvia());
					if(capl!=null && capl.length>0)
						via = obtenerViaAccesoAbl(catapldao.findWhereIdcatusoEquals(c.getIdcatuso())[0].getIdvia());
					else
						via = this.bundle.getString("no_especificada");
					cats+="\n "+this.bundle.getString("eef_reporte_msg_cat_tipo_abl")+" ("+(c.getModelo()!=null&&c.getModelo().length()>0?c.getModelo()+")":this.bundle.getString("eef_reporte_msg_cat_noesp"))+")"+" "+this.bundle.getString("eef_reporte_msg_cat_abord_1")+" "+via+".";
				}
					
				//cats+="\n"+(c.getModelo()!=null&&c.getModelo().length()>0?c.getModelo():"MODELO NO ESPECIFICADO")+" ("+tipo+"). "+"Localizado en "+(c.getIdlocalizacion()!=null?maestrasdao.findByPrimaryKey(c.getIdlocalizacion()).getValor().toLowerCase():"no especificada ")+" mediante vía de acceso "+(c.getIdvia()!=null&&c.getIdvia()!=0?maestrasdao.findByPrimaryKey(c.getIdvia()).getValor().toLowerCase()+".":"no especificada.");
				//cats+="\n"+(c.getModelo()!=null&&c.getModelo().length()>0?c.getModelo():"MODELO NO ESPECIFICADO")+" ("+tipo+")";
			}
			// Ablacion
			/*ArrEstudioAblacionDao abldao = new ArrEstudioAblacionDaoImpl("");
			ArrEstudioAblacion[] abls = abldao.findWhereIdestudioEquals(this.eef.getIdestudio());
			for(ArrEstudioAblacion c:abls){
				Element el = new Element("cateter");
				el.addContent(new Element("modelo").setText(c.getCateter()!=null&&c.getCateter().length()>0?c.getCateter():""));
				el.addContent(new Element("tipo").setText("Ablación"));
				el.addContent(new Element("localizacion").setText(""));
				el.addContent(new Element("via").setText(obtenerViaAccesoAbl(c.getIdabordaje())));
				root.addContent(el);
				cats+="\n"+(c.getCateter()!=null&&c.getCateter().length()>0?c.getCateter():"MODELO NO ESPECIFICADO")+" (ABLACIÓN). "+"Localizado en no especificado mediante vía acceso: "+obtenerViaAccesoAbl(c.getIdabordaje());
						
			}*/
			root.addContent(new Element("cats").setText(cats.length()>0?cats:null));

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
			// Datos de enfermeria
			// Introductores
			String introductores="";
			if(this.enf!=null && this.enf.getIntroductores()!=null){
				for(ArrEnfIntroductores in:this.enf.getIntroductores())
					introductores = introductores + (in.getTipo()!=null?in.getTipo()+" ":"") +(in.getCalibre()!=null?in.getCalibre()+" Fr ":" calibre no especificado ")+(in.getNumero()!=null?"(x"+in.getNumero()+")":"")+", ";
			}
			root.addContent(new Element("Introductores").setText(!introductores.equals("")?"Introductores: "+introductores.substring(0, introductores.length()-2):""));
			
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
			logger.error("Error generando fichero XML para informe - Reporte EEF. Motivo: "+e.getMessage(),e);
		}
	}
	private String obtenerViaAccesoAbl(Integer i){
		 String via;
	     if(i==null)
	    	 return "no especificada";
	     else
			 switch (i) {
		            case 1:  via = this.bundle.getString("eef_tab_abl_tab_abl_cats_abordaje_via_op1").toLowerCase();
		                     break;
		            case 2:  via = this.bundle.getString("eef_tab_abl_tab_abl_cats_abordaje_via_op2").toLowerCase();
		                     break;
		            case 3:  via = this.bundle.getString("eef_tab_abl_tab_abl_cats_abordaje_via_op3").toLowerCase();
		                     break;
		            case 4:  via = this.bundle.getString("eef_tab_abl_tab_abl_cats_abordaje_via_op4").toLowerCase();
		                     break;
		            case 5:  via = this.bundle.getString("eef_tab_abl_tab_abl_cats_abordaje_via_op5").toLowerCase();
		                     break;
		            case 6:  via = this.bundle.getString("eef_tab_abl_tab_abl_cats_abordaje_via_op6").toLowerCase();
		                     break;
		            case 7:  via = this.bundle.getString("eef_tab_abl_tab_abl_cats_abordaje_via_op7").toLowerCase();
		                     break;
		            default: via = this.bundle.getString("no_especificada").toLowerCase();
		                     break;
		        }
	     return via;
	}
	
	private void obtenerDatosComplDiag(){
		try{
			ComplicacionesDao cdao = new ComplicacionesDaoImpl("consulta");
			Complicaciones[] lista = cdao.findWhereAmbitoEquals(2);
			for(Complicaciones item:lista){
				if(item.getNombre().equals("BLOQUEO AV"))
					idCompBAV = item.getIdcomplicacion();
				else if(item.getNombre().equals("EMBOLISMO"))
					idCompEMB = item.getIdcomplicacion();
				else if(item.getNombre().equals("DERRAME PERICÁRDICO"))
					idCompDERR = item.getIdcomplicacion();
				else if(item.getNombre().equals("TEP"))
					idCompTEP = item.getIdcomplicacion();
				else if(item.getNombre().equals("VASCULARES"))
					idCompVAS = item.getIdcomplicacion();
			}
		}catch(Exception e1){
			
		}
	}
}

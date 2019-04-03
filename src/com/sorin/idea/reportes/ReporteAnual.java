package com.sorin.idea.reportes;


import java.io.FileOutputStream;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dto.ArrAnual;
import com.sorin.idea.dto.ArrAnualSubstratos;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrEnf;
import com.sorin.idea.dto.ArrEnfIntroductores;
import com.sorin.idea.dto.ArrEstudioCateter;
import com.sorin.idea.dto.ArrTestFle;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;

public class ReporteAnual {
	private static Logger logger = Logger.getLogger(ReporteAnual.class);
	ArrAnual anual = new ArrAnual();
	public String pathFichero;
	private ResourceBundle bundle;

	public ReporteAnual(String path, ArrAnual anual, ResourceBundle bundle) {
		pathFichero = path;
		this.anual = anual;
		this.bundle = bundle;
	}

	public void GeneraArchivoPlanilla() {
		ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
		Element root = new Element("Anual");

		try {
			Element titulo = new Element("titulo");
			titulo.addContent(new Element("anio").setText(anual.getAnio().toString()));
			root.addContent(titulo);
			
			Element hosp = new Element("hosp");
			hosp.addContent(new Element("anio").setText(anual.getAnio().toString()));
			hosp.addContent(new Element("hospital").setText(anual.getCentro().getHospital()));
			hosp.addContent(new Element("codcentro").setText(anual.getCentro().getCodcentro()));
			hosp.addContent(new Element("direccion").setText(anual.getCentro().getDireccion()));
			hosp.addContent(new Element("provincia").setText(anual.getCentro().getProvincia()));
			hosp.addContent(new Element("cp").setText(anual.getCentro().getCp()));
			hosp.addContent(new Element("comunidad").setText(anual.getCentro().getComunidad()));
			hosp.addContent(new Element("telefono").setText(anual.getCentro().getTelefono()));
			hosp.addContent(new Element("extension").setText(anual.getCentro().getExt()));
			hosp.addContent(new Element("fax").setText(anual.getCentro().getFax()));
			hosp.addContent(new Element("responsable").setText(anual.getCentro().getResponsable()));
			hosp.addContent(new Element("movil").setText(anual.getCentro().getTelcontacto()));
			hosp.addContent(new Element("email").setText(anual.getCentro().getEmailcontacto()));
			
			String tipo_hosp = "";
			switch (anual.getCentro().getIdtipohospi1()) {
			case 1:
				tipo_hosp = this.bundle.getString("abl_anual_tab_datos_nivel_hosp_1");
				break;
			case 2:
				tipo_hosp = this.bundle.getString("abl_anual_tab_datos_nivel_hosp_2");
				break;
			case 3:
				tipo_hosp = this.bundle.getString("abl_anual_tab_datos_nivel_hosp_3");
				break;
			case 4:
				tipo_hosp = this.bundle.getString("abl_anual_tab_datos_nivel_hosp_4");
				break;
			case 5:
				tipo_hosp = this.bundle.getString("abl_anual_tab_datos_nivel_hosp_5");
				break;
			default:
				break;
			}
			switch (anual.getCentro().getIdtipohospi2()) {
			case 1:
				tipo_hosp = " "+this.bundle.getString("abl_anual_tab_datos_publ").toLowerCase();
				break;
			case 2:
				tipo_hosp = " "+this.bundle.getString("abl_anual_tab_datos_priv").toLowerCase();
				break;
			default:
				break;
			}
			hosp.addContent(new Element("tipohosp").setText(tipo_hosp));
			
			String servicio = "";
			switch (anual.getCentro().getIdservicio()) {
			case 1:
				servicio = this.bundle.getString("abl_anual_tab_datos_serv_cardio");
				break;
			case 2:
				servicio = this.bundle.getString("abl_anual_tab_datos_serv_intens");
				break;
			case 3:
				servicio = this.bundle.getString("abl_anual_tab_datos_serv_otro");
				break;
			default:
				break;
			}
			hosp.addContent(new Element("servicio").setText(servicio));
			
			if(this.anual.getCentro().getIdcirugia() == 0)
				hosp.addContent(new Element("cirugia").setText(this.bundle.getString("abl_anual_no")));
			else
				hosp.addContent(new Element("cirugia").setText(this.bundle.getString("abl_anual_si")));
			
			hosp.addContent(new Element("plantilla").setText(anual.getLab().getPlantilla()));
			hosp.addContent(new Element("plantilla2").setText(anual.getLab().getPlantillatc()));
			hosp.addContent(new Element("becarios").setText(anual.getLab().getBecarios()));
			hosp.addContent(new Element("mir").setText(anual.getLab().getMir()));
			hosp.addContent(new Element("ats").setText(anual.getLab().getAts()));
			hosp.addContent(new Element("atr").setText(anual.getLab().getAtr()));
			root.addContent(hosp);
			
			Element lab = new Element("lab");
			lab.addContent(new Element("anio").setText(anual.getAnio().toString()));
			lab.addContent(new Element("convencional").setText(anual.getLab().getSalac()));
			lab.addContent(new Element("digital").setText(anual.getLab().getSalad()));
			
			if(this.anual.getLab().getIdportatil() == 0)
				lab.addContent(new Element("portatil").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("portatil").setText(this.bundle.getString("abl_anual_si")));
			
			if(this.anual.getLab().getIdexclusiva() == 0)
				lab.addContent(new Element("exclusiva").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("exclusiva").setText(this.bundle.getString("abl_anual_si")));
			lab.addContent(new Element("salas").setText(anual.getLab().getExclusivas()));
			lab.addContent(new Element("dias").setText(anual.getLab().getDias()));
			if(this.anual.getLab().getIdmp() == 0)
				lab.addContent(new Element("mp").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("mp").setText(this.bundle.getString("abl_anual_si")));
			if(this.anual.getLab().getIddai() == 0)
				lab.addContent(new Element("dai").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("dai").setText(this.bundle.getString("abl_anual_si")));
			if(this.anual.getLab().getIdcvexterna() == 0)
				lab.addContent(new Element("cvext").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("cvext").setText(this.bundle.getString("abl_anual_si")));
			if(this.anual.getLab().getIdcvinterna() == 0)
				lab.addContent(new Element("cvint").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("cvint").setText(this.bundle.getString("abl_anual_si")));
			lab.addContent(new Element("otrosproc").setText(anual.getLab().getProcedimientos()));
			if(this.anual.getLab().getIdpoligrafo() == 0)
				lab.addContent(new Element("poligrafo").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("poligrafo").setText(this.bundle.getString("abl_anual_si")));
			lab.addContent(new Element("marca").setText(anual.getLab().getPoligrafo()));
			
			lab.addContent(new Element("comentarios").setText(anual.getTec().getComentarios()));
			
			if(this.anual.getTec().getIdeco() == 0)
				lab.addContent(new Element("ecografia").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("ecografia").setText(this.bundle.getString("abl_anual_si")));
			if(this.anual.getTec().getIdcrio() == 0)
				lab.addContent(new Element("crioablacion").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("crioablacion").setText(this.bundle.getString("abl_anual_si")));
			if(this.anual.getTec().getIdus() == 0)
				lab.addContent(new Element("ablacionus").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("ablacionus").setText(this.bundle.getString("abl_anual_si")));
			if(this.anual.getTec().getIdremota() == 0)
				lab.addContent(new Element("sistema").setText(this.bundle.getString("abl_anual_no")));
			else
				lab.addContent(new Element("sistema").setText(this.bundle.getString("abl_anual_si")));
			
			lab.addContent(new Element("otros").setText(anual.getTec().getTecnicas()));
			
			if(this.anual.getTec().getCartob())
				lab.addContent(new Element("carto").setText("1"));
			else
				lab.addContent(new Element("carto").setText("0"));
			if(this.anual.getTec().getNavxb())
				lab.addContent(new Element("navx").setText("1"));
			else
				lab.addContent(new Element("navx").setText("0"));
			if(this.anual.getTec().getLocalisab())
				lab.addContent(new Element("localisa").setText("1"));
			else
				lab.addContent(new Element("localisa").setText("0"));
			if(this.anual.getTec().getRpmb())
				lab.addContent(new Element("rpm").setText("1"));
			else
				lab.addContent(new Element("rpm").setText("0"));
			if(this.anual.getTec().getNogab())
				lab.addContent(new Element("noga").setText("1"));
			else
				lab.addContent(new Element("noga").setText("0"));
			if(this.anual.getTec().getOtrosb())
				lab.addContent(new Element("otrosnav").setText("1"));
			else
				lab.addContent(new Element("otrosnav").setText("0"));
			if(this.anual.getTec().getIctb())
				lab.addContent(new Element("ict").setText("1"));
			else
				lab.addContent(new Element("ict").setText("0"));
			if(this.anual.getTec().getTab())
				lab.addContent(new Element("tafocal").setText("1"));
			else
				lab.addContent(new Element("tafocal").setText("0"));
			if(this.anual.getTec().getFmb())
				lab.addContent(new Element("flutter").setText("1"));
			else
				lab.addContent(new Element("flutter").setText("0"));
			if(this.anual.getTec().getFab())
				lab.addContent(new Element("fa").setText("1"));
			else
				lab.addContent(new Element("fa").setText("0"));
			if(this.anual.getTec().getTvib())
				lab.addContent(new Element("tvi").setText("1"));
			else
				lab.addContent(new Element("tvi").setText("0"));
			if(this.anual.getTec().getTvcb())
				lab.addContent(new Element("tvc").setText("1"));
			else
				lab.addContent(new Element("tvc").setText("0"));
			root.addContent(lab);
			
			root.addContent(cargaab1());
			root.addContent(cargaab2());
			root.addContent(cargaab3());
			root.addContent(cargaab4());
			root.addContent(cargaab5());
			root.addContent(cargaab6());
			
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
			logger.error("Error generando fichero XML para informe - Reporte Ablación Anual. Motivo: "+e.getMessage(),e);
		}
	}

	private Element cargaab6() {
		Element titulo = new Element("ab6");
		ArrAnualSubstratos s = this.anual.getTvnoiam();
		titulo.addContent(new Element("anio").setText(this.anual.getAnio().toString()));
		titulo.addContent(new Element("pacientes").setText(s.getCampo1()));
		titulo.addContent(new Element("proc").setText(s.getCampo2()));
		titulo.addContent(new Element("rama").setText(s.getCampo22()));
		titulo.addContent(new Element("ramae").setText(s.getCampo23()));
		titulo.addContent(new Element("davd").setText(s.getCampo24()));
		titulo.addContent(new Element("davde").setText(s.getCampo25()));
		titulo.addContent(new Element("md").setText(s.getCampo26()));
		titulo.addContent(new Element("mde").setText(s.getCampo27()));
		titulo.addContent(new Element("cpv").setText(s.getCampo28()));
		titulo.addContent(new Element("cpve").setText(s.getCampo29()));
		titulo.addContent(new Element("tv").setText(s.getCampo30()));
		titulo.addContent(new Element("tve").setText(s.getCampo31()));
		titulo.addContent(new Element("c8mm").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri").setText(s.getCampo5()));
		titulo.addContent(new Element("crio").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc").setText(s.getCampo8()));
		titulo.addContent(new Element("bav").setText(s.getCampo9()));
		titulo.addContent(new Element("vascv").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca").setText(s.getCampo11()));
		titulo.addContent(new Element("derper").setText(s.getCampo12()));
		titulo.addContent(new Element("tc").setText(s.getCampo13()));
		titulo.addContent(new Element("embo").setText(s.getCampo14()));
		titulo.addContent(new Element("acv").setText(s.getCampo15()));
		titulo.addContent(new Element("ait").setText(s.getCampo16()));
		titulo.addContent(new Element("iam").setText(s.getCampo17()));
		titulo.addContent(new Element("icc").setText(s.getCampo18()));
		titulo.addContent(new Element("otrcomp").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios").setText(s.getCampo34()));
		return titulo;
	}

	private Element cargaab5() {
		Element titulo = new Element("ab5");
		ArrAnualSubstratos s = this.anual.getTvi();
		titulo.addContent(new Element("anio").setText(this.anual.getAnio().toString()));
		titulo.addContent(new Element("pacientes").setText(s.getCampo1()));
		titulo.addContent(new Element("proc").setText(s.getCampo2()));
		titulo.addContent(new Element("vd").setText(s.getCampo22()));
		titulo.addContent(new Element("vi").setText(s.getCampo23()));
		titulo.addContent(new Element("tvf").setText(s.getCampo24()));
		titulo.addContent(new Element("tvo").setText(s.getCampo25()));
		titulo.addContent(new Element("vde").setText(s.getCampo26()));
		titulo.addContent(new Element("vie").setText(s.getCampo27()));
		titulo.addContent(new Element("tvfe").setText(s.getCampo28()));
		titulo.addContent(new Element("tvoe").setText(s.getCampo29()));
		titulo.addContent(new Element("procexito").setText(s.getCampo3()));
		titulo.addContent(new Element("c8mm").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri").setText(s.getCampo5()));
		titulo.addContent(new Element("crio").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc").setText(s.getCampo8()));
		titulo.addContent(new Element("bav").setText(s.getCampo9()));
		titulo.addContent(new Element("vascv").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca").setText(s.getCampo11()));
		titulo.addContent(new Element("derper").setText(s.getCampo12()));
		titulo.addContent(new Element("tc").setText(s.getCampo13()));
		titulo.addContent(new Element("embo").setText(s.getCampo14()));
		titulo.addContent(new Element("acv").setText(s.getCampo15()));
		titulo.addContent(new Element("ait").setText(s.getCampo16()));
		titulo.addContent(new Element("iam").setText(s.getCampo17()));
		titulo.addContent(new Element("icc").setText(s.getCampo18()));
		titulo.addContent(new Element("otrcomp").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios").setText(s.getCampo34()));
		s = this.anual.getTviam();
		titulo.addContent(new Element("pacientes2").setText(s.getCampo1()));
		titulo.addContent(new Element("proc2").setText(s.getCampo2()));
		titulo.addContent(new Element("procexito2").setText(s.getCampo3()));
		titulo.addContent(new Element("absus").setText(s.getCampo22()));
		titulo.addContent(new Element("absusobj").setText(s.getCampo23()));
		titulo.addContent(new Element("abcon").setText(s.getCampo24()));
		titulo.addContent(new Element("abconobj").setText(s.getCampo25()));
		titulo.addContent(new Element("c8mm2").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri2").setText(s.getCampo5()));
		titulo.addContent(new Element("crio2").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc2").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc2").setText(s.getCampo8()));
		titulo.addContent(new Element("bav2").setText(s.getCampo9()));
		titulo.addContent(new Element("vascv2").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca2").setText(s.getCampo11()));
		titulo.addContent(new Element("derper2").setText(s.getCampo12()));
		titulo.addContent(new Element("tc2").setText(s.getCampo13()));
		titulo.addContent(new Element("embo2").setText(s.getCampo14()));
		titulo.addContent(new Element("acv2").setText(s.getCampo15()));
		titulo.addContent(new Element("ait2").setText(s.getCampo16()));
		titulo.addContent(new Element("iam2").setText(s.getCampo17()));
		titulo.addContent(new Element("icc2").setText(s.getCampo18()));
		titulo.addContent(new Element("otrcomp2").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes2").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc2").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios2").setText(s.getCampo34()));
		return titulo;
	}

	private Element cargaab4() {
		Element titulo = new Element("ab4");
		ArrAnualSubstratos s = this.anual.getFa();
		titulo.addContent(new Element("anio").setText(this.anual.getAnio().toString()));
		titulo.addContent(new Element("pacientes").setText(s.getCampo1()));
		titulo.addContent(new Element("proc").setText(s.getCampo2()));
		titulo.addContent(new Element("ad").setText(s.getCampo22()));
		titulo.addContent(new Element("ai").setText(s.getCampo23()));
		titulo.addContent(new Element("segvp").setText(s.getCampo24()));
		titulo.addContent(new Element("nseg").setText(s.getCampo26()));
		titulo.addContent(new Element("cirdes").setText(s.getCampo25()));
		titulo.addContent(new Element("ncir").setText(s.getCampo31()));
		titulo.addContent(new Element("cirred").setText(" "));
		titulo.addContent(new Element("nvcs").setText(s.getCampo32()));
		titulo.addContent(new Element("aisvps").setText(s.getCampo27()));
		titulo.addContent(new Element("otrprc").setText(s.getCampo33()));
		
		titulo.addContent(new Element("otrprcex").setText(s.getCampo28()));
		titulo.addContent(new Element("c8mm").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri").setText(s.getCampo5()));
		titulo.addContent(new Element("crio").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc").setText(s.getCampo8()));
		titulo.addContent(new Element("bav").setText(s.getCampo9()));
		titulo.addContent(new Element("vascv").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca").setText(s.getCampo11()));
		titulo.addContent(new Element("derper").setText(s.getCampo12()));
		titulo.addContent(new Element("tc").setText(s.getCampo13()));
		titulo.addContent(new Element("embo").setText(s.getCampo14()));
		titulo.addContent(new Element("acv").setText(s.getCampo15()));
		titulo.addContent(new Element("ait").setText(s.getCampo16()));
		titulo.addContent(new Element("iam").setText(s.getCampo17()));
		titulo.addContent(new Element("icc").setText(s.getCampo18()));
		titulo.addContent(new Element("estenosis").setText(s.getCampo29()));
		titulo.addContent(new Element("fistula").setText(s.getCampo30()));
		titulo.addContent(new Element("otrcomp").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios").setText(s.getCampo34()));
		return titulo;
	}

	private Element cargaab3() {
		Element titulo = new Element("ab3");
		ArrAnualSubstratos s = this.anual.getIct();
		titulo.addContent(new Element("anio").setText(this.anual.getAnio().toString()));
		titulo.addContent(new Element("pacientes").setText(s.getCampo1()));
		titulo.addContent(new Element("proc").setText(s.getCampo2()));
		titulo.addContent(new Element("procexito").setText(s.getCampo3()));
		titulo.addContent(new Element("c8mm").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri").setText(s.getCampo5()));
		titulo.addContent(new Element("crio").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc").setText(s.getCampo8()));
		titulo.addContent(new Element("bav").setText(s.getCampo9()));
		titulo.addContent(new Element("vascv").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca").setText(s.getCampo11()));
		titulo.addContent(new Element("derper").setText(s.getCampo12()));
		titulo.addContent(new Element("tc").setText(s.getCampo13()));
		titulo.addContent(new Element("embo").setText(s.getCampo14()));
		titulo.addContent(new Element("acv").setText(s.getCampo15()));
		titulo.addContent(new Element("ait").setText(s.getCampo16()));
		titulo.addContent(new Element("iam").setText(s.getCampo17()));
		titulo.addContent(new Element("icc").setText(s.getCampo18()));
		titulo.addContent(new Element("otrcomp").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios").setText(s.getCampo34()));
		s = this.anual.getFta();
		titulo.addContent(new Element("pacientes2").setText(s.getCampo1()));
		titulo.addContent(new Element("proc2").setText(s.getCampo2()));
		titulo.addContent(new Element("procexito2").setText(s.getCampo3()));
		titulo.addContent(new Element("ad").setText(s.getCampo22()));
		titulo.addContent(new Element("ai").setText(s.getCampo23()));
		titulo.addContent(new Element("ade").setText(s.getCampo24()));
		titulo.addContent(new Element("aie").setText(s.getCampo25()));
		titulo.addContent(new Element("c8mm2").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri2").setText(s.getCampo5()));
		titulo.addContent(new Element("crio2").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc2").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc2").setText(s.getCampo8()));
		titulo.addContent(new Element("bav2").setText(s.getCampo9()));
		titulo.addContent(new Element("vascv2").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca2").setText(s.getCampo11()));
		titulo.addContent(new Element("derper2").setText(s.getCampo12()));
		titulo.addContent(new Element("tc2").setText(s.getCampo13()));
		titulo.addContent(new Element("embo2").setText(s.getCampo14()));
		titulo.addContent(new Element("acv2").setText(s.getCampo15()));
		titulo.addContent(new Element("ait2").setText(s.getCampo16()));
		titulo.addContent(new Element("iam2").setText(s.getCampo17()));
		titulo.addContent(new Element("icc2").setText(s.getCampo18()));
		titulo.addContent(new Element("otrcomp2").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes2").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc2").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios2").setText(s.getCampo34()));
		return titulo;
	}

	private Element cargaab2() {
		Element titulo = new Element("ab2");
		ArrAnualSubstratos s = this.anual.getCav();
		titulo.addContent(new Element("anio").setText(this.anual.getAnio().toString()));
		titulo.addContent(new Element("pacientes").setText(s.getCampo1()));
		titulo.addContent(new Element("proc").setText(s.getCampo2()));
		titulo.addContent(new Element("procexito").setText(s.getCampo3()));
		titulo.addContent(new Element("c8mm").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri").setText(s.getCampo5()));
		titulo.addContent(new Element("crio").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc").setText(s.getCampo8()));
		titulo.addContent(new Element("vascv").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca").setText(s.getCampo11()));
		titulo.addContent(new Element("derper").setText(s.getCampo12()));
		titulo.addContent(new Element("tc").setText(s.getCampo13()));
		titulo.addContent(new Element("embo").setText(s.getCampo14()));
		titulo.addContent(new Element("acv").setText(s.getCampo15()));
		titulo.addContent(new Element("ait").setText(s.getCampo16()));
		titulo.addContent(new Element("iam").setText(s.getCampo17()));
		titulo.addContent(new Element("icc").setText(s.getCampo18()));
		titulo.addContent(new Element("otrcomp").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios").setText(s.getCampo34()));
		s = this.anual.getTaf();
		titulo.addContent(new Element("pacientes2").setText(s.getCampo1()));
		titulo.addContent(new Element("proc2").setText(s.getCampo2()));
		titulo.addContent(new Element("procexito2").setText(s.getCampo3()));
		titulo.addContent(new Element("ad").setText(s.getCampo22()));
		titulo.addContent(new Element("ai").setText(s.getCampo23()));
		titulo.addContent(new Element("ade").setText(s.getCampo24()));
		titulo.addContent(new Element("aie").setText(s.getCampo25()));
		titulo.addContent(new Element("c8mm2").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri2").setText(s.getCampo5()));
		titulo.addContent(new Element("crio2").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc2").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc2").setText(s.getCampo8()));
		titulo.addContent(new Element("bav2").setText(s.getCampo9()));
		titulo.addContent(new Element("vascv2").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca2").setText(s.getCampo11()));
		titulo.addContent(new Element("derper2").setText(s.getCampo12()));
		titulo.addContent(new Element("tc2").setText(s.getCampo13()));
		titulo.addContent(new Element("embo2").setText(s.getCampo14()));
		titulo.addContent(new Element("acv2").setText(s.getCampo15()));
		titulo.addContent(new Element("ait2").setText(s.getCampo16()));
		titulo.addContent(new Element("iam2").setText(s.getCampo17()));
		titulo.addContent(new Element("icc2").setText(s.getCampo18()));
		titulo.addContent(new Element("otrcomp2").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes2").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc2").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios2").setText(s.getCampo34()));
		return titulo;
	}

	private Element cargaab1() {
		Element titulo = new Element("ab1");
		ArrAnualSubstratos s = this.anual.getTin();
		titulo.addContent(new Element("anio").setText(this.anual.getAnio().toString()));
		titulo.addContent(new Element("pacientes").setText(s.getCampo1()));
		titulo.addContent(new Element("proc").setText(s.getCampo2()));
		titulo.addContent(new Element("procexito").setText(s.getCampo3()));
		titulo.addContent(new Element("c8mm").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri").setText(s.getCampo5()));
		titulo.addContent(new Element("crio").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc").setText(s.getCampo8()));
		titulo.addContent(new Element("bav").setText(s.getCampo9()));
		titulo.addContent(new Element("vascv").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca").setText(s.getCampo11()));
		titulo.addContent(new Element("derper").setText(s.getCampo12()));
		titulo.addContent(new Element("tc").setText(s.getCampo13()));
		titulo.addContent(new Element("embo").setText(s.getCampo14()));
		titulo.addContent(new Element("acv").setText(s.getCampo15()));
		titulo.addContent(new Element("ait").setText(s.getCampo16()));
		titulo.addContent(new Element("iam").setText(s.getCampo17()));
		titulo.addContent(new Element("icc").setText(s.getCampo18()));
		titulo.addContent(new Element("otrcomp").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios").setText(s.getCampo34()));
		s = this.anual.getVacc();
		titulo.addContent(new Element("pacientes2").setText(s.getCampo1()));
		titulo.addContent(new Element("proc2").setText(s.getCampo2()));
		titulo.addContent(new Element("procexito2").setText(s.getCampo3()));
		titulo.addContent(new Element("vd").setText(s.getCampo22()));
		titulo.addContent(new Element("vi").setText(s.getCampo23()));
		titulo.addContent(new Element("vs").setText(s.getCampo24()));
		titulo.addContent(new Element("vp").setText(s.getCampo25()));
		titulo.addContent(new Element("ved").setText(s.getCampo26()));
		titulo.addContent(new Element("vei").setText(s.getCampo27()));
		titulo.addContent(new Element("ves").setText(s.getCampo28()));
		titulo.addContent(new Element("vep").setText(s.getCampo29()));
		titulo.addContent(new Element("c8mm2").setText(s.getCampo4()));
		titulo.addContent(new Element("pirri2").setText(s.getCampo5()));
		titulo.addContent(new Element("crio2").setText(s.getCampo6()));
		titulo.addContent(new Element("otrproc2").setText(s.getCampo7()));
		titulo.addContent(new Element("otrprocdesc2").setText(s.getCampo8()));
		titulo.addContent(new Element("bav2").setText(s.getCampo9()));
		titulo.addContent(new Element("vascv2").setText(s.getCampo10()));
		titulo.addContent(new Element("vasca2").setText(s.getCampo11()));
		titulo.addContent(new Element("derper2").setText(s.getCampo12()));
		titulo.addContent(new Element("tc2").setText(s.getCampo13()));
		titulo.addContent(new Element("embo2").setText(s.getCampo14()));
		titulo.addContent(new Element("acv2").setText(s.getCampo15()));
		titulo.addContent(new Element("ait2").setText(s.getCampo16()));
		titulo.addContent(new Element("iam2").setText(s.getCampo17()));
		titulo.addContent(new Element("icc2").setText(s.getCampo18()));
		titulo.addContent(new Element("otrcomp2").setText(s.getCampo19()));
		titulo.addContent(new Element("muertes2").setText(s.getCampo20()));
		titulo.addContent(new Element("muertesc2").setText(s.getCampo21()));
		titulo.addContent(new Element("comentarios2").setText(s.getCampo34()));
		return titulo;
	}
}

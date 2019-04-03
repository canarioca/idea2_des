package com.sorin.idea.reportes;

import hvn.cm.dao.DAOException;

import java.io.File;
import java.io.FileOutputStream;
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
import com.sorin.idea.dto.ArrEnf;
import com.sorin.idea.dto.ArrEnfAct;
import com.sorin.idea.dto.ArrEnfIntroductores;
import com.sorin.idea.dto.ArrEstudioCateter;
import com.sorin.idea.dto.ArrTestFle;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.iu.ControlMaterial;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;

public class ReporteENF {
	private static Logger logger = Logger.getLogger(ReporteENF.class);
	PacienteAplDto paciente = new PacienteAplDto();
	ArrEnf enf = new ArrEnf();
	public String pathFichero;
	private String diagnostico;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	private ResourceBundle bundle;

	public ReporteENF(String path, ArrEnf enf, PacienteAplDto pacienteSelect, String diagnostico, ResourceBundle bundle) {
		pathFichero = path;
		paciente = pacienteSelect;
		this.enf = enf;
		this.diagnostico = diagnostico;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}

	public void GeneraArchivoPlanilla() {
		ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
		Element root = new Element("Listado");

		try {
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
			root.addContent(new Element("nestudio").setText(diagnostico.toLowerCase()));
			root.addContent(new Element("festudio").setText(enf.getFechastr()));
			root.addContent(new Element("fnaci").setText(paciente.getFechaNaciString()));
			root.addContent(new Element("Edad").setText(paciente.getEdad()));
			root.addContent(new Element("paciente").setText(paciente.getNombreCompleto()));
			root.addContent(new Element("nhc").setText(paciente.getNhc()));
			root.addContent(new Element("nuhsa").setText(paciente.getNuhsa()));
			

			root.addContent(new Element("peso").setText(enf.getPeso()!=null?enf.getPeso() + this.bundle.getString("eef_enf_peso_unidades")+".":""));
			root.addContent(new Element("talla").setText(enf.getTalla()!=null?enf.getTalla() + this.bundle.getString("eef_enf_talla_unidades_2")+".":""));
			root.addContent(new Element("imc").setText(enf.getImc()!=null?enf.getImc() + this.bundle.getString("eef_enf_imc_unidades")+".":""));
			root.addContent(new Element("tallegada").setText(enf.getTalleg1()!=null?enf.getTalleg1():""+enf.getTalleg2()!=null?"/"+enf.getTalleg2():"/"));
			root.addContent(new Element("fcllegada").setText(enf.getFclleg()!=null?enf.getFclleg():""));
			root.addContent(new Element("tafinal").setText(enf.getTafin1()!=null?enf.getTafin1():""+enf.getTafin2()!=null?"/"+enf.getTafin2():"/"));
			root.addContent(new Element("fcfinal").setText(enf.getFcfin()!=null?enf.getFcfin():""));
			root.addContent(new Element("tataqui").setText(enf.getTataq1()!=null?enf.getTataq1():""+enf.getTataq2()!=null?"/"+enf.getTataq2():"/"));
			root.addContent(new Element("fctaqui").setText(enf.getFctaq()!=null?enf.getFctaq():""));
			root.addContent(new Element("inr").setText(enf.getInr()!=null?enf.getInr():""));
			
			if (enf.getPlanta() != null && enf.getPlanta() == 1)
				root.addContent(new Element("viavenosa").setText(this.bundle.getString("eef_enf_calibre").toLowerCase()+" " + enf.getCalibre1() + ",  "+this.bundle.getString("eef_enf_miembro").toLowerCase() + enf.getMiembro()));
			else
				root.addContent(new Element("viavenosa").setText(null));
			if (enf.getPuncion() != null && enf.getPuncion() == 1)
				root.addContent(new Element("puncion").setText(enf.getMaterial()));
			else
				root.addContent(new Element("puncion").setText(null));
			
			root.addContent(new Element("vesical").setText(enf.getVesical()!=null?enf.getVesical():null));
			root.addContent(new Element("sondajes").setText(enf.getOtros()!=null?enf.getOtros():null));
			root.addContent(new Element("diuresis").setText(enf.getDiuresis()!=null?enf.getDiuresis():null));
			if(enf.getHemostasia()!=null){
				if(enf.getHemostasia() == 1)
					root.addContent(new Element("tipohemo").setText(this.bundle.getString("eef_enf_tipo_hem_manual")));
				else if(enf.getHemostasia() == 2)
					root.addContent(new Element("tipohemo").setText(this.bundle.getString("eef_enf_tipo_hem_disp")));
				else
					root.addContent(new Element("tipohemo").setText(null));
			}else
				root.addContent(new Element("tipohemo").setText(null));
			//root.addContent(new Element("tipohemo").setText(enf.getHemostasia()!=null && enf.getHemostasia() == 1? "Manual":"Dispositivo"));
			root.addContent(new Element("hemostasia").setText(enf.getHemostr()!=null?enf.getHemostr():null));			
			if(enf.getHemostasiav()!=null){
				if(enf.getHemostasiav() == 1)
					root.addContent(new Element("tipohemov").setText(this.bundle.getString("eef_enf_tipo_hem_manual")));
				else if(enf.getHemostasiav() == 2)
					root.addContent(new Element("tipohemov").setText(this.bundle.getString("eef_enf_tipo_hem_disp")));
				else
					root.addContent(new Element("tipohemov").setText(null));
			}else
				root.addContent(new Element("tipohemo").setText(null));
			//root.addContent(new Element("tipohemov").setText(enf.getHemostasiav() == 1? "Manual":"Dispositivo"));
			root.addContent(new Element("hemostasiav").setText(enf.getHemostrv()!=null?enf.getHemostrv():null));
			
			String viavascular = "";
			if(this.enf.getVascular1())
				viavascular +=this.bundle.getString("eef_enf_vena_fem_izq")+" - ";
			if(this.enf.getVascular2())
				viavascular +=this.bundle.getString("eef_enf_vena_fem_dcha")+" - ";
			if(this.enf.getVascular3())
				viavascular +=this.bundle.getString("eef_enf_vena_braq_izq")+" - ";
			if(this.enf.getVascular4())
				viavascular +=this.bundle.getString("eef_enf_art_fem_dcha")+" - ";
			if(this.enf.getVascular5())
				viavascular +=this.bundle.getString("eef_enf_art_fem_izq")+" - ";
			if(this.enf.getVascular6())
				viavascular +=this.bundle.getString("eef_enf_yug_subclav")+" - ";
			if(this.enf.getVascular7())
				viavascular +=this.bundle.getString("eef_enf_art_rad_dcha")+" - ";
			if(this.enf.getVascular8())
				viavascular +=this.bundle.getString("eef_enf_art_rad_izq")+" - ";
			root.addContent(new Element("viavascular").setText(!viavascular.equals("")?viavascular.substring(0, viavascular.length()-3):""));
			
			if(this.enf.getZona()!=null){
				String zonapuncion = "";
				
				switch (this.enf.getZona()) {
				case 1:
					zonapuncion = this.bundle.getString("eef_enf_estado_zona_puncion_post_op1");
					break;
				case 2:
					zonapuncion = this.bundle.getString("eef_enf_estado_zona_puncion_post_op2");
					break;
				case 3:
					zonapuncion = this.bundle.getString("eef_enf_estado_zona_puncion_post_op3");
					break;
				case 4:
					zonapuncion = this.bundle.getString("eef_enf_estado_zona_puncion_post_op4");
					break;
				}
				root.addContent(new Element("zonapuncion").setText(zonapuncion));
			}else
				root.addContent(new Element("zonapuncion").setText(null));
			
			
			String sedacion = "";
			if(this.enf.getSedacion1())
				sedacion += this.bundle.getString("eef_enf_sedacion_reminf")+" - ";
			if(this.enf.getSedacion2())
				sedacion += this.bundle.getString("eef_enf_sedacion_midalo")+" - ";
			if(this.enf.getSedacion3())
				sedacion += this.bundle.getString("eef_enf_sedacion_propof");
			root.addContent(new Element("sedacion").setText(sedacion));
			root.addContent(new Element("suero").setText(enf.getSuero()));
			root.addContent(new Element("farmacos").setText(enf.getFarmacos()));
			root.addContent(new Element("heparina").setText(enf.getHeparina()));
			
			if(this.enf.getCv()!=null && this.enf.getCv() == 1){
				root.addContent(new Element("cv").setText("1"));
				root.addContent(new Element("julios").setText((this.enf.getCv1() != null && this.enf.getCv1().length()>0?"CVE1: " + this.enf.getCv1() + " - ":"") + (this.enf.getCv2() != null && this.enf.getCv2().length()>0?"CVE2: " + this.enf.getCv2() + " - ":"") + (this.enf.getCv3() != null && this.enf.getCv3().length()>0?"CVE3: " + this.enf.getCv3() + " - ":"") + (this.enf.getCv4() != null && this.enf.getCv4().length()>0?"CVE4: " + this.enf.getCv4():"")));
				String motivo = "";
				if(this.enf.getMotivo() == 1)
					motivo = this.bundle.getString("eef_enf_motivo_op1");
				if(this.enf.getMotivo() == 2)
					motivo = this.bundle.getString("eef_enf_motivo_op2");
				if(this.enf.getMotivo() == 3)
					motivo = this.bundle.getString("eef_enf_motivo_op3");
				root.addContent(new Element("motivo").setText(motivo));
				root.addContent(new Element("exito").setText(this.enf.getExito() == 1?this.bundle.getString("eef_enf_exito_si"):this.bundle.getString("eef_enf_exito_no")));
				root.addContent(new Element("obs").setText(this.enf.getObserv()));
			}else
				root.addContent(new Element("cv").setText("0"));
			root.addContent(new Element("cuidados").setText(this.enf.getCuidados()!=null?this.enf.getCuidados():null));
			
			
			if(this.enf.getCats() != null && this.enf.getCats().size() > 0){
				root.addContent(new Element("haycat").setText("1"));
				for(ArrEstudioCateter cat : this.enf.getCats()){
					Element cateter = new Element("cateter");
					cateter.addContent(new Element("tipo").setText(cat.getIdcateter()));
					cateter.addContent(new Element("marca").setText(cat.getIdfuncion()));
					cateter.addContent(new Element("localizacion").setText(cat.getIdloc()));
					String via = " ";
					if(cat.getIdvia() != null && cat.getIdvia() != 0)
						via = maedao.findByPrimaryKey(cat.getIdvia()).getValor();
					cateter.addContent(new Element("via").setText(via));
					root.addContent(cateter);
				}
			}else{
				root.addContent(new Element("haycat").setText("0"));
			}
			
			if(this.enf.getIntroductores() != null && this.enf.getIntroductores().size() > 0){
				root.addContent(new Element("hayint").setText("1"));
				for(ArrEnfIntroductores introd : this.enf.getIntroductores()){
					Element intro = new Element("introductor");
					intro.addContent(new Element("numero").setText(introd.getNumero()));
					intro.addContent(new Element("calibre").setText(introd.getCalibre()));
					intro.addContent(new Element("tipo").setText(introd.getTipo()));
					root.addContent(intro);
				}
			}else{
				root.addContent(new Element("hayint").setText("0"));
			}
			
			if(this.enf.getActs() != null && this.enf.getActs().size() > 0){
				// Se pide el valor de cada ACT
				String acts = "";
				for(ArrEnfAct act : this.enf.getActs())
					acts = acts + String.valueOf(act.getAct())+"-";						
				if(!acts.equals(""))
					acts = acts.substring(0,acts.length()-1);
				root.addContent(new Element("act").setText(acts));
				// No se pide la media de ACTs como este ejemplo
				/*Integer sum = 0, max = this.enf.getActs().get(0).getAct(), min = this.enf.getActs().get(0).getAct();
				for(ArrEnfAct act : this.enf.getActs()){
					sum += act.getAct();
					if(act.getAct() < min)
						min = act.getAct();
					if(act.getAct() > max)
						max = act.getAct();
				}
				Integer media = sum/this.enf.getActs().size();
				root.addContent(new Element("act").setText(media + "(" + min + " - " + max + ")"));*/
			}else{
				root.addContent(new Element("act").setText("-"));
			}
			
			if(this.enf.getVendaje()!=null && this.enf.getVendaje() == 1)
				root.addContent(new Element("vendaje").setText("1"));
			else
				root.addContent(new Element("vendaje").setText(null));
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte Enfermería. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Reporte Enfermería. Motivo: "+e.getMessage(),e);
		}
	}
}

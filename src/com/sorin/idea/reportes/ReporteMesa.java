package com.sorin.idea.reportes;

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
import com.sorin.idea.dto.ArrMesas;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.util.InfoCentro;

import hvn.cm.dao.DAOException;

public class ReporteMesa {
	
	private static Logger logger = Logger.getLogger(ReporteMesa.class);
	PacienteAplDto paciente = new PacienteAplDto();
	ArrMesas mesa = new ArrMesas();
	public String pathFichero;
	Integer puntuacion;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	private InfoCentro centro;
	private ResourceBundle bundle;
	
	public ReporteMesa(String pathFichero, ArrMesas mesa, PacienteAplDto paciente, Integer puntuacion, InfoCentro c, ResourceBundle bundle) {
		this.paciente = paciente;
		this.mesa = mesa;
		this.pathFichero = pathFichero;
		this.puntuacion = puntuacion;
		this.centro = c;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	
	public void GeneraArchivoPlanilla() throws Exception {
		ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
		Element root = new Element("Mesa");
		try{
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
	        root.addContent(new Element("Centro").setText(this.centro.getCentro()));
	        root.addContent(new Element("fnaci").setText(this.paciente.getFechaNaciString()));
			root.addContent(new Element("edad").setText(this.paciente.getEdad()));
			root.addContent(new Element("sexo").setText(this.paciente.getSexo().toString()));
			root.addContent(new Element("nhc").setText(this.paciente.getNhc()));
			root.addContent(new Element("nuhsa").setText(this.paciente.getNuhsa()));
			root.addContent(new Element("paciente").setText(this.paciente.getNombreCompleto()));
			if(this.paciente.getProcedencia() != null && this.paciente.getProcedencia() > 0)
				root.addContent(new Element("procedencia").setText(maedao.findByPrimaryKey(this.paciente.getProcedencia()).getValor()));
			else
				root.addContent(new Element("procedencia").setText(" "));
			
			root.addContent(new Element("fecha").setText(this.mesa.getFechaStr()));
			root.addContent(new Element("nproc").setText(this.mesa.getNproc()));
			if(!this.mesa.getReferidor().equals("0"))
				root.addContent(new Element("referidor").setText(this.mesa.getReferidor()));
			else
				root.addContent(new Element("referidor").setText(" "));
			
			switch (this.mesa.getIndicacion()) {
			case 1:
				root.addContent(new Element("indicacion").setText(this.bundle.getString("mesa_tab1_mesa_msg_ind_op1")));
				break;
			case 2:
				root.addContent(new Element("indicacion").setText(this.bundle.getString("mesa_tab1_mesa_msg_ind_op2")));
				break;
			case 3:
				root.addContent(new Element("indicacion").setText(this.bundle.getString("mesa_tab1_mesa_msg_ind_op3")));
				break;
			case 4:
				root.addContent(new Element("indicacion").setText(this.bundle.getString("mesa_tab1_mesa_msg_ind_op4")));
				break;
			case 5:
				root.addContent(new Element("indicacion").setText(this.bundle.getString("mesa_tab1_mesa_msg_ind_op5")));
				break;
			case 6:
				root.addContent(new Element("indicacion").setText(this.bundle.getString(this.bundle.getString("mesa_tab1_mesa_msg_ind_op6"))+". " + this.mesa.getIndicacionOtra()));
				break;
			default:
				root.addContent(new Element("indicacion").setText(" "));
				break;
			}
			
			if(this.mesa.getEpiPrevios() == 0)
				root.addContent(new Element("presincopales").setText(this.bundle.getString("mesa_tab1_mesa_msg_epi_pre_op0")));
			else
				root.addContent(new Element("presincopales").setText(this.bundle.getString("mesa_tab1_mesa_msg_epi_pre_op1")));
			root.addContent(new Element("sincopales").setText(this.mesa.getEpiSin().toString()));
			if(!this.mesa.getOpMed().equals("0"))
				root.addContent(new Element("opmed").setText(this.mesa.getOpMed()));
			else
				root.addContent(new Element("opmed").setText(" "));
			if(!this.mesa.getOpEnf().equals("0"))
				root.addContent(new Element("openf").setText(this.mesa.getOpEnf()));
			else
				root.addContent(new Element("openf").setText(" "));
			root.addContent(new Element("comentarios").setText(this.mesa.getComentarios()));
			if(this.mesa.getComplicacionesSn() == 0)
				root.addContent(new Element("complicaciones").setText(this.bundle.getString("mesa_tab1_mesa_msg_compl_op0")));
			else
				root.addContent(new Element("complicaciones").setText(this.bundle.getString("mesa_tab1_mesa_msg_compl_op1")+". " + this.mesa.getComplicaciones().replace(";", "; ")));
			
			String resultado = "";
			if(this.mesa.getResN1() == 0)
				resultado = this.bundle.getString("mesa_tab3_res_op0")+". ";
			else{
				resultado += this.bundle.getString("mesa_tab3_res_op1")+". ";
				if(this.mesa.getResN2() == 0){
					resultado += this.bundle.getString("mesa_tab3_res_respuesta")+" ";
					if(this.mesa.getResN3() == 0)
						resultado += this.bundle.getString("mesa_tab3_res_tipo1")+".";
					else if(this.mesa.getResN3() == 1)
						resultado += this.bundle.getString("mesa_tab3_res_tipo2a")+".";
					else if(this.mesa.getResN3() == 2)
						resultado += this.bundle.getString("mesa_tab3_res_tipo2b")+".";
					else if(this.mesa.getResN3() == 3)
						resultado += this.bundle.getString("mesa_tab3_res_tipo3")+".";
				}	
				if(this.mesa.getResN2() == 1){
					resultado += this.bundle.getString("mesa_tab3_res_tiempo_asistolia")+" " + this.mesa.getResTiempo() + ". ";
					if(this.mesa.getResN3() == 0)
						resultado += this.bundle.getString("mesa_tab3_res_bav_no")+".";
					else if(this.mesa.getResN3() == 1)
						resultado += this.bundle.getString("mesa_tab3_res_bav_si")+".";
				}
			}
			root.addContent(new Element("resultados").setText(resultado));
			
			if(this.mesa.getCardiopatia() == 0)
				if(this.puntuacion >= -2)
					root.addContent(new Element("cardiopatia").setText(this.bundle.getString("regev_msg_reporte_cardiop_no")+": " + this.puntuacion + ". "+this.bundle.getString("regev_msg_reporte_sincop_vasovag")));
				else
					root.addContent(new Element("cardiopatia").setText(this.bundle.getString("regev_msg_reporte_cardiop_no")+": " + this.puntuacion + "."));
			if(this.mesa.getCardiopatia() == 1)
				if(this.puntuacion >= 1)
					root.addContent(new Element("cardiopatia").setText(this.bundle.getString("regev_msg_reporte_cardiop_si")+": " + this.puntuacion + ". "+this.bundle.getString("regev_msg_reporte_sincop_tv")));
				else
					root.addContent(new Element("cardiopatia").setText(this.bundle.getString("regev_msg_reporte_cardiop_si")+": " + this.puntuacion + "."));
			
			if(this.mesa.getNtg() == 0)
				root.addContent(new Element("ntg").setText(this.bundle.getString("mesa_tab1_mesa_ntg_op0")));
			else
				root.addContent(new Element("ntg").setText(this.bundle.getString("mesa_tab1_mesa_ntg_op1")));
	
			if(this.mesa.getEcgdto().getIdritmo() != null && this.mesa.getEcgdto().getIdritmo() > 0)
				root.addContent(new Element("ritmo").setText(maedao.findByPrimaryKey(this.mesa.getEcgdto().getIdritmo()).getValor()));
			else
				root.addContent(new Element("ritmo").setText(" "));
			if (this.mesa.getEcgdto() != null && this.mesa.getEcgdto().getIdconduccion() != null && this.mesa.getEcgdto().getIdconduccion() == 1)
				root.addContent(new Element("cav").setText(this.mesa.getEcgdto().getIdconduccionno()!=0?maedao.findByPrimaryKey(this.mesa.getEcgdto().getIdconduccionno()).getValor():this.bundle.getString("mesa_tab2_ecg_no_normal")));
				//root.addContent(new Element("cav").setText(maedao.findByPrimaryKey(this.mesa.getEcgdto().getIdconduccionno()).getValor()));					
			else
				root.addContent(new Element("cav").setText(this.bundle.getString("mesa_tab2_ecg_normal")));
			if (this.mesa.getEcgdto() != null && this.mesa.getEcgdto().getIdqrs() != null && this.mesa.getEcgdto().getIdqrs() == 1)
				root.addContent(new Element("cqrs").setText(this.mesa.getEcgdto().getIdqrsno()!=0?maedao.findByPrimaryKey(this.mesa.getEcgdto().getIdqrsno()).getValor():this.bundle.getString("mesa_tab2_ecg_no_normal")));
				//root.addContent(new Element("cqrs").setText(maedao.findByPrimaryKey(this.mesa.getEcgdto().getIdqrsno()).getValor()));
			else
				root.addContent(new Element("cqrs").setText(this.bundle.getString("mesa_tab2_ecg_normal")));
			root.addContent(new Element("rr").setText(this.mesa.getEcgdto().getRr().toString()));
			root.addContent(new Element("pr").setText(this.mesa.getEcgdto().getPr().toString()));
			root.addContent(new Element("qrs").setText(this.mesa.getEcgdto().getQrs().toString()));
			root.addContent(new Element("qt").setText(this.mesa.getEcgdto().getQt().toString()));
			root.addContent(new Element("qtc").setText(this.mesa.getEcgdto().getQtc().toString()));
			
			Document doc = new Document(root);

			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			// XMLOutputter out= new XMLOutputter();
			FileOutputStream file = new FileOutputStream(pathFichero);
			out.output(doc, file);
			file.flush();
			file.close();
			// out.output(doc, System.out);
		} catch (Exception e) {
			logger.error("Error generando fichero XML para informe - Reporte Mesa basculante. Motivo: "+e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}
}


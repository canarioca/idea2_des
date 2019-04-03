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
import com.sorin.idea.dto.ArrRegistrador;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.iu.SelectorIdioma;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilFechas;

import hvn.cm.dao.DAOException;

public class ReporteRegistrador {
	
	private static Logger logger = Logger.getLogger(ReporteRegistrador.class);
	PacienteAplDto paciente = new PacienteAplDto();
	ArrRegistrador registrador = new ArrRegistrador();
	public String pathFichero;
	Integer puntuacion;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	private InfoCentro centro;
	private ResourceBundle bundle;
	
	public ReporteRegistrador(String pathFichero, ArrRegistrador registrador, PacienteAplDto paciente, Integer puntuacion, InfoCentro c, ResourceBundle bundle) {
		this.paciente = paciente;
		this.registrador = registrador;
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
		Element root = new Element("Registrador");
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
			
			root.addContent(new Element("fecha").setText(UtilFechas.getFechaStringFormato(this.registrador.getFecha(), "dd/MM/yyyy")));
			root.addContent(new Element("nproc").setText(this.registrador.getNproc()));
			if(this.registrador.getReferidor()!=null && !this.registrador.getReferidor().equals("0"))
				root.addContent(new Element("referidor").setText(this.registrador.getReferidor()));
			else
				root.addContent(new Element("referidor").setText(null));
			
			if(this.registrador.getIndicacion()!=null){
				switch (this.registrador.getIndicacion()) {
					case 1:
						root.addContent(new Element("indicacion").setText(this.bundle.getString("regev_tab1_reg_ind_op1")));
						break;
					case 2:
						root.addContent(new Element("indicacion").setText(this.bundle.getString("regev_tab1_reg_ind_op2")));
						break;
					case 3:
						root.addContent(new Element("indicacion").setText(this.bundle.getString("regev_tab1_reg_ind_op3")));
						break;
					case 4:
						root.addContent(new Element("indicacion").setText(this.bundle.getString("regev_tab1_reg_ind_op4")));
						break;
					case 5:
						root.addContent(new Element("indicacion").setText(this.bundle.getString("regev_tab1_reg_ind_op5")));
						break;
					case 6:
						root.addContent(new Element("indicacion").setText(this.bundle.getString("regev_tab1_reg_ind_op6")));
						break;
					case 7:
						root.addContent(new Element("indicacion").setText(this.bundle.getString("regev_tab1_reg_ind_op7")));
						break;
					case 8:
						root.addContent(new Element("indicacion").setText(this.bundle.getString("regev_tab1_reg_ind_op8")));
						break;
					case 9:
						root.addContent(new Element("indicacion").setText(this.bundle.getString("regev_tab1_reg_ind_op9")));
						break;
					default:
						root.addContent(new Element("indicacion").setText(null));
						break;
				}
			}
			
			if(this.registrador.getIndicacionsincope()!=null){
				if(this.registrador.getIndicacionsincope() == 0)
					root.addContent(new Element("presincopales").setText(this.bundle.getString("regev_tab1_reg_epi_pre_op0")));
				else
					root.addContent(new Element("presincopales").setText(this.bundle.getString("regev_tab1_reg_epi_pre_op1")));
			}		
			root.addContent(new Element("sincopales").setText(this.registrador.getIndicacionsincopen().toString()));
			if(this.registrador.getOpMed()!=null && !this.registrador.getOpMed().equals("0"))
				root.addContent(new Element("opmed").setText(this.registrador.getOpMed()));
			else
				root.addContent(new Element("opmed").setText(null));
			if(this.registrador.getOpEnf()!=null && !this.registrador.getOpEnf().equals("0"))
				root.addContent(new Element("openf").setText(this.registrador.getOpEnf()));
			else
				root.addContent(new Element("openf").setText(null));
			root.addContent(new Element("comentarios").setText(this.registrador.getComentarios()));
			if(this.registrador.getComplicaciones() == null || this.registrador.getComplicaciones().length()==0)
				root.addContent(new Element("complicaciones").setText(this.bundle.getString("regev_msg_reporte_compl_no")));
			else
				root.addContent(new Element("complicaciones").setText(this.bundle.getString("regev_msg_reporte_compl_si")+". " + this.registrador.getComplicaciones().replace(";", "; ")));
			
			if(this.registrador.getCardiopatia() == 0)
				if(this.puntuacion >= -2)
					root.addContent(new Element("cardiopatia").setText(this.bundle.getString("regev_msg_reporte_cardiop_no")+": " + this.puntuacion + ". "+this.bundle.getString("regev_msg_reporte_sincop_vasovag")));
				else
					root.addContent(new Element("cardiopatia").setText(this.bundle.getString("regev_msg_reporte_cardiop_no")+": " + this.puntuacion + "."));
			if(this.registrador.getCardiopatia() == 1)
				if(this.puntuacion >= 1)
					root.addContent(new Element("cardiopatia").setText(this.bundle.getString("regev_msg_reporte_cardiop_si")+": " + this.puntuacion + ". "+this.bundle.getString("regev_msg_reporte_sincop_tv")));
				else
					root.addContent(new Element("cardiopatia").setText(this.bundle.getString("regev_msg_reporte_cardiop_si")+": " + this.puntuacion + "."));
			
			if(this.registrador.getEcgdto().getIdritmo() != null && this.registrador.getEcgdto().getIdritmo() > 0)
				root.addContent(new Element("ritmo").setText(maedao.findByPrimaryKey(this.registrador.getEcgdto().getIdritmo()).getValor()));
			else
				root.addContent(new Element("ritmo").setText(" "));
			if (this.registrador.getEcgdto() != null && this.registrador.getEcgdto().getIdconduccion() != null && this.registrador.getEcgdto().getIdconduccion() == 1)
				root.addContent(new Element("cav").setText(this.registrador.getEcgdto().getIdconduccionno()!=0?maedao.findByPrimaryKey(this.registrador.getEcgdto().getIdconduccionno()).getValor():this.bundle.getString("regev_tab2_ecg_no_normal")));
				//root.addContent(new Element("cav").setText(maedao.findByPrimaryKey(this.registrador.getEcgdto().getIdconduccionno()).getValor()));
			else
				root.addContent(new Element("cav").setText(this.bundle.getString("regev_tab2_ecg_normal")));
			if (this.registrador.getEcgdto() != null && this.registrador.getEcgdto().getIdqrs() != null && this.registrador.getEcgdto().getIdqrs() == 1)
				root.addContent(new Element("cqrs").setText(this.registrador.getEcgdto().getIdqrsno()!=0?maedao.findByPrimaryKey(this.registrador.getEcgdto().getIdqrsno()).getValor():this.bundle.getString("regev_tab2_ecg_no_normal")));
				//root.addContent(new Element("cqrs").setText(maedao.findByPrimaryKey(this.registrador.getEcgdto().getIdqrsno()).getValor()));
			else
				root.addContent(new Element("cqrs").setText(this.bundle.getString("regev_tab2_ecg_normal")));
			root.addContent(new Element("rr").setText(this.registrador.getEcgdto().getRr().toString()));
			root.addContent(new Element("pr").setText(this.registrador.getEcgdto().getPr().toString()));
			root.addContent(new Element("qrs").setText(this.registrador.getEcgdto().getQrs().toString()));
			root.addContent(new Element("qt").setText(this.registrador.getEcgdto().getQt().toString()));
			root.addContent(new Element("qtc").setText(this.registrador.getEcgdto().getQtc().toString()));
			
			root.addContent(new Element("sala").setText(this.registrador.getImplanteSala()));
			root.addContent(new Element("modelo").setText(this.registrador.getImplanteModelo()));
			root.addContent(new Element("nserie").setText(this.registrador.getNserie()));
			switch (this.registrador.getImplanteZona()) {
			case 1:
				root.addContent(new Element("zona").setText(this.bundle.getString("regev_tab3_imp_zona_op1")));
				break;
			case 2:
				root.addContent(new Element("zona").setText(this.bundle.getString("regev_tab3_imp_zona_op2")));
				break;
			case 3:
				root.addContent(new Element("zona").setText(this.bundle.getString("regev_tab3_imp_zona_op3")));
				break;
			case 4:
				root.addContent(new Element("zona").setText(this.bundle.getString("regev_tab3_imp_zona_op4")));
				break;
			case 5:
				root.addContent(new Element("zona").setText(this.bundle.getString("regev_tab3_imp_zona_op5")));
				break;
			default:
				root.addContent(new Element("zona").setText(null));
				break;
			}
			
			root.addContent(new Element("fechaex").setText(this.registrador.getExplanteFecha()!=null?UtilFechas.dateToString(this.registrador.getExplanteFecha()):null));
			if(this.registrador.getExplanteOpmed()!=null && !this.registrador.getExplanteOpmed().equals("0"))
				root.addContent(new Element("medex").setText(this.registrador.getExplanteOpmed()));
			else
				root.addContent(new Element("medex").setText(null));
			if(this.registrador.getExplanteOpEnf()!=null && !this.registrador.getExplanteOpEnf().equals("0"))
				root.addContent(new Element("enfex").setText(this.registrador.getExplanteOpEnf()));
			else
				root.addContent(new Element("enfex").setText(null));
			switch (this.registrador.getExplanteDiagnostico()) {
			case 1:
				root.addContent(new Element("diagex").setText(this.bundle.getString("regev_tab5_exp_motivo_op1")));
				break;
			case 2:
				root.addContent(new Element("diagex").setText(this.bundle.getString("regev_tab5_exp_motivo_op2")));
				break;
			case 3:
				root.addContent(new Element("diagex").setText(this.bundle.getString("regev_tab5_exp_motivo_op3")));
				break;
			case 4:
				root.addContent(new Element("diagex").setText(this.bundle.getString("regev_tab5_exp_motivo_op4")));
				break;
			case 5:
				root.addContent(new Element("diagex").setText(this.bundle.getString("regev_tab5_exp_motivo_op5")));
				break;
			case 6:
				root.addContent(new Element("diagex").setText(this.bundle.getString("regev_tab5_exp_motivo_op6")));
				break;
			case 7:
				root.addContent(new Element("diagex").setText(this.bundle.getString("regev_tab5_exp_motivo_op7")));
				break;
			default:
				root.addContent(new Element("diagex").setText(null));
				break;
			}
			
			Document doc = new Document(root);

			XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
			// XMLOutputter out= new XMLOutputter();
			FileOutputStream file = new FileOutputStream(pathFichero);
			out.output(doc, file);
			file.flush();
			file.close();
			// out.output(doc, System.out);
		} catch (Exception e) {
			logger.error("Error generando fichero XML para informe - Reporte Registrador de eventos. Motivo: "+e.getMessage(),e);
			throw new Exception(e.getMessage());
		}
	}
}


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
import com.sorin.idea.dto.ArrTestAtp;
import com.sorin.idea.dto.ArrTestEpi;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilFechas;

public class ReporteEPI {
	private static Logger logger = Logger.getLogger(ReporteEPI.class);
	PacienteAplDto paciente = new PacienteAplDto();
	ArrTestEpi atp = new ArrTestEpi();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	private InfoCentro centro;
	private ResourceBundle bundle;

	public ReporteEPI(String path, ArrTestEpi atp, PacienteAplDto pacienteSelect,InfoCentro c, ResourceBundle bundle) {
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.atp = atp;
		this.centro = c;
		this.bundle = bundle;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}

	public void GeneraArchivoPlanilla() {
		ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
		Element root = new Element("Test");

		try {
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
	        root.addContent(new Element("Centro").setText(this.centro.getCentro()));
			root.addContent(new Element("test").setText("Epinefrina"));
			root.addContent(new Element("Fecha").setText(UtilFechas.getFechaStringFormato(this.atp.getFecha(), "dd/MM/yyyy")));
			root.addContent(new Element("Edad").setText(this.paciente.getEdad()));
			root.addContent(new Element("Nombre").setText(this.paciente.getNombreCompleto()));
			root.addContent(new Element("NHC").setText(this.paciente.getNhc()));
			root.addContent(new Element("NUHSA").setText(this.paciente.getNuhsa()!=null?this.paciente.getNuhsa():null));

			root.addContent(new Element("nproc").setText(this.atp.getNproc()!=null?this.atp.getNproc():null));
			if(this.atp.getClinico() != null && this.atp.getClinico() > 0)
				root.addContent(new Element("mclinico").setText(maedao.findByPrimaryKey(this.atp.getClinico()).getValor()));
			else
				root.addContent(new Element("mclinico").setText(" "));
			if(this.atp.getEcg() != null && this.atp.getEcg() > 0)
				root.addContent(new Element("mecg").setText(maedao.findByPrimaryKey(this.atp.getEcg()).getValor()));
			else
				root.addContent(new Element("mecg").setText(" "));
			if(this.atp.getEcgdto().getIdritmo() != null && this.atp.getEcgdto().getIdritmo() > 0)
				root.addContent(new Element("ritmo").setText(maedao.findByPrimaryKey(this.atp.getEcgdto().getIdritmo()).getValor()));
			else
				root.addContent(new Element("ritmo").setText(" "));
			if (this.atp.getEcgdto() != null && this.atp.getEcgdto().getIdconduccion() != null && this.atp.getEcgdto().getIdconduccion() == 1)
				root.addContent(new Element("cav").setText(this.atp.getEcgdto().getIdconduccionno()!=0?maedao.findByPrimaryKey(this.atp.getEcgdto().getIdconduccionno()).getValor():this.bundle.getString("testfarma_ecg_nonormal")));
				//root.addContent(new Element("cav").setText(maedao.findByPrimaryKey(this.atp.getEcgdto().getIdconduccionno()).getValor()));
			else
				root.addContent(new Element("cav").setText(this.bundle.getString("testfarma_ecg_normal")));
			if (this.atp.getEcgdto() != null && this.atp.getEcgdto().getIdqrs() != null && this.atp.getEcgdto().getIdqrs() == 1)
				root.addContent(new Element("cqrs").setText(this.atp.getEcgdto().getIdqrsno()!=0?maedao.findByPrimaryKey(this.atp.getEcgdto().getIdqrsno()).getValor():this.bundle.getString("testfarma_ecg_nonormal")));
				//root.addContent(new Element("cqrs").setText(maedao.findByPrimaryKey(this.atp.getEcgdto().getIdqrsno()).getValor()));
			else
				root.addContent(new Element("cqrs").setText(this.bundle.getString("testfarma_ecg_normal")));
			root.addContent(new Element("rr").setText(this.atp.getEcgdto().getRr().toString()));
			root.addContent(new Element("pr").setText(this.atp.getEcgdto().getPr().toString()));
			root.addContent(new Element("qrs").setText(this.atp.getEcgdto().getQrs().toString()));
			root.addContent(new Element("qt").setText(this.atp.getEcgdto().getQt().toString()));
			root.addContent(new Element("qtc").setText(this.atp.getEcgdto().getQtc().toString()));
			if(this.atp.getDosis1() != null && this.atp.getDosis1() > 0){
				String res = maedao.findByPrimaryKey(this.atp.getDosis1()).getValor(); 
				root.addContent(new Element("res1").setText(res));
				if(res != null && res.equals("LQT1"))
					root.addContent(new Element("res2").setText(this.atp.getPicoqt()));
				else
					root.addContent(new Element("res2").setText(null));
			}
			else{
				root.addContent(new Element("res1").setText(" "));
				root.addContent(new Element("res2").setText(null));
			}
			root.addContent(new Element("res3").setText(null));
			if(this.atp.getComplica() != null && this.atp.getComplica() > 0){
				String comp = maedao.findByPrimaryKey(this.atp.getComplica()).getValor();
				if (comp != null && comp.equals("OTRAS"))
					root.addContent(new Element("complicaciones").setText(this.atp.getComplicaotr()));
				else
					root.addContent(new Element("complicaciones").setText(comp));
			}
			else
				root.addContent(new Element("complicaciones").setText(" "));
			if(this.atp.getTratam() != null && this.atp.getTratam() > 0)
				root.addContent(new Element("tratamiento").setText(maedao.findByPrimaryKey(this.atp.getTratam()).getValor()));
			else
				root.addContent(new Element("tratamiento").setText(" "));
			root.addContent(new Element("comentarios").setText(this.atp.getEcgdto().getComentarios()));
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error generando fichero XML para informe - Reporte Test Epinefrina. Motivo: "+e.getMessage(),e);
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
			logger.error("Error generando fichero XML para informe - Reporte Test Epinefrina. Motivo: "+e.getMessage(),e);
		}
	}
}

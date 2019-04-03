package com.sorin.idea.reportes;

import hvn.cm.dao.DAOException;

import java.io.File;
import java.io.FileOutputStream;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dao.MaestrasDao;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrDatosMes;
import com.sorin.idea.dto.ArrTestAtp;
import com.sorin.idea.dto.ArrTestFle;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;

public class ReporteResumenMes {
	ArrDatosMes mes = new ArrDatosMes();
	public String pathFichero;
	private String nombremes;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();

	public ReporteResumenMes(String path, ArrDatosMes mes, String nombremes) {
		this.pathFichero = path;
		this.mes = mes;
		this.nombremes = nombremes;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}

	public void GeneraArchivoPlanilla() {
		MaestrasDao stat = new MaestrasDao("");
		Element root = new Element("Mes");

		try {
			File fg = new File(req.getRealPath(rutaImagen));
	        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
	        String consulta_mes = "last_day(STR_TO_DATE('01/"+this.mes.getMes()+"/"+this.mes.getAnio()+"','%d/%m/%Y'))";
			root.addContent(new Element("mes").setText(this.nombremes + " " + this.mes.getAnio()));
			Integer eef1m = stat.consultaEstadistica("select count(*) total from arr_estudio where fecha between '01/"+this.mes.getMes()+"/2011' and "+consulta_mes+" and tipo_procedimiento = 502");
			Integer eef1t = stat.consultaEstadistica("select count(*) total from arr_estudio where fecha <="+consulta_mes+" and tipo_procedimiento = 502");
			Integer eef2m = stat.consultaEstadistica("select count(*) total from arr_estudio where fecha between '01/"+this.mes.getMes()+"/2011' and "+consulta_mes+" and tipo_procedimiento = 503");
			Integer eef2t = stat.consultaEstadistica("select count(*) total from arr_estudio where fecha <="+consulta_mes+" and tipo_procedimiento = 503");
			Integer dai1m = stat.consultaEstadistica("select count(*) total from arr_desfibrilador where fecha between '01/"+this.mes.getMes()+"/2011' and "+consulta_mes+" and generador = 1");
			Integer dai1t = stat.consultaEstadistica("select count(*) total from arr_desfibrilador where fecha <= "+consulta_mes+" and generador = 1");
			Integer dai2m = stat.consultaEstadistica("select count(*) total from arr_desfibrilador where fecha between '01/"+this.mes.getMes()+"/2011' and "+consulta_mes+" and generador = 2");
			Integer dai2t = stat.consultaEstadistica("select count(*) total from arr_desfibrilador where fecha <= "+consulta_mes+" and generador = 2");
			Integer cvm = stat.consultaEstadistica("select count(*) total from arr_cardioversion where fecha between '01/"+this.mes.getMes()+"/2011' and "+consulta_mes);
			Integer cvt = stat.consultaEstadistica("select count(*) total from arr_cardioversion where fecha <= "+consulta_mes);
			Integer atpm = stat.consultaEstadistica("select count(*) total from arr_test_atp where fecha between '01/"+this.mes.getMes()+"/2011' and "+consulta_mes);
			Integer atpt = stat.consultaEstadistica("select count(*) total from arr_test_atp where fecha <= "+consulta_mes);
			Integer epim = stat.consultaEstadistica("select count(*) total from arr_test_fle where fecha between '01/"+this.mes.getMes()+"/2011' and "+consulta_mes);
			Integer epit = stat.consultaEstadistica("select count(*) total from arr_test_fle where fecha <="+consulta_mes);
			Integer flem = stat.consultaEstadistica("select count(*) total from arr_test_epi where fecha between '01/"+this.mes.getMes()+"/2011' and "+consulta_mes);
			Integer flet = stat.consultaEstadistica("select count(*) total from arr_test_epi where fecha <="+consulta_mes);
			
			root.addContent(new Element("eef1m").setText(eef1m.toString()));
			root.addContent(new Element("eef1t").setText(eef1t.toString()));
			root.addContent(new Element("eef2m").setText(eef2m.toString()));
			root.addContent(new Element("eef2t").setText(eef2t.toString()));
			root.addContent(new Element("eef3m").setText(new Integer(eef1m+eef2m).toString()));
			root.addContent(new Element("eef3t").setText(new Integer(eef1t+eef2t).toString()));
			root.addContent(new Element("dai1m").setText(dai1m.toString()));
			root.addContent(new Element("dai1t").setText(dai1t.toString()));
			root.addContent(new Element("dai2m").setText(dai2m.toString()));
			root.addContent(new Element("dai2t").setText(dai2t.toString()));
			root.addContent(new Element("dai3m").setText(new Integer(dai1m+dai2m).toString()));
			root.addContent(new Element("dai3t").setText(new Integer(dai1t+dai2t).toString()));
			root.addContent(new Element("mesam").setText(this.mes.getMesasmes()));
			root.addContent(new Element("mesat").setText(this.mes.getMesastot()));
			root.addContent(new Element("cvm").setText(cvm.toString()));
			root.addContent(new Element("cvt").setText(cvt.toString()));
			root.addContent(new Element("riem").setText(this.mes.getRiemes()));
			root.addContent(new Element("riet").setText(this.mes.getRietot()));
			root.addContent(new Element("farm").setText(new Integer(atpm+epim+flem).toString()));
			root.addContent(new Element("fart").setText(new Integer(atpt+epit+flet).toString()));
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
		}
	}
}

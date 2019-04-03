package com.sorin.idea.reportes;

import hvn.cm.dao.DAOException;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dto.ArrDesfibrilador;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.util.UtilFechas;

public class ReporteDAI {

	PacienteAplDto paciente = new PacienteAplDto();
	ArrDesfibrilador desf = new ArrDesfibrilador();
	ArrayList<GenericosDto> hospitales = new ArrayList<GenericosDto>();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();

	public ReporteDAI(String path, ArrDesfibrilador desf,
			PacienteAplDto pacienteSelect, ArrayList<GenericosDto> hospitales) {
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.desf = desf;
		this.hospitales = hospitales;
		try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}

	public void GeneraArchivoPlanilla() {
		Element root = new Element("DAI");

		File fg = new File(req.getRealPath(rutaImagen));
        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
		root.addContent(new Element("Fnac").setText(this.paciente.getFechaNaciString()));
		root.addContent(new Element("Edad").setText(this.paciente.getEdad()));
		root.addContent(new Element("Sexo").setText(this.paciente.getSexo().toString()));
		if(this.paciente.getNss1() != null && this.paciente.getNss1().length() > 0)
			root.addContent(new Element("SS").setText("1"));
		else
			root.addContent(new Element("SS").setText("0"));
		root.addContent(new Element("Poblacion").setText(this.paciente.getPoblacion()));
		root.addContent(new Element("Himplante").setText("VIRGEN DE LAS NIEVES"));
		for(GenericosDto gen : this.hospitales)
			if(gen.getTmpInteger1() == this.paciente.getProcedencia())
				root.addContent(new Element("Hprocedencia").setText(gen.getTmpString1()));
		root.addContent(new Element("Ciudad").setText(this.paciente.getProvincia()));
		root.addContent(new Element("Isquemica").setText(this.desf.getIsquemica().toString()));
		root.addContent(new Element("Revasprev").setText(this.desf.getRevascprevia().toString()));
		root.addContent(new Element("Anosevo").setText(this.desf.getAnosevo().toString()));
		root.addContent(new Element("Infprev").setText(this.desf.getInfartoprevio().toString()));
		root.addContent(new Element("Anoscardio").setText(this.desf.getInfartoprevioano().toString()));
		root.addContent(new Element("Noisquemica").setText(this.desf.getDilatnoisquem().toString()));
		root.addContent(new Element("Hipertrof").setText(this.desf.getHipertrofica().toString()));
		root.addContent(new Element("DAVD").setText(this.desf.getDavd().toString()));
		root.addContent(new Element("Valvular").setText(this.desf.getValvular().toString()));
		root.addContent(new Element("Otravalvular").setText(this.desf.getOtracardiostr()));
		root.addContent(new Element("Brugada").setText(this.desf.getBrugada().toString()));
		root.addContent(new Element("Otrabrugada").setText(this.desf.getOtracardio2str()));
		root.addContent(new Element("Fraccion").setText(this.desf.getFraccion().toString()));
		root.addContent(new Element("IC").setText(this.desf.getIc().toString()));
		root.addContent(new Element("Clasefunc").setText(this.desf.getClasefuncional().toString()));
		root.addContent(new Element("Enfconduc").setText(this.desf.getEnfconduccion().toString()));
		root.addContent(new Element("Otroconduc").setText(this.desf.getEnfconduccionstr()));
		root.addContent(new Element("Ritmo").setText(this.desf.getRitmobasal().toString()));
		root.addContent(new Element("Otrobasal").setText(this.desf.getRitmobasalstr()));
		root.addContent(new Element("Histof").setText(this.desf.getAntecinsrenal().toString()));
		root.addContent(new Element("Histog").setText(this.desf.getAntecfa().toString()));
		root.addContent(new Element("Histoh").setText(this.desf.getDiabetes().toString()));
		root.addContent(new Element("Histoi").setText(this.desf.getHipertension().toString()));
		root.addContent(new Element("Histoj").setText(this.desf.getAntecmuertesubita().toString()));
		root.addContent(new Element("QRS").setText(this.desf.getAnchuraqrs()));
		root.addContent(new Element("Histol").setText(this.desf.getFumador().toString()));
		root.addContent(new Element("Histom").setText(this.desf.getHipercoles().toString()));
		root.addContent(new Element("Histon").setText(this.desf.getAcv().toString()));
		root.addContent(new Element("Arritmia").setText(this.desf.getArrclinica().toString()));
		root.addContent(new Element("Otrossintomas").setText(this.desf.getPresclinicastr()));
		root.addContent(new Element("Presentacion").setText(this.desf.getPresclinica().toString()));
		root.addContent(new Element("EEF").setText(this.desf.getEef().toString()));
		root.addContent(new Element("Arrindu").setText(this.desf.getArrinducida().toString()));
		root.addContent(new Element("Implante").setText(this.desf.getImplante().toString()));
		root.addContent(new Element("Fimplante").setText(UtilFechas.dateToString(this.desf.getFecimplante())));
		root.addContent(new Element("Lugarimpl").setText(this.desf.getLugarimplante().toString()));
		root.addContent(new Element("Implantador").setText(this.desf.getImplantador().toString()));
		root.addContent(new Element("Generador").setText(this.desf.getGenerador().toString()));
		root.addContent(new Element("Fprevio").setText(UtilFechas.dateToString(this.desf.getFecimplprevio())));
		root.addContent(new Element("Recambio").setText(this.desf.getRecambio().toString()));
		root.addContent(new Element("TVFV").setText(this.desf.getTvfv().toString()));
		root.addContent(new Element("Terapia").setText(this.desf.getTerapia().toString()));
		root.addContent(new Element("Localizacion").setText(this.desf.getLocimplante().toString()));
		root.addContent(new Element("Electrodosact").setText(this.desf.getElecsisact().toString()));
		root.addContent(new Element("Ad").setText(this.desf.getAd().toString()));
		root.addContent(new Element("Vd").setText(this.desf.getVd().toString()));
		root.addContent(new Element("Vi").setText(this.desf.getVi().toString()));
		root.addContent(new Element("Fanterior").setText(UtilFechas.dateToString(this.desf.getFecimplanter())));
		root.addContent(new Element("Electrodoadi").setText(this.desf.getElecadic().toString()));
		root.addContent(new Element("Elecprev").setText(this.desf.getElecprev().toString()));
		root.addContent(new Element("Induccion").setText(this.desf.getInduc().toString()));
		root.addContent(new Element("Umbral").setText(this.desf.getUmbral()));
		root.addContent(new Element("Choques").setText(this.desf.getNchoques().toString()));
		root.addContent(new Element("Comp1").setText(this.desf.getComplninguna().toString()));
		root.addContent(new Element("Comp2").setText(this.desf.getComplmuerte().toString()));
		root.addContent(new Element("Comp3").setText(this.desf.getCompltap().toString()));
		root.addContent(new Element("Comp4").setText(this.desf.getComplneum().toString()));
		root.addContent(new Element("Comp5").setText(this.desf.getCompldisec().toString()));
		root.addContent(new Element("Comp6").setText(this.desf.getComplotro().toString()));
		root.addContent(new Element("Comp7").setText(this.desf.getComplsitua().toString()));
		root.addContent(new Element("Antibra").setText(this.desf.getEstimantibradi().toString()));
		root.addContent(new Element("Algor").setText(this.desf.getAlgoritmo().toString()));
		root.addContent(new Element("ATP").setText(this.desf.getAtp().toString()));
		root.addContent(new Element("Modelo").setText(this.desf.getModelo().toString()));

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

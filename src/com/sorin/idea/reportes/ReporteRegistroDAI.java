package com.sorin.idea.reportes;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;

import hvn.cm.dao.DAOException;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ComplicacionesDao;
import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Complicaciones;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpIndicacion;
import com.sorin.idea.dto.ImpSintomas;
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilReporteRegistroDAI;

public class ReporteRegistroDAI {

	private static Logger logger = Logger.getLogger(ReporteRegistroDAI.class);
	PacienteAplDto paciente = new PacienteAplDto();
	public String pathFichero;
	private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	private ArrMaestrasDao mdao = new ArrMaestrasDaoImpl("informe");
	private ComplicacionesDao compdao = new ComplicacionesDaoImpl("informe");
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
	
	private ImpHojaImplante himp;
	private SituacionClinicaProc hind;
	private ImpEvolucion hev;
	private UtilReporteRegistroDAI u;
	private InfoCentro info;
	private ArrayList<ComplicacionesPacientes> complicaciones;
	private Integer VVI;
	private Integer VVIR;
	private Integer DDD;
	private Integer DDDR;
	private Integer compMUERTE;
	private Integer compTAPCARD;
	private Integer compNEUMO;
	private Integer compDISECSC;
	private Integer compSITUACION;
	
	
	public ReporteRegistroDAI(String path, PacienteAplDto pacienteSelect,ImpHojaImplante imp, SituacionClinicaProc ind, 
			ImpEvolucion hevo, UtilReporteRegistroDAI util, InfoCentro centro, ArrayList<ComplicacionesPacientes> comps){
		this.pathFichero = path;
		this.paciente = pacienteSelect;
		this.himp = imp; 
		this.hind = ind;
		this.hev = hevo;
		this.u = util;
		this.info = centro;
		this.complicaciones = comps;
		try {
			this.obtenerDatosBD();
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
	}
	public void GeneraArchivoPlanilla() {
		Element root = new Element("DAI");

		File fg = new File(req.getRealPath(rutaImagen));
        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
		root.addContent(new Element("Fnac").setText(this.paciente.getFechaNaciString()!=null?this.paciente.getFechaNaciString():""));
		root.addContent(new Element("Edad").setText(this.paciente.getEdad()!=null?this.paciente.getEdad():""));
		root.addContent(new Element("Sexo").setText(this.paciente.getSexo().toString()));
		if(this.paciente.getNss1() != null && this.paciente.getNss1().length() > 0)
			root.addContent(new Element("SS").setText("1"));
		else
			root.addContent(new Element("SS").setText("0"));
		root.addContent(new Element("Poblacion").setText(this.paciente.getPoblacion()));
		root.addContent(new Element("Himplante").setText(this.info.getCentro()));
		root.addContent(new Element("Hprocedencia").setText(this.u.getHospitalprocedencia()));
		// REVISAR
		/*for(GenericosDto gen : this.hospitales)
			if(gen.getTmpInteger1() == this.paciente.getProcedencia())
				root.addContent(new Element("Hprocedencia").setText(gen.getTmpString1()));*/
		root.addContent(new Element("Ciudad").setText(this.info.getCiudad()));
		root.addContent(new Element("Isquemica").setText((this.hind.getCardiopatia()!=null)?this.hind.getCardiopatia().toString():""));
		root.addContent(new Element("Revasprev").setText((this.hind.getRevasc()!=null)?this.hind.getRevasc().toString():""));
		root.addContent(new Element("Anosevo").setText((this.hind.getAevolucion()!=null)?this.hind.getAevolucion().toString():""));
		root.addContent(new Element("Infprev").setText((this.hind.getInfprevio()!=null)?this.hind.getInfprevio().toString():""));
		root.addContent(new Element("Anoscardio").setText((this.hind.getAnio()!=null)?this.hind.getAnio().toString():""));
		root.addContent(new Element("Noisquemica").setText((this.hind.getCardiopatia()!=null)?this.hind.getCardiopatia().toString():""));
		root.addContent(new Element("Hipertrof").setText((this.hind.getCardiopatia()!=null)?this.hind.getCardiopatia().toString():""));
		root.addContent(new Element("DAVD").setText((this.hind.getCardiopatia()!=null)?this.hind.getCardiopatia().toString():""));
		root.addContent(new Element("Valvular").setText((this.hind.getCardiopatia()!=null)?this.hind.getCardiopatia().toString():""));
		root.addContent(new Element("Otravalvular").setText((this.hind.getOtra()!=null)&&(this.hind.getOtra().length()>0)?this.hind.getOtra().toString():""));
		root.addContent(new Element("Brugada").setText((this.hind.getCardiopatia()!=null)?this.hind.getCardiopatia().toString():""));
		root.addContent(new Element("Otrabrugada").setText((this.hind.getOtra()!=null)&&(this.hind.getOtra().length()>0)?this.hind.getOtra().toString():""));
		root.addContent(new Element("Fraccion").setText((this.hind.getFuncionventricular()!=null)?this.hind.getFuncionventricular().toString():""));	
		root.addContent(new Element("IC").setText((this.hind.isIc()?"2":"1")));
		root.addContent(new Element("Clasefunc").setText((this.hind.getNyha()!=null)?this.hind.getNyha().toString():""));
		// REVISAR
		//root.addContent(new Element("Enfconduc").setText((this.hind.getConducav()!=null)?this.hind.getConducav().toString():""));
		if(this.hind.getRitmo()==1028 && this.hind.getRitmo2()!=null && this.hind.getRitmo2()!=1043)
			root.addContent(new Element("Enfconduc").setText("1"));
		else if((this.hind.getConducav()==63||this.hind.getConducav()==64||this.hind.getConducav()==65))
			root.addContent(new Element("Enfconduc").setText("2"));
		else if(this.hind.getQrs()==69||this.hind.getQrs()==67||this.hind.getQrs()==681||this.hind.getQrs()==682)
			root.addContent(new Element("Enfconduc").setText("3"));
		else if(this.hind.getQrs()==72||this.hind.getQrs()==68)
			root.addContent(new Element("Enfconduc").setText("4"));
		else{
			root.addContent(new Element("Enfconduc").setText("0"));
			root.addContent(new Element("Otroconduc").setText(""));
		}
			
		//root.addContent(new Element("Enfconduc"));
		// REVISAR
		
		//root.addContent(new Element("Ritmo").setText((this.hind.getRitmobasal()!=null)?this.hind.getRitmobasal().toString():""));
		if(u.getRitmo().equals("SINUSAL NORMAL"))
			root.addContent(new Element("Ritmo").setText("0"));
		else if(u.getRitmo().equals("MARCAPASOS"))
			root.addContent(new Element("Ritmo").setText("3"));
		else if(u.getRitmo().equals("FIBRILACIÓN AURICULAR"))
			root.addContent(new Element("Ritmo").setText("1"));
		else{
			root.addContent(new Element("Ritmo").setText("4"));
			root.addContent(new Element("Otrobasal").setText(u.getRitmo()));
		}
		
		root.addContent(new Element("Histof").setText(this.hind.isAnteinsrenal()?"2":"1"));
		root.addContent(new Element("Histog").setText(this.hind.isAntefa()?"2":"1"));	
		root.addContent(new Element("Histoh").setText(this.hind.isAntediab()?"2":"1"));		
		root.addContent(new Element("Histoi").setText(this.hind.isAntehipertens()?"2":"1"));
		root.addContent(new Element("Histoj").setText(this.hind.isAntefam()?"2":"1"));
		root.addContent(new Element("QRS").setText(this.hind.getAnchuraqrs()));
		root.addContent(new Element("Histol").setText(this.hind.isAntetabaq()?"2":"1"));
		root.addContent(new Element("Histom").setText(this.hind.isAntehipercol()?"2":"1"));
		root.addContent(new Element("Histon").setText(this.hind.isAnteacv()?"2":"1"));
		root.addContent(new Element("Arritmia").setText((this.hind.getArritmias()!=null)?this.hind.getArritmias().toString():"5"));		
		boolean enc=false;
		for(SintomasSitclinProc s:this.hind.getSintomas()){
			if(s.getIdsintomas().equals("MUERTE SUBITA")){
				root.addContent(new Element("Presentacion").setText("1"));
				enc=true;
				break;
			}else if(s.getIdsintomas().equals("SINCOPE")){
				root.addContent(new Element("Presentacion").setText("2"));
				enc=true;
				break;
			}else if(s.getIdsintomas().equals("ASINTOMATICO")){
				root.addContent(new Element("Presentacion").setText("4"));
				enc=true;
				break;
			}		
		}
		if(enc==false){		
			if(this.hind.getSintomas().size()>0){
				root.addContent(new Element("Presentacion").setText("3"));
				root.addContent(new Element("Otrossintomas").setText((this.hind.getSintomas().get(0).getIdsintomas()!=null)?this.hind.getSintomas().get(0).getIdsintomas().toString():""));			
			}		
		}	
		root.addContent(new Element("EEF").setText(this.hind.isEefprev()?"2":"1"));		
		root.addContent(new Element("Arrindu").setText((this.hind.getEef()!=null)?this.hind.getEef().toString():"5"));	
		root.addContent(new Element("Implante").setText(this.himp.getTindicacion()!=null?this.himp.getTindicacion().toString():"3"));
		root.addContent(new Element("Fimplante").setText(UtilFechas.getFechaStringFormato(u.getFechaimplante(), "dd/MM/yyyy")));	
		root.addContent(new Element("Lugarimpl").setText((this.himp.getLugarimp()!=null)?this.himp.getLugarimp().toString():""));
		root.addContent(new Element("Implantador").setText((this.himp.getImplantador()!=null)?this.himp.getImplantador().toString():""));
		if(this.u.isPrimoimplante())
			root.addContent(new Element("Generador").setText("1"));
		else if(this.u.isRecambio())
			root.addContent(new Element("Generador").setText("2"));
		// REVISAR
		root.addContent(new Element("Fprevio").setText((u.getFechaimplanteprevio()!=null)?UtilFechas.getFechaStringFormato(u.getFechaimplanteprevio(), "dd/MM/yyyy"):""));
		// CONFIRMAR
		//root.addContent(new Element("Recambio").setText(this.u.isRecambio()?"1":"2"));
		// CONFIRMAR - POR AGOTAMIENTO Y POR COMPLICACIONES
		root.addContent(new Element("Recambio").setText(u.getMotivorecambio()!=null?u.getMotivorecambio():""));
		// CONFIRMAR
		root.addContent(new Element("TVFV").setText((this.hev.getNumepisodios()!=null && this.hev.getNumepisodios().length()>0 && !(this.hev.getNumepisodios().equals("0")))?"2":"1"));
		if(this.hev.isTeratp() && this.hev.isTerchoques())
			root.addContent(new Element("Terapia").setText("3"));
		else if(this.hev.isTeratp() && !(this.hev.isTerchoques()))
			root.addContent(new Element("Terapia").setText("1"));
		else if(!(this.hev.isTeratp()) && this.hev.isTerchoques())
			root.addContent(new Element("Terapia").setText("2"));
		else
			root.addContent(new Element("Terapia").setText(""));
		root.addContent(new Element("Localizacion").setText((this.u.getLocalizacion()!=null)?this.u.getLocalizacion():""));
		root.addContent(new Element("Electrodosact").setText("1"));
		root.addContent(new Element("Ad").setText(this.u.isAd()?"1":"2"));
		root.addContent(new Element("Vd").setText(this.u.isVd()?"1":"2"));
		root.addContent(new Element("Vi").setText(this.u.isVi()?"1":"2"));
		root.addContent(new Element("Fanterior").setText((u.getFechaimplanteprevio()!=null)?UtilFechas.getFechaStringFormato(u.getFechaimplanteprevio(),"dd/MM/yyyy"):""));
		// REVISAR
		root.addContent(new Element("Electrodoadi").setText(""));
		// REVISAR - Funcionalidad Historicos
		root.addContent(new Element("Elecprev").setText(u.getElecprev()!=null?u.getElecprev():""));
		root.addContent(new Element("Elecprevaband").setText(u.getElecdisfaban()!=null?u.getElecdisfaban():""));
		root.addContent(new Element("Elecprevexp").setText(u.getElecdisfexp()!=null?u.getElecdisfexp():""));
		
		
		root.addContent(new Element("Induccion").setText((this.himp.isTesti()?"2":"1")));
		root.addContent(new Element("Umbral").setText((this.himp.getEnergiatest()!=null)?this.himp.getEnergiatest().toString():""));
		root.addContent(new Element("Choques").setText((this.himp.getNumchoqtest()!=null)?this.himp.getNumchoqtest().toString():""));
		// COMPLICACIONES
		root.addContent(new Element("Comp1").setText((this.complicaciones.size()==0)?"1":""));
		for(ComplicacionesPacientes c:this.complicaciones){
			if(c.getComplicacion().equals(this.compMUERTE))
				root.addContent(new Element("Comp2").setText("1"));
			else if(c.getComplicacion().equals(this.compTAPCARD))
				root.addContent(new Element("Comp3").setText("1"));
			else if(c.getComplicacion().equals(this.compNEUMO))
				root.addContent(new Element("Comp4").setText("1"));
			else if(c.getComplicacion().equals(this.compDISECSC))
				root.addContent(new Element("Comp5").setText("1"));
			else if(c.getComplicacion().equals(this.compSITUACION))
				root.addContent(new Element("Comp7").setText("1"));
			else
				root.addContent(new Element("Comp6").setText("1"));
		}
		
		if(this.hev.getModogen()!=null){
			if(this.hev.getModogen().equals(this.VVI))
				root.addContent(new Element("Antibra").setText("1"));
			else if(this.hev.getModogen().equals(this.VVIR))
				root.addContent(new Element("Antibra").setText("2"));
			else if(this.hev.getModogen().equals(this.DDD))
				root.addContent(new Element("Antibra").setText("3"));
			else if(this.hev.getModogen().equals(this.DDDR))
				root.addContent(new Element("Antibra").setText("4"));
			else
				root.addContent(new Element("Antibra").setText("5"));
		}
		
		root.addContent(new Element("Algor").setText((this.hev.isMinestvent()?"1":"2")));
		root.addContent(new Element("ATP").setText("2"));
		if(this.hev.getZonas().size()>0)
			for(ImpZona z:this.hev.getZonas())
				if(z.getAtps().size()>0){
					//root.addContent(new Element("ATP").setText("1"));
					root.getChild("ATP").setText("1");
					break;
				}
		// 6.C - Modelo. Se obtiene del modo basico del generador. VR = Monocameral, DR = Bicameral, DDDRV = Tricameral
		if(this.u.getModoBasico()!=null){
			if(this.u.getModoBasico().toUpperCase().startsWith("D")){
				if(this.u.getModoBasico().toUpperCase().contains("V"))
					root.addContent(new Element("Modelo").setText("3"));
				else
					root.addContent(new Element("Modelo").setText("2"));
			}else // MONOCAMERAL
				root.addContent(new Element("Modelo").setText("1"));
		}else
			root.addContent(new Element("Modelo").setText(""));
		
		/*if(this.hev.getModogen()!=null && (this.hev.getModogen().equals(1) || this.hev.getModogen().equals(2)
				|| this.hev.getModogen().equals(5) || this.hev.getModogen().equals(6)))
			root.addContent(new Element("Modelo").setText("2"));
		else if(this.hev.getModogen()!=null && (this.hev.getModogen().equals(3) || this.hev.getModogen().equals(7)))
			root.addContent(new Element("Modelo").setText("1"));
		else if(this.hev.getModogen()!=null && this.hev.getModogen().equals(9))
			root.addContent(new Element("Modelo").setText("3"));
		else
			root.addContent(new Element("Modelo").setText(""));*/
			
		root.addContent(new Element("InfoGenerador").setText(u.getInfogen()));
		root.addContent(new Element("InfoElectrodos").setText(u.getInfoelecs()));
	
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
			logger.error("Error generando fichero XML para informe - Registro Nacional de DAI. Motivo: "+e.getMessage(),e);
		}
	}
	
	private void obtenerDatosBD(){
		try{
			Complicaciones[] comps = this.compdao.findByDynamicWhere("AMBITO = ? OR AMBITO = ?", new Object[]{3,0});
			for(Complicaciones c:comps){
				if(c.getNombre().toUpperCase().startsWith("NEUMO"))
					this.compNEUMO = c.getIdcomplicacion();
				else if(c.getNombre().toUpperCase().startsWith("MUERT"))
					this.compMUERTE = c.getIdcomplicacion();
				else if(c.getNombre().toUpperCase().startsWith("TAPONA"))
					this.compTAPCARD = c.getIdcomplicacion();
				else if(c.getNombre().toUpperCase().startsWith("SITUA"))
					this.compSITUACION = c.getIdcomplicacion();
				else if(c.getNombre().toUpperCase().startsWith("DISECCI"))
					this.compDISECSC = c.getIdcomplicacion();
			}
			ArrMaestras[] modos = this.mdao.findWhereTipoEquals(97);
			for(ArrMaestras m:modos){
				if(m.getValor().toUpperCase().equals("VVI"))
					this.VVI = m.getCodigo();
				else if(m.getValor().toUpperCase().equals("VVIR"))
					this.VVIR = m.getCodigo();
				else if(m.getValor().toUpperCase().equals("DDD"))
					this.DDD = m.getCodigo();
				else if(m.getValor().toUpperCase().equals("DDDR"))
					this.DDDR = m.getCodigo();
			}
		}catch(Exception e1){
			logger.error("Error obteniendo datos BD para informe - Registro Nacional de DAI. Motivo: "+e1.getMessage(),e1);
		}
	}
	
}

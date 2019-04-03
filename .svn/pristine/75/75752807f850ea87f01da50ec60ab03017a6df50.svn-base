package com.sorin.idea.exportacion;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import org.jdom.Document;
import org.jdom.Element;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ComplicacionDao;
import com.sorin.idea.dao.ComplicacionesDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.Complicacion;
import com.sorin.idea.dto.Complicaciones;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpZona;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.RegistroDaiDto;
import com.sorin.idea.util.UtilConversorTarjetaEuropea;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilReporteRegistroDAI;

public class ExportaRegistroDAI {

	private ArrPacientes paciente = new ArrPacientes();
	private SituacionClinicaProc hind;
	private ImpHojaImplante himp;
	private ImpEvolucion hev;
	private UtilReporteRegistroDAI u;
	private InfoCentro hospital;
	//private ImpHojaImplanteComplicacion[] compIntra;
	private ComplicacionesPacientes[] compIntra;
	private Date fechaPrevio;
	private ArrMaestrasDao mdao = new ArrMaestrasDaoImpl("informe");
	private ComplicacionesDao compdao = new ComplicacionesDaoImpl("informe");
	
	
	/*private static Integer VVI = 1109;
	private static Integer VVIR = 1110;
	private static Integer DDD = 1107;
	private static Integer DDDR = 1108;*/
	
	private static Integer VVI;
	private static Integer VVIR;
	private static Integer DDD;
	private static Integer DDDR;
	private static Integer compMUERTE;
	private static Integer compTAPCARD;
	private static Integer compNEUMO;
	private static Integer compDISECSC;
	private static Integer compSITUACION;
	
	public ExportaRegistroDAI(){
		try{
			this.obtenerDatosBD();
		}catch(Exception e1){
			
		}
	}
	
	public ExportaRegistroDAI(ArrPacientes pacienteSelect,SituacionClinicaProc s,ImpHojaImplante imp, ImpEvolucion ev, 
				UtilReporteRegistroDAI util,InfoCentro hosp, /*ImpHojaImplanteComplicacion[]*/ComplicacionesPacientes[] comps, Date fechaPrevio){
		this.hind = s;
		this.himp = imp;
		this.hev = ev;
		this.u = util;
		this.paciente = pacienteSelect;
		this.hospital = hosp;
		this.compIntra = comps;
		this.fechaPrevio = fechaPrevio;
		try{
			this.obtenerDatosBD();
		}catch(Exception e1){
			
		}
	}

	public Element creaItemRegistroDAI(){
		try{
			ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
			ComplicacionDao cdao = new ComplicacionDaoImpl("");
			Element root = new Element("DAI");

			root.addContent(new Element("Fnac").setText(this.paciente.getFechanaci()!=null?UtilFechas.dateToString(this.paciente.getFechanaci()):""));
			root.addContent(new Element("Edad").setText(this.paciente.getFechanaci()!=null?String.valueOf(UtilFechas.getEdad(this.paciente.getFechanaci())):null));
			root.addContent(new Element("Sexo").setText(this.paciente.getSexo()!=null?this.paciente.getSexo().toString():null));
			if(this.paciente.getNss1() != null && this.paciente.getNss1().length() > 0)
				root.addContent(new Element("SS").setText("1"));
			else
				root.addContent(new Element("SS").setText("0"));
			root.addContent(new Element("Poblacion").setText(this.paciente.getPoblacion()));
			root.addContent(new Element("Himplante").setText(this.hospital.getCentro()));
			String hproc = "";
			if(this.paciente.getHprocedencia()!=null && !this.paciente.getHprocedencia().equals(0)){
				hproc = maedao.findByPrimaryKey(this.paciente.getHprocedencia()).getValor();
			}
			root.addContent(new Element("Hprocedencia").setText(hproc!=null?hproc:""));
			// REVISAR
			/*for(GenericosDto gen : this.hospitales)
				if(gen.getTmpInteger1() == this.paciente.getProcedencia())
					root.addContent(new Element("Hprocedencia").setText(gen.getTmpString1()));*/
			root.addContent(new Element("Ciudad").setText(this.hospital.getCiudad()));
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
			
			if(u.getRitmo().equals("SINUSAL"))
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
			/*boolean enc=false;
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
				root.addContent(new Element("Presentacion").setText("3"));
				if(this.hind.getSintomas().size()>0)
					root.addContent(new Element("Otrossintomas").setText((this.hind.getSintomas().get(0).getIdsintomas()!=null)?this.hind.getSintomas().get(0).getIdsintomas().toString():""));
				else
					root.addContent(new Element("Otrossintomas").setText("NO ESPECIFICADO"));		
			}*/	
			root.addContent(new Element("EEF").setText(this.hind.isEefprev()?"2":"1"));		
			root.addContent(new Element("Arrindu").setText((this.hind.getEef()!=null)?this.hind.getEef().toString():"5"));	
			root.addContent(new Element("Implante").setText(this.himp.getTindicacion()!=null?this.himp.getTindicacion().toString():"3"));
			// CONFIRMAR
			root.addContent(new Element("Fimplante").setText(UtilFechas.dateToString(u.getFechaimplante())));	
			root.addContent(new Element("Lugarimpl").setText((this.himp.getLugarimp()!=null)?this.himp.getLugarimp().toString():""));
			root.addContent(new Element("Implantador").setText((this.himp.getImplantador()!=null)?this.himp.getImplantador().toString():""));
			// CONFIRMAR
			root.addContent(new Element("Generador").setText(this.u.isPrimoimplante()?"1":"2"));
			
			// REVISAR
			Date fprev = obtenerFechaImplanteAnterior(this.paciente.getCodigo());
			root.addContent(new Element("Fprevio").setText(fprev!=null?UtilFechas.getFechaStringFormato(fprev, "dd/MM/yyyy"):""));
			// CONFIRMAR
			//root.addContent(new Element("Recambio").setText(this.u.isRecambio()?"1":"2"));
			root.addContent(new Element("Recambio").setText(""));// PENDIENTE
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
			root.addContent(new Element("Fanterior").setText((u.getFechaimplanteprevio()!=null)?UtilFechas.dateToString(u.getFechaimplanteprevio()):""));
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
			if(this.compIntra.length>0){
				for(ComplicacionesPacientes c:this.compIntra){
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
				/*for(ImpHojaImplanteComplicacion comp:this.compIntra){
					Complicacion c = cdao.findByPrimaryKey(comp.getIdcompl());
					if(c!=null){
						if(c.getIdcompl()==16)// NEUMOTORAX
							root.addContent(new Element("Comp4").setText("1"));
						else if(c.getIdcompl()==123)// TAPONAMIENTO
							root.addContent(new Element("Comp3").setText("1"));
						else if(c.getIdcompl()==124)// DISECCION SC
							root.addContent(new Element("Comp5").setText("1"));
						else if(c.getIdcompl()==125)// SITUACION SUBOPTIMA
							root.addContent(new Element("Comp7").setText("1"));
						else if(c.getTipo().equals(971))// MUERTE
							root.addContent(new Element("Comp2").setText("1"));
						else
							root.addContent(new Element("Comp6").setText("1"));
					}
				}*/
			}else
				root.addContent(new Element("Comp1").setText("1"));
			
			// PROGRAMACION ANTIBRADICARDIA
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
			
			//root.addContent(new Element("Antibra").setText((this.hev.getModogen()!=null)?this.hev.getModogen().toString():"5"));
			root.addContent(new Element("Algor").setText((this.hev.isMinestvent()?"1":"2")));
			// REVISAR
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
				
			root.addContent(new Element("InfoGenerador").setText(u.getInfogen()));
			root.addContent(new Element("InfoElectrodos").setText(u.getInfoelecs()));
			
			return root;
		}catch(Exception e1){
			e1.printStackTrace();
			return null;
		}
	}

	public static Document generaExportacionRegistroDAI(ArrayList<Element> items){
		try{
			Element root = new Element("RegistroNacionalDAIAnual");				
			for(Element e:items){
				root.addContent(e);
			}
			Document doc= new Document(root);
			return doc;
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}
	}

	public static UtilReporteRegistroDAI preparaObjetoAuxiliar(Procedimiento p,ImpGenerador g,
				ImpImplanteElectrodos[] els,ArrayList<ImpHojaImplanteComplicacion> cs,
				SituacionClinicaProc sit, Generador[] generadores, Electrodos[] electrodos,ArrMaestras[] ritmos){
		UtilReporteRegistroDAI util = new UtilReporteRegistroDAI();
		util.setHospitalprocedencia("ABC"); // TODO
		util.setFechaimplante(p.getFecha());
		if (p.getTipoprocedimiento().equals(956))
			util.setPrimoimplante(true);
		else
			util.setPrimoimplante(false);
		for (SelectItem i : getRitmos(ritmos)) {
			if (i.getValue().toString().equals(sit.getRitmo().toString())) {
				util.setRitmo(i.getLabel());
				break;
			}
		}
		//for (ImpGenerador g : this.listagenerador) {
			if (g.getMotivorecambio() != null)
				util.setRecambio(true);
			if (g.getMotivoexplante() == null
					&& (g.getLocalizacion() == 3 || g.getLocalizacion() == 4))
				util.setLocalizacion("1");
			if (g.getMotivoexplante() == null
					&& (g.getLocalizacion() == 5 || g.getLocalizacion() == 6))
				util.setLocalizacion("2");
			if (g.getMotivoexplante() == null) {
				Generador auxgen = UtilConversorTarjetaEuropea.buscaGenerador(generadores, g.getIdgenerador());
				util.setInfogen(auxgen.getFabricante() + " " + auxgen.getModelo() + " Num.Serie:" + g.getNumserie());
			}
		//}
		String auxInfoElec = "";
		for (ImpImplanteElectrodos e : els) {
			if (e.getCamara()!=null && e.getCamara() == 948)
				util.setAd(true);
			else if (e.getCamara()!=null &&e.getCamara() == 949)
				util.setVd(true);
			else if (e.getCamara()!=null &&e.getCamara() == 950)
				util.setVi(true);
			if (e.getEstado() == 0) {// Solo metemos los electrodos activos
				Electrodos auxelec = UtilConversorTarjetaEuropea.buscaElectrodo(electrodos, e.getIdelectrodo());
				auxInfoElec = auxInfoElec + auxelec.getFabricante() + " " + auxelec.getModelo() + " Num.Serie:" + e.getNumserie() + "\n";
				util.setInfoelecs(auxInfoElec);
				// Electrodos Previos
				util.setElecprev("1");
			} else if (((e.getEstado() == 2) || (e.getEstado() == 3)) && (e.getCaracter() == 2)) {
				// Electrodos Previos
				util.setElecdisfexp("1");
			} else if (e.getEstado() == 1)
				// Electrodos Previos
				util.setElecdisfaban("1");
		}
		
		return util;
	}
	
	public RegistroDaiDto obtenerItemDAI(ArrPacientes pat, Procedimiento p, ImpHojaImplante himp,
			ImpEvolucion ev, ImpGenerador g, ImpImplanteElectrodos[] els, /*ImpHojaImplanteComplicacion[]*/ComplicacionesPacientes[] cs,
			SituacionClinicaProc sit, Generador generador, Date fechaPrev, InfoCentro hosp){
		RegistroDaiDto item = new RegistroDaiDto();
		try{
			ArrMaestrasDao maedao = new ArrMaestrasDaoImpl("");
			ComplicacionDao cdao = new ComplicacionDaoImpl("");
			item.setFechaNac(pat.getFechanaci());
			item.setEdad(pat.getFechanaci()!=null?UtilFechas.getEdad(pat.getFechanaci()):null); // TODO
			if(pat.getSexo()!=null){
				if(pat.getSexo().equals(1))
					item.setSexo("Masculino");
				else if(pat.getSexo().equals(2))
					item.setSexo("Femenino");
				else
					item.setSexo("");
			}
			item.setSeg(pat.getNss1()!=null?"Si":"No");
			item.setPoblacion(pat.getPoblacion()!=null?pat.getPoblacion():"");
			item.setHospImp(hosp.getCentro()!=null?hosp.getCentro():"");
			String hproc = "";
			if(pat.getHprocedencia()!=null && !pat.getHprocedencia().equals(0)){
				hproc = maedao.findByPrimaryKey(pat.getHprocedencia()).getValor(); // REVISAR
			}
			item.setHospProc(hproc!=null?hproc:""); 
			item.setCiudadHosp(hosp.getCiudad()!=null?hosp.getCiudad():"");
			// 2.A CARDIOPATÍA
			String cardiop = null;
			if(sit.getCardiopatia()!=null)
				cardiop = maedao.findByPrimaryKey(sit.getCardiopatia()).getValor();
			item.setCardiopatia(cardiop!=null?cardiop:"");
			item.setAevol(sit.getAevolucion()!=null?sit.getAevolucion():"");
			item.setCardiopatiaOtra(sit.getOtra()!=null?sit.getOtra():"");
			if(sit.getRevasc()!=null)
				item.setRevasc(sit.getRevasc().intValue()==1?"Si":"No");
			if(sit.getInfprevio()!=null)
				item.setInfPrevio(sit.getInfprevio().intValue()==1?"Si":"No");
			// 2.B FRACCIÓN DE EYECCIÓN
			String feyec = "";
			if(sit.getFuncionventricular()!=null){
				if(sit.getFuncionventricular().equals(1))
					feyec = ">50%";
				else if(sit.getFuncionventricular().equals(2))
					feyec = "41-50%";
				else if(sit.getFuncionventricular().equals(3))
					feyec = "36-40%";
				else if(sit.getFuncionventricular().equals(4))
					feyec = "31-35%";
				else if(sit.getFuncionventricular().equals(5))
					feyec = "<=30%";
			}
			item.setFracEyec(feyec);
			// 2.C IC
			if(sit.getNyha()!=null){
				if(sit.getNyha().equals(1))
					item.setIc("Nyha I");
				else if(sit.getNyha().equals(2))
					item.setIc("Nyha II");
				else if(sit.getNyha().equals(3))
					item.setIc("Nyha III");
				else if(sit.getNyha().equals(4))
					item.setIc("Nyha IV");
			}else
				item.setIc("");
			// 2.D ENFERMEDAD DE CONDUCCIÓN
			if(sit.getRitmo()==1028 && sit.getRitmo2()!=null && sit.getRitmo2()!=1043)
				item.setEnfCond("");
			else if((sit.getConducav()==63 || sit.getConducav()==64|| sit.getConducav()==65))
				item.setEnfCond("BAV");
			else if(sit.getQrs()==69 || sit.getQrs()==67 || sit.getQrs()==681|| sit.getQrs()==682)
				item.setEnfCond("BRD");
			else if(sit.getQrs()==72 || sit.getQrs()==68)
				item.setEnfCond("BRI");
			else{
				item.setEnfCond("");
			}
			// 2.E RITMO BASAL
			if(sit.getRitmo()!=null && !sit.getRitmo().equals(0)){
				if(sit.getRitmo().equals(56))
					item.setRitmoBasal("FA");
				else if(sit.getRitmo().equals(61))
					item.setRitmoBasal("Marcapasos");
				else if(sit.getRitmo().equals(342))
					item.setRitmoBasal("Sinusal");
				else{
					item.setRitmoBasal("Otro");
					item.setRitmoBasalOtro(maedao.findByPrimaryKey(sit.getRitmo()).getValor());
				}
			}else
				item.setRitmoBasal("");
			// 2.F-N ANTECEDENTES
			if(sit.getInsrenal()!=null)
				item.setAntInsRenal(sit.getInsrenal().intValue()==1?"Si":"No");
			if(sit.getAntfa()!=null)
				item.setAntFa(sit.getAntfa().intValue()==1?"Si":"No");
			if(sit.getDiabetes()!=null)
				item.setAntDiab(sit.getDiabetes().intValue()==1?"Si":"No");
			if(sit.getHta()!=null)
				item.setAntHta(sit.getHta().intValue()==1?"Si":"No");
			if(sit.getMuertesubita()!=null)
				item.setAntMuerteSub(sit.getMuertesubita().intValue()==1?"Si":"No");
			if(sit.getTabaquismo()!=null)
				item.setAntFum(sit.getTabaquismo().intValue()==1?"Si":"No");
			if(sit.getHipercolest()!=null)
				item.setAntDislip(sit.getHipercolest().intValue()==1?"Si":"No");
			if(sit.getAcv()!=null)
				item.setAntAcv(sit.getAcv().intValue()==1?"Si":"No");
			item.setAnchQRS(sit.getAnchuraqrs()!=null?sit.getAnchuraqrs():"");
			// 3.A Arritmia Clínica
			if(sit.getArritmias()!=null){
				if(sit.getArritmias().equals(1))
					item.setArritmiaClinica("FV");
				else if(sit.getArritmias().equals(2))
					item.setArritmiaClinica("TVP");
				if(sit.getArritmias().equals(3))
					item.setArritmiaClinica("TVMS");
				if(sit.getArritmias().equals(4))
					item.setArritmiaClinica("TVNS");
			}else
				item.setArritmiaClinica("NINGUNA");
			
			// 3.B - PRESENTACION CLINICA
			for(SintomasSitclinProc s:sit.getSintomas()){
				if(s.getIdsintomas().equals("MUERTE SUBITA")){
					item.setPresClinica("MUERTE SÚBITA");
					break;
				}else if(s.getIdsintomas().equals("SINCOPE")){
					item.setPresClinica("SÍNCOPE");
					break;
				}else if(s.getIdsintomas().equals("ASINTOMATICO")){
					item.setPresClinica("ASINTOMÁTICO");
					break;
				}else{
					item.setPresClinica("OTROS");
					item.setPresClinciaOtros(s.getIdsintomas());
					break;
				}
			}
			// 3.C - EEF
			if(sit.getEef()!=null){
				item.setEef("SI");
				if(sit.getEef().equals(1))
					item.setEefArritmia("FV");
				else if(sit.getEef().equals(2))
					item.setEefArritmia("TVMS");
				else if(sit.getEef().equals(3))
					item.setEefArritmia("TVNS");
				else if(sit.getEef().equals(4))
					item.setEefArritmia("OTRA");
			}else
				item.setEef("NO");
			
			// 4.A PREVENCION
			if(himp.getTindicacion()!=null){
				if(himp.getTindicacion().equals(0))
					item.setPrevencion("PREVENCIÓN PRIMARIA");
				else if(himp.getTindicacion().equals(1))
					item.setPrevencion("PREVENCIÓN SECUNDARIA");
				else if(himp.getTindicacion().equals(2))
					item.setPrevencion("DESCONOCIDA");
			}else
				item.setPrevencion("");
			//4.B FECHA + LUGAR IMPLANTE
			item.setFechaImpl(p.getFecha());
			if(himp.getLugarimp()!=null){
				if(himp.getLugarimp().equals(1))
					item.setLugarImpl("Lab. Electrofisiología");
				else if(himp.getLugarimp().equals(2))
					item.setLugarImpl("Quirófano");
				else if(himp.getLugarimp().equals(3))
					item.setLugarImpl("Otro");
			}else
				item.setLugarImpl("");
			// 4.C IMPLANTADOR
			if(himp.getImplantador()!=null){
				if(himp.getImplantador().equals(1))
					item.setImplantador("Cirujano");
				else if(himp.getImplantador().equals(2))
					item.setImplantador("Electrofisiólogo");
				else if(himp.getImplantador().equals(3))
					item.setImplantador("Intensivista");
				else if(himp.getImplantador().equals(4))
					item.setImplantador("EEF+Cirujano");
				else if(himp.getImplantador().equals(5))
					item.setImplantador("Otro");
			}else
				item.setImplantador("");
			
			// 4.D GENERADOR
			item.setTipoProc(p.getTipoprocedimiento().equals(956)?"PRIMOIMPLANTE":"RECAMBIO");
			item.setModeloGen(generador.getModelo());
			item.setNserieGen(g.getNumserie());
			if(g.getLocalizacion()!=null && !g.getLocalizacion().equals(0)){
				if(g.getLocalizacion().equals(986) || g.getLocalizacion().equals(987)
						|| g.getLocalizacion().equals(990))
					item.setLocGen("SUBCUTÁNEA");
				else if(g.getLocalizacion().equals(988) || g.getLocalizacion().equals(989))
					item.setLocGen("SUBPECTORAL");
			}
			if(!p.getTipoprocedimiento().equals(956)){ // RECAMBIO
				item.setFechaImplPrev(obtenerFechaImplanteAnterior(p.getCodigo())); 
				if(g.getMotivorecambio()!=null){
					if(g.getMotivorecambio().equals(960))
						item.setMotivosRecambioAgot("SI");
					else if(g.getMotivorecambio().equals(1094))
						item.setMotivosRecambioCompl("SI");
					else if(g.getMotivorecambio().equals(1093))
						item.setMotivosRecambioUpgrade("SI");
				}
				if(p.getTipoprocedimiento().equals(1061))
					item.setMotivosRecambioUpgrade("SI");
				if(ev.getAtp()!=null && ev.getAtp().intValue()==1)
					item.setTerapiaATP("SI");
				if(ev.getChoques()!=null && ev.getChoques().intValue()==1)
					item.setTerapiaChoques("SI");
				int numepi = 0;
				if(ev.getNumepifv()!=null){
					try{
						numepi = Integer.parseInt(ev.getNumepifv());
					}catch(Exception e){
					}
				}
				if(ev.getNumepitv()!=null){
					try{
						numepi = numepi + Integer.parseInt(ev.getNumepitv());
					}catch(Exception e){
					}
				}
				item.setEpiTVFV(numepi>0?"SI":"NO");
			}
			// 4.E ELECTRODOS SISTEMA ACTUAL
			for(ImpImplanteElectrodos e:els){
				if(e.getCamara().equals(948) && e.getEstado().equals(0)){
					item.setAd(true);
					item.setModeloAD(e.getNombremodelo());
					item.setNserieAD(e.getNumserie());	
				}else if(e.getCamara().equals(949) && e.getEstado().equals(0)){
					item.setVd(true);
					item.setModeloVD(e.getNombremodelo());
					item.setNserieVD(e.getNumserie());
				}else if(e.getCamara().equals(950) && e.getEstado().equals(0)){
					item.setVi(true);
					item.setModeloVI(e.getNombremodelo());
					item.setNserieVI(e.getNumserie());
				}
				// ELECTRODOS PREVIOS - abandonados + disfuncionantes
				if(e.getEstado().equals(1)){
					item.setElecPrevDisf(true);
					item.setElecPrevDisfAband(true);
				}
				if(e.getEstado().equals(2) || e.getEstado().equals(3)){
					item.setElecPrevDisf(true);
					item.setElecPrevDisfExpl(true);
				}	
			}
			// 4.G INDUCCIÓN
			if(himp.getTestind()!=null && himp.getTestind().intValue()==1){
				item.setInduccion(true);
				item.setInduccionEnergia(himp.getEnergiatest()!=null?himp.getEnergiatest():"");
				item.setInduccionNumChoques(himp.getNumchoqtest()!=null?himp.getNumchoqtest():"");
			}
			// 5. COMPLICACIONES
			if(cs.length>0){
				for(ComplicacionesPacientes c:cs){
					if(c.getComplicacion().equals(compMUERTE))
						item.setCompliMuerte("SI");
					else if(c.getComplicacion().equals(compTAPCARD))
						item.setCompliTapCard("SI");
					else if(c.getComplicacion().equals(compNEUMO))
						item.setCompliNeumo("SI");
					else if(c.getComplicacion().equals(compDISECSC))
						item.setCompliDiseccionSC("SI");
					else if(c.getComplicacion().equals(compSITUACION))
						item.setCompliSitSubOptima("SI");
					else
						item.setCompliOtro("SI");
				}
				/*for(ImpHojaImplanteComplicacion comp:cs){
					Complicacion c = cdao.findByPrimaryKey(comp.getIdcompl());
					if(c!=null){
						if(c.getIdcompl()==16)// NEUMOTORAX
							item.setCompliNeumo("SI");
						else if(c.getIdcompl()==123)// TAPONAMIENTO
							item.setCompliTapCard("SI");
						else if(c.getIdcompl()==124)// DISECCION SC
							item.setCompliDiseccionSC("SI");
						else if(c.getIdcompl()==125)// SITUACION SUBOPTIMA
							item.setCompliSitSubOptima("SI");
						else if(c.getTipo().equals(971))// MUERTE
							item.setCompliMuerte("SI");
						else // OTRO
							item.setCompliOtro("SI");
					}
				}*/
			}else
				item.setCompliNinguna("SI");
			// 6.A ESTIMULACIÓN ANTIBRADICARDIA
			if(ev.getModogen()!=null){
				if(ev.getModogen().equals(VVI))
					item.setEstimAntiBradi("VVI");
				else if(ev.getModogen().equals(VVIR))
					item.setEstimAntiBradi("VVIR");
				else if(ev.getModogen().equals(DDD))
					item.setEstimAntiBradi("DDD");
				else if(ev.getModogen().equals(DDDR))
					item.setEstimAntiBradi("DDDR");
				else
					item.setEstimAntiBradi("OTRO");
			}
			if(ev.getMev()!=null)
				item.setMev(ev.getMev().intValue()==1?"ON":"OFF");
			if(ev.getZonas()!=null){
				boolean atp = false;
				for(ImpZona z:ev.getZonas()){
					if(z.getAtps()!=null && z.getAtps().size()>0){
						atp = true;
						break;
					}
				}
				item.setAtpProg(atp?"SI":"NO");
			}
			if(generador.getModo()!=null){
				if(generador.getModo().toUpperCase().startsWith("D")){
					if(generador.getModo().toUpperCase().contains("V"))
						item.setModelo("TRICAMERAL");
					else
						item.setModelo("BICAMERAL");
				}else // MONOCAMERAL
					item.setModelo("MONOCAMERAL");
			}else
				item.setModelo("");
		}catch(Exception e){
			e.printStackTrace();
		}
		return item;
	}
	
	public static ArrayList<SelectItem> getRitmos(ArrMaestras[] ritmos) {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "SINUSAL"));
		for (ArrMaestras diagnostico : ritmos)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	
	public static Date obtenerFechaImplanteAnterior(Integer idpaciente){
		try{
			ProcedimientoDao pdao = new ProcedimientoDaoImpl();
			Procedimiento[] lista= pdao.findByDynamicWhere(
							"CODIGO =? AND (TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?  OR TIPOPROCEDIMIENTO = ?  OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?)",
							new Object[] {idpaciente,956,957,993,1059,1060,1085,1147,1086,1090});
			List<Procedimiento> lista_procs = Arrays.asList(lista);
			// Ordenar DESC
			Collections.sort(lista_procs, new Comparator() {
				public int compare(Object o1, Object o2) {
					Procedimiento e1 = (Procedimiento) o1;
					Procedimiento e2 = (Procedimiento) o2;
					if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())>0) {
						return 1;
					} else if (UtilFechas.dateDiff(e1.getFecha(), e2.getFecha())<=0) {
						return -1;
					} else {
						return 0;
					}
				}
			});
			for(int i=0;i<lista_procs.size();i++){
				if(!lista_procs.get(i).getTipoprocedimiento().equals(1147) && !lista_procs.get(i).getTipoprocedimiento().equals(957)
						&& !lista_procs.get(i).getTipoprocedimiento().equals(1085) && !lista_procs.get(i).getTipoprocedimiento().equals(1086)){
					return lista_procs.get(i).getFecha();
				}
			}
		}catch(Exception e1){
			
		}
		return null;
	}
	
	public String getEdad(Date fechaNaci) {
        String edad = "";
		try {
            if (fechaNaci != null)
                edad = new Integer(UtilFechas.getEdad(fechaNaci)).toString();
        }
        catch (Exception ex) {
            edad = "";
        }
        return edad;
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
			//logger.error("Error obteniendo datos BD para informe - Registro Nacional de DAI. Motivo: "+e1.getMessage(),e1);
		}
	}
}

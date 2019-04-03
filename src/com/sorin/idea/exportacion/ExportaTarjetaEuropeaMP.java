package com.sorin.idea.exportacion;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import org.jdom.Document;
import org.jdom.Element;

import com.sorin.idea.dao.ElectrodosDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dao.ImpGeneradorDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.ImpImplanteElectrodosDao;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplantePop;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpGeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteElectrodosDaoImpl;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.TarjetaMP;
import com.sorin.idea.util.UtilConversorTarjetaEuropea;


public class ExportaTarjetaEuropeaMP {

	private TarjetaMP tarjeta;
	ArrPacientes paciente = new ArrPacientes();
	private ImpImplanteElectrodosDao impelecdao;
	private ImpImplanteDao impdao;
	private ImpGeneradorDao gendao;
	private ElectrodosDao elecdao;
	
	public ExportaTarjetaEuropeaMP(ArrPacientes pacienteSelect,TarjetaMP tr){
		this.paciente = pacienteSelect;
		this.tarjeta = tr;
		this.impelecdao = new ImpImplanteElectrodosDaoImpl();
		this.impdao = new ImpImplanteDaoImpl();
		this.gendao = new ImpGeneradorDaoImpl();
	}
	
	public Element creaItemTarjetaEuropea(){
		Element root = new Element("TarjetaEuropeaPortadorMP");
		
		java.text.SimpleDateFormat sdf=new java.text.SimpleDateFormat("yyyy-MM-dd");
		
		
		root.addContent(new Element("Fecha").setText(sdf.format(new Date())));
			//root.addContent(new Element("Edad").setText(this.paciente.getEdad()));
			root.addContent(new Element("Nombre").setText(this.paciente.getApellid1()+" "+this.paciente.getApellid2()+", "+this.paciente.getNombre()));
			root.addContent(new Element("Direccion").setText(this.paciente.getDireccion()));
			root.addContent(new Element("Ciudad").setText(this.paciente.getPoblacion()));
			root.addContent(new Element("CodigoPostal").setText(this.paciente.getCp()));
			root.addContent(new Element("Pais").setText(this.paciente.getPais()));
			root.addContent(new Element("Telefono").setText(this.paciente.getTelefono1()));
			// cambio formato YYYY-MM-DD
			root.addContent(new Element("FechaNacimiento").setText(this.paciente.getFechanaci()!=null?sdf.format(this.paciente.getFechanaci()):""));
			// tratarlo 1 F, 2 M
			if(this.paciente.getSexo()!= null){
				if(this.paciente.getSexo().toString().equals("1"))
					root.addContent(new Element("Sexo").setText("M"));
				else 
					root.addContent(new Element("Sexo").setText("F"));
			}else{
				root.addContent(new Element("Sexo").setText("U"));
			}
			root.addContent(new Element("NHC").setText(this.paciente.getNhc()));
			root.addContent(new Element("DNI").setText(this.paciente.getDni()));
			root.addContent(new Element("NSS").setText(this.paciente.getNss1()));

			if(this.tarjeta.getFechaprimerimplante() != null)
				root.addContent(new Element("FechaPrimerImplante").setText(sdf.format(this.tarjeta.getFechaprimerimplante())));
			if(this.tarjeta.getSintprim() != null)
				root.addContent(new Element("Sintoma1").setText(this.tarjeta.getSintprim()));
			if(this.tarjeta.getSintsec() != null)
				root.addContent(new Element("Sintoma2").setText(this.tarjeta.getSintsec()));
			if(this.tarjeta.getEcgprim() != null)
				root.addContent(new Element("ECG1").setText(this.tarjeta.getEcgprim()));
			if(this.tarjeta.getEcgsec() != null)
				root.addContent(new Element("ECG2").setText(this.tarjeta.getEcgsec()));
			if(this.tarjeta.getEtioprim() != null)
				root.addContent(new Element("Etiologia1").setText(this.tarjeta.getEtioprim()));
			if(this.tarjeta.getEtiosec() != null)
				root.addContent(new Element("Etiologia2").setText(this.tarjeta.getEtiosec()));
			if(this.tarjeta.getDependientemp() >= 0)
				root.addContent(new Element("DependienteMP").setText(String.valueOf(this.tarjeta.getDependientemp())));
			if(this.tarjeta.getDoctor() != null)
				root.addContent(new Element("Doctor").setText(this.tarjeta.getDoctor()));
			if(this.tarjeta.getHospital() != null)
				root.addContent(new Element("Hospital").setText(this.tarjeta.getHospital()));
			if(this.tarjeta.getDirhosp() != null)
				root.addContent(new Element("DireccionHospital").setText(this.tarjeta.getDirhosp()));
			if(this.tarjeta.getCiudadhosp() != null)
				root.addContent(new Element("CiudadHospital").setText(this.tarjeta.getCiudadhosp()));
			if(this.tarjeta.getTfnohosp() != null)
				root.addContent(new Element("TelefonoHospital").setText(this.tarjeta.getTfnohosp()));
			
			root.addContent(new Element("PaisHospital").setText("ES"));
			
			if(this.tarjeta.getFrecgen() != null)
				root.addContent(new Element("FrecMinima").setText(this.tarjeta.getFrecgen()));
			if(this.tarjeta.getModogen() != null)
				root.addContent(new Element("ModoEstimulacion").setText(this.tarjeta.getModogen()));
			if(this.tarjeta.getDurimpgen() != null)
				root.addContent(new Element("DuracionImp").setText(this.tarjeta.getDurimpgen()));
			if(this.tarjeta.getFechaimpgen() != null)
				root.addContent(new Element("FechaImplante").setText(sdf.format(this.tarjeta.getFechaimpgen())));
			if(this.tarjeta.getFabgen() != null)
				root.addContent(new Element("Fabricante").setText(this.tarjeta.getFabgen()));
			if(this.tarjeta.getModelogen() != null)
				root.addContent(new Element("Modelo").setText(this.tarjeta.getModelogen()));
			if(this.tarjeta.getNumseriegen() != null)
				root.addContent(new Element("NumSerie").setText(this.tarjeta.getNumseriegen()));
			
			
			if(this.tarjeta.getFechaimpea() != null)
				root.addContent(new Element("FechaImplanteEA").setText(sdf.format(this.tarjeta.getFechaimpea())));
			if(this.tarjeta.getFabea() != null)
				root.addContent(new Element("FabricanteEA").setText(this.tarjeta.getFabea()));
			if(this.tarjeta.getModeloea() != null)
				root.addContent(new Element("ModeloEA").setText(this.tarjeta.getModeloea()));
			if(this.tarjeta.getNumserieea() != null)
				root.addContent(new Element("NumSerieEA").setText(this.tarjeta.getNumserieea()));
			
			if(this.tarjeta.getIsea()){
				root.addContent(new Element("IS1EA").setText("1"));
				if(this.tarjeta.getUnibiea()==1){
					root.addContent(new Element("UniEA").setText("1"));
					root.addContent(new Element("BiEA").setText("0"));
				}else if(this.tarjeta.getUnibiea()==0){
					root.addContent(new Element("UniEA").setText("0"));
					root.addContent(new Element("BiEA").setText("1"));
				}
			}	
			else
				root.addContent(new Element("IS1EA").setText("0"));
			

			if(this.tarjeta.getFechaimpev() != null)
				root.addContent(new Element("FechaImplanteEV").setText(sdf.format(this.tarjeta.getFechaimpev())));
			if(this.tarjeta.getFabev() != null)
				root.addContent(new Element("FabricanteEV").setText(this.tarjeta.getFabev()));
			if(this.tarjeta.getModeloev() != null)
				root.addContent(new Element("ModeloEV").setText(this.tarjeta.getModeloev()));
			if(this.tarjeta.getNumserieev() != null)
				root.addContent(new Element("NumSerieEV").setText(this.tarjeta.getNumserieev()));
			
			if(this.tarjeta.getIsev()){
				root.addContent(new Element("IS1EV").setText("1"));
				if(this.tarjeta.getUnibiev()==1){
					root.addContent(new Element("UniEV").setText("1"));
					root.addContent(new Element("BiEV").setText("0"));
				}else if(this.tarjeta.getUnibiev()==0){
						root.addContent(new Element("UniEV").setText("0"));
						root.addContent(new Element("BiEV").setText("1"));
				}
			}	
			else
				root.addContent(new Element("IS1EV").setText("0"));
			
			
			/************* BLOQUE EXPLANTES *******************/
			if(this.tarjeta.getFechaexplante() != null)
				root.addContent(new Element("FechaExplante").setText(sdf.format(this.tarjeta.getFechaexplante())));
			
			if(this.tarjeta.getMotivoexpgen() != null)
				root.addContent(new Element("MotivoExplanteGen").setText(this.tarjeta.getMotivoexpgen()));
			if(this.tarjeta.getFechaimpgenexp() != null)
				root.addContent(new Element("FechaImplanteGenExplante").setText(sdf.format(this.tarjeta.getFechaimpgenexp())));
			if(this.tarjeta.getFabgenexp() != null)
				root.addContent(new Element("FabricanteGenExplante").setText(this.tarjeta.getFabgenexp()));
			if(this.tarjeta.getModogenexp() != null)
				root.addContent(new Element("ModoEstimGenExplante").setText(this.tarjeta.getModogenexp()));
			if(this.tarjeta.getModelogenexp() != null)
				root.addContent(new Element("ModeloGenExplante").setText(this.tarjeta.getModelogenexp()));
			if(this.tarjeta.getNumseriegenexp() != null)
				root.addContent(new Element("NumSerieGenExplante").setText(this.tarjeta.getNumseriegenexp()));
			
			
			if(this.tarjeta.getMotivoexpea() != null)
				root.addContent(new Element("MotivoExplanteEA").setText(this.tarjeta.getMotivoexpea()));
			if(this.tarjeta.getFechaimpeaexp() != null)
				root.addContent(new Element("FechaImplanteEAExplante").setText(sdf.format(this.tarjeta.getFechaimpeaexp())));
			if(this.tarjeta.getFabeaexp() != null)
				root.addContent(new Element("FabricanteEAExplante").setText(this.tarjeta.getFabeaexp()));
			if(this.tarjeta.getModeloeaexp() != null)
				root.addContent(new Element("ModeloEAExplante").setText(this.tarjeta.getModeloeaexp()));
			if(this.tarjeta.getNumserieeaexp() != null)
				root.addContent(new Element("NumSerieEAExplante").setText(this.tarjeta.getNumserieeaexp()));
			
			if(this.tarjeta.isIseaexp()){
				root.addContent(new Element("IS1EAExplante").setText("1"));
				if(this.tarjeta.getUnibieaexp()==1){
					root.addContent(new Element("UniEAExplante").setText("1"));
					root.addContent(new Element("BiEAExplante").setText("0"));
				}else if(this.tarjeta.getUnibieaexp()==0){
					root.addContent(new Element("UniEAExplante").setText("0"));
					root.addContent(new Element("BiEAExplante").setText("1"));
				}
			}	
			else
				root.addContent(new Element("IS1EAExplante").setText("0"));
				
			if(this.tarjeta.getMotivoexpea() != null)
				root.addContent(new Element("MotivoExplanteEV").setText(this.tarjeta.getMotivoexpev()));
			if(this.tarjeta.getFechaimpeevxp() != null)
				root.addContent(new Element("FechaImplanteEVExplante").setText(sdf.format(this.tarjeta.getFechaimpeevxp())));
			if(this.tarjeta.getFabevexp() != null)
				root.addContent(new Element("FabricanteEVExplante").setText(this.tarjeta.getFabevexp()));
			if(this.tarjeta.getModeloevexp() != null)
				root.addContent(new Element("ModeloEVExplante").setText(this.tarjeta.getModeloevexp()));
			if(this.tarjeta.getNumserieevexp() != null)
				root.addContent(new Element("NumSerieEVExplante").setText(this.tarjeta.getNumserieevexp()));
			
			if(this.tarjeta.isIsevexp()){
				root.addContent(new Element("IS1EVExplante").setText("1"));
				if(this.tarjeta.getUnibievexp()==1){
					root.addContent(new Element("UniEVExplante").setText("1"));
					root.addContent(new Element("BiEVExplante").setText("0"));
				}else if(this.tarjeta.getUnibievexp()==0){
					root.addContent(new Element("UniEVExplante").setText("0"));
					root.addContent(new Element("BiEVExplante").setText("1"));
				}
			}
			else
				root.addContent(new Element("IS1EVExplante").setText("0"));
		return root;
	}
	public static Document generaExportacionRegistroMPS(ArrayList<Element> items){
		try{
			Element root = new Element("RegistroNacionalMarcapasos");				
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
	
	public static TarjetaMP preparaTarjetaEuropea(Procedimiento proc, SituacionClinicaProc hind,ImpHojaImplante himp,
			ImpEvolucion hev,ImpGenerador[] listagenerador,ImpImplanteElectrodos[] listaelectrodos,
			Generador[] generadores, Electrodos[] electrodos, InfoCentro infocentro) {
		TarjetaMP tmp = new TarjetaMP();
		
		// Lista de generadores explantados
		ArrayList<ImpGenerador> listageneradorexp = new ArrayList<ImpGenerador>();
		for(ImpGenerador g:listagenerador)
			if(g.getMotivoexplante()!=null)
				listageneradorexp.add(g);
		// Lista de electrodos explantados
		ArrayList<ImpImplanteElectrodos> listaelectrodosexp = new ArrayList<ImpImplanteElectrodos>();
		for(ImpImplanteElectrodos e:listaelectrodos)
			if(e.getMotivoexaband()!=null && e.getEstado()!=0 && e.getCaracter()==1)
				listaelectrodosexp.add(e);
		
		tmp.setFechaprimerimplante(proc.getFecha());
		if(hind.getSintomas().size()>0)
			tmp.setSintprim((hind.getSintomas().get(0) != null) ? UtilConversorTarjetaEuropea
					.codigoSintoma(hind.getSintomas().get(0).getIdsintomas(),hind.getRitmo(),hind.getRitmo2())
					: "");
		if(hind.getSintomas().size()>1)
			tmp.setSintsec((hind.getSintomas().get(1) != null) ? UtilConversorTarjetaEuropea
					.codigoSintoma(hind.getSintomas().get(1).getIdsintomas(),hind.getRitmo(),hind.getRitmo2())
					: "");
		/*tmp.setEtioprim((hind.getEtiologia() != null) ? UtilConversorTarjetaEuropea
				.codigoEtiologia(hind.getEtiologia()) : "");*/
		int neuro = 0;int cardio=0;
		if(hind.getNeuromediados() != null)
			neuro = hind.getNeuromediados();
		if(hind.getCardiopatia()!=null)
			cardio=hind.getCardiopatia();
		tmp.setEtioprim(UtilConversorTarjetaEuropea.codigoEtiologia(cardio,neuro,hind.isAnteTrasplanteCardiaco(),hind.isInfartoprev()));
		
		// ECG
		int anchura=0;int r2=0;int c2=0;int q2=0;
		if(hind.getAnchuraqrs()!=null && hind.getAnchuraqrs().length()>0)
			anchura = Integer.valueOf(hind.getAnchuraqrs());
		if(hind.getRitmo2()!=null)
			r2=hind.getRitmo2();
		if(hind.getConducav2()!=null)
			c2 = hind.getConducav2();
		if(hind.getQrs2()!=null)
			q2 = hind.getQrs2();
		tmp.setEcgprim(UtilConversorTarjetaEuropea.codigoECG(hind.getRitmo(), r2, hind.getConducav(), c2,hind.getQrs(), q2, anchura));
		
		// Sintoma + Etiologia + ECG secundario -> no lo ponemos
		tmp.setDependientemp(hev.getMpdependiente() != null
				&& hev.getMpdependiente() == 1 ? 1 : 0);
		// CENTRO MP
		String pops = "";
		for (ImpHojaImplantePop s : himp.getPoperador()) {
			pops = pops + s.getIdop() + ", ";
		}
		tmp.setDoctor(pops);

		tmp.setFrecgen((hev.getFmin() != null) ? hev.getFmin() : "");
		tmp.setModogen((hev.getModogen() != null ? UtilConversorTarjetaEuropea
				.cambiaModoGen(hev.getModogen()) : ""));
		for (ImpGenerador g : listagenerador) {
			if (g.getMotivoexplante() == null) {
				tmp.setNumseriegen(g.getNumserie());
				Generador auxgen = UtilConversorTarjetaEuropea.buscaGenerador(
						generadores, g.getIdgenerador());
				tmp.setModelogen(auxgen.getModelo());
				tmp.setFabgen(auxgen.getFabricante());
				break;
			}
		}
		tmp.setFechaimpgen(proc.getFecha());
		// EXPLANTE GENERADOR
		if (listageneradorexp != null) {
			for (ImpGenerador g : listageneradorexp) {
				if (g.getMotivoexplante() != null) {
					tmp.setMotivoexpgen("");
					Generador auxgen = UtilConversorTarjetaEuropea
							.buscaGenerador(generadores,
									g.getIdgenerador());
					tmp.setModelogenexp(auxgen.getModelo());
					tmp.setFabgenexp(auxgen.getFabricante());
					tmp.setFechaexplante(proc.getFecha());
					tmp.setModogenexp(g.getModo());
					tmp.setNumseriegenexp(g.getNumserie());
					ImpImplante aux = buscaImplanteGenExp(g);
					tmp.setFechaimpgenexp(aux!=null?buscaImplanteGenExp(g).getFechaimplante():null);
					break;
				}
			}
		}
		
		boolean vd = false, vi = false;
		String auxDurImpAD = null, auxDurImpVD = null, auxDurImpVI = null;
		for (ImpImplanteElectrodos e : listaelectrodos) {
			if (e.getMotivoexaband() == null && e.getCamara()!=null && e.getCamara() == 948) {// AD
				tmp.setFechaimpea(proc.getFecha());
				Electrodos auxelec = UtilConversorTarjetaEuropea
						.buscaElectrodo(electrodos, e.getIdelectrodo());
				tmp.setFabea(auxelec.getFabricante());
				tmp.setModeloea(auxelec.getModelo());
				tmp.setNumserieea(e.getNumserie());
				auxDurImpAD = e.getDurimpulso();
				if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
					tmp.setIsea(true);
				if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
					tmp.setUnibiea(1);
				else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
					tmp.setUnibiea(0);
			} else if (e.getMotivoexaband() == null && e.getCamara()!=null && e.getCamara() == 949) { // VD
				tmp.setFechaimpev(proc.getFecha());
				Electrodos auxelec = UtilConversorTarjetaEuropea
						.buscaElectrodo(electrodos, e.getIdelectrodo());
				tmp.setFabev(auxelec.getFabricante());
				tmp.setModeloev(auxelec.getModelo());
				tmp.setNumserieev(e.getNumserie());
				auxDurImpVD = e.getDurimpulso();
				vd = true;
				if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
					tmp.setIsev(true);
				if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
					tmp.setUnibiev(1);
				else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
					tmp.setUnibiev(0);
			} else if (e.getMotivoexaband() == null && e.getCamara()!=null && e.getCamara() == 949) {
				auxDurImpVI = e.getDurimpulso();
				vi = true;
			}
		}
		// Duracion Impulso Generador
		if (vd)
			tmp.setDurimpgen(auxDurImpVD);
		else if (vi && !vd)
			tmp.setDurimpgen(auxDurImpVI);
		else
			tmp.setDurimpgen(auxDurImpAD);

		// EXPLANTE ELECTRODOS
		if (listaelectrodosexp != null) {
			for (ImpImplanteElectrodos e : listaelectrodosexp) {
				if (e.getEstado() != 0 && e.getCamara()!=null && e.getCamara() == 948) {// AD
					tmp.setFechaimpeaexp(buscaFechaImplanteEaEvExp(e));
					Electrodos auxelec = UtilConversorTarjetaEuropea
							.buscaElectrodo(electrodos, e.getIdelectrodo());
					tmp.setFabeaexp(auxelec.getFabricante());
					tmp.setModeloeaexp(auxelec.getModelo());
					tmp.setNumserieeaexp(e.getNumserie());
					tmp.setFechaexplante(proc.getFecha());
					if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
						tmp.setIseaexp(true);
					if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
						tmp.setUnibieaexp(1);
					else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
						tmp.setUnibieaexp(0);
				} else if (e.getEstado() != 0 && e.getCamara()!=null && e.getCamara() == 949) { // VD
					tmp.setFechaimpeevxp(buscaFechaImplanteEaEvExp(e));
					Electrodos auxelec = UtilConversorTarjetaEuropea
							.buscaElectrodo(electrodos, e.getIdelectrodo());
					tmp.setFabevexp(auxelec.getFabricante());
					tmp.setModeloevexp(auxelec.getModelo());
					tmp.setNumserieevexp(e.getNumserie());
					tmp.setFechaexplante(proc.getFecha());
					if (auxelec.getConector()!=null && auxelec.getConector().equals("IS-1"))
						tmp.setIsevexp(true);
					if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("UNI"))
						tmp.setUnibievexp(1);
					else if (auxelec.getPolaridad()!=null && auxelec.getPolaridad().equals("BI"))
						tmp.setUnibievexp(0);
				} else if (e.getEstado() != 0 && e.getCamara()!=null && e.getCamara() == 949) {

				}
			}
		}
		
		tmp.setHospital(infocentro.getCentro());
		tmp.setDirhosp(infocentro.getDireccion());
		tmp.setCiudadhosp(infocentro.getCiudad());
		tmp.setTfnohosp(infocentro.getTelefono());
		
		return tmp;
	}
	private static Date buscaFechaImplanteEaEvExp(ImpImplanteElectrodos eaexp) {
		try {
			ImpImplanteElectrodosDao impelecdao = new ImpImplanteElectrodosDaoImpl();
			ImpImplanteElectrodos[] els = impelecdao.findByDynamicWhere("IDELECTRODO =? AND NUMSERIE = ?",
							new Object[] { eaexp.getIdelectrodo(),
									eaexp.getNumserie() });

			// Asumiendo numero de serie
			ImpImplanteDao impdao = new ImpImplanteDaoImpl();
			ImpImplante[] imps = impdao.findWhereIdhojaimpEquals(els[0]
					.getIdhojaimp());
			return imps[0].getFechaimplante();
		} catch (Exception e) {
			return null;
		}
	}
	private static ImpImplante buscaImplanteGenExp(ImpGenerador gexp) {
		try {
			ImpGeneradorDao gendao = new ImpGeneradorDaoImpl();
			ImpGenerador[] gens = gendao.findByDynamicWhere(
					"IDGENERADOR =? AND NUMSERIE = ?",
					new Object[] { gexp.getIdgenerador(), gexp.getNumserie() });
			
			// Asumiendo numero de serie
			ImpImplanteDao impdao = new ImpImplanteDaoImpl();
			ImpImplante[] imps = impdao.findWhereIdhojaimpEquals(gens[0].getIdhojaimp());
			return imps[0];
		} catch (Exception e) {
			return null;
		}

	}
	
}

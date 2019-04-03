package com.sorin.idea.iu;

import hvn.cm.modelo.Mensaje;

import java.util.ArrayList;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.TarjetaMP;

public class ControlMarcapasos extends BaseIU{


	private LoginForm lf;
	private String usuario = "";
	private ControlPacientes cp;
	private Date fecha;
	private ControlMaestras cm;
	private ArrMaestras[] centros;
	private String comentarios;
	private String modelomp;
	private String numseriemp;
	private Date fechaImplante;
	private ArrMaestras[] ops;
	private String med;
	private ArrMaestras[] sintomas;
	private ArrMaestras[] etiologia;
	private ArrMaestras[] indecg;
	private ArrMaestras[] fabricantes;
	private ArrMaestras[] modelogen;
	private ArrMaestras[] modeloelec;
	private ArrMaestras[] modoestim;
	private TarjetaMP obj;
	
	public void iniciaMarcapasos(ActionEvent e) {
		try {
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			this.cargaMaestras();
			this.obj = new TarjetaMP();
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,
								"No ha seleccionado paciente o no se ha podido recuperar.");
			} else {
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"No se puede recuperar el paciente seleccionado. Error: "
							+ e1.getMessage());
		}
	}
	
	public void cargaMaestras() {
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			this.centros = cm.getHospitalProcedencia();
			this.ops = cm.getPrimerOperador();
			
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"No se pueden recuperar los datos maestros. Error: "
							+ e1.getMessage());
		}
	}
	
	public void imprimeInformes(ActionEvent e){
		
		// Adaptacion de valores - fechas (YYYY-MM-DD), checboxes y radiobuttons
		
		
		
		/*if ((this.modelomp == null)||(this.numseriemp==null)) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Especifique modelo de MP y número de serie por favor");
		}else{*/		
			ConstructorPdf constructorPDF = new ConstructorPdf();
			String PathFicheroXml = "";
			GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());
			
			try {
				PathFicheroXml = generadorXML.imprimeInformeMP(this.obj, this.cp.pacienteSelect);
			}catch(Exception se){
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error generando documento,motivo: "
									+ se.getMessage(),
							"Error generando documento,Motivo: "
									+ se.getMessage());
				}catch (Exception e3){
				}
			}
			
			try {
				constructorPDF.generarArchivoPdf(FacesContext
						.getCurrentInstance(), PathFicheroXml,
						"TarjetaEuropeaPortadorMP-Todos.jasper");
			} catch (Exception se) {
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error imprimiendo documento,motivo: "
									+ se.getMessage(),
							"Error imprimiendo documento,Motivo: "
									+ se.getMessage());
				} catch (Exception e2) {
				}
			}
			
		//}
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getModelomp() {
		return modelomp;
	}

	public void setModelomp(String modelomp) {
		this.modelomp = modelomp;
	}

	public String getNumseriemp() {
		return numseriemp;
	}

	public void setNumseriemp(String numseriemp) {
		this.numseriemp = numseriemp;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFechaImplante() {
		return fechaImplante;
	}

	public void setFechaImplante(Date fechaImplante) {
		this.fechaImplante = fechaImplante;
	}

	public String getMed() {
		return med;
	}

	public void setMed(String med) {
		this.med = med;
	}
	
	public ArrayList<SelectItem> getOps() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "(Seleccione profesional)"));
		/*for (ArrMaestras ref : this.ops)
			diag.add(new SelectItem(ref.getValor(), ref.getValor()));*/
		diag.add(new SelectItem("Operador 1", "Operador 1"));
		diag.add(new SelectItem("Operador 2", "Operador 2"));
		return diag;
	}
	public ArrayList<SelectItem> getCentros() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "(Seleccione opción)"));
		/*for (ArrMaestras procedimiento : this.centros)
			diag.add(new SelectItem(procedimiento.getValor(),procedimiento.getValor()));*/
		
		diag.add(new SelectItem("Hospital Universitario Virgen de la Victoria", "Hospital Universitario Virgen de la Victoria"));
		diag.add(new SelectItem("Hospital Carlos Haya", "Hospital Carlos Haya"));
		diag.add(new SelectItem("Hospital Costa del Sol", "Hospital Costa del Sol"));
		diag.add(new SelectItem("Hospital Universitario Virgen de las Nieves", "Hospital Universitario Virgen de las Nieves"));
		
		return diag;
	}
	
	public ArrayList<SelectItem> getSintomas() {
		ArrayList<SelectItem> sintomas = new ArrayList<SelectItem>();
		sintomas.add(new SelectItem("  ", "(Seleccione opción)"));
		/*for (ArrMaestras procedimiento : this.mps)
			sintomas.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));*/
		
		sintomas.add(new SelectItem("A1", "No especificado"));
		sintomas.add(new SelectItem("A2", "Síntoma no codificado"));
		sintomas.add(new SelectItem("B1", "Síncope"));
		sintomas.add(new SelectItem("B2", "Mareos"));
		sintomas.add(new SelectItem("B3", "Bradicardia"));
		sintomas.add(new SelectItem("C1", "Taquicardia"));
		sintomas.add(new SelectItem("D1", "Profiláctico/asintomático"));
		sintomas.add(new SelectItem("D2", "Disnea/Insuficiencia cardiaca"));
		sintomas.add(new SelectItem("D3", "Disfunción cerebral"));
		sintomas.add(new SelectItem("D4", "Dolores pecho"));
		sintomas.add(new SelectItem("D5", "Muerte súbita resucitada"));
		
		return sintomas;
	}
	public ArrayList<SelectItem> getEtiologia() {
		ArrayList<SelectItem> et = new ArrayList<SelectItem>();
		et.add(new SelectItem("  ", "(Seleccione opción)"));
		/*for (ArrMaestras procedimiento : this.mps)
			sintomas.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));*/
		
		et.add(new SelectItem("A1", "No especificado (ausencia)"));
		et.add(new SelectItem("A2", "No codificado"));
		et.add(new SelectItem("B1", "Etiología desconocida"));
		et.add(new SelectItem("B2", "Fibrosis del sistema de conducción"));
		et.add(new SelectItem("C1", "Isquémica"));
		et.add(new SelectItem("C2", "Post-infarto"));
		et.add(new SelectItem("D1", "Congénita"));
		et.add(new SelectItem("E1", "Complicación quirúrjica"));
		et.add(new SelectItem("E2", "Quirúrjica"));
		et.add(new SelectItem("E3", "Ablación"));
		et.add(new SelectItem("E4", "Medicación"));
		et.add(new SelectItem("F1", "Síndrome del seno carotídeo"));
		et.add(new SelectItem("F2", "Síndrome vasovagal"));
		et.add(new SelectItem("F3", "Hipotensión ortostática"));
		et.add(new SelectItem("G1", "Miocardiopatía-no especificada"));
		et.add(new SelectItem("GA", "Miocardiopatía hipertrófica"));
		et.add(new SelectItem("GB", "Miocardiopatía dilatada"));
		et.add(new SelectItem("G2", "Miocarditis"));
		et.add(new SelectItem("G3", "Lesión valvular"));
		et.add(new SelectItem("G4", "Endocarditis"));
		et.add(new SelectItem("G7", "Transplante cardíaco"));
		et.add(new SelectItem("G8", "Radiaciones ionizantes"));
		
		return et;
	}
	public ArrayList<SelectItem> getIndecg() {
		ArrayList<SelectItem> ecg = new ArrayList<SelectItem>();
		ecg.add(new SelectItem("   ", "(Seleccione opción)"));
		/*for (ArrMaestras procedimiento : this.mps)
			sintomas.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));*/
		
		ecg.add(new SelectItem("A01", "Ritmo no especificado (ausencia)"));
		ecg.add(new SelectItem("A02", "Ritmo no codificado"));
		ecg.add(new SelectItem("B01", "Ritmo sinusal normal (RSN)"));
		ecg.add(new SelectItem("B02", "RSN + anomalías EF"));
		ecg.add(new SelectItem("C01", "BAV de 1er grado"));
		ecg.add(new SelectItem("C02", "BAV de 2º grado sin especificar"));
		ecg.add(new SelectItem("C03", "BAV de 2º grado Wenckebach"));
		ecg.add(new SelectItem("C04", "BAV de 2º grado Mobitz"));
		ecg.add(new SelectItem("C05", "BAV de 3er grado con QRS sin especificar"));
		ecg.add(new SelectItem("C06", "BAV de 3er grado con QRS estrecho"));
		ecg.add(new SelectItem("C07", "BAV de 3er grado con QRS ancho"));
		ecg.add(new SelectItem("C08", "FA crónica + BAV"));
		
		ecg.add(new SelectItem("D01", "BR sin especificar"));
		ecg.add(new SelectItem("D02", "BR derecha (D) incompleto"));
		ecg.add(new SelectItem("D03", "BRD completo"));
		ecg.add(new SelectItem("D04", "BRD izquierda (I) completo"));
		ecg.add(new SelectItem("D05", "Hemibloqueo anterior izquierdo (HAI)"));
		ecg.add(new SelectItem("D06", "Hemibloqueo poster. izquierdo (HPI)"));
		ecg.add(new SelectItem("D07", "BRD + HAI + intervalo PR normal"));
		ecg.add(new SelectItem("D08", "BRD + HPI + intervalo PR normal"));
		ecg.add(new SelectItem("D09", "BRD + HAI + intervalo PR largo"));
		ecg.add(new SelectItem("D10", "BRD + HPI + intervalo PR largo"));
		ecg.add(new SelectItem("D11", "BRI + intervalo PR largo"));
		ecg.add(new SelectItem("D12", "BRI/BRD(alternante)"));
		
		ecg.add(new SelectItem("E01", "SSS sin especificar"));
		ecg.add(new SelectItem("E02", "SSS con bloqueo de salida sino-auricular(SA)"));
		ecg.add(new SelectItem("E03", "SSS con parada SA"));
		ecg.add(new SelectItem("E04", "SSS con bradicardia"));
		ecg.add(new SelectItem("E05", "SSS con bradi-taquicardia"));
		ecg.add(new SelectItem("E06", "FA crónica + bradicardia"));
		ecg.add(new SelectItem("E07", "Bloqueo interauricular"));
		ecg.add(new SelectItem("E08", "Incompetencia cronotrópica"));
			
		ecg.add(new SelectItem("F01", "Taquicardia auricular - n.e."));
		ecg.add(new SelectItem("F02", "Taquicardia AV por re-entrada"));
		ecg.add(new SelectItem("F03", "Taquicardia de la unción"));
		ecg.add(new SelectItem("G01", "Extrasistolia ventricular"));
		ecg.add(new SelectItem("G02", "TV/FV no sostenida"));
		ecg.add(new SelectItem("G03", "TV/FV sostenida"));
		ecg.add(new SelectItem("G04", "Torsade de pointe"));
		
		return ecg;
	}

	public ArrayList<SelectItem> getFabricantes() {
		ArrayList<SelectItem> fab = new ArrayList<SelectItem>();
		fab.add(new SelectItem("0", "(Seleccione opción)"));
		/*for (ArrMaestras procedimiento : this.mps)
			sintomas.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));*/
		
		fab.add(new SelectItem("Sorin", "Sorin"));
		
		return fab;
	}
	public ArrayList<SelectItem> getModelogen() {
		ArrayList<SelectItem> fab = new ArrayList<SelectItem>();
		fab.add(new SelectItem("0", "(Seleccione opción)"));
		/*for (ArrMaestras procedimiento : this.mps)
			sintomas.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));*/
		
		fab.add(new SelectItem("Reply DR", "Reply DR"));
		
		return fab;
	}
	public ArrayList<SelectItem> getModeloelect() {
		ArrayList<SelectItem> fab = new ArrayList<SelectItem>();
		fab.add(new SelectItem("0", "(Seleccione opción)"));
		/*for (ArrMaestras procedimiento : this.mps)
			sintomas.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));*/
		
		fab.add(new SelectItem("TILDA R45", "TILDA R45"));
		fab.add(new SelectItem("TILDA T60", "TILDA T60"));
		
		return fab;
	}
	
	public ArrayList<SelectItem> getModoestim() {
		ArrayList<SelectItem> fab = new ArrayList<SelectItem>();
		fab.add(new SelectItem("0", "(Seleccione opción)"));
		/*for (ArrMaestras procedimiento : this.mps)
			sintomas.add(new SelectItem(procedimiento.getCodigo().toString(),procedimiento.getValor()));*/
		
		fab.add(new SelectItem("VDD", "VDD"));
		
		return fab;
	}
	
	public TarjetaMP getObj() {
		return obj;
	}

	public void setObj(TarjetaMP obj) {
		this.obj = obj;
	}
	
}

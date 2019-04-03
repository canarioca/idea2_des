package com.sorin.idea.util;
/**
 * Clase Bean contenedora de informacion para generar informes de consentimiento
 * @author Francisco.Romera
 *
 */
public class ConsentimientoBean {

	private String doctor;
	private String numcolegiado;
	private String repleg_nombre;
	private String repleg_ap1;
	private String repleg_ap2;
	private String repleg_dni;
	private String riesgos;
	private String indicacion;
	
	public ConsentimientoBean(){
		
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getRepleg_nombre() {
		return repleg_nombre;
	}

	public void setRepleg_nombre(String repleg_nombre) {
		this.repleg_nombre = repleg_nombre;
	}

	public String getRepleg_ap1() {
		return repleg_ap1;
	}

	public void setRepleg_ap1(String repleg_ap1) {
		this.repleg_ap1 = repleg_ap1;
	}

	public String getRepleg_ap2() {
		return repleg_ap2;
	}

	public void setRepleg_ap2(String repleg_ap2) {
		this.repleg_ap2 = repleg_ap2;
	}

	public String getRepleg_dni() {
		return repleg_dni;
	}

	public void setRepleg_dni(String repleg_dni) {
		this.repleg_dni = repleg_dni;
	}

	public String getRiesgos() {
		return riesgos;
	}

	public void setRiesgos(String riesgos) {
		this.riesgos = riesgos;
	}

	public String getIndicacion() {
		return indicacion;
	}

	public void setIndicacion(String indicacion) {
		this.indicacion = indicacion;
	}

	public String getNumcolegiado() {
		return numcolegiado;
	}

	public void setNumcolegiado(String numcolegiado) {
		this.numcolegiado = numcolegiado;
	}
}

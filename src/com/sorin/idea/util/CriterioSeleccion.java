package com.sorin.idea.util;

import java.util.Date;

public class CriterioSeleccion {

	private String clase;
	private String nombre;
	private int tipo;// 1 = int, 2 = string, 3 = date, 4 = short
	private int maxInt;
	private int minInt;
	private int valorInt;
	private Date fechaIni;	
	private Date fechaFin;
	private Date fecha;
	private String minStr;
	private String maxStr;
	private String valorStr;
	private int operacion; // 1 =, 2 <, 3 <=, 4 >, 5 >=
	
	private String tabla;
	
	public CriterioSeleccion(String clase,String nombre){
		this.setClase(clase);
		this.setNombre(nombre);
		// asignar tipo de dato en funcion de la clase?
	}
	
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getMaxInt() {
		return maxInt;
	}
	public void setMaxInt(int maxInt) {
		this.maxInt = maxInt;
	}
	public int getMinInt() {
		return minInt;
	}
	public void setMinInt(int minInt) {
		this.minInt = minInt;
	}
	public int getValorInt() {
		return valorInt;
	}
	public void setValorInt(int valorInt) {
		this.valorInt = valorInt;
	}
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getMinStr() {
		return minStr;
	}
	public void setMinStr(String minStr) {
		this.minStr = minStr;
	}
	public String getMaxStr() {
		return maxStr;
	}
	public void setMaxStr(String maxStr) {
		this.maxStr = maxStr;
	}
	public String getValorStr() {
		return valorStr;
	}
	public void setValorStr(String valorStr) {
		this.valorStr = valorStr;
	}
	public int getOperacion() {
		return operacion;
	}
	public void setOperacion(int operacion) {
		this.operacion = operacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
}

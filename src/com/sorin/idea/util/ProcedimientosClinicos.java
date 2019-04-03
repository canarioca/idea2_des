package com.sorin.idea.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ProcedimientosClinicos {

	private String start; // fecha de procedimiento en formato texto
	private String content;// valido para linea temporal de eventos
	
	private Integer tipoproc;
	private Date fecha;
	private String obs;
	
	public ProcedimientosClinicos(){		
	}
	
	public ProcedimientosClinicos(Date d, String p, Integer tipo, String com){
		this.content = p;
		// Restamos un mes para poner la fecha adecuada - Recordar que Date pone un mes de mas...	
		DateFormat DF = new SimpleDateFormat("yyyy/MM/dd");
		this.start = UtilDatos.formateaJSON(DF.format(d));
		this.tipoproc = tipo;
		this.fecha = d;
		this.obs = com;
	}
	
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Integer getTipoproc() {
		return tipoproc;
	}

	public void setTipoproc(Integer tipoproc) {
		this.tipoproc = tipoproc;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
}

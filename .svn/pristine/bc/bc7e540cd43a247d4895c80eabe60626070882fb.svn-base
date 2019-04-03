package com.sorin.idea.util;

import java.util.Date;

public class NotasPreviasBean {

	private Date fecha;
	private Integer tipoproc;
	private String tipoprocstr;
	private String comentarios;
	
	public NotasPreviasBean(){
		
	}

	public NotasPreviasBean(Date f, Integer tp,String c1, String c2){
		this.fecha = f;
		this.tipoproc = tp;
		this.tipoprocstr = UtilMapeos.mapeoTipoProcedimiento(tp);
		this.comentarios = (c1!=null?c1+". ":"")+(c2!=null?c2:"");
	}
	
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Integer getTipoproc() {
		return tipoproc;
	}

	public void setTipoproc(Integer tipoproc) {
		this.tipoproc = tipoproc;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getTipoprocstr() {
		return tipoprocstr;
	}

	public void setTipoprocstr(String tipoprocstr) {
		this.tipoprocstr = tipoprocstr;
	}
	
}

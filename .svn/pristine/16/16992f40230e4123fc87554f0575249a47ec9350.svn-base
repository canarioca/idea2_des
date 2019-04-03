package com.sorin.idea.iu.gestor;

import java.util.Date;

import jcifs.smb.SmbFile;

/**
 * Bean contenedor de informacion para mostrar en formulario
 * @author Francisco.Romera
 *
 */
public class SmbDto {

	private String nombre;
	private Date fecha;
	private SmbFile sFile;
	
	public SmbDto(){
		
	}
	
	public SmbDto(String n, SmbFile s, Date f){
		this.nombre = n;
		this.sFile = s;
		this.fecha = f;
	}
	
	public SmbDto(String n, SmbFile s){
		this.nombre = n;
		this.sFile = s;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public SmbFile getsFile() {
		return sFile;
	}
	public void setsFile(SmbFile sFile) {
		this.sFile = sFile;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}

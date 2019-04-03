package com.sorin.idea.dto;

import com.sorin.idea.util.UtilCodifi;

import hvn.cm.modelo.dto.BaseDto;
//mmb
public class DatoEstAnual extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2307322464387461360L;
	String tipo;
	public Integer[] valor;
	public Float[] valorf;
	Integer total;
	boolean esTipoInteger;
	
	public DatoEstAnual(String tipo,Integer[] valor){
		this.tipo =tipo;
		this.valor = valor;
		iniTotal();
		this.esTipoInteger = true;
	}
	
	public DatoEstAnual(String tipo,Float[] valor){
		this.tipo =tipo;
		this.valorf = valor;
		this.esTipoInteger = false;
	}

	
	public DatoEstAnual(String tipo){
		this.tipo =tipo;
		valor = new Integer[12];
		esTipoInteger = true;
		iniVacios();
	}
		
	public DatoEstAnual(){
		tipo ="";
		valor = new Integer[12];
		iniVacios();		
		this.esTipoInteger = true;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer[] getValor() {
		return valor;
	}

	public void setValor(Integer[] valor) {
		this.valor = valor;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
	public void iniVacios(){
		this.total =0;
		for (int i = 0;i<12;i++){
			this.valor[i]=new Integer(0);
		}
	}
	
	public void iniTotal(){
		this.total =0;
		for (Integer i: this.getValor()){
			total += UtilCodifi.parserInteger(i);
		}
	}
	
	public Integer iniSubTotal(Integer tope){
		Integer sub = 0;
		for (int i=0;i<=tope;i++)
			sub+=UtilCodifi.parserInteger(this.valor[i]);
		
		return sub;
	}

	
	public Float iniMedia(){
		Float sub = new Float(0);
		for (int i=0;i<this.valorf.length;i++)
			sub+=UtilCodifi.parserFloat(this.valorf[i]);
		
		if (this.valorf.length > 0)
			return sub/this.valorf.length;
		else 
			return new Float(0);
		
		
	
	}


	public boolean isEsTipoInteger() {
		return esTipoInteger;
	}


	public void setEsTipoInteger(boolean esTipoInteger) {
		this.esTipoInteger = esTipoInteger;
	}
	
	
	
}

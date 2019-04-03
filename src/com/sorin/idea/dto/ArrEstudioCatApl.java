/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.dto;

import com.sorin.idea.dao.*;
import com.sorin.idea.factory.*;
import com.sorin.idea.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class ArrEstudioCatApl implements Serializable
{
	/** 
	 * This attribute maps to the column IDABLACION in the arr_estudio_cat_apl table.
	 */
	protected Integer idablacion;

	/** 
	 * This attribute maps to the column IDCATUSO in the arr_estudio_cat_apl table.
	 */
	protected Integer idcatuso;

	/** 
	 * This attribute maps to the column IDVIA in the arr_estudio_cat_apl table.
	 */
	protected Integer idvia;

	/** 
	 * This attribute maps to the column TIEMPO in the arr_estudio_cat_apl table.
	 */
	protected String tiempo;

	/** 
	 * This attribute maps to the column POTENCIA in the arr_estudio_cat_apl table.
	 */
	protected String potencia;

	/** 
	 * This attribute maps to the column IMPEDANCIA in the arr_estudio_cat_apl table.
	 */
	protected String impedancia;

	protected String modelo;
	protected Integer idcateteruso;
	protected Integer energia;
	
	/**
	 * Method 'ArrEstudioCatApl'
	 * 
	 */
	public ArrEstudioCatApl()
	{
	}
	public ArrEstudioCatApl(Integer idvia)
	{
		this.setIdvia(idvia);
	}

	/**
	 * Method 'getIdablacion'
	 * 
	 * @return Integer
	 */
	public Integer getIdablacion()
	{
		return idablacion;
	}

	/**
	 * Method 'setIdablacion'
	 * 
	 * @param idablacion
	 */
	public void setIdablacion(Integer idablacion)
	{
		this.idablacion = idablacion;
	}

	/**
	 * Method 'getIdcatuso'
	 * 
	 * @return Integer
	 */
	public Integer getIdcatuso()
	{
		return idcatuso;
	}

	/**
	 * Method 'setIdcatuso'
	 * 
	 * @param idcatuso
	 */
	public void setIdcatuso(Integer idcatuso)
	{
		this.idcatuso = idcatuso;
	}

	/**
	 * Method 'getIdvia'
	 * 
	 * @return Integer
	 */
	public Integer getIdvia()
	{
		return idvia;
	}

	/**
	 * Method 'setIdvia'
	 * 
	 * @param idvia
	 */
	public void setIdvia(Integer idvia)
	{
		this.idvia = idvia;
	}

	/**
	 * Method 'getTiempo'
	 * 
	 * @return String
	 */
	public String getTiempo()
	{
		return tiempo;
	}

	/**
	 * Method 'setTiempo'
	 * 
	 * @param tiempo
	 */
	public void setTiempo(String tiempo)
	{
		this.tiempo = tiempo;
	}

	/**
	 * Method 'getPotencia'
	 * 
	 * @return String
	 */
	public String getPotencia()
	{
		return potencia;
	}

	/**
	 * Method 'setPotencia'
	 * 
	 * @param potencia
	 */
	public void setPotencia(String potencia)
	{
		this.potencia = potencia;
	}

	/**
	 * Method 'getImpedancia'
	 * 
	 * @return String
	 */
	public String getImpedancia()
	{
		return impedancia;
	}

	/**
	 * Method 'setImpedancia'
	 * 
	 * @param impedancia
	 */
	public void setImpedancia(String impedancia)
	{
		this.impedancia = impedancia;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof ArrEstudioCatApl)) {
			return false;
		}
		
		final ArrEstudioCatApl _cast = (ArrEstudioCatApl) _other;
		if (idablacion == null ? _cast.idablacion != idablacion : !idablacion.equals( _cast.idablacion )) {
			return false;
		}
		
		if (idcatuso == null ? _cast.idcatuso != idcatuso : !idcatuso.equals( _cast.idcatuso )) {
			return false;
		}
		
		if (idvia == null ? _cast.idvia != idvia : !idvia.equals( _cast.idvia )) {
			return false;
		}
		
		if (tiempo == null ? _cast.tiempo != tiempo : !tiempo.equals( _cast.tiempo )) {
			return false;
		}
		
		if (potencia == null ? _cast.potencia != potencia : !potencia.equals( _cast.potencia )) {
			return false;
		}
		
		if (impedancia == null ? _cast.impedancia != impedancia : !impedancia.equals( _cast.impedancia )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (idablacion != null) {
			_hashCode = 29 * _hashCode + idablacion.hashCode();
		}
		
		if (idcatuso != null) {
			_hashCode = 29 * _hashCode + idcatuso.hashCode();
		}
		
		if (idvia != null) {
			_hashCode = 29 * _hashCode + idvia.hashCode();
		}
		
		if (tiempo != null) {
			_hashCode = 29 * _hashCode + tiempo.hashCode();
		}
		
		if (potencia != null) {
			_hashCode = 29 * _hashCode + potencia.hashCode();
		}
		
		if (impedancia != null) {
			_hashCode = 29 * _hashCode + impedancia.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return ArrEstudioCatAplPk
	 */
	public ArrEstudioCatAplPk createPk()
	{
		return new ArrEstudioCatAplPk(idablacion, idcatuso, idvia);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.sorin.idea.dto.ArrEstudioCatApl: " );
		ret.append( "idablacion=" + idablacion );
		ret.append( ", idcatuso=" + idcatuso );
		ret.append( ", idvia=" + idvia );
		ret.append( ", tiempo=" + tiempo );
		ret.append( ", potencia=" + potencia );
		ret.append( ", impedancia=" + impedancia );
		return ret.toString();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getIdcateteruso() {
		return idcateteruso;
	}

	public void setIdcateteruso(Integer idcateter) {
		this.idcateteruso = idcateter;
	}

	public Integer getEnergia() {
		return energia;
	}

	public void setEnergia(Integer energia) {
		this.energia = energia;
	}

}
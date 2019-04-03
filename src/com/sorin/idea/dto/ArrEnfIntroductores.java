/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.dto;

import java.io.Serializable;
import java.util.*;

import com.sorin.idea.dao.*;
import com.sorin.idea.exceptions.*;
import com.sorin.idea.factory.*;

public class ArrEnfIntroductores implements Serializable
{
	/** 
	 * This attribute maps to the column ID_REG in the ARR_ENF_INTRODUCTORES table.
	 */
	protected Integer idReg;

	/** 
	 * This attribute maps to the column NUMERO in the ARR_ENF_INTRODUCTORES table.
	 */
	protected String numero;

	/** 
	 * This attribute maps to the column CALIBRE in the ARR_ENF_INTRODUCTORES table.
	 */
	protected String calibre;

	/** 
	 * This attribute maps to the column TIPO in the ARR_ENF_INTRODUCTORES table.
	 */
	protected String tipo;

	/**
	 * Method 'ArrEnfIntroductores'
	 * 
	 */
	public ArrEnfIntroductores()
	{
	}

	/**
	 * Method 'getIdReg'
	 * 
	 * @return Integer
	 */
	public Integer getIdReg()
	{
		return idReg;
	}

	/**
	 * Method 'setIdReg'
	 * 
	 * @param idReg
	 */
	public void setIdReg(Integer idReg)
	{
		this.idReg = idReg;
	}

	/**
	 * Method 'getNumero'
	 * 
	 * @return String
	 */
	public String getNumero()
	{
		return numero;
	}

	/**
	 * Method 'setNumero'
	 * 
	 * @param numero
	 */
	public void setNumero(String numero)
	{
		this.numero = numero;
	}

	/**
	 * Method 'getCalibre'
	 * 
	 * @return String
	 */
	public String getCalibre()
	{
		return calibre;
	}

	/**
	 * Method 'setCalibre'
	 * 
	 * @param calibre
	 */
	public void setCalibre(String calibre)
	{
		this.calibre = calibre;
	}

	/**
	 * Method 'getTipo'
	 * 
	 * @return String
	 */
	public String getTipo()
	{
		return tipo;
	}

	/**
	 * Method 'setTipo'
	 * 
	 * @param tipo
	 */
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
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
		
		if (!(_other instanceof ArrEnfIntroductores)) {
			return false;
		}
		
		final ArrEnfIntroductores _cast = (ArrEnfIntroductores) _other;
		if (idReg == null ? _cast.idReg != idReg : !idReg.equals( _cast.idReg )) {
			return false;
		}
		
		if (numero == null ? _cast.numero != numero : !numero.equals( _cast.numero )) {
			return false;
		}
		
		if (calibre == null ? _cast.calibre != calibre : !calibre.equals( _cast.calibre )) {
			return false;
		}
		
		if (tipo == null ? _cast.tipo != tipo : !tipo.equals( _cast.tipo )) {
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
		if (idReg != null) {
			_hashCode = 29 * _hashCode + idReg.hashCode();
		}
		
		if (numero != null) {
			_hashCode = 29 * _hashCode + numero.hashCode();
		}
		
		if (calibre != null) {
			_hashCode = 29 * _hashCode + calibre.hashCode();
		}
		
		if (tipo != null) {
			_hashCode = 29 * _hashCode + tipo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "hvn.apl.jProyecto2011.dto.ArrEnfIntroductores: " );
		ret.append( "idReg=" + idReg );
		ret.append( ", numero=" + numero );
		ret.append( ", calibre=" + calibre );
		ret.append( ", tipo=" + tipo );
		return ret.toString();
	}

}
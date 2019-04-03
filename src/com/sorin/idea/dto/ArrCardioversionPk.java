/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the ARR_CARDIOVERSION table.
 */
public class ArrCardioversionPk implements Serializable
{
	protected Integer codigoPaciente;

	protected Integer codigoCardioversion;

	/** 
	 * Sets the value of codigoPaciente
	 */
	public void setCodigoPaciente(Integer codigoPaciente)
	{
		this.codigoPaciente = codigoPaciente;
	}

	/** 
	 * Gets the value of codigoPaciente
	 */
	public Integer getCodigoPaciente()
	{
		return codigoPaciente;
	}

	/** 
	 * Sets the value of codigoCardioversion
	 */
	public void setCodigoCardioversion(Integer codigoCardioversion)
	{
		this.codigoCardioversion = codigoCardioversion;
	}

	/** 
	 * Gets the value of codigoCardioversion
	 */
	public Integer getCodigoCardioversion()
	{
		return codigoCardioversion;
	}

	/**
	 * Method 'ArrCardioversionPk'
	 * 
	 */
	public ArrCardioversionPk()
	{
	}

	/**
	 * Method 'ArrCardioversionPk'
	 * 
	 * @param codigoPaciente
	 * @param codigoCardioversion
	 */
	public ArrCardioversionPk(final Integer codigoPaciente, final Integer codigoCardioversion)
	{
		this.codigoPaciente = codigoPaciente;
		this.codigoCardioversion = codigoCardioversion;
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
		
		if (!(_other instanceof ArrCardioversionPk)) {
			return false;
		}
		
		final ArrCardioversionPk _cast = (ArrCardioversionPk) _other;
		if (codigoPaciente == null ? _cast.codigoPaciente != codigoPaciente : !codigoPaciente.equals( _cast.codigoPaciente )) {
			return false;
		}
		
		if (codigoCardioversion == null ? _cast.codigoCardioversion != codigoCardioversion : !codigoCardioversion.equals( _cast.codigoCardioversion )) {
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
		if (codigoPaciente != null) {
			_hashCode = 29 * _hashCode + codigoPaciente.hashCode();
		}
		
		if (codigoCardioversion != null) {
			_hashCode = 29 * _hashCode + codigoCardioversion.hashCode();
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
		ret.append( "hvn.apl.jProyecto2011.dto.ArrCardioversionPk: " );
		ret.append( "codigoPaciente=" + codigoPaciente );
		ret.append( ", codigoCardioversion=" + codigoCardioversion );
		return ret.toString();
	}

}
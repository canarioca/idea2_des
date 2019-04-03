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
 * This class represents the primary key of the ARR_ESTUDIO_SOP table.
 */
public class ArrEstudioSopPk implements Serializable
{
	protected Integer idestudio;

	/** 
	 * Sets the value of idestudio
	 */
	public void setIdestudio(Integer idestudio)
	{
		this.idestudio = idestudio;
	}

	/** 
	 * Gets the value of idestudio
	 */
	public Integer getIdestudio()
	{
		return idestudio;
	}

	/**
	 * Method 'ArrEstudioSopPk'
	 * 
	 */
	public ArrEstudioSopPk()
	{
	}

	/**
	 * Method 'ArrEstudioSopPk'
	 * 
	 * @param idestudio
	 */
	public ArrEstudioSopPk(final Integer idestudio)
	{
		this.idestudio = idestudio;
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
		
		if (!(_other instanceof ArrEstudioSopPk)) {
			return false;
		}
		
		final ArrEstudioSopPk _cast = (ArrEstudioSopPk) _other;
		if (idestudio == null ? _cast.idestudio != idestudio : !idestudio.equals( _cast.idestudio )) {
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
		if (idestudio != null) {
			_hashCode = 29 * _hashCode + idestudio.hashCode();
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
		ret.append( "hvn.apl.jProyecto2011.dto.ArrEstudioSopPk: " );
		ret.append( "idestudio=" + idestudio );
		return ret.toString();
	}

}

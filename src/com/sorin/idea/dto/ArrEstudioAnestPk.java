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
 * This class represents the primary key of the arr_estudio_anest table.
 */
public class ArrEstudioAnestPk implements Serializable
{
	protected Integer idestudio;

	protected String idanestesista;

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
	 * Sets the value of idanestesista
	 */
	public void setIdanestesista(String idanestesista)
	{
		this.idanestesista = idanestesista;
	}

	/** 
	 * Gets the value of idanestesista
	 */
	public String getIdanestesista()
	{
		return idanestesista;
	}

	/**
	 * Method 'ArrEstudioAnestPk'
	 * 
	 */
	public ArrEstudioAnestPk()
	{
	}

	/**
	 * Method 'ArrEstudioAnestPk'
	 * 
	 * @param idestudio
	 * @param idanestesista
	 */
	public ArrEstudioAnestPk(final Integer idestudio, final String idanestesista)
	{
		this.idestudio = idestudio;
		this.idanestesista = idanestesista;
	}
	public ArrEstudioAnestPk(final Integer idestudio)
	{
		this.idestudio = idestudio;
		//this.idanestesista = idanestesista;
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
		
		if (!(_other instanceof ArrEstudioAnestPk)) {
			return false;
		}
		
		final ArrEstudioAnestPk _cast = (ArrEstudioAnestPk) _other;
		if (idestudio == null ? _cast.idestudio != idestudio : !idestudio.equals( _cast.idestudio )) {
			return false;
		}
		
		if (idanestesista == null ? _cast.idanestesista != idanestesista : !idanestesista.equals( _cast.idanestesista )) {
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
		
		if (idanestesista != null) {
			_hashCode = 29 * _hashCode + idanestesista.hashCode();
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
		ret.append( "com.sorin.idea.dto.ArrEstudioAnestPk: " );
		ret.append( "idestudio=" + idestudio );
		ret.append( ", idanestesista=" + idanestesista );
		return ret.toString();
	}

}
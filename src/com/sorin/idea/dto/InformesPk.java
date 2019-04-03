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
 * This class represents the primary key of the informes table.
 */
public class InformesPk implements Serializable
{
	protected Integer idinf;

	/** 
	 * Sets the value of idinf
	 */
	public void setIdinf(Integer idinf)
	{
		this.idinf = idinf;
	}

	/** 
	 * Gets the value of idinf
	 */
	public Integer getIdinf()
	{
		return idinf;
	}

	/**
	 * Method 'InformesPk'
	 * 
	 */
	public InformesPk()
	{
	}

	/**
	 * Method 'InformesPk'
	 * 
	 * @param idinf
	 */
	public InformesPk(final Integer idinf)
	{
		this.idinf = idinf;
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
		
		if (!(_other instanceof InformesPk)) {
			return false;
		}
		
		final InformesPk _cast = (InformesPk) _other;
		if (idinf == null ? _cast.idinf != idinf : !idinf.equals( _cast.idinf )) {
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
		if (idinf != null) {
			_hashCode = 29 * _hashCode + idinf.hashCode();
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
		ret.append( "com.sorin.idea.dto.InformesPk: " );
		ret.append( "idinf=" + idinf );
		return ret.toString();
	}

}

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
 * This class represents the primary key of the ARR_TEST_EPI_ECG table.
 */
public class ArrTestEpiEcgPk implements Serializable
{
	protected Integer idtest;

	/** 
	 * Sets the value of idtest
	 */
	public void setIdtest(Integer idtest)
	{
		this.idtest = idtest;
	}

	/** 
	 * Gets the value of idtest
	 */
	public Integer getIdtest()
	{
		return idtest;
	}

	/**
	 * Method 'ArrTestEpiEcgPk'
	 * 
	 */
	public ArrTestEpiEcgPk()
	{
	}

	/**
	 * Method 'ArrTestEpiEcgPk'
	 * 
	 * @param idtest
	 */
	public ArrTestEpiEcgPk(final Integer idtest)
	{
		this.idtest = idtest;
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
		
		if (!(_other instanceof ArrTestEpiEcgPk)) {
			return false;
		}
		
		final ArrTestEpiEcgPk _cast = (ArrTestEpiEcgPk) _other;
		if (idtest == null ? _cast.idtest != idtest : !idtest.equals( _cast.idtest )) {
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
		if (idtest != null) {
			_hashCode = 29 * _hashCode + idtest.hashCode();
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
		ret.append( "hvn.apl.jProyecto2011.dto.ArrTestEpiEcgPk: " );
		ret.append( "idtest=" + idtest );
		return ret.toString();
	}

}
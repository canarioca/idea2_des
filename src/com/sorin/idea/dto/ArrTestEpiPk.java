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
 * This class represents the primary key of the ARR_TEST_EPI table.
 */
public class ArrTestEpiPk implements Serializable
{
	protected Integer codigoTest;

	/** 
	 * Sets the value of codigoTest
	 */
	public void setCodigoTest(Integer codigoTest)
	{
		this.codigoTest = codigoTest;
	}

	/** 
	 * Gets the value of codigoTest
	 */
	public Integer getCodigoTest()
	{
		return codigoTest;
	}

	/**
	 * Method 'ArrTestEpiPk'
	 * 
	 */
	public ArrTestEpiPk()
	{
	}

	/**
	 * Method 'ArrTestEpiPk'
	 * 
	 * @param codigoTest
	 */
	public ArrTestEpiPk(final Integer codigoTest)
	{
		this.codigoTest = codigoTest;
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
		
		if (!(_other instanceof ArrTestEpiPk)) {
			return false;
		}
		
		final ArrTestEpiPk _cast = (ArrTestEpiPk) _other;
		if (codigoTest == null ? _cast.codigoTest != codigoTest : !codigoTest.equals( _cast.codigoTest )) {
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
		if (codigoTest != null) {
			_hashCode = 29 * _hashCode + codigoTest.hashCode();
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
		ret.append( "hvn.apl.jProyecto2011.dto.ArrTestEpiPk: " );
		ret.append( "codigoTest=" + codigoTest );
		return ret.toString();
	}

}
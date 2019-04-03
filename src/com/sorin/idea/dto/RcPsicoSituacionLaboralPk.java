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
 * This class represents the primary key of the RC_PSICO_SITUACION_LABORAL table.
 */
public class RcPsicoSituacionLaboralPk implements Serializable
{
	protected long idSituacionLaboral;

	/** 
	 * This attribute represents whether the primitive attribute idSituacionLaboral is null.
	 */
	protected boolean idSituacionLaboralNull;

	/** 
	 * Sets the value of idSituacionLaboral
	 */
	public void setIdSituacionLaboral(long idSituacionLaboral)
	{
		this.idSituacionLaboral = idSituacionLaboral;
	}

	/** 
	 * Gets the value of idSituacionLaboral
	 */
	public long getIdSituacionLaboral()
	{
		return idSituacionLaboral;
	}

	/**
	 * Method 'RcPsicoSituacionLaboralPk'
	 * 
	 */
	public RcPsicoSituacionLaboralPk()
	{
	}

	/**
	 * Method 'RcPsicoSituacionLaboralPk'
	 * 
	 * @param idSituacionLaboral
	 */
	public RcPsicoSituacionLaboralPk(final long idSituacionLaboral)
	{
		this.idSituacionLaboral = idSituacionLaboral;
	}

	/** 
	 * Sets the value of idSituacionLaboralNull
	 */
	public void setIdSituacionLaboralNull(boolean idSituacionLaboralNull)
	{
		this.idSituacionLaboralNull = idSituacionLaboralNull;
	}

	/** 
	 * Gets the value of idSituacionLaboralNull
	 */
	public boolean isIdSituacionLaboralNull()
	{
		return idSituacionLaboralNull;
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
		
		if (!(_other instanceof RcPsicoSituacionLaboralPk)) {
			return false;
		}
		
		final RcPsicoSituacionLaboralPk _cast = (RcPsicoSituacionLaboralPk) _other;
		if (idSituacionLaboral != _cast.idSituacionLaboral) {
			return false;
		}
		
		if (idSituacionLaboralNull != _cast.idSituacionLaboralNull) {
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
		_hashCode = 29 * _hashCode + (int) (idSituacionLaboral ^ (idSituacionLaboral >>> 32));
		_hashCode = 29 * _hashCode + (idSituacionLaboralNull ? 1 : 0);
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
		ret.append( "com.sorin.idea.dto.RcPsicoSituacionLaboralPk: " );
		ret.append( "idSituacionLaboral=" + idSituacionLaboral );
		return ret.toString();
	}

}
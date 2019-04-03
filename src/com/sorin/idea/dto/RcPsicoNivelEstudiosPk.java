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
 * This class represents the primary key of the RC_PSICO_NIVEL_ESTUDIOS table.
 */
public class RcPsicoNivelEstudiosPk implements Serializable
{
	protected long idNivelEstudios;

	/** 
	 * This attribute represents whether the primitive attribute idNivelEstudios is null.
	 */
	protected boolean idNivelEstudiosNull;

	/** 
	 * Sets the value of idNivelEstudios
	 */
	public void setIdNivelEstudios(long idNivelEstudios)
	{
		this.idNivelEstudios = idNivelEstudios;
	}

	/** 
	 * Gets the value of idNivelEstudios
	 */
	public long getIdNivelEstudios()
	{
		return idNivelEstudios;
	}

	/**
	 * Method 'RcPsicoNivelEstudiosPk'
	 * 
	 */
	public RcPsicoNivelEstudiosPk()
	{
	}

	/**
	 * Method 'RcPsicoNivelEstudiosPk'
	 * 
	 * @param idNivelEstudios
	 */
	public RcPsicoNivelEstudiosPk(final long idNivelEstudios)
	{
		this.idNivelEstudios = idNivelEstudios;
	}

	/** 
	 * Sets the value of idNivelEstudiosNull
	 */
	public void setIdNivelEstudiosNull(boolean idNivelEstudiosNull)
	{
		this.idNivelEstudiosNull = idNivelEstudiosNull;
	}

	/** 
	 * Gets the value of idNivelEstudiosNull
	 */
	public boolean isIdNivelEstudiosNull()
	{
		return idNivelEstudiosNull;
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
		
		if (!(_other instanceof RcPsicoNivelEstudiosPk)) {
			return false;
		}
		
		final RcPsicoNivelEstudiosPk _cast = (RcPsicoNivelEstudiosPk) _other;
		if (idNivelEstudios != _cast.idNivelEstudios) {
			return false;
		}
		
		if (idNivelEstudiosNull != _cast.idNivelEstudiosNull) {
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
		_hashCode = 29 * _hashCode + (int) (idNivelEstudios ^ (idNivelEstudios >>> 32));
		_hashCode = 29 * _hashCode + (idNivelEstudiosNull ? 1 : 0);
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
		ret.append( "com.sorin.idea.dto.RcPsicoNivelEstudiosPk: " );
		ret.append( "idNivelEstudios=" + idNivelEstudios );
		return ret.toString();
	}

}

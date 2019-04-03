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
 * This class represents the primary key of the RC_PSICO_APOYO_SOCIAL table.
 */
public class RcPsicoApoyoSocialPk implements Serializable
{
	protected long idApoyoSocial;

	/** 
	 * This attribute represents whether the primitive attribute idApoyoSocial is null.
	 */
	protected boolean idApoyoSocialNull;

	/** 
	 * Sets the value of idApoyoSocial
	 */
	public void setIdApoyoSocial(long idApoyoSocial)
	{
		this.idApoyoSocial = idApoyoSocial;
	}

	/** 
	 * Gets the value of idApoyoSocial
	 */
	public long getIdApoyoSocial()
	{
		return idApoyoSocial;
	}

	/**
	 * Method 'RcPsicoApoyoSocialPk'
	 * 
	 */
	public RcPsicoApoyoSocialPk()
	{
	}

	/**
	 * Method 'RcPsicoApoyoSocialPk'
	 * 
	 * @param idApoyoSocial
	 */
	public RcPsicoApoyoSocialPk(final long idApoyoSocial)
	{
		this.idApoyoSocial = idApoyoSocial;
	}

	/** 
	 * Sets the value of idApoyoSocialNull
	 */
	public void setIdApoyoSocialNull(boolean idApoyoSocialNull)
	{
		this.idApoyoSocialNull = idApoyoSocialNull;
	}

	/** 
	 * Gets the value of idApoyoSocialNull
	 */
	public boolean isIdApoyoSocialNull()
	{
		return idApoyoSocialNull;
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
		
		if (!(_other instanceof RcPsicoApoyoSocialPk)) {
			return false;
		}
		
		final RcPsicoApoyoSocialPk _cast = (RcPsicoApoyoSocialPk) _other;
		if (idApoyoSocial != _cast.idApoyoSocial) {
			return false;
		}
		
		if (idApoyoSocialNull != _cast.idApoyoSocialNull) {
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
		_hashCode = 29 * _hashCode + (int) (idApoyoSocial ^ (idApoyoSocial >>> 32));
		_hashCode = 29 * _hashCode + (idApoyoSocialNull ? 1 : 0);
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
		ret.append( "com.sorin.idea.dto.RcPsicoApoyoSocialPk: " );
		ret.append( "idApoyoSocial=" + idApoyoSocial );
		return ret.toString();
	}

}

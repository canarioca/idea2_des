/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.dto;

import com.sorin.idea.dao.*;
import com.sorin.idea.factory.*;
import com.sorin.idea.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class RcPsicoApoyoSocial implements Serializable
{
	/** 
	 * This attribute maps to the column ID_APOYO_SOCIAL in the RC_PSICO_APOYO_SOCIAL table.
	 */
	protected long idApoyoSocial;

	/** 
	 * This attribute represents whether the attribute idApoyoSocial has been modified since being read from the database.
	 */
	protected boolean idApoyoSocialModified = false;

	/** 
	 * This attribute maps to the column TIPO in the RC_PSICO_APOYO_SOCIAL table.
	 */
	protected String tipo;

	/** 
	 * This attribute represents whether the attribute tipo has been modified since being read from the database.
	 */
	protected boolean tipoModified = false;

	/**
	 * Method 'RcPsicoApoyoSocial'
	 * 
	 */
	public RcPsicoApoyoSocial()
	{
	}

	/**
	 * Method 'getIdApoyoSocial'
	 * 
	 * @return long
	 */
	public long getIdApoyoSocial()
	{
		return idApoyoSocial;
	}

	/**
	 * Method 'setIdApoyoSocial'
	 * 
	 * @param idApoyoSocial
	 */
	public void setIdApoyoSocial(long idApoyoSocial)
	{
		this.idApoyoSocial = idApoyoSocial;
		this.idApoyoSocialModified = true;
	}

	/** 
	 * Sets the value of idApoyoSocialModified
	 */
	public void setIdApoyoSocialModified(boolean idApoyoSocialModified)
	{
		this.idApoyoSocialModified = idApoyoSocialModified;
	}

	/** 
	 * Gets the value of idApoyoSocialModified
	 */
	public boolean isIdApoyoSocialModified()
	{
		return idApoyoSocialModified;
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
		this.tipoModified = true;
	}

	/** 
	 * Sets the value of tipoModified
	 */
	public void setTipoModified(boolean tipoModified)
	{
		this.tipoModified = tipoModified;
	}

	/** 
	 * Gets the value of tipoModified
	 */
	public boolean isTipoModified()
	{
		return tipoModified;
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
		
		if (!(_other instanceof RcPsicoApoyoSocial)) {
			return false;
		}
		
		final RcPsicoApoyoSocial _cast = (RcPsicoApoyoSocial) _other;
		if (idApoyoSocial != _cast.idApoyoSocial) {
			return false;
		}
		
		if (idApoyoSocialModified != _cast.idApoyoSocialModified) {
			return false;
		}
		
		if (tipo == null ? _cast.tipo != tipo : !tipo.equals( _cast.tipo )) {
			return false;
		}
		
		if (tipoModified != _cast.tipoModified) {
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
		_hashCode = 29 * _hashCode + (idApoyoSocialModified ? 1 : 0);
		if (tipo != null) {
			_hashCode = 29 * _hashCode + tipo.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (tipoModified ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return RcPsicoApoyoSocialPk
	 */
	public RcPsicoApoyoSocialPk createPk()
	{
		return new RcPsicoApoyoSocialPk(idApoyoSocial);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.sorin.idea.dto.RcPsicoApoyoSocial: " );
		ret.append( "idApoyoSocial=" + idApoyoSocial );
		ret.append( ", tipo=" + tipo );
		return ret.toString();
	}

}
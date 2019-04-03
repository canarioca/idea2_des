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

public class RcPsicoFamilia implements Serializable
{
	/** 
	 * This attribute maps to the column ID_FAMILIA in the RC_PSICO_FAMILIA table.
	 */
	protected long idFamilia;

	/** 
	 * This attribute represents whether the attribute idFamilia has been modified since being read from the database.
	 */
	protected boolean idFamiliaModified = false;

	/** 
	 * This attribute maps to the column TIPO in the RC_PSICO_FAMILIA table.
	 */
	protected String tipo;

	/** 
	 * This attribute represents whether the attribute tipo has been modified since being read from the database.
	 */
	protected boolean tipoModified = false;

	/**
	 * Method 'RcPsicoFamilia'
	 * 
	 */
	public RcPsicoFamilia()
	{
	}

	/**
	 * Method 'getIdFamilia'
	 * 
	 * @return long
	 */
	public long getIdFamilia()
	{
		return idFamilia;
	}

	/**
	 * Method 'setIdFamilia'
	 * 
	 * @param idFamilia
	 */
	public void setIdFamilia(long idFamilia)
	{
		this.idFamilia = idFamilia;
		this.idFamiliaModified = true;
	}

	/** 
	 * Sets the value of idFamiliaModified
	 */
	public void setIdFamiliaModified(boolean idFamiliaModified)
	{
		this.idFamiliaModified = idFamiliaModified;
	}

	/** 
	 * Gets the value of idFamiliaModified
	 */
	public boolean isIdFamiliaModified()
	{
		return idFamiliaModified;
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
		
		if (!(_other instanceof RcPsicoFamilia)) {
			return false;
		}
		
		final RcPsicoFamilia _cast = (RcPsicoFamilia) _other;
		if (idFamilia != _cast.idFamilia) {
			return false;
		}
		
		if (idFamiliaModified != _cast.idFamiliaModified) {
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
		_hashCode = 29 * _hashCode + (int) (idFamilia ^ (idFamilia >>> 32));
		_hashCode = 29 * _hashCode + (idFamiliaModified ? 1 : 0);
		if (tipo != null) {
			_hashCode = 29 * _hashCode + tipo.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (tipoModified ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return RcPsicoFamiliaPk
	 */
	public RcPsicoFamiliaPk createPk()
	{
		return new RcPsicoFamiliaPk(idFamilia);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.sorin.idea.dto.RcPsicoFamilia: " );
		ret.append( "idFamilia=" + idFamilia );
		ret.append( ", tipo=" + tipo );
		return ret.toString();
	}

}

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

public class RcPsicoSituacionEconomica implements Serializable
{
	/** 
	 * This attribute maps to the column ID_SITUACION_ECONOMICA in the RC_PSICO_SITUACION_ECONOMICA table.
	 */
	protected long idSituacionEconomica;

	/** 
	 * This attribute represents whether the attribute idSituacionEconomica has been modified since being read from the database.
	 */
	protected boolean idSituacionEconomicaModified = false;

	/** 
	 * This attribute maps to the column SITUACION in the RC_PSICO_SITUACION_ECONOMICA table.
	 */
	protected String situacion;

	/** 
	 * This attribute represents whether the attribute situacion has been modified since being read from the database.
	 */
	protected boolean situacionModified = false;

	/**
	 * Method 'RcPsicoSituacionEconomica'
	 * 
	 */
	public RcPsicoSituacionEconomica()
	{
	}

	/**
	 * Method 'getIdSituacionEconomica'
	 * 
	 * @return long
	 */
	public long getIdSituacionEconomica()
	{
		return idSituacionEconomica;
	}

	/**
	 * Method 'setIdSituacionEconomica'
	 * 
	 * @param idSituacionEconomica
	 */
	public void setIdSituacionEconomica(long idSituacionEconomica)
	{
		this.idSituacionEconomica = idSituacionEconomica;
		this.idSituacionEconomicaModified = true;
	}

	/** 
	 * Sets the value of idSituacionEconomicaModified
	 */
	public void setIdSituacionEconomicaModified(boolean idSituacionEconomicaModified)
	{
		this.idSituacionEconomicaModified = idSituacionEconomicaModified;
	}

	/** 
	 * Gets the value of idSituacionEconomicaModified
	 */
	public boolean isIdSituacionEconomicaModified()
	{
		return idSituacionEconomicaModified;
	}

	/**
	 * Method 'getSituacion'
	 * 
	 * @return String
	 */
	public String getSituacion()
	{
		return situacion;
	}

	/**
	 * Method 'setSituacion'
	 * 
	 * @param situacion
	 */
	public void setSituacion(String situacion)
	{
		this.situacion = situacion;
		this.situacionModified = true;
	}

	/** 
	 * Sets the value of situacionModified
	 */
	public void setSituacionModified(boolean situacionModified)
	{
		this.situacionModified = situacionModified;
	}

	/** 
	 * Gets the value of situacionModified
	 */
	public boolean isSituacionModified()
	{
		return situacionModified;
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
		
		if (!(_other instanceof RcPsicoSituacionEconomica)) {
			return false;
		}
		
		final RcPsicoSituacionEconomica _cast = (RcPsicoSituacionEconomica) _other;
		if (idSituacionEconomica != _cast.idSituacionEconomica) {
			return false;
		}
		
		if (idSituacionEconomicaModified != _cast.idSituacionEconomicaModified) {
			return false;
		}
		
		if (situacion == null ? _cast.situacion != situacion : !situacion.equals( _cast.situacion )) {
			return false;
		}
		
		if (situacionModified != _cast.situacionModified) {
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
		_hashCode = 29 * _hashCode + (int) (idSituacionEconomica ^ (idSituacionEconomica >>> 32));
		_hashCode = 29 * _hashCode + (idSituacionEconomicaModified ? 1 : 0);
		if (situacion != null) {
			_hashCode = 29 * _hashCode + situacion.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (situacionModified ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return RcPsicoSituacionEconomicaPk
	 */
	public RcPsicoSituacionEconomicaPk createPk()
	{
		return new RcPsicoSituacionEconomicaPk(idSituacionEconomica);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.sorin.idea.dto.RcPsicoSituacionEconomica: " );
		ret.append( "idSituacionEconomica=" + idSituacionEconomica );
		ret.append( ", situacion=" + situacion );
		return ret.toString();
	}

}
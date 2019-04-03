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
 * This class represents the primary key of the imp_hoja_implante_complicacion table.
 */
public class ImpHojaImplanteComplicacionPk implements Serializable
{
	protected Integer idhojaimp;

	protected Integer idcompl;

	/** 
	 * Sets the value of idhojaimp
	 */
	public void setIdhojaimp(Integer idhojaimp)
	{
		this.idhojaimp = idhojaimp;
	}

	/** 
	 * Gets the value of idhojaimp
	 */
	public Integer getIdhojaimp()
	{
		return idhojaimp;
	}

	/** 
	 * Sets the value of idcompl
	 */
	public void setIdcompl(Integer idcompl)
	{
		this.idcompl = idcompl;
	}

	/** 
	 * Gets the value of idcompl
	 */
	public Integer getIdcompl()
	{
		return idcompl;
	}

	/**
	 * Method 'ImpHojaImplanteComplicacionPk'
	 * 
	 */
	public ImpHojaImplanteComplicacionPk()
	{
	}

	/**
	 * Method 'ImpHojaImplanteComplicacionPk'
	 * 
	 * @param idhojaimp
	 * @param idcompl
	 */
	public ImpHojaImplanteComplicacionPk(final Integer idhojaimp, final Integer idcompl)
	{
		this.idhojaimp = idhojaimp;
		this.idcompl = idcompl;
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
		
		if (!(_other instanceof ImpHojaImplanteComplicacionPk)) {
			return false;
		}
		
		final ImpHojaImplanteComplicacionPk _cast = (ImpHojaImplanteComplicacionPk) _other;
		if (idhojaimp == null ? _cast.idhojaimp != idhojaimp : !idhojaimp.equals( _cast.idhojaimp )) {
			return false;
		}
		
		if (idcompl == null ? _cast.idcompl != idcompl : !idcompl.equals( _cast.idcompl )) {
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
		if (idhojaimp != null) {
			_hashCode = 29 * _hashCode + idhojaimp.hashCode();
		}
		
		if (idcompl != null) {
			_hashCode = 29 * _hashCode + idcompl.hashCode();
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
		ret.append( "hvn.apl.jProyecto2011.dto.ImpHojaImplanteComplicacionPk: " );
		ret.append( "idhojaimp=" + idhojaimp );
		ret.append( ", idcompl=" + idcompl );
		return ret.toString();
	}

}
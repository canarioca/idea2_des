/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.dto;

import java.io.Serializable;
import java.util.*;

import com.sorin.idea.dao.*;
import com.sorin.idea.exceptions.*;
import com.sorin.idea.factory.*;

public class ImpAtp implements Serializable
{
	/** 
	 * This attribute maps to the column IDATP in the imp_atp table.
	 */
	protected Integer idatp;

	/** 
	 * This attribute maps to the column IDZONA in the imp_atp table.
	 */
	protected Integer idzona;

	/** 
	 * This attribute maps to the column TIPO in the imp_atp table.
	 */
	protected String tipo;

	/** 
	 * This attribute maps to the column NUMSEC in the imp_atp table.
	 */
	protected String numsec;

	/** 
	 * This attribute maps to the column CICLOSEC in the imp_atp table.
	 */
	protected String ciclosec;

	/** 
	 * This attribute maps to the column ACOPLAMIENTO in the imp_atp table.
	 */
	protected String acoplamiento;

	/** 
	 * This attribute maps to the column DECREMENTO in the imp_atp table.
	 */
	protected String decremento;

	/**
	 * Method 'ImpAtp'
	 * 
	 */
	public ImpAtp()
	{
	}
	public ImpAtp(String t)
	{
		setTipo(t);
	}

	/**
	 * Method 'getIdatp'
	 * 
	 * @return Integer
	 */
	public Integer getIdatp()
	{
		return idatp;
	}

	/**
	 * Method 'setIdatp'
	 * 
	 * @param idatp
	 */
	public void setIdatp(Integer idatp)
	{
		this.idatp = idatp;
	}

	/**
	 * Method 'getIdzona'
	 * 
	 * @return Integer
	 */
	public Integer getIdzona()
	{
		return idzona;
	}

	/**
	 * Method 'setIdzona'
	 * 
	 * @param idzona
	 */
	public void setIdzona(Integer idzona)
	{
		this.idzona = idzona;
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
	}

	/**
	 * Method 'getNumsec'
	 * 
	 * @return String
	 */
	public String getNumsec()
	{
		return numsec;
	}

	/**
	 * Method 'setNumsec'
	 * 
	 * @param numsec
	 */
	public void setNumsec(String numsec)
	{
		this.numsec = numsec;
	}

	/**
	 * Method 'getCiclosec'
	 * 
	 * @return String
	 */
	public String getCiclosec()
	{
		return ciclosec;
	}

	/**
	 * Method 'setCiclosec'
	 * 
	 * @param ciclosec
	 */
	public void setCiclosec(String ciclosec)
	{
		this.ciclosec = ciclosec;
	}

	/**
	 * Method 'getAcoplamiento'
	 * 
	 * @return String
	 */
	public String getAcoplamiento()
	{
		return acoplamiento;
	}

	/**
	 * Method 'setAcoplamiento'
	 * 
	 * @param acoplamiento
	 */
	public void setAcoplamiento(String acoplamiento)
	{
		this.acoplamiento = acoplamiento;
	}

	/**
	 * Method 'getDecremento'
	 * 
	 * @return String
	 */
	public String getDecremento()
	{
		return decremento;
	}

	/**
	 * Method 'setDecremento'
	 * 
	 * @param decremento
	 */
	public void setDecremento(String decremento)
	{
		this.decremento = decremento;
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
		
		if (!(_other instanceof ImpAtp)) {
			return false;
		}
		
		final ImpAtp _cast = (ImpAtp) _other;
		if (idatp == null ? _cast.idatp != idatp : !idatp.equals( _cast.idatp )) {
			return false;
		}
		
		if (idzona == null ? _cast.idzona != idzona : !idzona.equals( _cast.idzona )) {
			return false;
		}
		
		if (tipo == null ? _cast.tipo != tipo : !tipo.equals( _cast.tipo )) {
			return false;
		}
		
		if (numsec == null ? _cast.numsec != numsec : !numsec.equals( _cast.numsec )) {
			return false;
		}
		
		if (ciclosec == null ? _cast.ciclosec != ciclosec : !ciclosec.equals( _cast.ciclosec )) {
			return false;
		}
		
		if (acoplamiento == null ? _cast.acoplamiento != acoplamiento : !acoplamiento.equals( _cast.acoplamiento )) {
			return false;
		}
		
		if (decremento == null ? _cast.decremento != decremento : !decremento.equals( _cast.decremento )) {
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
		if (idatp != null) {
			_hashCode = 29 * _hashCode + idatp.hashCode();
		}
		
		if (idzona != null) {
			_hashCode = 29 * _hashCode + idzona.hashCode();
		}
		
		if (tipo != null) {
			_hashCode = 29 * _hashCode + tipo.hashCode();
		}
		
		if (numsec != null) {
			_hashCode = 29 * _hashCode + numsec.hashCode();
		}
		
		if (ciclosec != null) {
			_hashCode = 29 * _hashCode + ciclosec.hashCode();
		}
		
		if (acoplamiento != null) {
			_hashCode = 29 * _hashCode + acoplamiento.hashCode();
		}
		
		if (decremento != null) {
			_hashCode = 29 * _hashCode + decremento.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return ImpAtpPk
	 */
	public ImpAtpPk createPk()
	{
		return new ImpAtpPk(idatp);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "hvn.apl.jProyecto2011.dto.ImpAtp: " );
		ret.append( "idatp=" + idatp );
		ret.append( ", idzona=" + idzona );
		ret.append( ", tipo=" + tipo );
		ret.append( ", numsec=" + numsec );
		ret.append( ", ciclosec=" + ciclosec );
		ret.append( ", acoplamiento=" + acoplamiento );
		ret.append( ", decremento=" + decremento );
		return ret.toString();
	}

}
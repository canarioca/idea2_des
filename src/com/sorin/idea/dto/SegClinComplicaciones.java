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

public class SegClinComplicaciones implements Serializable
{
	/** 
	 * This attribute maps to the column IDCOMP in the seg_clin_complicaciones table.
	 */
	protected Integer idcomp;

	/** 
	 * This attribute maps to the column IDSEGCLIN in the seg_clin_complicaciones table.
	 */
	protected Integer idsegclin;

	/** 
	 * This attribute maps to the column ACTITUD in the seg_clin_complicaciones table.
	 */
	protected String actitud;

	/** 
	 * This attribute maps to the column RESULTADO in the seg_clin_complicaciones table.
	 */
	protected Integer resultado;

	/** 
	 * This attribute maps to the column OTRA in the seg_clin_complicaciones table.
	 */
	protected String otra;

	protected String tipocomp;
	
	/**
	 * Method 'SegClinComplicaciones'
	 * 
	 */
	public SegClinComplicaciones()
	{
	}

	/**
	 * Method 'getIdcomp'
	 * 
	 * @return Integer
	 */
	public Integer getIdcomp()
	{
		return idcomp;
	}

	/**
	 * Method 'setIdcomp'
	 * 
	 * @param idcomp
	 */
	public void setIdcomp(Integer idcomp)
	{
		this.idcomp = idcomp;
	}

	/**
	 * Method 'getIdsegclin'
	 * 
	 * @return Integer
	 */
	public Integer getIdsegclin()
	{
		return idsegclin;
	}

	/**
	 * Method 'setIdsegclin'
	 * 
	 * @param idsegclin
	 */
	public void setIdsegclin(Integer idsegclin)
	{
		this.idsegclin = idsegclin;
	}

	/**
	 * Method 'getActitud'
	 * 
	 * @return String
	 */
	public String getActitud()
	{
		return actitud;
	}

	/**
	 * Method 'setActitud'
	 * 
	 * @param actitud
	 */
	public void setActitud(String actitud)
	{
		this.actitud = actitud;
	}

	/**
	 * Method 'getResultado'
	 * 
	 * @return Integer
	 */
	public Integer getResultado()
	{
		return resultado;
	}

	/**
	 * Method 'setResultado'
	 * 
	 * @param resultado
	 */
	public void setResultado(Integer resultado)
	{
		this.resultado = resultado;
	}

	/**
	 * Method 'getOtra'
	 * 
	 * @return String
	 */
	public String getOtra()
	{
		return otra;
	}

	/**
	 * Method 'setOtra'
	 * 
	 * @param otra
	 */
	public void setOtra(String otra)
	{
		this.otra = otra;
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
		
		if (!(_other instanceof SegClinComplicaciones)) {
			return false;
		}
		
		final SegClinComplicaciones _cast = (SegClinComplicaciones) _other;
		if (idcomp == null ? _cast.idcomp != idcomp : !idcomp.equals( _cast.idcomp )) {
			return false;
		}
		
		if (idsegclin == null ? _cast.idsegclin != idsegclin : !idsegclin.equals( _cast.idsegclin )) {
			return false;
		}
		
		if (actitud == null ? _cast.actitud != actitud : !actitud.equals( _cast.actitud )) {
			return false;
		}
		
		if (resultado == null ? _cast.resultado != resultado : !resultado.equals( _cast.resultado )) {
			return false;
		}
		
		if (otra == null ? _cast.otra != otra : !otra.equals( _cast.otra )) {
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
		if (idcomp != null) {
			_hashCode = 29 * _hashCode + idcomp.hashCode();
		}
		
		if (idsegclin != null) {
			_hashCode = 29 * _hashCode + idsegclin.hashCode();
		}
		
		if (actitud != null) {
			_hashCode = 29 * _hashCode + actitud.hashCode();
		}
		
		if (resultado != null) {
			_hashCode = 29 * _hashCode + resultado.hashCode();
		}
		
		if (otra != null) {
			_hashCode = 29 * _hashCode + otra.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SegClinComplicacionesPk
	 */
	public SegClinComplicacionesPk createPk()
	{
		return new SegClinComplicacionesPk(idcomp, idsegclin);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.sorin.idea.dto.SegClinComplicaciones: " );
		ret.append( "idcomp=" + idcomp );
		ret.append( ", idsegclin=" + idsegclin );
		ret.append( ", actitud=" + actitud );
		ret.append( ", resultado=" + resultado );
		ret.append( ", otra=" + otra );
		return ret.toString();
	}

	public String getTipocomp() {
		return tipocomp;
	}

	public void setTipocomp(String tipocomp) {
		this.tipocomp = tipocomp;
	}

}

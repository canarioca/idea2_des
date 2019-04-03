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

public class Codigosgs128 implements Serializable
{
	/** 
	 * This attribute maps to the column IDMATERIAL in the codigosgs128 table.
	 */
	protected Integer idmaterial;

	/** 
	 * This attribute maps to the column TIPO in the codigosgs128 table.
	 */
	protected Integer tipo;

	/** 
	 * This attribute maps to the column CODIGO in the codigosgs128 table.
	 */
	protected String codigo;

	/**
	 * Method 'Codigosgs128'
	 * 
	 */
	public Codigosgs128()
	{
	}

	/**
	 * Method 'getIdmaterial'
	 * 
	 * @return Integer
	 */
	public Integer getIdmaterial()
	{
		return idmaterial;
	}

	/**
	 * Method 'setIdmaterial'
	 * 
	 * @param idmaterial
	 */
	public void setIdmaterial(Integer idmaterial)
	{
		this.idmaterial = idmaterial;
	}

	/**
	 * Method 'getTipo'
	 * 
	 * @return Integer
	 */
	public Integer getTipo()
	{
		return tipo;
	}

	/**
	 * Method 'setTipo'
	 * 
	 * @param tipo
	 */
	public void setTipo(Integer tipo)
	{
		this.tipo = tipo;
	}

	/**
	 * Method 'getCodigo'
	 * 
	 * @return String
	 */
	public String getCodigo()
	{
		return codigo;
	}

	/**
	 * Method 'setCodigo'
	 * 
	 * @param codigo
	 */
	public void setCodigo(String codigo)
	{
		this.codigo = codigo;
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
		
		if (!(_other instanceof Codigosgs128)) {
			return false;
		}
		
		final Codigosgs128 _cast = (Codigosgs128) _other;
		if (idmaterial == null ? _cast.idmaterial != idmaterial : !idmaterial.equals( _cast.idmaterial )) {
			return false;
		}
		
		if (tipo == null ? _cast.tipo != tipo : !tipo.equals( _cast.tipo )) {
			return false;
		}
		
		if (codigo == null ? _cast.codigo != codigo : !codigo.equals( _cast.codigo )) {
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
		if (idmaterial != null) {
			_hashCode = 29 * _hashCode + idmaterial.hashCode();
		}
		
		if (tipo != null) {
			_hashCode = 29 * _hashCode + tipo.hashCode();
		}
		
		if (codigo != null) {
			_hashCode = 29 * _hashCode + codigo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return Codigosgs128Pk
	 */
	public Codigosgs128Pk createPk()
	{
		return new Codigosgs128Pk(idmaterial, tipo, codigo);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.sorin.idea.dto.Codigosgs128: " );
		ret.append( "idmaterial=" + idmaterial );
		ret.append( ", tipo=" + tipo );
		ret.append( ", codigo=" + codigo );
		return ret.toString();
	}

}
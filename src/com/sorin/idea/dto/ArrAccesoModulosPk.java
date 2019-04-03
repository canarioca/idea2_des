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
 * This class represents the primary key of the arr_acceso_modulos table.
 */
public class ArrAccesoModulosPk implements Serializable
{
	protected String usuario;

	/** 
	 * Sets the value of usuario
	 */
	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	/** 
	 * Gets the value of usuario
	 */
	public String getUsuario()
	{
		return usuario;
	}

	/**
	 * Method 'ArrAccesoModulosPk'
	 * 
	 */
	public ArrAccesoModulosPk()
	{
	}

	/**
	 * Method 'ArrAccesoModulosPk'
	 * 
	 * @param usuario
	 */
	public ArrAccesoModulosPk(final String usuario)
	{
		this.usuario = usuario;
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
		
		if (!(_other instanceof ArrAccesoModulosPk)) {
			return false;
		}
		
		final ArrAccesoModulosPk _cast = (ArrAccesoModulosPk) _other;
		if (usuario == null ? _cast.usuario != usuario : !usuario.equals( _cast.usuario )) {
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
		if (usuario != null) {
			_hashCode = 29 * _hashCode + usuario.hashCode();
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
		ret.append( "com.sorin.idea.dto.ArrAccesoModulosPk: " );
		ret.append( "usuario=" + usuario );
		return ret.toString();
	}

}
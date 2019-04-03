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

public class UsuariosPlantillas implements Serializable
{
	/** 
	 * This attribute maps to the column ID_USUARIOS in the usuarios_plantillas table.
	 */
	protected String idUsuarios;

	/** 
	 * This attribute maps to the column ID_PLANTILLA in the usuarios_plantillas table.
	 */
	protected int idPlantilla;

	/**
	 * Method 'UsuariosPlantillas'
	 * 
	 */
	public UsuariosPlantillas()
	{
	}

	/**
	 * Method 'getIdUsuarios'
	 * 
	 * @return String
	 */
	public String getIdUsuarios()
	{
		return idUsuarios;
	}

	/**
	 * Method 'setIdUsuarios'
	 * 
	 * @param idUsuarios
	 */
	public void setIdUsuarios(String idUsuarios)
	{
		this.idUsuarios = idUsuarios;
	}

	/**
	 * Method 'getIdPlantilla'
	 * 
	 * @return int
	 */
	public int getIdPlantilla()
	{
		return idPlantilla;
	}

	/**
	 * Method 'setIdPlantilla'
	 * 
	 * @param idPlantilla
	 */
	public void setIdPlantilla(int idPlantilla)
	{
		this.idPlantilla = idPlantilla;
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
		
		if (!(_other instanceof UsuariosPlantillas)) {
			return false;
		}
		
		final UsuariosPlantillas _cast = (UsuariosPlantillas) _other;
		if (idUsuarios == null ? _cast.idUsuarios != idUsuarios : !idUsuarios.equals( _cast.idUsuarios )) {
			return false;
		}
		
		if (idPlantilla != _cast.idPlantilla) {
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
		if (idUsuarios != null) {
			_hashCode = 29 * _hashCode + idUsuarios.hashCode();
		}
		
		_hashCode = 29 * _hashCode + idPlantilla;
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return UsuariosPlantillasPk
	 */
	public UsuariosPlantillasPk createPk()
	{
		return new UsuariosPlantillasPk(idPlantilla, idUsuarios);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.sorin.idea.dto.UsuariosPlantillas: " );
		ret.append( "idUsuarios=" + idUsuarios );
		ret.append( ", idPlantilla=" + idPlantilla );
		return ret.toString();
	}

}

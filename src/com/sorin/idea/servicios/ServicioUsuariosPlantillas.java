package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.UsuariosPlantillas;
import com.sorin.idea.exceptions.UsuariosPlantillasDaoException;

public interface ServicioUsuariosPlantillas{

	/**
	 * Metodo que obtiene la relacion de plantillas del usuario
	 * 
	 * @param usuario
	 * @return
	 */
	public List<UsuariosPlantillas> obtenerListadoUsuarioPlantillas( String usuario ) throws UsuariosPlantillasDaoException;
	
	/**
	 * Método que guarda la relacion del entre el usuario y la plantilla
	 * 
	 * @param usuario
	 * @param idPlantilla
	 * @return
	 */
	public void guardarUsuarioPlantilla( String usuario, int idPlantilla ) throws UsuariosPlantillasDaoException;
}

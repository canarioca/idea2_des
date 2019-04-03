package com.sorin.idea.servicios;

import com.sorin.idea.dto.RcNutricion;
import com.sorin.idea.dto.RcNutricionPk;
import com.sorin.idea.exceptions.RcNutricionDaoException;

public interface ServicioRCNutricion {

	/**
	 * Método que obtiene un objeto RCNutricion por su id
	 * 
	 * @param id
	 * @return
	 */
	public RcNutricion buscar( int id );
	
	
	/**
	 * Método que elimina un objeto RCNutricion
	 * 
	 * @param pkNutricion
	 */
	public void eliminar( RcNutricionPk pkNutricion ) throws RcNutricionDaoException;
	
	/**
	 * Método que guarda un objeto RCNutricion
	 * 
	 * @param rcNutricion
	 * @return
	 */
	public RcNutricionPk guardar( RcNutricion rcNutricion );
	
	/**
	 * Método que actualiza un objeto RCNutricion
	 * 
	 * @param pkNutricion
	 * @param rcNutricion
	 * @throws RcNutricionDaoException 
	 */
	public void actualizar( RcNutricionPk pkNutricion, RcNutricion rcNutricion ) throws RcNutricionDaoException;
	
}

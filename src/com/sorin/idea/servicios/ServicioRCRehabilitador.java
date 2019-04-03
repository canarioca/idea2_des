package com.sorin.idea.servicios;

import com.sorin.idea.dto.RcRehabilitador;
import com.sorin.idea.dto.RcRehabilitadorPk;
import com.sorin.idea.exceptions.RcRehabilitadorDaoException;

public interface ServicioRCRehabilitador {

	/**
	 * Método que obtiene un objeto de tipo RCRehabilitador
	 * 
	 * @param id
	 * @return
	 */
	public RcRehabilitador buscar( int id );

	/**
	 * Método que elimina un objeto RCRehabilitador
	 * 
	 * @param pkRehabilitador
	 */
	public void eliminar( RcRehabilitadorPk pkRehabilitador ) throws RcRehabilitadorDaoException;
	
	/**
	 * Método que guarda un objeto RCRehabilitador
	 * 
	 * @param pkRehabilitador
	 */
	public RcRehabilitadorPk guardar( RcRehabilitador rcRehabilitador ); 
	
	/**
	 * Método que actualiza un objeto RCRehabilitador
	 * 
	 * @param pkRehabilitador
	 * @param rcRehabilitador
	 * @throws RcRehabilitadorDaoException 
	 */
	public void actualizar( RcRehabilitadorPk pkRehabilitador, RcRehabilitador rcRehabilitador ) throws RcRehabilitadorDaoException;
}

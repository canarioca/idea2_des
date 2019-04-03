package com.sorin.idea.servicios;

import com.sorin.idea.dto.RcRehabilitacionCardiaca;
import com.sorin.idea.dto.RcRehabilitacionCardiacaPk;
import com.sorin.idea.exceptions.RcRehabilitacionCardiacaDaoException;

public interface ServicioRehabilitacionCardiaca {

	/**
	 * Método que obtiene el objeto de rehabilitacion cardiaca por su id
	 * 
	 * @param id
	 * @return
	 */
	public RcRehabilitacionCardiaca obtenerRC( int id );
	
	/**
	 * Método que guarda un objeto de rehabilitacion cardiaca
	 * 
	 * @param rcRehabilitacionCardiaca
	 * @return
	 */
	public RcRehabilitacionCardiacaPk guardarRC( RcRehabilitacionCardiaca rcRehabilitacionCardiaca );
	
	/**
	 * Método que actualiza un objeto de rehabilitacion cardiaca
	 * 
	 * @param rcRehabilitacionCardiaca
	 * @return
	 */
	public void updateRC( RcRehabilitacionCardiacaPk rcRehabilitacionCardiacaPk, RcRehabilitacionCardiaca rcRehabilitacionCardiaca);
	
	
	/**
	 * Método que elimina una rehabilitacion cardiaca del sistema
	 * 
	 * @param rcRehabilitacionCardiacaPk
	 */
	public void eliminarRC( RcRehabilitacionCardiacaPk rcRehabilitacionCardiacaPk ) throws RcRehabilitacionCardiacaDaoException;

}

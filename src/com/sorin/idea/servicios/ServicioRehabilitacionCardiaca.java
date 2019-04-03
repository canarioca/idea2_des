package com.sorin.idea.servicios;

import com.sorin.idea.dto.RcRehabilitacionCardiaca;
import com.sorin.idea.dto.RcRehabilitacionCardiacaPk;
import com.sorin.idea.exceptions.RcRehabilitacionCardiacaDaoException;

public interface ServicioRehabilitacionCardiaca {

	/**
	 * M�todo que obtiene el objeto de rehabilitacion cardiaca por su id
	 * 
	 * @param id
	 * @return
	 */
	public RcRehabilitacionCardiaca obtenerRC( int id );
	
	/**
	 * M�todo que guarda un objeto de rehabilitacion cardiaca
	 * 
	 * @param rcRehabilitacionCardiaca
	 * @return
	 */
	public RcRehabilitacionCardiacaPk guardarRC( RcRehabilitacionCardiaca rcRehabilitacionCardiaca );
	
	/**
	 * M�todo que actualiza un objeto de rehabilitacion cardiaca
	 * 
	 * @param rcRehabilitacionCardiaca
	 * @return
	 */
	public void updateRC( RcRehabilitacionCardiacaPk rcRehabilitacionCardiacaPk, RcRehabilitacionCardiaca rcRehabilitacionCardiaca);
	
	
	/**
	 * M�todo que elimina una rehabilitacion cardiaca del sistema
	 * 
	 * @param rcRehabilitacionCardiacaPk
	 */
	public void eliminarRC( RcRehabilitacionCardiacaPk rcRehabilitacionCardiacaPk ) throws RcRehabilitacionCardiacaDaoException;

}

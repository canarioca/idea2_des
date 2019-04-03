package com.sorin.idea.servicios;

import com.sorin.idea.dto.RcPsicologia;
import com.sorin.idea.dto.RcPsicologiaPk;
import com.sorin.idea.exceptions.RcPsicologiaDaoException;

public interface ServicioRCPsicologia {

	/**
	 * Método que obtiene un objeto RCPsicologia
	 * 
	 * @param id
	 * @return
	 */
	public RcPsicologia buscar(int id);
	
	/**
	 * Método que elimina un objeto RCPsicologia
	 * 
	 * @param pkPsicologia
	 * @throws RcPsicologiaDaoException 
	 */
	public void eliminar( RcPsicologiaPk pkPsicologia ) throws RcPsicologiaDaoException;
	
	/**
	 * Método que guarda un objeto RCPsicologia
	 * 
	 * @param rcPsicologia
	 * @return
	 */
	public RcPsicologiaPk guardar( RcPsicologia rcPsicologia );
	
	
	/**
	 * Método que actualiza un objeto RCPsicologia
	 * 
	 * @param pkPsicologia
	 * @param rcPsicologia
	 * @throws RcPsicologiaDaoException 
	 */
	public void actualizar( RcPsicologiaPk pkPsicologia,  RcPsicologia rcPsicologia) throws RcPsicologiaDaoException;
	
}

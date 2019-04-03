package com.sorin.idea.servicios;

import com.sorin.idea.dto.Plantillas;
import com.sorin.idea.dto.PlantillasPk;
import com.sorin.idea.exceptions.PlantillasDaoException;

public interface ServicioPlantillas {

	/**
	 * Método que obtiene una plantilla del sistema
	 * 
	 * @return
	 * @throws PlantillasDaoException
	 */
	public Plantillas obtenerPlantillas( int idPlantilla ) throws PlantillasDaoException;
	
	/**
	 * Método que elimina una plantilla del sistema
	 * 
	 * @param idPlantilla
	 * @throws PlantillasDaoException
	 */
	public void eliminarPlantilla( int idPlantilla ) throws PlantillasDaoException;
	
	/**
	 * Método que inserta una plantilla en el sistema
	 * 
	 * @param plantilla
	 * @return
	 * @throws PlantillasDaoException
	 */
	public PlantillasPk guardarPlantilla( String descripcionPlantilla, String  tituloPlantilla, int idAmbito ) throws PlantillasDaoException ;
	
	/**
	 * Método que actualiza una plantilla en el sistema
	 * 
	 * @param plantilla
	 * @param idPlantilla
	 * @throws PlantillasDaoException
	 */
	public void actualizarPlantilla( int idPlantilla, String descripcionPlantilla, String tituloPlantilla, int idAmbito ) throws PlantillasDaoException;
}

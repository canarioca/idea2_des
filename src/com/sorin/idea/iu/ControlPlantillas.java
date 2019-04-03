package com.sorin.idea.iu;

import org.apache.log4j.Logger;

import com.sorin.idea.dto.Plantillas;
import com.sorin.idea.exceptions.PlantillasDaoException;
import com.sorin.idea.servicios.impl.ServicioPlantillasImpl;

public class ControlPlantillas {

	private static Logger logger = Logger.getLogger(ControlPlantillas.class);
	
	private static ServicioPlantillasImpl servicioPlantillasImpl;
	
	/**
	 * Método que obtiene la plantilla seleccionada
	 * 
	 * @param idPlantilla
	 * @return
	 */
	public static String cambiarPlantilla( int idPlantilla ) {
		
		try {
			servicioPlantillasImpl = new ServicioPlantillasImpl();
			Plantillas plantilla = servicioPlantillasImpl.obtenerPlantillas( idPlantilla );
			
			if( plantilla != null ) {
				return plantilla.getDescripcionPlantilla();
			}
			
			return "";
			
		} catch (NumberFormatException e1) {
			logger.error("Error al obtener la descripcion de la plantilla. Motivo: "+ e1.getMessage());
		} catch (PlantillasDaoException e1) {
			logger.error(" Error al obtener la descripcion de la plantilla. Motivo: "+ e1.getMessage());
		}
		
		return null;
	}
	
}

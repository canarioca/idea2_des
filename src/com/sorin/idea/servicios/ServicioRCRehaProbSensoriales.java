package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcRehaProbSensoriales;

public interface ServicioRCRehaProbSensoriales {

	/**
	 * Metodo que obtiene la lista de la tabla maestra de Problemas Sensoriales
	 * 
	 * @return
	 */
	public List<RcRehaProbSensoriales> obtenerListadoProbSensoriales();
	
	/**
	 * Metodo que obtiene la seleccion del radio button para un paciente concreto
	 * por su idRehabilitador
	 * 
	 * @param idRehabilitador
	 * @return
	 */
	public RcRehaProbSensoriales obtenerProbSensorialesSeleccionadoDelPaciente( long idRehabilitador );
	
}

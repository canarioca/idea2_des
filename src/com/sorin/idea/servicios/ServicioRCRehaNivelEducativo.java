package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcRehaNivelEducativo;

public interface ServicioRCRehaNivelEducativo {

	/**
	 * Metodo que obtiene la lista de la tabla maestra de Nivel Educativo
	 * 
	 * @return
	 */
	public List<RcRehaNivelEducativo> obtenerListadoNivelEducativo();
	
	/**
	 * Metodo que obtiene la seleccion del radio button para un paciente concreto
	 * por su idRehabilitador
	 * 
	 * @param idRehabilitador
	 * @return
	 */
	public RcRehaNivelEducativo obtenerProbSensorialesSeleccionadoDelPaciente( long idRehabilitador );
	
}

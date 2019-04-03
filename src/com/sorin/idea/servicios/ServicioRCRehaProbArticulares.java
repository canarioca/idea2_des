package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcRehaProbArticulares;

public interface ServicioRCRehaProbArticulares {

	/**
	 * Metodo que obtiene los valores de la tabla maestra de Problemas Articulares
	 * 
	 * @return
	 */
	public List<RcRehaProbArticulares> obtenerListadoProbArticulares();
	
	/**
	 * Metodo que obtiene la seleccion del radio button para un paciente concreto
	 * por su idRehabilitador
	 * 
	 * @param idRehabilitador
	 * @return
	 */
	public RcRehaProbArticulares obtenerProbArticularSeleccionadoDelPaciente( long idRehabilitador );
	
	
}

package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcPsicoSituacionLaboral;
import com.sorin.idea.dto.RcPsicoVidaSexual;

public interface ServicioRCPsicoSituacionLaboral {

	/**
	 * Metodo que obtiene los valores de la tabla maestra de Situacion Laboral
	 * 
	 * @return
	 */
	public List<RcPsicoSituacionLaboral> obtenerListadoSituacionLaboral();
	
	/**
	 * Metodo que obtiene la seleccion del radio button para un paciente concreto
	 * por su idPsicologia
	 * 
	 * @param idPsicologia
	 * @return
	 */
	public RcPsicoSituacionLaboral obtenerSituacionLaboralSeleccionadoDelPaciente( long idPsicologia );
}

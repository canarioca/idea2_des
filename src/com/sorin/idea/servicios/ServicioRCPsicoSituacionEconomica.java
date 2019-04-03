package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcPsicoSituacionEconomica;

public interface ServicioRCPsicoSituacionEconomica {

	/**
	 * Metodo que obtiene los valores de la tabla maestra de Situacion Economica
	 * 
	 * @return
	 */
	public List<RcPsicoSituacionEconomica> obtenerListadoSituacionEconomica();
	
	/**
	 * Metodo que obtiene la seleccion del radio button para un paciente concreto
	 * por su idPsicologia
	 * 
	 * @param idPsicologia
	 * @return
	 */
	public RcPsicoSituacionEconomica obtenerSituacionEconomicaSeleccionadoDelPaciente( long idPsicologia );
}

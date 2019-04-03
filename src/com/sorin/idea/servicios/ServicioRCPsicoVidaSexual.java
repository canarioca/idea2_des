package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcPsicoVidaSexual;

public interface ServicioRCPsicoVidaSexual {

	/**
	 * Metodo que obtiene los valores de la tabla maestra de Vida Sexual
	 * 
	 * @return
	 */
	public List<RcPsicoVidaSexual> obtenerListadoVidaSexual();
	
	/**
	 * Metodo que obtiene la seleccion del radio button para un paciente concreto
	 * por su idPsicologia
	 * 
	 * @param idPsicologia
	 * @return
	 */
	public RcPsicoVidaSexual obtenerVidaSexualSeleccionadoDelPaciente( long idPsicologia );
}

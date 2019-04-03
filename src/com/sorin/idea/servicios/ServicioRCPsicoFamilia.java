package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcPsicoFamilia;

public interface ServicioRCPsicoFamilia {

	/**
	 * Metodo que obtiene los valores de la tabla maestra de Familia
	 * 
	 * @return
	 */
	public List<RcPsicoFamilia> obtenerListadoFamilia();
	
	/**
	 * Metodo que obtiene la seleccion del radio button para un paciente concreto
	 * por su idPsicologia
	 * 
	 * @param idPsicologia
	 * @return
	 */
	public RcPsicoFamilia obtenerFamiliaSeleccionadoDelPaciente( long idPsicologia );
	
}

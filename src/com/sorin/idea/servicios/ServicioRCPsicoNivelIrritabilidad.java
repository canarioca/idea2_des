package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcPsicoNivelIrritabilidad;
import com.sorin.idea.dto.RcPsicoNivelSatisfaccion;

public interface ServicioRCPsicoNivelIrritabilidad {

	/**
	 * Metodo que obtiene los valores de la tabla maestra de Familia
	 * 
	 * @return
	 */
	public List<RcPsicoNivelIrritabilidad> obtenerListadoNivelIrritabilidad();
	
	/**
	 * Metodo que obtiene la seleccion del radio button para un paciente concreto
	 * por su idPsicologia
	 * 
	 * @param idPsicologia
	 * @return
	 */
	public RcPsicoNivelIrritabilidad obtenerNivelIrritabilidadSeleccionadoDelPaciente( long idPsicologia );
	
}

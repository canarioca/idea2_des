package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcPsicoApoyoSocial;

public interface ServicioRCPsicoApoyoSocial {

	/**
	 * Metodo que obtiene los valores de la tabla maestra de Apoyo Social
	 * 
	 * @return
	 */
	public List<RcPsicoApoyoSocial> obtenerListadoApoyoSocial();
	
	/**
	 * Metodo que obtiene la seleccion del radio button para un paciente concreto
	 * por su idPsicologia
	 * 
	 * @param idPsicologia
	 * @return
	 */
	public RcPsicoApoyoSocial obtenerApoyoSocialSeleccionadoDelPaciente( long idPsicologia );
}

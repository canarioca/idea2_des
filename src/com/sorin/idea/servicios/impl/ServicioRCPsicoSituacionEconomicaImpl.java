package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoSituacionEconomica;
import com.sorin.idea.exceptions.RcPsicoSituacionEconomicaDaoException;
import com.sorin.idea.jdbc.RcPsicoSituacionEconomicaDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoSituacionEconomica;

public class ServicioRCPsicoSituacionEconomicaImpl implements ServicioRCPsicoSituacionEconomica {

	/**
	 * Método que obtiene la lista de la relacion de psicologia del sueño
	 * 
	 */
	public List<RcPsicoSituacionEconomica> obtenerListadoSituacionEconomica(){
		
		RcPsicoSituacionEconomicaDaoImpl rcPsicoSituacionEconomicaDaoImpl = new RcPsicoSituacionEconomicaDaoImpl();
		try {
			RcPsicoSituacionEconomica[] array = rcPsicoSituacionEconomicaDaoImpl.findAll();
			List<RcPsicoSituacionEconomica> lista = Arrays.asList(array);
			return lista;
		} catch (RcPsicoSituacionEconomicaDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcPsicoSituacionEconomica obtenerSituacionEconomicaSeleccionadoDelPaciente( long idPsicologia ) {
		
		RcPsicoSituacionEconomicaDaoImpl rcPsicoSituacionEconomicaDaoImpl = new RcPsicoSituacionEconomicaDaoImpl();
		try {
			RcPsicoSituacionEconomica resultado = rcPsicoSituacionEconomicaDaoImpl.findByInnerJoinRCRehabilitador( idPsicologia );
			return resultado;
		} catch (RcPsicoSituacionEconomicaDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoSituacionLaboral;
import com.sorin.idea.exceptions.RcPsicoSituacionLaboralDaoException;
import com.sorin.idea.jdbc.RcPsicoSituacionLaboralDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoSituacionLaboral;

public class ServicioRCPsicoSituacionLaboralImpl implements ServicioRCPsicoSituacionLaboral {

	/**
	 * Método que obtiene la lista de la relacion de psicologia del sueño
	 * 
	 */
	public List<RcPsicoSituacionLaboral> obtenerListadoSituacionLaboral(){
		
		RcPsicoSituacionLaboralDaoImpl rcPsicoSituacionLaboralDaoImpl = new RcPsicoSituacionLaboralDaoImpl();
		try {
			RcPsicoSituacionLaboral[] array = rcPsicoSituacionLaboralDaoImpl.findAll();
			List<RcPsicoSituacionLaboral> lista = Arrays.asList(array);
			return lista;
		} catch (RcPsicoSituacionLaboralDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcPsicoSituacionLaboral obtenerSituacionLaboralSeleccionadoDelPaciente( long idPsicologia ) {
		
		RcPsicoSituacionLaboralDaoImpl rcPsicoSituacionLaboralDaoImpl = new RcPsicoSituacionLaboralDaoImpl();
		try {
			RcPsicoSituacionLaboral resultado = rcPsicoSituacionLaboralDaoImpl.findByInnerJoinRCRehabilitador( idPsicologia );
			return resultado;
		} catch (RcPsicoSituacionLaboralDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

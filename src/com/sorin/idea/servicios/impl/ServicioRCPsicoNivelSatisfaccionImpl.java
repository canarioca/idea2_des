package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoNivelSatisfaccion;
import com.sorin.idea.exceptions.RcPsicoNivelSatisfaccionDaoException;
import com.sorin.idea.jdbc.RcPsicoNivelSatisfaccionDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoNivelSatisfaccion;

public class ServicioRCPsicoNivelSatisfaccionImpl implements ServicioRCPsicoNivelSatisfaccion {

	/**
	 * Método que obtiene la lista de la relacion de psicologia del sueño
	 * 
	 */
	public List<RcPsicoNivelSatisfaccion> obtenerListadoNivelSatisfaccion(){
		
		RcPsicoNivelSatisfaccionDaoImpl rcPsicoNivelSatisfaccionDaoImpl = new RcPsicoNivelSatisfaccionDaoImpl();
		try {
			RcPsicoNivelSatisfaccion[] array = rcPsicoNivelSatisfaccionDaoImpl.findAll();
			List<RcPsicoNivelSatisfaccion> lista = Arrays.asList(array);
			return lista;
		} catch (RcPsicoNivelSatisfaccionDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcPsicoNivelSatisfaccion obtenerNivelSatisfaccionSeleccionadoDelPaciente( long idPsicologia ) {
		
		RcPsicoNivelSatisfaccionDaoImpl rcPsicoNivelSatisfaccionDaoImpl = new RcPsicoNivelSatisfaccionDaoImpl();
		try {
			RcPsicoNivelSatisfaccion resultado = rcPsicoNivelSatisfaccionDaoImpl.findByInnerJoinRCRehabilitador( idPsicologia );
			return resultado;
		} catch (RcPsicoNivelSatisfaccionDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}

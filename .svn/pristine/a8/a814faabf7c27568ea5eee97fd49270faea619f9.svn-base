package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcRehaProbSensoriales;
import com.sorin.idea.exceptions.RcRehaProbSensorialesDaoException;
import com.sorin.idea.jdbc.RcRehaProbSensorialesDaoImpl;
import com.sorin.idea.servicios.ServicioRCRehaProbSensoriales;

public class ServicioRCRehaProbSensorialesImpl implements ServicioRCRehaProbSensoriales {

	/**
	 * Método que obtiene la lista de la relacion de psicologia del sueño
	 * 
	 */
	public List<RcRehaProbSensoriales> obtenerListadoProbSensoriales(){
		
		RcRehaProbSensorialesDaoImpl rcRehaProbSensorialesDaoImpl = new RcRehaProbSensorialesDaoImpl();
		try {
			RcRehaProbSensoriales[] array = rcRehaProbSensorialesDaoImpl.findAll();
			List<RcRehaProbSensoriales> lista = Arrays.asList(array);
			return lista;
		} catch (RcRehaProbSensorialesDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcRehaProbSensoriales obtenerProbSensorialesSeleccionadoDelPaciente( long idRehabilitador ) {
		
		RcRehaProbSensorialesDaoImpl rcRehaProbSensorialesDaoImpl = new RcRehaProbSensorialesDaoImpl();
		try {
			RcRehaProbSensoriales resultado = rcRehaProbSensorialesDaoImpl.findByInnerJoinRCRehabilitador( idRehabilitador );
			return resultado;
		} catch (RcRehaProbSensorialesDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}

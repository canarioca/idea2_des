package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcRehaNivelEducativo;
import com.sorin.idea.dto.RcRehaProbSensoriales;
import com.sorin.idea.exceptions.RcRehaNivelEducativoDaoException;
import com.sorin.idea.exceptions.RcRehaProbSensorialesDaoException;
import com.sorin.idea.jdbc.RcRehaNivelEducativoDaoImpl;
import com.sorin.idea.jdbc.RcRehaProbSensorialesDaoImpl;
import com.sorin.idea.servicios.ServicioRCRehaNivelEducativo;

public class ServicioRCRehaNivelEducativoImpl implements ServicioRCRehaNivelEducativo {

	/**
	 * Método que obtiene la lista de la relacion de psicologia del sueño
	 * 
	 */
	public List<RcRehaNivelEducativo> obtenerListadoNivelEducativo(){
		
		RcRehaNivelEducativoDaoImpl rcRehaNivelEducativoDaoImpl = new RcRehaNivelEducativoDaoImpl();
		try {
			RcRehaNivelEducativo[] array = rcRehaNivelEducativoDaoImpl.findAll();
			List<RcRehaNivelEducativo> lista = Arrays.asList(array);
			return lista;
		} catch (RcRehaNivelEducativoDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcRehaNivelEducativo obtenerProbSensorialesSeleccionadoDelPaciente( long idRehabilitador ) {
		
		RcRehaNivelEducativoDaoImpl rcRehaNivelEducativoDaoImpl = new RcRehaNivelEducativoDaoImpl();
		try {
			RcRehaNivelEducativo resultado = rcRehaNivelEducativoDaoImpl.findByInnerJoinRCRehabilitador( idRehabilitador );
			return resultado;
		} catch (RcRehaNivelEducativoDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}

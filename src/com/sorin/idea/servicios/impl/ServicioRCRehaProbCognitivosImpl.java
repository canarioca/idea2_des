package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcRehaProbCognitivos;
import com.sorin.idea.exceptions.RcRehaProbCognitivosDaoException;
import com.sorin.idea.jdbc.RcRehaProbCognitivosDaoImpl;
import com.sorin.idea.servicios.ServicioRCRehaProbCognitivos;

public class ServicioRCRehaProbCognitivosImpl implements ServicioRCRehaProbCognitivos {

	public List<RcRehaProbCognitivos> obtenerListadoProbCognitivos(){
		
		RcRehaProbCognitivosDaoImpl rcRehaProbCognitivosDaoImpl = new RcRehaProbCognitivosDaoImpl();
		try {
			RcRehaProbCognitivos[] array = rcRehaProbCognitivosDaoImpl.findAll();
			List<RcRehaProbCognitivos> lista = Arrays.asList(array);
			return lista;
		} catch (RcRehaProbCognitivosDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcRehaProbCognitivos obtenerProbCognitivoSeleccionadoDelPaciente( long idRehabilitador ) {
		
		RcRehaProbCognitivosDaoImpl rcRehaProbCognitivosDaoImpl = new RcRehaProbCognitivosDaoImpl();
		try {
			RcRehaProbCognitivos resultado = rcRehaProbCognitivosDaoImpl.findByInnerJoinRCRehabilitador( idRehabilitador );
			return resultado;
		} catch (RcRehaProbCognitivosDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

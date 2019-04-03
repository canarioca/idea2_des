package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcRehaProbArticulares;
import com.sorin.idea.exceptions.RcRehaProbArticularesDaoException;
import com.sorin.idea.jdbc.RcRehaProbArticularesDaoImpl;
import com.sorin.idea.servicios.ServicioRCRehaProbArticulares;

public class ServicioRCRehaProbArticularesImpl implements ServicioRCRehaProbArticulares {

	public List<RcRehaProbArticulares> obtenerListadoProbArticulares(){
		
		RcRehaProbArticularesDaoImpl rcRehaProbArticularesDaoImpl = new RcRehaProbArticularesDaoImpl();
		try {
			RcRehaProbArticulares[] array = rcRehaProbArticularesDaoImpl.findAll();
			List<RcRehaProbArticulares> lista = Arrays.asList(array);
			return lista;
		} catch (RcRehaProbArticularesDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	
	public RcRehaProbArticulares obtenerProbArticularSeleccionadoDelPaciente( long idRehabilitador ) {
		
		RcRehaProbArticularesDaoImpl rcRehaProbArticularesDaoImpl = new RcRehaProbArticularesDaoImpl();
		try {
			RcRehaProbArticulares resultado = rcRehaProbArticularesDaoImpl.findByInnerJoinRCRehabilitador( idRehabilitador );
			return resultado;
		} catch (RcRehaProbArticularesDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}

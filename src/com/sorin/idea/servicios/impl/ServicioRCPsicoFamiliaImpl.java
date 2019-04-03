package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoFamilia;
import com.sorin.idea.exceptions.RcPsicoFamiliaDaoException;
import com.sorin.idea.jdbc.RcPsicoFamiliaDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoFamilia;

public class ServicioRCPsicoFamiliaImpl implements ServicioRCPsicoFamilia {

	public List<RcPsicoFamilia> obtenerListadoFamilia(){
		
		RcPsicoFamiliaDaoImpl rcPsicoFamiliaDaoImpl = new RcPsicoFamiliaDaoImpl();
		try {
			RcPsicoFamilia[] array = rcPsicoFamiliaDaoImpl.findAll();
			List<RcPsicoFamilia> lista = Arrays.asList(array);
			return lista;
		} catch (RcPsicoFamiliaDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcPsicoFamilia obtenerFamiliaSeleccionadoDelPaciente( long idPsicologia ) {
		
		RcPsicoFamiliaDaoImpl rcPsicoFamiliaDaoImpl = new RcPsicoFamiliaDaoImpl();
		try {
			RcPsicoFamilia resultado = rcPsicoFamiliaDaoImpl.findByInnerJoinRCRehabilitador( idPsicologia );
			return resultado;
		} catch (RcPsicoFamiliaDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}

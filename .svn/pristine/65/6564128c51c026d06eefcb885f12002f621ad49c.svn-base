package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoVidaSexual;
import com.sorin.idea.exceptions.RcPsicoVidaSexualDaoException;
import com.sorin.idea.jdbc.RcPsicoVidaSexualDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoVidaSexual;

public class ServicioRCPsicoVidaSexualImpl implements ServicioRCPsicoVidaSexual {

	public List<RcPsicoVidaSexual> obtenerListadoVidaSexual(){
		
		RcPsicoVidaSexualDaoImpl rcPsicoVidaSexualDaoImpl = new RcPsicoVidaSexualDaoImpl();
		try {
			RcPsicoVidaSexual[] array = rcPsicoVidaSexualDaoImpl.findAll();
			List<RcPsicoVidaSexual> lista = Arrays.asList(array);
			return lista;
		} catch (RcPsicoVidaSexualDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcPsicoVidaSexual obtenerVidaSexualSeleccionadoDelPaciente( long idPsicologia ) {
		
		RcPsicoVidaSexualDaoImpl rcPsicoVidaSexualDaoImpl = new RcPsicoVidaSexualDaoImpl();
		try {
			RcPsicoVidaSexual resultado = rcPsicoVidaSexualDaoImpl.findByInnerJoinRCRehabilitador( idPsicologia );
			return resultado;
		} catch (RcPsicoVidaSexualDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}

package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoNivelIrritabilidad;
import com.sorin.idea.exceptions.RcPsicoNivelIrritabilidadDaoException;
import com.sorin.idea.jdbc.RcPsicoNivelIrritabilidadDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoNivelIrritabilidad;

public class ServicioRCPsicoNivelIrritabilidadImpl implements ServicioRCPsicoNivelIrritabilidad {

	public List<RcPsicoNivelIrritabilidad> obtenerListadoNivelIrritabilidad(){
		
		RcPsicoNivelIrritabilidadDaoImpl rcPsicoNivelIrritabilidadDaoImpl = new RcPsicoNivelIrritabilidadDaoImpl();
		try {
			RcPsicoNivelIrritabilidad[] array = rcPsicoNivelIrritabilidadDaoImpl.findAll();
			List<RcPsicoNivelIrritabilidad> lista = Arrays.asList(array);
			return lista;
		} catch (RcPsicoNivelIrritabilidadDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcPsicoNivelIrritabilidad obtenerNivelIrritabilidadSeleccionadoDelPaciente( long idPsicologia ) {
		
		RcPsicoNivelIrritabilidadDaoImpl rcPsicoNivelIrritabilidadDaoImpl = new RcPsicoNivelIrritabilidadDaoImpl();
		try {
			RcPsicoNivelIrritabilidad resultado = rcPsicoNivelIrritabilidadDaoImpl.findByInnerJoinRCRehabilitador( idPsicologia );
			return resultado;
		} catch (RcPsicoNivelIrritabilidadDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}

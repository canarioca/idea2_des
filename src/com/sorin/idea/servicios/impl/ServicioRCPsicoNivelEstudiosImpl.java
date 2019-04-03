package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoEstadoCivil;
import com.sorin.idea.dto.RcPsicoNivelEstudios;
import com.sorin.idea.exceptions.RcPsicoEstadoCivilDaoException;
import com.sorin.idea.exceptions.RcPsicoNivelEstudiosDaoException;
import com.sorin.idea.jdbc.RcPsicoEstadoCivilDaoImpl;
import com.sorin.idea.jdbc.RcPsicoNivelEstudiosDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoNivelEstudios;

public class ServicioRCPsicoNivelEstudiosImpl implements ServicioRCPsicoNivelEstudios {

	public List<RcPsicoNivelEstudios> obtenerListadoNivelEstudios(){
		
		RcPsicoNivelEstudiosDaoImpl rcPsicoNivelEstudiosDaoImpl = new RcPsicoNivelEstudiosDaoImpl();
		try {
			RcPsicoNivelEstudios[] array = rcPsicoNivelEstudiosDaoImpl.findAll();
			return Arrays.asList(array);
		} catch (RcPsicoNivelEstudiosDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public RcPsicoNivelEstudios obtenerEstadoCivilSeleccionadoDelPaciente( long idPsicologia ) {
		
		RcPsicoNivelEstudiosDaoImpl rcPsicoNivelEstudiosDaoImpl = new RcPsicoNivelEstudiosDaoImpl();
		try {
			RcPsicoNivelEstudios resultado = rcPsicoNivelEstudiosDaoImpl.findByInnerJoinRCRehabilitador( idPsicologia );
			return resultado;
		} catch (RcPsicoNivelEstudiosDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}

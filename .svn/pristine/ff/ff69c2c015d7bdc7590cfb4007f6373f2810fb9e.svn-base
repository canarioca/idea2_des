package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoEstadoCivil;
import com.sorin.idea.dto.RcRehaNivelEducativo;
import com.sorin.idea.exceptions.RcPsicoEstadoCivilDaoException;
import com.sorin.idea.exceptions.RcRehaNivelEducativoDaoException;
import com.sorin.idea.jdbc.RcPsicoEstadoCivilDaoImpl;
import com.sorin.idea.jdbc.RcRehaNivelEducativoDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoEstadoCivil;

public class ServicioRCPsicoEstadoCivilImpl implements ServicioRCPsicoEstadoCivil{

	public List<RcPsicoEstadoCivil> obtenerListadoEstadoCivil(){
		
		RcPsicoEstadoCivilDaoImpl rcPsicoEstadoCivilDaoImpl = new RcPsicoEstadoCivilDaoImpl();
		try {
			RcPsicoEstadoCivil[] array = rcPsicoEstadoCivilDaoImpl.findAll();
			return Arrays.asList(array);
		} catch (RcPsicoEstadoCivilDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public RcPsicoEstadoCivil obtenerEstadoCivilSeleccionadoDelPaciente( long idPsicologia ) {
		
		RcPsicoEstadoCivilDaoImpl rcPsicoEstadoCivilDaoImpl = new RcPsicoEstadoCivilDaoImpl();
		try {
			RcPsicoEstadoCivil resultado = rcPsicoEstadoCivilDaoImpl.findByInnerJoinRCRehabilitador( idPsicologia );
			return resultado;
		} catch (RcPsicoEstadoCivilDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}

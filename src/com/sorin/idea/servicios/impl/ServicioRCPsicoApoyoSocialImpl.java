package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoApoyoSocial;
import com.sorin.idea.exceptions.RcPsicoApoyoSocialDaoException;
import com.sorin.idea.jdbc.RcPsicoApoyoSocialDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoApoyoSocial;

public class ServicioRCPsicoApoyoSocialImpl implements ServicioRCPsicoApoyoSocial {

	/**
	 * Método que obtiene la lista de la relacion de psicologia del sueño
	 * 
	 */
	public List<RcPsicoApoyoSocial> obtenerListadoApoyoSocial(){
		
		RcPsicoApoyoSocialDaoImpl rcPsicoApoyoSocialDaoImpl = new RcPsicoApoyoSocialDaoImpl();
		try {
			RcPsicoApoyoSocial[] array = rcPsicoApoyoSocialDaoImpl.findAll();
			List<RcPsicoApoyoSocial> lista = Arrays.asList(array);
			return lista;
		} catch (RcPsicoApoyoSocialDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public RcPsicoApoyoSocial obtenerApoyoSocialSeleccionadoDelPaciente( long idPsicologia ) {
		
		RcPsicoApoyoSocialDaoImpl rcPsicoApoyoSocialDaoImpl = new RcPsicoApoyoSocialDaoImpl();
		try {
			RcPsicoApoyoSocial resultado = rcPsicoApoyoSocialDaoImpl.findByInnerJoinRCRehabilitador( idPsicologia );
			return resultado;
		} catch (RcPsicoApoyoSocialDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
}

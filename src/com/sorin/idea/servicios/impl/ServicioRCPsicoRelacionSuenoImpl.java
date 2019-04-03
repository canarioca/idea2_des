package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoRelacionSueno;
import com.sorin.idea.dto.RcPsicoRelacionSuenoPk;
import com.sorin.idea.exceptions.RcPsicoRelacionSuenoDaoException;
import com.sorin.idea.jdbc.RcPsicoRelacionSuenoDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoRelacionSueno;

public class ServicioRCPsicoRelacionSuenoImpl implements ServicioRCPsicoRelacionSueno {

	/**
	 * Método que obtiene la lista de la relacion de psicologia del sueño
	 * 
	 */
	public List<RcPsicoRelacionSueno> obtenerRelacionSueno( long idRcPsicologia ){
		
		RcPsicoRelacionSuenoDaoImpl rcPsicoRelacionSuenoDaoImpl = new RcPsicoRelacionSuenoDaoImpl();
		try {
			RcPsicoRelacionSueno[] array = rcPsicoRelacionSuenoDaoImpl.findByRcPsicologia( idRcPsicologia );
			List<RcPsicoRelacionSueno> lista = Arrays.asList(array);
			return lista;
		} catch (RcPsicoRelacionSuenoDaoException e) {
			return null;
		}
	}

	@Override
	public void eliminarRelacionSueno(RcPsicoRelacionSuenoPk rcPsicoRelacionSuenoPk) throws RcPsicoRelacionSuenoDaoException {
		RcPsicoRelacionSuenoDaoImpl rcPsicoRelacionSuenoDaoImpl = new RcPsicoRelacionSuenoDaoImpl();
		rcPsicoRelacionSuenoDaoImpl.delete( rcPsicoRelacionSuenoPk );
	}

	@Override
	public void guardarCalidadSueno(RcPsicoRelacionSueno rcPsicoRelacionSueno) throws RcPsicoRelacionSuenoDaoException {
		RcPsicoRelacionSuenoDaoImpl rcPsicoRelacionSuenoDaoImpl = new RcPsicoRelacionSuenoDaoImpl();
		rcPsicoRelacionSuenoDaoImpl.insert( rcPsicoRelacionSueno );
	}
}

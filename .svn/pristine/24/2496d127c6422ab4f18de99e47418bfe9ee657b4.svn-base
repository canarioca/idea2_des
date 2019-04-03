package com.sorin.idea.servicios.impl;

import java.util.Arrays;
import java.util.List;

import com.sorin.idea.dto.RcPsicoCalidadSueno;
import com.sorin.idea.exceptions.RcPsicoCalidadSuenoDaoException;
import com.sorin.idea.jdbc.RcPsicoCalidadSuenoDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicoCalidadSueno;

public class ServicioRCPsicoCalidadSuenoImpl implements ServicioRCPsicoCalidadSueno {
	
	public List<RcPsicoCalidadSueno> obtenerListadoCalidadSueno(){
		
		RcPsicoCalidadSuenoDaoImpl rcPsicoCalidadSuenoDao = new RcPsicoCalidadSuenoDaoImpl();
		try {
			RcPsicoCalidadSueno[] array = rcPsicoCalidadSuenoDao.findAll();
			return Arrays.asList(array);
		} catch (RcPsicoCalidadSuenoDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}

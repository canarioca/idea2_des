package com.sorin.idea.servicios.impl;

import com.sorin.idea.dto.RcPsicologia;
import com.sorin.idea.dto.RcPsicologiaPk;
import com.sorin.idea.exceptions.RcPsicologiaDaoException;
import com.sorin.idea.jdbc.RcPsicologiaDaoImpl;
import com.sorin.idea.servicios.ServicioRCPsicologia;

public class ServicioRCPsicologiaImpl implements ServicioRCPsicologia{

	@Override
	public RcPsicologia buscar(int id) {
		RcPsicologiaDaoImpl rcPsicologiaDaoImpl = new RcPsicologiaDaoImpl();
		try {
			return rcPsicologiaDaoImpl.findByPrimaryKey( id );
		} catch (RcPsicologiaDaoException e) {
			return null;
		}
	}

	@Override
	public void eliminar(RcPsicologiaPk pkPsicologia) throws RcPsicologiaDaoException {
		RcPsicologiaDaoImpl rcPsicologiaDaoImpl = new RcPsicologiaDaoImpl();
		rcPsicologiaDaoImpl.delete( pkPsicologia );
	}

	@Override
	public RcPsicologiaPk guardar(RcPsicologia rcPsicologia) {
		
		RcPsicologiaDaoImpl rcPsicologiaDaoImpl = new RcPsicologiaDaoImpl();
		try {
			return rcPsicologiaDaoImpl.insert( rcPsicologia );
		} catch (RcPsicologiaDaoException e) {
			return null;
		}
	}

	@Override
	public void actualizar(RcPsicologiaPk pkPsicologia, RcPsicologia rcPsicologia) throws RcPsicologiaDaoException {
		RcPsicologiaDaoImpl rcPsicologiaDaoImpl = new RcPsicologiaDaoImpl();
		rcPsicologiaDaoImpl.update( pkPsicologia, rcPsicologia );
	}
}

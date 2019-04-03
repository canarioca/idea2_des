package com.sorin.idea.servicios.impl;

import com.sorin.idea.dto.RcRehabilitador;
import com.sorin.idea.dto.RcRehabilitadorPk;
import com.sorin.idea.exceptions.RcRehabilitadorDaoException;
import com.sorin.idea.jdbc.RcRehabilitadorDaoImpl;
import com.sorin.idea.servicios.ServicioRCRehabilitador;

public class ServicioRCRehabilitadorImpl implements ServicioRCRehabilitador {

	@Override
	public RcRehabilitador buscar(int id) {
		
		RcRehabilitadorDaoImpl rcRehabilitadorDaoImpl = new RcRehabilitadorDaoImpl();
		try {
			return rcRehabilitadorDaoImpl.findByPrimaryKey( id );
		} catch (RcRehabilitadorDaoException e) {
			return null;
		}
	}

	@Override
	public void eliminar(RcRehabilitadorPk pkRehabilitador) throws RcRehabilitadorDaoException {
		
		RcRehabilitadorDaoImpl rcRehabilitadorDaoImpl = new RcRehabilitadorDaoImpl();
		rcRehabilitadorDaoImpl.delete( pkRehabilitador );
		
	}

	@Override
	public RcRehabilitadorPk guardar( RcRehabilitador rcRehabilitador) {
		RcRehabilitadorDaoImpl rcRehabilitadorDaoImpl = new RcRehabilitadorDaoImpl();
		 try {
			return rcRehabilitadorDaoImpl.insert( rcRehabilitador );
		} catch (RcRehabilitadorDaoException e) {
			return null;
		}
	}

	@Override
	public void actualizar(RcRehabilitadorPk pkRehabilitador, RcRehabilitador rcRehabilitador) throws RcRehabilitadorDaoException {

		RcRehabilitadorDaoImpl rcRehabilitadorDaoImpl = new RcRehabilitadorDaoImpl();
		rcRehabilitadorDaoImpl.update( pkRehabilitador, rcRehabilitador );
		
	}
	
	
}

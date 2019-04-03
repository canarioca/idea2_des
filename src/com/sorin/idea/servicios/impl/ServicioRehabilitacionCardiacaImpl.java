package com.sorin.idea.servicios.impl;

import com.sorin.idea.dto.RcRehabilitacionCardiaca;
import com.sorin.idea.dto.RcRehabilitacionCardiacaPk;
import com.sorin.idea.exceptions.RcRehabilitacionCardiacaDaoException;
import com.sorin.idea.jdbc.RcRehabilitacionCardiacaDaoImpl;
import com.sorin.idea.servicios.ServicioRehabilitacionCardiaca;

public class ServicioRehabilitacionCardiacaImpl implements ServicioRehabilitacionCardiaca {

	@Override
	public RcRehabilitacionCardiaca obtenerRC( int id ) {
		
		RcRehabilitacionCardiacaDaoImpl rcRehabilitacionCardiacaDaoImpl = new RcRehabilitacionCardiacaDaoImpl();
		try {
			return rcRehabilitacionCardiacaDaoImpl.findByPrimaryKey( id );
		} catch (RcRehabilitacionCardiacaDaoException e) {
			return null;
		}
	}

	@Override
	public RcRehabilitacionCardiacaPk guardarRC(RcRehabilitacionCardiaca rcRehabilitacionCardiaca) {
		RcRehabilitacionCardiacaDaoImpl rcRehabilitacionCardiacaDaoImpl = new RcRehabilitacionCardiacaDaoImpl();
		try {
			return rcRehabilitacionCardiacaDaoImpl.insert( rcRehabilitacionCardiaca );
		} catch (RcRehabilitacionCardiacaDaoException e) {
			return null;
		}
	}

	@Override
	public void updateRC( RcRehabilitacionCardiacaPk rcRehabilitacionCardiacaPk, RcRehabilitacionCardiaca rcRehabilitacionCardiaca) {
		RcRehabilitacionCardiacaDaoImpl rcRehabilitacionCardiacaDaoImpl = new RcRehabilitacionCardiacaDaoImpl();
		try {
			rcRehabilitacionCardiacaDaoImpl.update( rcRehabilitacionCardiacaPk, rcRehabilitacionCardiaca );
		} catch (RcRehabilitacionCardiacaDaoException e) {
			
		}
	}

	@Override
	public void eliminarRC(RcRehabilitacionCardiacaPk rcRehabilitacionCardiacaPk) throws RcRehabilitacionCardiacaDaoException {
		RcRehabilitacionCardiacaDaoImpl rcRehabilitacionCardiacaDaoImpl = new RcRehabilitacionCardiacaDaoImpl();
		rcRehabilitacionCardiacaDaoImpl.delete(rcRehabilitacionCardiacaPk);
	}
}

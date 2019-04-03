package com.sorin.idea.servicios.impl;

import com.sorin.idea.dto.RcNutricion;
import com.sorin.idea.dto.RcNutricionPk;
import com.sorin.idea.exceptions.RcNutricionDaoException;
import com.sorin.idea.jdbc.RcNutricionDaoImpl;
import com.sorin.idea.servicios.ServicioRCNutricion;

public class ServicioRCNutricionImpl implements ServicioRCNutricion {

	@Override
	public RcNutricion buscar(int id) {

		RcNutricionDaoImpl rcNutricionDaoImpl = new RcNutricionDaoImpl();
		try {
			return rcNutricionDaoImpl.findByPrimaryKey( id );
		} catch (RcNutricionDaoException e) {
			return null;
		}
	}

	@Override
	public void eliminar(RcNutricionPk pkNutricion) throws RcNutricionDaoException {
		RcNutricionDaoImpl rcNutricionDaoImpl = new RcNutricionDaoImpl();
		rcNutricionDaoImpl.delete( pkNutricion );
	}

	@Override
	public RcNutricionPk guardar(RcNutricion rcNutricion) {
		RcNutricionDaoImpl rcNutricionDaoImpl = new RcNutricionDaoImpl();
		try {
			return rcNutricionDaoImpl.insert( rcNutricion );
		} catch (RcNutricionDaoException e) {
			return null;
		}
	}

	@Override
	public void actualizar(RcNutricionPk pkNutricion, RcNutricion rcNutricion) throws RcNutricionDaoException {
		RcNutricionDaoImpl rcNutricionDaoImpl = new RcNutricionDaoImpl();
		rcNutricionDaoImpl.update( pkNutricion, rcNutricion );
	}
}

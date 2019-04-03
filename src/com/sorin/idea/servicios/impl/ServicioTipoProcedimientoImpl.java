package com.sorin.idea.servicios.impl;

import com.sorin.idea.dto.TipoProcedimiento;
import com.sorin.idea.exceptions.TipoProcedimientoDaoException;
import com.sorin.idea.jdbc.TipoProcedimientoDaoImpl;
import com.sorin.idea.servicios.ServicioTipoProcedimiento;

public class ServicioTipoProcedimientoImpl implements ServicioTipoProcedimiento{

	@Override
	public TipoProcedimiento obtenerTipoProcedimiento(int idTipoProcedimiento) throws TipoProcedimientoDaoException {
		TipoProcedimientoDaoImpl tipoImpl = new TipoProcedimientoDaoImpl();
		return tipoImpl.findByPrimaryKey( idTipoProcedimiento );
	}
}

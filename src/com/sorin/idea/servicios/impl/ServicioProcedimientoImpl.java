package com.sorin.idea.servicios.impl;

import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.exceptions.ProcedimientoDaoException;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.servicios.ServicioProcedimiento;

public class ServicioProcedimientoImpl implements ServicioProcedimiento {

	@Override
	public void guardarProcedimiento(Procedimiento procedimiento) {
		
		try {
			ProcedimientoDaoImpl dao = new ProcedimientoDaoImpl();
			dao.insert( procedimiento );
		} catch (ProcedimientoDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

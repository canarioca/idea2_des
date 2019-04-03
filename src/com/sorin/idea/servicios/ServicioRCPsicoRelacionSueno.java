package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcPsicoRelacionSueno;
import com.sorin.idea.dto.RcPsicoRelacionSuenoPk;
import com.sorin.idea.exceptions.RcPsicoRelacionSuenoDaoException;

public interface ServicioRCPsicoRelacionSueno {

	/**
	 * Metodo que obtiene los valores de la tabla relacion sue�o para un id de psicologia
	 * 
	 * @return
	 */
	public List<RcPsicoRelacionSueno> obtenerRelacionSueno( long psico );
	
	/**
	 * Metodo que elimina un objeto Relacion Sue�o del sistema
	 * 
	 * @param rcPsicoRelacionSuenoPk
	 * @throws RcPsicoRelacionSuenoDaoException 
	 */
	public void eliminarRelacionSueno( RcPsicoRelacionSuenoPk rcPsicoRelacionSuenoPk ) throws RcPsicoRelacionSuenoDaoException;

	/**
	 * M�todo que guarda la relacion de calidad sue�o
	 * 
	 * @param rcPsicoRelacionSueno
	 * @throws RcPsicoRelacionSuenoDaoException 
	 */
	public void guardarCalidadSueno( RcPsicoRelacionSueno rcPsicoRelacionSueno ) throws RcPsicoRelacionSuenoDaoException;
	
}

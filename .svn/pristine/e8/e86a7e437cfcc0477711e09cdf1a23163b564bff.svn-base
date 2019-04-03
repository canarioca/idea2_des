package com.sorin.idea.servicios;

import java.util.List;

import com.sorin.idea.dto.RcPsicoRelacionSueno;
import com.sorin.idea.dto.RcPsicoRelacionSuenoPk;
import com.sorin.idea.exceptions.RcPsicoRelacionSuenoDaoException;

public interface ServicioRCPsicoRelacionSueno {

	/**
	 * Metodo que obtiene los valores de la tabla relacion sueño para un id de psicologia
	 * 
	 * @return
	 */
	public List<RcPsicoRelacionSueno> obtenerRelacionSueno( long psico );
	
	/**
	 * Metodo que elimina un objeto Relacion Sueño del sistema
	 * 
	 * @param rcPsicoRelacionSuenoPk
	 * @throws RcPsicoRelacionSuenoDaoException 
	 */
	public void eliminarRelacionSueno( RcPsicoRelacionSuenoPk rcPsicoRelacionSuenoPk ) throws RcPsicoRelacionSuenoDaoException;

	/**
	 * Método que guarda la relacion de calidad sueño
	 * 
	 * @param rcPsicoRelacionSueno
	 * @throws RcPsicoRelacionSuenoDaoException 
	 */
	public void guardarCalidadSueno( RcPsicoRelacionSueno rcPsicoRelacionSueno ) throws RcPsicoRelacionSuenoDaoException;
	
}

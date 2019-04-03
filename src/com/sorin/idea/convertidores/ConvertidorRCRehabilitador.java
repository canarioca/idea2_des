package com.sorin.idea.convertidores;

import com.sorin.idea.dto.RcRehabilitador;
import com.sorin.idea.dto.RehabiliatadorDTO;

public class ConvertidorRCRehabilitador {

	/**
	 *  Método encargado de convertir un objeto RcRehabilitadorDTO a objeto Rehabiliatador
	 * 
	 * @param idRehabilitador
	 * @param rehabilitadorDTO
	 * @return
	 */
	public static RcRehabilitador convertirRCRehabilitador( int idRehabilitador, RehabiliatadorDTO rehabilitadorDTO ) {
		
		RcRehabilitador rcRehabilitador = new RcRehabilitador();
			
		if( rehabilitadorDTO.getFechaRehabilitador() != null ) {
			rcRehabilitador.setFecha( rehabilitadorDTO.getFechaRehabilitador() );
		}
		
		if( rehabilitadorDTO.getFechaRehabilitador() != null ) {
			rcRehabilitador.setSedentarismo( rehabilitadorDTO.getSedentarismo() == false ? 0 : 1 );
		}
		
		if( rehabilitadorDTO.getNivelEjercicio() != null ) {
			rcRehabilitador.setNivelEjercicio( rehabilitadorDTO.getNivelEjercicio() );
		}
		
		if( rehabilitadorDTO.getAnsiedadFEVIFVC() != null ) {
			rcRehabilitador.setParametroFvcFevi( rehabilitadorDTO.getAnsiedadFEVIFVC() );
		}
		
		if( rehabilitadorDTO.getFechaRehabilitador() != null ) {
			rcRehabilitador.setParametroFvc( rehabilitadorDTO.getParametroFVC() );
		}
		
		if( rehabilitadorDTO.getFechaRehabilitador() != null ) {
			rcRehabilitador.setParametroFevi( rehabilitadorDTO.getParametroFEVI() );
		}
		
		if( rehabilitadorDTO.getFechaRehabilitador() != null ) {
			rcRehabilitador.setHorasEjercicio( rehabilitadorDTO.getHorasEjercicio() );
		}
		
		if( rehabilitadorDTO.getSelectedNivelEducativo() != null && !rehabilitadorDTO.getSelectedNivelEducativo().equals("" ) )
			rcRehabilitador.setIdNivelEducativo( Integer.valueOf( rehabilitadorDTO.getSelectedNivelEducativo() ) );
		
		if( rehabilitadorDTO.getSelectedProbArticulares() != null && !rehabilitadorDTO.getSelectedProbArticulares().equals("" ) )
			rcRehabilitador.setIdProblemaArticular( Integer.valueOf( rehabilitadorDTO.getSelectedProbArticulares() ) );
		
		if( rehabilitadorDTO.getSelectedProbCognitivos() != null && !rehabilitadorDTO.getSelectedProbCognitivos().equals("" ) )
			rcRehabilitador.setIdProblemaCognitivo( Integer.valueOf( rehabilitadorDTO.getSelectedProbCognitivos() ) );
		
		if( rehabilitadorDTO.getSelectedProbSensoriales() != null && !rehabilitadorDTO.getSelectedProbSensoriales().equals("" ) )
			rcRehabilitador.setIdProblemaSensorial( Integer.valueOf( rehabilitadorDTO.getSelectedProbSensoriales() ) );
		
		return rcRehabilitador;
		
	}
	
	/**
	 * Método encargado de convertir un objeto RcRehabilitador a objeto RehabiliatadorDTO
	 * 
	 * @param rcRehabilitador
	 * @return
	 */
	public static RehabiliatadorDTO convertirRCRehabilitadorDTO( RcRehabilitador rcRehabilitador ) {
		RehabiliatadorDTO rehabilitadorDTO = new RehabiliatadorDTO();
		rehabilitadorDTO.setNivelEjercicio(  rcRehabilitador.getNivelEjercicio() );
		rehabilitadorDTO.setAnsiedadFEVIFVC(rcRehabilitador.getParametroFvcFevi());
		rehabilitadorDTO.setFechaRehabilitador( rcRehabilitador.getFecha() );
		rehabilitadorDTO.setHorasEjercicio( rcRehabilitador.getHorasEjercicio() );
		rehabilitadorDTO.setParametroFEVI( rcRehabilitador.getParametroFevi() );
		rehabilitadorDTO.setParametroFVC( rcRehabilitador.getParametroFvc() );
		rehabilitadorDTO.setSedentarismo( rcRehabilitador.getSedentarismo() == 0 ? false : true );
		return rehabilitadorDTO;
	}
}

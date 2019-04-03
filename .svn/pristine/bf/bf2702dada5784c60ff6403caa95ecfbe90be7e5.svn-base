package com.sorin.idea.convertidores;

import java.math.BigDecimal;

import com.sorin.idea.dto.NutricionistaDTO;
import com.sorin.idea.dto.RcNutricion;

public class ConvertidorRCNutricionista {

	/**
	 * Método encargado de convertir un objeto de NutricionistaDTO a objeto RcNutricion
	 * 
	 * @param idNutricion
	 * @param nutricionistaDTO
	 * @return
	 */
	public static RcNutricion convertirRcNutricion( int idNutricion, NutricionistaDTO nutricionistaDTO ) {
		
		RcNutricion rcNutricion = new RcNutricion();
		
		rcNutricion.setFecha( nutricionistaDTO.getFechaCreacion() );
		
		if ( nutricionistaDTO.getCinturaCadera() != null && !nutricionistaDTO.getCinturaCadera().equals("") ) {
			rcNutricion.setCinturaCadera( new BigDecimal( nutricionistaDTO.getCinturaCadera() ) );
		}
		
		if ( nutricionistaDTO.getEscalaDietetica() != null && !nutricionistaDTO.getEscalaDietetica().equals("") ) {
			rcNutricion.setEscalaDietetica( new BigDecimal( nutricionistaDTO.getEscalaDietetica() ) );
		}

		if ( nutricionistaDTO.getIndiceCinturaCadera() != null && !nutricionistaDTO.getIndiceCinturaCadera().equals("") ) {
			rcNutricion.setIndiceCintura( new BigDecimal( nutricionistaDTO.getIndiceCinturaCadera() ) );
		}

		if ( nutricionistaDTO.getIndiceCinturaTalla() != null && !nutricionistaDTO.getIndiceCinturaTalla().equals("") ) {
			rcNutricion.setIndiceCinturaTalla( new BigDecimal( nutricionistaDTO.getIndiceCinturaTalla() ) );
		}

		if ( nutricionistaDTO.getMasaGrasaCorporal() != null && !nutricionistaDTO.getMasaGrasaCorporal().equals("") ) {
			rcNutricion.setMasaGrasaCorporal( new BigDecimal( nutricionistaDTO.getMasaGrasaCorporal() ));
		}

		if ( nutricionistaDTO.getMasaMuscularEsqueletico() != null && !nutricionistaDTO.getMasaMuscularEsqueletico().equals("") ) {
			rcNutricion.setMasaMuscular( new BigDecimal( nutricionistaDTO.getMasaMuscularEsqueletico() ) );
		}
		
		if ( nutricionistaDTO.getPerimetroAbdominal() != null && !nutricionistaDTO.getPerimetroAbdominal().equals("") ) {
			rcNutricion.setPerimetroAbdominal( new BigDecimal( nutricionistaDTO.getPerimetroAbdominal()  ) );
		}

		if ( nutricionistaDTO.getPerimetroCintura() != null && !nutricionistaDTO.getPerimetroCintura().equals("") ) {
			rcNutricion.setPerimetroCintura( new BigDecimal( nutricionistaDTO.getPerimetroCintura() ) );
		}
		
		if ( nutricionistaDTO.getPorcentajeGrasaCorporal() != null && !nutricionistaDTO.getPorcentajeGrasaCorporal().equals("") ) {
			rcNutricion.setPorcentajeGrasaCorporal( new BigDecimal( nutricionistaDTO.getPorcentajeGrasaCorporal() ) );
		}
		
		if ( nutricionistaDTO.getRelacionCinturaCadera() != null && !nutricionistaDTO.getRelacionCinturaCadera().equals("") ) {
			rcNutricion.setRelacionCinturaCadera( new BigDecimal( nutricionistaDTO.getRelacionCinturaCadera() ) );
		}
		
		return rcNutricion;
	}

	/**
	 * Método encargado de convertir un objeto de RcNutricion a objeto RcNutricionDTO
	 * 
	 * @param rcNutricion
	 * @return
	 */
	public static NutricionistaDTO convertirRCNutricionistaDTO( RcNutricion rcNutricion ) {
		
		NutricionistaDTO nutricionistaDTO = new NutricionistaDTO(); 
		
		if( rcNutricion.getCinturaCadera() != null ) {
			nutricionistaDTO.setCinturaCadera( rcNutricion.getCinturaCadera().toString()  );
		}
		
		if( rcNutricion.getEscalaDietetica() != null ) {
			nutricionistaDTO.setEscalaDietetica( rcNutricion.getEscalaDietetica().toString() );		
		}
		
		if( rcNutricion.getFecha() != null ) {
			nutricionistaDTO.setFechaCreacion( rcNutricion.getFecha() );
		}
		
		if( rcNutricion.getIndiceCintura() != null) {
			nutricionistaDTO.setIndiceCinturaCadera( rcNutricion.getIndiceCintura().toString() );
		}
		
		if( rcNutricion.getIndiceCinturaTalla() != null ) {
			nutricionistaDTO.setIndiceCinturaTalla( rcNutricion.getIndiceCinturaTalla().toString() );
		}
		
		if( rcNutricion.getMasaGrasaCorporal() != null  ) {
			nutricionistaDTO.setMasaGrasaCorporal( rcNutricion.getMasaGrasaCorporal().toString() );
		}
		
		if( rcNutricion.getMasaMuscular() != null ) {
			nutricionistaDTO.setMasaMuscularEsqueletico( rcNutricion.getMasaMuscular().toString() );
		}
		
		if( rcNutricion.getPerimetroAbdominal() != null ) {
			nutricionistaDTO.setPerimetroAbdominal( rcNutricion.getPerimetroAbdominal().toString() );
		}
		
		if( rcNutricion.getPerimetroCintura() != null ) {
			nutricionistaDTO.setPerimetroCintura( rcNutricion.getPerimetroCintura().toString() );
		}
		
		if( rcNutricion.getPorcentajeGrasaCorporal() != null ) {
			nutricionistaDTO.setPorcentajeGrasaCorporal( rcNutricion.getPorcentajeGrasaCorporal().toString() );
		}
		
		if( rcNutricion.getRelacionCinturaCadera() != null ) {
			nutricionistaDTO.setRelacionCinturaCadera( rcNutricion.getRelacionCinturaCadera().toString() ) ;
		}
		
		return nutricionistaDTO;
	}
	
}

package com.sorin.idea.convertidores;

import com.sorin.idea.dto.PsicologaDTO;
import com.sorin.idea.dto.RcPsicologia;

public class ConvertidorRCPsicologia {

	/**
	 * Método encargado de convertir un objeto PsicologaDTO a objeto RcPsicologia
	 * 
	 * @param idRcPsicologia
	 * @param psicologaDTO
	 * @return
	 */
	public static RcPsicologia convertirRCPsicologia( int idRcPsicologia, PsicologaDTO psicologaDTO ) {
		
		RcPsicologia rcPsicologia = new RcPsicologia();
		
		if( psicologaDTO.getAntecedentesPsiquiatricosFamiliares() != null ) {
			rcPsicologia.setAntecPsiqFam( psicologaDTO.getAntecedentesPsiquiatricosFamiliares() == false ? 0 : 1 );	
		}
		
		if( psicologaDTO.getAntecedentesPsiquiatricosFamiliaresDiagnostico() != null) {
			rcPsicologia.setAntecPsiqFamDiag( psicologaDTO.getAntecedentesPsiquiatricosFamiliaresDiagnostico() );
		}
		
		if( psicologaDTO.getAntecedentesPsiquiatricosFamiliaresGrado() != null ) {
			rcPsicologia.setAntecPsiqFamFinal( psicologaDTO.getAntecedentesPsiquiatricosFamiliaresGrado() );
		}
		
		if( psicologaDTO.getAntecedentesPsiquiatricosPersonales() != null ) {
			rcPsicologia.setAntecPsiqPers( psicologaDTO.getAntecedentesPsiquiatricosPersonales() == false ? 0 : 1 );
		}
			
		if( psicologaDTO.getFechaPsicologa() != null ) {
			rcPsicologia.setFecha( psicologaDTO.getFechaPsicologa() );
		}
		
		if( psicologaDTO.getSelectedApoyoSocial() != null && !psicologaDTO.getSelectedApoyoSocial().equals("" ) ) {
			rcPsicologia.setIdApoyoSocial( Integer.valueOf(  psicologaDTO.getSelectedApoyoSocial() ) );			
		}
		
		if( psicologaDTO.getSelectedEstadoCivil() != null && !psicologaDTO.getSelectedEstadoCivil().equals("" ) ) {
			rcPsicologia.setIdEstadoCivil( Integer.valueOf( psicologaDTO.getSelectedEstadoCivil() ) );			
		}
		
		if( psicologaDTO.getSelectedFamilia() != null && !psicologaDTO.getSelectedFamilia().equals("" ) ) {
			rcPsicologia.setIdFamilia( Integer.valueOf( psicologaDTO.getSelectedFamilia() ) );			
		}
		
		if( psicologaDTO.getSelectedVidaSexual() != null && !psicologaDTO.getSelectedVidaSexual().equals("" ) ) {
			rcPsicologia.setIdNivelEstudios( Integer.valueOf( psicologaDTO.getSelectedVidaSexual() ) );			
		}
		
		if( psicologaDTO.getSelectedNivelIrritabilidad() != null && !psicologaDTO.getSelectedNivelIrritabilidad().equals("" ) ) {
			rcPsicologia.setIdNivelIrritabilidad( Integer.valueOf( psicologaDTO.getSelectedNivelIrritabilidad() ));			
		}
		
		if( psicologaDTO.getSelectedNivelSatisfaccion() != null && !psicologaDTO.getSelectedNivelSatisfaccion().equals("" ) ) {
			rcPsicologia.setIdNivelSatisfaccion( Integer.valueOf( psicologaDTO.getSelectedNivelSatisfaccion() ) );			
		}
		
		if( psicologaDTO.getSelectedSituacionEconomica() != null && !psicologaDTO.getSelectedSituacionEconomica().equals("" ) )
			rcPsicologia.setIdSituacionEconomica( Integer.valueOf( psicologaDTO.getSelectedSituacionEconomica() ) );
		
		if( psicologaDTO.getSelectedSituacionLaboral() != null && !psicologaDTO.getSelectedSituacionLaboral().equals("" ) ) {
			rcPsicologia.setIdSituacionLaboral( Integer.valueOf( psicologaDTO.getSelectedSituacionLaboral() ) );			
		}
		
		if( psicologaDTO.getSelectedVidaSexual() != null && !psicologaDTO.getSelectedVidaSexual().equals("") ) {
			rcPsicologia.setIdVidaSexual( Integer.valueOf( psicologaDTO.getSelectedVidaSexual() ) );			
		}
		
		if( psicologaDTO.getSelectedNivelEstudios() != null && !psicologaDTO.getSelectedNivelEstudios().equals("" ) ) {
			rcPsicologia.setIdNivelEstudios( Integer.valueOf( psicologaDTO.getSelectedNivelEstudios() ) );			
		}

		if( psicologaDTO.getSelectedNivelEstudios() != null && !psicologaDTO.getSelectedNivelEstudios().equals("" ) ) {
			
		}
		
		if( psicologaDTO.getProfesion() != null && !psicologaDTO.getProfesion().equals("" ) ) {
			rcPsicologia.setProfesion( psicologaDTO.getProfesion() );
		}
		
		if( psicologaDTO.getDepresionDBI() != null && !psicologaDTO.getDepresionDBI().equals("" ) ) {
			rcPsicologia.setParametroDbiIi( psicologaDTO.getDepresionDBI() );
		}

		if( psicologaDTO.getAfrontamientoAFN() != null && !psicologaDTO.getAfrontamientoAFN().equals("" ) ) {
			rcPsicologia.setParametroAfn( psicologaDTO.getAfrontamientoAFN() );
		}
		
		if( psicologaDTO.getAnsiedadAE() != null && !psicologaDTO.getAnsiedadAE().equals("" ) ) {
			rcPsicologia.setParametroAe( psicologaDTO.getAnsiedadAE() );
		}
		
		if( psicologaDTO.getAfrontamientoFSP() != null && !psicologaDTO.getAfrontamientoFSP().equals("" ) ) {
			rcPsicologia.setParametroFsp( psicologaDTO.getAfrontamientoFSP() );
		}
		
		if( psicologaDTO.getAfrontamientoEVI() != null && !psicologaDTO.getAfrontamientoEVI().equals("" ) ) {
			rcPsicologia.setParametroEvi( psicologaDTO.getAfrontamientoEVI() );
		}
		
		if( psicologaDTO.getAfrontamientoEVI() != null && !psicologaDTO.getAfrontamientoEVI().equals("" ) ) {
			rcPsicologia.setParametroEvi( psicologaDTO.getAfrontamientoEVI() );
		}
		
		if( psicologaDTO.getAfrontamientoEEA() != null && !psicologaDTO.getAfrontamientoEEA().equals("" ) ) {
			rcPsicologia.setParametroEea( psicologaDTO.getAfrontamientoEEA() );
		}
		
		if( psicologaDTO.getAfrontamientoBAS() != null && !psicologaDTO.getAfrontamientoBAS().equals("" ) ) {
			rcPsicologia.setParametroBas( psicologaDTO.getAfrontamientoBAS() );
		}
		
		if( psicologaDTO.getAnsiedadAR() != null && !psicologaDTO.getAnsiedadAR().equals("" ) ) {
			rcPsicologia.setParametroAr( psicologaDTO.getAnsiedadAR() );
		}
		
		if( psicologaDTO.getAfrontamientoREP() != null && !psicologaDTO.getAfrontamientoREP().equals("" ) ) {
			rcPsicologia.setParametroRep( psicologaDTO.getAfrontamientoREP() );
		}
		
		if( psicologaDTO.getAfrontamientoRLG() != null && !psicologaDTO.getAfrontamientoRLG().equals("" ) ) {
			rcPsicologia.setParametroRlg( psicologaDTO.getAfrontamientoRLG() );	
		}
		
		if( psicologaDTO.getAnsiedadSTAI() != null && !psicologaDTO.getAnsiedadSTAI().equals("" ) ) {
			rcPsicologia.setParametroStai( psicologaDTO.getAnsiedadSTAI() );	
		}
		
		if( psicologaDTO.getNumHijos() != null ) {
			rcPsicologia.setNumHijos( psicologaDTO.getNumHijos() );	
		}
		
		return rcPsicologia;
	}
	
	/**
	 * Método encargado de convertir un objeto RcPsicologia a objeto PsicologaDTO
	 * 
	 * @param rcPsicologia
	 * @return
	 */
	public static PsicologaDTO convertirRCPsicologiaDTO( RcPsicologia rcPsicologia ) {
		
		PsicologaDTO psicologaDTO = new PsicologaDTO();
		psicologaDTO.setDepresionDBI( rcPsicologia.getParametroDbiIi() );
		psicologaDTO.setAfrontamientoAFN( rcPsicologia.getParametroAfn() );
		psicologaDTO.setAfrontamientoBAS( rcPsicologia.getParametroBas() );
		psicologaDTO.setAfrontamientoEEA( rcPsicologia.getParametroEea() );
		psicologaDTO.setAfrontamientoEVI( rcPsicologia.getParametroEvi() );
		psicologaDTO.setAfrontamientoFSP( rcPsicologia.getParametroFsp() );
		psicologaDTO.setAfrontamientoREP( rcPsicologia.getParametroRep() );
		psicologaDTO.setAfrontamientoRLG( rcPsicologia.getParametroRlg() );
		psicologaDTO.setAnsiedadAE( rcPsicologia.getParametroAe() );
		psicologaDTO.setAnsiedadAR( rcPsicologia.getParametroAr() );
		psicologaDTO.setAnsiedadSTAI( rcPsicologia.getParametroStai() );
		psicologaDTO.setFechaPsicologa( rcPsicologia.getFecha() );
		psicologaDTO.setNumHijos( Integer.valueOf( String.valueOf( rcPsicologia.getNumHijos() ) ) );
		psicologaDTO.setProfesion( rcPsicologia.getProfesion() );
		psicologaDTO.setAntecedentesPsiquiatricosFamiliares( rcPsicologia.getAntecPsiqFam() == 0 ? false : true );
		psicologaDTO.setAntecedentesPsiquiatricosFamiliaresDiagnostico( rcPsicologia.getAntecPsiqFamDiag() );
		psicologaDTO.setAntecedentesPsiquiatricosFamiliaresGrado( rcPsicologia.getAntecPsiqFamFinal() );
		psicologaDTO.setAntecedentesPsiquiatricosPersonales( rcPsicologia.getAntecPsiqPers() == 0 ? false : true );
		psicologaDTO.setAntecedentesPsiquiatricosPersonalesDiagnostico( rcPsicologia.getAntecPsiqPersDiag() );
		return psicologaDTO;
	}
}

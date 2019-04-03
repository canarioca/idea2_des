package com.sorin.idea.integracion.programadores;

import org.apache.log4j.Logger;

import com.sorin.idea.util.GestorHL7;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;

/**
 * Clase validadora para segmentos ORU_R01 y ADT_A04/A01 requeridos
 * @author Francisco.Romera
 *
 */
public class Validador {

	private static Logger logger = Logger.getLogger(Validador.class);
	
	/**
	 * Valida existencia de nombre, apellidos y fecha de nacimiento
	 * @param adt
	 * @return
	 */
	public static boolean validarDemograficos(ADT_A01 adt){		
		return adt.getPID().getPatientName(0).getGivenName().getValue()!=null 
				&& !adt.getPID().getPatientName(0).getGivenName().getValue().equals("");
	}
	
	/**
	 * Valida existencia de fecha de implante.
	 * @param oru
	 * @return
	 */
	public static boolean validarSistemaImplantado(ORU_R01 oruMsg){
		// Fecha implante 
		String fecha = null;
		try {
			fecha = GestorHL7.obtenerValorOBX("720901", oruMsg.getPATIENT_RESULTAll().get(0).getORDER_OBSERVATIONAll().get(0).getOBSERVATIONAll());
			if(fecha!=null && !fecha.equals(""))
				return true;
		} catch (HL7Exception e) {
			e.printStackTrace();
			return false;
		}		
		return false;
	}
	
}

package com.sorin.idea.util;

import java.util.Date;

/**
 * Clase generadora de identificadores para entidades de IDEA
 * @author Francisco.Romera
 *
 */
public class GestorNomenclatura {

	public static String generaIdentificador(String tipo,int proc,Date fecha,String nhc,Integer tipogen){
		return "IDEA-"+tipo+"_"+proc+"_"+String.valueOf(tipogen)+"_"+(nhc!=null?nhc:"NO_NHC")+"_"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMddHHmmss");
	}
	
}

package com.sorin.idea.util;

import java.util.ArrayList;

/**
 * Clase de lectura de codigos de barra
 * FORMATOS GENERADOR ELECTRODOS: 
 *  - (01)XXXXXXXXXXXXXX(17)XXXXXX(21)....
 *  - (01)XXXXXXXXXXXXXX(240)....
 *  - (01)XXXXXXXXXXXXXX(11)XXXXXX(17)XXXXXX(21)....
 *  - (17)XXXXXX(21).....
 *  FORMATOS CATETERES: 
 *  - (17)XXXXXX(10)..... 
 *  - (01)XXXXXXXXXXXXXX(17)XXXXXX(10)....
 * @author Francisco.Romera
 *
 */
public class GestorCodigoBarras {

	/**
	 * Metodo para obtener modelo/num.serie a partir de un codigo GTIN-GS1-128
	 * @param code
	 * @return arraylist de dos posiciones. 1 = modelo, 2 = num.serie
	 */
	public static ArrayList<String> lectura(String code){
		ArrayList<String> res = new ArrayList<String>();
		//1. Control de digitos iniciales
		if(code.startsWith("01")){
			// control de numero de serie si no es formato GTIN
			if(code.length()>=16)
				res.add(code.substring(2,16));// Se introduce el segmento (01). Se debe contar toda la posición del segmento (01)
			else
				res.add(null);// se asume nulo el modelo ya que debe ser lectura de numero de serie que empieza en 01
			//res.add(code.substring(2,16));// Se introduce el segmento (01)
			if(code.length()>24 && code.substring(16,18).equals("17") && (code.substring(24,26).equals("21") || code.substring(24,26).equals("10")))
				res.add(code.substring(26,code.length()));// numero de serie
			else if(code.length()>34 && code.substring(24,26).equals("17") && code.substring(32,34).equals("21"))
				res.add(code.substring(34,code.length()));// numero de serie
			else
				res.add(null);
		}else if(code.startsWith("17") && code.length()>8 && (code.substring(8,10).equals("21") || code.substring(8,10).equals("10"))){
			res.add(null);
			res.add(code.substring(10,code.length()));
		}else{
			res.add(null);// modelo
			res.add(null);// n.serie
		}
		return res;
	}
	
}

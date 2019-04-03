package com.sorin.idea.util;

import java.util.ArrayList;

public class UtilSituacionClinica {

	/**
	 * Metodo para el calculo del score de CHADSVASC
	 * @param ic
	 * @param fevi
	 * @param hta
	 * @param edad
	 * @param diabetes
	 * @param acv
	 * @param ait
	 * @param enfart
	 * @param sexo
	 * @return
	 */
	public static int calcularScoreCHADSVASC(Integer ic, Integer fevi,Short hta,Integer edad,Short diabetes,
			Short acv, Short ait,Integer enfart,Integer sexo){
		int res = 0;		
		if((ic!=null && ic>0)||(fevi!=null && fevi>0))
			res = res +1;
		if(hta!=null && hta==1)
			res = res +1;
		if(edad!=null && edad>=75)
			res = res +2;
		if(diabetes!=null && diabetes==1)
			res = res +1;
		if(acv!=null && acv==1 || (ait!=null && ait==1))
			res = res +2;
		if(enfart!=null && enfart==1)
			res = res +1;
		if(edad!=null && (edad>=65 && edad <=74))
			res = res +1;
		if(sexo!=null && sexo==2)
			res = res +1;
		return res;
	}
	public static String obtenerRiesgoIctus(int in){
		String res = "0";		
		switch (in) {
	        case 1:  res = "1.3";
	                 break;
	        case 2:  res = "2.2";
	                 break;
	        case 3:  res = "3.2";
	                 break;
	        case 4:  res = "4.0";
	                 break;
	        case 5:  res = "6.7";
	                 break;
	        case 6:  res = "9.8";
	                 break;
	        case 7:  res = "9.6";
	                 break;
	        case 8:  res = "6.7";
	                 break;
	        case 9:  res = "15.2";
	                 break;
	        case -1:  res = "No calculable";
	        		break;
	        default: res = "0";
	                 break;
		}
		return res;
	}
	
	public static String obtenerDosisEscopiaAcumulada(ArrayList<ArrayList<Object>> acumEef, ArrayList<ArrayList<Object>> acumImpl){
		try{
			Double acum = 0.0;
			String aux = "";
			for(int i=0;i<acumEef.size();i++){
				if(acumEef.get(i).get(1)!=null){
					aux = (String) acumEef.get(i).get(1);
					if(UtilDatos.esNumero(aux))
						acum = acum + Double.valueOf(aux);
				}
			}
			for(int i=0;i<acumImpl.size();i++){
				if(acumImpl.get(i).get(1)!=null){
					aux = (String) acumImpl.get(i).get(1);
					if(UtilDatos.esNumero(aux))
						acum = acum + Double.valueOf(aux);
				}
			}
			if(acum==0.0)
				return "";
			return String.valueOf(acum);
		}catch(Exception e1){
			return null;
		}
	}
	
}

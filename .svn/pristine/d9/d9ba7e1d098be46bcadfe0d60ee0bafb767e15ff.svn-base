package com.sorin.idea.util;

import java.util.ArrayList;
import java.util.Date;


public class UtilAgenda {

	public static void crearListaHuecosDiario(ArrayList<Date> huecos, Integer TOTAL, Integer TAM_HUECO, Date ini){
		huecos.add(ini);
		for(int i=0;i<TOTAL;i++){
			huecos.add(UtilFechas.sumaDuracion(huecos.get(i), TAM_HUECO, "min"));
		}
	}
	
	public static void marcarHorasOcupadas(ArrayList<Date> huecos, ArrayList<Date> marcador){
		if(marcador!=null && marcador.size()>0){
			for(int j=0;j<huecos.size();j++){
				for(int i=0;i<marcador.size();i++){
					if((marcador.get(i).getHours() - huecos.get(j).getHours()==0) 
							&& UtilFechas.diferenciaMinutos(marcador.get(i),huecos.get(j))==0){
						huecos.set(j, null);
						break;
					}		
				}
			}
		}
	}
	
	public static ArrayList<Date> obtenerFranjasLibres(ArrayList<Date> huecos, int HUECOS){
		ArrayList<Date> res = new ArrayList<Date>();
		for(int i=0;i<huecos.size();i++){
			if(huecos.get(i)!=null && existeHuecoDisponible(huecos,i,HUECOS)){
				res.add(huecos.get(i));
			}
		}
		return res;
	}
	
	public static boolean existeHuecoDisponible(ArrayList<Date> huecos,int pos, int HUECOS){
		for(int i=0;i<HUECOS;i++){
			if(pos<huecos.size()){
				if(huecos.get(pos)==null)
					return false;
				pos++;
			}else
				return false;
		}	
		return true;	
	}
	
	public static Integer calculaNumeroHuecosEvento(Date start, Date fin, Integer TAM_HUECO){
		try{
	        float minutos = (fin.getTime() - start.getTime())/ 60000; // 1000 * 60 * 60 
	        Float num_huecos = minutos / TAM_HUECO;        
	        // Se aplica redondeo. Si esta por encima del tamaño de hueco se toma un hueco mas.
	        return (int)Math.round(num_huecos);
		}catch(Exception e){
			
		}
		return 0;
	}
	
	public static void insertaHuecos(ArrayList<Date> m1, int numhuecos, Date start, Integer TAM_HUECO){
		for(int i=0;i<numhuecos;i++)
			m1.add(UtilFechas.sumaDuracion(start, TAM_HUECO*i, "min"));		
	}
}

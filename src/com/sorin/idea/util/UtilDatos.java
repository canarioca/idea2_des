package com.sorin.idea.util;

import java.util.ArrayList;
import java.util.Date;

import com.sorin.idea.dto.ArrAcceso;
import com.sorin.idea.dto.Procedimiento;

/**
 * Clase con metodos para comprobaciones basicas
 * @author Francisco.Romera
 *
 */
public class UtilDatos {

	public static boolean esNumero(String cadena){
		try {
			Double.parseDouble(cadena);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}
	/**
	 * Funcion para quitar un mes a Linea Temporal en formato String para JSON
	 * 0 -> Enero
	 * 1 -> Febrero
	 * ...
	 * 11 -> Diciembre
	 * @return
	 */
	public static String formateaJSON(String fecha){
		if(fecha!=null && !fecha.equals("")){
			String mes = fecha.substring(5,7);
			Integer mes_int = Integer.valueOf(mes)-1;
			if(mes_int<10)
				mes = "0"+String.valueOf(mes_int);
			else
				mes = String.valueOf(mes_int);
			return fecha.substring(0,4)+"/"+mes+fecha.substring(7,10);
		}
		return fecha;
	}
	/**
	 * Comprueba si un procedimiento es editable
	 * @param us
	 * @param fechaproc
	 * @return
	 */
	public static boolean procedimientoEditable(ArrAcceso us, Date fechaproc){
		if(us.getPrivs().getEdicion()!=null){
			if(us.getPrivs().getEdicion().equals(1))
				return true;
			else if(us.getPrivs().getEdicion().equals(2)){
				Long dias = UtilFechas.diferenciaDias(fechaproc, new Date());
				if(dias<=us.getPrivs().getTiempoedicion() && dias >=0)
					return true;
				else return false;
			}else
				return false;
		}
		return false;
	}
	
	public static String obtenerNombreUsuario(ArrAcceso acc){
		String res = "";
		if(acc!=null){
			if(acc.getNombre()!=null && !acc.getNombre().equals(""))
				res += acc.getNombre()+" ";
			if(acc.getApellido1()!=null && !acc.getApellido1().equals(""))
				res += acc.getApellido1()+" ";
			if(acc.getApellido2()!=null && !acc.getApellido2().equals(""))
				res += acc.getApellido2()+" ";
		}
		return res;
	}
	
	public static String obtenerUsuarioAuditoria(String descri){
		try{
			if(descri!=null && !descri.equals("")){
				String[] ini = descri.split(",");
				if(ini!=null && ini.length>0){
					String[] aux = ini[0].split("=");
					if(aux!=null && aux.length>0)
						return aux[1];
				}
			}
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Metodo para buscar la fecha del ultimo implante efectivo asociado al dispositivo del que se hace un seguimiento.
	 * Un implante efectivo será aquel que haya implicado un primoimplante, recambio, upgrade o reimplante ya que supone un cambio efectivo
	 * Las recolocaciones y reintervenciones no se consideran de este tipo
	 * La lista de procedimientos se pasa de antiguo a más nuevo - orden ascencente
	 * @return
	 */
	public static Date obtenerFechaImplanteEfectivo(ArrayList<Procedimiento> prs, Date fecha_proc){
		for(int i=prs.size()-1;i>=0;i--){
			if((prs.get(i).getTipoprocedimiento()==956 || prs.get(i).getTipoprocedimiento()==1059 
					|| prs.get(i).getTipoprocedimiento()==1060 || prs.get(i).getTipoprocedimiento()==1090)
					&& UtilFechas.dateDiff(fecha_proc, prs.get(i).getFecha())>=0)
				return prs.get(i).getFecha();
		}
		return null;
	}
}

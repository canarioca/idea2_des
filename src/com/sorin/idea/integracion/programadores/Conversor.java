package com.sorin.idea.integracion.programadores;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;

/**
 * Clase conversora de valores IEEE-11073 MDC - IDEA
 * @author Francisco.Romera
 *
 */
public class Conversor {
	
	private static ArrMaestrasDao mdao;
	
	public Conversor(){
		this.mdao = new ArrMaestrasDaoImpl("Integracion");
	}
	
	public Integer convModoProg(String in){
		try{
			String modo = in.substring(in.indexOf("^")+1,in.length()-1);
			if(modo!=null)
				return mdao.findWhereValorEquals(modo)[0].getCodigo();
			else return null;
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}		
	}
	
	public String convPolaridad(String in){
		try{
			if(in.equals("CWE[BI^Bipolar]"))
				return "1";
			else 
				return "0";
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}
	}
	public String convTipoATP(String in){
		try{
			if(in.equals("CWE[BURST+SCAN^BURST+SCAN]")
					|| in.equals("CWE[BURST^BURST]")
					|| in.equals("CWE[Burst^Burst]")
					|| in.equals("CWE[Burst+Scan^Burst+Scan]"))
				return "2";
			else if(in.equals("CWE[RAMP+SCAN^RAMP+SCAN]")
					|| in.equals("CWE[RAMP^RAMP]")
					|| in.equals("CWE[Ramp+Scan^Ramp+Scan]")
					|| in.equals("CWE[Ramp^Ramp]")) 
				return "1";
			else
				return null;
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}
	}
	
	public String convFabricante(String in){
		try{
			if(in.equals("CWE[SOR^Sorin]")
					|| in.equals("CWE[ELA^ELA Medical]"))
				return "SORIN GROUP";
			else if(in.equals("CWE[MED^Medtronic]")) 
				return "MEDTRONIC";
			else if(in.equals("CWE[BIO^Biotronik]")) 
				return "BIOTRONIK";
			else if(in.equals("CWE[STJ^St.Jude Medical]")) 
				return "SAINT JUDE";
			else if(in.equals("CWE[BSX^Boston Scientific]")) 
				return "BOSTON SCIENTIFIC";
			else if(in.equals("CWE[VIT^Vitatron]")) 
				return "VITATRON";
			else
				return null;
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}
	}

}

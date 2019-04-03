package com.sorin.idea.util;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;

public class UtilConversorTarjetaEuropea {
	
	public static String codigoSintoma(String in, Integer r1, Integer r2){
		if(in!=null && !in.equals("")){
			if(in.equals("NO ESPECIFICADO"))
				return "A1";
			else if(in.equals("ANGOR"))
				return "A2";
			else if(in.equals("ASINTOMATICO"))
				return "D1";
			else if(in.equals("DISNEA"))
				return "D2";
			else if(in.equals("MAREOS"))
				return "B2";
			else if(in.equals("MUERTE SUBITA"))
				return "D5";
			else if(in.equals("PALPITACIONES"))
				return null;
			else if(in.equals("SINCOPE"))
				return "B1";
		}else if(r1!=null && r2!=null)
			return "B3";		
		return "";	
	}
	public static String codigoEtiologia(Integer c, Integer n, boolean t,boolean ip){
		String str = null;
		if(c!=null){
			if(c==913)
				str = "A1";
			/*else if(in==892)
				return "A2";
			else if(in==893)
				return "B1";*/
			else if(c==1049)
				str = "B2";
			else if(c==914 && !(ip))
				str = "C1";
			else if(c==914 && ip)
				str = "C2";
			else if(c==919)
				str = "D1";
			else if(c==1050)
				str = "E1";
			else if(c==1051)
				str = "E2";
			else if(c==1052)
				str = "E3";
			else if(c==1053)
				str = "E4";	
			/*else if(in==905)
				return "G1";*/
			else if(c==916)
				str = "G1A";
			else if(c==915)
				str = "G1B";
			/*else if(in==908)
				return "G2";*/
			else if(c==918)
				str = "G3";
			/*else if(in==910)
				return "G4";*/
			else if(t)
				str = "G7";
			/*else
				return "G8";*/
			else if(n!=null && str == null){// comprobacion de mejroas
				if(n==1)
					str = "F1";
				else if(n==2)
					str = "F2";
				else if(n==3)
					str = "F3";
				else
					str = "A2";
			}
			else
				str = "A2";
		}else if(n!=null && str == null){
			if(n==1)
				str = "F1";
			else if(n==2)
				str = "F2";
			else if(n==3)
				str = "F3";
			else
				str = "A2";
		}else
			str = "A2";
		return str;
	}
	public static String codigoEtiologia_OLD(int in){
		if(in==891)
			return "A1";
		else if(in==892)
			return "A2";
		else if(in==893)
			return "B1";
		else if(in==894)
			return "B2";
		else if(in==895)
			return "C1";
		else if(in==896)
			return "C2";
		else if(in==897)
			return "D1";
		else if(in==898)
			return "E1";
		else if(in==899)
			return "E2";
		else if(in==900)
			return "E3";
		else if(in==901)
			return "E4";
		else if(in==902)
			return "F1";
		else if(in==903)
			return "F2";
		else if(in==904)
			return "F3";
		else if(in==905)
			return "G1";
		else if(in==906)
			return "G1A";
		else if(in==907)
			return "G1B";
		else if(in==908)
			return "G2";
		else if(in==909)
			return "G3";
		else if(in==910)
			return "G4";
		else if(in==911)
			return "G7";
		else
			return "G8";
	}
	public static String codigoECG(int r,int r2, int c,int c2, int q,int q2, int anchura){
		if(r==0 && c==0 && q==0)
			return "A01";
		// TODO A02
		else if(r==342 && q2!=1045)
			return "B01";
		else if(r==342 && q2==1045)
			return "B02";
		else if(c==63 && q!=681 && q!=682 && q!=72){
			if(r==56 && r2==1038)
				return "C08";
			else
				return "C01";		
		}	
		else if(c==64 && c2!=1057 && c2!=1058){
			if(r==56 && r2==1038)
				return "C08";
			else
				return "C02";
		}	
		else if(c==64 && c2==1057)
			return "C03";
		else if(c==64 && c2==1058)
			return "C04";
		else if(c==65 && r!=56 && r2!=1038 && anchura==0)
			return "C05";
		else if(c==65 && r!=56 && r2!=1038 && anchura<100)
			return "C06";
		else if(c==65 && r!=56 && r2!=1038 && anchura>=100)
			return "C07";
		else if((c==65 || c==64 || c==1054 || c==1055) && r==56 && r2==1038)
			return "C08";
		else if(q==67)
			return "D02";
		else if(q==69)
			return "D03";
		else if(c!=63 && q==72)
			return "D04";
		else if(q==70)
			return "D05";
		else if(q==71)
			return "D06";
		else if(c==1056 && q==681)
			return "D07";
		else if(c==63 && q==681)
			return "D09";
		else if(c==1056 && q==682)
			return "D08";
		else if(c==63 && q==682)
			return "D10";
		else if(c==63 && q==72)
			return "D11";
		else if(r==1028 && r2==0)
			return "E01";
		else if(r==1028 && r2==1041)
			return "E02";
		else if(r==1028 && r2==1040)
			return "E03";
		else if(r==1028 && r2==1039)
			return "E04";
		else if(r==1028 && r2==1042)
			return "E05";
		else if(r==56 && r2==1038)
			return "E06";
		else if(r==1028 && r2==1043)
			return "E08";
		else if(r==58 && q!=75)
			return "F01";
		else if(r==58 && q==75 && q2==1046)
			return "F02";
		else if(r==59)
			return "F03";
		else if(r==60 && r2==1032)
			return "G01";
		else if(r==60 && r2==1033)
			return "G02";
		else if(r==60 && r2==1034)
			return "G03";
		else if(r==60 && r2==1035)
			return "G04";
		return null;
	}
	public static String cambiaModoGen(int in){
		ArrMaestrasDao mdao = new ArrMaestrasDaoImpl("consulta");
		try{
			return mdao.findWhereCodigoEquals(in)[0].getValor();
		}catch(Exception e){
			e.fillInStackTrace();
		}
		return null;
		/*if(in==1107)
			return "DDD";
		else if(in==1108)
			return "DDDR";
		else if(in==1109)
			return "VVI";
		else if(in==1110)
			return "VVIR";
		else if(in==1111)
			return "VDD";
		else if(in==1112)
			return "VDDR";
		else if(in==1113)
			return "AAI";
		else if(in==1114)
			return "AAIR";
		else
			return null;*/
	}
	public static Generador buscaGenerador(Generador[] in, int id){
		for(int i=0;i<in.length;i++){
			if(in[i].getIdgenerador()==id){
				return in[i];
			}
		}
		return null;
	}
	public static Electrodos buscaElectrodo(Electrodos[] in, int id){
		for(int i=0;i<in.length;i++){
			if(in[i].getIdelectrodo()==id){
				return in[i];
			}
		}
		return null;
	}
	public static String codigoMotivoGeneradorRetirado(Integer recam){
		if(recam!=null){
			switch(recam){
				case 959: return "B1";
				case 960: return "F1";
				case 1092: return "B2";
				case 1093: return "A2";
				case 1094: return "C3";
				case 1095: return "D1";
				case 961: return "C3";
				case 1096: return "A2";
				case 1097: return "A2";
				case 979: return "A1";
				case 980: return "A2";
				case 994: return "B1";
				case 995: return "B2";
				case 996: return "B3";
				case 997: return "B4";
				case 998: return "B5";
				case 999: return "B6";
				case 1000: return "C1";
				case 1001: return "C2";
				case 1002: return "C3";
				case 1003: return "C4";
				case 1004: return "D1";
				case 1005: return "D2";
				case 1006: return "D3";
				case 1007: return "D4";
				case 1008: return "D5";
				case 1009: return "E2";
				case 1010: return "E3";
				case 1011: return "E4";
				case 1012: return "E5";
				case 1013: return "E6";
				case 1014: return "E7";
				case 1015: return "F1";
				case 1016: return "F2";
				default: return "";
			}
		}
		return null;	
	}
	public static String codigoMotivoElectrodoRetirado(int in){
		switch(in){
			case 981: return "";
			case 982: return "";
			case 1017: return "A1";
			case 1018: return "A2";
			case 1019: return "B1";
			case 1020: return "B2";
			case 1021: return "B3";
			case 1022: return "B4";
			case 1023: return "B5";
			case 963: return "D1";
			case 1098: return "D2";
			case 965: return "D1";
			case 966: return "D1";
			case 1099: return "D1";
			case 1100: return "A2";
			case 1101: return "B4";
			default: return "";
		}
	}
	public String codigoCierreArchivo(String in){
		String res = null;
		return res;
	}
	
}

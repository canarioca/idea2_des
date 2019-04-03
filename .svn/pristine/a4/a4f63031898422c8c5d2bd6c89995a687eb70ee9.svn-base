package com.sorin.idea.util;

import java.util.ArrayList;
import java.util.Date;

import com.sorin.idea.dao.RegistradoreventosDao;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.Registradoreventos;
import com.sorin.idea.jdbc.RegistradoreventosDaoImpl;

public class UtilMapeos {

	public static int mapeoNombreFabricante(String fab){
		if(fab!=null && !fab.equals("")){
			if(fab.equals("SORIN GROUP"))
				return 1;
			else if(fab.equals("BIOTRONIK"))
				return 2;
			else if(fab.equals("BOSTON SCIENTIFIC") || fab.equals("GUIDANT"))
				return 3;
			else if(fab.equals("SAINT JUDE"))
				return 4;
			else if(fab.equals("MEDTRONIC"))
				return 5;
			else if(fab.equals("VITATRON"))
				return 6;
			else 
				return 0;
		}
		return 0;
	}	
	
	public static String mapeoTipoProcedimiento(Integer i){
		switch(i){
			case 0: return "No especificado";
			case 1: return "Otro";
			case 956: return "Primo Implante dispositivo";
			case 957: return "Reintervención";
			case 1059: return "Recambio dispositivo";
			case 1060: return "Upgrade dispositivo";
			case 1085: return "Recolocación Generador";
			case 1086: return "Recolocación Electrodo";
			case 1147: return "Explante dispositivo";
			case 1061: return "Estudio EF";
			case 1068: return "Cardioversión eléctrica";
			case 1066: return "Mesa basculante";
			case 1067: return "Registrador de eventos";
			case 1063: return "Test ATP";
			case 1064: return "Test Epinefrina";
			case 1065: return "Test Flecainida";
			case 983: return "Seguimiento de dispositivo";
			case 1087: return "Seguimiento clínico";
			case 1088: return "Seguimiento Registrador de Eventos";
			case 1089: return "Holter 24h";
			case 1090: return "Reimplante";
			case 1091: return "Registrador de eventos externo";
			case 1092: return "Test de Ortostatismo Activo";
			case 1093: return "Protocolo Síncope";
			case 1094: return "Rehabilitación Cardíaca";
			default: return "No especificado";
		}
	}
	
	public static String mapeoTipoDispositivo(Integer i){
		switch(i){
			case 1: return "MPS";
			case 2: return "DAI";
			case 3: return "CRT-P";
			case 4: return "CRT-D";
			case 5: return "MPS leadless";
			case 6: return "DAI subcutáneo";
			default: return "";
		}
	}
	/**
	 * Generador de identificadores de evento IDEA
	 * Formato: IDEA_TipoProc_TipoGen_NHC_TimeStamp
	 * @param tipoproc
	 * @param nhc
	 * @param tipogen
	 * @return
	 */
	public static String generaIdEvento(Integer tipoproc,String nhc,Integer tipogen){
		return (tipoproc!=null && nhc!=null && tipogen!=null)
				?"IDEA_"+String.valueOf(tipoproc)+"_"+String.valueOf(tipogen)+"_"+(nhc!=null?nhc:"NO_NHC")+"_"+UtilFechas.getFechaStringFormato(new Date(), "yyyyMMddHHmmss")
						:null;
	}
	
	public static Integer obtenerTipoGeneradorEvento(String idevento){	
		try{
			if(idevento!=null && !idevento.equals("")){
				String[] str = idevento.split("_");
				if(str!=null && str.length>3 && str[2]!=null)
					return Integer.parseInt(str[2]);				
			}
		}catch(Exception e){
			return 0;
		}	
		return 0;
	}
	
	public static String obtenerOndaPVDD_EvSeg(ArrayList<ImpImplanteElectrodos> lista){
		if(lista!=null && lista.size()>0){
			for(ImpImplanteElectrodos e:lista){
				if(e.isVdd() && e.getCamara()==948 && e.getEstado()==0)
					return e.getOndarpEv();
			}
		}	
		return null;
	}
	public static String obtenerOndaPVDD_Imp(ArrayList<ImpImplanteElectrodos> lista){
		if(lista!=null && lista.size()>0){
			for(ImpImplanteElectrodos e:lista){
				if(e.isVdd() && e.getCamara()==948 && e.getEstado()==0)
					return e.getOndarpImp();
			}
		}	
		return null;
	}
	public static String obtenerPolDetVDD_EvSeg(ArrayList<ImpImplanteElectrodos> lista){
		if(lista!=null && lista.size()>0){
			for(ImpImplanteElectrodos e:lista){
				if(e.isVdd() && e.getCamara()==948)
					return e.getPoldeteccion();
			}
		}	
		return null;
	}
	/**
	 * Metodo para obtener a partir del código ATN datos completos de medicacion
	 * @return
	 * [0] -> Tipo medicacion
	 * [1] -> Subtipo 1
	 * [2] -> Subtipo 2
	 * [3] -> integer tipo medicacion
	 * [4] -> integer subtipo1 medicacion
	 * [5] -> integer subtipo2 medicacion
	 */
	public static String[] obtenerDatosMedicacion(String codigo){
		String[] res =new String[6];
		if(codigo!=null && !codigo.equals("") && codigo.length()>=5){
			if(codigo.startsWith("C")){
				res[0]="SISTEMA CARDIOVASCULAR";
				res[3]="1";
				if(codigo.substring(1, 3).equals("01")){
					res[1] = "TERAPIA CARDIACA";
					//res[4]="1"; // gestion ATC - DIGITÁLICOS
					if(codigo.substring(3, 4).equals("A")){
						res[2] = "GLUCOSIDOS CARDIOTONICOS";
						res[5]="1";
						res[4]="10"; // gestion SICCS
					}else if(codigo.substring(3, 4).equals("B")){
						res[2] = "ANTIARRITMICOS";
						res[5]="2";
						res[4]="1"; // gestion SICCS - ANTIARRITMICOS
					}else if(codigo.substring(3, 4).equals("C")){
						res[2] = "ESTIMULANTES CARDIACOS";
						res[5]="3";
						res[4]="15"; // gestion SICCS - INTROPICOS ENDOVENOSOS
					}else if(codigo.substring(3, 4).equals("D")){
						res[2] = "VASODILATADORES";
						res[5]="4";
						res[4]="16"; // gestion SICCS - NITRATOS
					}else if(codigo.substring(3, 4).equals("E")){
						res[2] = "OTROS";
						res[5]="5";
					}	
				}else if(codigo.substring(1, 3).equals("02")){
					res[1] = "ANTIHIPERTENSIVOS";
					// res[4]="2"; // GESTION ATC
					if(codigo.substring(3, 4).equals("A")){
						res[2] = "AGENTES ANTIADRENÉRGICOS DE ACCIÓN CENTRAL";
						res[5]="1";
					}else if(codigo.substring(3, 4).equals("C")){
						res[2] = "AGENTES ANTIADRENÉRGICOS DE ACCIÓN PERIFÉRICA";
						res[5]="2";
					}else if(codigo.substring(3, 4).equals("D")){
						res[2] = "MÚSCULO LISO ARTERIOLAR";
						res[5]="3";
					}else if(codigo.substring(3, 4).equals("K")){
						res[2] = "OTROS";
						res[5]="4";
					}else if(codigo.substring(3, 4).equals("E")){
						res[2] = "OTROS";
						res[5]="5";
					}	
				}else if(codigo.substring(1, 3).equals("03")){
					res[1] = "DIURETICOS";
					// res[4]="3"; // GESTION ATC
					res[4]="11"; // gestion SICCS
					if(codigo.substring(3, 4).equals("A")){
						res[2] = "BAJO TECHO: TIAZIDAS";
						res[5]="1";
					}else if(codigo.substring(3, 4).equals("B")){
						res[2] = "BAJO TECHO: SIN TIAZIDAS";
						res[5]="2";
					}else if(codigo.substring(3, 4).equals("C")){
						res[2] = "TECHO ALTO";
						res[5]="3";
					}else if(codigo.substring(3, 4).equals("D")){
						res[2] = "AGENTES AHORRADORES DE POTASIO";
						res[5]="4";
					}else if(codigo.substring(3, 4).equals("E")){
						res[2] = "OTROS";
						res[5]="5";
					}	
				}else if(codigo.substring(1, 3).equals("04")){
					res[1] = "VASODILATADORES PERIFÉRICOS";
					res[4]="4";
				}else if(codigo.substring(1, 3).equals("05")){
					res[1] = "VASOPROTECTORES";
					res[4]="5";
				}else if(codigo.substring(1, 3).equals("07")){
					res[1] = "AGENTES BETA BLOQUEANTES";
					//res[4]="7";// GESTION ATC
					res[4]="7"; // gestion SICCS
				}else if(codigo.substring(1, 3).equals("08")){
					res[1] = "BLOQUEANTES DE CANALES DE CALCIO";
					//res[4]="8";// GESTION ATC
					res[4]="9"; // gestion SICCS - CALCIOANTAGONISTAS
					if(codigo.substring(3, 4).equals("C")){
						res[2] = "CON EFECTOS VASCULARES";
						res[5]="1";
					}else if(codigo.substring(3, 4).equals("D")){
						res[2] = "SIN EFECTOS VASCULARES";
						res[5]="2";
					}
				}else if(codigo.substring(1, 3).equals("09")){
					res[1] = "IECA";
					//res[4]="9";// GESTION ATC
					res[4]="14"; // gestion SICCS - IECA-ARA II
				}else if(codigo.substring(1, 3).equals("10")){
					res[1] = "ANTILIPEMICOS";
					//res[4]="10";// GESTION ATC
					res[4]="5"; // gestion SICCS - ANTILIPEMICOS
				}
			}else if(codigo.startsWith("B")){
				res[0]="SANGRE Y ORGANOS HEMATOPOYETICOS";
				res[3]="2";
				if(codigo.substring(1, 3).equals("01")){
					if(codigo.substring(3, 4).equals("A") && codigo.substring(4, 5).equals("A")){
						res[4]="4";// gestion SICCS - ANTICOAGULANTE ORAL
					}else if(codigo.substring(3, 4).equals("A") && codigo.substring(4, 5).equals("B")){
						if(codigo.substring(5, 7).equals("02") || codigo.substring(5, 7).equals("04") || codigo.substring(5, 7).equals("05"))
							res[4]="3";// gestion SICCS - ANTICOAGULANTE ENDOVENOSO
						else if(codigo.substring(5, 7).equals("01"))
							res[4]="13";// gestion SICCS - HEPARINA BAJO PESO MOLECULAR
						res[4]="6";// gestion SICCS - ANTIPLAQUETARIOS
					}else if(codigo.substring(3, 4).equals("A") && codigo.substring(4, 5).equals("C")){
						res[4]="6";// gestion SICCS - ANTIPLAQUETARIOS
					}
				}
			}else if(codigo.startsWith("A")){
				res[0]="TRACTO ALIMENTARIO Y METABOLISMO";
				res[3]="2";
				res[4]="12";// gestion SICCS - ESTEROIDES
			}else if(codigo.startsWith("R")){
				res[0]="SISTEMA RESPIRATORIO";
				res[3]="2";
				res[4]="8";// gestion SICCS - BRONCODILATADORES
			}else if(codigo.startsWith("J")){
				res[0]="SISTEMA RESPIRATORIO";
				res[3]="2";
				res[4]="2";// gestion SICCS - ANTIBIOTICOS
			}else if(codigo.startsWith("Z")){// OTROS o NO ESPECIFICADOS
				if(codigo.equals("Z000000")){// OTROS
					res[0]="OTROS";
					res[3]="2";
					res[1] = "OTROS";
					res[4]="18";// gestion SICCS - OTROS
				}else if(codigo.equals("ZZAO000"))
					res[4]="4";// gestion SICCS - ANTICOAGULANTE ORAL. NE
				else if(codigo.equals("ZZDG000"))
					res[4]="10";// gestion SICCS - DIGITALICOS. NE
				else if(codigo.equals("ZZAB000"))
					res[4]="2";// gestion SICCS - ANTIBIOTICOS. NE
				else if(codigo.equals("ZZAP000"))
					res[4]="6";// gestion SICCS - ANTIPLAQUETARIOS. NE
				else if(codigo.equals("ZZES000"))
					res[4]="12";// gestion SICCS - ESTEROIDES. NE
				else if(codigo.equals("ZZAR000"))
					res[4]="1";// gestion SICCS - ANTIARRITMICOS. NE
				else if(codigo.equals("ZZBB000"))
					res[4]="7";// gestion SICCS - B-BLOQUEANTES. NE
				else if(codigo.equals("ZZCA000"))
					res[4]="9";// gestion SICCS - CALCIOANTAGONISTAS. NE
				else if(codigo.equals("ZZDI000"))
					res[4]="11";// gestion SICCS - DIURETICOS. NE
				else if(codigo.equals("ZZIE000"))
					res[4]="15";// gestion SICCS - INOTROPICOS ENDOVENOSOS. NE
				else if(codigo.equals("ZZNE000"))
					res[4]="17";// gestion SICCS - NITRITOS ENDOVENOSOS. NE
				else if(codigo.equals("ZZNI000"))
					res[4]="16";// gestion SICCS - NITRATOS. NE
				else if(codigo.equals("ZZAL000"))
					res[4]="5";// gestion SICCS - ANTILIPEMICOS. NE
				else if(codigo.equals("ZZBR000"))
					res[4]="8";// gestion SICCS - BRONCODILATADORES. NE
				else if(codigo.equals("ZZAE000"))
					res[4]="3";// gestion SICCS - ANTICOAGULANTE ENDOVENOSO. NE
				else if(codigo.equals("ZZHP000"))
					res[4]="13";// gestion SICCS - HEPARINA B.P. MOLECULAR. NE
				else if(codigo.equals("ZZIA000"))
					res[4]="14";// gestion SICCS - IECA-ARA II. NE
			}	
		}
		return res;
	}
	
	public static Integer obtenerTipoMedicacion(String tipo){
		if(tipo!=null){
			if(tipo.equals("TERAPIA CARDIACA"))
				return 1;
			else if(tipo.equals("ANTIHIPERTENSIVOS"))
				return 2;
			else if(tipo.equals("DIURÉTICOS"))
				return 3;
			else if(tipo.equals("VASODILATADORES PERIFÉRICOS"))
				return 4;
			else if(tipo.equals("VASOPROTECTORES"))
				return 5;
			else if(tipo.equals("AGENTES BETA BLOQUEANTES"))
				return 7;
			else if(tipo.equals("BLOQUEANTES DE CANALES DE CALCIO"))
				return 8;
			else if(tipo.equals("IECA"))
				return 9;
			else if(tipo.equals("ANTILIPEMICOS"))
				return 10;
			else
				return 0;
		}
		return 0;
	}
	public static String getSistema(int in){
		if(in==1 || in==6)
			return "ORCHESTRA PLUS";
		else if(in==2 || in==7)
			return "RENAMIC";
		else if(in==3 || in==8)
			return "ZOOM LATITUDE";
		else if(in==4 || in==9)
			return "MERLIN 3330";
		else if(in==5 || in==10)
			return "2090";
		else if(in==11 || in==13)
			return "HOME MONITORING SERVICE";
		else if(in==12)
			return "SMART VIEW";
		else if(in==14)
			return "LATITUDE NXT";
		else if(in==15)
			return "MERLIN .NET";
		else if(in==16)
			return "CARELINK";
		return "";
	}
	/**
	 * lISTA DE SISTEMAS
	 * 1 = ORCHESTRA PLUS
	 * 2 = RENAMIC
	 * 3 = ZOOM LATITUDE
	 * 4 = MERLIN 3330
	 * 5 = 2090
	 * 6 = SMART VIEW
	 * 7 = HOME MONITORING SERVICE
	 * 8 = LATITUDE NXT
	 * 9 = MERLIN .NET
	 * 10= CARLELINK
	 * @param mnf
	 * @param remoto
	 * @return
	 */
	public static Integer getSistema(String mnf,boolean remoto){
		if(remoto){
			if(mnf.equals("CWE[SOR^Sorin]"))
				return 6;
			else if(mnf.equals("CWE[BIO^Biotronik]"))
				return 7;
			else if(mnf.equals("CWE[BSX^Boston Scientific]") || mnf.equals("CWE[GDT^Guidant]"))
				return 8;
			else if(mnf.equals("CWE[STJ^St.Jude Medical]"))
				return 9;
			else if(mnf.equals("CWE[MED^Medtronic]"))
				return 10;
			else
				return 0;
		}else{
			if(mnf.equals("CWE[SOR^Sorin]"))
				return 1;
			else if(mnf.equals("CWE[BIO^Biotronik]"))
				return 2;
			else if(mnf.equals("CWE[BSX^Boston Scientific]") || mnf.equals("CWE[GDT^Guidant]"))
				return 3;
			else if(mnf.equals("CWE[STJ^St.Jude Medical]"))
				return 4;
			else if(mnf.equals("CWE[MED^Medtronic]"))
				return 5;
			else
				return 0;
		}
	}
	
	public static boolean esModoValidoMPS(String modo_in, String test){
		if(modo_in!=null && !modo_in.equals("") && test!=null && !test.equals("")){
			if(modo_in.toUpperCase().startsWith("SSI")){
				if(modo_in.toUpperCase().endsWith("R"))
					return test.toUpperCase().equals("000") || test.toUpperCase().equals("A00")
							|| test.toUpperCase().equals("AAT") || test.toUpperCase().equals("AAI")
							|| test.toUpperCase().equals("V00") || test.toUpperCase().equals("VVI")
							|| test.toUpperCase().equals("VVT") || test.toUpperCase().equals("AAIR")
							|| test.toUpperCase().equals("VVIR");	
				return test.toUpperCase().equals("000") || test.toUpperCase().equals("A00")
						|| test.toUpperCase().equals("AAT") || test.toUpperCase().equals("AAI")
						|| test.toUpperCase().equals("V00") || test.toUpperCase().equals("VVI")
						|| test.toUpperCase().equals("VVT");
			}else if(modo_in.toUpperCase().startsWith("AAI")){
				if(modo_in.toUpperCase().endsWith("R"))
					return test.toUpperCase().equals("000") || test.toUpperCase().equals("A00")
							|| test.toUpperCase().equals("AAT") || test.toUpperCase().equals("AAI")
							|| test.toUpperCase().equals("AAIR");	
				return test.toUpperCase().equals("000") || test.toUpperCase().equals("A00")
						|| test.toUpperCase().equals("AAT") || test.toUpperCase().equals("AAI");
			}else if(modo_in.toUpperCase().startsWith("VVI")){
				if(modo_in.toUpperCase().endsWith("R"))
					return test.toUpperCase().equals("000") || test.toUpperCase().equals("V00")
							|| test.toUpperCase().equals("VVT") || test.toUpperCase().equals("VVI")
							|| test.toUpperCase().equals("VVIR");	
				return test.toUpperCase().equals("000") || test.toUpperCase().equals("V00")
						|| test.toUpperCase().equals("VVT") || test.toUpperCase().equals("VVI");
			}else if(modo_in.toUpperCase().startsWith("VDD")){
				if(modo_in.toUpperCase().endsWith("R"))
					return test.toUpperCase().equals("000") || test.toUpperCase().equals("V00")
							|| test.toUpperCase().equals("VVT") || test.toUpperCase().equals("VVI")
							|| test.toUpperCase().equals("VDD") || test.toUpperCase().equals("VVIR")
							|| test.toUpperCase().equals("VDI") || test.toUpperCase().equals("VDDR");	
				return test.toUpperCase().equals("000") || test.toUpperCase().equals("V00")
						|| test.toUpperCase().equals("VVT") || test.toUpperCase().equals("VVI")
						|| test.toUpperCase().equals("VDI") || test.toUpperCase().equals("VDD");
			}else if(modo_in.toUpperCase().startsWith("DDD")){
				if(modo_in.toUpperCase().endsWith("R"))
					return test.toUpperCase().equals("000") || test.toUpperCase().equals("A00")
							|| test.toUpperCase().equals("AAT") || test.toUpperCase().equals("AAI")
							|| test.toUpperCase().equals("V00") || test.toUpperCase().equals("VVI")
							|| test.toUpperCase().equals("VVIR") || test.toUpperCase().equals("VVT")
							|| test.toUpperCase().equals("VDD") || test.toUpperCase().equals("D00")
							|| test.toUpperCase().equals("DDI") || test.toUpperCase().equals("DDD")
							|| test.toUpperCase().equals("AAIR") || test.toUpperCase().equals("VDDR")
							|| test.toUpperCase().equals("DDIR") || test.toUpperCase().equals("DDDR")
							|| test.toUpperCase().equals("DDT") || test.toUpperCase().equals("VDI")
							|| test.toUpperCase().equals("AAI---DDD") || test.toUpperCase().equals("AAIR---DDDR");	
				else if(modo_in.toUpperCase().endsWith("V"))
					return test.toUpperCase().equals("000") || test.toUpperCase().equals("A00")
							|| test.toUpperCase().equals("AAT") || test.toUpperCase().equals("AAI")
							|| test.toUpperCase().equals("V00") || test.toUpperCase().equals("VVI")
							|| test.toUpperCase().equals("VVIR") || test.toUpperCase().equals("VVT")
							|| test.toUpperCase().equals("VDD") || test.toUpperCase().equals("D00")
							|| test.toUpperCase().equals("DDI") || test.toUpperCase().equals("DDD")
							|| test.toUpperCase().equals("AAIR") || test.toUpperCase().equals("VDDR")
							|| test.toUpperCase().equals("DDIR") || test.toUpperCase().equals("DDDR")
							|| test.toUpperCase().equals("AAI---DDD") || test.toUpperCase().equals("AAIR---DDDR")
							|| test.toUpperCase().equals("DDT") || test.toUpperCase().equals("VDI") 
							|| test.toUpperCase().equals("DDDRV");
				return test.toUpperCase().equals("000") || test.toUpperCase().equals("A00")
						|| test.toUpperCase().equals("AAT") || test.toUpperCase().equals("AAI")
						|| test.toUpperCase().equals("V00") || test.toUpperCase().equals("VVI")
						|| test.toUpperCase().equals("VVT") || test.toUpperCase().equals("VDI")
						|| test.toUpperCase().equals("VDD") || test.toUpperCase().equals("D00")
						|| test.toUpperCase().equals("DDI") || test.toUpperCase().equals("DDD")
						|| test.toUpperCase().equals("DDT") || test.toUpperCase().equals("AAI---DDD");
			}
		}
		return false;
	}
	
	public static boolean esModoValidoDAI(String modo_in, String test, int tipo){
		if(modo_in!=null && !modo_in.equals("") && test!=null && !test.equals("")){
			if(tipo==4)
				return test.toUpperCase().equals("000") || test.toUpperCase().equals("V00")
						|| test.toUpperCase().equals("VVI") || test.toUpperCase().equals("VVIR")
						|| test.toUpperCase().equals("AAI---DDD") || test.toUpperCase().equals("AAIR---DDDR")
						|| test.toUpperCase().equals("D00") || test.toUpperCase().equals("DDI")
						|| test.toUpperCase().equals("DDIR") || test.toUpperCase().equals("DDD")
						|| test.toUpperCase().equals("DDDR") || test.toUpperCase().equals("DDDRV");
			else{
				if(modo_in.toUpperCase().contains("VR") || modo_in.toUpperCase().contains("VVIR"))
					return test.toUpperCase().equals("000") || test.toUpperCase().equals("V00")
							|| test.toUpperCase().equals("VVI") || test.toUpperCase().equals("VVIR");
				else if(modo_in.toUpperCase().contains("DR"))
					return test.toUpperCase().equals("000") || test.toUpperCase().equals("V00")
							|| test.toUpperCase().equals("VVI") || test.toUpperCase().equals("VVIR")
							|| test.toUpperCase().equals("D00") || test.toUpperCase().equals("DDI")
							|| test.toUpperCase().equals("DDIR") || test.toUpperCase().equals("DDD")
							|| test.toUpperCase().equals("AAI---DDD") || test.toUpperCase().equals("AAIR---DDDR")
							|| test.toUpperCase().equals("DDDR");
			}
		}
		return false;
	}
	
	public static String getFabricanteRegistrador(Integer idreg){
		try{
			RegistradoreventosDao regdao = new RegistradoreventosDaoImpl("");
			Registradoreventos reg = regdao.findByPrimaryKey(idreg);
			return reg.getFabricante();
		}catch(Exception e1){
			e1.printStackTrace();
			return null;
		}
	}
}

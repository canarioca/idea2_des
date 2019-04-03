package com.sorin.idea.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.segment.OBX;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageIterator;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageStringIterator;

public class GestorHL7 {

	/**
	 * Metodo para obtener objeto ORU a partir de un oru en formato String
	 * @param oru: mensaje en formato string
	 * @return
	 */
	public static ORU_R01 obtenerORU(String oru){
		//Declaramos el InputStream
		InputStream inputStream=null;		 
		//Creamos un StringBuffer pasando como parametro el String a convertir.
		StringBuffer StringBuffer1 = new StringBuffer(oru);
		try {
			inputStream = new ByteArrayInputStream(StringBuffer1.toString().getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		Hl7InputStreamMessageStringIterator iter2 = new Hl7InputStreamMessageStringIterator(inputStream); 
		while (iter2.hasNext()) {
		 	oru = iter2.next();
		}	
		HapiContext context = new DefaultHapiContext();
		Parser p = context.getGenericParser();
		Message hapiMsg=null;
		try {
		  // The parse method performs the actual parsing
		    hapiMsg = p.parse(oru);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return (ORU_R01)hapiMsg;		 
	}
	
	/**
	 * Metodo para obtener el valor de la observacion (OBX 5) a partir de su codigo de referencia (OBX 3.1)
	 * @param code
	 * @param lista
	 * @return
	 */
	public static String obtenerValorOBX(String code, List<ORU_R01_OBSERVATION> lista){
		try{
			for(ORU_R01_OBSERVATION r:lista){
				if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals(code))
					return r.getOBX().getObx5_ObservationValue()[0].getData().toString();
			}
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}
		return null;
	}
	public static String obtenerValorOBX_ED(String code, List<ORU_R01_OBSERVATION> lista){
		try{
			for(ORU_R01_OBSERVATION r:lista){
				if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals(code))
					return r.getOBX().getObx5_ObservationValue()[0].getData().toString();
			}
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}
		return null;
	}
	/**
	 * Metodo para obtener un objeto OBX a partir de su código de referencia (OBX 3.1)
	 * @param code
	 * @param lista
	 * @return
	 */
	public static OBX obtenerOBX(String code, String valor, List<ORU_R01_OBSERVATION> lista){
		try{
			for(ORU_R01_OBSERVATION r:lista){
				if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals(code)
						&& r.getOBX().getObx5_ObservationValue(0).getData().toString().equals(valor)){
					//System.out.println(" TEST EPID: "+r.getOBX().getObx5_ObservationValue(0).getData().toString());
					return r.getOBX();
				}
					
			}
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}
		return null;
	}
	/**
	 * Metodo para obtener el valor de la observacion (OBX 5) a partir de su código de referencia (OBX 3.1) y el sub-Id(OBX 4)
	 * @param code
	 * @param subcode
	 * @param lista
	 * @return
	 */
	public static String obtenerValorOBX(String code, String subcode, List<ORU_R01_OBSERVATION> lista){
		try{
			for(ORU_R01_OBSERVATION r:lista){
				if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals(code)
						&& r.getOBX().getObservationSubID().getValue().equals(subcode)){
					//System.out.println(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
					return r.getOBX().getObx5_ObservationValue()[0].getData().toString();
				}			
			}
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}
		return "";
	}
	/**
	 * Metodo para obtener lista de valores de la observacion (OBX 5) a partir de su código de referencia (OBX 3.1) y el sub-Id(OBX 4)
	 * @param code
	 * @param subcode
	 * @param lista
	 * @return
	 */
	public static ArrayList<String> obtenerValoresOBX(String code, List<ORU_R01_OBSERVATION> lista){
		ArrayList<String> res = new ArrayList<String>();
		try{
			for(ORU_R01_OBSERVATION r:lista){
				if(r.getOBX().getObx3_ObservationIdentifier().getCe1_Identifier().getValue().equals(code))
					res.add(r.getOBX().getObx5_ObservationValue()[0].getData().toString());
			}
			return res;
		}catch(Exception e){
			e.fillInStackTrace();
			return null;
		}
	}
	
	
	public static String obtenerCodeEpiNoSost(String fabricante){
		if(fabricante!=null && !fabricante.equals("")){
			if (fabricante.equals("CWE[SOR^Sorin]"))
				return "CWE[SOR-Epis_NST^Non Sustained]";
			else if (fabricante.equals("CWE[BIO^Biotronik]"))
				return "CWE[BIO-Epis_NSVT^NSVT]";
			else if (fabricante.equals("CWE[STJ^St.Jude Medical]"))
				return "CWE[STJ-Epis_Non-sustained^Non-sustained VT]";
			else if (fabricante.equals("CWE[BSX^Boston Scientific]"))
				return "CWE[BSX-Epis_NSVT^NSVT]";
			else if (fabricante.equals("CWE[MED^Medtronic]") )
				return "CWE[MDT-Epis_NS_VT^NSVT]";
			else
				return null;
		}else
			return null;
	}
	public static int obtenerCamaraElectrodo(String camara){
		if(camara!=null && !camara.equals("")){
			if (camara.equals("CWE[LA^Left Atrium]"))
				return 0;
			else if (camara.equals("CWE[LV^Left Ventricle]"))
				return 950;
			else if (camara.equals("CWE[RA^Right Atrium]"))
				return 948;
			else if (camara.equals("CWE[RV^Right Ventricle]"))
				return 949;
			else if (camara.equals("CWE[OTHER^Other]") || camara.equals("CWE[Unknown^Unknown]") )
				return 0;
			else
				return 0;
		}else
			return 0;
	}
	public static int obtenerStatusElectrodo(String stat){
		if(stat!=null && !stat.equals("")){
			if (stat.equals("CWE[Connected^Connected]"))
				return 0;
			else if (stat.equals("CWE[Abandoned^Abandoned]"))
				return 1;			
			else
				return 0;
		}else
			return 0;
	}
	public static String obtenerFabricante(String fabricante){
		if(fabricante!=null && !fabricante.equals("")){
			if (fabricante.equals("CWE[SOR^Sorin]"))
				return "SORIN GROUP";
			else if (fabricante.equals("CWE[BIO^Biotronik]"))
				return "BIOTRONIK";
			else if (fabricante.equals("CWE[STJ^St.Jude Medical]"))
				return "SAINT JUDE MEDICAL";
			else if (fabricante.equals("CWE[BSX^Boston Scientific]"))
				return "BOSTON SCIENTIFIC";
			else if (fabricante.equals("CWE[MED^Medtronic]") )
				return "MEDTRONIC";
			else if (fabricante.equals("CWE[GDT^Guidant]") )
				return "GUIDANT";
			else
				return null;
		}else
			return null;
	}
	
	public static Integer obtenerSexo(String in){
		if(in!=null && !in.equals("")){
			if(in.equals("M"))
				return 1;
			else if(in.equals("F"))
				return 2;
			else
				return 0;
		}
		return 0;
	}
}

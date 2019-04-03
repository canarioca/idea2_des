package com.sorin.idea.util;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class UtilCodifi {
	//mmb
	
	public static String formatoFloat(Float valor){
		DecimalFormat df= new DecimalFormat("#0.00");
		return (valor == null) ? "":df.format(valor);
		
	}
	
	public static Integer parserInteger(Integer i){
		try {
			return (i==null)?0:i;
		}catch(Exception ex){
			return 0;
		}
	}
	
	public static Float parserFloat(Float i){
		try {
			return (i==null)?0:i;
		}catch(Exception ex){
			return new Float(0);
		}
	}
	
	
	public static Integer parserInteger(String i){
		try {
			return (i == null)? 0:new Integer(i);
		}catch(Exception ex){
			return 0;
		}
	}
	
	public static String getCodWin(String source) {
		if (source != null) {
			String cadena = null;
			try {
				cadena = source.trim();
				byte[] c = cadena.getBytes();
				return new String(c, "Cp850");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return source;
			}
		} else
			return source;
	}

	public static String getCodMB(String source) {
		if (source != null) {
			String cadena = null;
			try {
				cadena = source.trim();
				byte[] c = cadena.getBytes();
				return new String(c, "Cp1252");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				return source;
			}
		} else
			return source;
	}

	public static String getStringSimple(String source) {
		if (source != null) {
			String cadena = null;
			try {
				cadena = source.trim().replace("é", "e").replace("á", "a");
				return cadena;
			} catch (Exception e) {
				return source;
			}

		} else
			return source;
	}

	public static boolean isNumeric(String cadena) {
		try {
			Integer.parseInt(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	public static boolean isNumericLong(String cadena) {
		try {
			Long.parseLong(cadena);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Función que comprueba que una cadena que contenga vocales acentuadas las
	 * cambie por su vocal correspondiente sin tilde para su correcta función a
	 * la hora de buscar en bdu por url
	 * 
	 * @param palabra
	 * @return
	 */
	public static String compruebaTildes(String cadena) {

		cadena = cadena.replaceAll("Á", "A");
		cadena = cadena.replaceAll("É", "E");
		cadena = cadena.replaceAll("Í", "I");
		cadena = cadena.replaceAll("Ó", "O");
		cadena = cadena.replaceAll("Ú", "U");
		cadena = cadena.replaceAll("a", "a");
		cadena = cadena.replaceAll("e", "e");
		cadena = cadena.replaceAll("i", "i");
		cadena = cadena.replaceAll("o", "o");
		cadena = cadena.replaceAll("u", "u");

		return cadena;
	}

	/**
	 * Función que cambia los espacios y los carcácteres ñ por %20 y %F1
	 * respectivamente para su correcta función a la hora de buscar por url en
	 * bdu
	 * 
	 * @param cadena
	 * @return
	 */
	public static String compruebaSpEnye(String cadena) {
		cadena = cadena.replaceAll(" ", "%20");
		cadena = cadena.replaceAll("Ñ", "%F1");

		return cadena;
	}

	// ------------------------------------------------------------------------
	/**
	 * Remove occurences of html, defined as any text between the characters
	 * "&lt;" and "&gt;". Replace any HTML tags with a space.
	 */
	public static String removeHTML(String str) {
		return removeHTML(str, true);
	}

	/**
	 * Remove occurences of html, defined as any text between the characters
	 * "&lt;" and "&gt;". Optionally replace HTML tags with a space.
	 * 
	 * @param str
	 * @param addSpace
	 * @return
	 */
	public static String removeHTML(String str, boolean addSpace) {
		if (str == null)
			return "";
		str = str.replaceAll("&nbsp;", " ").replaceAll("&aacute;", "á")
				.replaceAll("&eacute;", "é").replaceAll("&iacute;", "í")
				.replaceAll("&oacute;", "ó").replaceAll("&uacute;", "ú")
				.replaceAll("&Aacute;", "Á").replaceAll("&Eacute;", "É")
				.replaceAll("&Iacute;", "Í").replaceAll("&Oacute;", "Ó")
				.replaceAll("&Uacute;", "Ú");

		StringBuffer ret = new StringBuffer(str.length());
		int start = 0;
		int beginTag = str.indexOf("<");
		int endTag = 0;
		if (beginTag == -1)
			return str;

		while (beginTag >= start) {
			if (beginTag > 0) {
				ret.append(str.substring(start, beginTag));

				// replace each tag with a space (looks better)
				if (addSpace)
					ret.append(" ");
			}
			endTag = str.indexOf(">", beginTag);

			// if endTag found move "cursor" forward
			if (endTag > -1) {
				start = endTag + 1;
				beginTag = str.indexOf("<", start);
			}
			// if no endTag found, get rest of str and break
			else {
				ret.append(str.substring(beginTag));
				break;
			}
		}
		// append everything after the last endTag
		if (endTag > -1 && endTag + 1 < str.length()) {
			ret.append(str.substring(endTag + 1));
		}
		return ret.toString().trim();
	}

	public static String changeHTMLFormat(String cad) {
		cad = cad.replaceAll("<em>", "<i>");
		cad = cad.replaceAll("</em>", "</i>");
		cad = cad.replaceAll("<strong>", "<b>");
		cad = cad.replaceAll("</strong>", "</b>");

		return cad;
	}

	public static ArrayList<ArrayList<Object>> Results2Array(ResultSet rs)
			throws SQLException {
		ResultSetMetaData metaData = rs.getMetaData();
		int columns = metaData.getColumnCount();
		ArrayList<ArrayList<Object>> al = new ArrayList<ArrayList<Object>>();
		while (rs.next()) {
			ArrayList<Object> record = new ArrayList<Object>();
			for (int i = 1; i <= columns; i++) {
				Object value = rs.getObject(i);
				record.add(value);
			}
			al.add(record);
		}
		return al;
	}
}

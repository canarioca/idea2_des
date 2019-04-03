package com.sorin.idea.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;

public class GestorClaves {

	//algoritmos
	public static String MD2 = "MD2";
	public static String MD5 = "MD5";
	public static String SHA1 = "SHA-1";
	public static String SHA256 = "SHA-256";
	public static String SHA384 = "SHA-384";
	public static String SHA512 = "SHA-512";
	// PATRONES DE VALIDACION
	public static String PATRON_ASCII = "\\p{ASCII}+";
	public static String PATRON_ALFANUM = "[\\w-]+";
	public static String PATRON_NUM = "\\d*";
	/***
	 * Convierte un arreglo de bytes a String usando valores hexadecimales
	 * @param digest arreglo de bytes a convertir
	 * @return String creado a partir de <code>digest</code>
	*/
	
		private static String toHexadecimal(byte[] digest){
		 String hash = "";
		 for(byte aux : digest) {	
	            int b = aux & 0xff;	
	            if (Integer.toHexString(b).length() == 1) hash += "0";	
	            hash += Integer.toHexString(b);	
	        }	
	        return hash;
	    }
		
		    /***
		     * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje.
		     * @param message texto a encriptar
		     * @param algorithm algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1, SHA-256, SHA-384, SHA-512
		     * @return mensaje encriptado
		     */
		
		    public static String getStringMessageDigest(String message, String algorithm){	
		        byte[] digest = null;	
		        byte[] buffer = message.getBytes();	
		        try {	
		            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);	
		            messageDigest.reset();
		            messageDigest.update(buffer);	
		            digest = messageDigest.digest();	
		        } catch (NoSuchAlgorithmException ex) {
		            System.out.println("Error creando Digest");	
		        }	
		       return toHexadecimal(digest);
		    }
		   
		    public static String encodeToB64(String in){
		    	byte[] encoded = Base64.encodeBase64(in.getBytes());     		        
		        return new String(encoded);
		    }
		    public static String decodeFromB64(String in){
		    	byte[] decoded = Base64.decodeBase64(in.getBytes());      
		        return new String(decoded);
		    }

		   public static int validadorClave(String pw, int l_min){
			Pattern pat = Pattern.compile(PATRON_ASCII);
			Matcher mat = pat.matcher(pw);
				if (mat.matches()) 
					if(pw.length()<l_min)
						return -2;
					else
						return 0;	
				else 
				     return -1;
		   }
		    
	
}

package com.sorin.idea.util;

public class UtilDni {
    
    public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";
    
    /**
     * Devuelve un NIF completo a partir de un DNI. Es decir, a�ade la letra del NIF
     * @param dni dni al que se quiere a�adir la letra del NIF
     * @return NIF completo.
     */
    public static String nifFromDni(int dni) {
      return String.valueOf(dni) + NIF_STRING_ASOCIATION.charAt(dni % 23);
    }
    
    /**
     * Devuelve la letra de un n�mero DNI.
     */
    public static char letraDni (int dni){
        return NIF_STRING_ASOCIATION.charAt(dni % 23);
    }

}

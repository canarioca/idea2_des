package com.sorin.idea.iu;

import java.util.Locale;

import javax.faces.event.ActionEvent;

public class SelectorIdioma {

	private static final long serialVersionUID = 84157941310458440L; 
	private static String localeCode;
	private static Locale locale;
     
    static{
    	localeCode = "es";
    	locale = new Locale("ES"); 
    }
    
    public String getLocaleCode() {
    	 return localeCode;
    }
     
    public void setLocaleCode(String localeCode) {
    	this.localeCode = localeCode;
    }
    
    public void seleccionaEs(ActionEvent e){
    	localeCode = "es";
    	locale = new Locale("ES");
    }
    
    public void seleccionaEn(ActionEvent e){
    	localeCode = "en";
    	locale = new Locale("EN");
    }

    public void seleccionaCat(ActionEvent e){
    	localeCode = "ca_ES";
    	locale = new Locale("ca_ES");
    }
    
    public void seleccionaEus(ActionEvent e){
    	localeCode = "be_BY";
    	locale = new Locale("be_BY");
    }
    
    public void seleccionaPt(ActionEvent e){
    	localeCode = "pt";
    	locale = new Locale("pt");
    }
    
	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}
    
}

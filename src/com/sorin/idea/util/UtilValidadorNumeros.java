package com.sorin.idea.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

public class UtilValidadorNumeros implements Validator {

	@Override
	public void validate( FacesContext arg0, UIComponent arg1, Object arg2 ) {
		
		if ( arg2 != null && !arg2.equals("") && !(arg2.toString().contains("."))) {
            throw new ValidatorException(new FacesMessage(" El campo debe tener '.' "));
        }
		
		try {	
			if ( !( Double.valueOf(arg2.toString()) instanceof Double)) {
	            throw new ValidatorException(new FacesMessage("Debe ser un numérico"));
	        }
		}
		catch(Exception e) {
			throw new ValidatorException(new FacesMessage("Debe ser un numérico"));
		}
		
	}
}

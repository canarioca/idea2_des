package com.sorin.idea.dto;

import java.util.ArrayList;

/**
 * Clase contenedora de elementos de medicacion para plan general o procedimiento
 * @author Francisco.Romera
 *
 */
public class MedicacionDto {

	private MedGenerico medgenerico;
	private MedComercial medscom;
	
	public MedicacionDto(){
		this.medgenerico = new MedGenerico();
		this.medscom = new MedComercial();
	}

	public MedGenerico getMedgenerico() {
		return medgenerico;
	}

	public void setMedgenerico(MedGenerico medgenerico) {
		this.medgenerico = medgenerico;
	}

	public MedComercial getMedscom() {
		return medscom;
	}

	public void setMedscom(MedComercial medscom) {
		this.medscom = medscom;
	}

	
	
}

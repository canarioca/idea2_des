package com.sorin.idea.iu;

import javax.faces.component.html.HtmlForm;

import hvn.cm.modelo.Mensaje;

public class ControlInicio extends BaseIU {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4938028227000395524L;

	public ControlInicio() {
		this.formulario = new HtmlForm();
	}

	public void inicia(String usuario) {
		nuevoMensaje(this.formulario.getId(), Mensaje.SEVERIDAD_INFO,
				"Bienvenido/a " + usuario, "Bienvenido/a " + usuario);
	}

}

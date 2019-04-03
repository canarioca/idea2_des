package com.sorin.idea.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.faces.event.ActionEvent;

import com.sorin.idea.iu.BaseIU;
import com.sorin.idea.iu.LoginForm;

import hvn.apl.jayuda.dao.AyuUsuariosDao;
import hvn.apl.jayuda.dto.AyuInfoDto;
import hvn.apl.jayuda.dto.AyuRolesDto;
import hvn.cm.iu.IUException;
import hvn.cm.modelo.BaseException;
import hvn.mod.contexto.ctxweb.ContextoWeb;

public class IdentificaId extends BaseIU {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String aplicacion;
	private String formularioId;
	private String controlId;
	private String user;
	private String rol;
	private String tipotecla;

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getFormularioId() {
		return formularioId;
	}

	public void setFormularioId(String formularioId) {
		this.formularioId = formularioId;
	}

	public String getControlId() {

		return controlId;
	}

	public void setControlId(String control) {
		controlId = control;
	}

	public void control(ActionEvent ac) throws IUException, BaseException {

		setAplicacion(((ContextoWeb) getContexto().getContextoBase())
				.getRequest().getContextPath().substring(1));
		AyuInfoDto ayuda = new AyuInfoDto();
		ayuda.setIdentificadorAplicacion(getAplicacion());
		ayuda.setIdentificadorControl(getControlId());
		ayuda.setIdentificadorFormulario(getFormularioId());

	}

	public String getVentana() {
		try {

			Dimension aa = Toolkit.getDefaultToolkit().getScreenSize();
			Integer iAncho = aa.width / 3;
			Integer iAlto = aa.height;
			Integer iPos = (aa.width - iAncho) - 5;
			String retorno = "";
			String opcionesTamano = "";
			LoginForm identUsuario = (LoginForm) getBean("loginForm");
			AyuRolesDto filtro = new AyuRolesDto();
			AyuUsuariosDao usuario = new AyuUsuariosDao();

			this.user = identUsuario.getSesionUsuario().getUsuario();
			filtro.setUsuario(this.getUser());
			filtro.setAplicacion(this.aplicacion);
			opcionesTamano = "width=" + iAncho + ", height=" + iAlto
					+ ", top=0, left=" + iPos;
			retorno = "window.open('http://adcp1:8081/jayuda/faces/iniParam.jsp?Parametros=<Parametros><login>"
					+ this.getUser()
					+ "</login><aplicacion>"
					+ this.getAplicacion()
					+ "</aplicacion><controlId>"
					+ this.getControlId()
					+ "</controlId><formularioId>"
					+ this.getFormularioId()
					+ "</formularioId><tecla>"
					+ tipotecla
					+ "</tecla></Parametros>','ventana','"
					+ opcionesTamano
					+ ", dependent=no, menubar=no, toolbar=no, resizable=no, scrollbars=no');";
			if (this.tipotecla.equals("F8"))				
				return retorno;
			else
				if (usuario.consultarRol(filtro) != null)
					return retorno;
				else
					return "";
			
		} catch (Exception e) {
			return "";
		}
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getTipotecla() {
		return tipotecla;
	}

	public void setTipotecla(String tipotecla) {
		this.tipotecla = tipotecla;
	}
}

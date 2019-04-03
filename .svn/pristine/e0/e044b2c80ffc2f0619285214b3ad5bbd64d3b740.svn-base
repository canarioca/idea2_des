package com.sorin.idea.iu.gestor;

import java.util.Date;

import com.sorin.idea.iu.ControlAplicacion;

import hvn.apl.jProyecto2010.modelo.servicios.ServicioUsuario;
import hvn.apl.jProyecto2010.modelo.servicios.dto.SesionUsuarioDto;
import hvn.apl.jProyecto2010.modelo.servicios.exception.ServicioException;

import hvn.cm.iu.form.BaseForm;
import hvn.mod.contexto.ctxfaces.ContextoFaces;
import hvn.mod.contexto.ctxweb.ContextoWeb;

public class GestorAcceso extends BaseForm {
    private static final long serialVersionUID = 1L;

    ServicioUsuario           servicioUsuario  = null;

    public GestorAcceso() {
        try {
        	ContextoFaces ctxf = new ContextoFaces((ContextoWeb) getContexto()
					.getContextoBase());	
            ControlAplicacion controlAplicacion = (ControlAplicacion) ctxf.getBean("controlAplicacion");
            if (controlAplicacion != null)
                servicioUsuario = controlAplicacion.getServicioUsuario();
        }
        catch (Exception ex) {
            logError(new Date() + " Error en GestorAcceso.GestorAcceso(). Motivo: " + ex.getMessage());
        }
    }

    public SesionUsuarioDto iniAplicacionUsuario(String usuario, String password, String ip, String session) {
        try {
            return servicioUsuario.accediendoAplicacion(usuario, password, ip, session);
        }
        catch (ServicioException ex) {
            logError(new Date() + " Error en GestorAcceso.iniAplicacionUsuario(" + usuario + ", " + ip + ", "
                + session + "). Motivo: " + ex.getMessage());
            return null;
        }
    }
}

package com.sorin.idea.iu;

import hvn.apl.jProyecto2010.modelo.servicios.LocalizadorServicios;
import hvn.apl.jProyecto2010.modelo.servicios.ServicioBase;
import hvn.apl.jProyecto2010.modelo.servicios.ServicioUsuario;
import hvn.cm.iu.form.ListaBaseForm;

import java.util.Date;

public class ControlAplicacion  extends ListaBaseForm {
    private static final long serialVersionUID     = 5961810210898404412L;

    LocalizadorServicios      localizadorServicios = null;
    ServicioBase              servicioBase         = null;
    ServicioUsuario           servicioUsuario      = null;
    String                    iniBean              = "";

    public ControlAplicacion() {
        try {
            localizadorServicios = new LocalizadorServicios();
            if (localizadorServicios != null) {
                servicioBase = localizadorServicios.getServicio(ServicioBase.class);
                servicioUsuario = localizadorServicios.getServicio(ServicioUsuario.class);
            }
            setBean("controlAplicacion",this);
        }
        catch (Exception ex) {
            logError(new Date() + " Error en ControlAplicacion.ControlAplicacion(). Motivo: " + ex.getMessage());
        }
    }

    public ServicioBase getServicioBase() {
        return servicioBase;
    }

    public void setServicioBase(ServicioBase servicioBase) {
        this.servicioBase = servicioBase;
    }

    public ServicioUsuario getServicioUsuario() {
        return servicioUsuario;
    }

    public void setServicioUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    public String getIniBean() {
        return iniBean;
    }

    public void setIniBean(String iniBean) {
        this.iniBean = iniBean;
    }
}

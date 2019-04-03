package com.sorin.idea.iu;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import hvn.cm.iu.form.ListaBaseForm;

public class BaseIU extends ListaBaseForm {
    private static final long serialVersionUID = 1L;

    public static final int   INFO             = 1;
    public static final int   AVISO            = 2;
    public static final int   ERROR            = 3;
    boolean                   hayMensajes      = false;

    public BaseIU() {
        super();
    }

    public boolean isHayMensajes() {
        try {
            return getContexto().getMensajes().isEmpty();
        }
        catch (Exception e) {
            return false;
        }
    }

    public void pintaMensaje(int tipo, String mensaje) {
    	String idForm = null;
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            if (tipo == 1)
                context.addMessage(idForm, new FacesMessage(FacesMessage.SEVERITY_INFO, mensaje, mensaje));
            if (tipo == 2)
                context.addMessage(idForm, new FacesMessage(FacesMessage.SEVERITY_WARN, mensaje, mensaje));
            if (tipo == 3)
                context.addMessage(idForm, new FacesMessage(FacesMessage.SEVERITY_ERROR, mensaje, mensaje));

        }
        catch (Exception ex) {
            System.out.println("error : " + ex.getMessage());
        }
    }

    public void nuevoMensaje(String idForm, int tipo, String mensaje1, String mensaje2) {
        pintaMensaje(tipo, mensaje1);
    }
}

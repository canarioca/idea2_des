package com.sorin.idea.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.PropertyResourceBundle;

public class FtpConfiguracion {
    private String ficheroPropiedades = "com/sorin/idea/util/ftp.properties";

    private String hostRemoto         = new String();
    private String usuario            = new String();
    private String clave              = new String();
    private String directorio         = new String();

    public FtpConfiguracion() {
        this.configuracionFicheroProperties();
    }

    /**
     * Obtiene una configuración por fichero de propiedades.
     */
    private void configuracionFicheroProperties() {

        String cad;

        try {
            InputStream inputStream = FtpConfiguracion.class.getClassLoader().getResourceAsStream(
                ficheroPropiedades);
            PropertyResourceBundle bundle = new PropertyResourceBundle(inputStream);

            // propiedad para recoger el usuario.
            cad = bundle.getString("ftp.username").trim();
            if (cad != null && !cad.isEmpty())
                usuario = cad;

            // propiedad para recoger la clave.
            cad = bundle.getString("ftp.password").trim();
            if (cad != null && !cad.isEmpty())
                clave = cad;

            // propiedad para recoger el host Remoto.
            cad = bundle.getString("ftp.hostRemoto").trim();
            if (cad != null && !cad.isEmpty())
                hostRemoto = cad;

            // propiedad para recoger el directorio de envío del pedido.
            cad = bundle.getString("ftp.directorio").trim();
            if (cad != null && !cad.isEmpty())
                directorio = cad;

        }
        catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("ERROR: Al obtener los parámetros de configuración FTP");
        }
    }

    public String getFicheroPropiedades() {
        return ficheroPropiedades;
    }

    public void setFicheroPropiedades(String ficheroPropiedades) {
        this.ficheroPropiedades = ficheroPropiedades;
    }

    public String getHostRemoto() {
        return hostRemoto;
    }

    public void setHostRemoto(String hostRemoto) {
        this.hostRemoto = hostRemoto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDirectorio() {
        return directorio;
    }

    public void setDirectorio(String directorio) {
        this.directorio = directorio;
    }

}

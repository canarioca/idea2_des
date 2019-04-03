package com.sorin.idea.util;



import java.io.File;

import org.apache.log4j.Logger;

import com.sorin.idea.iu.ControlImplantes;



import hvn.cm.iu.form.BaseForm;

public class GestorFTPInforme extends BaseForm {
    private static final long serialVersionUID = 6125820813347145033L;
    private static Logger logger = Logger.getLogger(GestorFTPInforme.class);
	
    public static int enviarFicheroFTP(String origen, String destino) {
        int ok = 1;

        if (origen == null || origen.equals("") || destino == null || destino.equals(""))
            return -1;

        FtpTransfer ftp = new FtpTransfer();

        File ficheroLocal = new File(origen);

        if (ficheroLocal.length() <= 0) {
            System.out.println("ERROR: No se ha creado el fichero correctamente");
            logger.error("ERROR: No se ha creado el fichero correctamente");
            return -1;
        }

        String ficheroRemoto = ftp.getFtp_configuracion().getDirectorio() + destino;

        if (ftp.putFicheroFtp(ficheroLocal.getAbsolutePath(), ficheroRemoto) < 0) {
            System.out.println("ERROR: No se ha ha enviado el fichero correctamente");
            logger.error("ERROR: No se ha ha enviado el fichero correctamente. Compruebe la conectividad con el servidor FTP");
            return -1;
        }

        return ok;
    }

}

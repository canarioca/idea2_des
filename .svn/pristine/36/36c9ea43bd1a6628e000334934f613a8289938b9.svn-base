package com.sorin.idea.util;

import java.io.IOException;

import com.enterprisedt.net.ftp.FTPException;
import com.enterprisedt.net.ftp.FileTransferClient;

public class FtpTransfer {

    private FileTransferClient ftp;

    public FtpConfiguracion    ftp_configuracion;

    public FtpTransfer() {
        ftp = new FileTransferClient();
        ftp_configuracion = new FtpConfiguracion();
    }

    /**
     * Inicializa los parámetros de configuración y crea la conexión FTP
     * 
     * @throws IOException
     * @throws FTPException
     */
    public void conectar()
        throws IOException, FTPException {

        ftp.setRemoteHost(ftp_configuracion.getHostRemoto());
        ftp.setUserName(ftp_configuracion.getUsuario());
        ftp.setPassword(ftp_configuracion.getClave());

        ftp.connect();
    }

    /**
     * Cierra la conexión FTP
     * 
     * @throws IOException
     * @throws FTPException
     */

    public void desconectar()
        throws IOException, FTPException {
        ftp.disconnect();
    }

    /**
     * Recibe un fichero mediante ftp de un servidor a otro.
     * 
     * @param ficheroLocal
     * @param ficheroRemoto
     * @return
     */

    public int getFicheroFtp(String ficheroLocal, String ficheroRemoto) {
        int ok = 1;

        // Inicio de la conexión FTP
        try {
            conectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al obtener la conexión FTP");
            return -1;
        }

        // Se obtiene el fichero remoto
        try {
            ftp.downloadFile(ficheroLocal, ficheroRemoto);
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al coger el fichero remoto mediante FTP");
            return -1;
        }

        // Cierre de la conexión FTP
        try {
            desconectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al cerrar la conexión FTP");
            return -1;
        }

        return ok;
    }

    /**
     * Recibe un fichero mediante ftp de un servidor a otro. Es necesario realizar una conexión previa.
     * 
     * @param ficheroLocal
     * @param ficheroRemoto
     * @return
     */

    public int getFicheroFtpSinConexion(String ficheroLocal, String ficheroRemoto) {
        int ok = 1;

        // Se obtiene el fichero remoto
        try {
            ftp.downloadFile(ficheroLocal, ficheroRemoto);
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al coger el fichero remoto mediante FTP");
            return -1;
        }
        return ok;
    }

    /**
     * Envía un fichero por ftp a una máquina remota
     * 
     * @param ficheroLocal
     * @param ficheroRemoto
     * @return
     */
    public int putFicheroFtp(String ficheroLocal, String ficheroRemoto) {
        int ok = 1;

        // Inicio de la conexión FTP
        try {
            conectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al obtener la conexión FTP");
            return -1;
        }

        // se comprueba si existe la carpeta y se crea
        try {
            ftp.createDirectory(ficheroRemoto.substring(0,ficheroRemoto.length()-9));
            ftp.createDirectory(ficheroRemoto.substring(0,ficheroRemoto.length()-6));
            ftp.createDirectory(ficheroRemoto.substring(0,ficheroRemoto.length()-3));
        }
        catch (Exception ex) {
        	try {
            		ftp.createDirectory(ficheroRemoto.substring(0,ficheroRemoto.length()-6));
            		ftp.createDirectory(ficheroRemoto.substring(0,ficheroRemoto.length()-3));
            }
            catch (Exception ex1) {
            	try {
                		ftp.createDirectory(ficheroRemoto.substring(0,ficheroRemoto.length()-3));
                }
                catch (Exception ex2) {
                }
            }
        }
        try {
        	// Se envía el fichero local
            ftp.uploadFile(ficheroLocal, ficheroRemoto);
        }
        catch (Exception ex) {
            System.out.println("ERROR: Al copiar el fichero remoto mediante FTP");
            return -1;
        }

        // Cierre de la conexión FTP
        try {
            desconectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al cerrar la conexión FTP");
            return -1;
        }

        return ok;

    }

    /**
     * Envía un fichero por ftp a una máquina remota, es necesario realizar una conexión previa
     * 
     * @param ficheroLocal
     * @param ficheroRemoto
     * @return
     */
    public int putFicheroFtpSinConexion(String ficheroLocal, String ficheroRemoto) {
        int ok = 1;

        // Se envía el fichero local
        try {
            ftp.uploadFile(ficheroLocal, ficheroRemoto);
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al coger el fichero remoto mediante FTP");
            return -1;
        }

        return ok;

    }

    /**
     * Borra un fichero que se encuentra en otra máquina mediante ftp
     * 
     * @param ficheroRemoto
     * @return
     */
    public int borrarFicheroRemoto(String ficheroRemoto) {
        int ok = 1;

        // Inicio de la conexión FTP
        try {
            conectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al obtener la conexión FTP");
            return -1;
        }

        // Se envía el fichero local
        try {
            ftp.deleteFile(ficheroRemoto);
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al coger el fichero remoto mediante FTP");
            return -1;
        }

        // Cierre de la conexión FTP
        try {
            desconectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al cerrar la conexión FTP");
            return -1;
        }

        return ok;

    }

    /**
     * Borra un fichero que se encuentra en otra máquina mediante ftp. Es necesario realizar una conexión previa.
     * 
     * @param ficheroRemoto
     * @return
     */
    public int borrarFicheroRemotoSinConexion(String ficheroRemoto) {
        int ok = 1;

        // Se envía el fichero local
        try {
            ftp.deleteFile(ficheroRemoto);
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al coger el fichero remoto mediante FTP");
            return -1;
        }
        return ok;
    }

    /**
     * Devuelve una lista con los ficheros que se encuentran en el directorio determinado
     * 
     * @param directorioRemoto
     * @return
     */
    public String[] listarDirectorioRemoto(String directorioRemoto) {
        String[] lista = null;

        // Inicio de la conexión FTP
        try {
            conectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al obtener la conexión FTP");
            return null;
        }

        // Se obtiene la lista de ficheros
        try {
            lista = ftp.directoryNameList(directorioRemoto, false);
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al coger el fichero remoto mediante FTP");
            return null;
        }

        // Cierre de la conexión FTP
        try {
            desconectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al cerrar la conexión FTP");
            return null;
        }

        return lista;
    }

    /**
     * Cambia el directorio remoto.
     * 
     * @param directorioRemoto
     * @return
     */
    public int cambiarDirectorioRemoto(String directorioRemoto) {
        int ok = 1;

        // Inicio de la conexión FTP
        try {
            conectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al obtener la conexión FTP");
            return -1;
        }

        // Se cambia de directorio
        try {
            ftp.changeDirectory(directorioRemoto);
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al coger el fichero remoto mediante FTP");
            return -1;
        }

        // Cierre de la conexión FTP
        try {
            desconectar();
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al cerrar la conexión FTP");
            return -1;
        }
        return ok;
    }

    /**
     * Cambia el directorio remoto. Es necesario realizar una conexión previa.
     * 
     * @param directorioRemoto
     * @return
     */
    public int cambiarDirectorioRemotoSinconexion(String directorioRemoto) {
        int ok = 1;

        // Se cambia de directorio
        try {
            ftp.changeDirectory(directorioRemoto);
        }
        catch (Exception ex) {
            
            System.out.println("ERROR: Al coger el fichero remoto mediante FTP");
            return -1;
        }

        return ok;
    }

    public FtpConfiguracion getFtp_configuracion() {
        return ftp_configuracion;
    }

    public void setFtp_configuracion(FtpConfiguracion ftp_configuracion) {
        this.ftp_configuracion = ftp_configuracion;
    }
}

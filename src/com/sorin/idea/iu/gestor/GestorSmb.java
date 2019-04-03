/**
 * 
 */
package com.sorin.idea.iu.gestor;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Properties;

import jcifs.smb.SmbFile;

import org.apache.log4j.Logger;

import com.sorin.idea.dto.Evento;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilFiles;

/**
 * Clase mediadora de gestion de consulta y visualizacion de informes en directorios remotos en red
 * @author Francisco.Romera
 *
 */
public class GestorSmb {

	private static Logger logger = Logger.getLogger(GestorSmb.class);
	
	private String RUTA_INFORME;
	private String RUTA_INFORME_LOCAL;
	private String SERVER;
	private String USER;
	private String PASS;
	private String DOMINIO;
	
	public GestorSmb(){
		inicia();
	}
	
	public ArrayList<SmbDto> getFilesFromDir(String ruta_dir_pat, String extension) {
		try{
			ArrayList<SmbDto> smbFiles = new ArrayList<SmbDto>();
			ArrayList<SmbFile> files = UtilFiles.getFilesFromDir(SERVER, ruta_dir_pat, USER, PASS, DOMINIO, extension);
			for(SmbFile s:files){
				// Obtencion de datos de ficheros remotos
				SmbDto item = new SmbDto(s.getName(),s);
				smbFiles.add(item);
			}
			return smbFiles;
		}catch(Exception e1){
			e1.printStackTrace();
			logger.error("Error en obtencion de informes de repositorio. Motivo: "+e1.getMessage(),e1);
			return null;
		}
	}
	
	public static Date obtenerFecha(String in){
		try{
			String[] aux = in.split("_");
			if(aux!=null && aux.length>=2 && aux[2]!=null){
				aux[2] = aux[2].replace("[", "");
				aux[2] = aux[2].replace("]", "");
				return UtilFechas.StringToDateFormato(aux[2], "yyyyMMddHHmmss");
			}
		}catch(Exception e1){
			e1.printStackTrace();
		}
		return null;
	}
	
	public void inicia() {		
		try {
			Properties p = new Properties();
			InputStream is = GestorSmb.class.getResourceAsStream("smb.properties");
			p.load(is);
			RUTA_INFORME = p.getProperty("informes.ruta");
			SERVER = p.getProperty("smb.servidor");
			RUTA_INFORME_LOCAL = p.getProperty("smb.rutaservidor");
			USER = p.getProperty("smb.user");
			PASS = p.getProperty("smb.pass");
			DOMINIO = p.getProperty("smb.dominio");
			is.close();
		} catch (IOException e) {
			logger.error("ERROR en lectura properties: smb.properties");
		}
	}
}

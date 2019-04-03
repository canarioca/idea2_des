package com.sorin.idea.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;
import jcifs.smb.SmbFileOutputStream;

public class UtilFiles {

	public static void write2File(String str, String path){  		   	
		try{
	   	    BufferedWriter out = new BufferedWriter(new FileWriter(path));
	   	    out.write(str);
	   	    out.close();
	   	 }catch (IOException e){
	   		 e.fillInStackTrace();
	   	 } 
	}
	
	public static void crearDirectorio(String destino){
		File f = new File(destino);
		if(!f.exists()){
			f.mkdirs();
		}
	}
	
	public static boolean convertByteArrayToDoc(byte[] b, String path) {
		//below is the different part
        File someFile = new File(path);
        FileOutputStream fos;
		try {
			fos = new FileOutputStream(someFile);
			fos.write(b);
	        fos.flush();
	        fos.close();
	        return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
	}
	public static String file2String(File file){
    	//StringBuffer buffer=new StringBuffer();
    	String line="";
    	String aux="";
    	FileReader fReader;
    	BufferedReader bReader;  	
    	try{
    		fReader=new FileReader(file);
    		bReader = new BufferedReader(fReader);
    		while((line=bReader.readLine())!=null){	    			  	
    			aux =aux+"\n"+line; 
    		}
    		bReader.close();
    		fReader.close();  		
    	}catch(FileNotFoundException e){
    		e.fillInStackTrace();
    	}catch(IOException e){
    		e.fillInStackTrace();
    	} 
    	return aux;
    }
	
	public static byte[] read(File file) throws IOException {

	    ByteArrayOutputStream ous = null;
	    InputStream ios = null;
	    try {
	        byte[] buffer = new byte[4096];
	        ous = new ByteArrayOutputStream();
	        ios = new FileInputStream(file);
	        int read = 0;
	        while ( (read = ios.read(buffer)) != -1 ) {
	            ous.write(buffer, 0, read);
	        }
	    } finally { 
	        try {
	             if ( ous != null ) 
	                 ous.close();
	        } catch ( IOException e) {
	        }

	        try {
	             if ( ios != null ) 
	                  ios.close();
	        } catch ( IOException e) {
	        }
	    }
	    return ous.toByteArray();
	}
	
	public static boolean moverFicheroRemotoSamba(File original, String user, String pass, String server, String ruta_server,String dominio){
		try{
			String sourcePath = original.getAbsolutePath();
	        String destinationPath = "smb://"+server+ruta_server;
			copyFileUsingJcifs(user, pass, sourcePath, destinationPath,dominio);
			original.delete();
			//logger.info("Fichero copiado correctamente en destino ("+ruta_server+") y borrado en local");
			return true;
	    }catch(IOException e){
	    	e.printStackTrace();
	    	//logger.error("Error moviendo fichero. Causa: "+e.getMessage(), e);
	    	return false;
	    } catch (Exception e) {
	    	e.printStackTrace();
    	   // logger.error("Error moviendo fichero. Causa: "+e.getMessage(), e);
    	    return false;
		}
	}
	
	public static void copyFileUsingJcifs(final String userName,
		final String password, final String sourcePath,
		final String destinationPath, final String dominio) throws IOException {

		final String user = userName + ":" + password;
		//final NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
		final NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(dominio,userName,password);
		final SmbFile sFile = new SmbFile(destinationPath, auth);
		final SmbFileOutputStream smbFileOutputStream = new SmbFileOutputStream(sFile);
		final FileInputStream fileInputStream = new FileInputStream(new File(sourcePath));

		final byte[] buf = new byte[16 * 1024 * 1024];
		int len;
		while ((len = fileInputStream.read(buf)) > 0) {
		   smbFileOutputStream.write(buf, 0, len);
		}
		fileInputStream.close();
		smbFileOutputStream.close();
	}
	
	public static boolean copyFilesJCIFS(String fileContent, String destino, String user, String pass, String dominio) {
        boolean successful = false;
         try{
        	//NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
        	NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(dominio,user,pass);
            SmbFile sFile = new SmbFile("smb://"+destino, auth);
            SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
            sfos.write(fileContent.getBytes());
            successful = true;
            sfos.close();
       } catch (Exception e) {
    	   successful = false;
           e.printStackTrace();
        }
        return successful;
    }
	
	public static void borrarFiles(File root){
		if(root.exists() && root.listFiles()!=null)
			for(File fs:root.listFiles()){
				if(fs.isDirectory())
					borrarFiles(fs);
				fs.delete();				
			}				
	}
	
	public static void borrarFilesJCIFS(String destino, String user, String pass, String dominio){
		try{
			ArrayList<SmbFile> lista = getFilesFromDir(destino,user,pass,dominio);
			for(SmbFile f:lista){
				if(f.isDirectory())
					borrarFilesJCIFS(f.getCanonicalPath(),user,pass,dominio);
				f.delete();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para trasladar directorio origen hacia directorio destino
	 * @param origen: Directorio origen
	 * @param destino: Directorio destino
	 */
	public static boolean moverDirectorioLectura_(String origen, String destino){
		try{
			File sourceDir = new File(origen); //this directory already exists
			File destDir = new File(destino); //this is a new directory
			destDir.mkdirs(); // make sure that the dest directory exists
			Path destPath = destDir.toPath();
			for (File sourceFile : sourceDir.listFiles()) {
			    Path sourcePath = sourceFile.toPath();
			    Files.copy(sourcePath, destPath.resolve(sourcePath.getFileName()));
			}
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean moverDirectorioLectura(String origen, String destino){
		try{
			File ini = new File(origen);
			File dest = new File(destino);
			FileUtils.copyDirectory(ini, dest, true);
			return true;
		}catch(Exception e1){
			e1.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Metodo de consulta de fichero en repositorio 
	 * @param path
	 * @param userName
	 * @param password
	 * @param dominio
	 * @param extension
	 * @return
	 */
	public static ArrayList<SmbFile> getFilesFromDir(String server,String path,String userName,String password,String dominio,String extension) {
		try{
			final NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(dominio,userName,password);
			SmbFile baseDir = new SmbFile( "smb://"+server+"/"+path+"/",auth);
		    SmbFile[] files = baseDir.listFiles();
		    ArrayList<SmbFile> results = new ArrayList<SmbFile>();
		    for(int i=0;i< files.length;i++) {
		        SmbFile file = files[i];
		        if(!file.isDirectory()){
		        	if(file.getName().toUpperCase().endsWith(extension))
		        		results.add(file);  
		        }
		    }
		    return results;
		}catch(Exception e1){
			e1.printStackTrace();
			return null;
		}
	}
	
	public static ArrayList<SmbFile> getFilesFromDir(String path,String userName,String password,String dominio) {
		try{
			final NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(dominio,userName,password);
			SmbFile baseDir = new SmbFile( "smb://"+path+"/",auth);
		    SmbFile[] files = baseDir.listFiles();
		    ArrayList<SmbFile> results = new ArrayList<SmbFile>();
		    for(int i=0;i< files.length;i++) 
		    	results.add(files[i]);
		    return results;
		}catch(Exception e1){
			e1.printStackTrace();
			return null;
		}
	}
	
	public static byte[] obtenerContenido(SmbFile sFile){
		try{
			InputStream in = new SmbFileInputStream(sFile);
			return UtilFiles.getBytes(in);
		}catch(Exception e1){
			e1.printStackTrace();
			return null;
		}
	}
	
	public static byte[] getBytes(InputStream is){
		try{
			int len;
			int size=1024;
			byte[] buf;
			
			if(is instanceof ByteArrayInputStream){
				size = is.available();
				buf = new byte[size];
				len = is.read(buf, 0, size);
			}else{
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				buf = new byte[size];
				while((len=is.read(buf, 0, size))!=-1)
					bos.write(buf, 0, len);
				buf = bos.toByteArray();	
			}
			return buf;
		}catch(Exception e1){
			e1.printStackTrace();
			return null;
		}
	}
	
	public static File mergePDF(ArrayList<File> files, String dest_dir, String nombre_fichero) {
		File f = null;	
		try {	
			Document pdfCombineUsingJava = new Document();			
			PdfCopy copy = new PdfCopy(pdfCombineUsingJava, new FileOutputStream(new File(dest_dir+"/"+nombre_fichero+".pdf")));			
			pdfCombineUsingJava.open();
			PdfReader ReadInputPDF;			
			int number_of_pages;
			for (int i = 0; i < files.size(); i++) {
				ReadInputPDF = new PdfReader(files.get(i).toString());
				number_of_pages = ReadInputPDF.getNumberOfPages();
				for (int page = 0; page < number_of_pages;) {
					copy.addPage(copy.getImportedPage(ReadInputPDF, ++page));
				}
			}
			pdfCombineUsingJava.close();						
			f = new File(dest_dir+"/"+nombre_fichero+".pdf");// FRR - mover fichero a directorio temporal de consulta
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return f;
	}
	
	public static File copiarInformeAdjunto(File dir_repo, String dest){
		for(File f:dir_repo.listFiles())
			if(f.getName().toUpperCase().endsWith("PDF")){
				try {
					Files.copy(Paths.get(f.getAbsolutePath()), Paths.get(dest), StandardCopyOption.REPLACE_EXISTING);
					File fich = new File(dest);
					if(fich.exists())
						return fich;
					break;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		return null;
	}
	
	public static String obtenerDirectorioHolter(File root){
		String res = null;
		for(File f:root.listFiles()){
			if(f.isDirectory() && f.getName().toUpperCase().startsWith("PAT"))
				return f.getName();
		}
		return res;
	}
	
	public static String obtenerDirectorioRegEvExt(File root){
		String res = null;
		for(File f:root.listFiles()){
			if(f.isDirectory() && f.getName().toUpperCase().startsWith("EVT"))
				return f.getName();
		}
		return res;
	}
}

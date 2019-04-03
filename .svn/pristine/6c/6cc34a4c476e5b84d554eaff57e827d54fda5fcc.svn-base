package com.sorin.idea.acceso;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import org.apache.log4j.Logger;



/**
 * Clase util de mecanismos de validación de usuarios por medio de LDAP 
 * @author Francisco.Romera
 *
 */
public class AccesoLDAP {

	private static Logger logger = Logger.getLogger(AccesoLDAP.class);
	private static Properties p = new Properties();
	
	public AccesoLDAP(){
		inicia();
	}
	/**
	 * Metodo de validacion de usuarios LDAP
	 * @param login
	 * @param pass
	 * @return 1 = OK, 0 = USUARIO NO VALIDO, -1 = ERROR INTERNO 
	 */
	public int isUsuarioLDAP(String login,String pass){
		try{
			Hashtable<String, String> env = new Hashtable<String, String>();
	        String factory, url, authentication, dominio, activo;
	        // resto de atributos
	        factory = p.getProperty("aut.ldap.initial.context.factory");
	        url = p.getProperty("aut.ldap.provider.url");
	        authentication = p.getProperty("aut.ldap.security.authentication");
	        dominio = p.getProperty("aut.ldap.usuario.dominio");
	        // nombre = bundle.getString("ldap.nombre");

	        // introducimos el nombre que nos va a permitir identificarnos
	        env.put(Context.INITIAL_CONTEXT_FACTORY, factory);
	        env.put(Context.PROVIDER_URL, url);
	        env.put(Context.SECURITY_AUTHENTICATION, authentication);
	        //env.put(Context.SECURITY_PRINCIPAL, login.trim());
	        //env.put(Context.SECURITY_PRINCIPAL, "CN="+login.trim()+",OU=mathematicians,DC=example,DC=com");
	        //env.put(Context.SECURITY_PRINCIPAL, "CN="+login.trim()+",OU=users,DC=testathon,DC=net");	
	        //env.put(Context.SECURITY_PRINCIPAL, "CN="+login+",OU=OU-30-USR-2.ESTANDAR,OU=OU-30-USR-OSI DONOSTIALDEA,OU=OU-30-OSI DONOSTIALDEA,DC=osakidetza,DC=svs,DC=local");
	        //env.put(Context.SECURITY_PRINCIPAL, "CN="+login+",OU=All Users,DC=osakidetza,DC=svs,DC=local");
	        env.put(Context.SECURITY_PRINCIPAL, login+"@"+dominio);
		       
	        
	        env.put(Context.SECURITY_CREDENTIALS, pass);
	        // acceder a directorio activo
	        try {
	            DirContext ctx = new InitialDirContext(env);	            
	            ctx.close();
	            return 1;
	        }
	        catch (NamingException e) {
	        	e.fillInStackTrace();
				e.printStackTrace();
	            return 0;
	        }
		}catch(Exception e){
			logger.error("Error validando usuario. Motivo: "+e.getMessage(), e);
			return -1;
		}
	}
	
	private static void inicia(){
		try {
			p = new Properties();
			InputStream is = AccesoLDAP.class.getResourceAsStream("ldap.properties");
			p.load(is);
			is.close(); 
		} catch (IOException e) {
			logger.error("ERROR en lectura properties: ldap.properties",e);
		} 
	}
}

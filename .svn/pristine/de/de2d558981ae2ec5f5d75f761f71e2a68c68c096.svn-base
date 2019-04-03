package com.sorin.idea.util;

import hvn.cm.dao.bd.impl.GestionConexionLDAP;
import hvn.cm.modelo.BaseServicio;
import hvn.cm.utiles.conf.dto.ConfigConexionDto;
import hvnx.contexto.base.IContextoDao;
import hvnx.contexto.base.IContextoIu;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.PropertyResourceBundle;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

import com.sorin.idea.util.Manager;

// import com.microsoft.util.UtilException;

import hvn.mod.seg2.modelo.dto.UsuarioLDAPDto;
import hvn.mod.usu.dao.UsuarioDaoImpl;
import hvn.mod.usu.modelo.dto.UsuarioDto;

/**
 * Clase util con métodos para autenticar usuarios en varios sistemas del HVN.
 * 
 * @author José Sevilla
 * @version 1.0, 24/09/2008
 */
public class AutenticaUsuarioHVN extends BaseServicio {
    private static String           fileProperties = "hvn/apl/jProyecto2011/modelo/dao/dao.properties";
    /** Lista de atributos que vamos a recuperar del sistema LDAP */
    protected final static String[] atributos      = {"physicalDeliveryOfficeName", "sAMAccountName"};

    /**
     * Comprueba que este es usuario del hospital, primero compruenba que sea usuario de directorio activo (LDAP)
     * si lo es devuelve true, en caso de que no lo sea, compruba si es usuario de la máquina de clínica intentando
     * conectar por jdbc a la base de datos integral de dicho servidor si conecta devuelve true y si no false.
     * 
     * @param login nombre de usuarios.
     * @param pass clave de usuario.
     * @return true si es usuario del HVN o false en otro caso.
     * @throws UtilException
     */
    public static boolean isUsuarioHVN(String login, String pass)
        throws Exception {
        String activoLDAP, activoClinica;

        // leer datos del fichero de propiedades
        InputStream inputStream = Manager.class.getClassLoader().getResourceAsStream(fileProperties);
        PropertyResourceBundle bundle;

        try {
            bundle = new PropertyResourceBundle(inputStream);
        }
        catch (IOException e) {
            throw new Exception(
                "AutenticaUsuario.isUsuarioHVN(String login, String pass) Error al acceder al fichero de propiedades: "
                    + e.getMessage(), e);
        }

        // comprobar si esta activo autentifcación por clínica y LDAP
        activoLDAP = bundle.getString("aut.ldap.activo");
        activoClinica = bundle.getString("aut.clinica.activo");

        // LDAP
        if (activoLDAP.equals("true"))
            if (isUsuarioLDAPHVN(login, pass))
                return true;

        if (activoClinica.equals("true"))
            if (isUsuarioBDMBClinica(login, pass))
                return true;

        return false;
    }

    /**
     * Metodo para comprobar que es usuario del LDAP del hospital.
     * 
     * @param login nombre de usuairos
     * @param pass clave de usuarios
     * @return true si el usuario es un usuario valido de LDAP del HVN.
     * @throws UtilException
     * @since 1.0
     */
    public static boolean isUsuarioLDAPHVN(String login, String pass)
        throws Exception {
        Hashtable<String, String> env = new Hashtable<String, String>();
        String factory, url, authentication, dominio, activo;
        // String nombre;

        // leer datos del fichero de propiedades
        InputStream inputStream = Manager.class.getClassLoader().getResourceAsStream(fileProperties);
        PropertyResourceBundle bundle;

        try {
            bundle = new PropertyResourceBundle(inputStream);
        }
        catch (IOException e) {
            throw new Exception(
                "AutenticaUsuario.isUsuarioLDAPHVN(String login, String pass) Error al acceder al fichero de propiedades: "
                    + e.getMessage(), e);
        }
        // comprobar si esta activo autentifcación por clínica y si no devolver una excepción
        activo = bundle.getString("aut.ldap.activo");
        if (activo == null || activo.equals("false"))
            throw new Exception(
                "AutenticaUsuario.isUsuarioBDMBClinica(String login, String pass) No está activa la autenticación por BD de Clínica");

        // resto de atributos
        factory = bundle.getString("aut.ldap.initial.context.factory");
        url = bundle.getString("aut.ldap.provider.url");
        authentication = bundle.getString("aut.ldap.security.authentication");
        dominio = bundle.getString("aut.ldap.usuario.dominio");
        // nombre = bundle.getString("ldap.nombre");

        // introducimos el nombre que nos va a permitir identificarnos
        env.put(Context.INITIAL_CONTEXT_FACTORY, factory);
        env.put(Context.PROVIDER_URL, url);
        env.put(Context.SECURITY_AUTHENTICATION, authentication);
        env.put(Context.SECURITY_PRINCIPAL, login.trim() + "@" + dominio);
        env.put(Context.SECURITY_CREDENTIALS, pass);

        // acceder a directorio activo
        try {
            DirContext ctx = new InitialDirContext(env);
            
            ctx.close();
            return true;
        }
        catch (NamingException e) {
            // throw new
            // UtilException("AutenticaUsuario.isUsuarioLDAPHVN(String login, String pass) Error al inicializar el contecto LDAP: "
            // + e.getMessage(),e);
            return false;
        }
    }

    public static boolean isUsuarioBDMBClinica(String login, String pass)
        throws Exception {
        String jdbcDriver = null;
        String jdbcUrl = null;
        String jdbcUsername = null;
        String jdbcPassword = null;
        String activo;
        Connection con;

        // leer datos del fichero de propiedades
        InputStream inputStream = Manager.class.getClassLoader().getResourceAsStream(fileProperties);
        PropertyResourceBundle bundle;

        try {
            bundle = new PropertyResourceBundle(inputStream);
        }
        catch (IOException e) {
            throw new Exception(
                "AutenticaUsuario.isUsuarioBDMBClinica(String login, String pass) Error al acceder al fichero de propiedades: "
                    + e.getMessage(), e);
        }

        // comprobar si esta activo autentifcación por clínica y si no devolver una excepción
        activo = bundle.getString("aut.clinica.activo");
        if (activo == null || activo.equals("false"))
            throw new Exception(
                "AutenticaUsuario.isUsuarioBDMBClinica(String login, String pass) No está activa la autenticación por BD de Clínica");

        jdbcDriver = bundle.getString("aut.clinica.jdbc.driver");
        try {
            Class.forName(jdbcDriver).newInstance();
        }
        catch (InstantiationException e1) {
            throw new Exception(
                "AutenticaUsuario.isUsuarioBDMBClinica(String login, String pass) Error al instanciar el driver jdbc: "
                    + e1.getMessage(), e1);
        }
        catch (IllegalAccessException e1) {
            throw new Exception(
                "AutenticaUsuario.isUsuarioBDMBClinica(String login, String pass) Error al acceder al driver jdbc: "
                    + e1.getMessage(), e1);
        }
        catch (ClassNotFoundException e1) {
            throw new Exception(
                "AutenticaUsuario.isUsuarioBDMBClinica(String login, String pass) Error no se ha encontrado el driver jdbc: "
                    + e1.getMessage(), e1);
        }
        jdbcUrl = bundle.getString("aut.clinica.jdbc.url");
        jdbcUsername = login;
        jdbcPassword = pass;

        // conectar y desconectar de la base de datos
        if (jdbcDriver != null && jdbcUrl != null && jdbcUsername != null && jdbcPassword != null) {
            try {
                con = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
                con.close();
            }
            catch (SQLException e) {
                return false;
            }
        } else
            return false;

        return true;
    }

    public UsuarioDto getInfoUsuario(String usuario, String clave)
        throws Exception {
        try {
            IContextoIu contexto = null;
            contexto = (IContextoIu) getContexto();

            GestionConexionLDAP gestion = new GestionConexionLDAP();
            ConfigConexionDto config = gestion.getConfiguracion();

            config.setClave(contexto.getEncriptador().encriptar(clave));
            // config.setClave(new String(getClave()));
            config.setUsuario(usuario);
            // la introducimos en el contexto
            contexto.setToCache(IContextoDao.CONFIG_DA, gestion);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        UsuarioDaoImpl usuarioLdap = new UsuarioDaoImpl();
        UsuarioDto unUsuario = null;
        unUsuario = usuarioLdap.getUsuarioByLoginClave(usuario, clave);

        return unUsuario;
    }
    
    public  UsuarioDto getInfoUsuariobynif(String nif)
    throws Exception
{
    try {
        IContextoIu contexto = null;
        contexto = (IContextoIu) getContexto();

        GestionConexionLDAP gestion = new GestionConexionLDAP();
        ConfigConexionDto config = gestion.getConfiguracion();
        //config.setClave(contexto.getEncriptador().encriptar("nalepe07"));
         config.setClave(new String("generico2"));
        config.setUsuario("genclin1@hvn.sas.junta-andalucia.es");
        // la introducimos en el contexto
    
        contexto.setToCache(IContextoDao.CONFIG_DA, gestion);
    }
    catch (Exception ex) {
        System.out.println(ex.getMessage());
    }

    UsuarioDaoImpl usuarioLdap = new UsuarioDaoImpl();
    UsuarioDto unUsuario = null;
    unUsuario = usuarioLdap.getUsuarioLDAPByNIF(nif);

    return unUsuario;
}

}

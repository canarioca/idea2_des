package com.sorin.idea.jdbc;

import hvn.cm.dao.BaseDao;
import hvn.cm.dao.bd.IConfiguradorBd;
import hvn.cm.dao.bd.impl.GestorConexionBD;
import hvnx.aut.ICredencial;
import hvnx.contexto.base.FactoriaContexto;
import hvnx.contexto.base.IContextoDao;

import java.sql.*;
import java.util.Properties;

public class ResourceManager {
	/*private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/arritmias?user=root";
	private static String JDBC_USER = "root";
	private static String JDBC_PASSWORD = "";*/

	// CONECTVIDAD CON POOL DE CONEXION A BASE DE DATOS
	private static Driver driver = null;
	protected static IContextoDao ctx;
	protected static boolean isDePool = true;

	public static synchronized Connection getConnection() throws SQLException {
		Connection conex = null;
		try {
			if(ctx == null)
				ctx = (IContextoDao) FactoriaContexto.getContexto();
			if (isDePool) {
				conex = ctx.getConexion("poolDepart");
			}
			
			//Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
			//driver = (Driver) jdbcDriverClass.newInstance();
			//DriverManager.registerDriver(driver);
		} catch (Exception e) {
			System.out.println("Failed to initialise JDBC driver");
			e.printStackTrace();
		}
		return conex;
		//return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	}

	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void close(PreparedStatement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

	}

	
	 // CONECTVIDAD DIRECTA A BASE DE DATOS
/*	 private static String JDBC_DRIVER   = "com.mysql.jdbc.Driver";
    private static String JDBC_URL      = "jdbc:mysql://localhost/idea";

    private static String JDBC_USER     = "root";
    private static String JDBC_PASSWORD = "mysql";

    private static Driver driver = null;

    public static synchronized Connection getConnection()
	throws SQLException
    {
        if (driver == null)
        {
            try
            {
                Class jdbcDriverClass = Class.forName( JDBC_DRIVER );
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver( driver );
            }
            catch (Exception e)
            {
                System.out.println( "Failed to initialise JDBC driver" );
                e.printStackTrace();
            }
        }

        return DriverManager.getConnection(
                JDBC_URL,
                JDBC_USER,
                JDBC_PASSWORD
        );
    }


	public static void close(Connection conn)
	{
		try {
			if (conn != null) conn.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public static void close(PreparedStatement stmt)
	{
		try {
			if (stmt != null) stmt.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}

	public static void close(ResultSet rs)
	{
		try {
			if (rs != null) rs.close();
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}

	}
	*/
	
}

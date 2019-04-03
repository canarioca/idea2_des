/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.factory;

import java.sql.Connection;

import com.sorin.idea.dao.*;
import com.sorin.idea.jdbc.*;


public class ArrListaEsperaDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return ArrListaEsperaDao
	 */
	public static ArrListaEsperaDao create()
	{
		return new ArrListaEsperaDaoImpl("");
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return ArrListaEsperaDao
	 */
	public static ArrListaEsperaDao create(Connection conn)
	{
		return new ArrListaEsperaDaoImpl( conn );
	}

}

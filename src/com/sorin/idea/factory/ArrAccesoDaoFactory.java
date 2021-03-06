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


public class ArrAccesoDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return PedAccesoDao
	 */
	public static ArrAccesoDao create()
	{
		return new ArrAccesoDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return PedAccesoDao
	 */
	public static ArrAccesoDao create(Connection conn)
	{
		return new ArrAccesoDaoImpl( conn );
	}

}

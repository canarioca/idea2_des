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

public class RcNutricionDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return RcNutricionDao
	 */
	public static RcNutricionDao create()
	{
		return new RcNutricionDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return RcNutricionDao
	 */
	public static RcNutricionDao create(Connection conn)
	{
		return new RcNutricionDaoImpl( conn );
	}

}

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

public class RcRehaProbSensorialesDaoFactory
{
	/**
	 * Method 'create'
	 * 
	 * @return RcRehaProbSensorialesDao
	 */
	public static RcRehaProbSensorialesDao create()
	{
		return new RcRehaProbSensorialesDaoImpl();
	}

	/**
	 * Method 'create'
	 * 
	 * @param conn
	 * @return RcRehaProbSensorialesDao
	 */
	public static RcRehaProbSensorialesDao create(Connection conn)
	{
		return new RcRehaProbSensorialesDaoImpl( conn );
	}

}

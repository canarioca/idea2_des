/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.jdbc;


import java.sql.Connection;
import java.util.Collection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

import com.sorin.idea.dao.*;
import com.sorin.idea.dto.*;
import com.sorin.idea.exceptions.*;
import com.sorin.idea.factory.*;

public class ArrEnfActDaoImpl extends AbstractDAO implements ArrEnfActDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT ID_REGISTRO, ACT FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( ID_REGISTRO, ACT ) VALUES ( ?, ? )";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE ID_REGISTRO = ?";
	
	/** 
	 * Index of column ID_REGISTRO
	 */
	protected static final int COLUMN_ID_REGISTRO = 1;

	/** 
	 * Index of column ACT
	 */
	protected static final int COLUMN_ACT = 2;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 2;

	/** 
	 * Inserts a new row in the ARR_ENF_ACT table.
	 */
	public void insert(ArrEnfAct dto) throws ArrEnfActDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT );
			int index = 1;
			if (dto.getIdRegistro() != null) {
				stmt.setInt( index++, dto.getIdRegistro().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getAct() != null) {
				stmt.setInt( index++, dto.getAct().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			reset(dto);
		}
		catch (Exception _e) {
			throw new ArrEnfActDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}
	
	/** 
	 * Deletes a single row in the ARR_ENF table.
	 */
	public void delete(Integer codEnf) throws ArrEnfActDaoException{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_DELETE );
			if (codEnf != null) {
				stmt.setInt( 1, codEnf );
			} else {
				stmt.setNull(1, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new ArrEnfActDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the ARR_ENF_ACT table that match the criteria ''.
	 */
	public ArrEnfAct[] findAll() throws ArrEnfActDaoException
	{
		return findByDynamicSelect( SQL_SELECT, null );
	}

	/** 
	 * Returns all rows from the ARR_ENF_ACT table that match the criteria 'ID_REGISTRO = :idRegistro'.
	 */
	public ArrEnfAct[] findWhereIdRegistroEquals(long idRegistro) throws ArrEnfActDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_REGISTRO = ? ORDER BY ID_REGISTRO", new Object[] {  new Long(idRegistro) } );
	}

	/** 
	 * Returns all rows from the ARR_ENF_ACT table that match the criteria 'ACT = :act'.
	 */
	public ArrEnfAct[] findWhereActEquals(long act) throws ArrEnfActDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ACT = ? ORDER BY ACT", new Object[] {  new Long(act) } );
	}

	/**
	 * Method 'ArrEnfActDaoImpl'
	 * 
	 */
	public ArrEnfActDaoImpl()
	{
	}

	/**
	 * Method 'ArrEnfActDaoImpl'
	 * 
	 * @param userConn
	 */
	public ArrEnfActDaoImpl(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		//return "idea.ARR_ENF_ACT";
		return "idea.arr_enf_act";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ArrEnfAct fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ArrEnfAct dto = new ArrEnfAct();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ArrEnfAct[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ArrEnfAct dto = new ArrEnfAct();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ArrEnfAct ret[] = new ArrEnfAct[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ArrEnfAct dto, ResultSet rs) throws SQLException
	{
		dto.setIdRegistro( new Integer( rs.getInt(COLUMN_ID_REGISTRO) ) );
		dto.setAct( new Integer( rs.getInt(COLUMN_ACT) ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ArrEnfAct dto)
	{
	}

	/** 
	 * Returns all rows from the ARR_ENF_ACT table that match the specified arbitrary SQL statement
	 */
	public ArrEnfAct[] findByDynamicSelect(String sql, Object[] sqlParams) throws ArrEnfActDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			throw new ArrEnfActDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns all rows from the ARR_ENF_ACT table that match the specified arbitrary SQL statement
	 */
	public ArrEnfAct[] findByDynamicWhere(String sql, Object[] sqlParams) throws ArrEnfActDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ ) {
				stmt.setObject( i+1, sqlParams[i] );
			}
		
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception _e) {
			throw new ArrEnfActDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

}

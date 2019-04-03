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

public class ArrDatosMesDaoImpl extends AbstractDAO implements ArrDatosMesDao
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
	protected final String SQL_SELECT = "SELECT MES, ANIO, MESASMES, MESASTOT, RIEMES, RIETOT FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( MES, ANIO, MESASMES, MESASTOT, RIEMES, RIETOT ) VALUES ( ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET MES = ?, ANIO = ?, MESASMES = ?, MESASTOT = ?, RIEMES = ?, RIETOT = ? WHERE MES = ? AND ANIO = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE MES = ? AND ANIO = ?";

	/** 
	 * Index of column MES
	 */
	protected static final int COLUMN_MES = 1;

	/** 
	 * Index of column ANIO
	 */
	protected static final int COLUMN_ANIO = 2;

	/** 
	 * Index of column MESASMES
	 */
	protected static final int COLUMN_MESASMES = 3;

	/** 
	 * Index of column MESASTOT
	 */
	protected static final int COLUMN_MESASTOT = 4;

	/** 
	 * Index of column RIEMES
	 */
	protected static final int COLUMN_RIEMES = 5;

	/** 
	 * Index of column RIETOT
	 */
	protected static final int COLUMN_RIETOT = 6;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 6;

	/** 
	 * Index of primary-key column MES
	 */
	protected static final int PK_COLUMN_MES = 1;

	/** 
	 * Index of primary-key column ANIO
	 */
	protected static final int PK_COLUMN_ANIO = 2;

	/** 
	 * Inserts a new row in the ARR_DATOS_MES table.
	 */
	public ArrDatosMesPk insert(ArrDatosMes dto) throws ArrDatosMesDaoException
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
			stmt.setString( index++, dto.getMes() );
			if (dto.getAnio() != null) {
				stmt.setInt( index++, dto.getAnio().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getMesasmes() );
			stmt.setString( index++, dto.getMesastot() );
			stmt.setString( index++, dto.getRiemes() );
			stmt.setString( index++, dto.getRietot() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			throw new ArrDatosMesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the ARR_DATOS_MES table.
	 */
	public void update(ArrDatosMesPk pk, ArrDatosMes dto) throws ArrDatosMesDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			stmt.setString( index++, dto.getMes() );
			if (dto.getAnio() != null) {
				stmt.setInt( index++, dto.getAnio().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getMesasmes() );
			stmt.setString( index++, dto.getMesastot() );
			stmt.setString( index++, dto.getRiemes() );
			stmt.setString( index++, dto.getRietot() );
			stmt.setString( 7, pk.getMes() );
			if (pk.getAnio() != null) {
				stmt.setInt( 8, pk.getAnio().intValue() );
			} else {
				stmt.setNull(8, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new ArrDatosMesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the ARR_DATOS_MES table.
	 */
	public void delete(ArrDatosMesPk pk) throws ArrDatosMesDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_DELETE );
			stmt.setString( 1, pk.getMes() );
			if (pk.getAnio() != null) {
				stmt.setInt( 2, pk.getAnio().intValue() );
			} else {
				stmt.setNull(2, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new ArrDatosMesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the ARR_DATOS_MES table that matches the specified primary-key value.
	 */
	public ArrDatosMes findByPrimaryKey(ArrDatosMesPk pk) throws ArrDatosMesDaoException
	{
		return findByPrimaryKey( pk.getMes(), pk.getAnio() );
	}

	/** 
	 * Returns all rows from the ARR_DATOS_MES table that match the criteria 'MES = :mes AND ANIO = :anio'.
	 */
	public ArrDatosMes findByPrimaryKey(String mes, Integer anio) throws ArrDatosMesDaoException
	{
		ArrDatosMes ret[] = findByDynamicSelect( SQL_SELECT + " WHERE MES = ? AND ANIO = ?", new Object[] { mes, anio } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the ARR_DATOS_MES table that match the criteria ''.
	 */
	public ArrDatosMes[] findAll() throws ArrDatosMesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY MES, ANIO", null );
	}

	/** 
	 * Returns all rows from the ARR_DATOS_MES table that match the criteria 'MES = :mes'.
	 */
	public ArrDatosMes[] findWhereMesEquals(String mes) throws ArrDatosMesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE MES = ? ORDER BY MES", new Object[] { mes } );
	}

	/** 
	 * Returns all rows from the ARR_DATOS_MES table that match the criteria 'ANIO = :anio'.
	 */
	public ArrDatosMes[] findWhereAnioEquals(long anio) throws ArrDatosMesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ANIO = ? ORDER BY ANIO", new Object[] {  new Long(anio) } );
	}

	/** 
	 * Returns all rows from the ARR_DATOS_MES table that match the criteria 'MESASMES = :mesasmes'.
	 */
	public ArrDatosMes[] findWhereMesasmesEquals(String mesasmes) throws ArrDatosMesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE MESASMES = ? ORDER BY MESASMES", new Object[] { mesasmes } );
	}

	/** 
	 * Returns all rows from the ARR_DATOS_MES table that match the criteria 'MESASTOT = :mesastot'.
	 */
	public ArrDatosMes[] findWhereMesastotEquals(String mesastot) throws ArrDatosMesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE MESASTOT = ? ORDER BY MESASTOT", new Object[] { mesastot } );
	}

	/** 
	 * Returns all rows from the ARR_DATOS_MES table that match the criteria 'RIEMES = :riemes'.
	 */
	public ArrDatosMes[] findWhereRiemesEquals(String riemes) throws ArrDatosMesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE RIEMES = ? ORDER BY RIEMES", new Object[] { riemes } );
	}

	/** 
	 * Returns all rows from the ARR_DATOS_MES table that match the criteria 'RIETOT = :rietot'.
	 */
	public ArrDatosMes[] findWhereRietotEquals(String rietot) throws ArrDatosMesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE RIETOT = ? ORDER BY RIETOT", new Object[] { rietot } );
	}

	/**
	 * Method 'ArrDatosMesDaoImpl'
	 * 
	 */
	public ArrDatosMesDaoImpl()
	{
	}

	/**
	 * Method 'ArrDatosMesDaoImpl'
	 * 
	 * @param userConn
	 */
	public ArrDatosMesDaoImpl(final java.sql.Connection userConn)
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
		//return "idea.ARR_DATOS_MES";
		return "idea.arr_datos_mes";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ArrDatosMes fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ArrDatosMes dto = new ArrDatosMes();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ArrDatosMes[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ArrDatosMes dto = new ArrDatosMes();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ArrDatosMes ret[] = new ArrDatosMes[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ArrDatosMes dto, ResultSet rs) throws SQLException
	{
		dto.setMes( rs.getString( COLUMN_MES ) );
		dto.setAnio( new Integer( rs.getInt(COLUMN_ANIO) ) );
		dto.setMesasmes( rs.getString( COLUMN_MESASMES ) );
		dto.setMesastot( rs.getString( COLUMN_MESASTOT ) );
		dto.setRiemes( rs.getString( COLUMN_RIEMES ) );
		dto.setRietot( rs.getString( COLUMN_RIETOT ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ArrDatosMes dto)
	{
	}

	/** 
	 * Returns all rows from the ARR_DATOS_MES table that match the specified arbitrary SQL statement
	 */
	public ArrDatosMes[] findByDynamicSelect(String sql, Object[] sqlParams) throws ArrDatosMesDaoException
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
			throw new ArrDatosMesDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the ARR_DATOS_MES table that match the specified arbitrary SQL statement
	 */
	public ArrDatosMes[] findByDynamicWhere(String sql, Object[] sqlParams) throws ArrDatosMesDaoException
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
			throw new ArrDatosMesDaoException( "Exception: " + _e.getMessage(), _e );
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

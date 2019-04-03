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

public class ArrEstudioPopDaoImpl extends AbstractDAO implements ArrEstudioPopDao
{
	private AuditoriaDao auditoriaDao = new AuditoriaDao();
    private AuditoriaDto auditoriaDto = null;
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
	protected final String SQL_SELECT = "SELECT IDESTUDIO, IDOPERADOR FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDESTUDIO, IDOPERADOR ) VALUES ( ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDESTUDIO = ?, IDOPERADOR = ? WHERE IDESTUDIO = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDESTUDIO = ?";

	/** 
	 * Index of column IDESTUDIO
	 */
	protected static final int COLUMN_IDESTUDIO = 1;

	/** 
	 * Index of column IDOPERADOR
	 */
	protected static final int COLUMN_IDOPERADOR = 2;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 2;

	/** 
	 * Index of primary-key column IDESTUDIO
	 */
	protected static final int PK_COLUMN_IDESTUDIO = 1;

	/** 
	 * Inserts a new row in the ARR_ESTUDIO_POP table.
	 */
	public ArrEstudioPopPk insert(ArrEstudioPop dto) throws ArrEstudioPopDaoException
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
			if (dto.getIdestudio() != null) {
				stmt.setInt( index++, dto.getIdestudio().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getIdoperador() );
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			auditoriaDto.setAccion(AuditoriaDto.insercion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			throw new ArrEstudioPopDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the ARR_ESTUDIO_POP table.
	 */
	public void update(ArrEstudioPopPk pk, ArrEstudioPop dto) throws ArrEstudioPopDaoException
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
			if (dto.getIdestudio() != null) {
				stmt.setInt( index++, dto.getIdestudio().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getIdoperador());
		
			if (pk.getIdestudio() != null) {
				stmt.setInt( 3, pk.getIdestudio().intValue() );
			} else {
				stmt.setNull(3, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			auditoriaDto.setAccion(AuditoriaDto.modificacion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new ArrEstudioPopDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the ARR_ESTUDIO_POP table.
	 */
	public void delete(ArrEstudioPopPk pk) throws ArrEstudioPopDaoException
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
			if (pk.getIdestudio() != null) {
				stmt.setInt( 1, pk.getIdestudio().intValue() );
			} else {
				stmt.setNull(1, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			auditoriaDto.setAccion(AuditoriaDto.borrado);
	        auditoriaDto.setDescri(pk.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new ArrEstudioPopDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the ARR_ESTUDIO_POP table that matches the specified primary-key value.
	 */
	public ArrEstudioPop findByPrimaryKey(ArrEstudioPopPk pk) throws ArrEstudioPopDaoException
	{
		return findByPrimaryKey( pk.getIdestudio() );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_POP table that match the criteria 'IDESTUDIO = :idestudio'.
	 */
	public ArrEstudioPop findByPrimaryKey(Integer idestudio) throws ArrEstudioPopDaoException
	{
		ArrEstudioPop ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDESTUDIO = ?", new Object[] { idestudio } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_POP table that match the criteria ''.
	 */
	public ArrEstudioPop[] findAll() throws ArrEstudioPopDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDESTUDIO", null );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_POP table that match the criteria 'IDESTUDIO = :idestudio'.
	 */
	public ArrEstudioPop[] findWhereIdestudioEquals(long idestudio) throws ArrEstudioPopDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDESTUDIO = ? ORDER BY IDESTUDIO", new Object[] {  new Long(idestudio) } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_POP table that match the criteria 'IDOPERADOR = :idoperador'.
	 */
	public ArrEstudioPop[] findWhereIdoperadorEquals(long idoperador) throws ArrEstudioPopDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDOPERADOR = ? ORDER BY IDOPERADOR", new Object[] {  new Long(idoperador) } );
	}

	/**
	 * Method 'ArrEstudioPopDaoImpl'
	 * 
	 */
	public ArrEstudioPopDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public ArrEstudioPopDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}

	/**
	 * Method 'ArrEstudioPopDaoImpl'
	 * 
	 * @param userConn
	 */
	public ArrEstudioPopDaoImpl(final java.sql.Connection userConn)
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
		//return "idea.ARR_ESTUDIO_POP";
		return "idea.arr_estudio_pop";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ArrEstudioPop fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ArrEstudioPop dto = new ArrEstudioPop();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ArrEstudioPop[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ArrEstudioPop dto = new ArrEstudioPop();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ArrEstudioPop ret[] = new ArrEstudioPop[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ArrEstudioPop dto, ResultSet rs) throws SQLException
	{
		dto.setIdestudio( new Integer( rs.getInt(COLUMN_IDESTUDIO) ) );
		dto.setIdoperador( rs.getString(COLUMN_IDOPERADOR) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ArrEstudioPop dto)
	{
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_POP table that match the specified arbitrary SQL statement
	 */
	public ArrEstudioPop[] findByDynamicSelect(String sql, Object[] sqlParams) throws ArrEstudioPopDaoException
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
			throw new ArrEstudioPopDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the ARR_ESTUDIO_POP table that match the specified arbitrary SQL statement
	 */
	public ArrEstudioPop[] findByDynamicWhere(String sql, Object[] sqlParams) throws ArrEstudioPopDaoException
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
			throw new ArrEstudioPopDaoException( "Exception: " + _e.getMessage(), _e );
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

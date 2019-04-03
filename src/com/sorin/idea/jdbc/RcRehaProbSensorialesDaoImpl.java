/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import com.sorin.idea.dao.RcRehaProbSensorialesDao;
import com.sorin.idea.dto.RcRehaProbSensoriales;
import com.sorin.idea.dto.RcRehaProbSensorialesPk;
import com.sorin.idea.exceptions.RcRehaProbSensorialesDaoException;

public class RcRehaProbSensorialesDaoImpl extends AbstractDAO implements RcRehaProbSensorialesDao
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
	protected final String SQL_SELECT = "SELECT ID_PROBLEMA_SENSORIAL, NOMBRE_PROBLEMA FROM " + getTableName() + "";

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT_INNER_JOIN = "SELECT " + getTableName() + ".ID_PROBLEMA_SENSORIAL, " + getTableName() + ".NOMBRE_PROBLEMA FROM " + getTableName() + "";

	
	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( ID_PROBLEMA_SENSORIAL, NOMBRE_PROBLEMA ) VALUES ( ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET ID_PROBLEMA_SENSORIAL = ?, NOMBRE_PROBLEMA = ? WHERE ID_PROBLEMA_SENSORIAL = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE ID_PROBLEMA_SENSORIAL = ?";

	/** 
	 * Index of column ID_PROBLEMA_SENSORIAL
	 */
	protected static final int COLUMN_ID_PROBLEMA_SENSORIAL = 1;

	/** 
	 * Index of column NOMBRE_PROBLEMA
	 */
	protected static final int COLUMN_NOMBRE_PROBLEMA = 2;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 2;

	/** 
	 * Index of primary-key column ID_PROBLEMA_SENSORIAL
	 */
	protected static final int PK_COLUMN_ID_PROBLEMA_SENSORIAL = 1;

	/** 
	 * Inserts a new row in the RC_REHA_PROB_SENSORIALES table.
	 */
	public RcRehaProbSensorialesPk insert(RcRehaProbSensoriales dto) throws RcRehaProbSensorialesDaoException
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
		
			StringBuffer sql = new StringBuffer();
			StringBuffer values = new StringBuffer();
			sql.append( "INSERT INTO " + getTableName() + " (" );
			int modifiedCount = 0;
			if (dto.isIdProblemaSensorialModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "ID_PROBLEMA_SENSORIAL" );
				values.append( "?" );
				modifiedCount++;
			}
		
			if (dto.isNombreProblemaModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "NOMBRE_PROBLEMA" );
				values.append( "?" );
				modifiedCount++;
			}
		
			if (modifiedCount==0) {
				// nothing to insert
				throw new IllegalStateException( "Nothing to insert" );
			}
		
			sql.append( ") VALUES (" );
			sql.append( values );
			sql.append( ")" );
			stmt = conn.prepareStatement( sql.toString() );
			int index = 1;
			if (dto.isIdProblemaSensorialModified()) {
				stmt.setLong( index++, dto.getIdProblemaSensorial() );
			}
		
			if (dto.isNombreProblemaModified()) {
				stmt.setString( index++, dto.getNombreProblema() );
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			throw new RcRehaProbSensorialesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the RC_REHA_PROB_SENSORIALES table.
	 */
	public void update(RcRehaProbSensorialesPk pk, RcRehaProbSensoriales dto) throws RcRehaProbSensorialesDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			StringBuffer sql = new StringBuffer();
			sql.append( "UPDATE " + getTableName() + " SET " );
			boolean modified = false;
			if (dto.isIdProblemaSensorialModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "ID_PROBLEMA_SENSORIAL=?" );
				modified=true;
			}
		
			if (dto.isNombreProblemaModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "NOMBRE_PROBLEMA=?" );
				modified=true;
			}
		
			if (!modified) {
				// nothing to update
				return;
			}
		
			sql.append( " WHERE ID_PROBLEMA_SENSORIAL=?" );
			stmt = conn.prepareStatement( sql.toString() );
			int index = 1;
			if (dto.isIdProblemaSensorialModified()) {
				stmt.setLong( index++, dto.getIdProblemaSensorial() );
			}
		
			if (dto.isNombreProblemaModified()) {
				stmt.setString( index++, dto.getNombreProblema() );
			}
		
			stmt.setLong( index++, pk.getIdProblemaSensorial() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new RcRehaProbSensorialesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the RC_REHA_PROB_SENSORIALES table.
	 */
	public void delete(RcRehaProbSensorialesPk pk) throws RcRehaProbSensorialesDaoException
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
			stmt.setLong( 1, pk.getIdProblemaSensorial() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new RcRehaProbSensorialesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the RC_REHA_PROB_SENSORIALES table that matches the specified primary-key value.
	 */
	public RcRehaProbSensoriales findByPrimaryKey(RcRehaProbSensorialesPk pk) throws RcRehaProbSensorialesDaoException
	{
		return findByPrimaryKey( pk.getIdProblemaSensorial() );
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_SENSORIALES table that match the criteria 'ID_PROBLEMA_SENSORIAL = :idProblemaSensorial'.
	 */
	public RcRehaProbSensoriales findByPrimaryKey(long idProblemaSensorial) throws RcRehaProbSensorialesDaoException
	{
		RcRehaProbSensoriales ret[] = findByDynamicSelect( SQL_SELECT + " WHERE ID_PROBLEMA_SENSORIAL = ?", new Object[] {  new Long(idProblemaSensorial) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_SENSORIALES table that match the criteria ''.
	 */
	public RcRehaProbSensoriales[] findAll() throws RcRehaProbSensorialesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY ID_PROBLEMA_SENSORIAL", null );
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_SENSORIALES table that match the criteria 'ID_PROBLEMA_SENSORIAL = :idProblemaSensorial'.
	 */
	public RcRehaProbSensoriales[] findWhereIdProblemaSensorialEquals(long idProblemaSensorial) throws RcRehaProbSensorialesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_PROBLEMA_SENSORIAL = ? ORDER BY ID_PROBLEMA_SENSORIAL", new Object[] {  new Long(idProblemaSensorial) } );
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_SENSORIALES table that match the criteria 'NOMBRE_PROBLEMA = :nombreProblema'.
	 */
	public RcRehaProbSensoriales[] findWhereNombreProblemaEquals(String nombreProblema) throws RcRehaProbSensorialesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE NOMBRE_PROBLEMA = ? ORDER BY NOMBRE_PROBLEMA", new Object[] { nombreProblema } );
	}

	/**
	 * Method 'RcRehaProbSensorialesDaoImpl'
	 * 
	 */
	public RcRehaProbSensorialesDaoImpl()
	{
	}

	/**
	 * Method 'RcRehaProbSensorialesDaoImpl'
	 * 
	 * @param userConn
	 */
	public RcRehaProbSensorialesDaoImpl(final java.sql.Connection userConn)
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
		return "IDEA.RC_REHA_PROB_SENSORIALES";
	}
	
	/**
	 * Method 'getTableNameInnerJoin'
	 * 
	 * @return String
	 */
	public String getTableNameInnerJoin()
	{
		return "IDEA.RC_REHABILITADOR";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected RcRehaProbSensoriales fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			RcRehaProbSensoriales dto = new RcRehaProbSensoriales();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected RcRehaProbSensoriales[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			RcRehaProbSensoriales dto = new RcRehaProbSensoriales();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		RcRehaProbSensoriales ret[] = new RcRehaProbSensoriales[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(RcRehaProbSensoriales dto, ResultSet rs) throws SQLException
	{
		dto.setIdProblemaSensorial( rs.getLong( COLUMN_ID_PROBLEMA_SENSORIAL ) );
		dto.setNombreProblema( rs.getString( COLUMN_NOMBRE_PROBLEMA ) );
		reset(dto);
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(RcRehaProbSensoriales dto)
	{
		dto.setIdProblemaSensorialModified( false );
		dto.setNombreProblemaModified( false );
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_SENSORIALES table that match the specified arbitrary SQL statement
	 */
	public RcRehaProbSensoriales[] findByDynamicSelect(String sql, Object[] sqlParams) throws RcRehaProbSensorialesDaoException
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
			throw new RcRehaProbSensorialesDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the RC_REHA_PROB_SENSORIALES table that match the specified arbitrary SQL statement
	 */
	public RcRehaProbSensoriales[] findByDynamicWhere(String sql, Object[] sqlParams) throws RcRehaProbSensorialesDaoException
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
			throw new RcRehaProbSensorialesDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Metodo que obtiene el objeto RcRehaProbSensoriales a traves del idRehabilitador
	 * 
	 * @param sql
	 * @param sqlParams
	 * @return
	 * @throws RcRehaProbSensorialesDaoException
	 */
	public RcRehaProbSensoriales findByInnerJoinRCRehabilitador( long idRehabilitador ) throws RcRehaProbSensorialesDaoException{
		
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT_INNER_JOIN 
					           + " INNER JOIN " + getTableNameInnerJoin()
					           + " ON " + getTableNameInnerJoin() + ".ID_PROBLEMA_SENSORIAL = " + getTableName() + ".ID_PROBLEMA_SENSORIAL"
					           + " WHERE " + getTableNameInnerJoin() + ".ID_RC_REHABILITADOR =" + idRehabilitador;
		
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchSingleResult(rs);
		}
		catch (Exception _e) {
			throw new RcRehaProbSensorialesDaoException( "Exception: " + _e.getMessage(), _e );
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

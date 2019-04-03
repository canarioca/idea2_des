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

import com.sorin.idea.dao.RcRehaProbArticularesDao;
import com.sorin.idea.dto.RcRehaProbArticulares;
import com.sorin.idea.dto.RcRehaProbArticularesPk;
import com.sorin.idea.exceptions.RcRehaProbArticularesDaoException;
import com.sorin.idea.exceptions.RcRehaProbSensorialesDaoException;

public class RcRehaProbArticularesDaoImpl extends AbstractDAO implements RcRehaProbArticularesDao
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
	protected final String SQL_SELECT = "SELECT ID_PROBLEMA_ARTICULAR, NOMBRE_PROBLEMA FROM " + getTableName() + "";

	
	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT_INNER_JOIN = "SELECT " + getTableName() + ".ID_PROBLEMA_ARTICULAR, " + getTableName() + ".NOMBRE_PROBLEMA FROM " + getTableName() + "";

	
	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( ID_PROBLEMA_ARTICULAR, NOMBRE_PROBLEMA ) VALUES ( ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET ID_PROBLEMA_ARTICULAR = ?, NOMBRE_PROBLEMA = ? WHERE ID_PROBLEMA_ARTICULAR = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE ID_PROBLEMA_ARTICULAR = ?";

	/** 
	 * Index of column ID_PROBLEMA_ARTICULAR
	 */
	protected static final int COLUMN_ID_PROBLEMA_ARTICULAR = 1;

	/** 
	 * Index of column NOMBRE_PROBLEMA
	 */
	protected static final int COLUMN_NOMBRE_PROBLEMA = 2;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 2;

	/** 
	 * Index of primary-key column ID_PROBLEMA_ARTICULAR
	 */
	protected static final int PK_COLUMN_ID_PROBLEMA_ARTICULAR = 1;

	/** 
	 * Inserts a new row in the RC_REHA_PROB_ARTICULARES table.
	 */
	public RcRehaProbArticularesPk insert(RcRehaProbArticulares dto) throws RcRehaProbArticularesDaoException
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
			if (dto.isIdProblemaArticularModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "ID_PROBLEMA_ARTICULAR" );
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
			if (dto.isIdProblemaArticularModified()) {
				stmt.setLong( index++, dto.getIdProblemaArticular() );
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
			throw new RcRehaProbArticularesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the RC_REHA_PROB_ARTICULARES table.
	 */
	public void update(RcRehaProbArticularesPk pk, RcRehaProbArticulares dto) throws RcRehaProbArticularesDaoException
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
			if (dto.isIdProblemaArticularModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "ID_PROBLEMA_ARTICULAR=?" );
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
		
			sql.append( " WHERE ID_PROBLEMA_ARTICULAR=?" );
			stmt = conn.prepareStatement( sql.toString() );
			int index = 1;
			if (dto.isIdProblemaArticularModified()) {
				stmt.setLong( index++, dto.getIdProblemaArticular() );
			}
		
			if (dto.isNombreProblemaModified()) {
				stmt.setString( index++, dto.getNombreProblema() );
			}
		
			stmt.setLong( index++, pk.getIdProblemaArticular() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new RcRehaProbArticularesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the RC_REHA_PROB_ARTICULARES table.
	 */
	public void delete(RcRehaProbArticularesPk pk) throws RcRehaProbArticularesDaoException
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
			stmt.setLong( 1, pk.getIdProblemaArticular() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new RcRehaProbArticularesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the RC_REHA_PROB_ARTICULARES table that matches the specified primary-key value.
	 */
	public RcRehaProbArticulares findByPrimaryKey(RcRehaProbArticularesPk pk) throws RcRehaProbArticularesDaoException
	{
		return findByPrimaryKey( pk.getIdProblemaArticular() );
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_ARTICULARES table that match the criteria 'ID_PROBLEMA_ARTICULAR = :idProblemaArticular'.
	 */
	public RcRehaProbArticulares findByPrimaryKey(long idProblemaArticular) throws RcRehaProbArticularesDaoException
	{
		RcRehaProbArticulares ret[] = findByDynamicSelect( SQL_SELECT + " WHERE ID_PROBLEMA_ARTICULAR = ?", new Object[] {  new Long(idProblemaArticular) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_ARTICULARES table that match the criteria ''.
	 */
	public RcRehaProbArticulares[] findAll() throws RcRehaProbArticularesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY ID_PROBLEMA_ARTICULAR", null );
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_ARTICULARES table that match the criteria 'ID_PROBLEMA_ARTICULAR = :idProblemaArticular'.
	 */
	public RcRehaProbArticulares[] findWhereIdProblemaArticularEquals(long idProblemaArticular) throws RcRehaProbArticularesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_PROBLEMA_ARTICULAR = ? ORDER BY ID_PROBLEMA_ARTICULAR", new Object[] {  new Long(idProblemaArticular) } );
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_ARTICULARES table that match the criteria 'NOMBRE_PROBLEMA = :nombreProblema'.
	 */
	public RcRehaProbArticulares[] findWhereNombreProblemaEquals(String nombreProblema) throws RcRehaProbArticularesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE NOMBRE_PROBLEMA = ? ORDER BY NOMBRE_PROBLEMA", new Object[] { nombreProblema } );
	}

	/**
	 * Method 'RcRehaProbArticularesDaoImpl'
	 * 
	 */
	public RcRehaProbArticularesDaoImpl()
	{
	}

	/**
	 * Method 'RcRehaProbArticularesDaoImpl'
	 * 
	 * @param userConn
	 */
	public RcRehaProbArticularesDaoImpl(final java.sql.Connection userConn)
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
		return "IDEA.RC_REHA_PROB_ARTICULARES";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected RcRehaProbArticulares fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			RcRehaProbArticulares dto = new RcRehaProbArticulares();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected RcRehaProbArticulares[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			RcRehaProbArticulares dto = new RcRehaProbArticulares();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		RcRehaProbArticulares ret[] = new RcRehaProbArticulares[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(RcRehaProbArticulares dto, ResultSet rs) throws SQLException
	{
		dto.setIdProblemaArticular( rs.getLong( COLUMN_ID_PROBLEMA_ARTICULAR ) );
		dto.setNombreProblema( rs.getString( COLUMN_NOMBRE_PROBLEMA ) );
		reset(dto);
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(RcRehaProbArticulares dto)
	{
		dto.setIdProblemaArticularModified( false );
		dto.setNombreProblemaModified( false );
	}

	/** 
	 * Returns all rows from the RC_REHA_PROB_ARTICULARES table that match the specified arbitrary SQL statement
	 */
	public RcRehaProbArticulares[] findByDynamicSelect(String sql, Object[] sqlParams) throws RcRehaProbArticularesDaoException
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
			throw new RcRehaProbArticularesDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the RC_REHA_PROB_ARTICULARES table that match the specified arbitrary SQL statement
	 */
	public RcRehaProbArticulares[] findByDynamicWhere(String sql, Object[] sqlParams) throws RcRehaProbArticularesDaoException
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
			throw new RcRehaProbArticularesDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Method 'getTableNameInnerJoin'
	 * 
	 * @return String
	 */
	public String getTableNameInnerJoin()
	{
		return "IDEA.RC_REHABILITADOR";
	}
	
	/**
	 * Metodo que obtiene el objeto RcRehaProbSensoriales a traves del idRehabilitador
	 * 
	 * @param sql
	 * @param sqlParams
	 * @return
	 * @throws RcRehaProbSensorialesDaoException
	 */
	public RcRehaProbArticulares findByInnerJoinRCRehabilitador( long idRehabilitador ) throws RcRehaProbArticularesDaoException{
		
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
					           + " ON " + getTableNameInnerJoin() + ".ID_PROBLEMA_ARTICULAR = " + getTableName() + ".ID_PROBLEMA_ARTICULAR"
					           + " WHERE " + getTableNameInnerJoin() + ".ID_RC_REHABILITADOR =" + idRehabilitador;
		
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchSingleResult(rs);
		}
		catch (Exception _e) {
			throw new RcRehaProbArticularesDaoException( "Exception: " + _e.getMessage(), _e );
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
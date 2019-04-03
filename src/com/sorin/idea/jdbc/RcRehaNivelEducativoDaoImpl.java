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

import com.sorin.idea.dao.RcRehaNivelEducativoDao;
import com.sorin.idea.dto.RcRehaNivelEducativo;
import com.sorin.idea.dto.RcRehaNivelEducativoPk;
import com.sorin.idea.exceptions.RcRehaNivelEducativoDaoException;
import com.sorin.idea.exceptions.RcRehaProbSensorialesDaoException;

public class RcRehaNivelEducativoDaoImpl extends AbstractDAO implements RcRehaNivelEducativoDao
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
	protected final String SQL_SELECT = "SELECT ID_NIVEL_EDUCATIVO, NOMBRE_NIVEL FROM " + getTableName() + "";
	
	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT_INNER_JOIN = "SELECT " + getTableName() + ".ID_NIVEL_EDUCATIVO, " + getTableName() + ".NOMBRE_NIVEL FROM " + getTableName() + "";


	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( ID_NIVEL_EDUCATIVO, NOMBRE_NIVEL ) VALUES ( ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET ID_NIVEL_EDUCATIVO = ?, NOMBRE_NIVEL = ? WHERE ID_NIVEL_EDUCATIVO = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE ID_NIVEL_EDUCATIVO = ?";

	/** 
	 * Index of column ID_NIVEL_EDUCATIVO
	 */
	protected static final int COLUMN_ID_NIVEL_EDUCATIVO = 1;

	/** 
	 * Index of column NOMBRE_NIVEL
	 */
	protected static final int COLUMN_NOMBRE_NIVEL = 2;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 2;

	/** 
	 * Index of primary-key column ID_NIVEL_EDUCATIVO
	 */
	protected static final int PK_COLUMN_ID_NIVEL_EDUCATIVO = 1;

	/** 
	 * Inserts a new row in the RC_REHA_NIVEL_EDUCATIVO table.
	 */
	public RcRehaNivelEducativoPk insert(RcRehaNivelEducativo dto) throws RcRehaNivelEducativoDaoException
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
			if (dto.isIdNivelEducativoModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "ID_NIVEL_EDUCATIVO" );
				values.append( "?" );
				modifiedCount++;
			}
		
			if (dto.isNombreNivelModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "NOMBRE_NIVEL" );
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
			if (dto.isIdNivelEducativoModified()) {
				stmt.setLong( index++, dto.getIdNivelEducativo() );
			}
		
			if (dto.isNombreNivelModified()) {
				stmt.setString( index++, dto.getNombreNivel() );
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			throw new RcRehaNivelEducativoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the RC_REHA_NIVEL_EDUCATIVO table.
	 */
	public void update(RcRehaNivelEducativoPk pk, RcRehaNivelEducativo dto) throws RcRehaNivelEducativoDaoException
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
			if (dto.isIdNivelEducativoModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "ID_NIVEL_EDUCATIVO=?" );
				modified=true;
			}
		
			if (dto.isNombreNivelModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "NOMBRE_NIVEL=?" );
				modified=true;
			}
		
			if (!modified) {
				// nothing to update
				return;
			}
		
			sql.append( " WHERE ID_NIVEL_EDUCATIVO=?" );
			stmt = conn.prepareStatement( sql.toString() );
			int index = 1;
			if (dto.isIdNivelEducativoModified()) {
				stmt.setLong( index++, dto.getIdNivelEducativo() );
			}
		
			if (dto.isNombreNivelModified()) {
				stmt.setString( index++, dto.getNombreNivel() );
			}
		
			stmt.setLong( index++, pk.getIdNivelEducativo() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new RcRehaNivelEducativoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the RC_REHA_NIVEL_EDUCATIVO table.
	 */
	public void delete(RcRehaNivelEducativoPk pk) throws RcRehaNivelEducativoDaoException
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
			stmt.setLong( 1, pk.getIdNivelEducativo() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new RcRehaNivelEducativoDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the RC_REHA_NIVEL_EDUCATIVO table that matches the specified primary-key value.
	 */
	public RcRehaNivelEducativo findByPrimaryKey(RcRehaNivelEducativoPk pk) throws RcRehaNivelEducativoDaoException
	{
		return findByPrimaryKey( pk.getIdNivelEducativo() );
	}

	/** 
	 * Returns all rows from the RC_REHA_NIVEL_EDUCATIVO table that match the criteria 'ID_NIVEL_EDUCATIVO = :idNivelEducativo'.
	 */
	public RcRehaNivelEducativo findByPrimaryKey(long idNivelEducativo) throws RcRehaNivelEducativoDaoException
	{
		RcRehaNivelEducativo ret[] = findByDynamicSelect( SQL_SELECT + " WHERE ID_NIVEL_EDUCATIVO = ?", new Object[] {  new Long(idNivelEducativo) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the RC_REHA_NIVEL_EDUCATIVO table that match the criteria ''.
	 */
	public RcRehaNivelEducativo[] findAll() throws RcRehaNivelEducativoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY ID_NIVEL_EDUCATIVO", null );
	}

	/** 
	 * Returns all rows from the RC_REHA_NIVEL_EDUCATIVO table that match the criteria 'ID_NIVEL_EDUCATIVO = :idNivelEducativo'.
	 */
	public RcRehaNivelEducativo[] findWhereIdNivelEducativoEquals(long idNivelEducativo) throws RcRehaNivelEducativoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_NIVEL_EDUCATIVO = ? ORDER BY ID_NIVEL_EDUCATIVO", new Object[] {  new Long(idNivelEducativo) } );
	}

	/** 
	 * Returns all rows from the RC_REHA_NIVEL_EDUCATIVO table that match the criteria 'NOMBRE_NIVEL = :nombreNivel'.
	 */
	public RcRehaNivelEducativo[] findWhereNombreNivelEquals(String nombreNivel) throws RcRehaNivelEducativoDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE NOMBRE_NIVEL = ? ORDER BY NOMBRE_NIVEL", new Object[] { nombreNivel } );
	}

	/**
	 * Method 'RcRehaNivelEducativoDaoImpl'
	 * 
	 */
	public RcRehaNivelEducativoDaoImpl()
	{
	}

	/**
	 * Method 'RcRehaNivelEducativoDaoImpl'
	 * 
	 * @param userConn
	 */
	public RcRehaNivelEducativoDaoImpl(final java.sql.Connection userConn)
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
		return "IDEA.RC_REHA_NIVEL_EDUCATIVO";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected RcRehaNivelEducativo fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			RcRehaNivelEducativo dto = new RcRehaNivelEducativo();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected RcRehaNivelEducativo[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			RcRehaNivelEducativo dto = new RcRehaNivelEducativo();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		RcRehaNivelEducativo ret[] = new RcRehaNivelEducativo[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(RcRehaNivelEducativo dto, ResultSet rs) throws SQLException
	{
		dto.setIdNivelEducativo( rs.getLong( COLUMN_ID_NIVEL_EDUCATIVO ) );
		dto.setNombreNivel( rs.getString( COLUMN_NOMBRE_NIVEL ) );
		reset(dto);
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(RcRehaNivelEducativo dto)
	{
		dto.setIdNivelEducativoModified( false );
		dto.setNombreNivelModified( false );
	}

	/** 
	 * Returns all rows from the RC_REHA_NIVEL_EDUCATIVO table that match the specified arbitrary SQL statement
	 */
	public RcRehaNivelEducativo[] findByDynamicSelect(String sql, Object[] sqlParams) throws RcRehaNivelEducativoDaoException
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
			throw new RcRehaNivelEducativoDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the RC_REHA_NIVEL_EDUCATIVO table that match the specified arbitrary SQL statement
	 */
	public RcRehaNivelEducativo[] findByDynamicWhere(String sql, Object[] sqlParams) throws RcRehaNivelEducativoDaoException
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
			throw new RcRehaNivelEducativoDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Metodo que obtiene el objeto RcRehaNivelEducativo a traves del idRehabilitador
	 * 
	 * @param sql
	 * @param sqlParams
	 * @return
	 * @throws RcRehaProbSensorialesDaoException
	 */
	public RcRehaNivelEducativo findByInnerJoinRCRehabilitador( long idRehabilitador ) throws RcRehaNivelEducativoDaoException{
		
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
					           + " ON " + getTableNameInnerJoin() + ".ID_NIVEL_EDUCATIVO = " + getTableName() + ".ID_NIVEL_EDUCATIVO"
					           + " WHERE " + getTableNameInnerJoin() + ".ID_RC_REHABILITADOR =" + idRehabilitador;
		
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchSingleResult(rs);
		}
		catch (Exception _e) {
			throw new RcRehaNivelEducativoDaoException( "Exception: " + _e.getMessage(), _e );
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

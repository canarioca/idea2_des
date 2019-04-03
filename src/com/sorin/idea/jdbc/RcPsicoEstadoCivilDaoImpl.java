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

import com.sorin.idea.dao.RcPsicoEstadoCivilDao;
import com.sorin.idea.dto.RcPsicoEstadoCivil;
import com.sorin.idea.dto.RcPsicoEstadoCivilPk;
import com.sorin.idea.exceptions.RcPsicoEstadoCivilDaoException;
import com.sorin.idea.exceptions.RcRehaProbSensorialesDaoException;

public class RcPsicoEstadoCivilDaoImpl extends AbstractDAO implements RcPsicoEstadoCivilDao
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
	protected final String SQL_SELECT = "SELECT ID_ESTADO_CIVIL, ESTADO FROM " + getTableName() + "";
	
	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT_INNER_JOIN = "SELECT " + getTableName() + ".ID_ESTADO_CIVIL, " + getTableName() + ".ESTADO FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( ID_ESTADO_CIVIL, ESTADO ) VALUES ( ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET ID_ESTADO_CIVIL = ?, ESTADO = ? WHERE ID_ESTADO_CIVIL = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE ID_ESTADO_CIVIL = ?";

	/** 
	 * Index of column ID_ESTADO_CIVIL
	 */
	protected static final int COLUMN_ID_ESTADO_CIVIL = 1;

	/** 
	 * Index of column ESTADO
	 */
	protected static final int COLUMN_ESTADO = 2;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 2;

	/** 
	 * Index of primary-key column ID_ESTADO_CIVIL
	 */
	protected static final int PK_COLUMN_ID_ESTADO_CIVIL = 1;

	/** 
	 * Inserts a new row in the RC_PSICO_ESTADO_CIVIL table.
	 */
	public RcPsicoEstadoCivilPk insert(RcPsicoEstadoCivil dto) throws RcPsicoEstadoCivilDaoException
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
			if (dto.isIdEstadoCivilModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "ID_ESTADO_CIVIL" );
				values.append( "?" );
				modifiedCount++;
			}
		
			if (dto.isEstadoModified()) {
				if (modifiedCount>0) {
					sql.append( ", " );
					values.append( ", " );
				}
		
				sql.append( "ESTADO" );
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
			if (dto.isIdEstadoCivilModified()) {
				stmt.setLong( index++, dto.getIdEstadoCivil() );
			}
		
			if (dto.isEstadoModified()) {
				stmt.setString( index++, dto.getEstado() );
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			throw new RcPsicoEstadoCivilDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the RC_PSICO_ESTADO_CIVIL table.
	 */
	public void update(RcPsicoEstadoCivilPk pk, RcPsicoEstadoCivil dto) throws RcPsicoEstadoCivilDaoException
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
			if (dto.isIdEstadoCivilModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "ID_ESTADO_CIVIL=?" );
				modified=true;
			}
		
			if (dto.isEstadoModified()) {
				if (modified) {
					sql.append( ", " );
				}
		
				sql.append( "ESTADO=?" );
				modified=true;
			}
		
			if (!modified) {
				// nothing to update
				return;
			}
		
			sql.append( " WHERE ID_ESTADO_CIVIL=?" );
			stmt = conn.prepareStatement( sql.toString() );
			int index = 1;
			if (dto.isIdEstadoCivilModified()) {
				stmt.setLong( index++, dto.getIdEstadoCivil() );
			}
		
			if (dto.isEstadoModified()) {
				stmt.setString( index++, dto.getEstado() );
			}
		
			stmt.setLong( index++, pk.getIdEstadoCivil() );
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new RcPsicoEstadoCivilDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the RC_PSICO_ESTADO_CIVIL table.
	 */
	public void delete(RcPsicoEstadoCivilPk pk) throws RcPsicoEstadoCivilDaoException
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
			stmt.setLong( 1, pk.getIdEstadoCivil() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new RcPsicoEstadoCivilDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the RC_PSICO_ESTADO_CIVIL table that matches the specified primary-key value.
	 */
	public RcPsicoEstadoCivil findByPrimaryKey(RcPsicoEstadoCivilPk pk) throws RcPsicoEstadoCivilDaoException
	{
		return findByPrimaryKey( pk.getIdEstadoCivil() );
	}

	/** 
	 * Returns all rows from the RC_PSICO_ESTADO_CIVIL table that match the criteria 'ID_ESTADO_CIVIL = :idEstadoCivil'.
	 */
	public RcPsicoEstadoCivil findByPrimaryKey(long idEstadoCivil) throws RcPsicoEstadoCivilDaoException
	{
		RcPsicoEstadoCivil ret[] = findByDynamicSelect( SQL_SELECT + " WHERE ID_ESTADO_CIVIL = ?", new Object[] {  new Long(idEstadoCivil) } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the RC_PSICO_ESTADO_CIVIL table that match the criteria ''.
	 */
	public RcPsicoEstadoCivil[] findAll() throws RcPsicoEstadoCivilDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY ID_ESTADO_CIVIL", null );
	}

	/** 
	 * Returns all rows from the RC_PSICO_ESTADO_CIVIL table that match the criteria 'ID_ESTADO_CIVIL = :idEstadoCivil'.
	 */
	public RcPsicoEstadoCivil[] findWhereIdEstadoCivilEquals(long idEstadoCivil) throws RcPsicoEstadoCivilDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_ESTADO_CIVIL = ? ORDER BY ID_ESTADO_CIVIL", new Object[] {  new Long(idEstadoCivil) } );
	}

	/** 
	 * Returns all rows from the RC_PSICO_ESTADO_CIVIL table that match the criteria 'ESTADO = :estado'.
	 */
	public RcPsicoEstadoCivil[] findWhereEstadoEquals(String estado) throws RcPsicoEstadoCivilDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ESTADO = ? ORDER BY ESTADO", new Object[] { estado } );
	}

	/**
	 * Method 'RcPsicoEstadoCivilDaoImpl'
	 * 
	 */
	public RcPsicoEstadoCivilDaoImpl()
	{
	}

	/**
	 * Method 'RcPsicoEstadoCivilDaoImpl'
	 * 
	 * @param userConn
	 */
	public RcPsicoEstadoCivilDaoImpl(final java.sql.Connection userConn)
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
		return "IDEA.RC_PSICO_ESTADO_CIVIL";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected RcPsicoEstadoCivil fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			RcPsicoEstadoCivil dto = new RcPsicoEstadoCivil();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected RcPsicoEstadoCivil[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			RcPsicoEstadoCivil dto = new RcPsicoEstadoCivil();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		RcPsicoEstadoCivil ret[] = new RcPsicoEstadoCivil[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(RcPsicoEstadoCivil dto, ResultSet rs) throws SQLException
	{
		dto.setIdEstadoCivil( rs.getLong( COLUMN_ID_ESTADO_CIVIL ) );
		dto.setEstado( rs.getString( COLUMN_ESTADO ) );
		reset(dto);
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(RcPsicoEstadoCivil dto)
	{
		dto.setIdEstadoCivilModified( false );
		dto.setEstadoModified( false );
	}

	/** 
	 * Returns all rows from the RC_PSICO_ESTADO_CIVIL table that match the specified arbitrary SQL statement
	 */
	public RcPsicoEstadoCivil[] findByDynamicSelect(String sql, Object[] sqlParams) throws RcPsicoEstadoCivilDaoException
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
			throw new RcPsicoEstadoCivilDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the RC_PSICO_ESTADO_CIVIL table that match the specified arbitrary SQL statement
	 */
	public RcPsicoEstadoCivil[] findByDynamicWhere(String sql, Object[] sqlParams) throws RcPsicoEstadoCivilDaoException
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
			throw new RcPsicoEstadoCivilDaoException( "Exception: " + _e.getMessage(), _e );
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
		return "IDEA.RC_PSICOLOGIA";
	}
	
	/**
	 * Metodo que obtiene el objeto RcRehaNivelEducativo a traves del idRehabilitador
	 * 
	 * @param sql
	 * @param sqlParams
	 * @return
	 * @throws RcRehaProbSensorialesDaoException
	 */
	public RcPsicoEstadoCivil findByInnerJoinRCRehabilitador( long idPsicologia ) throws RcPsicoEstadoCivilDaoException{
		
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
					           + " ON " + getTableNameInnerJoin() + ".ID_ESTADO_CIVIL = " + getTableName() + ".ID_ESTADO_CIVIL"
					           + " WHERE " + getTableNameInnerJoin() + ".ID_RC_PSICOLOGIA =" + idPsicologia;
		
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchSingleResult(rs);
		}
		catch (Exception _e) {
			throw new RcPsicoEstadoCivilDaoException( "Exception: " + _e.getMessage(), _e );
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
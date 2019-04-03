/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.jdbc;

import com.sorin.idea.dao.*;
import com.sorin.idea.factory.*;
import com.sorin.idea.dto.*;
import com.sorin.idea.exceptions.*;
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

public class ArrAblacionComplicaDaoImpl extends AbstractDAO implements ArrAblacionComplicaDao
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
	protected final String SQL_SELECT = "SELECT IDESTUDIO, IDABLACION, IDPROCEDIMIENTO, IDLUGAR, IDCOMPLICACION, IDMUERTE, OTROS, IDCOMPLICACION2, IDCOMPAC FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDESTUDIO, IDABLACION, IDPROCEDIMIENTO, IDLUGAR, IDCOMPLICACION, IDMUERTE, OTROS, IDCOMPLICACION2, IDCOMPAC ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDESTUDIO = ?, IDABLACION = ?, IDPROCEDIMIENTO = ?, IDLUGAR = ?, IDCOMPLICACION = ?, IDMUERTE = ?, OTROS = ?, IDCOMPLICACION2 = ?, IDCOMPAC = ? WHERE IDESTUDIO = ? AND IDABLACION = ? AND IDCOMPLICACION = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDESTUDIO = ? AND IDABLACION = ? AND IDCOMPLICACION = ?";
	protected final String SQL_DELETE_CHICO = "DELETE FROM " + getTableName() + " WHERE IDESTUDIO = ?";

	/** 
	 * Index of column IDESTUDIO
	 */
	protected static final int COLUMN_IDESTUDIO = 1;

	/** 
	 * Index of column IDABLACION
	 */
	protected static final int COLUMN_IDABLACION = 2;

	/** 
	 * Index of column IDPROCEDIMIENTO
	 */
	protected static final int COLUMN_IDPROCEDIMIENTO = 3;

	/** 
	 * Index of column IDLUGAR
	 */
	protected static final int COLUMN_IDLUGAR = 4;

	/** 
	 * Index of column IDCOMPLICACION
	 */
	protected static final int COLUMN_IDCOMPLICACION = 5;

	/** 
	 * Index of column IDMUERTE
	 */
	protected static final int COLUMN_IDMUERTE = 6;

	/** 
	 * Index of column OTROS
	 */
	protected static final int COLUMN_OTROS = 7;

	/** 
	 * Index of column IDCOMPLICACION2
	 */
	protected static final int COLUMN_IDCOMPLICACION2 = 8;

	/** 
	 * Index of column IDCOMPAC
	 */
	protected static final int COLUMN_IDCOMPAC = 9;
	
	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 9;

	/** 
	 * Index of primary-key column IDESTUDIO
	 */
	protected static final int PK_COLUMN_IDESTUDIO = 1;

	/** 
	 * Index of primary-key column IDABLACION
	 */
	protected static final int PK_COLUMN_IDABLACION = 2;

	/** 
	 * Index of primary-key column IDCOMPLICACION
	 */
	protected static final int PK_COLUMN_IDCOMPLICACION = 3;

	/** 
	 * Inserts a new row in the arr_ablacion_complica table.
	 */
	public ArrAblacionComplicaPk insert(ArrAblacionComplica dto) throws ArrAblacionComplicaDaoException
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
		
			if (dto.getIdablacion() != null) {
				stmt.setInt( index++, dto.getIdablacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdprocedimiento() != null) {
				stmt.setInt( index++, dto.getIdprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdlugar() != null) {
				stmt.setInt( index++, dto.getIdlugar().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdcomplicacion() != null) {
				stmt.setInt( index++, dto.getIdcomplicacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdmuerte() != null) {
				stmt.setInt( index++, dto.getIdmuerte().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getOtros() );
			if (dto.getIdcomplicacion2() != null) {
				stmt.setInt( index++, dto.getIdcomplicacion2().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdcompac() != null) {
				stmt.setInt( index++, dto.getIdcompac().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
			
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			auditoriaDto.setAccion(AuditoriaDto.insercion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ArrAblacionComplicaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the arr_ablacion_complica table.
	 */
	public void update(ArrAblacionComplicaPk pk, ArrAblacionComplica dto) throws ArrAblacionComplicaDaoException
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
		
			if (dto.getIdablacion() != null) {
				stmt.setInt( index++, dto.getIdablacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdprocedimiento() != null) {
				stmt.setInt( index++, dto.getIdprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdlugar() != null) {
				stmt.setInt( index++, dto.getIdlugar().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdcomplicacion() != null) {
				stmt.setInt( index++, dto.getIdcomplicacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdmuerte() != null) {
				stmt.setInt( index++, dto.getIdmuerte().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getOtros() );
			if (dto.getIdcomplicacion2() != null) {
				stmt.setInt( index++, dto.getIdcomplicacion2().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdcompac() != null) {
				stmt.setInt( index++, dto.getIdcompac().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
			
			if (pk.getIdestudio() != null) {
				stmt.setInt( 10, pk.getIdestudio().intValue() );
			} else {
				stmt.setNull(10, java.sql.Types.INTEGER);
			}
		
			if (pk.getIdablacion() != null) {
				stmt.setInt( 11, pk.getIdablacion().intValue() );
			} else {
				stmt.setNull(11, java.sql.Types.INTEGER);
			}
		
			if (pk.getIdcomplicacion() != null) {
				stmt.setInt( 12, pk.getIdcomplicacion().intValue() );
			} else {
				stmt.setNull(12, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			auditoriaDto.setAccion(AuditoriaDto.modificacion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			long t2 = System.currentTimeMillis();
			
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ArrAblacionComplicaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the arr_ablacion_complica table.
	 */
	public void delete(ArrAblacionComplicaPk pk) throws ArrAblacionComplicaDaoException
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
		
			if (pk.getIdablacion() != null) {
				stmt.setInt( 2, pk.getIdablacion().intValue() );
			} else {
				stmt.setNull(2, java.sql.Types.INTEGER);
			}
		
			if (pk.getIdcomplicacion() != null) {
				stmt.setInt( 3, pk.getIdcomplicacion().intValue() );
			} else {
				stmt.setNull(3, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			auditoriaDto.setAccion(AuditoriaDto.borrado);
	        auditoriaDto.setDescri(pk.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ArrAblacionComplicaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	public void delete(Integer idestudio) throws ArrAblacionComplicaDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_DELETE_CHICO );
			if (idestudio != null) {
				stmt.setInt( 1, idestudio.intValue() );
			} else {
				stmt.setNull(1, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new ArrAblacionComplicaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}
	/** 
	 * Returns the rows from the arr_ablacion_complica table that matches the specified primary-key value.
	 */
	public ArrAblacionComplica findByPrimaryKey(ArrAblacionComplicaPk pk) throws ArrAblacionComplicaDaoException
	{
		return findByPrimaryKey( pk.getIdestudio(), pk.getIdablacion(), pk.getIdcomplicacion() );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'IDESTUDIO = :idestudio AND IDABLACION = :idablacion AND IDCOMPLICACION = :idcomplicacion'.
	 */
	public ArrAblacionComplica findByPrimaryKey(Integer idestudio, Integer idablacion, Integer idcomplicacion) throws ArrAblacionComplicaDaoException
	{
		ArrAblacionComplica ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDESTUDIO = ? AND IDABLACION = ? AND IDCOMPLICACION = ?", new Object[] { idestudio, idablacion, idcomplicacion } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria ''.
	 */
	public ArrAblacionComplica[] findAll() throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDESTUDIO, IDABLACION, IDCOMPLICACION", null );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'IDESTUDIO = :idestudio'.
	 */
	public ArrAblacionComplica[] findWhereIdestudioEquals(int idestudio) throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDESTUDIO = ? ORDER BY IDESTUDIO", new Object[] {  new Integer(idestudio) } );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'IDABLACION = :idablacion'.
	 */
	public ArrAblacionComplica[] findWhereIdablacionEquals(int idablacion) throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDABLACION = ? ORDER BY IDABLACION", new Object[] {  new Integer(idablacion) } );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'IDPROCEDIMIENTO = :idprocedimiento'.
	 */
	public ArrAblacionComplica[] findWhereIdprocedimientoEquals(int idprocedimiento) throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDPROCEDIMIENTO = ? ORDER BY IDPROCEDIMIENTO", new Object[] {  new Integer(idprocedimiento) } );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'IDLUGAR = :idlugar'.
	 */
	public ArrAblacionComplica[] findWhereIdlugarEquals(int idlugar) throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDLUGAR = ? ORDER BY IDLUGAR", new Object[] {  new Integer(idlugar) } );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'IDCOMPLICACION = :idcomplicacion'.
	 */
	public ArrAblacionComplica[] findWhereIdcomplicacionEquals(int idcomplicacion) throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDCOMPLICACION = ? ORDER BY IDCOMPLICACION", new Object[] {  new Integer(idcomplicacion) } );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'IDMUERTE = :idmuerte'.
	 */
	public ArrAblacionComplica[] findWhereIdmuerteEquals(int idmuerte) throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDMUERTE = ? ORDER BY IDMUERTE", new Object[] {  new Integer(idmuerte) } );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'OTROS = :otros'.
	 */
	public ArrAblacionComplica[] findWhereOtrosEquals(String otros) throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE OTROS = ? ORDER BY OTROS", new Object[] { otros } );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'IDCOMPLICACION2 = :idcomplicacion2'.
	 */
	public ArrAblacionComplica[] findWhereIdcomplicacion2Equals(int idcomplicacion2) throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDCOMPLICACION2 = ? ORDER BY IDCOMPLICACION2", new Object[] {  new Integer(idcomplicacion2) } );
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the criteria 'IDCOMPAC = :idcompac'.
	 */
	public ArrAblacionComplica[] findWhereIdcompacEquals(int idcompac) throws ArrAblacionComplicaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDCOMPAC = ? ORDER BY IDCOMPAC", new Object[] {  new Integer(idcompac) } );
	}
	
	/**
	 * Method 'ArrAblacionComplicaDaoImpl'
	 * 
	 */
	public ArrAblacionComplicaDaoImpl()
	{
	}

	public ArrAblacionComplicaDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public ArrAblacionComplicaDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	/**
	 * Method 'ArrAblacionComplicaDaoImpl'
	 * 
	 * @param userConn
	 */
	public ArrAblacionComplicaDaoImpl(final java.sql.Connection userConn)
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
		return "idea.arr_ablacion_complica";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ArrAblacionComplica fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ArrAblacionComplica dto = new ArrAblacionComplica();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ArrAblacionComplica[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ArrAblacionComplica dto = new ArrAblacionComplica();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ArrAblacionComplica ret[] = new ArrAblacionComplica[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ArrAblacionComplica dto, ResultSet rs) throws SQLException
	{
		dto.setIdestudio( new Integer( rs.getInt(COLUMN_IDESTUDIO) ) );
		dto.setIdablacion( new Integer( rs.getInt(COLUMN_IDABLACION) ) );
		dto.setIdprocedimiento( new Integer( rs.getInt(COLUMN_IDPROCEDIMIENTO) ) );
		if (rs.wasNull()) {
			dto.setIdprocedimiento( null );
		}
		
		dto.setIdlugar( new Integer( rs.getInt(COLUMN_IDLUGAR) ) );
		if (rs.wasNull()) {
			dto.setIdlugar( null );
		}
		
		dto.setIdcomplicacion( new Integer( rs.getInt(COLUMN_IDCOMPLICACION) ) );
		dto.setIdmuerte( new Integer( rs.getInt(COLUMN_IDMUERTE) ) );
		if (rs.wasNull()) {
			dto.setIdmuerte( null );
		}
		
		dto.setOtros( rs.getString( COLUMN_OTROS ) );
		dto.setIdcomplicacion2( new Integer( rs.getInt(COLUMN_IDCOMPLICACION2) ) );
		if (rs.wasNull()) {
			dto.setIdcomplicacion2( null );
		}
		dto.setIdcompac( new Integer( rs.getInt(COLUMN_IDCOMPAC) ) );
		if (rs.wasNull()) {
			dto.setIdcompac( null );
		}
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ArrAblacionComplica dto)
	{
	}

	/** 
	 * Returns all rows from the arr_ablacion_complica table that match the specified arbitrary SQL statement
	 */
	public ArrAblacionComplica[] findByDynamicSelect(String sql, Object[] sqlParams) throws ArrAblacionComplicaDaoException
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
			_e.printStackTrace();
			throw new ArrAblacionComplicaDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the arr_ablacion_complica table that match the specified arbitrary SQL statement
	 */
	public ArrAblacionComplica[] findByDynamicWhere(String sql, Object[] sqlParams) throws ArrAblacionComplicaDaoException
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
			_e.printStackTrace();
			throw new ArrAblacionComplicaDaoException( "Exception: " + _e.getMessage(), _e );
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

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

public class SegComplicacionesDaoImpl extends AbstractDAO implements SegComplicacionesDao
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
	protected final String SQL_SELECT = "SELECT IDCOMP, IDSEG, ACTITUD, RESULTADO, OTRA FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDCOMP, IDSEG, ACTITUD, RESULTADO, OTRA ) VALUES ( ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDCOMP = ?, IDSEG = ?, ACTITUD = ?, RESULTADO = ?, OTRA = ? WHERE IDSEG = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDSEG = ?";

	/** 
	 * Index of column IDCOMP
	 */
	protected static final int COLUMN_IDCOMP = 1;

	/** 
	 * Index of column IDSEG
	 */
	protected static final int COLUMN_IDSEG = 2;

	/** 
	 * Index of column ACTITUD
	 */
	protected static final int COLUMN_ACTITUD = 3;

	/** 
	 * Index of column RESULTADO
	 */
	protected static final int COLUMN_RESULTADO = 4;

	/** 
	 * Index of column OTRA
	 */
	protected static final int COLUMN_OTRA = 5;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 5;

	/** 
	 * Index of primary-key column IDCOMP
	 */
	protected static final int PK_COLUMN_IDCOMP = 1;

	/** 
	 * Index of primary-key column IDSEG
	 */
	protected static final int PK_COLUMN_IDSEG = 2;

	/** 
	 * Inserts a new row in the seg_complicaciones table.
	 */
	public SegComplicacionesPk insert(SegComplicaciones dto) throws SegComplicacionesDaoException
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
			if (dto.getIdcomp() != null) {
				stmt.setInt( index++, dto.getIdcomp().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdseg() != null) {
				stmt.setInt( index++, dto.getIdseg().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getActitud() );
			stmt.setString( index++, dto.getResultado() );
			stmt.setString( index++, dto.getOtra() );
			//System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			auditoriaDto.setAccion(AuditoriaDto.insercion);
			auditoriaDto.setDescri(dto.toString());
			auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new SegComplicacionesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the seg_complicaciones table.
	 */
	public void update(SegComplicacionesPk pk, SegComplicaciones dto) throws SegComplicacionesDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			//System.out.println( "Executing " + SQL_UPDATE + " with DTO: " + dto );
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index=1;
			if (dto.getIdcomp() != null) {
				stmt.setInt( index++, dto.getIdcomp().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdseg() != null) {
				stmt.setInt( index++, dto.getIdseg().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getActitud() );
			stmt.setString( index++, dto.getResultado() );
			stmt.setString( index++, dto.getOtra() );
			if (pk.getIdcomp() != null) {
				stmt.setInt( 6, pk.getIdcomp().intValue() );
			} else {
				stmt.setNull(6, java.sql.Types.INTEGER);
			}
		
			if (pk.getIdseg() != null) {
				stmt.setInt( 7, pk.getIdseg().intValue() );
			} else {
				stmt.setNull(7, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			auditoriaDto.setAccion(AuditoriaDto.modificacion);
			auditoriaDto.setDescri(dto.toString());
			auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new SegComplicacionesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the seg_complicaciones table.
	 */
	public void delete(SegComplicacionesPk pk) throws SegComplicacionesDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			//System.out.println( "Executing " + SQL_DELETE + " with PK: " + pk );
			stmt = conn.prepareStatement( SQL_DELETE );
			/*if (pk.getIdcomp() != null) {
				stmt.setInt( 1, pk.getIdcomp().intValue() );
			} else {
				stmt.setNull(1, java.sql.Types.INTEGER);
			}^*/
		
			if (pk.getIdseg() != null) {
				stmt.setInt( 1, pk.getIdseg().intValue() );
			} else {
				stmt.setNull(1, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			auditoriaDto.setAccion(AuditoriaDto.borrado);
			auditoriaDto.setDescri(pk.toString());
			auditoriaDao.escribeAuditoria(auditoriaDto);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new SegComplicacionesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the seg_complicaciones table that matches the specified primary-key value.
	 */
	public SegComplicaciones findByPrimaryKey(SegComplicacionesPk pk) throws SegComplicacionesDaoException
	{
		return findByPrimaryKey( pk.getIdcomp(), pk.getIdseg() );
	}

	/** 
	 * Returns all rows from the seg_complicaciones table that match the criteria 'IDCOMP = :idcomp AND IDSEG = :idseg'.
	 */
	public SegComplicaciones findByPrimaryKey(Integer idcomp, Integer idseg) throws SegComplicacionesDaoException
	{
		SegComplicaciones ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDCOMP = ? AND IDSEG = ?", new Object[] { idcomp, idseg } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the seg_complicaciones table that match the criteria ''.
	 */
	public SegComplicaciones[] findAll() throws SegComplicacionesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDCOMP, IDSEG", null );
	}

	/** 
	 * Returns all rows from the seg_complicaciones table that match the criteria 'IDSEG = :idseg'.
	 */
	public SegComplicaciones[] findBySegSeguimiento(int idseg) throws SegComplicacionesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDSEG = ?", new Object[] {  new Integer(idseg) } );
	}

	/** 
	 * Returns all rows from the seg_complicaciones table that match the criteria 'IDCOMP = :idcomp'.
	 */
	public SegComplicaciones[] findWhereIdcompEquals(int idcomp) throws SegComplicacionesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDCOMP = ? ORDER BY IDCOMP", new Object[] {  new Integer(idcomp) } );
	}

	/** 
	 * Returns all rows from the seg_complicaciones table that match the criteria 'IDSEG = :idseg'.
	 */
	public SegComplicaciones[] findWhereIdsegEquals(int idseg) throws SegComplicacionesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDSEG = ? ORDER BY IDSEG", new Object[] {  new Integer(idseg) } );
	}

	/** 
	 * Returns all rows from the seg_complicaciones table that match the criteria 'ACTITUD = :actitud'.
	 */
	public SegComplicaciones[] findWhereActitudEquals(String actitud) throws SegComplicacionesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ACTITUD = ? ORDER BY ACTITUD", new Object[] { actitud } );
	}

	/** 
	 * Returns all rows from the seg_complicaciones table that match the criteria 'RESULTADO = :resultado'.
	 */
	public SegComplicaciones[] findWhereResultadoEquals(String resultado) throws SegComplicacionesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE RESULTADO = ? ORDER BY RESULTADO", new Object[] { resultado } );
	}

	/** 
	 * Returns all rows from the seg_complicaciones table that match the criteria 'OTRA = :otra'.
	 */
	public SegComplicaciones[] findWhereOtraEquals(String otra) throws SegComplicacionesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE OTRA = ? ORDER BY OTRA", new Object[] { otra } );
	}

	/**
	 * Method 'SegComplicacionesDaoImpl'
	 * 
	 */
	public SegComplicacionesDaoImpl()
	{
	}
	/**
	 * Method 'SegComplicacionesDaoImpl'
	 * 
	 */
	public SegComplicacionesDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public SegComplicacionesDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}

	/**
	 * Method 'SegComplicacionesDaoImpl'
	 * 
	 * @param userConn
	 */
	public SegComplicacionesDaoImpl(final java.sql.Connection userConn)
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
		return "idea.seg_complicaciones";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected SegComplicaciones fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			SegComplicaciones dto = new SegComplicaciones();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected SegComplicaciones[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			SegComplicaciones dto = new SegComplicaciones();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		SegComplicaciones ret[] = new SegComplicaciones[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(SegComplicaciones dto, ResultSet rs) throws SQLException
	{
		dto.setIdcomp( new Integer( rs.getInt(COLUMN_IDCOMP) ) );
		dto.setIdseg( new Integer( rs.getInt(COLUMN_IDSEG) ) );
		dto.setActitud( rs.getString( COLUMN_ACTITUD ) );
		dto.setResultado( rs.getString( COLUMN_RESULTADO ) );
		dto.setOtra( rs.getString( COLUMN_OTRA ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(SegComplicaciones dto)
	{
	}

	/** 
	 * Returns all rows from the seg_complicaciones table that match the specified arbitrary SQL statement
	 */
	public SegComplicaciones[] findByDynamicSelect(String sql, Object[] sqlParams) throws SegComplicacionesDaoException
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
		
		
			//System.out.println( "Executing " + SQL );
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
			throw new SegComplicacionesDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the seg_complicaciones table that match the specified arbitrary SQL statement
	 */
	public SegComplicaciones[] findByDynamicWhere(String sql, Object[] sqlParams) throws SegComplicacionesDaoException
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
		
		
			//System.out.println( "Executing " + SQL );
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
			throw new SegComplicacionesDaoException( "Exception: " + _e.getMessage(), _e );
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
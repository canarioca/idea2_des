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

public class ArrEstudioConduccavDaoImpl extends AbstractDAO implements ArrEstudioConduccavDao
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
	protected final String SQL_SELECT = "SELECT IDESTUDIO, AH, HV, FISIOLOGIA, HV2, COMENTARIOS FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDESTUDIO, AH, HV, FISIOLOGIA, HV2, COMENTARIOS ) VALUES ( ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDESTUDIO = ?, AH = ?, HV = ?, FISIOLOGIA = ?, HV2 = ?, COMENTARIOS = ? WHERE IDESTUDIO = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDESTUDIO = ?";

	/** 
	 * Index of column IDESTUDIO
	 */
	protected static final int COLUMN_IDESTUDIO = 1;

	/** 
	 * Index of column AH
	 */
	protected static final int COLUMN_AH = 2;

	/** 
	 * Index of column HV
	 */
	protected static final int COLUMN_HV = 3;

	/** 
	 * Index of column FISIOLOGIA
	 */
	protected static final int COLUMN_FISIOLOGIA = 4;

	/** 
	 * Index of column HV2
	 */
	protected static final int COLUMN_HV2 = 5;

	/** 
	 * Index of column COMENTARIOS
	 */
	protected static final int COLUMN_COMENTARIOS = 6;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 6;

	/** 
	 * Index of primary-key column IDESTUDIO
	 */
	protected static final int PK_COLUMN_IDESTUDIO = 1;

	/** 
	 * Inserts a new row in the ARR_ESTUDIO_CONDUCCAV table.
	 */
	public ArrEstudioConduccavPk insert(ArrEstudioConduccav dto) throws ArrEstudioConduccavDaoException
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
		
			stmt.setString( index++, dto.getAh() );
			stmt.setString( index++, dto.getHv() );
			if (dto.getFisiologia() != null) {
				stmt.setInt( index++, dto.getFisiologia().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getHv2() != null) {
				stmt.setInt( index++, dto.getHv2().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getComentarios() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			auditoriaDto.setAccion(AuditoriaDto.insercion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			throw new ArrEstudioConduccavDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the ARR_ESTUDIO_CONDUCCAV table.
	 */
	public void update(ArrEstudioConduccavPk pk, ArrEstudioConduccav dto) throws ArrEstudioConduccavDaoException
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
		
			stmt.setString( index++, dto.getAh() );
			stmt.setString( index++, dto.getHv() );
			if (dto.getFisiologia() != null) {
				stmt.setInt( index++, dto.getFisiologia().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getHv2() != null) {
				stmt.setInt( index++, dto.getHv2().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getComentarios() );
			if (pk.getIdestudio() != null) {
				stmt.setInt( 7, pk.getIdestudio().intValue() );
			} else {
				stmt.setNull(7, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			auditoriaDto.setAccion(AuditoriaDto.modificacion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			long t2 = System.currentTimeMillis();
		}
		catch (Exception _e) {
			throw new ArrEstudioConduccavDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the ARR_ESTUDIO_CONDUCCAV table.
	 */
	public void delete(ArrEstudioConduccavPk pk) throws ArrEstudioConduccavDaoException
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
			throw new ArrEstudioConduccavDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the ARR_ESTUDIO_CONDUCCAV table that matches the specified primary-key value.
	 */
	public ArrEstudioConduccav findByPrimaryKey(ArrEstudioConduccavPk pk) throws ArrEstudioConduccavDaoException
	{
		return findByPrimaryKey( pk.getIdestudio() );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the criteria 'IDESTUDIO = :idestudio'.
	 */
	public ArrEstudioConduccav findByPrimaryKey(Integer idestudio) throws ArrEstudioConduccavDaoException
	{
		ArrEstudioConduccav ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDESTUDIO = ?", new Object[] { idestudio } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the criteria ''.
	 */
	public ArrEstudioConduccav[] findAll() throws ArrEstudioConduccavDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDESTUDIO", null );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the criteria 'IDESTUDIO = :idestudio'.
	 */
	public ArrEstudioConduccav[] findWhereIdestudioEquals(long idestudio) throws ArrEstudioConduccavDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDESTUDIO = ? ORDER BY IDESTUDIO", new Object[] {  new Long(idestudio) } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the criteria 'AH = :ah'.
	 */
	public ArrEstudioConduccav[] findWhereAhEquals(String ah) throws ArrEstudioConduccavDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE AH = ? ORDER BY AH", new Object[] { ah } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the criteria 'HV = :hv'.
	 */
	public ArrEstudioConduccav[] findWhereHvEquals(String hv) throws ArrEstudioConduccavDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE HV = ? ORDER BY HV", new Object[] { hv } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the criteria 'FISIOLOGIA = :fisiologia'.
	 */
	public ArrEstudioConduccav[] findWhereFisiologiaEquals(long fisiologia) throws ArrEstudioConduccavDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FISIOLOGIA = ? ORDER BY FISIOLOGIA", new Object[] {  new Long(fisiologia) } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the criteria 'HV2 = :hv2'.
	 */
	public ArrEstudioConduccav[] findWhereHv2Equals(long hv2) throws ArrEstudioConduccavDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE HV2 = ? ORDER BY HV2", new Object[] {  new Long(hv2) } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the criteria 'COMENTARIOS = :comentarios'.
	 */
	public ArrEstudioConduccav[] findWhereComentariosEquals(String comentarios) throws ArrEstudioConduccavDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE COMENTARIOS = ? ORDER BY COMENTARIOS", new Object[] { comentarios } );
	}

	/**
	 * Method 'ArrEstudioConduccavDaoImpl'
	 * 
	 */
	public ArrEstudioConduccavDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public ArrEstudioConduccavDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}

	/**
	 * Method 'ArrEstudioConduccavDaoImpl'
	 * 
	 * @param userConn
	 */
	public ArrEstudioConduccavDaoImpl(final java.sql.Connection userConn)
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
		//return "idea.ARR_ESTUDIO_CONDUCCAV";
		return "idea.arr_estudio_conduccav";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ArrEstudioConduccav fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ArrEstudioConduccav dto = new ArrEstudioConduccav();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ArrEstudioConduccav[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ArrEstudioConduccav dto = new ArrEstudioConduccav();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ArrEstudioConduccav ret[] = new ArrEstudioConduccav[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ArrEstudioConduccav dto, ResultSet rs) throws SQLException
	{
		dto.setIdestudio( new Integer( rs.getInt(COLUMN_IDESTUDIO) ) );
		dto.setAh( rs.getString( COLUMN_AH ) );
		dto.setHv( rs.getString( COLUMN_HV ) );
		dto.setFisiologia( new Integer( rs.getInt(COLUMN_FISIOLOGIA) ) );
		if (rs.wasNull()) {
			dto.setFisiologia( null );
		}
		
		dto.setHv2( new Integer( rs.getInt(COLUMN_HV2) ) );
		if (rs.wasNull()) {
			dto.setHv2( null );
		}
		
		dto.setComentarios( rs.getString( COLUMN_COMENTARIOS ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ArrEstudioConduccav dto)
	{
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the specified arbitrary SQL statement
	 */
	public ArrEstudioConduccav[] findByDynamicSelect(String sql, Object[] sqlParams) throws ArrEstudioConduccavDaoException
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
			throw new ArrEstudioConduccavDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the ARR_ESTUDIO_CONDUCCAV table that match the specified arbitrary SQL statement
	 */
	public ArrEstudioConduccav[] findByDynamicWhere(String sql, Object[] sqlParams) throws ArrEstudioConduccavDaoException
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
			throw new ArrEstudioConduccavDaoException( "Exception: " + _e.getMessage(), _e );
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
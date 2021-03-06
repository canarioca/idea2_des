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

public class ArrEstudioSinusalDaoImpl extends AbstractDAO implements ArrEstudioSinusalDao
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
	protected final String SQL_SELECT = "SELECT IDESTUDIO, CICLO, TRNS, TRNSC, TRT, TCSA, HIPER, FRECATRO, FRECINT, COMENTARIOS, PAUSA FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDESTUDIO, CICLO, TRNS, TRNSC, TRT, TCSA, HIPER, FRECATRO, FRECINT, COMENTARIOS, PAUSA ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDESTUDIO = ?, CICLO = ?, TRNS = ?, TRNSC = ?, TRT = ?, TCSA = ?, HIPER = ?, FRECATRO = ?, FRECINT = ?, COMENTARIOS = ?, PAUSA = ? WHERE IDESTUDIO = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDESTUDIO = ?";

	/** 
	 * Index of column IDESTUDIO
	 */
	protected static final int COLUMN_IDESTUDIO = 1;

	/** 
	 * Index of column CICLO
	 */
	protected static final int COLUMN_CICLO = 2;

	/** 
	 * Index of column TRNS
	 */
	protected static final int COLUMN_TRNS = 3;

	/** 
	 * Index of column TRNSC
	 */
	protected static final int COLUMN_TRNSC = 4;

	/** 
	 * Index of column TRT
	 */
	protected static final int COLUMN_TRT = 5;

	/** 
	 * Index of column TCSA
	 */
	protected static final int COLUMN_TCSA = 6;

	/** 
	 * Index of column HIPER
	 */
	protected static final int COLUMN_HIPER = 7;

	/** 
	 * Index of column FRECATRO
	 */
	protected static final int COLUMN_FRECATRO = 8;

	/** 
	 * Index of column FRECINT
	 */
	protected static final int COLUMN_FRECINT = 9;

	/** 
	 * Index of column COMENTARIOS
	 */
	protected static final int COLUMN_COMENTARIOS = 10;
	
	protected static final int COLUMN_PAUSA = 11;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 11;

	/** 
	 * Index of primary-key column IDESTUDIO
	 */
	protected static final int PK_COLUMN_IDESTUDIO = 1;

	/** 
	 * Inserts a new row in the ARR_ESTUDIO_SINUSAL table.
	 */
	public ArrEstudioSinusalPk insert(ArrEstudioSinusal dto) throws ArrEstudioSinusalDaoException
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
		
			stmt.setString( index++, dto.getCiclo() );
			stmt.setString( index++, dto.getTrns() );
			stmt.setString( index++, dto.getTrnsc() );
			stmt.setString( index++, dto.getTrt() );
			stmt.setString( index++, dto.getTcsa() );
			if (dto.getHiper() != null) {
				stmt.setInt( index++, dto.getHiper().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getFrecatro() );
			stmt.setString( index++, dto.getFrecint() );
			stmt.setString( index++, dto.getComentarios() );
			stmt.setString( index++, dto.getPausa() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			auditoriaDto.setAccion(AuditoriaDto.insercion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			throw new ArrEstudioSinusalDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the ARR_ESTUDIO_SINUSAL table.
	 */
	public void update(ArrEstudioSinusalPk pk, ArrEstudioSinusal dto) throws ArrEstudioSinusalDaoException
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
		
			stmt.setString( index++, dto.getCiclo() );
			stmt.setString( index++, dto.getTrns() );
			stmt.setString( index++, dto.getTrnsc() );
			stmt.setString( index++, dto.getTrt() );
			stmt.setString( index++, dto.getTcsa() );
			if (dto.getHiper() != null) {
				stmt.setInt( index++, dto.getHiper().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getFrecatro() );
			stmt.setString( index++, dto.getFrecint() );
			stmt.setString( index++, dto.getComentarios() );
			stmt.setString( index++, dto.getPausa() );
			if (pk.getIdestudio() != null) {
				stmt.setInt( 12, pk.getIdestudio().intValue() );
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
			throw new ArrEstudioSinusalDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the ARR_ESTUDIO_SINUSAL table.
	 */
	public void delete(ArrEstudioSinusalPk pk) throws ArrEstudioSinusalDaoException
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
			throw new ArrEstudioSinusalDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the ARR_ESTUDIO_SINUSAL table that matches the specified primary-key value.
	 */
	public ArrEstudioSinusal findByPrimaryKey(ArrEstudioSinusalPk pk) throws ArrEstudioSinusalDaoException
	{
		return findByPrimaryKey( pk.getIdestudio() );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'IDESTUDIO = :idestudio'.
	 */
	public ArrEstudioSinusal findByPrimaryKey(Integer idestudio) throws ArrEstudioSinusalDaoException
	{
		ArrEstudioSinusal ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDESTUDIO = ?", new Object[] { idestudio } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria ''.
	 */
	public ArrEstudioSinusal[] findAll() throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDESTUDIO", null );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'IDESTUDIO = :idestudio'.
	 */
	public ArrEstudioSinusal[] findWhereIdestudioEquals(long idestudio) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDESTUDIO = ? ORDER BY IDESTUDIO", new Object[] {  new Long(idestudio) } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'CICLO = :ciclo'.
	 */
	public ArrEstudioSinusal[] findWhereCicloEquals(String ciclo) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE CICLO = ? ORDER BY CICLO", new Object[] { ciclo } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'TRNS = :trns'.
	 */
	public ArrEstudioSinusal[] findWhereTrnsEquals(String trns) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TRNS = ? ORDER BY TRNS", new Object[] { trns } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'TRNSC = :trnsc'.
	 */
	public ArrEstudioSinusal[] findWhereTrnscEquals(String trnsc) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TRNSC = ? ORDER BY TRNSC", new Object[] { trnsc } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'TRT = :trt'.
	 */
	public ArrEstudioSinusal[] findWhereTrtEquals(String trt) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TRT = ? ORDER BY TRT", new Object[] { trt } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'TCSA = :tcsa'.
	 */
	public ArrEstudioSinusal[] findWhereTcsaEquals(String tcsa) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TCSA = ? ORDER BY TCSA", new Object[] { tcsa } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'HIPER = :hiper'.
	 */
	public ArrEstudioSinusal[] findWhereHiperEquals(long hiper) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE HIPER = ? ORDER BY HIPER", new Object[] {  new Long(hiper) } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'FRECATRO = :frecatro'.
	 */
	public ArrEstudioSinusal[] findWhereFrecatroEquals(String frecatro) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FRECATRO = ? ORDER BY FRECATRO", new Object[] { frecatro } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'FRECINT = :frecint'.
	 */
	public ArrEstudioSinusal[] findWhereFrecintEquals(String frecint) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FRECINT = ? ORDER BY FRECINT", new Object[] { frecint } );
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the criteria 'COMENTARIOS = :comentarios'.
	 */
	public ArrEstudioSinusal[] findWhereComentariosEquals(String comentarios) throws ArrEstudioSinusalDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE COMENTARIOS = ? ORDER BY COMENTARIOS", new Object[] { comentarios } );
	}

	/**
	 * Method 'ArrEstudioSinusalDaoImpl'
	 * 
	 */
	public ArrEstudioSinusalDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public ArrEstudioSinusalDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}

	/**
	 * Method 'ArrEstudioSinusalDaoImpl'
	 * 
	 * @param userConn
	 */
	public ArrEstudioSinusalDaoImpl(final java.sql.Connection userConn)
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
		//return "idea.ARR_ESTUDIO_SINUSAL";
		return "idea.arr_estudio_sinusal";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ArrEstudioSinusal fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ArrEstudioSinusal dto = new ArrEstudioSinusal();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ArrEstudioSinusal[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ArrEstudioSinusal dto = new ArrEstudioSinusal();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ArrEstudioSinusal ret[] = new ArrEstudioSinusal[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ArrEstudioSinusal dto, ResultSet rs) throws SQLException
	{
		dto.setIdestudio( new Integer( rs.getInt(COLUMN_IDESTUDIO) ) );
		dto.setCiclo( rs.getString( COLUMN_CICLO ) );
		dto.setTrns( rs.getString( COLUMN_TRNS ) );
		dto.setTrnsc( rs.getString( COLUMN_TRNSC ) );
		dto.setTrt( rs.getString( COLUMN_TRT ) );
		dto.setTcsa( rs.getString( COLUMN_TCSA ) );
		dto.setHiper( new Integer( rs.getInt(COLUMN_HIPER) ) );
		if (rs.wasNull()) {
			dto.setHiper( null );
		}
		
		dto.setFrecatro( rs.getString( COLUMN_FRECATRO ) );
		dto.setFrecint( rs.getString( COLUMN_FRECINT ) );
		dto.setComentarios( rs.getString( COLUMN_COMENTARIOS ) );
		dto.setPausa( rs.getString( COLUMN_PAUSA ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ArrEstudioSinusal dto)
	{
	}

	/** 
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the specified arbitrary SQL statement
	 */
	public ArrEstudioSinusal[] findByDynamicSelect(String sql, Object[] sqlParams) throws ArrEstudioSinusalDaoException
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
			throw new ArrEstudioSinusalDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the ARR_ESTUDIO_SINUSAL table that match the specified arbitrary SQL statement
	 */
	public ArrEstudioSinusal[] findByDynamicWhere(String sql, Object[] sqlParams) throws ArrEstudioSinusalDaoException
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
			throw new ArrEstudioSinusalDaoException( "Exception: " + _e.getMessage(), _e );
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

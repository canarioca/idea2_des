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

public class ImpZonaDaoImpl extends AbstractDAO implements ImpZonaDao
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
	protected final String SQL_SELECT = "SELECT IDZONA, IDEV, TIPO, FC_PPM, FC_MS, NUMCICLOMIN, DURMIN, DISCRIMINACION FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDZONA, IDEV, TIPO, FC_PPM, FC_MS, NUMCICLOMIN, DURMIN, DISCRIMINACION ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDZONA = ?, IDEV = ?, TIPO = ?, FC_PPM = ?, FC_MS = ?, NUMCICLOMIN = ?, DURMIN = ?, DISCRIMINACION = ? WHERE IDZONA = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDZONA = ?";

	/** 
	 * Index of column IDZONA
	 */
	protected static final int COLUMN_IDZONA = 1;

	/** 
	 * Index of column IDEV
	 */
	protected static final int COLUMN_IDEV = 2;

	/** 
	 * Index of column TIPO
	 */
	protected static final int COLUMN_TIPO = 3;

	/** 
	 * Index of column FC_PPM
	 */
	protected static final int COLUMN_FC_PPM = 4;

	/** 
	 * Index of column FC_MS
	 */
	protected static final int COLUMN_FC_MS = 5;

	/** 
	 * Index of column NUMCICLOMIN
	 */
	protected static final int COLUMN_NUMCICLOMIN = 6;

	/** 
	 * Index of column DURMIN
	 */
	protected static final int COLUMN_DURMIN = 7;

	/** 
	 * Index of column DISCRIMINACION
	 */
	protected static final int COLUMN_DISCRIMINACION = 8;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 8;

	/** 
	 * Index of primary-key column IDZONA
	 */
	protected static final int PK_COLUMN_IDZONA = 1;

	/** 
	 * Inserts a new row in the imp_zona table.
	 */
	public ImpZonaPk insert(ImpZona dto) throws ImpZonaDaoException
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
		
			stmt = conn.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			if (dto.getIdzona() != null) {
				stmt.setInt( index++, dto.getIdzona().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdev() != null) {
				stmt.setInt( index++, dto.getIdev().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getTipo() );
			stmt.setString( index++, dto.getFcPpm() );
			stmt.setString( index++, dto.getFcMs() );
			stmt.setString( index++, dto.getNumciclomin() );
			stmt.setString( index++, dto.getDurmin() );
			stmt.setString( index++, dto.getDiscriminacion() );
			//System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdzona( new Integer( rs.getInt(1) ) );
			}
			auditoriaDto.setAccion(AuditoriaDto.insercion);
			auditoriaDto.setDescri(dto.toString());
			auditoriaDao.escribeAuditoria(auditoriaDto);
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ImpZonaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the imp_zona table.
	 */
	public void update(ImpZonaPk pk, ImpZona dto) throws ImpZonaDaoException
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
			if (dto.getIdzona() != null) {
				stmt.setInt( index++, dto.getIdzona().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdev() != null) {
				stmt.setInt( index++, dto.getIdev().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getTipo() );
			stmt.setString( index++, dto.getFcPpm() );
			stmt.setString( index++, dto.getFcMs() );
			stmt.setString( index++, dto.getNumciclomin() );
			stmt.setString( index++, dto.getDurmin() );
			stmt.setString( index++, dto.getDiscriminacion() );
			if (pk.getIdzona() != null) {
				stmt.setInt( 9, pk.getIdzona().intValue() );
			} else {
				stmt.setNull(9, java.sql.Types.INTEGER);
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
			throw new ImpZonaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the imp_zona table.
	 */
	public void delete(ImpZonaPk pk) throws ImpZonaDaoException
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
			if (pk.getIdzona() != null) {
				stmt.setInt( 1, pk.getIdzona().intValue() );
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
			throw new ImpZonaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the imp_zona table that matches the specified primary-key value.
	 */
	public ImpZona findByPrimaryKey(ImpZonaPk pk) throws ImpZonaDaoException
	{
		return findByPrimaryKey( pk.getIdzona() );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'IDZONA = :idzona'.
	 */
	public ImpZona findByPrimaryKey(Integer idzona) throws ImpZonaDaoException
	{
		ImpZona ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDZONA = ?", new Object[] { idzona } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria ''.
	 */
	public ImpZona[] findAll() throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDZONA", null );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'IDEV = :idev'.
	 */
	public ImpZona[] findByImpEvolucion(int idev) throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDEV = ?", new Object[] {  new Integer(idev) } );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'IDZONA = :idzona'.
	 */
	public ImpZona[] findWhereIdzonaEquals(int idzona) throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDZONA = ? ORDER BY IDZONA", new Object[] {  new Integer(idzona) } );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'IDEV = :idev'.
	 */
	public ImpZona[] findWhereIdevEquals(int idev) throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDEV = ? ORDER BY IDEV", new Object[] {  new Integer(idev) } );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'TIPO = :tipo'.
	 */
	public ImpZona[] findWhereTipoEquals(String tipo) throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TIPO = ? ORDER BY TIPO", new Object[] { tipo } );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'FC_PPM = :fcPpm'.
	 */
	public ImpZona[] findWhereFcPpmEquals(String fcPpm) throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FC_PPM = ? ORDER BY FC_PPM", new Object[] { fcPpm } );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'FC_MS = :fcMs'.
	 */
	public ImpZona[] findWhereFcMsEquals(String fcMs) throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FC_MS = ? ORDER BY FC_MS", new Object[] { fcMs } );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'NUMCICLOMIN = :numciclomin'.
	 */
	public ImpZona[] findWhereNumciclominEquals(String numciclomin) throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE NUMCICLOMIN = ? ORDER BY NUMCICLOMIN", new Object[] { numciclomin } );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'DURMIN = :durmin'.
	 */
	public ImpZona[] findWhereDurminEquals(String durmin) throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE DURMIN = ? ORDER BY DURMIN", new Object[] { durmin } );
	}

	/** 
	 * Returns all rows from the imp_zona table that match the criteria 'DISCRIMINACION = :discriminacion'.
	 */
	public ImpZona[] findWhereDiscriminacionEquals(String discriminacion) throws ImpZonaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE DISCRIMINACION = ? ORDER BY DISCRIMINACION", new Object[] { discriminacion } );
	}

	/**
	 * Method 'ImpZonaDaoImpl'
	 * 
	 */
	public ImpZonaDaoImpl()
	{
	}
	/**
	 * Method 'ImpZonaDaoImpl'
	 * 
	 */
	public ImpZonaDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public ImpZonaDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}

	/**
	 * Method 'ImpZonaDaoImpl'
	 * 
	 * @param userConn
	 */
	public ImpZonaDaoImpl(final java.sql.Connection userConn)
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
		return "idea.imp_zona";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ImpZona fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ImpZona dto = new ImpZona();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ImpZona[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ImpZona dto = new ImpZona();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ImpZona ret[] = new ImpZona[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ImpZona dto, ResultSet rs) throws SQLException
	{
		dto.setIdzona( new Integer( rs.getInt(COLUMN_IDZONA) ) );
		dto.setIdev( new Integer( rs.getInt(COLUMN_IDEV) ) );
		dto.setTipo( rs.getString( COLUMN_TIPO ) );
		dto.setFcPpm( rs.getString( COLUMN_FC_PPM ) );
		dto.setFcMs( rs.getString( COLUMN_FC_MS ) );
		dto.setNumciclomin( rs.getString( COLUMN_NUMCICLOMIN ) );
		dto.setDurmin( rs.getString( COLUMN_DURMIN ) );
		dto.setDiscriminacion( rs.getString( COLUMN_DISCRIMINACION ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ImpZona dto)
	{
	}

	/** 
	 * Returns all rows from the imp_zona table that match the specified arbitrary SQL statement
	 */
	public ImpZona[] findByDynamicSelect(String sql, Object[] sqlParams) throws ImpZonaDaoException
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
			throw new ImpZonaDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the imp_zona table that match the specified arbitrary SQL statement
	 */
	public ImpZona[] findByDynamicWhere(String sql, Object[] sqlParams) throws ImpZonaDaoException
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
			throw new ImpZonaDaoException( "Exception: " + _e.getMessage(), _e );
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

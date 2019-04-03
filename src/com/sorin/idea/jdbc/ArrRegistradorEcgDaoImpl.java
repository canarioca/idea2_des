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

public class ArrRegistradorEcgDaoImpl extends AbstractDAO implements ArrRegistradorEcgDao
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
	protected final String SQL_SELECT = "SELECT ID_REGISTRADOR, IDRITMO, IDCONDUCCION, IDCONDUCCIONNO, IDQRS, IDQRSNO, MORFOLOGIA, COMENTARIOS, RR, PR, QRS, QT, QTC FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( ID_REGISTRADOR, IDRITMO, IDCONDUCCION, IDCONDUCCIONNO, IDQRS, IDQRSNO, MORFOLOGIA, COMENTARIOS, RR, PR, QRS, QT, QTC ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET ID_REGISTRADOR = ?, IDRITMO = ?, IDCONDUCCION = ?, IDCONDUCCIONNO = ?, IDQRS = ?, IDQRSNO = ?, MORFOLOGIA = ?, COMENTARIOS = ?, RR = ?, PR = ?, QRS = ?, QT = ?, QTC = ? WHERE ID_REGISTRADOR = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE ID_REGISTRADOR = ?";

	/** 
	 * Index of column ID_REGISTRADOR
	 */
	protected static final int COLUMN_ID_REGISTRADOR = 1;

	/** 
	 * Index of column IDRITMO
	 */
	protected static final int COLUMN_IDRITMO = 2;

	/** 
	 * Index of column IDCONDUCCION
	 */
	protected static final int COLUMN_IDCONDUCCION = 3;

	/** 
	 * Index of column IDCONDUCCIONNO
	 */
	protected static final int COLUMN_IDCONDUCCIONNO = 4;

	/** 
	 * Index of column IDQRS
	 */
	protected static final int COLUMN_IDQRS = 5;

	/** 
	 * Index of column IDQRSNO
	 */
	protected static final int COLUMN_IDQRSNO = 6;

	/** 
	 * Index of column MORFOLOGIA
	 */
	protected static final int COLUMN_MORFOLOGIA = 7;

	/** 
	 * Index of column COMENTARIOS
	 */
	protected static final int COLUMN_COMENTARIOS = 8;

	/** 
	 * Index of column RR
	 */
	protected static final int COLUMN_RR = 9;

	/** 
	 * Index of column PR
	 */
	protected static final int COLUMN_PR = 10;

	/** 
	 * Index of column QRS
	 */
	protected static final int COLUMN_QRS = 11;

	/** 
	 * Index of column QT
	 */
	protected static final int COLUMN_QT = 12;

	/** 
	 * Index of column QTC
	 */
	protected static final int COLUMN_QTC = 13;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 13;

	/** 
	 * Index of primary-key column ID_REGISTRADOR
	 */
	protected static final int PK_COLUMN_ID_REGISTRADOR = 1;

	/** 
	 * Inserts a new row in the arr_registrador_ecg table.
	 */
	public ArrRegistradorEcgPk insert(ArrRegistradorEcg dto) throws ArrRegistradorEcgDaoException
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
			if (dto.getIdRegistrador() != null) {
				stmt.setInt( index++, dto.getIdRegistrador().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdritmo() != null) {
				stmt.setInt( index++, dto.getIdritmo().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdconduccion() != null) {
				stmt.setInt( index++, dto.getIdconduccion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdconduccionno() != null) {
				stmt.setInt( index++, dto.getIdconduccionno().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdqrs() != null) {
				stmt.setInt( index++, dto.getIdqrs().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdqrsno() != null) {
				stmt.setInt( index++, dto.getIdqrsno().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getMorfologia() );
			stmt.setString( index++, dto.getComentarios() );
			stmt.setString( index++, dto.getRr() );
			stmt.setString( index++, dto.getPr() );
			stmt.setString( index++, dto.getQrs() );
			stmt.setString( index++, dto.getQt() );
			stmt.setString( index++, dto.getQtc() );
			//System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ArrRegistradorEcgDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the arr_registrador_ecg table.
	 */
	public void update(ArrRegistradorEcgPk pk, ArrRegistradorEcg dto) throws ArrRegistradorEcgDaoException
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
			if (dto.getIdRegistrador() != null) {
				stmt.setInt( index++, dto.getIdRegistrador().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdritmo() != null) {
				stmt.setInt( index++, dto.getIdritmo().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdconduccion() != null) {
				stmt.setInt( index++, dto.getIdconduccion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdconduccionno() != null) {
				stmt.setInt( index++, dto.getIdconduccionno().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdqrs() != null) {
				stmt.setInt( index++, dto.getIdqrs().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdqrsno() != null) {
				stmt.setInt( index++, dto.getIdqrsno().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getMorfologia() );
			stmt.setString( index++, dto.getComentarios() );
			stmt.setString( index++, dto.getRr() );
			stmt.setString( index++, dto.getPr() );
			stmt.setString( index++, dto.getQrs() );
			stmt.setString( index++, dto.getQt() );
			stmt.setString( index++, dto.getQtc() );
			if (pk.getIdRegistrador() != null) {
				stmt.setInt( 14, pk.getIdRegistrador().intValue() );
			} else {
				stmt.setNull(14, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ArrRegistradorEcgDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the arr_registrador_ecg table.
	 */
	public void delete(ArrRegistradorEcgPk pk) throws ArrRegistradorEcgDaoException
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
			if (pk.getIdRegistrador() != null) {
				stmt.setInt( 1, pk.getIdRegistrador().intValue() );
			} else {
				stmt.setNull(1, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ArrRegistradorEcgDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the arr_registrador_ecg table that matches the specified primary-key value.
	 */
	public ArrRegistradorEcg findByPrimaryKey(ArrRegistradorEcgPk pk) throws ArrRegistradorEcgDaoException
	{
		return findByPrimaryKey( pk.getIdRegistrador() );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'ID_REGISTRADOR = :idRegistrador'.
	 */
	public ArrRegistradorEcg findByPrimaryKey(Integer idRegistrador) throws ArrRegistradorEcgDaoException
	{
		ArrRegistradorEcg ret[] = findByDynamicSelect( SQL_SELECT + " WHERE ID_REGISTRADOR = ?", new Object[] { idRegistrador } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria ''.
	 */
	public ArrRegistradorEcg[] findAll() throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY ID_REGISTRADOR", null );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'ID_REGISTRADOR = :idRegistrador'.
	 */
	public ArrRegistradorEcg[] findByArrRegistrador(Integer idRegistrador) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_REGISTRADOR = ?", new Object[] { idRegistrador } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'ID_REGISTRADOR = :idRegistrador'.
	 */
	public ArrRegistradorEcg[] findWhereIdRegistradorEquals(Integer idRegistrador) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ID_REGISTRADOR = ? ORDER BY ID_REGISTRADOR", new Object[] { idRegistrador } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'IDRITMO = :idritmo'.
	 */
	public ArrRegistradorEcg[] findWhereIdritmoEquals(Integer idritmo) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDRITMO = ? ORDER BY IDRITMO", new Object[] { idritmo } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'IDCONDUCCION = :idconduccion'.
	 */
	public ArrRegistradorEcg[] findWhereIdconduccionEquals(Integer idconduccion) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDCONDUCCION = ? ORDER BY IDCONDUCCION", new Object[] { idconduccion } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'IDCONDUCCIONNO = :idconduccionno'.
	 */
	public ArrRegistradorEcg[] findWhereIdconduccionnoEquals(Integer idconduccionno) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDCONDUCCIONNO = ? ORDER BY IDCONDUCCIONNO", new Object[] { idconduccionno } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'IDQRS = :idqrs'.
	 */
	public ArrRegistradorEcg[] findWhereIdqrsEquals(Integer idqrs) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDQRS = ? ORDER BY IDQRS", new Object[] { idqrs } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'IDQRSNO = :idqrsno'.
	 */
	public ArrRegistradorEcg[] findWhereIdqrsnoEquals(Integer idqrsno) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDQRSNO = ? ORDER BY IDQRSNO", new Object[] { idqrsno } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'MORFOLOGIA = :morfologia'.
	 */
	public ArrRegistradorEcg[] findWhereMorfologiaEquals(String morfologia) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE MORFOLOGIA = ? ORDER BY MORFOLOGIA", new Object[] { morfologia } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'COMENTARIOS = :comentarios'.
	 */
	public ArrRegistradorEcg[] findWhereComentariosEquals(String comentarios) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE COMENTARIOS = ? ORDER BY COMENTARIOS", new Object[] { comentarios } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'RR = :rr'.
	 */
	public ArrRegistradorEcg[] findWhereRrEquals(String rr) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE RR = ? ORDER BY RR", new Object[] { rr } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'PR = :pr'.
	 */
	public ArrRegistradorEcg[] findWherePrEquals(String pr) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE PR = ? ORDER BY PR", new Object[] { pr } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'QRS = :qrs'.
	 */
	public ArrRegistradorEcg[] findWhereQrsEquals(String qrs) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE QRS = ? ORDER BY QRS", new Object[] { qrs } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'QT = :qt'.
	 */
	public ArrRegistradorEcg[] findWhereQtEquals(String qt) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE QT = ? ORDER BY QT", new Object[] { qt } );
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the criteria 'QTC = :qtc'.
	 */
	public ArrRegistradorEcg[] findWhereQtcEquals(String qtc) throws ArrRegistradorEcgDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE QTC = ? ORDER BY QTC", new Object[] { qtc } );
	}

	/**
	 * Method 'ArrRegistradorEcgDaoImpl'
	 * 
	 */
	public ArrRegistradorEcgDaoImpl()
	{
	}
	public ArrRegistradorEcgDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public ArrRegistradorEcgDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}

	/**
	 * Method 'ArrRegistradorEcgDaoImpl'
	 * 
	 * @param userConn
	 */
	public ArrRegistradorEcgDaoImpl(final java.sql.Connection userConn)
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
		return "arr_registrador_ecg";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ArrRegistradorEcg fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ArrRegistradorEcg dto = new ArrRegistradorEcg();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ArrRegistradorEcg[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ArrRegistradorEcg dto = new ArrRegistradorEcg();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ArrRegistradorEcg ret[] = new ArrRegistradorEcg[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ArrRegistradorEcg dto, ResultSet rs) throws SQLException
	{
		dto.setIdRegistrador( new Integer( rs.getInt(COLUMN_ID_REGISTRADOR) ) );
		dto.setIdritmo( new Integer( rs.getInt(COLUMN_IDRITMO) ) );
		if (rs.wasNull()) {
			dto.setIdritmo( null );
		}
		
		dto.setIdconduccion( new Integer( rs.getInt(COLUMN_IDCONDUCCION) ) );
		if (rs.wasNull()) {
			dto.setIdconduccion( null );
		}
		
		dto.setIdconduccionno( new Integer( rs.getInt(COLUMN_IDCONDUCCIONNO) ) );
		if (rs.wasNull()) {
			dto.setIdconduccionno( null );
		}
		
		dto.setIdqrs( new Integer( rs.getInt(COLUMN_IDQRS) ) );
		if (rs.wasNull()) {
			dto.setIdqrs( null );
		}
		
		dto.setIdqrsno( new Integer( rs.getInt(COLUMN_IDQRSNO) ) );
		if (rs.wasNull()) {
			dto.setIdqrsno( null );
		}
		
		dto.setMorfologia( rs.getString( COLUMN_MORFOLOGIA ) );
		dto.setComentarios( rs.getString( COLUMN_COMENTARIOS ) );
		dto.setRr( rs.getString( COLUMN_RR ) );
		dto.setPr( rs.getString( COLUMN_PR ) );
		dto.setQrs( rs.getString( COLUMN_QRS ) );
		dto.setQt( rs.getString( COLUMN_QT ) );
		dto.setQtc( rs.getString( COLUMN_QTC ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ArrRegistradorEcg dto)
	{
	}

	/** 
	 * Returns all rows from the arr_registrador_ecg table that match the specified arbitrary SQL statement
	 */
	public ArrRegistradorEcg[] findByDynamicSelect(String sql, Object[] sqlParams) throws ArrRegistradorEcgDaoException
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
			throw new ArrRegistradorEcgDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the arr_registrador_ecg table that match the specified arbitrary SQL statement
	 */
	public ArrRegistradorEcg[] findByDynamicWhere(String sql, Object[] sqlParams) throws ArrRegistradorEcgDaoException
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
			throw new ArrRegistradorEcgDaoException( "Exception: " + _e.getMessage(), _e );
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

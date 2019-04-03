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
import java.util.Date;
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

public class AgendaDaoImpl extends AbstractDAO implements AgendaDao
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
	protected final String SQL_SELECT = "SELECT IDAGENDA, NOMBRE, DESCRIPCION, IDUSUARIO, TIPOAGENDA, FECHACREACION, FECHAMOD, VISIBILIDAD FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDAGENDA, NOMBRE, DESCRIPCION, IDUSUARIO, TIPOAGENDA, FECHACREACION, FECHAMOD, VISIBILIDAD ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDAGENDA = ?, NOMBRE = ?, DESCRIPCION = ?, IDUSUARIO = ?, TIPOAGENDA = ?, FECHACREACION = ?, FECHAMOD = ?, VISIBILIDAD = ? WHERE IDAGENDA = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDAGENDA = ?";

	/** 
	 * Index of column IDAGENDA
	 */
	protected static final int COLUMN_IDAGENDA = 1;

	/** 
	 * Index of column NOMBRE
	 */
	protected static final int COLUMN_NOMBRE = 2;

	/** 
	 * Index of column DESCRIPCION
	 */
	protected static final int COLUMN_DESCRIPCION = 3;

	/** 
	 * Index of column IDUSUARIO
	 */
	protected static final int COLUMN_IDUSUARIO = 4;

	/** 
	 * Index of column TIPOAGENDA
	 */
	protected static final int COLUMN_TIPOAGENDA = 5;

	/** 
	 * Index of column FECHACREACION
	 */
	protected static final int COLUMN_FECHACREACION = 6;

	/** 
	 * Index of column FECHAMOD
	 */
	protected static final int COLUMN_FECHAMOD = 7;

	/** 
	 * Index of column VISIBILIDAD
	 */
	protected static final int COLUMN_VISIBILIDAD = 8;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 8;

	/** 
	 * Index of primary-key column IDAGENDA
	 */
	protected static final int PK_COLUMN_IDAGENDA = 1;

	/** 
	 * Inserts a new row in the agenda table.
	 */
	public AgendaPk insert(Agenda dto) throws AgendaDaoException
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
			if (dto.getIdagenda() != null) {
				stmt.setInt( index++, dto.getIdagenda().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getNombre() );
			stmt.setString( index++, dto.getDescripcion() );
			stmt.setString( index++, dto.getIdusuario() );
			if (dto.getTipoagenda() != null) {
				stmt.setInt( index++, dto.getTipoagenda().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setDate(index++, dto.getFechacreacion()==null ? null : new java.sql.Date( dto.getFechacreacion().getTime() ) );
			stmt.setDate(index++, dto.getFechamod()==null ? null : new java.sql.Date( dto.getFechamod().getTime() ) );
			if (dto.getVisibilidad() != null) {
				stmt.setInt( index++, dto.getVisibilidad().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			//System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdagenda( new Integer( rs.getInt(1) ) );
			}
		
			auditoriaDto.setAccion(AuditoriaDto.insercion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new AgendaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the agenda table.
	 */
	public void update(AgendaPk pk, Agenda dto) throws AgendaDaoException
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
			if (dto.getIdagenda() != null) {
				stmt.setInt( index++, dto.getIdagenda().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getNombre() );
			stmt.setString( index++, dto.getDescripcion() );
			stmt.setString( index++, dto.getIdusuario() );
			if (dto.getTipoagenda() != null) {
				stmt.setInt( index++, dto.getTipoagenda().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setDate(index++, dto.getFechacreacion()==null ? null : new java.sql.Date( dto.getFechacreacion().getTime() ) );
			stmt.setDate(index++, dto.getFechamod()==null ? null : new java.sql.Date( dto.getFechamod().getTime() ) );
			if (dto.getVisibilidad() != null) {
				stmt.setInt( index++, dto.getVisibilidad().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (pk.getIdagenda() != null) {
				stmt.setInt( 9, pk.getIdagenda().intValue() );
			} else {
				stmt.setNull(9, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			reset(dto);
			long t2 = System.currentTimeMillis();
			auditoriaDto.setAccion(AuditoriaDto.modificacion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new AgendaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the agenda table.
	 */
	public void delete(AgendaPk pk) throws AgendaDaoException
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
			if (pk.getIdagenda() != null) {
				stmt.setInt( 1, pk.getIdagenda().intValue() );
			} else {
				stmt.setNull(1, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			auditoriaDto.setAccion(AuditoriaDto.borrado);
	        auditoriaDto.setDescri(pk.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new AgendaDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the agenda table that matches the specified primary-key value.
	 */
	public Agenda findByPrimaryKey(AgendaPk pk) throws AgendaDaoException
	{
		return findByPrimaryKey( pk.getIdagenda() );
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria 'IDAGENDA = :idagenda'.
	 */
	public Agenda findByPrimaryKey(Integer idagenda) throws AgendaDaoException
	{
		Agenda ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDAGENDA = ?", new Object[] { idagenda } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria ''.
	 */
	public Agenda[] findAll() throws AgendaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDAGENDA", null );
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria 'IDAGENDA = :idagenda'.
	 */
	public Agenda[] findWhereIdagendaEquals(int idagenda) throws AgendaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDAGENDA = ? ORDER BY IDAGENDA", new Object[] {  new Integer(idagenda) } );
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria 'NOMBRE = :nombre'.
	 */
	public Agenda[] findWhereNombreEquals(String nombre) throws AgendaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE NOMBRE = ? ORDER BY NOMBRE", new Object[] { nombre } );
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria 'DESCRIPCION = :descripcion'.
	 */
	public Agenda[] findWhereDescripcionEquals(String descripcion) throws AgendaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE DESCRIPCION = ? ORDER BY DESCRIPCION", new Object[] { descripcion } );
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria 'IDUSUARIO = :idusuario'.
	 */
	public Agenda[] findWhereIdusuarioEquals(String idusuario) throws AgendaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDUSUARIO = ? ORDER BY IDUSUARIO", new Object[] { idusuario } );
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria 'TIPOAGENDA = :tipoagenda'.
	 */
	public Agenda[] findWhereTipoagendaEquals(int tipoagenda) throws AgendaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TIPOAGENDA = ? ORDER BY TIPOAGENDA", new Object[] {  new Integer(tipoagenda) } );
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria 'FECHACREACION = :fechacreacion'.
	 */
	public Agenda[] findWhereFechacreacionEquals(Date fechacreacion) throws AgendaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHACREACION = ? ORDER BY FECHACREACION", new Object[] { fechacreacion==null ? null : new java.sql.Date( fechacreacion.getTime() ) } );
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria 'FECHAMOD = :fechamod'.
	 */
	public Agenda[] findWhereFechamodEquals(Date fechamod) throws AgendaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHAMOD = ? ORDER BY FECHAMOD", new Object[] { fechamod==null ? null : new java.sql.Date( fechamod.getTime() ) } );
	}

	/** 
	 * Returns all rows from the agenda table that match the criteria 'VISIBILIDAD = :visibilidad'.
	 */
	public Agenda[] findWhereVisibilidadEquals(int visibilidad) throws AgendaDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE VISIBILIDAD = ? ORDER BY VISIBILIDAD", new Object[] {  new Integer(visibilidad) } );
	}

	/**
	 * Method 'AgendaDaoImpl'
	 * 
	 */
	public AgendaDaoImpl()
	{
	}
	
	public AgendaDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public AgendaDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}

	/**
	 * Method 'AgendaDaoImpl'
	 * 
	 * @param userConn
	 */
	public AgendaDaoImpl(final java.sql.Connection userConn)
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
		return "idea.agenda";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Agenda fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Agenda dto = new Agenda();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Agenda[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Agenda dto = new Agenda();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Agenda ret[] = new Agenda[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Agenda dto, ResultSet rs) throws SQLException
	{
		dto.setIdagenda( new Integer( rs.getInt(COLUMN_IDAGENDA) ) );
		dto.setNombre( rs.getString( COLUMN_NOMBRE ) );
		dto.setDescripcion( rs.getString( COLUMN_DESCRIPCION ) );
		dto.setIdusuario( rs.getString( COLUMN_IDUSUARIO ) );
		dto.setTipoagenda( new Integer( rs.getInt(COLUMN_TIPOAGENDA) ) );
		if (rs.wasNull()) {
			dto.setTipoagenda( null );
		}
		
		dto.setFechacreacion( rs.getDate(COLUMN_FECHACREACION ) );
		dto.setFechamod( rs.getDate(COLUMN_FECHAMOD ) );
		dto.setVisibilidad( new Integer( rs.getInt(COLUMN_VISIBILIDAD) ) );
		if (rs.wasNull()) {
			dto.setVisibilidad( null );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Agenda dto)
	{
	}

	/** 
	 * Returns all rows from the agenda table that match the specified arbitrary SQL statement
	 */
	public Agenda[] findByDynamicSelect(String sql, Object[] sqlParams) throws AgendaDaoException
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
			throw new AgendaDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the agenda table that match the specified arbitrary SQL statement
	 */
	public Agenda[] findByDynamicWhere(String sql, Object[] sqlParams) throws AgendaDaoException
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
			throw new AgendaDaoException( "Exception: " + _e.getMessage(), _e );
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
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

public class CateterDaoImpl extends AbstractDAO implements CateterDao
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
	protected final String SQL_SELECT = "SELECT IDCATETER, MODELO, FABRICANTE, REFERENCIA, GS128, TIPO, DISTANCIAELECS, NUMELECS, TIPOABLACION, TIPODIAGNOSTICO, TIPOCURVA, TAMANO, LONGITUD, ENERGIA, ACTIVO FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDCATETER, MODELO, FABRICANTE, REFERENCIA, GS128, TIPO, DISTANCIAELECS, NUMELECS, TIPOABLACION, TIPODIAGNOSTICO, TIPOCURVA, TAMANO, LONGITUD, ENERGIA, ACTIVO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDCATETER = ?, MODELO = ?, FABRICANTE = ?, REFERENCIA = ?, GS128 = ?, TIPO = ?, DISTANCIAELECS = ?, NUMELECS = ?, TIPOABLACION = ?, TIPODIAGNOSTICO = ?, TIPOCURVA = ?, TAMANO = ?, LONGITUD = ?, ENERGIA = ?, ACTIVO = ? WHERE IDCATETER = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDCATETER = ?";

	/** 
	 * Index of column IDCATETER
	 */
	protected static final int COLUMN_IDCATETER = 1;

	/** 
	 * Index of column MODELO
	 */
	protected static final int COLUMN_MODELO = 2;

	/** 
	 * Index of column FABRICANTE
	 */
	protected static final int COLUMN_FABRICANTE = 3;

	/** 
	 * Index of column REFERENCIA
	 */
	protected static final int COLUMN_REFERENCIA = 4;

	/** 
	 * Index of column GS128
	 */
	protected static final int COLUMN_GS128 = 5;

	/** 
	 * Index of column TIPO
	 */
	protected static final int COLUMN_TIPO = 6;

	/** 
	 * Index of column DISTANCIAELECS
	 */
	protected static final int COLUMN_DISTANCIAELECS = 7;

	/** 
	 * Index of column NUMELECS
	 */
	protected static final int COLUMN_NUMELECS = 8;

	/** 
	 * Index of column TIPOABLACION
	 */
	protected static final int COLUMN_TIPOABLACION = 9;

	/** 
	 * Index of column TIPODIAGNOSTICO
	 */
	protected static final int COLUMN_TIPODIAGNOSTICO = 10;

	/** 
	 * Index of column TIPOCURVA
	 */
	protected static final int COLUMN_TIPOCURVA = 11;

	/** 
	 * Index of column TAMANO
	 */
	protected static final int COLUMN_TAMANO = 12;

	/** 
	 * Index of column LONGITUD
	 */
	protected static final int COLUMN_LONGITUD = 13;

	/** 
	 * Index of column ENERGIA
	 */
	protected static final int COLUMN_ENERGIA = 14;

	/** 
	 * Index of column ACTIVO
	 */
	protected static final int COLUMN_ACTIVO = 15;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 15;

	/** 
	 * Index of primary-key column IDCATETER
	 */
	protected static final int PK_COLUMN_IDCATETER = 1;

	/** 
	 * Inserts a new row in the cateter table.
	 */
	public CateterPk insert(Cateter dto) throws CateterDaoException
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
			if (dto.getIdcateter() != null) {
				stmt.setInt( index++, dto.getIdcateter().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getModelo() );
			if (dto.getFabricante() != null) {
				stmt.setInt( index++, dto.getFabricante().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getReferencia() );
			stmt.setString( index++, dto.getGs128() );
			if (dto.getTipo() != null) {
				stmt.setInt( index++, dto.getTipo().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getDistanciaelecs() );
			if (dto.getNumelecs() != null) {
				stmt.setInt( index++, dto.getNumelecs().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipoablacion() != null) {
				stmt.setInt( index++, dto.getTipoablacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipodiagnostico() != null) {
				stmt.setInt( index++, dto.getTipodiagnostico().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipocurva() != null) {
				stmt.setInt( index++, dto.getTipocurva().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTamano() != null) {
				stmt.setInt( index++, dto.getTamano().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getLongitud() );
			if (dto.getEnergia() != null) {
				stmt.setInt( index++, dto.getEnergia().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getActivo() != null) {
				stmt.setInt( index++, dto.getActivo().intValue() );
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
				dto.setIdcateter( new Integer( rs.getInt(1) ) );
			}		
			auditoriaDto.setAccion(AuditoriaDto.insercion);
			auditoriaDto.setDescri(dto.toString());
			auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new CateterDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the cateter table.
	 */
	public void update(CateterPk pk, Cateter dto) throws CateterDaoException
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
			if (dto.getIdcateter() != null) {
				stmt.setInt( index++, dto.getIdcateter().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getModelo() );
			if (dto.getFabricante() != null) {
				stmt.setInt( index++, dto.getFabricante().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getReferencia() );
			stmt.setString( index++, dto.getGs128() );
			if (dto.getTipo() != null) {
				stmt.setInt( index++, dto.getTipo().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getDistanciaelecs() );
			if (dto.getNumelecs() != null) {
				stmt.setInt( index++, dto.getNumelecs().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipoablacion() != null) {
				stmt.setInt( index++, dto.getTipoablacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipodiagnostico() != null) {
				stmt.setInt( index++, dto.getTipodiagnostico().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipocurva() != null) {
				stmt.setInt( index++, dto.getTipocurva().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTamano() != null) {
				stmt.setInt( index++, dto.getTamano().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getLongitud() );
			if (dto.getEnergia() != null) {
				stmt.setInt( index++, dto.getEnergia().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getActivo() != null) {
				stmt.setInt( index++, dto.getActivo().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (pk.getIdcateter() != null) {
				stmt.setInt( 16, pk.getIdcateter().intValue() );
			} else {
				stmt.setNull(16, java.sql.Types.INTEGER);
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
			throw new CateterDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the cateter table.
	 */
	public void delete(CateterPk pk) throws CateterDaoException
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
			if (pk.getIdcateter() != null) {
				stmt.setInt( 1, pk.getIdcateter().intValue() );
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
			throw new CateterDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the cateter table that matches the specified primary-key value.
	 */
	public Cateter findByPrimaryKey(CateterPk pk) throws CateterDaoException
	{
		return findByPrimaryKey( pk.getIdcateter() );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'IDCATETER = :idcateter'.
	 */
	public Cateter findByPrimaryKey(Integer idcateter) throws CateterDaoException
	{
		Cateter ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDCATETER = ?", new Object[] { idcateter } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria ''.
	 */
	public Cateter[] findAll() throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDCATETER", null );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'IDCATETER = :idcateter'.
	 */
	public Cateter[] findWhereIdcateterEquals(int idcateter) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDCATETER = ? ORDER BY IDCATETER", new Object[] {  new Integer(idcateter) } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'MODELO = :modelo'.
	 */
	public Cateter[] findWhereModeloEquals(String modelo) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE MODELO = ? ORDER BY MODELO", new Object[] { modelo } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'FABRICANTE = :fabricante'.
	 */
	public Cateter[] findWhereFabricanteEquals(int fabricante) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FABRICANTE = ? ORDER BY FABRICANTE", new Object[] {  new Integer(fabricante) } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'REFERENCIA = :referencia'.
	 */
	public Cateter[] findWhereReferenciaEquals(String referencia) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE REFERENCIA = ? ORDER BY REFERENCIA", new Object[] { referencia } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'GS128 = :gs128'.
	 */
	public Cateter[] findWhereGs128Equals(String gs128) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE GS128 = ? ORDER BY GS128", new Object[] { gs128 } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'TIPO = :tipo'.
	 */
	public Cateter[] findWhereTipoEquals(int tipo) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TIPO = ? ORDER BY TIPO", new Object[] {  new Integer(tipo) } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'DISTANCIAELECS = :distanciaelecs'.
	 */
	public Cateter[] findWhereDistanciaelecsEquals(String distanciaelecs) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE DISTANCIAELECS = ? ORDER BY DISTANCIAELECS", new Object[] { distanciaelecs } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'NUMELECS = :numelecs'.
	 */
	public Cateter[] findWhereNumelecsEquals(int numelecs) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE NUMELECS = ? ORDER BY NUMELECS", new Object[] {  new Integer(numelecs) } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'TIPOABLACION = :tipoablacion'.
	 */
	public Cateter[] findWhereTipoablacionEquals(int tipoablacion) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TIPOABLACION = ? ORDER BY TIPOABLACION", new Object[] {  new Integer(tipoablacion) } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'TIPODIAGNOSTICO = :tipodiagnostico'.
	 */
	public Cateter[] findWhereTipodiagnosticoEquals(int tipodiagnostico) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TIPODIAGNOSTICO = ? ORDER BY TIPODIAGNOSTICO", new Object[] {  new Integer(tipodiagnostico) } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'TIPOCURVA = :tipocurva'.
	 */
	public Cateter[] findWhereTipocurvaEquals(int tipocurva) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TIPOCURVA = ? ORDER BY TIPOCURVA", new Object[] {  new Integer(tipocurva) } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'TAMANO = :tamano'.
	 */
	public Cateter[] findWhereTamanoEquals(int tamano) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TAMANO = ? ORDER BY TAMANO", new Object[] {  new Integer(tamano) } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'LONGITUD = :longitud'.
	 */
	public Cateter[] findWhereLongitudEquals(String longitud) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE LONGITUD = ? ORDER BY LONGITUD", new Object[] { longitud } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'ENERGIA = :energia'.
	 */
	public Cateter[] findWhereEnergiaEquals(int energia) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ENERGIA = ? ORDER BY ENERGIA", new Object[] {  new Integer(energia) } );
	}

	/** 
	 * Returns all rows from the cateter table that match the criteria 'ACTIVO = :activo'.
	 */
	public Cateter[] findWhereActivoEquals(int activo) throws CateterDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ACTIVO = ? ORDER BY ACTIVO", new Object[] {  new Integer(activo) } );
	}

	/**
	 * Method 'CateterDaoImpl'
	 * 
	 */
	public CateterDaoImpl()
	{
	}
	public CateterDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public CateterDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}

	/**
	 * Method 'CateterDaoImpl'
	 * 
	 * @param userConn
	 */
	public CateterDaoImpl(final java.sql.Connection userConn)
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
		return "idea.cateter";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Cateter fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			Cateter dto = new Cateter();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected Cateter[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			Cateter dto = new Cateter();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		Cateter ret[] = new Cateter[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Cateter dto, ResultSet rs) throws SQLException
	{
		dto.setIdcateter( new Integer( rs.getInt(COLUMN_IDCATETER) ) );
		dto.setModelo( rs.getString( COLUMN_MODELO ) );
		dto.setFabricante( new Integer( rs.getInt(COLUMN_FABRICANTE) ) );
		if (rs.wasNull()) {
			dto.setFabricante( null );
		}
		
		dto.setReferencia( rs.getString( COLUMN_REFERENCIA ) );
		dto.setGs128( rs.getString( COLUMN_GS128 ) );
		dto.setTipo( new Integer( rs.getInt(COLUMN_TIPO) ) );
		if (rs.wasNull()) {
			dto.setTipo( null );
		}
		
		dto.setDistanciaelecs( rs.getString( COLUMN_DISTANCIAELECS ) );
		dto.setNumelecs( new Integer( rs.getInt(COLUMN_NUMELECS) ) );
		if (rs.wasNull()) {
			dto.setNumelecs( null );
		}
		
		dto.setTipoablacion( new Integer( rs.getInt(COLUMN_TIPOABLACION) ) );
		if (rs.wasNull()) {
			dto.setTipoablacion( null );
		}
		
		dto.setTipodiagnostico( new Integer( rs.getInt(COLUMN_TIPODIAGNOSTICO) ) );
		if (rs.wasNull()) {
			dto.setTipodiagnostico( null );
		}
		
		dto.setTipocurva( new Integer( rs.getInt(COLUMN_TIPOCURVA) ) );
		if (rs.wasNull()) {
			dto.setTipocurva( null );
		}
		
		dto.setTamano( new Integer( rs.getInt(COLUMN_TAMANO) ) );
		if (rs.wasNull()) {
			dto.setTamano( null );
		}
		
		dto.setLongitud( rs.getString( COLUMN_LONGITUD ) );
		dto.setEnergia( new Integer( rs.getInt(COLUMN_ENERGIA) ) );
		if (rs.wasNull()) {
			dto.setEnergia( null );
		}
		
		dto.setActivo( new Integer( rs.getInt(COLUMN_ACTIVO) ) );
		if (rs.wasNull()) {
			dto.setActivo( null );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(Cateter dto)
	{
	}

	/** 
	 * Returns all rows from the cateter table that match the specified arbitrary SQL statement
	 */
	public Cateter[] findByDynamicSelect(String sql, Object[] sqlParams) throws CateterDaoException
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
			throw new CateterDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the cateter table that match the specified arbitrary SQL statement
	 */
	public Cateter[] findByDynamicWhere(String sql, Object[] sqlParams) throws CateterDaoException
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
			throw new CateterDaoException( "Exception: " + _e.getMessage(), _e );
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

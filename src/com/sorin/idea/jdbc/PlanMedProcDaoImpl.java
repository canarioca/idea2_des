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

public class PlanMedProcDaoImpl extends AbstractDAO implements PlanMedProcDao
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
	protected final String SQL_SELECT = "SELECT IDPLANMEDPROC, IDPROCEDIMIENTO, TIPOPROCEDIMIENTO, IDMEDGEN, IDMEDCOM, DOSIS, UNIDAD, ADMINISTRACION, IDVIA, FECHAPRESCRIPCION, FECHAINICIO, FECHAMOD, FECHASUSPENSION, MOTIVOSUSPENSION, PRESCRIPTOR, COMENTARIOS FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDPLANMEDPROC, IDPROCEDIMIENTO, TIPOPROCEDIMIENTO, IDMEDGEN, IDMEDCOM, DOSIS, UNIDAD, ADMINISTRACION, IDVIA, FECHAPRESCRIPCION, FECHAINICIO, FECHAMOD, FECHASUSPENSION, MOTIVOSUSPENSION, PRESCRIPTOR, COMENTARIOS ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDPLANMEDPROC = ?, IDPROCEDIMIENTO = ?, TIPOPROCEDIMIENTO = ?, IDMEDGEN = ?, IDMEDCOM = ?, DOSIS = ?, UNIDAD = ?, ADMINISTRACION = ?, IDVIA = ?, FECHAPRESCRIPCION = ?, FECHAINICIO = ?, FECHAMOD = ?, FECHASUSPENSION = ?, MOTIVOSUSPENSION = ?, PRESCRIPTOR = ?, COMENTARIOS = ? WHERE IDPLANMEDPROC = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDPLANMEDPROC = ?";

	/** 
	 * Index of column IDPLANMEDPROC
	 */
	protected static final int COLUMN_IDPLANMEDPROC = 1;

	/** 
	 * Index of column IDPROCEDIMIENTO
	 */
	protected static final int COLUMN_IDPROCEDIMIENTO = 2;

	/** 
	 * Index of column TIPOPROCEDIMIENTO
	 */
	protected static final int COLUMN_TIPOPROCEDIMIENTO = 3;

	/** 
	 * Index of column IDMEDGEN
	 */
	protected static final int COLUMN_IDMEDGEN = 4;

	/** 
	 * Index of column IDMEDCOM
	 */
	protected static final int COLUMN_IDMEDCOM = 5;

	/** 
	 * Index of column DOSIS
	 */
	protected static final int COLUMN_DOSIS = 6;

	/** 
	 * Index of column UNIDAD
	 */
	protected static final int COLUMN_UNIDAD = 7;

	/** 
	 * Index of column ADMINISTRACION
	 */
	protected static final int COLUMN_ADMINISTRACION = 8;

	/** 
	 * Index of column IDVIA
	 */
	protected static final int COLUMN_IDVIA = 9;

	/** 
	 * Index of column FECHAPRESCRIPCION
	 */
	protected static final int COLUMN_FECHAPRESCRIPCION = 10;

	/** 
	 * Index of column FECHAINICIO
	 */
	protected static final int COLUMN_FECHAINICIO = 11;

	/** 
	 * Index of column FECHAMOD
	 */
	protected static final int COLUMN_FECHAMOD = 12;

	/** 
	 * Index of column FECHASUSPENSION
	 */
	protected static final int COLUMN_FECHASUSPENSION = 13;

	/** 
	 * Index of column MOTIVOSUSPENSION
	 */
	protected static final int COLUMN_MOTIVOSUSPENSION = 14;

	/** 
	 * Index of column PRESCRIPTOR
	 */
	protected static final int COLUMN_PRESCRIPTOR = 15;

	/** 
	 * Index of column COMENTARIOS
	 */
	protected static final int COLUMN_COMENTARIOS = 16;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 16;

	/** 
	 * Index of primary-key column IDPLANMEDPROC
	 */
	protected static final int PK_COLUMN_IDPLANMEDPROC = 1;

	/** 
	 * Inserts a new row in the plan_med_proc table.
	 */
	public PlanMedProcPk insert(PlanMedProc dto) throws PlanMedProcDaoException
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
			if (dto.getIdplanmedproc() != null) {
				stmt.setInt( index++, dto.getIdplanmedproc().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdprocedimiento() != null) {
				stmt.setInt( index++, dto.getIdprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipoprocedimiento() != null) {
				stmt.setInt( index++, dto.getTipoprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdmedgen() != null) {
				stmt.setInt( index++, dto.getIdmedgen().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdmedcom() != null) {
				stmt.setInt( index++, dto.getIdmedcom().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getDosis() );
			stmt.setString( index++, dto.getUnidad() );
			stmt.setString( index++, dto.getAdministracion() );
			if (dto.getIdvia() != null) {
				stmt.setInt( index++, dto.getIdvia().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setDate(index++, dto.getFechaprescripcion()==null ? null : new java.sql.Date( dto.getFechaprescripcion().getTime() ) );
			stmt.setDate(index++, dto.getFechainicio()==null ? null : new java.sql.Date( dto.getFechainicio().getTime() ) );
			stmt.setDate(index++, dto.getFechamod()==null ? null : new java.sql.Date( dto.getFechamod().getTime() ) );
			stmt.setDate(index++, dto.getFechasuspension()==null ? null : new java.sql.Date( dto.getFechasuspension().getTime() ) );
			stmt.setString( index++, dto.getMotivosuspension() );
			stmt.setString( index++, dto.getPrescriptor() );
			stmt.setString( index++, dto.getComentarios() );
			//System.out.println( "Executing " + SQL_INSERT + " with DTO: " + dto );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdplanmedproc( new Integer( rs.getInt(1) ) );
			}
			auditoriaDto.setAccion(AuditoriaDto.insercion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
		
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new PlanMedProcDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the plan_med_proc table.
	 */
	public void update(PlanMedProcPk pk, PlanMedProc dto) throws PlanMedProcDaoException
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
			if (dto.getIdplanmedproc() != null) {
				stmt.setInt( index++, dto.getIdplanmedproc().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdprocedimiento() != null) {
				stmt.setInt( index++, dto.getIdprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipoprocedimiento() != null) {
				stmt.setInt( index++, dto.getTipoprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdmedgen() != null) {
				stmt.setInt( index++, dto.getIdmedgen().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdmedcom() != null) {
				stmt.setInt( index++, dto.getIdmedcom().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getDosis() );
			stmt.setString( index++, dto.getUnidad() );
			stmt.setString( index++, dto.getAdministracion() );
			if (dto.getIdvia() != null) {
				stmt.setInt( index++, dto.getIdvia().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setDate(index++, dto.getFechaprescripcion()==null ? null : new java.sql.Date( dto.getFechaprescripcion().getTime() ) );
			stmt.setDate(index++, dto.getFechainicio()==null ? null : new java.sql.Date( dto.getFechainicio().getTime() ) );
			stmt.setDate(index++, dto.getFechamod()==null ? null : new java.sql.Date( dto.getFechamod().getTime() ) );
			stmt.setDate(index++, dto.getFechasuspension()==null ? null : new java.sql.Date( dto.getFechasuspension().getTime() ) );
			stmt.setString( index++, dto.getMotivosuspension() );
			stmt.setString( index++, dto.getPrescriptor() );
			stmt.setString( index++, dto.getComentarios() );
			if (pk.getIdplanmedproc() != null) {
				stmt.setInt( 17, pk.getIdplanmedproc().intValue() );
			} else {
				stmt.setNull(17, java.sql.Types.INTEGER);
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
			throw new PlanMedProcDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the plan_med_proc table.
	 */
	public void delete(PlanMedProcPk pk) throws PlanMedProcDaoException
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
			if (pk.getIdplanmedproc() != null) {
				stmt.setInt( 1, pk.getIdplanmedproc().intValue() );
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
			throw new PlanMedProcDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the plan_med_proc table that matches the specified primary-key value.
	 */
	public PlanMedProc findByPrimaryKey(PlanMedProcPk pk) throws PlanMedProcDaoException
	{
		return findByPrimaryKey( pk.getIdplanmedproc() );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'IDPLANMEDPROC = :idplanmedproc'.
	 */
	public PlanMedProc findByPrimaryKey(Integer idplanmedproc) throws PlanMedProcDaoException
	{
		PlanMedProc ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDPLANMEDPROC = ?", new Object[] { idplanmedproc } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria ''.
	 */
	public PlanMedProc[] findAll() throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDPLANMEDPROC", null );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'IDPLANMEDPROC = :idplanmedproc'.
	 */
	public PlanMedProc[] findWhereIdplanmedprocEquals(int idplanmedproc) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDPLANMEDPROC = ? ORDER BY IDPLANMEDPROC", new Object[] {  new Integer(idplanmedproc) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'IDPROCEDIMIENTO = :idprocedimiento'.
	 */
	public PlanMedProc[] findWhereIdprocedimientoEquals(int idprocedimiento) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDPROCEDIMIENTO = ? ORDER BY IDPROCEDIMIENTO", new Object[] {  new Integer(idprocedimiento) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'TIPOPROCEDIMIENTO = :tipoprocedimiento'.
	 */
	public PlanMedProc[] findWhereTipoprocedimientoEquals(int tipoprocedimiento) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TIPOPROCEDIMIENTO = ? ORDER BY TIPOPROCEDIMIENTO", new Object[] {  new Integer(tipoprocedimiento) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'IDMEDGEN = :idmedgen'.
	 */
	public PlanMedProc[] findWhereIdmedgenEquals(int idmedgen) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDMEDGEN = ? ORDER BY IDMEDGEN", new Object[] {  new Integer(idmedgen) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'IDMEDCOM = :idmedcom'.
	 */
	public PlanMedProc[] findWhereIdmedcomEquals(int idmedcom) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDMEDCOM = ? ORDER BY IDMEDCOM", new Object[] {  new Integer(idmedcom) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'DOSIS = :dosis'.
	 */
	public PlanMedProc[] findWhereDosisEquals(String dosis) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE DOSIS = ? ORDER BY DOSIS", new Object[] { dosis } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'UNIDAD = :unidad'.
	 */
	public PlanMedProc[] findWhereUnidadEquals(String unidad) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE UNIDAD = ? ORDER BY UNIDAD", new Object[] { unidad } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'ADMINISTRACION = :administracion'.
	 */
	public PlanMedProc[] findWhereAdministracionEquals(String administracion) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ADMINISTRACION = ? ORDER BY ADMINISTRACION", new Object[] { administracion } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'IDVIA = :idvia'.
	 */
	public PlanMedProc[] findWhereIdviaEquals(int idvia) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDVIA = ? ORDER BY IDVIA", new Object[] {  new Integer(idvia) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'FECHAPRESCRIPCION = :fechaprescripcion'.
	 */
	public PlanMedProc[] findWhereFechaprescripcionEquals(Date fechaprescripcion) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHAPRESCRIPCION = ? ORDER BY FECHAPRESCRIPCION", new Object[] { fechaprescripcion==null ? null : new java.sql.Date( fechaprescripcion.getTime() ) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'FECHAINICIO = :fechainicio'.
	 */
	public PlanMedProc[] findWhereFechainicioEquals(Date fechainicio) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHAINICIO = ? ORDER BY FECHAINICIO", new Object[] { fechainicio==null ? null : new java.sql.Date( fechainicio.getTime() ) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'FECHAMOD = :fechamod'.
	 */
	public PlanMedProc[] findWhereFechamodEquals(Date fechamod) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHAMOD = ? ORDER BY FECHAMOD", new Object[] { fechamod==null ? null : new java.sql.Date( fechamod.getTime() ) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'FECHASUSPENSION = :fechasuspension'.
	 */
	public PlanMedProc[] findWhereFechasuspensionEquals(Date fechasuspension) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHASUSPENSION = ? ORDER BY FECHASUSPENSION", new Object[] { fechasuspension==null ? null : new java.sql.Date( fechasuspension.getTime() ) } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'MOTIVOSUSPENSION = :motivosuspension'.
	 */
	public PlanMedProc[] findWhereMotivosuspensionEquals(String motivosuspension) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE MOTIVOSUSPENSION = ? ORDER BY MOTIVOSUSPENSION", new Object[] { motivosuspension } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'PRESCRIPTOR = :prescriptor'.
	 */
	public PlanMedProc[] findWherePrescriptorEquals(String prescriptor) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE PRESCRIPTOR = ? ORDER BY PRESCRIPTOR", new Object[] { prescriptor } );
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the criteria 'COMENTARIOS = :comentarios'.
	 */
	public PlanMedProc[] findWhereComentariosEquals(String comentarios) throws PlanMedProcDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE COMENTARIOS = ? ORDER BY COMENTARIOS", new Object[] { comentarios } );
	}

	/**
	 * Method 'PlanMedProcDaoImpl'
	 * 
	 */
	public PlanMedProcDaoImpl()
	{
	}

	public PlanMedProcDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public PlanMedProcDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	/**
	 * Method 'PlanMedProcDaoImpl'
	 * 
	 * @param userConn
	 */
	public PlanMedProcDaoImpl(final java.sql.Connection userConn)
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
		return "idea.plan_med_proc";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected PlanMedProc fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			PlanMedProc dto = new PlanMedProc();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected PlanMedProc[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			PlanMedProc dto = new PlanMedProc();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		PlanMedProc ret[] = new PlanMedProc[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(PlanMedProc dto, ResultSet rs) throws SQLException
	{
		dto.setIdplanmedproc( new Integer( rs.getInt(COLUMN_IDPLANMEDPROC) ) );
		dto.setIdprocedimiento( new Integer( rs.getInt(COLUMN_IDPROCEDIMIENTO) ) );
		dto.setTipoprocedimiento( new Integer( rs.getInt(COLUMN_TIPOPROCEDIMIENTO) ) );
		dto.setIdmedgen( new Integer( rs.getInt(COLUMN_IDMEDGEN) ) );
		if (rs.wasNull()) {
			dto.setIdmedgen( null );
		}
		
		dto.setIdmedcom( new Integer( rs.getInt(COLUMN_IDMEDCOM) ) );
		if (rs.wasNull()) {
			dto.setIdmedcom( null );
		}
		
		dto.setDosis( rs.getString( COLUMN_DOSIS ) );
		dto.setUnidad( rs.getString( COLUMN_UNIDAD ) );
		dto.setAdministracion( rs.getString( COLUMN_ADMINISTRACION ) );
		dto.setIdvia( new Integer( rs.getInt(COLUMN_IDVIA) ) );
		if (rs.wasNull()) {
			dto.setIdvia( null );
		}
		
		dto.setFechaprescripcion( rs.getDate(COLUMN_FECHAPRESCRIPCION ) );
		dto.setFechainicio( rs.getDate(COLUMN_FECHAINICIO ) );
		dto.setFechamod( rs.getDate(COLUMN_FECHAMOD ) );
		dto.setFechasuspension( rs.getDate(COLUMN_FECHASUSPENSION ) );
		dto.setMotivosuspension( rs.getString( COLUMN_MOTIVOSUSPENSION ) );
		dto.setPrescriptor( rs.getString( COLUMN_PRESCRIPTOR ) );
		dto.setComentarios( rs.getString( COLUMN_COMENTARIOS ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(PlanMedProc dto)
	{
	}

	/** 
	 * Returns all rows from the plan_med_proc table that match the specified arbitrary SQL statement
	 */
	public PlanMedProc[] findByDynamicSelect(String sql, Object[] sqlParams) throws PlanMedProcDaoException
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
			throw new PlanMedProcDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the plan_med_proc table that match the specified arbitrary SQL statement
	 */
	public PlanMedProc[] findByDynamicWhere(String sql, Object[] sqlParams) throws PlanMedProcDaoException
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
			throw new PlanMedProcDaoException( "Exception: " + _e.getMessage(), _e );
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

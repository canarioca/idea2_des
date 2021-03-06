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

public class PlanMedGenDaoImpl extends AbstractDAO implements PlanMedGenDao
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
	protected final String SQL_SELECT = "SELECT IDPLANMEDGEN, IDPACIENTE, IDMEDGEN, IDMEDCOM, DOSIS, UNIDAD, FRECUENCIA, ADMINISTRACION, IDVIA, FECHAPRESCRIPCION, FECHAINICIO, FECHAMOD, FECHASUSPENSION, MOTIVOSUSPENSION, ESTADO, PRESCRIPTOR, COMENTARIOS, OTROS FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDPLANMEDGEN, IDPACIENTE, IDMEDGEN, IDMEDCOM, DOSIS, UNIDAD, FRECUENCIA, ADMINISTRACION, IDVIA, FECHAPRESCRIPCION, FECHAINICIO, FECHAMOD, FECHASUSPENSION, MOTIVOSUSPENSION, ESTADO, PRESCRIPTOR, COMENTARIOS, OTROS ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDPLANMEDGEN = ?, IDPACIENTE = ?, IDMEDGEN = ?, IDMEDCOM = ?, DOSIS = ?, UNIDAD = ?, FRECUENCIA = ?, ADMINISTRACION = ?, IDVIA = ?, FECHAPRESCRIPCION = ?, FECHAINICIO = ?, FECHAMOD = ?, FECHASUSPENSION = ?, MOTIVOSUSPENSION = ?, ESTADO = ?, PRESCRIPTOR = ?, COMENTARIOS = ?, OTROS = ? WHERE IDPLANMEDGEN = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDPLANMEDGEN = ?";

	/** 
	 * Index of column IDPLANMEDGEN
	 */
	protected static final int COLUMN_IDPLANMEDGEN = 1;

	/** 
	 * Index of column IDPACIENTE
	 */
	protected static final int COLUMN_IDPACIENTE = 2;

	/** 
	 * Index of column IDMEDGEN
	 */
	protected static final int COLUMN_IDMEDGEN = 3;

	/** 
	 * Index of column IDMEDCOM
	 */
	protected static final int COLUMN_IDMEDCOM = 4;

	/** 
	 * Index of column DOSIS
	 */
	protected static final int COLUMN_DOSIS = 5;

	/** 
	 * Index of column UNIDAD
	 */
	protected static final int COLUMN_UNIDAD = 6;

	/** 
	 * Index of column FRECUENCIA
	 */
	protected static final int COLUMN_FRECUENCIA = 7;

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
	 * Index of column ESTADO
	 */
	protected static final int COLUMN_ESTADO = 15;

	/** 
	 * Index of column PRESCRIPTOR
	 */
	protected static final int COLUMN_PRESCRIPTOR = 16;

	/** 
	 * Index of column COMENTARIOS
	 */
	protected static final int COLUMN_COMENTARIOS = 17;

	/** 
	 * Index of column OTROS
	 */
	protected static final int COLUMN_OTROS = 18;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 18;

	/** 
	 * Index of primary-key column IDPLANMEDGEN
	 */
	protected static final int PK_COLUMN_IDPLANMEDGEN = 1;

	/** 
	 * Inserts a new row in the plan_med_gen table.
	 */
	public PlanMedGenPk insert(PlanMedGen dto) throws PlanMedGenDaoException
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
			if (dto.getIdplanmedgen() != null) {
				stmt.setInt( index++, dto.getIdplanmedgen().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdpaciente() != null) {
				stmt.setInt( index++, dto.getIdpaciente().intValue() );
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
			stmt.setString( index++, dto.getFrecuencia() );
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
			if (dto.getEstado() != null) {
				stmt.setInt( index++, dto.getEstado().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getPrescriptor() );
			stmt.setString( index++, dto.getComentarios() );
			stmt.setString( index++, dto.getOtros() );
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			//System.out.println( rows + " rows affected (" + (t2-t1) + " ms)" );
		
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdplanmedgen( new Integer( rs.getInt(1) ) );
			}
		
			auditoriaDto.setAccion(AuditoriaDto.insercion);
	        auditoriaDto.setDescri(dto.toString());
	        auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new PlanMedGenDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the plan_med_gen table.
	 */
	public void update(PlanMedGenPk pk, PlanMedGen dto) throws PlanMedGenDaoException
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
			if (dto.getIdplanmedgen() != null) {
				stmt.setInt( index++, dto.getIdplanmedgen().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdpaciente() != null) {
				stmt.setInt( index++, dto.getIdpaciente().intValue() );
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
			stmt.setString( index++, dto.getFrecuencia() );
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
			if (dto.getEstado() != null) {
				stmt.setInt( index++, dto.getEstado().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getPrescriptor() );
			stmt.setString( index++, dto.getComentarios() );
			stmt.setString( index++, dto.getOtros() );
			if (pk.getIdplanmedgen() != null) {
				stmt.setInt( 19, pk.getIdplanmedgen().intValue() );
			} else {
				stmt.setNull(19, java.sql.Types.INTEGER);
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
			throw new PlanMedGenDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the plan_med_gen table.
	 */
	public void delete(PlanMedGenPk pk) throws PlanMedGenDaoException
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
			if (pk.getIdplanmedgen() != null) {
				stmt.setInt( 1, pk.getIdplanmedgen().intValue() );
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
			throw new PlanMedGenDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the plan_med_gen table that matches the specified primary-key value.
	 */
	public PlanMedGen findByPrimaryKey(PlanMedGenPk pk) throws PlanMedGenDaoException
	{
		return findByPrimaryKey( pk.getIdplanmedgen() );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'IDPLANMEDGEN = :idplanmedgen'.
	 */
	public PlanMedGen findByPrimaryKey(Integer idplanmedgen) throws PlanMedGenDaoException
	{
		PlanMedGen ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDPLANMEDGEN = ?", new Object[] { idplanmedgen } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria ''.
	 */
	public PlanMedGen[] findAll() throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDPLANMEDGEN", null );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'IDPLANMEDGEN = :idplanmedgen'.
	 */
	public PlanMedGen[] findWhereIdplanmedgenEquals(int idplanmedgen) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDPLANMEDGEN = ? ORDER BY IDPLANMEDGEN", new Object[] {  new Integer(idplanmedgen) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'IDPACIENTE = :idpaciente'.
	 */
	public PlanMedGen[] findWhereIdpacienteEquals(int idpaciente) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDPACIENTE = ? ORDER BY IDPACIENTE", new Object[] {  new Integer(idpaciente) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'IDMEDGEN = :idmedgen'.
	 */
	public PlanMedGen[] findWhereIdmedgenEquals(int idmedgen) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDMEDGEN = ? ORDER BY IDMEDGEN", new Object[] {  new Integer(idmedgen) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'IDMEDCOM = :idmedcom'.
	 */
	public PlanMedGen[] findWhereIdmedcomEquals(int idmedcom) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDMEDCOM = ? ORDER BY IDMEDCOM", new Object[] {  new Integer(idmedcom) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'DOSIS = :dosis'.
	 */
	public PlanMedGen[] findWhereDosisEquals(String dosis) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE DOSIS = ? ORDER BY DOSIS", new Object[] { dosis } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'UNIDAD = :unidad'.
	 */
	public PlanMedGen[] findWhereUnidadEquals(String unidad) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE UNIDAD = ? ORDER BY UNIDAD", new Object[] { unidad } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'FRECUENCIA = :frecuencia'.
	 */
	public PlanMedGen[] findWhereFrecuenciaEquals(String frecuencia) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FRECUENCIA = ? ORDER BY FRECUENCIA", new Object[] { frecuencia } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'ADMINISTRACION = :administracion'.
	 */
	public PlanMedGen[] findWhereAdministracionEquals(String administracion) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ADMINISTRACION = ? ORDER BY ADMINISTRACION", new Object[] { administracion } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'IDVIA = :idvia'.
	 */
	public PlanMedGen[] findWhereIdviaEquals(int idvia) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDVIA = ? ORDER BY IDVIA", new Object[] {  new Integer(idvia) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'FECHAPRESCRIPCION = :fechaprescripcion'.
	 */
	public PlanMedGen[] findWhereFechaprescripcionEquals(Date fechaprescripcion) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHAPRESCRIPCION = ? ORDER BY FECHAPRESCRIPCION", new Object[] { fechaprescripcion==null ? null : new java.sql.Date( fechaprescripcion.getTime() ) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'FECHAINICIO = :fechainicio'.
	 */
	public PlanMedGen[] findWhereFechainicioEquals(Date fechainicio) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHAINICIO = ? ORDER BY FECHAINICIO", new Object[] { fechainicio==null ? null : new java.sql.Date( fechainicio.getTime() ) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'FECHAMOD = :fechamod'.
	 */
	public PlanMedGen[] findWhereFechamodEquals(Date fechamod) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHAMOD = ? ORDER BY FECHAMOD", new Object[] { fechamod==null ? null : new java.sql.Date( fechamod.getTime() ) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'FECHASUSPENSION = :fechasuspension'.
	 */
	public PlanMedGen[] findWhereFechasuspensionEquals(Date fechasuspension) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHASUSPENSION = ? ORDER BY FECHASUSPENSION", new Object[] { fechasuspension==null ? null : new java.sql.Date( fechasuspension.getTime() ) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'MOTIVOSUSPENSION = :motivosuspension'.
	 */
	public PlanMedGen[] findWhereMotivosuspensionEquals(String motivosuspension) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE MOTIVOSUSPENSION = ? ORDER BY MOTIVOSUSPENSION", new Object[] { motivosuspension } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'ESTADO = :estado'.
	 */
	public PlanMedGen[] findWhereEstadoEquals(int estado) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE ESTADO = ? ORDER BY ESTADO", new Object[] {  new Integer(estado) } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'PRESCRIPTOR = :prescriptor'.
	 */
	public PlanMedGen[] findWherePrescriptorEquals(String prescriptor) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE PRESCRIPTOR = ? ORDER BY PRESCRIPTOR", new Object[] { prescriptor } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'COMENTARIOS = :comentarios'.
	 */
	public PlanMedGen[] findWhereComentariosEquals(String comentarios) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE COMENTARIOS = ? ORDER BY COMENTARIOS", new Object[] { comentarios } );
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the criteria 'OTROS = :otros'.
	 */
	public PlanMedGen[] findWhereOtrosEquals(String otros) throws PlanMedGenDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE OTROS = ? ORDER BY OTROS", new Object[] { otros } );
	}

	/**
	 * Method 'PlanMedGenDaoImpl'
	 * 
	 */
	public PlanMedGenDaoImpl()
	{
	}
	
	public PlanMedGenDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public PlanMedGenDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}

	/**
	 * Method 'PlanMedGenDaoImpl'
	 * 
	 * @param userConn
	 */
	public PlanMedGenDaoImpl(final java.sql.Connection userConn)
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
		return "plan_med_gen";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected PlanMedGen fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			PlanMedGen dto = new PlanMedGen();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected PlanMedGen[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			PlanMedGen dto = new PlanMedGen();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		PlanMedGen ret[] = new PlanMedGen[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(PlanMedGen dto, ResultSet rs) throws SQLException
	{
		dto.setIdplanmedgen( new Integer( rs.getInt(COLUMN_IDPLANMEDGEN) ) );
		dto.setIdpaciente( new Integer( rs.getInt(COLUMN_IDPACIENTE) ) );
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
		dto.setFrecuencia( rs.getString( COLUMN_FRECUENCIA ) );
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
		dto.setEstado( new Integer( rs.getInt(COLUMN_ESTADO) ) );
		if (rs.wasNull()) {
			dto.setEstado( null );
		}
		
		dto.setPrescriptor( rs.getString( COLUMN_PRESCRIPTOR ) );
		dto.setComentarios( rs.getString( COLUMN_COMENTARIOS ) );
		dto.setOtros( rs.getString( COLUMN_OTROS ) );
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(PlanMedGen dto)
	{
	}

	/** 
	 * Returns all rows from the plan_med_gen table that match the specified arbitrary SQL statement
	 */
	public PlanMedGen[] findByDynamicSelect(String sql, Object[] sqlParams) throws PlanMedGenDaoException
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
			throw new PlanMedGenDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the plan_med_gen table that match the specified arbitrary SQL statement
	 */
	public PlanMedGen[] findByDynamicWhere(String sql, Object[] sqlParams) throws PlanMedGenDaoException
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
			throw new PlanMedGenDaoException( "Exception: " + _e.getMessage(), _e );
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

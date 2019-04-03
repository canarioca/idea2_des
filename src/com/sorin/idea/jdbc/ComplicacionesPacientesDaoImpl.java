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
import com.sorin.idea.util.UtilCodifi;
import com.sorin.idea.util.UtilFechas;

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

public class ComplicacionesPacientesDaoImpl extends AbstractDAO implements ComplicacionesPacientesDao
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
	protected final String SQL_SELECT = "SELECT IDCOMPAC, IDPACIENTE, TIPO, TIPOPROCEDIMIENTO, IDPROCEDIMIENTO, COMPLICACION, COMPLICACION1, COMPLICACION_OTRA, IDRELACION, IDLUGAR, FECHAINI, FECHAFIN, RESUELTA, RESUELTA_OTROS, TRATAMIENTO, TRATAMIENTO_TIPO, TRATAMIENTO_DESCR, INGRESO, DESCRIPCION, COMPLICACION2 FROM " + getTableName() + "";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO " + getTableName() + " ( IDCOMPAC, IDPACIENTE, TIPO, TIPOPROCEDIMIENTO, IDPROCEDIMIENTO, COMPLICACION, COMPLICACION1, COMPLICACION_OTRA, IDRELACION, IDLUGAR, FECHAINI, FECHAFIN, RESUELTA, RESUELTA_OTROS, TRATAMIENTO, TRATAMIENTO_TIPO, TRATAMIENTO_DESCR, INGRESO, DESCRIPCION, COMPLICACION2 ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE " + getTableName() + " SET IDCOMPAC = ?, IDPACIENTE = ?, TIPO = ?, TIPOPROCEDIMIENTO = ?, IDPROCEDIMIENTO = ?, COMPLICACION = ?, COMPLICACION1 = ?, COMPLICACION_OTRA = ?, IDRELACION = ?, IDLUGAR = ?, FECHAINI = ?, FECHAFIN = ?, RESUELTA = ?, RESUELTA_OTROS = ?, TRATAMIENTO = ?, TRATAMIENTO_TIPO = ?, TRATAMIENTO_DESCR = ?, INGRESO = ?, DESCRIPCION = ?, COMPLICACION2 = ? WHERE IDCOMPAC = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM " + getTableName() + " WHERE IDCOMPAC = ?";

	/** 
	 * Index of column IDCOMPAC
	 */
	protected static final int COLUMN_IDCOMPAC = 1;

	/** 
	 * Index of column IDPACIENTE
	 */
	protected static final int COLUMN_IDPACIENTE = 2;

	/** 
	 * Index of column TIPO
	 */
	protected static final int COLUMN_TIPO = 3;

	/** 
	 * Index of column TIPOPROCEDIMIENTO
	 */
	protected static final int COLUMN_TIPOPROCEDIMIENTO = 4;

	/** 
	 * Index of column IDPROCEDIMIENTO
	 */
	protected static final int COLUMN_IDPROCEDIMIENTO = 5;

	/** 
	 * Index of column COMPLICACION
	 */
	protected static final int COLUMN_COMPLICACION = 6;

	/** 
	 * Index of column COMPLICACION1
	 */
	protected static final int COLUMN_COMPLICACION1 = 7;

	/** 
	 * Index of column COMPLICACION_OTRA
	 */
	protected static final int COLUMN_COMPLICACION_OTRA = 8;

	/** 
	 * Index of column IDRELACION
	 */
	protected static final int COLUMN_IDRELACION = 9;

	/** 
	 * Index of column IDLUGAR
	 */
	protected static final int COLUMN_IDLUGAR = 10;

	/** 
	 * Index of column FECHAINI
	 */
	protected static final int COLUMN_FECHAINI = 11;

	/** 
	 * Index of column FECHAFIN
	 */
	protected static final int COLUMN_FECHAFIN = 12;

	/** 
	 * Index of column RESUELTA
	 */
	protected static final int COLUMN_RESUELTA = 13;

	/** 
	 * Index of column RESUELTA_OTROS
	 */
	protected static final int COLUMN_RESUELTA_OTROS = 14;

	/** 
	 * Index of column TRATAMIENTO
	 */
	protected static final int COLUMN_TRATAMIENTO = 15;

	/** 
	 * Index of column TRATAMIENTO_TIPO
	 */
	protected static final int COLUMN_TRATAMIENTO_TIPO = 16;

	/** 
	 * Index of column TRATAMIENTO_DESCR
	 */
	protected static final int COLUMN_TRATAMIENTO_DESCR = 17;

	/** 
	 * Index of column INGRESO
	 */
	protected static final int COLUMN_INGRESO = 18;

	/** 
	 * Index of column DESCRIPCION
	 */
	protected static final int COLUMN_DESCRIPCION = 19;

	/** 
	 * Index of column COMPLICACION2
	 */
	protected static final int COLUMN_COMPLICACION2 = 20;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 20;

	/** 
	 * Index of primary-key column IDCOMPAC
	 */
	protected static final int PK_COLUMN_IDCOMPAC = 1;

	/** 
	 * Inserts a new row in the complicaciones_pacientes table.
	 */
	public ComplicacionesPacientesPk insert(ComplicacionesPacientes dto) throws ComplicacionesPacientesDaoException
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
			if (dto.getIdcompac() != null) {
				stmt.setInt( index++, dto.getIdcompac().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdpaciente() != null) {
				stmt.setInt( index++, dto.getIdpaciente().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipo() != null) {
				stmt.setInt( index++, dto.getTipo().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipoprocedimiento() != null) {
				stmt.setInt( index++, dto.getTipoprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdprocedimiento() != null) {
				stmt.setInt( index++, dto.getIdprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getComplicacion() != null) {
				stmt.setInt( index++, dto.getComplicacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getComplicacion1() != null) {
				stmt.setInt( index++, dto.getComplicacion1().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getComplicacionOtra() );
			if (dto.getIdrelacion() != null) {
				stmt.setInt( index++, dto.getIdrelacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdlugar() != null) {
				stmt.setInt( index++, dto.getIdlugar().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setDate(index++, dto.getFechaini()==null ? null : new java.sql.Date( dto.getFechaini().getTime() ) );
			stmt.setDate(index++, dto.getFechafin()==null ? null : new java.sql.Date( dto.getFechafin().getTime() ) );
			if (dto.getResuelta() != null) {
				stmt.setInt( index++, dto.getResuelta().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getResueltaOtros() );
			if (dto.getTratamiento() != null) {
				stmt.setInt( index++, dto.getTratamiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTratamientoTipo() != null) {
				stmt.setInt( index++, dto.getTratamientoTipo().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getTratamientoDescr() );
			if (dto.getIngreso() != null) {
				stmt.setInt( index++, dto.getIngreso().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getDescripcion() );
			if (dto.getComplicacion2() != null) {
				stmt.setInt( index++, dto.getComplicacion2().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next()) {
				dto.setIdcompac( new Integer( rs.getInt(1) ) );
			}
			auditoriaDto.setAccion(AuditoriaDto.insercion);
			auditoriaDto.setDescri(dto.toString());
			auditoriaDao.escribeAuditoria(auditoriaDto);
			reset(dto);
			return dto.createPk();
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ComplicacionesPacientesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Updates a single row in the complicaciones_pacientes table.
	 */
	public void update(ComplicacionesPacientesPk pk, ComplicacionesPacientes dto) throws ComplicacionesPacientesDaoException
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
			if (dto.getIdcompac() != null) {
				stmt.setInt( index++, dto.getIdcompac().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdpaciente() != null) {
				stmt.setInt( index++, dto.getIdpaciente().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipo() != null) {
				stmt.setInt( index++, dto.getTipo().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTipoprocedimiento() != null) {
				stmt.setInt( index++, dto.getTipoprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdprocedimiento() != null) {
				stmt.setInt( index++, dto.getIdprocedimiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getComplicacion() != null) {
				stmt.setInt( index++, dto.getComplicacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getComplicacion1() != null) {
				stmt.setInt( index++, dto.getComplicacion1().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getComplicacionOtra() );
			if (dto.getIdrelacion() != null) {
				stmt.setInt( index++, dto.getIdrelacion().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getIdlugar() != null) {
				stmt.setInt( index++, dto.getIdlugar().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setDate(index++, dto.getFechaini()==null ? null : new java.sql.Date( dto.getFechaini().getTime() ) );
			stmt.setDate(index++, dto.getFechafin()==null ? null : new java.sql.Date( dto.getFechafin().getTime() ) );
			if (dto.getResuelta() != null) {
				stmt.setInt( index++, dto.getResuelta().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getResueltaOtros() );
			if (dto.getTratamiento() != null) {
				stmt.setInt( index++, dto.getTratamiento().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (dto.getTratamientoTipo() != null) {
				stmt.setInt( index++, dto.getTratamientoTipo().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getTratamientoDescr() );
			if (dto.getIngreso() != null) {
				stmt.setInt( index++, dto.getIngreso().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			stmt.setString( index++, dto.getDescripcion() );
			if (dto.getComplicacion2() != null) {
				stmt.setInt( index++, dto.getComplicacion2().intValue() );
			} else {
				stmt.setNull(index++, java.sql.Types.INTEGER);
			}
		
			if (pk.getIdcompac() != null) {
				stmt.setInt( 21, pk.getIdcompac().intValue() );
			} else {
				stmt.setNull(21, java.sql.Types.INTEGER);
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
			throw new ComplicacionesPacientesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Deletes a single row in the complicaciones_pacientes table.
	 */
	public void delete(ComplicacionesPacientesPk pk) throws ComplicacionesPacientesDaoException
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
			if (pk.getIdcompac() != null) {
				stmt.setInt( 1, pk.getIdcompac().intValue() );
			} else {
				stmt.setNull(1, java.sql.Types.INTEGER);
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			auditoriaDto.setAccion(AuditoriaDto.borrado);
			auditoriaDto.setDescri(pk.toString());
			auditoriaDao.escribeAuditoria(auditoriaDto);
		}
		catch (Exception _e) {
			_e.printStackTrace();
			throw new ComplicacionesPacientesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	/** 
	 * Returns the rows from the complicaciones_pacientes table that matches the specified primary-key value.
	 */
	public ComplicacionesPacientes findByPrimaryKey(ComplicacionesPacientesPk pk) throws ComplicacionesPacientesDaoException
	{
		return findByPrimaryKey( pk.getIdcompac() );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'IDCOMPAC = :idcompac'.
	 */
	public ComplicacionesPacientes findByPrimaryKey(Integer idcompac) throws ComplicacionesPacientesDaoException
	{
		ComplicacionesPacientes ret[] = findByDynamicSelect( SQL_SELECT + " WHERE IDCOMPAC = ?", new Object[] { idcompac } );
		return ret.length==0 ? null : ret[0];
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria ''.
	 */
	public ComplicacionesPacientes[] findAll() throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " ORDER BY IDCOMPAC", null );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'IDCOMPAC = :idcompac'.
	 */
	public ComplicacionesPacientes[] findWhereIdcompacEquals(int idcompac) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDCOMPAC = ? ORDER BY IDCOMPAC", new Object[] {  new Integer(idcompac) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'IDPACIENTE = :idpaciente'.
	 */
	public ComplicacionesPacientes[] findWhereIdpacienteEquals(int idpaciente) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDPACIENTE = ? ORDER BY IDPACIENTE", new Object[] {  new Integer(idpaciente) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'TIPO = :tipo'.
	 */
	public ComplicacionesPacientes[] findWhereTipoEquals(int tipo) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TIPO = ? ORDER BY TIPO", new Object[] {  new Integer(tipo) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'TIPOPROCEDIMIENTO = :tipoprocedimiento'.
	 */
	public ComplicacionesPacientes[] findWhereTipoprocedimientoEquals(int tipoprocedimiento) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TIPOPROCEDIMIENTO = ? ORDER BY TIPOPROCEDIMIENTO", new Object[] {  new Integer(tipoprocedimiento) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'IDPROCEDIMIENTO = :idprocedimiento'.
	 */
	public ComplicacionesPacientes[] findWhereIdprocedimientoEquals(int idprocedimiento) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDPROCEDIMIENTO = ? ORDER BY IDPROCEDIMIENTO", new Object[] {  new Integer(idprocedimiento) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'COMPLICACION = :complicacion'.
	 */
	public ComplicacionesPacientes[] findWhereComplicacionEquals(int complicacion) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE COMPLICACION = ? ORDER BY COMPLICACION", new Object[] {  new Integer(complicacion) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'COMPLICACION1 = :complicacion1'.
	 */
	public ComplicacionesPacientes[] findWhereComplicacion1Equals(int complicacion1) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE COMPLICACION1 = ? ORDER BY COMPLICACION1", new Object[] {  new Integer(complicacion1) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'COMPLICACION_OTRA = :complicacionOtra'.
	 */
	public ComplicacionesPacientes[] findWhereComplicacionOtraEquals(String complicacionOtra) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE COMPLICACION_OTRA = ? ORDER BY COMPLICACION_OTRA", new Object[] { complicacionOtra } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'IDRELACION = :idrelacion'.
	 */
	public ComplicacionesPacientes[] findWhereIdrelacionEquals(int idrelacion) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDRELACION = ? ORDER BY IDRELACION", new Object[] {  new Integer(idrelacion) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'IDLUGAR = :idlugar'.
	 */
	public ComplicacionesPacientes[] findWhereIdlugarEquals(int idlugar) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE IDLUGAR = ? ORDER BY IDLUGAR", new Object[] {  new Integer(idlugar) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'FECHAINI = :fechaini'.
	 */
	public ComplicacionesPacientes[] findWhereFechainiEquals(Date fechaini) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHAINI = ? ORDER BY FECHAINI", new Object[] { fechaini==null ? null : new java.sql.Date( fechaini.getTime() ) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'FECHAFIN = :fechafin'.
	 */
	public ComplicacionesPacientes[] findWhereFechafinEquals(Date fechafin) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE FECHAFIN = ? ORDER BY FECHAFIN", new Object[] { fechafin==null ? null : new java.sql.Date( fechafin.getTime() ) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'RESUELTA = :resuelta'.
	 */
	public ComplicacionesPacientes[] findWhereResueltaEquals(int resuelta) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE RESUELTA = ? ORDER BY RESUELTA", new Object[] {  new Integer(resuelta) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'RESUELTA_OTROS = :resueltaOtros'.
	 */
	public ComplicacionesPacientes[] findWhereResueltaOtrosEquals(String resueltaOtros) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE RESUELTA_OTROS = ? ORDER BY RESUELTA_OTROS", new Object[] { resueltaOtros } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'TRATAMIENTO = :tratamiento'.
	 */
	public ComplicacionesPacientes[] findWhereTratamientoEquals(int tratamiento) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TRATAMIENTO = ? ORDER BY TRATAMIENTO", new Object[] {  new Integer(tratamiento) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'TRATAMIENTO_TIPO = :tratamientoTipo'.
	 */
	public ComplicacionesPacientes[] findWhereTratamientoTipoEquals(int tratamientoTipo) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TRATAMIENTO_TIPO = ? ORDER BY TRATAMIENTO_TIPO", new Object[] {  new Integer(tratamientoTipo) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'TRATAMIENTO_DESCR = :tratamientoDescr'.
	 */
	public ComplicacionesPacientes[] findWhereTratamientoDescrEquals(String tratamientoDescr) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE TRATAMIENTO_DESCR = ? ORDER BY TRATAMIENTO_DESCR", new Object[] { tratamientoDescr } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'INGRESO = :ingreso'.
	 */
	public ComplicacionesPacientes[] findWhereIngresoEquals(int ingreso) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE INGRESO = ? ORDER BY INGRESO", new Object[] {  new Integer(ingreso) } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'DESCRIPCION = :descripcion'.
	 */
	public ComplicacionesPacientes[] findWhereDescripcionEquals(String descripcion) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE DESCRIPCION = ? ORDER BY DESCRIPCION", new Object[] { descripcion } );
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the criteria 'COMPLICACION2 = :complicacion2'.
	 */
	public ComplicacionesPacientes[] findWhereComplicacion2Equals(int complicacion2) throws ComplicacionesPacientesDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE COMPLICACION2 = ? ORDER BY COMPLICACION2", new Object[] {  new Integer(complicacion2) } );
	}

	/**
	 * Method 'ComplicacionesPacientesDaoImpl'
	 * 
	 */
	public ComplicacionesPacientesDaoImpl()
	{
	}

	public ComplicacionesPacientesDaoImpl(String usuario)
	{
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	public ComplicacionesPacientesDaoImpl(final java.sql.Connection userConn,String usuario)
	{
		this.userConn = userConn;
		this.auditoriaDto = new AuditoriaDto(usuario, getTableName());
	}
	/**
	 * Method 'ComplicacionesPacientesDaoImpl'
	 * 
	 * @param userConn
	 */
	public ComplicacionesPacientesDaoImpl(final java.sql.Connection userConn)
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
		return "idea.complicaciones_pacientes";
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected ComplicacionesPacientes fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next()) {
			ComplicacionesPacientes dto = new ComplicacionesPacientes();
			populateDto( dto, rs);
			return dto;
		} else {
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected ComplicacionesPacientes[] fetchMultiResults(ResultSet rs) throws SQLException
	{
		Collection resultList = new ArrayList();
		while (rs.next()) {
			ComplicacionesPacientes dto = new ComplicacionesPacientes();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		ComplicacionesPacientes ret[] = new ComplicacionesPacientes[ resultList.size() ];
		resultList.toArray( ret );
		return ret;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(ComplicacionesPacientes dto, ResultSet rs) throws SQLException
	{
		dto.setIdcompac( new Integer( rs.getInt(COLUMN_IDCOMPAC) ) );
		dto.setIdpaciente( new Integer( rs.getInt(COLUMN_IDPACIENTE) ) );
		dto.setTipo( new Integer( rs.getInt(COLUMN_TIPO) ) );
		if (rs.wasNull()) {
			dto.setTipo( null );
		}
		
		dto.setTipoprocedimiento( new Integer( rs.getInt(COLUMN_TIPOPROCEDIMIENTO) ) );
		if (rs.wasNull()) {
			dto.setTipoprocedimiento( null );
		}
		
		dto.setIdprocedimiento( new Integer( rs.getInt(COLUMN_IDPROCEDIMIENTO) ) );
		if (rs.wasNull()) {
			dto.setIdprocedimiento( null );
		}
		
		dto.setComplicacion( new Integer( rs.getInt(COLUMN_COMPLICACION) ) );
		dto.setComplicacion1( new Integer( rs.getInt(COLUMN_COMPLICACION1) ) );
		if (rs.wasNull()) {
			dto.setComplicacion1( null );
		}
		
		dto.setComplicacionOtra( rs.getString( COLUMN_COMPLICACION_OTRA ) );
		dto.setIdrelacion( new Integer( rs.getInt(COLUMN_IDRELACION) ) );
		if (rs.wasNull()) {
			dto.setIdrelacion( null );
		}
		
		dto.setIdlugar( new Integer( rs.getInt(COLUMN_IDLUGAR) ) );
		if (rs.wasNull()) {
			dto.setIdlugar( null );
		}
		
		dto.setFechaini( rs.getDate(COLUMN_FECHAINI ) );
		dto.setFechafin( rs.getDate(COLUMN_FECHAFIN ) );
		dto.setResuelta( new Integer( rs.getInt(COLUMN_RESUELTA) ) );
		if (rs.wasNull()) {
			dto.setResuelta( null );
		}
		
		dto.setResueltaOtros( rs.getString( COLUMN_RESUELTA_OTROS ) );
		dto.setTratamiento( new Integer( rs.getInt(COLUMN_TRATAMIENTO) ) );
		if (rs.wasNull()) {
			dto.setTratamiento( null );
		}
		
		dto.setTratamientoTipo( new Integer( rs.getInt(COLUMN_TRATAMIENTO_TIPO) ) );
		if (rs.wasNull()) {
			dto.setTratamientoTipo( null );
		}
		
		dto.setTratamientoDescr( rs.getString( COLUMN_TRATAMIENTO_DESCR ) );
		dto.setIngreso( new Integer( rs.getInt(COLUMN_INGRESO) ) );
		if (rs.wasNull()) {
			dto.setIngreso( null );
		}
		
		dto.setDescripcion( rs.getString( COLUMN_DESCRIPCION ) );
		dto.setComplicacion2( new Integer( rs.getInt(COLUMN_COMPLICACION2) ) );
		if (rs.wasNull()) {
			dto.setComplicacion2( null );
		}
		
	}

	/** 
	 * Resets the modified attributes in the DTO
	 */
	protected void reset(ComplicacionesPacientes dto)
	{
	}

	/** 
	 * Returns all rows from the complicaciones_pacientes table that match the specified arbitrary SQL statement
	 */
	public ComplicacionesPacientes[] findByDynamicSelect(String sql, Object[] sqlParams) throws ComplicacionesPacientesDaoException
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
			throw new ComplicacionesPacientesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	public ArrayList<ArrayList<Object>> findByDynamicSelect(String sql) throws ComplicacionesPacientesDaoException
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
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return UtilCodifi.Results2Array(rs);
		}
		catch (Exception _e) {
			throw new ComplicacionesPacientesDaoException( "Exception: " + _e.getMessage(), _e );
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
	 * Returns all rows from the complicaciones_pacientes table that match the specified arbitrary SQL statement
	 */
	public ComplicacionesPacientes[] findByDynamicWhere(String sql, Object[] sqlParams) throws ComplicacionesPacientesDaoException
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
			throw new ComplicacionesPacientesDaoException( "Exception: " + _e.getMessage(), _e );
		}
		finally {
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied) {
				ResourceManager.close(conn);
			}
		
		}
		
	}

	public ArrayList<ArrayList<Object>> getComplicacionesTipoProc(Integer idrelacion, Date fechaini, Date fechafin) throws ComplicacionesPacientesDaoException{
		StringBuffer sql = new StringBuffer();
		sql.append("select complicaciones.idcomplicacion COMPLICACION, ");
		sql.append(" complicaciones_pacientes.tipo TIPO_COMPLICACION ");
		sql.append(" from complicaciones, ");
		sql.append(" complicaciones_pacientes ");
		sql.append(" WHERE complicaciones_pacientes.fechaini between '"+UtilFechas.getFechaString(fechaini)+"' and '"+UtilFechas.getFechaString(fechafin)+"'");
		sql.append(" and complicaciones.idcomplicacion = complicaciones_pacientes.complicacion ");
		sql.append(" and complicaciones_pacientes.idrelacion = "+idrelacion);
		return findByDynamicSelect(sql.toString());
	}
	
}
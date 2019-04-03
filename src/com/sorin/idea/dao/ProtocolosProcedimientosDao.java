/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.dao;

import com.sorin.idea.dto.*;
import com.sorin.idea.exceptions.*;

public interface ProtocolosProcedimientosDao
{
	/** 
	 * Inserts a new row in the protocolos_procedimientos table.
	 */
	public ProtocolosProcedimientosPk insert(ProtocolosProcedimientos dto) throws ProtocolosProcedimientosDaoException;

	/** 
	 * Updates a single row in the protocolos_procedimientos table.
	 */
	public void update(ProtocolosProcedimientosPk pk, ProtocolosProcedimientos dto) throws ProtocolosProcedimientosDaoException;

	/** 
	 * Deletes a single row in the protocolos_procedimientos table.
	 */
	public void delete(ProtocolosProcedimientosPk pk) throws ProtocolosProcedimientosDaoException;

	/** 
	 * Returns the rows from the protocolos_procedimientos table that matches the specified primary-key value.
	 */
	public ProtocolosProcedimientos findByPrimaryKey(ProtocolosProcedimientosPk pk) throws ProtocolosProcedimientosDaoException;

	/** 
	 * Returns all rows from the protocolos_procedimientos table that match the criteria 'IDPROTOCOLO = :idprotocolo AND IDPROCEDIMIENTO = :idprocedimiento AND TIPOPROCEDIMIENTO = :tipoprocedimiento'.
	 */
	public ProtocolosProcedimientos findByPrimaryKey(Integer idprotocolo, Integer idprocedimiento, Integer tipoprocedimiento) throws ProtocolosProcedimientosDaoException;

	/** 
	 * Returns all rows from the protocolos_procedimientos table that match the criteria ''.
	 */
	public ProtocolosProcedimientos[] findAll() throws ProtocolosProcedimientosDaoException;

	/** 
	 * Returns all rows from the protocolos_procedimientos table that match the criteria 'IDPROTOCOLO = :idprotocolo'.
	 */
	public ProtocolosProcedimientos[] findWhereIdprotocoloEquals(int idprotocolo) throws ProtocolosProcedimientosDaoException;

	/** 
	 * Returns all rows from the protocolos_procedimientos table that match the criteria 'IDPROCEDIMIENTO = :idprocedimiento'.
	 */
	public ProtocolosProcedimientos[] findWhereIdprocedimientoEquals(int idprocedimiento) throws ProtocolosProcedimientosDaoException;

	/** 
	 * Returns all rows from the protocolos_procedimientos table that match the criteria 'TIPOPROCEDIMIENTO = :tipoprocedimiento'.
	 */
	public ProtocolosProcedimientos[] findWhereTipoprocedimientoEquals(int tipoprocedimiento) throws ProtocolosProcedimientosDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the protocolos_procedimientos table that match the specified arbitrary SQL statement
	 */
	public ProtocolosProcedimientos[] findByDynamicSelect(String sql, Object[] sqlParams) throws ProtocolosProcedimientosDaoException;

	/** 
	 * Returns all rows from the protocolos_procedimientos table that match the specified arbitrary SQL statement
	 */
	public ProtocolosProcedimientos[] findByDynamicWhere(String sql, Object[] sqlParams) throws ProtocolosProcedimientosDaoException;

}
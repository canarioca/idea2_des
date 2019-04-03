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


public interface ImpEvolucionComplicacionDao
{
	/** 
	 * Inserts a new row in the imp_evolucion_complicacion table.
	 */
	public ImpEvolucionComplicacionPk insert(ImpEvolucionComplicacion dto) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Updates a single row in the imp_evolucion_complicacion table.
	 */
	public void update(ImpEvolucionComplicacionPk pk, ImpEvolucionComplicacion dto) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Deletes a single row in the imp_evolucion_complicacion table.
	 */
	public void delete(ImpEvolucionComplicacionPk pk) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Returns the rows from the imp_evolucion_complicacion table that matches the specified primary-key value.
	 */
	public ImpEvolucionComplicacion findByPrimaryKey(ImpEvolucionComplicacionPk pk) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Returns all rows from the imp_evolucion_complicacion table that match the criteria 'IDCOMPL = :idcompl AND IDEV = :idev'.
	 */
	public ImpEvolucionComplicacion findByPrimaryKey(Integer idcompl, Integer idev) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Returns all rows from the imp_evolucion_complicacion table that match the criteria ''.
	 */
	public ImpEvolucionComplicacion[] findAll() throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Returns all rows from the imp_evolucion_complicacion table that match the criteria 'IDCOMPL = :idcompl'.
	 */
	public ImpEvolucionComplicacion[] findWhereIdcomplEquals(int idcompl) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Returns all rows from the imp_evolucion_complicacion table that match the criteria 'IDEV = :idev'.
	 */
	public ImpEvolucionComplicacion[] findWhereIdevEquals(int idev) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Returns all rows from the imp_evolucion_complicacion table that match the criteria 'ACTITUD = :actitud'.
	 */
	public ImpEvolucionComplicacion[] findWhereActitudEquals(String actitud) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Returns all rows from the imp_evolucion_complicacion table that match the criteria 'RESULTADO = :resultado'.
	 */
	public ImpEvolucionComplicacion[] findWhereResultadoEquals(String resultado) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Returns all rows from the imp_evolucion_complicacion table that match the criteria 'OTRA = :otra'.
	 */
	public ImpEvolucionComplicacion[] findWhereOtraEquals(String otra) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the imp_evolucion_complicacion table that match the specified arbitrary SQL statement
	 */
	public ImpEvolucionComplicacion[] findByDynamicSelect(String sql, Object[] sqlParams) throws ImpEvolucionComplicacionDaoException;

	/** 
	 * Returns all rows from the imp_evolucion_complicacion table that match the specified arbitrary SQL statement
	 */
	public ImpEvolucionComplicacion[] findByDynamicWhere(String sql, Object[] sqlParams) throws ImpEvolucionComplicacionDaoException;

}

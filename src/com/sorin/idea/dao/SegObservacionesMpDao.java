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


public interface SegObservacionesMpDao
{
	/** 
	 * Inserts a new row in the seg_observaciones_mp table.
	 */
	public SegObservacionesMpPk insert(SegObservacionesMp dto) throws SegObservacionesMpDaoException;

	/** 
	 * Updates a single row in the seg_observaciones_mp table.
	 */
	public void update(SegObservacionesMpPk pk, SegObservacionesMp dto) throws SegObservacionesMpDaoException;

	/** 
	 * Deletes a single row in the seg_observaciones_mp table.
	 */
	public void delete(SegObservacionesMpPk pk) throws SegObservacionesMpDaoException;

	/** 
	 * Returns the rows from the seg_observaciones_mp table that matches the specified primary-key value.
	 */
	public SegObservacionesMp findByPrimaryKey(SegObservacionesMpPk pk) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria 'IDOBSMP = :idobsmp'.
	 */
	public SegObservacionesMp findByPrimaryKey(Integer idobsmp) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria ''.
	 */
	public SegObservacionesMp[] findAll() throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria 'IDOBSMP = :idobsmp'.
	 */
	public SegObservacionesMp[] findWhereIdobsmpEquals(int idobsmp) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria 'ARRAU = :arrau'.
	 */
	public SegObservacionesMp[] findWhereArrauEquals(short arrau) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria 'NUMARRAU = :numarrau'.
	 */
	public SegObservacionesMp[] findWhereNumarrauEquals(String numarrau) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria 'CAMBIOMODOARRAU = :cambiomodoarrau'.
	 */
	public SegObservacionesMp[] findWhereCambiomodoarrauEquals(short cambiomodoarrau) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria 'NUMCAMBIOMODOARRAU = :numcambiomodoarrau'.
	 */
	public SegObservacionesMp[] findWhereNumcambiomodoarrauEquals(String numcambiomodoarrau) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria 'ARRVENT = :arrvent'.
	 */
	public SegObservacionesMp[] findWhereArrventEquals(short arrvent) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria 'EPIRUIDO = :epiruido'.
	 */
	public SegObservacionesMp[] findWhereEpiruidoEquals(short epiruido) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the criteria 'NUMARRV = :numarrv'.
	 */
	public SegObservacionesMp[] findWhereNumarrvEquals(String numarrv) throws SegObservacionesMpDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the specified arbitrary SQL statement
	 */
	public SegObservacionesMp[] findByDynamicSelect(String sql, Object[] sqlParams) throws SegObservacionesMpDaoException;

	/** 
	 * Returns all rows from the seg_observaciones_mp table that match the specified arbitrary SQL statement
	 */
	public SegObservacionesMp[] findByDynamicWhere(String sql, Object[] sqlParams) throws SegObservacionesMpDaoException;

}
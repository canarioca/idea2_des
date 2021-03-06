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

public interface RcPsicoSituacionEconomicaDao
{
	/** 
	 * Inserts a new row in the RC_PSICO_SITUACION_ECONOMICA table.
	 */
	public RcPsicoSituacionEconomicaPk insert(RcPsicoSituacionEconomica dto) throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Updates a single row in the RC_PSICO_SITUACION_ECONOMICA table.
	 */
	public void update(RcPsicoSituacionEconomicaPk pk, RcPsicoSituacionEconomica dto) throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Deletes a single row in the RC_PSICO_SITUACION_ECONOMICA table.
	 */
	public void delete(RcPsicoSituacionEconomicaPk pk) throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Returns the rows from the RC_PSICO_SITUACION_ECONOMICA table that matches the specified primary-key value.
	 */
	public RcPsicoSituacionEconomica findByPrimaryKey(RcPsicoSituacionEconomicaPk pk) throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_SITUACION_ECONOMICA table that match the criteria 'ID_SITUACION_ECONOMICA = :idSituacionEconomica'.
	 */
	public RcPsicoSituacionEconomica findByPrimaryKey(long idSituacionEconomica) throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_SITUACION_ECONOMICA table that match the criteria ''.
	 */
	public RcPsicoSituacionEconomica[] findAll() throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_SITUACION_ECONOMICA table that match the criteria 'ID_SITUACION_ECONOMICA = :idSituacionEconomica'.
	 */
	public RcPsicoSituacionEconomica[] findWhereIdSituacionEconomicaEquals(long idSituacionEconomica) throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_SITUACION_ECONOMICA table that match the criteria 'SITUACION = :situacion'.
	 */
	public RcPsicoSituacionEconomica[] findWhereSituacionEquals(String situacion) throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the RC_PSICO_SITUACION_ECONOMICA table that match the specified arbitrary SQL statement
	 */
	public RcPsicoSituacionEconomica[] findByDynamicSelect(String sql, Object[] sqlParams) throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_SITUACION_ECONOMICA table that match the specified arbitrary SQL statement
	 */
	public RcPsicoSituacionEconomica[] findByDynamicWhere(String sql, Object[] sqlParams) throws RcPsicoSituacionEconomicaDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_SITUACION_ECONOMICA table that match the specified arbitrary SQL statement inner join with RC_PSICOLOGIA
	 */
	public RcPsicoSituacionEconomica findByInnerJoinRCRehabilitador( long idPsicologia ) throws RcPsicoSituacionEconomicaDaoException;
}

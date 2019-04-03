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

public interface RcPsicoNivelSatisfaccionDao
{
	/** 
	 * Inserts a new row in the RC_PSICO_NIVEL_SATISFACCION table.
	 */
	public RcPsicoNivelSatisfaccionPk insert(RcPsicoNivelSatisfaccion dto) throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Updates a single row in the RC_PSICO_NIVEL_SATISFACCION table.
	 */
	public void update(RcPsicoNivelSatisfaccionPk pk, RcPsicoNivelSatisfaccion dto) throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Deletes a single row in the RC_PSICO_NIVEL_SATISFACCION table.
	 */
	public void delete(RcPsicoNivelSatisfaccionPk pk) throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Returns the rows from the RC_PSICO_NIVEL_SATISFACCION table that matches the specified primary-key value.
	 */
	public RcPsicoNivelSatisfaccion findByPrimaryKey(RcPsicoNivelSatisfaccionPk pk) throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_NIVEL_SATISFACCION table that match the criteria 'ID_NIVEL_SATISFACCION = :idNivelSatisfaccion'.
	 */
	public RcPsicoNivelSatisfaccion findByPrimaryKey(long idNivelSatisfaccion) throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_NIVEL_SATISFACCION table that match the criteria ''.
	 */
	public RcPsicoNivelSatisfaccion[] findAll() throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_NIVEL_SATISFACCION table that match the criteria 'ID_NIVEL_SATISFACCION = :idNivelSatisfaccion'.
	 */
	public RcPsicoNivelSatisfaccion[] findWhereIdNivelSatisfaccionEquals(long idNivelSatisfaccion) throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_NIVEL_SATISFACCION table that match the criteria 'TIPO = :tipo'.
	 */
	public RcPsicoNivelSatisfaccion[] findWhereTipoEquals(String tipo) throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the RC_PSICO_NIVEL_SATISFACCION table that match the specified arbitrary SQL statement
	 */
	public RcPsicoNivelSatisfaccion[] findByDynamicSelect(String sql, Object[] sqlParams) throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_NIVEL_SATISFACCION table that match the specified arbitrary SQL statement
	 */
	public RcPsicoNivelSatisfaccion[] findByDynamicWhere(String sql, Object[] sqlParams) throws RcPsicoNivelSatisfaccionDaoException;

	/** 
	 * Returns all rows from the RC_PSICO_NIVEL_IRRITABILIDAD table that match the specified arbitrary SQL statement inner join with RC_PSICOLOGIA
	 */
	public RcPsicoNivelSatisfaccion findByInnerJoinRCRehabilitador( long idPsicologia ) throws RcPsicoNivelSatisfaccionDaoException;

}

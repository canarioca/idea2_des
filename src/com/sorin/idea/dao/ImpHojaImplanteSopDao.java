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


public interface ImpHojaImplanteSopDao
{
	/** 
	 * Inserts a new row in the imp_hoja_implante_sop table.
	 */
	public ImpHojaImplanteSopPk insert(ImpHojaImplanteSop dto) throws ImpHojaImplanteSopDaoException;

	/** 
	 * Updates a single row in the imp_hoja_implante_sop table.
	 */
	public void update(ImpHojaImplanteSopPk pk, ImpHojaImplanteSop dto) throws ImpHojaImplanteSopDaoException;

	/** 
	 * Deletes a single row in the imp_hoja_implante_sop table.
	 */
	public void delete(ImpHojaImplanteSopPk pk) throws ImpHojaImplanteSopDaoException;

	/** 
	 * Returns the rows from the imp_hoja_implante_sop table that matches the specified primary-key value.
	 */
	public ImpHojaImplanteSop findByPrimaryKey(ImpHojaImplanteSopPk pk) throws ImpHojaImplanteSopDaoException;

	/** 
	 * Returns all rows from the imp_hoja_implante_sop table that match the criteria 'IDHOJAIMP = :idhojaimp AND IDOP = :idop'.
	 */
	public ImpHojaImplanteSop findByPrimaryKey(Integer idhojaimp, String idop) throws ImpHojaImplanteSopDaoException;

	/** 
	 * Returns all rows from the imp_hoja_implante_sop table that match the criteria ''.
	 */
	public ImpHojaImplanteSop[] findAll() throws ImpHojaImplanteSopDaoException;

	/** 
	 * Returns all rows from the imp_hoja_implante_sop table that match the criteria 'IDHOJAIMP = :idhojaimp'.
	 */
	public ImpHojaImplanteSop[] findWhereIdhojaimpEquals(int idhojaimp) throws ImpHojaImplanteSopDaoException;

	/** 
	 * Returns all rows from the imp_hoja_implante_sop table that match the criteria 'IDOP = :idop'.
	 */
	public ImpHojaImplanteSop[] findWhereIdopEquals(String idop) throws ImpHojaImplanteSopDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the imp_hoja_implante_sop table that match the specified arbitrary SQL statement
	 */
	public ImpHojaImplanteSop[] findByDynamicSelect(String sql, Object[] sqlParams) throws ImpHojaImplanteSopDaoException;

	/** 
	 * Returns all rows from the imp_hoja_implante_sop table that match the specified arbitrary SQL statement
	 */
	public ImpHojaImplanteSop[] findByDynamicWhere(String sql, Object[] sqlParams) throws ImpHojaImplanteSopDaoException;

}

/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.dao;

import java.util.ArrayList;
import java.util.Date;
import com.sorin.idea.dto.*;
import com.sorin.idea.exceptions.*;

public interface ImpImplanteDao
{
	/** 
	 * Inserts a new row in the imp_implante table.
	 */
	public ImpImplantePk insert(ImpImplante dto) throws ImpImplanteDaoException;

	/** 
	 * Updates a single row in the imp_implante table.
	 */
	public void update(ImpImplantePk pk, ImpImplante dto) throws ImpImplanteDaoException;

	/** 
	 * Deletes a single row in the imp_implante table.
	 */
	public void delete(ImpImplantePk pk) throws ImpImplanteDaoException;

	/** 
	 * Returns the rows from the imp_implante table that matches the specified primary-key value.
	 */
	public ImpImplante findByPrimaryKey(ImpImplantePk pk) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria 'IDIMPLANTE = :idimplante'.
	 */
	public ImpImplante findByPrimaryKey(Integer idimplante) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria ''.
	 */
	public ImpImplante[] findAll() throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria 'IDIMPLANTE = :idimplante'.
	 */
	public ImpImplante[] findWhereIdimplanteEquals(int idimplante) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria 'IDHOJAIMP = :idhojaimp'.
	 */
	public ImpImplante[] findWhereIdhojaimpEquals(int idhojaimp) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria 'IDEV = :idev'.
	 */
	public ImpImplante[] findWhereIdevEquals(int idev) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria 'FECHAIMPLANTE = :fechaimplante'.
	 */
	public ImpImplante[] findWhereFechaimplanteEquals(Date fechaimplante) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria 'TIPO = :tipo'.
	 */
	public ImpImplante[] findWhereTipoEquals(String tipo) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria 'INTERVENCIONPREVIA = :intervencionprevia'.
	 */
	public ImpImplante[] findWhereIntervencionpreviaEquals(short intervencionprevia) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria 'NPROC = :nproc'.
	 */
	public ImpImplante[] findWhereNprocEquals(String nproc) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the criteria 'COMENTARIOS = :comentarios'.
	 */
	public ImpImplante[] findWhereComentariosEquals(String comentarios) throws ImpImplanteDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the imp_implante table that match the specified arbitrary SQL statement
	 */
	public ImpImplante[] findByDynamicSelect(String sql, Object[] sqlParams) throws ImpImplanteDaoException;

	/** 
	 * Returns all rows from the imp_implante table that match the specified arbitrary SQL statement
	 */
	public ImpImplante[] findByDynamicWhere(String sql, Object[] sqlParams) throws ImpImplanteDaoException;

	/** 
	 * Devuelve la consulta estadística de los Implantes-Situacion Clinica
	 * @param eef 
	 */
	public ArrayList<ArrayList<Object>> getEstadisticasBradi(int tipoproc, int ritmo, int cav, int qrs, int modo, String modelo, String pop,Date fechaini,Date fechafin,String tipo1,String tipo2,String tipo3) throws ImpImplanteDaoException;
	/** 
	 * Devuelve la consulta estadística de los Implantes-Situacion Clinica
	 * @param eef 
	 */
	public ArrayList<ArrayList<Object>> getEstadisticasTaqui(int tipoproc, int ritmo, int cav, int qrs, int modo, String modelo, String pop,Date fechaini,Date fechafin,String tipo1,String tipo2,String tipo3) throws ImpImplanteDaoException;
	
	public ArrayList<ArrayList<Object>> getPops(Integer idhimp) throws ImpImplanteDaoException;
	public ArrayList<ArrayList<Object>> getSops(Integer idhimp) throws ImpImplanteDaoException;
	public ArrayList<ArrayList<Object>> getEstadisticasImplantes(Date fechaini,Date fechafin) throws ImpImplanteDaoException;
	
	public ImpImplante getLastNProc() throws ImpImplanteDaoException;
	
	public ArrayList<ArrayList<Object>> getGeneradoresImplantados(Integer codigo, Date fecha) throws ImpImplanteDaoException;
	public ArrayList<ArrayList<Object>> getConsultaGeneradores(String modelo, String nserie, String nserie2, String fab, Date fini, Date ffin) throws ImpImplanteDaoException;
	public ArrayList<ArrayList<Object>> getConsultaElectrodos(String modelo, String nserie, String nserie2, String fab, Date fini, Date ffin) throws ImpImplanteDaoException;
}

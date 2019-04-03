/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import com.sorin.idea.dto.*;
import com.sorin.idea.exceptions.*;


public interface ArrTestEpiDao
{
	/** 
	 * Inserts a new row in the ARR_TEST_EPI table.
	 */
	public ArrTestEpiPk insert(ArrTestEpi dto) throws ArrTestEpiDaoException;

	/** 
	 * Updates a single row in the ARR_TEST_EPI table.
	 */
	public void update(ArrTestEpiPk pk, ArrTestEpi dto) throws ArrTestEpiDaoException;

	/** 
	 * Deletes a single row in the ARR_TEST_EPI table.
	 */
	public void delete(ArrTestEpiPk pk) throws ArrTestEpiDaoException;

	/** 
	 * Returns the rows from the ARR_TEST_EPI table that matches the specified primary-key value.
	 */
	public ArrTestEpi findByPrimaryKey(ArrTestEpiPk pk) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'CODIGO_TEST = :codigoTest'.
	 */
	public ArrTestEpi findByPrimaryKey(Integer codigoTest) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria ''.
	 */
	public ArrTestEpi[] findAll() throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'CODIGO_PACIENTE = :codigoPaciente'.
	 */
	public ArrTestEpi[] findWhereCodigoPacienteEquals(long codigoPaciente) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'CODIGO_TEST = :codigoTest'.
	 */
	public ArrTestEpi[] findWhereCodigoTestEquals(long codigoTest) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'CLINICO = :clinico'.
	 */
	public ArrTestEpi[] findWhereClinicoEquals(long clinico) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'ECG = :ecg'.
	 */
	public ArrTestEpi[] findWhereEcgEquals(long ecg) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'INTERVALOS = :intervalos'.
	 */
	public ArrTestEpi[] findWhereIntervalosEquals(long intervalos) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'QRS = :qrs'.
	 */
	public ArrTestEpi[] findWhereQrsEquals(long qrs) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'DOSIS1 = :dosis1'.
	 */
	public ArrTestEpi[] findWhereDosis1Equals(long dosis1) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'DOSIS2 = :dosis2'.
	 */
	public ArrTestEpi[] findWhereDosis2Equals(long dosis2) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'COMPLICA = :complica'.
	 */
	public ArrTestEpi[] findWhereComplicaEquals(long complica) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'TRATAM = :tratam'.
	 */
	public ArrTestEpi[] findWhereTratamEquals(long tratam) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'PICOQT = :picoqt'.
	 */
	public ArrTestEpi[] findWherePicoqtEquals(String picoqt) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the criteria 'FECHA = :fecha'.
	 */
	public ArrTestEpi[] findWhereFechaEquals(Date fecha) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the arr_test_epi table that match the criteria 'COMPLICAOTR = :complicaotr'.
	 */
	public ArrTestEpi[] findWhereComplicaotrEquals(String complicaotr) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the arr_test_epi table that match the criteria 'NPROC = :nproc'.
	 */
	public ArrTestEpi[] findWhereNprocEquals(String nproc) throws ArrTestEpiDaoException;

	/**
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the specified arbitrary SQL statement
	 */
	public ArrTestEpi[] findByDynamicSelect(String sql, Object[] sqlParams) throws ArrTestEpiDaoException;

	/** 
	 * Returns all rows from the ARR_TEST_EPI table that match the specified arbitrary SQL statement
	 */
	public ArrTestEpi[] findByDynamicWhere(String sql, Object[] sqlParams) throws ArrTestEpiDaoException;
	
	/** 
	 * ESTADISTICAS
	 */
	public ArrayList<ArrayList<Object>> getEstadisticas(Date fechaini,Date fechafin,ArrTestEpi test) throws ArrTestEpiDaoException;
	public ArrayList<ArrayList<Object>> getEstadisticasEPI(Date fechaini, Date fechafin) throws ArrTestEpiDaoException;

}
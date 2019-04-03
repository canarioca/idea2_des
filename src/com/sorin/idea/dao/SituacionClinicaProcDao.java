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

public interface SituacionClinicaProcDao
{
	/** 
	 * Inserts a new row in the situacion_clinica_proc table.
	 */
	public SituacionClinicaProcPk insert(SituacionClinicaProc dto) throws SituacionClinicaProcDaoException;

	/** 
	 * Updates a single row in the situacion_clinica_proc table.
	 */
	public void update(SituacionClinicaProcPk pk, SituacionClinicaProc dto) throws SituacionClinicaProcDaoException;

	/** 
	 * Deletes a single row in the situacion_clinica_proc table.
	 */
	public void delete(SituacionClinicaProcPk pk) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns the rows from the situacion_clinica_proc table that matches the specified primary-key value.
	 */
	public SituacionClinicaProc findByPrimaryKey(SituacionClinicaProcPk pk) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'IDSITCLIN = :idsitclin'.
	 */
	public SituacionClinicaProc findByPrimaryKey(Integer idsitclin) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria ''.
	 */
	public SituacionClinicaProc[] findAll() throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'IDSITCLIN = :idsitclin'.
	 */
	public SituacionClinicaProc[] findWhereIdsitclinEquals(int idsitclin) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'RITMO = :ritmo'.
	 */
	public SituacionClinicaProc[] findWhereRitmoEquals(int ritmo) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'RITMO2 = :ritmo2'.
	 */
	public SituacionClinicaProc[] findWhereRitmo2Equals(int ritmo2) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'CONDUCAV = :conducav'.
	 */
	public SituacionClinicaProc[] findWhereConducavEquals(int conducav) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'CONDUCAV2 = :conducav2'.
	 */
	public SituacionClinicaProc[] findWhereConducav2Equals(int conducav2) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'QRS = :qrs'.
	 */
	public SituacionClinicaProc[] findWhereQrsEquals(int qrs) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'QRS2 = :qrs2'.
	 */
	public SituacionClinicaProc[] findWhereQrs2Equals(int qrs2) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'ANCHURAQRS = :anchuraqrs'.
	 */
	public SituacionClinicaProc[] findWhereAnchuraqrsEquals(String anchuraqrs) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'FEVI = :fevi'.
	 */
	public SituacionClinicaProc[] findWhereFeviEquals(String fevi) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'FUNCIONVENTRICULAR = :funcionventricular'.
	 */
	public SituacionClinicaProc[] findWhereFuncionventricularEquals(int funcionventricular) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'NYHA = :nyha'.
	 */
	public SituacionClinicaProc[] findWhereNyhaEquals(int nyha) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'CARDIOPATIA = :cardiopatia'.
	 */
	public SituacionClinicaProc[] findWhereCardiopatiaEquals(int cardiopatia) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'AEVOLUCION = :aevolucion'.
	 */
	public SituacionClinicaProc[] findWhereAevolucionEquals(String aevolucion) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'OTRA = :otra'.
	 */
	public SituacionClinicaProc[] findWhereOtraEquals(String otra) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'REVASC = :revasc'.
	 */
	public SituacionClinicaProc[] findWhereRevascEquals(short revasc) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'INFPREVIO = :infprevio'.
	 */
	public SituacionClinicaProc[] findWhereInfprevioEquals(short infprevio) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'ANIO = :anio'.
	 */
	public SituacionClinicaProc[] findWhereAnioEquals(String anio) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'LOCALIZACION = :localizacion'.
	 */
	public SituacionClinicaProc[] findWhereLocalizacionEquals(int localizacion) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'ARRITMIAS = :arritmias'.
	 */
	public SituacionClinicaProc[] findWhereArritmiasEquals(int arritmias) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'EEF = :eef'.
	 */
	public SituacionClinicaProc[] findWhereEefEquals(int eef) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'ETIOLOGIA = :etiologia'.
	 */
	public SituacionClinicaProc[] findWhereEtiologiaEquals(int etiologia) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'HTA = :hta'.
	 */
	public SituacionClinicaProc[] findWhereHtaEquals(short hta) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'DISLIPEMIA = :dislipemia'.
	 */
	public SituacionClinicaProc[] findWhereDislipemiaEquals(short dislipemia) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'DIABETES = :diabetes'.
	 */
	public SituacionClinicaProc[] findWhereDiabetesEquals(short diabetes) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'TABAQUISMO = :tabaquismo'.
	 */
	public SituacionClinicaProc[] findWhereTabaquismoEquals(short tabaquismo) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'INGALCOHOLICA = :ingalcoholica'.
	 */
	public SituacionClinicaProc[] findWhereIngalcoholicaEquals(short ingalcoholica) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'ACV = :acv'.
	 */
	public SituacionClinicaProc[] findWhereAcvEquals(short acv) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'AIT = :ait'.
	 */
	public SituacionClinicaProc[] findWhereAitEquals(short ait) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'EPOC = :epoc'.
	 */
	public SituacionClinicaProc[] findWhereEpocEquals(short epoc) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'SAHS = :sahs'.
	 */
	public SituacionClinicaProc[] findWhereSahsEquals(short sahs) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'TIPOSAHS = :tiposahs'.
	 */
	public SituacionClinicaProc[] findWhereTiposahsEquals(int tiposahs) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'AHI = :ahi'.
	 */
	public SituacionClinicaProc[] findWhereAhiEquals(String ahi) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'CPAP = :cpap'.
	 */
	public SituacionClinicaProc[] findWhereCpapEquals(short cpap) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'INSRENAL = :insrenal'.
	 */
	public SituacionClinicaProc[] findWhereInsrenalEquals(short insrenal) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'TIPOINSRENAL = :tipoinsrenal'.
	 */
	public SituacionClinicaProc[] findWhereTipoinsrenalEquals(int tipoinsrenal) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'NEOPLASIA = :neoplasia'.
	 */
	public SituacionClinicaProc[] findWhereNeoplasiaEquals(short neoplasia) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'TIPONEOPLASIA = :tiponeoplasia'.
	 */
	public SituacionClinicaProc[] findWhereTiponeoplasiaEquals(String tiponeoplasia) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'AFECTIROIDEA = :afectiroidea'.
	 */
	public SituacionClinicaProc[] findWhereAfectiroideaEquals(int afectiroidea) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'ANTFA = :antfa'.
	 */
	public SituacionClinicaProc[] findWhereAntfaEquals(short antfa) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'HIPERTENSION = :hipertension'.
	 */
	public SituacionClinicaProc[] findWhereHipertensionEquals(short hipertension) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'MUERTESUBITA = :muertesubita'.
	 */
	public SituacionClinicaProc[] findWhereMuertesubitaEquals(short muertesubita) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'HIPERCOLEST = :hipercolest'.
	 */
	public SituacionClinicaProc[] findWhereHipercolestEquals(short hipercolest) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'COMENTARIOS = :comentarios'.
	 */
	public SituacionClinicaProc[] findWhereComentariosEquals(String comentarios) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'FECHA = :fecha'.
	 */
	public SituacionClinicaProc[] findWhereFechaEquals(Date fecha) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'NEUROMEDIADOS = :neuromediados'.
	 */
	public SituacionClinicaProc[] findWhereNeuromediadosEquals(int neuromediados) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'TRASPLANTECARDIACO = :trasplantecardiaco'.
	 */
	public SituacionClinicaProc[] findWhereTrasplantecardiacoEquals(short trasplantecardiaco) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'SINCOPE = :sincope'.
	 */
	public SituacionClinicaProc[] findWhereSincopeEquals(short sincope) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'PARADACARDIACA = :paradacardiaca'.
	 */
	public SituacionClinicaProc[] findWhereParadacardiacaEquals(short paradacardiaca) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'AI = :ai'.
	 */
	public SituacionClinicaProc[] findWhereAiEquals(String ai) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'AI2 = :ai2'.
	 */
	public SituacionClinicaProc[] findWhereAi2Equals(int ai2) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the criteria 'ENFART = :enfart'.
	 */
	public SituacionClinicaProc[] findWhereEnfartEquals(int enfart) throws SituacionClinicaProcDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the specified arbitrary SQL statement
	 */
	public SituacionClinicaProc[] findByDynamicSelect(String sql, Object[] sqlParams) throws SituacionClinicaProcDaoException;

	/** 
	 * Returns all rows from the situacion_clinica_proc table that match the specified arbitrary SQL statement
	 */
	public SituacionClinicaProc[] findByDynamicWhere(String sql, Object[] sqlParams) throws SituacionClinicaProcDaoException;

	public ArrayList<ArrayList<Object>> getEstadisticasFEVI(Integer codigo, Date fecha_muestreo) throws SituacionClinicaProcDaoException;
}
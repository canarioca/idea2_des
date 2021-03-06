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

public interface RegistradorEventosExtDao
{
	/** 
	 * Inserts a new row in the registrador_eventos_ext table.
	 */
	public RegistradorEventosExtPk insert(RegistradorEventosExt dto) throws RegistradorEventosExtDaoException;

	/** 
	 * Updates a single row in the registrador_eventos_ext table.
	 */
	public void update(RegistradorEventosExtPk pk, RegistradorEventosExt dto) throws RegistradorEventosExtDaoException;

	/** 
	 * Deletes a single row in the registrador_eventos_ext table.
	 */
	public void delete(RegistradorEventosExtPk pk) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns the rows from the registrador_eventos_ext table that matches the specified primary-key value.
	 */
	public RegistradorEventosExt findByPrimaryKey(RegistradorEventosExtPk pk) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'IDEVENTO = :idevento'.
	 */
	public RegistradorEventosExt findByPrimaryKey(Integer idevento) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria ''.
	 */
	public RegistradorEventosExt[] findAll() throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'IDEVENTO = :idevento'.
	 */
	public RegistradorEventosExt[] findWhereIdeventoEquals(int idevento) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'FECHACOLOCACION = :fechacolocacion'.
	 */
	public RegistradorEventosExt[] findWhereFechacolocacionEquals(Date fechacolocacion) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'FECHALECTURA = :fechalectura'.
	 */
	public RegistradorEventosExt[] findWhereFechalecturaEquals(Date fechalectura) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'FECHARETIRADA = :fecharetirada'.
	 */
	public RegistradorEventosExt[] findWhereFecharetiradaEquals(Date fecharetirada) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'FECHANALISIS = :fechanalisis'.
	 */
	public RegistradorEventosExt[] findWhereFechanalisisEquals(Date fechanalisis) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'ESTADO = :estado'.
	 */
	public RegistradorEventosExt[] findWhereEstadoEquals(int estado) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'COMENTARIOS_COL = :comentariosCol'.
	 */
	public RegistradorEventosExt[] findWhereComentariosColEquals(String comentariosCol) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'COMENTARIOS_ANA = :comentariosAna'.
	 */
	public RegistradorEventosExt[] findWhereComentariosAnaEquals(String comentariosAna) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'RECOMENDACIONES = :recomendaciones'.
	 */
	public RegistradorEventosExt[] findWhereRecomendacionesEquals(String recomendaciones) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'DIAGNOSTICOINI = :diagnosticoini'.
	 */
	public RegistradorEventosExt[] findWhereDiagnosticoiniEquals(int diagnosticoini) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'DIAGNOSTICOFIN = :diagnosticofin'.
	 */
	public RegistradorEventosExt[] findWhereDiagnosticofinEquals(int diagnosticofin) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'REFERIDOR = :referidor'.
	 */
	public RegistradorEventosExt[] findWhereReferidorEquals(String referidor) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'COLOCACION_ENF = :colocacionEnf'.
	 */
	public RegistradorEventosExt[] findWhereColocacionEnfEquals(String colocacionEnf) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'COLOCACION_MED = :colocacionMed'.
	 */
	public RegistradorEventosExt[] findWhereColocacionMedEquals(String colocacionMed) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'ANALISIS_MED = :analisisMed'.
	 */
	public RegistradorEventosExt[] findWhereAnalisisMedEquals(String analisisMed) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'RETIRADA_ENF = :retiradaEnf'.
	 */
	public RegistradorEventosExt[] findWhereRetiradaEnfEquals(String retiradaEnf) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'RETIRADA_MED = :retiradaMed'.
	 */
	public RegistradorEventosExt[] findWhereRetiradaMedEquals(String retiradaMed) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'NPROC = :nproc'.
	 */
	public RegistradorEventosExt[] findWhereNprocEquals(String nproc) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'DIAGINIOTRO = :diaginiotro'.
	 */
	public RegistradorEventosExt[] findWhereDiaginiotroEquals(String diaginiotro) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the criteria 'DIAGFINOTRO = :diagfinotro'.
	 */
	public RegistradorEventosExt[] findWhereDiagfinotroEquals(String diagfinotro) throws RegistradorEventosExtDaoException;

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows);

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows();

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the specified arbitrary SQL statement
	 */
	public RegistradorEventosExt[] findByDynamicSelect(String sql, Object[] sqlParams) throws RegistradorEventosExtDaoException;

	/** 
	 * Returns all rows from the registrador_eventos_ext table that match the specified arbitrary SQL statement
	 */
	public RegistradorEventosExt[] findByDynamicWhere(String sql, Object[] sqlParams) throws RegistradorEventosExtDaoException;

	public ArrayList<ArrayList<Object>> getEstadisticasRegEvExt(Date fechaini, Date fechafin) throws RegistradorEventosExtDaoException;
	public ArrayList<ArrayList<Object>> getEstadisticas(Date fechaini, Date fechafin, int ind)throws RegistradorEventosExtDaoException;

}

package com.sorin.idea.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.IntPacientes;
import com.sorin.idea.dto.PacienteAplDto;

import hvn.cm.dao.BaseDao;
import hvn.cm.dao.DAOException;

/**
 * Clase de acceso a la base de datos Clínica.
 * 
 * @author jofuga00
 */
public class PacienteDao extends BaseDao {

	protected void iniciarDao() {
		this.setDePool(true);
		this.nombreConector = "poolClinicaBD";
		//this.nombreConector = "poolDepart";
	}

	public PacienteDao() {
		this.iniciarDao();
	}

	/**
	 * Función que devuelve el número de historia clínica del paciente si se
	 * encuentra en la base de datos Clínica.
	 * 
	 * @author jofuga00
	 * @param nuhsa
	 * @return
	 * @throws DAOException
	 * @version 1.0; 28/06/2010
	 */
	public String getPacientesByNUHSA(String nuhsa) throws DAOException {

		String sql = "SELECT pacientes.numerohc FROM pacientes, bdu_nuhsa WHERE "
				+ "bdu_nuhsa.nuhsa = '"
				+ nuhsa
				+ "' AND pacientes.numerohc = bdu_nuhsa.numerohc";

		List<Map> resultado = consultarSQL(sql);

		if (resultado.size() == 0)
			return "";
		else
			return resultado.get(0).get("numerohc").toString().trim();
	}

	public PacienteAplDto getPacientesByNHC_Conciliado(String nhc)
			throws DAOException {

		StringBuffer sql = new StringBuffer();
		sql
				.append("SELECT "
						+ "bdu_nuhsa.nuhsa nuhsa, "
						+ "pacientes.numerohc nhc, "
						+ "pacientes.nombre nombre, "
						+ "pacientes.apellid1 apellid1, "
						+ "pacientes.apellid2 apellid2, "
						+ "pacientes.sexo sexo, "
						+ "pacientes.fechanac fechaNaci, "
						+ "provincias.descprov provincia, "
						+ "poblacion.nompobla poblacion, "
						+ "pacientes.domiresi direccion, "
						+ "pacientes.codipost cp, "
						+ "pacientes.dni dni, "
						+ "pacientes.telefono telefono1, "
						+ "pacientes.numeross1||pacientes.numeross2||pacientes.numeross3 nss1 "
						+

						"FROM pacientes, bdu_nuhsa, provincias, poblacion " +

						"WHERE pacientes.provresi = provincias.codprov "
						+ "AND pacientes.poblares = poblacion.codpobla "
						//+ "AND poblacion.codiprov = pacientes.provresi "
						+ "AND pacientes.numerohc = bdu_nuhsa.numerohc "
						+ "AND pacientes.numerohc = " + nhc);

		PacienteAplDto resultado = (PacienteAplDto) consultarDtoFromSQL(sql
				.toString(), PacienteAplDto.class);

		if (resultado != null)
			return resultado;
		else
			return new PacienteAplDto();
	}

	public PacienteAplDto getPacientesByNHC_NoConc(String nhc)
			throws DAOException {

		StringBuffer sql = new StringBuffer();
		sql
				.append("SELECT "
						+ "pacientes.numerohc nhc, "
						+ "pacientes.nombre nombre, "
						+ "pacientes.apellid1 apellid1, "
						+ "pacientes.apellid2 apellid2, "
						+ "pacientes.sexo sexo, "
						+ "pacientes.fechanac fechaNaci, "
						+ "provincias.descprov provincia, "
						+ "poblacion.nompobla poblacion, "
						+ "pacientes.domiresi direccion, "
						+ "pacientes.codipost cp, "
						+ "pacientes.dni dni, "
						+ "pacientes.telefono telefono1, "
						+ "pacientes.numeross1||pacientes.numeross2||pacientes.numeross3 nss1 "
						+

						"FROM pacientes, provincias, poblacion " +

						"WHERE pacientes.provresi = provincias.codprov "
						+ "AND pacientes.poblares = poblacion.codpobla "
						+ "AND pacientes.numerohc = " + nhc);

		PacienteAplDto resultado = (PacienteAplDto) consultarDtoFromSQL(sql
				.toString(), PacienteAplDto.class);

		if (resultado != null)
			return resultado;
		else
			return new PacienteAplDto();
	}

	public ArrayList<PacienteAplDto> getPacientesByFiltro_Conciliado(
			PacienteAplDto filtro) throws DAOException {

		StringBuffer sql = new StringBuffer();
		sql
				.append("SELECT "
						+ "bdu_nuhsa.nuhsa nuhsa, "
						+ "pacientes.numerohc nhc, "
						+ "pacientes.nombre nombre, "
						+ "pacientes.apellid1 apellid1, "
						+ "pacientes.apellid2 apellid2, "
						+ "pacientes.sexo sexo, "
						+ "pacientes.fechanac fechaNaci, "
						+ "provincias.descprov provincia, "
						+ "poblacion.nompobla poblacion, "
						+ "pacientes.domiresi direccion, "
						+ "pacientes.codipost cp, "
						+ "pacientes.dni dni, "
						+ "pacientes.telefono telefono1, "
						+ "pacientes.numeross1||pacientes.numeross2||pacientes.numeross3 nss1 "
						+ "FROM pacientes, bdu_nuhsa, provincias, poblacion "
						+ "WHERE pacientes.provresi = provincias.codprov "
						//+ "AND pacientes.provresi = poblacion.codiprov "
						+ "AND pacientes.poblares = poblacion.codpobla "
						+ "AND pacientes.numerohc = bdu_nuhsa.numerohc ");
		if (filtro != null) {
			if (filtro.getNhc() != null && filtro.getNhc().length() > 0)
				sql.append("AND pacientes.numerohc = " + filtro.getNhc());
			if (filtro.getDni() != null && filtro.getDni().length() > 0)
				sql.append(" AND pacientes.dni = " + filtro.getDni() + " ");
			if (filtro.getApellid1() != null
					&& filtro.getApellid1().length() > 0)
				sql.append(" AND pacientes.apellid1 matches '"
						+ filtro.getApellid1().toUpperCase() + "*'");
			if (filtro.getApellid2() != null
					&& filtro.getApellid2().length() > 0)
				sql.append(" AND pacientes.apellid2 matches '"
						+ filtro.getApellid2().toUpperCase() + "*'");
			if (filtro.getNombre() != null && filtro.getNombre().length() > 0)
				sql.append(" AND pacientes.nombre matches '"
						+ filtro.getNombre().toUpperCase() + "*'");
		}

		ArrayList<PacienteAplDto> resultado = (ArrayList<PacienteAplDto>) consultarDtosFromSQL(
				sql.toString(), PacienteAplDto.class);

		if (resultado != null)
			return resultado;
		else
			return new ArrayList<PacienteAplDto>();
	}

	public ArrayList<PacienteAplDto> getPacientesByFiltro_NoConc(
			PacienteAplDto filtro) throws DAOException {

		StringBuffer sql = new StringBuffer();
		sql
				.append("SELECT "
						+ "pacientes.numerohc nhc, "
						+ "pacientes.nombre nombre, "
						+ "pacientes.apellid1 apellid1, "
						+ "pacientes.apellid2 apellid2, "
						+ "pacientes.sexo sexo, "
						+ "pacientes.fechanac fechaNaci, "
						+ "provincias.descprov provincia, "
						+ "poblacion.nompobla poblacion, "
						+ "pacientes.domiresi direccion, "
						+ "pacientes.codipost cp, "
						+ "pacientes.dni dni, "
						+ "pacientes.telefono telefono1, "
						+ "pacientes.numeross1||pacientes.numeross2||pacientes.numeross3 nss1 "
						+ "FROM pacientes, provincias, poblacion "
						+ "WHERE pacientes.provresi = provincias.codprov "
						//+ "AND pacientes.provresi = poblacion.codiprov "
						+ "AND pacientes.poblares = poblacion.codpobla ");
		if (filtro != null) {
			if (filtro.getNhc() != null && filtro.getNhc().length() > 0)
				sql.append("AND pacientes.numerohc = " + filtro.getNhc());
			if (filtro.getDni() != null && filtro.getDni().length() > 0)
				sql.append(" AND pacientes.dni = " + filtro.getDni() + " ");
			if (filtro.getApellid1() != null
					&& filtro.getApellid1().length() > 0)
				sql.append(" AND pacientes.apellid1 matches '"
						+ filtro.getApellid1().toUpperCase() + "*'");
			if (filtro.getApellid2() != null
					&& filtro.getApellid2().length() > 0)
				sql.append(" AND pacientes.apellid2 matches '"
						+ filtro.getApellid2().toUpperCase() + "*'");
			if (filtro.getNombre() != null && filtro.getNombre().length() > 0)
				sql.append(" AND pacientes.nombre matches '"
						+ filtro.getNombre().toUpperCase() + "*'");
		}

		ArrayList<PacienteAplDto> resultado = (ArrayList<PacienteAplDto>) consultarDtosFromSQL(
				sql.toString(), PacienteAplDto.class);

		if (resultado != null)
			return resultado;
		else
			return new ArrayList<PacienteAplDto>();
	}

	public List<EpisodioDto> getEpisodiosHospitalizacion(String nhc)
			throws DAOException {
		StringBuffer sql = new StringBuffer();
		sql
				.append("select numicu numicu,numerohc nhc ,fecha_ingreso fechaEpisodio,");
		sql.append(" fecha_alta fechaFin,servreal unidad,nomserv descriUnidad");
		sql.append(" from histo_paci ,servicios");
		sql.append(" where numerohc  = " + nhc
				+ " and codserv = servreal order by fecha_ingreso desc");

		ArrayList<EpisodioDto> lstTmp = (ArrayList) consultarDtosFromSQL(sql
				.toString(), EpisodioDto.class);
		return lstTmp;
	}

	public ArrayList<EpisodioDto> getEpisodios(String nhc) throws DAOException {
		StringBuffer sql = new StringBuffer();

		sql.append("SELECT numicu numicu,numerohc nhc, dataingr fechaEpisodio");
		sql.append(", datalta fechaFin,servreal unidad, nomserv descriUnidad");
		sql.append(" from ficus, servicios where 1=1");
		sql.append(" and numerohc = " + nhc);
		sql.append(" and servreal = codserv order by 3 desc");

		ArrayList<EpisodioDto> resultado = (ArrayList<EpisodioDto>) consultarDtosFromSQL(
				sql.toString(), EpisodioDto.class);

		return resultado;
	}
	
	public ArrayList<PacienteAplDto> getPacientesByNombreApellidos(
			IntPacientes filtro) throws DAOException {

		StringBuffer sql = new StringBuffer();
		sql
				.append("SELECT "
						+ "pacientes.nhc nhc, "
						+ "pacientes.nombre nombre, "
						+ "pacientes.apellid1 apellid1, "
						+ "pacientes.apellid2 apellid2, "
						+ "pacientes.sexo sexo, "
						+ "pacientes.fechanaci fechaNaci, "
						+ "pacientes.codigo codigo "
						+ "FROM arr_pacientes pacientes "
						+ "WHERE pacientes.nombre like '"+ filtro.getNombre().toUpperCase() + "%'");
		if (filtro != null) {
			if (filtro.getNhc() != null && filtro.getNhc().length() > 0)
				sql.append("AND pacientes.nhc = " + filtro.getNhc());
			if (filtro.getApellidos() != null
					&& filtro.getApellidos().length() > 0)
				sql.append(" AND pacientes.apellid1 like '"
						+ filtro.getApellidos().toUpperCase() + "%'");
			if (filtro.getApellido2() != null
					&& filtro.getApellido2().length() > 0)
				sql.append(" AND pacientes.apellid2 like '"
						+ filtro.getApellido2().toUpperCase() + "%'");
		}

		ArrayList<PacienteAplDto> resultado = (ArrayList<PacienteAplDto>) consultarDtosFromSQL(
				sql.toString(), PacienteAplDto.class);

		if (resultado != null)
			return resultado;
		else
			return new ArrayList<PacienteAplDto>();
	} 

}

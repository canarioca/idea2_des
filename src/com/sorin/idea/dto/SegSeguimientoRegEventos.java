/*
 * This source file was generated by FireStorm/DAO.
 * 
 * If you purchase a full license for FireStorm/DAO you can customize this header file.
 * 
 * For more information please visit http://www.codefutures.com/products/firestorm
 */

package com.sorin.idea.dto;

import com.sorin.idea.dao.*;
import com.sorin.idea.factory.*;
import com.sorin.idea.exceptions.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

public class SegSeguimientoRegEventos implements Serializable
{
	/** 
	 * This attribute maps to the column IDSEG in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer idseg;

	/** 
	 * This attribute maps to the column IDREGEVENTOS in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer idregeventos;

	/** 
	 * This attribute maps to the column FECHA in the seg_seguimiento_reg_eventos table.
	 */
	protected Date fecha;

	/** 
	 * This attribute maps to the column OPERADOR_MEDICO in the seg_seguimiento_reg_eventos table.
	 */
	protected String operadorMedico;

	/** 
	 * This attribute maps to the column OPERADOR_ENFERMERIA in the seg_seguimiento_reg_eventos table.
	 */
	protected String operadorEnfermeria;

	/** 
	 * This attribute maps to the column MOTIVO in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer motivo;

	/** 
	 * This attribute maps to the column REMOTO in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer remoto;

	/** 
	 * This attribute maps to the column TIPOSEGUIMIENTO in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer tiposeguimiento;

	/** 
	 * This attribute maps to the column ACTIVACION in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer activacion;

	/** 
	 * This attribute maps to the column ESTADOBATERIA in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer estadobateria;

	/** 
	 * This attribute maps to the column EV_RITMOSINUSAL in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer evRitmosinusal;

	/** 
	 * This attribute maps to the column EV_PAUSA in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer evPausa;

	/** 
	 * This attribute maps to the column EV_BAV in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer evBav;

	/** 
	 * This attribute maps to the column EV_TPSV in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer evTpsv;

	/** 
	 * This attribute maps to the column EV_TV in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer evTv;

	/** 
	 * This attribute maps to the column EV_FV in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer evFv;

	/** 
	 * This attribute maps to the column EV_OTROS in the seg_seguimiento_reg_eventos table.
	 */
	protected Integer evOtros;

	/** 
	 * This attribute maps to the column TIEMPO_FA in the seg_seguimiento_reg_eventos table.
	 */
	protected String tiempoFa;

	/** 
	 * This attribute maps to the column OBSERVACIONES in the seg_seguimiento_reg_eventos table.
	 */
	protected String observaciones;

	/** 
	 * This attribute maps to the column COMENTARIOS_INTERNOS in the seg_seguimiento_reg_eventos table.
	 */
	protected String comentariosInternos;

	/** 
	 * This attribute maps to the column DESCRIPCIONOTROS in the seg_seguimiento_reg_eventos table.
	 */
	protected String descripcionotros;
	
	private boolean segrem;
	private String modelo;
	private String nserie;
	private Date fechaimp;

	/**
	 * Method 'SegSeguimientoRegEventos'
	 * 
	 */
	public SegSeguimientoRegEventos()
	{
	}

	/**
	 * Method 'getIdseg'
	 * 
	 * @return Integer
	 */
	public Integer getIdseg()
	{
		return idseg;
	}

	/**
	 * Method 'setIdseg'
	 * 
	 * @param idseg
	 */
	public void setIdseg(Integer idseg)
	{
		this.idseg = idseg;
	}

	/**
	 * Method 'getIdregeventos'
	 * 
	 * @return Integer
	 */
	public Integer getIdregeventos()
	{
		return idregeventos;
	}

	/**
	 * Method 'setIdregeventos'
	 * 
	 * @param idregeventos
	 */
	public void setIdregeventos(Integer idregeventos)
	{
		this.idregeventos = idregeventos;
	}

	/**
	 * Method 'getFecha'
	 * 
	 * @return Date
	 */
	public Date getFecha()
	{
		return fecha;
	}

	/**
	 * Method 'setFecha'
	 * 
	 * @param fecha
	 */
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}

	/**
	 * Method 'getOperadorMedico'
	 * 
	 * @return String
	 */
	public String getOperadorMedico()
	{
		return operadorMedico;
	}

	/**
	 * Method 'setOperadorMedico'
	 * 
	 * @param operadorMedico
	 */
	public void setOperadorMedico(String operadorMedico)
	{
		this.operadorMedico = operadorMedico;
	}

	/**
	 * Method 'getOperadorEnfermeria'
	 * 
	 * @return String
	 */
	public String getOperadorEnfermeria()
	{
		return operadorEnfermeria;
	}

	/**
	 * Method 'setOperadorEnfermeria'
	 * 
	 * @param operadorEnfermeria
	 */
	public void setOperadorEnfermeria(String operadorEnfermeria)
	{
		this.operadorEnfermeria = operadorEnfermeria;
	}

	/**
	 * Method 'getMotivo'
	 * 
	 * @return Integer
	 */
	public Integer getMotivo()
	{
		return motivo;
	}

	/**
	 * Method 'setMotivo'
	 * 
	 * @param motivo
	 */
	public void setMotivo(Integer motivo)
	{
		this.motivo = motivo;
	}

	/**
	 * Method 'getRemoto'
	 * 
	 * @return Integer
	 */
	public Integer getRemoto()
	{
		return remoto;
	}

	/**
	 * Method 'setRemoto'
	 * 
	 * @param remoto
	 */
	public void setRemoto(Integer remoto)
	{
		this.remoto = remoto;
	}

	/**
	 * Method 'getTiposeguimiento'
	 * 
	 * @return Integer
	 */
	public Integer getTiposeguimiento()
	{
		return tiposeguimiento;
	}

	/**
	 * Method 'setTiposeguimiento'
	 * 
	 * @param tiposeguimiento
	 */
	public void setTiposeguimiento(Integer tiposeguimiento)
	{
		this.tiposeguimiento = tiposeguimiento;
	}

	/**
	 * Method 'getActivacion'
	 * 
	 * @return Integer
	 */
	public Integer getActivacion()
	{
		return activacion;
	}

	/**
	 * Method 'setActivacion'
	 * 
	 * @param activacion
	 */
	public void setActivacion(Integer activacion)
	{
		this.activacion = activacion;
	}

	/**
	 * Method 'getEstadobateria'
	 * 
	 * @return Integer
	 */
	public Integer getEstadobateria()
	{
		return estadobateria;
	}

	/**
	 * Method 'setEstadobateria'
	 * 
	 * @param estadobateria
	 */
	public void setEstadobateria(Integer estadobateria)
	{
		this.estadobateria = estadobateria;
	}

	/**
	 * Method 'getEvRitmosinusal'
	 * 
	 * @return Integer
	 */
	public Integer getEvRitmosinusal()
	{
		return evRitmosinusal;
	}

	/**
	 * Method 'setEvRitmosinusal'
	 * 
	 * @param evRitmosinusal
	 */
	public void setEvRitmosinusal(Integer evRitmosinusal)
	{
		this.evRitmosinusal = evRitmosinusal;
	}

	/**
	 * Method 'getEvPausa'
	 * 
	 * @return Integer
	 */
	public Integer getEvPausa()
	{
		return evPausa;
	}

	/**
	 * Method 'setEvPausa'
	 * 
	 * @param evPausa
	 */
	public void setEvPausa(Integer evPausa)
	{
		this.evPausa = evPausa;
	}

	/**
	 * Method 'getEvBav'
	 * 
	 * @return Integer
	 */
	public Integer getEvBav()
	{
		return evBav;
	}

	/**
	 * Method 'setEvBav'
	 * 
	 * @param evBav
	 */
	public void setEvBav(Integer evBav)
	{
		this.evBav = evBav;
	}

	/**
	 * Method 'getEvTpsv'
	 * 
	 * @return Integer
	 */
	public Integer getEvTpsv()
	{
		return evTpsv;
	}

	/**
	 * Method 'setEvTpsv'
	 * 
	 * @param evTpsv
	 */
	public void setEvTpsv(Integer evTpsv)
	{
		this.evTpsv = evTpsv;
	}

	/**
	 * Method 'getEvTv'
	 * 
	 * @return Integer
	 */
	public Integer getEvTv()
	{
		return evTv;
	}

	/**
	 * Method 'setEvTv'
	 * 
	 * @param evTv
	 */
	public void setEvTv(Integer evTv)
	{
		this.evTv = evTv;
	}

	/**
	 * Method 'getEvFv'
	 * 
	 * @return Integer
	 */
	public Integer getEvFv()
	{
		return evFv;
	}

	/**
	 * Method 'setEvFv'
	 * 
	 * @param evFv
	 */
	public void setEvFv(Integer evFv)
	{
		this.evFv = evFv;
	}

	/**
	 * Method 'getEvOtros'
	 * 
	 * @return Integer
	 */
	public Integer getEvOtros()
	{
		return evOtros;
	}

	/**
	 * Method 'setEvOtros'
	 * 
	 * @param evOtros
	 */
	public void setEvOtros(Integer evOtros)
	{
		this.evOtros = evOtros;
	}

	/**
	 * Method 'getTiempoFa'
	 * 
	 * @return String
	 */
	public String getTiempoFa()
	{
		return tiempoFa;
	}

	/**
	 * Method 'setTiempoFa'
	 * 
	 * @param tiempoFa
	 */
	public void setTiempoFa(String tiempoFa)
	{
		this.tiempoFa = tiempoFa;
	}

	/**
	 * Method 'getObservaciones'
	 * 
	 * @return String
	 */
	public String getObservaciones()
	{
		return observaciones;
	}

	/**
	 * Method 'setObservaciones'
	 * 
	 * @param observaciones
	 */
	public void setObservaciones(String observaciones)
	{
		this.observaciones = observaciones;
	}

	/**
	 * Method 'getComentariosInternos'
	 * 
	 * @return String
	 */
	public String getComentariosInternos()
	{
		return comentariosInternos;
	}

	/**
	 * Method 'setComentariosInternos'
	 * 
	 * @param comentariosInternos
	 */
	public void setComentariosInternos(String comentariosInternos)
	{
		this.comentariosInternos = comentariosInternos;
	}

	/**
	 * Method 'getDescripcionotros'
	 * 
	 * @return String
	 */
	public String getDescripcionotros()
	{
		return descripcionotros;
	}

	/**
	 * Method 'setDescripcionotros'
	 * 
	 * @param descripcionotros
	 */
	public void setDescripcionotros(String descripcionotros)
	{
		this.descripcionotros = descripcionotros;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SegSeguimientoRegEventos)) {
			return false;
		}
		
		final SegSeguimientoRegEventos _cast = (SegSeguimientoRegEventos) _other;
		if (idseg == null ? _cast.idseg != idseg : !idseg.equals( _cast.idseg )) {
			return false;
		}
		
		if (idregeventos == null ? _cast.idregeventos != idregeventos : !idregeventos.equals( _cast.idregeventos )) {
			return false;
		}
		
		if (fecha == null ? _cast.fecha != fecha : !fecha.equals( _cast.fecha )) {
			return false;
		}
		
		if (operadorMedico == null ? _cast.operadorMedico != operadorMedico : !operadorMedico.equals( _cast.operadorMedico )) {
			return false;
		}
		
		if (operadorEnfermeria == null ? _cast.operadorEnfermeria != operadorEnfermeria : !operadorEnfermeria.equals( _cast.operadorEnfermeria )) {
			return false;
		}
		
		if (motivo == null ? _cast.motivo != motivo : !motivo.equals( _cast.motivo )) {
			return false;
		}
		
		if (remoto == null ? _cast.remoto != remoto : !remoto.equals( _cast.remoto )) {
			return false;
		}
		
		if (tiposeguimiento == null ? _cast.tiposeguimiento != tiposeguimiento : !tiposeguimiento.equals( _cast.tiposeguimiento )) {
			return false;
		}
		
		if (activacion == null ? _cast.activacion != activacion : !activacion.equals( _cast.activacion )) {
			return false;
		}
		
		if (estadobateria == null ? _cast.estadobateria != estadobateria : !estadobateria.equals( _cast.estadobateria )) {
			return false;
		}
		
		if (evRitmosinusal == null ? _cast.evRitmosinusal != evRitmosinusal : !evRitmosinusal.equals( _cast.evRitmosinusal )) {
			return false;
		}
		
		if (evPausa == null ? _cast.evPausa != evPausa : !evPausa.equals( _cast.evPausa )) {
			return false;
		}
		
		if (evBav == null ? _cast.evBav != evBav : !evBav.equals( _cast.evBav )) {
			return false;
		}
		
		if (evTpsv == null ? _cast.evTpsv != evTpsv : !evTpsv.equals( _cast.evTpsv )) {
			return false;
		}
		
		if (evTv == null ? _cast.evTv != evTv : !evTv.equals( _cast.evTv )) {
			return false;
		}
		
		if (evFv == null ? _cast.evFv != evFv : !evFv.equals( _cast.evFv )) {
			return false;
		}
		
		if (evOtros == null ? _cast.evOtros != evOtros : !evOtros.equals( _cast.evOtros )) {
			return false;
		}
		
		if (tiempoFa == null ? _cast.tiempoFa != tiempoFa : !tiempoFa.equals( _cast.tiempoFa )) {
			return false;
		}
		
		if (observaciones == null ? _cast.observaciones != observaciones : !observaciones.equals( _cast.observaciones )) {
			return false;
		}
		
		if (comentariosInternos == null ? _cast.comentariosInternos != comentariosInternos : !comentariosInternos.equals( _cast.comentariosInternos )) {
			return false;
		}
		
		if (descripcionotros == null ? _cast.descripcionotros != descripcionotros : !descripcionotros.equals( _cast.descripcionotros )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (idseg != null) {
			_hashCode = 29 * _hashCode + idseg.hashCode();
		}
		
		if (idregeventos != null) {
			_hashCode = 29 * _hashCode + idregeventos.hashCode();
		}
		
		if (fecha != null) {
			_hashCode = 29 * _hashCode + fecha.hashCode();
		}
		
		if (operadorMedico != null) {
			_hashCode = 29 * _hashCode + operadorMedico.hashCode();
		}
		
		if (operadorEnfermeria != null) {
			_hashCode = 29 * _hashCode + operadorEnfermeria.hashCode();
		}
		
		if (motivo != null) {
			_hashCode = 29 * _hashCode + motivo.hashCode();
		}
		
		if (remoto != null) {
			_hashCode = 29 * _hashCode + remoto.hashCode();
		}
		
		if (tiposeguimiento != null) {
			_hashCode = 29 * _hashCode + tiposeguimiento.hashCode();
		}
		
		if (activacion != null) {
			_hashCode = 29 * _hashCode + activacion.hashCode();
		}
		
		if (estadobateria != null) {
			_hashCode = 29 * _hashCode + estadobateria.hashCode();
		}
		
		if (evRitmosinusal != null) {
			_hashCode = 29 * _hashCode + evRitmosinusal.hashCode();
		}
		
		if (evPausa != null) {
			_hashCode = 29 * _hashCode + evPausa.hashCode();
		}
		
		if (evBav != null) {
			_hashCode = 29 * _hashCode + evBav.hashCode();
		}
		
		if (evTpsv != null) {
			_hashCode = 29 * _hashCode + evTpsv.hashCode();
		}
		
		if (evTv != null) {
			_hashCode = 29 * _hashCode + evTv.hashCode();
		}
		
		if (evFv != null) {
			_hashCode = 29 * _hashCode + evFv.hashCode();
		}
		
		if (evOtros != null) {
			_hashCode = 29 * _hashCode + evOtros.hashCode();
		}
		
		if (tiempoFa != null) {
			_hashCode = 29 * _hashCode + tiempoFa.hashCode();
		}
		
		if (observaciones != null) {
			_hashCode = 29 * _hashCode + observaciones.hashCode();
		}
		
		if (comentariosInternos != null) {
			_hashCode = 29 * _hashCode + comentariosInternos.hashCode();
		}
		
		if (descripcionotros != null) {
			_hashCode = 29 * _hashCode + descripcionotros.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SegSeguimientoRegEventosPk
	 */
	public SegSeguimientoRegEventosPk createPk()
	{
		return new SegSeguimientoRegEventosPk(idseg);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.sorin.idea.dto.SegSeguimientoRegEventos: " );
		ret.append( "idseg=" + idseg );
		ret.append( ", idregeventos=" + idregeventos );
		ret.append( ", fecha=" + fecha );
		ret.append( ", operadorMedico=" + operadorMedico );
		ret.append( ", operadorEnfermeria=" + operadorEnfermeria );
		ret.append( ", motivo=" + motivo );
		ret.append( ", remoto=" + remoto );
		ret.append( ", tiposeguimiento=" + tiposeguimiento );
		ret.append( ", activacion=" + activacion );
		ret.append( ", estadobateria=" + estadobateria );
		ret.append( ", evRitmosinusal=" + evRitmosinusal );
		ret.append( ", evPausa=" + evPausa );
		ret.append( ", evBav=" + evBav );
		ret.append( ", evTpsv=" + evTpsv );
		ret.append( ", evTv=" + evTv );
		ret.append( ", evFv=" + evFv );
		ret.append( ", evOtros=" + evOtros );
		ret.append( ", tiempoFa=" + tiempoFa );
		ret.append( ", observaciones=" + observaciones );
		ret.append( ", comentariosInternos=" + comentariosInternos );
		ret.append( ", descripcionotros=" + descripcionotros );
		return ret.toString();
	}
	
	public boolean isSegrem() {
		return segrem;
	}

	public void setSegrem(boolean segrem) {
		this.segrem = segrem;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNserie() {
		return nserie;
	}

	public void setNserie(String nserie) {
		this.nserie = nserie;
	}

	public Date getFechaimp() {
		return fechaimp;
	}

	public void setFechaimp(Date fechaimp) {
		this.fechaimp = fechaimp;
	}

}

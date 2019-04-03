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

public class ImpImplanteElectrodos implements Serializable
{
	/** 
	 * This attribute maps to the column IDIMPELECTRODOS in the imp_implante_electrodos table.
	 */
	protected Integer idimpelectrodos;

	/** 
	 * This attribute maps to the column IDELECTRODO in the imp_implante_electrodos table.
	 */
	protected Integer idelectrodo;

	/** 
	 * This attribute maps to the column NUMSERIE in the imp_implante_electrodos table.
	 */
	protected String numserie;

	/** 
	 * This attribute maps to the column IDHOJAIMP in the imp_implante_electrodos table.
	 */
	protected Integer idhojaimp;

	/** 
	 * This attribute maps to the column IDEVOLUCION in the imp_implante_electrodos table.
	 */
	protected Integer idevolucion;

	/** 
	 * This attribute maps to the column IDSEG in the imp_implante_electrodos table.
	 */
	protected Integer idseg;

	/** 
	 * This attribute maps to the column ONDARP_IMP in the imp_implante_electrodos table.
	 */
	protected String ondarpImp;

	/** 
	 * This attribute maps to the column UMBRALV_IMP in the imp_implante_electrodos table.
	 */
	protected String umbralvImp;

	/** 
	 * This attribute maps to the column UMBRALMS_IMP in the imp_implante_electrodos table.
	 */
	protected String umbralmsImp;

	/** 
	 * This attribute maps to the column SLEWRATE in the imp_implante_electrodos table.
	 */
	protected String slewrate;

	/** 
	 * This attribute maps to the column IMPOHM_IMP in the imp_implante_electrodos table.
	 */
	protected String impohmImp;

	/** 
	 * This attribute maps to the column IMPMS_IMP in the imp_implante_electrodos table.
	 */
	protected String impmsImp;

	/** 
	 * This attribute maps to the column IMPV_IMP in the imp_implante_electrodos table.
	 */
	protected String impvImp;

	/** 
	 * This attribute maps to the column ESTIMFREN in the imp_implante_electrodos table.
	 */
	protected String estimfren;

	/** 
	 * This attribute maps to the column MOTIVOEXABAND in the imp_implante_electrodos table.
	 */
	protected Integer motivoexaband;

	/** 
	 * This attribute maps to the column MOTIVORECAMBIO in the imp_implante_electrodos table.
	 */
	protected Integer motivorecambio;

	/** 
	 * This attribute maps to the column MOTIVORECOLOCACION in the imp_implante_electrodos table.
	 */
	protected Integer motivorecolocacion;

	/** 
	 * This attribute maps to the column TIPOELECTRODO in the imp_implante_electrodos table.
	 */
	protected String tipoelectrodo;

	/** 
	 * This attribute maps to the column DURIMPULSO in the imp_implante_electrodos table.
	 */
	protected String durimpulso;

	/** 
	 * This attribute maps to the column VOLTAJE in the imp_implante_electrodos table.
	 */
	protected String voltaje;

	/** 
	 * This attribute maps to the column SENSIBILIDAD in the imp_implante_electrodos table.
	 */
	protected String sensibilidad;

	/** 
	 * This attribute maps to the column POLDETECCION in the imp_implante_electrodos table.
	 */
	protected String poldeteccion;

	/** 
	 * This attribute maps to the column POLESTIMULACION in the imp_implante_electrodos table.
	 */
	protected String polestimulacion;

	/** 
	 * This attribute maps to the column CAPTURAAUTO in the imp_implante_electrodos table.
	 */
	protected Short capturaauto;

	/** 
	 * This attribute maps to the column ONDARP_EV in the imp_implante_electrodos table.
	 */
	protected String ondarpEv;

	/** 
	 * This attribute maps to the column UMBRALV_EV in the imp_implante_electrodos table.
	 */
	protected String umbralvEv;

	/** 
	 * This attribute maps to the column UMBRALMS_EV in the imp_implante_electrodos table.
	 */
	protected String umbralmsEv;

	/** 
	 * This attribute maps to the column IMPOHM_EV in the imp_implante_electrodos table.
	 */
	protected String impohmEv;

	/** 
	 * This attribute maps to the column IMPV_EV in the imp_implante_electrodos table.
	 */
	protected String impvEv;

	/** 
	 * This attribute maps to the column IMPMS_EV in the imp_implante_electrodos table.
	 */
	protected String impmsEv;

	/** 
	 * This attribute maps to the column VIA in the imp_implante_electrodos table.
	 */
	protected Integer via;

	/** 
	 * This attribute maps to the column LATERALIDAD in the imp_implante_electrodos table.
	 */
	protected Integer lateralidad;

	/** 
	 * This attribute maps to the column CAMARA in the imp_implante_electrodos table.
	 */
	protected Integer camara;

	/** 
	 * This attribute maps to the column ZONACAMARA in the imp_implante_electrodos table.
	 */
	protected Integer zonacamara;

	/** 
	 * This attribute maps to the column PORCION in the imp_implante_electrodos table.
	 */
	protected Integer porcion;

	/** 
	 * This attribute maps to the column ESTADO in the imp_implante_electrodos table.
	 */
	protected Integer estado;

	/** 
	 * This attribute maps to the column CARACTER in the imp_implante_electrodos table.
	 */
	protected Integer caracter;

	/** 
	 * This attribute maps to the column VECTORVI1 in the imp_implante_electrodos table.
	 */
	protected Integer vectorvi1;

	/** 
	 * This attribute maps to the column VECTORVI2 in the imp_implante_electrodos table.
	 */
	protected Integer vectorvi2;

	/** 
	 * This attribute maps to the column FECHAIMPLANTE in the imp_implante_electrodos table.
	 */
	protected Date fechaimplante;

	/** 
	 * This attribute maps to the column FECHAMOD in the imp_implante_electrodos table.
	 */
	protected Date fechamod;

	/** 
	 * This attribute maps to the column IMPOHMDESFIB_IMP in the imp_implante_electrodos table.
	 */
	protected String impohmdesfibImp;

	/** 
	 * This attribute maps to the column IMPOHMDESFIB_EV in the imp_implante_electrodos table.
	 */
	protected String impohmdesfibEv;
	
	protected String idelec;
	protected String abordajetexto;
	protected boolean estimfrenok;
	protected boolean cambiaabordaje;
	protected boolean eliminar;
	protected Integer idaux;
	protected boolean recambio;
	protected String barcode;
	protected String nombremodelo;
	protected boolean muestrabarcode;
	protected String conector;
	protected String fabricante;
	protected String polaridad;
	protected boolean vdd;
	protected boolean previo;
	protected boolean f_modificada;
	protected String nserieprev;
	protected Integer idelectrodoprev;
	protected boolean vddprev;

	/**
	 * Method 'ImpImplanteElectrodos'
	 * 
	 */
	public ImpImplanteElectrodos()
	{
		// Inicia estado activo (0) y caracter activo (0)
		this.setEstado(0);
		this.setCaracter(0);
		this.setMuestrabarcode(true);
		this.setVdd(false);
		this.setFechaimplante(new Date());
		this.setPrevio(false);
	}

	/**
	 * Method 'getIdimpelectrodos'
	 * 
	 * @return Integer
	 */
	public Integer getIdimpelectrodos()
	{
		return idimpelectrodos;
	}

	/**
	 * Method 'setIdimpelectrodos'
	 * 
	 * @param idimpelectrodos
	 */
	public void setIdimpelectrodos(Integer idimpelectrodos)
	{
		this.idimpelectrodos = idimpelectrodos;
	}

	/**
	 * Method 'getIdelectrodo'
	 * 
	 * @return Integer
	 */
	public Integer getIdelectrodo()
	{
		return idelectrodo;
	}

	/**
	 * Method 'setIdelectrodo'
	 * 
	 * @param idelectrodo
	 */
	public void setIdelectrodo(Integer idelectrodo)
	{
		this.idelectrodo = idelectrodo;
	}

	/**
	 * Method 'getNumserie'
	 * 
	 * @return String
	 */
	public String getNumserie()
	{
		return numserie;
	}

	/**
	 * Method 'setNumserie'
	 * 
	 * @param numserie
	 */
	public void setNumserie(String numserie)
	{
		this.numserie = numserie;
	}

	/**
	 * Method 'getIdhojaimp'
	 * 
	 * @return Integer
	 */
	public Integer getIdhojaimp()
	{
		return idhojaimp;
	}

	/**
	 * Method 'setIdhojaimp'
	 * 
	 * @param idhojaimp
	 */
	public void setIdhojaimp(Integer idhojaimp)
	{
		this.idhojaimp = idhojaimp;
	}

	/**
	 * Method 'getIdevolucion'
	 * 
	 * @return Integer
	 */
	public Integer getIdevolucion()
	{
		return idevolucion;
	}

	/**
	 * Method 'setIdevolucion'
	 * 
	 * @param idevolucion
	 */
	public void setIdevolucion(Integer idevolucion)
	{
		this.idevolucion = idevolucion;
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
	 * Method 'getOndarpImp'
	 * 
	 * @return String
	 */
	public String getOndarpImp()
	{
		return ondarpImp;
	}

	/**
	 * Method 'setOndarpImp'
	 * 
	 * @param ondarpImp
	 */
	public void setOndarpImp(String ondarpImp)
	{
		this.ondarpImp = ondarpImp;
	}

	/**
	 * Method 'getUmbralvImp'
	 * 
	 * @return String
	 */
	public String getUmbralvImp()
	{
		return umbralvImp;
	}

	/**
	 * Method 'setUmbralvImp'
	 * 
	 * @param umbralvImp
	 */
	public void setUmbralvImp(String umbralvImp)
	{
		this.umbralvImp = umbralvImp;
	}

	/**
	 * Method 'getUmbralmsImp'
	 * 
	 * @return String
	 */
	public String getUmbralmsImp()
	{
		return umbralmsImp;
	}

	/**
	 * Method 'setUmbralmsImp'
	 * 
	 * @param umbralmsImp
	 */
	public void setUmbralmsImp(String umbralmsImp)
	{
		this.umbralmsImp = umbralmsImp;
	}

	/**
	 * Method 'getSlewrate'
	 * 
	 * @return String
	 */
	public String getSlewrate()
	{
		return slewrate;
	}

	/**
	 * Method 'setSlewrate'
	 * 
	 * @param slewrate
	 */
	public void setSlewrate(String slewrate)
	{
		this.slewrate = slewrate;
	}

	/**
	 * Method 'getImpohmImp'
	 * 
	 * @return String
	 */
	public String getImpohmImp()
	{
		return impohmImp;
	}

	/**
	 * Method 'setImpohmImp'
	 * 
	 * @param impohmImp
	 */
	public void setImpohmImp(String impohmImp)
	{
		this.impohmImp = impohmImp;
	}

	/**
	 * Method 'getImpmsImp'
	 * 
	 * @return String
	 */
	public String getImpmsImp()
	{
		return impmsImp;
	}

	/**
	 * Method 'setImpmsImp'
	 * 
	 * @param impmsImp
	 */
	public void setImpmsImp(String impmsImp)
	{
		this.impmsImp = impmsImp;
	}

	/**
	 * Method 'getImpvImp'
	 * 
	 * @return String
	 */
	public String getImpvImp()
	{
		return impvImp;
	}

	/**
	 * Method 'setImpvImp'
	 * 
	 * @param impvImp
	 */
	public void setImpvImp(String impvImp)
	{
		this.impvImp = impvImp;
	}

	/**
	 * Method 'getEstimfren'
	 * 
	 * @return String
	 */
	public String getEstimfren()
	{
		return estimfren;
	}

	/**
	 * Method 'setEstimfren'
	 * 
	 * @param estimfren
	 */
	public void setEstimfren(String estimfren)
	{
		this.estimfren = estimfren;
	}

	/**
	 * Method 'getMotivoexaband'
	 * 
	 * @return Integer
	 */
	public Integer getMotivoexaband()
	{
		return motivoexaband;
	}

	/**
	 * Method 'setMotivoexaband'
	 * 
	 * @param motivoexaband
	 */
	public void setMotivoexaband(Integer motivoexaband)
	{
		this.motivoexaband = motivoexaband;
	}

	/**
	 * Method 'getMotivorecambio'
	 * 
	 * @return Integer
	 */
	public Integer getMotivorecambio()
	{
		return motivorecambio;
	}

	/**
	 * Method 'setMotivorecambio'
	 * 
	 * @param motivorecambio
	 */
	public void setMotivorecambio(Integer motivorecambio)
	{
		this.motivorecambio = motivorecambio;
	}

	/**
	 * Method 'getMotivorecolocacion'
	 * 
	 * @return Integer
	 */
	public Integer getMotivorecolocacion()
	{
		return motivorecolocacion;
	}

	/**
	 * Method 'setMotivorecolocacion'
	 * 
	 * @param motivorecolocacion
	 */
	public void setMotivorecolocacion(Integer motivorecolocacion)
	{
		this.motivorecolocacion = motivorecolocacion;
	}

	/**
	 * Method 'getTipoelectrodo'
	 * 
	 * @return String
	 */
	public String getTipoelectrodo()
	{
		return tipoelectrodo;
	}

	/**
	 * Method 'setTipoelectrodo'
	 * 
	 * @param tipoelectrodo
	 */
	public void setTipoelectrodo(String tipoelectrodo)
	{
		this.tipoelectrodo = tipoelectrodo;
	}

	/**
	 * Method 'getDurimpulso'
	 * 
	 * @return String
	 */
	public String getDurimpulso()
	{
		return durimpulso;
	}

	/**
	 * Method 'setDurimpulso'
	 * 
	 * @param durimpulso
	 */
	public void setDurimpulso(String durimpulso)
	{
		this.durimpulso = durimpulso;
	}

	/**
	 * Method 'getVoltaje'
	 * 
	 * @return String
	 */
	public String getVoltaje()
	{
		return voltaje;
	}

	/**
	 * Method 'setVoltaje'
	 * 
	 * @param voltaje
	 */
	public void setVoltaje(String voltaje)
	{
		this.voltaje = voltaje;
	}

	/**
	 * Method 'getSensibilidad'
	 * 
	 * @return String
	 */
	public String getSensibilidad()
	{
		return sensibilidad;
	}

	/**
	 * Method 'setSensibilidad'
	 * 
	 * @param sensibilidad
	 */
	public void setSensibilidad(String sensibilidad)
	{
		this.sensibilidad = sensibilidad;
	}

	/**
	 * Method 'getPoldeteccion'
	 * 
	 * @return String
	 */
	public String getPoldeteccion()
	{
		return poldeteccion;
	}

	/**
	 * Method 'setPoldeteccion'
	 * 
	 * @param poldeteccion
	 */
	public void setPoldeteccion(String poldeteccion)
	{
		this.poldeteccion = poldeteccion;
	}

	/**
	 * Method 'getPolestimulacion'
	 * 
	 * @return String
	 */
	public String getPolestimulacion()
	{
		return polestimulacion;
	}

	/**
	 * Method 'setPolestimulacion'
	 * 
	 * @param polestimulacion
	 */
	public void setPolestimulacion(String polestimulacion)
	{
		this.polestimulacion = polestimulacion;
	}

	/**
	 * Method 'getCapturaauto'
	 * 
	 * @return Short
	 */
	public Short getCapturaauto()
	{
		return capturaauto;
	}

	/**
	 * Method 'setCapturaauto'
	 * 
	 * @param capturaauto
	 */
	public void setCapturaauto(Short capturaauto)
	{
		this.capturaauto = capturaauto;
	}

	/**
	 * Method 'getOndarpEv'
	 * 
	 * @return String
	 */
	public String getOndarpEv()
	{
		return ondarpEv;
	}

	/**
	 * Method 'setOndarpEv'
	 * 
	 * @param ondarpEv
	 */
	public void setOndarpEv(String ondarpEv)
	{
		this.ondarpEv = ondarpEv;
	}

	/**
	 * Method 'getUmbralvEv'
	 * 
	 * @return String
	 */
	public String getUmbralvEv()
	{
		return umbralvEv;
	}

	/**
	 * Method 'setUmbralvEv'
	 * 
	 * @param umbralvEv
	 */
	public void setUmbralvEv(String umbralvEv)
	{
		this.umbralvEv = umbralvEv;
	}

	/**
	 * Method 'getUmbralmsEv'
	 * 
	 * @return String
	 */
	public String getUmbralmsEv()
	{
		return umbralmsEv;
	}

	/**
	 * Method 'setUmbralmsEv'
	 * 
	 * @param umbralmsEv
	 */
	public void setUmbralmsEv(String umbralmsEv)
	{
		this.umbralmsEv = umbralmsEv;
	}

	/**
	 * Method 'getImpohmEv'
	 * 
	 * @return String
	 */
	public String getImpohmEv()
	{
		return impohmEv;
	}

	/**
	 * Method 'setImpohmEv'
	 * 
	 * @param impohmEv
	 */
	public void setImpohmEv(String impohmEv)
	{
		this.impohmEv = impohmEv;
	}

	/**
	 * Method 'getImpvEv'
	 * 
	 * @return String
	 */
	public String getImpvEv()
	{
		return impvEv;
	}

	/**
	 * Method 'setImpvEv'
	 * 
	 * @param impvEv
	 */
	public void setImpvEv(String impvEv)
	{
		this.impvEv = impvEv;
	}

	/**
	 * Method 'getImpmsEv'
	 * 
	 * @return String
	 */
	public String getImpmsEv()
	{
		return impmsEv;
	}

	/**
	 * Method 'setImpmsEv'
	 * 
	 * @param impmsEv
	 */
	public void setImpmsEv(String impmsEv)
	{
		this.impmsEv = impmsEv;
	}

	/**
	 * Method 'getVia'
	 * 
	 * @return Integer
	 */
	public Integer getVia()
	{
		return via;
	}

	/**
	 * Method 'setVia'
	 * 
	 * @param via
	 */
	public void setVia(Integer via)
	{
		this.via = via;
	}

	/**
	 * Method 'getLateralidad'
	 * 
	 * @return Integer
	 */
	public Integer getLateralidad()
	{
		return lateralidad;
	}

	/**
	 * Method 'setLateralidad'
	 * 
	 * @param lateralidad
	 */
	public void setLateralidad(Integer lateralidad)
	{
		this.lateralidad = lateralidad;
	}

	/**
	 * Method 'getCamara'
	 * 
	 * @return Integer
	 */
	public Integer getCamara()
	{
		return camara;
	}

	/**
	 * Method 'setCamara'
	 * 
	 * @param camara
	 */
	public void setCamara(Integer camara)
	{
		this.camara = camara;
	}

	/**
	 * Method 'getZonacamara'
	 * 
	 * @return Integer
	 */
	public Integer getZonacamara()
	{
		return zonacamara;
	}

	/**
	 * Method 'setZonacamara'
	 * 
	 * @param zonacamara
	 */
	public void setZonacamara(Integer zonacamara)
	{
		this.zonacamara = zonacamara;
	}

	/**
	 * Method 'getPorcion'
	 * 
	 * @return Integer
	 */
	public Integer getPorcion()
	{
		return porcion;
	}

	/**
	 * Method 'setPorcion'
	 * 
	 * @param porcion
	 */
	public void setPorcion(Integer porcion)
	{
		this.porcion = porcion;
	}

	/**
	 * Method 'getEstado'
	 * 
	 * @return Integer
	 */
	public Integer getEstado()
	{
		return estado;
	}

	/**
	 * Method 'setEstado'
	 * 
	 * @param estado
	 */
	public void setEstado(Integer estado)
	{
		this.estado = estado;
	}

	/**
	 * Method 'getCaracter'
	 * 
	 * @return Integer
	 */
	public Integer getCaracter()
	{
		return caracter;
	}

	/**
	 * Method 'setCaracter'
	 * 
	 * @param caracter
	 */
	public void setCaracter(Integer caracter)
	{
		this.caracter = caracter;
	}

	/**
	 * Method 'getVectorvi1'
	 * 
	 * @return Integer
	 */
	public Integer getVectorvi1()
	{
		return vectorvi1;
	}

	/**
	 * Method 'setVectorvi1'
	 * 
	 * @param vectorvi1
	 */
	public void setVectorvi1(Integer vectorvi1)
	{
		this.vectorvi1 = vectorvi1;
	}

	/**
	 * Method 'getVectorvi2'
	 * 
	 * @return Integer
	 */
	public Integer getVectorvi2()
	{
		return vectorvi2;
	}

	/**
	 * Method 'setVectorvi2'
	 * 
	 * @param vectorvi2
	 */
	public void setVectorvi2(Integer vectorvi2)
	{
		this.vectorvi2 = vectorvi2;
	}

	/**
	 * Method 'getFechaimplante'
	 * 
	 * @return Date
	 */
	public Date getFechaimplante()
	{
		return fechaimplante;
	}

	/**
	 * Method 'setFechaimplante'
	 * 
	 * @param fechaimplante
	 */
	public void setFechaimplante(Date fechaimplante)
	{
		this.fechaimplante = fechaimplante;
	}

	/**
	 * Method 'getFechamod'
	 * 
	 * @return Date
	 */
	public Date getFechamod()
	{
		return fechamod;
	}

	/**
	 * Method 'setFechamod'
	 * 
	 * @param fechamod
	 */
	public void setFechamod(Date fechamod)
	{
		this.fechamod = fechamod;
	}

	/**
	 * Method 'getImpohmdesfibImp'
	 * 
	 * @return String
	 */
	public String getImpohmdesfibImp()
	{
		return impohmdesfibImp;
	}

	/**
	 * Method 'setImpohmdesfibImp'
	 * 
	 * @param impohmdesfibImp
	 */
	public void setImpohmdesfibImp(String impohmdesfibImp)
	{
		this.impohmdesfibImp = impohmdesfibImp;
	}

	/**
	 * Method 'getImpohmdesfibEv'
	 * 
	 * @return String
	 */
	public String getImpohmdesfibEv()
	{
		return impohmdesfibEv;
	}

	/**
	 * Method 'setImpohmdesfibEv'
	 * 
	 * @param impohmdesfibEv
	 */
	public void setImpohmdesfibEv(String impohmdesfibEv)
	{
		this.impohmdesfibEv = impohmdesfibEv;
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
		
		if (!(_other instanceof ImpImplanteElectrodos)) {
			return false;
		}
		
		final ImpImplanteElectrodos _cast = (ImpImplanteElectrodos) _other;
		if (idimpelectrodos == null ? _cast.idimpelectrodos != idimpelectrodos : !idimpelectrodos.equals( _cast.idimpelectrodos )) {
			return false;
		}
		
		if (idelectrodo == null ? _cast.idelectrodo != idelectrodo : !idelectrodo.equals( _cast.idelectrodo )) {
			return false;
		}
		
		if (numserie == null ? _cast.numserie != numserie : !numserie.equals( _cast.numserie )) {
			return false;
		}
		
		if (idhojaimp == null ? _cast.idhojaimp != idhojaimp : !idhojaimp.equals( _cast.idhojaimp )) {
			return false;
		}
		
		if (idevolucion == null ? _cast.idevolucion != idevolucion : !idevolucion.equals( _cast.idevolucion )) {
			return false;
		}
		
		if (idseg == null ? _cast.idseg != idseg : !idseg.equals( _cast.idseg )) {
			return false;
		}
		
		if (ondarpImp == null ? _cast.ondarpImp != ondarpImp : !ondarpImp.equals( _cast.ondarpImp )) {
			return false;
		}
		
		if (umbralvImp == null ? _cast.umbralvImp != umbralvImp : !umbralvImp.equals( _cast.umbralvImp )) {
			return false;
		}
		
		if (umbralmsImp == null ? _cast.umbralmsImp != umbralmsImp : !umbralmsImp.equals( _cast.umbralmsImp )) {
			return false;
		}
		
		if (slewrate == null ? _cast.slewrate != slewrate : !slewrate.equals( _cast.slewrate )) {
			return false;
		}
		
		if (impohmImp == null ? _cast.impohmImp != impohmImp : !impohmImp.equals( _cast.impohmImp )) {
			return false;
		}
		
		if (impmsImp == null ? _cast.impmsImp != impmsImp : !impmsImp.equals( _cast.impmsImp )) {
			return false;
		}
		
		if (impvImp == null ? _cast.impvImp != impvImp : !impvImp.equals( _cast.impvImp )) {
			return false;
		}
		
		if (estimfren == null ? _cast.estimfren != estimfren : !estimfren.equals( _cast.estimfren )) {
			return false;
		}
		
		if (motivoexaband == null ? _cast.motivoexaband != motivoexaband : !motivoexaband.equals( _cast.motivoexaband )) {
			return false;
		}
		
		if (motivorecambio == null ? _cast.motivorecambio != motivorecambio : !motivorecambio.equals( _cast.motivorecambio )) {
			return false;
		}
		
		if (motivorecolocacion == null ? _cast.motivorecolocacion != motivorecolocacion : !motivorecolocacion.equals( _cast.motivorecolocacion )) {
			return false;
		}
		
		if (tipoelectrodo == null ? _cast.tipoelectrodo != tipoelectrodo : !tipoelectrodo.equals( _cast.tipoelectrodo )) {
			return false;
		}
		
		if (durimpulso == null ? _cast.durimpulso != durimpulso : !durimpulso.equals( _cast.durimpulso )) {
			return false;
		}
		
		if (voltaje == null ? _cast.voltaje != voltaje : !voltaje.equals( _cast.voltaje )) {
			return false;
		}
		
		if (sensibilidad == null ? _cast.sensibilidad != sensibilidad : !sensibilidad.equals( _cast.sensibilidad )) {
			return false;
		}
		
		if (poldeteccion == null ? _cast.poldeteccion != poldeteccion : !poldeteccion.equals( _cast.poldeteccion )) {
			return false;
		}
		
		if (polestimulacion == null ? _cast.polestimulacion != polestimulacion : !polestimulacion.equals( _cast.polestimulacion )) {
			return false;
		}
		
		if (capturaauto == null ? _cast.capturaauto != capturaauto : !capturaauto.equals( _cast.capturaauto )) {
			return false;
		}
		
		if (ondarpEv == null ? _cast.ondarpEv != ondarpEv : !ondarpEv.equals( _cast.ondarpEv )) {
			return false;
		}
		
		if (umbralvEv == null ? _cast.umbralvEv != umbralvEv : !umbralvEv.equals( _cast.umbralvEv )) {
			return false;
		}
		
		if (umbralmsEv == null ? _cast.umbralmsEv != umbralmsEv : !umbralmsEv.equals( _cast.umbralmsEv )) {
			return false;
		}
		
		if (impohmEv == null ? _cast.impohmEv != impohmEv : !impohmEv.equals( _cast.impohmEv )) {
			return false;
		}
		
		if (impvEv == null ? _cast.impvEv != impvEv : !impvEv.equals( _cast.impvEv )) {
			return false;
		}
		
		if (impmsEv == null ? _cast.impmsEv != impmsEv : !impmsEv.equals( _cast.impmsEv )) {
			return false;
		}
		
		if (via == null ? _cast.via != via : !via.equals( _cast.via )) {
			return false;
		}
		
		if (lateralidad == null ? _cast.lateralidad != lateralidad : !lateralidad.equals( _cast.lateralidad )) {
			return false;
		}
		
		if (camara == null ? _cast.camara != camara : !camara.equals( _cast.camara )) {
			return false;
		}
		
		if (zonacamara == null ? _cast.zonacamara != zonacamara : !zonacamara.equals( _cast.zonacamara )) {
			return false;
		}
		
		if (porcion == null ? _cast.porcion != porcion : !porcion.equals( _cast.porcion )) {
			return false;
		}
		
		if (estado == null ? _cast.estado != estado : !estado.equals( _cast.estado )) {
			return false;
		}
		
		if (caracter == null ? _cast.caracter != caracter : !caracter.equals( _cast.caracter )) {
			return false;
		}
		
		if (vectorvi1 == null ? _cast.vectorvi1 != vectorvi1 : !vectorvi1.equals( _cast.vectorvi1 )) {
			return false;
		}
		
		if (vectorvi2 == null ? _cast.vectorvi2 != vectorvi2 : !vectorvi2.equals( _cast.vectorvi2 )) {
			return false;
		}
		
		if (fechaimplante == null ? _cast.fechaimplante != fechaimplante : !fechaimplante.equals( _cast.fechaimplante )) {
			return false;
		}
		
		if (fechamod == null ? _cast.fechamod != fechamod : !fechamod.equals( _cast.fechamod )) {
			return false;
		}
		
		if (impohmdesfibImp == null ? _cast.impohmdesfibImp != impohmdesfibImp : !impohmdesfibImp.equals( _cast.impohmdesfibImp )) {
			return false;
		}
		
		if (impohmdesfibEv == null ? _cast.impohmdesfibEv != impohmdesfibEv : !impohmdesfibEv.equals( _cast.impohmdesfibEv )) {
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
		if (idimpelectrodos != null) {
			_hashCode = 29 * _hashCode + idimpelectrodos.hashCode();
		}
		
		if (idelectrodo != null) {
			_hashCode = 29 * _hashCode + idelectrodo.hashCode();
		}
		
		if (numserie != null) {
			_hashCode = 29 * _hashCode + numserie.hashCode();
		}
		
		if (idhojaimp != null) {
			_hashCode = 29 * _hashCode + idhojaimp.hashCode();
		}
		
		if (idevolucion != null) {
			_hashCode = 29 * _hashCode + idevolucion.hashCode();
		}
		
		if (idseg != null) {
			_hashCode = 29 * _hashCode + idseg.hashCode();
		}
		
		if (ondarpImp != null) {
			_hashCode = 29 * _hashCode + ondarpImp.hashCode();
		}
		
		if (umbralvImp != null) {
			_hashCode = 29 * _hashCode + umbralvImp.hashCode();
		}
		
		if (umbralmsImp != null) {
			_hashCode = 29 * _hashCode + umbralmsImp.hashCode();
		}
		
		if (slewrate != null) {
			_hashCode = 29 * _hashCode + slewrate.hashCode();
		}
		
		if (impohmImp != null) {
			_hashCode = 29 * _hashCode + impohmImp.hashCode();
		}
		
		if (impmsImp != null) {
			_hashCode = 29 * _hashCode + impmsImp.hashCode();
		}
		
		if (impvImp != null) {
			_hashCode = 29 * _hashCode + impvImp.hashCode();
		}
		
		if (estimfren != null) {
			_hashCode = 29 * _hashCode + estimfren.hashCode();
		}
		
		if (motivoexaband != null) {
			_hashCode = 29 * _hashCode + motivoexaband.hashCode();
		}
		
		if (motivorecambio != null) {
			_hashCode = 29 * _hashCode + motivorecambio.hashCode();
		}
		
		if (motivorecolocacion != null) {
			_hashCode = 29 * _hashCode + motivorecolocacion.hashCode();
		}
		
		if (tipoelectrodo != null) {
			_hashCode = 29 * _hashCode + tipoelectrodo.hashCode();
		}
		
		if (durimpulso != null) {
			_hashCode = 29 * _hashCode + durimpulso.hashCode();
		}
		
		if (voltaje != null) {
			_hashCode = 29 * _hashCode + voltaje.hashCode();
		}
		
		if (sensibilidad != null) {
			_hashCode = 29 * _hashCode + sensibilidad.hashCode();
		}
		
		if (poldeteccion != null) {
			_hashCode = 29 * _hashCode + poldeteccion.hashCode();
		}
		
		if (polestimulacion != null) {
			_hashCode = 29 * _hashCode + polestimulacion.hashCode();
		}
		
		if (capturaauto != null) {
			_hashCode = 29 * _hashCode + capturaauto.hashCode();
		}
		
		if (ondarpEv != null) {
			_hashCode = 29 * _hashCode + ondarpEv.hashCode();
		}
		
		if (umbralvEv != null) {
			_hashCode = 29 * _hashCode + umbralvEv.hashCode();
		}
		
		if (umbralmsEv != null) {
			_hashCode = 29 * _hashCode + umbralmsEv.hashCode();
		}
		
		if (impohmEv != null) {
			_hashCode = 29 * _hashCode + impohmEv.hashCode();
		}
		
		if (impvEv != null) {
			_hashCode = 29 * _hashCode + impvEv.hashCode();
		}
		
		if (impmsEv != null) {
			_hashCode = 29 * _hashCode + impmsEv.hashCode();
		}
		
		if (via != null) {
			_hashCode = 29 * _hashCode + via.hashCode();
		}
		
		if (lateralidad != null) {
			_hashCode = 29 * _hashCode + lateralidad.hashCode();
		}
		
		if (camara != null) {
			_hashCode = 29 * _hashCode + camara.hashCode();
		}
		
		if (zonacamara != null) {
			_hashCode = 29 * _hashCode + zonacamara.hashCode();
		}
		
		if (porcion != null) {
			_hashCode = 29 * _hashCode + porcion.hashCode();
		}
		
		if (estado != null) {
			_hashCode = 29 * _hashCode + estado.hashCode();
		}
		
		if (caracter != null) {
			_hashCode = 29 * _hashCode + caracter.hashCode();
		}
		
		if (vectorvi1 != null) {
			_hashCode = 29 * _hashCode + vectorvi1.hashCode();
		}
		
		if (vectorvi2 != null) {
			_hashCode = 29 * _hashCode + vectorvi2.hashCode();
		}
		
		if (fechaimplante != null) {
			_hashCode = 29 * _hashCode + fechaimplante.hashCode();
		}
		
		if (fechamod != null) {
			_hashCode = 29 * _hashCode + fechamod.hashCode();
		}
		
		if (impohmdesfibImp != null) {
			_hashCode = 29 * _hashCode + impohmdesfibImp.hashCode();
		}
		
		if (impohmdesfibEv != null) {
			_hashCode = 29 * _hashCode + impohmdesfibEv.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return ImpImplanteElectrodosPk
	 */
	public ImpImplanteElectrodosPk createPk()
	{
		return new ImpImplanteElectrodosPk(idimpelectrodos);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "com.sorin.idea.dto.ImpImplanteElectrodos: " );
		ret.append( "idimpelectrodos=" + idimpelectrodos );
		ret.append( ", idelectrodo=" + idelectrodo );
		ret.append( ", numserie=" + numserie );
		ret.append( ", idhojaimp=" + idhojaimp );
		ret.append( ", idevolucion=" + idevolucion );
		ret.append( ", idseg=" + idseg );
		ret.append( ", ondarpImp=" + ondarpImp );
		ret.append( ", umbralvImp=" + umbralvImp );
		ret.append( ", umbralmsImp=" + umbralmsImp );
		ret.append( ", slewrate=" + slewrate );
		ret.append( ", impohmImp=" + impohmImp );
		ret.append( ", impmsImp=" + impmsImp );
		ret.append( ", impvImp=" + impvImp );
		ret.append( ", estimfren=" + estimfren );
		ret.append( ", motivoexaband=" + motivoexaband );
		ret.append( ", motivorecambio=" + motivorecambio );
		ret.append( ", motivorecolocacion=" + motivorecolocacion );
		ret.append( ", tipoelectrodo=" + tipoelectrodo );
		ret.append( ", durimpulso=" + durimpulso );
		ret.append( ", voltaje=" + voltaje );
		ret.append( ", sensibilidad=" + sensibilidad );
		ret.append( ", poldeteccion=" + poldeteccion );
		ret.append( ", polestimulacion=" + polestimulacion );
		ret.append( ", capturaauto=" + capturaauto );
		ret.append( ", ondarpEv=" + ondarpEv );
		ret.append( ", umbralvEv=" + umbralvEv );
		ret.append( ", umbralmsEv=" + umbralmsEv );
		ret.append( ", impohmEv=" + impohmEv );
		ret.append( ", impvEv=" + impvEv );
		ret.append( ", impmsEv=" + impmsEv );
		ret.append( ", via=" + via );
		ret.append( ", lateralidad=" + lateralidad );
		ret.append( ", camara=" + camara );
		ret.append( ", zonacamara=" + zonacamara );
		ret.append( ", porcion=" + porcion );
		ret.append( ", estado=" + estado );
		ret.append( ", caracter=" + caracter );
		ret.append( ", vectorvi1=" + vectorvi1 );
		ret.append( ", vectorvi2=" + vectorvi2 );
		ret.append( ", fechaimplante=" + fechaimplante );
		ret.append( ", fechamod=" + fechamod );
		ret.append( ", impohmdesfibImp=" + impohmdesfibImp );
		ret.append( ", impohmdesfibEv=" + impohmdesfibEv );
		return ret.toString();
	}
	
	public String getIdelec() {
		return idelec;
	}

	public void setIdelec(String idelec) {
		this.idelec = idelec;
	}

	public String getAbordajetexto() {
		return abordajetexto;
	}

	public void setAbordajetexto(String abordajetexto) {
		this.abordajetexto = abordajetexto;
	}

	public boolean isEstimfrenok() {
		return estimfrenok;
	}

	public void setEstimfrenok(boolean estimfrenok) {
		this.estimfrenok = estimfrenok;
	}

	public boolean isCambiaabordaje() {
		return cambiaabordaje;
	}

	public void setCambiaabordaje(boolean cambiaabordaje) {
		this.cambiaabordaje = cambiaabordaje;
	}

	public boolean isEliminar() {
		return eliminar;
	}

	public void setEliminar(boolean eliminar) {
		this.eliminar = eliminar;
	}
	public Integer getIdaux() {
		return idaux;
	}
	public void setIdaux(Integer idaux) {
		this.idaux = idaux;
	}
	public boolean isRecambio() {
		return recambio;
	}
	public void setRecambio(boolean recambio) {
		this.recambio = recambio;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getNombremodelo() {
		return nombremodelo;
	}

	public void setNombremodelo(String nombremodelo) {
		this.nombremodelo = nombremodelo;
	}

	public boolean isMuestrabarcode() {
		return muestrabarcode;
	}

	public void setMuestrabarcode(boolean muestrabarcode) {
		this.muestrabarcode = muestrabarcode;
	}

	public String getConector() {
		return conector;
	}

	public void setConector(String conector) {
		this.conector = conector;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getPolaridad() {
		return polaridad;
	}

	public void setPolaridad(String polaridad) {
		this.polaridad = polaridad;
	}

	public boolean isVdd() {
		return vdd;
	}

	public void setVdd(boolean vdd) {
		this.vdd = vdd;
	}

	public boolean isPrevio() {
		return previo;
	}

	public void setPrevio(boolean previo) {
		this.previo = previo;
	}

	public boolean isF_modificada() {
		return f_modificada;
	}

	public void setF_modificada(boolean f_modificada) {
		this.f_modificada = f_modificada;
	}

	public String getNserieprev() {
		return nserieprev;
	}

	public void setNserieprev(String nserieprev) {
		this.nserieprev = nserieprev;
	}

	public Integer getIdelectrodoprev() {
		return idelectrodoprev;
	}

	public void setIdelectrodoprev(Integer idelectrodoprev) {
		this.idelectrodoprev = idelectrodoprev;
	}

	public boolean isVddprev() {
		return vddprev;
	}

	public void setVddprev(boolean vddprev) {
		this.vddprev = vddprev;
	}

}
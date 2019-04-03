package com.sorin.idea.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import com.sorin.idea.util.UtilCodifi;
import com.sorin.idea.util.UtilFechas;

import hvn.cm.modelo.dto.BaseDto;
public class EpisodioDto extends BaseDto implements Serializable,Comparable 
{
    public static int serUrgencias = 4;
    public static int serUnidadEnfermeria = 2;
    public static int serServicio = 1;
    public static int serConsulta = 3;
    public static String FORMATO="dd-MM-yyyy";
    
    String nhc;
    String numicu;
    Date fechaEpisodio;
    Date fechaFin;
    String unidad;
    String descriUnidad;
    Integer tipoEpisodio;
    Integer idEpisodio;
  
    
    ArrayList listaDocumentos;
    
    private String identev;
	private String procedimiento;
    
    public EpisodioDto(){
        
    }
    
    public EpisodioDto(String n,String numi,ArrayList lista,String unidad,Integer tipo){
        nhc = n;
        numicu = numi;
        listaDocumentos = lista;
        this.unidad = unidad;
        tipoEpisodio = tipo;
    }
  
    public EpisodioDto(String n,String numi,Date fechaini,Date fechafin,String unidad, Integer tipo, Integer idepi,String identev, String proc){
    	this.nhc = n;
        this.numicu = numi;
        this.fechaEpisodio = fechaini;
        this.fechaFin = fechafin;
        this.unidad = unidad;
        this.tipoEpisodio = tipo;
        this.idEpisodio = idepi;
        this.identev = identev;
        this.procedimiento = proc;
    }
    
    
    public ArrayList getListaDocumentos()
    {
        return listaDocumentos;
    }


    public void setListaDocumentos(ArrayList listaDocumentos)
    {
        this.listaDocumentos = listaDocumentos;
    }


    public String getNhc()
    {
        return nhc;
    }
    public void setNhc(String nhc)
    {
        this.nhc = nhc;
    }
    public String getNumicu()
    {
        return numicu;
    }
    public void setNumicu(String numicu)
    {
        this.numicu = numicu;
    }


    public String getUnidad()
    {
        return UtilCodifi.getCodWin(unidad);
       
    }


    public void setUnidad(String unidad)
    {
        this.unidad = unidad;
    }


    public Date getFechaEpisodio()
    {
        return fechaEpisodio;
    }
    
    public String getFechaEpisodiostr()
    {
    	if(fechaEpisodio != null)
    		return UtilFechas.getFechaStringFormato(fechaEpisodio, FORMATO);
    		//return UtilFechas.dateToString(fechaEpisodio);
    	else
    		return "";
    }


    public void setFechaEpisodio(Date fechaEpisodio)
    {
        this.fechaEpisodio = fechaEpisodio;
    }


    public Integer getTipoEpisodio()
    {
        return tipoEpisodio;
    }


    public void setTipoEpisodio(Integer tipoEpisodio)
    {
        this.tipoEpisodio = tipoEpisodio;
    }


  
    public int compareTo(Object o) {
        EpisodioDto otroEpisodio = (EpisodioDto)o;       

        return -1*new Float(UtilFechas.dateDiff(this.getFechaEpisodio(), otroEpisodio.getFechaEpisodio())).intValue();
        
    }


    public Date getFechaFin()
    {
        return fechaFin;
    }

    public String getFechaFinstr()
    {
    	if(fechaFin != null)
    		return UtilFechas.dateToString(fechaFin);
    	else
    		return "";
    }

    public void setFechaFin(Date fechaFin)
    {
        this.fechaFin = fechaFin;
    }

    public String getDescriUnidad()
    {
        return descriUnidad;
    }

    public void setDescriUnidad(String descriUnidad)
    {
        this.descriUnidad = descriUnidad;
    }

	public Integer getIdEpisodio() {
		return idEpisodio;
	}

	public void setIdEpisodio(Integer idEpisodio) {
		this.idEpisodio = idEpisodio;
	}

	public String getIdentev() {
		return identev;
	}

	public void setIdentev(String identev) {
		this.identev = identev;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	} 
    
    
    
}

package com.sorin.idea.dto;

import hvn.cm.modelo.dto.BaseDto;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.sorin.idea.util.UtilFechas;

public class AuditoriaDto extends BaseDto implements Serializable
{
    private static final long serialVersionUID = 1L;
    public static int sesion = 0;
    public static int insercion = 1;
    public static int modificacion = 2;
    public static int borrado = 3;
    public static int consulta = 4;
    
    Integer codigo;
    String usuario;
    String tabla;
    Integer accion;
    String descri;
    Timestamp fechahora;
    Date fecha;
    
    
    public AuditoriaDto(){}
    public AuditoriaDto(String u,String t,Integer a,String d){
        usuario = u;
        tabla = t;
        accion = a;
        descri = d;
    }
    
    public AuditoriaDto(String u,String t){
        usuario = u;
        tabla = t;
    }
    
    public Integer getAccion()
    {
        return accion;
    }
    public void setAccion(Integer accion)
    {
        this.accion = accion;
    }
    public String getDescri()
    {
        return descri;
    }
    public void setDescri(String descri)
    {
        this.descri = descri;
    }
    public String getTabla()
    {
        return tabla;
    }
    public void setTabla(String tabla)
    {
        this.tabla = tabla;
    }
    public String getUsuario()
    {
        return usuario;
    }
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }
    
    public String getAccionString(){
    	if(this.accion!=null){
    		switch(this.accion){
            	case 0: return "Acceso";
            	case 1: return "Inserción";
            	case 2: return "Modificación";
            	case 3: return "Borrado";
            	case 4: return "Consulta";
            	default: return "";
    		}
    	}else
        return "";
    }
    
    public String getFechaHoraString(){
        return UtilFechas.dateToString(this.fechahora);
    }
    public Integer getCodigo() {
        return codigo;
    }
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    
    public Timestamp getFechahora() {
        return fechahora;
    }
    public void setFechahora(Timestamp fechahora) {
        this.fecha = UtilFechas.TimestampToDate(fechahora);
        this.fechahora = fechahora;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fechahora = UtilFechas.dateToTimestamp(fecha);
        this.fecha = fecha;
    }
}

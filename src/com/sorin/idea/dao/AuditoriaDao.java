package com.sorin.idea.dao;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.sorin.idea.dto.AuditoriaDto;
import com.sorin.idea.util.UtilFechas;

import hvn.cm.dao.BaseDao;
import hvn.cm.dao.DAOException;
import hvn.cm.utiles.UtilBd;

public class AuditoriaDao extends BaseDao {
    
    protected void iniciarDao() {
        setNombreConector("poolDepart");
        setDePool(true);
    }
    
    public AuditoriaDao(){
        this.iniciarDao();
    }
    
    /**
     * Función para guardar en la base de datos la auditoría.
     * 
     * @author jofuga00
     * @param auditoria
     * @return 1 si es correcto y 0 en caso contrario.
     * @throws DAOException
     * @version 1.0; 30/06/2010
     */
    public int escribeAuditoria(AuditoriaDto auditoria) throws DAOException{
        int estado = 1;
        StringBuffer sql = new StringBuffer();
        StringBuffer campo = new StringBuffer();
        StringBuffer valor = new StringBuffer();
    
        campo.append(" CODIGO");
        valor.append(" ");
        valor.append("null");
        
        campo.append(" ,USUARIO");
        valor.append(" ,");
        valor.append(prepararCampo(auditoria.getUsuario()));
        
        campo.append(" ,ACCION");
        valor.append(" ,");
        valor.append(prepararCampo(auditoria.getAccion()));
        
        campo.append(" ,TABLA");
        valor.append(" ,");
        valor.append(prepararCampo(auditoria.getTabla()));
        
        campo.append(" ,DESCRI");
        valor.append(" ,");
        valor.append(prepararCampo(auditoria.getDescri()));
        
        /*campo.append(" ,FECHA");
        valor.append(" ,");
        valor.append("SYSTIMESTAMP");*/
        
        sql.append("INSERT INTO arr_audita (" + campo + ") VALUES (" + valor
            + ")");
     
        estado = procesarSQL(sql.toString());
        return  estado;
    } 
    
    public ArrayList<AuditoriaDto> getAuditorias(Timestamp desde, Timestamp hasta) throws DAOException{
        StringBuffer sql = new StringBuffer();
        
        sql.append("SELECT codigo as \"codigo\", " +
        		"usuario as \"usuario\", " +
        		"accion as \"accion\", " +
        		"tabla as \"tabla\", " +
        		"descri as \"descri\", " +
        		"fecha as \"fechahora\" " +
        		"FROM arr_audita " +
        		"WHERE 1 = 1");
        
        if(desde != null)
            sql.append(" AND fecha >= STR_TO_DATE('" + UtilFechas.dateToString(desde) + "', '%d/%m/%Y %H:%i')");
        if(hasta != null)
            sql.append(" AND fecha <= STR_TO_DATE('" + UtilFechas.dateToString(hasta) + "', '%d/%m/%Y %H:%i')");
        
        sql.append(" ORDER BY fecha DESC");
        
        ArrayList<AuditoriaDto> resultado = (ArrayList<AuditoriaDto>) consultarDtosFromSQL(sql.toString(), AuditoriaDto.class);
        
        if(resultado != null)
            return resultado;
        else
            return new ArrayList<AuditoriaDto>();
    }

    public ArrayList<AuditoriaDto> getAuditoriasAcceso(Timestamp desde, Timestamp hasta) throws DAOException{
        StringBuffer sql = new StringBuffer();
        
        sql.append("SELECT codigo as \"codigo\", " +
        		"usuario as \"usuario\", " +
        		"accion as \"accion\", " +
        		"tabla as \"tabla\", " +
        		"descri as \"descri\", " +
        		"fecha as \"fechahora\" " +
        		"FROM arr_audita " +
        		"WHERE 1 = 1 AND usuario='login' AND accion = 2");
        
        if(desde != null)
            sql.append(" AND fecha >= STR_TO_DATE('" + UtilFechas.dateToString(desde) + "', '%d/%m/%Y %H:%i')");
        if(hasta != null)
            sql.append(" AND fecha <= STR_TO_DATE('" + UtilFechas.dateToString(hasta) + "', '%d/%m/%Y %H:%i')");
        
        sql.append(" ORDER BY fecha DESC");
        
        ArrayList<AuditoriaDto> resultado = (ArrayList<AuditoriaDto>) consultarDtosFromSQL(sql.toString(), AuditoriaDto.class);
        
        if(resultado != null)
            return resultado;
        else
            return new ArrayList<AuditoriaDto>();
    }
    
}

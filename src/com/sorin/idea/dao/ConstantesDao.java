package com.sorin.idea.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sorin.idea.dto.AuditoriaDto;
import com.sorin.idea.dto.GenericosDto;

import hvn.cm.dao.BaseDao;
import hvn.cm.dao.DAOException;

public class ConstantesDao extends BaseDao {
    
    public ConstantesDao(){
        this.setNombreConector("poolDepart");
        this.setDePool(true);
    }
    
    public String getValor(String nombre) throws DAOException{
        
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT descri as \"tmpString1\" " +
                "FROM arr_constantes where nombre = '" + nombre + "'");
        
        GenericosDto resultado = (GenericosDto) consultarDtoFromSQL(sql.toString(),
            GenericosDto.class);
        
        if (resultado != null)
            return resultado.getTmpString1();
        else
            return "";
    }    
}

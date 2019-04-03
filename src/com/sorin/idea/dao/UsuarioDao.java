package com.sorin.idea.dao;

import java.util.ArrayList;

import hvn.apl.jProyecto2010.modelo.servicios.dto.SesionUsuarioDto;
import hvn.cm.dao.BaseDao;
import hvn.cm.dao.DAOException;

public class UsuarioDao extends BaseDao {
    
	protected void iniciarDao() {
		this.setDePool(true);
		this.nombreConector = "poolClinicaBD";
	}
	
    @SuppressWarnings("unchecked")
    public ArrayList<SesionUsuarioDto> getUsuariosByNom (SesionUsuarioDto usuario) throws DAOException{
        StringBuffer sql = new StringBuffer();
        
        sql.append("SELECT us_nombre login, us_apelnom nombre, ");
        sql.append("us_dni dni FROM us_usuarios WHERE 1=1");
        if(usuario.getNombre() != null && !usuario.getNombre().equals(""))
        	sql.append(" and us_apelnom like '%" + usuario.getNombre().toUpperCase() + "%' ");
        if(usuario.getLogin() != null && !usuario.getLogin().equals(""))
        	sql.append(" and us_nombre like '%" + usuario.getLogin() + "%' ");
        
        sql.append(" ORDER BY us_apelnom");
        
        ArrayList<SesionUsuarioDto> resultado = (ArrayList<SesionUsuarioDto>) consultarDtosFromSQL(sql.toString(),
        		SesionUsuarioDto.class);
        
        if(resultado.size() > 0)
            return resultado;
        else
            return new ArrayList<SesionUsuarioDto>();
    }

}

package com.sorin.idea.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sorin.idea.dto.AuditoriaDto;
import com.sorin.idea.dto.GenericosDto;

import hvn.cm.dao.BaseDao;
import hvn.cm.dao.DAOException;

public class MaestrasDao extends BaseDao {
    
    private AuditoriaDao auditoriaDao = new AuditoriaDao();
    private AuditoriaDto auditoriaDto = null;
    
    public MaestrasDao(String usuario){
        this.setNombreConector("poolDepart");
        this.setDePool(true);
        this.auditoriaDto = new AuditoriaDto(usuario, "ARR_DMAESTRAS");
    }
    
    
  //sobrecargamos éste método de BaseDAO para que nos devuelva más de 150 registros. 
    @Override
    public long getMAX_REGISTROS_SQL() {
        // TODO Auto-generated method stub
       // return super.getMAX_REGISTROS_SQL();
        return 5000;
    }
    
    public ArrayList<GenericosDto> getTablas () throws DAOException{
        
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT DISTINCT nombre as \"tmpString1\" " +
        		", tipo as \"tmpInteger1\"" +
                "FROM arr_tablasmaestras ORDER BY nombre");
        
        ArrayList<GenericosDto> resultado = (ArrayList<GenericosDto>) consultarDtosFromSQL(sql.toString(),
            GenericosDto.class);
        
        if (resultado != null)
            return resultado;
        else
            return new ArrayList<GenericosDto>();
        
    }
    
    public ArrayList<GenericosDto> getResultadoByTipo (Integer tipo) throws DAOException{
        
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT codigo as \"tmpInteger1\", valor as \"tmpString1\", tipo as \"tmpInteger2\" " +
                "FROM arr_maestras ");
        
        sql.append("WHERE tipo = " + tipo);
        sql.append(" ORDER BY valor");
        
        ArrayList<GenericosDto> resultado = (ArrayList<GenericosDto>) consultarDtosFromSQL(sql.toString(),
            GenericosDto.class);
        
        if (resultado != null)
            return resultado;
        else
            return new ArrayList<GenericosDto>();
    }
    
    
    /**
     * Inserción de un dato nuevo para uno de los desplegables de la aplicación.
     * 
     * @author jofuga00
     * @param descripcion
     * @param tipo
     * @return 1 si la inserción es correcta, 0 en caso contrario.
     * @throws DAOException
     * @version 1.0; 30/06/2010
     */
    public int insertarMaestra(String descripcion, Integer tipo) throws DAOException{
        
        int estado = 1;

        StringBuffer sql = new StringBuffer();
        StringBuffer campo = new StringBuffer();
        StringBuffer valor = new StringBuffer();
        
        campo.append("CODIGO, ");
        valor.append("null, ");
        
        campo.append("VALOR, ");
        valor.append("'" + descripcion.toUpperCase() + "', ");
        
        campo.append("TIPO");
        valor.append(tipo);
        
        sql.append("INSERT INTO arr_maestras (" + campo + ") VALUES (" + valor + ")");
        
        estado = procesarSQL(sql.toString());
        
        auditoriaDto.setAccion(AuditoriaDto.insercion);
        auditoriaDto.setDescri(sql.toString());
        auditoriaDao.escribeAuditoria(auditoriaDto);

        return estado;
    }
    
    public int modificarMaestra(Integer codigo, String nombre) throws DAOException{
        int estado = 1;
        
        StringBuffer sql = new StringBuffer();
        StringBuffer campo = new StringBuffer();
        
        campo.append("valor = ");
        campo.append("'" + nombre.toUpperCase() + "' ");
        
        sql.append("UPDATE arr_maestras SET " + campo) ;
        sql.append("WHERE codigo = " + codigo );
        
        estado = procesarSQL(sql.toString());
        
        auditoriaDto.setAccion(AuditoriaDto.modificacion);
        auditoriaDto.setDescri(sql.toString());
        auditoriaDao.escribeAuditoria(auditoriaDto);

        return estado;
    }
    
    public int eliminarDmaestra(Integer codigo) throws DAOException{
        int estado = 1;
        
        StringBuffer sql = new StringBuffer();
        
        sql.append("DELETE FROM arr_maestras where codigo = " + codigo);
        
        estado = procesarSQL(sql.toString());
        
        auditoriaDto.setAccion(AuditoriaDto.borrado);
        auditoriaDto.setDescri(sql.toString());
        auditoriaDao.escribeAuditoria(auditoriaDto);

        return estado;
    }
    
    public boolean exixteMaestra (String nombre, Integer tipo) throws DAOException{
        
        String sql = "SELECT codigo FROM arr_maestras WHERE valor = '" + nombre.toUpperCase() + "' AND " +
        		"tipo = " + tipo;
        
        List<Map> resultado = consultarSQL(sql);
        
        if(resultado.size() == 0)
            return false;
        else
            return true;
    } 
    
    public Integer consultaEstadistica(String sql) throws DAOException{
        
        List<Map> resultado = consultarSQL(sql);
        
        if(resultado.size() == 0)
            return 0;
        else
            return new Integer(resultado.get(0).get("TOTAL").toString());
    } 
}

package com.sorin.idea.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sorin.idea.dto.ArrAnual;
import com.sorin.idea.dto.AuditoriaDto;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.util.UtilFechas;

import hvn.cm.dao.BaseDao;
import hvn.cm.dao.DAOException;

public class ConsultasDao extends BaseDao {
    
    private AuditoriaDao auditoriaDao = new AuditoriaDao();
    private AuditoriaDto auditoriaDto = null;
    
    public ConsultasDao(String usuario){
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
    
    //mmb
    private Integer[] inicializaVectorInteger(Integer[] v,int tama){
    	v = new Integer[tama];
    	for(int i=0;i<tama;i++){
    		v[i] = new Integer(0);
    	}
    	return v;
    }
    
    private Float[] inicializaVectorFloat(Float[] v,int tama){
    	v = new Float[tama];
    	for(int i=0;i<tama;i++){
    		v[i] = new Float(0);
    	}
    	return v;
    }
    
   
    public Integer[] getEstadisticaN1Sumas(Integer[] v1,Integer[] v2) throws DAOException{
    	Integer[] salida = null;
    	salida = inicializaVectorInteger(salida,12);
    	for (int i=0;i<12;i++)
    		salida[i] = v1[i] + v2[i];
    	
    	return salida;
    }
    //TODO: DEBE SER FLOAT
    public Float[] getEstadisticaPorcentajes(Integer[] total,Integer[] inferior) throws DAOException{
    	Float[] salida = null;
    	salida = inicializaVectorFloat(salida,12);
    	for (int i=0;i<12;i++){
    		if (total[i] == 0) salida[i] = new Float(0);
    		else{
    			salida[i] = new Float((new Float(inferior[i])/new Float(total[i]))*100); 
    		}
    	}
    	
    	
    		
    	
    	return salida;
    }
    
    public Integer[] getEstadisticaN1Sumas(Integer[] v1,Integer[] v2,Integer[] v3) throws DAOException{
    	Integer[] salida = null;
    	salida = inicializaVectorInteger(salida,12);
    	for (int i=0;i<12;i++)
    		salida[i] = v1[i] + v2[i]+v3[i];
    	
    	return salida;
    }
    
    public Integer[] getEstadisticaN16(Integer anio,Integer totalPa) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append(" select mes as mes, count(fecha) as total from (select DATE_FORMAT(arr_estudio.fecha, '%m') as mes, fecha,count(distinct (arr_estudio_ablacion.idestudio))  ");
        sql.append(" from arr_estudio,arr_estudio_ablacion ");
        sql.append(" where 1=1 and DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" and arr_estudio.idestudio = arr_estudio_ablacion.idestudio group by DATE_FORMAT(arr_estudio.fecha, '%m'), fecha having count(distinct (arr_estudio_ablacion.idestudio)) = "+totalPa+") as est group by mes order by mes ");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    
  
    
    public Integer[] getEstadisticaN15(Integer anio,Integer totalPa) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append(" select mes as mes, count(fecha) as total from (select DATE_FORMAT(fecha, '%m') as mes, fecha, count(distinct (idpaciente))");
        sql.append(" from arr_estudio ");
        sql.append(" where 1=1 and DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(fecha, '%m'),fecha having count(distinct (idpaciente)) = "+totalPa+") as est group by mes order by mes ");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    
    
    public Integer[] getEstadisticaN14(Integer anio,Integer generador) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) as total,DATE_FORMAT(fecha, '%m') as mes");
        sql.append(" from arr_desfibrilador");
        sql.append(" where generador = "+generador+" and DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(fecha, '%m') order by DATE_FORMAT(fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    
    public Integer[] getEstadisticaN13(Integer anio) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) total ,DATE_FORMAT(fecha, '%m') as mes");
        sql.append(" from arr_test_epi");
        sql.append(" where DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    public Integer[] getEstadisticaN12(Integer anio) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) total ,DATE_FORMAT(arr_test_fle.fecha, '%m') as mes");
        sql.append(" from arr_test_fle");
        sql.append(" where DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(arr_test_fle.fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    public Integer[] getEstadisticaN11(Integer anio) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) total ,DATE_FORMAT(arr_test_atp.fecha, '%m') as mes");
        sql.append(" from arr_test_atp");
        sql.append(" where DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(arr_test_atp.fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    public Integer[] getEstadisticaN10(Integer anio) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) total ,DATE_FORMAT(arr_cardioversion.fecha, '%m') as mes");
        sql.append(" from arr_cardioversion");
        sql.append(" where DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(arr_cardioversion.fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    
    
    public Integer[] getEstadisticaN9(Integer anio,Integer ecografia) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) as total,DATE_FORMAT(fecha, '%m') as mes");
        sql.append(" from arr_estudio");
        sql.append(" where ecografia = "+ecografia+" and DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(fecha, '%m') order by DATE_FORMAT(fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    
    public Integer[] getEstadisticaN8(Integer anio,Integer edad) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) as total,DATE_FORMAT(fecha, '%m') as mes");
        sql.append(" from arr_estudio,arr_pacientes where TIPO_PROCEDIMIENTO in (502,503,504) ");
        sql.append(" and DATE_FORMAT(fecha, '%Y') = '"+anio+"' and arr_estudio.idpaciente = arr_pacientes.codigo and TIMESTAMPDIFF(MONTH,arr_estudio.fecha, arr_pacientes.fechanaci) < "+edad);
        sql.append(" group by DATE_FORMAT(arr_estudio.fecha, '%m') order by DATE_FORMAT(fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    public Integer[] getEstadisticaN7(Integer anio,Integer idEnergia) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(distinct(arr_estudio.fecha)) total ,DATE_FORMAT(arr_estudio.fecha, '%m') as mes");
        sql.append(" from  arr_estudio,arr_estudio_ablacion");
        sql.append(" where 1=1 and DATE_FORMAT(fecha, '%Y') = '"+anio+"' and arr_estudio.idestudio = arr_estudio_ablacion.idestudio and arr_estudio_ablacion.idenergia = "+idEnergia);
        sql.append(" group by DATE_FORMAT(arr_estudio.fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    
    public Integer[] getEstadisticaN6(Integer anio,Integer idAbordaje) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(distinct(arr_estudio.fecha)) total ,DATE_FORMAT(arr_estudio.fecha, '%m') as mes");
        sql.append(" from  arr_estudio,arr_estudio_ablacion");
        sql.append(" where 1=1 and DATE_FORMAT(fecha, '%Y') = '"+anio+"' and arr_estudio.idestudio = arr_estudio_ablacion.idestudio and arr_estudio_ablacion.idabordaje = "+idAbordaje);
        sql.append(" group by DATE_FORMAT(arr_estudio.fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    public Integer[] getEstadisticaN5(Integer anio,Integer navegador) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) as total,DATE_FORMAT(fecha, '%m') as mes");
        sql.append(" from arr_estudio");
        sql.append(" where navegador = "+navegador+" and DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(fecha, '%m') order by DATE_FORMAT(fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    
    public Integer[] getEstadisticaN4(Integer anio) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(distinct(arr_estudio.fecha)) total ,DATE_FORMAT(arr_estudio.fecha, '%m') as mes");
        sql.append(" from  arr_estudio,arr_estudio_ablacion");
        sql.append(" where 1=1 and DATE_FORMAT(fecha, '%Y') = '"+anio+"' and arr_estudio.idestudio = arr_estudio_ablacion.idestudio");
        sql.append(" group by DATE_FORMAT(arr_estudio.fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    public Integer[] getEstadisticaN3(Integer anio) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(distinct(fecha)) total,DATE_FORMAT(fecha, '%m') as mes");
        sql.append(" from  arr_estudio");
        sql.append(" where 1=1 and DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by  DATE_FORMAT(fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    public Integer[] getEstadisticaN1(Integer anio,Integer procedimiento) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) as total,DATE_FORMAT(fecha, '%m') as mes");
        sql.append(" from arr_estudio");
        sql.append(" where TIPO_PROCEDIMIENTO = "+procedimiento+" and DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(fecha, '%m') order by DATE_FORMAT(fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    public Integer[] getEstadisticaN2(Integer anio,Integer ablaciones) throws DAOException{
        Integer[] salida = null;
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(*) as total,DATE_FORMAT(fecha, '%m') as mes");
        sql.append(" from arr_estudio");
        sql.append(" where ABLACION = "+ablaciones+" and DATE_FORMAT(fecha, '%Y') = '"+anio+"'");
        sql.append(" group by DATE_FORMAT(fecha, '%m') order by DATE_FORMAT(fecha, '%m')");
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0){
        	salida = inicializaVectorInteger(salida,12);
        	for (int i=0;i<consulta.size();i++){
        		Integer pos = new Integer(consulta.get(i).get("mes").toString());
        		salida[pos-1] = new Integer(consulta.get(i).get("total").toString());
        	}
        	return salida;
        }
        
        else{
        	return inicializaVectorInteger(salida,12);
        }
        	
    }
    
    
    
    
    public String getPacientesAblacion(Integer anio, Integer ablacion) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(distinct ee.idpaciente) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getProcedimientosAblacion(Integer anio, Integer ablacion) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
       // sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getProcedimientosAblacionExito(Integer anio, Integer ablacion) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_resultado re");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and re.idablacion = ab.idablacion");
        sql.append(" and re.idres = 1");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getMuertesAblacion(Integer anio, Integer ablacion) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_ablacion_complica com");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and com.idablacion = ab.idablacion");
        sql.append(" and com.idmuerte = 1");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    
    
    
    public String getMuertesConComplicacionAblacion(Integer anio, Integer ablacion) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_ablacion_complica com");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and com.idablacion = ab.idablacion");
        sql.append(" and com.idmuerte = 1");
        sql.append(" and com.idcomplicacion is not null");
        sql.append(" and com.idcomplicacion > 0");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getComplicacionesAblacion(Integer anio, Integer ablacion, Integer complicacion) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_ablacion_complica com");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and com.idablacion = ab.idablacion");
        sql.append(" and com.idcomplicacion is not null");
        sql.append(" and com.idcomplicacion = " + complicacion);
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getOtrasComplicacionesAblacion(Integer anio, Integer ablacion) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_ablacion_complica com");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and com.idablacion = ab.idablacion");
        sql.append(" and com.idcomplicacion is not null");
        sql.append(" and com.idcomplicacion > 12");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getCateteresAblacion(Integer anio, Integer ablacion, String cateter) throws DAOException{
        /*StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and ab.cateter like '%"+cateter+"%'");*/
        
        // nueva consulta con nuevo modelo de cateter
        
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_cat_apl apl, arr_estudio_cat_uso uso, cateter cat");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and apl.idablacion = ab.idablacion ");
        sql.append(" and apl.idcatuso = uso.idcatuso ");
        sql.append(" and uso.idcateter = cat.idcateter ");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and cat.tipoablacion = "+Integer.valueOf(cateter));
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getOtrosCateteresAblacion(Integer anio, Integer ablacion) throws DAOException{
        /*StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and not (ab.cateter like '%IRRIGAD%')");
        sql.append(" and not (ab.cateter like '%8MM%')");
        sql.append(" and not (ab.cateter like '%CRIO%')");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";*/
    	// nueva consulta con nuevo modelo de cateter  
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_cat_apl apl, arr_estudio_cat_uso uso, cateter cat");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and apl.idablacion = ab.idablacion ");
        sql.append(" and apl.idcatuso = uso.idcatuso ");
        sql.append(" and uso.idcateter = cat.idcateter ");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and (cat.tipoablacion > 4 and cat.tipoablacion <>9 and cat.tipoablacion <>9 and cat.tipoablacion <>10 and cat.tipoablacion <>11)");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getOtrosCateteresAblacionNombres(Integer anio, Integer ablacion) throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select cat.modelo as \"modelo\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_cat_apl apl, arr_estudio_cat_uso uso, cateter cat");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and apl.idablacion = ab.idablacion ");
        sql.append(" and apl.idcatuso = uso.idcatuso ");
        sql.append(" and uso.idcateter = cat.idcateter ");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and (cat.tipoablacion > 4 and cat.tipoablacion <>9 and cat.tipoablacion <>10 and cat.tipoablacion <>11)");
        
        List<Map> consulta = consultarSQL(sql.toString());
        String modelos = "";
        if(consulta != null && consulta.size() > 0){
        	for(int i=0;i<consulta.size();i++){
        		modelos+= (consulta.get(0)!=null && consulta.get(0).get("modelo")!=null?consulta.get(0).get("modelo").toString()+". ":"");
        	}
        	return modelos;
        } 	
        else
        	return "";
    }
    
    public String getVacTotal(Integer anio, Integer ablacion)throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
       // sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getVacConducciones(Integer anio, Integer ablacion, Integer tipo)throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(vias.idsentido) as \"total\" from arr_estudio ee, arr_estudio_vias vias");
        sql.append(" where ee.idestudio = vias.idestudio");
       // sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and vias.idsentido = " + tipo);
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getVacAblacion(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
       // sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        switch (loc) {
		case 1:
			sql.append(" and ab.iddcha = 1");
			sql.append(" and (ab.idizda = 1 or ab.idizda = 2 or ab.idizda = 6)");
			break;
		case 2:
			sql.append(" and ab.iddcha = 2");
			sql.append(" and ab.idizda <> 2");
			break;
		case 3:
			sql.append(" and ((ab.iddcha = 1 and ab.idizda = 3)");
			sql.append(" or (ab.iddcha = 2 and ab.idizda = 2))");
			break;
		case 4:
			sql.append(" and ab.iddcha = 1");
			sql.append(" and (ab.idizda = 4 or ab.idizda = 5 or ab.idizda = 7)");
			break;
		default:
			break;
		}
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getVacAblacionExito(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_resultado re");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and re.idablacion = ab.idablacion");
        sql.append(" and re.idres = 1");
        switch (loc) {
		case 1:
			sql.append(" and ab.iddcha = 1");
			sql.append(" and (ab.idizda = 1 or ab.idizda = 2 or ab.idizda = 6)");
			break;
		case 2:
			sql.append(" and ab.iddcha = 2");
			sql.append(" and ab.idizda <> 2");
			break;
		case 3:
			sql.append(" and ((ab.iddcha = 1 and ab.idizda = 3)");
			sql.append(" or (ab.iddcha = 2 and ab.idizda = 2))");
			break;
		case 4:
			sql.append(" and ab.iddcha = 1");
			sql.append(" and (ab.idizda = 4 or ab.idizda = 5 or ab.idizda = 7)");
			break;
		default:
			break;
		}
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getVacAblacionAccesoIzquierdas(Integer anio, Integer ablacion, Integer via) throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_cat_apl apl");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and ab.iddcha = 2");
		sql.append(" and ab.idizda <> 2");
		sql.append(" and apl.idablacion = ab.idablacion");
		sql.append(" and apl.idvia = "+via);

        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTafAblacion(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and ab.iddcha = " + loc);
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTafAblacionExito(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_resultado re");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and re.idablacion = ab.idablacion");
        sql.append(" and re.idres = 1");
        sql.append(" and ab.iddcha = " + loc);
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getFtaAblacion(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and ab.iddcha = " + loc);
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getFtaAblacionTipo(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and ab.iddcha > 1");
        sql.append(" and ab.idizda = "+loc);
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getFtaAblacionExito(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_resultado re");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and re.idablacion = ab.idablacion");
        sql.append(" and re.idres = 1");
        sql.append(" and ab.iddcha = " + loc);
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTviAblacion(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        if(loc < 3 || loc > 6)
        	sql.append(" and ab.iddcha = " + loc);
        if(loc == 3)
        	sql.append(" and ab.iddcha in (5,6)");
        if(loc == 4)
        	sql.append(" and ab.iddcha in (3,4)");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTviAblacionExito(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_resultado re");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and re.idablacion = ab.idablacion");
        sql.append(" and re.idres = 1");
        if(loc < 3 || loc > 6)
        	sql.append(" and ab.iddcha = " + loc);
        if(loc == 3)
        	sql.append(" and ab.iddcha in (5,6)");
        if(loc == 4)
        	sql.append(" and ab.iddcha in (3,4)");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTVIAMAblacion(Integer anio, Integer ablacion, Integer sustrato) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        if(sustrato == 0)
        	sql.append(" and ab.iddcha in (1,2)");
        else
        	sql.append(" and ab.iddcha in (3,4)");
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTVIAMAblacionExito(Integer anio, Integer ablacion, Integer sustrato) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_resultado re");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and re.idablacion = ab.idablacion");
        sql.append(" and re.idres = 1");
        if(sustrato == 0)
        	sql.append(" and ab.iddcha in (1,2)");
        else
        	sql.append(" and ab.iddcha in (3,4)");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTVIAMAcceso(Integer anio, Integer ablacion, Integer via) throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_cat_apl apl");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
		sql.append(" and apl.idablacion = ab.idablacion");
		sql.append(" and apl.idvia = "+via);
	  
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTVNOIAMAblacion(Integer anio, Integer ablacion, Integer tipo) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        switch (tipo) {
		case 1:
			sql.append(" and ab.iddcha in (4,5)");
			break;
		case 2:
			sql.append(" and ab.iddcha in (1,2,3)");
			break;
		case 3:
			sql.append(" and ab.iddcha = 6");
			break;
		case 4:
			sql.append(" and ab.iddcha = 7");
			break;
		case 5:
			sql.append(" and ab.iddcha = 8");
			break;
		case 9:
			sql.append(" and ab.iddcha = 9");
			break;
		case 10:
			sql.append(" and ab.iddcha = 10");
			break;
		default:
			break;
		}
        	
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTVNOIAMAblacionExito(Integer anio, Integer ablacion, Integer tipo) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_resultado re");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and re.idablacion = ab.idablacion");
        sql.append(" and re.idres = 1");
        switch (tipo) {
		case 1:
			sql.append(" and ab.iddcha in (4,5)");
			break;
		case 2:
			sql.append(" and ab.iddcha in (1,2,3)");
			break;
		case 3:
			sql.append(" and ab.iddcha = 6");
			break;
		case 4:
			sql.append(" and ab.iddcha = 7");
			break;
		case 5:
			sql.append(" and ab.iddcha = 8");
			break;
		case 9:
			sql.append(" and ab.iddcha = 9");
			break;
		case 10:
			sql.append(" and ab.iddcha = 10");
			break;
		default:
			break;
		}
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getTVNOIAMAcceso(Integer anio, Integer ablacion, Integer via) throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_cat_apl apl");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
		sql.append(" and apl.idablacion = ab.idablacion");
		sql.append(" and apl.idvia = "+via);
		
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getFaAblacion(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        if(loc == 1)
        	sql.append(" and ab.iddcha = 1");
        if(loc == 2)
        	sql.append(" and ab.iddcha in (2,3)");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getFaAblacionAbordaje(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        switch (loc) {
		case 1:
			sql.append(" and ab.iddcha = 1 and ab.idizda = 2");
			break;
		case 2:
			sql.append(" and ab.iddcha = 1 and ab.idizda = 1");
			break;
		case 3:
			sql.append(" and ab.iddcha = 2 and ab.idizda = 1");
			break;
		case 4:
			sql.append(" and ab.iddcha = 2 and ab.idizda = 2");
			break;
		default:
			break;
		}
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getFaAblacionAbordajeExito(Integer anio, Integer ablacion, Integer loc) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_estudio_resultado re");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and re.idablacion = ab.idablacion");
        sql.append(" and re.idres = 1");
        switch (loc) {
		case 1:
			sql.append(" and ab.iddcha = 1 and ab.idizda = 2");
			break;
		case 2:
			sql.append(" and ab.iddcha = 1 and ab.idizda = 1");
			break;
		case 3:
			sql.append(" and ab.iddcha = 2 and ab.idizda = 1");
			break;
		case 4:
			sql.append(" and ab.iddcha = 2 and ab.idizda = 2");
			break;
		default:
			break;
		}
        
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getFaAblacionSustrato(Integer anio, Integer ablacion, Integer idtaquiarr, Integer tipoFA) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("select count(ab.idestudio) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        sql.append(" and ab.idnodo = " + ablacion);
        sql.append(" and ee.diagnostico = " + idtaquiarr);
        sql.append(" and ee.tipodiag1 = 3" );
        switch (tipoFA) {
		case 1:
			sql.append(" and ee.tipodiag2 = 1");
			break;
		case 2:
			sql.append(" and ee.tipodiag2 = 2");
			break;
		case 3:
			sql.append(" and ee.tipodiag2 = 3");
			break;
		default:
			break;
		}      
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getCasosPediatricos(Integer anio, Integer ablacion)throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(distinct ee.idpaciente) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee, arr_pacientes pa");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and ee.idpaciente = pa.codigo");
        sql.append(" and TIMESTAMPDIFF(YEAR, pa.fechanaci, CURDATE()) <= 15");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getCasosNavegador(Integer anio, Integer ablacion, Integer nav_no)throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(distinct ee.idpaciente) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append(" and ee.navegador is not null and ee.navegador <> -1");
        if(nav_no!=null)
        	sql.append(" and ee.navegador <>"+nav_no);
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    
    public String getCasosSinFluoroscopia(Integer anio, Integer ablacion)throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(distinct ee.idpaciente) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append("  and (ee.tescopia is null or ee.tescopia = '' or ee.tescopia = '0')");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
    public String getCasosConEcoIntra(Integer anio, Integer ablacion)throws DAOException{
    	StringBuffer sql = new StringBuffer();
        sql.append("select count(distinct ee.idpaciente) as \"total\" from arr_estudio_ablacion ab, arr_estudio ee");
        sql.append(" where ab.idestudio = ee.idestudio");
        //sql.append(" and ee.fecha between '01/01/"+anio+"' and '31/12/"+anio+"'");
        sql.append(" and ee.fecha between '"+anio+"-01-01' and '"+anio+"-12-31'");
        if(ablacion != ArrAnual.FLUTER_AURICULAR_ICT){
        	sql.append(" and ab.idnodo = " + ablacion);
        	if(ablacion == ArrAnual.FLUTER_AURICULAR)
        		sql.append(" and ab.iddcha <> 1");
        }else{
        	sql.append(" and ab.idnodo = " + ArrAnual.FLUTER_AURICULAR);
        	sql.append(" and ab.iddcha = 1");
        }
        sql.append("  and (ee.ecografia = 1)");
        
        List<Map> consulta = consultarSQL(sql.toString());
        if(consulta != null && consulta.size() > 0)
        	return new String(consulta.get(0).get("total").toString());
        else
        	return "0";
    }
}

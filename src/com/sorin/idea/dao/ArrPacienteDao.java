package com.sorin.idea.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sorin.idea.dto.AuditoriaDto;
import com.sorin.idea.dto.EstadisticaDto;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.exceptions.GeneradorDaoException;
import com.sorin.idea.jdbc.ResourceManager;
import com.sorin.idea.util.UtilFechas;


import oracle.jdbc.OracleTypes;

import hvn.cm.dao.BaseDao;
import hvn.cm.dao.DAOException;

public class ArrPacienteDao extends BaseDao {
    
	private AuditoriaDao auditoriaDao = new AuditoriaDao();
    private AuditoriaDto auditoriaDto = null;
    
    /*private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static String JDBC_URL = "jdbc:mysql://localhost:3306/arritmias?user=root";
	private static String JDBC_USER = "root";
	private static String JDBC_PASSWORD = "";*/
	private static Driver driver = null;
    
    public ArrPacienteDao(String usuario){
        this.setDePool(true);
        this.setNombreConector("poolDepart");
        auditoriaDto = new AuditoriaDto(usuario, "idea.arr_pacientes");
    }
    
    

	public long getMAX_REGISTROS_SQL() {
		return 10000;
	}
    
    /**
     * Método que inserta el registro de un paciente nuevo.
     * 
     * @author jofuga00
     * @param paciente
     * @return
     * @throws DAOException
     * @version 1.0; 01/07/2010
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public int insertarPaciente(PacienteAplDto paciente) throws Exception{
        
        int estado = 1;

        StringBuffer sql = new StringBuffer();
        StringBuffer campo = new StringBuffer();
        StringBuffer valor = new StringBuffer();
        
        campo.append("CODIGO, ");
        valor.append("null, ");
        
        campo.append("NUHSA, ");
        if(paciente.getNuhsa() != null)
        	valor.append("'" + paciente.getNuhsa().toUpperCase() + "', ");
        else
        	valor.append("'', ");
        
        campo.append("NHC, ");
        valor.append("'" + paciente.getNhc().toUpperCase() + "', ");
        
        campo.append("NOMBRE, ");
        valor.append("'" + paciente.getNombre().toUpperCase() + "', ");
        
        campo.append("APELLID1, ");
        valor.append("'" + paciente.getApellid1().toUpperCase() + "', ");
        
        campo.append("APELLID2, ");
        if(paciente.getApellid2() != null)
        	valor.append("'" + paciente.getApellid2().toUpperCase() + "', ");
        else
        	valor.append("'', ");
        campo.append("SEXO, ");
        valor.append(paciente.getSexo() + ", ");
        
        if(paciente.getFechaNaci() != null){
            campo.append("FECHANACI, ");
            valor.append("STR_TO_DATE('" + UtilFechas.dateToString(paciente.getFechaNaci()) + "', '%Y/%m/%d'), ");
        }
        
        campo.append("DNI ,");
        valor.append("'" + paciente.getDni().toUpperCase() + "', ");
        
        campo.append("NSS1, ");
        valor.append("'" + paciente.getNss1().toUpperCase() + "', ");
        
        campo.append("DIRECCION, ");
        valor.append("'" + paciente.getDireccion() + "', ");
        
        campo.append("PROVINCIA, ");
        valor.append("'" + paciente.getProvincia() + "', ");
        
        campo.append("POBLACION, ");
        valor.append("'" + paciente.getPoblacion() + "', ");
        
        campo.append("PAIS, ");
        valor.append("'" + paciente.getPais() + "', ");
        
        campo.append("CP, ");
        valor.append("'" + paciente.getCp() + "', ");
        
        campo.append("ESTADO, ");
        valor.append("'" + paciente.getEstado() + "', ");
        
        campo.append("TELEFONO1, ");
        if(paciente.getTelefono1() != null)
        	paciente.setTelefono1(paciente.getTelefono1().trim());
        valor.append("'" + paciente.getTelefono1() + "', ");
        
        campo.append("TELEFONO2, ");
        if(paciente.getTelefono2() != null)
        	paciente.setTelefono2(paciente.getTelefono2().trim());
        valor.append("'" + paciente.getTelefono2() + "', ");
        
        campo.append("CORREO, ");
        valor.append("'" + paciente.getCorreo() + "', ");
        
        campo.append("PROCEDENCIA, ");
        valor.append(prepararCampo(paciente.getProcedencia()) + ", ");
        
        campo.append("HPROCEDENCIA ");
        valor.append(prepararCampo(paciente.getHprocedencia()));
        
        sql.append("INSERT INTO arr_pacientes (" + campo + ") VALUES (" + valor + ")");
        
        procesarSQL(sql.toString());
        
        StringBuffer sql2 = new StringBuffer();
        sql2.append("SELECT LAST_INSERT_ID() id");
        List<Map> resultado = consultarSQL(sql2.toString());
        if(resultado != null && resultado.size()>0)
        	paciente.setCodigo(((Long) resultado.get(0).get("id")).intValue());
        
        //estado = procesarSQL(sql.toString());
        
        auditoriaDto.setAccion(AuditoriaDto.insercion);
        auditoriaDto.setDescri(sql.toString());
        auditoriaDao.escribeAuditoria(auditoriaDto);
        

        return paciente.getCodigo();
        
    }
    
    @SuppressWarnings("unchecked")
    public boolean existePaciente(PacienteAplDto paciente) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT nuhsa,nhc,dni FROM arr_pacientes WHERE 0=1");
        if(paciente.getNuhsa() != null && paciente.getNuhsa().length() > 0)
        	sql.append(" or nuhsa = '" + paciente.getNuhsa() + "'");
        if(paciente.getNhc() != null && paciente.getNhc().length() > 0)
        	sql.append(" or nhc = '" + paciente.getNhc() + "'");
        if(paciente.getDni() != null && paciente.getDni().length() > 0)
        	sql.append(" or dni = '" + paciente.getDni() + "'");
        
        List<Map> resultado = consultarSQL(sql.toString());
        
        if(resultado.size() == 0)
            return false;
        else
            return true;
    }
    
    @SuppressWarnings("unchecked")
    public Integer obtienePaciente(PacienteAplDto paciente) throws DAOException{
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT codigo as \"codigo\",nuhsa,nhc,dni FROM arr_pacientes WHERE 0=1");
        if(paciente.getNuhsa() != null && paciente.getNuhsa().length() > 0)
        	sql.append(" or nuhsa = '" + paciente.getNuhsa() + "'");
        if(paciente.getNhc() != null && paciente.getNhc().length() > 0)
        	sql.append(" or nhc = '" + paciente.getNhc() + "'");
        if(paciente.getDni() != null && paciente.getDni().length() > 0)
        	sql.append(" or dni = '" + paciente.getDni() + "'");
        
        List<Map> resultado = consultarSQL(sql.toString());
        
        if(resultado.size() == 0)
            return null;
        else{
        	Object a = resultado.get(0).get("CODIGO");
            return new Integer(a.toString());
        }
    }
    
    /**
     * Método que devuelve el listado de pacientes que hay registrados en la aplicación judp según los critorios
     * introducidos que pueden ser (nuhsa, nhc, nombre, apellidos, nif, nss, fecha de nacimiento y sexo). 
     * 
     * @author jofuga00
     * @param paciente
     * @return ArrayList<PacientedolorDto>
     * @throws DAOException
     * @version 1.0; 02/07/2010
     */
    @SuppressWarnings("unchecked")
    public ArrayList<PacienteAplDto> buscaPacientes (PacienteAplDto paciente) throws DAOException{
        
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT arr_pacientes.codigo as \"codigo\", arr_pacientes.nuhsa as \"nuhsa\", " +
        		"arr_pacientes.nhc as \"nhc\", " +
        		"arr_pacientes.nombre as \"nombre\", " +
        		"arr_pacientes.apellid1 as \"apellid1\", " +
        		"arr_pacientes.apellid2 as \"apellid2\", " +
        		"arr_pacientes.sexo as \"sexo\", " +
        		"arr_pacientes.fechaNaci as \"fechaNaci\", " +
        		"arr_pacientes.dni as \"dni\", " +
        		"arr_pacientes.nss1 as \"nss1\", " +
        		"arr_pacientes.direccion as \"direccion\", " +
        		"arr_pacientes.provincia as \"provincia\", " +
        		"arr_pacientes.poblacion as \"poblacion\", " +
        		"arr_pacientes.pais as \"pais\", " +
        		"arr_pacientes.cp as \"cp\", " +
        		"arr_pacientes.estado as \"estado\", " +
        		"arr_pacientes.telefono1 as \"telefono1\", " +
        		"arr_pacientes.telefono2 as \"telefono2\", " +
        		"arr_pacientes.correo as \"correo\", " +
        		"arr_pacientes.procedencia as \"procedencia\", " +
        		"arr_pacientes.hprocedencia as \"hprocedencia\" ");
        		//"procedimiento.tipoprocedimiento as \"tipoproc\" ");
        		/*"count(distinct(codigo_desfibrilador)) AS \"ndai\", " +
        		"count(distinct(codigo_cardioversion)) AS \"ncv\", "+
        		"count(distinct(idestudio)) AS \"neef\", "+*/
        if(paciente.getTipoproc()!=null && paciente.getTipoproc()==1){//eef
        	sql.append(", arr_estudio.nestudio AS \"neef\","
        				+"arr_estudio.idestudio AS \"ideef\", "
        				+"arr_estudio.fecha AS \"fechaeef\" ");	
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==2){
        	sql.append(", arr_cardioversion.ncv AS \"ncv\", "
    				+"codigo_cardioversion AS \"idcv\", "
    				+"arr_cardioversion.fecha AS \"fechacv\" ");	
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==3){
        	sql.append(", arr_registrador.nproc AS \"nreg\", "
    				+"id_registrador AS \"idreg\", "
    				+"arr_registrador.fecha AS \"fechareg\", "
    				+"registradoreventos.modelo as \"modeloDisp\", " // NUEVO
    				+"arr_registrador.nserie as \"nserieDisp\" ");	// NUEVO);
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==4){
        	sql.append(", arr_mesas.nproc AS \"nmesa\", "
    				+"id_mesa AS \"idmesa\", "
    				+"arr_mesas.fecha AS \"fechamesa\" ");	
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==5){
        	sql.append(", arr_test_atp.nproc AS \"natp\", "
    				+"arr_test_atp.codigo_test AS \"idatp\", "
    				+"arr_test_atp.fecha AS \"fechaatp\" ");	
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==6){
        	sql.append(", arr_test_epi.nproc AS \"nepi\", "
    				+"arr_test_epi.codigo_test AS \"idepi\", "
    				+"arr_test_epi.fecha AS \"fechaepi\" ");	
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==7){
        	sql.append(", arr_test_fle.nproc AS \"nfle\", "
    				+"arr_test_fle.codigo_test AS \"idfle\", "
    				+"arr_test_fle.fecha AS \"fechafle\" ");	
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==8){
        	sql.append(", imp_implante.nproc AS \"nimp\", "
    				+"imp_implante.idimplante AS \"idimp\", "
    				+"imp_implante.fechaimplante AS \"fechaimp\", "
    				+"procedimiento.tipoprocedimiento as \"tipoproc\", "
    				+"generador.modelo as \"modeloDisp\", "			// NUEVO
    				+"imp_generador.numserie as \"nserieDisp\" ");	// NUEVO
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==11){
        	sql.append(", holter.nproc AS \"nholter\", "
    				+"holter.idholter AS \"idholter\", "
    				+"holter.estado AS \"estadoproc\", "
    				+"holter.fechacolocacion AS \"fechaholter\" ");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==12){
        	sql.append(", registrador_eventos_ext.nproc AS \"nregevext\", "
    				+"registrador_eventos_ext.idevento AS \"idregevext\", "
    				+"registrador_eventos_ext.estado AS \"estadoproc\", "
    				+"registrador_eventos_ext.fechacolocacion AS \"fecharegevext\" ");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==13){
        	sql.append(", test_ortostatismo_activo.nproc AS \"ntestorto\", "
    				+"test_ortostatismo_activo.idtest AS \"idtestorto\", "
    				+"test_ortostatismo_activo.fecha AS \"fechatestorto\" ");
        }else{// sin tipo de procedimiento
        		
        }
        // FROM   		
        sql.append("FROM arr_pacientes left join arr_desfibrilador " +
        		"on arr_desfibrilador.codigo_paciente = arr_pacientes.codigo " + 
        		"left join arr_cardioversion on arr_cardioversion.codigo_paciente = arr_pacientes.codigo " +
        		"left join arr_estudio on arr_estudio.idpaciente = arr_pacientes.codigo " +
        		"left join arr_mesas on arr_mesas.id_paciente = arr_pacientes.codigo " +
        		"left join arr_registrador on arr_registrador.id_paciente = arr_pacientes.codigo " +
        		"left join arr_test_atp on arr_test_atp.codigo_paciente = arr_pacientes.codigo " +
        		"left join arr_test_epi on arr_test_epi.codigo_paciente = arr_pacientes.codigo " +
        		"left join arr_test_fle on arr_test_fle.codigo_paciente = arr_pacientes.codigo ");
        		//"left join procedimiento on procedimiento.codigo = arr_pacientes.codigo " +
        		//", imp_implante "+
        		//"WHERE 1 = 1 ");
        if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 1)
        	sql.append(", arr_estudio_ablacion ");
        if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 3)
        	sql.append(", registradoreventos "); // NUEVO
        if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 8){
        	sql.append("left join procedimiento on procedimiento.codigo = arr_pacientes.codigo , imp_implante, imp_hoja_implante, imp_generador, generador ");
        	/*sql.append("left join procedimiento on procedimiento.codigo = arr_pacientes.codigo , imp_implante ");
        	if((paciente.getModeloGen()!=null && !paciente.getModeloGen().equals(""))
        			||(paciente.getNumserieGen()!=null && !paciente.getNumserieGen().equals(""))){
        		sql.append(" , imp_hoja_implante, imp_generador ");
        		if(paciente.getModeloGen()!=null && !paciente.getModeloGen().equals(""))
        			sql.append(", generador ");
        	}*/
        }
        if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 11)
        	sql.append("left join procedimiento on procedimiento.codigo = arr_pacientes.codigo , holter ");
        if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 12)
        	sql.append("left join procedimiento on procedimiento.codigo = arr_pacientes.codigo , registrador_eventos_ext ");
        if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 13)
        	sql.append("left join procedimiento on procedimiento.codigo = arr_pacientes.codigo , test_ortostatismo_activo ");
        
        // WHERE
        sql.append("WHERE 1 = 1 ");
        sql.append("AND arr_pacientes.void = 0 ");// condicion de no mostrar los pacientes a VOID = 1
        if(paciente.getNuhsa() != null && !paciente.getNuhsa().equals(""))
            sql.append("AND nuhsa = '" + paciente.getNuhsa().toUpperCase() + "' ");
        
        if(paciente.getNhc() != null && !paciente.getNhc().equals(""))
            sql.append("AND nhc = '" + paciente.getNhc().toUpperCase() + "' ");
        
        if(paciente.getNombre() != null && !paciente.getNombre().equals(""))
            sql.append("AND nombre like '%" + paciente.getNombre().toUpperCase() + "%' ");
        
        if(paciente.getApellid1() != null && !paciente.getApellid1().equals(""))
            sql.append("AND apellid1 like '%" + paciente.getApellid1().toUpperCase() + "%' ");
        
        if(paciente.getApellid2() != null && !paciente.getApellid2().equals(""))
            sql.append("AND apellid2 like '%" + paciente.getApellid2().toUpperCase() + "%' ");
        
        if(paciente.getDni() != null && !paciente.getDni().equals(""))
            sql.append("AND dni like '%" + paciente.getDni().toUpperCase() + "%' ");
        
        if(paciente.getNss1() != null && !paciente.getNss1().equals(""))
            sql.append("AND nss1 = '" + paciente.getNss1() + "' ");
        
        if(paciente.getFechaNaci()!=null && !paciente.getFechaNaci().toString().equals(""))
            sql.append("AND fechaNaci = '" + UtilFechas.dateToString(paciente.getFechaNaci()) + "' ");
        
        if(paciente.getSexo() != null && paciente.getSexo() > 0 && paciente.getSexo() < 3)
            sql.append("AND sexo = '" + paciente.getSexo().toString() + "' ");
        
        if(paciente.isEef())
        	sql.append(" AND idestudio is not null");
        if(paciente.isDai())
        	sql.append(" AND codigo_desfibrilador is not null");
        if(paciente.isCv())
        	sql.append(" AND codigo_cardioversion is not null");
        
        if(paciente.getNumEstudio() != null && paciente.getNumEstudio().length() > 0){
        	if(paciente.getTipoEstudio() == 0)
        		sql.append(" AND arr_estudio.nestudio = " + paciente.getNumEstudio());
        	if(paciente.getTipoEstudio() == 1)
        		sql.append(" AND arr_desfibrilador.ndai = " + paciente.getNumEstudio());
        	if(paciente.getTipoEstudio() == 2)
        		sql.append(" AND arr_cardioversion.ncv = " + paciente.getNumEstudio());
        }
        if(paciente.getNproc()!=null && paciente.getNproc().length()>0){
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 1){
        		sql.append(" AND arr_estudio.nestudio = " + paciente.getNproc());
        		//sql.append(" AND arr_estudio.idestudio = procedimiento.idprocedimiento" );
            	//sql.append(" AND procedimiento.tipoprocedimiento = 1061" );
        	}
        		    		
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 2)
        		sql.append(" AND arr_cardioversion.ncv = " + paciente.getNproc());        		
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 3)
        		sql.append(" AND arr_registrador.idmodeloreg = registradoreventos.idregistrador AND arr_registrador.nproc = " + paciente.getNproc());		
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 4)
        		sql.append(" AND arr_mesas.nproc = " + paciente.getNproc());        		
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 5)
        		sql.append(" AND arr_test_atp.nproc = " + paciente.getNproc());      		
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 6)
        		sql.append(" AND arr_test_epi.nproc = " + paciente.getNproc());       		
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 7)
        		sql.append(" AND arr_test_fle.nproc = " + paciente.getNproc());
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 8){
        		sql.append(" AND imp_implante.nproc = " + paciente.getNproc());
        		sql.append(" AND imp_implante.idimplante = procedimiento.idprocedimiento" );
        		sql.append(" AND (procedimiento.tipoprocedimiento = '956' OR procedimiento.tipoprocedimiento = '957' OR procedimiento.tipoprocedimiento = '1059'" +
        					"OR procedimiento.tipoprocedimiento = '1060' OR procedimiento.tipoprocedimiento = '993' OR procedimiento.tipoprocedimiento = '1085' " +
        					"OR procedimiento.tipoprocedimiento = '1086' OR procedimiento.tipoprocedimiento = '1090' OR procedimiento.tipoprocedimiento = '1147')"+
        					"AND imp_hoja_implante.idhojaimp = imp_implante.idhojaimp " +
        					"AND imp_generador.idhojaimp = imp_hoja_implante.idhojaimp AND generador.idgenerador = imp_generador.idgenerador ");
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 11){
        		sql.append(" AND holter.nproc = '" + paciente.getNproc()+"'"); 
            	sql.append(" AND holter.idholter = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1089" );
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 12){
        		sql.append(" AND registrador_eventos_ext.nproc = '" + paciente.getNproc()+"'"); 
            	sql.append(" AND registrador_eventos_ext.idevento = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1091" );
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 13){
        		sql.append(" AND test_ortostatismo_activo.nproc = '" + paciente.getNproc()+"'"); 
            	sql.append(" AND test_ortostatismo_activo.idtest = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1092" );
        	}
    		sql.append(generaWherePorTipoProcedimiento(paciente));	
        }
        if(paciente.getFechaproc()!=null ){
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 1){
        		sql.append(" AND arr_estudio.fecha >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");    
        		//sql.append(" AND arr_estudio.idestudio = procedimiento.idprocedimiento" );
            	//sql.append(" AND procedimiento.tipoprocedimiento = 1061" );
        	}	      	
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 2)
        		sql.append(" AND arr_cardioversion.fecha >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 3)
        		sql.append(" AND arr_registrador.idmodeloreg = registradoreventos.idregistrador AND arr_registrador.fecha >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 4)
        		sql.append(" AND arr_mesas.fecha >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 5)
        		sql.append(" AND arr_test_atp.fecha >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 6)
        		sql.append(" AND arr_test_epi.fecha >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 7)
        		sql.append(" AND arr_test_fle.fecha >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 8){
        		sql.append(" AND procedimiento.fecha >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        		sql.append(" AND imp_implante.idimplante = procedimiento.idprocedimiento" );
        		sql.append(" AND (procedimiento.tipoprocedimiento = '956' OR procedimiento.tipoprocedimiento = '957' OR procedimiento.tipoprocedimiento = '1059'" +
    					"OR procedimiento.tipoprocedimiento = '1060' OR procedimiento.tipoprocedimiento = '993' OR procedimiento.tipoprocedimiento = '1085' " +
    					"OR procedimiento.tipoprocedimiento = '1086' OR procedimiento.tipoprocedimiento = '1090' OR procedimiento.tipoprocedimiento = '1147')"+
    					"AND imp_hoja_implante.idhojaimp = imp_implante.idhojaimp " +
    					"AND imp_generador.idhojaimp = imp_hoja_implante.idhojaimp AND generador.idgenerador = imp_generador.idgenerador ");
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 11){
        		sql.append(" AND holter.fechacolocacion >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        		sql.append(" AND holter.idholter = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1089" );
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 12){
        		sql.append(" AND registrador_eventos_ext.fechacolocacion >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        		sql.append(" AND registrador_eventos_ext.idevento = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1091" );
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 12){
        		sql.append(" AND test_ortostatismo_activo.fecha >= '" + UtilFechas.dateToString(paciente.getFechaproc()) + "' ");
        		sql.append(" AND test_ortostatismo_activo.idtest = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1092" );
        	}
    		sql.append(generaWherePorTipoProcedimiento(paciente));	
        }
        if(paciente.getFechaprocfin()!=null ){
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 1){
        		sql.append(" AND arr_estudio.fecha <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' "); 
        		//sql.append(" AND arr_estudio.idestudio = procedimiento.idprocedimiento" );
            	//sql.append(" AND procedimiento.tipoprocedimiento = 1061" );
        	}	         	
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 2)
        		sql.append(" AND arr_cardioversion.fecha <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 3)
        		sql.append(" AND arr_registrador.idmodeloreg = registradoreventos.idregistrador AND arr_registrador.fecha <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 4)
        		sql.append(" AND arr_mesas.fecha <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 5)
        		sql.append(" AND arr_test_atp.fecha <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 6)
        		sql.append(" AND arr_test_epi.fecha <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 7)
        		sql.append(" AND arr_test_fle.fecha <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");  
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 8){
        		sql.append(" AND procedimiento.fecha <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");
        		sql.append(" AND imp_implante.idimplante = procedimiento.idprocedimiento" );
        		sql.append(" AND (procedimiento.tipoprocedimiento = '956' OR procedimiento.tipoprocedimiento = '957' OR procedimiento.tipoprocedimiento = '1059'" +
    					"OR procedimiento.tipoprocedimiento = '1060' OR procedimiento.tipoprocedimiento = '993' OR procedimiento.tipoprocedimiento = '1085' " +
    					"OR procedimiento.tipoprocedimiento = '1086' OR procedimiento.tipoprocedimiento = '1090' OR procedimiento.tipoprocedimiento = '1147')"+
    					"AND imp_hoja_implante.idhojaimp = imp_implante.idhojaimp " +
    					"AND imp_generador.idhojaimp = imp_hoja_implante.idhojaimp AND generador.idgenerador = imp_generador.idgenerador ");
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 11){
        		sql.append(" AND holter.fechacolocacion <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");
        		sql.append(" AND holter.idholter = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1089" );
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 12){
        		sql.append(" AND registrador_eventos_ext.fechacolocacion <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");
        		sql.append(" AND registrador_eventos_ext.idevento = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1091" );
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 13){
        		sql.append(" AND test_ortostatismo_activo.fecha <= '" + UtilFechas.dateToString(paciente.getFechaprocfin()) + "' ");
        		sql.append(" AND test_ortostatismo_activo.idtest = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1092" );
        	}
    		sql.append(generaWherePorTipoProcedimiento(paciente));
        }
        if(paciente.getFechaproc()==null && paciente.getFechaprocfin()==null && paciente.getNproc().equals("") && paciente.getNproc().length()==0){
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 1){
        		sql.append(" AND arr_estudio.idestudio is not null");
        		//sql.append(" AND arr_estudio.idestudio = procedimiento.idprocedimiento" );
            	//sql.append(" AND procedimiento.tipoprocedimiento = 1061" );
        	}
        		          	
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 2)
        		sql.append(" AND codigo_cardioversion is not null");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 3)
        		sql.append(" AND arr_registrador.idmodeloreg = registradoreventos.idregistrador AND id_registrador is not null");	
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 4)
        		sql.append(" AND id_mesa is not null");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 5)
        		sql.append(" AND arr_test_atp.codigo_test is not null");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 6)
        		sql.append(" AND arr_test_epi.codigo_test is not null");
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 7)
        		sql.append(" AND arr_test_fle.codigo_test is not null"); 
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 8){
        		sql.append(" AND imp_implante.idimplante is not null");
        		sql.append(" AND imp_implante.idimplante = procedimiento.idprocedimiento" );
        		sql.append(" AND (procedimiento.tipoprocedimiento = '956' OR procedimiento.tipoprocedimiento = '957' OR procedimiento.tipoprocedimiento = '1059'" +
    					"OR procedimiento.tipoprocedimiento = '1060' OR procedimiento.tipoprocedimiento = '993' OR procedimiento.tipoprocedimiento = '1085' " +
    					"OR procedimiento.tipoprocedimiento = '1086' OR procedimiento.tipoprocedimiento = '1090' OR procedimiento.tipoprocedimiento = '1147')" +
    					"AND imp_hoja_implante.idhojaimp = imp_implante.idhojaimp " +
    					"AND imp_generador.idhojaimp = imp_hoja_implante.idhojaimp AND generador.idgenerador = imp_generador.idgenerador ");
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 11){
        		sql.append(" AND holter.idholter is not null");
        		sql.append(" AND holter.idholter = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1089" );
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 12){
        		sql.append(" AND registrador_eventos_ext.idevento is not null");
        		sql.append(" AND registrador_eventos_ext.idevento = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1091" );
        	}
        	if(paciente.getTipoproc()!=null && paciente.getTipoproc() == 13){
        		sql.append(" AND test_ortostatismo_activo.idtest is not null");
        		sql.append(" AND test_ortostatismo_activo.idtest = procedimiento.idprocedimiento" );
            	sql.append(" AND procedimiento.tipoprocedimiento = 1092" );
        	}
    		sql.append(generaWherePorTipoProcedimiento(paciente));	
        }
        if(paciente.getTipoproc()!=null && paciente.getTipoproc()==0){ // Se agrupa para no devolver tropecientos pacientes iguales
        	sql.append(" GROUP BY arr_pacientes.codigo, arr_pacientes.nuhsa, arr_pacientes.nhc," +
            		"arr_pacientes.nombre, arr_pacientes.apellid1, arr_pacientes.apellid2,"+
            		"arr_pacientes.sexo, arr_pacientes.fechaNaci, arr_pacientes.dni, arr_pacientes.nss1,"+
            		"arr_pacientes.direccion, arr_pacientes.provincia, arr_pacientes.poblacion, arr_pacientes.pais,"+
            		"arr_pacientes.cp, arr_pacientes.estado, arr_pacientes.telefono1, arr_pacientes.telefono2,"+
            		"arr_pacientes.correo, arr_pacientes.procedencia, arr_pacientes.hprocedencia order by apellid1");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==1){
        	sql.append(" GROUP BY arr_estudio.idestudio order by fechaeef");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==2){
        	sql.append(" GROUP BY arr_cardioversion.codigo_cardioversion order by fechacv");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==3){
        	sql.append(" GROUP BY arr_registrador.id_registrador order by fechareg");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==4){
        	sql.append(" GROUP BY arr_mesas.id_mesa order by fechamesa");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==5){
        	sql.append(" GROUP BY arr_test_atp.codigo_test order by fechaatp");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==6){
        	sql.append(" GROUP BY arr_test_epi.codigo_test order by fechaepi");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==7){
        	sql.append(" GROUP BY arr_test_fle.codigo_test order by fechafle");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==8){
        	sql.append(" GROUP BY procedimiento.tipoprocedimiento, imp_implante.idimplante order by fechaimp");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==11){
        	sql.append(" GROUP BY procedimiento.tipoprocedimiento, holter.idholter order by fechacolocacion");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==12){
        	sql.append(" GROUP BY procedimiento.tipoprocedimiento, registrador_eventos_ext.idevento order by fechacolocacion");
        }else if(paciente.getTipoproc()!=null && paciente.getTipoproc()==13){
        	sql.append(" GROUP BY procedimiento.tipoprocedimiento, test_ortostatismo_activo.idtest order by fechatestorto");
        }
        
        ArrayList<PacienteAplDto> resultado = (ArrayList<PacienteAplDto>)consultarDtosFromSQL(sql.toString(),
        		PacienteAplDto.class);
        
        if(!paciente.getTipoproc().equals(8)) // Se controla de esta manera porque los implantes ya vienen especificados el valor de TIPO_PROCEDIMIENTO
	        for(PacienteAplDto p:resultado)
	        	p.setTipoproc(paciente.getTipoproc());
        
        if(resultado != null)
            return resultado;
        else
            return new ArrayList<PacienteAplDto>();
    }
    
    private String generaWherePorTipoProcedimiento(PacienteAplDto filtro){
    	String res = "";
    	if(filtro.getTipoproc().equals(1)){ // EEF
    		if(filtro.getDiagEef()!=null && !filtro.getDiagEef().equals(0))
    			res = res + " AND arr_estudio.diagnostico = "+filtro.getDiagEef()+" ";
    		if(filtro.getAblEef()!=null && !filtro.getAblEef().equals(-1)){
    			res = res + " AND arr_estudio.ablacion = "+filtro.getAblEef()+" ";
    			if(filtro.getAblEef().equals(2) && (filtro.getSustAblEef()!=null && !filtro.getSustAblEef().equals(0)))
    				res = res + " AND arr_estudio.idestudio = arr_estudio_ablacion.idestudio AND arr_estudio_ablacion.idnodo = "+filtro.getSustAblEef();
    		}
    	}
    	if(filtro.getTipoproc().equals(3)){ // REGISTRADOR DE EVENTOS 
    		if(filtro.getModeloRegEv()!=null && !filtro.getModeloRegEv().equals("")){
    			res = " AND registradoreventos.modelo LIKE '%"+filtro.getModeloRegEv()+"%'";
    			if(filtro.getNumserieRegEv()!=null && !filtro.getNumserieRegEv().equals(""))
    				res = res + " AND arr_registrador.nserie LIKE '%"+filtro.getNumserieRegEv()+"%'";
    		}else{
    			if(filtro.getNumserieRegEv()!=null && !filtro.getNumserieRegEv().equals("")){
    				res = " AND arr_registrador.nserie LIKE '%"+filtro.getNumserieRegEv()+"%'";
    				if(filtro.getModeloRegEv()!=null && !filtro.getModeloRegEv().equals(""))
    					res = res + " AND registradoreventos.modelo LIKE '%"+filtro.getModeloRegEv()+"%'";
    			}
    		}
    	}
    	if(filtro.getTipoproc().equals(8)){// IMPLANTES
    		if(filtro.getModeloGen()!=null && !filtro.getModeloGen().equals("")){
    			res =" AND generador.modelo LIKE '%"+filtro.getModeloGen()+"%'";
    			if(filtro.getNumserieGen()!=null && !filtro.getNumserieGen().equals(""))
            		res = res + " AND imp_generador.numserie LIKE '%"+filtro.getNumserieGen()+"%'";
        	}
    		else{
    			if(filtro.getNumserieGen()!=null && !filtro.getNumserieGen().equals("")){
        			res =" AND imp_generador.numserie LIKE '%"+filtro.getNumserieGen()+"%' ";
        			if(filtro.getModeloGen()!=null && !filtro.getModeloGen().equals(""))
        				res = res + " AND generador.modelo LIKE '%"+filtro.getModeloGen()+"%'";
        		}
    		} 
    	}
    	if(filtro.getTipoproc().equals(11)){ // HOLTER24H
    		if(filtro.getEstadoprocfiltro()!=null && !filtro.getEstadoprocfiltro().equals(-100))
    			res =" AND holter.estado = "+filtro.getEstadoprocfiltro();
    	}
    	if(filtro.getTipoproc().equals(12)){ // ELR
    		if(filtro.getEstadoprocfiltro()!=null && !filtro.getEstadoprocfiltro().equals(-100))
    			res =" AND registrador_eventos_ext.estado = "+filtro.getEstadoprocfiltro();
    	}
    	return res;
    }
    
    /**
     * Método que modifica un registro de un paciente con los parámetros pasado.
     * 
     * @author jofuga00
     * @param paciente
     * @return 1 si todo correcto 0 en caso contrario.
     * @throws DAOException
     * @version 1.0; 06/07/2010
     */
    public int modificaPaciente(PacienteAplDto paciente) throws DAOException{
        
        int estado = 1;
        
        StringBuffer sql = new StringBuffer();
        StringBuffer campo = new StringBuffer();

        if(paciente.getNombre() != null)
            campo.append("NOMBRE = '" + paciente.getNombre().toUpperCase() + "'");
        if(paciente.getNuhsa() != null)
        	campo.append(", NUHSA = '" + paciente.getNuhsa().toUpperCase() + "'");
        if(paciente.getNhc() != null)
            campo.append(", NHC = '" + paciente.getNhc().toUpperCase() + "'");
        if(paciente.getApellid1() != null)
            campo.append(", APELLID1 = '" + paciente.getApellid1().toUpperCase() + "'");
        if(paciente.getApellid2() != null)
            campo.append(", APELLID2 = '" + paciente.getApellid2().toUpperCase() + "'");
        if(paciente.getSexo() != null)
            campo.append(", SEXO = " + paciente.getSexo().toString());
        if(paciente.getFechaNaci() != null)
            campo.append(", FECHANACI = " + "STR_TO_DATE('" + UtilFechas.dateToString(paciente.getFechaNaci()) + "', '%Y/%m/%d')");
        if(paciente.getDni() != null)
            campo.append(", DNI = '" + paciente.getDni().toUpperCase() + "'");
        if(paciente.getNss1() != null)
            campo.append(", NSS1 = '" + paciente.getNss1().toUpperCase() + "'");
        if(paciente.getDireccion() != null)
            campo.append(", DIRECCION = '" + paciente.getDireccion() + "'");
        if(paciente.getProvincia() != null)
            campo.append(", PROVINCIA = '" + paciente.getProvincia() + "'");
        if(paciente.getPoblacion() != null)
            campo.append(", POBLACION = '" + paciente.getPoblacion() + "'");
        if(paciente.getPais() != null)
            campo.append(", PAIS = '" + paciente.getPais() + "'");
        if(paciente.getCp() != null)
            campo.append(", CP = '" + paciente.getCp() + "'");
        if(paciente.getEstado() != null)
            campo.append(", ESTADO = '" + paciente.getEstado() + "'");
        if(paciente.getTelefono1() != null)
            campo.append(", TELEFONO1 = '" + paciente.getTelefono1() + "'");
        if(paciente.getTelefono2() != null)
            campo.append(", TELEFONO2 = '" + paciente.getTelefono2() + "'");
        if(paciente.getCorreo() != null)
            campo.append(", CORREO = '" + paciente.getCorreo() + "'");
        if(paciente.getProcedencia() != null && paciente.getProcedencia() > 0)
            campo.append(", PROCEDENCIA = '" + paciente.getProcedencia() + "'");
        if(paciente.getHprocedencia() != null && paciente.getHprocedencia() > 0)
            campo.append(", HPROCEDENCIA = '" + paciente.getHprocedencia() + "'");
        
        sql.append("UPDATE arr_pacientes SET " + campo) ;
        sql.append(" WHERE codigo = '" + paciente.getCodigo() + "' ");

        estado = procesarSQL(sql.toString());
        
        auditoriaDto.setAccion(AuditoriaDto.modificacion);
        auditoriaDto.setDescri(sql.toString());
        auditoriaDto.setTabla("idea.arr_pacientes");
        auditoriaDao.escribeAuditoria(auditoriaDto);

        return estado;
        
    }
    
    public int eliminaPaciente(PacienteAplDto paciente) throws DAOException{
        int estado = 1;
        
        StringBuffer sql = new StringBuffer();
        
        sql.append("DELETE FROM arr_pacientes WHERE codigo = " + paciente.getCodigo());
        
        estado = procesarSQL(sql.toString());
        
        auditoriaDto.setAccion(AuditoriaDto.borrado);
        auditoriaDto.setDescri(sql.toString());
        auditoriaDto.setTabla("idea.arr_pacientes");
        auditoriaDao.escribeAuditoria(auditoriaDto);
        
        return estado;
    }
    
    public Integer cuentaSexo(Integer sexo) throws DAOException{
        
        String sql = "SELECT count(sexo) as \"sexo\" FROM arr_pacientes WHERE sexo = " + sexo;
        
        List<Map> resultado = consultarSQL(sql);
        
        if(resultado != null)
            return Integer.parseInt(resultado.get(0).get("sexo").toString().trim());
        else
            return 0;
    }
    
    public List<Map> getEstadisticas(String nhcs) throws DAOException{
    	StringBuffer sql = new StringBuffer();
    	sql.append("select pa.nhc NHC,");
    	sql.append("pa.FECHANACI NACIMIENTO,");
    	sql.append("pa.sexo SEXO,");
    	sql.append("m2.VALOR HOSPITAL_PROCEDENCIA,");
    	sql.append("m1.VALOR CARACTER_PROCEDENCIA,");
    	sql.append("clin.idcardio CARDIOPATIA,");
    	sql.append("clin.tipocardio TIPO_CARDIOPATIA,"); 
    	sql.append("clin.otrasstr OTRAS_CARDIOPATIAS,");
    	sql.append("clin.fevi FEVI,");
    	sql.append("clin.funcion FUNCION_VENTRICULAR,");
    	sql.append("clin.hta FACT_HTA,");
    	sql.append("clin.dislipemia FACT_DISLIPEMIA,");
    	sql.append("clin.diabetes FACT_DIABETES,");
    	sql.append("clin.tabaquismo FACT_TABAQUISMO,");
    	sql.append("clin.acv ANT_ACV,");
    	sql.append("clin.insuf ANT_INSUF,");
    	sql.append("clin.saos ANT_SAOS,");
    	sql.append("clin.afecta ANT_TIROIDEA,");
    	sql.append("car.id1 FIBRI_AURICU,");
    	sql.append("car.id2 ARR_VENT_SOS,");
    	sql.append("car.id3 INS_CAR,");
    	sql.append("car.id4 SINCOPE,");
    	sql.append("car.id5 PARADA_CARD,");
    	sql.append("car.id6 CV,");
    	sql.append("car.id7 PORTADORDAI,");
    	sql.append("car.id8 PORTADORMP,");
    	sql.append("pa.NOMBRE NOMBRE,");
    	sql.append("pa.APELLID1 AP1,");
    	sql.append("pa.APELLID2 AP2,");
    	sql.append("pa.NUHSA NUHSA");
    	sql.append(" from");
    	sql.append(" arr_pacientes pa"); 
    	sql.append(" left outer join arr_maestras m1 on pa.procedencia = m1.codigo");
    	sql.append(" left outer join arr_maestras m2 on pa.hprocedencia = m2.codigo,"); 
    	sql.append(" arr_paciente_hcardio car, arr_paciente_hclin clin");
    	sql.append(" where pa.codigo = car.idpaciente");
    	sql.append(" and pa.codigo = clin.idpaciente");
    	sql.append(" and pa.nhc in " + nhcs);
    	//sql.append(" where pa.nhc in " + nhcs);
    	sql.append(" order by 1");
    	
    	List<Map> resultado = consultarDtosFromSQL(sql.toString(),EstadisticaDto.class);
    	return resultado;
    }
    
    
    public int obtenerNumPaciente() throws DAOException{
   	 String sql = "SELECT count(*) as \"total\" FROM arr_pacientes"; 
        List<Map> resultado = consultarSQL(sql);
        //System.out.println("#PACIENTES PREVIO INSERCION: "+Integer.parseInt(resultado.get(0).get("total").toString().trim()));
        if(resultado != null)
            return Integer.parseInt(resultado.get(0).get("total").toString().trim());
        else
            return 0;
       
   }
    

}

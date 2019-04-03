package com.sorin.idea.dao;

import java.util.ArrayList;

import hvn.apl.evomed.util.UtilFechas;
import hvn.apl.evomed.ssh.exception.SshException;
import hvn.apl.evomed.dto.AuditoriaDto;
import hvn.apl.evomed.dto.DocHl7Dto;
import hvn.apl.jpacientes.dto.MaestraSimpleDto;



import hvn.cm.dao.BaseDao;
import hvn.cm.dao.DAOException;
import hvn.cm.utiles.UtilBd;

public class DocHL7InformesDao extends BaseDao {
    static final public long serialVersionUID = 1;
    public static int        ok               = 1;
    AuditoriaDao             auditoriaDao     = new AuditoriaDao();
    AuditoriaDto             auditoriadto     = null;

    protected void iniciarDao() {
        this.setDePool(true);
        this.nombreConector = "poolClinicaBD";
    }

    public DocHL7InformesDao(String usuario) {
        auditoriadto = new AuditoriaDto(usuario, "doc_hl7informes");
    }

    public int añadirDocHL7Informes(DocHl7Dto linea )
        throws DAOException, SshException {
        StringBuffer sql = new StringBuffer();
        StringBuffer campo = new StringBuffer();
        StringBuffer valor = new StringBuffer();

        campo.append(" idinfor");
        valor.append(UtilBd.prepararCampo(linea.getIdinfor()));

        campo.append(",idinforext");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getIdinforext()));

        campo.append(",idsubti");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getIdsubti()));

        campo.append(",idtipodoc");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getIdtipodoc()));

        campo.append(",idformato");
        valor.append(",");
        valor.append(UtilBd.prepararCampo("PDF"));

        campo.append(",idpetic");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getIdpetic()));

        campo.append(",episodio");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getEpisodio()));

        campo.append(",nhc");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(new Integer(linea.getNhc())));

        campo.append(",redactor");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getRedactor()));

        campo.append(",responprime");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getResponprime()));

        campo.append(",responsegun");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getResponprime()));

        campo.append(",idestado");
        valor.append(",");
        valor.append(UtilBd.prepararCampo("F"));

        campo.append(",fcreacion");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(UtilFechas.dateToString(linea.getFcreacion())));

        campo.append(",hcreacion");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(UtilFechas.horaMinutoToString(linea.getFcreacion())));

        campo.append(",fmodificacion");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(UtilFechas.dateToString(UtilFechas.getFecha())));

        campo.append(",hmodificacion");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(UtilFechas.horaMinutoToString(UtilFechas.getFecha())));

        campo.append(",fcierre");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(UtilFechas.dateToString(linea.getFcreacion())));

        campo.append(",hcierre");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(UtilFechas.horaMinutoToString(linea.getFcreacion())));

        campo.append(",nivelacceso");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(5));

        campo.append(",handle");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getHandle()));

        campo.append(",servicio");
        valor.append(",");
        valor.append(UtilBd.prepararCampo(linea.getServicio()));

        sql.append("INSERT INTO doc_hl7informes (" + campo + ") VALUES (" + valor + ")");

        auditoriadto.setAccion(AuditoriaDto.insercion);
        auditoriadto.setDescri(sql.toString());
      //  auditoriaDao.escribeAuditoria(auditoriadto);

        return procesarSQL(sql.toString());
    }
    


    public int modificarDocHL7Informes(DocHl7Dto consulta)
        throws DAOException {
        int estado = ok;

        StringBuffer sql = new StringBuffer();
        sql.append(" update doc_hl7informes set nhc = "
            + UtilBd.prepararCampo(new Integer(consulta.getNhc())));
        sql.append(",redactor = " + UtilBd.prepararCampo(consulta.getRedactor()));
        sql.append(",responprime = " + UtilBd.prepararCampo(consulta.getResponprime()));
        sql.append(",responsegun = " + UtilBd.prepararCampo(consulta.getResponprime()));
        sql.append(",fmodificacion = " + UtilBd.prepararCampo(UtilFechas.dateToString(UtilFechas.getFecha())));
        sql.append(",hmodificacion = "
            + UtilBd.prepararCampo(UtilFechas.horaMinutoToString(UtilFechas.getFecha())));

        sql.append(" where idinfor = " + UtilBd.prepararCampo(consulta.getIdinfor()));

        procesarSQL(sql.toString());

        auditoriadto.setAccion(AuditoriaDto.modificacion);
        auditoriadto.setDescri(sql.toString());
        //auditoriaDao.escribeAuditoria(auditoriadto);

        return estado;
    }
    public String modificarDocHL7InformesSinNumicu(DocHl7Dto consulta)
    throws DAOException {
    int estado = ok;

    StringBuffer sql = new StringBuffer();
    sql.append(" update doc_hl7informes set nhc = "
        + UtilBd.prepararCampo(new Integer(consulta.getNhc())));
    sql.append(",redactor = " + UtilBd.prepararCampo(consulta.getRedactor()));
    sql.append(",responprime = " + UtilBd.prepararCampo(consulta.getResponprime()));
    sql.append(",responsegun = " + UtilBd.prepararCampo(consulta.getResponprime()));
    sql.append(",fmodificacion = " + UtilBd.prepararCampo(UtilFechas.dateToString(UtilFechas.getFecha())));
    sql.append(",hmodificacion = "
        + UtilBd.prepararCampo(UtilFechas.horaMinutoToString(UtilFechas.getFecha())));

    sql.append(" where nhc  = " + UtilBd.prepararCampo(consulta.getNhc())+" and idsubti = "+UtilBd.preparaCampoMB(consulta.getIdsubti())
        +" and episodio = "+UtilBd.preparaCampoMB(consulta.getEpisodio()));
    
    procesarSQL(sql.toString());

    auditoriadto.setAccion(AuditoriaDto.modificacion);
    auditoriadto.setDescri(sql.toString());
    //auditoriaDao.escribeAuditoria(auditoriadto);

    return getHalndlePorCodExt(consulta.getIdsubti(),consulta.getNhc(),consulta.getEpisodio());
   }
    
 public String getHalndlePorCodExt(String tipo,String nhc,String numicu) throws DAOException {
        
        StringBuffer sql = new StringBuffer();
        sql.append(" select handle codigo " );
        sql.append(" from doc_hl7informes  ");
        sql.append(" where 1=1  ");
        sql.append(" and nhc = "+nhc);
        sql.append(" and idsubti = '"+tipo+"'");
        if (numicu != null && !numicu.isEmpty())
            sql.append(" and episodio = "+numicu+"");
        
        MaestraSimpleDto maestra = (MaestraSimpleDto) consultarDtoFromSQL(sql.toString(), MaestraSimpleDto.class);
        if (maestra == null || maestra.getCodigo()==null)
            return null;
        else return maestra.getCodigo();
 }
 
 public String modificarDocHL7InformesIdExt(DocHl7Dto consulta)
 throws DAOException {
 int estado = ok;

 StringBuffer sql = new StringBuffer();
 sql.append(" update doc_hl7informes set nhc = "
     + UtilBd.prepararCampo(new Integer(consulta.getNhc())));
 sql.append(",redactor = " + UtilBd.prepararCampo(consulta.getRedactor()));
 sql.append(",responprime = " + UtilBd.prepararCampo(consulta.getResponprime()));
 sql.append(",episodio = " + UtilBd.prepararCampo(consulta.getEpisodio()));
 sql.append(",responsegun = " + UtilBd.prepararCampo(consulta.getResponprime()));
 sql.append(",fmodificacion = " + UtilBd.prepararCampo(UtilFechas.dateToString(UtilFechas.getFecha())));
 sql.append(",hmodificacion = "
     + UtilBd.prepararCampo(UtilFechas.horaMinutoToString(UtilFechas.getFecha())));

 sql.append(" where nhc  = " + UtilBd.prepararCampo(consulta.getNhc())+" and idsubti = "+UtilBd.preparaCampoMB(consulta.getIdsubti())
     +" and idinforext = "+UtilBd.preparaCampoMB(consulta.getIdinforext()));
 
 procesarSQL(sql.toString());

 auditoriadto.setAccion(AuditoriaDto.modificacion);
 auditoriadto.setDescri(sql.toString());
 //auditoriaDao.escribeAuditoria(auditoriadto);

 return getHalndlePorIdExt(consulta.getIdsubti(),consulta.getNhc(),consulta.getIdinforext());
}


public String getHalndlePorIdExt(String tipo,String nhc,String idext) throws DAOException {
     
     StringBuffer sql = new StringBuffer();
     sql.append(" select handle codigo " );
     sql.append(" from doc_hl7informes  ");
     sql.append(" where 1=1  ");
     sql.append(" and nhc = "+nhc);
     sql.append(" and idsubti = '"+tipo+"'");
     sql.append(" and idinforext = '"+idext+"' ");
     
     MaestraSimpleDto maestra = (MaestraSimpleDto) consultarDtoFromSQL(sql.toString(), MaestraSimpleDto.class);
     if (maestra == null || maestra.getCodigo()==null)
         return null;
     else return maestra.getCodigo();
}
 
}

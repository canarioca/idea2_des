package com.sorin.idea.dto;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import com.sorin.idea.util.UtilCodifi;

import hvn.cm.bdu.dao.PacienteDao;
import hvn.cm.bdu.dto.PacienteBduBean;
import hvn.cm.bdu.dto.PacienteDto;
import hvn.cm.bdu.modelo.GestorPaciente;

public class ModeloBdu
{
    GestorPaciente gp = new GestorPaciente();
    
    public List<PacienteBduBean> buscaPacienteBduPorPacienteDto(PacienteAplDto paciente, FacesContext contexto)
    throws Exception{
        PacienteDto pacientebdu = new PacienteDto();
        
        /**
         * Apellido1
         */
        //Comprobamos si tiene vocales acentuadas
        paciente.setApellid1(UtilCodifi.compruebaTildes(paciente.getApellid1()));
        //Lo pasamos todo a mayúsculas
        pacientebdu.setApellido1(paciente.getApellid1().toUpperCase());
        //Comprobamos si tiene espacios o la ñ
        pacientebdu.setApellido1(UtilCodifi.compruebaSpEnye(pacientebdu.getApellido1()));
        
        /**
         * Apellido2
         */
        //Comprobamos si tiene vocales acentuadas
        paciente.setApellid2(UtilCodifi.compruebaTildes(paciente.getApellid2()));
        //Lo pasamos todo a mayúsculas
        pacientebdu.setApellido2(paciente.getApellid2().toUpperCase());
        //Comprobamos si tiene espacios o la ñ
        pacientebdu.setApellido2(UtilCodifi.compruebaSpEnye(pacientebdu.getApellido2()));
        
        /**
         * Nombre
         */
        //Comprobamos si tiene vocales acentuadas
        paciente.setNombre(UtilCodifi.compruebaTildes(paciente.getNombre()));
        //Lo pasamos todo a mayúsculas
        pacientebdu.setNombre(paciente.getNombre().toUpperCase());
        //Comprobamos si tiene espacios o la ñ
        pacientebdu.setNombre(UtilCodifi.compruebaSpEnye(pacientebdu.getNombre()));
        
        /**
         * Año
         */
        //Incluimos la fecha de nacimiento en la consulta para acotar más el resultado.
        pacientebdu.setFechaNacimiento(paciente.getFechaNaci());
        
        List<PacienteBduBean> lista = new ArrayList<PacienteBduBean>();
        
            PacienteDao pacienteDao = new PacienteDao("", contexto);
            
            lista = pacienteDao.getPacienteBduByPacienteDto(pacientebdu);

            if (lista != null) 
            return lista;
        else
            return null;
    }
    
    public List<PacienteBduBean> buscaPacienteBduPorNIF(PacienteAplDto paciente, FacesContext contexto)
    throws Exception{
        PacienteDto pacientebdu = new PacienteDto();
        String aux;
        
        if(paciente.getDni() == null || paciente.getDni().equals(""))
            throw new Exception("El campo DNI está vacío.");
        else if(paciente.getDni().matches("^((\\d{8}|\\d{9})([A-Z]|[a-z]))$"))
            aux = paciente.getDni().substring(0, paciente.getDni().length()-1);
        else{
            if(UtilCodifi.isNumeric(paciente.getDni()))
                aux = paciente.getDni();
            else
                throw new Exception("El campo DNI debe ser de la forma 099999999L.");
        }
        
        if(!UtilCodifi.isNumeric(aux))
            throw new Exception("El campo DNI debe ser de la forma 099999999L.");
            
            
        pacientebdu.setDni(Integer.parseInt(aux));
        
        List<PacienteBduBean> lista = new ArrayList<PacienteBduBean>();
        
            PacienteDao pacienteDao = new PacienteDao("", contexto);
            
            lista = pacienteDao.getPacienteBduByPacienteDto(pacientebdu);

            if (lista != null) 
            return lista;
        else
            return null;
    }
    
    public List<PacienteBduBean> buscaPacienteBduPorNSS(PacienteAplDto paciente, FacesContext contexto)
    throws Exception{
        PacienteDto pacientebdu = new PacienteDto();
        
        if(paciente.getNss1() == null || paciente.getNss1().equals(""))
            throw new Exception("El campo NSS está vacío.");
        else if(!UtilCodifi.isNumericLong(paciente.getNss1()))
            throw new Exception("El campo NSS debe ser un número.");
            
        pacientebdu.setNss(Long.parseLong(paciente.getNss1().trim()));
        
        List<PacienteBduBean> lista = new ArrayList<PacienteBduBean>();
        
            PacienteDao pacienteDao = new PacienteDao("", contexto);
            
            lista = pacienteDao.getPacienteBduByPacienteDto(pacientebdu);

            if (lista != null) 
            return lista;
        else
            return null;
    }
    
    public List<PacienteBduBean> buscaPacienteBduPorNUHSA(PacienteAplDto paciente, FacesContext contexto)
    throws Exception{
        PacienteDto pacientebdu = new PacienteDto();
        
        if(paciente.getNuhsa() == null || paciente.getNuhsa().equals(""))
            throw new Exception("El campo NUHSA está vacío.");
            
        pacientebdu.setNuhsa(paciente.getNuhsa());
        
        List<PacienteBduBean> lista = new ArrayList<PacienteBduBean>();
        
            PacienteDao pacienteDao = new PacienteDao("", contexto);
            
            lista = pacienteDao.getPacienteBduByPacienteDto(pacientebdu);

            if (lista != null) 
            return lista;
        else
            return null;
    }
}

package com.sorin.idea.reportes;


import hvn.cm.dao.DAOException;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.sorin.idea.dao.ConstantesDao;
import com.sorin.idea.dto.AuditoriaDto;
import com.sorin.idea.util.UtilFechas;

public class ReporteAuditoria {
    
	private static Logger logger = Logger.getLogger(ReporteAuditoria.class);
    ArrayList<AuditoriaDto> auditoria = new ArrayList<AuditoriaDto>();
    String usuario = "";
    public String pathFichero;
    private String rutaImagen;
	private ConstantesDao constanteDao = new ConstantesDao();
	HttpServletRequest req = (HttpServletRequest) FacesContext
    .getCurrentInstance().getExternalContext().getRequest();
    
    public ReporteAuditoria(String path, String usuario, ArrayList<AuditoriaDto> auditoria){
        this.pathFichero = path;
        this.usuario = usuario;
        this.auditoria = auditoria;
        try {
			this.rutaImagen = this.constanteDao.getValor("RutaImagen");
		} catch (DAOException e) {
			this.rutaImagen = "/reportes/img/logo_sorin_informes.png";
		}
    }
    
    public void GeneraArchivoPlanilla() {
        Element root = new Element("Listado");
        
        File fg = new File(req.getRealPath(rutaImagen));
        root.addContent(new Element("rutaImagen").setText(fg.getAbsolutePath()));
        root.addContent(new Element("fimpresion").setText(UtilFechas.getFechaActual() + " " + UtilFechas.getHora()));
        root.addContent(new Element("login").setText(this.usuario));
        root.addContent(this.creaAuditorias());
        
        Document doc = new Document(root);
        
        try {
            XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
            // XMLOutputter out= new XMLOutputter();
            FileOutputStream file = new FileOutputStream(pathFichero);
            out.output(doc, file);
            file.flush();
            file.close();
            //out.output(doc, System.out);
        }
        catch (Exception e) {
            e.printStackTrace();
            logger.error("Error generando fichero XML para informe - Reporte Auditoría. Motivo: "+e.getMessage(),e);
        }
    }
    
    private Element creaAuditorias(){
        Element auditorias = new Element("auditorias");
        
        for(int i = 0; i < this.auditoria.size(); ++i){
            Element audito = new Element("auditoria");
            audito.addContent(new Element("codigo").setText(auditoria.get(i).getCodigo()!=null?auditoria.get(i).getCodigo().toString():null));
            audito.addContent(new Element("usuario").setText(auditoria.get(i).getUsuario()!=null?auditoria.get(i).getUsuario():null));
            audito.addContent(new Element("tabla").setText(auditoria.get(i).getTabla()!=null?auditoria.get(i).getTabla():null));
            audito.addContent(new Element("accion").setText(auditoria.get(i).getAccionString()!=null?auditoria.get(i).getAccionString():null));
            audito.addContent(new Element("fecha").setText(auditoria.get(i).getFechaHoraString()!=null?auditoria.get(i).getFechaHoraString():null));
            auditorias.addContent(audito);
        }
        return auditorias;
    }

}

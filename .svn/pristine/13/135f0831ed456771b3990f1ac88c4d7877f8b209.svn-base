package com.sorin.idea.iu;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.math3.stat.Frequency;
import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;
import org.richfaces.component.html.HtmlExtendedDataTable;

import com.sorin.idea.dao.ArrAccesoDao;
import com.sorin.idea.dao.AuditoriaDao;
import com.sorin.idea.dto.ArrAcceso;
import com.sorin.idea.dto.AuditoriaDto;
import com.sorin.idea.exceptions.ArrAccesoDaoException;
import com.sorin.idea.jdbc.ArrAccesoDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.UtilDatos;
import com.sorin.idea.util.UtilFechas;

import hvn.cm.dao.DAOException;
import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

public class ControlAuditoria extends BaseIU {
	
	private static Logger logger = Logger.getLogger(ControlAuditoria.class);
	private static final long       serialVersionUID = 1L;

    private String                  usuario;

    private HtmlDataTable   bindingTabla;
    private HtmlDataTable   bindingAccesoUsuarios;
    private HtmlDataTable   bindingAccesoUsuariosEst;
    private Integer                 pagina_inicial   = 1;
    private Integer                 pagina_inicial_acc   = 1;
    private Integer                 pagina_inicial_nacc   = 1;
    private ArrayList<AuditoriaDto> auditoria;
    private ArrayList<AuditoriaDto> accesosUsuarios;
    private ArrayList<ArrAcceso> accesosUsuariosEst;
    private ArrAccesoDao userdao;

    private Date                    desde            = UtilFechas.getFecha();
    private Date                    hasta            = UtilFechas.getFecha();
    private Timestamp               desdeFH;
    private Timestamp               hastaFH;
    
    private Integer numUsuarios;
    private Integer numAccesos;
    private SelectorIdioma si;
	private ResourceBundle bundle;

    public ControlAuditoria() {
        try {
            LoginForm loginform;
            loginform = (LoginForm) getBean("loginForm");
            this.usuario = loginform.getSesionUsuario().getUsuario();
            this.auditoria = new ArrayList<AuditoriaDto>();
            this.accesosUsuarios = new ArrayList<AuditoriaDto>();
            this.accesosUsuariosEst = new ArrayList<ArrAcceso>();
            this.userdao = new ArrAccesoDaoImpl(this.usuario);
            this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
        }
        catch (IUException e) {
            logError("Error no se ha podido recuperar los datos del usuario. ");
            logger.error("("+this.usuario+") Error al iniciar control de auditoria. Motivo: "+e.getMessage(),e);
        }
    }

    public void buscarAuditoria(ActionEvent event) {
        AuditoriaDao ga = new AuditoriaDao();
        this.auditoria.clear();
        this.accesosUsuarios.clear();
        this.accesosUsuariosEst.clear();
        Frequency f_user = new Frequency();
        try {
            this.auditoria = ga.getAuditorias(this.desdeFH,this.hastaFH);
            this.accesosUsuarios = ga.getAuditoriasAcceso(this.desdeFH,this.hastaFH);
            for(AuditoriaDto au:this.accesosUsuarios){
            	au.setUsuario(UtilDatos.obtenerUsuarioAuditoria(au.getDescri()));
            	f_user.addValue((String) au.getUsuario());
            }	
            /*for(AuditoriaDto au:this.auditoria){// Procesado de accesos
            	if(esAuditoriaAcceso(au)){
            		AuditoriaDto item = new AuditoriaDto();
                	item.setUsuario(UtilDatos.obtenerUsuarioAuditoria(au.getDescri()));
                	item.setFechahora(au.getFechahora());
                	this.accesosUsuarios.add(item);
                	f_user.addValue((String) item.getUsuario());
            	}
            }*/
            this.obtenerEstadisticaAcceso(f_user);
            logger.info("("+this.usuario+") Consulta de auditoria ");
        } catch (DAOException e) {
            pintaMensaje( 3, this.bundle.getString("audi_msg_1")+": " + e.getMessage());
            logger.error("("+this.usuario+") Error en consulta de auditoria. Motivo: "+e.getMessage(),e);
		}
    }

    public void limpiaAuditoria(ActionEvent event) {
        //this.auditoria;
        this.desde = UtilFechas.getFecha();
        this.hasta = UtilFechas.getFecha();
        this.pagina_inicial = 1;
        this.pagina_inicial_acc = 1;
        this.pagina_inicial_nacc = 1;
        this.auditoria.clear();
        this.accesosUsuarios.clear();
        this.accesosUsuariosEst.clear();
        this.numAccesos = 0;
        this.numUsuarios = 0;
    }

    public void imprimeInformeAuditoria(ActionEvent event) {
        if (this.usuario != null) {
            if (this.auditoria==null || this.auditoria.size() == 0) {
                this.pintaMensaje(ERROR, this.bundle.getString("audi_msg_2"));
            	/*nuevoMensaje(this.formulario.getId(), Mensaje.SEVERIDAD_ERROR,
                    "¡Atención!, no hay listado de auditoría para imprimir.",
                    "¡Atención!, no hay listado de auditoría para imprimir");*/
            } else {
                ConstructorPdf constructorPDF = new ConstructorPdf();
                String PathFicheroXml = "";
                GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

                try {
                    PathFicheroXml = generadorXML.imprimeInformeAuditoria(this.usuario, this.auditoria);
                }
                catch (Exception se) {
                    try {
                        /*nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
                            "Error generando documento,motivo: " + se.getMessage(),
                            "Error generando documento,Motivo: " + se.getMessage());*/
                    	this.pintaMensaje(ERROR, this.bundle.getString("audi_msg_3")+": " + se.getMessage());
                    }
                    catch (Exception e3) {}
                }

                try {
                    constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml,
                        "InformeAuditoria.jasper");
                }
                catch (Exception se) {
                    try {
                        nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
                            "Error imprimiendo documento,motivo: " + se.getMessage(),
                            "Error imprimiendo documento,Motivo: " + se.getMessage());
                    }
                    catch (Exception e2) {}
                }
            }
        } else
            nuevoMensaje(this.formulario.getId(), Mensaje.SEVERIDAD_ERROR,
                "Error, debe tener un usuario para poder imprimir.",
                "Error, debe tener un usuario para poder imprimir.");
    }

    public void imprimeInformeAuditoriaAccesos(ActionEvent event) {
        if (this.usuario != null) {
            if (this.accesosUsuarios==null || this.accesosUsuarios.size() == 0) {
                this.pintaMensaje(ERROR, this.bundle.getString("audi_msg_2"));
            } else {
                ConstructorPdf constructorPDF = new ConstructorPdf();
                String PathFicheroXml = "";
                GeneradorXml generadorXML = new GeneradorXml(FacesContext.getCurrentInstance());

                try {
                    PathFicheroXml = generadorXML.imprimeInformeAuditoria(this.usuario, this.accesosUsuarios);
                }
                catch (Exception se) {
                    try {
                        this.pintaMensaje(ERROR, this.bundle.getString("audi_msg_3")+": " + se.getMessage());
                    }
                    catch (Exception e3) {}
                }
                try {
                    constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(), PathFicheroXml, "InformeAuditoriaAccesos.jasper");
                }
                catch (Exception se) {
                    try {
                        nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
                            "Error imprimiendo documento,motivo: " + se.getMessage(),
                            "Error imprimiendo documento,Motivo: " + se.getMessage());
                    }
                    catch (Exception e2) {}
                }
            }
        } else
            nuevoMensaje(this.formulario.getId(), Mensaje.SEVERIDAD_ERROR,
                "Error, debe tener un usuario para poder imprimir.",
                "Error, debe tener un usuario para poder imprimir.");
    }
    
    public boolean esAuditoriaAcceso(AuditoriaDto au){
    	if(au!=null && (au.getAccion()!=null && au.getAccion().equals(2))
    		&& (au.getUsuario()!=null && au.getUsuario().toUpperCase().equals("LOGIN"))
    		&& (au.getTabla()!=null && au.getTabla().toUpperCase().endsWith("ARR_ACCESO")))
    		return true;
    	return false;
    }
    
    public void obtenerEstadisticaAcceso(Frequency frec){
    	try {
			ArrAcceso[] lista = this.userdao.findAll();
			for(ArrAcceso user:lista){
				Long num_acc = frec.getCount(user.getUsuario());
				user.setNumeroAccesos(num_acc.intValue());
				this.accesosUsuariosEst.add(user);
			}
			this.numUsuarios = lista.length;
			this.numAccesos = this.accesosUsuarios.size();
		} catch (Exception e) {
			this.pintaMensaje( ERROR, this.bundle.getString("audi_msg_4")+": " + e.getMessage());
			logger.error("("+this.usuario+") Error en generacion de auditoria: accesos de usuario. Motivo: "+e.getMessage(),e);
		}
    }
    
    /********************************************************
     ********************* GET / SET ************************ 
     ********************************************************/
    
    public HtmlDataTable getBindingTabla() {
        return bindingTabla;
    }

    public void setBindingTabla(HtmlDataTable bindingTabla) {
        this.bindingTabla = bindingTabla;
    }

    public Integer getPagina_inicial() {
        return pagina_inicial;
    }

    public void setPagina_inicial(Integer paginaInicial) {
        pagina_inicial = paginaInicial;
    }

    public ArrayList<AuditoriaDto> getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(ArrayList<AuditoriaDto> auditoria) {
        this.auditoria = auditoria;
    }

    public Date getDesde() {
        return desde;
    }

    public void setDesde(Date desde) {
        this.desdeFH = UtilFechas.dateToTimestamp(desde);
        this.desde = desde;
    }

    public Date getHasta() {
        return hasta;
    }

    public void setHasta(Date hasta) {
        this.hastaFH = UtilFechas.dateToTimestamp(hasta);
        this.hasta = hasta;
    }

    public Timestamp getDesdeFH() {
        return desdeFH;
    }

    public void setDesdeFH(Timestamp desdeFH) {
        this.desde = UtilFechas.TimestampToDate(desdeFH);
        this.desdeFH = desdeFH;
    }

    public Timestamp getHastaFH() {
        return hastaFH;
    }

    public void setHastaFH(Timestamp hastaFH) {
        this.hasta = UtilFechas.TimestampToDate(hastaFH);
        this.hastaFH = hastaFH;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

	public HtmlDataTable getBindingAccesoUsuarios() {
		return bindingAccesoUsuarios;
	}

	public void setBindingAccesoUsuarios(HtmlDataTable bindingAccesoUsuarios) {
		this.bindingAccesoUsuarios = bindingAccesoUsuarios;
	}

	public ArrayList<AuditoriaDto> getAccesosUsuarios() {
		return accesosUsuarios;
	}

	public void setAccesosUsuarios(ArrayList<AuditoriaDto> accesosUsuarios) {
		this.accesosUsuarios = accesosUsuarios;
	}

	public Integer getPagina_inicial_acc() {
		return pagina_inicial_acc;
	}

	public void setPagina_inicial_acc(Integer pagina_inicial_acc) {
		this.pagina_inicial_acc = pagina_inicial_acc;
	}

	public ArrayList<ArrAcceso> getAccesosUsuariosEst() {
		return accesosUsuariosEst;
	}

	public void setAccesosUsuariosEst(ArrayList<ArrAcceso> accesosUsuariosEst) {
		this.accesosUsuariosEst = accesosUsuariosEst;
	}

	public HtmlDataTable getBindingAccesoUsuariosEst() {
		return bindingAccesoUsuariosEst;
	}

	public void setBindingAccesoUsuariosEst(HtmlDataTable bindingAccesoUsuariosEst) {
		this.bindingAccesoUsuariosEst = bindingAccesoUsuariosEst;
	}

	public Integer getPagina_inicial_nacc() {
		return pagina_inicial_nacc;
	}

	public void setPagina_inicial_nacc(Integer pagina_inicial_nacc) {
		this.pagina_inicial_nacc = pagina_inicial_nacc;
	}

	public Integer getNumUsuarios() {
		return numUsuarios;
	}

	public void setNumUsuarios(Integer numUsuarios) {
		this.numUsuarios = numUsuarios;
	}

	public Integer getNumAccesos() {
		return numAccesos;
	}

	public void setNumAccesos(Integer numAccesos) {
		this.numAccesos = numAccesos;
	}

}

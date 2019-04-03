package com.sorin.idea.iu;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import hvn.cm.modelo.Mensaje;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.sorin.idea.dao.ArrPacienteDao;
import com.sorin.idea.dao.ArrPacientesDao;
import com.sorin.idea.dao.ComplicacionDao;
import com.sorin.idea.dao.ComplicacionesPacientesDao;
import com.sorin.idea.dao.ElectrodosDao;
import com.sorin.idea.dao.GeneradorDao;
import com.sorin.idea.dao.ImpEvolucionDao;
import com.sorin.idea.dao.ImpGeneradorDao;
import com.sorin.idea.dao.ImpHojaImplanteComplicacionDao;
import com.sorin.idea.dao.ImpHojaImplanteDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dao.ImpImplanteElectrodosDao;
import com.sorin.idea.dao.PacienteDao;
import com.sorin.idea.dao.ProcedimientoDao;
import com.sorin.idea.dao.SintomasSitclinProcDao;
import com.sorin.idea.dao.SituacionClinicaProcDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.SintomasSitclinProc;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.exportacion.ExportaRegistroDAI;
import com.sorin.idea.exportacion.ExportaTarjetaEuropeaMP;
import com.sorin.idea.jdbc.ArrPacientesDaoImpl;
import com.sorin.idea.jdbc.ComplicacionDaoImpl;
import com.sorin.idea.jdbc.ComplicacionesPacientesDaoImpl;
import com.sorin.idea.jdbc.ElectrodosDaoImpl;
import com.sorin.idea.jdbc.GeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpEvolucionDaoImpl;
import com.sorin.idea.jdbc.ImpGeneradorDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteComplicacionDaoImpl;
import com.sorin.idea.jdbc.ImpHojaImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteElectrodosDaoImpl;
import com.sorin.idea.jdbc.ProcedimientoDaoImpl;
import com.sorin.idea.jdbc.SintomasSitclinProcDaoImpl;
import com.sorin.idea.jdbc.SituacionClinicaProcDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.ExportExcel;
import com.sorin.idea.util.InfoCentro;
import com.sorin.idea.util.RegistroDaiDto;
import com.sorin.idea.util.TarjetaMP;
import com.sorin.idea.util.UtilReporteRegistroDAI;

public class ControlExportacion extends BaseIU{

	private static Logger logger = Logger.getLogger(ControlExportacion.class);
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private LoginForm lf;
	
	private int anio;
	private int registro;
	private InfoCentro hospital;
	private ControlMaestras cm;
	private Procedimiento[] listaproc;
	private ProcedimientoDao procdao;
	private ArrayList<Procedimiento> procs;
	private ArrayList<ImpImplante> impls;
	private ImpImplanteDao impdao;
	private ImpGeneradorDao gendao;
	private Generador[] generadores;
	private ImpImplanteElectrodosDao impelecdao;
	private ImpHojaImplanteComplicacionDao impcompdao;
	private ComplicacionDao compdao;
	private ComplicacionesPacientesDao compacdao;
	private Electrodos[] electrodos;
	private GeneradorDao g;
	private ElectrodosDao e;
	private ArrPacientesDao pacdao;
	private SituacionClinicaProcDao sitclindao;
	private SintomasSitclinProcDao sintomasdao;
	private ImpHojaImplanteDao himpdao;
	private ImpEvolucionDao hevdao;
	private ImpImplanteElectrodos elecdao;
	private ArrMaestras[] ritmos;
	private ArrMaestras[] conducciones;
	private ArrMaestras[] qrs;
	private ArrMaestras[] cardiopatia;
	
	
	public void iniciaExportacion(ActionEvent e){
		try{
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			this.lf = (LoginForm) getBean("loginForm");
			
			lecturaProperties();
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			// Precarga por defecto el anio actual
			this.anio = 1900 + new Date().getYear();
			this.procdao = new ProcedimientoDaoImpl();
			this.procs = new ArrayList<Procedimiento>();
			this.impls = new ArrayList<ImpImplante>();
			this.impdao = new ImpImplanteDaoImpl();
			this.gendao = new ImpGeneradorDaoImpl();
			this.pacdao = new ArrPacientesDaoImpl();
			this.sitclindao = new SituacionClinicaProcDaoImpl();
			this.sintomasdao = new SintomasSitclinProcDaoImpl();
			this.himpdao = new ImpHojaImplanteDaoImpl();
			this.hevdao = new ImpEvolucionDaoImpl();
			this.impelecdao = new ImpImplanteElectrodosDaoImpl();
			this.impcompdao = new ImpHojaImplanteComplicacionDaoImpl();
			this.compdao = new ComplicacionDaoImpl();
			this.compacdao = new ComplicacionesPacientesDaoImpl();
			this.ritmos = cm.getRitmoSinusal();
			this.conducciones = cm.getConduccionNoNormal();
			this.qrs = cm.getQrsNoNormal();
			this.cardiopatia = cm.getCardiopatia();
			cargaGeneradores();
			cargaElectrodos();
		}catch(Exception e1){
			logError(this.bundle.getString("info_msg_error_inicio_mod"));
		}
		
	}
	/**
	 * Metodo para exportar en XML los registros especificados. 
	 * TODO - control de tipos de registro. Actualmente solo DAI y Tarjeta Europea 
	 * @param e
	 */
	public void exportaRegistrosAnuales(ActionEvent e){
		if(this.getRegistro()==0)
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("export_msg_warn_selec"));
		else{
			try{
				ArrayList<Element> itemsDAI = new ArrayList<Element>();
				ArrayList<Element> itemsMP = new ArrayList<Element>();
				this.procs = new ArrayList<Procedimiento>();
				this.listaproc = this.procdao.findByDynamicWhere("(TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?) AND FECHA BETWEEN ? AND ?",
								new Object[] {956,1059,1060,1090,this.anio+"-01-01",this.anio+"-12-31"});
				// Cribado por anio - Solo nos quedamos con los del anio especificado
				/*for(int i=0;i<this.listaproc.length;i++){
					if((1900 +this.listaproc[i].getFecha().getYear() == this.anio))
						this.procs.add(this.listaproc[i]);
				}*/
				// Bucle para insertar implantes en una lista sobre la que iterar
				for(Procedimiento p : this.listaproc){
					ImpImplante auximp = this.impdao.findByPrimaryKey(p.getIdprocedimiento());
					ImpGenerador[] genimp = this.gendao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
					// genimp[] solo interesa el primer item ya que hay una relacion unica entre objetos
					if(genimp!=null && genimp.length>0){
						if(esDAI(genimp[0])){
							ArrPacientes pacienteSelect = this.pacdao.findByPrimaryKey(p.getCodigo());
							SituacionClinicaProc sitclin = this.sitclindao.findByPrimaryKey(p.getIdsitclinica());
							SintomasSitclinProc[] sintomas = this.sintomasdao.findWhereIdsitclinEquals(sitclin.getIdsitclin());
							for(SintomasSitclinProc st:sintomas)
								sitclin.getSintomas().add(st);
							ImpHojaImplante himp = this.himpdao.findByPrimaryKey(auximp.getIdhojaimp());
							ImpEvolucion hev = this.hevdao.findByPrimaryKey(auximp.getIdev());
							ImpImplanteElectrodos[] impelectrodos = this.impelecdao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
							//ImpHojaImplanteComplicacion[] compIntra = this.impcompdao.findWhereIdhojaimpEquals(himp.getIdhojaimp());
							ComplicacionesPacientes[] compIntra = this.compacdao.findByDynamicWhere("IDPROCEDIMIENTO=? AND TIPOPROCEDIMIENTO=? AND TIPO=?", new Object[]{p.getIdprocedimiento(),p.getTipoprocedimiento(),1});
							UtilReporteRegistroDAI util = ExportaRegistroDAI.preparaObjetoAuxiliar(p, genimp[0], impelectrodos, null, sitclin, this.generadores, this.electrodos, ritmos);
							ExportaRegistroDAI it = new ExportaRegistroDAI(pacienteSelect,sitclin,himp,hev,util,this.hospital,compIntra,null);
							itemsDAI.add(it.creaItemRegistroDAI());
							//this.impls.add(auximp);
						}else if(esMP(genimp[0])){
							ArrPacientes pacienteSelect = this.pacdao.findByPrimaryKey(p.getCodigo());
							SituacionClinicaProc sitclin = this.sitclindao.findByPrimaryKey(p.getIdsitclinica());
							SintomasSitclinProc[] sintomas = this.sintomasdao.findWhereIdsitclinEquals(sitclin.getIdsitclin());
							for(SintomasSitclinProc st:sintomas)
								sitclin.getSintomas().add(st);
							ImpHojaImplante himp = this.himpdao.findByPrimaryKey(auximp.getIdhojaimp());
							ImpEvolucion hev = this.hevdao.findByPrimaryKey(auximp.getIdev());
							ImpImplanteElectrodos[] impelectrodos = this.impelecdao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
							ImpGenerador[] gens = this.gendao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
							TarjetaMP tmp = ExportaTarjetaEuropeaMP.preparaTarjetaEuropea(p,sitclin,himp,hev,gens,impelectrodos,this.generadores,this.electrodos,this.hospital);
							ExportaTarjetaEuropeaMP it = new ExportaTarjetaEuropeaMP(pacienteSelect,tmp);
							itemsMP.add(it.creaItemTarjetaEuropea());
						}
					}	
				}
				Document doc = null;
				if(this.getRegistro()==1)
					doc = ExportaRegistroDAI.generaExportacionRegistroDAI(itemsDAI);
				else if(this.getRegistro() ==2)
					doc = ExportaTarjetaEuropeaMP.generaExportacionRegistroMPS(itemsMP);
				/********************************************************/
				try {
					XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
					// XMLOutputter out= new XMLOutputter();
					/*******************************************************/
					/*FileOutputStream file = new FileOutputStream("C:/PRUEBAS/out.xml");
					out.output(doc, file);
					file.flush();
					file.close();*/
					/*******************************************************/
					//Set the filename
			        DateTime dt = new DateTime();
			        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
			        String filename="";
			        if(this.getRegistro()==1)
			        	filename = "RegistroNacionalDAI_Anual "+this.getAnio()+"_"+dt.toString(fmt) + ".xml";
			        else if(this.getRegistro() ==2)
			        	filename = "RegistroNacionalMP_Anual "+this.getAnio()+"_"+dt.toString(fmt) + ".xml";
			        //Setup the output
			        String contentType = "text/xml";
			        FacesContext fc = FacesContext.getCurrentInstance();
			        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
			        response.setHeader("Content-disposition", "attachment; filename=" + filename);
			        //response.setHeader("Content-disposition", "filename=" + filename);
			        response.setContentType(contentType);
			        	        
			        OutputStream outfile = response.getOutputStream();
			        out.output(doc, outfile);
			        //Write the table back out
			        // GenerarExcel.crearExcel(paciente, rescv, filename, out);
			        outfile.flush();
			        outfile.close();
			        fc.responseComplete();	
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				logger.info("("+this.lf.getAcceso().getUsuario()+") Exportación de registros - General - XML");
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
						this.bundle.getString("export_msg_error")+": " + e1.getMessage());
				logger.error("Error generando exportacion. Motivo: "+e1.getMessage(), e1);
			}
		}	
	}
	
	public void exportaRegistrosAnualesPDF(ActionEvent e){
		if(this.getRegistro()==0)
			this.pintaMensaje(Mensaje.SEVERIDAD_AVISO, this.bundle.getString("export_msg_warn_selec"));
		else{
			try{
				ArrayList<Element> itemsDAI = new ArrayList<Element>();
				ArrayList<Element> itemsMP = new ArrayList<Element>();
				this.procs = new ArrayList<Procedimiento>();
				this.listaproc = this.procdao.findByDynamicWhere("(TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?) AND FECHA BETWEEN ? AND ?",
								new Object[] {956,1059,1060,1090,this.anio+"-01-01",this.anio+"-12-31"});
				// Cribado por anio - Solo nos quedamos con los del anio especificado
				/*for(int i=0;i<this.listaproc.length;i++){
					if((1900 +this.listaproc[i].getFecha().getYear() == this.anio))
						this.procs.add(this.listaproc[i]);
				}*/
				// Bucle para insertar implantes en una lista sobre la que iterar
				for(Procedimiento p : this.listaproc){
					ImpImplante auximp = this.impdao.findByPrimaryKey(p.getIdprocedimiento());
					ImpGenerador[] genimp = this.gendao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
					// genimp[] solo interesa el primer item ya que hay una relacion unica entre objetos
					if(genimp!=null && genimp.length>0){
						if(esDAI(genimp[0])){
							ArrPacientes pacienteSelect = this.pacdao.findByPrimaryKey(p.getCodigo());
							SituacionClinicaProc sitclin = this.sitclindao.findByPrimaryKey(p.getIdsitclinica());
							SintomasSitclinProc[] sintomas = this.sintomasdao.findWhereIdsitclinEquals(sitclin.getIdsitclin());
							for(SintomasSitclinProc st:sintomas)
								sitclin.getSintomas().add(st);
							ImpHojaImplante himp = this.himpdao.findByPrimaryKey(auximp.getIdhojaimp());
							ImpEvolucion hev = this.hevdao.findByPrimaryKey(auximp.getIdev());
							ImpImplanteElectrodos[] impelectrodos = this.impelecdao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
							//ImpHojaImplanteComplicacion[] compIntra = this.impcompdao.findWhereIdhojaimpEquals(himp.getIdhojaimp());
							ComplicacionesPacientes[] compIntra = this.compacdao.findByDynamicWhere("IDPROCEDIMIENTO=? AND TIPOPROCEDIMIENTO=? AND TIPO=?", new Object[]{p.getIdprocedimiento(),p.getTipoprocedimiento(),1});
							UtilReporteRegistroDAI util = ExportaRegistroDAI.preparaObjetoAuxiliar(p, genimp[0], impelectrodos, null, sitclin, this.generadores, this.electrodos, ritmos);
							ExportaRegistroDAI it = new ExportaRegistroDAI(pacienteSelect,sitclin,himp,hev,util,this.hospital,compIntra,null);
							itemsDAI.add(it.creaItemRegistroDAI());
							//this.impls.add(auximp);
						}else if(esMP(genimp[0])){
							ArrPacientes pacienteSelect = this.pacdao.findByPrimaryKey(p.getCodigo());
							SituacionClinicaProc sitclin = this.sitclindao.findByPrimaryKey(p.getIdsitclinica());
							SintomasSitclinProc[] sintomas = this.sintomasdao.findWhereIdsitclinEquals(sitclin.getIdsitclin());
							for(SintomasSitclinProc st:sintomas)
								sitclin.getSintomas().add(st);
							ImpHojaImplante himp = this.himpdao.findByPrimaryKey(auximp.getIdhojaimp());
							ImpEvolucion hev = this.hevdao.findByPrimaryKey(auximp.getIdev());
							ImpImplanteElectrodos[] impelectrodos = this.impelecdao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
							ImpGenerador[] gens = this.gendao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
							TarjetaMP tmp = ExportaTarjetaEuropeaMP.preparaTarjetaEuropea(p,sitclin,himp,hev,gens,impelectrodos,this.generadores,this.electrodos,this.hospital);
							ExportaTarjetaEuropeaMP it = new ExportaTarjetaEuropeaMP(pacienteSelect,tmp);
							itemsMP.add(it.creaItemTarjetaEuropea());
						}
					}	
				}
				Document doc = null;
				if(this.getRegistro()==1)
					doc = ExportaRegistroDAI.generaExportacionRegistroDAI(itemsDAI);
				else if(this.getRegistro()==2)
					doc = ExportaTarjetaEuropeaMP.generaExportacionRegistroMPS(itemsMP);
				/********************************************************/
				try {
					XMLOutputter out = new XMLOutputter(Format.getPrettyFormat());
					// XMLOutputter out= new XMLOutputter();
					/*******************************************************/
					HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
					HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
					String sesionID = req.getRequestedSessionId();
					String pathFichero = req.getRealPath("/reportes/PED_" + sesionID+ ".xml");
					
					FileOutputStream file = new FileOutputStream(pathFichero);
					out.output(doc, file);
					file.flush();
					file.close();
					/*FileOutputStream file = new FileOutputStream("C:/PRUEBAS/out.xml");
					out.output(doc, file);
					file.flush();
					file.close();*/
					/*******************************************************/
					ConstructorPdf constructorPDF = new ConstructorPdf();
					String jasper = "";
					if(this.getRegistro()==1)
						jasper = "EXP_DAI_ANUAL.jasper";
					else if(this.getRegistro() ==2)
						jasper = "EXP_MP_ANUAL.jasper";
					try {
						constructorPDF.generarArchivoPdf(FacesContext.getCurrentInstance(),pathFichero, jasper);
						if(this.getRegistro()==1)
							logger.info("Exportación de informe anual (DAI).");
						else
							logger.info("Exportación de informe anual (MPS).");
					} catch (Exception se) {
						logger.error("Error generando informe exportacion PDF documento (RegistroDAI/Tarjeta Europea MP). Motivo: "+ se.getMessage(),se);	
						try {
							nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
									"Error imprimiendo informe,motivo: " + se.getMessage(),
									"Error imprimiendo informe,Motivo: " + se.getMessage());
						} catch (Exception e2) {
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				logger.info("("+this.lf.getAcceso().getUsuario()+") Exportación de registros - General - PDF");
			}catch(Exception e1){
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
						this.bundle.getString("export_msg_error")+": " + e1.getMessage());
				logger.error("Error generando exportacion. Motivo: "+e1.getMessage(), e1);
			}
		}	
	}
	
	public void exportaRegistroNacionalDai(ActionEvent e){
		try{
			this.procs = new ArrayList<Procedimiento>();
			this.listaproc = this.procdao.findByDynamicWhere("(TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ? OR TIPOPROCEDIMIENTO = ?) AND FECHA BETWEEN ? AND ?",
							new Object[] {956,1059,1060,1090,this.anio+"-01-01",this.anio+"-12-31"});
			ArrayList<RegistroDaiDto> items = new ArrayList<RegistroDaiDto>();
			ElectrodosDao edao = new ElectrodosDaoImpl();
			ExportaRegistroDAI exp = new ExportaRegistroDAI();
			for(Procedimiento p : this.listaproc){
				ImpImplante auximp = this.impdao.findByPrimaryKey(p.getIdprocedimiento());
				ImpGenerador[] genimp = this.gendao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
				// genimp[] solo interesa el primer item ya que hay una relacion unica entre objetos
				if(genimp!=null && genimp.length>0){
					if(esDAI(genimp[0])){
						// Obtener Generador asociado
						Generador gen = this.g.findByPrimaryKey(genimp[0].getIdgenerador());
						ArrPacientes pacienteSelect = this.pacdao.findByPrimaryKey(p.getCodigo());
						SituacionClinicaProc sitclin = this.sitclindao.findByPrimaryKey(p.getIdsitclinica());
						SintomasSitclinProc[] sintomas = this.sintomasdao.findWhereIdsitclinEquals(sitclin.getIdsitclin());
						for(SintomasSitclinProc st:sintomas)
							sitclin.getSintomas().add(st);
						ImpHojaImplante himp = this.himpdao.findByPrimaryKey(auximp.getIdhojaimp());
						ImpEvolucion hev = this.hevdao.findByPrimaryKey(auximp.getIdev());
						ImpImplanteElectrodos[] impelectrodos = this.impelecdao.findWhereIdhojaimpEquals(auximp.getIdhojaimp());
						// Obtener modelos electrodos
						for(ImpImplanteElectrodos ele:impelectrodos){
							Electrodos el = edao.findByPrimaryKey(ele.getIdelectrodo());
							ele.setNombremodelo(el.getModelo());
						}
						//ImpHojaImplanteComplicacion[] compIntra = this.impcompdao.findWhereIdhojaimpEquals(himp.getIdhojaimp());
						ComplicacionesPacientes[] compIntra = this.compacdao.findByDynamicWhere("IDPROCEDIMIENTO=? AND TIPOPROCEDIMIENTO=? AND TIPO=?", new Object[]{p.getIdprocedimiento(),p.getTipoprocedimiento(),1});
						
						//UtilReporteRegistroDAI util = ExportaRegistroDAI.preparaObjetoAuxiliar(p, genimp[0], impelectrodos, null, sitclin, this.generadores, this.electrodos, ritmos);
						RegistroDaiDto item = exp.obtenerItemDAI(pacienteSelect, p, himp, hev, genimp[0], impelectrodos, compIntra, sitclin,
								gen, new Date(), this.hospital);
						items.add(item);
					}
				}
				
			}
			// GENERACION excel
			ExportExcel ee = new ExportExcel();
			ee.exportToExcel_RegNalDAI(items, this.anio);
			logger.info("("+this.lf.getAcceso().getUsuario()+") Exportación de registros - Registro Nacional DAI - Excel");
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, 
					this.bundle.getString("export_msg_error")+": " + e1.getMessage());
			logger.error("Error generando exportacion. Motivo: "+e1.getMessage(), e1);
		}
	}
	
	public void enviaDatosExportados(ActionEvent e){
		
	}
	public void cargaGeneradores() {
		try {
			this.g = new GeneradorDaoImpl();
			this.generadores = this.g.findAll();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}
	public void cargaElectrodos() {
		try {
			this.e = new ElectrodosDaoImpl();
			this.electrodos = this.e.findAll();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					this.bundle.getString("mat_mag_warn_consulta_error")+": "+ e1.getMessage());
		}
	}
	private boolean esDAI(ImpGenerador g){
		for(int i=0;i<this.generadores.length;i++){
			if(g.getIdgenerador().equals(this.generadores[i].getIdgenerador()) 
					&& (this.generadores[i].getTipo().equals("2") || this.generadores[i].getTipo().equals("4") || this.generadores[i].getTipo().equals("6")))
				return true;
		}
		return false;
	}
	private boolean esMP(ImpGenerador g){
		for(int i=0;i<this.generadores.length;i++){
			if(g.getIdgenerador().equals(this.generadores[i].getIdgenerador()) 
					&& (this.generadores[i].getTipo().equals("1") || this.generadores[i].getTipo().equals("3") || this.generadores[i].getTipo().equals("5")))
				return true;
		}
		return false;
	}
	
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getRegistro() {
		return registro;
	}

	public void setRegistro(int registro) {
		this.registro = registro;
	}
	
	public void lecturaProperties() throws Exception {
		Properties p = new Properties();
		InputStream is = ControlExportacion.class.getResourceAsStream("labels.properties");
		p.load(is);
		is.close();
		this.hospital = new InfoCentro(p.getProperty("centro"),p.getProperty("direccion"),
				p.getProperty("ciudad"),p.getProperty("pais"),p.getProperty("telefono"),p.getProperty("responsable"));
	}
	
}

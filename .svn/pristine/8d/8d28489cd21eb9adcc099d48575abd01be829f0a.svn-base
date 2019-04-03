package com.sorin.idea.iu;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import hvn.cm.modelo.Mensaje;

import org.apache.log4j.Logger;
import org.apache.myfaces.component.html.ext.HtmlDataTable;

import com.sorin.idea.dao.MedComercialDao;
import com.sorin.idea.dao.MedGenericoDao;
import com.sorin.idea.dao.PlanMedGenDao;
import com.sorin.idea.dao.PlanMedProcDao;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.MedComercial;
import com.sorin.idea.dto.MedGenerico;
import com.sorin.idea.dto.MedicacionDto;
import com.sorin.idea.dto.PlanMedGen;
import com.sorin.idea.dto.PlanMedGenPk;
import com.sorin.idea.dto.PlanMedProc;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.exceptions.PlanMedGenDaoException;
import com.sorin.idea.jdbc.MedComercialDaoImpl;
import com.sorin.idea.jdbc.MedGenericoDaoImpl;
import com.sorin.idea.jdbc.PlanMedGenDaoImpl;
import com.sorin.idea.jdbc.PlanMedProcDaoImpl;
import com.sorin.idea.util.UtilMapeos;

public class ControlMedicacion extends BaseIU{

	private static final long serialVersionUID = -2815005343083864824L;
	private String usuario;
	private static Logger logger = Logger.getLogger(ControlMedicacion.class);
	private SelectorIdioma si;
	private ResourceBundle bundle;
	private LoginForm lf;
	private ControlPacientes cp;

	private ControlMaestras cm;
	private ArrMaestras[] tiposmedicacion;
	private ArrMaestras[] vias;
	private ArrMaestras[] formaspresentacion;
	
	private PlanMedGen planmedgen;
	private PlanMedGenDao plangendao;
	
	private PlanMedProc planmedproc;
	
	private MedGenericoDao medgendao;
	private MedComercialDao medcomdao;
	private MedGenerico[] genericos;
	private MedComercial[] comerciales;
	
	private MedGenerico[] antibioticos;
	private MedGenerico[] ieca;
	private MedGenerico[] araii;
	private MedGenerico[] diureticos;
	private MedGenerico[] antiarritmicos;
	
	private ArrayList<PlanMedGen> planmedicaciongen;
	/* IMPORTANTE
	 * Se deben tanto bindingMedicacionGeneralxxx como dataTables con bindings
	 * se pongan para cada tipo de procedimiento. 
	 * Al usar uno solo da problemas de render con duplicado de ids.
	 */
	private HtmlDataTable bindingMedicacionGeneral;
	private HtmlDataTable bindingMedicacionGeneralImp;
	private HtmlDataTable bindingMedicacionGeneralSeg;
	
	private PlanMedGen currentItem;
	
	private boolean ascendente = true;
	
	private boolean editable;
	private boolean editableImp;
	private boolean editableSeg;
	
	public void iniciaMedicacion(ActionEvent e){
		try {
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			this.cargaMaestras();
			
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if(this.cp == null){
				cp = new ControlPacientes();
				this.pintaMensaje(Mensaje.SEVERIDAD_AVISO,this.bundle.getString("info_msg_error_rec_pat"));
			}
			
			this.plangendao = new PlanMedGenDaoImpl(this.usuario);
			this.medgendao = new MedGenericoDaoImpl(this.usuario);
			this.medcomdao = new MedComercialDaoImpl(this.usuario);
			
			this.planmedgen = new PlanMedGen();
			this.currentItem = new PlanMedGen();
			
			this.planmedicaciongen = new ArrayList<PlanMedGen>();		
			
			if(cp.getPacienteSelect().getCodigo()!=null)
				this.obtenerPlanGeneralPaciente();
			this.cargaMedicamentosGenerico();
			this.cargaMedicamentosComerciales();
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_inicio_mod")+": "+ e1.getMessage());
		}	
	}

	public void cargaMaestras(){
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			//this.tiposmedicacion = cm.getTiposMedicacion();
			this.vias = cm.getViaAdminMedicacion();
			this.formaspresentacion = cm.getFormasPresentacionMedicacion();
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("info_msg_error_inicio_dmaestras")+": "+ e1.getMessage());
		}
	}
	
	public void obtenerPlanGeneralPaciente(){
		try{
			this.planmedicaciongen.clear();
			PlanMedGen[] plan = this.plangendao.findWhereIdpacienteEquals(cp.getPacienteSelect().getCodigo());
			// Obtener medicamentos comerciales asociados si procede
			if(plan!=null && plan.length>0){
				for(PlanMedGen item:plan){
					MedGenerico med = this.medgendao.findByPrimaryKey(item.getIdmedgen());
					if(med!=null){
						String[] info_med = UtilMapeos.obtenerDatosMedicacion(med.getCodigo());
						item.setInfomedgen(med.getNombregenerico());
						if(info_med!=null){
							item.getMedicacionDto().getMedgenerico().setTipomed(info_med[4]!=null?Integer.valueOf(info_med[4]):0);
							item.getMedicacionDto().getMedgenerico().setTipomed1(info_med[5]!=null?Integer.valueOf(info_med[5]):0);
						}	
					}
					this.planmedicaciongen.add(item);
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("med_msg_error_consulta_plan")+": "+ e1.getMessage());
		}
	}
	
	public void cargaMedicamentosGenerico(){
		try{
			this.genericos = this.medgendao.findAll();
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("med_msg_error_consulta_medgen")+": "+ e1.getMessage());
		}
	}
	
	public void cargaMedicamentosComerciales(){
		try{
			this.comerciales = this.medcomdao.findAll();
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("med_msg_error_consulta_medcom")+": "+ e1.getMessage());
		}
	}
	
	public void addItemPlanGen(ActionEvent e){
		try{
			if(this.planmedgen.getMedicacionDto().getMedgenerico().getTipomed().equals(0)){
				this.pintaMensaje(ERROR, this.bundle.getString("med_msg_warn_add_1"));
				this.planmedgen = new PlanMedGen();
			}else{
				if((this.planmedgen.getIdmedgen()==null || this.planmedgen.getIdmedgen().equals(0))
						&& !(this.planmedgen.getMedicacionDto().getMedgenerico().getTipomed().equals(18))){
					this.pintaMensaje(ERROR, this.bundle.getString("med_msg_warn_add_1"));
					this.planmedgen = new PlanMedGen();
				}else{
					this.planmedgen.setIdpaciente(cp.getPacienteSelect().getCodigo());
					this.planmedgen.setPrescriptor(lf.getAcceso().getUsuario());
					// CONTROL DE TIPOMEDICAMENTO = OTROS (18). Asigancion de medicaciongenerica: Z000000
					if(this.planmedgen.getMedicacionDto().getMedgenerico().getTipomed().equals(18)){
						MedGenerico[] med = this.medgendao.findWhereCodigoEquals("Z000000");
						if(med!=null && med.length>0){
							this.planmedgen.setIdmedgen(med[0].getIdmedgen());
							this.planmedgen.setInfomedgen(med[0].getNombregenerico());// carga de nombre generico en infomedgen
						}
					}else{// carga de nombre generico en infomedgen
						MedGenerico med = this.medgendao.findByPrimaryKey(this.planmedgen.getIdmedgen());
						this.planmedgen.setInfomedgen(med!=null?med.getNombregenerico():null);
					}	
					this.plangendao.insert(this.planmedgen);
					
					this.planmedicaciongen.add(this.planmedgen);
					this.planmedgen = new PlanMedGen();
					logger.info("("+this.usuario+") Inserción de nuevo item de mediación general. Id Paciente: "+cp.getPacienteSelect().getCodigo());
					this.pintaMensaje(INFO, this.bundle.getString("msd_msg_info_add"));
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("med_msg_error_add")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en inserción de nuevo item de mediación general. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}	
	}
	
	public void editItemPlanGen(ActionEvent e){
		try{
			if(this.currentItem.getMedicacionDto().getMedgenerico().getTipomed().equals(0)){
				this.pintaMensaje(ERROR, this.bundle.getString("med_msg_warn_add_1"));
			}else{
				if((this.currentItem.getIdmedgen()==null || this.currentItem.getIdmedgen().equals(0))
						&& !(this.currentItem.getMedicacionDto().getMedgenerico().getTipomed().equals(18))){
					this.pintaMensaje(ERROR, this.bundle.getString("med_msg_warn_add_1"));
				}else{
					// CONTROL DE TIPOMEDICAMENTO = OTROS (18). Asigancion de medicaciongenerica: Z000000
					if(this.currentItem.getMedicacionDto().getMedgenerico().getTipomed().equals(18)){
						MedGenerico[] med = this.medgendao.findWhereCodigoEquals("Z000000");
						if(med!=null && med.length>0){
							this.currentItem.setIdmedgen(med[0].getIdmedgen());
							this.currentItem.setInfomedgen(med[0].getNombregenerico());// carga de nombre generico en infomedgen
						}
					}else{// carga de nombre generico en infomedgen
						MedGenerico med = this.medgendao.findByPrimaryKey(this.currentItem.getIdmedgen());
						this.currentItem.setInfomedgen(med!=null?med.getNombregenerico():null);
					}
					this.plangendao.update(new PlanMedGenPk(this.currentItem.getIdplanmedgen()),this.currentItem);
					this.obtenerPlanGeneralPaciente();// Recuperacion de lista completa asociada a paciente -
					//this.setCurrentItem(new PlanMedGen());
					this.setEditable(false);
					this.setEditableImp(false);
					this.setEditableSeg(false);
					logger.info("("+this.usuario+") Item Medicación actualizado con éxito. Id Paciente: "+cp.getPacienteSelect().getCodigo());
					this.pintaMensaje(INFO, this.bundle.getString("med_msg_info_edit"));
				}
			}
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("med_msg_error_edit")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en edición de item de mediación general. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	
	public void delItemPlanGen(ActionEvent e){
		try {
			this.plangendao.delete(new PlanMedGenPk(this.planmedicaciongen.get(this.bindingMedicacionGeneral.getRowIndex()).getIdplanmedgen()));
			this.planmedicaciongen.remove(this.bindingMedicacionGeneral.getRowIndex());
			logger.info("("+this.usuario+") Item de mediación borrado con éxito del sistema. Id Paciente: "+cp.getPacienteSelect().getCodigo());
		} catch (PlanMedGenDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("med_msg_error_borrar")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en borrado de nuevo item de mediación procedimiento. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	// Borrado desde formulario de implante
	public void delItemPlanGenImp(ActionEvent e){
		try {
			this.plangendao.delete(new PlanMedGenPk(this.planmedicaciongen.get(this.bindingMedicacionGeneralImp.getRowIndex()).getIdplanmedgen()));
			this.planmedicaciongen.remove(this.bindingMedicacionGeneralImp.getRowIndex());
			logger.info("("+this.usuario+") Item de mediación borrado con éxito del sistema. Id Paciente: "+cp.getPacienteSelect().getCodigo());
		} catch (PlanMedGenDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("med_msg_error_borrar")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en borrado de nuevo item de mediación procedimiento. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	// Borrado desde formulario de seguimiento
	public void delItemPlanGenSeg(ActionEvent e){
		try {
			this.plangendao.delete(new PlanMedGenPk(this.planmedicaciongen.get(this.bindingMedicacionGeneralSeg.getRowIndex()).getIdplanmedgen()));
			this.planmedicaciongen.remove(this.bindingMedicacionGeneralSeg.getRowIndex());
			logger.info("("+this.usuario+") Item de mediación borrado con éxito del sistema. Id Paciente: "+cp.getPacienteSelect().getCodigo());
		} catch (PlanMedGenDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("med_msg_error_borrar")+": "+ e1.getMessage());
			logger.error("("+this.usuario+") Error en borrado de nuevo item de mediación procedimiento. Id Paciente: "+cp.getPacienteSelect().getCodigo()+". Motivo: "+e1.getMessage());
		}
	}
	
	public void cancelarItemPlanGen(ActionEvent e){
		this.setEditable(false);
		this.setEditableImp(false);
		this.setEditableSeg(false);
	}
	
	public void limpia(ActionEvent e){
		this.planmedgen = new PlanMedGen();
	}
	
	public void seleccionaMedicacion(ActionEvent e){
		try{
			// DEBE ACTUALIZAR LAS LISTAS DESPLEGABLES
			System.out.println(this.planmedgen.getMedicacionDto().getMedgenerico().getCodigo());
		}catch(Exception e1){
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,this.bundle.getString("med_msg_error_consulta_plan_1")+": "+ e1.getMessage());
		}
	}
	
	public void preEditar(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		PlanMedGen aux = this.getPlanmedicaciongen().get(this.bindingMedicacionGeneral.getRowIndex());	
		this.currentItem.setAdministracion(aux.getAdministracion());
		this.currentItem.setComentarios(aux.getComentarios());
		this.currentItem.setDosis(aux.getDosis());
		this.currentItem.setEstado(aux.getEstado());
		this.currentItem.setFechainicio(aux.getFechainicio());
		this.currentItem.setFechamod(aux.getFechamod());
		this.currentItem.setFechaprescripcion(aux.getFechaprescripcion());
		this.currentItem.setFechasuspension(aux.getFechasuspension());
		this.currentItem.setFrecuencia(aux.getFrecuencia());
		this.currentItem.setIdmedcom(aux.getIdmedcom());
		this.currentItem.setIdmedgen(aux.getIdmedgen());
		this.currentItem.setIdpaciente(aux.getIdpaciente());
		this.currentItem.setIdplanmedgen(aux.getIdplanmedgen());
		this.currentItem.setIdvia(aux.getIdvia());
		this.currentItem.setInfomedgen(aux.getInfomedgen());
		this.currentItem.setMedicacionDto(aux.getMedicacionDto());
		this.currentItem.setMotivosuspension(aux.getMotivosuspension());
		this.currentItem.setPrescriptor(aux.getPrescriptor());
		this.currentItem.setUnidad(aux.getUnidad());
		this.currentItem.setOtros(aux.getOtros());
		//System.out.println(this.currentItem.getIdmedgen());
		this.setEditable(true);
	}
	
	public void preEditarImp(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		PlanMedGen aux = this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex());	
		this.currentItem.setAdministracion(aux.getAdministracion());
		this.currentItem.setComentarios(aux.getComentarios());
		this.currentItem.setDosis(aux.getDosis());
		this.currentItem.setEstado(aux.getEstado());
		this.currentItem.setFechainicio(aux.getFechainicio());
		this.currentItem.setFechamod(aux.getFechamod());
		this.currentItem.setFechaprescripcion(aux.getFechaprescripcion());
		this.currentItem.setFechasuspension(aux.getFechasuspension());
		this.currentItem.setFrecuencia(aux.getFrecuencia());
		this.currentItem.setIdmedcom(aux.getIdmedcom());
		this.currentItem.setIdmedgen(aux.getIdmedgen());
		this.currentItem.setIdpaciente(aux.getIdpaciente());
		this.currentItem.setIdplanmedgen(aux.getIdplanmedgen());
		this.currentItem.setIdvia(aux.getIdvia());
		this.currentItem.setInfomedgen(aux.getInfomedgen());
		this.currentItem.setMedicacionDto(aux.getMedicacionDto());
		this.currentItem.setMotivosuspension(aux.getMotivosuspension());
		this.currentItem.setPrescriptor(aux.getPrescriptor());
		this.currentItem.setUnidad(aux.getUnidad());
		this.currentItem.setOtros(aux.getOtros());
		/*this.currentItem.setAdministracion(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getAdministracion());
		this.currentItem.setComentarios(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getComentarios());
		this.currentItem.setDosis(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getDosis());
		this.currentItem.setEstado(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getEstado());
		this.currentItem.setFechainicio(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getFechainicio());
		this.currentItem.setFechamod(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getFechamod());
		this.currentItem.setFechaprescripcion(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getFechaprescripcion());
		this.currentItem.setFechasuspension(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getFechasuspension());
		this.currentItem.setFrecuencia(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getFrecuencia());
		this.currentItem.setIdmedcom(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getIdmedcom());
		this.currentItem.setIdmedgen(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getIdmedgen());
		this.currentItem.setIdpaciente(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getIdpaciente());
		this.currentItem.setIdplanmedgen(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getIdplanmedgen());
		this.currentItem.setIdvia(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getIdvia());
		this.currentItem.setInfomedgen(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getInfomedgen());
		this.currentItem.setMedicacionDto(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getMedicacionDto());
		this.currentItem.setMotivosuspension(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getMotivosuspension());
		this.currentItem.setPrescriptor(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getPrescriptor());
		this.currentItem.setUnidad(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralImp.getRowIndex()).getUnidad());
		*/
		this.setEditableImp(true);
	}
	
	public void preEditarSeg(ActionEvent e){
		// Precarga el objeto currenItem con el valor del objeto seleccionado e independizado
		PlanMedGen aux = this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex());	
		this.currentItem.setAdministracion(aux.getAdministracion());
		this.currentItem.setComentarios(aux.getComentarios());
		this.currentItem.setDosis(aux.getDosis());
		this.currentItem.setEstado(aux.getEstado());
		this.currentItem.setFechainicio(aux.getFechainicio());
		this.currentItem.setFechamod(aux.getFechamod());
		this.currentItem.setFechaprescripcion(aux.getFechaprescripcion());
		this.currentItem.setFechasuspension(aux.getFechasuspension());
		this.currentItem.setFrecuencia(aux.getFrecuencia());
		this.currentItem.setIdmedcom(aux.getIdmedcom());
		this.currentItem.setIdmedgen(aux.getIdmedgen());
		this.currentItem.setIdpaciente(aux.getIdpaciente());
		this.currentItem.setIdplanmedgen(aux.getIdplanmedgen());
		this.currentItem.setIdvia(aux.getIdvia());
		this.currentItem.setInfomedgen(aux.getInfomedgen());
		this.currentItem.setMedicacionDto(aux.getMedicacionDto());
		this.currentItem.setMotivosuspension(aux.getMotivosuspension());
		this.currentItem.setPrescriptor(aux.getPrescriptor());
		this.currentItem.setUnidad(aux.getUnidad());
		this.currentItem.setOtros(aux.getOtros());
		/*this.currentItem.setAdministracion(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getAdministracion());
		this.currentItem.setComentarios(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getComentarios());
		this.currentItem.setDosis(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getDosis());
		this.currentItem.setEstado(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getEstado());
		this.currentItem.setFechainicio(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getFechainicio());
		this.currentItem.setFechamod(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getFechamod());
		this.currentItem.setFechaprescripcion(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getFechaprescripcion());
		this.currentItem.setFechasuspension(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getFechasuspension());
		this.currentItem.setFrecuencia(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getFrecuencia());
		this.currentItem.setIdmedcom(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getIdmedcom());
		this.currentItem.setIdmedgen(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getIdmedgen());
		this.currentItem.setIdpaciente(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getIdpaciente());
		this.currentItem.setIdplanmedgen(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getIdplanmedgen());
		this.currentItem.setIdvia(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getIdvia());
		this.currentItem.setInfomedgen(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getInfomedgen());
		this.currentItem.setMedicacionDto(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getMedicacionDto());
		this.currentItem.setMotivosuspension(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getMotivosuspension());
		this.currentItem.setPrescriptor(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getPrescriptor());
		this.currentItem.setUnidad(this.getPlanmedicaciongen().get(this.bindingMedicacionGeneralSeg.getRowIndex()).getUnidad());
		*/
		this.setEditableSeg(true);
	}

	/**************** GET/SET *****************************/
	
	public ArrayList<SelectItem> getGenericos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (MedGenerico ref : this.genericos)
			diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		return diag;
	}
	// Para rich:comboBox
	public ArrayList<SelectItem> getGenericosCodigo() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (MedGenerico ref : this.genericos)
			diag.add(new SelectItem(ref.getNombregenerico(), ref.getCodigo()));
		return diag;
	}
	
	public ArrayList<SelectItem> getComerciales() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		//diag.add(new SelectItem("0", "(Seleccione modelo)"));
		for (MedComercial ref : this.comerciales)
			diag.add(new SelectItem(ref.getIdmedcom(), ref.getNombrecomercial()));
		return diag;
	}
	
	public ArrayList<SelectItem> getTiposmedicacion() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		diag.add(new SelectItem(1, this.bundle.getString("med_tipo_1")));
		diag.add(new SelectItem(2, this.bundle.getString("med_tipo_2")));
		diag.add(new SelectItem(3, this.bundle.getString("med_tipo_3")));
		diag.add(new SelectItem(4, this.bundle.getString("med_tipo_4")));
		diag.add(new SelectItem(5, this.bundle.getString("med_tipo_5")));
		diag.add(new SelectItem(6, this.bundle.getString("med_tipo_6")));
		diag.add(new SelectItem(7, this.bundle.getString("med_tipo_7")));
		diag.add(new SelectItem(8, this.bundle.getString("med_tipo_8")));
		diag.add(new SelectItem(9, this.bundle.getString("med_tipo_9")));
		diag.add(new SelectItem(10, this.bundle.getString("med_tipo_10")));
		diag.add(new SelectItem(11, this.bundle.getString("med_tipo_11")));
		diag.add(new SelectItem(12, this.bundle.getString("med_tipo_12")));
		diag.add(new SelectItem(13, this.bundle.getString("med_tipo_13")));
		diag.add(new SelectItem(14, this.bundle.getString("med_tipo_14")));
		diag.add(new SelectItem(15, this.bundle.getString("med_tipo_15")));
		diag.add(new SelectItem(16, this.bundle.getString("med_tipo_16")));
		diag.add(new SelectItem(17, this.bundle.getString("med_tipo_17")));
		diag.add(new SelectItem(18, this.bundle.getString("med_tipo_18")));
		/*diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		diag.add(new SelectItem(1, "TERAPIA CARDIACA"));
		diag.add(new SelectItem(2, "ANTIHIPERTENSIVOS"));
		diag.add(new SelectItem(3, "DIURÉTICOS"));
		diag.add(new SelectItem(4, "VASODILATADORES PERIFÉRICOS"));
		diag.add(new SelectItem(5, "VASOPROTECTORES"));
		diag.add(new SelectItem(7, "AGENTES BETA BLOQUEANTES"));
		diag.add(new SelectItem(8, "BLOQUEANTES DE CANALES DE CALCIO"));
		diag.add(new SelectItem(9, "IECA"));
		diag.add(new SelectItem(10, "ANTILIPEMICOS"));*/
		// tb incluimos los de tipo SANGRE aqui!
		
		return diag;
	}
	/****************** SICCS ************************************/
	
	public ArrayList<SelectItem> getMedicacionGeneral(){
		if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed()!=null){
			if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(1))
				return getAntiarritmicos_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(2))
				return getAntibioticos_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(3))
				return getAnticoagulantevenoso_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(4))
				return getAnticoagulanteoral_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(5))
				return getAntilipemicos_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(6))
				return getAntiplaquetarios_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(7))
				return getBetabloqueantes_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(8))
				return getBroncodilatadores_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(9))
				return getCalcioantagonistas_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(10))
				return getDigitalicos_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(11))
				return getDiureticos_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(12))
				return getEsteroides_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(13))
				return getHeparina_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(14))
				return getIeca_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(15))
				return getInotropicos_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(16))
				return getNitratos_siccs();
			else if(this.getCurrentItem().getMedicacionDto().getMedgenerico().getTipomed().equals(17))
				return getNitritos_siccs();
			else
				return new ArrayList<SelectItem>();
		}
		return new ArrayList<SelectItem>();
	}
	
	public ArrayList<SelectItem> getAntiarritmicos_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("B"))
					|| ref.getCodigo().equals("ZZAR000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getAntibioticos_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("J")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01"))
					|| ref.getCodigo().equals("ZZAB000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getAnticoagulantevenoso_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("B")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A")
					&& ref.getSubclase4()!=null && ref.getSubclase4().equals("B")
					&& ref.getSubclase5()!=null && ref.getSubclase5().equals("02"))
				|| (ref.getSubclase1()!=null && ref.getSubclase1().equals("B")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A")
					&& ref.getSubclase4()!=null && ref.getSubclase4().equals("B")
					&& ref.getSubclase5()!=null && ref.getSubclase5().equals("04"))
				|| (ref.getSubclase1()!=null && ref.getSubclase1().equals("B")
						&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
						&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A")
						&& ref.getSubclase4()!=null && ref.getSubclase4().equals("B")
						&& ref.getSubclase5()!=null && ref.getSubclase5().equals("05"))
				|| ref.getCodigo().equals("ZZAE000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}			
		return diag;
	}
	
	public ArrayList<SelectItem> getAnticoagulanteoral_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("B")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A")
					&& ref.getSubclase4()!=null && ref.getSubclase4().equals("A")
					&& ref.getSubclase5()!=null && ref.getSubclase5().equals("03"))
				|| ref.getSubclase1()!=null && ref.getSubclase1().equals("B")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A")
					&& ref.getSubclase4()!=null && ref.getSubclase4().equals("A")
					&& ref.getSubclase5()!=null && ref.getSubclase5().equals("07")
					|| ref.getCodigo().equals("ZZAO000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getAntilipemicos_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("10"))
					|| ref.getCodigo().equals("ZZAL000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getAntiplaquetarios_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("B")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& (ref.getSubclase3()!=null && ref.getSubclase3().equals("A") || ref.getSubclase3()!=null && ref.getSubclase3().equals("C")))
					|| ref.getCodigo().equals("ZZAP000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getBetabloqueantes_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("07"))
					|| ref.getCodigo().equals("ZZBB000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getBroncodilatadores_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("R")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("03"))
					|| ref.getCodigo().equals("ZZBR000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getCalcioantagonistas_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("08"))
					|| ref.getCodigo().equals("ZZCA000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getDigitalicos_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A"))
					|| ref.getCodigo().equals("ZZDG000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}	
		return diag;
	}
	
	public ArrayList<SelectItem> getDiureticos_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("03"))
					|| ref.getCodigo().equals("ZZDI000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getEsteroides_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("A")
					&& (ref.getSubclase2()!=null && ref.getSubclase2().equals("14") || ref.getSubclase2()!=null && ref.getSubclase2().equals("16")))
					|| ref.getCodigo().equals("ZZES000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getHeparina_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("B")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A")
					&& ref.getSubclase4()!=null && ref.getSubclase4().equals("B")
					&& ref.getSubclase5()!=null && ref.getSubclase5().equals("01"))
					|| ref.getCodigo().equals("ZZHP000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getIeca_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("09"))
					|| ref.getCodigo().equals("ZZIA000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getInotropicos_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A")
					&& ref.getSubclase4()!=null && ref.getSubclase4().equals("A")
					&& ref.getSubclase5()!=null && ref.getSubclase5().equals("05"))
				|| (ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("C")
					&& ref.getSubclase4()!=null && ref.getSubclase4().equals("A")
					&& ref.getSubclase5()!=null && ref.getSubclase5().equals("04"))
					|| ref.getCodigo().equals("ZZIE000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}	
		return diag;
	}
	
	public ArrayList<SelectItem> getNitratos_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("D"))
					|| ref.getCodigo().equals("ZZNI000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getNitritos_siccs() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, this.bundle.getString("seleccione_opcion")));
		for (MedGenerico ref : this.genericos){
			if((ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01"))
				|| (ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A")
					&& ref.getSubclase4()!=null && ref.getSubclase4().equals("A")
					&& ref.getSubclase5()!=null && ref.getSubclase5().equals("05"))
					|| ref.getCodigo().equals("ZZNE000"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	/*************************************************************/
	public ArrayList<SelectItem> getTerapiacardiaca() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		diag.add(new SelectItem(1, "GLUCOSIDOS CARDIOTONICOS"));
		diag.add(new SelectItem(2, "ANTIARRITMICOS"));
		diag.add(new SelectItem(3, "ESTIMULANTES CARDIACOS"));
		diag.add(new SelectItem(4, "VASODILATADORES"));
		diag.add(new SelectItem(5, "OTROS"));
		return diag;
	}
	// TERAPIA CARDIACA / GLUCOSIDOS CARDIOTONICOS
	public ArrayList<SelectItem> getTerapiacardiaca1() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// TERAPIA CARDIACA / ANTIARRITMICOS
	public ArrayList<SelectItem> getTerapiacardiaca2() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("B"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// TERAPIA CARDIACA / ESTIMULANTES CARDIACOS
	public ArrayList<SelectItem> getTerapiacardiaca3() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("C"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// TERAPIA CARDIACA / VASODILATADORES
	public ArrayList<SelectItem> getTerapiacardiaca4() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("D"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// TERAPIA CARDIACA / VASODILATADORES
	public ArrayList<SelectItem> getTerapiacardiaca5() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("01")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("E"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	
	public ArrayList<SelectItem> getAntihipertensivos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		diag.add(new SelectItem(1, "ANTIADRENÉRGICOS DE ACCIÓN CENTRAL"));
		diag.add(new SelectItem(2, "ANTIADRENÉRGICOS DE ACCIÓN PERIFÉRICA"));
		diag.add(new SelectItem(3, "MÚSCULO LISO ARTERIOLAR"));
		diag.add(new SelectItem(4, "OTROS"));
		diag.add(new SelectItem(5, "ANTIHIPERTENSIVOS Y DIURÉTICOS COMBINADOS"));
		return diag;
	}
	
	// ANTIHIPERTENSIVOS / ACCIÓN CENTRAL
	public ArrayList<SelectItem> getAntihipertensivos1() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("02")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// ANTIHIPERTENSIVOS / ACCIÓN PERIFÉRICA
	public ArrayList<SelectItem> getAntihipertensivos2() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("02")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("C"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// ANTIHIPERTENSIVOS / MUSCULO LISO ARTERIORAL
	public ArrayList<SelectItem> getAntihipertensivos3() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("02")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("D"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// ANTIHIPERTENSIVOS / OTROS HIPERTENSIVOS
	public ArrayList<SelectItem> getAntihipertensivos4() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("02")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("K"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}	
		
	public ArrayList<SelectItem> getDiureticos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		diag.add(new SelectItem(1, "DIURÉTICOS DE TECHO BAJO - TIAZIDAS"));
		diag.add(new SelectItem(2, "DIURÉTICOS DE TECHO BAJO"));
		diag.add(new SelectItem(3, "DIURÉTICOS DE TECHO ALTO"));
		diag.add(new SelectItem(4, "AGENTES AHORRADORES DE POTASIO"));
		diag.add(new SelectItem(5, "DIURÉTICOS Y AGENTES AHORRADORES DE POTASIO EN COMBINACIÓN"));
		return diag;
	}
	
	// DIURETICOS / TECHO BAJO: TIAZIDAS
	public ArrayList<SelectItem> getDiureticos1() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("03")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("A"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}	
	// DIURETICOS / TECHO BAJO: SIN TIAZIDAS
	public ArrayList<SelectItem> getDiureticos2() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("03")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("B"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// DIURETICOS / TECHO ALTO
	public ArrayList<SelectItem> getDiureticos3() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("03")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("C"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// DIURETICOS / AHORRADORES DE POTASIO
	public ArrayList<SelectItem> getDiureticos4() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("03")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("D"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// DIURETICOS / AHORRADORES DE POTASIO + DIURETICOS
	public ArrayList<SelectItem> getDiureticos5() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("03")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("E"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// VASODILATADORES PERIFERICOS
	public ArrayList<SelectItem> getVasodilatadoresperifericos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("04"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// PENDIENTES DE VISUALIZACION
	public ArrayList<SelectItem> getVasoprotectores() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		diag.add(new SelectItem(1, "AGENTES DE USO TOPICO PARA EL TRATAMIENTO DE HEMORROIDES Y FISURAS ANALES"));
		diag.add(new SelectItem(2, "TERAPIA ANTIVARICOSA"));
		return diag;
	}
	// AGENTES BETA BLOQUEANTES
	public ArrayList<SelectItem> getAgentesbetabloqueantes() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("07"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	
	public ArrayList<SelectItem> getBloqueantescanalescalcio() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		diag.add(new SelectItem(1, "BLOQUEANTES SELECTIVOS DE CANALES DE CALCIO CON EFECTOS PRINCIPALMENTE VASCULARES"));
		diag.add(new SelectItem(2, "BLOQUEANTES SELECTIVOS DE CANALES DE CALCIO CON EFECTOS CARDÍACOS DIRECTOS"));
		diag.add(new SelectItem(3, "BLOQUEANTES DE CANALES DE CALCIO Y DIURÉTICOS"));
		return diag;
	}
	// ANTICALCICOS / EFECTOS VASCULARES
	public ArrayList<SelectItem> getBloqueantescanalescalcio1() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("08")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("C"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}	
	// ANTICALCICOS / SIN EFECTOS VASCULARES
	public ArrayList<SelectItem> getBloqueantescanalescalcio2() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("08")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("D"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	// ANTICALCICOS / + DIURETICOS
	public ArrayList<SelectItem> getBloqueantescanalescalcio3() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("08")
					&& ref.getSubclase3()!=null && ref.getSubclase3().equals("G"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	
	public ArrayList<SelectItem> getIeca() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("09"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	
	public ArrayList<SelectItem> getAntilipemicos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getSubclase1()!=null && ref.getSubclase1().equals("C")
					&& ref.getSubclase2()!=null && ref.getSubclase2().equals("10"))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}
		return diag;
	}
	
	/*public ArrayList<SelectItem> getAntiarritmicos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getTipomed().equals(1))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getDiureticos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getTipomed().equals(3))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getAntibioticos() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getTipomed().equals(9))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getIeca() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getTipomed().equals(10))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}
	
	public ArrayList<SelectItem> getAraii() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem(0, "NO ESPECIFICADO"));
		for (MedGenerico ref : this.genericos){
			if(ref.getTipomed().equals(11))
				diag.add(new SelectItem(ref.getIdmedgen(), ref.getNombregenerico()));
		}		
		return diag;
	}*/
	
	public ArrayList<SelectItem> getVias() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "NO ESPECIFICADA"));
		for (ArrMaestras diagnostico : this.vias)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}
	
	public ArrayList<SelectItem> getFormasPresentacion() {
		ArrayList<SelectItem> diag = new ArrayList<SelectItem>();
		diag.add(new SelectItem("0", "NO ESPECIFICADO"));
		for (ArrMaestras diagnostico : this.formaspresentacion)
			diag.add(new SelectItem(diagnostico.getCodigo().toString(),
					diagnostico.getValor()));
		return diag;
	}

	
	public PlanMedGen getPlanmedgen() {
		return planmedgen;
	}

	public void setPlanmedgen(PlanMedGen planmedgen) {
		this.planmedgen = planmedgen;
	}

	public PlanMedProc getPlanmedproc() {
		return planmedproc;
	}

	public void setPlanmedproc(PlanMedProc planmedproc) {
		this.planmedproc = planmedproc;
	}

	public ArrayList<PlanMedGen> getPlanmedicaciongen() {
		return planmedicaciongen;
	}

	public void setPlanmedicaciongen(ArrayList<PlanMedGen> planmedicaciongen) {
		this.planmedicaciongen = planmedicaciongen;
	}

	public HtmlDataTable getBindingMedicacionGeneral() {
		return bindingMedicacionGeneral;
	}

	public void setBindingMedicacionGeneral(HtmlDataTable bindingMedicacionGeneral) {
		this.bindingMedicacionGeneral = bindingMedicacionGeneral;
	}

	public PlanMedGen getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(PlanMedGen currentItem) {
		this.currentItem = currentItem;
	}

	public HtmlDataTable getBindingMedicacionGeneralImp() {
		return bindingMedicacionGeneralImp;
	}

	public void setBindingMedicacionGeneralImp(
			HtmlDataTable bindingMedicacionGeneralImp) {
		this.bindingMedicacionGeneralImp = bindingMedicacionGeneralImp;
	}

	public HtmlDataTable getBindingMedicacionGeneralSeg() {
		return bindingMedicacionGeneralSeg;
	}

	public void setBindingMedicacionGeneralSeg(
			HtmlDataTable bindingMedicacionGeneralSeg) {
		this.bindingMedicacionGeneralSeg = bindingMedicacionGeneralSeg;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public boolean isEditableImp() {
		return editableImp;
	}

	public void setEditableImp(boolean editableImp) {
		this.editableImp = editableImp;
	}

	public boolean isEditableSeg() {
		return editableSeg;
	}

	public void setEditableSeg(boolean editableSeg) {
		this.editableSeg = editableSeg;
	}

}

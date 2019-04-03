package com.sorin.idea.iu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlDataTable;

import com.sorin.idea.dao.ArrListaEsperaDao;
import com.sorin.idea.dao.ArrPacienteDao;
import com.sorin.idea.dto.ArrListaEspera;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.Complicacion;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.exceptions.ArrListaEsperaDaoException;
import com.sorin.idea.jdbc.ArrListaEsperaDaoImpl;

import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

public class ControlLe extends BaseIU {

	private SelectorIdioma si;
	private ResourceBundle bundle;
	private ArrayList<ArrListaEspera> lista;
	private ArrListaEsperaDao ledao;
	private ArrPacienteDao pacidao;
	private HtmlDataTable bindingle;
	private String columna;
	private Boolean ascendente;
	private ArrListaEspera filtro;
	private ArrListaEspera regselec;
	private Integer fila;
	private String usuario;
	private Integer ordenacion = 8;
	
	private ControlMaestras cm;
	private ArrMaestras[] operador;

	public ControlLe() {
		// TODO Auto-generated constructor stub
	}

	public void init(ActionEvent e) {
		try {
			this.si = (SelectorIdioma) getBean("selectorIdioma");
			if (this.si == null)
				this.si = new SelectorIdioma();
			setBean("selectorIdioma", this.si);
			FacesContext context = FacesContext.getCurrentInstance();
			this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
			
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
			LoginForm loginform;
			loginform = (LoginForm) getBean("loginForm");
			this.usuario = loginform.getSesionUsuario().getUsuario();
			this.lista = new ArrayList<ArrListaEspera>();
			this.ledao = new ArrListaEsperaDaoImpl(this.usuario);
			this.pacidao = new ArrPacienteDao(this.usuario);
			this.bindingle = new HtmlDataTable();
			this.filtro = new ArrListaEspera();
			this.filtro.setIngreso(null);
			this.filtro.setIngresomax(null);
			Integer a = null;
			this.filtro.setEdadmin(a);
			this.filtro.setEdadmax(null);
			this.filtro.setEstado(1);
			this.regselec = new ArrListaEspera();
			this.lista = this.ledao.findWhereFiltro(this.filtro);
			this.cargaMaestras();
		} catch (ArrListaEsperaDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_le")+": " + e1.getMessage());
		} catch (IUException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_user")+": " + e1.getMessage());
		}
	}
	
	public void cargaMaestras(){
		try {
			this.cm = (ControlMaestras) getBean("controlMaestras");
			if (cm == null)
				cm = new ControlMaestras();
			this.operador = cm.getPrimerOperador();
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_inicio_dmaestras")+": " + e1.getMessage());
		}
		
	}
	
	public void buscaPacientes(ActionEvent e){
		try{
			this.lista = this.ledao.findWhereFiltro(this.filtro);
			this.regselec = new ArrListaEspera();
			if(this.lista.size()<=0)
				this.pintaMensaje(AVISO, this.bundle.getString("info_msg_warn_consulta"));
		} catch (ArrListaEsperaDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_carga_le_2")+": " + e1.getMessage());
		}
	}
	
	public void limpiarFiltro(ActionEvent e){
		this.filtro = new ArrListaEspera();
		this.filtro.setIngreso(null);
		this.filtro.setIngresomax(null);
		Integer a = null;
		this.filtro.setEdadmin(a);
		this.filtro.setEdadmax(null);
		this.filtro.setEstado(1);
		this.regselec = new ArrListaEspera();
		this.lista.clear();
	}
	
	public void sortLista() {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				ArrListaEspera c1 = (ArrListaEspera) o1;
				ArrListaEspera c2 = (ArrListaEspera) o2;
				try {
					if (columna == null) {
						return 0;
					}
					if (columna.equals("edadmin")) {
						return ascendente ? c1.getEdadmin()
								.compareTo(c2.getEdadmin()
								) : c2.getEdadmin().compareTo(c1.getEdadmin());
					}else if (columna.equals("apellido1")) {
						return ascendente ? c1.getApellido1()
								.trim().compareTo(c2.getApellido1()
								.trim()) : c2.getApellido1().trim()
								.compareTo(c1.getApellido1().trim());
					}else if (columna.equals("nombre")) {
						return ascendente ? c1.getNombre()
								.trim().compareTo(c2.getNombre()
								.trim()) : c2.getNombre().trim()
								.compareTo(c1.getNombre().trim());
					}else if (columna.equals("codigoLe")) {
						return ascendente ? c1.getCodigoLe()
								.compareTo(c2.getCodigoLe()
								) : c2.getCodigoLe()
								.compareTo(c1.getCodigoLe());
					}else if (columna.equals("ingreso")) {
						return ascendente ? c1.getIngreso()
								.compareTo(c2.getIngreso())
								: c2.getIngreso().compareTo(c1.getIngreso());
					}else
						return 0;
				} catch (Exception ex) {
					return 0;
				}
			}
		};
		Collections.sort(this.lista, comparator);
	}

	public ArrayList<ArrListaEspera> getLista() {
		sortLista();
		return lista;
	}
	
	public void verLe(ActionEvent e){
		try{
			this.regselec = (ArrListaEspera) this.bindingle.getRowData();
		}catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_consulta_sel")+": " + e1.getMessage());
		}
	}
	
	public void borraLe(ActionEvent e){
		try{
			this.ledao.delete(this.regselec.createPk());
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_borrado"));
			this.buscaPacientes(null);
		}catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_borrado_error_exep")+": " + e1.getMessage());
		}
	}
	
	public void modLe(ActionEvent e){
		try{
			this.ledao.update(this.regselec.createPk(), this.regselec);
			PacienteAplDto paciente = new PacienteAplDto();
			paciente.setCodigo(this.regselec.getCodigoPaciente());
			paciente.setNombre(this.regselec.getNombre());
			paciente.setApellid1(this.regselec.getApellido1());
			paciente.setApellid2(this.regselec.getApellido2());
			paciente.setTelefono1(this.regselec.getTelefono1());
			paciente.setTelefono2(this.regselec.getTelefono2());
			
			this.pacidao.modificaPaciente(paciente);
			this.pintaMensaje(Mensaje.SEVERIDAD_INFO, this.bundle.getString("info_msg_editar_info"));
			this.buscaPacientes(null);
		}catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_guarda_error_exep")+": " + e1.getMessage());
		}
	}

	public void setLista(ArrayList<ArrListaEspera> lista) {
		this.lista = lista;
	}

	public HtmlDataTable getBindingle() {
		return bindingle;
	}

	public void setBindingle(HtmlDataTable bindingle) {
		this.bindingle = bindingle;
	}

	public ArrListaEspera getFiltro() {
		return filtro;
	}

	public void setFiltro(ArrListaEspera filtro) {
		this.filtro = filtro;
	}

	public Integer getFila() {
		return fila;
	}

	public void setFila(Integer fila) {
		this.fila = fila;
	}

	public ArrListaEspera getRegselec() {
		return regselec;
	}

	public void setRegselec(ArrListaEspera regselec) {
		this.regselec = regselec;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public Boolean getAscendente() {
		return ascendente;
	}

	public void setAscendente(Boolean ascendente) {
		this.ascendente = ascendente;
	}

	public Integer getOrdenacion() {
		return ordenacion;
	}

	public void setOrdenacion(Integer ordenacion) {
		this.ordenacion = ordenacion;
		switch (this.ordenacion) {
		case 0:
			this.ascendente = true;
			this.columna = "codigoLe";
			break;
		case 1:
			this.ascendente = false;
			this.columna = "codigoLe";
			break;
		case 2:
			this.ascendente = true;
			this.columna = "nombre";
			break;
		case 3:
			this.ascendente = false;
			this.columna = "nombre";
			break;
		case 4:
			this.ascendente = true;
			this.columna = "apellido1";
			break;
		case 5:
			this.ascendente = false;
			this.columna = "apellido1";
			break;
		case 6:
			this.ascendente = true;
			this.columna = "edadmin";
			break;
		case 7:
			this.ascendente = false;
			this.columna = "edadmin";
			break;
		case 8:
			this.ascendente = true;
			this.columna = "ingreso";
			break;
		case 9:
			this.ascendente = false;
			this.columna = "ingreso";
			break;
		}
	}
	
	public ArrayList<SelectItem> getOperadores() {
		ArrayList<SelectItem> c = new ArrayList<SelectItem>();
		c.add(new SelectItem("0", this.bundle.getString("seleccione_opcion")));
		for (ArrMaestras m : this.operador) {
			c.add(new SelectItem(m.getCodigo().toString(), m.getValor()));
		}
		return c;
	}

}

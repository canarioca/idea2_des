package com.sorin.idea.iu;

import hvn.apl.evomed.dto.DocHl7Dto;
import hvn.apl.evomed.ssh.UtilesTerminalSsh;
import hvn.apl.evomed.ssh.exception.SshException;
import hvn.apl.jProyecto2010.modelo.servicios.dto.SesionUsuarioDto;
import hvn.cm.dao.DAOException;
import hvn.cm.modelo.Mensaje;

import java.io.File;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.sorin.idea.dao.ArrDesfibriladorDao;
import com.sorin.idea.dao.DocHL7InformesDao;
import com.sorin.idea.dao.PacienteDao;
import com.sorin.idea.dao.UsuarioDao;
import com.sorin.idea.dto.ArrDesfibrilador;
import com.sorin.idea.dto.ArrDesfibriladorPk;
import com.sorin.idea.dto.EpisodioDto;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.exceptions.ArrDesfibriladorDaoException;
import com.sorin.idea.jdbc.ArrDesfibriladorDaoImpl;
import com.sorin.idea.util.ConstructorPdf;
import com.sorin.idea.util.GeneradorXml;
import com.sorin.idea.util.GestorFTPInforme;
import com.sorin.idea.util.UtilFechas;

public class ControlDesfibriladores extends BaseIU {
	private ArrDesfibrilador desf;
	private ArrDesfibrilador[] desflist;
	private ArrayList<ArrDesfibrilador> desfs;
	private ArrDesfibriladorDao desfdao;
	private ArrDesfibriladorPk desfpk;
	private ControlPacientes cp;
	private LoginForm lf;
	private HtmlDataTable bindingHistorico;
	private String columna = "fecha";
	private boolean ascendente = false;
	
	private ArrayList<EpisodioDto> episodios;
	private HtmlDataTable bindingepi;
	private PacienteDao pacientedao = new PacienteDao();
	private String usuario = "";

	public void iniciaDesfibriladores(ActionEvent e) {
		try {
			ControlEef ceef = (ControlEef) getBean("controlEef");
			if(ceef != null)
				ceef.anuladiag(null);
			this.desf = new ArrDesfibrilador();
			this.desfpk = new ArrDesfibriladorPk();
			this.lf = (LoginForm) getBean("loginForm");
			this.usuario = lf.getSesionUsuario().getUsuario();
			this.desfdao = new ArrDesfibriladorDaoImpl(lf.getSesionUsuario()
					.getUsuario());
			this.cp = (ControlPacientes) getBean("controlPacientes");
			if (cp == null) {
				cp = new ControlPacientes();
				this
						.pintaMensaje(Mensaje.SEVERIDAD_AVISO,
								"No ha seleccionado paciente o no se ha podido recuperar.");
			} else {
				this.desfs = new ArrayList<ArrDesfibrilador>();
				this.desf.setCodigoPaciente(this.cp.getPacienteSelect()
						.getCodigo());
				this.desflist = this.desfdao
						.findWhereCodigoPacienteEquals(this.desf
								.getCodigoPaciente());
				if (this.desflist != null)
					for (int i = 0; i < this.desflist.length; i++)
						this.desfs.add(this.desflist[i]);
			}
		} catch (Exception e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"No se puede recuperar el paciente seleccionado. Error: "
							+ e1.getMessage());
		}
	}

	public void cargaUltimoDai() {
		this.desf = this.desfs.get(0);
	}

	public void cargaDesfibrilador(ActionEvent e) {
		Integer fila = this.bindingHistorico.getRowIndex();
		this.desf = this.desfs.get(fila);
		this.desfpk = this.desf.createPk();
	}

	public void limpia(ActionEvent e) {
		this.desf = new ArrDesfibrilador();
		this.desf.setCodigoPaciente(this.cp.getPacienteSelect().getCodigo());
		this.desfpk = new ArrDesfibriladorPk();
	}
	
	public void preguarda(ActionEvent e) {
		try {
			this.episodios = new ArrayList<EpisodioDto>();
			this.episodios = (ArrayList<EpisodioDto>) this.pacientedao
				.getEpisodios(this.cp.getPacienteSelect()
						.getNhc());
			this.episodios.addAll((ArrayList<EpisodioDto>) this.pacientedao
					.getEpisodiosHospitalizacion(this.cp.getPacienteSelect()
							.getNhc()));
		} catch (DAOException e1) {
			this.pintaMensaje(3,
					"No se han podido obtener los episodios de hospitalización del paciente: "
							+ e1.getMessage());
		}
	}

	public void guarda(ActionEvent e) {
		Integer epi = this.bindingepi.getRowIndex();
		if(epi != null && epi >= 0)
			this.desf.setEpisodio(this.episodios.get(epi).getNumicu());
		boolean existe = false;
		try {
			if (this.desf.getFecha() == null) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
						"Introduzca la fecha");
			} else {
				if (this.desf.getNdai() == null
						|| this.desf.getNdai().length() != 5)
					this
							.pintaMensaje(
									Mensaje.SEVERIDAD_ERROR,
									"El número de DAI sigue el formato "
											+ ((this.desf.getFecha().getYear() + 1900) + "")
													.substring(2) + " XXX");
				else {
					ArrDesfibrilador[] ests = this.desfdao.findByDynamicWhere(
							" ndai = ?", new Object[] { this.desf.getNdai() });
					if (ests != null && ests.length > 0)
						if (this.desf.getCodigoDesfibrilador() == null) {
							this
									.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
											"El número de DAI ya ha sido asignado a otro DAI");
							existe = true;
						} else if (!ests[0].getCodigoDesfibrilador().equals(
								this.desf.getCodigoDesfibrilador())) {
							this
									.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
											"El número de estudio DAI ha sido asignado a otro DAI");
							existe = true;
						}
					if (!existe) {
						if (this.desf.getCodigoDesfibrilador() != null){
							this.desfdao.update(this.desf.createPk(), this.desf);
							//escribeEnClinica(false);
						}else {
							this.desfpk = this.desfdao.insert(this.desf);
							this.desf.setCodigoDesfibrilador(this.desfpk.getCodigoDesfibrilador());
							//escribeEnClinica(true);
						}
						this.pintaMensaje(Mensaje.SEVERIDAD_INFO,
								"Datos almacenados con éxito");
					}
				}
			}
		} catch (ArrDesfibriladorDaoException e1) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Se ha producido un error intentando guardar los datos: "
							+ e1.getMessage());
		} catch (Exception e1) {
			this.pintaMensaje(3, "Se ha producido un error enlazando el informe a EC: " + e1.getMessage());
		}
	}

	public void imprimeInforme(ActionEvent e) {
		if (this.desf.getCodigoDesfibrilador() == null) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Guarde los datos para poder imprimirlos");
		} else {
			ConstructorPdf constructorPDF = new ConstructorPdf();
			String PathFicheroXml = "";
			GeneradorXml generadorXML = new GeneradorXml(FacesContext
					.getCurrentInstance());

			try {
				PathFicheroXml = generadorXML.imprimeInformeDAI(this.desf,
						this.cp.pacienteSelect, new ArrayList<GenericosDto>());
			} catch (Exception se) {
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error generando documento,motivo: "
									+ se.getMessage(),
							"Error generando documento,Motivo: "
									+ se.getMessage());
				} catch (Exception e3) {
				}
			}

			try {
				constructorPDF.generarArchivoPdf(FacesContext
						.getCurrentInstance(), PathFicheroXml,
						"DAIARRITMIAS.jasper");
			} catch (Exception se) {
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error imprimiendo documento,motivo: "
									+ se.getMessage(),
							"Error imprimiendo documento,Motivo: "
									+ se.getMessage());
				} catch (Exception e2) {
				}
			}
		}
	}

	public void sortHistorico(final String columna, final boolean ascending) {
		Comparator comparator = new Comparator() {
			public int compare(Object o1, Object o2) {
				ArrDesfibrilador c1 = (ArrDesfibrilador) o1;
				ArrDesfibrilador c2 = (ArrDesfibrilador) o2;
				try {
					if (columna == null) {
						return 0;
					}
					if (columna.equals("codigo")) {
						return ascending ? c1.getCodigoDesfibrilador()
								.compareTo(c2.getCodigoDesfibrilador()) : c2
								.getCodigoDesfibrilador().compareTo(
										c1.getCodigoDesfibrilador());
					} else if (columna.equals("fecha")) {
						return ascending ? c1.getFecha().compareTo(
								c2.getFecha()) : c2.getFecha().compareTo(
								c1.getFecha());
					} else
						return 0;
				} catch (Exception ex) {
					return 0;
				}
			}
		};
		Collections.sort(this.desfs, comparator);
	}

	public ArrDesfibrilador getDesf() {
		return desf;
	}

	public void setDesf(ArrDesfibrilador desf) {
		this.desf = desf;
	}

	public ArrayList<ArrDesfibrilador> getDesfs() {
		sortHistorico(this.columna, this.ascendente);
		return desfs;
	}

	public void setDesfs(ArrayList<ArrDesfibrilador> desfs) {
		this.desfs = desfs;
	}

	public HtmlDataTable getBindingHistorico() {
		return bindingHistorico;
	}

	public void setBindingHistorico(HtmlDataTable bindingHistorico) {
		this.bindingHistorico = bindingHistorico;
	}

	public String getColumna() {
		return columna;
	}

	public void setColumna(String columna) {
		this.columna = columna;
	}

	public boolean isAscendente() {
		return ascendente;
	}

	public void setAscendente(boolean ascendente) {
		this.ascendente = ascendente;
	}

	public ArrayList<EpisodioDto> getEpisodios() {
		return episodios;
	}

	public void setEpisodios(ArrayList<EpisodioDto> episodios) {
		this.episodios = episodios;
	}

	public HtmlDataTable getBindingepi() {
		return bindingepi;
	}

	public void setBindingepi(HtmlDataTable bindingepi) {
		this.bindingepi = bindingepi;
	}

	public PacienteDao getPacientedao() {
		return pacientedao;
	}

	public void setPacientedao(PacienteDao pacientedao) {
		this.pacientedao = pacientedao;
	}
	static private String getRemoteFileName(long handle) {

		String remotePath = null;
		String remoteFileName = null;

		remotePath = "00000000" + Long.toHexString(handle);
		remotePath = remotePath.substring(remotePath.length() - 8, remotePath
				.length());
		remoteFileName = remotePath.substring(6, 8);

		return remoteFileName.toUpperCase();
	}

	static private String getRemotePath(long handle) {

		String remotePath = null;

		remotePath = "00000000" + Long.toHexString(handle);
		remotePath = remotePath.substring(remotePath.length() - 8, remotePath
				.length());
		remotePath = remotePath.substring(0, 2) + "/"
				+ remotePath.substring(2, 4) + "/" + remotePath.substring(4, 6);

		return remotePath.toUpperCase();
	}

	public void escribeEnClinica(boolean nuevo) throws Exception {
		DocHl7Dto consultaNueva = new DocHl7Dto();
		String path = printFichero();
		if (nuevo) {
			Integer numHandle;
			try {
				numHandle = UtilesTerminalSsh.getSiguienteID("SGHANINFEXT",
						true);
			} catch (SshException ex) {
				numHandle = -1;
			}
			consultaNueva.setHandle(numHandle);

			Integer numDocHl7Informes;
			try {
				numDocHl7Informes = UtilesTerminalSsh.getSiguienteID(
						"SGCODINFEXT", true);
			} catch (SshException ex) {
				numDocHl7Informes = -1;
			}
			consultaNueva.setIdinfor(numDocHl7Informes);
			consultaNueva.setIdinforext("" + this.desf.getNdai());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.desf.getEpisodio() != null && this.desf.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.desf.getEpisodio());
			else
				consultaNueva.setEpisodio("0");
			UsuarioDao usDao = new UsuarioDao();
        	SesionUsuarioDto ses = new SesionUsuarioDto();
        	ses.setLogin(this.usuario);
			String doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
			consultaNueva.setRedactor(doctor);
			consultaNueva.setResponprime(doctor);
			consultaNueva.setServicio("QCAR");
			Timestamp fecT = UtilFechas.dateToTimestamp(this.desf.getFecha());
			consultaNueva.setFcreacion(fecT);
			Time t = new Time(fecT.getTime());
			consultaNueva.setHcreacion(t);
			consultaNueva.setIdtipodoc(56);
			consultaNueva.setIdsubti("ARR03");
			enviaInformeFTP(consultaNueva, true, path);

		} else {
			Timestamp fecT = UtilFechas.dateToTimestamp(this.desf.getFecha());
			Time t = new Time(fecT.getTime());
			consultaNueva.setNhc(this.cp.getPacienteSelect().getNhc());
			consultaNueva.setIdpetic("0");
			if(this.desf.getEpisodio() != null && this.desf.getEpisodio().length() > 0)
				consultaNueva.setEpisodio(this.desf.getEpisodio());
			else
				consultaNueva.setEpisodio("0");
			UsuarioDao usDao = new UsuarioDao();
        	SesionUsuarioDto ses = new SesionUsuarioDto();
        	ses.setLogin(this.usuario);
			String doctor = usDao.getUsuariosByNom(ses).get(0).getNombre().trim();
			consultaNueva.setRedactor(doctor);
			consultaNueva.setResponprime(doctor);
			consultaNueva.setResponsegun(doctor);
			consultaNueva.setServicio("QCAR");
			consultaNueva.setIdinforext("" + this.desf.getNdai());
			consultaNueva.setIdsubti("ARR03");
			consultaNueva.setIdtipodoc(56);
			consultaNueva.setFmodificacion(fecT);
			consultaNueva.setHmodificacion(t);
			enviaInformeFTP(consultaNueva, false, path);
		}
	}
	
	public void enviaInformeFTP(DocHl7Dto item, boolean nuevo, String path) {
		logInfo("Inicio de ControlConsulta.enviaInformeFTP");
		boolean seguir = true;
		try {
			if (nuevo) {
				DocHL7InformesDao docHL7InformesDao = new DocHL7InformesDao(this.usuario);
				docHL7InformesDao.añadirDocHL7Informes(item);
			} else {
				try{
					DocHL7InformesDao docHL7InformesDao = new DocHL7InformesDao(this.usuario);
					item.setHandle(new Integer(docHL7InformesDao
						.modificarDocHL7InformesIdExt(item)));
				}catch (Exception e) {
					//escribeEnClinica(true);
					seguir = false;
				}
			}

			if(seguir){
				String pathFTP = "";

				pathFTP = "/" + getRemotePath(item.getHandle()) + "/"
					+ getRemoteFileName(item.getHandle());

				if (GestorFTPInforme.enviarFicheroFTP(path, pathFTP) == 1) {
					File ficheroLocal = new File(path);
					ficheroLocal.delete();
				}
			}

		} catch (Exception ex) {
				this.pintaMensaje(Mensaje.SEVERIDAD_ERROR, "Error guardando informe. Motivo: "
						+ ex.getMessage());
		}
		logInfo("Fin de ControlConsulta.enviaInformeFTP");
	}
	
	public String printFichero() {
		String path = "";
		if (this.desf.getCodigoDesfibrilador() == null) {
			this.pintaMensaje(Mensaje.SEVERIDAD_ERROR,
					"Guarde los datos para poder imprimirlos");
		} else {
			ConstructorPdf constructorPDF = new ConstructorPdf();
			String PathFicheroXml = "";
			GeneradorXml generadorXML = new GeneradorXml(FacesContext
					.getCurrentInstance());

			try {
				PathFicheroXml = generadorXML.imprimeInformeDAI(this.desf,
						this.cp.pacienteSelect, new ArrayList<GenericosDto>());
			} catch (Exception se) {
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error generando documento,motivo: "
									+ se.getMessage(),
							"Error generando documento,Motivo: "
									+ se.getMessage());
				} catch (Exception e3) {
				}
			}

			try {
				path = constructorPDF.generarArchivoPdfFile(FacesContext.getCurrentInstance(), 
						PathFicheroXml, "DAIARRITMIAS.jasper");
			} catch (Exception se) {
				try {
					nuevoMensaje(formulario.getId(), Mensaje.SEVERIDAD_ERROR,
							"Error imprimiendo documento,motivo: "
									+ se.getMessage(),
							"Error imprimiendo documento,Motivo: "
									+ se.getMessage());
				} catch (Exception e2) {
				}
			}
		}
		return path;
	}
}

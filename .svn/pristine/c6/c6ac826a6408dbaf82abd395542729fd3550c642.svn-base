package com.sorin.idea.dto;

import java.util.Date;

import com.sorin.idea.util.UtilCodifi;
import com.sorin.idea.util.UtilFechas;

import hvn.cm.bdu.dto.PacienteBduBean;
import hvn.cm.modelo.dto.BaseDto;

public class PacienteAplDto extends BaseDto {
    private static final long serialVersionUID = 1L;

    // Datos clínicos
    private Integer 		  codigo;
    private String            nhc;
    private String            nombre           = "";
    private String            apellid1         = "";
    private String            apellid2         = "";
    private String            nuhsa;
    private Integer           sexo;
    private Date              fechaNaci;
    private String            fechaNaciString;
    private String            dni;
    private String            nss1;
    private String            direccion;
    private String            provincia;
    private String            poblacion;
    private String			  pais;
    private String            telefono;
    private String            cp;
    private String            estado           = "";
    private String            edad;
    private String            telefono1;
    private String            telefono2;
    private String            correo;
    private Integer			  procedencia = 0;
    private Integer			  hprocedencia = 0;
    private String			  ndai = "";
    private String			  ncv = "";
    private String			  neef = "";
    private String			  nreg = "";
    private String			  nmesa = "";
    private String			  natp = "";
    private String			  nepi = "";
    private String			  nfle = "";
    private String			  nimp = "";
    private String            nsegclin="";
    private String            nsegregev="";
    private String            nholter="";
    private String            nregevext="";
    private String            ntestorto="";
    
    private Integer			  tipoproc;
    private Date			  fechaproc;
    private Date			  fechaprocfin;
    private String	 	      nproc;
    private Integer			  idcv = 0;
    private Integer			  ideef = 0;
    private Integer			  idreg = 0;
    private Integer			  idmesa = 0;
    private Integer			  idatp = 0;
    private Integer			  idepi = 0;
    private Integer			  idfle = 0;
    private Integer			  idimp = 0;
    private Integer 		  idsegclin=0;
    private Integer			  idholter = 0;
    private Integer			  idregevext = 0;
    private Integer			  idtestorto = 0;
    private Date			  fechaeef;
    private Date			  fechacv;
    private Date			  fechareg;
    private Date			  fechamesa;
    private Date			  fechaatp;
    private Date			  fechaepi;
    private Date			  fechafle;
    private Date			  fechaimp;
    private Date 		      fechasegclin;
    private Date 		      fechasegregev;
    private Date 		      fechaholter;
    private Date 		      fecharegevext;
    private Date 		      fechatestorto;
    
    private Integer			  tipoEstudio = 0;
    private String			  numEstudio = "";
    
    private boolean eef = false;
    private boolean dai = false;
    private boolean cv = false;
    private boolean mp = false;
    private boolean mp_leadless = false;
    private boolean protocolo = false;
    
    private ArrPacienteHcardio hcardio;
    private ArrPacienteHclin hclin;
    private SituacionClinicaGeneral sitclin;
    
    private boolean seleccion;
    private String dosisEscopiaAcum;
    private String resumenCompl;
    
    private Integer estadoproc = 0;

    /////////// FILTROS ADICIONALES
    private String modeloGen;
    private String numserieGen;
    
    private String modeloRegEv;
    private String numserieRegEv;
    
    private Integer diagEef;
    private Integer ablEef;
    private Integer sustAblEef;
    
    private String modeloDisp;
    private String nserieDisp;
    
    private Integer estadoprocfiltro; 
    
    public PacienteAplDto() {
    	this.hcardio = new ArrPacienteHcardio();
    	this.hclin = new ArrPacienteHclin();
    	this.sitclin = new SituacionClinicaGeneral();
    }

    public PacienteAplDto(PacienteBduBean item) {
        bduafiltro(item);
        this.hcardio = new ArrPacienteHcardio();
        this.hclin = new ArrPacienteHclin();
        this.sitclin = new SituacionClinicaGeneral();
    }

    public PacienteAplDto(PacienteAplDto tmp) {
    	this.codigo = tmp.getCodigo();
        this.nuhsa = tmp.getNuhsa();
        this.nhc = tmp.getNhc();
        this.nombre = tmp.getNombre();
        this.apellid1 = tmp.getApellid1();
        this.apellid2 = tmp.getApellid2();
        this.dni = tmp.getDni();
        this.nss1 = tmp.getNss1();
        this.fechaNaci = tmp.getFechaNaci();
        this.sexo = tmp.getSexo();
        this.direccion = tmp.getDireccion();
        this.provincia = tmp.getProvincia();
        this.poblacion = tmp.getPoblacion();
        this.procedencia = tmp.getProcedencia();
        this.hprocedencia = tmp.getHprocedencia();
        this.pais = tmp.getPais();
        this.cp = tmp.getCp();
        this.telefono1 = tmp.getTelefono1();
        this.telefono2 = tmp.getTelefono2();
        this.correo = tmp.getCorreo();
        
        this.hcardio = tmp.getHcardio();
        this.hclin = tmp.getHclin();
        this.sitclin = tmp.getSitclin();
    }

    public PacienteAplDto bduafiltro(PacienteBduBean item) {
        try {
            this.setApellid1(item.getApellido1());
            this.setApellid2(item.getApellido2());
            this.setNombre(item.getNombre());
            this.setCp(item.getCodigoPostal().toString());

            /* DIRECCIÓN */
            // Nombre de la vía
            this.setDireccion(item.getNombreVia());
            // Tipo de vía
            if (item.getVia() != null && !item.getVia().equals("") && !item.getVia().equals("null"))
                this.setDireccion(item.getVia() + " " + this.getDireccion());
            // Nº vía
            if (item.getNumeroVia() != null && !item.getNumeroVia().equals("")
                && !item.getNumeroVia().equals("null"))
                this.setDireccion(this.getDireccion() + " Nº" + item.getNumeroVia() + " ");
            // Bloque
            if (item.getBloque() != null && !item.getBloque().equals("") && !item.getBloque().equals("null"))
                this.setDireccion(this.getDireccion() + " Bloque " + item.getBloque() + " ");
            // Escalera
            if (item.getEscalera() != null && !item.getEscalera().equals("") && !item.getEscalera().equals("null"))
                this.setDireccion(this.getDireccion() + "Escalera " + item.getEscalera() + " ");
            // Piso
            if (item.getPiso() != null && !item.getPiso().equals("") && !item.getPiso().equals("null"))
                this.setDireccion(this.getDireccion() + item.getPiso() + "º ");
            // Puerta
            if (item.getPuerta() != null && !item.getPuerta().equals("") && !item.getPuerta().equals("null"))
                this.setDireccion(this.getDireccion() + item.getPuerta());

            this.setDni(item.getDni());
            this.setEstado("D");
            this.setFechaNaci(item.getFechaNacimiento());
            this.setNhc("");
            this.setNss1(item.getNss());
            this.setNuhsa(item.getNuhsa());
            this.setPoblacion(item.getPoblacionSinCodifi());
            this.setProvincia(item.getProvinciaSinCodifi());
            this.setPais(item.getPaisSinCodifi());
            if (item.getSexo() != null && item.getSexo() == 0)
                this.setSexo(1);
            else if (item.getSexo() != null && item.getSexo() == 1)
                this.setSexo(2);
            this.setTelefono1(item.getTelefono());
            this.setTelefono2(item.getTelefono2());
            this.setCorreo("");
            
            return this;
        }
        catch (Exception ex) {
            return new PacienteAplDto();
        }

    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApellid1() {
        // return UtilCodifi.getCodWin(apellid1);
        return this.apellid1;
    }

    public void setApellid1(String apellid1) {
        if (apellid1.contains("Ð"))
            apellid1 = apellid1.replace("Ð", "Ñ");
        this.apellid1 = apellid1;
    }

    public String getApellid2() {
        // return UtilCodifi.getCodWin(apellid2);
        return this.apellid2;
    }

    public void setApellid2(String apellid2) {
        this.apellid2 = apellid2;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNaci() {
        return fechaNaci;
    }

    public void setFechaNaci(Date fechaNaci) {
        this.fechaNaci = fechaNaci;
    }

    public String getNhc() {
        return nhc;
    }

    public void setNhc(String nhc) {
        this.nhc = nhc;
    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNss1() {
        return UtilCodifi.getCodWin(nss1);

    }

    public void setNss1(String nss1) {
        this.nss1 = nss1;
    }

    public String getNuhsa() {
        return nuhsa;
    }

    public void setNuhsa(String nuhsa) {
        this.nuhsa = nuhsa;
    }

    public String getPoblacion() {
        return this.poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return this.provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Integer getSexo() {
        return sexo;
    }

    public void setSexo(Integer sexo) {
        this.sexo = sexo;
    }

    public String getTelefono() {
        return UtilCodifi.getCodWin(telefono);
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getFechaNaciString() {
        try {
            fechaNaciString = UtilFechas.getFechaStringFormato(fechaNaci, "dd/MM/yyyy");
           // fechaNaciString = UtilFechas.dateToString(fechaNaci);
        }
        catch (Exception ex) {
            fechaNaciString = "";
        }
        return fechaNaciString;
    }

    public void setFechaNaciString(String fechaNaciString) {
        this.fechaNaciString = fechaNaciString;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEdad() {
        try {
            if (fechaNaci != null)
                edad = new Integer(UtilFechas.getEdad(fechaNaci)).toString();
        }
        catch (Exception ex) {
            edad = "";
        }

        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNombreCompleto() {
    	String nombre = (this.apellid1!=null?this.apellid1.toUpperCase():"");
    	if (this.apellid2 != null && this.apellid2.length() > 0)
    		nombre += " " + this.apellid2.toUpperCase();
    	nombre += ", " + (this.nombre!=null?this.nombre.toUpperCase():"");
        return  nombre;
    }

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getProcedencia() {
		return procedencia;
	}

	public void setProcedencia(Integer procedencia) {
		this.procedencia = procedencia;
	}

	public Integer getHprocedencia() {
		return hprocedencia;
	}

	public void setHprocedencia(Integer hprocedencia) {
		this.hprocedencia = hprocedencia;
	}

	public String getNdai() {
		return ndai;
	}

	public void setNdai(String ndai) {
		this.ndai = ndai;
	}

	public String getNcv() {
		return ncv;
	}

	public void setNcv(String ncv) {
		this.ncv = ncv;
	}

	public String getNeef() {
		return neef;
	}

	public void setNeef(String neef) {
		this.neef = neef;
	}

	public ArrPacienteHcardio getHcardio() {
		return hcardio;
	}

	public void setHcardio(ArrPacienteHcardio hcardio) {
		if(hcardio == null)
			this.hcardio = new ArrPacienteHcardio();
		else
			this.hcardio = hcardio;
	}

	public ArrPacienteHclin getHclin() {
		return hclin;
	}

	public void setHclin(ArrPacienteHclin hclin) {
		if(hclin == null)
			this.hclin = new ArrPacienteHclin();
		else
			this.hclin = hclin;
	}

	public boolean isEef() {
		return eef;
	}

	public void setEef(boolean eef) {
		this.eef = eef;
	}

	public boolean isDai() {
		return dai;
	}

	public void setDai(boolean dai) {
		this.dai = dai;
	}

	public boolean isCv() {
		return cv;
	}

	public void setCv(boolean cv) {
		this.cv = cv;
	}

	public Integer getTipoEstudio() {
		return tipoEstudio;
	}

	public void setTipoEstudio(Integer tipoEstudio) {
		this.tipoEstudio = tipoEstudio;
	}

	public String getNumEstudio() {
		return numEstudio;
	}

	public void setNumEstudio(String numEstudio) {
		this.numEstudio = numEstudio;
	}

	public boolean isMp() {
		return mp;
	}

	public void setMp(boolean mp) {
		this.mp = mp;
	}

	public SituacionClinicaGeneral getSitclin() {
		return sitclin;
	}

	public void setSitclin(SituacionClinicaGeneral sitclin) {
		if(sitclin==null)
			this.sitclin = new SituacionClinicaGeneral();
		else
			this.sitclin = sitclin;
	}

	public String getNreg() {
		return nreg;
	}

	public void setNreg(String nreg) {
		this.nreg = nreg;
	}

	public String getNmesa() {
		return nmesa;
	}

	public void setNmesa(String nmesa) {
		this.nmesa = nmesa;
	}

	public String getNatp() {
		return natp;
	}

	public void setNatp(String natp) {
		this.natp = natp;
	}

	public String getNepi() {
		return nepi;
	}

	public void setNepi(String nepi) {
		this.nepi = nepi;
	}

	public String getNfle() {
		return nfle;
	}

	public void setNfle(String nfle) {
		this.nfle = nfle;
	}

	public Integer getTipoproc() {
		return tipoproc;
	}

	public void setTipoproc(Integer tipoproc) {
		this.tipoproc = tipoproc;
	}

	public Date getFechaproc() {
		return fechaproc;
	}

	public void setFechaproc(Date fechaproc) {
		this.fechaproc = fechaproc;
	}

	public String getNproc() {
		return nproc;
	}

	public void setNproc(String nproc) {
		this.nproc = nproc;
	}

	public Integer getIdcv() {
		return idcv;
	}

	public void setIdcv(Integer idcv) {
		this.idcv = idcv;
	}

	public Integer getIdeef() {
		return ideef;
	}

	public void setIdeef(Integer ideef) {
		this.ideef = ideef;
	}

	public Integer getIdreg() {
		return idreg;
	}

	public void setIdreg(Integer idreg) {
		this.idreg = idreg;
	}

	public Integer getIdmesa() {
		return idmesa;
	}

	public void setIdmesa(Integer idmesa) {
		this.idmesa = idmesa;
	}

	public Integer getIdatp() {
		return idatp;
	}

	public void setIdatp(Integer idatp) {
		this.idatp = idatp;
	}

	public Integer getIdepi() {
		return idepi;
	}

	public void setIdepi(Integer idepi) {
		this.idepi = idepi;
	}

	public Integer getIdfle() {
		return idfle;
	}

	public void setIdfle(Integer idfle) {
		this.idfle = idfle;
	}

	public Date getFechaeef() {
		return fechaeef;
	}

	public void setFechaeef(Date fechaeef) {
		this.fechaeef = fechaeef;
	}

	public Date getFechacv() {
		return fechacv;
	}

	public void setFechacv(Date fechacv) {
		this.fechacv = fechacv;
	}

	public Date getFechareg() {
		return fechareg;
	}

	public void setFechareg(Date fechareg) {
		this.fechareg = fechareg;
	}

	public Date getFechamesa() {
		return fechamesa;
	}

	public void setFechamesa(Date fechamesa) {
		this.fechamesa = fechamesa;
	}

	public Date getFechaatp() {
		return fechaatp;
	}

	public void setFechaatp(Date fechaatp) {
		this.fechaatp = fechaatp;
	}

	public Date getFechaepi() {
		return fechaepi;
	}

	public void setFechaepi(Date fechaepi) {
		this.fechaepi = fechaepi;
	}

	public Date getFechafle() {
		return fechafle;
	}

	public void setFechafle(Date fechafle) {
		this.fechafle = fechafle;
	}

	public Date getFechaprocfin() {
		return fechaprocfin;
	}

	public void setFechaprocfin(Date fechaprocfin) {
		this.fechaprocfin = fechaprocfin;
	}

	public String getNimp() {
		return nimp;
	}

	public void setNimp(String nimp) {
		this.nimp = nimp;
	}

	public Integer getIdimp() {
		return idimp;
	}

	public void setIdimp(Integer idimp) {
		this.idimp = idimp;
	}

	public Date getFechaimp() {
		return fechaimp;
	}

	public void setFechaimp(Date fechaimp) {
		this.fechaimp = fechaimp;
	}

	public boolean isSeleccion() {
		return seleccion;
	}

	public void setSeleccion(boolean seleccion) {
		this.seleccion = seleccion;
	}

	public boolean isMp_leadless() {
		return mp_leadless;
	}

	public void setMp_leadless(boolean mp_leadless) {
		this.mp_leadless = mp_leadless;
	}

	public String getNsegclin() {
		return nsegclin;
	}

	public void setNsegclin(String nsegclin) {
		this.nsegclin = nsegclin;
	}

	public Integer getIdsegclin() {
		return idsegclin;
	}

	public void setIdsegclin(Integer idsegclin) {
		this.idsegclin = idsegclin;
	}

	public Date getFechasegclin() {
		return fechasegclin;
	}

	public void setFechasegclin(Date fechasegclin) {
		this.fechasegclin = fechasegclin;
	}

	public String getNsegregev() {
		return nsegregev;
	}

	public void setNsegregev(String nsegregev) {
		this.nsegregev = nsegregev;
	}

	public Date getFechasegregev() {
		return fechasegregev;
	}

	public void setFechasegregev(Date fechasegregev) {
		this.fechasegregev = fechasegregev;
	}

	public Integer getIdholter() {
		return idholter;
	}

	public void setIdholter(Integer idholter) {
		this.idholter = idholter;
	}

	public String getNholter() {
		return nholter;
	}

	public void setNholter(String nholter) {
		this.nholter = nholter;
	}

	public Date getFechaholter() {
		return fechaholter;
	}

	public void setFechaholter(Date fechaholter) {
		this.fechaholter = fechaholter;
	}

	public String getNregevext() {
		return nregevext;
	}

	public void setNregevext(String nregevext) {
		this.nregevext = nregevext;
	}

	public Integer getIdregevext() {
		return idregevext;
	}

	public void setIdregevext(Integer idregevext) {
		this.idregevext = idregevext;
	}

	public Date getFecharegevext() {
		return fecharegevext;
	}

	public void setFecharegevext(Date fecharegevext) {
		this.fecharegevext = fecharegevext;
	}

	public String getModeloGen() {
		return modeloGen;
	}

	public void setModeloGen(String modeloGen) {
		this.modeloGen = modeloGen;
	}

	public String getNumserieGen() {
		return numserieGen;
	}

	public void setNumserieGen(String numserieGen) {
		this.numserieGen = numserieGen;
	}

	public String getModeloRegEv() {
		return modeloRegEv;
	}

	public void setModeloRegEv(String modeloRegEv) {
		this.modeloRegEv = modeloRegEv;
	}

	public String getNumserieRegEv() {
		return numserieRegEv;
	}

	public void setNumserieRegEv(String numserieRegEv) {
		this.numserieRegEv = numserieRegEv;
	}

	public Integer getDiagEef() {
		return diagEef;
	}

	public void setDiagEef(Integer diagEef) {
		this.diagEef = diagEef;
	}

	public Integer getAblEef() {
		return ablEef;
	}

	public void setAblEef(Integer ablEef) {
		this.ablEef = ablEef;
	}

	public Integer getSustAblEef() {
		return sustAblEef;
	}

	public void setSustAblEef(Integer sustAblEef) {
		this.sustAblEef = sustAblEef;
	}

	public String getModeloDisp() {
		return modeloDisp;
	}

	public void setModeloDisp(String modeloDisp) {
		this.modeloDisp = modeloDisp;
	}

	public String getNserieDisp() {
		return nserieDisp;
	}

	public void setNserieDisp(String nserieDisp) {
		this.nserieDisp = nserieDisp;
	}

	public String getDosisEscopiaAcum() {
		return dosisEscopiaAcum;
	}

	public void setDosisEscopiaAcum(String dosisEscopiaAcum) {
		this.dosisEscopiaAcum = dosisEscopiaAcum;
	}

	public String getResumenCompl() {
		return resumenCompl;
	}

	public void setResumenCompl(String resumenCompl) {
		this.resumenCompl = resumenCompl;
	}

	public String getNtestorto() {
		return ntestorto;
	}

	public void setNtestorto(String ntestorto) {
		this.ntestorto = ntestorto;
	}

	public Date getFechatestorto() {
		return fechatestorto;
	}

	public void setFechatestorto(Date fechatestorto) {
		this.fechatestorto = fechatestorto;
	}

	public Integer getIdtestorto() {
		return idtestorto;
	}

	public void setIdtestorto(Integer idtestorto) {
		this.idtestorto = idtestorto;
	}

	public boolean isProtocolo() {
		return protocolo;
	}

	public void setProtocolo(boolean protocolo) {
		this.protocolo = protocolo;
	}

	public Integer getEstadoproc() {
		return estadoproc;
	}

	public void setEstadoproc(Integer estadoproc) {
		this.estadoproc = estadoproc;
	}

	public Integer getEstadoprocfiltro() {
		return estadoprocfiltro;
	}

	public void setEstadoprocfiltro(Integer estadoprocfiltro) {
		this.estadoprocfiltro = estadoprocfiltro;
	}

}

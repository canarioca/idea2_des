package com.sorin.idea.util;

import java.util.Date;

/**
 * POJO contenedor para exportacion de registros de DAI
 * @author Francisco.Romera
 *
 */
public class RegistroDaiDto {

	private Date fechaNac;
	private Integer edad;
	private String sexo = "";
	private String seg = "";
	private String poblacion = "";
	private String hospImp = "";
	private String hospProc = "";
	private String ciudadHosp = "";
	private String cardiopatia = "";
	private String cardiopatiaOtra = "";
	private String revasc = "";
	private String infPrevio = "";
	private String aevol = "";
	private String inPrevAn = "";
	private String fracEyec = "";
	private String ic = "";
	private String enfCond = "";
	private String ritmoBasal= "";
	private String ritmoBasalOtro= "";
	private String antInsRenal= "";
	private String antFa= "";
	private String antDiab= "";
	private String antHta= "";
	private String antMuerteSub= "";
	private String anchQRS= "";
	private String antFum= "";
	private String antDislip= "";
	private String antAcv= "";
	
	private String arritmiaClinica= "";
	private String presClinica= "";
	private String presClinciaOtros= "";
	private String eef= "";
	private String eefArritmia= "";
	
	private String prevencion= "";
	private Date fechaImpl;
	private String lugarImpl= "";
	private String implantador= "";
	private String tipoProc= "";
	private Date fechaImplPrev;
	private String motivosRecambioAgot= "";
	private String motivosRecambioCompl= "";
	private String motivosRecambioUpgrade= "";
	private String modeloGen= "";
	private String nserieGen= "";
	private String locGen= "";
	private Boolean ad;
	private String modeloAD= "";
	private String nserieAD= "";
	private Boolean vd;
	private String modeloVD= "";
	private String nserieVD= "";
	private Boolean vi;
	private String modeloVI= "";
	private String nserieVI= "";
	private String epiTVFV= "";
	private String terapiaATP= "";
	private String terapiaChoques= "";
	
	
	private Date fechaImplElecPrevios;
	private String elecAdiSensado= "";
	private String elecAdiDesf= "";
	private Boolean elecPrevFunc;
	private Boolean elecPrevDisf;
	private Boolean elecPrevDisfAband;
	private Boolean elecPrevDisfExpl;
	
	private Boolean induccion;
	private String induccionEnergia= "";
	private String induccionNumChoques= "";
	
	private String compliNinguna= "";
	private String compliMuerte= "";
	private String compliTapCard= "";
	private String compliNeumo= "";
	private String compliDiseccionSC= "";
	private String compliOtro= "";
	private String compliSitSubOptima= "";
	
	private String estimAntiBradi= "";
	private String mev= "";
	private String atpProg= "";
	private String modelo= "";
	
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public Integer getEdad() {
		return edad;
	}
	public void setEdad(Integer edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getSeg() {
		return seg;
	}
	public void setSeg(String seg) {
		this.seg = seg;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getHospImp() {
		return hospImp;
	}
	public void setHospImp(String hospImp) {
		this.hospImp = hospImp;
	}
	public String getHospProc() {
		return hospProc;
	}
	public void setHospProc(String hospProc) {
		this.hospProc = hospProc;
	}
	public String getCiudadHosp() {
		return ciudadHosp;
	}
	public void setCiudadHosp(String ciudadHosp) {
		this.ciudadHosp = ciudadHosp;
	}
	public String getCardiopatia() {
		return cardiopatia;
	}
	public void setCardiopatia(String cardiopatia) {
		this.cardiopatia = cardiopatia;
	}
	public String getCardiopatiaOtra() {
		return cardiopatiaOtra;
	}
	public void setCardiopatiaOtra(String cardiopatiaOtra) {
		this.cardiopatiaOtra = cardiopatiaOtra;
	}
	public String getRevasc() {
		return revasc;
	}
	public void setRevasc(String revasc) {
		this.revasc = revasc;
	}
	public String getInfPrevio() {
		return infPrevio;
	}
	public void setInfPrevio(String infPrevio) {
		this.infPrevio = infPrevio;
	}
	public String getAevol() {
		return aevol;
	}
	public void setAevol(String aevol) {
		this.aevol = aevol;
	}
	public String getInPrevAn() {
		return inPrevAn;
	}
	public void setInPrevAn(String inPrevAn) {
		this.inPrevAn = inPrevAn;
	}
	public String getFracEyec() {
		return fracEyec;
	}
	public void setFracEyec(String fracEyec) {
		this.fracEyec = fracEyec;
	}
	public String getIc() {
		return ic;
	}
	public void setIc(String ic) {
		this.ic = ic;
	}
	public String getEnfCond() {
		return enfCond;
	}
	public void setEnfCond(String enfCond) {
		this.enfCond = enfCond;
	}
	public String getRitmoBasal() {
		return ritmoBasal;
	}
	public void setRitmoBasal(String ritmoBasal) {
		this.ritmoBasal = ritmoBasal;
	}
	public String getRitmoBasalOtro() {
		return ritmoBasalOtro;
	}
	public void setRitmoBasalOtro(String ritmoBasalOtro) {
		this.ritmoBasalOtro = ritmoBasalOtro;
	}
	public String getAntInsRenal() {
		return antInsRenal;
	}
	public void setAntInsRenal(String antInsRenal) {
		this.antInsRenal = antInsRenal;
	}
	public String getAntFa() {
		return antFa;
	}
	public void setAntFa(String antFa) {
		this.antFa = antFa;
	}
	public String getAntDiab() {
		return antDiab;
	}
	public void setAntDiab(String antDiab) {
		this.antDiab = antDiab;
	}
	public String getAntHta() {
		return antHta;
	}
	public void setAntHta(String antHta) {
		this.antHta = antHta;
	}
	public String getAnchQRS() {
		return anchQRS;
	}
	public void setAnchQRS(String anchQRS) {
		this.anchQRS = anchQRS;
	}
	public String getAntFum() {
		return antFum;
	}
	public void setAntFum(String antFum) {
		this.antFum = antFum;
	}
	public String getAntDislip() {
		return antDislip;
	}
	public void setAntDislip(String antDislip) {
		this.antDislip = antDislip;
	}
	public String getAntAcv() {
		return antAcv;
	}
	public void setAntAcv(String antAcv) {
		this.antAcv = antAcv;
	}
	public String getArritmiaClinica() {
		return arritmiaClinica;
	}
	public void setArritmiaClinica(String arritmiaClinica) {
		this.arritmiaClinica = arritmiaClinica;
	}
	public String getPresClinica() {
		return presClinica;
	}
	public void setPresClinica(String presClinica) {
		this.presClinica = presClinica;
	}
	public String getPresClinciaOtros() {
		return presClinciaOtros;
	}
	public void setPresClinciaOtros(String presClinciaOtros) {
		this.presClinciaOtros = presClinciaOtros;
	}
	public String getEef() {
		return eef;
	}
	public void setEef(String eef) {
		this.eef = eef;
	}
	public String getPrevencion() {
		return prevencion;
	}
	public void setPrevencion(String prevencion) {
		this.prevencion = prevencion;
	}
	public Date getFechaImpl() {
		return fechaImpl;
	}
	public void setFechaImpl(Date fechaImpl) {
		this.fechaImpl = fechaImpl;
	}
	public String getLugarImpl() {
		return lugarImpl;
	}
	public void setLugarImpl(String lugarImpl) {
		this.lugarImpl = lugarImpl;
	}
	public String getImplantador() {
		return implantador;
	}
	public void setImplantador(String implantador) {
		this.implantador = implantador;
	}
	public String getModeloGen() {
		return modeloGen;
	}
	public void setModeloGen(String modeloGen) {
		this.modeloGen = modeloGen;
	}
	public String getNserieGen() {
		return nserieGen;
	}
	public void setNserieGen(String nserieGen) {
		this.nserieGen = nserieGen;
	}
	public String getLocGen() {
		return locGen;
	}
	public void setLocGen(String locGen) {
		this.locGen = locGen;
	}
	public Boolean getAd() {
		return ad;
	}
	public void setAd(Boolean ad) {
		this.ad = ad;
	}
	public String getModeloAD() {
		return modeloAD;
	}
	public void setModeloAD(String modeloAD) {
		this.modeloAD = modeloAD;
	}
	public String getNserieAD() {
		return nserieAD;
	}
	public void setNserieAD(String nserieAD) {
		this.nserieAD = nserieAD;
	}
	public Boolean getVd() {
		return vd;
	}
	public void setVd(Boolean vd) {
		this.vd = vd;
	}
	public String getModeloVD() {
		return modeloVD;
	}
	public void setModeloVD(String modeloVD) {
		this.modeloVD = modeloVD;
	}
	public String getNserieVD() {
		return nserieVD;
	}
	public void setNserieVD(String nserieVD) {
		this.nserieVD = nserieVD;
	}
	public Boolean getVi() {
		return vi;
	}
	public void setVi(Boolean vi) {
		this.vi = vi;
	}
	public String getModeloVI() {
		return modeloVI;
	}
	public void setModeloVI(String modeloVI) {
		this.modeloVI = modeloVI;
	}
	public String getNserieVI() {
		return nserieVI;
	}
	public void setNserieVI(String nserieVI) {
		this.nserieVI = nserieVI;
	}
	public Date getFechaImplElecPrevios() {
		return fechaImplElecPrevios;
	}
	public void setFechaImplElecPrevios(Date fechaImplElecPrevios) {
		this.fechaImplElecPrevios = fechaImplElecPrevios;
	}
	public String getElecAdiSensado() {
		return elecAdiSensado;
	}
	public void setElecAdiSensado(String elecAdiSensado) {
		this.elecAdiSensado = elecAdiSensado;
	}
	public String getElecAdiDesf() {
		return elecAdiDesf;
	}
	public void setElecAdiDesf(String elecAdiDesf) {
		this.elecAdiDesf = elecAdiDesf;
	}
	public Boolean getElecPrevFunc() {
		return elecPrevFunc;
	}
	public void setElecPrevFunc(Boolean elecPrevFunc) {
		this.elecPrevFunc = elecPrevFunc;
	}
	public Boolean getElecPrevDisf() {
		return elecPrevDisf;
	}
	public void setElecPrevDisf(Boolean elecPrevDisf) {
		this.elecPrevDisf = elecPrevDisf;
	}
	public Boolean getElecPrevDisfAband() {
		return elecPrevDisfAband;
	}
	public void setElecPrevDisfAband(Boolean elecPrevDisfAband) {
		this.elecPrevDisfAband = elecPrevDisfAband;
	}
	public Boolean getElecPrevDisfExpl() {
		return elecPrevDisfExpl;
	}
	public void setElecPrevDisfExpl(Boolean elecPrevDisfExpl) {
		this.elecPrevDisfExpl = elecPrevDisfExpl;
	}
	public Boolean getInduccion() {
		return induccion;
	}
	public void setInduccion(Boolean induccion) {
		this.induccion = induccion;
	}
	public String getInduccionEnergia() {
		return induccionEnergia;
	}
	public void setInduccionEnergia(String induccionEnergia) {
		this.induccionEnergia = induccionEnergia;
	}
	public String getInduccionNumChoques() {
		return induccionNumChoques;
	}
	public void setInduccionNumChoques(String induccionNumChoques) {
		this.induccionNumChoques = induccionNumChoques;
	}
	public String getCompliNinguna() {
		return compliNinguna;
	}
	public void setCompliNinguna(String compliNinguna) {
		this.compliNinguna = compliNinguna;
	}
	public String getCompliMuerte() {
		return compliMuerte;
	}
	public void setCompliMuerte(String compliMuerte) {
		this.compliMuerte = compliMuerte;
	}
	public String getCompliTapCard() {
		return compliTapCard;
	}
	public void setCompliTapCard(String compliTapCard) {
		this.compliTapCard = compliTapCard;
	}
	public String getCompliNeumo() {
		return compliNeumo;
	}
	public void setCompliNeumo(String compliNeumo) {
		this.compliNeumo = compliNeumo;
	}
	public String getCompliDiseccionSC() {
		return compliDiseccionSC;
	}
	public void setCompliDiseccionSC(String compliDiseccionSC) {
		this.compliDiseccionSC = compliDiseccionSC;
	}
	public String getCompliOtro() {
		return compliOtro;
	}
	public void setCompliOtro(String compliOtro) {
		this.compliOtro = compliOtro;
	}
	public String getCompliSitSubOptima() {
		return compliSitSubOptima;
	}
	public void setCompliSitSubOptima(String compliSitSubOptima) {
		this.compliSitSubOptima = compliSitSubOptima;
	}
	public String getEstimAntiBradi() {
		return estimAntiBradi;
	}
	public void setEstimAntiBradi(String estimAntiBradi) {
		this.estimAntiBradi = estimAntiBradi;
	}
	public String getMev() {
		return mev;
	}
	public void setMev(String mev) {
		this.mev = mev;
	}
	public String getAtpProg() {
		return atpProg;
	}
	public void setAtpProg(String atpProg) {
		this.atpProg = atpProg;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getAntMuerteSub() {
		return antMuerteSub;
	}
	public void setAntMuerteSub(String antMuerteSub) {
		this.antMuerteSub = antMuerteSub;
	}
	public String getEefArritmia() {
		return eefArritmia;
	}
	public void setEefArritmia(String eefArritmia) {
		this.eefArritmia = eefArritmia;
	}
	public String getTipoProc() {
		return tipoProc;
	}
	public void setTipoProc(String tipoProc) {
		this.tipoProc = tipoProc;
	}
	public Date getFechaImplPrev() {
		return fechaImplPrev;
	}
	public void setFechaImplPrev(Date fechaImplPrev) {
		this.fechaImplPrev = fechaImplPrev;
	}
	public String getMotivosRecambioAgot() {
		return motivosRecambioAgot;
	}
	public void setMotivosRecambioAgot(String motivosRecambioAgot) {
		this.motivosRecambioAgot = motivosRecambioAgot;
	}
	public String getMotivosRecambioCompl() {
		return motivosRecambioCompl;
	}
	public void setMotivosRecambioCompl(String motivosRecambioCompl) {
		this.motivosRecambioCompl = motivosRecambioCompl;
	}
	public String getMotivosRecambioUpgrade() {
		return motivosRecambioUpgrade;
	}
	public void setMotivosRecambioUpgrade(String motivosRecambioUpgrade) {
		this.motivosRecambioUpgrade = motivosRecambioUpgrade;
	}
	public String getEpiTVFV() {
		return epiTVFV;
	}
	public void setEpiTVFV(String epiTVFV) {
		this.epiTVFV = epiTVFV;
	}
	public String getTerapiaATP() {
		return terapiaATP;
	}
	public void setTerapiaATP(String terapiaATP) {
		this.terapiaATP = terapiaATP;
	}
	public String getTerapiaChoques() {
		return terapiaChoques;
	}
	public void setTerapiaChoques(String terapiaChoques) {
		this.terapiaChoques = terapiaChoques;
	}
	
}

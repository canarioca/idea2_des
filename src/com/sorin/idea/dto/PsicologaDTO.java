package com.sorin.idea.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;


public class PsicologaDTO implements Serializable{

	private static final long serialVersionUID = -709174698384493371L;
	
	protected Date fechaPsicologa;
	protected String profesion;
	protected Boolean antecedentesPsiquiatricosPersonales;
	protected String antecedentesPsiquiatricosPersonalesDiagnostico;
	protected Boolean antecedentesPsiquiatricosFamiliares;
	protected String antecedentesPsiquiatricosFamiliaresDiagnostico;
	protected String antecedentesPsiquiatricosFamiliaresGrado;
	protected Integer apoyoSocial;
	protected Integer numHijos;
	protected String depresionDBI;
	protected String ansiedadSTAI;
	protected String ansiedadAE;
	protected String ansiedadAR;
	protected String afrontamientoFSP;
	protected String afrontamientoAFN;
	protected String afrontamientoREP;
	protected String afrontamientoEEA;
	protected String afrontamientoEVI;
	protected String afrontamientoBAS;
	protected String afrontamientoRLG;
	
	public List<String> selectedCalidadSueno;
	public List<SelectItem> selectItemCalidadSueno;
	
	public String selectedEstadoCivil;
	public List<SelectItem> selectItemEstadoCivil;
	
	public String selectedNivelEstudios;
	public List<SelectItem> selectItemNivelEstudios;
	
	public String selectedSituacionLaboral;
	public List<SelectItem> selectItemSituacionLaboral;
	
	public String selectedSituacionEconomica;
	public List<SelectItem> selectItemSituacionEconomica;
	
	public String selectedApoyoSocial;
	public List<SelectItem> selectItemApoyoSocial;
	
	public String selectedFamilia;
	public List<SelectItem> selectItemFamilia;
	
	public String selectedNivelIrritabilidad;
	public List<SelectItem> selectItemNivelIrritabilidad;
	
	public String selectedNivelSatisfaccion;
	public List<SelectItem> selectItemNivelSatisfaccion;
	
	public String selectedVidaSexual;
	public List<SelectItem> selectItemVidaSexual;
	
	public Date getFechaPsicologa() {
		return fechaPsicologa;
	}
	public void setFechaPsicologa(Date fechaPsicologa) {
		this.fechaPsicologa = fechaPsicologa;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public Boolean getAntecedentesPsiquiatricosPersonales() {
		return antecedentesPsiquiatricosPersonales;
	}
	public void setAntecedentesPsiquiatricosPersonales(Boolean antecedentesPsiquiatricosPersonales) {
		this.antecedentesPsiquiatricosPersonales = antecedentesPsiquiatricosPersonales;
	}
	public String getAntecedentesPsiquiatricosPersonalesDiagnostico() {
		return antecedentesPsiquiatricosPersonalesDiagnostico;
	}
	public void setAntecedentesPsiquiatricosPersonalesDiagnostico(String antecedentesPsiquiatricosPersonalesDiagnostico) {
		this.antecedentesPsiquiatricosPersonalesDiagnostico = antecedentesPsiquiatricosPersonalesDiagnostico;
	}
	public Boolean getAntecedentesPsiquiatricosFamiliares() {
		return antecedentesPsiquiatricosFamiliares;
	}
	public void setAntecedentesPsiquiatricosFamiliares(Boolean antecedentesPsiquiatricosFamiliares) {
		this.antecedentesPsiquiatricosFamiliares = antecedentesPsiquiatricosFamiliares;
	}
	public String getAntecedentesPsiquiatricosFamiliaresDiagnostico() {
		return antecedentesPsiquiatricosFamiliaresDiagnostico;
	}
	public void setAntecedentesPsiquiatricosFamiliaresDiagnostico(String antecedentesPsiquiatricosFamiliaresDiagnostico) {
		this.antecedentesPsiquiatricosFamiliaresDiagnostico = antecedentesPsiquiatricosFamiliaresDiagnostico;
	}
	public String getAntecedentesPsiquiatricosFamiliaresGrado() {
		return antecedentesPsiquiatricosFamiliaresGrado;
	}
	public void setAntecedentesPsiquiatricosFamiliaresGrado(String antecedentesPsiquiatricosFamiliaresGrado) {
		this.antecedentesPsiquiatricosFamiliaresGrado = antecedentesPsiquiatricosFamiliaresGrado;
	}
	public Integer getApoyoSocial() {
		return apoyoSocial;
	}
	public void setApoyoSocial(Integer apoyoSocial) {
		this.apoyoSocial = apoyoSocial;
	}
	public Integer getNumHijos() {
		return numHijos;
	}
	public void setNumHijos(Integer numHijos) {
		this.numHijos = numHijos;
	}
	public String getDepresionDBI() {
		return depresionDBI;
	}
	public void setDepresionDBI(String depresionDBI) {
		this.depresionDBI = depresionDBI;
	}
	public String getAnsiedadSTAI() {
		return ansiedadSTAI;
	}
	public void setAnsiedadSTAI(String ansiedadSTAI) {
		this.ansiedadSTAI = ansiedadSTAI;
	}
	public String getAnsiedadAE() {
		return ansiedadAE;
	}
	public void setAnsiedadAE(String ansiedadAE) {
		this.ansiedadAE = ansiedadAE;
	}
	public String getAnsiedadAR() {
		return ansiedadAR;
	}
	public void setAnsiedadAR(String ansiedadAR) {
		this.ansiedadAR = ansiedadAR;
	}
	public String getAfrontamientoFSP() {
		return afrontamientoFSP;
	}
	public void setAfrontamientoFSP(String afrontamientoFSP) {
		this.afrontamientoFSP = afrontamientoFSP;
	}
	public String getAfrontamientoAFN() {
		return afrontamientoAFN;
	}
	public void setAfrontamientoAFN(String afrontamientoAFN) {
		this.afrontamientoAFN = afrontamientoAFN;
	}
	public String getAfrontamientoREP() {
		return afrontamientoREP;
	}
	public void setAfrontamientoREP(String afrontamientoREP) {
		this.afrontamientoREP = afrontamientoREP;
	}
	public String getAfrontamientoEEA() {
		return afrontamientoEEA;
	}
	public void setAfrontamientoEEA(String afrontamientoEEA) {
		this.afrontamientoEEA = afrontamientoEEA;
	}
	public String getAfrontamientoEVI() {
		return afrontamientoEVI;
	}
	public void setAfrontamientoEVI(String afrontamientoEVI) {
		this.afrontamientoEVI = afrontamientoEVI;
	}
	public String getAfrontamientoBAS() {
		return afrontamientoBAS;
	}
	public void setAfrontamientoBAS(String afrontamientoBAS) {
		this.afrontamientoBAS = afrontamientoBAS;
	}
	public String getAfrontamientoRLG() {
		return afrontamientoRLG;
	}
	public void setAfrontamientoRLG(String afrontamientoRLG) {
		this.afrontamientoRLG = afrontamientoRLG;
	}
	public List<String> getSelectedCalidadSueno() {
		return selectedCalidadSueno;
	}
	public void setSelectedCalidadSueno(List<String> selectedCalidadSueno) {
		this.selectedCalidadSueno = selectedCalidadSueno;
	}
	public List<SelectItem> getSelectItemCalidadSueno() {
		return selectItemCalidadSueno;
	}
	public void setSelectItemCalidadSueno(List<SelectItem> selectItemCalidadSueno) {
		this.selectItemCalidadSueno = selectItemCalidadSueno;
	}
	public String getSelectedEstadoCivil() {
		return selectedEstadoCivil;
	}
	public void setSelectedEstadoCivil(String selectedEstadoCivil) {
		this.selectedEstadoCivil = selectedEstadoCivil;
	}
	public List<SelectItem> getSelectItemEstadoCivil() {
		return selectItemEstadoCivil;
	}
	public void setSelectItemEstadoCivil(List<SelectItem> selectItemEstadoCivil) {
		this.selectItemEstadoCivil = selectItemEstadoCivil;
	}
	public String getSelectedNivelEstudios() {
		return selectedNivelEstudios;
	}
	public void setSelectedNivelEstudios(String selectedNivelEstudios) {
		this.selectedNivelEstudios = selectedNivelEstudios;
	}
	public List<SelectItem> getSelectItemNivelEstudios() {
		return selectItemNivelEstudios;
	}
	public void setSelectItemNivelEstudios(List<SelectItem> selectItemNivelEstudios) {
		this.selectItemNivelEstudios = selectItemNivelEstudios;
	}
	public String getSelectedSituacionLaboral() {
		return selectedSituacionLaboral;
	}
	public void setSelectedSituacionLaboral(String selectedSituacionLaboral) {
		this.selectedSituacionLaboral = selectedSituacionLaboral;
	}
	public List<SelectItem> getSelectItemSituacionLaboral() {
		return selectItemSituacionLaboral;
	}
	public void setSelectItemSituacionLaboral(List<SelectItem> selectItemSituacionLaboral) {
		this.selectItemSituacionLaboral = selectItemSituacionLaboral;
	}
	public String getSelectedSituacionEconomica() {
		return selectedSituacionEconomica;
	}
	public void setSelectedSituacionEconomica(String selectedSituacionEconomica) {
		this.selectedSituacionEconomica = selectedSituacionEconomica;
	}
	public List<SelectItem> getSelectItemSituacionEconomica() {
		return selectItemSituacionEconomica;
	}
	public void setSelectItemSituacionEconomica(List<SelectItem> selectItemSituacionEconomica) {
		this.selectItemSituacionEconomica = selectItemSituacionEconomica;
	}
	public String getSelectedApoyoSocial() {
		return selectedApoyoSocial;
	}
	public void setSelectedApoyoSocial(String selectedApoyoSocial) {
		this.selectedApoyoSocial = selectedApoyoSocial;
	}
	public List<SelectItem> getSelectItemApoyoSocial() {
		return selectItemApoyoSocial;
	}
	public void setSelectItemApoyoSocial(List<SelectItem> selectItemApoyoSocial) {
		this.selectItemApoyoSocial = selectItemApoyoSocial;
	}
	public String getSelectedFamilia() {
		return selectedFamilia;
	}
	public void setSelectedFamilia(String selectedFamilia) {
		this.selectedFamilia = selectedFamilia;
	}
	public List<SelectItem> getSelectItemFamilia() {
		return selectItemFamilia;
	}
	public void setSelectItemFamilia(List<SelectItem> selectItemFamilia) {
		this.selectItemFamilia = selectItemFamilia;
	}
	public String getSelectedNivelIrritabilidad() {
		return selectedNivelIrritabilidad;
	}
	public void setSelectedNivelIrritabilidad(String selectedNivelIrritabilidad) {
		this.selectedNivelIrritabilidad = selectedNivelIrritabilidad;
	}
	public List<SelectItem> getSelectItemNivelIrritabilidad() {
		return selectItemNivelIrritabilidad;
	}
	public void setSelectItemNivelIrritabilidad(List<SelectItem> selectItemNivelIrritabilidad) {
		this.selectItemNivelIrritabilidad = selectItemNivelIrritabilidad;
	}
	public String getSelectedNivelSatisfaccion() {
		return selectedNivelSatisfaccion;
	}
	public void setSelectedNivelSatisfaccion(String selectedNivelSatisfaccion) {
		this.selectedNivelSatisfaccion = selectedNivelSatisfaccion;
	}
	public List<SelectItem> getSelectItemNivelSatisfaccion() {
		return selectItemNivelSatisfaccion;
	}
	public void setSelectItemNivelSatisfaccion(List<SelectItem> selectItemNivelSatisfaccion) {
		this.selectItemNivelSatisfaccion = selectItemNivelSatisfaccion;
	}
	public String getSelectedVidaSexual() {
		return selectedVidaSexual;
	}
	public void setSelectedVidaSexual(String selectedVidaSexual) {
		this.selectedVidaSexual = selectedVidaSexual;
	}
	public List<SelectItem> getSelectItemVidaSexual() {
		return selectItemVidaSexual;
	}
	public void setSelectItemVidaSexual(List<SelectItem> selectItemVidaSexual) {
		this.selectItemVidaSexual = selectItemVidaSexual;
	}
	
}

package com.sorin.idea.dto;

import java.util.Date;

import hvn.cm.modelo.dto.BaseDto;

public class ArrAnual extends BaseDto{

	ArrAnualCentro centro;
	ArrAnualLab lab;
	ArrAnualTecnicas tec;
	Integer anio;
	ArrAnualSubstratos tin;
	ArrAnualSubstratos vacc;
	ArrAnualSubstratos cav;
	ArrAnualSubstratos taf;
	ArrAnualSubstratos ict;
	ArrAnualSubstratos fta;
	ArrAnualSubstratos fa;
	ArrAnualSubstratos tvi;
	ArrAnualSubstratos tviam;
	ArrAnualSubstratos tvnoiam;
	
	public final static int FIBRILACION_AURICULAR = 1;
	public final static int FLUTER_AURICULAR = 2;
	public final static int NODO_AV = 3;
	public final static int TA_FOCAL = 4;
	public final static int TIN = 5;
	public final static int TV_IAM = 6;
	public final static int TV_NOIAM = 7;
	public final static int TV_FOCAL = 8;
	public final static int VIA_ACCESORIA = 9;
	public final static int FLUTER_AURICULAR_ICT = 10;
	
	public ArrAnual() {
		this.anio = new Date().getYear()+1900;
		centro = new ArrAnualCentro(this.anio);
		lab = new ArrAnualLab(this.anio);
		tec = new ArrAnualTecnicas(this.anio);
	}

	public ArrAnual(Integer anio2) {
		this.anio = anio2;
		centro = new ArrAnualCentro(this.anio);
		lab = new ArrAnualLab(this.anio);
		tec = new ArrAnualTecnicas(this.anio);
	}

	public ArrAnualCentro getCentro() {
		return centro;
	}

	public void setCentro(ArrAnualCentro centro) {
		this.centro = centro;
		if(centro == null)
			this.centro = new ArrAnualCentro();
	}

	public ArrAnualLab getLab() {
		return lab;
	}

	public void setLab(ArrAnualLab lab) {
		this.lab = lab;
		if(lab == null)
			this.lab = new ArrAnualLab();
	}

	public ArrAnualTecnicas getTec() {
		return tec;
	}

	public void setTec(ArrAnualTecnicas tec) {
		this.tec = tec;
		if(tec == null)
			this.tec = new ArrAnualTecnicas();
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
		this.centro.setAnio(anio);
		this.lab.setAnio(anio);
		this.tec.setAnio(anio);
	}

	public ArrAnualSubstratos getTin() {
		return tin;
	}

	public void setTin(ArrAnualSubstratos tin) {
		this.tin = tin;
	}

	public ArrAnualSubstratos getVacc() {
		return vacc;
	}

	public void setVacc(ArrAnualSubstratos vacc) {
		this.vacc = vacc;
	}

	public ArrAnualSubstratos getCav() {
		return cav;
	}

	public void setCav(ArrAnualSubstratos cav) {
		this.cav = cav;
	}

	public ArrAnualSubstratos getTaf() {
		return taf;
	}

	public void setTaf(ArrAnualSubstratos taf) {
		this.taf = taf;
	}

	public ArrAnualSubstratos getIct() {
		return ict;
	}

	public void setIct(ArrAnualSubstratos ict) {
		this.ict = ict;
	}

	public ArrAnualSubstratos getFta() {
		return fta;
	}

	public void setFta(ArrAnualSubstratos fta) {
		this.fta = fta;
	}

	public ArrAnualSubstratos getFa() {
		return fa;
	}

	public void setFa(ArrAnualSubstratos fa) {
		this.fa = fa;
	}

	public ArrAnualSubstratos getTvi() {
		return tvi;
	}

	public void setTvi(ArrAnualSubstratos tvi) {
		this.tvi = tvi;
	}

	public ArrAnualSubstratos getTviam() {
		return tviam;
	}

	public void setTviam(ArrAnualSubstratos tviam) {
		this.tviam = tviam;
	}

	public ArrAnualSubstratos getTvnoiam() {
		return tvnoiam;
	}

	public void setTvnoiam(ArrAnualSubstratos tvnoiam) {
		this.tvnoiam = tvnoiam;
	}
	
	
}

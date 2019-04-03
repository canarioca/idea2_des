package com.sorin.idea.util;

import java.util.ArrayList;

import org.apache.myfaces.component.html.ext.HtmlDataTable;

import com.sorin.idea.dto.ArrEstudioCatApl;

public class AbordajeAblaciones {

	private Integer idvia;
	private ArrayList<ArrEstudioCatApl> listacats;
	//private HtmlDataTable bindingCats;
	
	public AbordajeAblaciones(){
		this.idvia = 0;
		this.listacats = new ArrayList<ArrEstudioCatApl>();
	}
	public AbordajeAblaciones(Integer id){
		this.setIdvia(id);
		this.listacats = new ArrayList<ArrEstudioCatApl>();
	}
	public AbordajeAblaciones(Integer idvia,ArrayList<ArrEstudioCatApl> lista ){
		this.setIdvia(idvia);
		this.setListacats(lista);
	}

	public Integer getIdvia() {
		return idvia;
	}

	public void setIdvia(Integer idvia) {
		this.idvia = idvia;
	}

	public ArrayList<ArrEstudioCatApl> getListacats() {
		return listacats;
	}

	public void setListacats(ArrayList<ArrEstudioCatApl> listacats) {
		this.listacats = listacats;
	}
	/*public HtmlDataTable getBindingCats() {
		return bindingCats;
	}
	public void setBindingCats(HtmlDataTable bindingCats) {
		this.bindingCats = bindingCats;
	}*/
	
}

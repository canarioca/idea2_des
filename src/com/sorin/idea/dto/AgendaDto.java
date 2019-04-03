package com.sorin.idea.dto;

import java.util.ArrayList;
import java.util.Date;

import org.apache.myfaces.custom.schedule.HtmlSchedule;
import org.apache.myfaces.custom.schedule.model.DefaultScheduleEntry;
import org.apache.myfaces.custom.schedule.model.ScheduleModel;
import org.apache.myfaces.custom.schedule.model.SimpleScheduleModel;

public class AgendaDto {

	private ArrAcceso user;
	private boolean comparar;
	ArrayList<Evento> eventos; //alta lista de eventos
	private ScheduleModel model;
	private HtmlSchedule schedule;	
	private ArrayList<DefaultScheduleEntry> evdiarios;
	
	
	public AgendaDto(){
		this.model = new SimpleScheduleModel();
		this.model.setMode(ScheduleModel.WORKWEEK);
		this.model.setSelectedDate(new Date());
		this.schedule = new HtmlSchedule();
		this.schedule.setVisibleStartHour(7);
		this.schedule.setWorkingStartHour(8);
		this.schedule.setWorkingEndHour(17);
		this.schedule.setVisibleEndHour(18);
		this.setEvdiarios(new ArrayList<DefaultScheduleEntry>());
		this.comparar = false;
		this.eventos = new ArrayList<Evento>();
	}
	public AgendaDto(ArrAcceso u){
		this.model = new SimpleScheduleModel();
		this.model.setMode(ScheduleModel.WORKWEEK);
		this.model.setSelectedDate(new Date());
		this.schedule = new HtmlSchedule();
		this.schedule.setVisibleStartHour(7);
		this.schedule.setWorkingStartHour(8);
		this.schedule.setWorkingEndHour(17);
		this.schedule.setVisibleEndHour(18);
		this.setEvdiarios(new ArrayList<DefaultScheduleEntry>());
		this.comparar = false;
		this.user = u;
		this.eventos = new ArrayList<Evento>();
	}
	
	public ArrAcceso getUser() {
		return user;
	}
	public void setUser(ArrAcceso user) {
		this.user = user;
	}
	public boolean isComparar() {
		return comparar;
	}
	public void setComparar(boolean comparar) {
		this.comparar = comparar;
	}

	public ScheduleModel getModel() {
		return model;
	}

	public void setModel(ScheduleModel model) {
		this.model = model;
	}

	public HtmlSchedule getSchedule() {
		return schedule;
	}

	public void setSchedule(HtmlSchedule schedule) {
		this.schedule = schedule;
	}

	public ArrayList<DefaultScheduleEntry> getEvdiarios() {
		return evdiarios;
	}

	public void setEvdiarios(ArrayList<DefaultScheduleEntry> evdiarios) {
		this.evdiarios = evdiarios;
	}
	public ArrayList<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(ArrayList<Evento> eventos) {
		this.eventos = eventos;
	}
	
	
	
}

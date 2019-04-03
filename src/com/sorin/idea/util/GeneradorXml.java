package com.sorin.idea.util;


import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sorin.idea.dto.Agenda;
import com.sorin.idea.dto.ArrAcceso;
import com.sorin.idea.dto.ArrAnual;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrDatosMes;
import com.sorin.idea.dto.ArrDesfibrilador;
import com.sorin.idea.dto.ArrEnf;
import com.sorin.idea.dto.ArrEstudio;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrMesas;
import com.sorin.idea.dto.ArrRegistrador;
import com.sorin.idea.dto.ArrTestAtp;
import com.sorin.idea.dto.ArrTestEpi;
import com.sorin.idea.dto.ArrTestFle;
import com.sorin.idea.dto.AuditoriaDto;
import com.sorin.idea.dto.ComplicacionesPacientes;
import com.sorin.idea.dto.Evento;
import com.sorin.idea.dto.GenericosDto;
import com.sorin.idea.dto.Holter;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpEvolucionComplicacion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.ImpHojaImplanteComplicacion;
import com.sorin.idea.dto.ImpHojaImplantePop;
import com.sorin.idea.dto.ImpImplante;
import com.sorin.idea.dto.ImpImplanteElectrodos;
import com.sorin.idea.dto.ImpIndicacion;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.ProtSincope;
import com.sorin.idea.dto.Protocolos;
import com.sorin.idea.dto.RegistradorEventosExt;
import com.sorin.idea.dto.SegClinComplicaciones;
import com.sorin.idea.dto.SegObservacionesDai;
import com.sorin.idea.dto.SegObservacionesMp;
import com.sorin.idea.dto.SegPorestimulacion;
import com.sorin.idea.dto.SegSeguimiento;
import com.sorin.idea.dto.SegSeguimientoClinico;
import com.sorin.idea.dto.SegSeguimientoRegEventos;
import com.sorin.idea.dto.SegSistema;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.dto.TestOrtostatismoActivo;
import com.sorin.idea.reportes.ReporteATP;
import com.sorin.idea.reportes.ReporteAnual;
import com.sorin.idea.reportes.ReporteAuditoria;
import com.sorin.idea.reportes.ReporteCV;
import com.sorin.idea.reportes.ReporteDAI;
import com.sorin.idea.reportes.ReporteEEF;
import com.sorin.idea.reportes.ReporteENF;
import com.sorin.idea.reportes.ReporteEPI;
import com.sorin.idea.reportes.ReporteEventos;
import com.sorin.idea.reportes.ReporteFLE;
import com.sorin.idea.reportes.ReporteHolter;
import com.sorin.idea.reportes.ReporteImplante;
import com.sorin.idea.reportes.ReporteMP;
import com.sorin.idea.reportes.ReporteMesa;
import com.sorin.idea.reportes.ReportePacienteConsentimiento;
import com.sorin.idea.reportes.ReportePacienteConsentimientoRecambio;
import com.sorin.idea.reportes.ReportePacienteProcedimientos;
import com.sorin.idea.reportes.ReportePacienteResumenHC;
import com.sorin.idea.reportes.ReporteProtocoloSincope;
import com.sorin.idea.reportes.ReporteRegEvExt;
import com.sorin.idea.reportes.ReporteRegistrador;
import com.sorin.idea.reportes.ReporteRegistroDAI;
import com.sorin.idea.reportes.ReporteResumenMes;
import com.sorin.idea.reportes.ReporteSeguimiento;
import com.sorin.idea.reportes.ReporteSeguimientoClinico;
import com.sorin.idea.reportes.ReporteSeguimientoRegEv;
import com.sorin.idea.reportes.ReporteSuministro;
import com.sorin.idea.reportes.ReporteTarjetaEuropea;
import com.sorin.idea.reportes.ReporteTestOrto;

public class GeneradorXml {

	public String pathFichero;

	public GeneradorXml(FacesContext contexto) {
		HttpServletRequest req = (HttpServletRequest) contexto
				.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) contexto
				.getExternalContext().getResponse();
		String sesionID = req.getRequestedSessionId();
		this.pathFichero = req.getRealPath("/reportes/PED_" + sesionID
				+ ".xml");
	}

	public String imprimeInformeAuditoria(String usuario,
			ArrayList<AuditoriaDto> auditorias) {
		ReporteAuditoria reporte = new ReporteAuditoria(pathFichero, usuario,
				auditorias);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}

	public String imprimeInformeDAI(ArrDesfibrilador desf,
			PacienteAplDto pacienteSelect, ArrayList<GenericosDto> hospitales) {
		ReporteDAI reporte = new ReporteDAI(pathFichero, desf,
				pacienteSelect, hospitales);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}

	public String imprimeInformeCV(ArrCardioversion car,
			PacienteAplDto pacienteSelect,InfoCentro infocentro,SituacionClinicaProc sitclin,ResourceBundle bundle, ArrayList<ComplicacionesPacientes> listacomp) {
		ReporteCV reporte = new ReporteCV(pathFichero, car,
				pacienteSelect,infocentro,sitclin,bundle, listacomp);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	public String imprimeInformeMesa(ArrMesas mesa,
			PacienteAplDto pacienteSelect, Integer puntuacion, InfoCentro infocentro, ResourceBundle bundle) throws Exception {
		ReporteMesa reporte = new ReporteMesa(pathFichero, mesa,
				pacienteSelect, puntuacion, infocentro,bundle);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	public String imprimeInformeRegistrador(ArrRegistrador registrador,
			PacienteAplDto pacienteSelect, Integer puntuacion, InfoCentro infocentro, ResourceBundle bundle) throws Exception {
		ReporteRegistrador reporte = new ReporteRegistrador(pathFichero, registrador,
				pacienteSelect, puntuacion,infocentro, bundle);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	public String imprimeATP(ArrTestAtp atp,
			PacienteAplDto pacienteSelect, InfoCentro infocentro, ResourceBundle bundle) {
		ReporteATP reporte = new ReporteATP(pathFichero, atp,
				pacienteSelect,infocentro, bundle);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	public String imprimeEPI(ArrTestEpi epi,
			PacienteAplDto pacienteSelect, InfoCentro infocentro, ResourceBundle bundle) {
		ReporteEPI reporte = new ReporteEPI(pathFichero, epi,pacienteSelect,infocentro, bundle);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	public String imprimeFLE(ArrTestFle fle,
			PacienteAplDto pacienteSelect, InfoCentro infocentro, ResourceBundle bundle) {
		ReporteFLE reporte = new ReporteFLE(pathFichero, fle,
				pacienteSelect,infocentro, bundle);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	public String imprimeENF(ArrEnf enf,
			PacienteAplDto pacienteSelect, String diagnostico, ResourceBundle bundle) {
		ReporteENF reporte = new ReporteENF(pathFichero, enf,
				pacienteSelect, diagnostico, bundle);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	public String imprimeResumenMes(ArrDatosMes mes, String nombremes) {
		ReporteResumenMes reporte = new ReporteResumenMes(pathFichero, mes, nombremes);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	public String imprimeAblacionAnual(ArrAnual anual, ResourceBundle bundle) {
		ReporteAnual reporte = new ReporteAnual(pathFichero, anual, bundle);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	public String imprimeInformeEEF(ArrEstudio eef,
			PacienteAplDto pacienteSelect, InfoCentro infocentro,
			SituacionClinicaProc sitclin,ArrEnf enf, ResourceBundle bundle) {
		ReporteEEF reporte = new ReporteEEF(pathFichero, eef,
				pacienteSelect,infocentro,sitclin,enf,bundle);

		reporte.GeneraArchivoPlanilla();

		return pathFichero;
	}
	
	/**
	 * FRR
	 */
	public String imprimeInformeMP(TarjetaMP tr, PacienteAplDto pacienteSelect) {
		ReporteMP reporte = new ReporteMP(pathFichero,pacienteSelect,tr);
		reporte.GeneraArchivoPlanilla2();
		return pathFichero;
	}
	/**
	 * 
	 */
	public String imprimeInformeTarjetaEuropea(TarjetaMP tr, PacienteAplDto pacienteSelect){
		ReporteTarjetaEuropea reporte = new ReporteTarjetaEuropea(pathFichero,pacienteSelect,tr);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeRegistroDAI(ImpHojaImplante imp,SituacionClinicaProc ind,ImpEvolucion hev,UtilReporteRegistroDAI util
			, PacienteAplDto pacienteSelect,InfoCentro centro, ArrayList<ComplicacionesPacientes> comp){
		ReporteRegistroDAI reporte = new ReporteRegistroDAI(pathFichero,pacienteSelect,imp,ind,hev,util,centro,comp);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeImplante(ImpImplante imp,SituacionClinicaProc ind,ImpHojaImplante himp,ImpEvolucion hev,PacienteAplDto pacienteSelect,UtilReporteInformes r,InfoCentro c,ArrayList<ImpImplanteElectrodos> els,
			ArrayList<ImpHojaImplanteComplicacion> compintra, ArrayList<ImpEvolucionComplicacion> comppost,ResourceBundle bundle){
		ReporteImplante reporte = new ReporteImplante(pathFichero,pacienteSelect,imp,ind,himp,hev,r,c,els,compintra,comppost,bundle);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeSeguimiento(SegSeguimiento seg,SituacionClinicaProc sitclin,ImpEvolucion hev,SegSistema st,PacienteAplDto pacienteSelect,UtilReporteInformes r,InfoCentro c,ArrayList<ImpImplanteElectrodos> els
			,SegObservacionesMp obsmp,SegObservacionesDai obsdai,SegPorestimulacion por,ResourceBundle bundle){
		ReporteSeguimiento reporte = new ReporteSeguimiento(pathFichero,pacienteSelect,seg,sitclin,hev,st,r,c,els,obsmp,obsdai,por,bundle);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	
	public String imprimeInformeResumenProcedimientosPaciente(PacienteAplDto pacienteSelect, ArrayList<ProcedimientosClinicos> listapr, ResourceBundle bundle){
		ReportePacienteProcedimientos reporte = new ReportePacienteProcedimientos(pathFichero,pacienteSelect,listapr,bundle);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeConsentimiento(PacienteAplDto pacienteSelect, InfoCentro infocentro,ConsentimientoBean cons, ResourceBundle bundle){
		ReportePacienteConsentimiento reporte = new ReportePacienteConsentimiento(pathFichero,pacienteSelect,infocentro,cons,bundle);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeConsentimientoImpREC(PacienteAplDto pacienteSelect, InfoCentro infocentro,ConsentimientoBean cons, ResourceBundle bundle){
		ReportePacienteConsentimientoRecambio reporte = new ReportePacienteConsentimientoRecambio(pathFichero,pacienteSelect,infocentro,cons,bundle);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeResumenHC(PacienteAplDto pacienteSelect, ResourceBundle bundle){
		ReportePacienteResumenHC reporte = new ReportePacienteResumenHC(pathFichero,pacienteSelect,bundle);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeEventos(Evento[] eventos, Agenda agenda, ArrAcceso usuario, String tipo,String dia, String semana, String mes, ResourceBundle bundle){
		ReporteEventos reporte = new ReporteEventos(pathFichero,eventos,agenda,usuario,tipo,dia,semana,mes,bundle);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeSuministro(PacienteAplDto pacienteSelect,
			ArrayList<ImpGenerador> listagenerador, 
			ArrayList<ImpImplanteElectrodos> listaelectrodos,
			ArrayList<ImpHojaImplantePop> poperador, Procedimiento proc,ImpEvolucion hev,ImpHojaImplante himp,SituacionClinicaProc hind,UtilReporteInformes rep) {
		ReporteSuministro reporte = new ReporteSuministro(pathFichero,pacienteSelect,listagenerador,listaelectrodos,poperador,proc,hev,himp,hind,rep);
		reporte.GeneraArchivoPlantilla();
		return pathFichero;
	}
	public String imprimeInformePreconsulta(PacienteAplDto pacienteSelect,ArrayList<PreconsultaBean> lista,String modelogen, String nsgen, Date fechaimp) {
		System.out.println(modelogen);
		return null;
	}
	public String imprimeInformeSeguimientoClinico(PacienteAplDto pacienteSelect,SituacionClinicaProc sitclin,SegSeguimientoClinico seg,
			ArrayList<SegClinComplicaciones> comps, ResourceBundle bundle){
		ReporteSeguimientoClinico reporte = new ReporteSeguimientoClinico(pathFichero,pacienteSelect,sitclin,seg,comps,bundle);
		reporte.GeneraArchivoPlantilla();
		return pathFichero;
	}
	public String imprimeInformeSeguimientoRegEventos(PacienteAplDto pacienteSelect,SituacionClinicaProc sitclin,SegSeguimientoRegEventos seg,ResourceBundle bundle){
		ReporteSeguimientoRegEv reporte = new ReporteSeguimientoRegEv(pathFichero,pacienteSelect,sitclin,seg,bundle);
		reporte.GeneraArchivoPlantilla();
		return pathFichero;
	}
	public String imprimeInformeHolter(PacienteAplDto pacienteSelect, SituacionClinicaProc sitclin, Holter holter, InfoCentro c, ResourceBundle bundle){
		ReporteHolter reporte = new ReporteHolter(pathFichero,holter,pacienteSelect,c,sitclin,bundle);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeRegExExt(PacienteAplDto pacienteSelect, SituacionClinicaProc sitclin, RegistradorEventosExt regevext, InfoCentro c, ResourceBundle bundle){
		ReporteRegEvExt reporte = new ReporteRegEvExt(pathFichero,regevext,pacienteSelect,c,sitclin,bundle);
		reporte.GeneraArchivoPlanilla();
		return pathFichero;
	}
	public String imprimeInformeTestOrto(PacienteAplDto pacienteSelect, TestOrtostatismoActivo test, ResourceBundle bundle){
		ReporteTestOrto reporte = new ReporteTestOrto(pathFichero,pacienteSelect,test,bundle);
		reporte.GeneraArchivoPlantilla();
		return pathFichero;
	}
	public String imprimeInformeProtocoloSincope(PacienteAplDto pacienteSelect, Protocolos protocolo, ProtSincope sincope, ResourceBundle bundle){
		ReporteProtocoloSincope reporte = new ReporteProtocoloSincope(pathFichero,pacienteSelect,protocolo,sincope,bundle);
		reporte.GeneraArchivoPlantilla();
		return pathFichero;
	}
}
package com.sorin.idea.iu;


import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import com.sorin.idea.dao.ArrEstudioDao;
import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dao.ImpImplanteDao;
import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrDesfibrilador;
import com.sorin.idea.dto.ArrEstudioIntento;
import com.sorin.idea.dto.ArrMaestras;
import com.sorin.idea.dto.ArrMesas;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.ArrRegistrador;
import com.sorin.idea.dto.Cateter;
import com.sorin.idea.dto.Codigosgs128;
import com.sorin.idea.dto.DatoEstAnual;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.EstadisticaDto;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.RecallDto;
import com.sorin.idea.dto.Registradoreventos;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.exceptions.ArrEstudioDaoException;
import com.sorin.idea.exceptions.ArrMaestrasDaoException;
import com.sorin.idea.exceptions.ImpImplanteDaoException;
import com.sorin.idea.jdbc.ArrEstudioDaoImpl;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.jdbc.ImpImplanteDaoImpl;
import com.sorin.idea.util.EstadisticasImplanteBean;
import com.sorin.idea.util.RegistroDaiDto;
import com.sorin.idea.util.UtilCodifi;
import com.sorin.idea.util.UtilFechas;
import com.sorin.idea.util.UtilMapeos;

/**
 * Clase para generar una hoja Excel Simple
 * 
 * @author Moises Fanchi + FRR
 * 
 */
public class GenerarExcel extends BaseIU{
	
	private static Workbook wb;
	private static Sheet sheetPacientes;
	private static Sheet sheetEEF;
	private static Sheet sheetCV;
	private static Sheet sheetDAI;
	private static Sheet sheetATP;
	private static Sheet sheetEPI;
	private static Sheet sheetFLE;
	private static Sheet sheetVA;
	private static Sheet sheetTAQ;
	private static Sheet sheetEEFCOMPABL;
	
	private static Sheet sheetIMPMP;
	private static Sheet sheetIMPMP_IND;
	private static Sheet sheetIMPMP_EV;
	
	private static Sheet sheetIMPDESF;
	private static Sheet sheetIMPDESF_IND;
	private static Sheet sheetIMPDESF_EV;
	
	private static Sheet sheetIMPBRADI;
	private static Sheet sheetIMPBRADI_IND;
	private static Sheet sheetIMPBRADI_EV;
	
	private static Sheet sheetIMPTAQUI;
	
	private static Sheet sheetREG;
	private static Sheet sheetMESA;
	private static Sheet sheetHOLTER;
	private static Sheet sheetREGEVEXT;
	private static Sheet sheetPAT;
	private static Sheet sheetRegNalDAI;
	private static Sheet sheetMatGen;
	private static Sheet sheetMatEle;
	private static Sheet sheetMatCat;
	private static Sheet sheetMatReg;
	private static Sheet sheetRecalls;
	
	private static String FORMATO = "dd-MM-yyyy";
	
	/**
	 * Para escribir el contenido de una celda.
	 * 
	 * @param row fila.
	 * @param i posicion en la fila.
	 * @param value texto a escribir.
	 * @param style estilo de la celda.
	 */
	public static void createCell(Row row, int i, String value, CellStyle style) {
		Cell cell = row.createCell(i);
		value = value + " ";
		cell.setCellValue(value);
		// si no hay estilo, no se aplica
		if (style != null)
			cell.setCellStyle(style);
	}
	
	public static String ToString(Object s) {
		if(s != null)
			return s.toString();
		else
			return "";
	}
	
	public static Integer ToInteger(String s) {
		if(s != null && s.length() > 0)
			return new Integer(s);
		else
			return -1;
	}
	
	public static String getDuracion(String hini, String hfin){
		String duracion = "";
		if(hini != null && hini.length() == 4 &&
				hfin != null && hfin.length() == 4){
			Date ini = new Date(2011,1,1,new Integer(hini.substring(0,2)), new Integer(hini.substring(2,4)), 0);
			Date fin = new Date(2011,1,1,new Integer(hfin.substring(0,2)), new Integer(hfin.substring(2,4)), 0);
			duracion = UtilFechas.dateDiffms(fin, ini);
		}
		return duracion;
	}
	
	/**
	 * Crea una hoja de excel para cada test
	 * @param pacienteAtp Pacientes con los filtros atp
	 * @param resatp Datos de test atp
	 * @param pacienteEpi Pacientes con los filtros epi
	 * @param resepi Datos de test epi
	 * @param pacienteFle Pacientes con los filtros fle
	 * @param resfle Datos de test fle
	 * @param filename Nombre del fichero
	 * @param out Salida
	 */
	public static void crearExcel(List<Map> pacienteAtp,
			ArrayList<ArrayList<Object>> resatp, List<Map> pacienteEpi,
			ArrayList<ArrayList<Object>> resepi, List<Map> pacienteFle,
			ArrayList<ArrayList<Object>> resfle, String filename,
			OutputStream out) {
		try {
			wb = new HSSFWorkbook();
			sheetATP = wb.createSheet("TEST_ATP");
			sheetEPI = wb.createSheet("TEST_EPI");
			sheetFLE = wb.createSheet("TEST_FLE");
			
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasTest(wb);
			
			rellenaATP(pacienteAtp, resatp);
			rellenaEPI(pacienteEpi, resepi);
			rellenaFLE(pacienteFle, resfle);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 50; i++) {
				sheetATP.autoSizeColumn((short) i);
				sheetEPI.autoSizeColumn((short) i);
				sheetFLE.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Crea un excel para las cardioversiones
	 * mmb
	 * @param datos Datos de las distintas consultas
	 * @param rescv Datos de Cardioversiones
	 * @param filename Nombre del fichero
	 * @param out Salida
	 */
	public static void crearExcel(ArrayList<DatoEstAnual> datos,
			String filename, OutputStream out) {
		try {
			wb = new HSSFWorkbook();
			sheetCV = wb.createSheet("ESTADISTICAS_ANUALES");
			
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasEstadisticas(wb);
			
			rellenaEstadisticas(datos);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 50; i++) {
				sheetCV.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	/**
	 * Crea un excel para las cardioversiones
	 * @param paciente Datos de los pacientes
	 * @param rescv Datos de Cardioversiones
	 * @param filename Nombre del fichero
	 * @param out Salida
	 */
	public static void crearExcel(List<Map> paciente, ArrCardioversion[] rescv,
			String filename, OutputStream out) {
		try {
			wb = new HSSFWorkbook();
			sheetCV = wb.createSheet("CARDIOVERSION");
			
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasCv(wb);
			
			rellenaCV(paciente, rescv);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 50; i++) {
				sheetCV.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Crea un excel para los desfibriladores
	 * @param paciente paciente Datos de los pacientes
	 * @param resdai datos de los desfibriladores
	 * @param filename Nombre del fichero
	 * @param out Salida
	 */
	public static void crearExcel(List<Map> paciente,
			ArrDesfibrilador[] resdai, String filename, OutputStream out) {
		try {
			wb = new HSSFWorkbook();
			sheetDAI = wb.createSheet("DESFIBRILADORES");
			
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasDai(wb);
			
			rellenaDAI(paciente, resdai);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetDAI.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Crea un excel con los estudios
	 * @param paciente Datos de los pacientes
	 * @param reseef Datos de los estudios
	 * @param restaq 
	 * @param resvias 
	 * @param pacienteTaq 
	 * @param pacienteVias 
	 * @param reseefcompabl Complicaciones de ablacion
	 * @param filename Nombre del fichero
	 * @param out Salida
	 */
	public static void crearExcel(List<Map> paciente,
			ArrayList<ArrayList<Object>> reseef, Integer tipo_ablacion, 
			ArrayList<ArrayList<Object>> resvias, ArrayList<ArrayList<Object>> restaq, 
			List<Map> pacienteVias, List<Map> pacienteTaq, ArrayList<ArrayList<Object>> reseefcompabl,
			String filename, OutputStream out) {
		try {
			wb = new HSSFWorkbook();
			if(tipo_ablacion == 1)
				sheetEEF = wb.createSheet("INTENTO_ABLACION");
			else if(tipo_ablacion == 2){
				sheetEEF = wb.createSheet("ABLACION");
				sheetEEFCOMPABL = wb.createSheet("COMPLICACIONES_ABLACION");
			}else
				sheetEEF = wb.createSheet("ESTUDIO");
			sheetVA = wb.createSheet("VIAS_ACCESORIAS");
			sheetTAQ = wb.createSheet("TAQUICARDIAS");
			
			
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasEef(wb, tipo_ablacion);
			
			rellenaEEF(paciente, reseef, tipo_ablacion, resvias, restaq, pacienteVias, pacienteTaq, reseefcompabl);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 60; i++) {
				sheetEEF.autoSizeColumn((short) i);
				sheetVA.autoSizeColumn((short) i);
				sheetTAQ.autoSizeColumn((short) i);
				if(tipo_ablacion == 2)
					sheetEEFCOMPABL.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void crearExcel_BRADI(ArrayList<ArrayList<Object>> res,
			String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetIMPBRADI = wb.createSheet("Implante");
			//sheetIMPBRADI_IND = wb.createSheet("Indicacion");
			//sheetIMPBRADI_EV = wb.createSheet("Evolucion");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasImpBRADI(wb);
			
			rellenaImpBRADI(res);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetIMPBRADI.autoSizeColumn((short) i);
				//sheetIMPBRADI_IND.autoSizeColumn((short) i);
				//sheetIMPBRADI_EV.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_TAQUI(ArrayList<ArrayList<Object>> res,
			String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetIMPTAQUI = wb.createSheet("Implante");
			//sheetIMPBRADI_IND = wb.createSheet("Indicacion");
			//sheetIMPBRADI_EV = wb.createSheet("Evolucion");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasImpTAQUI(wb);
			
			rellenaImpTAQUI(res);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetIMPTAQUI.autoSizeColumn((short) i);
				//sheetIMPBRADI_IND.autoSizeColumn((short) i);
				//sheetIMPBRADI_EV.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Crea un excel con los implantes de Marcapasos
	 * @param pacientes
	 * @param sitclin
	 * @param himp
	 * @param ev
	 * @param impgenlist
	 * @param gens
	 * @param filename
	 * @param out
	 */
	public static void crearExcel_MP(ArrayList<ArrPacientes> pacientes, ArrayList<SituacionClinicaProc> sitclin,
			ArrayList<ImpHojaImplante> himp, ArrayList<ImpEvolucion> ev,
			ArrayList<ImpGenerador> impgenlist, ArrayList<Generador> gens,ArrayList<Procedimiento> prs,
			ArrayList<EstadisticasImplanteBean> auxest,
			String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetIMPMP = wb.createSheet("Implante");
			sheetIMPMP_IND = wb.createSheet("Indicacion");
			sheetIMPMP_EV = wb.createSheet("Evolucion");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasImpMP(wb);
			
			rellenaImpMP(pacientes,sitclin,himp,ev,impgenlist,gens,prs, auxest);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetIMPMP.autoSizeColumn((short) i);
				sheetIMPMP_IND.autoSizeColumn((short) i);
				sheetIMPMP_EV.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * Crea un excel con los implantes de Desfibrilador
	 * @param pacientes
	 * @param sitclin
	 * @param himp
	 * @param ev
	 * @param impgenlist
	 * @param gens
	 * @param filename
	 * @param out
	 */
	public static void crearExcel_DAI(ArrayList<ArrPacientes> pacientes, ArrayList<SituacionClinicaProc> sitclin,
			ArrayList<ImpHojaImplante> himp, ArrayList<ImpEvolucion> ev,
			ArrayList<ImpGenerador> impgenlist, ArrayList<Generador> gens,ArrayList<Procedimiento> prs,
			ArrayList<EstadisticasImplanteBean> auxest,
			String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetIMPDESF = wb.createSheet("Implante");
			sheetIMPDESF_IND = wb.createSheet("Indicacion");
			sheetIMPDESF_EV = wb.createSheet("Evolucion");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasImpDESF(wb);
			
			rellenaImpDESF(pacientes,sitclin,himp,ev,impgenlist,gens,prs, auxest);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetIMPDESF.autoSizeColumn((short) i);
				sheetIMPDESF_IND.autoSizeColumn((short) i);
				sheetIMPDESF_EV.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void crearExcel_Reg(ArrayList<ArrayList<Object>> res,
			String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetREG = wb.createSheet("REGISTRADOR_EVENTOS");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasReg(wb);
			
			rellenaREG(res);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetREG.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_Mesa(ArrayList<ArrayList<Object>> res, 
			String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetMESA = wb.createSheet("MESA_BASCULANTE");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasMesas(wb);
			
			rellenaMESA(res);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetMESA.autoSizeColumn((short) i);
			}

			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_Hol(ArrayList<ArrayList<Object>> res,
			String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetHOLTER = wb.createSheet("HOLTER_24h");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasHol(wb);
			
			rellenaHOLTER(res);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetHOLTER.autoSizeColumn((short) i);
			}
			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		
		}
	}
	public static void crearExcel_RegEvExt(ArrayList<ArrayList<Object>> res,
			String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetREGEVEXT = wb.createSheet("REGISTRADOR_EVENTOS_EXTERNO");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasRegEvExt(wb);
			
			rellenaREGEVEXT(res);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetREGEVEXT.autoSizeColumn((short) i);
			}
			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_Pacientes(ArrayList<PacienteAplDto> res,
			String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetPAT = wb.createSheet("CONSULTAS_PACIENTES_PROCEDIMIENTOS");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasPat(wb);
			
			rellenaPAT(res);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetPAT.autoSizeColumn((short) i);
			}
			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_RegNalDAI(ArrayList<RegistroDaiDto> res, String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetRegNalDAI = wb.createSheet("REGISTRO_NACIONAL_DAI");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasRegNalDAI(wb);
			
			rellenaRegNalDAI(res);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetRegNalDAI.autoSizeColumn((short) i);
			}
			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_MatGen(Generador[] gens, String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetMatGen = wb.createSheet("GENERADORES");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasMatGen(wb);
			
			rellenaMatGen(gens);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetMatGen.autoSizeColumn((short) i);
			}
			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_MatEle(Electrodos[] els, String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetMatEle = wb.createSheet("ELCTRODOS");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasMatEle(wb);
			
			rellenaMatEle(els);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetMatEle.autoSizeColumn((short) i);
			}
			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_MatCat(Cateter[] cats, String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetMatCat = wb.createSheet("CATETERES");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasMatCat(wb);
			
			rellenaMatCat(cats);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetMatCat.autoSizeColumn((short) i);
			}
			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_MatRegEv(Registradoreventos[] regs, String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetMatReg = wb.createSheet("REGISTRADOR_EVENTOS_IMPL");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasMatRegEv(wb);
			
			rellenaMatRegEv(regs);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetMatReg.autoSizeColumn((short) i);
			}
			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void crearExcel_Recalls(ArrayList<RecallDto> recs, String filename, OutputStream out){
		try{
			wb = new HSSFWorkbook();
			sheetRecalls = wb.createSheet("ALERTAS_SEGURIDAD");
			// para la cabecera, la primera fila, aplicamos un estilo
			// (negrita y color de fondo azul)
			creaCabecerasRecalls(wb);
			rellenaRecalls(recs);
			
			// Asignar automaticamente el tamaño de las celdas en funcion del contenido
			for (int i = 0; i < 70; i++) {
				sheetRecalls.autoSizeColumn((short) i);
			}
			// Escribir el fichero.
			wb.write(out);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void creaCabecerasTest(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		
		//Cabecera para la hoja atp
		Row row = sheetATP.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		/*createCell(row, cont++, "CARDIOPATIA", style);
		createCell(row, cont++, "FEVI(%)", style);
		createCell(row, cont++, "FUNCION_VENTRICULAR", style);
		createCell(row, cont++, "HTA", style);
		createCell(row, cont++, "DISLIPEMIA", style);
		createCell(row, cont++, "DIABETES", style);
		createCell(row, cont++, "TABAQUISMO", style);
		createCell(row, cont++, "ACV", style);
		createCell(row, cont++, "INSUF_RENAL", style);
		createCell(row, cont++, "SAOS/EPOC", style);
		createCell(row, cont++, "AFECTA_TIROIDEA", style);
		createCell(row, cont++, "FIBRILACION_AURICULAR", style);
		createCell(row, cont++, "ARRITMIA_VENTRICULAR_SOSTENIDA", style);
		createCell(row, cont++, "INSUF_CARDIACA", style);
		createCell(row, cont++, "SINCOPE", style);
		createCell(row, cont++, "PARADA_CARDIACA", style);
		createCell(row, cont++, "CV-DESF", style);
		createCell(row, cont++, "PORTADOR DAI", style);
		createCell(row, cont++, "PORTADOR MP", style);*/
		createCell(row, cont++, "FECHA", style2);
		createCell(row, cont++, "MOTIVO_CLINICO", style2);
		createCell(row, cont++, "MOTIVO_ECG", style2);
		createCell(row, cont++, "PRIMERA_DOSIS", style2);
		createCell(row, cont++, "SEGUNDA_DOSIS", style2);
		createCell(row, cont++, "COMPLICACIONES", style2);
		createCell(row, cont++, "OTRAS_COMPLICA", style2);
		createCell(row, cont++, "TRATAMIENTO", style2);
		createCell(row, cont++, "RITMO_BASAL", style2);
		createCell(row, cont++, "CONDUCCION_AV", style2);
		createCell(row, cont++, "CONDUCCION_AV_NO_NORMAL", style2);
		createCell(row, cont++, "QRS_NORMAL", style2);
		createCell(row, cont++, "QRS_NO_NORMAL", style2);
		createCell(row, cont++, "RR", style2);
		createCell(row, cont++, "PR", style2);
		createCell(row, cont++, "QRS", style2);
		createCell(row, cont++, "QT", style2);
		createCell(row, cont++, "QTC", style2);
		createCell(row, cont++, "COMENTARIOS", style2);
		
		cont = 0;
		
		//Cabecera para la hoja epi
		row = sheetEPI.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		/*createCell(row, cont++, "CARDIOPATIA", style);
		createCell(row, cont++, "FEVI(%)", style);
		createCell(row, cont++, "FUNCION_VENTRICULAR", style);
		createCell(row, cont++, "HTA", style);
		createCell(row, cont++, "DISLIPEMIA", style);
		createCell(row, cont++, "DIABETES", style);
		createCell(row, cont++, "TABAQUISMO", style);
		createCell(row, cont++, "ACV", style);
		createCell(row, cont++, "INSUF_RENAL", style);
		createCell(row, cont++, "SAOS/EPOC", style);
		createCell(row, cont++, "AFECTA_TIROIDEA", style);
		createCell(row, cont++, "FIBRILACION_AURICULAR", style);
		createCell(row, cont++, "ARRITMIA_VENTRICULAR_SOSTENIDA", style);
		createCell(row, cont++, "INSUF_CARDIACA", style);
		createCell(row, cont++, "SINCOPE", style);
		createCell(row, cont++, "PARADA_CARDIACA", style);
		createCell(row, cont++, "CV-DESF", style);
		createCell(row, cont++, "PORTADOR DAI", style);
		createCell(row, cont++, "PORTADOR MP", style);*/
		createCell(row, cont++, "FECHA", style2);
		createCell(row, cont++, "MOTIVO_CLINICO", style2);
		createCell(row, cont++, "MOTIVO_ECG", style2);
		createCell(row, cont++, "RESULTADO", style2);
		createCell(row, cont++, "PICO", style2);
		createCell(row, cont++, "COMPLICACIONES", style2);
		createCell(row, cont++, "OTRAS_COMPLICA", style2);
		createCell(row, cont++, "TRATAMIENTO", style2);
		createCell(row, cont++, "RITMO_BASAL", style2);
		createCell(row, cont++, "CONDUCCION_AV", style2);
		createCell(row, cont++, "CONDUCCION_AV_NO_NORMAL", style2);
		createCell(row, cont++, "QRS_NORMAL", style2);
		createCell(row, cont++, "QRS_NO_NORMAL", style2);
		createCell(row, cont++, "RR", style2);
		createCell(row, cont++, "PR", style2);
		createCell(row, cont++, "QRS", style2);
		createCell(row, cont++, "QT", style2);
		createCell(row, cont++, "QTC", style2);
		createCell(row, cont++, "COMENTARIOS", style2);
		
		cont = 0;
		
		//Cabecera para la hoja fle
		row = sheetFLE.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		/*createCell(row, cont++, "CARDIOPATIA", style);
		createCell(row, cont++, "FEVI(%)", style);
		createCell(row, cont++, "FUNCION_VENTRICULAR", style);
		createCell(row, cont++, "HTA", style);
		createCell(row, cont++, "DISLIPEMIA", style);
		createCell(row, cont++, "DIABETES", style);
		createCell(row, cont++, "TABAQUISMO", style);
		createCell(row, cont++, "ACV", style);
		createCell(row, cont++, "INSUF_RENAL", style);
		createCell(row, cont++, "SAOS/EPOC", style);
		createCell(row, cont++, "AFECTA_TIROIDEA", style);
		createCell(row, cont++, "FIBRILACION_AURICULAR", style);
		createCell(row, cont++, "ARRITMIA_VENTRICULAR_SOSTENIDA", style);
		createCell(row, cont++, "INSUF_CARDIACA", style);
		createCell(row, cont++, "SINCOPE", style);
		createCell(row, cont++, "PARADA_CARDIACA", style);
		createCell(row, cont++, "CV-DESF", style);
		createCell(row, cont++, "PORTADOR DAI", style);
		createCell(row, cont++, "PORTADOR MP", style);*/
		createCell(row, cont++, "FECHA", style2);
		createCell(row, cont++, "MOTIVO_CLINICO", style2);
		createCell(row, cont++, "MOTIVO_ECG", style2);
		createCell(row, cont++, "RESULTADO", style2);
		createCell(row, cont++, "V1", style2);
		createCell(row, cont++, "V2", style2);
		createCell(row, cont++, "COMPLICACIONES", style2);
		createCell(row, cont++, "OTRAS_COMPLICA", style2);
		createCell(row, cont++, "TRATAMIENTO", style2);
		createCell(row, cont++, "RITMO_BASAL", style2);
		createCell(row, cont++, "CONDUCCION_AV", style2);
		createCell(row, cont++, "CONDUCCION_AV_NO_NORMAL", style2);
		createCell(row, cont++, "QRS_NORMAL", style2);
		createCell(row, cont++, "QRS_NO_NORMAL", style2);
		createCell(row, cont++, "RR", style2);
		createCell(row, cont++, "PR", style2);
		createCell(row, cont++, "QRS", style2);
		createCell(row, cont++, "QT", style2);
		createCell(row, cont++, "QTC", style2);
		createCell(row, cont++, "COMENTARIOS", style2);
	}
	
	//mmb
	private static void creaCabecerasEstadisticas(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		
		//Cabecera para la hoja atp
		Row row = sheetCV.createRow((short) 0);
		createCell(row, cont++, "CONSULTA", style);
		createCell(row, cont++, "ENERO", style);
		createCell(row, cont++, "FEBRERO", style);
		createCell(row, cont++, "MARZO", style);
		createCell(row, cont++, "ABRIL", style);
		createCell(row, cont++, "MAYO", style);
		createCell(row, cont++, "JUNIO", style);
		createCell(row, cont++, "JULIO", style);
		createCell(row, cont++, "AGOSTO", style);
		createCell(row, cont++, "SEPTIEMBRE", style);
		createCell(row, cont++, "OCTUBRE", style);
		createCell(row, cont++, "NOVIEMBRE", style);
		createCell(row, cont++, "DICIEMBRE", style);
		createCell(row, cont++, "TOTAL", style);
		
	}
	
	private static void creaCabecerasCv(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		
		//Cabecera para la hoja atp
		Row row = sheetCV.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		/*createCell(row, cont++, "CARDIOPATIA", style);
		createCell(row, cont++, "FEVI(%)", style);
		createCell(row, cont++, "FUNCION_VENTRICULAR", style);
		createCell(row, cont++, "HTA", style);
		createCell(row, cont++, "DISLIPEMIA", style);
		createCell(row, cont++, "DIABETES", style);
		createCell(row, cont++, "TABAQUISMO", style);
		createCell(row, cont++, "ACV", style);
		createCell(row, cont++, "INSUF_RENAL", style);
		createCell(row, cont++, "SAOS/EPOC", style);
		createCell(row, cont++, "AFECTA_TIROIDEA", style);
		createCell(row, cont++, "FIBRILACION_AURICULAR", style);
		createCell(row, cont++, "ARRITMIA_VENTRICULAR_SOSTENIDA", style);
		createCell(row, cont++, "INSUF_CARDIACA", style);
		createCell(row, cont++, "SINCOPE", style);
		createCell(row, cont++, "PARADA_CARDIACA", style);
		createCell(row, cont++, "CV-DESF", style);
		createCell(row, cont++, "PORTADOR DAI", style);
		createCell(row, cont++, "PORTADOR MP", style);*/
		createCell(row, cont++, "NUMERO", style2);
		createCell(row, cont++, "INDICACION_FIBRILACION", style2);
		createCell(row, cont++, "INDICACION_FLUTER_ATIPICO", style2);
		createCell(row, cont++, "INDICACION_FLUTER_TIPICO", style2);
		createCell(row, cont++, "PROCEDENCIA", style2);
		createCell(row, cont++, "CVE_PREVIA", style2);
		createCell(row, cont++, "ABLACION", style2);
		createCell(row, cont++, "AMIODARONA", style2);
		createCell(row, cont++, "DRONEDARONA", style2);
		createCell(row, cont++, "SOTALOL", style2);
		createCell(row, cont++, "CLASE_I", style2);
		createCell(row, cont++, "IECA", style2);
		createCell(row, cont++, "ARA_II", style2);
		createCell(row, cont++, "DURACION", style2);
		createCell(row, cont++, "TTO_ANTITROM_AVTAK", style2);
		createCell(row, cont++, "TTO_ANTITROM_ETE", style2);
		createCell(row, cont++, "SEC1", style2);
		createCell(row, cont++, "SEC2", style2);
		createCell(row, cont++, "SEC3", style2);
		createCell(row, cont++, "SEC4", style2);
		createCell(row, cont++, "SEC5", style2);
		createCell(row, cont++, "PARCHES", style2);
		createCell(row, cont++, "ATROPINA", style2);
		createCell(row, cont++, "ESTIM_TMP_EXT", style2);
		createCell(row, cont++, "EXITO_TRANSITORIO", style2);
		createCell(row, cont++, "EXITO_FINAL", style2);
		createCell(row, cont++, "COMPLICACION", style2);
		createCell(row, cont++, "TIPO PROCEDIMIENTO", style2);
		createCell(row, cont++, "FECHA PROCEDIMIENTO", style2);
	}
	
	private static void creaCabecerasDai(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		
		//Cabecera para la hoja atp
		Row row = sheetDAI.createRow((short) 0);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "CARDIOPATIA", style);
		createCell(row, cont++, "FEVI(%)", style);
		createCell(row, cont++, "FUNCION_VENTRICULAR", style);
		createCell(row, cont++, "HTA", style);
		createCell(row, cont++, "DISLIPEMIA", style);
		createCell(row, cont++, "DIABETES", style);
		createCell(row, cont++, "TABAQUISMO", style);
		createCell(row, cont++, "ACV", style);
		createCell(row, cont++, "INSUF_RENAL", style);
		createCell(row, cont++, "SAOS/EPOC", style);
		createCell(row, cont++, "AFECTA_TIROIDEA", style);
		createCell(row, cont++, "FIBRILACION_AURICULAR", style);
		createCell(row, cont++, "ARRITMIA_VENTRICULAR_SOSTENIDA", style);
		createCell(row, cont++, "INSUF_CARDIACA", style);
		createCell(row, cont++, "SINCOPE", style);
		createCell(row, cont++, "PARADA_CARDIACA", style);
		createCell(row, cont++, "CV-DESF", style);
		createCell(row, cont++, "PORTADOR DAI", style);
		createCell(row, cont++, "PORTADOR MP", style);
		//Cabeceras de desfibriladores
		createCell(row, cont++, "DAI", style2);
		createCell(row, cont++, "CARDIOPATIA", style2);
		createCell(row, cont++, "FRAC_EYECCION", style2);
		createCell(row, cont++, "IC", style2);
		createCell(row, cont++, "ENF_CONDUCCION", style2);
		createCell(row, cont++, "RITMO_BASAL", style2);
		createCell(row, cont++, "ANTECE_INS_RENAL", style2);
		createCell(row, cont++, "ANTECE_FA", style2);
		createCell(row, cont++, "DIABETES", style2);
		createCell(row, cont++, "HIPERTENSION", style2);
		createCell(row, cont++, "ANTECE_MUERTE_SUBITA", style2);
		createCell(row, cont++, "ANCHURA_QRS", style2);
		createCell(row, cont++, "FUMADOR", style2);
		createCell(row, cont++, "HIPERCOLESTEROLEMIA", style2);
		createCell(row, cont++, "ACV", style2);
		createCell(row, cont++, "ARR_CLINICA", style2);
		createCell(row, cont++, "PRESENTA_CLINICA", style2);
		createCell(row, cont++, "EEF", style2);
		createCell(row, cont++, "PREVENCION", style2);
		createCell(row, cont++, "FECHA_IMPLANTE", style2);
		createCell(row, cont++, "LUGAR", style2);
		createCell(row, cont++, "IMPLANTADOR", style2);
		createCell(row, cont++, "GENERADOR", style2);
		createCell(row, cont++, "LOC_GENERADOR", style2);
		createCell(row, cont++, "ELECTRODOS", style2);
		createCell(row, cont++, "ELECTRODOS_PREVIOS", style2);
		createCell(row, cont++, "¿INDUCCION?", style2);
		createCell(row, cont++, "COMPLICACIONES", style2);
		createCell(row, cont++, "ESTIM_ANTIBRADICARDIA", style2);
		createCell(row, cont++, "ALGORITMO_PREVENCION", style2);
		createCell(row, cont++, "ESTIM_ATP", style2);
		createCell(row, cont++, "MODELO", style2);
	}
	
	//Cabecera de EEF
	private static void creaCabecerasEef(Workbook wb, Integer tipo_ablacion){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		CellStyle style3 = wb.createCellStyle();
		style3.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		style3.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style3.setBorderBottom(CellStyle.BORDER_THICK);
		style3.setBorderTop(CellStyle.BORDER_THICK);
		style3.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		
		//Cabecera para la hoja eef
		Row row = sheetEEF.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		/*createCell(row, cont++, "CARDIOPATIA", style);
		createCell(row, cont++, "FEVI(%)", style);
		createCell(row, cont++, "FUNCION_VENTRICULAR", style);
		createCell(row, cont++, "HTA", style);
		createCell(row, cont++, "DISLIPEMIA", style);
		createCell(row, cont++, "DIABETES", style);
		createCell(row, cont++, "TABAQUISMO", style);
		createCell(row, cont++, "ACV", style);
		createCell(row, cont++, "INSUF_RENAL", style);
		createCell(row, cont++, "SAOS/EPOC", style);
		createCell(row, cont++, "AFECTA_TIROIDEA", style);
		createCell(row, cont++, "FIBRILACION_AURICULAR", style);
		createCell(row, cont++, "ARRITMIA_VENTRICULAR_SOSTENIDA", style);
		createCell(row, cont++, "INSUF_CARDIACA", style);
		createCell(row, cont++, "SINCOPE", style);
		createCell(row, cont++, "PARADA_CARDIACA", style);
		createCell(row, cont++, "CV-DESF", style);
		createCell(row, cont++, "PORTADOR DAI", style);
		createCell(row, cont++, "PORTADOR MP", style);*/
		//cabecera propia del estudio
		createCell(row, cont++, "FECHA", style2);
		createCell(row, cont++, "ESTUDIO", style2);
		createCell(row, cont++, "TIPO_PROCEDIMIENTO", style2);
		createCell(row, cont++, "PROCEDIMIENTO", style2);
		createCell(row, cont++, "MOTIVO", style2);
		createCell(row, cont++, "DIAGNOSTICO", style2);
		createCell(row, cont++, "PRIMER_OPERADOR", style2);
		createCell(row, cont++, "SEGUNDO_OPERADOR", style2);
		createCell(row, cont++, "ANESTESIA", style2);
		createCell(row, cont++, "NAVEGADOR", style2);
		createCell(row, cont++, "ECOGRAFIA", style2);
		createCell(row, cont++, "ESCOPIA", style2);
		createCell(row, cont++, "TIEMPO_ESCOPIA", style2);
		createCell(row, cont++, "ANGIOGRAFIA ROT.", style2);
		createCell(row, cont++, "ROBOT", style2);
		createCell(row, cont++, "CATETERES", style2);
		createCell(row, cont++, "T_OCUPACION_SALA", style2);
		createCell(row, cont++, "T_PREPARACION", style2);
		createCell(row, cont++, "T_EEF_DIAGNOSTICO", style2);
		createCell(row, cont++, "T_ABLACION", style2);
		createCell(row, cont++, "T_SALIDA", style2);
		createCell(row, cont++, "RITMO_BASAL", style2);
		createCell(row, cont++, "QRS_NORMAL", style2);
		createCell(row, cont++, "INTERVALO", style2);
		createCell(row, cont++, "COMPLICACION", style2);
		createCell(row, cont++, "MUERTE", style2);
		if(tipo_ablacion == 1){
			createCell(row, cont++, "TIPO", style3);
			createCell(row, cont++, "COMPLICACION", style3);
			createCell(row, cont++, "BLOQUEO-TRANSEPTAL", style3);
			createCell(row, cont++, "OTRA_COMP", style3);
		}
		if(tipo_ablacion == 2){
			createCell(row, cont++, "NUM_SUSTRATO", style3);
			createCell(row, cont++, "ABORDAJE", style3);
			createCell(row, cont++, "ENERGIA", style3);
			createCell(row, cont++, "TIEMPO_APLICACION", style3);
			createCell(row, cont++, "POTENCIA", style3);
			createCell(row, cont++, "CATETER", style3);
			createCell(row, cont++, "SUSTRATO", style3);
			createCell(row, cont++, "RESULTADO", style3);
			//createCell(row, cont++, "COMPLICACION", style3);
			//createCell(row, cont++, "MUERTE", style3);
			
			//cabecera de Complicaciones de ablacion
			cont = 0;
			row = sheetEEFCOMPABL.createRow((short) 0);
			//createCell(row, cont++, "CIP", style);
			createCell(row, cont++, "NHC", style);
			createCell(row, cont++, "FECHA", style2);
			createCell(row, cont++, "ESTUDIO", style2);
			createCell(row, cont++, "NUM_SUSTRATO", style3);
			createCell(row, cont++, "ABORDAJE", style3);
			createCell(row, cont++, "ENERGIA", style3);
			createCell(row, cont++, "TIEMPO_APLICACION", style3);
			createCell(row, cont++, "POTENCIA", style3);
			createCell(row, cont++, "CATETER", style3);
			createCell(row, cont++, "SUSTRATO", style3);
			createCell(row, cont++, "RESULTADO", style3);
			createCell(row, cont++, "COMPLICACION", style3);
			createCell(row, cont++, "MUERTE", style3);
		}
		
		//cabecera de Vias Accesorias
		cont = 0;
		row = sheetVA.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		/*createCell(row, cont++, "CARDIOPATIA", style);
		createCell(row, cont++, "FEVI(%)", style);
		createCell(row, cont++, "FUNCION_VENTRICULAR", style);
		createCell(row, cont++, "HTA", style);
		createCell(row, cont++, "DISLIPEMIA", style);
		createCell(row, cont++, "DIABETES", style);
		createCell(row, cont++, "TABAQUISMO", style);
		createCell(row, cont++, "ACV", style);
		createCell(row, cont++, "INSUF_RENAL", style);
		createCell(row, cont++, "SAOS/EPOC", style);
		createCell(row, cont++, "AFECTA_TIROIDEA", style);
		createCell(row, cont++, "FIBRILACION_AURICULAR", style);
		createCell(row, cont++, "ARRITMIA_VENTRICULAR_SOSTENIDA", style);
		createCell(row, cont++, "INSUF_CARDIACA", style);
		createCell(row, cont++, "SINCOPE", style);
		createCell(row, cont++, "PARADA_CARDIACA", style);
		createCell(row, cont++, "CV-DESF", style);
		createCell(row, cont++, "PORTADOR DAI", style);
		createCell(row, cont++, "PORTADOR MP", style);*/
		//cabecera especifica de VA
		createCell(row, cont++, "ESTUDIO", style3);
		createCell(row, cont++, "TIPO", style3);
		createCell(row, cont++, "SENTIDO", style3);
		createCell(row, cont++, "LOCALIZACION", style3);
		
		//cabecera de Taquicardias
		cont = 0;
		row = sheetTAQ.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		/*createCell(row, cont++, "CARDIOPATIA", style);
		createCell(row, cont++, "FEVI(%)", style);
		createCell(row, cont++, "FUNCION_VENTRICULAR", style);
		createCell(row, cont++, "HTA", style);
		createCell(row, cont++, "DISLIPEMIA", style);
		createCell(row, cont++, "DIABETES", style);
		createCell(row, cont++, "TABAQUISMO", style);
		createCell(row, cont++, "ACV", style);
		createCell(row, cont++, "INSUF_RENAL", style);
		createCell(row, cont++, "SAOS/EPOC", style);
		createCell(row, cont++, "AFECTA_TIROIDEA", style);
		createCell(row, cont++, "FIBRILACION_AURICULAR", style);
		createCell(row, cont++, "ARRITMIA_VENTRICULAR_SOSTENIDA", style);
		createCell(row, cont++, "INSUF_CARDIACA", style);
		createCell(row, cont++, "SINCOPE", style);
		createCell(row, cont++, "PARADA_CARDIACA", style);
		createCell(row, cont++, "CV-DESF", style);
		createCell(row, cont++, "PORTADOR DAI", style);
		createCell(row, cont++, "PORTADOR MP", style);*/
		//cabecera especifica de taquicardias
		createCell(row, cont++, "ESTUDIO", style3);
		createCell(row, cont++, "NUM_TAQUI", style3);
		createCell(row, cont++, "LONG_CICLO(ms)", style3);
		createCell(row, cont++, "MORFOLOGIA", style3);
		createCell(row, cont++, "INDUCCION", style3);
		createCell(row, cont++, "INDUCIDA", style3);
		createCell(row, cont++, "COMPORTAMIENTO", style3);
		createCell(row, cont++, "TIPO", style3);
	}
	
	private static void creaCabecerasImpMP(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de IMPLANTE 
		Row row = sheetIMPMP.createRow((short) 0);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "FECHA PROCEDIMIENTO", style2);
		createCell(row, cont++, "TIPO PROCEDIMIENTO", style2);
		createCell(row, cont++, "MODELO", style2);
		createCell(row, cont++, "NUM. SERIE", style2);
		createCell(row, cont++, "FABRICANTE", style2);
		createCell(row, cont++, "LOCALIZACION", style2);
		
		createCell(row, cont++, "IMPLANTADOR", style2);
		createCell(row, cont++, "ENFERMERIA", style2);
		createCell(row, cont++, "PRIMER OPERADOR", style2);
		createCell(row, cont++, "SEGUNDO OPERADOR", style2);
		createCell(row, cont++, "PRIORIDAD", style2);
		createCell(row, cont++, "LUGAR IMPLANTE", style2);
		createCell(row, cont++, "TIPO ANESTESIA", style2);
		createCell(row, cont++, "TIEMPO ESCOPIA(min)", style2);
		createCell(row, cont++, "HORA LLEGADA", style2);
		createCell(row, cont++, "HORA INICIO", style2);
		createCell(row, cont++, "HORA FIN", style2);
		createCell(row, cont++, "HORA SALIDA", style2);
		
		
		//Cabeceras de indicacion
		row = sheetIMPMP_IND.createRow((short) 0);
		cont = 0;
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "RITMO", style2);
		createCell(row, cont++, "CONDUCCION AV", style2);
		createCell(row, cont++, "QRS", style2);
		createCell(row, cont++, "FEVI(%)", style2);
		createCell(row, cont++, "FUNCION VENTRICULAR", style2);
		createCell(row, cont++, "NYHA", style2);
		createCell(row, cont++, "CARDIOPATIA", style2);
		createCell(row, cont++, "A.EVOLUCION", style2);
		createCell(row, cont++, "REVASCULARIZACION PREVIA", style2);
		createCell(row, cont++, "INFARTO PREVIO", style2);
		createCell(row, cont++, "INS. RENAL", style2);
		createCell(row, cont++, "DIABETES", style2);
		createCell(row, cont++, "FA", style2);
		createCell(row, cont++, "HIPERTENSION", style2);
		createCell(row, cont++, "MUERTE SUBITA FAM.", style2);
		createCell(row, cont++, "TABAQUISMO", style2);
		createCell(row, cont++, "HIPERCOLESTEROLEMIA", style2);
		createCell(row, cont++, "ACV", style2);
		createCell(row, cont++, "TRANSPLANTE CARDIACO", style2);
		createCell(row, cont++, "AIT", style2);
		createCell(row, cont++, "SINCOPE", style2);
		createCell(row, cont++, "PARADA CARDIACA", style2);
		createCell(row, cont++, "EPOC", style2);
		createCell(row, cont++, "SAHS", style2);
		createCell(row, cont++, "AFEC. TIROIDEA", style2);
		createCell(row, cont++, "NEUROLOGICOS", style2);
		
		//Cabeceras de evolucion
		row = sheetIMPMP_EV.createRow((short) 0);
		cont = 0;
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "MP DEPENDIENTE", style2);
		createCell(row, cont++, "MODO", style2);
		createCell(row, cont++, "FREC.BASICA", style2);
		createCell(row, cont++, "SEG.REMOTO", style2);
		createCell(row, cont++, "MIN.ESTIM.VENTRICULAR", style2);
		createCell(row, cont++, "IAV DETECTADO", style2);
		createCell(row, cont++, "IAV ESTIMULADO", style2);
		createCell(row, cont++, "IAV MAX.", style2);
		createCell(row, cont++, "IAV MIN.", style2);
		createCell(row, cont++, "FREC.MAX", style2);
		createCell(row, cont++, "FREC.MIN", style2);
		createCell(row, cont++, "HISTERESIS", style2);
		createCell(row, cont++, "ALG.PREVENCION FA", style2);
		createCell(row, cont++, "FECHA ALTA", style2);
		createCell(row, cont++, "MOTIVO ALTA", style2);
		
	}
	private static void creaCabecerasImpBRADI(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de IMPLANTE 
		Row row = sheetIMPBRADI.createRow((short) 0);
		//createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		//createCell(row, cont++, "SEXO", style);
		//createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		//createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "TIPO PROCEDIMIENTO", style2);
		createCell(row, cont++, "NUM. PROCEDIMIENTO", style2);
		createCell(row, cont++, "FECHA PROCEDIMIENTO", style2);	
		createCell(row, cont++, "MODELO", style2);
		createCell(row, cont++, "NUM. SERIE", style2);
		createCell(row, cont++, "FABRICANTE", style2);
		//createCell(row, cont++, "LOCALIZACION", style2);
		
		//createCell(row, cont++, "IMPLANTADOR", style2);
		//createCell(row, cont++, "ENFERMERIA", style2);
		//createCell(row, cont++, "PRIMER OPERADOR", style2);
		//createCell(row, cont++, "SEGUNDO OPERADOR", style2);
		//createCell(row, cont++, "PRIORIDAD", style2);
		//createCell(row, cont++, "LUGAR IMPLANTE", style2);
		//createCell(row, cont++, "TIPO ANESTESIA", style2);
		createCell(row, cont++, "TIEMPO ESCOPIA(min)", style2);
		createCell(row, cont++, "IMPLANTADOR", style2);
		createCell(row, cont++, "LUGAR IMP", style2);
		createCell(row, cont++, "PRIORIDAD", style2);
		createCell(row, cont++, "ANESTESIA", style2);
		createCell(row, cont++, "HORA LLEGADA", style2);
		createCell(row, cont++, "HORA INICIO", style2);
		createCell(row, cont++, "HORA FIN", style2);
		createCell(row, cont++, "HORA SALIDA", style2);
		createCell(row, cont++, "RITMO", style2);
		createCell(row, cont++, "RITMO_2", style2);
		createCell(row, cont++, "CONDUCCION AV", style2);
		createCell(row, cont++, "CONDUCCION AV_2", style2);
		createCell(row, cont++, "QRS", style2);
		createCell(row, cont++, "QRS_2", style2);
		createCell(row, cont++, "ANCHURA QRS", style2);
		createCell(row, cont++, "FEVI(%)", style2);
		createCell(row, cont++, "FUNCION VENTRICULAR", style2);
		createCell(row, cont++, "NYHA", style2);
		createCell(row, cont++, "CARDIOPATIA", style2);
		createCell(row, cont++, "A.EVOLUCION", style2);
		createCell(row, cont++, "OTRA", style2);
		//createCell(row, cont++, "REVASCULARIZACION PREVIA", style2);
		//createCell(row, cont++, "INFARTO PREVIO", style2);
		createCell(row, cont++, "HIPERTENSION", style2);
		createCell(row, cont++, "DISLIPEMIA", style2);
		createCell(row, cont++, "DIABETES", style2);
		createCell(row, cont++, "TABAQUISMO", style2);
		createCell(row, cont++, "ING. ALCOHOLICA", style2);
		createCell(row, cont++, "ACV", style2);
		createCell(row, cont++, "AIT", style2);
		createCell(row, cont++, "EPOC", style2);
		createCell(row, cont++, "SAHS", style2);		
		createCell(row, cont++, "INS. RENAL", style2);
		createCell(row, cont++, "NEOPLASIA", style2);	
		createCell(row, cont++, "FA", style2);
		createCell(row, cont++, "TRANSPLANTE CARDIACO", style2);
		createCell(row, cont++, "PARADA CARDIACA", style2);
		createCell(row, cont++, "SINCOPE", style2);
		createCell(row, cont++, "MP DEPENDIENTE", style2);
		createCell(row, cont++, "MODO", style2);
		createCell(row, cont++, "FREC.BASICA", style2);
		createCell(row, cont++, "SEG.REMOTO", style2);
		createCell(row, cont++, "MIN.ESTIM.VENTRICULAR", style2);
		createCell(row, cont++, "IAV DETECTADO", style2);
		createCell(row, cont++, "IAV ESTIMULADO", style2);
		createCell(row, cont++, "IAV MAX.", style2);
		createCell(row, cont++, "IAV MIN.", style2);
		createCell(row, cont++, "FREC.MAX", style2);
		createCell(row, cont++, "FREC.MIN", style2);
		createCell(row, cont++, "HISTERESIS", style2);
		createCell(row, cont++, "ALG.PREVENCION FA", style2);
		createCell(row, cont++, "FECHA ALTA", style2);
		createCell(row, cont++, "PRIMER OPERADOR", style2);
		createCell(row, cont++, "SEGUNDO OPERADOR", style2);
		//createCell(row, cont++, "NUM. PROCEDIMIENTO", style2);
		
		//Cabeceras de indicacion
		/*row = sheetIMPBRADI_IND.createRow((short) 0);
		cont = 0;
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "RITMO", style2);
		createCell(row, cont++, "RITMO_2", style2);
		createCell(row, cont++, "CONDUCCION AV", style2);
		createCell(row, cont++, "CONDUCCION AV_2", style2);
		createCell(row, cont++, "QRS", style2);
		createCell(row, cont++, "QRS_2", style2);
		createCell(row, cont++, "ANCHURA QRS", style2);
		createCell(row, cont++, "FEVI(%)", style2);
		createCell(row, cont++, "FUNCION VENTRICULAR", style2);
		createCell(row, cont++, "NYHA", style2);
		createCell(row, cont++, "CARDIOPATIA", style2);
		createCell(row, cont++, "A.EVOLUCION", style2);
		createCell(row, cont++, "OTRA", style2);
		createCell(row, cont++, "HIPERTENSION", style2);
		createCell(row, cont++, "DISLIPEMIA", style2);
		createCell(row, cont++, "DIABETES", style2);
		createCell(row, cont++, "TABAQUISMO", style2);
		createCell(row, cont++, "ING. ALCOHOLICA", style2);
		createCell(row, cont++, "ACV", style2);
		createCell(row, cont++, "AIT", style2);
		createCell(row, cont++, "EPOC", style2);
		createCell(row, cont++, "SAHS", style2);		
		createCell(row, cont++, "INS. RENAL", style2);
		createCell(row, cont++, "NEOPLASIA", style2);	
		createCell(row, cont++, "FA", style2);
		createCell(row, cont++, "TRANSPLANTE CARDIACO", style2);
		createCell(row, cont++, "PARADA CARDIACA", style2);
		createCell(row, cont++, "SINCOPE", style2);*/
		//createCell(row, cont++, "MUERTE SUBITA FAM.", style2);
		//createCell(row, cont++, "HIPERCOLESTEROLEMIA", style2);
		
		//createCell(row, cont++, "AFEC. TIROIDEA", style2);
		//createCell(row, cont++, "NEUROLOGICOS", style2);
		
		//Cabeceras de evolucion
		/*row = sheetIMPBRADI_EV.createRow((short) 0);
		cont = 0;
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "MP DEPENDIENTE", style2);
		createCell(row, cont++, "MODO", style2);
		createCell(row, cont++, "FREC.BASICA", style2);
		createCell(row, cont++, "SEG.REMOTO", style2);
		createCell(row, cont++, "MIN.ESTIM.VENTRICULAR", style2);
		createCell(row, cont++, "IAV DETECTADO", style2);
		createCell(row, cont++, "IAV ESTIMULADO", style2);
		createCell(row, cont++, "IAV MAX.", style2);
		createCell(row, cont++, "IAV MIN.", style2);
		createCell(row, cont++, "FREC.MAX", style2);
		createCell(row, cont++, "FREC.MIN", style2);
		createCell(row, cont++, "HISTERESIS", style2);
		createCell(row, cont++, "ALG.PREVENCION FA", style2);
		createCell(row, cont++, "FECHA ALTA", style2);
		createCell(row, cont++, "MOTIVO ALTA", style2);*/
		
	}
	private static void creaCabecerasImpTAQUI(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de IMPLANTE 
		Row row = sheetIMPTAQUI.createRow((short) 0);
		//createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		//createCell(row, cont++, "SEXO", style);
		//createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		//createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "TIPO PROCEDIMIENTO", style2);
		createCell(row, cont++, "NUM. PROCEDIMIENTO", style2);
		createCell(row, cont++, "FECHA PROCEDIMIENTO", style2);	
		createCell(row, cont++, "MODELO", style2);
		createCell(row, cont++, "NUM. SERIE", style2);
		createCell(row, cont++, "FABRICANTE", style2);
		//createCell(row, cont++, "LOCALIZACION", style2);
		
		//createCell(row, cont++, "IMPLANTADOR", style2);
		//createCell(row, cont++, "ENFERMERIA", style2);
		//createCell(row, cont++, "PRIMER OPERADOR", style2);
		//createCell(row, cont++, "SEGUNDO OPERADOR", style2);
		//createCell(row, cont++, "PRIORIDAD", style2);
		//createCell(row, cont++, "LUGAR IMPLANTE", style2);
		//createCell(row, cont++, "TIPO ANESTESIA", style2);
		createCell(row, cont++, "TIPO INDICACION", style2); //8
		createCell(row, cont++, "TIEMPO ESCOPIA(min)", style2);
		createCell(row, cont++, "IMPLANTADOR", style2);
		createCell(row, cont++, "LUGAR IMP", style2);
		createCell(row, cont++, "PRIORIDAD", style2);
		createCell(row, cont++, "ANESTESIA", style2);
		createCell(row, cont++, "HORA LLEGADA", style2);
		createCell(row, cont++, "HORA INICIO", style2);
		createCell(row, cont++, "HORA FIN", style2);
		createCell(row, cont++, "HORA SALIDA", style2);
		createCell(row, cont++, "TEST INDUCCION", style2);
		createCell(row, cont++, "TEST INDUCCION_ENERGIA", style2);
		createCell(row, cont++, "TEST INDUCCION_IMPEDANCIA", style2);
		createCell(row, cont++, "TEST INDUCCION_NUM.CHOQUES", style2);
		createCell(row, cont++, "RITMO", style2);
		createCell(row, cont++, "RITMO_2", style2);
		createCell(row, cont++, "CONDUCCION AV", style2);
		createCell(row, cont++, "CONDUCCION AV_2", style2);
		createCell(row, cont++, "QRS", style2);
		createCell(row, cont++, "QRS_2", style2);
		createCell(row, cont++, "ANCHURA QRS", style2);
		createCell(row, cont++, "FEVI(%)", style2);
		createCell(row, cont++, "FUNCION VENTRICULAR", style2);
		createCell(row, cont++, "NYHA", style2);
		createCell(row, cont++, "CARDIOPATIA", style2);
		createCell(row, cont++, "A.EVOLUCION", style2);
		createCell(row, cont++, "OTRA", style2);
		//createCell(row, cont++, "REVASCULARIZACION PREVIA", style2);
		//createCell(row, cont++, "INFARTO PREVIO", style2);
		createCell(row, cont++, "HIPERTENSION", style2);
		createCell(row, cont++, "DISLIPEMIA", style2);
		createCell(row, cont++, "DIABETES", style2);
		createCell(row, cont++, "TABAQUISMO", style2);
		createCell(row, cont++, "ING. ALCOHOLICA", style2);
		createCell(row, cont++, "ACV", style2);
		createCell(row, cont++, "AIT", style2);
		createCell(row, cont++, "EPOC", style2);
		createCell(row, cont++, "SAHS", style2);		
		createCell(row, cont++, "INS. RENAL", style2);
		createCell(row, cont++, "NEOPLASIA", style2);	
		createCell(row, cont++, "FA", style2);
		createCell(row, cont++, "TRANSPLANTE CARDIACO", style2);
		createCell(row, cont++, "PARADA CARDIACA", style2);
		createCell(row, cont++, "SINCOPE", style2);
		createCell(row, cont++, "MP DEPENDIENTE", style2);
		createCell(row, cont++, "MODO", style2);
		createCell(row, cont++, "FREC.BASICA", style2);
		createCell(row, cont++, "SEG.REMOTO", style2);
		createCell(row, cont++, "MIN.ESTIM.VENTRICULAR", style2);
		createCell(row, cont++, "IAV DETECTADO", style2);
		createCell(row, cont++, "IAV ESTIMULADO", style2);
		createCell(row, cont++, "IAV MAX.", style2);
		createCell(row, cont++, "IAV MIN.", style2);
		createCell(row, cont++, "FREC.MAX", style2);
		createCell(row, cont++, "FREC.MIN", style2);
		createCell(row, cont++, "HISTERESIS", style2);
		createCell(row, cont++, "NUM.EPISODIOS TSV", style2);
		createCell(row, cont++, "NUM.EPISODIOS TV", style2);
		createCell(row, cont++, "NUM.EPISODIOS FV", style2);
		createCell(row, cont++, "NUM.EPISODIOS NO SOST.", style2);
		createCell(row, cont++, "NUM.EPISODIOS NO ESP.", style2);
		createCell(row, cont++, "ALG.PREVENCION FA", style2);
		createCell(row, cont++, "FECHA ALTA", style2);
		createCell(row, cont++, "PRIMER OPERADOR", style2);
		createCell(row, cont++, "SEGUNDO OPERADOR", style2);
		//createCell(row, cont++, "NUM. PROCEDIMIENTO", style2);
		
	}
	private static void creaCabecerasImpDESF(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de IMPLANTE 
		Row row = sheetIMPDESF.createRow((short) 0);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "FECHA PROCEDIMIENTO", style2);
		createCell(row, cont++, "TIPO PROCEDIMIENTO", style2);
		createCell(row, cont++, "MODELO", style2);
		createCell(row, cont++, "NUM. SERIE", style2);
		createCell(row, cont++, "FABRICANTE", style2);
		createCell(row, cont++, "LOCALIZACION", style2);
		
		createCell(row, cont++, "TIPO INDICACION", style2);
		createCell(row, cont++, "IMPLANTADOR", style2);
		createCell(row, cont++, "ENFERMERIA", style2);
		createCell(row, cont++, "PRIMER OPERADOR", style2);
		createCell(row, cont++, "SEGUNDO OPERADOR", style2);
		createCell(row, cont++, "PRIORIDAD", style2);
		createCell(row, cont++, "LUGAR IMPLANTE", style2);
		createCell(row, cont++, "TIPO ANESTESIA", style2);
		createCell(row, cont++, "TIEMPO ESCOPIA(min)", style2);
		createCell(row, cont++, "HORA LLEGADA", style2);
		createCell(row, cont++, "HORA INICIO", style2);
		createCell(row, cont++, "HORA FIN", style2);
		createCell(row, cont++, "HORA SALIDA", style2);
		createCell(row, cont++, "TESTIND ENERGIA", style2);
		createCell(row, cont++, "TESTIND IMP_CHOQUE", style2);
		createCell(row, cont++, "TESTIND NUM.CHOQUES", style2);
		
		//Cabeceras de indicacion
		row = sheetIMPDESF_IND.createRow((short) 0);
		cont = 0;
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "RITMO", style2);
		createCell(row, cont++, "CONDUCCION AV", style2);
		createCell(row, cont++, "QRS", style2);
		createCell(row, cont++, "FEVI(%)", style2);
		createCell(row, cont++, "FUNCION VENTRICULAR", style2);
		createCell(row, cont++, "NYHA", style2);
		createCell(row, cont++, "CARDIOPATIA", style2);
		createCell(row, cont++, "A.EVOLUCION", style2);
		createCell(row, cont++, "REVASCULARIZACION PREVIA", style2);
		createCell(row, cont++, "INFARTO PREVIO", style2);
		createCell(row, cont++, "INS. RENAL", style2);
		createCell(row, cont++, "DIABETES", style2);
		createCell(row, cont++, "FA", style2);
		createCell(row, cont++, "HIPERTENSION", style2);
		createCell(row, cont++, "MUERTE SUBITA FAM.", style2);
		createCell(row, cont++, "TABAQUISMO", style2);
		createCell(row, cont++, "HIPERCOLESTEROLEMIA", style2);
		createCell(row, cont++, "ACV", style2);
		createCell(row, cont++, "TRANSPLANTE CARDIACO", style2);
		createCell(row, cont++, "AIT", style2);
		createCell(row, cont++, "SINCOPE", style2);
		createCell(row, cont++, "PARADA CARDIACA", style2);
		createCell(row, cont++, "EPOC", style2);
		createCell(row, cont++, "SAHS", style2);
		createCell(row, cont++, "AFEC. TIROIDEA", style2);
		createCell(row, cont++, "NEUROLOGICOS", style2);
		
		//Cabeceras de evolucion
		row = sheetIMPDESF_EV.createRow((short) 0);
		cont = 0;
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "MP DEPENDIENTE", style2);
		createCell(row, cont++, "MODO", style2);
		createCell(row, cont++, "FREC.BASICA", style2);
		createCell(row, cont++, "SEG.REMOTO", style2);
		createCell(row, cont++, "MIN.ESTIM.VENTRICULAR", style2);
		createCell(row, cont++, "IAV DETECTADO", style2);
		createCell(row, cont++, "IAV ESTIMULADO", style2);
		createCell(row, cont++, "IAV MAX.", style2);
		createCell(row, cont++, "IAV MIN.", style2);
		createCell(row, cont++, "EST. POST CHOQUE AMPLITUD", style2);
		createCell(row, cont++, "EST. POST CHOQUE FRECUENCIA", style2);
		createCell(row, cont++, "EST. POST CHOQUE DUR.PULSO", style2);
		createCell(row, cont++, "EST. POST CHOQUE DURACION", style2);
		createCell(row, cont++, "CONFIGURACION CHOQUE", style2);
		createCell(row, cont++, "FREC.MAX", style2);
		createCell(row, cont++, "FREC.MIN", style2);
		createCell(row, cont++, "HISTERESIS", style2);
		createCell(row, cont++, "ALG.PREVENCION FA", style2);
		
		createCell(row, cont++, "NUM.TOTAL EPISODIOS", style2);
		createCell(row, cont++, "NUM.EPISODIOS TSV", style2);
		createCell(row, cont++, "NUM.EPISODIOS TV", style2);
		createCell(row, cont++, "NUM.EPISODIOS FV", style2);
		createCell(row, cont++, "NUM.EPISODIOS NO SOSTENIDOS", style2);
		createCell(row, cont++, "NUM.EPISODIOS NO ESPECIFICADOS", style2);
		createCell(row, cont++, "NUM. TERAPIAS ATP", style2);
		createCell(row, cont++, "TERAPIAS ATP TODAS EFECTIVAS", style2);
		createCell(row, cont++, "NUM. TERAPIAS CHOQUE", style2);
		createCell(row, cont++, "TERAPIAS CHOQUE TODAS EFECTIVAS", style2);
		createCell(row, cont++, "ULTIMO CHOQUE ENERGIA", style2);
		createCell(row, cont++, "ULTIMO CHOQUE TIEMPO CARGA", style2);
		createCell(row, cont++, "ULTIMO CHOQUE IMP.CHOQUE", style2);
		
		createCell(row, cont++, "FECHA ALTA", style2);
		createCell(row, cont++, "MOTIVO ALTA", style2);
		
	}
	private static void creaCabecerasReg(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de Registrador de Eventos 
		Row row = sheetREG.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		//createCell(row, cont++, "SEXO", style);
		//createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		//createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "NUM_PROC", style2);
		createCell(row, cont++, "FECHA PROCEDIMIENTO", style2);
		
		createCell(row, cont++, "REFERIDOR", style2);
		createCell(row, cont++, "OPERADOR MEDICO", style2);
		createCell(row, cont++, "ENFERMERIA", style2);
		createCell(row, cont++, "INDICACION", style2);	
		createCell(row, cont++, "INDICACION SINCOPE", style2);
		
		createCell(row, cont++, "MODELO", style2);
		createCell(row, cont++, "NUM.SERIE", style2);
		createCell(row, cont++, "ZONA IMPLANTE", style2);	
		createCell(row, cont++, "FECHA EXPLANTE", style2);
		createCell(row, cont++, "DIAGNOSTICO EXPLANTE", style2);
		createCell(row, cont++, "OPERADOR EXPLANTE", style2);
		createCell(row, cont++, "ENFERMERIA EXPLANTE", style2);
	}
	private static void creaCabecerasMesas(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de Mesa Basculante 
		Row row = sheetMESA.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		//createCell(row, cont++, "SEXO", style);
		//createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		//createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "NUM_PROC", style2);
		createCell(row, cont++, "FECHA PROCEDIMIENTO", style2);
		
		createCell(row, cont++, "REFERIDOR", style2);
		createCell(row, cont++, "OPERADOR MEDICO", style2);
		createCell(row, cont++, "ENFERMERIA", style2);
		createCell(row, cont++, "NTG SUBLINGUAL", style2);
		createCell(row, cont++, "INDICACION", style2);	
		createCell(row, cont++, "EPISODIOS PRESINCOPALES PREVIOS", style2);
		createCell(row, cont++, "EPISODIOS SINCOPALES 2 AÑOS ATRAS", style2);
		createCell(row, cont++, "RESULTADO", style2);
		//createCell(row, cont++, "RESPUESTA", style2);
		createCell(row, cont++, "TIPO", style2);
		createCell(row, cont++, "TIEMPO ASISTOLIA VENTRICULAR", style2);
		createCell(row, cont++, "BLOQUEO AV", style2);
		createCell(row, cont++, "CARDIOPATIA", style2);
		
	}
	private static void creaCabecerasHol(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de Holter 24h
		Row row = sheetHOLTER.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		//createCell(row, cont++, "SEXO", style);
		//createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		//createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "FECHA PROCEDIMIENTO", style2);
		createCell(row, cont++, "FECHA COLOCACION", style2);
		createCell(row, cont++, "FECHA LECTURA", style2);
		createCell(row, cont++, "FECHA RETIRADA", style2);
		createCell(row, cont++, "FECHA ANALISIS", style2);
		createCell(row, cont++, "ESTADO", style2);
		createCell(row, cont++, "COMENTARIOS COLOCACION", style2);
		createCell(row, cont++, "COMENTARIOS ANALISIS", style2);
		createCell(row, cont++, "RECOMENDACIONES", style2);
		createCell(row, cont++, "DIAGNOSTICO INICIAL", style2);
		createCell(row, cont++, "DIAGNOSTICO INICIAL OTRO", style2);
		createCell(row, cont++, "DIGANOSTICO FINAL", style2);
		createCell(row, cont++, "DIAGNOSTICO FINAL OTRO", style2);
		createCell(row, cont++, "REFERIDOR", style2);
		createCell(row, cont++, "OPERADOR ENFERMERIA COLOCACION", style2);
		createCell(row, cont++, "OPERADOR MEDICO COLOCACION", style2);
		createCell(row, cont++, "OPERADOR MEDICO ANALISIS", style2);
		createCell(row, cont++, "OPERADOR MEDICO RETIRADA", style2);
		createCell(row, cont++, "OPERADOR ENFERMERIA RETIRADA", style2);
		createCell(row, cont++, "NUMERO PROCEDIMIENTO", style2);
	}
	private static void creaCabecerasRegEvExt(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de Registrador de Eventos Externo
		Row row = sheetREGEVEXT.createRow((short) 0);
		createCell(row, cont++, "CIP", style);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		//createCell(row, cont++, "SEXO", style);
		//createCell(row, cont++, "HOSPI_PROCEDENCIA", style);
		//createCell(row, cont++, "CARACTER_PROCEDENCIA", style);
		createCell(row, cont++, "FECHA PROCEDIMIENTO", style2);
		createCell(row, cont++, "FECHA COLOCACION", style2);
		createCell(row, cont++, "FECHA LECTURA", style2);
		createCell(row, cont++, "FECHA RETIRADA", style2);
		createCell(row, cont++, "FECHA ANALISIS", style2);
		createCell(row, cont++, "ESTADO", style2);
		createCell(row, cont++, "COMENTARIOS COLOCACION", style2);
		createCell(row, cont++, "COMENTARIOS ANALISIS", style2);
		createCell(row, cont++, "RECOMENDACIONES", style2);
		createCell(row, cont++, "DIAGNOSTICO INICIAL", style2);
		createCell(row, cont++, "DIAGNOSTICO INICIAL OTRO", style2);
		createCell(row, cont++, "DIGANOSTICO FINAL", style2);
		createCell(row, cont++, "DIAGNOSTICO FINAL OTRO", style2);
		createCell(row, cont++, "REFERIDOR", style2);
		createCell(row, cont++, "OPERADOR ENFERMERIA COLOCACION", style2);
		createCell(row, cont++, "OPERADOR MEDICO COLOCACION", style2);
		createCell(row, cont++, "OPERADOR MEDICO ANALISIS", style2);
		createCell(row, cont++, "OPERADOR MEDICO RETIRADA", style2);
		createCell(row, cont++, "OPERADOR ENFERMERIA RETIRADA", style2);
		createCell(row, cont++, "NUMERO PROCEDIMIENTO", style2);
	}

	private static void creaCabecerasPat(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de Exportacion de Consulta de pacientes-Procedimientos
		Row row = sheetPAT.createRow((short) 0);
		createCell(row, cont++, "NHC", style);
		createCell(row, cont++, "NOMBRE", style);
		createCell(row, cont++, "APELLIDO1", style);
		createCell(row, cont++, "APELLIDO2", style);
		createCell(row, cont++, "TIPO_PROCEDIMIENTO", style);
		createCell(row, cont++, "FECHA_PROCEDIMIENTO", style);
	}
	
	private static void creaCabecerasRegNalDAI(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		//cabecera de Exportacion de Consulta de pacientes-Procedimientos
		Row row = sheetRegNalDAI.createRow((short) 0);
		createCell(row, cont++, "FECHA_NACIMIENTO", style);
		createCell(row, cont++, "EDAD", style);
		createCell(row, cont++, "SEXO", style);
		createCell(row, cont++, "SEG", style);
		createCell(row, cont++, "POBLACION", style);
		createCell(row, cont++, "HOSPITAL_IMPLANTE", style);
		createCell(row, cont++, "HOSPITAL_PROCEDENCIA", style);
		createCell(row, cont++, "HOSPITAL_CIUDAD", style);
		createCell(row, cont++, "CARDIOPATIA", style);
		createCell(row, cont++, "CARDIOPATIA_OTRA", style);
		createCell(row, cont++, "ANOS_EVOLUCION", style);
		createCell(row, cont++, "REVASCULARIZACION", style);
		createCell(row, cont++, "INFARTO_PREVIO", style);
		createCell(row, cont++, "ANIO", style);
		createCell(row, cont++, "FRACCION_EYECCION", style);
		createCell(row, cont++, "IC", style);
		createCell(row, cont++, "ENF_CONDUCCION", style);
		createCell(row, cont++, "RITMO_BASAL", style);
		createCell(row, cont++, "RITMO_BASAL_OTRO", style);
		createCell(row, cont++, "INSUF_RENAL", style);
		createCell(row, cont++, "FA", style);
		createCell(row, cont++, "DIABETES", style);
		createCell(row, cont++, "HTA", style);
		createCell(row, cont++, "MUERTE_SUBITA", style);
		createCell(row, cont++, "ANCHURA_QRS", style);
		createCell(row, cont++, "FUMADOR", style);
		createCell(row, cont++, "HIPERCOLESTEROLEMIA", style);
		createCell(row, cont++, "ACV", style);
		createCell(row, cont++, "ARRITMIA_CLINICA", style);
		createCell(row, cont++, "PRESENTACION_CLINICA", style);
		createCell(row, cont++, "PRESENTACION_CLINICA_OTROS", style);
		createCell(row, cont++, "EEF", style);
		createCell(row, cont++, "EEF_ARRITMIA", style);
		createCell(row, cont++, "PREVENCION", style);
		createCell(row, cont++, "FECHA_IMPLANTE", style);
		createCell(row, cont++, "LUGAR_IMPLANTE", style);
		createCell(row, cont++, "IMPLANTADOR", style);
		createCell(row, cont++, "TIPO_PROCEDIMIENTO", style);
		createCell(row, cont++, "MODELO_GENERADOR", style);
		createCell(row, cont++, "NUM_SERIE_GENERADOR", style);
		createCell(row, cont++, "LOCALIZACION_GENERADOR", style);
		createCell(row, cont++, "FECHA_IMPLANTE_PREVIO", style);
		createCell(row, cont++, "MOTIVOS_RECAMBIO_AGOT", style);
		createCell(row, cont++, "MOTIVOS_RECAMBIO_COMPL", style);
		createCell(row, cont++, "MOTIVOS_RECAMBIO_UPGRADE", style);
		createCell(row, cont++, "EPISODIOS_TVFV", style);
		createCell(row, cont++, "TERAPIA_ATP", style);
		createCell(row, cont++, "TERAPIA_CHOQUE", style);
		createCell(row, cont++, "ELECTRODO_AD", style);
		createCell(row, cont++, "ELECTRODO_AD_MODELO", style);
		createCell(row, cont++, "ELECTRODO_AD_NUM_SERIE", style);
		createCell(row, cont++, "ELECTRODO_VD", style);
		createCell(row, cont++, "ELECTRODO_VD_MODELO", style);
		createCell(row, cont++, "ELECTRODO_VD_NUM_SERIE", style);
		createCell(row, cont++, "ELECTRODO_VI", style);
		createCell(row, cont++, "ELECTRODO_VI_MODELO", style);
		createCell(row, cont++, "ELECTRODO_VI_NUM_SERIE", style);
		createCell(row, cont++, "ELECTRODOS_PREVIOS_FUNC", style);
		createCell(row, cont++, "ELECTRODOS_PREVIOS_DISFUNC", style);
		createCell(row, cont++, "ELECTRODOS_PREVIOS_DISFUNC_ABAND", style);
		createCell(row, cont++, "ELECTRODOS_PREVIOS_DISFUNC_EXPL", style);
		createCell(row, cont++, "INDUCCION", style);
		createCell(row, cont++, "INDUCCION_ENERGIA", style);
		createCell(row, cont++, "INDUCCION_NCHOQUES", style);
		createCell(row, cont++, "COMPLICACION_NINGUNA", style);
		createCell(row, cont++, "COMPLICACION_MUERTE", style);
		createCell(row, cont++, "COMPLICACION_TAP_CARDIACO", style);
		createCell(row, cont++, "COMPLICACION_NEUMOTORAX", style);
		createCell(row, cont++, "COMPLICACION_DISECCION_SC", style);
		createCell(row, cont++, "COMPLICACION_SITUACION_SUBOPTIMA_VI", style);
		createCell(row, cont++, "COMPLICACION_OTRA", style);
		createCell(row, cont++, "ESTIM_ANTIBRADI", style);
		createCell(row, cont++, "ALGORITMO_PREV_EST_VENT", style);
		createCell(row, cont++, "MODELO_ATP_PROG", style);
		createCell(row, cont++, "MODELO", style);
	}
	
	private static void creaCabecerasMatGen(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		// Cabecera de Material - Generador
		Row row = sheetMatGen.createRow((short) 0);
		createCell(row, cont++, "MODELO", style);
		createCell(row, cont++, "FABRICANTE", style);
		createCell(row, cont++, "TIPO", style);
		createCell(row, cont++, "MODO", style);
		createCell(row, cont++, "CONECTOR_AD", style);
		createCell(row, cont++, "CONECTOR_VD", style);
		createCell(row, cont++, "CONECTOR_VI", style);
		createCell(row, cont++, "RF", style);
		createCell(row, cont++, "MRI", style);
		createCell(row, cont++, "REFERENCIA", style);
		createCell(row, cont++, "CONECTOR_VD2", style);
		createCell(row, cont++, "CONECTOR_VCS", style);
		createCell(row, cont++, "ID_RX", style);
		createCell(row, cont++, "ACTIVO", style);
		createCell(row, cont++, "CODIGO_GS1-128", style2);		
	}
	private static void creaCabecerasMatEle(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		// Cabecera de Material - Electrodos
		Row row = sheetMatEle.createRow((short) 0);
		createCell(row, cont++, "MODELO", style);
		createCell(row, cont++, "FABRICANTE", style);
		createCell(row, cont++, "POLARIDAD", style);
		createCell(row, cont++, "FIJACION", style);
		createCell(row, cont++, "BOBINA", style);
		createCell(row, cont++, "CONECTOR", style);
		createCell(row, cont++, "REFERENCIA", style);
		createCell(row, cont++, "ACTIVO", style);
		createCell(row, cont++, "CODIGO_GS1-128", style2);		
	}
	private static void creaCabecerasMatCat(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		// Cabecera de Material - Cateter
		Row row = sheetMatCat.createRow((short) 0);
		createCell(row, cont++, "MODELO", style);
		createCell(row, cont++, "FABRICANTE", style);
		createCell(row, cont++, "REFERENCIA", style);
		createCell(row, cont++, "TIPO", style);
		createCell(row, cont++, "DISTANCIA_ELECTRODOS", style);
		createCell(row, cont++, "NUMERO_ELECTRODOS", style);
		createCell(row, cont++, "TIPO_CATETER_ABLACION", style);
		createCell(row, cont++, "TIPO_CATETER_DIAGNOSTICO", style);
		createCell(row, cont++, "CURVA", style);
		createCell(row, cont++, "TAMANIO", style);
		createCell(row, cont++, "LONGITUD", style);
		createCell(row, cont++, "ENERGIA", style);
		createCell(row, cont++, "ACTIVO", style);
		createCell(row, cont++, "CODIGO_GS1-128", style2);		
	}
	private static void creaCabecerasMatRegEv(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		// Cabecera de Material - Registrador de eventos
		Row row = sheetMatReg.createRow((short) 0);
		createCell(row, cont++, "MODELO", style);
		createCell(row, cont++, "FABRICANTE", style);
		createCell(row, cont++, "REFERENCIA", style);
		createCell(row, cont++, "RF", style);
		createCell(row, cont++, "MRI", style);
		createCell(row, cont++, "ACTIVO", style);
		createCell(row, cont++, "CODIGO_GS1-128", style2);		
	}
	private static void creaCabecerasRecalls(Workbook wb){
		CellStyle style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(CellStyle.BORDER_THICK);
		style.setBorderTop(CellStyle.BORDER_THICK);
		style.setLocked(true);
		CellStyle style2 = wb.createCellStyle();
		style2.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
		style2.setFillPattern(CellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(CellStyle.BORDER_THICK);
		style2.setBorderTop(CellStyle.BORDER_THICK);
		style2.setLocked(true);
		Font font = wb.createFont();
		font.setFontName("Courier New");
		font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setColor(IndexedColors.WHITE.getIndex());
		style.setFont(font);
		
		Integer cont = 0;
		// Cabecera de alertas de seguridad
		Row row = sheetRecalls.createRow((short) 0);
		createCell(row, cont++, "MODELO", style);
		createCell(row, cont++, "NUM.SERIE", style);
		createCell(row, cont++, "FABRICANTE", style);
		createCell(row, cont++, "FECHA_PROCEDIMIENTO", style);
		createCell(row, cont++, "NHC", style);
	}
	private static void rellenaPacientes(List<Map> paciente){
		//hoja de pacientes
		for (int i = 0; i < paciente.size(); i++) {
			Row row = sheetPacientes.createRow((short) i+1);
			Map pac = paciente.get(i);
			//Double a = new Double((Double) ToString(pac.get("codigo"));
			Date d;
			//En TOMCAT
			try{
				d = (Date) pac.get("NACIMIENTO");
			}catch (Exception e) {
				//En WebLogic
				GregorianCalendar cal = (GregorianCalendar) pac.get("NACIMIENTO");
				d = cal.getTime();
			}
			createCell(row, 0, ToString(pac.get("NHC")), null);
			createCell(row, 1, UtilFechas.getFechaStringFormato(d,"dd-MM-yyyy"), null);
			createCell(row, 2, ""+UtilFechas.getEdad(d), null);
			createCell(row, 3, pac.get("SEXO")!=null?ToString(pac.get("SEXO")).startsWith("1")?"H":"M":"", null);
			createCell(row, 4, ToString(pac.get("HOSPITAL_PROCEDENCIA")), null);
			createCell(row, 5, ToString(pac.get("CARACTER_PROCEDENCIA")), null);
			String cardio = ToString(pac.get("CARDIOPATIA"));
			if(cardio != null && cardio.startsWith("2")){
				switch (new Double(ToString(pac.get("TIPO_CARDIOPATIA"))).intValue()) {
				case 1:
					cardio = "ISQUÉMICA";
					break;
				case 2:
					cardio = "DILATADA";
					break;
				case 3:
					cardio = "SOSPECHA TAQUIMIOPATÍA";
					break;
				case 4:
					cardio = "HIPERTRÓFICA";
					break;
				case 5:
					cardio = "DISPLASIA VD";
					break;
				case 6:
					cardio = "NO COMPACTADA";
					break;
				case 7:
					cardio = "CONGÉNITA";
					break;
				case 8:
					cardio = "CIRUGÍA CARDIACA PREVIA";
					break;
				case 9:
					cardio = "VALVULAR";
					break;
				case 10:
					cardio = ToString(pac.get("OTRAS_CARDIOPATIAS"));
					break;
				default:
					cardio = "";
					break;
				}
				createCell(row, 6, cardio, null);
			}else{
				createCell(row, 6, "NO", null);
			}
			createCell(row, 7, ToString(pac.get("FEVI")), null);
			createCell(row, 8, ToString(pac.get("FUNCION_VENTRICULAR")), null);
			createCell(row, 9, pac.get("FACT_HTA")!=null?ToString(pac.get("FACT_HTA")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 10, pac.get("FACT_DISLIPEMIA")!=null?ToString(pac.get("FACT_DISLIPEMIA")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 11, pac.get("FACT_DIABETES")!=null?ToString(pac.get("FACT_DIABETES")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 12, pac.get("FACT_TABAQUISMO")!=null?ToString(pac.get("FACT_TABAQUISMO")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 13, pac.get("ANT_ACV")!=null?ToString(pac.get("ANT_ACV")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 14, pac.get("ANT_INSUF")!=null?ToString(pac.get("ANT_INSUF")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 15, pac.get("ANT_SAOS")!=null?ToString(pac.get("ANT_SAOS")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 16, pac.get("ANT_TIROIDEA")!=null?ToString(pac.get("ANT_TIROIDEA")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 17, pac.get("FIBRI_AURICU")!=null?ToString(pac.get("FIBRI_AURICU")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 18, pac.get("ARR_VENT_SOS")!=null?ToString(pac.get("ARR_VENT_SOS")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 19, pac.get("INS_CAR")!=null?ToString(pac.get("INS_CAR")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 20, pac.get("SINCOPE")!=null?ToString(pac.get("SINCOPE")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 21, pac.get("PARADA_CARD")!=null?ToString(pac.get("PARADA_CARD")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 22, pac.get("CV")!=null?ToString(pac.get("CV")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 23, pac.get("PORTADORDAI")!=null?ToString(pac.get("PORTADORDAI")).startsWith("0")?"NO":"SI":"", null);
			createCell(row, 24, pac.get("PORTADORMP")!=null?ToString(pac.get("PORTADORMP")).startsWith("0")?"NO":"SI":"", null);
		}
	}
	
	private static void rellenaEstudio(ArrayList<ArrayList<Object>> eef){
		try {
			ArrEstudioDao estudiodao = new ArrEstudioDaoImpl("consulta");
			//hoja de estudios
			int conteef = 0;
			for (ArrayList<Object> obj: eef) {
				Row row = sheetEEF.createRow((short) conteef+1);
				createCell(row, 0, ToString(obj.get(0)), null);
				createCell(row, 1, UtilFechas.dateToString((Date) obj.get(1)), null);
				createCell(row, 2, ToString(obj.get(2)), null);
				createCell(row, 3, ToString(obj.get(13)), null);
				String idproc = ToString(obj.get(3));
				if(idproc.startsWith("1")) idproc = "PRIMERO";
				else idproc = "N-" + ToInteger(ToString(obj.get(4)));
				createCell(row, 4, idproc, null);
				String motivo = ToString(obj.get(5));
				if(!motivo.equals("")){
					switch (ToInteger(motivo)) {
					case 1:
						motivo = "RECURRENCIA MISMO SUSTRATO";
						break;
					case 2:
						motivo = "INEFICACIA ABLACION PREVIA";
						break;
					case 3:
						motivo = "OTRO SUSTRATO";
						break;
					case 4:
						motivo = "EEF PREVIO SIN ABLACION";
						break;
					default:
						break;
					}
				}
				createCell(row, 5, motivo, null);
				createCell(row, 6, ToString(obj.get(6)), null);
				
				ArrayList<ArrayList<Object>> pops = estudiodao.getPops(ToInteger(ToString(obj.get(24))));
				ArrayList<ArrayList<Object>> sops = estudiodao.getSops(ToInteger(ToString(obj.get(24))));
				
				createCell(row, 7, ToString(pops.get(0).get(0)), null);
				createCell(row, 8, ToString(sops.get(0).get(0)), null);
				
				createCell(row, 9, obj.get(7)!=null?ToString(obj.get(7)).startsWith("0")?"NO":"SI":"", null);
				createCell(row, 10, ToString(obj.get(8)).startsWith("0")?"NO":ToString(obj.get(8)).startsWith("1")?"CARTO":"NAVX", null);
				createCell(row, 11, obj.get(9)!=null?ToString(obj.get(9)).startsWith("0")?"NO":"SI":"", null);
				createCell(row, 12, obj.get(10)!=null?ToString(obj.get(10)).startsWith("1")?"NO":"SI":"", null);
				createCell(row, 13, ToString(obj.get(11)), null);
				createCell(row, 14, ToString(obj.get(12)), null);
				
				String t1,t2,t3,t4,t5;
				t1 = ToString(obj.get(14));
				t2 = ToString(obj.get(15));
				t3 = ToString(obj.get(16));
				t4 = ToString(obj.get(17));
				t5 = ToString(obj.get(18));
				createCell(row, 15, getDuracion(t1,t5), null);
				createCell(row, 16, getDuracion(t1,t2), null);
				createCell(row, 17, getDuracion(t2,t3), null);
				createCell(row, 18, getDuracion(t3,t4), null);
				createCell(row, 19, getDuracion(t4,t5), null);
				createCell(row, 20, ToString(obj.get(19)), null);
				createCell(row, 21, obj.get(20)!=null?ToString(obj.get(20)).startsWith("0")?"NO":"SI":"", null);
				createCell(row, 22, ToString(obj.get(21)), null);
				
				String comp = ToString(obj.get(22));
				switch(ToInteger(comp)){
				case 1:
					comp = "BLOQUEO AV";
					break;
				case 2:
					comp = "EMBOLISMO";
					break;
				case 3:
					comp = "DERRAME PERICARDICO";
					break;
				case 4:
					comp = "TEP";
					break;
				case 5:
					comp = "VASCULARES";
					break;
				case 6:
					comp = "OTRAS";
					break;
				case 7:
					comp = "BLOQUEO MECANICO RAMA DERECHA";
					break;
				case 8:
					comp = "BLOQUEO MECANICO RAMA IZQUIERDA";
					break;
				default:
					comp = "";
				}
				createCell(row, 23, comp, null);
				createCell(row, 24, obj.get(23)!=null?ToString(obj.get(23)).startsWith("0")?"NO":"SI":"", null);
				conteef++;
			}
		} catch (ArrEstudioDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rellenaVias(ArrayList<ArrayList<Object>> va){
		//hoja de vias accesorias
		int contva = 0;
		for (ArrayList<Object> obj: va) {
			Row row = sheetVA.createRow((short) contva+1);
			createCell(row, 0, ToString(obj.get(0)), null);
			createCell(row, 1, ToString(obj.get(1)), null);
			createCell(row, 2, ToString(obj.get(2)), null);
			createCell(row, 3, ToString(obj.get(3)), null);
			String loc1 = ToString(obj.get(4));
			String loc2 = ToString(obj.get(5));
			String[] locs;
			
			switch (loc1.equals("")?0:ToInteger(loc1)) {
				case 1:
					loc1 = "PARED LIBRE IZQUIERDA";
					if(loc2.length() > 0){
						locs = loc2.split(",");
						for(int i=0;i<locs.length;i++)
							switch (new Integer(locs[i])) {
							case 1:
								loc1 += " - POSTERIOR"; 
								break;
							case 2:
								loc1 += " - SUPERIOR"; 
								break;
							case 3:
								loc1 += " - INFERIOR"; 
								break;
							default:
								break;
						}
					}
					break;
				case 2:
					loc1 = "PARED LIBRE DERECHA";
					if(loc2.length() > 0){
						locs = loc2.split(",");
						for(int i=0;i<locs.length;i++)
							switch (new Integer(locs[i])) {
							case 1:
								loc1 += " - ANTERIOR"; 
								break;
							case 2:
								loc1 += " - SUPERIOR"; 
								break;
							case 3:
								loc1 += " - INFERIOR"; 
								break;
							default:
								break;
						}
					}
					break;
				case 3:
					loc1 = "SEPTAL";
					switch (loc2.equals("")?0:ToInteger(loc2)) {
					case 1:
						loc1 += " - IZQUIERDA INFERIOR";
						break;
					case 2:
						loc1 += " - DERECHA SUPERIOR";
						break;
					case 3:
						loc1 += " - DERECHA PERIHIS";
						break;
					case 4:
						loc1 += " - DERECHA MEDIOSEPTAL";
						break;
					case 5:
						loc1 += " - DERECHA INFERIOR";
						break;
					}
					break;
				case 4:
					loc1 = "EPICARDICA";
					switch (loc2.equals("")?0:ToInteger(loc2)) {
					case 1:
						loc1 += " - SENO CORONARIO";
						break;
					case 2:
						loc1 += " - DIVERTICULO SC";
						break;
					}
					break;
				default:
					loc1 = "";
					break;
				}
			createCell(row, 4, loc1, null);
			contva++;
		}
	}
	
	private static void rellenaTaquicardias(ArrayList<ArrayList<Object>> taq){
		//hoja de taquicardias
		int conttaq = 0;
		for (ArrayList<Object> obj: taq) {
			Row row = sheetTAQ.createRow((short) conttaq+1);
			createCell(row, 0, ToString(obj.get(0)), null);
			createCell(row, 1, ToString(obj.get(1)), null);
			createCell(row, 2, ToString(obj.get(2)), null);
			createCell(row, 3, ToString(obj.get(3)), null);
			createCell(row, 4, ToString(obj.get(4)), null);
			
			String induccion = ToString(obj.get(5));
			Integer tipoInduccion = induccion.equals("")?0:ToInteger(induccion); 
			switch (tipoInduccion) {
				case 1:
					induccion = "NO INTENTADA";
					break;
				case 2:
					induccion = "NO INDUCIBLE";
					break;
				case 3:
					induccion = "INDUCIBLE";
					break;
				case 4:
					induccion = "ESPONTANEA";
					break;
				default:
					induccion = "";
					break;
				}
			createCell(row, 5, induccion, null);
			
			String clinica = ToString(obj.get(6));
			if(ToString(clinica).equals("1")) clinica = "CLINICA";
			else if(ToString(clinica).equals("2")) clinica = "NO CLINICA";
			else clinica = "";
			
			String comportamiento = ToString(obj.get(7));
			if(ToString(comportamiento).equals("1")) comportamiento = "SOSTENIDA";
			else if(ToString(comportamiento).equals("2")) comportamiento = "NO SOSTENIDA";
			else if(ToString(comportamiento).equals("3")) comportamiento = "EXTRASISTOLICA";
			else if(ToString(comportamiento).equals("4")) comportamiento = "INCESANTE";
			else comportamiento = "";
			
			String tipo = ToString(obj.get(8));
			if(ToString(tipo).equals("1")) tipo = "INTRANODAL";
			else if(ToString(tipo).equals("2")) tipo = "VIA ACCESORIA";
			else if(ToString(tipo).equals("3")) tipo = "AURICULAR FOCAL";
			else if(ToString(tipo).equals("4")) tipo = "FLUTER AURICULAR/TA MACRORREENTRANTE";
			else if(ToString(tipo).equals("5")) tipo = "FIBRILACION AURICULAR";
			else if(ToString(tipo).equals("6")) tipo = "NO PAROXISTICA DE LA UNION AV";
			else if(ToString(tipo).equals("7")) tipo = "VENTRICULAR";
			else if(ToString(tipo).equals("8")) tipo = "FIBRILACION VENTRICULAR";
			else tipo = "";
			
			if(tipoInduccion == 3 || tipoInduccion == 4){
				createCell(row, 6, clinica, null);
				createCell(row, 7, comportamiento, null);
				createCell(row, 8, tipo, null);
			}else{
				createCell(row, 6, "", null);
				createCell(row, 7, "", null);
				createCell(row, 8, "", null);
			}
			
			conttaq++;
		}
	}
	
	
	//mmb
	private static void rellenaEstadisticas(ArrayList<DatoEstAnual> datos){
		Integer fila = 1, filapaci = 0, cont = 0;
		
		for(DatoEstAnual dato: datos){
			Row row = sheetCV.createRow(fila);
			//consulta
			createCell(row, cont++, dato.getTipo(), null);
			if (dato.isEsTipoInteger()){
			//meses
				for (int i=0;i<12;i++){
					createCell(row, cont++, new Integer(dato.valor[i]).toString(), null);
				}
			//total
				dato.iniTotal();
				createCell(row, cont++, new Integer(dato.getTotal()).toString(), null);
			}
				
			else {
				//meses
				for (int i=0;i<12;i++){
					createCell(row, cont++, UtilCodifi.formatoFloat(dato.valorf[i]), null);
				}
			//total
				createCell(row, cont++, UtilCodifi.formatoFloat(dato.iniMedia())+" %", null);
			}
			fila++;
			cont = 0;
		}
	}
	
	
	private static void rellenaEEF(List<Map> paciente, ArrayList<ArrayList<Object>> eefs, 
			Integer tipo_ablacion, ArrayList<ArrayList<Object>> resvias, 
			ArrayList<ArrayList<Object>> restaq, List<Map> pacienteVias, List<Map> pacienteTaq,
			ArrayList<ArrayList<Object>> reseefcompabl) throws ArrEstudioDaoException, ArrMaestrasDaoException{
		Integer fila = 1, filapaci = 0, cont = 0;
		ArrEstudioDao estudiodao = new ArrEstudioDaoImpl("consulta");
		
		for(int i= 0; i < eefs.size(); i++){
			Row row = sheetEEF.createRow(fila);
			if(filapaci >= paciente.size())
				filapaci--;
			//Map pac = paciente.get(filapaci++);
			EstadisticaDto pac = (EstadisticaDto) paciente.get(filapaci++);
			//System.out.println(pac.getNHC() +" "+ToString(eefs.get(i).get(0)));
			if(!pac.getNHC().equals(ToString(eefs.get(i).get(0)))){
				filapaci = filapaci - 2;
				pac = (EstadisticaDto) paciente.get(filapaci++);
			}
			Date d;
			//En TOMCAT
			try{
				d = pac.getNACIMIENTO();
			}catch (Exception e) {
				//En WebLogic
				Date cal = pac.getNACIMIENTO();
				d = cal;
			}
			createCell(row, cont++, pac.getNUHSA(), null);
			createCell(row, cont++, pac.getNHC(), null);
			createCell(row, cont++, pac.getNOMBRE(), null);
			createCell(row, cont++, pac.getAP1()!=null?pac.getAP1():"", null);
			createCell(row, cont++, pac.getAP2()!=null?pac.getAP2():"", null);
			createCell(row, cont++, d!=null?UtilFechas.getFechaStringFormato(d,"dd-MM-yyyy"):"", null);
			createCell(row, cont++, ""+(d!=null?UtilFechas.getEdad(d):""), null);
			createCell(row, cont++, pac.getSEXO()!=null?pac.getSEXO().startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, pac.getHOSPITAL_PROCEDENCIA()!=null?pac.getHOSPITAL_PROCEDENCIA():"", null);
			createCell(row, cont++, pac.getCARACTER_PROCEDENCIA()!=null?pac.getCARACTER_PROCEDENCIA():"", null);
			/*String cardio = pac.getCARDIOPATIA();
			if(cardio != null && cardio.startsWith("2")){
				switch (new Double(pac.getTIPO_CARDIOPATIA()).intValue()) {
				case 1:
					cardio = "ISQUÉMICA";
					break;
				case 2:
					cardio = "DILATADA";
					break;
				case 3:
					cardio = "SOSPECHA TAQUIMIOPATÍA";
					break;
				case 4:
					cardio = "HIPERTRÓFICA";
					break;
				case 5:
					cardio = "DISPLASIA VD";
					break;
				case 6:
					cardio = "NO COMPACTADA";
					break;
				case 7:
					cardio = "CONGÉNITA";
					break;
				case 8:
					cardio = "CIRUGÍA CARDIACA PREVIA";
					break;
				case 9:
					cardio = "VALVULAR";
					break;
				case 10:
					cardio = pac.getOTRAS_CARDIOPATIAS();
					break;
				default:
					cardio = "";
					break;
				}
				createCell(row, cont++, cardio, null);
			}else{
				createCell(row, cont++, "NO", null);
			}
			createCell(row, cont++, pac.getFEVI(), null);
			createCell(row, cont++, pac.getFUNCION_VENTRICULAR(), null);
			createCell(row, cont++, pac.getFACT_HTA()!=null?pac.getFACT_HTA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DISLIPEMIA()!=null?pac.getFACT_DISLIPEMIA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DIABETES()!=null?pac.getFACT_DIABETES().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_TABAQUISMO()!=null?pac.getFACT_TABAQUISMO().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_ACV()!=null?pac.getANT_ACV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_INSUF()!=null?pac.getANT_INSUF().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_SAOS()!=null?pac.getANT_SAOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_TIROIDEA()!=null?pac.getANT_TIROIDEA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFIBRI_AURICU()!=null?pac.getFIBRI_AURICU().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getARR_VENT_SOS()!=null?pac.getARR_VENT_SOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getINS_CAR()!=null?pac.getINS_CAR().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getSINCOPE()!=null?pac.getSINCOPE().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPARADA_CARD()!=null?pac.getPARADA_CARD().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getCV()!=null?pac.getCV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORDAI()!=null?pac.getPORTADORDAI().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORMP()!=null?pac.getPORTADORMP().startsWith("0")?"NO":"SI":"", null);
			*/
			//hoja de estudios
			ArrayList<Object> obj = eefs.get(i);
			//createCell(row, cont++, cv.getCodigoPaciente().toString(), null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato((Date) obj.get(1),"dd-MM-yyyy"), null);
			createCell(row, cont++, ToString(obj.get(2)), null);
			createCell(row, cont++, ToString(obj.get(13)), null);
			String idproc = ToString(obj.get(3));
			if(idproc.startsWith("1")) idproc = "PRIMERO";
			else idproc = "N-" + ToInteger(ToString(obj.get(4)));
			createCell(row, cont++, idproc, null);
			String motivo = ToString(obj.get(5));
			if(!motivo.equals("")){
				switch (ToInteger(motivo)) {
				case 1:
					motivo = "RECURRENCIA MISMO SUSTRATO";
					break;
				case 2:
					motivo = "INEFICACIA ABLACION PREVIA";
					break;
				case 3:
					motivo = "OTRO SUSTRATO";
					break;
				case 4:
					motivo = "EEF PREVIO SIN ABLACION";
					break;
				default:
					break;
				}
			}
			createCell(row, cont++, motivo, null);
			createCell(row, cont++, ToString(obj.get(6)), null);
			
			ArrayList<ArrayList<Object>> pops = estudiodao.getPops(ToInteger(ToString(obj.get(24))));
			ArrayList<ArrayList<Object>> sops = estudiodao.getSops(ToInteger(ToString(obj.get(24))));
			
			createCell(row, cont++, ToString(pops.get(0).get(0)), null);
			createCell(row, cont++, ToString(sops.get(0).get(0)), null);
			
			createCell(row, cont++, obj.get(7)!=null?ToString(obj.get(7)).startsWith("0")?"NO":"SI":"", null);
			// NAVEGADOR - mejoras
			ArrMaestrasDao mdao = new ArrMaestrasDaoImpl("consulta");
			String navegador = "";
			if(obj.get(8)!=null && !obj.get(8).equals(-1) && !obj.get(8).equals(0))
				navegador = mdao.findByPrimaryKey((Integer)obj.get(8)).getValor();		
			createCell(row, cont++, (!navegador.toUpperCase().equals("NO"))?(navegador):"", null);
			//createCell(row, cont++, (obj.get(8)!=null && !obj.get(8).equals(-1))?(ToString(obj.get(8)).startsWith("0")?"NO":ToString(obj.get(8)).startsWith("1")?"CARTO":"NAVX"):"", null);
			createCell(row, cont++, obj.get(9)!=null?ToString(obj.get(9)).startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, obj.get(10)!=null?ToString(obj.get(10)).startsWith("1")?"NO":"SI":"", null);
			createCell(row, cont++, ToString(obj.get(11)), null);
			createCell(row, cont++, obj.get(25)!=null?ToString(obj.get(25)).startsWith("1")?"SI":"NO":"", null);
			String robot = ToString(obj.get(26));
			if(!robot.equals("")){
				switch (ToInteger(robot)) {
				case 1:
					robot = "HANSEN";
					break;
				case 2:
					robot = "AMIGO";
					break;
				default:
					robot = "NO";
					break;
				}
			}
			createCell(row, cont++, robot, null);
			createCell(row, cont++, ToString(obj.get(12)), null);
		
			String t1,t2,t3,t4,t5;
			t1 = ToString(obj.get(14));
			t2 = ToString(obj.get(15));
			t3 = ToString(obj.get(16));
			t4 = ToString(obj.get(17));
			t5 = ToString(obj.get(18));
			createCell(row, cont++, getDuracion(t1,t5), null);
			createCell(row, cont++, getDuracion(t1,t2), null);
			createCell(row, cont++, getDuracion(t2,t3), null);
			createCell(row, cont++, getDuracion(t3,t4), null);
			createCell(row, cont++, getDuracion(t4,t5), null);
			createCell(row, cont++, ToString(obj.get(19)), null);
			createCell(row, cont++, obj.get(20)!=null?ToString(obj.get(20)).startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, ToString(obj.get(21)), null);
			
			String comp = ToString(obj.get(22));
			switch(ToInteger(comp)){
			case 1:
				comp = "BLOQUEO AV";
				break;
			case 2:
				comp = "EMBOLISMO";
				break;
			case 3:
				comp = "DERRAME PERICARDICO";
				break;
			case 4:
				comp = "TEP";
				break;
			case 5:
				comp = "VASCULARES";
				break;
			case 6:
				comp = "OTRAS";
				break;
			case 7:
				comp = "BLOQUEO MECANICO RAMA DERECHA";
				break;
			case 8:
				comp = "BLOQUEO MECANICO RAMA IZQUIERDA";
				break;
			default:
				comp = "";
			}
			createCell(row, cont++, comp, null);
			createCell(row, cont++, obj.get(23)!=null?ToString(obj.get(23)).startsWith("0")?"NO":"SI":"", null);
			
			//intento ablacion
			if(tipo_ablacion == 1){
				String n1,n2 = "",n3 = "";
				switch(ToInteger(ToString(obj.get(27)))){
				case 1:
					n1 = "Sustrato no definido";
					break;
				case 2:
					n1 = "Negativa paciente";
					break;
				case 3:
					n1 = "Alto riesgo";
					break;
				case 4:
					n1 = "Ablación diferida";
					break;
				case 5:
					n1 = "Complicación EEF diagnóstico";
					switch(ToInteger(ToString(obj.get(28)))){
					case 1:
						n2 = "Bloqueo mecánico";
						switch(ToInteger(ToString(obj.get(29)))){
						case 1:
							n3 = "Sustrato";
							break;
						case 2:
							n3 = "BAV";
							break;
						default:
							n3 = "";
						}
						break;
					case 2:
						n2 = "Complicación transeptal";
						switch(ToInteger(ToString(obj.get(29)))){
						case 1:
							n3 = "Derrame pericárdico";
							break;
						case 2:
							n3 = "Taponamiento";
							break;
						case 3:
							n3 = "Punción raíz aórtica";
							break;
						case 4:
							n3 = "Otro";
							break;
						default:
							n3 = "";
						}
						break;
					case 3:
						n2 = "Otro";
						break;
					default:
						n2 = "";
					}
					break;
				default:
					n1 = "";
				}
				createCell(row, cont++, n1, null);
				createCell(row, cont++, n2, null);
				createCell(row, cont++, n3, null);
				createCell(row, cont++, ToString(obj.get(30)), null);
			}
			if(tipo_ablacion == 2){
				createCell(row, cont++, ToString(obj.get(27)), null);
				Integer ab = ToInteger(ToString(obj.get(28)));
				String abordaje;
				switch (ab) {
				case 1:
					abordaje = "Venoso femoral"; 
					break;
				case 2:
					abordaje = "Venoso braquial";
					break;
				case 3:
					abordaje = "Venoso yugular/subclavia";
					break;
				case 4:
					abordaje = "Arterial femoral";
					break;
				case 5:
					abordaje = "Foramen ovale";
					break;
				case 6:
					abordaje = "Transeptal";
					break;
				case 7:
					abordaje = "Epicárdico";
					break;
				default:
					abordaje = "";
					break;
				}
				createCell(row, cont++, abordaje, null);
				
				//String energia = ToString(obj.get(29));
				//createCell(row, cont++, energia.equals("0")?"":energia.equals("1")?"Radiofrecuencia":energia.equals("2")?"Crioablación":"Otras", null);
				Integer energia = ToInteger(ToString(obj.get(29)));
				String energia_str="";
				switch (energia){
				case 1:
					energia_str = "RF (4mm)";
					break;
				case 2:
					energia_str = "RF (8mm)";
					break;
				case 3:
					energia_str = "RF (Irrigado estándar)";
					break;
				case 4:
					energia_str = "Crioablación";
					break;
				case 5:
					energia_str = "Criobalón";
					break;
				case 6:
					energia_str = "Laser";
					break;
				case 7:
					energia_str = "RF (10mm)";
					break;
				case 8:
					energia_str = "Otro";
					break;
				case 9:
					energia_str = "RF (Irrigado de contacto)";
					break;
				case 10:
					energia_str = "RF (Circular RF fásica)";
					break;
				case 11:
					energia_str = "RF (Circular RF irrigada)";
					break;
				}
				createCell(row, cont++, energia_str, null);
				
				createCell(row, cont++, ToString(obj.get(30)), null);
				createCell(row, cont++, ToString(obj.get(31)), null);
				createCell(row, cont++, ToString(obj.get(32)), null);
				Integer sustn1 = ToInteger(ToString(obj.get(33)));
				Integer sustn2 = ToInteger(ToString(obj.get(34)));
				Integer exito = ToInteger(ToString(obj.get(36)));
				String sustrato, exitostr = "";
				switch (sustn1) {
				case 1:
					sustrato = "Fibrilación auricular ";
					switch (sustn2) {
					case 1:
						sustrato += "Aurícula izquierda";
						break;
					case 2:
						sustrato += "Aurícula derecha";
						break;
					case 3:
						sustrato += "Ambas";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Aislamiento segmentario";
						break;
					case 2:
						exitostr = " - Aislamiento segmentario - Todas las VVPP";
						break;
					case 3:
						exitostr = " - Aislamiento circunferencial";
						break;
					}
					break;
				case 2:
					sustrato = "Flúter auricular/T. auricular macroreentrante ";
					switch (sustn2) {
					case 1:
						sustrato += "Istmo cavo-tricúspide";
						break;
					case 2:
						sustrato += "Otro istmo AD";
						break;
					case 3:
						sustrato += "Istmo mitral";
						break;
					case 4:
						sustrato += "Otro istmo AI";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Bloqueo bidireccional ICT";
						break;
					case 2:
						exitostr = " - Supresión inducibilidad TAM";
						break;
					}
					break;
				case 3:
					sustrato = "Nodo AV";
					switch (exito) {
					case 1:
						exitostr = " - Modulación";
						break;
					case 2:
						exitostr = " - Bloqueo AV";
						break;
					}
					break;
				case 4:
					sustrato = "TA focal ";
					switch (sustn2) {
					case 1:
						sustrato += "AD";
						break;
					case 2:
						sustrato += "Art. Pulmonar";
						break;
					case 3:
						sustrato += "AI";
						break;
					case 4:
						sustrato += "Aorta";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión foco";
						break;
					}
					break;
				case 5:
					sustrato = "TIN ";
					switch (sustn2) {
					case 1:
						sustrato += "Vía lenta nodal";
						break;
					case 2:
						sustrato += "Vía rápida";
						break;
					case 3:
						sustrato += "Nodo compacto";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Modulación Vía lenta";
						break;
					case 2:
						exitostr = " - Modulación Vía rápida";
						break;
					case 3:
						exitostr = " - Supresión Vía lenta";
						break;
					case 4:
						exitostr = " - Supresión Vía rápida";
						break;
					}
					break;
				case 6:
					sustrato = "TV-asociada a IAM ";
					switch (sustn2) {
					case 1:
						sustrato += "Convencional - TV Clínica";
						break;
					case 2:
						sustrato += "Convencional - TV No Clínica";
						break;
					case 3:
						sustrato += "Mixto";
						break;
					case 4:
						sustrato += "Sustrato";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión induciblidad TV - Clínica";
						break;
					case 2:
						exitostr = " - Supresión induciblidad TV - Todas las TV";
						break;
					case 3:
						exitostr = " - Supresión de canales sin intentar inducibilidad";
						break;
					}
					break;
				case 7:
					sustrato = "TV-no asociada a IAM ";
					switch (sustn2) {
					case 1:
						sustrato += "DAVD Convencional";
						break;
					case 2:
						sustrato += "DAVD Sustrato";
						break;
					case 3:
						sustrato += "DAVD Mixto";
						break;
					case 4:
						sustrato += "TV-RR Rama derecha";
						break;
					case 5:
						sustrato += "TV-RR Rama izquierda";
						break;
					case 6:
						sustrato += "M Dilatada";
						break;
					case 7:
						sustrato += "Otra";
						break;
					case 8:
						sustrato += "TVNS-CPV";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión induciblidad TV - Clínica";
						break;
					case 2:
						exitostr = " - Supresión induciblidad TV - Todas las TV";
						break;
					}
					break;
				case 8:
					sustrato = "TV idiopática ";
					switch (sustn2) {
					case 1:
						sustrato += "TSVD";
						break;
					case 2:
						sustrato += "TSVI";
						break;
					case 3:
						sustrato += "Sigmoideas aórticas";
						break;
					case 5:
						sustrato += "Fascicular anterior";
						break;
					case 6:
						sustrato += "Fascicular posterior";
						break;
					case 4:
						sustrato += "Otra";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión induciblidad";
						break;
					}
					break;
				case 9:
					sustrato = "Vía accesoria ";
					switch (sustn2) {
					case 1:
						sustrato += "Derecha";
						break;
					case 2:
						sustrato += "Izquierda";
						break;
					case 3:
						sustrato += "Epicárdica";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión conducción VAC";
						break;
					}
					break;
				default:
					sustrato = "";
					break;
				}
				createCell(row, cont++, sustrato, null);
				Integer res = ToInteger(ToString(obj.get(35)));
				Integer exparcial = ToInteger(ToString(obj.get(37)));
				String resultado = "";

				switch (res) {
				case 1:
					resultado = "Éxito" + exitostr;
					break;
				case 2:
					resultado = "Fracaso";
					break;
				case 3:
					resultado = "Éxito parcial";
					switch (exparcial){
					case 1:
						resultado += " - TIN Inducible &gt; 3 ECOS";
						break;
					case 2:
						resultado += " - Supresión conducción unidireccional VAC";
						break;
					case 3:
						resultado += " - Inducibilidad TV no clínica";
						break;
					case 4:
						resultado += " - Aislamiento parcial de venas pulmonares";
						break;
					}
					break;
				default:
					resultado = "";;
				}
				
				createCell(row, cont++, resultado, null);
				
				/*comp = "";
				comp = ToString(obj.get(38));
				switch (ToInteger(comp)){
				case 1:
					comp = "BAV que precisan MP";
					break;
				case 2:
					comp = "Vascular V";
					break;
				case 3:
					comp = "Vascular A";
					break;
				case 4:
					comp = "Derrame pericárdico";
					break;
				case 5:
					comp = "Taponamiento cardíaco";
					break;
				case 6:
					comp = "Embolismo";
					break;
				case 7:
					comp = "ACV";
					break;
				case 8:
					comp = "AIT";
					break;
				case 9:
					comp = "IAM o isquemia";
					break;
				case 10:
					comp = "ICC o EAP";
					break;
				case 11:
					comp = "Estenosis VP";
					break;
				case 12:
					comp = "Fístula atrioesofágica";
					break;
				case 13:
					comp = ToString(obj.get(40));
					break;
				case 14:
					comp = "Bloqueo mecánico rama derecha";
					break;
				case 15:
					comp = "Bloqueo mecánico rama izquierda";
					break;
				default:
					comp = "Ninguna";
					break;
				}
				createCell(row, cont++, comp, null);
				createCell(row, cont++, obj.get(39)!=null?ToString(obj.get(39)).startsWith("1")?"SI":"NO":"", null);*/
			}
			
			fila++;
			cont = 0;
		}
		
		
		fila = 1;
		filapaci = 0;
		cont = 0;
		
		for(int i= 0; i < resvias.size(); i++){
			Row row = sheetVA.createRow(fila);
			if(filapaci >= pacienteVias.size())
				filapaci--;
			EstadisticaDto pac = (EstadisticaDto) pacienteVias.get(filapaci++);
			if(!pac.getNHC().equals(ToString(resvias.get(i).get(0)))){
				filapaci = filapaci - 2;
				pac = (EstadisticaDto) pacienteVias.get(filapaci++);
			}
			Date d;
			//En TOMCAT
			try{
				d = pac.getNACIMIENTO();
			}catch (Exception e) {
				//En WebLogic
				Date cal = (Date) pac.getNACIMIENTO();
				d = cal;
			}
			createCell(row, cont++, pac.getNUHSA(), null);
			createCell(row, cont++, pac.getNHC(), null);
			createCell(row, cont++, UtilFechas.dateToString(d), null);
			createCell(row, cont++, ""+(d!=null?UtilFechas.getEdad(d):""), null);
			createCell(row, cont++, pac.getSEXO()!=null?pac.getSEXO().startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, pac.getHOSPITAL_PROCEDENCIA(), null);
			createCell(row, cont++, pac.getCARACTER_PROCEDENCIA(), null);
			/*String cardio = pac.getCARDIOPATIA();
			if(cardio != null && cardio.startsWith("2")){
				switch (new Double(pac.getTIPO_CARDIOPATIA()).intValue()) {
				case 1:
					cardio = "ISQUÉMICA";
					break;
				case 2:
					cardio = "DILATADA";
					break;
				case 3:
					cardio = "SOSPECHA TAQUIMIOPATÍA";
					break;
				case 4:
					cardio = "HIPERTRÓFICA";
					break;
				case 5:
					cardio = "DISPLASIA VD";
					break;
				case 6:
					cardio = "NO COMPACTADA";
					break;
				case 7:
					cardio = "CONGÉNITA";
					break;
				case 8:
					cardio = "CIRUGÍA CARDIACA PREVIA";
					break;
				case 9:
					cardio = "VALVULAR";
					break;
				case 10:
					cardio = pac.getOTRAS_CARDIOPATIAS();
					break;
				default:
					cardio = "";
					break;
				}
				createCell(row, cont++, cardio, null);
			}else{
				createCell(row, cont++, "NO", null);
			}
			createCell(row, cont++, pac.getFEVI(), null);
			createCell(row, cont++, pac.getFUNCION_VENTRICULAR(), null);
			createCell(row, cont++, pac.getFACT_HTA()!=null?pac.getFACT_HTA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DISLIPEMIA()!=null?pac.getFACT_DISLIPEMIA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DIABETES()!=null?pac.getFACT_DIABETES().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_TABAQUISMO()!=null?pac.getFACT_TABAQUISMO().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_ACV()!=null?pac.getANT_ACV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_INSUF()!=null?pac.getANT_INSUF().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_SAOS()!=null?pac.getANT_SAOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_TIROIDEA()!=null?pac.getANT_TIROIDEA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFIBRI_AURICU()!=null?pac.getFIBRI_AURICU().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getARR_VENT_SOS()!=null?pac.getARR_VENT_SOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getINS_CAR()!=null?pac.getINS_CAR().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getSINCOPE()!=null?pac.getSINCOPE().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPARADA_CARD()!=null?pac.getPARADA_CARD().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getCV()!=null?pac.getCV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORDAI()!=null?pac.getPORTADORDAI().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORMP()!=null?pac.getPORTADORMP().startsWith("0")?"NO":"SI":"", null);
			*/
			//hoja de vias
			ArrayList<Object> obj = resvias.get(i);
			//createCell(row, cont++, cv.getCodigoPaciente().toString(), null);
			createCell(row, cont++, ToString(obj.get(1)), null);
			createCell(row, cont++, ToString(obj.get(2)), null);
			createCell(row, cont++, ToString(obj.get(3)), null);
			String loc1 = ToString(obj.get(4));
			String loc2 = ToString(obj.get(5));
			String[] locs;
			
			switch (loc1.equals("")?0:ToInteger(loc1)) {
				case 1:
					loc1 = "PARED LIBRE IZQUIERDA";
					if(loc2.length() > 0){
						locs = loc2.split(",");
						for(int k=0;k<locs.length;k++)
							switch (new Integer(locs[k])) {
							case 1:
								loc1 += " - POSTERIOR"; 
								break;
							case 2:
								loc1 += " - SUPERIOR"; 
								break;
							case 3:
								loc1 += " - INFERIOR"; 
								break;
							default:
								break;
						}
					}
					break;
				case 2:
					loc1 = "PARED LIBRE DERECHA";
					if(loc2.length() > 0){
						locs = loc2.split(",");
						for(int k=0;k<locs.length;k++)
							switch (new Integer(locs[k])) {
							case 1:
								loc1 += " - ANTERIOR"; 
								break;
							case 2:
								loc1 += " - SUPERIOR"; 
								break;
							case 3:
								loc1 += " - INFERIOR"; 
								break;
							default:
								break;
						}
					}
					break;
				case 3:
					loc1 = "SEPTAL";
					switch (loc2.equals("")?0:ToInteger(loc2)) {
					case 1:
						loc1 += " - IZQUIERDA INFERIOR";
						break;
					case 2:
						loc1 += " - DERECHA SUPERIOR";
						break;
					case 3:
						loc1 += " - DERECHA PERIHIS";
						break;
					case 4:
						loc1 += " - DERECHA MEDIOSEPTAL";
						break;
					case 5:
						loc1 += " - DERECHA INFERIOR";
						break;
					}
					break;
				case 4:
					loc1 = "EPICARDICA";
					switch (loc2.equals("")?0:ToInteger(loc2)) {
					case 1:
						loc1 += " - SENO CORONARIO";
						break;
					case 2:
						loc1 += " - DIVERTICULO SC";
						break;
					}
					break;
				default:
					loc1 = "";
					break;
				}
			createCell(row, cont++, loc1, null);
			
			fila++;
			cont = 0;
		}
		
		
		fila = 1;
		filapaci = 0;
		cont = 0;
		//hoja de taquicardias
		for(int i= 0; i < restaq.size(); i++){
			Row row = sheetTAQ.createRow(fila);
			if(filapaci >= pacienteTaq.size())
				filapaci--;
			EstadisticaDto pac = (EstadisticaDto) pacienteTaq.get(filapaci++);
			if(!pac.getNHC().equals(ToString(restaq.get(i).get(0)))){
				filapaci = filapaci - 2;
				pac = (EstadisticaDto) pacienteTaq.get(filapaci++);
			}
			Date d;
			//En TOMCAT
			try{
				d = pac.getNACIMIENTO();
			}catch (Exception e) {
				//En WebLogic
				Date cal = pac.getNACIMIENTO();
				d = cal;
			}
			createCell(row, cont++, pac.getNUHSA(), null);
			createCell(row, cont++, pac.getNHC(), null);
			createCell(row, cont++, UtilFechas.dateToString(d), null);
			createCell(row, cont++, ""+(d!=null?UtilFechas.getEdad(d):""), null);
			createCell(row, cont++, pac.getSEXO()!=null?pac.getSEXO().startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, pac.getHOSPITAL_PROCEDENCIA(), null);
			createCell(row, cont++, pac.getCARACTER_PROCEDENCIA(), null);
			/*String cardio = pac.getCARDIOPATIA();
			if(cardio != null && cardio.startsWith("2")){
				switch (new Double(pac.getTIPO_CARDIOPATIA()).intValue()) {
				case 1:
					cardio = "ISQUÉMICA";
					break;
				case 2:
					cardio = "DILATADA";
					break;
				case 3:
					cardio = "SOSPECHA TAQUIMIOPATÍA";
					break;
				case 4:
					cardio = "HIPERTRÓFICA";
					break;
				case 5:
					cardio = "DISPLASIA VD";
					break;
				case 6:
					cardio = "NO COMPACTADA";
					break;
				case 7:
					cardio = "CONGÉNITA";
					break;
				case 8:
					cardio = "CIRUGÍA CARDIACA PREVIA";
					break;
				case 9:
					cardio = "VALVULAR";
					break;
				case 10:
					cardio = pac.getOTRAS_CARDIOPATIAS();
					break;
				default:
					cardio = "";
					break;
				}
				createCell(row, cont++, cardio, null);
			}else{
				createCell(row, cont++, "NO", null);
			}
			createCell(row, cont++, pac.getFEVI(), null);
			createCell(row, cont++, pac.getFUNCION_VENTRICULAR(), null);
			createCell(row, cont++, pac.getFACT_HTA()!=null?pac.getFACT_HTA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DISLIPEMIA()!=null?pac.getFACT_DISLIPEMIA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DIABETES()!=null?pac.getFACT_DIABETES().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_TABAQUISMO()!=null?pac.getFACT_TABAQUISMO().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_ACV()!=null?pac.getANT_ACV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_INSUF()!=null?pac.getANT_INSUF().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_SAOS()!=null?pac.getANT_SAOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_TIROIDEA()!=null?pac.getANT_TIROIDEA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFIBRI_AURICU()!=null?pac.getFIBRI_AURICU().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getARR_VENT_SOS()!=null?pac.getARR_VENT_SOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getINS_CAR()!=null?pac.getINS_CAR().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getSINCOPE()!=null?pac.getSINCOPE().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPARADA_CARD()!=null?pac.getPARADA_CARD().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getCV()!=null?pac.getCV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORDAI()!=null?pac.getPORTADORDAI().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORMP()!=null?pac.getPORTADORMP().startsWith("0")?"NO":"SI":"", null);
			*/
			//hoja de taquicardias
			ArrayList<Object> obj = restaq.get(i);
			//createCell(row, cont++, cv.getCodigoPaciente().toString(), null);
			createCell(row, cont++, ToString(obj.get(1)), null);
			createCell(row, cont++, ToString(obj.get(2)), null);
			createCell(row, cont++, ToString(obj.get(3)), null);
			createCell(row, cont++, ToString(obj.get(4)), null);
			
			String induccion = ToString(obj.get(5));
			Integer tipoInduccion = induccion.equals("")?0:ToInteger(induccion); 
			switch (tipoInduccion) {
				case 1:
					induccion = "NO INTENTADA";
					break;
				case 2:
					induccion = "NO INDUCIBLE";
					break;
				case 3:
					induccion = "INDUCIBLE";
					break;
				case 4:
					induccion = "ESPONTANEA";
					break;
				default:
					induccion = "";
					break;
				}
			createCell(row, cont++, induccion, null);
			
			String clinica = ToString(obj.get(6));
			if(ToString(clinica).equals("1")) clinica = "CLINICA";
			else if(ToString(clinica).equals("2")) clinica = "NO CLINICA";
			else clinica = "";
			
			String comportamiento = ToString(obj.get(7));
			if(ToString(comportamiento).equals("1")) comportamiento = "SOSTENIDA";
			else if(ToString(comportamiento).equals("2")) comportamiento = "NO SOSTENIDA";
			else if(ToString(comportamiento).equals("3")) comportamiento = "EXTRASISTOLICA";
			else if(ToString(comportamiento).equals("4")) comportamiento = "INCESANTE";
			else comportamiento = "";
			
			String tipo = ToString(obj.get(8));
			if(ToString(tipo).equals("1")) tipo = "INTRANODAL";
			else if(ToString(tipo).equals("2")) tipo = "VIA ACCESORIA";
			else if(ToString(tipo).equals("3")) tipo = "AURICULAR FOCAL";
			else if(ToString(tipo).equals("4")) tipo = "FLUTER AURICULAR/TA MACRORREENTRANTE";
			else if(ToString(tipo).equals("5")) tipo = "FIBRILACION AURICULAR";
			else if(ToString(tipo).equals("6")) tipo = "NO PAROXISTICA DE LA UNION AV";
			else if(ToString(tipo).equals("7")) tipo = "VENTRICULAR";
			else if(ToString(tipo).equals("8")) tipo = "FIBRILACION VENTRICULAR";
			else tipo = "";
			
			if(tipoInduccion == 3 || tipoInduccion == 4){
				createCell(row, cont++, clinica, null);
				createCell(row, cont++, comportamiento, null);
				createCell(row, cont++, tipo, null);
			}else{
				createCell(row, cont++, "", null);
				createCell(row, cont++, "", null);
				createCell(row, cont++, "", null);
			}
			
			fila++;
			cont = 0;
		}
		
		// Complicaciones de ablacion
		if(reseefcompabl!=null){
			fila = 1;
			filapaci = 0;
			cont = 0;
			
			for(int i= 0; i < reseefcompabl.size(); i++){
				Row row = sheetEEFCOMPABL.createRow(fila);
				
				//hoja de ablacion
				ArrayList<Object> obj = reseefcompabl.get(i);
				createCell(row, cont++, ToString(obj.get(0)), null);
				createCell(row, cont++, UtilFechas.getFechaStringFormato((Date) obj.get(1),"dd-MM-yyyy"), null);
				createCell(row, cont++, ToString(obj.get(2)), null);
				createCell(row, cont++, ToString(obj.get(3)), null);
				
				Integer ab = ToInteger(ToString(obj.get(4)));
				String abordaje;
				switch (ab) {
				case 1:
					abordaje = "Venoso femoral"; 
					break;
				case 2:
					abordaje = "Venoso braquial";
					break;
				case 3:
					abordaje = "Venoso yugular/subclavia";
					break;
				case 4:
					abordaje = "Arterial femoral";
					break;
				case 5:
					abordaje = "Foramen ovale";
					break;
				case 6:
					abordaje = "Transeptal";
					break;
				case 7:
					abordaje = "Epicárdico";
					break;
				default:
					abordaje = "";
					break;
				}
				createCell(row, cont++, abordaje, null);
				Integer energia = ToInteger(ToString(obj.get(5)));
				String energia_str="";
				switch (energia){
				case 1:
					energia_str = "RF (4mm)";
					break;
				case 2:
					energia_str = "RF (8mm)";
					break;
				case 3:
					energia_str = "RF (Irrigado estándar)";
					break;
				case 4:
					energia_str = "Crioablación";
					break;
				case 5:
					energia_str = "Criobalón";
					break;
				case 6:
					energia_str = "Laser";
					break;
				case 7:
					energia_str = "RF (10mm)";
					break;
				case 8:
					energia_str = "Otro";
					break;
				case 9:
					energia_str = "RF (Irrigado de contacto)";
					break;
				case 10:
					energia_str = "RF (Circular RF fásica)";
					break;
				case 11:
					energia_str = "RF (Circular RF irrigada)";
					break;
				}
				createCell(row, cont++, energia_str, null);
				createCell(row, cont++, ToString(obj.get(6)), null);
				createCell(row, cont++, ToString(obj.get(7)), null);
				createCell(row, cont++, ToString(obj.get(8)), null);
				Integer sustn1 = ToInteger(ToString(obj.get(9)));
				Integer sustn2 = ToInteger(ToString(obj.get(10)));
				Integer exito = ToInteger(ToString(obj.get(12)));
				String sustrato, exitostr = "";
				switch (sustn1) {
				case 1:
					sustrato = "Fibrilación auricular ";
					switch (sustn2) {
					case 1:
						sustrato += "Aurícula izquierda";
						break;
					case 2:
						sustrato += "Aurícula derecha";
						break;
					case 3:
						sustrato += "Ambas";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Aislamiento segmentario";
						break;
					case 2:
						exitostr = " - Aislamiento segmentario - Todas las VVPP";
						break;
					case 3:
						exitostr = " - Aislamiento circunferencial";
						break;
					}
					break;
				case 2:
					sustrato = "Flúter auricular/T. auricular macroreentrante ";
					switch (sustn2) {
					case 1:
						sustrato += "Istmo cavo-tricúspide";
						break;
					case 2:
						sustrato += "Otro istmo AD";
						break;
					case 3:
						sustrato += "Istmo mitral";
						break;
					case 4:
						sustrato += "Otro istmo AI";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Bloqueo bidireccional ICT";
						break;
					case 2:
						exitostr = " - Supresión inducibilidad TAM";
						break;
					}
					break;
				case 3:
					sustrato = "Nodo AV";
					switch (exito) {
					case 1:
						exitostr = " - Modulación";
						break;
					case 2:
						exitostr = " - Bloqueo AV";
						break;
					}
					break;
				case 4:
					sustrato = "TA focal ";
					switch (sustn2) {
					case 1:
						sustrato += "AD";
						break;
					case 2:
						sustrato += "Art. Pulmonar";
						break;
					case 3:
						sustrato += "AI";
						break;
					case 4:
						sustrato += "Aorta";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión foco";
						break;
					}
					break;
				case 5:
					sustrato = "TIN ";
					switch (sustn2) {
					case 1:
						sustrato += "Vía lenta nodal";
						break;
					case 2:
						sustrato += "Vía rápida";
						break;
					case 3:
						sustrato += "Nodo compacto";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Modulación Vía lenta";
						break;
					case 2:
						exitostr = " - Modulación Vía rápida";
						break;
					case 3:
						exitostr = " - Supresión Vía lenta";
						break;
					case 4:
						exitostr = " - Supresión Vía rápida";
						break;
					}
					break;
				case 6:
					sustrato = "TV-asociada a IAM ";
					switch (sustn2) {
					case 1:
						sustrato += "Convencional - TV Clínica";
						break;
					case 2:
						sustrato += "Convencional - TV No Clínica";
						break;
					case 3:
						sustrato += "Mixto";
						break;
					case 4:
						sustrato += "Sustrato";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión induciblidad TV - Clínica";
						break;
					case 2:
						exitostr = " - Supresión induciblidad TV - Todas las TV";
						break;
					case 3:
						exitostr = " - Supresión de canales sin intentar inducibilidad";
						break;
					}
					break;
				case 7:
					sustrato = "TV-no asociada a IAM ";
					switch (sustn2) {
					case 1:
						sustrato += "DAVD Convencional";
						break;
					case 2:
						sustrato += "DAVD Sustrato";
						break;
					case 3:
						sustrato += "DAVD Mixto";
						break;
					case 4:
						sustrato += "TV-RR Rama derecha";
						break;
					case 5:
						sustrato += "TV-RR Rama izquierda";
						break;
					case 6:
						sustrato += "M Dilatada";
						break;
					case 7:
						sustrato += "Otra";
						break;
					case 8:
						sustrato += "TVNS-CPV";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión induciblidad TV - Clínica";
						break;
					case 2:
						exitostr = " - Supresión induciblidad TV - Todas las TV";
						break;
					}
					break;
				case 8:
					sustrato = "TV idiopática ";
					switch (sustn2) {
					case 1:
						sustrato += "TSVD";
						break;
					case 2:
						sustrato += "TSVI";
						break;
					case 3:
						sustrato += "Sigmoideas aórticas";
						break;
					case 5:
						sustrato += "Fascicular anterior";
						break;
					case 6:
						sustrato += "Fascicular posterior";
						break;
					case 4:
						sustrato += "Otra";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión induciblidad";
						break;
					}
					break;
				case 9:
					sustrato = "Vía accesoria ";
					switch (sustn2) {
					case 1:
						sustrato += "Derecha";
						break;
					case 2:
						sustrato += "Izquierda";
						break;
					case 3:
						sustrato += "Epicárdica";
						break;
					}
					switch (exito) {
					case 1:
						exitostr = " - Supresión conducción VAC";
						break;
					}
					break;
				default:
					sustrato = "";
					break;
				}
				createCell(row, cont++, sustrato, null);
				Integer res = ToInteger(ToString(obj.get(11)));
				Integer exparcial = ToInteger(ToString(obj.get(13)));
				String resultado = "";

				switch (res) {
				case 1:
					resultado = "Éxito" + exitostr;
					break;
				case 2:
					resultado = "Fracaso";
					break;
				case 3:
					resultado = "Éxito parcial";
					switch (exparcial){
					case 1:
						resultado += " - TIN Inducible &gt; 3 ECOS";
						break;
					case 2:
						resultado += " - Supresión conducción unidireccional VAC";
						break;
					case 3:
						resultado += " - Inducibilidad TV no clínica";
						break;
					case 4:
						resultado += " - Aislamiento parcial de venas pulmonares";
						break;
					}
					break;
				default:
					resultado = "";;
				}
				
				createCell(row, cont++, resultado, null);
				
				String comp = "";
				comp = ToString(obj.get(14));
				switch (ToInteger(comp)){
				case 1:
					comp = "BAV que precisan MP";
					break;
				case 2:
					comp = "Vascular V";
					break;
				case 3:
					comp = "Vascular A";
					break;
				case 4:
					comp = "Derrame pericárdico";
					break;
				case 5:
					comp = "Taponamiento cardíaco";
					break;
				case 6:
					comp = "Embolismo";
					break;
				case 7:
					comp = "ACV";
					break;
				case 8:
					comp = "AIT";
					break;
				case 9:
					comp = "IAM o isquemia";
					break;
				case 10:
					comp = "ICC o EAP";
					break;
				case 11:
					comp = "Estenosis VP";
					break;
				case 12:
					comp = "Fístula atrioesofágica";
					break;
				case 13:
					comp = ToString(obj.get(15));
					break;
				case 14:
					comp = "Bloqueo mecánico rama derecha";
					break;
				case 15:
					comp = "Bloqueo mecánico rama izquierda";
					break;
				default:
					comp = "Ninguna";
					break;
				}
				createCell(row, cont++, comp, null);
				createCell(row, cont++, obj.get(16)!=null?ToString(obj.get(16)).startsWith("1")?"SI":"NO":"NO", null);
				
				fila++;
				cont = 0;
			}
		}
	}
		
	
	private static void rellenaCV(List<Map> paciente, ArrCardioversion[] cvs){
		Integer fila = 1, filapaci = 0, cont = 0;
		
		for(int i= 0; i < cvs.length; i++){
			Row row = sheetCV.createRow(fila);
			if(filapaci >= paciente.size())
				filapaci--;
			EstadisticaDto pac = (EstadisticaDto) paciente.get(filapaci++);
			//System.out.println(ToString(cvs[i].getCodigoPaciente()));
			//String aux = pac.getNHC().replaceFirst ("^0*", "")
			if(!pac.getNHC().replaceFirst ("^0*", "").equals(ToString(cvs[i].getNhc()))){
				filapaci = filapaci - 2;
				pac = (EstadisticaDto) paciente.get(filapaci++);
			}
			Date d;
			//En TOMCAT
			try{
				d = pac.getNACIMIENTO();
			}catch (Exception e) {
				//En WebLogic
				Date cal = pac.getNACIMIENTO();
				d = cal;
			}
			createCell(row, cont++, pac.getNUHSA(), null);
			createCell(row, cont++, pac.getNHC(), null);
			createCell(row, cont++, pac.getNOMBRE(), null);
			createCell(row, cont++, pac.getAP1()!=null?pac.getAP1():"", null);
			createCell(row, cont++, pac.getAP2()!=null?pac.getAP2():"", null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(d, FORMATO), null);
			createCell(row, cont++, ""+(d!=null?UtilFechas.getEdad(d):""), null);
			createCell(row, cont++, pac.getSEXO()!=null?pac.getSEXO().startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, pac.getHOSPITAL_PROCEDENCIA()!=null?pac.getHOSPITAL_PROCEDENCIA():"", null);
			createCell(row, cont++, pac.getCARACTER_PROCEDENCIA()!=null?pac.getCARACTER_PROCEDENCIA():"", null);
			/*String cardio = pac.getCARDIOPATIA();
			if(cardio != null && cardio.startsWith("2")){
				switch (new Double(pac.getTIPO_CARDIOPATIA()).intValue()) {
				case 1:
					cardio = "ISQUÉMICA";
					break;
				case 2:
					cardio = "DILATADA";
					break;
				case 3:
					cardio = "SOSPECHA TAQUIMIOPATÍA";
					break;
				case 4:
					cardio = "HIPERTRÓFICA";
					break;
				case 5:
					cardio = "DISPLASIA VD";
					break;
				case 6:
					cardio = "NO COMPACTADA";
					break;
				case 7:
					cardio = "CONGÉNITA";
					break;
				case 8:
					cardio = "CIRUGÍA CARDIACA PREVIA";
					break;
				case 9:
					cardio = "VALVULAR";
					break;
				case 10:
					cardio = pac.getOTRAS_CARDIOPATIAS();
					break;
				default:
					cardio = "";
					break;
				}
				createCell(row, cont++, cardio, null);
			}else{
				createCell(row, cont++, "NO", null);
			}
			createCell(row, cont++, pac.getFEVI(), null);
			createCell(row, cont++, pac.getFUNCION_VENTRICULAR(), null);
			createCell(row, cont++, pac.getFACT_HTA()!=null?pac.getFACT_HTA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DISLIPEMIA()!=null?pac.getFACT_DISLIPEMIA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DIABETES()!=null?pac.getFACT_DIABETES().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_TABAQUISMO()!=null?pac.getFACT_TABAQUISMO().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_ACV()!=null?pac.getANT_ACV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_INSUF()!=null?pac.getANT_INSUF().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_SAOS()!=null?pac.getANT_SAOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_TIROIDEA()!=null?pac.getANT_TIROIDEA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFIBRI_AURICU()!=null?pac.getFIBRI_AURICU().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getARR_VENT_SOS()!=null?pac.getARR_VENT_SOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getINS_CAR()!=null?pac.getINS_CAR().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getSINCOPE()!=null?pac.getSINCOPE().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPARADA_CARD()!=null?pac.getPARADA_CARD().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getCV()!=null?pac.getCV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORDAI()!=null?pac.getPORTADORDAI().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORMP()!=null?pac.getPORTADORMP().startsWith("0")?"NO":"SI":"", null);
			*/
			//hoja de cardioversion
			ArrCardioversion cv = cvs[i];
			//createCell(row, cont++, cv.getCodigoPaciente().toString(), null);
			createCell(row, cont++, ToString(cv.getNcv()), null);
			createCell(row, cont++, cv.getFibrilacion()==1?"SI":"NO", null);
			createCell(row, cont++, cv.getFluteratipico()==1?"SI":"NO", null);
			createCell(row, cont++, cv.getFlutertipico()==1?"SI":"NO", null);
			createCell(row, cont++, cv.getIdprocedencia()==0?"INGRESADO":"HOSPITAL DE DÍA", null);
			String cveprevia = cv.getCveno()==1?"NO":cv.getCvesi()==1?"SI":"";
			createCell(row, cont++, cveprevia.equals("SI")?"SI" + ToString(cv.getCvenumero()):cveprevia, null);
			createCell(row, cont++, cv.getIdablacion()!=null?(cv.getIdablacion()==1?"SI":"NO"):"", null);
			createCell(row, cont++, cv.getAmiod()!=null?(cv.getAmiod()==1?"SI":"NO"):"", null);
			createCell(row, cont++, cv.getDronedarona()!=null?(cv.getDronedarona()==1?"SI":"NO"):"", null);
			createCell(row, cont++, cv.getSotalol()!=null?(cv.getSotalol()==1?"SI":"NO"):"", null);
			createCell(row, cont++, cv.getClasei()!=null?(cv.getClasei()==1?"SI":"NO"):"", null);
			createCell(row, cont++, cv.getIeca()!=null?(cv.getIeca()==1?"SI":"NO"):"", null);
			createCell(row, cont++, cv.getAraii()!=null?(cv.getAraii()==1?"SI":"NO"):"", null);
			String duracion = "";
			if(cv.getIdduracion()!=null){
				switch (cv.getIdduracion()) {
				case 0:
					duracion = "<1 mes";
					break;
				case 1:
					duracion = "<6 meses";
					break;
				case 2:
					duracion = "<1 año";
					break;
				case 3:
					duracion = ">1 año";
					break;
				case 4:
					duracion = "Desconocido";
					break;
				}
			}
			createCell(row, cont++, duracion, null);
			createCell(row, cont++, cv.getAvta()!=null?(cv.getAvta()==1?"SI":"NO"):"", null);
			createCell(row, cont++, cv.getEte()!=null?(cv.getEte()==1?"SI":"NO"):"", null);
			createCell(row, cont++, ToString(cv.getSec1()), null);
			createCell(row, cont++, ToString(cv.getSec2()), null);
			createCell(row, cont++, ToString(cv.getSec3()), null);
			createCell(row, cont++, ToString(cv.getSec4()), null);
			createCell(row, cont++, ToString(cv.getSec5()), null);
			createCell(row, cont++, cv.getParches()==1?"SI":"NO", null);
			createCell(row, cont++, cv.getAtropina()==1?"SI":"NO", null);
			createCell(row, cont++, cv.getEstimtmpext()==1?"SI":"NO", null);
			createCell(row, cont++, cv.getExitotrans()==1?"SI":"NO", null);
			createCell(row, cont++, cv.getIdexitofinal()==1?"SI":"NO", null);
			createCell(row, cont++, cv.getIdcomplicacion()!=null?(cv.getIdcomplicacion()==1?cv.getComplicacion():cv.getIdcomplicacion()==0?"NO":""):"", null);
			String tipo = "";
			if(cv.getTipoprocedimiento()!=null)
				switch (cv.getTipoprocedimiento()) {
				case 0:
					tipo = "No especificado";
					break;
				case 1:
					tipo = "Interna desde DAI";
					break;
				case 2:
					tipo = "Externa";
					break;
				}
			createCell(row, cont++, tipo, null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(cv.getFecha(), FORMATO), null);
			
			fila++;
			cont = 0;
		}
	}
	
	private static void rellenaDAI(List<Map> paciente, ArrDesfibrilador[] dais){
		Integer fila = 1, filapaci = 0, cont = 0;
		
		for(int i= 0; i < dais.length; i++){
			Row row = sheetDAI.createRow(fila);
			if(filapaci >= paciente.size())
				filapaci--;
			EstadisticaDto pac = (EstadisticaDto) paciente.get(filapaci++);
			if(!pac.getNHC().replaceFirst ("^0*", "").equals(ToString(dais[i].getCodigoPaciente()))){
				filapaci = filapaci - 2;
				pac = (EstadisticaDto) paciente.get(filapaci++);
			}
			Date d;
			//En TOMCAT
			try{
				d = pac.getNACIMIENTO();
			}catch (Exception e) {
				//En WebLogic
				Date cal = pac.getNACIMIENTO();
				d = cal;
			}
			createCell(row, cont++, pac.getNHC(), null);
			createCell(row, cont++, pac.getNOMBRE(), null);
			createCell(row, cont++, pac.getAP1()!=null?pac.getAP1():"", null);
			createCell(row, cont++, pac.getAP2()!=null?pac.getAP2():"", null);
			createCell(row, cont++, UtilFechas.dateToString(d), null);
			createCell(row, cont++, ""+UtilFechas.getEdad(d), null);
			createCell(row, cont++, pac.getSEXO()!=null?pac.getSEXO().startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, pac.getHOSPITAL_PROCEDENCIA()!=null?pac.getHOSPITAL_PROCEDENCIA():"", null);
			createCell(row, cont++, pac.getCARACTER_PROCEDENCIA()!=null?pac.getCARACTER_PROCEDENCIA():"", null);
			String cardio = pac.getCARDIOPATIA();
			if(cardio != null && cardio.startsWith("2")){
				switch (new Double(pac.getTIPO_CARDIOPATIA()).intValue()) {
				case 1:
					cardio = "ISQUÉMICA";
					break;
				case 2:
					cardio = "DILATADA";
					break;
				case 3:
					cardio = "SOSPECHA TAQUIMIOPATÍA";
					break;
				case 4:
					cardio = "HIPERTRÓFICA";
					break;
				case 5:
					cardio = "DISPLASIA VD";
					break;
				case 6:
					cardio = "NO COMPACTADA";
					break;
				case 7:
					cardio = "CONGÉNITA";
					break;
				case 8:
					cardio = "CIRUGÍA CARDIACA PREVIA";
					break;
				case 9:
					cardio = "VALVULAR";
					break;
				case 10:
					cardio = pac.getOTRAS_CARDIOPATIAS();
					break;
				default:
					cardio = "";
					break;
				}
				createCell(row, cont++, cardio, null);
			}else{
				createCell(row, cont++, "NO", null);
			}
			createCell(row, cont++, pac.getFEVI(), null);
			createCell(row, cont++, pac.getFUNCION_VENTRICULAR(), null);
			createCell(row, cont++, pac.getFACT_HTA()!=null?pac.getFACT_HTA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DISLIPEMIA()!=null?pac.getFACT_DISLIPEMIA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DIABETES()!=null?pac.getFACT_DIABETES().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_TABAQUISMO()!=null?pac.getFACT_TABAQUISMO().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_ACV()!=null?pac.getANT_ACV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_INSUF()!=null?pac.getANT_INSUF().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_SAOS()!=null?pac.getANT_SAOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_TIROIDEA()!=null?pac.getANT_TIROIDEA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFIBRI_AURICU()!=null?pac.getFIBRI_AURICU().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getARR_VENT_SOS()!=null?pac.getARR_VENT_SOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getINS_CAR()!=null?pac.getINS_CAR().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getSINCOPE()!=null?pac.getSINCOPE().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPARADA_CARD()!=null?pac.getPARADA_CARD().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getCV()!=null?pac.getCV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORDAI()!=null?pac.getPORTADORDAI().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORMP()!=null?pac.getPORTADORMP().startsWith("0")?"NO":"SI":"", null);
		
			//hoja de cardioversion
			ArrDesfibrilador dai = dais[i];
			//createCell(row, cont++, cv.getCodigoPaciente().toString(), null);
			createCell(row, cont++, ToString(dai.getNdai()), null);
			String cardiopatia = "";
			if(dai.getIsquemicab()) cardiopatia += "ISQUEMICA";
			if(dai.getDilatnoisquemb()) cardiopatia += "DILATADA NO ISQUEMICA";
			switch (dai.getValvular()) {
			case 1:
				cardiopatia += " VALVULAR";
				break;
			case 2:
				cardiopatia += " CONGENITA";
				break;
			case 3:
				cardiopatia += " NINGUNA";
				break;
			case 4:
				cardiopatia += " " + dai.getOtracardiostr();
				break;
			}
			switch (dai.getBrugada()) {
			case 1:
				cardiopatia += " BRUGADA";
				break;
			case 2:
				cardiopatia += " QT LARGO";
				break;
			case 3:
				cardiopatia += " QT CORTO";
				break;
			case 4:
				cardiopatia += " TV CATECOLAMINERGICA";
				break;
			case 5:
				cardiopatia += " " + dai.getOtracardio2str();
				break;
			}
			createCell(row, cont++, cardiopatia, null);
			String eyeccion = "";
			switch (dai.getFraccion()) {
			case 1:
				eyeccion = ">50%";
				break;
			case 2:
				eyeccion = "41-50%";
				break;
			case 3:
				eyeccion = "36-40%";
				break;
			case 4:
				eyeccion = "31-35%";
				break;
			case 5:
				eyeccion = "<=30%";
				break;
			}
			createCell(row, cont++, eyeccion, null);
			String ic = "";
			if(dai.getIc() == 1) ic = "NO";
			else
				switch (dai.getClasefuncional()) {
				case 1:
					ic = "Nyha I";
					break;
				case 2:
					ic = "Nyha II";
					break;
				case 3:
					ic = "Nyha III";
					break;
				case 4:
					ic = "Nyha IV";
					break;
				default:
					ic = "SI";
					break;
				}
			createCell(row, cont++, ic, null);
			String enfc = "";
			switch (dai.getEnfconduccion()) {
			case 1:
				enfc = "NO";
				break;
			case 2:
				enfc = "ENS";
				break;
			case 3:
				enfc = "BAV";
				break;
			case 4:
				enfc = "BRD";
				break;
			case 5:
				enfc = "BRI";
				break;
			case 6:
				enfc = dai.getEnfconduccionstr();
				break;
			}
			createCell(row, cont++, enfc, null);
			String rbasal = "";
			switch (dai.getRitmobasal()) {
			case 1:
				rbasal = "FA";
				break;
			case 2:
				rbasal = "SINUSAL";
				break;
			case 3:
				rbasal = "MARCAPASOS";
				break;
			case 4:
				rbasal = dai.getRitmobasalstr();
				break;
			}
			createCell(row, cont++, rbasal, null);
			createCell(row, cont++, dai.getAntecinsrenal()==2?"SI":"NO", null);
			createCell(row, cont++, dai.getAntecfa()==2?"SI":"NO", null);
			createCell(row, cont++, dai.getDiabetes()==2?"SI":"NO", null);
			createCell(row, cont++, dai.getHipertension()==2?"SI":"NO", null);
			createCell(row, cont++, dai.getAntecmuertesubita()==2?"SI":"NO", null);
			createCell(row, cont++, dai.getAnchuraqrs(), null);
			createCell(row, cont++, dai.getFumador()==2?"SI":"NO", null);
			createCell(row, cont++, dai.getHipercoles()==2?"SI":"NO", null);
			createCell(row, cont++, dai.getAcv()==2?"SI":"NO", null);
			String arrclini = "";
			switch (dai.getArrclinica()) {
			case 1:
				arrclini = "FV";
				break;
			case 2:
				arrclini = "TVP";
				break;
			case 3:
				arrclini = "TVMS";
				break;
			case 4:
				arrclini = "TVNS";
				break;
			}
			createCell(row, cont++, arrclini, null);
			String presclini = "";
			switch (dai.getPresclinica()) {
			case 1:
				presclini = "ASINTOMATICO";
				break;
			case 2:
				presclini = "MUERTE SUBITA";
				break;
			case 3:
				presclini = "SINCOPE";
				break;
			case 4:
				presclini = dai.getPresclinicastr();
				break;
			}
			createCell(row, cont++, presclini, null);
			
			String eef = "";
			if(dai.getEef() == 1) eef = "NO";
			else
				switch (dai.getArrinducida()) {
				case 1:
					eef = "FV";
					break;
				case 2:
					eef = "TVMS";
					break;
				case 3:
					eef = "TVNS";
					break;
				case 4:
					eef = "NINGUNA";
					break;
				case 5:
					eef = "OTRA";
					break;
				}
			createCell(row, cont++, eef, null);
			createCell(row, cont++, dai.getImplante()==1?"PRIMARIA":"SECUNDARIA", null);
			createCell(row, cont++, UtilFechas.dateToString(dai.getFecimplante()), null);
			String lugimpl = "";
			switch (dai.getLugarimplante()) {
			case 1:
				lugimpl = "LAB ELECTROFISIOLOGIA";
				break;
			case 2:
				lugimpl = "QUIROFANO";
				break;
			case 3:
				lugimpl = "OTRO";
				break;
			}
			createCell(row, cont++, lugimpl, null);
			String implantador = "";
			switch (dai.getImplantador()) {
			case 1:
				implantador = "CIRUJANO";
				break;
			case 2:
				implantador = "ELECTROFISIOLOGO";
				break;
			case 3:
				implantador = "INTENSIVISTA";
				break;
			case 4:
				implantador = "OTRO";
				break;
			case 5:
				implantador = "EF + CIRUJANO";
				break;
			}
			createCell(row, cont++, implantador, null);
			String generador = "";
			if(dai.getGenerador() == 1){
				generador = "PRIMOIMPLANTE";
			}
			if(dai.getGenerador() == 2){
				generador = "RECAMBIO";
				switch (dai.getRecambio()) {
				case 1:
					generador += " POR AGOTAMIENTO";
					break;
				case 2:
					generador += " POR COMPLICACIONES";
					break;
				case 3:
					generador += " POR CAMBIO DE INDICACION";
					break;
				}
			}
			createCell(row, cont++, generador, null);
			createCell(row, cont++, dai.getLocimplante()==1?"SUBCUTANEO":"SUBPECTORAL", null);
			String electrodos = "";
			if(dai.getAdb()) electrodos += "AD - ";
			if(dai.getVdb()) electrodos += "VD - ";
			if(dai.getVib()) electrodos += "VI - ";
			if(electrodos.length() > 0) electrodos = electrodos.substring(0, electrodos.length()-2);
			createCell(row, cont++, electrodos, null);
			String elecprev = "";
			switch (dai.getElecprev()) {
			case 1:
				elecprev = "FUNCIONANTES";
				break;
			case 2:
				elecprev = "DISFUNCIONANTES ABANDONADOS";
				break;
			case 3:
				elecprev = "DISFUNCIONANTES EXPLANTADOS";
				break;
			}
			createCell(row, cont++, elecprev, null);
			createCell(row, cont++, dai.getInduc()==2?"SI":"NO", null);
			String complicaciones = "";
			if(dai.getComplmuerteb()) complicaciones += "MUERTE,";
			if(dai.getCompltapb()) complicaciones += "TAPONAMIENTO CARDIACO,";
			if(dai.getComplneumb()) complicaciones += "NEUMOTORAX,";
			if(dai.getCompldisecb()) complicaciones += "DISECCION SC,";
			if(dai.getComplsituab()) complicaciones += "SITUACION SUBOPTIMA VI,";
			if(complicaciones.length() > 0) complicaciones = complicaciones.substring(0, complicaciones.length()-1);
			createCell(row, cont++, complicaciones, null);
			String antibrad = "";
			switch (dai.getEstimantibradi()) {
			case 1:
				antibrad = "VVI";
				break;
			case 2:
				antibrad = "VVIR";
				break;
			case 3:
				antibrad = "DDD";
				break;
			case 4:
				antibrad = "DDDR";
				break;
			case 5:
				antibrad = "OTRO";
				break;
			}
			createCell(row, cont++, antibrad, null);
			String ventri = "";
			switch (dai.getAlgoritmo()) {
			case 1:
				ventri = "ON";
				break;
			case 2:
				ventri = "OFF";
				break;
			case 3:
				ventri = "NO PRESENTE";
				break;
			}
			createCell(row, cont++, ventri, null);
			String atp = "";
			switch (dai.getAtp()) {
			case 1:
				atp = "SI";
				break;
			case 2:
				atp = "NO";
				break;
			case 3:
				atp = "NO DISPONIBLE";
				break;
			}
			createCell(row, cont++, atp, null);
			String modelo = "";
			switch (dai.getModelo()) {
			case 1:
				modelo = "MONOCAMERAL";
				break;
			case 2:
				modelo = "BICAMERAL";
				break;
			case 3:
				modelo = "TRICAMERAL";
				break;
			}
			createCell(row, cont++, modelo, null);
			
			fila++;
			cont = 0;
		}
	}
	
	private static void rellenaATP(List<Map> paciente, ArrayList<ArrayList<Object>> testatp){
		Integer fila = 1, filapaci = 0, cont = 0;
		
		for(int i= 0; i < testatp.size(); i++){
			Row row = sheetATP.createRow(fila);
			if(filapaci >= paciente.size())
				filapaci--;
			EstadisticaDto pac = (EstadisticaDto) paciente.get(filapaci++);
			if(!pac.getNHC().equals(ToString(testatp.get(i).get(0)))){
				filapaci = filapaci - 2;
				pac = (EstadisticaDto) paciente.get(filapaci++);
			}
			Date d;
			//En TOMCAT
			try{
				d = pac.getNACIMIENTO();
			}catch (Exception e) {
				//En WebLogic
				Date cal = pac.getNACIMIENTO();
				d = cal;
			}
			createCell(row, cont++, pac.getNUHSA(), null);
			createCell(row, cont++, pac.getNHC(), null);
			createCell(row, cont++, pac.getNOMBRE(), null);
			createCell(row, cont++, pac.getAP1()!=null?pac.getAP1():"", null);
			createCell(row, cont++, pac.getAP2()!=null?pac.getAP2():"", null);
			createCell(row, cont++, d!=null?UtilFechas.getFechaStringFormato(d, FORMATO):"", null);
			createCell(row, cont++, ""+(d!=null?UtilFechas.getEdad(d):""), null);
			createCell(row, cont++, pac.getSEXO()!=null?pac.getSEXO().startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, pac.getHOSPITAL_PROCEDENCIA()!=null?pac.getHOSPITAL_PROCEDENCIA():"", null);
			createCell(row, cont++, pac.getCARACTER_PROCEDENCIA()!=null?pac.getCARACTER_PROCEDENCIA():"", null);
			/*String cardio = pac.getCARDIOPATIA();
			if(cardio != null && cardio.startsWith("2")){
				switch (new Double(pac.getTIPO_CARDIOPATIA()).intValue()) {
				case 1:
					cardio = "ISQUÉMICA";
					break;
				case 2:
					cardio = "DILATADA";
					break;
				case 3:
					cardio = "SOSPECHA TAQUIMIOPATÍA";
					break;
				case 4:
					cardio = "HIPERTRÓFICA";
					break;
				case 5:
					cardio = "DISPLASIA VD";
					break;
				case 6:
					cardio = "NO COMPACTADA";
					break;
				case 7:
					cardio = "CONGÉNITA";
					break;
				case 8:
					cardio = "CIRUGÍA CARDIACA PREVIA";
					break;
				case 9:
					cardio = "VALVULAR";
					break;
				case 10:
					cardio = pac.getOTRAS_CARDIOPATIAS();
					break;
				default:
					cardio = "";
					break;
				}
				createCell(row, cont++, cardio, null);
			}else{
				createCell(row, cont++, "NO", null);
			}
			createCell(row, cont++, pac.getFEVI(), null);
			createCell(row, cont++, pac.getFUNCION_VENTRICULAR(), null);
			createCell(row, cont++, pac.getFACT_HTA()!=null?pac.getFACT_HTA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DISLIPEMIA()!=null?pac.getFACT_DISLIPEMIA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DIABETES()!=null?pac.getFACT_DIABETES().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_TABAQUISMO()!=null?pac.getFACT_TABAQUISMO().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_ACV()!=null?pac.getANT_ACV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_INSUF()!=null?pac.getANT_INSUF().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_SAOS()!=null?pac.getANT_SAOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_TIROIDEA()!=null?pac.getANT_TIROIDEA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFIBRI_AURICU()!=null?pac.getFIBRI_AURICU().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getARR_VENT_SOS()!=null?pac.getARR_VENT_SOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getINS_CAR()!=null?pac.getINS_CAR().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getSINCOPE()!=null?pac.getSINCOPE().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPARADA_CARD()!=null?pac.getPARADA_CARD().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getCV()!=null?pac.getCV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORDAI()!=null?pac.getPORTADORDAI().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORMP()!=null?pac.getPORTADORMP().startsWith("0")?"NO":"SI":"", null);
			*/
			ArrayList<Object> obj = testatp.get(i);
			createCell(row, cont++, UtilFechas.getFechaStringFormato((Date) obj.get(1), FORMATO), null);
			createCell(row, cont++, ToString(obj.get(2)), null);
			createCell(row, cont++, ToString(obj.get(3)), null);
			createCell(row, cont++, ToString(obj.get(4)), null);
			createCell(row, cont++, ToString(obj.get(5)), null);
			createCell(row, cont++, ToString(obj.get(6)), null);
			createCell(row, cont++, ToString(obj.get(7)), null);
			createCell(row, cont++, ToString(obj.get(8)), null);
			createCell(row, cont++, ToString(obj.get(9)), null);
			String n10 = obj.get(10)!=null?ToString(obj.get(10)).startsWith("1")?"NO":"SI":"";
			createCell(row, cont++, n10, null);
			if(n10.equals("NO"))
				createCell(row, cont++, ToString(obj.get(11)), null);
			else
				createCell(row, cont++, "", null);
			String n12 = obj.get(12)!=null?ToString(obj.get(12)).startsWith("1")?"NO":"SI":"";
			createCell(row, cont++, n12, null);
			if(n12.equals("NO"))
				createCell(row, cont++, ToString(obj.get(13)), null);
			else
				createCell(row, cont++, "", null);
			createCell(row, cont++, ToString(obj.get(14)), null);
			createCell(row, cont++, ToString(obj.get(15)), null);
			createCell(row, cont++, ToString(obj.get(16)), null);
			createCell(row, cont++, ToString(obj.get(17)), null);
			createCell(row, cont++, ToString(obj.get(18)), null);
			createCell(row, cont++, ToString(obj.get(19)), null);
			fila++;
			cont = 0;
		}
	}
	
	private static void rellenaEPI(List<Map> paciente, ArrayList<ArrayList<Object>> testepi){
		Integer fila = 1, filapaci = 0, cont = 0;
		for(int i= 0; i < testepi.size(); i++){
			Row row = sheetEPI.createRow(fila);
			if(filapaci >= paciente.size())
				filapaci--;
			EstadisticaDto pac = (EstadisticaDto) paciente.get(filapaci++);
			if(!pac.getNHC().equals(ToString(testepi.get(i).get(0)))){
				filapaci = filapaci - 2;
				pac = (EstadisticaDto) paciente.get(filapaci++);
			}
			Date d;
			//En TOMCAT
			try{
				d = pac.getNACIMIENTO();
			}catch (Exception e) {
				//En WebLogic
				Date cal = pac.getNACIMIENTO();
				d = cal;
			}
			createCell(row, cont++, pac.getNUHSA(), null);
			createCell(row, cont++, pac.getNHC(), null);
			createCell(row, cont++, pac.getNOMBRE(), null);
			createCell(row, cont++, pac.getAP1()!=null?pac.getAP1():"", null);
			createCell(row, cont++, pac.getAP2()!=null?pac.getAP2():"", null);
			createCell(row, cont++, d!=null?UtilFechas.getFechaStringFormato(d,FORMATO):"", null);
			createCell(row, cont++, ""+(d!=null?UtilFechas.getEdad(d):""), null);
			createCell(row, cont++, pac.getSEXO()!=null?pac.getSEXO().startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, pac.getHOSPITAL_PROCEDENCIA()!=null?pac.getHOSPITAL_PROCEDENCIA():"", null);
			createCell(row, cont++, pac.getCARACTER_PROCEDENCIA()!=null?pac.getCARACTER_PROCEDENCIA():"", null);
			/*String cardio = pac.getCARDIOPATIA();
			if(cardio != null && cardio.startsWith("2")){
				switch (new Double(pac.getTIPO_CARDIOPATIA()).intValue()) {
				case 1:
					cardio = "ISQUÉMICA";
					break;
				case 2:
					cardio = "DILATADA";
					break;
				case 3:
					cardio = "SOSPECHA TAQUIMIOPATÍA";
					break;
				case 4:
					cardio = "HIPERTRÓFICA";
					break;
				case 5:
					cardio = "DISPLASIA VD";
					break;
				case 6:
					cardio = "NO COMPACTADA";
					break;
				case 7:
					cardio = "CONGÉNITA";
					break;
				case 8:
					cardio = "CIRUGÍA CARDIACA PREVIA";
					break;
				case 9:
					cardio = "VALVULAR";
					break;
				case 10:
					cardio = pac.getOTRAS_CARDIOPATIAS();
					break;
				default:
					cardio = "";
					break;
				}
				createCell(row, cont++, cardio, null);
			}else{
				createCell(row, cont++, "NO", null);
			}
			createCell(row, cont++, pac.getFEVI(), null);
			createCell(row, cont++, pac.getFUNCION_VENTRICULAR(), null);
			createCell(row, cont++, pac.getFACT_HTA()!=null?pac.getFACT_HTA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DISLIPEMIA()!=null?pac.getFACT_DISLIPEMIA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DIABETES()!=null?pac.getFACT_DIABETES().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_TABAQUISMO()!=null?pac.getFACT_TABAQUISMO().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_ACV()!=null?pac.getANT_ACV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_INSUF()!=null?pac.getANT_INSUF().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_SAOS()!=null?pac.getANT_SAOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_TIROIDEA()!=null?pac.getANT_TIROIDEA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFIBRI_AURICU()!=null?pac.getFIBRI_AURICU().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getARR_VENT_SOS()!=null?pac.getARR_VENT_SOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getINS_CAR()!=null?pac.getINS_CAR().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getSINCOPE()!=null?pac.getSINCOPE().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPARADA_CARD()!=null?pac.getPARADA_CARD().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getCV()!=null?pac.getCV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORDAI()!=null?pac.getPORTADORDAI().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORMP()!=null?pac.getPORTADORMP().startsWith("0")?"NO":"SI":"", null);
			*/
			ArrayList<Object> obj = testepi.get(i);
			createCell(row, cont++, UtilFechas.getFechaStringFormato((Date) obj.get(1),FORMATO), null);
			createCell(row, cont++, ToString(obj.get(2)), null);
			createCell(row, cont++, ToString(obj.get(3)), null);
			createCell(row, cont++, ToString(obj.get(4)), null);
			createCell(row, cont++, ToString(obj.get(5)), null);
			createCell(row, cont++, ToString(obj.get(6)), null);
			createCell(row, cont++, ToString(obj.get(7)), null);
			createCell(row, cont++, ToString(obj.get(8)), null);
			createCell(row, cont++, ToString(obj.get(9)), null);
			String n10 = obj.get(10)!=null?ToString(obj.get(10)).startsWith("1")?"NO":"SI":"";
			createCell(row, cont++, n10, null);
			if(n10.equals("NO"))
				createCell(row, cont++, ToString(obj.get(11)), null);
			else
				createCell(row, cont++, "", null);
			String n12 = obj.get(12)!=null?ToString(obj.get(12)).startsWith("1")?"NO":"SI":"";
			createCell(row, cont++, n12, null);
			if(n12.equals("NO"))
				createCell(row, cont++, ToString(obj.get(13)), null);
			else
				createCell(row, cont++, "", null);
			createCell(row, cont++, ToString(obj.get(14)), null);
			createCell(row, cont++, ToString(obj.get(15)), null);
			createCell(row, cont++, ToString(obj.get(16)), null);
			createCell(row, cont++, ToString(obj.get(17)), null);
			createCell(row, cont++, ToString(obj.get(18)), null);
			createCell(row, cont++, ToString(obj.get(19)), null);
			fila++;
			cont = 0;
		}
	}
	
	private static void rellenaFLE(List<Map> paciente, ArrayList<ArrayList<Object>> testfle){
		Integer fila = 1, filapaci = 0, cont = 0;
		for(int i= 0; i < testfle.size(); i++){
			Row row = sheetFLE.createRow(fila);
			if(filapaci >= paciente.size())
				filapaci--;
			EstadisticaDto pac = (EstadisticaDto) paciente.get(filapaci++);
			if(!pac.getNHC().equals(ToString(testfle.get(i).get(0)))){
				filapaci = filapaci - 2;
				pac = (EstadisticaDto) paciente.get(filapaci++);
			}
			Date d;
			//En TOMCAT
			try{
				d = pac.getNACIMIENTO();
			}catch (Exception e) {
				//En WebLogic
				Date cal = pac.getNACIMIENTO();
				d = cal;
			}
			createCell(row, cont++, pac.getNUHSA(), null);
			createCell(row, cont++, pac.getNHC(), null);
			createCell(row, cont++, pac.getNOMBRE(), null);
			createCell(row, cont++, pac.getAP1()!=null?pac.getAP1():"", null);
			createCell(row, cont++, pac.getAP2()!=null?pac.getAP2():"", null);
			createCell(row, cont++, d!=null?UtilFechas.getFechaStringFormato(d, FORMATO):"", null);
			createCell(row, cont++, ""+(d!=null?UtilFechas.getEdad(d):""), null);
			createCell(row, cont++, pac.getSEXO()!=null?pac.getSEXO().startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, pac.getHOSPITAL_PROCEDENCIA()!=null?pac.getHOSPITAL_PROCEDENCIA():"", null);
			createCell(row, cont++, pac.getCARACTER_PROCEDENCIA()!=null?pac.getCARACTER_PROCEDENCIA():"", null);
			/*String cardio = pac.getCARDIOPATIA();
			if(cardio != null && cardio.startsWith("2")){
				switch (new Double(pac.getTIPO_CARDIOPATIA()).intValue()) {
				case 1:
					cardio = "ISQUÉMICA";
					break;
				case 2:
					cardio = "DILATADA";
					break;
				case 3:
					cardio = "SOSPECHA TAQUIMIOPATÍA";
					break;
				case 4:
					cardio = "HIPERTRÓFICA";
					break;
				case 5:
					cardio = "DISPLASIA VD";
					break;
				case 6:
					cardio = "NO COMPACTADA";
					break;
				case 7:
					cardio = "CONGÉNITA";
					break;
				case 8:
					cardio = "CIRUGÍA CARDIACA PREVIA";
					break;
				case 9:
					cardio = "VALVULAR";
					break;
				case 10:
					cardio = pac.getOTRAS_CARDIOPATIAS();
					break;
				default:
					cardio = "";
					break;
				}
				createCell(row, cont++, cardio, null);
			}else{
				createCell(row, cont++, "NO", null);
			}
			createCell(row, cont++, pac.getFEVI(), null);
			createCell(row, cont++, pac.getFUNCION_VENTRICULAR(), null);
			createCell(row, cont++, pac.getFACT_HTA()!=null?pac.getFACT_HTA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DISLIPEMIA()!=null?pac.getFACT_DISLIPEMIA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_DIABETES()!=null?pac.getFACT_DIABETES().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFACT_TABAQUISMO()!=null?pac.getFACT_TABAQUISMO().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_ACV()!=null?pac.getANT_ACV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_INSUF()!=null?pac.getANT_INSUF().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_SAOS()!=null?pac.getANT_SAOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getANT_TIROIDEA()!=null?pac.getANT_TIROIDEA().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getFIBRI_AURICU()!=null?pac.getFIBRI_AURICU().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getARR_VENT_SOS()!=null?pac.getARR_VENT_SOS().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getINS_CAR()!=null?pac.getINS_CAR().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getSINCOPE()!=null?pac.getSINCOPE().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPARADA_CARD()!=null?pac.getPARADA_CARD().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getCV()!=null?pac.getCV().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORDAI()!=null?pac.getPORTADORDAI().startsWith("0")?"NO":"SI":"", null);
			createCell(row, cont++, pac.getPORTADORMP()!=null?pac.getPORTADORMP().startsWith("0")?"NO":"SI":"", null);
			*/
			ArrayList<Object> obj = testfle.get(i);
			createCell(row, cont++, UtilFechas.getFechaStringFormato((Date) obj.get(1),FORMATO), null);
			createCell(row, cont++, ToString(obj.get(2)), null);
			createCell(row, cont++, ToString(obj.get(3)), null);
			createCell(row, cont++, ToString(obj.get(4)), null);
			createCell(row, cont++, ToString(obj.get(5)), null);
			createCell(row, cont++, ToString(obj.get(6)), null);
			createCell(row, cont++, ToString(obj.get(7)), null);
			createCell(row, cont++, ToString(obj.get(8)), null);
			createCell(row, cont++, ToString(obj.get(9)), null);
			createCell(row, cont++, ToString(obj.get(10)), null);
			String n11 = obj.get(11)!=null?ToString(obj.get(11)).startsWith("1")?"NO":"SI":"";
			createCell(row, cont++, n11, null);
			if(n11.equals("NO"))
				createCell(row, cont++, ToString(obj.get(12)), null);
			else
				createCell(row, cont++, "", null);
			String n13 = obj.get(13)!=null?ToString(obj.get(13)).startsWith("1")?"NO":"SI":"";
			createCell(row, cont++, n13, null);
			if(n13.equals("NO"))
				createCell(row, cont++, ToString(obj.get(14)), null);
			else
				createCell(row, cont++, "", null);
			createCell(row, cont++, ToString(obj.get(15)), null);
			createCell(row, cont++, ToString(obj.get(16)), null);
			createCell(row, cont++, ToString(obj.get(17)), null);
			createCell(row, cont++, ToString(obj.get(18)), null);
			createCell(row, cont++, ToString(obj.get(19)), null);
			createCell(row, cont++, ToString(obj.get(20)), null);
			fila++;
			cont = 0;
		}
	}
	private static void rellenaImpTAQUI(ArrayList<ArrayList<Object>> res) throws ImpImplanteDaoException{
		Integer fila = 1, filapaci = 0, cont = 0;		
		for(int i= 0; i < res.size(); i++){
			ArrayList<Object> obj = res.get(i);
			Row row = sheetIMPTAQUI.createRow(fila);
			//createCell(row, cont++, obj.get(0)!=null?obj.get(73).toString():"", null);// CIP
			createCell(row, cont++, obj.get(0)!=null?obj.get(0).toString():"", null);//nhc
			
			createCell(row, cont++, obj.get(69)!=null?obj.get(69).toString():"", null);//nombre
			createCell(row, cont++, obj.get(70)!=null?obj.get(70).toString():"", null);//ap1
			createCell(row, cont++, obj.get(71)!=null?obj.get(71).toString():"", null);//ap2
			
			createCell(row, cont++, obj.get(1)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(1), FORMATO):"", null);//fnacimiento
			createCell(row, cont++, obj.get(1)!=null?""+UtilFechas.getEdad((Date)obj.get(1)):"", null);
			//createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			//createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			//createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			Integer tipoproc = (Integer) obj.get(2);
			createCell(row, cont++, tipoproc!=null?UtilMapeos.mapeoTipoProcedimiento(tipoproc):"", null);//tipo proc
			//createCell(row, cont++, obj.get(2)!=null?obj.get(2).toString():"", null);//tipo proc
			createCell(row, cont++, obj.get(72)!=null?obj.get(72).toString():"", null);// NUM PROC
			createCell(row, cont++, obj.get(3)!=null?UtilFechas.getFechaStringFormato((Date)obj.get(3), FORMATO):"", null);//fecha proc			
			createCell(row, cont++, obj.get(4)!=null?obj.get(4).toString():"", null);// modelo
			createCell(row, cont++, obj.get(5)!=null?obj.get(5).toString():"", null);//num.serie
			createCell(row, cont++, obj.get(6)!=null?obj.get(6).toString():"", null);//fabricante	
			if(obj.get(7)!=null) // TIPO INDICACION
				if(obj.get(7).toString().equals("0"))
					createCell(row, cont++, "PREVENCION PRIMARIA", null);
				else if(obj.get(7).toString().equals("1"))
					createCell(row, cont++, "PREVENCION SECUNDARIA", null);
				else if(obj.get(7).toString().equals("2"))
					createCell(row, cont++, "DESCONOCIDO", null);
				else
					createCell(row, cont++, "", null);
			else
				createCell(row, cont++, "", null);	
			createCell(row, cont++, obj.get(8)!=null?obj.get(8).toString():"", null);// tescopia
			if(obj.get(9)!=null){// implantador				
				if(obj.get(9).toString().equals("1"))
					createCell(row, cont++, "CIRUJANO", null);
				else if(obj.get(9).toString().equals("2"))
					createCell(row, cont++, "ELECTROFISIÓLOGO", null);
				else if(obj.get(9).toString().equals("3"))
					createCell(row, cont++, "INTENSIVISTA", null);
				else if(obj.get(9).toString().equals("4"))
					createCell(row, cont++, "EEF+CIRUJANO", null);
				else
					createCell(row, cont++, "OTRO", null);
			}else
				createCell(row, cont++, "", null); // implantador
			
			if(obj.get(10)!=null){// lugar imp
				if(obj.get(10).equals("1"))
					createCell(row, cont++, "LAB. ELECTROFISIOLOGIA", null);
				else if(obj.get(10).equals("2"))
					createCell(row, cont++, "QUIROFANO", null);
				else if(obj.get(10).equals("3"))
					createCell(row, cont++, "OTRO", null);
				else
					createCell(row, cont++, "", null);
			}else
				createCell(row, cont++, "", null);// lugar imp
			
			if(obj.get(11)!=null){// prioridad
				if(obj.get(11).equals("1"))
					createCell(row, cont++, "EMERGENCIA", null);
				else if(obj.get(11).equals("2"))
					createCell(row, cont++, "URGENCIA", null);
				else if(obj.get(11).equals("3"))
					createCell(row, cont++, "PREFERENTE", null);
				else if(obj.get(11).equals("4"))
					createCell(row, cont++, "PRIOTOTARIO", null);
				else if(obj.get(11).equals("5"))
					createCell(row, cont++, "ELECTIVO", null);
				else
					createCell(row, cont++, "", null);
			}else
				createCell(row, cont++, "", null);// prioridad
			
			if(obj.get(12)!=null){// tanestesia
				if(obj.get(12).equals("1"))
					createCell(row, cont++, "LOCAL", null);
				else if(obj.get(12).equals("2"))
					createCell(row, cont++, "REGIONAL", null);
				else if(obj.get(12).equals("2"))
					createCell(row, cont++, "GENERAL", null);
				else
					createCell(row, cont++, "", null);
			}else
				createCell(row, cont++, "", null);// tanestesia
			
			createCell(row, cont++, obj.get(13)!=null?obj.get(13).toString():"", null);//hllegada
			createCell(row, cont++, obj.get(14)!=null?obj.get(14).toString():"", null);//hinicio
			createCell(row, cont++, obj.get(15)!=null?obj.get(15).toString():"", null);//hfin
			createCell(row, cont++, obj.get(16)!=null?obj.get(16).toString():"", null);//hsalida
			createCell(row, cont++, obj.get(17)!=null?obj.get(17).toString():"", null);//testinduccion
			createCell(row, cont++, obj.get(18)!=null?obj.get(18).toString():"", null);//energiatest
			createCell(row, cont++, obj.get(19)!=null?obj.get(19).toString():"", null);//imptest
			createCell(row, cont++, obj.get(20)!=null?obj.get(20).toString():"", null);//num choques test
			
			
			// todo en una misma hoja - Indicacion
			createCell(row, cont++, obj.get(21)!=null?obj.get(21).toString():"", null);// ritmo
			createCell(row, cont++, obj.get(22)!=null?obj.get(22).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(23)!=null?obj.get(23).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(24)!=null?obj.get(24).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(25)!=null?obj.get(25).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(26)!=null?obj.get(26).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(27)!=null?obj.get(27).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(28)!=null?obj.get(28).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(29)!=null?obj.get(29).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(30)!=null?obj.get(30).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(31)!=null?obj.get(31).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(32)!=null?obj.get(32).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(33)!=null?obj.get(33).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(34)!=null?obj.get(34).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(35)!=null?obj.get(35).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(36)!=null?obj.get(36).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(37)!=null?obj.get(37).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(38)!=null?obj.get(38).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(39)!=null?obj.get(39).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(40)!=null?obj.get(40).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(41)!=null?obj.get(41).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(42)!=null?obj.get(42).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(43)!=null?obj.get(43).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(44)!=null?obj.get(44).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(45)!=null?obj.get(45).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(46)!=null?obj.get(46).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(47)!=null?obj.get(47).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(48)!=null?obj.get(48).toString():"", null);// ritmo2
			
			createCell(row, cont++, obj.get(49)!=null?obj.get(49).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(50)!=null?obj.get(50).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(51)!=null?obj.get(51).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(52)!=null?obj.get(52).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(53)!=null?obj.get(53).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(54)!=null?obj.get(54).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(55)!=null?obj.get(55).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(56)!=null?obj.get(56).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(57)!=null?obj.get(57).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(58)!=null?obj.get(58).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(59)!=null?obj.get(59).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(60)!=null?obj.get(60).toString():"", null);// valor_histereisi
			createCell(row, cont++, obj.get(61)!=null?obj.get(61).toString():"", null);// numepitsv
			createCell(row, cont++, obj.get(62)!=null?obj.get(62).toString():"", null);// numepitv
			createCell(row, cont++, obj.get(63)!=null?obj.get(63).toString():"", null);// numepifv
			createCell(row, cont++, obj.get(64)!=null?obj.get(64).toString():"", null);// numepinosost
			createCell(row, cont++, obj.get(65)!=null?obj.get(65).toString():"", null);// numepinoesp
			
			
			createCell(row, cont++, obj.get(66)!=null?obj.get(66).toString():"", null);// algprevfa
			createCell(row, cont++, obj.get(67)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(67), FORMATO):"", null);// fecha alta
			
			ImpImplanteDao impdao = new ImpImplanteDaoImpl("consulta");
			ArrayList<ArrayList<Object>> pops = impdao.getPops(ToInteger(ToString(obj.get(68))));
			ArrayList<ArrayList<Object>> sops = impdao.getSops(ToInteger(ToString(obj.get(68))));
			createCell(row, cont++, ToString(pops.get(0).get(0)), null);
			createCell(row, cont++, ToString(sops.get(0).get(0)), null);
			//createCell(row, cont++, obj.get(58)!=null?obj.get(58).toString():"", null);// ritmo2
			//createCell(row, cont++, obj.get(59)!=null?obj.get(59).toString():"", null);// ritmo2
			
			// hasta 58-59
			// todo en una misma hoja - Evolucion
			
			//createCell(row, cont++, obj.get(72)!=null?obj.get(72).toString():"", null);// NUM PROC
			
			fila++;
			cont = 0;
		}
		
	}
	private static void rellenaImpBRADI(ArrayList<ArrayList<Object>> res) throws ImpImplanteDaoException{
		Integer fila = 1, filapaci = 0, cont = 0;		
		for(int i= 0; i < res.size(); i++){
			ArrayList<Object> obj = res.get(i);
			Row row = sheetIMPBRADI.createRow(fila);
			//createCell(row, cont++, obj.get(0)!=null?obj.get(63).toString():"", null);// CIP
			createCell(row, cont++, obj.get(0)!=null?obj.get(0).toString():"", null);//nhc
			
			createCell(row, cont++, obj.get(59)!=null?obj.get(59).toString():"", null);//nombre
			createCell(row, cont++, obj.get(60)!=null?obj.get(60).toString():"", null);//ap1
			createCell(row, cont++, obj.get(61)!=null?obj.get(61).toString():"", null);//ap2
			
			createCell(row, cont++, obj.get(1)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(1), FORMATO):"", null);//fnacimiento
			createCell(row, cont++, obj.get(1)!=null?""+UtilFechas.getEdad((Date)obj.get(1)):"", null);
			//createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			//createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			//createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			Integer tipoproc = (Integer) obj.get(2);
			createCell(row, cont++, tipoproc!=null?UtilMapeos.mapeoTipoProcedimiento(tipoproc):"", null);//tipo proc
			//createCell(row, cont++, obj.get(2)!=null?obj.get(2).toString():"", null);//tipo proc
			createCell(row, cont++, obj.get(62)!=null?obj.get(62).toString():"", null);// n proc
			createCell(row, cont++, obj.get(3)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(3), FORMATO):"", null);//fecha proc			
			createCell(row, cont++, obj.get(4)!=null?obj.get(4).toString():"", null);// modelo
			createCell(row, cont++, obj.get(5)!=null?obj.get(5).toString():"", null);//num.serie
			createCell(row, cont++, obj.get(6)!=null?obj.get(6).toString():"", null);//fabricante
			
			createCell(row, cont++, obj.get(7)!=null?obj.get(7).toString():"", null);// tescopia
			if(obj.get(8)!=null) // implantador
				if(obj.get(8).toString().equals("1"))
					createCell(row, cont++, "CIRUJANO", null);
				else if(obj.get(8).toString().equals("2"))
					createCell(row, cont++, "ELECTROFISIÓLOGO", null);
				else if(obj.get(8).toString().equals("3"))
					createCell(row, cont++, "INTENSIVISTA", null);
				else if(obj.get(8).toString().equals("4"))
					createCell(row, cont++, "EEF+CIRUJANO", null);
				else
					createCell(row, cont++, "OTRO", null);
			else
				createCell(row, cont++, "", null); // implantador
			if(obj.get(9)!=null)// lugar imp
				if(obj.get(11).equals("1"))
					createCell(row, cont++, "LAB. ELECTROFISIOLOGIA", null);
				else if(obj.get(9).equals("2"))
					createCell(row, cont++, "QUIROFANO", null);
				else if(obj.get(9).equals("3"))
					createCell(row, cont++, "OTRO", null);
				else
					createCell(row, cont++, "", null);
			else
				createCell(row, cont++, "", null);// lugar imp
			
			if(obj.get(10)!=null)// prioridad
				if(obj.get(10).equals("1"))
					createCell(row, cont++, "EMERGENCIA", null);
				else if(obj.get(10).equals("2"))
					createCell(row, cont++, "URGENCIA", null);
				else if(obj.get(10).equals("3"))
					createCell(row, cont++, "PREFERENTE", null);
				else if(obj.get(10).equals("4"))
					createCell(row, cont++, "PRIOTOTARIO", null);
				else if(obj.get(10).equals("5"))
					createCell(row, cont++, "ELECTIVO", null);
				else
					createCell(row, cont++, "", null);
			else
				createCell(row, cont++, "", null);// prioridad
			
			if(obj.get(11)!=null)// tanestesia
				if(obj.get(11).equals("1"))
					createCell(row, cont++, "LOCAL", null);
				else if(obj.get(11).equals("2"))
					createCell(row, cont++, "REGIONAL", null);
				else if(obj.get(11).equals("2"))
					createCell(row, cont++, "GENERAL", null);
				else
					createCell(row, cont++, "", null);
			else
				createCell(row, cont++, "", null);// tanestesia
			
			createCell(row, cont++, obj.get(12)!=null?obj.get(12).toString():"", null);
			createCell(row, cont++, obj.get(13)!=null?obj.get(13).toString():"", null);
			createCell(row, cont++, obj.get(14)!=null?obj.get(14).toString():"", null);
			createCell(row, cont++, obj.get(15)!=null?obj.get(15).toString():"", null);
			// todo en una misma hoja - Indicacion
			createCell(row, cont++, obj.get(16)!=null?obj.get(16).toString():"", null);// ritmo
			createCell(row, cont++, obj.get(17)!=null?obj.get(17).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(18)!=null?obj.get(18).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(19)!=null?obj.get(19).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(20)!=null?obj.get(20).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(21)!=null?obj.get(21).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(22)!=null?obj.get(22).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(23)!=null?obj.get(23).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(24)!=null?obj.get(24).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(25)!=null?obj.get(25).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(26)!=null?obj.get(26).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(27)!=null?obj.get(27).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(28)!=null?obj.get(28).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(29)!=null?obj.get(29).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(30)!=null?obj.get(30).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(31)!=null?obj.get(31).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(32)!=null?obj.get(32).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(33)!=null?obj.get(33).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(34)!=null?obj.get(34).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(35)!=null?obj.get(35).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(36)!=null?obj.get(36).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(37)!=null?obj.get(37).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(38)!=null?obj.get(38).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(39)!=null?obj.get(39).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(40)!=null?obj.get(40).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(41)!=null?obj.get(41).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(42)!=null?obj.get(42).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(43)!=null?obj.get(43).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(44)!=null?obj.get(44).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(45)!=null?obj.get(45).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(46)!=null?obj.get(46).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(47)!=null?obj.get(47).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(48)!=null?obj.get(48).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(49)!=null?obj.get(49).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(50)!=null?obj.get(50).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(51)!=null?obj.get(51).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(52)!=null?obj.get(52).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(53)!=null?obj.get(53).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(54)!=null?obj.get(54).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(55)!=null?obj.get(55).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(56)!=null?obj.get(56).toString():"", null);// ritmo2
			createCell(row, cont++, obj.get(57)!=null?obj.get(57).toString():"", null);// ritmo2
			
			ImpImplanteDao impdao = new ImpImplanteDaoImpl("consulta");
			ArrayList<ArrayList<Object>> pops = impdao.getPops(ToInteger(ToString(obj.get(58))));
			ArrayList<ArrayList<Object>> sops = impdao.getSops(ToInteger(ToString(obj.get(58))));
			createCell(row, cont++, ToString(pops.get(0).get(0)), null);
			createCell(row, cont++, ToString(sops.get(0).get(0)), null);
			
			
			//createCell(row, cont++, obj.get(62)!=null?obj.get(62).toString():"", null);// n proc
			//createCell(row, cont++, obj.get(58)!=null?obj.get(58).toString():"", null);// ritmo2
			//createCell(row, cont++, obj.get(59)!=null?obj.get(59).toString():"", null);// ritmo2
			
			// hasta 58-59
			// todo en una misma hoja - Evolucion
			
			fila++;
			cont = 0;
		}
		/*fila = 1; filapaci = 0; cont = 0;		
		for(int i= 0; i < res.size(); i++){
			ArrayList<Object> obj = res.get(i);
			Row row = sheetIMPBRADI_IND.createRow(fila);
			createCell(row, cont++, obj.get(0)!=null?obj.get(0).toString():"", null);//nhc
			createCell(row, cont++, obj.get(1)!=null?obj.get(1).toString():"", null);//fnacimiento
			createCell(row, cont++, obj.get(16)!=null?obj.get(16).toString():"", null);// ritmo
			createCell(row, cont++, obj.get(17)!=null?obj.get(16).toString():"", null);// ritmo2
			
			createCell(row, cont++, "EDAD", null);
			createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			createCell(row, cont++, auxest.get(i).getRitmo().toString(), null);//
			createCell(row, cont++, auxest.get(i).getConduccionav().toString(), null);//
			createCell(row, cont++, auxest.get(i).getQrs().toString(), null);//
			createCell(row, cont++, sitclin.get(i).getFevi()!=null?sitclin.get(i).getFevi():"", null);//
			createCell(row, cont++, auxest.get(i).getFuncionventricular()!=null?auxest.get(i).getFuncionventricular():"", null);//
			createCell(row, cont++, sitclin.get(i).getNyha()!=null?sitclin.get(i).getNyha().toString():"", null);//
			createCell(row, cont++, auxest.get(i).getCardiopatia()!=null?auxest.get(i).getCardiopatia().toString():"", null);//
			createCell(row, cont++, sitclin.get(i).getAevolucion()!=null?sitclin.get(i).getAevolucion():"", null);
			if(sitclin.get(i).getRevasc()!=null)
				createCell(row, cont++,sitclin.get(i).getRevasc()==1?"Si":"", null);
			else
				createCell(row, cont++,"", null);
			
			if(sitclin.get(i).getInfprevio()!=null)
				createCell(row, cont++,sitclin.get(i).getInfprevio()==1?"Si":"", null);
			else
				createCell(row, cont++,"", null);
			
			createCell(row, cont++,sitclin.get(i).getInsrenal()!=null && sitclin.get(i).getInsrenal()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getDiabetes()!=null && sitclin.get(i).getDiabetes()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getAntfa()!=null && sitclin.get(i).getAntfa()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getHipertension()!=null && sitclin.get(i).getHipertension()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getMuertesubita()!=null && sitclin.get(i).getMuertesubita()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getTabaquismo()!=null && sitclin.get(i).getTabaquismo()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getHipercolest()!=null && sitclin.get(i).getHipercolest()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getAcv()!=null && sitclin.get(i).getAcv()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getTrasplantecardiaco()!=null && sitclin.get(i).getTrasplantecardiaco()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getAit()!=null && sitclin.get(i).getAit()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getSincope()!=null && sitclin.get(i).getSincope()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getParadacardiaca()!=null && sitclin.get(i).getParadacardiaca()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getEpoc()!=null && sitclin.get(i).getEpoc()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getSahs()!=null && sitclin.get(i).getSahs()==1?"Si":"", null);
			createCell(row, cont++,auxest.get(i).getAfectiroidea()!=null?auxest.get(i).getAfectiroidea():"", null);//
			createCell(row, cont++,auxest.get(i).getNeuromediados()!=null ?auxest.get(i).getNeuromediados():"", null);//
			
			fila++;
			cont = 0;
			
		}*//*
		fila = 1; filapaci = 0; cont = 0;		
		for(int i= 0; i < ev.size(); i++){
			Row row = sheetIMPMP_EV.createRow(fila);
			createCell(row, cont++, pacientes.get(i).getNhc(), null);
			createCell(row, cont++, UtilFechas.dateToString(pacientes.get(i).getFechanaci()), null);
			createCell(row, cont++, "EDAD", null);
			createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			createCell(row, cont++, ev.get(i).getMpdependiente()!=null && ev.get(i).getMpdependiente()==1?"Si":"", null);
			createCell(row, cont++, auxest.get(i).getModo()!=null?auxest.get(i).getModo():"", null);
			createCell(row, cont++, ev.get(i).getFbasica()!=null?ev.get(i).getFbasica():"", null);
			createCell(row, cont++, ev.get(i).getSegremoto()!=null && ev.get(i).getSegremoto()==1?"Si":"", null);
			createCell(row, cont++, ev.get(i).getMev()!=null && ev.get(i).getMev()==1?"Si":"", null);
			createCell(row, cont++, ev.get(i).getIavdetec()!=null?ev.get(i).getIavdetec():"", null);
			createCell(row, cont++, ev.get(i).getIavestim()!=null?ev.get(i).getIavestim():"", null);
			createCell(row, cont++, ev.get(i).getIavmax()!=null?ev.get(i).getIavmax():"", null);
			createCell(row, cont++, ev.get(i).getIavmin()!=null?ev.get(i).getIavmin():"", null);
			createCell(row, cont++, ev.get(i).getFmax()!=null?ev.get(i).getFmax():"", null);
			createCell(row, cont++, ev.get(i).getFmin()!=null?ev.get(i).getFmin():"", null);
			createCell(row, cont++, ev.get(i).getValorHisteresis()!=null?ev.get(i).getValorHisteresis():"", null);
			createCell(row, cont++, ev.get(i).getAlgprevfa()!=null && ev.get(i).getAlgprevfa()==1?"Si":"", null);
			createCell(row, cont++, UtilFechas.dateToString(ev.get(i).getFechaalta()), null);
			if(ev.get(i).getMotivoalta()!=null)
				if(ev.get(i).getMotivoalta()==1)
					createCell(row, cont++,"CURADO", null);
				else if(ev.get(i).getMotivoalta()==2)
					createCell(row, cont++,"TRASLADO", null);
				else if(ev.get(i).getMotivoalta()==3)
					createCell(row, cont++,"FUGADO", null);
				else if(ev.get(i).getMotivoalta()==4)
					createCell(row, cont++,"ORDEN MEDICA", null);
				else if(ev.get(i).getMotivoalta()==5)
					createCell(row, cont++,"VOLUNTARIA", null);
				else if(ev.get(i).getMotivoalta()==6)
					createCell(row, cont++,"DEFUNCION", null);
				else 
					createCell(row, cont++,"", null);
			
			fila++;
			cont = 0;
			
		}*/
	}
	private static void rellenaImpMP(ArrayList<ArrPacientes> pacientes, ArrayList<SituacionClinicaProc> sitclin,
			ArrayList<ImpHojaImplante> himp, ArrayList<ImpEvolucion> ev,
			ArrayList<ImpGenerador> listgen, ArrayList<Generador> gens, ArrayList<Procedimiento> prs,
			ArrayList<EstadisticasImplanteBean> auxest){
		Integer fila = 1, filapaci = 0, cont = 0;		
		for(int i= 0; i < listgen.size(); i++){
			Row row = sheetIMPMP.createRow(fila);
			createCell(row, cont++, pacientes.get(i).getNhc(), null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(pacientes.get(i).getFechanaci(),FORMATO), null);
			createCell(row, cont++, ""+UtilFechas.getEdad(pacientes.get(i).getFechanaci()), null);
			createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(prs.get(i).getFecha(),FORMATO), null);
			createCell(row, cont++, auxest.get(i).getTipoproc().toString(), null);//			
			createCell(row, cont++, gens.get(i).getModelo(), null);
			createCell(row, cont++, listgen.get(i).getNumserie(), null);
			createCell(row, cont++, gens.get(i).getFabricante(), null);
			String locgen="";
			if(listgen.get(i).getLocalizacion() != null ){
				switch (listgen.get(i).getLocalizacion()) {
				case 984:
					locgen = "SUBCLAVIAR IZQUIERDA";
					break;
				case 985:
					locgen = "SUBCLAVIAR DERECHA";
					break;
				case 986:
					locgen = "SUBCUTANEA IZQUIERDA";
					break;
				case 987:
					locgen = "SUBCUTANEA DERECHA";
					break;
				case 988:
					locgen = "SUBPECTORAL IZQUIERDA";
					break;
				case 989:
					locgen = "SUBPECTORAL DERECHA";
					break;
				case 990:
					locgen = "ABDOMINAL SUBCUTANEA";
					break;
				case 991:
					locgen = "ABDOMINAL RETROMUSCULAR";
					break;
				case 992:
					locgen = "OTRA";
					break;
				default:
					locgen = "NO ESPECIFICADO";
					break;
				}
				createCell(row, cont++, locgen, null);
			}else{
				createCell(row, cont++, "NO ESPECIFICADO", null);
			}		
			if(himp.get(i).getImplantador()!=null)
				if(himp.get(i).getImplantador()==1)
					createCell(row, cont++, "CIRUJANO", null);
				else if(himp.get(i).getImplantador()==2)
					createCell(row, cont++, "ELECTROFISIÓLOGO", null);
				else if(himp.get(i).getImplantador()==3)
					createCell(row, cont++, "INTENSIVISTA", null);
				else if(himp.get(i).getImplantador()==4)
					createCell(row, cont++, "EEF+CIRUJANO", null);
				else
					createCell(row, cont++, "OTRO", null);
			createCell(row, cont++, auxest.get(i).getEnf(), null);
			createCell(row, cont++, auxest.get(i).getPop(), null);
			createCell(row, cont++, auxest.get(i).getSop(), null);
			if(himp.get(i).getPrioridad()!=null)
				if(himp.get(i).getPrioridad()==1)
					createCell(row, cont++, "EMERGENCIA", null);
				else if(himp.get(i).getPrioridad()==2)
					createCell(row, cont++, "URGENCIA", null);
				else if(himp.get(i).getPrioridad()==3)
					createCell(row, cont++, "PREFERENTE", null);
				else if(himp.get(i).getPrioridad()==4)
					createCell(row, cont++, "PRIOTOTARIO", null);
				else if(himp.get(i).getPrioridad()==5)
					createCell(row, cont++, "ELECTIVO", null);
				else
					createCell(row, cont++, "", null);
			if(himp.get(i).getLugarimp()!=null)
				if(himp.get(i).getLugarimp()==1)
					createCell(row, cont++, "LAB. ELECTROFISIOLOGIA", null);
				else if(himp.get(i).getLugarimp()==2)
					createCell(row, cont++, "QUIROFANO", null);
				else if(himp.get(i).getLugarimp()==3)
					createCell(row, cont++, "OTRO", null);
				else
					createCell(row, cont++, "", null);
			if(himp.get(i).getTanestesia()!=null)
				if(himp.get(i).getTanestesia()==1)
					createCell(row, cont++, "LOCAL", null);
				else if(himp.get(i).getTanestesia()==2)
					createCell(row, cont++, "REGIONAL", null);
				else if(himp.get(i).getTanestesia()==3)
					createCell(row, cont++, "GENERAL", null);
				else
					createCell(row, cont++, "", null);
			
			createCell(row, cont++, himp.get(i).getTescopia()!=null?himp.get(i).getTescopia():"", null);
			createCell(row, cont++, "HORA LLEGADA", null);
			createCell(row, cont++, "HORA INICIO", null);
			createCell(row, cont++, "HORA FIN", null);
			createCell(row, cont++, "HORA SALIDA\nholaaa!!", null);
			
			fila++;
			cont = 0;
		}
		fila = 1; filapaci = 0; cont = 0;		
		for(int i= 0; i < sitclin.size(); i++){
			Row row = sheetIMPMP_IND.createRow(fila);
			createCell(row, cont++, pacientes.get(i).getNhc(), null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(pacientes.get(i).getFechanaci(),FORMATO), null);
			createCell(row, cont++, "EDAD", null);
			createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			createCell(row, cont++, auxest.get(i).getRitmo().toString(), null);//
			createCell(row, cont++, auxest.get(i).getConduccionav().toString(), null);//
			createCell(row, cont++, auxest.get(i).getQrs().toString(), null);//
			createCell(row, cont++, sitclin.get(i).getFevi()!=null?sitclin.get(i).getFevi():"", null);//
			createCell(row, cont++, auxest.get(i).getFuncionventricular()!=null?auxest.get(i).getFuncionventricular():"", null);//
			createCell(row, cont++, sitclin.get(i).getNyha()!=null?sitclin.get(i).getNyha().toString():"", null);//
			createCell(row, cont++, auxest.get(i).getCardiopatia()!=null?auxest.get(i).getCardiopatia().toString():"", null);//
			createCell(row, cont++, sitclin.get(i).getAevolucion()!=null?sitclin.get(i).getAevolucion():"", null);
			if(sitclin.get(i).getRevasc()!=null)
				createCell(row, cont++,sitclin.get(i).getRevasc()==1?"Si":"", null);
			else
				createCell(row, cont++,"", null);
			
			if(sitclin.get(i).getInfprevio()!=null)
				createCell(row, cont++,sitclin.get(i).getInfprevio()==1?"Si":"", null);
			else
				createCell(row, cont++,"", null);
			
			createCell(row, cont++,sitclin.get(i).getInsrenal()!=null && sitclin.get(i).getInsrenal()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getDiabetes()!=null && sitclin.get(i).getDiabetes()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getAntfa()!=null && sitclin.get(i).getAntfa()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getHipertension()!=null && sitclin.get(i).getHipertension()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getMuertesubita()!=null && sitclin.get(i).getMuertesubita()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getTabaquismo()!=null && sitclin.get(i).getTabaquismo()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getHipercolest()!=null && sitclin.get(i).getHipercolest()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getAcv()!=null && sitclin.get(i).getAcv()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getTrasplantecardiaco()!=null && sitclin.get(i).getTrasplantecardiaco()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getAit()!=null && sitclin.get(i).getAit()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getSincope()!=null && sitclin.get(i).getSincope()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getParadacardiaca()!=null && sitclin.get(i).getParadacardiaca()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getEpoc()!=null && sitclin.get(i).getEpoc()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getSahs()!=null && sitclin.get(i).getSahs()==1?"Si":"", null);
			createCell(row, cont++,auxest.get(i).getAfectiroidea()!=null?auxest.get(i).getAfectiroidea():"", null);//
			createCell(row, cont++,auxest.get(i).getNeuromediados()!=null ?auxest.get(i).getNeuromediados():"", null);//
			
			fila++;
			cont = 0;
			
		}
		fila = 1; filapaci = 0; cont = 0;		
		for(int i= 0; i < ev.size(); i++){
			Row row = sheetIMPMP_EV.createRow(fila);
			createCell(row, cont++, pacientes.get(i).getNhc(), null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(pacientes.get(i).getFechanaci(),FORMATO), null);
			createCell(row, cont++, "EDAD", null);
			createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			createCell(row, cont++, ev.get(i).getMpdependiente()!=null && ev.get(i).getMpdependiente()==1?"Si":"", null);
			createCell(row, cont++, auxest.get(i).getModo()!=null?auxest.get(i).getModo():"", null);
			createCell(row, cont++, ev.get(i).getFbasica()!=null?ev.get(i).getFbasica():"", null);
			createCell(row, cont++, ev.get(i).getSegremoto()!=null && ev.get(i).getSegremoto()==1?"Si":"", null);
			createCell(row, cont++, ev.get(i).getMev()!=null && ev.get(i).getMev()==1?"Si":"", null);
			createCell(row, cont++, ev.get(i).getIavdetec()!=null?ev.get(i).getIavdetec():"", null);
			createCell(row, cont++, ev.get(i).getIavestim()!=null?ev.get(i).getIavestim():"", null);
			createCell(row, cont++, ev.get(i).getIavmax()!=null?ev.get(i).getIavmax():"", null);
			createCell(row, cont++, ev.get(i).getIavmin()!=null?ev.get(i).getIavmin():"", null);
			createCell(row, cont++, ev.get(i).getFmax()!=null?ev.get(i).getFmax():"", null);
			createCell(row, cont++, ev.get(i).getFmin()!=null?ev.get(i).getFmin():"", null);
			createCell(row, cont++, ev.get(i).getValorHisteresis()!=null?ev.get(i).getValorHisteresis():"", null);
			createCell(row, cont++, ev.get(i).getAlgprevfa()!=null && ev.get(i).getAlgprevfa()==1?"Si":"", null);
			createCell(row, cont++, UtilFechas.dateToString(ev.get(i).getFechaalta()), null);
			if(ev.get(i).getMotivoalta()!=null)
				if(ev.get(i).getMotivoalta()==1)
					createCell(row, cont++,"CURADO", null);
				else if(ev.get(i).getMotivoalta()==2)
					createCell(row, cont++,"TRASLADO", null);
				else if(ev.get(i).getMotivoalta()==3)
					createCell(row, cont++,"FUGADO", null);
				else if(ev.get(i).getMotivoalta()==4)
					createCell(row, cont++,"ORDEN MEDICA", null);
				else if(ev.get(i).getMotivoalta()==5)
					createCell(row, cont++,"VOLUNTARIA", null);
				else if(ev.get(i).getMotivoalta()==6)
					createCell(row, cont++,"DEFUNCION", null);
				else 
					createCell(row, cont++,"", null);
			
			fila++;
			cont = 0;
			
		}
	}
	
	private static void rellenaImpDESF(ArrayList<ArrPacientes> pacientes, ArrayList<SituacionClinicaProc> sitclin,
			ArrayList<ImpHojaImplante> himp, ArrayList<ImpEvolucion> ev,
			ArrayList<ImpGenerador> listgen, ArrayList<Generador> gens, ArrayList<Procedimiento> prs,
			ArrayList<EstadisticasImplanteBean> auxest){
		Integer fila = 1, filapaci = 0, cont = 0;		
		for(int i= 0; i < listgen.size(); i++){
			Row row = sheetIMPDESF.createRow(fila);
			createCell(row, cont++, pacientes.get(i).getNhc(), null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(pacientes.get(i).getFechanaci(),FORMATO), null);
			createCell(row, cont++, ""+UtilFechas.getEdad(pacientes.get(i).getFechanaci()), null);
			createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(prs.get(i).getFecha(),FORMATO), null);
			createCell(row, cont++, auxest.get(i).getTipoproc().toString(), null);//			
			createCell(row, cont++, gens.get(i).getModelo(), null);
			createCell(row, cont++, listgen.get(i).getNumserie(), null);
			createCell(row, cont++, gens.get(i).getFabricante(), null);
			String locgen="";
			if(listgen.get(i).getLocalizacion() != null ){
				switch (listgen.get(i).getLocalizacion()) {
				case 984:
					locgen = "SUBCLAVIAR IZQUIERDA";
					break;
				case 985:
					locgen = "SUBCLAVIAR DERECHA";
					break;
				case 986:
					locgen = "SUBCUTANEA IZQUIERDA";
					break;
				case 987:
					locgen = "SUBCUTANEA DERECHA";
					break;
				case 988:
					locgen = "SUBPECTORAL IZQUIERDA";
					break;
				case 989:
					locgen = "SUBPECTORAL DERECHA";
					break;
				case 990:
					locgen = "ABDOMINAL SUBCUTANEA";
					break;
				case 991:
					locgen = "ABDOMINAL RETROMUSCULAR";
					break;
				case 992:
					locgen = "OTRA";
					break;
				default:
					locgen = "NO ESPECIFICADO";
					break;
				}
				createCell(row, cont++, locgen, null);
			}else{
				createCell(row, cont++, "NO ESPECIFICADO", null);
			}	
			if(himp.get(i).getTindicacion()!=null)
				if(himp.get(i).getTindicacion()==1)
					createCell(row, cont++, "PRIMARIA", null);
				else if(himp.get(i).getTindicacion()==2)
					createCell(row, cont++, "SECUNDARIA", null);
				else if(himp.get(i).getTindicacion()==3)
					createCell(row, cont++, "DESCONOCIDA", null);
				else
					createCell(row, cont++, "", null);
			
			if(himp.get(i).getImplantador()!=null)
				if(himp.get(i).getImplantador()==1)
					createCell(row, cont++, "CIRUJANO", null);
				else if(himp.get(i).getImplantador()==2)
					createCell(row, cont++, "ELECTROFISIÓLOGO", null);
				else if(himp.get(i).getImplantador()==3)
					createCell(row, cont++, "INTENSIVISTA", null);
				else if(himp.get(i).getImplantador()==4)
					createCell(row, cont++, "EEF+CIRUJANO", null);
				else
					createCell(row, cont++, "OTRO", null);
			createCell(row, cont++, auxest.get(i).getEnf(), null);
			createCell(row, cont++, auxest.get(i).getPop(), null);
			createCell(row, cont++, auxest.get(i).getSop(), null);
			if(himp.get(i).getPrioridad()!=null)
				if(himp.get(i).getPrioridad()==1)
					createCell(row, cont++, "EMERGENCIA", null);
				else if(himp.get(i).getPrioridad()==2)
					createCell(row, cont++, "URGENCIA", null);
				else if(himp.get(i).getPrioridad()==3)
					createCell(row, cont++, "PREFERENTE", null);
				else if(himp.get(i).getPrioridad()==4)
					createCell(row, cont++, "PRIOTOTARIO", null);
				else if(himp.get(i).getPrioridad()==5)
					createCell(row, cont++, "ELECTIVO", null);
				else
					createCell(row, cont++, "", null);
			if(himp.get(i).getLugarimp()!=null)
				if(himp.get(i).getLugarimp()==1)
					createCell(row, cont++, "LAB. ELECTROFISIOLOGIA", null);
				else if(himp.get(i).getLugarimp()==2)
					createCell(row, cont++, "QUIROFANO", null);
				else if(himp.get(i).getLugarimp()==3)
					createCell(row, cont++, "OTRO", null);
				else
					createCell(row, cont++, "", null);
			if(himp.get(i).getTanestesia()!=null)
				if(himp.get(i).getTanestesia()==1)
					createCell(row, cont++, "LOCAL", null);
				else if(himp.get(i).getTanestesia()==2)
					createCell(row, cont++, "REGIONAL", null);
				else if(himp.get(i).getTanestesia()==3)
					createCell(row, cont++, "GENERAL", null);
				else
					createCell(row, cont++, "", null);
			
			createCell(row, cont++, himp.get(i).getTescopia()!=null?himp.get(i).getTescopia():"", null);
			createCell(row, cont++, "HORA LLEGADA", null);
			createCell(row, cont++, "HORA INICIO", null);
			createCell(row, cont++, "HORA FIN", null);
			createCell(row, cont++, "HORA SALIDA", null);
			createCell(row, cont++, himp.get(i).getEnergiatest()!=null?himp.get(i).getEnergiatest():"", null);
			createCell(row, cont++, himp.get(i).getImptest()!=null?himp.get(i).getImptest():"", null);
			createCell(row, cont++, himp.get(i).getNumchoqtest()!=null?himp.get(i).getNumchoqtest():"", null);
			
			fila++;
			cont = 0;
		}
		fila = 1; filapaci = 0; cont = 0;		
		for(int i= 0; i < sitclin.size(); i++){
			Row row = sheetIMPDESF_IND.createRow(fila);
			createCell(row, cont++, pacientes.get(i).getNhc(), null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(pacientes.get(i).getFechanaci(),FORMATO), null);
			createCell(row, cont++, "EDAD", null);
			createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			createCell(row, cont++, auxest.get(i).getRitmo().toString(), null);//
			createCell(row, cont++, auxest.get(i).getConduccionav().toString(), null);//
			createCell(row, cont++, auxest.get(i).getQrs().toString(), null);//
			createCell(row, cont++, sitclin.get(i).getFevi()!=null?sitclin.get(i).getFevi():"", null);//
			createCell(row, cont++, auxest.get(i).getFuncionventricular()!=null?auxest.get(i).getFuncionventricular():"", null);//
			createCell(row, cont++, sitclin.get(i).getNyha()!=null?sitclin.get(i).getNyha().toString():"", null);//
			createCell(row, cont++, auxest.get(i).getCardiopatia()!=null?auxest.get(i).getCardiopatia().toString():"", null);//
			createCell(row, cont++, sitclin.get(i).getAevolucion()!=null?sitclin.get(i).getAevolucion():"", null);
			if(sitclin.get(i).getRevasc()!=null)
				createCell(row, cont++,sitclin.get(i).getRevasc()==1?"Si":"", null);
			else
				createCell(row, cont++,"", null);
			
			if(sitclin.get(i).getInfprevio()!=null)
				createCell(row, cont++,sitclin.get(i).getInfprevio()==1?"Si":"", null);
			else
				createCell(row, cont++,"", null);
			
			createCell(row, cont++,sitclin.get(i).getInsrenal()!=null && sitclin.get(i).getInsrenal()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getDiabetes()!=null && sitclin.get(i).getDiabetes()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getAntfa()!=null && sitclin.get(i).getAntfa()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getHipertension()!=null && sitclin.get(i).getHipertension()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getMuertesubita()!=null && sitclin.get(i).getMuertesubita()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getTabaquismo()!=null && sitclin.get(i).getTabaquismo()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getHipercolest()!=null && sitclin.get(i).getHipercolest()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getAcv()!=null && sitclin.get(i).getAcv()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getTrasplantecardiaco()!=null && sitclin.get(i).getTrasplantecardiaco()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getAit()!=null && sitclin.get(i).getAit()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getSincope()!=null && sitclin.get(i).getSincope()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getParadacardiaca()!=null && sitclin.get(i).getParadacardiaca()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getEpoc()!=null && sitclin.get(i).getEpoc()==1?"Si":"", null);
			createCell(row, cont++,sitclin.get(i).getSahs()!=null && sitclin.get(i).getSahs()==1?"Si":"", null);
			createCell(row, cont++,auxest.get(i).getAfectiroidea()!=null?auxest.get(i).getAfectiroidea():"", null);//
			createCell(row, cont++,auxest.get(i).getNeuromediados()!=null ?auxest.get(i).getNeuromediados():"", null);//
			
			fila++;
			cont = 0;
			
		}
		fila = 1; filapaci = 0; cont = 0;		
		for(int i= 0; i < ev.size(); i++){
			Row row = sheetIMPDESF_EV.createRow(fila);
			createCell(row, cont++, pacientes.get(i).getNhc(), null);
			createCell(row, cont++, UtilFechas.getFechaStringFormato(pacientes.get(i).getFechanaci(),FORMATO), null);
			createCell(row, cont++, "EDAD", null);
			createCell(row, cont++, pacientes.get(i).getSexo()!=null?ToString(pacientes.get(i).getSexo()).startsWith("1")?"H":"M":"", null);
			createCell(row, cont++, auxest.get(i).getHospitalproc()!=null?auxest.get(i).getHospitalproc():"", null);
			createCell(row, cont++, auxest.get(i).getCaracterproc()!=null?auxest.get(i).getCaracterproc():"", null);
			createCell(row, cont++, ev.get(i).getMpdependiente()!=null && ev.get(i).getMpdependiente()==1?"Si":"", null);
			createCell(row, cont++, auxest.get(i).getModo()!=null?auxest.get(i).getModo():"", null);
			createCell(row, cont++, ev.get(i).getFbasica()!=null?ev.get(i).getFbasica():"", null);
			createCell(row, cont++, ev.get(i).getSegremoto()!=null && ev.get(i).getSegremoto()==1?"Si":"", null);
			createCell(row, cont++, ev.get(i).getMev()!=null && ev.get(i).getMev()==1?"Si":"", null);
			createCell(row, cont++, ev.get(i).getIavdetec()!=null?ev.get(i).getIavdetec():"", null);
			createCell(row, cont++, ev.get(i).getIavestim()!=null?ev.get(i).getIavestim():"", null);
			createCell(row, cont++, ev.get(i).getIavmax()!=null?ev.get(i).getIavmax():"", null);
			createCell(row, cont++, ev.get(i).getIavmin()!=null?ev.get(i).getIavmin():"", null);
			createCell(row, cont++, ev.get(i).getAmpPostch()!=null?ev.get(i).getAmpPostch():"", null);
			createCell(row, cont++, ev.get(i).getFrecPostch()!=null?ev.get(i).getFrecPostch():"", null);
			createCell(row, cont++, ev.get(i).getDurpulsoPostch()!=null?ev.get(i).getDurpulsoPostch():"", null);
			createCell(row, cont++, ev.get(i).getDurPostch()!=null?ev.get(i).getDurPostch():"", null);
			if(ev.get(i).getConfch()!=null)
				if(ev.get(i).getConfch()==1)
					createCell(row, cont++, "CARCASA A VD", null);
				else if(ev.get(i).getConfch()==2)
					createCell(row, cont++, "VCS A VD", null);
				else if(ev.get(i).getConfch()==3)
					createCell(row, cont++, "CARCASA + VCS A VD", null);
				else if(ev.get(i).getConfch()==4)
					createCell(row, cont++, "VD A CARCASA", null);
				else if(ev.get(i).getConfch()==5)
					createCell(row, cont++, "VD A VCS", null);
				else if(ev.get(i).getConfch()==6)
					createCell(row, cont++, "VD A CARCASA + VCS", null);
				else
					createCell(row, cont++, "", null);
			
			createCell(row, cont++, ev.get(i).getFmax()!=null?ev.get(i).getFmax():"", null);
			createCell(row, cont++, ev.get(i).getFmin()!=null?ev.get(i).getFmin():"", null);
			createCell(row, cont++, ev.get(i).getValorHisteresis()!=null?ev.get(i).getValorHisteresis():"", null);
			createCell(row, cont++, ev.get(i).getAlgprevfa()!=null && ev.get(i).getAlgprevfa()==1?"Si":"", null);
			
			createCell(row, cont++, ev.get(i).getNumepisodios()!=null?ev.get(i).getNumepisodios():"", null);
			createCell(row, cont++, ev.get(i).getNumepitsv()!=null?ev.get(i).getNumepitsv():"", null);
			createCell(row, cont++, ev.get(i).getNumepitv()!=null?ev.get(i).getNumepitv():"", null);
			createCell(row, cont++, ev.get(i).getNumepifv()!=null?ev.get(i).getNumepifv():"", null);
			createCell(row, cont++, ev.get(i).getNumepinosost()!=null?ev.get(i).getNumepinosost():"", null);
			createCell(row, cont++, ev.get(i).getNumepiotros()!=null?ev.get(i).getNumepiotros():"", null);
			createCell(row, cont++, ev.get(i).getNumteratp()!=null?ev.get(i).getNumteratp():"", null);
			createCell(row, cont++, ev.get(i).getTerefecatp()!=null && ev.get(i).getTerefecatp()==1?"Si":"", null);
			createCell(row, cont++, ev.get(i).getNumchoque()!=null?ev.get(i).getNumchoque():"", null);
			createCell(row, cont++, ev.get(i).getTereefecchoq()!=null && ev.get(i).getTereefecchoq()==1?"Si":"", null);
			createCell(row, cont++, ev.get(i).getEnergiachoque()!=null?ev.get(i).getEnergiachoque():"", null);
			createCell(row, cont++, ev.get(i).getTcargachoque()!=null?ev.get(i).getTcargachoque():"", null);
			createCell(row, cont++, ev.get(i).getImpchoque()!=null?ev.get(i).getImpchoque():"", null);
			
			
			createCell(row, cont++, UtilFechas.getFechaStringFormato(ev.get(i).getFechaalta(),FORMATO), null);
			if(ev.get(i).getMotivoalta()!=null)
				if(ev.get(i).getMotivoalta()==1)
					createCell(row, cont++,"CURADO", null);
				else if(ev.get(i).getMotivoalta()==2)
					createCell(row, cont++,"TRASLADO", null);
				else if(ev.get(i).getMotivoalta()==3)
					createCell(row, cont++,"FUGADO", null);
				else if(ev.get(i).getMotivoalta()==4)
					createCell(row, cont++,"ORDEN MEDICA", null);
				else if(ev.get(i).getMotivoalta()==5)
					createCell(row, cont++,"VOLUNTARIA", null);
				else if(ev.get(i).getMotivoalta()==6)
					createCell(row, cont++,"DEFUNCION", null);
				else 
					createCell(row, cont++,"", null);
			
			fila++;
			cont = 0;
			
		}
	}
	
	private static void rellenaREG(ArrayList<ArrayList<Object>> res){
		Integer fila = 1, filapaci = 0, cont = 0;		
		for(int i= 0; i < res.size(); i++){
			ArrayList<Object> obj = res.get(i);
			Row row = sheetREG.createRow(fila);
			createCell(row, cont++, obj.get(21)!=null?obj.get(21).toString():"", null);//CIP
			createCell(row, cont++, obj.get(0)!=null?obj.get(0).toString():"", null);//nhc
			
			createCell(row, cont++, obj.get(18)!=null?(String)obj.get(18):"", null); //NOMBRE
			createCell(row, cont++, obj.get(19)!=null?(String)obj.get(19):"", null); //APELLIDO1
			createCell(row, cont++, obj.get(20)!=null?(String)obj.get(20):"", null); //APELLIDO2
			
			createCell(row, cont++, obj.get(1)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(1), FORMATO):"", null);//fnacimiento
			createCell(row, cont++, obj.get(1)!=null?""+UtilFechas.getEdad((Date)obj.get(1)):"", null);//edad			
			createCell(row, cont++, obj.get(22)!=null?obj.get(22).toString():"", null);//NUM_PROC
			createCell(row, cont++, obj.get(2)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(2), FORMATO):"", null); // fecha
			createCell(row, cont++, obj.get(4)!=null&&!obj.get(4).equals("0")?obj.get(4).toString():"", null);//referidor
			createCell(row, cont++, obj.get(8)!=null&&!obj.get(8).equals("0")?obj.get(8).toString():"", null);//op_med
			createCell(row, cont++, obj.get(7)!=null&&!obj.get(7).equals("0")?obj.get(7).toString():"", null);//op_enf
			String ind="";
			if(obj.get(3)!= null){ // Indicacion
				switch ((Integer)obj.get(3)) {
				case 1:
					ind = "SINCOPE NEUROMEDIADO";
					break;
				case 2:
					ind = "SINCOPE INEXPLICADO";
					break;
				case 3:
					ind = "SINCOPE CON TRAUMATISMO O ENTORNO LABORAL DE RIESGO";
					break;
				case 4:
					ind = "CAIDA";
					break;
				case 5:
					ind = "PALPITACIONES";
					break;
				case 6:
					ind = "ICTUS";
					break;
				case 7:
					ind = "FIBRILACION AURICULAR";
					break;
				case 8:
					ind = "POST-ABLACION FA";
					break;
				case 9:
					ind = "OTRO";
					break;
				default:
					ind = "";
					break;
				}
				createCell(row, cont++, ind, null);
			}else{
				createCell(row, cont++, "", null);
			}
			if(obj.get(5)!= null) // Indicacion Sincope
				createCell(row, cont++, obj.get(5).equals(0)?"NO(PRIMER EPISODIO)":"SI", null);
			createCell(row, cont++, obj.get(9)!=null?obj.get(9).toString():"", null);//modelo
			createCell(row, cont++, obj.get(17)!=null?obj.get(17).toString():"", null);//nserie
			String zona="";
			if(obj.get(10) != null){ // Zona
				switch ((Integer)obj.get(10)) {
				case 1:
					zona = "PARAESTERNAL IZQUIERDA";
					break;
				case 2:
					zona = "SUBCLAVIA IZQUIERDA";
					break;
				case 3:
					zona = "INFRAMAMARIA";
					break;
				case 4:
					zona = "AXILAR";
					break;
				case 5:
					zona = "OTRA";
					break;
				default:
					zona = "";
					break;
				}
				createCell(row, cont++, zona, null);
			}else{
				createCell(row, cont++, "", null);
			}
			createCell(row, cont++, obj.get(12)!=null?UtilFechas.getFechaStringFormato((Date)obj.get(12), FORMATO):"", null);//Fecha explante
			String diag="";
			if(obj.get(15) != null){// motivo/diagnostico explante
				switch ((Integer)obj.get(15)) {
				case 1:
					diag = "SIN DIAGNOSTICO";
					break;
				case 2:
					diag = "SINCOPE DE ORIGEN ARRITMICO";
					break;
				case 3:
					diag = "SINCOPE DE ORIGEN NO ARRITMICO";
					break;
				case 4:
					diag = "DETECCION DE ARRITMIA CLINICA";
					break;
				case 5:
					diag = "OTRO";
					break;
				case 6:
					diag = "AGOTAMIENTO DE BATERIA";
					break;
				case 7:
					diag = "INFECCION/DECUBITO";
					break;
				default:
					diag = "";
					break;
				}
				createCell(row, cont++, diag, null);
			}else{
				createCell(row, cont++, "", null);
			}
			createCell(row, cont++, obj.get(14)!=null&&!obj.get(14).equals("0")?(String)obj.get(14):"", null);// op_med explante
			createCell(row, cont++, obj.get(13)!=null&&!obj.get(13).equals("0")?(String)obj.get(13):"", null); //op_enf explante
			createCell(row, cont++, obj.get(16)!=null&&!obj.get(16).equals("0")?(String)obj.get(16):"", null); //complicaciones
			
			fila++;
			cont = 0;
		}
	}
	
	private static void rellenaMESA(ArrayList<ArrayList<Object>> res){
		Integer fila = 1, filapaci = 0, cont = 0;		
		for(int i= 0; i < res.size(); i++){
			ArrayList<Object> obj = res.get(i);
			Row row = sheetMESA.createRow(fila);
			createCell(row, cont++, obj.get(20)!=null?obj.get(20).toString():"", null);//CIP
			createCell(row, cont++, obj.get(0)!=null?obj.get(0).toString():"", null);//nhc
			
			createCell(row, cont++, obj.get(17)!=null?obj.get(17).toString():"", null);//nombre
			createCell(row, cont++, obj.get(18)!=null?obj.get(18).toString():"", null);//ap1
			createCell(row, cont++, obj.get(19)!=null?obj.get(19).toString():"", null);//ap2
			
			createCell(row, cont++, obj.get(1)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(1), FORMATO):"", null);//fnacimiento
			createCell(row, cont++, obj.get(1)!=null?""+UtilFechas.getEdad((Date)obj.get(1)):"", null);//edad
			createCell(row, cont++, obj.get(21)!=null?obj.get(21).toString():"", null);//NPROC
			createCell(row, cont++, obj.get(2)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(2), FORMATO):"", null); // fecha procedimiento
			
			createCell(row, cont++, obj.get(4)!=null&&!obj.get(4).equals("0")?obj.get(4).toString():"", null);//referidor		
			createCell(row, cont++, obj.get(9)!=null&&!obj.get(9).equals("0")?obj.get(9).toString():"", null);//op_med
			createCell(row, cont++, obj.get(8)!=null&&!obj.get(8).equals("0")?obj.get(8).toString():"", null);//op_enf
			if(obj.get(16)!=null)//NTG
				createCell(row, cont++, obj.get(16).equals(0)?"NO":"SI", null);		
			String ind="";
			if(obj.get(5) != null){ // Indicacion
				switch ((Integer)obj.get(5)) {
				case 1:
					ind = "SINCOPE NEUROMEDIADO";
					break;
				case 2:
					ind = "SINCOPE INEXPLICADO";
					break;
				case 3:
					ind = "SINCOPE CON TRAUMATISMO O ENTORNO LABORAL DE RIESGO";
					break;
				case 4:
					ind = "CAIDA";
					break;
				case 5:
					ind = "CONVULSIONES NO FILIADAS";
					break;
				case 6:
					ind = "OTRO";
					break;
				default:
					ind = "";
					break;
				}
				createCell(row, cont++, ind, null);
			}else{
				createCell(row, cont++, "", null);
			}			
			if(obj.get(6)!=null) // Episodios presincopales previos
				createCell(row, cont++, obj.get(6).equals(0)?"NO":"SI", null);			
			if(obj.get(7)!=null)
				createCell(row, cont++, obj.get(7).toString(), null);			
			if(obj.get(3)!=null)
				createCell(row, cont++, obj.get(3).equals(0)?"NEGATIVO":"POSITIVO", null);
			if(obj.get(11)!=null){
				if(obj.get(11).equals(0)){ // Respuesta
					if(obj.get(12)!=null){
						if(obj.get(12).equals(1))
							createCell(row, cont++, "TIPO 1 - MIXTO", null);
						else if(obj.get(12).equals(2))
							createCell(row, cont++, "TIPO 2A - CARDIOINHIBITORIO SIN ASITOLIA", null);
						else if(obj.get(12).equals(3))
							createCell(row, cont++, "TIPO 2B - CARDIOINHIBITORIO CON ASITOLIA >3s", null);
						else if(obj.get(12).equals(4))
							createCell(row, cont++, "TIPO 3 - VASODEPRESOR PURO", null);
						else
							createCell(row, cont++, "", null);
						createCell(row, cont++, "", null);// celda vacia tiempo
						createCell(row, cont++, "", null);// celda vacia BAV
					}else{
						createCell(row, cont++, "", null);
					}
				}else if(obj.get(11).equals(1)){ // Tiempo
					createCell(row, cont++, "", null);// celda vacia Tipo
					createCell(row, cont++, obj.get(14)!=null?obj.get(14).toString():"", null);
					if(obj.get(12)!=null){
						if(obj.get(12).equals(1))
							createCell(row, cont++, "SI", null);
						else
							createCell(row, cont++, "NO", null);
					}else{
						createCell(row, cont++, "", null);
					}
				}else{
					createCell(row, cont++, "", null);// celda vacia Tipo
					createCell(row, cont++, "", null);// celda vacia Tiempo
					createCell(row, cont++, "", null);// celda vacia BAV
				}
			}else{
				createCell(row, cont++, "", null);
				createCell(row, cont++, "", null);
				createCell(row, cont++, "", null);
				createCell(row, cont++, "", null);
			}
				
			if(obj.get(15)!=null)
				if(obj.get(15).equals(1))
					createCell(row, cont++, "SI", null);
				else if(obj.get(15).equals(0))
					createCell(row, cont++, "NO", null);
				else
					createCell(row, cont++, "", null);
			fila++;
			cont = 0;
		}
	}

	private static void rellenaHOLTER(ArrayList<ArrayList<Object>> res){
		Integer fila = 1, filapaci = 0, cont = 0;		
		for(int i= 0; i < res.size(); i++){
			ArrayList<Object> obj = res.get(i);
			Row row = sheetHOLTER.createRow(fila);
			createCell(row, cont++, obj.get(25)!=null?obj.get(25).toString():"", null);// CIP
			createCell(row, cont++, obj.get(0)!=null?obj.get(0).toString():"", null);// NHC
			
			createCell(row, cont++, obj.get(1)!=null?(String)obj.get(1):"", null); //NOMBRE
			createCell(row, cont++, obj.get(2)!=null?(String)obj.get(2):"", null); //APELLIDO1
			createCell(row, cont++, obj.get(3)!=null?(String)obj.get(3):"", null); //APELLIDO2
			
			createCell(row, cont++, obj.get(4)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(4), FORMATO):"", null);//fnacimiento
			createCell(row, cont++, obj.get(4)!=null?""+UtilFechas.getEdad((Date)obj.get(4)):"", null);//edad			
			createCell(row, cont++, obj.get(5)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(5), FORMATO):"", null); // fecha PROCEDIMIENTO
			createCell(row, cont++, obj.get(6)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(6), FORMATO):"", null); // FECHA COLOCACION
			createCell(row, cont++, obj.get(7)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(7), FORMATO):"", null); // FECHA LECTURA
			createCell(row, cont++, obj.get(8)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(8), FORMATO):"", null); // FECHA RETIRADA
			createCell(row, cont++, obj.get(9)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(9), FORMATO):"", null); // FECHA ANALISIS
			String estado = "";
			if(obj.get(10)!= null){
				switch ((Integer)obj.get(10)){
				case 0:
					estado = "PENDIENTE DE LECTURA";
					break;
				case 1:
					estado = "LEIDO - PENDIENTE DE ANALISIS";
					break;
				case 2:
					estado = "DESCARGADO - EN ANALISIS";
					break;
				case 3:
					estado = "ANALIZADO CON INFORME ASOCIADO";
					break;
				case 4:
					estado = "INTEGRADO EN HCE";
					break;
				default:
					estado = "";
					break;
				}
				createCell(row, cont++, estado, null);
			}else{
				createCell(row, cont++, "", null);
			}
			createCell(row, cont++, obj.get(11)!=null?(String)obj.get(11):"", null); // COMENTARIOS COLOCACION
			createCell(row, cont++, obj.get(12)!=null?(String)obj.get(12):"", null); // COMENTARIOS ANALISIS
			createCell(row, cont++, obj.get(13)!=null?(String)obj.get(13):"", null); // RECOMENDACIONES
			String diag_ini = "";
			if(obj.get(14)!= null){
				switch ((Integer)obj.get(14)){
				case 0:
					diag_ini = "NO ESPECIFICADO";
					break;
				case 1:
					diag_ini = "SINCOPE";
					break;
				case 2:
					diag_ini = "MAREOS";
					break;
				case 3:
					diag_ini = "PALPITACIONES";
					break;
				case 4:
					diag_ini = "OTROS";
					break;
				default:
					diag_ini = "";
					break;
				}
				createCell(row, cont++, diag_ini, null);
			}else{
				createCell(row, cont++, "", null);
			}
			createCell(row, cont++, obj.get(23)!=null?(String)obj.get(23):"", null); // DIAGNOSTICO INICIAL OTRO
			String diag_fin = "";
			if(obj.get(15)!= null){
				switch ((Integer)obj.get(15)){
				case 0:
					diag_fin = "NO ESPECIFICADO";
					break;
				case 1:
					diag_fin = "SINCOPE";
					break;
				case 2:
					diag_fin = "MAREOS";
					break;
				case 3:
					diag_fin = "PALPITACIONES";
					break;
				case 4:
					diag_fin = "OTROS";
					break;
				default:
					diag_fin = "";
					break;
				}
				createCell(row, cont++, diag_fin, null);
			}else{
				createCell(row, cont++, "", null);
			}
			createCell(row, cont++, obj.get(24)!=null?(String)obj.get(24):"", null); // DIAGNOSTICO FINAL OTRO
			createCell(row, cont++, obj.get(16)!=null?(String)obj.get(16):"", null); // REFERIDOR
			createCell(row, cont++, obj.get(17)!=null?(String)obj.get(17):"", null); // COLOCACION_OP_ENF
			createCell(row, cont++, obj.get(18)!=null?(String)obj.get(18):"", null); // COLOCACION_OP_MED
			createCell(row, cont++, obj.get(19)!=null?(String)obj.get(19):"", null); // ANALISIS_OP_MED
			createCell(row, cont++, obj.get(20)!=null?(String)obj.get(20):"", null); // RETIRADA_OP_MED
			createCell(row, cont++, obj.get(21)!=null?(String)obj.get(21):"", null); // RETIRADA_OP_ENF
			createCell(row, cont++, obj.get(22)!=null?(String)obj.get(22):"", null); // NUMERO_PROCEDIMIENTO
			
			fila++;
			cont = 0;
		}
	}
	
	private static void rellenaREGEVEXT(ArrayList<ArrayList<Object>> res){
		Integer fila = 1, filapaci = 0, cont = 0;		
		for(int i= 0; i < res.size(); i++){
			ArrayList<Object> obj = res.get(i);
			Row row = sheetREGEVEXT.createRow(fila);
			createCell(row, cont++, obj.get(25)!=null?obj.get(25).toString():"", null);// CIP
			createCell(row, cont++, obj.get(0)!=null?obj.get(0).toString():"", null);// NHC
			
			createCell(row, cont++, obj.get(1)!=null?(String)obj.get(1):"", null); //NOMBRE
			createCell(row, cont++, obj.get(2)!=null?(String)obj.get(2):"", null); //APELLIDO1
			createCell(row, cont++, obj.get(3)!=null?(String)obj.get(3):"", null); //APELLIDO2
			
			createCell(row, cont++, obj.get(4)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(4), FORMATO):"", null);//fnacimiento
			createCell(row, cont++, obj.get(4)!=null?""+UtilFechas.getEdad((Date)obj.get(4)):"", null);//edad			
			createCell(row, cont++, obj.get(5)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(5), FORMATO):"", null); // fecha PROCEDIMIENTO
			createCell(row, cont++, obj.get(6)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(6), FORMATO):"", null); // FECHA COLOCACION
			createCell(row, cont++, obj.get(7)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(7), FORMATO):"", null); // FECHA LECTURA
			createCell(row, cont++, obj.get(8)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(8), FORMATO):"", null); // FECHA RETIRADA
			createCell(row, cont++, obj.get(9)!=null?UtilFechas.getFechaStringFormato((Date) obj.get(9), FORMATO):"", null); // FECHA ANALISIS
			String estado = "";
			if(obj.get(10)!= null){
				switch ((Integer)obj.get(10)){
				case 0:
					estado = "PENDIENTE DE LECTURA";
					break;
				case 1:
					estado = "LEIDO - PENDIENTE DE ANALISIS";
					break;
				case 2:
					estado = "DESCARGADO - EN ANALISIS";
					break;
				case 3:
					estado = "ANALIZADO CON INFORME ASOCIADO";
					break;
				case 4:
					estado = "INTEGRADO EN HCE";
					break;
				default:
					estado = "";
					break;
				}
				createCell(row, cont++, estado, null);
			}else{
				createCell(row, cont++, "", null);
			}
			createCell(row, cont++, obj.get(11)!=null?(String)obj.get(11):"", null); // COMENTARIOS COLOCACION
			createCell(row, cont++, obj.get(12)!=null?(String)obj.get(12):"", null); // COMENTARIOS ANALISIS
			createCell(row, cont++, obj.get(13)!=null?(String)obj.get(13):"", null); // RECOMENDACIONES
			String diag_ini = "";
			if(obj.get(14)!= null){
				switch ((Integer)obj.get(14)){
				case 0:
					diag_ini = "NO ESPECIFICADO";
					break;
				case 1:
					diag_ini = "SINCOPE";
					break;
				case 2:
					diag_ini = "MAREOS";
					break;
				case 3:
					diag_ini = "PALPITACIONES";
					break;
				case 4:
					diag_ini = "OTROS";
					break;
				default:
					diag_ini = "";
					break;
				}
				createCell(row, cont++, diag_ini, null);
			}else{
				createCell(row, cont++, "", null);
			}
			createCell(row, cont++, obj.get(23)!=null?(String)obj.get(23):"", null); // DIAGNOSTICO INICIAL OTRO
			String diag_fin = "";
			if(obj.get(15)!= null){
				switch ((Integer)obj.get(15)){
				case 0:
					diag_fin = "NO ESPECIFICADO";
					break;
				case 1:
					diag_fin = "SINCOPE";
					break;
				case 2:
					diag_fin = "MAREOS";
					break;
				case 3:
					diag_fin = "PALPITACIONES";
					break;
				case 4:
					diag_fin = "OTROS";
					break;
				default:
					diag_fin = "";
					break;
				}
				createCell(row, cont++, diag_fin, null);
			}else{
				createCell(row, cont++, "", null);
			}
			createCell(row, cont++, obj.get(24)!=null?(String)obj.get(24):"", null); // DIAGNOSTICO FINAL OTRO
			createCell(row, cont++, obj.get(16)!=null?(String)obj.get(16):"", null); // REFERIDOR
			createCell(row, cont++, obj.get(17)!=null?(String)obj.get(17):"", null); // COLOCACION_OP_ENF
			createCell(row, cont++, obj.get(18)!=null?(String)obj.get(18):"", null); // COLOCACION_OP_MED
			createCell(row, cont++, obj.get(19)!=null?(String)obj.get(19):"", null); // ANALISIS_OP_MED
			createCell(row, cont++, obj.get(20)!=null?(String)obj.get(20):"", null); // RETIRADA_OP_MED
			createCell(row, cont++, obj.get(21)!=null?(String)obj.get(21):"", null); // RETIRADA_OP_ENF
			createCell(row, cont++, obj.get(22)!=null?(String)obj.get(22):"", null); // NUMERO_PROCEDIMIENTO
			
			fila++;
			cont = 0;
		}
	}
	
	private static void rellenaPAT(ArrayList<PacienteAplDto> res){
		Integer fila = 1, filapaci = 0, cont = 0;
		
		for(int i= 0; i < res.size(); i++){
			Row row = sheetPAT.createRow(fila);
			createCell(row, cont++, res.get(i).getNhc()!=null?res.get(i).getNhc():"", null);// NHC
			
			createCell(row, cont++, res.get(i).getNombre()!=null?res.get(i).getNombre():"", null); //NOMBRE
			createCell(row, cont++, res.get(i).getApellid1()!=null?res.get(i).getApellid1():"", null); //APELLIDO1
			createCell(row, cont++, res.get(i).getApellid2()!=null?res.get(i).getApellid2():"", null); //APELLIDO2
			String tipo_proc = "", fecha_proc = "";
			if(res.get(i).getTipoproc()!= null){
				switch (res.get(i).getTipoproc()){
					case 1:
						tipo_proc = "EEF";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaeef(), FORMATO);
						break;
					case 2:
						tipo_proc = "Cardioversión eléctrica";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechacv(), FORMATO);
						break;
					case 3:
						tipo_proc = "Registrador de eventos";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechareg(), FORMATO);
						break;
					case 4:
						tipo_proc = "Mesa basculante";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechamesa(), FORMATO);
						break;
					case 5:
						tipo_proc = "Test farmacológico - ATP";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaatp(), FORMATO);
						break;
					case 6:
						tipo_proc = "Test farmacológico - EPINEFRINA";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaepi(), FORMATO);
						break;
					case 7:
						tipo_proc = "Test farmacológico - FLECAINIDA";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechafle(), FORMATO);
						break;
					case 956:
						tipo_proc = "Primo Implante";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaimp(), FORMATO);
						break;
					case 957:
						tipo_proc = "Reintervención";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaimp(), FORMATO);
						break;
					case 1059:
						tipo_proc = "Recambio";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaimp(), FORMATO);
						break;
					case 1060:
						tipo_proc = "Upgrade";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaimp(), FORMATO);
						break;
					case 1085:
						tipo_proc = "Recolocación de generador";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaimp(), FORMATO);
						break;
					case 1086:
						tipo_proc = "Recolocación de electrodo";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaimp(), FORMATO);
						break;
					case 1090:
						tipo_proc = "Reimplante";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaimp(), FORMATO);
						break;
					case 1147:
						tipo_proc = "Explante";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaimp(), FORMATO);
						break;
					case 11:
						tipo_proc = "Holter 24h";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFechaholter(), FORMATO);
						break;
					case 12:
						tipo_proc = "ELR";
						fecha_proc = UtilFechas.getFechaStringFormato(res.get(i).getFecharegevext(), FORMATO);
						break;
					default:
						tipo_proc = "";
						fecha_proc = "";
						break;
				}
				createCell(row, cont++, tipo_proc, null);
				createCell(row, cont++, fecha_proc, null);
			}else{
				createCell(row, cont++, "", null);
				createCell(row, cont++, "", null);
			}
			
			fila++;
			cont = 0;
		}
	}
	
	private static void rellenaRegNalDAI(ArrayList<RegistroDaiDto> res){
		Integer fila = 1, filapaci = 0, cont = 0;
		
		for(int i= 0; i < res.size(); i++){
			Row row = sheetRegNalDAI.createRow(fila);
			createCell(row, cont++, res.get(i).getFechaNac()!=null?UtilFechas.getFechaStringFormato(res.get(i).getFechaNac(), FORMATO):"", null);// FECHA NACIMIENTO
			createCell(row, cont++, res.get(i).getEdad()!=null?res.get(i).getEdad().toString():"", null); //EDAD - TODO
			createCell(row, cont++, res.get(i).getSexo(), null); // SEXO
			createCell(row, cont++, res.get(i).getSeg(), null); // SEG
			createCell(row, cont++, res.get(i).getPoblacion(), null); // POBLACION
			createCell(row, cont++, res.get(i).getHospImp(), null); // HOSPITAL IMPLANTE
			createCell(row, cont++, res.get(i).getHospProc(), null); // HOSPITAL PROCEDENCIA
			createCell(row, cont++, res.get(i).getCiudadHosp(), null); // HOSPITAL CIUDAD
			createCell(row, cont++, res.get(i).getCardiopatia(), null); // Cardiopatia
			createCell(row, cont++, res.get(i).getCardiopatiaOtra(), null); // Cardiopatia otra
			createCell(row, cont++, res.get(i).getAevol(), null); // Años de evolucion
			createCell(row, cont++, res.get(i).getRevasc(), null); // Revascularizacion
			createCell(row, cont++, res.get(i).getInfPrevio(), null); // Infarto Previo
			createCell(row, cont++, res.get(i).getInPrevAn(), null); // Infarto previo - año
			createCell(row, cont++, res.get(i).getFracEyec(), null); // Fraccion de eyeccion
			createCell(row, cont++, res.get(i).getIc(), null); // Ic
			createCell(row, cont++, res.get(i).getEnfCond(), null); // Enfermedad de la conduccion
			createCell(row, cont++, res.get(i).getRitmoBasal(), null); // Ritmo basal
			createCell(row, cont++, res.get(i).getRitmoBasalOtro(), null); // Ritmo basal otro
			createCell(row, cont++, res.get(i).getAntInsRenal(), null); // Insuf. renal
			createCell(row, cont++, res.get(i).getAntFa(), null); // FA
			createCell(row, cont++, res.get(i).getAntDiab(), null); // Diabetes
			createCell(row, cont++, res.get(i).getAntHta(), null); // HTa
			createCell(row, cont++, res.get(i).getAntMuerteSub(), null); // Muerte subita
			createCell(row, cont++, res.get(i).getAnchQRS(), null); // Anchura QRS
			createCell(row, cont++, res.get(i).getAntFum(), null); // fumador
			createCell(row, cont++, res.get(i).getAntDislip(), null); // Hipercolesterolemia
			createCell(row, cont++, res.get(i).getAntAcv(), null); // ACV
			createCell(row, cont++, res.get(i).getArritmiaClinica(), null); // ARRITMIA CLINICA
			createCell(row, cont++, res.get(i).getPresClinica(), null); // Presentacion clincia
			createCell(row, cont++, res.get(i).getPresClinciaOtros(), null); // Presentacion clincia otros
			createCell(row, cont++, res.get(i).getEef(), null); // EEF
			createCell(row, cont++, res.get(i).getEefArritmia(), null); // Presentacion clincia otros
			createCell(row, cont++, res.get(i).getPrevencion(), null); // PREVENCION
			createCell(row, cont++, res.get(i).getFechaImpl()!=null?UtilFechas.getFechaStringFormato(res.get(i).getFechaImpl(), FORMATO):"", null); // Fecha de implante
			createCell(row, cont++, res.get(i).getLugarImpl(), null); // Lugar de implante
			createCell(row, cont++, res.get(i).getImplantador(), null); // IMPLANTADOR
			createCell(row, cont++, res.get(i).getTipoProc(), null); // TIPO PROCEDIMIENTO
			createCell(row, cont++, res.get(i).getModeloGen(), null); // MODELO GENERADO
			createCell(row, cont++, res.get(i).getNserieGen(), null); // NUM. SERIE GENERADOR
			createCell(row, cont++, res.get(i).getLocGen(), null); // localizacion generador
			createCell(row, cont++, res.get(i).getFechaImplPrev()!=null?UtilFechas.getFechaStringFormato(res.get(i).getFechaImplPrev(), FORMATO):"", null); // Fecha de implante previo
			createCell(row, cont++, res.get(i).getMotivosRecambioAgot(), null); // motivo recambio agotamiento
			createCell(row, cont++, res.get(i).getMotivosRecambioCompl(), null); // motivo recambio complicaciones
			createCell(row, cont++, res.get(i).getMotivosRecambioUpgrade(), null); // motivo recambio upgrade
			createCell(row, cont++, res.get(i).getEpiTVFV(), null); // episodios tv-fv
			createCell(row, cont++, res.get(i).getTerapiaATP(), null); // terapia ATP
			createCell(row, cont++, res.get(i).getTerapiaChoques(), null); // terapia choques
			createCell(row, cont++, res.get(i).getAd()!=null && res.get(i).getAd()?"SI":"NO", null); // Electrodo AD
			createCell(row, cont++, res.get(i).getModeloAD(), null); // Modelo Electrodo AD
			createCell(row, cont++, res.get(i).getNserieAD(), null); // Num. Serie electro AD
			createCell(row, cont++, res.get(i).getVd()!=null && res.get(i).getVd()?"SI":"NO", null); // Electrodo VD
			createCell(row, cont++, res.get(i).getModeloVD(), null); // Modelo Electrodo VD
			createCell(row, cont++, res.get(i).getNserieVD(), null); // Num. Serie electro VD
			createCell(row, cont++, res.get(i).getVi()!=null && res.get(i).getVi()?"SI":"NO", null); // Electrodo VI
			createCell(row, cont++, res.get(i).getModeloVI(), null); // Modelo Electrodo VI
			createCell(row, cont++, res.get(i).getNserieVI(), null); // Num. Serie electro VI
			createCell(row, cont++, res.get(i).getElecPrevFunc()!=null && res.get(i).getElecPrevFunc()?"SI":"NO", null); // Electrodo previos funcionantes
			createCell(row, cont++, res.get(i).getElecPrevDisf()!=null && res.get(i).getElecPrevDisf()?"SI":"NO", null); // Electrodo previos disfuncionantes
			createCell(row, cont++, res.get(i).getElecPrevDisfAband()!=null && res.get(i).getElecPrevDisfAband()?"SI":"NO", null); // Electrodo previos disfuncionantes abandonados
			createCell(row, cont++, res.get(i).getElecPrevDisfExpl()!=null && res.get(i).getElecPrevDisfExpl()?"SI":"NO", null); // Electrodo previos disfuncionantes explantado
			createCell(row, cont++, res.get(i).getInduccion()!=null && res.get(i).getInduccion()?"SI":"NO", null); // induccion
			createCell(row, cont++, res.get(i).getInduccionEnergia(), null); // Induccion energia
			createCell(row, cont++, res.get(i).getInduccionNumChoques(), null); // Induccion numero de choques
			createCell(row, cont++, res.get(i).getCompliNinguna(), null); // complicacion ninguna
			createCell(row, cont++, res.get(i).getCompliMuerte(), null); // complicacion muerte
			createCell(row, cont++, res.get(i).getCompliTapCard(), null); // complicacion taponamiento cardiaco
			createCell(row, cont++, res.get(i).getCompliNeumo(), null); // complicacion neumotorax
			createCell(row, cont++, res.get(i).getCompliDiseccionSC(), null); // complicacion diseccion SC
			createCell(row, cont++, res.get(i).getCompliSitSubOptima(), null); // complicacion situacion suboptima vi
			createCell(row, cont++, res.get(i).getCompliOtro(), null); // complicacion otro
			createCell(row, cont++, res.get(i).getEstimAntiBradi(), null); // estimulacion antibradicardia
			createCell(row, cont++, res.get(i).getMev(), null); // mev
			createCell(row, cont++, res.get(i).getAtpProg(), null); // modelo atp programada
			createCell(row, cont++, res.get(i).getModelo(), null); // modelo
			
			fila++;
			cont = 0;
		}
	}
	
	private static void rellenaMatGen(Generador[] res){
		Integer fila = 1, cont = 0;		
		for(int i= 0; i < res.length; i++){
			Row row = sheetMatGen.createRow(fila);
			
			createCell(row, cont++, res[i].getModelo(), null); // MODELO
			createCell(row, cont++, res[i].getFabricante()!=null?res[i].getFabricante():"", null); // FABRICANTE
			String tipo = "";									
			if(res[i].getTipo()!= null){
				if(res[i].getTipo().equals("1"))
					tipo = "MARCAPASOS";
				else if(res[i].getTipo().equals("2"))
					tipo = "DAI";
				if(res[i].getTipo().equals("3"))
					tipo = "CRT-P";
				if(res[i].getTipo().equals("4"))
					tipo = "CRT-D";
				if(res[i].getTipo().equals("5"))
					tipo = "MARCAPASOS SIN CABLE";
				if(res[i].getTipo().equals("6"))
					tipo = "S-ICD";
				createCell(row, cont++, tipo, null);
			}else{
				createCell(row, cont++, "", null);
			}
			createCell(row, cont++, res[i].getModo()!=null?res[i].getModo():"", null); // MODO
			createCell(row, cont++, res[i].getConectorad()!=null?res[i].getConectorad():"", null); // CONECTOR AD
			createCell(row, cont++, res[i].getConectorvd()!=null?res[i].getConectorvd():"", null); // CONECTOR VD
			createCell(row, cont++, res[i].getConectorvi()!=null?res[i].getConectorvi():"", null); // CONECTOR VI
			String rf = "";
			if(res[i].getRf()!=null)
				rf = res[i].getRf().equals((short)1)?"Si":"No";
			createCell(row, cont++, rf, null); // RF
			String mri = "";
			if(res[i].getMri()!=null)
				mri = res[i].getMri().equals((short)1)?"Si":"No";
			createCell(row, cont++, mri, null); // MRI
			createCell(row, cont++, res[i].getCodigo()!=null?res[i].getCodigo():"", null); // REFERENCIA
			createCell(row, cont++, res[i].getConectorVd2()!=null?res[i].getConectorVd2():"", null); // CONECTOR VD2
			createCell(row, cont++, res[i].getConectorvcs()!=null?res[i].getConectorvcs():"", null); // CONECTOR VCS
			createCell(row, cont++, res[i].getIdrx()!=null?res[i].getIdrx():"", null); // ID RX
			String activo = "";
			if(res[i].getActivo()!=null)
				activo = res[i].getActivo().equals((Integer)1)?"Si":"No";
			createCell(row, cont++, activo, null); // ACTIVO
			
			String gs128 = "";
			if(res[i].getCodigos()!=null){
				for(Codigosgs128 cod:res[i].getCodigos())
					gs128 += cod.getCodigo()+", ";
				if(!gs128.equals(""))
					gs128 = gs128.substring(0,gs128.length()-2);
			}
			createCell(row, cont++, gs128, null); // GS1-128
			
			fila++;
			cont = 0;
		}
	}
	private static void rellenaMatEle(Electrodos[] res){
		Integer fila = 1, cont = 0;		
		for(int i= 0; i < res.length; i++){
			Row row = sheetMatEle.createRow(fila);
			createCell(row, cont++, res[i].getModelo(), null); // MODELO
			createCell(row, cont++, res[i].getFabricante()!=null?res[i].getFabricante():"", null); // FABRICANTE
			createCell(row, cont++, res[i].getPolaridad()!=null?res[i].getPolaridad():"", null); // POLARIDAD
			createCell(row, cont++, res[i].getFijacion()!=null?res[i].getFijacion():"", null); // FIJACION
			createCell(row, cont++, res[i].getBobina()!=null?res[i].getBobina():"", null); // BOBINA
			createCell(row, cont++, res[i].getConector()!=null?res[i].getConector():"", null); // CONECTOR
			createCell(row, cont++, res[i].getCodigo()!=null?res[i].getCodigo():"", null); // REFERENCIA
			String activo = "";
			if(res[i].getActivo()!=null)
				activo = res[i].getActivo().equals((Integer)1)?"Si":"No";
			createCell(row, cont++, activo, null); // ACTIVO
			
			String gs128 = "";
			if(res[i].getCodigos()!=null){
				for(Codigosgs128 cod:res[i].getCodigos())
					gs128 += cod.getCodigo()+", ";
				if(!gs128.equals(""))
					gs128 = gs128.substring(0,gs128.length()-2);
			}
			createCell(row, cont++, gs128, null); // GS1-128
			fila++;
			cont = 0;
		}
	}
	private static void rellenaMatCat(Cateter[] res){
		try{
			ArrMaestrasDao mdao = new ArrMaestrasDaoImpl();
			Integer fila = 1, cont = 0;	
			for(int i= 0; i < res.length; i++){
				Row row = sheetMatCat.createRow(fila);
				createCell(row, cont++, res[i].getModelo(), null); // MODELO
				createCell(row, cont++, res[i].getFabricante()!=null?mdao.findByPrimaryKey(res[i].getFabricante()).getValor():"", null); // FABRICANTE
				createCell(row, cont++, res[i].getReferencia()!=null?res[i].getReferencia():"", null); // REFERENCIA
				String tipo = "";
				if(res[i].getTipo()!=null)
					tipo = (res[i].getTipo().equals((Integer)1))?"Diagnóstico":"Ablación";
				createCell(row, cont++, tipo, null); // TIPO
				createCell(row, cont++, res[i].getDistanciaelecs()!=null?res[i].getDistanciaelecs():"", null); // DISTANCIA ELECTRODOS
				createCell(row, cont++, res[i].getNumelecs()!=null?String.valueOf(res[i].getNumelecs()):"", null); // NÚMERO DE ELECTRODOS
				String tipo_abl = "";
				if(res[i].getTipoablacion()!= null){
					switch (res[i].getTipoablacion()){
					case 0:
						tipo_abl = "NO ESPECIFICADO";
						break;
					case 1:
						tipo_abl = "4 mm";
						break;
					case 2:
						tipo_abl = "8 mm";
						break;
					case 3:
						tipo_abl = "Punta irrigada";
						break;
					case 4:
						tipo_abl = "Crioablación";
						break;
					case 5:
						tipo_abl = "Criobalón";
						break;
					case 6:
						tipo_abl = "Laser";
						break;
					case 7:
						tipo_abl = "10 mm";
						break;
					case 8:
						tipo_abl = "Otro";
						break;
					case 9:
						tipo_abl = "Irrigado de contacto";
						break;
					default:
						tipo_abl = "";
						break;
					}
				}
				createCell(row, cont++, tipo_abl, null);
				
				String tipo_diag = "";
				if(res[i].getTipodiagnostico()!= null){
					switch (res[i].getTipodiagnostico()){
					case 0:
						tipo_diag = "NO ESPECIFICADO";
						break;
					case 1:
						tipo_diag = "Curva fija";
						break;
					case 2:
						tipo_diag = "Curva deflectable";
						break;
					case 3:
						tipo_diag = "Circular";
						break;
					case 4:
						tipo_diag = "Mapeo";
						break;
					default:
						tipo_diag = "";
						break;
					}
				}
				createCell(row, cont++, tipo_diag, null);
				
				String curva = "";
				if(res[i].getTipocurva()!= null){
					if(res[i].getTipo()!=null && res[i].getTipo().equals((Integer) 2)){// Ablacion - tipo = 2
						switch (res[i].getTipocurva()){
						case 0:
							curva = "NO ESPECIFICADO";
							break;
						case 1:
							curva = "Unidireccional";
							break;
						case 2:
							curva = "Bidireccional";
							break;
						default:
							curva = "";
							break;
						}
					}else if(res[i].getTipo()!=null && res[i].getTipo().equals((Integer) 1)
							&& res[i].getTipodiagnostico()!=null && res[i].getTipodiagnostico().equals((Integer)2)){
						switch (res[i].getTipocurva()){ // Diagnostico - tipo = 1 + TipoDiagnostico = 2
						case 0:
							curva = "NO ESPECIFICADO";
							break;
						case 1:
							curva = "Josephson";
							break;
						case 2:
							curva = "Cournard";
							break;
						case 3:
							curva = "Preformada";
							break;
						case 4:
							curva = "Damato";
							break;
						default:
							curva = "";
							break;
						}
					}
				}
				createCell(row, cont++, curva, null);
				createCell(row, cont++, res[i].getTamano()!=null?String.valueOf(res[i].getTamano()):"", null); // TAMAÑO
				createCell(row, cont++, res[i].getLongitud()!=null?res[i].getLongitud():"", null); // LONGITUD
				String energia = "";
				if(res[i].getEnergia()!= null){
					switch (res[i].getEnergia()){
					case 0:
						energia = "NO ESPECIFICADO";
						break;
					case 1:
						energia = "RF";
						break;
					case 2:
						energia = "Crioablación";
						break;
					case 3:
						energia = "Laser";
						break;
					case 4:
						energia = "Ultrasonidos";
						break;
					default:
						energia = "";
						break;
					}
				}
				createCell(row, cont++, energia, null);
					
				String activo = "";
				if(res[i].getActivo()!=null)
					activo = res[i].getActivo().equals((Integer)1)?"Si":"No";
				createCell(row, cont++, activo, null); // ACTIVO
				
				String gs128 = "";
				if(res[i].getCodigos()!=null){
					for(Codigosgs128 cod:res[i].getCodigos())
						gs128 += cod.getCodigo()+", ";
					if(!gs128.equals(""))
						gs128 = gs128.substring(0,gs128.length()-2);
				}
				createCell(row, cont++, gs128, null); // GS1-128
				fila++;
				cont = 0;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private static void rellenaMatRegEv(Registradoreventos[] res){
		Integer fila = 1, cont = 0;		
		for(int i= 0; i < res.length; i++){
			Row row = sheetMatReg.createRow(fila);
			createCell(row, cont++, res[i].getModelo(), null); // MODELO
			createCell(row, cont++, res[i].getFabricante()!=null?res[i].getFabricante():"", null); // FABRICANTE
			createCell(row, cont++, res[i].getReferencia()!=null?res[i].getReferencia():"", null); // REFERENCIA
			String rf = "";
			if(res[i].getRf()!=null)
				rf = res[i].getRf().equals((Integer)1)?"Si":"No";
			createCell(row, cont++, rf, null); // RF
			String mri = "";
			if(res[i].getMri()!=null)
				mri = res[i].getMri().equals((Integer)1)?"Si":"No";
			createCell(row, cont++, mri, null); // MRI
			
			String activo = "";
			if(res[i].getActivo()!=null)
				activo = res[i].getActivo().equals((Integer)1)?"Si":"No";
			createCell(row, cont++, activo, null); // ACTIVO
			
			String gs128 = "";
			if(res[i].getCodigos()!=null){
				for(Codigosgs128 cod:res[i].getCodigos())
					gs128 += cod.getCodigo()+", ";
				if(!gs128.equals(""))
					gs128 = gs128.substring(0,gs128.length()-2);
			}
			createCell(row, cont++, gs128, null); // GS1-128
			fila++;
			cont = 0;
		}
	}
	private static void rellenaRecalls(ArrayList<RecallDto> res){
		Integer fila = 1, cont = 0;		
		for(int i= 0; i < res.size(); i++){
			Row row = sheetRecalls.createRow(fila);
			createCell(row, cont++, res.get(i).getModelo(), null); // MODELO
			createCell(row, cont++, res.get(i).getNumserie(), null); // NUMERO DE SERIE
			createCell(row, cont++, res.get(i).getFabricante()!=null?res.get(i).getFabricante():"", null); // FABRICANTE
			createCell(row, cont++, res.get(i).getFechaimp()!=null?UtilFechas.getFechaStringFormato(res.get(i).getFechaimp(), "dd-MM-yyyy"):"", null); // FECHA PROCEDIMIENTO
			createCell(row, cont++, res.get(i).getNhc(), null); // NHC
			
			fila++;
			cont = 0;
		}
	}
}
// end of class GenerarExcel.java
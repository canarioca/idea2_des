package com.sorin.idea.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * Clase auxiliar para manejo de Excel
 * @author Francisco.Romera
 *
 */
public class ExcelUtils {

	public static void escribeValorCelda(XSSFSheet hoja, String valor, int fila, int celda){
		Cell cell = null;
		// Acceso a la celda para actualizar el valor
		if(hoja.getRow(fila)!=null)
			cell = hoja.getRow(fila).getCell(celda);
		else{
			// Crear nueva fila
			hoja.createRow(fila);
			cell = hoja.getRow(fila).createCell(celda);
		}
			
        cell.setCellValue(valor);
	}
	
}

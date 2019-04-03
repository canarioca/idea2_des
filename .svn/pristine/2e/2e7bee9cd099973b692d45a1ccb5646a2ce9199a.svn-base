package com.sorin.idea.util;


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFFooter;
import org.apache.poi.hssf.usermodel.HSSFHeader;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.util.ParserUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.sorin.idea.dto.ArrCardioversion;
import com.sorin.idea.dto.ArrDesfibrilador;
import com.sorin.idea.dto.ArrEstudioIntento;
import com.sorin.idea.dto.ArrMesas;
import com.sorin.idea.dto.ArrPacientes;
import com.sorin.idea.dto.ArrRegistrador;
import com.sorin.idea.dto.ArrTestAtp;
import com.sorin.idea.dto.ArrTestEpi;
import com.sorin.idea.dto.ArrTestFle;
import com.sorin.idea.dto.Cateter;
import com.sorin.idea.dto.DatoEstAnual;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.ImpEvolucion;
import com.sorin.idea.dto.ImpGenerador;
import com.sorin.idea.dto.ImpHojaImplante;
import com.sorin.idea.dto.PacienteAplDto;
import com.sorin.idea.dto.Procedimiento;
import com.sorin.idea.dto.RecallDto;
import com.sorin.idea.dto.Registradoreventos;
import com.sorin.idea.dto.SituacionClinicaProc;
import com.sorin.idea.iu.GenerarExcel;

public class ExportExcel {
    private String htmlBuffer;
    
    public ExportExcel() {
        
    }
    
    public void exportHtmlTableToExcel() throws IOException{        
        
        //Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "datosExportados"+dt.toString(fmt) + ".xls";
       // String filename ="datosMovilidad" + ".xls";
        
        
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
       // filename = fc.getExternalContext().getUserPrincipal().toString() + "-"+ filename;
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        //Write the table back out
        PrintWriter out = response.getWriter();
        out.print(htmlBuffer);
        out.close();
        fc.responseComplete();
    }    
    
    public void exportToExcel(List<Map> pacienteAtp,
			ArrayList<ArrayList<Object>> resatp, List<Map> pacienteEpi,
			ArrayList<ArrayList<Object>> resepi, List<Map> pacienteFle,
			ArrayList<ArrayList<Object>> resfle) throws IOException {
		//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultasTest"+dt.toString(fmt) + ".xls";
        
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel(pacienteAtp, resatp, pacienteEpi, resepi, pacienteFle, resfle, filename, out);
        out.close();
        fc.responseComplete();
	}
    
    public void exportToExcel(List<Map> paciente, ArrCardioversion[] rescv) throws IOException {
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultasCv"+dt.toString(fmt) + ".xls";
        
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel(paciente, rescv, filename, out);
        out.close();
        fc.responseComplete();
	}
    
    public void exportToExcel(List<Map> paciente, ArrDesfibrilador[] resdai) throws IOException {
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultasDai"+dt.toString(fmt) + ".xls";
        
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel(paciente, resdai, filename, out);
        out.close();
        fc.responseComplete();
	}
    
    public void exportToExcel(List<Map> paciente, ArrayList<ArrayList<Object>> reseef, 
    		Integer tipo_ablacion, ArrayList<ArrayList<Object>> resvias, 
    		ArrayList<ArrayList<Object>> restaq, List<Map> pacienteVias, List<Map> pacienteTaq, ArrayList<ArrayList<Object>> reseefcompabl) throws IOException {
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultasEEF"+dt.toString(fmt) + ".xls";
        
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel(paciente, reseef, tipo_ablacion, resvias, restaq, pacienteVias, pacienteTaq, reseefcompabl, filename, out);
        out.close();
        fc.responseComplete();
		
	}
    
    
    //mmb
    public void exportToExcel(ArrayList<DatoEstAnual> registros) throws IOException {
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultaEstAnual"+dt.toString(fmt) + ".xls";
        
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel(registros, filename, out);
        out.close();
        fc.responseComplete();
	}
    /*************************/
    public void exportToExcel(ArrayList<ArrayList<Object>> res,
    		int tipo)throws IOException{
    	// Tipo =1 -> MP | CRT-P. Tipo = 2, DAI |CRT-D. Tipo = 3. TODOS
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "";
        if(tipo==1)
        	filename = "consultaImplanteBRADI"+dt.toString(fmt) + ".xls";
        else if(tipo == 2)
        	filename = "consultaImplanteTAQUI"+dt.toString(fmt) + ".xls";
        else if(tipo == 3)
        	filename = "consultaImplanteTODOS"+dt.toString(fmt) + ".xls";
        
      //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        if(tipo ==1)
        	GenerarExcel.crearExcel_BRADI(res, filename, out);
        else if(tipo==2)
        	GenerarExcel.crearExcel_TAQUI(res, filename, out);
        else if(tipo==3)
        	GenerarExcel.crearExcel_TAQUI(res, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel(ArrayList<ArrPacientes> pacientes, ArrayList<SituacionClinicaProc> sitclin,
    		ArrayList<ImpHojaImplante> himp, ArrayList<ImpEvolucion> ev,
    		ArrayList<ImpGenerador> impgenlist, ArrayList<Generador> gens, 
    		ArrayList<Procedimiento> prs, ArrayList<EstadisticasImplanteBean> auxest,
    		int tipo)throws IOException{
    	// Tipo =1 -> MP | CRT-P. Tipo = 2, DAI |CRT-D
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "";
        if(tipo==1)
        	filename = "consultaImplanteMP"+dt.toString(fmt) + ".xls";
        else if(tipo == 2)
        	filename = "consultaImplanteDAI"+dt.toString(fmt) + ".xls";
        
      //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        if(tipo ==1)
        	GenerarExcel.crearExcel_MP(pacientes,sitclin,himp,ev,impgenlist,gens,prs,auxest, filename, out);
        else if(tipo==2)
        	GenerarExcel.crearExcel_DAI(pacientes,sitclin,himp,ev,impgenlist,gens,prs,auxest, filename, out);
        out.close();
        fc.responseComplete();
    }
    
    
    public void exportToExcel_Reg(ArrayList<ArrayList<Object>> res)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultaRegistradorEventos"+dt.toString(fmt) + ".xls";;
        
      //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_Reg(res, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_Mesa(ArrayList<ArrayList<Object>> res)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultaMesaBasculante"+dt.toString(fmt) + ".xls";;
        
      //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_Mesa(res, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_Hol(ArrayList<ArrayList<Object>> hol)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultaHolter24h"+dt.toString(fmt) + ".xls";;
        
      //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_Hol(hol, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_RegEvExt(ArrayList<ArrayList<Object>> regevext)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultaRegistrador_Eventos_Externos"+dt.toString(fmt) + ".xls";;
        
      //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_RegEvExt(regevext, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_Pacientes(ArrayList<PacienteAplDto> lista)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "Exportacion_Consulta_Pacientes-Procedimientos_"+dt.toString(fmt) + ".xls";;
        
      //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_Pacientes(lista, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_RegNalDAI(ArrayList<RegistroDaiDto> regdai, int anio)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "RegistroNacionalDAI_"+String.valueOf(anio)+"_"+dt.toString(fmt) + ".xls";;
        
      //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_RegNalDAI(regdai, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_Mat_Gen(Generador[] gens)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultaMaterial_Generador_"+dt.toString(fmt) + ".xls"; 
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_MatGen(gens, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_Mat_Ele(Electrodos[] els)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultaMaterial_Electrodo_"+dt.toString(fmt) + ".xls"; 
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_MatEle(els, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_Mat_Cat(Cateter[] cats)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultaMaterial_Cateter_"+dt.toString(fmt) + ".xls"; 
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_MatCat(cats, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_Mat_RegEv(Registradoreventos[] regs)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "consultaMaterial_RegistradorEventos_"+dt.toString(fmt) + ".xls"; 
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_MatRegEv(regs, filename, out);
        out.close();
        fc.responseComplete();
    }
    public void exportToExcel_Recalls(ArrayList<RecallDto> lista)throws IOException{
    	//Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = "Exportacion_Consulta_Alertas_Seguridad_"+dt.toString(fmt) + ".xls";;
        
      //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        
        OutputStream out = response.getOutputStream();
        //Write the table back out
        GenerarExcel.crearExcel_Recalls(lista, filename, out);
        out.close();
        fc.responseComplete();
    }
    /**************************/
    public void exportHtmlTableAsExcel() throws IOException{
        int rowCount = 0;
        int colCount = 0;
        
        //Set the filename
        DateTime dt = new DateTime();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd_HHmmss");
        String filename = dt.toString(fmt);
        
        
        // Create Excel Workbook and Sheet
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet(filename);
        HSSFHeader header = sheet.getHeader();
        header.setCenter(filename);
        
        
        //Setup the output
        String contentType = "application/vnd.ms-excel";
        FacesContext fc = FacesContext.getCurrentInstance();
        filename = fc.getExternalContext().getUserPrincipal().toString() + "-"+ filename;
        HttpServletResponse response = (HttpServletResponse)fc.getExternalContext().getResponse();
        filename = filename + ".xls";
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        response.setContentType(contentType);
        ServletOutputStream out = response.getOutputStream();
        
        
        
        try{

            htmlBuffer = "<html>" + htmlBuffer + "</html>";
            Parser parser = new Parser();
            parser.setInputHTML(htmlBuffer);
            NodeList nodelist = parser.parse(null);
            Node node = nodelist.elementAt(0);
            
            //nodelist.visitAllNodesWith(new TableVisitor());
            NodeList tableList = nodelist.extractAllNodesThatMatch(new TagNameFilter("TABLE"), true);
            NodeList  headList = tableList.extractAllNodesThatMatch(new TagNameFilter("THEAD"), true);
            NodeList  bodyList = tableList.extractAllNodesThatMatch(new TagNameFilter("TBODY"), true);
            NodeList  footList = tableList.extractAllNodesThatMatch(new TagNameFilter("TFOOT"), true);
            NodeList  rowList = tableList.extractAllNodesThatMatch(new TagNameFilter("TR"), true);
            
            //Create a ParserUtils var
            ParserUtils pu = new ParserUtils();
            //Set rowCount to size of rowList
            rowCount = rowList.size();
            
            
            HSSFFont boldFont = wb.createFont();
            boldFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            HSSFCellStyle boldStyle = wb.createCellStyle();
            boldStyle.setFont(boldFont);
            boldStyle.setWrapText(true);
            
            //Loop through excel 'Rows'
            for ( int i = 0; i < rowList.size(); i++ ) {
                HSSFRow row;
                String htmlRow = rowList.elementAt(i).toHtml().trim();
                String[] splitHtmlRow;
                
                if(i == 0 && headList.size() == 1){
                    row = sheet.createRow((short) i);
                    htmlRow = htmlRow.replace("<th></th>","<th> </th>");
                    htmlRow = htmlRow.replace("<TH></TH>","<th> </th>");
                    splitHtmlRow = pu.splitTags(htmlRow, new String[] {"tr", "th", "a"}, true, false);
                    /*if your column headers don't links use 
                     splitHtmlRow = pu.splitTags(htmlRow, new String[] {"tr", "th"}, true, false); */
                    colCount = splitHtmlRow.length;
                } else if(i == 1 && footList.size() == 1){
                    row = sheet.createRow((short) rowList.size() - 1);
                    htmlRow = pu.trimTags(htmlRow, new String[]{"span"},false,false);
                    htmlRow = htmlRow.replace("<td></td>","<td> </td>");
                    htmlRow = htmlRow.replace("<TD></TD>","<td> </td>");
                    splitHtmlRow = pu.splitTags(htmlRow, new String[] {"tr", "td"}, true, false);
                    colCount = splitHtmlRow.length;
                    
                } else {
                    
                    if (footList.size() == 1){
                        row = sheet.createRow((short) i - 1);
                    } else {
                        row = sheet.createRow((short) i);
                    }
                    
                    htmlRow = htmlRow.replace("<td></td>","<td> </td>");
                    htmlRow = htmlRow.replace("<TD></TD>","<td> </td>");
                    //if your h:dataTable has columnclass attribute uncomment 2 lines below
                    //htmlRow = htmlRow.replace("</span>", " </span>");
                    //splitHtmlRow = ParserUtils.splitTags(htmlRow, new String[]{"tr", "td", "span"}, true, false);
                    splitHtmlRow = pu.splitTags(htmlRow, new String[] {"tr", "td"}, true, false);
                    colCount = splitHtmlRow.length;
                }
                
                //Loop through excel 'Columns'
                for (int j = 0; j < splitHtmlRow.length; j++){
                    HSSFCell cell = row.createCell((short) j);
                    
                    
                    // Calculate what the column width should be.
                    // Increase if the current width is samller than
                    // the calculated width.
                    int width = splitHtmlRow[j].length() * 325;
                    if(width > sheet.getColumnWidth((short)j)){
                        sheet.setColumnWidth((short)j, (short)width);
                    }
                    
                    
                    
                    //Wrap Text in the Cell for the Header Row
                    if(i == 0 && headList.size() == 1){
                        
                        // Determine the width of the column head
                        Pattern p = Pattern.compile(" ");
                        String[] splitHead = p.split(splitHtmlRow[j]);
                        int wordCnt = splitHead.length;
                        for (int q = 0; q < splitHead.length; q++){
                            if(splitHead[q].length() * 325 > width)
                                width = splitHead[q].length() * 325;
                            sheet.setColumnWidth((short)j, (short)width);
                        }
                        
                        // Dertermin the height of the column head
                        int height = wordCnt * 275;
                        if(row.getHeight() < height){
                            row.setHeight((short)height);
                        }
                        
                        
                        // Add new line to cell content and make the cell
                        // word wrap
                        splitHtmlRow[j] = splitHtmlRow[j].replaceAll(" ", " \n");
                        
                        //Set Cell to boldStyle
                        cell.setCellStyle(boldStyle);
                        
                    }
                    
                    //Populate Cell
                    if(splitHtmlRow[j] == null){
                        cell.setCellValue("");
                    }else{
                        cell.setCellValue(splitHtmlRow[j]);
                    }
                    
                }
            }
            
            
            
        }catch(ParserException p){ p.printStackTrace(); }
        
        
        // Do stuff the Excel SpreaSheet
        // Freeze Panes on First Row
        sheet.createFreezePane(0,1);
        // Row 1 Repeats on each page
        wb.setRepeatingRowsAndColumns(0,0,0,0,1);
        
        // Set Print Area, Footer
        wb.setPrintArea(0, 0, colCount, 0, rowCount);
        HSSFFooter footer = sheet.getFooter();
        footer.setCenter("Page " + HSSFFooter.page() + " of " + HSSFFooter.numPages());
        // Fit Sheet to 1 page wide but very long
        sheet.setAutobreaks(true);
        HSSFPrintSetup ps = sheet.getPrintSetup();
        ps.setFitWidth((short)1);
        ps.setFitHeight((short)9999);
        sheet.setGridsPrinted(true);
        sheet.setHorizontallyCenter(true);
        ps.setPaperSize(HSSFPrintSetup.LETTER_PAPERSIZE);
        if(colCount > 5){ps.setLandscape(true);}
        if(colCount > 10){ps.setPaperSize(HSSFPrintSetup.LEGAL_PAPERSIZE);}
        if(colCount > 14){ps.setPaperSize(HSSFPrintSetup.EXECUTIVE_PAPERSIZE);}
        // Set Margins
        ps.setHeaderMargin((double) .35);
        ps.setFooterMargin((double) .35);
        sheet.setMargin(HSSFSheet.TopMargin, (double) .50);
        sheet.setMargin(HSSFSheet.BottomMargin, (double) .50);
        sheet.setMargin(HSSFSheet.LeftMargin, (double) .50);
        sheet.setMargin(HSSFSheet.RightMargin, (double) .50);
        
        //Write out the spreadsheet
        wb.write(out);
        out.close();
        
        fc.responseComplete();
    }
    
    public String getHtmlBuffer() {
        return htmlBuffer;
    }
    
    public void setHtmlBuffer(String htmlBuffer) {
        this.htmlBuffer = htmlBuffer;
    }
}
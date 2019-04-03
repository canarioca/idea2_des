package com.sorin.idea.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;

import hvn.cm.modelo.ServicioException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRRuntimeException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sorin.idea.dto.ArrAnual;
import com.sorin.idea.iu.ControlCitas;

public class ConstructorExcel {

	static final public long serialVersionUID = 1;
	
	public void generarArchivoExcel(FacesContext contexto,ArrAnual anual)throws ServicioException {	
		
		ExternalContext externalContext = contexto.getExternalContext();
		HttpServletRequest req = (HttpServletRequest) contexto.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) contexto.getExternalContext().getResponse();
		String sesionID = req.getRequestedSessionId();
		
		String reportNameFile = null;
		
		try{
			ServletOutputStream servletOutputStream = response.getOutputStream();
			
			reportNameFile = req.getRealPath("/reportes/" + "Formulario_Ablacion_Anual_"+UtilFechas.dateToString(new Date())+".xlsx");
			// creo el report
			File reportFile = new File(reportNameFile);
			// creo el excel
			byte[] xlsxBytes = contruyeFormularioAblacion(anual);
					
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setContentLength(xlsxBytes.length);
			//response.setHeader("Content-Transfer-Enconding", "binary");
			response.setHeader("Content-disposition", "inline; filename=\""
					+ reportNameFile + "\"");

			servletOutputStream.write(xlsxBytes);

			// esta sentencia es extremadamente importante de cara a conseguir
			// que se pueda abrir el
			// archivo
			contexto.responseComplete();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new ServicioException("Error al crear el fichero excel "+e.getMessage());		
		}
	}
	
	/**
	 * Crea el fichero Excel a partir del objeto ArrAnual
	 * @param anual
	 */
	public byte[] contruyeFormularioAblacion(ArrAnual anual){
		try{
			// 1. Recupera plantilla vacia
			InputStream is = ConstructorExcel.class.getResourceAsStream("plantilla.xlsx");
			//Read Excel document first
	        //FileInputStream input = new FileInputStream(new File(path));
	        // Conversion a objeto POI
	        XSSFWorkbook xlsx_workbook = new XSSFWorkbook(is); 
	        // Obtener hojas de la plantilla
	        XSSFSheet info_conf = xlsx_workbook.getSheetAt(0); // Info. Confidencial
	        XSSFSheet centro = xlsx_workbook.getSheetAt(1); // Centro
	        XSSFSheet tin = xlsx_workbook.getSheetAt(2); // TIN
	        XSSFSheet vias = xlsx_workbook.getSheetAt(3); // VIAS
	        XSSFSheet nodo_av = xlsx_workbook.getSheetAt(4); // NODO AV
	        XSSFSheet ta_focal = xlsx_workbook.getSheetAt(5); // TA FOCAL
	        XSSFSheet ict = xlsx_workbook.getSheetAt(6); // ICT
	        XSSFSheet flutter = xlsx_workbook.getSheetAt(7); // FLUTTER
	        XSSFSheet fa = xlsx_workbook.getSheetAt(8); // FA
	        XSSFSheet tv_idio = xlsx_workbook.getSheetAt(9); // TV IDIOPATICA
	        XSSFSheet tv_iam = xlsx_workbook.getSheetAt(10); // TV IAM
	        XSSFSheet tv_otras = xlsx_workbook.getSheetAt(11); // TV OTRAS
	             
	        // Rellenado de datos de las hojas
	        rellenaInfoConfidencial(anual, info_conf);
	        rellenaCentro(anual,centro);
	        rellenaTIN(anual,tin);
	        rellenaVias(anual,vias);
	        rellenaNodoAV(anual,nodo_av);
	        rellenaTAFocal(anual,ta_focal);
	        rellenaICT(anual,ict);
	        rellenaFLUTTER(anual,flutter);
	        rellenaFA(anual,fa);
	        rellenaTVIDIO(anual,tv_idio);
	        rellenaTVIAM(anual,tv_iam);
	        rellenaTVOTRAS(anual,tv_otras);
	        
	        //Cierre de InputStream
	        is.close();
	        /*//Open FileOutputStream to write updates
	        FileOutputStream output_file =new FileOutputStream(new File(path));
	        //write changes
	        xlsx_workbook.write(output_file);
	        //close the stream
	        output_file.close(); */
	        	        
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();
	        try {
	        	xlsx_workbook.write(bos);
	        } finally {
	            bos.close();
	        }
	        
	        return bos.toByteArray();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	public void rellenaInfoConfidencial(ArrAnual anual, XSSFSheet hoja){
		ExcelUtils.escribeValorCelda(hoja, "AÑO: "+anual.getAnio(), 3, 5); // ANIO (F4)
		ExcelUtils.escribeValorCelda(hoja, anual.getCentro().getCodcentro(), 3, 5); // CODIGO CENTRO (K4)
		ExcelUtils.escribeValorCelda(hoja, anual.getCentro().getHospital(), 6, 1); // HOSPITAL (B7)
		ExcelUtils.escribeValorCelda(hoja, anual.getCentro().getDireccion(), 7, 1); // DIRECCION (B8)
		ExcelUtils.escribeValorCelda(hoja, anual.getCentro().getCp(), 8, 1); // CODIGO POSTAL (B9)
		ExcelUtils.escribeValorCelda(hoja, anual.getCentro().getPoblacion(),9, 1); // CIUDAD (B10)
		ExcelUtils.escribeValorCelda(hoja, anual.getCentro().getComunidad(),10, 1); // COMUNIDAD AUTONOMA (B11)
		ExcelUtils.escribeValorCelda(hoja, anual.getCentro().getResponsable(),11, 1); // MEDICO RESPONSABLE (B12)
		ExcelUtils.escribeValorCelda(hoja, anual.getCentro().getTelcontacto(),12, 1); // TELEFONO CONTACTO (B13)
		ExcelUtils.escribeValorCelda(hoja, anual.getCentro().getEmailcontacto(),13, 1); // EMAIL CONTACTO (B14)
	}
	
	public void rellenaCentro(ArrAnual anual, XSSFSheet hoja){
		// NIVEL HOSPITAL (D3) + UNIVERSITARIO (D4)
		String tipo_hosp = "";
		String universitario = "";
		if(anual.getCentro().getIdtipohospi1()!=null){
			if(anual.getCentro().getIdtipohospi1().equals(1)){
				universitario = "SI";
				tipo_hosp="";
			}else if(anual.getCentro().getIdtipohospi1().equals(2)){
				universitario = "SI";
				tipo_hosp="Secundario/Comarcal";
			}else if(anual.getCentro().getIdtipohospi1().equals(3)){
				universitario = "SI";
				tipo_hosp="Terciario";
			}else if(anual.getCentro().getIdtipohospi1().equals(4)){
				universitario = "NO";
				tipo_hosp="Secundario/Comarcal";
			}else if(anual.getCentro().getIdtipohospi1().equals(5)){
				universitario = "NO";
				tipo_hosp="Terciario";
			}
			ExcelUtils.escribeValorCelda(hoja, tipo_hosp, 2, 3); // NIVEL HOSPITAL (D3)
			ExcelUtils.escribeValorCelda(hoja, universitario, 3, 3); // UNIVERSITARIO (D4)
		}
		if(anual.getCentro().getIdtipohospi2()!=null)
			ExcelUtils.escribeValorCelda(hoja, (anual.getCentro().getIdtipohospi2().equals(1)?"Publica":"Privada"), 4, 3); // FINANCIACION (D5)
		if(anual.getCentro().getIdcirugia()!=null)
			ExcelUtils.escribeValorCelda(hoja, (anual.getCentro().getIdtipohospi2().equals(1)?"SI":"NO"), 5, 3); // CIRUGIA CARDIACA DISP (D6)
		String servicio = "";
		if(anual.getCentro().getIdservicio()!=null){
			if(anual.getCentro().getIdservicio().equals(1))
				servicio = "Cardiología";
			else if(anual.getCentro().getIdservicio().equals(2))
				servicio = "Intensivos";
			else
				servicio = "Otro";
			ExcelUtils.escribeValorCelda(hoja, servicio, 6, 3); // SERVICIO (D7)
		}
		if(anual.getLab().getPlantilla()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getPlantilla(), 7, 3); // N. MEDICO PLANTILLA (D8)
		if(anual.getLab().getPlantillatc()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getPlantillatc(), 8, 3); // N. MEDICO PLANTILLA TIEMPO COMPLETO (D9)
		if(anual.getLab().getBecarios()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getBecarios(), 9, 3); // N. BECARIOS (D10)
		if(anual.getLab().getMir()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getMir(), 10, 3); // MIR (D11)
		if(anual.getLab().getAts()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getAts(), 11, 3); // ATS (D12)
		if(anual.getLab().getAtr()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getAtr(), 12, 3); // ATR (D13)
		if(anual.getLab().getAne()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getAne().equals("1")?"SI":"NO", 13, 3); // ANESTESISTAS (D14)
		// N. SALAS (D15)
		Integer sala_c =0, sala_d=0;
		if(anual.getLab().getSalac()!=null && UtilDatos.esNumero(anual.getLab().getSalac()))
			sala_c = Integer.parseInt(anual.getLab().getSalac());
		if(anual.getLab().getSalad()!=null && UtilDatos.esNumero(anual.getLab().getSalad()))
			sala_d = Integer.parseInt(anual.getLab().getSalad());
		ExcelUtils.escribeValorCelda(hoja, String.valueOf(sala_c+sala_d), 14, 3); // N. SALAS (D15)	
		if(anual.getLab().getExclusivas()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getExclusivas(), 15, 3); // N. SALAS DED. EXCL (D16)
		if(anual.getLab().getNrxfijo()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getNrxfijo(), 16, 3); // N. RX ARCO FIJO (D17)
		if(anual.getLab().getNrxportatil()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getNrxportatil(), 17, 3); // N. RX ARCO PORTATIL (D18)
		if(anual.getLab().getDias()!=null)
			ExcelUtils.escribeValorCelda(hoja, anual.getLab().getDias(), 18, 3); // DIAS SEM. ABALCIONES (D19)
		if(anual.getTec().getNavx()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getNavx().equals(1)?"SI":"NO"), 19, 3); // ENSITE/NAVX/VELOCITY (D20)
		if(anual.getTec().getCarto()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getCarto().equals(1)?"SI":"NO"), 20, 3); // CARTO (D21)
		if(anual.getTec().getRythmia()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getRythmia().equals(1)?"SI":"NO"), 21, 3); // RYTHMIA (D22)
		if(anual.getTec().getMediguide()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getMediguide().equals(1)?"SI":"NO"), 22, 3); // MEDIGUIDE (D23)
		if(anual.getTec().getAngrot()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getAngrot().equals(1)?"SI":"NO"), 23, 3); // ANGIOGRAFIA ROTACIONAL (D24)
		if(anual.getTec().getNiobe()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getNiobe().equals(1)?"SI":"NO"), 24, 3); // NIOBE (D25)
		if(anual.getTec().getHansen()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getHansen().equals(1)?"SI":"NO"), 25, 3); // HANSEN (D26)
		if(anual.getTec().getAmigo()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getAmigo().equals(1)?"SI":"NO"), 26, 3); // AMIGO (D27)
		if(anual.getTec().getArotro()!=null && !anual.getTec().getArotro().equals("")){
			ExcelUtils.escribeValorCelda(hoja,"SI", 27, 3); // OTRO  - DESCRIPCION (E28)
			ExcelUtils.escribeValorCelda(hoja,anual.getTec().getArotro(), 27, 4); // OTRO  - DESCRIPCION (E28)
		}
		if(anual.getTec().getIdeco()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getIdeco().equals(1)?"SI":"NO"), 28, 3); // ECOGRAFICA INTRACARDIACA (D29)
		if(anual.getTec().getIdcrio()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getIdcrio().equals(1)?"SI":"NO"), 29, 3); // CRIOABLACION (D30)
		if(anual.getTec().getIdus()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getIdus().equals(1)?"SI":"NO"), 30, 3); // ABLACION US (D31)
		if(anual.getTec().getIdlaser()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getTec().getIdlaser().equals(1)?"SI":"NO"), 31, 3); // ABLACION LASER (D32)
		if(anual.getTec().getTecnicas()!=null && !anual.getTec().getTecnicas().equals("")){
			ExcelUtils.escribeValorCelda(hoja,"SI", 32, 3); // TECNICAS - SI/NO (D33)
			ExcelUtils.escribeValorCelda(hoja,anual.getTec().getTecnicas(), 32, 4); // TECNICAS - DESCRICPION (E33)
		}	
		if(anual.getLab().getIdmp()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getLab().getIdmp().equals(1)?"SI":"NO"), 33, 3); // IMPLANTE MPS (D34)
		if(anual.getLab().getIddai()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getLab().getIddai().equals(1)?"SI":"NO"), 34, 3); // IMPLANTE DAI (D35)
		if(anual.getLab().getIdcrt()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getLab().getIdcrt().equals(1)?"SI":"NO"), 35, 3); // IMPLANTE CRT (D36)
		if(anual.getLab().getIdholter()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getLab().getIdholter().equals(1)?"SI":"NO"), 36, 3); // IMPLANTE HOLTER (D37)
		if(anual.getLab().getIdcvexterna()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getLab().getIdcvexterna().equals(1)?"SI":"NO"), 37, 3); // CVE EXTERNA (D38)
		if(anual.getLab().getIdcvinterna()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getLab().getIdcvinterna().equals(1)?"SI":"NO"), 38, 3); // CVE INTERNA (D39)
		if(anual.getLab().getIddenren()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getLab().getIddenren().equals(1)?"SI":"NO"), 39, 3); // DENERVACION RENAL (D40)
		if(anual.getLab().getIdcieore()!=null)
			ExcelUtils.escribeValorCelda(hoja,(anual.getLab().getIdcieore().equals(1)?"SI":"NO"), 40, 3); // CIERRE OREJUELA (D41)
		if(anual.getLab().getProcedimientos()!=null && !anual.getLab().getProcedimientos().equals("")){
			ExcelUtils.escribeValorCelda(hoja,"SI", 41, 3); // OTROS PROCEDIMIENTOS (D42)
			ExcelUtils.escribeValorCelda(hoja,anual.getLab().getProcedimientos(), 41, 4); // OTROS PROCEDIMIENTOS - DESCRIPCION (E42)
		}	
	}
	
	public void rellenaTIN(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo1()!=null?anual.getTin().getCampo1():""), 1, 2); // TOTAL PACIENTES (C2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo2()!=null?anual.getTin().getCampo2():""), 2, 2); // TOTAL PROCEDIMIENTOS (C3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo3()!=null?anual.getTin().getCampo3():""), 3, 2); // TOTAL PROCEDIMIENTOS EXITO (C4)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo35()!=null?anual.getTin().getCampo35():""), 4, 2); // 4 mm (C5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo4()!=null?anual.getTin().getCampo4():""), 5, 2); // 8 mm (C6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo5()!=null?anual.getTin().getCampo5():""), 6, 2); // IRRIGADO ESTANDAR (C7)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo6()!=null?anual.getTin().getCampo6():""), 7, 2); // CRIOABLACION (C8)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo36()!=null?anual.getTin().getCampo36():""), 8, 2); // IRRIGADO CONTACTO (C9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo7()!=null?anual.getTin().getCampo7():""), 9, 2); // OTRO (C10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo8()!=null?anual.getTin().getCampo8():""), 9, 3); // OTRO - DESCRICPCION (D10)
		// COMPLICACIONES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo9()!=null?anual.getTin().getCampo9():""), 10, 2); // BAV (C11)
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getTin().getCampo10()!=null && UtilDatos.esNumero(anual.getTin().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getTin().getCampo10());
		if(anual.getTin().getCampo11()!=null && UtilDatos.esNumero(anual.getTin().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getTin().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 11, 2); // COMPLICACION VASCULAR (C12)
		Integer derr = 0, tc = 0;
		if(anual.getTin().getCampo12()!=null && UtilDatos.esNumero(anual.getTin().getCampo12()))
			derr = Integer.parseInt(anual.getTin().getCampo12());
		if(anual.getTin().getCampo13()!=null && UtilDatos.esNumero(anual.getTin().getCampo13()))
			tc = Integer.parseInt(anual.getTin().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 12, 2); // DERRAME PERICARDICO (C13)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getTin().getCampo14()!=null && UtilDatos.esNumero(anual.getTin().getCampo14()))
			emb = Integer.parseInt(anual.getTin().getCampo14());
		if(anual.getTin().getCampo15()!=null && UtilDatos.esNumero(anual.getTin().getCampo15()))
			acv = Integer.parseInt(anual.getTin().getCampo15());
		if(anual.getTin().getCampo16()!=null && UtilDatos.esNumero(anual.getTin().getCampo16()))
			ait = Integer.parseInt(anual.getTin().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 13, 2); // EMBOLISMO, ACV o AIT (C14)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo17()!=null?anual.getTin().getCampo17():""), 14, 2); // IAM o ISQUEMIA (C15)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo18()!=null?anual.getTin().getCampo18():""), 15, 2); // ICC o SHOCK (C16)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo19()!=null?anual.getTin().getCampo19():""), 16, 2); // OTRA (C17)
		Integer m1 = 0, m2 = 0;
		if(anual.getTin().getCampo20()!=null && UtilDatos.esNumero(anual.getTin().getCampo20()))
			m1 = Integer.parseInt(anual.getTin().getCampo20());
		if(anual.getTin().getCampo21()!=null && UtilDatos.esNumero(anual.getTin().getCampo21()))
			m2 = Integer.parseInt(anual.getTin().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 17, 2); // MUERTES (C18)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo37()!=null?anual.getTin().getCampo37():""), 18, 2); // CASOS PEDIATRICOS (C19)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo38()!=null?anual.getTin().getCampo38():""), 19, 2); // CASOS CON NAVEGADOR (C20)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTin().getCampo39()!=null?anual.getTin().getCampo39():""), 20, 2); // CASOS SIN FLUOROSCOPIA (C21)
	}
	
	public void rellenaVias(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo1()!=null?anual.getVacc().getCampo1():""), 1, 2); // TOTAL PACIENTES (C2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo2()!=null?anual.getVacc().getCampo2():""), 2, 2); // TOTAL PROCEDIMIENTOS (C3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo3()!=null?anual.getVacc().getCampo3():""), 3, 2); // TOTAL PROCEDIMIENTOS EXITO (C4)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo35()!=null?anual.getVacc().getCampo35():""), 4, 2); // 4 mm (C5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo4()!=null?anual.getVacc().getCampo4():""), 5, 2); // 8 mm (C6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo5()!=null?anual.getVacc().getCampo5():""), 6, 2); // IRRIGADO ESTANDAR (C7)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo6()!=null?anual.getVacc().getCampo6():""), 7, 2); // CRIOABLACION (C8)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo36()!=null?anual.getVacc().getCampo36():""), 8, 2); // IRRIGADO CONTACTO (C9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo7()!=null?anual.getVacc().getCampo7():""), 9, 2); // OTRO (C10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo8()!=null?anual.getVacc().getCampo8():""), 9, 3); // OTRO - DESCRICPCION (D10)
		// SUSTRATO
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo30()!=null?anual.getVacc().getCampo30():""), 10, 2); // N. TOTAL VIAS (C11)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo31()!=null?anual.getVacc().getCampo31():""), 11, 2); // COND. ANTEROGRADA (C12)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo32()!=null?anual.getVacc().getCampo32():""), 12, 2); // COND. RETROGRADA (C13)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo33()!=null?anual.getVacc().getCampo33():""), 13, 2); // COND. BIDIRECCIONAL (C14)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo22()!=null?anual.getVacc().getCampo22():""), 14, 2); // PARED LIBRE DCHA (C15)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo23()!=null?anual.getVacc().getCampo23():""), 15, 2); // PARED LIBRE IZQDA (C16)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo24()!=null?anual.getVacc().getCampo24():""), 16, 2); // PARASEPT. INF (C17)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo25()!=null?anual.getVacc().getCampo25():""), 17, 2); // PERIHIS (C18)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo26()!=null?anual.getVacc().getCampo26():""), 18, 2); // PARED LIBRE DCHA - EXITO (C19)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo27()!=null?anual.getVacc().getCampo27():""), 19, 2); // PARED LIBRE IZQDA - EXITO (C20)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo28()!=null?anual.getVacc().getCampo28():""), 20, 2); // PARASEPT INF - EXITO (C21)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo29()!=null?anual.getVacc().getCampo29():""), 21, 2); // PERIHIS - EXITO (C22)
		// ACCESO VIAS IZQUIERDA
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo40()!=null?anual.getVacc().getCampo40():""), 22, 2); // ENDOCARDICO RETROAORTICO (C23)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo41()!=null?anual.getVacc().getCampo41():""), 23, 2); // ENDOCARDICO TRANSEPTAL (C24)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo42()!=null?anual.getVacc().getCampo42():""), 24, 2); // EPICARDICO/SC (C25)
		// COMPLICACIONES
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo9()!=null?anual.getVacc().getCampo9():""), 25, 2); // BAV (C26)
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getVacc().getCampo10()!=null && UtilDatos.esNumero(anual.getVacc().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getVacc().getCampo10());
		if(anual.getVacc().getCampo11()!=null && UtilDatos.esNumero(anual.getVacc().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getVacc().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 26, 2); // COMPLICACION VASCULAR (C27)
		Integer derr = 0, tc = 0;
		if(anual.getVacc().getCampo12()!=null && UtilDatos.esNumero(anual.getVacc().getCampo12()))
			derr = Integer.parseInt(anual.getVacc().getCampo12());
		if(anual.getVacc().getCampo13()!=null && UtilDatos.esNumero(anual.getVacc().getCampo13()))
			tc = Integer.parseInt(anual.getVacc().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 27, 2); // DERRAME PERICARDICO (C28)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getVacc().getCampo14()!=null && UtilDatos.esNumero(anual.getVacc().getCampo14()))
			emb = Integer.parseInt(anual.getVacc().getCampo14());
		if(anual.getVacc().getCampo15()!=null && UtilDatos.esNumero(anual.getVacc().getCampo15()))
			acv = Integer.parseInt(anual.getVacc().getCampo15());
		if(anual.getVacc().getCampo16()!=null && UtilDatos.esNumero(anual.getVacc().getCampo16()))
			ait = Integer.parseInt(anual.getVacc().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 28, 2); // EMBOLISMO, ACV o AIT (C29)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo17()!=null?anual.getVacc().getCampo17():""), 29, 2); // IAM o ISQUEMIA (C30)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo18()!=null?anual.getVacc().getCampo18():""), 30, 2); // ICC o SHOCK (C31)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo19()!=null?anual.getVacc().getCampo19():""), 31, 2); // OTRA (C32)
		Integer m1 = 0, m2 = 0;
		if(anual.getVacc().getCampo20()!=null && UtilDatos.esNumero(anual.getVacc().getCampo20()))
			m1 = Integer.parseInt(anual.getVacc().getCampo20());
		if(anual.getVacc().getCampo21()!=null && UtilDatos.esNumero(anual.getVacc().getCampo21()))
			m2 = Integer.parseInt(anual.getVacc().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 32, 2); // MUERTES (C33)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo37()!=null?anual.getVacc().getCampo37():""), 33, 2); // CASOS PEDIATRICOS (C34)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo38()!=null?anual.getVacc().getCampo38():""), 34, 2); // CASOS CON NAVEGADOR (C35)
		ExcelUtils.escribeValorCelda(hoja,(anual.getVacc().getCampo39()!=null?anual.getVacc().getCampo39():""), 35, 2); // CASOS SIN FLUOROSCOPIA (C36)
	}
	
	public void rellenaNodoAV(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo1()!=null?anual.getCav().getCampo1():""), 1, 2); // TOTAL PACIENTES (C2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo2()!=null?anual.getCav().getCampo2():""), 2, 2); // TOTAL PROCEDIMIENTOS (C3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo3()!=null?anual.getCav().getCampo3():""), 3, 2); // TOTAL PROCEDIMIENTOS EXITO (C4)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo35()!=null?anual.getCav().getCampo35():""), 4, 2); // 4 mm (C5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo4()!=null?anual.getCav().getCampo4():""), 5, 2); // 8 mm (C6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo5()!=null?anual.getCav().getCampo5():""), 6, 2); // IRRIGADO ESTANDAR (C7)
		//ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo6()!=null?anual.getCav().getCampo6():""), 7, 2); // CRIOABLACION (C8) - > no aparece
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo36()!=null?anual.getCav().getCampo36():""), 7, 2); // IRRIGADO CONTACTO (C9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo7()!=null?anual.getCav().getCampo7():""), 8, 2); // OTRO (C10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo8()!=null?anual.getCav().getCampo8():""), 8, 3); // OTRO - DESCRICPCION (D10)
		// COMPLICACIONES
		//ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo9()!=null?anual.getCav().getCampo9():""), 10, 2); // BAV (C11) - > NO APARECE EN LA HOJA
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getCav().getCampo10()!=null && UtilDatos.esNumero(anual.getCav().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getCav().getCampo10());
		if(anual.getCav().getCampo11()!=null && UtilDatos.esNumero(anual.getCav().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getCav().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 9, 2); // COMPLICACION VASCULAR (C12)
		Integer derr = 0, tc = 0;
		if(anual.getCav().getCampo12()!=null && UtilDatos.esNumero(anual.getCav().getCampo12()))
			derr = Integer.parseInt(anual.getCav().getCampo12());
		if(anual.getCav().getCampo13()!=null && UtilDatos.esNumero(anual.getCav().getCampo13()))
			tc = Integer.parseInt(anual.getCav().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 10, 2); // DERRAME PERICARDICO (C13)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getCav().getCampo14()!=null && UtilDatos.esNumero(anual.getCav().getCampo14()))
			emb = Integer.parseInt(anual.getCav().getCampo14());
		if(anual.getCav().getCampo15()!=null && UtilDatos.esNumero(anual.getCav().getCampo15()))
			acv = Integer.parseInt(anual.getCav().getCampo15());
		if(anual.getCav().getCampo16()!=null && UtilDatos.esNumero(anual.getCav().getCampo16()))
			ait = Integer.parseInt(anual.getCav().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 11, 2); // EMBOLISMO, ACV o AIT (C14)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo17()!=null?anual.getCav().getCampo17():""), 12, 2); // IAM o ISQUEMIA (C15)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo18()!=null?anual.getCav().getCampo18():""), 13, 2); // ICC o SHOCK (C16)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo19()!=null?anual.getCav().getCampo19():""), 14, 2); // OTRA (C17)
		Integer m1 = 0, m2 = 0;
		if(anual.getCav().getCampo20()!=null && UtilDatos.esNumero(anual.getCav().getCampo20()))
			m1 = Integer.parseInt(anual.getCav().getCampo20());
		if(anual.getCav().getCampo21()!=null && UtilDatos.esNumero(anual.getCav().getCampo21()))
			m2 = Integer.parseInt(anual.getCav().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 15, 2); // MUERTES (C18)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo37()!=null?anual.getCav().getCampo37():""), 16, 2); // CASOS PEDIATRICOS (C19)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo38()!=null?anual.getCav().getCampo38():""), 17, 2); // CASOS CON NAVEGADOR (C20)
		ExcelUtils.escribeValorCelda(hoja,(anual.getCav().getCampo39()!=null?anual.getCav().getCampo39():""), 18, 2); // CASOS SIN FLUOROSCOPIA (C21)
	}
	
	public void rellenaTAFocal(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo1()!=null?anual.getTaf().getCampo1():""), 1, 2); // TOTAL PACIENTES (C2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo2()!=null?anual.getTaf().getCampo2():""), 2, 2); // TOTAL PROCEDIMIENTOS (C3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo3()!=null?anual.getTaf().getCampo3():""), 3, 2); // TOTAL PROCEDIMIENTOS EXITO (C4)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo35()!=null?anual.getTaf().getCampo35():""), 4, 2); // 4 mm (C5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo4()!=null?anual.getTaf().getCampo4():""), 5, 2); // 8 mm (C6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo5()!=null?anual.getTaf().getCampo5():""), 6, 2); // IRRIGADO ESTANDAR (C7)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo6()!=null?anual.getTaf().getCampo6():""), 7, 2); // CRIOABLACION (C8)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo36()!=null?anual.getTaf().getCampo36():""), 8, 2); // IRRIGADO CONTACTO (C9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo7()!=null?anual.getTaf().getCampo7():""), 9, 2); // OTRO (C10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo8()!=null?anual.getTaf().getCampo8():""), 9, 3); // OTRO - DESCRICPCION (D10)
		// SUSTRATO	
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo22()!=null?anual.getTaf().getCampo22():""), 11, 2); // AD (C12)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo23()!=null?anual.getTaf().getCampo23():""), 12, 2); // AI (C13)
		// N. TOTAL TQ (C11)
		Integer ad = 0, ai = 0;
		if(anual.getTaf().getCampo22()!=null && UtilDatos.esNumero(anual.getTaf().getCampo22()))
			ad = Integer.parseInt(anual.getTaf().getCampo22());
		if(anual.getTaf().getCampo23()!=null && UtilDatos.esNumero(anual.getTaf().getCampo23()))
			ai = Integer.parseInt(anual.getTaf().getCampo23());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(ad+ai), 10, 2); // N. TOTAL TQ (C11)
		
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo24()!=null?anual.getTaf().getCampo24():""), 13, 2); // AD - EXITO (C14)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo25()!=null?anual.getTaf().getCampo25():""), 14, 2); // AI - EXITO (C15)
		// COMPLICACIONES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo9()!=null?anual.getTaf().getCampo9():""), 15, 2); // BAV (C16)
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getTaf().getCampo10()!=null && UtilDatos.esNumero(anual.getTaf().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getTaf().getCampo10());
		if(anual.getTaf().getCampo11()!=null && UtilDatos.esNumero(anual.getTaf().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getTaf().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 16, 2); // COMPLICACION VASCULAR (C17)
		Integer derr = 0, tc = 0;
		if(anual.getTaf().getCampo12()!=null && UtilDatos.esNumero(anual.getTaf().getCampo12()))
			derr = Integer.parseInt(anual.getTaf().getCampo12());
		if(anual.getTaf().getCampo13()!=null && UtilDatos.esNumero(anual.getTaf().getCampo13()))
			tc = Integer.parseInt(anual.getTaf().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 17, 2); // DERRAME PERICARDICO (C18)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getTaf().getCampo14()!=null && UtilDatos.esNumero(anual.getTaf().getCampo14()))
			emb = Integer.parseInt(anual.getTaf().getCampo14());
		if(anual.getTaf().getCampo15()!=null && UtilDatos.esNumero(anual.getTaf().getCampo15()))
			acv = Integer.parseInt(anual.getTaf().getCampo15());
		if(anual.getTaf().getCampo16()!=null && UtilDatos.esNumero(anual.getTaf().getCampo16()))
			ait = Integer.parseInt(anual.getTaf().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 18, 2); // EMBOLISMO, ACV o AIT (C19)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo17()!=null?anual.getTaf().getCampo17():""), 19, 2); // IAM o ISQUEMIA (C20)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo18()!=null?anual.getTaf().getCampo18():""), 20, 2); // ICC o SHOCK (C21)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo19()!=null?anual.getTaf().getCampo19():""), 21, 2); // OTRA (C22)
		Integer m1 = 0, m2 = 0;
		if(anual.getTaf().getCampo20()!=null && UtilDatos.esNumero(anual.getTaf().getCampo20()))
			m1 = Integer.parseInt(anual.getTaf().getCampo20());
		if(anual.getTaf().getCampo21()!=null && UtilDatos.esNumero(anual.getTaf().getCampo21()))
			m2 = Integer.parseInt(anual.getTaf().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 22, 2); // MUERTES (C23)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo37()!=null?anual.getTaf().getCampo37():""), 23, 2); // CASOS PEDIATRICOS (C24)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo38()!=null?anual.getTaf().getCampo38():""), 24, 2); // CASOS CON NAVEGADOR (C25)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTaf().getCampo39()!=null?anual.getTaf().getCampo39():""), 25, 2); // CASOS SIN FLUOROSCOPIA (C26)
	}
	
	public void rellenaICT(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo1()!=null?anual.getIct().getCampo1():""), 1, 2); // TOTAL PACIENTES (C2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo2()!=null?anual.getIct().getCampo2():""), 2, 2); // TOTAL PROCEDIMIENTOS (C3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo3()!=null?anual.getIct().getCampo3():""), 3, 2); // TOTAL PROCEDIMIENTOS EXITO (C4)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo35()!=null?anual.getIct().getCampo35():""), 4, 2); // 4 mm (C5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo4()!=null?anual.getIct().getCampo4():""), 5, 2); // 8 mm (C6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo5()!=null?anual.getIct().getCampo5():""), 6, 2); // IRRIGADO ESTANDAR (C7)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo6()!=null?anual.getIct().getCampo6():""), 7, 2); // CRIOABLACION (C8)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo36()!=null?anual.getIct().getCampo36():""), 8, 2); // IRRIGADO CONTACTO (C9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo7()!=null?anual.getIct().getCampo7():""), 9, 2); // OTRO (C10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo8()!=null?anual.getIct().getCampo8():""), 9, 3); // OTRO - DESCRICPCION (D10)
		// COMPLICACIONES
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo9()!=null?anual.getIct().getCampo9():""), 10, 2); // BAV (C11)
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getIct().getCampo10()!=null && UtilDatos.esNumero(anual.getIct().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getIct().getCampo10());
		if(anual.getIct().getCampo11()!=null && UtilDatos.esNumero(anual.getIct().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getIct().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 11, 2); // COMPLICACION VASCULAR (C12)
		Integer derr = 0, tc = 0;
		if(anual.getIct().getCampo12()!=null && UtilDatos.esNumero(anual.getIct().getCampo12()))
			derr = Integer.parseInt(anual.getIct().getCampo12());
		if(anual.getIct().getCampo13()!=null && UtilDatos.esNumero(anual.getIct().getCampo13()))
			tc = Integer.parseInt(anual.getIct().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 12, 2); // DERRAME PERICARDICO (C13)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getIct().getCampo14()!=null && UtilDatos.esNumero(anual.getIct().getCampo14()))
			emb = Integer.parseInt(anual.getIct().getCampo14());
		if(anual.getIct().getCampo15()!=null && UtilDatos.esNumero(anual.getIct().getCampo15()))
			acv = Integer.parseInt(anual.getIct().getCampo15());
		if(anual.getIct().getCampo16()!=null && UtilDatos.esNumero(anual.getIct().getCampo16()))
			ait = Integer.parseInt(anual.getIct().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 13, 2); // EMBOLISMO, ACV o AIT (C14)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo17()!=null?anual.getIct().getCampo17():""), 14, 2); // IAM o ISQUEMIA (C15)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo18()!=null?anual.getIct().getCampo18():""), 15, 2); // ICC o SHOCK (C16)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo19()!=null?anual.getIct().getCampo19():""), 16, 2); // OTRA (C17)
		Integer m1 = 0, m2 = 0;
		if(anual.getIct().getCampo20()!=null && UtilDatos.esNumero(anual.getIct().getCampo20()))
			m1 = Integer.parseInt(anual.getIct().getCampo20());
		if(anual.getIct().getCampo21()!=null && UtilDatos.esNumero(anual.getIct().getCampo21()))
			m2 = Integer.parseInt(anual.getIct().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 17, 2); // MUERTES (C18)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo37()!=null?anual.getIct().getCampo37():""), 18, 2); // CASOS PEDIATRICOS (C19)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo38()!=null?anual.getIct().getCampo38():""), 19, 2); // CASOS CON NAVEGADOR (C20)
		ExcelUtils.escribeValorCelda(hoja,(anual.getIct().getCampo39()!=null?anual.getIct().getCampo39():""), 20, 2); // CASOS SIN FLUOROSCOPIA (C21)
	}
	
	public void rellenaFLUTTER(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo1()!=null?anual.getFta().getCampo1():""), 1, 2); // TOTAL PACIENTES (C2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo2()!=null?anual.getFta().getCampo2():""), 2, 2); // TOTAL PROCEDIMIENTOS (C3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo3()!=null?anual.getFta().getCampo3():""), 3, 2); // TOTAL PROCEDIMIENTOS EXITO (C4)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo35()!=null?anual.getFta().getCampo35():""), 4, 2); // 4 mm (C5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo4()!=null?anual.getFta().getCampo4():""), 5, 2); // 8 mm (C6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo5()!=null?anual.getFta().getCampo5():""), 6, 2); // IRRIGADO ESTANDAR (C7)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo6()!=null?anual.getFta().getCampo6():""), 7, 2); // CRIOABLACION (C8)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo36()!=null?anual.getFta().getCampo36():""), 8, 2); // IRRIGADO CONTACTO (C9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo7()!=null?anual.getFta().getCampo7():""), 9, 2); // OTRO (C10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo8()!=null?anual.getFta().getCampo8():""), 9, 3); // OTRO - DESCRICPCION (D10)
		// SUSTRATO - LOCALIZACION
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo22()!=null?anual.getFta().getCampo22():""), 11, 2); // AD (C12)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo23()!=null?anual.getFta().getCampo23():""), 12, 2); // AI (C13)
		// N. TOTAL TQ (C11)
		Integer ad = 0, ai = 0;
		if(anual.getFta().getCampo22()!=null && UtilDatos.esNumero(anual.getFta().getCampo22()))
			ad = Integer.parseInt(anual.getTaf().getCampo22());
		if(anual.getFta().getCampo23()!=null && UtilDatos.esNumero(anual.getFta().getCampo23()))
			ai = Integer.parseInt(anual.getTaf().getCampo23());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(ad+ai), 10, 2); // N. TOTAL TQ (C11)
			
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo24()!=null?anual.getFta().getCampo24():""), 13, 2); // AD - EXITO (C14)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo25()!=null?anual.getFta().getCampo25():""), 14, 2); // AI -EXITO (C15)
		// SUSTRATO - TIPO
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo26()!=null?anual.getFta().getCampo26():""), 15, 2); // ABLACION FA (C16)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo27()!=null?anual.getFta().getCampo27():""), 16, 2); // CC (C17)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo28()!=null?anual.getFta().getCampo28():""), 17, 2); // NO ASOCIADA A CC (C18)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo29()!=null?anual.getFta().getCampo29():""), 18, 2); // OTRO (C19)
		// COMPLICACIONES
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo9()!=null?anual.getFta().getCampo9():""), 19, 2); // BAV (C20)
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getFta().getCampo10()!=null && UtilDatos.esNumero(anual.getFta().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getFta().getCampo10());
		if(anual.getFta().getCampo11()!=null && UtilDatos.esNumero(anual.getFta().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getFta().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 20, 2); // COMPLICACION VASCULAR (C21)
		Integer derr = 0, tc = 0;
		if(anual.getFta().getCampo12()!=null && UtilDatos.esNumero(anual.getFta().getCampo12()))
			derr = Integer.parseInt(anual.getFta().getCampo12());
		if(anual.getFta().getCampo13()!=null && UtilDatos.esNumero(anual.getFta().getCampo13()))
			tc = Integer.parseInt(anual.getFta().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 21, 2); // DERRAME PERICARDICO (C22)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getFta().getCampo14()!=null && UtilDatos.esNumero(anual.getFta().getCampo14()))
			emb = Integer.parseInt(anual.getFta().getCampo14());
		if(anual.getFta().getCampo15()!=null && UtilDatos.esNumero(anual.getFta().getCampo15()))
			acv = Integer.parseInt(anual.getFta().getCampo15());
		if(anual.getFta().getCampo16()!=null && UtilDatos.esNumero(anual.getFta().getCampo16()))
			ait = Integer.parseInt(anual.getFta().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 22, 2); // EMBOLISMO, ACV o AIT (C23)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo17()!=null?anual.getFta().getCampo17():""), 23, 2); // IAM o ISQUEMIA (C24)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo18()!=null?anual.getFta().getCampo18():""), 24, 2); // ICC o SHOCK (C25)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo19()!=null?anual.getFta().getCampo19():""), 25, 2); // OTRA (C26)
		Integer m1 = 0, m2 = 0;
		if(anual.getFta().getCampo20()!=null && UtilDatos.esNumero(anual.getFta().getCampo20()))
			m1 = Integer.parseInt(anual.getFta().getCampo20());
		if(anual.getFta().getCampo21()!=null && UtilDatos.esNumero(anual.getFta().getCampo21()))
			m2 = Integer.parseInt(anual.getFta().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 26, 2); // MUERTES (C27)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo37()!=null?anual.getFta().getCampo37():""), 27, 2); // CASOS PEDIATRICOS (C28)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo38()!=null?anual.getFta().getCampo38():""), 28, 2); // CASOS CON NAVEGADOR (C29)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFta().getCampo39()!=null?anual.getFta().getCampo39():""), 29, 2); // CASOS SIN FLUOROSCOPIA (C30)
	}
	
	public void rellenaFA(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo1()!=null?anual.getFa().getCampo1():""), 1, 3); // TOTAL PACIENTES (D2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo2()!=null?anual.getFa().getCampo2():""), 2, 3); // TOTAL PROCEDIMIENTOS (D3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo3()!=null?anual.getFa().getCampo3():""), 3, 3); // TOTAL PROCEDIMIENTOS EXITO (D4)
		// SUSTRATO
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo42()!=null?anual.getFa().getCampo42():""), 4, 3); // PAROXISTICA (D5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo43()!=null?anual.getFa().getCampo43():""), 5, 3); // PERSISTENTE (D6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo44()!=null?anual.getFa().getCampo44():""), 6, 3); // LONG STANDING (D7)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo5()!=null?anual.getFa().getCampo5():""), 7, 3); // IRRIGADO ESTANDAR (D8)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo36()!=null?anual.getFa().getCampo36():""), 8, 3); // IRRIGADO CONTACTO (D9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo7()!=null?anual.getFa().getCampo7():""), 9, 3); // OTRO (D10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo8()!=null?anual.getFa().getCampo8():""), 9, 4); // OTRO - DESCRICPCION (E10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo6()!=null?anual.getFa().getCampo6():""), 10, 3); // CRIOABLACION (D11)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCatRFFasica()!=null?anual.getFa().getCatRFFasica():""), 11, 3); // RF BASICA PVAC (D12)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCatRFIrrig()!=null?anual.getFa().getCatRFIrrig():""), 12, 3); // RF IRRIGADO nMARQ (D13)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCatLaser()!=null?anual.getFa().getCatLaser():""), 13, 3); // LASER (D14)
		// OBJETIVOS
		Integer seg = 0, cir = 0;
		if(anual.getFa().getCampo26()!=null && UtilDatos.esNumero(anual.getFa().getCampo26()))
			seg = Integer.parseInt(anual.getFa().getCampo26());
		if(anual.getFta().getCampo31()!=null && UtilDatos.esNumero(anual.getFta().getCampo31()))
			cir = Integer.parseInt(anual.getFta().getCampo31());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(seg+cir), 14, 2); // AISLAMIENTO VVPP (D15)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo45()!=null?anual.getFa().getCampo45():""), 15, 3); // REDUCCION ECG (D16)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo46()!=null?anual.getFa().getCampo46():""), 16, 3); // LINEAS AI (D17)	
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo47()!=null?anual.getFa().getCampo47():""), 17, 3); // ELIMINACION CFAE (D18)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo32()!=null?anual.getFa().getCampo32():""), 18, 3); // AISLAMIENTO VCS (D19)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo33()!=null?anual.getFa().getCampo33():""), 19, 3); // OTROS (D20)
		Integer seg_ex = 0, cir_ex = 0;
		if(anual.getFa().getCampo24()!=null && UtilDatos.esNumero(anual.getFa().getCampo24()))
			seg_ex = Integer.parseInt(anual.getFa().getCampo24());
		if(anual.getFta().getCampo25()!=null && UtilDatos.esNumero(anual.getFta().getCampo25()))
			cir_ex = Integer.parseInt(anual.getFta().getCampo25());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(seg_ex+cir_ex), 20, 2); // AISLAMIENTO VVPP - EXITO (D21)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo48()!=null?anual.getFa().getCampo48():""), 21, 3); // REDUCCION ECG - EXITO(D22)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo49()!=null?anual.getFa().getCampo49():""), 22, 3); // LINEAS AI - EXITO(D23)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo50()!=null?anual.getFa().getCampo50():""), 23, 3); // ELIMINACON CFAE - EXITO(D24)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo27()!=null?anual.getFa().getCampo27():""), 24, 3); // AISLAMIENTO VCS - EXITO(D25)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo28()!=null?anual.getFa().getCampo28():""), 25, 3); // OTROS - EXITO(D26)	
		// COMPLICACIONES
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo9()!=null?anual.getFa().getCampo9():""), 26, 3); // BAV (D27)
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getFa().getCampo10()!=null && UtilDatos.esNumero(anual.getFa().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getFa().getCampo10());
		if(anual.getFa().getCampo11()!=null && UtilDatos.esNumero(anual.getFa().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getFa().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 27, 3); // COMPLICACION VASCULAR (D28)
		Integer derr = 0, tc = 0;
		if(anual.getFa().getCampo12()!=null && UtilDatos.esNumero(anual.getFa().getCampo12()))
			derr = Integer.parseInt(anual.getFa().getCampo12());
		if(anual.getFa().getCampo13()!=null && UtilDatos.esNumero(anual.getFa().getCampo13()))
			tc = Integer.parseInt(anual.getFa().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 28, 3); // DERRAME PERICARDICO (D29)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getFa().getCampo14()!=null && UtilDatos.esNumero(anual.getFa().getCampo14()))
			emb = Integer.parseInt(anual.getFa().getCampo14());
		if(anual.getFa().getCampo15()!=null && UtilDatos.esNumero(anual.getFa().getCampo15()))
			acv = Integer.parseInt(anual.getFa().getCampo15());
		if(anual.getFa().getCampo16()!=null && UtilDatos.esNumero(anual.getFa().getCampo16()))
			ait = Integer.parseInt(anual.getFa().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 29, 3); // EMBOLISMO, ACV o AIT (D30)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo17()!=null?anual.getFa().getCampo17():""), 30, 3); // IAM o ISQUEMIA (D31)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo18()!=null?anual.getFa().getCampo18():""), 31, 3); // ICC o SHOCK (D32)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo30()!=null?anual.getFa().getCampo30():""), 32, 3); // PARALISIS FRENICA (D33)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo19()!=null?anual.getFa().getCampo19():""), 33, 3); // OTRA (D34)
		Integer m1 = 0, m2 = 0;
		if(anual.getFa().getCampo20()!=null && UtilDatos.esNumero(anual.getFa().getCampo20()))
			m1 = Integer.parseInt(anual.getFa().getCampo20());
		if(anual.getFa().getCampo21()!=null && UtilDatos.esNumero(anual.getFa().getCampo21()))
			m2 = Integer.parseInt(anual.getFa().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 34, 3); // MUERTES (D35)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo40()!=null?anual.getFa().getCampo40():""), 35, 3); // CASOS VAINA DIRIGIBLE (D36)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo41()!=null?anual.getFa().getCampo41():""), 36, 3); // CASOS ECO INTRACARDIACO (D37)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo37()!=null?anual.getFa().getCampo37():""), 37, 3); // CASOS PEDIATRICOS (D38)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo38()!=null?anual.getFa().getCampo38():""), 38, 3); // CASOS CON NAVEGADOR (D39)
		ExcelUtils.escribeValorCelda(hoja,(anual.getFa().getCampo39()!=null?anual.getFa().getCampo39():""), 39, 3); // CASOS SIN FLUOROSCOPIA (D40)
	}
	
	public void rellenaTVIDIO(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo1()!=null?anual.getTvi().getCampo1():""), 1, 2); // TOTAL PACIENTES (C2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo2()!=null?anual.getTvi().getCampo2():""), 2, 2); // TOTAL PROCEDIMIENTOS (C3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo3()!=null?anual.getTvi().getCampo3():""), 3, 2); // TOTAL PROCEDIMIENTOS EXITO (C4)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo35()!=null?anual.getTvi().getCampo35():""), 4, 2); // 4 mm (C5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo4()!=null?anual.getTvi().getCampo4():""), 5, 2); // 8 mm (C6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo5()!=null?anual.getTvi().getCampo5():""), 6, 2); // IRRIGADO ESTANDAR (C7)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo6()!=null?anual.getTvi().getCampo6():""), 7, 2); // CRIOABLACION (C8)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo36()!=null?anual.getTvi().getCampo36():""), 8, 2); // IRRIGADO CONTACTO (C9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo7()!=null?anual.getTvi().getCampo7():""), 9, 2); // OTRO (C10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo8()!=null?anual.getTvi().getCampo8():""), 9, 3); // OTRO - DESCRICPCION (D10)
		// SUSTRATOS
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo22()!=null?anual.getTvi().getCampo22():""), 10, 2); // TRACTO SALIDA VD (C11)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo30()!=null?anual.getTvi().getCampo30():""), 11, 2); // ARTERIA PULMONAR (C12)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo23()!=null?anual.getTvi().getCampo23():""), 12, 2); // TRACTO SALIDA VI (C13)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo31()!=null?anual.getTvi().getCampo31():""), 13, 2); // RAIZ AORTICA (C14)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo24()!=null?anual.getTvi().getCampo24():""), 14, 2); // TV FASCICULAR (C15)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo32()!=null?anual.getTvi().getCampo32():""), 15, 2); // EPICARDIO/SC (C16)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo25()!=null?anual.getTvi().getCampo25():""), 16, 2); // OTRA (C17)
		
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo26()!=null?anual.getTvi().getCampo26():""), 17, 2); // TRACTO SALIDA VD - EXITO (C18)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo33()!=null?anual.getTvi().getCampo33():""), 18, 2); // ARTERIA PULMONAR - EXITO (C19)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo27()!=null?anual.getTvi().getCampo27():""), 19, 2); // TRACTO SALIDA VI - EXITO (C20)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo40()!=null?anual.getTvi().getCampo40():""), 20, 2); // RAIZ AORTICA - EXITO (C21)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo28()!=null?anual.getTvi().getCampo28():""), 21, 2); // TV FASCICULAR - EXITO (C22)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo41()!=null?anual.getTvi().getCampo41():""), 22, 2); // EPICARDIO/SC - EXITO (C23)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo29()!=null?anual.getTvi().getCampo29():""), 23, 2); // OTRA - EXITO (C24)
		// COMPLICACIONES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo9()!=null?anual.getTvi().getCampo9():""), 24, 2); // BAV (C25)
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getTvi().getCampo10()!=null && UtilDatos.esNumero(anual.getTvi().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getTvi().getCampo10());
		if(anual.getTvi().getCampo11()!=null && UtilDatos.esNumero(anual.getTvi().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getTvi().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 25, 2); // COMPLICACION VASCULAR (C26)
		Integer derr = 0, tc = 0;
		if(anual.getTvi().getCampo12()!=null && UtilDatos.esNumero(anual.getTvi().getCampo12()))
			derr = Integer.parseInt(anual.getTvi().getCampo12());
		if(anual.getTvi().getCampo13()!=null && UtilDatos.esNumero(anual.getTvi().getCampo13()))
			tc = Integer.parseInt(anual.getTvi().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 26, 2); // DERRAME PERICARDICO (C27)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getTvi().getCampo14()!=null && UtilDatos.esNumero(anual.getTvi().getCampo14()))
			emb = Integer.parseInt(anual.getTvi().getCampo14());
		if(anual.getTvi().getCampo15()!=null && UtilDatos.esNumero(anual.getTvi().getCampo15()))
			acv = Integer.parseInt(anual.getTvi().getCampo15());
		if(anual.getTvi().getCampo16()!=null && UtilDatos.esNumero(anual.getTvi().getCampo16()))
			ait = Integer.parseInt(anual.getTvi().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 27, 2); // EMBOLISMO, ACV o AIT (C28)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo17()!=null?anual.getTvi().getCampo28():""), 28, 2); // IAM o ISQUEMIA (C29)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo18()!=null?anual.getTvi().getCampo18():""), 29, 2); // ICC o SHOCK (C30)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo19()!=null?anual.getTvi().getCampo19():""), 30, 2); // OTRA (C31)
		Integer m1 = 0, m2 = 0;
		if(anual.getTvi().getCampo20()!=null && UtilDatos.esNumero(anual.getTvi().getCampo20()))
			m1 = Integer.parseInt(anual.getTvi().getCampo20());
		if(anual.getTvi().getCampo21()!=null && UtilDatos.esNumero(anual.getTvi().getCampo21()))
			m2 = Integer.parseInt(anual.getTvi().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 31, 2); // MUERTES (C32)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo37()!=null?anual.getTvi().getCampo37():""), 32, 2); // CASOS PEDIATRICOS (C33)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo38()!=null?anual.getTvi().getCampo38():""), 33, 2); // CASOS CON NAVEGADOR (C34)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvi().getCampo39()!=null?anual.getTvi().getCampo39():""), 34, 2); // CASOS SIN FLUOROSCOPIA (C35)
	}
	
	public void rellenaTVIAM(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo1()!=null?anual.getTviam().getCampo1():""), 1, 2); // TOTAL PACIENTES (C2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo2()!=null?anual.getTviam().getCampo2():""), 2, 2); // TOTAL PROCEDIMIENTOS (C3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo3()!=null?anual.getTviam().getCampo3():""), 3, 2); // TOTAL PROCEDIMIENTOS EXITO (C4)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo35()!=null?anual.getTviam().getCampo35():""), 4, 2); // 4 mm (C5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo4()!=null?anual.getTviam().getCampo4():""), 5, 2); // 8 mm (C6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo5()!=null?anual.getTviam().getCampo5():""), 6, 2); // IRRIGADO ESTANDAR (C7)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo6()!=null?anual.getTviam().getCampo6():""), 7, 2); // CRIOABLACION (C8)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo36()!=null?anual.getTviam().getCampo36():""), 8, 2); // IRRIGADO CONTACTO (C9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo7()!=null?anual.getTviam().getCampo7():""), 9, 2); // OTRO (C10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo8()!=null?anual.getTviam().getCampo8():""), 9, 3); // OTRO - DESCRICPCION (D10)
		// ACCESO
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo26()!=null?anual.getTviam().getCampo26():""), 10, 2); // ENDOCARDICO RETROAORTICO (C11)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo27()!=null?anual.getTviam().getCampo27():""), 11, 2); // ENDOCARDICO TRANSEPTAL (C12)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo28()!=null?anual.getTviam().getCampo28():""), 12, 2); // EPICARDICO (C13)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo29()!=null?anual.getTviam().getCampo29():""), 13, 2); // ENDOCARDICO Y EPICARDICO (C14)
		// TIPO DE ABLACION
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo24()!=null?anual.getTviam().getCampo24():""), 14, 2); // ABLACION CONVENCIONAL (C15)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo22()!=null?anual.getTviam().getCampo22():""), 15, 2); // ABLACION DE SUSTRATO (C16)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo25()!=null?anual.getTviam().getCampo25():""), 16, 2); // ABLACION CONVENCIONAL - EXITO (C17)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo23()!=null?anual.getTviam().getCampo23():""), 17, 2); // ABLACION DE SUSTRATO - EXITO (C18)		
		// COMPLICACIONES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo9()!=null?anual.getTviam().getCampo9():""), 18, 2); // BAV (C19)
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getTviam().getCampo10()!=null && UtilDatos.esNumero(anual.getTviam().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getTviam().getCampo10());
		if(anual.getTviam().getCampo11()!=null && UtilDatos.esNumero(anual.getTviam().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getTviam().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 19, 2); // COMPLICACION VASCULAR (C20)
		Integer derr = 0, tc = 0;
		if(anual.getTviam().getCampo12()!=null && UtilDatos.esNumero(anual.getTviam().getCampo12()))
			derr = Integer.parseInt(anual.getTviam().getCampo12());
		if(anual.getTviam().getCampo13()!=null && UtilDatos.esNumero(anual.getTviam().getCampo13()))
			tc = Integer.parseInt(anual.getTviam().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 20, 2); // DERRAME PERICARDICO (C21)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getTviam().getCampo14()!=null && UtilDatos.esNumero(anual.getTviam().getCampo14()))
			emb = Integer.parseInt(anual.getTviam().getCampo14());
		if(anual.getTviam().getCampo15()!=null && UtilDatos.esNumero(anual.getTviam().getCampo15()))
			acv = Integer.parseInt(anual.getTviam().getCampo15());
		if(anual.getTviam().getCampo16()!=null && UtilDatos.esNumero(anual.getTviam().getCampo16()))
			ait = Integer.parseInt(anual.getTviam().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 21, 2); // EMBOLISMO, ACV o AIT (C22)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo17()!=null?anual.getTviam().getCampo17():""), 22, 2); // IAM o ISQUEMIA (C23)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo18()!=null?anual.getTviam().getCampo18():""), 23, 2); // ICC o SHOCK (C24)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo19()!=null?anual.getTviam().getCampo19():""), 24, 2); // OTRA (C25)
		Integer m1 = 0, m2 = 0;
		if(anual.getTviam().getCampo20()!=null && UtilDatos.esNumero(anual.getTviam().getCampo20()))
			m1 = Integer.parseInt(anual.getTviam().getCampo20());
		if(anual.getTviam().getCampo21()!=null && UtilDatos.esNumero(anual.getTviam().getCampo21()))
			m2 = Integer.parseInt(anual.getTviam().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 25, 2); // MUERTES (C26)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo40()!=null?anual.getTviam().getCampo40():""), 26, 2); // USO VAINA DIRIGIBLE (C27)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo37()!=null?anual.getTviam().getCampo37():""), 27, 2); // CASOS PEDIATRICOS (C28)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo38()!=null?anual.getTviam().getCampo38():""), 28, 2); // CASOS CON NAVEGADOR (C29)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTviam().getCampo39()!=null?anual.getTviam().getCampo39():""), 29, 2); // CASOS SIN FLUOROSCOPIA (C30)
	}
	
	public void rellenaTVOTRAS(ArrAnual anual, XSSFSheet hoja){
		// DATOS GENERALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo1()!=null?anual.getTvnoiam().getCampo1():""), 1, 2); // TOTAL PACIENTES (C2)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo2()!=null?anual.getTvnoiam().getCampo2():""), 2, 2); // TOTAL PROCEDIMIENTOS (C3)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo3()!=null?anual.getTvnoiam().getCampo3():""), 3, 2); // TOTAL PROCEDIMIENTOS EXITO (C4)
		// CATETERES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo35()!=null?anual.getTvnoiam().getCampo35():""), 4, 2); // 4 mm (C5)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo4()!=null?anual.getTvnoiam().getCampo4():""), 5, 2); // 8 mm (C6)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo5()!=null?anual.getTvnoiam().getCampo5():""), 6, 2); // IRRIGADO ESTANDAR (C7)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo6()!=null?anual.getTvnoiam().getCampo6():""), 7, 2); // CRIOABLACION (C8)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo36()!=null?anual.getTvnoiam().getCampo36():""), 8, 2); // IRRIGADO CONTACTO (C9)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo7()!=null?anual.getTvnoiam().getCampo7():""), 9, 2); // OTRO (C10)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo8()!=null?anual.getTvnoiam().getCampo8():""), 9, 3); // OTRO - DESCRICPCION (D10)
		// ACCESO
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo40()!=null?anual.getTvnoiam().getCampo40():""), 10, 2); // ENDOCARDICO RETROAORTICO (C11)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo41()!=null?anual.getTvnoiam().getCampo41():""), 11, 2); // ENDOCARDICO TRANSEPTAL (C12)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo42()!=null?anual.getTvnoiam().getCampo42():""), 12, 2); // EPICARDICO (C13)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo43()!=null?anual.getTvnoiam().getCampo43():""), 13, 2); // ENDOCARDICO Y EPICARDICO (C14)
		// SUSTRATOS
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo26()!=null?anual.getTvnoiam().getCampo26():""), 14, 2); // M. DILATADA (C15)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo24()!=null?anual.getTvnoiam().getCampo24():""), 15, 2); // DAVD (C16)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo32()!=null?anual.getTvnoiam().getCampo32():""), 16, 2); // M. HIPERTROFICA (C17)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo44()!=null?anual.getTvnoiam().getCampo44():""), 17, 2); // M. CONGENITA (C18)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo22()!=null?anual.getTvnoiam().getCampo22():""), 18, 2); // TV RAMA-RAMA (C19)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo30()!=null?anual.getTvnoiam().getCampo30():""), 19, 2); // OTRA (C20)
		
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo27()!=null?anual.getTvnoiam().getCampo27():""), 20, 2); // M. DILATADA - EXITO(C21)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo25()!=null?anual.getTvnoiam().getCampo25():""), 21, 2); // DAVD - EXITO(C22)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo33()!=null?anual.getTvnoiam().getCampo33():""), 22, 2); // M. HIPERTROFICA - EXITO(C23)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo45()!=null?anual.getTvnoiam().getCampo45():""), 23, 2); // M. CONGENITA - EXITO(C24)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo23()!=null?anual.getTvnoiam().getCampo23():""), 24, 2); // TV RAMA-RAMA - EXITO(C25)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo31()!=null?anual.getTvnoiam().getCampo31():""), 25, 2); // OTRA - EXITO(C26)
		// COMPLICACIONES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo9()!=null?anual.getTvnoiam().getCampo9():""), 26, 2); // BAV (C27)
		Integer c_vasc_v = 0, c_vasc_a = 0;
		if(anual.getTvnoiam().getCampo10()!=null && UtilDatos.esNumero(anual.getTvnoiam().getCampo10()))
			c_vasc_v = Integer.parseInt(anual.getTvnoiam().getCampo10());
		if(anual.getTvnoiam().getCampo11()!=null && UtilDatos.esNumero(anual.getTvnoiam().getCampo11()))
			c_vasc_a = Integer.parseInt(anual.getTvnoiam().getCampo11());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(c_vasc_v+c_vasc_a), 27, 2); // COMPLICACION VASCULAR (C28)
		Integer derr = 0, tc = 0;
		if(anual.getTvnoiam().getCampo12()!=null && UtilDatos.esNumero(anual.getTvnoiam().getCampo12()))
			derr = Integer.parseInt(anual.getTvnoiam().getCampo12());
		if(anual.getTvnoiam().getCampo13()!=null && UtilDatos.esNumero(anual.getTvnoiam().getCampo13()))
			tc = Integer.parseInt(anual.getTvnoiam().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(derr+tc), 28, 2); // DERRAME PERICARDICO (C29)
		Integer emb = 0, acv = 0, ait = 0;
		if(anual.getTvnoiam().getCampo14()!=null && UtilDatos.esNumero(anual.getTvnoiam().getCampo14()))
			emb = Integer.parseInt(anual.getTvnoiam().getCampo14());
		if(anual.getTvnoiam().getCampo15()!=null && UtilDatos.esNumero(anual.getTvnoiam().getCampo15()))
			acv = Integer.parseInt(anual.getTvnoiam().getCampo15());
		if(anual.getTvnoiam().getCampo16()!=null && UtilDatos.esNumero(anual.getTvnoiam().getCampo16()))
			ait = Integer.parseInt(anual.getTvnoiam().getCampo16());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(emb+acv+ait), 29, 2); // EMBOLISMO, ACV o AIT (C30)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo17()!=null?anual.getTvnoiam().getCampo17():""), 30, 2); // IAM o ISQUEMIA (C31)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo18()!=null?anual.getTvnoiam().getCampo18():""), 31, 2); // ICC o SHOCK (C32)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo19()!=null?anual.getTvnoiam().getCampo19():""), 32, 2); // OTRA (C33)
		Integer m1 = 0, m2 = 0;
		if(anual.getTvnoiam().getCampo20()!=null && UtilDatos.esNumero(anual.getTvnoiam().getCampo20()))
			m1 = Integer.parseInt(anual.getTvnoiam().getCampo20());
		if(anual.getTvnoiam().getCampo21()!=null && UtilDatos.esNumero(anual.getTvnoiam().getCampo21()))
			m2 = Integer.parseInt(anual.getTvnoiam().getCampo13());
		ExcelUtils.escribeValorCelda(hoja,String.valueOf(m1+m2), 33, 2); // MUERTES (C34)
		// DATOS ADICIONALES
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo37()!=null?anual.getTvnoiam().getCampo37():""), 34, 2); // CASOS PEDIATRICOS (C35)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo38()!=null?anual.getTvnoiam().getCampo38():""), 35, 2); // CASOS CON NAVEGADOR (C36)
		ExcelUtils.escribeValorCelda(hoja,(anual.getTvnoiam().getCampo39()!=null?anual.getTvnoiam().getCampo39():""), 36, 2); // CASOS SIN FLUOROSCOPIA (C37)
	}
}

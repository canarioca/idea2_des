package com.sorin.idea.util;

import hvn.cm.modelo.ServicioException;
import hvn.mod.jsf.Lanzador;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.PropertyResourceBundle;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import oracle.jdbc.pool.OracleDataSource;

import org.w3c.dom.Document;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.query.JRXPathQueryExecuterFactory;
import net.sf.jasperreports.engine.util.JRXmlUtils;

public class ConstructorRtf {
	static final public long serialVersionUID = 1;
	
	protected static String ficheroPropiedadesBD = "hvn/apl/jwpedidos/dao/bd.properties";
	

	/**
	 * Crea el archivo RTF de una actividad guardada.
	 * 
	 * @param contexto
	 * @param nombreFicheroDatos
	 * @throws ServicioException
	 */
	public void generarArchivoRtf(FacesContext contexto,
			String nombreFicheroDatos, String nombreJasper, String nhc, String tipoproc)
			throws ServicioException {
		// ServletContext context = getServletConfig().getServletContext();
		// InputStream reportStream = null, inputStream = null;
		JasperPrint jasperPrint = null;
		JasperPrint jasperPrintGlobal = null;
		String reportFileName = null;
		String subreportFileName = null;
		String xmlFileName = null;
		ExternalContext externalContext = contexto.getExternalContext();
		HttpServletRequest req = (HttpServletRequest) contexto
				.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) contexto
				.getExternalContext().getResponse();
		String sesionID = req.getRequestedSessionId();

		try {
			ServletOutputStream servletOutputStream = response
					.getOutputStream();
			// inicializo el template de Jasper
			reportFileName = req.getRealPath("/reportes/" + nombreJasper);

			xmlFileName = nombreFicheroDatos;
			// creo el report
			File reportFile = new File(reportFileName);
			// creo el xml
			File xmlFile = new File(xmlFileName);
			if (!reportFile.exists())
				throw new JRRuntimeException(
						"Fichero Template no encontrado. Debe compilarlo previamente. "
								+ reportFileName);

			if (!xmlFile.exists())
				throw new JRRuntimeException("Fichero XML no encontrado.");

			Map parameters = new HashMap();
			Map parameters2 = new HashMap();
			Document document = JRXmlUtils.parse(xmlFile);

			parameters.put(
					JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT,
					document);
			parameters.put("SUBREPORT_DIR", reportFile.getParent());

			jasperPrint = JasperFillManager.fillReport(reportFileName,
					parameters);

			// exportamos a pdf
			//byte[] pdfasbytes = JasperExportManager.exportReportToPdf(jasperPrint);
			
			/******************************/
			final JRRtfExporter rtfExporter = new JRRtfExporter();
	        final ByteArrayOutputStream rtfStream = new ByteArrayOutputStream();
	        rtfExporter.setParameter(JRExporterParameter.JASPER_PRINT,jasperPrint);
	        rtfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,rtfStream);
	        rtfExporter.exportReport();
	        byte[] rtfResume = rtfStream.toByteArray();
			/******************************/
			
			// byte[] pdfasbytes =
			// JasperExportManager.exportReportToPdf(jasperPrint2);
	        reportFileName =nhc+"_"+tipoproc+"_"+UtilFechas.dateToString(new Date())+".rtf";
			response.setContentType("application/rtf");
			response.setContentLength(rtfResume.length);
			//response.setHeader("Content-Transfer-Enconding", "binary");
			response.setHeader("Content-disposition", "inline; filename=\""
					+ reportFileName + "\"");

			servletOutputStream.write(rtfResume);

			// esta sentencia es extremadamente importante de cara a conseguir
			// que se pueda abrir el
			// archivo
			contexto.responseComplete();

			xmlFile.delete();
		} catch (IOException ioe) {
			throw new ServicioException("Error al crear el fichero de claves "
					+ ioe.getMessage());
		} catch (JRException je) {
			throw new ServicioException("Error al crear el fichero de claves "
					+ je.getMessage());
		}

		// servletOutputStream.flush();
		// servletOutputStream.close();

	}

	/**
	 * 
	 * @param contexto
	 * @param nombreFicheroDatos
	 * @return String con la ruta del documento pdf que se genera.
	 * @throws ServicioException
	 */

	public String generarArchivoPdfFile(FacesContext contexto,
			String nombreFicheroDatos, String nombreJasper)
			throws ServicioException {
		// ServletContext context = getServletConfig().getServletContext();
		// InputStream reportStream = null, inputStream = null;
		JasperPrint jasperPrint = null;
		JasperPrint jasperPrintGlobal = null;
		String reportFileName = null;
		String subreportFileName = null;
		String xmlFileName = null;
		ExternalContext externalContext = contexto.getExternalContext();
		HttpServletRequest req = (HttpServletRequest) contexto
				.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) contexto
				.getExternalContext().getResponse();
		String sesionID = req.getRequestedSessionId();

		try {
			ServletOutputStream servletOutputStream = response
					.getOutputStream();
			// inicializo el template de Jasper
			reportFileName = req.getRealPath("/reportes/" + nombreJasper);

			xmlFileName = nombreFicheroDatos;
			// creo el report
			File reportFile = new File(reportFileName);
			// creo el xml
			File xmlFile = new File(xmlFileName);
			if (!reportFile.exists())
				throw new JRRuntimeException(
						"Fichero Template no encontrado. Debe compilarlo previamente. "
								+ reportFileName);

			if (!xmlFile.exists())
				throw new JRRuntimeException("Fichero XML no encontrado.");

			Map parameters = new HashMap();
			Map parameters2 = new HashMap();
			Document document = JRXmlUtils.parse(xmlFile);

			parameters.put(
					JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT,
					document);
			parameters.put("SUBREPORT_DIR", reportFile.getParent());

			jasperPrint = JasperFillManager.fillReport(reportFileName,
					parameters);

			// exportamos a pdf
			String destino = req.getRealPath("/reportes/tmp_" + sesionID
					+ ".pdf");
			JasperExportManager.exportReportToPdfFile(jasperPrint, destino);

			return destino;

		} catch (IOException ioe) {
			throw new ServicioException("Error al crear el fichero de claves "
					+ ioe.getMessage());
		} catch (JRException je) {
			throw new ServicioException("Error al crear el fichero de claves "
					+ je.getMessage());
		}

		// servletOutputStream.flush();
		// servletOutputStream.close();

	}

	public  void generarArchivoPdfDinamico(FacesContext contexto, File xml, File jasper) throws ServicioException{
        JasperPrint jasperPrint = null;
        String url;
    	String driver;
    	String username;
    	String password;
        
        String xmlFileName = null ;
        HttpServletRequest req = (HttpServletRequest) contexto.getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) contexto.getExternalContext().getResponse();
      
        try {
        	InputStream inputStream = Manager.class.getClassLoader()
        		.getResourceAsStream(ficheroPropiedadesBD);
        	PropertyResourceBundle bundle = new PropertyResourceBundle(
        			inputStream);
        	driver = bundle.getString("jdbc.driver");
        	url = bundle.getString("jdbc.url");
        	username = bundle.getString("jdbc.username");
        	password = bundle.getString("jdbc.password");
	
        	ServletOutputStream servletOutputStream = response.getOutputStream();

            Map parameters = new HashMap();
            if(xml != null){
            	Document document = JRXmlUtils.parse(xml);          
            	parameters.put(JRXPathQueryExecuterFactory.PARAMETER_XML_DATA_DOCUMENT, document);
            }
            parameters.put("SUBREPORT_DIR", jasper.getParent());
            
            Connection con = null;
            OracleDataSource basicDataSource = new OracleDataSource();
			basicDataSource.setDriverType(driver);
			basicDataSource.setUser(username);
			basicDataSource.setPassword(password);
			basicDataSource.setURL(url);

			con = basicDataSource.getConnection();
        
            jasperPrint = JasperFillManager.fillReport(jasper.getAbsolutePath(),parameters, con);
            
            //exportamos a pdf
            byte[] pdfasbytes = JasperExportManager.exportReportToPdf(jasperPrint);   
            
            response.setContentType("application/pdf");
			response.setContentLength(pdfasbytes.length);
			response.setHeader("Content-Transfer-Enconding", "binary");
			response.setHeader("Content-disposition", "inline; filename=\"ReporteVisitas\"");

			servletOutputStream.write(pdfasbytes);

			contexto.responseComplete();
        }
        catch (IOException ioe) {
            throw new ServicioException("Error al crear el fichero de claves " + ioe.getMessage());
        }
        catch (JRException je) {
            throw new ServicioException("Error al crear el fichero de claves " + je.getMessage());
        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	public static  String doc2Str(Document d){		
		   try   
		    	{      
		    		DOMSource domSource = new DOMSource(d);       
		    		StringWriter writer = new StringWriter();      
		    		StreamResult result = new StreamResult(writer);       
		    		TransformerFactory tf = TransformerFactory.newInstance();      
		    		Transformer transformer = tf.newTransformer();      
		    		transformer.transform(domSource, result);      
		    		return writer.toString();   
		    	}   
		    	catch(TransformerException ex) 
		    	{      
		    		ex.printStackTrace();     
		    		return null;  
		    	}  	  
		    }
}

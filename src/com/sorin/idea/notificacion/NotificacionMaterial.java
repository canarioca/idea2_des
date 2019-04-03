package com.sorin.idea.notificacion;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.mirth.connect.connectors.ws.DefaultAcceptMessageServiceStub;
import com.mirth.connect.connectors.ws.DefaultAcceptMessageServiceStub.AcceptMessage;
import com.mirth.connect.connectors.ws.DefaultAcceptMessageServiceStub.AcceptMessageE;
import com.mirth.connect.connectors.ws.DefaultAcceptMessageServiceStub.AcceptMessageResponse;
import com.mirth.connect.connectors.ws.DefaultAcceptMessageServiceStub.AcceptMessageResponseE;
import com.sorin.idea.iu.ControlImplantes;



public class NotificacionMaterial {

	private static Logger logger = Logger.getLogger(NotificacionMaterial.class);
	private String endpoint;
	protected static String  ficheroPropiedades = "com/sorin/idea/notificacion/url.properties";
	
	public NotificacionMaterial(){
		try {
            InputStream inputStream = NotificacionMaterial.class.getClassLoader().getResourceAsStream(ficheroPropiedades);
            PropertyResourceBundle bundle = new PropertyResourceBundle(inputStream);
            this.endpoint = bundle.getString("endpointnotificacion");
        }
        catch (Exception e) {
        	logger.error("No se puede iniciar configuración Notificación de Material. Motivo: "+e.getMessage());
        }
	}
	
	public void notificaMaterialGenerador(String mod,String ref,String fab,String tipo, String modo, String cad, String cvd,String cvi,String rf, String mri,String idea,String gs1){
		String req = "1:"+mod+";"+ref+";"+fab+";"+tipo+";"+modo+";"+cad+";"+cvd+";"+cvi+";"+rf+";"+mri+";"+idea+";"+gs1;
		try{
			DefaultAcceptMessageServiceStub stub = new DefaultAcceptMessageServiceStub(endpoint);
			AcceptMessageE request = new AcceptMessageE();
			AcceptMessage msg = new AcceptMessage();
			msg.setArg0(req);
			request.setAcceptMessage(msg);
			stub.acceptMessage(request);
			logger.info("Notificación de material (GENERADOR) enviada con éxito.");
		}catch(Exception ex){
			logger.error("No se ha podido enviar notificación de generador. Motivo: "+ex.getMessage());
		}
	}
	public void notificaMaterialElectrodo(String mod,String ref,String fab,String pol, 
				String fij, String con, String bob,String idea,String nmod,String gs1){
		String req = "2:"+mod+";"+ref+";"+fab+";"+pol+";"+fij+";"+con+";"+bob+";"+idea+";"+nmod+";"+gs1;
		try{
			DefaultAcceptMessageServiceStub stub = new DefaultAcceptMessageServiceStub(endpoint);
			AcceptMessageE request = new AcceptMessageE();
			AcceptMessage msg = new AcceptMessage();
			msg.setArg0(req);
			request.setAcceptMessage(msg);
			stub.acceptMessage(request);
			logger.info("Notificación de material (ELECTRODO) enviada con éxito.");
		}catch(Exception ex){
			logger.error("No se ha podido enviar notificación de ELECTRODO. Motivo: "+ex.getMessage());
		}		
		
	}
	public void notificaMaterialCateter(){
		try{
			logger.info("Notificación de material (CATETER) enviada con éxito.");
		}catch(Exception ex){
			logger.error("No se ha podido enviar notificación de cateter. Motivo: "+ex.getStackTrace());
		}
	}
	/**
     * Obtiene una configuración por fichero de propiedades.
     * 
     * @param fichero de propiedades.
     * @throws ServicioException
     */
    public static void configuracionFicheroProperties(String fileName) {
        
    }
	
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
}

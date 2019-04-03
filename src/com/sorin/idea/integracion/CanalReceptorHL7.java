package com.sorin.idea.integracion;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

import com.sorin.idea.integracion.programadores.LogicaIntegracionProgramadores;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.message.ACK;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.parser.Parser;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageStringIterator;

public class CanalReceptorHL7 {

	private static Logger logger = Logger.getLogger(CanalReceptorHL7.class);
	/**
	 * Metodo rx de mensajes para encaminar por un procesamiento u otro.
	 * @param in
	 * @return
	 */
	public static String receptorHL7(String input){
		String ack="";
		String msg_oru="";
		String msg_adt="";
		String msg_ack="";
		// Obtención de mensajes ADT_A04 y ORU_R01. Si no trae #####, es un NACK
		String[] aux =input.split("######");
		
		if(aux!=null && aux.length==2 ){
			/* Es necesario reparsear el string del mensaje HL7 recibido
			 * ya que da problemas con saltos de linea. El proceso consiste en
			 * pasar el string rx a Stream y con una clase de HAPI reparsearlo 
			 * a string. Esto ofrece un string adecuado para parsearlo a objeto HAPI
			 */
			//Declaramos el InputStream
			InputStream inputStream0=null;
			InputStream inputStream1=null;
			//Creamos un StringBuffer pasando como parametro el String a convertir.
			StringBuffer StringBuffer0 = new StringBuffer(aux[0]);
			StringBuffer StringBuffer1 = new StringBuffer(aux[1]);
			try {
				inputStream0= new ByteArrayInputStream(StringBuffer0.toString().getBytes("UTF-8"));
				inputStream1 = new ByteArrayInputStream(StringBuffer1.toString().getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			Hl7InputStreamMessageStringIterator iter1 = new Hl7InputStreamMessageStringIterator(inputStream1); 
			Hl7InputStreamMessageStringIterator iter0 = new Hl7InputStreamMessageStringIterator(inputStream0); 
			while (iter0.hasNext()) {
			 	msg_adt = iter0.next();
			}
			while (iter1.hasNext()) {
			 	msg_oru = iter1.next();
			}	
			HapiContext context = new DefaultHapiContext();
			Parser p = context.getGenericParser();
			Message hapiMsg_oru=null;
			Message hapiMsg_adt=null;
			try {
			    hapiMsg_oru = p.parse(msg_oru);
			    hapiMsg_adt = p.parse(msg_adt);
			}catch(Exception e) {
				logger.error("Error en procesado de mensaje ORU recibido. Motivo: "+e.getMessage(), e);
				e.printStackTrace();
			}
			
			ORU_R01 oruMsg = (ORU_R01)hapiMsg_oru;
			ADT_A01 adtMsg = (ADT_A01)hapiMsg_adt;
			String tipo = oruMsg.getMSH().getMsh9_MessageType().getMessageCode().getValue();
			// Discriminador
			LogicaIntegracionProgramadores logic = new LogicaIntegracionProgramadores();
			if(tipo.equals("ORM")){
				// TODO - encaminar a logica de integracion de ORM
			}else if(tipo.equals("ADT")){// Recepcion de mensajes
				ack = logic.procesaORU(oruMsg,adtMsg);
			}else if(tipo.equals("ORU")){
				ack = logic.procesaORU(oruMsg,adtMsg);
			}
		}else{ // GESTION NACK
			//Declaramos el InputStream
			InputStream inputStream0=null;
			//Creamos un StringBuffer pasando como parametro el String a convertir.
			StringBuffer StringBuffer0 = new StringBuffer(aux[0]);
			try {
				inputStream0= new ByteArrayInputStream(StringBuffer0.toString().getBytes("UTF-8"));				
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			Hl7InputStreamMessageStringIterator iter0 = new Hl7InputStreamMessageStringIterator(inputStream0); 
			while (iter0.hasNext()) {
			 	msg_ack = iter0.next();
			}
			HapiContext context = new DefaultHapiContext();
			Parser p = context.getGenericParser();
			Message hapiMsg_ack=null;
			try {
			    hapiMsg_ack = p.parse(msg_ack);
			}catch(Exception e) {
				logger.error("Error en procesado de mensaje ACK recibido. Motivo: "+e.getMessage(), e);
				e.printStackTrace();
			}
			ACK ackMsg = (ACK) hapiMsg_ack;
			LogicaIntegracionProgramadores logic = new LogicaIntegracionProgramadores();
			ack = logic.procesaACK(ackMsg);
		}	
		return ack;
	}
	
	
}

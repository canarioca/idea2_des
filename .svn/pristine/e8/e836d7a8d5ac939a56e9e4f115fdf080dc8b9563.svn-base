package com.sorin.idea.correo;

import hvn.cm.modelo.Mensaje;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.faces.context.FacesContext;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;

import com.sorin.idea.dao.ArrMaestrasDao;
import com.sorin.idea.dto.Cateter;
import com.sorin.idea.dto.Codigosgs128;
import com.sorin.idea.dto.Electrodos;
import com.sorin.idea.dto.Generador;
import com.sorin.idea.dto.Registradoreventos;
import com.sorin.idea.jdbc.ArrMaestrasDaoImpl;
import com.sorin.idea.util.UtilFechas;
import com.sshtools.j2ssh.util.Base64;


public class GestorCorreo {

	private static Logger logger = Logger.getLogger(GestorCorreo.class);
	private static Properties p = new Properties();
	//private ResourceBundle bundle;
	
	public GestorCorreo(){	
		inicia();
		//this.bundle = bundle;
	}
	/**
	 * Notificación de correo para nuevo generador
	 * @param sol
	 */
	public int sendMailToAdminGen(Generador gen, String centro, String user, int accion) {
		String smtp = null,port=null;
		try {
			smtp = p.getProperty("host");
			final String username = p.getProperty("username");
			final String password = Base64.decodeToString(p.getProperty("password"));
			final String to = p.getProperty("to");
			port = p.getProperty("port");
			// Dirección del host smtp
			Properties props = new Properties();
			props.put("mail.smtp.host", smtp);
						
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", port);
		
			// obtenemos una sesión por defecto con la dirección anterior
			Session session = Session.getDefaultInstance(props ,new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
			session.setDebug(false);

			String accion_str = "";
			if(accion==1)
				accion_str = "Nueva insercion";
			else
				accion_str = "Actualizacion";
			
			String codigos = this.obtenerGS128(gen.getCodigos());
			
			String tipo = "";
			if(gen.getTipo().equals("1"))
				tipo = "Marcapasos";
			else if(gen.getTipo().equals("2"))
				tipo = "DAI";
			else if(gen.getTipo().equals("3"))
				tipo = "CRT-P";
			else if(gen.getTipo().equals("4"))
				tipo = "CRT-D";
			else if(gen.getTipo().equals("5"))
				tipo = "MP LEADLESS";
			else if(gen.getTipo().equals("6"))
				tipo = "S-ICD";
			
			// Escribo el texto del mensaje
			BodyPart texto = new MimeBodyPart();
			String txt = "<html>" +
					"<head>" +
					"	<style>" +
					"		table {   " +
					"			border-collapse: collapse; " +
					"			width: 100%;" +
					"		}" +
					"		th, td {    " +
					"			text-align: left;    " +
					"			padding: 8px;" +
					"		}" +
					"		tr:nth-child(even){" +
					"			background-color: #f2f2f2" +
					"		}" +
					"		th {   " +
					"			background-color: #4CAF50;" +
					"		    color: white;" +
					"		}" +
					"	</style>" +
					"</head>" +
					"<body>" +
					"	<p><img src='cid:imagen1' style='width:56px;height:38px;'></p>"+
					"	<table>"+
					"		<tr>"+
					"			<th style='right: 0px;'>"+
					"				<h2>"+accion_str+" de material: Generador</h2>" +
					"			</th>"+
					"		</tr>"+
					"	</table>"+
					"	<table> " +
					"		<tr>" +
					"			<th>Fecha creación</th>" +
					"			<th>Usuario</th>" +
					"			<th>Centro</th>" +
					"		</tr>" +
					"		<tr>" +
					"			<td>"+UtilFechas.getFechaStringFormato(new Date(), "dd MMM yyyy")+"</td>" +
					"			<td>"+(user!=null?user:"No especificado")+"</td>" +
					"			<td>"+(centro!=null?centro:"No especificado")+"</td>" +
					"		</tr>" +
					"	</table>" +
					"	<table>"+
					"		<tr>"+
					"			<th style='right: 0px;'>"+
					"				<h3>GS1-128</h3>" +
					"			</th>"+
					"		</tr>"+
					"		<tr>" +
					"			<td>"+(!codigos.equals("")?codigos:"No especificado")+"</td>" +
					"		</tr>" +
					"	</table>"+
					"	<table> " +
					"		<tr>" +
					"			<th>IdGenerador</th>" +
					"			<th>Tipo</th>" +
					"			<th>Modelo</th>" +
					"			<th>Fabricante</th>" +
					"			<th>Referencia</th>" +
					"			<th>RF</th>" +
					"			<th>MRI</th>" +
					"		</tr>" +
					"		<tr>" +
					"			<td>"+gen.getIdgenerador()+"</td>" +
					"			<td>"+tipo+"</td>" +
					"			<td>"+(gen.getModelo()!=null?gen.getModelo():"No especificado.")+"</td>" +
					"			<td>"+(gen.getFabricante()!=null?gen.getFabricante():"No especificado.")+"</td>" +
					"			<td>"+(gen.getCodigo()!=null?gen.getCodigo():"No especificado.")+"</td>" +
					"			<td>"+(gen.getRf()!=null?(gen.getRf().equals((short)1)?"Si":"No"):"")+"</td>" +
					"			<td>"+(gen.getMri()!=null?(gen.getMri().equals((short)1)?"Si":"No"):"")+"</td>" +
					"		</tr>" +
					"		<tr>" +
					"			<th>Modo</th>" +
					"			<th>Conector AD</th>" +
					"			<th>Conector VD</th>" +
					"			<th>Conector VI</th>" +
					"			<th>Conector VD_2</th>" +
					"			<th>Conector VCS</th>" +
					"			<th>Id. RX</th>" +
					"		</tr>" +
					"		<tr>" +
					"			<td>"+(gen.getModo()!=null?gen.getModo():"No especificado")+"</td>" +
					"			<td>"+(gen.getConectorad()!=null?gen.getConectorad():"")+"</td>" +
					"			<td>"+(gen.getConectorvd()!=null?gen.getConectorvd():"")+"</td>" +
					"			<td>"+(gen.getConectorvi()!=null?gen.getConectorvi():"")+"</td>" +
					"			<td>"+(gen.getConectorVd2()!=null?gen.getConectorVd2():"")+"</td>" +
					"			<td>"+(gen.getConectorvcs()!=null?gen.getConectorvcs():"")+"</td>" +
					"			<td>"+(gen.getIdrx()!=null?gen.getIdrx():"")+"</td>" +
					"		</tr>" +
					"	</table>" +
					"</body>" +
					"</html>";
			
			texto.setContent(txt,"text/html");
				
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			// Obtencion de las imagenes
			addCID("imagen1", "LogoIdea.png",multiParte);
			//addCID("imagen1", "C:/IDEA/ESTILOS/LogoIdeaLivaNova.png",multiParte);
				
			// Creamos un mensaje
			MimeMessage msg = new MimeMessage(session);

			// Se indica el remitente y el destinatario
			InternetAddress addressFrom = new InternetAddress("idea@omedit.com");
			msg.setFrom(addressFrom);
			msg.setSubject("Idea - Notificación de accion sobre material");
			
			msg.addRecipients(Message.RecipientType.TO, to);
			// Se configura el Asunto y la fecha de envío
			msg.setSentDate(new Date());
			// Se escribe el mensaje y se indica del tipo que es
			msg.setContent(multiParte);
			// Enviamos el email
			Transport.send(msg);
			logger.info("Email enviado con exito. IdGenerador: "+gen.getIdgenerador());
			return 1;										
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("No se ha podido enviar correo. Motivo: "+e.getMessage(), e);
			return -1;
		}
	}
	
	/**
	 * Notificación de correo para nuevo electrodo
	 * @param sol
	 */
	public int sendMailToAdminElec(Electrodos el, String centro, String user, int accion) {
		String smtp = null,port=null;
		try {
			smtp = p.getProperty("host");
			final String username = p.getProperty("username");
			final String password = Base64.decodeToString(p.getProperty("password"));
			final String to = p.getProperty("to");
			port = p.getProperty("port");
			// Dirección del host smtp
			Properties props = new Properties();
			props.put("mail.smtp.host", smtp);
						
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", port);
		
			// obtenemos una sesión por defecto con la dirección anterior
			Session session = Session.getDefaultInstance(props ,new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
			session.setDebug(false);

			String codigos = this.obtenerGS128(el.getCodigos());
			String accion_str = "";
			if(accion==1)
				accion_str = "Nueva insercion";
			else
				accion_str = "Actualizacion";
			
			// Escribo el texto del mensaje
			BodyPart texto = new MimeBodyPart();
			String txt = "<html>" +
					"<head>" +
					"	<style>" +
					"		table {   " +
					"			border-collapse: collapse; " +
					"			width: 100%;" +
					"		}" +
					"		th, td {    " +
					"			text-align: left;    " +
					"			padding: 8px;" +
					"		}" +
					"		tr:nth-child(even){" +
					"			background-color: #f2f2f2" +
					"		}" +
					"		th {   " +
					"			background-color: #4CAF50;" +
					"		    color: white;" +
					"		}" +
					"	</style>" +
					"</head>" +
					"<body>" +
					"	<p><img src='cid:imagen1' style='width:56px;height:38px;'></p>"+
					"	<table>"+
					"		<tr>"+
					"			<th style='right: 0px;'>"+
					"				<h2>"+accion_str+" de material: Electrodo</h2>" +
					"			</th>"+
					"		</tr>"+
					"	</table>"+
					"	<table> " +
					"		<tr>" +
					"			<th>Fecha creación</th>" +
					"			<th>Usuario</th>" +
					"			<th>Centro</th>" +
					"		</tr>" +
					"		<tr>" +
					"			<td>"+UtilFechas.getFechaStringFormato(new Date(), "dd MMM yyyy")+"</td>" +
					"			<td>"+(user!=null?user:"No especificado")+"</td>" +
					"			<td>"+(centro!=null?centro:"No especificado")+"</td>" +
					"		</tr>" +
					"	</table>" +
					"	<table>"+
					"		<tr>"+
					"			<th style='right: 0px;'>"+
					"				<h3>GS1-128</h3>" +
					"			</th>"+
					"		</tr>"+
					"		<tr>" +
					"			<td>"+(!codigos.equals("")?codigos:"No especificado")+"</td>" +
					"		</tr>" +
					"	</table>"+
					"	<table> " +
					"		<tr>" +
					"			<th>IdElectrodo</th>" +
					"			<th>Modelo</th>" +
					"			<th>Fabricante</th>" +
					"			<th>Referencia</th>" +
					"		</tr>" +
					"		<tr>" +
					"			<td>"+el.getIdelectrodo()+"</td>" +
					"			<td>"+(el.getModelo()!=null?el.getModelo():"No especificado.")+"</td>" +
					"			<td>"+(el.getFabricante()!=null?el.getFabricante():"No especificado.")+"</td>" +
					"			<td>"+(el.getCodigo()!=null?el.getCodigo():"No especificado.")+"</td>" +
					"		</tr>" +
					"		<tr>" +
					"			<th>Conector</th>" +
					"			<th>Fijacion</th>" +
					"			<th>Polaridad</th>" +
					"			<th>Bobina</th>" +
					"		</tr>" +
					"		<tr>" +
					"			<td>"+(el.getConector()!=null?el.getConector():"No especificado")+"</td>" +
					"			<td>"+(el.getFijacion()!=null?el.getFijacion():"")+"</td>" +
					"			<td>"+(el.getPolaridad()!=null?el.getPolaridad():"")+"</td>" +
					"			<td>"+(el.getBobina()!=null?el.getBobina():"")+"</td>" +
					"		</tr>" +
					"	</table>" +
					"</body>" +
					"</html>";
			
			texto.setContent(txt,"text/html");
				
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			// Obtencion de las imagenes
			addCID("imagen1", "LogoIdea.png",multiParte);
			//addCID("imagen1", "C:/IDEA/ESTILOS/LogoIdeaLivaNova.png",multiParte);
				
			// Creamos un mensaje
			MimeMessage msg = new MimeMessage(session);

			// Se indica el remitente y el destinatario
			InternetAddress addressFrom = new InternetAddress("idea@omedit.com");
			msg.setFrom(addressFrom);
			msg.setSubject("Idea - Notificación de accion sobre material");
			
			msg.addRecipients(Message.RecipientType.TO, to);
			// Se configura el Asunto y la fecha de envío
			msg.setSentDate(new Date());
			// Se escribe el mensaje y se indica del tipo que es
			msg.setContent(multiParte);
			// Enviamos el email
			Transport.send(msg);
			logger.info("Email enviado con exito. IdElectrodo: "+el.getIdelectrodo());
			return 1;										
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("No se ha podido enviar correo. Motivo: "+e.getMessage(), e);
			return -1;
		}
	}
	
	/**
	 * Notificación de correo para nuevo cateter
	 * @param sol
	 */
	public int sendMailToAdminCat(Cateter cat, String centro, String user, int accion) {
		String smtp = null,port=null;
		try {
			smtp = p.getProperty("host");
			final String username = p.getProperty("username");
			final String password = Base64.decodeToString(p.getProperty("password"));
			final String to = p.getProperty("to");
			port = p.getProperty("port");
			// Dirección del host smtp
			Properties props = new Properties();
			props.put("mail.smtp.host", smtp);
						
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", port);
		
			// obtenemos una sesión por defecto con la dirección anterior
			Session session = Session.getDefaultInstance(props ,new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
			session.setDebug(false);

			ArrMaestrasDao mdao = new ArrMaestrasDaoImpl("correo");
			String fabricante = "";
			if(cat.getFabricante()!=null)
				fabricante = mdao.findByPrimaryKey(cat.getFabricante()).getValor();
			String codigos = this.obtenerGS128(cat.getCodigos());
			String accion_str = "";
			if(accion==1)
				accion_str = "Nueva insercion";
			else
				accion_str = "Actualizacion";
			
			String tipo = "";
			String curva = "";
			String energia = "";
			if(cat.getTipo()!=null){
				if(cat.getTipo().equals(1)){// DIAGNOSTICO
					if(cat.getTipodiagnostico()!=null){
						if(cat.getTipodiagnostico().equals(1))
							tipo = "Curva fija";
						else if(cat.getTipodiagnostico().equals(2))
							tipo = "Curva Deflectable";
						else if(cat.getTipodiagnostico().equals(3))
							tipo = "Circular";
						else if(cat.getTipodiagnostico().equals(4))
							tipo = "Mapeo";
					}
					if(cat.getTipocurva()!=null){
						if(cat.getTipocurva().equals(1))
							curva = "Josephson";
						else if(cat.getTipocurva().equals(2))
							curva = "Cournard";
						else if(cat.getTipocurva().equals(3))
							curva = "Preformada";
						else if(cat.getTipocurva().equals(4))
							curva = "Damato";
					}
				}else{//ABLACION
					if(cat.getTipoablacion()!=null){
						if(cat.getTipoablacion().equals(1))
							tipo = "4 mm";
						else if(cat.getTipoablacion().equals(2))
							tipo = "8 mm";
						else if(cat.getTipoablacion().equals(3))
							tipo = "Punta irrigada estandar";
						else if(cat.getTipoablacion().equals(4))
							tipo = "Crioablacion";
						else if(cat.getTipoablacion().equals(5))
							tipo = "Criobalon";
						else if(cat.getTipoablacion().equals(6))
							tipo = "Laser";
						else if(cat.getTipoablacion().equals(7))
							tipo = "10 mm";
						else if(cat.getTipoablacion().equals(8))
							tipo = "Otro";
						else if(cat.getTipoablacion().equals(9))
							tipo = "Irrigado de contacto";
						else if(cat.getTipoablacion().equals(10))
							tipo = "Circular RF fásica";
						else if(cat.getTipoablacion().equals(11))
							tipo = "Circular RF irrigada";
					}
					if(cat.getTipocurva()!=null){
						if(cat.getTipocurva().equals(1))
							curva = "Unidireccional";
						else if(cat.getTipocurva().equals(2))
							curva = "Bidireccional";
					}
					if(cat.getEnergia()!=null){
						if(cat.getEnergia().equals(1))
							energia = "RF";
						else if(cat.getEnergia().equals(2))
							energia = "Crioablacion";
						else if(cat.getEnergia().equals(3))
							energia = "Laser";
						else if(cat.getEnergia().equals(4))
							energia = "Ultrasonidos";
					}
				}
			}
			
			// Escribo el texto del mensaje
			BodyPart texto = new MimeBodyPart();
			String txt = "<html>" +
					"<head>" +
					"	<style>" +
					"		table {   " +
					"			border-collapse: collapse; " +
					"			width: 100%;" +
					"		}" +
					"		th, td {    " +
					"			text-align: left;    " +
					"			padding: 8px;" +
					"		}" +
					"		tr:nth-child(even){" +
					"			background-color: #f2f2f2" +
					"		}" +
					"		th {   " +
					"			background-color: #4CAF50;" +
					"		    color: white;" +
					"		}" +
					"	</style>" +
					"</head>" +
					"<body>" +
					"	<p><img src='cid:imagen1' style='width:56px;height:38px;'></p>"+
					"	<table>"+
					"		<tr>"+
					"			<th style='right: 0px;'>"+
					"				<h2>"+accion_str+" de material: Cateter</h2>" +
					"			</th>"+
					"		</tr>"+
					"	</table>"+
					"	<table> " +
					"		<tr>" +
					"			<th>Fecha creación</th>" +
					"			<th>Usuario</th>" +
					"			<th>Centro</th>" +
					"		</tr>" +
					"		<tr>" +
					"			<td>"+UtilFechas.getFechaStringFormato(new Date(), "dd MMM yyyy")+"</td>" +
					"			<td>"+(user!=null?user:"No especificado")+"</td>" +
					"			<td>"+(centro!=null?centro:"No especificado")+"</td>" +
					"		</tr>" +
					"	</table>" +
					"	<table>"+
					"		<tr>"+
					"			<th style='right: 0px;'>"+
					"				<h3>GS1-128</h3>" +
					"			</th>"+
					"		</tr>"+
					"		<tr>" +
					"			<td>"+(!codigos.equals("")?codigos:"No especificado")+"</td>" +
					"		</tr>" +
					"	</table>"+
					"	<table> " +
					"		<tr>" +
					"			<th>IdCateter</th>" +
					"			<th>Modelo</th>" +
					"			<th>Fabricante</th>" +
					"			<th>Referencia</th>" +
					"			<th>Tipo (Diagnostico/Ablacion)</th>" +
					"		</tr>" +
					"		<tr>" +
					"			<td>"+cat.getIdcateter()+"</td>" +
					"			<td>"+(cat.getModelo()!=null?cat.getModelo():"No especificado.")+"</td>" +
					"			<td>"+(!fabricante.equals("")?fabricante:"No especificado.")+"</td>" +
					"			<td>"+(cat.getReferencia()!=null?cat.getReferencia():"No especificado.")+"</td>" +
					"			<td>"+(cat.getTipo()!=null?(cat.getTipo().equals(1)?"Diagnostico":"Ablacion"):"No especificado")+"</td>" +
					"		</tr>" +
					"		<tr>" +
					"			<th>Num. electrodos</th>" +
					"			<th>Dist. electrodos</th>" +
					"			<th>Tamaño</th>" +
					"			<th>Longitud</th>" +
					"			<th>Tipo</th>" +
					"			<th>Curva</th>" +
					"		</tr>" +
					"		<tr>" +
					"			<td>"+(cat.getNumelecs()!=null?cat.getNumelecs():"No especificado")+"</td>" +
					"			<td>"+(cat.getDistanciaelecs()!=null?cat.getDistanciaelecs():"No especificado")+"</td>" +
					"			<td>"+(cat.getTamano()!=null?cat.getTamano()+" F.":"No especificado")+"</td>" +
					"			<td>"+(cat.getLongitud()!=null?cat.getLongitud()+" cm.":"No especificado")+"</td>" +
					"			<td>"+tipo+(cat.getTipo()!=null&&cat.getTipo().equals(2)?".(Energia: "+energia+")":"")+"</td>" +
					"			<td>"+curva+"</td>" +
					"		</tr>" +
					"	</table>" +
					"</body>" +
					"</html>";
			
			texto.setContent(txt,"text/html");
				
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			// Obtencion de las imagenes
			addCID("imagen1", "LogoIdea.png",multiParte);
			//addCID("imagen1", "C:/IDEA/ESTILOS/LogoIdeaLivaNova.png",multiParte);
				
			// Creamos un mensaje
			MimeMessage msg = new MimeMessage(session);

			// Se indica el remitente y el destinatario
			InternetAddress addressFrom = new InternetAddress("idea@omedit.com");
			msg.setFrom(addressFrom);
			msg.setSubject("Idea - Notificación de accion sobre material");
			
			msg.addRecipients(Message.RecipientType.TO, to);
			// Se configura el Asunto y la fecha de envío
			msg.setSentDate(new Date());
			// Se escribe el mensaje y se indica del tipo que es
			msg.setContent(multiParte);
			// Enviamos el email
			Transport.send(msg);
			logger.info("Email enviado con exito. IdCateter: "+cat.getIdcateter());
			return 1;										
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("No se ha podido enviar correo. Motivo: "+e.getMessage(), e);
			return -1;
		}
	}
	
	/**
	 * Notificación de correo para nuevo registrador de eventos
	 * @param sol
	 */
	public int sendMailToAdminRegEv(Registradoreventos reg, String centro, String user,int accion) {
		String smtp = null,port=null;
		try {
			smtp = p.getProperty("host");
			final String username = p.getProperty("username");
			final String password = Base64.decodeToString(p.getProperty("password"));
			final String to = p.getProperty("to");
			port = p.getProperty("port");
			// Dirección del host smtp
			Properties props = new Properties();
			props.put("mail.smtp.host", smtp);
						
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", port);
		
			// obtenemos una sesión por defecto con la dirección anterior
			Session session = Session.getDefaultInstance(props ,new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });
			session.setDebug(false);

			String codigos = this.obtenerGS128(reg.getCodigos());
			String accion_str = "";
			if(accion==1)
				accion_str = "Nueva insercion";
			else
				accion_str = "Actualizacion";
			
			// Escribo el texto del mensaje
			BodyPart texto = new MimeBodyPart();
			String txt = "<html>" +
				"<head>" +
				"	<style>" +
				"		table {   " +
				"			border-collapse: collapse; " +
				"			width: 100%;" +
				"		}" +
				"		th, td {    " +
				"			text-align: left;    " +
				"			padding: 8px;" +
				"		}" +
				"		tr:nth-child(even){" +
				"			background-color: #f2f2f2" +
				"		}" +
				"		th {   " +
				"			background-color: #4CAF50;" +
				"		    color: white;" +
				"		}" +
				"	</style>" +
				"</head>" +
				"<body>" +
				"	<p><img src='cid:imagen1' style='width:56px;height:38px;'></p>"+
				"	<table>"+
				"		<tr>"+
				"			<th style='right: 0px;'>"+
				"				<h2>"+accion_str+" de material: Registrador de Eventos</h2>" +
				"			</th>"+
				"		</tr>"+
				"	</table>"+
				"	<table> " +
				"		<tr>" +
				"			<th>Fecha creación</th>" +
				"			<th>Usuario</th>" +
				"			<th>Centro</th>" +
				"		</tr>" +
				"		<tr>" +
				"			<td>"+UtilFechas.getFechaStringFormato(new Date(), "dd MMM yyyy")+"</td>" +
				"			<td>"+(user!=null?user:"No especificado")+"</td>" +
				"			<td>"+(centro!=null?centro:"No especificado")+"</td>" +
				"		</tr>" +
				"	</table>" +
				"	<table>"+
				"		<tr>"+
				"			<th style='right: 0px;'>"+
				"				<h3>GS1-128</h3>" +
				"			</th>"+
				"		</tr>"+
				"		<tr>" +
				"			<td>"+(!codigos.equals("")?codigos:"No especificado")+"</td>" +
				"		</tr>" +
				"	</table>"+
				"	<table> " +
				"		<tr>" +
				"			<th>IdGenerador</th>" +
				"			<th>Modelo</th>" +
				"			<th>Fabricante</th>" +
				"			<th>Referencia</th>" +
				"			<th>RF</th>" +
				"			<th>MRI</th>" +
				"		</tr>" +
				"		<tr>" +
				"			<td>"+reg.getIdregistrador()+"</td>" +
				"			<td>"+(reg.getModelo()!=null?reg.getModelo():"No especificado.")+"</td>" +
				"			<td>"+(reg.getFabricante()!=null?reg.getFabricante():"No especificado.")+"</td>" +
				"			<td>"+(reg.getReferencia()!=null?reg.getReferencia():"No especificado.")+"</td>" +
				"			<td>"+(reg.getRf()!=null?(reg.getRf().equals(1)?"Si":"No"):"")+"</td>" +
				"			<td>"+(reg.getMri()!=null?(reg.getMri().equals(1)?"Si":"No"):"")+"</td>" +
				"		</tr>" +				
				"	</table>" +
				"</body>" +
				"</html>";
						
			texto.setContent(txt,"text/html");
				
			MimeMultipart multiParte = new MimeMultipart();
			multiParte.addBodyPart(texto);
			// Obtencion de las imagenes
			addCID("imagen1", "LogoIdea.png",multiParte);
			//addCID("imagen1", "C:/IDEA/ESTILOS/LogoIdeaLivaNova.png",multiParte);
				
			// Creamos un mensaje
			MimeMessage msg = new MimeMessage(session);

			// Se indica el remitente y el destinatario
			InternetAddress addressFrom = new InternetAddress("idea@omedit.com");
			msg.setFrom(addressFrom);
			msg.setSubject("Idea - Notificación de accion sobre material");
			
			msg.addRecipients(Message.RecipientType.TO, to);
			// Se configura el Asunto y la fecha de envío
			msg.setSentDate(new Date());
			// Se escribe el mensaje y se indica del tipo que es
			msg.setContent(multiParte);
			// Enviamos el email
			Transport.send(msg);
			logger.info("Email enviado con exito. IdRegistrador: "+reg.getIdregistrador());
			return 1;										
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("No se ha podido enviar correo. Motivo: "+e.getMessage(), e);
			return -1;
		}
	}
	
	public static void addCID(String cidname,String pathname, MimeMultipart multipart) throws Exception{
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath=(String) servletContext.getRealPath("//img/genericos/"+pathname); // Sustituye "/" por el directorio ej: "/upload"
		DataSource fds = new FileDataSource(realPath);
		//DataSource fds = new FileDataSource(pathname);
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setDataHandler(new DataHandler(fds));
		messageBodyPart.setHeader("Content-ID","<"+cidname+">");
		multipart.addBodyPart(messageBodyPart);
	}
	
	public String obtenerGS128(ArrayList<Codigosgs128> lista){
		String res = "";
		for(Codigosgs128 c:lista)
			res +=c.getCodigo()+", ";
		if(!res.equals(""))
			res = res.substring(0, res.length()-2);
		return res;
	}
	
	private static void inicia(){
		try {
			p = new Properties();
			InputStream is = GestorCorreo.class.getResourceAsStream("mail.properties");
			p.load(is);
			is.close(); 
		} catch (IOException e) {
			logger.error("ERROR en lectura properties: mail.properties",e);
		} 
	}
}

<%@page import="es.andaluciajunta.cjap.autenticacion.*"%>
<%@ page import="java.util.Hashtable" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<html>
	<head>
		<title>Modulo de Autenticación Web @Firma 5 - Componente de retorno Cliente</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<meta http-equiv="pragma" content="no-cache"/>
		<meta http-equiv="cache-control" content="no-cache"/>
	</head>
	<body>
<%
	CertificateUser usuario = (CertificateUser)session.getAttribute("usuario");
String errorComp = (String)session.getAttribute("errorComp");
%>
	<h1 align="center">Informaci&oacute;n de validaci&oacute;n Objeto CertificateUser</h1>
	<br/>
	<%if ((errorComp!=null)&&(!errorComp.equals(""))) {%>
	<%= errorComp %>
	<%}else{ %>
	Los datos obtenidos del firmante son la la la:
	
	String NIF  : <%= usuario.getNIF() %><br/>
	String email :<%= usuario.getEmail() %><br/>
	String apellido1 :<%= usuario.getApellido1() %><br/>
	String apellido2 :<%= usuario.getApellido2()%><br/>
	String anagramaFiscal :<%= usuario.getAnagramaFiscal()%><br/>
	String nombre :<%= usuario.getNombre()%><br/>
	Date f_creacion :<%= usuario.getFechaCreacion()%><br/>
	Date f_caducidad :<%= usuario.getFechaCaducidad()%><br/>
	Date validoDesde :<%= usuario.getValidoDesde()%><br/>
	Date validoHasta :<%= usuario.getValidoHasta()%><br/>
	String tipoCertificado :<%= usuario.getTipoCertificado()%><br/>
	String usoCertificado= :<%= usuario.getUsoCertificado()%><br/>
	String apellidosResponsable= :<%= usuario.getApellidosResponsable()%><br/>
	String politica= :<%= usuario.getPolitica()%><br/>
	String subject= :<%= usuario.getSubject()%><br/>
	String versionPolitica= :<%= usuario.getVersionPolitica()%><br/>
	String organizacionEmisora= :<%= usuario.getOrganizacionEmisora()%><br/>
	String idPolitica= :<%= usuario.getIdPolitica()%><br/>
	String numSerie= :<%= usuario.getNumSerie()%><br/>
	String clasificacion= :<%= usuario.getClasificacion()%><br/>
	String tipoAfirma= :<%= usuario.getTipoAfirma()%><br/>
	<%} %>
	<br/><br/>
	<h1 align="center">Informaci&oacute;n de validaci&oacute;n Objeto Map</h1>
	<br/>
	<% Map userMap = (Map)session.getAttribute("userMap");
		String objetoMap = UtilidadesAutFachada.printValInfo(userMap);
	%>

	<%=objetoMap%>


	</body>
</html>
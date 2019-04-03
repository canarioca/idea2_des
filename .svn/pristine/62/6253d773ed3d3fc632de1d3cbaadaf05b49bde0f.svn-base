<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jp="http://www.jenia.org/jsf/popup"
	xmlns:jsflot="http://www.jsflot.org/taglib/jsflot">
<f:view locale="#{selectorIdioma.localeCode }">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta http-equiv="refresh" content="#{session.maxInactiveInterval};url=/idea/faces/timeout.jsp" />
<link rel="shortcut icon"
	href="/idea/img/aplicacion/idea.ico" />
<link href="/idea/css/iniciocss.css"
	rel="stylesheet" type="text/css" />
<link type="text/css" rel="stylesheet"
	href="/idea/css/redmond/redmond.css" />
<script language="JavaScript" type="text/javascript" src="/idea/js/jsinicio.js"/>
<script src="/idea/js/dw_event.js" type="text/javascript"/>
<script src="/idea/js/dw_cookies.js" type="text/javascript"/>
<script src="/idea/js/dw_sizerdx.js" type="text/javascript"/>
<script type="text/javascript">
	dw_fontSizerDX.setDefaults("px", 11, 9, 26, [ 'body', 'td', 'div', 'p',
			'font', 'a', 'label', 'tr', 'a', 'input' ]);
	dw_Event.add(window, 'load', dw_fontSizerDX.init);
</script>
<script type="text/javascript" src="/idea/js/keyboard.js" charset="UTF-8"/>
<link rel="stylesheet" type="text/css" href="/idea/css/keyboard.css"/>
<link rel="stylesheet" type="text/css" href="/idea/css/timeline.css"/>
<f:loadBundle var="ms" basename="com.sorin.idea.iu.labels"/>
<title>#{ms.titulo}</title>
<jsflot:resources />

</head>
<body>
<img id="bg" src="/idea/img/aplicacion/CirculosSorin.png" alt="Fondo" />
<rich:modalPanel id="buscando" minHeight="80" minWidth="150"
	height="80" width="150" zindex="2000">
	<f:facet name="header">
		<h:panelGrid border="0">
			<h:outputText value="Procesando peticion"
				style="font-weight:bold;color: white;" />
		</h:panelGrid>
	</f:facet>
	<h:panelGrid columns="2" style="border:0;">
		<h:graphicImage url="/img/aplicacion/ajax-loader.gif" width="10"
			height="10" />
		<h:outputText value="Por favor, espere ..." styleClass="hvn_estatus" />
	</h:panelGrid>
</rich:modalPanel>
<table width="100%" align="center" style="top: 0;" border="0"
	cellspacing="0" cellpadding="0">
	<tr>
		<td>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0" class="fondoAzul">
			<tr>
				<td valign="top">
				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr height="59">
						<td>
						<table border="0" width="309px" class="fondoAzul"
							cellspacing="0" cellpadding="0">
							<tr height="59">
								<td class="logoArriba"></td>
								<!--<td class="nombreLogoArriba"></td>-->
							</tr>
						</table>
						</td>
						<td>
						<table border="0" height="70" width="100%" class="fondoAzul"
							cellspacing="0" cellpadding="0">
							<tr height="70">
								<td class="fondoAzul"></td>
							</tr>
						</table>
						</td>
						<td>
						<table border="0" width="400px" class="fondoAzul"
							cellspacing="0" cellpadding="0" align="right">
							<tr height="70">
								<td class="logoDerecha"><img class="logoCentro" align="right" src="/idea/img/genericos/LogoCentro.png" width="140" height="59"/></td>
							</tr>
						</table>
						</td>
					</tr>
					<tr>
						<table border="0" width="100%" cellspacing="0" cellpadding="0"
							bgcolor="#FFFFFF" >
							
								<table align="center" width="100%" border="0" cellspacing="0"
									cellpadding="0" bgcolor="#FFFFFF">
									<tr>
										<td width="20"><a class="reset" href="#{ms.regincidencias}" target="_blank"
											title="Registro de incidencias">
											<img src="/idea/img/iconos/incidencias.png"
												width="16" height="16" alt="Registro de incidencias" border="0" style="margin-left:5px;"/>
										</a></td>
										<td width="20"><a class="reset" href="#{ms.urlayuda}" target="_blank"
											title="Ayuda online">
											<img src="/idea/img/iconos/helpbook.png"
												width="16" height="16" alt="Ayuda online" border="0" style="margin-left:5px;"/>
										</a></td>
										<td width="23"><img
											src="/idea/img/genericos/time.png"
											width="16" height="16" style="margin-left:3px;"/></td>
										<td><ui:include src="/pl/inc/hora.jsp" /></td>
										<td align="right">
										<table width="80" border="0" cellspacing="0" cellpadding="0"
											bgcolor="#FFFFFF">
											<tr>
												<td width="20"><img
													src="/idea/img/genericos/zoom.png"
													width="20px" height="20px" alt="#{ms.pl_zoom }" border="0" /></td>
												<td width="20" id="sizer"><a href="#" class="increase"
													title="#{ms.pl_aumentar }"
													onclick="dw_fontSizerDX.adjust(dw_fontSizerDX.sizeIncrement);">
												<img
													src="/idea/img/genericos/ico_letra_agrandar.gif"
													width="20px" height="20" alt="#{ms.pl_aumentar }" border="0" />
												</a></td>
												<td width="20" id="sizerd"><a href="#" class="decrease"
													title="#{ms.pl_disminuir }"
													onclick="dw_fontSizerDX.adjust(-dw_fontSizerDX.sizeIncrement);">
												<img
													src="/idea/img/genericos/ico_letra_achicar.gif"
													width="20px" height="20" alt="#{ms.pl_disminuir }" border="0" />
												</a></td>
												<td width="20"><a class="reset" href="#"
				 									title="#{ms.pl_restaurar }" onclick="dw_fontSizerDX.reset();">
												<img src="/idea/img/genericos/ico_letra.gif"
													width="20px" height="20" alt="#{ms.pl_restaurar }" border="0" style="margin-left:5px;"/>
												</a></td>
												<td>
													<ui:include src="/pl/inc/idioma.jsp" />
												</td>
											</tr>
										</table>
										</td>
									</tr>
								</table>
							
						</table>
					</tr>
					<tr>
						<table border="0" class="center input100" cellspacing="0"
							cellpadding="0" bgcolor="#B9C3CC">
							<tr height="30" valign="middle">
								<td class="left">
								<h3>#{ms.titulo}</h3>
								</td>
								<td class="right">
								<!-- <img src="/idea/img/aplicacion/logo.png"
									alt="Unidad de arritmias" border="0" />-->
								<h3>#{ms.unidad }</h3>
								</td>
							</tr>
						</table>
					</tr>
					<tr>
						<td valign="top" class="main-panel-grid">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="15%" valign="top"><ui:include
									src="/pl/inc/menuv-test.jsp" /></td>
								<td width="3%"></td>
								<td valign="top" width="80%">
								<ui:include src="/pl/inc/cabecera-test.jsp" />
								<ui:insert name="contenido" />
								<rich:spacer height="50px"/></td>
							</tr>
							<tr class="main-pie">
								<td valign="bottom" class="main-pie" colspan="3">
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td width="100%" valign="bottom">
											
										</td>
									</tr>
								</table>
								</td>
							</tr>
						</table>
						</td>
					</tr>

				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</f:view>
</html>

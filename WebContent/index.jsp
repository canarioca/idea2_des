<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plIndex.jsp">
	<style>
.col20 {
	width: 20%;
	vertical-align: top;
}

.col80 {
	width: 80%;
	vertical-align: top;
}
</style>
	<ui:define name="contenido">
		<h:form id="indiceForm" 
			style="margin-top: 5px;" binding="#{loginForm.formulario}">

			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="100%">
				<rich:messages showDetail="true" showSummary="false"
					errorClass="hvn_msjError" warnClass="hvn_msjAviso" infoClass="hvn_msjInfo"/>
				<rich:panel id="panelLogin" 
					style="width: 500px;">
					<f:facet name="header">
						<h:outputText value="#{ms.login_saludo }"/>
					</f:facet>
				
					<h:panelGrid columns="2">
						<f:attribute name="align" value="center" />
						<h:outputLabel for="Usuario" value="#{ms.login_usuario }" />
						<h:inputText id="Usuario"
							requiredMessage="#{ms.login_usuario_msg }" size="40"
							maxlength="20" styleClass="keyboardInput"
							style="border: 1px solid #444444;color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;"
							required="true" value="#{loginForm.login}" />
						<h:outputLabel for="pass" value="#{ms.login_pw }" />
						<h:inputSecret id="pass" value="#{loginForm.pass }" size="40"
							styleClass="keyboardInput"
							required="true"
							requiredMessage="#{ms.login_pw_msg }"
							style="border: 1px solid #444444;color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;"/>
						
					</h:panelGrid>
					<h:outputText value="#{ms.login_msg_1 }"/>
					<h:panelGrid columns="2" align="center">
						
						<h:commandButton immediate="false" id="botonLogin" value="#{ms.acceder }"
							styleClass="boton" title="#{ms.acceder }"
							action="#{loginForm.acnAutenticarUsuario}"
							onclick="javascript:Richfaces.showModalPanel('acceso')"/>
						<h:commandButton id="idBotonLimpia" title="#{ms.limpiar }"
							action="#{loginForm.acnLimpiarCampos}" value="#{ms.limpiar }"
							styleClass="boton" />
					</h:panelGrid>
				</rich:panel>
				
			</h:panelGrid>
			
			
			
			
			<rich:modalPanel id="acceso" minHeight="80" minWidth="150"
				height="80" width="150" zindex="2000">
				<f:facet name="header">
					<h:panelGrid border="0">
						<h:outputText value="#{ms.login_acceso_msg_title }" styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<h:panelGrid columns="2" style="border:0;">
					<h:graphicImage url="/img/aplicacion/ajax-loader.gif" width="10"
						height="10" />
					<h:outputText value="#{ms.login_acceso_msg }" styleClass="hvn_estatus" />
				</h:panelGrid>
			</rich:modalPanel>

			<script type="text/javascript">
				document.getElementById('indiceForm:Usuario').focus();
			</script>
		</h:form>
	</ui:define>

</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="inicio">
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="90%"
				style="margin-top: 15px;"
				id="panNuevoPedido">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo" warnClass="hvn_msjAviso"/>
				<rich:panel style="background-color: #ffffff;
                 	 background-image:url(/cardioarritmiasMS/img/iconos/users.png);
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="Título" style="color: white;"/>
							<h:panelGrid columns="2" columnClasses="right">
								<a4j:commandLink style="text-align: right;" reRender="panNuevoPedido">
									<h:graphicImage url="/img/iconos/new.png" style="border:0px;"/>
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panNuevoPedido">
									<h:graphicImage url="/img/iconos/save.png" style="border:0px;"/>
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
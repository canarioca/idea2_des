<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:r="http://richfaces.org/rich"
	xmlns:s="http://myfaces.apache.org/sandbox" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="formIntegraciones">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelIntegraciones">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel style="background-color: #ffffff;
                 	 background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.integra_reg_title }" style="color: white;" />
							<h:panelGrid columns="1" columnClasses="right">	
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>				
					<rich:tabPanel switchType="client" >
						<rich:tab label="#{ms.integra_reg_solicitudes }">
							<a4j:include viewId="solicitudes.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.integra_reg_registros }">
							<rich:tabPanel switchType="client" >
								<rich:tab label="#{ms.integra_reg_registros_idea }">
									<a4j:include viewId="logs_integracion.jsp" />
								</rich:tab>	
								<rich:tab label="#{ms.integra_reg_registros_integr }">
									<a4j:include viewId="logs_integrador.jsp" />
								</rich:tab>
							</rich:tabPanel>
						</rich:tab>
											
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
			
			<rich:modalPanel id="sugerenciasGenerador" autosized="true" zindex="2000" minWidth="550">
				<f:facet name="header">
					<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
						<h:outputText value="Generadores sugeridos en el sistema"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>						
						<a4j:commandLink 
							onclick="javascript:Richfaces.hideModalPanel('sugerenciasGenerador');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;"
								onclick="javascript:Richfaces.hideModalPanel('sugerenciasGenerador')"
								title="#{ms.cancelar }" />
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid id="sugerenciasGeneradorPanel" width="100%">
					<h:outputLabel value="Hola: #{controlIntegracion.currentItemGenerador.imp.modelog }"/>
				</h:panelGrid>
			</rich:modalPanel>
			
			<rich:modalPanel id="sugerenciasElectrodo" autosized="true" zindex="2000" minWidth="550">
				<f:facet name="header">
					<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
						<h:outputText value="Electrodos sugeridos en el sistema"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>						
						<a4j:commandLink 
							onclick="javascript:Richfaces.hideModalPanel('sugerenciasElectrodo');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;"
								onclick="javascript:Richfaces.hideModalPanel('sugerenciasElectrodo')"
								title="#{ms.cancelar }" />
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid id="sugerenciasElectrodoPanel" width="100%">
					<h:outputLabel value="AMOOOOOOO"/>
				</h:panelGrid>
			</rich:modalPanel>
			
		</h:form>
	</ui:define>
</ui:composition>
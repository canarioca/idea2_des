<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel>
					<f:facet name="header">
						<h:panelGrid width="100%" cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.export_datos_filtros_title }" style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:outputText value="#{ms.export_datos_msg_1 }"/>
					<rich:tabPanel switchType="client" width="100%" height="500px">
						<rich:tab label="#{ms.export_datos_tab_eef_title }" rendered="#{controlPacientes.booleanEEF == true}">
							<a4j:include viewId="consultas/eef.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.export_datos_tab_imp_title }" 
							   rendered="#{controlPacientes.booleanPrimoImplante == true or 
						             controlPacientes.booleanReintervencion == true or 
						             controlPacientes.booleanRecambioDispositivo == true or 
						             controlPacientes.booleanUpgradeDispositivo == true or 
						             controlPacientes.booleanRecolocacionGenerador == true or 
						             controlPacientes.booleanRecolocacionElectrodo == true or 
				             		 controlPacientes.booleanReimplante == true}">
							<a4j:include viewId="consultas/implantes.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.export_datos_tab_cve_title }" rendered="#{controlPacientes.booleanCardioversiónElectrica == true}">
							<a4j:include viewId="consultas/cv.jsp"/>
						</rich:tab>
						<rich:tab label="Desfibriladores" rendered="false">
							<a4j:include viewId="consultas/dai.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.export_datos_tab_mesa_title }" rendered="#{controlPacientes.booleanMesa == true}">
							<a4j:include viewId="consultas/mesabasculante.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.export_datos_tab_test_title }" rendered="#{controlPacientes.booleanTestOrto == true}">
							<a4j:include viewId="consultas/test.jsp"/>
						</rich:tab>						
						<rich:tab label="#{ms.export_datos_tab_regev_title }" rendered="#{controlPacientes.booleanRegistradorEventos == true}">
							<a4j:include viewId="consultas/registrador.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.export_datos_tab_hol24_title }" rendered="#{controlPacientes.booleanHolter == true}">
							<a4j:include viewId="consultas/holter.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.export_datos_tab_elr_title }" rendered="#{controlPacientes.booleanRecolocacionElectrodo == true}">
							<a4j:include viewId="consultas/regevext.jsp"/>
						</rich:tab>
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
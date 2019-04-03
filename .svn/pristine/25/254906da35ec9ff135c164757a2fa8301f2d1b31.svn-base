<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox"
	xmlns:p="http://primefaces.prime.com.tr/ui" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="iniciohistoenf">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" cellpadding="0"
							cellspacing="0" columnClasses="left,right">
							<h:outputLabel value="Histórico de registros de enfermería"
								style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="40%" id="panelEnfs">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlTest.bindingEnf}"
							id="tablaEnf" preserveDataModel="true" preserveSort="true"
							value="#{controlTest.enfs}">
							<t:column>
								<f:facet name="header">
									<h:outputText value="Número de estudio" />
								</f:facet>
								<a4j:commandLink title="Número de estudio #{linea.neef}" 
									action="irEnf" value="#{linea.neef}"
									actionListener="#{controlTest.cargaEnf}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<t:column>
								<f:facet name="header">
									<h:outputText value="Fecha" />
								</f:facet>
								<a4j:commandLink title="#{linea.fechastr}" 
									action="irEnf" value="#{linea.fechastr}"
									actionListener="#{controlTest.cargaEnf}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaEnf" id="scrollEnf"
									renderIfSinglePage="false" fastStep="4" stepControls="auto"
									boundaryControls="auto" fastControls="auto" />
							</f:facet>
						</t:dataTable>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
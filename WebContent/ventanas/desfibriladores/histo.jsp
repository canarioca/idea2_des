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
		<h:form id="inicio">
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
							<h:outputLabel value="Hist�rico de desfibriladores"
								style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" id="panelDesfibriladores">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlDesfibriladores.bindingHistorico}"
							id="tablaDesfibriladores" preserveDataModel="true" preserveSort="true"
							sortColumn="#{controlDesfibriladores.columna }"
							sortAscending="#{controlDesfibriladores.ascendente }"
							value="#{controlDesfibriladores.desfs}">
							<t:column width="15%" id="codigo">
								<f:facet name="header">
									<t:commandSortHeader columnName="codigo" arrow="true">
										<h:outputText value="C�digo" />
									</t:commandSortHeader>
								</f:facet>
								<a4j:commandLink title="C�digo de desfibrilador: #{linea.ndai}" 
									action="irDesfibriladores" value="#{linea.ndai}"
									actionListener="#{controlDesfibriladores.cargaDesfibrilador}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<t:column width="85%" id="fecha">
								<f:facet name="header">
									<t:commandSortHeader columnName="fecha" arrow="true">
										<h:outputText value="Fecha" />
									</t:commandSortHeader>
								</f:facet>
								<a4j:commandLink title="Fecha de desfibrilador: #{linea.fechaStr}" 
									action="irDesfibriladores" value="#{linea.fechaStr}"
									actionListener="#{controlDesfibriladores.cargaDesfibrilador}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaDesfibriladores" id="scrollDesfibriladores"
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
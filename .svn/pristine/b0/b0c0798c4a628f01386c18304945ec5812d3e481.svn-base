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
							<h:outputLabel value="Histórico de cardioversión eléctrica externa electiva"
								style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" id="panelCardioversiones">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlCardioversion.bindingHistorico}"
							id="tablaCardioversiones" preserveDataModel="true" preserveSort="true"
							sortColumn="#{controlCardioversion.columna }"
							sortAscending="#{controlCardioversion.ascendente }"
							value="#{controlCardioversion.cvs}">
							<t:column width="15%" id="codigo">
								<f:facet name="header">
									<t:commandSortHeader columnName="codigo" arrow="true">
										<h:outputText value="Código" />
									</t:commandSortHeader>
								</f:facet>
								<a4j:commandLink title="Código de cardioversión: #{linea.ncv}" 
									action="irCardioversion" value="#{linea.ncv}"
									actionListener="#{controlCardioversion.cargaCardioversion}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<t:column width="85%" id="fecha">
								<f:facet name="header">
									<t:commandSortHeader columnName="fecha" arrow="true">
										<h:outputText value="Fecha" />
									</t:commandSortHeader>
								</f:facet>
								<a4j:commandLink title="Fecha de cardioversión: #{linea.fechaStr}" 
									action="irCardioversion" value="#{linea.fechaStr}"
									actionListener="#{controlCardioversion.cargaCardioversion}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaCardioversiones" id="scrollCardioversiones"
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
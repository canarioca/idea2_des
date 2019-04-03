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
		<h:form id="iniciohistoeef">
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
							<h:outputLabel value="Histórico de estudios"
								style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" id="panelEEFs">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlEef.bindingBuscar}"
							id="tablaEEF" preserveDataModel="true" preserveSort="true"
							sortColumn="#{controlEef.columna }"
							sortAscending="#{controlEef.ascendente }"
							value="#{controlEef.eefs}">
							<t:column width="15%" id="codigoheef">
								<f:facet name="header">
									<t:commandSortHeader columnName="codigo" arrow="true">
										<h:outputText value="Código" />
									</t:commandSortHeader>
								</f:facet>
								<a4j:commandLink title="Código de estudio: #{linea.nestudio}" 
									action="irEef" value="#{linea.nestudio}"
									actionListener="#{controlEef.cargaEstudio}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<t:column width="20%" id="fechaheef">
								<f:facet name="header">
									<t:commandSortHeader columnName="fecha" arrow="true">
										<h:outputText value="Fecha" />
									</t:commandSortHeader>
								</f:facet>
								<a4j:commandLink title="Fecha de estudio: #{linea.fechastr}" 
									action="irEef" value="#{linea.fechastr}"
									actionListener="#{controlEef.cargaEstudio}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<t:column width="60%" id="diagheef">
								<f:facet name="header">
									<h:outputText value="Diagnóstico" />
								</f:facet>
								<h:selectOneMenu value="#{linea.diagnostico }" disabled="true" 
									readonly="true">
									<f:selectItems value="#{controlEef.diagnosticos }"/>
								</h:selectOneMenu>
							</t:column>
							<t:column>
								<a4j:commandLink title="Eliminar estudio" 
									reRender="tablaEEF"
									actionListener="#{controlEef.eliminaEstudio}"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									onclick="if (!confirm('Atención: va a eliminar un estudio, ¿desea continuar?')) return false;javascript:Richfaces.showModalPanel('buscando');">
									<h:graphicImage style="border: 0px;" value="/img/aplicacion/icoCancelar.png"
										width="16" height="16"/>
								</a4j:commandLink>
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaEEF" id="scrollDesfibriladores"
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
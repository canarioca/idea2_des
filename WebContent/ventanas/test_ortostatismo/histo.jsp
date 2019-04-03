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
		<h:form id="inicioHistTestOrto">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%" style="margin-top: 15px;">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo" warnClass="hvn_msjAviso" />
				<rich:panel style="background-color: #ffffff; background-repeat: no-repeat; background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" cellpadding="0"
							cellspacing="0" columnClasses="left,right">
							<h:outputLabel value="#{ms.test_orto_histo_title }" style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="40%" id="paneHistTestOrto">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlTestOrtostatismo.bindingBuscar}"
							id="tablaHistTestOrto" preserveDataModel="true" preserveSort="true"
							sortColumn="#{controlTestOrtostatismo.columna }"
							sortAscending="#{controlTestOrtostatismo.ascendente }"
							value="#{controlTestOrtostatismo.lista}">
							<t:column width="15%">
								<a4j:commandLink action="irTestOrto" 
									actionListener="#{controlTestOrtostatismo.cargaTestOrto}" 
									onclick="javascript:Richfaces.showModalPanel('buscando');" >
									<h:graphicImage url="/img/iconos/bpm.png" style="border:0px;"
											width="22" height="22" />
								</a4j:commandLink>
							</t:column>
							<t:column width="85%" id="fecha"> 
								<f:facet name="header">
									<t:commandSortHeader columnName="fecha" arrow="true">
										<h:outputText value="#{ms.test_orto_histo_fecha_msg_2 }" />
									</t:commandSortHeader>
								</f:facet>
								<a4j:commandLink title="#{ms.test_orto_histo_fecha_msg_2 }: #{linea.fecha}" 
									action="irTestOrto" value="#{linea.fecha}"
									actionListener="#{controlTestOrtostatismo.cargaTestOrto}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaHistTestOrto" id="scrollHistTestOrto"
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
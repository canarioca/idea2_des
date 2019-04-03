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
		<h:form id="inicioHistSegClin">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" cellpadding="0"
							cellspacing="0" columnClasses="left,right">
							<h:outputLabel value="#{ms.segclin_histo_title }"
								style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="40%" id="paneHistSegClin">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlSeguimientosClinicos.bindingBuscar}"
							id="tablaHistSegClin" preserveDataModel="true" preserveSort="true"
							sortColumn="#{controlSeguimientosClinicos.columna }"
							sortAscending="#{controlSeguimientosClinicos.ascendente }"
							value="#{controlSeguimientosClinicos.listaseg}">
							<t:column width="15%">
								<a4j:commandLink action="irSeguimientosClinicos" 
									actionListener="#{controlSeguimientosClinicos.cargaSegClin}" 
									onclick="javascript:Richfaces.showModalPanel('buscando');" >
									<h:graphicImage url="/img/iconos/BandAid.png" style="border:0px;"
											width="22" height="22" />
								</a4j:commandLink>
							</t:column>
							<t:column width="85%" id="fecha"> 
								<f:facet name="header">
									<t:commandSortHeader columnName="fecha" arrow="true">
										<h:outputText value="#{ms.segclin_histo_fecha_msg_1 }" />
									</t:commandSortHeader>
								</f:facet>
								<a4j:commandLink title="#{ms.segclin_histo_fecha_msg_2 }: #{linea.fecha}" 
									action="irSeguimientosClinicos" value="#{linea.fecha}"
									actionListener="#{controlSeguimientosClinicos.cargaSegClin}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<t:column width="85%" id="tiposegclinhist"> 
								<f:facet name="header">
								</f:facet>
								<h:selectOneMenu value="#{linea.tiposeg }" disabled="true">
									<f:selectItems value="#{controlSeguimientosClinicos.tiposeg}" />							
								</h:selectOneMenu>
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaHistSegClin" id="scrollHistSegClin"
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
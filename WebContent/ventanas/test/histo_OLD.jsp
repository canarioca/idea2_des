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
		<h:form id="iniciohistotest">
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
							<h:outputLabel value="Histórico de test"
								style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" id="panelTests" columns="3" 
						columnClasses="alignTop33,alignTop33,alignTop33">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlTest.bindingATP}"
							id="tablaATP" preserveDataModel="true" preserveSort="true"
							value="#{controlTest.atps}">
							<t:column>
								<f:facet name="header">
									<h:outputText value="Fecha test ATP" />
								</f:facet>
								<a4j:commandLink title="#{linea.fechastr}" 
									action="irATP" value="#{linea.fechastr}"
									actionListener="#{controlTest.cargaATP}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaATP" id="scrollATP"
									renderIfSinglePage="false" fastStep="4" stepControls="auto"
									boundaryControls="auto" fastControls="auto" />
							</f:facet>
							<t:column>
								<a4j:commandLink title="Eliminar test" 
									reRender="panelTests"
									actionListener="#{controlTest.eliminaATP}"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									onclick="if (!confirm('Atención: va a eliminar un test, ¿desea continuar?')) return false;javascript:Richfaces.showModalPanel('buscando');">
									<h:graphicImage style="border: 0px;" value="/img/aplicacion/icoCancelar.png"
										width="16" height="16"/>
								</a4j:commandLink>
							</t:column>
						</t:dataTable>
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlTest.bindingEpi}"
							id="tablaEpi" preserveDataModel="true" preserveSort="true"
							value="#{controlTest.epis}">
							<t:column>
								<f:facet name="header">
									<h:outputText value="Fecha test Epinefrina" />
								</f:facet>
								<a4j:commandLink title="#{linea.fechastr}" 
									action="irEpi" value="#{linea.fechastr}"
									actionListener="#{controlTest.cargaEpi}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<t:column>
								<a4j:commandLink title="Eliminar test" 
									reRender="panelTests"
									actionListener="#{controlTest.eliminaEpi}"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									onclick="if (!confirm('Atención: va a eliminar un test, ¿desea continuar?')) return false;javascript:Richfaces.showModalPanel('buscando');">
									<h:graphicImage style="border: 0px;" value="/img/aplicacion/icoCancelar.png"
										width="16" height="16"/>
								</a4j:commandLink>
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaEpi" id="scrollEpi"
									renderIfSinglePage="false" fastStep="4" stepControls="auto"
									boundaryControls="auto" fastControls="auto" />
							</f:facet>
						</t:dataTable>
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlTest.bindingFle}"
							id="tablaFle" preserveDataModel="true" preserveSort="true"
							value="#{controlTest.fles}">
							<t:column>
								<f:facet name="header">
									<h:outputText value="Fecha test Flecainida" />
								</f:facet>
								<a4j:commandLink title="#{linea.fechastr}" 
									action="irFle" value="#{linea.fechastr}"
									actionListener="#{controlTest.cargaFle}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>
							<t:column>
								<a4j:commandLink title="Eliminar test" 
									reRender="panelTests"
									actionListener="#{controlTest.eliminaFle}"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									onclick="if (!confirm('Atención: va a eliminar un test, ¿desea continuar?')) return false;javascript:Richfaces.showModalPanel('buscando');">
									<h:graphicImage style="border: 0px;" value="/img/aplicacion/icoCancelar.png"
										width="16" height="16"/>
								</a4j:commandLink>
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaFle" id="scrollFle"
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
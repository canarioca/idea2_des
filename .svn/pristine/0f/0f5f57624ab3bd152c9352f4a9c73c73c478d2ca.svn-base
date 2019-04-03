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
		<h:form id="iniciohistoRegEvExt">
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
							<h:outputLabel value="#{ms.elr_histo_title }" style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" id="panelRegEvExts">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlRegEvExt.bindingBuscar}"
							id="tablaRegEvExt" preserveDataModel="true" preserveSort="true"
							sortColumn="#{controlRegEvExt.columna }"
							sortAscending="#{controlRegEvExt.ascendente }"
							value="#{controlRegEvExt.procs}">
							<t:column>
								<h:graphicImage style="border: 0px;" value="/img/iconos/regevext.png" width="24" height="24"/>
							</t:column>				
							<t:column id="fechahregevext">
								<f:facet name="header">
									<t:commandSortHeader columnName="fecha" arrow="true">
										<h:outputText value="#{ms.elr_histo_fecha_msg_1 }" />
									</t:commandSortHeader>
								</f:facet>
								<a4j:commandLink title="#{ms.elr_histo_fecha_msg_2 }: #{linea.fecha}" 
									action="irRegEvExt" value="#{linea.fecha}"
									actionListener="#{controlRegEvExt.cargaRegEvExt}"
									onclick="javascript:Richfaces.showModalPanel('buscando');" />
							</t:column>						
							<t:column>
								<a4j:commandLink title="#{ms.eliminar }" 
									reRender="tablaRegEvExt" rendered="#{loginForm.acceso.privs.borrado eq 1}"
									actionListener="#{controlRegEvExt.eliminarHisto}"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									onclick="if (!confirm('Atención: va a eliminar un registro de grabadora externa de eventos, ¿desea continuar?')) return false;javascript:Richfaces.showModalPanel('buscando');">
									<h:graphicImage style="border: 0px;" value="/img/aplicacion/icoCancelar.png"
										width="16" height="16"/>
								</a4j:commandLink>
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaRegEvExt" id="scrollRegEvExt"
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
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:a4j="http://richfaces.org/a4j" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<style>
.alignTop {
	vertical-align: top;
}
</style>

		<h:form id="form">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panAudita">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel>
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.audi_title }" style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid>
						<f:attribute name="align" value="right" />
						<h:panelGrid columns="3">
							<f:attribute name="align" value="right" />
							<h:panelGrid columns="1" id="fdesde">
								<h:outputText value="#{ms.audi_consulta_msg_1 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="1">
									<rich:calendar datePattern="dd/MM/yyyy HH:mm" inputStyle="input"
										popup="true" showInput="true" enableManualInput="true"
										showApplyButton="true" value="#{controlAuditoria.desde}"
										styleClass="estiloInput" />
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid columns="1" id="fhasta">
								<h:outputText value="#{ms.audi_consulta_msg_2 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="1">
									<rich:calendar datePattern="dd/MM/yyyy HH:mm" inputStyle="input"
										popup="true" showInput="true" enableManualInput="true"
										showApplyButton="true" value="#{controlAuditoria.hasta}"
										styleClass="estiloInput" />
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid columns="2" columnClasses="right">
								<a4j:commandLink actionListener="#{controlAuditoria.buscarAuditoria}"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									reRender="PanelTabla,PanelTablaAccesos,panelResultadosAuditoriaAccesos" style="align:right;">
									<h:graphicImage styleClass="hvn_enlImagen" id="icoBuscar"
										value="/img/iconos/buscar.png" style="border:none;"
										width="24" height="24" title="#{ms.buscar }" />
								</a4j:commandLink>
								<a4j:commandLink actionListener="#{controlAuditoria.limpiaAuditoria}"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									style="align:right;" reRender="panAudita,panelResultadosAuditoriaAccesos">
									<h:graphicImage url="/img/iconos/limpia.png"
										title="#{ms.limpiar }" styleClass="hvn_enlImagen"
										width="24" height="24"
										style="border:none;" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="1">
							<f:attribute name="align" value="right" />
							<h:outputLabel value="#{ms.audi_consulta_msg_3 }"
								style="color: red;font-size: 10px;font-weight: bold;"/>
						</h:panelGrid>
					</h:panelGrid>

					<h:panelGrid width="100%">
						<rich:tabPanel switchType="client" width="100%" height="500px">
							<rich:tab label="#{ms.audi_consulta_tab_1 }">
								<a4j:include viewId="auditoria/audita.jsp" id="auditGeneral"/>
							</rich:tab>
							<rich:tab label="#{ms.audi_consulta_tab_2 }">
								<a4j:include viewId="auditoria/accesos.jsp" id="auditAccesos"/>
							</rich:tab>
						</rich:tabPanel>
					</h:panelGrid>
					
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
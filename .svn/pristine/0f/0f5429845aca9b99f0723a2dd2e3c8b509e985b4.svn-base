<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:a4j="http://richfaces.org/a4j">

	<rich:spacer height="5px"/>
	<h:panelGrid>
		<h:commandLink actionListener="#{controlAuditoria.imprimeInformeAuditoria}"
			target="_blank" action="recarga">
			<h:graphicImage value="/img/iconos/print.png"
				width="24" height="24" style="border:none;" title="#{ms.imprimir }" />
		</h:commandLink>
	</h:panelGrid>
	<h:panelGrid id="PanelTabla" width="100%">
		<t:dataTable width="100%" rows="30" 
			value="#{controlAuditoria.auditoria}" var="linea" id="listaRRLL"
			binding="#{controlAuditoria.bindingTabla}"
			styleClass="hor-minimalist-b" 
			style="width:100%;background-image:url(/jwpedidos/img/iconos/spy_sweeper.png);
                background-repeat: no-repeat;
            	background-position:right bottom;" sortable="true">
			<t:column width="12%" style="text-align: center;" title="#{ms.audi_consulta_tab_1_msg_1 }"
				id="usuario" sortable="true" styleClass="hor-minimalist-b-row">
				<f:facet name="header">
					<h:outputText value="#{ms.audi_consulta_tab_1_msg_1 }" styleClass="hvn_cpoEtiqueta" id="cabUsuario" />
				</f:facet>
				<h:panelGrid style="text-align:center;" width="100%" id="a78">
					<h:outputText value="#{linea.usuario}" id="otusuario" styleClass="hvn_cpoEtiqueta" title="#{linea.usuario}" />
				</h:panelGrid>
			</t:column>
			<t:column width="20%" style="text-align: center;" title="#{ms.audi_consulta_tab_1_msg_2 }"
				id="accion" sortable="false" styleClass="hor-minimalist-b-row">
				<f:facet name="header">
					<h:outputText value="#{ms.audi_consulta_tab_1_msg_2 }" styleClass="hvn_cpoEtiqueta" id="cabAccion" />
				</f:facet>
				<h:panelGrid style="text-align:center;" width="100%" id="PGAccion">
					<h:outputText value="#{linea.accionString}" id="otaccion"
						styleClass="hvn_cpoEtiqueta" title="#{linea.accionString}" />
				</h:panelGrid>
			</t:column>
			<t:column width="20%" style="text-align: center;" title="#{ms.audi_consulta_tab_1_msg_3 }"
				id="tabla" sortable="false" styleClass="hor-minimalist-b-row">
				<f:facet name="header">
					<h:outputText value="#{ms.audi_consulta_tab_1_msg_3 }" styleClass="hvn_cpoEtiqueta" id="cabTabla" />
				</f:facet>
				<h:panelGrid style="text-align:center;" width="100%" id="PGTabla">
					<h:outputText value="#{linea.tabla}" id="otTabla"
						styleClass="hvn_cpoEtiqueta" title="#{linea.tabla}" />
				</h:panelGrid>
			</t:column>
			<t:column width="28%" style="text-align: center;" styleClass="hor-minimalist-b-row"
				title="#{ms.audi_consulta_tab_1_msg_4 }" id="descri" sortable="false">
				<f:facet name="header">
					<h:outputText value="#{ms.audi_consulta_tab_1_msg_4 }" styleClass="hvn_cpoEtiqueta" id="cabdescri" />
				</f:facet>
				<h:panelGrid style="text-align:center;" width="100%" id="PGdescri">
					<h:outputText value="#{linea.descri}" id="otdescri"
						styleClass="hvn_cpoEtiqueta" title="#{linea.descri}" />
				</h:panelGrid>
			</t:column>
			<t:column width="20%" style="text-align: center;" title="#{ms.audi_consulta_tab_1_msg_5 }"
				id="fecha" sortable="false" styleClass="hor-minimalist-b-row">
				<f:facet name="header">
					<h:outputText value="#{ms.audi_consulta_tab_1_msg_5 }" styleClass="hvn_cpoEtiqueta" id="cabfecha" />
				</f:facet>
				<h:panelGrid style="text-align:center;" width="100%" id="PGfecha">
					<h:outputText value="#{linea.fechaHoraString}" id="otfecha"
						styleClass="hvn_cpoEtiqueta" title="#{linea.fechaHoraString}" />
				</h:panelGrid>
			</t:column>
			<f:facet name="footer">
				<rich:datascroller align="center" for="listaRRLL" id="a113"
					renderIfSinglePage="true" fastStep="10" boundaryControls="show"
					page="#{controlAuditoria.pagina_inicial}" />
			</f:facet>
		</t:dataTable>
	</h:panelGrid>
	
</ui:composition>
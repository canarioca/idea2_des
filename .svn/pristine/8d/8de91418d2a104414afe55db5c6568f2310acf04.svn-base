<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:a4j="http://richfaces.org/a4j">

	<rich:spacer height="5px"/>
	<h:panelGrid columns="2" id="panelResultadosAuditoriaAccesos" width="100%">
		<h:panelGrid columns="2">
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.audi_consulta_tab_2_msg_1 }" style="font-weight: bold;"/>
				<h:outputLabel value="#{controlAuditoria.numAccesos}" style="font-weight: bold;color:#E17009" />
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.audi_consulta_tab_2_msg_2 }" style="font-weight: bold;"/>
				<h:outputLabel value="#{controlAuditoria.numUsuarios}" style="font-weight: bold;color:#E17009" />
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid>
			<f:attribute name="align" value="right" />
			<h:commandLink actionListener="#{controlAuditoria.imprimeInformeAuditoriaAccesos}"
				target="_blank" action="recarga">
				<h:graphicImage value="/img/iconos/print.png"
					width="24" height="24"
					style="border:none;" title="#{ms.imprimir }" />
			</h:commandLink>
		</h:panelGrid>
		
	</h:panelGrid>
	<h:panelGrid id="PanelTablaAccesos" width="100%" columns="2">
		<h:panelGrid columnClasses="alignTop" width="100%">
			<t:dataTable width="100%" rows="30" 
				value="#{controlAuditoria.accesosUsuariosEst}" var="linea" id="listaAuditoriaAccesosEst"
				binding="#{controlAuditoria.bindingAccesoUsuariosEst}"
				styleClass="hor-minimalist-b"
				style="width:100%;background-repeat: no-repeat;
		            background-position:right bottom;" sortable="true">
				<t:column width="12%" style="text-align: center;" title="#{ms.audi_consulta_tab_2_msg_3 }"
					id="usuarioAcc" sortable="true" styleClass="hor-minimalist-b-row">
					<f:facet name="header">
						<h:outputText value="#{ms.audi_consulta_tab_2_msg_3 }" styleClass="hvn_cpoEtiqueta" id="cabUsuarioAcc" />
					</f:facet>
					<h:panelGrid style="text-align:center;" width="100%" id="a78">
						<h:outputText value="#{linea.usuario}" id="otusuarioAcc" styleClass="hvn_cpoEtiqueta" title="#{linea.usuario}" />
					</h:panelGrid>
				</t:column>
				<t:column width="20%" style="text-align: center;" title="#{ms.audi_consulta_tab_2_msg_4 }"
					id="accesosAcc" sortable="false" styleClass="hor-minimalist-b-row">
					<f:facet name="header">
						<h:outputText value="#{ms.audi_consulta_tab_2_msg_4 }" styleClass="hvn_cpoEtiqueta" id="cabaccAcc" />
					</f:facet>
					<h:panelGrid style="text-align:center;" width="100%" id="PGaccAcc">
						<h:outputText value="#{linea.numeroAccesos}" id="otaccAcc"
							styleClass="hvn_cpoEtiqueta" title="#{linea.numeroAccesos}" />
					</h:panelGrid>
				</t:column>
				<f:facet name="footer">
					<rich:datascroller align="center" for="listaAuditoriaAccesosEst" id="a113"
						renderIfSinglePage="true" fastStep="10" boundaryControls="show"
						page="#{controlAuditoria.pagina_inicial_nacc}" />
				</f:facet>
			</t:dataTable>
		</h:panelGrid>
		<h:panelGrid columnClasses="alignTop" width="100%">
			<t:dataTable width="100%" rows="30" 
				value="#{controlAuditoria.accesosUsuarios}" var="linea" id="listaAuditoriaAccesos"
				binding="#{controlAuditoria.bindingAccesoUsuarios}"
				styleClass="hor-minimalist-b" 
				style="width:100%;background-repeat: no-repeat;
		            background-position:right bottom;" sortable="true">
				<t:column width="12%" style="text-align: center;" title="#{ms.audi_consulta_tab_2_msg_3 }"
					id="usuarioAcc" sortable="true" styleClass="hor-minimalist-b-row">
					<f:facet name="header">
						<h:outputText value="#{ms.audi_consulta_tab_2_msg_3 }" styleClass="hvn_cpoEtiqueta" id="cabUsuarioAcc" />
					</f:facet>
					<h:panelGrid style="text-align:center;" width="100%" id="a78">
						<h:outputText value="#{linea.usuario}" id="otusuarioAcc" styleClass="hvn_cpoEtiqueta" title="#{linea.usuario}" />
					</h:panelGrid>
				</t:column>
				<t:column width="20%" style="text-align: center;" title="#{ms.audi_consulta_tab_2_msg_5 }"
					id="fechaAcc" sortable="false" styleClass="hor-minimalist-b-row">
					<f:facet name="header">
						<h:outputText value="#{ms.audi_consulta_tab_2_msg_5 }" styleClass="hvn_cpoEtiqueta" id="cabfechaAcc" />
					</f:facet>
					<h:panelGrid style="text-align:center;" width="100%" id="PGfechaAcc">
						<h:outputText value="#{linea.fechaHoraString}" id="otfechaAcc"
							styleClass="hvn_cpoEtiqueta" title="#{linea.fechaHoraString}" />
					</h:panelGrid>
				</t:column>
				<f:facet name="footer">
					<rich:datascroller align="center" for="listaAuditoriaAccesos" id="a113"
						renderIfSinglePage="true" fastStep="10" boundaryControls="show"
						page="#{controlAuditoria.pagina_inicial_acc}" />
				</f:facet>
			</t:dataTable>
		</h:panelGrid>
	</h:panelGrid>
	
</ui:composition>
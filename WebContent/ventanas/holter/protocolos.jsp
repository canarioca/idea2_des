<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox">

	<h:panelGrid id="tablaPacientesBduPrt" width="100%">
		<h:outputText rendered="#{empty controlHolter.listaprot}"
			value="#{ms.prot_modal_sin_resultados }" style="font-size: 16px;font-weight: bold;" />
		<t:dataTable styleClass="hor-minimalist-b" var="prot" width="90%"
			binding="#{controlHolter.bindingProt}" id="tablaprotocolospat" rows="13"
			preserveDataModel="true" value="#{controlHolter.listaprot}">
			<t:column id="vinculoPrt">
				<f:facet name="header">
					<h:outputText value="" />
				</f:facet>
				<a4j:commandLink reRender="panHolter,panicoholter"
					actionListener="#{controlHolter.vincularProtocolo}"
					onclick="javascript:Richfaces.showModalPanel('buscando');javascript:Richfaces.hideModalPanel('protocolos');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage url="/img/iconos/link.png" style="border:0px;"
						title="#{ms.vincular }" width="22" height="22"/>
				</a4j:commandLink>
			</t:column>
			<t:column id="fechaIniPrt">
				<f:facet name="header">
					<h:outputText value="#{ms.prot_modal_fechaprot }" />
				</f:facet>
				<a4j:commandLink value="#{prot.fechacreacion}" reRender="panHolter,panicoholter"
					actionListener="#{controlHolter.vincularProtocolo}"
					onclick="javascript:Richfaces.showModalPanel('buscando');javascript:Richfaces.hideModalPanel('protocolos');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');" />
			</t:column>
			<t:column id="tipoPrt">
				<f:facet name="header">
					<h:outputText value="#{ms.prot_modal_prot }" />
				</f:facet>
				<h:selectOneMenu value="#{prot.tipo }" disabled="true">
					<f:selectItems value="#{controlHolter.tipos}" />							
				</h:selectOneMenu>
			</t:column>
			<t:column id="verPrt">
				<f:facet name="header">
					<h:outputText value="" />
				</f:facet>
				<a4j:commandLink actionListener="#{controlHolter.irProtocolo}"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					title="#{ms.ver_protocolo }" action="irProtocoloSincope">
					<h:graphicImage value="/img/iconos/protocolo.png" style="border: 0px;"
						width="20" height="20"/>
				</a4j:commandLink>
			</t:column>
			
			<f:facet name="footer">
				<rich:datascroller for="tablaprotocolospat" id="scrollprotocolos"
					renderIfSinglePage="false" fastStep="4" stepControls="auto"
					boundaryControls="auto" fastControls="auto" />
			</f:facet>
		</t:dataTable>
	</h:panelGrid>
</ui:composition>
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

	<h:panelGrid id="tablaPacientesBdu" width="100%">
		<h:outputText rendered="#{empty controlRegistrador.episodios}"
			value="#{ms.episodios_sin_resultados }"
			style="font-size: 16px;font-weight: bold;" />
		<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
			binding="#{controlRegistrador.bindingepi}" id="tablaepi" rows="13"
			preserveDataModel="true" value="#{controlRegistrador.episodios}">
			<t:column id="fechaepi">
				<f:facet name="header">
					<h:outputText value="#{ms.episodios_fechaproc }" />
				</f:facet>
				<h:outputText value="#{linea.fechaEpisodiostr}" rendered="false"/>
				<a4j:commandLink value="#{linea.fechaEpisodiostr}" reRender="panRegistrador,panComplicacionesPacienteRegEv"
					actionListener="#{controlRegistrador.guarda}"
					onclick="javascript:Richfaces.showModalPanel('buscando');javascript:Richfaces.hideModalPanel('episodios');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');" />
			</t:column>
			<t:column id="fechaalta" rendered="false">
				<f:facet name="header">
					<h:outputText value="Fecha alta" />
				</f:facet>
				<h:outputText value="#{linea.fechaFinstr}" />
			</t:column>
			<t:column>
				<f:facet name="header">
					<h:outputText value="#{ms.episodios_proc }" />
				</f:facet>
				<h:outputText value="#{linea.procedimiento}" rendered="false"/>
				<a4j:commandLink value="#{linea.procedimiento}" reRender="panRegistrador,panComplicacionesPacienteRegEv"
					actionListener="#{controlRegistrador.guarda}"
					onclick="javascript:Richfaces.showModalPanel('buscando');javascript:Richfaces.hideModalPanel('episodios');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');" />
			</t:column>
			<t:column id="episodio">
				<f:facet name="header">
					<h:outputText value="#{ms.episodios_episodio }" />
				</f:facet>
				<a4j:commandLink title="#{ms.episodios_episodio }: #{linea.numicu}"
					value="#{linea.numicu}" reRender="panRegistrador"
					actionListener="#{controlRegistrador.guarda}"
					onclick="javascript:Richfaces.showModalPanel('buscando');javascript:Richfaces.hideModalPanel('episodios');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');" />
			</t:column>
			<t:column>
				<f:facet name="header">
					<h:outputText value="#{ms.episodio_evento }" />
				</f:facet>
				<h:outputText value="#{linea.identev}" rendered="false"/>
				<a4j:commandLink value="#{linea.identev}" reRender="panRegistrador,panComplicacionesPacienteRegEv"
					actionListener="#{controlRegistrador.guarda}"
					onclick="javascript:Richfaces.showModalPanel('buscando');javascript:Richfaces.hideModalPanel('episodios');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');" />
			</t:column>
			<f:facet name="footer">
				<rich:datascroller for="tablaepi" id="scrollepisodios"
					renderIfSinglePage="false" fastStep="4" stepControls="auto"
					boundaryControls="auto" fastControls="auto" />
			</f:facet>
		</t:dataTable>

		<a4j:commandLink title="#{ms.guardar }" reRender="panRegistrador,panComplicacionesPacienteRegEv"
			value="#{ms.episodio_otromsg }"
			actionListener="#{controlRegistrador.guarda}"
			onclick="javascript:Richfaces.showModalPanel('buscando');javascript:Richfaces.hideModalPanel('episodios');"
			oncomplete="javascript:Richfaces.hideModalPanel('buscando');" />
	</h:panelGrid>
</ui:composition>
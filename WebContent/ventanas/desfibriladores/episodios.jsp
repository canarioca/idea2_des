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
		<h:outputText rendered="#{empty controlDesfibriladores.episodios}"
			value="No se han encontrado resultados"
			style="font-size: 16px;font-weight: bold;" />
		<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
			binding="#{controlDesfibriladores.bindingepi}" id="tablaepi" rows="13"
			preserveDataModel="true" value="#{controlDesfibriladores.episodios}">
			<t:column id="episodio">
				<f:facet name="header">
					<h:outputText value="Episodio" />
				</f:facet>
				<a4j:commandLink title="Episodio: #{linea.numicu}"
					value="#{linea.numicu}" reRender="panicodai"
					actionListener="#{controlDesfibriladores.guarda}"
					onclick="javascript:Richfaces.showModalPanel('buscando');javascript:Richfaces.hideModalPanel('episodios');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');" />
			</t:column>
			<t:column id="fechaepi">
				<f:facet name="header">
					<h:outputText value="Fecha ingreso" />
				</f:facet>
				<h:outputText value="#{linea.fechaEpisodiostr}" />
			</t:column>
			<t:column id="fechaalta">
				<f:facet name="header">
					<h:outputText value="Fecha alta" />
				</f:facet>
				<h:outputText value="#{linea.fechaFinstr}" />
			</t:column>
			<t:column id="servicio">
				<f:facet name="header">
					<h:outputText value="Servicio" />
				</f:facet>
				<h:outputText value="#{linea.descriUnidad}" />
			</t:column>
			<f:facet name="footer">
				<rich:datascroller for="tablaepi" id="scrollepisodios"
					renderIfSinglePage="false" fastStep="4" stepControls="auto"
					boundaryControls="auto" fastControls="auto" />
			</f:facet>
		</t:dataTable>

		<a4j:commandLink title="Guardar" reRender="panicodai"
			value="Si no es ninguno de los anteriores pulse aquí para guardar"
			actionListener="#{controlDesfibriladores.guarda}"
			onclick="javascript:Richfaces.showModalPanel('buscando');javascript:Richfaces.hideModalPanel('episodios');"
			oncomplete="javascript:Richfaces.hideModalPanel('buscando');" />
	</h:panelGrid>
</ui:composition>
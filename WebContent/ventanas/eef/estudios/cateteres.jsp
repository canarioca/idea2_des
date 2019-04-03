<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="90%">
		<h:panelGrid columns="2">
			<h:outputLabel value="Catéteres diagnósticos utilizados"
				style="font-weight: bold;" />
			<a4j:commandLink reRender="tablaCateteres"
				actionListener="#{controlEef.eef.addCateter }">
				<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
					style="border:0;" title="Añadir catéter" />
			</a4j:commandLink>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaCateteres" width="100%">
			<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
				value="#{controlEef.eef.cateterdto }"
				binding="#{controlEef.eef.bincat }">
				<t:column width="30%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="Catéter" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:inputText id="Catet" size="30"
							value="#{linea.idcateter }" />
						<h:graphicImage value="/img/iconos/arrow.png"
							onclick="#{rich:component('suggestionBoxCateter')}.callSuggestion(true)" />
						<rich:suggestionbox id="suggestionBoxCateter"
							for="Catet"
							suggestionAction="#{controlEef.autocompletarCateteres}"
							var="result" zindex="50000" width="200" height="100"
							nothingLabel="No se encontró ningún catéter">
							<a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender" />
							<h:column>
								<h:outputText value="#{result.valor}"
									style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
							</h:column>
						</rich:suggestionbox>
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="Marca/Modelo" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:inputText id="Marca" size="30"
							value="#{linea.idfuncion }" />
						<h:graphicImage value="/img/iconos/arrow.png"
							onclick="#{rich:component('suggestionBoxMarca')}.callSuggestion(true)" />
						<rich:suggestionbox id="suggestionBoxMarca"
							for="Marca"
							suggestionAction="#{controlEef.autocompletarMarcaCat}"
							var="result" zindex="50000" width="200" height="100"
							nothingLabel="No se encontró ninguna marca/modelo">
							<a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender" />
							<h:column>
								<h:outputText value="#{result.valor}"
									style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
							</h:column>
						</rich:suggestionbox>
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="Localización" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:inputText id="Local" size="30"
							value="#{linea.idloc }" />
						<h:graphicImage value="/img/iconos/arrow.png"
							onclick="#{rich:component('suggestionBoxLocal')}.callSuggestion(true)" />
						<rich:suggestionbox id="suggestionBoxLocal"
							for="Local"
							suggestionAction="#{controlEef.autocompletarLocalCat}"
							var="result" zindex="50000" width="200" height="100"
							nothingLabel="No se encontró ninguna localización">
							<a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender" />
							<h:column>
								<h:outputText value="#{result.valor}"
									style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
							</h:column>
						</rich:suggestionbox>
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="Vía acceso" />
					</f:facet>
					<h:selectOneMenu value="#{linea.idvia }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.viascateter }" />
					</h:selectOneMenu>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaCateteres"
						actionListener="#{controlEef.eef.delCateter }">
						<h:graphicImage url="/img/iconos/minus.png"
							title="Eliminar catéter" width="16" height="16"
							style="border: 0px;" />
					</a4j:commandLink>
				</t:column>
			</t:dataTable>
		</h:panelGrid>

		<rich:spacer height="10" />

		<h:outputLabel value="Comentarios" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="100%">
			<h:inputTextarea rows="2" cols="120"
				value="#{controlEef.eef.coment_cateter }" />
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
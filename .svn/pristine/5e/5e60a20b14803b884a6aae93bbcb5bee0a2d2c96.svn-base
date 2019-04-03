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
			<h:outputLabel value="#{ms.eef_tab_pref_title }" style="font-weight: bold;" />
			<a4j:commandLink reRender="tablaPeriodo" actionListener="#{controlEef.eef.addPr }">
				<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
					style="border:0;" title="#{ms.eef_tab_pref_add }" />
			</a4j:commandLink>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaPeriodo" width="100%">
			<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
				value="#{controlEef.eef.periodosdto }"
				binding="#{controlEef.eef.binpr }">
				<t:column width="15%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_pref_tipo }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.idtipo }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.tipoperiodos }" />
					</h:selectOneMenu>
				</t:column>
				<t:column width="35%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_pref_tejido }" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:inputText id="Tejidos" size="30"
							value="#{linea.idtejido }" />
						<h:graphicImage value="/img/iconos/arrow.png"
							onclick="#{rich:component('suggestionBoxTejidos')}.callSuggestion(true)" />
						<rich:suggestionbox id="suggestionBoxTejidos"
							for="Tejidos"
							suggestionAction="#{controlEef.autocompletarTejidos}"
							var="result" zindex="50000" width="200" height="100"
							nothingLabel="#{ms.eef_tab_pref_tejido_no }">
							<a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender" />
							<h:column>
								<h:outputText value="#{result.valor}"
									style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
							</h:column>
						</rich:suggestionbox>
					</h:panelGrid>
				</t:column>
				<t:column width="15%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_pref_farma }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.idfarmaco }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.farmacospr }" />
					</h:selectOneMenu>
				</t:column>
				<t:column width="15%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_pref_s1s1 }" />
					</f:facet>
					<h:inputText size="5" value="#{linea.ids1 }" maxlength="20"/>
				</t:column>
				<t:column width="15%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_pref_valor }" />
					</f:facet>
					<h:inputText value="#{linea.ref }" maxlength="20"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;"/>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaPeriodo" actionListener="#{controlEef.eef.delPr }">
						<h:graphicImage url="/img/iconos/minus.png"
							title="#{ms.eef_tab_pref_del }" width="16" height="16"
							style="border: 0px;" />
					</a4j:commandLink>
				</t:column>
			</t:dataTable>
		</h:panelGrid>
		
		<rich:spacer height="10"/>
		
		<h:outputLabel value="#{ms.eef_tab_pref_com }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="100%">
			<h:inputTextarea rows="6" cols="120" value="#{controlEef.eef.coment_periodos }"/>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
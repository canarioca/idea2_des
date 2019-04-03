<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		<h:outputLabel value="Complicaciones" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			columns="6" width="60%"
			columnClasses="alignMiddle,alignMiddle,alignMiddle,alignMiddle,alignMiddle,alignMiddle">
			<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.complningunab }" />
			<h:outputLabel value="Ninguna" />
			<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.complmuerteb }" />
			<h:outputLabel value="Muerte" />
			<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.compltapb }" />
			<h:outputLabel value="Taponamiento cardiaco" />
			<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.complneumb }" />
			<h:outputLabel value="Neumotorax" />
			<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.compldisecb }" />
			<h:outputLabel value="Disección SC" />
			<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.complotrob }" />
			<h:panelGrid cellpadding="0" cellspacing="0" columns="2">
				<h:outputLabel value="Otro" />
				<h:inputText size="25" value="#{controlDesfibriladores.desf.otracomp}"/>
			</h:panelGrid>
			<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.complsituab }" />
			<h:outputLabel value="Situación subóptima VI" />
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
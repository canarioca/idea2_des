<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid width="100%" styleClass="index_text_center"
		rendered="#{controlPacientes.pacienteSelect.nhc ne null }">
		<h:panelGrid columns="2">
			<h:outputLabel styleClass="index_text_center" style="color: white;font-weight: bold;font-size: 14px;" 
				value="#{controlPacientes.pacienteSelect.nombreCompleto} - NHC: #{controlPacientes.pacienteSelect.nhc }"/>
			<h:outputLabel styleClass="index_text_center" style="color: red;font-weight: bold;font-size: 14px;"
				rendered="#{controlPacientes.pacienteSelect.edad &lt; 17 }" 
				value=" - PEDIÁTRICO"/>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid width="100%" styleClass="index_text_center" id="cabpaci">
		<h:outputLabel styleClass="index_text_center" style="color: white;font-weight: bold;font-size: 10px;" 
			value="#{controlEef.tiempo }"/>
	</h:panelGrid>
</ui:composition>
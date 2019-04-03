<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="85%">
		<h:outputLabel value="A. Arritmia Clínica" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="55%">
			<h:selectOneRadio layout="lineDirection" value="#{controlDesfibriladores.desf.arrclinica }">
				<f:selectItem itemLabel="FV" itemValue="1" />
				<f:selectItem itemLabel="TVP" itemValue="2" />
				<f:selectItem itemLabel="TVMS" itemValue="3" />
				<f:selectItem itemLabel="TVNS" itemValue="4" />
				<f:selectItem itemLabel="Ninguna" itemValue="5" />
			</h:selectOneRadio>
		</h:panelGrid>
		
		<rich:spacer height="3"/>
		
		<h:outputLabel value="B. Presentación Clínica" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="55%" columns="2" columnClasses="alignTop,alignTop">
			<h:selectOneRadio layout="lineDirection" value="#{controlDesfibriladores.desf.presclinica }" >
				<f:selectItem itemLabel="Asintomático" itemValue="4" />
				<f:selectItem itemLabel="Muerte súbita" itemValue="1" />
				<f:selectItem itemLabel="Síncope" itemValue="2" />
				<f:selectItem itemLabel="Otros síntomas" itemValue="3" />
			</h:selectOneRadio>
			<h:inputText size="25" value="#{controlDesfibriladores.desf.presclinicastr }"/>
		</h:panelGrid>
		
		<rich:spacer height="3"/>
		
		<h:outputLabel value="C. EEF" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="55%" cellspacing="0">
			<h:selectOneRadio layout="lineDirection" value="#{controlDesfibriladores.desf.eef }">
				<f:selectItem itemLabel="No" itemValue="1" />
				<f:selectItem itemLabel="Si" itemValue="2" />
			</h:selectOneRadio>
			<h:panelGrid columns="3">
				<rich:spacer width="15px"/>
				<h:outputLabel value="Arritmia inducida:" style="font-weight: bold;" />
				<h:selectOneRadio layout="lineDirection" value="#{controlDesfibriladores.desf.arrinducida }">
					<f:selectItem itemLabel="FV" itemValue="1" />
					<f:selectItem itemLabel="TVMS" itemValue="2" />
					<f:selectItem itemLabel="TVNS" itemValue="3" />
					<f:selectItem itemLabel="Ninguna" itemValue="4" />
					<f:selectItem itemLabel="Otra" itemValue="5" />
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
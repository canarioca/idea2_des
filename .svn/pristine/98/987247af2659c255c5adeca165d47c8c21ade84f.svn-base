<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" cellspacing="0">
		<h:outputLabel value="A. Estimulación antribradicardia"
			style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%">
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.estimantibradi }">
				<f:selectItem itemLabel="VVI" itemValue="1" />
				<f:selectItem itemLabel="VVIR" itemValue="2" />
				<f:selectItem itemLabel="DDD" itemValue="3" />
				<f:selectItem itemLabel="DDDR" itemValue="4" />
				<f:selectItem itemLabel="Otro" itemValue="5" />
			</h:selectOneRadio>
		</h:panelGrid>
		<h:panelGrid width="60%" columns="3">
			<rich:spacer width="15px"/>
			<h:outputLabel value="A.1 Algoritmo de prevención de estimulación ventricular"
			style="font-weight: bold;" />
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.algoritmo }">
				<f:selectItem itemLabel="ON" itemValue="1" />
				<f:selectItem itemLabel="OFF" itemValue="2" />
				<f:selectItem itemLabel="No presente" itemValue="3" />
			</h:selectOneRadio>
		</h:panelGrid>
		
		<rich:spacer height="3"/>
		
		<h:outputLabel value="B. Estimulación ATP Programada"
			style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%">
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.atp }">
				<f:selectItem itemLabel="Si" itemValue="1" />
				<f:selectItem itemLabel="No" itemValue="2" />
				<f:selectItem itemLabel="No disponible" itemValue="3" />
			</h:selectOneRadio>
		</h:panelGrid>
		
		<rich:spacer height="3"/>
		
		<h:outputLabel value="C. Modelo"
			style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%">
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.modelo }">
				<f:selectItem itemLabel="Monocameral" itemValue="1" />
				<f:selectItem itemLabel="Bicameral" itemValue="2" />
				<f:selectItem itemLabel="Tricameral" itemValue="3" />
			</h:selectOneRadio>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
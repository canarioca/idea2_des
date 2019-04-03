<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid columns="2">
		<h:panelGrid columns="2">
			<h:panelGrid columns="2">
				<h:outputLabel value="A. F.Nac:" style="font-weight: bold;" />
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
					showWeeksBar="false" direction="bottom-left"
					value=""/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="B. Edad:" style="font-weight: bold;" />
				<h:inputText />
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="C. Sexo:" style="font-weight: bold;" />
				<h:panelGrid columns="4">
					<h:selectBooleanCheckbox
						value="" />
					<h:outputLabel value="Varón" />
					<h:selectBooleanCheckbox
						value="" />
					<h:outputLabel value="Mujer" />
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="D. Seg." style="font-weight: bold;" />
				<h:panelGrid columns="4">
					<h:selectBooleanCheckbox
						value="" />
					<h:outputLabel value="Si" />
					<h:selectBooleanCheckbox
						value="" />
					<h:outputLabel value="No" />
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="E. Población de Residencia:" style="font-weight: bold;" />
				<h:inputText />
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid>
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
				<h:outputLabel value="F. Hospital de Implante:" style="font-weight: bold;" />
				<h:inputText />
				<h:outputLabel value="G. Hospital de Procedencia:" style="font-weight: bold;" />
				<h:inputText />
				<h:outputLabel value="H. Ciudad del Hospital:" style="font-weight: bold;" />
				<h:inputText />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		
		<h:outputLabel value="Electrodo Auricular" style="font-weight: bold;" />
		<h:panelGrid width="100%" columns="2" style="border-top: solid 1px;border-color: black;">
			<h:outputLabel value="Fecha de implantación" style="font-weight: bold;" />
			<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlMarcapasos.obj.fechaimpea}" />						
			<rich:spacer width="10" />
			<rich:spacer width="10" />
			
			<h:outputLabel value="Fabricante" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.fabea}">
				<f:selectItems value="#{controlMarcapasos.fabricantes }" />
			</h:selectOneMenu>
			<rich:spacer width="10" />
			<rich:spacer width="10" />
			
			<h:panelGrid width="100%" columns="6">
				<h:outputText value="IS.1"/>
				<h:selectBooleanCheckbox
					  value="#{controlMarcapasos.obj.isea}" >
				</h:selectBooleanCheckbox>
				<h:selectOneRadio layout="lineDirection" value="#{controlMarcapasos.obj.unibiea}">
						<f:selectItem itemLabel="Uni." itemValue="1" />
						<f:selectItem itemLabel="Bi." itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
				
			<rich:spacer width="10" />	
					
			<h:outputLabel value="Modelo" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.modeloea}">
				<f:selectItems value="#{controlMarcapasos.modeloelect }" />
			</h:selectOneMenu>
			<rich:spacer width="10" />
			<rich:spacer width="10" />
			
			<h:outputLabel value="No./Serie" style="font-weight: bold;" />
			<h:inputText size="75" value="#{controlMarcapasos.obj.numserieea }"/>
			<rich:spacer width="10" />
			<rich:spacer width="10" />
		</h:panelGrid>
		
		<h:outputLabel value="Electrodo Ventricular" style="font-weight: bold;" />
		<h:panelGrid width="100%" columns="2" style="border-top: solid 1px;border-color: black;">
			<h:outputLabel value="Fecha de implantación" style="font-weight: bold;" />
			<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlMarcapasos.obj.fechaimpev}" />						
			<rich:spacer width="10" />
			<rich:spacer width="10" />
			
			<h:outputLabel value="Fabricante" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.fabev}">
				<f:selectItems value="#{controlMarcapasos.fabricantes }" />
			</h:selectOneMenu>
			<rich:spacer width="10" />
			<rich:spacer width="10" />
			
			<h:panelGrid width="100%" columns="6">
				<h:outputText value="IS.1"/>
				<h:selectBooleanCheckbox
					  value="#{controlMarcapasos.obj.isev}" >
				</h:selectBooleanCheckbox>
				<h:selectOneRadio layout="lineDirection" value="#{controlMarcapasos.obj.unibiev}">
						<f:selectItem itemLabel="Uni." itemValue="1" />
						<f:selectItem itemLabel="Bi." itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
				
			<rich:spacer width="10" />
			
			<h:outputLabel value="Modelo" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.modeloev}">
				<f:selectItems value="#{controlMarcapasos.modeloelect }" />
			</h:selectOneMenu>
			<rich:spacer width="10" />
			<rich:spacer width="10" />
			
			<h:outputLabel value="No./Serie" style="font-weight: bold;" />
			<h:inputText size="75" value="#{controlMarcapasos.obj.numserieev }"/>
			<rich:spacer width="10" />
			<rich:spacer width="10" />
		</h:panelGrid>
		
		
		
		
	</h:panelGrid>
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		
		<h:outputLabel value="Frecuencia mínima" style="font-weight: bold;" />
		<h:inputText size="5" id="frecmin" value="#{controlMarcapasos.obj.frecgen }"/>
		<rich:spacer width="10" />
		<rich:spacer width="10" />
		
		<h:outputLabel value="Modo Estimulación" style="font-weight: bold;" />
		<h:selectOneMenu value="#{controlMarcapasos.obj.modogen}">
			<f:selectItems value="#{controlMarcapasos.modoestim }" />
		</h:selectOneMenu>
		<rich:spacer width="10" />
		<rich:spacer width="10" />
		
		<h:outputLabel value="Duración impulso" style="font-weight: bold;" />
		<h:inputText size="5" value="#{controlMarcapasos.obj.durimpgen }"/>
		<rich:spacer width="10" />
		<rich:spacer width="10" />
		
		<h:outputLabel value="Fecha de implantación" style="font-weight: bold;" />
		<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlMarcapasos.obj.fechaimpgen}" />						
		<rich:spacer width="10" />
		<rich:spacer width="10" />
							
		<h:outputLabel value="Fabricante" style="font-weight: bold;" />
		<h:selectOneMenu value="#{controlMarcapasos.obj.fabgen}">
			<f:selectItems value="#{controlMarcapasos.fabricantes }" />
		</h:selectOneMenu>
		<rich:spacer width="10" />
		<rich:spacer width="10" />
		
		<h:outputLabel value="Modelo" style="font-weight: bold;" />
		<h:selectOneMenu value="#{controlMarcapasos.obj.modelogen}">
			<f:selectItems value="#{controlMarcapasos.modelogen }" />
		</h:selectOneMenu>
		<rich:spacer width="10" />
		<rich:spacer width="10" />
		
		<h:outputLabel value="No./Serie" style="font-weight: bold;" />
		<h:inputText size="75" value="#{controlMarcapasos.obj.numseriegen }"/>
		<rich:spacer width="10" />
		<rich:spacer width="10" />
		
	</h:panelGrid>
</ui:composition>
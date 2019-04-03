<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		
		<h:outputLabel value="Fecha de 1ª implantación" style="font-weight: bold;" />
		<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlMarcapasos.obj.fechaprimerimplante}" />							
		<rich:spacer width="10" />
		<rich:spacer width="10" />
		
		<h:outputLabel value="Parámetros principales" style="font-weight: bold;" />
		<h:panelGrid width="100%" columns="2" style="border-top: solid 1px;border-color: black;">
			<h:outputLabel value="Síntoma principal" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.sintprim }">
				<f:selectItems value="#{controlMarcapasos.sintomas }" />
			</h:selectOneMenu>
			<h:outputLabel value="ECG" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.ecgprim }">
				<f:selectItems value="#{controlMarcapasos.indecg }" />
			</h:selectOneMenu>
			<h:outputLabel value="Etiología" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.etioprim }">
				<f:selectItems value="#{controlMarcapasos.etiologia }" />
			</h:selectOneMenu>
		</h:panelGrid>

		<rich:spacer height="3"/>
		
		<h:outputLabel value="Parámetros secundarios" style="font-weight: bold;" />
		<h:panelGrid width="100%" columns="2" style="border-top: solid 1px;border-color: black;">
			<h:outputLabel value="Síntoma secundario" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.sintsec }">
				<f:selectItems value="#{controlMarcapasos.sintomas }" />
			</h:selectOneMenu>
			<h:outputLabel value="ECG" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.ecgsec }">
				<f:selectItems value="#{controlMarcapasos.indecg }" />
			</h:selectOneMenu>
			<h:outputLabel value="Etiología" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMarcapasos.obj.etiosec }">
				<f:selectItems value="#{controlMarcapasos.etiologia }" />
			</h:selectOneMenu>
		</h:panelGrid>
		
		<h:outputLabel value="Dependiente de Marcapasos" style="font-weight: bold;" />
		<h:panelGrid width="60%" cellspacing="0" style="border-top: solid 1px;border-color: black;">
			<h:selectOneRadio layout="lineDirection" value="#{controlMarcapasos.obj.dependientemp }">
				<f:selectItem itemLabel="No" itemValue="0" />
				<f:selectItem itemLabel="Si" itemValue="1" />
			</h:selectOneRadio>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
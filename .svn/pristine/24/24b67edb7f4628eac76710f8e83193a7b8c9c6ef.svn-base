<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox">
	
	<h:panelGrid id="panelMaterialEditarElectrodoImp">
		<h:panelGrid  
			columns="4" width="100%" >
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.mat_ele_modelo }"/>
				<h:inputText value="#{controlImplantes.nuevoelec.modelo}"/>
				<h:outputLabel value="#{ms.mat_ele_fabricante }"/>
				<h:selectOneMenu value="#{controlImplantes.nuevoelec.fabricante}">
					<f:selectItems value="#{controlImplantes.fabelec }" />											
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" id="RefMaterialEditarElecImp">
				<h:outputLabel value="#{ms.mat_ele_referencia }"/>
				<h:inputText value="#{controlImplantes.nuevoelec.codigo}"/>
				<h:outputLabel value="#{ms.mat_ele_gs128 }"/>
				<h:inputText value="#{controlImplantes.nuevoelec.gs128}" disabled="true">
					<a4j:support event="onchange" reRender="RefMaterialEditarElecImp" ajaxSingle="true"
						actionListener="#{controlImplantes.lecturaGs128Electrodo}"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="2">	
				<h:outputLabel value="#{ms.mat_ele_polaridad }"/>
				<h:selectOneMenu value="#{controlImplantes.nuevoelec.polaridad}">
					<f:selectItems value="#{controlImplantes.polelec }" />												
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.mat_ele_conector }"/>
				<h:selectOneMenu value="#{controlImplantes.nuevoelec.conector}">
					<f:selectItems value="#{controlImplantes.conelec }" />												
				</h:selectOneMenu>
				<rich:spacer/>
				<rich:spacer/>
			</h:panelGrid>
			<h:panelGrid columns="2">	
				<h:outputLabel value="#{ms.mat_ele_fijacion }"/>
				<h:selectOneMenu value="#{controlImplantes.nuevoelec.fijacion}">
					<f:selectItems value="#{controlImplantes.fijaelec }" />											
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.mat_ele_bobina }"/>
				<h:selectOneMenu value="#{controlImplantes.nuevoelec.bobina}">
					<f:selectItems value="#{controlImplantes.bobelec }" />												
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>	
	</h:panelGrid>
	
</ui:composition>
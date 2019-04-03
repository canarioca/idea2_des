<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" cellspacing="0">
		<h:outputLabel value="#{ms.eef_tab_taq_tab_farma }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaFarmacos" width="50%">
			<h:selectManyListbox size="5" value="#{controlEef.eef.taquicardidto.farmacosarr }">
				<f:selectItems value="#{controlEef.farmacostaqui }" />
			</h:selectManyListbox>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
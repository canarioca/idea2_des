<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" columns="2" columnClasses="alignTop50,alignTop50"
		cellspacing="0">
		<h:outputLabel value="#{ms.eef_tab_taq_tab_modind_punto }"
			style="font-weight: bold;" />
		<h:outputLabel value="#{ms.eef_tab_taq_tab_modind_modo }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaEstim" width="80%">
			<h:selectOneMenu value="#{controlEef.eef.taquicardidto.puntoest }">
				<f:selectItems value="#{controlEef.puntoestimula }" />
			</h:selectOneMenu>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaCiclo" width="80%" columns="2">
			<h:selectOneMenu value="#{controlEef.eef.taquicardidto.modoind }">
				<f:selectItems value="#{controlEef.modoinduccion }" />
			</h:selectOneMenu>
			<h:inputText size="25" maxlength="20" value="#{controlEef.eef.taquicardidto.valorind }"/>
		</h:panelGrid>
		<h:panelGrid width="80%">
			<h:selectOneMenu value="#{controlEef.eef.taquicardidto.puntoest2 }">
				<f:selectItems value="#{controlEef.puntoestimula }" />
			</h:selectOneMenu>
		</h:panelGrid>
		<h:panelGrid width="80%" columns="2">
			<h:selectOneMenu value="#{controlEef.eef.taquicardidto.modoind2 }">
				<f:selectItems value="#{controlEef.modoinduccion }" />
			</h:selectOneMenu>
			<h:inputText size="25" maxlength="20" value="#{controlEef.eef.taquicardidto.valorind2 }"/>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
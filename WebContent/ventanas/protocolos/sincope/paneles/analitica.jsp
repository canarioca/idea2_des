<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" id="panProtSincopeAnalitica">
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.prot_sincope_analitica_title }" style="font-weight: bold;"/>
			<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.anaRealizada }">
				<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
				<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
				<a4j:support event="onchange" reRender="panProtSincopeAnaliticaRealizada" ajaxSingle="true"/>
			</h:selectOneRadio>
		</h:panelGrid>
		<h:panelGrid id="panProtSincopeAnaliticaRealizada">
			<h:panelGrid columns="2" rendered="#{controlProtocolos.prSincope.anaRealizada eq 1}">
				<h:outputLabel value="#{ms.prot_sincope_analitica_fecha }" style="font-weight: bold;"/>
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
					showWeeksBar="false" direction="bottom-left" value="#{controlProtocolos.prSincope.anaFecha }" />
			</h:panelGrid>
			<h:panelGrid columns="3" rendered="#{controlProtocolos.prSincope.anaRealizada eq 1}">
				<h:outputLabel value="#{ms.prot_sincope_analitica_hemo }" style="font-weight: bold;"/>
				<h:inputText value="#{controlProtocolos.prSincope.anaHemoglobina }" size="5"/>
				<h:outputLabel value="#{ms.prot_sincope_analitica_hemo_unidad }"/>
				<h:outputLabel value="#{ms.prot_sincope_analitica_ddimero }" style="font-weight: bold;"/>
				<h:inputText value="#{controlProtocolos.prSincope.anaDdimero }" size="5"/>
				<h:outputLabel value="#{ms.prot_sincope_analitica_ddimero_unidad }"/>
				<h:outputLabel value="#{ms.prot_sincope_analitica_lact }" style="font-weight: bold;"/>
				<h:inputText value="#{controlProtocolos.prSincope.anaLactato }" size="5"/>
				<h:outputLabel value="#{ms.prot_sincope_analitica_lact_unidad }"/>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>

</ui:composition>
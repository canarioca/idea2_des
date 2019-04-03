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
	
	<h:panelGrid columnClasses="alignTop,alignTop" width="100%">
		<h:panelGrid columns="2" rendered="#{controlSeguimientos.pleno eq true }">
			<h:graphicImage value="/img/iconos/alerta.png" width="28"
				height="28" style="border:0;" title="#{ms.seg_disp_evento_irfecha }"/>
			<h:outputLabel value="#{ms.seg_disp_evento_msg }"
				style="font-weight: bold;color: red;"/>
		</h:panelGrid>
		<h:panelGrid width="100%" columnClasses="alignTop">
			<t:schedule value="#{controlSeguimientos.agenda.model }" id="proximoseguimiento"
				binding="#{controlSeguimientos.agenda.schedule}"
				readonly="false"
				theme="evolution"
				tooltip="true"
				compactWeekRowHeight="300"
				compactMonthRowHeight="100"
				submitOnClick="true"
				expandToFitEntries="true"
				detailedRowHeight="25"
				headerDateFormat="EEE dd MMM yyyy"	
				rendered="true"												
				entryRenderer="#{colorEvento}"/>
		</h:panelGrid>			
	</h:panelGrid>
	
</ui:composition>
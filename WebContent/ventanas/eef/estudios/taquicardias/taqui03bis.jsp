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
		<h:outputLabel value="#{ms.eef_tab_taq_tab_eep_protocolos }" style="font-weight: bold;" />
		<h:outputLabel value="#{ms.eef_tab_taq_tab_eep_induc }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaProtocolos" width="90%">
			<a4j:jsFunction name="updateprot" reRender="tablaProtocolos" />
			<h:selectOneRadio layout="pageDirection" onclick="updateprot();" 
				value="#{controlEef.eef.taquicardidto.protocolo }">
				<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_eep_protocolos_op1 }" itemValue="1"/>
				<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_eep_protocolos_op2 }" itemValue="2"/>
				<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_eep_protocolos_op3 }" itemValue="3"/>
			</h:selectOneRadio>
			<h:panelGrid columns="3" rendered="#{controlEef.eef.taquicardidto.protocolo &gt; 1}">
				<rich:spacer width="10px"/>
				<h:outputLabel value="#{ms.eef_tab_taq_tab_eep_lc_tren }"
					style="font-style: italic;" />
				<h:inputText size="10" maxlength="10" value="#{controlEef.eef.taquicardidto.lctren }"/>
				<rich:spacer width="10px"/>
				<h:outputLabel value="#{ms.eef_tab_taq_tab_eep_nextra }"
					style="font-style: italic;" />
				<h:inputText size="10" maxlength="10" value="#{controlEef.eef.taquicardidto.nextra }"/>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaAAVV" width="80%">
			<h:selectOneMenu value="#{controlEef.eef.taquicardidto.aavv }">
				<f:selectItems value="#{controlEef.induccionaavv }" />
			</h:selectOneMenu>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
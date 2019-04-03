<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" columns="4">
		<h:outputLabel value="#{ms.prot_sincope_res_diag_final_title }" style="font-weight: bold;"/>
		<h:outputLabel value="#{ms.prot_sincope_res_decision_clin_title }" style="font-weight: bold;"/>
		<h:outputLabel value="#{ms.prot_sincope_res_fecha }" style="font-weight: bold;"/>
		<h:outputLabel value="#{ms.prot_sincope_res_operador }" style="font-weight: bold;"/>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;" width="100%" >
			<h:selectOneMenu value="#{controlProtocolos.prSincope.resDiagfin }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
				<f:selectItem itemLabel="#{ms.prot_sincope_res_diag_final_op1 }" itemValue="1" />
				<f:selectItem itemLabel="#{ms.prot_sincope_res_diag_final_op2 }" itemValue="2" />
				<f:selectItem itemLabel="#{ms.prot_sincope_res_diag_final_op3 }" itemValue="3" />
				<f:selectItem itemLabel="#{ms.prot_sincope_res_diag_final_op4 }" itemValue="4" />
			</h:selectOneMenu>
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;" width="100%" >
			<h:selectOneMenu value="#{controlProtocolos.prSincope.resDecisionclin }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
				<f:selectItem itemLabel="#{ms.prot_sincope_res_decision_clin_op1 }" itemValue="1" />
				<f:selectItem itemLabel="#{ms.prot_sincope_res_decision_clin_op2 }" itemValue="2" />
				<f:selectItem itemLabel="#{ms.prot_sincope_res_decision_clin_op3 }" itemValue="3" />
				<f:selectItem itemLabel="#{ms.prot_sincope_res_decision_clin_op4 }" itemValue="4" />
				<f:selectItem itemLabel="#{ms.prot_sincope_res_decision_clin_op5 }" itemValue="5" />
			</h:selectOneMenu>
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;" width="100%" >
			<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
				showWeeksBar="false" direction="bottom-left" value="#{controlProtocolos.prSincope.resFecha }" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;" width="100%" >
			<h:selectOneMenu value="#{controlProtocolos.prSincope.resOperador }">
				<f:selectItems value="#{controlEef.primerOperador }" />
			</h:selectOneMenu>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid width="100%">
		<h:outputLabel value="#{ms.prot_sincope_res_comentarios }" style="font-weight: bold;"/>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%" >
			<h:inputTextarea cols="200" rows="5" value="#{controlProtocolos.prSincope.resComentarios }" id="protSincResComentarios">
				<f:validateLength maximum="1000" />
			</h:inputTextarea>	
			<h:message for="protSincResComentarios" style="color:red" />
		</h:panelGrid>
	</h:panelGrid>

</ui:composition>
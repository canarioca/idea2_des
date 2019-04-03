<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.regev_tab5_exp_fecha }" style="font-weight: bold;" />
			<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
				showWeeksBar="false" direction="bottom-left"
				value="#{controlRegistrador.registrador.explanteFecha}" />
			<h:outputLabel value="#{ms.regev_tab5_exp_med }" style="font-weight: bold;" />
			<h:selectOneMenu
				value="#{controlRegistrador.registrador.explanteOpmed}"
				style="width:400px;">
				<f:selectItems value="#{controlEef.primerOperador}" />
			</h:selectOneMenu>

			<h:outputLabel value="#{ms.regev_tab5_exp_enf }" style="font-weight: bold;" />
			<h:selectOneMenu
				value="#{controlRegistrador.registrador.explanteOpEnf}"
				style="width:400px;">
				<f:selectItems value="#{controlEef.enfermeras}" />
			</h:selectOneMenu>

			<h:outputLabel value="#{ms.regev_tab5_exp_motivo }" style="font-weight: bold;" />
			<h:selectOneMenu style="width:400px;"
				value="#{controlRegistrador.registrador.explanteDiagnostico}">
				<f:selectItem itemLabel="" itemValue="0" />
				<f:selectItem itemLabel="#{ms.regev_tab5_exp_motivo_op1 }" itemValue="1" />
				<f:selectItem itemLabel="#{ms.regev_tab5_exp_motivo_op2 }" itemValue="2" />
				<f:selectItem itemLabel="#{ms.regev_tab5_exp_motivo_op3 }" itemValue="3" />
				<f:selectItem itemLabel="#{ms.regev_tab5_exp_motivo_op4 }" itemValue="4" />
				<f:selectItem itemLabel="#{ms.regev_tab5_exp_motivo_op5 }" itemValue="5" />
				<f:selectItem itemLabel="#{ms.regev_tab5_exp_motivo_op6 }" itemValue="6" />
				<f:selectItem itemLabel="#{ms.regev_tab5_exp_motivo_op7 }" itemValue="7" />
			</h:selectOneMenu>

		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
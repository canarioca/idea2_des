<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		<h:outputLabel value="#{ms.mesa_tab2_ecg_title2 }"
			style="font-weight: bold;" />
		<h:panelGrid columns="3" width="100%"
			style="border-top: solid 1px;border-color: black;"
			columnClasses="alignTop33,alignTop33,alignTop33">
			<h:outputLabel value="#{ms.mesa_tab2_ecg_ritmo }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.mesa_tab2_ecg_cav }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.mesa_tab2_ecg_qrs }" style="font-weight: bold;" />

			<h:panelGrid id="tablaRitmos"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlMesas.mesa.ecgdto.idritmo }">
					<f:selectItems value="#{controlEef.ritmos }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaCond"
				style="border-top: solid 1px;border-color: black;">
				<a4j:jsFunction name="updecg" reRender="tablaCond" />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_normal }" />
				<h:panelGrid columns="2">
					<rich:spacer width="35px" />
					<h:selectOneRadio layout="pageDirection"
						value="#{controlMesas.mesa.ecgdto.idconduccion }" onclick="updecg();">
						<f:selectItem itemLabel="#{ms.mesa_tab2_ecg_cav_op2 }" itemValue="2" />
						<f:selectItem itemLabel="#{ms.mesa_tab2_ecg_cav_op1 }" itemValue="1" />
					</h:selectOneRadio>
					<rich:spacer width="35px"
						rendered="#{controlMesas.mesa.ecgdto.idconduccion eq 1 }" />
					<h:panelGrid columns="2"
						rendered="#{controlMesas.mesa.ecgdto.idconduccion eq 1 }">
						<rich:spacer width="35px" />
						<h:selectOneMenu value="#{controlMesas.mesa.ecgdto.idconduccionno }">
							<f:selectItems value="#{controlEef.conducciones }" />
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="tablaQrs"
				style="border-top: solid 1px;border-color: black;">
				<a4j:jsFunction name="updecgqrs" reRender="tablaQrs" />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_normal }" />
				<h:panelGrid columns="2">
					<rich:spacer width="35px" />
					<h:selectOneRadio layout="pageDirection" onclick="updecgqrs();"
						value="#{controlMesas.mesa.ecgdto.idqrs}">
						<f:selectItem itemLabel="#{ms.mesa_tab2_ecg_qrs_op2 }" itemValue="2" />
						<f:selectItem itemLabel="#{ms.mesa_tab2_ecg_qrs_op1 }" itemValue="1" />
					</h:selectOneRadio>
					<rich:spacer width="35px"
						rendered="#{controlMesas.mesa.ecgdto.idqrs eq 1 }" />
					<h:panelGrid columns="2"
						rendered="#{controlMesas.mesa.ecgdto.idqrs eq 1 }">
						<rich:spacer width="35px" />
						<h:selectOneMenu value="#{controlMesas.mesa.ecgdto.idqrsno }">
							<f:selectItems value="#{controlEef.qrs }" />
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>

		<a4j:jsFunction name="updqtc" reRender="intervalos"/>
		<h:panelGrid columns="2" width="80%"
			columnClasses="alignTop,alignTop">
			<h:panelGrid></h:panelGrid>
			<h:outputLabel value="#{ms.mesa_tab2_ecg_com }" style="font-weight: bold;" />
			<h:panelGrid width="90%" columns="3" id="intervalos">
				<h:outputLabel value="#{ms.mesa_tab2_ecg_rr }" />
				<h:inputText size="8" maxlength="5"
					value="#{controlMesas.mesa.ecgdto.rr }" />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_ms }." />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_pr }" />
				<h:inputText size="8" maxlength="5"
					value="#{controlMesas.mesa.ecgdto.pr }" />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_ms }." />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_qrs }" />
				<h:inputText size="8" maxlength="5"
					value="#{controlMesas.mesa.ecgdto.qrs }" />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_ms }." />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_qt }" />
				<h:inputText size="8" maxlength="5"
					value="#{controlMesas.mesa.ecgdto.qt }"
					onblur="updqtc();" />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_ms }." />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_qtc }" />
				<h:inputText size="8" readonly="true"
					value="#{controlMesas.mesa.ecgdto.qtc }" />
				<h:outputLabel value="#{ms.mesa_tab2_ecg_ms }." />
			</h:panelGrid>
			<h:panelGrid width="90%"
				style="border-top: solid 1px;border-color: black;">
				<h:inputTextarea cols="80" rows="5" id="comentariosMesaEcg"
					value="#{controlMesas.mesa.ecgdto.comentarios }" >
					<f:validateLength maximum="2000" />
				</h:inputTextarea>	
				<h:message for="comentariosMesaEcg" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
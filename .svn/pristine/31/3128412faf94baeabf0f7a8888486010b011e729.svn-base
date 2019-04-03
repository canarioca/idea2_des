<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		<h:outputLabel value="#{ms.testfarma_ecg_title2 }"
			style="font-weight: bold;" />
		<h:panelGrid columns="3" width="100%"
			style="border-top: solid 1px;border-color: black;"
			columnClasses="alignTop33,alignTop33,alignTop33">
			<h:outputLabel value="#{ms.testfarma_ecg_ritmo }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.testfarma_ecg_cav }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.testfarma_ecg_qrs }" style="font-weight: bold;" />

			<h:panelGrid id="tablaRitmos"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlTest.fle.ecgdto.idritmo }">
					<f:selectItems value="#{controlEef.ritmos }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaCond"
				style="border-top: solid 1px;border-color: black;">
				<a4j:jsFunction name="updecg" reRender="tablaCond" />
				<h:outputLabel value="#{ms.testfarma_ecg_normal }" />
				<h:panelGrid columns="2">
					<rich:spacer width="35px" />
					<h:selectOneRadio layout="pageDirection"
						value="#{controlTest.fle.ecgdto.idconduccion }" onclick="updecg();">
						<f:selectItem itemLabel="#{ms.testfarma_ecg_si }" itemValue="2" />
						<f:selectItem itemLabel="#{ms.testfarma_ecg_no }" itemValue="1" />
					</h:selectOneRadio>
					<rich:spacer width="35px"
						rendered="#{controlTest.fle.ecgdto.idconduccion eq 1 }" />
					<h:panelGrid columns="2"
						rendered="#{controlTest.fle.ecgdto.idconduccion eq 1 }">
						<rich:spacer width="35px" />
						<h:selectOneMenu value="#{controlTest.fle.ecgdto.idconduccionno }">
							<f:selectItems value="#{controlEef.conducciones }" />
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="tablaQrs"
				style="border-top: solid 1px;border-color: black;">
				<a4j:jsFunction name="updecgqrs" reRender="tablaQrs" />
				<h:outputLabel value="#{ms.testfarma_ecg_normal }" />
				<h:panelGrid columns="2">
					<rich:spacer width="35px" />
					<h:selectOneRadio layout="pageDirection" onclick="updecgqrs();"
						value="#{controlTest.fle.ecgdto.idqrs}">
						<f:selectItem itemLabel="#{ms.testfarma_ecg_si }" itemValue="2" />
						<f:selectItem itemLabel="#{ms.testfarma_ecg_no }" itemValue="1" />
					</h:selectOneRadio>
					<rich:spacer width="35px"
						rendered="#{controlTest.fle.ecgdto.idqrs eq 1 }" />
					<h:panelGrid columns="2"
						rendered="#{controlTest.fle.ecgdto.idqrs eq 1 }">
						<rich:spacer width="35px" />
						<h:selectOneMenu value="#{controlTest.fle.ecgdto.idqrsno }">
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
			<h:outputLabel value="#{ms.testfarma_ecg_com }" style="font-weight: bold;" />
			<h:panelGrid width="90%" columns="3" id="intervalos">
				<h:outputLabel value="#{ms.testfarma_ecg_rr }" />
				<h:inputText size="8" maxlength="5"
					value="#{controlTest.fle.ecgdto.rr }" />
				<h:outputLabel value="#{ms.testfarma_ecg_ms }." />
				<h:outputLabel value="#{ms.testfarma_ecg_pr }" />
				<h:inputText size="8" maxlength="5"
					value="#{controlTest.fle.ecgdto.pr }" />
				<h:outputLabel value="#{ms.testfarma_ecg_ms }." />
				<h:outputLabel value="#{ms.testfarma_ecg_qrs }" />
				<h:inputText size="8" maxlength="5"
					value="#{controlTest.fle.ecgdto.qrs }" />
				<h:outputLabel value="#{ms.testfarma_ecg_ms }." />
				<h:outputLabel value="#{ms.testfarma_ecg_qt }" />
				<h:inputText size="8" maxlength="5"
					value="#{controlTest.fle.ecgdto.qt }"
					onblur="updqtc();" />
				<h:outputLabel value="#{ms.testfarma_ecg_ms }." />
				<h:outputLabel value="#{ms.testfarma_ecg_qtc }" />
				<h:inputText size="8" readonly="true"
					value="#{controlTest.fle.ecgdto.qtc }" />
				<h:outputLabel value="#{ms.testfarma_ecg_ms }." />
			</h:panelGrid>
			<h:panelGrid width="90%"
				style="border-top: solid 1px;border-color: black;">
				<h:inputTextarea cols="80" rows="5" id="comentariosFleEcg"
					value="#{controlTest.fle.ecgdto.comentarios }" >
					<f:validateLength maximum="2000" />
				</h:inputTextarea>	
				<h:message for="comentariosFleEcg" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
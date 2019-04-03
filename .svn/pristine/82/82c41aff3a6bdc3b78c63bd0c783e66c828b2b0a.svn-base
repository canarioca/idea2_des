<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid cellpadding="0" cellspacing="0" id="pantaq" width="100%">
		<a4j:jsFunction name="updtaq" reRender="pantaq,panta" />
		<h:panelGrid columns="3" width="100%">
			<h:outputLabel value="#{ms.eef_tab_taq_tab_taq_ind }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.eef_tab_taq_tab_taq_longcicl }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.eef_tab_taq_tab_taq_morfo }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaInduccion">
				<h:selectOneRadio onclick="updtaq();"
					value="#{controlEef.eef.taquicardidto.induccion }">
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_ind_op1 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_ind_op2 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_ind_op3 }" itemValue="3" />
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_ind_op4 }" itemValue="4" />
				</h:selectOneRadio>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText size="5" maxlength="3" value="#{controlEef.eef.taquicardidto.longciclo }"/>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlEef.eef.taquicardidto.morfologia }">
					<f:selectItems value="#{controlEef.morfologias }" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>

		<rich:spacer height="10px"
			rendered="#{controlEef.eef.taquicardidto.induccion eq 3 || controlEef.eef.taquicardidto.induccion eq 4}" />

		<h:panelGrid
			rendered="#{controlEef.eef.taquicardidto.induccion eq 3 || controlEef.eef.taquicardidto.induccion eq 4}">
			<h:outputLabel value="#{ms.eef_tab_taq_tab_taq_taquiindu }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaInduc" columns="2" cellpadding="0" cellspacing="0">
				<h:selectOneRadio value="#{controlEef.eef.taquicardidto.taquiindu }">
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_taquiindu_op1 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_taquiindu_op2 }" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>

		<rich:spacer height="10px"
			rendered="#{controlEef.eef.taquicardidto.induccion eq 3 || controlEef.eef.taquicardidto.induccion eq 4}" />

		<h:panelGrid
			rendered="#{controlEef.eef.taquicardidto.induccion eq 3 || controlEef.eef.taquicardidto.induccion eq 4}">
			<h:outputLabel value="#{ms.eef_tab_taq_tab_taq_comport }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaComporta">
				<h:selectOneRadio
					value="#{controlEef.eef.taquicardidto.comportamiento }">
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_comport_op1 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_comport_op2 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_comport_op3 }" itemValue="3" />
					<f:selectItem itemLabel="#{ms.eef_tab_taq_tab_taq_comport_op4 }" itemValue="4" />
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>

		<rich:spacer height="10px"
			rendered="#{controlEef.eef.taquicardidto.induccion eq 3 || controlEef.eef.taquicardidto.induccion eq 4}" />

		<a4j:jsFunction name="recargan2" reRender="tipotaqui,panta"/>
		<h:panelGrid id="tipotaqui"
			rendered="#{controlEef.eef.taquicardidto.induccion eq 3 || controlEef.eef.taquicardidto.induccion eq 4}">
			<h:outputLabel value="#{ms.eef_tab_taq_tab_taq_tipo }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlEef.eef.taquicardidto.idn1 }"
					onchange="recargan2();">
					<f:selectItems value="#{controlEef.tipoTaquicardias }"/>
				</h:selectOneMenu>
				<h:panelGrid cellpadding="0" cellspacing="0" columns="2" rendered="#{controlEef.tipoTaquicardiasN2 ne null }">
					<rich:spacer width="15px"/>
					<h:selectOneMenu value="#{controlEef.eef.taquicardidto.idn2 }"
						onchange="recargan2();">
						<f:selectItems value="#{controlEef.tipoTaquicardiasN2 }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid cellpadding="0" cellspacing="0" columns="2" rendered="#{controlEef.tipoTaquicardiasN3 ne null }">
					<rich:spacer width="30px"/>
					<h:selectOneMenu value="#{controlEef.eef.taquicardidto.idn3 }">
						<f:selectItems value="#{controlEef.tipoTaquicardiasN3 }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
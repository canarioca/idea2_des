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

	<h:outputText value="Historia clínica" style="font-weight:bold;" />
	<h:panelGrid width="100%"
		style="border-top: solid 1px;border-color: black;">
		<h:panelGrid columns="2">
			<h:outputText value="FEVI (%)"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:outputText value="Función Ventricular"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText size="6" maxlength="6"
					value="#{controlPacientes.filtro.hclin.fevi }" />
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="2">
				<h:inputText id="funcVentri" size="50"
					value="#{controlPacientes.filtro.hclin.funcion }" />
				<h:graphicImage value="/img/iconos/arrow.png"
					onclick="#{rich:component('suggestionFunVentri')}.callSuggestion(true)"
					alt="" />
			</h:panelGrid>
			<rich:suggestionbox id="suggestionFunVentri" for="funcVentri"
				suggestionAction="#{controlPacientes.autocompletarFV}"
				ajaxSingle="false" var="result" zindex="5000" width="270"
				height="120" nothingLabel="No se encontró nada">
				<h:column>
					<h:outputText value="#{result.valor}" />
				</h:column>
			</rich:suggestionbox>
		</h:panelGrid>

		<h:panelGrid columns="2" width="100%"
			columnClasses="alignTop,alignTop">
			<h:panelGrid id="tablaFactores" width="80%">
				<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%">
					<f:facet name="header">
						<h:outputText value="Factores de riesgo cardiovascular" />
					</f:facet>
				</t:dataTable>
				<h:panelGrid columns="2">
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox
							value="#{controlPacientes.filtro.hclin.htab }" />
						<h:outputLabel value="HTA" />
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox
							value="#{controlPacientes.filtro.hclin.diabetesb }" />
						<h:outputLabel value="Diabetes Mellitus" />
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox
							value="#{controlPacientes.filtro.hclin.dislipemiab }" />
						<h:outputLabel value="Dislipemia" />
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox
							value="#{controlPacientes.filtro.hclin.tabaquismob }" />
						<h:outputLabel value="Tabaquismo" />
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="tablaAntecedentes" width="80%">
				<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%">
					<f:facet name="header">
						<h:outputText value="Antecedentes no cardiológicos" />
					</f:facet>
				</t:dataTable>
				<h:panelGrid columns="2">
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox
							value="#{controlPacientes.filtro.hclin.acvb }" />
						<h:outputLabel value="ACV" />
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox
							value="#{controlPacientes.filtro.hclin.saosb }" />
						<h:outputLabel value="SAOS / EPOC" />
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox
							value="#{controlPacientes.filtro.hclin.insufb }" />
						<h:outputLabel value="Insuficiencia renal" />
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox
							value="#{controlPacientes.filtro.hclin.afectab }" />
						<h:outputLabel value="Afectación tiroidea" />
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="tablaCardiopatia" width="100%">
			<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%">
				<f:facet name="header">
					<h:outputText value="Cardiopatía" />
				</f:facet>
			</t:dataTable>
			<a4j:jsFunction name="updatecardio" reRender="tablaCardiopatia" />
			<h:panelGrid columns="2" width="100%" columnClasses="alignTop,alignTop">
				<h:panelGrid cellpadding="0" cellspacing="0">
					<h:selectOneRadio layout="lineDirection"
						value="#{controlPacientes.filtro.hclin.idcardio }"
						onclick="updatecardio();">
						<f:selectItem itemValue="1" itemLabel="No" />
						<f:selectItem itemValue="2" itemLabel="Si" />
					</h:selectOneRadio>

					<h:panelGrid cellspacing="0"
						rendered="#{controlPacientes.filtro.hclin.idcardio eq 2 }">
						<h:selectOneMenu value="#{controlPacientes.filtro.hclin.tipocardio }"
							onchange="updatecardio();">
							<f:selectItem itemValue="0" itemLabel="(Seleccione opción)" />
							<f:selectItem itemValue="1" itemLabel="Isquémica" />
							<f:selectItem itemValue="2" itemLabel="Dilatada" />
							<f:selectItem itemValue="3" itemLabel="Sospecha taquimiopatía" />
							<f:selectItem itemValue="4" itemLabel="Hipertrófica" />
							<f:selectItem itemValue="5" itemLabel="Displasia VD" />
							<f:selectItem itemValue="6" itemLabel="No compactada" />
							<f:selectItem itemValue="7" itemLabel="Congénita" />
							<f:selectItem itemValue="8" itemLabel="Cirugía cardiaca previa" />
							<f:selectItem itemValue="9" itemLabel="Valvular" />
							<f:selectItem itemValue="10" itemLabel="Otras" />
						</h:selectOneMenu>
						<h:panelGrid columns="2" cellspacing="0"
							rendered="#{controlPacientes.filtro.hclin.tipocardio eq 1}">
							<rich:spacer width="20px" />
							<h:selectOneRadio layout="pageDirection"
								value="#{controlPacientes.filtro.hclin.idisquemica}"
								onclick="updatecardio();">
								<f:selectItem itemValue="1" itemLabel="Sin infarto" />
								<f:selectItem itemValue="2" itemLabel="Con infarto" />
							</h:selectOneRadio>
						</h:panelGrid>
						<h:panelGrid columns="3" cellspacing="0"
							rendered="#{controlPacientes.filtro.hclin.tipocardio eq 1 &amp;&amp; controlPacientes.filtro.hclin.idisquemica eq 2 }">
							<rich:spacer width="50px" />
							<h:outputLabel value="Localización" />
							<h:inputText size="60"
								value="#{controlPacientes.filtro.hclin.localizacion }" />
						</h:panelGrid>
						<h:panelGrid columns="2" cellspacing="0"
							rendered="#{controlPacientes.filtro.hclin.tipocardio eq 7}">
							<rich:spacer width="20px" />
							<h:inputText size="60"
								value="#{controlPacientes.filtro.hclin.congenitastr }" />
						</h:panelGrid>
						<h:panelGrid columns="2" cellspacing="0" rendered="#{controlPacientes.filtro.hclin.tipocardio eq 8}">
							<rich:spacer width="20px" />
							<h:selectOneRadio layout="lineDirection"
								value="#{controlPacientes.filtro.hclin.idcircardia }">
								<f:selectItem itemValue="1" itemLabel="Coronaria" />
								<f:selectItem itemValue="2" itemLabel="Valvular" />
								<f:selectItem itemValue="3" itemLabel="Otra" />
							</h:selectOneRadio>
						</h:panelGrid>
						<h:panelGrid columns="2" cellspacing="0"
							rendered="#{controlPacientes.filtro.hclin.tipocardio eq 10}">
							<rich:spacer width="20px" />
							<h:inputText size="60"
								value="#{controlPacientes.filtro.hclin.otrasstr }" />
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
				<h:inputTextarea cols="80" rows="8" value="#{controlPacientes.filtro.hclin.texto }"/>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid columns="2" cellpadding="0" cellspacing="0" width="100%"
		columnClasses="alignTop,alignTop">
		<h:outputLabel value="#{ms.eef_tab_cav_medbas }" style="font-weight: bold;" />
		<h:outputLabel value="#{ms.eef_tab_cav_fisio_dob }"
			style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="90%" columns="2">
			<h:panelGrid columns="3">
				<h:outputLabel value="#{ms.eef_tab_cav_ah }" />
				<h:inputText size="4" maxlength="4" value="#{controlEef.eef.conducciondto.ah }"/>
				<h:outputLabel value="#{ms.eef_tab_cav_ms }." />
			</h:panelGrid>
			<h:panelGrid columns="3">
				<h:outputLabel value="#{ms.eef_tab_cav_hv }" />
				<h:inputText size="4" maxlength="4" value="#{controlEef.eef.conducciondto.hv }" />
				<h:outputLabel value="#{ms.eef_tab_cav_ms }." />
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="90%">
			<h:selectOneMenu  value="#{controlEef.eef.conducciondto.fisiologia }">
				<f:selectItems value="#{controlEef.fisiologias }" />
			</h:selectOneMenu>
		</h:panelGrid>
	</h:panelGrid>

	<rich:spacer height="10" />

	<h:panelGrid width="100%">
		<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
			<h:outputLabel value="#{ms.eef_tab_cav_ec }"
				style="font-weight: bold;" />
			<a4j:commandLink reRender="tablaEstimulacion" actionListener="#{controlEef.eef.conducciondto.addEstim }">
				<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
					style="border:0;" title="#{ms.eef_tab_cav_ec_add }" />
			</a4j:commandLink>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="95%" id="tablaEstimulacion">
			<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
				value="#{controlEef.eef.conducciondto.estim }"
					binding="#{controlEef.eef.conducciondto.binestim }">
				<t:column width="23%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_cav_ec_cond }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.conduc }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.conduccionnodal }" />
						<a4j:support event="onchange" reRender="tablaEstimulacion" ajaxSingle="true"
								actionListener="#{controlEef.controlCAVEstimulacion }"/>
					</h:selectOneMenu>
				</t:column>
				<t:column width="23%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_cav_ec_farma }" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:inputText id="Farav" size="30"
							value="#{linea.farmaco }" />
						<h:graphicImage value="/img/iconos/arrow.png"
							onclick="#{rich:component('suggestionBoxFarmacoav')}.callSuggestion(true)" />
						<rich:suggestionbox id="suggestionBoxFarmacoav"
							for="Farav"
							suggestionAction="#{controlEef.autocompletarFarmacosav}"
							var="result" zindex="50000" width="200" height="100"
							nothingLabel="#{ms.eef_tab_cav_ec_farma_no }">
							<a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender" />
							<h:column>
								<h:outputText value="#{result.valor}"
									style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
							</h:column>
						</rich:suggestionbox>
					</h:panelGrid>
				</t:column>
				<t:column width="23%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_cav_ec_bloq }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.bloqueo }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.bloqueos }" />
					</h:selectOneMenu>
				</t:column>
				<t:column width="23%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_cav_ec_niv_bloq }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.nviel }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.nivelbloqueo }" />
					</h:selectOneMenu>
				</t:column>
				<t:column width="5%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_cav_ms }" />
					</f:facet>
					<h:inputText value="#{linea.msvalor }" maxlength="5"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;"/>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaEstimulacion" actionListener="#{controlEef.eef.conducciondto.delEstim }">
						<h:graphicImage url="/img/iconos/minus.png"
							title="#{ms.eef_tab_cav_ec_del }" width="16" height="16"
							style="border: 0px;" />
					</a4j:commandLink>
				</t:column>
			</t:dataTable>
		</h:panelGrid>
	</h:panelGrid>

	<rich:spacer height="10" />

	<h:panelGrid columns="2" cellpadding="0" cellspacing="0" width="100%"
		columnClasses="alignTop,alignTop">
		<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
			<h:outputLabel value="#{ms.eef_tab_cav_pfarma }"
				style="font-weight: bold;" />
			<a4j:commandLink reRender="tablaPruebasAV" actionListener="#{controlEef.eef.conducciondto.addPrueba }">
				<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
					style="border:0;" title="#{ms.eef_tab_cav_pfarma_add }" />
			</a4j:commandLink>
		</h:panelGrid>
		<h:panelGrid cellpadding="0" cellspacing="0">
			<h:outputLabel value="Comentarios" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="90%" id="tablaPruebasAV">
			<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
				value="#{controlEef.eef.conducciondto.pruebas }"
					binding="#{controlEef.eef.conducciondto.binpru }">
				<t:column width="60%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_cav_pfarma_prueba }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.prueba }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.pruebasav }" />
						<a4j:support event="onchange" reRender="tablaPruebasAV" ajaxSingle="true"
								actionListener="#{controlEef.controlCAVPf }"/>
					</h:selectOneMenu>
				</t:column>
				<t:column width="35%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_cav_pfarma_res }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.resultado }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.resultadosav }" />
						<a4j:support event="onchange" reRender="tablaPruebasAV" ajaxSingle="true"
								actionListener="#{controlEef.controlCAVPf }"/>
					</h:selectOneMenu>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaPruebasAV" actionListener="#{controlEef.eef.conducciondto.delPrueba }">
						<h:graphicImage url="/img/iconos/minus.png"
							title="#{ms.eef_tab_cav_pfarma_del }" width="16" height="16"
							style="border: 0px;" />
					</a4j:commandLink>
				</t:column>
			</t:dataTable>
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.eef_tab_cav_inthv }" />
				<h:inputText size="4" maxlength="4" value="#{controlEef.eef.conducciondto.hv2 }" />
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="90%">
			<h:inputTextarea cols="65" rows="8" value="#{controlEef.eef.conducciondto.comentarios }" id="comentariosEefAv">
				<f:validateLength maximum="2000" />
			</h:inputTextarea>	
			<h:message for="comentariosEefAv" style="color:red" />
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
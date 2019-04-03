<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid columns="3" cellpadding="0" cellspacing="0" width="100%" columnClasses="alignTop,alignTop,alignTop">
		<h:panelGrid width="100%">
			<a4j:jsFunction name="updfs" reRender="trnsc"/>
			<h:outputLabel value="#{ms.eef_tab_fsin_mbasal }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" id="trnsc"
				width="90%" columns="3">
				<h:outputLabel value="#{ms.eef_tab_fsin_ciclosin }" />
				<h:inputText size="4" maxlength="4" value="#{controlEef.eef.sinusaldto.ciclo }"/>
				<h:outputLabel value="#{ms.eef_tab_fsin_ms }." />
				<h:outputLabel value="#{ms.eef_tab_fsin_trns }" />
				<h:inputText size="4" maxlength="4"  value="#{controlEef.eef.sinusaldto.trns }" onblur="updfs();"/>
				<h:outputLabel value="#{ms.eef_tab_fsin_ms }." />
				<h:outputLabel value="#{ms.eef_tab_fsin_trnsc }" />
				<h:inputText size="4" maxlength="4" value="#{controlEef.eef.sinusaldto.trnsc }" />
				<h:outputLabel value="#{ms.eef_tab_fsin_ms }." />
				<h:outputLabel value="#{ms.eef_tab_fsin_trt }" />
				<h:inputText size="4" maxlength="4" value="#{controlEef.eef.sinusaldto.trt }" />
				<h:outputLabel value="#{ms.eef_tab_fsin_ms }." />
				<h:outputLabel value="#{ms.eef_tab_fsin_tcsa }" />
				<h:inputText size="4" maxlength="4" value="#{controlEef.eef.sinusaldto.tcsa }" />
				<h:outputLabel value="#{ms.eef_tab_fsin_ms }." />
			</h:panelGrid>

			<rich:spacer height="10" />

			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.eef_tab_fsin_pfarma }" style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaPruebas" actionListener="#{controlEef.eef.sinusaldto.addPrueba }">
					<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
						style="border:0;" title="#{ms.eef_tab_fsin_pfarma_add }" />
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="90%" id="tablaPruebas">
				<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
					value="#{controlEef.eef.sinusaldto.pruebas }"
					binding="#{controlEef.eef.sinusaldto.binsin }">
					<t:column width="60%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputLabel value="#{ms.eef_tab_fsin_pfarma_prueba }" />
						</f:facet>
						<h:selectOneMenu value="#{linea.prueba }"
							style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
							<f:selectItems value="#{controlEef.pruebasfs }" />
							<a4j:support event="onchange" reRender="tablaPruebas" ajaxSingle="true"
								actionListener="#{controlEef.controlSinusalPf }"/>
						</h:selectOneMenu>
					</t:column>
					<t:column width="35%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputLabel value="#{ms.eef_tab_fsin_pfarma_res }" />
						</f:facet>
						<h:selectOneMenu value="#{linea.resultado }"
							style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
							<f:selectItems value="#{controlEef.resultadosfs }" />
							<a4j:support event="onchange" reRender="tablaPruebas" ajaxSingle="true"
								actionListener="#{controlEef.controlSinusalPf }"/>
						</h:selectOneMenu>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaPruebas" actionListener="#{controlEef.eef.sinusaldto.delPrueba }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eef_tab_fsin_pfarma_del }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
			<h:panelGrid columns="3" cellpadding="0" width="90%">
				<h:outputLabel value="#{ms.eef_tab_fsin_fsin_atrop }"/>
				<h:inputText size="4" value="#{controlEef.eef.sinusaldto.frecatro }" maxlength="4"/>
				<h:outputLabel value="#{ms.eef_tab_fsin_lpm }."/>
				<h:outputLabel value="#{ms.eef_tab_fsin_fsin_intr }"/>
				<h:inputText size="4" value="#{controlEef.eef.sinusaldto.frecint }" maxlength="4"/>
				<h:outputLabel value="#{ms.eef_tab_fsin_lpm }."/>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid width="100%">
			<rich:spacer width="20"/>
		</h:panelGrid>
		
		<h:panelGrid width="100%">
			<a4j:jsFunction name="updpausa" reRender="panhiper"/>
			<h:outputLabel value="#{ms.eef_tab_fsin_hipersen }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="80%" id="panhiper">
				<h:selectOneMenu value="#{controlEef.eef.sinusaldto.hiper }" onchange="updpausa();">
					<f:selectItems value="#{controlEef.hipersensibilidad }" />
				</h:selectOneMenu>
				<h:panelGrid columns="2" cellpadding="0" rendered="#{controlEef.eef.sinusaldto.hiper eq 2 }">
					<h:outputLabel value="#{ms.eef_tab_fsin_pausa }"/>
					<h:inputText size="7" value="#{controlEef.eef.sinusaldto.pausa }"/>
				</h:panelGrid>
			</h:panelGrid>
			
			<rich:spacer height="10"/>
			
			<h:outputLabel value="#{ms.eef_tab_fsin_com }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="80%">
				<h:inputTextarea cols="65" rows="12" value="#{controlEef.eef.sinusaldto.comentarios }" id="comentariosEefSin">
					<f:validateLength maximum="2000" />
				</h:inputTextarea>	
				<h:message for="comentariosEefSin" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
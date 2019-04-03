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
			<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_clin_fecha }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_clin_operador }" style="font-weight: bold;"/>
			<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
				showWeeksBar="false" direction="bottom-left" value="#{controlProtocolos.prSincope.valcar.fecha }" />
			<h:selectOneMenu value="#{controlProtocolos.prSincope.valcar.operador }">
				<f:selectItems value="#{controlEef.primerOperador }" />
			</h:selectOneMenu>
		</h:panelGrid>
		<t:fieldset legend="#{ms.prot_sincope_valoracion_criterios_clin_title }">
			<h:panelGrid columns="4">
				<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.valcar.sincopePicoB }">
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaFactorRiesgo }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_clin_sinc_pico }" />
				<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.valcar.sincopeDecB }">
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaFactorRiesgo }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_clin_sinc_dec }" />
				<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.valcar.afMsB }">
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaFactorRiesgo }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_clin_af }" />
				<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.valcar.dolorToracicoB }">
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaFactorRiesgo }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_clin_dolor }" />
				<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.valcar.palpitacionesB }">
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaFactorRiesgo }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_clin_palp }" />
			</h:panelGrid>
		</t:fieldset>
		<t:fieldset legend="#{ms.prot_sincope_valoracion_criterios_cardiop }">
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_cardiop_estr }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.cardioEstruct }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_cardiop_antec }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.antIsqIcc }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal }" />
				<h:selectOneMenu value="#{controlProtocolos.prSincope.valcar.ecgAnormal }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op1 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op2 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op3 }" itemValue="3" />
					<f:selectItem itemLabel="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op4 }" itemValue="4" />
					<f:selectItem itemLabel="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op5 }" itemValue="5" />
					<f:selectItem itemLabel="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op6 }" itemValue="6" />
					<f:selectItem itemLabel="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op7 }" itemValue="7" />
					<f:selectItem itemLabel="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op8 }" itemValue="8" />
					<f:selectItem itemLabel="#{ms.prot_sincope_valoracion_criterios_cardiop_ecg_anormal_op9 }" itemValue="9" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneMenu>
			</h:panelGrid>
		</t:fieldset>
		<t:fieldset legend="#{ms.prot_sincope_valoracion_criterios_hallazgos_title }">
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_brad }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallBradi }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_bav }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallBav }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_br }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallBr }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_tsv }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallTsv }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_tvns }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallTvns }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_mp }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallMpdai }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_ecg }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallEcg }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_est }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallEsten}">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_hta }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallHtapulm }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_emb }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallEmbol }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_dis }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallDisec }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.prot_sincope_valoracion_criterios_hallazgos_mix }" />
				<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.valcar.hallMix }">
					<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
					<a4j:support event="onchange" reRender="panProtSincopeInfo" ajaxSingle="true"
						actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</t:fieldset>
		<h:panelGrid>
			<h:outputLabel value="#{ms.prot_sincope_valoracion_comentarios }" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%" >
				<h:inputTextarea cols="200" rows="5" value="#{controlProtocolos.prSincope.valcar.comentarios }" id="protSincValComentarios">
					<f:validateLength maximum="1000" />
				</h:inputTextarea>	
				<h:message for="protSincValComentarios" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>

</ui:composition>
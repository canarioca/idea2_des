<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">

	<h:panelGrid columns="3" width="100%"
		columnClasses="alignTop,alignTop,alignTop">
		<h:outputLabel value="#{ms.eef_tab_plantilla_proc }" style="font-weight: bold;" />
		<h:outputLabel value="#{ms.eef_tab_plantilla_motivo }" style="font-weight: bold;" />
		<h:outputLabel value="#{ms.eef_tab_plantilla_hallaz }"
			style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="panNumProc">
			<a4j:jsFunction name="updatenumproc" reRender="panNumProc" />
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:selectOneMenu value="#{controlEef.eef.nproc.idproc }"
					onchange="updatenumproc();">
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_prim }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_otro }" itemValue="2" />
				</h:selectOneMenu>
				<h:inputText size="5" maxlength="3" readonly="true"
					rendered="#{controlEef.eef.nproc.idproc eq 2 }"
					value="#{controlEef.eef.nproc.numproc }" />
					
			</h:panelGrid>
			<h:selectOneMenu onchange="updatenumproc();"
				rendered="#{controlEef.eef.nproc.idproc eq 2 }"
				value="#{controlEef.eef.nproc.idmotivo }">
				<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_otro_op1 }" itemValue="1" />
				<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_otro_op2 }" itemValue="2" />
				<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_otro_op3 }" itemValue="3" />
				<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_otro_op4 }" itemValue="4" />
			</h:selectOneMenu>
			<h:selectOneMenu value="#{controlEef.eef.nproc.ideef }"
				rendered="#{controlEef.eef.nproc.idproc eq 2 &amp;&amp; controlEef.eef.nproc.idmotivo eq 4 }">
				<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_otro_op4_op1 }" itemValue="1" />
				<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_otro_op4_op2 }" itemValue="2" />
				<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_otro_op4_op3 }" itemValue="3" />
				<f:selectItem itemLabel="#{ms.eef_tab_plantilla_proc_otro_op4_op4 }" itemValue="4" />
			</h:selectOneMenu>
			<h:outputLabel value="#{ms.eef_tab_plantilla_eef_anterior }" rendered="#{controlEef.eef.nproc.idproc eq 2 }"/>
			<h:inputText value="#{controlEef.eef.eefanterior }" rendered="#{controlEef.eef.nproc.idproc eq 2 }"
				size="30" maxlength="40"/>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;">
			<h:inputTextarea cols="50" rows="5" value="#{controlEef.eef.motivo }" id="comentariosEefMot">
				<f:validateLength maximum="2500" />
			</h:inputTextarea>	
			<h:message for="comentariosEefMot" style="color:red" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="panHallazgos">
			<h:inputTextarea cols="80" rows="5"
				value="#{controlEef.eef.hallazgos }" id="comentariosEefHall">
				<f:validateLength maximum="5000" />
			</h:inputTextarea>	
			<h:message for="comentariosEefHall" style="color:red" />
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid columns="2" columnClasses="alignTop,alignTop" id="panEefTipoDiag">
		<h:panelGrid>
			<h:outputLabel value="#{ms.eef_tab_plantilla_diagn }" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlEef.eef.diagnostico }">
					<f:selectItems value="#{controlEef.diagnosticos }" />
					<a4j:support event="onchange" reRender="panEefTipoDiag" ajaxSingle="true"
						actionListener="#{controlEef.cambiaDiagnostico }"/>
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid>
			<h:outputLabel value="#{ms.eef_tab_plantilla_diagn_tipo }" style="font-weight: bold;" rendered="#{controlEef.eef.diagnostico eq controlEef.TAQUIARR_AUR }"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" id="panEefTipoDiag2"
				rendered="#{controlEef.eef.diagnostico eq controlEef.TAQUIARR_AUR }">
				<h:selectOneMenu value="#{controlEef.eef.tipoDiag1 }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_diagn_tipo_op1 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_diagn_tipo_op2 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_diagn_tipo_op3 }" itemValue="3" />
					<a4j:support event="onchange" reRender="panEefTipoDiag2" ajaxSingle="true"/>
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlEef.eef.tipoDiag2 }" rendered="#{controlEef.eef.tipoDiag1 eq 1}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_diagn_tipo_op1_op1 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_diagn_tipo_op1_op2 }" itemValue="2" />					
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlEef.eef.tipoDiag2 }" rendered="#{controlEef.eef.tipoDiag1 eq 3}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_diagn_tipo_op3_op1 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_diagn_tipo_op3_op2 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.eef_tab_plantilla_diagn_tipo_op3_op3 }" itemValue="3" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<rich:spacer height="10px"/>
	
	<rich:spacer height="10px"/>
	<a4j:jsFunction name="actualizaEstudios" reRender="panEef" />
	<h:panelGrid columns="3" width="100%"
		columnClasses="alignTop,alignTop,alignTop">
		<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio }" style="font-weight: bold;" />
		<h:outputLabel value="#{ms.eef_tab_plantilla_interes }" style="font-weight: bold;" />
		<h:outputLabel value="#{ms.eef_tab_plantilla_duracion } #{controlEef.eef.duracion }"
			style="font-weight: bold;" />

		<h:panelGrid cellpadding="0" cellspacing="0">
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="3" columnClasses="alignTop,alignTop,alignTop">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlEef.eef.ecgb }"
						onclick="actualizaEstudios();" />
					<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio_ecg }" />
					<h:selectBooleanCheckbox value="#{controlEef.eef.sinusalb }"
						onclick="actualizaEstudios();"/>
					<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio_fsin }" />
					<h:selectBooleanCheckbox value="#{controlEef.eef.taquicardiasb }"
						onclick="actualizaEstudios();" />
					<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio_taq }" />
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlEef.eef.conduccionb }"
						onclick="actualizaEstudios();" />
					<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio_cav }" />
					<h:selectBooleanCheckbox value="#{controlEef.eef.viasb }"
						onclick="actualizaEstudios();" />
					<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio_vacc }" />
					<h:selectBooleanCheckbox value="#{controlEef.eef.periodosb }"
						onclick="actualizaEstudios();" />
					<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio_pref }" />
				</h:panelGrid>
				<h:panelGrid columns="2" >
					<h:selectBooleanCheckbox value="#{controlEef.eef.complicacionesb }"
						onclick="actualizaEstudios();" />
					<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio_compdiag }" />
					<h:selectBooleanCheckbox value="#{controlEef.eef.ablb }"
							onclick="actualizaEstudios();" />
					<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio_abl }" />
				</h:panelGrid>		
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.eef_tab_plantilla_partes_estudio_abl }" style="font-weight: bold;" rendered="#{controlEef.eef.ablb eq true}"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneRadio layout="pageDirection" rendered="#{controlEef.eef.ablb eq true}"
						onclick="actualizaEstudios();" value="#{controlEef.eef.ablacion }">
						<f:selectItem itemLabel="#{ms.eef_tab_plantilla_partes_estudio_abl_intento }"
							itemValue="1" />
						<f:selectItem itemLabel="#{ms.eef_tab_plantilla_partes_estudio_abl_real }"
							itemValue="2" />
					</h:selectOneRadio>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.eef_tab_plantilla_tipo_proc }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlEef.eef.tipoProcedimiento }">
						<f:selectItems value="#{controlEef.tipoProcedimientos }"  />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;">
			<h:selectOneMenu value="#{controlEef.eef.interes }">
				<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
				<f:selectItem itemValue="0" itemLabel="#{ms.eef_tab_plantilla_interes_op0 }" />
				<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_plantilla_interes_op1 }" />
				<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_plantilla_interes_op2 }" />
				<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_plantilla_interes_op3 }" />
				<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_plantilla_interes_op4 }" />
				<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_plantilla_interes_op5 }" />
				<f:selectItem itemValue="6" itemLabel="#{ms.eef_tab_plantilla_interes_op6 }" />
			</h:selectOneMenu>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="true"
			columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
			<h:outputLabel value="#{ms.eef_tab_plantilla_duracion_hllegada }" />
			<rich:inputNumberSpinner value="#{controlEef.eef.hllegadah }" step="1" maxValue="23" minValue="00" inputSize="2"/>
			<h:outputLabel value=":" />
			<rich:inputNumberSpinner value="#{controlEef.eef.hllegadam }" step="1" maxValue="59" minValue="00" inputSize="2"/>
			<h:outputLabel value="#{ms.eef_tab_plantilla_duracion_hpuncion }" />
			<rich:inputNumberSpinner value="#{controlEef.eef.hpuncionh }" step="1" maxValue="23" minValue="00" inputSize="2"/>
			<h:outputLabel value=":" />
			<rich:inputNumberSpinner  value="#{controlEef.eef.hpuncionm }" step="1" maxValue="59" minValue="00" inputSize="2"/>
			<h:outputLabel value="#{ms.eef_tab_plantilla_duracion_hablac }" />
			<rich:inputNumberSpinner value="#{controlEef.eef.hablacionh }" step="1" maxValue="23" minValue="00" inputSize="2"/>
			<h:outputLabel value=":" />
			<rich:inputNumberSpinner value="#{controlEef.eef.hablacionm }" step="1" maxValue="59" minValue="00" inputSize="2"/>
			<h:outputLabel value="#{ms.eef_tab_plantilla_duracion_hcateteres }" />
			<rich:inputNumberSpinner value="#{controlEef.eef.hcateterh }" step="1" maxValue="23" minValue="00" inputSize="2"/>
			<h:outputLabel value=":" />
			<rich:inputNumberSpinner value="#{controlEef.eef.hcateterm }" step="1" maxValue="59" minValue="00" inputSize="2"/>
			<h:outputLabel value="#{ms.eef_tab_plantilla_duracion_hsalida }" />
			<rich:inputNumberSpinner value="#{controlEef.eef.hsalidah }" step="1" maxValue="23" minValue="00" inputSize="2"/>
			<h:outputLabel value=":" />
			<rich:inputNumberSpinner value="#{controlEef.eef.hsalidam }" step="1" maxValue="59" minValue="00" inputSize="2"/>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="false"
			columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
			<h:outputLabel value="Hora llegada paciente" />
			<h:inputText size="2" value="#{controlEef.eef.hllegadah }" maxlength="2"/>
			<h:outputLabel value=":" />
			<h:inputText size="2" value="#{controlEef.eef.hllegadam }" maxlength="2"/>
			<h:outputLabel value="Hora inicio punciones" />
			<h:inputText size="2" value="#{controlEef.eef.hpuncionh }" maxlength="2"/>
			<h:outputLabel value=":" />
			<h:inputText size="2" value="#{controlEef.eef.hpuncionm }" maxlength="2"/>
			<h:outputLabel value="Hora ablación" />
			<h:inputText size="2" value="#{controlEef.eef.hablacionh }" maxlength="2"/>
			<h:outputLabel value=":" />
			<h:inputText size="2" value="#{controlEef.eef.hablacionm }" maxlength="2"/>
			<h:outputLabel value="Hora retirada catéteres" />
			<h:inputText size="2" value="#{controlEef.eef.hcateterh }" maxlength="2"/>
			<h:outputLabel value=":" />
			<h:inputText size="2" value="#{controlEef.eef.hcateterm }" maxlength="2"/>
			<h:outputLabel value="Hora salida paciente" />
			<h:inputText size="2" value="#{controlEef.eef.hsalidah }" maxlength="2"/>
			<h:outputLabel value=":" />
			<h:inputText size="2" value="#{controlEef.eef.hsalidam }" maxlength="2"/>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid>
		<rich:simpleTogglePanel switchType="client" label="#{ms.eef_tab_plantilla_recom }" opened="false">
			<h:panelGrid>
				<h:inputTextarea cols="200" rows="11" value="#{controlEef.eef.recomendaciones }" id="recomendacionesEF">
					<f:validateLength maximum="2000" />
				</h:inputTextarea>
				<h:message for="recomendacionesEF" style="color:red" />			
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:panelGrid>
	
	
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">

	<h:panelGrid id="panEditItemComplicacionesPacEefAbl" >
		<h:panelGrid width="70%" cellspacing="0" id="pancompablEdit2">
			<a4j:jsFunction name="updatecompablEdit2" reRender="pancompablEdit2" />
			<h:outputLabel value="#{ms.eef_tab_abl_tac_compl_relacion_con }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="78%">
				<h:selectOneMenu
					value="#{controlEef.currentItemAblComp.idprocedimiento }" onchange="updatecompablEdit2();">
					<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tac_compl_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tac_compl_op2 }" />
				</h:selectOneMenu>
				<h:selectOneMenu
					value="#{controlEef.currentItemAblComp.idlugar }"
					rendered="#{controlEef.currentItemAblComp.idprocedimiento eq 1 }">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op3 }" />
					<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op4 }" />
					<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op5 }" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="panEditComplicacionPacEefAbl" width="100%" columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
			<h:outputLabel value="#{ms.compli_compl }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_tipo }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_fechaini }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_fechafin }" style="font-weight: bold;"/>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panEditComPacCompliEefAbl">
				<h:selectOneMenu value="#{controlEef.currentItemAblComp.compabl.complicacion }">
					<f:selectItems value="#{controlComplicaciones.complicacionesEefAbl }" />
					<a4j:support event="onchange" reRender="panEditComPacCompliEefAbl" ajaxSingle="true" />						
				</h:selectOneMenu>
				<h:inputText value="#{controlEef.currentItemAblComp.compabl.complicacionOtra }" 
					rendered="#{controlEef.currentItemAblComp.compabl.complicacion eq controlComplicaciones.idcompotra}"/>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
				<h:selectOneMenu value="#{controlEef.currentItemAblComp.compabl.tipo }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_tipo_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_tipo_2 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.compli_tipo_3 }"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
					showWeeksBar="false" direction="bottom-left" 
					value="#{controlEef.currentItemAblComp.compabl.fechaini }" />
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
					showWeeksBar="false" direction="bottom-left" 
					value="#{controlEef.currentItemAblComp.compabl.fechafin }" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.compli_resuelta }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_tratamiento }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_ingreso }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_descripcion }" style="font-weight: bold;"/>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
				<h:selectOneMenu value="#{controlEef.currentItemAblComp.compabl.resuelta }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="0" itemLabel="#{ms.compli_resuelta_0 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_resuelta_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_resuelta_2 }"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panEditComPacTratEefAbl">								
				<h:selectOneMenu value="#{controlEef.currentItemAblComp.compabl.tratamiento }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="0" itemLabel="#{ms.compli_tratamiento_0 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_tratamiento_1 }"/>
					<a4j:support event="onchange" reRender="panEditComPacTratEefAbl" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:inputText value="#{controlEef.currentItemAblComp.compabl.tratamientoDescr }" 
					rendered="#{controlEef.currentItemAblComp.compabl.tratamiento eq 1}"/>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
				<h:selectOneMenu value="#{controlEef.currentItemAblComp.compabl.ingreso }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="0" itemLabel="#{ms.compli_ingreso_0 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_ingreso_1 }"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<h:inputTextarea cols="40" rows="4" value="#{controlEef.currentItemAblComp.compabl.descripcion }" id="descEditComPacEefAbl">
					<f:validateLength maximum="1000" />
				</h:inputTextarea>	
				<h:message for="descEditComPacEefAbl" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
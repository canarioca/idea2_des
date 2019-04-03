<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">

	<h:panelGrid id="panEditItemComplicacionesPacRegEv" >
		<h:panelGrid id="panEditComplicacionPacRegEv" width="100%" columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
			<h:outputLabel value="#{ms.compli_compl }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_tipo }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_fechaini }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_fechafin }" style="font-weight: bold;"/>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panEditComPacCompliRegEv">
				<h:selectOneMenu value="#{controlRegistrador.currentItemComp.complicacion }">
					<f:selectItems value="#{controlComplicaciones.complicacionesImpl }" />
					<a4j:support event="onchange" reRender="panEditComPacCompliRegEv" ajaxSingle="true" />						
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlRegistrador.currentItemComp.complicacion1 }" 
					rendered="#{controlRegistrador.currentItemComp.complicacion eq  controlComplicaciones.idarritmias}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_arritmias_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_arritmias_2 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_arritmias_3 }"/>
					<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_arritmias_4 }"/>
					<f:selectItem itemValue="5" itemLabel="#{ms.compli_compl_arritmias_5 }"/>
					<f:selectItem itemValue="6" itemLabel="#{ms.compli_compl_arritmias_6 }"/>
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlRegistrador.currentItemComp.complicacion1 }" 
					rendered="#{controlRegistrador.currentItemComp.complicacion eq controlComplicaciones.idhematoma}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_hematoma_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_hematoma_2 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_hematoma_3 }"/>
				</h:selectOneMenu>
				<h:inputText value="#{controlRegistrador.currentItemComp.complicacionOtra }" 
					rendered="#{controlRegistrador.currentItemComp.complicacion eq controlComplicaciones.idcompotra}"/>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
				<h:selectOneMenu value="#{controlRegistrador.currentItemComp.tipo }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_tipo_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_tipo_2 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.compli_tipo_3 }"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
					showWeeksBar="false" direction="bottom-left" 
					value="#{controlRegistrador.currentItemComp.fechaini }" />
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
					showWeeksBar="false" direction="bottom-left" 
					value="#{controlRegistrador.currentItemComp.fechafin }" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.compli_resuelta }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_tratamiento }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_ingreso }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_descripcion }" style="font-weight: bold;"/>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
				<h:selectOneMenu value="#{controlRegistrador.currentItemComp.resuelta }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="0" itemLabel="#{ms.compli_resuelta_0 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_resuelta_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_resuelta_2 }"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panEditComPacTratRegEv">								
				<h:selectOneMenu value="#{controlRegistrador.currentItemComp.tratamiento }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="0" itemLabel="#{ms.compli_tratamiento_0 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_tratamiento_1 }"/>
					<a4j:support event="onchange" reRender="panEditComPacTratRegEv" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:inputText value="#{controlRegistrador.currentItemComp.tratamientoDescr }" 
					rendered="#{controlRegistrador.currentItemComp.tratamiento eq 1}"/>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
				<h:selectOneMenu value="#{controlRegistrador.currentItemComp.ingreso }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="0" itemLabel="#{ms.compli_ingreso_0 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_ingreso_1 }"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<h:inputTextarea cols="40" rows="4" value="#{controlRegistrador.currentItemComp.descripcion }" id="descEditComPacRegEv">
					<f:validateLength maximum="1000" />
				</h:inputTextarea>	
				<h:message for="descEditComPacRegEv" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
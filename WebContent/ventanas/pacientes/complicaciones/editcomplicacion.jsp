<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">

	<h:panelGrid id="panEditItemComplicacionesPac" >
		<h:panelGrid width="100%">
			<h:outputLabel value="#{ms.compli_relacion_proc_title }" style="font-weight: bold;"/>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.idrelacion }">
					<f:selectItems value="#{controlComplicaciones.modulosDisponibles }" />
					<a4j:support event="onchange" reRender="panEditComplicacionPac" ajaxSingle="true" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="panEditComplicacionPac" width="100%" columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
			<h:outputLabel value="#{ms.compli_compl }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_tipo }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_fechaini }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_fechafin }" style="font-weight: bold;"/>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panEditComPacCompli">
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion }" rendered="false">
					<f:selectItems value="#{controlComplicaciones.complicacionesTodas }" />
					<a4j:support event="onchange" reRender="panEditComPacCompli" ajaxSingle="true" />						
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion }" rendered="#{controlComplicaciones.currentCompl.idrelacion eq 0}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion }" rendered="#{controlComplicaciones.currentCompl.idrelacion eq 1}">
					<f:selectItems value="#{controlComplicaciones.complicacionesEefAbl }" />
					<a4j:support event="onchange" reRender="panEditComPacCompli" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion }" rendered="#{controlComplicaciones.currentCompl.idrelacion eq 7}">
					<f:selectItems value="#{controlComplicaciones.complicacionesEefDiag }" />
					<a4j:support event="onchange" reRender="panEditComPacCompli" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion }" rendered="#{controlComplicaciones.currentCompl.idrelacion eq 2 or controlComplicaciones.currentCompl.idrelacion eq 3 or controlComplicaciones.currentCompl.idrelacion eq 4 or controlComplicaciones.currentCompl.idrelacion eq 5}">
					<f:selectItems value="#{controlComplicaciones.complicacionesImpl }" />
					<a4j:support event="onchange" reRender="panEditComPacCompli" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion }" rendered="#{controlComplicaciones.currentCompl.idrelacion eq 6}">
					<f:selectItems value="#{controlComplicaciones.complicacionesCve }" />
					<a4j:support event="onchange" reRender="panEditComPacCompli" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion1 }" 
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idarritmias or controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idarritmiasCVE}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_arritmias_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_arritmias_2 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_arritmias_3 }"/>
					<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_arritmias_4 }"/>
					<f:selectItem itemValue="5" itemLabel="#{ms.compli_compl_arritmias_5 }"/>
					<f:selectItem itemValue="6" itemLabel="#{ms.compli_compl_arritmias_6 }"/>
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion1 }" 
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idhematoma or controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idhematomaCVE}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_hematoma_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_hematoma_2 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_hematoma_3 }"/>
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion1 }"
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idBavEEFDiag}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_bav_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_bav_2 }"/>
						<a4j:support event="onchange" reRender="panEditComPacCompli" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion2 }"
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idBavEEFDiag and controlComplicaciones.currentCompl.complicacion1 eq 2}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_bav_2_1 }"/>
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion1 }"
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idEmbEEFDiag}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_emb_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_emb_2 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_emb_3 }"/>
					<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_emb_4 }"/>
					<f:selectItem itemValue="5" itemLabel="#{ms.compli_compl_emb_5 }"/>
					<f:selectItem itemValue="6" itemLabel="#{ms.compli_compl_emb_6 }"/>
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion1 }"
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idDerrPerEEFDiag}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_derr_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_derr_2 }"/>
						<a4j:support event="onchange" reRender="panEditComPacCompli" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion2 }"
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idDerrPerEEFDiag and controlComplicaciones.currentCompl.complicacion1 eq 2}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_derr_2_1 }"/>
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion1 }"
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idTEPEEFDiag}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_tep_1 }"/>
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion1 }"
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idVascEEFDiag}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_vasc_2 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_vasc_3 }"/>
					<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_vasc_4 }"/>
						<a4j:support event="onchange" reRender="panEditComPacCompli" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.complicacion2 }"
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idVascEEFDiag and controlComplicaciones.currentCompl.complicacion1 eq 4}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_4_1 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_4_2 }"/>
				</h:selectOneMenu>
				<h:inputText value="#{controlComplicaciones.currentCompl.complicacionOtra }" 
					rendered="#{controlComplicaciones.currentCompl.complicacion eq controlComplicaciones.idcompotra}"/>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.tipo }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_tipo_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_tipo_2 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.compli_tipo_3 }"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
					showWeeksBar="false" direction="bottom-left" 
					value="#{controlComplicaciones.currentCompl.fechaini }" />
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
					showWeeksBar="false" direction="bottom-left" 
					value="#{controlComplicaciones.currentCompl.fechafin }" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.compli_resuelta }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_tratamiento }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_ingreso }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.compli_descripcion }" style="font-weight: bold;"/>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.resuelta }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="0" itemLabel="#{ms.compli_resuelta_0 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_resuelta_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.compli_resuelta_2 }"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panEditComPacTrat">								
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.tratamiento }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="0" itemLabel="#{ms.compli_tratamiento_0 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_tratamiento_1 }"/>
					<a4j:support event="onchange" reRender="panEditComPacTrat" ajaxSingle="true" />
				</h:selectOneMenu>
				<h:inputText value="#{controlComplicaciones.currentCompl.tratamientoDescr }" 
					rendered="#{controlComplicaciones.currentCompl.tratamiento eq 1}"/>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
				<h:selectOneMenu value="#{controlComplicaciones.currentCompl.ingreso }">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					<f:selectItem itemValue="0" itemLabel="#{ms.compli_ingreso_0 }"/>
					<f:selectItem itemValue="1" itemLabel="#{ms.compli_ingreso_1 }"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
				<h:inputTextarea cols="40" rows="4" value="#{controlComplicaciones.currentCompl.descripcion }" id="descEditComPac">
					<f:validateLength maximum="1000" />
				</h:inputTextarea>	
				<h:message for="descEditComPac" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
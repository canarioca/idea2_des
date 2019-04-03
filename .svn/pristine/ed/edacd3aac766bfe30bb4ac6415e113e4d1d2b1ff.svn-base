<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid columns="3" width="100%" id="panelAccionesElectrodo"
		columnClasses="alignTop,alignTop,alignTop">
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.imp_dispositivos_tab_himp_modal_acciones_elec_accion }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlImplantes.currentItemElectrodosEliminar.estado }">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_ele_estado_1_1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_ele_estado_2_1 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_ele_estado_3 }" />
					<a4j:support event="onchange" reRender="panelAccionesElectrodosCaracter,panelAccionesElectrodosMotivo" ajaxSingle="true"/>
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid columns="1" id="panelAccionesElectrodosCaracter">
			<h:outputText value="#{ms.imp_dispositivos_ele_estado_caracter }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" 
				rendered="#{controlImplantes.currentItemElectrodosEliminar.estado eq 2 || controlImplantes.currentItemElectrodosEliminar.estado eq 3}"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				rendered="#{controlImplantes.currentItemElectrodosEliminar.estado eq 2 || controlImplantes.currentItemElectrodosEliminar.estado eq 3}">
				<h:selectOneMenu value="#{controlImplantes.currentItemElectrodosEliminar.caracter }">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_ele_estado_caracter_1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_ele_estado_caracter_2 }" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid columns="1" id="panelAccionesElectrodosMotivo">
			<h:outputText value="#{ms.imp_dispositivos_tab_himp_modal_acciones_elec_motivo }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" 
				rendered="#{controlImplantes.currentItemElectrodosEliminar.estado ne 0}"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				rendered="#{controlImplantes.currentItemElectrodosEliminar.estado ne 0}">
				<h:selectOneMenu value="#{controlImplantes.currentItemElectrodosEliminar.motivoexaband }">
					<f:selectItems value="#{controlImplantes.mexplanteelec }" />											
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
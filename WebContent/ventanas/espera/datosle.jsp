<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid columns="3" width="100%" columnClasses="alignTop,alignTop,alignTop">
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.le_pat_nueva_msg_1 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlLe.regselec.estado }">
					<f:selectItem itemValue="1" itemLabel="#{ms.le_pat_msg_3 }" />
					<f:selectItem itemValue="5" itemLabel="#{ms.le_pat_msg_4 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.le_pat_msg_6 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.le_pat_msg_5 }" />
					<f:selectItem itemValue="4" itemLabel="#{ms.le_pat_msg_7 }" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid columns="1">
			<h:outputText value="#{ms.le_pat_nueva_msg_2 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlLe.regselec.nombre}" size="28" />
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid columns="1">
			<h:outputText value="#{ms.le_pat_nueva_msg_3 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2" cellspacing="0">
				<h:inputText value="#{controlLe.regselec.apellido1}"
					size="14" />
				<h:inputText value="#{controlLe.regselec.apellido2}"
					size="14" />
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid columns="1">
			<h:outputText value="#{ms.le_pat_nueva_msg_4 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:outputLabel value="#{controlLe.regselec.edadmin} años" />
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.le_pat_nueva_msg_5 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
					popup="true" showInput="true" enableManualInput="false"
					value="#{controlLe.regselec.ingreso}"/>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.le_pat_nueva_msg_6 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2" cellspacing="0">
				<h:inputText value="#{controlLe.regselec.telefono1}" size="11" />
				<h:inputText value="#{controlLe.regselec.telefono2}" size="11" />
			</h:panelGrid>
		</h:panelGrid>
		
	</h:panelGrid>
	
	<h:panelGrid columns="2" width="100%" columnClasses="alignTop,alignTop">
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.le_pat_nueva_msg_7 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="1">
				<h:selectOneMenu value="#{controlLe.regselec.arritmia }">
					<f:selectItems value="#{controlPacientes.arritmiasle }" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="2">
			<h:outputText value="#{ms.le_pat_nueva_msg_8 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:outputText value="#{ms.le_pat_nueva_msg_9 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlLe.regselec.procedimiento }">
					<f:selectItems value="#{controlPacientes.procedimientosle }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlLe.regselec.incluidopor }">
					<f:selectItems value="#{controlLe.operadores }" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="1" width="100%">
			<h:outputText value="#{ms.le_pat_nueva_msg_10 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="1" width="80%">
				<h:selectOneMenu value="#{controlLe.regselec.tratamiento1 }">
					<f:selectItems value="#{controlPacientes.anticoagulantesle }" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.le_pat_nueva_msg_11 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlLe.regselec.caracter }">
					<f:selectItems value="#{controlPacientes.caracterle }" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.le_pat_nueva_msg_12 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="1">
				<h:inputTextarea styleClass="estiloInput" rows="2" cols="50"
					value="#{controlLe.regselec.notas}" />
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="1" width="100%">
			<h:panelGrid columns="1" cellpadding="0" cellspacing="0" width="100%">
				<h:outputText value="#{ms.le_pat_nueva_msg_13 }"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%">
				<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
					popup="true" showInput="true" enableManualInput="false"
					value="#{controlLe.regselec.reclamacion}"/>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
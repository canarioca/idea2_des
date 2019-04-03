<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" id="panresul">
		<a4j:jsFunction name="updateResult1" reRender="panresul" 
			actionListener="#{controlMesas.reiniciaResultadon1 }"/>
		<a4j:jsFunction name="updateResult2" reRender="panresul" 
			actionListener="#{controlMesas.reiniciaResultadon2 }"/>
		<h:selectOneMenu value="#{controlMesas.mesa.resN1}"
			onchange="updateResult1();">
			<f:selectItem itemLabel="" itemValue="-1" />
			<f:selectItem itemLabel="#{ms.mesa_tab3_res_op0 }" itemValue="0" />
			<f:selectItem itemLabel="#{ms.mesa_tab3_res_op1 }" itemValue="1" />
		</h:selectOneMenu>
		<h:panelGrid columns="2" rendered="#{controlMesas.mesa.resN1 eq 1 }">
			<rich:spacer width="20px"/>
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:selectOneMenu value="#{controlMesas.mesa.resN2}"
					onchange="updateResult2();">
					<f:selectItem itemLabel="" itemValue="-1" />
					<f:selectItem itemLabel="#{ms.mesa_tab3_res_respuesta }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.mesa_tab3_res_tiempo_asistolia }" itemValue="1" />
				</h:selectOneMenu>
				<h:inputText value="#{controlMesas.mesa.resTiempo }" size="5" maxlength="6"
					rendered="#{controlMesas.mesa.resN2 eq 1 }"/>
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:panelGrid columns="2">
				<rich:spacer width="20px"/>
				<h:selectOneMenu value="#{controlMesas.mesa.resN3}"
					rendered="#{controlMesas.mesa.resN2 eq 1 }">
					<f:selectItem itemLabel="#{ms.mesa_tab3_res_bav_si }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.mesa_tab3_res_bav_no }" itemValue="0" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlMesas.mesa.resN3}"
					rendered="#{controlMesas.mesa.resN2 eq 0 }">
					<f:selectItem itemLabel="" itemValue="-1" />
					<f:selectItem itemLabel="#{ms.mesa_tab3_res_tipo1 }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.mesa_tab3_res_tipo2a }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.mesa_tab3_res_tipo2b }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.mesa_tab3_res_tipo3 }" itemValue="3" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>	
</ui:composition>
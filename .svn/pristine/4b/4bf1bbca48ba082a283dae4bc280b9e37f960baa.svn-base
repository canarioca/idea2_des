<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		<a4j:jsFunction name="updateCar" reRender="cardio,panres" 
			actionListener="#{controlMesas.reiniciaResultadoCardio }"/>
		<h:panelGrid columns="2" >
			<h:outputLabel value="#{ms.mesa_tab4_score_cardiopatia }" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlMesas.mesa.cardiopatia}"
				onchange="updateCar();">
				<f:selectItem itemLabel="" itemValue="-1" />
				<f:selectItem itemLabel="#{ms.mesa_tab4_score_cardiopatia_op0 }" itemValue="0" />
				<f:selectItem itemLabel="#{ms.mesa_tab4_score_cardiopatia_op1 }" itemValue="1" />
			</h:selectOneMenu>
		</h:panelGrid>
		<h:panelGrid id="cardio">
			<h:panelGrid rendered="#{controlMesas.mesa.cardiopatia eq 0 }">
				<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_title }" 
					style="font-weight: bold;" />
				<h:panelGrid columns="2" width="100%">
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonA }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:panelGrid cellpadding="0" cellspacing="0">
						<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio0_a }"/>
						<h:panelGrid cellpadding="0" cellspacing="0" columns="2">
							<rich:spacer width="20px"/>
							<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio0_a_i }" />
						</h:panelGrid>
					</h:panelGrid>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonB }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio0_b }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonC }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio0_c }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonD }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio0_d }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonE }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio0_e }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonF }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio0_f }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonG }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio0_g }"/>
				</h:panelGrid>	
			</h:panelGrid>
			<h:panelGrid rendered="#{controlMesas.mesa.cardiopatia eq 1 }">
				<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_title_2 }" 
					style="font-weight: bold;" />
				<h:panelGrid columns="2" width="100%">
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonA }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio1_a }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonB }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio1_b }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonC }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio1_c }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonD }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio1_d }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonE }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio1_e }"/>
					<h:selectOneRadio value="#{controlMesas.mesa.sheldonF }">
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.mesa_tab4_score_sheldon_op0 }" itemValue="0"/>
					</h:selectOneRadio>
					<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_cardio1_f }"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="panres" rendered="#{controlMesas.mesa.cardiopatia ge 0 }">
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.mesa_tab4_score_sheldon_puntuacion }" style="font-weight: bold;"/>
				<h:inputText value="#{controlMesas.puntuacion }" maxlength="2" size="4" readonly="true"/>
				<a4j:commandButton value="#{ms.mesa_tab4_score_sheldon_puntuacion_calculo }" reRender="panres" 
					actionListener="#{controlMesas.calculaPuntuacion }" />
			</h:panelGrid>
			<h:outputLabel rendered="#{controlMesas.comprobar and controlMesas.mesa.cardiopatia eq 0 and controlMesas.puntuacion ge -2}" 
				value="#{ms.mesa_tab4_score_sheldon_puntuacion_res1 }" style="font-weight: bold;"/>
			<h:outputLabel rendered="#{controlMesas.comprobar and controlMesas.mesa.cardiopatia eq 1 and controlMesas.puntuacion ge 1}" 
				value="#{ms.mesa_tab4_score_sheldon_puntuacion_res2 }" style="font-weight: bold;"/>
		</h:panelGrid>
	</h:panelGrid>	
</ui:composition>
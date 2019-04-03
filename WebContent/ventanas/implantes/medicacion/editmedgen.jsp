<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">

	<h:panelGrid id="panEditItemPlanGenImp" >
		<h:panelGrid columns="3" width="100%" columnClasses="alignTop,alignTop,alignTop" id="panMedEditItemPlanGenImp">
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_2 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
					<r:comboBox enableManualInput="true" defaultLabel="Escriba nombre de medicamento" width="220"
						rendered="false"
						value="#{controlMedicacion.currentItem.medicacionDto.medgenerico.codigo}">
						<f:selectItems value="#{controlMedicacion.genericos }"/>
						<a4j:support event="onchange" reRender="panMedEditItemPlanGenImp" ajaxSingle="true"
							actionListener="#{controlMedicacion.seleccionaMedicacion }"/>
					</r:comboBox>						
					<h:selectOneMenu value="#{controlMedicacion.currentItem.medicacionDto.medgenerico.tipomed }">
						<f:selectItems value="#{controlMedicacion.tiposmedicacion }" />	
						<a4j:support event="onchange" reRender="panEditMedGenComponentesImp" ajaxSingle="true" />						
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid>
					<h:panelGrid columnClasses="alignTop" id="panEditMedGenComponentesImp">								
						<h:selectOneMenu value="#{controlMedicacion.currentItem.idmedgen }"
							rendered="#{controlMedicacion.currentItem.medicacionDto.medgenerico.tipomed ne 18 }">
							<f:selectItems value="#{controlMedicacion.medicacionGeneral }" />
						</h:selectOneMenu>
						<h:inputText value="#{controlMedicacion.currentItem.otros }" 
							rendered="#{controlMedicacion.currentItem.medicacionDto.medgenerico.tipomed eq 18 }"/>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			
			<h:panelGrid rendered="false" id="panEditItemPlanGenImpCom">
				<h:outputLabel value="#{ms.med_gen_msg_4 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<h:selectOneMenu value="#{controlMedicacion.currentItem.idmedcom }"
						rendered="#{controlMedicacion.currentItem.medicacionDto.medgenerico.tipomed eq 9}">
						<f:selectItems value="#{controlMedicacion.antibioticoscom }" />	
						<a4j:support event="onchange" reRender="panEditItemPlanGenImp" ajaxSingle="true" />						
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlMedicacion.currentItem.idmedcom }"
						rendered="#{controlMedicacion.currentItem.medicacionDto.medgenerico.tipomed eq 10}">
						<f:selectItems value="#{controlMedicacion.iecacom }" />	
						<a4j:support event="onchange" reRender="panEditItemPlanGenImp" ajaxSingle="true" />						
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid id="panEditFechasItemPlanMedGenImp" columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_5 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<h:selectOneMenu value="#{controlMedicacion.currentItem.estado }">
						<f:selectItem itemValue="1" itemLabel="#{ms.med_gen_msg_9 }"/>
						<f:selectItem itemValue="0" itemLabel="#{ms.med_gen_msg_10 }"/>
						<f:selectItem itemValue="-1" itemLabel="#{ms.med_gen_msg_11 }"/>
						<a4j:support event="onchange" reRender="panEditMotivosSuspItemPlanGenImp" ajaxSingle="true"/>														
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_18 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlMedicacion.currentItem.fechaprescripcion}">								
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_19 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlMedicacion.currentItem.fechainicio}">								
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_20 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlMedicacion.currentItem.fechasuspension}">								
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<rich:simpleTogglePanel switchType="client" label="#{ms.med_gen_msg_21 }" opened="false" rendered="false">
			<h:panelGrid columns="2">
				<h:panelGrid>
					<h:outputLabel value="#{ms.med_gen_msg_22 }" style="font-weight: bold;"/>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
						<h:selectOneMenu value="#{controlMedicacion.currentItem.medicacionDto.medscom.idpresentacion }">
							<f:selectItems value="#{controlMedicacion.formasPresentacion }" />						
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.med_gen_msg_23 }" style="font-weight: bold;"/>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
						<h:selectOneMenu value="#{controlMedicacion.currentItem.idvia }">
							<f:selectItems value="#{controlMedicacion.vias }" />						
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</rich:simpleTogglePanel>
		<h:panelGrid id="panEditMotivosSuspItemPlanGenImp">
			<h:outputLabel value="#{ms.med_gen_msg_24 }" style="font-weight: bold;" rendered="#{controlMedicacion.currentItem.estado eq 0 }"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlMedicacion.currentItem.estado eq 0 }">
				<h:inputTextarea cols="80" rows="8" value="#{controlMedicacion.currentItem.motivosuspension }" id="motivosEditSuspItemPlanGenImp">
					<f:validateLength maximum="1000" />
				</h:inputTextarea>	
				<h:message for="motivosEditSuspItemPlanGenImp" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
		<rich:simpleTogglePanel switchType="client" label="#{ms.med_gen_msg_25 }" opened="false">
			<h:panelGrid>
				<h:inputTextarea cols="80" rows="8" value="#{controlMedicacion.currentItem.comentarios }" id="comentariosEditItemPlanGenImp">
					<f:validateLength maximum="1000" />
				</h:inputTextarea>	
				<h:message for="comentariosEditItemPlanGenImp" style="color:red" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:panelGrid>
</ui:composition>
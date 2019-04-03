<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">

	<h:panelGrid id="panNuevoItemPlanGenSeg" >
		<h:panelGrid columns="3" width="100%" columnClasses="alignTop,alignTop,alignTop" id="panMedNuevoItemPlanGenSeg">
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_17 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
					<r:comboBox enableManualInput="true" defaultLabel="Escriba nombre de medicamento" width="220"
						rendered="false"
						value="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.codigo}">
						<f:selectItems value="#{controlMedicacion.genericos }"/>
						<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true"
							actionListener="#{controlMedicacion.seleccionaMedicacion }"/>
					</r:comboBox>						
					<h:selectOneMenu value="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed }">
						<f:selectItems value="#{controlMedicacion.tiposmedicacion }" />	
						<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid rendered="false">
					<h:panelGrid columnClasses="alignTop" >								
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 1}">
							<f:selectItems value="#{controlMedicacion.terapiacardiaca }" />	
							<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 2}">
							<f:selectItems value="#{controlMedicacion.antihipertensivos }" />	
							<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 3}">
							<f:selectItems value="#{controlMedicacion.diureticos }" />	
							<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 4}">
							<f:selectItems value="#{controlMedicacion.vasodilatadoresperifericos  }" />	
							<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 5}">
							<f:selectItems value="#{controlMedicacion.vasoprotectores }" />	
							<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 7}">
							<f:selectItems value="#{controlMedicacion.agentesbetabloqueantes }" />	
							<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1}" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 8}">
							<f:selectItems value="#{controlMedicacion.bloqueantescanalescalcio }" />	
							<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 9}">
							<f:selectItems value="#{controlMedicacion.ieca }" />	
							<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 10}">
							<f:selectItems value="#{controlMedicacion.antilipemicos }" />	
							<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid rendered="false">
					<h:panelGrid rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 1}">
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 1}">
							<f:selectItems value="#{controlMedicacion.terapiacardiaca1 }" />													
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 2}">
							<f:selectItems value="#{controlMedicacion.terapiacardiaca2 }" />							
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 3}">
							<f:selectItems value="#{controlMedicacion.terapiacardiaca3 }" />							
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 4}">
							<f:selectItems value="#{controlMedicacion.terapiacardiaca4 }" />							
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 5}">
							<f:selectItems value="#{controlMedicacion.terapiacardiaca5 }" />							
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 2}">
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 1}">
							<f:selectItems value="#{controlMedicacion.antihipertensivos1 }" />													
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 2}">
							<f:selectItems value="#{controlMedicacion.antihipertensivos2 }" />													
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 3}">
							<f:selectItems value="#{controlMedicacion.antihipertensivos3 }" />													
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 4}">
							<f:selectItems value="#{controlMedicacion.antihipertensivos4 }" />													
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 3}">
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 1}">
							<f:selectItems value="#{controlMedicacion.diureticos1 }" />													
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 2}">
							<f:selectItems value="#{controlMedicacion.diureticos2 }" />							
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 3}">
							<f:selectItems value="#{controlMedicacion.diureticos3 }" />							
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 4}">
							<f:selectItems value="#{controlMedicacion.diureticos4 }" />							
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 5}">
							<f:selectItems value="#{controlMedicacion.diureticos5 }" />							
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid rendered="false">
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }">
							<f:selectItems value="#{controlMedicacion.vasodilatadoresperifericos }" />							
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid rendered="false">
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }">
							<f:selectItems value="#{controlMedicacion.agentesbetabloqueantes }" />							
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 8}">
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 1}">
							<f:selectItems value="#{controlMedicacion.bloqueantescanalescalcio1 }" />													
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 2}">
							<f:selectItems value="#{controlMedicacion.bloqueantescanalescalcio2 }" />							
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
							rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed1 eq 3}">
							<f:selectItems value="#{controlMedicacion.bloqueantescanalescalcio3 }" />							
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid rendered="false">
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }">
							<f:selectItems value="#{controlMedicacion.ieca}" />							
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid rendered="false">
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }">
							<f:selectItems value="#{controlMedicacion.antilipemicos}" />							
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid>
						<h:panelGrid columnClasses="alignTop" >								
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 1}">
								<f:selectItems value="#{controlMedicacion.antiarritmicos_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 2}">
								<f:selectItems value="#{controlMedicacion.antibioticos_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 3}">
								<f:selectItems value="#{controlMedicacion.anticoagulantevenoso_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 4}">
								<f:selectItems value="#{controlMedicacion.anticoagulanteoral_siccs  }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 5}">
								<f:selectItems value="#{controlMedicacion.antilipemicos_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 6}">
								<f:selectItems value="#{controlMedicacion.antiplaquetarios_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 7}">
								<f:selectItems value="#{controlMedicacion.betabloqueantes_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 8}">
								<f:selectItems value="#{controlMedicacion.broncodilatadores_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 9}">
								<f:selectItems value="#{controlMedicacion.calcioantagonistas_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 10}">
								<f:selectItems value="#{controlMedicacion.digitalicos_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>							
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 11}">
								<f:selectItems value="#{controlMedicacion.diureticos_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 12}">
								<f:selectItems value="#{controlMedicacion.esteroides_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 13}">
								<f:selectItems value="#{controlMedicacion.heparina_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 14}">
								<f:selectItems value="#{controlMedicacion.ieca_siccs  }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 15}">
								<f:selectItems value="#{controlMedicacion.inotropicos_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 16}">
								<f:selectItems value="#{controlMedicacion.nitratos_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
								rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 17}">
								<f:selectItems value="#{controlMedicacion.nitritos_siccs }" />	
								<a4j:support event="onchange" reRender="panMedNuevoItemPlanGen" ajaxSingle="true" />						
							</h:selectOneMenu>	
						</h:panelGrid>
					</h:panelGrid>
			</h:panelGrid>
			
			<h:panelGrid rendered="false" id="panNuevoItemPlanGenSegCom">
				<h:outputLabel value="#{ms.med_gen_msg_4 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedcom }"
						rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 9}">
						<f:selectItems value="#{controlMedicacion.antibioticoscom }" />	
						<a4j:support event="onchange" reRender="panNuevoItemPlanGenSeg" ajaxSingle="true" />						
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedcom }"
						rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 10}">
						<f:selectItems value="#{controlMedicacion.iecacom }" />	
						<a4j:support event="onchange" reRender="panNuevoItemPlanGenSeg" ajaxSingle="true" />						
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid id="panFechasItemPlanMedGenSeg" columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_5 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<h:selectOneMenu value="#{controlMedicacion.planmedgen.estado }">
						<f:selectItem itemValue="1" itemLabel="#{ms.med_gen_msg_9 }"/>
						<f:selectItem itemValue="0" itemLabel="#{ms.med_gen_msg_10 }"/>
						<f:selectItem itemValue="-1" itemLabel="#{ms.med_gen_msg_11 }"/>
						<a4j:support event="onchange" reRender="panMotivosSuspItemPlanGenSeg" ajaxSingle="true"/>														
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_18 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlMedicacion.planmedgen.fechaprescripcion}">								
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_19 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlMedicacion.planmedgen.fechainicio}">								
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.med_gen_msg_20 }" style="font-weight: bold;"/>
				<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlMedicacion.planmedgen.fechasuspension}">								
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<rich:simpleTogglePanel switchType="client" label="#{ms.med_gen_msg_21 }" opened="false" rendered="false">
			<h:panelGrid columns="2">
				<h:panelGrid>
					<h:outputLabel value="#{ms.med_gen_msg_22 }" style="font-weight: bold;"/>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.medicacionDto.medscom.idpresentacion }">
							<f:selectItems value="#{controlMedicacion.formasPresentacion }" />						
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.med_gen_msg_23 }" style="font-weight: bold;"/>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
						<h:selectOneMenu value="#{controlMedicacion.planmedgen.idvia }">
							<f:selectItems value="#{controlMedicacion.vias }" />						
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</rich:simpleTogglePanel>
		<h:panelGrid id="panMotivosSuspItemPlanGenSeg">
			<h:outputLabel value="#{ms.med_gen_msg_24 }" style="font-weight: bold;" rendered="#{controlMedicacion.planmedgen.estado eq 0 }"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlMedicacion.planmedgen.estado eq 0 }">
				<h:inputTextarea cols="80" rows="8" value="#{controlMedicacion.planmedgen.motivosuspension }" id="motivosSuspItemPlanGenSeg">
					<f:validateLength maximum="1000" />
				</h:inputTextarea>	
				<h:message for="motivosSuspItemPlanGenSeg" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
		<rich:simpleTogglePanel switchType="client" label="#{ms.med_gen_msg_25 }" opened="false">
			<h:panelGrid>
				<h:inputTextarea cols="80" rows="8" value="#{controlMedicacion.planmedgen.comentarios }" id="comentariosItemPlanGenSeg">
					<f:validateLength maximum="1000" />
				</h:inputTextarea>	
				<h:message for="comentariosItemPlanGenSeg" style="color:red" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:panelGrid>
</ui:composition>
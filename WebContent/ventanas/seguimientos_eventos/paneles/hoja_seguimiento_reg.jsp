<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid cellpadding="0" cellspacing="0">
		<h:panelGrid columns="2" id="panelSegRegEv" columnClasses="alignTop,alignTop">
			<h:panelGrid>
				<h:panelGrid>
                     <t:fieldset legend="#{ms.segregev_tab2_datos_info_disp_title }">
                     	<h:panelGrid columns="3" columnClasses="alignTop,alignTop,alignTop">
                     		<h:outputLabel value="#{ms.segregev_tab2_datos_info_disp_modelo }" style="font-weight: bold;"/>	
							<h:outputLabel value="#{ms.segregev_tab2_datos_info_disp_nserie }" style="font-weight: bold;"/>
							<h:outputLabel value="#{ms.segregev_tab2_datos_info_disp_fimp }" style="font-weight: bold;"/>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlSeguimientosRegEventos.seg.modelo}" disabled="true">
									<f:selectItems value="#{controlSeguimientosRegEventos.regs}"/>
								</h:selectOneMenu>
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:outputLabel value="#{controlSeguimientosRegEventos.seg.nserie }"/>
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:outputLabel value="#{controlSeguimientosRegEventos.seg.fechaimp }">
									<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+1"/>
								</h:outputLabel>
							</h:panelGrid>
                     	</h:panelGrid>
                     </t:fieldset>
                </h:panelGrid>
				<h:panelGrid columns="2" columnClasses="alignTop">
					<h:outputLabel value="#{ms.segregev_tab2_datos_motivo }" style="font-weight: bold;"/>					
					<h:outputLabel value="#{ms.segregev_tab2_datos_activacion }" style="font-weight: bold;"/>				
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlSeguimientosRegEventos.seg.motivo }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.segregev_tab2_datos_motivo_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.segregev_tab2_datos_motivo_op1 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.segregev_tab2_datos_motivo_op3 }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.segregev_tab2_datos_motivo_op4 }" />
							<f:selectItem itemValue="5" itemLabel="#{ms.segregev_tab2_datos_motivo_op5 }" />				
						</h:selectOneMenu>
					</h:panelGrid>					
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlSeguimientosRegEventos.seg.activacion}">
						    <f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />   
							<f:selectItem itemValue="1" itemLabel="#{ms.segregev_tab2_datos_activacion_op1 }" />
							<f:selectItem itemValue="0" itemLabel="#{ms.segregev_tab2_datos_activacion_op0 }" />
							<a4j:support event="onchange" reRender="panEventosSegReg" />	
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.segregev_tab2_datos_med }" style="font-weight: bold;" />
					<h:outputLabel value="#{ms.segregev_tab2_datos_enf }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlSeguimientosRegEventos.seg.operadorMedico}">
							<f:selectItems value="#{controlSeguimientosRegEventos.primerOperador}" />
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlSeguimientosRegEventos.seg.operadorEnfermeria}">
							<f:selectItems value="#{controlSeguimientosRegEventos.enfermeras}" />
						</h:selectOneMenu>
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid columns="2" columnClasses="alignTop,alignTop" id="panEventosSegReg">				
					<h:panelGrid columnClasses="alignTop">
						<h:outputLabel value="#{ms.segregev_tab2_datos_bat }" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:selectOneMenu value="#{controlSeguimientosRegEventos.seg.estadobateria}">
							    <f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />   
								<f:selectItem itemValue="1" itemLabel="#{ms.segregev_tab2_datos_bat_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.segregev_tab2_datos_bat_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.segregev_tab2_datos_bat_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.segregev_tab2_datos_bat_op4 }" />								
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop" rendered="#{controlSeguimientosRegEventos.seg.activacion eq 1 }">
						<h:outputLabel value="#{ms.segregev_tab2_datos_eventos }" style="font-weight: bold;" />
						<h:outputLabel value="#{ms.segregev_tab2_datos_tiempo_fa }" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
								<h:outputLabel value="#{ms.segregev_tab2_datos_eventos_sintoma }"/>
								<h:inputText value="#{controlSeguimientosRegEventos.seg.evRitmosinusal}" size="4"/>
								<h:outputLabel value="#{ms.segregev_tab2_datos_eventos_asistolia }"/>
								<h:inputText value="#{controlSeguimientosRegEventos.seg.evPausa}" size="4"/>
								<h:outputLabel value="#{ms.segregev_tab2_datos_eventos_bradicardia }"/>
								<h:inputText value="#{controlSeguimientosRegEventos.seg.evBav}" size="4"/>
								<h:outputLabel value="#{ms.segregev_tab2_datos_eventos_tpsv }"/>
								<h:inputText value="#{controlSeguimientosRegEventos.seg.evTpsv}" size="4"/>
								<h:outputLabel value="#{ms.segregev_tab2_datos_eventos_tv }"/>
								<h:inputText value="#{controlSeguimientosRegEventos.seg.evTv}" size="4"/>
								<h:outputLabel value="#{ms.segregev_tab2_datos_eventos_fv }"/>
								<h:inputText value="#{controlSeguimientosRegEventos.seg.evFv}" size="4"/>
								<h:outputLabel value="#{ms.segregev_tab2_datos_eventos_otros }"/>
								<h:inputText value="#{controlSeguimientosRegEventos.seg.evOtros}" size="4"/>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputText value="#{controlSeguimientosRegEventos.seg.tiempoFa}" size="4"/>
						</h:panelGrid>
					</h:panelGrid>			
				</h:panelGrid>
			</h:panelGrid>
			
			<h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.segregev_tab2_datos_obs }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						width="80%" cellspacing="0" columnClasses="alignTop">					
						<h:inputTextarea cols="100" rows="8" value="#{controlSeguimientosRegEventos.seg.observaciones }" 
							id="observacionesSegRegEv" >
							 <f:validateLength maximum="2000" />
						</h:inputTextarea>	
						<h:message for="observacionesSegRegEv" style="color:red" />
					</h:panelGrid>
				</h:panelGrid>
			    <rich:spacer width="10"/>
				<h:panelGrid>
					<h:outputLabel value="#{ms.segregev_tab2_datos_com_inter }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						width="80%" cellspacing="0" columnClasses="alignTop">					
						<h:inputTextarea cols="100" rows="8" value="#{controlSeguimientosRegEventos.seg.comentariosInternos }" 
							id="comentariosSegRegEv" >
							 <f:validateLength maximum="2000" />
						</h:inputTextarea>	
						<h:message for="comentariosSegRegEv" style="color:red" />
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid width="100%">
			<rich:simpleTogglePanel switchType="client" label="#{ms.segclin_tab2_datos_compl }" opened="#{not empty controlSeguimientosRegEventos.listacompl }">
                 <a4j:include viewId="complicaciones/complicacion.jsp"/>
            </rich:simpleTogglePanel>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid cellpadding="0" cellspacing="0">
		<h:panelGrid columns="2" id="panelSegClin" columnClasses="alignTop,alignTop" width="100%">
			<h:panelGrid>
				<h:panelGrid columnClasses="alignTop">
					<h:outputLabel value="#{ms.segclin_tab2_datos_tiposeg }" style="font-weight: bold;"/>					
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlSeguimientosClinicos.seg.tiposeg }">
							<f:selectItems value="#{controlSeguimientosClinicos.tiposeg}" />					
						</h:selectOneMenu>
					</h:panelGrid>				
				</h:panelGrid>
				<h:panelGrid id="panMotivosSegClin">
					<h:outputLabel value="#{ms.segclin_tab2_datos_motivo }" style="font-weight: bold;" 
						rendered="#{controlSeguimientosClinicos.seg.tiposeg ne null or controlSeguimientosClinicos.seg.tiposeg ne 0 }"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlSeguimientosClinicos.seg.tiposeg ne 0 }">
						<h:selectOneMenu value="#{controlSeguimientosClinicos.seg.motivo}" >
							<f:selectItems value="#{controlSeguimientosClinicos.motivosseg}" />
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.segclin_tab2_datos_med }" style="font-weight: bold;" />
					<h:selectOneMenu value="#{controlSeguimientosClinicos.seg.opmed}">
						<f:selectItems value="#{controlSeguimientosClinicos.primerOperador}" />
					</h:selectOneMenu>
					<rich:spacer width="10" />
					<h:outputLabel value="#{ms.segclin_tab2_datos_enf }" style="font-weight: bold;" />
					<h:selectOneMenu value="#{controlSeguimientosClinicos.seg.openf}">
						<f:selectItems value="#{controlSeguimientosClinicos.enfermeras}" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.segclin_tab2_datos_obs }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						width="80%" cellspacing="0" columnClasses="alignTop">					
						<h:inputTextarea cols="120" rows="8" value="#{controlSeguimientosClinicos.seg.observaciones }" 
							id="observacionesSegClin" >
							 <f:validateLength maximum="2000" />
						</h:inputTextarea>	
						<h:message for="observacionesSegClin" style="color:red" />
					</h:panelGrid>
				</h:panelGrid>
			    <rich:spacer width="10"/>
				<h:panelGrid>
					<h:outputLabel value="#{ms.segclin_tab2_datos_res }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						width="80%" cellspacing="0" columnClasses="alignTop">					
						<h:inputTextarea cols="120" rows="8" value="#{controlSeguimientosClinicos.seg.resultados }" 
							id="resultadosSegClin" >
							 <f:validateLength maximum="2000" />
						</h:inputTextarea>	
						<h:message for="resultadosSegClin" style="color:red" />
					</h:panelGrid>
				</h:panelGrid>
				<rich:spacer width="10"/>
				<h:panelGrid>
					<h:outputLabel value="#{ms.segclin_tab2_datos_coment }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						width="80%" cellspacing="0" columnClasses="alignTop">					
						<h:inputTextarea cols="120" rows="8" value="#{controlSeguimientosClinicos.seg.comentarios }" 
							id="comentariosSegClin" >
							 <f:validateLength maximum="2000" />
						</h:inputTextarea>	
						<h:message for="comentariosSegClin" style="color:red" />
					</h:panelGrid>
				</h:panelGrid>				
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid width="100%">
			<rich:simpleTogglePanel switchType="client" label="#{ms.segclin_tab2_datos_compl }" opened="#{not empty controlSeguimientosClinicos.listacompl }">
                 <a4j:include viewId="complicaciones/complicacion.jsp"/>
            </rich:simpleTogglePanel>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
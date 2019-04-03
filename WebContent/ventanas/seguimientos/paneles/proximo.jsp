<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid columns="3" columnClasses="alignTop,alignTop" id="proxSeguimiento">
		<h:panelGrid columnClasses="alignTop">
			<h:outputLabel value="#{ms.seg_disp_tab_prox_seg_fecha }" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%">
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12" id="calProxSeg"
					showWeeksBar="false" direction="bottom-left" 
					popup="#{controlSeguimientos.seg.fechaproximoseg eq null}"
					value="#{controlSeguimientos.seg.fechaproximoseg}" 
					ondateselected="javascript:Richfaces.showModalPanel('eventoSeguimiento');">
					<a4j:support event="onchanged" reRender="eventoProximoSeguimiento,proxSeguimiento" 
						actionListener="#{controlSeguimientos.eventosDiarios}"/>
				</rich:calendar>
			</h:panelGrid>
			<h:panelGrid columns="3" rendered="false">
				<a4j:commandLink actionListener="#{controlSeguimientos.avanza3Meses }"
					reRender="proxSeguimiento,calProxSeg">
					<h:graphicImage style="border: 0px;" value="/img/iconos/calendar_3m.png"
						width="38px" height="48px" title="#{ms.seg_disp_tab_prox_seg_av3m }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlSeguimientos.avanza6Meses }"
					reRender="proxSeguimiento,calProxSeg">
					<h:graphicImage style="border: 0px;" value="/img/iconos/calendar_6m.png"
						width="38px" height="48px" title="#{ms.seg_disp_tab_prox_seg_av6m }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlSeguimientos.avanza12Meses }"
					reRender="proxSeguimiento,calProxSeg">
					<h:graphicImage style="border: 0px;" value="/img/iconos/calendar_12m.png"
						width="38px" height="48px" title="#{ms.seg_disp_tab_prox_seg_av12m }"/>
				</a4j:commandLink>
			</h:panelGrid>			
		</h:panelGrid>
		
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop" width="100%">			
			<h:panelGrid columnClasses="alignTop">
				<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
					<h:panelGrid id="horaProxSeg">
						<h:outputLabel value="#{ms.seg_disp_tab_prox_seg_hora_inicio }" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="3">
							<rich:inputNumberSpinner value="#{controlSeguimientos.evento.hora_ini }" step="1" maxValue="23" minValue="0" inputSize="2"/>													
							<h:outputLabel value=":" />
							<rich:inputNumberSpinner value="#{controlSeguimientos.evento.min_ini }" step="1" maxValue="59" minValue="0" inputSize="2"/>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid>
						<h:outputLabel value="#{ms.seg_disp_tab_prox_seg_duracion }" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<rich:inputNumberSpinner step="1" maxValue="99999"
								value="#{controlSeguimientos.evento.duracion }"/>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>	
				<h:panelGrid columnClasses="alignTop">					
					<h:outputLabel value="#{ms.seg_disp_tab_prox_seg_obs }" style="font-weight: bold;" />									
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputTextarea value="#{controlSeguimientos.evento.descripcion }" id="descripcionProxSeg" cols="37">
							<f:validateLength maximum="2000" />
						</h:inputTextarea>	
						<h:message for="descripcionProxSeg" style="color:red" />
					</h:panelGrid>		
				</h:panelGrid>					
				
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop">
				<h:outputLabel value="#{ms.seg_disp_tipo_seg }" style="font-weight: bold;"/>	
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%">
					<h:selectOneMenu value="#{controlSeguimientos.seg.caracterproximo }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.seg_disp_tipo_seg_pres_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.seg_disp_tipo_seg_pres_op2 }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>		
		</h:panelGrid>
		
		
	</h:panelGrid>
	
	<rich:modalPanel id="eventoSeguimiento" autosized="true" zindex="2000" minWidth="464">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.seg_disp_tab_prox_seg_modal_title }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">					
				<a4j:commandLink 
					onclick="javascript:Richfaces.hideModalPanel('eventoSeguimiento');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('eventoSeguimiento')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="eventoProximoSeguimiento" width="100%">
			<ui:include src="/ventanas/seguimientos/evento.jsp"/>
		</h:panelGrid>
	</rich:modalPanel>
	
</ui:composition>
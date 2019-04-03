<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox">
	
	<h:panelGrid id="panEventoCitaHueco">
		<h:panelGrid id="duracionDiaEventoHueco" columns="2" rendered="#{controlCitas.agenda.gestionhuecos eq false }">
			<h:selectBooleanCheckbox value="#{controlCitas.evento.tododia }">
				<a4j:support event="onclick" reRender="fechaInicioEventoHueco,fechaFinEventoHueco,duracionEventoHueco" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.citas_evento_todo_dia }" style="font-weight: bold;" />					
		</h:panelGrid>
		<h:panelGrid >
			<h:panelGrid columns="3" columnClasses="alignTop,alignTop,alignTop">
				<h:panelGrid columnClasses="alignTop">
					<h:outputLabel value="#{ms.citas_evento_msg_1 }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlCitas.evento.procedimiento}">
							<f:selectItems value="#{controlCitas.procedimientos}" />					
							<a4j:support event="onchange" reRender="panCitas,panEventoCitaHueco,panTipoGenEventoHueco,panSelectorHuecos" ajaxSingle="true"
								actionListener="#{controlCitas.cambiaProcedimientoEvento }"/>
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid id="panTipoGenEventoHueco" columnClasses="alignTop" 
					rendered="#{controlCitas.evento.procedimiento eq 983 || controlCitas.evento.procedimiento eq 956 || controlCitas.evento.procedimiento eq 1059 || controlCitas.evento.procedimiento eq 1060 || controlCitas.evento.procedimiento eq 1090}">
					<h:outputLabel value="#{ms.citas_evento_msg_2 }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlCitas.evento.tipogen}">
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tipo_0 }" itemValue="0" />
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tipo_1 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tipo_2 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tipo_3 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tipo_4 }" itemValue="4" />
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tipo_5 }" itemValue="5" />
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tipo_6 }" itemValue="6" />
							<a4j:support event="onchange" reRender="panCitas,panEventoCitaHueco,panTipoGenEventoHueco,panSelectorHuecos" ajaxSingle="true"
								actionListener="#{controlCitas.cambiaProcedimientoEvento }"/>					
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columnClasses="alignTop">
					<h:outputLabel value="#{ms.citas_evento_msg_3 }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlCitas.evento.estado}">
							<f:selectItem itemLabel="#{ms.citas_estado_title_1 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.citas_estado_title_0 }" itemValue="0" />
							<f:selectItem itemLabel="#{ms.citas_estado_title_2 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.citas_estado_title_3 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.citas_estado_title_5 }" itemValue="5" />							
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>				
		</h:panelGrid>
		
		<h:panelGrid id="panSelectorHuecos" rendered="#{controlCitas.evento.procedimiento ne 0 and controlCitas.agenda.gestionhuecos eq true }">
			<rich:panel id="panelHuecos" >
		        <f:facet name="header">
		            <h:outputText value="#{ms.citas_evento_msg_4 }"/>
		        </f:facet><h:panelGrid columnClasses="top, top" columns="4">
		        	<a4j:commandLink reRender="fechaInicioEventoHueco,fechaFinEventoHueco,duracionEventoHueco,panSelectorHuecos,panHuecosGrid,panelHuecos,panHuecoFechaSel,panNoHuecos" onclick="javascript:Richfaces.showModalPanel('buscando');" rendered="#{controlCitas.evento.procedimiento ne 0 }" oncomplete="javascript:Richfaces.hideModalPanel('buscando');" ajaxSingle="true" actionListener="#{controlCitas.retrocede1Dia }">	
						<h:graphicImage value="/img/timeline/moveleft.png" width="16" height="16" style="border:0;" title="#{ms.citas_evento_msg_5 }" />				
					</a4j:commandLink>
					<h:panelGrid columns="2" id="panNoHuecos">
						<h:graphicImage value="/img/iconos/alerta.png" width="28" height="28" style="border:0;" rendered="#{controlCitas.pleno eq true }" />
						<h:outputLabel value="#{ms.citas_evento_msg_18 }" style="font-weight: bold;color: red;" rendered="#{controlCitas.pleno eq true }" />
					</h:panelGrid>
					<h:panelGrid columnClasses="center" rendered="#{not empty controlCitas.huecoslibresdiarios}">
						<h:panelGrid columns="3" columnClasses="center,alignLeft" id="panHuecoFechaSel">
							<h:panelGrid columns="2">
								<h:graphicImage value="/img/iconos/calendar.png" width="16" height="16" style="border:0;" title="#{ms.citas_evento_msg_6 }" />
								<h:outputLabel value="#{controlCitas.evento.fechaini }" style="font-weight: bold;">
									<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2" />
								</h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3">
								<h:graphicImage value="/img/iconos/today.png" width="16" height="16" style="border:0;" title="#{ms.citas_evento_msg_7 }" />
								<h:outputLabel value="#{ms.citas_evento_msg_8 }" />
								<h:outputLabel value="#{controlCitas.evento.fechaini }" style="font-weight: bold;">
									<f:convertDateTime pattern="HH:mm:ss" timeZone="GMT+2" />
								</h:outputLabel>
							</h:panelGrid>
							<h:panelGrid columns="3">
								<h:graphicImage value="/img/genericos/time.png" width="16" height="16" style="border:0;" title="#{ms.citas_evento_msg_9 }" />
								<h:outputLabel value="#{ms.citas_evento_msg_10 }" />
								<h:outputLabel value="#{controlCitas.evento.duracion } min" style="font-weight: bold;" />
							</h:panelGrid>
						</h:panelGrid>
						<rich:dataGrid value="#{controlCitas.huecoslibresdiarios}" binding="#{controlCitas.bindingGridHuecos }" id="panHuecosGrid" rendered="#{not empty controlCitas.huecoslibresdiarios}" var="hueco" columns="5" elements="15" width="600px">
					        <rich:panel bodyClass="pbody">
					             <f:facet name="header">
					                <h:outputText value="#{ms.citas_evento_msg_11 }" />
					             </f:facet>
					             <h:panelGrid columnClasses="alignCenter">		                			    
		    						<h:outputText value="#{hueco}" />
		    						<a4j:commandLink reRender="fechaInicioEventoHueco,fechaFinEventoHueco,duracionEventoHueco,panHuecoFechaSel,panCitasDemograficos" ajaxSingle="true" value="Seleccionar" actionListener="#{controlCitas.selHueco }">	
										<h:graphicImage value="/img/iconos/add.png" width="16" height="16" style="border:0;" title="#{ms.citas_evento_msg_12 }" />				
									</a4j:commandLink>		                    
					             </h:panelGrid>
					        </rich:panel>
					        <f:facet name="footer">
					           <rich:datascroller />
					        </f:facet>
					   </rich:dataGrid>
					</h:panelGrid>					
				   <a4j:commandLink reRender="fechaInicioEventoHueco,fechaFinEventoHueco,duracionEventoHueco,panSelectorHuecos,panHuecosGrid,panelHuecos,panHuecoFechaSel,panNoHuecos" ajaxSingle="true" rendered="#{controlCitas.evento.procedimiento ne 0 }" onclick="javascript:Richfaces.showModalPanel('buscando');" oncomplete="javascript:Richfaces.hideModalPanel('buscando');" actionListener="#{controlCitas.avanza1Dia }">	
						<h:graphicImage value="/img/timeline/moveright.png" width="16" height="16" style="border:0;" title="#{ms.citas_evento_msg_13 }" />				
					</a4j:commandLink>				   			 	        	               
			    </h:panelGrid>
		        
			</rich:panel>
		</h:panelGrid>
		<h:panelGrid columns="3" columnClasses="alignTop,alignTop,alignTop" id="panHorasHueco" rendered="#{controlCitas.agenda.gestionhuecos eq false }">
			<h:panelGrid id="fechaInicioEventoHueco">
				<h:outputLabel value="#{ms.citas_evento_msg_14 }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<rich:calendar datePattern="dd/MM/yyyy HH:mm" inputSize="15"
						disabled="#{controlCitas.evento.tododia eq true}"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlCitas.evento.fechaini }" />
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="fechaFinEventoHueco">
				<h:outputLabel value="#{ms.citas_evento_msg_15 }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<rich:calendar datePattern="dd/MM/yyyy HH:mm" inputSize="15"
						showWeeksBar="false" direction="bottom-left"
						disabled="#{controlCitas.evento.tododia eq true}"
						value="#{controlCitas.evento.fechafin }" />
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="duracionEventoHueco">
				<h:outputLabel value="#{ms.citas_evento_msg_16 }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<rich:inputNumberSpinner step="1" maxValue="99999"
						value="#{controlCitas.evento.duracion }" disabled="#{controlCitas.evento.tododia }"/>
				</h:panelGrid>
			</h:panelGrid>		
		</h:panelGrid>
		
		<rich:simpleTogglePanel switchType="client" label="#{ms.citas_evento_msg_17 }" opened="false">
			<h:panelGrid >
				<h:inputTextarea value="#{controlCitas.evento.descripcion }" id="descripcionEventoHueco" cols="110">
					<f:validateLength maximum="2000" />
				</h:inputTextarea>	
				<h:message for="descripcionEventoHueco" style="color:red" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:panelGrid>		
</ui:composition>
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
	
	<h:panelGrid id="panNuevaAgenda">	
		<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
			<h:panelGrid columns="2">
				<h:panelGrid columnClasses="alignTop">
					<h:outputLabel value="#{ms.citas_agenda_msg_2 }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText value="#{controlCitas.personal.nombre }" title="#{ms.citas_agenda_msg_2 }" size="45"/>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columnClasses="alignTop">
					<h:outputLabel value="#{ms.citas_agenda_msg_3 }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlCitas.personal.tipoagenda}">
					        <f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
					        <f:selectItem itemLabel="#{ms.citas_agenda_msg_4 }" itemValue="0" />
					        <f:selectItem itemLabel="#{ms.citas_agenda_msg_5 }" itemValue="1" />					        
					    </h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>							
			</h:panelGrid>			
			<h:panelGrid columnClasses="alignTop,alignTop" columns="2">
				<h:panelGrid>
					<h:outputLabel value="#{ms.citas_agenda_msg_6 }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputTextarea value="#{controlCitas.personal.descripcion }" id="descripcionAgenda" 
							title="#{ms.citas_agenda_msg_6 }" cols="43"> 
							<f:validateLength maximum="200" />
						</h:inputTextarea>	
						<h:message for="descripcionAgenda" style="color:red" />
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columnClasses="alignTop" width="100%">
					<h:outputLabel value="#{ms.citas_agenda_msg_7 }" style="font-weight: bold;"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneRadio value="#{controlCitas.personal.visibilidad}">
					        <f:selectItem itemLabel="#{ms.citas_agenda_msg_8 }" itemValue="0"/>
					        <f:selectItem itemLabel="#{ms.citas_agenda_msg_9 }" itemValue="1"/>					        
					    </h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>	
			</h:panelGrid>		
		</h:panelGrid>		
	</h:panelGrid>				
</ui:composition>
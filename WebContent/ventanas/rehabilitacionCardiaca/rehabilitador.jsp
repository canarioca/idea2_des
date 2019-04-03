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
	
		
			<t:fieldset>
				<h:panelGrid columns="2" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop" id="gridRehabilitador1">
					<h:panelGrid columns="2" >
						<h:outputLabel value="#{ms.general_fecha}" style="font-weight: bold;" />
						<br />
						<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;">
							<rich:calendar  datePattern="dd/MM/yyyy HH:mm" inputSize="15"
											showWeeksBar="false" direction="bottom-left"
											value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.fechaRehabilitador}" id="fechaRehabilitador" />
							<h:selectBooleanCheckbox value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.sedentarismo}" id="sedentarismo" />
							<h:outputLabel value="#{ms.reacar_txt_sedentarismo}" />
						</h:panelGrid>
						<br />
					</h:panelGrid>
				</h:panelGrid>
				
				<h:panelGrid columns="5" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop" id="gridRehabilitador2">
					<h:panelGrid>
						<h:outputLabel value="#{ms.reacar_txt_nivelEjercicio}" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
							<h:inputText onKeyPress="validateInput('[0-9]')" converter="javax.faces.Integer" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.nivelEjercicio}" id="nivelEjercicio" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_nivelEjercicio} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5">
							</h:inputText>		
						</h:panelGrid>	
					</h:panelGrid>
					<h:panelGrid>
						<h:outputLabel value="#{ms.reacar_txt_horasEjercicio}" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
							<h:inputText onKeyPress="validateInput('[0-9]')" converter="javax.faces.Integer" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.horasEjercicio}" id="horasEjercicio" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_horasEjercicio} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5">
							</h:inputText>																	
						</h:panelGrid>	
					</h:panelGrid>
					<h:panelGrid>
						<h:outputLabel value="#{ms.reacar_txt_FVC}" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
							<h:inputText onKeyPress="validateInput('[0-9]')" converter="javax.faces.Integer" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.parametroFVC}" id="parametroFVC" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_FVC} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5">
							</h:inputText>																
						</h:panelGrid>	
					</h:panelGrid>
					<h:panelGrid>
						<h:outputLabel value="#{ms.reacar_txt_FEVI1}" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
							<h:inputText onKeyPress="validateInput('[0-9]')" converter="javax.faces.Integer" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.parametroFEVI}" id="parametroFEVI" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_FEVI1} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5">
							</h:inputText>														
						</h:panelGrid>	
					</h:panelGrid>
					<h:panelGrid>
						<h:outputLabel value="#{ms.reacar_txt_FEVI1_FVC}" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
							<h:inputText onKeyPress="validateInput('[0-9]')" converter="javax.faces.Integer" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.ansiedadFEVIFVC}" id="ansiedadFEVIFVC" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_FEVI1_FVC} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5">
							</h:inputText>						
						</h:panelGrid>	
					</h:panelGrid>
				</h:panelGrid>
				
				<br />
				
				<t:fieldset legend ="#{ms.reacar_fieldset_problemasArticulares}">
					<h:selectOneRadio layout="spread" id="idSelectProbArticularesCheckBox" value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedProbArticulares}">
					    <f:selectItems value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemProbArticulares}" />
					</h:selectOneRadio>  
				</t:fieldset>
				
				<br />
				
				<t:fieldset legend ="#{ms.reacar_fieldset_problemasCognitivos}">
					<h:selectOneRadio layout="spread" id="idSelectProbCognitivosCheckBox" value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedProbCognitivos}">
					    <f:selectItems value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemProbCognitivos}" />
					</h:selectOneRadio>    
				</t:fieldset>
				
				<br />
				
				<t:fieldset legend ="#{ms.reacar_fieldset_problemasSensoriales}">
					<h:selectOneRadio layout="spread" id="idSelectProbSensorialesCheckBox" value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedProbSensoriales}">
					    <f:selectItems value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemProbSensoriales}" />
					</h:selectOneRadio>    
				</t:fieldset>
				
				<br />
				
				<t:fieldset legend ="#{ms.reacar_fieldset_nivelEducativoSanitario}">
					<h:selectOneRadio layout="spread" id="idSelectNivelEducativoCheckBox" value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectedNivelEducativo}">
					    <f:selectItems value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.rehabilitadorDTO.selectItemNivelEducativo}" />
					</h:selectOneRadio>     
				</t:fieldset>
				
			</t:fieldset>
</ui:composition>
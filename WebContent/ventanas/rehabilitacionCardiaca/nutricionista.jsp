<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich">
	
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop" id="gridPsicologa">
				<h:panelGrid columns="2" >
					<h:outputLabel value="#{ms.general_fecha}" style="font-weight: bold;" />
					<br />
					<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;">
						<rich:calendar  datePattern="dd/MM/yyyy HH:mm" inputSize="15"
										showWeeksBar="false" direction="bottom-left"
										value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.fechaCreacion}" />
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>

		<t:fieldset>
			<h:panelGrid columns="5" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop" id="gridPsicologa3">
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_escalaDietetica}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double" 
									 value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.escalaDietetica}"
									 id="idEscalaDietetica" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_escalaDietetica} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
							<f:validator validatorId="validadorNumerico" />  
						</h:inputText>	
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_perimetroAbdominal}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double"
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.perimetroAbdominal}" id="idPerimetroAbdominal" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_perimetroAbdominal} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
							<f:validator validatorId="validadorNumerico" />    	
						</h:inputText>								
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_perimetroCintura}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.perimetroCintura}" id="idPerimetroCintura" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_perimetroCintura} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
						   <f:validator validatorId="validadorNumerico" />    	
						</h:inputText>														
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_indiceCinturaCadera}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.indiceCinturaCadera}" id="idIndiceCinturaCadera" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_indiceCinturaCadera} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
						    <f:validator validatorId="validadorNumerico" />  	
						</h:inputText>																												
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_cinturaCadera}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.cinturaCadera}" id="idCinturaCadera" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_cinturaCadera} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
						    <f:validator validatorId="validadorNumerico" />  
						</h:inputText>																																										
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_indiceCinturaTalla}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.indiceCinturaTalla}" id="idIndiceCinturaTalla" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_indiceCinturaTalla} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
						    <f:validator validatorId="validadorNumerico" />  
						</h:inputText>																																										
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_masaMuscularEsqueletico}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.masaMuscularEsqueletico}" id="idMasaMuscularEsqueletico" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_masaMuscularEsqueletico} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
						   <f:validator validatorId="validadorNumerico" />  
						</h:inputText>																																									
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_masaGrasaCorporal}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.masaGrasaCorporal}" id="idMasaGrasaCorporala" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_masaGrasaCorporal} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
						    <f:validator validatorId="validadorNumerico" />  
						</h:inputText>																																										
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_porcentajeGrasaCorporal}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.porcentajeGrasaCorporal}" id="idPorcentajeGrasaCorporal" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_porcentajeGrasaCorporal} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
						    <f:validator validatorId="validadorNumerico" />  
						</h:inputText>																																									
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.reacar_txt_relacionCinturaCadera}" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
						<h:inputText onKeyPress="validateInput('[0-9]*')"  converter="javax.faces.Double" 
						             value="#{controlRehabilitacionCardiaca.rehabilitacionCardiacaDTO.nutricionistaDTO.relacionCinturaCadera}" id="idRelacionCinturaCadera" 
									 converterMessage="#{ms.mensajeErrorValidacionNumerico1} #{ms.reacar_txt_relacionCinturaCadera} #{ms.mensajeErrorValidacionNumerico2}"  
						             maxlength="5" >
						    <f:validator validatorId="validadorNumerico" />  
						</h:inputText>																																										
					</h:panelGrid>	
				</h:panelGrid>
			</h:panelGrid>
		</t:fieldset>
</ui:composition>
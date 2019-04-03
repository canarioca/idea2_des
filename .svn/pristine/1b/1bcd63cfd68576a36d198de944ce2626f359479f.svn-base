<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid width="100%" columnClasses="alignTop" 
		style="height: 500px;
		background-color: #ffffff;
		background-image:url(/cardioarritmiasMS/img/iconos/filter.png);
		background-repeat: no-repeat;
		background-position:right bottom;">
		<h:panelGrid width="60%">
			<h:outputLabel value="· Filtro Paciente" style="color: red;font-size: 14px;font-weight: bold;"/>
			<h:panelGrid width="100%" columns="2"
				columnClasses="alignTop,alignTop" cellspacing="0">
				<h:outputLabel value="Edad" style="font-weight: bold;" />
				<h:outputLabel value="Sexo" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:panelGrid columns="5" cellspacing="0">
						<h:outputLabel value="Mayor de "/>
						<h:inputText size="4" value="#{controlConsultas.dai.acv }"/>
						<h:outputLabel value=" años y menor de "/>
						<h:inputText size="4" value="#{controlConsultas.dai.ad }"/>
						<h:outputLabel value=" años."/>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.anosevo }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="Hombre" itemValue="1" />
						<f:selectItem itemLabel="Mujer" itemValue="2" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
	
			<rich:spacer height="20px"/>
			
			<a4j:jsFunction name="actrecambio" reRender="panImpl"/>
			<h:outputLabel value="· Filtro Fesfibriladores" style="color: red;font-size: 14px;font-weight: bold;"/>
			<h:panelGrid width="100%" columns="2" id="panImpl"
				columnClasses="alignTop,alignTop" cellspacing="0">
				<h:outputLabel value="Cardiopatía" style="font-weight: bold;" />
				<h:outputLabel value="Fracción eyección" style="font-weight: bold;" />
				
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%"
					columns="2">
					<h:panelGrid columns="2" columnClasses="alignMiddle,alignMiddle" 
						cellpadding="0" cellspacing="0" width="100%">
						<h:selectBooleanCheckbox value="#{controlConsultas.dai.isquemicab}" />
						<h:outputLabel value="Isquémica" />
					</h:panelGrid>
					<h:panelGrid columns="2" columnClasses="alignMiddle,alignMiddle" 
						cellpadding="0" cellspacing="0" width="100%">
						<h:selectBooleanCheckbox value="#{controlConsultas.dai.dilatnoisquemb}" />
						<h:outputLabel value="Dilatada no isquémica" />
					</h:panelGrid>
					<h:selectOneMenu value="#{controlConsultas.dai.valvular }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="Valvular" itemValue="1" />
						<f:selectItem itemLabel="Congénita" itemValue="2" />
						<f:selectItem itemLabel="Ninguna" itemValue="3" />
						<f:selectItem itemLabel="Otra" itemValue="4" />
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlConsultas.dai.brugada }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="Brugada" itemValue="1" />
						<f:selectItem itemLabel="QT largo" itemValue="2" />
						<f:selectItem itemLabel="QT corto" itemValue="3" />
						<f:selectItem itemLabel="TV catecolaminérgica" itemValue="4" />
						<f:selectItem itemLabel="Otra" itemValue="5" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.fraccion }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="&gt;50%" itemValue="1" />
						<f:selectItem itemLabel="41-50%" itemValue="2" />
						<f:selectItem itemLabel="36-40%" itemValue="3" />
						<f:selectItem itemLabel="31-35%" itemValue="4" />
						<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
					</h:selectOneMenu>
				</h:panelGrid>
			
				<rich:spacer height="5px"/>
				<rich:spacer height="5px"/>
			
				<h:outputLabel value="Enfermedad de conducción" style="font-weight: bold;" />
				<h:outputLabel value="IC" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:panelGrid columns="6" width="100%">
						<h:panelGrid cellpadding="0" columns="2">
							<h:selectBooleanCheckbox value="#{controlConsultas.dai.enfconduccion1 }"/>
							<h:outputLabel value="No"/>
						</h:panelGrid>
						<h:panelGrid cellpadding="0" columns="2">
							<h:selectBooleanCheckbox value="#{controlConsultas.dai.enfconduccion2 }"/>
							<h:outputLabel value="ENS"/>
						</h:panelGrid>
						<h:panelGrid cellpadding="0" columns="2">
							<h:selectBooleanCheckbox value="#{controlConsultas.dai.enfconduccion3 }"/>
							<h:outputLabel value="BAV"/>
						</h:panelGrid>
						<h:panelGrid cellpadding="0" columns="2">
							<h:selectBooleanCheckbox value="#{controlConsultas.dai.enfconduccion4 }"/>
							<h:outputLabel value="BRD"/>
						</h:panelGrid>
						<h:panelGrid cellpadding="0" columns="2">
							<h:selectBooleanCheckbox value="#{controlConsultas.dai.enfconduccion5 }"/>
							<h:outputLabel value="BRI"/>
						</h:panelGrid>
						<h:panelGrid cellpadding="0" columns="2">
							<h:selectBooleanCheckbox value="#{controlConsultas.dai.enfconduccion6 }"/>
							<h:outputLabel value="Otro"/>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.ic }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="No" itemValue="1" />
						<f:selectItem itemLabel="Si" itemValue="2" />
					</h:selectOneMenu>
				</h:panelGrid>
				
				<rich:spacer height="5px"/>
				<rich:spacer height="5px"/>
				
				<h:outputLabel value="Antecedentes de FA" style="font-weight: bold;" />
				<h:outputLabel value="Arritmia clínica" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.antecfa }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="No" itemValue="1" />
						<f:selectItem itemLabel="Si" itemValue="2" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.arrclinica }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="FV" itemValue="1" />
						<f:selectItem itemLabel="TVP" itemValue="2" />
						<f:selectItem itemLabel="TVMS" itemValue="3" />
						<f:selectItem itemLabel="TVNS" itemValue="4" />
						<f:selectItem itemLabel="Ninguna" itemValue="5" />
					</h:selectOneMenu>
				</h:panelGrid>
			
				<rich:spacer height="5px"/>
				<rich:spacer height="5px"/>
				
				<h:outputLabel value="Presentación clínica" style="font-weight: bold;" />
				<h:outputLabel value="EEF Previa" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.presclinica }" >
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="Asintomático" itemValue="4" />
						<f:selectItem itemLabel="Muerte súbita" itemValue="1" />
						<f:selectItem itemLabel="Síncope" itemValue="2" />
						<f:selectItem itemLabel="Otros síntomas" itemValue="3" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.eef }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="No" itemValue="1" />
						<f:selectItem itemLabel="Si" itemValue="2" />
					</h:selectOneMenu>
				</h:panelGrid>
				
				<rich:spacer height="5px"/>
				<rich:spacer height="5px"/>
				
				<h:outputLabel value="Prevención" style="font-weight: bold;" />
				<h:outputLabel value="Implantador" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.implante }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="Prevención primaria" itemValue="1" />
						<f:selectItem itemLabel="Prevención secundaria" itemValue="2" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.implantador }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="Cirujano" itemValue="1" />
						<f:selectItem itemLabel="Electrofisiológico" itemValue="2" />
						<f:selectItem itemLabel="Intensivista" itemValue="3" />
						<f:selectItem itemLabel="Otro" itemValue="4" />
						<f:selectItem itemLabel="EF + Cirujano" itemValue="5" />
					</h:selectOneMenu>
				</h:panelGrid>
				
				<rich:spacer height="5px"/>
				<rich:spacer height="5px"/>
				
				<h:outputLabel value="Generador" style="font-weight: bold;" />
				<h:outputLabel value="Recambio" style="font-weight: bold;"
					rendered="#{controlConsultas.dai.generador eq 2}" />
				<h:outputLabel value="" style="font-weight: bold;" 
					rendered="#{controlConsultas.dai.generador ne 2}"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%">
					<h:selectOneMenu onchange="actrecambio();"
						value="#{controlConsultas.dai.generador }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="Primoimplante" itemValue="1" />
						<f:selectItem itemLabel="Recambio" itemValue="2" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" rendered="#{controlConsultas.dai.generador eq 2}">	
					<h:selectOneMenu value="#{controlConsultas.dai.recambio }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="Por agotamiento" itemValue="1" />
						<f:selectItem itemLabel="Por complicaciones" itemValue="2" />
						<f:selectItem itemLabel="upgrade por cambio de indicación" itemValue="3" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:outputLabel value="" rendered="#{controlConsultas.dai.generador ne 2}"/>
				
				<rich:spacer height="5px"/>
				<rich:spacer height="5px"/>
				
				<h:outputLabel value="Inducción" style="font-weight: bold;" />
				<h:outputLabel value="Modelo generador" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.induc }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="No" itemValue="1" />
						<f:selectItem itemLabel="Si" itemValue="2" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%">
					<h:selectOneMenu value="#{controlConsultas.dai.modelo }">
						<f:selectItem itemLabel="(Seleccione)" itemValue="0" />
						<f:selectItem itemLabel="Monocameral" itemValue="1" />
						<f:selectItem itemLabel="Bicameral" itemValue="2" />
						<f:selectItem itemLabel="Tricameral" itemValue="3" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			
			<rich:spacer height="5px"/>
			
			<h:outputLabel value="Complicaciones" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="6" width="80%"
				columnClasses="alignMiddle,alignMiddle,alignMiddle,alignMiddle,alignMiddle,alignMiddle">
				<h:selectBooleanCheckbox value="#{controlConsultas.dai.complningunab }" />
				<h:outputLabel value="Ninguna" />
				<h:selectBooleanCheckbox value="#{controlConsultas.dai.complmuerteb }" />
				<h:outputLabel value="Muerte" />
				<h:selectBooleanCheckbox value="#{controlConsultas.dai.compltapb }" />
				<h:outputLabel value="Taponamiento cardiaco" />
				<h:selectBooleanCheckbox value="#{controlConsultas.dai.complneumb }" />
				<h:outputLabel value="Neumotorax" />
				<h:selectBooleanCheckbox value="#{controlConsultas.dai.compldisecb }" />
				<h:outputLabel value="Disección SC" />
				<h:selectBooleanCheckbox value="#{controlConsultas.dai.complotrob }" />
				<h:outputLabel value="Otro" />
				<h:selectBooleanCheckbox value="#{controlConsultas.dai.complsituab }" />
				<h:outputLabel value="Situación subóptima VI" />
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="2">
			<t:commandLink value="Pulse para generar la consulta de desfibriladores" actionListener="#{controlConsultas.generaEstadisticasDai}"
				target="_blank" style="font-size: 14px;font-weight: bold;" title="Generar Consulta"/>
			<t:commandLink actionListener="#{controlConsultas.generaEstadisticasDai}" target="_blank" title="Generar Consulta">
				<h:graphicImage value="/img/iconos/excel_icon.png" width="32" height="32" style="border: 0px;"/>
			</t:commandLink>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
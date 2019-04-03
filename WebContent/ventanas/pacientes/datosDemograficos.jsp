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

	<h:outputText value="#{ms.pat_demograficos_title }"
		style="font-weight:bold;" />
	<rich:separator width="100%" height="1" />
	<h:panelGrid columns="4">
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.pat_consulta_cip }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText styleClass="estiloInput" size="15" maxlength="15"
					value="#{controlPacientes.filtro.nuhsa}" />
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.pat_consulta_nhc }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="2">
				<h:inputText styleClass="estiloInput" size="10" maxlength="10"
					value="#{controlPacientes.filtro.nhc}"
					readonly="#{controlPacientes.modPaci eq 1}" />
				<a4j:commandLink reRender="infoPacienteDemo,nuevoCasa"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
					actionListener="#{controlPacientes.buscaPacientePorNhc}"
					title="#{ms.pat_demograficos_msg_1 }">
					<h:graphicImage value="/img/iconos/bd.jpg" style="border:0;" />
				</a4j:commandLink>
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid columns="1">
			<h:outputText value="#{ms.pat_consulta_nss }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="1">
				<h:inputText styleClass="estiloInput" size="12" maxlength="12"
					value="#{controlPacientes.filtro.nss1}" />
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid columns="1">
			<h:outputText value="#{ms.pat_consulta_nif }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="2">
				<h:inputText styleClass="estiloInput" size="15" maxlength="10"
					value="#{controlPacientes.filtro.dni}"
					readonly="#{controlPacientes.modPaci eq 1}" />
				<a4j:commandLink reRender="tablaPacientesBdu"
					actionListener="#{controlPacientes.buscaPacientePorNifBdu}"
					title="#{ms.pat_demograficos_msg_2 }"
					onclick="javascript:Richfaces.showModalPanel('acceso')"
					oncomplete="#{controlPacientes.checkbudape}">
					<h:graphicImage value="/img/iconos/bd.jpg" style="border:0;" />
				</a4j:commandLink>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid columns="2">
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.pat_consulta_nombre }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText styleClass="estiloInput" size="20" maxlength="100"
					value="#{controlPacientes.filtro.nombre}" />
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.pat_consulta_apellidos }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="3">
				<h:inputText styleClass="estiloInput" size="30" maxlength="100"
					value="#{controlPacientes.filtro.apellid1}" />
				<h:inputText styleClass="estiloInput" size="30" maxlength="100"
					value="#{controlPacientes.filtro.apellid2}" />
				<a4j:commandLink reRender="tablaPacientesBdu"
					actionListener="#{controlPacientes.buscaPacientePorApellidosBdu}"
					title="#{ms.pat_demograficos_msg_3 }"
					onclick="javascript:Richfaces.showModalPanel('acceso')"
					oncomplete="#{controlPacientes.checkbudape}">
					<h:graphicImage value="/img/iconos/bd.jpg" style="border:0;" />
				</a4j:commandLink>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>

	<h:panelGrid columns="4">
		<h:panelGrid columns="1">
			<h:outputText value="#{ms.pat_consulta_sexo }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneRadio value="#{controlPacientes.filtro.sexo}">
					<f:selectItem itemLabel="#{ms.hombre }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.mujer }" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid columns="1" id="fnac">
			<h:outputText value="#{ms.pat_consulta_fnac }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
					popup="true" showInput="true" enableManualInput="true"
					value="#{controlPacientes.filtro.fechaNaci}">
					<a4j:support event="onchanged" reRender="fnac,edadPacidolor" />
				</rich:calendar>
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid columns="1" id="edadPacidolor">
			<h:outputText value="#{ms.edad }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText styleClass="estiloInput" size="10" maxlength="10"
					value="#{controlPacientes.filtro.edad}" readonly="true" />
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="1">		
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.exit}">
					<a4j:support event="onclick" reRender="exitus" ajaxSingle="true"
					actionListener="#{controlPacientes.cambiaExitus }"/>
				</h:selectBooleanCheckbox>
				<h:outputText value="#{ms.exitus }"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			</h:panelGrid>	
			<h:panelGrid>
				<h:panelGrid id="exitus" >
					<h:panelGrid columns="3" rendered="#{controlPacientes.filtro.sitclin.exit eq true}"
						style="border-top: solid 1px;border-color: black;">
						<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
							popup="true" showInput="true" enableManualInput="true"
							value="#{controlPacientes.filtro.sitclin.exitusfecha}">
							<a4j:support event="onchanged" reRender="exitus" />
						</rich:calendar>
						<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.exitdesc}">
							<a4j:support event="onclick" reRender="exitus" ajaxSingle="true"
								actionListener="#{controlPacientes.cambiaExitusDesconocido }"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.desconocido }" />
					</h:panelGrid>				
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="3" rendered="false">
			<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.exit}">
				<a4j:support event="onclick" reRender="exitus" ajaxSingle="true"
					actionListener="#{controlPacientes.cambiaExitus }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.exitus }" />
			<h:panelGrid id="exitus1" >
				<h:panelGrid columns="3" rendered="#{controlPacientes.filtro.sitclin.exit eq true}">
					<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
						popup="true" showInput="true" enableManualInput="true"
						value="#{controlPacientes.filtro.sitclin.exitusfecha}">
						<a4j:support event="onchanged" reRender="exitus" />
					</rich:calendar>
					<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.exitdesc}">
						<a4j:support event="onclick" reRender="exitus" ajaxSingle="true"
							actionListener="#{controlPacientes.cambiaExitusDesconocido }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.desconocido }" />
				</h:panelGrid>				
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>

	<h:panelGrid columns="2" id="panproc">
		<h:panelGrid columns="1" id="procPacidolor">
			<h:outputText value="#{ms.pat_demograficos_msg_4 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.filtro.procedencia }">
					<f:selectItems value="#{controlPacientes.caracter }"/>				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="1" id="hprocPacidolor">
			<h:outputText value="#{ms.pat_demograficos_msg_5 }"
				style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.filtro.hprocedencia }">
					<f:selectItems value="#{controlPacientes.hospital }"/>				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
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

	<h:panelGrid id="tablaPacientesBdu">
		<h:outputText rendered="#{empty controlPacientes.lstPacientes}" 
			value="No se han encontrado resultados o superan las 50 coincidencias"
			style="font-size: 16px;font-weight: bold;"/>
		<rich:dataTable var="linea" value="#{controlPacientes.lstPacientes}"
			id="tablapacientes" rows="8" rendered="#{!empty controlPacientes.lstPacientes}"
			binding="#{controlPacientes.tablaBindingBusqueda}">
			<rich:column id="c1">
				<f:facet name="header">
					<h:outputText value="DNI" styleClass="textoAzul" />
				</f:facet>
				<a4j:commandLink
					onclick="javascript:Richfaces.showModalPanel('bloqueoCarga');"
					oncomplete="javascript:Richfaces.hideModalPanel('busqueda');javascript:Richfaces.hideModalPanel('bloqueoCarga');"
					reRender="panelContenidoGlobal"
					actionListener="#{controlPacientes.seleccionaPacienteBdu}">
					<h:outputText value="#{linea.dni}" styleClass="textoNegro" />
				</a4j:commandLink>
			</rich:column>

			<rich:column id="c2" width="200">
				<f:facet name="header">
					<h:outputText value="Nombre del Paciente" styleClass="textoAzul"/>
				</f:facet>
				<a4j:commandLink
					onclick="javascript:Richfaces.showModalPanel('bloqueoCarga');"
					oncomplete="javascript:Richfaces.hideModalPanel('busqueda');javascript:Richfaces.hideModalPanel('bloqueoCarga');"
					reRender="panelContenidoGlobal"
					actionListener="#{controlPacientes.seleccionaPacienteBdu}">
					<h:outputText
						value="#{linea.apellid1} #{linea.apellid2},#{linea.nombre}" styleClass="textoNegro" />
				</a4j:commandLink>
			</rich:column>

			<rich:column>
				<f:facet name="header">
					<h:outputText value="NUHSA" styleClass="textoAzul" />
				</f:facet>
				<a4j:commandLink
					onclick="javascript:Richfaces.showModalPanel('bloqueoCarga');"
					oncomplete="javascript:Richfaces.hideModalPanel('busqueda');javascript:Richfaces.hideModalPanel('bloqueoCarga');"
					reRender="panelContenidoGlobal"
					actionListener="#{controlPacientes.seleccionaPacienteBdu}">
					<h:outputText value="#{linea.nuhsa}" styleClass="textoNegro" />
				</a4j:commandLink>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="F.Nacimiento" styleClass="textoAzul" />
				</f:facet>
				<h:outputText value="#{linea.fechaNaciString}">
					<f:convertDateTime pattern="dd/MM/yyyy" timeZone="Europe/Paris" />
				</h:outputText>
			</rich:column>
			<rich:column>
				<f:facet name="header">
					<h:outputText value="Teléfono" styleClass="textoAzul" />
				</f:facet>
				<h:outputText value="#{linea.telefono1}" />
			</rich:column>
			<rich:column width="200">
				<f:facet name="header">
					<h:outputText value="Dirección" styleClass="textoAzul" />
				</f:facet>
				<h:outputText
					value="#{linea.direccion} #{linea.poblacion} (#{linea.provincia})" />
			</rich:column>
			<f:facet name="footer">
				<rich:datascroller for="tablapacientes" renderIfSinglePage="false" fastStep="3">
					<f:facet name="first"><h:graphicImage url="/img/genericos/navegacion/first.png" /></f:facet>
					<f:facet name="last"><h:graphicImage url="/img/genericos/navegacion/last.png" /></f:facet>
					<f:facet name="fastrewind"><h:graphicImage url="/img/genericos/navegacion/frwd.png" /></f:facet>
					<f:facet name="fastforward"><h:graphicImage url="/img/genericos/navegacion/ffwd.png" /></f:facet>
					<f:facet name="previous"><h:graphicImage url="/img/genericos/navegacion/rwd.png" /></f:facet>
					<f:facet name="next"><h:graphicImage url="/img/genericos/navegacion/fwd.png" /></f:facet>
					<f:facet name="first_disabled"><h:graphicImage url="/img/genericos/navegacion/first.png" /></f:facet>
					<f:facet name="last_disabled"><h:graphicImage url="/img/genericos/navegacion/last.png" /></f:facet>
					<f:facet name="fastrewind_disabled"><h:graphicImage url="/img/genericos/navegacion/frwd.png" /></f:facet>
					<f:facet name="fastforward_disabled"><h:graphicImage url="/img/genericos/navegacion/ffwd.png" /></f:facet>
					<f:facet name="previous_disabled"><h:graphicImage url="/img/genericos/navegacion/rwd.png" /></f:facet>
					<f:facet name="next_disabled"><h:graphicImage url="/img/genericos/navegacion/fwd.png" /></f:facet>
				</rich:datascroller>
			</f:facet>
		</rich:dataTable>
	</h:panelGrid>
</ui:composition>
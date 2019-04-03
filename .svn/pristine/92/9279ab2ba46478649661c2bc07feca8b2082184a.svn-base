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

	<h:panelGrid columns="2" width="100%">
		<h:outputText value="#{ms.le_pat_title }"
			style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;font-weight: bold;" />
		<a4j:commandLink reRender="pannuevole" rendered="#{controlPacientes.pacienteSelect.codigo ne null }"
			actionListener="#{controlPacientes.limpiaregistrole }"
			oncomplete="javascript:Richfaces.showModalPanel('newle');">
			<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
				style="border:0;" title="#{ms.le_pat_msg_1 }" />
		</a4j:commandLink>
	</h:panelGrid>
	<h:panelGrid style="border-top: solid 1px;border-color: black;"
		id="tablaPendiente" width="100%">
		<a4j:jsFunction name="cargaRegistro" oncomplete="cargaRegistro2();">
			<a4j:actionparam name="par1" assignTo="#{controlPacientes.leselec }" />
		</a4j:jsFunction>
		<a4j:jsFunction name="cargaRegistro2"
			reRender="pannuevole"
			actionListener="#{controlPacientes.modregistrole }"
			oncomplete="javascript:Richfaces.showModalPanel('newle');"/>
		<a4j:jsFunction name="actualiza"
			oncomplete="javascript:Richfaces.showModalPanel('buscando');actualiza2();">
			<a4j:actionparam name="par1" assignTo="#{controlPacientes.leselec }" />
		</a4j:jsFunction>
		<a4j:jsFunction name="actualiza2"
			actionListener="#{controlPacientes.cambiaEstado}"
			oncomplete="javascript:Richfaces.hideModalPanel('buscando');" />
		<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
			value="#{controlPacientes.lstespera }">
			<t:column width="18px">
				<a4j:commandLink reRender="pannuevole"
					onclick="cargaRegistro(#{linea.codigoLe });">
					<h:graphicImage value="/img/iconos/moduser.png" width="16" height="16"
						style="border:0;" title="Modificar registro de lista de espera" />
				</a4j:commandLink>
			</t:column>
			<t:column id="estado" width="60px">
				<f:facet name="header">
					<h:outputText value="#{ms.le_pat_msg_2 }" />
				</f:facet>
				<h:selectOneMenu value="#{linea.estado }"
					onchange="actualiza(#{linea.codigoLe });">
					<f:selectItem itemValue="1" itemLabel="#{ms.le_pat_msg_3 }" />
					<f:selectItem itemValue="5" itemLabel="#{ms.le_pat_msg_4 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.le_pat_msg_5 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.le_pat_msg_6 }" />
					<f:selectItem itemValue="4" itemLabel="#{ms.le_pat_msg_7 }" />
				</h:selectOneMenu>
			</t:column>
			<t:column width="10%" headerstyleClass="left">
				<f:facet name="header">
					<h:outputText value="#{ms.le_pat_msg_16 }" />
				</f:facet>
				<h:outputText value="#{linea.codigoLe }" />
			</t:column>
			<t:column width="10%" headerstyleClass="left">
				<f:facet name="header">
					<h:outputText value="#{ms.le_pat_msg_8 }" />
				</f:facet>
				<h:outputText value="#{linea.ingresostr }" />
			</t:column>
			<t:column headerstyleClass="left">
				<f:facet name="header">
					<h:outputText value="#{ms.le_pat_msg_9 }" />
				</f:facet>
				<h:outputText value="#{linea.arritmia }" />
			</t:column>
			<t:column headerstyleClass="left">
				<f:facet name="header">
					<h:outputText value="#{ms.le_pat_msg_10 }" />
				</f:facet>
				<h:outputText value="#{linea.procedimiento }" />
			</t:column>
			<t:column headerstyleClass="left">
				<f:facet name="header">
					<h:outputText value="#{ms.le_pat_msg_11 }" />
				</f:facet>
				<h:outputText value="#{linea.tratamiento1 }" />
			</t:column>
			<t:column headerstyleClass="left">
				<f:facet name="header">
					<h:outputText value="#{ms.le_pat_msg_12 }" />
				</f:facet>
				<h:outputText value="#{linea.caracter }" />
			</t:column>
			<t:column width="10%" headerstyleClass="left">
				<f:facet name="header">
					<h:outputText value="#{ms.le_pat_msg_13 }" />
				</f:facet>
				<h:outputText value="#{linea.reclamacionstr }" />
			</t:column>
			<t:column width="10%" headerstyleClass="left">
				<f:facet name="header">
					<h:outputText value="#{ms.le_pat_msg_14 }" />
				</f:facet>
				<h:panelGrid columns="2">
					<h:selectOneMenu value="#{linea.incluidopor }" disabled="true">
						<f:selectItems value="#{controlPacientes.operadoresle}" />															
					</h:selectOneMenu>
				</h:panelGrid>
			</t:column>
		</t:dataTable>
	</h:panelGrid>

	<rich:modalPanel id="newle" autosized="true" zindex="2000" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.le_pat_msg_15 }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlPacientes.guardaLe }"
					reRender="tablaPendiente"
					onclick="javascript:Richfaces.hideModalPanel('newle');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.guardar }"/>
				</a4j:commandLink>
				<h:graphicImage value="/img/aplicacion/icoCancelar.png"
					style="border:0;cursor:pointer;"
					onclick="javascript:Richfaces.hideModalPanel('newle')"
					title="#{ms.cerrar }" />
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="pannuevole" width="100%">
			<ui:include src="/ventanas/pacientes/nuevale.jsp" />
		</h:panelGrid>
	</rich:modalPanel>
</ui:composition>
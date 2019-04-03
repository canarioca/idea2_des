<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid cellpadding="0" cellspacing="0" columns="2"
		columnClasses="left,right" width="100%" id="panablas">
		<h:panelGrid cellspacing="0" columns="2">
			<h:outputLabel value="#{ms.eef_tab_abl_sust }:" />
			<h:inputText size="3" maxlength="3" value="#{controlEef.eef.ablaciondto.sustrato }" />
		</h:panelGrid>
		<h:panelGrid cellspacing="0" columns="4" columnClasses="right">
			<a4j:commandLink style="text-align: right;" reRender="panablas,pana"
				onclick="if (!confirm('#{ms.eef_tab_abl_warn_nueva}'))return false;javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
				actionListener="#{controlEef.addAblacion }">
				<h:graphicImage url="/img/iconos/new.png" style="border:0px;"
					width="22" height="22" title="#{ms.eef_tab_abl_add }" />
			</a4j:commandLink>
			<a4j:commandLink style="text-align: right;" reRender="panablas,pana,panEef,panComplicacionesPacienteEefAbl"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
				actionListener="#{controlEef.guardaAblacion }">
				<h:graphicImage url="/img/iconos/save.png" style="border:0px;"
					title="#{ms.eef_tab_abl_guardar }" />
			</a4j:commandLink>
			<a4j:commandLink style="text-align: right;" reRender="panablas,pana"
				rendered="#{controlEef.eef.ablaciondto.idablacion ne null}"
				onclick="if (!confirm('#{ms.eef_tab_abl_warn_eliminar}'))return false;javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
				actionListener="#{controlEef.borraAblacion }">
				<h:graphicImage url="/img/iconos/borra.png" style="border:0px;"
					title="#{ms.eef_tab_abl_eliminar }" width="22" height="22"/>
			</a4j:commandLink>
			<a4j:commandLink style="text-align: right;" reRender="tablaAb"
				actionListener="#{controlEef.verAblacion }" 
				onclick="javascript:Richfaces.showModalPanel('listaablas');">
				<h:graphicImage url="/img/iconos/list-view.png" style="border:0px;"
					width="22" height="22" title="#{ms.eef_tab_abl_ver }" />
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>

	<h:panelGrid width="100%" id="pana">
		<rich:tabPanel switchType="client" contentClass="estiloFondo">
			<rich:tab label="#{ms.eef_tab_abl_tab_abl }">
				<a4j:include viewId="/ventanas/eef/estudios/ablacion/ablacion.jsp" />
			</rich:tab>
			<rich:tab label="#{ms.eef_tab_abl_tab_res }">
				<a4j:include viewId="/ventanas/eef/estudios/ablacion/resultados.jsp" />
			</rich:tab>
			<rich:tab label="#{ms.eef_tab_abl_tac_compl }">
				<a4j:include viewId="/ventanas/eef/estudios/ablacion/complicaciones.jsp" />
			</rich:tab>
			<rich:tab label="#{ms.eef_tab_abl_tac_coment }">
				<h:outputLabel value="#{ms.eef_tab_abl_tac_coment }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="100%">
					<h:inputTextarea rows="6" cols="120"
						value="#{controlEef.eef.ablaciondto.comentarios }" id="comentariosEefAbl">
						<f:validateLength maximum="4000" />
					</h:inputTextarea>	
					<h:message for="comentariosEefAbl" style="color:red" />
				</h:panelGrid>
			</rich:tab>
		</rich:tabPanel>
	</h:panelGrid>
	
	<rich:modalPanel id="listaablas" height="200" width="400" zindex="2000">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.eef_tab_abl_modal_lista }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid>
				<f:attribute name="align" value="right" />
				<h:graphicImage url="/img/aplicacion/icoCancelar.png"
					style="cursor:pointer"
					onclick="javascript: Richfaces.hideModalPanel('listaablas');" />
			</h:panelGrid>
		</f:facet>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaAb" width="82%">
			<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
				value="#{controlEef.eef.ablaciones }"
				binding="#{controlEef.binlstabl }">
				<t:column width="90%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_abl_modal_num_sust }"/>
					</f:facet>
					<a4j:commandLink reRender="panablas,pana"
						actionListener="#{controlEef.cargaAblacion }"
						onclick="javascript: Richfaces.hideModalPanel('listaablas');"
						value="#{ms.eef_tab_abl_sust } #{linea.sustrato }"/>
				</t:column>
			</t:dataTable>
		</h:panelGrid>
	</rich:modalPanel>
</ui:composition>
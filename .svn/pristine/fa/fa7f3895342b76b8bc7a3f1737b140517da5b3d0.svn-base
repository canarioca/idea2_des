<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid cellpadding="0" cellspacing="0" columns="2"
		columnClasses="left,right" width="100%" id="panTaqui">
		<h:panelGrid cellspacing="0" columns="2">
			<h:outputLabel
				value="#{ms.eef_tab_taq_numero } #{controlEef.eef.taquicardidto.numtaqui }" />
		</h:panelGrid>
		<h:panelGrid cellspacing="0" columns="4" columnClasses="right">
			<a4j:commandLink style="text-align: right;" reRender="panTaqui,panta"
				onclick="if (!confirm('#{ms.eef_tab_taq_warn_nueva}'))return false;javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
				actionListener="#{controlEef.addTaqui }">
				<h:graphicImage url="/img/iconos/new.png" style="border:0px;"
					width="22" height="22" title="#{ms.eef_tab_taq_nueva }" />
			</a4j:commandLink>
			<a4j:commandLink style="text-align: right;" reRender="panTaqui,panta,panEef"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
				actionListener="#{controlEef.guardaTaquicardia }">
				<h:graphicImage url="/img/iconos/save.png" style="border:0px;"
					title="#{ms.eef_tab_taq_guardar }" />
			</a4j:commandLink>
			<a4j:commandLink style="text-align: right;" reRender="panTaqui,panta"
				rendered="#{controlEef.eef.taquicardidto.idtaqui ne null}"
				onclick="if (!confirm('#{ms.eef_tab_taq_warn_eliminar}'))return false;javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
				actionListener="#{controlEef.borraTaquicardia }">
				<h:graphicImage url="/img/iconos/borra.png" style="border:0px;"
					title="#{ms.eef_tab_taq_eliminar }" width="22" height="22"/>
			</a4j:commandLink>
			<a4j:commandLink style="text-align: right;" reRender="tablaTq"
				actionListener="#{controlEef.verTaqui }" 
				onclick="javascript:Richfaces.showModalPanel('listataqs');">
				<h:graphicImage url="/img/iconos/list-view.png" style="border:0px;"
					width="22" height="22" title="#{ms.eef_tab_taq_ver }" />
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>

	<h:panelGrid width="100%" id="panta">
		<h:panelGrid width="84%">
			<rich:tabPanel switchType="client">
				<rich:tab label="#{ms.eef_tab_taq_tab_taq }">
					<a4j:include
						viewId="/ventanas/eef/estudios/taquicardias/taqui01bis.jsp" />
				</rich:tab>
				<rich:tab label="#{ms.eef_tab_taq_tab_modind }">
					<a4j:include
						viewId="/ventanas/eef/estudios/taquicardias/taqui02bis.jsp" />
				</rich:tab>
				<rich:tab label="#{ms.eef_tab_taq_tab_eep }" rendered="#{controlEef.isEEP }">
					<a4j:include
						viewId="/ventanas/eef/estudios/taquicardias/taqui03bis.jsp" />
				</rich:tab>
				<rich:tab label="#{ms.eef_tab_taq_tab_farma }">
					<a4j:include
						viewId="/ventanas/eef/estudios/taquicardias/taqui04bis.jsp" />
				</rich:tab>
				<rich:tab label="#{ms.eef_tab_taq_tab_com }">
					<h:outputLabel value="#{ms.eef_tab_taq_comentarios }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						width="100%">
						<h:inputTextarea rows="6" cols="120"
							value="#{controlEef.eef.taquicardidto.comentarios }" id="comentariosEefTq">
							<f:validateLength maximum="4000" />
						</h:inputTextarea>	
						<h:message for="comentariosEefTq" style="color:red" />
					</h:panelGrid>
				</rich:tab>
			</rich:tabPanel>
		</h:panelGrid>
	</h:panelGrid>
	<rich:modalPanel id="listataqs" height="200" width="400" zindex="2000">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.eef_tab_taq_modal_lista }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid>
				<f:attribute name="align" value="right" />
				<h:graphicImage url="/img/aplicacion/icoCancelar.png"
					style="cursor:pointer"
					onclick="javascript: Richfaces.hideModalPanel('listataqs');" />
			</h:panelGrid>
		</f:facet>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaTq" width="82%">
			<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
				value="#{controlEef.eef.lsttaquicardias }"
				binding="#{controlEef.binlsttaq }">
				<t:column width="90%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_taq_numero_taqui }"/>
					</f:facet>
					<a4j:commandLink reRender="panTaqui,panta"
						actionListener="#{controlEef.cargaTaqui }"
						onclick="javascript: Richfaces.hideModalPanel('listataqs');"
						value="#{linea.numtaqui }"/>
				</t:column>
				<t:column headerstyleClass="left">
					<f:facet name="header">
						<h:outputLabel value="#{ms.eef_tab_taq_comentarios }"/>
					</f:facet>
					<a4j:commandLink reRender="panTaqui,panta"
						actionListener="#{controlEef.cargaTaqui }"
						onclick="javascript: Richfaces.hideModalPanel('listataqs');"
						value="#{linea.comentarios }"/>
				</t:column>
			</t:dataTable>
		</h:panelGrid>
	</rich:modalPanel>
</ui:composition>
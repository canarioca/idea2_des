<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="90%">
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.eef_tab_vacc }" style="font-weight: bold;" />
			<a4j:commandLink reRender="tablaVias" actionListener="#{controlEef.eef.addVias }">
				<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
					style="border:0;" title="#{ms.eef_tab_vacc_add }" />
			</a4j:commandLink>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaVias" width="100%">
			<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
				value="#{controlEef.eef.viasdto }"
				binding="#{controlEef.eef.binvias }">
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_vacc_tipo }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.idvia }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.tipovia }" />
						<a4j:support event="onchange" reRender="tablaVias" ajaxSingle="true"
								actionListener="#{controlEef.controlVias }"/>
					</h:selectOneMenu>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_vacc_sentido }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.idsentido }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.sentidos }" />
					</h:selectOneMenu>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_vacc_tipocond }" />
					</f:facet>
					<h:selectOneMenu value="#{linea.idtipo }"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
						<f:selectItems value="#{controlEef.tipoconduccion }" />
					</h:selectOneMenu>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_vacc_loc }" />
					</f:facet>
					<a4j:commandLink actionListener="#{controlEef.eef.obtenVia }"
						oncomplete="javascript:Richfaces.showModalPanel('localizaciones');"
						reRender="panlocal">
						<h:graphicImage url="/img/iconos/location.png"
							style="cursor:pointer;border:0px;" title="Ver localización"/>
					</a4j:commandLink>
				</t:column>
				<t:column headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_vacc_ca }" title="#{ms.eef_tab_vacc_ca_title }"/>
					</f:facet>
					<h:inputText value="#{linea.ca }" size="6" maxlength="20"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
				</t:column>
				<t:column headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_vacc_cr }" title="#{ms.eef_tab_vacc_cr_title }" />
					</f:facet>
					<h:inputText value="#{linea.cr }" size="6" maxlength="20"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;"/>
				</t:column>
				<t:column headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.eef_tab_vacc_rr }" title="#{ms.eef_tab_vacc_rr_title }"/>
					</f:facet>
					<h:inputText value="#{linea.rr }" size="6" maxlength="20"
						style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;"/>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaVias" actionListener="#{controlEef.eef.delVias }">
						<h:graphicImage url="/img/iconos/minus.png"
							title="#{ms.eef_tab_vacc_del }" width="16" height="16"
							style="border: 0px;" />
					</a4j:commandLink>
				</t:column>
			</t:dataTable>
		</h:panelGrid>
		
		<rich:spacer height="10"/>
		
		<h:outputLabel value="#{ms.eef_tab_vacc_com }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="100%">
			<h:inputTextarea rows="6" cols="120" value="#{controlEef.eef.coment_vias }" id="comentariosEefVias">
				<f:validateLength maximum="2000" />
			</h:inputTextarea>	
			<h:message for="comentariosEefVias" style="color:red" />
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
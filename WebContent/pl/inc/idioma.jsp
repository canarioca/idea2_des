<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:form>
		<h:panelGrid columns="5">
			<f:attribute name="align" value="right" />
			<h:commandLink style="font-weight:bold;border:0;color:#FFFFFF;font-size:12px;"
				actionListener="#{selectorIdioma.seleccionaEs}" title="#{ms.login_es }">
				<h:graphicImage value="/img/iconos/es_flag.png" 
				    styleClass="pic" width="14" height="14" title="#{ms.login_es }"/>
			</h:commandLink>
			<h:commandLink style="font-weight:bold;border:0;color:#FFFFFF;font-size:12px;"
				actionListener="#{selectorIdioma.seleccionaCat}" title="#{ms.login_cat }">
				<h:graphicImage value="/img/iconos/cat_flag.png" 
				    styleClass="pic" width="14" height="14" title="#{ms.login_cat }"/>
			</h:commandLink>
			<h:commandLink style="font-weight:bold;border:0;color:#FFFFFF;font-size:12px;"
				actionListener="#{selectorIdioma.seleccionaEus}" title="#{ms.login_eus }">
				<h:graphicImage value="/img/iconos/eus_flag.png" 
				    styleClass="pic" width="14" height="14" title="#{ms.login_eus }"/>
			</h:commandLink>
			<h:commandLink style="font-weight:bold;border:0;color:#FFFFFF;font-size:12px;"
				actionListener="#{selectorIdioma.seleccionaEn}" title="#{ms.login_en }">
				<h:graphicImage value="/img/iconos/gb_flag.png" 
				    styleClass="pic" width="14" height="14" title="#{ms.login_en }"/>
			</h:commandLink>
			<h:commandLink style="font-weight:bold;border:0;color:#FFFFFF;font-size:12px;"
				actionListener="#{selectorIdioma.seleccionaPt}" title="#{ms.login_pt }">
				<h:graphicImage value="/img/iconos/pt_flag.png" 
				    styleClass="pic" width="14" height="14" title="#{ms.login_pt }"/>
			</h:commandLink>
		</h:panelGrid>
	</h:form>
</ui:composition>
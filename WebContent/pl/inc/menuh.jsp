<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jp="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j">

	<h:form id="formularioMenuGeneral" style="border:0;">
		<h:panelGrid columns="2" width="100%">
			<h:panelGrid>
				<rich:toolBar itemSeparator="line">
					<rich:dropDownMenu value="Menú 1">
						<rich:menuItem value="Submenú 1.1" icon="" />
						<rich:menuItem value="Submenú 1.2" icon="" />
					</rich:dropDownMenu>
					<rich:dropDownMenu value="Menú 2">
						<rich:menuItem value="Submenú 2.1" icon="" />
					</rich:dropDownMenu>
					<rich:dropDownMenu value="Menú 3">
						<rich:menuItem value="Menú 3.1" icon="" />
					</rich:dropDownMenu>
					<h:commandLink
						style="font-weight:bold;border:0;color:#FFFFFF;font-size:12px;"
						action="#{loginForm.acnCerrarSesion}" immediate="true">
						<h:outputText value="Salir de la aplicación"
							style="font-weight:bold;border:0;color:#FFFFFF;" />
					</h:commandLink>
				</rich:toolBar>
			</h:panelGrid>
			<h:panelGrid width="100%" id="panelBotones" columnClasses="right">
				<f:attribute name="align" value="right" />
				<a4j:commandButton image="/img/iconos/Acceder/acceder_48x48.png"/>
			</h:panelGrid>
		</h:panelGrid>
	</h:form>
</ui:composition>
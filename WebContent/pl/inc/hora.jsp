<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:outputLabel value="#{loginForm.hora}"/>
	<h:outputLabel value=" #{ms.hora_msg_1 } #{loginForm.sesionUsuario.usuario}" 
		rendered="#{loginForm.sesionUsuario.usuario ne null}"/>	
</ui:composition>
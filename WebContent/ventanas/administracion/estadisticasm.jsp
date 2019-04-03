<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="formUsuarios">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelMensual">

				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                 	 background-image:url(/cardioarritmiasMS/img/iconos/estadistica.png);
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="Resumen de actividad mensual" style="color: white;" />
							<h:panelGrid columns="4" columnClasses="right">
								<a4j:commandLink
									actionListener="#{controlEstadisticas.limpiaMensual}"
									style="align:right;" reRender="panelMensual">
									<h:graphicImage url="/img/iconos/limpia.png" title="Limpiar"
										styleClass="hvn_enlImagen" width="24" height="24"
										style="border:none;" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panelMensual"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlEstadisticas.guardaResumenMes }">
									<h:graphicImage url="/img/iconos/save.png" style="border:0px;"
										title="Guardar test" />
								</a4j:commandLink>
								<h:commandLink 
									actionListener="#{controlEstadisticas.imprimeResumenMes}"
									target="_blank">
									<h:graphicImage value="/img/iconos/print.png"
										width="22" height="22"
										style="border:none;" title="Imprimir Informe" />
								</h:commandLink>
								<a4j:commandLink title="Enviar informe" actionListener="#{controlEstadisticas.enviaInforme}">
									<h:graphicImage value="/img/iconos/forward-mail.png" width="24"
										height="24" style="border:0;" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>

					<a4j:jsFunction name="recargaDatos" actionListener="#{controlEstadisticas.recargaDatosMes }"
							reRender="panelMensual"/>
					<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
						<h:outputText value="Seleccione mes y año"
							style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
						<h:selectOneMenu value="#{controlEstadisticas.datosmes.mes }" onchange="recargaDatos();">
							<f:selectItems value="#{controlEstadisticas.meses }"/>
						</h:selectOneMenu>
						<rich:inputNumberSpinner cycled="true" enableManualInput="false" inputSize="5" minValue="2000" 
							maxValue="#{controlEstadisticas.maxanio }" value="#{controlEstadisticas.datosmes.anio }"/>
					</h:panelGrid>
					<rich:spacer height="30px"/>
					<h:outputText value="Introduzca el número de mesas basculantes de este mes y el total acumulado"
							style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" width="30%">
						<h:panelGrid columns="2">
							<h:outputText value="mensual"/> 
							<h:inputText size="5" maxlength="5" value="#{controlEstadisticas.datosmes.mesasmes }"/>
							<h:outputText value="acumulado"/>
							<h:inputText size="5" maxlength="5" value="#{controlEstadisticas.datosmes.mesastot }"/>
						</h:panelGrid>
					</h:panelGrid>
					<rich:spacer height="30px"/>
					<h:outputText value="Introduzca el número de registradores insertables de eventos (Holter insertable) de este mes y el total acumulado"
						style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" width="40%">
						<h:panelGrid columns="2">
							<h:outputText value="mensual"/> 
							<h:inputText size="5" maxlength="5" value="#{controlEstadisticas.datosmes.riemes }"/>
							<h:outputText value="acumulado"/>
							<h:inputText size="5" maxlength="5" value="#{controlEstadisticas.datosmes.rietot }"/>
						</h:panelGrid>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
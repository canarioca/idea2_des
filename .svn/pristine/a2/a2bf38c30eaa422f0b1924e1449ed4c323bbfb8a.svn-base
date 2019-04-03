<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="inicio">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panMarcapasos">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicodai">
							<h:outputLabel value="Módulo de Marcapasos - DEMO"
								style="color: white;" />
							<h:panelGrid columns="6" columnClasses="right">
								<h:outputLabel value="Fecha" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlMarcapasos.fecha}" />
								<h:outputLabel value="Generador de Informe MP" style="color: white;" />
								<h:commandLink rendered="true" 
									actionListener="#{controlMarcapasos.imprimeInformes}"
									target="_blank">
									<h:graphicImage value="/img/iconos/print.png"
										width="22" height="22"
										style="border:none;" title="Imprimir Informe" 
										onclick=""/>
								</h:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
				
				<rich:tabPanel switchType="client">
						<rich:tab label="Información Clínica">
							<a4j:include viewId="paneles/info.jsp"/>
						</rich:tab>
						<rich:tab label="Centro de Marcapasos">
							<a4j:include viewId="paneles/centro.jsp"/>
						</rich:tab>
						<rich:tab label="Generador">
							<a4j:include viewId="paneles/generador.jsp"/>
						</rich:tab>
						<rich:tab label="Electrodos">
							<a4j:include viewId="paneles/electrodos.jsp"/>
						</rich:tab>
					</rich:tabPanel>
				
				
				</rich:panel>			
			</h:panelGrid>
			
		</h:form>
	</ui:define>
</ui:composition>
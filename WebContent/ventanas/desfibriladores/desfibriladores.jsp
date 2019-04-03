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
				style="margin-top: 15px;" id="panDesfibrilador">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicodai">
							<h:outputLabel value="Registro Nacional de DAI - Recogida de Datos"
								style="color: white;" />
							<h:panelGrid columns="7" columnClasses="right">
								<h:outputLabel value="Nº Desfibrilador" style="color: white;" />
								<h:inputText size="10" maxlength="5"
									value="#{controlDesfibriladores.desf.ndai}" />
								<h:outputLabel value="Fecha" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left" value="#{controlDesfibriladores.desf.fecha}"/>
								<a4j:commandLink style="text-align: right;"
									reRender="panDesfibrilador" actionListener="#{controlDesfibriladores.limpia }">
									<h:graphicImage url="/img/iconos/new.png" style="border:0px;" 
										title="Limpiar y generar nueva hoja" width="22" height="22"/>
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panDesfibrilador,tablaPacientesBdu"
									onclick="javascript:Richfaces.showModalPanel('episodios');"
									actionListener="#{controlDesfibriladores.preguarda }"
									rendered="#{controlDesfibriladores.desf.episodio eq null}">
									<h:graphicImage url="/img/iconos/save.png" style="border:0px;"
										title="Guardar hoja" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panDesfibrilador"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlDesfibriladores.guarda }"
									rendered="#{controlDesfibriladores.desf.episodio ne null}">
									<h:graphicImage url="/img/iconos/save.png" style="border:0px;"
										title="Guardar hoja" />
								</a4j:commandLink>
								<h:commandLink
									actionListener="#{controlDesfibriladores.imprimeInforme}"
									rendered="#{controlDesfibriladores.desf.codigoDesfibrilador ne null }"
									target="_blank" action="recarga">
									<h:graphicImage value="/img/iconos/print.png"
										width="22" height="22"
										style="border:none;" title="Imprimir Informe" />
								</h:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<rich:tabPanel switchType="client">
						<rich:tab label="Paciente">
							<a4j:include viewId="paneles/paciente.jsp"/>
						</rich:tab>
						<rich:tab label="Historia Cardiovascular">
							<a4j:include viewId="paneles/historia.jsp"/>
						</rich:tab>
						<rich:tab label="Antecedentes de Arritmias Ventriculares">
							<a4j:include viewId="paneles/antecedentes.jsp"/>
						</rich:tab>
						<rich:tab label="Implante">
							<a4j:include viewId="paneles/implante.jsp"/>
						</rich:tab>
						<rich:tab label="Complicaciones Intraoperatorias">
							<a4j:include viewId="paneles/complicaciones.jsp"/>
						</rich:tab>
						<rich:tab label="Programación del Dispositivo">
							<a4j:include viewId="paneles/programacion.jsp"/>
						</rich:tab>
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodios" autosized="true" minHeight="350" minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="Lista de episodios del paciente"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>
						<f:attribute name="align" value="right" />
						<h:graphicImage url="/img/aplicacion/icoCancelar.png"
							style="cursor:pointer"
							onclick="javascript: Richfaces.hideModalPanel('episodios');" />
					</h:panelGrid>
				</f:facet>
				<ui:include src="/ventanas/desfibriladores/episodios.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">	
	<ui:define name="contenido">
		<h:form id="inicioSeguimientosRegEv">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
						 style="margin-top: 15px;" id="panSeguimientoRegEv">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
                     <f:facet name="header">
                     	<h:panelGrid columns="8" width="65%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicosegregev">
							<h:outputLabel value="#{ms.segregev_title }" style="color: white;" />
							<h:panelGrid columns="4" columnClasses="right">
								<h:outputLabel value="#{ms.segregev_fecha }" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlSeguimientosRegEventos.seg.fecha}" >
									<a4j:support event="onchanged" reRender="panSeguimientoRegEv" />
								</rich:calendar>
								<h:outputLabel value="#{ms.segregev_remoto }" style="font-weight: bold;color: white;"/>
	                     		<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.seg.segrem}">
	                     			<a4j:support event="onclick" ajaxSingle="true"
	                     				actionListener="#{controlSeguimientosRegEventos.seguimientoRemoto }"/>
	                     		</h:selectBooleanCheckbox>													
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.segregev_progr }" style="color: white;font-weight: bold;"/>
								<h:panelGrid>
									<h:selectOneMenu value="#{controlSeguimientosRegEventos.seg.tiposeguimiento}">
									    <f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
										<f:selectItem itemValue="1" itemLabel="#{ms.segregev_progr_op1 }" />
										<f:selectItem itemValue="2" itemLabel="#{ms.segregev_progr_op2 }" />		
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
	                 		<a4j:commandLink style="text-align: right;" reRender="panSeguimientoRegEv,tablaPacientesBdu,panicosegregev" 
	                 			onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('episodios');" 
	                 			actionListener="#{controlSeguimientosRegEventos.preguarda }" rendered="#{controlSeguimientosRegEventos.proc.idepisodio eq null and controlSeguimientosRegEventos.editable}">
								<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;" title="#{ms.guardar }"/>
							</a4j:commandLink>                 		
							<a4j:commandLink style="text-align: right;" reRender="panSeguimientoRegEv,panicosegregev"
								onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								actionListener="#{controlSeguimientosRegEventos.guarda }" rendered="#{controlSeguimientosRegEventos.proc.idepisodio ne null and controlSeguimientosRegEventos.editable}">
								<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;" title="#{ms.guardar }" />
							</a4j:commandLink>
							<a4j:commandLink style="text-align: right;" reRender="panSeguimientoRegEv"
								onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								actionListener="#{controlSeguimientosRegEventos.eliminar }" action="menuprincipal"
								rendered="#{controlSeguimientosRegEventos.seg.idseg ne null and loginForm.acceso.privs.borrado eq 1}">
								<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
									title="#{ms.eliminar }" />
							</a4j:commandLink>
							<h:commandLink actionListener="#{controlSeguimientosRegEventos.imprimeInforme}"
								rendered="#{controlSeguimientosRegEventos.seg.idseg ne null }" target="_blank">
								<h:graphicImage value="/img/iconos/informe_especial.png"
									width="22" height="22" style="border:none;" title="#{ms.imprimir_informe }" />
							</h:commandLink>														
						</h:panelGrid>
                     </f:facet>
                     <h:panelGrid>
                     	
                     	 <rich:tabPanel switchType="client" selectedTab="nameHojaRevisionSegRegEv">
                     	 	<rich:tab label="#{ms.segregev_tab1_sitclin }">
								<a4j:include viewId="paneles/indicacion_reg.jsp"/>
							</rich:tab>
							<rich:tab label="#{ms.segregev_tab2_datos }" name="nameHojaRevisionSegRegEv">
								<a4j:include viewId="paneles/hoja_seguimiento_reg.jsp" />
							</rich:tab>
                     	 </rich:tabPanel>
                     </h:panelGrid>	
                </rich:panel>
			</h:panelGrid>
			
			<rich:modalPanel id="episodios" autosized="true" minHeight="350" minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.segregev_modal_epi_title }"
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
				<ui:include src="/ventanas/seguimientos_eventos/episodios.jsp" />
			</rich:modalPanel>
			
		</h:form>
	</ui:define>
</ui:composition>
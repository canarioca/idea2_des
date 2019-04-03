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
						 style="margin-top: 15px;" id="panImplante">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
                     <f:facet name="header">
                     	<h:panelGrid columns="3" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicoimp">
							<h:outputLabel value="#{ms.imp_dispositivos_title }"
								style="color: white;" />
							<h:panelGrid columns="10" columnClasses="right">
								<h:outputLabel value="#{ms.imp_dispositivos_nproc }" style="color: white;" />
								<h:inputText size="10" maxlength="5"
									value="#{controlImplantes.impl.nproc}" />
								<h:outputLabel value="#{ms.imp_dispositivos_fecha }" style="color: white;" 
									rendered="#{controlImplantes.impl.interprev eq false}"/>
								<h:outputLabel value="#{ms.imp_dispositivos_fecha_int_previa }" style="color: white;" 
									rendered="#{controlImplantes.impl.interprev eq true}"/>
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlImplantes.impl.fechaimplante}" rendered="#{controlImplantes.actualizacion eq false}">
									<a4j:support event="onchanged" reRender="panImplante,panComplicacionesPacienteImp" actionListener="#{controlImplantes.compruebaFechas }"/>
								</rich:calendar>
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlImplantes.impl.fechaimplante}" rendered="#{controlImplantes.actualizacion eq true}"
									onclick="if (!confirm('#{ms.war_guarda_fecha}')) return false;">
									<a4j:support event="onchanged" reRender="panImplante" actionListener="#{controlImplantes.compruebaFechas }"/>
								</rich:calendar>
								<a4j:commandLink style="text-align: right;" reRender="panImplante,tablaPacientesBdu,panicoimp"
									onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('episodios');"
									actionListener="#{controlImplantes.preguarda }"
									rendered="#{controlImplantes.proc.idepisodio eq null and controlImplantes.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panImplante,panicoimp"
									actionListener="#{controlImplantes.guarda }"
									onclick="if (!confirm('#{ms.war_guarda_2}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									rendered="#{controlImplantes.actualizacion eq false and controlImplantes.proc.idepisodio ne null and controlImplantes.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panImplante,panicoimp"
									onclick="if (!confirm('#{ms.war_guarda_impl}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlImplantes.guarda }"
									rendered="#{controlImplantes.actualizacion eq true and controlImplantes.proc.idepisodio ne null and controlImplantes.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panImplante"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlImplantes.eliminarImplante }" action="menuprincipal"
									rendered="#{controlImplantes.actualizacion eq true and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
								</a4j:commandLink>
								<h:commandLink
									actionListener="#{controlImplantes.imprimeInforme}"
									rendered="#{((controlImplantes.previoimp eq true &amp;&amp; controlImplantes.actualizacion eq true) || controlImplantes.completado)}"
									target="_blank">
									<h:graphicImage value="/img/iconos/informe_especial.png"
										width="22" height="22"
										style="border:none;" title="#{ms.imprimir }" />
								</h:commandLink>
								<h:commandLink
									actionListener="#{controlImplantes.imprimeInformeEspecifico}" action="recarga"
									rendered="#{((controlImplantes.previoimp eq true &amp;&amp; controlImplantes.actualizacion eq true) || controlImplantes.completado)&amp;&amp; (controlImplantes.tipogen eq 1 || controlImplantes.tipogen eq 2 || controlImplantes.tipogen eq 3 || controlImplantes.tipogen eq 4 || controlImplantes.tipogen eq 5 || controlImplantes.tipogen eq 6)}"
									target="_blank">
									<h:graphicImage value="/img/iconos/informe.png"
										width="22" height="22"
										style="border:none;" title="#{ms.imp_dispositivos_imprimir_informe }" />
								</h:commandLink>
								<h:outputLabel value="#{ms.integracion_inf }" style="color: white;" 
									rendered="#{controlImplantes.proc.integrado eq 1 }"/>
							</h:panelGrid>
							<h:panelGrid columns="2" columnClasses="right">
								<h:outputLabel value="#{ms.imp_dispositivos_tipo_proc }" style="color: white;" />
								<h:selectOneMenu value="#{controlImplantes.tipoprocmanual }">
									<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
									<f:selectItem itemLabel="#{ms.proc_956 }" itemValue="956" />
									<f:selectItem itemLabel="#{ms.proc_1059 }" itemValue="1059" />
									<f:selectItem itemLabel="#{ms.proc_1060 }" itemValue="1060" />
									<f:selectItem itemLabel="#{ms.proc_1085 }" itemValue="1085" />
									<f:selectItem itemLabel="#{ms.proc_1086 }" itemValue="1086" />
									<f:selectItem itemLabel="#{ms.proc_957 }" itemValue="957" />
									<f:selectItem itemLabel="#{ms.proc_993 }" itemValue="993" />
									<f:selectItem itemLabel="#{ms.proc_1090 }" itemValue="1090" />
									<a4j:support event="onchange" reRender="panImplante" />															
								</h:selectOneMenu>
							</h:panelGrid>
						</h:panelGrid>
                     </f:facet>
                     <rich:tabPanel switchType="client" selectedTab="#{controlImplantes.selectedtab}">
						<rich:tab label="#{ms.imp_dispositivos_tab_ind }" name="tabIndicacionImplantes">
							<a4j:include viewId="paneles/indicacion.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.imp_dispositivos_tab_himp }" name="tabHojaImplanteImplantes">
							<a4j:include viewId="paneles/hojaimplante.jsp" id="panelHojaImplante" />
						</rich:tab>
						<rich:tab label="#{ms.imp_dispositivos_tab_ev }">
							<a4j:include viewId="paneles/evolucion.jsp"/>
						</rich:tab>
					</rich:tabPanel>
                </rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodios" autosized="true" minHeight="350" minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.imp_dispositivos_episodios_modal_title }"
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
				<ui:include src="/ventanas/implantes/episodios.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>

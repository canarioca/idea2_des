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
			<h:panelGrid width="100%" styleClass="index_text_center" id="cabregevext">
				<h:outputLabel styleClass="index_text_center" style="color: white;font-weight: bold;font-size: 10px;" 
					value="#{controlRegEvExt.tiempo }"/>
			</h:panelGrid>
			<a4j:poll reRender="cabregevext,panAnalisisRegEvExtControl,panRegEvExtEstado" interval="1000" />
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panRegEvExt">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicoRegEvExt">
							<h:outputLabel value="#{ms.elr_title }"
								style="color: white;" />
							<h:panelGrid columns="10" columnClasses="right">
								<h:outputLabel value="#{ms.elr_nproc }" style="color: white;" />
								<h:inputText size="10" maxlength="6"
									value="#{controlRegEvExt.regevext.nproc }" />
								<h:outputLabel value="#{ms.elr_fecha }" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlRegEvExt.regevext.fechacolocacion }" />
								<a4j:commandLink style="text-align: right;"
									reRender="panRegEvExt,tablaPacientesBdu,menu,panicoRegEvExt"
									onclick="javascript:Richfaces.showModalPanel('episodios');"
									actionListener="#{controlRegEvExt.preguarda }"
									rendered="#{controlRegEvExt.proc.idepisodio eq null and controlRegEvExt.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;"
									reRender="panRegEvExt,menu,panicoRegEvExt"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlRegEvExt.guarda }"
									rendered="#{controlRegEvExt.proc.idepisodio ne null and controlRegEvExt.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<h:commandLink actionListener="#{controlRegEvExt.imprimeInformeUnificado}"
									rendered="#{controlRegEvExt.regevext.idevento ne null }"
									target="_blank" action="recarga">
									<h:graphicImage value="/img/iconos/informe_especial.png" width="22"
										height="22" style="border:none;" title="#{ms.imprimir_informe }" />
								</h:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panRegEvExt"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlRegEvExt.eliminar }"
									rendered="#{controlRegEvExt.regevext.idevento ne null and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
								</a4j:commandLink>
								<h:panelGrid columns="2" columnClasses="right" id="panRegEvExtEstado"
									rendered="#{controlRegEvExt.regevext.idevento ne null }">
									<h:outputLabel value="#{ms.elr_estado_title}" style="color: white;" />
									<h:selectOneMenu value="#{controlRegEvExt.regevext.estado }" disabled="true">
										<f:selectItem itemLabel="#{ms.elr_estado_op100 }" itemValue="100" />
										<f:selectItem itemLabel="#{ms.elr_estado_op0 }" itemValue="0" />
										<f:selectItem itemLabel="#{ms.elr_estado_op1 }" itemValue="1" />
										<f:selectItem itemLabel="#{ms.elr_estado_op2 }" itemValue="2" />
										<f:selectItem itemLabel="#{ms.elr_estado_op3 }" itemValue="3" />
										<f:selectItem itemLabel="#{ms.elr_estado_op_1 }" itemValue="-1" />
										<f:selectItem itemLabel="#{ms.elr_estado_op_2 }" itemValue="-2" />
										<f:selectItem itemLabel="#{ms.elr_estado_op_3 }" itemValue="-3" />
										<f:selectItem itemLabel="#{ms.elr_estado_op_4 }" itemValue="-4" />														
									</h:selectOneMenu>
								</h:panelGrid>
								<a4j:commandLink style="text-align: right;"
									reRender="panRegEvExt,tablaPacientesBduPrt,panicoRegEvExt"
									onclick="javascript:Richfaces.showModalPanel('protocolos');"
									actionListener="#{controlRegEvExt.consultaProtocolos }"
									rendered="#{controlRegEvExt.proc.idprocedimiento ne null and controlRegEvExt.editable}">
									<h:graphicImage url="/img/iconos/protocolo.png" style="border:0px;"
										title="#{ms.vincular }" width="22" height="22"/>
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panRegEvExt"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlRegEvExt.verificaInfoRepositorio }"
									rendered="#{controlRegEvExt.regevext.idevento ne null and controlRegEvExt.regevext.estado ne 0}">
									<h:graphicImage url="/img/iconos/repo_check.png" style="border:0px;" width="24" height="24"
										title="#{ms.holter24h_verifica_title }" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<rich:tabPanel switchType="client" selectedTab="#{controlRegEvExt.selectedtab}">
						<rich:tab label="#{ms.elr_tab1_sitclin_title }" name="tabIndicacionRegEvExt">
							<a4j:include viewId="indicacion.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.elr_tab2_col_title }" name="tabColocacionRegEvExt">
							<a4j:include viewId="colocacion.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.elr_tab3_ana_title }" name="tabAnalisisRegEvExt" rendered="#{controlRegEvExt.regevext.idevento ne null and controlRegEvExt.regevext.estado ne 0}">
							<a4j:include viewId="analisis.jsp" />
						</rich:tab>
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodios" autosized="true" minHeight="350"
				minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.elr_modal_epi_title }"
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
				<ui:include src="/ventanas/regevext/episodios.jsp" />
			</rich:modalPanel>
			<rich:modalPanel id="protocolos" autosized="true" minHeight="350"
				minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.prot_modal_epi_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>
						<f:attribute name="align" value="right" />
						<h:graphicImage url="/img/aplicacion/icoCancelar.png"
							style="cursor:pointer"
							onclick="javascript: Richfaces.hideModalPanel('protocolos');" />
					</h:panelGrid>
				</f:facet>
				<ui:include src="/ventanas/regevext/protocolos.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
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
			<a4j:poll reRender="cabpaci" interval="120000" />
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panRegistrador">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicoregs">
							<h:outputLabel value="#{ms.regev_title }"
								style="color: white;" />
							<h:panelGrid columns="9" columnClasses="right">
								<h:outputLabel value="#{ms.regev_nproc_title }" style="color: white;" />
								<h:inputText size="10" maxlength="6"
									value="#{controlRegistrador.registrador.nproc}" />
								<h:outputLabel value="#{ms.regev_fecha_title }" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlRegistrador.registrador.fecha}" />
								<a4j:commandLink style="text-align: right;"
									reRender="panRegistrador"
									actionListener="#{controlRegistrador.limpia }">
									<h:graphicImage url="/img/iconos/new.png" style="border:0px;"
										title="#{ms.regev_limpiar_title }"
										width="22" height="22" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;"
									reRender="panRegistrador,tablaPacientesBdu,menu,panicoregs"
									onclick="javascript:Richfaces.showModalPanel('episodios');"
									actionListener="#{controlRegistrador.preguarda }"
									rendered="#{controlRegistrador.registrador.episodio eq null and controlRegistrador.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;"
									reRender="panRegistrador,menu,panicoregs"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlRegistrador.guarda }"
									rendered="#{controlRegistrador.registrador.episodio ne null and controlRegistrador.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }o" />
								</a4j:commandLink>
								<h:commandLink
									actionListener="#{controlRegistrador.imprimeInforme}"
									rendered="#{controlRegistrador.registrador.idRegistrador ne null }"
									target="_blank" action="recarga">
									<h:graphicImage value="/img/iconos/informe_especial.png" width="22"
										height="22" style="border:none;" title="#{ms.imprimir_informe }" />
								</h:commandLink>
								<a4j:commandLink style="text-align: right;"
									reRender="panRegistrador,tablaPacientesBduPrt,panicoregs"
									onclick="javascript:Richfaces.showModalPanel('protocolos');"
									actionListener="#{controlRegistrador.consultaProtocolos }"
									rendered="#{controlRegistrador.proc.idprocedimiento ne null and controlRegistrador.editable}">
									<h:graphicImage url="/img/iconos/protocolo.png" style="border:0px;"
										title="#{ms.vincular }" width="22" height="22"/>
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panRegistrador"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlRegistrador.eliminarRegistrador }"
									rendered="#{controlRegistrador.registrador.idRegistrador ne null and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<a4j:jsFunction name="updev" reRender="eventos"/>
					<rich:tabPanel switchType="client">
						<rich:tab label="#{ms.regev_tab1_reg_title }">
							<h:panelGrid columns="2" width="100%" id="eventos"
								columnClasses="alignTop50,alignTop50">
								<h:panelGrid columns="2" width="90%" columnClasses="left,left">
									<h:outputLabel value="#{ms.regev_tab1_reg_ref }"
										style="font-weight: bold;" />
									<h:selectOneMenu
										value="#{controlRegistrador.registrador.referidor}">
										<f:selectItems value="#{controlRegistrador.referidores}" />
									</h:selectOneMenu>

									<rich:spacer width="10" />
									<rich:spacer width="10" />

									<h:outputLabel value="#{ms.regev_tab1_reg_med }" style="font-weight: bold;" />
									<h:selectOneMenu
										value="#{controlRegistrador.registrador.opMed}">
										<f:selectItems value="#{controlEef.primerOperador}" />
									</h:selectOneMenu>

									<rich:spacer width="10" />
									<rich:spacer width="10" />

									<h:outputLabel value="#{ms.regev_tab1_reg_enf }" style="font-weight: bold;" />
									<h:selectOneMenu
										value="#{controlRegistrador.registrador.opEnf}">
										<f:selectItems value="#{controlEef.enfermeras}" />
									</h:selectOneMenu>

									<rich:spacer width="10" />
									<rich:spacer width="10" />

									<h:outputLabel value="#{ms.regev_tab1_reg_com }" style="font-weight: bold;" />
									<h:inputTextarea
										value="#{controlRegistrador.registrador.comentarios }"
										rows="4" cols="55" id="comentariosReg">
										<f:validateLength maximum="2000" />
									</h:inputTextarea>	
									<h:message for="comentariosReg" style="color:red" />
									
								</h:panelGrid>

								<h:panelGrid columns="2" width="80%" columnClasses="left55,left">
									<h:outputLabel value="#{ms.regev_tab1_reg_ind }" style="font-weight: bold;" />
									<h:selectOneMenu
										value="#{controlRegistrador.registrador.indicacion}"
										onchange="updev();">
										<f:selectItem itemLabel="" itemValue="0" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_ind_op1 }" itemValue="1" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_ind_op2 }" itemValue="2" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_ind_op3 }" itemValue="3" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_ind_op4 }" itemValue="4" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_ind_op5 }" itemValue="5" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_ind_op6 }" itemValue="6" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_ind_op7 }" itemValue="7" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_ind_op8 }" itemValue="8" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_ind_op9 }" itemValue="9" />
									</h:selectOneMenu>

									<rich:spacer width="10" />
									<rich:spacer width="10" />

									<h:outputLabel value="#{ms.regev_tab1_reg_epi_pre }"
										style="font-weight: bold;"
										rendered="#{controlRegistrador.registrador.indicacion eq 1 or  controlRegistrador.registrador.indicacion eq 2 or controlRegistrador.registrador.indicacion eq 3}" />
									<h:selectOneMenu
										value="#{controlRegistrador.registrador.indicacionsincope}"
										onchange="updev();"
										rendered="#{controlRegistrador.registrador.indicacion eq 1 or  controlRegistrador.registrador.indicacion eq 2 or controlRegistrador.registrador.indicacion eq 3}">
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_epi_pre_op0 }" itemValue="0" />
										<f:selectItem itemLabel="#{ms.regev_tab1_reg_epi_pre_op1 }" itemValue="1" />
									</h:selectOneMenu>


									<h:outputLabel value="#{ms.regev_tab1_reg_epi_pre_2_atras }"
										style="font-weight: bold;"
										rendered="#{(controlRegistrador.registrador.indicacion eq 1 or  controlRegistrador.registrador.indicacion eq 2 or controlRegistrador.registrador.indicacion eq 3) and controlRegistrador.registrador.indicacionsincope eq 1}" />
									<h:inputText
										value="#{controlRegistrador.registrador.indicacionsincopen }"
										size="4" maxlength="4"
										rendered="#{(controlRegistrador.registrador.indicacion eq 1 or  controlRegistrador.registrador.indicacion eq 2 or controlRegistrador.registrador.indicacion eq 3) and controlRegistrador.registrador.indicacionsincope eq 1}" />

								</h:panelGrid>
							</h:panelGrid>
						</rich:tab>
						<rich:tab label="#{ms.regev_tab2_ecg_title }">
							<a4j:include viewId="ecg.jsp" />
						</rich:tab>

						<rich:tab label="#{ms.regev_tab3_imp_title }">
							<a4j:include viewId="implante.jsp" />
						</rich:tab>
						
						<rich:tab label="#{ms.regev_tab6_comp_title }">
							<a4j:include viewId="complicaciones/complicacion.jsp" />
						</rich:tab>

						<rich:tab label="#{ms.regev_tab4_score_title }">
							<a4j:include viewId="cardiopatia.jsp" />
						</rich:tab>

						<rich:tab label="#{ms.regev_tab5_exp_title }">
							<a4j:include viewId="explante.jsp" />
						</rich:tab>

					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodios" autosized="true" minHeight="350"
				minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.regev_modal_epi_title }"
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
				<ui:include src="/ventanas/eventos/episodios.jsp" />
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
				<ui:include src="/ventanas/eventos/protocolos.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
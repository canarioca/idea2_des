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
				style="margin-top: 15px;" id="panMesa">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicomesa">
							<h:outputLabel value="#{ms.mesa_title }"
								style="color: white;" />
							<h:panelGrid columns="9" columnClasses="right">
								<h:outputLabel value="#{ms.mesa_nproc_title }" style="color: white;" />
								<h:inputText size="10" maxlength="5"
									value="#{controlMesas.mesa.nproc}" />
								<h:outputLabel value="#{ms.mesa_fecha_title }" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlMesas.mesa.fecha}" />
								<a4j:commandLink style="text-align: right;"
									reRender="panMesa"
									actionListener="#{controlMesas.limpia }">
									<h:graphicImage url="/img/iconos/new.png" style="border:0px;"
										title="#{ms.mesa_limpiar_title }" width="22"
										height="22" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panMesa,tablaPacientesBdu,panicomesa"
									onclick="javascript:Richfaces.showModalPanel('episodios');"
									actionListener="#{controlMesas.preguarda }"
									rendered="#{controlMesas.mesa.episodio eq null and controlMesas.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panMesa,panicomesa"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlMesas.guarda }"
									rendered="#{controlMesas.mesa.episodio ne null and controlMesas.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<h:commandLink
									actionListener="#{controlMesas.imprimeInforme}"
									rendered="#{controlMesas.mesa.idMesa ne null }"
									target="_blank" action="recarga">
									<h:graphicImage value="/img/iconos/informe_especial.png" width="22"
										height="22" style="border:none;" title="#{ms.imprimir_informe }" />
								</h:commandLink>
								<a4j:commandLink style="text-align: right;"
									reRender="panMesa,tablaPacientesBduPrt,panicomesa"
									onclick="javascript:Richfaces.showModalPanel('protocolos');"
									actionListener="#{controlMesas.consultaProtocolos }"
									rendered="#{controlMesas.proc.idprocedimiento ne null and controlMesas.editable}">
									<h:graphicImage url="/img/iconos/protocolo.png" style="border:0px;"
										title="#{ms.vincular }" width="22" height="22"/>
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panMesa"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlMesas.eliminarMesa }"
									rendered="#{controlMesas.mesa.idMesa ne null and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<a4j:jsFunction name="updme" reRender="mesas"/>
					<rich:tabPanel switchType="client">
						<rich:tab label="#{ms.mesa_tab1_mesa_title }">

							<h:panelGrid columns="2" width="100%" id="mesas"
								columnClasses="alignTop50,alignTop50">
								<h:panelGrid columns="2" width="90%" columnClasses="left,left">
									<h:outputLabel value="#{ms.mesa_tab1_mesa_ref }" style="font-weight: bold;" />
									<h:selectOneMenu value="#{controlMesas.mesa.referidor}">
										<f:selectItems value="#{controlMesas.referidores }" />
									</h:selectOneMenu>
									
									<rich:spacer width="10" />
									<rich:spacer width="10" />
									
									<h:outputLabel value="#{ms.mesa_tab1_mesa_med }" style="font-weight: bold;" />
									<h:selectOneMenu value="#{controlMesas.mesa.opMed}">
										<f:selectItems value="#{controlEef.primerOperador }" />
									</h:selectOneMenu>
									
									<rich:spacer width="10" />
									<rich:spacer width="10" />
									
									<h:outputLabel value="#{ms.mesa_tab1_mesa_enf }" style="font-weight: bold;" />
									<h:selectOneMenu value="#{controlMesas.mesa.opEnf}">
										<f:selectItems value="#{controlEef.enfermeras }" />
									</h:selectOneMenu>
									
									<rich:spacer width="10" />
									<rich:spacer width="10" />
									
									<h:outputLabel value="#{ms.mesa_tab1_mesa_ntg }" style="font-weight: bold;" />
									<h:selectOneRadio value="#{controlMesas.mesa.ntg}">
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_ntg_op0 }" itemValue="0" />
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_ntg_op1 }" itemValue="1" />
									</h:selectOneRadio>
									
									<rich:spacer width="10" />
									<rich:spacer width="10" />
									
									<h:outputLabel value="#{ms.mesa_tab1_mesa_msg_com }" style="font-weight: bold;" />
									<h:inputTextarea value="#{controlMesas.mesa.comentarios }" rows="4" cols="55" id="comentariosMesa">
										<f:validateLength maximum="2000" />
									</h:inputTextarea>	
									<h:message for="comentariosMesa" style="color:red" />
								</h:panelGrid>
								
								<h:panelGrid columns="2" width="80%" columnClasses="left55,left">
									<h:outputLabel value="#{ms.mesa_tab1_mesa_msg_ind }" style="font-weight: bold;" />
									<h:selectOneMenu value="#{controlMesas.mesa.indicacion}" 
										onchange="updme();">
										<f:selectItem itemLabel="" itemValue="0" />
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_ind_op1 }" itemValue="1" />
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_ind_op2 }" itemValue="2" />
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_ind_op3 }" itemValue="3" />
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_ind_op4 }" itemValue="4" />
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_ind_op5 }" itemValue="5" />
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_ind_op6 }" itemValue="6" />
									</h:selectOneMenu>
									<h:outputLabel value="" rendered="#{controlMesas.mesa.indicacion eq 6 }"/>
									<h:inputText value="#{controlMesas.mesa.indicacionOtra }" size="60" maxlength="60" 
										rendered="#{controlMesas.mesa.indicacion eq 6 }" />
									
									<rich:spacer width="10" />
									<rich:spacer width="10" />
									
									<h:outputLabel value="#{ms.mesa_tab1_mesa_msg_epi_pre }" style="font-weight: bold;" />
									<h:selectOneMenu value="#{controlMesas.mesa.epiPrevios}">
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_epi_pre_op0 }" itemValue="0" />
										<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_epi_pre_op1 }" itemValue="1" />
									</h:selectOneMenu>
									
									<rich:spacer width="10" />
									<rich:spacer width="10" />
									
									<h:outputLabel value="#{ms.mesa_tab1_mesa_msg_epi_pre_2_atras }" style="font-weight: bold;" />
									<h:inputText value="#{controlMesas.mesa.epiSin }" size="4" maxlength="4"/>
									
									<rich:spacer width="10" />
									<rich:spacer width="10" />
									
									<h:outputLabel value="#{ms.mesa_tab1_mesa_msg_compl }" style="font-weight: bold;" />
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:selectOneMenu value="#{controlMesas.mesa.complicacionesSn}" onchange="updme();">
											<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_compl_op0 }" itemValue="0" />
											<f:selectItem itemLabel="#{ms.mesa_tab1_mesa_msg_compl_op1 }" itemValue="1" />
										</h:selectOneMenu>
										<a4j:commandLink reRender="tablacomp"
											rendered="#{controlMesas.mesa.complicacionesSn eq 1 }"
											actionListener="#{controlMesas.mesa.addComp }">
											<h:graphicImage value="/img/iconos/add.png" width="16"
												height="16" style="border:0;" title="#{ms.mesa_tab1_mesa_msg_compl_add }" />
										</a4j:commandLink>
									</h:panelGrid>
									
									<h:outputLabel value="" rendered="#{controlMesas.mesa.complicacionesSn eq 1 }"/>
									<h:panelGrid id="tablacomp" rendered="#{controlMesas.mesa.complicacionesSn eq 1 }">
										<t:dataTable styleClass="hor-minimalist-b" var="linea"
											width="100%" value="#{controlMesas.mesa.compArr }"
											binding="#{controlMesas.mesa.bincomp }">
											<t:column width="30%" headerstyleClass="left">
												<h:inputText size="20" value="#{linea.tmpString1 }" />
											</t:column>
											<t:column headerstyleClass="left">
												<a4j:commandLink reRender="tablacomp"
													actionListener="#{controlMesas.mesa.delComp }">
													<h:graphicImage url="/img/iconos/minus.png"
														title="#{ms.mesa_tab1_mesa_msg_compl_del }" width="16" height="16"
														style="border: 0px;" />
												</a4j:commandLink>
											</t:column>
										</t:dataTable>
									</h:panelGrid>
								</h:panelGrid>
							</h:panelGrid>
						</rich:tab>
						<rich:tab label="#{ms.mesa_tab2_ecg_title }">
							<a4j:include viewId="ecg.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.mesa_tab3_res_title }">
							<a4j:include viewId="resultados.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.mesa_tab4_score_title }">
							<a4j:include viewId="cardiopatia.jsp"/>
						</rich:tab>
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodios" autosized="true" minHeight="350" minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.mesa_modal_epi_title }"
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
				<ui:include src="/ventanas/basculante/episodios.jsp" />
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
				<ui:include src="/ventanas/basculante/protocolos.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
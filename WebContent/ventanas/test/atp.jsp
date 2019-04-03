<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox"
	xmlns:p="http://primefaces.prime.com.tr/ui" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="testatp">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="pantestatp">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" cellpadding="0"
							cellspacing="0" columnClasses="left,right">
							<h:outputLabel value="#{ms.testfarma_atp_title }" style="color: white;" />
							<h:panelGrid columns="7" columnClasses="right">
								<h:outputLabel value="#{ms.testfarma_nproc }" style="color: white;" />
								<h:inputText size="5" maxlength="5"
									value="#{controlTest.atp.nproc }" />
								<h:outputLabel value="#{ms.testfarma_fecha }" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlTest.atp.fecha }" />
								<a4j:commandLink style="text-align: right;" reRender="panATP,tablaPacientesBdu,pantestatp"
									onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('episodiosatp');"
									actionListener="#{controlTest.preguarda }"
									rendered="#{controlTest.proc.idepisodio eq null and controlTest.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panelATP,pantestatp,pantestatp"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									rendered="#{controlTest.proc.idepisodio ne null and controlTest.editable}"
									actionListener="#{controlTest.guardaATP }">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<h:commandLink rendered="#{controlTest.atp.codigoTest ne null }"
									actionListener="#{controlTest.imprimeATP}"
									target="_blank">
									<h:graphicImage value="/img/iconos/informe_especial.png"
										width="22" height="22"
										style="border:none;" title="#{ms.imprimir_informe }" />
								</h:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panelATP,pantestatp"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlTest.eliminaATPInterno }"
									rendered="#{controlTest.atp.codigoTest ne null and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" id="panelATP">
						<rich:tabPanel switchType="client">
							<rich:tab label="#{ms.testfarma_ind }">
								<h:panelGrid width="100%" columns="2"
									columnClasses="alignTop50,alignTop50" cellspacing="0">
									<h:outputLabel value="#{ms.testfarma_ind_motivo_clin }"
										style="font-weight: bold;" />
									<h:outputLabel value="#{ms.testfarma_ind_motivo_ecg }" style="font-weight: bold;" />
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%">
										<h:selectOneMenu value="#{controlTest.atp.clinico }">
											<f:selectItems value="#{controlTest.atpclinico }" />
										</h:selectOneMenu>
									</h:panelGrid>
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%">
										<h:selectOneMenu value="#{controlTest.atp.ecg }">
											<f:selectItems value="#{controlTest.atpecg }" />
										</h:selectOneMenu>
									</h:panelGrid>
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.testfarma_ecg_title }">
								<a4j:include viewId="ecgATP.jsp"/>
							</rich:tab>
							<rich:tab label="#{ms.testfarma_tab_res_title }">
								<h:panelGrid width="100%" columns="2"
									columnClasses="alignTop50,alignTop50" cellspacing="0">
									<h:outputLabel value="#{ms.testfarma_atp_tab_res_dos1 }" style="font-weight: bold;" />
									<h:outputLabel value="#{ms.testfarma_atp_tab_res_dos2 }" style="font-weight: bold;" />
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%">
										<h:selectOneMenu value="#{controlTest.atp.dosis1 }">
											<f:selectItems value="#{controlTest.atpdosis }" />
										</h:selectOneMenu>
									</h:panelGrid>
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%">
										<h:selectOneMenu value="#{controlTest.atp.dosis2 }">
											<f:selectItems value="#{controlTest.atpdosis }" />
										</h:selectOneMenu>
									</h:panelGrid>
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.testfarma_tab_compl_title }">
								<a4j:jsFunction name="updtcom" reRender="pancom"/>
								<h:panelGrid width="100%" columns="2" id="pancom"
									columnClasses="alignTop50,alignTop50" cellspacing="0">
									<h:outputLabel value="#{ms.testfarma_tab_compl_title }"
										style="font-weight: bold;" />
									<h:outputLabel value="#{ms.testfarma_tab_compl_tratamiento }" style="font-weight: bold;" />
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%">
										<h:selectOneMenu value="#{controlTest.atp.complica }" onchange="updtcom();">
											<f:selectItems value="#{controlTest.atpcomplica }" />
										</h:selectOneMenu>
										<h:inputText size="40" value="#{controlTest.atp.complicaotr}" rendered="#{controlTest.complicaatp eq 'OTRAS'}" maxlength="100"/>
									</h:panelGrid>
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%">
										<h:selectOneMenu value="#{controlTest.atp.tratam }">
											<f:selectItems value="#{controlTest.atptratam }" />
										</h:selectOneMenu>
									</h:panelGrid>
								</h:panelGrid>
							</rich:tab>
						</rich:tabPanel>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodiosatp" autosized="true" minHeight="350" minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.testfarma_modal_epi_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>
						<f:attribute name="align" value="right" />
						<h:graphicImage url="/img/aplicacion/icoCancelar.png"
							style="cursor:pointer"
							onclick="javascript: Richfaces.hideModalPanel('episodiosatp');" />
					</h:panelGrid>
				</f:facet>
				<ui:include src="/ventanas/test/episodiosATP.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
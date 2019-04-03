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
		<h:form id="testepi">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="pantestepi">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" cellpadding="0"
							cellspacing="0" columnClasses="left,right">
							<h:outputLabel value="#{ms.testfarma_epi_title }" style="color: white;" />
							<h:panelGrid columns="7" columnClasses="right">
								<h:outputLabel value="#{ms.testfarma_nproc }" style="color: white;" />
								<h:inputText size="10" maxlength="5"
									value="#{controlTest.epi.nproc }" />
								<h:outputLabel value="#{ms.testfarma_fecha }" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlTest.epi.fecha }" />
								<a4j:commandLink style="text-align: right;" reRender="panEPI,tablaPacientesBdu,pantestepi"
									onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('episodiosepi');"
									actionListener="#{controlTest.preguarda }"
									rendered="#{controlTest.proc.idepisodio eq null and controlTest.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panelEPI,pantestepi"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									rendered="#{controlTest.proc.idepisodio ne null and controlTest.editable}"
									actionListener="#{controlTest.guardaEPI }">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<h:commandLink rendered="#{controlTest.epi.codigoTest ne null }"
									actionListener="#{controlTest.imprimeEPI}"
									target="_blank">
									<h:graphicImage value="/img/iconos/informe_especial.png"
										width="22" height="22"
										style="border:none;" title="#{ms.imprimir_informe }" />
								</h:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panelEPI,pantestepi"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlTest.eliminaEpiInterno }"
									rendered="#{controlTest.epi.codigoTest ne null and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" id="panelEPI">
						<rich:tabPanel switchType="client">
							<rich:tab label="#{ms.testfarma_ind }">
								<h:panelGrid width="100%" columns="2"
									columnClasses="alignTop50,alignTop50" cellspacing="0">
									<h:outputLabel value="#{ms.testfarma_ind_motivo_clin }"
										style="font-weight: bold;" />
									<h:outputLabel value="#{ms.testfarma_ind_motivo_ecg }" style="font-weight: bold;" />
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%">
										<h:selectOneMenu value="#{controlTest.epi.clinico }">
											<f:selectItems value="#{controlTest.epiclinico }" />
										</h:selectOneMenu>
									</h:panelGrid>
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%">
										<h:selectOneMenu value="#{controlTest.epi.ecg }">
											<f:selectItems value="#{controlTest.epiecg }" />
										</h:selectOneMenu>
									</h:panelGrid>
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.testfarma_ecg_title }">
								<a4j:include viewId="ecgEPI.jsp"/>
							</rich:tab>
							<rich:tab label="#{ms.testfarma_tab_res_title }">
								<h:panelGrid width="100%" cellspacing="0">
									<a4j:jsFunction name="updres" reRender="panres"/>
									<h:outputLabel value="#{ms.testfarma_epi_res_resultado }" style="font-weight: bold;" />
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%" id="panres">
										<h:selectOneMenu value="#{controlTest.epi.dosis1 }"
											onchange="updres();">
											<f:selectItems value="#{controlTest.epires }"/>
										</h:selectOneMenu>
										<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
											rendered="#{controlTest.dosis1epi eq 'LQT1'}">
											<h:outputLabel value="#{ms.testfarma_epi_res_resultado_inc_qt }" />
											<h:inputText size="6" maxlength="7" value="#{controlTest.epi.picoqt }"/>
										</h:panelGrid>
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
										<h:selectOneMenu value="#{controlTest.epi.complica }" onchange="updtcom();">
											<f:selectItems value="#{controlTest.epicomplica }" />
										</h:selectOneMenu>
										<h:inputText size="40" value="#{controlTest.epi.complicaotr}" rendered="#{controlTest.complicaepi eq 'OTRAS'}" maxlength="100"/>
									</h:panelGrid>
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="80%">
										<h:selectOneMenu value="#{controlTest.epi.tratam }">
											<f:selectItems value="#{controlTest.epitratam }" />
										</h:selectOneMenu>
									</h:panelGrid>
								</h:panelGrid>
							</rich:tab>
						</rich:tabPanel>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodiosepi" autosized="true" minHeight="350" minWidth="600" zindex="2000">
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
							onclick="javascript: Richfaces.hideModalPanel('episodiosepi');" />
					</h:panelGrid>
				</f:facet>
				<ui:include src="/ventanas/test/episodiosEPI.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
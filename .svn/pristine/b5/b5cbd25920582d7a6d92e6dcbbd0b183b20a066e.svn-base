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
		<h:form id="inicio">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" cellpadding="0"
							cellspacing="0" columnClasses="left,right">
							<h:outputLabel value="#{ms.regev_histo_title }"
								style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" id="panelHistoRegEventos">
						
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlRegistrador.bindingHistorico}"
							id="tablaHistoRegEv" preserveDataModel="true" preserveSort="true"
							sortColumn="#{controlRegistrador.columna }"
							sortAscending="#{controlRegistrador.ascendente }"
							value="#{controlRegistrador.lista}">
							<t:column width="100%" >
								<f:facet name="header">
									<t:commandSortHeader columnName="procedimiento" arrow="true">
										<h:outputText value="#{ms.regev_histo_res_title }" />
									</t:commandSortHeader>
								</f:facet>
								<h:panelGrid width="100%">
									<h:panelGrid columnClasses="alignTop,alignTop" width="100%">
										<h:panelGrid>
											<h:panelGrid  columns="4">
												<a4j:commandLink title="#{ms.regev_histo_res_nserie }: #{linea.reg.nserie }"
													action="irRegistrador" actionListener="#{controlRegistrador.cargaRegistrador}" 
													onclick="javascript:Richfaces.showModalPanel('buscando');" >
													<h:graphicImage url="/img/iconos/ViewResults.png" style="border:0px;" 
														title="#{linea.reg.implanteModelo }" width="22" height="22" />
												</a4j:commandLink>
												<h:selectOneMenu value="#{linea.reg.implanteModelo}" disabled="true" title="#{linea.reg.implanteModelo }"
													readonly="true">
													<f:selectItems value="#{controlRegistrador.regs}" />
												</h:selectOneMenu>
												<a4j:commandLink title="#{ms.regev_histo_res_fechaproc }" 
													action="irRegistrador"
													actionListener="#{controlRegistrador.cargaRegistrador}" 
													onclick="javascript:Richfaces.showModalPanel('buscando');">
													<h:outputLabel value="#{linea.reg.fecha }">
														<f:convertDateTime pattern="dd.MM.yyyy" timeZone="CET"/>
													</h:outputLabel>
												</a4j:commandLink>
												<h:outputText value=" - #{linea.reg.opMed }" title="#{ms.regev_histo_res_operadorproc }"/>
											</h:panelGrid>
											
										</h:panelGrid>
									</h:panelGrid>
									<h:panelGrid width="100%">
										<t:dataTable styleClass="hor-minimalist-b" var="seg"
											width="100%" value="#{linea.segs}" id="tablaSegRegEv"
											binding="#{controlRegistrador.bindingSeguimientos}">
											<t:column width="5%">
											</t:column>
											<t:column width="100%">
												<h:panelGrid columnClasses="alignTop">
													<h:panelGrid>
														<h:panelGrid columns="3">
															<a4j:commandLink title="#{ms.regev_histo_res_segs_title }"
															action="irSeguimientosRegEventos" 
															actionListener="#{controlSeguimientosRegEventos.cargaSegRegEv}"
															onclick="javascript:Richfaces.showModalPanel('buscando');" >
															<h:graphicImage url="/img/iconos/segregev.png" style="border:0px;"
																width="22" height="22"/>
															</a4j:commandLink>													
															<a4j:commandLink title="#{ms.regev_histo_res_segs_fecha }"
																action="irSeguimientosRegEventos"
																actionListener="#{controlSeguimientosRegEventos.cargaSegRegEv}"
																onclick="javascript:Richfaces.showModalPanel('buscando');">
																<h:outputLabel value="#{seg.fecha}">
																	<f:convertDateTime pattern="dd.MM.yyyy" timeZone="CET"/>
																</h:outputLabel>
															</a4j:commandLink>
															<h:outputText value="#{seg.operadorMedico }" title="#{ms.regev_histo_res_operadorproc }"/>	
														</h:panelGrid>															
													</h:panelGrid>
												</h:panelGrid>
											</t:column>
										</t:dataTable>
									</h:panelGrid>
								</h:panelGrid>
							</t:column>
							<f:facet name="footer">
								<rich:datascroller for="tablaHistoRegEv" id="scrollHistoRegistradores"
									renderIfSinglePage="false" fastStep="4" stepControls="auto"
									boundaryControls="auto" fastControls="auto" />
							</f:facet>
						</t:dataTable>
						
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
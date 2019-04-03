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
		<h:form id="iniciohistoimplantes">
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
							<h:outputLabel value="#{ms.imp_dispositivos_histo_title }" style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" id="panelImplantes">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="90%"
							binding="#{controlImplantes.bindingBuscar}"
							sortColumn="#{controlImplantes.columna }"
							sortAscending="#{controlImplantes.ascendente }"
							id="tablaImplante" preserveDataModel="true" preserveSort="true"
							value="#{controlImplantes.procs}">
							<t:column width="75%" id="codigohimplante">
								<f:facet name="header">
									<t:commandSortHeader columnName="procedimiento" arrow="true">
										<h:outputText value="#{ms.imp_dispositivos_histo_proc }" />
									</t:commandSortHeader>
								</f:facet>
								<h:panelGrid width="100%">
									<h:panelGrid columns="2" columnClasses="alignTop,alignTop" width="100%">
										<h:panelGrid>
											<h:panelGrid  columns="3">
												<a4j:commandLink title="#{linea.modelo }"
												action="irImplantes" 
												actionListener="#{controlImplantes.cargaImplante}" 
												onclick="javascript:Richfaces.showModalPanel('buscando');" >
												<h:graphicImage url="/img/iconos/dispositivo.png" style="border:0px;" title="#{linea.modelo }"
													width="22" height="22" rendered="#{linea.tipoimplante eq 956 || linea.tipoimplante eq 1059 ||linea.tipoimplante eq 1060 ||linea.tipoimplante eq 1090}"/>
												<h:graphicImage url="/img/iconos/Skalpell.png" style="border:0px;" title="#{linea.modelo }"
													width="22" height="22" rendered="#{linea.tipoimplante eq 957 || linea.tipoimplante eq 1085 || linea.tipoimplante eq 1086 ||linea.tipoimplante eq 993 ||linea.tipoimplante eq 1147 }"/>
												</a4j:commandLink>
												<h:selectOneMenu value="#{linea.tipoimplante}" disabled="true" title="#{linea.modelo }"
													readonly="true">
													<f:selectItem itemLabel="#{ms.proc_0 }" itemValue="0" />
													<f:selectItem itemLabel="#{ms.proc_956 }" itemValue="956" />
													<f:selectItem itemLabel="#{ms.proc_1059 }" itemValue="1059" />
													<f:selectItem itemLabel="#{ms.proc_1060 }" itemValue="1060" />
													<f:selectItem itemLabel="#{ms.proc_1085 }" itemValue="1085" />
													<f:selectItem itemLabel="#{ms.proc_1086 }" itemValue="1086" />
													<f:selectItem itemLabel="#{ms.proc_957 }" itemValue="957" />
													<f:selectItem itemLabel="#{ms.proc_993 }" itemValue="993" />
													<f:selectItem itemLabel="#{ms.proc_1147 }" itemValue="1147" />
													<f:selectItem itemLabel="#{ms.proc_1090 }" itemValue="1090" />
												</h:selectOneMenu>
												<a4j:commandLink title="#{ms.imp_dispositivos_histo_fecha_proc }" 
													action="irImplantes"
													actionListener="#{controlImplantes.cargaImplante}" 
													onclick="javascript:Richfaces.showModalPanel('buscando');">
													<h:outputLabel value="#{linea.fechaimplante }">
														<f:convertDateTime pattern="dd.MM.yyyy" timeZone="CET"/>
													</h:outputLabel>
												</a4j:commandLink>
											</h:panelGrid>
											<h:panelGrid>
												<h:outputText value="#{linea.operador }" title="#{ms.imp_dispositivos_histo_fecha_op }"/>
											</h:panelGrid>
										</h:panelGrid>																			
										<h:panelGrid>
											<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_histo_proc_com }" opened="true"
												rendered="#{linea.comentarios_sitclin ne null or linea.comentarios_imp ne null or linea.comentarios_ev ne null}">
												<h:panelGrid>
													<h:outputLabel value="#{ms.imp_dispositivos_histo_proc_com_ind }" rendered="#{linea.comentarios_sitclin ne null}"/>
													<h:inputTextarea cols="80" rows="4" value="#{linea.comentarios_sitclin }" disabled="true"
														rendered="#{linea.comentarios_sitclin ne null}">
														<f:validateLength maximum="2000" />
													</h:inputTextarea>
													<h:outputLabel value="#{ms.imp_dispositivos_histo_proc_com_imp }" rendered="#{linea.comentarios_imp ne null}"/>
													<h:inputTextarea cols="80" rows="4" value="#{linea.comentarios_imp }" 
														rendered="#{linea.comentarios_imp ne null}" disabled="true">
														<f:validateLength maximum="2000" />
													</h:inputTextarea>
													<h:outputLabel value="#{ms.imp_dispositivos_histo_proc_com_ev }" rendered="#{linea.comentarios_ev ne null}"/>
													<h:inputTextarea cols="80" rows="4" value="#{linea.comentarios_ev }" 
														rendered="#{linea.comentarios_ev ne null}" disabled="true">
														<f:validateLength maximum="2000" />
													</h:inputTextarea>
												</h:panelGrid>
											</rich:simpleTogglePanel>
										</h:panelGrid>
									</h:panelGrid>
									
									<h:panelGrid columns="2" width="100%">
										<t:dataTable styleClass="hor-minimalist-b" var="seg"
											width="100%" value="#{linea.seguimientos}" id="tablaSegImpl"
											binding="#{controlImplantes.bindingSeguimientos}">
											<t:column width="5%">
											</t:column>
											<t:column width="100%">
												<h:panelGrid columns="2" columnClasses="alignTop,alignTop,alignTop,alignTop">
													<h:panelGrid>
														<h:panelGrid columns="3">
															<a4j:commandLink title="#{ms.imp_dispositivos_histo_seg }"
															action="irSeguimientos" 
															actionListener="#{controlSeguimientos.cargaSeguimiento}"
															onclick="javascript:Richfaces.showModalPanel('buscando');" >
															<h:graphicImage url="/img/iconos/LastThreeMonths.png" style="border:0px;"
																width="22" height="22"/>
															</a4j:commandLink>
															<h:selectOneMenu value="#{seg.implante.tipoprocedimiento}" disabled="true" 
																readonly="true">
																<f:selectItems value="#{controlImplantes.tipoproc }"/>
															</h:selectOneMenu>													
															<a4j:commandLink title="#{ms.imp_dispositivos_histo_seg_fecha }"
																action="irSeguimientos"
																actionListener="#{controlSeguimientos.cargaSeguimiento}"
																onclick="javascript:Richfaces.showModalPanel('buscando');">
																<h:outputLabel value="#{seg.implante.fecha}">
																	<f:convertDateTime pattern="dd.MM.yyyy" timeZone="CET"/>
																</h:outputLabel>
															</a4j:commandLink>
																
														</h:panelGrid>														
														<h:panelGrid>
															<h:outputText value="#{seg.operador }" title="#{ms.imp_dispositivos_histo_fecha_op }"/>
														</h:panelGrid>
													</h:panelGrid>												
													<h:panelGrid>
														<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_histo_proc_com }" opened="true"
															rendered="#{seg.comentarios_seg ne null || seg.comentarios_seg_internos ne null}">
															<h:panelGrid rendered="#{seg.comentarios_seg ne null }">
																<h:outputLabel value="#{ms.imp_dispositivos_histo_seg_com_evol }" />
																<h:inputTextarea cols="80" rows="8" value="#{seg.comentarios_seg }" disabled="true">
																	<f:validateLength maximum="2000" />
																</h:inputTextarea>															
															</h:panelGrid>
															<h:panelGrid rendered="#{seg.comentarios_seg_internos ne null}">
																<h:outputLabel value="#{ms.imp_dispositivos_histo_seg_com_obs }" />
																<h:inputTextarea cols="80" rows="8" value="#{seg.comentarios_seg_internos }" disabled="true">
																	<f:validateLength maximum="2000" />
																</h:inputTextarea>															
															</h:panelGrid>
														</rich:simpleTogglePanel>
													</h:panelGrid>
													
												</h:panelGrid>
												
											</t:column>
										</t:dataTable>
									</h:panelGrid>
								</h:panelGrid>
							</t:column>		
							<f:facet name="footer">
								<rich:datascroller for="tablaImplante" id="scrollDesfibriladores"
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
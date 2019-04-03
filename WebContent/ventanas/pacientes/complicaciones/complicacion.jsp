<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="formComplicaciones">
			<rich:messages errorClass="hvn_msjError" warnClass="hvn_msjAviso" infoClass="hvn_msjInfo" />
			<h:panelGrid width="100%" id="panComplicacionesPaciente">
				<rich:panel style="width:95%;">
					<f:facet name="header">
						<h:panelGrid width="100%" columnClasses="left" cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.compli_panel_title}" style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%">
						<h:outputLabel value="#{ms.compli_nores_title }" style="font-weight: bold;"/>
						<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="tablaComplicacionesNoResPac" width="100%">
							<h:outputLabel value="#{ms.compli_msg_2}" rendered="#{empty controlComplicaciones.listacompacnores }"/>
							<t:dataTable styleClass="hor-minimalist-b" var="comp" rendered="#{not empty controlComplicaciones.listacompacnores }"
								width="100%" value="#{controlComplicaciones.listacompacnores }"
								binding="#{controlComplicaciones.bindingComplicacionesNoRes }" id="dataTableComplicacionesNoResPac" rowIndexVar="rib">
								<t:column width="5%" headerstyleClass="left">
									<h:panelGrid columnClasses="alignTop">								
										<a4j:commandLink reRender="tablaComplicacionesPac,tablaComplicacionesNoResPac,panEditItemComplicacionesPac,editItemComplicacionesPac"
											rendered="#{comp.idrelacion ne 1 }"
											actionListener="#{controlComplicaciones.preEditarNoRes }">		
											<h:graphicImage value="/img/iconos/complicacion.png" width="16"
												height="16" style="border:0;" title="#{ms.compli_title_edit}"/>
										</a4j:commandLink>
										<h:graphicImage value="/img/iconos/complicacion.png" width="16"
											rendered="#{comp.idrelacion eq 1 }"
											height="16" style="border:0;" title="#{ms.compli_title_no_edit}"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.compli_table_title_1 }" />
									</f:facet>
									<h:panelGrid columnClasses="alignTop">								
										<h:selectOneMenu value="#{comp.complicacion }" disabled="true">
											<f:selectItems value="#{controlComplicaciones.complicacionesTodas }" />															
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idarritmias}">
											<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_arritmias_1 }"/>
											<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_arritmias_2 }"/>
											<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_arritmias_3 }"/>
											<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_arritmias_4 }"/>
											<f:selectItem itemValue="5" itemLabel="#{ms.compli_compl_arritmias_5 }"/>
											<f:selectItem itemValue="6" itemLabel="#{ms.compli_compl_arritmias_6 }"/>
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idhematoma}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_hematoma_1 }"/>
											<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_hematoma_2 }"/>
											<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_hematoma_3 }"/>
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idBavEEFDiag}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_bav_1 }"/>
											<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_bav_2 }"/>
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion2 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idBavEEFDiag and comp.complicacion1 eq 2}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_bav_2_1 }"/>
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idEmbEEFDiag}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_emb_1 }"/>
											<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_emb_2 }"/>
											<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_emb_3 }"/>
											<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_emb_4 }"/>
											<f:selectItem itemValue="5" itemLabel="#{ms.compli_compl_emb_5 }"/>
											<f:selectItem itemValue="6" itemLabel="#{ms.compli_compl_emb_6 }"/>
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idDerrPerEEFDiag}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_derr_1 }"/>
											<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_derr_2 }"/>
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion2 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idDerrPerEEFDiag and comp.complicacion1 eq 2}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_derr_2_1 }"/>
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idTEPEEFDiag}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_tep_1 }"/>
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idVascEEFDiag}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_1 }"/>
											<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_vasc_2 }"/>
											<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_vasc_3 }"/>
											<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_vasc_4 }"/>
										</h:selectOneMenu>
										<h:selectOneMenu value="#{comp.complicacion2 }" disabled="true"
											rendered="#{comp.complicacion eq controlComplicaciones.idVascEEFDiag and comp.complicacion1 eq 4}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_4_1 }"/>
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_4_2 }"/>
										</h:selectOneMenu>
										<h:inputText value="#{comp.complicacionOtra }" disabled="true" 
											rendered="#{comp.complicacion eq controlComplicaciones.idcompotra}"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.compli_table_title_2 }" />
									</f:facet>
									<h:panelGrid columnClasses="alignTop">								
										<h:selectOneMenu value="#{comp.tipo }" disabled="true">
											<f:selectItem itemValue="1" itemLabel="#{ms.compli_tipo_1 }"/>
											<f:selectItem itemValue="2" itemLabel="#{ms.compli_tipo_2 }"/>
											<f:selectItem itemValue="3" itemLabel="#{ms.compli_tipo_3 }"/>
										</h:selectOneMenu>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.compli_table_title_3 }" />
									</f:facet>
									<h:panelGrid columnClasses="alignTop">								
										<h:outputLabel value="#{comp.fechaini }" >
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</h:panelGrid>
								</t:column>
								<t:column width="40%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.compli_table_title_6 }" />
									</f:facet>
									<h:panelGrid>
										<h:panelGrid columnClasses="alignMiddle,alignMiddle" columns="2" rendered="#{comp.idprocedimiento ne null }">
											<h:panelGrid>
												<h:graphicImage value="/img/iconos/hearticon.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1061 }"
													title="#{ms.proc_1061 }"/>
												<h:graphicImage value="/img/iconos/ViewResults.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1067 }"
													title="#{ms.proc_1067 }"/>
												<h:graphicImage value="/img/iconos/shock.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1068 }"
													title="#{ms.proc_1068 }"/>
												<h:graphicImage value="/img/iconos/LastThreeMonths.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 983 }"
													title="#{ms.proc_983 }"/>
												<h:graphicImage value="/img/iconos/segregev.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1088 }"
													title="#{ms.proc_1088 }"/>
												<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 957}"
													title="#{ms.proc_957 }"/>
												<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1085}"
													title="#{ms.proc_1085 }"/>
												<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1086}"
													title="#{ms.proc_1086 }"/>
												<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1147}"
													title="#{ms.proc_1147 }"/>
												<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 956}"
													title="#{ms.proc_956 }"/>
												<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1059}"
													title="#{ms.proc_1059 }"/>
												<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1060}"
													title="#{ms.proc_1060 }"/>
												<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1090 }"
													title="#{ms.proc_1090 }"/>
												<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 993}"
													title="#{ms.proc_993 }"/>
												<h:graphicImage value="/img/iconos/BandAid.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1087}"
													title="#{ms.proc_1087 }"/>
												<h:graphicImage value="/img/iconos/segregev.png" style="border: 0px;"
													width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1088}"
													title="#{ms.proc_1088 }"/>
											</h:panelGrid>
											<h:outputLabel value="#{comp.fechaProc }" >
												<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
											</h:outputLabel>
										</h:panelGrid>
										<h:panelGrid rendered="#{comp.idprocedimiento eq null }">
											<h:outputLabel value="#{ms.compli_edit_proc_sel_nodata }"/>
										</h:panelGrid>
									</h:panelGrid>
								</t:column>
							</t:dataTable>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid width="100%">
						<rich:simpleTogglePanel switchType="client" label="#{ms.compli_totales_title }" opened="false">
							<h:panelGrid id="tablaComplicacionesPac" width="100%">
								<h:outputLabel value="#{ms.compli_msg_1 }" rendered="#{empty controlComplicaciones.listacompac }"/>
								<t:dataTable styleClass="hor-minimalist-b" var="comp" rendered="#{not empty controlComplicaciones.listacompac }"
									width="100%" value="#{controlComplicaciones.listacompac }"
									binding="#{controlComplicaciones.bindingComplicaciones }" id="dataTableComplicacionesPac" rowIndexVar="rib">
									<t:column width="5%" headerstyleClass="left">
										<h:panelGrid columnClasses="alignTop">								
											<a4j:commandLink reRender="tablaComplicacionesPac,tablaComplicacionesNoResPac,panEditItemComplicacionesPac,editItemComplicacionesPac"
												actionListener="#{controlComplicaciones.preEditar }" rendered="#{comp.idrelacion ne 1 }">		
												<h:graphicImage value="/img/iconos/complicacion.png" width="16" rendered="#{comp.resuelta ne 1}"
													height="16" style="border:0;" title="#{ms.compli_title_edit}"/>
												<h:graphicImage value="/img/iconos/complicacionRes.png" width="16" rendered="#{comp.resuelta eq 1}"
													height="16" style="border:0;" title="#{ms.compli_title_edit}"/>
											</a4j:commandLink>
											<h:panelGrid rendered="#{comp.idrelacion eq 1 }">
												<h:graphicImage value="/img/iconos/complicacion.png" width="16" rendered="#{comp.resuelta ne 1}"
													height="16" style="border:0;" title="#{ms.compli_title_no_edit}"/>
												<h:graphicImage value="/img/iconos/complicacionRes.png" width="16" rendered="#{comp.resuelta eq 1}"
													height="16" style="border:0;" title="#{ms.compli_title_no_edit}"/>
											</h:panelGrid>
										</h:panelGrid>
									</t:column>
									<t:column width="20%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.compli_table_title_1 }" />
										</f:facet>
										<h:panelGrid columnClasses="alignTop">								
											<h:selectOneMenu value="#{comp.complicacion }" disabled="true">
												<f:selectItems value="#{controlComplicaciones.complicacionesTodas }" />															
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idarritmias}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_arritmias_1 }"/>
												<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_arritmias_2 }"/>
												<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_arritmias_3 }"/>
												<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_arritmias_4 }"/>
												<f:selectItem itemValue="5" itemLabel="#{ms.compli_compl_arritmias_5 }"/>
												<f:selectItem itemValue="6" itemLabel="#{ms.compli_compl_arritmias_6 }"/>
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idhematoma}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_hematoma_1 }"/>
												<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_hematoma_2 }"/>
												<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_hematoma_3 }"/>
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idBavEEFDiag}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_bav_1 }"/>
												<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_bav_2 }"/>
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion2 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idBavEEFDiag and comp.complicacion1 eq 1}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_bav_2_1 }"/>
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idEmbEEFDiag}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_emb_1 }"/>
												<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_emb_2 }"/>
												<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_emb_3 }"/>
												<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_emb_4 }"/>
												<f:selectItem itemValue="5" itemLabel="#{ms.compli_compl_emb_5 }"/>
												<f:selectItem itemValue="6" itemLabel="#{ms.compli_compl_emb_6 }"/>
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idDerrPerEEFDiag}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_derr_1 }"/>
												<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_derr_2 }"/>
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion2 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idDerrPerEEFDiag and comp.complicacion1 eq 2}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_derr_2_1 }"/>
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idTEPEEFDiag}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_tep_1 }"/>
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion1 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idVascEEFDiag}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_1 }"/>
												<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_vasc_2 }"/>
												<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_vasc_3 }"/>
												<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_vasc_4 }"/>
											</h:selectOneMenu>
											<h:selectOneMenu value="#{comp.complicacion2 }" disabled="true"
												rendered="#{comp.complicacion eq controlComplicaciones.idVascEEFDiag and comp.complicacion1 eq 4}">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_4_1 }"/>
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_4_2 }"/>
											</h:selectOneMenu>
											<h:inputText value="#{comp.complicacionOtra }" disabled="true" 
												rendered="#{comp.complicacion eq controlComplicaciones.idcompotra}"/>
										</h:panelGrid>
									</t:column>
									<t:column width="20%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.compli_table_title_2 }" />
										</f:facet>
										<h:panelGrid columnClasses="alignTop">								
											<h:selectOneMenu value="#{comp.tipo }" disabled="true">
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_tipo_1 }"/>
												<f:selectItem itemValue="2" itemLabel="#{ms.compli_tipo_2 }"/>
												<f:selectItem itemValue="3" itemLabel="#{ms.compli_tipo_3 }"/>
											</h:selectOneMenu>
										</h:panelGrid>
									</t:column>
									<t:column width="10%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.compli_table_title_3 }" />
										</f:facet>
										<h:panelGrid columnClasses="alignTop">								
											<h:outputLabel value="#{comp.fechaini }" >
												<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
											</h:outputLabel>
										</h:panelGrid>
									</t:column>
									<t:column width="10%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.compli_table_title_5 }" />
										</f:facet>
										<h:panelGrid columnClasses="alignTop">								
											<h:outputLabel value="#{comp.fechafin }" >
												<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
											</h:outputLabel>
										</h:panelGrid>
									</t:column>
									<t:column width="10%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.compli_table_title_4 }" />
										</f:facet>
										<h:panelGrid columnClasses="alignTop">								
											<h:selectOneMenu value="#{comp.resuelta }" disabled="true">
												<f:selectItem itemValue="0" itemLabel="#{ms.compli_resuelta_0 }"/>
												<f:selectItem itemValue="1" itemLabel="#{ms.compli_resuelta_1 }"/>
												<f:selectItem itemValue="2" itemLabel="#{ms.compli_resuelta_2 }"/>
											</h:selectOneMenu>
										</h:panelGrid>
									</t:column>
									<t:column width="40%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.compli_table_title_6 }" />
										</f:facet>
										<h:panelGrid>
											<h:panelGrid columnClasses="alignMiddle,alignMiddle,alignMiddle" columns="3" rendered="#{comp.idprocedimiento ne null }">
												<h:panelGrid>
													<h:graphicImage value="/img/iconos/hearticon.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1061 }"
														title="#{ms.proc_1061 }"/>
													<h:graphicImage value="/img/iconos/ViewResults.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1067 }"
														title="#{ms.proc_1067 }"/>
													<h:graphicImage value="/img/iconos/shock.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1068 }"
														title="#{ms.proc_1068 }"/>
													<h:graphicImage value="/img/iconos/LastThreeMonths.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 983 }"
														title="#{ms.proc_983 }"/>
													<h:graphicImage value="/img/iconos/segregev.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1088 }"
														title="#{ms.proc_1088 }"/>
													<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 957}"
														title="#{ms.proc_957 }"/>
													<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1085}"
														title="#{ms.proc_1085 }"/>
													<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1086}"
														title="#{ms.proc_1086 }"/>
													<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1147}"
														title="#{ms.proc_1147 }"/>
													<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 956}"
														title="#{ms.proc_956 }"/>
													<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1059}"
														title="#{ms.proc_1059 }"/>
													<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1060}"
														title="#{ms.proc_1060 }"/>
													<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1090 }"
														title="#{ms.proc_1090 }"/>
													<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 993}"
														title="#{ms.proc_993 }"/>
													<h:graphicImage value="/img/iconos/BandAid.png" style="border: 0px;"
														width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1087}"
														title="#{ms.proc_1087 }"/>
												</h:panelGrid>
												<h:outputLabel value="#{comp.fechaProc }" >
													<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
												</h:outputLabel>
												<a4j:commandLink actionListener="#{controlComplicaciones.deselProc }"
													rendered="#{comp.idrelacion ne 1 }"
											     	reRender="tablaComplicacionesPac,dataTableComplicacionesPac,tablaComplicacionesNoResPac,dataTableComplicacionesNoResPac">
													<h:graphicImage value="/img/aplicacion/icoCancelar.png" width="16"
														height="16" style="border:0;" title="#{ms.segclin_proc_asociado_del_sel }"/>				
												</a4j:commandLink>
											</h:panelGrid>
											<h:panelGrid rendered="#{comp.idprocedimiento eq null }">
												<a4j:commandLink reRender="panselproccompac" rendered="#{comp.idrelacion ne 1 }"
													onclick="javascript:Richfaces.showModalPanel('asociarProcCompliPac');"
													actionListener="#{controlComplicaciones.obtenerProcedimientosPaciente }">
													<h:graphicImage url="/img/iconos/add.png" title="#{ms.compli_edit_proc_sel }" 
														width="16" height="16" style="border: 0px;"/>
												</a4j:commandLink>
											</h:panelGrid>
										</h:panelGrid>
									</t:column>
									<t:column headerstyleClass="left">
										<h:panelGrid columns="2">
											<a4j:commandLink reRender="tablaComplicacionesPac,panelContenidoGlobal,tablaComplicacionesNoResPac"
												onclick="if (!confirm('#{ms.compli_msg_warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
												oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
												actionListener="#{controlComplicaciones.delItemComplicacion }">
												<h:graphicImage url="/img/iconos/minus.png" title="#{ms.compli_title_borra }" 
													width="16" height="16" style="border: 0px;"/>
											</a4j:commandLink>
										</h:panelGrid>
									</t:column>
								</t:dataTable>	
							</h:panelGrid>
						</rich:simpleTogglePanel>
					</h:panelGrid>
					<h:panelGrid width="100%">
						<rich:simpleTogglePanel switchType="client" label="#{ms.insertar }" opened="false">
							<h:panelGrid width="100%">
								<h:outputLabel value="#{ms.compli_relacion_proc_title }" style="font-weight: bold;"/>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
									<h:selectOneMenu value="#{controlComplicaciones.compli.idrelacion }">
										<f:selectItems value="#{controlComplicaciones.modulosDisponibles }" />
										<a4j:support event="onchange" reRender="panNuevaComplicacionPac" ajaxSingle="true" />
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid id="panNuevaComplicacionPac" width="100%" columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
								<h:outputLabel value="#{ms.compli_compl }" style="font-weight: bold;"/>
								<h:outputLabel value="#{ms.compli_tipo }" style="font-weight: bold;"/>
								<h:outputLabel value="#{ms.compli_fechaini }" style="font-weight: bold;"/>
								<h:outputLabel value="#{ms.compli_fechafin }" style="font-weight: bold;"/>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panNuevaComPacCompli">
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion }" rendered="false">
										<f:selectItems value="#{controlComplicaciones.complicacionesTodas }" />
										<a4j:support event="onchange" reRender="panNuevaComPacCompli" ajaxSingle="true" />
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion }" rendered="#{controlComplicaciones.compli.idrelacion eq 0}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion }" rendered="#{controlComplicaciones.compli.idrelacion eq 1}">
										<f:selectItems value="#{controlComplicaciones.complicacionesEefAbl }" />
										<a4j:support event="onchange" reRender="panNuevaComPacCompli" ajaxSingle="true" />
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion }" rendered="#{controlComplicaciones.compli.idrelacion eq 7}">
										<f:selectItems value="#{controlComplicaciones.complicacionesEefDiag }" />
										<a4j:support event="onchange" reRender="panNuevaComPacCompli" ajaxSingle="true" />
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion }" rendered="#{controlComplicaciones.compli.idrelacion eq 2 or controlComplicaciones.compli.idrelacion eq 3 or controlComplicaciones.compli.idrelacion eq 4 or controlComplicaciones.compli.idrelacion eq 5}">
										<f:selectItems value="#{controlComplicaciones.complicacionesImpl }" />
										<a4j:support event="onchange" reRender="panNuevaComPacCompli" ajaxSingle="true" />
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion }" rendered="#{controlComplicaciones.compli.idrelacion eq 6}">
										<f:selectItems value="#{controlComplicaciones.complicacionesCve }" />
										<a4j:support event="onchange" reRender="panNuevaComPacCompli" ajaxSingle="true" />
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion1 }" 
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idarritmias or controlComplicaciones.compli.complicacion eq controlComplicaciones.idarritmiasCVE}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_arritmias_1 }"/>
										<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_arritmias_2 }"/>
										<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_arritmias_3 }"/>
										<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_arritmias_4 }"/>
										<f:selectItem itemValue="5" itemLabel="#{ms.compli_compl_arritmias_5 }"/>
										<f:selectItem itemValue="6" itemLabel="#{ms.compli_compl_arritmias_6 }"/>
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion1 }" 
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idhematoma or controlComplicaciones.compli.complicacion eq controlComplicaciones.idhematomaCVE}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_hematoma_1 }"/>
										<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_hematoma_2 }"/>
										<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_hematoma_3 }"/>
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion1 }"
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idBavEEFDiag}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_bav_1 }"/>
										<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_bav_2 }"/>
										<a4j:support event="onchange" reRender="panNuevaComPacCompli" ajaxSingle="true" />
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion2 }"
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idBavEEFDiag and controlComplicaciones.compli.complicacion1 eq 2}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_bav_2_1 }"/>
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion1 }"
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idEmbEEFDiag}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_emb_1 }"/>
										<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_emb_2 }"/>
										<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_emb_3 }"/>
										<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_emb_4 }"/>
										<f:selectItem itemValue="5" itemLabel="#{ms.compli_compl_emb_5 }"/>
										<f:selectItem itemValue="6" itemLabel="#{ms.compli_compl_emb_6 }"/>
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion1 }"
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idDerrPerEEFDiag}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_derr_1 }"/>
										<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_derr_2 }"/>
										<a4j:support event="onchange" reRender="panNuevaComPacCompli" ajaxSingle="true" />
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion2 }"
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idDerrPerEEFDiag and controlComplicaciones.compli.complicacion1 eq 2}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_derr_2_1 }"/>
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion1 }"
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idTEPEEFDiag}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_tep_1 }"/>
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion1 }"
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idVascEEFDiag}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_1 }"/>
										<f:selectItem itemValue="2" itemLabel="#{ms.compli_compl_vasc_2 }"/>
										<f:selectItem itemValue="3" itemLabel="#{ms.compli_compl_vasc_3 }"/>
										<f:selectItem itemValue="4" itemLabel="#{ms.compli_compl_vasc_4 }"/>
										<a4j:support event="onchange" reRender="panNuevaComPacCompli" ajaxSingle="true" />
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlComplicaciones.compli.complicacion2 }"
										rendered="#{controlComplicaciones.compli.complicacion eq controlComplicaciones.idVascEEFDiag and controlComplicaciones.compli.complicacion1 eq 4}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_4_1 }"/>
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_compl_vasc_4_2 }"/>
									</h:selectOneMenu>
									<h:inputText value="#{controlComplicaciones.compli.complicacionOtra }" 
										rendered="#{controlComplicaciones.compli.complicacion eq  controlComplicaciones.idcompotra}"/>
								</h:panelGrid>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
									<h:selectOneMenu value="#{controlComplicaciones.compli.tipo }">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_tipo_1 }"/>
										<f:selectItem itemValue="2" itemLabel="#{ms.compli_tipo_2 }"/>
										<f:selectItem itemValue="3" itemLabel="#{ms.compli_tipo_3 }"/>
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
									<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
										showWeeksBar="false" direction="bottom-left" 
										value="#{controlComplicaciones.compli.fechaini }" />
								</h:panelGrid>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
									<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
										showWeeksBar="false" direction="bottom-left" 
										value="#{controlComplicaciones.compli.fechafin }" />
								</h:panelGrid>
								<h:outputLabel value="#{ms.compli_resuelta }" style="font-weight: bold;"/>
								<h:outputLabel value="#{ms.compli_tratamiento }" style="font-weight: bold;"/>
								<h:outputLabel value="#{ms.compli_ingreso }" style="font-weight: bold;"/>
								<h:outputLabel value="#{ms.compli_descripcion }" style="font-weight: bold;"/>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
									<h:selectOneMenu value="#{controlComplicaciones.compli.resuelta }">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="0" itemLabel="#{ms.compli_resuelta_0 }"/>
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_resuelta_1 }"/>
										<f:selectItem itemValue="2" itemLabel="#{ms.compli_resuelta_2 }"/>
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panNuevaComPacTrat">								
									<h:selectOneMenu value="#{controlComplicaciones.compli.tratamiento }">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="0" itemLabel="#{ms.compli_tratamiento_0 }"/>
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_tratamiento_1 }"/>
										<a4j:support event="onchange" reRender="panNuevaComPacTrat" ajaxSingle="true" />
									</h:selectOneMenu>
									<h:inputText value="#{controlComplicaciones.compli.tratamientoDescr }" 
										rendered="#{controlComplicaciones.compli.tratamiento eq 1}"/>
								</h:panelGrid>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
									<h:selectOneMenu value="#{controlComplicaciones.compli.ingreso }">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
										<f:selectItem itemValue="0" itemLabel="#{ms.compli_ingreso_0 }"/>
										<f:selectItem itemValue="1" itemLabel="#{ms.compli_ingreso_1 }"/>
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
									<h:inputTextarea cols="40" rows="4" value="#{controlComplicaciones.compli.descripcion }" id="descNuevaComPac">
										<f:validateLength maximum="1000" />
									</h:inputTextarea>	
									<h:message for="descNuevaComPac" style="color:red" />
								</h:panelGrid>
							</h:panelGrid>
							<hr/>
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
								<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
									<a4j:commandLink actionListener="#{controlComplicaciones.addItemComplicacion }"
										reRender="tablaComplicacionesPac,panNuevaComplicacionPac,cabecerapaciente,tablaComplicacionesNoResPac,panelContenidoGlobal"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
										<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
											width="24" height="24" title="#{ms.guardar }"/>
									</a4j:commandLink>
								</h:panelGrid>
								<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
									<a4j:commandLink actionListener="#{controlComplicaciones.limpiar }"
										reRender="tablaComplicacionesPac,panNuevaComplicacionPac"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
										<h:graphicImage value="/img/iconos/limpia.png"
											style="border:0;cursor:pointer;" 
											width="24" height="24" title="#{ms.limpiar }" />
									</a4j:commandLink>
								</h:panelGrid>
							</h:panelGrid>
						</rich:simpleTogglePanel>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
			
			<rich:modalPanel id="editItemComplicacionesPac" autosized="true" zindex="500" minWidth="550" showWhenRendered="#{controlComplicaciones.editable}">
				<f:facet name="header">
					<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.compli_edit_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid columns="3">
						<a4j:commandLink actionListener="#{controlComplicaciones.editItemComplicacion }"
							reRender="tablaComplicacionesPac,dataTableComplicacionesPac,cabecerapaciente,tablaComplicacionesNoResPac,dataTableComplicacionesNoResPac,panelContenidoGlobal"
							onclick="javascript:Richfaces.hideModalPanel('editItemComplicacionesPac');">
							<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
								width="16px" height="16px" title="#{ms.guardar }"/>
						</a4j:commandLink>
						<a4j:commandLink actionListener="#{controlComplicaciones.cancelarItemComplicacion }"
							reRender="tablaComplicacionesPac,panEditItemComplicacionesPac,dataTableComplicacionesPac,tablaComplicacionesNoResPac,dataTableComplicacionesNoResPac"
							onclick="javascript:Richfaces.hideModalPanel('editItemComplicacionesPac');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
							style="border:0;cursor:pointer;"
							onclick="javascript:Richfaces.hideModalPanel('editItemComplicacionesPac')"
							title="#{ms.cerrar }" />
						</a4j:commandLink>				
					</h:panelGrid>
				</f:facet>
				<h:panelGrid id="paneditcompac" width="100%">
					<ui:include src="/ventanas/pacientes/complicaciones/editcomplicacion.jsp" />
				</h:panelGrid>
			</rich:modalPanel>
			
			<rich:modalPanel id="asociarProcCompliPac" autosized="true" zindex="500" minWidth="550" showWhenRendered="#{controlComplicaciones.selProc}">
				<f:facet name="header">
					<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.compli_edit_proc_title }" styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid columns="2">
						<a4j:commandLink onclick="javascript:Richfaces.hideModalPanel('asociarProcCompliPac');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
							style="border:0;cursor:pointer;"
							onclick="javascript:Richfaces.hideModalPanel('editItemComplicacionesPac')"
							title="#{ms.cerrar }" />
						</a4j:commandLink>				
					</h:panelGrid>
				</f:facet>
				<h:panelGrid id="panselproccompac" width="100%">
					<h:outputLabel value="#{ms.compli_edit_proc_title_info }" />
					<h:panelGrid>
				    	<rich:dataGrid value="#{controlComplicaciones.listaprocsdisp}" var="proc" columns="2" elements="2" id="dataTableSelProcsComp"
							binding="#{controlComplicaciones.bindingPrevios }" columnClasses="alignTop,alignTop,alignTop,alignTop">
							<rich:panel bodyClass="pbody">
								<f:facet name="header">
									<h:outputLabel value="#{proc.fecha}">
								    	<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
									</h:outputLabel>
								</f:facet>
								<h:panelGrid columns="3">
									<h:graphicImage value="/img/iconos/hearticon.png" style="border: 0px;" title="#{ms.proc_1061 }"
										width="22" height="22" rendered="#{proc.tipoprocedimiento eq 1061 }"/>
									<h:graphicImage value="/img/iconos/ViewResults.png" style="border: 0px;" title="#{ms.proc_1067 }"
										width="22" height="22" rendered="#{proc.tipoprocedimiento eq 1067 }"/>
									<h:graphicImage value="/img/iconos/shock.png" style="border: 0px;" title="#{ms.proc_1068 }"
										width="22" height="22" rendered="#{proc.tipoprocedimiento eq 1068 }"/>
									<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
										width="22" height="22" rendered="#{comp.tipoprocedimiento eq 957}"
										title="#{ms.proc_957 }"/>
									<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
										width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1085}"
										title="#{ms.proc_1085 }"/>
									<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
										width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1086}"
										title="#{ms.proc_1086 }"/>
									<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
										width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1147}"
										title="#{ms.proc_1147 }"/>
									<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
										width="22" height="22" rendered="#{comp.tipoprocedimiento eq 956}"
										title="#{ms.proc_956 }"/>
									<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
										width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1059}"
										title="#{ms.proc_1059 }"/>
									<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
										width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1060}"
										title="#{ms.proc_1060 }"/>
									<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
										width="22" height="22" rendered="#{comp.tipoprocedimiento eq 1090 }"
										title="#{ms.proc_1090 }"/>
									<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
										width="22" height="22" rendered="#{comp.tipoprocedimiento eq 993}"
										title="#{ms.proc_993 }"/>
									<h:graphicImage value="/img/iconos/LastThreeMonths.png" style="border: 0px;" title="#{ms.proc_983 }"
										width="22" height="22" rendered="#{proc.tipoprocedimiento eq 983 }"/>
									<h:graphicImage value="/img/iconos/BandAid.png" style="border: 0px;" title="#{ms.proc_1087 }"
										width="22" height="22" rendered="#{proc.tipoprocedimiento eq 1087 }"/>
									<h:graphicImage value="/img/iconos/segregev.png" style="border: 0px;" title="#{ms.proc_1088 }"
										width="22" height="22" rendered="#{proc.tipoprocedimiento eq 1088 }"/>
									<h:selectOneMenu value="#{proc.tipoprocedimiento }" disabled="true">
								   		<f:selectItem itemLabel="#{ms.proc_1061 }" itemValue="1061"/>
								   		<f:selectItem itemLabel="#{ms.proc_1068 }" itemValue="1068"/>
								        <f:selectItem itemLabel="#{ms.proc_1067 }" itemValue="1067"/>
										<f:selectItem itemLabel="#{ms.proc_983 }" itemValue="983"/>
								 		<f:selectItem itemLabel="#{ms.proc_956 }" itemValue="956"/>
										<f:selectItem itemLabel="#{ms.proc_1059 }" itemValue="1059"/>
								  		<f:selectItem itemLabel="#{ms.proc_1060 }" itemValue="1060"/>
								   		<f:selectItem itemLabel="#{ms.proc_1085 }" itemValue="1085"/>
								    	<f:selectItem itemLabel="#{ms.proc_1086 }" itemValue="1086"/>
								  		<f:selectItem itemLabel="#{ms.proc_957 }" itemValue="957"/>
								  		<f:selectItem itemLabel="#{ms.proc_1087 }" itemValue="1087"/>
								  		<f:selectItem itemLabel="#{ms.proc_1088 }" itemValue="1088"/>
								   	</h:selectOneMenu>
								     <a4j:commandLink actionListener="#{controlComplicaciones.selProc }" 
								     	reRender="tablaComplicacionesPac,dataTableComplicacionesPac,tablaComplicacionesNoResPac,dataTableComplicacionesNoResPac"
								       	onclick="javascript:Richfaces.hideModalPanel('asociarProcCompliPac');">
										<h:graphicImage value="/img/iconos/add.png" width="16"
											height="16" style="border:0;" title="#{ms.segclin_proc_asociado_add_sel }"/>				
									</a4j:commandLink>
								</h:panelGrid>
							</rich:panel>
							<f:facet name="footer">
								<rich:datascroller for="dataTableSelProcsComp"></rich:datascroller>
							</f:facet>
						</rich:dataGrid>
			    	</h:panelGrid>
				</h:panelGrid>
			</rich:modalPanel>
			
		</h:form>
	</ui:define>
	
	
	
	
</ui:composition>
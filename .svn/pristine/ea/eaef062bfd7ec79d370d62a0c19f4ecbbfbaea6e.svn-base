<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">	
	<ui:define name="contenido">
		<h:form id="inicioSeguimientosClinicos">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
						 style="margin-top: 15px;" id="panSeguimientoClinicos">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
                     <f:facet name="header">
                     	<h:panelGrid columns="7" width="65%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicosegclin">
							<h:outputLabel value="#{ms.segclin_title }" style="color: white;" />
							<h:panelGrid columns="2" columnClasses="right">
								<h:outputLabel value="Fecha" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlSeguimientosClinicos.seg.fecha}" >
								</rich:calendar>														
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.segclin_prog }" style="color: white;font-weight: bold;"/>
								<h:panelGrid>
									<h:selectOneMenu value="#{controlSeguimientosClinicos.seg.programado}">
									    <f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
										<f:selectItem itemValue="1" itemLabel="#{ms.segclin_prog_op1 }" />
										<f:selectItem itemValue="0" itemLabel="#{ms.segclin_prog_op0 }" />		
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
	                 		<a4j:commandLink style="text-align: right;" reRender="panSeguimientoClinicos,tablaPacientesBdu,panicosegclin,panNuevaComplicacionPacSegClin" 
	                 			onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('episodios');" 
	                 			actionListener="#{controlSeguimientosClinicos.preguarda }" rendered="#{controlSeguimientosClinicos.proc.idepisodio eq null }">
								<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;" title="#{ms.guardar }"/>
							</a4j:commandLink>                 		
							<a4j:commandLink style="text-align: right;" reRender="panSeguimientoClinicos,panicosegclin,panNuevaComplicacionPacSegClin"
								onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								actionListener="#{controlSeguimientosClinicos.guarda }" rendered="#{controlSeguimientosClinicos.proc.idepisodio ne null and controlSeguimientosClinicos.editable }">
								<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;" title="#{ms.guardar }" />
							</a4j:commandLink>
							<a4j:commandLink style="text-align: right;" reRender="panSeguimientoClinicos"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlSeguimientosClinicos.eliminar }" action="menuprincipal"
									rendered="#{controlSeguimientosClinicos.seg.idsegclin ne null and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
							</a4j:commandLink>
							<h:commandLink actionListener="#{controlSeguimientosClinicos.imprimeInforme}"
								rendered="#{controlSeguimientosClinicos.seg.idsegclin ne null }" target="_blank">
								<h:graphicImage value="/img/iconos/informe_especial.png"
									width="22" height="22" style="border:none;" title="#{ms.imprimir_informe }" />
							</h:commandLink>														
						</h:panelGrid>
                     </f:facet>
                     <h:panelGrid>
                     	<h:panelGrid id="panSelProcSegClin">
                     		<h:panelGrid columns="3" rendered="#{controlSeguimientosClinicos.seg.procasoc ne null }">
                     			<h:outputLabel value="#{ms.segclin_proc_asociado }: " style="font-weight: bold;color:#E17009;"/>
                     			<h:panelGrid columns="3">
                     				<h:outputLabel value="#{controlSeguimientosClinicos.seg.procasoc.fecha}">
						            	<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
						            </h:outputLabel>
						            <h:graphicImage value="/img/iconos/hearticon.png" style="border: 0px;" title="#{ms.proc_1061 }"
										width="22" height="22" rendered="#{controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1061 }"/>
									<h:graphicImage value="/img/iconos/ViewResults.png" style="border: 0px;" title="#{ms.proc_1067 }"
										width="22" height="22" rendered="#{controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1067 }"/>
									<h:graphicImage value="/img/iconos/shock.png" style="border: 0px;" title="#{ms.proc_1068 }"
										width="22" height="22" rendered="#{controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1068 }"/>
									<h:graphicImage value="/img/iconos/mesabasc.png" style="border: 0px;" title="#{ms.proc_1066 }"
										width="22" height="22" rendered="#{controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1066 }"/>
									<h:graphicImage value="/img/iconos/Pills.png" style="border: 0px;" title="#{ms.proc_label_test_gen }"
										width="22" height="22" rendered="#{controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1063 or controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1064 or controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1065}"/>
									<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;" title="#{ms.proc_label_imp_gen }"
										width="22" height="22" rendered="#{controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 956 or controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1059 or controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1060 }"/>
									<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;" title="#{ms.proc_label_reint_rec_gen }"
										width="22" height="22" rendered="#{controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 957 or controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1085 or controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1086 or controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1147}"/>
									<h:graphicImage value="/img/iconos/holter.png" style="border: 0px;" title="#{ms.proc_1089 }"
										width="22" height="22" rendered="#{controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento eq 1089 }"/>
						            <h:selectOneMenu value="#{controlSeguimientosClinicos.seg.procasoc.tipoprocedimiento }" disabled="true">
						            	<f:selectItem itemLabel="#{ms.proc_1061 }" itemValue="1061"/>
						                <f:selectItem itemLabel="#{ms.proc_1068 }" itemValue="1068"/>
						                <f:selectItem itemLabel="#{ms.proc_1067 }" itemValue="1067"/>
						                <f:selectItem itemLabel="#{ms.proc_1089 }" itemValue="1089"/>
						                <f:selectItem itemLabel="#{ms.proc_956 }" itemValue="956"/>
						                <f:selectItem itemLabel="#{ms.proc_1059 }" itemValue="1059"/>
						                <f:selectItem itemLabel="#{ms.proc_1060 }" itemValue="1060"/>
						                <f:selectItem itemLabel="#{ms.proc_1085 }" itemValue="1085"/>
						                <f:selectItem itemLabel="#{ms.proc_1086 }" itemValue="1086"/>
						                <f:selectItem itemLabel="#{ms.proc_1066 }" itemValue="1066"/>
						                <f:selectItem itemLabel="#{ms.proc_1063 }" itemValue="1063"/>
						                <f:selectItem itemLabel="#{ms.proc_1064 }" itemValue="1064"/>
						                <f:selectItem itemLabel="#{ms.proc_1065 }" itemValue="1065"/>
						                <f:selectItem itemLabel="#{ms.proc_957 }" itemValue="957"/>
						           </h:selectOneMenu> 
						        </h:panelGrid>
						        <a4j:commandLink reRender="panSelProcSegClin" actionListener="#{controlSeguimientosClinicos.deselProc }">
									<h:graphicImage style="border: 0px;" value="/img/aplicacion/icoCancelar.png"
										width="16" height="16" title="#{ms.segclin_proc_asociado_del_sel }"/>				
								</a4j:commandLink>
                     		</h:panelGrid>
                     		<h:panelGrid>
		                     	<rich:simpleTogglePanel switchType="client" label="#{ms.segclin_proc_asociado_empar }" opened="false"
		                     		rendered="#{controlSeguimientosClinicos.seg.procasoc eq null }">
		                     		<h:outputLabel value="#{ms.segclin_proc_asociado_msg_1 }" 
		                     			style="font-weight: bold;color:#E17009;"/>
			                     	<h:panelGrid>
				                     	<rich:dataGrid value="#{controlSeguimientosClinicos.proclstprevl}" var="proc" columns="4" elements="4"
									    	binding="#{controlSeguimientosClinicos.bindingPrevios }" columnClasses="alignTop,alignTop,alignTop,alignTop">
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
													<h:graphicImage value="/img/iconos/mesabasc.png" style="border: 0px;" title="#{ms.proc_1066 }"
														width="22" height="22" rendered="#{proc.tipoprocedimiento eq 1066 }"/>
													<h:graphicImage value="/img/iconos/Pills.png" style="border: 0px;" title="#{ms.proc_label_test_gen }"
														width="22" height="22" rendered="#{proc.tipoprocedimiento eq 1063 or proc.tipoprocedimiento eq 1064 or proc.tipoprocedimiento eq 1065}"/>
													<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;" title="#{ms.proc_label_imp_gen }"
														width="22" height="22" rendered="#{proc.tipoprocedimiento eq 956 or proc.tipoprocedimiento eq 1059 or proc.tipoprocedimiento eq 1060 }"/>
													<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;" title="#{ms.proc_label_reint_rec_gen }"
														width="22" height="22" rendered="#{proc.tipoprocedimiento eq 957 or proc.tipoprocedimiento eq 1085 or proc.tipoprocedimiento eq 1086 or proc.tipoprocedimiento eq 1147}"/>
													<h:graphicImage value="/img/iconos/holter.png" style="border: 0px;" title="#{ms.proc_1089 }"
														width="22" height="22" rendered="#{proc.tipoprocedimiento eq 1089 }"/>
								                    <h:selectOneMenu value="#{proc.tipoprocedimiento }" disabled="true">
								                    	<f:selectItem itemLabel="#{ms.proc_1061 }" itemValue="1061"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1068 }" itemValue="1068"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1067 }" itemValue="1067"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1089 }" itemValue="1089"/>
								                    	<f:selectItem itemLabel="#{ms.proc_956 }" itemValue="956"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1059 }" itemValue="1059"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1060 }" itemValue="1060"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1085 }" itemValue="1085"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1086 }" itemValue="1086"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1066 }" itemValue="1066"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1063 }" itemValue="1063"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1064 }" itemValue="1064"/>
								                    	<f:selectItem itemLabel="#{ms.proc_1065 }" itemValue="1065"/>
								                    	<f:selectItem itemLabel="#{ms.proc_957 }" itemValue="957"/>
								                    </h:selectOneMenu>
								                    <a4j:commandLink reRender="panSelProcSegClin" actionListener="#{controlSeguimientosClinicos.selProc }">
														<h:graphicImage value="/img/iconos/add.png" width="16"
															height="16" style="border:0;" title="#{ms.segclin_proc_asociado_add_sel }"/>				
													</a4j:commandLink>
								                </h:panelGrid>
								            </rich:panel>
								            <f:facet name="footer">
								                <rich:datascroller></rich:datascroller>
								            </f:facet>
									    </rich:dataGrid>
			                     	</h:panelGrid>
		                     	</rich:simpleTogglePanel>
	                     	</h:panelGrid>
                     	</h:panelGrid>
                     	
                     	 <h:panelGrid columns="2" rendered="false">
							<h:panelGrid>
								<h:outputText value="Carácter procedencia" style="font-weight: bold;"/>
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:selectOneMenu value="#{controlPacientes.filtro.procedencia }">
										<f:selectItems value="#{controlPacientes.caracter }"/>				
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid>
								<h:outputText value="Hospital de Procedencia" style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:selectOneMenu value="#{controlPacientes.filtro.hprocedencia }">
										<f:selectItems value="#{controlPacientes.hospital }"/>				
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
						</h:panelGrid>
                     	 <rich:tabPanel switchType="client" selectedTab="nameHojaRevisionSegClin">
                     	 	<rich:tab label="#{ms.segclin_tab1_sitclin_title }">
								<a4j:include viewId="paneles/indicacion.jsp"/>
							</rich:tab>
							<rich:tab label="#{ms.segclin_tab2_datos_title }" name="nameHojaRevisionSegClin">
								<a4j:include viewId="paneles/hoja_seguimiento.jsp" />
							</rich:tab>
                     	 </rich:tabPanel>
                	</h:panelGrid>	
                </rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodios" autosized="true" minHeight="350" minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.segclin_modal_epi_title }"
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
				<ui:include src="/ventanas/seguimientos_clinicos/episodios.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
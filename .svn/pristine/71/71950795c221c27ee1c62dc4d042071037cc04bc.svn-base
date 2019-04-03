<?xml version="1.0" encoding="UTF-8" ?>
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
		<h:form id="formUsuarios">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="100%"
				style="margin-top: 15px;" id="panelCitas">

				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel>
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.citas_title }" style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" columns="2" id="panCitas" columnClasses="alignTop,alignTop">
						<h:panelGrid width="100%">
							<rich:simpleTogglePanel switchType="client" label="#{ms.citas_lt_title } (#{controlCitas.fecha_actual })" opened="true">
								<h:panelGrid width="100%">
									<h:outputLabel value="#{ms.citas_lt_msg_1 } #{controlCitas.fecha_actual }" rendered="#{empty controlCitas.agenda.diarios}"/>
									<t:dataTable styleClass="hor-minimalist-b" var="cita" rows="10"
										sortColumn="#{controlCitas.columna }" rendered="#{not empty controlCitas.agenda.diarios}"
										sortAscending="#{controlCitas.ascendente }"
										width="100%" value="#{controlCitas.agenda.diarios}"
										binding="#{controlCitas.bindingEventosDiarios }"
										id="listacitas">
										<t:column width="5%" headerstyleClass="left">
											<f:facet name="header">
												<h:outputText value="" />
											</f:facet>
											<h:panelGrid>
												<h:graphicImage url="/img/aplicacion/icoCancelar.png"
													title="#{ms.citas_estado_title_0 }" width="16" height="16"
													style="border: 0px;" 
													rendered="#{cita.estado eq 0 }"/>
												<h:graphicImage url="/img/iconos/citas.png"
													title="#{ms.citas_estado_title_1 }" width="16" height="16"
													style="border: 0px;" 
													rendered="#{cita.estado eq 1 }"/>
												<h:graphicImage url="/img/aplicacion/accept.png"
													title="#{ms.citas_estado_title_2 }" width="16" height="16"
													style="border: 0px;" 
													rendered="#{cita.estado eq 2 }"/>
												<h:graphicImage url="/img/iconos/alerta.png"
													title="#{ms.citas_estado_title_3 }" width="16" height="16"
													style="border: 0px;" 
													rendered="#{cita.estado eq 3 }"/>
												<h:graphicImage url="/img/iconos/alerta.png"
													title="#{ms.citas_estado_title_5 }" width="16" height="16"
													style="border: 0px;" 
													rendered="#{cita.estado eq 5 }"/>												
											</h:panelGrid>
										</t:column>
										<t:column width="15%" headerstyleClass="left">
											<f:facet name="header">
												<h:outputText value="#{ms.citas_lt_msg_2 }" />
											</f:facet>
											<h:panelGrid>								
												<h:outputLabel value="#{cita.idpaciente }" />
											</h:panelGrid>
										</t:column>
										<t:column width="15%" headerstyleClass="left">
											<f:facet name="header">
												<h:outputText value="#{ms.citas_lt_msg_3 }" />
											</f:facet>
											<h:panelGrid>								
												<h:outputLabel value="#{cita.nombre }" />
											</h:panelGrid>
										</t:column>
										<t:column width="25%" headerstyleClass="left">
											<f:facet name="header">
												<h:outputText value="#{ms.citas_lt_msg_4 }" />
											</f:facet>
											<h:panelGrid>								
												<h:outputLabel value="#{cita.apellido1 } #{cita.apellido2 }" />
											</h:panelGrid>
										</t:column>
										<t:column width="50%" headerstyleClass="left">
											<f:facet name="header">
												<h:outputText value="#{ms.citas_lt_msg_5 }" />
											</f:facet>
											<h:panelGrid>								
												<h:selectOneMenu value="#{cita.procedimiento}" disabled="true">
													<f:selectItem itemLabel="#{ms.proc_0 }" itemValue="0"/>
													<f:selectItem itemLabel="#{ms.proc_1061 }" itemValue="1061"/>
													<f:selectItem itemLabel="#{ms.proc_956 }" itemValue="956"/>
													<f:selectItem itemLabel="#{ms.proc_1059 }" itemValue="1059"/>
													<f:selectItem itemLabel="#{ms.proc_1060 }" itemValue="1060"/>
													<f:selectItem itemLabel="#{ms.proc_1085 }" itemValue="1085"/>
													<f:selectItem itemLabel="#{ms.proc_1086 }" itemValue="1086"/>
													<f:selectItem itemLabel="#{ms.proc_1147 }" itemValue="1147"/>
													<f:selectItem itemLabel="#{ms.proc_1090 }" itemValue="1090"/>
													<f:selectItem itemLabel="#{ms.proc_983 }" itemValue="983"/>
													<f:selectItem itemLabel="#{ms.proc_1068 }" itemValue="1068"/>
													<f:selectItem itemLabel="#{ms.proc_1063 }" itemValue="1063"/>
													<f:selectItem itemLabel="#{ms.proc_1064 }" itemValue="1064"/>
													<f:selectItem itemLabel="#{ms.proc_1065 }" itemValue="1065"/>
													<f:selectItem itemLabel="#{ms.proc_1066 }" itemValue="1066"/>
													<f:selectItem itemLabel="#{ms.proc_1067 }" itemValue="1067"/>
													<f:selectItem itemLabel="#{ms.proc_1089 }" itemValue="1089"/>
													<f:selectItem itemLabel="#{ms.proc_1091}" itemValue="1091"/>
													<f:selectItem itemLabel="#{ms.proc_1087}" itemValue="1087"/>
													<f:selectItem itemLabel="#{ms.proc_1 }" itemValue="1"/>
												</h:selectOneMenu>
											</h:panelGrid>
										</t:column>
										<t:column width="80%" headerstyleClass="left">
											<f:facet name="header">												
												<t:commandSortHeader columnName="fechaevento" arrow="true">
													<h:outputText value="#{ms.citas_lt_msg_6 }" id="cabFechaevento" />
												</t:commandSortHeader>
											</f:facet>
											<h:panelGrid>								
												<h:outputLabel value="#{cita.fechaini }">
													<f:convertDateTime type="date" pattern="HH:mm:ss" timeZone="Europe/Madrid"/>
												</h:outputLabel>
											</h:panelGrid>
										</t:column>
									</t:dataTable>
								</h:panelGrid>
							</rich:simpleTogglePanel>
							<rich:spacer height="5px"/>
							<rich:simpleTogglePanel switchType="client" label="#{ms.citas_pat_title }" opened="false">
								<h:panelGrid id="seleccionEventoPaciente" columns="3">
									<h:outputLabel rendered="#{controlCitas.evento.idpaciente ne null}"
										value="#{ms.citas_pat_msg_1 }: "/>
									<h:outputLabel rendered="#{controlCitas.evento.idpaciente ne null}" style="font-weight: bold;color:#E17009"
										value="#{controlCitas.evento.idpaciente } - #{controlCitas.evento.nombre } #{controlCitas.evento.apellido1 } #{controlCitas.evento.apellido2 }"/>
									<h:outputLabel rendered="#{controlCitas.evento.idpaciente eq null}"
										value="#{ms.citas_pat_msg_2 }"/>
									<h:panelGrid>											
										<a4j:commandLink actionListener="#{controlCitas.limpiar}" title="#{ms.limpiar }"
											onclick="javascript:Richfaces.showModalPanel('buscando');"
											oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
											reRender="panelConsultaPacientesCitas,filtrosConsultaPacienteCitas,seleccionEventoPaciente">
											<h:graphicImage style="align:right;border:none;"
												styleClass="hvn_enlImagen" id="icoLimpiar" title="Limpia selección, filtros y resultados"
												width="24" height="24" url="/img/iconos/limpia.png"/>							
										</a4j:commandLink>	
									</h:panelGrid>
								</h:panelGrid>
								<rich:spacer height="5px"/>
								<t:fieldset legend ="#{ms.citas_pat_msg_3 }">
									<h:panelGrid columns="5" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop" id="filtrosConsultaPacienteCitas">
										<h:panelGrid>
											<h:outputLabel value="#{ms.citas_pat_msg_4 }" style="font-weight: bold;" />
											<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
												<h:inputText value="#{controlCitas.filtro.nhc }"/>															
											</h:panelGrid>	
										</h:panelGrid>					
										<h:panelGrid>
											<h:outputLabel value="#{ms.citas_pat_msg_5 }" style="font-weight: bold;" />
											<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
												<h:inputText value="#{controlCitas.filtro.nuhsa }"/>																
											</h:panelGrid>	
										</h:panelGrid>
										<h:panelGrid>
											<h:outputLabel value="#{ms.citas_pat_msg_6 }" style="font-weight: bold;" />
											<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
												<h:inputText value="#{controlCitas.filtro.nombre }"/>																
											</h:panelGrid>	
										</h:panelGrid>
										<h:panelGrid>
											<h:outputLabel value="#{ms.citas_pat_msg_7 }" style="font-weight: bold;" />
											<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
												<h:inputText value="#{controlCitas.filtro.apellid1}"/>																
											</h:panelGrid>	
										</h:panelGrid>
										<h:panelGrid>
											<h:outputLabel value="" style="font-weight: bold;" />
											<h:panelGrid columns="2">
												<a4j:commandLink actionListener="#{controlCitas.buscarPacientes}" 
													onclick="javascript:Richfaces.showModalPanel('buscando');" 
													oncomplete="javascript:Richfaces.hideModalPanel('buscando');" 
													reRender="panelConsultaPacientesCitas">
													<h:graphicImage value="/img/iconos/bd.jpg" style="border:0;"/>							
												</a4j:commandLink>																
											</h:panelGrid>	
										</h:panelGrid>
									</h:panelGrid>
								</t:fieldset>
								<h:panelGrid id="panelConsultaPacientesCitas" width="100%">								
									<t:dataTable width="100%" rows="5" rendered="#{not empty controlCitas.listapats }"
										value="#{controlCitas.listapats}" var="pat"
										id="listapacientescitas" styleClass="hor-minimalist-b"
										style="width:100%;background-color: #ffffff;background-repeat: no-repeat;background-position:right bottom;"														 		
										binding="#{controlCitas.bindingPacientes}">
										<t:column width="5%" style="text-align: left;" 
											styleClass="hor-minimalist-b-row" >
											<f:facet name="header">
												<h:outputText value="" title=""/>
											</f:facet>
											<h:panelGrid style="text-align:left;" width="100%">
												<h:graphicImage value="/img/iconos/masculino.png"
													styleClass="hvn_enlImagen" style="border:none;"
													title="#{ms.hombre }" rendered="#{pat.sexo eq 1}" />
												<h:graphicImage value="/img/iconos/femenino.png"
													styleClass="hvn_enlImagen" style="border:none;" title="#{ms.mujer }"
													rendered="#{pat.sexo eq 2}" />
											</h:panelGrid>
										</t:column>
										<t:column width="15%" style="text-align: left;" title="#{ms.citas_pat_msg_4 }"
											styleClass="hor-minimalist-b-row">
											<f:facet name="header">
												<h:outputText value="#{ms.citas_pat_msg_4 }" />
											</f:facet>
											<h:panelGrid style="text-align:left;" width="100%" >
												<h:outputLabel value="#{pat.nhc}" />
											</h:panelGrid>
										</t:column>
										<t:column width="15%" style="text-align: left;" title="#{ms.citas_pat_msg_5 }"
											styleClass="hor-minimalist-b-row">
											<f:facet name="header">
												<h:outputText value="#{ms.citas_pat_msg_5 }" />
											</f:facet>
											<h:panelGrid style="text-align:left;" width="100%" >
												<h:outputLabel value="#{pat.nuhsa}" />
											</h:panelGrid>
										</t:column>
										<t:column width="20%" style="text-align: left;" title="#{ms.citas_pat_msg_6 }"
											styleClass="hor-minimalist-b-row" >
											<f:facet name="header">
												<h:outputText value="#{ms.citas_pat_msg_6 }" title="#{ms.citas_pat_msg_6 }"/>
											</f:facet>
											<h:panelGrid style="text-align:left;" width="100%">
												<h:outputLabel value="#{pat.nombre }"/>
											</h:panelGrid>
										</t:column>		
										<t:column width="20%" style="text-align: left;" title="#{ms.citas_pat_msg_7 }"
											styleClass="hor-minimalist-b-row" >
											<f:facet name="header">
												<h:outputText value="#{ms.citas_pat_msg_7 }" title="#{ms.citas_pat_msg_7 }"/>
											</f:facet>
											<h:panelGrid style="text-align:left;" width="100%">
												<h:outputLabel value="#{pat.apellid1 }" />
											</h:panelGrid>
										</t:column>
										<t:column width="20%" style="text-align: left;" title="#{ms.citas_pat_msg_8 }"
											styleClass="hor-minimalist-b-row" >
											<f:facet name="header">
												<h:outputText value="#{ms.citas_pat_msg_8 }" title="#{ms.citas_pat_msg_8 }"/>
											</f:facet>
											<h:panelGrid style="text-align:left;" width="100%">
												<h:outputLabel value="#{pat.apellid2 }" />
											</h:panelGrid>
										</t:column>							
										<t:column width="5%" style="text-align: left;" styleClass="hor-minimalist-b-row">
											<f:facet name="header"> 
												<h:outputText value="" />
											</f:facet>
											<h:panelGrid style="text-align:left;" width="100%">
												<h:selectBooleanCheckbox value="#{pat.seleccion }" >
													<a4j:support event="onclick" reRender="nuevoEventoInfoDemografica,seleccionEventoPaciente,listapacientescitas" 
														ajaxSingle="true" actionListener="#{controlCitas.seleccionaPaciente }"/>
												</h:selectBooleanCheckbox>																				
											</h:panelGrid>
										</t:column>
										<f:facet name="footer">
											<rich:datascroller align="center" for="listapacientescitas" 
												renderIfSinglePage="true" fastStep="3"
												page="#{controlCitas.pagina_inicial_pat}">
												<f:facet name="first">
													<h:graphicImage url="/img/genericos/navegacion/first.png" />
												</f:facet>
												<f:facet name="last">
													<h:graphicImage url="/img/genericos/navegacion/last.png" />
												</f:facet>
												<f:facet name="fastrewind">
													<h:graphicImage url="/img/genericos/navegacion/frwd.png" />
												</f:facet>
												<f:facet name="fastforward">
													<h:graphicImage url="/img/genericos/navegacion/ffwd.png" />
												</f:facet>
												<f:facet name="previous">
													<h:graphicImage url="/img/genericos/navegacion/rwd.png" />
												</f:facet>
												<f:facet name="next">
													<h:graphicImage url="/img/genericos/navegacion/fwd.png" />
												</f:facet>
												<f:facet name="first_disabled">
													<h:graphicImage url="/img/genericos/navegacion/first.png" />
												</f:facet>
												<f:facet name="last_disabled">
													<h:graphicImage url="/img/genericos/navegacion/last.png" />
												</f:facet>
												<f:facet name="fastrewind_disabled">
													<h:graphicImage url="/img/genericos/navegacion/frwd.png" />
												</f:facet>
												<f:facet name="fastforward_disabled">
													<h:graphicImage url="/img/genericos/navegacion/ffwd.png" />
												</f:facet>
												<f:facet name="previous_disabled">
													<h:graphicImage url="/img/genericos/navegacion/rwd.png" />
												</f:facet>
												<f:facet name="next_disabled">
													<h:graphicImage url="/img/genericos/navegacion/fwd.png" />
												</f:facet>
											</rich:datascroller>
										</f:facet>
									</t:dataTable>
								</h:panelGrid>							
							</rich:simpleTogglePanel>
							<rich:spacer height="5px"/>
							<rich:simpleTogglePanel switchType="client" label="Agenda" opened="true">
								<h:panelGrid columns="2" columnClasses="alignTop,alignTop" width="100%">
									<h:panelGrid  columnClasses="alignTop" width="100%">
										<rich:spacer height="15px"/>
										
											<rich:toolBar styleClass="scheduler">
												<rich:toolBarGroup>                       										            
										            <h:outputLabel value="#{controlCitas.agenda.nombre }" 
										            	title="#{controlCitas.agenda.descripcion }"/>
									            </rich:toolBarGroup>
												<rich:toolBarGroup location="right" rendered="false">                       
										            <a4j:commandLink reRender="panCitas" title="Editar agenda"
														onclick="javascript:Richfaces.showModalPanel('gestionAgenda');">
														<h:graphicImage value="/img/iconos/calendar_edit.png" width="28"
															height="28" style="border:0;" title="Editar agenda"/>				
													</a4j:commandLink>										
									            </rich:toolBarGroup>
									            
									            <rich:toolBarGroup location="right">                       
										            <a4j:commandLink reRender="panCitas" actionListener="#{controlCitas.irHoy }"
										            	onclick="javascript:Richfaces.showModalPanel('buscando');"
														oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
										              	id="irHoyToolbar2" title="#{ms.citas_agenda_irhoy }">
														<h:graphicImage value="/img/iconos/calendar.png" width="28"
															height="28" style="border:0;" title="#{ms.citas_agenda_irhoy }"/>				
													</a4j:commandLink>
									            </rich:toolBarGroup>
									            <rich:toolBarGroup location="right">   
									            	<a4j:commandLink
														style="align:right;" reRender="panelCitas"
														onclick="javascript:Richfaces.showModalPanel('listainformeseventos');">
														<h:graphicImage style="align:right;border:none;"
															styleClass="hvn_enlImagen" title="#{ms.citas_agenda_partes }"
															width="24" height="24" url="/img/iconos/informe_especial.png"/>
													</a4j:commandLink>                    								            
									            </rich:toolBarGroup>
									            <rich:toolBarGroup location="right">
									            	<h:panelGrid columns="2">
										            	<h:selectBooleanCheckbox value="#{controlCitas.agenda.gestionhuecos}" title="#{ms.citas_agenda_huecos_msg_1 }">
										            		<a4j:support event="onchange" reRender="panCitas" ajaxSingle="true"/>
										            	</h:selectBooleanCheckbox>
										            	<h:outputLabel value="#{ms.citas_agenda_huecos_msg_2 }" style="font-weight: bold;color: white;" />
									            	</h:panelGrid>	            									            	                    								            
									            </rich:toolBarGroup>			            
									        </rich:toolBar>
									        
									        <h:panelGrid columns="2" columnClasses="alignTop,alignTop" width="100%">
									        	<h:panelGrid width="100%" columnClasses="alignTop">
									        		<t:schedule value="#{controlCitas.agenda.model }" id="citas"
														binding="#{controlCitas.agenda.schedule}"
														readonly="false"
														theme="evolution"
														tooltip="true"
														compactWeekRowHeight="400"
														compactMonthRowHeight="100"
														submitOnClick="true"
														expandToFitEntries="true"
														detailedRowHeight="50"
														headerDateFormat="EEE dd MMM yyyy"	
														rendered="true"					
														mouseListener="#{controlCitas.scheduleClicked}"
														entryRenderer="#{colorEvento}"/>
									        	</h:panelGrid>
									        	<h:panelGrid width="100%">					        		 
									        		 <rich:dataGrid value="#{controlCitas.agendausers}" rendered="#{controlCitas.tamlist &gt; 0}" var="ag" columns="3">
											            <t:schedule value="#{ag.model }" id="restocal"
															binding="#{controlCitas.schedule2}"
															readonly="true"
															theme="evolution"
															tooltip="true"
															compactWeekRowHeight="400"
															compactMonthRowHeight="100"
															submitOnClick="true"
															expandToFitEntries="true"
															detailedRowHeight="25"
															headerDateFormat="EEE dd MMM yyyy"	
															rendered="#{ag.comparar eq true }"
															mouseListener="#{controlCitas.scheduleClicked}"/>
														<h:outputLabel value="#{ag.user.usuario }" style="font-weight: bold;align: center;"
															rendered="#{ag.comparar eq true }"/>
											        </rich:dataGrid>					
									        	</h:panelGrid>	
									        	<h:panelGrid>
										        	<rich:simpleTogglePanel switchType="client" label="#{ms.citas_agenda_msg_1 }" opened="false">
										        		<h:panelGrid columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
										        			<h:panelGrid columnClasses="alignTop">
																<h:outputLabel value="#{ms.citas_agenda_msg_2 }" style="font-weight: bold;" />
																<h:panelGrid style="border-top: solid 1px;border-color: black;">
																	<h:inputText value="#{controlCitas.agenda.nombre }" title="#{ms.citas_agenda_msg_2 }" size="45"/>
																</h:panelGrid>
															</h:panelGrid>
															<h:panelGrid columnClasses="alignTop">
																<h:outputLabel value="#{ms.citas_agenda_msg_3 }" style="font-weight: bold;" />
																<h:panelGrid style="border-top: solid 1px;border-color: black;">
																	<h:selectOneMenu value="#{controlCitas.agenda.tipoagenda}">
																        <f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
																        <f:selectItem itemLabel="#{ms.citas_agenda_msg_4 }" itemValue="0" />
																        <f:selectItem itemLabel="#{ms.citas_agenda_msg_5 }" itemValue="1" />					        
																    </h:selectOneMenu>
																</h:panelGrid>
															</h:panelGrid>
															<h:panelGrid>
																<h:outputLabel value="#{ms.citas_agenda_msg_6 }" style="font-weight: bold;" />
																<h:panelGrid style="border-top: solid 1px;border-color: black;">
																	<h:inputTextarea value="#{controlCitas.agenda.descripcion }" id="descripcionAgendaEdit" 
																		title="#{ms.citas_agenda_msg_6 }" cols="43"> 
																		<f:validateLength maximum="200" />
																	</h:inputTextarea>	
																	<h:message for="descripcionAgendaEdit" style="color:red" />
																</h:panelGrid>
															</h:panelGrid>
															<h:panelGrid columnClasses="alignTop" width="100%">
																<h:outputLabel value="#{ms.citas_agenda_msg_7 }" style="font-weight: bold;" />
																<h:panelGrid style="border-top: solid 1px;border-color: black;">
																	<h:selectOneRadio value="#{controlCitas.agenda.visibilidad}">
																	    <f:selectItem itemLabel="#{ms.citas_agenda_msg_8 }" itemValue="0" />
																	    <f:selectItem itemLabel="#{ms.citas_agenda_msg_9 }" itemValue="1" />					        
																	</h:selectOneRadio>
																</h:panelGrid>
															</h:panelGrid>
										        		</h:panelGrid>
										        		<h:panelGrid columns="2">
										        			<a4j:commandLink actionListener="#{controlCitas.editarAgenda }" 
										        				reRender="panCitas,citas,nuevoevento,listacitas"
										        				onclick ="javascript:Richfaces.showModalPanel('buscando');"
										        				oncomplete ="javascript:Richfaces.hideModalPanel('buscando');">
																<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png" 
																	width="16px" height="16px" title="#{ms.editar }"/>
															</a4j:commandLink>
															<h:outputLabel value="#{ms.editar }" style="font-weight: bold;" />
										        		</h:panelGrid>
										        	</rich:simpleTogglePanel>
										        </h:panelGrid>				        	
									        </h:panelGrid>											
									</h:panelGrid>								
								</h:panelGrid>
							</rich:simpleTogglePanel>
						</h:panelGrid>
						<h:panelGrid>
							<h:panelGrid width="50%">
									<rich:panel>
								        <f:facet name="header">
								        	Calendario
								        </f:facet>
								        <h:panelGrid columnClasses="center">
								        	<t:inputCalendar id="scheduleNavigator" title="#{ms.citas_agenda_cal_msg_1 }"								      
												value="#{controlCitas.agenda.model.selectedDate}" currentDayCellClass="currentDayCell"
												valueChangeListener="#{controlCitas.cambiaFecha }">
												<a4j:support event="onchange" reRender="panCitas,citas,horasSemana" ajaxSingle="false"
													actionListener="#{controlCitas.cambiaFecha }"/>
											</t:inputCalendar>									
								        </h:panelGrid>
								        			        
								    </rich:panel>
								    <rich:simpleTogglePanel switchType="client" label="#{ms.citas_agenda_disp_msg_1 }" opened="true">
								    	<h:panelGrid>
								    		 <t:dataList var="ag" value="#{controlCitas.agendas_disp}" 
								    		 	binding="#{controlCitas.bindingAgendas }" rows="10">
								    		 	<h:panelGrid columns="3">
								    		 		<a4j:commandLink reRender="panCitas"
														actionListener="#{controlCitas.seleccionaAgenda }"
														onclick="javascript:Richfaces.showModalPanel('buscando');"
														oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
														<h:graphicImage value="/img/iconos/calendar_com.png" width="28"
															rendered="#{ag.tipoagenda eq 0 }"
															height="28" style="border:0;" title="#{ms.citas_agenda_disp_msg_2 }"/>
														<h:graphicImage value="/img/iconos/calendar_pers.png" width="28"
															rendered="#{ag.tipoagenda eq 1 }"
															height="28" style="border:0;" title="#{ms.citas_agenda_disp_msg_3 } #{ag.idusuario }"/>																		
													</a4j:commandLink>
													<h:outputLabel value="#{ag.nombre }" style="font-weight: bold;"/>						
								    		 	</h:panelGrid>								    		 													
								    		 </t:dataList>
								    		 <h:panelGrid columnClasses="center"  columns="2">
												<a4j:commandLink reRender="panCitas"
													onclick="javascript:Richfaces.showModalPanel('nuevaAgenda');"
													oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
													<h:graphicImage value="/img/iconos/calendar_add.png" width="28"
														height="28" style="border:0;" title="#{ms.aniadir }"/>																
												</a4j:commandLink>
												<h:outputLabel value="#{ms.aniadir }" style="font-weight: bold;"/>												
											</h:panelGrid>								    	
								    	</h:panelGrid>
								    	
								    </rich:simpleTogglePanel>
									<rich:simpleTogglePanel switchType="client" label="#{ms.citas_agenda_disp_msg_4 }" opened="false">
										<h:outputLabel value="Presentación" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:selectOneRadio style="font-size: 14px;font-weight: bold;" 
												value="#{controlCitas.agenda.model.mode }" layout="lineDirection">
												<f:selectItem itemLabel="#{ms.citas_agenda_disp_msg_5 }" itemValue="0"/>
												<f:selectItem itemLabel="#{ms.citas_agenda_disp_msg_6 }" itemValue="1"/>
												<f:selectItem itemLabel="#{ms.citas_agenda_disp_msg_7 }" itemValue="3"/>
												<a4j:support event="onchange" reRender="panCitas,citas,horasSemana" ajaxSingle="true"
													actionListener="#{controlCitas.cambiaFormatoPresentacion }"/>
											</h:selectOneRadio>
										</h:panelGrid>										
										<h:outputLabel value="#{ms.citas_agenda_disp_msg_1 }" style="font-weight: bold;" rendered="false"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2" rendered="false">
											<rich:dataList var="ev" value="#{controlCitas.agendausers}" rows="10">
										            <h:selectBooleanCheckbox value="#{ev.comparar }">
										   				<a4j:support event="onclick" reRender="panCitas" ajaxSingle="true" actionListener="#{controlCitas.addCalendario }"/>
										  			</h:selectBooleanCheckbox>
										            <h:graphicImage url="/img/iconos/users.png" style="border:0px;" width="20" height="20" />							            
										            <h:outputText value="#{ev.user.usuario}"/>
										    </rich:dataList>
											
											<h:selectBooleanCheckbox value="#{controlCitas.otrocal }" rendered="false">
								   				<a4j:support event="onclick" reRender="panCitas" ajaxSingle="true" actionListener="#{controlCitas.addCalendario }"/>
								  			</h:selectBooleanCheckbox>
								  			<h:outputLabel value="Dr. Perez Narvaez" rendered="false"/>
										</h:panelGrid>
										<h:panelGrid id="horasSemana">																
											<h:outputLabel value="#{ms.citas_agenda_hora_ini }" style="font-weight: bold;" rendered="#{controlCitas.agenda.model.mode ne 3}"/>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlCitas.agenda.model.mode ne 3}">
												<rich:inputNumberSlider minValue="0" value="#{controlCitas.agenda.schedule.visibleStartHour }" maxValue="24">
													<a4j:support event="onchange" reRender="panCitas,citas" ajaxSingle="true"
														actionListener="#{controlCitas.cambiaFormatoPresentacion }"/>
												</rich:inputNumberSlider>
											</h:panelGrid>
											<h:outputLabel value="#{ms.citas_agenda_hora_ini_trab }" style="font-weight: bold;" rendered="#{controlCitas.agenda.model.mode ne 3}"/>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlCitas.agenda.model.mode ne 3}">
												<rich:inputNumberSlider minValue="0" value="#{controlCitas.agenda.schedule.workingStartHour }" maxValue="24">
													<a4j:support event="onchange" reRender="panCitas,citas" ajaxSingle="true"
														actionListener="#{controlCitas.cambiaFormatoPresentacion }"/>
												</rich:inputNumberSlider>
											</h:panelGrid>
											<h:outputLabel value="#{ms.citas_agenda_hora_fin }" style="font-weight: bold;" rendered="#{controlCitas.agenda.model.mode ne 3}"/>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlCitas.agenda.model.mode ne 3}">
												<rich:inputNumberSlider minValue="0" value="#{controlCitas.agenda.schedule.visibleEndHour }" maxValue="24">
													<a4j:support event="onchange" reRender="panCitas,citas" ajaxSingle="true"
														actionListener="#{controlCitas.cambiaFormatoPresentacion }"/>
												</rich:inputNumberSlider>
											</h:panelGrid>
											<h:outputLabel value="#{ms.citas_agenda_hora_fin_trab }" style="font-weight: bold;" rendered="#{controlCitas.agenda.model.mode ne 3}"/>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlCitas.agenda.model.mode ne 3}">
												<rich:inputNumberSlider minValue="0" value="#{controlCitas.agenda.schedule.workingEndHour }" maxValue="24">
													<a4j:support event="onchange" reRender="panCitas,citas" ajaxSingle="true"
														actionListener="#{controlCitas.cambiaFormatoPresentacion }"/>
												</rich:inputNumberSlider>
											</h:panelGrid>
											<h:panelGrid columns="2">
												<a4j:commandLink reRender="panCitas" rendered="#{controlCitas.agenda.model.mode ne 3}"
													actionListener="#{controlCitas.actualizaValoresProperties }"
													onclick="javascript:Richfaces.showModalPanel('buscando');" 
													oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
													<h:graphicImage value="/img/iconos/guarda.png" width="24" height="24" 
														style="border:0;" title="#{ms.guardar }"/>																
												</a4j:commandLink>
												<h:outputLabel value="#{ms.guardar }" style="font-weight: bold;" rendered="#{controlCitas.agenda.model.mode ne 3}"/>
											</h:panelGrid>
										</h:panelGrid>
									</rich:simpleTogglePanel>
									<rich:simpleTogglePanel switchType="client" label="#{ms.citas_agenda_huecos_msg_2 }" opened="false" rendered="#{controlCitas.agenda.gestionhuecos eq true }">
										<h:outputLabel value="#{ms.citas_agenda_huecos_msg_3 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="3">
											<rich:inputNumberSpinner minValue="10" maxValue="60" step="10" value="#{controlCitas.TAM_HUECO}"/>
											<h:outputLabel value="minutos"/>
											<a4j:commandLink reRender="panCitas" 
												actionListener="#{controlCitas.adaptaHuecosAgenda }"
												onclick="javascript:Richfaces.showModalPanel('buscando');" 
												oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
												<h:graphicImage value="/img/iconos/guarda.png" width="24" height="24" 
													style="border:0;" title="#{ms.citas_agenda_huecos_msg_1 }"/>																
											</a4j:commandLink>
										</h:panelGrid>
										<h:outputLabel value="#{ms.citas_agenda_huecos_msg_4 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_EEF}"
												rendered="#{controlPacientes.booleanEEF == true}"/>
											<h:outputLabel value="#{ms.proc_label_eef } (#{controlCitas.HUECO_EEF * controlCitas.TAM_HUECO} min)" rendered="#{controlPacientes.booleanEEF == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_CV}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true}"/>
											<h:outputLabel value="#{ms.proc_label_cv } (#{controlCitas.HUECO_CV * controlCitas.TAM_HUECO} min)" rendered="#{controlPacientes.booleanCardioversiónElectrica == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_MESA}"
												rendered="#{controlPacientes.booleanMesa == true}"/>
											<h:outputLabel value="#{ms.proc_label_mesa } (#{controlCitas.HUECO_MESA * controlCitas.TAM_HUECO} min)" rendered="#{controlPacientes.booleanMesa == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_REG}"
												rendered="#{controlPacientes.booleanRegistradorEventos == true or  controlPacientes.booleanRegistradorEventosExterno == true}"/>
											<h:outputLabel value="#{ms.proc_label_regev } (#{controlCitas.HUECO_REG * controlCitas.TAM_HUECO} min)" rendered="#{controlPacientes.booleanRegistradorEventos == true or controlPacientes.booleanRegistradorEventosExterno == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_REGEVEXT}"
												rendered="#{controlPacientes.booleanRegistradorEventos == true or controlPacientes.booleanRegistradorEventosExterno == true}"/>
											<h:outputLabel value="#{ms.proc_label_elr } (#{controlCitas.HUECO_REGEVEXT * controlCitas.TAM_HUECO} min)" rendered="#{controlPacientes.booleanRegistradorEventos == true or controlPacientes.booleanRegistradorEventosExterno == true}"/>	
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_HOLTER_24H}"
												rendered="#{controlPacientes.booleanHolter  == true }"/>
											<h:outputLabel value="#{ms.proc_label_holter } (#{controlCitas.HUECO_HOLTER_24H * controlCitas.TAM_HUECO} min)" rendered="#{controlPacientes.booleanHolter == true }"/>											
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_ATP}"
												rendered="#{controlPacientes.booleanTestOrto == true }"/>
											<h:outputLabel value="#{ms.proc_label_atp } (#{controlCitas.HUECO_ATP * controlCitas.TAM_HUECO} min)" rendered="#{controlPacientes.booleanTestOrto == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_EPI}"
												rendered="#{controlPacientes.booleanTestOrto == true}"/>
											<h:outputLabel value="#{ms.proc_label_epi } (#{controlCitas.HUECO_EPI * controlCitas.TAM_HUECO} min)" rendered="#{controlPacientes.booleanTestOrto == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_FLE}"
												rendered="#{controlPacientes.booleanTestOrto == true}"/>
											<h:outputLabel value="#{ms.proc_label_fle } (#{controlCitas.HUECO_FLE * controlCitas.TAM_HUECO} min)" rendered="#{controlPacientes.booleanTestOrto == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_IMP_MPS}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_imp_mps } (#{controlCitas.HUECO_IMP_MPS * controlCitas.TAM_HUECO} min)" 
														   rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
															             controlPacientes.booleanPrimoImplante == true or 
															             controlPacientes.booleanReintervencion == true or 
															             controlPacientes.booleanRecambioDispositivo == true or 
															             controlPacientes.booleanUpgradeDispositivo == true or 
															             controlPacientes.booleanRecolocacionGenerador == true or 
															             controlPacientes.booleanRecolocacionElectrodo == true or 
															             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_IMP_DAI}"
																	rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
																             controlPacientes.booleanPrimoImplante == true or 
																             controlPacientes.booleanReintervencion == true or 
																             controlPacientes.booleanRecambioDispositivo == true or 
																             controlPacientes.booleanUpgradeDispositivo == true or 
																             controlPacientes.booleanRecolocacionGenerador == true or 
																             controlPacientes.booleanRecolocacionElectrodo == true or 
																             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_imp_dai } (#{controlCitas.HUECO_IMP_DAI * controlCitas.TAM_HUECO} min)" 
															rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
															             controlPacientes.booleanPrimoImplante == true or 
															             controlPacientes.booleanReintervencion == true or 
															             controlPacientes.booleanRecambioDispositivo == true or 
															             controlPacientes.booleanUpgradeDispositivo == true or 
															             controlPacientes.booleanRecolocacionGenerador == true or 
															             controlPacientes.booleanRecolocacionElectrodo == true or 
															             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_IMP_CRTP}"
																	rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
																	             controlPacientes.booleanPrimoImplante == true or 
																	             controlPacientes.booleanReintervencion == true or 
																	             controlPacientes.booleanRecambioDispositivo == true or 
																	             controlPacientes.booleanUpgradeDispositivo == true or 
																	             controlPacientes.booleanRecolocacionGenerador == true or 
																	             controlPacientes.booleanRecolocacionElectrodo == true or 
																	             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_imp_crtp } (#{controlCitas.HUECO_IMP_CRTP * controlCitas.TAM_HUECO} min)" 
														rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
														             controlPacientes.booleanPrimoImplante == true or 
														             controlPacientes.booleanReintervencion == true or 
														             controlPacientes.booleanRecambioDispositivo == true or 
														             controlPacientes.booleanUpgradeDispositivo == true or 
														             controlPacientes.booleanRecolocacionGenerador == true or 
														             controlPacientes.booleanRecolocacionElectrodo == true or 
														             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_IMP_CRTD}"
																	rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
																	             controlPacientes.booleanPrimoImplante == true or 
																	             controlPacientes.booleanReintervencion == true or 
																	             controlPacientes.booleanRecambioDispositivo == true or 
																	             controlPacientes.booleanUpgradeDispositivo == true or 
																	             controlPacientes.booleanRecolocacionGenerador == true or 
																	             controlPacientes.booleanRecolocacionElectrodo == true or 
																	             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_imp_crtd } (#{controlCitas.HUECO_IMP_CRTD * controlCitas.TAM_HUECO} min)" 
														rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
														             controlPacientes.booleanPrimoImplante == true or 
														             controlPacientes.booleanReintervencion == true or 
														             controlPacientes.booleanRecambioDispositivo == true or 
														             controlPacientes.booleanUpgradeDispositivo == true or 
														             controlPacientes.booleanRecolocacionGenerador == true or 
														             controlPacientes.booleanRecolocacionElectrodo == true or 
														             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_SEG_MPS}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_seg_mps } (#{controlCitas.HUECO_SEG_MPS * controlCitas.TAM_HUECO} min)" 
											            rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
														             controlPacientes.booleanPrimoImplante == true or 
														             controlPacientes.booleanReintervencion == true or 
														             controlPacientes.booleanRecambioDispositivo == true or 
														             controlPacientes.booleanUpgradeDispositivo == true or 
														             controlPacientes.booleanRecolocacionGenerador == true or 
														             controlPacientes.booleanRecolocacionElectrodo == true or 
				             										 controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_SEG_DAI}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_seg_dai } (#{controlCitas.HUECO_SEG_DAI * controlCitas.TAM_HUECO} min)" 
											            rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
														             controlPacientes.booleanPrimoImplante == true or 
														             controlPacientes.booleanReintervencion == true or 
														             controlPacientes.booleanRecambioDispositivo == true or 
														             controlPacientes.booleanUpgradeDispositivo == true or 
														             controlPacientes.booleanRecolocacionGenerador == true or 
														             controlPacientes.booleanRecolocacionElectrodo == true or 
														             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_SEG_CRTP}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_seg_crtp } (#{controlCitas.HUECO_SEG_CRTP * controlCitas.TAM_HUECO} min)" 
														rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
													             controlPacientes.booleanPrimoImplante == true or 
													             controlPacientes.booleanReintervencion == true or 
													             controlPacientes.booleanRecambioDispositivo == true or 
													             controlPacientes.booleanUpgradeDispositivo == true or 
													             controlPacientes.booleanRecolocacionGenerador == true or 
													             controlPacientes.booleanRecolocacionElectrodo == true or 
													             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_SEG_CRTD}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_seg_crtd } (#{controlCitas.HUECO_SEG_CRTD * controlCitas.TAM_HUECO} min)" 
														rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
														             controlPacientes.booleanPrimoImplante == true or 
														             controlPacientes.booleanReintervencion == true or 
														             controlPacientes.booleanRecambioDispositivo == true or 
														             controlPacientes.booleanUpgradeDispositivo == true or 
														             controlPacientes.booleanRecolocacionGenerador == true or 
														             controlPacientes.booleanRecolocacionElectrodo == true or 
														             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_EXPLANTE}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_exp } (#{controlCitas.HUECO_EXPLANTE * controlCitas.TAM_HUECO} min)" 
														rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
														             controlPacientes.booleanPrimoImplante == true or 
														             controlPacientes.booleanReintervencion == true or 
														             controlPacientes.booleanRecambioDispositivo == true or 
														             controlPacientes.booleanUpgradeDispositivo == true or 
														             controlPacientes.booleanRecolocacionGenerador == true or 
														             controlPacientes.booleanRecolocacionElectrodo == true or 
														             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_REINTERVENCION}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_reint } (#{controlCitas.HUECO_REINTERVENCION * controlCitas.TAM_HUECO} min)" 
														rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
														             controlPacientes.booleanPrimoImplante == true or 
														             controlPacientes.booleanReintervencion == true or 
														             controlPacientes.booleanRecambioDispositivo == true or 
														             controlPacientes.booleanUpgradeDispositivo == true or 
														             controlPacientes.booleanRecolocacionGenerador == true or 
														             controlPacientes.booleanRecolocacionElectrodo == true or 
														             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_REC_GEN}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_rec_gen } (#{controlCitas.HUECO_REC_GEN * controlCitas.TAM_HUECO} min)" 
											rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
											             controlPacientes.booleanPrimoImplante == true or 
											             controlPacientes.booleanReintervencion == true or 
											             controlPacientes.booleanRecambioDispositivo == true or 
											             controlPacientes.booleanUpgradeDispositivo == true or 
											             controlPacientes.booleanRecolocacionGenerador == true or 
											             controlPacientes.booleanRecolocacionElectrodo == true or 
											             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_REC_ELE}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_rec_ele } (#{controlCitas.HUECO_REC_ELE * controlCitas.TAM_HUECO} min)" 
											rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
											             controlPacientes.booleanPrimoImplante == true or 
											             controlPacientes.booleanReintervencion == true or 
											             controlPacientes.booleanRecambioDispositivo == true or 
											             controlPacientes.booleanUpgradeDispositivo == true or 
											             controlPacientes.booleanRecolocacionGenerador == true or 
											             controlPacientes.booleanRecolocacionElectrodo == true or 
											             controlPacientes.booleanReimplante == true}"/>
											<rich:inputNumberSpinner minValue="1" maxValue="10" step="1" value="#{controlCitas.HUECO_SEG_CLIN}"
												rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
												             controlPacientes.booleanPrimoImplante == true or 
												             controlPacientes.booleanReintervencion == true or 
												             controlPacientes.booleanRecambioDispositivo == true or 
												             controlPacientes.booleanUpgradeDispositivo == true or 
												             controlPacientes.booleanRecolocacionGenerador == true or 
												             controlPacientes.booleanRecolocacionElectrodo == true or 
												             controlPacientes.booleanReimplante == true}"/>
											<h:outputLabel value="#{ms.proc_label_seg_clin } (#{controlCitas.HUECO_SEG_CLIN * controlCitas.TAM_HUECO} min)" 
											rendered="#{controlPacientes.booleanCardioversiónElectrica == true or 
											             controlPacientes.booleanPrimoImplante == true or 
											             controlPacientes.booleanReintervencion == true or 
											             controlPacientes.booleanRecambioDispositivo == true or 
											             controlPacientes.booleanUpgradeDispositivo == true or 
											             controlPacientes.booleanRecolocacionGenerador == true or 
											             controlPacientes.booleanRecolocacionElectrodo == true or 
											             controlPacientes.booleanReimplante == true}"/>
										</h:panelGrid>
										<h:panelGrid columns="2">
											<a4j:commandLink reRender="panCitas" 
												actionListener="#{controlCitas.actualizaValoresProperties }"
												onclick="javascript:Richfaces.showModalPanel('buscando');" 
												oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
												<h:graphicImage value="/img/iconos/guarda.png" width="24" height="24" 
													style="border:0;" title="#{ms.citas_agenda_huecos_msg_1 }"/>																
											</a4j:commandLink>
											<h:outputLabel value="#{ms.editar }" style="font-weight: bold;"/>
										</h:panelGrid>
									</rich:simpleTogglePanel>						
								</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
						
				</rich:panel>
			</h:panelGrid>
			
			
			<rich:modalPanel id="gestionHuecoEvento" autosized="true" zindex="2000" minWidth="250" showWhenRendered="#{controlCitas.editar eq true}">
				<f:facet name="header">
					<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.citas_evento_modal_msg_1 }" styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid columns="4">
						<a4j:commandLink actionListener="#{controlCitas.preguardaNuevoEvento }"
							reRender="panCitas,citas,nuevoevento,listacitas,panEventoCitaHueco,infoNuevoEvento" rendered="#{controlCitas.evento.idevento eq null }"
							onclick="javascript:Richfaces.hideModalPanel('gestionHuecoEvento');"
							oncomplete="javascript:Richfaces.showModalPanel('confirmaNuevoEvento');">
							<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
								width="16px" height="16px" title="#{ms.confirmar }"/>
						</a4j:commandLink>
						<a4j:commandLink actionListener="#{controlCitas.editarEvento }"
							reRender="panCitas,citas,nuevoevento,listacitas,panEventoCitaHueco" rendered="#{controlCitas.evento.idevento ne null }"
							onclick="javascript:Richfaces.hideModalPanel('gestionHuecoEvento');">
							<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
								width="16px" height="16px" title="#{ms.confirmar }"/>
						</a4j:commandLink>
						<a4j:commandLink reRender="panCitas,panEventoCitaHueco"
							onclick="if (!confirm('#{ms.warn_borra_evento}')) return false;javascript:Richfaces.showModalPanel('buscando');"
							oncomplete="javascript:Richfaces.hideModalPanel('buscando');javascript:Richfaces.hideModalPanel('gestionHuecoEvento');"
							actionListener="#{controlCitas.eliminarEvento}" title="Borrar evento"
							rendered="#{controlCitas.evento.idevento ne null }">
							<h:graphicImage value="/img/iconos/borra.png" width="20"
								height="20" style="border:0;" title="#{ms.eliminar }"/>				
						</a4j:commandLink>
						<a4j:commandLink actionListener="#{controlCitas.cierraVentanaHueco }"
							reRender="panCitas,panEventoCitaHueco"
							onclick="javascript:Richfaces.hideModalPanel('gestionHuecoEvento');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;"
								onclick="javascript:Richfaces.hideModalPanel('gestionEvento')"
								title="#{ms.cancelar }" />
						</a4j:commandLink>								
					</h:panelGrid>
				</f:facet>
				<h:panelGrid id="nuevoeventohueco" width="100%">
					<h:panelGrid columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop" id="nuevoEventoInfoDemografica">
						<h:panelGrid>
							<h:outputLabel value="#{ms.citas_pat_msg_4 }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
								<h:inputText value="#{controlCitas.evento.idpaciente }" disabled="#{controlCitas.evento.idpaciente ne null}"/>											
							</h:panelGrid>	
						</h:panelGrid>					
						<h:panelGrid>
							<h:outputLabel value="#{ms.citas_pat_msg_6 }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlCitas.evento.nombre }" disabled="#{controlCitas.evento.nombre ne null}"/>
							</h:panelGrid>	
						</h:panelGrid>
						<h:panelGrid>
							<h:outputLabel value="#{ms.citas_pat_msg_7 }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlCitas.evento.apellido1 }" disabled="#{controlCitas.evento.apellido1 ne null}"/>
							</h:panelGrid>	
						</h:panelGrid>
						<h:panelGrid>
							<h:outputLabel value="#{ms.citas_pat_msg_8 }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlCitas.evento.apellido2 }" disabled="#{controlCitas.evento.apellido2 ne null}"/>
							</h:panelGrid>	
						</h:panelGrid>
					</h:panelGrid>
					<ui:include src="/ventanas/administracion/citas/evento.jsp"/>
				</h:panelGrid>
			</rich:modalPanel>
			
			
			<rich:modalPanel id="confirmaNuevoEvento" autosized="true" zindex="2000" minWidth="300" width="400">
				<f:facet name="header">
					<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.citas_evento_modal_msg_2 }" styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid columns="3">
						<a4j:commandLink actionListener="#{controlCitas.insertarNuevoEvento }"
							reRender="panCitas,citas,panNuevaAgenda" 
							onclick="javascript:Richfaces.hideModalPanel('confirmaNuevoEvento');">
							<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
								width="16px" height="16px" title="#{ms.confirmar }"/>
						</a4j:commandLink>						
						<a4j:commandLink 
							onclick="javascript:Richfaces.hideModalPanel('confirmaNuevoEvento');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;"
								onclick="javascript:Richfaces.hideModalPanel('confirmaNuevoEvento')"
								title="#{ms.cancelar }" />
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid id="infoNuevoEvento" width="100%">
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop" width="100%">
						<h:panelGrid width="100%" columnClasses="alignTop">
							<h:outputLabel value="#{ms.citas_pat_msg_4 }" style="font-weight: bold;"/>							
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlCitas.info.idpaciente }" disabled="true"/>
							</h:panelGrid>							
							<h:outputLabel value="#{ms.citas_pat_msg_6 }" style="font-weight: bold;"/>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlCitas.info.nombre}" disabled="true"/>
							</h:panelGrid>							
							<h:outputLabel value="#{ms.citas_pat_msg_9 }" style="font-weight: bold;"/>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlCitas.info.apellido1} #{controlCitas.info.apellido2}" disabled="true"/>
							</h:panelGrid>							
						</h:panelGrid>
						<h:panelGrid width="100%">
							<h:outputLabel value="#{ms.citas_lt_msg_5 }" style="font-weight: bold;"/>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlCitas.info.procedimiento}" disabled="true">
									<f:selectItem itemLabel="#{ms.proc_0 }" itemValue="0"/>
									<f:selectItem itemLabel="#{ms.proc_1061 }" itemValue="1061"/>
									<f:selectItem itemLabel="#{ms.proc_956 }" itemValue="956"/>
									<f:selectItem itemLabel="#{ms.proc_1059 }" itemValue="1059"/>
									<f:selectItem itemLabel="#{ms.proc_1060 }" itemValue="1060"/>
									<f:selectItem itemLabel="#{ms.proc_1085 }" itemValue="1085"/>
									<f:selectItem itemLabel="#{ms.proc_1086 }" itemValue="1086"/>
									<f:selectItem itemLabel="#{ms.proc_1090 }" itemValue="1090"/>
									<f:selectItem itemLabel="#{ms.proc_1147 }" itemValue="1147"/>
									<f:selectItem itemLabel="#{ms.proc_983 }" itemValue="983"/>
									<f:selectItem itemLabel="#{ms.proc_1068 }" itemValue="1068"/>
									<f:selectItem itemLabel="#{ms.proc_1063 }" itemValue="1063"/>
									<f:selectItem itemLabel="#{ms.proc_1064 }" itemValue="1064"/>
									<f:selectItem itemLabel="#{ms.proc_1065 }" itemValue="1065"/>
									<f:selectItem itemLabel="#{ms.proc_1066 }" itemValue="1066"/>
									<f:selectItem itemLabel="#{ms.proc_1067 }" itemValue="1067"/>
									<f:selectItem itemLabel="#{ms.proc_1089 }" itemValue="1089"/>
									<f:selectItem itemLabel="#{ms.proc_1091 }" itemValue="1091"/>
									<f:selectItem itemLabel="#{ms.proc_1087 }" itemValue="1087"/>
									<f:selectItem itemLabel="#{ms.proc_1 }" itemValue="1"/>
								</h:selectOneMenu>
							</h:panelGrid>							
							<h:panelGrid columns="2">
								<h:panelGrid>
									<h:outputLabel value="#{ms.citas_lt_msg_7 }" style="font-weight: bold;"/>
									<h:panelGrid style="border-top: solid 1px;border-color: black;">
										<h:outputLabel value="#{controlCitas.info.fechaini }">
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</h:panelGrid>
								</h:panelGrid>
								<h:panelGrid>
									<h:outputLabel value="#{ms.citas_lt_msg_8 }" style="font-weight: bold;"/>
									<h:panelGrid style="border-top: solid 1px;border-color: black;">
										<h:outputLabel value="#{controlCitas.info.fechaini }">
											<f:convertDateTime pattern="HH:mm:ss" timeZone="GMT+2"/>
										</h:outputLabel>
									</h:panelGrid>
								</h:panelGrid>
							</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
			</rich:modalPanel>
			
			
			<rich:modalPanel id="nuevaAgenda" autosized="true" zindex="2000" minWidth="250">
				<f:facet name="header">
					<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.citas_evento_modal_msg_3 }" styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid columns="3">
						<a4j:commandLink actionListener="#{controlCitas.guardarAgenda }"
							reRender="panCitas,citas,panNuevaAgenda" 
							onclick="javascript:Richfaces.hideModalPanel('nuevaAgenda');">
							<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
								width="16px" height="16px" title="#{ms.confirmar }"/>
						</a4j:commandLink>						
						<a4j:commandLink 
							onclick="javascript:Richfaces.hideModalPanel('nuevaAgenda');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;"
								onclick="javascript:Richfaces.hideModalPanel('nuevaAgenda')"
								title="#{ms.cancelar }" />
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid id="nuevaAgendaPersonal" width="100%">
					<ui:include src="/ventanas/administracion/citas/agenda.jsp"/>
				</h:panelGrid>
			</rich:modalPanel>
			
			<rich:modalPanel id="listainformeseventos" autosized="true" zindex="2000" minWidth="175">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.citas_evento_modal_msg_4 }" styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>
						<a4j:commandLink 
							onclick="javascript:Richfaces.hideModalPanel('listainformeseventos');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;"
								onclick="javascript:Richfaces.hideModalPanel('listainformeseventos')"
								title="#{ms.cancelar }" />
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>
					<h:outputLabel value="#{ms.citas_evento_modal_msg_5 }" style="font-weight: bold;"/>					
					<h:panelGrid>
						<h:commandLink actionListener="#{controlCitas.generaInformeDiario }"
							target="_blank"
							onclick="javascript:Richfaces.hideModalPanel('listainformeseventos');">	
							<h:graphicImage style="align:right;border:none;"
								styleClass="hvn_enlImagen" title="#{ms.generar_informe }"
								width="24" height="24" url="/img/iconos/informe_especial.png"/>						
							<h:outputLabel value="#{ms.citas_agenda_disp_msg_5 }" style="font-weight: bold;"/>
						</h:commandLink>
						<rich:spacer height="2px"/>
						<h:commandLink actionListener="#{controlCitas.generaInformeSemanal }"
							target="_blank"
							onclick="javascript:Richfaces.hideModalPanel('listainformeseventos');">
							<h:graphicImage style="align:right;border:none;"
								styleClass="hvn_enlImagen" title="#{ms.generar_informe }"
								width="24" height="24" url="/img/iconos/informe_especial.png"/>
							<h:outputLabel value="#{ms.citas_agenda_disp_msg_6 }" style="font-weight: bold;"/>
						</h:commandLink>
						<rich:spacer height="2px"/>
						<h:commandLink actionListener="#{controlCitas.generaInformeMensual }"
							target="_blank"
							onclick="javascript:Richfaces.hideModalPanel('listainformeseventos');">
							<h:graphicImage style="align:right;border:none;"
								styleClass="hvn_enlImagen" title="#{ms.generar_informe }"
								width="24" height="24" url="/img/iconos/informe_especial.png"/>
							<h:outputLabel value="#{ms.citas_agenda_disp_msg_7 }" style="font-weight: bold;"/>
						</h:commandLink>
					</h:panelGrid>	
				</h:panelGrid>
			</rich:modalPanel>
			
		</h:form>	
	</ui:define>
</ui:composition>
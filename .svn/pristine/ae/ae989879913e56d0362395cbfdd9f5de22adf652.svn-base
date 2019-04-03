<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:s="http://myfaces.apache.org/sandbox" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="consultaPaciente">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid width="85%" id="panelContenidoGlobal" onkeypress="if(event.keyCode==13) buscarEnter();"
				style="margin-top: 15px;">
				<rich:messages errorClass="hvn_msjError" warnClass="hvn_msjAviso"
					infoClass="hvn_msjInfo" />
				<rich:panel>
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.pat_consulta_title}"
								style="color: white;" />
							<h:panelGrid columns="2" columnClasses="right">
								<a4j:commandLink id="botonBuscar"
									actionListener="#{controlPacientes.buscaPacientes}"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									style="align:right;" reRender="panelContenidoGlobal">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" id="icoBuscar" title="#{ms.buscar }"
										width="24" height="24" url="/img/iconos/buscar.png" />
								</a4j:commandLink>
								<a4j:commandLink
									actionListener="#{controlPacientes.limpiarPacienteSelect}"
									style="align:right;" reRender="panelContenidoGlobal">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" id="icoLimpiar" title="#{ms.limpiar }"
										width="24" height="24" url="/img/iconos/limpia.png" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<h:panelGrid columns="4" id="datosPacienteSelect">
						<h:panelGrid columns="1">
							<h:outputText value="#{ms.pat_consulta_cip }" title="#{ms.pat_consulta_cip_title }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText styleClass="estiloInput" size="15"
									value="#{controlPacientes.filtro.nuhsa}" />
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid columns="1">
							<h:outputText value="#{ms.pat_consulta_nhc }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText styleClass="estiloInput" size="10" id="nhc"
									value="#{controlPacientes.filtro.nhc}" />
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid columns="1">
							<h:outputText value="#{ms.pat_consulta_nombre }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText styleClass="estiloInput" size="20"
									value="#{controlPacientes.filtro.nombre}" />
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid columns="1">
							<h:outputText value="#{ms.pat_consulta_apellidos }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								columns="2">
								<h:inputText styleClass="estiloInput" size="30"
									value="#{controlPacientes.filtro.apellid1}" />
								<h:inputText styleClass="estiloInput" size="30"
									value="#{controlPacientes.filtro.apellid2}" />
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid columns="1">
							<h:outputText value="#{ms.pat_consulta_nif }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								columns="1">
								<h:inputText styleClass="estiloInput" size="15"
									value="#{controlPacientes.filtro.dni}" />
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid columns="1">
							<h:outputText value="#{ms.pat_consulta_nss }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								columns="1">
								<h:inputText styleClass="estiloInput" size="12" maxlength="12"
									value="#{controlPacientes.filtro.nss1}" />
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid columns="1">
							<h:outputText value="#{ms.pat_consulta_fnac }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
									popup="true" showInput="true" enableManualInput="true"
									value="#{controlPacientes.filtro.fechaNaci}">
								</rich:calendar>
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid columns="1"  columnClasses="alignTop, alignTop"
							width="100%">
							<h:outputText value="#{ms.pat_consulta_sexo }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
							<h:outputText value="Procedimientos"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" rendered="false"/>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneRadio
									value="#{controlPacientes.filtro.sexo}">
									<f:selectItem itemLabel="Hombre" itemValue="1" />
									<f:selectItem itemLabel="Mujer" itemValue="2" />
								</h:selectOneRadio>
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="6" rendered="false">
								<h:selectBooleanCheckbox value="#{controlPacientes.filtro.eef}"/>
								<h:outputLabel value="EEF"/>
								<h:selectBooleanCheckbox value="#{controlPacientes.filtro.dai}" />
								<h:outputLabel value="DAI" rendered="false"/>
								<h:selectBooleanCheckbox value="#{controlPacientes.filtro.cv}"/>
								<h:outputLabel value="CV"/>
							</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid id="datosPacienteSelectProcs">
						<t:fieldset legend="#{ms.pat_consulta_filtro_proc_title }">
							<h:panelGrid columns="4">
								<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_1 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
								<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_2 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
								<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_3 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
								<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_4 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:selectOneMenu value="#{controlPacientes.filtro.tipoproc }" >
										<f:selectItems value="#{controlPacientes.modulos }" />
										<a4j:support event="onchange" reRender="panFiltrosConsultaProcs" ajaxSingle="true"/>
									</h:selectOneMenu>
								</h:panelGrid>		
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
										popup="true" showInput="true" enableManualInput="true"
										value="#{controlPacientes.filtro.fechaproc }">
									</rich:calendar>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
										popup="true" showInput="true" enableManualInput="true"
										value="#{controlPacientes.filtro.fechaprocfin }">
									</rich:calendar>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:inputText value="#{controlPacientes.filtro.nproc }" size="5"/>
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid id="panFiltrosConsultaProcs">
								<h:panelGrid rendered="#{controlPacientes.filtro.tipoproc eq 1}">
									<h:panelGrid columns="2">
										<h:panelGrid columns="2">
											<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_5 }" style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;"/>
											<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_6 }" style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;"/>
											<h:panelGrid style="border-top: solid 1px;border-color: black;">
												<h:selectOneMenu value="#{controlPacientes.filtro.diagEef }">
													<f:selectItems value="#{controlEef.diagnosticos }" />
												</h:selectOneMenu>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;">
												<h:selectOneMenu value="#{controlPacientes.filtro.ablEef}">
													<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
													<f:selectItem itemLabel="#{ms.pat_consulta_filtro_proc_msg_7 }" itemValue="0" />
													<f:selectItem itemLabel="#{ms.pat_consulta_filtro_proc_msg_8 }" itemValue="1" />
													<f:selectItem itemLabel="#{ms.pat_consulta_filtro_proc_msg_9 }" itemValue="2" />
													<a4j:support event="onchange" reRender="panFiltrosConsultaProcsEef" ajaxSingle="true"/>
												</h:selectOneMenu>
											</h:panelGrid>
										</h:panelGrid>
										<h:panelGrid id="panFiltrosConsultaProcsEef">
											<h:panelGrid rendered="#{controlPacientes.filtro.ablEef eq 2}">
												<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_10 }" style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;"/>
												<h:panelGrid style="border-top: solid 1px;border-color: black;">
													<h:selectOneMenu value="#{controlPacientes.filtro.sustAblEef }">
														<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0"/>
														<f:selectItem itemLabel="#{ms.eef_abl_sust_1 }" itemValue="1"/>
														<f:selectItem itemLabel="#{ms.eef_abl_sust_2 }" itemValue="2"/>
														<f:selectItem itemLabel="#{ms.eef_abl_sust_3 }" itemValue="3"/>
														<f:selectItem itemLabel="#{ms.eef_abl_sust_4 }" itemValue="4"/>
														<f:selectItem itemLabel="#{ms.eef_abl_sust_5 }" itemValue="5"/>
														<f:selectItem itemLabel="#{ms.eef_abl_sust_6 }" itemValue="6"/>
														<f:selectItem itemLabel="#{ms.eef_abl_sust_7 }" itemValue="7"/>
														<f:selectItem itemLabel="#{ms.eef_abl_sust_8 }" itemValue="8"/>
														<f:selectItem itemLabel="#{ms.eef_abl_sust_9 }" itemValue="9"/>
													</h:selectOneMenu>
												</h:panelGrid>
											</h:panelGrid>
										</h:panelGrid>
									</h:panelGrid>
								</h:panelGrid>
								<h:panelGrid rendered="#{controlPacientes.filtro.tipoproc eq 8}">
									<h:panelGrid columns="2">
										<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_11 }" style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;"/>
										<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_12 }" style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlPacientes.filtro.modeloGen }"/>
										</h:panelGrid>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlPacientes.filtro.numserieGen }"/>
										</h:panelGrid>
									</h:panelGrid>
								</h:panelGrid>
								<h:panelGrid rendered="#{controlPacientes.filtro.tipoproc eq 3}">
									<h:panelGrid columns="2">
										<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_13 }" style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;"/>
										<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_12 }" style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlPacientes.filtro.modeloRegEv }"/>
										</h:panelGrid>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlPacientes.filtro.numserieRegEv }"/>
										</h:panelGrid>
									</h:panelGrid>
								</h:panelGrid>
								<h:panelGrid rendered="#{controlPacientes.filtro.tipoproc eq 11}">
									<h:panelGrid>
										<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_14 }" style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:selectOneMenu value="#{controlPacientes.filtro.estadoprocfiltro }">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-100" />
												<f:selectItem itemLabel="#{ms.holter24h_estado_op0 }" itemValue="0" />
												<f:selectItem itemLabel="#{ms.holter24h_estado_op1 }" itemValue="1" />
												<f:selectItem itemLabel="#{ms.holter24h_estado_op2 }" itemValue="2" />
												<f:selectItem itemLabel="#{ms.holter24h_estado_op3 }" itemValue="3" />
												<f:selectItem itemLabel="#{ms.holter24h_estado_op_1 }" itemValue="-1" />
												<f:selectItem itemLabel="#{ms.holter24h_estado_op_2 }" itemValue="-2" />
												<f:selectItem itemLabel="#{ms.holter24h_estado_op_3 }" itemValue="-3" />
												<f:selectItem itemLabel="#{ms.holter24h_estado_op_4 }" itemValue="-4" />														
											</h:selectOneMenu>
										</h:panelGrid>
									</h:panelGrid>
								</h:panelGrid>
								<h:panelGrid rendered="#{controlPacientes.filtro.tipoproc eq 12}">
									<h:panelGrid>
										<h:outputText value="#{ms.pat_consulta_filtro_proc_msg_14 }" style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:selectOneMenu value="#{controlPacientes.filtro.estadoprocfiltro }">
												<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-100" />
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
									</h:panelGrid>
								</h:panelGrid>
							</h:panelGrid>
						</t:fieldset>
					</h:panelGrid>
					<h:panelGrid columnClasses="alignRight" columns="3" id="panResultadosBusquedaPacientes">
						<f:attribute name="align" value="right" />
						<h:outputLabel value="#{ms.pat_consulta_resultados_msg_1 }" style="font-weight: bold" 
							rendered="#{controlPacientes.listaPacientes ne null and not empty controlPacientes.listaPacientes }"/>
						<h:outputLabel value="#{fn:length(controlPacientes.listaPacientes) } #{ms.pat_consulta_resultados_msg_2 }." 
							style="font-weight: bold;color:#E17009" rendered="#{controlPacientes.listaPacientes ne null and not empty controlPacientes.listaPacientes }"/>
						<t:commandLink actionListener="#{controlPacientes.exportarDatos}" target="_blank" title="#{ms.exportar_excel }"
							rendered="#{controlPacientes.listaPacientes ne null and not empty controlPacientes.listaPacientes }">
							<h:graphicImage value="/img/iconos/excel_icon.png" width="16" height="16" style="border: 0px;"/>
						</t:commandLink>
					</h:panelGrid>
					<h:panelGrid id="PanelTabla" width="100%">
						<t:dataTable width="100%" rows="10"
							value="#{controlPacientes.listaPacientes}" var="linea"
							id="listaRRLL"
							style="width:100%;background-color: #ffffff;
                 	 			background-image:url(/jwoncologia/img/iconos/seguimiento.png);
                     			background-repeat: no-repeat;
                     			background-position:right bottom;"
							styleClass="hor-minimalist-b"
							sortColumn="#{controlPacientes.columna }"
							sortAscending="#{controlPacientes.ascendente }"
							binding="#{controlPacientes.bindingTabla}">
							<f:facet name="header">
								<h:outputText value="#{ms.pacientes }" styleClass="textoBlancoNegrita" />
							</f:facet>

							<t:column width="10%" style="text-align: left;"
								styleClass="hor-minimalist-b-row" id="procedimientos" sortable="false" rendered="false">
								<f:facet name="header">
									<h:outputText value="#{ms.procedimientos }" id="cabProc" />
								</f:facet>
								<h:panelGrid style="text-align:left;"  id="hpanproc" columns="3"
									columnClasses="alignTop,AlignTop,AlignTop" cellspacing="0" cellpadding="3">
									<h:graphicImage value="/img/iconos/EEFdis.png" style="border: 0px;"
										rendered="#{linea.neef eq 0 }"/>
									<a4j:commandLink id="linkeef" rendered="#{linea.neef ne 0 }"
										actionListener="#{controlPacientes.obtenLineaeef}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="ver último Estudio" action="irEef">
										<h:graphicImage value="/img/iconos/EEF.png" style="border: 0px;"/>
									</a4j:commandLink>
									<h:graphicImage value="/img/iconos/DAIdis.png" style="border: 0px;"
										rendered="false"/>
									<a4j:commandLink id="linkdai" rendered="false"
										actionListener="#{controlPacientes.obtenLineadai}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="ver último DAI" action="irDesfibriladores">
										<h:graphicImage value="/img/iconos/DAI.png" style="border: 0px;"/>
									</a4j:commandLink>
									<h:graphicImage value="/img/iconos/CVdis.png" style="border: 0px;"
										rendered="#{linea.ncv eq 0 }"/>
									<a4j:commandLink id="linkcv" rendered="#{linea.ncv ne 0 }"
										actionListener="#{controlPacientes.obtenLineacv}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="ver última CV" action="irCardioversion">
										<h:graphicImage value="/img/iconos/CV.png" style="border: 0px;"/>
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>
							
							<t:column width="15%" style="text-align: left;" rendered="#{loginForm.acceso.idrolacceso ne 3 }"
								styleClass="hor-minimalist-b-row" id="procs" sortable="true">
								<f:facet name="header">
									<t:commandSortHeader columnName="procsId" arrow="true">
										<h:outputText value="#{ms.procedimiento }" id="cabProcs" />
									</t:commandSortHeader>
								</f:facet>
								<h:panelGrid style="text-align:left;"  id="hpanprocs" columns="3"
									columnClasses="alignTop,AlignTop,AlignTop" cellspacing="0" cellpadding="3">
									<a4j:commandLink id="linkprocseef" rendered="#{controlPacientes.filtro.tipoproc eq 1 }"
										actionListener="#{controlPacientes.obtenLineaeef}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irEef">
										<h:graphicImage value="/img/iconos/hearticon.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.neef }" />
									</a4j:commandLink> 
									<a4j:commandLink id="linkprocsreg" rendered="#{controlPacientes.filtro.tipoproc eq 3 }"
										actionListener="#{controlPacientes.obtenLineaReg}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irRegistrador">
										<h:graphicImage value="/img/iconos/ViewResults.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.nreg }" />
										<h:panelGrid>
											<h:outputLabel value="#{linea.modeloDisp }" />
											<h:outputLabel value="#{linea.nserieDisp }" />
										</h:panelGrid>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocscv" rendered="#{controlPacientes.filtro.tipoproc eq 2 }"
										actionListener="#{controlPacientes.obtenLineacv}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irCardioversion">
										<h:graphicImage value="/img/iconos/shock.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.ncv }" />
									</a4j:commandLink>
									<a4j:commandLink id="linkprocsmesa" rendered="#{controlPacientes.filtro.tipoproc eq 4 }"
										actionListener="#{controlPacientes.obtenLineaMesa}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irMesa">
										<h:graphicImage value="/img/iconos/mesabasc.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.nmesa }" />
									</a4j:commandLink>
									<a4j:commandLink id="linkprocstestatp" rendered="#{controlPacientes.filtro.tipoproc eq 5 }"
										actionListener="#{controlPacientes.obtenLineaTestAtp}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irATP">
										<h:graphicImage value="/img/iconos/Pills.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.natp }" />
									</a4j:commandLink>
									<a4j:commandLink id="linkprocstestepi" rendered="#{controlPacientes.filtro.tipoproc eq 6 }"
										actionListener="#{controlPacientes.obtenLineaTestEpi}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irEpi">
										<h:graphicImage value="/img/iconos/Pills.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.nepi }" />
									</a4j:commandLink>
									<a4j:commandLink id="linkprocstestfle" rendered="#{controlPacientes.filtro.tipoproc eq 7 }"
										actionListener="#{controlPacientes.obtenLineaTestFle}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irFle">
										<h:graphicImage value="/img/iconos/Pills.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.nfle }" />
									</a4j:commandLink>
									<a4j:commandLink id="linkprocsimps" rendered="#{controlPacientes.filtro.tipoproc eq 8 }"
										actionListener="#{controlPacientes.obtenLineaImplante}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irImplantes">
										<h:graphicImage value="/img/iconos/Skalpell.png" style="border: 0px;"
											width="22" height="22" rendered="#{linea.tipoproc eq 957 || linea.tipoproc eq 1085 || linea.tipoproc eq 1086 ||linea.tipoproc eq 1147 }"/>
										<h:graphicImage value="/img/iconos/dispositivo.png" style="border: 0px;"
											width="22" height="22" rendered="#{linea.tipoproc eq 956 || linea.tipoproc eq 1059 || linea.tipoproc eq 1060 || linea.tipoproc eq 993 || linea.tipoproc eq 1090}"/>
										<h:outputLabel value="#{linea.nimp }" />
										<h:panelGrid>
											<h:outputLabel value="#{linea.modeloDisp }" />
											<h:outputLabel value="#{linea.nserieDisp }" />
										</h:panelGrid>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocssegclin" rendered="#{controlPacientes.filtro.tipoproc eq 9 }"
										actionListener="#{controlPacientes.obtenLineaSegClin}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irSeguimientoClinico">
										<h:graphicImage value="/img/iconos/BandAid.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.nsegclin }" />
									</a4j:commandLink>
									<a4j:commandLink id="linkprocssegregev" rendered="#{controlPacientes.filtro.tipoproc eq 10 }"
										actionListener="#{controlPacientes.obtenLineaSegRegEv}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irSeguimientosRegEventos">
										<h:graphicImage value="/img/iconos/segregev.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.nsegregev }" />
									</a4j:commandLink>
									<a4j:commandLink id="linkprocsholter" rendered="#{controlPacientes.filtro.tipoproc eq 11 }"
										actionListener="#{controlPacientes.obtenLineaHolter}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irHolter">
										<h:graphicImage value="/img/iconos/holter.png" style="border: 0px;"
											width="22" height="22"/>
										<h:graphicImage value="/img/iconos/sd.png" style="border: 0px;"
											width="22" height="22" rendered="#{linea.estadoproc eq 0 }" title="#{ms.holter24h_estado_op0 }"/>
										<h:graphicImage value="/img/genericos/time.png" style="border: 0px;"
											width="18" height="18" rendered="#{linea.estadoproc eq 1 }" title="#{ms.holter24h_estado_op1 }"/>
										<h:graphicImage value="/img/iconos/ViewResults.png" style="border: 0px;"
											width="22" height="22" rendered="#{linea.estadoproc eq 2 }" title="#{ms.holter24h_estado_op2 }"/>
										<h:graphicImage value="/img/aplicacion/accept.png" style="border: 0px;"
											width="16" height="16" rendered="#{linea.estadoproc eq 3 }" title="#{ms.holter24h_estado_op3 }"/>
										<h:graphicImage value="/img/aplicacion/icoCancelar.png" style="border: 0px;"
											width="18" height="18" rendered="#{linea.estadoproc &lt; 0 }" title="Error"/>
										<h:outputLabel value="#{linea.nholter }" />
									</a4j:commandLink>
									<a4j:commandLink id="linkprocsregevext" rendered="#{controlPacientes.filtro.tipoproc eq 12 }"
										actionListener="#{controlPacientes.obtenLineaRegEvExt}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irRegEvExt">
										<h:graphicImage value="/img/iconos/regevext.png" style="border: 0px;"
											width="22" height="22"/>
										<h:graphicImage value="/img/iconos/hookup.png" style="border: 0px;"
											width="22" height="22" rendered="#{linea.estadoproc eq 100 }" title="#{ms.elr_estado_op100 }"/>
										<h:graphicImage value="/img/iconos/sd.png" style="border: 0px;"
											width="22" height="22" rendered="#{linea.estadoproc eq 0 }" title="#{ms.elr_estado_op0 }"/>
										<h:graphicImage value="/img/genericos/time.png" style="border: 0px;"
											width="18" height="18" rendered="#{linea.estadoproc eq 1 }" title="#{ms.elr_estado_op1 }"/>
										<h:graphicImage value="/img/iconos/ViewResults.png" style="border: 0px;"
											width="22" height="22" rendered="#{linea.estadoproc eq 2 }" title="#{ms.elr_estado_op2 }"/>
										<h:graphicImage value="/img/aplicacion/accept.png" style="border: 0px;"
											width="16" height="16" rendered="#{linea.estadoproc eq 3 }" title="#{ms.elr_estado_op3 }"/>
										<h:graphicImage value="/img/aplicacion/icoCancelar.png" style="border: 0px;"
											width="18" height="18" rendered="#{linea.estadoproc &lt; 0 }" title="Error"/>
										<h:outputLabel value="#{linea.nregevext }" />
									</a4j:commandLink>
									<a4j:commandLink id="linkprocstestorto" rendered="#{controlPacientes.filtro.tipoproc eq 13 }"
										actionListener="#{controlPacientes.obtenLineaTestOrto}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irTestOrto">
										<h:graphicImage value="/img/iconos/bpm.png" style="border: 0px;"
											width="22" height="22"/>
										<h:outputLabel value="#{linea.ntestorto }" />
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>
							<t:column width="15%" style="text-align: left;" rendered="#{loginForm.acceso.idrolacceso ne 3 }"
								styleClass="hor-minimalist-b-row" id="procsfecha" sortable="true">
								<f:facet name="header">		
									<t:commandSortHeader columnName="procsFechas" arrow="true">
										<h:outputText value="#{ms.fecha_procedimiento }" id="cabProcsFechas" />
									</t:commandSortHeader>
								</f:facet>
								<h:panelGrid style="text-align:left;"  id="hpanprocsfechas" columns="3"
									columnClasses="alignTop,AlignTop,AlignTop" cellspacing="0" cellpadding="3">
									<a4j:commandLink id="linkprocseeffecha" rendered="#{linea.fechaeef ne null }"
										actionListener="#{controlPacientes.obtenLineaeef}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irEef">
										<h:outputLabel value="#{linea.fechaeef }">
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocsregfecha" rendered="#{linea.fechareg ne null }"
										actionListener="#{controlPacientes.obtenLineaReg}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irRegistrador">
										<h:outputLabel value="#{linea.fechareg }">
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocscvfecha" rendered="#{linea.fechacv ne null }"
										actionListener="#{controlPacientes.obtenLineacv}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irCardioversion">
										<h:outputLabel value="#{linea.fechacv }" >
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocsmesafecha" rendered="#{linea.fechamesa ne null }"
										actionListener="#{controlPacientes.obtenLineaMesa}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irMesa">										
										<h:outputLabel value="#{linea.fechamesa }" >
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocstestatpfecha" rendered="#{linea.fechaatp ne null }"
										actionListener="#{controlPacientes.obtenLineaTestAtp}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irATP">									
										<h:outputLabel value="#{linea.fechaatp }" >
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocstestepifecha" rendered="#{linea.fechaepi ne null }"
										actionListener="#{controlPacientes.obtenLineaTestEpi}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irEpi">								
										<h:outputLabel value="#{linea.fechaepi }" >
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocstestflefecha" rendered="#{linea.fechafle ne null }"
										actionListener="#{controlPacientes.obtenLineaTestFle}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irFle">										
										<h:outputLabel value="#{linea.fechafle }" >
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocsimpsfecha" rendered="#{linea.fechaimp ne null }"
										actionListener="#{controlPacientes.obtenLineaImplante}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irImplantes">										
										<h:outputLabel value="#{linea.fechaimp }" >
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocssegclinfecha" rendered="#{linea.fechasegclin ne null }"
										actionListener="#{controlPacientes.obtenLineaSegClin }"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										title="#{ms.ver_registro }" action="irSeguimientosClinicos">										
										<h:outputLabel value="#{linea.fechasegclin }" >
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocssegregevfecha" rendered="#{linea.fechasegregev ne null }" 
										actionListener="#{controlPacientes.obtenLineaSegRegEv }" 
										onclick="javascript:Richfaces.showModalPanel('buscando');" 
										title="#{ms.ver_registro }" action="irSeguimientosRegEventos">										
										<h:outputLabel value="#{linea.fechasegregev }">
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocsholterfecha" rendered="#{linea.fechaholter ne null }" 
										actionListener="#{controlPacientes.obtenLineaHolter }" 
										onclick="javascript:Richfaces.showModalPanel('buscando');" 
										title="#{ms.ver_registro }" action="irHolter">										
										<h:outputLabel value="#{linea.fechaholter }">
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocsregevextfecha" rendered="#{linea.fecharegevext ne null }" 
										actionListener="#{controlPacientes.obtenLineaRegEvExt }" 
										onclick="javascript:Richfaces.showModalPanel('buscando');" 
										title="#{ms.ver_registro }" action="irRegEvExt">										
										<h:outputLabel value="#{linea.fecharegevext }">
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
									<a4j:commandLink id="linkprocstestortofecha" rendered="#{linea.fechatestorto ne null }" 
										actionListener="#{controlPacientes.obtenLineaTestOrto }" 
										onclick="javascript:Richfaces.showModalPanel('buscando');" 
										title="#{ms.ver_registro }" action="irTestOrto">										
										<h:outputLabel value="#{linea.fechatestorto }">
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>
							
							
	
							<t:column width="12%" style="text-align: left;" title="Nuhsa" rendered="false"
								styleClass="hor-minimalist-b-row" id="nuhsa" sortable="false">
								<f:facet name="header">
									<h:outputText value="Nica" id="cabNuhsa" title="Número de Identificación de Comunidad Autónoma"/>
								</f:facet>
								<h:panelGrid style="text-align:left;" width="100%" id="a78">
									<a4j:commandLink id="a79"
										actionListener="#{controlPacientes.obtenLinea}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										reRender="datosPacienteSelect,panelContenidoGlobal" action="irNuevoPaciente">
										<h:outputText value="#{linea.nuhsa}" id="otNuhsa"
											styleClass="textoNegro" title="#{linea.nuhsa}" />
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>

							<t:column width="6%" style="text-align: left;" title="#{ms.pat_consulta_nhc }"
								id="nhc" sortable="true" styleClass="hor-minimalist-b-row">
								<f:facet name="header">
									<t:commandSortHeader columnName="nhc" arrow="true">
										<h:outputText value="#{ms.pat_consulta_nhc }" id="cabNhc" />
									</t:commandSortHeader>
								</f:facet>
								<h:panelGrid style="text-align:left;" width="100%" id="pnNhc">
									<a4j:commandLink id="clNhc"
										actionListener="#{controlPacientes.obtenLinea}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										reRender="datosPacienteSelect,panelContenidoGlobal" action="irNuevoPaciente">
										<h:outputText value="#{linea.nhc}" id="otNhc"
											styleClass="textoNegro" title="#{linea.nhc}" />
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>

							<t:column width="18%" style="text-align: left;"
								title="#{ms.pat_consulta_apellido_1_title }" id="apellid1" sortable="true"
								styleClass="hor-minimalist-b-row">
								<f:facet name="header">
									<t:commandSortHeader columnName="apellido1" arrow="true">
										<h:outputText value="#{ms.pat_consulta_apellido_1_msg }" id="cabApellid1" />
									</t:commandSortHeader>
								</f:facet>
								<h:panelGrid style="text-align:left;" width="100%"
									id="pnapellid1">
									<a4j:commandLink id="clapellid1"
										actionListener="#{controlPacientes.obtenLinea}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										reRender="datosPacienteSelect,panelContenidoGlobal" action="irNuevoPaciente">
										<h:outputText value="#{linea.apellid1}" id="otapellid1"
											styleClass="textoNegro" title="#{linea.apellid1}" />
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>

							<t:column width="18%" style="text-align: left;" title="#{ms.pat_consulta_apellido_2_title }"
								id="apellid2" sortable="false" styleClass="hor-minimalist-b-row">
								<f:facet name="header">
									<h:outputText value="#{ms.pat_consulta_apellido_2_msg }" id="cabApellid2" />
								</f:facet>
								<h:panelGrid style="text-align:left;" width="100%"
									id="pnapellid2">
									<a4j:commandLink id="clapellid2"
										actionListener="#{controlPacientes.obtenLinea}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										reRender="datosPacienteSelect,panelContenidoGlobal" action="irNuevoPaciente">
										<h:outputText value="#{linea.apellid2}" id="otapellid2"
											styleClass="textoNegro" title="#{linea.apellid2}" />
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>

							<t:column width="13%" style="text-align: left;" title="#{ms.pat_consulta_nombre_title }"
								id="nombre" sortable="true" styleClass="hor-minimalist-b-row">
								<f:facet name="header">
									<t:commandSortHeader columnName="nombre" arrow="true">
										<h:outputText value="#{ms.pat_consulta_nombre_title }" id="cabNombre" />
									</t:commandSortHeader>
								</f:facet>
								<h:panelGrid style="text-align:left;" width="100%" id="pnNombre">
									<a4j:commandLink id="clNombre"
										actionListener="#{controlPacientes.obtenLinea}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										reRender="datosPacienteSelect,panelContenidoGlobal" action="irNuevoPaciente">
										<h:outputText value="#{linea.nombre}" id="otNombre"
											styleClass="textoNegro" title="#{linea.nombre}" />
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>

							<t:column width="10%" style="text-align: left;" title="#{ms.pat_consulta_dni }"
								id="dni" sortable="false" styleClass="hor-minimalist-b-row">
								<f:facet name="header">
									<h:outputText value="#{ms.pat_consulta_dni }" id="cabDni" />
								</f:facet>
								<h:panelGrid width="100%" id="pnDni">
									<a4j:commandLink id="clDni"
										actionListener="#{controlPacientes.obtenLinea}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										reRender="datosPacienteSelect,panelContenidoGlobal" action="irNuevoPaciente">
										<h:outputText value="#{linea.dni}" id="otDni"
											styleClass="textoNegro" title="#{linea.dni}" />
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>

							<t:column width="5%" style="text-align: left;" title="#{ms.pat_consulta_sexo }"
								id="sexo" sortable="false" styleClass="hor-minimalist-b-row">
								<f:facet name="header">
									<h:outputText value="#{ms.pat_consulta_sexo }" id="cabSexo" />
								</f:facet>
								<h:panelGrid style="text-align:center;" width="100%" id="pnSexo">
									<a4j:commandLink id="clSexo"
										actionListener="#{controlPacientes.obtenLinea}"
										onclick="javascript:Richfaces.showModalPanel('buscando');"
										reRender="datosPacienteSelect,panelContenidoGlobal" action="irNuevoPaciente">
										<h:graphicImage value="/img/iconos/masculino.png" id="imgH"
											styleClass="hvn_enlImagen" style="border:none;"
											title="Hombre" rendered="#{linea.sexo eq 1}" />
										<h:graphicImage value="/img/iconos/femenino.png" id="imgM"
											styleClass="hvn_enlImagen" style="border:none;" title="Mujer"
											rendered="#{linea.sexo eq 2}" />
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>

							<f:facet name="footer">
								<rich:datascroller align="center" for="listaRRLL" id="a113"
									renderIfSinglePage="true" fastStep="3"
									page="#{controlPacientes.pagina_inicial}">
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
				</rich:panel>
			</h:panelGrid>
			<script type="text/javascript">
	function buscarEnter() {
		var nuevoFoco = document
				.getElementById('consultaPaciente:botonBuscar');
		nuevoFoco.click();
	}
	document.getElementById('consultaPaciente:nhc').focus();
</script>
		</h:form>
	</ui:define>
</ui:composition>
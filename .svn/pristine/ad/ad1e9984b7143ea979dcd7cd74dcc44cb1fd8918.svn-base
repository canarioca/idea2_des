<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="iniciole">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panlistaespera">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" cellpadding="0"
							cellspacing="0" columnClasses="left,right">
							<h:outputLabel value="#{ms.le_mod_title }" style="color: white;" />
							<h:panelGrid columns="2" columnClasses="right">
								<a4j:commandLink
									actionListener="#{controlLe.buscaPacientes}"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									style="align:right;" reRender="panelle">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" id="icoBuscar" title="#{ms.buscar }"
										width="24" height="24" url="/img/iconos/buscar.png" />
								</a4j:commandLink>
								<a4j:commandLink
									actionListener="#{controlLe.limpiarFiltro}"
									style="align:right;" reRender="panlistaespera">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" id="icoLimpiar" title="#{ms.limpiar }"
										width="24" height="24" url="/img/iconos/limpia.png" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>

					<t:fieldset legend="#{ms.le_mod_busq_filtro_title }">
						<h:panelGrid columns="4" id="filtroLe" width="100%" cellpadding="0" columnClasses="alignTop,alignTop,alignTop,alignTop">
							<h:panelGrid columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
								<h:outputText value="#{ms.le_pat_nueva_msg_1 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:outputText value="#{ms.le_pat_nueva_msg_14 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:outputText value="#{ms.le_pat_nueva_msg_15 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:outputText value="#{ms.le_pat_nueva_msg_16 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:selectOneMenu value="#{controlLe.filtro.estado }">
										<f:selectItem itemValue="0" itemLabel="#{ms.le_pat_busq_msg_estados_1 }" />
										<f:selectItem itemValue="1" itemLabel="#{ms.le_pat_busq_msg_estados_2 }" />
										<f:selectItem itemValue="5" itemLabel="#{ms.le_pat_busq_msg_estados_3 }" />
										<f:selectItem itemValue="3" itemLabel="#{ms.le_pat_busq_msg_estados_4 }" />
										<f:selectItem itemValue="2" itemLabel="#{ms.le_pat_busq_msg_estados_5 }" />
										<f:selectItem itemValue="4" itemLabel="#{ms.le_pat_busq_msg_estados_6 }" />
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:inputText size="9" value="#{controlLe.filtro.nhc }"/>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:inputText size="9" value="#{controlLe.filtro.cip }"/>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:inputText size="9" value="#{controlLe.filtro.codigoLe }"/>
								</h:panelGrid>
							</h:panelGrid>

							<h:panelGrid columns="1" columnClasses="alignTop">
								<h:outputText value="#{ms.le_pat_nueva_msg_2 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:inputText styleClass="estiloInput" size="45"
										value="#{controlLe.filtro.nombre}" />
								</h:panelGrid>
							</h:panelGrid>

							<h:panelGrid columns="1" columnClasses="alignTop">
								<h:outputText value="#{ms.le_pat_nueva_msg_3 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="2">
									<h:inputText styleClass="estiloInput" size="20"
										value="#{controlLe.filtro.apellido1}" />
									<h:inputText styleClass="estiloInput" size="20"
										value="#{controlLe.filtro.apellido2}" />
								</h:panelGrid>
							</h:panelGrid>
							
							<h:panelGrid columns="1" columnClasses="alignTop">
								<h:outputText value="#{ms.le_pat_nueva_msg_4 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="4">
									<h:outputLabel value="#{ms.le_pat_nueva_msg_4_1 }"/>
									<h:inputText styleClass="estiloInput" size="3"
										value="#{controlLe.filtro.edadmin}" />
									<h:outputLabel value="#{ms.le_pat_nueva_msg_4_2 }"/>
									<h:inputText styleClass="estiloInput" size="3"
										value="#{controlLe.filtro.edadmax}" />
								</h:panelGrid>
							</h:panelGrid>

							<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
								<h:outputText value="#{ms.le_mod_busq_filtro_msg_1 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
								<h:outputText value="#{ms.le_pat_nueva_msg_9 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="4">
									<h:outputLabel value="#{ms.le_mod_busq_filtro_msg_1_1 }"/>
									<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
										popup="true" showInput="true" enableManualInput="false"
										value="#{controlLe.filtro.ingreso}" inputSize="11">
									</rich:calendar>
									<h:outputLabel value="#{ms.le_mod_busq_filtro_msg_1_2 }"/>
									<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
										popup="true" showInput="true" enableManualInput="false"
										value="#{controlLe.filtro.ingresomax}" inputSize="11">
									</rich:calendar>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="1">
									<h:selectOneMenu value="#{controlLe.filtro.incluidopor }">
										<f:selectItems value="#{controlLe.operadores }" />
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
							
							<h:panelGrid columns="1" columnClasses="alignTop">
								<h:outputText value="#{ms.le_pat_nueva_msg_7 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="1">
									<h:selectOneMenu value="#{controlLe.filtro.arritmia }">
										<f:selectItems value="#{controlPacientes.arritmiasle }" />
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
							
							<h:panelGrid columns="2" width="100%" columnClasses="alignTop,alignTop">
								<h:outputText value="#{ms.le_pat_nueva_msg_11 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:outputText value="#{ms.le_mod_busq_filtro_msg_2 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="1">
									<h:selectOneMenu value="#{controlLe.filtro.caracter }">
										<f:selectItems value="#{controlPacientes.caracterle }" />
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="1">
									<h:selectOneMenu value="#{controlLe.filtro.tratamiento1 }">
										<f:selectItems value="#{controlPacientes.anticoagulantesle }" />
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
							
							<h:panelGrid columns="1">
								<h:outputText value="#{ms.le_pat_nueva_msg_8 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="1">
									<h:selectOneMenu value="#{controlLe.filtro.procedimiento }">
										<f:selectItems value="#{controlPacientes.procedimientosle }" />
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
						</h:panelGrid>
					</t:fieldset>
					
					<h:panelGrid width="100%" id="panelle">
						<rich:dataTable var="linea" width="100%"
							binding="#{controlLe.bindingle}"
							styleClass="hor-minimalist-b"
							rowClasses="hvn_lstLineaImpar,hvn_lstLineaPar"
							id="tablale" rows="10" value="#{controlLe.lista}">
							<rich:column id="accion">
								<a4j:commandLink actionListener="#{controlLe.verLe }"
									reRender="pandatosle"
									oncomplete="javascript:Richfaces.showModalPanel('datosle');">
									<h:graphicImage style="border: 0px;" value="/img/iconos/search.png"
										width="24px" height="24px"/>
								</a4j:commandLink>
							</rich:column>
							<rich:column id="estado">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_1 }" />
								</f:facet>
								<h:outputText value="#{linea.estadoString }"/>
							</rich:column>
							<rich:column id="codigoLe" label="codigoLe" width="40px">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_2 }" title="#{ms.le_mod_res_filtro_title_2 }" />
								</f:facet>
								<h:outputText value="#{linea.codigoLe }" />
							</rich:column>
							<rich:column id="nhc" width="60px">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_3 }" />
								</f:facet>
								<h:outputText value="#{linea.nhc }" />
							</rich:column>
							<rich:column id="nombre" label="nombre">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_4 }" />
								</f:facet>
								<h:outputText value="#{linea.nombre }" />
							</rich:column>
							<rich:column id="apellido1" label="apellido1">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_5 }" />
								</f:facet>
								<h:outputText value="#{linea.apellido1 }"/>
							</rich:column>
							<rich:column id="apellido2">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_6 }" />
								</f:facet>
								<h:outputText value="#{linea.apellido2 }" />
							</rich:column>
							<rich:column id="edadmin" width="30px" label="edadmin">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_7 }" />
								</f:facet>
								<h:outputText value="#{linea.edadmin }" />
							</rich:column>
							<rich:column id="telefono" width="80px">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_8 }" />
								</f:facet>
								<h:outputText value="#{linea.telefono1 } - #{linea.telefono2 }" />
							</rich:column>
							<rich:column id="ingreso" width="70px" label="ingreso">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_9 }" title="#{ms.le_mod_res_filtro_title_9 }" />
								</f:facet>
								<h:outputText value="#{linea.ingresostr }" />
							</rich:column>
							<rich:column id="arritmia" width="170px">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_10 }" />
								</f:facet>
								<h:outputText value="#{linea.arritmia }" />
							</rich:column>
							<rich:column id="procedimiento">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_11 }" />
								</f:facet>
								<h:outputText value="#{linea.procedimiento }" />
							</rich:column>
							<rich:column id="tratamiento1">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_12 }" title="#{ms.le_mod_res_filtro_title_12 }" />
								</f:facet>
								<h:outputText value="#{linea.tratamiento1 }" />
							</rich:column>
							<rich:column id="caracter">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_13 }" title="#{ms.le_mod_res_filtro_title_13 }" />
								</f:facet>
								<h:graphicImage title="#{linea.caracter }"
									value="/img/iconos/caracter_urgente.png"
									rendered="#{linea.caracter eq 'URGENTE'}"/>
								<h:graphicImage title="#{linea.caracter }"
									value="/img/iconos/caracter_preferente.png"
									rendered="#{linea.caracter eq 'PREFERENTE'}"/>
								<h:graphicImage title="#{linea.caracter }"
									value="/img/iconos/caracter_normal.png"
									rendered="#{linea.caracter eq 'NORMAL'}"/>
							</rich:column>
							<rich:column width="10%" label="Inclusión realizada por" id="incluidoporle">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_14 }"/>
								</f:facet>
								<h:panelGrid columns="2">
									<h:selectOneMenu value="#{linea.incluidopor }" disabled="true">
										<f:selectItems value="#{controlLe.operadores}"/>															
									</h:selectOneMenu>
								</h:panelGrid>
							</rich:column>
							<rich:column id="reclamacion" width="70px" label="reclamacion">
								<f:facet name="header">
									<h:outputText value="#{ms.le_mod_res_filtro_msg_15 }" />
								</f:facet>
								<h:outputText value="#{linea.reclamacionstr }" />
							</rich:column>
							<rich:column id="notas">
								<f:facet name="header">
									<h:outputText value="" />
								</f:facet>
								<h:graphicImage value="/img/iconos/note.png"
									rendered="#{linea.notas ne null }"/>
								<rich:toolTip direction="top-left" rendered="#{linea.notas ne null }">
									<h:outputText value="#{linea.notas }" />
								</rich:toolTip>
							</rich:column>
							<f:facet name="footer">
								<rich:datascroller for="tablale" id="scrollle"
									renderIfSinglePage="false" fastStep="4" stepControls="auto"
									boundaryControls="auto" fastControls="auto" />							
							</f:facet>
						</rich:dataTable>
					</h:panelGrid>
					
					<a4j:jsFunction name="recarga" reRender="panelle"/>
					<t:fieldset legend="#{ms.le_mod_ord_title }">
						<h:selectOneMenu value="#{controlLe.ordenacion }" onchange="recarga();">
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_0 }" itemValue="0"/>
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_1 }" itemValue="1"/>
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_2 }" itemValue="2"/>
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_3 }" itemValue="3"/>
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_4 }" itemValue="4"/>
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_5 }" itemValue="5"/>
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_6 }" itemValue="6"/>
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_7 }" itemValue="7"/>
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_8 }" itemValue="8"/>
							<f:selectItem itemLabel="#{ms.le_mod_ord_msg_9 }" itemValue="9"/>
						</h:selectOneMenu>
					</t:fieldset>
				</rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="datosle" autosized="true" zindex="2000" width="550">
				<f:facet name="header">
					<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.le_mod_modal_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid columns="3">
						<a4j:commandLink actionListener="#{controlLe.modLe }"
							reRender="panlistaespera"
							onclick="javascript:Richfaces.hideModalPanel('datosle');">
							<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
								width="16px" height="16px"/>
						</a4j:commandLink>		
						<a4j:commandLink actionListener="#{controlLe.borraLe }"
							reRender="panlistaespera"
							onclick="if (!confirm('#{ms.warn_borra}'))return false;javascript:Richfaces.hideModalPanel('datosle');">
							<h:graphicImage style="border: 0px;" value="/img/iconos/borra.png"
								width="16px" height="16px"/>
						</a4j:commandLink>
						<h:graphicImage value="/img/aplicacion/icoCancelar.png"
							style="border:0;cursor:pointer;"
							onclick="javascript:Richfaces.hideModalPanel('datosle')"
							title="#{ms.cerrar }" />
					</h:panelGrid>
				</f:facet>  
				<h:panelGrid id="pandatosle">
					<ui:include src="/ventanas/espera/datosle.jsp" />
				</h:panelGrid>
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
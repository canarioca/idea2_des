<?xml version="1.0" encoding="UTF-8" ?>
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
		<h:form id="formRecalls">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelRecalls">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel style="background-color: #ffffff;
                     background-repeat: no-repeat; background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid width="100%" columnClasses="left" cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.recall_consulta_title }" style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%" columnClasses="centerTop">		
						<h:panelGrid>
							<t:fieldset legend="#{ms.recall_consulta_filtros}">
								<h:panelGrid columns="2">		
									<h:selectBooleanCheckbox value="#{controlRecalls.consultaRangos}">
										<a4j:support event="onclick" reRender="panConsultaNumSerie" ajaxSingle="true"/>
									</h:selectBooleanCheckbox>
									<h:outputLabel value="#{ms.recall_consulta_res_nserie_consulta }"
										title="#{ms.recall_consulta_res_nserie_consulta_title }" />
								</h:panelGrid>
								<h:panelGrid columns="4">
									<h:panelGrid>
										<h:outputLabel value="#{ms.recall_consulta_filtros_tipo_dispositivo }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:selectOneMenu value="#{controlRecalls.filtroTipo}">
											<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
											<f:selectItem itemValue="1" itemLabel="#{ms.recall_consulta_filtros_tipo_op1 }" />
											<f:selectItem itemValue="2" itemLabel="#{ms.recall_consulta_filtros_tipo_op2 }" />
											<f:selectItem itemValue="3" itemLabel="#{ms.recall_consulta_filtros_tipo_op3 }" />										
										</h:selectOneMenu>
										</h:panelGrid>
									</h:panelGrid>
									<h:panelGrid columns="2">
										<h:outputLabel value="#{ms.est_basic_fecha_desde }" style="font-weight: bold;"/>
										<h:outputLabel value="#{ms.est_basic_fecha_hasta }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
												showWeeksBar="false" direction="bottom-left"
												value="#{controlRecalls.fechaini }">
											</rich:calendar>
										</h:panelGrid>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
												showWeeksBar="false" direction="bottom-left"
												value="#{controlRecalls.fechafin }">
											</rich:calendar>
										</h:panelGrid>
									</h:panelGrid>
									<h:panelGrid columns="2">
										<h:outputLabel value="#{ms.imp_dispositivos_gen_modelo }" style="font-weight: bold;"/>
										<h:outputLabel value="#{ms.imp_dispositivos_gen_numserie }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlRecalls.filtroModelo }" />
										</h:panelGrid>
										<h:panelGrid columns="3" style="border-top: solid 1px;border-color: black;" id="panConsultaNumSerie">
											<h:inputText value="#{controlRecalls.filtroNumserie }"/>
											<h:outputLabel value="-" rendered="#{controlRecalls.consultaRangos eq true }"/>
											<h:inputText value="#{controlRecalls.filtroNumSerieFin }" rendered="#{controlRecalls.consultaRangos eq true }"
												title="#{ms.recall_consulta_res_nserie_title }"/>
										</h:panelGrid>
									</h:panelGrid>
									<h:panelGrid columns="2">
										<a4j:commandLink actionListener="#{controlRecalls.consulta}"
											onclick="javascript:Richfaces.showModalPanel('buscando');"
											oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
											style="align:right;" reRender="panelRecalls">
											<h:graphicImage value="/img/iconos/buscar.png" width="24"
												height="24" style="border:0;" title="#{ms.buscar }"/>
										</a4j:commandLink>
										<a4j:commandLink actionListener="#{controlRecalls.limpiar}"
											onclick="javascript:Richfaces.showModalPanel('buscando');"
											oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
											style="align:right;" reRender="panelRecalls">
											<h:graphicImage style="align:right;border:none;"
												styleClass="hvn_enlImagen" id="icoLimpiar" title="#{ms.limpiar }"
												width="24" height="24" url="/img/iconos/limpia.png"/>
										</a4j:commandLink>
									</h:panelGrid>
								</h:panelGrid>
							</t:fieldset>
						</h:panelGrid>
						<h:panelGrid columnClasses="alignLeft" columns="3" id="panResultadosBusquedaRecalls">
							<f:attribute name="align" value="right" />
							<h:outputLabel value="#{ms.pat_consulta_resultados_msg_1 }" style="font-weight: bold" 
								rendered="#{controlRecalls.lista ne null and not empty controlRecalls.lista }"/>
							<h:outputLabel value="#{fn:length(controlRecalls.lista) } #{ms.pat_consulta_resultados_msg_2 }." 
								style="font-weight: bold;color:#E17009" rendered="#{controlRecalls.lista ne null and not empty controlRecalls.lista }"/>
							<t:commandLink actionListener="#{controlRecalls.exportarDatos}" target="_blank" title="#{ms.exportar_excel }"
								rendered="#{controlRecalls.lista ne null and not empty controlRecalls.lista }">
								<h:graphicImage value="/img/iconos/excel_icon.png" width="16" height="16" style="border: 0px;"/>
							</t:commandLink>
						</h:panelGrid>
						<h:panelGrid width="100%">
							<t:dataTable styleClass="hor-minimalist-b" var="rec" rows="15"
								width="100%" value="#{controlRecalls.lista }"
								binding="#{controlRecalls.bindingRecalls }"
								id="listarecalls">
								<t:column headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.recall_consulta_res_modelo }" />
									</f:facet>
									<h:panelGrid>
										<h:outputLabel value="#{rec.modelo }" />
									</h:panelGrid>
								</t:column>
								<t:column headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.recall_consulta_res_nserie }" />
									</f:facet>
									<h:panelGrid>
										<h:outputLabel value="#{rec.numserie }" />
									</h:panelGrid>
								</t:column>
								<t:column headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.recall_consulta_res_fimp }" rendered="#{controlRecalls.filtroTipo ne 2 }"/>
										<h:outputText value="#{ms.recall_consulta_res_fimp_elec }" rendered="#{controlRecalls.filtroTipo eq 2 }"/>
									</f:facet>
									<h:panelGrid>
										<h:outputLabel value="#{rec.fechaimp }">
											<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
										</h:outputLabel>
									</h:panelGrid>
								</t:column>
								<t:column headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.recall_consulta_res_nhc }" />
									</f:facet>
									<h:panelGrid>
										<h:outputLabel value="#{rec.nhc }" />
									</h:panelGrid>
								</t:column>
								<t:column headerstyleClass="left" rendered="#{controlRecalls.filtroTipo eq 2 }">
									<f:facet name="header">
										<h:outputText value="#{ms.imp_dispositivos_ele_estado }" />
									</f:facet>
									<h:panelGrid columns="2">
										<h:selectOneMenu value="#{rec.estadoElec }" disabled="true">
											<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_ele_estado_0 }" />
											<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_ele_estado_1 }" />
											<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_ele_estado_2 }" />
											<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_ele_estado_3 }" />					
										</h:selectOneMenu>
										<h:outputText value="#{ms.imp_dispositivos_ele_estado_caracter_2 }" rendered="#{rec.caracterElec eq 2 }"/>
									</h:panelGrid>
								</t:column>
								<f:facet name="footer">
								<rich:datascroller align="center" for="listarecalls" id="scrollRecalls"
									renderIfSinglePage="true" fastStep="3"
									page="#{controlRecalls.pagina_inicial}">
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
					</h:panelGrid>
					<rich:spacer height="30px"/>				
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
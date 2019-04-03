<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:jsflot="http://www.jsflot.org/taglib/jsflot"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid width="100%">
		<h:panelGrid>
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.integra_reg_logs_ver_title }" style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaListaLogsIntegrador"
					actionListener="#{controlIntegraciones.consultarRegistrosIntegracion }"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage value="/img/iconos/buscar.png" width="16"
						height="16" style="border:0;" title="#{ms.buscar }"/>				
				</a4j:commandLink>
				<a4j:commandLink
					actionListener="#{controlIntegraciones.limpiarRegistrosIntegrador}"
					style="align:right;" reRender="tablaListaLogsIntegrador">
					<h:graphicImage url="/img/iconos/limpia.png" title="#{ms.limpiar }"
						styleClass="hvn_enlImagen" width="16" height="16"
						style="border:none;" />
				</a4j:commandLink>
			</h:panelGrid>
			<t:fieldset legend="Filtros consulta">
				<h:panelGrid columns="4">
					<h:outputLabel value="#{ms.integra_reg_logs_fechaini }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.integra_reg_logs_fechafin }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.integra_reg_logs_sistema }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.integra_reg_logs_estado }" style="font-weight: bold;"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlIntegraciones.regfiltro.fechaini}" />
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlIntegraciones.regfiltro.fechafin}" />
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlIntegraciones.regfiltro.sistema}">
							<f:selectItem itemValue="0" itemLabel="#{ms.sistema_todos }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sistema_sor_pres }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sistema_bio_pres }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sistema_bsc_pres }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.sistema_sjm_pres }" />
							<f:selectItem itemValue="5" itemLabel="#{ms.sistema_med_pres }" />
							<f:selectItem itemValue="6" itemLabel="#{ms.sistema_sor_rem }" />
							<f:selectItem itemValue="7" itemLabel="#{ms.sistema_bio_rem }" />
							<f:selectItem itemValue="8" itemLabel="#{ms.sistema_bsc_rem }" />
							<f:selectItem itemValue="9" itemLabel="#{ms.sistema_sjm_rem }" />
							<f:selectItem itemValue="10" itemLabel="#{ms.sistema_med_rem }" />											
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlIntegraciones.regfiltro.estado}">
							<f:selectItem itemValue="2" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.integra_reg_logs_estado_op11 }" />
							<f:selectItem itemValue="-1" itemLabel="#{ms.integra_reg_logs_estado_op_1 }" />												
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
			</t:fieldset>
		</h:panelGrid>
		<h:panelGrid id="tablaListaLogsIntegrador">
			<t:dataTable styleClass="hor-minimalist-b" var="logseg" rows="15"
				width="100%" value="#{controlIntegraciones.listaregs}"
				binding="#{controlIntegraciones.bindingRegInt }"
				id="listalogsintegrador">
				<t:column width="5%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.integra_reg_logs_fecharx }" />
					</f:facet>
					<h:outputLabel value="#{logseg.fechahorarx }">
						<f:convertDateTime pattern="dd.MM.yyyy HH:mm:ss" timeZone="CET"/>
					</h:outputLabel>
				</t:column>
				<t:column width="15%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.integra_reg_logs_sistema }" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:panelGrid>
							<h:graphicImage value="/img/iconos/Sorin.png"
								rendered="#{logseg.sistema eq 1 or logseg.sistema eq 6}"
								width="28" height="28"
								style="border:none;" title="#{ms.sistema_fab_sor }" />
							<h:graphicImage value="/img/iconos/Biotronik.png"
								rendered="#{logseg.sistema eq 2 or logseg.sistema eq 7 }"
								width="22" height="22"
								style="border:none;" title="#{ms.sistema_fab_bio }" />
							<h:graphicImage value="/img/iconos/Boston.png"
								rendered="#{logseg.sistema eq 3 or logseg.sistema eq 8 }"
								width="25" height="25"
								style="border:none;" title="#{ms.sistema_fab_bsc }" />
							<h:graphicImage value="/img/iconos/St_Jude.png"
								rendered="#{logseg.sistema eq 4 or logseg.sistema eq 9 }"
								width="25" height="25"
								style="border:none;" title="#{ms.sistema_fab_sjm }" />
							<h:graphicImage value="/img/iconos/Medtronic.png"
								rendered="#{logseg.sistema eq 5 or logseg.sistema eq 10 }"
								width="25" height="25"
								style="border:none;" title="#{ms.sistema_fab_med }" />
						</h:panelGrid>								
						<h:selectOneMenu value="#{logseg.sistema }" disabled="true">
							<f:selectItem itemValue="0" itemLabel="#{ms.no_especificado }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sistema_sor_pres }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sistema_bio_pres }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sistema_bsc_pres }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.sistema_sjm_pres }" />
							<f:selectItem itemValue="5" itemLabel="#{ms.sistema_med_pres }" />
							<f:selectItem itemValue="6" itemLabel="#{ms.sistema_sor_rem }" />
							<f:selectItem itemValue="7" itemLabel="#{ms.sistema_bio_rem }" />
							<f:selectItem itemValue="8" itemLabel="#{ms.sistema_bsc_rem }" />
							<f:selectItem itemValue="9" itemLabel="#{ms.sistema_sjm_rem }" />
							<f:selectItem itemValue="10" itemLabel="#{ms.sistema_med_rem }" />													
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column width="5%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.integra_reg_logs_estado }" />									
					</f:facet>									
					<h:graphicImage value="/img/aplicacion/accept.png"
						rendered="#{logseg.estado eq 1}"
						width="16" height="16"
						style="border:none;" title="#{ms.integra_reg_logs_estado_op11_title }" />
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						rendered="#{logseg.estado ne 1}"
						width="16" height="16"
						style="border:none;" title="#{ms.integra_reg_logs_estado_op_1_title }" />									
				</t:column>
				<t:column width="5%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.integra_reg_logs_nfich }" />									
					</f:facet>
					<h:outputText value="#{logseg.nombrefichero }"/>
				</t:column>	
				<t:column width="5%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.integra_reg_logs_coment }" />									
					</f:facet>
					<h:inputTextarea cols="75" rows="1" value="#{logseg.error }" rendered="#{logseg.error ne null}"/>
				</t:column>
			</t:dataTable>
			<rich:datascroller align="center" for="listalogsintegrador" id="sclistalogsintegrador" 
				renderIfSinglePage="true" fastStep="3" page="#{controlIntegraciones.pagina_inicial_regint}">
				<f:facet name="first">
					<h:graphicImage url="/img/genericos/navegacion/first.png"/>
				</f:facet>
				<f:facet name="last">
					<h:graphicImage url="/img/genericos/navegacion/last.png"/>
				</f:facet>
				<f:facet name="fastrewind">
					<h:graphicImage url="/img/genericos/navegacion/frwd.png"/>
				</f:facet>
				<f:facet name="fastforward">
					<h:graphicImage url="/img/genericos/navegacion/ffwd.png"/>
				</f:facet>
				<f:facet name="previous">
					<h:graphicImage url="/img/genericos/navegacion/rwd.png"/>
				</f:facet>
				<f:facet name="next">
					<h:graphicImage url="/img/genericos/navegacion/fwd.png"/>
				</f:facet>
				<f:facet name="first_disabled">
					<h:graphicImage url="/img/genericos/navegacion/first.png"/>
				</f:facet>
				<f:facet name="last_disabled">
					<h:graphicImage url="/img/genericos/navegacion/last.png"/>
				</f:facet>
				<f:facet name="fastrewind_disabled">
					<h:graphicImage url="/img/genericos/navegacion/frwd.png"/>
				</f:facet>
				<f:facet name="fastforward_disabled">
					<h:graphicImage url="/img/genericos/navegacion/ffwd.png"/>
				</f:facet>
				<f:facet name="previous_disabled">
					<h:graphicImage url="/img/genericos/navegacion/rwd.png"/>
				</f:facet>
				<f:facet name="next_disabled">
					<h:graphicImage url="/img/genericos/navegacion/fwd.png"/>
				</f:facet>
			</rich:datascroller>
		</h:panelGrid>
	</h:panelGrid>
	
</ui:composition>
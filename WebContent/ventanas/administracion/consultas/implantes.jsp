<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid width="100%" columnClasses="alignTop" 
		style="height: 500px;
		background-color: #ffffff;
		background-repeat: no-repeat;
		background-position:right bottom;">
		<h:panelGrid width="75%">
			<h:outputLabel value="#{ms.export_datos_tab_imp_filtro_title }" style="color: red;font-size: 14px;font-weight: bold;"/>
			<h:panelGrid width="100%" columns="3"
				columnClasses="alignTop,alignTop,alignTop" cellspacing="0">
				<h:outputLabel value="#{ms.export_datos_fechas_title }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.export_datos_tab_imp_tipo_proc }" style="font-weight: bold;" rendered="true"/>
				<h:outputLabel value="#{ms.export_datos_tab_imp_tipo_disp }" style="font-weight: bold;" rendered="true"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="95%">
					<h:panelGrid columns="4" cellspacing="0">
						<h:outputLabel value="#{ms.export_datos_fecha_desde }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlConsultas.fechaini_imp }">
						</rich:calendar>
						<h:outputLabel value="#{ms.export_datos_fecha_hasta }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlConsultas.fechafin_imp }">
						</rich:calendar>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" rendered="true">
					<h:selectOneMenu value="#{controlConsultas.proc.tipoprocedimiento }">
						<f:selectItem itemLabel="#{ms.proc_todos }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.proc_956}" itemValue="956" />
						<f:selectItem itemLabel="#{ms.proc_993}" itemValue="993" />
						<f:selectItem itemLabel="#{ms.proc_1085}" itemValue="1085" />
						<f:selectItem itemLabel="#{ms.proc_1086}" itemValue="1086" />
						<f:selectItem itemLabel="#{ms.proc_1059}" itemValue="1059" />
						<f:selectItem itemLabel="#{ms.proc_957}" itemValue="957" />
						<f:selectItem itemLabel="#{ms.proc_1060}" itemValue="1060" />
						<f:selectItem itemLabel="#{ms.proc_1147}" itemValue="1147" />
						<f:selectItem itemLabel="#{ms.proc_1090}" itemValue="1090" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" rendered="true">
					<h:selectOneMenu value="#{controlConsultas.tipodispositivo}">
						<f:selectItem itemLabel="#{ms.export_datos_tab_imp_tipo_disp_op0 }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.export_datos_tab_imp_tipo_disp_op1 }" itemValue="1" />
						<f:selectItem itemLabel="#{ms.export_datos_tab_imp_tipo_disp_op2 }" itemValue="2" />
						<f:selectItem itemLabel="#{ms.export_datos_tab_imp_tipo_disp_op3 }" itemValue="3" />
						<f:selectItem itemLabel="#{ms.export_datos_tab_imp_tipo_disp_op4 }" itemValue="4" />
						<f:selectItem itemLabel="#{ms.export_datos_tab_imp_tipo_disp_op5 }" itemValue="5" />
						<f:selectItem itemLabel="#{ms.export_datos_tab_imp_tipo_disp_op6 }" itemValue="6" />
						<f:selectItem itemLabel="#{ms.export_datos_tab_imp_tipo_disp_op7 }" itemValue="7" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="3">
				<h:outputLabel value="#{ms.sc_ecg_ritmo }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.sc_ecg_cav }" style="font-weight: bold;" rendered="true"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs }" style="font-weight: bold;" rendered="true"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" id="ritmosConsulta">
					<h:selectOneMenu value="#{controlConsultas.filtroritmo }">
						<f:selectItems value="#{controlConsultas.ritmos }" />
						<a4j:support event="onchange" ajaxSingle="true" reRender="ritmosConsulta"/>
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" >
					<h:selectOneMenu value="#{controlConsultas.filtrocav }">
						<f:selectItems value="#{controlConsultas.conducciones }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" rendered="true">
					<h:selectOneMenu value="#{controlConsultas.filtroqrs }">
						<f:selectItems value="#{controlConsultas.qrs }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="3">
				<h:outputLabel value="#{ms.export_datos_tab_imp_fab }" style="font-weight: bold;" rendered="true"/>
				<h:outputLabel value="#{ms.export_datos_tab_imp_modelo }" style="font-weight: bold;" rendered="true"/>
				<h:outputLabel value="#{ms.export_datos_tab_imp_modest }" style="font-weight: bold;" rendered="true"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" rendered="true">
					<h:selectOneMenu value="#{controlConsultas.filtrofab }">
						<f:selectItems value="#{controlConsultas.fabricantes }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" rendered="true">
					<h:selectOneMenu value="#{controlConsultas.filtromodelo }">
						<f:selectItems value="#{controlConsultas.generadores }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" rendered="true">
					<h:selectOneMenu value="#{controlConsultas.filtromodo }">
						<f:selectItems value="#{controlConsultas.modogen }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="2">
			<t:commandLink value="#{ms.export_datos_tab_imp_gen_msg }" actionListener="#{controlConsultas.generarEstadisticasImplantes}"
				target="_blank" style="font-size: 14px;font-weight: bold;" title="#{ms.export_datos_generar_consulta }"/>
			<t:commandLink actionListener="#{controlConsultas.generarEstadisticasImplantes}" target="_blank" title="#{ms.export_datos_generar_consulta }">
				<h:graphicImage value="/img/iconos/excel_icon.png" width="32" height="32" style="border: 0px;"/>
			</t:commandLink>
		</h:panelGrid>
		
		
	</h:panelGrid>
</ui:composition>
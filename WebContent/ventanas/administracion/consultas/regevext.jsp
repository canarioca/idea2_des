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
		<h:panelGrid width="50%">
			<h:outputLabel value="#{ms.export_datos_tab_elr_filtro_title }" style="color: red;font-size: 14px;font-weight: bold;"/>
			<h:panelGrid width="100%" 
				columnClasses="alignTop,alignTop" cellspacing="0">
				<h:outputLabel value="#{ms.export_datos_fechas_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:panelGrid columns="4" cellspacing="0">
						<h:outputLabel value="#{ms.export_datos_fecha_desde }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlConsultas.fechaini_regevext }">
						</rich:calendar>
						<h:outputLabel value="#{ms.export_datos_fecha_hasta }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlConsultas.fechafin_regevext }">
						</rich:calendar>
					</h:panelGrid>
				</h:panelGrid>				
			</h:panelGrid>	
			<h:panelGrid>
				<h:outputLabel value="#{ms.elr_tab3_ana_diag_fin }" style="font-weight: bold;" rendered="true"/>				
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" rendered="true">
					<h:selectOneMenu value="#{controlConsultas.filtroregevextdiag}">
					 	<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.elr_tab2_ana_diag_fin_op1 }" itemValue="1" />
						<f:selectItem itemLabel="#{ms.elr_tab2_ana_diag_fin_op2 }" itemValue="2" />
						<f:selectItem itemLabel="#{ms.elr_tab2_ana_diag_fin_op3 }" itemValue="3" />
						<f:selectItem itemLabel="#{ms.elr_tab2_ana_diag_fin_op4 }" itemValue="4" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>		
		</h:panelGrid>
		
		<h:panelGrid columns="2">
			<t:commandLink value="#{ms.export_datos_tab_elr_gen_msg }" actionListener="#{controlConsultas.generaEstadisticasRegEvExt}"
				target="_blank" style="font-size: 14px;font-weight: bold;" title="#{ms.export_datos_generar_consulta }"/>
			<t:commandLink actionListener="#{controlConsultas.generaEstadisticasRegEvExt}" target="_blank" title="#{ms.export_datos_generar_consulta }">
				<h:graphicImage value="/img/iconos/excel_icon.png" width="32" height="32" style="border: 0px;"/>
			</t:commandLink>
		</h:panelGrid>
		
	</h:panelGrid>
</ui:composition>
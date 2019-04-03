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
		background-image:url(/cardioarritmiasMS/img/iconos/filter.png);
		background-repeat: no-repeat;
		background-position:right bottom;">
		<h:panelGrid width="60%">
			<h:outputLabel value="#{ms.export_datos_tab_cve_filtro_title }" style="color: red;font-size: 14px;font-weight: bold;"/>
			<h:panelGrid width="100%" 
				columnClasses="alignTop,alignTop" cellspacing="0">
				<h:outputLabel value="#{ms.export_datos_fechas_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:panelGrid columns="4" cellspacing="0">
						<h:outputLabel value="#{ms.export_datos_fecha_desde }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
								showWeeksBar="false" direction="bottom-left"
								value="#{controlConsultas.fechaini_cv }">
						</rich:calendar>
						<h:outputLabel value="#{ms.export_datos_fecha_hasta }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
								showWeeksBar="false" direction="bottom-left"
								value="#{controlConsultas.fechafin_cv }">
						</rich:calendar>
					</h:panelGrid>
				</h:panelGrid>				
			</h:panelGrid>
			<h:panelGrid width="100%" columns="3"
				columnClasses="alignTop,alignTop,alignTop" cellspacing="0">
				<h:outputLabel value="#{ms.cve_tab1_ind_title }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.cve_tab1_proc_title }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.cve_tab1_cardiop_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.cv.fibrilacion }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemLabel="#{ms.cve_tab1_ind_op1 }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.cve_tab1_ind_op2 }" itemValue="1" />
						<f:selectItem itemLabel="#{ms.cve_tab1_ind_op3 }" itemValue="2" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.cv.idprocedencia }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemLabel="#{ms.cve_tab1_proc_op0 }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.cve_tab1_proc_op1 }" itemValue="1" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.cv.idcardiopatia }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemLabel="#{ms.cve_tab1_cardiop_op0 }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.cve_tab1_cardiop_op1 }" itemValue="1" />
					</h:selectOneMenu>
				</h:panelGrid>
			
				<rich:spacer height="20"/>
				<rich:spacer height="20"/>
				<rich:spacer height="20"/>
			
				<h:outputLabel value="#{ms.cve_tab1_abl_title }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_title }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.cve_tab2_exitofinal_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.cv.idablacion }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemLabel="#{ms.cve_tab1_abl_op0 }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.cve_tab1_abl_op1 }" itemValue="1" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" columns="3">
					<h:panelGrid columns="2" columnClasses="alignMiddle,alignMiddle" cellpadding="0" cellspacing="0">
						<h:selectBooleanCheckbox
							value="#{controlConsultas.cv.avtab}" />
						<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_atk }" />
					</h:panelGrid>
					<h:panelGrid columns="2" columnClasses="alignMiddle,alignMiddle" cellpadding="0" cellspacing="0">
						<h:selectBooleanCheckbox
							value="#{controlConsultas.cv.eteb}" />
						<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_ete }" />
					</h:panelGrid>
					<h:panelGrid columns="2" columnClasses="alignMiddle,alignMiddle" cellpadding="0" cellspacing="0">
						<h:selectBooleanCheckbox
							value="#{controlConsultas.cv.otrosaltab}" />
						<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_otros }" />
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.cv.idexitofinal }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemLabel="#{ms.cve_tab2_exitofinal_op0 }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.cve_tab2_exitofinal_op1 }" itemValue="1" />
					</h:selectOneMenu>
				</h:panelGrid>
			
				<rich:spacer height="20"/>
				<rich:spacer height="20"/>
				<rich:spacer height="20"/>
			
				<h:outputLabel value="#{ms.cve_tab2_complicacion }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.cve_tab1_medhab_title }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.cve_tab2_tipoproc_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.cv.idcomplicacion }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemLabel="#{ms.cve_tab2_complicacion_op0 }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.cve_tab2_complicacion_op1 }" itemValue="1" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:panelGrid columns="8" width="100%"
						columnClasses="alignMiddle,alignMiddle,alignMiddle,alignMiddle">
						<h:selectBooleanCheckbox
							value="#{controlConsultas.cv.amiodb}" />
						<h:outputLabel value="#{ms.cve_tab1_medhab_amiod }" />
						<h:selectBooleanCheckbox
							value="#{controlConsultas.cv.dronedaronab}" />
						<h:outputLabel value="#{ms.cve_tab1_medhab_drone }" />
						<h:selectBooleanCheckbox
							value="#{controlConsultas.cv.sotalolb}" />
						<h:outputLabel value="#{ms.cve_tab1_medhab_sotal }" />
						<h:selectBooleanCheckbox
							value="#{controlConsultas.cv.claseib}" />
						<h:outputLabel value="#{ms.cve_tab1_medhab_clase1 }" />
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%">
					<h:selectOneMenu value="#{controlConsultas.cv.tipoprocedimiento}">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0"/>
						<f:selectItem itemLabel="#{ms.cve_tab2_tipoproc_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.cve_tab2_tipoproc_op2 }" itemValue="2"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="2">
			<t:commandLink value="#{ms.export_datos_tab_cve_gen_msg }" actionListener="#{controlConsultas.generaEstadisticasCv}"
				target="_blank" style="font-size: 14px;font-weight: bold;" title="#{ms.export_datos_generar_consulta }"/>
			<t:commandLink actionListener="#{controlConsultas.generaEstadisticasCv}" target="_blank" title="#{ms.export_datos_generar_consulta }">
				<h:graphicImage value="/img/iconos/excel_icon.png" width="32" height="32" style="border: 0px;"/>
			</t:commandLink>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
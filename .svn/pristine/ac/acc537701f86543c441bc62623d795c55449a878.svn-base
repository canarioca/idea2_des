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
		<h:panelGrid width="50%">
			<h:outputLabel value="#{ms.export_datos_tab_eef_filtro_title }" style="color: red;font-size: 14px;font-weight: bold;"/>
			<h:panelGrid width="100%" 
				columnClasses="alignTop,alignTop" cellspacing="0">
				<h:outputLabel value="#{ms.export_datos_fechas_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:panelGrid columns="4" cellspacing="0">
						<h:outputLabel value="#{ms.export_datos_fecha_desde }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
								showWeeksBar="false" direction="bottom-left"
								value="#{controlConsultas.fechaini_eef }">
						</rich:calendar>
						<h:outputLabel value="#{ms.export_datos_fecha_hasta }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
								showWeeksBar="false" direction="bottom-left"
								value="#{controlConsultas.fechafin_eef }">
						</rich:calendar>
					</h:panelGrid>
				</h:panelGrid>				
			</h:panelGrid>
			<h:panelGrid width="100%" columns="2"
				columnClasses="alignTop,alignTop" cellspacing="0">
				<h:outputLabel value="#{ms.export_datos_tab_cve_filtro_edad }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.export_datos_tab_cve_filtro_sexo }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:panelGrid columns="5" cellspacing="0">
						<h:outputLabel value="#{ms.export_datos_tab_cve_filtro_edad_mayor_de } "/>
						<h:inputText size="4" value="#{controlConsultas.eef.edadmin }"/>
						<h:outputLabel value=" #{ms.export_datos_tab_cve_filtro_edad_menor_de } "/>
						<h:inputText size="4" value="#{controlConsultas.eef.edadmax }"/>
						<h:outputLabel value=" #{ms.export_datos_tab_cve_filtro_edad_anios }."/>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.eef.idpaciente }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemLabel="#{ms.export_datos_tab_cve_filtro_sexo_hom }" itemValue="1" />
						<f:selectItem itemLabel="#{ms.export_datos_tab_cve_filtro_sexo_muj }" itemValue="2" />
					</h:selectOneMenu>
				</h:panelGrid>
	
				<rich:spacer height="20px"/>
				<rich:spacer height="20px"/>
			
				<h:outputLabel value="#{ms.eef_tab_plantilla_diagn }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.eef_tab_recmat_nav }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.eef.diagnostico }">
						<f:selectItems value="#{controlEef.diagnosticos }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.eef.navegador }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemValue="0" itemLabel="#{ms.export_datos_tab_eef_filtro_nav_no }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.export_datos_tab_eef_filtro_nav_carto }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.export_datos_tab_eef_filtro_nav_navx }" />
					</h:selectOneMenu>
				</h:panelGrid>
				
				<rich:spacer height="20px"/>
				<rich:spacer height="20px"/>
				
				<h:outputLabel value="#{ms.eef_tab_plantilla_tipo_proc }" style="font-weight: bold;" rendered="false"/>
				<h:outputLabel value="#{ms.eef_tab_rechum_pop }" style="font-weight: bold;" rendered="false"/>
				<h:outputLabel value="" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" rendered="false">
					<h:selectOneMenu value="#{controlConsultas.eef.tipoProcedimiento }">
						<f:selectItems value="#{controlEef.tipoProcedimientos }"  />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" rendered="false">
					<h:selectOneMenu value="#{controlConsultas.eef.anestesista }">
						<f:selectItems value="#{controlEef.primerOperador }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid width="80%">
					
				</h:panelGrid>
			</h:panelGrid>
			
			<rich:spacer height="20px"/>

			<a4j:jsFunction name="actualiza" reRender="panfil"/>
			<h:panelGrid id="panfil">
				<h:selectOneRadio style="color: red;font-size: 14px;font-weight: bold;"
					onclick="actualiza();" value="#{controlConsultas.eef.escopia }">
					<f:selectItem itemLabel="#{ms.export_datos_tab_eef_filtro_todos }" itemValue="0"/>
					<f:selectItem itemLabel="#{ms.export_datos_tab_eef_filtro_sin_abl }" itemValue="-1"/>
					<f:selectItem itemLabel="#{ms.export_datos_tab_eef_filtro_con_intent_abl }" itemValue="1"/>
					<f:selectItem itemLabel="#{ms.export_datos_tab_eef_filtro_con_abl }" itemValue="2"/>
					<a4j:support event="onchange" reRender="panfil" ajaxSingle="true"/>
				</h:selectOneRadio>
				<h:outputLabel value="· #{ms.export_datos_tab_eef_filtro_con_intent_abl }" style="color: red;font-size: 14px;font-weight: bold;"
					rendered="#{controlConsultas.eef.escopia eq 1}"/>
				<h:panelGrid width="100%" columns="1" columnClasses="alignTop" cellspacing="0"
					rendered="#{controlConsultas.eef.escopia eq 1}">
					<h:outputLabel value="#{ms.export_datos_tab_eef_filtro_con_intent_abl_mot }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
						<h:selectOneMenu value="#{controlConsultas.intento.idnivel1 }">
							<f:selectItems value="#{controlConsultas.eef.intentodto.intento }" />
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				
				<h:outputLabel value="· #{ms.export_datos_tab_eef_filtro_con_abl }" style="color: red;font-size: 14px;font-weight: bold;"
					rendered="#{controlConsultas.eef.escopia eq 2}"/>
				<h:panelGrid width="100%" columns="2" id="filtroabla"
					columnClasses="alignTop,alignTop,alignTop" cellspacing="0"
					rendered="#{controlConsultas.eef.escopia eq 2}">
					<h:outputLabel value="#{ms.eef_tab_abl_tab_abl_sust_abordado }" style="font-weight: bold;" />
					<h:outputLabel value="#{ms.eef_tab_abl_tab_res }" style="font-weight: bold;" />
					<h:outputLabel value="#{ms.eef_tab_compdiag }" style="font-weight: bold;" rendered="false"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
						<h:selectOneMenu value="#{controlConsultas.ablacion.idnodo }">
							<f:selectItem itemLabel="#{ms.eef_abl_sust_0 }" itemValue="-1"/>
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
					<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
						<h:selectOneMenu value="#{controlConsultas.ablacion.resultadodto.idres}">
							<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op2 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op3 }" itemValue="3" />
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%" columns="2" rendered="false">
						<h:selectOneMenu value="#{controlConsultas.ablacion.complicacion.idlugar}"
							onchange="actualiza();">
							<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
							<f:selectItem itemLabel="#{ms.export_datos_tab_eef_filtro_con_abl_compl_no }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.export_datos_tab_eef_filtro_con_abl_compl_si }" itemValue="2" />
						</h:selectOneMenu>
						<h:selectOneMenu value="#{controlConsultas.ablacion.complicacion.idcomplicacion }"
							rendered="#{controlConsultas.ablacion.complicacion.idlugar eq 2 }">
							<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op1 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op2 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op3 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op4 }" itemValue="4" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op5 }" itemValue="5" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op6 }" itemValue="6" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op7 }" itemValue="7" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op8 }" itemValue="8" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op9 }" itemValue="9" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op10 }" itemValue="10" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op11 }" itemValue="11" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op12 }" itemValue="12" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_menores_op3 }" itemValue="13" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_menores_op1 }" itemValue="14" />
							<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_menores_op2 }" itemValue="15" />
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="2">
			<t:commandLink value="#{ms.export_datos_tab_eef_gen_msg }" actionListener="#{controlConsultas.generaEstadisticasEef}"
				target="_blank" style="font-size: 14px;font-weight: bold;" title="#{ms.export_datos_generar_consulta }"/>
			<t:commandLink actionListener="#{controlConsultas.generaEstadisticasEef}" target="_blank" title="#{ms.export_datos_generar_consulta }">
				<h:graphicImage value="/img/iconos/excel_icon.png" width="32" height="32" style="border: 0px;"/>
			</t:commandLink>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
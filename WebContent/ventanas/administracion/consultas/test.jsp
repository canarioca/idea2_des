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
		<h:panelGrid>
			<h:panelGrid width="100%" 
				columnClasses="alignTop,alignTop" cellspacing="0">
				<h:outputLabel value="#{ms.export_datos_fechas_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:panelGrid columns="4" cellspacing="0">
						<h:outputLabel value="#{ms.export_datos_fecha_desde }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
								showWeeksBar="false" direction="bottom-left"
								value="#{controlConsultas.fechaini_test }">
						</rich:calendar>
						<h:outputLabel value="#{ms.export_datos_fecha_hasta }"/>
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
								showWeeksBar="false" direction="bottom-left"
								value="#{controlConsultas.fechafin_test }">
						</rich:calendar>
					</h:panelGrid>
				</h:panelGrid>				
			</h:panelGrid>
			<h:outputLabel value="#{ms.export_datos_tab_test_atp_filtro_title }" style="color: red;font-size: 14px;font-weight: bold;"/>
			<h:panelGrid width="100%" columns="4"
				columnClasses="alignTop50,alignTop50,alignTop50,alignTop50" cellspacing="0">
				<h:outputLabel value="#{ms.testfarma_ind_motivo_clin }"
					style="font-weight: bold;" />
				<h:outputLabel value="#{ms.testfarma_ind_motivo_ecg }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.testfarma_tab_res_title }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.testfarma_tab_compl_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testAtp.clinico }">
						<f:selectItems value="#{controlTest.atpclinico }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testAtp.ecg }">
						<f:selectItems value="#{controlTest.atpecg }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testAtp.dosis1 }">
						<f:selectItems value="#{controlTest.atpdosis }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testAtp.complica }">
						<f:selectItems value="#{controlTest.atpcomplica }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			
			<rich:spacer height="20"/>
	
			<h:outputLabel value="#{ms.export_datos_tab_test_epi_filtro_title }" style="color: red;font-size: 14px;font-weight: bold;"/>		
			<h:panelGrid width="100%" columns="4"
				columnClasses="alignTop50,alignTop50,alignTop50,alignTop50" cellspacing="0">
				<h:outputLabel value="#{ms.testfarma_ind_motivo_clin }"
					style="font-weight: bold;" />
				<h:outputLabel value="#{ms.testfarma_ind_motivo_ecg }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.testfarma_tab_res_title }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.testfarma_tab_compl_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testEpi.clinico }">
						<f:selectItems value="#{controlTest.epiclinico }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testEpi.ecg }">
						<f:selectItems value="#{controlTest.epiecg }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testEpi.dosis1 }">
						<f:selectItems value="#{controlTest.epires }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testEpi.complica }">
						<f:selectItems value="#{controlTest.epicomplica }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			
			<rich:spacer height="20"/>
		
			<h:outputLabel value="#{ms.export_datos_tab_test_fle_filtro_title }" style="color: red;font-size: 14px;font-weight: bold;"/>	
			<h:panelGrid width="100%" columns="4"
				columnClasses="alignTop50,alignTop50,alignTop50,alignTop50" cellspacing="0">
				<h:outputLabel value="#{ms.testfarma_ind_motivo_clin }"
					style="font-weight: bold;" />
				<h:outputLabel value="#{ms.testfarma_ind_motivo_ecg }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.testfarma_tab_res_title }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.testfarma_tab_compl_title }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testFle.clinico }">
						<f:selectItems value="#{controlTest.fleclinico }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testFle.ecg }">
						<f:selectItems value="#{controlTest.fleecg }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testFle.resultado }">
						<f:selectItems value="#{controlTest.fleres }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
					<h:selectOneMenu value="#{controlConsultas.testFle.complica }">
						<f:selectItems value="#{controlTest.epicomplica }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid columns="2">
			<t:commandLink value="#{ms.export_datos_tab_test_gen_msg }" actionListener="#{controlConsultas.generaEstadisticasTest}"
				target="_blank" style="font-size: 14px;font-weight: bold;" title="#{ms.export_datos_generar_consulta }"/>
			<t:commandLink actionListener="#{controlConsultas.generaEstadisticasTest}" target="_blank" title="#{ms.export_datos_generar_consulta }">
				<h:graphicImage value="/img/iconos/excel_icon.png" width="32" height="32" style="border: 0px;"/>
			</t:commandLink>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
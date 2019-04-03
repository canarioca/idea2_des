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
		<h:form id="formExportacion">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelExportacion">

				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                 	 *background-image:url(/idea/img/iconos/estadistica.png);
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.expor_reg_title }" style="color: white;" />
							<h:panelGrid columns="4" columnClasses="right">
								<t:commandLink style="text-align: right;" 
									actionListener="#{controlExportacion.exportaRegistrosAnuales }"
									target="_blank" rendered="false">
									<h:graphicImage url="/img/iconos/application_xml.png" style="border:0px;"
										title="Exportar registros a XML" width="24" height="24"/>
								</t:commandLink>							
								<a4j:commandLink title="Enviar registro" actionListener="#{controlExportacion.enviaDatosExportados}"
									rendered="false">
									<h:graphicImage value="/img/iconos/forward-mail.png" width="24"
										height="24" style="border:0;" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<h:panelGrid columns="3">
						<h:panelGrid>
							<h:outputText value="#{ms.export_reg_msg_1 }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlExportacion.registro }">
									<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.export_reg_op2 }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.export_reg_op1 }" />
									<a4j:support event="onchange" reRender="panExpFormato" ajaxSingle="true"/>																								
								</h:selectOneMenu>
							</h:panelGrid>				
						</h:panelGrid>
						<h:panelGrid cellpadding="0" cellspacing="0" id="panExpAnio">
							<h:outputText value="#{ms.export_reg_msg_2 }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<rich:inputNumberSpinner cycled="true" enableManualInput="false" inputSize="5" minValue="2000" 
									maxValue="3000"  step="1" value="#{controlExportacion.anio }"/>
							</h:panelGrid>	
						</h:panelGrid>											
						<h:panelGrid id="panExpFormato">
							<h:panelGrid columns="32">
								<t:commandLink style="text-align: right;" rendered="#{controlExportacion.registro ne 0 }"
									actionListener="#{controlExportacion.exportaRegistrosAnuales }"
									target="_blank">
									<h:graphicImage url="/img/iconos/application_xml.png" style="border:0px;"
										title="#{ms.export_reg_msg_3 }" width="24" height="24"/>
								</t:commandLink>
								<h:commandLink actionListener="#{controlExportacion.exportaRegistrosAnualesPDF}" action="recarga"
									target="_blank" rendered="#{controlExportacion.registro ne 0 }">
									<h:graphicImage value="/img/iconos/pdf.png" width="22" height="22"
										style="border:none;" title="#{ms.export_reg_msg_4 }" />
								</h:commandLink>
								<t:commandLink actionListener="#{controlExportacion.exportaRegistroNacionalDai}" target="_blank" title="#{ms.exportar_excel }"
									rendered="#{controlExportacion.registro eq 1 }">
									<h:graphicImage value="/img/iconos/excel_icon.png" width="16" height="16" style="border: 0px;"/>
								</t:commandLink>
							</h:panelGrid>
						</h:panelGrid>					
					</h:panelGrid>
					<rich:spacer height="30px"/>				
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
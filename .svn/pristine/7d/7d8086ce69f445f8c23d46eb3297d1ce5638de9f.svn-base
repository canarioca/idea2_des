<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="inicio">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<style>
.alignRight {
	text-align: right;
}

.estiloFondo {
	background-color: #ffffff;
	background-image: url(/idea/img/iconos/formulario.png);
	background-repeat: no-repeat;
	background-position: right bottom;
}
</style>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panAn">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<a4j:jsFunction name="recargaDatos"
					actionListener="#{controlEstadisticas.recargaAnual }"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
					reRender="panAn" />	
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panelAnual">
							<h:outputLabel value="#{ms.abl_anual_title }"
								style="color: white;" />
							<h:panelGrid columns="6">
								<h:outputLabel value="#{ms.abl_anual_anio }" style="color: white;" />
								<rich:inputNumberSpinner cycled="true" enableManualInput="false"
									inputSize="5" minValue="2000" ondownclick="recargaDatos();javascript:Richfaces.showModalPanel('buscando');"
									onupclick="recargaDatos();javascript:Richfaces.showModalPanel('buscando');"
									maxValue="#{controlEstadisticas.maxanio }"
									value="#{controlEstadisticas.anual.anio }" />
								<a4j:commandLink
									actionListener="#{controlEstadisticas.limpiaMensual}"
									style="align:right;" reRender="panelAnual">
									<h:graphicImage url="/img/iconos/limpia.png" title="#{ms.limpiar }"
										styleClass="hvn_enlImagen" width="24" height="24"
										style="border:none;" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panEef"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlEstadisticas.guardaAnual }">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<t:commandLink title="#{ms.imprimir }" target="_blank"
									actionListener="#{controlEstadisticas.imprimeAnual}">
									<h:graphicImage value="/img/iconos/informe_especial.png" width="22"
										height="22" style="border:0;" />
								</t:commandLink>
								<t:commandLink title="#{ms.abl_anual_gen_excel }" target="_blank" 
									actionListener="#{controlEstadisticas.imprimeAnualExcel}">
									<h:graphicImage value="/img/iconos/excel_icon.png" width="22"
										 height="22" style="border: 0px;"/>
								</t:commandLink>
								<a4j:commandLink title="#{ms.abl_anual_enviar_inf }" actionListener="#{controlEstadisticas.enviaInformeAnual}"
									rendered="false">
									<h:graphicImage value="/img/iconos/forward-mail.png" width="24"
										height="24" style="border:0;" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<rich:tabPanel switchType="client">
						<rich:tab label="#{ms.abl_anual_tab_datos }">
							<a4j:include viewId="/ventanas/administracion/anual/centro.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.abl_anual_tab_lab }">
							<a4j:include viewId="/ventanas/administracion/anual/lab.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.abl_anual_tab_tec }">
							<a4j:include viewId="/ventanas/administracion/anual/tecnicas.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.abl_anual_tab_abls }">
							<rich:tabPanel contentClass="estiloFondo" switchType="client">
								<rich:tab label="#{ms.abl_anual_tab_abls_tin }">
									<a4j:include viewId="/ventanas/administracion/anual/tin.jsp" />
								</rich:tab>
								<rich:tab label="#{ms.abl_anual_tab_abls_vacc }">
									<a4j:include viewId="/ventanas/administracion/anual/vaav.jsp" />
								</rich:tab>
								<rich:tab label="#{ms.abl_anual_tab_abls_cav }">
									<a4j:include viewId="/ventanas/administracion/anual/cav.jsp" />
								</rich:tab>
								<rich:tab label="#{ms.abl_anual_tab_abls_taf }">
									<a4j:include viewId="/ventanas/administracion/anual/taf.jsp" />
								</rich:tab>
								<rich:tab label="#{ms.abl_anual_tab_abls_ict }">
									<a4j:include viewId="/ventanas/administracion/anual/ict.jsp" />
								</rich:tab>
								<rich:tab label="#{ms.abl_anual_tab_abls_fta }">
									<a4j:include viewId="/ventanas/administracion/anual/fta.jsp" />
								</rich:tab>
								<rich:tab label="#{ms.abl_anual_tab_abls_fa }">
									<a4j:include viewId="/ventanas/administracion/anual/fa.jsp" />
								</rich:tab>
								<rich:tab label="#{ms.abl_anual_tab_abls_tvi }">
									<a4j:include viewId="/ventanas/administracion/anual/tvi.jsp" />
								</rich:tab>
								<rich:tab label="#{ms.abl_anual_tab_abls_tvm }">
									<a4j:include viewId="/ventanas/administracion/anual/tvmcp.jsp" />
								</rich:tab>
								<rich:tab label="#{ms.abl_anual_tab_abls_tvn }">
									<a4j:include viewId="/ventanas/administracion/anual/tvncp.jsp" />
								</rich:tab>
							</rich:tabPanel>
						</rich:tab>
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
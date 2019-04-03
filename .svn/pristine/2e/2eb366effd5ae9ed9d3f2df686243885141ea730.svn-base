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
		<h:form id="formMaterial">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelMaterial">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.mat_title }" style="color: white;" />
							<h:panelGrid rendered="false">
								<a4j:commandLink
									actionListener="#{controlMaterial.limpiarFormulario}"
									style="align:right;" reRender="panelMaterialGenerador,panelMaterialElectrodo,panelMaterialCateter,panelMaterialRegEv">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" id="icoLimpiar" title="Limpiar"
										width="24" height="24" url="/img/iconos/limpia.png"/>
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="90%" columnClasses="centerTop">		
						<rich:tabPanel contentClass="estiloFondo" switchType="client" id="tabmaterial">						
							<rich:tab label="#{ms.mat_tab_gen_title }" rendered="#{loginForm.accmods.implante eq 1 and true}">
								<h:panelGrid id="matgen" width="100%">
									<a4j:include viewId="/ventanas/administracion/material/generador.jsp" />
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.mat_tab_ele_title }" rendered="#{loginForm.accmods.implante eq 1 and true}">
								<h:panelGrid id="matelec" width="100%">
									<a4j:include viewId="/ventanas/administracion/material/electrodo.jsp" />
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.mat_tab_cat_title }" rendered="#{loginForm.accmods.eef eq 1 }">
								<h:panelGrid id="matcat" width="100%">
									<a4j:include viewId="/ventanas/administracion/material/cateter.jsp" />
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.mat_tab_regev_title }" rendered="#{loginForm.accmods.registrador eq 1 }">
								<h:panelGrid id="matreg" width="100%">
									<a4j:include viewId="/ventanas/administracion/material/regeventos.jsp" />
								</h:panelGrid>
							</rich:tab>
						</rich:tabPanel>
					</h:panelGrid>
					<rich:spacer height="30px"/>				
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
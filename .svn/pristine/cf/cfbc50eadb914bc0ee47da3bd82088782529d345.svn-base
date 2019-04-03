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
		<h:form id="estadisticasbasicas">
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel>
					<f:facet name="header">
						<h:panelGrid width="100%" cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.est_basic_title }" style="color: white;" />
						</h:panelGrid>
					</f:facet>
					<h:outputText value="#{ms.est_basic_info }"/>
					<rich:tabPanel switchType="client" width="100%" height="500px">
						<rich:tab label="#{ms.est_basic_tab_gen_title }">
							<a4j:include viewId="estadisticas/general.jsp" id="estGenTab"/>
						</rich:tab>
						<rich:tab label="#{ms.est_basic_tab_eef_title }" rendered="#{loginForm.accmods.eef eq 1 }">
							<a4j:include viewId="estadisticas/eef.jsp" id="estEefTab"/>
						</rich:tab>
						<rich:tab label="#{ms.est_basic_tab_imp_title }" rendered="#{loginForm.accmods.implante eq 1 }">
							<a4j:include viewId="estadisticas/implantes.jsp" id="estImpTab"/>
						</rich:tab>
						<rich:tab label="#{ms.est_basic_tab_cve_title }" rendered="#{loginForm.accmods.cv eq 1 }">
							<a4j:include viewId="estadisticas/cv.jsp" id="estCvTab"/>
						</rich:tab>
						<rich:tab label="#{ms.est_basic_tab_mesa_title }" rendered="#{loginForm.accmods.mesa eq 1 }">
							<a4j:include viewId="estadisticas/mesabasculante.jsp" id="estMesaTab"/>
						</rich:tab>
						<rich:tab label="#{ms.est_basic_tab_test_title }" rendered="#{loginForm.accmods.test eq 1 }">
							<a4j:include viewId="estadisticas/test.jsp" id="estTestTab"/>
						</rich:tab>
						<rich:tab label="#{ms.est_basic_tab_regev_title }" rendered="#{loginForm.accmods.registrador eq 1 }">
							<a4j:include viewId="estadisticas/registrador.jsp" id="estRegTab"/>
						</rich:tab>
						<rich:tab label="#{ms.est_basic_tab_hol24_title }" rendered="#{loginForm.accmods.holter eq 1 }">
							<a4j:include viewId="estadisticas/holter.jsp" id="estHolterTab"/>
						</rich:tab>
						<rich:tab label="#{ms.est_basic_tab_elr_title }" rendered="#{loginForm.accmods.elr eq 1 }">
							<a4j:include viewId="estadisticas/regevext.jsp" id="estRegEvExtTab"/>
						</rich:tab>
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
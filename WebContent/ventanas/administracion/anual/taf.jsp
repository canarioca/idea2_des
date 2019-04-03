<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		<h:outputLabel value="#{ms.abl_anual_tab_abls_taf_title }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_npatproc_total }" style="font-weight: bold;" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo1 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo2 }" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_npatproc_exito }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo3 }" />
			<h:outputLabel value="#{ms.abl_anual_tab_abls_taf_proc_adai }" style="font-weight: bold;" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo22 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo23 }" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_taf_proc_adai_exito }" style="font-weight: bold;" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo24 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo25 }" />
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est }" style="font-weight: bold;" />
		<h:panelGrid columns="3">
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_4mm }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo35 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_8mm }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo4 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_irri_est }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo5 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_crio }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo4 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_irri_cont }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo36 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_otro }" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo7 }" />
				<h:outputLabel value="/" />
				<h:inputText size="30" maxlength="40" value="#{controlEstadisticas.anual.taf.campo8 }" />
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="#{ms.abl_anual_tab_abls_compl }" style="font-weight: bold;" />
		<h:panelGrid columns="3">
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_bav_mp }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo9 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_vascular }" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo10 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo11 }" />
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_derrame }" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo12 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo13 }" />
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_embolismo }" />
			<h:panelGrid columns="5" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo14 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo15 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo16 }" />
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_iam }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo17 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_icc }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo18 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_otra }" />
			<h:inputText size="30" maxlength="40" value="#{controlEstadisticas.anual.taf.campo19 }" />
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_muerte }" style="font-weight: bold;" />
			<h:panelGrid columns="4" cellpadding="0" cellspacing="0">
				<h:inputText size="20" maxlength="20" value="#{controlEstadisticas.anual.taf.campo20 }" />
				<rich:spacer width="20px"/>
				<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_merte_compprev }" />
				<h:inputText size="20" maxlength="20" value="#{controlEstadisticas.anual.taf.campo21 }" />
			</h:panelGrid>		
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_casos_ped }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo37 }" />
			<h:outputLabel value="#{ms.abl_anual_tab_abls_casos_nav }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo38 }" />
			<h:outputLabel value="#{ms.abl_anual_tab_abls_casos_fluo }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.taf.campo39 }" />
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_comentarios }" style="font-weight: bold;" />
			<h:inputTextarea cols="120" rows="2" value="#{controlEstadisticas.anual.taf.campo34 }" />
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
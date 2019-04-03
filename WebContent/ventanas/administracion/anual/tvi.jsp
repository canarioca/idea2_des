<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		<h:outputLabel value="#{ms.abl_anual_tab_abls_tvi_title }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_npatproc_total }" style="font-weight: bold;" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo1 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo2 }" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_tvi_procs }" style="font-weight: bold;" />
			<h:panelGrid columns="13" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo22 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo30 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo23 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo31 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo24 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo32 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo25 }" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_tvi_procs_exito }" style="font-weight: bold;" />
			<h:panelGrid columns="13" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo26 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo33 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo27 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo40 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo28 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo41 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo29 }" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_npatproc_exito }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo3 }" />
		</h:panelGrid>
		<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est }" style="font-weight: bold;" />
		<h:panelGrid columns="3">
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_4mm }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo35 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_8mm }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo4 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_irri_est }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo5 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_crio }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo6 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_irri_cont }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo36 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_otro }" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo7 }" />
				<h:outputLabel value="/" />
				<h:inputText size="30" maxlength="40" value="#{controlEstadisticas.anual.tvi.campo8 }" />
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="#{ms.abl_anual_tab_abls_compl }" style="font-weight: bold;" />
		<h:panelGrid columns="3">
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_bav_mp }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo9 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_vascular }" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo10 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo11 }" />
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_derrame }" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo12 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo13 }" />
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_embolismo }" />
			<h:panelGrid columns="5" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo14 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo15 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo16 }" />
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_iam }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo17 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_icc }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo18 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_otra }" />
			<h:inputText size="30" maxlength="40" value="#{controlEstadisticas.anual.tvi.campo19 }" />
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_muerte }" style="font-weight: bold;" />
			<h:panelGrid columns="4" cellpadding="0" cellspacing="0">
				<h:inputText size="20" maxlength="20" value="#{controlEstadisticas.anual.tvi.campo20 }" />
				<rich:spacer width="20px"/>
				<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_merte_compprev }" />
				<h:inputText size="20" maxlength="20" value="#{controlEstadisticas.anual.tvi.campo21 }" />
			</h:panelGrid>			
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_casos_ped }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo37 }" />
			<h:outputLabel value="#{ms.abl_anual_tab_abls_casos_nav }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo38 }" />
			<h:outputLabel value="#{ms.abl_anual_tab_abls_casos_fluo }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.tvi.campo39 }" />
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_comentarios }" style="font-weight: bold;" />
			<h:inputTextarea cols="120" rows="2" value="#{controlEstadisticas.anual.tvi.campo34 }" />
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
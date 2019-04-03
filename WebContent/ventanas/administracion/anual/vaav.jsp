<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		<h:outputLabel value="#{ms.abl_anual_tab_abls_vacc_title }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_npatproc_total }" style="font-weight: bold;" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo1 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo2 }" />
			</h:panelGrid>			
			<h:outputLabel value="#{ms.abl_anual_tab_abls_npatproc_exito }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo3 }" />
			<h:outputLabel value="#{ms.abl_anual_tab_abls_vacc_tipos }" style="font-weight: bold;" />
			<h:panelGrid columns="7" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo33 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo31 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo32 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo30 }" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_vacc_tratadas_loc }" style="font-weight: bold;" />
			<h:panelGrid columns="8" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo22 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo23 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo24 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo25 }" />
				<h:outputLabel value="#{ms.abl_anual_tab_abls_vacc_tratadas_loc_msg }" style="font-style: italic;" />
			</h:panelGrid>			
			<h:outputLabel value="#{ms.abl_anual_tab_abls_vacc_tratadas_loc_exito }" style="font-weight: bold;" />
			<h:panelGrid columns="8" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo26 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo27 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo28 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo29 }" />
				<h:outputLabel value="#{ms.abl_anual_tab_abls_vacc_tratadas_loc_msg }" style="font-style: italic;" />
			</h:panelGrid>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_vacc_accceso_vi }" style="font-weight: bold;" />
			<h:panelGrid columns="6" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo40 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo41 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo42 }" />
				<h:outputLabel value="#{ms.abl_anual_tab_abls_vacc_accceso_vi_msg }" style="font-style: italic;" />
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est }" style="font-weight: bold;" />
		<h:panelGrid columns="3">
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_4mm }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo35 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_8mm }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo4 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_irri_est }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo5 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_crio }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo6 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_irri_cont }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo36 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_cateter_no_est_otro }" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo7 }" />
				<h:outputLabel value="/" />
				<h:inputText size="30" maxlength="40" value="#{controlEstadisticas.anual.vacc.campo8 }" />
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="#{ms.abl_anual_tab_abls_compl }" style="font-weight: bold;" />
		<h:panelGrid columns="3">
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_bav_mp }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo9 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_vascular }" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo10 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo11 }" />
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_derrame }" />
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo12 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo13 }" />
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_embolismo }" />
			<h:panelGrid columns="5" cellpadding="0" cellspacing="0">
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo14 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo15 }" />
				<h:outputLabel value="/" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo16 }" />
			</h:panelGrid>
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_iam }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo17 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_icc }" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo18 }" />
			<rich:spacer width="20px"/>
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_otra }" />
			<h:inputText size="30" maxlength="40" value="#{controlEstadisticas.anual.vacc.campo19 }" />
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_muerte }" style="font-weight: bold;" />
			<h:panelGrid columns="4" cellpadding="0" cellspacing="0">
				<h:inputText size="20" maxlength="20" value="#{controlEstadisticas.anual.vacc.campo20 }" />
				<rich:spacer width="20px"/>
				<h:outputLabel value="#{ms.abl_anual_tab_abls_compl_merte_compprev }" />
				<h:inputText size="20" maxlength="20" value="#{controlEstadisticas.anual.vacc.campo21 }" />
			</h:panelGrid>			
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_casos_ped }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo37 }" />
			<h:outputLabel value="#{ms.abl_anual_tab_abls_casos_nav }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo38 }" />
			<h:outputLabel value="#{ms.abl_anual_tab_abls_casos_fluo }" style="font-weight: bold;" />
			<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.vacc.campo39 }" />
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.abl_anual_tab_abls_comentarios }" style="font-weight: bold;" />
			<h:inputTextarea cols="120" rows="2" value="#{controlEstadisticas.anual.vacc.campo34 }" />
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
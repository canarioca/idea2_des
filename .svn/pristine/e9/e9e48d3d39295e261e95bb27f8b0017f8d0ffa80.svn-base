<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" styleClass="estiloFondo">
		<h:panelGrid width="100%">
			<h:outputLabel value="#{ms.abl_anual_tab_lab_title }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
				<h:outputLabel value="#{ms.abl_anual_tab_lab_nmed_title }" style="font-weight: bold;" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.plantilla }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_nmed_tcomp }" style="font-weight: bold;" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.plantillatc }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_nmed_nbec }" style="font-weight: bold;" />
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.becarios }" />
					<h:outputLabel value="#{ms.abl_anual_tab_lab_nmed_nbec_msg }"
						style="font-style: italic;" />
				</h:panelGrid>
				<h:outputLabel value="#{ms.abl_anual_tab_lab_nmed_mir }" style="font-weight: bold;" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.mir }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_nats }" style="font-weight: bold;" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.ats }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_natr }" style="font-weight: bold;" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.atr }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_anest }" style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.lab.ane }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
				</h:selectOneRadio>
			</h:panelGrid>
			<h:outputLabel
				value="#{ms.abl_anual_tab_lab_msg_1 }"
				style="font-style: italic;" />
			<h:outputLabel
				value="#{ms.abl_anual_tab_lab_msg_2 }"
				style="font-style: italic;" />
			<h:outputLabel
				value="#{ms.abl_anual_tab_lab_msg_3 }"
				style="font-style: italic;" />
		</h:panelGrid>

		<rich:spacer height="10" />

		<h:panelGrid width="100%">
			<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_title }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="2">
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_tipo }"
					style="font-weight: bold;" />
				<h:panelGrid columns="4" cellpadding="0" cellspacing="0">
					<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_tipo_conv }" />
					<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.salac }" />
					<h:outputLabel value="/#{ms.abl_anual_tab_lab_datos_tipo_dig }" />
					<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.salad }" />
				</h:panelGrid>
				<h:outputLabel
					value="#{ms.abl_anual_tab_lab_datos_escopia }"
					style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.lab.idportatil }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
				</h:selectOneRadio>
				<h:outputLabel
					value="#{ms.abl_anual_tab_lab_datos_sala_excl }"
					style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.lab.idexclusiva }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_sala_nsalas }"
					style="font-weight: bold;" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.exclusivas }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_nrxs_fijo }"
					style="font-weight: bold;" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.nrxfijo }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_nrxs_port }"
					style="font-weight: bold;" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.nrxportatil }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_ndias_abls }"
					style="font-weight: bold;" />
				<h:inputText size="6" maxlength="4" value="#{controlEstadisticas.anual.lab.dias }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_imp_mps }"
					style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.lab.idmp }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_imp_dai }"
					style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.lab.iddai }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_imp_crt }"
					style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.lab.idcrt }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_imp_hol }"
					style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.lab.idholter }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_cve }"
					style="font-weight: bold;" />
				<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_cve_externa }" />
						<h:selectOneRadio value="#{controlEstadisticas.anual.lab.idcvexterna }">
							<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
							<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
						</h:selectOneRadio>
					</h:panelGrid>
					<rich:spacer width="20px" />
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_cve_interna }" />
						<h:selectOneRadio value="#{controlEstadisticas.anual.lab.idcvinterna }">
							<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
							<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_denerv }"
					style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.lab.iddenren }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
				</h:selectOneRadio>
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_cierre_orej }"
					style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.lab.idcieore }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
				</h:selectOneRadio>
				<h:outputLabel
					value="#{ms.abl_anual_tab_lab_datos_otros }"
					style="font-weight: bold;" />
				<h:inputTextarea cols="60" rows="2" value="#{controlEstadisticas.anual.lab.procedimientos }" />
				<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_poli_dig }"
					style="font-weight: bold;" />
				<h:panelGrid columns="4" cellpadding="0" cellspacing="0">
					<h:selectOneRadio value="#{controlEstadisticas.anual.lab.idpoligrafo }">
						<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }" />
						<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }" />
					</h:selectOneRadio>
					<rich:spacer width="20px" />
					<h:outputLabel value="#{ms.abl_anual_tab_lab_datos_poli_dig_marca }" />
					<h:inputText size="30" maxlength="40" value="#{controlEstadisticas.anual.lab.poligrafo }" />
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
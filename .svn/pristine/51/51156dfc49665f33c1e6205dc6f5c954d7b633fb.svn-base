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
			<h:outputLabel value="#{ms.abl_anual_tab_datos_title }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
				<h:outputLabel value="#{ms.abl_anual_tab_datos_hosp }" style="font-weight: bold;" />
				<h:inputText size="70" maxlength="70" value="#{controlEstadisticas.anual.centro.hospital }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_cod_centro }" style="font-weight: bold;" />
				<h:inputText size="10" maxlength="8" value="#{controlEstadisticas.anual.centro.codcentro }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_direccion }" style="font-weight: bold;" />
				<h:inputText size="70" maxlength="120" value="#{controlEstadisticas.anual.centro.direccion }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_poblacion }" style="font-weight: bold;" />
				<h:inputText size="70" maxlength="120" value="#{controlEstadisticas.anual.centro.poblacion }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_prov }" style="font-weight: bold;" />
				<h:inputText size="30" maxlength="30" value="#{controlEstadisticas.anual.centro.provincia }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_cp }" style="font-weight: bold;" />
				<h:inputText size="8" maxlength="5" value="#{controlEstadisticas.anual.centro.cp }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_ca }" style="font-weight: bold;" />
				<h:inputText size="30" maxlength="30" value="#{controlEstadisticas.anual.centro.comunidad }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_tfno }" style="font-weight: bold;" />
				<h:inputText size="12" maxlength="9" value="#{controlEstadisticas.anual.centro.telefono }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_tfno_ext }" style="font-weight: bold;" />
				<h:inputText size="12" maxlength="9" value="#{controlEstadisticas.anual.centro.ext }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_fax }" style="font-weight: bold;" />
				<h:inputText size="12" maxlength="9" value="#{controlEstadisticas.anual.centro.fax }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_med_resp }" style="font-weight: bold;" />
				<h:inputText size="100" maxlength="100" value="#{controlEstadisticas.anual.centro.responsable }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_tfno_movil }" style="font-weight: bold;" />
				<h:inputText size="12" maxlength="9" value="#{controlEstadisticas.anual.centro.telcontacto }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_email }" style="font-weight: bold;" />
				<h:inputText size="70" maxlength="120" value="#{controlEstadisticas.anual.centro.emailcontacto }" />
				<h:outputLabel value="#{ms.abl_anual_tab_datos_nivel_hosp }" style="font-weight: bold;" />
				<h:selectOneMenu value="#{controlEstadisticas.anual.centro.idtipohospi1 }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_tab_datos_nivel_hosp_1 }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.abl_anual_tab_datos_nivel_hosp_2 }"/>
					<f:selectItem itemValue="4" itemLabel="#{ms.abl_anual_tab_datos_nivel_hosp_4 }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.abl_anual_tab_datos_nivel_hosp_3 }"/>
					<f:selectItem itemValue="5" itemLabel="#{ms.abl_anual_tab_datos_nivel_hosp_5 }"/>
				</h:selectOneMenu>
				<h:outputLabel value="" style="font-weight: bold;" />
				<h:selectOneMenu value="#{controlEstadisticas.anual.centro.idtipohospi2 }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_tab_datos_publ }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.abl_anual_tab_datos_priv }"/>
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.abl_anual_tab_datos_serv }" style="font-weight: bold;" />
				<h:selectOneMenu value="#{controlEstadisticas.anual.centro.idservicio }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_tab_datos_serv_cardio }"/>
					<f:selectItem itemValue="2" itemLabel="#{ms.abl_anual_tab_datos_serv_intens }"/>
					<f:selectItem itemValue="3" itemLabel="#{ms.abl_anual_tab_datos_serv_otro }"/>
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.abl_anual_tab_datos_cirugia }" style="font-weight: bold;" />
				<h:selectOneRadio value="#{controlEstadisticas.anual.centro.idcirugia }">
					<f:selectItem itemValue="1" itemLabel="#{ms.abl_anual_si }"/>
					<f:selectItem itemValue="0" itemLabel="#{ms.abl_anual_no }"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">


	<h:panelGrid columns="2" columnClasses="alignTop,alignTop" width="100%"
		cellspacing="0" cellpadding="0" id="panlocal">
		<a4j:jsFunction name="updloc" reRender="panloc" />
		<h:panelGrid columns="2" style="text-align: right;">
			<f:attribute name="align" value="right" />
			<h:graphicImage url="/img/aplicacion/icoCancelar.png"
				style="cursor:pointer"
				onclick="javascript:Richfaces.hideModalPanel('localizaciones');" />
			<a4j:commandLink actionListener="#{controlEef.eef.guardaLoc }"
				oncomplete="javascript:Richfaces.hideModalPanel('localizaciones');">
				<h:graphicImage url="/img/aplicacion/accept.png"
					style="cursor:pointer;border:0px;" />
			</a4j:commandLink>
		</h:panelGrid>
		<h:panelGrid cellspacing="0" cellpadding="0">
			<h:outputLabel value="#{ms.eef_tab_vacc_loc }" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneRadio onclick="updloc();" layout="pageDirection"
					value="#{controlEef.eef.localizacion.tmpInteger2 }"
					immediate="true">
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_vacc_loc_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_vacc_loc_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_vacc_loc_op3 }" />
					<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_vacc_loc_op4 }" />
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>

		<h:panelGrid cellspacing="0" cellpadding="0" id="panloc">
			<h:panelGrid cellspacing="0" cellpadding="0"
				rendered="#{controlEef.eef.localizacion.tmpInteger2 eq 1 }">
				<h:outputLabel value="#{ms.eef_tab_vacc_loc_op1_sel }"
					style="font-weight: bold;" />
				<h:selectManyListbox size="3"
					value="#{controlEef.eef.localizacion.tmpArray }">
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_vacc_loc_op1_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_vacc_loc_op1_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_vacc_loc_op1_op3 }" />
				</h:selectManyListbox>
				<h:outputLabel value="#{ms.eef_tab_vacc_loc_sel_varias }"
					style="font-size: 9px;font-style: italic;" />
			</h:panelGrid>

			<h:panelGrid cellspacing="0" cellpadding="0"
				rendered="#{controlEef.eef.localizacion.tmpInteger2 eq 2 }">
				<h:outputLabel value="#{ms.eef_tab_vacc_loc_op2_sel }"
					style="font-weight: bold;" />
				<h:selectManyListbox size="3"
					value="#{controlEef.eef.localizacion.tmpArray }">
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_vacc_loc_op2_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_vacc_loc_op2_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_vacc_loc_op2_op3 }" />
				</h:selectManyListbox>
				<h:outputLabel value="#{ms.eef_tab_vacc_loc_sel_varias }"
					style="font-size: 9px;font-style: italic;" />
			</h:panelGrid>

			<h:panelGrid cellspacing="0" cellpadding="0"
				rendered="#{controlEef.eef.localizacion.tmpInteger2 eq 3 }">
				<h:outputLabel value="#{ms.eef_tab_vacc_loc_op3_sel }" style="font-weight: bold;" />
				<h:selectOneListbox size="5"
					value="#{controlEef.eef.localizacion.tmpString1 }">
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_vacc_loc_op3_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_vacc_loc_op3_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_vacc_loc_op3_op3 }" />
					<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_vacc_loc_op3_op4 }" />
					<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_vacc_loc_op3_op5 }" />
				</h:selectOneListbox>
			</h:panelGrid>

			<h:panelGrid cellspacing="0" cellpadding="0"
				rendered="#{controlEef.eef.localizacion.tmpInteger2 eq 4 }">
				<h:outputLabel value="#{ms.eef_tab_vacc_loc_op4_sel }"
					style="font-weight: bold;" />
				<h:selectOneListbox size="2"
					value="#{controlEef.eef.localizacion.tmpString1 }">
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_vacc_loc_op4_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_vacc_loc_op4_op2 }" />
				</h:selectOneListbox>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
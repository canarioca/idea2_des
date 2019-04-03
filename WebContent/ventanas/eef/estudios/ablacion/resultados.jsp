<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid id="panres" width="70%">
		<a4j:jsFunction name="updateres" reRender="panres" />
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop"
			width="100%">
			<h:selectOneRadio layout="pageDirection"
				value="#{controlEef.eef.ablaciondto.resultadodto.idres }" onclick="updateres();">
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1 }" itemValue="1" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op2 }" itemValue="2" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op3 }" itemValue="3" />
			</h:selectOneRadio>

			<h:panelGrid rendered="#{controlEef.eef.ablaciondto.resultadodto.idres eq 1}">
				<h:outputLabel value="Éxito" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;" cellspacing="0">
					<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idnodo }" disabled="true">
						<f:selectItem itemLabel="#{ms.eef_abl_sust_1 }" itemValue="1" />
						<f:selectItem itemLabel="#{ms.eef_abl_sust_2 }" itemValue="2" />
						<f:selectItem itemLabel="#{ms.eef_abl_sust_3 }" itemValue="3" />
						<f:selectItem itemLabel="#{ms.eef_abl_sust_4 }" itemValue="4" />
						<f:selectItem itemLabel="#{ms.eef_abl_sust_5 }" itemValue="5" />
						<f:selectItem itemLabel="#{ms.eef_abl_sust_6 }" itemValue="6" />
						<f:selectItem itemLabel="#{ms.eef_abl_sust_7 }" itemValue="7" />
						<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_tvfocal }" itemValue="8" />
						<f:selectItem itemLabel="#{ms.eef_abl_sust_9 }" itemValue="9" />
					</h:selectOneMenu>

					<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
						rendered="#{controlEef.eef.ablaciondto.idnodo eq 1}">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.resultadodto.idtin}">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_1_1 }" itemValue="1" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_1_2 }" itemValue="2" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_1_3 }" itemValue="3" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
						rendered="#{controlEef.eef.ablaciondto.idnodo eq 2}">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.resultadodto.idtin}">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_2_1 }" itemValue="1" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_2_2 }" itemValue="2" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
						rendered="#{controlEef.eef.ablaciondto.idnodo eq 3}">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.resultadodto.idtin}">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_3_1 }" itemValue="1" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_3_2 }" itemValue="2" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
						rendered="#{controlEef.eef.ablaciondto.idnodo eq 4}">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.resultadodto.idtin}">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_4_1 }" itemValue="1" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
						rendered="#{controlEef.eef.ablaciondto.idnodo eq 5}">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.resultadodto.idtin}">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_5_1 }" itemValue="1" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_5_2 }" itemValue="2" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_5_3 }" itemValue="3" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_5_4 }" itemValue="4" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
						rendered="#{controlEef.eef.ablaciondto.idnodo eq 6}">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.resultadodto.idtin}">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_6_1 }" itemValue="1" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_6_2 }" itemValue="2" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_6_3 }" itemValue="3" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
						rendered="#{controlEef.eef.ablaciondto.idnodo eq 7}">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.resultadodto.idtin}">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_7_1 }" itemValue="1" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_7_2 }" itemValue="2" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
						rendered="#{controlEef.eef.ablaciondto.idnodo eq 8}">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.resultadodto.idtin}">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_8_1 }" itemValue="1" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
						rendered="#{controlEef.eef.ablaciondto.idnodo eq 9}">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<rich:spacer width="10px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.resultadodto.idtin}">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op1_9_1 }" itemValue="1" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid rendered="#{controlEef.eef.ablaciondto.resultadodto.idres eq 3}">
				<h:outputLabel value="#{ms.eef_tab_abl_tab_res_op3 }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneRadio layout="pageDirection" value="#{controlEef.eef.ablaciondto.resultadodto.idparcial}">
						<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op3_op1 }" itemValue="1" />
						<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op3_op2 }" itemValue="2" />
						<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op3_op3 }" itemValue="3" />
						<f:selectItem itemLabel="#{ms.eef_tab_abl_tab_res_op3_op4 }" itemValue="4" />
					</h:selectOneRadio>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
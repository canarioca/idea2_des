<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" id="panComplicacionesEefDiag">
		<a4j:include viewId="/ventanas/eef/estudios/complicaciones/complicacion.jsp" />
	</h:panelGrid>
	<h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.eef_tab_compdiag_muerte }"/>
			<h:selectOneRadio value="#{controlEef.eef.complicacionesdto.idprocedimienton4}">
				<f:selectItem itemLabel="#{ms.eef_tab_compdiag_muerte_op1 }" itemValue="1"/>
				<f:selectItem itemLabel="#{ms.eef_tab_compdiag_muerte_op0 }" itemValue="0"/>
			</h:selectOneRadio>
		</h:panelGrid>
		<h:outputLabel value="#{ms.eef_tab_compdiag_com }" />
		<h:inputTextarea cols="100" rows="4" value="#{controlEef.eef.complicacionesdto.comentarios }" />
	</h:panelGrid>

	<h:panelGrid width="70%" cellspacing="0" id="pancomplica2" rendered="false">
		<h:outputLabel value="#{ms.eef_tab_compdiag_tipo }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;">
			<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimiento }">
				<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
				<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_compdiag_tipo_op1 }" />
				<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_compdiag_tipo_op2 }" />
				<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_compdiag_tipo_op3 }" />
				<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_compdiag_tipo_op4 }" />
				<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_compdiag_tipo_op5 }" />
				<f:selectItem itemValue="6" itemLabel="#{ms.eef_tab_compdiag_tipo_op6 }" />
				<f:selectItem itemValue="7" itemLabel="#{ms.eef_tab_compdiag_tipo_op7 }" />
				<f:selectItem itemValue="8" itemLabel="#{ms.eef_tab_compdiag_tipo_op8 }" />
				<a4j:support event="onchange" reRender="pancomplica22,pancomplica222" ajaxSingle="true"/>
			</h:selectOneMenu>
			<h:panelGrid columns="2">
				<rich:spacer width="15px"/>
				<h:panelGrid id="pancomplica22">
					<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton2 }"
						rendered="#{controlEef.eef.complicacionesdto.idprocedimiento eq 1 }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_compdiag_tipo_op1_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_compdiag_tipo_op1_op2 }" />
						<a4j:support event="onchange" reRender="pancomplica222" ajaxSingle="true"/>
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton2 }"
						rendered="#{controlEef.eef.complicacionesdto.idprocedimiento eq 2 }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_compdiag_tipo_op2_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_compdiag_tipo_op2_op2 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_compdiag_tipo_op2_op3 }" />
						<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_compdiag_tipo_op2_op4 }" />
						<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_compdiag_tipo_op2_op5 }" />
						<f:selectItem itemValue="6" itemLabel="#{ms.eef_tab_compdiag_tipo_op2_op6 }" />
						<f:selectItem itemValue="7" itemLabel="#{ms.eef_tab_compdiag_tipo_op2_op7 }" />
						<a4j:support event="onchange" reRender="pancomplica222" ajaxSingle="true"/>
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton2 }"
						rendered="#{controlEef.eef.complicacionesdto.idprocedimiento eq 3 }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_compdiag_tipo_op3_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_compdiag_tipo_op3_op2 }" />
						<a4j:support event="onchange" reRender="pancomplica222" ajaxSingle="true"/>
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton2 }"
						rendered="#{controlEef.eef.complicacionesdto.idprocedimiento eq 4 }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_compdiag_tipo_op4_op1 }" />
						<a4j:support event="onchange" reRender="pancomplica222" ajaxSingle="true"/>
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton2 }"
						rendered="#{controlEef.eef.complicacionesdto.idprocedimiento eq 5 }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_compdiag_tipo_op5_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_compdiag_tipo_op5_op2 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_compdiag_tipo_op5_op3 }" />
						<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_compdiag_tipo_op5_op4 }" />
						<a4j:support event="onchange" reRender="pancomplica222" ajaxSingle="true"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<rich:spacer width="30px"/>
				<h:panelGrid id="pancomplica222">
					<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton3 }" 
						rendered="#{controlEef.eef.complicacionesdto.idprocedimiento eq 1 and controlEef.eef.complicacionesdto.idprocedimienton2 eq 2 }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_compdiag_tipo_op1_op2_op1 }" />
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton3 }" 
						rendered="#{controlEef.eef.complicacionesdto.idprocedimiento eq 3 and controlEef.eef.complicacionesdto.idprocedimienton2 eq 2 }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_compdiag_tipo_op3_op2_op1 }" />
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton3 }" 
						rendered="#{controlEef.eef.complicacionesdto.idprocedimiento eq 5 and controlEef.eef.complicacionesdto.idprocedimienton2 eq 4 }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_compdiag_tipo_op5_op4_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_compdiag_tipo_op5_op4_op2 }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.eef_tab_compdiag_muerte }"/>
				<h:selectOneRadio value="#{controlEef.eef.complicacionesdto.idprocedimienton4}">
					<f:selectItem itemLabel="#{ms.eef_tab_compdiag_muerte_op1 }" itemValue="1"/>
					<f:selectItem itemLabel="#{ms.eef_tab_compdiag_muerte_op0 }" itemValue="0"/>
				</h:selectOneRadio>
			</h:panelGrid>
			<h:outputLabel value="#{ms.eef_tab_compdiag_com }" />
			<h:inputTextarea cols="100" rows="4"
				value="#{controlEef.eef.complicacionesdto.comentarios }" />
		</h:panelGrid>
	</h:panelGrid>

	<h:panelGrid width="70%" cellspacing="0" id="pancomplica" rendered="false">
		<a4j:jsFunction name="updatecomp" reRender="pancomplica" />
		<h:outputLabel value="#{ms.eef_tab_compdiag_tipo }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;">
			<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimiento }" 
				onchange="updatecomp();">
				<f:selectItems value="#{controlEef.eef.complicacionesdto.tipoComplicaciones }" />
			</h:selectOneMenu>
			<h:panelGrid columns="2">
				<rich:spacer width="15px"/>
				<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton2 }" 
					onchange="updatecomp();" rendered="#{controlEef.eef.complicacionesdto.tipoComplicacionesN2 ne null}">
					<f:selectItems value="#{controlEef.eef.complicacionesdto.tipoComplicacionesN2 }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<rich:spacer width="30px"/>
				<h:selectOneMenu value="#{controlEef.eef.complicacionesdto.idprocedimienton3 }" 
					rendered="#{controlEef.eef.complicacionesdto.tipoComplicacionesN3 ne null}">
					<f:selectItems value="#{controlEef.eef.complicacionesdto.tipoComplicacionesN3 }" />
				</h:selectOneMenu>
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.eef_tab_compdiag_muerte }"/>
				<h:selectOneRadio value="#{controlEef.eef.complicacionesdto.idprocedimienton4}">
					<f:selectItem itemLabel="#{ms.eef_tab_compdiag_muerte_op1 }" itemValue="1"/>
					<f:selectItem itemLabel="#{ms.eef_tab_compdiag_muerte_op0 }" itemValue="0"/>
				</h:selectOneRadio>
			</h:panelGrid>
			<h:outputLabel value="#{ms.eef_tab_compdiag_com }" />
			<h:inputTextarea cols="100" rows="4"
				value="#{controlEef.eef.complicacionesdto.comentarios }" />
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>

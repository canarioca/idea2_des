<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid id="panintentoN" cellpadding="0" cellspacing="0">
		<h:panelGrid columns="1">
			<a4j:jsFunction name="updateint" reRender="panintentoN" />
			<h:selectOneMenu value="#{controlEef.eef.intentodto.idnivel1 }" onchange="updateint();">
				<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
				<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_intabl_op1 }" />
				<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_intabl_op2 }" />
				<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_intabl_op3 }" />
				<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_intabl_op4 }" />
				<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_intabl_op5 }" />
			</h:selectOneMenu>
			<h:panelGrid columns="2" rendered="#{controlEef.eef.intentodto.intentoN2 ne null}">
				<rich:spacer width="15px"/>
				<h:selectOneMenu value="#{controlEef.eef.intentodto.idnivel2 }" onchange="updateint();"
					rendered="#{controlEef.eef.intentodto.idnivel1 eq 5 }">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_intabl_op5_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_intabl_op5_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_intabl_op5_op3 }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" rendered="#{controlEef.eef.intentodto.intentoN3 ne null}">
				<rich:spacer width="15px"/>
				<h:selectOneMenu value="#{controlEef.eef.intentodto.idnivel3 }" onchange="updateint();"
					rendered="#{controlEef.eef.intentodto.idnivel2 eq 1 }">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_intabl_op5_op1_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_intabl_op5_op1_op2 }" />
				</h:selectOneMenu>
				<h:selectOneMenu value="#{controlEef.eef.intentodto.idnivel3 }" onchange="updateint();"
					rendered="#{controlEef.eef.intentodto.idnivel2 eq 2 }">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_intabl_op5_op2_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_intabl_op5_op2_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_intabl_op5_op2_op3 }" />
					<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_intabl_op5_op2_op4 }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" rendered="#{controlEef.eef.intentodto.idnivel1 eq 5 and controlEef.eef.intentodto.idnivel2 eq 3}">
				<rich:spacer width="30px" />
				<h:inputTextarea rows="3" cols="150" value="#{controlEef.eef.intentodto.otros }" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>

	<h:panelGrid id="panintento" cellpadding="0" cellspacing="0" rendered="false">
		<h:panelGrid columns="1">
			<a4j:jsFunction name="updateint" reRender="panintento"/>
			<h:selectOneMenu value="#{controlEef.eef.intentodto.idnivel1 }"
				onchange="updateint();">
				<f:selectItems value="#{controlEef.eef.intentodto.intento }" />
			</h:selectOneMenu>
			<h:panelGrid columns="2" rendered="#{controlEef.eef.intentodto.intentoN2 ne null}">
				<rich:spacer width="15px"/>
				<h:selectOneMenu value="#{controlEef.eef.intentodto.idnivel2 }"
					onchange="updateint();">
					<f:selectItems value="#{controlEef.eef.intentodto.intentoN2 }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" rendered="#{controlEef.eef.intentodto.intentoN3 ne null}">
				<rich:spacer width="30px"/>
				<h:selectOneMenu value="#{controlEef.eef.intentodto.idnivel3 }">
					<f:selectItems value="#{controlEef.eef.intentodto.intentoN3 }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" rendered="#{controlEef.eef.intentodto.idnivel1 eq 5 &amp;&amp; controlEef.eef.intentodto.idnivel2 eq 3}">
				<rich:spacer width="30px" />
				<h:inputTextarea rows="3" cols="150"
					 value="#{controlEef.eef.intentodto.otros }" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
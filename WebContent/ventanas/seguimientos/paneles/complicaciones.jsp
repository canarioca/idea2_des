<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="80%">
		<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
			<h:outputLabel value="#{ms.seg_disp_compl }" style="font-weight: bold;" />
			<a4j:commandLink reRender="tablaCompSeg"
				actionListener="#{controlSeguimientos.addComplicaciones }">
				<h:graphicImage value="/img/iconos/add.png" width="16"
					height="16" style="border:0;" title="#{ms.compl_add }"/>				
			</a4j:commandLink>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaCompSeg" width="100%">
			<t:dataTable styleClass="hor-minimalist-b" var="lineacomp"
				width="100%" value="#{controlSeguimientos.listacomplicaciones }"
				binding="#{controlSeguimientos.bindingComplicaciones }">
				<t:column width="30%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.compl_tipo }" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:selectOneMenu value="#{lineacomp.tipocomp }">
							<f:selectItems value="#{controlSeguimientos.tipocomplicacion}" />
							<a4j:support event="onchange" reRender="tablaCompSeg" ajaxSingle="true"
								actionListener="#{controlSeguimientos.controlCompTipo }"/>						
						</h:selectOneMenu>					
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.compl_clase }" />
					</f:facet>
					<h:panelGrid columns="2">								
						<h:selectOneMenu value="#{lineacomp.idcomp}" rendered="#{lineacomp.tipocomp eq '1088'}">
							<f:selectItems value="#{controlSeguimientos.lcompsegtec }" />
							<a4j:support event="onchange" reRender="tablaCompSeg" ajaxSingle="true"
								actionListener="#{controlSeguimientos.controlComp}"/>						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{lineacomp.idcomp}" rendered="#{lineacomp.tipocomp eq '1086'}">
							<f:selectItems value="#{controlSeguimientos.lcompsegarr }" />		
							<a4j:support event="onchange" reRender="tablaCompSeg" ajaxSingle="true"
								actionListener="#{controlSeguimientos.controlComp}"/>				
						</h:selectOneMenu>
						<h:selectOneMenu value="#{lineacomp.idcomp}" rendered="#{lineacomp.tipocomp eq '1087'}">
							<f:selectItems value="#{controlSeguimientos.lcompsegproc }" />	
							<a4j:support event="onchange" reRender="tablaCompSeg" ajaxSingle="true"
								actionListener="#{controlSeguimientos.controlComp}"/>					
						</h:selectOneMenu>
						<h:selectOneMenu value="#{lineacomp.idcomp}" rendered="#{lineacomp.tipocomp eq '1089'}">
							<f:selectItems value="#{controlSeguimientos.lcompsegresp }" />	
							<a4j:support event="onchange" reRender="tablaCompSeg" ajaxSingle="true"
								actionListener="#{controlSeguimientos.controlComp}"/>					
						</h:selectOneMenu>
						<h:selectOneMenu value="#{lineacomp.idcomp}" rendered="#{lineacomp.tipocomp eq '1090'}">
							<f:selectItems value="#{controlSeguimientos.lcompsegmuerte }" />		
							<a4j:support event="onchange" reRender="tablaCompSeg" ajaxSingle="true"
								actionListener="#{controlSeguimientos.controlComp}"/>				
						</h:selectOneMenu>
						<h:inputText value="#{lineacomp.otra}" size="15" rendered="#{lineacomp.tipocomp eq '1091'}"/>
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.compl_actitud }" />
					</f:facet>
					<h:panelGrid columns="2">												
						<h:inputTextarea cols="25" rows="4" value="#{lineacomp.actitud }"/>
					</h:panelGrid>					
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.compl_resultado }" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:selectOneMenu value="#{lineacomp.resultado }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.compl_resultado_pos }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.compl_resultado_neg }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.compl_resultado_reint }" />													
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaCompSeg"
						actionListener="#{controlSeguimientos.delComplicaciones }">
						<h:graphicImage url="/img/iconos/minus.png"
							title="#{ms.compl_del }" width="16" height="16"
							style="border: 0px;" />
					</a4j:commandLink>
				</t:column>
			</t:dataTable>
		</h:panelGrid>
	</h:panelGrid>

</ui:composition>
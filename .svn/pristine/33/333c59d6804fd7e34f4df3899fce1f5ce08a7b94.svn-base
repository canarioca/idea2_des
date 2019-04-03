<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox">
	
	<h:panelGrid columns="4" width="100%"
			columnClasses="alignTop33,alignTop33,alignTop33,alignTop33">
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.eef_tab_rechum_enf }" style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaEnf"
					actionListener="#{controlEef.addEnf }">
					<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
						style="border:0;" title="#{ms.eef_tab_rechum_enf_add }" />
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.eef_tab_rechum_pop }" style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaEquipo"
					actionListener="#{controlEef.addPop }">
					<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
						style="border:0;" title="#{ms.eef_tab_rechum_pop_add }" />
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.eef_tab_rechum_sop }" style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaOp2"
					actionListener="#{controlEef.addSop }">
					<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
						style="border:0;" title="#{ms.eef_tab_rechum_sop_add }" />
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.eef_tab_rechum_ane }" style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaAnestesista"
					actionListener="#{controlEef.addAnest }">
					<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
						style="border:0;" title="#{ms.eef_tab_rechum_ane_add }" />
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaEnf" width="50%">
				<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
					value="#{controlEef.eef.enfermeras }"
					binding="#{controlEef.binenf }">
					<t:column width="90%" headerstyleClass="left">
						<h:outputLabel value="#{linea.idenfermera }"/>
						<h:selectOneMenu value="#{linea.idenfermera }" rendered="#{linea.lectura eq 0 }"
							style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
							<f:selectItems value="#{controlEef.enfermeras }" />
								<a4j:support event="onchange" reRender="tablaEnf" ajaxSingle="true"
									actionListener="#{controlEef.controlEnf }"/>							
						</h:selectOneMenu>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaEnf" actionListener="#{controlEef.delEnf }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eef_tab_rechum_enf_del }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaEnf" actionListener="#{controlEef.editEnf }" >
							<h:graphicImage url="/img/iconos/editar.png"
								title="#{ms.editar }" width="16" height="16" style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaEquipo" width="50%">
				<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
					value="#{controlEef.eef.poperador }" binding="#{controlEef.binpop }">
					<t:column width="90%" headerstyleClass="left">
						<h:outputLabel value="#{linea.idoperador }"/>
						<h:selectOneMenu value="#{linea.idoperador }" rendered="#{linea.lectura eq 0 }"
							style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
							<f:selectItems value="#{controlEef.primerOperador }" />
								<a4j:support event="onchange" reRender="tablaEquipo" ajaxSingle="true"
									actionListener="#{controlEef.controlPop }"/>
						</h:selectOneMenu>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaEquipo"
							actionListener="#{controlEef.delPop }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eef_tab_rechum_pop_del }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaEquipo" actionListener="#{controlEef.editPop }" >
							<h:graphicImage url="/img/iconos/editar.png"
								title="#{ms.editar }" width="16" height="16" style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaOp2" width="50%">
				<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
					value="#{controlEef.eef.soperador }" binding="#{controlEef.binsop }">
					<t:column width="90%" headerstyleClass="left">
						<h:outputLabel value="#{linea.idoperador }"/>
						<h:selectOneMenu value="#{linea.idoperador }" rendered="#{linea.lectura eq 0 }"
							style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
							<f:selectItems value="#{controlEef.segundoOperador }" />
								<a4j:support event="onchange" reRender="tablaOp2" ajaxSingle="true"
									actionListener="#{controlEef.controlSop }"/>
						</h:selectOneMenu>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaOp2"
							actionListener="#{controlEef.delSop }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eef_tab_rechum_sop_del }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaOp2" actionListener="#{controlEef.editSop }" >
							<h:graphicImage url="/img/iconos/editar.png"
								title="#{ms.editar }" width="16" height="16" style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaAnestesista" width="65%">
				<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
					value="#{controlEef.eef.anest }" binding="#{controlEef.binanest }">
					<t:column width="90%" headerstyleClass="left">
						<h:outputLabel value="#{linea.idanestesista }"/>
						<h:selectOneMenu value="#{linea.idanestesista }" rendered="#{linea.lectura eq 0 }"
							style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
							<f:selectItems value="#{controlEef.anestesista }" />
								<a4j:support event="onchange" reRender="tablaAnestesista" ajaxSingle="true"
									actionListener="#{controlEef.controlAnest }"/>
						</h:selectOneMenu>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaAnestesista"
							actionListener="#{controlEef.delAnest }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eef_tab_rechum_ane_del }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaAnestesista" actionListener="#{controlEef.editAnest }" >
							<h:graphicImage url="/img/iconos/editar.png"
								title="#{ms.editar }" width="16" height="16" style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
		</h:panelGrid>
	
	
</ui:composition>
<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="formUsuarios">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelMaestras">

				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                 	 background-image:url(/jwpedidos/img/iconos/wizard-magic.png);
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.maestras_title }"
								style="color: white;" />
						</h:panelGrid>
					</f:facet>

					<h:panelGrid id="GestionDatos" width="100%">
						<h:outputLabel
							value="#{ms.maestras_msg_1 }"
							style="color: red;font-size: 12px;" />
						<h:panelGrid columns="1">
							<h:outputText value="#{ms.maestras_mod_msg_1 }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								columns="1">
								<h:selectOneMenu id="tseccion"
									value="#{controlMaestras.seccionSelect}"
									style="border-color: #C4C0B9;">
									<f:selectItems value="#{controlMaestras.listaSecciones}" />
									<a4j:support event="onchange" actionListener="#{controlMaestras.seleccionaSeccion }"
										reRender="GestionDatos" />
								</h:selectOneMenu>
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid columns="1" id="tcampo">
							<h:outputText value="#{ms.maestras_mod_msg_2 }"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								columns="1">
								<h:selectOneMenu id="tdato"
									value="#{controlMaestras.tablaSelect}"
									style="border-color: #C4C0B9;">
									<f:selectItems value="#{controlMaestras.listaTablas}" />
									<a4j:support event="onchange"
										actionListener="#{controlMaestras.buscaDatos}"
										reRender="GestionDatos" />
								</h:selectOneMenu>
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid columns="2" id="panelDescripcion" 
							rendered="#{controlMaestras.tablaSelect > 0}">
							<h:panelGrid columns="1" id="descripcion">
								<h:outputText value="#{ms.maestras_mod_msg_3 }"
									style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="1">
									<h:inputText size="60" styleClass="estiloInput"
										value="#{controlMaestras.datoSelect.valor}"
										style="font-size:12px;" />
								</h:panelGrid>
							</h:panelGrid>

							<h:panelGrid columns="3" id="panelOpciones"
								style="margin-top: 20px;">
								<a4j:commandLink actionListener="#{controlMaestras.guardaDato}"
									reRender="tablaDatos,panelDescripcion"
									rendered="#{controlMaestras.modDato eq 0}">
									<h:graphicImage value="/img/iconos/add.png"
										style="border:none;" title="#{ms.aniadir }" />
								</a4j:commandLink>

								<a4j:commandLink
									actionListener="#{controlMaestras.modificaDato}"
									reRender="tablaDatos,panelDescripcion"
									rendered="#{controlMaestras.modDato eq 1}">
									<h:graphicImage value="/img/iconos/modify.png" width="24"
										height="24" style="border:none;" title="#{ms.modificar }" />
								</a4j:commandLink>

								<a4j:commandLink actionListener="#{controlMaestras.eliminaDato}"
									reRender="tablaDatos,panelDescripcion"
									rendered="#{controlMaestras.modDato eq 1}">
									<h:graphicImage value="/img/iconos/cancel.gif"
										style="border:none;" title="#{ms.eliminar }" />
								</a4j:commandLink>

								<a4j:commandLink actionListener="#{controlMaestras.nuevoDato}"
									reRender="panelDescripcion">
									<h:graphicImage value="/img/iconos/document_new.gif"
										style="border:none;" title="#{ms.maestras_mod_msg_5 }" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>

						<h:panelGrid id="tablaDatos" width="50%">
							<t:dataTable width="100%" rows="10"
								value="#{controlMaestras.listaDatos}" var="linea" id="listaItems"
								style="width:100%;" styleClass="hor-minimalist-b"
								binding="#{controlMaestras.bindingTabla}">
								<t:column width="100%" style="text-align: left;"
									title="#{ms.maestras_mod_msg_4 }" id="idDesc" sortable="false">
									<f:facet name="header">
										<h:outputText value="#{ms.maestras_mod_msg_4 }" styleClass="hvn_cpoEtiqueta"
											id="cabDesc" style="text-align: left;" />
									</f:facet>
									<h:panelGrid style="text-align:left;" width="100%" id="a99">
										<a4j:commandLink rendered="#{linea.activo eq 1 }"
											actionListener="#{controlMaestras.lineaSelect}"
											value="#{linea.valor}" reRender="panelDescripcion"
											id="clDescp" />
										<a4j:commandLink rendered="#{linea.activo eq 0 }"
											style="text-decoration:none;color:red;"
											actionListener="#{controlMaestras.lineaSelect}"
											value="#{linea.valor}" reRender="panelDescripcion"
											id="clDescpVoid" title="#{ms.inactivo }"/>
									</h:panelGrid>
								</t:column>

								<f:facet name="footer">
									<rich:datascroller align="center" for="listaItems" id="a113"
										renderIfSinglePage="false" fastStep="5"
										boundaryControls="show"
										page="#{controlMaestras.pagina_inicial}" />
								</f:facet>
							</t:dataTable>
						</h:panelGrid>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
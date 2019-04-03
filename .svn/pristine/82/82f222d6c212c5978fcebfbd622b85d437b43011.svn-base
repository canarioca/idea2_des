<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form binding="#{controlPacientes.formulario}" id="menuPaciente">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<style>
.alignRight {
	text-align: right;
}

.estiloFondo {
	background-color: #ffffff;
	*background-image: url(/idea/img/aplicacion/datosPaci.png);
	background-repeat: no-repeat;
	background-position: right bottom;
}
</style>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				id="panelContenidoGlobal" style="margin-top: 15px;">
				<rich:messages errorClass="hvn_msjError" warnClass="hvn_msjAviso"
					infoClass="hvn_msjInfo" />
				<rich:panel>
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.pat_menu_title_1 }"
								styleClass="textoBlancoNegrita" />
							<h:panelGrid columns="3" columnClasses="right" id="accionesPacienteMenu">
								<a4j:commandLink 
									actionListener="#{controlPacientes.guardarPaciente }" rendered="#{controlPacientes.pacienteSelect.nhc ne null }"
									style="align:right;" reRender="infoPacienteDemo,nuevoCasa,histclin,histcardio,le,menu"
									onclick="javascript:RichFaces.switchTab('menuPaciente:tabpacienteMenu','menuPaciente:tabresumenclinicaMenu','barratemporalMenu')">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" title="#{ms.guardar }"
										width="24" height="24" url="/img/iconos/guardar.png"/>
								</a4j:commandLink>
								<a4j:commandLink 
									rendered="#{controlPacientes.modPaci eq 1 }"
									actionListener="#{controlPacientes.eliminarPaciente}"
									onclick="if (!confirm('Atención: Se eliminará el paciente de la base de datos, ¿desea continuar?')) return false"
									style="align:right;" reRender="panelContenidoGlobal,menu,cabecerapaciente">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" title="#{ms.eliminar }"
										width="24" height="24" url="/img/iconos/borra.png"/>
								</a4j:commandLink>
								<a4j:commandLink
									actionListener="#{controlPacientes.limpiarPacienteNuevo}"
									rendered="#{controlPacientes.modPaci eq 1}"
									style="align:right;" reRender="panelContenidoGlobal,menu,cabecerapaciente"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" title="#{ms.limpiar }"
										width="24" height="24" url="/img/iconos/limpia.png"/>
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<rich:tabPanel contentClass="estiloFondo" switchType="client" id="tabpacienteMenu">
						<rich:tab label="#{ms.pat_menu_title_tab_1 }" name="barratemporalMenu"
							rendered="#{controlPacientes.pacienteSelect.nhc ne null }" id="tabresumenclinicaMenu">
							<h:panelGrid id="resumenClinicaMenu" width="80%" >
								<a4j:include viewId="/ventanas/pacientes/resumenClinica.jsp" id="resumenclinicapacienteMenu"/>
							</h:panelGrid>
						</rich:tab>
						<rich:tab label="#{ms.pat_menu_title_tab_2 }" name="demograficos" id="tabdemograficosMenu">
							<h:panelGrid id="infoPacienteDemoMenu">
								<a4j:include viewId="/ventanas/pacientes/datosDemograficos.jsp" />
							</h:panelGrid>
							<h:panelGrid id="nuevoCasaMenu">
								<a4j:include viewId="/ventanas/pacientes/datosCasa.jsp" />
							</h:panelGrid>
						</rich:tab>
						<rich:tab label="#{ms.pat_menu_title_tab_3 }">
							<h:panelGrid id="sitclingenMenu" width="80%">
								<a4j:include viewId="/ventanas/pacientes/situacionclinica.jsp" />
							</h:panelGrid>
						</rich:tab>
						<rich:tab label="#{ms.pat_menu_title_tab_4 }">
							<h:panelGrid id="histclinMenu" width="80%">
								<a4j:include viewId="/ventanas/pacientes/historiaClinica.jsp" />
							</h:panelGrid>
						</rich:tab>
						<rich:tab label="#{ms.pat_menu_title_tab_5 }">
							<h:panelGrid id="histcardioMenu" width="80%">
								<a4j:include viewId="/ventanas/pacientes/historiaCardiologica.jsp" />
							</h:panelGrid>
						</rich:tab>
						<rich:tab label="#{ms.pat_menu_title_tab_6 }" rendered="#{controlPacientes.booleanListaEspera == true}">
							<h:panelGrid id="leMenu" width="80%">
								<a4j:include viewId="/ventanas/pacientes/listaEspera.jsp" />
							</h:panelGrid>
						</rich:tab>
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>

			
			

			

			<rich:modalPanel id="busqueda" height="450" width="760" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="Resultados obtenidos en la consulta"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>
						<f:attribute name="align" value="right" />
						<h:graphicImage url="/img/aplicacion/icoCancelar.png"
							style="cursor:pointer"
							onclick="javascript: Richfaces.hideModalPanel('busqueda');" />
					</h:panelGrid>
				</f:facet>
				<ui:include src="/ventanas/pacientes/busqueda.jsp" />
			</rich:modalPanel>
			<rich:modalPanel id="procedimiento" autosized="true" minHeight="50" minWidth="200" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="Selección de procedimiento"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>
					<h:panelGrid columns="2" rendered="true">
						<h:outputLabel style="font-weight: bold;" 
							value="Procedimiento: "/>
						<h:outputLabel 
							value="#{controlPacientes.tipoprocedimientobarratemporal }"/>
						<h:outputLabel style="font-weight: bold;" 
							value="Fecha: "/>
						<h:outputLabel
							value="#{controlPacientes.fechaprocedimientobarratemporal }"/>
					</h:panelGrid>
					
					<h:panelGrid columns="2" >
						<a4j:commandLink action="irImplantes" value="Ver registro" 
							actionListener="#{controlImplantes.cargaImplanteDesdeBarra }" rendered="#{controlPacientes.tipoprocedimiento eq 956 || controlPacientes.tipoprocedimiento eq 957 || controlPacientes.tipoprocedimiento eq 1059 || controlPacientes.tipoprocedimiento eq 1060 || controlPacientes.tipoprocedimiento eq 993}"/>
						<a4j:commandLink action="irSeguimientos" value="Ver registro" 
							actionListener="#{controlSeguimientos.cargaSeguimientoDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 983 }"/>
						<a4j:commandLink action="irRegistrador" value="Ver registro" 
							actionListener="#{controlRegistrador.cargaRegistradorDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1067 }"/>
						<a4j:commandLink action="irMesa" value="Ver registro" 
							actionListener="#{controlMesas.cargaMesaDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1066 }"/>
						<a4j:commandLink action="irCardioversion" value="Ver registro" 
							actionListener="#{controlCardioversion.cargaCardioversionDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1068 }"/>
						<a4j:commandLink action="irEef" value="Ver registro" 
							actionListener="#{controlEef.cargaEstudioDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1061 }"/>
						<a4j:commandLink action="irATP" value="Ver registro" 
							actionListener="#{controlTest.cargaATPDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1063 }"/>
						<a4j:commandLink action="irEpi" value="Ver registro" 
							actionListener="#{controlTest.cargaEpiDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1064 }"/>
						<a4j:commandLink action="irFle" value="Ver registro" 
							actionListener="#{controlTest.cargaFleDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1065 }"/>
						<a4j:commandLink value="Volver" onclick="javascript:Richfaces.hideModalPanel('procedimiento')"/>
					</h:panelGrid>
				</h:panelGrid>
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
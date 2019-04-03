<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="inicio">
			<style>
.alignRight {
	text-align: right;
}

.estiloFondo {
	background-color: #ffffff;
	background-image: url(/cardioarritmiasMS/img/iconos/book.png);
	background-repeat: no-repeat;
	background-position: right bottom;
}
</style>
			<a4j:poll reRender="cabpaci" interval="55000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panEef">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="3" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="paniconos">
							<h:panelGrid columns="3">
								<h:outputLabel value="#{ms.eef_neef }" style="color: white;" />
								<h:inputText size="9" maxlength="10"
									value="#{controlEef.eef.nestudio }" />
								<h:outputLabel value="#{ms.eef_title }"
									style="color: white;" />
							</h:panelGrid>
							<h:panelGrid columns="9">
								<h:outputLabel value="#{ms.eef_fecha }" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlEef.eef.fecha }" />
								<a4j:commandLink style="text-align: right;" reRender="panEef"
									onclick="if (!confirm('#{ms.eef_warn_nuevo}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlEef.nuevoEstudio }">
									<h:graphicImage url="/img/iconos/new.png" style="border:0px;"
										width="22" height="22" title="#{ms.eef_nuevo }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panEef,tablaPacientesBdu,paniconos"
									onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('episodios');"
									actionListener="#{controlEef.preguardaEstudio }"
									rendered="#{controlEef.eef.episodio eq null and controlEef.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panEef,paniconos"
									onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlEef.guardaEstudio }"
									rendered="#{controlEef.eef.episodio ne null and controlEef.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<t:commandLink title="#{ms.imprimir_informe }" rendered="#{controlEef.eef.idestudio ne null }"
									target="_blank" actionListener="#{controlEef.printEstudio}">
									<h:graphicImage value="/img/iconos/informe_especial.png" width="22"
										height="22" style="border:0;" />
								</t:commandLink>
								<t:commandLink title="#{ms.eef_impr_enf }" rendered="#{controlEef.eef.idestudio ne null }" 
									target="_blank" actionListener="#{controlEef.printEnfermeria}">
									<h:graphicImage value="/img/iconos/informe_especial_enf.png" width="22" height="22" style="border:0;"/>
								</t:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panEef"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									rendered="false"
									actionListener="#{controlEef.cargaMaestras }">
									<h:graphicImage url="/img/iconos/bd.png" style="border:0px;"
										title="#{ms.eef_recarga_dm }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panEef"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlEef.eliminarEstudioInterno }"
									rendered="#{controlEef.eef.idestudio ne null and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;"
									reRender="panEef,tablaPacientesBduPrt,paniconos"
									onclick="javascript:Richfaces.showModalPanel('protocolos');"
									actionListener="#{controlEef.consultaProtocolos }"
									rendered="#{controlEef.proc.idprocedimiento ne null and controlEef.editable}">
									<h:graphicImage url="/img/iconos/protocolo.png" style="border:0px;"
										title="#{ms.vincular }" width="22" height="22"/>
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<rich:tabPanel contentClass="estiloFondo" switchType="client" selectedTab="nameTabResumenEEF">
						<rich:tab label="#{ms.eef_tab_ind }">
							<a4j:include viewId="/ventanas/eef/indicacion.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_plantilla }" name="nameTabResumenEEF">
							<a4j:include viewId="/ventanas/eef/plantilla.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_rechum }" >
							<a4j:include viewId="/ventanas/eef/rechumanos.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_recmat }">
							<a4j:include viewId="/ventanas/eef/recmateriales.jsp" id="panelRecMaterialesEEF"/>
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_enf }">
							<a4j:include viewId="/ventanas/eef/enfermeria.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_ecg }" rendered="#{controlEef.eef.ecgb }">
							<a4j:include viewId="/ventanas/eef/estudios/ecg.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_fsin }"
							rendered="#{controlEef.eef.sinusalb }">
							<a4j:include viewId="/ventanas/eef/estudios/sinusal.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_cav }"
							rendered="#{controlEef.eef.conduccionb }">
							<a4j:include viewId="/ventanas/eef/estudios/av.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_vacc }"
							rendered="#{controlEef.eef.viasb }">
							<a4j:include viewId="/ventanas/eef/estudios/vias.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_pref }"
							rendered="#{controlEef.eef.periodosb }">
							<a4j:include viewId="/ventanas/eef/estudios/refractarios.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_taq }"
							rendered="#{controlEef.eef.taquicardiasb }">
							<a4j:include viewId="/ventanas/eef/estudios/taqui.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_intabl }"
							rendered="#{controlEef.eef.ablacion eq 1 }">
							<a4j:include viewId="/ventanas/eef/estudios/intento.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_abl }"
							rendered="#{controlEef.eef.ablacion eq 2}">
							<a4j:include viewId="/ventanas/eef/estudios/ablacion.jsp" />
						</rich:tab>
						<rich:tab label="#{ms.eef_tab_compdiag }"
							rendered="#{controlEef.eef.complicacionesb }">
							<a4j:include viewId="/ventanas/eef/estudios/complicaciones.jsp" />
						</rich:tab>						
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodios" autosized="true" minHeight="350" minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.eef_modal_episodios }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>
						<f:attribute name="align" value="right" />
						<h:graphicImage url="/img/aplicacion/icoCancelar.png"
							style="cursor:pointer"
							onclick="javascript: Richfaces.hideModalPanel('episodios');" />
					</h:panelGrid>
				</f:facet>
				<ui:include src="/ventanas/eef/episodios.jsp" />
			</rich:modalPanel>
			<rich:modalPanel id="protocolos" autosized="true" minHeight="350"
				minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.prot_modal_epi_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>
						<f:attribute name="align" value="right" />
						<h:graphicImage url="/img/aplicacion/icoCancelar.png"
							style="cursor:pointer"
							onclick="javascript: Richfaces.hideModalPanel('protocolos');" />
					</h:panelGrid>
				</f:facet>
				<ui:include src="/ventanas/eef/protocolos.jsp" />
			</rich:modalPanel>
		</h:form>
		<rich:modalPanel id="localizaciones" height="200" width="400"
			zindex="2000">
			<f:facet name="header">
				<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
					<h:outputText value="#{ms.eef_modal_vacc }"
						styleClass="textoBlancoNegrita" />
				</h:panelGrid>
			</f:facet>
			<h:form>
				<ui:include src="/ventanas/eef/estudios/vias/localizaciones.jsp" />
			</h:form>
		</rich:modalPanel>
	</ui:define>
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">	
	<ui:define name="contenido">
		<h:form id="inicioTestOrto">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"  style="margin-top: 15px;" id="panTestOrto">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo" warnClass="hvn_msjAviso" />
				<rich:panel style="background-color: #ffffff; background-repeat: no-repeat; background-position:right bottom;">
                     <f:facet name="header">
                     	<h:panelGrid columns="7" width="65%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicotestorto">
							<h:outputLabel value="#{ms.test_orto_title }" style="color: white;" />
							<h:panelGrid columns="2" columnClasses="right">
								<h:outputLabel value="#{ms.test_orto_fecha }" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlTestOrtostatismo.test.fecha}" >
								</rich:calendar>														
							</h:panelGrid>
	                 		<a4j:commandLink style="text-align: right;" reRender="panTestOrto,tablaPacientesBdu,panicotestorto" 
	                 			onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('episodios');" 
	                 			actionListener="#{controlTestOrtostatismo.preguarda }" rendered="#{controlTestOrtostatismo.proc.idepisodio eq null }">
								<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;" title="#{ms.guardar }"/>
							</a4j:commandLink>                 		
							<a4j:commandLink style="text-align: right;" reRender="panTestOrto,panicotestorto,panNuevaComplicacionPacSegClin"
								onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								actionListener="#{controlTestOrtostatismo.guardar }" rendered="#{controlTestOrtostatismo.proc.idepisodio ne null and controlTestOrtostatismo.editable }">
								<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;" title="#{ms.guardar }" />
							</a4j:commandLink>
							<a4j:commandLink style="text-align: right;"
								reRender="panTestOrto,tablaPacientesBduPrt,panicotestorto"
								onclick="javascript:Richfaces.showModalPanel('protocolos');"
								actionListener="#{controlTestOrtostatismo.consultaProtocolos }"
								rendered="#{controlTestOrtostatismo.proc.idprocedimiento ne null and controlTestOrtostatismo.editable}">
								<h:graphicImage url="/img/iconos/protocolo.png" style="border:0px;"
									title="#{ms.vincular }" width="22" height="22"/>
							</a4j:commandLink>
							<a4j:commandLink style="text-align: right;" reRender="panTestOrto"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlTestOrtostatismo.eliminar }" action="menuprincipal"
									rendered="#{controlTestOrtostatismo.test.idtest ne null and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
							</a4j:commandLink>
							<h:commandLink actionListener="#{controlTestOrtostatismo.imprimeInforme}"
								rendered="#{controlTestOrtostatismo.test.idtest ne null }" target="_blank">
								<h:graphicImage value="/img/iconos/informe_especial.png"
									width="22" height="22" style="border:none;" title="#{ms.imprimir_informe }" />
							</h:commandLink>														
						</h:panelGrid>
                     </f:facet>
                     <h:panelGrid columns="2" columnClasses="alignTop,alignTop,alignTop">
						<h:panelGrid columns="4" id="panTestOrtValores">
							<h:outputLabel value=""/>
							<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_dec }" style="font-weight: bold;"/>
							<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_ort }" style="font-weight: bold;"/>
							<h:outputLabel value="#{ms.test_orto_variacion }" style="font-weight: bold;"/>
							<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_tas }" style="font-weight: bold;"
								title="#{ms.prot_sincope_alta_pdiag_ini_test_ort_tas_title }"/>
							<h:inputText value="#{controlTestOrtostatismo.test.decTas }" size="5">
								<a4j:support event="onchange" reRender="panTestOrtValores,panTestOrtoResultados" 
									actionListener="#{controlTestOrtostatismo.calcularVariacionValores }"/>
							</h:inputText>
							<h:inputText value="#{controlTestOrtostatismo.test.ortTas }" size="5">
								<a4j:support event="onchange" reRender="panTestOrtValores,panTestOrtoResultados" 
									actionListener="#{controlTestOrtostatismo.calcularVariacionValores }"/>
							</h:inputText>
							<h:inputText value="#{controlTestOrtostatismo.test.varTas }" size="5" disabled="true" id="panTestOrtVarTas"/>
							<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_tad }" style="font-weight: bold;"
								title="#{ms.prot_sincope_alta_pdiag_ini_test_ort_tad_title }"/>
							<h:inputText value="#{controlTestOrtostatismo.test.decTad }" size="5">
								<a4j:support event="onchange" reRender="panTestOrtValores,panTestOrtoResultados" 
									actionListener="#{controlTestOrtostatismo.calcularVariacionValores }"/>
							</h:inputText>
							<h:inputText value="#{controlTestOrtostatismo.test.ortTad }" size="5">
								<a4j:support event="onchange" reRender="panTestOrtValores,panTestOrtoResultados" 
									actionListener="#{controlTestOrtostatismo.calcularVariacionValores }"/>
							</h:inputText>
							<h:inputText value="#{controlTestOrtostatismo.test.varTad }" size="5" disabled="true" id="panTestOrtVarTad"/>
							<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_fc }" style="font-weight: bold;"
								title="#{ms.prot_sincope_alta_pdiag_ini_test_ort_fc_title }"/>
							<h:inputText value="#{controlTestOrtostatismo.test.decFc }" size="5"/>
							<h:inputText value="#{controlTestOrtostatismo.test.ortFc }" size="5"/>
							<h:outputLabel value=""/>
						</h:panelGrid>
						<h:panelGrid>
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
								<h:outputLabel value="#{ms.test_orto_med }" style="font-weight: bold;" />
								<h:outputLabel value="#{ms.test_orto_enf }" style="font-weight: bold;" />
								<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;" >
									<h:selectOneMenu value="#{controlTestOrtostatismo.test.operador}">
										<f:selectItems value="#{controlTestOrtostatismo.primerOperador}" />
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;" >
									<h:selectOneMenu value="#{controlTestOrtostatismo.test.enfermeria}">
										<f:selectItems value="#{controlTestOrtostatismo.enfermeras}" />
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid>
								<h:outputLabel value="#{ms.test_orto_coment }" style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									width="80%" cellspacing="0" columnClasses="alignTop">					
									<h:inputTextarea cols="120" rows="5" value="#{controlTestOrtostatismo.test.comentarios }" 
										id="comentariosTestOrto" >
										 <f:validateLength maximum="1000" />
									</h:inputTextarea>	
									<h:message for="comentariosTestOrto" style="color:red" />
								</h:panelGrid>
							</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
					<h:outputLabel value="#{ms.test_orto_hta}" rendered="#{controlPacientes.pacienteSelect.sitclin.hta eq 1}"
						style="font-weight: bold;color:#E17009" />
					<h:panelGrid id="panTestOrtoResultados">
						<h:panelGrid columns="2" rendered="#{controlTestOrtostatismo.test.res ne null }">
							<h:outputLabel value="#{ms.test_orto_resultado }:" />
							<h:outputLabel value="#{ms.test_orto_resultado_pos}" rendered="#{controlTestOrtostatismo.test.res eq 1}"
								style="font-weight: bold;color:#E17009" />
							<h:outputLabel value="#{ms.test_orto_resultado_neg }" rendered="#{controlTestOrtostatismo.test.res eq 0}"
								style="font-weight: bold;color:#009933" />
						</h:panelGrid>
					</h:panelGrid>
                </rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodios" autosized="true" minHeight="350" minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.test_orto_modal_epi_title }"
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
				<ui:include src="/ventanas/test_ortostatismo/episodios.jsp" />
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
				<ui:include src="/ventanas/test_ortostatismo/protocolos.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
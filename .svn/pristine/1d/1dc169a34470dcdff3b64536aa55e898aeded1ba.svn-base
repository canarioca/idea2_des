<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox"
	xmlns:p="http://primefaces.prime.com.tr/ui" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="testatp">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelEnf">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" cellpadding="0"
							cellspacing="0" columnClasses="left,right">
							<h:outputLabel value="#{ms.eef_enf_title }"
								style="color: white;" />
							<h:panelGrid columns="4" columnClasses="right">
								<h:outputLabel value="#{ms.eef_enf_fecha_eef }"
									style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlTest.enf.fecha }" />
								<a4j:commandLink style="text-align: right;" reRender="panelEnf"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlTest.guardaEnf }">
									<h:graphicImage url="/img/iconos/save.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<t:commandLink title="#{ms.imprimir_informe }" rendered="#{controlTest.asociado }"
									target="_blank" actionListener="#{controlTest.printEnfermeria}">
									<h:graphicImage value="/img/iconos/print.png" width="22"
										height="22" style="border:0;" />
								</t:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<h:panelGrid width="100%">
						<a4j:jsFunction name="calcimc" reRender="panelEnf" />
						<h:panelGrid columns="3" cellpadding="0" cellspacing="0"
							width="50%">
							<h:panelGrid columns="3">
								<h:outputLabel value="#{ms.eef_enf_peso }" />
								<h:inputText size="5" value="#{controlTest.enf.peso }" />
								<h:outputLabel value="kg" />
							</h:panelGrid>
							<h:panelGrid columns="3">
								<h:outputLabel value="#{ms.eef_enf_talla }" />
								<h:inputText size="5" value="#{controlTest.enf.talla }"
									onblur="calcimc();" />
								<h:outputLabel value="centímetros" />
							</h:panelGrid>
							<h:panelGrid columns="3">
								<h:outputLabel value="#{ms.eef_enf_imc }" />
								<h:inputText size="5" value="#{controlTest.enf.imc }" />
								<h:outputLabel value="#{ms.eef_enf_imc_unidades }" />
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
							width="50%">
							<h:panelGrid columns="4">
								<h:outputLabel value="#{ms.eef_enf_ta_llegada }" />
								<h:inputText size="5" value="#{controlTest.enf.talleg1 }" />
								<h:outputLabel value="/" />
								<h:inputText size="5" value="#{controlTest.enf.talleg2 }" />
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.eef_enf_fc_llegada }" />
								<h:inputText size="5" value="#{controlTest.enf.fclleg }" />
							</h:panelGrid>
							<h:panelGrid columns="4">
								<h:outputLabel value="#{ms.eef_enf_ta_final }" />
								<h:inputText size="5" value="#{controlTest.enf.tafin1 }" />
								<h:outputLabel value="/" />
								<h:inputText size="5" value="#{controlTest.enf.tafin2 }" />
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.eef_enf_fc_final }" />
								<h:inputText size="5" value="#{controlTest.enf.fcfin }" />
							</h:panelGrid>
							<h:panelGrid columns="4">
								<h:outputLabel value="#{ms.eef_enf_ta_taqui }" />
								<h:inputText size="5" value="#{controlTest.enf.tataq1 }" />
								<h:outputLabel value="/" />
								<h:inputText size="5" value="#{controlTest.enf.tataq2 }" />
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.eef_enf_fc_taqui }" />
								<h:inputText size="5" value="#{controlTest.enf.fctaq }" />
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.eef_enf_inr }" />
								<h:inputText size="5" maxlength="4"
									value="#{controlTest.enf.inr }" />
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="#{ms.eef_enf_canalizacion_vv }"
								style="font-weight: bold;" />
							<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
								<h:outputLabel value="#{ms.eef_enf_introductores }" style="font-weight: bold;" />
								<a4j:commandLink reRender="tablaIntroductores"
									actionListener="#{controlTest.enf.addIntroductores }">
									<h:graphicImage value="/img/iconos/add.png" width="16"
										height="16" style="border:0;" title="#{ms.aniadir }" />
								</a4j:commandLink>
							</h:panelGrid>
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop"
								style="border-top: solid 1px;border-color: black;">
								<h:outputLabel value="#{ms.eef_enf_vv_planta }" />
								<h:selectOneRadio value="#{controlTest.enf.planta }">
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_vv_planta_si }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_vv_planta_no }" />
								</h:selectOneRadio>
								<h:outputLabel value="#{ms.eef_enf_calibre }" />
								<h:inputText size="6" value="#{controlTest.enf.calibre1 }" />
								<h:outputLabel value="#{ms.eef_enf_miembro }" />
								<h:inputText size="30" value="#{controlTest.enf.miembro }" />
							</h:panelGrid>
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop"
								style="border-top: solid 1px;border-color: black;"
								id="tablaIntroductores">
								<t:dataTable styleClass="hor-minimalist-b" var="linea"
									width="100%" value="#{controlTest.enf.introductores }"
									binding="#{controlTest.enf.binintr }">
									<t:column width="30%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.eef_enf_introductores_num }" />
										</f:facet>
										<h:inputText id="numero" size="15" value="#{linea.numero }" />
									</t:column>
									<t:column width="30%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.eef_enf_introductores_calibre }" />
										</f:facet>
										<h:inputText id="calibre" size="15" value="#{linea.calibre }" />
									</t:column>
									<t:column width="30%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.eef_enf_introductores_tipo }" />
										</f:facet>
										<h:inputText id="tipo" size="15" value="#{linea.tipo }" />
									</t:column>
									<t:column headerstyleClass="left">
										<a4j:commandLink reRender="tablaIntroductores"
											actionListener="#{controlTest.enf.delIntroductores }">
											<h:graphicImage url="/img/iconos/minus.png"
												title="#{ms.eliminar }" width="16" height="16"
												style="border: 0px;" />
										</a4j:commandLink>
									</t:column>
								</t:dataTable>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid width="80%">
							<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
								<h:outputLabel value="Catéteres diagnósticos"
									style="font-weight: bold;" />
								<a4j:commandLink reRender="tablaCat"
									actionListener="#{controlTest.enf.addCat }">
									<h:graphicImage value="/img/iconos/add.png" width="16"
										height="16" style="border:0;" title="Añadir catéter" />
								</a4j:commandLink>
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								id="tablaCat" width="100%">
								<t:dataTable styleClass="hor-minimalist-b" var="linea"
									width="100%" value="#{controlTest.enf.cats }"
									binding="#{controlTest.enf.bincat }">
									<t:column width="30%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="Catéter" />
										</f:facet>
										<h:panelGrid columns="2">
											<h:inputText id="Catet" size="30" value="#{linea.idcateter }" />
											<h:graphicImage value="/img/iconos/arrow.png"
												onclick="#{rich:component('suggestionBoxCateter')}.callSuggestion(true)" />
											<rich:suggestionbox id="suggestionBoxCateter" for="Catet"
												suggestionAction="#{controlEef.autocompletarCateteres}"
												var="result" zindex="50000" width="200" height="100"
												nothingLabel="No se encontró ningún catéter">
												<a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender" />
												<h:column>
													<h:outputText value="#{result.valor}"
														style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
												</h:column>
											</rich:suggestionbox>
										</h:panelGrid>
									</t:column>
									<t:column width="20%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="Marca/Modelo" />
										</f:facet>
										<h:panelGrid columns="2">
											<h:inputText id="Marca" size="30" value="#{linea.idfuncion }" />
											<h:graphicImage value="/img/iconos/arrow.png"
												onclick="#{rich:component('suggestionBoxMarca')}.callSuggestion(true)" />
											<rich:suggestionbox id="suggestionBoxMarca" for="Marca"
												suggestionAction="#{controlEef.autocompletarMarcaCat}"
												var="result" zindex="50000" width="200" height="100"
												nothingLabel="No se encontró ninguna marca/modelo">
												<a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender" />
												<h:column>
													<h:outputText value="#{result.valor}"
														style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
												</h:column>
											</rich:suggestionbox>
										</h:panelGrid>
									</t:column>
									<t:column width="20%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="Localización" />
										</f:facet>
										<h:panelGrid columns="2">
											<h:inputText id="Local" size="30" value="#{linea.idloc }" />
											<h:graphicImage value="/img/iconos/arrow.png"
												onclick="#{rich:component('suggestionBoxLocal')}.callSuggestion(true)" />
											<rich:suggestionbox id="suggestionBoxLocal" for="Local"
												suggestionAction="#{controlEef.autocompletarLocalCat}"
												var="result" zindex="50000" width="200" height="100"
												nothingLabel="No se encontró ninguna localización">
												<a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender" />
												<h:column>
													<h:outputText value="#{result.valor}"
														style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
												</h:column>
											</rich:suggestionbox>
										</h:panelGrid>
									</t:column>
									<t:column width="20%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="Vía acceso" />
										</f:facet>
										<h:selectOneMenu value="#{linea.idvia }"
											style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
											<f:selectItems value="#{controlEef.viascateter }" />
										</h:selectOneMenu>
									</t:column>
									<t:column headerstyleClass="left">
										<a4j:commandLink reRender="tablaCat"
											actionListener="#{controlTest.enf.delCat }">
											<h:graphicImage url="/img/iconos/minus.png"
												title="Eliminar catéter" width="16" height="16"
												style="border: 0px;" />
										</a4j:commandLink>
									</t:column>
								</t:dataTable>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="Punción transeptal?" />
							<h:selectOneRadio value="#{controlTest.enf.puncion }">
								<f:selectItem itemValue="1" itemLabel="Si" />
								<f:selectItem itemValue="2" itemLabel="No" />
							</h:selectOneRadio>
							<h:outputLabel value="Material utilizado en punción" />
							<h:inputTextarea rows="3" cols="60"
								value="#{controlTest.enf.material }" />
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="Sondajes" style="font-weight: bold;" />
							<h:outputLabel value="Vía vascular utilizada"
								style="font-weight: bold;" />
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop"
								style="border-top: solid 1px;border-color: black;">
								<h:outputLabel value="Vesical" />
								<h:inputText size="40" value="#{controlTest.enf.vesical }" />
								<h:outputLabel value="Otros" />
								<h:inputText size="40" value="#{controlTest.enf.otros }" />
								<h:outputLabel value="Diuresis" />
								<h:inputText size="40" value="#{controlTest.enf.diuresis }" />
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								columns="2">
								<h:selectBooleanCheckbox value="#{controlTest.enf.vascular1 }" />
								<h:outputLabel value="Vena femoral izquierda" />
								<h:selectBooleanCheckbox value="#{controlTest.enf.vascular2 }" />
								<h:outputLabel value="Vena femoral derecha" />
								<h:selectBooleanCheckbox value="#{controlTest.enf.vascular3 }" />
								<h:outputLabel value="Vena braquial izquierda" />
								<h:selectBooleanCheckbox value="#{controlTest.enf.vascular4 }" />
								<h:outputLabel value="Arteria femoral derecha" />
								<h:selectBooleanCheckbox value="#{controlTest.enf.vascular5 }" />
								<h:outputLabel value="Arteria femoral izquierda" />
								<h:selectBooleanCheckbox value="#{controlTest.enf.vascular6 }" />
								<h:outputLabel value="Yugular / Subclavia" />
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="Tipo de hemostasia arterial"
								style="font-weight: bold;" />
							<h:outputLabel value="Tipo de hemostasia venosa"
								style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								width="300px">
								<h:selectOneRadio layout="pageDirection"
									value="#{controlTest.enf.hemostasia }">
									<f:selectItem itemValue="1" itemLabel="Manual" />
									<f:selectItem itemValue="2" itemLabel="Dispositivo" />
								</h:selectOneRadio>
								<h:inputText size="30" value="#{controlTest.enf.hemostr }" />
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								width="300px">
								<h:selectOneRadio layout="pageDirection"
									value="#{controlTest.enf.hemostasiav }">
									<f:selectItem itemValue="1" itemLabel="Manual" />
									<f:selectItem itemValue="2" itemLabel="Dispositivo" />
								</h:selectOneRadio>
								<h:inputText size="30" value="#{controlTest.enf.hemostrv }" />
							</h:panelGrid>
							<h:outputLabel value="Vendaje compresivo"
								style="font-weight: bold;" />
							<h:outputLabel value=""
								style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								width="300px">
								<h:selectOneRadio layout="pageDirection"
									value="#{controlTest.enf.vendaje }">
									<f:selectItem itemValue="1" itemLabel="Si" />
									<f:selectItem itemValue="2" itemLabel="No" />
								</h:selectOneRadio>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="Estado de la zona de punción post"
								style="font-weight: bold;" />
							<h:outputLabel value="Medicación" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								width="300px">
								<h:selectOneRadio layout="pageDirection"
									value="#{controlTest.enf.zona }">
									<f:selectItem itemValue="1" itemLabel="Normal" />
									<f:selectItem itemValue="2" itemLabel="Hematoma ligero" />
									<f:selectItem itemValue="3" itemLabel="Hematoma moderado" />
									<f:selectItem itemValue="4" itemLabel="Hematoma severo" />
								</h:selectOneRadio>
							</h:panelGrid>
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop"
								style="border-top: solid 1px;border-color: black;">
								<h:outputLabel value="Sueroterapia" />
								<h:inputText size="60" value="#{controlTest.enf.suero }" />
								<h:outputLabel value="Dosis de heparina" />
								<h:inputText size="10" value="#{controlTest.enf.heparina }" />
								<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
									<h:outputLabel value="ACT" style="font-weight: bold;" />
									<a4j:commandLink reRender="tablaact"
										actionListener="#{controlTest.enf.addAct }">
										<h:graphicImage value="/img/iconos/add.png" width="16"
											height="16" style="border:0;" title="Añadir ACT" />
									</a4j:commandLink>
								</h:panelGrid>
								<h:panelGrid id="tablaact">
									<t:dataTable styleClass="hor-minimalist-b" var="linea"
										width="100%" value="#{controlTest.enf.acts }"
										binding="#{controlTest.enf.binact }">
										<t:column width="30%" headerstyleClass="left">
											<h:inputText id="act" size="15" value="#{linea.act }" />
										</t:column>
										<t:column headerstyleClass="left">
											<a4j:commandLink reRender="tablaact"
												actionListener="#{controlTest.enf.delAct }">
												<h:graphicImage url="/img/iconos/minus.png"
													title="Eliminar ACT" width="16" height="16"
													style="border: 0px;" />
											</a4j:commandLink>
										</t:column>
									</t:dataTable>
								</h:panelGrid>
								<h:outputLabel value="Sedación" />
								<h:panelGrid cellpadding="0" cellspacing="0" columns="2">
									<h:selectBooleanCheckbox value="#{controlTest.enf.sedacion1 }" />
									<h:outputLabel value="Remifentanilo" />
									<h:selectBooleanCheckbox value="#{controlTest.enf.sedacion2 }" />
									<h:outputLabel value="Midazolan" />
									<h:selectBooleanCheckbox value="#{controlTest.enf.sedacion3 }" />
									<h:outputLabel value="Propofol" />
								</h:panelGrid>
								<h:outputLabel value="Otros fármacos" />
								<h:inputText size="60" value="#{controlTest.enf.farmacos }" />
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="Cardioversión / desfibrilación"
								style="font-weight: bold;" />
							<h:outputLabel value="Servicio / cama destino"
								style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								columns="2">
								<h:selectOneRadio value="#{controlTest.enf.cv }">
									<f:selectItem itemValue="1" itemLabel="Si" />
									<f:selectItem itemValue="2" itemLabel="No" />
								</h:selectOneRadio>
								<h:outputLabel value="" />
								<h:outputLabel value="Julios" style="font-weight: bold;" />
								<h:panelGrid columns="4">
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:outputLabel value="CVE 1" />
										<h:inputText size="5" value="#{controlTest.enf.cv1 }" />
									</h:panelGrid>
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:outputLabel value="CVE 2" />
										<h:inputText size="5" value="#{controlTest.enf.cv2 }" />
									</h:panelGrid>
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:outputLabel value="CVE 3" />
										<h:inputText size="5" value="#{controlTest.enf.cv3 }" />
									</h:panelGrid>
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:outputLabel value="CVE 4" />
										<h:inputText size="5" value="#{controlTest.enf.cv4 }" />
									</h:panelGrid>
								</h:panelGrid>
								<h:outputLabel value="Motivo:" />
								<h:selectOneRadio value="#{controlTest.enf.motivo }">
									<f:selectItem itemValue="1" itemLabel="FA/FLT" />
									<f:selectItem itemValue="2" itemLabel="TVM" />
									<f:selectItem itemValue="3" itemLabel="FV" />
								</h:selectOneRadio>
								<h:outputLabel value="Éxito:" />
								<h:selectOneRadio value="#{controlTest.enf.exito }">
									<f:selectItem itemValue="1" itemLabel="Si" />
									<f:selectItem itemValue="2" itemLabel="No" />
								</h:selectOneRadio>
								<h:outputLabel value="Obs.:" />
								<h:inputTextarea cols="50" rows="3"
									value="#{controlTest.enf.observ }" />
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText size="30" value="#{controlTest.enf.destino }" />
							</h:panelGrid>
						</h:panelGrid>
						<h:outputLabel value="Cuidados Posteriores" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputTextarea rows="5" cols="160"
								value="#{controlTest.enf.cuidados }" />
						</h:panelGrid>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>

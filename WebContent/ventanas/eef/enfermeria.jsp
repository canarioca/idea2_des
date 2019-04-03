<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox"
	xmlns:p="http://primefaces.prime.com.tr/ui">

	<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelEnfEef">
				<h:panelGrid width="100%">
						<a4j:jsFunction name="calcimc" reRender="panelEnfEef" />
						<h:panelGrid columns="3" cellpadding="0" cellspacing="0"
							width="50%">
							<h:panelGrid columns="3">
								<h:outputLabel value="#{ms.eef_enf_peso }" />
								<h:inputText size="5" value="#{controlEef.enf.peso }" maxlength="5"/>
								<h:outputLabel value="#{ms.eef_enf_peso_unidades }" />
							</h:panelGrid>
							<h:panelGrid columns="3">
								<h:outputLabel value="#{ms.eef_enf_talla }" />
								<h:inputText size="5" value="#{controlEef.enf.talla }"
									onblur="calcimc();" maxlength="5"/>
								<h:outputLabel value="#{ms.eef_enf_talla_unidades }" />
							</h:panelGrid>
							<h:panelGrid columns="3">
								<h:outputLabel value="#{ms.eef_enf_imc }" />
								<h:inputText size="5" value="#{controlEef.enf.imc }" maxlength="5"/>
								<h:outputLabel value="#{ms.eef_enf_imc_unidades }" />
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0"
							width="50%">
							<h:panelGrid columns="4">
								<h:outputLabel value="#{ms.eef_enf_ta_llegada }" />
								<h:inputText size="5" value="#{controlEef.enf.talleg1 }" maxlength="5"/>
								<h:outputLabel value="/" />
								<h:inputText size="5" value="#{controlEef.enf.talleg2 }" maxlength="5"/>
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.eef_enf_fc_llegada }" />
								<h:inputText size="5" value="#{controlEef.enf.fclleg }" maxlength="5"/>
							</h:panelGrid>
							<h:panelGrid columns="4">
								<h:outputLabel value="#{ms.eef_enf_ta_final }" />
								<h:inputText size="5" value="#{controlEef.enf.tafin1 }" maxlength="5"/>
								<h:outputLabel value="/" />
								<h:inputText size="5" value="#{controlEef.enf.tafin2 }" maxlength="5"/>
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.eef_enf_fc_final }" />
								<h:inputText size="5" value="#{controlEef.enf.fcfin }" maxlength="5"/>
							</h:panelGrid>
							<h:panelGrid columns="4">
								<h:outputLabel value="#{ms.eef_enf_ta_taqui }" />
								<h:inputText size="5" value="#{controlEef.enf.tataq1 }" maxlength="5"/>
								<h:outputLabel value="/" />
								<h:inputText size="5" value="#{controlEef.enf.tataq2 }" maxlength="5"/>
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.eef_enf_fc_taqui }" />
								<h:inputText size="5" value="#{controlEef.enf.fctaq }" maxlength="5"/>
							</h:panelGrid>
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.eef_enf_inr }" />
								<h:inputText size="5" maxlength="4"
									value="#{controlEef.enf.inr }" />
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="#{ms.eef_enf_canalizacion_vv }"
								style="font-weight: bold;" />
							<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
								<h:outputLabel value="Introductores" style="font-weight: bold;" />
								<a4j:commandLink reRender="tablaIntroductoresEnf"
									actionListener="#{controlEef.enf.addIntroductores }">
									<h:graphicImage value="/img/iconos/add.png" width="16"
										height="16" style="border:0;" title="#{ms.aniadir }" />
								</a4j:commandLink>
							</h:panelGrid>
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop"
								style="border-top: solid 1px;border-color: black;">
								<h:outputLabel value="#{ms.eef_enf_vv_planta }" />
								<h:selectOneRadio value="#{controlEef.enf.planta }">
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_vv_planta_si }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_vv_planta_no }" />
								</h:selectOneRadio>
								<h:outputLabel value="#{ms.eef_enf_calibre }" />
								<h:inputText size="6" value="#{controlEef.enf.calibre1 }" maxlength="100"/>
								<h:outputLabel value="#{ms.eef_enf_miembro }" />
								<h:inputText size="30" value="#{controlEef.enf.miembro }" maxlength="30"/>
							</h:panelGrid>
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop"
								style="border-top: solid 1px;border-color: black;"
								id="tablaIntroductoresEnf">
								<t:dataTable styleClass="hor-minimalist-b" var="linea"
									width="100%" value="#{controlEef.enf.introductores }"
									binding="#{controlEef.enf.binintr }">
									<t:column width="30%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.eef_enf_introductores_num }" />
										</f:facet>
										<h:inputText id="numeroEnf" size="15" value="#{linea.numero }" maxlength="40"/>
									</t:column>
									<t:column width="30%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.eef_enf_introductores_calibre }" />
										</f:facet>
										<h:inputText id="calibreEnf" size="15" value="#{linea.calibre }" maxlength="40"/>
									</t:column>
									<t:column width="30%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="#{ms.eef_enf_introductores_tipo }" />
										</f:facet>
										<h:inputText id="tipoEnf" size="15" value="#{linea.tipo }" maxlength="40"/>
									</t:column>
									<t:column headerstyleClass="left">
										<a4j:commandLink reRender="tablaIntroductoresEnf"
											actionListener="#{controlEef.enf.delIntroductores }">
											<h:graphicImage url="/img/iconos/minus.png"
												title="#{ms.eliminar }" width="16" height="16"
												style="border: 0px;" />
										</a4j:commandLink>
									</t:column>
								</t:dataTable>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid width="80%" rendered="false">
							<h:panelGrid columns="2" cellpadding="0" cellspacing="0" rendered="false">
								<h:outputLabel value="Catéteres diagnósticos"
									style="font-weight: bold;" />
								<a4j:commandLink reRender="tablaCatDiag"
									actionListener="#{controlEef.enf.addCat }">
									<h:graphicImage value="/img/iconos/add.png" width="16"
										height="16" style="border:0;" title="Añadir catéter" />
								</a4j:commandLink>
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								id="tablaCatDiag" width="100%" rendered="false">
								<t:dataTable styleClass="hor-minimalist-b" var="linea"
									width="100%" value="#{controlEef.enf.cats }"
									binding="#{controlEef.enf.bincat }">
									<t:column width="30%" headerstyleClass="left">
										<f:facet name="header">
											<h:outputText value="Catéter" />
										</f:facet>
										<h:panelGrid columns="2">
											<h:inputText id="CatetDiag" size="30" value="#{linea.idcateter }" />
											<h:graphicImage value="/img/iconos/arrow.png"
												onclick="#{rich:component('suggestionBoxCateterDiag')}.callSuggestion(true)" />
											<rich:suggestionbox id="suggestionBoxCateterDiag" for="CatetDiag"
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
											<h:inputText id="MarcaDiag" size="30" value="#{linea.idfuncion }" />
											<h:graphicImage value="/img/iconos/arrow.png"
												onclick="#{rich:component('suggestionBoxMarcaDiag')}.callSuggestion(true)" />
											<rich:suggestionbox id="suggestionBoxMarcaDiag" for="MarcaDiag"
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
											<h:inputText id="LocalDiag" size="30" value="#{linea.idloc }" />
											<h:graphicImage value="/img/iconos/arrow.png"
												onclick="#{rich:component('suggestionBoxLocalDiag')}.callSuggestion(true)" />
											<rich:suggestionbox id="suggestionBoxLocalDiag" for="LocalDiag"
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
										<a4j:commandLink reRender="tablaCatDiag"
											actionListener="#{controlEef.enf.delCat }">
											<h:graphicImage url="/img/iconos/minus.png"
												title="Eliminar catéter" width="16" height="16"
												style="border: 0px;" />
										</a4j:commandLink>
									</t:column>
								</t:dataTable>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="#{ms.eef_enf_puncion_trans }" />
							<h:selectOneRadio value="#{controlEef.enf.puncion }">
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_puncion_trans_si }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_puncion_trans_no }" />
							</h:selectOneRadio>
							<h:outputLabel value="#{ms.eef_enf_puncion_material }" />
							<h:inputTextarea rows="3" cols="60"
								value="#{controlEef.enf.material }" id="comentariosEnfMat">
								<f:validateLength maximum="4000" />
							</h:inputTextarea>	
							<h:message for="comentariosEnfMat" style="color:red" />
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="#{ms.eef_enf_sondajes }" style="font-weight: bold;" />
							<h:outputLabel value="#{ms.eef_enf_via_vasc_utilizada }"
								style="font-weight: bold;" />
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop"
								style="border-top: solid 1px;border-color: black;">
								<h:outputLabel value="#{ms.eef_enf_vesical }" />
								<h:inputText size="40" value="#{controlEef.enf.vesical }" maxlength="100"/>
								<h:outputLabel value="#{ms.eef_enf_otros }" />
								<h:inputText size="40" value="#{controlEef.enf.otros }" maxlength="100"/>
								<h:outputLabel value="#{ms.eef_enf_diuresis }" />
								<h:inputText size="40" value="#{controlEef.enf.diuresis }" maxlength="20"/>
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								columns="2">
								<h:selectBooleanCheckbox value="#{controlEef.enf.vascular1 }" />
								<h:outputLabel value="#{ms.eef_enf_vena_fem_izq }" />
								<h:selectBooleanCheckbox value="#{controlEef.enf.vascular2 }" />
								<h:outputLabel value="#{ms.eef_enf_vena_fem_dcha }" />
								<h:selectBooleanCheckbox value="#{controlEef.enf.vascular3 }" />
								<h:outputLabel value="#{ms.eef_enf_vena_braq_izq }" />
								<h:selectBooleanCheckbox value="#{controlEef.enf.vascular4 }" />
								<h:outputLabel value="#{ms.eef_enf_art_fem_dcha }" />
								<h:selectBooleanCheckbox value="#{controlEef.enf.vascular5 }" />
								<h:outputLabel value="#{ms.eef_enf_art_fem_izq }" />
								<h:selectBooleanCheckbox value="#{controlEef.enf.vascular6 }" />
								<h:outputLabel value="#{ms.eef_enf_yug_subclav }" />
								<h:selectBooleanCheckbox value="#{controlEef.enf.vascular7 }" />
								<h:outputLabel value="#{ms.eef_enf_art_rad_dcha }" />
								<h:selectBooleanCheckbox value="#{controlEef.enf.vascular8 }" />
								<h:outputLabel value="#{ms.eef_enf_art_rad_izq }" />
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="#{ms.eef_enf_tipo_hem_art }"
								style="font-weight: bold;" />
							<h:outputLabel value="#{ms.eef_enf_tipo_hem_ven }"
								style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								width="300px">
								<h:selectOneRadio layout="pageDirection"
									value="#{controlEef.enf.hemostasia }">
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_tipo_hem_manual }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_tipo_hem_disp }" />
								</h:selectOneRadio>
								<h:inputText size="30" value="#{controlEef.enf.hemostr }" maxlength="100"/>
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								width="300px">
								<h:selectOneRadio layout="pageDirection"
									value="#{controlEef.enf.hemostasiav }">
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_tipo_hem_manual }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_tipo_hem_disp }" />
								</h:selectOneRadio>
								<h:inputText size="30" value="#{controlEef.enf.hemostrv }" maxlength="100"/>
							</h:panelGrid>
							<h:outputLabel value="#{ms.eef_enf_vendaje_comp }"
								style="font-weight: bold;" />
							<h:outputLabel value=""
								style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								width="300px">
								<h:selectOneRadio layout="pageDirection"
									value="#{controlEef.enf.vendaje }">
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_vendaje_comp_si }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_vendaje_comp_no }" />
								</h:selectOneRadio>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="#{ms.eef_enf_estado_zona_puncion_post }"
								style="font-weight: bold;" />
							<h:outputLabel value="#{ms.eef_enf_medicacion }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								width="300px">
								<h:selectOneRadio layout="pageDirection"
									value="#{controlEef.enf.zona }">
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_estado_zona_puncion_post_op1 }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_estado_zona_puncion_post_op2 }" />
									<f:selectItem itemValue="3" itemLabel="#{ms.eef_enf_estado_zona_puncion_post_op3 }" />
									<f:selectItem itemValue="4" itemLabel="#{ms.eef_enf_estado_zona_puncion_post_op4 }" />
								</h:selectOneRadio>
							</h:panelGrid>
							<h:panelGrid columns="2" columnClasses="alignTop,alignTop"
								style="border-top: solid 1px;border-color: black;">
								<h:outputLabel value="#{ms.eef_enf_suero }" />
								<h:inputText size="60" value="#{controlEef.enf.suero }" maxlength="200"/>
								<h:outputLabel value="#{ms.eef_enf_dosis_heparina }" />
								<h:inputText size="10" value="#{controlEef.enf.heparina }" maxlength="20"/>
								<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
									<h:outputLabel value="#{ms.eef_enf_act }" style="font-weight: bold;" />
									<a4j:commandLink reRender="tablaactenf"
										actionListener="#{controlEef.enf.addAct }">
										<h:graphicImage value="/img/iconos/add.png" width="16"
											height="16" style="border:0;" title="#{ms.aniadir }" />
									</a4j:commandLink>
								</h:panelGrid>
								<h:panelGrid id="tablaactenf">
									<t:dataTable styleClass="hor-minimalist-b" var="linea"
										width="100%" value="#{controlEef.enf.acts }"
										binding="#{controlEef.enf.binact }">
										<t:column width="30%" headerstyleClass="left">
											<h:inputText id="act" size="15" value="#{linea.act }" />
										</t:column>
										<t:column headerstyleClass="left">
											<a4j:commandLink reRender="tablaactenf"
												actionListener="#{controlEef.enf.delAct }">
												<h:graphicImage url="/img/iconos/minus.png"
													title="#{ms.eliminar }" width="16" height="16"
													style="border: 0px;" />
											</a4j:commandLink>
										</t:column>
									</t:dataTable>
								</h:panelGrid>
								<h:outputLabel value="#{ms.eef_enf_sedacion }" />
								<h:panelGrid cellpadding="0" cellspacing="0" columns="2">
									<h:selectBooleanCheckbox value="#{controlEef.enf.sedacion1 }" />
									<h:outputLabel value="#{ms.eef_enf_sedacion_reminf }" />
									<h:selectBooleanCheckbox value="#{controlEef.enf.sedacion2 }" />
									<h:outputLabel value="#{ms.eef_enf_sedacion_midalo }" />
									<h:selectBooleanCheckbox value="#{controlEef.enf.sedacion3 }" />
									<h:outputLabel value="#{ms.eef_enf_sedacion_propof }" />
								</h:panelGrid>
								<h:outputLabel value="#{ms.eef_enf_otros_farma }" />
								<h:inputText size="60" value="#{controlEef.enf.farmacos }" maxlength="200"/>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignTop50,alignTop50"
							width="90%">
							<h:outputLabel value="#{ms.eef_enf_cv_desfi }"
								style="font-weight: bold;" />
							<h:outputLabel value="#{ms.eef_enf_servicio_cama }"
								style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;"
								columns="2">
								<h:selectOneRadio value="#{controlEef.enf.cv }">
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_cv_desfi_si }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_cv_desfi_no }" />
								</h:selectOneRadio>
								<h:outputLabel value="" />
								<h:outputLabel value="#{ms.eef_enf_cv_unidades }" style="font-weight: bold;" />
								<h:panelGrid columns="4">
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:outputLabel value="#{ms.eef_enf_cv_title } 1" />
										<h:inputText size="5" value="#{controlEef.enf.cv1 }" maxlength="20"/>
									</h:panelGrid>
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:outputLabel value="#{ms.eef_enf_cv_title } 2" />
										<h:inputText size="5" value="#{controlEef.enf.cv2 }" maxlength="20"/>
									</h:panelGrid>
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:outputLabel value="#{ms.eef_enf_cv_title } 3" />
										<h:inputText size="5" value="#{controlEef.enf.cv3 }" maxlength="20"/>
									</h:panelGrid>
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:outputLabel value="#{ms.eef_enf_cv_title } 4" />
										<h:inputText size="5" value="#{controlEef.enf.cv4 }" maxlength="20"/>
									</h:panelGrid>
								</h:panelGrid>
								<h:outputLabel value="#{ms.eef_enf_motivo }:" />
								<h:selectOneRadio value="#{controlEef.enf.motivo }">
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_motivo_op1 }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_motivo_op2 }" />
									<f:selectItem itemValue="3" itemLabel="#{ms.eef_enf_motivo_op3 }" />
								</h:selectOneRadio>
								<h:outputLabel value="#{ms.eef_enf_exito }:" />
								<h:selectOneRadio value="#{controlEef.enf.exito }">
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_enf_exito_si }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_enf_exito_no }" />
								</h:selectOneRadio>
								<h:outputLabel value="#{ms.eef_enf_obs }:" />
								<h:inputTextarea cols="50" rows="3"
									value="#{controlEef.enf.observ }" id="comentariosEnfObs">
									<f:validateLength maximum="2000" />
								</h:inputTextarea>	
								<h:message for="comentariosEnfObs" style="color:red" />
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText size="30" value="#{controlEef.enf.destino }" maxlength="200"/>
							</h:panelGrid>
						</h:panelGrid>
						<h:outputLabel value="#{ms.eef_enf_cuidados_post }" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputTextarea rows="5" cols="160"
								value="#{controlEef.enf.cuidados }" id="comentariosEnfCuid">
								<f:validateLength maximum="4000" />
							</h:inputTextarea>	
							<h:message for="comentariosEnfCuid" style="color:red" />
						</h:panelGrid>
					</h:panelGrid>
			</h:panelGrid>
</ui:composition>

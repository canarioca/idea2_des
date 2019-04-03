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
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panCardioVersion">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicocv">
							<h:outputLabel value="#{ms.cve_title }"
								style="color: white;" />
							<h:panelGrid columns="8" columnClasses="right">
								<h:outputLabel value="#{ms.cve_nproc }" style="color: white;" />
								<h:inputText size="10" maxlength="5"
									value="#{controlCardioversion.cv.ncv}" />
								<h:outputLabel value="#{ms.cve_fecha }" style="color: white;" />
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{controlCardioversion.cv.fecha}" />
								<a4j:commandLink style="text-align: right;"
									reRender="panCardioVersion"
									actionListener="#{controlCardioversion.limpia }">
									<h:graphicImage url="/img/iconos/new.png" style="border:0px;"
										title="#{ms.cve_limpiar_nueva }" width="22"
										height="22" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panCardioVersion,tablaPacientesBdu,panicocv"
									onclick="javascript:Richfaces.showModalPanel('episodios');"
									actionListener="#{controlCardioversion.preguarda }"
									rendered="#{controlCardioversion.cv.episodio eq null and controlCardioversion.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panCardioVersion,panicocv"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlCardioversion.guarda }"
									rendered="#{controlCardioversion.cv.episodio ne null and controlCardioversion.editable}">
									<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;"
										title="#{ms.guardar }" />
								</a4j:commandLink>
								<h:commandLink
									actionListener="#{controlCardioversion.imprimeInforme}"
									rendered="#{controlCardioversion.cv.codigoCardioversion ne null }"
									target="_blank" action="recarga">
									<h:graphicImage value="/img/iconos/informe_especial.png" width="22"
										height="22" style="border:none;" title="#{ms.imprimir_informe }" />
								</h:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panCardioVersion,panicocv"
									onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlCardioversion.eliminarCardioversion }"
									rendered="#{controlCardioversion.cv.codigoCardioversion ne null and loginForm.acceso.privs.borrado eq 1}">
									<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
										title="#{ms.eliminar }" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					<rich:tabPanel switchType="client">
						<rich:tab label="#{ms.cve_tab1_title }">
							<a4j:include viewId="paneles/indicacion.jsp"/>
						</rich:tab>
						<rich:tab label="#{ms.cve_tab1_title }" rendered="false">
							<h:panelGrid columns="3" width="100%"
								columnClasses="alignTop,alignTop,alignTop">
								<h:outputLabel value="#{ms.cve_tab1_ind_title }" style="font-weight: bold;" />
								<h:outputLabel value="#{ms.cve_tab1_proc_title }" style="font-weight: bold;" />
								<h:outputLabel value="#{ms.cve_tab1_prev_title }" style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="2" width="70%" columnClasses="left,left">
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.fibrilacionb }" />
									<h:outputLabel value="#{ms.cve_tab1_ind_op1 }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.fluteratipicob}" />
									<h:outputLabel value="#{ms.cve_tab1_ind_op2 }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.flutertipicob}" />
									<h:outputLabel value="#{ms.cve_tab1_ind_op3 }" />
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="2" width="70%" columnClasses="left,left">
									<h:selectOneMenu value="#{controlCardioversion.cv.idprocedencia}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_proc_op1 }" itemValue="1"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_proc_op0 }" itemValue="0"/>
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="4" width="80%" columnClasses="left,left,left,left">
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.cvenob}" />
									<h:outputLabel value="#{ms.cve_tab1_prev_opNo }" />
									<h:outputLabel value="" />
									<h:outputLabel value="" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.cvesib}" />
									<h:outputLabel value="#{ms.cve_tab1_prev_opSi }" />
									<h:outputLabel value="#{ms.cve_tab1_prev_opSi_numero }" />
									<h:inputText size="6" maxlength="6"
										value="#{controlCardioversion.cv.cvenumero}" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.cveeficazb}" />
									<h:outputLabel value="#{ms.cve_tab1_prev_opSi_eficaz }" />
								</h:panelGrid>

								<rich:spacer width="10" />
								<rich:spacer width="10" />
								<rich:spacer width="10" />

								<h:outputLabel value="#{ms.cve_tab1_abl_title }" style="font-weight: bold;" />
								<h:outputLabel value="#{ms.cve_tab1_nyha_title }" style="font-weight: bold;" />
								<h:outputLabel value="#{ms.cve_tab1_cardiop_title }" style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									width="70%">
									<h:selectOneMenu value="#{controlCardioversion.cv.idablacion}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_abl_op1 }" itemValue="1"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_abl_op0 }" itemValue="0"/>
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="2" width="70%" columnClasses="left">
									<h:inputText size="5" value="#{controlCardioversion.cv.nyha}" />
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									width="80%" columns="3">
									<h:selectOneMenu value="#{controlCardioversion.cv.idcardiopatia}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_cardiop_op1 }" itemValue="1"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_cardiop_op0 }" itemValue="0"/>
										<a4j:support event="onclick" reRender="panelCardiopatiaCV" ajaxSingle="true"/>
									</h:selectOneMenu>
									<h:panelGrid id="panelCardiopatiaCV" columns="2">
										<h:outputLabel value="#{ms.cve_tab1_cardiop_tipo }" rendered="#{controlCardioversion.cv.idcardiopatia eq 1}"/>
										<h:inputText size="30"
											value="#{controlCardioversion.cv.tipocardio }" rendered="#{controlCardioversion.cv.idcardiopatia eq 1}"/>
									</h:panelGrid>									
								</h:panelGrid>

								<rich:spacer width="10" />
								<rich:spacer width="10" />
								<rich:spacer width="10" />

								<h:outputLabel value="#{ms.cve_tab1_antecedentes }" style="font-weight: bold;" />
								<h:outputLabel value="#{ms.cve_tab1_tabaco }" style="font-weight: bold;" />
								<h:outputLabel value="" style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="4" width="70%"
									columnClasses="alignTop,alignTop,alignTop,alignTop">
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.htab}" />
									<h:outputLabel value="#{ms.cve_tab1_antecedentes_hta }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.epocb}" />
									<h:outputLabel value="#{ms.cve_tab1_antecedentes_epoc }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.mpdefinitivob}" />
									<h:outputLabel value="#{ms.cve_tab1_antecedentes_mpdef }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.acvb}" />
									<h:outputLabel value="#{ms.cve_tab1_antecedentes_acv }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.diabetesb}" />
									<h:outputLabel value="#{ms.cve_tab1_antecedentes_diab }" />
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									width="70%">
									<h:selectOneRadio layout="pageDirection" rendered="false"
										value="#{controlCardioversion.cv.idtabaco}">
										<f:selectItem itemLabel="Si" itemValue="1" />
										<f:selectItem itemLabel="No" itemValue="0" />
										<f:selectItem itemLabel="Exfumador" itemValue="2" />
									</h:selectOneRadio>
									<h:selectOneMenu value="#{controlCardioversion.cv.idtabaco}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_tabaco_op1 }" itemValue="1"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_tabaco_op0 }" itemValue="0"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_tabaco_op2 }" itemValue="2"/>
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>

							<rich:spacer width="10" />

							<h:panelGrid width="100%">
								<h:outputLabel value="#{ms.cve_tab1_medhab_title }"
									style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="12" width="80%"
									columnClasses="alignMiddle,alignMiddle,alignMiddle,alignMiddle,alignMiddle,alignMiddle">
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.digoxinab}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_digox }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.bbloqb}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_bbloq }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.antcab}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_antca }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.amiodb}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_amiod }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.aasb}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_aas }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.dronedaronab}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_drone }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.sotalolb}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_sotal }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.claseib}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_clase1 }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.diureticosb}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_diuret }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.iecab}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_ieca }" />
									<h:selectBooleanCheckbox
										value="#{controlCardioversion.cv.araiib}" />
									<h:outputLabel value="#{ms.cve_tab1_medhab_ara2 }" />
								</h:panelGrid>

								<rich:spacer width="10" />
								<rich:spacer width="10" />

								<h:outputLabel value="#{ms.cve_tab1_durfafl_title }"
									style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									width="70%">
									<h:selectOneRadio value="#{controlCardioversion.cv.idduracion}"
										rendered="false">
										<f:selectItem itemLabel="&lt;1 mes" itemValue="0" />
										<f:selectItem itemLabel="&lt;6 meses" itemValue="1" />
										<f:selectItem itemLabel="&lt;1 año" itemValue="2" />
										<f:selectItem itemLabel="&gt;1 año" itemValue="3" />
										<f:selectItem itemLabel="Desconocido" itemValue="4" />
									</h:selectOneRadio>
									<h:selectOneMenu value="#{controlCardioversion.cv.idduracion}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1"/>
										<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op0 }" itemValue="0" />
										<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op1 }" itemValue="1" />
										<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op2 }" itemValue="2" />
										<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op3 }" itemValue="3" />
										<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op4 }" itemValue="4" />
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>

							<rich:spacer width="10" />

							<h:panelGrid columns="3" width="100%"
								columnClasses="alignTop,alignTop,alignTop">
								<h:outputLabel value="#{ms.cve_tab1_ecg_title }" style="font-weight: bold;" />
								<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_title }"
									style="font-weight: bold;" />
								<h:outputLabel value="" style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									columns="2" width="70%" columnClasses="alignTop,alignTop">
									<h:outputLabel value="#{ms.cve_tab1_ecg_fe }" />
									<h:inputText size="5" value="#{controlCardioversion.cv.fe}" />
									<h:outputLabel value="#{ms.cve_tab1_ecg_ai }" />
									<h:inputText size="5" value="#{controlCardioversion.cv.al}" />
									<h:outputLabel value="#{ms.cve_tab1_ecg_otros }" />
									<h:inputText size="25"
										value="#{controlCardioversion.cv.otroseco}" />
								</h:panelGrid>
								<h:panelGrid>
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										columns="2" width="80%" columnClasses="alignTop,alignTop">
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.avtab}" />
										<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_atk }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.eteb}" />
										<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_ete }" />
									</h:panelGrid>
									<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
										<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_otros }" style="font-weight: bold;" />
										<a4j:commandLink reRender="tablaOtrostto"
											actionListener="#{controlCardioversion.cv.addOtros }">
											<h:graphicImage value="/img/iconos/add.png" width="16"
												height="16" style="border:0;"
												title="#{ms.cve_tab1_ttoantitromb_otros_add }" />
										</a4j:commandLink>
									</h:panelGrid>
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										id="tablaOtrostto" width="100%">
										<t:dataTable styleClass="hor-minimalist-b" var="linea"
											width="100%" value="#{controlCardioversion.cv.tratamientos }"
											binding="#{controlCardioversion.cv.binotr }">
											<t:column width="30%" headerstyleClass="left">
												<f:facet name="header">
													<h:outputText value="#{ms.cve_tab1_ttoantitromb_otros_trat }" />
												</f:facet>
												<h:inputText id="Tto" size="30" value="#{linea.tmpString1 }" />
											</t:column>
											<t:column headerstyleClass="left">
												<a4j:commandLink reRender="tablaOtrostto"
													actionListener="#{controlCardioversion.cv.delOtros }">
													<h:graphicImage url="/img/iconos/minus.png"
														title="#{ms.cve_tab1_ttoantitromb_otros_del }" width="16" height="16"
														style="border: 0px;" />
												</a4j:commandLink>
											</t:column>
										</t:dataTable>
									</h:panelGrid>
								</h:panelGrid>
							</h:panelGrid>
						</rich:tab>
						<rich:tab label="#{ms.cve_tab2_title }">
							<h:panelGrid width="100%">
								<h:outputLabel value="#{ms.cve_tab2_tipoproc_title }" style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									width="70%">
									<h:selectOneMenu value="#{controlCardioversion.cv.tipoprocedimiento}">
										<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0"/>
										<f:selectItem itemLabel="#{ms.cve_tab2_tipoproc_op1 }" itemValue="1"/>
										<f:selectItem itemLabel="#{ms.cve_tab2_tipoproc_op2 }" itemValue="2"/>
									</h:selectOneMenu>
								</h:panelGrid>
								<h:outputLabel value="#{ms.cve_tab2_enermat_title }"
									style="font-weight: bold;" />
								<h:panelGrid style="border-top: solid 1px;border-color: black;"
									width="70%">
									<h:panelGrid columns="15">
										<h:outputLabel value="#{ms.cve_tab2_secuencia_title }" />
										<h:inputText size="5" value="#{controlCardioversion.cv.sec1}" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.idsec1b}" />
										<h:outputLabel value="/" />
										<h:inputText size="5" value="#{controlCardioversion.cv.sec2}" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.idsec2b}" />
										<h:outputLabel value="/" />
										<h:inputText size="5" value="#{controlCardioversion.cv.sec3}" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.idsec3b}" />
										<h:outputLabel value="/" />
										<h:inputText size="5" value="#{controlCardioversion.cv.sec4}" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.idsec4b}" />
										<h:outputLabel value="/" />
										<h:inputText size="5" value="#{controlCardioversion.cv.sec5}" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.idsec5b}" />
									</h:panelGrid>
									<h:panelGrid columns="8">
										<h:outputLabel value="#{ms.cve_tab2_parches_title }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.parchesb}" />
										<rich:spacer width="20px" />
										<h:outputLabel value="#{ms.cve_tab2_atrop_title }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.atropinab}" />
										<rich:spacer width="20px" />
										<h:outputLabel value="#{ms.cve_tab2_estempext_title }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.estimtmpextb}" />
									</h:panelGrid>
								</h:panelGrid>
								<h:panelGrid width="100%">
									<h:panelGrid columns="2">
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.exitotransb}" />
										<h:outputLabel value="#{ms.cve_tab2_exitotrans_title }"
											style="font-weight: bold;" />
									</h:panelGrid>
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="70%" columns="3">
										<h:panelGrid columns="2">
											<h:outputLabel value="Nº" />
											<h:inputText size="5"
												value="#{controlCardioversion.cv.numexitotrans}" />
										</h:panelGrid>
										<h:panelGrid columns="2">
											<h:outputLabel value="#{ms.cve_tab2_duracions_title }" />
											<h:inputText size="5"
												value="#{controlCardioversion.cv.duracionextrans}" />
										</h:panelGrid>
										<h:panelGrid columns="2">
											<h:outputLabel value="#{ms.cve_tab2_energia_title }" />
											<h:inputText size="10"
												value="#{controlCardioversion.cv.energiaextrans}" />
										</h:panelGrid>
									</h:panelGrid>
								</h:panelGrid>

								<h:panelGrid width="100%">
									<h:outputLabel value="#{ms.cve_tab2_exitofinal_title }" style="font-weight: bold;" />
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="70%">
										<h:selectOneRadio rendered="false"
											value="#{controlCardioversion.cv.idexitofinal}">
											<f:selectItem itemLabel="Si" itemValue="1" />
											<f:selectItem itemLabel="No" itemValue="0" />
										</h:selectOneRadio>
										<h:selectOneMenu value="#{controlCardioversion.cv.idexitofinal}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion })" itemValue="-1"/>
											<f:selectItem itemLabel="#{ms.cve_tab2_exitofinal_op1 }" itemValue="1"/>
											<f:selectItem itemLabel="#{ms.cve_tab2_exitofinal_op0 }" itemValue="0"/>
										</h:selectOneMenu>
									</h:panelGrid>
								</h:panelGrid>
								<h:panelGrid width="100%">
									<h:outputLabel value="#{ms.cve_tab2_complicacion }" style="font-weight: bold;" />
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										width="70%" columns="3">
										<h:selectOneRadio rendered="false"
											value="#{controlCardioversion.cv.idcomplicacion}">
											<f:selectItem itemLabel="No" itemValue="0" />
											<f:selectItem itemLabel="Si" itemValue="1" />
										</h:selectOneRadio>
										<h:selectOneMenu value="#{controlCardioversion.cv.idcomplicacion}">
											<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1"/>
											<f:selectItem itemLabel="#{ms.cve_tab2_complicacion_op1 }" itemValue="1"/>
											<f:selectItem itemLabel="#{ms.cve_tab2_complicacion_op0 }" itemValue="0"/>
											<a4j:support event="onclick" reRender="panelComplicacionesCV" ajaxSingle="true"/>
										</h:selectOneMenu>
										<h:panelGrid id="panelComplicacionesCV" columns="2">
											<h:outputLabel value="#{ms.cve_tab2_complicacion_esp }" rendered="#{controlCardioversion.cv.idcomplicacion eq 1}"/>
											<h:inputText size="25"
												value="#{controlCardioversion.cv.complicacion}" rendered="#{controlCardioversion.cv.idcomplicacion eq 1}"/>
										</h:panelGrid>								
									</h:panelGrid>
								</h:panelGrid>

								<h:panelGrid width="100%">
									<h:outputLabel value="#{ms.cve_tab2_madalta_title }" style="font-weight: bold;" />
									<h:panelGrid style="border-top: solid 1px;border-color: black;"
										columns="6" width="70%"
										columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop,alignTop">
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.bbaltab}" />
										<h:outputLabel value="#{ms.cve_tab2_madalta_bbloq }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.amiodaronaaltab}" />
										<h:outputLabel value="#{ms.cve_tab2_madalta_amiod }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.solatololaltab}" />
										<h:outputLabel value="#{ms.cve_tab2_madalta_sotal }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.avtaaltab}" />
										<h:outputLabel value="#{ms.cve_tab2_madalta_atk }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.claseialtab}" />
										<h:outputLabel value="#{ms.cve_tab2_madalta_clase1 }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.iecaaltab}" />
										<h:outputLabel value="#{ms.cve_tab2_madalta_ieca }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.araaltab}" />
										<h:outputLabel value="#{ms.cve_tab2_madalta_ara2 }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.dronedaronaaltab}" />
										<h:outputLabel value="#{ms.cve_tab2_madalta_drone }" />
										<h:selectBooleanCheckbox
											value="#{controlCardioversion.cv.otrosaltab}">
											<a4j:support event="onclick" reRender="panelOtrosMedAltaCV" ajaxSingle="true"/>
										</h:selectBooleanCheckbox>
										<h:panelGrid columns="2" cellpadding="0" cellspacing="0" id="panelOtrosMedAltaCV">
											<h:outputLabel value="#{ms.cve_tab2_madalta_otros }" />
											<h:inputText size="25" rendered="#{controlCardioversion.cv.otrosaltab eq true}"
												value="#{controlCardioversion.cv.otrosmedalta}" />
										</h:panelGrid>
									</h:panelGrid>
									<h:outputLabel value="#{ms.cve_tab2_comentarios }" style="font-weight: bold;" />
									<h:panelGrid style="border-top: solid 1px;border-color: black;" width="70%">
										<h:inputTextarea value="#{controlCardioversion.cv.comentarios}" rows="5" cols="100">
											<f:validateLength maximum="4000" />
										</h:inputTextarea>
									</h:panelGrid>
								</h:panelGrid>
							</h:panelGrid>
						</rich:tab>
					</rich:tabPanel>
				</rich:panel>
			</h:panelGrid>
			<rich:modalPanel id="episodios" autosized="true" minHeight="350" minWidth="600" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.cve_episodios_modal_title }"
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
				<ui:include src="/ventanas/cardioversion/episodios.jsp" />
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
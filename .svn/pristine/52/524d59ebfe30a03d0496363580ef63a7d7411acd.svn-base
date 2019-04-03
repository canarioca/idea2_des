<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">
	
	<ui:define name="contenido">
		<h:form id="inicioProtocoloSincope">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%" style="margin-top: 15px;" id="panProtocoloSincope">
				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo" warnClass="hvn_msjAviso" />
				<rich:panel style="background-color: #ffffff;
                     background-repeat: no-repeat;  background-position:right bottom;">
                     <f:facet name="header">
                     	<h:panelGrid columns="7" width="65%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" id="panicoprotsincope">
							<h:outputLabel value="#{ms.prot_sincope_title }" style="color: white;" />
							<a4j:commandLink style="text-align: right;" reRender="panProtocoloSincope,tablaPacientesBdu,panicoprotsincope" 
	                 			onclick="if (!confirm('#{ms.warn_guarda}')) return false;javascript:Richfaces.showModalPanel('buscando');" action="irProtocoloSincope"
	                 			oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
	                 			actionListener="#{controlProtocolos.guardaProtSincope }">
								<h:graphicImage url="/img/iconos/guardar.png" style="border:0px;" title="#{ms.guardar }"/>
							</a4j:commandLink>                 		
							<a4j:commandLink style="text-align: right;" reRender="panProtocoloSincope"
								onclick="if (!confirm('#{ms.warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								actionListener="#{controlProtocolos.eliminarProtSincope }" action="menuprincipal"
								rendered="#{controlProtocolos.prSincope.idprotsincope ne null and loginForm.acceso.privs.borrado eq 1}">
								<h:graphicImage url="/img/iconos/borra.png" style="border:0px;" width="24" height="24"
									title="#{ms.eliminar }" />
							</a4j:commandLink>
							<h:commandLink actionListener="#{controlProtocolos.imprimirProtSincope}"
								rendered="#{controlProtocolos.prSincope.idprotsincope ne null }" target="_blank">
								<h:graphicImage value="/img/iconos/informe_especial.png"
									width="22" height="22" style="border:none;" title="#{ms.imprimir_informe }" />
							</h:commandLink>														
						</h:panelGrid>
                     </f:facet>
                     <h:panelGrid width="100%">
                     	<h:panelGrid id="timelineProtSincope" width="100%">
                     		<script type="text/javascript" src="/idea/js/jsapi.js"/>
							<script type="text/javascript" src="/idea/js/timeline.js"/>
							<script type="text/javascript" src="/idea/js/timeline-locales.js"/>
							<h:panelGrid width="100%" id="panelTimelineProtSincope" rendered="#{loginForm.acceso.idrolacceso ne 5 }">							
								<input type="hidden" id="jsonPrtSinc" value="#{controlProtocolos.json }"/>
								<input type="hidden" id="jsonstartPrtSinc" value="#{controlProtocolos.jsonstart }"/>
								<input type="hidden" id="jsonendPrtSinc" value="#{controlProtocolos.jsonend }"/>
								<h:outputLabel value="#{ms.pat_procs_msg_1 }" rendered="#{empty controlProtocolos.json and controlPacientes.pacienteSelect.nhc ne null}"/>
								<h:outputLabel value="#{ms.pat_procs_msg_2 }" rendered="#{controlPacientes.pacienteSelect.nhc eq null }"/>
								<div id="mytimelinePrtSinc"/>
								<script type="text/javascript">
									var jsonstart = document.getElementById('jsonstartPrtSinc').value;
								    var jsonend = document.getElementById('jsonendPrtSinc').value;
								 	// specify options
							        options = {
							          //start: new Date(jsonstart.substring(0,4),jsonstart.substring(5,7),jsonstart.substring(8,11)),
							          //end: new Date(jsonend.substring(0,4),jsonend.substring(5,7),jsonend.substring(8,11)),
							          width:  "95%",
							          height: "99%",
							          style: "box", 
							          minHeight: 300,
							          editable: false,   // enable dragging and editing events
						              enableKeys: true,
						              axisOnTop: false,
						              showNavigation: true,
						              showButtonNew: true,
						              animate: true,
						              animateZoom: true,
						              layout: "box"
							        };
							        var dataJSON = [];
							    	var obj = document.getElementById('jsonPrtSinc').value;					    	
								    //alert(obj);
								    var spl = obj.split('_');
								    for(var i=0;i &lt; spl.length;i++){
								    	var item = spl[i].split('--');
								    	var date = item[0];var content = item[1];
								    	dataJSON.push({'start':new Date(item[0].substring(0,4),item[0].substring(5,7),item[0].substring(8,11)),'content':content.toString()});
								    }  
								    // Instantiate our timeline object.
								    var timeline = new links.Timeline(document.getElementById('mytimelinePrtSinc'));	
								    options.locale = "es_ES";
								    // Draw our timeline with the created data and options
								    timeline.draw(dataJSON, options);
								    // Called when the Visualization API is loaded.
								    function drawVisualization() {	       
								    	// specify options
								        options = {
								          width:  "95%",
								          height: "99%",
								          style: "box", 
								          minHeight: 300,
								          editable: false,   // enable dragging and editing events
							              enableKeys: true,
							              axisOnTop: false,
							              showNavigation: true,
							              showButtonNew: true,
							              animate: true,
							              animateZoom: true,
							              layout: "box"
								        };
								        var dataJSON = [];
								    	var obj = document.getElementById('jsonPrtSinc').value;
									    //alert(obj);
									    var spl = obj.split('_');
									    for(var i=0;i &lt; spl.length;i++){
									    	var item = spl[i].split('-');
									    	var date = item[0];var content = item[1];
									    	dataJSON.push({'start':new Date(item[0].substring(0,4),item[0].substring(5,7),item[0].substring(8,11)),'content':content.toString()});
									    }  
									    // Instantiate our timeline object.
									    var timeline = new links.Timeline(document.getElementById('mytimelinePrtSinc'));	
									    options.locale = "es_ES";
									    // Draw our timeline with the created data and options
									    timeline.draw(dataJSON, options);
								    }	
								</script>
							</h:panelGrid>
                     	</h:panelGrid>
                     	<h:panelGrid id="panProtSincopeInfo">
                 			<h:panelGrid columns="2" columnClasses="alignTop,alignTop,alignTop,alignTop">
                 				<h:outputLabel value="#{ms.prot_sincope_perfil_riesgo_op1 }" styleClass="protSincopePerfilBajo"
                 					title="#{ms.prot_sincope_perfil_riesgo }"
                 					rendered="#{controlProtocolos.prSincope.perfilRiesgo eq 1}"/>
                 				<h:outputLabel value="#{ms.prot_sincope_perfil_riesgo_op2 }" styleClass="protSincopePerfilMedio"
                 					title="#{ms.prot_sincope_perfil_riesgo }"
                 					rendered="#{controlProtocolos.prSincope.perfilRiesgo eq 2}"/>
                 				<h:outputLabel value="#{ms.prot_sincope_perfil_riesgo_op3 }" styleClass="protSincopePerfilAlto"
                 					title="#{ms.prot_sincope_perfil_riesgo }"
                 					rendered="#{controlProtocolos.prSincope.perfilRiesgo eq 3}"/>
                 				<h:panelGrid>
	                 				<h:outputLabel value="#{ms.prot_sincope_orientacion_diag }" style="font-weight: bold;"/>
	                 				<h:panelGrid style="border-top: solid 1px;border-color: black;">
	                 					<h:selectOneMenu value="#{controlProtocolos.prSincope.orientacionDiag}" disabled="true">
											<f:selectItem itemLabel="" itemValue="0" />
											<f:selectItem itemLabel="#{ms.prot_sincope_orientacion_diag_op1 }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.prot_sincope_orientacion_diag_op2 }" itemValue="2" />
											<f:selectItem itemLabel="#{ms.prot_sincope_orientacion_diag_op3 }" itemValue="3" />
										</h:selectOneMenu>
	                 				</h:panelGrid>
                 				</h:panelGrid>
                 			</h:panelGrid>
                     	</h:panelGrid>
                     	<rich:tabPanel switchType="client" selectedTab="nameAltaProtSincope">
                     	 	<rich:tab label="#{ms.prot_sincope_tab1_alta_title }">
								<h:panelGrid width="100%">
									<h:panelGrid columns="2">
										<h:outputLabel value="#{ms.prot_sincope_alta_fecha }" style="font-weight: bold;"/>
										<h:outputLabel value="#{ms.prot_sincope_alta_operador }" style="font-weight: bold;"/>
										<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
											showWeeksBar="false" direction="bottom-left" value="#{controlProtocolos.prSincope.alta.fechaAlta }" />
										<h:selectOneMenu value="#{controlProtocolos.prSincope.alta.operador }">
											<f:selectItems value="#{controlEef.primerOperador }" />
										</h:selectOneMenu>
									</h:panelGrid>
									<h:panelGrid width="100%">
										<h:outputLabel value="#{ms.prot_sincope_alta_condiciones_title }" style="font-weight: bold;"/>
										<h:panelGrid columns="2">		
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.perdconoB }"/>
											<h:outputLabel value="#{ms.prot_sincope_alta_condiciones_op1_title }" />
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.recespB }"/>
											<h:outputLabel value="#{ms.prot_sincope_alta_condiciones_op2_title }" />
										</h:panelGrid>
									</h:panelGrid>
									<hr/>
									<h:panelGrid id="panProtSincopeAltaPrimerEpisodio">
										<h:panelGrid columns="2">
											<h:outputLabel value="#{ms.prot_sincope_alta_primer_epi_title }" style="font-weight: bold;"/>
											<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.alta.primepi }">
												<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
												<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
												<a4j:support event="onchange" reRender="panProtSincopeAltaPrimerEpisodio" ajaxSingle="true"/>
											</h:selectOneRadio>
										</h:panelGrid>
										<h:panelGrid columns="5" rendered="#{controlProtocolos.prSincope.alta.primepi eq 0}">
											<h:outputLabel value="#{ms.prot_sincope_alta_num_epi_prev_title }" style="font-weight: bold;"/>
											<h:inputText value="#{controlProtocolos.prSincope.alta.numepiprev}" size="3"/>
											<h:outputLabel value="#{ms.prot_sincope_alta_prim_epi_title }" style="font-weight: bold;"/>
											<h:inputText value="#{controlProtocolos.prSincope.alta.primerepi}" size="4"/>
											<h:outputLabel value="#{ms.prot_sincope_alta_prim_epi_title_2 }"/>
										</h:panelGrid>
									</h:panelGrid>
									<hr/>
									<h:panelGrid columns="2" width="100%" columnClasses="alignTop,alignTop">
										<h:outputLabel value="#{ms.prot_sincope_alta_precip_title }" style="font-weight: bold;"/>
										<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_title }" style="font-weight: bold;"/>
										<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;" width="100%" cellspacing="0" >
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaCalorB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op1 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaAgloB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op2 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaOrtoB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op3 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaPostB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op4 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaAlcoholB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op5 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaVenopB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op6 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaEmocionB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op7 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaSitB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op8 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaAyunoB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op9 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.preciAltaEmbB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_precip_op10 }"/>
										</h:panelGrid>
										<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;" width="100%" cellspacing="0" >
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaMareoB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op1 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaFatigaB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op2 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaVisionB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op3 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaSudorB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op4 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaNauseaB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op5 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaFaltaaireB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op6 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaPalidezB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op7 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaFrioB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op8 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaDolorabB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op9 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaCefalB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op10 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaPalpB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op11 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaDolortorB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op12 }"/>
											<h:selectBooleanCheckbox value="#{controlProtocolos.prSincope.alta.prodAltaHipervB}">
												<a4j:support event="onchange" actionListener="#{controlProtocolos.calculaOrientacionDiagnostica }"
													reRender="panProtSincopeInfo" ajaxSingle="true"/>
											</h:selectBooleanCheckbox>
											<h:outputLabel value="#{ms.prot_sincope_alta_prodrom_op13 }"/>
										</h:panelGrid>	
									</h:panelGrid>
									<hr/>
									<h:panelGrid width="100%" id="panProtSincopePruebasDiagIni">
										<t:fieldset legend="#{ms.prot_sincope_alta_pdiag_ini_title }">
											<h:panelGrid columns="3" columnClasses="alignTop,alignTop,alignTop">
												<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_hclin }" style="font-weight: bold;"/>
												<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.alta.prdiaginiAltaHc}">
													<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
													<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
												</h:selectOneRadio>
												<h:outputLabel value=""/>
												<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_masaje_sen_car }" style="font-weight: bold;"/>
												<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.alta.prdiaginiAltaSc}">
													<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
													<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
													<a4j:support event="onchange" reRender="panProtSincopePruebasDiagIni" ajaxSingle="true"/>
												</h:selectOneRadio>
												<h:panelGrid>
													<h:panelGrid>
														<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_masaje_sen_car_res }" style="font-weight: bold;"
															rendered="#{controlProtocolos.prSincope.alta.prdiaginiAltaSc eq 1 }"/>
													</h:panelGrid>
													<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
														rendered="#{controlProtocolos.prSincope.alta.prdiaginiAltaSc eq 1 }">
														<h:selectOneMenu value="#{controlProtocolos.prSincope.alta.prdiaginiAltaScRes}">
															<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
															<f:selectItem itemLabel="#{ms.prot_sincope_alta_pdiag_ini_masaje_sen_car_res_0 }" itemValue="0" />
															<f:selectItem itemLabel="#{ms.prot_sincope_alta_pdiag_ini_masaje_sen_car_res_1 }" itemValue="1" />
														</h:selectOneMenu>
													</h:panelGrid>
												</h:panelGrid>
												<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort }" style="font-weight: bold;"/>
												<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.alta.prdiaginiAltaTestort}">
													<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
													<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
													<a4j:support event="onchange" reRender="panProtSincopePruebasDiagIni" ajaxSingle="true"/>
												</h:selectOneRadio>
												<h:panelGrid>
													<h:panelGrid columns="4">
														<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
															rendered="#{controlProtocolos.prSincope.alta.prdiaginiAltaTestort eq 1 and controlProtocolos.prSincope.idprotsincope ne null}"/>
														<a4j:commandLink actionListener="#{controlProtocolos.verTestOrto}"
															onclick="javascript:Richfaces.showModalPanel('buscando');"
															title="#{ms.ver_registro }" action="irTestOrto"
															rendered="#{controlProtocolos.prSincope.alta.prdiaginiAltaTestort eq 1 and controlProtocolos.prSincope.idprotsincope ne null}">
															<h:graphicImage value="/img/iconos/bpm.png" style="border: 0px;"
																width="22" height="22"/>
														</a4j:commandLink>
														<a4j:commandLink actionListener="#{controlProtocolos.desvincularTestOrto}"
															onclick="javascript:Richfaces.showModalPanel('buscando');"
															reRender="panProtocoloSincope,panicoprotsincope,panProtSincopePruebasDiagIni"
															title="#{ms.desvincular }" action="irProtocoloSincope"
															rendered="#{controlProtocolos.prSincope.alta.prdiaginiAltaTestort eq 1 and controlProtocolos.prSincope.idprotsincope ne null}">
															<h:graphicImage value="/img/aplicacion/icoCancelar.png" style="border: 0px;"
																width="16" height="16"/>
														</a4j:commandLink>
														<a4j:commandLink actionListener="#{controlTestOrtostatismo.inicia}"
															onclick="javascript:Richfaces.showModalPanel('buscando');"
															title="#{ms.aniadir }" action="irTestOrto"
															rendered="#{controlProtocolos.prSincope.alta.prdiaginiAltaTestort ne 1 and controlProtocolos.prSincope.idprotsincope ne null}">
															<h:graphicImage value="/img/iconos/add.png" style="border: 0px;"
																width="20" height="20"/>
														</a4j:commandLink>
													</h:panelGrid>
													<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
														rendered="#{controlProtocolos.prSincope.alta.prdiaginiAltaTestort eq 1 and controlProtocolos.prSincope.idprotsincope ne null}">
														<h:panelGrid columns="4" rendered="#{controlProtocolos.prSincope.alta.prdiaginiAltaTestort eq 1}">
															<h:outputLabel value=""/>
															<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_dec }" />
															<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_ort }" />
															<h:outputLabel value="#{ms.test_orto_variacion }" style="font-weight: bold;"/>
															<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_tas }" title="#{ms.prot_sincope_alta_pdiag_ini_test_ort_tas_title }"/>
															<h:inputText value="#{controlProtocolos.prSincope.testOrto.decTas }" size="5" disabled="true"/>
															<h:inputText value="#{controlProtocolos.prSincope.testOrto.ortTas }" size="5" disabled="true"/>
															<h:inputText value="#{controlProtocolos.prSincope.testOrto.varTas }" size="5" disabled="true"/>
															<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_tad }" title="#{ms.prot_sincope_alta_pdiag_ini_test_ort_tad_title }"/>
															<h:inputText value="#{controlProtocolos.prSincope.testOrto.decTad }" size="5" disabled="true"/>
															<h:inputText value="#{controlProtocolos.prSincope.testOrto.ortTad }" size="5" disabled="true"/>
															<h:inputText value="#{controlProtocolos.prSincope.testOrto.varTad }" size="5" disabled="true"/>
															<h:outputLabel value="#{ms.prot_sincope_alta_pdiag_ini_test_ort_fc }" title="#{ms.prot_sincope_alta_pdiag_ini_test_ort_fc_title }"/>
															<h:inputText value="#{controlProtocolos.prSincope.testOrto.decFc }" size="5" disabled="true"/>
															<h:inputText value="#{controlProtocolos.prSincope.testOrto.ortFc }" size="5" disabled="true"/>
														</h:panelGrid>
														<h:outputLabel value="#{ms.test_orto_hta}" rendered="#{controlPacientes.pacienteSelect.sitclin.hta eq 1 and controlProtocolos.prSincope.alta.prdiaginiAltaTestort eq 1}"
															style="font-weight: bold;color:#E17009" />
														<h:panelGrid id="panTestOrtoResultados">
															<h:panelGrid columns="2" rendered="#{controlProtocolos.prSincope.testOrto.res ne null and controlProtocolos.prSincope.alta.prdiaginiAltaTestort eq 1}">
																<h:outputLabel value="#{ms.test_orto_resultado }:" />
																<h:outputLabel value="#{ms.test_orto_resultado_pos}" rendered="#{controlProtocolos.prSincope.testOrto.res eq 1}"
																	style="font-weight: bold;color:#E17009" />
																<h:outputLabel value="#{ms.test_orto_resultado_neg }" rendered="#{controlProtocolos.prSincope.testOrto.res eq 0}"
																	style="font-weight: bold;color:#009933" />
															</h:panelGrid>
														</h:panelGrid>
													</h:panelGrid>
												</h:panelGrid>
											</h:panelGrid>
										</t:fieldset>
									</h:panelGrid>
									<h:panelGrid>
										<h:outputLabel value="#{ms.prot_sincope_alta_comentarios }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%" >
											<h:inputTextarea cols="200" rows="5" value="#{controlProtocolos.prSincope.alta.comentarios}" id="protSincAltaComentarios">
												<f:validateLength maximum="1000" />
											</h:inputTextarea>	
											<h:message for="protSincAltaComentarios" style="color:red" />
										</h:panelGrid>
									</h:panelGrid>
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.prot_sincope_tab2_analitica_title }" name="nameAnaliticaProtSincope" rendered="#{loginForm.acceso.idrolacceso ne 5 }">
								<a4j:include viewId="paneles/analitica.jsp" />
							</rich:tab>
							<rich:tab label="#{ms.prot_sincope_tab3_valoracion_title }" name="nameValCardProtSincope" rendered="#{loginForm.acceso.idrolacceso ne 5 }">
								<a4j:include viewId="paneles/valoracion_cardiaca.jsp" />
							</rich:tab>
							<rich:tab label="#{ms.prot_sincope_tab4_pdiag_title }" name="namePrDiagProtSincope" rendered="#{loginForm.acceso.idrolacceso ne 5 }">
								<h:panelGrid width="100%">
									<h:outputLabel value="#{ms.prot_sincope_pdiag_esp_title }" style="font-weight: bold;"/>
									<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
										columns="3" columnClasses="alignTop,alignTop,alignTop" id="panProtSincopePDiag">
										<h:outputLabel value="#{ms.prot_sincope_pdiag_esp_ecg }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagEcgcont }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiag" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid>
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagEcgcont eq 1 }"/>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagEcgcont eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagEcgcontRes }" id="protSincPDiagEcgRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagEcgRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										
										<h:outputLabel value="#{ms.prot_sincope_pdiag_esp_hol24h }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagMonitorizacion }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiag" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid columns="3">
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagMonitorizacion eq 1 }"/>
												<a4j:commandLink actionListener="#{controlProtocolos.verHolter}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.ver_registro }" action="irHolter"
													rendered="#{controlProtocolos.prSincope.pdiagMonitorizacion eq 1 }">
													<h:graphicImage value="/img/iconos/holter.png" style="border: 0px;"
														width="22" height="22"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlProtocolos.desvincularHolter}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													reRender="panProtocoloSincope,tablaPacientesBdu,panicoprotsincope"
													title="#{ms.desvincular }" action="irProtocoloSincope"
													rendered="#{controlProtocolos.prSincope.pdiagMonitorizacion eq 1 }">
													<h:graphicImage value="/img/aplicacion/icoCancelar.png" style="border: 0px;"
														width="16" height="16"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlHolter.iniciaHolter2}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.aniadir }" action="irHolter"
													rendered="#{controlProtocolos.prSincope.pdiagMonitorizacion ne 1 }">
													<h:graphicImage value="/img/iconos/add.png" style="border: 0px;"
														width="20" height="20"/>
												</a4j:commandLink>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagMonitorizacion eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagMonitorizacionRes }" id="protSincPDiagMonRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagMonRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										
										<h:outputLabel value="#{ms.prot_sincope_pdiag_esp_elr }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagElr }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiag" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid columns="3">
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagElr eq 1 }"/>
												<a4j:commandLink actionListener="#{controlProtocolos.verELR}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.ver_registro }" action="irRegEvExt"
													rendered="#{controlProtocolos.prSincope.pdiagElr eq 1 }">
													<h:graphicImage value="/img/iconos/regevext.png" style="border: 0px;"
														width="22" height="22"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlProtocolos.desvincularELR}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													reRender="panProtocoloSincope,tablaPacientesBdu,panicoprotsincope"
													title="#{ms.desvincular }" action="irProtocoloSincope"
													rendered="#{controlProtocolos.prSincope.pdiagElr eq 1 }">
													<h:graphicImage value="/img/aplicacion/icoCancelar.png" style="border: 0px;"
														width="16" height="16"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlRegEvExt.iniciaRegEvExt2}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.aniadir }" action="irRegEvExt"
													rendered="#{controlProtocolos.prSincope.pdiagElr ne 1 }">
													<h:graphicImage value="/img/iconos/add.png" style="border: 0px;"
														width="22" height="22"/>
												</a4j:commandLink>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagElr eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagElrRes }" id="protSincPDiagElrRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagElrRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										
										<h:outputLabel value="#{ms.prot_sincope_pdiag_esp_mesa }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagMesab }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiag" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid columns="3">
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagMesab eq 1 }"/>
												<a4j:commandLink actionListener="#{controlProtocolos.verMesa}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.ver_registro }" action="irMesa"
													rendered="#{controlProtocolos.prSincope.pdiagMesab eq 1 }">
													<h:graphicImage value="/img/iconos/mesabasc.png" style="border: 0px;"
														width="22" height="22"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlProtocolos.desvincularMesa}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													reRender="panProtocoloSincope,tablaPacientesBdu,panicoprotsincope"
													title="#{ms.desvincular }" action="irProtocoloSincope"
													rendered="#{controlProtocolos.prSincope.pdiagMesab eq 1 }">
													<h:graphicImage value="/img/aplicacion/icoCancelar.png" style="border: 0px;"
														width="16" height="16"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlMesas.iniciaMesas}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.aniadir }" action="irMesa"
													rendered="#{controlProtocolos.prSincope.pdiagMesab ne 1 }">
													<h:graphicImage value="/img/iconos/add.png" style="border: 0px;"
														width="22" height="22"/>
												</a4j:commandLink>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagMesab eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagMesabRes }" id="protSincPDiagMesaBRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagMesaBRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										
										<h:outputLabel value="#{ms.prot_sincope_pdiag_esp_ilr }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagIlr }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiag" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid columns="3">
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagIlr eq 1 }"/>
												<a4j:commandLink actionListener="#{controlProtocolos.verILR}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.ver_registro }" action="irRegistrador"
													rendered="#{controlProtocolos.prSincope.pdiagIlr eq 1 }">
													<h:graphicImage value="/img/iconos/ViewResults.png" style="border: 0px;"
														width="22" height="22"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlProtocolos.desvincularILR}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													reRender="panProtocoloSincope,tablaPacientesBdu,panicoprotsincope"
													title="#{ms.desvincular }" action="irProtocoloSincope"
													rendered="#{controlProtocolos.prSincope.pdiagIlr eq 1 }">
													<h:graphicImage value="/img/aplicacion/icoCancelar.png" style="border: 0px;"
														width="16" height="16"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlRegistrador.iniciaRegistradores}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.aniadir }" action="irRegistrador"
													rendered="#{controlProtocolos.prSincope.pdiagIlr ne 1 }">
													<h:graphicImage value="/img/iconos/add.png" style="border: 0px;"
														width="22" height="22"/>
												</a4j:commandLink>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagIlr eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagIlrRes }" id="protSincPDiagIlrRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagIlrRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										
										<h:outputLabel value="#{ms.prot_sincope_pdiag_esp_erg }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagPesfuerzo }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiag" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid>
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagPesfuerzo eq 1 }"/>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagPesfuerzo eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagPesfuerzoRes }" id="protSincPDiagPEsfRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagPEsfRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										
										<h:outputLabel value="#{ms.prot_sincope_pdiag_esp_eco }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagEcografia }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiag" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid>
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagEcografia eq 1 }"/>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagEcografia eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagEcografiaRes }" id="protSincPDiagEcoRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagEcoRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										
										<h:outputLabel value="#{ms.prot_sincope_pdiag_esp_eef }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagEef }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiag" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid columns="3">
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagEef eq 1 }"/>
												<a4j:commandLink actionListener="#{controlProtocolos.verEEF }"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.ver_registro }" action="irEef"
													rendered="#{controlProtocolos.prSincope.pdiagEef eq 1 }">
													<h:graphicImage value="/img/iconos/hearticon.png" style="border: 0px;"
														width="22" height="22"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlProtocolos.desvincularEEF}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													reRender="panProtocoloSincope,tablaPacientesBdu,panicoprotsincope"
													title="#{ms.desvincular }" action="irProtocoloSincope"
													rendered="#{controlProtocolos.prSincope.pdiagEef eq 1 }">
													<h:graphicImage value="/img/aplicacion/icoCancelar.png" style="border: 0px;"
														width="16" height="16"/>
												</a4j:commandLink>
												<a4j:commandLink actionListener="#{controlEef.iniciaEef}"
													onclick="javascript:Richfaces.showModalPanel('buscando');"
													title="#{ms.aniadir }" action="irEef"
													rendered="#{controlProtocolos.prSincope.pdiagEef ne 1 }">
													<h:graphicImage value="/img/iconos/add.png" style="border: 0px;"
														width="22" height="22"/>
												</a4j:commandLink>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagEef eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagEefRes }" id="protSincPDiagEefRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagEefRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
									</h:panelGrid>
									<h:outputLabel value="#{ms.prot_sincope_pdiag_otras_title }" style="font-weight: bold;"/>
									<h:panelGrid columns="3" style="border-top: solid 1px;border-color: black;" width="100%" 
										id="panProtSincopePDiagOtras" columnClasses="alignTop,alignTop,alignTop">
										<h:outputLabel value="#{ms.prot_sincope_pdiag_otras_rx_torax }" />
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagRxtorax }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiagOtras" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid>
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagRxtorax eq 1 }"/>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagRxtorax eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagRxtoraxRes }" id="protSincPDiagRxTorRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagRxTorRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										<h:outputLabel value="#{ms.prot_sincope_pdiag_otras_tac_cer }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagTaccer }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiagOtras" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid>
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagTaccer eq 1 }"/>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagTaccer eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagTaccerRes }" id="protSincPDiagTacCerRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagTacCerRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										<h:outputLabel value="#{ms.prot_sincope_pdiag_otras_tac_tor }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagTactor }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiagOtras" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid>
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagTactor eq 1 }"/>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagTactor eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagTactorRes }" id="protSincPDiagTacTorRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagTacTorRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
										<h:outputLabel value="#{ms.prot_sincope_pdiag_otras_tac_ang }"/>
										<h:selectOneRadio layout="lineDirection" value="#{controlProtocolos.prSincope.pdiagAngiotac }">
											<f:selectItem itemLabel="#{ms.opcion_si }" itemValue="1" />
											<f:selectItem itemLabel="#{ms.opcion_no }" itemValue="0" />
											<a4j:support event="onchange" reRender="panProtSincopePDiagOtras" ajaxSingle="true"/>
										</h:selectOneRadio>
										<h:panelGrid>
											<h:panelGrid>
												<h:outputLabel value="#{ms.prot_sincope_pdiag_hallazgos }" style="font-weight: bold;"
													rendered="#{controlProtocolos.prSincope.pdiagAngiotac eq 1 }"/>
											</h:panelGrid>
											<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%"
												rendered="#{controlProtocolos.prSincope.pdiagAngiotac eq 1 }">
												<h:inputTextarea cols="150" rows="3" value="#{controlProtocolos.prSincope.pdiagAngiotacRes }" id="protSincPDiagAngTacRes">
													<f:validateLength maximum="400" />
												</h:inputTextarea>	
												<h:message for="protSincPDiagAngTacRes" style="color:red" />
											</h:panelGrid>
										</h:panelGrid>
									</h:panelGrid>
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.prot_sincope_tab5_res_title }" name="nameResProtSincope" rendered="#{loginForm.acceso.idrolacceso ne 5 }">
								<a4j:include viewId="paneles/resultados.jsp" />
							</rich:tab>
							<rich:tab label="#{ms.prot_sincope_tab6_seg_title }" name="nameSegProtSincope" rendered="#{loginForm.acceso.idrolacceso ne 5 }">
								<a4j:include viewId="paneles/seguimientos.jsp" />
							</rich:tab>
                    	</rich:tabPanel>
                	</h:panelGrid>	
                </rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
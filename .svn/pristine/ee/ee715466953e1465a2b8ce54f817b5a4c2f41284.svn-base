<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form binding="#{controlPacientes.formulario}" id="nuevoPaciente">
			<a4j:poll reRender="cabpaci,nuevoseguimentointegrado,nuevoseguimentointegradoPac" interval="10000"/>
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
.scroll_div{
 overflow: scroll;
 width:100%;
 height:100%;
}
</style>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="100%"
				id="panelContenidoGlobal" style="margin-top: 15px;">
				<rich:messages errorClass="hvn_msjError" warnClass="hvn_msjAviso"
					infoClass="hvn_msjInfo" />
				<rich:panel style="width:95%;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="99%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.pat_menu_title_1 }"
								styleClass="textoBlancoNegrita" />
							<h:panelGrid columns="5" columnClasses="right" id="accionesPaciente">
								<a4j:commandLink 
									actionListener="#{controlPacientes.guardarPaciente }" rendered="#{controlPacientes.pacienteSelect.nhc ne null }"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									style="align:right;" reRender="infoPacienteDemo,nuevoCasa,histclin,histcardio,le,menu,chadvascSitClin">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" id="icoBuscar" title="#{ms.guardar }"
										width="24" height="24" url="/img/iconos/guardar.png"/>
								</a4j:commandLink>
								<a4j:commandLink 
									actionListener="#{controlPacientes.guardarPaciente }" rendered="#{controlPacientes.pacienteSelect.nhc eq null }"
									style="align:right;" reRender="infoPacienteDemo,nuevoCasa,histclin,histcardio,le,menu,accionesPaciente,tabpaciente"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									action="irNuevoPaciente">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" id="icoBuscarInicial" title="#{ms.guardar }"
										width="24" height="24" url="/img/iconos/guardar.png"/>
								</a4j:commandLink>
								<a4j:commandLink 
									rendered="#{controlPacientes.modPaci eq 1 }"
									actionListener="#{controlPacientes.eliminarPaciente}"
									onclick="if (!confirm('#{ms.warn_borra_pat}')) return false;javascript:Richfaces.showModalPanel('buscando'); "
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									style="align:right;" reRender="panelContenidoGlobal,menu,cabecerapaciente">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" id="icoEliminar" title="#{ms.eliminar }"
										width="24" height="24" url="/img/iconos/borra.png"/>
								</a4j:commandLink>
								<a4j:commandLink
									actionListener="#{controlPacientes.limpiarPacienteNuevo}"
									rendered="#{controlPacientes.modPaci eq 1}"
									style="align:right;" reRender="panelContenidoGlobal,menu,cabecerapaciente,textoConsentimientoMPS,textoConsentimientoDAI,textoConsentimientoREC"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" id="icoLimpiar" title="#{ms.limpiar }"
										width="24" height="24" url="/img/iconos/limpia.png"/>
								</a4j:commandLink>
								<a4j:commandLink
									rendered="false"
									style="align:right;" reRender="panelContenidoGlobal,menu,cabecerapaciente"
									onclick="javascript:Richfaces.showModalPanel('listainformesgenerales');">
									<h:graphicImage style="align:right;border:none;"
										styleClass="hvn_enlImagen" title="Informes disponibles"
										width="24" height="24" url="/img/iconos/informe_especial.png"/>
								</a4j:commandLink>
								<h:panelGrid>
									<rich:dropDownMenu rendered="#{controlPacientes.modPaci eq 1}">
										 <f:facet name="label"> 
						                    <h:panelGroup>
						                        <h:graphicImage value="/img/iconos/informe_especial_mini.png" styleClass="pic" title="#{ms.pat_inf_title_1 }"/>
						                    </h:panelGroup>
						                </f:facet>
						                <rich:menuItem value="#{ms.pat_inf_title_2 }" 
						                	actionListener="#{controlPacientes.generaInformeProcedimientosPaciente }"
											target="_blank" icon="/img/iconos/informe_especial_mini.png">
                						</rich:menuItem>
                						<rich:menuItem value="#{ms.pat_inf_title_3 }" 
						                	actionListener="#{controlPacientes.generaInformeResumenHC }"
											target="_blank" icon="/img/iconos/cruzroja.png">
                						</rich:menuItem>
                						<rich:menuGroup value="#{ms.pat_inf_title_4 }">
                							<rich:menuItem value="#{ms.pat_inf_cons_title_1 }" submitMode="ajax"
	                							onclick="javascript:Richfaces.showModalPanel('consentimientoMPS');"
							                	icon="/img/iconos/consent.png">
	                						</rich:menuItem>	                						
	                						<rich:menuItem value="#{ms.pat_inf_cons_title_2 }" submitMode="ajax"
	                							onclick="javascript:Richfaces.showModalPanel('consentimientoDAI');"
							                	icon="/img/iconos/consent.png">
	                						</rich:menuItem>
	                						<rich:menuItem value="#{ms.pat_inf_cons_title_3 }" submitMode="ajax"
	                							onclick="javascript:Richfaces.showModalPanel('consentimientoREC');"
							                	icon="/img/iconos/consent.png">
	                						</rich:menuItem>
	                						<rich:menuItem value="#{ms.pat_inf_cons_title_4 }" submitMode="ajax"
	                							onclick="javascript:Richfaces.showModalPanel('consentimientoMPSTRANS');"
							                	icon="/img/iconos/consent.png">
	                						</rich:menuItem>
	                						<rich:menuItem value="#{ms.pat_inf_cons_title_5 }" submitMode="ajax"
	                							onclick="javascript:Richfaces.showModalPanel('consentimientoHOLTER');"
							                	icon="/img/iconos/consent.png">
	                						</rich:menuItem>
	                						<rich:menuItem value="#{ms.pat_inf_cons_title_6 }" submitMode="ajax"
	                							onclick="javascript:Richfaces.showModalPanel('consentimientoEXP');"
							                	icon="/img/iconos/consent.png">
	                						</rich:menuItem>
	                						<rich:menuItem value="#{ms.pat_inf_cons_title_7 }" submitMode="ajax"
	                							onclick="javascript:Richfaces.showModalPanel('consentimientoMRI');"
							                	icon="/img/iconos/consent.png">
	                						</rich:menuItem>
                						</rich:menuGroup>
									</rich:dropDownMenu>
								</h:panelGrid>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>	
					<!-- BARRA TEMPORAL -->									
					<script type="text/javascript" src="/idea/js/jsapi.js"></script>
					<script type="text/javascript" src="/idea/js/timeline.js"></script>
					<script type="text/javascript" src="/idea/js/timeline-locales.js"></script>
						<h:panelGrid id="panControlLineaTemporal" columns="2" columnClasses="right,right">
							<h:selectBooleanCheckbox value="#{controlPacientes.verComplicaciones}" rendered="#{controlPacientes.pacienteSelect.codigo ne null }">
								<a4j:support event="onclick" reRender="panelContenidoGlobal" ajaxSingle="true"
									actionListener="#{controlPacientes.cambiaVistaLineaTemporal }"/>
							</h:selectBooleanCheckbox>
							<h:outputLabel value="#{ms.linea_temporal_ver_complicaciones }" style="font-weight: bold;color:#E17009" 
								rendered="#{controlPacientes.pacienteSelect.codigo ne null }"/>
						</h:panelGrid>				
						<h:panelGrid width="100%" id="panelResumenClinica" rendered="#{loginForm.acceso.idrolacceso ne 3 }">							
							<input type="hidden" id="json" value="#{controlPacientes.json }"/>
							<input type="hidden" id="jsonstart" value="#{controlPacientes.jsonstart }"/>
							<input type="hidden" id="jsonend" value="#{controlPacientes.jsonend }"/>
							<h:outputLabel value="#{ms.pat_procs_msg_1 }" rendered="#{empty controlPacientes.json &amp;&amp; controlPacientes.pacienteSelect.nhc ne null}"/>
							<h:outputLabel value="#{ms.pat_procs_msg_2 }" rendered="#{controlPacientes.pacienteSelect.nhc eq null }"/>
							<div id="mytimeline"/>
							<h:inputText id="numeroprocedimiento" value="#{controlPacientes.infoprocedimientobarratemporal }" style="opacity:0;filter:alpha(opacity=0);" size="1">
								<a4j:support reRender="numeroprocedimiento,procedimiento" event="onfocus" actionListener="#{controlPacientes.cargaNumeroProc }"
									oncomplete="javascript:Richfaces.showModalPanel('procedimiento')"/>
							</h:inputText>							
						</h:panelGrid>						
						<script type="text/javascript">
							//google.load("visualization", "1");	
						    // Set callback to run when API is loaded
						    //google.setOnLoadCallback(drawVisualization);
						    var jsonstart = document.getElementById('jsonstart').value;
						    var jsonend = document.getElementById('jsonend').value;
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
					    	var obj = document.getElementById('json').value;					    	
						    //alert(obj);
						    var spl = obj.split('_');
						    for(var i=0;i &lt; spl.length;i++){
						    	var item = spl[i].split('--');
						    	var date = item[0];var content = item[1];
						    	dataJSON.push({'start':new Date(item[0].substring(0,4),item[0].substring(5,7),item[0].substring(8,11)),'content':content.toString()});
						    }  
						    // Instantiate our timeline object.
						    var timeline = new links.Timeline(document.getElementById('mytimeline'));	
						    options.locale = "es_ES";
						    // Draw our timeline with the created data and options
						    //timeline.draw(data, options);
						    timeline.draw(dataJSON, options);
						    // Called when the Visualization API is loaded.
						    function drawVisualization() {	       
						    	// specify options
						        options = {
						         // start: new Date(jsonstart.substring(0,4),jsonstart.substring(5,7),jsonstart.substring(8,11)),
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
						    	var obj = document.getElementById('json').value;
							    //alert(obj);
							    var spl = obj.split('_');
							    for(var i=0;i &lt; spl.length;i++){
							    	var item = spl[i].split('-');
							    	var date = item[0];var content = item[1];
							    	dataJSON.push({'start':new Date(item[0].substring(0,4),item[0].substring(5,7),item[0].substring(8,11)),'content':content.toString()});
							    }  
							    // Instantiate our timeline object.
							    var timeline = new links.Timeline(document.getElementById('mytimeline'));	
							    options.locale = "es_ES";
							    // Draw our timeline with the created data and options
							    //timeline.draw(data, options);
							    timeline.draw(dataJSON, options);
						    }	
						</script>
					<!-- BARRA TEMPORAL FIN-->	
					<h:panelGrid width="90%" columClasses="centerTop">		
						<rich:tabPanel contentClass="estiloFondo" switchType="client" id="tabpaciente">						
							<rich:tab label="#{ms.pat_menu_title_tab_2 }" name="demograficos" id="tabdemograficos">
								<h:panelGrid id="infoPacienteDemo">
									<a4j:include viewId="/ventanas/pacientes/datosDemograficos.jsp" />
								</h:panelGrid>
								<h:panelGrid id="nuevoCasa">
									<a4j:include viewId="/ventanas/pacientes/datosCasa.jsp" />
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.pat_menu_title_tab_3 }">
								<h:panelGrid id="sitclingenMenu" width="100%">
									<a4j:include viewId="/ventanas/pacientes/situacionclinica.jsp" />
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.pat_menu_title_tab_7 }">
								<h:panelGrid id="medicacionMenu" width="95%">
									<a4j:include viewId="/ventanas/pacientes/medicacion.jsp" />
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.pat_menu_title_tab_4 }" rendered="false">
								<h:panelGrid id="histclin" width="80%">
									<a4j:include viewId="/ventanas/pacientes/historiaClinica.jsp" />
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.pat_menu_title_tab_5 }" rendered="false">
								<h:panelGrid id="histcardio" width="80%">
									<a4j:include viewId="/ventanas/pacientes/historiaCardiologica.jsp" />
								</h:panelGrid>
							</rich:tab>
							<rich:tab label="#{ms.pat_menu_title_tab_6 }" rendered="#{loginForm.accmods.lespera eq 1 }">
								<h:panelGrid id="le" width="100%">
									<a4j:include viewId="/ventanas/pacientes/listaEspera.jsp" />
								</h:panelGrid>
							</rich:tab>
						</rich:tabPanel>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>

			<rich:modalPanel id="acceso" autosized="true" zindex="2000"
				width="200">
				<f:facet name="header">
					<h:panelGrid align="center" border="0">
						<h:outputText value="#{ms.buscando }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<h:panelGrid columns="2" style="border:0;" align="center">
					<h:graphicImage url="/img/aplicacion/ajaxloading.gif" width="10"
						height="10" />
					<h:outputText value="#{ms.espere }" styleClass="hvn_estatus" />
				</h:panelGrid>
			</rich:modalPanel>

			<rich:modalPanel id="bloqueoCarga" autosized="true" zindex="2000"
				width="200">
				<f:facet name="header">
					<h:panelGrid align="center" border="0">
						<h:outputText value="#{ms.pat_procs_modal_msg_1 }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<h:panelGrid columns="2" style="border:0;" align="center">
					<h:graphicImage url="/img/aplicacion/ajaxloading.gif" width="10"
						height="10" />
					<h:outputText value="#{ms.espere }" styleClass="hvn_estatus" />
				</h:panelGrid>
			</rich:modalPanel>

			<rich:modalPanel id="bloqueoGuarda" autosized="true" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0">
						<h:outputText value="#{ms.pat_procs_modal_msg_2 }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<h:panelGrid columns="2" style="border:0;" align="center">
					<h:graphicImage url="/img/aplicacion/ajaxloading.gif" width="10"
						height="10" />
					<h:outputText value="#{ms.espere }" styleClass="hvn_estatus" />
				</h:panelGrid>
			</rich:modalPanel>

			<rich:modalPanel id="busqueda" height="450" width="760" zindex="2000">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.pat_procs_modal_msg_3 }"
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
						<h:outputText value="#{ms.pat_procs_modal_msg_4 }" rendered="#{controlPacientes.tipoprocedimiento ne 1 }"
							styleClass="textoBlancoNegrita" />
						<h:outputText value="#{ms.pat_procs_modal_msg_9 }" rendered="#{controlPacientes.tipoprocedimiento eq 1 }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>
					<h:panelGrid columns="2" rendered="true">
						<h:outputLabel style="font-weight: bold;" rendered="#{controlPacientes.tipoprocedimiento ne 1 }"
							value="#{ms.pat_procs_modal_msg_5 }"/>
						<h:outputLabel rendered="#{controlPacientes.tipoprocedimiento ne 1 }"
							value="#{controlPacientes.tipoprocedimientobarratemporal }"/>
						<h:outputLabel style="font-weight: bold;" 
							value="#{ms.pat_procs_modal_msg_6 }"/>
						<h:outputLabel
							value="#{controlPacientes.fechaprocedimientobarratemporal }"/>
						<h:outputLabel style="font-weight: bold;" 
							value="Modelo: " rendered="false"/>
						<h:outputLabel value="#{controlPacientes.modeloprocedimientobarratemporal }"
							rendered="false"/>
						<h:outputLabel style="font-weight: bold;" 
							value="#{ms.pat_procs_modal_msg_7 }" rendered="#{controlPacientes.tipoprocedimiento eq 956 || controlPacientes.tipoprocedimiento eq 957 || controlPacientes.tipoprocedimiento eq 1059 || controlPacientes.tipoprocedimiento eq 1060 || controlPacientes.tipoprocedimiento eq 993 || controlPacientes.tipoprocedimiento eq 1085}"/>
						<h:outputLabel value="#{controlPacientes.dispprocedimientobarratemporal }"
							rendered="#{controlPacientes.tipoprocedimiento eq 956 || controlPacientes.tipoprocedimiento eq 957 || controlPacientes.tipoprocedimiento eq 1059 || controlPacientes.tipoprocedimiento eq 1060 || controlPacientes.tipoprocedimiento eq 993 || controlPacientes.tipoprocedimiento eq 1085}"/>
					</h:panelGrid>
					
					<h:panelGrid columns="2" >
						<a4j:commandLink action="irImplantes" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlImplantes.cargaImplanteDesdeBarra }" rendered="#{controlPacientes.tipoprocedimiento eq 956 || controlPacientes.tipoprocedimiento eq 957 || controlPacientes.tipoprocedimiento eq 1059 || controlPacientes.tipoprocedimiento eq 1060 || controlPacientes.tipoprocedimiento eq 993 || controlPacientes.tipoprocedimiento eq 1085 || controlPacientes.tipoprocedimiento eq 1086 || controlPacientes.tipoprocedimiento eq 1147 || controlPacientes.tipoprocedimiento eq 1090}"/>
						<a4j:commandLink action="irSeguimientos" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlSeguimientos.cargaSeguimientoDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 983 }"/>
						<a4j:commandLink action="irRegistrador" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlRegistrador.cargaRegistradorDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1067 }"/>
						<a4j:commandLink action="irMesa" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlMesas.cargaMesaDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1066 }"/>
						<a4j:commandLink action="irCardioversion" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlCardioversion.cargaCardioversionDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1068 }"/>
						<a4j:commandLink action="irEef" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlEef.cargaEstudioDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1061 }"/>
						<a4j:commandLink action="irATP" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlTest.cargaATPDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1063 }"/>
						<a4j:commandLink action="irEpi" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlTest.cargaEpiDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1064 }"/>
						<a4j:commandLink action="irFle" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlTest.cargaFleDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1065 }"/>
						<a4j:commandLink action="irSeguimientosClinicos" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlSeguimientosClinicos.cargaSegClinDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1087 }"/>
						<a4j:commandLink action="irSeguimientosRegEventos" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlSeguimientosRegEventos.cargaSegRegEvDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1088 }"/>
						<a4j:commandLink action="irHolter" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlHolter.cargaHolterDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1089 }"/>
						<a4j:commandLink action="irRegEvExt" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlRegEvExt.cargaRegEvExtDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1091 }"/>
						<a4j:commandLink action="irTestOrto" value="#{ms.pat_procs_modal_msg_8 }" 
							actionListener="#{controlTestOrtostatismo.cargaTestOrtoDesdeBarraTemporal}" rendered="#{controlPacientes.tipoprocedimiento eq 1092 }"/>
						<a4j:commandLink value="Volver" onclick="javascript:Richfaces.hideModalPanel('procedimiento')"/>
					</h:panelGrid>
				</h:panelGrid>
			</rich:modalPanel>
			<rich:modalPanel id="listainformesgenerales" autosized="true" zindex="2000" minWidth="250">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.pat_inf_title_1 }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>
						<a4j:commandLink 
							onclick="javascript:Richfaces.hideModalPanel('listainformesgenerales');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;"
								onclick="javascript:Richfaces.hideModalPanel('listainformesgenerales')"
								title="#{ms.cancelar }" />
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>
					<h:outputLabel value="#{ms.pat_inf_msg_1 }" style="font-weight: bold;"/>
					<h:selectOneRadio value="#{controlPacientes.tipoinforme }" layout="pageDirection" rendered="false">
					   <f:selectItem itemValue="1" itemLabel="#{ms.pat_inf_title_2 }" />
					   <f:selectItem itemValue="2" itemLabel="#{ms.pat_inf_cons_title_2_1 }" />	   			
					</h:selectOneRadio>
					<h:panelGrid>
						<h:commandLink actionListener="#{controlPacientes.generaInformeProcedimientosPaciente }"
							target="_blank" onclick="javascript:Richfaces.hideModalPanel('listainformesgenerales');">
							<h:graphicImage style="align:right;border:none;"
								styleClass="hvn_enlImagen" title="#{ms.generar_informe }"
								width="24" height="24" url="/img/iconos/informe_especial.png"/>
							<h:outputLabel value="#{ms.pat_inf_title_2 }" style="font-weight: bold;"/>
						</h:commandLink>
						<rich:spacer height="2px"/>
						<h:commandLink actionListener="#{controlPacientes.generaInformeResumenHC }"
							target="_blank"
							onclick="javascript:Richfaces.hideModalPanel('listainformesgenerales');">
							<h:graphicImage style="align:right;border:none;"
								styleClass="hvn_enlImagen" title="#{ms.generar_informe }"
								width="24" height="24" url="/img/iconos/informe_especial.png"/>
							<h:outputLabel value="#{ms.pat_inf_title_3 }" style="font-weight: bold;"/>
						</h:commandLink>
						<rich:spacer height="2px"/>
						<h:commandLink actionListener="#{controlPacientes.generaInformeConsentimientoDAI }"
							target="_blank"
							onclick="javascript:Richfaces.hideModalPanel('listainformesgenerales');">
							<h:graphicImage style="align:right;border:none;"
								styleClass="hvn_enlImagen" title="#{ms.generar_informe }"
								width="24" height="24" url="/img/iconos/informe_especial.png"/>
							<h:outputLabel value="#{ms.pat_inf_cons_title_2_1 }" style="font-weight: bold;"/>
						</h:commandLink>
						<h:commandLink onclick="javascript:Richfaces.showModalPanel('consentimientoDAI');">
							<h:graphicImage style="align:right;border:none;"
								styleClass="hvn_enlImagen" title="#{ms.generar_informe }"
								width="24" height="24" url="/img/iconos/informe_especial.png"/>
							<h:outputLabel value="#{ms.pat_inf_cons_title_1_1 }" style="font-weight: bold;"/>
						</h:commandLink>
					</h:panelGrid>	
					
				</h:panelGrid>
			</rich:modalPanel>
			<rich:modalPanel id="consentimientoDAI" style="overflow:scroll;" zindex="2000" minWidth="1250" height="650" onshow="updateconsdai();">
				<a4j:jsFunction name="updateconsdai" reRender="panModalConsentimientoDAI" />
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.pat_inf_cons_modal_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid columns="2">
						<h:commandLink actionListener="#{controlPacientes.generaInformeConsentimientoDAI }" 
							target="_blank" onclick="javascript:Richfaces.hideModalPanel('consentimientoDAI');">
							<h:graphicImage value="/img/iconos/informe_especial.png" width="20" height="20"
								style="border:0;cursor:pointer;" title="#{ms.generar_informe }" />
						</h:commandLink>
						<a4j:commandLink actionListener="#{controlPacientes.limpiaConsentimiento }"
							onclick="javascript:Richfaces.hideModalPanel('consentimientoDAI');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;" title="Cancelar" 
								onclick="javascript:Richfaces.hideModalPanel('consentimientoDAI')"/>
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>
					<ui:include src="/ventanas/consentimientos/implante_dai.jsp"/>
				</h:panelGrid>
			</rich:modalPanel>
			<rich:modalPanel id="consentimientoMPS" style="overflow:scroll;" zindex="2000" minWidth="1250" height="650" onshow="updateconsmps();">
				<a4j:jsFunction name="updateconsmps" reRender="panModalConsentimientoMPS" />
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.pat_inf_cons_modal_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid columns="2">
						<h:commandLink actionListener="#{controlPacientes.generaInformeConsentimientoMPS }" 
							target="_blank" onclick="javascript:Richfaces.hideModalPanel('consentimientoMPS');">
							<h:graphicImage value="/img/iconos/informe_especial.png" width="20" height="20"
								style="border:0;cursor:pointer;" title="#{ms.generar_informe }" />
						</h:commandLink>
						<a4j:commandLink actionListener="#{controlPacientes.limpiaConsentimiento }"
							onclick="javascript:Richfaces.hideModalPanel('consentimientoMPS');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;" title="#{ms.cancelar }" 
								onclick="javascript:Richfaces.hideModalPanel('consentimientoMPS')"/>
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>					
					<ui:include src="/ventanas/consentimientos/implante_mps.jsp"/>
				</h:panelGrid>
			</rich:modalPanel>
			<rich:modalPanel id="consentimientoREC" style="overflow:scroll;" zindex="2000" minWidth="1250" height="650" onshow="updateconsrec();">
				<a4j:jsFunction name="updateconsrec" reRender="panModalConsentimientoREC" />
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.pat_inf_cons_modal_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">					
					<h:panelGrid columns="2">
						<h:commandLink actionListener="#{controlPacientes.generaInformeConsentimientoREC }" 
							target="_blank" onclick="javascript:Richfaces.hideModalPanel('consentimientoREC');">
							<h:graphicImage value="/img/iconos/informe_especial.png" width="20" height="20"
								style="border:0;cursor:pointer;" title="#{ms.generar_informe }" />
						</h:commandLink>
						<a4j:commandLink actionListener="#{controlPacientes.limpiaConsentimiento }"
							onclick="javascript:Richfaces.hideModalPanel('consentimientoREC');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;" title="#{ms.cancelar }" 
								onclick="javascript:Richfaces.hideModalPanel('consentimientoREC')"/>
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>										
					<ui:include src="/ventanas/consentimientos/recambio.jsp"/>
				</h:panelGrid>
			</rich:modalPanel>
			<rich:modalPanel id="consentimientoMPSTRANS" style="overflow:scroll;" zindex="2000" minWidth="1250" height="650" onshow="updateconstrans();">
				<a4j:jsFunction name="updateconstrans" reRender="panModalConsentimientoMPSTRANS" />
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.pat_inf_cons_modal_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">					
					<h:panelGrid columns="2">
						<h:commandLink actionListener="#{controlPacientes.generaInformeConsentimientoTRANS }" 
							target="_blank" onclick="javascript:Richfaces.hideModalPanel('consentimientoMPSTRANS');">
							<h:graphicImage value="/img/iconos/informe_especial.png" width="20" height="20"
								style="border:0;cursor:pointer;" title="#{ms.generar_informe }" />
						</h:commandLink>
						<a4j:commandLink actionListener="#{controlPacientes.limpiaConsentimiento }"
							onclick="javascript:Richfaces.hideModalPanel('consentimientoMPSTRANS');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;" title="#{ms.cancelar }" 
								onclick="javascript:Richfaces.hideModalPanel('consentimientoMPSTRANS')"/>
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>										
					<ui:include src="/ventanas/consentimientos/implante_mps_trans.jsp"/>
				</h:panelGrid>
			</rich:modalPanel>
			<rich:modalPanel id="consentimientoHOLTER" style="overflow:scroll;" zindex="2000" minWidth="1250" height="650" onshow="updateconsholter();">
				<a4j:jsFunction name="updateconsholter" reRender="panModalConsentimientoHOLTER" />
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.pat_inf_cons_modal_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">					
					<h:panelGrid columns="2">
						<h:commandLink actionListener="#{controlPacientes.generaInformeConsentimientoHOLTER }" 
							target="_blank" onclick="javascript:Richfaces.hideModalPanel('consentimientoHOLTER');">
							<h:graphicImage value="/img/iconos/informe_especial.png" width="20" height="20"
								style="border:0;cursor:pointer;" title="#{ms.generar_informe }" />
						</h:commandLink>
						<a4j:commandLink actionListener="#{controlPacientes.limpiaConsentimiento }"
							onclick="javascript:Richfaces.hideModalPanel('consentimientoHOLTER');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;" title="#{ms.cancelar }" 
								onclick="javascript:Richfaces.hideModalPanel('consentimientoHOLTER')"/>
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>										
					<ui:include src="/ventanas/consentimientos/implante_holter.jsp"/>
				</h:panelGrid>
			</rich:modalPanel>
			<rich:modalPanel id="consentimientoEXP" style="overflow:scroll;" zindex="2000" minWidth="1250" height="650" onshow="updateconsexp();">
				<a4j:jsFunction name="updateconsexp" reRender="panModalConsentimientoEXP" />
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.pat_inf_cons_modal_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">					
					<h:panelGrid columns="2">
						<h:commandLink actionListener="#{controlPacientes.generaInformeConsentimientoEXP }" 
							target="_blank" onclick="javascript:Richfaces.hideModalPanel('consentimientoEXP');">
							<h:graphicImage value="/img/iconos/informe_especial.png" width="20" height="20"
								style="border:0;cursor:pointer;" title="#{ms.generar_informe }" />
						</h:commandLink>
						<a4j:commandLink actionListener="#{controlPacientes.limpiaConsentimiento }"
							onclick="javascript:Richfaces.hideModalPanel('consentimientoEXP');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;" title="#{ms.cancelar }" 
								onclick="javascript:Richfaces.hideModalPanel('consentimientoEXP')"/>
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>										
					<ui:include src="/ventanas/consentimientos/explante.jsp"/>
				</h:panelGrid>
			</rich:modalPanel>
			<rich:modalPanel id="consentimientoMRI" style="overflow:scroll;" zindex="2000" minWidth="1250" height="650" onshow="updateconsmri();">
				<a4j:jsFunction name="updateconsmri" reRender="panModalConsentimientoMRI" />
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="90%">
						<h:outputText value="#{ms.pat_inf_cons_modal_title }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">					
					<h:panelGrid columns="2">
						<h:commandLink actionListener="#{controlPacientes.generaInformeConsentimientoMRI }" 
							target="_blank" onclick="javascript:Richfaces.hideModalPanel('consentimientoMRI');">
							<h:graphicImage value="/img/iconos/informe_especial.png" width="20" height="20"
								style="border:0;cursor:pointer;" title="#{ms.generar_informe }" />
						</h:commandLink>
						<a4j:commandLink actionListener="#{controlPacientes.limpiaConsentimiento }"
							onclick="javascript:Richfaces.hideModalPanel('consentimientoMRI');">
							<h:graphicImage value="/img/aplicacion/icoCancelar.png"
								style="border:0;cursor:pointer;" title="#{ms.cancelar }" 
								onclick="javascript:Richfaces.hideModalPanel('consentimientoMRI')"/>
						</a4j:commandLink>		
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>										
					<ui:include src="/ventanas/consentimientos/proc_mri.jsp"/>
				</h:panelGrid>
			</rich:modalPanel>
			<rich:modalPanel id="nuevoseguimentointegradoPac" autosized="true" 
				showWhenRendered="#{controlSeguimientos.muestraModalNuevoSeg }">
				<f:facet name="header">
					<h:panelGrid align="center" border="0" columns="2" width="100%">
						<h:outputText value="#{ms.pat_integr_segs_modal_msg_1 }"
							styleClass="textoBlancoNegrita" />
					</h:panelGrid>
				</f:facet>
				<f:facet name="controls">
					<h:panelGrid>
						<f:attribute name="align" value="right" />
						<h:graphicImage url="/img/aplicacion/icoCancelar.png"
							style="cursor:pointer"
							onclick="javascript: Richfaces.hideModalPanel('nuevoseguimentointegradoPac');" />
					</h:panelGrid>
				</f:facet>
				<h:panelGrid>
					<h:outputLabel style="font-weight: bold;" 
						value="#{ms.pat_integr_segs_modal_msg_2 }"/>
					<h:outputLabel style="font-weight: bold;" rendered="#{empty controlSeguimientos.listanuevosseg}"
						value="#{ms.pat_integr_segs_modal_msg_3 }"/>
					<t:dataTable styleClass="hor-minimalist-b" var="seg" width="100%" value="#{controlSeguimientos.listanuevosseg }"
						binding="#{controlSeguimientos.bindingNuevosSeg }" id="dataTableNuevoSegs" 
						rendered="#{not empty controlSeguimientos.listanuevosseg}">
						<t:column width="10%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="alignTop">								
								<h:graphicImage style="align:right;border:none;"
									styleClass="hvn_enlImagen" title="#{ms.ver }"
									width="24" height="24" url="/img/iconos/LastThreeMonths.png"/>
							</h:panelGrid>
						</t:column>
						<t:column width="90%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.fecha }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="alignTop">								
								<a4j:commandLink action="irSeguimientos" 
									actionListener="#{controlSeguimientos.cargaNuevoSeguimiento }"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');javascript:Richfaces.hideModalPanel('nuevoseguimentointegradoPac');">
									<h:outputLabel value="#{seg.fecha }">
										<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
									</h:outputLabel>
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>
					</t:dataTable>
				</h:panelGrid>
			</rich:modalPanel>
		</h:form>
	</ui:define>
</ui:composition>
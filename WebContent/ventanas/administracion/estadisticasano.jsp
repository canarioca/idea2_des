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
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="90%"
				style="margin-top: 15px;" id="panelMensual">

				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                 	 background-image:url(/cardioarritmiasMS/img/iconos/estadistica.png);
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0"  id="panelOpciones">
							<h:outputLabel value="Resumen de actividad anual" style="color: white;" />
							<h:panelGrid columns="5" columnClasses="right" >
								<a4j:commandLink
									actionListener="#{controlEstadisticas.limpiaMensual}"
									style="align:right;" reRender="panelMensual" title="Limpiar datos del formulario">
									<h:graphicImage url="/img/iconos/limpia.png" title="Limpiar"
										styleClass="hvn_enlImagen" width="24" height="24"
										style="border:none;" />
								</a4j:commandLink>
								<a4j:commandLink style="text-align: right;" reRender="panelMensual"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
									actionListener="#{controlEstadisticas.guardaDatosAnuales }"
									title="Guardar cambios" rendered="false">
									<h:graphicImage url="/img/iconos/save.png" style="border:0px;"
										title="Guardar test" />
								</a4j:commandLink>
								
								<h:commandLink 
									actionListener="#{controlEstadisticas.imprimeResumenMesAnio}"
									target="_blank" title="Imprimir informe de un mes"
									rendered="#{controlEstadisticas.mesMarcado ne null}">
									<h:graphicImage value="/img/iconos/print.png"
										width="22" height="22"
										style="border:none;" title="Imprimir Informe" />
								</h:commandLink>
								<a4j:commandLink title="Enviar informe" actionListener="#{controlEstadisticas.enviaInformeMesAnio}"
								rendered="false">
									<h:graphicImage value="/img/iconos/forward-mail.png" width="24"
										height="24" style="border:0;" />
								</a4j:commandLink>
								<t:commandLink actionListener="#{controlEstadisticas.generaExcelEstadisticas}" target="_blank" title="Generar Consulta">
									<h:graphicImage value="/img/iconos/excel_icon.png" width="32" height="32" style="border: 0px;"/>
								</t:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>

						<h:panelGrid columns="1" rendered="false">
							<h:outputText value="Histórico anual de mesas basculantes y registradores insertables de eventos (Holter insertable)"
								style="font-weight:bold;"/>
							<h:outputText value="Puede indicar los valores mensuales de los siguientes items:"
								style="font-style:italic;"/>
						</h:panelGrid>
						
					
					
						
					<rich:spacer height="30px"/>
					
					
					<a4j:jsFunction name="recargaDatos" actionListener="#{controlEstadisticas.recargaDatosMes }"
							reRender="panelMensual"/>
					<h:panelGrid columns="2" id="pinfomes">
						<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
							<h:outputText value="Seleccione el año de consulta"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
							<rich:inputNumberSpinner cycled="true" enableManualInput="false" inputSize="5" minValue="2000" 
								maxValue="#{controlEstadisticas.maxanio }" value="#{controlEstadisticas.datosmes.anio }">
								<a4j:support event="onchange" reRender="panelMensual" actionListener="#{controlEstadisticas.cambiaAnoMes}"/>	
							</rich:inputNumberSpinner>
						</h:panelGrid>
						<h:panelGrid rendered="#{controlEstadisticas.mesMarcado ne null}" columns="2">
							<h:outputText value="Mes seleccionado:"/>
							<h:outputText value="#{controlEstadisticas.descriMesMarcado}" style="font-weight:bold;"/>
						</h:panelGrid>
						
											
					</h:panelGrid>
					<rich:spacer height="30px"/>
					
					<h:panelGrid columns="1" width="100%" id="pTablaAnual">
					 
					<t:dataTable width="100%" rows="10"
							value="#{controlEstadisticas.lstEstAnuales}" var="linea"
							style="width:100%;background-color: #ffffff;
                     			background-repeat: no-repeat;
                     			background-position:right bottom;"
							styleClass="hor-minimalist-b"
							binding="#{controlEstadisticas.lstb}" rendered="false">
							

							<t:column width="10%" style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
										
								<h:outputText value="#{linea.tipo}"/>
							</t:column>
	
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="ENE" title="Enero" reRender="pinfomes,panelOpciones">
											<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="0"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[0]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>

							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="FEB" title="Febrero"  reRender="pinfomes,panelOpciones">
											<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="1"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>

										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[1]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="MAR" title="Marzo"  reRender="pinfomes,panelOpciones">
											<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="2"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[2]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="ABR" title="Abril"  reRender="pinfomes,panelOpciones">
											<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="3"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[3]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="MAY" title="Mayo"  reRender="pinfomes,panelOpciones">
											<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="4"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[4]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="JUN" title="Junio"  reRender="pinfomes,panelOpciones">
											<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="5"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[5]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="JUL" title="Julio"  reRender="pinfomes,panelOpciones">
										<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="6"
										actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[6]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="AGO" title="Agosto"  reRender="pinfomes,panelOpciones">
										<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="7"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[7]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="SEP" title="Septiembre"  reRender="pinfomes,panelOpciones">
										<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="8"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[8]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="OCT" title="Octubre"  reRender="pinfomes,panelOpciones">
										<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="9"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[9]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="NOV" title="Noviembre"  reRender="pinfomes,panelOpciones">
										<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="10"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[10]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="DIC" title="Diciembre"  reRender="pinfomes,panelOpciones">
										<a4j:actionparam assignTo="#{controlEstadisticas.mesMarcado}" value="11"
											actionListener="#{controlEstadisticas.iniMesMarcado}"/>
										
										</a4j:commandLink>
									</f:facet>
									<h:inputText size="3" value="#{linea.valor[11]}">
										<a4j:support event="onblur" 
										actionListener="#{controlEstadisticas.recargaLineasTotales}" reRender="pTablaAnual"/>
									</h:inputText>
							</t:column>
							
							<t:column style="text-align: left;"
								styleClass="hor-minimalist-b-row" >
									<f:facet name="header">
										<a4j:commandLink value="TOTAL" title="TOTAL ACUMULADO ACTUAL">
										</a4j:commandLink>
									</f:facet>
									<h:outputText  value="#{linea.total}" style="font-weight:bold;"/>
							</t:column>



						</t:dataTable>
					</h:panelGrid>
				
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
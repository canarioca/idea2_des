<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:jsflot="http://www.jsflot.org/taglib/jsflot"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid columns="2">
		<h:panelGrid>
			<h:outputLabel value="#{ms.est_basic_fechas_title }" style="font-weight: bold;" />					
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%">
				<h:panelGrid columns="4" cellspacing="0">
					<h:outputLabel value="#{ms.est_basic_fecha_desde }"/>
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlEstadisticas.fechaini_regevext }">
					</rich:calendar>
					<h:outputLabel value="#{ms.est_basic_fecha_hasta }"/>
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlEstadisticas.fechafin_regevext }">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid>
			<a4j:commandLink style="text-align: right;" reRender="panResultadosEstadisticasRegEvExt"
				actionListener="#{controlEstadisticas.generarEstadisticasRegEvExt}"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
				<h:graphicImage url="/img/iconos/ParameterReview.png" style="border:0px;"
					title="#{ms.est_basic_generar_title }" width="24" height="24"/>
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="panResultadosEstadisticasRegEvExt" columns="2" width="100%" columnClasses="alignTop,alignTop">
		<h:panelGrid rendered="#{controlEstadisticas.est_regevext eq true }" width="100%">
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">		 		
				<t:dataTable value="#{controlEstadisticas.regevextdiagfin}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingRegEvExtDiagFin}" styleClass="hor-minimalist-b">
		            <f:facet name="header">
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasRegEvExt">
							<h:outputText value="#{ms.est_basic_tab_elr_diag_fin }"/>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_elr_diag }" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="alignTop">								
							<h:outputLabel value="#{proc.tipo }"/>
						</h:panelGrid>
					</t:column>	
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_numero }" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="right" width="100%">								
							<h:outputLabel value="#{proc.numero }"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="right">
						<f:facet name="header">
							<h:outputText value="%" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="right" width="100%">								
							<h:outputLabel value="#{proc.porcentaje }"/>
						</h:panelGrid>
					</t:column>            
		        </t:dataTable>
		        <h:panelGrid>
					 <jsflot:flotChart id="chartRegEvExtDiagnosticoFin"
					  	value="#{controlEstadisticas.chartSeriesRegEvExtDiagFin}"
						actionListener="#{controlEstadisticas.chartActionListener}"
						testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						chartDraggable="true"
						chartClickable="true"
						chartZoomable="#{controlEstadisticas.chartDataRegEvExtDiagFin.chartZoomable}"
						reRender="clickedPanel"
						showLines="false"
						fillLines="#{controlEstadisticas.chartDataRegEvExtDiagFin.fillLines}"
						showDataPoints="#{controlEstadisticas.chartDataRegEvExtDiagFin.showDataPoints}"
						legendColumns="#{controlEstadisticas.chartDataRegEvExtDiagFin.legendColumns}"
						legendOpacity="#{controlEstadisticas.chartDataRegEvExtDiagFin.legendOpacity}"
						legendPosition="#{controlEstadisticas.chartDataRegEvExtDiagFin.legendPosition}"
						legendColor="#{controlEstadisticas.chartDataRegEvExtDiagFin.legendColor}"
						height="#{controlEstadisticas.chartDataRegEvExtDiagFin.height}"
						width="#{controlEstadisticas.chartDataRegEvExtDiagFin.width}"
						showTooltip="#{controlEstadisticas.chartDataRegEvExtDiagFin.showTooltip}"
						tooltipPosition="#{controlEstadisticas.chartDataRegEvExtDiagFin.tooltipPosition}"
						tooltipFollowMouse="#{controlEstadisticas.chartDataRegEvExtDiagFin.tooltipFollowMouse}"
						mode="#{controlEstadisticas.chartDataRegEvExtDiagFin.mode}"
						timeFormat="#{controlEstadisticas.chartDataRegEvExtDiagFin.timeFormat}"
						title="#{controlEstadisticas.chartDataRegEvExtDiagFin.title}"
						subtitle="#{controlEstadisticas.chartDataRegEvExtDiagFin.subtitle}"
						chartType="pie"
						showXaxisLabels="false"
						xaxisTitle="#{controlEstadisticas.chartDataRegEvExtDiagFin.xaxisTitle}"
						xaxisTitleRotation="#{controlEstadisticas.chartDataRegEvExtDiagFin.xaxisTitleRotation}"
						xaxisLabelRotation="#{controlEstadisticas.chartDataRegEvExtDiagFin.xaxisLabelRotation}"
						showYaxisLabels="false"
						yaxisTitle="#{controlEstadisticas.chartDataRegEvExtDiagFin.yaxisTitle}"
						yaxisTitleRotation="#{controlEstadisticas.chartDataRegEvExtDiagFin.yaxisTitleRotation}"
						yaxisLabelRotation="#{controlEstadisticas.chartDataRegEvExtDiagFin.yaxisLabelRotation}"
						numberOfXAxisTicks="#{controlEstadisticas.chartDataRegEvExtDiagFin.numberOfXAxisTicks}"
						xaxisMinValue="#{controlEstadisticas.chartDataRegEvExtDiagFin.xaxisMinValue}"
						xaxisMaxValue="#{controlEstadisticas.chartDataRegEvExtDiagFin.xaxisMaxValue}"
						numberOfYAxisTicks="#{controlEstadisticas.chartDataRegEvExtDiagFin.numberOfYAxisTicks}"
						yaxisMinValue="#{controlEstadisticas.chartDataRegEvExtDiagFin.yaxisMinValue}"
						markers="#{controlEstadisticas.chartDataRegEvExtDiagFin.markers}"
						markerPosition="#{controlEstadisticas.chartDataRegEvExtDiagFin.markerPosition}"
						yaxisMaxValue="#{controlEstadisticas.chartDataRegEvExtDiagFin.yaxisMaxValue}"
						crosshair="#{controlEstadisticas.chartDataRegEvExtDiagFin.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
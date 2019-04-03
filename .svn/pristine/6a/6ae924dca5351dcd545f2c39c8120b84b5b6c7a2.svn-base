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
							value="#{controlEstadisticas.fechaini_holter }">
					</rich:calendar>
					<h:outputLabel value="#{ms.est_basic_fecha_hasta }"/>
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlEstadisticas.fechafin_holter }">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid>
			<a4j:commandLink style="text-align: right;" reRender="panResultadosEstadisticasHolter"
				actionListener="#{controlEstadisticas.generarEstadisticasHolter}"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
				<h:graphicImage url="/img/iconos/ParameterReview.png" style="border:0px;"
					title="#{ms.est_basic_generar_title }" width="24" height="24"/>
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="panResultadosEstadisticasHolter" columns="2" width="100%" columnClasses="alignTop,alignTop">
		<h:panelGrid rendered="#{controlEstadisticas.est_holter eq true }" width="100%">
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">		 		
				<t:dataTable value="#{controlEstadisticas.holdiagfin}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingHolDiagFin}" styleClass="hor-minimalist-b">
		            <f:facet name="header">
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasHolter">
							<h:outputText value="#{ms.est_basic_tab_hol24_diag_fin }"/>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_hol24_diag }" />
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
					 <jsflot:flotChart id="chartHolDiagnosticoFin"
					  	value="#{controlEstadisticas.chartSeriesHolDiagFin}"
						actionListener="#{controlEstadisticas.chartActionListener}"
						testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						chartDraggable="true"
						chartClickable="true"
						chartZoomable="#{controlEstadisticas.chartDataHolDiagFin.chartZoomable}"
						reRender="clickedPanel"
						showLines="false"
						fillLines="#{controlEstadisticas.chartDataHolDiagFin.fillLines}"
						showDataPoints="#{controlEstadisticas.chartDataHolDiagFin.showDataPoints}"
						legendColumns="#{controlEstadisticas.chartDataHolDiagFin.legendColumns}"
						legendOpacity="#{controlEstadisticas.chartDataHolDiagFin.legendOpacity}"
						legendPosition="#{controlEstadisticas.chartDataHolDiagFin.legendPosition}"
						legendColor="#{controlEstadisticas.chartDataHolDiagFin.legendColor}"
						height="#{controlEstadisticas.chartDataHolDiagFin.height}"
						width="#{controlEstadisticas.chartDataHolDiagFin.width}"
						showTooltip="#{controlEstadisticas.chartDataHolDiagFin.showTooltip}"
						tooltipPosition="#{controlEstadisticas.chartDataHolDiagFin.tooltipPosition}"
						tooltipFollowMouse="#{controlEstadisticas.chartDataHolDiagFin.tooltipFollowMouse}"
						mode="#{controlEstadisticas.chartDataHolDiagFin.mode}"
						timeFormat="#{controlEstadisticas.chartDataHolDiagFin.timeFormat}"
						title="#{controlEstadisticas.chartDataHolDiagFin.title}"
						subtitle="#{controlEstadisticas.chartDataHolDiagFin.subtitle}"
						chartType="pie"
						showXaxisLabels="false"
						xaxisTitle="#{controlEstadisticas.chartDataHolDiagFin.xaxisTitle}"
						xaxisTitleRotation="#{controlEstadisticas.chartDataHolDiagFin.xaxisTitleRotation}"
						xaxisLabelRotation="#{controlEstadisticas.chartDataHolDiagFin.xaxisLabelRotation}"
						showYaxisLabels="false"
						yaxisTitle="#{controlEstadisticas.chartDataHolDiagFin.yaxisTitle}"
						yaxisTitleRotation="#{controlEstadisticas.chartDataHolDiagFin.yaxisTitleRotation}"
						yaxisLabelRotation="#{controlEstadisticas.chartDataHolDiagFin.yaxisLabelRotation}"
						numberOfXAxisTicks="#{controlEstadisticas.chartDataHolDiagFin.numberOfXAxisTicks}"
						xaxisMinValue="#{controlEstadisticas.chartDataHolDiagFin.xaxisMinValue}"
						xaxisMaxValue="#{controlEstadisticas.chartDataHolDiagFin.xaxisMaxValue}"
						numberOfYAxisTicks="#{controlEstadisticas.chartDataHolDiagFin.numberOfYAxisTicks}"
						yaxisMinValue="#{controlEstadisticas.chartDataHolDiagFin.yaxisMinValue}"
						markers="#{controlEstadisticas.chartDataHolDiagFin.markers}"
						markerPosition="#{controlEstadisticas.chartDataHolDiagFin.markerPosition}"
						yaxisMaxValue="#{controlEstadisticas.chartDataHolDiagFin.yaxisMaxValue}"
						crosshair="#{controlEstadisticas.chartDataHolDiagFin.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
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
						value="#{controlEstadisticas.fechaini_mesa }">
					</rich:calendar>
					<h:outputLabel value="#{ms.est_basic_fecha_hasta }"/>
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlEstadisticas.fechafin_mesa }">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid>
			<a4j:commandLink style="text-align: right;" reRender="panResultadosEstadisticasMesa"
				actionListener="#{controlEstadisticas.generarEstadisticasMesaBasculante}"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
				<h:graphicImage url="/img/iconos/ParameterReview.png" style="border:0px;"
					title="#{ms.est_basic_generar_title }" width="24" height="24"/>
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="panResultadosEstadisticasMesa" columns="2" width="90%" columnClasses="alignTop,alignTop">
		<h:panelGrid rendered="#{controlEstadisticas.est_mesa eq true }" width="90%">
			<h:panelGrid width="100" columns="2" columnClasses="alignTop,alignRight">
		 		<t:dataTable value="#{controlEstadisticas.mesares}" var="proc" width="70%"
					binding="#{controlEstadisticas.bindingMesaRes}" styleClass="hor-minimalist-b">
		            <f:facet name="header">
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasMesa">
							<h:outputText value="#{ms.est_basic_tab_mesa_resultado }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
							title="Generar gráfica" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_mesa_resultado }" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="alignTop">								
							<h:outputLabel value="#{proc.tipo }"/>
						</h:panelGrid>
					</t:column>	
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_numero } (%)" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="right" width="100%">								
							<h:outputLabel value="#{proc.numero }"/>
							<h:outputLabel value="(#{proc.porcentaje }%)"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_mesa_ntg }" title="#{ms.est_basic_tab_mesa_ntg_title }"/>
						</f:facet>
						<h:panelGrid columns="2" columnClasses="right" width="100%">								
							<h:outputLabel value="#{proc.numero2 }"/>
							<h:outputLabel value="(#{proc.porcentaje2 }%)"/>
						</h:panelGrid>
					</t:column>            
		        </t:dataTable>
		        <h:panelGrid>
					 <jsflot:flotChart id="chartMesaBasculanteResultado"
							        value="#{controlEstadisticas.chartSeriesMesaRes}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataMesaRes.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataMesaRes.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataMesaRes.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataMesaRes.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataMesaRes.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataMesaRes.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataMesaRes.legendColor}"
							        height="#{controlEstadisticas.chartDataMesaRes.height}"
							        width="#{controlEstadisticas.chartDataMesaRes.width}"
							        showTooltip="#{controlEstadisticas.chartDataMesaRes.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataMesaRes.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataMesaRes.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataMesaRes.mode}"
							        timeFormat="#{controlEstadisticas.chartDataMesaRes.timeFormat}"
							        title="#{controlEstadisticas.chartDataMesaRes.title}"
							        subtitle="#{controlEstadisticas.chartDataMesaRes.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataMesaRes.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataMesaRes.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataMesaRes.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataMesaRes.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataMesaRes.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataMesaRes.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataMesaRes.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataMesaRes.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataMesaRes.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataMesaRes.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataMesaRes.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataMesaRes.markers}"
							        markerPosition="#{controlEstadisticas.chartDataMesaRes.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataMesaRes.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataMesaRes.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>
				
		</h:panelGrid>
		
	</h:panelGrid>
	<rich:modalPanel id="graficasEstadisticasMesa" autosized="true" zindex="2000" minWidth="550" 
		onshow="JSFlot.AJAX.Submit('estadisticasbasicas', 'refresh', document.location, new JSFlot.Options(null, null, null, 
		'estadisticasbasicas_estMesaTab_chartMesa'));">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="Mesa Basculante"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid>
				<a4j:commandLink
					onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasMesa');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasMesa')"
						title="Cancelar" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
			<jsflot:flotChart id="chartMesa"
			        value="#{controlEstadisticas.chartSeries}"
			        actionListener="#{controlEstadisticas.chartActionListener}"
			        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
			        chartDraggable="true"
			        chartClickable="true"
			        chartZoomable="#{controlEstadisticas.chartDataMesa.chartZoomable}"
			        reRender="clickedPanel"
			        showLines="false"
			        fillLines="#{controlEstadisticas.chartDataMesa.fillLines}"
			        showDataPoints="#{controlEstadisticas.chartDataMesa.showDataPoints}"
			        legendColumns="#{controlEstadisticas.chartDataMesa.legendColumns}"
			        legendOpacity="#{controlEstadisticas.chartDataMesa.legendOpacity}"
			        legendPosition="#{controlEstadisticas.chartDataMesa.legendPosition}"
			        legendColor="#{controlEstadisticas.chartDataMesa.legendColor}"
			        height="250"
			        width="550"
			        showTooltip="#{controlEstadisticas.chartDataMesa.showTooltip}"
			        tooltipPosition="#{controlEstadisticas.chartDataMesa.tooltipPosition}"
			        tooltipFollowMouse="#{controlEstadisticas.chartDataMesa.tooltipFollowMouse}"
			        mode="#{controlEstadisticas.chartDataMesa.mode}"
			        timeFormat="#{controlEstadisticas.chartDataMesa.timeFormat}"
			        title="#{controlEstadisticas.chartDataMesa.title}"
			        subtitle="#{controlEstadisticas.chartDataMesa.subtitle}"
			        chartType="pie"
			        showXaxisLabels="false"
			        xaxisTitle="#{controlEstadisticas.chartDataMesa.xaxisTitle}"
			        xaxisTitleRotation="#{controlEstadisticas.chartDataMesa.xaxisTitleRotation}"
			        xaxisLabelRotation="#{controlEstadisticas.chartDataMesa.xaxisLabelRotation}"
			        showYaxisLabels="false"
			        yaxisTitle="#{controlEstadisticas.chartDataMesa.yaxisTitle}"
			        yaxisTitleRotation="#{controlEstadisticas.chartDataMesa.yaxisTitleRotation}"
			        yaxisLabelRotation="#{controlEstadisticas.chartDataMesa.yaxisLabelRotation}"
			        numberOfXAxisTicks="#{controlEstadisticas.chartDataMesa.numberOfXAxisTicks}"
			        xaxisMinValue="#{controlEstadisticas.chartDataMesa.xaxisMinValue}"
			        xaxisMaxValue="#{controlEstadisticas.chartDataMesa.xaxisMaxValue}"
			        numberOfYAxisTicks="#{controlEstadisticas.chartDataMesa.numberOfYAxisTicks}"
			        yaxisMinValue="#{controlEstadisticas.chartDataMesa.yaxisMinValue}"
			        markers="#{controlEstadisticas.chartDataMesa.markers}"
			        markerPosition="#{controlEstadisticas.chartDataMesa.markerPosition}"
			        yaxisMaxValue="#{controlEstadisticas.chartDataMesa.yaxisMaxValue}"
			        crosshair="#{controlEstadisticas.chartDataMesa.crosshair}">
			    </jsflot:flotChart>
	</rich:modalPanel>
</ui:composition>
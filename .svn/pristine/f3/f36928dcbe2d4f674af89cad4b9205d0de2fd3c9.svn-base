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
						value="#{controlEstadisticas.fechaini_test }">
					</rich:calendar>
					<h:outputLabel value="#{ms.est_basic_fecha_hasta }"/>
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlEstadisticas.fechafin_test }">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid>
			<a4j:commandLink style="text-align: right;" reRender="panResultadosEstadisticasTest"
				actionListener="#{controlEstadisticas.generarEstadisticasTest}"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
				<h:graphicImage url="/img/iconos/ParameterReview.png" style="border:0px;"
					title="#{ms.est_basic_generar_title }" width="24" height="24"/>
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="panResultadosEstadisticasTest" columns="2" width="100%" columnClasses="alignTop,alignTop">
		<h:panelGrid rendered="#{controlEstadisticas.est_test eq true }" width="100%">			
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
		 		<t:dataTable value="#{controlEstadisticas.testatp1}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingTestAtp1}" styleClass="hor-minimalist-b">
		            <f:facet name="header">            
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasTest">
							<h:outputText value="#{ms.est_basic_tab_test_atp }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_test_resultado }" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="alignTop">								
							<h:outputLabel value="#{proc.tipo }"/>
						</h:panelGrid>
					</t:column>	
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_test_atp_dosis1 }" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="right" width="100%">								
							<h:outputLabel value="#{proc.numero }"/>
							<h:outputLabel value="(#{proc.porcentaje}%)"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_test_atp_dosis2 }" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="right" width="100%">								
							<h:outputLabel value="#{proc.numero2 }"/>
							<h:outputLabel value="(#{proc.porcentaje2}%)"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_test_atp_fin }" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="right" width="100%">								
							<h:outputLabel value="#{proc.numero3}"/>
							<h:outputLabel value="(#{proc.porcentaje3}%)"/>
						</h:panelGrid>
					</t:column>            
		        </t:dataTable>
		        <h:panelGrid>
					 <jsflot:flotChart id="chartTestAtp"
							        value="#{controlEstadisticas.chartSeriesAtpRes}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataAtpRes.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataAtpRes.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataAtpRes.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataAtpRes.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataAtpRes.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataAtpRes.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataAtpRes.legendColor}"
							        height="#{controlEstadisticas.chartDataAtpRes.height}"
							        width="#{controlEstadisticas.chartDataAtpRes.width}"
							        showTooltip="#{controlEstadisticas.chartDataAtpRes.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataAtpRes.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataAtpRes.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataAtpRes.mode}"
							        timeFormat="#{controlEstadisticas.chartDataAtpRes.timeFormat}"
							        title="#{controlEstadisticas.chartDataAtpRes.title}"
							        subtitle="#{controlEstadisticas.chartDataAtpRes.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataAtpRes.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataAtpRes.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataAtpRes.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataAtpRes.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataAtpRes.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataAtpRes.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataAtpRes.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataAtpRes.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataAtpRes.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataAtpRes.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataAtpRes.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataAtpRes.markers}"
							        markerPosition="#{controlEstadisticas.chartDataAtpRes.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataAtpRes.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataAtpRes.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
				<t:dataTable value="#{controlEstadisticas.testepi}" var="proc" width="70%"
					binding="#{controlEstadisticas.bindingTestEpi}" styleClass="hor-minimalist-b">
		            <f:facet name="header">      
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasTest">
							 <h:outputText value="#{ms.est_basic_tab_test_epi }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
							title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_test_resultado }" />
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
					 <jsflot:flotChart id="chartTestEpi"
							        value="#{controlEstadisticas.chartSeriesEpiRes}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataEpiRes.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataEpiRes.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataEpiRes.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataEpiRes.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataEpiRes.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataEpiRes.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataEpiRes.legendColor}"
							        height="#{controlEstadisticas.chartDataEpiRes.height}"
							        width="#{controlEstadisticas.chartDataEpiRes.width}"
							        showTooltip="#{controlEstadisticas.chartDataEpiRes.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataEpiRes.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataEpiRes.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataEpiRes.mode}"
							        timeFormat="#{controlEstadisticas.chartDataEpiRes.timeFormat}"
							        title="#{controlEstadisticas.chartDataEpiRes.title}"
							        subtitle="#{controlEstadisticas.chartDataEpiRes.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataEpiRes.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataEpiRes.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataEpiRes.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataEpiRes.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataEpiRes.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataEpiRes.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataEpiRes.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataEpiRes.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataEpiRes.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataEpiRes.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataEpiRes.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataEpiRes.markers}"
							        markerPosition="#{controlEstadisticas.chartDataEpiRes.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataEpiRes.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataEpiRes.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
				<t:dataTable value="#{controlEstadisticas.testfle}" var="proc" width="70%"
					binding="#{controlEstadisticas.bindingTestFle}" styleClass="hor-minimalist-b">
		            <f:facet name="header">		              
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasTest">
							 <h:outputText value="#{ms.est_basic_tab_test_fle }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
							title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_test_resultado }" />
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
					 <jsflot:flotChart id="chartTestFle"
							        value="#{controlEstadisticas.chartSeriesFleRes}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataFleRes.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataFleRes.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataFleRes.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataFleRes.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataFleRes.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataFleRes.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataFleRes.legendColor}"
							        height="#{controlEstadisticas.chartDataFleRes.height}"
							        width="#{controlEstadisticas.chartDataFleRes.width}"
							        showTooltip="#{controlEstadisticas.chartDataFleRes.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataFleRes.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataFleRes.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataFleRes.mode}"
							        timeFormat="#{controlEstadisticas.chartDataFleRes.timeFormat}"
							        title="#{controlEstadisticas.chartDataFleRes.title}"
							        subtitle="#{controlEstadisticas.chartDataFleRes.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataFleRes.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataFleRes.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataFleRes.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataFleRes.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataFleRes.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataFleRes.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataFleRes.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataFleRes.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataFleRes.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataFleRes.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataFleRes.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataFleRes.markers}"
							        markerPosition="#{controlEstadisticas.chartDataFleRes.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataFleRes.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataFleRes.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>	
			</h:panelGrid>
		</h:panelGrid>
		
	</h:panelGrid>
	<rich:modalPanel id="graficasEstadisticasTest" autosized="true" zindex="2000" minWidth="550" 
		onshow="JSFlot.AJAX.Submit('estadisticasbasicas', 'refresh', document.location, new JSFlot.Options(null, null, null, 
		'estadisticasbasicas_estTestTab_chartTest'));">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="Test farmacológico"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid>
				<a4j:commandLink
					onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasTest');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasTest')"
						title="Cancelar" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
			<jsflot:flotChart id="chartTest"
			        value="#{controlEstadisticas.chartSeries}"
			        actionListener="#{controlEstadisticas.chartActionListener}"
			        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
			        chartDraggable="true"
			        chartClickable="true"
			        chartZoomable="#{controlEstadisticas.chartDataTest.chartZoomable}"
			        reRender="clickedPanel"
			        showLines="false"
			        fillLines="#{controlEstadisticas.chartDataTest.fillLines}"
			        showDataPoints="#{controlEstadisticas.chartDataTest.showDataPoints}"
			        legendColumns="#{controlEstadisticas.chartDataTest.legendColumns}"
			        legendOpacity="#{controlEstadisticas.chartDataTest.legendOpacity}"
			        legendPosition="#{controlEstadisticas.chartDataTest.legendPosition}"
			        legendColor="#{controlEstadisticas.chartDataTest.legendColor}"
			        height="250"
			        width="550"
			        showTooltip="#{controlEstadisticas.chartDataTest.showTooltip}"
			        tooltipPosition="#{controlEstadisticas.chartDataTest.tooltipPosition}"
			        tooltipFollowMouse="#{controlEstadisticas.chartDataTest.tooltipFollowMouse}"
			        mode="#{controlEstadisticas.chartDataTest.mode}"
			        timeFormat="#{controlEstadisticas.chartDataTest.timeFormat}"
			        title="#{controlEstadisticas.chartDataTest.title}"
			        subtitle="#{controlEstadisticas.chartDataTest.subtitle}"
			        chartType="pie"
			        showXaxisLabels="false"
			        xaxisTitle="#{controlEstadisticas.chartDataTest.xaxisTitle}"
			        xaxisTitleRotation="#{controlEstadisticas.chartDataTest.xaxisTitleRotation}"
			        xaxisLabelRotation="#{controlEstadisticas.chartDataTest.xaxisLabelRotation}"
			        showYaxisLabels="false"
			        yaxisTitle="#{controlEstadisticas.chartDataTest.yaxisTitle}"
			        yaxisTitleRotation="#{controlEstadisticas.chartDataTest.yaxisTitleRotation}"
			        yaxisLabelRotation="#{controlEstadisticas.chartDataTest.yaxisLabelRotation}"
			        numberOfXAxisTicks="#{controlEstadisticas.chartDataTest.numberOfXAxisTicks}"
			        xaxisMinValue="#{controlEstadisticas.chartDataTest.xaxisMinValue}"
			        xaxisMaxValue="#{controlEstadisticas.chartDataTest.xaxisMaxValue}"
			        numberOfYAxisTicks="#{controlEstadisticas.chartDataTest.numberOfYAxisTicks}"
			        yaxisMinValue="#{controlEstadisticas.chartDataTest.yaxisMinValue}"
			        markers="#{controlEstadisticas.chartDataTest.markers}"
			        markerPosition="#{controlEstadisticas.chartDataTest.markerPosition}"
			        yaxisMaxValue="#{controlEstadisticas.chartDataTest.yaxisMaxValue}"
			        crosshair="#{controlEstadisticas.chartDataTest.crosshair}">
			    </jsflot:flotChart>
	</rich:modalPanel>
</ui:composition>
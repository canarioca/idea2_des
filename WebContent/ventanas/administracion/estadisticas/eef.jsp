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
						value="#{controlEstadisticas.fechaini_eef }">
					</rich:calendar>
					<h:outputLabel value="#{ms.est_basic_fecha_hasta }"/>
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlEstadisticas.fechafin_eef }">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid>
			<a4j:commandLink style="text-align: right;" reRender="panResultadosEstadisticasEef"
				actionListener="#{controlEstadisticas.generarEstadisticasEef}"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
				<h:graphicImage url="/img/iconos/ParameterReview.png" style="border:0px;"
					title="#{ms.est_basic_generar_title }" width="24" height="24"/>
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="panResultadosEstadisticasEef" columns="2" width="100%" columnClasses="alignTop,alignTop">
		<h:panelGrid rendered="#{controlEstadisticas.est_eef eq true }" width="100%">
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignTop">
		 		<t:dataTable value="#{controlEstadisticas.eefcar}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingEefCar}" styleClass="hor-minimalist-b">
		            <f:facet name="header">	                
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasEef">
							<h:outputText value="#{ms.est_basic_tab_eef_total }:#{controlEstadisticas.reseef1 })"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_eef_accion }" />
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
					<jsflot:flotChart id="chartEefRealizados"
							        value="#{controlEstadisticas.chartSeriesEefReal}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataEefReal.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataEefReal.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataEefReal.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataEefReal.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataEefReal.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataEefReal.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataEefReal.legendColor}"
							        height="#{controlEstadisticas.chartDataEefReal.height}"
							        width="#{controlEstadisticas.chartDataEefReal.width}"
							        showTooltip="#{controlEstadisticas.chartDataEefReal.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataEefReal.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataEefReal.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataEefReal.mode}"
							        timeFormat="#{controlEstadisticas.chartDataEefReal.timeFormat}"
							        title="#{controlEstadisticas.chartDataEefReal.title}"
							        subtitle="#{controlEstadisticas.chartDataEefReal.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataEefReal.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataEefReal.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataEefReal.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataEefReal.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataEefReal.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataEefReal.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataEefReal.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataEefReal.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataEefReal.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataEefReal.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataEefReal.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataEefReal.markers}"
							        markerPosition="#{controlEstadisticas.chartDataEefReal.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataEefReal.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataEefReal.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
				<t:dataTable value="#{controlEstadisticas.eefdiag}" var="proc" width="70%"
					binding="#{controlEstadisticas.bindingEefDiag}" styleClass="hor-minimalist-b">
		            <f:facet name="header">	                
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasEef"
							>
							<h:outputText value="#{ms.est_basic_tab_eef_diagn }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
							title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_eef_diagn }" />
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
					<jsflot:flotChart id="chartEefDiagnostico"
							        value="#{controlEstadisticas.chartSeriesEefDiag}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataEefDiag.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataEefDiag.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataEefDiag.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataEefDiag.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataEefDiag.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataEefDiag.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataEefDiag.legendColor}"
							        height="#{controlEstadisticas.chartDataEefDiag.height}"
							        width="#{controlEstadisticas.chartDataEefDiag.width}"
							        showTooltip="#{controlEstadisticas.chartDataEefDiag.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataEefDiag.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataEefDiag.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataEefDiag.mode}"
							        timeFormat="#{controlEstadisticas.chartDataEefDiag.timeFormat}"
							        title="#{controlEstadisticas.chartDataEefDiag.title}"
							        subtitle="#{controlEstadisticas.chartDataEefDiag.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataEefDiag.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataEefDiag.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataEefDiag.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataEefDiag.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataEefDiag.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataEefDiag.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataEefDiag.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataEefDiag.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataEefDiag.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataEefDiag.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataEefDiag.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataEefDiag.markers}"
							        markerPosition="#{controlEstadisticas.chartDataEefDiag.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataEefDiag.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataEefDiag.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
				<t:dataTable value="#{controlEstadisticas.eefint}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingEefInt}" styleClass="hor-minimalist-b">
		            <f:facet name="header">		                
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasEef"
							>
							<h:outputText value="#{ms.est_basic_tab_eef_abl_no }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
							title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_eef_abl_no_causa }" />
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
					<jsflot:flotChart id="chartEefIntentoAblacion"
							        value="#{controlEstadisticas.chartSeriesEefAblNo}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataEefAblNo.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataEefAblNo.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataEefAblNo.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataEefAblNo.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataEefAblNo.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataEefAblNo.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataEefAblNo.legendColor}"
							        height="#{controlEstadisticas.chartDataEefAblNo.height}"
							        width="#{controlEstadisticas.chartDataEefAblNo.width}"
							        showTooltip="#{controlEstadisticas.chartDataEefAblNo.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataEefAblNo.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataEefAblNo.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataEefAblNo.mode}"
							        timeFormat="#{controlEstadisticas.chartDataEefAblNo.timeFormat}"
							        title="#{controlEstadisticas.chartDataEefAblNo.title}"
							        subtitle="#{controlEstadisticas.chartDataEefAblNo.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataEefAblNo.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataEefAblNo.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataEefAblNo.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataEefAblNo.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataEefAblNo.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataEefAblNo.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataEefAblNo.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataEefAblNo.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataEefAblNo.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataEefAblNo.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataEefAblNo.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataEefAblNo.markers}"
							        markerPosition="#{controlEstadisticas.chartDataEefAblNo.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataEefAblNo.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataEefAblNo.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>				
			</h:panelGrid>
			<h:panelGrid width="100%">
				<t:fieldset legend="#{ms.est_basic_tab_eef_abl_sust_title }" >
					<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
						<t:dataTable value="#{controlEstadisticas.eefablsust}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingEefAblSust}" styleClass="hor-minimalist-b">
				            <t:column width="50%" headerstyleClass="left">
								<f:facet name="header">
									<a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasEef"
										>
										<h:outputText value="#{ms.est_basic_tab_eef_abl_sust_abord }" />
										<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
										title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
									</a4j:commandLink>
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
							<jsflot:flotChart id="chartEefSustratoAblacion"
							        value="#{controlEstadisticas.chartSeriesEefSust}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataEefSust.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataEefSust.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataEefSust.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataEefSust.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataEefSust.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataEefSust.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataEefSust.legendColor}"
							        height="#{controlEstadisticas.chartDataEefSust.height}"
							        width="#{controlEstadisticas.chartDataEefSust.width}"
							        showTooltip="#{controlEstadisticas.chartDataEefSust.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataEefSust.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataEefSust.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataEefSust.mode}"
							        timeFormat="#{controlEstadisticas.chartDataEefSust.timeFormat}"
							        title="#{controlEstadisticas.chartDataEefSust.title}"
							        subtitle="#{controlEstadisticas.chartDataEefSust.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataEefSust.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataEefSust.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataEefSust.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataEefSust.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataEefSust.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataEefSust.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataEefSust.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataEefSust.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataEefSust.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataEefSust.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataEefSust.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataEefSust.markers}"
							        markerPosition="#{controlEstadisticas.chartDataEefSust.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataEefSust.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataEefSust.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
				        <t:dataTable value="#{controlEstadisticas.eefablres}" var="proc" width="70%"
							binding="#{controlEstadisticas.bindingEefAblRes}" styleClass="hor-minimalist-b">
				            <t:column width="50%" headerstyleClass="left">
								<f:facet name="header">
									
									<a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasEef"
										>
										<h:outputText value="#{ms.est_basic_tab_eef_resultado }" />									
										<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
										title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
									</a4j:commandLink>
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
							<jsflot:flotChart id="chartEefResultadoAblacion"
							        value="#{controlEstadisticas.chartSeriesEefRes}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataEefRes.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataEefRes.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataEefRes.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataEefRes.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataEefRes.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataEefRes.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataEefRes.legendColor}"
							        height="#{controlEstadisticas.chartDataEefRes.height}"
							        width="#{controlEstadisticas.chartDataEefRes.width}"
							        showTooltip="#{controlEstadisticas.chartDataEefRes.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataEefRes.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataEefRes.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataEefRes.mode}"
							        timeFormat="#{controlEstadisticas.chartDataEefRes.timeFormat}"
							        title="#{controlEstadisticas.chartDataEefRes.title}"
							        subtitle="#{controlEstadisticas.chartDataEefRes.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataEefRes.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataEefRes.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataEefRes.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataEefRes.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataEefRes.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataEefRes.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataEefRes.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataEefRes.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataEefRes.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataEefRes.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataEefRes.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataEefRes.markers}"
							        markerPosition="#{controlEstadisticas.chartDataEefRes.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataEefRes.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataEefRes.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
				</t:fieldset>
			</h:panelGrid>
			<h:panelGrid width="100%">
				<t:fieldset legend="#{ms.compli_proc_title }" >
					<h:outputLabel value="#{ms.compli_proc_eef_diag_title }" style="font-weight: bold;color:#E17009"/>
					<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
				 		<t:dataTable value="#{controlEstadisticas.eefcompdiag}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingEefCompDiag}" styleClass="hor-minimalist-b">
				            <t:column width="50%" headerstyleClass="left">
								<f:facet name="header">
									<h:outputText value="#{ms.compli_table_title_1 }" />
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
							<jsflot:flotChart id="chartEefCompDiag"
								value="#{controlEstadisticas.chartSeriesEefCompDiag}" 
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataEefCompDiag.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataEefCompDiag.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataEefCompDiag.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataEefCompDiag.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataEefCompDiag.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataEefCompDiag.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataEefCompDiag.legendColor}"
								height="#{controlEstadisticas.chartDataEefCompDiag.height}"
								width="#{controlEstadisticas.chartDataEefCompDiag.width}"
								showTooltip="#{controlEstadisticas.chartDataEefCompDiag.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataEefCompDiag.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataEefCompDiag.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataEefCompDiag.mode}"
								timeFormat="#{controlEstadisticas.chartDataEefCompDiag.timeFormat}"
								title="#{controlEstadisticas.chartDataEefCompDiag.title}"
								subtitle="#{controlEstadisticas.chartDataEefCompDiag.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataEefCompDiag.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataEefCompDiag.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataEefCompDiag.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataEefCompDiag.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataEefCompDiag.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataEefCompDiag.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataEefCompDiag.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataEefCompDiag.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataEefCompDiag.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataEefCompDiag.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataEefCompDiag.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataEefCompDiag.markers}"
								markerPosition="#{controlEstadisticas.chartDataEefCompDiag.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataEefCompDiag.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataEefCompDiag.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
				 		<t:dataTable value="#{controlEstadisticas.eefcompdiagtipo}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingEefCompDiagTipo}" styleClass="hor-minimalist-b">
				            <t:column width="50%" headerstyleClass="left">
								<f:facet name="header">
									<h:outputText value="#{ms.compli_est_tipo }" />
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
							 <jsflot:flotChart id="chartEefCompDiagTipo"
								value="#{controlEstadisticas.chartSeriesEefCompDiagTipo}" 
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataEefCompTipoDiag.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataEefCompTipoDiag.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataEefCompTipoDiag.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataEefCompTipoDiag.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataEefCompTipoDiag.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataEefCompTipoDiag.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataEefCompTipoDiag.legendColor}"
								height="#{controlEstadisticas.chartDataEefCompTipoDiag.height}"
								width="#{controlEstadisticas.chartDataEefCompTipoDiag.width}"
								showTooltip="#{controlEstadisticas.chartDataEefCompTipoDiag.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataEefCompTipoDiag.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataEefCompTipoDiag.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataEefCompTipoDiag.mode}"
								timeFormat="#{controlEstadisticas.chartDataEefCompTipoDiag.timeFormat}"
								title="#{controlEstadisticas.chartDataEefCompTipoDiag.title}"
								subtitle="#{controlEstadisticas.chartDataEefCompTipoDiag.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataEefCompTipoDiag.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataEefCompTipoDiag.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataEefCompTipoDiag.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataEefCompTipoDiag.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataEefCompTipoDiag.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataEefCompTipoDiag.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataEefCompTipoDiag.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataEefCompTipoDiag.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataEefCompTipoDiag.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataEefCompTipoDiag.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataEefCompTipoDiag.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataEefCompTipoDiag.markers}"
								markerPosition="#{controlEstadisticas.chartDataEefCompTipoDiag.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataEefCompTipoDiag.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataEefCompTipoDiag.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:outputLabel value="#{ms.compli_proc_eef_abl_title }" style="font-weight: bold;color:#E17009"/>
					
					<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
				 		<t:dataTable value="#{controlEstadisticas.eefcompabl}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingEefCompAbl}" styleClass="hor-minimalist-b">
				            <t:column width="50%" headerstyleClass="left">
								<f:facet name="header">
									<h:outputText value="#{ms.compli_table_title_1 }" />
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
							 <jsflot:flotChart id="chartEefCompAbl"
								value="#{controlEstadisticas.chartSeriesEefCompAbl}" 
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataEefCompAbl.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataEefCompAbl.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataEefCompAbl.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataEefCompAbl.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataEefCompAbl.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataEefCompAbl.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataEefCompAbl.legendColor}"
								height="#{controlEstadisticas.chartDataEefCompAbl.height}"
								width="#{controlEstadisticas.chartDataEefCompAbl.width}"
								showTooltip="#{controlEstadisticas.chartDataEefCompAbl.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataEefCompAbl.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataEefCompAbl.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataEefCompAbl.mode}"
								timeFormat="#{controlEstadisticas.chartDataEefCompAbl.timeFormat}"
								title="#{controlEstadisticas.chartDataEefCompAbl.title}"
								subtitle="#{controlEstadisticas.chartDataEefCompAbl.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataEefCompAbl.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataEefCompAbl.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataEefCompAbl.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataEefCompAbl.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataEefCompAbl.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataEefCompAbl.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataEefCompAbl.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataEefCompAbl.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataEefCompAbl.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataEefCompAbl.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataEefCompAbl.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataEefCompAbl.markers}"
								markerPosition="#{controlEstadisticas.chartDataEefCompAbl.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataEefCompAbl.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataEefCompAbl.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
				 		<t:dataTable value="#{controlEstadisticas.eefcompabltipo}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingEefCompAblTipo}" styleClass="hor-minimalist-b">
				            <t:column width="50%" headerstyleClass="left">
								<f:facet name="header">
									<h:outputText value="#{ms.compli_est_tipo }" />
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
							 <jsflot:flotChart id="chartEefCompAblTipo"
								value="#{controlEstadisticas.chartSeriesEefCompAblTipo}" 
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataEefCompTipoAbl.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataEefCompTipoAbl.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataEefCompTipoAbl.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataEefCompTipoAbl.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataEefCompTipoAbl.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataEefCompTipoAbl.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataEefCompTipoAbl.legendColor}"
								height="#{controlEstadisticas.chartDataEefCompTipoAbl.height}"
								width="#{controlEstadisticas.chartDataEefCompTipoAbl.width}"
								showTooltip="#{controlEstadisticas.chartDataEefCompTipoAbl.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataEefCompTipoAbl.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataEefCompTipoAbl.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataEefCompTipoAbl.mode}"
								timeFormat="#{controlEstadisticas.chartDataEefCompTipoAbl.timeFormat}"
								title="#{controlEstadisticas.chartDataEefCompTipoAbl.title}"
								subtitle="#{controlEstadisticas.chartDataEefCompTipoAbl.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataEefCompTipoAbl.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataEefCompTipoAbl.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataEefCompTipoAbl.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataEefCompTipoAbl.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataEefCompTipoAbl.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataEefCompTipoAbl.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataEefCompTipoAbl.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataEefCompTipoAbl.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataEefCompTipoAbl.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataEefCompTipoAbl.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataEefCompTipoAbl.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataEefCompTipoAbl.markers}"
								markerPosition="#{controlEstadisticas.chartDataEefCompTipoAbl.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataEefCompTipoAbl.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataEefCompTipoAbl.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
					
					
				</t:fieldset>
			</h:panelGrid>
			
		</h:panelGrid>
		
	</h:panelGrid>
	<rich:modalPanel id="graficasEstadisticasEef" autosized="true" zindex="2000" minWidth="550" 
		onshow="JSFlot.AJAX.Submit('estadisticasbasicas', 'refresh', document.location, new JSFlot.Options(null, null, null, 
		'estadisticasbasicas_estEefTab_chartEef'));">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="Estudio EF"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid>
				<a4j:commandLink
					onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasEef');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasEef')"
						title="Cancelar" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
			<jsflot:flotChart id="chartEef"
			        value="#{controlEstadisticas.chartSeries}"
			        actionListener="#{controlEstadisticas.chartActionListener}"
			        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
			        chartDraggable="true"
			        chartClickable="true"
			        chartZoomable="#{controlEstadisticas.chartDataEef.chartZoomable}"
			        reRender="clickedPanel"
			        showLines="false"
			        fillLines="#{controlEstadisticas.chartDataEef.fillLines}"
			        showDataPoints="#{controlEstadisticas.chartDataEef.showDataPoints}"
			        legendColumns="#{controlEstadisticas.chartDataEef.legendColumns}"
			        legendOpacity="#{controlEstadisticas.chartDataEef.legendOpacity}"
			        legendPosition="#{controlEstadisticas.chartDataEef.legendPosition}"
			        legendColor="#{controlEstadisticas.chartDataEef.legendColor}"
			        height="250"
			        width="#{controlEstadisticas.chartDataEef.width}"
			        showTooltip="#{controlEstadisticas.chartDataEef.showTooltip}"
			        tooltipPosition="#{controlEstadisticas.chartDataEef.tooltipPosition}"
			        tooltipFollowMouse="#{controlEstadisticas.chartDataEef.tooltipFollowMouse}"
			        mode="#{controlEstadisticas.chartDataEef.mode}"
			        timeFormat="#{controlEstadisticas.chartDataEef.timeFormat}"
			        title="#{controlEstadisticas.chartDataEef.title}"
			        subtitle="#{controlEstadisticas.chartDataEef.subtitle}"
			        chartType="pie"
			        showXaxisLabels="false"
			        xaxisTitle="#{controlEstadisticas.chartDataEef.xaxisTitle}"
			        xaxisTitleRotation="#{controlEstadisticas.chartDataEef.xaxisTitleRotation}"
			        xaxisLabelRotation="#{controlEstadisticas.chartDataEef.xaxisLabelRotation}"
			        showYaxisLabels="false"
			        yaxisTitle="#{controlEstadisticas.chartDataEef.yaxisTitle}"
			        yaxisTitleRotation="#{controlEstadisticas.chartDataEef.yaxisTitleRotation}"
			        yaxisLabelRotation="#{controlEstadisticas.chartDataEef.yaxisLabelRotation}"
			        numberOfXAxisTicks="#{controlEstadisticas.chartDataEef.numberOfXAxisTicks}"
			        xaxisMinValue="#{controlEstadisticas.chartDataEef.xaxisMinValue}"
			        xaxisMaxValue="#{controlEstadisticas.chartDataEef.xaxisMaxValue}"
			        numberOfYAxisTicks="#{controlEstadisticas.chartDataEef.numberOfYAxisTicks}"
			        yaxisMinValue="#{controlEstadisticas.chartDataEef.yaxisMinValue}"
			        markers="#{controlEstadisticas.chartDataEef.markers}"
			        markerPosition="#{controlEstadisticas.chartDataEef.markerPosition}"
			        yaxisMaxValue="#{controlEstadisticas.chartDataEef.yaxisMaxValue}"
			        crosshair="#{controlEstadisticas.chartDataEef.crosshair}">
			    </jsflot:flotChart>
	</rich:modalPanel>
</ui:composition>
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
						value="#{controlEstadisticas.fechaini_reg }">
					</rich:calendar>
					<h:outputLabel value="#{ms.est_basic_fecha_hasta }"/>
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlEstadisticas.fechafin_reg }">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid>
			<a4j:commandLink style="text-align: right;" reRender="panResultadosEstadisticasRegistrador"
				actionListener="#{controlEstadisticas.generarEstadisticasRegistrador}"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
				<h:graphicImage url="/img/iconos/ParameterReview.png" style="border:0px;"
					title="#{ms.est_basic_generar_title }" width="24" height="24"/>
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="panResultadosEstadisticasRegistrador" width="100%" columnClasses="alignTop,alignTop">
		<h:panelGrid rendered="#{controlEstadisticas.est_reg eq true }" width="100%">
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
				<t:dataTable value="#{controlEstadisticas.regfab}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingRegFab}" styleClass="hor-minimalist-b">
		            <f:facet name="header">
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasRegistrador">
							<h:outputText value="#{ms.est_basic_tab_regev_fabricante }"/>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_regev_fabricante }" />
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
					 <jsflot:flotChart id="chartRegFabricante"
					 	value="#{controlEstadisticas.chartSeriesRegFab}"
						actionListener="#{controlEstadisticas.chartActionListener}"
						testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						chartDraggable="true"
						chartClickable="true"
						chartZoomable="#{controlEstadisticas.chartDataRegFab.chartZoomable}"
						reRender="clickedPanel"
						showLines="false"
						fillLines="#{controlEstadisticas.chartDataRegFab.fillLines}"
						showDataPoints="#{controlEstadisticas.chartDataRegFab.showDataPoints}"
						legendColumns="#{controlEstadisticas.chartDataRegFab.legendColumns}"
						legendOpacity="#{controlEstadisticas.chartDataRegFab.legendOpacity}"
						legendPosition="#{controlEstadisticas.chartDataRegFab.legendPosition}"
						legendColor="#{controlEstadisticas.chartDataRegFab.legendColor}"
						height="#{controlEstadisticas.chartDataRegFab.height}"
						width="#{controlEstadisticas.chartDataRegFab.width}"
						showTooltip="#{controlEstadisticas.chartDataRegFab.showTooltip}"
						tooltipPosition="#{controlEstadisticas.chartDataRegFab.tooltipPosition}"
						tooltipFollowMouse="#{controlEstadisticas.chartDataRegFab.tooltipFollowMouse}"
						mode="#{controlEstadisticas.chartDataRegFab.mode}"
						timeFormat="#{controlEstadisticas.chartDataRegFab.timeFormat}"
						title="#{controlEstadisticas.chartDataRegFab.title}"
						subtitle="#{controlEstadisticas.chartDataRegFab.subtitle}"
						chartType="pie"
						showXaxisLabels="false"
						xaxisTitle="#{controlEstadisticas.chartDataRegFab.xaxisTitle}"
						xaxisTitleRotation="#{controlEstadisticas.chartDataRegFab.xaxisTitleRotation}"
						xaxisLabelRotation="#{controlEstadisticas.chartDataRegFab.xaxisLabelRotation}"
						showYaxisLabels="false"
						yaxisTitle="#{controlEstadisticas.chartDataRegFab.yaxisTitle}"
						yaxisTitleRotation="#{controlEstadisticas.chartDataRegFab.yaxisTitleRotation}"
						yaxisLabelRotation="#{controlEstadisticas.chartDataRegFab.yaxisLabelRotation}"
						numberOfXAxisTicks="#{controlEstadisticas.chartDataRegFab.numberOfXAxisTicks}"
						xaxisMinValue="#{controlEstadisticas.chartDataRegFab.xaxisMinValue}"
						xaxisMaxValue="#{controlEstadisticas.chartDataRegFab.xaxisMaxValue}"
						numberOfYAxisTicks="#{controlEstadisticas.chartDataRegFab.numberOfYAxisTicks}"
						yaxisMinValue="#{controlEstadisticas.chartDataRegFab.yaxisMinValue}"
						markers="#{controlEstadisticas.chartDataRegFab.markers}"
						markerPosition="#{controlEstadisticas.chartDataRegFab.markerPosition}"
						yaxisMaxValue="#{controlEstadisticas.chartDataRegFab.yaxisMaxValue}"
						crosshair="#{controlEstadisticas.chartDataRegFab.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
		 		<t:dataTable value="#{controlEstadisticas.regind}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingRegInd}" styleClass="hor-minimalist-b">
		            <f:facet name="header">
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasRegistrador">
							<h:outputText value="#{ms.est_basic_tab_regev_indicacion }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
							title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_regev_indicacion }" />
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
					 <jsflot:flotChart id="chartRegIndicacion"
							        value="#{controlEstadisticas.chartSeriesRegInd}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataRegInd.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataRegInd.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataRegInd.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataRegInd.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataRegInd.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataRegInd.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataRegInd.legendColor}"
							        height="#{controlEstadisticas.chartDataRegInd.height}"
							        width="#{controlEstadisticas.chartDataRegInd.width}"
							        showTooltip="#{controlEstadisticas.chartDataRegInd.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataRegInd.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataRegInd.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataRegInd.mode}"
							        timeFormat="#{controlEstadisticas.chartDataRegInd.timeFormat}"
							        title="#{controlEstadisticas.chartDataRegInd.title}"
							        subtitle="#{controlEstadisticas.chartDataRegInd.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataRegInd.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataRegInd.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataRegInd.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataRegInd.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataRegInd.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataRegInd.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataRegInd.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataRegInd.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataRegInd.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataRegInd.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataRegInd.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataRegInd.markers}"
							        markerPosition="#{controlEstadisticas.chartDataRegInd.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataRegInd.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataRegInd.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
				<t:dataTable value="#{controlEstadisticas.regmot}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingRegMot}" styleClass="hor-minimalist-b">
		            <f:facet name="header">
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasRegistrador">
							<h:outputText value="#{ms.est_basic_tab_regev_diag }"/>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
							title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_regev_diag }" />
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
					 <jsflot:flotChart id="chartRegDiagnostico"
							        value="#{controlEstadisticas.chartSeriesRegDiag}"
							        actionListener="#{controlEstadisticas.chartActionListener}"
							        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							        chartDraggable="true"
							        chartClickable="true"
							        chartZoomable="#{controlEstadisticas.chartDataRegDiag.chartZoomable}"
							        reRender="clickedPanel"
							        showLines="false"
							        fillLines="#{controlEstadisticas.chartDataRegDiag.fillLines}"
							        showDataPoints="#{controlEstadisticas.chartDataRegDiag.showDataPoints}"
							        legendColumns="#{controlEstadisticas.chartDataRegDiag.legendColumns}"
							        legendOpacity="#{controlEstadisticas.chartDataRegDiag.legendOpacity}"
							        legendPosition="#{controlEstadisticas.chartDataRegDiag.legendPosition}"
							        legendColor="#{controlEstadisticas.chartDataRegDiag.legendColor}"
							        height="#{controlEstadisticas.chartDataRegDiag.height}"
							        width="#{controlEstadisticas.chartDataRegDiag.width}"
							        showTooltip="#{controlEstadisticas.chartDataRegDiag.showTooltip}"
							        tooltipPosition="#{controlEstadisticas.chartDataRegDiag.tooltipPosition}"
							        tooltipFollowMouse="#{controlEstadisticas.chartDataRegDiag.tooltipFollowMouse}"
							        mode="#{controlEstadisticas.chartDataRegDiag.mode}"
							        timeFormat="#{controlEstadisticas.chartDataRegDiag.timeFormat}"
							        title="#{controlEstadisticas.chartDataRegDiag.title}"
							        subtitle="#{controlEstadisticas.chartDataRegDiag.subtitle}"
							        chartType="pie"
							        showXaxisLabels="false"
							        xaxisTitle="#{controlEstadisticas.chartDataRegDiag.xaxisTitle}"
							        xaxisTitleRotation="#{controlEstadisticas.chartDataRegDiag.xaxisTitleRotation}"
							        xaxisLabelRotation="#{controlEstadisticas.chartDataRegDiag.xaxisLabelRotation}"
							        showYaxisLabels="false"
							        yaxisTitle="#{controlEstadisticas.chartDataRegDiag.yaxisTitle}"
							        yaxisTitleRotation="#{controlEstadisticas.chartDataRegDiag.yaxisTitleRotation}"
							        yaxisLabelRotation="#{controlEstadisticas.chartDataRegDiag.yaxisLabelRotation}"
							        numberOfXAxisTicks="#{controlEstadisticas.chartDataRegDiag.numberOfXAxisTicks}"
							        xaxisMinValue="#{controlEstadisticas.chartDataRegDiag.xaxisMinValue}"
							        xaxisMaxValue="#{controlEstadisticas.chartDataRegDiag.xaxisMaxValue}"
							        numberOfYAxisTicks="#{controlEstadisticas.chartDataRegDiag.numberOfYAxisTicks}"
							        yaxisMinValue="#{controlEstadisticas.chartDataRegDiag.yaxisMinValue}"
							        markers="#{controlEstadisticas.chartDataRegDiag.markers}"
							        markerPosition="#{controlEstadisticas.chartDataRegDiag.markerPosition}"
							        yaxisMaxValue="#{controlEstadisticas.chartDataRegDiag.yaxisMaxValue}"
							        crosshair="#{controlEstadisticas.chartDataRegDiag.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid width="100%">
					<t:fieldset legend="#{ms.compli_proc_title }" >
						<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
					 		<t:dataTable value="#{controlEstadisticas.regcomp}" var="proc" width="90%"
								binding="#{controlEstadisticas.bindingRegComp}" styleClass="hor-minimalist-b">
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
								 <jsflot:flotChart id="chartRegComp"
									value="#{controlEstadisticas.chartSeriesRegComp}" 
									actionListener="#{controlEstadisticas.chartActionListener}"
									testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
									chartDraggable="true"
									chartClickable="true"
									chartZoomable="#{controlEstadisticas.chartDataRegComp.chartZoomable}"
									reRender="clickedPanel"
									showLines="false"
									fillLines="#{controlEstadisticas.chartDataRegComp.fillLines}"
									showDataPoints="#{controlEstadisticas.chartDataRegComp.showDataPoints}"
									legendColumns="#{controlEstadisticas.chartDataRegComp.legendColumns}"
									legendOpacity="#{controlEstadisticas.chartDataRegComp.legendOpacity}"
									legendPosition="#{controlEstadisticas.chartDataRegComp.legendPosition}"
									legendColor="#{controlEstadisticas.chartDataRegComp.legendColor}"
									height="#{controlEstadisticas.chartDataRegComp.height}"
									width="#{controlEstadisticas.chartDataRegComp.width}"
									showTooltip="#{controlEstadisticas.chartDataRegComp.showTooltip}"
									tooltipPosition="#{controlEstadisticas.chartDataRegComp.tooltipPosition}"
									tooltipFollowMouse="#{controlEstadisticas.chartDataRegComp.tooltipFollowMouse}"
									mode="#{controlEstadisticas.chartDataRegComp.mode}"
									timeFormat="#{controlEstadisticas.chartDataRegComp.timeFormat}"
									title="#{controlEstadisticas.chartDataRegComp.title}"
									subtitle="#{controlEstadisticas.chartDataRegComp.subtitle}"
									chartType="pie"
									showXaxisLabels="false"
									xaxisTitle="#{controlEstadisticas.chartDataRegComp.xaxisTitle}"
									xaxisTitleRotation="#{controlEstadisticas.chartDataRegComp.xaxisTitleRotation}"
									xaxisLabelRotation="#{controlEstadisticas.chartDataRegComp.xaxisLabelRotation}"
									showYaxisLabels="false"
									yaxisTitle="#{controlEstadisticas.chartDataRegComp.yaxisTitle}"
									yaxisTitleRotation="#{controlEstadisticas.chartDataRegComp.yaxisTitleRotation}"
									yaxisLabelRotation="#{controlEstadisticas.chartDataRegComp.yaxisLabelRotation}"
									numberOfXAxisTicks="#{controlEstadisticas.chartDataRegComp.numberOfXAxisTicks}"
									xaxisMinValue="#{controlEstadisticas.chartDataRegComp.xaxisMinValue}"
									xaxisMaxValue="#{controlEstadisticas.chartDataRegComp.xaxisMaxValue}"
									numberOfYAxisTicks="#{controlEstadisticas.chartDataRegComp.numberOfYAxisTicks}"
									yaxisMinValue="#{controlEstadisticas.chartDataRegComp.yaxisMinValue}"
									markers="#{controlEstadisticas.chartDataRegComp.markers}"
									markerPosition="#{controlEstadisticas.chartDataRegComp.markerPosition}"
									yaxisMaxValue="#{controlEstadisticas.chartDataRegComp.yaxisMaxValue}"
									crosshair="#{controlEstadisticas.chartDataRegComp.crosshair}">
								</jsflot:flotChart>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
					 		<t:dataTable value="#{controlEstadisticas.regcomptipo}" var="proc" width="90%"
								binding="#{controlEstadisticas.bindingRegCompTipo}" styleClass="hor-minimalist-b">
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
								 <jsflot:flotChart id="chartRegCompTipo"
									value="#{controlEstadisticas.chartSeriesRegCompTipo}" 
									actionListener="#{controlEstadisticas.chartActionListener}"
									testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
									chartDraggable="true"
									chartClickable="true"
									chartZoomable="#{controlEstadisticas.chartDataRegCompTipo.chartZoomable}"
									reRender="clickedPanel"
									showLines="false"
									fillLines="#{controlEstadisticas.chartDataRegCompTipo.fillLines}"
									showDataPoints="#{controlEstadisticas.chartDataRegCompTipo.showDataPoints}"
									legendColumns="#{controlEstadisticas.chartDataRegCompTipo.legendColumns}"
									legendOpacity="#{controlEstadisticas.chartDataRegCompTipo.legendOpacity}"
									legendPosition="#{controlEstadisticas.chartDataRegCompTipo.legendPosition}"
									legendColor="#{controlEstadisticas.chartDataRegCompTipo.legendColor}"
									height="#{controlEstadisticas.chartDataRegCompTipo.height}"
									width="#{controlEstadisticas.chartDataRegCompTipo.width}"
									showTooltip="#{controlEstadisticas.chartDataRegCompTipo.showTooltip}"
									tooltipPosition="#{controlEstadisticas.chartDataRegCompTipo.tooltipPosition}"
									tooltipFollowMouse="#{controlEstadisticas.chartDataRegCompTipo.tooltipFollowMouse}"
									mode="#{controlEstadisticas.chartDataRegCompTipo.mode}"
									timeFormat="#{controlEstadisticas.chartDataRegCompTipo.timeFormat}"
									title="#{controlEstadisticas.chartDataRegCompTipo.title}"
									subtitle="#{controlEstadisticas.chartDataRegCompTipo.subtitle}"
									chartType="pie"
									showXaxisLabels="false"
									xaxisTitle="#{controlEstadisticas.chartDataRegCompTipo.xaxisTitle}"
									xaxisTitleRotation="#{controlEstadisticas.chartDataRegCompTipo.xaxisTitleRotation}"
									xaxisLabelRotation="#{controlEstadisticas.chartDataRegCompTipo.xaxisLabelRotation}"
									showYaxisLabels="false"
									yaxisTitle="#{controlEstadisticas.chartDataRegCompTipo.yaxisTitle}"
									yaxisTitleRotation="#{controlEstadisticas.chartDataRegCompTipo.yaxisTitleRotation}"
									yaxisLabelRotation="#{controlEstadisticas.chartDataRegCompTipo.yaxisLabelRotation}"
									numberOfXAxisTicks="#{controlEstadisticas.chartDataRegCompTipo.numberOfXAxisTicks}"
									xaxisMinValue="#{controlEstadisticas.chartDataRegCompTipo.xaxisMinValue}"
									xaxisMaxValue="#{controlEstadisticas.chartDataRegCompTipo.xaxisMaxValue}"
									numberOfYAxisTicks="#{controlEstadisticas.chartDataRegCompTipo.numberOfYAxisTicks}"
									yaxisMinValue="#{controlEstadisticas.chartDataRegCompTipo.yaxisMinValue}"
									markers="#{controlEstadisticas.chartDataRegCompTipo.markers}"
									markerPosition="#{controlEstadisticas.chartDataRegCompTipo.markerPosition}"
									yaxisMaxValue="#{controlEstadisticas.chartDataRegCompTipo.yaxisMaxValue}"
									crosshair="#{controlEstadisticas.chartDataRegCompTipo.crosshair}">
								</jsflot:flotChart>
							</h:panelGrid>
						</h:panelGrid>
					</t:fieldset>
				</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<rich:modalPanel id="graficasEstadisticasRegistrador" autosized="true" zindex="2000" minWidth="550" 
		onshow="JSFlot.AJAX.Submit('estadisticasbasicas', 'refresh', document.location, new JSFlot.Options(null, null, null, 
		'estadisticasbasicas_estRegTab_chartReg'));">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="Registrador de eventos"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid>
				<a4j:commandLink
					onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasRegistrador');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasRegistrador')"
						title="Cancelar" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
			<jsflot:flotChart id="chartReg"
			        value="#{controlEstadisticas.chartSeries}"
			        actionListener="#{controlEstadisticas.chartActionListener}"
			        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
			        chartDraggable="true"
			        chartClickable="true"
			        chartZoomable="#{controlEstadisticas.chartDataReg.chartZoomable}"
			        reRender="clickedPanel"
			        showLines="false"
			        fillLines="#{controlEstadisticas.chartDataReg.fillLines}"
			        showDataPoints="#{controlEstadisticas.chartDataReg.showDataPoints}"
			        legendColumns="#{controlEstadisticas.chartDataReg.legendColumns}"
			        legendOpacity="#{controlEstadisticas.chartDataReg.legendOpacity}"
			        legendPosition="#{controlEstadisticas.chartDataReg.legendPosition}"
			        legendColor="#{controlEstadisticas.chartDataReg.legendColor}"
			        height="250"
			        width="550"
			        showTooltip="#{controlEstadisticas.chartDataReg.showTooltip}"
			        tooltipPosition="#{controlEstadisticas.chartDataReg.tooltipPosition}"
			        tooltipFollowMouse="#{controlEstadisticas.chartDataReg.tooltipFollowMouse}"
			        mode="#{controlEstadisticas.chartDataReg.mode}"
			        timeFormat="#{controlEstadisticas.chartDataReg.timeFormat}"
			        title="#{controlEstadisticas.chartDataReg.title}"
			        subtitle="#{controlEstadisticas.chartDataReg.subtitle}"
			        chartType="pie"
			        showXaxisLabels="false"
			        xaxisTitle="#{controlEstadisticas.chartDataReg.xaxisTitle}"
			        xaxisTitleRotation="#{controlEstadisticas.chartDataReg.xaxisTitleRotation}"
			        xaxisLabelRotation="#{controlEstadisticas.chartDataReg.xaxisLabelRotation}"
			        showYaxisLabels="false"
			        yaxisTitle="#{controlEstadisticas.chartDataReg.yaxisTitle}"
			        yaxisTitleRotation="#{controlEstadisticas.chartDataReg.yaxisTitleRotation}"
			        yaxisLabelRotation="#{controlEstadisticas.chartDataReg.yaxisLabelRotation}"
			        numberOfXAxisTicks="#{controlEstadisticas.chartDataReg.numberOfXAxisTicks}"
			        xaxisMinValue="#{controlEstadisticas.chartDataReg.xaxisMinValue}"
			        xaxisMaxValue="#{controlEstadisticas.chartDataReg.xaxisMaxValue}"
			        numberOfYAxisTicks="#{controlEstadisticas.chartDataReg.numberOfYAxisTicks}"
			        yaxisMinValue="#{controlEstadisticas.chartDataReg.yaxisMinValue}"
			        markers="#{controlEstadisticas.chartDataReg.markers}"
			        markerPosition="#{controlEstadisticas.chartDataReg.markerPosition}"
			        yaxisMaxValue="#{controlEstadisticas.chartDataReg.yaxisMaxValue}"
			        crosshair="#{controlEstadisticas.chartDataReg.crosshair}">
			    </jsflot:flotChart>
	</rich:modalPanel>
</ui:composition>
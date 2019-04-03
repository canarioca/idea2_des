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
							value="#{controlEstadisticas.fechaini_cv }">
					</rich:calendar>
					<h:outputLabel value="#{ms.est_basic_fecha_hasta }"/>
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left"
							value="#{controlEstadisticas.fechafin_cv }">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid>
			<a4j:commandLink style="text-align: right;" reRender="panResultadosEstadisticasCv"
				actionListener="#{controlEstadisticas.generarEstadisticasCv}"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
				<h:graphicImage url="/img/iconos/ParameterReview.png" style="border:0px;"
					title="#{ms.est_basic_generar_title }" width="24" height="24"/>
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="panResultadosEstadisticasCv" columns="2" width="98%" columnClasses="alignTop,alignTop">
		<h:panelGrid rendered="#{controlEstadisticas.est_cv eq true }" width="90%">
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
		 		<t:dataTable value="#{controlEstadisticas.cvind}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingCvInd}" styleClass="hor-minimalist-b">
		            <f:facet name="header">		                	
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasCv">
							<h:outputText value="#{ms.est_basic_tab_cve_indicacion }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
							title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>          		
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_cve_indicacion }" />
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
					<jsflot:flotChart id="chartCvIndicacion"
						value="#{controlEstadisticas.chartSeriesCvInd}"
						actionListener="#{controlEstadisticas.chartActionListener}"
						testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						chartDraggable="true"
						chartClickable="true"
						chartZoomable="#{controlEstadisticas.chartDataCvInd.chartZoomable}"
						reRender="clickedPanel"
						showLines="false"
						fillLines="#{controlEstadisticas.chartDataCvInd.fillLines}"
						showDataPoints="#{controlEstadisticas.chartDataCvInd.showDataPoints}"
						legendColumns="#{controlEstadisticas.chartDataCvInd.legendColumns}"
						legendOpacity="#{controlEstadisticas.chartDataCvInd.legendOpacity}"
						legendPosition="#{controlEstadisticas.chartDataCvInd.legendPosition}"
						legendColor="#{controlEstadisticas.chartDataCvInd.legendColor}"
						height="#{controlEstadisticas.chartDataCvInd.height}"
						width="#{controlEstadisticas.chartDataCvInd.width}"
						showTooltip="#{controlEstadisticas.chartDataCvInd.showTooltip}"
						tooltipPosition="#{controlEstadisticas.chartDataCvInd.tooltipPosition}"
						tooltipFollowMouse="#{controlEstadisticas.chartDataCvInd.tooltipFollowMouse}"
						mode="#{controlEstadisticas.chartDataCvInd.mode}"
						timeFormat="#{controlEstadisticas.chartDataCvInd.timeFormat}"
						title="#{controlEstadisticas.chartDataCvInd.title}"
						subtitle="#{controlEstadisticas.chartDataCvInd.subtitle}"
						chartType="pie"
						showXaxisLabels="false"
						xaxisTitle="#{controlEstadisticas.chartDataCvInd.xaxisTitle}"
						xaxisTitleRotation="#{controlEstadisticas.chartDataCvInd.xaxisTitleRotation}"
						xaxisLabelRotation="#{controlEstadisticas.chartDataCvInd.xaxisLabelRotation}"
						showYaxisLabels="false"
						yaxisTitle="#{controlEstadisticas.chartDataCvInd.yaxisTitle}"
						yaxisTitleRotation="#{controlEstadisticas.chartDataCvInd.yaxisTitleRotation}"
						yaxisLabelRotation="#{controlEstadisticas.chartDataCvInd.yaxisLabelRotation}"
						numberOfXAxisTicks="#{controlEstadisticas.chartDataCvInd.numberOfXAxisTicks}"
						xaxisMinValue="#{controlEstadisticas.chartDataCvInd.xaxisMinValue}"
						xaxisMaxValue="#{controlEstadisticas.chartDataCvInd.xaxisMaxValue}"
						numberOfYAxisTicks="#{controlEstadisticas.chartDataCvInd.numberOfYAxisTicks}"
						yaxisMinValue="#{controlEstadisticas.chartDataCvInd.yaxisMinValue}"
						markers="#{controlEstadisticas.chartDataCvInd.markers}"
						markerPosition="#{controlEstadisticas.chartDataCvInd.markerPosition}"
						yaxisMaxValue="#{controlEstadisticas.chartDataCvInd.yaxisMaxValue}"
						crosshair="#{controlEstadisticas.chartDataCvInd.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
		 		<t:dataTable value="#{controlEstadisticas.cvres}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingCvRes}" styleClass="hor-minimalist-b">
		            <f:facet name="header">		                
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasCv">
							<h:outputText value="#{ms.est_basic_tab_cve_exito_final }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_cve_resultado }" />
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
					 <jsflot:flotChart id="chartCvExito"
						value="#{controlEstadisticas.chartSeriesCvExito}"
						actionListener="#{controlEstadisticas.chartActionListener}"
						testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						chartDraggable="true"
						chartClickable="true"
						chartZoomable="#{controlEstadisticas.chartDataCvExito.chartZoomable}"
						reRender="clickedPanel"
						showLines="false"
						fillLines="#{controlEstadisticas.chartDataCvExito.fillLines}"
						showDataPoints="#{controlEstadisticas.chartDataCvExito.showDataPoints}"
						legendColumns="#{controlEstadisticas.chartDataCvExito.legendColumns}"
						legendOpacity="#{controlEstadisticas.chartDataCvExito.legendOpacity}"
						legendPosition="#{controlEstadisticas.chartDataCvExito.legendPosition}"
						legendColor="#{controlEstadisticas.chartDataCvExito.legendColor}"
						height="#{controlEstadisticas.chartDataCvExito.height}"
						width="#{controlEstadisticas.chartDataCvExito.width}"
						showTooltip="#{controlEstadisticas.chartDataCvExito.showTooltip}"
						tooltipPosition="#{controlEstadisticas.chartDataCvExito.tooltipPosition}"
						tooltipFollowMouse="#{controlEstadisticas.chartDataCvExito.tooltipFollowMouse}"
						mode="#{controlEstadisticas.chartDataCvExito.mode}"
						timeFormat="#{controlEstadisticas.chartDataCvExito.timeFormat}"
						title="#{controlEstadisticas.chartDataCvExito.title}"
						subtitle="#{controlEstadisticas.chartDataCvExito.subtitle}"
						chartType="pie"
						showXaxisLabels="false"
						xaxisTitle="#{controlEstadisticas.chartDataCvExito.xaxisTitle}"
						xaxisTitleRotation="#{controlEstadisticas.chartDataCvExito.xaxisTitleRotation}"
						xaxisLabelRotation="#{controlEstadisticas.chartDataCvExito.xaxisLabelRotation}"
						showYaxisLabels="false"
						yaxisTitle="#{controlEstadisticas.chartDataCvExito.yaxisTitle}"
						yaxisTitleRotation="#{controlEstadisticas.chartDataCvExito.yaxisTitleRotation}"
						yaxisLabelRotation="#{controlEstadisticas.chartDataCvExito.yaxisLabelRotation}"
						numberOfXAxisTicks="#{controlEstadisticas.chartDataCvExito.numberOfXAxisTicks}"
						xaxisMinValue="#{controlEstadisticas.chartDataCvExito.xaxisMinValue}"
						xaxisMaxValue="#{controlEstadisticas.chartDataCvExito.xaxisMaxValue}"
						numberOfYAxisTicks="#{controlEstadisticas.chartDataCvExito.numberOfYAxisTicks}"
						yaxisMinValue="#{controlEstadisticas.chartDataCvExito.yaxisMinValue}"
						markers="#{controlEstadisticas.chartDataCvExito.markers}"
						markerPosition="#{controlEstadisticas.chartDataCvExito.markerPosition}"
						yaxisMaxValue="#{controlEstadisticas.chartDataCvExito.yaxisMaxValue}"
						crosshair="#{controlEstadisticas.chartDataCvExito.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
		 		<t:dataTable value="#{controlEstadisticas.cvabl}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingCvAbl}" styleClass="hor-minimalist-b">
		            <f:facet name="header">
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasCv">
							<h:outputText value="#{ms.est_basic_tab_cve_ablacion }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_valor }" />
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
					 <jsflot:flotChart id="chartCvAblacion"
						value="#{controlEstadisticas.chartSeriesCvAbl}"
						actionListener="#{controlEstadisticas.chartActionListener}"
						testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						chartDraggable="true"
						chartClickable="true"
						chartZoomable="#{controlEstadisticas.chartDatacvAbl.chartZoomable}"
						reRender="clickedPanel"
						showLines="false"
						fillLines="#{controlEstadisticas.chartDatacvAbl.fillLines}"
						showDataPoints="#{controlEstadisticas.chartDatacvAbl.showDataPoints}"
						legendColumns="#{controlEstadisticas.chartDatacvAbl.legendColumns}"
						legendOpacity="#{controlEstadisticas.chartDatacvAbl.legendOpacity}"
						legendPosition="#{controlEstadisticas.chartDatacvAbl.legendPosition}"
						legendColor="#{controlEstadisticas.chartDatacvAbl.legendColor}"
						height="#{controlEstadisticas.chartDatacvAbl.height}"
						width="#{controlEstadisticas.chartDatacvAbl.width}"
						showTooltip="#{controlEstadisticas.chartDatacvAbl.showTooltip}"
						tooltipPosition="#{controlEstadisticas.chartDatacvAbl.tooltipPosition}"
						tooltipFollowMouse="#{controlEstadisticas.chartDatacvAbl.tooltipFollowMouse}"
						mode="#{controlEstadisticas.chartDatacvAbl.mode}"
						timeFormat="#{controlEstadisticas.chartDatacvAbl.timeFormat}"
						title="#{controlEstadisticas.chartDatacvAbl.title}"
						subtitle="#{controlEstadisticas.chartDatacvAbl.subtitle}"
						chartType="pie"
						showXaxisLabels="false"
						xaxisTitle="#{controlEstadisticas.chartDatacvAbl.xaxisTitle}"
						xaxisTitleRotation="#{controlEstadisticas.chartDatacvAbl.xaxisTitleRotation}"
						xaxisLabelRotation="#{controlEstadisticas.chartDatacvAbl.xaxisLabelRotation}"
						showYaxisLabels="false"
						yaxisTitle="#{controlEstadisticas.chartDatacvAbl.yaxisTitle}"
						yaxisTitleRotation="#{controlEstadisticas.chartDatacvAbl.yaxisTitleRotation}"
						yaxisLabelRotation="#{controlEstadisticas.chartDatacvAbl.yaxisLabelRotation}"
						numberOfXAxisTicks="#{controlEstadisticas.chartDatacvAbl.numberOfXAxisTicks}"
						xaxisMinValue="#{controlEstadisticas.chartDatacvAbl.xaxisMinValue}"
						xaxisMaxValue="#{controlEstadisticas.chartDatacvAbl.xaxisMaxValue}"
						numberOfYAxisTicks="#{controlEstadisticas.chartDatacvAbl.numberOfYAxisTicks}"
						yaxisMinValue="#{controlEstadisticas.chartDatacvAbl.yaxisMinValue}"
						markers="#{controlEstadisticas.chartDatacvAbl.markers}"
						markerPosition="#{controlEstadisticas.chartDatacvAbl.markerPosition}"
						yaxisMaxValue="#{controlEstadisticas.chartDatacvAbl.yaxisMaxValue}"
						crosshair="#{controlEstadisticas.chartDatacvAbl.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>	
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
		 		<t:dataTable value="#{controlEstadisticas.cvtipo}" var="proc" width="90%"
					binding="#{controlEstadisticas.bindingCvTipo}" styleClass="hor-minimalist-b">
		            <f:facet name="header">		                
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasCv">
							<h:outputText value="#{ms.est_basic_tab_cve_tipoproc }"></h:outputText>
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_cve_resultado }" />
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
					 <jsflot:flotChart id="chartCvTipo"
						value="#{controlEstadisticas.chartSeriesCvTipo}" 
						actionListener="#{controlEstadisticas.chartActionListener}"
						testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						chartDraggable="true"
						chartClickable="true"
						chartZoomable="#{controlEstadisticas.chartDatacvTipo.chartZoomable}"
						reRender="clickedPanel"
						showLines="false"
						fillLines="#{controlEstadisticas.chartDatacvTipo.fillLines}"
						showDataPoints="#{controlEstadisticas.chartDatacvTipo.showDataPoints}"
						legendColumns="#{controlEstadisticas.chartDatacvTipo.legendColumns}"
						legendOpacity="#{controlEstadisticas.chartDatacvTipo.legendOpacity}"
						legendPosition="#{controlEstadisticas.chartDatacvTipo.legendPosition}"
						legendColor="#{controlEstadisticas.chartDatacvTipo.legendColor}"
						height="#{controlEstadisticas.chartDatacvTipo.height}"
						width="#{controlEstadisticas.chartDatacvTipo.width}"
						showTooltip="#{controlEstadisticas.chartDatacvTipo.showTooltip}"
						tooltipPosition="#{controlEstadisticas.chartDatacvTipo.tooltipPosition}"
						tooltipFollowMouse="#{controlEstadisticas.chartDatacvTipo.tooltipFollowMouse}"
						mode="#{controlEstadisticas.chartDatacvTipo.mode}"
						timeFormat="#{controlEstadisticas.chartDatacvTipo.timeFormat}"
						title="#{controlEstadisticas.chartDatacvTipo.title}"
						subtitle="#{controlEstadisticas.chartDatacvTipo.subtitle}"
						chartType="pie"
						showXaxisLabels="false"
						xaxisTitle="#{controlEstadisticas.chartDatacvTipo.xaxisTitle}"
						xaxisTitleRotation="#{controlEstadisticas.chartDatacvTipo.xaxisTitleRotation}"
						xaxisLabelRotation="#{controlEstadisticas.chartDatacvTipo.xaxisLabelRotation}"
						showYaxisLabels="false"
						yaxisTitle="#{controlEstadisticas.chartDatacvTipo.yaxisTitle}"
						yaxisTitleRotation="#{controlEstadisticas.chartDatacvTipo.yaxisTitleRotation}"
						yaxisLabelRotation="#{controlEstadisticas.chartDatacvTipo.yaxisLabelRotation}"
						numberOfXAxisTicks="#{controlEstadisticas.chartDatacvTipo.numberOfXAxisTicks}"
						xaxisMinValue="#{controlEstadisticas.chartDatacvTipo.xaxisMinValue}"
						xaxisMaxValue="#{controlEstadisticas.chartDatacvTipo.xaxisMaxValue}"
						numberOfYAxisTicks="#{controlEstadisticas.chartDatacvTipo.numberOfYAxisTicks}"
						yaxisMinValue="#{controlEstadisticas.chartDatacvTipo.yaxisMinValue}"
						markers="#{controlEstadisticas.chartDatacvTipo.markers}"
						markerPosition="#{controlEstadisticas.chartDatacvTipo.markerPosition}"
						yaxisMaxValue="#{controlEstadisticas.chartDatacvTipo.yaxisMaxValue}"
						crosshair="#{controlEstadisticas.chartDatacvTipo.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>
			<t:fieldset legend="#{ms.compli_proc_title }" >
				<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
			 		<t:dataTable value="#{controlEstadisticas.cvcomp}" var="proc" width="90%"
						binding="#{controlEstadisticas.bindingCvComp}" styleClass="hor-minimalist-b">
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
						 <jsflot:flotChart id="chartCvComp"
							value="#{controlEstadisticas.chartSeriesCvComp}" 
							actionListener="#{controlEstadisticas.chartActionListener}"
							testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							chartDraggable="true"
							chartClickable="true"
							chartZoomable="#{controlEstadisticas.chartDatacvComp.chartZoomable}"
							reRender="clickedPanel"
							showLines="false"
							fillLines="#{controlEstadisticas.chartDatacvComp.fillLines}"
							showDataPoints="#{controlEstadisticas.chartDatacvComp.showDataPoints}"
							legendColumns="#{controlEstadisticas.chartDatacvComp.legendColumns}"
							legendOpacity="#{controlEstadisticas.chartDatacvComp.legendOpacity}"
							legendPosition="#{controlEstadisticas.chartDatacvComp.legendPosition}"
							legendColor="#{controlEstadisticas.chartDatacvComp.legendColor}"
							height="#{controlEstadisticas.chartDatacvComp.height}"
							width="#{controlEstadisticas.chartDatacvComp.width}"
							showTooltip="#{controlEstadisticas.chartDatacvComp.showTooltip}"
							tooltipPosition="#{controlEstadisticas.chartDatacvComp.tooltipPosition}"
							tooltipFollowMouse="#{controlEstadisticas.chartDatacvComp.tooltipFollowMouse}"
							mode="#{controlEstadisticas.chartDatacvComp.mode}"
							timeFormat="#{controlEstadisticas.chartDatacvComp.timeFormat}"
							title="#{controlEstadisticas.chartDatacvComp.title}"
							subtitle="#{controlEstadisticas.chartDatacvComp.subtitle}"
							chartType="pie"
							showXaxisLabels="false"
							xaxisTitle="#{controlEstadisticas.chartDatacvComp.xaxisTitle}"
							xaxisTitleRotation="#{controlEstadisticas.chartDatacvComp.xaxisTitleRotation}"
							xaxisLabelRotation="#{controlEstadisticas.chartDatacvComp.xaxisLabelRotation}"
							showYaxisLabels="false"
							yaxisTitle="#{controlEstadisticas.chartDatacvComp.yaxisTitle}"
							yaxisTitleRotation="#{controlEstadisticas.chartDatacvComp.yaxisTitleRotation}"
							yaxisLabelRotation="#{controlEstadisticas.chartDatacvComp.yaxisLabelRotation}"
							numberOfXAxisTicks="#{controlEstadisticas.chartDatacvComp.numberOfXAxisTicks}"
							xaxisMinValue="#{controlEstadisticas.chartDatacvComp.xaxisMinValue}"
							xaxisMaxValue="#{controlEstadisticas.chartDatacvComp.xaxisMaxValue}"
							numberOfYAxisTicks="#{controlEstadisticas.chartDatacvComp.numberOfYAxisTicks}"
							yaxisMinValue="#{controlEstadisticas.chartDatacvComp.yaxisMinValue}"
							markers="#{controlEstadisticas.chartDatacvComp.markers}"
							markerPosition="#{controlEstadisticas.chartDatacvComp.markerPosition}"
							yaxisMaxValue="#{controlEstadisticas.chartDatacvComp.yaxisMaxValue}"
							crosshair="#{controlEstadisticas.chartDatacvComp.crosshair}">
						</jsflot:flotChart>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
			 		<t:dataTable value="#{controlEstadisticas.cvcomptipo}" var="proc" width="90%"
						binding="#{controlEstadisticas.bindingCvCompTipo}" styleClass="hor-minimalist-b">
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
						 <jsflot:flotChart id="chartCvCompTipo"
							value="#{controlEstadisticas.chartSeriesCvCompTipo}" 
							actionListener="#{controlEstadisticas.chartActionListener}"
							testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							chartDraggable="true"
							chartClickable="true"
							chartZoomable="#{controlEstadisticas.chartDatacvCompTipo.chartZoomable}"
							reRender="clickedPanel"
							showLines="false"
							fillLines="#{controlEstadisticas.chartDatacvCompTipo.fillLines}"
							showDataPoints="#{controlEstadisticas.chartDatacvCompTipo.showDataPoints}"
							legendColumns="#{controlEstadisticas.chartDatacvCompTipo.legendColumns}"
							legendOpacity="#{controlEstadisticas.chartDatacvCompTipo.legendOpacity}"
							legendPosition="#{controlEstadisticas.chartDatacvCompTipo.legendPosition}"
							legendColor="#{controlEstadisticas.chartDatacvCompTipo.legendColor}"
							height="#{controlEstadisticas.chartDatacvCompTipo.height}"
							width="#{controlEstadisticas.chartDatacvCompTipo.width}"
							showTooltip="#{controlEstadisticas.chartDatacvCompTipo.showTooltip}"
							tooltipPosition="#{controlEstadisticas.chartDatacvCompTipo.tooltipPosition}"
							tooltipFollowMouse="#{controlEstadisticas.chartDatacvCompTipo.tooltipFollowMouse}"
							mode="#{controlEstadisticas.chartDatacvCompTipo.mode}"
							timeFormat="#{controlEstadisticas.chartDatacvCompTipo.timeFormat}"
							title="#{controlEstadisticas.chartDatacvCompTipo.title}"
							subtitle="#{controlEstadisticas.chartDatacvCompTipo.subtitle}"
							chartType="pie"
							showXaxisLabels="false"
							xaxisTitle="#{controlEstadisticas.chartDatacvCompTipo.xaxisTitle}"
							xaxisTitleRotation="#{controlEstadisticas.chartDatacvCompTipo.xaxisTitleRotation}"
							xaxisLabelRotation="#{controlEstadisticas.chartDatacvCompTipo.xaxisLabelRotation}"
							showYaxisLabels="false"
							yaxisTitle="#{controlEstadisticas.chartDatacvCompTipo.yaxisTitle}"
							yaxisTitleRotation="#{controlEstadisticas.chartDatacvCompTipo.yaxisTitleRotation}"
							yaxisLabelRotation="#{controlEstadisticas.chartDatacvCompTipo.yaxisLabelRotation}"
							numberOfXAxisTicks="#{controlEstadisticas.chartDatacvCompTipo.numberOfXAxisTicks}"
							xaxisMinValue="#{controlEstadisticas.chartDatacvCompTipo.xaxisMinValue}"
							xaxisMaxValue="#{controlEstadisticas.chartDatacvCompTipo.xaxisMaxValue}"
							numberOfYAxisTicks="#{controlEstadisticas.chartDatacvCompTipo.numberOfYAxisTicks}"
							yaxisMinValue="#{controlEstadisticas.chartDatacvCompTipo.yaxisMinValue}"
							markers="#{controlEstadisticas.chartDatacvCompTipo.markers}"
							markerPosition="#{controlEstadisticas.chartDatacvCompTipo.markerPosition}"
							yaxisMaxValue="#{controlEstadisticas.chartDatacvCompTipo.yaxisMaxValue}"
							crosshair="#{controlEstadisticas.chartDatacvCompTipo.crosshair}">
						</jsflot:flotChart>
					</h:panelGrid>
				</h:panelGrid>
			</t:fieldset>
		</h:panelGrid>
		
	</h:panelGrid>
	<rich:modalPanel id="graficasEstadisticasCv" autosized="true" zindex="2000" minWidth="550" 
		onshow="JSFlot.AJAX.Submit('estadisticasbasicas', 'refresh', document.location, new JSFlot.Options(null, null, null, 
		'estadisticasbasicas_estCvTab_chartCv'));">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="Cardioversión eléctrica"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid>
				<a4j:commandLink
					onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasCv');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasCv')"
						title="Cancelar" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
			<jsflot:flotChart id="chartCv"
			        value="#{controlEstadisticas.chartSeries}"
			        actionListener="#{controlEstadisticas.chartActionListener}"
			        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
			        chartDraggable="true"
			        chartClickable="true"
			        chartZoomable="#{controlEstadisticas.chartDataCv.chartZoomable}"
			        reRender="clickedPanel"
			        showLines="false"
			        fillLines="#{controlEstadisticas.chartDataCv.fillLines}"
			        showDataPoints="#{controlEstadisticas.chartDataCv.showDataPoints}"
			        legendColumns="#{controlEstadisticas.chartDataCv.legendColumns}"
			        legendOpacity="#{controlEstadisticas.chartDataCv.legendOpacity}"
			        legendPosition="#{controlEstadisticas.chartDataCv.legendPosition}"
			        legendColor="#{controlEstadisticas.chartDataCv.legendColor}"
			        height="250"
			        width="#{controlEstadisticas.chartDataCv.width}"
			        showTooltip="#{controlEstadisticas.chartDataCv.showTooltip}"
			        tooltipPosition="#{controlEstadisticas.chartDataCv.tooltipPosition}"
			        tooltipFollowMouse="#{controlEstadisticas.chartDataCv.tooltipFollowMouse}"
			        mode="#{controlEstadisticas.chartDataCv.mode}"
			        timeFormat="#{controlEstadisticas.chartDataCv.timeFormat}"
			        title="#{controlEstadisticas.chartDataCv.title}"
			        subtitle="#{controlEstadisticas.chartDataCv.subtitle}"
			        chartType="pie"
			        showXaxisLabels="false"
			        xaxisTitle="#{controlEstadisticas.chartDataCv.xaxisTitle}"
			        xaxisTitleRotation="#{controlEstadisticas.chartDataCv.xaxisTitleRotation}"
			        xaxisLabelRotation="#{controlEstadisticas.chartDataCv.xaxisLabelRotation}"
			        showYaxisLabels="false"
			        yaxisTitle="#{controlEstadisticas.chartDataCv.yaxisTitle}"
			        yaxisTitleRotation="#{controlEstadisticas.chartDataCv.yaxisTitleRotation}"
			        yaxisLabelRotation="#{controlEstadisticas.chartDataCv.yaxisLabelRotation}"
			        numberOfXAxisTicks="#{controlEstadisticas.chartDataCv.numberOfXAxisTicks}"
			        xaxisMinValue="#{controlEstadisticas.chartDataCv.xaxisMinValue}"
			        xaxisMaxValue="#{controlEstadisticas.chartDataCv.xaxisMaxValue}"
			        numberOfYAxisTicks="#{controlEstadisticas.chartDataCv.numberOfYAxisTicks}"
			        yaxisMinValue="#{controlEstadisticas.chartDataCv.yaxisMinValue}"
			        markers="#{controlEstadisticas.chartDataCv.markers}"
			        markerPosition="#{controlEstadisticas.chartDataCv.markerPosition}"
			        yaxisMaxValue="#{controlEstadisticas.chartDataCv.yaxisMaxValue}"
			        crosshair="#{controlEstadisticas.chartDataCv.crosshair}">
			    </jsflot:flotChart>
	</rich:modalPanel>
	
</ui:composition>
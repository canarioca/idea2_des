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
						value="#{controlEstadisticas.fechaini_imp }">
					</rich:calendar>
					<h:outputLabel value="#{ms.est_basic_fecha_hasta }"/>
					<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
						showWeeksBar="false" direction="bottom-left"
						value="#{controlEstadisticas.fechafin_imp }">
					</rich:calendar>
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid>
			<a4j:commandLink style="text-align: right;" reRender="panResultadosEstadisticasImplantes"
				actionListener="#{controlEstadisticas.generarEstadisticasImplantes}"
				onclick="javascript:Richfaces.showModalPanel('buscando');"
				oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
				<h:graphicImage url="/img/iconos/ParameterReview.png" style="border:0px;"
					title="#{ms.est_basic_generar_title }" width="24" height="24"/>
			</a4j:commandLink>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="panResultadosEstadisticasImplantes" columns="2" width="90%">
		<h:panelGrid rendered="#{controlEstadisticas.est_imp eq true }" width="90%">
			<h:panelGrid width="100%" columnClasses="alignTop">
				<t:dataTable value="#{controlEstadisticas.impproc}" var="proc" width="50%"
					binding="#{controlEstadisticas.bindingImpProc}" styleClass="hor-minimalist-b">
			        <f:facet name="header">
			            <h:outputText value="#{ms.est_basic_tab_imp_implantes }"/>
			         </f:facet>	            
			          <t:column width="50%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_disp }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="alignTop">								
								<h:outputLabel value="#{proc.tipo }"/>
								<a4j:commandLink style="text-align: right;" 
									reRender="graficasEstadisticasImplantes" rendered="#{proc.tipo eq 'Total'}">
									<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
										title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>	
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_proc_primo }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="right" width="100%">								
								<h:outputLabel value="#{proc.numero }"/>
								<h:outputLabel value="(#{proc.porcentaje }%)"/>
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_proc_recam }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="right" width="100%">								
								<h:outputLabel value="#{proc.numero2 }"/>
								<h:outputLabel value="(#{proc.porcentaje2 }%)"/>
							</h:panelGrid>
						</t:column> 
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_proc_upgra }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="right" width="100%">								
								<h:outputLabel value="#{proc.numero3 }"/>
								<h:outputLabel value="(#{proc.porcentaje3 }%)"/>
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_proc_reimp }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="right" width="100%">								
								<h:outputLabel value="#{proc.numero4 }"/>
								<h:outputLabel value="(#{proc.porcentaje4 }%)"/>
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:graphicImage url="/img/iconos/sumImpl.png" style="border:0px;"
									title="#{ms.est_basic_total }" width="51" height="24"/>
							</f:facet>
							<h:panelGrid columnClasses="center" width="100%">								
								<h:outputLabel value="#{proc.suma1} "/>
							</h:panelGrid>
						</t:column>
						<t:column width="40%" headerstyleClass="left" rendered="false">
							<f:facet name="header">								
								<a4j:commandLink style="text-align: right;" 
									reRender="graficasEstadisticasImplantes">
									<h:outputText value="#{ms.est_basic_total }" />
									<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
										title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
								</a4j:commandLink>
							</f:facet>
							<h:panelGrid columns="2" columnClasses="alignTop">								
								<h:outputLabel value="#{proc.numero5 }"/>								
							</h:panelGrid>
						</t:column>         
			     </t:dataTable>
			     <h:panelGrid columns="2">
			     	<h:panelGrid>
				     	<jsflot:flotChart id="chartImpDisp"
							value="#{controlEstadisticas.chartSeriesImpDisp}"
							actionListener="#{controlEstadisticas.chartActionListener}"
							testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						    chartDraggable="true"
						    chartClickable="true"
						    chartZoomable="#{controlEstadisticas.chartDataImpDisp.chartZoomable}"
						    reRender="clickedPanel"
						    showLines="false"
						    fillLines="#{controlEstadisticas.chartDataImpDisp.fillLines}"
						    showDataPoints="#{controlEstadisticas.chartDataImpDisp.showDataPoints}"
						    legendColumns="#{controlEstadisticas.chartDataImpDisp.legendColumns}"
						    legendOpacity="#{controlEstadisticas.chartDataImpDisp.legendOpacity}"
						    legendPosition="#{controlEstadisticas.chartDataImpDisp.legendPosition}"
						    legendColor="#{controlEstadisticas.chartDataImpDisp.legendColor}"
						    height="#{controlEstadisticas.chartDataImpDisp.height}"
						    width="#{controlEstadisticas.chartDataImpDisp.width}"
						    showTooltip="#{controlEstadisticas.chartDataImpDisp.showTooltip}"
						    tooltipPosition="#{controlEstadisticas.chartDataImpDisp.tooltipPosition}"
						    tooltipFollowMouse="#{controlEstadisticas.chartDataImpDisp.tooltipFollowMouse}"
						    mode="#{controlEstadisticas.chartDataImpDisp.mode}"
						    timeFormat="#{controlEstadisticas.chartDataImpDisp.timeFormat}"
						    title="#{controlEstadisticas.chartDataImpDisp.title}"
						    subtitle="#{controlEstadisticas.chartDataImpDisp.subtitle}"
						    chartType="pie"
						    showXaxisLabels="false"
						    xaxisTitle="#{controlEstadisticas.chartDataImpDisp.xaxisTitle}"
						    xaxisTitleRotation="#{controlEstadisticas.chartDataImpDisp.xaxisTitleRotation}"
						    xaxisLabelRotation="#{controlEstadisticas.chartDataImpDisp.xaxisLabelRotation}"
						    showYaxisLabels="false"
						    yaxisTitle="#{controlEstadisticas.chartDataImpDisp.yaxisTitle}"
						    yaxisTitleRotation="#{controlEstadisticas.chartDataImpDisp.yaxisTitleRotation}"
						    yaxisLabelRotation="#{controlEstadisticas.chartDataImpDisp.yaxisLabelRotation}"
						    numberOfXAxisTicks="#{controlEstadisticas.chartDataImpDisp.numberOfXAxisTicks}"
						    xaxisMinValue="#{controlEstadisticas.chartDataImpDisp.xaxisMinValue}"
						    xaxisMaxValue="#{controlEstadisticas.chartDataImpDisp.xaxisMaxValue}"
						    numberOfYAxisTicks="#{controlEstadisticas.chartDataImpDisp.numberOfYAxisTicks}"
						    yaxisMinValue="#{controlEstadisticas.chartDataImpDisp.yaxisMinValue}"
						    markers="#{controlEstadisticas.chartDataImpDisp.markers}"
						    markerPosition="#{controlEstadisticas.chartDataImpDisp.markerPosition}"
						    yaxisMaxValue="#{controlEstadisticas.chartDataImpDisp.yaxisMaxValue}"
						    crosshair="#{controlEstadisticas.chartDataImpDisp.crosshair}">
						</jsflot:flotChart>
			     	</h:panelGrid>
			     	<h:panelGrid>
				     	<jsflot:flotChart id="chartImpProc"
							value="#{controlEstadisticas.chartSeriesImpProc}"
							actionListener="#{controlEstadisticas.chartActionListener}"
							testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							chartDraggable="true"
							chartClickable="true"
							chartZoomable="#{controlEstadisticas.chartDataImpProc.chartZoomable}"
							reRender="clickedPanel"
							showLines="false"
							fillLines="#{controlEstadisticas.chartDataImpProc.fillLines}"
							showDataPoints="#{controlEstadisticas.chartDataImpProc.showDataPoints}"
							legendColumns="#{controlEstadisticas.chartDataImpProc.legendColumns}"
							legendOpacity="#{controlEstadisticas.chartDataImpProc.legendOpacity}"
							legendPosition="#{controlEstadisticas.chartDataImpProc.legendPosition}"
							legendColor="#{controlEstadisticas.chartDataImpProc.legendColor}"
							height="#{controlEstadisticas.chartDataImpProc.height}"
							width="#{controlEstadisticas.chartDataImpProc.width}"
							showTooltip="#{controlEstadisticas.chartDataImpProc.showTooltip}"
							tooltipPosition="#{controlEstadisticas.chartDataImpProc.tooltipPosition}"
							tooltipFollowMouse="#{controlEstadisticas.chartDataImpProc.tooltipFollowMouse}"
							mode="#{controlEstadisticas.chartDataImpProc.mode}"
							timeFormat="#{controlEstadisticas.chartDataImpProc.timeFormat}"
							title="#{controlEstadisticas.chartDataImpProc.title}"
							subtitle="#{controlEstadisticas.chartDataImpProc.subtitle}"
							chartType="pie"
							showXaxisLabels="false"
							xaxisTitle="#{controlEstadisticas.chartDataImpProc.xaxisTitle}"
							xaxisTitleRotation="#{controlEstadisticas.chartDataImpProc.xaxisTitleRotation}"
							xaxisLabelRotation="#{controlEstadisticas.chartDataImpProc.xaxisLabelRotation}"
							showYaxisLabels="false"
							yaxisTitle="#{controlEstadisticas.chartDataImpProc.yaxisTitle}"
							yaxisTitleRotation="#{controlEstadisticas.chartDataImpProc.yaxisTitleRotation}"
							yaxisLabelRotation="#{controlEstadisticas.chartDataImpProc.yaxisLabelRotation}"
							numberOfXAxisTicks="#{controlEstadisticas.chartDataImpProc.numberOfXAxisTicks}"
							xaxisMinValue="#{controlEstadisticas.chartDataImpProc.xaxisMinValue}"
							xaxisMaxValue="#{controlEstadisticas.chartDataImpProc.xaxisMaxValue}"
							numberOfYAxisTicks="#{controlEstadisticas.chartDataImpProc.numberOfYAxisTicks}"
							yaxisMinValue="#{controlEstadisticas.chartDataImpProc.yaxisMinValue}"
							markers="#{controlEstadisticas.chartDataImpProc.markers}"
							markerPosition="#{controlEstadisticas.chartDataImpProc.markerPosition}"
							yaxisMaxValue="#{controlEstadisticas.chartDataImpProc.yaxisMaxValue}"
							crosshair="#{controlEstadisticas.chartDataImpProc.crosshair}">
						</jsflot:flotChart>
			     	</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid width="100%" columnClasses="alignTop">
				<t:dataTable value="#{controlEstadisticas.impreintproc}" var="proc" width="50%"
					binding="#{controlEstadisticas.bindingImpReintProc}" styleClass="hor-minimalist-b">
			        <f:facet name="header">
			            <h:outputText value="#{ms.est_basic_tab_imp_implantes_otros }"/>
			         </f:facet>	            
			          <t:column width="50%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_disp }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="alignTop">								
								<h:outputLabel value="#{proc.tipo }"/>
								<a4j:commandLink style="text-align: right;" 
									reRender="graficasEstadisticasImplantes" rendered="#{proc.tipo eq 'Total'}">
									<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
										title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>	
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_proc_reint }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="right" width="100%">								
								<h:outputLabel value="#{proc.numero }"/>
								<h:outputLabel value="(#{proc.porcentaje }%)"/>
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_proc_recol_gen }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="right" width="100%">								
								<h:outputLabel value="#{proc.numero2 }"/>
								<h:outputLabel value="(#{proc.porcentaje2 }%)"/>
							</h:panelGrid>
						</t:column> 
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_proc_recol_ele }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="right" width="100%">								
								<h:outputLabel value="#{proc.numero3 }"/>
								<h:outputLabel value="(#{proc.porcentaje3 }%)"/>
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.est_basic_tab_imp_proc_expl }" />
							</f:facet>
							<h:panelGrid columns="2" columnClasses="right" width="100%">								
								<h:outputLabel value="#{proc.numero4 }"/>
								<h:outputLabel value="(#{proc.porcentaje4 }%)"/>
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:graphicImage url="/img/iconos/sumReint.png" style="border:0px;"
									title="#{ms.est_basic_total }" width="51" height="24"/>
							</f:facet>
							<h:panelGrid columnClasses="center" width="100%">								
								<h:outputLabel value="#{proc.suma1} "/>
							</h:panelGrid>
						</t:column>
						<t:column width="40%" headerstyleClass="left" rendered="false">
							<f:facet name="header">								
								<a4j:commandLink style="text-align: right;" 
									reRender="graficasEstadisticasImplantes">
									<h:outputText value="#{ms.est_basic_total }" />
									<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
									title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
								</a4j:commandLink>
							</f:facet>
							<h:panelGrid columns="2" columnClasses="alignTop">								
								<h:outputLabel value="#{proc.numero5 }"/>								
							</h:panelGrid>
						</t:column>         
			     </t:dataTable>
			     <h:panelGrid columns="2">
			     	<h:panelGrid>
				     	<jsflot:flotChart id="chartImpReintDisp"
							value="#{controlEstadisticas.chartSeriesImpReintDisp}"
							actionListener="#{controlEstadisticas.chartActionListener}"
							testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						    chartDraggable="true"
						    chartClickable="true"
						    chartZoomable="#{controlEstadisticas.chartDataImpReintDisp.chartZoomable}"
						    reRender="clickedPanel"
						    showLines="false"
						    fillLines="#{controlEstadisticas.chartDataImpReintDisp.fillLines}"
						    showDataPoints="#{controlEstadisticas.chartDataImpReintDisp.showDataPoints}"
						    legendColumns="#{controlEstadisticas.chartDataImpReintDisp.legendColumns}"
						    legendOpacity="#{controlEstadisticas.chartDataImpReintDisp.legendOpacity}"
						    legendPosition="#{controlEstadisticas.chartDataImpReintDisp.legendPosition}"
						    legendColor="#{controlEstadisticas.chartDataImpReintDisp.legendColor}"
						    height="#{controlEstadisticas.chartDataImpReintDisp.height}"
						    width="#{controlEstadisticas.chartDataImpReintDisp.width}"
						    showTooltip="#{controlEstadisticas.chartDataImpReintDisp.showTooltip}"
						    tooltipPosition="#{controlEstadisticas.chartDataImpReintDisp.tooltipPosition}"
						    tooltipFollowMouse="#{controlEstadisticas.chartDataImpReintDisp.tooltipFollowMouse}"
						    mode="#{controlEstadisticas.chartDataImpReintDisp.mode}"
						    timeFormat="#{controlEstadisticas.chartDataImpReintDisp.timeFormat}"
						    title="#{controlEstadisticas.chartDataImpReintDisp.title}"
						    subtitle="#{controlEstadisticas.chartDataImpReintDisp.subtitle}"
						    chartType="pie"
						    showXaxisLabels="false"
						    xaxisTitle="#{controlEstadisticas.chartDataImpReintDisp.xaxisTitle}"
						    xaxisTitleRotation="#{controlEstadisticas.chartDataImpReintDisp.xaxisTitleRotation}"
						    xaxisLabelRotation="#{controlEstadisticas.chartDataImpReintDisp.xaxisLabelRotation}"
						    showYaxisLabels="false"
						    yaxisTitle="#{controlEstadisticas.chartDataImpReintDisp.yaxisTitle}"
						    yaxisTitleRotation="#{controlEstadisticas.chartDataImpReintDisp.yaxisTitleRotation}"
						    yaxisLabelRotation="#{controlEstadisticas.chartDataImpReintDisp.yaxisLabelRotation}"
						    numberOfXAxisTicks="#{controlEstadisticas.chartDataImpReintDisp.numberOfXAxisTicks}"
						    xaxisMinValue="#{controlEstadisticas.chartDataImpReintDisp.xaxisMinValue}"
						    xaxisMaxValue="#{controlEstadisticas.chartDataImpReintDisp.xaxisMaxValue}"
						    numberOfYAxisTicks="#{controlEstadisticas.chartDataImpReintDisp.numberOfYAxisTicks}"
						    yaxisMinValue="#{controlEstadisticas.chartDataImpReintDisp.yaxisMinValue}"
						    markers="#{controlEstadisticas.chartDataImpReintDisp.markers}"
						    markerPosition="#{controlEstadisticas.chartDataImpReintDisp.markerPosition}"
						    yaxisMaxValue="#{controlEstadisticas.chartDataImpReintDisp.yaxisMaxValue}"
						    crosshair="#{controlEstadisticas.chartDataImpReintDisp.crosshair}">
						</jsflot:flotChart>
			     	</h:panelGrid>
			     	<h:panelGrid>
				     	<jsflot:flotChart id="chartImpReintProc"
							value="#{controlEstadisticas.chartSeriesImpReintProc}"
							actionListener="#{controlEstadisticas.chartActionListener}"
							testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
							chartDraggable="true"
							chartClickable="true"
							chartZoomable="#{controlEstadisticas.chartDataImpReintProc.chartZoomable}"
							reRender="clickedPanel"
							showLines="false"
							fillLines="#{controlEstadisticas.chartDataImpReintProc.fillLines}"
							showDataPoints="#{controlEstadisticas.chartDataImpReintProc.showDataPoints}"
							legendColumns="#{controlEstadisticas.chartDataImpReintProc.legendColumns}"
							legendOpacity="#{controlEstadisticas.chartDataImpReintProc.legendOpacity}"
							legendPosition="#{controlEstadisticas.chartDataImpReintProc.legendPosition}"
							legendColor="#{controlEstadisticas.chartDataImpReintProc.legendColor}"
							height="#{controlEstadisticas.chartDataImpReintProc.height}"
							width="#{controlEstadisticas.chartDataImpReintProc.width}"
							showTooltip="#{controlEstadisticas.chartDataImpReintProc.showTooltip}"
							tooltipPosition="#{controlEstadisticas.chartDataImpReintProc.tooltipPosition}"
							tooltipFollowMouse="#{controlEstadisticas.chartDataImpReintProc.tooltipFollowMouse}"
							mode="#{controlEstadisticas.chartDataImpReintProc.mode}"
							timeFormat="#{controlEstadisticas.chartDataImpReintProc.timeFormat}"
							title="#{controlEstadisticas.chartDataImpReintProc.title}"
							subtitle="#{controlEstadisticas.chartDataImpReintProc.subtitle}"
							chartType="pie"
							showXaxisLabels="false"
							xaxisTitle="#{controlEstadisticas.chartDataImpReintProc.xaxisTitle}"
							xaxisTitleRotation="#{controlEstadisticas.chartDataImpReintProc.xaxisTitleRotation}"
							xaxisLabelRotation="#{controlEstadisticas.chartDataImpReintProc.xaxisLabelRotation}"
							showYaxisLabels="false"
							yaxisTitle="#{controlEstadisticas.chartDataImpReintProc.yaxisTitle}"
							yaxisTitleRotation="#{controlEstadisticas.chartDataImpReintProc.yaxisTitleRotation}"
							yaxisLabelRotation="#{controlEstadisticas.chartDataImpReintProc.yaxisLabelRotation}"
							numberOfXAxisTicks="#{controlEstadisticas.chartDataImpReintProc.numberOfXAxisTicks}"
							xaxisMinValue="#{controlEstadisticas.chartDataImpReintProc.xaxisMinValue}"
							xaxisMaxValue="#{controlEstadisticas.chartDataImpReintProc.xaxisMaxValue}"
							numberOfYAxisTicks="#{controlEstadisticas.chartDataImpReintProc.numberOfYAxisTicks}"
							yaxisMinValue="#{controlEstadisticas.chartDataImpReintProc.yaxisMinValue}"
							markers="#{controlEstadisticas.chartDataImpReintProc.markers}"
							markerPosition="#{controlEstadisticas.chartDataImpReintProc.markerPosition}"
							yaxisMaxValue="#{controlEstadisticas.chartDataImpReintProc.yaxisMaxValue}"
							crosshair="#{controlEstadisticas.chartDataImpReintProc.crosshair}">
						</jsflot:flotChart>
			     	</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			
			<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
				<t:dataTable value="#{controlEstadisticas.gensegs}" var="proc" width="70%"
					binding="#{controlEstadisticas.bindingGenSegs}" styleClass="hor-minimalist-b">
		            <f:facet name="header">		                
		                <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasImplante">
							<h:outputText value="#{ms.est_basic_tab_imp_num_seg_total }: #{controlEstadisticas.resgen4 })"></h:outputText>		        
							<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
						</a4j:commandLink>
		            </f:facet>	            
		            <t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.est_basic_tab_imp_tipo_disp }" />
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
					<jsflot:flotChart id="chartSegDisp"
						value="#{controlEstadisticas.chartSeriesImpSegDisp}"
						actionListener="#{controlEstadisticas.chartActionListener}"
						testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
						chartDraggable="true"
						chartClickable="true"
						chartZoomable="#{controlEstadisticas.chartDataImpSegDisp.chartZoomable}"
						reRender="clickedPanel"
						showLines="false"
						fillLines="#{controlEstadisticas.chartDataImpSegDisp.fillLines}"
						showDataPoints="#{controlEstadisticas.chartDataImpSegDisp.showDataPoints}"
						legendColumns="#{controlEstadisticas.chartDataImpSegDisp.legendColumns}"
						legendOpacity="#{controlEstadisticas.chartDataImpSegDisp.legendOpacity}"
						legendPosition="#{controlEstadisticas.chartDataImpSegDisp.legendPosition}"
						legendColor="#{controlEstadisticas.chartDataImpSegDisp.legendColor}"
						height="#{controlEstadisticas.chartDataImpSegDisp.height}"
						width="#{controlEstadisticas.chartDataImpSegDisp.width}"
						showTooltip="#{controlEstadisticas.chartDataImpSegDisp.showTooltip}"
						tooltipPosition="#{controlEstadisticas.chartDataImpSegDisp.tooltipPosition}"
						tooltipFollowMouse="#{controlEstadisticas.chartDataImpSegDisp.tooltipFollowMouse}"
						mode="#{controlEstadisticas.chartDataImpSegDisp.mode}"
						timeFormat="#{controlEstadisticas.chartDataImpSegDisp.timeFormat}"
						title="#{controlEstadisticas.chartDataImpSegDisp.title}"
						subtitle="#{controlEstadisticas.chartDataImpSegDisp.subtitle}"
						chartType="pie"
						showXaxisLabels="false"
						xaxisTitle="#{controlEstadisticas.chartDataImpSegDisp.xaxisTitle}"
						xaxisTitleRotation="#{controlEstadisticas.chartDataImpSegDisp.xaxisTitleRotation}"
						xaxisLabelRotation="#{controlEstadisticas.chartDataImpSegDisp.xaxisLabelRotation}"
						showYaxisLabels="false"
						yaxisTitle="#{controlEstadisticas.chartDataImpSegDisp.yaxisTitle}"
						yaxisTitleRotation="#{controlEstadisticas.chartDataImpSegDisp.yaxisTitleRotation}"
						yaxisLabelRotation="#{controlEstadisticas.chartDataImpSegDisp.yaxisLabelRotation}"
						numberOfXAxisTicks="#{controlEstadisticas.chartDataImpSegDisp.numberOfXAxisTicks}"
						xaxisMinValue="#{controlEstadisticas.chartDataImpSegDisp.xaxisMinValue}"
						xaxisMaxValue="#{controlEstadisticas.chartDataImpSegDisp.xaxisMaxValue}"
						numberOfYAxisTicks="#{controlEstadisticas.chartDataImpSegDisp.numberOfYAxisTicks}"
						yaxisMinValue="#{controlEstadisticas.chartDataImpSegDisp.yaxisMinValue}"
						markers="#{controlEstadisticas.chartDataImpSegDisp.markers}"
						markerPosition="#{controlEstadisticas.chartDataImpSegDisp.markerPosition}"
						yaxisMaxValue="#{controlEstadisticas.chartDataImpSegDisp.yaxisMaxValue}"
						crosshair="#{controlEstadisticas.chartDataImpSegDisp.crosshair}">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid width="100%">
				<t:fieldset legend="#{ms.est_basic_tab_imp_baja_energia }" >
					<h:outputLabel value="#{ms.est_basic_tab_imp_info1 }" style="font-weight: bold;color:#E17009" />
					<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
						<t:dataTable value="#{controlEstadisticas.impbefab}" var="proc" width="50%"
							binding="#{controlEstadisticas.bindingImpBEFab}" styleClass="hor-minimalist-b">
					        <f:facet name="header">
					            <h:outputText value="#{ms.est_basic_tab_imp_fab_tipo }"/>
					         </f:facet>	            
					          <t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.est_basic_tab_imp_fabr }" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="alignTop">								
										<h:outputLabel value="#{proc.tipo }"/>
										<a4j:commandLink style="text-align: right;" 
											reRender="graficasEstadisticasImplante" rendered="#{proc.tipo eq 'Total'}">
											<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
											title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
										</a4j:commandLink>
									</h:panelGrid>
								</t:column>	
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="SSI" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero }"/>
										<h:outputLabel value="(#{proc.porcentaje }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="SSIR" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero2 }"/>
										<h:outputLabel value="(#{proc.porcentaje2 }%)"/>
									</h:panelGrid>
								</t:column> 
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="VDD" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero3 }"/>
										<h:outputLabel value="(#{proc.porcentaje3 }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="VDDR" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero4 }"/>
										<h:outputLabel value="(#{proc.porcentaje4 }%)"/>
									</h:panelGrid>
								</t:column>  
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="DDD" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero5 }"/>
										<h:outputLabel value="(#{proc.porcentaje5 }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="DDDR" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero6 }"/>
										<h:outputLabel value="(#{proc.porcentaje6 }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="CRTP" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero7 }"/>
										<h:outputLabel value="(#{proc.porcentaje7 }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="40%" headerstyleClass="left">
									<f:facet name="header">								
										<h:graphicImage url="/img/iconos/sumImpl.png" style="border:0px;"
											title="#{ms.est_basic_total }" width="51" height="24"/>
									</f:facet>
									<h:panelGrid columnClasses="center" width="100%">								
										<h:outputLabel value="#{proc.numero8 }"/>								
									</h:panelGrid>
								</t:column>         
					     </t:dataTable>
					     <h:panelGrid>
							<jsflot:flotChart id="chartImpBeTipoFab"
								value="#{controlEstadisticas.chartSeriesImpBeTipoFab}"
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataImpBeTipoFab.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataImpBeTipoFab.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataImpBeTipoFab.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataImpBeTipoFab.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataImpBeTipoFab.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataImpBeTipoFab.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataImpBeTipoFab.legendColor}"
								height="#{controlEstadisticas.chartDataImpBeTipoFab.height}"
								width="#{controlEstadisticas.chartDataImpBeTipoFab.width}"
								showTooltip="#{controlEstadisticas.chartDataImpBeTipoFab.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataImpBeTipoFab.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataImpBeTipoFab.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataImpBeTipoFab.mode}"
								timeFormat="#{controlEstadisticas.chartDataImpBeTipoFab.timeFormat}"
								title="#{controlEstadisticas.chartDataImpBeTipoFab.title}"
								subtitle="#{controlEstadisticas.chartDataImpBeTipoFab.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataImpBeTipoFab.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataImpBeTipoFab.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataImpBeTipoFab.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataImpBeTipoFab.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataImpBeTipoFab.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataImpBeTipoFab.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataImpBeTipoFab.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataImpBeTipoFab.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataImpBeTipoFab.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataImpBeTipoFab.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataImpBeTipoFab.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataImpBeTipoFab.markers}"
								markerPosition="#{controlEstadisticas.chartDataImpBeTipoFab.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataImpBeTipoFab.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataImpBeTipoFab.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
						<t:dataTable value="#{controlEstadisticas.impbetipo}" var="proc" width="75%"
							binding="#{controlEstadisticas.bindingImpBETipo}" styleClass="hor-minimalist-b">
					        <f:facet name="header">
					            <h:outputText value="#{ms.est_basic_tab_imp_tipo_fab }"/>
					         </f:facet>	            
					          <t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.est_basic_tab_imp_tipo }" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="alignTop">								
										<h:outputLabel value="#{proc.tipo }"/>
										<a4j:commandLink style="text-align: right;" 
											reRender="graficasEstadisticasImplante" rendered="#{proc.tipo eq 'Total'}">
											<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
												title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
										</a4j:commandLink>
									</h:panelGrid>
								</t:column>	
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Sorin Group" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero }"/>
										<h:outputLabel value="(#{proc.porcentaje }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Medtronic" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero2 }"/>
										<h:outputLabel value="(#{proc.porcentaje2 }%)"/>
									</h:panelGrid>
								</t:column> 
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Boston Scientific" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero3 }"/>
										<h:outputLabel value="(#{proc.porcentaje3 }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Saint Jude Medical" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero4 }"/>
										<h:outputLabel value="(#{proc.porcentaje4 }%)"/>
									</h:panelGrid>
								</t:column>  
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Biotronik" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero5 }"/>
										<h:outputLabel value="(#{proc.porcentaje5 }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Vitatron" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero6 }"/>
										<h:outputLabel value="(#{proc.porcentaje6 }%)"/>
									</h:panelGrid>
								</t:column>								
								<t:column width="40%" headerstyleClass="left">
									<f:facet name="header">		
										<h:graphicImage url="/img/iconos/sumImpl.png" style="border:0px;"
											title="#{ms.est_basic_total }" width="51" height="24"/>
									</f:facet>
									<h:panelGrid columnClasses="center" width="100%">								
										<h:outputLabel value="#{proc.numero7 }"/>								
									</h:panelGrid>
								</t:column>         
					     </t:dataTable>
					     <h:panelGrid>
							<jsflot:flotChart id="chartImpBeFabTipo"
								value="#{controlEstadisticas.chartSeriesImpBeFabTipo}"
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataImpBeFabTipo.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataImpBeFabTipo.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataImpBeFabTipo.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataImpBeFabTipo.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataImpBeFabTipo.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataImpBeFabTipo.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataImpBeFabTipo.legendColor}"
								height="#{controlEstadisticas.chartDataImpBeFabTipo.height}"
								width="#{controlEstadisticas.chartDataImpBeFabTipo.width}"
								showTooltip="#{controlEstadisticas.chartDataImpBeFabTipo.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataImpBeFabTipo.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataImpBeFabTipo.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataImpBeFabTipo.mode}"
								timeFormat="#{controlEstadisticas.chartDataImpBeFabTipo.timeFormat}"
								title="#{controlEstadisticas.chartDataImpBeFabTipo.title}"
								subtitle="#{controlEstadisticas.chartDataImpBeFabTipo.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataImpBeFabTipo.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataImpBeFabTipo.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataImpBeFabTipo.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataImpBeFabTipo.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataImpBeFabTipo.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataImpBeFabTipo.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataImpBeFabTipo.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataImpBeFabTipo.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataImpBeFabTipo.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataImpBeFabTipo.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataImpBeFabTipo.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataImpBeFabTipo.markers}"
								markerPosition="#{controlEstadisticas.chartDataImpBeFabTipo.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataImpBeFabTipo.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataImpBeFabTipo.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
				</t:fieldset>
			</h:panelGrid>
			<h:panelGrid width="100%">
				<t:fieldset legend="#{ms.est_basic_tab_imp_alta_energia }" >
					<h:outputLabel value="#{ms.est_basic_tab_imp_info1 }" style="font-weight: bold;color:#E17009" />
					<h:panelGrid width="100" columns="2" columnClasses="alignTop,alignRight">
						<t:dataTable value="#{controlEstadisticas.impaefab}" var="proc" width="80%"
							binding="#{controlEstadisticas.bindingImpAEFab}" styleClass="hor-minimalist-b">
					        <f:facet name="header">
					            <h:outputText value="#{ms.est_basic_tab_imp_fab_tipo }"/>
					         </f:facet>	            
					          <t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.est_basic_tab_imp_fabr }" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="alignTop">								
										<h:outputLabel value="#{proc.tipo }"/>
										<a4j:commandLink style="text-align: right;" 
											reRender="graficasEstadisticasImplante" rendered="#{proc.tipo eq 'Total'}">
											<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
												title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
										</a4j:commandLink>
									</h:panelGrid>
								</t:column>	
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="VR" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero }"/>
										<h:outputLabel value="(#{proc.porcentaje }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="DR" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero2 }"/>
										<h:outputLabel value="(#{proc.porcentaje2 }%)"/>
									</h:panelGrid>
								</t:column> 
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="CRTD" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero3 }"/>
										<h:outputLabel value="(#{proc.porcentaje3 }%)"/>
									</h:panelGrid>
								</t:column>  
								<t:column width="40%" headerstyleClass="left">
									<f:facet name="header">								
										<h:graphicImage url="/img/iconos/sumImpl.png" style="border:0px;"
											title="#{ms.est_basic_total }" width="51" height="24"/>
									</f:facet>
									<h:panelGrid columnClasses="center" width="100%">								
										<h:outputLabel value="#{proc.numero4 }"/>								
									</h:panelGrid>
								</t:column>         
					     </t:dataTable>
					     <h:panelGrid>
							<jsflot:flotChart id="chartImpAeTipoFab"
								value="#{controlEstadisticas.chartSeriesImpAeTipoFab}"
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartImpAeTipoFab.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartImpAeTipoFab.fillLines}"
								showDataPoints="#{controlEstadisticas.chartImpAeTipoFab.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartImpAeTipoFab.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartImpAeTipoFab.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartImpAeTipoFab.legendPosition}"
								legendColor="#{controlEstadisticas.chartImpAeTipoFab.legendColor}"
								height="#{controlEstadisticas.chartImpAeTipoFab.height}"
								width="#{controlEstadisticas.chartImpAeTipoFab.width}"
								showTooltip="#{controlEstadisticas.chartImpAeTipoFab.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartImpAeTipoFab.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartImpAeTipoFab.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartImpAeTipoFab.mode}"
								timeFormat="#{controlEstadisticas.chartImpAeTipoFab.timeFormat}"
								title="#{controlEstadisticas.chartImpAeTipoFab.title}"
								subtitle="#{controlEstadisticas.chartImpAeTipoFab.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartImpAeTipoFab.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartImpAeTipoFab.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartImpAeTipoFab.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartImpAeTipoFab.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartImpAeTipoFab.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartImpAeTipoFab.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartImpAeTipoFab.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartImpAeTipoFab.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartImpAeTipoFab.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartImpAeTipoFab.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartImpAeTipoFab.yaxisMinValue}"
								markers="#{controlEstadisticas.chartImpAeTipoFab.markers}"
								markerPosition="#{controlEstadisticas.chartImpAeTipoFab.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartImpAeTipoFab.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartImpAeTipoFab.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
						<t:dataTable value="#{controlEstadisticas.impaetipo}" var="proc" width="70%"
							binding="#{controlEstadisticas.bindingImpAETipo}" styleClass="hor-minimalist-b">
					        <f:facet name="header">
					            <h:outputText value="#{ms.est_basic_tab_imp_tipo_fab }"/>
					         </f:facet>	            
					          <t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.est_basic_tab_imp_tipo }" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="alignTop">								
										<h:outputLabel value="#{proc.tipo }"/>
										<a4j:commandLink style="text-align: right;" 
											reRender="graficasEstadisticasImplante" rendered="#{proc.tipo eq 'Total'}">
											<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
												title="#{ms.est_basic_grafica_title }" width="24" height="24"/>
										</a4j:commandLink>
									</h:panelGrid>
								</t:column>	
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Sorin Group" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero }"/>
										<h:outputLabel value="(#{proc.porcentaje }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Medtronic" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero2 }"/>
										<h:outputLabel value="(#{proc.porcentaje2 }%)"/>
									</h:panelGrid>
								</t:column> 
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Boston Scientific" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero3 }"/>
										<h:outputLabel value="(#{proc.porcentaje3 }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Saint Jude Medical" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero4 }"/>
										<h:outputLabel value="(#{proc.porcentaje4 }%)"/>
									</h:panelGrid>
								</t:column>  
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Biotronik" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero5 }"/>
										<h:outputLabel value="(#{proc.porcentaje5 }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="20%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="Vitatron" />
									</f:facet>
									<h:panelGrid columns="2" columnClasses="right" width="100%">								
										<h:outputLabel value="#{proc.numero6 }"/>
										<h:outputLabel value="(#{proc.porcentaje6 }%)"/>
									</h:panelGrid>
								</t:column>
								<t:column width="40%" headerstyleClass="left">
									<f:facet name="header">								
										<h:graphicImage url="/img/iconos/sumImpl.png" style="border:0px;"
											title="#{ms.est_basic_total }" width="51" height="24"/>
									</f:facet>
									<h:panelGrid columnClasses="center" width="100%">								
										<h:outputLabel value="#{proc.numero7 }"/>								
									</h:panelGrid>
								</t:column>         
					     </t:dataTable>
					     <h:panelGrid>
							<jsflot:flotChart id="chartImpAeFabTipo"
								value="#{controlEstadisticas.chartSeriesImpAeFabTipo}"
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataImpAeFabTipo.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataImpAeFabTipo.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataImpAeFabTipo.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataImpAeFabTipo.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataImpAeFabTipo.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataImpAeFabTipo.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataImpAeFabTipo.legendColor}"
								height="#{controlEstadisticas.chartDataImpAeFabTipo.height}"
								width="#{controlEstadisticas.chartDataImpAeFabTipo.width}"
								showTooltip="#{controlEstadisticas.chartDataImpAeFabTipo.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataImpAeFabTipo.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataImpAeFabTipo.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataImpAeFabTipo.mode}"
								timeFormat="#{controlEstadisticas.chartDataImpAeFabTipo.timeFormat}"
								title="#{controlEstadisticas.chartDataImpAeFabTipo.title}"
								subtitle="#{controlEstadisticas.chartDataImpAeFabTipo.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataImpAeFabTipo.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataImpAeFabTipo.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataImpAeFabTipo.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataImpAeFabTipo.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataImpAeFabTipo.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataImpAeFabTipo.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataImpAeFabTipo.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataImpAeFabTipo.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataImpAeFabTipo.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataImpAeFabTipo.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataImpAeFabTipo.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataImpAeFabTipo.markers}"
								markerPosition="#{controlEstadisticas.chartDataImpAeFabTipo.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataImpAeFabTipo.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataImpAeFabTipo.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
				</t:fieldset>
			</h:panelGrid>
			<h:panelGrid width="100%">
				<t:fieldset legend="#{ms.est_basic_tab_imp_ind_ecg }" >
					<h:outputLabel value="#{ms.est_basic_tab_imp_info2 }" style="font-weight: bold;color:#E17009" />
					<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
						<t:dataTable value="#{controlEstadisticas.impritmo}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingImpRitmo}" styleClass="hor-minimalist-b">
					        <f:facet name="header">
					            <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasImplante">
									<h:outputText value="#{ms.est_basic_tab_imp_ind_ecg_ritmo }"/>
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
							 <jsflot:flotChart id="chartImpRitmo"
								value="#{controlEstadisticas.chartSeriesImpRitmo}"
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataImpRitmo.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataImpRitmo.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataImpRitmo.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataImpRitmo.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataImpRitmo.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataImpRitmo.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataImpRitmo.legendColor}"
								height="#{controlEstadisticas.chartDataImpRitmo.height}"
								width="#{controlEstadisticas.chartDataImpRitmo.width}"
								showTooltip="#{controlEstadisticas.chartDataImpRitmo.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataImpRitmo.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataImpRitmo.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataImpRitmo.mode}"
								timeFormat="#{controlEstadisticas.chartDataImpRitmo.timeFormat}"
								title="#{controlEstadisticas.chartDataImpRitmo.title}"
								subtitle="#{controlEstadisticas.chartDataImpRitmo.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataImpRitmo.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataImpRitmo.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataImpRitmo.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataImpRitmo.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataImpRitmo.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataImpRitmo.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataImpRitmo.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataImpRitmo.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataImpRitmo.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataImpRitmo.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataImpRitmo.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataImpRitmo.markers}"
								markerPosition="#{controlEstadisticas.chartDataImpRitmo.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataImpRitmo.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataImpRitmo.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
						<t:dataTable value="#{controlEstadisticas.impcav}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingImpCav}" styleClass="hor-minimalist-b">
					        <f:facet name="header">
					            <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasImplante">
									<h:outputText value="#{ms.est_basic_tab_imp_ind_ecg_cav }"/>
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
							 <jsflot:flotChart id="chartImpCav"
								value="#{controlEstadisticas.chartSeriesImpCav}"
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataImpCav.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataImpCav.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataImpCav.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataImpCav.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataImpCav.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataImpCav.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataImpCav.legendColor}"
								height="#{controlEstadisticas.chartDataImpCav.height}"
								width="#{controlEstadisticas.chartDataImpCav.width}"
								showTooltip="#{controlEstadisticas.chartDataImpCav.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataImpCav.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataImpCav.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataImpCav.mode}"
								timeFormat="#{controlEstadisticas.chartDataImpCav.timeFormat}"
								title="#{controlEstadisticas.chartDataImpCav.title}"
								subtitle="#{controlEstadisticas.chartDataImpCav.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataImpCav.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataImpCav.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataImpCav.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataImpCav.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataImpCav.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataImpCav.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataImpCav.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataImpCav.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataImpCav.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataImpCav.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataImpCav.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataImpCav.markers}"
								markerPosition="#{controlEstadisticas.chartDataImpCav.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataImpCav.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataImpCav.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
						<t:dataTable value="#{controlEstadisticas.impqrs}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingImpQrs}" styleClass="hor-minimalist-b">
					        <f:facet name="header">
					            <a4j:commandLink style="text-align: right;" reRender="graficasEstadisticasImplante">
									<h:outputText value="#{ms.est_basic_tab_imp_ind_ecg_qrs }"/>
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
							 <jsflot:flotChart id="chartImpQrs"
								value="#{controlEstadisticas.chartSeriesImpQrs}"
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataImpQrs.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataImpQrs.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataImpQrs.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataImpQrs.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataImpQrs.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataImpQrs.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataImpQrs.legendColor}"
								height="#{controlEstadisticas.chartDataImpQrs.height}"
								width="#{controlEstadisticas.chartDataImpQrs.width}"
								showTooltip="#{controlEstadisticas.chartDataImpQrs.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataImpQrs.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataImpQrs.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataImpQrs.mode}"
								timeFormat="#{controlEstadisticas.chartDataImpQrs.timeFormat}"
								title="#{controlEstadisticas.chartDataImpQrs.title}"
								subtitle="#{controlEstadisticas.chartDataImpQrs.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataImpQrs.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataImpQrs.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataImpQrs.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataImpQrs.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataImpQrs.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataImpQrs.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataImpQrs.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataImpQrs.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataImpQrs.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataImpQrs.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataImpQrs.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataImpQrs.markers}"
								markerPosition="#{controlEstadisticas.chartDataImpQrs.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataImpQrs.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataImpQrs.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>	
					</h:panelGrid>
				</t:fieldset>
			</h:panelGrid>
			<h:panelGrid width="100%">
				<t:fieldset legend="#{ms.compli_proc_title }" >
					<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
				 		<t:dataTable value="#{controlEstadisticas.impcomp}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingImpComp}" styleClass="hor-minimalist-b">
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
							 <jsflot:flotChart id="chartImpComp"
								value="#{controlEstadisticas.chartSeriesImpComp}" 
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataImpComp.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataImpComp.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataImpComp.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataImpComp.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataImpComp.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataImpComp.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataImpComp.legendColor}"
								height="#{controlEstadisticas.chartDataImpComp.height}"
								width="#{controlEstadisticas.chartDataImpComp.width}"
								showTooltip="#{controlEstadisticas.chartDataImpComp.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataImpComp.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataImpComp.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataImpComp.mode}"
								timeFormat="#{controlEstadisticas.chartDataImpComp.timeFormat}"
								title="#{controlEstadisticas.chartDataImpComp.title}"
								subtitle="#{controlEstadisticas.chartDataImpComp.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataImpComp.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataImpComp.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataImpComp.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataImpComp.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataImpComp.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataImpComp.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataImpComp.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataImpComp.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataImpComp.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataImpComp.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataImpComp.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataImpComp.markers}"
								markerPosition="#{controlEstadisticas.chartDataImpComp.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataImpComp.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataImpComp.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignRight">
				 		<t:dataTable value="#{controlEstadisticas.impcomptipo}" var="proc" width="90%"
							binding="#{controlEstadisticas.bindingImpCompTipo}" styleClass="hor-minimalist-b">
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
							 <jsflot:flotChart id="chartImpCompTipo"
								value="#{controlEstadisticas.chartSeriesImpCompTipo}" 
								actionListener="#{controlEstadisticas.chartActionListener}"
								testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
								chartDraggable="true"
								chartClickable="true"
								chartZoomable="#{controlEstadisticas.chartDataImpCompTipo.chartZoomable}"
								reRender="clickedPanel"
								showLines="false"
								fillLines="#{controlEstadisticas.chartDataImpCompTipo.fillLines}"
								showDataPoints="#{controlEstadisticas.chartDataImpCompTipo.showDataPoints}"
								legendColumns="#{controlEstadisticas.chartDataImpCompTipo.legendColumns}"
								legendOpacity="#{controlEstadisticas.chartDataImpCompTipo.legendOpacity}"
								legendPosition="#{controlEstadisticas.chartDataImpCompTipo.legendPosition}"
								legendColor="#{controlEstadisticas.chartDataImpCompTipo.legendColor}"
								height="#{controlEstadisticas.chartDataImpCompTipo.height}"
								width="#{controlEstadisticas.chartDataImpCompTipo.width}"
								showTooltip="#{controlEstadisticas.chartDataImpCompTipo.showTooltip}"
								tooltipPosition="#{controlEstadisticas.chartDataImpCompTipo.tooltipPosition}"
								tooltipFollowMouse="#{controlEstadisticas.chartDataImpCompTipo.tooltipFollowMouse}"
								mode="#{controlEstadisticas.chartDataImpCompTipo.mode}"
								timeFormat="#{controlEstadisticas.chartDataImpCompTipo.timeFormat}"
								title="#{controlEstadisticas.chartDataImpCompTipo.title}"
								subtitle="#{controlEstadisticas.chartDataImpCompTipo.subtitle}"
								chartType="pie"
								showXaxisLabels="false"
								xaxisTitle="#{controlEstadisticas.chartDataImpCompTipo.xaxisTitle}"
								xaxisTitleRotation="#{controlEstadisticas.chartDataImpCompTipo.xaxisTitleRotation}"
								xaxisLabelRotation="#{controlEstadisticas.chartDataImpCompTipo.xaxisLabelRotation}"
								showYaxisLabels="false"
								yaxisTitle="#{controlEstadisticas.chartDataImpCompTipo.yaxisTitle}"
								yaxisTitleRotation="#{controlEstadisticas.chartDataImpCompTipo.yaxisTitleRotation}"
								yaxisLabelRotation="#{controlEstadisticas.chartDataImpCompTipo.yaxisLabelRotation}"
								numberOfXAxisTicks="#{controlEstadisticas.chartDataImpCompTipo.numberOfXAxisTicks}"
								xaxisMinValue="#{controlEstadisticas.chartDataImpCompTipo.xaxisMinValue}"
								xaxisMaxValue="#{controlEstadisticas.chartDataImpCompTipo.xaxisMaxValue}"
								numberOfYAxisTicks="#{controlEstadisticas.chartDataImpCompTipo.numberOfYAxisTicks}"
								yaxisMinValue="#{controlEstadisticas.chartDataImpCompTipo.yaxisMinValue}"
								markers="#{controlEstadisticas.chartDataImpCompTipo.markers}"
								markerPosition="#{controlEstadisticas.chartDataImpCompTipo.markerPosition}"
								yaxisMaxValue="#{controlEstadisticas.chartDataImpCompTipo.yaxisMaxValue}"
								crosshair="#{controlEstadisticas.chartDataImpCompTipo.crosshair}">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
				</t:fieldset>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<rich:modalPanel id="graficasEstadisticasImplante" autosized="true" zindex="2000" minWidth="550" 
		onshow="JSFlot.AJAX.Submit('estadisticasbasicas', 'refresh', document.location, new JSFlot.Options(null, null, null, 
		'estadisticasbasicas_estImpTab_chartImp'));">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="Dispositivos implantables"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="2">
				<a4j:commandLink onclick="PrintContent();" rendered="false">
					<h:graphicImage style="align:right;border:none;"
						title="Imprimir"
						width="20" height="20" url="/img/iconos/print.png" />
				</a4j:commandLink>
				<a4j:commandLink
					onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasImplante');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('graficasEstadisticasImplante')"
						title="Cancelar" />
				</a4j:commandLink>						
			</h:panelGrid>
		</f:facet>
			<jsflot:flotChart id="chartImp"
			        value="#{controlEstadisticas.chartSeries}"
			        actionListener="#{controlEstadisticas.chartActionListener}"
			        testChartDraggedAction="#{controlEstadisticas.chartDraggedListener}"
			        chartDraggable="true"
			        chartClickable="true"
			        chartZoomable="#{controlEstadisticas.chartDataImp.chartZoomable}"
			        reRender="clickedPanel"
			        showLines="false"
			        fillLines="#{controlEstadisticas.chartDataImp.fillLines}"
			        showDataPoints="#{controlEstadisticas.chartDataImp.showDataPoints}"
			        legendColumns="#{controlEstadisticas.chartDataImp.legendColumns}"
			        legendOpacity="#{controlEstadisticas.chartDataImp.legendOpacity}"
			        legendPosition="#{controlEstadisticas.chartDataImp.legendPosition}"
			        legendColor="#{controlEstadisticas.chartDataImp.legendColor}"
			        height="250"
			        width="#{controlEstadisticas.chartDataImp.width}"
			        showTooltip="#{controlEstadisticas.chartDataImp.showTooltip}"
			        tooltipPosition="#{controlEstadisticas.chartDataImp.tooltipPosition}"
			        tooltipFollowMouse="#{controlEstadisticas.chartDataImp.tooltipFollowMouse}"
			        mode="#{controlEstadisticas.chartDataImp.mode}"
			        timeFormat="#{controlEstadisticas.chartDataImp.timeFormat}"
			        title="#{controlEstadisticas.chartDataImp.title}"
			        subtitle="#{controlEstadisticas.chartDataImp.subtitle}"
			        chartType="pie"
			        showXaxisLabels="false"
			        xaxisTitle="#{controlEstadisticas.chartDataImp.xaxisTitle}"
			        xaxisTitleRotation="#{controlEstadisticas.chartDataImp.xaxisTitleRotation}"
			        xaxisLabelRotation="#{controlEstadisticas.chartDataImp.xaxisLabelRotation}"
			        showYaxisLabels="false"
			        yaxisTitle="#{controlEstadisticas.chartDataImp.yaxisTitle}"
			        yaxisTitleRotation="#{controlEstadisticas.chartDataImp.yaxisTitleRotation}"
			        yaxisLabelRotation="#{controlEstadisticas.chartDataImp.yaxisLabelRotation}"
			        numberOfXAxisTicks="#{controlEstadisticas.chartDataImp.numberOfXAxisTicks}"
			        xaxisMinValue="#{controlEstadisticas.chartDataImp.xaxisMinValue}"
			        xaxisMaxValue="#{controlEstadisticas.chartDataImp.xaxisMaxValue}"
			        numberOfYAxisTicks="#{controlEstadisticas.chartDataImp.numberOfYAxisTicks}"
			        yaxisMinValue="#{controlEstadisticas.chartDataImp.yaxisMinValue}"
			        markers="#{controlEstadisticas.chartDataImp.markers}"
			        markerPosition="#{controlEstadisticas.chartDataImp.markerPosition}"
			        yaxisMaxValue="#{controlEstadisticas.chartDataImp.yaxisMaxValue}"
			        crosshair="#{controlEstadisticas.chartDataImp.crosshair}">
			    </jsflot:flotChart>
			
	</rich:modalPanel>
	<script type="text/javascript">
		function PrintContent(){
			var DocumentContainer = document.getElementById('estadisticasbasicas_estImpTab_chartImp_chart');
			var WindowObject = window.open("", "PrintWindow",
			"width=750,height=650,top=50,left=50,toolbars=no,scrollbars=yes,status=no,resizable=yes");
			var canvas = DocumentContainer.innerHTML.toString();
			var aux = canvas.split('/canvas>');
			var canvas2 = aux[1] + '/canvas>';
			alert(canvas2);
			//var obj = ctx.toDataURL('image/png');
			WindowObject.document.writeln(DocumentContainer.innerHTML);
			//WindowObject.document.writeln('<img src='+obj+'/>');
			WindowObject.document.close();
			WindowObject.focus();
			WindowObject.print();
			WindowObject.close();
			}
	</script>
</ui:composition>
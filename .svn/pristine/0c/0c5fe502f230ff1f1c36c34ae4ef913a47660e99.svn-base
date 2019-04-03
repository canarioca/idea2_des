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
				style="margin-top: 15px;" id="panelEstadisticas">

				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="1" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0"  id="panelOpcionesEstadistica">
							<h:outputLabel value="Consulta estadistica" style="color: white;" />						
						</h:panelGrid>
					</f:facet>
					<h:panelGrid columns="3" columnClasses="alignTop,alignTop,alignTop">
						<h:outputLabel value="Tipo de consulta" style="font-weight: bold;" />			
						<h:panelGrid id="panSelEstadisticas">
							<h:selectOneMenu value="#{controlEstadisticas.tipoconsulta }">
								<f:selectItem itemLabel="Total procedimientos realizados" itemValue="1" />
								<f:selectItem itemLabel="Total implantes realizados" itemValue="2" />
							</h:selectOneMenu>
						</h:panelGrid>
						<h:panelGrid>
							<a4j:commandLink style="text-align: right;" reRender="panResultadosEstadisticas"
								actionListener="#{controlEstadisticas.generaEstadistica}">
								<h:graphicImage url="/img/iconos/icono_estadisticas.png" style="border:0px;"
								title="Generar estadistica" width="24" height="24"/>
							</a4j:commandLink>
						</h:panelGrid>
					</h:panelGrid>
					
					 <h:panelGrid columns="4" width="65%" columnClasses="alignTop,alignTop,alignTop,alignTop">			        
			            <rich:tree style="width:300px" nodeSelectListener="#{controlEstadisticas.processSelection}" 
			                reRender="selectedNode,gridParametros" ajaxSubmitSelection="true"  switchType="client"
			                value="#{controlEstadisticas.treeNode}" var="item" ajaxKeys="#{null}">
			            </rich:tree>			            
			            <h:outputText escape="false" value="Parámetro: #{controlEstadisticas.nodeTitle}" id="selectedNode" rendered="false"/>	
			            <h:panelGrid columnClasses="alignTop">
				            <h:outputLabel value="Parámetros seleccionados" style="font-weight: bold;" />
				            <h:panelGrid style="border-top: solid 1px;border-color: black;"
								id="tablaParametrosEst" width="100%" columnClasses="alignTop,alignTop,alignTop">				
						    	<rich:dataGrid value="#{controlEstadisticas.selectedParams}" var="par" columns="1" id="gridParametros"
						        	binding="#{controlEstadisticas.bindingGrid }" columnClasses="alignTop" >						    
							        <h:panelGrid columns="3">
							        	<h:outputLabel value="#{par}"/>
							        	<a4j:commandLink reRender="tablaParametrosEst,tablaCriteriosEst" 
							        		actionListener="#{controlEstadisticas.cargaCriterios }">
											<h:graphicImage url="/img/iconos/add.png"
												title="Especificar criterios" width="16" height="16"
												style="border: 0px;" />
										</a4j:commandLink>
							        	<a4j:commandLink reRender="tablaParametrosEst"
											actionListener="#{controlEstadisticas.delParam }">
											<h:graphicImage url="/img/iconos/minus.png"
												title="Eliminar parametro" width="16" height="16"
												style="border: 0px;" />
										</a4j:commandLink>
							        </h:panelGrid>
							    </rich:dataGrid>
						    </h:panelGrid>
						 
			            </h:panelGrid>  
			            <h:panelGrid columnClasses="alignTop">
				            <h:outputLabel value="Criterios de selección" style="font-weight: bold;" />
				            <h:panelGrid style="border-top: solid 1px;border-color: black;"
								id="tablaCriteriosEst" width="100%" columnClasses="alignTop,alignTop,alignTop">				
						    	<rich:dataGrid value="#{controlEstadisticas.selectedCriteria}" var="par" columns="1" id="gridCriterios"
						        	binding="#{controlEstadisticas.bindingGridCriterios }" columnClasses="alignTop" >						    
							        <h:panelGrid columns="3">
							        	<h:outputLabel value="#{par.nombre}"/>
							        	<h:panelGrid>
							        		<h:selectOneMenu value="#{par.valorInt}" rendered="#{par.clase eq '1.1.1.1'}">
												<f:selectItems value="#{controlEstadisticas.fabricante}" />												
											</h:selectOneMenu>
							        		<h:panelGrid columns="2" rendered="#{par.clase eq '3.1'}">
							        			<h:selectOneMenu value="#{par.operacion}">
													<f:selectItem itemLabel="=" itemValue="0" />
													<f:selectItem itemLabel="&gt;=" itemValue="1" />
													<f:selectItem itemLabel="&gt;" itemValue="2" />
													<f:selectItem itemLabel="&lt;" itemValue="3" />
													<f:selectItem itemLabel="&lt;=" itemValue="4" />																						
												</h:selectOneMenu>
												<h:inputText value="#{par.valorStr }" size="3"/>
							        		</h:panelGrid>
							        		<h:selectOneMenu value="#{par.valorInt}" rendered="#{par.clase eq '3.2'}">
												<f:selectItem itemLabel="Normal" itemValue="0" />
												<f:selectItem itemLabel="&gt;50%" itemValue="1" />
												<f:selectItem itemLabel="41-50%" itemValue="2" />
												<f:selectItem itemLabel="36-40%" itemValue="3" />
												<f:selectItem itemLabel="31-35%" itemValue="4" />
												<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
												<f:selectItem itemLabel="Deprimida" itemValue="6" />											
											</h:selectOneMenu>
							        		<h:selectOneMenu value="#{par.valorInt}" rendered="#{par.clase eq '3.4'}">
												<f:selectItems value="#{controlEstadisticas.cardiopatia}" />												
											</h:selectOneMenu>
											<h:selectOneMenu value="#{par.valorInt}" rendered="#{par.clase eq '3.3'}">
												<f:selectItem itemLabel="I" itemValue="1" />
												<f:selectItem itemLabel="II" itemValue="2" />
												<f:selectItem itemLabel="III" itemValue="3" />
												<f:selectItem itemLabel="IV" itemValue="4" />												
											</h:selectOneMenu>
											<h:selectOneMenu value="#{par.valorInt}" rendered="#{par.clase eq '3.20'}">
												<f:selectItem itemValue="1" itemLabel="Hipotiroidismo" />
												<f:selectItem itemValue="2" itemLabel="Hipertiroidismo" />											
											</h:selectOneMenu>
											<h:selectOneMenu value="#{par.valorInt}" rendered="#{par.clase eq '3.21'}">
												<f:selectItem itemValue="1" itemLabel="Síndrome del seno carotídeo" />
												<f:selectItem itemValue="2" itemLabel="Síndrome vasovagal" />
												<f:selectItem itemValue="3" itemLabel="Hipotensión ortostática" />											
											</h:selectOneMenu>
											
							        	</h:panelGrid>							  
							        	<a4j:commandLink reRender="tablaCriteriosEst"
											actionListener="#{controlEstadisticas.delCriterio }">
											<h:graphicImage url="/img/iconos/minus.png"
												title="Eliminar criterio" width="16" height="16"
												style="border: 0px;" />
										</a4j:commandLink>
							        </h:panelGrid>
							    </rich:dataGrid>
						    </h:panelGrid>
						 
			            </h:panelGrid>               		       
			        </h:panelGrid>
					<h:panelGrid id="panResultadosEstadisticas">
						<h:outputLabel value="Resultado" style="font-weight: bold;"/>			
						<h:panelGrid style="border-top: solid 1px;border-color: black;" width="80%">
							<h:inputTextarea cols="80" rows="8" value="#{controlEstadisticas.restexto }" id="resEstadisticaTexto" readonly="true"/>	
						</h:panelGrid>
					</h:panelGrid>	
					
				</rich:panel>
			</h:panelGrid>
			
			
			
		</h:form>
	</ui:define>
</ui:composition>
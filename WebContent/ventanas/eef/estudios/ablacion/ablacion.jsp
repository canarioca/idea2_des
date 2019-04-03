<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid width="100%" cellspacing="0" id="panabla" >
			<a4j:jsFunction name="updatetodo" reRender="panabla,panres" />
			<a4j:jsFunction name="updateabla" reRender="panabla" />
			<h:outputLabel value="#{ms.eef_tab_abl_tab_abl_sust_abordado }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="100%">
				<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idnodo }"
					onchange="updatetodo();">
					<f:selectItem itemLabel="#{ms.eef_abl_sust_0 }" itemValue="0"/>
					<f:selectItem itemLabel="#{ms.eef_abl_sust_1 }" itemValue="1"/>
					<f:selectItem itemLabel="#{ms.eef_abl_sust_2 }" itemValue="2"/>
					<f:selectItem itemLabel="#{ms.eef_abl_sust_3 }" itemValue="3"/>
					<f:selectItem itemLabel="#{ms.eef_abl_sust_4 }" itemValue="4"/>
					<f:selectItem itemLabel="#{ms.eef_abl_sust_5 }" itemValue="5"/>
					<f:selectItem itemLabel="#{ms.eef_abl_sust_6 }" itemValue="6"/>
					<f:selectItem itemLabel="#{ms.eef_abl_sust_7 }" itemValue="7"/>
					<f:selectItem itemLabel="#{ms.eef_abl_sust_8 }" itemValue="8"/>
					<f:selectItem itemLabel="#{ms.eef_abl_sust_9 }" itemValue="9"/>
				</h:selectOneMenu>
				<h:panelGrid width="100%" cellspacing="0">
					<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.idnodo eq 5}">
						<rich:spacer width="15px" />
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.iddcha }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_5_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_5_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_5_op3 }" />
						</h:selectOneMenu>
					</h:panelGrid>
					
					<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.idnodo eq 9}">
						<rich:spacer width="15px" />
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.iddcha }" onchange="updateabla();">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_9_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_9_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_9_op3 }" />
						</h:selectOneMenu>
						<rich:spacer width="15px" rendered="#{controlEef.eef.ablaciondto.iddcha eq 1}"/>
						<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.iddcha eq 1}">
							<rich:spacer width="15px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idizda }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_9_op1_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_9_op1_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_9_op1_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_9_op1_op4 }" />
								<f:selectItem itemValue="5" itemLabel="#{ms.eef_abl_sust_9_op1_op5 }" />
								<f:selectItem itemValue="6" itemLabel="#{ms.eef_abl_sust_9_op1_op6 }" />
								<f:selectItem itemValue="7" itemLabel="#{ms.eef_abl_sust_9_op1_op7 }" />							
							</h:selectOneMenu>
						</h:panelGrid>
						<rich:spacer width="15px" rendered="#{controlEef.eef.ablaciondto.iddcha eq 2}"/>
						<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.iddcha eq 2}">
							<rich:spacer width="15px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idizda }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_9_op2_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_9_op2_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_9_op2_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_9_op2_op4 }" />
							</h:selectOneMenu>
						</h:panelGrid>
						<rich:spacer width="15px" rendered="#{controlEef.eef.ablaciondto.iddcha eq 3}" />
						<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.iddcha eq 3}">
							<rich:spacer width="15px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idizda }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_9_op3_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_9_op3_op2 }" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
	
					<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.idnodo eq 2}">
						<rich:spacer width="15px" />
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.iddcha }" onchange="updateabla();">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_2_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_2_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_2_op3 }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_2_op4 }" />
						</h:selectOneMenu>
						<rich:spacer width="15px" rendered="#{controlEef.eef.ablaciondto.iddcha ne 0 and controlEef.eef.ablaciondto.iddcha ne 1}" />
						<h:panelGrid cellspacing="0" columns="2" 
							rendered="#{controlEef.eef.ablaciondto.iddcha ne 0 and controlEef.eef.ablaciondto.iddcha ne 1}">
							<rich:spacer width="15px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idizda }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_2_op2_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_2_op2_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_2_op2_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_2_op2_op4 }" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
	
					<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.idnodo eq 1}">
						<rich:spacer width="15px" />
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.iddcha }"
							onchange="updateabla();">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_1_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_1_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_1_op3 }" />
						</h:selectOneMenu>
						<rich:spacer width="15px"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 1}" />
						<h:panelGrid cellspacing="0" columns="2"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 1}">
							<rich:spacer width="15px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idizda }"
								onchange="updateabla();">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_1_op1_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_1_op1_op2 }" />
							</h:selectOneMenu>
							<rich:spacer width="15px" />
							<h:panelGrid cellspacing="0" columns="2"
								rendered="#{controlEef.eef.ablaciondto.idizda eq 2}">
								<rich:spacer width="15px" />
								<h:selectManyListbox value="#{controlEef.eef.ablaciondto.idparasepa }" >
									<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_1_op1_op2_op1 }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_1_op1_op2_op2 }" />
									<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_1_op1_op2_op3 }" />
									<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_1_op1_op2_op4 }" />
									<f:selectItem itemValue="5" itemLabel="#{ms.eef_abl_sust_1_op1_op2_op5 }" />
									<f:selectItem itemValue="6" itemLabel="#{ms.eef_abl_sust_1_op1_op2_op6 }" />
								</h:selectManyListbox>
								<rich:spacer width="15px" />
								<h:outputLabel value="#{ms.eef_tab_abl_tab_abl_varios }" style="font-size: 10px;font-style: italic;"/>
							</h:panelGrid>
						</h:panelGrid>
						<rich:spacer width="15px"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 2}" />
						<h:panelGrid cellspacing="0" columns="2"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 2}">
							<rich:spacer width="15px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idizda }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_1_op2_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_1_op2_op2 }" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
	
					<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.idnodo eq 8}">
						<rich:spacer width="15px" />
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.iddcha }"
							onchange="updateabla();">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_8_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_8_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_8_op3 }" />
							<f:selectItem itemValue="5" itemLabel="#{ms.eef_abl_sust_8_op5 }" />
							<f:selectItem itemValue="6" itemLabel="#{ms.eef_abl_sust_8_op6 }" />
							<f:selectItem itemValue="7" itemLabel="#{ms.eef_abl_sust_8_op7 }" />
							<f:selectItem itemValue="8" itemLabel="#{ms.eef_abl_sust_8_op8 }" />
							<f:selectItem itemValue="9" itemLabel="#{ms.eef_abl_sust_8_op9 }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_8_op4 }" />
						</h:selectOneMenu>
						<rich:spacer width="15px"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 4}" />
						<h:inputText size="40"
							value="#{controlEef.eef.ablaciondto.otratv }"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 4}" />
					</h:panelGrid>
	
					<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.idnodo eq 6}">
						<rich:spacer width="15px" />
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.iddcha }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_6_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_6_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_6_op3 }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_6_op4 }" />
						</h:selectOneMenu>
					</h:panelGrid>
	
					<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.idnodo eq 7}">
						<rich:spacer width="15px" />
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.iddcha }"
							onchange="updateabla();">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_7_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_7_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_7_op3 }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_7_op4 }" />
							<f:selectItem itemValue="5" itemLabel="#{ms.eef_abl_sust_7_op5 }" />
							<f:selectItem itemValue="6" itemLabel="#{ms.eef_abl_sust_7_op6 }" />
							<f:selectItem itemValue="8" itemLabel="#{ms.eef_abl_sust_7_op8 }" />
							<f:selectItem itemValue="9" itemLabel="#{ms.eef_abl_sust_7_op9 }" />
							<f:selectItem itemValue="10" itemLabel="#{ms.eef_abl_sust_7_op10 }" />
							<f:selectItem itemValue="7" itemLabel="#{ms.eef_abl_sust_7_op7 }" />
						</h:selectOneMenu>
						<rich:spacer width="15px"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 7}" />
						<h:inputText size="40" value="#{controlEef.eef.ablaciondto.otro }"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 7}" />
					</h:panelGrid>
					
					<h:panelGrid cellspacing="0" columns="2" rendered="#{controlEef.eef.ablaciondto.idnodo eq 4}">
						<rich:spacer width="15px" />
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.iddcha }"
							onchange="updateabla();">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_4_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_4_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_4_op3 }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_4_op4 }" />						
						</h:selectOneMenu>
						<rich:spacer width="15px"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 1}" />
						<h:panelGrid cellspacing="0" columns="2"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 1}">
							<rich:spacer width="15px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idizda }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_4_op1_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_4_op1_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_4_op1_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_4_op1_op4 }" />
								<f:selectItem itemValue="5" itemLabel="#{ms.eef_abl_sust_4_op1_op5 }" />
								<f:selectItem itemValue="6" itemLabel="#{ms.eef_abl_sust_4_op1_op6 }" />
							</h:selectOneMenu>
						</h:panelGrid>
						<rich:spacer width="15px"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 3}" />
						<h:panelGrid cellspacing="0" columns="2"
							rendered="#{controlEef.eef.ablaciondto.iddcha eq 3}">
							<rich:spacer width="15px" />
							<h:selectOneMenu value="#{controlEef.eef.ablaciondto.idizda }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_abl_sust_4_op3_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_abl_sust_4_op3_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.eef_abl_sust_4_op3_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.eef_abl_sust_4_op3_op4 }" />
								<f:selectItem itemValue="5" itemLabel="#{ms.eef_abl_sust_4_op3_op5 }" />
								<f:selectItem itemValue="6" itemLabel="#{ms.eef_abl_sust_4_op3_op6 }" />
								<f:selectItem itemValue="7" itemLabel="#{ms.eef_abl_sust_4_op3_op7 }" />
								<f:selectItem itemValue="8" itemLabel="#{ms.eef_abl_sust_4_op3_op8 }" />
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		
		<t:fieldset legend="#{ms.eef_tab_abl_tab_abl_cats }">
			<a4j:commandLink reRender="tablaAplicacionesAbl" rendered="false"
				actionListener="#{controlEef.addAplicacion }"
				value="Asociar catéter">
				<h:graphicImage url="/img/iconos/add.png"
					title="Asociar catéter" width="16" height="16"
					style="border: 0px;" />
			</a4j:commandLink>
			
			
			<h:panelGrid>
				<a4j:commandLink reRender="tablaAplicacionesAbordajes"
					onclick="javascript:Richfaces.showModalPanel('insertarAbordaje');"
					value="#{ms.eef_tab_abl_tab_abl_cats_abordaje_nuevo }">
					<h:graphicImage url="/img/iconos/add.png"
						title="#{ms.eef_tab_abl_tab_abl_cats_abordaje_nuevo_title }" width="16" height="16"
						style="border: 0px;" />
				</a4j:commandLink>
				<h:panelGrid width="100%" style="border-top: solid 1px;border-color: black;">
					<h:panelGrid id="tablaAplicacionesAbordajes" width="100%">
						<t:dataTable styleClass="hor-minimalist-b" var="item"
							width="100%" value="#{controlEef.eef.ablaciondto.lista }"
							binding="#{controlEef.eef.ablaciondto.bindingApls}"
							id="dataTableAplicacionesAbordajes" rowIndexVar="rib">
							<t:column width="20%" headerstyleClass="left">
								<f:facet name="header">
									<h:outputText value="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via }" />
								</f:facet>
								<h:panelGrid columnClasses="alignTop">
									<h:selectOneMenu value="#{item.idvia }" disabled="true">
										<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op1 }" />
										<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op2 }" />
										<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op3 }" />
										<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op4 }" />
										<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op5 }" />
										<f:selectItem itemValue="6" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op6 }" />
										<f:selectItem itemValue="7" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op7 }" />								
									</h:selectOneMenu>
									<a4j:commandLink reRender="tablaAplicacionesAbordajes"
										actionListener="#{controlEef.addAplicacion }"
										value="#{ms.eef_tab_abl_tab_abl_cats_asociar }">
										<h:graphicImage url="/img/iconos/add.png"
											title="#{ms.eef_tab_abl_tab_abl_cats_asociar }" width="16" height="16"
											style="border: 0px;" />
									</a4j:commandLink>
								</h:panelGrid>
							</t:column>
							<t:column width="20%" headerstyleClass="left">
								<f:facet name="header">							
									<h:outputText value="#{ms.eef_tab_abl_tab_abl_cats_title }" />
								</f:facet>
								<h:panelGrid id="tablaOfAplicacion">
									<h:panelGrid >
										<t:dataTable styleClass="hor-minimalist-b" var="apl"
											width="100%" value="#{item.listacats }"
											binding="#{controlEef.eef.ablaciondto.bindingAbordajes}" id="dataTableOfAplicacion" rowIndexVar="aplindex">
											<t:column width="20%" headerstyleClass="left">
												<f:facet name="header">
													<h:outputLabel value="#{ms.eef_tab_abl_tab_abl_cats_modelo }" />
												</f:facet>
												<h:panelGrid columns="2">
													<h:selectOneMenu value="#{apl.modelo }"> 
														<f:selectItems value="#{controlEef.cateef }" />	
														<a4j:support event="onchange" reRender="tablaOfAplicacion,dataTableAOfplicacion,tablaAplicacionesAbordajes,energiaApl" ajaxSingle="true"
															actionListener="#{controlEef.cambiaModeloCateterAblacionAplicacion}"/>							
													</h:selectOneMenu>
												</h:panelGrid>
											</t:column>
											<t:column width="20%" headerstyleClass="left">
												<f:facet name="header">
													<h:outputLabel value="#{ms.eef_tab_abl_tab_abl_cats_energia }" />
												</f:facet>
												<h:panelGrid columnClasses="alignTop" id="energiaApl">
													<h:selectOneMenu value="#{apl.energia }" disabled="true">
														<f:selectItem itemValue="0" itemLabel="" />
														<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_energia_rf }" />
														<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_energia_crioabl }" />	
														<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_energia_laser }" />
														<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_energia_ultrasonidos }" />
													</h:selectOneMenu>	
												</h:panelGrid>
											</t:column>
											<t:column width="20%" headerstyleClass="left">
												<f:facet name="header">
													<h:outputLabel value="#{ms.eef_tab_abl_tab_abl_cats_apl_tiempo }" />
												</f:facet>
												<h:panelGrid columnClasses="alignTop">
													<h:inputText size="4" value="#{apl.tiempo }" maxlength="4"/>
												</h:panelGrid>
											</t:column>
											<t:column width="20%" headerstyleClass="left">
												<f:facet name="header">
													<h:outputLabel value="#{ms.eef_tab_abl_tab_abl_cats_apl_pot_temp }" title="#{ms.eef_tab_abl_tab_abl_cats_apl_pot_temp_title }"/>
												</f:facet>
												<h:panelGrid columnClasses="alignTop">
													<h:inputText size="4" value="#{apl.potencia }" maxlength="4"/>
												</h:panelGrid>
											</t:column>											
											<t:column width="20%" headerstyleClass="left" >
												<f:facet name="header">
													<h:outputLabel value="#{ms.eef_tab_abl_tab_abl_cats_apl_imp }" rendered="#{apl.energia ne 2 }"/>
												</f:facet>
												<h:panelGrid columnClasses="alignTop">
													<h:inputText size="4" value="#{apl.impedancia }" maxlength="4" rendered="#{apl.energia ne 2 }"/>
												</h:panelGrid>
											</t:column>
											<t:column headerstyleClass="left">
												<a4j:commandLink reRender="tablaOfAplicacion,tablaAplicacionesAbordajes,"
													actionListener="#{controlEef.delAplicacion }">
													<h:graphicImage url="/img/iconos/minus.png"
														title="#{ms.eef_tab_abl_tab_abl_cats_del }" width="16" height="16"
														style="border: 0px;" />
												</a4j:commandLink>
											</t:column>			
										</t:dataTable>
									</h:panelGrid>
								</h:panelGrid>
							</t:column>	
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="tablaAplicacionesAbordajes,"
									actionListener="#{controlEef.delAbordaje }">
									<h:graphicImage url="/img/aplicacion/icoCancelar.png"
										title="#{ms.eef_tab_abl_tab_abl_cats_abordaje_del }" width="16" height="16"
										style="border: 0px;" />
								</a4j:commandLink>
							</t:column>					
						</t:dataTable>
					</h:panelGrid>
				</h:panelGrid>
			
			</h:panelGrid>
			
			
			
			<h:panelGrid width="100%" cellspacing="0" columns="3" id="panablacion"
				columnClasses="alignTop33,alignTop33,alignTop33" rendered="false">
				<h:panelGrid width="100%">
					<h:outputLabel value="Abordaje" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						width="70%">
						<h:selectOneRadio layout="pageDirection"
							value="#{controlEef.eef.ablaciondto.idabordaje }">
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op3 }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op4 }" />
							<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op5 }" />
							<f:selectItem itemValue="6" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op6 }" />
							<f:selectItem itemValue="7" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op7 }" />
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid width="100%">
					<h:outputLabel value="Energía utilizada" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						width="70%">
						<h:selectOneRadio layout="pageDirection"
							value="#{controlEef.eef.ablaciondto.idenergia }">
							<f:selectItem itemValue="1" itemLabel="Radiofrecuencia" />
							<f:selectItem itemValue="2" itemLabel="Crioablación" />
							<f:selectItem itemValue="3" itemLabel="Ambas" />
						</h:selectOneRadio>
						<h:panelGrid columns="3" cellspacing="0">
							<rich:spacer width="15px" />
							<h:outputLabel value="Tiempo radiofrecuencia" />
							<h:inputText size="20"
								value="#{controlEef.eef.ablaciondto.tradio }" />
							<rich:spacer width="15px" />
							<h:outputLabel value="Tiempo crioablación" />
							<h:inputText size="20" value="#{controlEef.eef.ablaciondto.tcrio }" />
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid width="100%">
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<h:outputLabel value="Catéter empleado" style="font-weight: bold;" />
						<a4j:commandLink reRender="tablaCatAbl"
							actionListener="#{controlEef.eef.ablaciondto.addCateter }">
							<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
								style="border:0;" title="Añadir catéter" />
						</a4j:commandLink>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						id="tablaCatAbl" width="90%">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
							value="#{controlEef.eef.ablaciondto.cateteres }"
							binding="#{controlEef.eef.ablaciondto.bincat }">
							<t:column width="90%" headerstyleClass="left">
								<f:facet name="header">
									<h:outputLabel value="Catéter" />
								</f:facet>
								<h:panelGrid columns="2">
									<h:inputText id="CatetAbl" size="30" value="#{linea.tmpString1 }" />
									<h:graphicImage value="/img/iconos/arrow.png"
										onclick="#{rich:component('suggestionBoxCateterAbl')}.callSuggestion(true)" />
									<rich:suggestionbox id="suggestionBoxCateterAbl" for="CatetAbl"
										suggestionAction="#{controlEef.autocompletarCateteresAblacion}"
										var="result" zindex="50000" width="200" height="100"
										nothingLabel="No se encontró ningún catéter">
										<a4j:ajaxListener type="org.ajax4jsf.ajax.ForceRender" />
										<h:column>
											<h:outputText value="#{result.valor}"
												style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;" />
										</h:column>
									</rich:suggestionbox>
								</h:panelGrid>
							</t:column>
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="tablaCatAbl"
									actionListener="#{controlEef.eef.ablaciondto.delCateter }">
									<h:graphicImage url="/img/iconos/minus.png"
										title="Eliminar catéter" width="16" height="16"
										style="border: 0px;" />
								</a4j:commandLink>
							</t:column>
						</t:dataTable>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</t:fieldset>
	</h:panelGrid>

	<rich:modalPanel id="insertarAbordaje" autosized="true" zindex="200" minWidth="150">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.eef_tab_abl_tab_abl_cats_modal_nuevo }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink 
					onclick="javascript:Richfaces.hideModalPanel('insertarAbordaje');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('insertarAbordaje')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="nuevocatetereef" width="10%" columns="2">
			<h:selectOneMenu value="#{controlEef.idviaaux }" >
				<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op1 }" />
				<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op2 }" />
				<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op3 }" />
				<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op4 }" />
				<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op5 }" />
				<f:selectItem itemValue="6" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op6 }" />
				<f:selectItem itemValue="7" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op7 }" />
				<f:selectItem itemValue="8" itemLabel="#{ms.eef_tab_abl_tab_abl_cats_abordaje_via_op8 }" />
			</h:selectOneMenu>
			<a4j:commandLink actionListener="#{controlEef.addAbordaje}" reRender="tablaAplicacionesAbordajes"
				onclick="javascript:Richfaces.hideModalPanel('insertarAbordaje');">
				<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
					width="16px" height="16px" title="#{ms.confirmar }"/>
			</a4j:commandLink>
		</h:panelGrid>
	</rich:modalPanel>
	
	
</ui:composition>
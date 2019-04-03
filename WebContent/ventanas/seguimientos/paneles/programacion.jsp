<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">

	<h:panelGrid width="50%" columns ="2" columnClasses="alignTop,alignTop,alignTop"
		rendered="#{controlSeguimientos.tipogen ne 6 }">
		<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_modo } " style="font-weight: bold;" />
		<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_fbasica }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;">
			<h:selectOneMenu value="#{controlSeguimientos.hev.modogen }">
				<f:selectItems value="#{controlSeguimientos.modogen}" />					
			</h:selectOneMenu>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;">
			<h:inputText size="4" value="#{controlSeguimientos.hev.fbasica }" maxlength="5"/>
		</h:panelGrid>			
	</h:panelGrid>	
	<h:panelGrid columns="2" rendered="#{!empty controlSeguimientos.listagenerador[0].rf &amp;&amp; controlSeguimientos.listagenerador[0].rf eq 'Si'}">
		<h:selectBooleanCheckbox value="#{controlSeguimientos.hev.segrem }">
			<a4j:support event="onclick" actionListener="#{controlSeguimientos.cambiaSegRem}"/>
		</h:selectBooleanCheckbox>
		<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_segrem }" style="font-weight: bold;" />
	</h:panelGrid>
	<h:panelGrid columns="2" rendered="#{controlSeguimientos.tipogen ne 6 and controlSeguimientos.tipogen ne 5}">
		<h:selectBooleanCheckbox value="#{controlSeguimientos.hev.minestvent }">
			<a4j:support event="onclick" actionListener="#{controlSeguimientos.cambiaMinEstVent}"/>
		</h:selectBooleanCheckbox>
		<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_mev }" style="font-weight: bold;" />
	</h:panelGrid>	
	<h:panelGrid rendered="#{controlSeguimientos.tipogen eq 3 || controlSeguimientos.tipogen eq 4}" 
		id="estimfrenSeg" columns="2">
		<h:selectBooleanCheckbox value="#{controlSeguimientos.hev.estimfren }">
			<a4j:support event="onclick" reRender="estimfrenSeg" ajaxSingle="true"/>
		</h:selectBooleanCheckbox>
		<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_estim_fren }" style="font-weight: bold;"/>
		 <h:outputLabel value="Umbral(V)" rendered="#{controlSeguimientos.hev.estimfren eq true}"/>
		<h:inputText size="4" value="#{controlSeguimientos.hev.umbralEstimfren }" maxlength="5"
			rendered="#{controlSeguimientos.hev.estimfren eq true}"/>			
	</h:panelGrid>
	<rich:panel rendered="#{controlSeguimientos.tipogen eq 2 || controlSeguimientos.tipogen eq 4 || controlSeguimientos.tipogen eq 6}">
		<f:facet name="header">
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas }"/>
		</f:facet>
		<h:panelGrid width="100%">
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas }" style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaZonasVSeg"
					actionListener="#{controlSeguimientos.addZona }">
					<h:graphicImage value="/img/iconos/add.png" width="16"
						height="16" style="border:0;" title="#{ms.aniadir }"/>				
				</a4j:commandLink>
				<a4j:commandLink reRender="tablaZonasVSeg"
					actionListener="#{controlSeguimientos.cargarAvanzadosZona }">
					<h:graphicImage value="/img/iconos/list-view.png" width="16"
						height="16" style="border:0;" title="#{ms.imp_dispositivos_tab_ev_prog_zonas_av }"/>				
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaZonasVSeg" width="100%" columnClasses="alignTop,alignTop,alignTop">	
				<rich:dataGrid value="#{controlSeguimientos.hev.zonas}" var="zona" columns="6" elements="6"
					 binding="#{controlSeguimientos.bindingGrid }" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop,alignTop">
					 <rich:panel bodyClass="pbody">
					     <f:facet name="header">
						      <h:outputText value="#{zona.tipo}"/>
					     </f:facet>
					     <a4j:commandLink reRender="tablaZonasVSeg"
							actionListener="#{controlSeguimientos.delZona }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eliminar }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					     <h:panelGrid columns="2">
					         <h:outputText value="#{ms.imp_dispositivos_tab_ev_prog_zonas_fc_ppm }" styleClass="label"/>
					         <h:outputText value="#{ms.imp_dispositivos_tab_ev_prog_zonas_fc_ms }" styleClass="label"/>
					         <h:panelGrid style="border-top: solid 1px;border-color: black;">
					            <h:inputText value="#{zona.fcPpm}" size="4" maxlength="4">
					               <a4j:support event="onchange" reRender="tablaZonasVSeg" ajaxSingle="true"
										actionListener="#{controlSeguimientos.gestionaZona}"/>
					            </h:inputText>
					         </h:panelGrid>
					         <h:panelGrid style="border-top: solid 1px;border-color: black;">
					             <h:inputText value="#{zona.fcMs}" size="4" maxlength="4">
					              	<a4j:support event="onchange" reRender="tablaZonasVSeg" ajaxSingle="true"
										actionListener="#{controlSeguimientos.gestionaZonaMs}"/>
								</h:inputText>
					         </h:panelGrid>					                    					             					                    
					     </h:panelGrid>
					     <h:panelGrid rendered="#{controlSeguimientos.tipogen ne 6}">
					         <h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp }"/>
					         <h:panelGrid columnClasses="alignTop,alignTop,alignTop"
					            style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{zona.numatpini}">
									<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_num_0 }" />
									<f:selectItem itemValue="1" itemLabel="1" />
									<f:selectItem itemValue="2" itemLabel="2" />
									<a4j:support event="onchange" reRender="tablaZonasVSeg,panelAtpAvanzadasSeg" ajaxSingle="true"
										actionListener="#{controlSeguimientos.cargaATPZona}"/>					
								</h:selectOneMenu>
								<h:panelGrid id="panelAtpAvanzadasSeg" width="30%" columnClasses="alignTop,alignTop,alignTop"
									rendered="#{controlSeguimientos.avzona eq true}">
									<f:facet name="header">
										<h:panelGroup>
										     <h:outputText value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_av }"></h:outputText>
										 </h:panelGroup>
									</f:facet>							        
									<h:panelGrid width="80%" rendered="#{!empty zona.atps[0]}">
										<rich:panel>
											<f:facet name="header">
												<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp }1" 
													style="font-weight: bold;"/>
											</f:facet>
											<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_tipo }"/>
												<h:panelGrid style="border-top: solid 1px;border-color: black;">													
													<h:selectOneMenu value="#{zona.atps[0].tipo}">
														<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
														<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_tipo_op1 }" />
														<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_tipo_op2 }" />	
																		
													</h:selectOneMenu>	
												</h:panelGrid>
												<h:panelGrid columns="2">
													<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_numsec }"/>
													<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_ciclos }"/>
													<h:panelGrid style="border-top: solid 1px;border-color: black;">							
														<h:inputText value="#{zona.atps[0].numsec}" size="3" maxlength="4"/>
													</h:panelGrid>							
													<h:panelGrid style="border-top: solid 1px;border-color: black;">												
														<h:inputText value="#{zona.atps[0].ciclosec}" size="3" maxlength="4"/>	
													</h:panelGrid>
												</h:panelGrid>
												<h:panelGrid columns="2">
													<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_acop }"/>	
													<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_decr }"/>
													<h:panelGrid style="border-top: solid 1px;border-color: black;">		
														<h:inputText value="#{zona.atps[0].acoplamiento}" size="3" maxlength="4"/>
													</h:panelGrid>
													<h:panelGrid style="border-top: solid 1px;border-color: black;">
														<h:inputText value="#{zona.atps[0].decremento}" size="3" maxlength="4"/>	
													</h:panelGrid>	
												</h:panelGrid>											
											</rich:panel>
										</h:panelGrid>	
										<h:panelGrid width="80%" rendered="#{!empty zona.atps[1]}">
										    <rich:panel>
												<f:facet name="header">
													<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp }2" 
														style="font-weight: bold;"/>
												</f:facet>
												<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_tipo }"/>
												<h:panelGrid style="border-top: solid 1px;border-color: black;">													
													<h:selectOneMenu value="#{zona.atps[1].tipo}">
														<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
														<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_tipo_op1 }" />
														<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_tipo_op2 }" />	
																		
													</h:selectOneMenu>	
												</h:panelGrid>
												<h:panelGrid columns="2">
													<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_numsec }"/>
													<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_ciclos }"/>
													<h:panelGrid style="border-top: solid 1px;border-color: black;">							
														<h:inputText value="#{zona.atps[1].numsec}" size="3" maxlength="4"/>
													</h:panelGrid>							
													<h:panelGrid style="border-top: solid 1px;border-color: black;">												
														<h:inputText value="#{zona.atps[1].ciclosec}" size="3" maxlength="4"/>	
													</h:panelGrid>
												</h:panelGrid>
												<h:panelGrid columns="2">
													<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_acop }"/>	
													<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_decr } " />														
													<h:panelGrid style="border-top: solid 1px;border-color: black;">		
														<h:inputText value="#{zona.atps[1].acoplamiento}" size="3" maxlength="4"/>
													</h:panelGrid>
													<h:panelGrid style="border-top: solid 1px;border-color: black;">
														<h:inputText value="#{zona.atps[1].decremento}" size="3" maxlength="4"/>	
													</h:panelGrid>	
												</h:panelGrid>											
											</rich:panel>
										 </h:panelGrid>	
									</h:panelGrid>							    
								</h:panelGrid>
					        </h:panelGrid>
					        <h:panelGrid columns="2">
					            <h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_choques }"/>
					            <h:selectBooleanCheckbox value="#{zona.choqini }">
									<a4j:support event="onclick" reRender="tablaZonasVSeg" ajaxSingle="true" />
								</h:selectBooleanCheckbox>
					            <h:panelGrid id="panelchoquesSeg" columnClasses="alignTop,alignTop,alignTop"
					                style="border-top: solid 1px;border-color: black;" rendered="#{zona.choqini eq true}">											
									<h:panelGrid columns="3" rendered="#{!empty zona.chqs[0]}">																					
										<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_choques_ene_ini }"/>
										<h:inputText value="#{zona.chqs[0].energia}" size="4" maxlength="4"/>
									</h:panelGrid>																												
									 <t:dataTable styleClass="hor-minimalist-b" var="ch"
										width="100%" value="#{zona.chqs}" id="tablaZonasSeg"
										binding="#{controlSeguimientos.bindingChoques }"
										rendered="#{controlSeguimientos.avzona eq true}">
										<t:column width="30%" headerstyleClass="left">
											<h:panelGrid columns="2">
												<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_choques_energia }"/>
												<h:inputText value="#{ch.energia}" size="4" maxlength="4">
													<a4j:support event="onchange" reRender="panelchoquesSeg" ajaxSingle="true"
														actionListener="#{controlSeguimientos.cambiaEnergiaChoques}"/>						
												</h:inputText>
											</h:panelGrid>													
										</t:column>
										<t:column width="30%" headerstyleClass="left">
											<h:panelGrid>
												<r:inputNumberSlider value="#{ch.numch}" minValue="0" maxValue="8" 
													rendered="#{controlSeguimientos.avzona eq true}">
													<a4j:support event="onchange" reRender="panelchoquesSeg" ajaxSingle="true"
														actionListener="#{controlSeguimientos.cambiaNumeroChoques }"/>						
												</r:inputNumberSlider>
											</h:panelGrid>
										</t:column>
										<t:column width="30%" headerstyleClass="left">
											<a4j:commandLink reRender="panelchoquesSeg"
												actionListener="#{controlSeguimientos.delChoque }">
												<h:graphicImage url="/img/iconos/minus.png"
													title="#{ms.eliminar }" width="16" height="16"
													style="border: 0px;" />
											</a4j:commandLink>
										</t:column>
									</t:dataTable>
									<a4j:commandLink title="#{ms.imp_dispositivos_tab_ev_prog_zonas_choques_add }" value="Añadir choque"
										actionListener="#{controlSeguimientos.addChoque}" reRender="panelchoquesSeg" 
										rendered="#{zona.choqini eq true &amp;&amp; controlSeguimientos.avzona eq true}"/>
								</h:panelGrid>
					        </h:panelGrid>
					    </rich:panel>
					</rich:dataGrid>      
				</h:panelGrid>
			</h:panelGrid>	
		</rich:panel>			
		<br/>
		<h:panelGrid columns="2" rendered="#{controlSeguimientos.tipogen eq 3 || controlSeguimientos.tipogen eq 4}" width="100%"
			columnClasses="alignTop,alignTop,alignTop">		
			<rich:panel id="iavCRTSeg">
				<f:facet name="header">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos }"/>
				</f:facet>
				<h:panelGrid columns="2" width="30%">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_det }"
						style="font-weight: bold;"/>		
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_est }"
						style="font-weight: bold;"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText size="4" value="#{controlSeguimientos.hev.iavdetec }" maxlength="5"/>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText size="4" value="#{controlSeguimientos.hev.iavestim }" maxlength="5"/>
					</h:panelGrid>
					<rich:spacer width="10" />		
				</h:panelGrid>				
				<rich:spacer height="10"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientos.hev.iavdinamico }">
					<a4j:support event="onclick" reRender="iavCRTSeg" ajaxSingle="true"/>
			  	</h:selectBooleanCheckbox>
			  	<rich:spacer width="10" />
			  	<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_dinam }"
						style="font-weight: bold;"/>
				<h:panelGrid columns="3" style="border-top: solid 1px;border-color: black;vertical-align:top;"
					rendered="#{controlSeguimientos.hev.iavdinamico eq true}" columnClasses="alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_max }"
						style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlSeguimientos.hev.iavmax }" maxlength="5"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_ms }"
						style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_min }"
						style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlSeguimientos.hev.iavmin }" maxlength="5"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_ms }"
						style="font-weight: bold;"/>
				</h:panelGrid>
				<br/>
				<a4j:jsFunction name="actualizaSecuenciaActivacion" reRender="iavCRTSeg"/>
				<h:panelGrid columns="2">
					<h:panelGrid>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_sec_act }"
							style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:selectOneMenu value="#{controlSeguimientos.hev.sactivacion}"
								onchange="actualizaSecuenciaActivacion();">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_sec_act_op1 }" />	
								<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_sec_act_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_sec_act_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_sec_act_op4 }" />
								<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_sec_act_op5 }" />										
							</h:selectOneMenu>
						</h:panelGrid>						
					</h:panelGrid>
					<h:panelGrid>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_sec_act_ivv }" rendered="#{controlSeguimientos.hev.sactivacion eq 2 || controlSeguimientos.hev.sactivacion eq 3 || controlSeguimientos.hev.sactivacion eq 4}"
							style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputText size="4" value="#{controlSeguimientos.hev.ivv}" maxlength="5" 
								rendered="#{controlSeguimientos.hev.sactivacion eq 2 || controlSeguimientos.hev.sactivacion eq 3 || controlSeguimientos.hev.sactivacion eq 4}"/>
						</h:panelGrid>						
					</h:panelGrid>				
				</h:panelGrid>			
				<h:panelGrid columns="2">
					<h:panelGrid>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_opt_inte }" style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:selectOneMenu value="#{controlSeguimientos.optint }"
								onchange="actualizaSecuenciaActivacion();">
								<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_op0 }" />	
								<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_op3 }" />										
							</h:selectOneMenu>
						</h:panelGrid>						
					</h:panelGrid>
					<h:panelGrid>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_frec }" rendered="#{controlSeguimientos.optint ne 0 }"
							style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:selectOneMenu value="#{controlSeguimientos.optint }" 
								rendered="#{controlSeguimientos.optint ne 0 }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_frec_op1 }" />	
								<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_frec_op2 }" />															
							</h:selectOneMenu>
						</h:panelGrid>						
					</h:panelGrid>				
				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>
	<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_tab_ev_prog_av }" opened="false">
		<h:panelGrid columns="3" width="80%" columnClasses="alignTop,alignTop,alignTop" id="progavgenSeg"
			rendered="#{controlSeguimientos.tipogen ne 6}">
			<h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_fmax }" style="font-weight: bold;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputText size="4" value="#{controlSeguimientos.hev.fmax }"/>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_freposo }" style="font-weight: bold;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputText size="4" value="#{controlSeguimientos.hev.fmin }" maxlength="4"/>
				</h:panelGrid>			
			</h:panelGrid>
			<h:panelGrid columns="2" rendered="#{controlSeguimientos.tipogen ne 5 }">
				<h:selectBooleanCheckbox value="#{controlSeguimientos.hev.prevfa}">
					<a4j:support event="onclick" reRender="evHisteresisSeg" ajaxSingle="true"
						actionListener="#{controlSeguimientos.cambiaAlgPrevFA }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_alg_prev_fa }" style="font-weight: bold;"/>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid columns="4" id="evHisteresisSeg" rendered="#{controlSeguimientos.tipogen ne 6}">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_histeresis }" 
					style="font-weight: bold;"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientos.hev.hist}">
					<a4j:support event="onclick" reRender="evHisteresisSeg" 
						actionListener="#{controlSeguimientos.cambiaHisteresis }" ajaxSingle="true"/>
				</h:selectBooleanCheckbox>
				<h:inputText size="4" value="#{controlSeguimientos.hev.valorHisteresis }" maxlength="4"
					rendered="#{controlSeguimientos.hev.hist eq true}"/>
		</h:panelGrid>
		<h:panelGrid rendered="#{controlSeguimientos.tipogen eq 1 || controlSeguimientos.tipogen eq 2}" width="50%"
			columnClasses="alignTop,alignTop,alignTop">
			<rich:panel id="iavMPDAISeg" >
				<f:facet name="header">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos }"/>
				</f:facet>				
				<h:panelGrid columns="2" width="40%">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_det }"
						style="font-weight: bold;"/>		
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_est }"
						style="font-weight: bold;"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText size="4" value="#{controlSeguimientos.hev.iavdetec }" maxlength="5"/>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText size="4" value="#{controlSeguimientos.hev.iavestim }" maxlength="5"/>
					</h:panelGrid>
					<rich:spacer width="10" />		
				</h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_dinam }"
						style="font-weight: bold;"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientos.hev.iavdinamico}">
					<a4j:support event="onclick" reRender="iavMPDAISeg" ajaxSingle="true"/>
			  	</h:selectBooleanCheckbox>
				<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;vertical-align:top;"
					rendered="#{controlSeguimientos.hev.iavdinamico eq true}" columnClasses="alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_max }"
						style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlSeguimientos.hev.iavmax }" maxlength="4"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_min }"
						style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlSeguimientos.hev.iavmin }" maxlength="4"/>
				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>
		<h:panelGrid rendered="#{controlSeguimientos.tipogen eq 2 || controlSeguimientos.tipogen eq 4 || controlSeguimientos.tipogen eq 6}" width="50%"
			columnClasses="alignTop,alignTop,alignTop">
			<rich:panel id="estimulacionpostchoqueDAISeg" rendered="#{controlSeguimientos.tipogen eq 2 || controlSeguimientos.tipogen eq 4 || controlSeguimientos.tipogen eq 6}">
				<f:facet name="header">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_param_choque }"/>
				</f:facet>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque }" style="font-weight: bold;"/>
				<h:panelGrid columns="4" style="width:50%;border-top: solid 1px;border-color: black;vertical-align:top;"
					columnClasses="alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_ampl }" style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlSeguimientos.hev.ampPostch }" maxlength="4"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_frec }" style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlSeguimientos.hev.frecPostch }" maxlength="4"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_durpuls }" style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlSeguimientos.hev.durpulsoPostch }" maxlength="4"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_duracion }" style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlSeguimientos.hev.durPostch }" maxlength="4"/>
				</h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf }" style="font-weight: bold;"/>
				<h:panelGrid columns="2" style="width:50%;border-top: solid 1px;border-color: black;vertical-align:top;"
					columnClasses="alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf_title }" style="font-weight: bold;"/>
					<h:selectOneMenu value="#{controlSeguimientos.hev.confch }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf_op1 }" />	
						<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf_op2 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf_op3 }" />
						<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf_op4 }" />
						<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf_op5 }" />	
						<f:selectItem itemValue="6" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf_op6 }" />									
					</h:selectOneMenu>
				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>
	</rich:simpleTogglePanel>
</ui:composition>
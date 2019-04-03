<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">
	
	<h:panelGrid width="100%" id="evolucion">
	<h:panelGrid width="100%" columns ="2" columnClasses="alignTop,alignTop">
		<h:panelGrid width="100%" columns="1" id="tablaUmb" style="text-align:center" rendered="#{controlImplantes.tipogen ne 6}">
			<h:outputLabel value="#{ms.imp_dispositivos_ele_umbrales }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%">
				<h:dataTable value="#{controlImplantes.listaelectrodos }" var="lis">
		            <h:column>
		              <f:facet name="header">
		                <h:outputText value="#{ms.imp_dispositivos_ele_tipo_elec }"/>
		              </f:facet>
		              <h:outputText value="AD" rendered="#{lis.camara eq 948 &amp;&amp; lis.estado eq 0}" />
		              <h:outputText value="VD" rendered="#{lis.camara eq 949 &amp;&amp; lis.estado eq 0}"/>
		              <h:outputText value="VI" rendered="#{lis.camara eq 950 &amp;&amp; lis.estado eq 0}"/>
		              <h:outputText value="LEADLESS" rendered="#{lis.camara eq 0 &amp;&amp; lis.estado eq 0}"/>
		              <h:outputText value="#{lis.abordajetexto }" rendered="#{lis.conector eq 'SQ1' and lis.estado eq 0}" />
		            </h:column>
		            <h:column>
		              <f:facet name="header">
		                <h:outputText value="#{ms.imp_dispositivos_ele_onda_rp }"/>
		              </f:facet>
		              <h:inputText size="4" value="#{lis.ondarpEv}" rendered="#{lis.estado eq 0 }" maxlength="5" disabled="#{lis.conector eq 'SQ1'}"/>
		            </h:column>
		            <h:column>
		              <f:facet name="header">
		                <h:outputText value="#{ms.imp_dispositivos_ele_umbral_v }"/>
		              </f:facet>
		              <h:inputText size="4" value="#{lis.umbralvEv}" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" maxlength="5" disabled="#{lis.conector eq 'SQ1'}"/>
		              <h:outputLabel value=""/>
		            </h:column>
		            <h:column>
		              <f:facet name="header">
		                <h:outputText value="#{ms.imp_dispositivos_ele_umbral_ms }"/>
		              </f:facet>
		              <h:inputText size="4" value="#{lis.umbralmsEv}" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" maxlength="5" disabled="#{lis.conector eq 'SQ1'}"/>
		              <h:outputLabel value=""/>
		            </h:column>
		            <h:column>
		              <f:facet name="header">
		                <h:outputText value="#{ms.imp_dispositivos_ele_imped_ohm_1 }"/>
		              </f:facet>
		              <h:inputText size="4" value="#{lis.impohmEv}" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" maxlength="5"/>
		            </h:column>
		            <h:column>
		              <f:facet name="header">
		                <h:outputText value="#{ms.imp_dispositivos_ele_imp_v }"/>
		              </f:facet>
		              <h:inputText size="4" value="#{lis.impvEv}" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" maxlength="5" disabled="#{lis.conector eq 'SQ1'}"/>
		              <h:outputLabel value=""/>
		            </h:column>
		            <h:column>
		              <f:facet name="header">
		                <h:outputText value="#{ms.imp_dispositivos_ele_imp_ms }"/>
		              </f:facet>
		              <h:inputText size="4" value="#{lis.impmsEv}" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" maxlength="5" disabled="#{lis.conector eq 'SQ1'}"/>
		              <h:outputLabel value=""/>
		            </h:column>
	          </h:dataTable>
          </h:panelGrid>
		</h:panelGrid>
		<h:panelGrid width="100%" columns="1" id="tablaProg" style="text-align:center" rendered="#{controlImplantes.tipogen ne 6}">
			<h:outputLabel value="#{ms.imp_dispositivos_ele_prog }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%">
				<h:dataTable value="#{controlImplantes.listaelectrodos }" var="lis">
	            <h:column>
	              <f:facet name="header">
	                <h:outputText value="#{ms.imp_dispositivos_ele_tipo_elec }"/>
	              </f:facet>
	              <h:outputText value="AD" rendered="#{lis.camara eq 948 &amp;&amp; lis.estado eq 0}" />
	              <h:outputText value="VD" rendered="#{lis.camara eq 949 &amp;&amp; lis.estado eq 0}"/>
	              <h:outputText value="VI" rendered="#{lis.camara eq 950 &amp;&amp; lis.estado eq 0}"/>
	              <h:outputText value="LEADLESS" rendered="#{lis.camara eq 0 &amp;&amp; lis.estado eq 0}"/>
	              <h:outputText value="#{lis.abordajetexto }" rendered="#{lis.conector eq 'SQ1' and lis.estado eq 0}" />
	            </h:column>
	            <h:column>
	              <f:facet name="header">
	                <h:outputText value="#{ms.imp_dispositivos_ele_prog_sens }"/>
	              </f:facet>
	              <h:inputText size="4" value="#{lis.sensibilidad }" rendered="#{lis.estado eq 0 }" maxlength="5" disabled="#{lis.conector eq 'SQ1'}"/>
	            </h:column>
	            <h:column>
	              <f:facet name="header">
	                <h:outputText value="#{ms.imp_dispositivos_ele_prog_pol_det }"/>
	              </f:facet>
	              <h:selectOneMenu value="#{lis.poldeteccion }" rendered="#{lis.estado eq 0}" disabled="#{lis.vdd eq true and lis.camara eq 948 }" >	
					<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_ele_prog_pol_op1 }" />	
					<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_ele_prog_pol_op0 }" />										
				   </h:selectOneMenu>
	            </h:column>	            
	            <h:column>
	              <f:facet name="header">
	                <h:outputText value="#{ms.imp_dispositivos_ele_prog_volt }"/>
	              </f:facet>
	              <h:inputText size="4" value="#{lis.voltaje }" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" maxlength="5" disabled="#{lis.conector eq 'SQ1'}"/>
	              <h:outputLabel value=""/>
	            </h:column>
	            <h:column>
	              <f:facet name="header">
	                <h:outputText value="#{ms.imp_dispositivos_ele_prog_durimp }" title="#{ms.imp_dispositivos_ele_prog_durimp_title }"/>
	              </f:facet>
	              <h:inputText size="4" value="#{lis.durimpulso }" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" maxlength="4" disabled="#{lis.conector eq 'SQ1'}"/>
	              <h:outputLabel value=""/>
	            </h:column>
	            
	            <h:column>
	              <f:facet name="header">
	                <h:outputText value="#{ms.imp_dispositivos_ele_prog_pol_est }"/>
	              </f:facet>
	              <h:selectOneMenu value="#{lis.polestimulacion }" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" disabled="#{lis.conector eq 'SQ1'}">					
					<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_ele_prog_pol_op1 }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_ele_prog_pol_op0 }" />											
				  </h:selectOneMenu>
				  <h:outputLabel value=""/>
	            </h:column>
	             <h:column>
	              <f:facet name="header">
	                <h:outputText value="#{ms.imp_dispositivos_ele_prog_capt_auto }" />
	              </f:facet>
	              <h:selectOneMenu value="#{lis.capturaauto }" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" disabled="#{lis.conector eq 'SQ1'}">
					<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_ele_prog_capt_auto_op0 }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_ele_prog_capt_auto_op1 }" />											
				  </h:selectOneMenu>
				  <h:outputLabel value=""/>
	            </h:column>
	          </h:dataTable>	
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid columns="3">
		<h:panelGrid id="vectorEstimulacionVIEv">
			<h:dataTable value="#{controlImplantes.listaelectrodos }" var="lis">
				<h:column rendered="#{lis.camara eq 950 &amp;&amp; lis.estado eq 0}">	        
		           <h:outputLabel value="#{ms.imp_dispositivos_ele_prog_vector_est_vi }" style="font-weight: bold;" />
		           <h:panelGrid columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop" 
		           	style="border-top: solid 1px;border-color: black;">
		           		<h:outputText value="#{ms.imp_dispositivos_ele_prog_vector_est_vi_de }" style="font-weight: bold;"/>
						<h:selectOneMenu value="#{lis.vectorvi1 }" >
							<f:selectItems value="#{controlImplantes.vectorinicial}"/>	
							<a4j:support event="onchange" reRender="vectorEstimulacionVIEv" 
								actionListener="#{controlImplantes.cambiaConjunto }"/>									
						</h:selectOneMenu>
						<h:outputText value="#{ms.imp_dispositivos_ele_prog_vector_est_vi_a }" style="font-weight: bold;"/>
						<h:selectOneMenu value="#{lis.vectorvi2 }" >
							<f:selectItems value="#{controlImplantes.vectorfinal}"/>														
						</h:selectOneMenu>							
		           </h:panelGrid>	        
		        </h:column>
			</h:dataTable>
		</h:panelGrid>
		<h:panelGrid rendered="#{controlImplantes.tipogen eq 6}">
			<h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_sicd_vector_det }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.hev.vectorSicd }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_sicd_vector_det_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_sicd_vector_det_op2 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_sicd_vector_det_op3 }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="panImpRespondedor" columns="2"
			rendered="#{(controlImplantes.tipogen eq 3 || controlImplantes.tipogen eq 4)}">
			<h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_respondedor }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.hev.respondedor }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_op2 }" />
						<a4j:support event="onchange" reRender="panImpRespondedor" ajaxSingle="false"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid  rendered="#{controlImplantes.hev.respondedor eq 1}">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_respondedor_tipo }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.hev.tiporespondedor }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_tipo_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_tipo_op2 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_tipo_op3 }" />	
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid columns="2">
		<h:panelGrid columns="2">
			<h:selectBooleanCheckbox value="#{controlImplantes.hev.mpdep }">
				<a4j:support event="onclick" actionListener="#{controlImplantes.mDep}"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_mpdep }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="2" rendered="#{!empty controlImplantes.listagenerador[0].mricomp &amp;&amp; controlImplantes.listagenerador[0].mricomp eq 'Si'}">
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_comp_mri }" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlImplantes.hev.compatiblemri }">
				<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
				<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_comp_mri_op1 }" />
				<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_comp_mri_op2 }" />
				<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_comp_mri_op3 }" />					
			</h:selectOneMenu>
		</h:panelGrid>
	</h:panelGrid>
	<rich:spacer width="20" />
	<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_tab_ev_prog }" opened="false">
		<h:panelGrid width="50%" columns ="2" columnClasses="alignTop,alignTop,alignTop"
			rendered="#{controlImplantes.tipogen ne 6}">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_modo }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_fbasica }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.hev.modogen }">
						<f:selectItems value="#{controlImplantes.modogen}" />					
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputText size="4" value="#{controlImplantes.hev.fbasica }" maxlength="5"/>
				</h:panelGrid>			
		</h:panelGrid>	
		<h:panelGrid columns="2" rendered="#{!empty controlImplantes.listagenerador[0].rf &amp;&amp; controlImplantes.listagenerador[0].rf eq 'Si'}">
			<h:selectBooleanCheckbox value="#{controlImplantes.hev.segrem }">
				<a4j:support event="onclick" actionListener="#{controlImplantes.segRem}"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_segrem }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="2" rendered="#{controlImplantes.tipogen ne 6 and controlImplantes.tipogen ne 5}">
			<h:selectBooleanCheckbox value="#{controlImplantes.hev.minestvent }">
				<a4j:support event="onclick" actionListener="#{controlImplantes.minEstVent}"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_mev }" style="font-weight: bold;" />
		</h:panelGrid>	
		<h:panelGrid rendered="#{controlImplantes.tipogen eq 3 || controlImplantes.tipogen eq 4}" 
			id="estimfren" columns="2">
			<h:selectBooleanCheckbox value="#{controlImplantes.hev.estimfren }">
				<a4j:support event="onclick" reRender="estimfren" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_estim_fren }" style="font-weight: bold;"/>
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_estim_fren_umb }" rendered="#{controlImplantes.hev.estimfren eq true}"/>
			<h:inputText size="4" value="#{controlImplantes.hev.umbralEstimfren }" 
				rendered="#{controlImplantes.hev.estimfren eq true}" maxlength="5"/>			
		</h:panelGrid>
		<rich:panel rendered="#{controlImplantes.tipogen eq 2 || controlImplantes.tipogen eq 4 || controlImplantes.tipogen eq 6}">
				<f:facet name="header">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas }"/>
				</f:facet>
				<h:panelGrid width="100%">
					<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas }" style="font-weight: bold;" />
						<a4j:commandLink reRender="tablaZonasV"
							actionListener="#{controlImplantes.addZona }">
							<h:graphicImage value="/img/iconos/add.png" width="16"
								height="16" style="border:0;" title="#{ms.aniadir }"/>				
						</a4j:commandLink>
						<a4j:commandLink reRender="tablaZonasV"
							actionListener="#{controlImplantes.cargarAvanzadosZona }">
							<h:graphicImage value="/img/iconos/list-view.png" width="16"
								height="16" style="border:0;" title="#{ms.imp_dispositivos_tab_ev_prog_zonas_av }"/>				
						</a4j:commandLink>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
							id="tablaZonasV" width="100%" columnClasses="alignTop,alignTop,alignTop">	
					        <rich:dataGrid value="#{controlImplantes.hev.zonas}" var="zona" columns="6" elements="6"
					        	binding="#{controlImplantes.bindingGrid }" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop,alignTop">
					            <rich:panel bodyClass="pbody">
					                <f:facet name="header">
						               <h:outputText value="#{zona.tipo}"/>
					                </f:facet>
					                <a4j:commandLink reRender="tablaZonasV"
										actionListener="#{controlImplantes.delZona }">
										<h:graphicImage url="/img/iconos/minus.png"
											title="#{ms.eliminar }" width="16" height="16"
											style="border: 0px;" />
									</a4j:commandLink>
					                <h:panelGrid columns="2">
					                    <h:outputText value="#{ms.imp_dispositivos_tab_ev_prog_zonas_fc_ppm }" styleClass="label"/>
					                    <h:outputText value="#{ms.imp_dispositivos_tab_ev_prog_zonas_fc_ms }" styleClass="label"/>
					                    <h:panelGrid style="border-top: solid 1px;border-color: black;">
					                    	<h:inputText value="#{zona.fcPpm}" size="4" maxlength="5">
					                    		<a4j:support event="onchange" reRender="tablaZonasV" ajaxSingle="true"
													actionListener="#{controlImplantes.gestionaZona}"/>
					                    	</h:inputText>
					                    </h:panelGrid>
					                    <h:panelGrid style="border-top: solid 1px;border-color: black;">
					                    	<h:inputText value="#{zona.fcMs}" size="4" maxlength="5">
					                    		<a4j:support event="onchange" reRender="tablaZonasV" ajaxSingle="true"
													actionListener="#{controlImplantes.gestionaZonaMs}"/>
					                    	</h:inputText>
					                    </h:panelGrid>					                    					             					                    
					                </h:panelGrid>
					                <h:panelGrid rendered="#{controlImplantes.tipogen ne 6}">
					                	<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp }"/>
					                	<h:panelGrid columnClasses="alignTop,alignTop,alignTop"
					                		style="border-top: solid 1px;border-color: black;">
											<h:selectOneMenu value="#{zona.numatpini}">
												<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_num_0 }" />
												<f:selectItem itemValue="1" itemLabel="1" />
												<f:selectItem itemValue="2" itemLabel="2" />
												<a4j:support event="onchange" reRender="tablaZonasV,panelAtpAvanzadas" ajaxSingle="true"
													actionListener="#{controlImplantes.cargaATPZona}"/>					
											</h:selectOneMenu>
											<h:panelGrid id="panelAtpAvanzadas" width="30%" columnClasses="alignTop,alignTop,alignTop"
												rendered="#{controlImplantes.avzona eq true}">
										        <f:facet name="header">
										            <h:panelGroup>
										                <h:outputText value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_av }"></h:outputText>
										            </h:panelGroup>
										        </f:facet>							        
										        <h:panelGrid width="80%" rendered="#{!empty zona.atps[0]}">
										        	<rich:panel>
														<f:facet name="header">
															<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp }1" style="font-weight: bold;"/>
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
																<h:inputText value="#{zona.atps[0].numsec}" size="3" maxlength="5"/>
															</h:panelGrid>							
															<h:panelGrid style="border-top: solid 1px;border-color: black;">												
																<h:inputText value="#{zona.atps[0].ciclosec}" size="3" maxlength="5"/>	
															</h:panelGrid>
														</h:panelGrid>
														<h:panelGrid columns="2">
															<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_acop }"/>	
															<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_decr }"/>
															<h:panelGrid style="border-top: solid 1px;border-color: black;">		
																<h:inputText value="#{zona.atps[0].acoplamiento}" size="3" maxlength="5"/>
															</h:panelGrid>
															<h:panelGrid style="border-top: solid 1px;border-color: black;">
																<h:inputText value="#{zona.atps[0].decremento}" size="3" maxlength="5"/>	
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
																<h:inputText value="#{zona.atps[1].numsec}" size="3" maxlength="5"/>
															</h:panelGrid>							
															<h:panelGrid style="border-top: solid 1px;border-color: black;">												
																<h:inputText value="#{zona.atps[1].ciclosec}" size="3" maxlength="5"/>	
															</h:panelGrid>
														</h:panelGrid>
														<h:panelGrid columns="2">
															<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_acop }"/>	
															<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp_decr } " />														
															<h:panelGrid style="border-top: solid 1px;border-color: black;">		
																<h:inputText value="#{zona.atps[1].acoplamiento}" size="3" maxlength="5"/>
															</h:panelGrid>
															<h:panelGrid style="border-top: solid 1px;border-color: black;">
																<h:inputText value="#{zona.atps[1].decremento}" size="3" maxlength="5"/>	
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
											<a4j:support event="onclick" reRender="tablaZonasV" ajaxSingle="true" />
										</h:selectBooleanCheckbox>
					                	<h:panelGrid id="panelchoques" columnClasses="alignTop,alignTop,alignTop"
					                		style="border-top: solid 1px;border-color: black;" rendered="#{zona.choqini eq true}">											
											<h:panelGrid columns="3" rendered="#{!empty zona.chqs[0]}">																					
												<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_choques_ene_ini }"/>
												<h:inputText value="#{zona.chqs[0].energia}" size="4" maxlength="5"/>
											</h:panelGrid>																													
									        <t:dataTable styleClass="hor-minimalist-b" var="ch"
												width="100%" value="#{zona.chqs}" id="tablaZonas"
												binding="#{controlImplantes.bindingChoques }"
												rendered="#{controlImplantes.avzona eq true}">
												<t:column width="30%" headerstyleClass="left">
													<h:panelGrid columns="2">
														<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_choques_energia }"/>
														<h:inputText value="#{ch.energia}" size="4" maxlength="5">
															<a4j:support event="onchange" reRender="panelchoques" ajaxSingle="true"
																actionListener="#{controlImplantes.cambiaEnergiaChoques}"/>						
														</h:inputText>
													</h:panelGrid>													
												</t:column>
												<t:column width="30%" headerstyleClass="left">
													<h:panelGrid>
														<r:inputNumberSlider value="#{ch.numch}" minValue="0" maxValue="8" 
															rendered="#{controlImplantes.avzona eq true}">
														<a4j:support event="onchange" reRender="panelchoques" ajaxSingle="true"
															actionListener="#{controlImplantes.cambiaNumeroChoques }"/>						
														</r:inputNumberSlider>
													</h:panelGrid>
												</t:column>
												<t:column width="30%" headerstyleClass="left">
													<a4j:commandLink reRender="panelchoques"
														actionListener="#{controlImplantes.delChoque }">
														<h:graphicImage url="/img/iconos/minus.png"
															title="#{ms.eliminar }" width="16" height="16"
															style="border: 0px;" />
													</a4j:commandLink>
												</t:column>
											</t:dataTable>
											<a4j:commandLink title="#{ms.aniadir }" value="#{ms.imp_dispositivos_tab_ev_prog_zonas_choques_add }"
												actionListener="#{controlImplantes.addChoque}" reRender="panelchoques" 
												rendered="#{zona.choqini eq true &amp;&amp; controlImplantes.avzona eq true}"/>
										</h:panelGrid>
					                </h:panelGrid>
					            </rich:panel>
					        </rich:dataGrid>      
					</h:panelGrid>
				</h:panelGrid>	
		</rich:panel>		
		<br/>
		<h:panelGrid columns="2" rendered="#{controlImplantes.tipogen eq 3 || controlImplantes.tipogen eq 4}" width="100%"
			columnClasses="alignTop,alignTop,alignTop">
			<rich:panel id="iavCRT">
				<f:facet name="header">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos }"/>
				</f:facet>
				<h:panelGrid columns="2" width="30%">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_det }"
						style="font-weight: bold;"/>		
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_est }"
						style="font-weight: bold;"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText size="4" value="#{controlImplantes.hev.iavdetec }" maxlength="5"/>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText size="4" value="#{controlImplantes.hev.iavestim }" maxlength="5"/>
					</h:panelGrid>
					<rich:spacer width="10" />		
				</h:panelGrid>				
				<rich:spacer height="10"/>
				<h:selectBooleanCheckbox value="#{controlImplantes.hev.iavdinamico }">
					<a4j:support event="onclick" reRender="iavCRT" ajaxSingle="true"/>
			  	</h:selectBooleanCheckbox>
			  	<rich:spacer width="10" />
			  	<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_dinam }"
						style="font-weight: bold;"/>
				<h:panelGrid columns="3" style="border-top: solid 1px;border-color: black;vertical-align:top;"
					rendered="#{controlImplantes.hev.iavdinamico eq true}" columnClasses="alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_max }"
						style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlImplantes.hev.iavmax }" maxlength="5"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_ms }"
						style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_min }"
						style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlImplantes.hev.iavmin }" maxlength="5"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_ms }"
						style="font-weight: bold;"/>
				</h:panelGrid>
				<br/>
				<a4j:jsFunction name="actualizaSecuenciaActivacion" reRender="iavCRT"/>
				<h:panelGrid columns="2">
					<h:panelGrid>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_sec_act }" style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:selectOneMenu value="#{controlImplantes.hev.sactivacion}"
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
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_sec_act_ivv }" 
							rendered="#{controlImplantes.hev.sactivacion eq 2 ||controlImplantes.hev.sactivacion eq 3 ||controlImplantes.hev.sactivacion eq 4 }"
							style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputText size="4" value="#{controlImplantes.hev.ivv}" maxlength="5" 
								rendered="#{controlImplantes.hev.sactivacion eq 2 ||controlImplantes.hev.sactivacion eq 3 ||controlImplantes.hev.sactivacion eq 4 }"/>
						</h:panelGrid>						
					</h:panelGrid>				
				</h:panelGrid>			
				<h:panelGrid columns="2">
					<h:panelGrid>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_opt_inte }" style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:selectOneMenu value="#{controlImplantes.optint }"
								onchange="actualizaSecuenciaActivacion();">
								<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_op0 }" />	
								<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_op3 }" />										
							</h:selectOneMenu>
						</h:panelGrid>						
					</h:panelGrid>
					<h:panelGrid>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_frec }" rendered="#{controlImplantes.optint ne 0 }"
							style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:selectOneMenu value="#{controlImplantes.optint }" 
								rendered="#{controlImplantes.optint ne 0 }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_frec_op1 }" />	
								<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_prog_opt_inte_frec_op2 }" />															
							</h:selectOneMenu>
						</h:panelGrid>						
					</h:panelGrid>				
				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>
	</rich:simpleTogglePanel>
	<rich:spacer width="20" />
	<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_tab_ev_prog_av }" opened="false" >
		<h:panelGrid columns="4" width="80%" columnClasses="alignTop,alignTop,alignTop" id="progavgen"
			rendered="#{controlImplantes.tipogen ne 6}">
			<h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_fmax }" 
					style="font-weight: bold;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputText size="4" value="#{controlImplantes.hev.fmax }" maxlength="5"/>
				</h:panelGrid>			
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_freposo }" 
					style="font-weight: bold;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputText size="4" value="#{controlImplantes.hev.fmin }" maxlength="5"/>
				</h:panelGrid>				
			</h:panelGrid>
			<h:panelGrid columns="2" rendered="#{controlImplantes.tipogen ne 5}">
				<h:selectBooleanCheckbox value="#{controlImplantes.hev.prevfa}">
					<a4j:support event="onclick" reRender="evHisteresis" ajaxSingle="true"
						actionListener="#{controlImplantes.algPrevFA }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_alg_prev_fa }" 
					style="font-weight: bold;"/>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid id="evHisteresis" rendered="#{controlImplantes.tipogen ne 6 }">
			<h:panelGrid columns="3">
				<h:selectBooleanCheckbox value="#{controlImplantes.hev.hist}">
					<a4j:support event="onclick" reRender="evHisteresis" ajaxSingle="true"
						actionListener="#{controlImplantes.cambiaHisteresis }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_histeresis }" 
					style="font-weight: bold;"/>
				<h:inputText size="4" value="#{controlImplantes.hev.valorHisteresis }" maxlength="5"
					rendered="#{controlImplantes.hev.hist eq true}"/>
			</h:panelGrid>							
		</h:panelGrid>
		<h:panelGrid rendered="#{controlImplantes.tipogen eq 1 || controlImplantes.tipogen eq 2}" width="50%"
			columnClasses="alignTop,alignTop,alignTop">
			<rich:panel id="iavMPDAI" rendered="#{controlImplantes.tipogen ne 6 }">
				<f:facet name="header">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos }"/>
				</f:facet>				
				<h:panelGrid columns="2" width="50%">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_det }"
						style="font-weight: bold;"/>		
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_est }"
						style="font-weight: bold;"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText size="4" value="#{controlImplantes.hev.iavdetec }" maxlength="5"/>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText size="4" value="#{controlImplantes.hev.iavestim }" maxlength="5"/>
					</h:panelGrid>
					<rich:spacer width="10" />		
				</h:panelGrid>
				<h:selectBooleanCheckbox value="#{controlImplantes.hev.iavdinamico}">
					<a4j:support event="onclick" reRender="iavMPDAI" ajaxSingle="true"/>
			  	</h:selectBooleanCheckbox>
			  	<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_dinam }"
						style="font-weight: bold;"/>
				<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;vertical-align:top;"
					rendered="#{controlImplantes.hev.iavdinamico eq true}" columnClasses="alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_max }"
						style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlImplantes.hev.iavmax }" maxlength="5"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_intervalos_iav_min }"
						style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlImplantes.hev.iavmin }" maxlength="5"/>
				</h:panelGrid>
			</rich:panel>
		</h:panelGrid>
		<h:panelGrid rendered="#{controlImplantes.tipogen eq 2 || controlImplantes.tipogen eq 4 || controlImplantes.tipogen eq 6}" width="50%"
			columnClasses="alignTop,alignTop,alignTop">
			<rich:panel id="estimulacionpostchoqueDAI" rendered="#{controlImplantes.tipogen eq 2 || controlImplantes.tipogen eq 4 || controlImplantes.tipogen eq 6}">
				<f:facet name="header">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_param_choque }"/>
				</f:facet>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque }" style="font-weight: bold;"/>
				<h:panelGrid columns="4" style="width:50%;border-top: solid 1px;border-color: black;vertical-align:top;"
					columnClasses="alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_ampl }" style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlImplantes.hev.ampPostch }" maxlength="5"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_frec }" style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlImplantes.hev.frecPostch }" maxlength="5"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_durpuls }" style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlImplantes.hev.durpulsoPostch }" maxlength="5"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_duracion }" style="font-weight: bold;"/>
					<h:inputText size="4" value="#{controlImplantes.hev.durPostch }" maxlength="5"/>
				</h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf }" style="font-weight: bold;"/>
				<h:panelGrid columns="2" style="width:50%;border-top: solid 1px;border-color: black;vertical-align:top;"
					columnClasses="alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_est_post_choque_conf_title }" style="font-weight: bold;"/>
					<h:selectOneMenu value="#{controlImplantes.hev.confch }">
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
	<rich:spacer width="20" />
	<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter }" opened="false"
		rendered="#{controlImplantes.tipogen eq 2 || controlImplantes.tipogen eq 4 || controlImplantes.tipogen eq 6}">
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
			<h:panelGrid id="panelEpisodiosTerapias">
				<h:panelGrid columns="4">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi }" style="font-weight: bold;" />
					<h:selectBooleanCheckbox value="#{controlImplantes.hev.episodios }">
						<a4j:support event="onclick" reRender="panelEpisodiosTerapias" ajaxSingle="true"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_total }" rendered="#{controlImplantes.hev.episodios eq true }"/>
					<h:inputText value="#{controlImplantes.hev.numepisodios }" size="3" maxlength="5"
						rendered="#{controlImplantes.hev.episodios eq true }">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapias" 
							actionListener="#{controlImplantes.controlNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>
				</h:panelGrid>
				<h:panelGrid columns="2" rendered="#{controlImplantes.hev.episodios eq true }">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_tsv }"/>
					<h:inputText value="#{controlImplantes.hev.numepitsv }" size="3" maxlength="5">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapias" 
							actionListener="#{controlImplantes.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_tv }"/>
					<h:inputText value="#{controlImplantes.hev.numepitv }" size="3" maxlength="5">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapias" 
							actionListener="#{controlImplantes.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_fv }"/>
					<h:inputText value="#{controlImplantes.hev.numepifv }" size="3" maxlength="5">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapias" 
							actionListener="#{controlImplantes.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>	
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_nsost }"/>
					<h:inputText value="#{controlImplantes.hev.numepinosost }" size="3" maxlength="5">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapias" 
							actionListener="#{controlImplantes.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_nesp }"/>
					<h:inputText value="#{controlImplantes.hev.numepiotros }" size="3" maxlength="5">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapias" 
							actionListener="#{controlImplantes.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>	
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="terapiaEntregadaDAI" >
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_ent }" style="font-weight: bold;" />
					<h:selectBooleanCheckbox value="#{controlImplantes.hev.terapiaentregada }">
						<a4j:support event="onclick" reRender="terapiaEntregadaDAI" ajaxSingle="true"/>
					</h:selectBooleanCheckbox>
				</h:panelGrid>
				<h:panelGrid columns="3" rendered="#{controlImplantes.hev.terapiaentregada eq true }"
		  			columnClasses="alignTop,alignTop,alignTop" width="100%">		
					<h:panelGrid columns="2" rendered="#{controlImplantes.tipogen eq 2 || controlImplantes.tipogen eq 4 }">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp }" style="font-weight: bold;" />
						<h:selectBooleanCheckbox value="#{controlImplantes.hev.teratp}">
							<a4j:support event="onclick" reRender="terapiaEntregadaDAI" ajaxSingle="true"
								actionListener="#{controlImplantes.terapiaAtp}"/>
						</h:selectBooleanCheckbox>
						<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" width="70%" 
							id="terapiaEntregadaATP" rendered="#{controlImplantes.hev.teratp eq true }">
							<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_atp_num }" style="font-weight: bold;"/>
							<h:inputText size="4" value="#{controlImplantes.hev.numteratp}" maxlength="5"/>
							<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_atp_efec }" style="font-weight: bold;" />
							<h:selectBooleanCheckbox value="#{controlImplantes.hev.terapiaefecatp}">
								<a4j:support event="onclick" reRender="terapiaEntregadaDAI" ajaxSingle="true"
									actionListener="#{controlImplantes.terapiaEfectivaATP}"/>
							</h:selectBooleanCheckbox>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_choques }" style="font-weight: bold;" />
						<h:selectBooleanCheckbox value="#{controlImplantes.hev.terchoques}">
							<a4j:support event="onclick" reRender="terapiaEntregadaDAI" ajaxSingle="true"
								actionListener="#{controlImplantes.terapiaChoques}"/>
						</h:selectBooleanCheckbox>
						<h:panelGrid style="border-top: solid 1px;border-color: black;" 
							id="terapiaEntregadaChoques" rendered="#{controlImplantes.hev.terchoques eq true }">
							<h:panelGrid columns="2" width="70%">
								<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_num }" style="font-weight: bold;" />
								<h:inputText size="4" value="#{controlImplantes.hev.numchoque}" maxlength="5"/>
								<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_efec }" style="font-weight: bold;" />
								<h:selectBooleanCheckbox value="#{controlImplantes.hev.terapiaefecchoques}">
									<a4j:support event="onclick" reRender="terapiaEntregadaChoques" ajaxSingle="true"
										actionListener="#{controlImplantes.terapiaEfectivaChoques}"/>
								</h:selectBooleanCheckbox>
							</h:panelGrid>
						</h:panelGrid>	
					</h:panelGrid>
					<h:panelGrid columns="2" id="terapiaTodasApropiadas" columnClasses="alignTop,alignTop">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_apropiadas }" style="font-weight: bold;" />
						<h:selectOneRadio layout="lineDirection" value="#{controlImplantes.hev.todasefec }">
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_apropiadas_op0 }" itemValue="0" />
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_apropiadas_op1 }" itemValue="1"/>
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_apropiadas_op2 }" itemValue="2"/>
							<a4j:support event="onclick" reRender="terapiaTodasApropiadas" ajaxSingle="true"/>
						</h:selectOneRadio>
						<rich:spacer width="20" />
						<h:selectOneMenu value="#{controlImplantes.hev.motivoterapiaapropiada }" 
							rendered="#{controlImplantes.hev.todasefec eq 1}">
							<f:selectItems value="#{controlImplantes.motivosterapianoapropiada}" />	
						</h:selectOneMenu>
					</h:panelGrid>		 
				</h:panelGrid>		
				<rich:panel rendered="#{controlImplantes.hev.terchoques eq true }">
					<f:facet name="header">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_ultimo }"/>
					</f:facet>
					<h:panelGrid columns ="6" columnClasses="alignTop,alignTop,alignTop">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_ultimo_ener }"
							style="font-weight: bold;"/>
						<h:inputText size="4" value="#{controlImplantes.hev.energiachoque}" maxlength="5"/>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_ultimo_tcarga }"
							style="font-weight: bold;"/>
						<h:inputText size="4" value="#{controlImplantes.hev.tcargachoque}" maxlength="5"/>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_ultimo_imp }"
							style="font-weight: bold;"/>
						<h:inputText size="4" value="#{controlImplantes.hev.impchoque}" maxlength="5"/>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:panelGrid>
	</rich:simpleTogglePanel>
	<rich:spacer width="20" />
	<rich:simpleTogglePanel switchType="client" label="#{ms.compli_proc_imp_post_title }" opened="false">
		<h:panelGrid id="complicacionesImplantesEv" width="100%">
			<a4j:include viewId="/ventanas/implantes/complicaciones/complicacionEv.jsp" />
		</h:panelGrid>
	</rich:simpleTogglePanel>
	<rich:simpleTogglePanel switchType="client" label="Complicaciones post operatorio" opened="false" rendered="false">
			<h:panelGrid width="80%">
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_compl }" style="font-weight: bold;" />
					<a4j:commandLink reRender="tablaCompPost"
						actionListener="#{controlImplantes.addComplicacionPost }">
						<h:graphicImage value="/img/iconos/add.png" width="16"
							height="16" style="border:0;" title="#{ms.compl_add }"/>				
					</a4j:commandLink>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					id="tablaCompPost" width="100%">
					<t:dataTable styleClass="hor-minimalist-b" var="lineacomppost"
						width="100%" value="#{controlImplantes.listacomplicacionespost }"
						binding="#{controlImplantes.bindingCompliPost }">
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.compl_tipo }" />
							</f:facet>
							<h:panelGrid columns="2">
								<h:selectOneMenu value="#{lineacomppost.tipocomp }">
									<f:selectItems value="#{controlImplantes.tipocomplicacionpost}" />
									<a4j:support event="onchange" reRender="tablaCompPost" ajaxSingle="true" 
										actionListener="#{controlImplantes.controlCompPostTipo }"/>						
								</h:selectOneMenu>	
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.compl_clase }" />
							</f:facet>
							<h:panelGrid columns="2">								
								<h:selectOneMenu value="#{lineacomppost.idcompl}" rendered="#{lineacomppost.tipocomp eq '975'}">
									<f:selectItems value="#{controlImplantes.lcomppostelect }" />	
									<a4j:support event="onchange" reRender="tablaCompPost" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompPost }"/>					
								</h:selectOneMenu>
								<h:selectOneMenu value="#{lineacomppost.idcompl}" rendered="#{lineacomppost.tipocomp eq '973'}">
									<f:selectItems value="#{controlImplantes.lcomppostarr }" />		
									<a4j:support event="onchange" reRender="tablaCompPost" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompPost }"/>				
								</h:selectOneMenu>
								<h:selectOneMenu value="#{lineacomppost.idcompl}" rendered="#{lineacomppost.tipocomp eq '974'}">
									<f:selectItems value="#{controlImplantes.lcompposttmp }" />	
									<a4j:support event="onchange" reRender="tablaCompPost" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompPost }"/>					
								</h:selectOneMenu>
								<h:selectOneMenu value="#{lineacomppost.idcompl}" rendered="#{lineacomppost.tipocomp eq '976'}">
									<f:selectItems value="#{controlImplantes.lcomppostresp }" />	
									<a4j:support event="onchange" reRender="tablaCompPost" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompPost }"/>					
								</h:selectOneMenu>
								<h:selectOneMenu value="#{lineacomppost.idcompl}" rendered="#{lineacomppost.tipocomp eq '977'}">
									<f:selectItems value="#{controlImplantes.lcomppostmuerte }" />	
									<a4j:support event="onchange" reRender="tablaCompPost" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompPost }"/>					
								</h:selectOneMenu>
								<h:inputText value="#{lineacomppost.otra }" size="15" rendered="#{lineacomppost.tipocomp eq '978'}"/>	
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.compl_actitud }" />
							</f:facet>
							<h:panelGrid columns="2">									
								<h:inputTextarea cols="25" rows="4" value="#{lineacomppost.actitud }"/>
							</h:panelGrid>					
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.compl_resultado }" />
							</f:facet>
							<h:panelGrid columns="2">
								<h:selectOneMenu value="#{lineacomppost.resultado }">
									<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.compl_resultado_pos }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.compl_resultado_neg }" />	
									<f:selectItem itemValue="3" itemLabel="#{ms.compl_resultado_reint }" />												
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column headerstyleClass="left">
							<a4j:commandLink reRender="tablaCompPost"
								actionListener="#{controlImplantes.delComplicacionPost }">
								<h:graphicImage url="/img/iconos/minus.png"
									title="#{ms.compl_del }" width="16" height="16"
									style="border: 0px;" />
							</a4j:commandLink>
						</t:column>
					</t:dataTable>
				</h:panelGrid>
			</h:panelGrid>
	</rich:simpleTogglePanel>
	<rich:spacer width="20" />
	<rich:simpleTogglePanel switchType="ajax" label="#{ms.imp_dispositivos_tab_ev_med }" opened="false" 
		reRender="medicacionImplantes">
		<h:panelGrid id="medicacionImplantes" width="80%">
			<a4j:include viewId="/ventanas/implantes/medicacion/medicacion.jsp" />
		</h:panelGrid>
	</rich:simpleTogglePanel>
	<rich:spacer width="20" />
	<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_tab_ev_alta }" opened="false">
		<h:panelGrid width="100%">
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_alta }" style="font-weight: bold;" />
			<h:panelGrid columns="4" width="100%"
				style="border-top: solid 1px;border-color: black;"
				columnClasses="alignTop33,alignTop33,alignTop33">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_alta_fecha }"/>
				<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
					showWeeksBar="false" direction="bottom-left"
					value="#{controlImplantes.hev.fechaalta }" />
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_alta_med_resp }"/>	
				<h:inputText size="14" value="#{controlImplantes.hev.medicoalta }" maxlength="45"/>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_alta_motivo }"/>
				<h:selectOneMenu value="#{controlImplantes.hev.motivoalta }">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_motivo_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_motivo_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_motivo_op3 }" />	
					<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_motivo_op4 }" />
					<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_motivo_op5 }" />	
					<f:selectItem itemValue="6" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_motivo_op6 }" />							
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_alta_tipo }"/>
				<h:selectOneMenu value="#{controlImplantes.hev.tipoalta }">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_tipo_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_tipo_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_tipo_op3 }" />	
					<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_tipo_op4 }" />
					<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_tipo_op5 }" />	
					<f:selectItem itemValue="6" itemLabel="#{ms.imp_dispositivos_tab_ev_alta_tipo_op6 }" />							
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</rich:simpleTogglePanel>
	<rich:spacer width="20" />
	<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_tab_ev_com_rec }" opened="false">
		<h:panelGrid>
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_recomendaciones }"/>
			<h:inputTextarea cols="200" rows="11" value="#{controlImplantes.hev.recomendaciones }" id="recomendacionesEvolucion"/>				
		</h:panelGrid>
		<h:panelGrid>
			<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_comentarios }"/>
			<h:inputTextarea cols="200" rows="8" value="#{controlImplantes.hev.comentarios }" id="comentariosEvolucion">
				<f:validateLength maximum="2000" />
			</h:inputTextarea>	
			<h:message for="comentariosEvolucion" style="color:red" />				
		</h:panelGrid>
	</rich:simpleTogglePanel>
	</h:panelGrid>
	
</ui:composition>
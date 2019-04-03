<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:jsflot="http://www.jsflot.org/taglib/jsflot"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid width="100%">
		<h:panelGrid cellpadding="0" cellspacing="0">
			<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_gen }"
				style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaGenSeg" width="85%">
			<t:dataTable styleClass="hor-minimalist-b" var="lineagenseg"
				width="100%" value="#{controlSeguimientos.listagenerador }"
				binding="#{controlSeguimientos.bindingGen }">
				<t:column width="30%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_gen_modelo }" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:selectOneMenu value="#{lineagenseg.modelo}" disabled="true">
							<f:selectItems value="#{controlSeguimientos.generadores}" />															
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column width="30%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_gen_fab }" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{lineagenseg.fabricante}"/>
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_gen_tipo }" />
					</f:facet>
					<h:panelGrid columns="2">								
						<h:outputText value="#{lineagenseg.modo }" />	
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_gen_numserie }" />
					</f:facet>
					<h:outputText value="#{lineagenseg.numserie }" />					
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_gen_loc }" />
					</f:facet>
					<h:panelGrid columns="2">
						<h:selectOneMenu value="#{lineagenseg.localizacion }" disabled="true" rendered="#{controlSeguimientos.tipogen ne 5 }">
							<f:selectItems value="#{controlSeguimientos.localizaciongen }" />						
						</h:selectOneMenu>
						<h:selectOneMenu value="#{lineagenseg.localizacion }" disabled="true" rendered="#{controlSeguimientos.tipogen eq 5 }">
							<f:selectItems value="#{controlSeguimientos.zonacamaravd}"/>
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_gen_rf }" />
					</f:facet>
					<h:outputLabel value="#{lineagenseg.rf }" />					
				</t:column>
				<t:column width="90%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_gen_mri }" />
					</f:facet>
					<h:outputLabel value="#{lineagenseg.mricomp }" />					
				</t:column>
				<t:column width="90%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_gen_fimp }" />
					</f:facet>
					<h:outputLabel value="#{lineagenseg.fechaimplante }">
						<f:convertDateTime pattern="dd.MM.yyyy" timeZone="CET"/>
					</h:outputLabel>					
				</t:column>
			</t:dataTable>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid width="75%" rendered="#{controlSeguimientos.tipogen ne 5 }">
		<h:panelGrid cellpadding="0" cellspacing="0">
			<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_ele }"
				style="font-weight: bold;" />									
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaCatSeg" width="100%">
			<t:dataTable styleClass="hor-minimalist-b" var="lineaelectrodosseg"
				width="100%" value="#{controlSeguimientos.listaelectrodosseg }"
				binding="#{controlSeguimientos.bindingElec }">
				<t:column width="30%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_camara }" />
					</f:facet>
					<h:panelGrid rendered="#{!(lineaelectrodosseg.vdd eq true and lineaelectrodosseg.camara eq 948)}">
						<h:outputText value="AD" rendered="#{lineaelectrodosseg.camara eq 948}" title="#{lineaelectrodosseg.abordajetexto }"/>
	             		<h:outputText value="VD" rendered="#{lineaelectrodosseg.camara eq 949}" title="#{lineaelectrodosseg.abordajetexto }"/>
	              		<h:outputText value="VI" rendered="#{lineaelectrodosseg.camara eq 950}" title="#{lineaelectrodosseg.abordajetexto }"/>
	              		<h:outputText value="#{lineaelectrodosseg.abordajetexto }" rendered="#{lineaelectrodosseg.conector eq 'SQ1'}" />
					</h:panelGrid>	
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_fab }"/>
					</f:facet>
					<h:panelGrid columns="2" rendered="#{!(lineaelectrodosseg.vdd eq true and lineaelectrodosseg.camara eq 948)}">
						<h:outputLabel value="#{lineaelectrodosseg.fabricante }"/>
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_modelo }" />
					</f:facet>
					<h:panelGrid columns="2" rendered="#{!(lineaelectrodosseg.vdd eq true and lineaelectrodosseg.camara eq 948)}">
						<h:selectOneMenu value="#{lineaelectrodosseg.nombremodelo }" disabled="true">
							<f:selectItems value="#{controlSeguimientos.electrodos }" />																
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_conector }"/>
					</f:facet>
					<h:panelGrid columns="2" rendered="#{!(lineaelectrodosseg.vdd eq true and lineaelectrodosseg.camara eq 948)}">
						<h:outputLabel value="#{lineaelectrodosseg.conector }"/>
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_numserie }" />
					</f:facet>
					<h:panelGrid columns="2" rendered="#{!(lineaelectrodosseg.vdd eq true and lineaelectrodosseg.camara eq 948)}">
						<h:outputLabel value="#{lineaelectrodosseg.numserie }"/>
					</h:panelGrid>
				</t:column>	
				<t:column width="40%" headerstyleClass="left">
					<f:facet name="header">
						<h:outputText value="#{ms.imp_dispositivos_ele_fimp }" />
					</f:facet>
					<h:panelGrid columns="2" rendered="#{!(lineaelectrodosseg.vdd eq true and lineaelectrodosseg.camara eq 948)}">							
						<h:outputLabel value="#{lineaelectrodosseg.fechaimplante }">
							<f:convertDateTime pattern="dd.MM.yyyy" timeZone="CET"/>
						</h:outputLabel>						
					</h:panelGrid>		
				</t:column>
				<t:column width="20%" headerstyleClass="left" rendered="#{lineaelectrodosseg.estado ne 0 }">				
					<h:panelGrid columns="3">
						<h:outputLabel value="#{ms.imp_dispositivos_ele_estado }" />
						<h:panelGrid>
							<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_1 }" style="font-weight: bold;"
								rendered="#{lineaelectrodosseg.estado eq 1}"/>
							<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_2 }" style="font-weight: bold;"
								rendered="#{lineaelectrodosseg.estado eq 2}"/>
							<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_3 }" style="font-weight: bold;"
								rendered="#{lineaelectrodosseg.estado eq 3}"/>
						</h:panelGrid>	
						<h:panelGrid>
							<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_caracter_1 }" style="font-weight: bold;"
								rendered="#{lineaelectrodosseg.caracter eq 1}"/>
							<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_caracter_2 }" style="font-weight: bold;"
								rendered="#{lineaelectrodosseg.caracter eq 2}"/>
						</h:panelGrid>
					</h:panelGrid>
				</t:column>
				<t:column width="20%" headerstyleClass="left" rendered="false">
					<h:panelGrid columns="2" rendered="#{lineaelectrodosseg.estado eq 0 }">
						<h:outputLabel value="#{ms.imp_dispositivos_ele_estim_fren_title }"/>
						<h:selectBooleanCheckbox value="#{lineaelectrodosseg.estimfrenok }">
							<a4j:support event="onclick" reRender="tablaCatSeg" ajaxSingle="true"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.imp_dispositivos_ele_estim_fren_umb }" rendered="#{lineaelectrodosseg.estimfrenok eq true}"/>
						<h:inputText size="4" value="#{lineaelectrodosseg.estimfren}" rendered="#{lineaelectrodosseg.estimfrenok eq true}"/>							
					</h:panelGrid>		
				</t:column>
			</t:dataTable>
		</h:panelGrid>
	</h:panelGrid>	
	<h:panelGrid width="100%" columns ="2" columnClasses="alignTop,alignTop" rendered="#{controlSeguimientos.tipogen ne 6 }">
		<h:panelGrid width="100%" columns="1" id="tablaUmbSeg" style="text-align:center">
			<h:panelGrid columns="2" columnClasses="center,alignLeft">
				<h:outputLabel value="#{ms.imp_dispositivos_ele_medidas_sondas }" style="font-weight: bold;" />
				<a4j:commandLink reRender="estElectrodos,estElectrodos2" actionListener="#{controlSeguimientos.generarEstadisticasElectrodos }" 
					onclick="javascript:Richfaces.showModalPanel('buscando');" rendered="false"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage url="/img/iconos/ParameterReview.png" title="Generar estadisticas" width="24" height="24" style="border: 0px;"/>
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%">
				<h:dataTable value="#{controlSeguimientos.listaelectrodosseg }" var="lis">
		            <h:column>
		              <f:facet name="header">
		                <h:outputText value="#{ms.imp_dispositivos_ele_tipo_elec }"/>
		              </f:facet>
		              <h:outputText value="AD" rendered="#{lis.camara eq 948 &amp;&amp; lis.estado eq 0}" />
		              <h:outputText value="VD" rendered="#{lis.camara eq 949 &amp;&amp; lis.estado eq 0}"/>
		              <h:outputText value="VI" rendered="#{lis.camara eq 950 &amp;&amp; lis.estado eq 0}"/>
		              <h:outputText value="LEADLESS" rendered="#{lis.camara eq 0 and lis.estado eq 0}"/>
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
		              <h:outputLabel value=""/>
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
		            <h:column rendered="#{controlSeguimientos.hayVI eq true}">
		              <f:facet name="header">
		                <h:outputText value="#{ms.imp_dispositivos_ele_estim_fren_umb_1 }" />
		              </f:facet>
		              <h:inputText size="4" value="#{lis.estimfren}" rendered="#{lis.estado eq 0 &amp;&amp; lis.camara eq 950}" maxlength="5"/>
		            </h:column>
	          </h:dataTable>
          </h:panelGrid>
		</h:panelGrid>
		<h:panelGrid width="100%" columns="1" id="tablaProg" style="text-align:center">		
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.imp_dispositivos_ele_prog }"
					style="font-weight: bold;" />
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="100%">
				<h:dataTable value="#{controlSeguimientos.listaelectrodosseg }" var="lis">
	            <h:column rendered="false">
	              <f:facet name="header">
	                <h:outputText value="#{ms.imp_dispositivos_ele_tipo_elec }"/>
	              </f:facet>
	              <h:outputText value="AD" rendered="#{lis.camara eq 948 &amp;&amp; lis.estado eq 0}" />
	              <h:outputText value="VD" rendered="#{lis.camara eq 949 &amp;&amp; lis.estado eq 0}"/>
	              <h:outputText value="VI" rendered="#{lis.camara eq 950 &amp;&amp; lis.estado eq 0}"/>
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
	              <h:selectOneMenu value="#{lis.poldeteccion }" rendered="#{lis.estado eq 0 }" disabled="#{lis.vdd eq true and lis.camara eq 948 }">
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
	            <h:column >
	              <f:facet name="header">
	                <h:outputText value="#{ms.imp_dispositivos_ele_prog_durimp }" title="#{ms.imp_dispositivos_ele_prog_durimp_title }"/>
	              </f:facet>
	              <h:inputText size="4" value="#{lis.durimpulso }" rendered="#{lis.estado eq 0 and (!(lis.vdd eq true and lis.camara eq 948))}" maxlength="5" disabled="#{lis.conector eq 'SQ1'}"/>
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
	
	<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid id="vectorEstimulacionVISeg">
			<h:dataTable value="#{controlSeguimientos.listaelectrodosseg }" var="lis">
				<h:column rendered="#{lis.camara eq 950 and lis.estado eq 0}">	        
		           <h:outputLabel value="#{ms.imp_dispositivos_ele_prog_vector_est_vi }" style="font-weight: bold;"/>
		           <h:panelGrid columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop" style="border-top: solid 1px;border-color: black;">
		           		<h:outputText value="#{ms.imp_dispositivos_ele_prog_vector_est_vi_de }" style="font-weight: bold;"/>
						<h:selectOneMenu value="#{lis.vectorvi1 }">
							<f:selectItems value="#{controlSeguimientos.vectorinicial}"/>	
							<a4j:support event="onchange" reRender="vectorEstimulacionVISeg"/>									
						</h:selectOneMenu>
						<h:outputText value="#{ms.imp_dispositivos_ele_prog_vector_est_vi_a }" style="font-weight: bold;"/>
						<h:selectOneMenu value="#{lis.vectorvi2 }">
							<f:selectItems value="#{controlSeguimientos.vectorfinal}"/>														
						</h:selectOneMenu>							
		           </h:panelGrid>	        
		        </h:column>
			</h:dataTable>
		</h:panelGrid>
		<h:panelGrid rendered="#{controlSeguimientos.tipogen eq 6}">
			<h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_sicd_vector_det }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlSeguimientos.hev.vectorSicd }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_sicd_vector_det_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_sicd_vector_det_op2 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_sicd_vector_det_op3 }" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	
	
	<h:panelGrid columns="2" columnClasses="alignTop, alignTop">
		<h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputText value="#{ms.seg_disp_tab_datos_sistema_bat }" style="font-weight: bold;" />
				<a4j:commandLink reRender="estBateria" actionListener="#{controlSeguimientos.generarEstadisticasBateria }"
					onclick="javascript:Richfaces.showModalPanel('buscando');" rendered="false"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage url="/img/iconos/ParameterReview.png" title="#{ms.generar_estadisticas }" 
						width="24" height="24" style="border: 0px;"/>
				</a4j:commandLink>
			</h:panelGrid>		
			<h:panelGrid id="panelBateria" columnClasses="alignTop"
				style="border-top: solid 1px;border-color: black;">
				<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
					<h:panelGrid columns="3" rendered="#{controlSeguimientos.tipogen ne 6 }">
						<h:outputText value="#{ms.seg_disp_tab_datos_sistema_bat_volt }"/>				
						<h:outputText value="#{ms.seg_disp_tab_datos_sistema_bat_imp }"/>				
						<h:outputText value="#{ms.seg_disp_tab_datos_sistema_bat_fmag }"/>				
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputText value="#{controlSeguimientos.sist.voltaje }" size="5" maxlength="5"/>
						</h:panelGrid>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputText value="#{controlSeguimientos.sist.impedancia}" size="5" maxlength="5"/>
						</h:panelGrid>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputText value="#{controlSeguimientos.sist.fmagnetica }" size="5" maxlength="5"/>
						</h:panelGrid>
						
					</h:panelGrid>				
					<h:panelGrid columns="2" rendered="#{controlSeguimientos.tipogen eq 2||controlSeguimientos.tipogen eq 4}">
						<t:fieldset legend="#{ms.seg_disp_tab_datos_sistema_bat_ultchoq }">
							<h:panelGrid columns="4">
								<h:outputLabel value="#{ms.seg_disp_tab_datos_sistema_bat_ultchoq_fecha }" />	
								<h:outputLabel value="#{ms.seg_disp_tab_datos_sistema_bat_ultchoq_energ }"/>
								<h:outputLabel value="#{ms.seg_disp_tab_datos_sistema_bat_ultchoq_tcarga }"/>					
								<h:outputLabel value="#{ms.seg_disp_tab_datos_sistema_bat_ultchoq_imp }"/>
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
										showWeeksBar="false" direction="bottom-left"
										value="#{controlSeguimientos.sist.ultchqfecha}" />
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:inputText value="#{controlSeguimientos.sist.ultchqenergia }" size="3" maxlength="5"/>
								</h:panelGrid>																	
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:inputText value="#{controlSeguimientos.sist.ultchqtcarga }" size="3" maxlength="5"/>
								</h:panelGrid>
								<h:panelGrid style="border-top: solid 1px;border-color: black;">
									<h:inputText value="#{controlSeguimientos.sist.ultchqimpedancia }" size="3" maxlength="5"/>
								</h:panelGrid>
							</h:panelGrid>					
						</t:fieldset>				
					</h:panelGrid>
					<h:panelGrid>
						<h:outputLabel value="#{ms.seg_disp_tab_datos_sistema_bat_tvida }" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputText value="#{controlSeguimientos.sist.tiempoeri }" size="30"/>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid columns="2" id="panEOLERI">
						<h:selectOneRadio layout="pageLine" value="#{controlSeguimientos.sist.auxeoleri }">
							<f:selectItem itemValue="1" itemLabel="#{ms.seg_disp_tab_datos_sistema_bat_eos }" title="#{ms.seg_disp_tab_datos_sistema_bat_eos_title }"/>
							<f:selectItem itemValue="2" itemLabel="#{ms.seg_disp_tab_datos_sistema_bat_rrt }" title="#{ms.seg_disp_tab_datos_sistema_bat_rrt_title }"/>
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlSeguimientos.cambiaEOLERI }"/>
						</h:selectOneRadio>
						<a4j:commandLink reRender="panEOLERI"
							actionListener="#{controlSeguimientos.delEOLERI }">
							<h:graphicImage url="/img/iconos/limpia.png"
								title="#{ms.borrar_sel }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</h:panelGrid>
				</h:panelGrid>			
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
			<h:panelGrid>
				<h:outputLabel value="#{ms.seg_disp_tab_datos_sistema_med }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlSeguimientos.seg.operador}">
						<f:selectItems value="#{controlSeguimientos.primerop}" />										
					</h:selectOneMenu>
				</h:panelGrid>
				<h:outputLabel value="#{ms.seg_disp_tab_datos_sistema_enf }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlSeguimientos.seg.operadorenf}">
						<f:selectItems value="#{controlSeguimientos.enfop}" />										
					</h:selectOneMenu>
				</h:panelGrid>			
			</h:panelGrid>
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
				<h:panelGrid>
					<h:panelGrid id="panSegRespondedor"
						rendered="#{controlSeguimientos.tipogen eq 3 ||controlSeguimientos.tipogen eq 4}">
						<h:panelGrid>
							<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_respondedor }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlSeguimientos.hev.respondedor }">
									<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_op1 }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_op2 }" />
									<a4j:support event="onchange" reRender="panSegRespondedor" ajaxSingle="false"/>
								</h:selectOneMenu>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid  rendered="#{controlSeguimientos.hev.respondedor eq 1}">
							<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_respondedor_tipo }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlSeguimientos.hev.tiporespondedor }">
									<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_tipo_op1 }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_tipo_op2 }" />
									<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_ev_respondedor_tipo_op3 }" />	
								</h:selectOneMenu>
							</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlSeguimientos.hev.mpdep }">
							<a4j:support event="onclick" actionListener="#{controlSeguimientos.mDep}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_mpdep }" style="font-weight: bold;" />
					</h:panelGrid>
				</h:panelGrid>
				
			</h:panelGrid>		
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid rendered="#{controlSeguimientos.tipogen ne 6 }">
		<h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.seg_disp_tab_datos_sistema_graficas }" style="font-weight: bold;" />
				<a4j:commandLink reRender="estElectrodos" actionListener="#{controlSeguimientos.mostrarEstadisticas }" 
					onclick="javascript:Richfaces.showModalPanel('buscando');" 
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage url="/img/iconos/ParameterReview.png" title="Mostrar/Ocultar más estadisticas" width="24" height="24" style="border: 0px;"/>
				</a4j:commandLink>
			</h:panelGrid>		
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:panelGrid columns="3" columnClasses="alignTop,alignTop,alignTop">
					<jsflot:flotChart id="chartElecOndaRP"
						value="#{controlSeguimientos.chartDataElecOndaRP}"
						chartDraggable="true"
						chartClickable="true"
						reRender="clickedPanel"
						showLines="true"
						fillLines="false"
						showDataPoints="true"
						height="250"
						width="350"
						chartType="line"
						showTooltip="true"
						tooltipFollowMouse="true"
						title="Onda R/P (mV)"
						subtitle="Electrodos. Medidas de las sondas"
						mode="Time"
						timeFormat="%d/%m/%y"
						yaxisTitle="mV"
						xaxisTitle="Fecha de Seguimiento"
						yaxisMinValue="0"						        
						markers="true"
						showXaxisLabels="true"
						showYaxisLabels="true">
					</jsflot:flotChart>
					<jsflot:flotChart id="chartElecUmbV" 
						value="#{controlSeguimientos.chartDataElecUmbralV}" 
						chartDraggable="true" chartClickable="true" 
						reRender="clickedPanel" 
						showLines="true" fillLines="false" 
						showDataPoints="true" 
						height="250" width="350" 
						chartType="line" 
						showTooltip="true" 
						tooltipFollowMouse="true" 
						title="Umbral (V)" subtitle="Electrodos. Medidas de las sondas" 
						mode="Time" timeFormat="%d/%m/%y" 
						yaxisTitle="V" xaxisTitle="Fecha de Seguimiento" 
						yaxisMinValue="0" 
						markers="true" 
						showXaxisLabels="true" showYaxisLabels="true">
					</jsflot:flotChart>
					<jsflot:flotChart id="chartElecImp" 
						value="#{controlSeguimientos.chartDataElecImpedancia}" 
						chartDraggable="true" 
						chartClickable="true" 
						reRender="clickedPanel" 
						showLines="true" fillLines="false" 
						showDataPoints="true" 
						height="250" width="350" 
						chartType="line" 
						showTooltip="true" tooltipFollowMouse="true" 
						title="Impedancia (Ohm)" subtitle="Electrodos. Medidas de las sondas" 
						mode="Time" timeFormat="%d/%m/%y" 
						yaxisTitle="Ohm" xaxisTitle="Fecha de Seguimiento" 
						yaxisMinValue="0" 
						markers="true" 
						showXaxisLabels="true" showYaxisLabels="true">
					</jsflot:flotChart>				
				</h:panelGrid>	
				<h:panelGrid id="estElectrodos">
					<h:panelGrid columns="3" columnClasses="alignTop,alignTop,alignTop"
						rendered="#{controlSeguimientos.adicionales eq true }">
						<h:panelGrid>
							<jsflot:flotChart 
								id="chartElecDurImp" 
								value="#{controlSeguimientos.chartDataElecDurImp}" 
								chartDraggable="true" 
								chartClickable="true" 
								reRender="clickedPanel" 
								showLines="true" 
								fillLines="false" 
								showDataPoints="true" 
								height="250" 
								width="350" 
								chartType="line" 
								showTooltip="true" 
								tooltipFollowMouse="true" 
								title="Duracion impulso" 
								subtitle="Electrodos. Programacion" 
								mode="Time" 
								timeFormat="%d/%m/%y" 
								yaxisTitle="ms" 
								xaxisTitle="Fecha de Seguimiento" 
								yaxisMinValue="0" 
								markers="true" 
								showXaxisLabels="true" 
								showYaxisLabels="true">
							</jsflot:flotChart>
						</h:panelGrid>
						<h:panelGrid>
							<jsflot:flotChart id="chartElecAmpl" 
								value="#{controlSeguimientos.chartDataElecAmpl}" 
								chartDraggable="true" 
								chartClickable="true" 
								reRender="clickedPanel" 
								showLines="true" 
								fillLines="false" 
								showDataPoints="true" 
								height="250" 
								width="350" 
								chartType="line" 
								showTooltip="true" 
								tooltipFollowMouse="true" 
								title="Amplitud (V)" 
								subtitle="Electrodos. Programacion" 
								mode="Time" 
								timeFormat="%d/%m/%y" 
								yaxisTitle="V" 
								xaxisTitle="Fecha de Seguimiento" 
								yaxisMinValue="0" 
								markers="true" 
								showXaxisLabels="true" 
								showYaxisLabels="true">
							</jsflot:flotChart>
						</h:panelGrid>
						<h:panelGrid>
							<jsflot:flotChart id="chartElecSens" 
								value="#{controlSeguimientos.chartDataElecSens}" 
								chartDraggable="true" 
								chartClickable="true" 
								reRender="clickedPanel" 
								showLines="true" 
								fillLines="false" 
								showDataPoints="true" 
								height="250" 
								width="350" 
								chartType="line" 
								showTooltip="true" 
								tooltipFollowMouse="true" 
								title="Sensibilidad" 
								subtitle="Electrodos. Programacion" 
								mode="Time" 
								timeFormat="%d/%m/%y" 
								yaxisTitle="mV" 
								xaxisTitle="Fecha de Seguimiento" 
								yaxisMinValue="0" 
								markers="true" 
								showXaxisLabels="true" 
								showYaxisLabels="true">
							</jsflot:flotChart>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
					<jsflot:flotChart id="chartBateriaVSeg"
						value="#{controlSeguimientos.chartDataBatV}"
						chartDraggable="true"
						chartClickable="true"
						reRender="clickedPanel"
						showLines="true"
						fillLines="true"
						showDataPoints="true"
						height="250"
						width="450"
						chartType="line"
						showTooltip="true"
						tooltipFollowMouse="true"
						title="Evolucion Voltaje"
						subtitle="Bateria"
						mode="Time"
						timeFormat="%d/%m/%y"
						yaxisTitle="V"
						xaxisTitle="Fecha de Seguimiento"
						yaxisMinValue="0"
						yaxisMaxValue="3.9"						        
						markers="true"
						showXaxisLabels="true"
						showYaxisLabels="true">
					</jsflot:flotChart>
					<jsflot:flotChart id="chartBateriaImpSeg"
						value="#{controlSeguimientos.chartDataBatImp}"
						chartDraggable="true"
						chartClickable="true"
						reRender="clickedPanel"
						showLines="true"
						fillLines="true"
						showDataPoints="true"
						height="250"
						width="450"
						chartType="line"
						showTooltip="true"
						tooltipFollowMouse="true"
						title="Evolucion Impedancia"
						subtitle="Bateria"
						mode="Time"
						timeFormat="%d/%m/%y"
						yaxisTitle="Ohm"
						xaxisTitle="Fecha de Seguimiento"
						yaxisMinValue="0"			   	        							        
						markers="true"
						showXaxisLabels="true"
						showYaxisLabels="true">
					</jsflot:flotChart>
				</h:panelGrid>
			</h:panelGrid>			
		</h:panelGrid>
	</h:panelGrid>
	
</ui:composition>
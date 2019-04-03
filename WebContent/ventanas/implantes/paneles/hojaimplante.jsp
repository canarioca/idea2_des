<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">
	
	<h:panelGrid width="100%" id="hojaimplante">
		<a4j:jsFunction name="actualizaGenerador" reRender="tablaGen"/>			
		<a4j:jsFunction name="actualizaLocalizacionGenerador" reRender="tablaGen,recolocacionGen">
			<a4j:actionparam name="param1" assignTo="#{controlImplantes.recolocacionGen}"  /> 
		</a4j:jsFunction>
		<h:panelGrid id="impIntervencionPrevia" rendered="#{controlImplantes.intprevia eq true }">
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_int_prev }" style="font-weight: bold;" />
				<h:selectBooleanCheckbox value="#{controlImplantes.impl.interprev }">
	   				<a4j:support event="onclick" reRender="impIntervencionPrevia,tablaElectrodos,panicoimp" ajaxSingle="true"
	   					actionListener="#{controlImplantes.cambiaIntervencionPrevia }"/>
	  			</h:selectBooleanCheckbox>
  			</h:panelGrid>
		</h:panelGrid>
		<h:inputHidden id="aux"/>
		<h:panelGrid width="100%">
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_gen }"
					style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaGen,panelMotivosGen"
					actionListener="#{controlImplantes.addGenerador }"
					focus="inicio:panelHojaImplante:dataTableGenerador:#{controlImplantes.bindingGen.rows}:hiddenGenerador">	
					<h:graphicImage value="/img/iconos/add.png" width="16"
						height="16" style="border:0;" title="#{ms.aniadir }"/>				
				</a4j:commandLink>			
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
					id="tablaGen" width="100%">
				<t:dataTable styleClass="hor-minimalist-b" var="lineagen"
					width="100%" value="#{controlImplantes.listagenerador }"
					binding="#{controlImplantes.bindingGen }" id="dataTableGenerador" rowIndexVar="rib">
					<t:column width="30%" headerstyleClass="left">
						<f:facet name="header">
							<h:panelGrid columns="3">
								<h:outputText value="#{ms.imp_dispositivos_gen_modelo }" />
								<a4j:commandLink reRender="tablaGen"
									actionListener="#{controlImplantes.cargarModelosGenerador }">
									<h:graphicImage value="/img/iconos/list-view.png" width="16"
										height="16" style="border:0;" title="#{ms.imp_dispositivos_gen_modelo_lista }"/>		
								</a4j:commandLink>
								<a4j:commandLink reRender="tablaGen" 
									onclick="javascript:Richfaces.showModalPanel('insertarGeneradorHimp');">
									<h:graphicImage value="/img/iconos/add_2.png" width="16"
										height="16" style="border:0;" title="#{ms.imp_dispositivos_gen_modelo_no_lista }"/>				
								</a4j:commandLink>
							</h:panelGrid>
						</f:facet>
						<h:panelGrid>
							<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_lectura_cod_barras_msg }" rendered="#{lineagen.muestrabarcode eq true }"/>
							<h:inputText id="hiddenGenerador" value="#{lineagen.barcode }" rendered="#{lineagen.muestrabarcode eq true }">
								<a4j:support event="onchange" reRender="tablaGen,hojaimplante,evolucion,tablaUmb,tablaProg,testinduccionimplante,opcionNuevoGeneradorHimp,panelMaterialEditarGeneradorImp" ajaxSingle="true"
					 				actionListener="#{controlImplantes.lecturaCodigoBarrasGenerador}"							
									focus="inicio:panelHojaImplante:dataTableGenerador:#{rib}:NumSer"
									oncomplete="document.getElementById('inicio:panelHojaImplante:dataTableGenerador:#{rib}:NumSer').focus();"/>
							</h:inputText>
							<h:outputLabel value="#{lineagen.nombremodelo}" />
							
							<h:panelGrid rendered="false">
								<h:selectOneMenu value="#{lineagen.modelo}">
									<f:selectItems value="#{controlImplantes.generadores }" />					
									<a4j:support event="onchange" reRender="tablaGen,hojaimplante,evolucion" ajaxSingle="true"
										actionListener="#{controlImplantes.cambiaModeloGen }"/>					
								</h:selectOneMenu>	
							</h:panelGrid>
							<h:panelGrid columns="2" rendered="#{controlImplantes.modgen eq true}">
								<r:comboBox enableManualInput="true" defaultLabel="#{ms.imp_dispositivos_tab_himp_lectura_manual }" width="220"
									value="#{lineagen.nombremodelo}" rendered="#{controlImplantes.impl.idimplante ne null }">
									<f:selectItems value="#{controlImplantes.generadores2 }"/>
									<a4j:support event="onchange" reRender="tablaGen,hojaimplante,evolucion,tablaUmb,tablaProg,testinduccionimplante" ajaxSingle="true"
										actionListener="#{controlImplantes.cambiaModeloGen2 }"/>
								</r:comboBox>
								<r:comboBox enableManualInput="true" defaultLabel="#{ms.imp_dispositivos_tab_himp_lectura_manual }" width="220"
									value="#{lineagen.nombremodelo}" rendered="#{controlImplantes.impl.idimplante eq null }">
									<f:selectItems value="#{controlImplantes.generadores }"/>
									<a4j:support event="onchange" reRender="tablaGen,hojaimplante,evolucion,tablaUmb,tablaProg,testinduccionimplante" ajaxSingle="true"
										actionListener="#{controlImplantes.cambiaModeloGen2 }"/>
								</r:comboBox>
							</h:panelGrid>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_gen_fab }" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="alignTop">								
							<h:outputLabel value="#{lineagen.fabricante }"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_gen_tipo }" />
						</f:facet>
						<h:panelGrid columns="2" columnClasses="alignTop">								
							<h:outputLabel value="#{lineagen.modo }"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_gen_numserie }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop,alignTop" columns="2">
							<h:inputText id="NumSer" size="30" value="#{lineagen.numserie }" maxlength="45">
								<a4j:support event="onchange" reRender="tablaGen" ajaxSingle="true"
									actionListener="#{controlImplantes.lecturaNumeroSerieGen}"/>
							</h:inputText>	
							<a4j:commandLink reRender="tablaGen"
								actionListener="#{controlImplantes.delNumSerieGen }">
								<h:graphicImage url="/img/iconos/limpia.png"
									title="#{ms.imp_dispositivos_tab_himp_lectura_numserie_borrar }" width="16" height="16"
									style="border: 0px;" />
							</a4j:commandLink>
						</h:panelGrid>				
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_gen_loc }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">
							<h:selectOneMenu id="LocGen" value="#{lineagen.localizacion }" rendered="#{controlImplantes.tipogen ne 5 and controlImplantes.tipogen ne 6}">
								<f:selectItems value="#{controlImplantes.localizaciongen }" />	
								<a4j:support event="onchange" reRender="panelMotivosGen" ajaxSingle="true"
									actionListener="#{controlImplantes.cambiaLocalizacionGen}"/>						
							</h:selectOneMenu>
							<h:selectOneMenu value="#{lineagen.localizacion }" rendered="#{controlImplantes.tipogen eq 5 }">
								<f:selectItems value="#{controlImplantes.zonacamaravd}"/>
							</h:selectOneMenu>
							<h:selectOneMenu value="#{lineagen.localizacion }" rendered="#{controlImplantes.tipogen eq 6 }">
								<f:selectItems value="#{controlImplantes.localizaciongensicd}"/>
								<a4j:support event="onchange" reRender="panelMotivosGen" ajaxSingle="true"
									actionListener="#{controlImplantes.cambiaLocalizacionGen}"/>
							</h:selectOneMenu>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_gen_rf }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">
							<h:outputLabel value="#{lineagen.rf }" />
						</h:panelGrid>					
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_gen_mri }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">
							<h:outputLabel value="#{lineagen.mricomp }" />
						</h:panelGrid>							
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaGen,panelMotivosGen" actionListener="#{controlImplantes.delGenerador }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eliminar }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="panelMotivosGen" columns="3">
			<h:panelGrid columns="2" rendered="#{(controlImplantes.actualizacion eq false and controlImplantes.explanteGen eq true and controlImplantes.previoimp eq true)}">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_gen_mot_expl }" style="font-weight: bold;"/>
				<h:selectOneMenu value="#{controlImplantes.listageneradorexp[0].motivoexplante }">
					<f:selectItems value="#{controlImplantes.mexplantegen}"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" rendered="#{(controlImplantes.actualizacion eq true) and (controlImplantes.tipoprocmanual eq 1147)}">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_gen_mot_expl }" style="font-weight: bold;"/>
				<h:selectOneMenu value="#{controlImplantes.listageneradorexptarjeta[0].motivoexplante }">
					<f:selectItems value="#{controlImplantes.mexplantegen}"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" rendered="#{(controlImplantes.actualizacion eq false and controlImplantes.recambioGen eq true and controlImplantes.previoimp eq true and !empty controlImplantes.listagenerador[0]) or (controlImplantes.tipoprocmanual eq 1059 or controlImplantes.tipoprocmanual eq 1060)}">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_gen_mot_recam }" style="font-weight: bold;"/>
				<h:selectOneMenu value="#{controlImplantes.listagenerador[0].motivorecambio }">
					<f:selectItems value="#{controlImplantes.mrecambiogen}"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" rendered="#{(controlImplantes.actualizacion eq false and controlImplantes.recolocacionGen eq true and controlImplantes.previoimp eq true) or (controlImplantes.tipoprocmanual eq 1085)}">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_gen_mot_recol }" style="font-weight: bold;"/>
				<h:selectOneMenu value="#{controlImplantes.listagenerador[0].motivorecolocacion }">
					<f:selectItems value="#{controlImplantes.mrecolocaciongen }"/>
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid rendered="#{controlImplantes.tipogen eq 2 || controlImplantes.tipogen eq 4 || controlImplantes.tipogen eq 6}" 
			columns="2" columnClasses="alignTop,alignTop">
			<h:panelGrid columnClasses="alignTop">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_tipo_indicacion }" style="font-weight: bold;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneRadio layout="lineDirection" value="#{controlImplantes.himp.tindicacion }">
						<f:selectItem itemLabel="#{ms.imp_dispositivos_tab_himp_tipo_indicacion_prim }" itemValue="0" />
						<f:selectItem itemLabel="#{ms.imp_dispositivos_tab_himp_tipo_indicacion_sec }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.imp_dispositivos_tab_himp_tipo_indicacion_desc }" itemValue="2"/>
					</h:selectOneRadio>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid rendered="#{controlImplantes.tipogen eq 6 }" columnClasses="alignTop">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_sicd_num_incis }" style="font-weight: bold;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.himp.incisionesSicd}">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
						<f:selectItem itemLabel="1" itemValue="1"/>
						<f:selectItem itemLabel="2" itemValue="2"/>
						<f:selectItem itemLabel="3" itemValue="3"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>			
		</h:panelGrid>
		
		<h:panelGrid width="100%">
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_ele }" rendered="#{controlImplantes.tipogen ne 5 }"
					style="font-weight: bold;" />
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_ele_med }" rendered="#{controlImplantes.tipogen eq 5 }"
					style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaElectrodos,tablaUmb,tablaProg" rendered="#{controlImplantes.tipogen ne 5 }"
					actionListener="#{controlImplantes.addElectrodos}">
					<h:graphicImage value="/img/iconos/add.png" width="16"
						height="16" style="border:0;" title="#{ms.aniadir }" />	
				</a4j:commandLink>
			</h:panelGrid>
			
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
					id="tablaElectrodos" width="100%">
				<t:dataTable styleClass="hor-minimalist-b" var="linea"
					width="100%" value="#{controlImplantes.listaelectrodos }"
					binding="#{controlImplantes.bindingElec }" id="dataTableElectrodos" rowIndexVar="ribelec">
					<t:column width="30%" headerstyleClass="left">
						<f:facet name="header">
							<h:panelGrid>
								<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_camara }" rendered="#{controlImplantes.tipogen ne 6 }"/>
								<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_ubicacion }" rendered="#{controlImplantes.tipogen eq 6 }"/>
							</h:panelGrid>						
						</f:facet>
						<h:panelGrid rendered="#{!(linea.vdd eq true and linea.camara eq 948)}">
							<h:outputText value="AD" rendered="#{linea.camara eq 948}" title="#{linea.abordajetexto }"/>
	             			<h:outputText value="VD" rendered="#{linea.camara eq 949}" title="#{linea.abordajetexto }"/>
	              			<h:outputText value="VI" rendered="#{linea.camara eq 950}" title="#{linea.abordajetexto }"/>
	              			<h:outputText value="LEADLESS" rendered="#{controlImplantes.tipogen eq 5}" title="#{ms.imp_dispositivos_tab_himp_ele_camara_leadless }"/>
	              			<h:outputText value="#{linea.abordajetexto }" rendered="#{linea.conector eq 'SQ1'}" />
						</h:panelGrid>
						<a4j:commandLink reRender="tablaElectrodos,tablaUmb,tablaProg,panModalAbordaje"
								onclick="javascript:Richfaces.showModalPanel('abordajeElectrodo');"
								value="#{ms.imp_dispositivos_tab_himp_ele_camara_vercambiar } " 
								rendered="#{!(linea.vdd eq true and linea.camara eq 948) and controlImplantes.tipogen ne 5}">		
							 <f:setPropertyActionListener value="#{linea}"
                            	target="#{controlImplantes.currentItemElectrodos}"/>
                             <f:setPropertyActionListener value="#{linea}"
                            	target="#{controlImplantes.currentItemElectrodosBackUp}"/>
						</a4j:commandLink>
					</t:column>
					<t:column width="20%" headerstyleClass="left" rendered="#{controlImplantes.tipogen ne 5}">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_fab }"/>
						</f:facet>
						<h:panelGrid columns="2" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}">
							<h:outputLabel value="#{linea.fabricante }"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left" rendered="#{controlImplantes.tipogen ne 5}">
						<f:facet name="header">
							<h:panelGrid columns="3" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}">
								<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_modelo }" />
								<a4j:commandLink reRender="tablaElectrodos"
									actionListener="#{controlImplantes.cargarModelosElectrodos }">
									<h:graphicImage value="/img/iconos/list-view.png" width="16"
										height="16" style="border:0;" title="#{ms.imp_dispositivos_tab_himp_ele_modelo_lista }"/>		
								</a4j:commandLink>
								<a4j:commandLink reRender="tablaElectrodos"
									onclick="javascript:Richfaces.showModalPanel('insertarElectrodoHimp');">
									<h:graphicImage value="/img/iconos/add_2.png" width="16"
										height="16" style="border:0;" title="#{ms.imp_dispositivos_tab_himp_ele_modelo_no_lista }"/>				
								</a4j:commandLink>
							</h:panelGrid>
						</f:facet>
						<h:panelGrid id="modeloElectrodo" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_lectura_cod_barras_msg }" rendered="#{linea.muestrabarcode eq true }"/>
							<h:inputText id="hiddenElectrodo" value="#{linea.barcode }" rendered="#{linea.muestrabarcode eq true }">
								<a4j:support event="onchange" reRender="tablaElectrodos,vectorEstimulacionVIEv,opcionNuevoElectrodoHimp,panelMaterialEditarElectrodoImp" ajaxSingle="true"
									actionListener="#{controlImplantes.lecturaCodigoBarrasElectrodo}"
									focus="inicio:panelHojaImplante:dataTableElectrodos:#{ribelec}:NumSerElec"/>
							</h:inputText>
							<h:outputLabel value="#{linea.nombremodelo}" />
							<h:panelGrid rendered="false">
								<h:selectOneMenu value="#{linea.idelectrodo }">
									<f:selectItems value="#{controlImplantes.electrodos }" />					
									<a4j:support event="onchange" reRender="evolucion,tablaElectrodos,vectorEstimulacionVIEv" 
										actionListener="#{controlImplantes.lecturaElectrodo}" ajaxSingle="true"/>							
								</h:selectOneMenu>
							</h:panelGrid>
							<h:panelGrid columns="2" rendered="#{controlImplantes.modelec eq true }">
								<r:comboBox enableManualInput="true" defaultLabel="#{ms.imp_dispositivos_tab_himp_lectura_manual }" width="200"
									value="#{linea.nombremodelo}" rendered="#{linea.tipoelectrodo eq null and controlImplantes.impl.idimplante ne null}">
									<f:selectItems value="#{controlImplantes.electrodos2 }"/>
									<a4j:support event="onchange" reRender="evolucion,tablaElectrodos" ajaxSingle="true"
										actionListener="#{controlImplantes.lecturaElectrodo2}"/>
								</r:comboBox>
								<r:comboBox enableManualInput="true" defaultLabel="#{ms.imp_dispositivos_tab_himp_lectura_manual }" width="200"
									value="#{linea.nombremodelo}" rendered="#{linea.tipoelectrodo eq null and controlImplantes.impl.idimplante eq null}">
									<f:selectItems value="#{controlImplantes.electrodos }"/>
									<a4j:support event="onchange" reRender="evolucion,tablaElectrodos" ajaxSingle="true"
										actionListener="#{controlImplantes.lecturaElectrodo2}"/>
								</r:comboBox>
							</h:panelGrid>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left" rendered="#{controlImplantes.tipogen ne 5}">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_numserie }" />
						</f:facet>
						<h:panelGrid columns="2"  id="numseriegen" rendered="#{linea.tipoelectrodo eq null }">
							<h:inputText id="NumSerElec" value="#{linea.numserie }" size="20" maxlength="45">
								<a4j:support event="onchange" reRender="tablaElectrodos" ajaxSingle="true"
									actionListener="#{controlImplantes.lecturaNumeroSerieElectrodo}"/>
							</h:inputText>
							<a4j:commandLink reRender="tablaElectrodos"
								actionListener="#{controlImplantes.delNumSerieElec }">
								<h:graphicImage url="/img/iconos/limpia.png"
									title="#{ms.imp_dispositivos_tab_himp_lectura_numserie_borrar }" width="16" height="16"
									style="border: 0px;" />
							</a4j:commandLink>
						</h:panelGrid>
					</t:column>	
					<t:column width="20%" headerstyleClass="left" rendered="#{controlImplantes.tipogen ne 5}">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_conector }" />
						</f:facet>
						<h:panelGrid columns="2" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}">
							<h:outputLabel value="#{linea.conector }" />
						</h:panelGrid>
					</t:column>
					
					<t:column width="60%" headerstyleClass="left" >	
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_ele_umbrales }" 
								rendered="#{linea.estado eq 0 and linea.conector ne 'SQ1'}"/>
						</f:facet>			
						<h:panelGrid columns="2" rendered="#{linea.estado eq 0 and linea.conector ne 'SQ1'}">
							<h:outputText value="#{ms.imp_dispositivos_ele_onda_p } " rendered="#{linea.camara eq 948 }"/>
							<h:outputText value="#{ms.imp_dispositivos_ele_onda_r } " rendered="#{linea.camara ne 948 }"/>
							<h:inputText size="4" value="#{linea.ondarpImp }" maxlength="5"/>	
							<h:outputText value="#{ms.imp_dispositivos_ele_imped_ohm }" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>
							<h:inputText size="4" value="#{linea.impohmImp }" maxlength="5" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>	
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="" />
						</f:facet>
						<h:panelGrid columns="2" rendered="#{linea.estado eq 0 and linea.conector ne 'SQ1'}">
							<h:outputText value="#{ms.imp_dispositivos_ele_umbral_v }" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>
							<h:inputText size="4" value="#{linea.umbralvImp }" maxlength="5" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>
							<h:outputText value="#{ms.imp_dispositivos_ele_umbral_ms }" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>
							<h:inputText size="4" value="#{linea.umbralmsImp }" maxlength="5" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>	
						</h:panelGrid>
					</t:column>					
					<t:column width="40%" headerstyleClass="left" >
						<f:facet name="header">
							<h:outputText value="" />
						</f:facet>
						<h:panelGrid rendered="#{linea.estado eq 0 and linea.conector ne 'SQ1'}">
							<a href="#" onclick="#{rich:element('opcionalesElec')}.style.display = ''; return false;">Más...</a>		  
							<h:panelGrid columns="2" id="opcionalesElec" style="display:none;">						
								<h:outputText value="#{ms.imp_dispositivos_ele_slew_rate }" />
								<h:inputText size="4" value="#{linea.slewrate }" maxlength="5"/>	
								<h:outputText value="#{ms.imp_dispositivos_ele_imp_ms }" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>
								<h:inputText size="4" value="#{linea.impmsImp }" maxlength="5" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>
								<h:outputText value="#{ms.imp_dispositivos_ele_imp_v }" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>
								<h:inputText size="4" value="#{linea.impvImp }" maxlength="5" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}"/>							
								<a href="#" onclick="#{rich:element('opcionalesElec')}.style.display = 'none'; return false;">Ocultar</a>	
							</h:panelGrid>
						</h:panelGrid>
					</t:column>
					
					<t:column width="20%" headerstyleClass="left" rendered="#{linea.camara eq 950}">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_ele_estim_fren }" />
						</f:facet>
						<h:panelGrid columns="2" rendered="#{linea.estado eq 0 }">
							<h:outputLabel value="#{ms.imp_dispositivos_ele_estim_fren_title }"/>
							<h:selectBooleanCheckbox value="#{linea.estimfrenok }">
								<a4j:support event="onclick" reRender="tablaElectrodos" ajaxSingle="true"/>
							</h:selectBooleanCheckbox>
							<h:outputLabel value="#{ms.imp_dispositivos_ele_estim_fren_umb }" rendered="#{linea.estimfrenok eq true}"/>
							<h:inputText size="4" value="#{linea.estimfren}" rendered="#{linea.estimfrenok eq true}" maxlength="5"/>							
						</h:panelGrid>		
					</t:column>
					<t:column width="40%" headerstyleClass="left" rendered="#{controlImplantes.tipogen ne 5}">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_ele_fimp }" />
						</f:facet>
						<h:panelGrid columns="2" rendered="#{!(linea.vdd eq true and linea.camara eq 948)}" width="100%">
							<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
								showWeeksBar="false" direction="bottom-left" 
								value="#{linea.fechaimplante}" rendered="#{linea.estado eq 0 }">
								<a4j:support event="onchanged" reRender="tablaElectrodos" ajaxSingle="true" actionListener="#{controlImplantes.actualizaFechaImpElectrodo}"/>
							</rich:calendar>	
							<h:outputLabel value="#{linea.fechaimplante }" rendered="#{linea.estado ne 0 }">
								<f:convertDateTime pattern="dd.MM.yyyy" timeZone="CET"/>
							</h:outputLabel>						
						</h:panelGrid>		
					</t:column>
					<t:column width="20%" headerstyleClass="left" rendered="#{linea.cambiaabordaje eq true &amp;&amp; linea.recambio eq false}">
						<f:facet name="header">
							<h:outputText value="#{ms.imp_dispositivos_ele_mot_recol }" />
						</f:facet>
						<h:panelGrid>
							<h:outputLabel value="#{ms.imp_dispositivos_ele_mot_recol }"/>
							<h:selectOneMenu value="#{linea.motivorecolocacion }">
								<f:selectItems value="#{controlImplantes.mrecolocacionelec }" />					
								<a4j:support event="onchange" reRender="tablaElectrodos" ajaxSingle="true"/>							
							</h:selectOneMenu>						
						</h:panelGrid>		
					</t:column>
					<t:column width="20%" headerstyleClass="left" rendered="false">
						<h:panelGrid>
							<h:outputLabel value="#{ms.imp_dispositivos_ele_mot_recam }"/>
							<h:selectOneMenu value="#{linea.motivorecambio }">
								<f:selectItems value="#{controlImplantes.mrecambioelec }" />					
								<a4j:support event="onchange" reRender="tablaElectrodos" ajaxSingle="true"/>							
							</h:selectOneMenu>						
						</h:panelGrid>		
					</t:column>
					<t:column width="20%" headerstyleClass="left" 
						rendered="#{controlImplantes.impl.interprev eq true and controlImplantes.tipogen ne 5}">						
						<h:panelGrid>
							<h:outputLabel value="#{ms.imp_dispositivos_ele_estado }"/>
							<h:selectOneMenu value="#{linea.estado }">
								<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_ele_estado_0 }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_ele_estado_1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_ele_estado_2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_ele_estado_3 }" />					
								<a4j:support event="onchange" reRender="tablaElectrodos" ajaxSingle="true"
									actionListener="#{controlImplantes.cambiarEstadoElectrodo }"/>							
							</h:selectOneMenu>						
						</h:panelGrid>		
					</t:column>
					<t:column width="20%" headerstyleClass="left" rendered="#{linea.estado ne 0 }">										
						<h:panelGrid columns="3">
							<h:outputLabel value="#{ms.imp_dispositivos_ele_estado }" />
							<h:panelGrid>
								<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_1 }" style="font-weight: bold;"
									rendered="#{linea.estado eq 1}"/>
								<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_2 }" style="font-weight: bold;"
									rendered="#{linea.estado eq 2}"/>
								<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_3 }" style="font-weight: bold;"
									rendered="#{linea.estado eq 3}"/>
							</h:panelGrid>	
							<h:panelGrid>
								<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_caracter_1 }" style="font-weight: bold;"
									rendered="#{linea.caracter eq 1}"/>
								<h:outputLabel value="#{ms.imp_dispositivos_ele_estado_caracter_2 }" style="font-weight: bold;"
									rendered="#{linea.caracter eq 2}"/>
							</h:panelGrid>
						</h:panelGrid>
					</t:column>
					
					<t:column headerstyleClass="left" rendered="#{controlImplantes.previoimp eq false || controlImplantes.actualizacion eq true || linea.recambio eq true}">
						<a4j:commandLink reRender="tablaElectrodos,tablaUmb,tablaProg" rendered="#{linea.tipoelectrodo eq null and controlImplantes.tipogen ne 5}"						
							actionListener="#{controlImplantes.delElectrodos }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eliminar }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
					<t:column headerstyleClass="left" rendered="#{controlImplantes.previoimp eq true &amp;&amp; controlImplantes.actualizacion eq false &amp;&amp; linea.recambio eq false &amp;&amp; linea.tipoelectrodo eq null and controlImplantes.tipogen ne 5}">
						<a4j:commandLink reRender="panelAccionesElectrodo,tablaElectrodos"
								onclick="javascript:Richfaces.showModalPanel('eliminarElectrodo');">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eliminar }" width="16" height="16"
								style="border: 0px;" />
							 <f:setPropertyActionListener value="#{linea}"
                            		target="#{controlImplantes.currentItemElectrodosEliminar}"/>
                             <f:setPropertyActionListener value="#{linea}"
                            		target="#{controlImplantes.currentItemElectrodosEliminarBackUp}"/>
						</a4j:commandLink>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
		</h:panelGrid>
		
		<rich:simpleTogglePanel switchType="client" label="Equipo" opened="false">		
				<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
					<h:outputLabel value="Implantador" style="font-weight: bold;"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlImplantes.himp.implantador}">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_implantador_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_himp_implantador_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_himp_implantador_op3 }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tab_himp_implantador_op4 }" />	
							<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tab_himp_implantador_op5 }" />							
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="3" width="100%"
					columnClasses="alignTop33,alignTop33,alignTop33">
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_equipo_enf }" style="font-weight: bold;" />
						<a4j:commandLink reRender="tablaEnf"
							actionListener="#{controlImplantes.addEnf }">
							<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
								style="border:0;" title="#{ms.imp_dispositivos_tab_himp_equipo_enf_add }" />
						</a4j:commandLink>
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_equipo_pop }" style="font-weight: bold;" />
						<a4j:commandLink reRender="tablaEquipo"
							actionListener="#{controlImplantes.addPop }">
							<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
								style="border:0;" title="#{ms.imp_dispositivos_tab_himp_equipo_pop_add }" />
						</a4j:commandLink>
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_equipo_sop }" style="font-weight: bold;" />
						<a4j:commandLink reRender="tablaOp2"
							actionListener="#{controlImplantes.addSop }">
							<h:graphicImage value="/img/iconos/add.png" width="16" height="16"
								style="border:0;" title="#{ms.imp_dispositivos_tab_himp_equipo_sop_add }" />
						</a4j:commandLink>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						id="tablaEnf" width="82%">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
							value="#{controlImplantes.himp.enfermeras }"
							binding="#{controlImplantes.binEnf }">
							<t:column width="90%" headerstyleClass="left">
								<h:outputLabel value="#{linea.idenf }"/>
								<h:selectOneMenu value="#{linea.idenf }" rendered="#{linea.lectura eq 0}"
									style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
									<f:selectItems value="#{controlImplantes.enfermeras }" />
									<a4j:support event="onchange" reRender="tablaEnf" ajaxSingle="true"
										actionListener="#{controlImplantes.controlEnf }"/>
								</h:selectOneMenu>
							</t:column>
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="tablaEnf" actionListener="#{controlImplantes.delEnf }">
									<h:graphicImage url="/img/iconos/minus.png"
										title="#{ms.imp_dispositivos_tab_himp_equipo_enf_del }" width="16" height="16"
										style="border: 0px;" />
								</a4j:commandLink>
							</t:column>
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="tablaEnf" actionListener="#{controlImplantes.editEnf }" >
									<h:graphicImage url="/img/iconos/editar.png"
										title="#{ms.editar }" width="16" height="16" style="border: 0px;" />
								</a4j:commandLink>
							</t:column>
						</t:dataTable>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						id="tablaEquipo" width="82%">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
							value="#{controlImplantes.himp.poperador }" binding="#{controlImplantes.binPop }">
							<t:column width="90%" headerstyleClass="left">
								<h:outputLabel value="#{linea.idop }"/>
								<h:selectOneMenu value="#{linea.idop }" rendered="#{linea.lectura eq 0}"
									style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
									<f:selectItems value="#{controlImplantes.primerOperador }" />
									<a4j:support event="onchange" reRender="tablaEquipo" ajaxSingle="true"
										actionListener="#{controlImplantes.controlPop }"/>
								</h:selectOneMenu>
							</t:column>
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="tablaEquipo" actionListener="#{controlImplantes.delPop }">
									<h:graphicImage url="/img/iconos/minus.png"
										title="#{ms.imp_dispositivos_tab_himp_equipo_pop_del }" width="16" height="16"
										style="border: 0px;" />
								</a4j:commandLink>
							</t:column>
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="tablaEquipo" actionListener="#{controlImplantes.editPop }" >
									<h:graphicImage url="/img/iconos/editar.png"
										title="#{ms.editar }" width="16" height="16" style="border: 0px;" />
								</a4j:commandLink>
							</t:column>
						</t:dataTable>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						id="tablaOp2" width="82%">
						<t:dataTable styleClass="hor-minimalist-b" var="linea" width="100%"
							value="#{controlImplantes.himp.soperador }" binding="#{controlImplantes.binSop }">
							<t:column width="90%" headerstyleClass="left">
								<h:outputLabel value="#{linea.idop }"/>
								<h:selectOneMenu value="#{linea.idop}" rendered="#{linea.lectura eq 0}"
									style="font-size: 10px;font-family: Lucida Grande, Lucida Sans, Arial, sans-serif;">
									<f:selectItems value="#{controlImplantes.segundoOperador }" />
									<a4j:support event="onchange" reRender="tablaOp2" ajaxSingle="true"
										actionListener="#{controlImplantes.controlSop }"/>
								</h:selectOneMenu>
							</t:column>
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="tablaOp2" actionListener="#{controlImplantes.delSop }">
									<h:graphicImage url="/img/iconos/minus.png"
										title="#{ms.imp_dispositivos_tab_himp_equipo_sop_del }" width="16" height="16"
										style="border: 0px;" />
								</a4j:commandLink>
							</t:column>
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="tablaOp2" actionListener="#{controlImplantes.editSop }" >
									<h:graphicImage url="/img/iconos/editar.png"
										title="#{ms.editar }" width="16" height="16" style="border: 0px;" />
								</a4j:commandLink>
							</t:column>
						</t:dataTable>
					</h:panelGrid>
				</h:panelGrid>
		</rich:simpleTogglePanel>		
		<rich:spacer width="20" />
		<rich:simpleTogglePanel switchType="client" label="Datos de operación" opened="false">	
			<h:panelGrid columns="3" width="100%" columnClasses="alignTop,alignTop,alignTop">
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_prioridad }" style="font-weight: bold;"/>
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_lugar_imp }" style="font-weight: bold;"/>
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_anest_tipo }" style="font-weight: bold;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.himp.prioridad}">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_prioridad_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_himp_prioridad_op2 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_himp_prioridad_op3 }" />
						<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tab_himp_prioridad_op4 }" />	
						<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tab_himp_prioridad_op5 }" />							
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.himp.lugarimp}">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_lugar_imp_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_himp_lugar_imp_op2 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_himp_lugar_imp_op3 }" />
					</h:selectOneMenu>
				</h:panelGrid>		
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.himp.tanestesia}">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_anest_tipo_op1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_himp_anest_tipo_op2 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_himp_anest_tipo_op3 }" />								
					</h:selectOneMenu>
				</h:panelGrid>							
			</h:panelGrid>
			<h:panelGrid columns="3" width="80%" columnClasses="alignTop,alignTop,alignTop">
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_t_escopia }" style="font-weight: bold;"/>
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_d_escopia }" style="font-weight: bold;"/>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_tiempos }" style="font-weight: bold;" />			
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					columnClasses="alignTop,alignTop,alignTop">
					<h:inputText size="3" value="#{controlImplantes.himp.tescopia}" maxlength="3"/>	
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					columnClasses="alignTop,alignTop,alignTop">
					<h:inputText size="3" value="#{controlImplantes.himp.dosisEscopia}" maxlength="10"/>	
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_tiempos_hllegada }" />
					<rich:inputNumberSpinner value="#{controlImplantes.himp.hllegadah }" step="1" maxValue="23" minValue="00" inputSize="2"/>
					<h:outputLabel value=":" />
					<rich:inputNumberSpinner value="#{controlImplantes.himp.hllegadam }" step="1" maxValue="59" minValue="00" inputSize="2"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_tiempos_hinicio }" />
					<rich:inputNumberSpinner value="#{controlImplantes.himp.hinicioh }" step="1" maxValue="23" minValue="00" inputSize="2"/>
					<h:outputLabel value=":" />
					<rich:inputNumberSpinner value="#{controlImplantes.himp.hiniciom }" step="1" maxValue="59" minValue="00" inputSize="2"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_tiempos_hfin }" />
					<rich:inputNumberSpinner value="#{controlImplantes.himp.hfinh }" step="1" maxValue="23" minValue="00" inputSize="2"/>
					<h:outputLabel value=":" />
					<rich:inputNumberSpinner value="#{controlImplantes.himp.hfinm }" step="1" maxValue="59" minValue="00" inputSize="2"/>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_tiempos_hsalida }" />
					<rich:inputNumberSpinner value="#{controlImplantes.himp.hsalidah }" step="1" maxValue="23" minValue="00" inputSize="2"/>
					<h:outputLabel value=":" />
					<rich:inputNumberSpinner value="#{controlImplantes.himp.hsalidam }" step="1" maxValue="59" minValue="00" inputSize="2"/>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid width="100%">
				<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_tab_himp_med_intra }" opened="true">
					<h:panelGrid columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop" width="100%">
						<h:outputText value="#{ms.imp_dispositivos_tab_himp_med_intra_antibio }" style="font-weight: bold;"/>
						<h:outputText value="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag }" style="font-weight: bold;"/>
						<h:outputText value="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_retirada }" style="font-weight: bold;"/>
						<h:outputText value="#{ms.imp_dispositivos_tab_himp_med_intra_inr }" style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;" id="panImpmedIntraProfAntibio">
							<h:selectOneMenu value="#{controlImplantes.himp.medintra.profiAntibio }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antibio_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antibio_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antibio_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antibio_op4 }" />
								<a4j:support event="onchange" reRender="panImpmedIntraProfAntibio" ajaxSingle="true"/>							
							</h:selectOneMenu>
							<h:inputText value="#{controlImplantes.himp.medintra.profiAntibioOtra }" 
								rendered="#{controlImplantes.himp.medintra.profiAntibio eq 4 }"/>
						</h:panelGrid>
						<h:panelGrid style="border-top: solid 1px;border-color: black;" id="panImpmedIntraAnticoag">
							<h:selectOneMenu value="#{controlImplantes.himp.medintra.anticoag }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_op4 }" />
								<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_op5 }" />
								<f:selectItem itemValue="6" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_op6 }" />
								<f:selectItem itemValue="8" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_op8 }" />
								<f:selectItem itemValue="7" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_op7 }" />
								<a4j:support event="onchange" reRender="panImpmedIntraAnticoag" ajaxSingle="true"/>							
							</h:selectOneMenu>
							<h:inputText value="#{controlImplantes.himp.medintra.anticoagOtra }" 
								rendered="#{controlImplantes.himp.medintra.anticoag eq 7}"/>
						</h:panelGrid>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:selectOneMenu value="#{controlImplantes.himp.medintra.anticoagRetirada }">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_retirada_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_retirada_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tab_himp_med_intra_antcoag_retirada_op3 }" />
								<a4j:support event="onchange" reRender="panImpmedIntraAnticoag" ajaxSingle="true"/>							
							</h:selectOneMenu>
						</h:panelGrid>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<h:inputText size="3" value="#{controlImplantes.himp.medintra.inr }" maxlength="3"/>
						</h:panelGrid>
					</h:panelGrid>
				</rich:simpleTogglePanel>
			</h:panelGrid>
			<h:panelGrid width="100%">
				<rich:simpleTogglePanel switchType="client" label="#{ms.compli_proc_imp_intra_title }" opened="true">
					<h:panelGrid id="complicacionesImplantes" width="100%">
						<a4j:include viewId="/ventanas/implantes/complicaciones/complicacion.jsp" />
					</h:panelGrid>
				</rich:simpleTogglePanel>
			</h:panelGrid>
			<h:panelGrid width="80%" rendered="false">
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_complic_title }"
						style="font-weight: bold;" />
					<a4j:commandLink reRender="tablaCompIntra"
						actionListener="#{controlImplantes.addComplicacionIntra }">
						<h:graphicImage value="/img/iconos/add.png" width="16"
							height="16" style="border:0;" title="#{ms.aniadir }"/>				
					</a4j:commandLink>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
						id="tablaCompIntra" width="100%">
					<t:dataTable styleClass="hor-minimalist-b" var="lineacompintra"
						width="100%" value="#{controlImplantes.listacomplicacionesintra }"
						binding="#{controlImplantes.bindingCompliIntra }">
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.compl_tipo }" />
							</f:facet>
							<h:panelGrid columns="2">
								<h:selectOneMenu value="#{lineacompintra.tipocomp }">
									<f:selectItems value="#{controlImplantes.tipocomplicacion}" />
									<a4j:support event="onchange" reRender="tablaCompIntra" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompIntraTipo }"/>						
								</h:selectOneMenu>					
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.compl_clase }" />
							</f:facet>
							<h:panelGrid columns="2">								
								<h:selectOneMenu value="#{lineacompintra.idcompl}" rendered="#{lineacompintra.tipocomp eq '967'}">
									<f:selectItems value="#{controlImplantes.lcompintraquir }" />
									<a4j:support event="onchange" reRender="tablaCompIntra" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompIntra }"/>						
								</h:selectOneMenu>
								<h:selectOneMenu value="#{lineacompintra.idcompl}" rendered="#{lineacompintra.tipocomp eq '968'}">
									<f:selectItems value="#{controlImplantes.lcompintraarr }" />	
									<a4j:support event="onchange" reRender="tablaCompIntra" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompIntra }"/>					
								</h:selectOneMenu>
								<h:selectOneMenu value="#{lineacompintra.idcompl}" rendered="#{lineacompintra.tipocomp eq '969'}">
									<f:selectItems value="#{controlImplantes.lcompintratmp }" />
									<a4j:support event="onchange" reRender="tablaCompIntra" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompIntra }"/>						
								</h:selectOneMenu>
								<h:selectOneMenu value="#{lineacompintra.idcompl}" rendered="#{lineacompintra.tipocomp eq '970'}">
									<f:selectItems value="#{controlImplantes.lcompintraresp }" />	
									<a4j:support event="onchange" reRender="tablaCompIntra" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompIntra }"/>					
								</h:selectOneMenu>
								<h:selectOneMenu value="#{lineacompintra.idcompl}" rendered="#{lineacompintra.tipocomp eq '971'}">
									<f:selectItems value="#{controlImplantes.lcompintramuerte }" />		
									<a4j:support event="onchange" reRender="tablaCompIntra" ajaxSingle="true"
										actionListener="#{controlImplantes.controlCompIntra }"/>				
								</h:selectOneMenu>
								<h:inputText value="#{lineacompintra.otra }" size="15" rendered="#{lineacompintra.tipocomp eq '972'}"/>
							</h:panelGrid>
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.compl_actitud }" />
							</f:facet>
							<h:panelGrid columns="2">												
								<h:inputTextarea cols="25" rows="4" value="#{lineacompintra.actitud }"/>
							</h:panelGrid>					
						</t:column>
						<t:column width="20%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.compl_resultado }" />
							</f:facet>
							<h:panelGrid columns="2">
								<h:selectOneMenu value="#{lineacompintra.resultado }">
									<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.compl_resultado_pos }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.compl_resultado_neg }" />													
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column headerstyleClass="left">
							<a4j:commandLink reRender="tablaCompIntra"
								actionListener="#{controlImplantes.delComplicacionIntra }">
								<h:graphicImage url="/img/iconos/minus.png"
									title="#{ms.eliminar }" width="16" height="16"
									style="border: 0px;" />
							</a4j:commandLink>
						</t:column>
					</t:dataTable>
				</h:panelGrid>
			</h:panelGrid>
		</rich:simpleTogglePanel>
		<rich:spacer width="20" />
		<rich:simpleTogglePanel switchType="client" label="Comentarios" opened="false">
			<h:panelGrid>
				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_comentarios }"/>
				<h:inputTextarea cols="200" rows="8" value="#{controlImplantes.himp.comentarios }" id="comentariosHojaImp">
					<f:validateLength maximum="2000" />
				</h:inputTextarea>	
				<h:message for="comentariosHojaImp" style="color:red" />
			</h:panelGrid>
		</rich:simpleTogglePanel>
		<rich:spacer width="20" />
		<rich:simpleTogglePanel switchType="client" label="#{ms.imp_dispositivos_tab_himp_testind_title }" 
			opened="true" rendered="#{controlImplantes.tipogen eq 2 || controlImplantes.tipogen eq 4 || controlImplantes.tipogen eq 6}"
			id="testinduccionimplante">
			<h:panelGrid columns="5" columnClasses="alignTop,alignTop,alignTop,alignTop" width="100%">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlImplantes.himp.testi}">
	   					<a4j:support event="onclick" reRender="testinduccionimplante" 
	   						actionListener="#{controlImplantes.testIndHojaImp}" ajaxSingle="true"/>
	  				</h:selectBooleanCheckbox>
	  				<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_testind_induc }" style="font-weight: bold;"/>
				</h:panelGrid>
  				<h:panelGrid rendered="#{controlImplantes.himp.testi eq true}">
  					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_testind_efec }" style="font-weight: bold;" />
  					<h:panelGrid style="border-top: solid 1px;border-color: black;"> 						
						<h:selectOneMenu value="#{controlImplantes.himp.testindEfectivo}">
							<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_testind_si }" />
							<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_tab_himp_testind_no }" />
							<a4j:support event="onchange" reRender="testinduccionimplante" ajaxSingle="true"/>													
						</h:selectOneMenu>
					</h:panelGrid>
  				</h:panelGrid>
  				<h:panelGrid rendered="#{controlImplantes.himp.testi eq true and controlImplantes.himp.testindEfectivo eq 1}">
  					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_testind_desfib }" style="font-weight: bold;" />
  					<h:panelGrid style="border-top: solid 1px;border-color: black;"> 						
						<h:selectOneMenu value="#{controlImplantes.himp.testindDesfib}">
							<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_testind_si }" />
							<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_tab_himp_testind_no }" />
							<a4j:support event="onchange" reRender="testinduccionimplante" ajaxSingle="true"/>												
						</h:selectOneMenu>
					</h:panelGrid>
  				</h:panelGrid>
  				<h:panelGrid columns="3" rendered="#{controlImplantes.himp.testi eq true and controlImplantes.himp.testindEfectivo eq 1 and controlImplantes.himp.testindDesfib eq 1}">
  					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_testind_energ }" title="#{ms.imp_dispositivos_tab_himp_testind_energ_title }" style="font-weight: bold;"/>
  					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_testind_imp }" title="#{ms.imp_dispositivos_tab_himp_testind_imp_title }" style="font-weight: bold;"/>
  					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_testind_nchoq }" title="#{ms.imp_dispositivos_tab_himp_testind_nchoq_title }" style="font-weight: bold;"/> 					
  					<h:panelGrid style="border-top: solid 1px;border-color: black;">	  					
						<h:inputText size="4" value="#{controlImplantes.himp.energiatest}" maxlength="4"/>
	  				</h:panelGrid>
	  				<h:panelGrid style="border-top: solid 1px;border-color: black;">	  					
						<h:inputText size="4" value="#{controlImplantes.himp.imptest}" maxlength="4"/>
	  				</h:panelGrid>
	  				<h:panelGrid style="border-top: solid 1px;border-color: black;">	  					
						<h:inputText size="4" value="#{controlImplantes.himp.numchoqtest}" maxlength="4"/>
	  				</h:panelGrid>	  				
  				</h:panelGrid>
  				<h:panelGrid rendered="#{controlImplantes.himp.testi eq true and controlImplantes.himp.testindEfectivo eq 1 and controlImplantes.himp.testindDesfib eq 1 and controlImplantes.tipogen eq 6}">
  					<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_testind_pol }" title="#{ms.imp_dispositivos_tab_himp_testind_pol_title }" style="font-weight: bold;"/>
  					<h:panelGrid style="border-top: solid 1px;border-color: black;">	  					
						<h:selectOneMenu value="#{controlImplantes.himp.polaridadTest}">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tab_himp_testind_pol_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tab_himp_testind_pol_op2 }" />																		
						</h:selectOneMenu>
	  				</h:panelGrid>
  				</h:panelGrid>		
			</h:panelGrid>
		</rich:simpleTogglePanel>
	</h:panelGrid>
	<rich:modalPanel id="eliminarElectrodo" autosized="true" zindex="2000" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_modal_acciones_elec }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlImplantes.accionesElectrodo }"
					reRender="tablaElectrodos,tablaUmb,tablaProg"
					onclick="javascript:Richfaces.hideModalPanel('eliminarElectrodo');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.confirmar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlImplantes.accionesElectrodoCancelar }"
					reRender="tablaElectrodos"
					onclick="javascript:Richfaces.hideModalPanel('eliminarElectrodo');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						title="#{ms.cancelar }" />
				</a4j:commandLink>			
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="accioneselectrodos" width="100%">
			<ui:include src="/ventanas/implantes/accioneselectrodo.jsp" />
		</h:panelGrid>
	</rich:modalPanel>
	<rich:modalPanel id="abordajeElectrodo" autosized="true" zindex="2000" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_modal_abordaje_elec }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlImplantes.cambiarAbordajeElectrodoIncluir }"
					reRender="tablaElectrodos,tablaUmb,tablaProg,vectorEstimulacionVIEv"
					onclick="javascript:Richfaces.hideModalPanel('abordajeElectrodo');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.confirmar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlImplantes.cambiarAbordajeElectrodoCancelar }"
					reRender="tablaElectrodos,tablaUmb,tablaProg"
					onclick="javascript:Richfaces.hideModalPanel('abordajeElectrodo');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('abordajeElectrodo')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="abordajeelectrodos" width="100%">
			<ui:include src="/ventanas/implantes/abordajeelectrodo.jsp" />
		</h:panelGrid>
	</rich:modalPanel>
	
	<rich:modalPanel id="insertarGeneradorHimp" autosized="true" zindex="2000" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_modal_ins_gen }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlImplantes.insertarNuevoGenerador }" reRender="hojaimplante,panelMaterialEditarGeneradorImp"
					onclick="javascript:Richfaces.hideModalPanel('insertarGeneradorHimp');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.confirmar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlImplantes.cancelarNuevoGenerador}" reRender="panelMaterialEditarGeneradorImp"
					onclick="javascript:Richfaces.hideModalPanel('insertarGeneradorHimp');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('insertarGeneradorHimp')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="nuevogeneradorhimp" width="100%">
			<ui:include src="/ventanas/implantes/materiales/generador.jsp"/>
		</h:panelGrid>
	</rich:modalPanel>
	<rich:modalPanel id="insertarElectrodoHimp" autosized="true" zindex="2000" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_modal_ins_ele }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlImplantes.insertarNuevoElectrodo }" reRender="hojaimplante,panelMaterialEditarElectrodoImp"
					onclick="javascript:Richfaces.hideModalPanel('insertarElectrodoHimp');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.confirmar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlImplantes.cancelarNuevoElectrodo }" reRender="panelMaterialEditarElectrodoImp"
					onclick="javascript:Richfaces.hideModalPanel('insertarElectrodoHimp');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('insertarElectrodoHimp')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="nuevoelectrodohimp" width="100%">
			<ui:include src="/ventanas/implantes/materiales/electrodo.jsp"/>
		</h:panelGrid>
	</rich:modalPanel>
	
	<rich:modalPanel id="opcionNuevoGeneradorHimp" autosized="true" zindex="2000" minWidth="150" 
		showWhenRendered="#{controlImplantes.ngen eq true}">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_modal_ins_prev }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<h:panelGrid width="100%" align="center">
			<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_modal_ins_prev_msg_1 }"/>
			<h:panelGrid columns="2" align="center">
				<a4j:commandLink reRender="tablaGen" title="#{ms.aceptar }" value="#{ms.imp_dispositivos_tab_himp_modal_ins_prev_si }" 
					actionListener="#{controlImplantes.actualizaNuevoGen }"
					onclick="javascript:Richfaces.hideModalPanel('opcionNuevoGeneradorHimp');javascript:Richfaces.showModalPanel('insertarGeneradorHimp');">
					<h:graphicImage value="/img/aplicacion/accept.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('opcionNuevoGeneradorHimp');javascript:Richfaces.showModalPanel('insertarGeneradorHimp');"
						title="#{ms.aceptar }" />
				</a4j:commandLink>
				<a4j:commandLink onclick="javascript:Richfaces.hideModalPanel('opcionNuevoGeneradorHimp');" 
					title="#{ms.cancelar }" value="#{ms.imp_dispositivos_tab_himp_modal_ins_prev_no }" 
					actionListener="#{controlImplantes.actualizaNuevoGen }">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('opcionNuevoGeneradorHimp');"
						title="#{ms.cancelar }" />
				</a4j:commandLink>	
			</h:panelGrid>
		</h:panelGrid>
	</rich:modalPanel>
	<rich:modalPanel id="opcionNuevoElectrodoHimp" autosized="true" zindex="2000" minWidth="150" 
		showWhenRendered="#{controlImplantes.nelec eq true}">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.imp_dispositivos_tab_himp_modal_ins_prev }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<h:panelGrid width="100%" align="center">
			<h:outputLabel value="#{ms.imp_dispositivos_tab_himp_modal_ins_prev_msg_1 }"/>
			<h:panelGrid columns="2" align="center">
				<a4j:commandLink reRender="tablaElectrodos" title="#{ms.aceptar }" value="#{ms.imp_dispositivos_tab_himp_modal_ins_prev_si }" 
					actionListener="#{controlImplantes.actualizaNuevoElec }"
					onclick="javascript:Richfaces.hideModalPanel('opcionNuevoElectrodoHimp');javascript:Richfaces.showModalPanel('insertarElectrodoHimp');">
					<h:graphicImage value="/img/aplicacion/accept.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('opcionNuevoElectrodoHimp');javascript:Richfaces.showModalPanel('insertarElectrodoHimp');"
						title="#{ms.aceptar }" />
				</a4j:commandLink>
				<a4j:commandLink onclick="javascript:Richfaces.hideModalPanel('opcionNuevoElectrodoHimp');" 
					title="#{ms.cancelar }" value="#{ms.imp_dispositivos_tab_himp_modal_ins_prev_no }" actionListener="#{controlImplantes.actualizaNuevoElec }">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('opcionNuevoElectrodoHimp');"
						title="#{ms.cancelar }" />
				</a4j:commandLink>	
			</h:panelGrid>
		</h:panelGrid>
	</rich:modalPanel>
</ui:composition>
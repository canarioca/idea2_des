<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox">
	
	<h:panelGrid id="panelMaterialCateter" width="100%">
		<h:panelGrid columnClasses="alignTop,alignTop,alignTop" width="100%">
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0" >
				<h:outputLabel value="#{ms.mat_tab_cat_cons_title }"
					style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaMatCat"
					actionListener="#{controlMaterial.consultarCateteres }"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage value="/img/iconos/buscar.png" width="16"
						height="16" style="border:0;" title="#{ms.buscar }"/>				
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMaterial.limpiarCateteres}"
					style="align:right;" reRender="panelMaterialCateter"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage style="align:right;border:none;"
						styleClass="hvn_enlImagen" title="#{ms.limpiar }"
						width="16" height="16" url="/img/iconos/limpia.png"/>
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" 
				columns="5" width="100%">
					<h:outputLabel value="#{ms.mat_cat_modelo }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.mat_cat_tipo }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.mat_cat_referencia }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.mat_cat_fabricante }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.mat_activo }" style="font-weight: bold;"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText value="#{controlMaterial.cat.modelo}"/>
					</h:panelGrid>	
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlMaterial.cat.tipo}">
							<f:selectItem itemValue="" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_tipo_diag }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_tipo_abl }" />												
						</h:selectOneMenu>
					</h:panelGrid>			
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText value="#{controlMaterial.cat.referencia}"/>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlMaterial.cat.fabricante}">
							<f:selectItems value="#{controlMaterial.fabcat }" />																	
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlMaterial.cat.activo}">
							<f:selectItem itemValue="2" itemLabel="#{ms.mat_activo_todos }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.mat_activo_si }" />
							<f:selectItem itemValue="0" itemLabel="#{ms.mat_activo_no }" />												
						</h:selectOneMenu>
					</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid width="100%">
			<h:panelGrid id="tablaMatCat" width="100%">
				<h:panelGrid columns="3" columnClasses="alignRight">
					<h:outputLabel value="#{ms.mat_res_msg_1 }: " style="font-weight: bold;"
						rendered="#{controlMaterial.cats ne null }"/>
					<h:outputLabel value="#{controlMaterial.totalcat } #{ms.mat_res_msg_2 }." 
						style="font-weight: bold;color:#E17009" rendered="#{controlMaterial.cats ne null }"/>
					<t:commandLink actionListener="#{controlMaterial.exportarCateteres}" target="_blank" title="#{ms.exportar_excel }"
						rendered="#{controlMaterial.cats ne null }">
						<h:graphicImage value="/img/iconos/excel_icon.png" width="16" height="16" style="border: 0px;"/>
					</t:commandLink>
				</h:panelGrid>
				<t:dataTable styleClass="hor-minimalist-b" var="cat" rows="5"
						width="100%" value="#{controlMaterial.cats }"
						binding="#{controlMaterial.bindingCateter }"
						id="listamatcat">
						<t:column width="5%" headerstyleClass="left">
							<h:panelGrid>
								<a4j:commandLink reRender="tablaMatCat,panelMaterialEditarCateter"
										rendered="#{cat.idcateter ne 121 and cat.idcateter ne 94}"
										onclick="javascript:Richfaces.showModalPanel('editarMaterialCateter');">		
									 <h:graphicImage url="/img/iconos/editar.png"
										title="#{ms.editar }" width="16" height="16"
										style="border: 0px;" />
									 <f:setPropertyActionListener value="#{cat}"
		                            		target="#{controlMaterial.currentItemCateter}"/>
		                             <f:setPropertyActionListener value="#{cat}"
		                            		target="#{controlMaterial.currentItemCateterBackup}"/>
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_cat_modelo }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{cat.modelo }" />
							</h:panelGrid>
						</t:column>
						<t:column width="25%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_cat_fabricante }" />
							</f:facet>
							<h:panelGrid>
								<h:selectOneMenu value="#{cat.fabricante }" disabled="true">
									<f:selectItems value="#{controlMaterial.fabcat }" />											
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column width="10%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_cat_tipo }" />
							</f:facet>
							<h:panelGrid>
								<h:selectOneMenu value="#{cat.tipo }" disabled="true">
									<f:selectItem itemValue="0" itemLabel="" />
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_tipo_diag }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_tipo_abl }" />													
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column width="10%" headerstyleClass="left" rendered="false">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_cat_carac }" />
							</f:facet>
							<h:panelGrid>
								<h:selectOneMenu value="#{cat.tipodiagnostico }" disabled="true" rendered="#{cat.tipo eq 1}">
									<f:selectItem itemValue="0" itemLabel="" />
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_diag_curva_fija }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_diag_curva_defl }" />	
									<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_diag_circular }" />
									<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_diag_mapeo }" />												
								</h:selectOneMenu>
								<h:selectOneMenu value="#{cat.tipoablacion }" disabled="true" rendered="#{cat.tipo eq 2}">
									<f:selectItem itemValue="0" itemLabel="" />			
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_abl_4mm }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_abl_8mm }" />	
									<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_abl_punta_irr }" />
									<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_abl_crioabl }" />	
									<f:selectItem itemValue="5" itemLabel="#{ms.mat_cat_abl_criobalon }" />
									<f:selectItem itemValue="6" itemLabel="#{ms.mat_cat_abl_laser }" />
									<f:selectItem itemValue="7" itemLabel="#{ms.mat_cat_abl_10mm }" />
									<f:selectItem itemValue="9" itemLabel="#{ms.mat_cat_abl_irr_contacto }" />
									<f:selectItem itemValue="10" itemLabel="#{ms.mat_cat_abl_circular_rf_fasica }" />
									<f:selectItem itemValue="11" itemLabel="#{ms.mat_cat_abl_circular_rf_irr }" />
									<f:selectItem itemValue="8" itemLabel="#{ms.mat_cat_abl_otro }" />									
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_cat_num_elec }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{cat.numelecs }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_cat_tamanio }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{cat.tamano }F" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_cat_long }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{cat.longitud }cm" />
							</h:panelGrid>
						</t:column>
						<t:column width="40%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_estado }"/>
							</f:facet>
							<h:panelGrid>
								<a4j:commandLink reRender="tablaMatCat" actionListener="#{controlMaterial.activadesactivaCateter }" 
									onclick="javascript:Richfaces.showModalPanel('buscando');" 
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
									<h:graphicImage value="/img/aplicacion/icoCancelar.png" width="16" rendered="#{cat.activo eq 0 }" 
										height="16" style="border:0;" title="#{ms.inactivo }"/>
									<h:graphicImage value="/img/aplicacion/accept.png" width="16" rendered="#{cat.activo eq 1 }" 
									height="16" style="border:0;" title="#{ms.mat_activo }"/>				
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>						
						<f:facet name="footer">
								<rich:datascroller align="center" for="listamatcat" id="scrollMatCat"
									renderIfSinglePage="true" fastStep="3"
									page="#{controlMaterial.pagina_inicial_cat}">
									<f:facet name="first">
										<h:graphicImage url="/img/genericos/navegacion/first.png" />
									</f:facet>
									<f:facet name="last">
										<h:graphicImage url="/img/genericos/navegacion/last.png" />
									</f:facet>
									<f:facet name="fastrewind">
										<h:graphicImage url="/img/genericos/navegacion/frwd.png" />
									</f:facet>
									<f:facet name="fastforward">
										<h:graphicImage url="/img/genericos/navegacion/ffwd.png" />
									</f:facet>
									<f:facet name="previous">
										<h:graphicImage url="/img/genericos/navegacion/rwd.png" />
									</f:facet>
									<f:facet name="next">
										<h:graphicImage url="/img/genericos/navegacion/fwd.png" />
									</f:facet>
									<f:facet name="first_disabled">
										<h:graphicImage url="/img/genericos/navegacion/first.png" />
									</f:facet>
									<f:facet name="last_disabled">
										<h:graphicImage url="/img/genericos/navegacion/last.png" />
									</f:facet>
									<f:facet name="fastrewind_disabled">
										<h:graphicImage url="/img/genericos/navegacion/frwd.png" />
									</f:facet>
									<f:facet name="fastforward_disabled">
										<h:graphicImage url="/img/genericos/navegacion/ffwd.png" />
									</f:facet>
									<f:facet name="previous_disabled">
										<h:graphicImage url="/img/genericos/navegacion/rwd.png" />
									</f:facet>
									<f:facet name="next_disabled">
										<h:graphicImage url="/img/genericos/navegacion/fwd.png" />
									</f:facet>
								</rich:datascroller>
							</f:facet>
					</t:dataTable>
				</h:panelGrid>
			</h:panelGrid>
			<rich:simpleTogglePanel switchType="client" label="Insertar" opened="false">
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:outputLabel value="#{ms.mat_cat_datos_cat }"
						style="font-weight: bold;" />
					<a4j:commandLink reRender="tablaMatCat" rendered="false"
						actionListener="#{controlMaterial.addCateter }">
						<h:graphicImage value="/img/iconos/add.png" width="16"
							height="16" style="border:0;" title="Añadir cateter"/>				
					</a4j:commandLink>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" 
					columns="5" width="100%" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
						<h:outputLabel value="#{ms.mat_cat_modelo }"/>
						<h:inputText value="#{controlMaterial.nuevocat.modelo}"/>
						<h:outputLabel value="#{ms.mat_cat_referencia }"/>
						<h:inputText value="#{controlMaterial.nuevocat.referencia}"/>
					</h:panelGrid>
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
						<h:outputLabel value="#{ms.mat_cat_tipo }"/>
						<h:selectOneMenu value="#{controlMaterial.nuevocat.tipo}">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_tipo_diag }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_tipo_abl }" />	
							<a4j:support event="onchange" reRender="catAblacion,catDiagnostico" ajaxSingle="true"/>						
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.mat_cat_fabricante }"/>
						<h:selectOneMenu value="#{controlMaterial.nuevocat.fabricante}">
							<f:selectItems value="#{controlMaterial.fabcat }" />											
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
						<h:outputLabel value="#{ms.mat_cat_num_elec }"/>
						<rich:inputNumberSpinner value="#{controlMaterial.nuevocat.numelecs}" step="1"/>
						<h:outputLabel value="#{ms.mat_cat_long }"/>
						<h:inputText value="#{controlMaterial.nuevocat.longitud }" size="4"/>						
					</h:panelGrid>
					<h:panelGrid columnClasses="alignTop">
						<h:panelGrid columns="2" columnClasses="alignLeft,alignLeft">
							<h:outputLabel value="#{ms.mat_cat_tamanio }"/>
							<rich:inputNumberSpinner value="#{controlMaterial.nuevocat.tamano}" step="1"/>					
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="#{ms.mat_cat_dist_inter_elec }" title="#{ms.mat_cat_dist_inter_elec_title }"/>
							<h:inputText value="#{controlMaterial.nuevocat.distanciaelecs }" />
						</h:panelGrid>
					</h:panelGrid>								
				</h:panelGrid>
				<h:panelGrid columns="2" id="RefMaterialCat" >
					<h:outputLabel value="#{ms.mat_cat_gs128 }: "/>
					<h:inputText value="#{controlMaterial.nuevocat.gs128 }">
						<a4j:support event="onchange" reRender="RefMaterialCat" ajaxSingle="true"
							actionListener="#{controlMaterial.lecturaGs128Cateter}"/>
					</h:inputText>
				</h:panelGrid>
				<h:panelGrid id="catAblacion">
					<h:panelGrid rendered="#{controlMaterial.nuevocat.tipo eq 2}">
						<t:fieldset legend="#{ms.mat_cat_datos_abl }">
							<h:panelGrid columns="4">
								<h:panelGrid>
									<h:outputLabel value="#{ms.mat_cat_tipo }"/>
									<h:selectOneMenu value="#{controlMaterial.nuevocat.tipoablacion}">
										<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
										<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_abl_4mm }" />
										<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_abl_8mm }" />	
										<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_abl_punta_irr }" />
										<f:selectItem itemValue="9" itemLabel="#{ms.mat_cat_abl_irr_contacto }" />
										<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_abl_crioabl }" />	
										<f:selectItem itemValue="5" itemLabel="#{ms.mat_cat_abl_criobalon }" />
										<f:selectItem itemValue="6" itemLabel="#{ms.mat_cat_abl_laser }" />
										<f:selectItem itemValue="7" itemLabel="#{ms.mat_cat_abl_10mm }" />
										<f:selectItem itemValue="10" itemLabel="#{ms.mat_cat_abl_circular_rf_fasica }" />
										<f:selectItem itemValue="11" itemLabel="#{ms.mat_cat_abl_circular_rf_irr }" />
										<f:selectItem itemValue="8" itemLabel="#{ms.mat_cat_abl_otro }" />
										<a4j:support event="onchange" reRender="energiaAbl" ajaxSingle="true"
											actionListener="#{controlMaterial.cambiaTipoablacion }"/>										
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid>
									<h:outputLabel value="#{ms.mat_cat_energia }"/>
									<h:selectOneMenu value="#{controlMaterial.nuevocat.energia}" id="energiaAbl" disabled="true">
										<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
										<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_energia_rf }" />
										<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_energia_crioabl }" />	
										<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_energia_laser }" />
										<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_energia_ultrasonidos }" />																
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid>
									<h:outputLabel value="#{ms.mat_cat_abl_curva }"/>
									<h:selectOneMenu value="#{controlMaterial.nuevocat.tipocurva}">
										<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
										<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_abl_curva_uni }" />
										<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_abl_curva_bi }" />																		
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
						</t:fieldset>
					</h:panelGrid>					
				</h:panelGrid>
				<h:panelGrid id="catDiagnostico">					
					<h:panelGrid rendered="#{controlMaterial.nuevocat.tipo eq 1}">
						<t:fieldset legend="#{ms.mat_cat_datos_diag }">
							<h:panelGrid columns="4">
								<h:panelGrid>
									<h:outputLabel value="#{ms.mat_cat_tipo }"/>
									<h:selectOneMenu value="#{controlMaterial.nuevocat.tipodiagnostico}">
										<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
										<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_diag_curva_fija }" />
										<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_diag_curva_defl }" />	
										<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_diag_circular }" />
										<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_diag_mapeo }" />
										<a4j:support event="onchange" reRender="tipoCurvaDiagnostico" ajaxSingle="true"/>											
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid id="tipoCurvaDiagnostico">
									<h:panelGrid rendered="#{controlMaterial.nuevocat.tipodiagnostico eq 1 }">
										<h:outputLabel value="#{ms.mat_cat_diag_curva_tipo }"/>
										<h:selectOneMenu value="#{controlMaterial.nuevocat.tipocurva}">
											<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
											<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_diag_curva_josephson }" />
											<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_diag_curva_cournard }" />	
											<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_diag_curva_preformada }" />
											<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_diag_curva_damato }" />										
										</h:selectOneMenu>
									</h:panelGrid>								
								</h:panelGrid>								
							</h:panelGrid>
						</t:fieldset>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<a4j:commandLink reRender="tablaMatCat,panelMaterialCateter" 
						onclick="javascript:Richfaces.showModalPanel('buscando');"
						oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
						actionListener="#{controlMaterial.addCateter }">
						<h:graphicImage value="/img/iconos/guardar.png" width="16" height="16" style="border:0;" title="#{ms.aniadir }"/>				
					</a4j:commandLink>
					<h:outputLabel value="#{ms.guardar }"
						style="font-weight: bold;" />
				</h:panelGrid>
			</rich:simpleTogglePanel>
			
	</h:panelGrid>
	<rich:modalPanel id="editarMaterialCateter" autosized="true" zindex="2000" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.mat_cat_edit_title }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlMaterial.cambiarCateterIncluir }"
					reRender="tablaMatCat"
					onclick="javascript:Richfaces.hideModalPanel('editarMaterialCateter');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.confirmar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMaterial.cambiarCateterCancelar }"
					reRender="tablaMatCat"
					onclick="javascript:Richfaces.hideModalPanel('editarMaterialCateter');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('editarMaterialCateter')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="editarcateter" width="100%">
			<ui:include src="/ventanas/administracion/material/editarcateter.jsp" />
		</h:panelGrid>
	</rich:modalPanel>
	
</ui:composition>
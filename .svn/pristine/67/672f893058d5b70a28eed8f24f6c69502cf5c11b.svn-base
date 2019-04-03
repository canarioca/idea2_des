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
	
	<h:panelGrid id="panelMaterialEditarCateter">
		<h:panelGrid columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop" 
			columns="5" width="100%" >
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
				<h:outputLabel value="#{ms.mat_cat_modelo }"/>
				<h:inputText value="#{controlMaterial.currentItemCateter.modelo}"/>
				<h:outputLabel value="#{ms.mat_cat_referencia }"/>
				<h:inputText value="#{controlMaterial.currentItemCateter.referencia}"/>
			</h:panelGrid>
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
				<h:outputLabel value="#{ms.mat_cat_tipo }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemCateter.tipo}">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_tipo_diag }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_tipo_abl }" />	
					<a4j:support event="onchange" reRender="catAblacionEdit,catDiagnosticoEdit" ajaxSingle="true"/>						
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.mat_cat_fabricante }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemCateter.fabricante}">
					<f:selectItems value="#{controlMaterial.fabcat }" />											
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" id="RefMaterialCatEdit" columnClasses="alignTop,alignTop">
				<h:outputLabel value="#{ms.mat_cat_num_elec }"/>
				<rich:inputNumberSpinner value="#{controlMaterial.currentItemCateter.numelecs}" step="1"/>
				<h:outputLabel value="#{ms.mat_cat_long }"/>
				<h:inputText value="#{controlMaterial.currentItemCateter.longitud }" size="4"/>					
			</h:panelGrid>
			
			<h:panelGrid columnClasses="alignTop">
				<h:panelGrid columns="2" columnClasses="alignLeft,alignLeft">
					<h:outputLabel value="#{ms.mat_cat_tamanio }"/>
					<rich:inputNumberSpinner value="#{controlMaterial.currentItemCateter.tamano}" step="1"/>					
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.mat_cat_dist_inter_elec }" title="#{ms.mat_cat_dist_inter_elec_title }"/>
					<h:inputText value="#{controlMaterial.currentItemCateter.distanciaelecs }" />
				</h:panelGrid>
			</h:panelGrid>		
		</h:panelGrid>
		<h:panelGrid columns="3">
			<h:panelGrid id="catAblacionEdit">
				<h:panelGrid rendered="#{controlMaterial.currentItemCateter.tipo eq 2}">
					<t:fieldset legend="#{ms.mat_cat_datos_abl}">
						<h:panelGrid columns="4">
							<h:panelGrid>
								<h:outputLabel value="#{ms.mat_cat_tipo }"/>
								<h:selectOneMenu value="#{controlMaterial.currentItemCateter.tipoablacion}">
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
									<a4j:support event="onchange" reRender="energiaAblEdit" ajaxSingle="true"
										actionListener="#{controlMaterial.cambiaTipoablacionEdit }"/>										
								</h:selectOneMenu>
							</h:panelGrid>
							<h:panelGrid>
								<h:outputLabel value="#{ms.mat_cat_energia }"/>
								<h:selectOneMenu value="#{controlMaterial.currentItemCateter.energia}" id="energiaAblEdit" disabled="true">
									<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_energia_rf }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_energia_crioabl }" />	
									<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_energia_laser }" />
									<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_energia_ultrasonidos }" />																
								</h:selectOneMenu>
							</h:panelGrid>
							<h:panelGrid>
								<h:outputLabel value="#{ms.mat_cat_abl_curva }"/>
								<h:selectOneMenu value="#{controlMaterial.currentItemCateter.tipocurva}">
									<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_abl_curva_uni }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_abl_curva_bi }" />																		
								</h:selectOneMenu>
							</h:panelGrid>
						</h:panelGrid>
					</t:fieldset>
				</h:panelGrid>					
			</h:panelGrid>
			<h:panelGrid id="catDiagnosticoEdit">					
				<h:panelGrid rendered="#{controlMaterial.currentItemCateter.tipo eq 1}">
					<t:fieldset legend="#{ms.mat_cat_datos_diag}">
						<h:panelGrid columns="4">
							<h:panelGrid>
								<h:outputLabel value="#{ms.mat_cat_tipo }"/>
								<h:selectOneMenu value="#{controlMaterial.currentItemCateter.tipodiagnostico}">
									<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_diag_curva_fija }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_diag_curva_defl }" />	
									<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_diag_circular }" />
									<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_diag_mapeo }" />
									<a4j:support event="onchange" reRender="tipoCurvaDiagnosticoEdit" ajaxSingle="true"/>											
								</h:selectOneMenu>
							</h:panelGrid>
							<h:panelGrid id="tipoCurvaDiagnosticoEdit">
								<h:panelGrid rendered="#{controlMaterial.currentItemCateter.tipodiagnostico eq 2 }">
									<h:outputLabel value="#{ms.mat_cat_diag_curva_tipo }"/>
									<h:selectOneMenu value="#{controlMaterial.currentItemCateter.tipocurva}">
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
			<h:panelGrid>
				<t:fieldset legend="#{ms.mat_codigos_gs128 }">
					<h:panelGrid id="panGs128Cat">
						<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.mat_codigos_gs128_asociar }" style="font-weight: bold;" />
							<h:inputText value="#{controlMaterial.currentItemCateter.nuevocodigo }" size="16">
								<a4j:support event="onchange" reRender="panGs128Cat" ajaxSingle="true"
						 			actionListener="#{controlMaterial.lecturaGs128Cateter2}"/>
							</h:inputText>
							<a4j:commandLink reRender="panGs128Cat" ajaxSingle="true"
								actionListener="#{controlMaterial.addGs128Cateter }">	
								<h:graphicImage value="/img/iconos/add.png" width="16"
									height="16" style="border:0;" title="#{ms.mat_codigos_gs128_add }"/>				
							</a4j:commandLink>			
						</h:panelGrid>
						<h:outputLabel value="#{ms.mat_codigos_gs128_no_codes }" 
							rendered="#{empty controlMaterial.currentItemCateter.codigos }"/>
						<t:dataTable styleClass="hor-minimalist-b" var="item" rows="5" 
							rendered="#{not empty controlMaterial.currentItemCateter.codigos }"
							width="100%" value="#{controlMaterial.currentItemCateter.codigos }"
							binding="#{controlMaterial.bindingCateterGs128 }"
							id="listamatcatgs128">
							<t:column width="50%" headerstyleClass="left">
								<f:facet name="header">
									<h:outputText value="#{ms.mat_codigos_gs128_asociados }" />
								</f:facet>
								<h:panelGrid>
									<h:inputText value="#{item.codigo }" size="16" />
								</h:panelGrid>
							</t:column>
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="panGs128Cat"
									actionListener="#{controlMaterial.delGs128Cateter }">
									<h:graphicImage url="/img/iconos/minus.png"
										title="#{ms.eliminar }" width="16" height="16"
										style="border: 0px;" />
								</a4j:commandLink>
							</t:column>
						</t:dataTable>
					</h:panelGrid>
				</t:fieldset>
			</h:panelGrid>
		</h:panelGrid>		
	</h:panelGrid>
	
</ui:composition>
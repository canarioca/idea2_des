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
	
	<h:panelGrid id="panelMaterialEefCateter">
		<h:panelGrid columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop"
			columns="5" width="100%">
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
				<h:outputLabel value="#{ms.mat_cat_modelo }"/>
				<h:inputText value="#{controlEef.nuevocat.modelo}"/>
				<h:outputLabel value="#{ms.mat_cat_referencia }"/>
				<h:inputText value="#{controlEef.nuevocat.referencia}"/>
			</h:panelGrid>
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
				<h:outputLabel value="#{ms.mat_cat_tipo }"/>
				<h:selectOneMenu value="#{controlEef.nuevocat.tipo}">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_tipo_diag }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_tipo_abl }" />	
					<a4j:support event="onchange" reRender="catAblacionEef,catDiagnosticoEef" ajaxSingle="true"/>											
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.mat_cat_fabricante }"/>
				<h:selectOneMenu value="#{controlEef.nuevocat.fabricante}">
					<f:selectItems value="#{controlEef.fabcat }" />											
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columns="2" id="RefMaterialCatEef" columnClasses="alignTop,alignTop">
				<h:outputLabel value="#{ms.mat_cat_num_elec }"/>
				<rich:inputNumberSpinner value="#{controlEef.nuevocat.numelecs}" step="1"/>
				<h:outputLabel value="#{ms.mat_cat_long }"/>
				<h:inputText value="#{controlEef.nuevocat.longitud }" size="4"/>						
			</h:panelGrid>		
			<h:panelGrid columnClasses="alignTop">
				<h:panelGrid columns="2" columnClasses="alignLeft,alignLeft">
					<h:outputLabel value="#{ms.mat_cat_tamanio }"/>
					<rich:inputNumberSpinner value="#{controlEef.nuevocat.tamano}" step="1"/>					
				</h:panelGrid>
				<h:panelGrid columns="4">
					<h:outputLabel value="#{ms.mat_cat_dist_inter_elec }" title="#{ms.mat_cat_dist_inter_elec_title }"/>
					<h:inputText value="#{controlEef.nuevocat.distanciaelecs }" />
				</h:panelGrid>
			</h:panelGrid>	
		</h:panelGrid>
		<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.mat_cat_gs128 } "/>
			<h:inputText value="#{controlEef.nuevocat.gs128 }" disabled="true"/>
		</h:panelGrid>
		<h:panelGrid id="catAblacionEef">
			<h:panelGrid rendered="#{controlEef.nuevocat.tipo eq 2}">
				<t:fieldset legend="#{ms.mat_cat_datos_abl }">
					<h:panelGrid columns="4">
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_cat_tipo }"/>
							<h:selectOneMenu value="#{controlEef.nuevocat.tipoablacion}">
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
									actionListener="#{controlEef.cambiaTipoablacion }"/>										
							</h:selectOneMenu>
						</h:panelGrid>
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_cat_energia }"/>
							<h:selectOneMenu value="#{controlEef.nuevocat.energia}" id="energiaAbl" disabled="true">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_energia_rf }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_energia_crioabl }" />	
								<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_energia_laser }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_energia_ultrasonidos }" />																
							</h:selectOneMenu>
						</h:panelGrid>
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_cat_abl_curva }"/>
							<h:selectOneMenu value="#{controlEef.nuevocat.tipocurva}">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_abl_curva_uni }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_abl_curva_bi }" />																		
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
				</t:fieldset>
			</h:panelGrid>					
		</h:panelGrid>
		<h:panelGrid id="catDiagnosticoEef" >					
			<h:panelGrid rendered="#{controlEef.nuevocat.tipo eq 1}">
				<t:fieldset legend="#{ms.mat_cat_datos_diag }">
					<h:panelGrid columns="4">
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_cat_tipo }"/>
							<h:selectOneMenu value="#{controlEef.nuevocat.tipodiagnostico}">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_diag_curva_fija }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_diag_curva_defl }" />	
								<f:selectItem itemValue="3" itemLabel="#{ms.mat_cat_diag_circular }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.mat_cat_diag_mapeo }" />
								<a4j:support event="onchange" reRender="tipoCurvaDiagnosticoEef" ajaxSingle="true"/>											
							</h:selectOneMenu>
						</h:panelGrid>
						<h:panelGrid id="tipoCurvaDiagnosticoEef">
							<h:panelGrid rendered="#{controlEef.nuevocat.tipodiagnostico eq 1 }">
								<h:outputLabel value="#{ms.mat_cat_diag_curva_tipo }"/>
								<h:selectOneMenu value="#{controlEef.nuevocat.tipocurva}">
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
	</h:panelGrid>	
</ui:composition>
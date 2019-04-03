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
	
	<h:panelGrid id="panelMaterialEditarGeneradorImp">
		<h:panelGrid  
			columns="4" width="100%" >
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.mat_gen_modelo }"/>
				<h:inputText value="#{controlImplantes.nuevogen.modelo}"/>
				<h:outputLabel value="#{ms.mat_gen_nummodelo }"/>
				<h:inputText value="#{controlImplantes.nuevogen.numeromodelo}"/>
			</h:panelGrid>
			<h:panelGrid columns="2" id="RefMaterialEditarGenImp">
				<h:outputLabel value="#{ms.mat_gen_referencia }"/>
				<h:inputText value="#{controlImplantes.nuevogen.codigo}"/>
				<h:outputLabel value="#{ms.mat_gen_gs128 }"/>
				<h:inputText value="#{controlImplantes.nuevogen.gs128}" disabled="true">
					<a4j:support event="onchange" reRender="RefMaterialEditarGenImp" ajaxSingle="true"
						actionListener="#{controlImplantes.lecturaGs128Generador}"/>
				</h:inputText>						
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.mat_gen_tipo }"/>
				<h:selectOneMenu value="#{controlImplantes.nuevogen.tipo}">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tipo_1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tipo_2 }" />	
					<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tipo_3 }" />	
					<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tipo_4 }" />
					<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tipo_5 }" />
					<f:selectItem itemValue="6" itemLabel="#{ms.imp_dispositivos_tipo_6 }" />
					<a4j:support event="onchange" reRender="panGenImpConectores" ajaxSingle="true"/>											
				</h:selectOneMenu>
				<h:outputLabel value="Fabricante"/>
				<h:selectOneMenu value="#{controlImplantes.nuevogen.fabricante}">
					<f:selectItems value="#{controlImplantes.fabgen }" />											
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid>
				<h:panelGrid columns="2" columnClasses="alignLeft,alignLeft">
					<h:outputLabel value="Modo"/>
					<h:selectOneMenu value="#{controlImplantes.nuevogen.modo}">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="" />
						<f:selectItem itemLabel="AAI" itemValue="AAI" />
						<f:selectItem itemLabel="AAIR" itemValue="AAIR" />	
						<f:selectItem itemLabel="SSI" itemValue="SSI" />
						<f:selectItem itemLabel="SSIR" itemValue="SSIR" />
						<f:selectItem itemLabel="VVI" itemValue="VVI" />
						<f:selectItem itemLabel="VVIR" itemValue="VVIR" />
						<f:selectItem itemLabel="VDD" itemValue="VDD" />
						<f:selectItem itemLabel="VDDR" itemValue="VDDR" />
						<f:selectItem itemLabel="DDD" itemValue="DDD" />
						<f:selectItem itemLabel="DDDR" itemValue="DDDR" />
						<f:selectItem itemLabel="DDDRV" itemValue="DDDRV" />										
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid columns="4">
					<h:selectBooleanCheckbox value="#{controlImplantes.nuevogen.rfb}"/>		
					<h:outputLabel value="#{ms.mat_gen_rf }"/>
					<h:selectBooleanCheckbox value="#{controlImplantes.nuevogen.mrib}"/>							
					<h:outputLabel value="#{ms.mat_gen_mri }"/>
				</h:panelGrid>
			</h:panelGrid>					
		</h:panelGrid>
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
			<h:panelGrid id="panGenImpConectores">
				<h:outputLabel value="#{ms.mat_gen_add_conect_msg_1 }"
					style="font-weight: bold;color:#EA9D65;font-size:12px;" 
					rendered="#{controlImplantes.nuevogen.tipo eq null or controlImplantes.nuevogen.tipo eq 0}"/>
				<t:fieldset legend="#{ms.mat_gen_datos_conec_baja_energ }"
					rendered="#{controlImplantes.nuevogen.tipo eq 1 or controlImplantes.nuevogen.tipo eq 2 or controlImplantes.nuevogen.tipo eq 3 or controlImplantes.nuevogen.tipo eq 4 or controlImplantes.nuevogen.tipo eq 6}">
					<h:panelGrid columns="4">
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_gen_conec_ad }"/>
							<h:selectOneMenu value="#{controlImplantes.nuevogen.conectorad}">
								<f:selectItems value="#{controlImplantes.conelec }" />											
							</h:selectOneMenu>
							<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
								<h:panelGrid columns="2">
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_volt }: "/>
									<h:inputText value="#{controlImplantes.nuevogen.genfab.voltajead }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_durimp }: "/>
									<h:inputText value="#{controlImplantes.nuevogen.genfab.durimpad }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_sens }: "/>
									<h:inputText value="#{controlImplantes.nuevogen.genfab.sensibad }" size="4"/>
								</h:panelGrid>
							</t:fieldset>
						</h:panelGrid>
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_gen_conec_vd }"/>
							<h:selectOneMenu value="#{controlImplantes.nuevogen.conectorvd}">
								<f:selectItems value="#{controlImplantes.conelec }" />											
							</h:selectOneMenu>
							<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
								<h:panelGrid columns="2">
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_volt }: "/>
									<h:inputText value="#{controlImplantes.nuevogen.genfab.voltajevd }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_durimp }: "/>
									<h:inputText value="#{controlImplantes.nuevogen.genfab.durimpvd }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_sens }: "/>
									<h:inputText value="#{controlImplantes.nuevogen.genfab.sensibvd }" size="4"/>
								</h:panelGrid>
							</t:fieldset>
						</h:panelGrid>
						<h:panelGrid rendered="#{controlImplantes.nuevogen.tipo eq 3 or controlImplantes.nuevogen.tipo eq 4}">
							<h:outputLabel value="#{ms.mat_gen_conec_vi }"/>
							<h:selectOneMenu value="#{controlImplantes.nuevogen.conectorvi}">
								<f:selectItems value="#{controlImplantes.conelec }" />											
							</h:selectOneMenu>
							<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
								<h:panelGrid columns="2">
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_volt }: "/>
									<h:inputText value="#{controlImplantes.nuevogen.genfab.voltajevi }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_durimp }: "/>
									<h:inputText value="#{controlImplantes.nuevogen.genfab.durimpvi }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_sens }: "/>
									<h:inputText value="#{controlImplantes.nuevogen.genfab.sensibvi }" size="4"/>
								</h:panelGrid>
							</t:fieldset>
						</h:panelGrid>		
					</h:panelGrid>
				</t:fieldset>
				<t:fieldset legend="#{ms.mat_gen_datos_conec_alta_energ }" rendered="#{controlImplantes.nuevogen.tipo eq 2 or controlImplantes.nuevogen.tipo eq 4 or controlImplantes.nuevogen.tipo eq 6}">
					<h:panelGrid columns="2">
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_gen_conec_vd2 }"/>
							<h:selectOneMenu value="#{controlImplantes.nuevogen.conectorVd2}">
								<f:selectItems value="#{controlImplantes.conelec }" />											
							</h:selectOneMenu>
						</h:panelGrid>
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_gen_conec_vcs }"/>
							<h:selectOneMenu value="#{controlImplantes.nuevogen.conectorvcs}">
								<f:selectItems value="#{controlImplantes.conelec }" />											
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
				</t:fieldset>
			</h:panelGrid>
			<h:panelGrid>
				<h:panelGrid rendered="#{controlImplantes.nuevogen.tipo eq null or controlImplantes.nuevogen.tipo eq 0}">
					<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
						<h:panelGrid columns="2">
							<h:outputLabel value="#{ms.mat_gen_valores_fabrica_frec }: "/>
							<h:inputText value="#{controlImplantes.nuevogen.genfab.frecuencia }" size="3"/>
							<h:outputLabel value="#{ms.mat_gen_valores_fabrica_iav_est }: " rendered="false"/>
							<h:inputText value="#{controlImplantes.nuevogen.genfab.iavest }" size="4" rendered="false"/>
							<h:outputLabel value="#{ms.mat_gen_valores_fabrica_iav_det }: " rendered="false"/>
							<h:inputText value="#{controlImplantes.nuevogen.genfab.iavdet }" size="4" rendered="false"/>
						</h:panelGrid>
					</t:fieldset>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.mat_gen_idrx }"/>
					<h:inputText value="#{controlImplantes.nuevogen.idrx}"/>	
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		
	</h:panelGrid>
	
</ui:composition>
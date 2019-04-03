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
	
	<h:panelGrid id="panelMaterialEditarGenerador">
		<h:panelGrid  
			columns="4" width="100%" >
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.mat_gen_modelo }"/>
				<h:inputText value="#{controlMaterial.currentItemGenerador.modelo}"/>
				<h:outputLabel value="#{ms.mat_gen_nummodelo }"/>
				<h:inputText value="#{controlMaterial.currentItemGenerador.numeromodelo}"/>
			</h:panelGrid>
			<h:panelGrid columns="2" id="RefMaterialEditarGen">	
				<h:outputLabel value="#{ms.mat_gen_referencia }"/>
				<h:inputText value="#{controlMaterial.currentItemGenerador.codigo}"/>
				<h:outputLabel value="#{ms.mat_gen_modo }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemGenerador.modo}">
					<f:selectItems value="#{controlMaterial.modogen }" />											
				</h:selectOneMenu>					
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.mat_gen_tipo }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemGenerador.tipo}">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tipo_1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tipo_2 }" />	
					<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tipo_3 }" />	
					<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tipo_4 }" />
					<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tipo_5 }" />
					<f:selectItem itemValue="6" itemLabel="#{ms.imp_dispositivos_tipo_6 }" />
					<a4j:support event="onchange" reRender="panGenEditConectores" ajaxSingle="true"/>										
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.mat_gen_fabricante }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemGenerador.fabricante}">
					<f:selectItems value="#{controlMaterial.fabgen }" />											
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid columnClasses="alignTop">
				<h:panelGrid columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
					<h:selectBooleanCheckbox value="#{controlMaterial.currentItemGenerador.rfb}"/>		
					<h:outputLabel value="#{ms.mat_gen_rf }"/>
					<h:selectBooleanCheckbox value="#{controlMaterial.currentItemGenerador.mrib}"/>							
					<h:outputLabel value="#{ms.mat_gen_mri }"/>
				</h:panelGrid>
			</h:panelGrid>			
		</h:panelGrid>
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
			<h:panelGrid id="panGenEditConectores">
				<h:outputLabel value="#{ms.mat_gen_add_conect_msg_1 }"
					style="font-weight: bold;color:#EA9D65;font-size:12px;" 
					rendered="#{controlMaterial.currentItemGenerador.tipo eq null or controlMaterial.currentItemGenerador.tipo eq 0}"/>
				<t:fieldset legend="#{ms.mat_gen_datos_conec_baja_energ }" 
					rendered="#{controlMaterial.currentItemGenerador.tipo eq 1 or controlMaterial.currentItemGenerador.tipo eq 2 or controlMaterial.currentItemGenerador.tipo eq 3 or controlMaterial.currentItemGenerador.tipo eq 4 or controlMaterial.currentItemGenerador.tipo eq 6}">
					<h:panelGrid columns="4">
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_gen_conec_ad }"/>
							<h:selectOneMenu value="#{controlMaterial.currentItemGenerador.conectorad}">
								<f:selectItems value="#{controlMaterial.conelec }" />											
							</h:selectOneMenu>
							<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
								<h:panelGrid columns="2">
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_volt }: "/>
									<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.voltajead }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_durimp }: "/>
									<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.durimpad }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_sens }: "/>
									<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.sensibad }" size="4"/>
								</h:panelGrid>
							</t:fieldset>
						</h:panelGrid>
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_gen_conec_vd }"/>
							<h:selectOneMenu value="#{controlMaterial.currentItemGenerador.conectorvd}">
								<f:selectItems value="#{controlMaterial.conelec }" />											
							</h:selectOneMenu>
							<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
								<h:panelGrid columns="2">
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_volt }: "/>
									<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.voltajevd }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_durimp }: "/>
									<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.durimpvd }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_sens }: "/>
									<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.sensibvd }" size="4"/>
								</h:panelGrid>
							</t:fieldset>
						</h:panelGrid>
						<h:panelGrid rendered="#{controlMaterial.currentItemGenerador.tipo eq 3 or controlMaterial.currentItemGenerador.tipo eq 4}">
							<h:outputLabel value="#{ms.mat_gen_conec_vi }"/>
							<h:selectOneMenu value="#{controlMaterial.currentItemGenerador.conectorvi}">
								<f:selectItems value="#{controlMaterial.conelec }" />											
							</h:selectOneMenu>
							<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
								<h:panelGrid columns="2">
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_volt }: "/>
									<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.voltajevi }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_durimp }: "/>
									<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.durimpvi }" size="4"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_sens }: "/>
									<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.sensibvi }" size="4"/>
								</h:panelGrid>
							</t:fieldset>
						</h:panelGrid>
					</h:panelGrid>
				</t:fieldset>
				<t:fieldset legend="#{ms.mat_gen_datos_conec_alta_energ }" rendered="#{controlMaterial.currentItemGenerador.tipo eq 2 or controlMaterial.currentItemGenerador.tipo eq 4 or controlMaterial.currentItemGenerador.tipo eq 6}">
					<h:panelGrid columns="2">
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_gen_conec_vd2 }"/>
							<h:selectOneMenu value="#{controlMaterial.currentItemGenerador.conectorVd2}">
								<f:selectItems value="#{controlMaterial.conelec }" />											
							</h:selectOneMenu>
						</h:panelGrid>
						<h:panelGrid>
							<h:outputLabel value="#{ms.mat_gen_conec_vcs }"/>
							<h:selectOneMenu value="#{controlMaterial.currentItemGenerador.conectorvcs}">
								<f:selectItems value="#{controlMaterial.conelec }" />											
							</h:selectOneMenu>
						</h:panelGrid>
					</h:panelGrid>
				</t:fieldset>
			</h:panelGrid>
			<h:panelGrid>
				<h:panelGrid>
					<h:panelGrid>
						<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
							<h:panelGrid columns="2">
								<h:outputLabel value="#{ms.mat_gen_valores_fabrica_frec }: "/>
								<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.frecuencia }" size="3"/>
								<h:outputLabel value="#{ms.mat_gen_valores_fabrica_iav_est }: " rendered="false"/>
								<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.iavest }" size="4" rendered="false"/>
								<h:outputLabel value="#{ms.mat_gen_valores_fabrica_iav_det }: " rendered="false"/>
								<h:inputText value="#{controlMaterial.currentItemGenerador.genfab.iavdet }" size="4" rendered="false"/>
							</h:panelGrid>
						</t:fieldset>
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.mat_gen_idrx }"/>
						<h:inputText value="#{controlMaterial.currentItemGenerador.idrx}"/>						
					</h:panelGrid>
				</h:panelGrid>				
				<h:panelGrid>
					<t:fieldset legend="#{ms.mat_codigos_gs128 }">
						<h:panelGrid id="panGs128Gen">
							<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
								<h:outputLabel value="#{ms.mat_codigos_gs128_asociar }" style="font-weight: bold;" />
								<h:inputText value="#{controlMaterial.currentItemGenerador.nuevocodigo }" size="16">
									<a4j:support event="onchange" reRender="panGs128Gen" ajaxSingle="true"
							 			actionListener="#{controlMaterial.lecturaGs128Generador2}"/>
								</h:inputText>
								<a4j:commandLink reRender="panGs128Gen" ajaxSingle="true"
									actionListener="#{controlMaterial.addGs128Generador }">	
									<h:graphicImage value="/img/iconos/add.png" width="16"
										height="16" style="border:0;" title="#{ms.mat_codigos_gs128_add }"/>				
								</a4j:commandLink>			
							</h:panelGrid>
							<h:outputLabel value="#{ms.mat_codigos_gs128_no_codes }" 
								rendered="#{empty controlMaterial.currentItemGenerador.codigos }"/>
							<t:dataTable styleClass="hor-minimalist-b" var="item" rows="5" 
								rendered="#{not empty controlMaterial.currentItemGenerador.codigos }"
								width="100%" value="#{controlMaterial.currentItemGenerador.codigos }"
								binding="#{controlMaterial.bindingGeneradorGs128 }"
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
									<a4j:commandLink reRender="panGs128Gen"
										actionListener="#{controlMaterial.delGs128Generador }">
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
		
	</h:panelGrid>
	
</ui:composition>
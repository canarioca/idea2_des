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
	
	<h:panelGrid id="panelMaterialRegEv" width="100%">
		<h:panelGrid columnClasses="alignTop,alignTop,alignTop" width="100%">
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0" >
				<h:outputLabel value="#{ms.mat_tab_regev_cons_title }"
					style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaMatRegEv"
					actionListener="#{controlMaterial.consultarRegEventos }"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage value="/img/iconos/buscar.png" width="16"
						height="16" style="border:0;" title="#{ms.buscar }"/>				
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMaterial.limpiarRegistradores}"
					style="align:right;" reRender="panelMaterialRegEv"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage style="align:right;border:none;"
						styleClass="hvn_enlImagen" title="#{ms.limpiar }"
						width="16" height="16" url="/img/iconos/limpia.png"/>
				</a4j:commandLink>			
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" 
				columns="4" width="100%">
					<h:outputLabel value="#{ms.mat_regev_modelo }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.mat_regev_referencia }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.mat_regev_fabricante }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.mat_activo }" style="font-weight: bold;"/>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText value="#{controlMaterial.reg.modelo}"/>
					</h:panelGrid>	
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:inputText value="#{controlMaterial.reg.referencia}"/>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlMaterial.reg.fabricante}">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="MEDTRONIC" itemLabel="#{ms.mat_regev_fabricante_med }" />
							<f:selectItem itemValue="SAINT JUDE MEDICAL" itemLabel="#{ms.mat_regev_fabricante_sjm }" />
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlMaterial.reg.activo}">
							<f:selectItem itemValue="2" itemLabel="#{ms.mat_activo_todos }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.mat_activo_si }" />
							<f:selectItem itemValue="0" itemLabel="#{ms.mat_activo_no }" />												
						</h:selectOneMenu>
					</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid width="100%">
			<h:panelGrid id="tablaMatRegEv" width="100%">
				<h:panelGrid columns="3" columnClasses="alignRight">
					<h:outputLabel value="#{ms.mat_res_msg_1 }: " style="font-weight: bold;" 
						rendered="#{controlMaterial.regs ne null }"/>
					<h:outputLabel value="#{controlMaterial.totalreg } #{ms.mat_res_msg_2 }." 
						style="font-weight: bold;color:#E17009" rendered="#{controlMaterial.regs ne null }"/>
					<t:commandLink actionListener="#{controlMaterial.exportarRegEventos}" target="_blank" title="#{ms.exportar_excel }"
						rendered="#{controlMaterial.regs ne null }">
						<h:graphicImage value="/img/iconos/excel_icon.png" width="16" height="16" style="border: 0px;"/>
					</t:commandLink>
				</h:panelGrid>
				<t:dataTable styleClass="hor-minimalist-b" var="reg" rows="5"
						width="100%" value="#{controlMaterial.regs }"
						binding="#{controlMaterial.bindingRegEventos }"
						id="listamatreg">
						<t:column width="5%" headerstyleClass="left">
							<h:panelGrid>
								<a4j:commandLink reRender="tablaMatRegEv,panelMaterialEditarRegEv"
									rendered="true"
									onclick="javascript:Richfaces.showModalPanel('editarMaterialRegEv');">		
									 <h:graphicImage url="/img/iconos/editar.png"
										title="#{ms.editar }" width="16" height="16"
										style="border: 0px;" />
									 <f:setPropertyActionListener value="#{reg}"
		                            	target="#{controlMaterial.currentItemRegistrador}"/>
		                             <f:setPropertyActionListener value="#{reg}"
		                            	target="#{controlMaterial.currentItemRegistradorBackup}"/>
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>
						<t:column width="50%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_regev_modelo }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{reg.modelo }" />
							</h:panelGrid>
						</t:column>
						<t:column width="25%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_regev_fabricante }" />
							</f:facet>
							<h:panelGrid>
								<h:selectOneMenu value="#{reg.fabricante }" disabled="true">
									<f:selectItem itemValue="0" itemLabel="" />
									<f:selectItem itemValue="MEDTRONIC" itemLabel="#{ms.mat_regev_fabricante_med }" />
									<f:selectItem itemValue="SAINT JUDE MEDICAL" itemLabel="#{ms.mat_regev_fabricante_sjm }" />											
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_regev_referencia }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{reg.referencia }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_regev_rf }" />
							</f:facet>
							<h:panelGrid>
								<h:selectOneMenu value="#{reg.rf }" disabled="true">
									<f:selectItem itemValue="0" itemLabel="#{ms.mat_regev_rf_op0 }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_regev_rf_op1 }" />												
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_regev_mri }" />
							</f:facet>
							<h:panelGrid>
								<h:selectOneMenu value="#{reg.mri }" disabled="true">
									<f:selectItem itemValue="0" itemLabel="#{ms.mat_regev_mri_op0 }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_regev_mri_op1 }" />												
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						
						<t:column width="40%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_estado }"/>
							</f:facet>
							<h:panelGrid>
								<a4j:commandLink reRender="tablaMatRegEv" 
									actionListener="#{controlMaterial.activadesactivaRegistrador }" 
									onclick="javascript:Richfaces.showModalPanel('buscando');" 
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
									<h:graphicImage value="/img/aplicacion/icoCancelar.png" width="16" rendered="#{reg.activo eq 0 }" 
										height="16" style="border:0;" title="#{ms.inactivo }"/>
									<h:graphicImage value="/img/aplicacion/accept.png" width="16" rendered="#{reg.activo eq 1 }" 
									height="16" style="border:0;" title="#{ms.mat_activo }"/>				
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>						
						<f:facet name="footer">
								<rich:datascroller align="center" for="listamatreg" id="scrollMatReg"
									renderIfSinglePage="true" fastStep="3"
									page="#{controlMaterial.pagina_inicial_reg}">
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
			<rich:simpleTogglePanel switchType="client" label="#{ms.insertar }" opened="false">
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:outputLabel value="#{ms.mat_regev_datos_regev }"
						style="font-weight: bold;" />
					<a4j:commandLink reRender="tablaMatRegEv" rendered="false"
						actionListener="#{controlMaterial.addRegistrador }">
						<h:graphicImage value="/img/iconos/add.png" width="16"
							height="16" style="border:0;" title="Añadir registrador de eventos"/>				
					</a4j:commandLink>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" 
					columns="4" width="100%" >
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.mat_regev_modelo }"/>
						<h:inputText value="#{controlMaterial.nuevoreg.modelo}"/>
						<h:outputLabel value="#{ms.mat_regev_referencia }"/>
						<h:inputText value="#{controlMaterial.nuevoreg.referencia}"/>
					</h:panelGrid>
					<h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="#{ms.mat_regev_fabricante }"/>
							<h:selectOneMenu value="#{controlMaterial.nuevoreg.fabricante}">
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="MEDTRONIC" itemLabel="#{ms.mat_regev_fabricante_med }" />
								<f:selectItem itemValue="SAINT JUDE MEDICAL" itemLabel="#{ms.mat_regev_fabricante_sjm }" />
							</h:selectOneMenu>					
						</h:panelGrid>
						<h:panelGrid columns="2" id="RefMaterialReg">
							<h:outputLabel value="#{ms.mat_regev_gs128 }"/>
							<h:inputText value="#{controlMaterial.nuevoreg.nuevocodigo}">
								<a4j:support event="onchange" reRender="RefMaterialReg" ajaxSingle="true"
										actionListener="#{controlMaterial.lecturaGs128Registrador}"/>
							</h:inputText>						
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid columns="4">
						<h:selectBooleanCheckbox value="#{controlMaterial.nuevoreg.rf_bol}"/>		
						<h:outputLabel value="#{ms.mat_regev_rf }"/>
						<h:selectBooleanCheckbox value="#{controlMaterial.nuevoreg.mri_bol}"/>							
						<h:outputLabel value="#{ms.mat_regev_mri }"/>
					</h:panelGrid>	
				</h:panelGrid>
				<h:panelGrid columns="2">
					<a4j:commandLink reRender="tablaMatRegEv,panelMaterialRegEv" 
						onclick="javascript:Richfaces.showModalPanel('buscando');"
						oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
						actionListener="#{controlMaterial.addRegistrador }">
						<h:graphicImage value="/img/iconos/guardar.png" width="16" height="16" 
							style="border:0;" title="#{ms.guardar }"/>				
					</a4j:commandLink>
					<h:outputLabel value="#{ms.guardar }"
						style="font-weight: bold;" />
				</h:panelGrid>
		</rich:simpleTogglePanel>
			
	</h:panelGrid>
	<rich:modalPanel id="editarMaterialRegEv" autosized="true" zindex="2000" minWidth="450">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.mat_regev_edit_title }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlMaterial.cambiarRegEvIncluir }"
					reRender="tablaMatRegEv"
					onclick="javascript:Richfaces.hideModalPanel('editarMaterialRegEv');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.confirmar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMaterial.cambiarRegEvCancelar }"
					reRender="tablaMatRegEv"
					onclick="javascript:Richfaces.hideModalPanel('editarMaterialRegEv');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('editarMaterialRegEv')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="editarregev" width="100%">
			<ui:include src="/ventanas/administracion/material/editarregeventos.jsp" />
		</h:panelGrid>
	</rich:modalPanel>
	
</ui:composition>
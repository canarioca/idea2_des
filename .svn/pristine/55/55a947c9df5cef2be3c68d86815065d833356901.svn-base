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
	
	<h:panelGrid id="panelMaterialElectrodo" width="100%">
		<h:panelGrid columnClasses="alignTop,alignTop,alignTop" width="100%">
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.mat_tab_ele_cons_title }"
					style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaMatElec"
					actionListener="#{controlMaterial.consultarElectrodos }"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage value="/img/iconos/buscar.png" width="16"
						height="16" style="border:0;" title="#{ms.buscar }"/>				
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMaterial.limpiarElectrodos}"
					style="align:right;" reRender="panelMaterialElectrodo"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage style="align:right;border:none;"
						styleClass="hvn_enlImagen" title="#{ms.limpiar }"
						width="16" height="16" url="/img/iconos/limpia.png"/>
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" 
				width="100%" columns="4">
				<h:outputLabel value="#{ms.mat_ele_modelo }" style="font-weight: bold;"/>
				<h:outputLabel value="#{ms.mat_ele_referencia }" style="font-weight: bold;"/>
				<h:outputLabel value="#{ms.mat_ele_fabricante }" style="font-weight: bold;"/>
				<h:outputLabel value="#{ms.mat_activo }" style="font-weight: bold;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputText value="#{controlMaterial.el.modelo}"/>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputText value="#{controlMaterial.el.codigo}"/>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlMaterial.el.fabricante}">
						<f:selectItems value="#{controlMaterial.fabelec }" />											
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlMaterial.el.activo}">
						<f:selectItem itemValue="2" itemLabel="#{ms.mat_activo_todos }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.mat_activo_si }" />
						<f:selectItem itemValue="0" itemLabel="#{ms.mat_activo_no }" />												
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid width="100%">
			<h:panelGrid id="tablaMatElec" width="100%">
				<h:panelGrid columns="3" columnClasses="alignRight">
					<h:outputLabel value="#{ms.mat_res_msg_1 }: " style="font-weight: bold;"
						rendered="#{controlMaterial.electrodos ne null }"/>
					<h:outputLabel value="#{controlMaterial.totalelec } #{ms.mat_res_msg_2 }." 
						style="font-weight: bold;color:#E17009" rendered="#{controlMaterial.electrodos ne null }"/>
					<t:commandLink actionListener="#{controlMaterial.exportarElectrodos}" target="_blank" title="#{ms.exportar_excel }"
						rendered="#{controlMaterial.electrodos ne null }">
						<h:graphicImage value="/img/iconos/excel_icon.png" width="16" height="16" style="border: 0px;"/>
					</t:commandLink>
				</h:panelGrid>
				<t:dataTable styleClass="hor-minimalist-b" var="elec" rows="5"
						width="100%" value="#{controlMaterial.electrodos }"
						binding="#{controlMaterial.bindingElectrodo }"
						id="listamatelectrodo">
						<t:column width="5%" headerstyleClass="left">
							<h:panelGrid>
								<a4j:commandLink reRender="tablaMatElec,panelMaterialEditarElectrodo"
									rendered="#{elec.idelectrodo ne 193 and  elec.idelectrodo ne 352}"
									onclick="javascript:Richfaces.showModalPanel('editarMaterialElectrodo');">		
									 <h:graphicImage url="/img/iconos/editar.png"
										title="#{ms.editar }" width="16" height="16"
										style="border: 0px;" />
									 <f:setPropertyActionListener value="#{elec}"
		                            	target="#{controlMaterial.currentItemElectrodo}"/>
		                             <f:setPropertyActionListener value="#{elec}"
		                            	target="#{controlMaterial.currentItemElectrodoBackup}"/>
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>
						<t:column width="50%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_ele_modelo }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{elec.modelo }" />
							</h:panelGrid>
						</t:column>
						<t:column width="15%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_ele_fabricante }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{elec.fabricante }" />
							</h:panelGrid>
						</t:column>
						<t:column width="10%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_ele_polaridad }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{elec.polaridad }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_ele_fijacion }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{elec.fijacion }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_ele_bobina }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{elec.bobina }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_ele_conector }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{elec.conector}" />
							</h:panelGrid>
						</t:column>					
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_ele_referencia }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{elec.codigo }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_ele_num_modelo }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{elec.numeromodelo }" />
							</h:panelGrid>
						</t:column>
						<t:column width="40%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_estado }"/>
							</f:facet>
							<h:panelGrid>
								<a4j:commandLink reRender="tablaMatElec" actionListener="#{controlMaterial.activadesactivaElectrodo }" 
									onclick="javascript:Richfaces.showModalPanel('buscando');" 
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
									<h:graphicImage value="/img/aplicacion/icoCancelar.png" width="16" rendered="#{elec.activo eq 0 }" 
										height="16" style="border:0;" title="#{ms.inactivo }"/>
									<h:graphicImage value="/img/aplicacion/accept.png" width="16" rendered="#{elec.activo eq 1 }" 
									height="16" style="border:0;" title="#{ms.mat_activo }"/>				
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>
						<f:facet name="footer">
							<rich:datascroller align="center" for="listamatelectrodo" id="scrollMatElec"
								renderIfSinglePage="true" fastStep="3"
								page="#{controlMaterial.pagina_inicial_elec}">
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
					<h:outputLabel value="#{ms.mat_ele_datos_ele }"
						style="font-weight: bold;" />
					<a4j:commandLink reRender="tablaMatElec" rendered="false"
						actionListener="#{controlMaterial.addElectrodo }">
						<h:graphicImage value="/img/iconos/add.png" width="16"
							height="16" style="border:0;" title="Añadir electrodo"/>				
					</a4j:commandLink>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" 
					columns="4" width="100%" >
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.mat_ele_modelo }"/>
						<h:inputText value="#{controlMaterial.nuevoel.modelo}"/>
						<h:outputLabel value="#{ms.mat_ele_fabricante }"/>
						<h:selectOneMenu value="#{controlMaterial.nuevoel.fabricante}">
							<f:selectItems value="#{controlMaterial.fabelec }" />											
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.mat_ele_referencia }"/>
						<h:inputText value="#{controlMaterial.nuevoel.codigo}"/>
						<h:outputLabel value="#{ms.mat_ele_gs128 }"/>
						<h:inputText value="#{controlMaterial.nuevoel.gs128}" id="RefMaterialElec">
							<a4j:support event="onchange" reRender="RefMaterialElec" ajaxSingle="true"
								actionListener="#{controlMaterial.lecturaGs128Electrodo}"/>
						</h:inputText>
					</h:panelGrid>
					<h:panelGrid columns="2">	
						<h:outputLabel value="#{ms.mat_ele_polaridad }"/>
						<h:selectOneMenu value="#{controlMaterial.nuevoel.polaridad}">
							<f:selectItems value="#{controlMaterial.polelec }" />												
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.mat_ele_conector }"/>
						<h:selectOneMenu value="#{controlMaterial.nuevoel.conector}">
							<f:selectItems value="#{controlMaterial.conelec }" />												
						</h:selectOneMenu>
						<rich:spacer/>
						<rich:spacer/>
					</h:panelGrid>
					<h:panelGrid columns="2">	
						<h:outputLabel value="#{ms.mat_ele_fijacion }"/>
						<h:selectOneMenu value="#{controlMaterial.nuevoel.fijacion}">
							<f:selectItems value="#{controlMaterial.fijaelec }" />											
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.mat_ele_bobina }"/>
						<h:selectOneMenu value="#{controlMaterial.nuevoel.bobina}">
							<f:selectItems value="#{controlMaterial.bobelec }" />												
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<a4j:commandLink reRender="tablaMatElec,panelMaterialElectrodo"
						onclick="javascript:Richfaces.showModalPanel('buscando');"
						oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
						actionListener="#{controlMaterial.addElectrodo }">
						<h:graphicImage value="/img/iconos/guardar.png" width="16"
							height="16" style="border:0;" title="#{ms.guardar }"/>				
					</a4j:commandLink>
					<h:outputLabel value="#{ms.guardar }"
						style="font-weight: bold;" />
				</h:panelGrid>
			</rich:simpleTogglePanel>
			
				
	</h:panelGrid>
	<rich:modalPanel id="editarMaterialElectrodo" autosized="true" zindex="2000" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.mat_ele_edit_title }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlMaterial.cambiarElectrodoIncluir }"
					reRender="tablaMatElec"
					onclick="javascript:Richfaces.hideModalPanel('editarMaterialElectrodo');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.confirmar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMaterial.cambiarElectrodoCancelar }"
					reRender="tablaMatElec"
					onclick="javascript:Richfaces.hideModalPanel('editarMaterialElectrodo');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('editarMaterialElectrodo')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="editarelectrodo" width="100%">
			<ui:include src="/ventanas/administracion/material/editarelectrodo.jsp" />
		</h:panelGrid>
	</rich:modalPanel>
</ui:composition>
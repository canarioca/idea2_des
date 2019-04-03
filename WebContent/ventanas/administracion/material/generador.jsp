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
	
	<h:panelGrid id="panelMaterialGenerador" width="100%">
		<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.mat_tab_gen_cons_title }"
					style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaMatGen"
					actionListener="#{controlMaterial.consultarGenerador }"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage value="/img/iconos/buscar.png" width="16"
						height="16" style="border:0;" title="#{ms.buscar }"/>				
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMaterial.limpiarGeneradores}"
					style="align:right;" reRender="panelMaterialGenerador"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage style="align:right;border:none;"
						styleClass="hvn_enlImagen" title="#{ms.limpiar }"
						width="16" height="16" url="/img/iconos/limpia.png"/>
				</a4j:commandLink>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" 
				columns="5" width="100%">
				<h:outputLabel value="#{ms.mat_gen_modelo }" style="font-weight: bold;"/>
				<h:outputLabel value="#{ms.mat_gen_referencia }" style="font-weight: bold;"/>
				<h:outputLabel value="#{ms.mat_gen_tipo }" style="font-weight: bold;"/>
				<h:outputLabel value="#{ms.mat_gen_fabricante }" style="font-weight: bold;"/>
				<h:outputLabel value="#{ms.mat_activo }" style="font-weight: bold;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputText value="#{controlMaterial.gen.modelo}"/>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputText value="#{controlMaterial.gen.codigo}"/>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlMaterial.gen.tipo}">
						<f:selectItem itemValue="" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tipo_1 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tipo_2 }" />	
						<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tipo_3 }" />	
						<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tipo_4 }" />
						<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tipo_5 }" />
						<f:selectItem itemValue="6" itemLabel="#{ms.imp_dispositivos_tipo_6 }" />										
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlMaterial.gen.fabricante}">
						<f:selectItems value="#{controlMaterial.fabgen }" />																	
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlMaterial.gen.activo}">
						<f:selectItem itemValue="2" itemLabel="#{ms.mat_activo_todos }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.mat_activo_si }" />
						<f:selectItem itemValue="0" itemLabel="#{ms.mat_activo_no }" />												
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid>
			<h:panelGrid id="tablaMatGen" width="100%">
				<h:panelGrid columns="3" columnClasses="alignRight">
					<h:outputLabel value="#{ms.mat_res_msg_1 }:  " style="font-weight: bold;"
						 rendered="#{controlMaterial.generadores ne null }"/>
					<h:outputLabel value="#{controlMaterial.totalgen } #{ms.mat_res_msg_2 }." 
						style="font-weight: bold;color:#E17009" rendered="#{controlMaterial.generadores ne null }"/>
					<t:commandLink actionListener="#{controlMaterial.exportarGeneradores}" target="_blank" title="#{ms.exportar_excel }"
						rendered="#{controlMaterial.generadores ne null }">
						<h:graphicImage value="/img/iconos/excel_icon.png" width="16" height="16" style="border: 0px;"/>
					</t:commandLink>
				</h:panelGrid>
				<t:dataTable styleClass="hor-minimalist-b" var="gen" rows="5"
						width="100%" value="#{controlMaterial.generadores }"
						binding="#{controlMaterial.bindingGenerador }"
						id="listamatgenerador">
						<t:column width="50%" headerstyleClass="left">
							<h:panelGrid>
								<a4j:commandLink reRender="tablaMatGen,panelMaterialEditarGenerador" 
										rendered="#{gen.idgenerador ne 129 and gen.idgenerador ne 130 and gen.idgenerador ne 131 and gen.idgenerador ne 132 }"
										onclick="javascript:Richfaces.showModalPanel('editarMaterialGenerador');">		
									 <h:graphicImage url="/img/iconos/editar.png"
										title="#{ms.editar }" width="16" height="16"
										style="border: 0px;" />
									 <f:setPropertyActionListener value="#{gen}"
		                            	target="#{controlMaterial.currentItemGenerador}"/>
		                             <f:setPropertyActionListener value="#{gen}"
		                            	target="#{controlMaterial.currentItemGeneradorBackup}"/>
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>
						<t:column width="50%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_modelo }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.modelo }" />
							</h:panelGrid>
						</t:column>
						<t:column width="50%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_fabricante }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.fabricante }" />
							</h:panelGrid>
						</t:column>
						<t:column width="10%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_tipo }" />
							</f:facet>
							<h:panelGrid>
								<h:selectOneMenu value="#{gen.tipo }" disabled="true">
									<f:selectItem itemValue="0" itemLabel="#{ms.imp_dispositivos_tipo_desc }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tipo_1 }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tipo_2 }" />	
									<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tipo_3 }" />
									<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tipo_4 }" />
									<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tipo_5 }" />
									<f:selectItem itemValue="6" itemLabel="#{ms.imp_dispositivos_tipo_6 }" />											
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_modo }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.modo }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_conec_ad }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.conectorad }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_conec_vd }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.conectorvd }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_conec_vi }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.conectorvi }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_conec_vcs }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.conectorvcs }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_rf }" />
							</f:facet>
							<h:panelGrid>
								<h:selectOneMenu value="#{gen.rf }" disabled="true">
									<f:selectItem itemValue="0" itemLabel="#{ms.mat_gen_rf_op0 }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_gen_rf_op1 }" />												
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_mri }" />
							</f:facet>
							<h:panelGrid>
								<h:selectOneMenu value="#{gen.mri }" disabled="true">
									<f:selectItem itemValue="0" itemLabel="#{ms.mat_gen_mri_op0 }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.mat_gen_mri_op1 }" />												
								</h:selectOneMenu>
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_referencia }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.codigo }" />
							</h:panelGrid>
						</t:column>
						<t:column width="30%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_nummodelo }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.numeromodelo }" />
							</h:panelGrid>
						</t:column>
						<t:column width="40%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_gen_idrx }" />
							</f:facet>
							<h:panelGrid>
								<h:outputLabel value="#{gen.idrx }" />
							</h:panelGrid>
						</t:column>
						<t:column width="40%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_estado }" />
							</f:facet>
							<h:panelGrid>
								<a4j:commandLink reRender="tablaMatGen" 
									actionListener="#{controlMaterial.activadesactivaGenerador }"
									onclick="javascript:Richfaces.showModalPanel('buscando');"
									oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
									<h:graphicImage value="/img/aplicacion/icoCancelar.png" width="16" 
										rendered="#{gen.activo eq 0 }"
										height="16" style="border:0;" title="#{ms.mat_inactivo }"/>
									<h:graphicImage value="/img/aplicacion/accept.png" width="16" 
										rendered="#{gen.activo eq 1 }"
										height="16" style="border:0;" title="#{ms.mat_activo }"/>				
								</a4j:commandLink>
							</h:panelGrid>
						</t:column>
						<f:facet name="footer">
								<rich:datascroller align="center" for="listamatgenerador" id="scrollMatGen"
									renderIfSinglePage="true" fastStep="3"
									page="#{controlMaterial.pagina_inicial}">
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
					<h:outputLabel value="#{ms.mat_gen_datos_gen }"
						style="font-weight: bold;" />
					<a4j:commandLink reRender="tablaMatGen" rendered="false"
						actionListener="#{controlMaterial.addGenerador }">
						<h:graphicImage value="/img/iconos/guardar.png" width="16"
							height="16" style="border:0;" title="Añadir generador"/>				
					</a4j:commandLink>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" 
					columns="4" width="100%" >
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.mat_gen_modelo }"/>
						<h:inputText value="#{controlMaterial.nuevogen.modelo}"/>
						<h:outputLabel value="#{ms.mat_gen_nummodelo }"/>
						<h:inputText value="#{controlMaterial.nuevogen.numeromodelo}"/>
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.mat_gen_referencia }"/>
						<h:inputText value="#{controlMaterial.nuevogen.codigo}"/>
						<h:outputLabel value="#{ms.mat_gen_gs128 }"/>
						<h:inputText value="#{controlMaterial.nuevogen.gs128}" id="RefMaterialGen">
							<a4j:support event="onchange" reRender="RefMaterialGen" ajaxSingle="true"
								actionListener="#{controlMaterial.lecturaGs128Generador}"/>
						</h:inputText>						
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.mat_gen_tipo }"/>
						<h:selectOneMenu value="#{controlMaterial.nuevogen.tipo}">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.imp_dispositivos_tipo_1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.imp_dispositivos_tipo_2 }" />	
							<f:selectItem itemValue="3" itemLabel="#{ms.imp_dispositivos_tipo_3 }" />	
							<f:selectItem itemValue="4" itemLabel="#{ms.imp_dispositivos_tipo_4 }" />
							<f:selectItem itemValue="5" itemLabel="#{ms.imp_dispositivos_tipo_5 }" />
							<f:selectItem itemValue="6" itemLabel="#{ms.imp_dispositivos_tipo_6 }" />
							<a4j:support event="onchange" reRender="panGenConectores" ajaxSingle="false"/>											
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.mat_gen_fabricante }"/>
						<h:selectOneMenu value="#{controlMaterial.nuevogen.fabricante}">
							<f:selectItems value="#{controlMaterial.fabgen }" />											
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid>
						<h:panelGrid columns="2" columnClasses="alignLeft,alignLeft">
							<h:outputLabel value="#{ms.mat_gen_modo }"/>
							<h:selectOneMenu value="#{controlMaterial.nuevogen.modo}">
								<f:selectItems value="#{controlMaterial.modogen }" />											
							</h:selectOneMenu>
						</h:panelGrid>
						<h:panelGrid columns="4">
							<h:selectBooleanCheckbox value="#{controlMaterial.rf}"/>		
							<h:outputLabel value="#{ms.mat_gen_rf }"/>
							<h:selectBooleanCheckbox value="#{controlMaterial.mri}"/>							
							<h:outputLabel value="#{ms.mat_gen_mri }"/>
						</h:panelGrid>
					</h:panelGrid>
					
				</h:panelGrid>
				<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
					<h:panelGrid id="panGenConectores">
						<h:outputLabel value="#{ms.mat_gen_add_conect_msg_1 }"
							style="font-weight: bold;color:#EA9D65;font-size:12px;" 
							rendered="#{controlMaterial.nuevogen.tipo eq null or controlMaterial.nuevogen.tipo eq 0}"/>
						<t:fieldset legend="#{ms.mat_gen_datos_conec_baja_energ }" 
							rendered="#{controlMaterial.nuevogen.tipo eq 1 or controlMaterial.nuevogen.tipo eq 2 or controlMaterial.nuevogen.tipo eq 3 or controlMaterial.nuevogen.tipo eq 4 or controlMaterial.nuevogen.tipo eq 6}">
							<h:panelGrid columns="4">
								<h:panelGrid>
									<h:outputLabel value="#{ms.mat_gen_conec_ad }"/>
									<h:selectOneMenu value="#{controlMaterial.nuevogen.conectorad}">
										<f:selectItems value="#{controlMaterial.conelec }" />											
									</h:selectOneMenu>
									<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
										<h:panelGrid columns="2">
											<h:outputLabel value="#{ms.mat_gen_valores_fabrica_volt }: "/>
											<h:inputText value="#{controlMaterial.nuevogen.genfab.voltajead }" size="4"/>
											<h:outputLabel value="#{ms.mat_gen_valores_fabrica_durimp }: "/>
											<h:inputText value="#{controlMaterial.nuevogen.genfab.durimpad }" size="4"/>
											<h:outputLabel value="#{ms.mat_gen_valores_fabrica_sens }: "/>
											<h:inputText value="#{controlMaterial.nuevogen.genfab.sensibad }" size="4"/>
										</h:panelGrid>
									</t:fieldset>
								</h:panelGrid>
								<h:panelGrid>
									<h:outputLabel value="#{ms.mat_gen_conec_vd }"/>
									<h:selectOneMenu value="#{controlMaterial.nuevogen.conectorvd}">
										<f:selectItems value="#{controlMaterial.conelec }" />											
									</h:selectOneMenu>
									<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
										<h:panelGrid columns="2">
											<h:outputLabel value="#{ms.mat_gen_valores_fabrica_volt }: "/>
											<h:inputText value="#{controlMaterial.nuevogen.genfab.voltajevd }" size="4"/>
											<h:outputLabel value="#{ms.mat_gen_valores_fabrica_durimp }: "/>
											<h:inputText value="#{controlMaterial.nuevogen.genfab.durimpvd }" size="4"/>
											<h:outputLabel value="#{ms.mat_gen_valores_fabrica_sens }: "/>
											<h:inputText value="#{controlMaterial.nuevogen.genfab.sensibvd }" size="4"/>
										</h:panelGrid>
									</t:fieldset>
								</h:panelGrid>
								<h:panelGrid rendered="#{controlMaterial.nuevogen.tipo eq 3 or controlMaterial.nuevogen.tipo eq 4}">
									<h:outputLabel value="#{ms.mat_gen_conec_vi }" />
									<h:selectOneMenu value="#{controlMaterial.nuevogen.conectorvi}">
										<f:selectItems value="#{controlMaterial.conelec }" />											
									</h:selectOneMenu>
									<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
										<h:panelGrid columns="2">
											<h:outputLabel value="#{ms.mat_gen_valores_fabrica_volt }: "/>
											<h:inputText value="#{controlMaterial.nuevogen.genfab.voltajevi }" size="4"/>
											<h:outputLabel value="#{ms.mat_gen_valores_fabrica_durimp }: "/>
											<h:inputText value="#{controlMaterial.nuevogen.genfab.durimpvi }" size="4"/>
											<h:outputLabel value="#{ms.mat_gen_valores_fabrica_sens }: "/>
											<h:inputText value="#{controlMaterial.nuevogen.genfab.sensibvi }" size="4"/>
										</h:panelGrid>
									</t:fieldset>
								</h:panelGrid>								
							</h:panelGrid>
						</t:fieldset>
						<t:fieldset legend="#{ms.mat_gen_datos_conec_alta_energ }" rendered="#{controlMaterial.nuevogen.tipo eq 2 or controlMaterial.nuevogen.tipo eq 4 or controlMaterial.nuevogen.tipo eq 6}">
							<h:panelGrid columns="2">
								<h:panelGrid>
									<h:outputLabel value="#{ms.mat_gen_conec_vd2 }"/>
									<h:selectOneMenu value="#{controlMaterial.nuevogen.conectorVd2}">
										<f:selectItems value="#{controlMaterial.conelec }" />											
									</h:selectOneMenu>
								</h:panelGrid>
								<h:panelGrid>
									<h:outputLabel value="#{ms.mat_gen_conec_vcs }"/>
									<h:selectOneMenu value="#{controlMaterial.nuevogen.conectorvcs}">
										<f:selectItems value="#{controlMaterial.conelec }" />											
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
						</t:fieldset>
					</h:panelGrid>
					<h:panelGrid>
						<h:panelGrid rendered="#{controlMaterial.nuevogen.tipo eq null or controlMaterial.nuevogen.tipo eq 0}">
							<t:fieldset legend="#{ms.mat_gen_valores_fabrica_title }" >
								<h:panelGrid columns="2">
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_frec }: "/>
									<h:inputText value="#{controlMaterial.nuevogen.genfab.frecuencia }" size="3"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_iav_est }: " rendered="false"/>
									<h:inputText value="#{controlMaterial.nuevogen.genfab.iavest }" size="4" rendered="false"/>
									<h:outputLabel value="#{ms.mat_gen_valores_fabrica_iav_det }: " rendered="false"/>
									<h:inputText value="#{controlMaterial.nuevogen.genfab.iavdet }" size="4" rendered="false"/>
								</h:panelGrid>
							</t:fieldset>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="#{ms.mat_gen_idrx }"/>
							<h:inputText value="#{controlMaterial.nuevogen.idrx}"/>						
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<a4j:commandLink reRender="tablaMatGen,panelMaterialGenerador"
						onclick="javascript:Richfaces.showModalPanel('buscando');"
						oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
						actionListener="#{controlMaterial.addGenerador }">
						<h:graphicImage value="/img/iconos/guardar.png" width="16"
							height="16" style="border:0;" title="#{ms.aniadir }"/>				
					</a4j:commandLink>
					<h:outputLabel value="#{ms.guardar }"
						style="font-weight: bold;" />
				</h:panelGrid>	
			</rich:simpleTogglePanel>
			
	</h:panelGrid>
	<rich:modalPanel id="editarMaterialGenerador" autosized="true" zindex="2000" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.mat_gen_edit_title }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlMaterial.cambiarGeneradorIncluir }"
					reRender="tablaMatGen"
					onclick="javascript:Richfaces.hideModalPanel('editarMaterialGenerador');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.confirmar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMaterial.cambiarGeneradorCancelar }"
					reRender="tablaMatGen"
					onclick="javascript:Richfaces.hideModalPanel('editarMaterialGenerador');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('editarMaterialGenerador')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="editargenerador" width="100%">
			<ui:include src="/ventanas/administracion/material/editargenerador.jsp" />
		</h:panelGrid>
	</rich:modalPanel>
</ui:composition>
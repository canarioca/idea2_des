<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:jsflot="http://www.jsflot.org/taglib/jsflot"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich"
	xmlns:s="http://myfaces.apache.org/sandbox">
	
	<h:panelGrid width="100%">
		<h:panelGrid columnClasses="alignTop" id="tablaIntegracionesControl">
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.integra_reg_solicitudes_msg }"
					style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaIntegraciones"
					onclick="javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');" 
					actionListener="#{controlIntegraciones.consultaIntegraciones }">
					<h:graphicImage value="/img/iconos/buscar.png" width="16"
						height="16" style="border:0;" title="#{ms.integra_reg_solicitudes_title }"/>				
				</a4j:commandLink>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="tablaIntegraciones" width="100%">
			<h:panelGrid rendered="#{empty controlIntegraciones.pends }" style="border-top: solid 1px;border-color: black;">
				<h:outputLabel value="#{ms.integra_reg_solicitudes_vacia }"/>
			</h:panelGrid>	
			<h:panelGrid width="100%" rendered="#{not empty controlIntegraciones.pends }" style="border-top: solid 1px;border-color: black;">
				<t:dataTable styleClass="hor-minimalist-b" var="sol" rows="4"
					width="100%" value="#{controlIntegraciones.pends }"
					binding="#{controlIntegraciones.bindingIntegraciones }"
					id="listaintegraciones">
					<t:column width="20%" headerstyleClass="left" styleClass="alignTop">
						<f:facet name="header">
							<h:outputText value="#{ms.integra_reg_solicitudes_demogr }" />
						</f:facet>
						<h:panelGrid columns="2" width="100%" columnClasses="alignTop, alignTop">
							<h:outputLabel value="#{ms.pat_consulta_nombre_title }" style="font-weight: bold;"/>
							<h:outputLabel value="#{ms.pat_consulta_nhc }" style="font-weight: bold;"/>
							<h:inputText value="#{sol.pat.nombre }" />
							<h:inputText value="#{sol.pat.nhc }" />
							<h:outputLabel value="#{ms.pat_consulta_apellido_1_msg }" style="font-weight: bold;"/>
							<h:outputLabel value="#{ms.pat_consulta_apellido_2_msg }" style="font-weight: bold;"/>
																					
							<h:inputText value="#{sol.pat.apellidos }" />																							
							<h:inputText value="#{sol.pat.apellido2 }" />
							<h:outputText value="#{ms.pat_consulta_sexo }" style="font-weight: bold;"/>
							<h:outputText value="#{ms.pat_consulta_fnac }" style="font-weight: bold;"/>
																									
							<h:selectOneMenu value="#{sol.pat.sexo }" >
								<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
								<f:selectItem itemValue="1" itemLabel="#{ms.masculino }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.femenino }" />													
							</h:selectOneMenu>
							<rich:calendar datePattern="dd/MM/yyyy" inputStyle="input"
								popup="true" showInput="true" enableManualInput="true"
								value="#{sol.pat.fechanacimiento}">
							</rich:calendar>						
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:graphicImage url="/img/iconos/alerta.png" rendered="#{not empty sol.pat.coinc}"
								title="#{ms.integra_reg_solicitudes_demogr_coinc }" width="16" height="16"
								style="border: 0px;" />
							<a4j:commandLink reRender="tablaIntegraciones" rendered="#{not empty sol.pat.coinc}"
								value="#{ms.integra_reg_solicitudes_demogr_coinc_2 }.">																				
							</a4j:commandLink>
						</h:panelGrid>
						<h:panelGrid width="100%" rendered="#{not empty sol.pat.coinc}">
							<t:dataTable styleClass="hor-minimalist-b" var="pat" rows="5"
								width="100%" value="#{sol.pat.coinc }"
								binding="#{controlIntegraciones.bindingPacientesCoincidentes }"
								id="listapacientescoincidentes">
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.pat_consulta_nombre_title }" />
									</f:facet>
									<h:panelGrid>
										<h:outputLabel value ="#{pat.nombre }"/>
									</h:panelGrid>
								</t:column>
								<t:column width="100%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.pat_consulta_apellido_1_msg }" />
									</f:facet>
									<h:panelGrid>
										<h:outputLabel value ="#{pat.apellid1 }"/>
									</h:panelGrid>
								</t:column>
								<t:column width="100%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.pat_consulta_apellido_2_msg }" />
									</f:facet>
									<h:panelGrid>
										<h:outputLabel value ="#{pat.apellid2 }"/>
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.pat_consulta_nhc }" />
									</f:facet>
									<h:panelGrid>
										<h:outputLabel value ="#{pat.nhc }"/>
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.pat_consulta_fnac }" />
									</f:facet>
									<h:panelGrid>
										<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
											showWeeksBar="false" direction="bottom-left"
											value="#{pat.fechaNaci }"/>												
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="" />
									</f:facet>
									<h:panelGrid>
										<h:selectBooleanCheckbox value="#{pat.seleccion}" />
									</h:panelGrid>
								</t:column>
							</t:dataTable>
							<rich:datascroller align="center" for="listapacientescoincidentes" id="scListaPatCoinc"
								renderIfSinglePage="true" fastStep="3"
								page="#{controlIntegraciones.pagina_inicial}">
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
						</h:panelGrid>
					</t:column>	
					<t:column width="50%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.integra_reg_solicitudes_sist } " />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">
							<h:panelGrid columns="4" >
								<h:outputLabel value="#{ms.imp_dispositivos_gen_fimp }: " style="font-weight: bold;"/>
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{sol.imp.fechaimplante }"/>
								<h:outputLabel value="#{ms.integra_reg_solicitudes_sist_fseg }: " style="font-weight: bold;"/>
								<h:outputLabel value="#{sol.imp.fechaseg }" rendered="false">
									<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+1"/>
								</h:outputLabel>
								<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
									showWeeksBar="false" direction="bottom-left"
									value="#{sol.imp.fechaseg }"/>
								<h:outputLabel value="#{ms.imp_dispositivos_gen_numserie }: " style="font-weight: bold;"/>
								<h:outputText value="#{sol.imp.numserieg }"/>
								<h:outputLabel value="#{ms.imp_dispositivos_gen_fab }: " style="font-weight: bold;"/>
								<h:outputText value="#{sol.imp.fabricanteg }"/>
							</h:panelGrid>	
							<h:panelGrid columns="3">
								<h:outputLabel value="#{ms.integra_reg_solicitudes_sist_modelo_gen }: " style="font-weight: bold;"/>
								<h:panelGrid columns="5">
									<h:outputText value="#{sol.imp.modelog }" style="font-color: red;"/>
									<a4j:commandLink reRender="tablaIntegraciones"													
										actionListener="#{controlIntegraciones.mostrarGeneradores }" >		
										<h:graphicImage url="/img/iconos/list-view.png"
											title="#{ms.integra_reg_solicitudes_sist_modelo_gen_lista }" width="16" height="16"
											style="border: 0px;" />																								
									</a4j:commandLink>
									<h:graphicImage url="/img/iconos/alerta.png"
										title="#{ms.integra_reg_solicitudes_sist_elecs_rev }" 
										width="16" height="16" style="border: 0px;"/>
									<a4j:commandLink rendered="#{not empty sol.imp.gencoinc}" value="#{ms.integra_reg_solicitudes_sist_modelo_gen_lista_coinc }."/>	
									<a4j:commandLink rendered="#{empty sol.imp.gencoinc}" value="#{ms.integra_reg_solicitudes_sist_modelo_gen_lista_no }."/>																							
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid>
								<h:panelGrid rendered="#{sol.imp.mostrargen eq true}">
									<r:comboBox enableManualInput="true" defaultLabel="#{ms.integra_reg_solicitudes_sist_modelo_gen_manual }"
										value="#{sol.imp.modelogensel}" width="220">
										<f:selectItems value="#{controlIntegraciones.generadores }"/>
										<a4j:support event="onchange" reRender="tablaIntegraciones" ajaxSingle="true"
											actionListener="#{controlIntegraciones.cambiaModeloGenSel }"/> 
									</r:comboBox>
								</h:panelGrid>
								<h:panelGrid rendered="#{sol.imp.mostrargen eq true}">
									<h:panelGrid width="100%" rendered="#{not empty sol.imp.gencoinc}">
										<t:dataTable styleClass="hor-minimalist-b" var="gen" rows="5"
											width="100%" value="#{sol.imp.gencoinc }"
											binding="#{controlIntegraciones.bindingGeneradoresCoincidentes }"
											id="listageneradorescoincidentes">
											<t:column width="50%" headerstyleClass="left">
												<f:facet name="header">
													<h:outputText value="#{ms.imp_dispositivos_gen_modelo }" />
												</f:facet>
												<h:panelGrid>
													<h:outputLabel value ="#{gen.modelo }"/>
												</h:panelGrid>
											</t:column>
											<t:column width="100%" headerstyleClass="left">
												<f:facet name="header">
													<h:outputText value="#{ms.imp_dispositivos_gen_fab }" />
												</f:facet>
												<h:panelGrid>
													<h:outputLabel value ="#{gen.fabricante }"/>
												</h:panelGrid>
											</t:column>													
											<t:column width="50%" headerstyleClass="left">
												<f:facet name="header">
													<h:outputText value="" />
												</f:facet>
												<h:panelGrid>
													<h:selectBooleanCheckbox value="#{gen.seleccion }">
														<a4j:support event="onchange" reRender="tablaIntegraciones" ajaxSingle="true"
															actionListener="#{controlIntegraciones.cambiaSeleccionGen}"/>
													</h:selectBooleanCheckbox> 																	
												</h:panelGrid>
											</t:column>
										</t:dataTable>
										<rich:datascroller align="center" for="listageneradorescoincidentes" id="scListaGenCoinc"
											renderIfSinglePage="true" fastStep="3"
											page="#{controlIntegraciones.pagina_inicial_gen}">
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
									</h:panelGrid>
								</h:panelGrid>
							</h:panelGrid>
							<t:dataTable styleClass="hor-minimalist-b" var="el" rows="5"
								width="100%" value="#{sol.els }"
								binding="#{controlIntegraciones.bindingElectrodos }"
								id="listaintegracioneselecs">
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_modelo }" />
									</f:facet>
									<h:panelGrid columns="3">
										<h:inputText value ="#{el.modelo }"/>
										<a4j:commandLink reRender="tablaIntegraciones"
											actionListener="#{controlIntegraciones.mostrarElectrodos }">		
											<h:graphicImage url="/img/iconos/list-view.png"
												title="#{ms.integra_reg_solicitudes_sist_elecs_prop }" width="16" height="16"
												style="border: 0px;" />																									
										</a4j:commandLink>
										<h:graphicImage url="/img/iconos/alerta.png"
											title="#{ms.integra_reg_solicitudes_sist_elecs_rev }" 
											width="16" height="16" style="border: 0px;"/>
									</h:panelGrid>
									<h:panelGrid id="tablaElectrodosCoincidentes">
										<h:panelGrid rendered="#{el.mostrarelec eq true}">
											<h:panelGrid>
												<r:comboBox enableManualInput="true" defaultLabel="#{ms.imp_dispositivos_tab_himp_lectura_manual }"
													width="220" value="#{el.modeloelecsel}">
													<f:selectItems value="#{controlIntegraciones.electrodos }"/>
													<a4j:support event="onchange" reRender="tablaIntegraciones" ajaxSingle="true"
														actionListener="#{controlIntegraciones.cambiaModeloElecSel }"/> 
												</r:comboBox>
											</h:panelGrid>
											<h:panelGrid width="100%" rendered="#{not empty el.elecs}">
												<t:dataTable styleClass="hor-minimalist-b" var="e" rows="2"
													width="100%" value="#{el.elecs }"
													binding="#{controlIntegraciones.bindingElectrodosCoincidentes }"
													id="listaelectrodoscoincidentes">
													<t:column width="50%" headerstyleClass="left">
														<f:facet name="header">
															<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_modelo }" />
														</f:facet>
														<h:panelGrid>
															<h:outputLabel value ="#{e.modelo }"/>
														</h:panelGrid>
													</t:column>
													<t:column width="100%" headerstyleClass="left">
														<f:facet name="header">
															<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_fab }" />
														</f:facet>
														<h:panelGrid>
															<h:outputLabel value ="#{e.fabricante }"/>
														</h:panelGrid>
													</t:column>													
													<t:column width="50%" headerstyleClass="left">
														<f:facet name="header">
															<h:outputText value="" />
														</f:facet>
														<h:panelGrid>
															<h:selectBooleanCheckbox value="#{e.seleccion }">
																<a4j:support event="onchange" reRender="tablaIntegraciones" ajaxSingle="true"
																	actionListener="#{controlIntegraciones.cambiaSeleccionElec }"/>
															</h:selectBooleanCheckbox>
														</h:panelGrid>
													</t:column>
												</t:dataTable>
												<rich:datascroller align="center" for="listaelectrodoscoincidentes" id="scListaElCoinc"
													renderIfSinglePage="true" fastStep="3"
													page="#{controlIntegraciones.pagina_inicial_elec}">
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
											</h:panelGrid>
										</h:panelGrid>		
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_numserie }" />
									</f:facet>
									<h:panelGrid columns="2">
										<h:inputText value ="#{el.nserie }"/>
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_fab }" />
									</f:facet>
									<h:panelGrid columns="2">
										<h:outputLabel value ="#{el.fabricante }"/>
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.imp_dispositivos_tab_himp_ele_camara }" />
									</f:facet>
									<h:panelGrid columns="2">
										<h:selectOneMenu value="#{el.camara }" disabled="true">
											<f:selectItem itemValue="0" itemLabel="#{ms.no_especificado }" />
											<f:selectItem itemValue="948" itemLabel="AD" />
											<f:selectItem itemValue="949" itemLabel="VD" />
											<f:selectItem itemValue="950" itemLabel="VI" />													
										</h:selectOneMenu>
									</h:panelGrid>
								</t:column>
							</t:dataTable>
						</h:panelGrid>
					</t:column>					
					<t:column width="10%" headerstyleClass="left">
						<h:panelGrid columns="3">										
							<a4j:commandLink reRender="tablaIntegraciones,tablaIntegracionesControl"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								onclick="if (!confirm('#{ms.warn_guarda_integr_solicitud}')) return false;javascript:Richfaces.showModalPanel('buscando');"
								actionListener="#{controlIntegraciones.guardar }">		
								<h:graphicImage url="/img/iconos/guarda.png"
									title="#{ms.insertar }" width="16" height="16"
									style="border: 0px;" />											
							</a4j:commandLink>
							<a4j:commandLink reRender="tablaIntegraciones,tablaIntegracionesControl"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								onclick="if (!confirm('#{ms.warn_borra_integr_solicitud}')) return false;javascript:Richfaces.showModalPanel('buscando');"
								actionListener="#{controlIntegraciones.eliminar  }">		
								<h:graphicImage url="/img/aplicacion/icoCancelar.png"
									title="#{ms.eliminar }" width="16" height="16"
									style="border: 0px;" />											
							</a4j:commandLink>
							<h:commandLink rendered="false"
								actionListener="#{controlIntegraciones.descarga}"
								target="_blank">
								<h:graphicImage value="/img/iconos/print.png"
									width="22" height="22"
									style="border:none;" title="Descarga" />
							</h:commandLink>											
						</h:panelGrid>
					</t:column>
				</t:dataTable>
				<rich:datascroller align="center" for="listaintegraciones" id="scListaSolicitudes" renderIfSinglePage="true" fastStep="3" 
					page="#{controlIntegraciones.pagina_inicial_gen}">
					<f:facet name="first">
						<h:graphicImage url="/img/genericos/navegacion/first.png"/>
					</f:facet>
					<f:facet name="last">
						<h:graphicImage url="/img/genericos/navegacion/last.png"/>
					</f:facet>
					<f:facet name="fastrewind">
						<h:graphicImage url="/img/genericos/navegacion/frwd.png"/>
					</f:facet>
					<f:facet name="fastforward">
						<h:graphicImage url="/img/genericos/navegacion/ffwd.png"/>
					</f:facet>
					<f:facet name="previous">
						<h:graphicImage url="/img/genericos/navegacion/rwd.png"/>
					</f:facet>
					<f:facet name="next">
						<h:graphicImage url="/img/genericos/navegacion/fwd.png"/>
					</f:facet>
					<f:facet name="first_disabled">
						<h:graphicImage url="/img/genericos/navegacion/first.png"/>
					</f:facet>
					<f:facet name="last_disabled">
						<h:graphicImage url="/img/genericos/navegacion/last.png"/>
					</f:facet>
					<f:facet name="fastrewind_disabled">
						<h:graphicImage url="/img/genericos/navegacion/frwd.png"/>
					</f:facet>
					<f:facet name="fastforward_disabled">
						<h:graphicImage url="/img/genericos/navegacion/ffwd.png"/>
					</f:facet>
					<f:facet name="previous_disabled">
						<h:graphicImage url="/img/genericos/navegacion/rwd.png"/>
					</f:facet>
					<f:facet name="next_disabled">
						<h:graphicImage url="/img/genericos/navegacion/fwd.png"/>
					</f:facet>
				</rich:datascroller>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	
</ui:composition>
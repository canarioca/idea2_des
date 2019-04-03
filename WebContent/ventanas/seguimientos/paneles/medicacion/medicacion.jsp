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

	<h:panelGrid width="100%" id="planMedicacionGeneralSeg">
		<h:panelGrid width="100%">
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.med_gen_title }"
					style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaPlanMedGenSeg" rendered="false"
					onclick="javascript:Richfaces.showModalPanel('nuevoItemPlanGenSeg');">	
					<h:graphicImage value="/img/iconos/add.png" width="16"
						height="16" style="border:0;" title="#{ms.aniadir }"/>				
				</a4j:commandLink>			
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaPlanMedGenSeg" width="100%">
				<h:outputLabel value="#{ms.med_gen_msg_1 }"
					rendered="#{empty controlMedicacion.planmedicaciongen }"/>
				<t:dataTable styleClass="hor-minimalist-b" var="medgen" rendered="#{not empty controlMedicacion.planmedicaciongen }"
					width="100%" value="#{controlMedicacion.planmedicaciongen }"
					binding="#{controlMedicacion.bindingMedicacionGeneralSeg }" id="dataTablePlanMedGenSeg" rowIndexVar="rib">
					<t:column width="20%" headerstyleClass="left">
						<h:panelGrid columnClasses="alignTop">								
							<a4j:commandLink reRender="tablaPlanMedGenSeg,panMededitItemPlanGenSeg,panEditItemPlanGenSeg,editItemPlanGenSeg"
								actionListener="#{controlMedicacion.preEditarSeg }">		
								<h:graphicImage value="/img/iconos/Pills.png" width="16"
									height="16" style="border:0;" title="#{ms.editar }"/>
							</a4j:commandLink>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.med_gen_msg_2 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:selectOneMenu value="#{medgen.medicacionDto.medgenerico.tipomed }" disabled="true" title="Genérico: #{medgen.infomedgen }">
								<f:selectItems value="#{controlMedicacion.tiposmedicacion }" />															
							</h:selectOneMenu>
							<h:inputText value="#{medgen.otros }" disabled="true"
								rendered="#{medgen.medicacionDto.medgenerico.tipomed eq 18 }"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left" rendered="false">
						<f:facet name="header">
							<h:outputText value="#{ms.med_gen_msg_3 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:selectOneMenu value="#{medgen.idmedgen }" disabled="true">
								<f:selectItems value="#{controlMedicacion.genericos }" />															
							</h:selectOneMenu>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left" rendered="false">
						<f:facet name="header">
							<h:outputText value="#{ms.med_gen_msg_4 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:selectOneMenu value="#{medgen.idmedcom }" disabled="true">
								<f:selectItems value="#{controlMedicacion.comerciales }" />														
							</h:selectOneMenu>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.med_gen_msg_5 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:graphicImage url="/img/iconos/activo.png" title="#{ms.med_gen_msg_6 }" 
								width="16" height="16" style="border: 0px;" rendered="#{medgen.estado eq 1}"/>
							<h:graphicImage url="/img/iconos/no_activo.png" title="#{ms.med_gen_msg_7 }" 
								width="16" height="16" style="border: 0px;" rendered="#{medgen.estado eq -1}"/>
							<h:graphicImage url="/img/iconos/pendiente.png" title="#{ms.med_gen_msg_8 }" 
								width="16" height="16" style="border: 0px;" rendered="#{medgen.estado eq 0}"/>				
							<h:selectOneMenu value="#{medgen.estado }" rendered="false">
								<f:selectItem itemValue="1" itemLabel="#{ms.med_gen_msg_9 }"/>
								<f:selectItem itemValue="0" itemLabel="#{ms.med_gen_msg_10 }"/>
								<f:selectItem itemValue="-1" itemLabel="#{ms.med_gen_msg_11 }"/>																
							</h:selectOneMenu>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.med_gen_msg_12 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:outputLabel value="#{medgen.fechaprescripcion }" >
								<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+1"/>
							</h:outputLabel>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.med_gen_msg_13 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:outputLabel value="#{medgen.fechainicio }" >
								<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+1"/>
							</h:outputLabel>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.med_gen_msg_14 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:outputLabel value="#{medgen.fechasuspension }" >
								<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+1"/>
							</h:outputLabel>
						</h:panelGrid>
					</t:column>
					<t:column headerstyleClass="left">
						<h:panelGrid columns="2">
							<a4j:commandLink reRender="tablaPlanMedGenSeg"  rendered="false"
								actionListener="#{controlMedicacion.editItemPlanGen }">
								<h:graphicImage url="/img/iconos/guardar.png" title="#{ms.editar }" 
									width="16" height="16" style="border: 0px;"/>
							</a4j:commandLink>
							<a4j:commandLink reRender="tablaPlanMedGenSeg"
								onclick="if (!confirm('Atención: Se va a eliminar medicación, ¿desea continuar?')) return false;javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								actionListener="#{controlMedicacion.delItemPlanGenSeg }">
								<h:graphicImage url="/img/iconos/minus.png" title="#{ms.eliminar }" 
									width="16" height="16" style="border: 0px;"/>
							</a4j:commandLink>
						</h:panelGrid>
					</t:column>
				</t:dataTable>	
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid width="100%">
			<rich:simpleTogglePanel switchType="client" label="#{ms.insertar }" opened="false">
				<h:panelGrid id="panNuevoItemPlanGenSeg" >
					<h:panelGrid columns="2" width="100%" columnClasses="alignTop,alignTop" id="panMedNuevoItemPlanGenSeg">
						<h:panelGrid>
							<h:outputLabel value="#{ms.med_gen_msg_17 }" style="font-weight: bold;"/>
							<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed }">
									<f:selectItems value="#{controlMedicacion.tiposmedicacion }" />	
									<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
								</h:selectOneMenu>
							</h:panelGrid>
							<h:panelGrid>
								<h:panelGrid columnClasses="alignTop" >								
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 1}">
										<f:selectItems value="#{controlMedicacion.antiarritmicos_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 2}">
										<f:selectItems value="#{controlMedicacion.antibioticos_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 3}">
										<f:selectItems value="#{controlMedicacion.anticoagulantevenoso_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 4}">
										<f:selectItems value="#{controlMedicacion.anticoagulanteoral_siccs  }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 5}">
										<f:selectItems value="#{controlMedicacion.antilipemicos_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 6}">
										<f:selectItems value="#{controlMedicacion.antiplaquetarios_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 7}">
										<f:selectItems value="#{controlMedicacion.betabloqueantes_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 8}">
										<f:selectItems value="#{controlMedicacion.broncodilatadores_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 9}">
										<f:selectItems value="#{controlMedicacion.calcioantagonistas_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 10}">
										<f:selectItems value="#{controlMedicacion.digitalicos_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>							
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 11}">
										<f:selectItems value="#{controlMedicacion.diureticos_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 12}">
										<f:selectItems value="#{controlMedicacion.esteroides_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 13}">
										<f:selectItems value="#{controlMedicacion.heparina_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 14}">
										<f:selectItems value="#{controlMedicacion.ieca_siccs  }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen }" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 15}">
										<f:selectItems value="#{controlMedicacion.inotropicos_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 16}">
										<f:selectItems value="#{controlMedicacion.nitratos_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idmedgen}" 
										rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 17}">
										<f:selectItems value="#{controlMedicacion.nitritos_siccs }" />	
										<a4j:support event="onchange" reRender="panMedNuevoItemPlanGenSeg" ajaxSingle="true" />						
									</h:selectOneMenu>	
								</h:panelGrid>
								<h:inputText value="#{controlMedicacion.planmedgen.otros }" 
									rendered="#{controlMedicacion.planmedgen.medicacionDto.medgenerico.tipomed eq 18 }"/>
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid id="panFechasItemPlanMedGenSeg" columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
							<h:panelGrid>
								<h:outputLabel value="#{ms.med_gen_msg_5 }" style="font-weight: bold;"/>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.estado }">
										<f:selectItem itemValue="1" itemLabel="#{ms.med_gen_msg_9 }"/>
										<f:selectItem itemValue="0" itemLabel="#{ms.med_gen_msg_10 }"/>
										<f:selectItem itemValue="-1" itemLabel="#{ms.med_gen_msg_11 }"/>
										<a4j:support event="onchange" reRender="panMotivosSuspItemPlanGenSeg" ajaxSingle="true"/>														
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid>
								<h:outputLabel value="#{ms.med_gen_msg_18 }" style="font-weight: bold;"/>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
									<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
										showWeeksBar="false" direction="bottom-left"
										value="#{controlMedicacion.planmedgen.fechaprescripcion}">								
									</rich:calendar>
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid>
								<h:outputLabel value="#{ms.med_gen_msg_19 }" style="font-weight: bold;"/>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
									<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
										showWeeksBar="false" direction="bottom-left"
										value="#{controlMedicacion.planmedgen.fechainicio}">								
									</rich:calendar>
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid>
								<h:outputLabel value="#{ms.med_gen_msg_20 }" style="font-weight: bold;"/>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
									<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
										showWeeksBar="false" direction="bottom-left"
										value="#{controlMedicacion.planmedgen.fechasuspension}">								
									</rich:calendar>
								</h:panelGrid>
							</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
					<rich:simpleTogglePanel switchType="client" label="#{ms.med_gen_msg_21 }" opened="false" rendered="false">
						<h:panelGrid columns="2">
							<h:panelGrid>
								<h:outputLabel value="#{ms.med_gen_msg_22 }" style="font-weight: bold;"/>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.medicacionDto.medscom.idpresentacion }">
										<f:selectItems value="#{controlMedicacion.formasPresentacion }" />						
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
							<h:panelGrid>
								<h:outputLabel value="#{ms.med_gen_msg_23 }" style="font-weight: bold;"/>
								<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
									<h:selectOneMenu value="#{controlMedicacion.planmedgen.idvia }">
										<f:selectItems value="#{controlMedicacion.vias }" />						
									</h:selectOneMenu>
								</h:panelGrid>
							</h:panelGrid>
						</h:panelGrid>
					</rich:simpleTogglePanel>
					<h:panelGrid id="panMotivosSuspItemPlanGenSeg">
						<h:outputLabel value="#{ms.med_gen_msg_24 }" style="font-weight: bold;" rendered="#{controlMedicacion.planmedgen.estado eq 0 }"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlMedicacion.planmedgen.estado eq 0 }">
							<h:inputTextarea cols="80" rows="8" value="#{controlMedicacion.planmedgen.motivosuspension }" id="motivosSuspItemPlanGenSeg">
								<f:validateLength maximum="1000" />
							</h:inputTextarea>	
							<h:message for="motivosSuspItemPlanGenSeg" style="color:red" />
						</h:panelGrid>
					</h:panelGrid>
					<rich:simpleTogglePanel switchType="client" label="#{ms.med_gen_msg_25 }" opened="false">
						<h:panelGrid>
							<h:inputTextarea cols="80" rows="8" value="#{controlMedicacion.planmedgen.comentarios }" id="comentariosItemPlanGenSeg">
								<f:validateLength maximum="1000" />
							</h:inputTextarea>	
							<h:message for="comentariosItemPlanGenSeg" style="color:red" />
						</h:panelGrid>
					</rich:simpleTogglePanel>
				</h:panelGrid>
				<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
						<a4j:commandLink actionListener="#{controlMedicacion.addItemPlanGen }"
							reRender="tablaPlanMedGenSeg,panNuevoItemPlanGenSeg"
							onclick="javascript:Richfaces.showModalPanel('buscando');"
							oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
							<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
								width="24" height="24" title="#{ms.guardar }"/>
						</a4j:commandLink>
					</h:panelGrid>
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
						<a4j:commandLink actionListener="#{controlMedicacion.limpia }"
							reRender="tablaPlanMedGenSeg,panNuevoItemPlanGenSeg"
							onclick="javascript:Richfaces.showModalPanel('buscando');"
							oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
							<h:graphicImage value="/img/iconos/limpia.png"
								style="border:0;cursor:pointer;"
								width="24" height="24"
								title="#{ms.limpiar }" />
						</a4j:commandLink>
					</h:panelGrid>
				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>
	</h:panelGrid>
	
	<rich:modalPanel id="nuevoItemPlanGenSeg" autosized="true" zindex="500" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.med_gen_msg_28 }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlMedicacion.addItemPlanGen }"
					reRender="tablaPlanMedGenSeg,panNuevoItemPlanGenSeg"
					onclick="javascript:Richfaces.hideModalPanel('nuevoItemPlanGenSeg');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.guardar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMedicacion.limpia }"
					reRender="tablaPlanMedGenSeg,panNuevoItemPlanGenSeg"
					onclick="javascript:Richfaces.hideModalPanel('nuevoItemPlanGenSeg');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
					style="border:0;cursor:pointer;"
					onclick="javascript:Richfaces.hideModalPanel('nuevoItemPlanGenSeg')"
					title="#{ms.cerrar }" />
				</a4j:commandLink>				
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="pannuevomedseg" width="100%">
			
		</h:panelGrid>
	</rich:modalPanel>
	
	<rich:modalPanel id="editItemPlanGenSeg" autosized="true" zindex="500" minWidth="550" showWhenRendered="#{controlMedicacion.editableSeg}">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="Editar datos de medicación"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlMedicacion.editItemPlanGen }"
					reRender="tablaPlanMedGenSeg,panEditItemPlanGenSeg,dataTablePlanMedGenSeg"
					onclick="javascript:Richfaces.hideModalPanel('editItemPlanGenSeg');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.guardar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlMedicacion.cancelarItemPlanGen }"
					reRender="tablaPlanMedGenSeg,panEditItemPlanGenSeg,dataTablePlanMedGenSeg"
					onclick="javascript:Richfaces.hideModalPanel('editItemPlanGenSeg');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
					style="border:0;cursor:pointer;"
					onclick="javascript:Richfaces.hideModalPanel('editItemPlanGenSeg')"
					title="#{ms.cerrar }" />
				</a4j:commandLink>				
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="paneditmedseg" width="100%">
			<ui:include src="/ventanas/seguimientos/paneles/medicacion/editmedgen.jsp" />
		</h:panelGrid>
	</rich:modalPanel>
	
</ui:composition>
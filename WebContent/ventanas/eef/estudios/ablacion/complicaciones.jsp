<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" id="panComplicacionesPacienteEefAbl">
		<h:panelGrid width="100%">
			<h:outputLabel value="#{ms.compli_proc_eef_abl_title }" style="font-weight: bold;"/>
			<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="tablaComplicacionesEefAblProc" width="100%">
				<h:outputLabel value="#{ms.compli_msg_3}" rendered="#{empty controlEef.eef.ablaciondto.listacomplicacion}"/>
				<t:dataTable styleClass="hor-minimalist-b" var="comp" rendered="#{not empty controlEef.eef.ablaciondto.listacomplicacion }"
					width="100%" value="#{controlEef.eef.ablaciondto.listacomplicacion }"
					binding="#{controlEef.eef.ablaciondto.bindingComplicacionesAblProc }" id="dataTableComplicacionesEefAblProc" rowIndexVar="rib">
					<t:column width="5%" headerstyleClass="left">
						<h:panelGrid columnClasses="alignTop">								
							<a4j:commandLink reRender="tablaComplicacionesEefAblProc,panEditItemComplicacionesPacEefAbl,editItemComplicacionesPacEefAbl"
								actionListener="#{controlEef.preEditarAblProc}">		
								<h:graphicImage value="/img/iconos/complicacion.png" width="16" rendered="#{comp.compabl.resuelta ne 1}"
									height="16" style="border:0;" title="#{ms.compli_title_edit}"/>
								<h:graphicImage value="/img/iconos/complicacionRes.png" width="16" rendered="#{comp.compabl.resuelta eq 1}"
									height="16" style="border:0;" title="#{ms.compli_title_edit}"/>
							</a4j:commandLink>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.compli_table_title_1 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:selectOneMenu value="#{comp.compabl.complicacion }" disabled="true">
								<f:selectItems value="#{controlComplicaciones.complicacionesTodas }" />															
							</h:selectOneMenu>
							<h:inputText value="#{comp.compabl.complicacionOtra }" disabled="true" 
								rendered="#{comp.compabl.complicacion eq controlComplicaciones.idcompotra}"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.compli_table_title_2 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:selectOneMenu value="#{comp.compabl.tipo }" disabled="true">
								<f:selectItem itemValue="1" itemLabel="#{ms.compli_tipo_1 }"/>
								<f:selectItem itemValue="2" itemLabel="#{ms.compli_tipo_2 }"/>
								<f:selectItem itemValue="3" itemLabel="#{ms.compli_tipo_3 }"/>
							</h:selectOneMenu>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.compli_table_title_3 }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:outputLabel value="#{comp.compabl.fechaini }" >
								<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
							</h:outputLabel>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.eef_tab_abl_tac_compl_relacion_con }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">								
							<h:selectOneMenu value="#{comp.idprocedimiento }" disabled="true">
								<f:selectItem itemValue="-1" itemLabel="" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tac_compl_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tac_compl_op2 }" />
							</h:selectOneMenu>
							<h:selectOneMenu value="#{comp.idlugar }" rendered="#{comp.idprocedimiento eq 1 }" disabled="true">
								<f:selectItem itemValue="0" itemLabel="" />
								<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op1 }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op2 }" />
								<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op3 }" />
								<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op4 }" />
								<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op5 }" />
							</h:selectOneMenu>
						</h:panelGrid>
					</t:column>
					<t:column headerstyleClass="left">
						<h:panelGrid columns="2">
							<a4j:commandLink reRender="tablaComplicacionesEefAblProc,dataTableComplicacionesEefAblProc,cabecerapaciente,panelContenidoGlobal"
								onclick="if (!confirm('#{ms.compli_msg_warn_borra}')) return false;javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								actionListener="#{controlEef.delItemComplicacionAbl }">
								<h:graphicImage url="/img/iconos/minus.png" title="#{ms.compli_title_borra }" 
									width="16" height="16" style="border: 0px;"/>
							</a4j:commandLink>
						</h:panelGrid>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid width="100%">
			<rich:simpleTogglePanel switchType="client" label="#{ms.insertar }" opened="false">
				<h:panelGrid width="70%" cellspacing="0" id="pancompab2">
					<a4j:jsFunction name="updatecompan2" reRender="pancompab2" />
					<h:outputLabel value="#{ms.eef_tab_abl_tac_compl_relacion_con }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" width="78%">
						<h:selectOneMenu
							value="#{controlEef.eef.ablaciondto.complicacion.idprocedimiento }" onchange="updatecompan2();">
							<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tac_compl_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tac_compl_op2 }" />
						</h:selectOneMenu>
						<h:selectOneMenu
							value="#{controlEef.eef.ablaciondto.complicacion.idlugar }"
							rendered="#{controlEef.eef.ablaciondto.complicacion.idprocedimiento eq 1 }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op1 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op2 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op3 }" />
							<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op4 }" />
							<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op5 }" />
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid id="panNuevaComplicacionPacEefAbl" width="100%" columns="4" columnClasses="alignTop,alignTop,alignTop,alignTop">
					<h:outputLabel value="#{ms.compli_compl }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.compli_tipo }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.compli_fechaini }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.compli_fechafin }" style="font-weight: bold;"/>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panNuevaComPacCompliEefAbl">
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.compacAbl.complicacion }">
							<f:selectItems value="#{controlComplicaciones.complicacionesEefAbl }" />
							<a4j:support event="onchange" reRender="panNuevaComPacCompliEefAbl" ajaxSingle="true" />						
						</h:selectOneMenu>
						<h:inputText value="#{controlEef.eef.ablaciondto.compacAbl.complicacionOtra }" 
							rendered="#{controlEef.eef.ablaciondto.compacAbl.complicacion eq controlComplicaciones.idcompotra}"/>
					</h:panelGrid>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.compacAbl.tipo }">
							<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
							<f:selectItem itemValue="1" itemLabel="#{ms.compli_tipo_1 }"/>
							<f:selectItem itemValue="2" itemLabel="#{ms.compli_tipo_2 }"/>
							<f:selectItem itemValue="3" itemLabel="#{ms.compli_tipo_3 }"/>
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left" 
							value="#{controlEef.eef.ablaciondto.compacAbl.fechaini }" />
					</h:panelGrid>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
						<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
							showWeeksBar="false" direction="bottom-left" 
							value="#{controlEef.eef.ablaciondto.compacAbl.fechafin }" />
					</h:panelGrid>
					<h:outputLabel value="#{ms.compli_resuelta }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.compli_tratamiento }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.compli_ingreso }" style="font-weight: bold;"/>
					<h:outputLabel value="#{ms.compli_descripcion }" style="font-weight: bold;"/>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.compacAbl.resuelta }">
							<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
							<f:selectItem itemValue="0" itemLabel="#{ms.compli_resuelta_0 }"/>
							<f:selectItem itemValue="1" itemLabel="#{ms.compli_resuelta_1 }"/>
							<f:selectItem itemValue="2" itemLabel="#{ms.compli_resuelta_2 }"/>
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;" id="panNuevaComPacTratEefAbl">								
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.compacAbl.tratamiento }">
							<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
							<f:selectItem itemValue="0" itemLabel="#{ms.compli_tratamiento_0 }"/>
							<f:selectItem itemValue="1" itemLabel="#{ms.compli_tratamiento_1 }"/>
							<a4j:support event="onchange" reRender="panNuevaComPacTratEefAbl" ajaxSingle="true" />
						</h:selectOneMenu>
						<h:inputText value="#{controlEef.eef.ablaciondto.compacAbl.tratamientoDescr }" 
							rendered="#{controlEef.eef.ablaciondto.compacAbl.tratamiento eq 1}"/>
					</h:panelGrid>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">								
						<h:selectOneMenu value="#{controlEef.eef.ablaciondto.compacAbl.ingreso }">
							<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
							<f:selectItem itemValue="0" itemLabel="#{ms.compli_ingreso_0 }"/>
							<f:selectItem itemValue="1" itemLabel="#{ms.compli_ingreso_1 }"/>
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid columnClasses="alignTop" style="border-top: solid 1px;border-color: black;">
						<h:inputTextarea cols="40" rows="4" value="#{controlEef.eef.ablaciondto.compacAbl.descripcion }" id="descNuevaComPacEefAbl">
							<f:validateLength maximum="1000" />
						</h:inputTextarea>	
						<h:message for="descNuevaComPacEefAbl" style="color:red" />
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.eef_tab_abl_tac_compl_muerte }"/>
					<h:selectOneRadio value="#{controlEef.eef.ablaciondto.complicacion.idmuerte }">
						<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_muerte_op1 }" itemValue="1"/>
						<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_muerte_op0 }" itemValue="0"/>
					</h:selectOneRadio>
				</h:panelGrid>
				<h:panelGrid>
					<h:outputLabel value="#{ms.compli_msg_warn_guarda_proc }" rendered="#{controlEef.proc.idprocedimiento eq null }"
						style="font-weight: bold; color:#E17009;font-style: italic;font-size: 12px;"/>
				</h:panelGrid>
				<hr/>
				<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
						<a4j:commandLink actionListener="#{controlEef.guardaComplicacionAbl}"
							reRender="tablaComplicacionesEefAblProc,dataTableComplicacionesEefAblProc,panNuevaComplicacionPacEefAbl,cabecerapaciente,panelContenidoGlobal"
							onclick="javascript:Richfaces.showModalPanel('buscando');"
							oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
							rendered="#{controlEef.eef.idestudio ne null and controlEef.eef.ablaciondto.idablacion ne null}">
							<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
								width="24" height="24" title="#{ms.guardar }"/>
						</a4j:commandLink>
					</h:panelGrid>
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
						<a4j:commandLink actionListener="#{controlEef.limpiarCompAbl }"
							reRender="tablaComplicacionesEefAblProc,panNuevaComplicacionPacEefAbl"
							onclick="javascript:Richfaces.showModalPanel('buscando');"
							oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
							<h:graphicImage value="/img/iconos/limpia.png"
								style="border:0;cursor:pointer;" 
								width="24" height="24" title="#{ms.limpiar }" />
						</a4j:commandLink>
					</h:panelGrid>
				</h:panelGrid>
			</rich:simpleTogglePanel>
		</h:panelGrid>
	</h:panelGrid>



	<rich:modalPanel id="editItemComplicacionesPacEefAbl" autosized="true" zindex="500" minWidth="550" showWhenRendered="#{controlEef.editableAblProc}">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.compli_edit_title }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlEef.actualizaItemComplicacionAbl }"
					reRender="dataTableComplicacionesEefAblProc,cabecerapaciente,tablaComplicacionesEefAblProc,panelContenidoGlobal"
					onclick="javascript:Richfaces.hideModalPanel('editItemComplicacionesPacEefAbl');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.guardar }"/>
				</a4j:commandLink>
				<a4j:commandLink actionListener="#{controlEef.cancelarItemComplicacionAbl }"
					reRender="panEditItemComplicacionesPacEefAbl,tablaComplicacionesEefAblProc,dataTableComplicacionesEefAblProc"
					onclick="javascript:Richfaces.hideModalPanel('editItemComplicacionesPacEefAbl');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('editItemComplicacionesPacEefAbl')"
						title="#{ms.cerrar }" />
				</a4j:commandLink>				
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="paneditcompaceefabl" width="100%">
			<ui:include src="/ventanas/eef/estudios/ablacion/editcomplicacion.jsp" />
		</h:panelGrid>
	</rich:modalPanel>







	<h:panelGrid width="70%" cellspacing="0" id="pancompab" rendered="false">
		<a4j:jsFunction name="updatecompan" reRender="pancompab" />
		<h:outputLabel value="#{ms.eef_tab_abl_tac_compl_relacion_con }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;" width="78%">
			<h:selectOneMenu
				value="#{controlEef.eef.ablaciondto.complicacion.idprocedimiento }" onchange="updatecompan();">
				<f:selectItem itemValue="0" itemLabel="#{ms.eef_tab_abl_tac_compl_op0 }" />
				<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tac_compl_op1 }" />
				<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tac_compl_op2 }" />
			</h:selectOneMenu>
			<h:selectOneMenu
				value="#{controlEef.eef.ablaciondto.complicacion.idlugar }"
				rendered="#{controlEef.eef.ablaciondto.complicacion.idprocedimiento eq 1 }">
				<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
				<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op1 }" />
				<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op2 }" />
				<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op3 }" />
				<f:selectItem itemValue="4" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op4 }" />
				<f:selectItem itemValue="5" itemLabel="#{ms.eef_tab_abl_tac_compl_lugar_op5 }" />
			</h:selectOneMenu>
		</h:panelGrid>

		<rich:spacer height="20px" />
		<h:outputLabel value="#{ms.eef_tab_abl_tac_compl_mayores }" style="font-weight: bold;" rendered="#{controlEef.eef.ablaciondto.complicacion.idprocedimiento ne 0 }"/>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlEef.eef.ablaciondto.complicacion.idprocedimiento ne 0 }">
			<h:selectOneMenu value="#{controlEef.eef.ablaciondto.complicacion.idcomplicacion }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op1 }" itemValue="1" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op2 }" itemValue="2" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op3 }" itemValue="3" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op4 }" itemValue="4" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op5 }" itemValue="5" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op6 }" itemValue="6" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op7 }" itemValue="7" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op8 }" itemValue="8" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op9 }" itemValue="9" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op10 }" itemValue="10" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op11 }" itemValue="11" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_mayores_op12 }" itemValue="12" />
			</h:selectOneMenu>
		</h:panelGrid>
		<rich:spacer height="20px" />
		<h:outputLabel value="#{ms.eef_tab_abl_tac_compl_menores }" style="font-weight: bold;" rendered="#{controlEef.eef.ablaciondto.complicacion.idprocedimiento ne 0 }"/>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" rendered="#{controlEef.eef.ablaciondto.complicacion.idprocedimiento ne 0 }">
			<h:selectOneMenu value="#{controlEef.eef.ablaciondto.complicacion.idcomplicacion2 }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_menores_op1 }" itemValue="1" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_menores_op2 }" itemValue="2" />
				<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_menores_op3 }" itemValue="3" />
			</h:selectOneMenu>
			<h:inputText value="#{controlEef.eef.ablaciondto.complicacion.otros }" size="20" maxlength="30"/>
			<h:panelGrid columns="2">
			<h:outputLabel value="#{ms.eef_tab_abl_tac_compl_muerte }"/>
				<h:selectOneRadio value="#{controlEef.eef.ablaciondto.complicacion.idmuerte }">
					<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_muerte_op1 }" itemValue="1"/>
					<f:selectItem itemLabel="#{ms.eef_tab_abl_tac_compl_muerte_op0 }" itemValue="0"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	
	
</ui:composition>

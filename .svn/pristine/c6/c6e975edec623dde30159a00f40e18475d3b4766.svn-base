<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox"
	xmlns:r="http://richfaces.org/rich">
	
	<style>
.rich-combobox-list-cord{
     position: fixed !important;
}
</style>
	
	<h:panelGrid columns="8" width="100%"
			columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
			<h:outputLabel value="#{ms.eef_tab_recmat_antest }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.eef_tab_recmat_nav }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.eef_tab_recmat_escopia }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.eef_tab_recmat_tescopia }" style="font-weight: bold;"  />
			<h:outputLabel value="#{ms.eef_tab_recmat_escopia_dosis }" style="font-weight: bold;"  />
			<h:outputLabel value="#{ms.eef_tab_recmat_ecointra }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.eef_tab_recmat_angrot }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.eef_tab_recmat_robot }" style="font-weight: bold;" />			
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlEef.eef.anestesista }">
					<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.eef_tab_recmat_antest_op0 }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_recmat_antest_op1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.eef_tab_recmat_antest_op2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.eef_tab_recmat_antest_op3 }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlEef.eef.navegador }">
					<f:selectItems value="#{controlEef.navegadores }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlEef.eef.escopia }"
					onchange="actualizaEstudios();">
					<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemLabel="#{ms.eef_tab_recmat_escopia_op2 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.eef_tab_recmat_escopia_op1 }" itemValue="1" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="1" columnClasses="alignTop,alignTop">
				<h:inputText size="6" maxlength="5"
					value="#{controlEef.eef.tescopia }" />
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="1" columnClasses="alignTop,alignTop">
				<h:inputText size="6" maxlength="5"
					value="#{controlEef.eef.dosisEscopia }" />
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlEef.eef.ecografia }">
					<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.eef_tab_recmat_ecointra_op0 }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_recmat_ecointra_op1 }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlEef.eef.angiografia }">
					<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="0" itemLabel="#{ms.eef_tab_recmat_angrot_op0 }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.eef_tab_recmat_angrot_op1 }" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlEef.eef.robot }">
					<f:selectItems value="#{controlEef.robot }" />
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:panelGrid width="80%">
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:outputLabel value="#{ms.eef_tab_recmat_cats }" style="font-weight: bold;" />
				<a4j:commandLink reRender="tablaCateteres"
					actionListener="#{controlEef.addCateter }"
					focus="inicio:panelRecMaterialesEEF:dataTableCateteres:#{controlEef.bindingCatDiag.rows}:hiddenCateter">	
					<h:graphicImage value="/img/iconos/add.png" width="16"
						height="16" style="border:0;" title="#{ms.eef_tab_recmat_cats_add }"/>				
				</a4j:commandLink>			
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
					id="tablaCateteres" width="100%">
				<t:dataTable styleClass="hor-minimalist-b" var="cat"
					width="100%" value="#{controlEef.eef.listacats }"
					binding="#{controlEef.bindingCatDiag }" id="dataTableCateteres" rowIndexVar="rib">
					<t:column width="30%" headerstyleClass="left">
						<f:facet name="header"> 
							<h:panelGrid columns="3">
								<h:outputText value="#{ms.mat_cat_modelo }" />
								<a4j:commandLink reRender="tablaCateteres"
									actionListener="#{controlEef.cargarModelosCateter}">
									<h:graphicImage value="/img/iconos/list-view.png" width="16"
										height="16" style="border:0;" title="#{ms.eef_tab_recmat_cats_mod_mostrar }"/>		
								</a4j:commandLink>
								<a4j:commandLink reRender="tablaCateteres" 
									onclick="javascript:Richfaces.showModalPanel('insertarNuevoCateterEef');">
									<h:graphicImage value="/img/iconos/add_2.png" width="16"
										height="16" style="border:0;" title="#{ms.eef_tab_recmat_cats_mod_noencontrado }"/>				
								</a4j:commandLink>
							</h:panelGrid>
						</f:facet>
						<h:panelGrid>
							<h:outputLabel value="#{ms.eef_tab_recmat_cats_mod_codbarras }" rendered="#{cat.muestrabarcode eq true }"/>
							<h:inputText id="hiddenCateter" value="#{cat.barcode }" rendered="#{cat.muestrabarcode eq true }">
								<a4j:support event="onchange" reRender="tablaCateteres,opcionNuevoCateterEef,panelMaterialEefCateter" ajaxSingle="true"
									actionListener="#{controlEef.lecturaModeloCateter}"/>
							</h:inputText>
							<h:outputLabel value="#{cat.modelo}" />
							<h:panelGrid columns="2" rendered="#{controlEef.modavcatdiag eq true}">
								<r:comboBox enableManualInput="true" defaultLabel="#{ms.eef_tab_recmat_cats_mod_escribe }"
									value="#{cat.modelo}" width="250" rendered="#{controlEef.eef.idestudio ne null }">
									<f:selectItems value="#{controlEef.catdiag2}"/>
									<a4j:support event="onchange" reRender="tablaCateteres" ajaxSingle="true"
										actionListener="#{controlEef.cambiaModeloCateter }"/>
								</r:comboBox>
								<r:comboBox enableManualInput="true" defaultLabel="#{ms.eef_tab_recmat_cats_mod_escribe }"
									value="#{cat.modelo}" width="250" rendered="#{controlEef.eef.idestudio eq null }">
									<f:selectItems value="#{controlEef.catdiag}"/>
									<a4j:support event="onchange" reRender="tablaCateteres" ajaxSingle="true"
										actionListener="#{controlEef.cambiaModeloCateter }"/>
								</r:comboBox>
							</h:panelGrid>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.mat_cat_tipo }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">
							<h:selectOneMenu value="#{cat.tipo }" disabled="true">
								<f:selectItem itemValue="0" itemLabel="" />
								<f:selectItem itemValue="1" itemLabel="#{ms.mat_cat_tipo_diag }" />
								<f:selectItem itemValue="2" itemLabel="#{ms.mat_cat_tipo_abl }" />
							</h:selectOneMenu>	
						</h:panelGrid>				
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.eef_tab_recmat_cats_lote }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop,alignTop" id="loteCateter" columns="2">
							<h:inputText id="Lotecat" size="30" value="#{cat.lote }" maxlength="45">
								<a4j:support event="onchange" reRender="tablaCateteres" ajaxSingle="true"
									actionListener="#{controlEef.lecturaLoteCateter}"/>
							</h:inputText>	
							<a4j:commandLink reRender="tablaCateteres"
								actionListener="#{controlEef.delLote }">
								<h:graphicImage url="/img/iconos/limpia.png"
									title="#{ms.eef_tab_recmat_cats_lote_del }" width="16" height="16"
									style="border: 0px;" />
							</a4j:commandLink>
						</h:panelGrid>				
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.eef_tab_recmat_cats_loc }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">
							<h:selectOneMenu value="#{cat.idlocalizacion }" rendered="#{cat.tipo eq 1 }">
								<f:selectItems value="#{controlEef.localcateter }"  />								
							</h:selectOneMenu>
							<h:outputLabel value="#{ms.eef_tab_recmat_cats_loc_abl }" rendered="#{cat.tipo eq 2 }"/>
						</h:panelGrid>
					</t:column>
					<t:column width="20%" headerstyleClass="left">
						<f:facet name="header">
							<h:outputText value="#{ms.eef_tab_recmat_cats_via }" />
						</f:facet>
						<h:panelGrid columnClasses="alignTop">
							<h:selectOneMenu value="#{cat.idvia }" rendered="#{cat.tipo eq 1 }">
								<f:selectItems value="#{controlEef.viascateter }"  />								
							</h:selectOneMenu>
							<h:outputLabel value="#{ms.eef_tab_recmat_cats_via_abl }" rendered="#{cat.tipo eq 2 }"/>
						</h:panelGrid>
					</t:column>					
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaCateteres"
							actionListener="#{controlEef.delCateter }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.eef_tab_recmat_cats_del }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
		</h:panelGrid>
		
		
		
	
	
	<rich:modalPanel id="insertarNuevoCateterEef" autosized="true" zindex="2000" minWidth="550">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.eef_modal_recmat_nuevo_cat }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<f:facet name="controls">
			<h:panelGrid columns="3">
				<a4j:commandLink actionListener="#{controlEef.insertarNuevoCateter}" reRender="tablaCateteres,panelMaterialEefCateter"
					onclick="javascript:Richfaces.hideModalPanel('insertarNuevoCateterEef');">
					<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
						width="16px" height="16px" title="#{ms.confirmar }"/>
				</a4j:commandLink>
				<a4j:commandLink reRender="panelMaterialEefCateter" actionListener="#{controlEef.cancelarNuevoCateter}"
					onclick="javascript:Richfaces.hideModalPanel('insertarNuevoCateterEef');">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('insertarNuevoCateterEef')"
						title="#{ms.cancelar }" />
				</a4j:commandLink>		
			</h:panelGrid>
		</f:facet>
		<h:panelGrid id="nuevocatetereef" width="100%">
			<ui:include src="/ventanas/eef/cateter.jsp"/>
		</h:panelGrid>
	</rich:modalPanel>
	
	<rich:modalPanel id="opcionNuevoCateterEef" autosized="true" zindex="2000" minWidth="150" 
		showWhenRendered="#{controlEef.nuevocateter eq true}">
		<f:facet name="header">
			<h:panelGrid styleClass="center" border="0" columns="2" width="90%">
				<h:outputText value="#{ms.eef_modal_recmat_nuevo_cat_prev }"
					styleClass="textoBlancoNegrita" />
			</h:panelGrid>
		</f:facet>
		<h:panelGrid width="100%" align="center">
			<h:outputLabel value="#{ms.eef_modal_recmat_nuevo_cat_prev_info }"/>
			<h:panelGrid columns="2" align="center">
				<a4j:commandLink reRender="tablaCateteres" title="#{ms.aceptar }" value="#{ms.eef_modal_recmat_nuevo_cat_prev_si }" actionListener="#{controlEef.actualizaNuevoMaterial }"
					onclick="javascript:Richfaces.hideModalPanel('opcionNuevoCateterEef');javascript:Richfaces.showModalPanel('insertarNuevoCateterEef');">
					<h:graphicImage value="/img/aplicacion/accept.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('opcionNuevoCateterEef');javascript:Richfaces.showModalPanel('insertarNuevoCateterEef');"
						title="#{ms.aceptar }" />
				</a4j:commandLink>
				<a4j:commandLink onclick="javascript:Richfaces.hideModalPanel('opcionNuevoCateterEef');" 
					title="#{ms.cancelar }" value="#{ms.eef_modal_recmat_nuevo_cat_prev_no }" actionListener="#{controlEef.actualizaNuevoMaterial }">
					<h:graphicImage value="/img/aplicacion/icoCancelar.png"
						style="border:0;cursor:pointer;"
						onclick="javascript:Richfaces.hideModalPanel('opcionNuevoCateterEef');"
						title="#{ms.cancelar }" />
				</a4j:commandLink>	
			</h:panelGrid>
		</h:panelGrid>
	</rich:modalPanel>
		
</ui:composition>
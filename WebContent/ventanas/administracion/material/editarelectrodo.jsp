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
	
	<h:panelGrid id="panelMaterialEditarElectrodo">
		<h:panelGrid columns="3" width="100%" columnClasses="alignTop,alignTop,alignTop">
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
				<h:outputLabel value="#{ms.mat_ele_modelo }"/>
				<h:inputText value="#{controlMaterial.currentItemElectrodo.modelo}"/>
				<h:outputLabel value="#{ms.mat_ele_fabricante }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemElectrodo.fabricante}">
					<f:selectItems value="#{controlMaterial.fabelec }" />											
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.mat_ele_referencia }"/>
				<h:inputText value="#{controlMaterial.currentItemElectrodo.codigo}"/>
			</h:panelGrid>
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">	
				<h:outputLabel value="#{ms.mat_ele_polaridad }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemElectrodo.polaridad}">
					<f:selectItems value="#{controlMaterial.polelec }" />												
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.mat_ele_conector }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemElectrodo.conector}">
					<f:selectItems value="#{controlMaterial.conelec }" />												
				</h:selectOneMenu>
				<rich:spacer/>
				<rich:spacer/>
			</h:panelGrid>
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">	
				<h:outputLabel value="#{ms.mat_ele_fijacion }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemElectrodo.fijacion}">
					<f:selectItems value="#{controlMaterial.fijaelec }" />											
				</h:selectOneMenu>
				<h:outputLabel value="#{ms.mat_ele_bobina }"/>
				<h:selectOneMenu value="#{controlMaterial.currentItemElectrodo.bobina}">
					<f:selectItems value="#{controlMaterial.bobelec }" />												
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid>
			<t:fieldset legend="#{ms.mat_codigos_gs128 }">
				<h:panelGrid id="panGs128Elec">
					<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
						<h:outputLabel value="#{ms.mat_codigos_gs128_asociar }" style="font-weight: bold;" />
						<h:inputText value="#{controlMaterial.currentItemElectrodo.nuevocodigo }" size="16">
							<a4j:support event="onchange" reRender="panGs128Elec" ajaxSingle="true"
					 			actionListener="#{controlMaterial.lecturaGs128Electrodo2}"/>
						</h:inputText>
						<a4j:commandLink reRender="panGs128Elec" ajaxSingle="true"
							actionListener="#{controlMaterial.addGs128Electrodo }">	
							<h:graphicImage value="/img/iconos/add.png" width="16"
								height="16" style="border:0;" title="#{ms.mat_codigos_gs128_add }"/>				
						</a4j:commandLink>			
					</h:panelGrid>
					<h:outputLabel value="#{ms.mat_codigos_gs128_no_codes }" 
						rendered="#{empty controlMaterial.currentItemElectrodo.codigos }"/>
					<t:dataTable styleClass="hor-minimalist-b" var="item" rows="5" 
						rendered="#{not empty controlMaterial.currentItemElectrodo.codigos }"
						width="100%" value="#{controlMaterial.currentItemElectrodo.codigos }"
						binding="#{controlMaterial.bindingElectrodoGs128 }"
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
							<a4j:commandLink reRender="panGs128Elec"
								actionListener="#{controlMaterial.delGs128Electrodo }">
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
	
</ui:composition>
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
	
	<h:panelGrid id="panelMaterialEditarRegEv">
		<h:panelGrid columns="2" width="100%" >
			<h:panelGrid columns="2">
				<h:outputLabel value="#{ms.mat_regev_modelo }"/>
				<h:inputText value="#{controlMaterial.currentItemRegistrador.modelo}"/>
				<h:outputLabel value="#{ms.mat_regev_referencia }"/>
				<h:inputText value="#{controlMaterial.currentItemRegistrador.referencia}"/>
			</h:panelGrid>
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.mat_regev_fabricante }"/>
					<h:selectOneMenu value="#{controlMaterial.currentItemRegistrador.fabricante}">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="MEDTRONIC" itemLabel="#{ms.mat_regev_fabricante_med }" />
						<f:selectItem itemValue="SAINT JUDE MEDICAL" itemLabel="#{ms.mat_regev_fabricante_sjm }" />
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid>
					<h:panelGrid columns="4">
						<h:selectBooleanCheckbox value="#{controlMaterial.currentItemRegistrador.rf_bol}"/>		
						<h:outputLabel value="#{ms.mat_regev_rf }"/>
						<h:selectBooleanCheckbox value="#{controlMaterial.currentItemRegistrador.mri_bol}"/>							
						<h:outputLabel value="#{ms.mat_regev_mri }"/>
					</h:panelGrid>
				</h:panelGrid>				
		  </h:panelGrid>				
		</h:panelGrid>
		<h:panelGrid>
			<t:fieldset legend="#{ms.mat_codigos_gs128 }">
				<h:panelGrid id="panGs128RegEv">
					<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
						<h:outputLabel value="#{ms.mat_codigos_gs128_asociar }" style="font-weight: bold;" />
						<h:inputText value="#{controlMaterial.currentItemRegistrador.nuevocodigo }" size="16">
							<a4j:support event="onchange" reRender="panGs128RegEv" ajaxSingle="true"
					 			actionListener="#{controlMaterial.lecturaGS128Registrador}"/>
						</h:inputText>
						<a4j:commandLink reRender="panGs128RegEv" ajaxSingle="true"
							actionListener="#{controlMaterial.addGs128Registrador }">	
							<h:graphicImage value="/img/iconos/add.png" width="16"
								height="16" style="border:0;" title="#{ms.mat_codigos_gs128_add }"/>				
						</a4j:commandLink>			
					</h:panelGrid>
					<h:outputLabel value="#{ms.mat_codigos_gs128_no_codes }" 
						rendered="#{empty controlMaterial.currentItemRegistrador.codigos }"/>
					<t:dataTable styleClass="hor-minimalist-b" var="item" rows="5" 
						rendered="#{not empty controlMaterial.currentItemRegistrador.codigos }"
						width="100%" value="#{controlMaterial.currentItemRegistrador.codigos }"
						binding="#{controlMaterial.bindingRegEventosGs128 }"
						id="listamatreggs128">
						<t:column width="50%" headerstyleClass="left">
							<f:facet name="header">
								<h:outputText value="#{ms.mat_codigos_gs128_asociados }" />
							</f:facet>
							<h:panelGrid>
								<h:inputText value="#{item.codigo }" size="16" />
							</h:panelGrid>
						</t:column>
						<t:column headerstyleClass="left">
							<a4j:commandLink reRender="panGs128RegEv"
								actionListener="#{controlMaterial.delGs128Registrador }">
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
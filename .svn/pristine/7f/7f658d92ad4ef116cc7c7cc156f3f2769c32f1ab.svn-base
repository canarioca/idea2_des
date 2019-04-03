<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:r="http://richfaces.org/rich">

	<h:panelGrid width="100%">
		<h:panelGrid columns="2" rendered="false">
			<h:outputLabel value="Sala" style="font-weight: bold;" />
			<h:inputText size="100"
				value="#{controlRegistrador.registrador.implanteSala}" />
			<h:outputLabel value="Modelo" style="font-weight: bold;" />
			<h:selectOneMenu value="#{controlRegistrador.registrador.implanteModelo}" rendered="false">
				<f:selectItems value="#{controlRegistrador.modeloImplantes}" />
			</h:selectOneMenu>
			<h:outputLabel value="Num.Serie" style="font-weight: bold;" />
			<h:inputText size="25"
				value="#{controlRegistrador.registrador.nserie}" />
			<h:outputLabel value="Zona" style="font-weight: bold;" />
			<h:selectOneMenu style="width:350px;"
				value="#{controlRegistrador.registrador.implanteZona}">
				<f:selectItem itemLabel="" itemValue="0" />
				<f:selectItem itemLabel="Paraesternal izquierda" itemValue="1" />
				<f:selectItem itemLabel="Subclavia izquierda" itemValue="2" />
				<f:selectItem itemLabel="Inframamaria" itemValue="3" />
				<f:selectItem itemLabel="Axilar" itemValue="4" />
				<f:selectItem itemLabel="Otra" itemValue="5" />
			</h:selectOneMenu>
		</h:panelGrid>
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
			<t:fieldset legend="#{ms.regev_tab3_imp_title_datos_disp }">
				<h:panelGrid columns="2" id="modRegEv" columnClasses="alignTop,alignTop">
					<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
						<h:outputText value="#{ms.regev_tab3_imp_modelo }" style="font-weight: bold;"/>
						<a4j:commandLink reRender="modRegEv"
							actionListener="#{controlRegistrador.cargarModelosReg}">
							<h:graphicImage value="/img/iconos/list-view.png" width="16"
								height="16" style="border:0;" title="#{ms.regev_tab3_imp_modelo_msg_1 }"/>
						</a4j:commandLink>
					</h:panelGrid>
					<h:panelGrid columnClasses="alignTop">
						<h:outputText value="#{ms.regev_tab3_imp_nserie }" style="font-weight: bold;"/>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columnClasses="alignTop">
						<h:panelGrid>
							<h:panelGrid columns="2">
								<h:graphicImage value="/img/iconos/barcode.png" width="16" 
									rendered="#{controlRegistrador.registrador.muestrabarcode eq true }"
									height="16" style="border:0;" title="#{ms.regev_tab3_imp_barcode }"/>		
								<h:inputText id="hiddenRegEv" value="#{controlRegistrador.registrador.barcode }" 
									rendered="#{controlRegistrador.registrador.muestrabarcode eq true }">
									<a4j:support event="onchange" reRender="modRegEv" ajaxSingle="true"
						 				actionListener="#{controlRegistrador.lecturaCodigoBarrasReg}"/>
								</h:inputText>
							</h:panelGrid>
							<h:outputLabel value="#{ms.regev_tab3_imp_barcode_title }" style="font-style: italic;"
								rendered="#{controlRegistrador.registrador.muestrabarcode eq true }"/>
							<h:outputLabel value="#{controlRegistrador.registrador.implanteModelo}" />
							<h:panelGrid columns="2" rendered="#{controlRegistrador.modreg eq true}">
								<r:comboBox enableManualInput="true" defaultLabel="#{ms.regev_tab3_imp_modelo_msg_2 }" width="220"
									value="#{controlRegistrador.registrador.implanteModelo}" 
									rendered="#{controlRegistrador.registrador.idRegistrador ne null }">
									<f:selectItems value="#{controlRegistrador.regs2 }"/>
									<a4j:support event="onchange" reRender="modRegEv" ajaxSingle="true"
										actionListener="#{controlRegistrador.cambiaModeloReg }"/>
								</r:comboBox>
								<r:comboBox enableManualInput="true" defaultLabel="#{ms.regev_tab3_imp_modelo_msg_2 }" width="220"
									value="#{controlRegistrador.registrador.implanteModelo}" 
									rendered="#{controlRegistrador.registrador.idRegistrador eq null }">
									<f:selectItems value="#{controlRegistrador.regs }"/>
									<a4j:support event="onchange" reRender="modRegEv" ajaxSingle="true"
										actionListener="#{controlRegistrador.cambiaModeloReg }"/>
								</r:comboBox>
							</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2"
						columnClasses="alignTop,alignTop" id="nserieRegEv">
						<h:inputText id="NumSerRegEv" size="30" value="#{controlRegistrador.registrador.nserie}" maxlength="45">
							<a4j:support event="onchange" reRender="nserieRegEv" ajaxSingle="true"
								actionListener="#{controlRegistrador.lecturaCodigoBarrasNumSerie}"/>
						</h:inputText>	
						<a4j:commandLink reRender="nserieRegEv"
							actionListener="#{controlRegistrador.delNumSerieReg }">
							<h:graphicImage url="/img/iconos/limpia.png"
								title="#{ms.regev_tab3_imp_nserie_borrar }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</h:panelGrid>
				</h:panelGrid>
			</t:fieldset>
			<h:panelGrid>
				<h:outputLabel value="#{ms.regev_tab3_imp_zona }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu style="width:350px;" value="#{controlRegistrador.registrador.implanteZona}">
						<f:selectItem itemLabel="" itemValue="0" />
						<f:selectItem itemLabel="#{ms.regev_tab3_imp_zona_op1 }" itemValue="1" />
						<f:selectItem itemLabel="#{ms.regev_tab3_imp_zona_op2 }" itemValue="2" />
						<f:selectItem itemLabel="#{ms.regev_tab3_imp_zona_op3 }" itemValue="3" />
						<f:selectItem itemLabel="#{ms.regev_tab3_imp_zona_op4 }" itemValue="4" />
						<f:selectItem itemLabel="#{ms.regev_tab3_imp_zona_op5 }" itemValue="5" />
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
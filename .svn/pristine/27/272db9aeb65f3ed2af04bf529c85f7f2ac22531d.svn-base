<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid>
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
			<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
				<h:panelGrid>
					<h:outputLabel value="#{ms.holter24h_tab2_col_ref }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;">
						<h:selectOneMenu value="#{controlHolter.holter.referidor }">
							<f:selectItems value="#{controlHolter.referidores}" />
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="2" columnClasses="alignTop,alignTop" id="diagIniHolter">
					<h:panelGrid>
						<h:outputLabel value="#{ms.holter24h_tab2_col_diag_ini }" style="font-weight: bold;" />	
						<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2">
							<h:selectOneMenu value="#{controlHolter.holter.diagnosticoini }">
								<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="0" />
								<f:selectItem itemLabel="#{ms.holter24h_tab2_col_diag_ini_op1 }" itemValue="1" />
								<f:selectItem itemLabel="#{ms.holter24h_tab2_col_diag_ini_op2 }" itemValue="2" />
								<f:selectItem itemLabel="#{ms.holter24h_tab2_col_diag_ini_op3 }" itemValue="3" />
								<f:selectItem itemLabel="#{ms.holter24h_tab2_col_diag_ini_op4 }" itemValue="4" />
								<a4j:support event="onchange" reRender="diagIniHolter" ajaxSingle="true"/>										
							</h:selectOneMenu>
							<h:inputText value="#{controlHolter.holter.diaginiotro }"
								rendered="#{controlHolter.holter.diagnosticoini eq 4}"/>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="2" id="panColocacionLecturaHolter24">
				<a4j:commandLink style="border:0;font-size:12px;" rendered="#{controlHolter.holter.idholter ne null and controlHolter.DIR_ESCUCHA_LECTURA_SD_CLIENTE ne null and controlHolter.holter.lecturasd eq true}"
					onclick="if (!confirm('Atención: En caso de que hubiera contenido previo asociado a este registro de holter se borrará del sistema ¿desea continuar?')) return false;javascript:Richfaces.showModalPanel('buscando');"
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
					actionListener="#{controlHolter.lecturaHolter}" reRender="panHolter">						
					<h:graphicImage value="/img/iconos/sd.png" 
			         	title="#{ms.holter24h_tab2_col_sd_msg_1 }" styleClass="centerStyle" width="48" height="48"/>
				</a4j:commandLink>
				<h:outputLabel value="#{ms.holter24h_tab2_col_sd_msg_2 }" rendered="#{controlHolter.holter.idholter ne null and controlHolter.DIR_ESCUCHA_LECTURA_SD_CLIENTE ne null and controlHolter.holter.lecturasd eq true}"
					style="font-weight: bold;font-style: italic;color: #E57F27;" />
				<h:graphicImage value="/img/iconos/sd_dis.png" rendered="#{controlHolter.holter.idholter ne null and controlHolter.DIR_ESCUCHA_LECTURA_SD_CLIENTE ne null and controlHolter.holter.lecturasd eq false}"
			         title="#{ms.holter24h_tab2_col_sd_msg_3 }" styleClass="centerStyle" width="48" height="48"/>
			    <h:panelGrid columns="2">
			    	<h:selectBooleanCheckbox value="#{controlHolter.holter.lecturasd }"
			    		rendered="#{controlHolter.holter.idholter ne null and controlHolter.DIR_ESCUCHA_LECTURA_SD_CLIENTE ne null and controlHolter.holter.lecturasd eq false}">
						<a4j:support event="onclick" reRender="panColocacionLecturaHolter24" ajaxSingle="true"/>
					</h:selectBooleanCheckbox>
			    	<h:outputLabel value="#{ms.holter24h_tab2_col_sd_msg_4 }" rendered="#{controlHolter.holter.idholter ne null and controlHolter.DIR_ESCUCHA_LECTURA_SD_CLIENTE ne null and controlHolter.holter.lecturasd eq false}"
						style="font-weight: bold;font-style: italic;color: #0059b3;" />
			    </h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>	
		<h:panelGrid columns="2" width="90%" columnClasses="left,left">
			<h:panelGrid>
				<t:fieldset legend="#{ms.holter24h_tab2_col_coloc_title }">
					<h:panelGrid>
						<h:outputLabel value="#{ms.holter24h_tab2_col_coloc_fechacol }" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
								showWeeksBar="false" direction="bottom-left"
								value="#{controlHolter.holter.fechacolocacion }" />
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="#{ms.holter24h_tab2_col_coloc_med }" style="font-weight: bold;" />
							<h:outputLabel value="#{ms.holter24h_tab2_col_coloc_enf }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlHolter.holter.colocacionMed }">
									<f:selectItems value="#{controlEef.primerOperador}" />
								</h:selectOneMenu>
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlHolter.holter.colocacionEnf }">
									<f:selectItems value="#{controlEef.enfermeras}" />
								</h:selectOneMenu>
							</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
					
				</t:fieldset>
			</h:panelGrid>
			<h:panelGrid>
				<t:fieldset legend="#{ms.holter24h_tab2_col_ret_title }">
					<h:panelGrid>
						<h:outputLabel value="#{ms.holter24h_tab2_col_ret_fecharet }" style="font-weight: bold;"/>
						<h:panelGrid style="border-top: solid 1px;border-color: black;">
							<rich:calendar datePattern="dd/MM/yyyy" inputSize="12"
								showWeeksBar="false" direction="bottom-left"
								value="#{controlHolter.holter.fecharetirada }" />
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="#{ms.holter24h_tab2_col_ret_med }" style="font-weight: bold;" />
							<h:outputLabel value="#{ms.holter24h_tab2_col_ret_enf }" style="font-weight: bold;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlHolter.holter.retiradaMed }">
									<f:selectItems value="#{controlEef.primerOperador}" />
								</h:selectOneMenu>
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlHolter.holter.retiradaEnf }">
									<f:selectItems value="#{controlEef.enfermeras}" />
								</h:selectOneMenu>
							</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
					
				</t:fieldset>
			</h:panelGrid>
		</h:panelGrid>
		
		<h:outputLabel value="#{ms.holter24h_tab2_col_coment }" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;">
			<h:inputTextarea value="#{controlHolter.holter.comentariosCol }" rows="4" cols="147" id="comentariosHolterColoc">
				<f:validateLength maximum="2000" />
			</h:inputTextarea>
			<h:message for="comentariosHolterColoc" style="color:red" />	
		</h:panelGrid>
		<rich:spacer width="10" />	
		
	</h:panelGrid>
	
</ui:composition>
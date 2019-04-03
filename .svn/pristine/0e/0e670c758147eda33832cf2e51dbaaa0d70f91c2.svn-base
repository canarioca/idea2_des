<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

<h:panelGrid width="100%" columns="2" columnClasses="alignLeft,alignRight">
	<h:outputText value="#{ms.sc_gen_title }" style="font-weight:bold;" />
	<h:outputLabel value="#{ms.sc_gen_ultmod_1 }: #{controlPacientes.filtro.sitclin.fechamod }" style="font-weight: bold;" 
		rendered="#{controlPacientes.filtro.sitclin.fechamod ne null}">
		<f:convertDateTime pattern="dd.MM.yyyy" timeZone="GMT+2"/>
	</h:outputLabel>
</h:panelGrid>	
<rich:separator width="100%" height="1" />	
<h:panelGrid width="100%">	
	<h:panelGrid width="60%" rendered="false">
		<h:outputLabel value="#{ms.sc_feyec_msg_1 }"
			style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%">
			<h:selectOneRadio layout="lineDirection"
				value="#{controlPacientes.filtro.sitclin.funcionventricular }">
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
			</h:selectOneRadio>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid columns="2" width="100%">
		<h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputText value="#{ms.sc_feyec_msg_2 }"
					style="font-weight: bold;" />
				<h:outputText value="#{ms.sc_feyec_msg_3 }"
					style="font-weight: bold;"  />		
				<h:panelGrid style="border-top: solid 1px;border-color: black;" id="feviSitClinGen">
					<h:inputText size="5" maxlength="5" value="#{controlPacientes.filtro.sitclin.fevi }">
						<a4j:support event="onchange" reRender="funcionventricularSitClinGen" ajaxSingle="true"
								actionListener="#{controlPacientes.ordenaFEVI}"/>
					</h:inputText>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" id="funcionventricularSitClinGen">
					<h:selectOneMenu value="#{controlPacientes.filtro.sitclin.funcionventricular }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemLabel="#{ms.sc_feyec_msg_4 }" itemValue="0" />
						<f:selectItem itemLabel="&gt;50%" itemValue="1" />
						<f:selectItem itemLabel="41-50%" itemValue="2" />
						<f:selectItem itemLabel="36-40%" itemValue="3" />
						<f:selectItem itemLabel="31-35%" itemValue="4" />
						<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
						<f:selectItem itemLabel="#{ms.sc_feyec_msg_5 }" itemValue="6" />
						<a4j:support event="onchange" reRender="feviSitClinGen" ajaxSingle="true"
							actionListener="#{controlPacientes.resetFEVI}"/>					
					</h:selectOneMenu>
				</h:panelGrid>		
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_gen_ultmod_1 }:#{controlPacientes.filtro.sitclin.fechamodfevi }" style="font-weight: bold;" 
					rendered="#{controlPacientes.filtro.sitclin.fechamodfevi ne null}"/>
			</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="chadvascSitClin">
		<t:fieldset legend="#{ms.sc_chadvas_title }" rendered="#{controlPacientes.filtro.sitclin.antefa eq true}">
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_chadvas_msg_1 }: #{controlPacientes.filtro.sitclin.scorechadsvasc }" rendered="#{controlPacientes.filtro.sitclin.scorechadsvasc ne -1}"/>
				<h:outputLabel value="#{ms.sc_chadvas_msg_2 }: #{controlPacientes.filtro.sitclin.scorechadsvascporcent }%" rendered="#{controlPacientes.filtro.sitclin.scorechadsvasc ne -1}"/>
				<h:outputLabel value="#{ms.sc_chadvas_msg_3 }" 
					rendered="#{controlPacientes.filtro.sitclin.scorechadsvasc eq -1}"
					style="background:#E17009;font:bold;color:white"/>
			</h:panelGrid>		
		</t:fieldset>
	</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid id="aiSitClinGen" columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_1 }" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText size="5" maxlength="5" value="#{controlPacientes.filtro.sitclin.ai}">
					
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_2 }" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.filtro.sitclin.ai2}">
					<f:selectItem itemLabel="#{ms.sc_ai_msg_3 }" itemValue="0"/>
					<f:selectItem itemLabel="#{ms.sc_ai_msg_4 }" itemValue="1"/>
					<f:selectItem itemLabel="#{ms.sc_ai_msg_5 }" itemValue="2"/>
					<f:selectItem itemLabel="#{ms.sc_ai_msg_6 }" itemValue="3"/>	
				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>	
	</h:panelGrid>
	
	<h:panelGrid width="55%" id="icSitClinGen">
		<h:panelGrid columns="2">		
			<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.ic}">
				<a4j:support event="onclick" reRender="icSitClinGen" ajaxSingle="true"
				actionListener="#{controlPacientes.cambiaIC }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_ic_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" columns="2" rendered="#{controlPacientes.filtro.sitclin.ic eq true}">
			<h:panelGrid columns="2" width="100%">
				<h:outputLabel value="#{ms.sc_ic_msg_2 }" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlPacientes.filtro.sitclin.nyha}">
					<f:selectItem itemLabel="I" itemValue="1" />
					<f:selectItem itemLabel="II" itemValue="2" />
					<f:selectItem itemLabel="III" itemValue="3" />
					<f:selectItem itemLabel="IV" itemValue="4" />
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="tablaCardiopatiaSitClinGen">
		<h:panelGrid columns="2">			
			<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.cardiop}">
				<a4j:support event="onclick" reRender="tablaCardiopatiaSitClinGen" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_cardiopatia_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" rendered="#{controlPacientes.filtro.sitclin.cardiop eq true}">		
			<h:selectOneMenu value="#{controlPacientes.filtro.sitclin.cardiopatia}">
				<f:selectItems value="#{controlPacientes.cardiopatia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatiaSitClinGen" ajaxSingle="true"/>							
			</h:selectOneMenu>
			<h:inputText value="#{controlPacientes.filtro.sitclin.otra}" maxlength="45"
				rendered="#{controlPacientes.filtro.sitclin.cardiopatia eq 923}"/>
			<h:panelGrid columns="2" rendered="#{controlPacientes.filtro.sitclin.cardiopatia ne 913}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_2 }"/>
				<h:inputText value="#{controlPacientes.filtro.sitclin.aevolucion}" size="4" maxlength="4"/>
			</h:panelGrid>
			<h:panelGrid columns="4" rendered="#{controlPacientes.filtro.sitclin.cardiopatia eq 914}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_3 }"/>
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.revascularizacion }">
					<a4j:support event="onclick" actionListener="#{controlPacientes.reVasc}"/>
				</h:selectBooleanCheckbox>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_4 }"/>
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.infartoprev }">
					<a4j:support event="onclick" reRender="tablaCardiopatiaSitClinGen" ajaxSingle="true"
						actionListener="#{controlPacientes.infPrevio}"/>
				</h:selectBooleanCheckbox>	
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_5 }" rendered="#{controlPacientes.filtro.sitclin.infartoprev eq true}"/>
				<h:inputText value="#{controlPacientes.filtro.sitclin.anio }" size="4" maxlength="4" rendered="#{controlPacientes.filtro.sitclin.infartoprev eq true}"/>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_6 }" rendered="#{controlPacientes.filtro.sitclin.infartoprev eq true}"/>
				<h:selectOneMenu value="#{controlPacientes.filtro.sitclin.localizacion }"
					rendered="#{controlPacientes.filtro.sitclin.infartoprev eq true}">
					<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
					<f:selectItem itemValue="1" itemLabel="#{ms.sc_cardiopatia_infprev_loc_msg_1 }" />
					<f:selectItem itemValue="2" itemLabel="#{ms.sc_cardiopatia_infprev_loc_msg_2 }" />
					<f:selectItem itemValue="3" itemLabel="#{ms.sc_cardiopatia_infprev_loc_msg_3 }" />
					<f:selectItem itemValue="4" itemLabel="#{ms.sc_cardiopatia_infprev_loc_msg_4 }" />	
					<f:selectItem itemValue="5" itemLabel="#{ms.sc_cardiopatia_infprev_loc_msg_5 }" />
					<f:selectItem itemValue="6" itemLabel="#{ms.sc_cardiopatia_infprev_loc_msg_6 }" />
					<f:selectItem itemValue="7" itemLabel="#{ms.sc_cardiopatia_infprev_loc_msg_7 }" />		
					<f:selectItem itemValue="8" itemLabel="#{ms.sc_cardiopatia_infprev_loc_msg_8 }" />
					<f:selectItem itemValue="9" itemLabel="#{ms.sc_cardiopatia_infprev_loc_msg_9 }" />		
				</h:selectOneMenu>
			</h:panelGrid>		
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid width="100%">
		<h:outputLabel value="#{ms.sc_antecedentes }" style="font-weight: bold;" />
		<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;">
			<h:panelGrid id="arritmiasventricularesSitClinGen" width="100%" cellspacing="0">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.avent }">
						<a4j:support event="onclick" reRender="arritmiasventricularesSitClinGen" ajaxSingle="true"
							actionListener="#{controlPacientes.cambiaArritmiasVentriculares }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_arritmias_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlPacientes.filtro.sitclin.avent eq true}">
					<h:panelGrid width="100%">
						<h:selectOneRadio layout="lineDirection"
							value="#{controlPacientes.filtro.sitclin.arritmias }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_2 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_3 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_4 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_5 }" itemValue="4" />
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="eefprevioSitClinGen" width="80%" cellspacing="0">
				<h:panelGrid columns="2">				
					<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.eefprev }">
						<a4j:support event="onclick" reRender="eefprevioSitClinGen" ajaxSingle="true"
							actionListener="#{controlPacientes.cambiaEefPrevio }"/>	
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlPacientes.filtro.sitclin.eefprev eq true}">
					<h:panelGrid width="100%" columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_2 }"/>
						<h:selectOneRadio layout="lineDirection"
							value="#{controlPacientes.filtro.sitclin.eef }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_3 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_4 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_5 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_6 }" itemValue="4" />
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="7" width="100%" id="panelAntecedentesSitClinGen">
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.antefa }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen,chadvascSitClin" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteFA}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_fa_msg }" title="#{ms.sc_antecedentes_fa_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteflutter }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteFlutter}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_flut_msg }" title="#{ms.sc_antecedentes_flut_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteSincope }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.cambiaSincope}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_sinc_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteParadaCardiaca }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlPacientes.cambiaParadaCardiaca}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_pcar_msg }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteHTA }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteHTA}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_hta_msg }"/>
			</h:panelGrid>	
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.antehipercol }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteHipercoles }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_disl_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.enfarterios }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.cambiaEnfArt}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_eart_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteinsrenal }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteInsRenal}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_iren_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.antediab }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteDiab}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_diab_msg }"/>
			</h:panelGrid>		
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.antefam }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteFam}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_msub_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteacv }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteACV }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_acv_msg }" title="#{ms.sc_antecedentes_acv_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteAIT }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlPacientes.cambiaAIT}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_ait_msg }" title="#{ms.sc_antecedentes_ait_title }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteTrasplanteCardiaco }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteTCardiaco}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tcar_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.antetabaq }">
					<a4j:support event="onclick" reRender="panelAntecedentesSitClinGen" 
						ajaxSingle="true" actionListener="#{controlPacientes.anteTabaq }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tabq_msg }"/>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
			<h:panelGrid id="antecedentesNoCardio">
				<h:outputLabel value="#{ms.sc_antecedentes_nc }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
					<h:panelGrid columns="2">	
						<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteEPOC }">
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlPacientes.cambiaEPOC}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_epoc_msg }" title="#{ms.sc_antecedentes_nc_epoc_title }"/>
					</h:panelGrid>						
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteSAHS }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="SitClinGenSAHS"
								actionListener="#{controlPacientes.cambiaSAHS}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_1 }" title=""/>				
					</h:panelGrid>
					<h:panelGrid columns="6" id="SitClinGenSAHS">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_2 }" rendered="#{controlPacientes.filtro.sitclin.anteSAHS eq true }"/>
						<h:selectOneMenu value="#{controlPacientes.filtro.sitclin.tiposahs }"
							rendered="#{controlPacientes.filtro.sitclin.anteSAHS eq true }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_3 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_4 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_5 }" />	
							<f:selectItem itemValue="4" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_6 }" />				
						</h:selectOneMenu>	
						<h:outputLabel value="#{ms.sc_antecedentes_nc_ahi_msg }" rendered="#{controlPacientes.filtro.sitclin.anteSAHS eq true }" title=""/>
						<h:inputText value="#{controlPacientes.filtro.sitclin.ahi }" rendered="#{controlPacientes.filtro.sitclin.anteSAHS eq true }" size="3" maxlength="10"/>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_cpap_msg }" rendered="#{controlPacientes.filtro.sitclin.anteSAHS eq true }"/>
						<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteCPAP }"
							rendered="#{controlPacientes.filtro.sitclin.anteSAHS eq true }" id="cpapSitClinGen">
							<a4j:support event="onclick" ajaxSingle="true" reRender="cpapSitClinGen"					
								actionListener="#{controlPacientes.cambiaCPAP}"/> 
						</h:selectBooleanCheckbox>
					</h:panelGrid>
					<rich:spacer width="20"></rich:spacer>
					<h:panelGrid columns="4">
						<h:selectBooleanCheckbox value="#{controlPacientes.filtro.sitclin.anteNeoplasia }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="SitClinGenNeoplasia"
								actionListener="#{controlPacientes.cambiaNeoplasia}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_1 }" />			
					</h:panelGrid>
					<h:panelGrid columns="2" id="SitClinGenNeoplasia">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_2 }" rendered="#{controlPacientes.filtro.sitclin.anteNeoplasia eq true }"/>
						<h:inputText value="#{controlPacientes.filtro.sitclin.tiponeoplasia }" rendered="#{controlPacientes.filtro.sitclin.anteNeoplasia eq true}" maxlength="45"/>				
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_tir_msg_1 }" />	
						<h:selectOneMenu value="#{controlPacientes.filtro.sitclin.afectiroidea }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_3 }" />					
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neur_msg_1 }" />	
						<h:selectOneMenu value="#{controlPacientes.filtro.sitclin.neuromediados }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_3 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_4 }" />					
						</h:selectOneMenu>	
					</h:panelGrid>
					<rich:spacer width="20"></rich:spacer>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_alergias }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputTextarea cols="50" rows="4" value="#{controlPacientes.filtro.sitclin.alergias }" id="alergiasSitClinGen">
						<f:validateLength maximum="200" />
					</h:inputTextarea>	
					<h:message for="alergiasSitClinGen" style="color:red" />
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>		
	</h:panelGrid>
	<h:panelGrid>
		<h:outputLabel value="#{ms.sc_comentarios }" style="font-weight: bold;" />
		<rich:separator width="100%" height="1" />
		<h:panelGrid
			width="80%" cellspacing="0">
			<h:inputTextarea cols="140" rows="8" value="#{controlPacientes.filtro.sitclin.comentarios }" id="comentariosSitClinGen">
				<f:validateLength maximum="2000" />
			</h:inputTextarea>	
			<h:message for="comentariosSitClinGen" style="color:red" />
		</h:panelGrid>
	</h:panelGrid>
</h:panelGrid>	

</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
		<h:outputLabel value="#{ms.sc_sintomas }" style="font-weight: bold;" />
		<a4j:commandLink reRender="tablaSintomasRegEvExt" actionListener="#{controlRegEvExt.addSintoma }">
			<h:graphicImage value="/img/iconos/add.png" width="16"
				height="16" style="border:0;" title="#{ms.sc_sintomas_add }"/>				
		</a4j:commandLink>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaSintomasRegEvExt" width="100%" columnClasses="alignTop,alignTop,alignTop">
			<t:dataTable styleClass="hor-minimalist-b" var="listasintoma"
				width="100%" value="#{controlRegEvExt.sitclin.sintomas }"
				binding="#{controlRegEvExt.bindingSintomas}">
				<t:column width="30%" headerstyleClass="left">	
					<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
						<h:selectOneMenu value="#{listasintoma.idsintomas }">
							<f:selectItems value="#{controlRegEvExt.sintomas }" />
							<a4j:support event="onchange" reRender="tablaSintomasRegEvExt" ajaxSingle="true"
								actionListener="#{controlRegEvExt.controlSintomas }"/>
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaSintomasRegEvExt"
						actionListener="#{controlRegEvExt.delSintoma }">
						<h:graphicImage url="/img/iconos/minus.png"
							title="#{ms.sc_sintomas_del }" width="16" height="16"
							style="border: 0px;" />
					</a4j:commandLink>
				</t:column>
			</t:dataTable>
		</h:panelGrid>
	</h:panelGrid>	
	<h:panelGrid width="60%">
		<h:outputLabel value="#{ms.sc_ecg_title }" style="font-weight: bold;" />
		<h:panelGrid columns="3" width="100%"
			style="border-top: solid 1px;border-color: black;"
			columnClasses="alignTop33,alignTop33,alignTop33">
			<h:outputLabel value="#{ms.sc_ecg_ritmo }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.sc_ecg_cav }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.sc_ecg_qrs }" style="font-weight: bold;" />
			<h:panelGrid id="tablaRitmosRegEvExt"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlRegEvExt.sitclin.ritmo }">
					<f:selectItems value="#{controlRegEvExt.ritmos}" />	
					<a4j:support event="onchange" reRender="ritmosadicionalesRegEvExt" ajaxSingle="true"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaCondAVRegEvExt"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlRegEvExt.sitclin.conducav }">
					<f:selectItems value="#{controlRegEvExt.conducciones}" />
					<a4j:support event="onchange" reRender="conduccionavadicionalRegEvExt" ajaxSingle="true"/>					
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaQRSRegEvExt"
				style="border-top: solid 1px;border-color: black;" columns="5">
				<h:selectOneMenu value="#{controlRegEvExt.sitclin.qrs }">
					<f:selectItems value="#{controlRegEvExt.qrs}" />
					<a4j:support event="onchange" reRender="qrsadicionalesRegEvExt" ajaxSingle="true"/>		
				</h:selectOneMenu>
				<rich:spacer width="10"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs_anchura }" style="font-weight: bold;" />
				<h:inputText value="#{controlRegEvExt.sitclin.anchuraqrs}" size="4" maxlength="5"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs_anchura_ms }" style="font-weight: bold;" />
			</h:panelGrid>
			<h:panelGrid id="ritmosadicionalesRegEvExt">	
				<h:panelGrid id="tablaRitmosRegEvExtSA" rendered="#{controlRegEvExt.sitclin.ritmo eq 1028}">
					<h:selectOneMenu value="#{controlRegEvExt.sitclin.ritmo2 }">
						<f:selectItems value="#{controlRegEvExt.ritmossa}" />					
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaRitmosRegEvExtFA" rendered="#{controlRegEvExt.sitclin.ritmo eq 56}">
					<h:selectOneMenu value="#{controlRegEvExt.sitclin.ritmo2 }">
						<f:selectItems value="#{controlRegEvExt.ritmosfa}" />					
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaRitmosRegEvExtTV" rendered="#{controlRegEvExt.sitclin.ritmo eq 60}">
					<h:selectOneMenu value="#{controlRegEvExt.sitclin.ritmo2 }">
						<f:selectItems value="#{controlRegEvExt.ritmostv}" />					
					</h:selectOneMenu>
				</h:panelGrid>	
			</h:panelGrid>	
			<h:panelGrid id="conduccionavadicionalRegEvExt">
				<h:panelGrid id="tablaConduccionAVOtrosRegEvExt" rendered="#{controlRegEvExt.sitclin.conducav eq 64}">
					<h:selectOneMenu value="#{controlRegEvExt.sitclin.conducav2 }">
						<f:selectItems value="#{controlRegEvExt.conduccionavotros}" />					
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>	
			<h:panelGrid id="qrsadicionalesRegEvExt" >
				<h:panelGrid id="tablaqrsadicionalesRegEvExt" rendered="#{controlRegEvExt.sitclin.qrs eq 75}">
					<h:selectOneMenu value="#{controlRegEvExt.sitclin.qrs2 }">
						<f:selectItems value="#{controlRegEvExt.qrsotros}" />					
					</h:selectOneMenu>
					<h:inputText value="" style="font-weight: bold;" rendered="false"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid columns="2">
		<h:outputText value="#{ms.sc_feyec_msg_2 }" style="font-weight: bold;" />
		<h:outputText value="#{ms.sc_feyec_msg_3 }" style="font-weight: bold;"  />
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="feviRegEvExt">
			<h:inputText size="5" maxlength="5" value="#{controlRegEvExt.sitclin.fevi }">
				<a4j:support event="onchange" reRender="funcionventricularRegEvExt" ajaxSingle="true"
					actionListener="#{controlRegEvExt.ordenaFEVI }"/>
			</h:inputText>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="funcionventricularRegEvExt">
			<h:selectOneMenu value="#{controlRegEvExt.sitclin.funcionventricular }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_4 }" itemValue="0" />
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_5 }" itemValue="6" />
				<a4j:support event="onchange" reRender="feviRegEvExt" ajaxSingle="true"
					actionListener="#{controlRegEvExt.resetFEVI }"/>					
			</h:selectOneMenu>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="aiSitClinRegEvExt" columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_1 }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:inputText size="5" maxlength="5" value="#{controlRegEvExt.sitclin.ai }">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlRegEvExt.cambiaAI}"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_2 }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:selectOneMenu value="#{controlRegEvExt.sitclin.ai2 }">
					<f:selectItem itemLabel="#{ms.sc_ai_msg_3 }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_4 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_5 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_6 }" itemValue="3" />	
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlRegEvExt.cambiaAI2}"/>				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid width="45%" id="icRegEvExt">
		<h:panelGrid columns="2">		
			<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.ic}">
				<a4j:support event="onclick" reRender="icRegEvExt" ajaxSingle="true"
					actionListener="#{controlRegEvExt.cambiaIC }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_ic_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" columns="2" rendered="#{controlRegEvExt.sitclin.ic eq true}">
			<h:panelGrid columns="2" width="100%">
				<h:outputLabel value="#{ms.sc_ic_msg_2 }" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection" value="#{controlRegEvExt.sitclin.nyha}">
					<f:selectItem itemLabel="I" itemValue="1" />
					<f:selectItem itemLabel="II" itemValue="2" />
					<f:selectItem itemLabel="III" itemValue="3" />
					<f:selectItem itemLabel="IV" itemValue="4" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlRegEvExt.cambiaNYHA}"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="tablaCardiopatiaRegEvExt">
		<h:panelGrid columns="2">			
			<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.cardiop}">
				<a4j:support event="onclick" reRender="tablaCardiopatiaRegEvExt" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_cardiopatia_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" rendered="#{controlRegEvExt.sitclin.cardiop eq true}">		
			<h:selectOneMenu value="#{controlRegEvExt.sitclin.cardiopatia}">
				<f:selectItems value="#{controlRegEvExt.cardiopatia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatiaRegEvExt" ajaxSingle="true"
					actionListener="#{controlRegEvExt.cambiaCardiopatiaEtiologia }"/>							
			</h:selectOneMenu> 
			<h:inputText value="#{controlRegEvExt.sitclin.otra}" maxlength="45"
				rendered="#{controlRegEvExt.sitclin.cardiopatia eq 923}"/>
			<h:panelGrid columns="2" rendered="#{controlRegEvExt.sitclin.cardiopatia ne 913}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_2 }"/>
				<h:inputText value="#{controlRegEvExt.sitclin.aevolucion}" size="4" maxlength="4">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlRegEvExt.cambiaAnosEvolucion }"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="4" rendered="#{controlRegEvExt.sitclin.cardiopatia eq 914}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_3 }"/>
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.revascularizacion }">
					<a4j:support event="onclick" actionListener="#{controlRegEvExt.reVasc}"/>
				</h:selectBooleanCheckbox>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_4 }"/>
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.infartoprev }">
					<a4j:support event="onclick" reRender="tablaCardiopatiaRegEvExt" ajaxSingle="true"
						actionListener="#{controlRegEvExt.infPrevio}"/>
				</h:selectBooleanCheckbox>	
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_5 }" rendered="#{controlRegEvExt.sitclin.infartoprev eq true}"/>
				<h:inputText value="#{controlRegEvExt.sitclin.anio }" size="4" maxlength="4" rendered="#{controlRegEvExt.sitclin.infartoprev eq true}">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlRegEvExt.cambiaAnosInfPrevio }"/>
				</h:inputText>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_6 }" rendered="#{controlRegEvExt.sitclin.infartoprev eq true}"/>
				<h:selectOneMenu value="#{controlRegEvExt.sitclin.localizacion }"
					rendered="#{controlRegEvExt.sitclin.infartoprev eq true}">
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
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlRegEvExt.cambiaLocalizacion }"/>					
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid>
		<h:outputLabel value="#{ms.sc_antecedentes }" style="font-weight: bold;" />
		<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" columnClasses="alignTop,alignTop">
			<h:panelGrid id="arritmiasventricularesRegEvExt" width="100%" cellspacing="0">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.avent }">
						<a4j:support event="onclick" reRender="arritmiasventricularesRegEvExt" ajaxSingle="true"
							actionListener="#{controlRegEvExt.cambiaArritmiasVentriculares }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_arritmias_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlRegEvExt.sitclin.avent eq true}">
					<h:panelGrid width="100%">
						<h:selectOneRadio layout="lineDirection" value="#{controlRegEvExt.sitclin.arritmias }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_2 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_3 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_4 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_5 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlRegEvExt.cambiaArrVent }"/>
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="RegEvExtprevioRegEvExt" width="80%" cellspacing="0">
				<h:panelGrid columns="2">				
					<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.eefprev }">
						<a4j:support event="onclick" reRender="RegEvExtprevioRegEvExt" ajaxSingle="true"
							actionListener="#{controlRegEvExt.cambiaEefPrevio }"/>	
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlRegEvExt.sitclin.eefprev eq true}">
					<h:panelGrid width="100%" columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_2 }"/>
						<h:selectOneRadio layout="lineDirection" value="#{controlRegEvExt.sitclin.eef }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_3 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_4 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_5 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_6 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlRegEvExt.cambiaEEF }"/>
						</h:selectOneRadio>
					</h:panelGrid> 
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="7" width="100%" id="panelAntecedentesIndicacionRegEvExt">
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.antefa }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteFA }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_fa_msg }" title="#{ms.sc_antecedentes_fa_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteflutter }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteFlutter }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_flut_msg }" title="#{ms.sc_antecedentes_flut_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteSincope }">
					<a4j:support event="onclick"  
						ajaxSingle="true" actionListener="#{controlRegEvExt.cambiaSincope}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_sinc_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteParadaCardiaca }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlRegEvExt.cambiaParadaCardiaca}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_pcar_msg }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteHTA }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteHipertens }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_hta_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.antehipercol }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteHipercoles }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_disl_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.enfarterios }">
					<a4j:support event="onclick" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.cambiaEnfArt}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_eart_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteinsrenal }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteInsRenal }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_iren_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.antediab }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteDiab }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_diab_msg }"/>
			</h:panelGrid>		
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.antefam }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteFam }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_msub_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteacv }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteACV }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_acv_msg }" title="#{ms.sc_antecedentes_acv_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteAIT }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlRegEvExt.cambiaAIT}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_ait_msg }" title="#{ms.sc_antecedentes_ait_title }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteTrasplanteCardiaco }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteTCardiaco}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tcar_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.antetabaq }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionRegEvExt" 
						ajaxSingle="true" actionListener="#{controlRegEvExt.anteTabaq }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tabq_msg }"/>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid>
			<h:panelGrid id="antecedentesNoCardioRegEvExt">
				<h:outputLabel value="#{ms.sc_antecedentes_nc }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
					<h:panelGrid columns="2">	
						<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteEPOC }">
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlRegEvExt.cambiaEPOC}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_epoc_msg }" title="#{ms.sc_antecedentes_nc_epoc_title }"/>
					</h:panelGrid>							
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteSAHS }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="RegEvExtSAHS"
								actionListener="#{controlRegEvExt.cambiaSAHS}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_1 }" title=""/>				
					</h:panelGrid>
					<h:panelGrid columns="6" id="RegEvExtSAHS">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_2 }" rendered="#{controlRegEvExt.sitclin.anteSAHS eq true }"/>
						<h:selectOneMenu value="#{controlRegEvExt.sitclin.tiposahs }"
							rendered="#{controlRegEvExt.sitclin.anteSAHS eq true }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_3 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_4 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_5 }" />	
							<f:selectItem itemValue="4" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_6 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlRegEvExt.cambiaTipoSAHS }"/>				
						</h:selectOneMenu>	
						<h:outputLabel value="#{ms.sc_antecedentes_nc_ahi_msg }" rendered="#{controlRegEvExt.sitclin.anteSAHS eq true }" title=""/>
						<h:inputText value="#{controlRegEvExt.sitclin.ahi }" rendered="#{controlRegEvExt.sitclin.anteSAHS eq true }" size="3" maxlength="10"/>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_cpap_msg }" rendered="#{controlRegEvExt.sitclin.anteSAHS eq true }"/>
						<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteCPAP }"
							rendered="#{controlRegEvExt.sitclin.anteSAHS eq true }" id="cpapRegEvExt">
							<a4j:support event="onclick" ajaxSingle="true" reRender="cpapRegEvExt"					
								actionListener="#{controlRegEvExt.cambiaCPAP}"/>
						</h:selectBooleanCheckbox>
					</h:panelGrid>
					<rich:spacer width="20"></rich:spacer>
					<h:panelGrid columns="4">
						<h:selectBooleanCheckbox value="#{controlRegEvExt.sitclin.anteNeoplasia }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="RegEvExtNeoplasia"
								actionListener="#{controlRegEvExt.cambiaNeoplasia}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_1 }" />			
					</h:panelGrid>
					<h:panelGrid columns="2" id="RegEvExtNeoplasia">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_2 }" rendered="#{controlRegEvExt.sitclin.anteNeoplasia eq true }"/>
						<h:inputText value="#{controlRegEvExt.sitclin.tiponeoplasia }" maxlength="45" rendered="#{controlRegEvExt.sitclin.anteNeoplasia eq true}">
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlRegEvExt.cambiaTipoNeoplasia }"/>
						</h:inputText>				
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_tir_msg_1 }" />	
						<h:selectOneMenu value="#{controlRegEvExt.sitclin.afectiroidea }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_3 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlRegEvExt.cambiaAfecTiroidea }"/>					
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neur_msg_1 }" />	
						<h:selectOneMenu value="#{controlRegEvExt.sitclin.neuromediados }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_3 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_4 }" />
							<a4j:support event="onchange" ajaxSingle="true" 
								actionListener="#{controlRegEvExt.cambiaNeurologicos }"/>					
						</h:selectOneMenu>	
					</h:panelGrid>
					<rich:spacer width="20"></rich:spacer>
					<h:panelGrid>
						<h:outputLabel value="#{ms.sc_comentarios }" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;"
							width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">					
							<h:inputTextarea cols="120" rows="8" value="#{controlRegEvExt.sitclin.comentarios }" id="comentariosIndicacionRegEvExt" >
								 <f:validateLength maximum="2000" />
							</h:inputTextarea>	
							<h:message for="comentariosIndicacionRegEvExt" style="color:red" />
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_alergias }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputTextarea cols="50" rows="4" value="#{controlRegEvExt.sitclin.alergias }" id="alergiasRegEvExt">
						<f:validateLength maximum="200" />
						<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlRegEvExt.cambiaAlergias }"/>
					</h:inputTextarea>	
					<h:message for="alergiasRegEvExt" style="color:red" />
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
		<h:outputLabel value="#{ms.sc_sintomas }"
				style="font-weight: bold;" />
		<a4j:commandLink reRender="tablaSintomasHolter"
				actionListener="#{controlHolter.addSintoma }">
			<h:graphicImage value="/img/iconos/add.png" width="16"
				height="16" style="border:0;" title="#{ms.sc_sintomas_add }"/>				
		</a4j:commandLink>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaSintomasHolter" width="100%" columnClasses="alignTop,alignTop,alignTop">
			<t:dataTable styleClass="hor-minimalist-b" var="listasintoma"
					width="100%" value="#{controlHolter.sitclin.sintomas }"
					binding="#{controlHolter.bindingSintomas}">
				<t:column width="30%" headerstyleClass="left">	
					<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
						<h:selectOneMenu value="#{listasintoma.idsintomas }">
							<f:selectItems value="#{controlHolter.sintomas }" />
							<a4j:support event="onchange" reRender="tablaSintomasHolter" ajaxSingle="true"
								actionListener="#{controlHolter.controlSintomas }"/>
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaSintomasHolter"
						actionListener="#{controlHolter.delSintoma }">
						<h:graphicImage url="/img/iconos/minus.png"
							title="#{ms.sc_sintomas_del }" width="16" height="16"
							style="border: 0px;" />
					</a4j:commandLink>
				</t:column>
			</t:dataTable>
		</h:panelGrid>
	</h:panelGrid>	
	<h:panelGrid width="60%">
			<h:outputLabel value="#{ms.sc_ecg_title }"
				style="font-weight: bold;" />
			<h:panelGrid columns="3" width="100%"
				style="border-top: solid 1px;border-color: black;"
				columnClasses="alignTop33,alignTop33,alignTop33">
				<h:outputLabel value="#{ms.sc_ecg_ritmo }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.sc_ecg_cav }" style="font-weight: bold;" />
				<h:outputLabel value="#{ms.sc_ecg_qrs }" style="font-weight: bold;" />
	
				<h:panelGrid id="tablaRitmosHolter"
					style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlHolter.sitclin.ritmo }">
						<f:selectItems value="#{controlHolter.ritmos}" />	
						<a4j:support event="onchange" reRender="ritmosadicionalesHolter" ajaxSingle="true"/>				
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaCondAVHolter"
					style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlHolter.sitclin.conducav }">
						<f:selectItems value="#{controlHolter.conducciones}" />
						<a4j:support event="onchange" reRender="conduccionavadicionalHolter" ajaxSingle="true"/>					
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaQRSHolter"
					style="border-top: solid 1px;border-color: black;" columns="5">
					<h:selectOneMenu value="#{controlHolter.sitclin.qrs }">
						<f:selectItems value="#{controlHolter.qrs}" />
						<a4j:support event="onchange" reRender="qrsadicionalesHolter" ajaxSingle="true"/>		
					</h:selectOneMenu>
					<rich:spacer width="10"/>
					<h:outputLabel value="#{ms.sc_ecg_qrs_anchura }"
						style="font-weight: bold;" />
					<h:inputText value="#{controlHolter.sitclin.anchuraqrs}" size="4" maxlength="5"/>
					<h:outputLabel value="#{ms.sc_ecg_qrs_anchura_ms }"
						style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid id="ritmosadicionalesHolter">	
					<h:panelGrid id="tablaRitmosHolterSA" rendered="#{controlHolter.sitclin.ritmo eq 1028}">
						<h:selectOneMenu value="#{controlHolter.sitclin.ritmo2 }">
							<f:selectItems value="#{controlHolter.ritmossa}" />					
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid id="tablaRitmosHolterFA" rendered="#{controlHolter.sitclin.ritmo eq 56}">
						<h:selectOneMenu value="#{controlHolter.sitclin.ritmo2 }">
							<f:selectItems value="#{controlHolter.ritmosfa}" />					
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid id="tablaRitmosHolterTV" rendered="#{controlHolter.sitclin.ritmo eq 60}">
						<h:selectOneMenu value="#{controlHolter.sitclin.ritmo2 }">
							<f:selectItems value="#{controlHolter.ritmostv}" />					
						</h:selectOneMenu>
					</h:panelGrid>	
				</h:panelGrid>	
				<h:panelGrid id="conduccionavadicionalHolter">
					<h:panelGrid id="tablaConduccionAVOtrosHolter" rendered="#{controlHolter.sitclin.conducav eq 64}">
						<h:selectOneMenu value="#{controlHolter.sitclin.conducav2 }">
							<f:selectItems value="#{controlHolter.conduccionavotros}" />					
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>	
				<h:panelGrid id="qrsadicionalesHolter" >
					<h:panelGrid id="tablaqrsadicionalesHolter" rendered="#{controlHolter.sitclin.qrs eq 75}">
						<h:selectOneMenu value="#{controlHolter.sitclin.qrs2 }">
							<f:selectItems value="#{controlHolter.qrsotros}" />					
						</h:selectOneMenu>
						<h:inputText value="" style="font-weight: bold;" rendered="false"/>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	<h:panelGrid columns="2">
		<h:outputText value="#{ms.sc_feyec_msg_2 }"
			style="font-weight: bold;" />
		<h:outputText value="#{ms.sc_feyec_msg_3 }"
			style="font-weight: bold;"  />
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="feviHolter">
			<h:inputText size="5" maxlength="5" value="#{controlHolter.sitclin.fevi }">
				<a4j:support event="onchange" reRender="funcionventricularHolter" ajaxSingle="true"
						actionListener="#{controlHolter.ordenaFEVI }"/>
			</h:inputText>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="funcionventricularHolter">
			<h:selectOneMenu value="#{controlHolter.sitclin.funcionventricular }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_4 }" itemValue="0" />
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_5 }" itemValue="6" />
				<a4j:support event="onchange" reRender="feviHolter" ajaxSingle="true"
					actionListener="#{controlHolter.resetFEVI }"/>					
			</h:selectOneMenu>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="aiSitClinHolter" columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_1 }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:inputText size="5" maxlength="5" value="#{controlHolter.sitclin.ai }">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlHolter.cambiaAI}"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_2 }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:selectOneMenu value="#{controlHolter.sitclin.ai2 }">
					<f:selectItem itemLabel="#{ms.sc_ai_msg_3 }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_4 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_5 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_6 }" itemValue="3" />	
					<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlHolter.cambiaAI2}"/>				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	
	</h:panelGrid>
	<h:panelGrid width="45%" id="icHolter">
		<h:panelGrid columns="2">		
			<h:selectBooleanCheckbox value="#{controlHolter.sitclin.ic}">
				<a4j:support event="onclick" reRender="icHolter" ajaxSingle="true"
					actionListener="#{controlHolter.cambiaIC }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_ic_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" columns="2" rendered="#{controlHolter.sitclin.ic eq true}">
			<h:panelGrid columns="2" width="100%">
				<h:outputLabel value="#{ms.sc_ic_msg_2 }" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlHolter.sitclin.nyha}">
					<f:selectItem itemLabel="I" itemValue="1" />
					<f:selectItem itemLabel="II" itemValue="2" />
					<f:selectItem itemLabel="III" itemValue="3" />
					<f:selectItem itemLabel="IV" itemValue="4" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlHolter.cambiaNYHA}"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="tablaCardiopatiaHolter">
		<h:panelGrid columns="2">			
			<h:selectBooleanCheckbox value="#{controlHolter.sitclin.cardiop}">
				<a4j:support event="onclick" reRender="tablaCardiopatiaHolter" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_cardiopatia_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" rendered="#{controlHolter.sitclin.cardiop eq true}">		
			<h:selectOneMenu value="#{controlHolter.sitclin.cardiopatia}">
				<f:selectItems value="#{controlHolter.cardiopatia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatiaHolter" ajaxSingle="true"
					actionListener="#{controlHolter.cambiaCardiopatiaEtiologia }"/>							
			</h:selectOneMenu> 
			<h:inputText value="#{controlHolter.sitclin.otra}" maxlength="45"
				rendered="#{controlHolter.sitclin.cardiopatia eq 923}"/>
			<h:panelGrid columns="2" rendered="#{controlHolter.sitclin.cardiopatia ne 913}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_2 }"/>
				<h:inputText value="#{controlHolter.sitclin.aevolucion}" size="4" maxlength="4">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlHolter.cambiaAnosEvolucion }"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="4" rendered="#{controlHolter.sitclin.cardiopatia eq 914}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_3 }"/>
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.revascularizacion }">
					<a4j:support event="onclick" actionListener="#{controlHolter.reVasc}"/>
				</h:selectBooleanCheckbox>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_4 }"/>
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.infartoprev }">
					<a4j:support event="onclick" reRender="tablaCardiopatiaHolter" ajaxSingle="true"
						actionListener="#{controlHolter.infPrevio}"/>
				</h:selectBooleanCheckbox>	
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_5 }" rendered="#{controlHolter.sitclin.infartoprev eq true}"/>
				<h:inputText value="#{controlHolter.sitclin.anio }" size="4" maxlength="4" rendered="#{controlHolter.sitclin.infartoprev eq true}">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlHolter.cambiaAnosInfPrevio }"/>
				</h:inputText>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_6 }" rendered="#{controlHolter.sitclin.infartoprev eq true}"/>
				<h:selectOneMenu value="#{controlHolter.sitclin.localizacion }"
					rendered="#{controlHolter.sitclin.infartoprev eq true}">
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
						actionListener="#{controlHolter.cambiaLocalizacion }"/>					
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid>
		<h:outputLabel value="#{ms.sc_antecedentes }" style="font-weight: bold;" />
		<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" columnClasses="alignTop,alignTop">
			<h:panelGrid id="arritmiasventricularesHolter" width="100%" cellspacing="0">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlHolter.sitclin.avent }">
						<a4j:support event="onclick" reRender="arritmiasventricularesHolter" ajaxSingle="true"
							actionListener="#{controlHolter.cambiaArritmiasVentriculares }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_arritmias_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlHolter.sitclin.avent eq true}">
					<h:panelGrid width="100%">
						<h:selectOneRadio layout="lineDirection"
							value="#{controlHolter.sitclin.arritmias }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_2 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_3 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_4 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_5 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlHolter.cambiaArrVent }"/>
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="HolterprevioHolter" width="80%" cellspacing="0">
				<h:panelGrid columns="2">				
					<h:selectBooleanCheckbox value="#{controlHolter.sitclin.eefprev }">
						<a4j:support event="onclick" reRender="HolterprevioHolter" ajaxSingle="true"
							actionListener="#{controlHolter.cambiaEefPrevio }"/>	
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlHolter.sitclin.eefprev eq true}">
					<h:panelGrid width="100%" columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_2 }"/>
						<h:selectOneRadio layout="lineDirection"
							value="#{controlHolter.sitclin.eef }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_3 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_4 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_5 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_6 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlHolter.cambiaEEF }"/>
						</h:selectOneRadio>
					</h:panelGrid> 
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="7" width="100%" id="panelAntecedentesIndicacionHolter">
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.antefa }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteFA }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_fa_msg }" title="#{ms.sc_antecedentes_fa_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteflutter }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteFlutter }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_flut_msg }" title="#{ms.sc_antecedentes_flut_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteSincope }">
					<a4j:support event="onclick"  
						ajaxSingle="true" actionListener="#{controlHolter.cambiaSincope}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_sinc_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteParadaCardiaca }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlHolter.cambiaParadaCardiaca}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_pcar_msg }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteHTA }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteHipertens }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_hta_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.antehipercol }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteHipercoles }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_disl_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.enfarterios }">
					<a4j:support event="onclick" 
						ajaxSingle="true" actionListener="#{controlHolter.cambiaEnfArt}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_eart_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteinsrenal }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteInsRenal }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_iren_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.antediab }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteDiab }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_diab_msg }"/>
			</h:panelGrid>		
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.antefam }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteFam }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_msub_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteacv }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteACV }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_acv_msg }" title="#{ms.sc_antecedentes_acv_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteAIT }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlHolter.cambiaAIT}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_ait_msg }" title="#{ms.sc_antecedentes_ait_title }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteTrasplanteCardiaco }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteTCardiaco}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tcar_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlHolter.sitclin.antetabaq }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionHolter" 
						ajaxSingle="true" actionListener="#{controlHolter.anteTabaq }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tabq_msg }"/>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid>
			<h:panelGrid id="antecedentesNoCardioHolter">
				<h:outputLabel value="#{ms.sc_antecedentes_nc }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
					<h:panelGrid columns="2">	
						<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteEPOC }">
								<a4j:support event="onclick" ajaxSingle="true"
									actionListener="#{controlHolter.cambiaEPOC}"/>
							</h:selectBooleanCheckbox>
							<h:outputLabel value="#{ms.sc_antecedentes_nc_epoc_msg }" title="#{ms.sc_antecedentes_nc_epoc_title }"/>
					</h:panelGrid>							
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteSAHS }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="HolterSAHS"
								actionListener="#{controlHolter.cambiaSAHS}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_1 }" title=""/>				
					</h:panelGrid>
					<h:panelGrid columns="6" id="HolterSAHS">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_2 }" rendered="#{controlHolter.sitclin.anteSAHS eq true }"/>
						<h:selectOneMenu value="#{controlHolter.sitclin.tiposahs }"
							rendered="#{controlHolter.sitclin.anteSAHS eq true }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_3 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_4 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_5 }" />	
							<f:selectItem itemValue="4" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_6 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlHolter.cambiaTipoSAHS }"/>				
						</h:selectOneMenu>	
						<h:outputLabel value="#{ms.sc_antecedentes_nc_ahi_msg }" rendered="#{controlHolter.sitclin.anteSAHS eq true }" title=""/>
						<h:inputText value="#{controlHolter.sitclin.ahi }" rendered="#{controlHolter.sitclin.anteSAHS eq true }" size="3" maxlength="10"/>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_cpap_msg }" rendered="#{controlHolter.sitclin.anteSAHS eq true }"/>
						<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteCPAP }"
							rendered="#{controlHolter.sitclin.anteSAHS eq true }" id="cpapHolter">
							<a4j:support event="onclick" ajaxSingle="true" reRender="cpapHolter"					
								actionListener="#{controlHolter.cambiaCPAP}"/>
						</h:selectBooleanCheckbox>
					</h:panelGrid>
					<rich:spacer width="20"></rich:spacer>
					<h:panelGrid columns="4">
						<h:selectBooleanCheckbox value="#{controlHolter.sitclin.anteNeoplasia }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="HolterNeoplasia"
								actionListener="#{controlHolter.cambiaNeoplasia}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_1 }" />			
					</h:panelGrid>
					<h:panelGrid columns="2" id="HolterNeoplasia">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_2 }" rendered="#{controlHolter.sitclin.anteNeoplasia eq true }"/>
						<h:inputText value="#{controlHolter.sitclin.tiponeoplasia }"  maxlength="45" rendered="#{controlHolter.sitclin.anteNeoplasia eq true}">
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlHolter.cambiaTipoNeoplasia }"/>
						</h:inputText>				
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_tir_msg_1 }" />	
						<h:selectOneMenu value="#{controlHolter.sitclin.afectiroidea }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_3 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlHolter.cambiaAfecTiroidea }"/>					
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neur_msg_1 }" />	
						<h:selectOneMenu value="#{controlHolter.sitclin.neuromediados }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_3 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_4 }" />
							<a4j:support event="onchange" ajaxSingle="true" 
								actionListener="#{controlHolter.cambiaNeurologicos }"/>					
						</h:selectOneMenu>	
					</h:panelGrid>
					<rich:spacer width="20"></rich:spacer>
					<h:panelGrid>
						<h:outputLabel value="#{ms.sc_comentarios }" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;"
							width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">					
							<h:inputTextarea cols="120" rows="8" value="#{controlHolter.sitclin.comentarios }" id="comentariosIndicacionHolter" >
								 <f:validateLength maximum="2000" />
							</h:inputTextarea>	
							<h:message for="comentariosIndicacionHolter" style="color:red" />
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_alergias }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputTextarea cols="50" rows="4" value="#{controlHolter.sitclin.alergias }" id="alergiasHolter">
						<f:validateLength maximum="200" />
						<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlHolter.cambiaAlergias }"/>
					</h:inputTextarea>	
					<h:message for="alergiasHolter" style="color:red" />
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
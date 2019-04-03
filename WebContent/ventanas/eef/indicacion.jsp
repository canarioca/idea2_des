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
		<a4j:commandLink reRender="tablaSintomasEef"
				actionListener="#{controlEef.addSintoma }">
			<h:graphicImage value="/img/iconos/add.png" width="16"
				height="16" style="border:0;" title="#{ms.sc_sintomas_add }"/>				
		</a4j:commandLink>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaSintomasEef" width="100%" columnClasses="alignTop,alignTop,alignTop">
			<t:dataTable styleClass="hor-minimalist-b" var="listasintoma"
					width="100%" value="#{controlEef.sitclin.sintomas }"
					binding="#{controlEef.bindingSintomas}">
				<t:column width="30%" headerstyleClass="left">	
					<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
						<h:selectOneMenu value="#{listasintoma.idsintomas }">
							<f:selectItems value="#{controlImplantes.sintomas }" />
							<a4j:support event="onchange" reRender="tablaSintomasEef" ajaxSingle="true"
								actionListener="#{controlEef.controlSintomas }"/>
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaSintomasEef"
						actionListener="#{controlEef.delSintoma }">
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
	
				<h:panelGrid id="tablaRitmosEef"
					style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlEef.sitclin.ritmo }">
						<f:selectItems value="#{controlImplantes.ritmos}" />	
						<a4j:support event="onchange" reRender="ritmosadicionaleseef" ajaxSingle="true"/>				
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaCondAVEefEef"
					style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlEef.sitclin.conducav }">
						<f:selectItems value="#{controlImplantes.conducciones}" />
						<a4j:support event="onchange" reRender="conduccionavadicionaleef" ajaxSingle="true"/>					
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaQRSEef"
					style="border-top: solid 1px;border-color: black;" columns="5">
					<h:selectOneMenu value="#{controlEef.sitclin.qrs }">
						<f:selectItems value="#{controlImplantes.qrs}" />
						<a4j:support event="onchange" reRender="qrsadicionaleseef" ajaxSingle="true"/>		
					</h:selectOneMenu>
					<rich:spacer width="10"/>
					<h:outputLabel value="#{ms.sc_ecg_qrs_anchura }"
						style="font-weight: bold;" />
					<h:inputText value="#{controlEef.sitclin.anchuraqrs}" size="4" maxlength="5"/>
					<h:outputLabel value="#{ms.sc_ecg_qrs_anchura_ms }"
						style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid id="ritmosadicionaleseef">	
					<h:panelGrid id="tablaRitmosEefSA" rendered="#{controlEef.sitclin.ritmo eq 1028}">
						<h:selectOneMenu value="#{controlEef.sitclin.ritmo2 }">
							<f:selectItems value="#{controlImplantes.ritmossa}" />					
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid id="tablaRitmosEefFA" rendered="#{controlEef.sitclin.ritmo eq 56}">
						<h:selectOneMenu value="#{controlEef.sitclin.ritmo2 }">
							<f:selectItems value="#{controlImplantes.ritmosfa}" />					
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid id="tablaRitmosEefTV" rendered="#{controlEef.sitclin.ritmo eq 60}">
						<h:selectOneMenu value="#{controlEef.sitclin.ritmo2 }">
							<f:selectItems value="#{controlImplantes.ritmostv}" />					
						</h:selectOneMenu>
					</h:panelGrid>	
				</h:panelGrid>	
				<h:panelGrid id="conduccionavadicionaleef">
					<h:panelGrid id="tablaConduccionAVOtroseef" rendered="#{controlEef.sitclin.conducav eq 64}">
						<h:selectOneMenu value="#{controlEef.sitclin.conducav2 }">
							<f:selectItems value="#{controlImplantes.conduccionavotros}" />					
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>	
				<h:panelGrid id="qrsadicionaleseef" >
					<h:panelGrid id="tablaqrsadicionaleseef" rendered="#{controlEef.sitclin.qrs eq 75}">
						<h:selectOneMenu value="#{controlEef.sitclin.qrs2 }">
							<f:selectItems value="#{controlImplantes.qrsotros}" />					
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
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="feviEef">
			<h:inputText size="5" maxlength="5" value="#{controlEef.sitclin.fevi }">
				<a4j:support event="onchange" reRender="funcionventricularEef" ajaxSingle="true"
						actionListener="#{controlEef.ordenaFEVI }"/>
			</h:inputText>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="funcionventricularEef">
			<h:selectOneMenu value="#{controlEef.sitclin.funcionventricular }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_4 }" itemValue="0" />
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_5 }" itemValue="6" />
				<a4j:support event="onchange" reRender="feviEef" ajaxSingle="true"
					actionListener="#{controlEef.resetFEVI }"/>					
			</h:selectOneMenu>
		</h:panelGrid>		
	</h:panelGrid>
	<h:panelGrid id="aiSitClinEef" columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_1 }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:inputText size="5" maxlength="5" value="#{controlEef.sitclin.ai }">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlEef.cambiaAI}"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_2 }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:selectOneMenu value="#{controlEef.sitclin.ai2 }">
					<f:selectItem itemLabel="#{ms.sc_ai_msg_3 }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_4 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_5 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_6 }" itemValue="3" />	
					<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlEef.cambiaAI2}"/>				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	
	</h:panelGrid>
	<h:panelGrid width="45%" id="iceef">
		<h:panelGrid columns="2">		
			<h:selectBooleanCheckbox value="#{controlEef.sitclin.ic}">
				<a4j:support event="onclick" reRender="iceef" ajaxSingle="true"
					actionListener="#{controlEef.cambiaIC }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_ic_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" columns="2" rendered="#{controlEef.sitclin.ic eq true}">
			<h:panelGrid columns="2" width="100%">
				<h:outputLabel value="#{ms.sc_ic_msg_2 }" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlEef.sitclin.nyha}">
					<f:selectItem itemLabel="I" itemValue="1" />
					<f:selectItem itemLabel="II" itemValue="2" />
					<f:selectItem itemLabel="III" itemValue="3" />
					<f:selectItem itemLabel="IV" itemValue="4" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlEef.cambiaNYHA}"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="tablaCardiopatiaEef">
		<h:panelGrid columns="2">			
			<h:selectBooleanCheckbox value="#{controlEef.sitclin.cardiop}">
				<a4j:support event="onclick" reRender="tablaCardiopatiaEef" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_cardiopatia_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" rendered="#{controlEef.sitclin.cardiop eq true}">		
			<h:selectOneMenu value="#{controlEef.sitclin.cardiopatia}">
				<f:selectItems value="#{controlImplantes.cardiopatia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatiaEef" ajaxSingle="true"
					actionListener="#{controlEef.cambiaCardiopatiaEtiologia }"/>							
			</h:selectOneMenu> 
			<h:inputText value="#{controlEef.sitclin.otra}" maxlength="45"
				rendered="#{controlEef.sitclin.cardiopatia eq 923}"/>
			<h:panelGrid columns="2" rendered="#{controlEef.sitclin.cardiopatia ne 913}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_2 }"/>
				<h:inputText value="#{controlEef.sitclin.aevolucion}" size="4" maxlength="4">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlEef.cambiaAnosEvolucion }"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="4" rendered="#{controlEef.sitclin.cardiopatia eq 914}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_3 }"/>
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.revascularizacion }">
					<a4j:support event="onclick" actionListener="#{controlEef.reVasc}"/>
				</h:selectBooleanCheckbox>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_4 }"/>
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.infartoprev }">
					<a4j:support event="onclick" reRender="tablaCardiopatia" ajaxSingle="true"
						actionListener="#{controlEef.infPrevio}"/>
				</h:selectBooleanCheckbox>	
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_5 }" rendered="#{controlEef.sitclin.infartoprev eq true}"/>
				<h:inputText value="#{controlEef.sitclin.anio }" size="4" maxlength="4" rendered="#{controlEef.sitclin.infartoprev eq true}">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlEef.cambiaAnosInfPrevio }"/>
				</h:inputText>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_6 }" rendered="#{controlEef.sitclin.infartoprev eq true}"/>
				<h:selectOneMenu value="#{controlEef.sitclin.localizacion }"
					rendered="#{controlEef.sitclin.infartoprev eq true}">
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
						actionListener="#{controlEef.cambiaLocalizacion }"/>					
				</h:selectOneMenu>
			</h:panelGrid>		
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid>
		<h:outputLabel value="#{ms.sc_antecedentes }" style="font-weight: bold;" />
		<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" columnClasses="alignTop,alignTop">
			<h:panelGrid id="arritmiasventricularesEef" width="100%" cellspacing="0">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlEef.sitclin.avent }">
						<a4j:support event="onclick" reRender="arritmiasventricularesEef" ajaxSingle="true"
							actionListener="#{controlEef.cambiaArritmiasVentriculares }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_arritmias_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlEef.sitclin.avent eq true}">
					<h:panelGrid width="100%">
						<h:selectOneRadio layout="lineDirection"
							value="#{controlEef.sitclin.arritmias }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_2 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_3 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_4 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_5 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlEef.cambiaArrVent }"/>
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="eefprevioEef" width="80%" cellspacing="0">
				<h:panelGrid columns="2">				
					<h:selectBooleanCheckbox value="#{controlEef.sitclin.eefprev }">
						<a4j:support event="onclick" reRender="eefprevioEef" ajaxSingle="true"
							actionListener="#{controlEef.cambiaEefPrevio }"/>	
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlEef.sitclin.eefprev eq true}">
					<h:panelGrid width="100%" columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_2 }"/>
						<h:selectOneRadio layout="lineDirection"
							value="#{controlEef.sitclin.eef }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_3 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_4 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_5 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_6 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlEef.cambiaEEF }"/>
						</h:selectOneRadio>
					</h:panelGrid> 
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="7" width="100%" id="panelAntecedentesIndicacionEef">
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.antefa }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteFA }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_fa_msg }" title="#{ms.sc_antecedentes_fa_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteflutter }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteFlutter }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_flut_msg }" title="#{ms.sc_antecedentes_flut_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteSincope }">
					<a4j:support event="onclick"  
						ajaxSingle="true" actionListener="#{controlEef.cambiaSincope}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_sinc_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteParadaCardiaca }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlEef.cambiaParadaCardiaca}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_pcar_msg }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteHTA }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteHipertens }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_hta_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.antehipercol }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteHipercoles }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_disl_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.enfarterios }">
					<a4j:support event="onclick" 
						ajaxSingle="true" actionListener="#{controlEef.cambiaEnfArt}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_eart_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteinsrenal }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteInsRenal }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_iren_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.antediab }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteDiab }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_diab_msg }"/>
			</h:panelGrid>		
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.antefam }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteFam }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_msub_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteacv }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteACV }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_acv_msg }" title="#{ms.sc_antecedentes_acv_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteAIT }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlEef.cambiaAIT}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_ait_msg }" title="#{ms.sc_antecedentes_ait_title }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteTrasplanteCardiaco }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteTCardiaco}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tcar_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlEef.sitclin.antetabaq }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionEef" 
						ajaxSingle="true" actionListener="#{controlEef.anteTabaq }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tabq_msg }"/>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="antecedentesNoCardioEef">
			<h:outputLabel value="#{ms.sc_antecedentes_nc }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
				<h:panelGrid columns="2">	
					<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteEPOC }">
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlEef.cambiaEPOC}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_epoc_msg }" title="#{ms.sc_antecedentes_nc_epoc_title }"/>
				</h:panelGrid>							
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteSAHS }">
						<a4j:support event="onclick" ajaxSingle="true" reRender="eefSAHS"
							actionListener="#{controlEef.cambiaSAHS}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_1 }" title=""/>				
				</h:panelGrid>
				<h:panelGrid columns="6" id="eefSAHS">
					<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_2 }" rendered="#{controlEef.sitclin.anteSAHS eq true }"/>
					<h:selectOneMenu value="#{controlEef.sitclin.tiposahs }"
						rendered="#{controlEef.sitclin.anteSAHS eq true }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_3 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_4 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_5 }" />	
						<f:selectItem itemValue="4" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_6 }" />
						<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlEef.cambiaTipoSAHS }"/>				
					</h:selectOneMenu>	
					<h:outputLabel value="#{ms.sc_antecedentes_nc_ahi_msg }" rendered="#{controlEef.sitclin.anteSAHS eq true }" title=""/>
					<h:inputText value="#{controlEef.sitclin.ahi }" rendered="#{controlEef.sitclin.anteSAHS eq true }" size="3" maxlength="10"/>
					<h:outputLabel value="#{ms.sc_antecedentes_nc_cpap_msg }" rendered="#{controlEef.sitclin.anteSAHS eq true }"/>
					<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteCPAP }"
						rendered="#{controlEef.sitclin.anteSAHS eq true }" id="cpapEef">
						<a4j:support event="onclick" ajaxSingle="true" reRender="cpapEef"					
							actionListener="#{controlEef.cambiaCPAP}"/>
					</h:selectBooleanCheckbox>
				</h:panelGrid>
				<rich:spacer width="20"></rich:spacer>
				<h:panelGrid columns="4">
					<h:selectBooleanCheckbox value="#{controlEef.sitclin.anteNeoplasia }">
						<a4j:support event="onclick" ajaxSingle="true" reRender="eefNeoplasia"
							actionListener="#{controlEef.cambiaNeoplasia}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_1 }" />			
				</h:panelGrid>
				<h:panelGrid columns="2" id="eefNeoplasia">
					<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_2 }" rendered="#{controlEef.sitclin.anteNeoplasia eq true }"/>
					<h:inputText value="#{controlEef.sitclin.tiponeoplasia }"  maxlength="45" rendered="#{controlEef.sitclin.anteNeoplasia eq true}">
						<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlEef.cambiaTipoNeoplasia }"/>
					</h:inputText>				
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.sc_antecedentes_nc_tir_msg_1 }" />	
					<h:selectOneMenu value="#{controlEef.sitclin.afectiroidea }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_2 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_3 }" />
						<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlEef.cambiaAfecTiroidea }"/>					
					</h:selectOneMenu>
					<h:outputLabel value="#{ms.sc_antecedentes_nc_neur_msg_1 }" />	
					<h:selectOneMenu value="#{controlEef.sitclin.neuromediados }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_2 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_3 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_4 }" />
						<a4j:support event="onchange" ajaxSingle="true" 
							actionListener="#{controlEef.cambiaNeurologicos }"/>					
					</h:selectOneMenu>	
				</h:panelGrid>
				<rich:spacer width="20"></rich:spacer>
				<h:panelGrid>
					<h:outputLabel value="#{ms.sc_comentarios }" style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">					
						<h:inputTextarea cols="120" rows="8" value="#{controlEef.sitclin.comentarios }" id="comentariosIndicacionEef" >
							 <f:validateLength maximum="2000" />
						</h:inputTextarea>	
						<h:message for="comentariosIndicacionEef" style="color:red" />
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid>
			<h:outputLabel value="#{ms.sc_alergias }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputTextarea cols="50" rows="4" value="#{controlHolter.sitclin.alergias }" id="alergiasEef">
					<f:validateLength maximum="200" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlEef.cambiaAlergias }"/>
				</h:inputTextarea>	
				<h:message for="alergiasEef" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
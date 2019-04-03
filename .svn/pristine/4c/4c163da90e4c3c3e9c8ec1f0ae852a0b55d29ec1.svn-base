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
		<a4j:commandLink reRender="tablaSintomasSegClin"
				actionListener="#{controlSeguimientosClinicos.addSintoma }">
			<h:graphicImage value="/img/iconos/add.png" width="16"
				height="16" style="border:0;" title="#{ms.sc_sintomas_add }"/>				
		</a4j:commandLink>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaSintomasSegClin" width="100%" columnClasses="alignTop,alignTop,alignTop">
			<t:dataTable styleClass="hor-minimalist-b" var="listasintoma"
					width="100%" value="#{controlSeguimientosClinicos.stclin.sintomas }"
					binding="#{controlSeguimientosClinicos.bindingSintomas}">
				<t:column width="30%" headerstyleClass="left">	
					<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
						<h:selectOneMenu value="#{listasintoma.idsintomas }">
							<f:selectItems value="#{controlSeguimientosClinicos.sintomas }" />
							<a4j:support event="onchange" reRender="tablaSintomasSegClin" ajaxSingle="true"
								actionListener="#{controlSeguimientosClinicos.controlSintomas }"/>
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaSintomasSegClin"
						actionListener="#{controlSeguimientosClinicos.delSintoma }">
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
			<h:panelGrid id="tablaRitmosSegClin"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.ritmo }">
					<f:selectItems value="#{controlSeguimientosClinicos.ritmos}" />	
					<a4j:support event="onchange" reRender="ritmosadicionalesSegClin" ajaxSingle="true"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaCondAVSegClin"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.conducav }">
					<f:selectItems value="#{controlSeguimientosClinicos.conducciones}" />
					<a4j:support event="onchange" reRender="conduccionavadicionalSegClin" ajaxSingle="true"/>					
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaQRSSegClin"
				style="border-top: solid 1px;border-color: black;" columns="5">
				<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.qrs }">
					<f:selectItems value="#{controlSeguimientosClinicos.qrs}" />
					<a4j:support event="onchange" reRender="qrsadicionalesSegClin" ajaxSingle="true"/>		
				</h:selectOneMenu>
				<rich:spacer width="10"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs_anchura }" style="font-weight: bold;" />
				<h:inputText value="#{controlSeguimientosClinicos.stclin.anchuraqrs}" size="4" maxlength="5"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs_anchura_ms }" style="font-weight: bold;" />
			</h:panelGrid>
			<h:panelGrid id="ritmosadicionalesSegClin">	
				<h:panelGrid id="tablaRitmosSegClinSA" rendered="#{controlSeguimientosClinicos.stclin.ritmo eq 1028}">
					<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.ritmo2 }">
						<f:selectItems value="#{controlSeguimientosClinicos.ritmossa}" />					
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaRitmosSegClinFA" rendered="#{controlSeguimientosClinicos.stclin.ritmo eq 56}">
					<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.ritmo2 }">
						<f:selectItems value="#{controlSeguimientosClinicos.ritmosfa}" />					
					</h:selectOneMenu>
				</h:panelGrid>
					<h:panelGrid id="tablaRitmosSegClinTV" rendered="#{controlSeguimientosClinicos.stclin.ritmo eq 60}">
						<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.ritmo2 }">
							<f:selectItems value="#{controlSeguimientosClinicos.ritmostv}" />					
						</h:selectOneMenu>
					</h:panelGrid>	
			</h:panelGrid>	
			<h:panelGrid id="conduccionavadicionalSegClin">
				<h:panelGrid id="tablaConduccionAVOtros" rendered="#{controlSeguimientosClinicos.stclin.conducav eq 64}">
					<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.conducav2 }">
						<f:selectItems value="#{controlSeguimientosClinicos.conduccionavotros}" />					
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>	
			<h:panelGrid id="qrsadicionalesSegClin" >
				<h:panelGrid id="tablaqrsadicionalesSegClin" rendered="#{controlSeguimientosClinicos.stclin.qrs eq 75}">
					<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.qrs2 }">
						<f:selectItems value="#{controlSeguimientosClinicos.qrsotros}" />					
					</h:selectOneMenu>
					<h:inputText value="" style="font-weight: bold;" rendered="false"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid columns="2">
		<h:outputText value="#{ms.sc_feyec_msg_2 }" style="font-weight: bold;" />
		<h:outputText value="#{ms.sc_feyec_msg_3 }" style="font-weight: bold;"  />
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="fevi">
			<h:inputText size="5" maxlength="5" value="#{controlSeguimientosClinicos.stclin.fevi }">
				<a4j:support event="onchange" reRender="funcionventricularSegClin" ajaxSingle="true"
					actionListener="#{controlSeguimientosClinicos.ordenaFEVI}"/>
			</h:inputText>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="funcionventricularSegClin">
			<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.funcionventricular }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_4 }" itemValue="0" />
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_5 }" itemValue="6" />
				<a4j:support event="onchange" reRender="fevi" ajaxSingle="true"
					actionListener="#{controlSeguimientosClinicos.resetFEVI }"/>					
			</h:selectOneMenu>
		</h:panelGrid>		
	</h:panelGrid>
	<h:panelGrid id="aiSitClinSegClin" columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_1 }" 
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:inputText size="5" maxlength="5" value="#{controlSeguimientosClinicos.stclin.ai }">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlSeguimientosClinicos.cambiaAI}"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_2 }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.ai2 }">
					<f:selectItem itemLabel="#{ms.sc_ai_msg_3 }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_4 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_5 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_6 }" itemValue="3" />	
					<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlSeguimientosClinicos.cambiaAI2}"/>				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid width="45%" id="icSegClin">
		<h:panelGrid columns="2">		
			<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.ic}">
				<a4j:support event="onclick" reRender="icSegClin" ajaxSingle="true"
				actionListener="#{controlSeguimientosClinicos.cambiaIC }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_ic_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" columns="2" rendered="#{controlSeguimientosClinicos.stclin.ic eq true}">
			<h:panelGrid columns="2" width="100%">
				<h:outputLabel value="#{ms.sc_ic_msg_2 }" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlSeguimientosClinicos.stclin.nyha}">
					<f:selectItem itemLabel="I" itemValue="1" />
					<f:selectItem itemLabel="II" itemValue="2" />
					<f:selectItem itemLabel="III" itemValue="3" />
					<f:selectItem itemLabel="IV" itemValue="4" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlSeguimientosClinicos.cambiaNYHA}"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="tablaCardiopatiaSegClin">
		<h:panelGrid columns="2">			
			<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.cardiop}">
				<a4j:support event="onclick" reRender="tablaCardiopatiaSegClin" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_cardiopatia_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" rendered="#{controlSeguimientosClinicos.stclin.cardiop eq true}">		
			<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.cardiopatia}">
				<f:selectItems value="#{controlSeguimientosClinicos.cardiopatia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatiaSegClin" ajaxSingle="true"
					actionListener="#{controlSeguimientosClinicos.cambiaCardiopatiaEtiologia }"/>							
			</h:selectOneMenu>
			<h:inputText value="#{controlSeguimientosClinicos.stclin.otra}" maxlength="45"
				rendered="#{controlSeguimientosClinicos.stclin.cardiopatia eq 923}"/>
			<h:panelGrid columns="2" rendered="#{controlSeguimientosClinicos.stclin.cardiopatia ne 913}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_2 }"/>
				<h:inputText value="#{controlSeguimientosClinicos.stclin.aevolucion}" size="4" maxlength="4">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlSeguimientosClinicos.cambiaAnosEvolucion}"/> 
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="4" rendered="#{controlSeguimientosClinicos.stclin.cardiopatia eq 914}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_3 }"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.revascularizacion }">
					<a4j:support event="onclick" actionListener="#{controlSeguimientosClinicos.reVasc}"/>
				</h:selectBooleanCheckbox>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_4 }"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.infartoprev }">
					<a4j:support event="onclick" reRender="tablaCardiopatiaSegClin" ajaxSingle="true"
						actionListener="#{controlSeguimientosClinicos.infPrevio}"/>
				</h:selectBooleanCheckbox>	
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_5 }" rendered="#{controlSeguimientosClinicos.stclin.infartoprev eq true}"/>
				<h:inputText value="#{controlSeguimientosClinicos.stclin.anio }" size="4" maxlength="4" 
					rendered="#{controlSeguimientosClinicos.stclin.infartoprev eq true}">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlSeguimientosClinicos.cambiaAnosInfPrevio }"/>
				</h:inputText>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_6 }" rendered="#{controlSeguimientosClinicos.stclin.infartoprev eq true}"/>
				<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.localizacion }"
					rendered="#{controlSeguimientosClinicos.stclin.infartoprev eq true}">
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
						actionListener="#{controlSeguimientosClinicos.cambiaLocalizacion }"/>					
				</h:selectOneMenu>
			</h:panelGrid>		
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid>
		<h:outputLabel value="#{ms.sc_antecedentes }" style="font-weight: bold;" />
		<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" columnClasses="alignTop,alignTop">
			<h:panelGrid id="arritmiasventricularesSegClin" width="100%" cellspacing="0">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.avent }">
						<a4j:support event="onclick" reRender="arritmiasventricularesSegClin" ajaxSingle="true"
							actionListener="#{controlSeguimientosClinicos.cambiaArritmiasVentriculares }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_arritmias_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlSeguimientosClinicos.stclin.avent eq true}">
					<h:panelGrid width="100%">
						<h:selectOneRadio layout="lineDirection"
							value="#{controlSeguimientosClinicos.stclin.arritmias }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_2 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_3 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_4 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_5 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosClinicos.cambiaArrVent }"/>
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="eefprevioSegClin" width="80%" cellspacing="0">
				<h:panelGrid columns="2">				
					<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.eefprev }">
						<a4j:support event="onclick" reRender="eefprevioSegClin" ajaxSingle="true"
							actionListener="#{controlSeguimientosClinicos.cambiaEefPrevio }"/>	
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlSeguimientosClinicos.stclin.eefprev eq true}">
					<h:panelGrid width="100%" columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_2 }"/>
						<h:selectOneRadio layout="lineDirection"
							value="#{controlSeguimientosClinicos.stclin.eef }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_3 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_4 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_5 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_6 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosClinicos.cambiaEEF }"/>
						</h:selectOneRadio>
					</h:panelGrid> 
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="7" width="100%" id="panelAntecedentesIndicacionSegClin">
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.antefa }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteFA }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_fa_msg }" title="#{ms.sc_antecedentes_fa_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteflutter }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteFlutter }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_flut_msg }" title="#{ms.sc_antecedentes_flut_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteSincope }">
					<a4j:support event="onclick"  
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.cambiaSincope}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_sinc_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteParadaCardiaca }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlSeguimientosClinicos.cambiaParadaCardiaca}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_pcar_msg }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteHTA }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteHipertens }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_hta_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.antehipercol }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteHipercoles }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_disl_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.enfarterios }">
					<a4j:support event="onclick" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.cambiaEnfArt}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_eart_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteinsrenal }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteInsRenal}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_iren_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.antediab }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteDiab }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_diab_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.antefam }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteFam }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_msub_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteacv }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteACV }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_acv_msg }" title="#{ms.sc_antecedentes_acv_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteAIT }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlSeguimientosClinicos.cambiaAIT}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_ait_msg }" title="#{ms.sc_antecedentes_ait_title }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteTrasplanteCardiaco }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteTCardiaco}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tcar_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.antetabaq }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegClin" 
						ajaxSingle="true" actionListener="#{controlSeguimientosClinicos.anteTabaq }"/>
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
						<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteEPOC }">
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlSeguimientosClinicos.cambiaEPOC}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_epoc_msg }" title="#{ms.sc_antecedentes_nc_epoc_title }"/>
					</h:panelGrid>							
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteSAHS }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="implanteSAHSSegClin"
								actionListener="#{controlSeguimientosClinicos.cambiaSAHS}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_1 }" title=""/>				
					</h:panelGrid>
					<h:panelGrid columns="6" id="implanteSAHSSegClin">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_2 }" rendered="#{controlSeguimientosClinicos.stclin.anteSAHS eq true }"/>
						<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.tiposahs }"
							rendered="#{controlSeguimientosClinicos.stclin.anteSAHS eq true }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_3 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_4 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_5 }" />	
							<f:selectItem itemValue="4" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_6 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosClinicos.cambiaTipoSAHS }"/>				
						</h:selectOneMenu>	
						<h:outputLabel value="#{ms.sc_antecedentes_nc_ahi_msg }" rendered="#{controlSeguimientosClinicos.stclin.anteSAHS eq true }" title=""/>
						<h:inputText value="#{controlSeguimientosClinicos.stclin.ahi }" rendered="#{controlSeguimientosClinicos.stclin.anteSAHS eq true }" size="3" maxlength="10"/>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_cpap_msg }" rendered="#{controlSeguimientosClinicos.stclin.anteSAHS eq true }"/>
						<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteCPAP }"
							rendered="#{controlSeguimientosClinicos.stclin.anteSAHS eq true }" id="cpapImpSegClin">
							<a4j:support event="onclick" ajaxSingle="true" reRender="cpapImpSegClin"					
								actionListener="#{controlSeguimientosClinicos.cambiaCPAP}"/>
						</h:selectBooleanCheckbox>
					</h:panelGrid>
					<rich:spacer width="20"/>
					<h:panelGrid columns="4">
						<h:selectBooleanCheckbox value="#{controlSeguimientosClinicos.stclin.anteNeoplasia }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="impNeoplasiaSegClin"
								actionListener="#{controlSeguimientosClinicos.cambiaNeoplasia}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_1 }" />			
					</h:panelGrid>
					<h:panelGrid columns="2" id="impNeoplasiaSegClin">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_2 }" rendered="#{controlSeguimientosClinicos.stclin.anteNeoplasia eq true }"/>
						<h:inputText value="#{controlSeguimientosClinicos.stclin.tiponeoplasia }"  maxlength="45" 
							rendered="#{controlSeguimientosClinicos.stclin.anteNeoplasia eq true}">
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosClinicos.cambiaTipoNeoplasia }"/>
						</h:inputText>				
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_tir_msg_1 }" />	
						<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.afectiroidea }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_3 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosClinicos.cambiaAfecTiroidea }"/>					
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neur_msg_1 }" />	
						<h:selectOneMenu value="#{controlSeguimientosClinicos.stclin.neuromediados }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_3 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_4 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosClinicos.cambiaNeurologicos }"/>					
						</h:selectOneMenu>	
					</h:panelGrid>
					<rich:spacer width="20"/>
					<h:panelGrid>
						<h:outputLabel value="#{ms.sc_comentarios }" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;"
							width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">					
							<h:inputTextarea cols="120" rows="8" value="#{controlSeguimientosClinicos.stclin.comentarios }" id="comentariosIndicacionSegClin" >
								 <f:validateLength maximum="2000" />
							</h:inputTextarea>	
							<h:message for="comentariosIndicacionSegClin" style="color:red" />
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_alergias }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputTextarea cols="50" rows="4" value="#{controlSeguimientosClinicos.stclin.alergias }" id="alergiasSegClin">
						<f:validateLength maximum="200" />
						<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlSeguimientosClinicos.cambiaAlergias }"/>
					</h:inputTextarea>	
					<h:message for="alergiasSegClin" style="color:red" />
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>		
	</h:panelGrid>
</ui:composition>
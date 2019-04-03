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
		<a4j:commandLink reRender="tablaSintomasSegRegEv"
				actionListener="#{controlSeguimientosRegEventos.addSintoma }">
			<h:graphicImage value="/img/iconos/add.png" width="16"
				height="16" style="border:0;" title="#{ms.sc_sintomas_add }"/>				
		</a4j:commandLink>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaSintomasSegRegEv" width="100%" columnClasses="alignTop,alignTop,alignTop">
			<t:dataTable styleClass="hor-minimalist-b" var="listasintoma"
					width="100%" value="#{controlSeguimientosRegEventos.stclin.sintomas }"
					binding="#{controlSeguimientosRegEventos.bindingSintomas}">
				<t:column width="30%" headerstyleClass="left">	
					<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
						<h:selectOneMenu value="#{listasintoma.idsintomas }">
							<f:selectItems value="#{controlSeguimientosRegEventos.sintomas }" />
							<a4j:support event="onchange" reRender="tablaSintomasSegRegEv" ajaxSingle="true"
								actionListener="#{controlSeguimientosRegEventos.controlSintomas }"/>
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaSintomasSegRegEv"
						actionListener="#{controlSeguimientosRegEventos.delSintoma }">
						<h:graphicImage url="/img/iconos/minus.png"
							title="#{ms.sc_sintomas_del }" width="16" height="16"
							style="border: 0px;" />
					</a4j:commandLink>
				</t:column>
			</t:dataTable>
		</h:panelGrid>
	</h:panelGrid>	
	<h:panelGrid width="60%">
		<h:outputLabel value="Electrocardiograma Basal" style="font-weight: bold;" />
		<h:panelGrid columns="3" width="100%"
			style="border-top: solid 1px;border-color: black;"
			columnClasses="alignTop33,alignTop33,alignTop33">
			<h:outputLabel value="#{ms.sc_ecg_ritmo }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.sc_ecg_cav }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.sc_ecg_qrs }" style="font-weight: bold;" />
			<h:panelGrid id="tablaRitmosSegRegEv"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.ritmo }">
					<f:selectItems value="#{controlSeguimientosRegEventos.ritmos}" />	
					<a4j:support event="onchange" reRender="ritmosadicionalesSegRegEv" ajaxSingle="true"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaCondAVSegRegEv"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.conducav }">
					<f:selectItems value="#{controlSeguimientosRegEventos.conducciones}" />
					<a4j:support event="onchange" reRender="conduccionavadicionalSegRegEv" ajaxSingle="true"/>					
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaQRSSegRegEv"
				style="border-top: solid 1px;border-color: black;" columns="5">
				<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.qrs }">
					<f:selectItems value="#{controlSeguimientosRegEventos.qrs}" />
					<a4j:support event="onchange" reRender="qrsadicionalesSegRegEv" ajaxSingle="true"/>		
				</h:selectOneMenu>
				<rich:spacer width="10"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs_anchura }" style="font-weight: bold;" />
				<h:inputText value="#{controlSeguimientosRegEventos.stclin.anchuraqrs}" size="4" maxlength="5"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs_anchura_ms }" style="font-weight: bold;" />
			</h:panelGrid>
			<h:panelGrid id="ritmosadicionalesSegRegEv">	
				<h:panelGrid id="tablaRitmosSegRegEvSA" rendered="#{controlSeguimientosRegEventos.stclin.ritmo eq 1028}">
					<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.ritmo2 }">
						<f:selectItems value="#{controlSeguimientosRegEventos.ritmossa}" />					
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaRitmosSegRegEvFA" rendered="#{controlSeguimientosRegEventos.stclin.ritmo eq 56}">
					<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.ritmo2 }">
						<f:selectItems value="#{controlSeguimientosRegEventos.ritmosfa}" />					
					</h:selectOneMenu>
				</h:panelGrid>
					<h:panelGrid id="tablaRitmosSegRegEvTV" rendered="#{controlSeguimientosRegEventos.stclin.ritmo eq 60}">
						<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.ritmo2 }">
							<f:selectItems value="#{controlSeguimientosRegEventos.ritmostv}" />					
						</h:selectOneMenu>
					</h:panelGrid>	
			</h:panelGrid>	
			<h:panelGrid id="conduccionavadicionalSegRegEv">
				<h:panelGrid id="tablaConduccionAVOtros" rendered="#{controlSeguimientosRegEventos.stclin.conducav eq 64}">
					<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.conducav2 }">
						<f:selectItems value="#{controlSeguimientosRegEventos.conduccionavotros}" />					
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>	
			<h:panelGrid id="qrsadicionalesSegRegEv" >
				<h:panelGrid id="tablaqrsadicionalesSegRegEv" rendered="#{controlSeguimientosRegEventos.stclin.qrs eq 75}">
					<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.qrs2 }">
						<f:selectItems value="#{controlSeguimientosRegEventos.qrsotros}" />					
					</h:selectOneMenu>
					<h:inputText value="" style="font-weight: bold;" rendered="false"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid columns="2">
		<h:outputText value="#{ms.sc_feyec_msg_2 }" style="font-weight: bold;" />
		<h:outputText value="#{ms.sc_feyec_msg_3 }" style="font-weight: bold;"  />
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="feviRegEv">
			<h:inputText size="5" maxlength="5" value="#{controlSeguimientosRegEventos.stclin.fevi }">
				<a4j:support event="onchange" reRender="funcionventricularSegRegEv" ajaxSingle="true"
					actionListener="#{controlSeguimientosRegEventos.ordenaFEVI}"/>
			</h:inputText>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="funcionventricularSegRegEv">
			<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.funcionventricular }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_4 }" itemValue="0" />
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_5 }" itemValue="6" />
				<a4j:support event="onchange" reRender="feviRegEv" ajaxSingle="true"
					actionListener="#{controlSeguimientosRegEventos.resetFEVI }"/>					
			</h:selectOneMenu>
		</h:panelGrid>		
	</h:panelGrid>
	<h:panelGrid id="aiSitClinSegRegEv" columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_1 }" 
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:inputText size="5" maxlength="5" value="#{controlSeguimientosRegEventos.stclin.ai }">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlSeguimientosRegEventos.cambiaAI}"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_2 }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.ai2 }">
					<f:selectItem itemLabel="#{ms.sc_ai_msg_3 }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_4 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_5 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_6 }" itemValue="3" />	
					<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlSeguimientosRegEventos.cambiaAI2}"/>				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid width="45%" id="icSegRegEv">
		<h:panelGrid columns="2">		
			<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.ic}">
				<a4j:support event="onclick" reRender="icSegRegEv" ajaxSingle="true"
				actionListener="#{controlSeguimientosRegEventos.cambiaIC }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_ic_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" columns="2" rendered="#{controlSeguimientosRegEventos.stclin.ic eq true}">
			<h:panelGrid columns="2" width="100%">
				<h:outputLabel value="#{ms.sc_ic_msg_2 }" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlSeguimientosRegEventos.stclin.nyha}">
					<f:selectItem itemLabel="I" itemValue="1" />
					<f:selectItem itemLabel="II" itemValue="2" />
					<f:selectItem itemLabel="III" itemValue="3" />
					<f:selectItem itemLabel="IV" itemValue="4" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlSeguimientosRegEventos.cambiaNYHA}"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="tablaCardiopatiaSegRegEv">
		<h:panelGrid columns="2">			
			<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.cardiop}">
				<a4j:support event="onclick" reRender="tablaCardiopatiaSegRegEv" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_cardiopatia_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" rendered="#{controlSeguimientosRegEventos.stclin.cardiop eq true}">		
			<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.cardiopatia}">
				<f:selectItems value="#{controlSeguimientosRegEventos.cardiopatia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatiaSegRegEv" ajaxSingle="true"
					actionListener="#{controlSeguimientosRegEventos.cambiaCardiopatiaEtiologia }"/>							
			</h:selectOneMenu>
			<h:inputText value="#{controlSeguimientosRegEventos.stclin.otra}" maxlength="45"
				rendered="#{controlSeguimientosRegEventos.stclin.cardiopatia eq 923}"/>
			<h:panelGrid columns="2" rendered="#{controlSeguimientosRegEventos.stclin.cardiopatia ne 913}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_2 }"/>
				<h:inputText value="#{controlSeguimientosRegEventos.stclin.aevolucion}" size="4" maxlength="4">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlSeguimientosRegEventos.cambiaAnosEvolucion}"/> 
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="4" rendered="#{controlSeguimientosRegEventos.stclin.cardiopatia eq 914}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_3 }"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.revascularizacion }">
					<a4j:support event="onclick" actionListener="#{controlSeguimientosRegEventos.reVasc}"/>
				</h:selectBooleanCheckbox>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_4 }"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.infartoprev }">
					<a4j:support event="onclick" reRender="tablaCardiopatiaSegRegEv" ajaxSingle="true"
						actionListener="#{controlSeguimientosRegEventos.infPrevio}"/>
				</h:selectBooleanCheckbox>	
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_5 }" rendered="#{controlSeguimientosRegEventos.stclin.infartoprev eq true}"/>
				<h:inputText value="#{controlSeguimientosRegEventos.stclin.anio }" size="4" maxlength="4" 
					rendered="#{controlSeguimientosRegEventos.stclin.infartoprev eq true}">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlSeguimientosRegEventos.cambiaAnosInfPrevio }"/>
				</h:inputText>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_6 }" rendered="#{controlSeguimientosRegEventos.stclin.infartoprev eq true}"/>
				<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.localizacion }"
					rendered="#{controlSeguimientosRegEventos.stclin.infartoprev eq true}">
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
						actionListener="#{controlSeguimientosRegEventos.cambiaLocalizacion }"/>					
				</h:selectOneMenu>
			</h:panelGrid>		
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid>
		<h:outputLabel value="#{ms.sc_antecedentes }" style="font-weight: bold;" />
		<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" columnClasses="alignTop,alignTop">
			<h:panelGrid id="arritmiasventricularesSegRegEv" width="100%" cellspacing="0">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.avent }">
						<a4j:support event="onclick" reRender="arritmiasventricularesSegRegEv" ajaxSingle="true"
							actionListener="#{controlSeguimientosRegEventos.cambiaArritmiasVentriculares }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_arritmias_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlSeguimientosRegEventos.stclin.avent eq true}">
					<h:panelGrid width="100%">
						<h:selectOneRadio layout="lineDirection"
							value="#{controlSeguimientosRegEventos.stclin.arritmias }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_2 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_3 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_4 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_5 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosRegEventos.cambiaArrVent }"/>
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="eefprevioSegRegEv" width="80%" cellspacing="0">
				<h:panelGrid columns="2">				
					<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.eefprev }">
						<a4j:support event="onclick" reRender="eefprevioSegRegEv" ajaxSingle="true"
							actionListener="#{controlSeguimientosRegEventos.cambiaEefPrevio }"/>	
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlSeguimientosRegEventos.stclin.eefprev eq true}">
					<h:panelGrid width="100%" columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_2 }"/>
						<h:selectOneRadio layout="lineDirection"
							value="#{controlSeguimientosRegEventos.stclin.eef }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_3 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_4 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_5 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_6 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosRegEventos.cambiaEEF }"/>
						</h:selectOneRadio>
					</h:panelGrid> 
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="7" width="100%" id="panelAntecedentesIndicacionSegRegEv">
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.antefa }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteFA }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_fa_msg }" title="#{ms.sc_antecedentes_fa_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteflutter }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteFlutter }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_flut_msg }" title="#{ms.sc_antecedentes_flut_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteSincope }">
					<a4j:support event="onclick"  
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.cambiaSincope}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_sinc_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteParadaCardiaca }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlSeguimientosRegEventos.cambiaParadaCardiaca}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_pcar_msg }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteHTA }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteHipertens }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_hta_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.antehipercol }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteHipercoles }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_disl_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.enfarterios }">
					<a4j:support event="onclick" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.cambiaEnfArt}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_eart_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteinsrenal }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteInsRenal}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_iren_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.antediab }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteDiab }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_diab_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.antefam }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteFam }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_msub_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteacv }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteACV }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_acv_msg }" title="#{ms.sc_antecedentes_acv_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteAIT }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlSeguimientosRegEventos.cambiaAIT}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_ait_msg }" title="#{ms.sc_antecedentes_ait_title }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteTrasplanteCardiaco }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteTCardiaco}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tcar_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.antetabaq }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionSegRegEv" 
						ajaxSingle="true" actionListener="#{controlSeguimientosRegEventos.anteTabaq }"/>
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
						<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteEPOC }">
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlSeguimientosRegEventos.cambiaEPOC}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_epoc_msg }" title="#{ms.sc_antecedentes_nc_epoc_title }"/>
					</h:panelGrid>							
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteSAHS }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="implanteSAHSSegRegEv"
								actionListener="#{controlSeguimientosRegEventos.cambiaSAHS}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_1 }" title=""/>				
					</h:panelGrid>
					<h:panelGrid columns="6" id="implanteSAHSSegRegEv">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_2 }" rendered="#{controlSeguimientosRegEventos.stclin.anteSAHS eq true }"/>
						<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.tiposahs }"
							rendered="#{controlSeguimientosRegEventos.stclin.anteSAHS eq true }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_3 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_4 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_5 }" />	
							<f:selectItem itemValue="4" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_6 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosRegEventos.cambiaTipoSAHS }"/>				
						</h:selectOneMenu>	
						<h:outputLabel value="#{ms.sc_antecedentes_nc_ahi_msg }" rendered="#{controlSeguimientosRegEventos.stclin.anteSAHS eq true }" title=""/>
						<h:inputText value="#{controlSeguimientosRegEventos.stclin.ahi }" rendered="#{controlSeguimientosRegEventos.stclin.anteSAHS eq true }" size="3" maxlength="10"/>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_cpap_msg }" rendered="#{controlSeguimientosRegEventos.stclin.anteSAHS eq true }"/>
						<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteCPAP }"
							rendered="#{controlSeguimientosRegEventos.stclin.anteSAHS eq true }" id="cpapImpSegRegEv">
							<a4j:support event="onclick" ajaxSingle="true" reRender="cpapImpSegRegEv"					
								actionListener="#{controlSeguimientosRegEventos.cambiaCPAP}"/>
						</h:selectBooleanCheckbox>
					</h:panelGrid>
					<rich:spacer width="20"/>
					<h:panelGrid columns="4">
						<h:selectBooleanCheckbox value="#{controlSeguimientosRegEventos.stclin.anteNeoplasia }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="impNeoplasiaSegRegEv"
								actionListener="#{controlSeguimientosRegEventos.cambiaNeoplasia}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_1 }" />			
					</h:panelGrid>
					<h:panelGrid columns="2" id="impNeoplasiaSegRegEv">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_2 }" rendered="#{controlSeguimientosRegEventos.stclin.anteNeoplasia eq true }"/>
						<h:inputText value="#{controlSeguimientosRegEventos.stclin.tiponeoplasia }"  maxlength="45" 
							rendered="#{controlSeguimientosRegEventos.stclin.anteNeoplasia eq true}">
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosRegEventos.cambiaTipoNeoplasia }"/>
						</h:inputText>				
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_tir_msg_1 }" />	
						<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.afectiroidea }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_3 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosRegEventos.cambiaAfecTiroidea }"/>					
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neur_msg_1 }" />	
						<h:selectOneMenu value="#{controlSeguimientosRegEventos.stclin.neuromediados }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_3 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_4 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientosRegEventos.cambiaNeurologicos }"/>					
						</h:selectOneMenu>	
					</h:panelGrid>
					<rich:spacer width="20"/>
					<h:panelGrid>
						<h:outputLabel value="#{ms.sc_comentarios }" style="font-weight: bold;" />
						<h:panelGrid style="border-top: solid 1px;border-color: black;"
							width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">					
							<h:inputTextarea cols="120" rows="8" value="#{controlSeguimientosRegEventos.stclin.comentarios }" id="comentariosIndicacionSegRegEv" >
								 <f:validateLength maximum="2000" />
								 <a4j:support event="onchange" ajaxSingle="true"
									actionListener="#{controlSeguimientosRegEventos.cambiaAlergias }"/>
							</h:inputTextarea>	
							<h:message for="comentariosIndicacionSegRegEv" style="color:red" />
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_alergias }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputTextarea cols="50" rows="4" value="#{controlSeguimientosRegEventos.stclin.alergias }" id="alergiasSegRegEv">
						<f:validateLength maximum="200" />
					</h:inputTextarea>	
					<h:message for="alergiasSegRegEv" style="color:red" />
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>		
	</h:panelGrid>
</ui:composition>
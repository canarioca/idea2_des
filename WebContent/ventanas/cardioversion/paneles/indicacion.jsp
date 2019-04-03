<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid columns="2" cellpadding="0" cellspacing="0" width="85%" columnClasses="alignTop,alignTop,alignTop">
		<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
			<h:outputLabel value="#{ms.sc_sintomas }" style="font-weight: bold;" />
			<a4j:commandLink reRender="tablaSintomasCVE" actionListener="#{controlCardioversion.addSintoma }">
				<h:graphicImage value="/img/iconos/add.png" width="16"
					height="16" style="border:0;" title="#{ms.sc_sintomas_add }"/>				
			</a4j:commandLink>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
					id="tablaSintomasCVE" width="100%" columnClasses="alignTop,alignTop,alignTop">
				<t:dataTable styleClass="hor-minimalist-b" var="listasintoma"
						width="100%" value="#{controlCardioversion.stclin.sintomas }"
						binding="#{controlCardioversion.bindingSintomas}">
					<t:column width="30%" headerstyleClass="left">	
						<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
							<h:selectOneMenu value="#{listasintoma.idsintomas }">
								<f:selectItems value="#{controlCardioversion.sintomas }" />
								<a4j:support event="onchange" reRender="tablaSintomasCVE" ajaxSingle="true"
									actionListener="#{controlCardioversion.controlSintomas }"/>
							</h:selectOneMenu>
						</h:panelGrid>
					</t:column>
					<t:column headerstyleClass="left">
						<a4j:commandLink reRender="tablaSintomasCVE"
							actionListener="#{controlCardioversion.delSintoma }">
							<h:graphicImage url="/img/iconos/minus.png"
								title="#{ms.sc_sintomas_del }" width="16" height="16"
								style="border: 0px;" />
						</a4j:commandLink>
					</t:column>
				</t:dataTable>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="4" width="100%" columnClasses="alignTop,alignTop,alignTop,alignTop">
			<h:outputLabel value="#{ms.cve_tab1_ind_title }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.cve_tab1_proc_title }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.cve_tab1_durfafl_title }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.cve_tab1_prev_title }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" columns="2" width="70%" columnClasses="left,left">
				<h:selectBooleanCheckbox value="#{controlCardioversion.cv.fibrilacionb }" />
				<h:outputLabel value="#{ms.cve_tab1_ind_op1 }" />
				<h:selectBooleanCheckbox value="#{controlCardioversion.cv.fluteratipicob}" />
				<h:outputLabel value="#{ms.cve_tab1_ind_op2 }" />
				<h:selectBooleanCheckbox value="#{controlCardioversion.cv.flutertipicob}" />
				<h:outputLabel value="#{ms.cve_tab1_ind_op3 }" />
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="2" width="70%" columnClasses="left,left">
				<h:selectOneMenu value="#{controlCardioversion.cv.idprocedencia}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1"/>
					<f:selectItem itemLabel="#{ms.cve_tab1_proc_op1 }" itemValue="1"/>
					<f:selectItem itemLabel="#{ms.cve_tab1_proc_op0 }" itemValue="0"/>
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;" width="70%">
				<h:selectOneMenu value="#{controlCardioversion.cv.idduracion}">
					<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1"/>
					<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op0 }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op1 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op2 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op3 }" itemValue="3" />
					<f:selectItem itemLabel="#{ms.cve_tab1_durfafl_op4 }" itemValue="4" />
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				columns="4" width="80%" columnClasses="left,left,left,left">
				<h:selectBooleanCheckbox value="#{controlCardioversion.cv.cvenob}" />
				<h:outputLabel value="#{ms.cve_tab1_prev_opNo }" />
				<h:outputLabel value="" />
				<h:outputLabel value="" />
				<h:selectBooleanCheckbox value="#{controlCardioversion.cv.cvesib}" />
				<h:outputLabel value="#{ms.cve_tab1_prev_opSi }" />
				<h:outputLabel value="#{ms.cve_tab1_prev_opSi_numero }" />
				<h:inputText size="6" maxlength="6" value="#{controlCardioversion.cv.cvenumero}" />
				<h:selectBooleanCheckbox value="#{controlCardioversion.cv.cveeficazb}" />
				<h:outputLabel value="#{ms.cve_tab1_prev_opSi_eficaz }" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid width="85%">
		<h:outputLabel value="#{ms.sc_ecg_title }" style="font-weight: bold;" />
		<h:panelGrid columns="3" width="100%"
			style="border-top: solid 1px;border-color: black;"
			columnClasses="alignTop33,alignTop33,alignTop33">
			<h:outputLabel value="#{ms.sc_ecg_ritmo }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.sc_ecg_cav }" style="font-weight: bold;" />
			<h:outputLabel value="#{ms.sc_ecg_qrs }" style="font-weight: bold;" />
			<h:panelGrid id="tablaRitmosCVE"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlCardioversion.stclin.ritmo }">
					<f:selectItems value="#{controlCardioversion.ritmos}" />	
					<a4j:support event="onchange" reRender="ritmosadicionalesCVE" ajaxSingle="true"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaCondAVCVE"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlCardioversion.stclin.conducav }">
					<f:selectItems value="#{controlCardioversion.conducciones}" />
					<a4j:support event="onchange" reRender="conduccionavadicionalCVE" ajaxSingle="true"/>					
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaQRSCVE"
				style="border-top: solid 1px;border-color: black;" columns="5">
				<h:selectOneMenu value="#{controlCardioversion.stclin.qrs }">
					<f:selectItems value="#{controlCardioversion.qrs}" />
					<a4j:support event="onchange" reRender="qrsadicionalesCVE" ajaxSingle="true"/>		
				</h:selectOneMenu>
				<rich:spacer width="10"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs_anchura }" style="font-weight: bold;" />
				<h:inputText value="#{controlCardioversion.stclin.anchuraqrs}" size="4" maxlength="5"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs_anchura_ms }" style="font-weight: bold;" />
			</h:panelGrid>
			<h:panelGrid id="ritmosadicionalesCVE">	
				<h:panelGrid id="tablaRitmosCVESA" rendered="#{controlCardioversion.stclin.ritmo eq 1028}">
					<h:selectOneMenu value="#{controlCardioversion.stclin.ritmo2 }">
						<f:selectItems value="#{controlCardioversion.ritmossa}" />					
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaRitmosCVEFA" rendered="#{controlCardioversion.stclin.ritmo eq 56}">
					<h:selectOneMenu value="#{controlCardioversion.stclin.ritmo2 }">
						<f:selectItems value="#{controlCardioversion.ritmosfa}" />					
					</h:selectOneMenu>
				</h:panelGrid>
					<h:panelGrid id="tablaRitmosCVETV" rendered="#{controlCardioversion.stclin.ritmo eq 60}">
						<h:selectOneMenu value="#{controlCardioversion.stclin.ritmo2 }">
							<f:selectItems value="#{controlCardioversion.ritmostv}" />					
						</h:selectOneMenu>
					</h:panelGrid>	
			</h:panelGrid>	
			<h:panelGrid id="conduccionavadicionalCVE">
				<h:panelGrid id="tablaConduccionAVOtrosCVE" rendered="#{controlCardioversion.stclin.conducav eq 64}">
					<h:selectOneMenu value="#{controlCardioversion.stclin.conducav2 }">
						<f:selectItems value="#{controlCardioversion.conduccionavotros}" />					
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>	
			<h:panelGrid id="qrsadicionalesCVE" >
				<h:panelGrid id="tablaqrsadicionalesCVE" rendered="#{controlCardioversion.stclin.qrs eq 75}">
					<h:selectOneMenu value="#{controlCardioversion.stclin.qrs2 }">
						<f:selectItems value="#{controlCardioversion.qrsotros}" />					
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
			<h:inputText size="5" maxlength="5" value="#{controlCardioversion.stclin.fevi }">
				<a4j:support event="onchange" reRender="funcionventricularCVE" ajaxSingle="true"
					actionListener="#{controlCardioversion.ordenaFEVI}"/>
			</h:inputText>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="funcionventricularCVE">
			<h:selectOneMenu value="#{controlCardioversion.stclin.funcionventricular }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_4 }" itemValue="0" />
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_5 }" itemValue="6" />
				<a4j:support event="onchange" reRender="fevi" ajaxSingle="true"
					actionListener="#{controlCardioversion.resetFEVI }"/>					
			</h:selectOneMenu>
		</h:panelGrid>		
	</h:panelGrid>
	<h:panelGrid id="aiSitClinCVE" columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_1 }" 
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:inputText size="5" maxlength="5" value="#{controlCardioversion.stclin.ai }">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlCardioversion.cambiaAI}"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_2 }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:selectOneMenu value="#{controlCardioversion.stclin.ai2 }">
					<f:selectItem itemLabel="#{ms.sc_ai_msg_3 }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_4 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_5 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_6 }" itemValue="3" />	
					<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlCardioversion.cambiaAI2}"/>				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid width="45%" id="icCVE">
		<h:panelGrid columns="2">		
			<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.ic}">
				<a4j:support event="onclick" reRender="icCVE" ajaxSingle="true"
				actionListener="#{controlCardioversion.cambiaIC }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_ic_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" columns="2" rendered="#{controlCardioversion.stclin.ic eq true}">
			<h:panelGrid columns="2" width="100%">
				<h:outputLabel value="#{ms.sc_ic_msg_2 }" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlCardioversion.stclin.nyha}">
					<f:selectItem itemLabel="I" itemValue="1" />
					<f:selectItem itemLabel="II" itemValue="2" />
					<f:selectItem itemLabel="III" itemValue="3" />
					<f:selectItem itemLabel="IV" itemValue="4" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlCardioversion.cambiaNYHA}"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="tablaCardiopatiaCVE">
		<h:panelGrid columns="2">			
			<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.cardiop}">
				<a4j:support event="onclick" reRender="tablaCardiopatiaCVE" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_cardiopatia_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" rendered="#{controlCardioversion.stclin.cardiop eq true}">		
			<h:selectOneMenu value="#{controlCardioversion.stclin.cardiopatia}">
				<f:selectItems value="#{controlCardioversion.cardiopatia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatiaCVE" ajaxSingle="true"
					actionListener="#{controlCardioversion.cambiaCardiopatiaEtiologia }"/>							
			</h:selectOneMenu>
			<h:inputText value="#{controlCardioversion.stclin.otra}" maxlength="45"
				rendered="#{controlCardioversion.stclin.cardiopatia eq 923}"/>
			<h:panelGrid columns="2" rendered="#{controlCardioversion.stclin.cardiopatia ne 913}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_2 }"/>
				<h:inputText value="#{controlCardioversion.stclin.aevolucion}" size="4" maxlength="4">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlCardioversion.cambiaAnosEvolucion}"/> 
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="4" rendered="#{controlCardioversion.stclin.cardiopatia eq 914}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_3 }"/>
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.revascularizacion }">
					<a4j:support event="onclick" actionListener="#{controlCardioversion.reVasc}"/>
				</h:selectBooleanCheckbox>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_4 }"/>
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.infartoprev }">
					<a4j:support event="onclick" reRender="tablaCardiopatiaCVE" ajaxSingle="true"
						actionListener="#{controlCardioversion.infPrevio}"/>
				</h:selectBooleanCheckbox>	
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_5 }" rendered="#{controlCardioversion.stclin.infartoprev eq true}"/>
				<h:inputText value="#{controlCardioversion.stclin.anio }" size="4" maxlength="4" 
					rendered="#{controlCardioversion.stclin.infartoprev eq true}">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlCardioversion.cambiaAnosInfPrevio }"/>
				</h:inputText>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_6 }" rendered="#{controlCardioversion.stclin.infartoprev eq true}"/>
				<h:selectOneMenu value="#{controlCardioversion.stclin.localizacion }"
					rendered="#{controlCardioversion.stclin.infartoprev eq true}">
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
						actionListener="#{controlCardioversion.cambiaLocalizacion }"/>					
				</h:selectOneMenu>
			</h:panelGrid>		
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid>
		<h:outputLabel value="#{ms.sc_antecedentes }" style="font-weight: bold;" />
		<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" columnClasses="alignTop,alignTop">
			<h:panelGrid id="arritmiasventricularesCVE" width="100%" cellspacing="0">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.avent }">
						<a4j:support event="onclick" reRender="arritmiasventricularesCVE" ajaxSingle="true"
							actionListener="#{controlCardioversion.cambiaArritmiasVentriculares }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_arritmias_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlCardioversion.stclin.avent eq true}">
					<h:panelGrid width="100%">
						<h:selectOneRadio layout="lineDirection"
							value="#{controlCardioversion.stclin.arritmias }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_2 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_3 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_4 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_5 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlCardioversion.cambiaArrVent }"/>
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="eefprevioCVE" width="80%" cellspacing="0">
				<h:panelGrid columns="2">				
					<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.eefprev }">
						<a4j:support event="onclick" reRender="eefprevioCVE" ajaxSingle="true"
							actionListener="#{controlCardioversion.cambiaEefPrevio }"/>	
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlCardioversion.stclin.eefprev eq true}">
					<h:panelGrid width="100%" columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_2 }"/>
						<h:selectOneRadio layout="lineDirection"
							value="#{controlCardioversion.stclin.eef }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_3 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_4 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_5 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_6 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlCardioversion.cambiaEEF }"/>
						</h:selectOneRadio>
					</h:panelGrid> 
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="7" width="100%" id="panelAntecedentesIndicacionCVE">
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.antefa }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteFA }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_fa_msg }" title="#{ms.sc_antecedentes_fa_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteflutter }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteFlutter }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_flut_msg }" title="#{ms.sc_antecedentes_flut_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteSincope }">
					<a4j:support event="onclick"  
						ajaxSingle="true" actionListener="#{controlCardioversion.cambiaSincope}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_sinc_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteParadaCardiaca }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlCardioversion.cambiaParadaCardiaca}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_pcar_msg }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteHTA }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteHipertens }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_hta_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.antehipercol }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteHipercoles }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_disl_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.enfarterios }">
					<a4j:support event="onclick" 
						ajaxSingle="true" actionListener="#{controlCardioversion.cambiaEnfArt}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_eart_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteinsrenal }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteInsRenal}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_iren_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.antediab }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteDiab }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_diab_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.antefam }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteFam }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_msub_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteacv }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteACV }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_acv_msg }" title="#{ms.sc_antecedentes_acv_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteAIT }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlCardioversion.cambiaAIT}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_ait_msg }" title="#{ms.sc_antecedentes_ait_title }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteTrasplanteCardiaco }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteTCardiaco}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tcar_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.antetabaq }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacionCVE" 
						ajaxSingle="true" actionListener="#{controlCardioversion.anteTabaq }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tabq_msg }"/>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
			<h:panelGrid id="antecedentesNoCardioCVE">
				<h:outputLabel value="#{ms.sc_antecedentes_nc }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
					<h:panelGrid columns="2">	
						<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteEPOC }">
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlCardioversion.cambiaEPOC}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_epoc_msg }" title="#{ms.sc_antecedentes_nc_epoc_title }"/>
					</h:panelGrid>							
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteSAHS }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="implanteSAHSCVE"
								actionListener="#{controlCardioversion.cambiaSAHS}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_1 }" title=""/>				
					</h:panelGrid>
					<h:panelGrid columns="6" id="implanteSAHSCVE">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_2 }" rendered="#{controlCardioversion.stclin.anteSAHS eq true }"/>
						<h:selectOneMenu value="#{controlCardioversion.stclin.tiposahs }"
							rendered="#{controlCardioversion.stclin.anteSAHS eq true }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_3 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_4 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_5 }" />	
							<f:selectItem itemValue="4" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_6 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlCardioversion.cambiaTipoSAHS }"/>				
						</h:selectOneMenu>	
						<h:outputLabel value="#{ms.sc_antecedentes_nc_ahi_msg }" rendered="#{controlCardioversion.stclin.anteSAHS eq true }" title=""/>
						<h:inputText value="#{controlCardioversion.stclin.ahi }" rendered="#{controlCardioversion.stclin.anteSAHS eq true }" size="3" maxlength="10"/>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_cpap_msg }" rendered="#{controlCardioversion.stclin.anteSAHS eq true }"/>
						<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteCPAP }"
							rendered="#{controlCardioversion.stclin.anteSAHS eq true }" id="cpapImpCVE">
							<a4j:support event="onclick" ajaxSingle="true" reRender="cpapImpCVE"					
								actionListener="#{controlCardioversion.cambiaCPAP}"/>
						</h:selectBooleanCheckbox>
					</h:panelGrid>
					<rich:spacer width="20"/>
					<h:panelGrid columns="4">
						<h:selectBooleanCheckbox value="#{controlCardioversion.stclin.anteNeoplasia }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="impNeoplasiaCVE"
								actionListener="#{controlCardioversion.cambiaNeoplasia}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_1 }" />			
					</h:panelGrid>
					<h:panelGrid columns="2" id="impNeoplasiaCVE">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_2 }" rendered="#{controlCardioversion.stclin.anteNeoplasia eq true }"/>
						<h:inputText value="#{controlCardioversion.stclin.tiponeoplasia }"  maxlength="45" 
							rendered="#{controlCardioversion.stclin.anteNeoplasia eq true}">
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlCardioversion.cambiaTipoNeoplasia }"/>
						</h:inputText>				
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_tir_msg_1 }" />	
						<h:selectOneMenu value="#{controlCardioversion.stclin.afectiroidea }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_3 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlCardioversion.cambiaAfecTiroidea }"/>					
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neur_msg_1 }" />	
						<h:selectOneMenu value="#{controlCardioversion.stclin.neuromediados }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_3 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_4 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlCardioversion.cambiaNeurologicos }"/>					
						</h:selectOneMenu>	
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<rich:spacer width="20"/>
		<h:panelGrid columns="3" columnClasses="alignTop,alignTop,alignTop">
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_comentarios }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">					
					<h:inputTextarea cols="100" rows="8" value="#{controlCardioversion.stclin.comentarios }" id="comentariosIndicacionCVE" >
						<f:validateLength maximum="2000" />
					</h:inputTextarea>	
					<h:message for="comentariosIndicacionCVE" style="color:red" />
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_alergias }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputTextarea cols="50" rows="4" value="#{controlCardioversion.stclin.alergias }" id="alergiasCVE">
						<f:validateLength maximum="200" />
						<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlCardioversion.cambiaAlergias }"/>
					</h:inputTextarea>	
					<h:message for="alergiasCVE" style="color:red" />
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="2" width="100%" columnClasses="alignTop,alignTop,alignTop">
				<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_title }" style="font-weight: bold;" />
				<h:outputLabel value="" style="font-weight: bold;" />
				<h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						columns="2" width="80%" columnClasses="alignTop,alignTop">
						<h:selectBooleanCheckbox value="#{controlCardioversion.cv.avtab}" />
						<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_atk }" />
						<h:selectBooleanCheckbox value="#{controlCardioversion.cv.eteb}" />
						<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_ete }" />
					</h:panelGrid>
					<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
						<h:outputLabel value="#{ms.cve_tab1_ttoantitromb_otros }" style="font-weight: bold;" />
						<a4j:commandLink reRender="tablaOtrosttoInd"
							actionListener="#{controlCardioversion.cv.addOtros }">
							<h:graphicImage value="/img/iconos/add.png" width="16"
								height="16" style="border:0;"
								title="#{ms.cve_tab1_ttoantitromb_otros_add }" />
						</a4j:commandLink>
					</h:panelGrid>
					<h:panelGrid style="border-top: solid 1px;border-color: black;"
						id="tablaOtrosttoInd" width="100%">
						<t:dataTable styleClass="hor-minimalist-b" var="linea"
							width="100%" value="#{controlCardioversion.cv.tratamientos }"
							binding="#{controlCardioversion.cv.binotr }">
							<t:column width="30%" headerstyleClass="left">
								<f:facet name="header">
									<h:outputText value="#{ms.cve_tab1_ttoantitromb_otros_trat }" />
								</f:facet>
								<h:inputText id="TtoCVEInd" size="30" value="#{linea.tmpString1 }" />
							</t:column>
							<t:column headerstyleClass="left">
								<a4j:commandLink reRender="tablaOtrosttoInd"
									actionListener="#{controlCardioversion.cv.delOtros }">
									<h:graphicImage url="/img/iconos/minus.png"
										title="#{ms.cve_tab1_ttoantitromb_otros_del }" width="16" height="16"
										style="border: 0px;" />
								</a4j:commandLink>
							</t:column>
						</t:dataTable>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
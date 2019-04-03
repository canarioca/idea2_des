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
		<a4j:commandLink reRender="tablaSintomas"
				actionListener="#{controlImplantes.addSintoma }">
			<h:graphicImage value="/img/iconos/add.png" width="16"
				height="16" style="border:0;" title="#{ms.sc_sintomas_add }"/>				
		</a4j:commandLink>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
				id="tablaSintomas" width="100%" columnClasses="alignTop,alignTop,alignTop">
			<t:dataTable styleClass="hor-minimalist-b" var="listasintoma"
					width="100%" value="#{controlImplantes.hind.sintomas }"
					binding="#{controlImplantes.bindingSintomas}">
				<t:column width="30%" headerstyleClass="left">	
					<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
						<h:selectOneMenu value="#{listasintoma.idsintomas }">
							<f:selectItems value="#{controlImplantes.sintomas }" />
							<a4j:support event="onchange" reRender="tablaSintomas" ajaxSingle="true"
								actionListener="#{controlImplantes.controlSintomas }"/>
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaSintomas"
						actionListener="#{controlImplantes.delSintoma }">
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
	
				<h:panelGrid id="tablaRitmos"
					style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.hind.ritmo }">
						<f:selectItems value="#{controlImplantes.ritmos}" />	
						<a4j:support event="onchange" reRender="ritmosadicionales" ajaxSingle="true"/>				
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaCondAV"
					style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.hind.conducav }">
						<f:selectItems value="#{controlImplantes.conducciones}" />
						<a4j:support event="onchange" reRender="conduccionavadicional" ajaxSingle="true"/>					
					</h:selectOneMenu>
				</h:panelGrid>
				<h:panelGrid id="tablaQRS"
					style="border-top: solid 1px;border-color: black;" columns="5">
					<h:selectOneMenu value="#{controlImplantes.hind.qrs }">
						<f:selectItems value="#{controlImplantes.qrs}" />
						<a4j:support event="onchange" reRender="qrsadicionales" ajaxSingle="true"/>		
					</h:selectOneMenu>
					<rich:spacer width="10"/>
					<h:outputLabel value="#{ms.sc_ecg_qrs_anchura }"
						style="font-weight: bold;" />
					<h:inputText value="#{controlImplantes.hind.anchuraqrs}" size="4" maxlength="5"/>
					<h:outputLabel value="#{ms.sc_ecg_qrs_anchura_ms }"
						style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid id="ritmosadicionales">	
					<h:panelGrid id="tablaRitmosSA" rendered="#{controlImplantes.hind.ritmo eq 1028}">
						<h:selectOneMenu value="#{controlImplantes.hind.ritmo2 }">
							<f:selectItems value="#{controlImplantes.ritmossa}" />					
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid id="tablaRitmosFA" rendered="#{controlImplantes.hind.ritmo eq 56}">
						<h:selectOneMenu value="#{controlImplantes.hind.ritmo2 }">
							<f:selectItems value="#{controlImplantes.ritmosfa}" />					
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid id="tablaRitmosTV" rendered="#{controlImplantes.hind.ritmo eq 60}">
						<h:selectOneMenu value="#{controlImplantes.hind.ritmo2 }">
							<f:selectItems value="#{controlImplantes.ritmostv}" />					
						</h:selectOneMenu>
					</h:panelGrid>	
				</h:panelGrid>	
				<h:panelGrid id="conduccionavadicional">
					<h:panelGrid id="tablaConduccionAVOtros" rendered="#{controlImplantes.hind.conducav eq 64}">
						<h:selectOneMenu value="#{controlImplantes.hind.conducav2 }">
							<f:selectItems value="#{controlImplantes.conduccionavotros}" />					
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>	
				<h:panelGrid id="qrsadicionales" >
					<h:panelGrid id="tablaqrsadicionales" rendered="#{controlImplantes.hind.qrs eq 75}">
						<h:selectOneMenu value="#{controlImplantes.hind.qrs2 }">
							<f:selectItems value="#{controlImplantes.qrsotros}" />					
						</h:selectOneMenu>
						<h:inputText value="" style="font-weight: bold;" rendered="false"/>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	<h:panelGrid width="60%" rendered="false">
		<h:outputLabel value="Fracción de eyección"
			style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%">
			<h:selectOneRadio layout="lineDirection"
				value="#{controlImplantes.hind.funcionventricular }">
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
			</h:selectOneRadio>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid columns="2">
		<h:outputText value="#{ms.sc_feyec_msg_2 }"
			style="font-weight: bold;" />
		<h:outputText value="#{ms.sc_feyec_msg_3 }"
			style="font-weight: bold;"  />
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="fevi">
			<h:inputText size="5" maxlength="5" value="#{controlImplantes.hind.fevi }">
				<a4j:support event="onchange" reRender="funcionventricular" ajaxSingle="true"
						actionListener="#{controlImplantes.ordenaFEVI }"/>
			</h:inputText>
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;" id="funcionventricular">
			<h:selectOneMenu value="#{controlImplantes.hind.funcionventricular }">
				<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_4 }" itemValue="0" />
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
				<f:selectItem itemLabel="#{ms.sc_feyec_msg_5 }" itemValue="6" />
				<a4j:support event="onchange" reRender="fevi" ajaxSingle="true"
					actionListener="#{controlImplantes.resetFEVI }"/>					
			</h:selectOneMenu>
		</h:panelGrid>		
	</h:panelGrid>
	<h:panelGrid id="aiSitClinImp" columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_1 }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:inputText size="5" maxlength="5" value="#{controlImplantes.hind.ai }">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlImplantes.cambiaAI}"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columnClasses="alignTop">
			<h:outputText value="#{ms.sc_ai_msg_2 }"
				style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;" >
				<h:selectOneMenu value="#{controlImplantes.hind.ai2 }">
					<f:selectItem itemLabel="#{ms.sc_ai_msg_3 }" itemValue="0" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_4 }" itemValue="1" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_5 }" itemValue="2" />
					<f:selectItem itemLabel="#{ms.sc_ai_msg_6 }" itemValue="3" />	
					<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlImplantes.cambiaAI2}"/>				
				</h:selectOneMenu>
			</h:panelGrid>
		</h:panelGrid>
	
	</h:panelGrid>
	
	
	<h:panelGrid width="45%" id="ic">
		<h:panelGrid columns="2">		
			<h:selectBooleanCheckbox value="#{controlImplantes.hind.ic}">
				<a4j:support event="onclick" reRender="ic" ajaxSingle="true"
				actionListener="#{controlImplantes.cambiaIC }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_ic_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" columns="2" rendered="#{controlImplantes.hind.ic eq true}">
			<h:panelGrid columns="2" width="100%">
				<h:outputLabel value="#{ms.sc_ic_msg_2 }" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlImplantes.hind.nyha}">
					<f:selectItem itemLabel="I" itemValue="1" />
					<f:selectItem itemLabel="II" itemValue="2" />
					<f:selectItem itemLabel="III" itemValue="3" />
					<f:selectItem itemLabel="IV" itemValue="4" />
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlImplantes.cambiaNYHA}"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="tablaCardiopatia">
		<h:panelGrid columns="2">			
			<h:selectBooleanCheckbox value="#{controlImplantes.hind.cardiop}">
				<a4j:support event="onclick" reRender="tablaCardiopatia" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_cardiopatia_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" rendered="#{controlImplantes.hind.cardiop eq true}">		
			<h:selectOneMenu value="#{controlImplantes.hind.cardiopatia}">
				<f:selectItems value="#{controlImplantes.cardiopatia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatia" ajaxSingle="true"
					actionListener="#{controlImplantes.cambiaCardiopatiaEtiologia }"/>							
			</h:selectOneMenu>
			<h:inputText value="#{controlImplantes.hind.otra}" maxlength="45"
				rendered="#{controlImplantes.hind.cardiopatia eq 923}"/>
			<h:panelGrid columns="2" rendered="#{controlImplantes.hind.cardiopatia ne 913}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_2 }"/>
				<h:inputText value="#{controlImplantes.hind.aevolucion}" size="4" maxlength="4">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlImplantes.cambiaAnosEvolucion }"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="4" rendered="#{controlImplantes.hind.cardiopatia eq 914}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_3 }"/>
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.revascularizacion }">
					<a4j:support event="onclick" actionListener="#{controlImplantes.reVasc}"/>
				</h:selectBooleanCheckbox>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_4 }"/>
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.infartoprev }">
					<a4j:support event="onclick" reRender="tablaCardiopatia" ajaxSingle="true"
						actionListener="#{controlImplantes.infPrevio}"/>
				</h:selectBooleanCheckbox>	
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_5 }" rendered="#{controlImplantes.hind.infartoprev eq true}"/>
				<h:inputText value="#{controlImplantes.hind.anio }" size="4" maxlength="4" rendered="#{controlImplantes.hind.infartoprev eq true}">
					<a4j:support event="onchange" ajaxSingle="true"
						actionListener="#{controlImplantes.cambiaAnosInfPrevio }"/>
				</h:inputText>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_6 }" rendered="#{controlImplantes.hind.infartoprev eq true}"/>
				<h:selectOneMenu value="#{controlImplantes.hind.localizacion }"
					rendered="#{controlImplantes.hind.infartoprev eq true}">
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
						actionListener="#{controlImplantes.cambiaLocalizacion }"/>					
				</h:selectOneMenu>
			</h:panelGrid>		
		</h:panelGrid>
		<h:panelGrid columns="4" id="panTEuropea" rendered="false">
			<h:outputLabel value="Códigos Tarjeta Europea" />
			<h:selectBooleanCheckbox value="#{controlImplantes.tarjetaeuropea }">
					<a4j:support event="onclick" reRender="panTEuropea" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="Etiología" rendered="#{controlImplantes.tarjetaeuropea eq true}"/>
			<h:selectOneMenu value="#{controlImplantes.hind.etiologia }" 
				rendered="#{controlImplantes.tarjetaeuropea eq true}">
				<f:selectItems value="#{controlImplantes.etiologia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatia" ajaxSingle="true"
					actionListener="#{controlImplantes.cambiaEtiologiaCardiopatia }"/>							
			</h:selectOneMenu>
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid>
		<h:outputLabel value="#{ms.sc_antecedentes }" style="font-weight: bold;" />
		<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" columnClasses="alignTop,alignTop">
			<h:panelGrid id="arritmiasventriculares" width="100%" cellspacing="0">
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlImplantes.hind.avent }">
						<a4j:support event="onclick" reRender="arritmiasventriculares" ajaxSingle="true"
							actionListener="#{controlImplantes.cambiaArritmiasVentriculares }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_arritmias_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlImplantes.hind.avent eq true}">
					<h:panelGrid width="100%">
						<h:selectOneRadio layout="lineDirection"
							value="#{controlImplantes.hind.arritmias }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_2 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_3 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_4 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_arritmias_msg_5 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlImplantes.cambiaArrVent }"/>
						</h:selectOneRadio>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="eefprevio" width="80%" cellspacing="0">
				<h:panelGrid columns="2">				
					<h:selectBooleanCheckbox value="#{controlImplantes.hind.eefprev }">
						<a4j:support event="onclick" reRender="eefprevio" ajaxSingle="true"
							actionListener="#{controlImplantes.cambiaEefPrevio }"/>	
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_1 }" style="font-weight: bold;" />
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					width="80%" cellspacing="0" columns="2" rendered="#{controlImplantes.hind.eefprev eq true}">
					<h:panelGrid width="100%" columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_eef_msg_2 }"/>
						<h:selectOneRadio layout="lineDirection"
							value="#{controlImplantes.hind.eef }">
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_3 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_4 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_5 }" itemValue="3" />
							<f:selectItem itemLabel="#{ms.sc_antecedentes_eef_msg_6 }" itemValue="4" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlImplantes.cambiaEEF }"/>
						</h:selectOneRadio>
					</h:panelGrid> 
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="7" width="100%" id="panelAntecedentesIndicacion">			
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.antefa }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteFA }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_fa_msg }" title="#{ms.sc_antecedentes_fa_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteflutter }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteFlutter }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_flut_msg }" title="#{ms.sc_antecedentes_flut_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteSincope }">
					<a4j:support event="onclick"  
						ajaxSingle="true" actionListener="#{controlImplantes.cambiaSincope}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_sinc_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteParadaCardiaca }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlImplantes.cambiaParadaCardiaca}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_pcar_msg }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteHTA }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteHipertens }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_hta_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.antehipercol }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteHipercoles }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_disl_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.enfarterios }">
					<a4j:support event="onclick" 
						ajaxSingle="true" actionListener="#{controlImplantes.cambiaEnfArt}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_eart_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">					
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteinsrenal }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteInsRenal }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_iren_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.antediab }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteDiab }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_diab_msg }"/>
			</h:panelGrid>			
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.antefam }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteFam }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_msub_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteacv }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteACV }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_acv_msg }" title="#{ms.sc_antecedentes_acv_title }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteAIT }">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlImplantes.cambiaAIT}"/> 
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_ait_msg }" title="#{ms.sc_antecedentes_ait_title }"/>						
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteTrasplanteCardiaco }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteTCardiaco}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tcar_msg }"/>
			</h:panelGrid>
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlImplantes.hind.antetabaq }">
					<a4j:support event="onclick" reRender="panelAntecedentesIndicacion" 
						ajaxSingle="true" actionListener="#{controlImplantes.anteTabaq }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.sc_antecedentes_tabq_msg }"/>
			</h:panelGrid>			
		</h:panelGrid>
		<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
			<h:panelGrid id="antecedentesNoCardio">
				<h:outputLabel value="#{ms.sc_antecedentes_nc }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
					<h:panelGrid columns="2">	
						<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteEPOC }">
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlImplantes.cambiaEPOC}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_epoc_msg }" title="#{ms.sc_antecedentes_nc_epoc_title }"/>
					</h:panelGrid>							
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteSAHS }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="implanteSAHS"
								actionListener="#{controlImplantes.cambiaSAHS}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_1 }" title=""/>				
					</h:panelGrid>
					<h:panelGrid columns="6" id="implanteSAHS">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_2 }" rendered="#{controlImplantes.hind.anteSAHS eq true }"/>
						<h:selectOneMenu value="#{controlImplantes.hind.tiposahs }"
							rendered="#{controlImplantes.hind.anteSAHS eq true }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_3 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_4 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_5 }" />	
							<f:selectItem itemValue="4" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_6 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlImplantes.cambiaTipoSAHS }"/>				
						</h:selectOneMenu>	
						<h:outputLabel value="#{ms.sc_antecedentes_nc_ahi_msg }" rendered="#{controlImplantes.hind.anteSAHS eq true }" title=""/>
						<h:inputText value="#{controlImplantes.hind.ahi }" rendered="#{controlImplantes.hind.anteSAHS eq true }" size="3" maxlength="10"/>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_cpap_msg }" rendered="#{controlImplantes.hind.anteSAHS eq true }"/>
						<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteCPAP }"
							rendered="#{controlImplantes.hind.anteSAHS eq true }" id="cpapImp">
							<a4j:support event="onclick" ajaxSingle="true" reRender="cpapImp"					
								actionListener="#{controlImplantes.cambiaCPAP}"/>
						</h:selectBooleanCheckbox>
					</h:panelGrid>
					<rich:spacer width="20"></rich:spacer>
					<h:panelGrid columns="4">
						<h:selectBooleanCheckbox value="#{controlImplantes.hind.anteNeoplasia }">
							<a4j:support event="onclick" ajaxSingle="true" reRender="impNeoplasia"
								actionListener="#{controlImplantes.cambiaNeoplasia}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_1 }" />			
					</h:panelGrid>
					<h:panelGrid columns="2" id="impNeoplasia">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_2 }" rendered="#{controlImplantes.hind.anteNeoplasia eq true }"/>
						<h:inputText value="#{controlImplantes.hind.tiponeoplasia }"  maxlength="45" rendered="#{controlImplantes.hind.anteNeoplasia eq true}">
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlImplantes.cambiaTipoNeoplasia }"/>
						</h:inputText>				
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.sc_antecedentes_nc_tir_msg_1 }" />	
						<h:selectOneMenu value="#{controlImplantes.hind.afectiroidea }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_3 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlImplantes.cambiaAfecTiroidea }"/>					
						</h:selectOneMenu>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_neur_msg_1 }" />	
						<h:selectOneMenu value="#{controlImplantes.hind.neuromediados }">
							<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
							<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_2 }" />
							<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_3 }" />
							<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_neur_msg_4 }" />
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlImplantes.cambiaNeurologicos }"/>					
						</h:selectOneMenu>	
					</h:panelGrid>										
				</h:panelGrid>							
			</h:panelGrid>
			<h:panelGrid>
				<h:outputLabel value="#{ms.sc_alergias }" style="font-weight: bold;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:inputTextarea cols="50" rows="4" value="#{controlImplantes.hind.alergias }" id="alergiasIndicacion">
						<f:validateLength maximum="200" />
						<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlImplantes.cambiaAlergias }"/>
					</h:inputTextarea>	
					<h:message for="alergiasIndicacion" style="color:red" />
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<rich:spacer width="20"></rich:spacer>
		<h:panelGrid>
			<h:outputLabel value="#{ms.sc_comentarios }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">					
				<h:inputTextarea cols="120" rows="8" value="#{controlImplantes.hind.comentarios }" id="comentariosIndicacion" >
					<f:validateLength maximum="2000" />
				</h:inputTextarea>	
				<h:message for="comentariosIndicacion" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:jsflot="http://www.jsflot.org/taglib/jsflot"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
		<h:outputLabel value="#{ms.sc_sintomas }"
			style="font-weight: bold;" />
		<a4j:commandLink reRender="tablaSintomasSeg"
			actionListener="#{controlSeguimientos.addSintoma }">
			<h:graphicImage value="/img/iconos/add.png" width="16"
				height="16" style="border:0;" title="#{ms.sc_sintomas_add }"/>				
		</a4j:commandLink>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			id="tablaSintomasSeg" width="100%" columnClasses="alignTop,alignTop,alignTop">
			<t:dataTable styleClass="hor-minimalist-b" var="listasintomaseg"
					width="100%" value="#{controlSeguimientos.sitclin.sintomas }"
					binding="#{controlSeguimientos.bindingSintomas}">
				<t:column width="30%" headerstyleClass="left">	
					<h:panelGrid columnClasses="alignTop,alignTop,alignTop">
						<h:selectOneMenu value="#{listasintomaseg.idsintomas }">
							<f:selectItems value="#{controlSeguimientos.sintomas }" />
							<a4j:support event="onchange" reRender="tablaSintomasSeg" ajaxSingle="true"
								actionListener="#{controlSeguimientos.controlSintomas }"/>
						</h:selectOneMenu>
					</h:panelGrid>
				</t:column>
				<t:column headerstyleClass="left">
					<a4j:commandLink reRender="tablaSintomasSeg"
						actionListener="#{controlSeguimientos.delSintoma }">
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
			<h:panelGrid id="tablaRitmosSeg"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlSeguimientos.sitclin.ritmo }">
					<f:selectItems value="#{controlSeguimientos.ritmos}" />	
					<a4j:support event="onchange" reRender="ritmosadicionales" ajaxSingle="true"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaCondAVSeg"
				style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlSeguimientos.sitclin.conducav }">
					<f:selectItems value="#{controlSeguimientos.conducciones}" />	
					<a4j:support event="onchange" reRender="conduccionavadicional" ajaxSingle="true"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid id="tablaQRSSeg"
				style="border-top: solid 1px;border-color: black;" columns="5">
				<h:selectOneMenu value="#{controlSeguimientos.sitclin.qrs }">
					<f:selectItems value="#{controlSeguimientos.qrs}" />	
					<a4j:support event="onchange" reRender="qrsadicionales" ajaxSingle="true"/>	
				</h:selectOneMenu>
				<rich:spacer width="10"/>
				<h:outputLabel value="#{ms.sc_ecg_qrs_anchura }"
					style="font-weight: bold;" />
					<h:inputText value="#{controlSeguimientos.sitclin.anchuraqrs }" size="4"/>
					<h:outputLabel value="#{ms.sc_ecg_qrs_anchura_ms }"
						style="font-weight: bold;" />
			</h:panelGrid>
			<h:panelGrid id="ritmosadicionales">	
					<h:panelGrid id="tablaRitmosSA" rendered="#{controlSeguimientos.sitclin.ritmo eq 1028}">
						<h:selectOneMenu value="#{controlSeguimientos.sitclin.ritmo2 }">
							<f:selectItems value="#{controlSeguimientos.ritmossa}" />					
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid id="tablaRitmosFA" rendered="#{controlSeguimientos.sitclin.ritmo eq 56}">
						<h:selectOneMenu value="#{controlSeguimientos.sitclin.ritmo2 }">
							<f:selectItems value="#{controlSeguimientos.ritmosfa}" />					
						</h:selectOneMenu>
					</h:panelGrid>
					<h:panelGrid id="tablaRitmosTV" rendered="#{controlSeguimientos.sitclin.ritmo eq 60}">
						<h:selectOneMenu value="#{controlSeguimientos.sitclin.ritmo2 }">
							<f:selectItems value="#{controlSeguimientos.ritmostv}" />					
						</h:selectOneMenu>
					</h:panelGrid>	
				</h:panelGrid>	
				<h:panelGrid id="conduccionavadicional">
					<h:panelGrid id="tablaConduccionAVOtros" rendered="#{controlSeguimientos.sitclin.conducav eq 64}">
						<h:selectOneMenu value="#{controlSeguimientos.sitclin.conducav2 }">
							<f:selectItems value="#{controlSeguimientos.conduccionavotros}" />					
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>	
				<h:panelGrid id="qrsadicionales" >
					<h:panelGrid id="tablaqrsadicionales" rendered="#{controlSeguimientos.sitclin.qrs eq 75}">
						<h:selectOneMenu value="#{controlSeguimientos.sitclin.qrs2 }">
							<f:selectItems value="#{controlSeguimientos.qrsotros}" />					
						</h:selectOneMenu>
						<h:inputText value="" style="font-weight: bold;" rendered="false"/>
					</h:panelGrid>
				</h:panelGrid>				
		</h:panelGrid>
	</h:panelGrid>
	
	<h:panelGrid columns="2" columnClasses="alignTop,alignTop">
		<h:panelGrid>
			<h:panelGrid columns="3" columnClasses="alignTop,alignTop,alignTop">
				<h:outputText value="#{ms.sc_feyec_msg_2 }"
					style="font-weight: bold;" />
				<h:outputText value="#{ms.sc_feyec_msg_3 }"
					style="font-weight: bold;"  />
				<a4j:commandLink reRender="estFEVI" actionListener="#{controlSeguimientos.generarEstadisticasSitClin }" 
					onclick="javascript:Richfaces.showModalPanel('buscando');" 
					oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
					<h:graphicImage url="/img/iconos/ParameterReview.png" title="#{ms.generar_estadisticas }" 
						width="24" height="24" style="border: 0px;"/>
				</a4j:commandLink>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" id="feviSeg">
					<h:inputText size="5" maxlength="5" value="#{controlSeguimientos.sitclin.fevi }">
						<a4j:support event="onchange" reRender="funcionventricularSeg" ajaxSingle="true"
							actionListener="#{controlSeguimientos.ordenaFEVI }"/>
					</h:inputText>
				</h:panelGrid>
				<h:panelGrid style="border-top: solid 1px;border-color: black;" id="funcionventricularSeg">
					<h:selectOneMenu value="#{controlSeguimientos.sitclin.funcionventricular }">
						<f:selectItem itemLabel="#{ms.seleccione_opcion }" itemValue="-1" />
						<f:selectItem itemLabel="#{ms.sc_feyec_msg_4 }" itemValue="0" />
						<f:selectItem itemLabel="&gt;50%" itemValue="1" />
						<f:selectItem itemLabel="41-50%" itemValue="2" />
						<f:selectItem itemLabel="36-40%" itemValue="3" />
						<f:selectItem itemLabel="31-35%" itemValue="4" />
						<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
						<f:selectItem itemLabel="#{ms.sc_feyec_msg_5 }" itemValue="6" />	
						<a4j:support event="onchange" reRender="feviSeg" ajaxSingle="true"
							actionListener="#{controlSeguimientos.resetFEVI }"/>				
					</h:selectOneMenu>
				</h:panelGrid>	
			</h:panelGrid>
			
			<h:panelGrid id="aiSitClinSeg" columns="2" columnClasses="alignTop,alignTop">
				<h:panelGrid columnClasses="alignTop">
					<h:outputText value="#{ms.sc_ai_msg_1 }"
						style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" >
						<h:inputText size="5" maxlength="5" value="#{controlSeguimientos.sitclin.ai }">
							<a4j:support event="onchange" ajaxSingle="true"
								actionListener="#{controlSeguimientos.cambiaAI}"/>
						</h:inputText>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columnClasses="alignTop">
					<h:outputText value="#{ms.sc_ai_msg_2 }"
						style="font-weight: bold;" />
					<h:panelGrid style="border-top: solid 1px;border-color: black;" >
						<h:selectOneMenu value="#{controlSeguimientos.sitclin.ai2 }">
							<f:selectItem itemLabel="#{ms.sc_ai_msg_3 }" itemValue="0" />
							<f:selectItem itemLabel="#{ms.sc_ai_msg_4 }" itemValue="1" />
							<f:selectItem itemLabel="#{ms.sc_ai_msg_5 }" itemValue="2" />
							<f:selectItem itemLabel="#{ms.sc_ai_msg_6 }" itemValue="3" />	
							<a4j:support event="onchange" ajaxSingle="true"
									actionListener="#{controlSeguimientos.cambiaAI2}"/>				
						</h:selectOneMenu>
					</h:panelGrid>
				</h:panelGrid>		
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid>
			<h:panelGrid id="estFEVI">
				<jsflot:flotChart id="chartSitClinSegFevi" 
					value="#{controlSeguimientos.chartDataSitClinFevi}" 
					chartDraggable="true" chartClickable="true" 
					reRender="clickedPanel" 
					showLines="true" fillLines="false" 
					showDataPoints="true" 
					height="200" width="350" 
					chartType="line" 
					showTooltip="true" tooltipFollowMouse="true" 
					title="FEVI" subtitle="Evolucion" 
					mode="Time" timeFormat="%m/%y" 
					yaxisTitle="%" xaxisTitle="" 
					yaxisMinValue="0" yaxisMaxValue="100" 
					markers="true" showXaxisLabels="true" showYaxisLabels="true">
				</jsflot:flotChart>
			</h:panelGrid>	
		</h:panelGrid>
	</h:panelGrid>
	
	
	
	
    <h:panelGrid width="45%" id="icSeg">
		<h:panelGrid columns="2">
			<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.ic}">
				<a4j:support event="onclick" reRender="icSeg" ajaxSingle="true"
					actionListener="#{controlSeguimientos.cambiaIC }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_ic_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" columns="2" rendered="#{controlSeguimientos.sitclin.ic eq true}">
			<h:panelGrid columns="2" width="100%">
				<h:outputLabel value="#{ms.sc_ic_msg_2 }" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection" value="#{controlSeguimientos.sitclin.nyha}">
					<f:selectItem itemLabel="I" itemValue="1" />
					<f:selectItem itemLabel="II" itemValue="2" />
					<f:selectItem itemLabel="III" itemValue="3" />
					<f:selectItem itemLabel="IV" itemValue="4" />
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlSeguimientos.cambiaNYHA }"/>
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid id="tablaCardiopatiaSeg">
		<h:panelGrid columns="2">			
			<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.cardiop}">
				<a4j:support event="onclick" reRender="tablaCardiopatiaSeg" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.sc_cardiopatia_msg_1 }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid columns="4" style="border-top: solid 1px;border-color: black;"
			width="80%" cellspacing="0" rendered="#{controlSeguimientos.sitclin.cardiop eq true }">		
			<h:selectOneMenu value="#{controlSeguimientos.sitclin.cardiopatia}">
				<f:selectItems value="#{controlSeguimientos.cardiopatia}" />					
				<a4j:support event="onchange" reRender="tablaCardiopatiaSeg" ajaxSingle="true"
				actionListener="#{controlSeguimientos.cambiaCardiopatia }"/>							
			</h:selectOneMenu>
			<h:inputText value="#{controlSeguimientos.sitclin.otra}" maxlength="45"
				rendered="#{controlSeguimientos.sitclin.cardiopatia eq 923}"/>
			<h:panelGrid columns="2" rendered="#{controlSeguimientos.sitclin.cardiopatia ne 913}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_2 }"/>
				<h:inputText value="#{controlSeguimientos.sitclin.aevolucion}" size="4" maxlength="4">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlSeguimientos.cambiaAnosEvolucion }"/> 
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid columns="4" rendered="#{controlSeguimientos.sitclin.cardiopatia eq 914}">
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_3 }"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.revascularizacion}">
					<a4j:support event="onclick" actionListener="#{controlSeguimientos.sitClinRevasc}"/>
				</h:selectBooleanCheckbox>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_4 }"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.infartoprev }">
					<a4j:support event="onclick" reRender="tablaCardiopatiaSeg" ajaxSingle="true"
						actionListener="#{controlSeguimientos.sitClinInfPrev}"/>
				</h:selectBooleanCheckbox>	
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_5 }" rendered="#{controlSeguimientos.sitclin.infartoprev eq true}"/>
				<h:inputText value="#{controlSeguimientos.sitclin.anio }" size="4" maxlength="4" rendered="#{controlSeguimientos.sitclin.infartoprev eq true}">
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlSeguimientos.cambiaAnioInfPrevio }"/>
				</h:inputText>
				<rich:spacer/>
				<rich:spacer/>
				<h:outputLabel value="#{ms.sc_cardiopatia_msg_6 }" rendered="#{controlSeguimientos.sitclin.infartoprev eq true}"/>
				<h:selectOneMenu value="#{controlSeguimientos.sitclin.localizacion }"
					rendered="#{controlSeguimientos.sitclin.infartoprev eq true}">
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
					<a4j:support event="onclick" ajaxSingle="true"
						actionListener="#{controlSeguimientos.cambiaLocalizacion }"/>					
				</h:selectOneMenu>
			</h:panelGrid>		
		</h:panelGrid>		
	</h:panelGrid>

	<h:panelGrid id="tablaComorbilidadesSeg" columns="3" 
		columnClasses="alignTop,alignTop,alignTop" >
		<h:panelGrid>
			<h:outputLabel value="#{ms.sc_antecedentes }" style="font-weight: bold;" />
			<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;"
				width="100%" cellspacing="0" columnClasses="alignTop,alignTop">
				<h:panelGrid columns="2">					
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.antefa }">
						<a4j:support event="onclick" 
							ajaxSingle="true" actionListener="#{controlSeguimientos.anteFA}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_fa_msg }"/>
				</h:panelGrid>
				<h:panelGrid columns="2">					
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteflutter }">
						<a4j:support event="onclick" 
							ajaxSingle="true" actionListener="#{controlSeguimientos.anteFlutter }"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_flut_msg }"/>
				</h:panelGrid>
				<h:panelGrid columns="2">				
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteSincope }">
						<a4j:support event="onclick" 
							ajaxSingle="true" actionListener="#{controlSeguimientos.cambiaSincope}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_sinc_msg }"/>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteParadaCardiaca }">
						<a4j:support event="onclick" ajaxSingle="true"
							actionListener="#{controlSeguimientos.cambiaParadaCardiaca}"/> 
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_pcar_msg }"/>						
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteHTA }">
						<a4j:support event="onclick" ajaxSingle="true"
							actionListener="#{controlSeguimientos.cambiaHTA}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_hta_msg }" />	
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteDislipemia }">
						<a4j:support event="onclick" ajaxSingle="true"
							actionListener="#{controlSeguimientos.cambiaDislipemia}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_disl_msg }" />
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.antediab }">
						<a4j:support event="onclick" ajaxSingle="true"
							actionListener="#{controlSeguimientos.cambiaDiabetes}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_diab_msg }" />			
				</h:panelGrid>
				<h:panelGrid columns="2">					
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.enfarterios }">
						<a4j:support event="onclick" 
							ajaxSingle="true" actionListener="#{controlSeguimientos.cambiaEnfArt}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_eart_msg }"/>
				</h:panelGrid>				
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.antetabaq }">
						<a4j:support event="onclick" ajaxSingle="true"
							actionListener="#{controlSeguimientos.cambiaTabaquismo}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_tabq_msg }" />
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteAlcohol }">
						<a4j:support event="onclick" ajaxSingle="true"
							actionListener="#{controlSeguimientos.cambiaAlcohol}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_alcohol_msg }" />	
				</h:panelGrid>			
				<rich:spacer/>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="otrasComorbilidadesSeg">
			<h:outputLabel value="#{ms.sc_antecedentes_nc }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="80%" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
				<h:panelGrid columns="3">
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteacv }" >
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlSeguimientos.cambiaACV}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_acv_msg }" />		
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteAIT }">
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlSeguimientos.cambiaAIT}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_ait_msg }" />						
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteEPOC }">
							<a4j:support event="onclick" ajaxSingle="true"
								actionListener="#{controlSeguimientos.cambiaEPOC}"/>
						</h:selectBooleanCheckbox>
						<h:outputLabel value="#{ms.sc_antecedentes_nc_epoc_msg }" />		
					</h:panelGrid>
				</h:panelGrid>							
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteSAHS }">
						<a4j:support event="onclick" ajaxSingle="true" reRender="seguimientoSAHS"
							actionListener="#{controlSeguimientos.cambiaSAHS}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_1 }" />				
				</h:panelGrid>
				<h:panelGrid columns="6" id="seguimientoSAHS">
					<h:outputLabel value="#{ms.sc_antecedentes_nc_sahs_msg_2 }" rendered="#{controlSeguimientos.sitclin.anteSAHS eq true }"/>
					<h:selectOneMenu value="#{controlSeguimientos.sitclin.tiposahs }"
						rendered="#{controlSeguimientos.sitclin.anteSAHS eq true }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_3 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_4 }" />
						<f:selectItem itemValue="3" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_5 }" />	
						<f:selectItem itemValue="4" itemLabel="#{ms.sc_antecedentes_nc_sahs_msg_6 }" />				
					</h:selectOneMenu>	
					<h:outputLabel value="#{ms.sc_antecedentes_nc_ahi_msg }" rendered="#{controlSeguimientos.sitclin.anteSAHS eq true }"/>
					<h:inputText value="#{controlSeguimientos.sitclin.ahi }" rendered="#{controlSeguimientos.sitclin.anteSAHS eq true }" size="3"/>
					<h:outputLabel value="#{ms.sc_antecedentes_nc_cpap_msg }" rendered="#{controlSeguimientos.sitclin.anteSAHS eq true }"/>
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteCPAP }"
						rendered="#{controlSeguimientos.sitclin.anteSAHS eq true }" id="cpapSeg">
						<a4j:support event="onclick" ajaxSingle="true" reRender="cpapSeg"					
							actionListener="#{controlSeguimientos.cambiaCPAP}"/>
					</h:selectBooleanCheckbox>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteinsrenal }">
						<a4j:support event="onclick" ajaxSingle="true" reRender="seguimientoInsRen"
							actionListener="#{controlSeguimientos.cambiaInsRenal}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_iren_msg }" />			
				</h:panelGrid>
				<h:panelGrid columns="2" id="seguimientoInsRen">
					<h:outputLabel value="#{ms.sc_antecedentes_iren_grado_msg }" rendered="#{controlSeguimientos.sitclin.anteinsrenal eq true }"/>
					<h:selectOneMenu value="#{controlSeguimientos.sitclin.tipoinsrenal }"
						rendered="#{controlSeguimientos.sitclin.anteinsrenal eq true }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_iren_grado_leve_msg }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_iren_grado_aguda_msg_msg }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_iren_grado_severa_msg_msg }" />					
					</h:selectOneMenu>
				</h:panelGrid>
				<rich:spacer width="20"></rich:spacer>
				<h:panelGrid columns="4">
					<h:selectBooleanCheckbox value="#{controlSeguimientos.sitclin.anteNeoplasia }">
						<a4j:support event="onclick" ajaxSingle="true" reRender="seguimientoNeoplasia"
							actionListener="#{controlSeguimientos.cambiaNeoplasia}"/>
					</h:selectBooleanCheckbox>
					<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_1 }" />			
				</h:panelGrid>
				<h:panelGrid columns="2" id="seguimientoNeoplasia">
					<h:outputLabel value="#{ms.sc_antecedentes_nc_neop_msg_2 }" rendered="#{controlSeguimientos.sitclin.anteNeoplasia eq true }"/>
					<h:inputText value="#{controlSeguimientos.sitclin.tiponeoplasia }" maxlength="45" rendered="#{controlSeguimientos.sitclin.anteNeoplasia eq true}"/>				
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.sc_antecedentes_nc_tir_msg_1 }" />	
					<h:selectOneMenu value="#{controlSeguimientos.sitclin.afectiroidea }">
						<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
						<f:selectItem itemValue="1" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_2 }" />
						<f:selectItem itemValue="2" itemLabel="#{ms.sc_antecedentes_nc_tir_msg_3 }" />					
					</h:selectOneMenu>	
				</h:panelGrid>
				<rich:spacer width="20"></rich:spacer>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid>
			<h:outputLabel value="#{ms.sc_alergias }" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputTextarea cols="50" rows="4" value="#{controlSeguimientos.sitclin.alergias }" id="alergiasSegDisp">
					<f:validateLength maximum="200" />
					<a4j:support event="onchange" ajaxSingle="true"
							actionListener="#{controlSeguimientos.cambiaAlergias }"/>
				</h:inputTextarea>	
				<h:message for="alergiasSegDisp" style="color:red" />
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid>
		<h:outputLabel value="#{ms.sc_comentarios }" style="font-weight: bold;"/>
		<h:inputTextarea cols="120" rows="8" value="#{controlSeguimientos.sitclin.comentarios }" id="comentariosSitClinSeg">	
			<f:validateLength maximum="2000" />
		</h:inputTextarea>	
		<h:message for="comentariosSitClinSeg" style="color:red" />
	</h:panelGrid>
</ui:composition>
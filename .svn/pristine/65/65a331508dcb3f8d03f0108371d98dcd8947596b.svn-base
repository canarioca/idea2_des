<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">
	
	<h:panelGrid columns="2" cellspacing="0" columnClasses="alignTop,alignTop,alignTop,alignTop,alignTop">
		<h:panelGrid rendered="#{controlSeguimientos.tipogen ne 6 }">
			<h:outputText value="#{ms.seg_disp_tab_obs_clin_porc_eval }" style="font-weight: bold;" />
			<h:panelGrid id="panelPorcEstimulacion" columnClasses="alignTop,alignTop"
				style="border-top: solid 1px;border-color: black;" columns="2">
				<h:panelGrid columns="4">
					<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_porc_eval_as }" rendered="#{controlSeguimientos.cablea eq true }"/>
					<h:inputText value="#{controlSeguimientos.por.poras }" size="3" maxlength="4"
						rendered="#{controlSeguimientos.cablea eq true }">
						<a4j:support event="onchange" ajaxSingle="true" reRender="panelPorcEstimulacion"
							actionListener="#{controlSeguimientos.cambiaAS }"/>
					</h:inputText>
					<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_porc_eval_ap }" rendered="#{controlSeguimientos.cablea eq true }"/>
					<h:inputText value="#{controlSeguimientos.por.porap }" size="3" maxlength="4"
						rendered="#{controlSeguimientos.cablea eq true }">
						<a4j:support event="onchange" ajaxSingle="true" reRender="panelPorcEstimulacion"
							actionListener="#{controlSeguimientos.cambiaAP }"/>
					</h:inputText>
					<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_porc_eval_vs }" rendered="#{controlSeguimientos.cablev eq true }"/>
					<h:inputText value="#{controlSeguimientos.por.porvs }" size="3" maxlength="4"
						rendered="#{controlSeguimientos.cablev eq true }">
						<a4j:support event="onchange" ajaxSingle="true" reRender="panelPorcEstimulacion"
							actionListener="#{controlSeguimientos.cambiaVS }"/>
					</h:inputText>
					<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_porc_eval_vp }" rendered="#{controlSeguimientos.cablev eq true }"/>
					<h:inputText value="#{controlSeguimientos.por.porvp }" size="3" maxlength="4"
						rendered="#{controlSeguimientos.cablev eq true }">
						<a4j:support event="onchange" ajaxSingle="true" reRender="panelPorcEstimulacion"
							actionListener="#{controlSeguimientos.cambiaVP }"/>
					</h:inputText>
				</h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_porc_eval_tfa }"/>
					<h:inputText value="#{controlSeguimientos.por.tiempofa }" size="3" maxlength="4"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid id="panelBloqueos" rendered="#{controlSeguimientos.tipogen ne 6 }">
			<h:panelGrid columns="2" >			
				<h:selectBooleanCheckbox value="#{controlSeguimientos.bloq.bav }">
					<a4j:support event="onclick" ajaxSingle="true" reRender="panelBloqueos"
						actionListener="#{controlSeguimientos.cambiaBAV }"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_bav }" style="font-weight: bold;"/>
			</h:panelGrid>
			<h:panelGrid columns="6" rendered="#{controlSeguimientos.bloq.bav eq true}" 
				style="border-top: solid 1px;border-color: black;">
				<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_bav_1 }"/>
				<h:inputText value="#{controlSeguimientos.bloq.bav1 }" size="3" maxlength="4"/>
				<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_bav_2 }"/>
				<h:inputText value="#{controlSeguimientos.bloq.bav2 }" size="3" maxlength="4"/>
				<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_bav_3 }"/>
				<h:inputText value="#{controlSeguimientos.bloq.bav3 }" size="3" maxlength="4"/>
			</h:panelGrid>
			<rich:spacer width="20"/>	
		</h:panelGrid>	
	</h:panelGrid>
	<h:panelGrid >
		<h:panelGrid id="panelArritmiasAuMP" rendered="#{controlSeguimientos.tipogen eq 1 || controlSeguimientos.tipogen eq 5}">
			<h:panelGrid columns="2">				
				<h:selectBooleanCheckbox value="#{controlSeguimientos.obsmp.arritmiaau }">
					<a4j:support event="onclick" reRender="panelArritmiasAuMP" ajaxSingle="true"/>
				</h:selectBooleanCheckbox>
				<h:outputText value="#{ms.seg_disp_tab_obs_clin_arritmias_au }" style="font-weight: bold;" />
			</h:panelGrid>
			<h:panelGrid columns="6" style="border-top: solid 1px;border-color: black;" 
				rendered="#{controlSeguimientos.obsmp.arritmiaau eq true}">
				<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_arritmias_au_num }"/>
				<h:inputText value="#{controlSeguimientos.obsmp.numarrau }" size="3" maxlength="4"/>
				<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_arritmias_au_cmodo }"/>
				<h:selectBooleanCheckbox value="#{controlSeguimientos.obsmp.cambiomodoarritmiaau }">
					<a4j:support event="onclick" ajaxSingle="true" reRender="panelArritmiasAuMP"
						actionListener="#{controlSeguimientos.cambiaCambioModoArritmiaAu}"/>
				</h:selectBooleanCheckbox>
				<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_arritmias_au_cmodo_num }"
					rendered="#{controlSeguimientos.obsmp.cambiomodoarritmiaau eq true}"/>
				<h:inputText value="#{controlSeguimientos.obsmp.numcambiomodoarrau }" size="3" maxlength="4"
					rendered="#{controlSeguimientos.obsmp.cambiomodoarritmiaau eq true}"/>
			</h:panelGrid>
		</h:panelGrid>	
		<h:panelGrid id="panelArritmiasVMP" rendered="#{controlSeguimientos.tipogen eq 1 || controlSeguimientos.tipogen eq 5}">
			<h:panelGrid columns="2">
				<h:selectBooleanCheckbox value="#{controlSeguimientos.obsmp.arritmiav }">
					<a4j:support event="onclick" reRender="panelArritmiasVMP" ajaxSingle="true"/>
				</h:selectBooleanCheckbox>
				<h:outputText value="#{ms.seg_disp_tab_obs_clin_arritmias_vent }" style="font-weight: bold;" />
			</h:panelGrid>
			<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" 
				rendered="#{controlSeguimientos.obsmp.arritmiav eq true}">
				<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_arritmias_vent_num }"/>
				<h:inputText value="#{controlSeguimientos.obsmp.numarrv }" size="3" maxlength="4"/>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid columns="2" rendered="#{controlSeguimientos.tipogen eq 1 || controlSeguimientos.tipogen eq 5}">
			<h:selectBooleanCheckbox value="#{controlSeguimientos.obsmp.episodiosruido }">
				<a4j:support event="onclick" ajaxSingle="true" reRender="panelArritmiasAuMP"
					actionListener="#{controlSeguimientos.cambiaEpisodiosRuidoMP }"/>
			</h:selectBooleanCheckbox>
			<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_arritmias_vent_ruido }"/>
		</h:panelGrid>
	</h:panelGrid>
	<h:panelGrid rendered="#{controlSeguimientos.tipogen eq 2 || controlSeguimientos.tipogen eq 4 || controlSeguimientos.tipogen eq 6}"
		id="panelEpisodiosTerapiasSeg" columnClasses="alignTop,alignTop">
		<h:panelGrid columns="2">
			<h:selectBooleanCheckbox value="#{controlSeguimientos.obsdai.arritmias }">
				<a4j:support event="onclick" reRender="panelEpisodiosTerapiasSeg" ajaxSingle="true"/>
			</h:selectBooleanCheckbox>
			<h:outputText value="#{ms.seg_disp_tab_obs_clin_arritmias }" style="font-weight: bold;" />
		</h:panelGrid>
		<h:panelGrid id="panelArritmiasDAI"
			style="border-top: solid 1px;border-color: black;" columns="3"
				columnClasses="alignTop,alignTop,alignTop" rendered="#{controlSeguimientos.obsdai.arritmias eq true}">
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_epi_total }" rendered="#{controlSeguimientos.obsdai.arritmias eq true }"
						style="font-weight: bold;"/>
					<h:inputText value="#{controlSeguimientos.obsdai.numepisodios }" size="3" maxlength="4" 
						rendered="#{controlSeguimientos.obsdai.arritmias eq true }">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapiasSeg" 
							actionListener="#{controlSeguimientos.controlNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>
				</h:panelGrid>
				<h:panelGrid columns="2" rendered="#{controlSeguimientos.obsdai.arritmias eq true }">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_tsv }"/>
					<h:inputText value="#{controlSeguimientos.obsdai.numepitsv }" size="3" maxlength="4">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapiasSeg" 
							actionListener="#{controlSeguimientos.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_tv }"/>
					<h:inputText value="#{controlSeguimientos.obsdai.numepitv }" size="3" maxlength="4">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapiasSeg" 
							actionListener="#{controlSeguimientos.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_fv }"/>
					<h:inputText value="#{controlSeguimientos.obsdai.numepifv }" size="3" maxlength="4">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapiasSeg" 
							actionListener="#{controlSeguimientos.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>	
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_nsost }"/>
					<h:inputText value="#{controlSeguimientos.obsdai.numepinosost }" size="3" maxlength="4">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapiasSeg" 
							actionListener="#{controlSeguimientos.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_nesp }"/>
					<h:inputText value="#{controlSeguimientos.obsdai.numepinoesp }" size="3" maxlength="4">
						<a4j:support event="onchange" reRender="panelEpisodiosTerapiasSeg" 
							actionListener="#{controlSeguimientos.cambiaNumEpisodios }" ajaxSingle="true"/>
					</h:inputText>	
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid id="terapiaEntregadaDAISeg" >
				<h:panelGrid columns="2">
					<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_ent }" style="font-weight: bold;" />
					<h:selectBooleanCheckbox value="#{controlSeguimientos.obsdai.terapiaentregada }">
						<a4j:support event="onclick" reRender="terapiaEntregadaDAISeg" ajaxSingle="true"/>
					</h:selectBooleanCheckbox>
				</h:panelGrid>
				<h:panelGrid columns="3" rendered="#{controlSeguimientos.obsdai.terapiaentregada eq true }"
		  			columnClasses="alignTop,alignTop,alignTop" width="100%">		
					<h:panelGrid columns="2" rendered="#{controlSeguimientos.tipogen eq 2 || controlSeguimientos.tipogen eq 4 }">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_atp }" style="font-weight: bold;" />
						<h:selectBooleanCheckbox value="#{controlSeguimientos.obsdai.teratp}">
							<a4j:support event="onclick" reRender="terapiaEntregadaDAISeg" ajaxSingle="true"
								actionListener="#{controlSeguimientos.cambiaTerapiaAtp}"/>
						</h:selectBooleanCheckbox>
						<h:panelGrid columns="2" style="border-top: solid 1px;border-color: black;" width="70%" 
							id="terapiaEntregadaATPSeg" rendered="#{controlSeguimientos.obsdai.teratp eq true }">
							<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_atp_num }" style="font-weight: bold;"/>
							<h:inputText size="4" value="#{controlSeguimientos.obsdai.numteratp}" maxlength="4"/>
							<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_atp_efec }" style="font-weight: bold;" />
							<h:selectBooleanCheckbox value="#{controlSeguimientos.obsdai.terapiaefecatp}">
								<a4j:support event="onclick" reRender="terapiaEntregadaDAISeg" ajaxSingle="true"
									actionListener="#{controlSeguimientos.cambiaTerapiaEfectivaATP}"/>
							</h:selectBooleanCheckbox>
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid columns="2">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_zonas_choques }" style="font-weight: bold;" />
						<h:selectBooleanCheckbox value="#{controlSeguimientos.obsdai.terchoques}">
							<a4j:support event="onclick" reRender="terapiaEntregadaDAISeg" ajaxSingle="true"
								actionListener="#{controlSeguimientos.cambiaTerapiaChoques}"/>
						</h:selectBooleanCheckbox>
						<h:panelGrid style="border-top: solid 1px;border-color: black;" 
							id="terapiaEntregadaChoquesSeg" rendered="#{controlSeguimientos.obsdai.terchoques eq true }">
							<h:panelGrid columns="2" width="70%">
								<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_num }" style="font-weight: bold;" />
								<h:inputText size="4" value="#{controlSeguimientos.obsdai.numterchoq}" maxlength="4"/>
								<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_efec }" style="font-weight: bold;" />
								<h:selectBooleanCheckbox value="#{controlSeguimientos.obsdai.terapiaefecchoq}">
									<a4j:support event="onclick" reRender="terapiaEntregadaChoquesSeg" ajaxSingle="true"
									actionListener="#{controlSeguimientos.cambiaTerapiaEfectivaChoques}"/>
								</h:selectBooleanCheckbox>
							</h:panelGrid>
						</h:panelGrid>	
					</h:panelGrid>
					<h:panelGrid columns="2" id="terapiaTodasApropiadasSeg">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_apropiadas }" style="font-weight: bold;" />
						<h:selectOneRadio layout="lineDirection" value="#{controlSeguimientos.obsdai.todasapropiadas}">
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_apropiadas_op0 }" itemValue="0" />
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_apropiadas_op1 }" itemValue="1"/>
							<f:selectItem itemLabel="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_apropiadas_op2 }" itemValue="2"/>
							<a4j:support event="onclick" reRender="terapiaTodasApropiadasSeg" ajaxSingle="true"/>
						</h:selectOneRadio>
						<rich:spacer width="20" />
						<h:selectOneMenu value="#{controlSeguimientos.obsdai.motivotodasapropiadas}" 
							rendered="#{controlSeguimientos.obsdai.todasapropiadas eq 1 }">
							<f:selectItems value="#{controlSeguimientos.motivosterapianoapropiada}" />	
						</h:selectOneMenu>
					</h:panelGrid>		 
				</h:panelGrid>		
				<rich:panel rendered="#{controlSeguimientos.obsdai.terchoques eq true }">
					<f:facet name="header">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_ultimo }"/>
					</f:facet>
					<h:panelGrid columns ="6" columnClasses="alignTop,alignTop,alignTop">
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_ultimo_ener }"
							style="font-weight: bold;"/>
						<h:inputText size="4" value="#{controlSeguimientos.obsdai.ultchoqenergia}" maxlength="4"/>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_ultimo_tcarga }"
							style="font-weight: bold;"/>
						<h:inputText size="4" value="#{controlSeguimientos.obsdai.ultchoqtcarga}" maxlength="4"/>
						<h:outputLabel value="#{ms.imp_dispositivos_tab_ev_prog_av_epi_ter_chq_ultimo_imp }"
							style="font-weight: bold;"/>
						<h:inputText size="4" value="#{controlSeguimientos.obsdai.ultchoqimpedancia}" maxlength="4"/>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
			<h:panelGrid columns="2" style="font-weight: bold;">
					<h:outputLabel value="#{ms.seg_disp_tab_obs_clin_epi_ruido }"/>
					<h:selectBooleanCheckbox value="#{controlSeguimientos.obsdai.episodiosruido }">
						<a4j:support event="onclick" ajaxSingle="true" reRender="panelArritmiasDAI"
							actionListener="#{controlSeguimientos.cambiaEpisodiosRuidoDAI }"/>
					</h:selectBooleanCheckbox>
			</h:panelGrid>
		</h:panelGrid>		
	</h:panelGrid>
</ui:composition>
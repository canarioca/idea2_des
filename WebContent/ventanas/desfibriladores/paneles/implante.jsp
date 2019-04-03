<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%" id="panImplante">
		<h:panelGrid columns="2" cellspacing="0">
			<h:outputLabel value="A." style="font-weight: bold;" />
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.implante }">
				<f:selectItem itemLabel="Prevención primaria" itemValue="1" />
				<f:selectItem itemLabel="Prevención secundaria" itemValue="2" />
			</h:selectOneRadio>
		</h:panelGrid>
		
		<rich:spacer height="2px"/>
		
		<h:outputLabel value="B. Datos Implante" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellspacing="0" columns="2">
			<h:outputLabel value="Fecha" />
			<rich:calendar datePattern="dd/MM/yyyy"
				value="#{controlDesfibriladores.desf.fecimplante }" inputSize="12" />
		</h:panelGrid>
		<h:panelGrid cellspacing="0" columns="3">
			<rich:spacer width="15px"/>
			<h:outputLabel value="Lugar del implante" style="font-style: oblique;"/>
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.lugarimplante }">
				<f:selectItem itemLabel="Lab. electrofisiología" itemValue="1" />
				<f:selectItem itemLabel="Quirófano" itemValue="2" />
				<f:selectItem itemLabel="Otro" itemValue="3" />
			</h:selectOneRadio>
		</h:panelGrid>
		
		<rich:spacer height="3px"/>
		
		<h:outputLabel value="C. Implantador" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellspacing="0">
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.implantador }">
				<f:selectItem itemLabel="Cirujano" itemValue="1" />
				<f:selectItem itemLabel="Electrofisiológico" itemValue="2" />
				<f:selectItem itemLabel="Intensivista" itemValue="3" />
				<f:selectItem itemLabel="Otro" itemValue="4" />
				<f:selectItem itemLabel="EF + Cirujano" itemValue="5" />
			</h:selectOneRadio>
		</h:panelGrid>
		
		<rich:spacer height="3px"/>
		
		<a4j:jsFunction name="actrecambio" reRender="panImplante"/>
		<h:outputLabel value="D. Generador" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellspacing="0">
			<h:panelGrid columns="3">
			<h:panelGrid columns="2">
				<h:outputLabel value="Fabricante" style="font-style: oblique;"/>
				<h:inputText/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="Modelo" style="font-style: oblique;"/>
				<h:inputText/>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputLabel value="Num.Serie" style="font-style: oblique;"/>
				<h:inputText/>
			</h:panelGrid>
		</h:panelGrid>
			<h:selectOneRadio layout="lineDirection" onclick="actrecambio();"
				value="#{controlDesfibriladores.desf.generador }">
				<f:selectItem itemLabel="Primoimplante" itemValue="1" />
				<f:selectItem itemLabel="Recambio" itemValue="2" />
			</h:selectOneRadio>
		</h:panelGrid>
		<h:panelGrid id="panRecambio" rendered="#{controlDesfibriladores.desf.generador eq 2 }"
			cellspacing="0">
			<t:fieldset legend="Recambio" rendered="#{controlDesfibriladores.desf.generador eq 2 }">
				<h:panelGrid columns="2" cellspacing="0">
					<h:outputLabel value="Fecha implante previo"/>
					<rich:calendar datePattern="dd/MM/yyyy"
						value="#{controlDesfibriladores.desf.fecimplprevio }" inputSize="12" />
				</h:panelGrid>
				<h:selectOneRadio layout="lineDirection" 
					value="#{controlDesfibriladores.desf.recambio }">
					<f:selectItem itemLabel="Por agotamiento" itemValue="1" />
					<f:selectItem itemLabel="Por complicaciones" itemValue="2" />
					<f:selectItem itemLabel="upgrade por cambio de indicación" itemValue="3" />
				</h:selectOneRadio>
				<h:panelGrid columns="2" cellspacing="0">
					<h:outputLabel value="¿Episodios de TV/FV?"/>
					<h:selectOneRadio layout="lineDirection" 
						value="#{controlDesfibriladores.desf.tvfv }">
						<f:selectItem itemLabel="No" itemValue="1" />
						<f:selectItem itemLabel="Si" itemValue="2" />
					</h:selectOneRadio>
				</h:panelGrid>
				<h:panelGrid columns="2" cellspacing="0">
					<h:outputLabel value="¿Terapia?"/>
					<h:selectOneRadio layout="lineDirection" 
						value="#{controlDesfibriladores.desf.terapia }">
						<f:selectItem itemLabel="ATP" itemValue="1" />
						<f:selectItem itemLabel="Choque" itemValue="2" />
						<f:selectItem itemLabel="Ambas" itemValue="3" />
					</h:selectOneRadio>
				</h:panelGrid>
			</t:fieldset>
		</h:panelGrid>
		<h:panelGrid cellspacing="0" columns="3">
			<rich:spacer width="15px"/>
			<h:outputLabel value="Localización" style="font-style: oblique;"/>
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.locimplante }">
				<f:selectItem itemLabel="Subcutáneo" itemValue="1" />
				<f:selectItem itemLabel="Subpectoral" itemValue="2" />
			</h:selectOneRadio>
		</h:panelGrid>
		
		<rich:spacer height="3px"/>
		
		<h:outputLabel value="E. Electrodos sistema actual" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellspacing="0">
			<h:panelGrid cellpadding="0">
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.adb }" />
						<h:outputLabel value="AD"/>
					</h:panelGrid>
					<h:panelGrid columns="4">
						<h:panelGrid columns="2">
							<h:outputLabel value="Fabricante"/>
							<h:inputText/>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="Modelo" />
							<h:inputText/>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="Num.Serie" />
							<h:inputText/>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.vdb }"/>
						<h:outputLabel value="VD"/>
					</h:panelGrid>
					<h:panelGrid columns="4">
						<h:panelGrid columns="2">
							<h:outputLabel value="Fabricante"/>
							<h:inputText/>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="Modelo" />
							<h:inputText/>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="Num.Serie" />
							<h:inputText/>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:panelGrid columns="2">
						<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.vib }"/>
						<h:outputLabel value="VI"/>
					</h:panelGrid>
					<h:panelGrid columns="4">
						<rich:spacer height="3px"/>
						<h:panelGrid columns="2">
							<h:outputLabel value="Fabricante"/>
							<h:inputText/>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="Modelo" />
							<h:inputText/>
						</h:panelGrid>
						<h:panelGrid columns="2">
							<h:outputLabel value="Num.Serie" />
							<h:inputText/>
						</h:panelGrid>
					</h:panelGrid>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:outputLabel value="Fecha implante (si anteriores)" style="font-style: oblique;"/>
				<rich:calendar datePattern="dd/MM/yyyy"
						value="#{controlDesfibriladores.desf.fecimplanter }" inputSize="12" />
				<h:outputLabel value="Electrodo adicional" style="font-style: oblique;"/>
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.elecadic }">
					<f:selectItem itemLabel="Sensado" itemValue="1" />
					<f:selectItem itemLabel="Desfibrilación" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
		
		<rich:spacer height="3px"/>
		
		<h:outputLabel value="F. Electrodos previos" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellspacing="0">
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.elecprev }">
				<f:selectItem itemLabel="Funcionantes" itemValue="1" />
				<f:selectItem itemLabel="Disfuncionantes abandonados" itemValue="2" />
				<f:selectItem itemLabel="Disfuncionantes explantados" itemValue="3" />
			</h:selectOneRadio>
		</h:panelGrid>
		
		<rich:spacer height="3px"/>
		
		<h:outputLabel value="G. ¿Se realiza inducción?" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellspacing="0">
			<h:panelGrid columns="3" cellpadding="0" cellspacing="0" width="80%">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.induc }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:outputLabel value="Umbral (J)"/>
					<h:inputText size="10" value="#{controlDesfibriladores.desf.umbral }"/>
				</h:panelGrid>
				<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
					<h:outputLabel value="Nº de choques"/>
					<h:inputText size="10" value="#{controlDesfibriladores.desf.nchoques }"/>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
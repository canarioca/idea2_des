<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid id="panModalConsentimientoMRI" >
		<h:panelGrid columns="6">
			<h:outputLabel value="Dr./Dra." style="font-weight: bold;"/>
			<h:outputLabel value="Num. Colegiado" style="font-weight: bold;"/>			
			<h:outputLabel value="Nombre (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido1 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido2 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="DNI (Rep.Legal)*" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.consmri.doctor }">
					<f:selectItems value="#{controlPacientes.operadores}" />
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorMRI1,doctorMRI2,doctorMRI3,doctorMRI4,doctorMRI5,doctorMRI6"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmri.numcolegiado }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorMRI6"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmri.repleg_nombre }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconsmri"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmri.repleg_ap1 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconsmri"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmri.repleg_ap2 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconsmri"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmri.repleg_dni }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconsmri"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="* Rellene esta información si procede" style="font-style: italic;"/>
		<hr/>
		<h:panelGrid id="textoConsentimientoMRI">
			<h:outputLabel value="CONSENTIMIENTO PARA LA REALIZACIÓN DE RESONANCIA MAGNÉTICA EN PACIENTE PORTADOR DE MARCAPASOS CARDÍACO DEFINITIVO U OTRO DISPOSITIVO DE ELECTROESTIMULACIÓN CARDÍACA." style="font-weight: bold;"/>
			<h:outputLabel value="I-INFORMACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="1-¿Qué es?" style="font-weight: bold;"/>
			<h:outputLabel value="La Resonancia Magnética es una prueba radiológica diagnóstica que dadas  las características clínicas de su enfermedad, su médico responsable considera muy conveniente o imprescindible. Sin embargo, usted es portador de un dispositivo de estimulación cardíaca (marcapasos, DAI, resincronizador, etc). Dado que el aparato de Resonancia magnética utiliza imanes muy potentes existe la posibilidad de que su dispositivo sea desprogramado o incluso dañado."/>
			<h:outputLabel value="2-¿Para qué sirve?" style="font-weight: bold;"/>
			<h:outputLabel value="Antes de realizar la prueba se realizará un estudio de su caso clínico, del estado del aparato y de su dependencia a la estimulación del corazón." />
			<h:outputLabel value="Justo antes de realizar la resonancia magnética se ajustará el dispositivo y durante el procedimiento habrá un experto en Marcapasos vigilando el estado clínico y las constantes vitales. El paciente permanecerá habitualmente acostado y consciente, aunque será sedado o incluso anestesiado si fuera necesario. Una vez acabada la prueba se realizará una revisión completa del dispositivo y se reprogramará el aparato con parámetros similares a los que tenía antes de la resonancia." />
			<h:outputLabel value="3-¿Qué riesgo tiene?" style="font-weight: bold;"/>
			<h:outputLabel value="Diferentes estudios científicos indican que los riesgos son escasos  (cambios en los parámetros medidos  en  el marcapasos, como impedancias y umbrales) y pocas veces son relevantes (mal funcionamiento del dispositivo o de los cables). Muy raras son otras complicaciones relacionadas con el procedimiento (dolor, calor, sensación de movimiento del generador, dislocación de cables, parada cardíaca), si bien alguna de ellas son graves y requieren actuación urgente; el riesgo de muerte es excepcional."/>
			<h:outputLabel value="Otros riesgos o complicaciones que podrían  aparecer, dada su situación clínica y sus circunstancias personales son:" />
			<h:inputTextarea cols="225" rows="3" value="#{controlPacientes.consmri.riesgos }"/>
			<h:outputLabel value="En su actual estado clínico, su médico considera que los beneficios derivados de la realización de este procedimiento superan los posibles riesgos. Por este motivo se le indica la conveniencia de que le sea practicado. Si aparecieran complicaciones, el personal médico y de enfermería que le atiende está capacitado y dispone de los medios para tratar de resolverlas."/>
			<h:outputLabel value="5-¿Hay otras alternativas?" style="font-weight: bold;"/>
			<h:outputLabel value="Este tratamiento está indicado de modo preferente en su caso. Antes de firmar este formulario, no dude en pedir cualquier aclaración adicional que desee."/>			 
			<h:outputLabel value="II-DECLARACIONES Y FIRMAS" style="font-weight: bold;"/>
			<h:outputLabel value="1-PACIENTE" style="font-weight: bold;"/>
			<h:outputLabel id="doctorMRI1" value="El médico Dr./Dra. #{controlPacientes.consmri.doctor } me ha explicado de forma satisfactoria qué es, como se realiza y para qué sirve la realización de una resonancia magnética siendo portador de un dispositivo de electroestimulación cardíaca (marcapasos, DAI, resincronizador, etc). También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para la situación clínica actual."/>				
			<h:outputLabel id="doctorMRI2" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consmri.doctor } y el personal ayudante que precise, realicen la Resonancia Magnética. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel value="2-REPRESENTANTE LEGAL*" style="font-weight: bold;"/>
			<h:outputLabel id="doctorMRI3" value="El médico Dr./Dra. #{controlPacientes.consmri.doctor } me ha explicado de forma satisfactoria qué es, como se realiza y para qué sirve la realización de una resonancia magnética siendo portador de un dispositivo de electroestimulación cardíaca (marcapasos, DAI, resincronizador, etc). También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para la situación clínica actual."/>				
			<h:outputLabel id="doctorMRI4" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consmri.doctor } y el personal ayudante que precise, realicen la Resonancia Magnética. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel id="repLegalconsmri" value="Firmado: #{controlPacientes.consmri.repleg_nombre } #{controlPacientes.consmri.repleg_ap1 } #{controlPacientes.consmri.repleg_ap2 } - DNI:  #{controlPacientes.consmri.repleg_dni }"/>
			<h:outputLabel value="3-MÉDICO" style="font-weight: bold;"/>
			<h:outputLabel id="doctorMRI5" value="Dr./Dra. #{controlPacientes.consmri.doctor }. He informado a este paciente y/o a su representante legal, del propósito y naturaleza del procedimiento diagnóstico Resonancia Magnética siendo portador de un dispositivo de electroestimulación cardíaca (marcapasos, DAI, resincronizador, etc) así como de sus riesgos y alternativas." />
			<h:outputLabel id="doctorMRI6" value="Firmado: #{controlPacientes.consmri.doctor } - Número colegiado:  #{controlPacientes.consmri.numcolegiado }"/>
			<h:outputLabel value="III-DATOS DE IDENTIFICACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="Paciente: #{controlPacientes.pacienteSelect.nombreCompleto }. Edad: #{controlPacientes.pacienteSelect.edad } años. Número Historia Clínica: #{controlPacientes.pacienteSelect.nhc }"   />
			<h:outputLabel value="IV-NOTA" style="font-weight: bold;"/>
			<h:outputLabel value="Si usted, ante testigos, no acepta firmar este consentimiento, hágalo constar:" />
			<h:outputLabel value="REVOCO la anterior autorización y rechazo el tratamiento indicado por mis médicos, conociendo las consecuencias que para mi salud o mi vida puede tener esta decisión" style="font-style: italic;"/>		
		</h:panelGrid>
			
	</h:panelGrid>
	
</ui:composition>
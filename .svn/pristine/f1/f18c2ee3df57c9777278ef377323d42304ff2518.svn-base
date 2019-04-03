<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid id="panModalConsentimientoMPSTRANS" >
		<h:panelGrid columns="6">
			<h:outputLabel value="Dr./Dra." style="font-weight: bold;"/>
			<h:outputLabel value="Num. Colegiado" style="font-weight: bold;"/>			
			<h:outputLabel value="Nombre (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido1 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido2 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="DNI (Rep.Legal)*" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.constran.doctor }">
					<f:selectItems value="#{controlPacientes.operadores}" />
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorMPSTRANS1,doctorMPSTRANS2,doctorMPSTRANS3,doctorMPSTRANS4,doctorMPSTRANS5,doctorMPSTRANS6"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.constran.numcolegiado }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorMPSTRANS6"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.constran.repleg_nombre }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconstran"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.constran.repleg_ap1 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconstran"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.constran.repleg_ap2 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconstran"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.constran.repleg_dni }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconstran"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="* Rellene esta información si procede" style="font-style: italic;"/>
		<hr/>
		<h:panelGrid id="textoConsentimientoMPSTRANS">
			<h:outputLabel value="CONSENTIMIENTO PARA IMPLANTACIÓN DE MARCAPASOS CARDÍACO TRANSITORIO" style="font-weight: bold;"/>
			<h:outputLabel value="I-INFORMACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="1-¿Qué es?" style="font-weight: bold;"/>
			<h:outputLabel value="Es un tratamiento para pacientes con determinadas alteraciones del ritmo (lentas), o de la conducción cardíaca (bloqueos). Consiste en colocar un cable-electrodo a través de una vena del cuello, debajo de la clavícula, brazo o ingle hasta el corazón, que se conecta con un generador externo de forma transitoria"/>
			<h:outputLabel value="2-¿Para qué sirve?" style="font-weight: bold;"/>
			<h:outputLabel value="Permite mantener una frecuencia adecuada de las pulsaciones del corazón, en espera de la colocación de un marcapasos definitivo o hasta la resolución del problema que precisó el marcapasos transitorio. Su implantación puede hacerse con carácter urgente o electivo." />
			<h:outputLabel value="3-¿Cómo se  realiza?" style="font-weight: bold;"/>
			<h:outputLabel value="El paciente permanecerá habitualmente acostado y consciente. Se administra anestesia local en el lugar de la punción. Posteriormente se punciona la vena y se introduce un electro-catéter (cable muy fino, largo y flexible) que se dirige hasta la punta del corazón con control radioscópico o sin radioscopia con un balón que tiene la punta del catéter. Dicho cable se conecta externamente a un estimulador eléctrico (marcapasos)."/>
			<h:outputLabel value="4-¿Qué riesgo tiene?" style="font-weight: bold;"/>
			<h:outputLabel value="Los riesgos son escasos y leves (hematoma en el lugar de la punción, flebitis) y pocas veces son relevantes (neumotórax, arritmias, hemorragia que precise transfusión). Muy raras son otras complicaciones relacionadas con el procedimiento (trombosis venosa o intracardiaca, infarto pulmonar, sepsis, perforación cardiaca con taponamiento), si bien alguna de ellas son graves y requieren actuación urgente. "/>
			<h:outputLabel value="Otros riesgos o complicaciones que podrían  aparecer, dada su situación clínica y sus circunstancias personales son: " />
			<h:inputTextarea cols="225" rows="3" value="#{controlPacientes.constran.riesgos }"/>
			<h:outputLabel value="En su actual estado clínico, los beneficios derivados de la realización de este procedimiento superan los posibles riesgos. Por este motivo se le indica la conveniencia de que le sea practicado. Si aparecieran complicaciones, el personal médico y de enfermería que le atiende está capacitado y dispone de los medios para tratar de resolverlas." />
			<h:outputLabel value="5-¿Hay otras alternativas?" style="font-weight: bold;"/>
			<h:outputLabel value="Este tratamiento está indicado de modo preferente en su caso. Antes de firmar este formulario, no dude en pedir cualquier aclaración adicional que desee."/>			 
			<h:outputLabel value="II-DECLARACIONES Y FIRMAS" style="font-weight: bold;"/>
			<h:outputLabel value="1-PACIENTE" style="font-weight: bold;"/>
			<h:outputLabel id="doctorMPSTRANS1" value="El médico Dr./Dra. #{controlPacientes.constran.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el implante de marcapasos cardíaco transitorio. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorMPSTRANS2" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.constran.doctor } y el personal ayudante que precise, realicen el implante de DAI. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel value="2-REPRESENTANTE LEGAL*" style="font-weight: bold;"/>
			<h:outputLabel id="doctorMPSTRANS3" value="El médico Dr./Dra. #{controlPacientes.constran.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el implante de marcapasos cardíaco transitorio. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorMPSTRANS4" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.constran.doctor } y el personal ayudante que precise, realicen el implante de DAI. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel id="repLegalconstran" value="Firmado: #{controlPacientes.constran.repleg_nombre } #{controlPacientes.constran.repleg_ap1 } #{controlPacientes.constran.repleg_ap2 } - DNI:  #{controlPacientes.constran.repleg_dni }"/>
			<h:outputLabel value="3-MÉDICO" style="font-weight: bold;"/>
			<h:outputLabel id="doctorMPSTRANS5" value="Dr./Dra. #{controlPacientes.constran.doctor }. He informado a este paciente y/o a su representante legal, del propósito y naturaleza del procedimiento implante de marcapasos cardíaco transitorio, así como de sus riesgos y alternativas." />
			<h:outputLabel id="doctorMPSTRANS6" value="Firmado: #{controlPacientes.constran.doctor } - Número colegiado:  #{controlPacientes.constran.numcolegiado }"/>
			<h:outputLabel value="III-DATOS DE IDENTIFICACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="Paciente: #{controlPacientes.pacienteSelect.nombreCompleto }. Edad: #{controlPacientes.pacienteSelect.edad } años. Número Historia Clínica: #{controlPacientes.pacienteSelect.nhc }"   />
			<h:outputLabel value="IV-NOTA" style="font-weight: bold;"/>
			<h:outputLabel value="Si usted, ante testigos, no acepta firmar este consentimiento, hágalo constar:" />
			<h:outputLabel value="REVOCO la anterior autorización y rechazo el tratamiento indicado por mis médicos, conociendo las consecuencias que para mi salud o mi vida puede tener esta decisión" style="font-style: italic;"/>		
		</h:panelGrid>
			
	</h:panelGrid>
	
</ui:composition>
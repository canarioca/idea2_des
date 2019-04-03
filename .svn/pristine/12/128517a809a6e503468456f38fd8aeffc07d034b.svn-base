<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid id="panModalConsentimientoREC" >
		<h:panelGrid columns="6">
			<h:outputLabel value="Dr./Dra." style="font-weight: bold;"/>
			<h:outputLabel value="Num. Colegiado" style="font-weight: bold;"/>			
			<h:outputLabel value="Nombre (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido1 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido2 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="DNI (Rep.Legal)*" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.consrec.doctor }">
					<f:selectItems value="#{controlPacientes.operadores}" />
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorREC1,doctorREC2,doctorREC3,doctorREC4,doctorREC5,doctorREC6"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consrec.numcolegiado }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorREC6"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consrec.repleg_nombre }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsREC"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consrec.repleg_ap1 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsREC"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consrec.repleg_ap2 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsREC"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consrec.repleg_dni }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsREC"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="* Rellene esta información si procede" style="font-style: italic;"/>
		<hr/>
		<h:panelGrid id="textoConsentimientoREC">
			<h:outputLabel value="CONSENTIMIENTO PARA CAMBIO DE SISTEMAS DE ESTIMULACIÓN CARDÍACA PERMANENTE" style="font-weight: bold;"/>
			<h:outputLabel value="I-INFORMACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="1- La unidad de estimulación (marcapasos, desfibrilador (DAI), resincronizador) que se le implantó necesita ser sustituida por una nueva. Ha estado acudiendo a revisiones a nuestra consulta externa y finalmente se le ha propuesto intervenirse para cambiar el dispositivo de estimulación. "/>
			<h:outputLabel value="La indicación actual de recambio es:"/>
			<h:selectOneMenu value="#{controlPacientes.consrec.indicacion}">
				<f:selectItem itemLabel="(Seleccione opción)" itemValue="" />
				<f:selectItem itemLabel="Agotamiento de batería" itemValue="Agotamiento de batería" />
				<f:selectItem itemLabel="Infección" itemValue="Infección" />
				<f:selectItem itemLabel="Prevención primaria" itemValue="Prevención primaria" />
			</h:selectOneMenu>	
			<h:outputLabel value="2-¿Cómo se realiza?" style="font-weight: bold;"/>
			<h:outputLabel value="El paciente permanecerá acostado y consciente. Se aplica anestesia local en el lugar donde se encuentra el dispositivo que hay que cambiar. Se realiza incisión, generalmente sobre la cicatriz previa (si el aparato no se ha desplazado del sitio de implante) y se realiza comprobación del funcionamiento de los electrodos y el cambio de generador. Una vez comprobado el correcto funcionamiento del dispositivo se cierra la herida de la piel con unos puntos de sutura. Después del cambio, el paciente deberá permanecer en reposo varias horas y en algunos casos precisará ingreso hospitalario." />
			<h:outputLabel value="3-¿Qué riesgo tiene?" style="font-weight: bold;"/>
			<h:outputLabel value="Los riesgos inmediatos son escasos y leves (molestias en la zona de implantación del generador, hematoma,...) y pocas veces son relevantes (hemorragia que precise transfusión). A medio-largo plazo puede ocurrir infección de la bolsa donde se localiza el aparato y/o infección en los electrodos produciendo infección grave (endocarditis) que precisaría antibioterapia y extracción de todos los componentes por parte de Cirugía Cardiovascular. Si el funcionamiento de su corazón es dependiente del dispositivo que se va a cambiar es posible que precise medicación durante la operación para ayudar a tener un ritmo cardíaco mínimo. Es muy infrecuente que alguna de las partes de su aparato resulte dañado durante la intervención."/>
			<h:outputLabel value="Otros riesgos o complicaciones que podrían  aparecer, dada su situación clínica y sus circunstancias personales son: " />
			<h:inputTextarea cols="225" rows="3" value="#{controlPacientes.consrec.riesgos }"/>
			<h:outputLabel value="En su actual estado clínico, los beneficios derivados de la realización de este procedimiento superan los posibles riesgos. Por este motivo se le indica la conveniencia de que le sea practicado. Si aparecieran complicaciones, el personal médico y de enfermería que le atiende está capacitado y dispone de los medios para tratar de resolverlas." />
			<h:outputLabel value="4-¿Hay otras alternativas?" style="font-weight: bold;"/>
			<h:outputLabel value="Este tratamiento está indicado de modo preferente en su caso. Antes de firmar este formulario, no dude en pedir cualquier aclaración adicional que desee."/>			 
			<h:outputLabel value="II-DECLARACIONES Y FIRMAS" style="font-weight: bold;"/>
			<h:outputLabel value="1-PACIENTE" style="font-weight: bold;"/>
			<h:outputLabel id="doctorREC1" value="El médico Dr./Dra. #{controlPacientes.consrec.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el cambio de mi dispositivo de estimulación cardíaca. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorREC2" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consrec.doctor } y el personal ayudante que precise, realicen el cambio del aparato. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel value="2-REPRESENTANTE LEGAL*" style="font-weight: bold;"/>
			<h:outputLabel id="doctorREC3" value="El médico Dr./Dra. #{controlPacientes.consrec.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el cambio de mi dispositivo de estimulación cardíaca. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorREC4" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consrec.doctor } y el personal ayudante que precise, realicen el cambio del aparato. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel id="repLegalConsREC" value="Firmado: #{controlPacientes.consrec.repleg_nombre } #{controlPacientes.consrec.repleg_ap1 } #{controlPacientes.consrec.repleg_ap2 } - DNI:  #{controlPacientes.consrec.repleg_dni }"/>
			<h:outputLabel value="3-MÉDICO" style="font-weight: bold;"/>
			<h:outputLabel id="doctorREC5" value="Dr./Dra. #{controlPacientes.consrec.doctor }. He informado a este paciente y/o a su representante legal, del propósito y naturaleza del procedimiento cambio del sistema de estimulación cardíaca permanente, así como de sus riesgos y alternativas." />
			<h:outputLabel id="doctorREC6" value="Firmado: #{controlPacientes.consrec.doctor } - Número colegiado:  #{controlPacientes.consrec.numcolegiado }"/>
			<h:outputLabel value="III-DATOS DE IDENTIFICACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="Paciente: #{controlPacientes.pacienteSelect.nombreCompleto }. Edad: #{controlPacientes.pacienteSelect.edad } años. Número Historia Clínica: #{controlPacientes.pacienteSelect.nhc }"   />
			<h:outputLabel value="IV-NOTA" style="font-weight: bold;"/>
			<h:outputLabel value="Si usted, ante testigos, no acepta firmar este consentimiento, hágalo constar:" />
			<h:outputLabel value="REVOCO la anterior autorización y rechazo el tratamiento indicado por mis médicos, conociendo las consecuencias que para mi salud o mi vida puede tener esta decisión" style="font-style: italic;"/>		
		</h:panelGrid>
			
	</h:panelGrid>
	
</ui:composition>
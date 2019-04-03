<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid id="panModalConsentimientoEXP" >
		<h:panelGrid columns="6">
			<h:outputLabel value="Dr./Dra." style="font-weight: bold;"/>
			<h:outputLabel value="Num. Colegiado" style="font-weight: bold;"/>			
			<h:outputLabel value="Nombre (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido1 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido2 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="DNI (Rep.Legal)*" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.consexp.doctor }">
					<f:selectItems value="#{controlPacientes.operadores}" />
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorEXP1,doctorEXP2,doctorEXP3,doctorEXP4,doctorEXP5,doctorEXP6"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consexp.numcolegiado }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorEXP6"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consexp.repleg_nombre }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconsexp"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consexp.repleg_ap1 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconsexp"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consexp.repleg_ap2 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconsexp"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consexp.repleg_dni }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalconsexp"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="* Rellene esta información si procede" style="font-style: italic;"/>
		<hr/>
		<h:panelGrid id="textoConsentimientoEXP">
			<h:outputLabel value="CONSENTIMIENTO PARA EXTIRPACIÓN DE LESIÓN Y/O REPARACIÓN DE BOLSA DE MARCAPASOS" style="font-weight: bold;"/>
			<h:outputLabel value="I-INFORMACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="Tras el implante de su dispositivo de estimulación cardíaca (marcapasos, desfibrilador (DAI), resincronizador, ) ha estado acudiendo a revisiones a nuestra consulta externa y hemos observado que usted presenta una lesión cutánea sobre la cicatriz o bolsa de implante. Estas lesiones frecuentemente son producidas por presión mantenida del aparato sobre la piel y en ocasiones son motivadas por infecciones locales crónicas no sintomáticas. En su caso consideramos que la mejor solución para evitar la progresión del problema es extirpar la zona afectada y repararla si es preciso."/>
			<h:outputLabel value="2-¿Cómo se  realiza?" style="font-weight: bold;"/>
			<h:outputLabel value="El paciente permanecerá acostado y consciente. Se aplica anestesia local en el lugar donde se encuentra la lesión. Según las características del problema se procederá a extirpar la piel y tejidos afectados e incluso a realizar una nueva bolsa donde alojar el dispositivo. Finalmente se cierra la herida con puntos de sutura. Después de la intervención, el paciente deberá permanecer en reposo varias horas y en algunos casos precisará ingreso hospitalario."/>
			<h:outputLabel value="3-¿Qué riesgo tiene?" style="font-weight: bold;"/>
			<h:outputLabel value="Los riesgos inmediatos son escasos y leves (molestias o dolor en la zona intervenida, hematoma,...) y pocas veces son relevantes (hemorragia que precise transfusión). A medio-largo plazo puede ocurrir infección de la herida o de la bolsa donde se localiza el aparato y/o infección en los electrodos produciendo infección grave (endocarditis) que precisaría antibioterapia y extracción de todos los componentes por parte de Cirugía Cardiovascular. Es muy infrecuente que alguna de las partes de su aparato resulte dañado durante la intervención."/>
			<h:outputLabel value="Otros riesgos o complicaciones que podrían  aparecer, dada su situación clínica y sus circunstancias personales son: " />
			<h:inputTextarea cols="225" rows="3" value="#{controlPacientes.consexp.riesgos }"/>
			<h:outputLabel value="En su actual estado clínico, los beneficios derivados de la realización de este procedimiento superan los posibles riesgos. Por este motivo se le indica la conveniencia de que le sea practicado. Si aparecieran complicaciones, el personal médico y de enfermería que le atiende está capacitado y dispone de los medios para tratar de resolverlas."/>
			<h:outputLabel value="5-¿Hay otras alternativas?" style="font-weight: bold;"/>
			<h:outputLabel value="Este tratamiento está indicado de modo preferente en su caso. Antes de firmar este formulario, no dude en pedir cualquier aclaración adicional que desee."/>			 
			<h:outputLabel value="II-DECLARACIONES Y FIRMAS" style="font-weight: bold;"/>
			<h:outputLabel value="1-PACIENTE" style="font-weight: bold;"/>
			<h:outputLabel id="doctorEXP1" value="El médico Dr./Dra. #{controlPacientes.consexp.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve la extirpación de la lesión y/o reparación de la bolsa de marcapasos. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorEXP2" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consexp.doctor } y el personal ayudante que precise, realicen la extirpación de la lesión y/o reparación de la bolsa de marcapasos. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel value="2-REPRESENTANTE LEGAL*" style="font-weight: bold;"/>
			<h:outputLabel id="doctorEXP3" value="El médico Dr./Dra. #{controlPacientes.consexp.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve la extirpación de la lesión y/o reparación de la bolsa de marcapasos. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorEXP4" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consexp.doctor } y el personal ayudante que precise, realicen la extirpación de la lesión y/o reparación de la bolsa de marcapasos. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel id="repLegalconsexp" value="Firmado: #{controlPacientes.consexp.repleg_nombre } #{controlPacientes.consexp.repleg_ap1 } #{controlPacientes.consexp.repleg_ap2 } - DNI:  #{controlPacientes.consexp.repleg_dni }"/>
			<h:outputLabel value="3-MÉDICO" style="font-weight: bold;"/>
			<h:outputLabel id="doctorEXP5" value="Dr./Dra. #{controlPacientes.consexp.doctor }. He informado a este paciente y/o a su representante legal, del propósito y naturaleza del procedimiento extirpación de la lesión y/o reparación de la bolsa de marcapasos, así como de sus riesgos y alternativas." />
			<h:outputLabel id="doctorEXP6" value="Firmado: #{controlPacientes.consexp.doctor } - Número colegiado:  #{controlPacientes.consexp.numcolegiado }"/>
			<h:outputLabel value="III-DATOS DE IDENTIFICACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="Paciente: #{controlPacientes.pacienteSelect.nombreCompleto }. Edad: #{controlPacientes.pacienteSelect.edad } años. Número Historia Clínica: #{controlPacientes.pacienteSelect.nhc }"   />
			<h:outputLabel value="IV-NOTA" style="font-weight: bold;"/>
			<h:outputLabel value="Si usted, ante testigos, no acepta firmar este consentimiento, hágalo constar:" />
			<h:outputLabel value="REVOCO la anterior autorización y rechazo el tratamiento indicado por mis médicos, conociendo las consecuencias que para mi salud o mi vida puede tener esta decisión" style="font-style: italic;"/>		
		</h:panelGrid>
			
	</h:panelGrid>
	
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid id="panModalConsentimientoMPS" >
		<h:panelGrid columns="6">
			<h:outputLabel value="Dr./Dra." style="font-weight: bold;"/>
			<h:outputLabel value="Num. Colegiado" style="font-weight: bold;"/>			
			<h:outputLabel value="Nombre (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido1 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido2 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="DNI (Rep.Legal)*" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.consmps.doctor }">
					<f:selectItems value="#{controlPacientes.operadores}" />
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorMPS1,doctorMPS2,doctorMPS3,doctorMPS4,doctorMPS5,doctorMPS6"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmps.numcolegiado }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorMPS6"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmps.repleg_nombre }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsMPS"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmps.repleg_ap1 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsMPS"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmps.repleg_ap2 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsMPS"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consmps.repleg_dni }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsMPS"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="* Rellene esta información si procede" style="font-style: italic;"/>
		<hr/>
		<h:panelGrid id="textoConsentimientoMPS">
			<h:outputLabel value="CONSENTIMIENTO PARA IMPLANTACIÓN DE MARCAPASOS CARDÍACO DEFINITIVO" style="font-weight: bold;"/>
			<h:outputLabel value="I-INFORMACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="1-¿Qué es?" style="font-weight: bold;"/>
			<h:outputLabel value="Es una forma de tratamiento para pacientes con determinadas alteraciones del ritmo (lentas y/o rápidas), o de la conducción cardíaca (bloqueos). Consiste en colocar un generador interno de impulsos eléctricos y uno o más cables-electrodos intravenosos e intra-cardíacos mediante una pequeña intervención quirúrgica."/>
			<h:outputLabel value="2-¿Para qué sirve?" style="font-weight: bold;"/>
			<h:outputLabel value="Permite mantener un ritmo adecuado de las pulsaciones del corazón, adaptado a las necesidades específicas de cada paciente." />
			<h:outputLabel value="3-¿Cómo se  realiza?" style="font-weight: bold;"/>
			<h:outputLabel value="El paciente permanecerá acostado y consciente, si es preciso sedado, para que no tenga ansiedad o dolor. Se aplica anestesia local en el lugar escogido (habitualmente bajo la clavícula). Se coloca debajo de la piel de dicha zona un pequeño aparato electrónico (generador de marcapasos) que producirá impulsos eléctricos, y que se conecta, según los casos, a uno o dos cables (electrodos) muy finos y flexibles. Estos se introducen por una  vena y se les hace avanzar hasta el corazón con control radiológico. Una vez comprobado el correcto funcionamiento del marcapasos se cierra la herida de la piel con unos puntos de sutura. Después de la implantación el paciente deberá permanecer en reposo varias horas o días."/>
			<h:outputLabel value="4-¿Qué riesgo tiene?" style="font-weight: bold;"/>
			<h:outputLabel value="Los riesgos son escasos y leves (molestias en la zona de implantación del generador, hematoma, dislocación de cable,...) y pocas veces son relevantes (neumotórax, hemorragia que precise transfusión). Muy raras son otras complicaciones relacionadas con el procedimiento (flebitis, trombosis venosa o intracardiaca, embolia pulmonar, sepsis, perforación cardiaca con taponamiento), si bien alguna de ellas son graves y requieren actuación urgente; el riesgo de muerte es excepcional (1-2 por 1000)."/>
			<h:outputLabel value="Otros riesgos o complicaciones que podrían  aparecer, dada su situación clínica y sus circunstancias personales son: " />
			<h:inputTextarea cols="225" rows="3" value="#{controlPacientes.consmps.riesgos }"/>
			<h:outputLabel value="En su actual estado clínico, los beneficios derivados de la realización de este procedimiento superan los posibles riesgos. Por este motivo se le indica la conveniencia de que le sea practicado. Si aparecieran complicaciones, el personal médico y de enfermería que le atiende está capacitado y dispone de los medios para tratar de resolverlas." />
			<h:outputLabel value="5-¿Hay otras alternativas?" style="font-weight: bold;"/>
			<h:outputLabel value="Este tratamiento está indicado de modo preferente en su caso. Antes de firmar este formulario, no dude en pedir cualquier aclaración adicional que desee."/>			 
			<h:outputLabel value="II-DECLARACIONES Y FIRMAS" style="font-weight: bold;"/>
			<h:outputLabel value="1-PACIENTE" style="font-weight: bold;"/>
			<h:outputLabel id="doctorMPS1" value="El médico Dr./Dra. #{controlPacientes.consmps.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el implante de marcapasos cardíaco definitivo. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorMPS2" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consmps.doctor } y el personal ayudante que precise, realicen el implante de marcapasos cardíaco definitivo. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel value="2-REPRESENTANTE LEGAL*" style="font-weight: bold;"/>
			<h:outputLabel id="doctorMPS3" value="El médico Dr./Dra. #{controlPacientes.consmps.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el implante de marcapasos cardíaco definitivo. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorMPS4" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consmps.doctor } y el personal ayudante que precise, realicen el implante de marcapasos cardíaco definitivo. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel id="repLegalConsMPS" value="Firmado: #{controlPacientes.consmps.repleg_nombre } #{controlPacientes.consmps.repleg_ap1 } #{controlPacientes.consmps.repleg_ap2 } - DNI:  #{controlPacientes.consmps.repleg_dni }"/>
			<h:outputLabel value="3-MÉDICO" style="font-weight: bold;"/>
			<h:outputLabel id="doctorMPS5" value="Dr./Dra. #{controlPacientes.consmps.doctor }. He informado a este paciente y/o a su representante legal, del propósito y naturaleza del procedimiento implante de desfibrilador automático implantable, así como de sus riesgos y alternativas." />
			<h:outputLabel id="doctorMPS6" value="Firmado: #{controlPacientes.consmps.doctor } - Número colegiado:  #{controlPacientes.consmps.numcolegiado }"/>
			<h:outputLabel value="III-DATOS DE IDENTIFICACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="Paciente: #{controlPacientes.pacienteSelect.nombreCompleto }. Edad: #{controlPacientes.pacienteSelect.edad } años. Número Historia Clínica: #{controlPacientes.pacienteSelect.nhc }"   />
			<h:outputLabel value="IV-NOTA" style="font-weight: bold;"/>
			<h:outputLabel value="Si usted, ante testigos, no acepta firmar este consentimiento, hágalo constar:" />
			<h:outputLabel value="REVOCO la anterior autorización y rechazo el tratamiento indicado por mis médicos, conociendo las consecuencias que para mi salud o mi vida puede tener esta decisión" style="font-style: italic;"/>		
		</h:panelGrid>
			
	</h:panelGrid>
	
</ui:composition>
<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid id="panModalConsentimientoDAI" >
		<h:panelGrid columns="6">
			<h:outputLabel value="Dr./Dra." style="font-weight: bold;"/>
			<h:outputLabel value="Num. Colegiado" style="font-weight: bold;"/>			
			<h:outputLabel value="Nombre (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido1 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido2 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="DNI (Rep.Legal)*" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.consdai.doctor }">
					<f:selectItems value="#{controlPacientes.operadores}" />
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorDAI1,doctorDAI2,doctorDAI3,doctorDAI4,doctorDAI5,doctorDAI6"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consdai.numcolegiado }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorDAI6"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consdai.repleg_nombre }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsDAI"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consdai.repleg_ap1 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsDAI"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consdai.repleg_ap2 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsDAI"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.consdai.repleg_dni }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsDAI"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="* Rellene esta información si procede" style="font-style: italic;"/>
		<hr/>
		<h:panelGrid id="textoConsentimientoDAI">
			<h:outputLabel value="CONSENTIMIENTO PARA IMPLANTACIÓN DE DESFIBRILADOR AUTOMÁTICO (DAI)" style="font-weight: bold;"/>
			<h:outputLabel value="I-INFORMACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="1-¿Qué es?" style="font-weight: bold;"/>
			<h:outputLabel value="Es una forma de tratamiento para pacientes con determinadas alteraciones del ritmo cardíaco (arritmias). Consiste en colocar un generador interno de impulsos eléctricos y uno o dos cables-electrodos intravenoso e intracardiaco mediante una pequeña intervención quirúrgica."/>
			<h:outputLabel value="2-¿Para qué sirve?" style="font-weight: bold;"/>
			<h:outputLabel value="Permite devolver al corazón su ritmo regular, suprimiendo la arritmia que tenía y sus consecuencias perjudiciales. Además,  puede mantener un ritmo adecuado de las pulsaciones cardíacas, adaptado a las necesidades específicas del paciente. " />
			<h:outputLabel value="3-¿Cómo se  realiza?" style="font-weight: bold;"/>
			<h:outputLabel value="Se realiza habitualmente con anestesia local y sedación, excepcionalmente con anestesia general, estando el paciente acostado. Se coloca en el lugar elegido, generalmente debajo de la clavícula, un aparato electrónico (desfibrilador automático implantable (DAI)) y se une a uno o dos cables (electrodos) según los casos, muy finos y flexibles. Estos se introducen por una vena y se les hace avanzar hasta el corazón con control radioscópico. En ocasiones se comprueba a continuación el correcto funcionamiento del aparato provocando y haciendo desaparecer ciertas arritmias malignas (taquicardia o fibrilación ventricular), semejantes a las que padece el enfermo. Finalmente se cierra la herida de la piel con unos puntos de sutura.  Es excepcional que la intervención se realice mediante apertura de la caja torácica. La duración del procedimiento es variable, debiendo permanecer el paciente en reposo varias horas después."/>
			<h:outputLabel value="4-¿Qué riesgo tiene?" style="font-weight: bold;"/>
			<h:outputLabel value="Es habitual que existan palpitaciones durante el procedimiento, ya que son provocadas por los catéteres. Previamente se le ha advertido que, para normalizar el ritmo cardíaco, el desfibrilador produce descargas eléctricas internas. Algunas de ellas, dependiendo de su potencia, pueden producir dolor instantáneo en el pecho, a veces intenso pero tolerable. Si esto le angustia, se le proporcionará medicación para calmar la ansiedad. La mayoría de las veces sólo habrá una leve molestia en la zona de implantación del generador, o la aparición de un hematoma que se reabsorberá casi siempre espontáneamente. Pocas veces ocurren otros hechos más relevantes (neumotórax, dislocación de cable o hemorragia que precise transfusión). Muy raras son otras complicaciones relacionadas con el procedimiento (flebitis, trombosis venosa o intra-cardíaca, embolia pulmonar, sepsis, perforación cardíaca con taponamiento), si bien alguna de ellas son graves y requieren actuación urgente; el riesgo de muerte está en torno al 1 por 100."/>
			<h:outputLabel value="Otros riesgos o complicaciones que podrían  aparecer, dada su situación clínica y sus circunstancias personales son: " />
			<h:inputTextarea cols="225" rows="3" value="#{controlPacientes.consdai.riesgos }"/>
			<h:outputLabel value="5-¿Hay otras alternativas?" style="font-weight: bold;"/>
			<h:outputLabel value="Este tratamiento está indicado de modo preferente en su caso. Antes de firmar este formulario, no dude en pedir cualquier aclaración adicional que desee."/>			 
			<h:outputLabel value="II-DECLARACIONES Y FIRMAS" style="font-weight: bold;"/>
			<h:outputLabel value="1-PACIENTE" style="font-weight: bold;"/>
			<h:outputLabel id="doctorDAI1" value="El médico Dr./Dra. #{controlPacientes.consdai.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el implante de desfibrilador automático implantable (DAI). También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorDAI2" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consdai.doctor } y el personal ayudante que precise, realicen el implante de DAI. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel value="2-REPRESENTANTE LEGAL*" style="font-weight: bold;"/>
			<h:outputLabel id="doctorDAI3" value="El médico Dr./Dra. #{controlPacientes.consdai.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el implante de desfibrilador automático implantable (DAI). También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorDAI4" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consdai.doctor } y el personal ayudante que precise, realicen el implante de DAI. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel id="repLegalConsDAI" value="Firmado: #{controlPacientes.consdai.repleg_nombre } #{controlPacientes.consdai.repleg_ap1 } #{controlPacientes.consdai.repleg_ap2 } - DNI:  #{controlPacientes.consdai.repleg_dni }"/>
			<h:outputLabel value="3-MÉDICO" style="font-weight: bold;"/>
			<h:outputLabel id="doctorDAI5" value="Dr./Dra. #{controlPacientes.consdai.doctor }. He informado a este paciente y/o a su representante legal, del propósito y naturaleza del procedimiento implante de desfibrilador automático implantable, así como de sus riesgos y alternativas." />
			<h:outputLabel id="doctorDAI6" value="Firmado: #{controlPacientes.consdai.doctor } - Número colegiado:  #{controlPacientes.consdai.numcolegiado }"/>
			<h:outputLabel value="III-DATOS DE IDENTIFICACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="Paciente: #{controlPacientes.pacienteSelect.nombreCompleto }. Edad: #{controlPacientes.pacienteSelect.edad } años. Número Historia Clínica: #{controlPacientes.pacienteSelect.nhc }"   />
			<h:outputLabel value="IV-NOTA" style="font-weight: bold;"/>
			<h:outputLabel value="Si usted, ante testigos, no acepta firmar este consentimiento, hágalo constar:" />
			<h:outputLabel value="REVOCO la anterior autorización y rechazo el tratamiento indicado por mis médicos, conociendo las consecuencias que para mi salud o mi vida puede tener esta decisión" style="font-style: italic;"/>		
		</h:panelGrid>
			
	</h:panelGrid>
	
</ui:composition>
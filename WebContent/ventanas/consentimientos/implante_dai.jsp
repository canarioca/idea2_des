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
		<h:outputLabel value="* Rellene esta informaci�n si procede" style="font-style: italic;"/>
		<hr/>
		<h:panelGrid id="textoConsentimientoDAI">
			<h:outputLabel value="CONSENTIMIENTO PARA IMPLANTACI�N DE DESFIBRILADOR AUTOM�TICO (DAI)" style="font-weight: bold;"/>
			<h:outputLabel value="I-INFORMACI�N" style="font-weight: bold;"/>
			<h:outputLabel value="1-�Qu� es?" style="font-weight: bold;"/>
			<h:outputLabel value="Es una forma de tratamiento para pacientes con determinadas alteraciones del ritmo card�aco (arritmias). Consiste en colocar un generador interno de impulsos el�ctricos y uno o dos cables-electrodos intravenoso e intracardiaco mediante una peque�a intervenci�n quir�rgica."/>
			<h:outputLabel value="2-�Para qu� sirve?" style="font-weight: bold;"/>
			<h:outputLabel value="Permite devolver al coraz�n su ritmo regular, suprimiendo la arritmia que ten�a y sus consecuencias perjudiciales. Adem�s,  puede mantener un ritmo adecuado de las pulsaciones card�acas, adaptado a las necesidades espec�ficas del paciente. " />
			<h:outputLabel value="3-�C�mo se  realiza?" style="font-weight: bold;"/>
			<h:outputLabel value="Se realiza habitualmente con anestesia local y sedaci�n, excepcionalmente con anestesia general, estando el paciente acostado. Se coloca en el lugar elegido, generalmente debajo de la clav�cula, un aparato electr�nico (desfibrilador autom�tico implantable (DAI)) y se une a uno o dos cables (electrodos) seg�n los casos, muy finos y flexibles. Estos se introducen por una vena y se les hace avanzar hasta el coraz�n con control radiosc�pico. En ocasiones se comprueba a continuaci�n el correcto funcionamiento del aparato provocando y haciendo desaparecer ciertas arritmias malignas (taquicardia o fibrilaci�n ventricular), semejantes a las que padece el enfermo. Finalmente se cierra la herida de la piel con unos puntos de sutura.  Es excepcional que la intervenci�n se realice mediante apertura de la caja tor�cica. La duraci�n del procedimiento es variable, debiendo permanecer el paciente en reposo varias horas despu�s."/>
			<h:outputLabel value="4-�Qu� riesgo tiene?" style="font-weight: bold;"/>
			<h:outputLabel value="Es habitual que existan palpitaciones durante el procedimiento, ya que son provocadas por los cat�teres. Previamente se le ha advertido que, para normalizar el ritmo card�aco, el desfibrilador produce descargas el�ctricas internas. Algunas de ellas, dependiendo de su potencia, pueden producir dolor instant�neo en el pecho, a veces intenso pero tolerable. Si esto le angustia, se le proporcionar� medicaci�n para calmar la ansiedad. La mayor�a de las veces s�lo habr� una leve molestia en la zona de implantaci�n del generador, o la aparici�n de un hematoma que se reabsorber� casi siempre espont�neamente. Pocas veces ocurren otros hechos m�s relevantes (neumot�rax, dislocaci�n de cable o hemorragia que precise transfusi�n). Muy raras son otras complicaciones relacionadas con el procedimiento (flebitis, trombosis venosa o intra-card�aca, embolia pulmonar, sepsis, perforaci�n card�aca con taponamiento), si bien alguna de ellas son graves y requieren actuaci�n urgente; el riesgo de muerte est� en torno al 1 por 100."/>
			<h:outputLabel value="Otros riesgos o complicaciones que podr�an  aparecer, dada su situaci�n cl�nica y sus circunstancias personales son: " />
			<h:inputTextarea cols="225" rows="3" value="#{controlPacientes.consdai.riesgos }"/>
			<h:outputLabel value="5-�Hay otras alternativas?" style="font-weight: bold;"/>
			<h:outputLabel value="Este tratamiento est� indicado de modo preferente en su caso. Antes de firmar este formulario, no dude en pedir cualquier aclaraci�n adicional que desee."/>			 
			<h:outputLabel value="II-DECLARACIONES Y FIRMAS" style="font-weight: bold;"/>
			<h:outputLabel value="1-PACIENTE" style="font-weight: bold;"/>
			<h:outputLabel id="doctorDAI1" value="El m�dico Dr./Dra. #{controlPacientes.consdai.doctor } me ha explicado de forma satisfactoria qu� es, c�mo se realiza y para qu� sirve el implante de desfibrilador autom�tico implantable (DAI). Tambi�n me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento m�s adecuado para mi situaci�n cl�nica actual."/>				
			<h:outputLabel id="doctorDAI2" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consdai.doctor } y el personal ayudante que precise, realicen el implante de DAI. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel value="2-REPRESENTANTE LEGAL*" style="font-weight: bold;"/>
			<h:outputLabel id="doctorDAI3" value="El m�dico Dr./Dra. #{controlPacientes.consdai.doctor } me ha explicado de forma satisfactoria qu� es, c�mo se realiza y para qu� sirve el implante de desfibrilador autom�tico implantable (DAI). Tambi�n me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento m�s adecuado para mi situaci�n cl�nica actual."/>				
			<h:outputLabel id="doctorDAI4" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.consdai.doctor } y el personal ayudante que precise, realicen el implante de DAI. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel id="repLegalConsDAI" value="Firmado: #{controlPacientes.consdai.repleg_nombre } #{controlPacientes.consdai.repleg_ap1 } #{controlPacientes.consdai.repleg_ap2 } - DNI:  #{controlPacientes.consdai.repleg_dni }"/>
			<h:outputLabel value="3-M�DICO" style="font-weight: bold;"/>
			<h:outputLabel id="doctorDAI5" value="Dr./Dra. #{controlPacientes.consdai.doctor }. He informado a este paciente y/o a su representante legal, del prop�sito y naturaleza del procedimiento implante de desfibrilador autom�tico implantable, as� como de sus riesgos y alternativas." />
			<h:outputLabel id="doctorDAI6" value="Firmado: #{controlPacientes.consdai.doctor } - N�mero colegiado:  #{controlPacientes.consdai.numcolegiado }"/>
			<h:outputLabel value="III-DATOS DE IDENTIFICACI�N" style="font-weight: bold;"/>
			<h:outputLabel value="Paciente: #{controlPacientes.pacienteSelect.nombreCompleto }. Edad: #{controlPacientes.pacienteSelect.edad } a�os. N�mero Historia Cl�nica: #{controlPacientes.pacienteSelect.nhc }"   />
			<h:outputLabel value="IV-NOTA" style="font-weight: bold;"/>
			<h:outputLabel value="Si usted, ante testigos, no acepta firmar este consentimiento, h�galo constar:" />
			<h:outputLabel value="REVOCO la anterior autorizaci�n y rechazo el tratamiento indicado por mis m�dicos, conociendo las consecuencias que para mi salud o mi vida puede tener esta decisi�n" style="font-style: italic;"/>		
		</h:panelGrid>
			
	</h:panelGrid>
	
</ui:composition>
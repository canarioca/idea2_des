<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid id="panModalConsentimientoHOLTER" >
		<h:panelGrid columns="6">
			<h:outputLabel value="Dr./Dra." style="font-weight: bold;"/>
			<h:outputLabel value="Num. Colegiado" style="font-weight: bold;"/>			
			<h:outputLabel value="Nombre (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido1 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="Apellido2 (Rep.Legal)*" style="font-weight: bold;"/>
			<h:outputLabel value="DNI (Rep.Legal)*" style="font-weight: bold;"/>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:selectOneMenu value="#{controlPacientes.conshol.doctor }">
					<f:selectItems value="#{controlPacientes.operadores}" />
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorHOLTER1,doctorHOLTER2,doctorHOLTER3,doctorHOLTER4,doctorHOLTER5,doctorHOLTER6"/>				
				</h:selectOneMenu>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.conshol.numcolegiado }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="doctorHOLTER6"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.conshol.repleg_nombre }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsHOLTER"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.conshol.repleg_ap1 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsHOLTER"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.conshol.repleg_ap2 }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsHOLTER"/>
				</h:inputText>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;">
				<h:inputText value="#{controlPacientes.conshol.repleg_dni }">
					<a4j:support event="onchange" ajaxSingle="true" reRender="repLegalConsHOLTER"/>
				</h:inputText>
			</h:panelGrid>
		</h:panelGrid>
		<h:outputLabel value="* Rellene esta información si procede" style="font-style: italic;"/>
		<hr/>
		<h:panelGrid id="textoConsentimientoHOLTER">
			<h:outputLabel value="CONSENTIMIENTO PARA IMPLANTACIÓN DE HOLTER SUBCUTANEO" style="font-weight: bold;"/>
			<h:outputLabel value="I-INFORMACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="1-¿Qué es? ¿Para qué sirve?" style="font-weight: bold;"/>
			<h:outputLabel value="La implantación de un Holter subcutáneo se realiza para profundizar en el estudio de las posibles causas de sus síntomas. Cuando un paciente presenta mareos, pérdidas de conciencia (síncopes) o sensación de palpitaciones y no se ha logrado aclarar por otros sistemas la trascendencia de los mismos o si están causados por un trastorno del ritmo del corazón, este aparato puede ofrecernos una información definitiva."/>
			<h:outputLabel value="El Holter tiene una pequeña batería que lee permite recoger la información del ritmo del corazón durante más de un año. Desde el exterior podemos programar el aparato indicándole qué alteraciones del ritmo del corazón van a quedar grabadas para que posteriormente las podamos revisar en la consulta. Fijaremos una frecuencia de latidos por encima de la cual registrará en su memoria el electrocardiograma y otra cifra por debajo de la cual realizará una función similar, todo ello de forma automática. Además el paciente contará con un mando pequeño y extremadamente simple (solo hay que ponerlo sobre la zona donde lleva el aparato y apretar su único botón) mediante el cual puede registrar su electrocardiograma al apreciar las molestias."/>
			<h:outputLabel value="3-¿Cómo se  realiza?" style="font-weight: bold;"/>
			<h:outputLabel value="El paciente permanecerá acostado y consciente. Se aplica anestesia local en el lugar escogido (paraesternal izquierdo entre 2ª y  4ª costilla). Se coloca debajo de la piel de dicha zona (subcutánea) un pequeño aparato electrónico (holter). Se cierra la herida de la piel con unos puntos de sutura."/>
			<h:outputLabel value="4-¿Qué riesgo tiene?" style="font-weight: bold;"/>
			<h:outputLabel value="Los riesgos son escasos y leves (molestias en la zona de implantación del generador, hematoma). Otra complicación podría ser la infección local, que quedaría resuelta extrayendo el dispositivo, tratando la infección y colocando de nuevo el Holter en un lugar próximo. Esta complicación no se ha presentado nunca en nuestro centro."/>
			<h:outputLabel value="Otros riesgos o complicaciones que podrían  aparecer, dada su situación clínica y sus circunstancias personales son: " />
			<h:inputTextarea cols="225" rows="3" value="#{controlPacientes.conshol.riesgos }"/>
			<h:outputLabel value="En su actual estado clínico, los beneficios derivados de la realización de este procedimiento superan los posibles riesgos. Si aparecieran complicaciones, el personal médico y de enfermería que le atiende está capacitado y dispone de los medios para tratar de resolverlas."/>
			<h:outputLabel value="5-¿Hay otras alternativas?" style="font-weight: bold;"/>
			<h:outputLabel value="Este tratamiento está indicado de modo preferente en su caso. Antes de firmar este formulario, no dude en pedir cualquier aclaración adicional que desee."/>			 
			<h:outputLabel value="II-DECLARACIONES Y FIRMAS" style="font-weight: bold;"/>
			<h:outputLabel value="1-PACIENTE" style="font-weight: bold;"/>
			<h:outputLabel id="doctorHOLTER1" value="El médico Dr./Dra. #{controlPacientes.conshol.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el implante de holter subcutáneo. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorHOLTER2" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.conshol.doctor } y el personal ayudante que precise, realicen el implante de holter subcutáneo. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel value="2-REPRESENTANTE LEGAL*" style="font-weight: bold;"/>
			<h:outputLabel id="doctorHOLTER3" value="El médico Dr./Dra. #{controlPacientes.conshol.doctor } me ha explicado de forma satisfactoria qué es, cómo se realiza y para qué sirve el implante de holter subcutáneo. También me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento más adecuado para mi situación clínica actual."/>				
			<h:outputLabel id="doctorHOLTER4" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.conshol.doctor } y el personal ayudante que precise, realicen el implante de holter subcutáneo. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel id="repLegalConsHOLTER" value="Firmado: #{controlPacientes.conshol.repleg_nombre } #{controlPacientes.conshol.repleg_ap1 } #{controlPacientes.conshol.repleg_ap2 } - DNI:  #{controlPacientes.conshol.repleg_dni }"/>
			<h:outputLabel value="3-MÉDICO" style="font-weight: bold;"/>
			<h:outputLabel id="doctorHOLTER5" value="Dr./Dra. #{controlPacientes.conshol.doctor }. He informado a este paciente y/o a su representante legal, del propósito y naturaleza del procedimiento implante de holter subcutáneo, así como de sus riesgos y alternativas." />
			<h:outputLabel id="doctorHOLTER6" value="Firmado: #{controlPacientes.conshol.doctor } - Número colegiado:  #{controlPacientes.conshol.numcolegiado }"/>
			<h:outputLabel value="III-DATOS DE IDENTIFICACIÓN" style="font-weight: bold;"/>
			<h:outputLabel value="Paciente: #{controlPacientes.pacienteSelect.nombreCompleto }. Edad: #{controlPacientes.pacienteSelect.edad } años. Número Historia Clínica: #{controlPacientes.pacienteSelect.nhc }"   />
			<h:outputLabel value="IV-NOTA" style="font-weight: bold;"/>
			<h:outputLabel value="Si usted, ante testigos, no acepta firmar este consentimiento, hágalo constar:" />
			<h:outputLabel value="REVOCO la anterior autorización y rechazo el tratamiento indicado por mis médicos, conociendo las consecuencias que para mi salud o mi vida puede tener esta decisión" style="font-style: italic;"/>		
		</h:panelGrid>
			
	</h:panelGrid>
	
</ui:composition>
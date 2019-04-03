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
		<h:outputLabel value="* Rellene esta informaci�n si procede" style="font-style: italic;"/>
		<hr/>
		<h:panelGrid id="textoConsentimientoHOLTER">
			<h:outputLabel value="CONSENTIMIENTO PARA IMPLANTACI�N DE HOLTER SUBCUTANEO" style="font-weight: bold;"/>
			<h:outputLabel value="I-INFORMACI�N" style="font-weight: bold;"/>
			<h:outputLabel value="1-�Qu� es? �Para qu� sirve?" style="font-weight: bold;"/>
			<h:outputLabel value="La implantaci�n de un Holter subcut�neo se realiza para profundizar en el estudio de las posibles causas de sus s�ntomas. Cuando un paciente presenta mareos, p�rdidas de conciencia (s�ncopes) o sensaci�n de palpitaciones y no se ha logrado aclarar por otros sistemas la trascendencia de los mismos o si est�n causados por un trastorno del ritmo del coraz�n, este aparato puede ofrecernos una informaci�n definitiva."/>
			<h:outputLabel value="El Holter tiene una peque�a bater�a que lee permite recoger la informaci�n del ritmo del coraz�n durante m�s de un a�o. Desde el exterior podemos programar el aparato indic�ndole qu� alteraciones del ritmo del coraz�n van a quedar grabadas para que posteriormente las podamos revisar en la consulta. Fijaremos una frecuencia de latidos por encima de la cual registrar� en su memoria el electrocardiograma y otra cifra por debajo de la cual realizar� una funci�n similar, todo ello de forma autom�tica. Adem�s el paciente contar� con un mando peque�o y extremadamente simple (solo hay que ponerlo sobre la zona donde lleva el aparato y apretar su �nico bot�n) mediante el cual puede registrar su electrocardiograma al apreciar las molestias."/>
			<h:outputLabel value="3-�C�mo se  realiza?" style="font-weight: bold;"/>
			<h:outputLabel value="El paciente permanecer� acostado y consciente. Se aplica anestesia local en el lugar escogido (paraesternal izquierdo entre 2� y  4� costilla). Se coloca debajo de la piel de dicha zona (subcut�nea) un peque�o aparato electr�nico (holter). Se cierra la herida de la piel con unos puntos de sutura."/>
			<h:outputLabel value="4-�Qu� riesgo tiene?" style="font-weight: bold;"/>
			<h:outputLabel value="Los riesgos son escasos y leves (molestias en la zona de implantaci�n del generador, hematoma). Otra complicaci�n podr�a ser la infecci�n local, que quedar�a resuelta extrayendo el dispositivo, tratando la infecci�n y colocando de nuevo el Holter en un lugar pr�ximo. Esta complicaci�n no se ha presentado nunca en nuestro centro."/>
			<h:outputLabel value="Otros riesgos o complicaciones que podr�an  aparecer, dada su situaci�n cl�nica y sus circunstancias personales son: " />
			<h:inputTextarea cols="225" rows="3" value="#{controlPacientes.conshol.riesgos }"/>
			<h:outputLabel value="En su actual estado cl�nico, los beneficios derivados de la realizaci�n de este procedimiento superan los posibles riesgos. Si aparecieran complicaciones, el personal m�dico y de enfermer�a que le atiende est� capacitado y dispone de los medios para tratar de resolverlas."/>
			<h:outputLabel value="5-�Hay otras alternativas?" style="font-weight: bold;"/>
			<h:outputLabel value="Este tratamiento est� indicado de modo preferente en su caso. Antes de firmar este formulario, no dude en pedir cualquier aclaraci�n adicional que desee."/>			 
			<h:outputLabel value="II-DECLARACIONES Y FIRMAS" style="font-weight: bold;"/>
			<h:outputLabel value="1-PACIENTE" style="font-weight: bold;"/>
			<h:outputLabel id="doctorHOLTER1" value="El m�dico Dr./Dra. #{controlPacientes.conshol.doctor } me ha explicado de forma satisfactoria qu� es, c�mo se realiza y para qu� sirve el implante de holter subcut�neo. Tambi�n me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento m�s adecuado para mi situaci�n cl�nica actual."/>				
			<h:outputLabel id="doctorHOLTER2" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.conshol.doctor } y el personal ayudante que precise, realicen el implante de holter subcut�neo. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel value="2-REPRESENTANTE LEGAL*" style="font-weight: bold;"/>
			<h:outputLabel id="doctorHOLTER3" value="El m�dico Dr./Dra. #{controlPacientes.conshol.doctor } me ha explicado de forma satisfactoria qu� es, c�mo se realiza y para qu� sirve el implante de holter subcut�neo. Tambi�n me ha explicado los riesgos existentes, las posibles molestias o complicaciones, y que es el procedimiento m�s adecuado para mi situaci�n cl�nica actual."/>				
			<h:outputLabel id="doctorHOLTER4" value="He comprendido perfectamente todo lo anterior y doy mi consentimiento para que el Dr./Dra. #{controlPacientes.conshol.doctor } y el personal ayudante que precise, realicen el implante de holter subcut�neo. Puedo retirar este consentimiento cuando lo desee." />
			<h:outputLabel id="repLegalConsHOLTER" value="Firmado: #{controlPacientes.conshol.repleg_nombre } #{controlPacientes.conshol.repleg_ap1 } #{controlPacientes.conshol.repleg_ap2 } - DNI:  #{controlPacientes.conshol.repleg_dni }"/>
			<h:outputLabel value="3-M�DICO" style="font-weight: bold;"/>
			<h:outputLabel id="doctorHOLTER5" value="Dr./Dra. #{controlPacientes.conshol.doctor }. He informado a este paciente y/o a su representante legal, del prop�sito y naturaleza del procedimiento implante de holter subcut�neo, as� como de sus riesgos y alternativas." />
			<h:outputLabel id="doctorHOLTER6" value="Firmado: #{controlPacientes.conshol.doctor } - N�mero colegiado:  #{controlPacientes.conshol.numcolegiado }"/>
			<h:outputLabel value="III-DATOS DE IDENTIFICACI�N" style="font-weight: bold;"/>
			<h:outputLabel value="Paciente: #{controlPacientes.pacienteSelect.nombreCompleto }. Edad: #{controlPacientes.pacienteSelect.edad } a�os. N�mero Historia Cl�nica: #{controlPacientes.pacienteSelect.nhc }"   />
			<h:outputLabel value="IV-NOTA" style="font-weight: bold;"/>
			<h:outputLabel value="Si usted, ante testigos, no acepta firmar este consentimiento, h�galo constar:" />
			<h:outputLabel value="REVOCO la anterior autorizaci�n y rechazo el tratamiento indicado por mis m�dicos, conociendo las consecuencias que para mi salud o mi vida puede tener esta decisi�n" style="font-style: italic;"/>		
		</h:panelGrid>
			
	</h:panelGrid>
	
</ui:composition>
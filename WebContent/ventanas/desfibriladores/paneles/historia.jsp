<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid width="100%">
		<h:outputLabel value="A. Cardiopatía" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellspacing="0">
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:selectBooleanCheckbox
					value="#{controlDesfibriladores.desf.isquemicab }" />
				<h:outputLabel value="Isquémica" />
			</h:panelGrid>
			<h:panelGrid columns="5" cellpadding="0" cellspacing="0" width="60%"
				columnClasses="alignMiddle,alignMiddle,alignMiddle,alignMiddle,alignMiddle">
				<rich:spacer width="15px" />
				<h:outputLabel value="Años de evolución:" />
				<h:inputText size="3" maxlength="3" value="#{controlDesfibriladores.desf.anosevo }" />
				<h:outputLabel value="" />
				<h:outputLabel value="" />
				<rich:spacer width="15px" />
				<h:outputLabel value="Revascularización previa"
					style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.revascprevia }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
				<h:outputLabel value="" />
				<h:outputLabel value="" />
				<rich:spacer width="15px" />
				<h:outputLabel value="Infarto previo" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.infartoprevio }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
				<h:outputLabel value="Año" />
				<h:inputText size="4" maxlength="4"
					value="#{controlDesfibriladores.desf.infartoprevioano }" />
			</h:panelGrid>

			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:selectBooleanCheckbox
					value="#{controlDesfibriladores.desf.dilatnoisquemb }" />
				<h:outputLabel value="Dilatada no isquémica" />
			</h:panelGrid>
			<h:panelGrid columns="5" cellpadding="0" cellspacing="0" width="50%"
				columnClasses="alignMiddle,alignMiddle,alignMiddle,alignMiddle,alignMiddle">
				<rich:spacer width="15px" />
				<h:selectBooleanCheckbox
					value="#{controlDesfibriladores.desf.hipertroficab }" />
				<h:outputLabel value="Hipertrófica" />
				<h:selectBooleanCheckbox
					value="#{controlDesfibriladores.desf.davdb }" />
				<h:outputLabel value="DAVD" />
			</h:panelGrid>

			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.valvular }">
					<f:selectItem itemLabel="Valvular" itemValue="1" />
					<f:selectItem itemLabel="Congénita" itemValue="2" />
					<f:selectItem itemLabel="Ninguna" itemValue="3" />
					<f:selectItem itemLabel="Otra" itemValue="4" />
				</h:selectOneRadio>
				<h:inputText value="#{controlDesfibriladores.desf.otracardiostr }" />
			</h:panelGrid>
			<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.brugada }">
					<f:selectItem itemLabel="Brugada" itemValue="1" />
					<f:selectItem itemLabel="QT largo" itemValue="2" />
					<f:selectItem itemLabel="QT corto" itemValue="3" />
					<f:selectItem itemLabel="TV catecolaminérgica" itemValue="4" />
					<f:selectItem itemLabel="Otra" itemValue="5" />
				</h:selectOneRadio>
				<h:inputText value="#{controlDesfibriladores.desf.otracardio2str }" />
			</h:panelGrid>
		</h:panelGrid>

		<rich:spacer height="3" />

		<h:outputLabel value="B. Fracción de eyección"
			style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%">
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.fraccion }">
				<f:selectItem itemLabel="&gt;50%" itemValue="1" />
				<f:selectItem itemLabel="41-50%" itemValue="2" />
				<f:selectItem itemLabel="36-40%" itemValue="3" />
				<f:selectItem itemLabel="31-35%" itemValue="4" />
				<f:selectItem itemLabel="&lt;=30%" itemValue="5" />
			</h:selectOneRadio>
		</h:panelGrid>

		<rich:spacer height="3" />

		<h:outputLabel value="C. IC" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellspacing="0">
			<h:selectOneRadio layout="lineDirection"
				value="#{controlDesfibriladores.desf.ic }">
				<f:selectItem itemLabel="No" itemValue="1" />
				<f:selectItem itemLabel="Si" itemValue="2" />
			</h:selectOneRadio>
			<h:panelGrid columns="3">
				<rich:spacer width="15px" />
				<h:outputLabel value="Clase funcional" style="font-style: oblique;" />
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.clasefuncional }">
					<f:selectItem itemLabel="Nyha I" itemValue="1" />
					<f:selectItem itemLabel="Nyha II" itemValue="2" />
					<f:selectItem itemLabel="Nyha III" itemValue="3" />
					<f:selectItem itemLabel="Nyha IV" itemValue="4" />
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>

		<rich:spacer height="3" />

		<h:outputLabel value="D. Enfermedad de Conducción"
			style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellpadding="0">
			<h:panelGrid columns="6" width="100%">
				<h:panelGrid cellpadding="0" columns="2">
					<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.enfconduccion1 }"/>
					<h:outputLabel value="No"/>
				</h:panelGrid>
				<h:panelGrid cellpadding="0" columns="2">
					<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.enfconduccion2 }"/>
					<h:outputLabel value="ENS"/>
				</h:panelGrid>
				<h:panelGrid cellpadding="0" columns="2">
					<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.enfconduccion3 }"/>
					<h:outputLabel value="BAV"/>
				</h:panelGrid>
				<h:panelGrid cellpadding="0" columns="2">
					<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.enfconduccion4 }"/>
					<h:outputLabel value="BRD"/>
				</h:panelGrid>
				<h:panelGrid cellpadding="0" columns="2">
					<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.enfconduccion5 }"/>
					<h:outputLabel value="BRI"/>
				</h:panelGrid>
				<h:panelGrid cellpadding="0" columns="3">
					<h:selectBooleanCheckbox value="#{controlDesfibriladores.desf.enfconduccion6 }"/>
					<h:outputLabel value="Otro"/>
					<h:inputText size="20" value="#{controlDesfibriladores.desf.enfconduccionstr }" />
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>

		<rich:spacer height="3" />

		<h:outputLabel value="E. Ritmo Basal" style="font-weight: bold;" />
		<h:panelGrid style="border-top: solid 1px;border-color: black;"
			width="60%" cellpadding="0">
			<h:panelGrid cellpadding="0" columns="2">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.ritmobasal }">
					<f:selectItem itemLabel="FA" itemValue="1" />
					<f:selectItem itemLabel="Sinusal" itemValue="2" />
					<f:selectItem itemLabel="Marcapasos" itemValue="3" />
					<f:selectItem itemLabel="Otro" itemValue="4" />
				</h:selectOneRadio>
				<h:inputText size="20"
					value="#{controlDesfibriladores.desf.ritmobasalstr }" />
			</h:panelGrid>
		</h:panelGrid>

		<rich:spacer height="3" />

		<h:panelGrid columns="2" cellpadding="0" cellspacing="0" width="70%">
			<h:outputLabel value="F. Antecedentes de insuficiencia renal" style="font-weight: bold;" />
			<h:outputLabel value="G. Antecedentes de FA" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="60%">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.antecinsrenal }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="60%">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.antecfa }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
			
			<rich:spacer height="3" />
			<rich:spacer height="3" />
			
			<h:outputLabel value="H. Diabetes" style="font-weight: bold;" />
			<h:outputLabel value="I. Hipertensión" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="60%">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.diabetes }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="60%">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.hipertension }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
			
			<rich:spacer height="3" />
			<rich:spacer height="3" />
			
			<h:outputLabel value="J. Antece. familiares de Muerte súbita" style="font-weight: bold;" />
			<h:outputLabel value="K. Anchura QRS (ms)" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="60%">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.antecmuertesubita }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="60%">
				<h:inputText size="10" value="#{controlDesfibriladores.desf.anchuraqrs }"/>
			</h:panelGrid>
			
			<rich:spacer height="3" />
			<rich:spacer height="3" />
			
			<h:outputLabel value="L. Fumador" style="font-weight: bold;" />
			<h:outputLabel value="M. Hipercolesterolemia" style="font-weight: bold;" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="60%">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.fumador }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="60%">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.hipercoles }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
			
			<rich:spacer height="3" />
			<rich:spacer height="3" />
			
			<h:outputLabel value="N. ACV" style="font-weight: bold;" />
			<h:outputLabel value="" />
			<h:panelGrid style="border-top: solid 1px;border-color: black;"
				width="60%">
				<h:selectOneRadio layout="lineDirection"
					value="#{controlDesfibriladores.desf.acv }">
					<f:selectItem itemLabel="No" itemValue="1" />
					<f:selectItem itemLabel="Si" itemValue="2" />
				</h:selectOneRadio>
			</h:panelGrid>
		</h:panelGrid>
	</h:panelGrid>
</ui:composition>
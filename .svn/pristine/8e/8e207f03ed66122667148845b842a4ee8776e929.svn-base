<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<h:panelGrid  id="panModalAbordaje" >
		<h:panelGrid columns="6" rendered="#{controlImplantes.tipogen ne 6 }">
			<h:panelGrid columns="1" id="abordajeCamara">
				<h:outputText value="#{ms.imp_dispositivos_ele_camara }"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.camara}">
						<f:selectItems value="#{controlImplantes.camara}"/>
						<a4j:support event="onchange" reRender="abordajeViaAcceso,abordajeLateralidad,abordajeProcedimiento,panZonas,panPorcion,panModalAbordaje" 
							ajaxSingle="true" actionListener="#{controlImplantes.cambiaCamaraElectrodo }"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="1" id="abordajeViaAcceso">
				<h:outputText value="#{ms.imp_dispositivos_ele_via }" rendered="#{(!empty controlImplantes.currentItemElectrodos.camara)&amp;&amp;(controlImplantes.currentItemElectrodos.camara ne 0)}"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.via}"
						rendered="#{(!empty controlImplantes.currentItemElectrodos.camara)&amp;&amp;(controlImplantes.currentItemElectrodos.camara ne 0)}">
						<f:selectItems value="#{controlImplantes.viaaccesoimplante}"/>
						<a4j:support event="onchange" reRender="panModalAbordaje" ajaxSingle="true"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="1" id="abordajeLateralidad">
				<h:outputText value="#{ms.imp_dispositivos_ele_later }"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" 
					rendered="#{(!empty controlImplantes.currentItemElectrodos.via) &amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)}"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					rendered="#{(controlImplantes.currentItemElectrodos.camara ne 0)&amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)}">
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.lateralidad}" 
							rendered="#{(!empty controlImplantes.currentItemElectrodos.via) &amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)}">
						<f:selectItems value="#{controlImplantes.lateralidad}"/>
						<a4j:support event="onchange" reRender="panModalAbordaje" ajaxSingle="true"/>			
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="1" id="abordajeProcedimiento">
				<h:outputText value="#{ms.imp_dispositivos_ele_proc }"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" 
					rendered="#{(!empty controlImplantes.currentItemElectrodos.camara) &amp;&amp;(controlImplantes.currentItemElectrodos.via eq 929)}"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					rendered="#{(!empty controlImplantes.currentItemElectrodos.camara) &amp;&amp;(controlImplantes.currentItemElectrodos.via eq 929)}">
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.zonacamara}" 
						rendered="#{(!empty controlImplantes.currentItemElectrodos.camara) &amp;&amp;(controlImplantes.currentItemElectrodos.via eq 929)}">
						<f:selectItems value="#{controlImplantes.zonaepicardico}"/>
						<a4j:support event="onchange" reRender="panModalAbordaje" ajaxSingle="true"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			
			<h:panelGrid columns="1" id="panZonas">
				<h:outputText value="#{ms.imp_dispositivos_ele_zona }"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" 
					rendered="#{(!empty controlImplantes.currentItemElectrodos.camara) &amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)}"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					rendered="#{(!empty controlImplantes.currentItemElectrodos.camara) &amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)}">
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.zonacamara}" rendered="#{(controlImplantes.currentItemElectrodos.camara eq 948) &amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)}" defaultLabel="Seleccione opción">
						<f:selectItems value="#{controlImplantes.zonacamaraad}"/>
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.zonacamara}" rendered="#{(controlImplantes.currentItemElectrodos.camara eq 949) &amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)}" defaultLabel="Seleccione opción">
						<f:selectItems value="#{controlImplantes.zonacamaravd}"/>
					</h:selectOneMenu>
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.zonacamara}" rendered="#{(controlImplantes.currentItemElectrodos.camara eq 950) &amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)}" defaultLabel="Seleccione opción">
						<f:selectItems value="#{controlImplantes.zonacamaravi}"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="1" id="panPorcion">
				<h:outputText value="#{ms.imp_dispositivos_ele_porcion }"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" 
					rendered="#{(!empty controlImplantes.currentItemElectrodos.camara) &amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)&amp;&amp;(controlImplantes.currentItemElectrodos.camara eq 950)}"/>
				<h:panelGrid style="border-top: solid 1px;border-color: black;"
					rendered="#{(!empty controlImplantes.currentItemElectrodos.lateralidad) &amp;&amp;(controlImplantes.currentItemElectrodos.via ne 929)&amp;&amp;(controlImplantes.currentItemElectrodos.camara eq 950)}">
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.porcion}" >
						<f:selectItems value="#{controlImplantes.porcion}"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>
		<h:panelGrid rendered="#{controlImplantes.tipogen eq 6 }" columns="2">
			<h:panelGrid columns="1" >
				<h:outputText value="#{ms.imp_dispositivos_ele_zona }"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.zonacamara}">
						<f:selectItems value="#{controlImplantes.zonacamarasicd}"/>
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
			<h:panelGrid columns="1">
				<h:outputText value="#{ms.imp_dispositivos_ele_later }"
					style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
				<h:panelGrid style="border-top: solid 1px;border-color: black;">
					<h:selectOneMenu value="#{controlImplantes.currentItemElectrodos.lateralidad}" >
						<f:selectItems value="#{controlImplantes.lateralidad}"/>			
					</h:selectOneMenu>
				</h:panelGrid>
			</h:panelGrid>
		</h:panelGrid>	
	</h:panelGrid>
	
</ui:composition>
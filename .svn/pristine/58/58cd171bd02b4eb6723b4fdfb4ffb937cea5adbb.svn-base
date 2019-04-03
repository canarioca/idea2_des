<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox">

<script type="text/javascript" src="/idea/js/jsapi.js"></script>
<script type="text/javascript" src="/idea/js/timeline.js"></script>
<link rel="stylesheet" type="text/css" href="/idea/css/timeline.css"/>

	<h:panelGrid width="100%" id="panelResumenClinica">
		<h:panelGrid columns="4" rendered="#{controlPacientes.pacienteSelect.nhc ne null }">
			<h:graphicImage value="/img/iconos/masculino.png" id="imgH"
				styleClass="hvn_enlImagen" style="border:none;"
				title="Hombre" rendered="#{controlPacientes.pacienteSelect.sexo eq 1}" />
			<h:graphicImage value="/img/iconos/femenino.png" id="imgM"
				styleClass="hvn_enlImagen" style="border:none;" title="Mujer"
				rendered="#{controlPacientes.pacienteSelect.sexo eq 2}" />
			<h:outputLabel styleClass="index_text_center" style="color: black;font-weight: bold;font-size: 14px;" 
				value="#{controlPacientes.pacienteSelect.nombreCompleto} - Edad: #{controlPacientes.filtro.edad} - NHC: #{controlPacientes.pacienteSelect.nhc }"/>	
			<h:outputLabel styleClass="index_text_center" style="color: red;font-weight: bold;font-size: 14px;"
				rendered="#{controlPacientes.pacienteSelect.edad &lt; 17 }" 
				value=" - PEDIÁTRICO"/>
		</h:panelGrid>
		
		<input type="hidden" id="json" value="#{controlPacientes.json }"/>
		<h:outputLabel value="No se han realizado procedimientos sobre el paciente" rendered="#{empty controlPacientes.json &amp;&amp; controlPacientes.pacienteSelect.nhc ne null}"/>
		<h:outputLabel value="Seleccione o inserte un nuevo paciente para visualizar sus procedimientos" rendered="#{controlPacientes.pacienteSelect.nhc eq null }"/>
		<h:panelGrid width="100%">
			<div id="mytimeline"/>
		</h:panelGrid>
		<rich:spacer width="1" height="30"/>
		<h:inputText id="numeroprocedimiento" value="#{controlPacientes.infoprocedimientobarratemporal }" style="opacity:0;filter:alpha(opacity=0);" size="1">
			<a4j:support reRender="numeroprocedimiento,procedimiento" event="onfocus" actionListener="#{controlPacientes.cargaNumeroProc }"
				oncomplete="javascript:Richfaces.showModalPanel('procedimiento')"/>
		</h:inputText>
		
	</h:panelGrid>
	
	
	<script type="text/javascript">
		google.load("visualization", "1");	
	    // Set callback to run when API is loaded
	    google.setOnLoadCallback(drawVisualization);	
	    // Called when the Visualization API is loaded.
	    function drawVisualization() {	       
	    	// specify options
	        options = {
	    	  start: new Date(2000,2,2),
	    	  width:  "100%",
	          height: "99%",
	          style: "box", 
	          minHeight: 300,
	        };
	        var dataJSON = [];
	        //dataJSON.push({'start':new Date(2009,4,6),'content':'hola'});
	    	var obj = document.getElementById('json').value;		    
		    var spl = obj.split('_');
		    for(var i=0;i &lt; spl.length;i++){
		    	var item = spl[i].split('-');
		    	var date = item[0];var content = item[1];
		    	dataJSON.push({'start':new Date(item[0].substring(0,4),item[0].substring(5,7),item[0].substring(8,11)),'content':content.toString()});
		    }  
		    // Instantiate our timeline object.
		    var timeline = new links.Timeline(document.getElementById('mytimeline'));	
		    // Draw our timeline with the created data and options
		    //timeline.draw(data, options);
		    timeline.draw(dataJSON, options);
	    };	
	</script>
	
</ui:composition>
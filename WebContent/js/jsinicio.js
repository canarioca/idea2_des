// JavaScript Document


function MM_reloadPage(init) {

  // PARTE I-cargar la página:
  // Si el parámetro pasado es cierto con la ayuda de
  // Navigator objeto...
  if (init == true) with (navigator) {

    // ... analizar el nombre del explorador y comprobación de la versión...
    // ... si el explorador es "Netscape" y la versión es "4"...
    if ( (appName == "Netscape") && (parseInt(appVersion) == 4) ) {

      // ... la anchura y la altura interior de la ventana las ponemos en las variables...
      document.MM_pgW = innerWidth;
      document.MM_pgH = innerHeight;

      // ... y se ejecuta sin parámetros (PARTE II) si
      // Ventana cambia de tamaño
      onresize = MM_reloadPage;
    }
  }
  
  // PARTE II-después de cambiar el tamaño:
  // Si el parámetro pasado no es correcto ...
  else {

    // ... y el ancho de la ventana interior y altura no coinciden ...
    // ... con los valores de las variables de partida...
    if (innerWidth != document.MM_pgW || innerHeight != document.MM_pgH) {

      // ... actualizar la página
      location.reload();
    }
  }
}

// Llamar a la función anterior (PARTE I) si la página se dibuja
MM_reloadPage(true);

function jsPrint(pdfUrl, jsBase, impresionDirecta, mostrarVentanaEspera) {
	createEmbed(pdfUrl);
	if (!jsBase)
		jsBase = "jsPdf";
	setTimeout("printUrl('civiembed'," + impresionDirecta + ")", 5000);

	if (typeof (mostrarVentanaEspera) == "undefined"
			|| mostrarVentanaEspera != 0)
		createWaitDialog(jsBase + '/html/wait.html', '500px', '170px');
}

/*
 Crea dinamicamente una pantalla de espera a partir de una url dada (template HTML)
 fijando el alto y ancho de dicha pantalla a partir de los parámetros proporcionados
 */
function createWaitDialog(url, ancho, alto) {
	if (!url)
		url = 'jsPdf/html/wait.html';
	createDivWait(url, ancho, alto);
	Popup.showModal('printWait');
	return false;
}

/*
 Crea dinamicamente un tag <embed> con la url dada.
 Esta url debe corresponder a un archivo PDF
 */
function createEmbed(url) {
	// Buscar el objeto iprint
	var obj = document.getElementById('civiembed');
	if (obj)
		obj.parentNode.removeChild(obj);

	obj = document.createElement("embed");
	obj.setAttribute("name", "iembedcivi");
	obj.setAttribute("id", "civiembed");
	obj.setAttribute("src", url);
	obj.width = "1";
	obj.height = "1";
	document.body.appendChild(obj);

	return obj;
}

/*
 Crea dinamicamente un tag <div> con la url dada
 */
function createDivWait(url, ancho, alto) {
	// Buscar el objeto iprint
	var obj = document.getElementById('cividiv');
	if (obj)
		obj.parentNode.removeChild(obj);

	obj = document.createElement("div");
	obj.setAttribute("name", "cividivname");
	obj.setAttribute("id", "cividiv");

	var htmlDiv = '<div id="printWait" style="border:1px solid black; background-color:#AABBCC; padding:0px; text-align:center; height:'
			+ alto
			+ '; width:'
			+ ancho
			+ '; display:none" >'
			+ '<iframe  id="my_iframe" src="'
			+ url
			+ '" width="100%" height="100%" frameBorder=0 scrolling=no marginheight=0 marginwidth=0 />'
			+ '</div>';
	obj.innerHTML = htmlDiv;

	document.body.appendChild(obj);

	return obj;
}

/*
 Invoca el metodo printDialog de un objeto dado por su id (idDoc).
 Se utilizará con el objeto <embed> que será el pdf incrustado.
 */
function printUrl(idDoc, impresionDirecta) {
	if (impresionDirecta != 1) {
		document.getElementById(idDoc).printWithDialog();
	} else {
		document.getElementById(idDoc).printAll();
	}

}

/*
 Cierra el dialogo de espera de impresion
 */
function closeWaitDialog() {
	Popup.hide('printWait');
}

// Obtener parametros desde la URL
function getUrlParam(name) {
	name = name.replace(/[\[]/, "\\\[").replace(/[\]]/, "\\\]");
	var regexS = "[\\?&]" + name + "=([^&#]*)";
	var regex = new RegExp(regexS);
	var results = regex.exec(window.location.href);
	if (results == null)
		return "";
	else
		return results[1];
}

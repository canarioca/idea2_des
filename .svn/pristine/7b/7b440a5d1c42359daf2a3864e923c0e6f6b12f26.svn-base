<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<rich:panel header="Menú principal" styleClass="fondo_trans" style="margin-top: 15px;"
		id="menu">
		<a4j:jsFunction name="expande" actionListener="#{loginForm.expande }">
			<a4j:actionparam name="param1" assignTo="#{loginForm.nodo }"/>
		</a4j:jsFunction>
		<a4j:jsFunction name="colapsa" actionListener="#{loginForm.colapsa }">
			<a4j:actionparam name="param2" assignTo="#{loginForm.nodo }"/>
		</a4j:jsFunction>
		<rich:panelMenu mode="ajax" iconExpandedGroup="disc" 
			iconCollapsedGroup="disc" iconExpandedTopGroup="chevronUp"
			iconGroupTopPosition="right" iconCollapsedTopGroup="chevronDown">
			<rich:panelMenuGroup label="Pacientes" expanded="true">
				<rich:panelMenuItem label="Nuevo paciente" action="irNuevoPaciente"
					icon="/img/iconos/adduser.png" actionListener="#{controlPacientes.limpiarPacienteNuevo }"/>
				<rich:panelMenuItem label="Consulta de pacientes"
					action="irConsultaPacientes" actionListener="#{controlPacientes.limpiarPacienteSelect }"
					icon="/img/iconos/users.png">
				</rich:panelMenuItem>
				<rich:panelMenuItem label="Editar paciente" action="irNuevoPaciente"
					actionListener="#{controlPacientes.iniciar }"
					icon="/img/iconos/moduser.png" rendered="#{controlPacientes.modPaci eq 1 }"/>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="Estudio electrofisiológico" expanded="#{loginForm.nodos[0] }"
				rendered="#{loginForm.acceso.idrolacceso ne 3 }"
				disabled="#{controlPacientes.modPaci eq 0 }"> 
				<rich:panelMenuItem label="Nuevo Estudio" action="irEef"
					actionListener="#{controlEef.iniciaEef}"/>
				<rich:panelMenuItem label="Registro de enfermería"
					actionListener="#{controlTest.iniciaTest}"
					action="irEnf"/>
				<rich:panelMenuItem label="Histórico Estudios"
					action="irBuscarEstudios" actionListener="#{controlEef.iniciaEef}"/>
				<rich:panelMenuItem label="Histórico Enfermería"
					action="irHistoEnf" actionListener="#{controlTest.iniciaTest}"/>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="Cardioversión" expanded="#{loginForm.nodos[1] }"
				rendered="#{loginForm.acceso.idrolacceso ne 3 }"
				disabled="#{controlPacientes.modPaci eq 0 }">
				<rich:panelMenuItem label="Cardioversión"
					action="irCardioversion"
					actionListener="#{controlCardioversion.iniciaCardioversion}">
				</rich:panelMenuItem>
				<rich:panelMenuItem label="Histórico Cardioversión"
					action="irHistoCardioversion"
					actionListener="#{controlCardioversion.iniciaCardioversion}">
				</rich:panelMenuItem>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="Desfibriladores"  expanded="#{loginForm.nodos[2] }"
				disabled="#{controlPacientes.modPaci eq 0 }"
				rendered="#{loginForm.acceso.idrolacceso ne 3 }">
				<rich:panelMenuItem label="Desfibriladores" action="irDesfibriladores"
					actionListener="#{controlDesfibriladores.iniciaDesfibriladores}"/>
				<rich:panelMenuItem label="Histórico Desfibriladores"
					action="irHistoDesfi"
					actionListener="#{controlDesfibriladores.iniciaDesfibriladores}">
				</rich:panelMenuItem>
			</rich:panelMenuGroup>
			<!-- FRR -->
			<rich:panelMenuGroup label="Marcapasos"  expanded="#{loginForm.nodos[2] }"
				disabled="#{controlPacientes.modPaci eq 0 }"
				rendered="#{loginForm.acceso.idrolacceso ne 3 }">
				<rich:panelMenuItem label="Marcapasos" action="irMarcapasos"
					actionListener="#{controlMarcapasos.iniciaMarcapasos}"/>
				
			</rich:panelMenuGroup>
			<!-- FRR -->
			<rich:panelMenuGroup label="Test farmacológicos" expanded="#{loginForm.nodos[3] }"
				rendered="#{loginForm.acceso.idrolacceso ne 3 }"
				disabled="#{controlPacientes.modPaci eq 0 }">
				<rich:panelMenuItem label="Test ATP"
					actionListener="#{controlTest.iniciaTest}"
					action="irATP"/>
				<rich:panelMenuItem label="Test Epinefrina"
					actionListener="#{controlTest.iniciaTest}"	
					action="irEpi"/>
				<rich:panelMenuItem label="Test Flecainida"
					actionListener="#{controlTest.iniciaTest}"
					action="irFle"/>
				<rich:panelMenuItem label="Históricos"
					actionListener="#{controlTest.iniciaTest}"
					action="irHistoTest"/>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="Mesas basculantes"  expanded="#{loginForm.nodos[6] }"
				disabled="#{controlPacientes.modPaci eq 0 }"
				rendered="#{loginForm.acceso.idrolacceso ne 3 and true}">
				<rich:panelMenuItem label="Mesa basculante" action="irMesa"
					actionListener="#{controlMesas.iniciaMesas}"/>
				<rich:panelMenuItem label="Histórico Mesas basculantes"
					action="irHistoMesa"
					actionListener="#{controlMesas.iniciaMesas}">
				</rich:panelMenuItem>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="Registrador de eventos"  expanded="#{loginForm.nodos[7] }"
				disabled="#{controlPacientes.modPaci eq 0 }"
				rendered="#{loginForm.acceso.idrolacceso ne 3 and true}">
				<rich:panelMenuItem label="Registrador de eventos" action="irRegistradorEventos"
						actionListener="#{controlRegistrador.iniciaRegistradores}"/>
				<rich:panelMenuItem label="Histórico Registrador de eventos"
					action="irHistoRegistrador"
					actionListener="#{controlRegistrador.iniciaRegistradores}">
				</rich:panelMenuItem>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="Lista de Espera" expanded="#{loginForm.nodos[4] }">
				<rich:panelMenuItem label="Gestión de la lista" action="irLE"
					actionListener="#{controlLe.init }"/>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="Administración" expanded="#{loginForm.nodos[5] }"
				rendered="#{loginForm.acceso.idrolacceso eq 1 }">
				<rich:panelMenuItem label="Consultas Estadísticas" action="irConsultas"
					icon="/img/iconos/excel_ico_vert.png"
					actionListener="#{controlConsultas.inicia }"/>
				<rich:panelMenuItem label="Estadísticas mensuales" action="irEstadisticasm"
					icon="/img/iconos/estadistica.png" rendered="false"
					actionListener="#{controlEstadisticas.limpiaMensual }"/>	
				<rich:panelMenuItem label="Estadísticas anuales" action="irEstadisticasano"
					icon="/img/iconos/estadistica.png"
					actionListener="#{controlEstadisticas.limpiaAnual }"/>	
				<rich:panelMenuItem label="Formulario ablación anual" action="irAnual"
					icon="/img/iconos/formularios.jpg"
					actionListener="#{controlEstadisticas.limpiaMensual }"/>
				<rich:panelMenuItem label="Gestión de Datos Maestros" action="irMaestras"
					icon="/img/iconos/wizard.png"
					actionListener="#{controlMaestras.iniciaMaestras }"/>
				<rich:panelMenuItem label="Gestión de Accesos" action="irAccesos"
					icon="/img/iconos/user.png" actionListener="#{controlEef.anuladiag }"/>
				<rich:panelMenuItem label="Auditoría" action="irAuditoria"
					icon="/img/iconos/spy_sweeper.png" actionListener="#{controlEef.anuladiag }"/>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="Cerrar sesión" expanded="true">
				<rich:panelMenuItem label="Salir de la aplicación" icon="/img/iconos/Salir_rojo/salir_16x16.png"
					 actionListener="#{controlEef.anuladiag }"
					action="#{loginForm.acnCerrarSesion}" immediate="true">
				</rich:panelMenuItem>
			</rich:panelMenuGroup>
		</rich:panelMenu>
	</rich:panel>
	<rich:spacer height="150px" />
</ui:composition>
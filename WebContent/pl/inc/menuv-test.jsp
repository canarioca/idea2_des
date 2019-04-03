<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:f="http://java.sun.com/jsf/core">

	<rich:panel header="#{ms.menu_pr_title }" styleClass="fondo_trans" style="margin-top: 15px;" id="menu">
		<a4j:jsFunction name="expande" actionListener="#{loginForm.expande }">
			<a4j:actionparam name="param1" assignTo="#{loginForm.nodo }"/>
		</a4j:jsFunction>
		<a4j:jsFunction name="colapsa" actionListener="#{loginForm.colapsa }">
			<a4j:actionparam name="param2" assignTo="#{loginForm.nodo }"/>
		</a4j:jsFunction>
		<rich:panelMenu mode="ajax" iconExpandedGroup="disc" 
			iconCollapsedGroup="disc" iconExpandedTopGroup="chevronUp"
			iconGroupTopPosition="right" iconCollapsedTopGroup="chevronDown">
			<rich:panelMenuGroup label="#{ms.pacientes }" expanded="true">
				<rich:panelMenuItem label="#{ms.menu_pr_msg_pat_1 }" action="irNuevoPaciente"
					icon="/img/iconos/adduser.png" actionListener="#{controlPacientes.limpiarPacienteNuevo }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_pat_2 }"
					action="irConsultaPacientes" actionListener="#{controlPacientes.limpiarPacienteSelect }"
					icon="/img/iconos/users.png">
				</rich:panelMenuItem>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_pat_3 }" action="irNuevoPaciente"
					actionListener="#{controlPacientes.iniciar }"
					icon="/img/iconos/moduser.png" rendered="#{controlPacientes.modPaci eq 1 }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_le_1 }" action="irLE" rendered="#{loginFormbooleanListaEspera == true}"
					icon="/img/genericos/time.png"
					actionListener="#{controlLe.init }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_comp_1 }" action="irComplicaciones"
					icon="/img/iconos/complicacion.png" rendered="#{controlPacientes.modPaci eq 1 }"
					actionListener="#{controlComplicaciones.inicia }"/>
			</rich:panelMenuGroup>
			
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_diag_1 }" expanded="false" styleClass="diagnostico"
				rendered="#{(controlPacientes.booleanTestATP == true or
							 controlPacientes.booleanTestEpinefrina == true or
							 controlPacientes.booleanTestFlecainida == true or
				             controlPacientes.booleanMesa == true or
				             controlPacientes.booleanRegistradorEventos == true or 
				             controlPacientes.booleanSeguimientoRegistradorEventos == true or
				             controlPacientes.booleanHolter == true ) 
				             and loginForm.acceso.idrolacceso ne 3}">
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_test_1 }" expanded="#{loginForm.nodos[3] }"
					rendered="#{controlPacientes.booleanTestATP == true || 
							 controlPacientes.booleanTestEpinefrina == true || 
							 controlPacientes.booleanTestFlecainida == true }"
					disabled="#{controlPacientes.modPaci eq 0 }" styleClass="diagnostico">
					<rich:panelMenuItem label="#{ms.menu_pr_msg_test_2 }"
						actionListener="#{controlTest.iniciaTest}"
						action="irATP" icon="/img/iconos/Pills.png"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_test_3 }"
						actionListener="#{controlTest.iniciaTest}"	
						action="irEpi" icon="/img/iconos/Pills.png"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_test_4 }"
						actionListener="#{controlTest.iniciaTest}"
						action="irFle" icon="/img/iconos/Pills.png"/>
					<rich:panelMenuItem label="#{ms.historicos }"
						actionListener="#{controlTest.iniciaTest}"
						action="irHistoTest"/>
				</rich:panelMenuGroup>
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_test_orto_1 }" expanded="#{loginForm.nodos[6] }"
					disabled="#{controlPacientes.modPaci eq 0 }"
					rendered="#{controlPacientes.booleanTestOrto == true}" styleClass="diagnostico">
					<rich:panelMenuItem label="#{ms.menu_pr_msg_test_orto_1 }" action="irTestOrto"
						actionListener="#{controlTestOrtostatismo.inicia}" icon="/img/iconos/bpm.png"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_test_orto_2 }"
						action="irHistoTestOrto"
						actionListener="#{controlTestOrtostatismo.inicia}">
					</rich:panelMenuItem>
				</rich:panelMenuGroup>
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_mesa_1 }"  expanded="#{loginForm.nodos[6] }"
					disabled="#{controlPacientes.modPaci eq 0 }"
					rendered="#{controlPacientes.booleanMesa == true and true}" styleClass="diagnostico">
					<rich:panelMenuItem label="#{ms.menu_pr_msg_mesa_2 }" action="irMesa"
						actionListener="#{controlMesas.iniciaMesas}" icon="/img/iconos/mesabasc.png"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_mesa_3 }"
						action="irHistoMesa"
						actionListener="#{controlMesas.iniciaMesas}">
					</rich:panelMenuItem>
				</rich:panelMenuGroup>
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_holter_1 }"  expanded="#{loginForm.nodos[7] }"
					disabled="#{controlPacientes.modPaci eq 0 }"
					rendered="#{controlPacientes.booleanHolter == true and true}" styleClass="diagnostico">
					<rich:panelMenuItem label="#{ms.menu_pr_msg_holter_1 }" action="irHolter"
						actionListener="#{controlHolter.iniciaHolter2}" icon="/img/iconos/holter.png"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_holter_2 }"
						action="irHistoHolter"
						actionListener="#{controlHolter.iniciaHolter}">
					</rich:panelMenuItem>
				</rich:panelMenuGroup>
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_elr_1 }"  expanded="#{loginForm.nodos[7] }"
					disabled="#{controlPacientes.modPaci eq 0 }"
					rendered="#{controlPacientes.booleanRegistradorEventosExterno == true and true}" styleClass="diagnostico">
					<rich:panelMenuItem label="#{ms.menu_pr_msg_elr_2 }" action="irRegEvExt"
						actionListener="#{controlRegEvExt.iniciaRegEvExt2}" icon="/img/iconos/regevext.png"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_elr_3 }"
						action="irHistoRegEvExt" actionListener="#{controlRegEvExt.iniciaRegEvExt}">
					</rich:panelMenuItem>
				</rich:panelMenuGroup>
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_ilr_1 }"  expanded="#{loginForm.nodos[7] }"
					disabled="#{controlPacientes.modPaci eq 0 }"
					rendered="#{controlPacientes.booleanRegistradorEventos == true or 
				                controlPacientes.booleanSeguimientoRegistradorEventos == true and true}" 
				    styleClass="diagnostico">
					<rich:panelMenuItem label="#{ms.menu_pr_msg_ilr_2 }" action="irRegistradorEventos"
						actionListener="#{controlRegistrador.iniciaRegistradores}" icon="/img/iconos/ViewResults.png"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_ilr_3 }" action="irSeguimientosRegEventos"
						actionListener="#{controlSeguimientosRegEventos.inicia}" icon="/img/iconos/segregev.png"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_ilr_4 }"
						action="irHistoRegistrador"
						actionListener="#{controlRegistrador.iniciaRegistradores}">
					</rich:panelMenuItem>
				</rich:panelMenuGroup>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_eef_1 }" expanded="false" styleClass="eefabl" 
			                     rendered="#{controlPacientes.booleanEEF == true and loginForm.acceso.idrolacceso ne 3}">
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_eef_2 }" expanded="#{loginForm.nodos[0] }"
					disabled="#{controlPacientes.modPaci eq 0 }" styleClass="eefabl"> 
					<rich:panelMenuItem label="#{ms.menu_pr_msg_eef_3 }" action="irEef"
						actionListener="#{controlEef.iniciaEef}" icon="/img/iconos/hearticon.png"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_eef_4 }"
						actionListener="#{controlTest.iniciaTest}" rendered="false"
						action="irEnf"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_eef_5 }"
						action="irBuscarEstudios" actionListener="#{controlEef.iniciaEef}"/>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_eef_6 }" rendered="false"
						action="irHistoEnf" actionListener="#{controlTest.iniciaTest}"/>
				</rich:panelMenuGroup>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_trat }" expanded="false" styleClass="tratamiento" 
				rendered="#{(controlPacientes.booleanCardioversiónElectrica == true or 
				             controlPacientes.booleanPrimoImplante == true or 
				             controlPacientes.booleanReintervencion == true or 
				             controlPacientes.booleanRecambioDispositivo == true or 
				             controlPacientes.booleanUpgradeDispositivo == true or 
				             controlPacientes.booleanRecolocacionGenerador == true or 
				             controlPacientes.booleanRecolocacionElectrodo == true or 
				             controlPacientes.booleanReimplante == true ) 
							and loginForm.acceso.idrolacceso ne 3 }">
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_cve_1 }" expanded="#{loginForm.nodos[1] }"
					rendered="#{controlPacientes.booleanCardioversiónElectrica == true }"
					disabled="#{controlPacientes.modPaci eq 0 }" styleClass="tratamiento">
					<rich:panelMenuItem label="#{ms.menu_pr_msg_cve_1 }"
						action="irCardioversion" icon="/img/iconos/shock.png"
						actionListener="#{controlCardioversion.iniciaCardioversion}">
					</rich:panelMenuItem>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_cve_2 }"
						action="irHistoCardioversion"
						actionListener="#{controlCardioversion.iniciaCardioversion}">
					</rich:panelMenuItem>
				</rich:panelMenuGroup>
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_imp_1 }" expanded="#{loginForm.nodos[0] }"
						rendered="#{controlPacientes.booleanPrimoImplante == true or 
				             controlPacientes.booleanReintervencion == true or 
				             controlPacientes.booleanRecambioDispositivo == true or 
				             controlPacientes.booleanUpgradeDispositivo == true or 
				             controlPacientes.booleanRecolocacionGenerador == true or 
				             controlPacientes.booleanRecolocacionElectrodo == true or 
				             controlPacientes.booleanReimplante == true}"
						disabled="#{controlPacientes.modPaci eq 0 }" styleClass="tratamiento"> 
						<rich:panelMenuItem label="#{ms.menu_pr_msg_imp_2 }" action="irImplantes"
							actionListener="#{controlImplantes.iniciaImplantes2}" icon="/img/iconos/dispositivo.png"/>
						<rich:panelMenuItem label="#{ms.menu_pr_msg_imp_3 }" action="irSeguimientos"
							actionListener="#{controlSeguimientos.iniciaSeguimientos}" icon="/img/iconos/LastThreeMonths.png"
							disabled="#{controlPacientes.modPaci eq 0 || controlSeguimientos.previmp eq false}"/>
						<rich:panelMenuItem label="#{ms.menu_pr_msg_imp_4 }"
							action="irHistoImplantes" 
							actionListener="#{controlImplantes.iniciaImplantes}"/>
				</rich:panelMenuGroup>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_segclin_1 }" expanded="false" styleClass="segclin" rendered="#{loginForm.acceso.idrolacceso ne 3 and loginForm.acceso.idrolacceso ne 5}">
				<rich:panelMenuGroup label="#{ms.menu_pr_msg_segclin_1 }" expanded="#{loginForm.nodos[1] }"
					disabled="#{controlPacientes.modPaci eq 0 }" styleClass="segclin">
					<rich:panelMenuItem label="#{ms.menu_pr_msg_segclin_2 }"
						action="irSeguimientosClinicos"  icon="/img/iconos/BandAid.png"
						actionListener="#{controlSeguimientosClinicos.inicia}">
					</rich:panelMenuItem>
					<rich:panelMenuItem label="#{ms.menu_pr_msg_segclin_3 }"
						action="irHistoSegClin"
						actionListener="#{controlSeguimientosClinicos.inicia}">
					</rich:panelMenuItem>
				</rich:panelMenuGroup>
			</rich:panelMenuGroup>
			
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_prot }" expanded="false" styleClass="protocolos" 
				rendered="#{controlPacientes.booleanProtocolos == true and loginForm.acceso.idrolacceso ne 3 }" 
				disabled="#{controlPacientes.modPaci eq 0 }">
				<rich:panelMenuItem label="#{ms.menu_pr_msg_prot_nuevo_sincope }"
					action="irProtocoloSincope"  icon="/img/iconos/protocolo.png"
					actionListener="#{controlProtocolos.inicia}">
				</rich:panelMenuItem>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_prot_lista }"
					action="irHistoProtocolos"
					actionListener="#{controlProtocolos.inicia}">
				</rich:panelMenuItem>
			</rich:panelMenuGroup>
			
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_gestion_datos_1 }" expanded="#{loginForm.nodos[4] }" rendered="#{loginForm.acceso.idrolacceso eq 1 }"
					styleClass="otrasfunciones">
				<rich:panelMenuItem label="#{ms.menu_pr_msg_gestion_datos_2 }" action="irEstadisticasBasicas"
						icon="/img/iconos/estadistica.png"
						actionListener="#{controlEstadisticas.iniciaEstadisticas }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_gestion_datos_3 }" action="irConsultas"
						icon="/img/iconos/excel_ico_vert.png"
						actionListener="#{controlConsultas.inicia }"/>	
				<rich:panelMenuItem label="#{ms.menu_pr_msg_gestion_datos_4 }" action="irIntegraciones"
						icon="/img/iconos/integration.png"
						actionListener="#{controlIntegraciones.inicia }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_gestion_datos_8 }" action="irRecalls"
						icon="/img/iconos/alerta.png" 
						rendered="#{controlPacientes.booleanPrimoImplante == true or 
				             controlPacientes.booleanReintervencion == true or 
				             controlPacientes.booleanRecambioDispositivo == true or 
				             controlPacientes.booleanUpgradeDispositivo == true or 
				             controlPacientes.booleanRecolocacionGenerador == true or 
				             controlPacientes.booleanRecolocacionElectrodo == true or 
				             controlPacientes.booleanReimplante == true or 
				             controlPacientes.booleanRegistradorEventos == true or 
				             controlPacientes.booleanRegistradorEventosExterno == true}"
						actionListener="#{controlRecalls.inicia }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_gestion_datos_5 }" action="irAnual"
						icon="/img/iconos/formularios.jpg" rendered="#{controlPacientes.booleanEEF == true and true}"
						actionListener="#{controlEstadisticas.limpiaMensual }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_gestion_datos_6 }" action="irExportacion"
						icon="/img/iconos/xml.png" 
						rendered="#{controlPacientes.booleanPrimoImplante == true or 
				             		controlPacientes.booleanReintervencion == true or 
				             		controlPacientes.booleanRecambioDispositivo == true or 
				             		controlPacientes.booleanUpgradeDispositivo == true or 
				             		controlPacientes.booleanRecolocacionGenerador == true or 
				             		controlPacientes.booleanRecolocacionElectrodo == true or 
				             		controlPacientes.booleanReimplante == true and true}"
						actionListener="#{controlExportacion.iniciaExportacion }"/>		
				<rich:panelMenuItem label="#{ms.menu_pr_msg_gestion_datos_7 }" action="irEstadisticasGeneral"
						icon="/img/iconos/estadistica.png" rendered="false"
						actionListener="#{controlEstadisticas.iniciaEstadisticas }"/>		
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_le_1 }" expanded="#{loginForm.nodos[4] }" styleClass="otrasfunciones" rendered="false">
				<rich:panelMenuItem label="#{ms.menu_pr_msg_le_2 }" action="irLE"
					actionListener="#{controlLe.init }"/>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_admin_1 }" expanded="#{loginForm.nodos[5] }"
				rendered="#{loginForm.acceso.idrolacceso eq 1 || loginForm.acceso.idrolacceso eq 3}" styleClass="otrasfunciones">
				<rich:panelMenuItem label="#{ms.menu_pr_msg_admin_2 }" action="irMaterial"
					icon="/img/iconos/Archive.png" rendered="#{loginForm.acceso.idrolacceso eq 1 }"
					actionListener="#{controlMaterial.iniciaMaterial }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_admin_3 }" action="irCitas"
						icon="/img/iconos/citas.png"
						actionListener="#{controlCitas.iniciaCitas }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_admin_4 }" action="irMaestras"
					icon="/img/iconos/wizard.png" rendered="#{loginForm.acceso.idrolacceso eq 1}"
					actionListener="#{controlMaestras.iniciaMaestras }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_admin_5 }" action="irAccesos" rendered="#{loginForm.acceso.idrolacceso eq 1 }"
					icon="/img/iconos/user.png" actionListener="#{controlEef.anuladiag }"/>
				<rich:panelMenuItem label="#{ms.menu_pr_msg_admin_6 }" action="irAuditoria" rendered="#{loginForm.acceso.idrolacceso eq 1 }"
					icon="/img/iconos/spy_sweeper.png" actionListener="#{controlEef.anuladiag }"/>
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_personal_1 }" expanded="#{loginForm.nodos[5] }"
				 styleClass="diagnostico" rendered="true">
				<rich:panelMenuItem label="#{ms.menu_pr_msg_personal_2 }" action="irPerfilUsuario"
					actionListener="#{controlPerfilUsuario.iniciaPerfilUsuario}" 
					icon="/img/iconos/moduser.png"/>	
			</rich:panelMenuGroup>
			<rich:panelMenuGroup label="Desfibriladores"  expanded="#{loginForm.nodos[2] }"
				disabled="#{controlPacientes.modPaci eq 0 }"
				rendered="false">
				<rich:panelMenuItem label="Desfibriladores" action="irDesfibriladores"
					actionListener="#{controlDesfibriladores.iniciaDesfibriladores}"/>
				<rich:panelMenuItem label="Histórico Desfibriladores"
					action="irHistoDesfi"
					actionListener="#{controlDesfibriladores.iniciaDesfibriladores}">
				</rich:panelMenuItem>
			</rich:panelMenuGroup>
			
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_rehabilitacion_cardiaca}" expanded="false" styleClass="diagnostico">
				<rich:panelMenuItem label="#{ms.menu_pr_msg_rehabilitacion_cardiaca}" action="irRehabilitacionCardiaca"
								actionListener="#{controlRehabilitacionCardiaca.iniciaRehabilitacionCardiaca}" 
								disabled="#{controlPacientes.modPaci eq 0 }" >
				</rich:panelMenuItem>
			</rich:panelMenuGroup>
			
			
			<rich:panelMenuGroup label="#{ms.menu_pr_msg_logout_1 }" expanded="true">
				<rich:panelMenuItem label="#{ms.menu_pr_msg_logout_2 }" icon="/img/iconos/Salir_rojo/salir_16x16.png"
					 actionListener="#{controlEef.anuladiag }"
					action="#{loginForm.acnCerrarSesion}" immediate="true">
				</rich:panelMenuItem>
			</rich:panelMenuGroup>
		</rich:panelMenu>
		
	</rich:panel>
	<rich:spacer height="150px" />
</ui:composition>
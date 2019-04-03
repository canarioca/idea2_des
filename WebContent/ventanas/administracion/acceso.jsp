<?xml version="1.0" encoding="UTF-8" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:fn="http://java.sun.com/jsp/jstl/functions"
	xmlns:s="http://myfaces.apache.org/sandbox" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="formUsuarios">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelAccesos">

				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				
				<rich:panel
					style="background-color: #ffffff;
                 	 background-image:url(/cardioarritmiasMS/img/iconos/user.png);
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid columns="2" width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.user_mod_title }" style="color: white;" />
							<h:panelGrid columns="1" columnClasses="right">
								<a4j:commandLink
									actionListener="#{controlAccesos.limpiaUsuario}"
									style="align:right;" reRender="panelAccesos">
									<h:graphicImage url="/img/iconos/limpia.png" title="#{ms.limpiar }"
										styleClass="hvn_enlImagen" width="24" height="24"
										style="border:none;" />
								</a4j:commandLink>
							</h:panelGrid>
						</h:panelGrid>
					</f:facet>
					
					<h:panelGrid columnClasses="alignTop">
						<h:panelGrid columns="3" cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.user_mod_cons_title }"
								style="font-weight: bold;" />
							<a4j:commandLink reRender="tablaUsuariosSistema"
								onclick="javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								actionListener="#{controlAccesos.consultaUsuarios }">
								<h:graphicImage value="/img/iconos/buscar.png" width="16"
									height="16" style="border:0;" title="#{ms.buscar }"/>				
							</a4j:commandLink>
							<a4j:commandLink actionListener="#{controlAccesos.limpiaUsuario}"
								style="align:right;" reRender="tablaUsuariosSistema,panFiltroConsultaUsuarios"
								onclick="javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');">
								<h:graphicImage style="align:right;border:none;"
									styleClass="hvn_enlImagen" title="#{ms.limpiar }"
									width="16" height="16" url="/img/iconos/limpia.png"/>
							</a4j:commandLink>
						</h:panelGrid>
						<h:panelGrid style="border-top: solid 1px;border-color: black;" 
							columns="5" width="100%" id="panFiltroConsultaUsuarios">
							<h:outputLabel value="#{ms.user_mod_cons_msg_1 }"/>
							<h:outputLabel value="#{ms.user_mod_cons_msg_6 }"/>
							<h:outputLabel value="#{ms.user_mod_cons_msg_7 }"/>
							<h:outputLabel value="#{ms.user_mod_cons_msg_2 }"/>
							<h:outputLabel value="#{ms.user_mod_cons_msg_15 }"/>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlAccesos.criterio.usuario}"/>							
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlAccesos.criterio.nombre}"/>							
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlAccesos.criterio.apellido1}"/>							
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlAccesos.criterio.idrolacceso }">
									<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.user_rol_1 }" />
									<f:selectItem itemValue="2" itemLabel="#{ms.user_rol_2 }" />
									<f:selectItem itemValue="3" itemLabel="#{ms.user_rol_3 }" />
									<f:selectItem itemValue="4" itemLabel="#{ms.user_rol_4 }" />
									<f:selectItem itemValue="5" itemLabel="#{ms.user_rol_5 }" />												
								</h:selectOneMenu>							
							</h:panelGrid>
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:selectOneMenu value="#{controlAccesos.criterio.activo }">
									<f:selectItem itemValue="-1" itemLabel="#{ms.seleccione_opcion }" />
									<f:selectItem itemValue="1" itemLabel="#{ms.user_mod_cons_msg_3 }" />
									<f:selectItem itemValue="0" itemLabel="#{ms.user_mod_cons_msg_4 }" />												
								</h:selectOneMenu>							
							</h:panelGrid>					
						</h:panelGrid>
					</h:panelGrid>
					<h:panelGrid id="tablaUsuariosSistema">
						<h:panelGrid width="100%" rendered="#{not empty controlAccesos.users }">
							<h:panelGrid columns="2" columnClasses="alignRight">
								<h:outputLabel value="#{ms.mat_res_msg_1 }: " style="font-weight: bold;"
									rendered="#{controlAccesos.users ne null }"/>
								<h:outputLabel value="#{fn:length(controlAccesos.users) } #{ms.mat_res_msg_2 }." 
									style="font-weight: bold;color:#E17009" rendered="#{controlAccesos.users ne null }"/>
							</h:panelGrid>
							<t:dataTable styleClass="hor-minimalist-b" var="user" rows="10"
								width="100%" value="#{controlAccesos.users }"
								binding="#{controlAccesos.bindingUsers }"
								id="listausuarios">
								
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.user_mod_cons_msg_1 }" />
									</f:facet>
									<h:panelGrid columns="2">
										<h:graphicImage url="/img/iconos/users.png"
											title="#{ms.user_mod_cons_msg_3 }" width="16" height="16"
											rendered="#{user.activo eq 1 }"
											style="border: 0px;" />
										<h:graphicImage url="/img/iconos/users_dis.png"
											title="#{ms.user_mod_cons_msg_4 }" width="16" height="16"
											rendered="#{user.activo eq 0 }"										
											style="border: 0px;" />
										<h:outputLabel value="#{user.usuario }" />
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.user_mod_cons_msg_2 }" />
									</f:facet>
									<h:panelGrid>
										<h:selectOneMenu value="#{user.idrolacceso }" disabled="#{user.usuario eq loginForm.acceso.usuario }">
											<f:selectItem itemValue="1" itemLabel="#{ms.user_rol_1 }" />
											<f:selectItem itemValue="2" itemLabel="#{ms.user_rol_2 }" />
											<f:selectItem itemValue="3" itemLabel="#{ms.user_rol_3 }" />
											<f:selectItem itemValue="4" itemLabel="#{ms.user_rol_4 }" />
											<f:selectItem itemValue="5" itemLabel="#{ms.user_rol_5 }" />													
										</h:selectOneMenu>
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left" rendered="#{controlAccesos.modpass eq true }">
									<f:facet name="header">
										<h:outputText value="#{ms.user_mod_cons_msg_5 }" title="#{ms.user_mod_cons_msg_5_1 } #{controlAccesos.LONGITUD_MINIMA} #{ms.user_mod_cons_msg_5_2 } "/>
									</f:facet>
									<h:panelGrid columns="2">					
										<h:inputSecret value="#{user.modpass }" />
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.user_mod_cons_msg_6 }"/>
									</f:facet>
									<h:panelGrid columns="2">					
										<h:inputText value="#{user.nombre }" />
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.user_mod_cons_msg_7 }"/>
									</f:facet>
									<h:panelGrid columns="2">					
										<h:inputText value="#{user.apellido1 }" />
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.user_mod_cons_msg_8 }"/>
									</f:facet>
									<h:panelGrid columns="2">					
										<h:inputText value="#{user.apellido2 }" />
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.user_mod_cons_msg_9 }"/>
									</f:facet>
									<h:panelGrid columns="2">					
										<h:inputText value="#{user.correo }" />
									</h:panelGrid>
								</t:column>
								<t:column width="50%" headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.user_mod_cons_msg_10 }"/>
									</f:facet>
									<h:panelGrid columns="2">					
										<h:inputText value="#{user.codigo }" />
									</h:panelGrid>
								</t:column>
								<t:column width="10%" headerstyleClass="left">
									<h:panelGrid columns="4">
										<a4j:commandLink reRender="tablaUsuariosSistema,listausuarios"
											actionListener="#{controlAccesos.resetPassUsuario }">		
											<h:graphicImage url="/img/iconos/group_key.png"
											 	title="#{ms.user_mod_cons_msg_11 }" width="16" height="16"
												style="border: 0px;" />											
										</a4j:commandLink>
										<a4j:commandLink reRender="tablaUsuariosSistema"
											oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
											onclick="if (!confirm('#{ms.warn_edit_usuario}')) return false;javascript:Richfaces.showModalPanel('buscando');"
											actionListener="#{controlAccesos.modificarUsuario }">		
											<h:graphicImage url="/img/iconos/guarda.png"
											 	title="#{ms.editar }" width="16" height="16"
												style="border: 0px;" />											
										</a4j:commandLink>
										<a4j:commandLink reRender="tablaUsuariosSistema"
											oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
											onclick="if (!confirm('#{ms.warn_desactivar_usuario}')) return false;javascript:Richfaces.showModalPanel('buscando');"
											actionListener="#{controlAccesos.desactivaUsuario }"
											rendered="#{user.usuario ne loginForm.acceso.usuario and user.activo eq 1}">		
											<h:graphicImage url="/img/aplicacion/icoCancelar.png"
											 	title="#{ms.user_mod_cons_msg_12 }" width="16" height="16"
												style="border: 0px;" />											
										</a4j:commandLink>
										<a4j:commandLink reRender="tablaUsuariosSistema"
											oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
											onclick="javascript:Richfaces.showModalPanel('buscando');"
											actionListener="#{controlAccesos.activaUsuario }"
											rendered="#{user.usuario ne loginForm.acceso.usuario and user.activo eq 0}">		
											<h:graphicImage url="/img/aplicacion/accept.png"
											 	title="#{ms.user_mod_cons_msg_14 }" width="16" height="16"
												style="border: 0px;" />											
										</a4j:commandLink>
										<a4j:commandLink reRender="tablaUsuariosSistema"
											oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
											onclick="if (!confirm('#{ms.warn_eliminar_usuario}')) return false;javascript:Richfaces.showModalPanel('buscando');"
											actionListener="#{controlAccesos.eliminaUsuario }"
											rendered="#{user.usuario ne loginForm.acceso.usuario or user.activo eq 0}">		
											<h:graphicImage url="/img/iconos/borra.png"
											 	title="#{ms.eliminar }" width="16" height="16"
												style="border: 0px;" />											
										</a4j:commandLink>											
									</h:panelGrid>
								</t:column>
								<f:facet name="footer">
									<rich:datascroller align="center" for="listausuarios" id="scrollUsuarios"
										renderIfSinglePage="true" fastStep="3"
										page="#{controlAccesos.pagina_inicial}">
										<f:facet name="first">
											<h:graphicImage url="/img/genericos/navegacion/first.png" />
										</f:facet>
										<f:facet name="last">
											<h:graphicImage url="/img/genericos/navegacion/last.png" />
										</f:facet>
										<f:facet name="fastrewind">
											<h:graphicImage url="/img/genericos/navegacion/frwd.png" />
										</f:facet>
										<f:facet name="fastforward">
											<h:graphicImage url="/img/genericos/navegacion/ffwd.png" />
										</f:facet>
										<f:facet name="previous">
											<h:graphicImage url="/img/genericos/navegacion/rwd.png" />
										</f:facet>
										<f:facet name="next">
											<h:graphicImage url="/img/genericos/navegacion/fwd.png" />
										</f:facet>
										<f:facet name="first_disabled">
											<h:graphicImage url="/img/genericos/navegacion/first.png" />
										</f:facet>
										<f:facet name="last_disabled">
											<h:graphicImage url="/img/genericos/navegacion/last.png" />
										</f:facet>
										<f:facet name="fastrewind_disabled">
											<h:graphicImage url="/img/genericos/navegacion/frwd.png" />
										</f:facet>
										<f:facet name="fastforward_disabled">
											<h:graphicImage url="/img/genericos/navegacion/ffwd.png" />
										</f:facet>
										<f:facet name="previous_disabled">
											<h:graphicImage url="/img/genericos/navegacion/rwd.png" />
										</f:facet>
										<f:facet name="next_disabled">
											<h:graphicImage url="/img/genericos/navegacion/fwd.png" />
										</f:facet>
									</rich:datascroller>
								</f:facet>
							</t:dataTable>
						</h:panelGrid>
					</h:panelGrid>
					<rich:spacer width="20" />
					<rich:simpleTogglePanel switchType="client" label="#{ms.user_nuevo_title }" opened="false">
						<h:panelGrid columns="2" cellpadding="0" cellspacing="0">
							<h:outputLabel value="#{ms.user_nuevo_msg_1 }" style="font-weight: bold;" />
						</h:panelGrid>
						<h:panelGrid style="border-top: solid 1px;border-color: black;" 
							width="80%" columnClasses="alignTop,alignTop" id="panAccesoNuevoUsuario">
							<t:fieldset legend="#{ms.user_nuevo_msg_2 }">
								<h:panelGrid columns="3">
									<h:panelGrid columnClasses="alignTop">
										<h:outputLabel value="#{ms.user_mod_cons_msg_1 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlAccesos.acceso.usuario }"/>
										</h:panelGrid>								
									</h:panelGrid>
									<h:panelGrid columnClasses="alignTop">
										<h:outputLabel value="#{ms.user_mod_cons_msg_5 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputSecret value="#{controlAccesos.acceso.pass }"/>
										</h:panelGrid>								
									</h:panelGrid>
									<h:panelGrid columnClasses="alignTop">
										<h:outputLabel value="#{ms.user_mod_cons_msg_2 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:selectOneMenu value="#{controlAccesos.acceso.idrolacceso }">
												<f:selectItem itemValue="0" itemLabel="#{ms.seleccione_opcion }" />
												<f:selectItem itemValue="1" itemLabel="#{ms.user_rol_1 }" />
												<f:selectItem itemValue="2" itemLabel="#{ms.user_rol_2 }" />
												<f:selectItem itemValue="3" itemLabel="#{ms.user_rol_3 }" />
												<f:selectItem itemValue="4" itemLabel="#{ms.user_rol_4 }" />
												<f:selectItem itemValue="5" itemLabel="#{ms.user_rol_5 }" />											
											</h:selectOneMenu>
										</h:panelGrid>								
									</h:panelGrid>
								</h:panelGrid>
							</t:fieldset>
							<t:fieldset legend="#{ms.user_nuevo_msg_3 }">
								<h:panelGrid columns="5">
									<h:panelGrid columnClasses="alignTop">
										<h:outputLabel value="#{ms.user_mod_cons_msg_6 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlAccesos.acceso.nombre }"/>
										</h:panelGrid>								
									</h:panelGrid>
									<h:panelGrid columnClasses="alignTop">
										<h:outputLabel value="#{ms.user_mod_cons_msg_7 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlAccesos.acceso.apellido1 }"/>
										</h:panelGrid>								
									</h:panelGrid>
									<h:panelGrid columnClasses="alignTop">
										<h:outputLabel value="#{ms.user_mod_cons_msg_8 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlAccesos.acceso.apellido2 }"/>
										</h:panelGrid>								
									</h:panelGrid>
									<h:panelGrid columnClasses="alignTop">
										<h:outputLabel value="#{ms.user_mod_cons_msg_13 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlAccesos.acceso.codigo }"/>
										</h:panelGrid>								
									</h:panelGrid>
									<h:panelGrid columnClasses="alignTop">
										<h:outputLabel value="#{ms.user_mod_cons_msg_9 }" style="font-weight: bold;"/>
										<h:panelGrid style="border-top: solid 1px;border-color: black;">
											<h:inputText value="#{controlAccesos.acceso.correo }"/>
										</h:panelGrid>								
									</h:panelGrid>
								</h:panelGrid>
							</t:fieldset>							
						</h:panelGrid>					
						<h:panelGrid columns="2">
							<a4j:commandLink reRender="tablaUsuariosSistema,panAccesoNuevoUsuario" actionListener="#{controlAccesos.guardarUsuario }">
								<h:graphicImage value="/img/iconos/guardar.png" width="16" height="16" style="border:0;" title="#{ms.user_nuevo_msg_4 }"/>				
							</a4j:commandLink>
							<h:outputLabel value="#{ms.guardar }" style="font-weight: bold;"/>
						</h:panelGrid>
					</rich:simpleTogglePanel>
					<rich:spacer height="15px" />
					<rich:simpleTogglePanel switchType="client" label="#{ms.user_priv_title }" opened="false">
						<h:panelGrid width="100%" id="panAccesoConfPriv">
							<t:dataTable styleClass="hor-minimalist-b" var="priv" rows="5"
								width="100%" value="#{controlAccesos.privs }"
								binding="#{controlAccesos.bindingPrivs }"
								id="listaprivs">
								<t:column headerstyleClass="left">
									<f:facet name="header">
										<h:outputText value="#{ms.user_mod_cons_msg_2 }"/>
									</f:facet>
									<h:panelGrid>					
										<h:selectOneMenu value="#{priv.idrol}" disabled="true">
											<f:selectItem itemValue="1" itemLabel="#{ms.user_rol_1 }" />
											<f:selectItem itemValue="2" itemLabel="#{ms.user_rol_2 }" />
											<f:selectItem itemValue="3" itemLabel="#{ms.user_rol_3 }" />
											<f:selectItem itemValue="4" itemLabel="#{ms.user_rol_4 }" />
											<f:selectItem itemValue="5" itemLabel="#{ms.user_rol_5 }" />											
										</h:selectOneMenu>
									</h:panelGrid>
								</t:column>
								<t:column headerstyleClass="left">
									<f:facet name="header">
										<h:panelGrid columns="2">											
											<h:graphicImage url="/img/iconos/add.png"
											 	title="#{ms.user_priv_title_1 }" width="16" height="16"
												style="border: 0px;" />
											<h:outputText value="#{ms.user_priv_msg_1 }"/>
										</h:panelGrid>
									</f:facet>
									<h:panelGrid>					
										<h:selectOneMenu value="#{priv.insercion}" disabled="#{priv.idrol eq 1 }">
											<f:selectItem itemValue="0" itemLabel="#{ms.user_priv_op0 }" />
											<f:selectItem itemValue="1" itemLabel="#{ms.user_priv_op1 }" />												
										</h:selectOneMenu>
									</h:panelGrid>
								</t:column>
								<t:column headerstyleClass="left">
									<f:facet name="header">
										<h:panelGrid columns="2">											
											<h:graphicImage url="/img/iconos/editar.png"
											 	title="#{ms.user_priv_title_2 }" width="16" height="16"
												style="border: 0px;" />
											<h:outputText value="#{ms.user_priv_msg_2 }"/>
										</h:panelGrid>
									</f:facet>
									<h:panelGrid>					
										<h:selectOneMenu value="#{priv.edicion}" disabled="#{priv.idrol eq 1 }">
											<f:selectItem itemValue="0" itemLabel="#{ms.user_priv_op0 }" />
											<f:selectItem itemValue="1" itemLabel="#{ms.user_priv_op1 }" />
											<f:selectItem itemValue="2" itemLabel="#{ms.user_priv_op2 }" />
											<a4j:support event="onchange" reRender="listaprivs" ajaxSingle="true"/>												
										</h:selectOneMenu>
									</h:panelGrid>
								</t:column>
								<t:column headerstyleClass="left">
									<f:facet name="header">
										<h:panelGrid columns="2">											
											<h:graphicImage url="/img/iconos/borra.png"
											 	title="#{ms.user_priv_title_3 }" width="16" height="16"
												style="border: 0px;" />
											<h:outputText value="#{ms.user_priv_msg_3 }"/>
										</h:panelGrid>
									</f:facet>
									<h:panelGrid>					
										<h:selectOneMenu value="#{priv.borrado}" disabled="#{priv.idrol eq 1 }">
											<f:selectItem itemValue="0" itemLabel="#{ms.user_priv_op0 }" />
											<f:selectItem itemValue="1" itemLabel="#{ms.user_priv_op1 }" />												
										</h:selectOneMenu>
									</h:panelGrid>
								</t:column>
								<t:column headerstyleClass="left">
									<f:facet name="header">
										<h:panelGrid columns="2">											
											<h:graphicImage url="/img/genericos/time.png"
											 	title="#{ms.user_priv_title_4 }" width="16" height="16"
												style="border: 0px;" />
											<h:outputText value="#{ms.user_priv_msg_4 }"/>
										</h:panelGrid>
									</f:facet>
									<h:panelGrid>					
										<rich:inputNumberSpinner minValue="1" maxValue="100" step="1" value="#{priv.tiempoedicion }"
											rendered="#{priv.edicion eq 2 }"/>
									</h:panelGrid>
								</t:column>
								<t:column width="10%" headerstyleClass="left">
									<h:panelGrid>
										<a4j:commandLink reRender="panAccesoConfPriv" rendered="#{priv.idrol ne 1 }"
											oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
											onclick="if (!confirm('#{ms.warn_edit_priv_usuario}')) return false;javascript:Richfaces.showModalPanel('buscando');"
											actionListener="#{controlAccesos.modificarPrivilegios }">		
											<h:graphicImage url="/img/iconos/guarda.png"
											 	title="#{ms.editar }" width="16" height="16"
												style="border: 0px;" />											
										</a4j:commandLink>																					
									</h:panelGrid>
								</t:column>
							</t:dataTable>
						</h:panelGrid>
					</rich:simpleTogglePanel>
					
					<rich:spacer height="15px" />
					<rich:simpleTogglePanel switchType="client" label="#{ms.user_pass_title }" opened="false">
						<h:panelGrid columns="3">
							<h:outputLabel value="#{ms.user_pass_msg_1 }" style="font-weight: bold;"/>
							<h:inputText value="#{controlAccesos.LONGITUD_MINIMA}" disabled="true" size="4"/>
							<h:outputLabel value="#{ms.user_pass_msg_2 }"/>
							<h:outputLabel value="#{ms.user_pass_msg_3 }" style="font-weight: bold;"/>
							<h:inputText value="#{controlAccesos.CADUCIDAD}" disabled="true" size="4"/>
							<h:outputLabel value="#{ms.user_pass_msg_4 }"/>
							<h:outputLabel value="#{ms.user_pass_msg_5 }" style="font-weight: bold;"/>
							<h:inputText value="#{controlAccesos.INTENTOS}" disabled="true" size="4"/>
							<h:outputLabel value="#{ms.user_pass_msg_6 }"/>
						</h:panelGrid>
					</rich:simpleTogglePanel>




					<h:panelGrid columns="3" rendered="false">
						<f:facet name="header">
							<h:outputText value="Filtros de búsqueda" />
						</f:facet>
						<f:attribute name="align" value="center" />
						<h:panelGrid>
							<h:outputText value="Login"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlAccesos.criterioBusqueda.login}"
									size="10" style="font-size: 11px;" />
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid rendered="false">
							<h:outputText value="Nombre"
								style="color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;" />
							<h:panelGrid style="border-top: solid 1px;border-color: black;">
								<h:inputText value="#{controlAccesos.criterioBusqueda.nombre}"
									size="50" style="font-size: 11px;" />
							</h:panelGrid>
						</h:panelGrid>
						<h:panelGrid>
							<a4j:commandLink actionListener="#{controlAccesos.buscaUsuarios}"
								onclick="javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								style="align:right;" reRender="panelAccesos">
								<h:graphicImage styleClass="hvn_enlImagen"
									value="/img/iconos/buscar.png" style="border:none;"
									width="24" height="24" title="Buscar" />
							</a4j:commandLink>
						</h:panelGrid>
					</h:panelGrid>

					<h:panelGrid width="50%" 
						rendered="false">
						<f:facet name="header">
							<h:outputText value="Resultados de la búsqueda" />
						</f:facet>
						<f:attribute name="align" value="center" />
						<rich:dataTable id="tablaUsuarios" styleClass="hor-minimalist-b"
							value="#{controlAccesos.usuarios}" var="usu" rows="10"
							width="100%" binding="#{controlAccesos.iuTablaUsuarios}">
							<rich:column id="login">
								<f:facet name="header">
									<h:outputText value="Login" styleClass="outputCampoForm" />
								</f:facet>
								<a4j:commandLink
									actionListener="#{controlAccesos.selectUsuario}"
									value="#{usu.login}" reRender="panelAccesos"
									style="text-decoration: none;color: black;" />
							</rich:column>
							<rich:column id="nombre">
								<f:facet name="header">
									<h:outputText value="Nombre" styleClass="outputCampoForm" />
								</f:facet>
								<a4j:commandLink
									actionListener="#{controlAccesos.selectUsuario}"
									value="#{usu.nombre}" reRender="panelAccesos"
									style="text-decoration: none;color: black;" />
							</rich:column>
						</rich:dataTable>
						<rich:datascroller for="tablaUsuarios" stepControls="auto"
							fastControls="auto" fastStep="3" maxPages="7"
							boundaryControls="auto" />
					</h:panelGrid>

					<h:panelGrid width="30%"
						rendered="false"
						columns="3">
						<f:facet name="header">
							<h:outputText value="Usuario seleccionado" />
						</f:facet>
						<f:attribute name="align" value="center" />
						<h:outputText value="#{controlAccesos.acceso.usuario}"
							styleClass="outputCampoForm" />
						<h:selectOneMenu value="#{controlAccesos.acceso.idrolacceso }">
							<f:selectItem itemValue="0" itemLabel="(Seleccione acceso)"/>
							<f:selectItem itemValue="1" itemLabel="Administrador"/>
							<f:selectItem itemValue="2" itemLabel="Usuario genérico"/>
							<f:selectItem itemValue="3" itemLabel="Usuario lista de espera"/>
						</h:selectOneMenu>
						<h:panelGrid columns="2" align="right" cellspacing="1">
							<a4j:commandLink
								actionListener="#{controlAccesos.guardarUsuario}"
								onclick="javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								style="align:right;"
								rendered="#{controlAccesos.acceso.usuario ne null and loginForm.acceso.usuario ne controlAccesos.acceso.usuario}"
								reRender="panelAccesos">
								<h:graphicImage styleClass="hvn_enlImagen"
									value="/img/iconos/guarda.png" style="border:none;"
									title="Guardar" />
							</a4j:commandLink>
							<a4j:commandLink
								actionListener="#{controlAccesos.eliminarUsuario}"
								onclick="javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								style="align:right;"
								rendered="#{controlAccesos.existe and loginForm.acceso.usuario ne controlAccesos.acceso.usuario}"
								reRender="panelAccesos">
								<h:graphicImage styleClass="hvn_enlImagen" width="24" height="24"
									value="/img/iconos/borra.png" style="border:none;"
									title="Eliminar" />
							</a4j:commandLink>
						</h:panelGrid>
					</h:panelGrid>
					
					<h:panelGrid width="30%"
						rendered="false"
						columns="2">
						<f:facet name="header">
							<h:outputText value="Nuevo usuario" />
						</f:facet>
						<f:attribute name="align" value="center" />
						<h:outputText value="Login" styleClass="outputCampoForm" />
						<h:inputText value="#{controlAccesos.acceso.usuario}"
							styleClass="outputCampoForm" size="12" maxlength="10" />
						<h:outputText value="Pass" styleClass="outputCampoForm" />
						<h:inputSecret value="#{controlAccesos.acceso.pass}" 
							styleClass="outputCampoForm" size="12" maxlength="10" />
						<h:outputText value="Rol" styleClass="outputCampoForm" />
						<h:selectOneMenu value="#{controlAccesos.acceso.idrolacceso }">
							<f:selectItem itemValue="0" itemLabel="(Seleccione acceso)"/>
							<f:selectItem itemValue="1" itemLabel="Administrador"/>
							<f:selectItem itemValue="2" itemLabel="Usuario genérico"/>
							<f:selectItem itemValue="3" itemLabel="Usuario lista de espera"/>
						</h:selectOneMenu>
						<h:panelGrid >
							<a4j:commandLink
								actionListener="#{controlAccesos.guardarUsuario}"
								onclick="javascript:Richfaces.showModalPanel('buscando');"
								oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
								style="align:right;" reRender="panelAccesos">
								<h:graphicImage styleClass="hvn_enlImagen"
									value="/img/iconos/guarda.png" style="border:none;"
									title="Guardar" />
							</a4j:commandLink>
						</h:panelGrid>
					</h:panelGrid>
				</rich:panel>
			</h:panelGrid>
		</h:form>
	</ui:define>
</ui:composition>
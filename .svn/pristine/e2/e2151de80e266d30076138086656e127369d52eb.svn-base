<?xml version="1.0" encoding="ISO-8859-1" ?>
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:t="http://myfaces.apache.org/tomahawk"
	xmlns:rich="http://richfaces.ajax4jsf.org/rich"
	xmlns:jenia="http://www.jenia.org/jsf/popup"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:s="http://myfaces.apache.org/sandbox" template="/pl/plBase.jsp">

	<ui:define name="contenido">
		<h:form id="formPersonal">
			<a4j:poll reRender="cabpaci" interval="120000"/>
			<h:panelGrid cellpadding="0" cellspacing="0" columns="1" width="98%"
				style="margin-top: 15px;" id="panelPersonal">

				<rich:messages errorClass="hvn_msjError" infoClass="hvn_msjInfo"
					warnClass="hvn_msjAviso" />
				<rich:panel
					style="background-color: #ffffff;
                     background-repeat: no-repeat;
                     background-position:right bottom;">
					<f:facet name="header">
						<h:panelGrid width="100%" columnClasses="left,right"
							cellpadding="0" cellspacing="0" >
							<h:outputLabel value="#{ms.miperfil_title_1 }" style="color: white;" />										
						</h:panelGrid>					
					</f:facet>
					<h:panelGrid width="90%" columnClasses="centerTop" id="panInfoUser">		
						<h:outputLabel value="#{ms.cab_exp_pw_1 } #{loginForm.acceso.diasrev } #{ms.cab_exp_pw_2 }" 
							rendered="#{loginForm.acceso.diasrev &lt; 15}"
							style="color: red;font-size: 14px;font-weight: bold;"/>		
						<h:panelGrid columns="2" columnClasses="alignTop">
							<h:panelGrid columnClasses="alignTop" >
								<t:fieldset legend="#{ms.miperfil_title_2 }">
									<h:panelGrid>
										<h:panelGrid columns="2" columnClasses="alignTop">
											<h:panelGrid>
												<h:outputText value="#{ms.miperfil_msg_1 }"
													style="font-weight: bold;color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
												<h:panelGrid style="border-top: solid 1px;border-color: black;">
													<h:outputLabel value="#{loginForm.acceso.usuario }"/>
												</h:panelGrid>
											</h:panelGrid>
											<h:panelGrid>
												<h:outputText value="#{ms.miperfil_msg_2 }"
													style="font-weight: bold;color: #444444;padding:3px;font-size:11px;margin: 5px 0px 5px 0px;;" />
												<h:panelGrid style="border-top: solid 1px;border-color: black;">
													<h:selectOneMenu value="#{loginForm.acceso.idrolacceso }" disabled="true">
														<f:selectItem itemValue="0" itemLabel="" />
														<f:selectItem itemValue="1" itemLabel="#{ms.user_rol_1 }" />
														<f:selectItem itemValue="2" itemLabel="#{ms.user_rol_2 }" />
														<f:selectItem itemValue="3" itemLabel="#{ms.user_rol_3 }" />
														<f:selectItem itemValue="4" itemLabel="#{ms.user_rol_4 }" />
													</h:selectOneMenu>
												</h:panelGrid>
											</h:panelGrid>
											<h:outputLabel value="#{ms.miperfil_msg_3 }"
													style="font-weight: bold;" />
											<h:outputLabel value="#{loginForm.acceso.fechaultacc } "/>
											<h:outputLabel value="#{ms.miperfil_msg_4 }"
													style="font-weight: bold;" />
											<h:outputLabel value="#{loginForm.acceso.fecharev} #{ms.miperfil_msg_4_1 } #{loginForm.acceso.diasrev } #{ms.miperfil_msg_4_2 }"/>
											<h:outputLabel value="#{ms.miperfil_msg_5 }" style="font-weight: bold;" />
											<h:outputLabel value="#{loginForm.acceso.contador} #{ms.miperfil_msg_5_1 }"/>
										</h:panelGrid>																
									</h:panelGrid>
									<h:panelGrid columns="2" rendered="#{loginForm.cambiopass eq false }">
										<h:graphicImage url="/img/iconos/group_key.png" style="border:0px;"
												width="22" height="22" title="#{ms.miperfil_title_3 }" />
										<a4j:commandLink 
											reRender="panInfoUser" style="align:right;" value="#{ms.miperfil_title_3 }"
											actionListener="#{loginForm.cambiaClave}">											
										</a4j:commandLink>	
									</h:panelGrid>
									<t:fieldset legend="#{ms.miperfil_title_4 }" rendered="#{loginForm.cambiopass eq true }">										
										<h:panelGrid id="cambioClave">
											<h:outputLabel value="#{ms.miperfil_cambio_pw_msg_1 }" style="font-weight: bold;"/>
											<h:panelGrid style="border-top: solid 1px;border-color: black;">
												<h:inputSecret value="#{loginForm.pass2}" size="45"/>								
											</h:panelGrid>
											<h:outputLabel value="#{ms.miperfil_cambio_pw_msg_2 }" style="font-weight: bold;"/>
											<h:panelGrid style="border-top: solid 1px;border-color: black;">
												<h:inputSecret value="#{loginForm.nuevapass }" size="45"/>
												<h:outputLabel value="#{ms.miperfil_cambio_pw_msg_3 } #{loginForm.LONGITUD } #{ms.miperfil_cambio_pw_msg_3_1 }" 
													style="font-size: 10px;font-weight: bold;"/>
											</h:panelGrid>
											<h:outputLabel value="#{ms.miperfil_cambio_pw_msg_4 }" style="font-weight: bold;"/>
											<h:panelGrid style="border-top: solid 1px;border-color: black;">
												<h:inputSecret value="#{loginForm.confnuevapass }" size="45"/>
											</h:panelGrid>							
										</h:panelGrid>
										<h:panelGrid columns="3">
											<a4j:commandLink actionListener="#{loginForm.cambiarClaveUsuario}"
												onclick="javascript:Richfaces.showModalPanel('buscando');"
												oncomplete="javascript:Richfaces.hideModalPanel('buscando');"
												reRender="panInfoUser,cambioClave,cabeceraClaveAlerta">
												<h:graphicImage style="border: 0px;" value="/img/iconos/guarda.png"
													width="16px" height="16px" title="#{ms.confirmar }"/>
											</a4j:commandLink>
											<a4j:commandLink actionListener="#{loginForm.cambiaClave }" reRender="panInfoUser,cambioClave,cabeceraClaveAlerta">
												<h:graphicImage value="/img/aplicacion/icoCancelar.png"
													style="border:0;cursor:pointer;"											
													title="#{ms.cancelar }" />
											</a4j:commandLink>	
											<a4j:commandLink actionListener="#{loginForm.limpiarCampos}" style="align:right;" reRender="panInfoUser,cambioClave,cabeceraClaveAlerta">
												<h:graphicImage style="align:right;border:none;" styleClass="hvn_enlImagen" title="#{ms.limpiar }" 
													width="16" height="16" url="/img/iconos/limpia.png"/>
											</a4j:commandLink>	
										</h:panelGrid>	
									</t:fieldset>
																	
								</t:fieldset>
							</h:panelGrid>
						</h:panelGrid>
					</h:panelGrid>
					<rich:spacer height="30px"/>				
				</rich:panel>
			</h:panelGrid>
			
			
			
			
		</h:form>
		
		
	</ui:define>
</ui:composition>
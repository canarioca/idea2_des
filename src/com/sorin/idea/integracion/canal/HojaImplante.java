
/**
 * HojaImplante.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.sorin.idea.integracion.canal;
            

            /**
            *  HojaImplante bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class HojaImplante
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = HojaImplante
                Namespace URI = http://canal.integracion.idea.sorin.com
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for Implantador
                        */

                        
                                    protected int localImplantador ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImplantadorTracker = false ;

                           public boolean isImplantadorSpecified(){
                               return localImplantadorTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getImplantador(){
                               return localImplantador;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Implantador
                               */
                               public void setImplantador(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localImplantadorTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localImplantador=param;
                                    

                               }
                            

                        /**
                        * field for Testinduccion
                        */

                        
                                    protected boolean localTestinduccion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTestinduccionTracker = false ;

                           public boolean isTestinduccionSpecified(){
                               return localTestinduccionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getTestinduccion(){
                               return localTestinduccion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Testinduccion
                               */
                               public void setTestinduccion(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localTestinduccionTracker =
                                       true;
                                   
                                            this.localTestinduccion=param;
                                    

                               }
                            

                        /**
                        * field for Testinduccion_energia
                        */

                        
                                    protected java.lang.String localTestinduccion_energia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTestinduccion_energiaTracker = false ;

                           public boolean isTestinduccion_energiaSpecified(){
                               return localTestinduccion_energiaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTestinduccion_energia(){
                               return localTestinduccion_energia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Testinduccion_energia
                               */
                               public void setTestinduccion_energia(java.lang.String param){
                            localTestinduccion_energiaTracker = param != null;
                                   
                                            this.localTestinduccion_energia=param;
                                    

                               }
                            

                        /**
                        * field for Testinduccion_impedancia
                        */

                        
                                    protected java.lang.String localTestinduccion_impedancia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTestinduccion_impedanciaTracker = false ;

                           public boolean isTestinduccion_impedanciaSpecified(){
                               return localTestinduccion_impedanciaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTestinduccion_impedancia(){
                               return localTestinduccion_impedancia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Testinduccion_impedancia
                               */
                               public void setTestinduccion_impedancia(java.lang.String param){
                            localTestinduccion_impedanciaTracker = param != null;
                                   
                                            this.localTestinduccion_impedancia=param;
                                    

                               }
                            

                        /**
                        * field for Testinduccion_numchoques
                        */

                        
                                    protected java.lang.String localTestinduccion_numchoques ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTestinduccion_numchoquesTracker = false ;

                           public boolean isTestinduccion_numchoquesSpecified(){
                               return localTestinduccion_numchoquesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTestinduccion_numchoques(){
                               return localTestinduccion_numchoques;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Testinduccion_numchoques
                               */
                               public void setTestinduccion_numchoques(java.lang.String param){
                            localTestinduccion_numchoquesTracker = param != null;
                                   
                                            this.localTestinduccion_numchoques=param;
                                    

                               }
                            

                        /**
                        * field for Prioridad
                        */

                        
                                    protected int localPrioridad ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPrioridadTracker = false ;

                           public boolean isPrioridadSpecified(){
                               return localPrioridadTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getPrioridad(){
                               return localPrioridad;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Prioridad
                               */
                               public void setPrioridad(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localPrioridadTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localPrioridad=param;
                                    

                               }
                            

                        /**
                        * field for Tescopia
                        */

                        
                                    protected java.lang.String localTescopia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTescopiaTracker = false ;

                           public boolean isTescopiaSpecified(){
                               return localTescopiaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTescopia(){
                               return localTescopia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Tescopia
                               */
                               public void setTescopia(java.lang.String param){
                            localTescopiaTracker = param != null;
                                   
                                            this.localTescopia=param;
                                    

                               }
                            

                        /**
                        * field for Hllegada
                        */

                        
                                    protected java.lang.String localHllegada ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHllegadaTracker = false ;

                           public boolean isHllegadaSpecified(){
                               return localHllegadaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getHllegada(){
                               return localHllegada;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hllegada
                               */
                               public void setHllegada(java.lang.String param){
                            localHllegadaTracker = param != null;
                                   
                                            this.localHllegada=param;
                                    

                               }
                            

                        /**
                        * field for Hinicio
                        */

                        
                                    protected java.lang.String localHinicio ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHinicioTracker = false ;

                           public boolean isHinicioSpecified(){
                               return localHinicioTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getHinicio(){
                               return localHinicio;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hinicio
                               */
                               public void setHinicio(java.lang.String param){
                            localHinicioTracker = param != null;
                                   
                                            this.localHinicio=param;
                                    

                               }
                            

                        /**
                        * field for Hfin
                        */

                        
                                    protected java.lang.String localHfin ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHfinTracker = false ;

                           public boolean isHfinSpecified(){
                               return localHfinTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getHfin(){
                               return localHfin;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hfin
                               */
                               public void setHfin(java.lang.String param){
                            localHfinTracker = param != null;
                                   
                                            this.localHfin=param;
                                    

                               }
                            

                        /**
                        * field for Hsalida
                        */

                        
                                    protected java.lang.String localHsalida ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHsalidaTracker = false ;

                           public boolean isHsalidaSpecified(){
                               return localHsalidaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getHsalida(){
                               return localHsalida;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hsalida
                               */
                               public void setHsalida(java.lang.String param){
                            localHsalidaTracker = param != null;
                                   
                                            this.localHsalida=param;
                                    

                               }
                            

                        /**
                        * field for Lugarimplante
                        */

                        
                                    protected int localLugarimplante ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLugarimplanteTracker = false ;

                           public boolean isLugarimplanteSpecified(){
                               return localLugarimplanteTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getLugarimplante(){
                               return localLugarimplante;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Lugarimplante
                               */
                               public void setLugarimplante(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localLugarimplanteTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localLugarimplante=param;
                                    

                               }
                            

                        /**
                        * field for Tanestesia
                        */

                        
                                    protected int localTanestesia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTanestesiaTracker = false ;

                           public boolean isTanestesiaSpecified(){
                               return localTanestesiaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getTanestesia(){
                               return localTanestesia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Tanestesia
                               */
                               public void setTanestesia(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localTanestesiaTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localTanestesia=param;
                                    

                               }
                            

                        /**
                        * field for Tipoindicacion
                        */

                        
                                    protected int localTipoindicacion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTipoindicacionTracker = false ;

                           public boolean isTipoindicacionSpecified(){
                               return localTipoindicacionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getTipoindicacion(){
                               return localTipoindicacion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Tipoindicacion
                               */
                               public void setTipoindicacion(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localTipoindicacionTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localTipoindicacion=param;
                                    

                               }
                            

                        /**
                        * field for Primeroperador
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.Personal[] localPrimeroperador ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPrimeroperadorTracker = false ;

                           public boolean isPrimeroperadorSpecified(){
                               return localPrimeroperadorTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.Personal[]
                           */
                           public  com.sorin.idea.integracion.canal.Personal[] getPrimeroperador(){
                               return localPrimeroperador;
                           }

                           
                        


                               
                              /**
                               * validate the array for Primeroperador
                               */
                              protected void validatePrimeroperador(com.sorin.idea.integracion.canal.Personal[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Primeroperador
                              */
                              public void setPrimeroperador(com.sorin.idea.integracion.canal.Personal[] param){
                              
                                   validatePrimeroperador(param);

                               localPrimeroperadorTracker = param != null;
                                      
                                      this.localPrimeroperador=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.Personal
                             */
                             public void addPrimeroperador(com.sorin.idea.integracion.canal.Personal param){
                                   if (localPrimeroperador == null){
                                   localPrimeroperador = new com.sorin.idea.integracion.canal.Personal[]{};
                                   }

                            
                                 //update the setting tracker
                                localPrimeroperadorTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localPrimeroperador);
                               list.add(param);
                               this.localPrimeroperador =
                             (com.sorin.idea.integracion.canal.Personal[])list.toArray(
                            new com.sorin.idea.integracion.canal.Personal[list.size()]);

                             }
                             

                        /**
                        * field for Segundooperador
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.Personal[] localSegundooperador ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSegundooperadorTracker = false ;

                           public boolean isSegundooperadorSpecified(){
                               return localSegundooperadorTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.Personal[]
                           */
                           public  com.sorin.idea.integracion.canal.Personal[] getSegundooperador(){
                               return localSegundooperador;
                           }

                           
                        


                               
                              /**
                               * validate the array for Segundooperador
                               */
                              protected void validateSegundooperador(com.sorin.idea.integracion.canal.Personal[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Segundooperador
                              */
                              public void setSegundooperador(com.sorin.idea.integracion.canal.Personal[] param){
                              
                                   validateSegundooperador(param);

                               localSegundooperadorTracker = param != null;
                                      
                                      this.localSegundooperador=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.Personal
                             */
                             public void addSegundooperador(com.sorin.idea.integracion.canal.Personal param){
                                   if (localSegundooperador == null){
                                   localSegundooperador = new com.sorin.idea.integracion.canal.Personal[]{};
                                   }

                            
                                 //update the setting tracker
                                localSegundooperadorTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localSegundooperador);
                               list.add(param);
                               this.localSegundooperador =
                             (com.sorin.idea.integracion.canal.Personal[])list.toArray(
                            new com.sorin.idea.integracion.canal.Personal[list.size()]);

                             }
                             

                        /**
                        * field for Enfermeria
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.Personal[] localEnfermeria ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEnfermeriaTracker = false ;

                           public boolean isEnfermeriaSpecified(){
                               return localEnfermeriaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.Personal[]
                           */
                           public  com.sorin.idea.integracion.canal.Personal[] getEnfermeria(){
                               return localEnfermeria;
                           }

                           
                        


                               
                              /**
                               * validate the array for Enfermeria
                               */
                              protected void validateEnfermeria(com.sorin.idea.integracion.canal.Personal[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Enfermeria
                              */
                              public void setEnfermeria(com.sorin.idea.integracion.canal.Personal[] param){
                              
                                   validateEnfermeria(param);

                               localEnfermeriaTracker = param != null;
                                      
                                      this.localEnfermeria=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.Personal
                             */
                             public void addEnfermeria(com.sorin.idea.integracion.canal.Personal param){
                                   if (localEnfermeria == null){
                                   localEnfermeria = new com.sorin.idea.integracion.canal.Personal[]{};
                                   }

                            
                                 //update the setting tracker
                                localEnfermeriaTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localEnfermeria);
                               list.add(param);
                               this.localEnfermeria =
                             (com.sorin.idea.integracion.canal.Personal[])list.toArray(
                            new com.sorin.idea.integracion.canal.Personal[list.size()]);

                             }
                             

                        /**
                        * field for Comentarios
                        */

                        
                                    protected java.lang.String localComentarios ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComentariosTracker = false ;

                           public boolean isComentariosSpecified(){
                               return localComentariosTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getComentarios(){
                               return localComentarios;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Comentarios
                               */
                               public void setComentarios(java.lang.String param){
                            localComentariosTracker = param != null;
                                   
                                            this.localComentarios=param;
                                    

                               }
                            

                        /**
                        * field for Complicaciones
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.Complicaciones[] localComplicaciones ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localComplicacionesTracker = false ;

                           public boolean isComplicacionesSpecified(){
                               return localComplicacionesTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.Complicaciones[]
                           */
                           public  com.sorin.idea.integracion.canal.Complicaciones[] getComplicaciones(){
                               return localComplicaciones;
                           }

                           
                        


                               
                              /**
                               * validate the array for Complicaciones
                               */
                              protected void validateComplicaciones(com.sorin.idea.integracion.canal.Complicaciones[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Complicaciones
                              */
                              public void setComplicaciones(com.sorin.idea.integracion.canal.Complicaciones[] param){
                              
                                   validateComplicaciones(param);

                               localComplicacionesTracker = param != null;
                                      
                                      this.localComplicaciones=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.Complicaciones
                             */
                             public void addComplicaciones(com.sorin.idea.integracion.canal.Complicaciones param){
                                   if (localComplicaciones == null){
                                   localComplicaciones = new com.sorin.idea.integracion.canal.Complicaciones[]{};
                                   }

                            
                                 //update the setting tracker
                                localComplicacionesTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localComplicaciones);
                               list.add(param);
                               this.localComplicaciones =
                             (com.sorin.idea.integracion.canal.Complicaciones[])list.toArray(
                            new com.sorin.idea.integracion.canal.Complicaciones[list.size()]);

                             }
                             

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName);
               return factory.createOMElement(dataSource,parentQName);
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"http://canal.integracion.idea.sorin.com");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":HojaImplante",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "HojaImplante",
                           xmlWriter);
                   }

               
                   }
                if (localImplantadorTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "implantador", xmlWriter);
                             
                                               if (localImplantador==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("implantador cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImplantador));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTestinduccionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "testinduccion", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("testinduccion cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTestinduccion));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTestinduccion_energiaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "testinduccion_energia", xmlWriter);
                             

                                          if (localTestinduccion_energia==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("testinduccion_energia cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTestinduccion_energia);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTestinduccion_impedanciaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "testinduccion_impedancia", xmlWriter);
                             

                                          if (localTestinduccion_impedancia==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("testinduccion_impedancia cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTestinduccion_impedancia);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTestinduccion_numchoquesTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "testinduccion_numchoques", xmlWriter);
                             

                                          if (localTestinduccion_numchoques==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("testinduccion_numchoques cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTestinduccion_numchoques);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPrioridadTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "prioridad", xmlWriter);
                             
                                               if (localPrioridad==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("prioridad cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPrioridad));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTescopiaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "tescopia", xmlWriter);
                             

                                          if (localTescopia==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("tescopia cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTescopia);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHllegadaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "hllegada", xmlWriter);
                             

                                          if (localHllegada==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("hllegada cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localHllegada);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHinicioTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "hinicio", xmlWriter);
                             

                                          if (localHinicio==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("hinicio cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localHinicio);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHfinTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "hfin", xmlWriter);
                             

                                          if (localHfin==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("hfin cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localHfin);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHsalidaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "hsalida", xmlWriter);
                             

                                          if (localHsalida==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("hsalida cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localHsalida);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLugarimplanteTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "lugarimplante", xmlWriter);
                             
                                               if (localLugarimplante==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("lugarimplante cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLugarimplante));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTanestesiaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "tanestesia", xmlWriter);
                             
                                               if (localTanestesia==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("tanestesia cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTanestesia));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTipoindicacionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "tipoindicacion", xmlWriter);
                             
                                               if (localTipoindicacion==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("tipoindicacion cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTipoindicacion));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPrimeroperadorTracker){
                                       if (localPrimeroperador!=null){
                                            for (int i = 0;i < localPrimeroperador.length;i++){
                                                if (localPrimeroperador[i] != null){
                                                 localPrimeroperador[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","primeroperador"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("primeroperador cannot be null!!");
                                        
                                    }
                                 } if (localSegundooperadorTracker){
                                       if (localSegundooperador!=null){
                                            for (int i = 0;i < localSegundooperador.length;i++){
                                                if (localSegundooperador[i] != null){
                                                 localSegundooperador[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","segundooperador"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("segundooperador cannot be null!!");
                                        
                                    }
                                 } if (localEnfermeriaTracker){
                                       if (localEnfermeria!=null){
                                            for (int i = 0;i < localEnfermeria.length;i++){
                                                if (localEnfermeria[i] != null){
                                                 localEnfermeria[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","enfermeria"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("enfermeria cannot be null!!");
                                        
                                    }
                                 } if (localComentariosTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "comentarios", xmlWriter);
                             

                                          if (localComentarios==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("comentarios cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localComentarios);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localComplicacionesTracker){
                                       if (localComplicaciones!=null){
                                            for (int i = 0;i < localComplicaciones.length;i++){
                                                if (localComplicaciones[i] != null){
                                                 localComplicaciones[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","complicaciones"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("complicaciones cannot be null!!");
                                        
                                    }
                                 }
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("http://canal.integracion.idea.sorin.com")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace,attName,attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localImplantadorTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "implantador"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImplantador));
                            } if (localTestinduccionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "testinduccion"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTestinduccion));
                            } if (localTestinduccion_energiaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "testinduccion_energia"));
                                 
                                        if (localTestinduccion_energia != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTestinduccion_energia));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("testinduccion_energia cannot be null!!");
                                        }
                                    } if (localTestinduccion_impedanciaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "testinduccion_impedancia"));
                                 
                                        if (localTestinduccion_impedancia != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTestinduccion_impedancia));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("testinduccion_impedancia cannot be null!!");
                                        }
                                    } if (localTestinduccion_numchoquesTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "testinduccion_numchoques"));
                                 
                                        if (localTestinduccion_numchoques != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTestinduccion_numchoques));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("testinduccion_numchoques cannot be null!!");
                                        }
                                    } if (localPrioridadTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "prioridad"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPrioridad));
                            } if (localTescopiaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "tescopia"));
                                 
                                        if (localTescopia != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTescopia));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("tescopia cannot be null!!");
                                        }
                                    } if (localHllegadaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "hllegada"));
                                 
                                        if (localHllegada != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHllegada));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("hllegada cannot be null!!");
                                        }
                                    } if (localHinicioTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "hinicio"));
                                 
                                        if (localHinicio != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHinicio));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("hinicio cannot be null!!");
                                        }
                                    } if (localHfinTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "hfin"));
                                 
                                        if (localHfin != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHfin));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("hfin cannot be null!!");
                                        }
                                    } if (localHsalidaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "hsalida"));
                                 
                                        if (localHsalida != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHsalida));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("hsalida cannot be null!!");
                                        }
                                    } if (localLugarimplanteTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "lugarimplante"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLugarimplante));
                            } if (localTanestesiaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "tanestesia"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTanestesia));
                            } if (localTipoindicacionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "tipoindicacion"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTipoindicacion));
                            } if (localPrimeroperadorTracker){
                             if (localPrimeroperador!=null) {
                                 for (int i = 0;i < localPrimeroperador.length;i++){

                                    if (localPrimeroperador[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "primeroperador"));
                                         elementList.add(localPrimeroperador[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("primeroperador cannot be null!!");
                                    
                             }

                        } if (localSegundooperadorTracker){
                             if (localSegundooperador!=null) {
                                 for (int i = 0;i < localSegundooperador.length;i++){

                                    if (localSegundooperador[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "segundooperador"));
                                         elementList.add(localSegundooperador[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("segundooperador cannot be null!!");
                                    
                             }

                        } if (localEnfermeriaTracker){
                             if (localEnfermeria!=null) {
                                 for (int i = 0;i < localEnfermeria.length;i++){

                                    if (localEnfermeria[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "enfermeria"));
                                         elementList.add(localEnfermeria[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("enfermeria cannot be null!!");
                                    
                             }

                        } if (localComentariosTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "comentarios"));
                                 
                                        if (localComentarios != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComentarios));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("comentarios cannot be null!!");
                                        }
                                    } if (localComplicacionesTracker){
                             if (localComplicaciones!=null) {
                                 for (int i = 0;i < localComplicaciones.length;i++){

                                    if (localComplicaciones[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "complicaciones"));
                                         elementList.add(localComplicaciones[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("complicaciones cannot be null!!");
                                    
                             }

                        }

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static HojaImplante parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            HojaImplante object =
                new HojaImplante();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"HojaImplante".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (HojaImplante)com.sorin.idea.integracion.canal.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                        java.util.ArrayList list15 = new java.util.ArrayList();
                    
                        java.util.ArrayList list16 = new java.util.ArrayList();
                    
                        java.util.ArrayList list17 = new java.util.ArrayList();
                    
                        java.util.ArrayList list19 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","implantador").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"implantador" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImplantador(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setImplantador(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","testinduccion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"testinduccion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTestinduccion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","testinduccion_energia").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"testinduccion_energia" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTestinduccion_energia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","testinduccion_impedancia").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"testinduccion_impedancia" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTestinduccion_impedancia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","testinduccion_numchoques").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"testinduccion_numchoques" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTestinduccion_numchoques(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","prioridad").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"prioridad" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPrioridad(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setPrioridad(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","tescopia").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"tescopia" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTescopia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","hllegada").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"hllegada" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHllegada(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","hinicio").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"hinicio" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHinicio(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","hfin").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"hfin" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHfin(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","hsalida").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"hsalida" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHsalida(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","lugarimplante").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"lugarimplante" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLugarimplante(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setLugarimplante(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","tanestesia").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"tanestesia" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTanestesia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setTanestesia(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","tipoindicacion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"tipoindicacion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTipoindicacion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setTipoindicacion(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","primeroperador").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list15.add(com.sorin.idea.integracion.canal.Personal.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone15 = false;
                                                        while(!loopDone15){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone15 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","primeroperador").equals(reader.getName())){
                                                                    list15.add(com.sorin.idea.integracion.canal.Personal.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone15 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setPrimeroperador((com.sorin.idea.integracion.canal.Personal[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.Personal.class,
                                                                list15));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","segundooperador").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list16.add(com.sorin.idea.integracion.canal.Personal.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone16 = false;
                                                        while(!loopDone16){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone16 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","segundooperador").equals(reader.getName())){
                                                                    list16.add(com.sorin.idea.integracion.canal.Personal.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone16 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setSegundooperador((com.sorin.idea.integracion.canal.Personal[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.Personal.class,
                                                                list16));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","enfermeria").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list17.add(com.sorin.idea.integracion.canal.Personal.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone17 = false;
                                                        while(!loopDone17){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone17 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","enfermeria").equals(reader.getName())){
                                                                    list17.add(com.sorin.idea.integracion.canal.Personal.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone17 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setEnfermeria((com.sorin.idea.integracion.canal.Personal[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.Personal.class,
                                                                list17));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","comentarios").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"comentarios" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setComentarios(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","complicaciones").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list19.add(com.sorin.idea.integracion.canal.Complicaciones.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone19 = false;
                                                        while(!loopDone19){
                                                            // We should be at the end element, but make sure
                                                            while (!reader.isEndElement())
                                                                reader.next();
                                                            // Step out of this element
                                                            reader.next();
                                                            // Step to next element event.
                                                            while (!reader.isStartElement() && !reader.isEndElement())
                                                                reader.next();
                                                            if (reader.isEndElement()){
                                                                //two continuous end elements means we are exiting the xml structure
                                                                loopDone19 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","complicaciones").equals(reader.getName())){
                                                                    list19.add(com.sorin.idea.integracion.canal.Complicaciones.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone19 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setComplicaciones((com.sorin.idea.integracion.canal.Complicaciones[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.Complicaciones.class,
                                                                list19));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    
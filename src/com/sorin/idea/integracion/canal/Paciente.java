
/**
 * Paciente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.sorin.idea.integracion.canal;
            

            /**
            *  Paciente bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Paciente
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = Paciente
                Namespace URI = http://canal.integracion.idea.sorin.com
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for Nuhsa
                        */

                        
                                    protected java.lang.String localNuhsa ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNuhsaTracker = false ;

                           public boolean isNuhsaSpecified(){
                               return localNuhsaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNuhsa(){
                               return localNuhsa;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Nuhsa
                               */
                               public void setNuhsa(java.lang.String param){
                            localNuhsaTracker = param != null;
                                   
                                            this.localNuhsa=param;
                                    

                               }
                            

                        /**
                        * field for Nhc
                        */

                        
                                    protected java.lang.String localNhc ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNhc(){
                               return localNhc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Nhc
                               */
                               public void setNhc(java.lang.String param){
                            
                                            this.localNhc=param;
                                    

                               }
                            

                        /**
                        * field for Nombre
                        */

                        
                                    protected java.lang.String localNombre ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNombreTracker = false ;

                           public boolean isNombreSpecified(){
                               return localNombreTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNombre(){
                               return localNombre;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Nombre
                               */
                               public void setNombre(java.lang.String param){
                            localNombreTracker = param != null;
                                   
                                            this.localNombre=param;
                                    

                               }
                            

                        /**
                        * field for Apellido1
                        */

                        
                                    protected java.lang.String localApellido1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localApellido1Tracker = false ;

                           public boolean isApellido1Specified(){
                               return localApellido1Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getApellido1(){
                               return localApellido1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Apellido1
                               */
                               public void setApellido1(java.lang.String param){
                            localApellido1Tracker = param != null;
                                   
                                            this.localApellido1=param;
                                    

                               }
                            

                        /**
                        * field for Apellido2
                        */

                        
                                    protected java.lang.String localApellido2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localApellido2Tracker = false ;

                           public boolean isApellido2Specified(){
                               return localApellido2Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getApellido2(){
                               return localApellido2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Apellido2
                               */
                               public void setApellido2(java.lang.String param){
                            localApellido2Tracker = param != null;
                                   
                                            this.localApellido2=param;
                                    

                               }
                            

                        /**
                        * field for Sexo
                        */

                        
                                    protected int localSexo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSexoTracker = false ;

                           public boolean isSexoSpecified(){
                               return localSexoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getSexo(){
                               return localSexo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Sexo
                               */
                               public void setSexo(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localSexoTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localSexo=param;
                                    

                               }
                            

                        /**
                        * field for Fechanaci
                        */

                        
                                    protected java.util.Date localFechanaci ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFechanaciTracker = false ;

                           public boolean isFechanaciSpecified(){
                               return localFechanaciTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getFechanaci(){
                               return localFechanaci;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fechanaci
                               */
                               public void setFechanaci(java.util.Date param){
                            localFechanaciTracker = param != null;
                                   
                                            this.localFechanaci=param;
                                    

                               }
                            

                        /**
                        * field for Dni
                        */

                        
                                    protected java.lang.String localDni ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDniTracker = false ;

                           public boolean isDniSpecified(){
                               return localDniTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDni(){
                               return localDni;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Dni
                               */
                               public void setDni(java.lang.String param){
                            localDniTracker = param != null;
                                   
                                            this.localDni=param;
                                    

                               }
                            

                        /**
                        * field for Nss1
                        */

                        
                                    protected java.lang.String localNss1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNss1Tracker = false ;

                           public boolean isNss1Specified(){
                               return localNss1Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNss1(){
                               return localNss1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Nss1
                               */
                               public void setNss1(java.lang.String param){
                            localNss1Tracker = param != null;
                                   
                                            this.localNss1=param;
                                    

                               }
                            

                        /**
                        * field for Direccion
                        */

                        
                                    protected java.lang.String localDireccion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDireccionTracker = false ;

                           public boolean isDireccionSpecified(){
                               return localDireccionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDireccion(){
                               return localDireccion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Direccion
                               */
                               public void setDireccion(java.lang.String param){
                            localDireccionTracker = param != null;
                                   
                                            this.localDireccion=param;
                                    

                               }
                            

                        /**
                        * field for Provincia
                        */

                        
                                    protected java.lang.String localProvincia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProvinciaTracker = false ;

                           public boolean isProvinciaSpecified(){
                               return localProvinciaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getProvincia(){
                               return localProvincia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Provincia
                               */
                               public void setProvincia(java.lang.String param){
                            localProvinciaTracker = param != null;
                                   
                                            this.localProvincia=param;
                                    

                               }
                            

                        /**
                        * field for Poblacion
                        */

                        
                                    protected java.lang.String localPoblacion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPoblacionTracker = false ;

                           public boolean isPoblacionSpecified(){
                               return localPoblacionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPoblacion(){
                               return localPoblacion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Poblacion
                               */
                               public void setPoblacion(java.lang.String param){
                            localPoblacionTracker = param != null;
                                   
                                            this.localPoblacion=param;
                                    

                               }
                            

                        /**
                        * field for Pais
                        */

                        
                                    protected java.lang.String localPais ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPaisTracker = false ;

                           public boolean isPaisSpecified(){
                               return localPaisTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPais(){
                               return localPais;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Pais
                               */
                               public void setPais(java.lang.String param){
                            localPaisTracker = param != null;
                                   
                                            this.localPais=param;
                                    

                               }
                            

                        /**
                        * field for Cp
                        */

                        
                                    protected java.lang.String localCp ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCpTracker = false ;

                           public boolean isCpSpecified(){
                               return localCpTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCp(){
                               return localCp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Cp
                               */
                               public void setCp(java.lang.String param){
                            localCpTracker = param != null;
                                   
                                            this.localCp=param;
                                    

                               }
                            

                        /**
                        * field for Estado
                        */

                        
                                    protected java.lang.String localEstado ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEstadoTracker = false ;

                           public boolean isEstadoSpecified(){
                               return localEstadoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEstado(){
                               return localEstado;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Estado
                               */
                               public void setEstado(java.lang.String param){
                            localEstadoTracker = param != null;
                                   
                                            this.localEstado=param;
                                    

                               }
                            

                        /**
                        * field for Telefono1
                        */

                        
                                    protected java.lang.String localTelefono1 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTelefono1Tracker = false ;

                           public boolean isTelefono1Specified(){
                               return localTelefono1Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTelefono1(){
                               return localTelefono1;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Telefono1
                               */
                               public void setTelefono1(java.lang.String param){
                            localTelefono1Tracker = param != null;
                                   
                                            this.localTelefono1=param;
                                    

                               }
                            

                        /**
                        * field for Telefono2
                        */

                        
                                    protected java.lang.String localTelefono2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTelefono2Tracker = false ;

                           public boolean isTelefono2Specified(){
                               return localTelefono2Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getTelefono2(){
                               return localTelefono2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Telefono2
                               */
                               public void setTelefono2(java.lang.String param){
                            localTelefono2Tracker = param != null;
                                   
                                            this.localTelefono2=param;
                                    

                               }
                            

                        /**
                        * field for Correo
                        */

                        
                                    protected java.lang.String localCorreo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCorreoTracker = false ;

                           public boolean isCorreoSpecified(){
                               return localCorreoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getCorreo(){
                               return localCorreo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Correo
                               */
                               public void setCorreo(java.lang.String param){
                            localCorreoTracker = param != null;
                                   
                                            this.localCorreo=param;
                                    

                               }
                            

                        /**
                        * field for Procedencia
                        */

                        
                                    protected int localProcedencia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localProcedenciaTracker = false ;

                           public boolean isProcedenciaSpecified(){
                               return localProcedenciaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getProcedencia(){
                               return localProcedencia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Procedencia
                               */
                               public void setProcedencia(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localProcedenciaTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localProcedencia=param;
                                    

                               }
                            

                        /**
                        * field for Hprocedencia
                        */

                        
                                    protected int localHprocedencia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHprocedenciaTracker = false ;

                           public boolean isHprocedenciaSpecified(){
                               return localHprocedenciaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getHprocedencia(){
                               return localHprocedencia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hprocedencia
                               */
                               public void setHprocedencia(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localHprocedenciaTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localHprocedencia=param;
                                    

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
                           namespacePrefix+":Paciente",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Paciente",
                           xmlWriter);
                   }

               
                   }
                if (localNuhsaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "nuhsa", xmlWriter);
                             

                                          if (localNuhsa==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("nuhsa cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNuhsa);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "nhc", xmlWriter);
                             

                                          if (localNhc==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("nhc cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNhc);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localNombreTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "nombre", xmlWriter);
                             

                                          if (localNombre==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("nombre cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNombre);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localApellido1Tracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "apellido1", xmlWriter);
                             

                                          if (localApellido1==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("apellido1 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localApellido1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localApellido2Tracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "apellido2", xmlWriter);
                             

                                          if (localApellido2==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("apellido2 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localApellido2);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSexoTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "sexo", xmlWriter);
                             
                                               if (localSexo==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("sexo cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSexo));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFechanaciTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "fechanaci", xmlWriter);
                             

                                          if (localFechanaci==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("fechanaci cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFechanaci));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDniTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "dni", xmlWriter);
                             

                                          if (localDni==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("dni cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDni);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNss1Tracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "nss1", xmlWriter);
                             

                                          if (localNss1==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("nss1 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNss1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDireccionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "direccion", xmlWriter);
                             

                                          if (localDireccion==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("direccion cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDireccion);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localProvinciaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "provincia", xmlWriter);
                             

                                          if (localProvincia==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("provincia cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localProvincia);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPoblacionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "poblacion", xmlWriter);
                             

                                          if (localPoblacion==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("poblacion cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPoblacion);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPaisTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "pais", xmlWriter);
                             

                                          if (localPais==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("pais cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPais);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCpTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "cp", xmlWriter);
                             

                                          if (localCp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("cp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCp);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEstadoTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "estado", xmlWriter);
                             

                                          if (localEstado==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("estado cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEstado);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTelefono1Tracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "telefono1", xmlWriter);
                             

                                          if (localTelefono1==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("telefono1 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTelefono1);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localTelefono2Tracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "telefono2", xmlWriter);
                             

                                          if (localTelefono2==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("telefono2 cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localTelefono2);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCorreoTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "correo", xmlWriter);
                             

                                          if (localCorreo==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("correo cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localCorreo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localProcedenciaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "procedencia", xmlWriter);
                             
                                               if (localProcedencia==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("procedencia cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProcedencia));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHprocedenciaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "hprocedencia", xmlWriter);
                             
                                               if (localHprocedencia==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("hprocedencia cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHprocedencia));
                                               }
                                    
                                   xmlWriter.writeEndElement();
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

                 if (localNuhsaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "nuhsa"));
                                 
                                        if (localNuhsa != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNuhsa));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("nuhsa cannot be null!!");
                                        }
                                    }
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "nhc"));
                                 
                                        if (localNhc != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNhc));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("nhc cannot be null!!");
                                        }
                                     if (localNombreTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "nombre"));
                                 
                                        if (localNombre != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNombre));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("nombre cannot be null!!");
                                        }
                                    } if (localApellido1Tracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "apellido1"));
                                 
                                        if (localApellido1 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localApellido1));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("apellido1 cannot be null!!");
                                        }
                                    } if (localApellido2Tracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "apellido2"));
                                 
                                        if (localApellido2 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localApellido2));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("apellido2 cannot be null!!");
                                        }
                                    } if (localSexoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "sexo"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSexo));
                            } if (localFechanaciTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "fechanaci"));
                                 
                                        if (localFechanaci != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFechanaci));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("fechanaci cannot be null!!");
                                        }
                                    } if (localDniTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "dni"));
                                 
                                        if (localDni != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDni));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("dni cannot be null!!");
                                        }
                                    } if (localNss1Tracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "nss1"));
                                 
                                        if (localNss1 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNss1));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("nss1 cannot be null!!");
                                        }
                                    } if (localDireccionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "direccion"));
                                 
                                        if (localDireccion != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDireccion));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("direccion cannot be null!!");
                                        }
                                    } if (localProvinciaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "provincia"));
                                 
                                        if (localProvincia != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProvincia));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("provincia cannot be null!!");
                                        }
                                    } if (localPoblacionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "poblacion"));
                                 
                                        if (localPoblacion != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPoblacion));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("poblacion cannot be null!!");
                                        }
                                    } if (localPaisTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "pais"));
                                 
                                        if (localPais != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPais));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("pais cannot be null!!");
                                        }
                                    } if (localCpTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "cp"));
                                 
                                        if (localCp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("cp cannot be null!!");
                                        }
                                    } if (localEstadoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "estado"));
                                 
                                        if (localEstado != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEstado));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("estado cannot be null!!");
                                        }
                                    } if (localTelefono1Tracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "telefono1"));
                                 
                                        if (localTelefono1 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTelefono1));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("telefono1 cannot be null!!");
                                        }
                                    } if (localTelefono2Tracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "telefono2"));
                                 
                                        if (localTelefono2 != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localTelefono2));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("telefono2 cannot be null!!");
                                        }
                                    } if (localCorreoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "correo"));
                                 
                                        if (localCorreo != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCorreo));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("correo cannot be null!!");
                                        }
                                    } if (localProcedenciaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "procedencia"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localProcedencia));
                            } if (localHprocedenciaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "hprocedencia"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHprocedencia));
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
        public static Paciente parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Paciente object =
                new Paciente();

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
                    
                            if (!"Paciente".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Paciente)com.sorin.idea.integracion.canal.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","nuhsa").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"nuhsa" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNuhsa(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","nhc").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"nhc" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNhc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","nombre").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"nombre" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNombre(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","apellido1").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"apellido1" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setApellido1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","apellido2").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"apellido2" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setApellido2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","sexo").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"sexo" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSexo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setSexo(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","fechanaci").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"fechanaci" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFechanaci(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","dni").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"dni" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDni(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","nss1").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"nss1" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNss1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","direccion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"direccion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDireccion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","provincia").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"provincia" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProvincia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","poblacion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"poblacion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPoblacion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","pais").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"pais" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPais(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","cp").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"cp" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","estado").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"estado" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEstado(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","telefono1").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"telefono1" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTelefono1(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","telefono2").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"telefono2" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setTelefono2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","correo").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"correo" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCorreo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","procedencia").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"procedencia" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setProcedencia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setProcedencia(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","hprocedencia").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"hprocedencia" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHprocedencia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setHprocedencia(java.lang.Integer.MIN_VALUE);
                                           
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
           
    

/**
 * InInsertarEF.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.sorin.idea.integracion.canal;
            

            /**
            *  InInsertarEF bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class InInsertarEF
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "http://canal.integracion.idea.sorin.com",
                "inInsertarEF",
                "ns1");

            

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
                        * field for Fecha
                        */

                        
                                    protected java.util.Date localFecha ;
                                

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getFecha(){
                               return localFecha;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fecha
                               */
                               public void setFecha(java.util.Date param){
                            
                                            this.localFecha=param;
                                    

                               }
                            

                        /**
                        * field for Situacionclinica
                        */

                        
                                    protected com.sorin.idea.integracion.canal.SituacionClinica localSituacionclinica ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSituacionclinicaTracker = false ;

                           public boolean isSituacionclinicaSpecified(){
                               return localSituacionclinicaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.SituacionClinica
                           */
                           public  com.sorin.idea.integracion.canal.SituacionClinica getSituacionclinica(){
                               return localSituacionclinica;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Situacionclinica
                               */
                               public void setSituacionclinica(com.sorin.idea.integracion.canal.SituacionClinica param){
                            localSituacionclinicaTracker = param != null;
                                   
                                            this.localSituacionclinica=param;
                                    

                               }
                            

                        /**
                        * field for Estudio
                        */

                        
                                    protected com.sorin.idea.integracion.canal.EstudioEF localEstudio ;
                                

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.EstudioEF
                           */
                           public  com.sorin.idea.integracion.canal.EstudioEF getEstudio(){
                               return localEstudio;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Estudio
                               */
                               public void setEstudio(com.sorin.idea.integracion.canal.EstudioEF param){
                            
                                            this.localEstudio=param;
                                    

                               }
                            

                        /**
                        * field for Ecg
                        */

                        
                                    protected com.sorin.idea.integracion.canal.ECGEF localEcg ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEcgTracker = false ;

                           public boolean isEcgSpecified(){
                               return localEcgTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.ECGEF
                           */
                           public  com.sorin.idea.integracion.canal.ECGEF getEcg(){
                               return localEcg;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ecg
                               */
                               public void setEcg(com.sorin.idea.integracion.canal.ECGEF param){
                            localEcgTracker = param != null;
                                   
                                            this.localEcg=param;
                                    

                               }
                            

                        /**
                        * field for Funcionsinusal
                        */

                        
                                    protected com.sorin.idea.integracion.canal.FuncionSinusalEF localFuncionsinusal ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFuncionsinusalTracker = false ;

                           public boolean isFuncionsinusalSpecified(){
                               return localFuncionsinusalTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.FuncionSinusalEF
                           */
                           public  com.sorin.idea.integracion.canal.FuncionSinusalEF getFuncionsinusal(){
                               return localFuncionsinusal;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Funcionsinusal
                               */
                               public void setFuncionsinusal(com.sorin.idea.integracion.canal.FuncionSinusalEF param){
                            localFuncionsinusalTracker = param != null;
                                   
                                            this.localFuncionsinusal=param;
                                    

                               }
                            

                        /**
                        * field for Taquicardias
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.TaquicardiaEF[] localTaquicardias ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTaquicardiasTracker = false ;

                           public boolean isTaquicardiasSpecified(){
                               return localTaquicardiasTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.TaquicardiaEF[]
                           */
                           public  com.sorin.idea.integracion.canal.TaquicardiaEF[] getTaquicardias(){
                               return localTaquicardias;
                           }

                           
                        


                               
                              /**
                               * validate the array for Taquicardias
                               */
                              protected void validateTaquicardias(com.sorin.idea.integracion.canal.TaquicardiaEF[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Taquicardias
                              */
                              public void setTaquicardias(com.sorin.idea.integracion.canal.TaquicardiaEF[] param){
                              
                                   validateTaquicardias(param);

                               localTaquicardiasTracker = param != null;
                                      
                                      this.localTaquicardias=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.TaquicardiaEF
                             */
                             public void addTaquicardias(com.sorin.idea.integracion.canal.TaquicardiaEF param){
                                   if (localTaquicardias == null){
                                   localTaquicardias = new com.sorin.idea.integracion.canal.TaquicardiaEF[]{};
                                   }

                            
                                 //update the setting tracker
                                localTaquicardiasTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localTaquicardias);
                               list.add(param);
                               this.localTaquicardias =
                             (com.sorin.idea.integracion.canal.TaquicardiaEF[])list.toArray(
                            new com.sorin.idea.integracion.canal.TaquicardiaEF[list.size()]);

                             }
                             

                        /**
                        * field for Conduccionav
                        */

                        
                                    protected com.sorin.idea.integracion.canal.ConduccionAVEF localConduccionav ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConduccionavTracker = false ;

                           public boolean isConduccionavSpecified(){
                               return localConduccionavTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.ConduccionAVEF
                           */
                           public  com.sorin.idea.integracion.canal.ConduccionAVEF getConduccionav(){
                               return localConduccionav;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Conduccionav
                               */
                               public void setConduccionav(com.sorin.idea.integracion.canal.ConduccionAVEF param){
                            localConduccionavTracker = param != null;
                                   
                                            this.localConduccionav=param;
                                    

                               }
                            

                        /**
                        * field for Viasaccesorias
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.ViaAccesoriaEF[] localViasaccesorias ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localViasaccesoriasTracker = false ;

                           public boolean isViasaccesoriasSpecified(){
                               return localViasaccesoriasTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.ViaAccesoriaEF[]
                           */
                           public  com.sorin.idea.integracion.canal.ViaAccesoriaEF[] getViasaccesorias(){
                               return localViasaccesorias;
                           }

                           
                        


                               
                              /**
                               * validate the array for Viasaccesorias
                               */
                              protected void validateViasaccesorias(com.sorin.idea.integracion.canal.ViaAccesoriaEF[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Viasaccesorias
                              */
                              public void setViasaccesorias(com.sorin.idea.integracion.canal.ViaAccesoriaEF[] param){
                              
                                   validateViasaccesorias(param);

                               localViasaccesoriasTracker = param != null;
                                      
                                      this.localViasaccesorias=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.ViaAccesoriaEF
                             */
                             public void addViasaccesorias(com.sorin.idea.integracion.canal.ViaAccesoriaEF param){
                                   if (localViasaccesorias == null){
                                   localViasaccesorias = new com.sorin.idea.integracion.canal.ViaAccesoriaEF[]{};
                                   }

                            
                                 //update the setting tracker
                                localViasaccesoriasTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localViasaccesorias);
                               list.add(param);
                               this.localViasaccesorias =
                             (com.sorin.idea.integracion.canal.ViaAccesoriaEF[])list.toArray(
                            new com.sorin.idea.integracion.canal.ViaAccesoriaEF[list.size()]);

                             }
                             

                        /**
                        * field for Periodosrefractarios
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.PeriodoRefractarioEF[] localPeriodosrefractarios ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPeriodosrefractariosTracker = false ;

                           public boolean isPeriodosrefractariosSpecified(){
                               return localPeriodosrefractariosTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.PeriodoRefractarioEF[]
                           */
                           public  com.sorin.idea.integracion.canal.PeriodoRefractarioEF[] getPeriodosrefractarios(){
                               return localPeriodosrefractarios;
                           }

                           
                        


                               
                              /**
                               * validate the array for Periodosrefractarios
                               */
                              protected void validatePeriodosrefractarios(com.sorin.idea.integracion.canal.PeriodoRefractarioEF[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Periodosrefractarios
                              */
                              public void setPeriodosrefractarios(com.sorin.idea.integracion.canal.PeriodoRefractarioEF[] param){
                              
                                   validatePeriodosrefractarios(param);

                               localPeriodosrefractariosTracker = param != null;
                                      
                                      this.localPeriodosrefractarios=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.PeriodoRefractarioEF
                             */
                             public void addPeriodosrefractarios(com.sorin.idea.integracion.canal.PeriodoRefractarioEF param){
                                   if (localPeriodosrefractarios == null){
                                   localPeriodosrefractarios = new com.sorin.idea.integracion.canal.PeriodoRefractarioEF[]{};
                                   }

                            
                                 //update the setting tracker
                                localPeriodosrefractariosTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localPeriodosrefractarios);
                               list.add(param);
                               this.localPeriodosrefractarios =
                             (com.sorin.idea.integracion.canal.PeriodoRefractarioEF[])list.toArray(
                            new com.sorin.idea.integracion.canal.PeriodoRefractarioEF[list.size()]);

                             }
                             

                        /**
                        * field for Complicaciones
                        */

                        
                                    protected com.sorin.idea.integracion.canal.ComplicacionesEF localComplicaciones ;
                                
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
                           * @return com.sorin.idea.integracion.canal.ComplicacionesEF
                           */
                           public  com.sorin.idea.integracion.canal.ComplicacionesEF getComplicaciones(){
                               return localComplicaciones;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Complicaciones
                               */
                               public void setComplicaciones(com.sorin.idea.integracion.canal.ComplicacionesEF param){
                            localComplicacionesTracker = param != null;
                                   
                                            this.localComplicaciones=param;
                                    

                               }
                            

                        /**
                        * field for Intentoablacion
                        */

                        
                                    protected com.sorin.idea.integracion.canal.IntentoAblacionEF localIntentoablacion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIntentoablacionTracker = false ;

                           public boolean isIntentoablacionSpecified(){
                               return localIntentoablacionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.IntentoAblacionEF
                           */
                           public  com.sorin.idea.integracion.canal.IntentoAblacionEF getIntentoablacion(){
                               return localIntentoablacion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Intentoablacion
                               */
                               public void setIntentoablacion(com.sorin.idea.integracion.canal.IntentoAblacionEF param){
                            localIntentoablacionTracker = param != null;
                                   
                                            this.localIntentoablacion=param;
                                    

                               }
                            

                        /**
                        * field for Ablacion
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.AblacionEF[] localAblacion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAblacionTracker = false ;

                           public boolean isAblacionSpecified(){
                               return localAblacionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.AblacionEF[]
                           */
                           public  com.sorin.idea.integracion.canal.AblacionEF[] getAblacion(){
                               return localAblacion;
                           }

                           
                        


                               
                              /**
                               * validate the array for Ablacion
                               */
                              protected void validateAblacion(com.sorin.idea.integracion.canal.AblacionEF[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Ablacion
                              */
                              public void setAblacion(com.sorin.idea.integracion.canal.AblacionEF[] param){
                              
                                   validateAblacion(param);

                               localAblacionTracker = param != null;
                                      
                                      this.localAblacion=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.AblacionEF
                             */
                             public void addAblacion(com.sorin.idea.integracion.canal.AblacionEF param){
                                   if (localAblacion == null){
                                   localAblacion = new com.sorin.idea.integracion.canal.AblacionEF[]{};
                                   }

                            
                                 //update the setting tracker
                                localAblacionTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localAblacion);
                               list.add(param);
                               this.localAblacion =
                             (com.sorin.idea.integracion.canal.AblacionEF[])list.toArray(
                            new com.sorin.idea.integracion.canal.AblacionEF[list.size()]);

                             }
                             

                        /**
                        * field for Cateterdiag
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.CateterEF[] localCateterdiag ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCateterdiagTracker = false ;

                           public boolean isCateterdiagSpecified(){
                               return localCateterdiagTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.CateterEF[]
                           */
                           public  com.sorin.idea.integracion.canal.CateterEF[] getCateterdiag(){
                               return localCateterdiag;
                           }

                           
                        


                               
                              /**
                               * validate the array for Cateterdiag
                               */
                              protected void validateCateterdiag(com.sorin.idea.integracion.canal.CateterEF[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Cateterdiag
                              */
                              public void setCateterdiag(com.sorin.idea.integracion.canal.CateterEF[] param){
                              
                                   validateCateterdiag(param);

                               localCateterdiagTracker = param != null;
                                      
                                      this.localCateterdiag=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.CateterEF
                             */
                             public void addCateterdiag(com.sorin.idea.integracion.canal.CateterEF param){
                                   if (localCateterdiag == null){
                                   localCateterdiag = new com.sorin.idea.integracion.canal.CateterEF[]{};
                                   }

                            
                                 //update the setting tracker
                                localCateterdiagTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localCateterdiag);
                               list.add(param);
                               this.localCateterdiag =
                             (com.sorin.idea.integracion.canal.CateterEF[])list.toArray(
                            new com.sorin.idea.integracion.canal.CateterEF[list.size()]);

                             }
                             

                        /**
                        * field for Regenfermeria
                        */

                        
                                    protected com.sorin.idea.integracion.canal.EnfermeriaEF localRegenfermeria ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRegenfermeriaTracker = false ;

                           public boolean isRegenfermeriaSpecified(){
                               return localRegenfermeriaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.EnfermeriaEF
                           */
                           public  com.sorin.idea.integracion.canal.EnfermeriaEF getRegenfermeria(){
                               return localRegenfermeria;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Regenfermeria
                               */
                               public void setRegenfermeria(com.sorin.idea.integracion.canal.EnfermeriaEF param){
                            localRegenfermeriaTracker = param != null;
                                   
                                            this.localRegenfermeria=param;
                                    

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
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME);
               return factory.createOMElement(dataSource,MY_QNAME);
            
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
                           namespacePrefix+":inInsertarEF",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "inInsertarEF",
                           xmlWriter);
                   }

               
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
                             
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "fecha", xmlWriter);
                             

                                          if (localFecha==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("fecha cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFecha));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                              if (localSituacionclinicaTracker){
                                            if (localSituacionclinica==null){
                                                 throw new org.apache.axis2.databinding.ADBException("situacionclinica cannot be null!!");
                                            }
                                           localSituacionclinica.serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","situacionclinica"),
                                               xmlWriter);
                                        }
                                            if (localEstudio==null){
                                                 throw new org.apache.axis2.databinding.ADBException("estudio cannot be null!!");
                                            }
                                           localEstudio.serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","estudio"),
                                               xmlWriter);
                                         if (localEcgTracker){
                                            if (localEcg==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ecg cannot be null!!");
                                            }
                                           localEcg.serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","ecg"),
                                               xmlWriter);
                                        } if (localFuncionsinusalTracker){
                                            if (localFuncionsinusal==null){
                                                 throw new org.apache.axis2.databinding.ADBException("funcionsinusal cannot be null!!");
                                            }
                                           localFuncionsinusal.serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","funcionsinusal"),
                                               xmlWriter);
                                        } if (localTaquicardiasTracker){
                                       if (localTaquicardias!=null){
                                            for (int i = 0;i < localTaquicardias.length;i++){
                                                if (localTaquicardias[i] != null){
                                                 localTaquicardias[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","taquicardias"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("taquicardias cannot be null!!");
                                        
                                    }
                                 } if (localConduccionavTracker){
                                            if (localConduccionav==null){
                                                 throw new org.apache.axis2.databinding.ADBException("conduccionav cannot be null!!");
                                            }
                                           localConduccionav.serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","conduccionav"),
                                               xmlWriter);
                                        } if (localViasaccesoriasTracker){
                                       if (localViasaccesorias!=null){
                                            for (int i = 0;i < localViasaccesorias.length;i++){
                                                if (localViasaccesorias[i] != null){
                                                 localViasaccesorias[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","viasaccesorias"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("viasaccesorias cannot be null!!");
                                        
                                    }
                                 } if (localPeriodosrefractariosTracker){
                                       if (localPeriodosrefractarios!=null){
                                            for (int i = 0;i < localPeriodosrefractarios.length;i++){
                                                if (localPeriodosrefractarios[i] != null){
                                                 localPeriodosrefractarios[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","periodosrefractarios"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("periodosrefractarios cannot be null!!");
                                        
                                    }
                                 } if (localComplicacionesTracker){
                                            if (localComplicaciones==null){
                                                 throw new org.apache.axis2.databinding.ADBException("complicaciones cannot be null!!");
                                            }
                                           localComplicaciones.serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","complicaciones"),
                                               xmlWriter);
                                        } if (localIntentoablacionTracker){
                                            if (localIntentoablacion==null){
                                                 throw new org.apache.axis2.databinding.ADBException("intentoablacion cannot be null!!");
                                            }
                                           localIntentoablacion.serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","intentoablacion"),
                                               xmlWriter);
                                        } if (localAblacionTracker){
                                       if (localAblacion!=null){
                                            for (int i = 0;i < localAblacion.length;i++){
                                                if (localAblacion[i] != null){
                                                 localAblacion[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","ablacion"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("ablacion cannot be null!!");
                                        
                                    }
                                 } if (localCateterdiagTracker){
                                       if (localCateterdiag!=null){
                                            for (int i = 0;i < localCateterdiag.length;i++){
                                                if (localCateterdiag[i] != null){
                                                 localCateterdiag[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","cateterdiag"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("cateterdiag cannot be null!!");
                                        
                                    }
                                 } if (localRegenfermeriaTracker){
                                            if (localRegenfermeria==null){
                                                 throw new org.apache.axis2.databinding.ADBException("regenfermeria cannot be null!!");
                                            }
                                           localRegenfermeria.serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","regenfermeria"),
                                               xmlWriter);
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

                
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "nhc"));
                                 
                                        if (localNhc != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNhc));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("nhc cannot be null!!");
                                        }
                                    
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "fecha"));
                                 
                                        if (localFecha != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFecha));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("fecha cannot be null!!");
                                        }
                                     if (localSituacionclinicaTracker){
                            elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "situacionclinica"));
                            
                            
                                    if (localSituacionclinica==null){
                                         throw new org.apache.axis2.databinding.ADBException("situacionclinica cannot be null!!");
                                    }
                                    elementList.add(localSituacionclinica);
                                }
                            elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "estudio"));
                            
                            
                                    if (localEstudio==null){
                                         throw new org.apache.axis2.databinding.ADBException("estudio cannot be null!!");
                                    }
                                    elementList.add(localEstudio);
                                 if (localEcgTracker){
                            elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "ecg"));
                            
                            
                                    if (localEcg==null){
                                         throw new org.apache.axis2.databinding.ADBException("ecg cannot be null!!");
                                    }
                                    elementList.add(localEcg);
                                } if (localFuncionsinusalTracker){
                            elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "funcionsinusal"));
                            
                            
                                    if (localFuncionsinusal==null){
                                         throw new org.apache.axis2.databinding.ADBException("funcionsinusal cannot be null!!");
                                    }
                                    elementList.add(localFuncionsinusal);
                                } if (localTaquicardiasTracker){
                             if (localTaquicardias!=null) {
                                 for (int i = 0;i < localTaquicardias.length;i++){

                                    if (localTaquicardias[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "taquicardias"));
                                         elementList.add(localTaquicardias[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("taquicardias cannot be null!!");
                                    
                             }

                        } if (localConduccionavTracker){
                            elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "conduccionav"));
                            
                            
                                    if (localConduccionav==null){
                                         throw new org.apache.axis2.databinding.ADBException("conduccionav cannot be null!!");
                                    }
                                    elementList.add(localConduccionav);
                                } if (localViasaccesoriasTracker){
                             if (localViasaccesorias!=null) {
                                 for (int i = 0;i < localViasaccesorias.length;i++){

                                    if (localViasaccesorias[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "viasaccesorias"));
                                         elementList.add(localViasaccesorias[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("viasaccesorias cannot be null!!");
                                    
                             }

                        } if (localPeriodosrefractariosTracker){
                             if (localPeriodosrefractarios!=null) {
                                 for (int i = 0;i < localPeriodosrefractarios.length;i++){

                                    if (localPeriodosrefractarios[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "periodosrefractarios"));
                                         elementList.add(localPeriodosrefractarios[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("periodosrefractarios cannot be null!!");
                                    
                             }

                        } if (localComplicacionesTracker){
                            elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "complicaciones"));
                            
                            
                                    if (localComplicaciones==null){
                                         throw new org.apache.axis2.databinding.ADBException("complicaciones cannot be null!!");
                                    }
                                    elementList.add(localComplicaciones);
                                } if (localIntentoablacionTracker){
                            elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "intentoablacion"));
                            
                            
                                    if (localIntentoablacion==null){
                                         throw new org.apache.axis2.databinding.ADBException("intentoablacion cannot be null!!");
                                    }
                                    elementList.add(localIntentoablacion);
                                } if (localAblacionTracker){
                             if (localAblacion!=null) {
                                 for (int i = 0;i < localAblacion.length;i++){

                                    if (localAblacion[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "ablacion"));
                                         elementList.add(localAblacion[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("ablacion cannot be null!!");
                                    
                             }

                        } if (localCateterdiagTracker){
                             if (localCateterdiag!=null) {
                                 for (int i = 0;i < localCateterdiag.length;i++){

                                    if (localCateterdiag[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "cateterdiag"));
                                         elementList.add(localCateterdiag[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("cateterdiag cannot be null!!");
                                    
                             }

                        } if (localRegenfermeriaTracker){
                            elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "regenfermeria"));
                            
                            
                                    if (localRegenfermeria==null){
                                         throw new org.apache.axis2.databinding.ADBException("regenfermeria cannot be null!!");
                                    }
                                    elementList.add(localRegenfermeria);
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
        public static InInsertarEF parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            InInsertarEF object =
                new InInsertarEF();

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
                    
                            if (!"inInsertarEF".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (InInsertarEF)com.sorin.idea.integracion.canal.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                        java.util.ArrayList list7 = new java.util.ArrayList();
                    
                        java.util.ArrayList list9 = new java.util.ArrayList();
                    
                        java.util.ArrayList list10 = new java.util.ArrayList();
                    
                        java.util.ArrayList list13 = new java.util.ArrayList();
                    
                        java.util.ArrayList list14 = new java.util.ArrayList();
                    
                                    
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","fecha").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"fecha" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFecha(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","situacionclinica").equals(reader.getName())){
                                
                                                object.setSituacionclinica(com.sorin.idea.integracion.canal.SituacionClinica.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","estudio").equals(reader.getName())){
                                
                                                object.setEstudio(com.sorin.idea.integracion.canal.EstudioEF.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                else{
                                    // A start element we are not expecting indicates an invalid parameter was passed
                                    throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                                }
                            
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","ecg").equals(reader.getName())){
                                
                                                object.setEcg(com.sorin.idea.integracion.canal.ECGEF.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","funcionsinusal").equals(reader.getName())){
                                
                                                object.setFuncionsinusal(com.sorin.idea.integracion.canal.FuncionSinusalEF.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","taquicardias").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list7.add(com.sorin.idea.integracion.canal.TaquicardiaEF.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone7 = false;
                                                        while(!loopDone7){
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
                                                                loopDone7 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","taquicardias").equals(reader.getName())){
                                                                    list7.add(com.sorin.idea.integracion.canal.TaquicardiaEF.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone7 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setTaquicardias((com.sorin.idea.integracion.canal.TaquicardiaEF[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.TaquicardiaEF.class,
                                                                list7));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","conduccionav").equals(reader.getName())){
                                
                                                object.setConduccionav(com.sorin.idea.integracion.canal.ConduccionAVEF.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","viasaccesorias").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list9.add(com.sorin.idea.integracion.canal.ViaAccesoriaEF.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone9 = false;
                                                        while(!loopDone9){
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
                                                                loopDone9 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","viasaccesorias").equals(reader.getName())){
                                                                    list9.add(com.sorin.idea.integracion.canal.ViaAccesoriaEF.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone9 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setViasaccesorias((com.sorin.idea.integracion.canal.ViaAccesoriaEF[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.ViaAccesoriaEF.class,
                                                                list9));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","periodosrefractarios").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list10.add(com.sorin.idea.integracion.canal.PeriodoRefractarioEF.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone10 = false;
                                                        while(!loopDone10){
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
                                                                loopDone10 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","periodosrefractarios").equals(reader.getName())){
                                                                    list10.add(com.sorin.idea.integracion.canal.PeriodoRefractarioEF.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone10 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setPeriodosrefractarios((com.sorin.idea.integracion.canal.PeriodoRefractarioEF[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.PeriodoRefractarioEF.class,
                                                                list10));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","complicaciones").equals(reader.getName())){
                                
                                                object.setComplicaciones(com.sorin.idea.integracion.canal.ComplicacionesEF.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","intentoablacion").equals(reader.getName())){
                                
                                                object.setIntentoablacion(com.sorin.idea.integracion.canal.IntentoAblacionEF.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","ablacion").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list13.add(com.sorin.idea.integracion.canal.AblacionEF.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone13 = false;
                                                        while(!loopDone13){
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
                                                                loopDone13 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","ablacion").equals(reader.getName())){
                                                                    list13.add(com.sorin.idea.integracion.canal.AblacionEF.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone13 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setAblacion((com.sorin.idea.integracion.canal.AblacionEF[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.AblacionEF.class,
                                                                list13));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","cateterdiag").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list14.add(com.sorin.idea.integracion.canal.CateterEF.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone14 = false;
                                                        while(!loopDone14){
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
                                                                loopDone14 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","cateterdiag").equals(reader.getName())){
                                                                    list14.add(com.sorin.idea.integracion.canal.CateterEF.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone14 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setCateterdiag((com.sorin.idea.integracion.canal.CateterEF[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.CateterEF.class,
                                                                list14));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","regenfermeria").equals(reader.getName())){
                                
                                                object.setRegenfermeria(com.sorin.idea.integracion.canal.EnfermeriaEF.Factory.parse(reader));
                                              
                                        reader.next();
                                    
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
           
    
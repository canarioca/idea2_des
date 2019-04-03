
/**
 * ConduccionAVEF.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.sorin.idea.integracion.canal;
            

            /**
            *  ConduccionAVEF bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ConduccionAVEF
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ConduccionAVEF
                Namespace URI = http://canal.integracion.idea.sorin.com
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for Ah
                        */

                        
                                    protected java.lang.String localAh ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAhTracker = false ;

                           public boolean isAhSpecified(){
                               return localAhTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getAh(){
                               return localAh;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ah
                               */
                               public void setAh(java.lang.String param){
                            localAhTracker = param != null;
                                   
                                            this.localAh=param;
                                    

                               }
                            

                        /**
                        * field for Hv
                        */

                        
                                    protected java.lang.String localHv ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHvTracker = false ;

                           public boolean isHvSpecified(){
                               return localHvTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getHv(){
                               return localHv;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hv
                               */
                               public void setHv(java.lang.String param){
                            localHvTracker = param != null;
                                   
                                            this.localHv=param;
                                    

                               }
                            

                        /**
                        * field for Fisiologia
                        */

                        
                                    protected int localFisiologia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFisiologiaTracker = false ;

                           public boolean isFisiologiaSpecified(){
                               return localFisiologiaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getFisiologia(){
                               return localFisiologia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fisiologia
                               */
                               public void setFisiologia(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localFisiologiaTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localFisiologia=param;
                                    

                               }
                            

                        /**
                        * field for Hv2
                        */

                        
                                    protected int localHv2 ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localHv2Tracker = false ;

                           public boolean isHv2Specified(){
                               return localHv2Tracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getHv2(){
                               return localHv2;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Hv2
                               */
                               public void setHv2(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localHv2Tracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localHv2=param;
                                    

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
                        * field for Estimulacioncontinua
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.EstimulacionContinuaEF[] localEstimulacioncontinua ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEstimulacioncontinuaTracker = false ;

                           public boolean isEstimulacioncontinuaSpecified(){
                               return localEstimulacioncontinuaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.EstimulacionContinuaEF[]
                           */
                           public  com.sorin.idea.integracion.canal.EstimulacionContinuaEF[] getEstimulacioncontinua(){
                               return localEstimulacioncontinua;
                           }

                           
                        


                               
                              /**
                               * validate the array for Estimulacioncontinua
                               */
                              protected void validateEstimulacioncontinua(com.sorin.idea.integracion.canal.EstimulacionContinuaEF[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Estimulacioncontinua
                              */
                              public void setEstimulacioncontinua(com.sorin.idea.integracion.canal.EstimulacionContinuaEF[] param){
                              
                                   validateEstimulacioncontinua(param);

                               localEstimulacioncontinuaTracker = param != null;
                                      
                                      this.localEstimulacioncontinua=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.EstimulacionContinuaEF
                             */
                             public void addEstimulacioncontinua(com.sorin.idea.integracion.canal.EstimulacionContinuaEF param){
                                   if (localEstimulacioncontinua == null){
                                   localEstimulacioncontinua = new com.sorin.idea.integracion.canal.EstimulacionContinuaEF[]{};
                                   }

                            
                                 //update the setting tracker
                                localEstimulacioncontinuaTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localEstimulacioncontinua);
                               list.add(param);
                               this.localEstimulacioncontinua =
                             (com.sorin.idea.integracion.canal.EstimulacionContinuaEF[])list.toArray(
                            new com.sorin.idea.integracion.canal.EstimulacionContinuaEF[list.size()]);

                             }
                             

                        /**
                        * field for Pruebasfarma
                        * This was an Array!
                        */

                        
                                    protected com.sorin.idea.integracion.canal.PruebasFarmaEF[] localPruebasfarma ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPruebasfarmaTracker = false ;

                           public boolean isPruebasfarmaSpecified(){
                               return localPruebasfarmaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return com.sorin.idea.integracion.canal.PruebasFarmaEF[]
                           */
                           public  com.sorin.idea.integracion.canal.PruebasFarmaEF[] getPruebasfarma(){
                               return localPruebasfarma;
                           }

                           
                        


                               
                              /**
                               * validate the array for Pruebasfarma
                               */
                              protected void validatePruebasfarma(com.sorin.idea.integracion.canal.PruebasFarmaEF[] param){
                             
                              }


                             /**
                              * Auto generated setter method
                              * @param param Pruebasfarma
                              */
                              public void setPruebasfarma(com.sorin.idea.integracion.canal.PruebasFarmaEF[] param){
                              
                                   validatePruebasfarma(param);

                               localPruebasfarmaTracker = param != null;
                                      
                                      this.localPruebasfarma=param;
                              }

                               
                             
                             /**
                             * Auto generated add method for the array for convenience
                             * @param param com.sorin.idea.integracion.canal.PruebasFarmaEF
                             */
                             public void addPruebasfarma(com.sorin.idea.integracion.canal.PruebasFarmaEF param){
                                   if (localPruebasfarma == null){
                                   localPruebasfarma = new com.sorin.idea.integracion.canal.PruebasFarmaEF[]{};
                                   }

                            
                                 //update the setting tracker
                                localPruebasfarmaTracker = true;
                            

                               java.util.List list =
                            org.apache.axis2.databinding.utils.ConverterUtil.toList(localPruebasfarma);
                               list.add(param);
                               this.localPruebasfarma =
                             (com.sorin.idea.integracion.canal.PruebasFarmaEF[])list.toArray(
                            new com.sorin.idea.integracion.canal.PruebasFarmaEF[list.size()]);

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
                           namespacePrefix+":ConduccionAVEF",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ConduccionAVEF",
                           xmlWriter);
                   }

               
                   }
                if (localAhTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "ah", xmlWriter);
                             

                                          if (localAh==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ah cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localAh);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHvTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "hv", xmlWriter);
                             

                                          if (localHv==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("hv cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localHv);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFisiologiaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "fisiologia", xmlWriter);
                             
                                               if (localFisiologia==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("fisiologia cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFisiologia));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localHv2Tracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "hv2", xmlWriter);
                             
                                               if (localHv2==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("hv2 cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHv2));
                                               }
                                    
                                   xmlWriter.writeEndElement();
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
                             } if (localEstimulacioncontinuaTracker){
                                       if (localEstimulacioncontinua!=null){
                                            for (int i = 0;i < localEstimulacioncontinua.length;i++){
                                                if (localEstimulacioncontinua[i] != null){
                                                 localEstimulacioncontinua[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","estimulacioncontinua"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("estimulacioncontinua cannot be null!!");
                                        
                                    }
                                 } if (localPruebasfarmaTracker){
                                       if (localPruebasfarma!=null){
                                            for (int i = 0;i < localPruebasfarma.length;i++){
                                                if (localPruebasfarma[i] != null){
                                                 localPruebasfarma[i].serialize(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","pruebasfarma"),
                                                           xmlWriter);
                                                } else {
                                                   
                                                        // we don't have to do any thing since minOccures is zero
                                                    
                                                }

                                            }
                                     } else {
                                        
                                               throw new org.apache.axis2.databinding.ADBException("pruebasfarma cannot be null!!");
                                        
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

                 if (localAhTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "ah"));
                                 
                                        if (localAh != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localAh));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ah cannot be null!!");
                                        }
                                    } if (localHvTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "hv"));
                                 
                                        if (localHv != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHv));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("hv cannot be null!!");
                                        }
                                    } if (localFisiologiaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "fisiologia"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFisiologia));
                            } if (localHv2Tracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "hv2"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localHv2));
                            } if (localComentariosTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "comentarios"));
                                 
                                        if (localComentarios != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComentarios));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("comentarios cannot be null!!");
                                        }
                                    } if (localEstimulacioncontinuaTracker){
                             if (localEstimulacioncontinua!=null) {
                                 for (int i = 0;i < localEstimulacioncontinua.length;i++){

                                    if (localEstimulacioncontinua[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "estimulacioncontinua"));
                                         elementList.add(localEstimulacioncontinua[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("estimulacioncontinua cannot be null!!");
                                    
                             }

                        } if (localPruebasfarmaTracker){
                             if (localPruebasfarma!=null) {
                                 for (int i = 0;i < localPruebasfarma.length;i++){

                                    if (localPruebasfarma[i] != null){
                                         elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                          "pruebasfarma"));
                                         elementList.add(localPruebasfarma[i]);
                                    } else {
                                        
                                                // nothing to do
                                            
                                    }

                                 }
                             } else {
                                 
                                        throw new org.apache.axis2.databinding.ADBException("pruebasfarma cannot be null!!");
                                    
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
        public static ConduccionAVEF parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ConduccionAVEF object =
                new ConduccionAVEF();

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
                    
                            if (!"ConduccionAVEF".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ConduccionAVEF)com.sorin.idea.integracion.canal.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                        java.util.ArrayList list6 = new java.util.ArrayList();
                    
                        java.util.ArrayList list7 = new java.util.ArrayList();
                    
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","ah").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ah" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setAh(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","hv").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"hv" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHv(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","fisiologia").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"fisiologia" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFisiologia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFisiologia(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","hv2").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"hv2" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setHv2(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setHv2(java.lang.Integer.MIN_VALUE);
                                           
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","estimulacioncontinua").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list6.add(com.sorin.idea.integracion.canal.EstimulacionContinuaEF.Factory.parse(reader));
                                                                
                                                        //loop until we find a start element that is not part of this array
                                                        boolean loopDone6 = false;
                                                        while(!loopDone6){
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
                                                                loopDone6 = true;
                                                            } else {
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","estimulacioncontinua").equals(reader.getName())){
                                                                    list6.add(com.sorin.idea.integracion.canal.EstimulacionContinuaEF.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone6 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setEstimulacioncontinua((com.sorin.idea.integracion.canal.EstimulacionContinuaEF[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.EstimulacionContinuaEF.class,
                                                                list6));
                                                            
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","pruebasfarma").equals(reader.getName())){
                                
                                    
                                    
                                    // Process the array and step past its final element's end.
                                    list7.add(com.sorin.idea.integracion.canal.PruebasFarmaEF.Factory.parse(reader));
                                                                
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
                                                                if (new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","pruebasfarma").equals(reader.getName())){
                                                                    list7.add(com.sorin.idea.integracion.canal.PruebasFarmaEF.Factory.parse(reader));
                                                                        
                                                                }else{
                                                                    loopDone7 = true;
                                                                }
                                                            }
                                                        }
                                                        // call the converter utility  to convert and set the array
                                                        
                                                        object.setPruebasfarma((com.sorin.idea.integracion.canal.PruebasFarmaEF[])
                                                            org.apache.axis2.databinding.utils.ConverterUtil.convertToArray(
                                                                com.sorin.idea.integracion.canal.PruebasFarmaEF.class,
                                                                list7));
                                                            
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
           
    
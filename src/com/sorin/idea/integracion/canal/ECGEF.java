
/**
 * ECGEF.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.sorin.idea.integracion.canal;
            

            /**
            *  ECGEF bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ECGEF
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ECGEF
                Namespace URI = http://canal.integracion.idea.sorin.com
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for Ritmo
                        */

                        
                                    protected int localRitmo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRitmoTracker = false ;

                           public boolean isRitmoSpecified(){
                               return localRitmoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getRitmo(){
                               return localRitmo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ritmo
                               */
                               public void setRitmo(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localRitmoTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localRitmo=param;
                                    

                               }
                            

                        /**
                        * field for Conduccion
                        */

                        
                                    protected int localConduccion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConduccionTracker = false ;

                           public boolean isConduccionSpecified(){
                               return localConduccionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getConduccion(){
                               return localConduccion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Conduccion
                               */
                               public void setConduccion(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localConduccionTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localConduccion=param;
                                    

                               }
                            

                        /**
                        * field for Conduccionno
                        */

                        
                                    protected int localConduccionno ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localConduccionnoTracker = false ;

                           public boolean isConduccionnoSpecified(){
                               return localConduccionnoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getConduccionno(){
                               return localConduccionno;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Conduccionno
                               */
                               public void setConduccionno(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localConduccionnoTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localConduccionno=param;
                                    

                               }
                            

                        /**
                        * field for Qrs_cond
                        */

                        
                                    protected int localQrs_cond ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localQrs_condTracker = false ;

                           public boolean isQrs_condSpecified(){
                               return localQrs_condTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getQrs_cond(){
                               return localQrs_cond;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Qrs_cond
                               */
                               public void setQrs_cond(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localQrs_condTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localQrs_cond=param;
                                    

                               }
                            

                        /**
                        * field for Qrsno
                        */

                        
                                    protected int localQrsno ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localQrsnoTracker = false ;

                           public boolean isQrsnoSpecified(){
                               return localQrsnoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getQrsno(){
                               return localQrsno;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Qrsno
                               */
                               public void setQrsno(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localQrsnoTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localQrsno=param;
                                    

                               }
                            

                        /**
                        * field for Morfologia
                        */

                        
                                    protected java.lang.String localMorfologia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMorfologiaTracker = false ;

                           public boolean isMorfologiaSpecified(){
                               return localMorfologiaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getMorfologia(){
                               return localMorfologia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Morfologia
                               */
                               public void setMorfologia(java.lang.String param){
                            localMorfologiaTracker = param != null;
                                   
                                            this.localMorfologia=param;
                                    

                               }
                            

                        /**
                        * field for Rr
                        */

                        
                                    protected java.lang.String localRr ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRrTracker = false ;

                           public boolean isRrSpecified(){
                               return localRrTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getRr(){
                               return localRr;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Rr
                               */
                               public void setRr(java.lang.String param){
                            localRrTracker = param != null;
                                   
                                            this.localRr=param;
                                    

                               }
                            

                        /**
                        * field for Pr
                        */

                        
                                    protected java.lang.String localPr ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPrTracker = false ;

                           public boolean isPrSpecified(){
                               return localPrTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPr(){
                               return localPr;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Pr
                               */
                               public void setPr(java.lang.String param){
                            localPrTracker = param != null;
                                   
                                            this.localPr=param;
                                    

                               }
                            

                        /**
                        * field for Qrs
                        */

                        
                                    protected java.lang.String localQrs ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localQrsTracker = false ;

                           public boolean isQrsSpecified(){
                               return localQrsTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getQrs(){
                               return localQrs;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Qrs
                               */
                               public void setQrs(java.lang.String param){
                            localQrsTracker = param != null;
                                   
                                            this.localQrs=param;
                                    

                               }
                            

                        /**
                        * field for Qt
                        */

                        
                                    protected java.lang.String localQt ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localQtTracker = false ;

                           public boolean isQtSpecified(){
                               return localQtTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getQt(){
                               return localQt;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Qt
                               */
                               public void setQt(java.lang.String param){
                            localQtTracker = param != null;
                                   
                                            this.localQt=param;
                                    

                               }
                            

                        /**
                        * field for Qtc
                        */

                        
                                    protected java.lang.String localQtc ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localQtcTracker = false ;

                           public boolean isQtcSpecified(){
                               return localQtcTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getQtc(){
                               return localQtc;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Qtc
                               */
                               public void setQtc(java.lang.String param){
                            localQtcTracker = param != null;
                                   
                                            this.localQtc=param;
                                    

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
                           namespacePrefix+":ECGEF",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ECGEF",
                           xmlWriter);
                   }

               
                   }
                if (localRitmoTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "ritmo", xmlWriter);
                             
                                               if (localRitmo==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("ritmo cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRitmo));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConduccionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "conduccion", xmlWriter);
                             
                                               if (localConduccion==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("conduccion cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConduccion));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localConduccionnoTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "conduccionno", xmlWriter);
                             
                                               if (localConduccionno==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("conduccionno cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConduccionno));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localQrs_condTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "qrs_cond", xmlWriter);
                             
                                               if (localQrs_cond==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("qrs_cond cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQrs_cond));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localQrsnoTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "qrsno", xmlWriter);
                             
                                               if (localQrsno==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("qrsno cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQrsno));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMorfologiaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "morfologia", xmlWriter);
                             

                                          if (localMorfologia==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("morfologia cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localMorfologia);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localRrTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "rr", xmlWriter);
                             

                                          if (localRr==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("rr cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localRr);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPrTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "pr", xmlWriter);
                             

                                          if (localPr==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("pr cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPr);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localQrsTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "qrs", xmlWriter);
                             

                                          if (localQrs==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("qrs cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localQrs);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localQtTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "qt", xmlWriter);
                             

                                          if (localQt==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("qt cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localQt);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localQtcTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "qtc", xmlWriter);
                             

                                          if (localQtc==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("qtc cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localQtc);
                                            
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

                 if (localRitmoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "ritmo"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRitmo));
                            } if (localConduccionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "conduccion"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConduccion));
                            } if (localConduccionnoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "conduccionno"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localConduccionno));
                            } if (localQrs_condTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "qrs_cond"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQrs_cond));
                            } if (localQrsnoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "qrsno"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQrsno));
                            } if (localMorfologiaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "morfologia"));
                                 
                                        if (localMorfologia != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMorfologia));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("morfologia cannot be null!!");
                                        }
                                    } if (localRrTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "rr"));
                                 
                                        if (localRr != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localRr));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("rr cannot be null!!");
                                        }
                                    } if (localPrTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "pr"));
                                 
                                        if (localPr != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPr));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("pr cannot be null!!");
                                        }
                                    } if (localQrsTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "qrs"));
                                 
                                        if (localQrs != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQrs));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("qrs cannot be null!!");
                                        }
                                    } if (localQtTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "qt"));
                                 
                                        if (localQt != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQt));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("qt cannot be null!!");
                                        }
                                    } if (localQtcTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "qtc"));
                                 
                                        if (localQtc != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localQtc));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("qtc cannot be null!!");
                                        }
                                    } if (localComentariosTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "comentarios"));
                                 
                                        if (localComentarios != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localComentarios));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("comentarios cannot be null!!");
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
        public static ECGEF parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ECGEF object =
                new ECGEF();

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
                    
                            if (!"ECGEF".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ECGEF)com.sorin.idea.integracion.canal.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","ritmo").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ritmo" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRitmo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setRitmo(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","conduccion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"conduccion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConduccion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setConduccion(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","conduccionno").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"conduccionno" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setConduccionno(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setConduccionno(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","qrs_cond").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"qrs_cond" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQrs_cond(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setQrs_cond(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","qrsno").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"qrsno" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQrsno(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setQrsno(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","morfologia").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"morfologia" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMorfologia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","rr").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"rr" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setRr(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","pr").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"pr" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPr(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","qrs").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"qrs" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQrs(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","qt").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"qt" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQt(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","qtc").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"qtc" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setQtc(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
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
           
    
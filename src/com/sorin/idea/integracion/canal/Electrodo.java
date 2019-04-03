
/**
 * Electrodo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package com.sorin.idea.integracion.canal;
            

            /**
            *  Electrodo bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Electrodo
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = Electrodo
                Namespace URI = http://canal.integracion.idea.sorin.com
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for Modelo
                        */

                        
                                    protected java.lang.String localModelo ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localModeloTracker = false ;

                           public boolean isModeloSpecified(){
                               return localModeloTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getModelo(){
                               return localModelo;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Modelo
                               */
                               public void setModelo(java.lang.String param){
                            localModeloTracker = param != null;
                                   
                                            this.localModelo=param;
                                    

                               }
                            

                        /**
                        * field for Nserie
                        */

                        
                                    protected java.lang.String localNserie ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNserieTracker = false ;

                           public boolean isNserieSpecified(){
                               return localNserieTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getNserie(){
                               return localNserie;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Nserie
                               */
                               public void setNserie(java.lang.String param){
                            localNserieTracker = param != null;
                                   
                                            this.localNserie=param;
                                    

                               }
                            

                        /**
                        * field for Fabricante
                        */

                        
                                    protected int localFabricante ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFabricanteTracker = false ;

                           public boolean isFabricanteSpecified(){
                               return localFabricanteTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getFabricante(){
                               return localFabricante;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fabricante
                               */
                               public void setFabricante(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localFabricanteTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localFabricante=param;
                                    

                               }
                            

                        /**
                        * field for Localizacion
                        */

                        
                                    protected int localLocalizacion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLocalizacionTracker = false ;

                           public boolean isLocalizacionSpecified(){
                               return localLocalizacionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getLocalizacion(){
                               return localLocalizacion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Localizacion
                               */
                               public void setLocalizacion(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localLocalizacionTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localLocalizacion=param;
                                    

                               }
                            

                        /**
                        * field for Mrecolocacion
                        */

                        
                                    protected int localMrecolocacion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMrecolocacionTracker = false ;

                           public boolean isMrecolocacionSpecified(){
                               return localMrecolocacionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMrecolocacion(){
                               return localMrecolocacion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Mrecolocacion
                               */
                               public void setMrecolocacion(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localMrecolocacionTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localMrecolocacion=param;
                                    

                               }
                            

                        /**
                        * field for Mrecambio
                        */

                        
                                    protected int localMrecambio ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMrecambioTracker = false ;

                           public boolean isMrecambioSpecified(){
                               return localMrecambioTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMrecambio(){
                               return localMrecambio;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Mrecambio
                               */
                               public void setMrecambio(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localMrecambioTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localMrecambio=param;
                                    

                               }
                            

                        /**
                        * field for Mexplante
                        */

                        
                                    protected int localMexplante ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localMexplanteTracker = false ;

                           public boolean isMexplanteSpecified(){
                               return localMexplanteTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getMexplante(){
                               return localMexplante;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Mexplante
                               */
                               public void setMexplante(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localMexplanteTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localMexplante=param;
                                    

                               }
                            

                        /**
                        * field for Ondarpimp
                        */

                        
                                    protected java.lang.String localOndarpimp ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOndarpimpTracker = false ;

                           public boolean isOndarpimpSpecified(){
                               return localOndarpimpTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOndarpimp(){
                               return localOndarpimp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ondarpimp
                               */
                               public void setOndarpimp(java.lang.String param){
                            localOndarpimpTracker = param != null;
                                   
                                            this.localOndarpimp=param;
                                    

                               }
                            

                        /**
                        * field for Umbralvimp
                        */

                        
                                    protected java.lang.String localUmbralvimp ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUmbralvimpTracker = false ;

                           public boolean isUmbralvimpSpecified(){
                               return localUmbralvimpTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getUmbralvimp(){
                               return localUmbralvimp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Umbralvimp
                               */
                               public void setUmbralvimp(java.lang.String param){
                            localUmbralvimpTracker = param != null;
                                   
                                            this.localUmbralvimp=param;
                                    

                               }
                            

                        /**
                        * field for Umbralmsimp
                        */

                        
                                    protected java.lang.String localUmbralmsimp ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUmbralmsimpTracker = false ;

                           public boolean isUmbralmsimpSpecified(){
                               return localUmbralmsimpTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getUmbralmsimp(){
                               return localUmbralmsimp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Umbralmsimp
                               */
                               public void setUmbralmsimp(java.lang.String param){
                            localUmbralmsimpTracker = param != null;
                                   
                                            this.localUmbralmsimp=param;
                                    

                               }
                            

                        /**
                        * field for Slewrate
                        */

                        
                                    protected java.lang.String localSlewrate ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSlewrateTracker = false ;

                           public boolean isSlewrateSpecified(){
                               return localSlewrateTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSlewrate(){
                               return localSlewrate;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Slewrate
                               */
                               public void setSlewrate(java.lang.String param){
                            localSlewrateTracker = param != null;
                                   
                                            this.localSlewrate=param;
                                    

                               }
                            

                        /**
                        * field for Impohmimp
                        */

                        
                                    protected java.lang.String localImpohmimp ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImpohmimpTracker = false ;

                           public boolean isImpohmimpSpecified(){
                               return localImpohmimpTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getImpohmimp(){
                               return localImpohmimp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Impohmimp
                               */
                               public void setImpohmimp(java.lang.String param){
                            localImpohmimpTracker = param != null;
                                   
                                            this.localImpohmimp=param;
                                    

                               }
                            

                        /**
                        * field for Impmsimp
                        */

                        
                                    protected java.lang.String localImpmsimp ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImpmsimpTracker = false ;

                           public boolean isImpmsimpSpecified(){
                               return localImpmsimpTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getImpmsimp(){
                               return localImpmsimp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Impmsimp
                               */
                               public void setImpmsimp(java.lang.String param){
                            localImpmsimpTracker = param != null;
                                   
                                            this.localImpmsimp=param;
                                    

                               }
                            

                        /**
                        * field for Impvimp
                        */

                        
                                    protected java.lang.String localImpvimp ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImpvimpTracker = false ;

                           public boolean isImpvimpSpecified(){
                               return localImpvimpTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getImpvimp(){
                               return localImpvimp;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Impvimp
                               */
                               public void setImpvimp(java.lang.String param){
                            localImpvimpTracker = param != null;
                                   
                                            this.localImpvimp=param;
                                    

                               }
                            

                        /**
                        * field for Estimfrenica
                        */

                        
                                    protected java.lang.String localEstimfrenica ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEstimfrenicaTracker = false ;

                           public boolean isEstimfrenicaSpecified(){
                               return localEstimfrenicaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEstimfrenica(){
                               return localEstimfrenica;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Estimfrenica
                               */
                               public void setEstimfrenica(java.lang.String param){
                            localEstimfrenicaTracker = param != null;
                                   
                                            this.localEstimfrenica=param;
                                    

                               }
                            

                        /**
                        * field for Ondarpev
                        */

                        
                                    protected java.lang.String localOndarpev ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localOndarpevTracker = false ;

                           public boolean isOndarpevSpecified(){
                               return localOndarpevTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getOndarpev(){
                               return localOndarpev;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Ondarpev
                               */
                               public void setOndarpev(java.lang.String param){
                            localOndarpevTracker = param != null;
                                   
                                            this.localOndarpev=param;
                                    

                               }
                            

                        /**
                        * field for Umbralvev
                        */

                        
                                    protected java.lang.String localUmbralvev ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUmbralvevTracker = false ;

                           public boolean isUmbralvevSpecified(){
                               return localUmbralvevTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getUmbralvev(){
                               return localUmbralvev;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Umbralvev
                               */
                               public void setUmbralvev(java.lang.String param){
                            localUmbralvevTracker = param != null;
                                   
                                            this.localUmbralvev=param;
                                    

                               }
                            

                        /**
                        * field for Umbralmsev
                        */

                        
                                    protected java.lang.String localUmbralmsev ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localUmbralmsevTracker = false ;

                           public boolean isUmbralmsevSpecified(){
                               return localUmbralmsevTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getUmbralmsev(){
                               return localUmbralmsev;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Umbralmsev
                               */
                               public void setUmbralmsev(java.lang.String param){
                            localUmbralmsevTracker = param != null;
                                   
                                            this.localUmbralmsev=param;
                                    

                               }
                            

                        /**
                        * field for Impohmev
                        */

                        
                                    protected java.lang.String localImpohmev ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImpohmevTracker = false ;

                           public boolean isImpohmevSpecified(){
                               return localImpohmevTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getImpohmev(){
                               return localImpohmev;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Impohmev
                               */
                               public void setImpohmev(java.lang.String param){
                            localImpohmevTracker = param != null;
                                   
                                            this.localImpohmev=param;
                                    

                               }
                            

                        /**
                        * field for Impmsev
                        */

                        
                                    protected java.lang.String localImpmsev ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImpmsevTracker = false ;

                           public boolean isImpmsevSpecified(){
                               return localImpmsevTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getImpmsev(){
                               return localImpmsev;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Impmsev
                               */
                               public void setImpmsev(java.lang.String param){
                            localImpmsevTracker = param != null;
                                   
                                            this.localImpmsev=param;
                                    

                               }
                            

                        /**
                        * field for Impvev
                        */

                        
                                    protected java.lang.String localImpvev ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localImpvevTracker = false ;

                           public boolean isImpvevSpecified(){
                               return localImpvevTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getImpvev(){
                               return localImpvev;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Impvev
                               */
                               public void setImpvev(java.lang.String param){
                            localImpvevTracker = param != null;
                                   
                                            this.localImpvev=param;
                                    

                               }
                            

                        /**
                        * field for Durimpulso
                        */

                        
                                    protected java.lang.String localDurimpulso ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDurimpulsoTracker = false ;

                           public boolean isDurimpulsoSpecified(){
                               return localDurimpulsoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getDurimpulso(){
                               return localDurimpulso;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Durimpulso
                               */
                               public void setDurimpulso(java.lang.String param){
                            localDurimpulsoTracker = param != null;
                                   
                                            this.localDurimpulso=param;
                                    

                               }
                            

                        /**
                        * field for Voltaje
                        */

                        
                                    protected java.lang.String localVoltaje ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVoltajeTracker = false ;

                           public boolean isVoltajeSpecified(){
                               return localVoltajeTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getVoltaje(){
                               return localVoltaje;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Voltaje
                               */
                               public void setVoltaje(java.lang.String param){
                            localVoltajeTracker = param != null;
                                   
                                            this.localVoltaje=param;
                                    

                               }
                            

                        /**
                        * field for Sensibilidad
                        */

                        
                                    protected java.lang.String localSensibilidad ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSensibilidadTracker = false ;

                           public boolean isSensibilidadSpecified(){
                               return localSensibilidadTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getSensibilidad(){
                               return localSensibilidad;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Sensibilidad
                               */
                               public void setSensibilidad(java.lang.String param){
                            localSensibilidadTracker = param != null;
                                   
                                            this.localSensibilidad=param;
                                    

                               }
                            

                        /**
                        * field for Poldeteccion
                        */

                        
                                    protected java.lang.String localPoldeteccion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPoldeteccionTracker = false ;

                           public boolean isPoldeteccionSpecified(){
                               return localPoldeteccionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPoldeteccion(){
                               return localPoldeteccion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Poldeteccion
                               */
                               public void setPoldeteccion(java.lang.String param){
                            localPoldeteccionTracker = param != null;
                                   
                                            this.localPoldeteccion=param;
                                    

                               }
                            

                        /**
                        * field for Polestimulacion
                        */

                        
                                    protected java.lang.String localPolestimulacion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPolestimulacionTracker = false ;

                           public boolean isPolestimulacionSpecified(){
                               return localPolestimulacionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getPolestimulacion(){
                               return localPolestimulacion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Polestimulacion
                               */
                               public void setPolestimulacion(java.lang.String param){
                            localPolestimulacionTracker = param != null;
                                   
                                            this.localPolestimulacion=param;
                                    

                               }
                            

                        /**
                        * field for Capturaauto
                        */

                        
                                    protected int localCapturaauto ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCapturaautoTracker = false ;

                           public boolean isCapturaautoSpecified(){
                               return localCapturaautoTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getCapturaauto(){
                               return localCapturaauto;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Capturaauto
                               */
                               public void setCapturaauto(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localCapturaautoTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localCapturaauto=param;
                                    

                               }
                            

                        /**
                        * field for Via
                        */

                        
                                    protected int localVia ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localViaTracker = false ;

                           public boolean isViaSpecified(){
                               return localViaTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getVia(){
                               return localVia;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Via
                               */
                               public void setVia(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localViaTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localVia=param;
                                    

                               }
                            

                        /**
                        * field for Lateralidad
                        */

                        
                                    protected int localLateralidad ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localLateralidadTracker = false ;

                           public boolean isLateralidadSpecified(){
                               return localLateralidadTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getLateralidad(){
                               return localLateralidad;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Lateralidad
                               */
                               public void setLateralidad(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localLateralidadTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localLateralidad=param;
                                    

                               }
                            

                        /**
                        * field for Camara
                        */

                        
                                    protected int localCamara ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCamaraTracker = false ;

                           public boolean isCamaraSpecified(){
                               return localCamaraTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getCamara(){
                               return localCamara;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Camara
                               */
                               public void setCamara(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localCamaraTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localCamara=param;
                                    

                               }
                            

                        /**
                        * field for Zonacamara
                        */

                        
                                    protected int localZonacamara ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localZonacamaraTracker = false ;

                           public boolean isZonacamaraSpecified(){
                               return localZonacamaraTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getZonacamara(){
                               return localZonacamara;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Zonacamara
                               */
                               public void setZonacamara(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localZonacamaraTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localZonacamara=param;
                                    

                               }
                            

                        /**
                        * field for Porcion
                        */

                        
                                    protected int localPorcion ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPorcionTracker = false ;

                           public boolean isPorcionSpecified(){
                               return localPorcionTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getPorcion(){
                               return localPorcion;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Porcion
                               */
                               public void setPorcion(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localPorcionTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localPorcion=param;
                                    

                               }
                            

                        /**
                        * field for Estado
                        */

                        
                                    protected int localEstado ;
                                
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
                           * @return int
                           */
                           public  int getEstado(){
                               return localEstado;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Estado
                               */
                               public void setEstado(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localEstadoTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localEstado=param;
                                    

                               }
                            

                        /**
                        * field for Caracter
                        */

                        
                                    protected int localCaracter ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCaracterTracker = false ;

                           public boolean isCaracterSpecified(){
                               return localCaracterTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return int
                           */
                           public  int getCaracter(){
                               return localCaracter;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Caracter
                               */
                               public void setCaracter(int param){
                            
                                       // setting primitive attribute tracker to true
                                       localCaracterTracker =
                                       param != java.lang.Integer.MIN_VALUE;
                                   
                                            this.localCaracter=param;
                                    

                               }
                            

                        /**
                        * field for Fechaimplante
                        */

                        
                                    protected java.util.Date localFechaimplante ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFechaimplanteTracker = false ;

                           public boolean isFechaimplanteSpecified(){
                               return localFechaimplanteTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.util.Date
                           */
                           public  java.util.Date getFechaimplante(){
                               return localFechaimplante;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Fechaimplante
                               */
                               public void setFechaimplante(java.util.Date param){
                            localFechaimplanteTracker = param != null;
                                   
                                            this.localFechaimplante=param;
                                    

                               }
                            

                        /**
                        * field for Vdd
                        */

                        
                                    protected boolean localVdd ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localVddTracker = false ;

                           public boolean isVddSpecified(){
                               return localVddTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return boolean
                           */
                           public  boolean getVdd(){
                               return localVdd;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param Vdd
                               */
                               public void setVdd(boolean param){
                            
                                       // setting primitive attribute tracker to true
                                       localVddTracker =
                                       true;
                                   
                                            this.localVdd=param;
                                    

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
                           namespacePrefix+":Electrodo",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Electrodo",
                           xmlWriter);
                   }

               
                   }
                if (localModeloTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "modelo", xmlWriter);
                             

                                          if (localModelo==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("modelo cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localModelo);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localNserieTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "nserie", xmlWriter);
                             

                                          if (localNserie==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("nserie cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localNserie);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFabricanteTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "fabricante", xmlWriter);
                             
                                               if (localFabricante==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("fabricante cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFabricante));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLocalizacionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "localizacion", xmlWriter);
                             
                                               if (localLocalizacion==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("localizacion cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLocalizacion));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMrecolocacionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "mrecolocacion", xmlWriter);
                             
                                               if (localMrecolocacion==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("mrecolocacion cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMrecolocacion));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMrecambioTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "mrecambio", xmlWriter);
                             
                                               if (localMrecambio==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("mrecambio cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMrecambio));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localMexplanteTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "mexplante", xmlWriter);
                             
                                               if (localMexplante==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("mexplante cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMexplante));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOndarpimpTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "ondarpimp", xmlWriter);
                             

                                          if (localOndarpimp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ondarpimp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOndarpimp);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUmbralvimpTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "umbralvimp", xmlWriter);
                             

                                          if (localUmbralvimp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("umbralvimp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localUmbralvimp);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUmbralmsimpTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "umbralmsimp", xmlWriter);
                             

                                          if (localUmbralmsimp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("umbralmsimp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localUmbralmsimp);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSlewrateTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "slewrate", xmlWriter);
                             

                                          if (localSlewrate==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("slewrate cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSlewrate);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImpohmimpTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "impohmimp", xmlWriter);
                             

                                          if (localImpohmimp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("impohmimp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localImpohmimp);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImpmsimpTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "impmsimp", xmlWriter);
                             

                                          if (localImpmsimp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("impmsimp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localImpmsimp);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImpvimpTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "impvimp", xmlWriter);
                             

                                          if (localImpvimp==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("impvimp cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localImpvimp);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEstimfrenicaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "estimfrenica", xmlWriter);
                             

                                          if (localEstimfrenica==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("estimfrenica cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEstimfrenica);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localOndarpevTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "ondarpev", xmlWriter);
                             

                                          if (localOndarpev==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("ondarpev cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localOndarpev);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUmbralvevTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "umbralvev", xmlWriter);
                             

                                          if (localUmbralvev==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("umbralvev cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localUmbralvev);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localUmbralmsevTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "umbralmsev", xmlWriter);
                             

                                          if (localUmbralmsev==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("umbralmsev cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localUmbralmsev);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImpohmevTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "impohmev", xmlWriter);
                             

                                          if (localImpohmev==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("impohmev cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localImpohmev);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImpmsevTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "impmsev", xmlWriter);
                             

                                          if (localImpmsev==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("impmsev cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localImpmsev);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localImpvevTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "impvev", xmlWriter);
                             

                                          if (localImpvev==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("impvev cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localImpvev);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localDurimpulsoTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "durimpulso", xmlWriter);
                             

                                          if (localDurimpulso==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("durimpulso cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localDurimpulso);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVoltajeTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "voltaje", xmlWriter);
                             

                                          if (localVoltaje==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("voltaje cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localVoltaje);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localSensibilidadTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "sensibilidad", xmlWriter);
                             

                                          if (localSensibilidad==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("sensibilidad cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localSensibilidad);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPoldeteccionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "poldeteccion", xmlWriter);
                             

                                          if (localPoldeteccion==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("poldeteccion cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPoldeteccion);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPolestimulacionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "polestimulacion", xmlWriter);
                             

                                          if (localPolestimulacion==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("polestimulacion cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localPolestimulacion);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCapturaautoTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "capturaauto", xmlWriter);
                             
                                               if (localCapturaauto==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("capturaauto cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCapturaauto));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localViaTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "via", xmlWriter);
                             
                                               if (localVia==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("via cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVia));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localLateralidadTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "lateralidad", xmlWriter);
                             
                                               if (localLateralidad==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("lateralidad cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLateralidad));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCamaraTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "camara", xmlWriter);
                             
                                               if (localCamara==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("camara cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCamara));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localZonacamaraTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "zonacamara", xmlWriter);
                             
                                               if (localZonacamara==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("zonacamara cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localZonacamara));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localPorcionTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "porcion", xmlWriter);
                             
                                               if (localPorcion==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("porcion cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPorcion));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEstadoTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "estado", xmlWriter);
                             
                                               if (localEstado==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("estado cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEstado));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localCaracterTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "caracter", xmlWriter);
                             
                                               if (localCaracter==java.lang.Integer.MIN_VALUE) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("caracter cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCaracter));
                                               }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localFechaimplanteTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "fechaimplante", xmlWriter);
                             

                                          if (localFechaimplante==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("fechaimplante cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFechaimplante));
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localVddTracker){
                                    namespace = "http://canal.integracion.idea.sorin.com";
                                    writeStartElement(null, namespace, "vdd", xmlWriter);
                             
                                               if (false) {
                                           
                                                         throw new org.apache.axis2.databinding.ADBException("vdd cannot be null!!");
                                                      
                                               } else {
                                                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVdd));
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

                 if (localModeloTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "modelo"));
                                 
                                        if (localModelo != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localModelo));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("modelo cannot be null!!");
                                        }
                                    } if (localNserieTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "nserie"));
                                 
                                        if (localNserie != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localNserie));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("nserie cannot be null!!");
                                        }
                                    } if (localFabricanteTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "fabricante"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFabricante));
                            } if (localLocalizacionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "localizacion"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLocalizacion));
                            } if (localMrecolocacionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "mrecolocacion"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMrecolocacion));
                            } if (localMrecambioTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "mrecambio"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMrecambio));
                            } if (localMexplanteTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "mexplante"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localMexplante));
                            } if (localOndarpimpTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "ondarpimp"));
                                 
                                        if (localOndarpimp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOndarpimp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ondarpimp cannot be null!!");
                                        }
                                    } if (localUmbralvimpTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "umbralvimp"));
                                 
                                        if (localUmbralvimp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUmbralvimp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("umbralvimp cannot be null!!");
                                        }
                                    } if (localUmbralmsimpTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "umbralmsimp"));
                                 
                                        if (localUmbralmsimp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUmbralmsimp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("umbralmsimp cannot be null!!");
                                        }
                                    } if (localSlewrateTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "slewrate"));
                                 
                                        if (localSlewrate != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSlewrate));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("slewrate cannot be null!!");
                                        }
                                    } if (localImpohmimpTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "impohmimp"));
                                 
                                        if (localImpohmimp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImpohmimp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("impohmimp cannot be null!!");
                                        }
                                    } if (localImpmsimpTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "impmsimp"));
                                 
                                        if (localImpmsimp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImpmsimp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("impmsimp cannot be null!!");
                                        }
                                    } if (localImpvimpTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "impvimp"));
                                 
                                        if (localImpvimp != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImpvimp));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("impvimp cannot be null!!");
                                        }
                                    } if (localEstimfrenicaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "estimfrenica"));
                                 
                                        if (localEstimfrenica != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEstimfrenica));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("estimfrenica cannot be null!!");
                                        }
                                    } if (localOndarpevTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "ondarpev"));
                                 
                                        if (localOndarpev != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localOndarpev));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("ondarpev cannot be null!!");
                                        }
                                    } if (localUmbralvevTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "umbralvev"));
                                 
                                        if (localUmbralvev != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUmbralvev));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("umbralvev cannot be null!!");
                                        }
                                    } if (localUmbralmsevTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "umbralmsev"));
                                 
                                        if (localUmbralmsev != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localUmbralmsev));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("umbralmsev cannot be null!!");
                                        }
                                    } if (localImpohmevTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "impohmev"));
                                 
                                        if (localImpohmev != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImpohmev));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("impohmev cannot be null!!");
                                        }
                                    } if (localImpmsevTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "impmsev"));
                                 
                                        if (localImpmsev != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImpmsev));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("impmsev cannot be null!!");
                                        }
                                    } if (localImpvevTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "impvev"));
                                 
                                        if (localImpvev != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localImpvev));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("impvev cannot be null!!");
                                        }
                                    } if (localDurimpulsoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "durimpulso"));
                                 
                                        if (localDurimpulso != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localDurimpulso));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("durimpulso cannot be null!!");
                                        }
                                    } if (localVoltajeTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "voltaje"));
                                 
                                        if (localVoltaje != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVoltaje));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("voltaje cannot be null!!");
                                        }
                                    } if (localSensibilidadTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "sensibilidad"));
                                 
                                        if (localSensibilidad != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localSensibilidad));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("sensibilidad cannot be null!!");
                                        }
                                    } if (localPoldeteccionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "poldeteccion"));
                                 
                                        if (localPoldeteccion != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPoldeteccion));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("poldeteccion cannot be null!!");
                                        }
                                    } if (localPolestimulacionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "polestimulacion"));
                                 
                                        if (localPolestimulacion != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPolestimulacion));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("polestimulacion cannot be null!!");
                                        }
                                    } if (localCapturaautoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "capturaauto"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCapturaauto));
                            } if (localViaTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "via"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVia));
                            } if (localLateralidadTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "lateralidad"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localLateralidad));
                            } if (localCamaraTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "camara"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCamara));
                            } if (localZonacamaraTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "zonacamara"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localZonacamara));
                            } if (localPorcionTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "porcion"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localPorcion));
                            } if (localEstadoTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "estado"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEstado));
                            } if (localCaracterTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "caracter"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localCaracter));
                            } if (localFechaimplanteTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "fechaimplante"));
                                 
                                        if (localFechaimplante != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localFechaimplante));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("fechaimplante cannot be null!!");
                                        }
                                    } if (localVddTracker){
                                      elementList.add(new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com",
                                                                      "vdd"));
                                 
                                elementList.add(
                                   org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localVdd));
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
        public static Electrodo parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Electrodo object =
                new Electrodo();

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
                    
                            if (!"Electrodo".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Electrodo)com.sorin.idea.integracion.canal.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","modelo").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"modelo" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setModelo(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","nserie").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"nserie" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setNserie(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","fabricante").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"fabricante" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFabricante(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setFabricante(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","localizacion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"localizacion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLocalizacion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setLocalizacion(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","mrecolocacion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"mrecolocacion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMrecolocacion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMrecolocacion(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","mrecambio").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"mrecambio" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMrecambio(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMrecambio(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","mexplante").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"mexplante" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setMexplante(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setMexplante(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","ondarpimp").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ondarpimp" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOndarpimp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","umbralvimp").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"umbralvimp" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUmbralvimp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","umbralmsimp").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"umbralmsimp" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUmbralmsimp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","slewrate").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"slewrate" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSlewrate(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","impohmimp").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"impohmimp" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImpohmimp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","impmsimp").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"impmsimp" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImpmsimp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","impvimp").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"impvimp" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImpvimp(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","estimfrenica").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"estimfrenica" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEstimfrenica(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","ondarpev").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"ondarpev" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setOndarpev(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","umbralvev").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"umbralvev" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUmbralvev(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","umbralmsev").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"umbralmsev" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setUmbralmsev(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","impohmev").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"impohmev" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImpohmev(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","impmsev").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"impmsev" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImpmsev(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","impvev").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"impvev" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setImpvev(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","durimpulso").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"durimpulso" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setDurimpulso(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","voltaje").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"voltaje" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVoltaje(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","sensibilidad").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"sensibilidad" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setSensibilidad(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","poldeteccion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"poldeteccion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPoldeteccion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","polestimulacion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"polestimulacion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPolestimulacion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","capturaauto").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"capturaauto" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCapturaauto(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setCapturaauto(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","via").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"via" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVia(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setVia(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","lateralidad").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"lateralidad" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setLateralidad(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setLateralidad(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","camara").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"camara" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCamara(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setCamara(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","zonacamara").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"zonacamara" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setZonacamara(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setZonacamara(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","porcion").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"porcion" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setPorcion(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setPorcion(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","estado").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"estado" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEstado(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setEstado(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","caracter").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"caracter" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setCaracter(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                               object.setCaracter(java.lang.Integer.MIN_VALUE);
                                           
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","fechaimplante").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"fechaimplante" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setFechaimplante(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToDate(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("http://canal.integracion.idea.sorin.com","vdd").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"vdd" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setVdd(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToBoolean(content));
                                              
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
           
    
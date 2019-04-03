
/**
 * CanalIntegracionSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
    package com.sorin.idea.integracion.canal;

import com.sorin.idea.integracion.canal.logica.LogicaIntegracion;
    /**
     *  CanalIntegracionSkeleton java skeleton for the axisService
     */
    public class CanalIntegracionSkeleton{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param inInsertarTestATP 
             * @return outInsertarTestATP 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarTestATP insertarTestATP
                  (
                  com.sorin.idea.integracion.canal.InInsertarTestATP inInsertarTestATP
                  )
            {
                	 com.sorin.idea.integracion.canal.OutInsertarTestATP response = new com.sorin.idea.integracion.canal.OutInsertarTestATP();
                	 LogicaIntegracion logica = new LogicaIntegracion();
                	 response.setResultado(logica.insertarTestATP(inInsertarTestATP.getNhc(),inInsertarTestATP.getFecha(),inInsertarTestATP.getSituacionclinica(),
                			 inInsertarTestATP.getEcg(),inInsertarTestATP.getAtp()));
                	 return response;
                //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#insertarTestATP");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param inInsertarEF 
             * @return outInsertarEF 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarEF insertarEF
                  (
                  com.sorin.idea.integracion.canal.InInsertarEF inInsertarEF
                  )
            {
                	 com.sorin.idea.integracion.canal.OutInsertarEF response = new com.sorin.idea.integracion.canal.OutInsertarEF();
                	 LogicaIntegracion logica = new LogicaIntegracion();
                	 response.setResultado(logica.insertarEF(inInsertarEF.getNhc(), inInsertarEF.getFecha(), 
                			 inInsertarEF.getSituacionclinica(), inInsertarEF.getEstudio(), inInsertarEF.getEcg(), 
                			 inInsertarEF.getFuncionsinusal(), inInsertarEF.getTaquicardias(),
                			 inInsertarEF.getConduccionav(), inInsertarEF.getViasaccesorias(), 
                			 inInsertarEF.getPeriodosrefractarios(), inInsertarEF.getComplicaciones(), 
                			 inInsertarEF.getIntentoablacion(), inInsertarEF.getAblacion(),
                			 inInsertarEF.getCateterdiag(),inInsertarEF.getRegenfermeria()));
                	 return response;
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param inInsertarTestFle 
             * @return outInsertarTestFle 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarTestFle insertarTestFle
                  (
                  com.sorin.idea.integracion.canal.InInsertarTestFle inInsertarTestFle
                  )
            {
                	 com.sorin.idea.integracion.canal.OutInsertarTestFle response = new com.sorin.idea.integracion.canal.OutInsertarTestFle();
                	 LogicaIntegracion logica = new LogicaIntegracion();
                	 response.setResultado(logica.insertarTestFLE(inInsertarTestFle.getNhc(),inInsertarTestFle.getFecha(),inInsertarTestFle.getSituacionclinica(),
                			 inInsertarTestFle.getEcg(),inInsertarTestFle.getAtp()));
                	 return response;
                	 
                	 //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#insertarTestFle");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param inInsertarImplante 
             * @return outInsertarImplante 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarImplante insertarImplante
                  (
                  com.sorin.idea.integracion.canal.InInsertarImplante inInsertarImplante
                  )
            {
                	 com.sorin.idea.integracion.canal.OutInsertarImplante response = new com.sorin.idea.integracion.canal.OutInsertarImplante();
                	 LogicaIntegracion logica = new LogicaIntegracion();
                	 response.setResultado(logica.insertarImplante(inInsertarImplante.getNhc(),inInsertarImplante.getTipoprocedimiento(),inInsertarImplante.getFecha(),inInsertarImplante.getSituacionclinica(),
                			 	inInsertarImplante.getGenerador(),inInsertarImplante.getElectrodo(),inInsertarImplante.getHojaimplante(),inInsertarImplante.getEvolucion(),inInsertarImplante.getNproc()));
                	 return response;
                	 
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param inInsertarMesa 
             * @return outInsertarMesa 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarMesa insertarMesa
                  (
                  com.sorin.idea.integracion.canal.InInsertarMesa inInsertarMesa
                  )
            {
                	 com.sorin.idea.integracion.canal.OutInsertarMesa response = new com.sorin.idea.integracion.canal.OutInsertarMesa();
                	 LogicaIntegracion logica = new LogicaIntegracion();
                	 response.setResultado(logica.insertarMesa(inInsertarMesa.getNhc(),inInsertarMesa.getFecha(),inInsertarMesa.getSituacionclinica(),
                			 	inInsertarMesa.getEcg(),inInsertarMesa.getMesa()));
                	 return response;
                	 //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#insertarMesa");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param inInsertarCV 
             * @return outInsertarCV 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarCV insertarCV
                  (
                  com.sorin.idea.integracion.canal.InInsertarCV inInsertarCV
                  )
            {
                	 com.sorin.idea.integracion.canal.OutInsertarCV response = new com.sorin.idea.integracion.canal.OutInsertarCV();
                	 LogicaIntegracion logica = new LogicaIntegracion();
                	 response.setResultado(logica.insertarCV(inInsertarCV.getNhc(), inInsertarCV.getFecha(), inInsertarCV.getCv()));
                	 return response;
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param inInsertarRegistrador 
             * @return outInsertarRegistrador 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarRegistrador insertarRegistrador
                  (
                  com.sorin.idea.integracion.canal.InInsertarRegistrador inInsertarRegistrador
                  )
            {          
                	 com.sorin.idea.integracion.canal.OutInsertarRegistrador response = new com.sorin.idea.integracion.canal.OutInsertarRegistrador();
                	 LogicaIntegracion logica = new LogicaIntegracion();
                	 response.setResultado(logica.insertarRegistrador(inInsertarRegistrador.getNhc(),inInsertarRegistrador.getFecha(),inInsertarRegistrador.getSituacionclinica(),
                			 	inInsertarRegistrador.getEcg(),inInsertarRegistrador.getRegistrador()));
                	 return response;
                	 //TODO : fill this with the necessary business logic
                //throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#insertarRegistrador");
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param inInsertarPaciente 
             * @return outInsertarPaciente 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarPaciente insertarPaciente
                  (
                  com.sorin.idea.integracion.canal.InInsertarPaciente inInsertarPaciente
                  )
            {
                	 com.sorin.idea.integracion.canal.OutInsertarPaciente response = new com.sorin.idea.integracion.canal.OutInsertarPaciente();
                	 LogicaIntegracion logica = new LogicaIntegracion();
                	 response.setResultado(logica.insertarPaciente(inInsertarPaciente.getPaciente(),inInsertarPaciente.getSituacionclinica()));
                	 return response;              	 
        }
     
         
        /**
         * Auto generated method signature
         * 
                                     * @param inInsertarTestEpi 
             * @return outInsertarTestEpi 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarTestEpi insertarTestEpi
                  (
                  com.sorin.idea.integracion.canal.InInsertarTestEpi inInsertarTestEpi
                  )
            {
                //TODO : fill this with the necessary business logic
                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#insertarTestEpi");
        }
		
		 /**
         * Auto generated method signature
         * 
                                     * @param inInsertarSeguimiento 
             * @return outInsertarSeguimiento 
         */
        
                 public com.sorin.idea.integracion.canal.OutInsertarSeguimiento insertarSeguimiento
                  (
                  com.sorin.idea.integracion.canal.InInsertarSeguimiento inInsertarSeguimiento
                  )
            {
                	 com.sorin.idea.integracion.canal.OutInsertarSeguimiento response = new com.sorin.idea.integracion.canal.OutInsertarSeguimiento();
                	 LogicaIntegracion logica = new LogicaIntegracion();
                	 response.setResultado(logica.insertarSeguimiento(inInsertarSeguimiento.getNhc(), inInsertarSeguimiento.getFecha(), 
                			 inInsertarSeguimiento.getTiposeguimiento(), inInsertarSeguimiento.getMotivonoprog(), 
                			 inInsertarSeguimiento.getRemoto(), inInsertarSeguimiento.getOperador(), 
                			 inInsertarSeguimiento.getFechaproximo(), inInsertarSeguimiento.getCaracterproximo(),
                			 inInsertarSeguimiento.getSituacionclinica(), inInsertarSeguimiento.getElectrodo(), 
                			 inInsertarSeguimiento.getSistema(), inInsertarSeguimiento.getBloqueo(), inInsertarSeguimiento.getPorestimulacion(),
                			 inInsertarSeguimiento.getObservacionmp(), inInsertarSeguimiento.getObservaciondai(),
                			 inInsertarSeguimiento.getEvolucion(), inInsertarSeguimiento.getComplicaciones(),
                			 inInsertarSeguimiento.getNseg(),inInsertarSeguimiento.getComentarios()));
                	return response; 
        }
     
         /**
           * Auto generated method signature
           * 
           * @param inInsertarPlanMedicacion 
           * @return outInsertarPlanMedicacion 
         */
                 
               public com.sorin.idea.integracion.canal.OutInsertarPlanMedicacion insertarPlanMedicacion
                 (
                    com.sorin.idea.integracion.canal.InInsertarPlanMedicacion inInsertarPlanMedicacion
                  )
                  {
                        com.sorin.idea.integracion.canal.OutInsertarPlanMedicacion response = new com.sorin.idea.integracion.canal.OutInsertarPlanMedicacion();
                        LogicaIntegracion logica = new LogicaIntegracion();
                        response.setResultado(logica.insertarPlanMedicacion(inInsertarPlanMedicacion.getNhc(), inInsertarPlanMedicacion.getPlanmedicacion()));
                        return response;
                 }
               /**
                * Auto generated method signature
                * 
                                            * @param inInsertarSeguimientoRegistrador 
                    * @return outInsertarSeguimientoRegistrador 
                */
               
                        public com.sorin.idea.integracion.canal.OutInsertarSeguimientoRegistrador insertarSeguimientoRegistrador
                         (
                         com.sorin.idea.integracion.canal.InInsertarSeguimientoRegistrador inInsertarSeguimientoRegistrador
                         )
                   {
                        	com.sorin.idea.integracion.canal.OutInsertarSeguimientoRegistrador response = new com.sorin.idea.integracion.canal.OutInsertarSeguimientoRegistrador();
                        	LogicaIntegracion logica = new LogicaIntegracion();
                        	response.setResultado(logica.insertarSeguimientoRegistrador(inInsertarSeguimientoRegistrador.getNhc(), inInsertarSeguimientoRegistrador.getFecha(), 
                        			inInsertarSeguimientoRegistrador.getSituacionclinica(), inInsertarSeguimientoRegistrador.getSeguimiento()));
                        	return response;
               }
            /**
              * Auto generated method signature
              * 
              * @param inInsertarListaEspera 
               * @return outInsertarListaEspera 
           */
                        
                       public com.sorin.idea.integracion.canal.OutInsertarListaEspera insertarListaEspera
                        (
                          com.sorin.idea.integracion.canal.InInsertarListaEspera inInsertarListaEspera
                        )
                      {
                    	   com.sorin.idea.integracion.canal.OutInsertarListaEspera response = new com.sorin.idea.integracion.canal.OutInsertarListaEspera();
                    	   LogicaIntegracion logica = new LogicaIntegracion();
                    	   response.setResultado(logica.insertarListaEspera(inInsertarListaEspera.getNhc(), inInsertarListaEspera.getListaespera()));
                    	   return response;
                      }
     
    }
    
package com.sorin.idea.iu;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import com.sorin.idea.dto.Plantillas;
import com.sorin.idea.exceptions.PlantillasDaoException;
import com.sorin.idea.servicios.impl.ServicioPlantillasImpl;

import hvn.cm.iu.IUException;
import hvn.cm.modelo.Mensaje;

public class ControlPlantillas extends BaseIU{

	private static final long serialVersionUID = -947158722307842244L;   

	private static Logger logger = Logger.getLogger(ControlPlantillas.class);
	
	private SelectorIdioma si;
	private static ResourceBundle bundle;

	public ControlPlantillas(){  
        try {
              this.si = (SelectorIdioma) getBean("selectorIdioma");
              FacesContext context = FacesContext.getCurrentInstance();
              this.bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), si.getLocale());
        } catch (IUException e) {
              this.pintaMensaje( Mensaje.SEVERIDAD_ERROR, this.bundle.getString("info_msg_error_rec_pat")+": "+ e.getMessage());
        }
	}

	public String cambiarPlantilla( int idPlantilla ) {
  
        try {
              ServicioPlantillasImpl servicioPlantillasImpl = new ServicioPlantillasImpl(this.bundle);
              Plantillas plantilla = servicioPlantillasImpl.obtenerPlantillas( idPlantilla );
        
              if( plantilla != null ) {
                    return plantilla.getDescripcionPlantilla();
              }
        
              return "";
        
        } catch (NumberFormatException e1) {
              logger.error("Error al obtener la descripcion de la plantilla. Motivo: "+ e1.getMessage());
        } catch (PlantillasDaoException e1) {
              logger.error(" Error al obtener la descripcion de la plantilla. Motivo: "+ e1.getMessage());
        }
  
        return null;
	}
}

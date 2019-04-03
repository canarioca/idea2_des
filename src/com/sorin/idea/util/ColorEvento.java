package com.sorin.idea.util;

import java.util.HashMap;
import java.util.Random;

import javax.faces.context.FacesContext;

import org.apache.myfaces.custom.schedule.DefaultScheduleEntryRenderer;
import org.apache.myfaces.custom.schedule.HtmlSchedule;
import org.apache.myfaces.custom.schedule.model.ScheduleEntry;

public class ColorEvento extends DefaultScheduleEntryRenderer{

	private static final long serialVersionUID = -4594648204963119057L;
    private HashMap colors = new HashMap();

    /**
     * Metodo para asignar colores a procedimientos en modulo agenda
     * 
     */
    public String getColor(FacesContext context, HtmlSchedule schedule,
            ScheduleEntry entry, boolean selected)
    {
        if (colors.containsKey(entry.getId()))
            return (String) colors.get(entry.getId());
        StringBuffer color = new StringBuffer();
        int r =0,g =0,b=0;
        if(entry.getTitle().equals("Estudio EF")){
        	r = 230;
        	g = 154;
        	b = 98;
        }else if(entry.getTitle().equals("Implante dispositivo") || entry.getTitle().equals("Recambio dispositivo")
        		|| entry.getTitle().equals("Upgrade dispositivo") || entry.getTitle().equals("Recolocación")
        		|| entry.getTitle().equals("Explante dispositivo") || entry.getTitle().equals("Seguimiento")
        		|| entry.getTitle().equals("Cardioversión eléctrica")){
        	r = 204;
        	g = 126;
        	b = 59;
        }else if(entry.getTitle().equals("Mesa basculante") || entry.getTitle().equals("Registrador de eventos")
        		|| entry.getTitle().equals("Test ATP") || entry.getTitle().equals("Test Epinefrina")
        		|| entry.getTitle().equals("Test Flecainida")){
        	r = 229;
        	g = 183;
        	b = 79;
        }else {
        	r = 127;
        	g = 176;
        	b = 213;
        }        
        //Random random = new Random();
        color.append("rgb(");
        color.append(r);
        color.append(",");
        color.append(g);
        color.append(",");
        color.append(b);
        color.append(")");
        String colorString = color.toString();
        colors.put(entry.getId(), colorString);
        //System.out.println(entry.getSubtitle());
        return colorString;
    }

}

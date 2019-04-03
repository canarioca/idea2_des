package com.sorin.idea.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilFechas
{
    public static String getFechaActual() {
        Calendar calendar = new GregorianCalendar();
        return dateToString(calendar.getTime());
    }
    
    
    public static Timestamp dateToTimestamp(Date date){
        if (date !=null)
            return new java.sql.Timestamp(date.getTime());
        return null;
    }
    
    public static Date TimestampToDate(Timestamp ts){
        if(ts != null)
            return new java.util.Date(ts.getYear(), ts.getMonth(), ts.getDate(), ts.getHours(), ts.getMinutes());
        else
            return null;
    }
    
    public static Date getFecha() {
        Calendar calendar = new GregorianCalendar();
        return calendar.getTime();
    }
    
    public static String getStringDifDias(Date fecha){
        String salida=" ";
       try {
        Calendar fechaActual = new GregorianCalendar();
        Calendar fechaPasada = new GregorianCalendar(1900+fecha.getYear(),1+fecha.getMonth(),1+fecha.getDay());
        
        Integer diffAños = Math.abs(fechaActual.get(Calendar.YEAR) - fechaPasada.get(Calendar.YEAR));
            if (diffAños>0) salida +=diffAños+" año(s), ";
        
        Integer diffMeses = Math.abs(fechaActual.get(Calendar.MONTH) - fechaPasada.get(Calendar.MONTH));
            if (diffMeses>0) salida +=diffMeses+" mes(es), ";
        
        Integer diffdias = Math.abs(fechaActual.get(Calendar.DAY_OF_MONTH) - fechaPasada.get(Calendar.DAY_OF_MONTH));
            if (diffdias>0) salida +=diffdias+" dia(s), ";
       }catch(Exception ex){
           salida ="imposible saber fecha";
       }    
        return salida;
        
    }
    
    
    public static String getHora(){
        Calendar calendario = new GregorianCalendar();
        int hora =calendario.get(Calendar.HOUR_OF_DAY);
        String horaExt;
            if (hora<10) 
                horaExt="0"+hora;
            else 
                horaExt=new Integer(hora).toString();
            
        int minutos = calendario.get(Calendar.MINUTE);
        String minutosExt;
            if (minutos<10) 
                minutosExt="0"+minutos; 
            else 
                minutosExt=new Integer(minutos).toString();
            
        int segundos = calendario.get(Calendar.SECOND);
        String segundosExt;
            if (segundos<10)
                segundosExt="0"+segundos;
            else 
                segundosExt = new Integer(segundos).toString();
       
        return horaExt + ":" + minutosExt + ":" + segundosExt;
    }
    
    public static Date addDate(Date date, int days)
    {
        Calendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(date.getTime());
        calendar.add(Calendar.DATE, days);

        return new Date(calendar.getTimeInMillis());
    }

    public int calcularEdad(Date fecha){
        Calendar fechaNac = Calendar.getInstance();
       
        fechaNac.setTime(fecha);
        
        Calendar today = Calendar.getInstance();
       
        int diff_year = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int diff_month = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diff_day = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        //Si está en ese año pero todavía no los ha cumplido
        if(diff_month<0 || (diff_month==0 && diff_day<0)){
            diff_year = diff_year - 1; //no aparecían los dos guiones del postincremento :|
        }
        return diff_year;
    }
    
    public static float dateDiff(Date date1, Date date2)
    {
        float timeInMillis = date1.getTime() - date2.getTime();
        float days = timeInMillis / 86400000; // 1000 * 60 * 60 * 24
        // No se ha considerado el posible ajuste de un segundo
        // por año (¿es aumento o disminución?, ¿es significativo?)

        return days;
    }

    public static String dateToString(Date d)
    {
    	if(d == null)
    		return "";
         String fecS = "";
         fecS += 1900 + d.getYear() + "/";
        
         int mes = d.getMonth() + 1;
         if (mes < 10)
             fecS += "0" + mes + "/";
         else
             fecS += mes + "/";
        
         if (d.getDate() < 10)
            fecS += "0" + d.getDate();
        else
            fecS += d.getDate() + "";

        
//        fecS += " ";
//        
//        if(d.getHours() < 10)
//        	fecS += "0" + d.getHours() + ":";
//        else
//        	fecS += d.getHours() + ":";
//        
//        if(d.getMinutes() < 10)
//        	fecS += "0" + d.getMinutes() + ":";
//        else
//        	fecS += d.getMinutes() + ":";
//        
//        if(d.getSeconds() < 10)
//        	fecS += "0" + d.getSeconds();
//        else
//        	fecS += d.getSeconds();        
        
        return fecS;
    }
    public static String dateToString2(Date d)
    {
    	if(d == null)
    		return "";
         String fecS = "";
         fecS += 1900 + d.getYear() + "/";
        
         int mes = d.getMonth() + 1;
         if (mes < 10)
             fecS += "0" + mes + "/";
         else
             fecS += mes + "/";
        
         if (d.getDate() < 10)
            fecS += "0" + d.getDate();
        else
            fecS += d.getDate() + "";

        
//        fecS += " ";
//        
//        if(d.getHours() < 10)
//        	fecS += "0" + d.getHours() + ":";
//        else
//        	fecS += d.getHours() + ":";
//        
//        if(d.getMinutes() < 10)
//        	fecS += "0" + d.getMinutes() + ":";
//        else
//        	fecS += d.getMinutes() + ":";
//        
//        if(d.getSeconds() < 10)
//        	fecS += "0" + d.getSeconds();
//        else
//        	fecS += d.getSeconds();        
        
        return fecS;
    }
    public static String dateToStringSinSeparador(Date d)
    {
    	if(d == null)
    		return "";
         String fecS = "";
         fecS += 1900 + d.getYear() + "";
        
         int mes = d.getMonth() + 1;
         if (mes < 10)
             fecS += "0" + mes + "";
         else
             fecS += mes + "";
        
         if (d.getDate() < 10)
            fecS += "0" + d.getDate();
        else
            fecS += d.getDate() + "";

        
//        fecS += " ";
//        
//        if(d.getHours() < 10)
//        	fecS += "0" + d.getHours() + ":";
//        else
//        	fecS += d.getHours() + ":";
//        
//        if(d.getMinutes() < 10)
//        	fecS += "0" + d.getMinutes() + ":";
//        else
//        	fecS += d.getMinutes() + ":";
//        
//        if(d.getSeconds() < 10)
//        	fecS += "0" + d.getSeconds();
//        else
//        	fecS += d.getSeconds();        
        
        return fecS;
    }
    public static String dateToStringSp(Date d)
    {
    	if(d == null)
    		return "";
         String fecS = "";
         
         if (d.getDate() < 10)
             fecS += "0" + d.getDate() + "/";
         else
             fecS += d.getDate() + "/";
         
         int mes = d.getMonth() + 1;
         if (mes < 10)
             fecS += "0" + mes + "/";
         else
             fecS += mes + "/";
        
         fecS += 1900 + d.getYear();
        
        return fecS;
    }

    public static String dateToString(Timestamp d)
    {
         String fecS = "";
        if (d.getDate() < 10)
            fecS = "0" + d.getDate() + "/";
        else
            fecS = d.getDate() + "/";
        
        int mes = d.getMonth() + 1;

        if (mes < 10)
            fecS += "0" + mes + "/";
        else
            fecS += mes + "/";

        fecS += 1900 + d.getYear()+" ";
        
        if (d.getHours() < 10)
            fecS += "0" + d.getHours() + ":";
        else
            fecS += d.getHours() + ":";
        
        if (d.getMinutes() < 10)
            fecS += "0" + d.getMinutes();
        else
            fecS += d.getMinutes();     

        return fecS;
    }

    
    public static String diaToString(Date d){
    	String diaS="";
        if (d.getDate() < 10) 
        	diaS = "0" + d.getDate();
        else
        	diaS += d.getDate();
        
        return diaS;
    }
    public static String mesToString(Date d){
    	String mesS="";
    	int mes = d.getMonth() + 1;
    	
        if (mes < 10) 
        	mesS = "0" + mes;
        else
        	mesS += mes;
        
        return mesS;
    }
    public static String anioToString(Date d){
    	String anioS="";

    	anioS += 1900+d.getYear();
        
        return anioS;
    }
    public static String horaToString(Date d){
    	String horaS="";
        if (d.getHours() < 10) 
            horaS = "0" + d.getHours();
        else
        	horaS += d.getHours();
        
        return horaS;
    }
    
    public static String horaMinutoToString(Date d){
    	String horaS="";
        if (d.getHours() < 10) 
            horaS = "0" + d.getHours()+":";
        else
        	horaS = d.getHours()+":";
        
        if (d.getMinutes() < 10) 
            horaS += "0" + d.getMinutes();
        else
        	horaS += d.getMinutes();
        
        return horaS;
    }
    
    public static String minutoToString(Date d){
    	String minutoS="";
        
        if (d.getMinutes() <10)
        	minutoS += "0" + d.getMinutes();
        else
        	minutoS += d.getMinutes();
        
        return minutoS;
    }
    
    public static Date StringToDate(String d)
    {
          try {
           SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy hh:mm" );
           return sdf.parse( d );
       }catch(ParseException ex){
          try {
              SimpleDateFormat sdf = new SimpleDateFormat( "dd-MM-yyyy hh:mm" );
              return sdf.parse( d );
          }catch(ParseException ex2) {
           
           return getFecha();
       }
       }
    }
    
    public static Date HoraToDate(String d)
    {
          try {
           SimpleDateFormat sdf = new SimpleDateFormat( "hh:mm" );
           return sdf.parse( d );
       }catch(ParseException ex){
          try {
              SimpleDateFormat sdf = new SimpleDateFormat( "hh:mm" );
              return sdf.parse( d );
          }catch(ParseException ex2) {
           
           return getFecha();
       }
       }
    }
    
    public static String horaToString(String h){
        if (h.length() == 1) 
            return "0"+h;
        else 
            return h;
    }
    
    public static String minutoToString(String h){
        if (h.length() == 1) 
            return "0"+h;
        else 
            return h;
    }

//    public static int getEdad(Date fechaNacimiento)
//    {
//        Calendar today = Calendar.getInstance();
//        
//        int diff_year = today.get(Calendar.YEAR) - fechaNacimiento.getYear();
//        int diff_month = today.get(Calendar.MONTH) - fechaNacimiento.getMonth();
//        int diff_day = today.get(Calendar.DAY_OF_MONTH) - fechaNacimiento.getDay();
//
//        //Si está en ese año pero todavía no los ha cumplido
//        if(diff_month<0 || (diff_month==0 && diff_day<0)){
//            diff_year = diff_year - 1; //no aparecían los dos guiones del postincremento :|
//        }
//        return diff_year - 1900;
//    }
    
    public static int getEdad(Date fechaNacimiento){
        Date hoy = UtilFechas.getFecha();
        
        int dif_ano = hoy.getYear() - fechaNacimiento.getYear();
        int dif_mes = hoy.getMonth() - fechaNacimiento.getMonth();
        if(dif_mes < 0){
            dif_ano -= 1;
        }else if(dif_mes == 0){
            int dif_day = hoy.getDate() - fechaNacimiento.getDate();
            if(dif_day < 0)
                dif_ano -= 1;
        }
        return dif_ano;
    }
 
    public static boolean AbarcaCita(java.util.Date fecha,java.util.Date lim_inferior,java.util.Date lim_superior) {
        try {
            if (fecha.after(lim_inferior) && fecha.before(lim_superior)) return true;
            if (fecha.getYear()==lim_inferior.getYear() && fecha.getMonth()==lim_inferior.getMonth() && fecha.getDate()==lim_inferior.getDate()) return true;
            if (fecha.getYear()==lim_superior.getYear() && fecha.getMonth()==lim_superior.getMonth() && fecha.getDate()==lim_superior.getDate()) return true;
        }catch(Exception ex){
            return false;
        }
            
            
        return false;
        
    }

    public static String dateDiffms(Date date1, Date date2)
    {
        float timeInMillis = date1.getTime() - date2.getTime();
        float days = timeInMillis/(24*60*60*1000);
        Integer dias = (int) days;
        float hours = (days - dias)*24;
        Integer horas = (int) hours;
        float minutes = (hours - horas)*60;
        Integer minutos = (int) minutes;
        float second = (minutes - minutos)*60;
        Integer segundos = (int) second;
        String total = "";
        if(horas > 0){
        	if(horas < 10)
        		total += "0" + horas + " h ";
        	else
        		total += horas + " h ";
        }else
        	total += "00 h ";
        if(minutos > 0){
        	if(minutos < 10)
        		total += "0" + minutos + " m";
        	else
        		total += minutos + " m";
        }else
        	total += "00 m";
        return total;
    }
    public static String dateHL7StringToDateString(String hl7){
		if(hl7==null)
			return null;
		else
			return hl7.substring(0, 4)+"-"+hl7.substring(4, 6)+"-"+hl7.substring(6,8);					
	}
    public static Date StringToDate2(String d)
    {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = formatoDelTexto.parse(d);		
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return fecha;
    }
    public static String getFechaString(Date f) {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(f);
    }
    public static String getFechaString2(Date f) {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        return formateador.format(f);
    }
    public static Date sumarRestarDiasFecha(Date fecha, int dias){
    	Calendar calendar = Calendar.getInstance();
    	calendar.setTime(fecha); // Configuramos la fecha que se recibe
    	calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
    	return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
	}
    public static String getFechaStringFormato(Date f, String formato) {
    	if(f==null)
    		return "";
        SimpleDateFormat formateador = new SimpleDateFormat(formato);
        return formateador.format(f);
    }
    public static Date StringToDateFormato(String d, String formato)
    {
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat(formato);
		Date fecha = null;
		try {
			fecha = formatoDelTexto.parse(d);		
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return fecha;
    }
    
    public static String adaptaHoras(String in){
    	if(in!=null && !in.equals("")){
    		if(in.length()==1)
    			return "0"+in;
    	}
    	return in;
    }
    
    public static Date sumaDuracion(Date fecha,int duracion,String unidad){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); // Configuramos la fecha que se recibe
		// Se discrimina por unidad
		int un=0;
		if(unidad.equals("min")){
			un = Calendar.MINUTE;
		}else if(unidad.equals("h")){
			un = Calendar.HOUR;
		}else if(unidad.equals("mes")){
			un = Calendar.MONTH;
		}
		calendar.add(un, duracion);  // numero de horas a añadir, o restar en caso de horas<0
		return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas
	}
    
    /*Metodo que calcula la diferencia de los minutos entre dos fechas */ 
    public static long diferenciaMinutos(Date fechaini ,Date fechafin){  
    	Calendar fechaInicial = Calendar.getInstance();
    	Calendar fechaFinal = Calendar.getInstance();
    	fechaInicial.setTime(fechaini);
    	fechaFinal.setTime(fechafin);
    	long diferenciaHoras=0; 
    	diferenciaHoras=(fechaFinal.get(Calendar.MINUTE)-fechaInicial.get(Calendar.MINUTE)); 
    	return diferenciaHoras; 
    }
    /*Metodo que calcula la diferencia de los DIAS entre dos fechas */ 
    public static long diferenciaDias(Date fechaini ,Date fechafin){  
    	Calendar fechaInicial = Calendar.getInstance();
    	Calendar fechaFinal = Calendar.getInstance();
    	fechaInicial.setTime(fechaini);
    	fechaFinal.setTime(fechafin);
    	long diferenciaHoras=0; 
    	diferenciaHoras=(fechaFinal.get(Calendar.DAY_OF_YEAR)-fechaInicial.get(Calendar.DAY_OF_YEAR)); 
    	return diferenciaHoras; 
    }
    /*Metodo que devuelve el Numero total de minutos que hay entre las dos Fechas */ 
    public static long cantidadTotalMinutos(Date fechaini ,Date fechafin){  
    	long totalMinutos=0; 
    	Calendar fechaInicial = Calendar.getInstance();
    	Calendar fechaFinal = Calendar.getInstance();
    	fechaInicial.setTime(fechaini);
    	fechaFinal.setTime(fechafin);
    	totalMinutos=((fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/1000/60); 
    	return totalMinutos; 
    }
    public static boolean esEventoDiario(Date fechaini, Date fechafin){
		if(fechaini!=null && fechafin!=null)
			return cantidadTotalMinutos(fechaini,fechafin)==1439;
		else
			return false;
	}
    
    public static Date getInicioSemana(Date d){
		Calendar calendarioActual = Calendar.getInstance(); 
		calendarioActual.setTime(d); 
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, 2);
		cal.set(Calendar.HOUR_OF_DAY,calendarioActual.getActualMinimum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE,calendarioActual.getActualMinimum(Calendar.MINUTE));
		cal.set(Calendar.SECOND,calendarioActual.getActualMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND,calendarioActual.getActualMinimum(Calendar.MILLISECOND));
		cal.set(Calendar.WEEK_OF_YEAR, calendarioActual.get(Calendar.WEEK_OF_YEAR));
		
		return cal.getTime();	
	}
	
	public static Date getInicioMes(Date d){
		Calendar calendarioActual = Calendar.getInstance(); 
		calendarioActual.setTime(d); 
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, calendarioActual.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY,calendarioActual.getActualMinimum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE,calendarioActual.getActualMinimum(Calendar.MINUTE));
		cal.set(Calendar.SECOND,calendarioActual.getActualMinimum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND,calendarioActual.getActualMinimum(Calendar.MILLISECOND));
		cal.set(Calendar.MONTH, calendarioActual.get(Calendar.MONTH));
		
		return cal.getTime();	
	}
	
	public static Date getFinSemana(Date d){
		Calendar calendarioActual = Calendar.getInstance(); 
		calendarioActual.setTime(d); 
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, 1);// En calendar el dia 1 es Domingo
		cal.set(Calendar.HOUR_OF_DAY,calendarioActual.getActualMaximum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE,calendarioActual.getActualMaximum(Calendar.MINUTE));
		cal.set(Calendar.SECOND,calendarioActual.getActualMaximum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND,calendarioActual.getActualMaximum(Calendar.MILLISECOND));
		cal.set(Calendar.WEEK_OF_YEAR, calendarioActual.get(Calendar.WEEK_OF_YEAR));
		
		return cal.getTime();	
	}
	
	public static Date getFinMes(Date d){
		Calendar calendarioActual = Calendar.getInstance(); 
		calendarioActual.setTime(d); 
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, calendarioActual.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY,calendarioActual.getActualMaximum(Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE,calendarioActual.getActualMaximum(Calendar.MINUTE));
		cal.set(Calendar.SECOND,calendarioActual.getActualMaximum(Calendar.SECOND));
		cal.set(Calendar.MILLISECOND,calendarioActual.getActualMaximum(Calendar.MILLISECOND));
		cal.set(Calendar.MONTH, calendarioActual.get(Calendar.MONTH));
		
		return cal.getTime();	
	}
	
	public static String getDiaMes(Date d){
		Calendar calendarioActual = Calendar.getInstance(); 
		calendarioActual.setTime(d);
		return String.valueOf(calendarioActual.get(Calendar.DAY_OF_MONTH));
	}
	
	public static String getDiaSemanaString(Date d){
		Calendar calendarioActual = Calendar.getInstance(); 
		calendarioActual.setTime(d);
		if(calendarioActual.get(Calendar.DAY_OF_WEEK)==1)
			return "Domingo";
		else if(calendarioActual.get(Calendar.MONTH)==2)
			return "Lunes";
		else if(calendarioActual.get(Calendar.MONTH)==3)
			return "Martes";
		else if(calendarioActual.get(Calendar.MONTH)==4)
			return "Miercoles";
		else if(calendarioActual.get(Calendar.MONTH)==5)
			return "Jueves";
		else if(calendarioActual.get(Calendar.MONTH)==6)
			return "Viernes";
		else if(calendarioActual.get(Calendar.MONTH)==7)
			return "Sabado";
		else
			return null;
	}
	
	public static String getHora(Date d){
		Calendar calendarioActual = Calendar.getInstance(); 
		calendarioActual.setTime(d);
		return String.valueOf(calendarioActual.get(Calendar.HOUR_OF_DAY));
	}
	
	public static String getMinuto(Date d){
		Calendar calendarioActual = Calendar.getInstance(); 
		calendarioActual.setTime(d);
		return String.valueOf(calendarioActual.get(Calendar.MINUTE));
	}
	
	public static String getMesString(Date d){
		Calendar calendarioActual = Calendar.getInstance(); 
		calendarioActual.setTime(d);
		if(calendarioActual.get(Calendar.MONTH)==0)
			return "Enero";
		else if(calendarioActual.get(Calendar.MONTH)==1)
			return "Febrero";
		else if(calendarioActual.get(Calendar.MONTH)==2)
			return "Marzo";
		else if(calendarioActual.get(Calendar.MONTH)==3)
			return "Abril";
		else if(calendarioActual.get(Calendar.MONTH)==4)
			return "Mayo";
		else if(calendarioActual.get(Calendar.MONTH)==5)
			return "Junio";
		else if(calendarioActual.get(Calendar.MONTH)==6)
			return "Julio";
		else if(calendarioActual.get(Calendar.MONTH)==7)
			return "Agosto";
		else if(calendarioActual.get(Calendar.MONTH)==8)
			return "Septiembre";
		else if(calendarioActual.get(Calendar.MONTH)==9)
			return "Octubre";
		else if(calendarioActual.get(Calendar.MONTH)==10)
			return "Noviembre";
		else if(calendarioActual.get(Calendar.MONTH)==11)
			return "Diciembre";
		else
			return null;
	}
}

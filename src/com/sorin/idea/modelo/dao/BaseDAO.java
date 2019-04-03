package com.sorin.idea.modelo.dao;


/**
 * Clase base para los objetos DAO.
 * 
 * @author José Sevilla
 */
public abstract class BaseDAO {
    // fichero para el cual se cargan las propiedades
    protected static String       ficheroPropiedades = "hvn/apl/jProyecto2011/modelo/dao/dao.properties";

    /**
     * Inicializa la clase con la información del fichero de propiedades.
     */
    protected void inicializa() {
        configuracionFicheroProperties(ficheroPropiedades);
    }

    /**
     * Libera la memoria ocupada con lista y datos precargados.
     */
    protected abstract void limpiar();

    /**
     * Reinicia la dos datos de la clase.
     */
    public void reiniciar() {
        limpiar();
        inicializa();
    }

    /**
     * Obtiene una configuración por fichero de propiedades.
     * 
     * @param fichero de propiedades.
     * @throws ServicioException
     */
    public static void configuracionFicheroProperties(String fileName) // throws ServicioException
    {
/*        String cad;
        try {
            InputStream inputStream = BaseDAO.class.getClassLoader().getResourceAsStream(fileName);
            PropertyResourceBundle bundle = new PropertyResourceBundle(inputStream);

            // propiedad para realizar precarga.
            cad = bundle.getString("dao.precarga.datos").trim();
            if (cad != null && !cad.isEmpty())
                precargaDatos = cad.equals("S");

        }
        catch (IOException e) {
            // throw new ServicioException( "ServicioPeticion.siguienteCodigoPeticion: " + e.getMessage(), e);
        }
    */
    }

}

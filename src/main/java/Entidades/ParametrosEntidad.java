package Entidades;

/**
 * Representa un parámetro de evaluación asociado a una prueba de análisis.
 *
 * @author Jack Murrieta
 */
public class ParametrosEntidad {

    private int idParametroEvaluacion;
    private String nombre;
    private String rango;
    private int idPruebaAnalisis;

    /**
     * Constructor para crear un nuevo parámetro de evaluación sin ID asignado.
     *
     * @param nombre Nombre del parámetro.
     * @param rango Rango de valores del parámetro.
     * @param idPruebaAnalisis ID de la prueba de análisis a la que pertenece.
     */
    public ParametrosEntidad(String nombre, String rango, int idPruebaAnalisis) {
        this.nombre = nombre;
        this.rango = rango;
        this.idPruebaAnalisis = idPruebaAnalisis;
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param idParametroEvaluacion ID del parámetro de evaluación.
     * @param nombre Nombre del parámetro.
     * @param rango Rango de valores del parámetro.
     * @param idPruebaAnalisis ID de la prueba de análisis asociada.
     */
    public ParametrosEntidad(int idParametroEvaluacion, String nombre, String rango, int idPruebaAnalisis) {
        this.idParametroEvaluacion = idParametroEvaluacion;
        this.nombre = nombre;
        this.rango = rango;
        this.idPruebaAnalisis = idPruebaAnalisis;
    }

    /**
     *
     * @return
     */
    public int getIdParametroEvaluacion() {
        return idParametroEvaluacion;
    }

    /**
     *
     * @param idParametroEvaluacion
     */
    public void setIdParametroEvaluacion(int idParametroEvaluacion) {
        this.idParametroEvaluacion = idParametroEvaluacion;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    public String getRango() {
        return rango;
    }

    /**
     *
     * @param rango
     */
    public void setRango(String rango) {
        this.rango = rango;
    }

    /**
     *
     * @return
     */
    public int getIdPruebaAnalisis() {
        return idPruebaAnalisis;
    }

    /**
     *
     * @param idPruebaAnalisis
     */
    public void setIdPruebaAnalisis(int idPruebaAnalisis) {
        this.idPruebaAnalisis = idPruebaAnalisis;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ParametrosEntidad{"
                + "idParametroEvaluacion=" + idParametroEvaluacion
                + ", nombre='" + nombre + '\''
                + ", rango='" + rango + '\''
                + ", idPruebaAnalisis=" + idPruebaAnalisis
                + '}';
    }
}

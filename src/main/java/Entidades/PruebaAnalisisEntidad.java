/*
 * Clase que representa una prueba de análisis en un laboratorio clínico.
 */
package Entidades;

/**
 * Representa una prueba de análisis clínico que se realiza en un laboratorio.
 * Contiene información sobre su identificador, nombre, categoría y laboratorio asociado.
 * @author Jack Murrieta
 */
public class PruebaAnalisisEntidad {

    private int idPruebaAnalisis;
    private String nombre;
    private int idCategoria;
    private int idLaboratorio;

    /**
     * Constructor vacío para la creación de una instancia sin inicializar atributos.
     */
    public PruebaAnalisisEntidad() {}

    /**
     * Constructor que inicializa una prueba de análisis con todos sus atributos.
     * 
     * @param idPruebaAnalisis Identificador único de la prueba de análisis.
     * @param nombre Nombre de la prueba de análisis.
     * @param idCategoria Identificador de la categoría a la que pertenece la prueba.
     * @param idLaboratorio Identificador del laboratorio donde se realiza la prueba.
     */
    public PruebaAnalisisEntidad(int idPruebaAnalisis, String nombre, int idCategoria, int idLaboratorio) {
        this.idPruebaAnalisis = idPruebaAnalisis;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.idLaboratorio = idLaboratorio;
    }

    /**
     * Obtiene el identificador único de la prueba de análisis.
     * 
     * @return ID de la prueba de análisis.
     */
    public int getIdPruebaAnalisis() {
        return idPruebaAnalisis;
    }

    /**
     * Establece el identificador de la prueba de análisis.
     * 
     * @param idPruebaAnalisis ID de la prueba de análisis.
     */
    public void setIdPruebaAnalisis(int idPruebaAnalisis) {
        this.idPruebaAnalisis = idPruebaAnalisis;
    }

    /**
     * Obtiene el nombre de la prueba de análisis.
     * 
     * @return Nombre de la prueba.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la prueba de análisis.
     * 
     * @param nombre Nombre de la prueba.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador de la categoría a la que pertenece la prueba.
     * 
     * @return ID de la categoría.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Establece el identificador de la categoría a la que pertenece la prueba.
     * 
     * @param idCategoria ID de la categoría.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtiene el identificador del laboratorio donde se realiza la prueba.
     * 
     * @return ID del laboratorio.
     */
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    /**
     * Establece el identificador del laboratorio donde se realiza la prueba.
     * 
     * @param idLaboratorio ID del laboratorio.
     */
    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    /**
     * Retorna una representación en cadena del objeto con sus atributos.
     * 
     * @return Representación en cadena de la prueba de análisis.
     */
    @Override
    public String toString() {
        return "PruebaAnalisis{" + 
                "idPruebaAnalisis=" + idPruebaAnalisis + 
                ", nombre='" + nombre + '\'' +
                ", idCategoria=" + idCategoria + 
                ", idLaboratorio=" + idLaboratorio + 
                '}';
    }
}

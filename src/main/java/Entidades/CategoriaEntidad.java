package Entidades;

/**
 * Representa una categoría en el sistema.
 * Contiene información sobre la categoría, como su identificador y su nombre.
 * 
 * @author oribi
 */
public class CategoriaEntidad {
    
    /** Identificador único de la categoría. */
    private int idCategoria;
    
    /** Nombre de la categoría. */
    private String nombre;

    /**
     * Constructor vacío de la clase CategoriaEntidad.
     */
    public CategoriaEntidad() {
    }

    /**
     * Constructor con parámetros para inicializar una categoría.
     * 
     * @param idCategoria Identificador único de la categoría.
     * @param nombre Nombre de la categoría.
     */
    public CategoriaEntidad(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    /**
     * Obtiene el identificador único de la categoría.
     * 
     * @return El identificador de la categoría.
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Establece el identificador único de la categoría.
     * 
     * @param idCategoria El nuevo identificador de la categoría.
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtiene el nombre de la categoría.
     * 
     * @return El nombre de la categoría.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     * 
     * @param nombre El nuevo nombre de la categoría.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Representación en cadena del objeto CategoriaEntidad.
     * 
     * @return Una cadena con la información de la categoría.
     */
    @Override
    public String toString() {
        return "CategoriaEntidad{" + "idCategoria=" + idCategoria + ", nombre=" + nombre + '}';
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 * DTO para representar los parámetros de evaluación de una prueba de análisis.
 * Contiene información sobre el nombre del parámetro, su rango y la prueba de análisis asociada.
 * 
 * @author Jack Murrieta
 */
public class ParametrosDTO {
    private int idParametroEvaluacion; // Identificador del parámetro de evaluación
    private String nombre; // Nombre del parámetro de evaluación
    private String rango; // Rango de valores aceptables
    private int idPruebaAnalisis; // ID de la prueba de análisis a la que pertenece el parámetro

    /**
     * Constructor vacío de ParametrosDTO.
     */
    public ParametrosDTO() {
    }

    /**
     * Constructor para guardar un nuevo parámetro de evaluación.
     * 
     * @param nombre Nombre del parámetro de evaluación
     * @param rango Rango de valores aceptables
     * @param idPruebaAnalisis ID de la prueba de análisis asociada
     */
    public ParametrosDTO(String nombre, String rango, int idPruebaAnalisis) {
        this.nombre = nombre;
        this.rango = rango;
        this.idPruebaAnalisis = idPruebaAnalisis;
    }

    /**
     * Constructor con todos los datos del parámetro de evaluación.
     * 
     * @param idParametroEvaluacion Identificador del parámetro de evaluación
     * @param nombre Nombre del parámetro de evaluación
     * @param rango Rango de valores aceptables
     * @param idPruebaAnalisis ID de la prueba de análisis asociada
     */
    public ParametrosDTO(int idParametroEvaluacion, String nombre, String rango, int idPruebaAnalisis) {
        this.idParametroEvaluacion = idParametroEvaluacion;
        this.nombre = nombre;
        this.rango = rango;
        this.idPruebaAnalisis = idPruebaAnalisis;
    }

    /**
     * Obtiene el identificador del parámetro de evaluación.
     * 
     * @return ID del parámetro de evaluación
     */
    public int getIdParametroEvaluacion() {
        return idParametroEvaluacion;
    }

    /**
     * Establece el identificador del parámetro de evaluación.
     * 
     * @param idParametroEvaluacion Nuevo ID del parámetro de evaluación
     */
    public void setIdParametroEvaluacion(int idParametroEvaluacion) {
        this.idParametroEvaluacion = idParametroEvaluacion;
    }

    /**
     * Obtiene el nombre del parámetro de evaluación.
     * 
     * @return Nombre del parámetro
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del parámetro de evaluación.
     * 
     * @param nombre Nuevo nombre del parámetro
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el rango de valores aceptables.
     * 
     * @return Rango del parámetro
     */
    public String getRango() {
        return rango;
    }

    /**
     * Establece el rango de valores aceptables.
     * 
     * @param rango Nuevo rango del parámetro
     */
    public void setRango(String rango) {
        this.rango = rango;
    }

    /**
     * Obtiene el ID de la prueba de análisis asociada.
     * 
     * @return ID de la prueba de análisis
     */
    public int getIdPruebaAnalisis() {
        return idPruebaAnalisis;
    }

    /**
     * Establece el ID de la prueba de análisis asociada.
     * 
     * @param idPruebaAnalisis Nuevo ID de la prueba de análisis
     */
    public void setIdPruebaAnalisis(int idPruebaAnalisis) {
        this.idPruebaAnalisis = idPruebaAnalisis;
    }

    /**
     * Devuelve una representación en cadena del objeto ParametrosDTO.
     * 
     * @return Cadena con los datos del parámetro de evaluación
     */
    @Override
    public String toString() {
        return "ParametrosDTO{" + 
               "idParametroEvaluacion=" + idParametroEvaluacion + 
               ", nombre='" + nombre + '\'' +
               ", rango='" + rango + '\'' +
               ", idPruebaAnalisis=" + idPruebaAnalisis + 
               '}';
    }
}


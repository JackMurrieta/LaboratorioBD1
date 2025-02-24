/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 * DTO para representar una prueba de análisis.
 * Contiene información sobre el nombre de la prueba, su categoría y el laboratorio al que pertenece.
 * 
 * @author oribi
 */
public class PruebaAnalisisDTO {
    private int idPruebaAnalisis; // Identificador de la prueba de análisis
    private String nombre; // Nombre de la prueba
    private int idCategoria; // ID de la categoría de la prueba
    private int idLaboratorio; // ID del laboratorio al que pertenece la prueba

    /**
     * Constructor vacío de PruebaAnalisisDTO.
     */
    public PruebaAnalisisDTO() {
    }

    /**
     * Constructor para registrar una nueva prueba de análisis.
     * 
     * @param nombre Nombre de la prueba de análisis
     * @param idCategoria ID de la categoría de la prueba
     * @param idLaboratorio ID del laboratorio asociado a la prueba
     */
    public PruebaAnalisisDTO(String nombre, int idCategoria, int idLaboratorio) {
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.idLaboratorio = idLaboratorio;
    }

    /**
     * Constructor con todos los parámetros de la prueba de análisis.
     * 
     * @param idPruebaAnalisis Identificador único de la prueba
     * @param nombre Nombre de la prueba de análisis
     * @param idCategoria ID de la categoría de la prueba
     * @param idLaboratorio ID del laboratorio asociado a la prueba
     */
    public PruebaAnalisisDTO(int idPruebaAnalisis, String nombre, int idCategoria, int idLaboratorio) {
        this.idPruebaAnalisis = idPruebaAnalisis;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.idLaboratorio = idLaboratorio;
    }

    /**
     * Obtiene el ID de la prueba de análisis.
     * 
     * @return ID de la prueba de análisis
     */
    public int getIdPruebaAnalisis() {
        return idPruebaAnalisis;
    }

    /**
     * Establece el ID de la prueba de análisis.
     * 
     * @param idPruebaAnalisis Nuevo ID de la prueba
     */
    public void setIdPruebaAnalisis(int idPruebaAnalisis) {
        this.idPruebaAnalisis = idPruebaAnalisis;
    }

    /**
     * Obtiene el nombre de la prueba de análisis.
     * 
     * @return Nombre de la prueba
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la prueba de análisis.
     * 
     * @param nombre Nuevo nombre de la prueba
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID de la categoría a la que pertenece la prueba.
     * 
     * @return ID de la categoría
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Establece el ID de la categoría de la prueba.
     * 
     * @param idCategoria Nuevo ID de la categoría
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtiene el ID del laboratorio asociado a la prueba.
     * 
     * @return ID del laboratorio
     */
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    /**
     * Establece el ID del laboratorio asociado a la prueba.
     * 
     * @param idLaboratorio Nuevo ID del laboratorio
     */
    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    /**
     * Devuelve una representación en cadena del objeto PruebaAnalisisDTO.
     * 
     * @return Cadena con los datos de la prueba de análisis
     */
    @Override
    public String toString() {
        return "PruebaAnalisisDTO{" +
               "idPruebaAnalisis=" + idPruebaAnalisis +
               ", nombre='" + nombre + '\'' +
               ", idCategoria=" + idCategoria +
               ", idLaboratorio=" + idLaboratorio +
               '}';
    }
}



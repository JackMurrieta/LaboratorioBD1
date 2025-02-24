/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;
/**
 * DTO para representar una categoría.
 * Contiene información sobre una categoría, incluyendo su ID y nombre.
 * 
 * @author oribi
 */
public class CategoriaDTO {
    private int idCategoria; // ID de la categoría
    private String nombre;   // Nombre de la categoría

    /**
     * Constructor vacío para la categoría.
     */
    public CategoriaDTO() {
    }

    /**
     * Constructor para crear una categoría con ID y nombre.
     * 
     * @param idCategoria ID de la categoría
     * @param nombre Nombre de la categoría
     */
    public CategoriaDTO(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    /**
     * Obtiene el ID de la categoría.
     * 
     * @return ID de la categoría
     */
    public int getIdCategoria() {
        return idCategoria;
    }

    /**
     * Establece el ID de la categoría.
     * 
     * @param idCategoria Nuevo ID de la categoría
     */
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    /**
     * Obtiene el nombre de la categoría.
     * 
     * @return Nombre de la categoría
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la categoría.
     * 
     * @param nombre Nuevo nombre de la categoría
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

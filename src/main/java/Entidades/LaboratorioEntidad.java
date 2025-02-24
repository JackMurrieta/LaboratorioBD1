/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 * Representa un laboratorio clínico.
 * @author Jack Murrieta
 */
public class LaboratorioEntidad {
    private int idLaboratorio;
    private String nombre;
    private String direccion;

    /**
     * Constructor que inicializa un laboratorio con solo su nombre.
     *
     * @param nombre Nombre del laboratorio.
     */
    public LaboratorioEntidad(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor que inicializa un laboratorio con todos sus atributos.
     *
     * @param idLaboratorio ID del laboratorio.
     * @param nombre Nombre del laboratorio.
     * @param direccion Dirección del laboratorio.
     */
    public LaboratorioEntidad(int idLaboratorio, String nombre, String direccion) {
        this.idLaboratorio = idLaboratorio;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "LaboratorioEntidad{" +
                "idLaboratorio=" + idLaboratorio +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}

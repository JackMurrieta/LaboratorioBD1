/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.time.LocalDate;
/**
 * DTO para representar un cliente.
 * Contiene información sobre un cliente, incluyendo su identificación, nombre y fecha de nacimiento.
 * 
 * @author Jack Murrieta
 */
public class ClienteDTO {
    private int id; // ID del cliente
    private String nombres; // Nombres del cliente
    private String apellidoPaterno; // Apellido paterno del cliente
    private String apellidoMaterno; // Apellido materno del cliente
    private LocalDate fechaNacimiento; // Fecha de nacimiento del cliente

    /**
     * Constructor vacío de ClienteDTO.
     */
    public ClienteDTO() {
    }

    /**
     * Constructor con parámetros para inicializar un cliente.
     * 
     * @param id Identificación única del cliente
     * @param nombres Nombre(s) del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     */
    public ClienteDTO(int id, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el ID del cliente.
     * 
     * @return ID del cliente
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param id Nuevo ID del cliente
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param nombres Nuevo nombre del cliente
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     * 
     * @return Apellido paterno del cliente
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     * 
     * @param apellidoPaterno Nuevo apellido paterno del cliente
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     * 
     * @return Apellido materno del cliente
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del cliente.
     * 
     * @param apellidoMaterno Nuevo apellido materno del cliente
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     * 
     * @return Fecha de nacimiento del cliente
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     * 
     * @param fechaNacimiento Nueva fecha de nacimiento del cliente
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Devuelve una representación en cadena del objeto ClienteDTO.
     * 
     * @return Cadena con los datos del cliente
     */
    @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", nombres=" + nombres + 
                ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + 
                apellidoMaterno + ", fechaNacimiento=" + fechaNacimiento + '}';
    }

}

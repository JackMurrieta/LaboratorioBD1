/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.time.LocalDate;

/**
 * DTO para representar la información de un cliente al registrarse.
 * Contiene los datos necesarios para crear un nuevo cliente en el sistema.
 * 
 * @author Jack Murrieta
 */
public class GuardarClienteDTO {
    private String nombres; // Nombre del cliente
    private String apellidoPaterno; // Apellido paterno del cliente
    private String apellidoMaterno; // Apellido materno del cliente
    private LocalDate fechaNacimiento; // Fecha de nacimiento del cliente
    private int idLaboratorio; // ID del laboratorio asociado al cliente

    /**
     * Constructor vacío de GuardarClienteDTO.
     */
    public GuardarClienteDTO() {
    }

    /**
     * Constructor para registrar un cliente sin laboratorio asociado.
     * 
     * @param nombres Nombre del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     */
    public GuardarClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Constructor para registrar un cliente con laboratorio asociado.
     * 
     * @param nombres Nombre del cliente
     * @param apellidoPaterno Apellido paterno del cliente
     * @param apellidoMaterno Apellido materno del cliente
     * @param fechaNacimiento Fecha de nacimiento del cliente
     * @param idLaboratorio ID del laboratorio asociado al cliente
     */
    public GuardarClienteDTO(String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, int idLaboratorio) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.idLaboratorio = idLaboratorio;
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
     * Obtiene el apellido paterno del cliente.
     * 
     * @return Apellido paterno del cliente
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
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
     * Obtiene la fecha de nacimiento del cliente.
     * 
     * @return Fecha de nacimiento del cliente
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Obtiene el ID del laboratorio asociado al cliente.
     * 
     * @return ID del laboratorio
     */
    public int getIdLaboratorio() {
        return idLaboratorio;
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
     * Establece el apellido paterno del cliente.
     * 
     * @param apellidoPaterno Nuevo apellido paterno del cliente
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
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
     * Establece la fecha de nacimiento del cliente.
     * 
     * @param fechaNacimiento Nueva fecha de nacimiento del cliente
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Establece el ID del laboratorio asociado al cliente.
     * 
     * @param idLaboratorio Nuevo ID del laboratorio
     */
    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }

    /**
     * Devuelve una representación en cadena del objeto GuardarClienteDTO.
     * 
     * @return Cadena con los datos del cliente registrado
     */
    @Override
    public String toString() {
        return "GuardarClienteDTO{" + 
               "nombres='" + nombres + '\'' +
               ", apellidoPaterno='" + apellidoPaterno + '\'' +
               ", apellidoMaterno='" + apellidoMaterno + '\'' +
               ", fechaNacimiento=" + fechaNacimiento +
               ", idLaboratorio=" + idLaboratorio +
               '}';
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

import java.time.LocalDate;

/**
 * Representa un objeto de transferencia de datos (DTO) para la tabla de clientes.
 * Contiene información básica de un cliente, como su identificador, nombres,
 * apellidos y fecha de nacimiento.
 * 
 * @author Jack Murrieta
 */
public class TablaClienteDTO {
    
    /** Identificador único del cliente. */
    private int idCliente;
    
    /** Nombres del cliente. */
    private String nombres;
    
    /** Apellido paterno del cliente. */
    private String apellidoPaterno;
    
    /** Apellido materno del cliente. */
    private String apellidoMaterno;
    
    /** Fecha de nacimiento del cliente. */
    private LocalDate fechaNacimiento;

    /**
     * Constructor que inicializa el DTO con el identificador del cliente.
     * 
     * @param idCliente Identificador único del cliente.
     */
    public TablaClienteDTO(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Constructor que inicializa el DTO con todos los datos del cliente.
     * 
     * @param idCliente Identificador único del cliente.
     * @param nombres Nombres del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     */
    public TablaClienteDTO(int idCliente, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento) {
        this.idCliente = idCliente;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Obtiene el identificador único del cliente.
     * 
     * @return El identificador del cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador único del cliente.
     * 
     * @param idCliente El nuevo identificador del cliente.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene los nombres del cliente.
     * 
     * @return Los nombres del cliente.
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * Establece los nombres del cliente.
     * 
     * @param nombres Los nuevos nombres del cliente.
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     * 
     * @return El apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Establece el apellido paterno del cliente.
     * 
     * @param apellidoPaterno El nuevo apellido paterno del cliente.
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     * 
     * @return El apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Establece el apellido materno del cliente.
     * 
     * @param apellidoMaterno El nuevo apellido materno del cliente.
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Obtiene la fecha de nacimiento del cliente.
     * 
     * @return La fecha de nacimiento del cliente.
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Establece la fecha de nacimiento del cliente.
     * 
     * @param fechaNacimiento La nueva fecha de nacimiento del cliente.
     */
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Representación en cadena del objeto TablaClienteDTO.
     * 
     * @return Una cadena con la información del cliente.
     */
    @Override
    public String toString() {
        return "TablaClienteDTO{" + 
                "idCliente=" + idCliente + 
                ", nombres=" + nombres + 
                ", apellidoPaterno=" + apellidoPaterno + 
                ", apellidoMaterno=" + apellidoMaterno + 
                ", fechaNacimiento=" + fechaNacimiento + 
                '}';
    }
}

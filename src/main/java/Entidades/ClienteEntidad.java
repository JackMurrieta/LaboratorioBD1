package Entidades;

import java.time.LocalDate;

/**
 * Representa un cliente que se somete a análisis clínicos en un laboratorio.
 *
 * @author Jack Murrieta
 */
public class ClienteEntidad {

    private int id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private LocalDate fechaNacimiento;
    private int idLaboratorio;

    /**
     * Constructor con todos los atributos.
     *
     * @param id ID del cliente.
     * @param nombres Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     * @param fechaNacimiento Fecha de nacimiento del cliente.
     * @param idLaboratorio ID del laboratorio asociado.
     */
    public ClienteEntidad(int id, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, int idLaboratorio) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.idLaboratorio = idLaboratorio;
    }

    /**
     *
     * @param id
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param fechaNacimiento
     */
    public ClienteEntidad(int id, String nombres, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento) {
        this.id = id;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getNombres() {
        return nombres;
    }

    /**
     *
     * @return
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     *
     * @return
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     *
     * @return
     */
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *
     * @return
     */
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ClienteEntidad{"
                + "id=" + id
                + ", nombres='" + nombres + '\''
                + ", apellidoPaterno='" + apellidoPaterno + '\''
                + ", apellidoMaterno='" + apellidoMaterno + '\''
                + ", fechaNacimiento=" + fechaNacimiento
                + ", idLaboratorio=" + idLaboratorio
                + '}';
    }
}

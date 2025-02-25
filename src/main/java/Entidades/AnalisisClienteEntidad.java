package Entidades;

import java.time.LocalDateTime;

/**
 * Representa un análisis clínico realizado a un cliente. Contiene información sobre la fecha y hora del análisis, el cliente y su folio.
 *
 * @author Jack Murrieta
 */
public class AnalisisClienteEntidad {

    private int idAnalisisCliente; // Identificador único del análisis clínico
    private int folio; // Número de folio del análisis
    private LocalDateTime fechaYhoraCaptura; // Fecha y hora en la que se realizó el análisis
    private int idCliente; // ID del cliente al que pertenece el análisis

    /**
     * Constructor vacío para mayor flexibilidad.
     */
    public AnalisisClienteEntidad() {
    }

    /**
     * Constructor para registrar un nuevo análisis sin folio.
     *
     * @param fechaYhoraCaptura Fecha y hora de la captura del análisis (no puede ser null).
     * @param idCliente ID del cliente al que se le realizó el análisis.
     */
    public AnalisisClienteEntidad(LocalDateTime fechaYhoraCaptura, int idCliente) {
        this.fechaYhoraCaptura = fechaYhoraCaptura;
        this.idCliente = idCliente;
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param idAnalisisCliente ID único del análisis.
     * @param folio Número de folio del análisis.
     * @param fechaYhoraCaptura Fecha y hora de la captura del análisis (no puede ser null).
     * @param idCliente ID del cliente al que pertenece el análisis.
     */
    public AnalisisClienteEntidad(int idAnalisisCliente, int folio, LocalDateTime fechaYhoraCaptura, int idCliente) {
        this.idAnalisisCliente = idAnalisisCliente;
        this.folio = folio;
        this.fechaYhoraCaptura = fechaYhoraCaptura;
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el ID del análisis clínico.
     *
     * @return ID del análisis.
     */
    public int getIdAnalisisCliente() {
        return idAnalisisCliente;
    }

    /**
     * Establece el ID del análisis clínico.
     *
     * @param idAnalisisCliente Nuevo ID del análisis.
     */
    public void setIdAnalisisCliente(int idAnalisisCliente) {
        this.idAnalisisCliente = idAnalisisCliente;
    }

    /**
     * Obtiene el número de folio del análisis.
     *
     * @return Número de folio.
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Establece el número de folio del análisis.
     *
     * @param folio Nuevo número de folio.
     */
    public void setFolio(int folio) {
        if (folio < 0) {
            throw new IllegalArgumentException("El folio no puede ser negativo.");
        }
        this.folio = folio;
    }

    /**
     * Obtiene la fecha y hora de captura del análisis.
     *
     * @return Fecha y hora de captura.
     */
    public LocalDateTime getFechaYhoraCaptura() {
        return fechaYhoraCaptura;
    }

    /**
     * Establece la fecha y hora de captura del análisis.
     *
     * @param fechaYhoraCaptura Nueva fecha y hora de captura.
     */
    public void setFechaYhoraCaptura(LocalDateTime fechaYhoraCaptura) {
        this.fechaYhoraCaptura = fechaYhoraCaptura;
    }

    /**
     * Obtiene el ID del cliente al que pertenece el análisis.
     *
     * @return ID del cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el ID del cliente al que pertenece el análisis.
     *
     * @param idCliente Nuevo ID del cliente.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Devuelve una representación en cadena del objeto AnalisisClienteEntidad.
     *
     * @return Cadena con los datos del análisis clínico.
     */
    @Override
    public String toString() {
        return "AnalisisClienteEntidad{"
                + "idAnalisisCliente=" + idAnalisisCliente
                + ", folio=" + folio
                + ", fechaYhoraCaptura=" + fechaYhoraCaptura
                + ", idCliente=" + idCliente
                + '}';
    }
}

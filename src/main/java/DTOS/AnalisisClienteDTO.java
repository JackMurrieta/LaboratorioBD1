/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;


/**
 * DTO para representar un análisis de cliente.
 * Contiene información sobre el análisis realizado a un cliente,
 * incluyendo su ID, folio, fecha y hora de captura.
 * 
 * @author Jack Murrieta
 */
public class AnalisisClienteDTO {
    private String ididAnalisisCliente; // ID del análisis de cliente
    private String folio; // Folio del análisis
    private String fechaYhoraCaptura; // Fecha y hora de captura
    private String idCliente; // ID del cliente asociado al análisis
    
    /**
     * Constructor para crear un análisis de cliente sin ID.
     * 
     * @param folio Folio del análisis
     * @param fechaYhoraCaptura Fecha y hora de la captura
     * @param idCliente ID del cliente
     */
    public AnalisisClienteDTO(String folio, String fechaYhoraCaptura, String idCliente) {
        this.folio = folio;
        this.fechaYhoraCaptura = fechaYhoraCaptura;
        this.idCliente = idCliente;
    }
    
    /**
     * Constructor para crear un análisis de cliente con todos los datos.
     * 
     * @param ididAnalisisCliente ID del análisis de cliente
     * @param folio Folio del análisis
     * @param fechaYhoraCaptura Fecha y hora de la captura
     * @param idCliente ID del cliente
     */
    public AnalisisClienteDTO(String ididAnalisisCliente, String folio, String fechaYhoraCaptura, String idCliente) {
        this.ididAnalisisCliente = ididAnalisisCliente;
        this.folio = folio;
        this.fechaYhoraCaptura = fechaYhoraCaptura;
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el folio del análisis.
     * 
     * @return Folio del análisis
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Establece el folio del análisis.
     * 
     * @param folio Nuevo folio del análisis
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Obtiene la fecha y hora de captura del análisis.
     * 
     * @return Fecha y hora de captura
     */
    public String getFechaYhoraCaptura() {
        return fechaYhoraCaptura;
    }

    /**
     * Establece la fecha y hora de captura del análisis.
     * 
     * @param fechaYhoraCaptura Nueva fecha y hora de captura
     */
    public void setFechaYhoraCaptura(String fechaYhoraCaptura) {
        this.fechaYhoraCaptura = fechaYhoraCaptura;
    }

    /**
     * Obtiene el ID del cliente asociado al análisis.
     * 
     * @return ID del cliente
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el ID del cliente asociado al análisis.
     * 
     * @param idCliente Nuevo ID del cliente
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Devuelve una representación en cadena del objeto.
     * 
     * @return Cadena con los datos del análisis de cliente
     */
    @Override
    public String toString() {
        return "AnalisisClienteDTO{" + 
                "ididAnalisisCliente=" + ididAnalisisCliente + 
                ", folio=" + folio + 
                ", fechaYhoraCaptura=" + fechaYhoraCaptura + 
                ", idCliente=" + idCliente + 
                '}';
    }
}
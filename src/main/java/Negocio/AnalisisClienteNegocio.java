/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.AnalisisClienteDTO;
import Entidades.AnalisisClienteEntidad;
import Persistencia.IAnalisisClientes;
import Persistencia.PersistenciaException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que maneja la lógica de negocio para el análisis de clientes. Implementa la interfaz {@link IAnalisisClienteNegocio}.
 *
 * @author Jack Murrieta
 */
public class AnalisisClienteNegocio implements IAnalisisClienteNegocio {

    private IAnalisisClientes analisisDAO;
    private AnalisisClienteDTO analisisDTO;

    /**
     * Constructor que inicializa el DAO de análisis de clientes.
     *
     * @param analisisDAO Objeto que permite el acceso a la base de datos para operaciones de análisis de clientes.
     */
    public AnalisisClienteNegocio(IAnalisisClientes analisisDAO) {
        this.analisisDAO = analisisDAO;
    }

    /**
     * Convierte una entidad de análisis de cliente en un DTO.
     *
     * @param analisisEntidad Objeto {@link AnalisisClienteEntidad} que representa un análisis de cliente.
     * @return Un objeto {@link AnalisisClienteDTO} con la información transformada.
     * @throws SQLException Si ocurre un error al convertir los datos.
     */
    private AnalisisClienteDTO convertirAnalisisCDTO(AnalisisClienteEntidad analisisEntidad) throws SQLException {
        String id = String.valueOf(analisisEntidad.getIdAnalisisCliente());
        String folio = String.valueOf(analisisEntidad.getFolio());
        LocalDateTime fechaYhoraCaptura = analisisEntidad.getFechaYhoraCaptura();
        // Definir un formato para la conversión a String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Convertir LocalDateTime a String con el formato especificado
        String fechaYhoraCapturaString = fechaYhoraCaptura.format(formatter);
        String idCliente = String.valueOf(analisisEntidad.getIdCliente());

        return new AnalisisClienteDTO(id, folio, fechaYhoraCapturaString, idCliente);
    }

    /**
     * Genera un análisis de cliente, asignándole un folio único antes de guardarlo en la base de datos.
     *
     * @param analisisCliente Objeto {@link AnalisisClienteEntidad} con la información del análisis del cliente.
     * @return Un objeto {@link AnalisisClienteDTO} con los datos del análisis generado.
     * @throws NegocioException Si ocurre un error en la generación del análisis.
     */
    @Override
    public AnalisisClienteDTO generarAnalisisCliente(AnalisisClienteEntidad analisisCliente) throws NegocioException {
        try {
            // Generar folio automáticamente antes de guardar
            crearFolio(analisisCliente);

            // Guardar el análisis cliente en la base de datos
            AnalisisClienteEntidad analisisGenerado = analisisDAO.generarUnAnalisisCliente(analisisCliente);

            // Convertir la entidad en DTO y retornarla
            return convertirAnalisisCDTO(analisisGenerado);

        } catch (PersistenciaException ex) {
            Logger.getLogger(AnalisisClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al generar el análisis del cliente");
        } catch (SQLException ex) {
            Logger.getLogger(AnalisisClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Crea y asigna un folio único para el análisis del cliente antes de guardarlo en la base de datos.
     *
     * @param analisisCliente Objeto {@link AnalisisClienteEntidad} al que se asignará un nuevo folio.
     * @throws RuntimeException Si se alcanza el límite máximo de folios.
     */
    private void crearFolio(AnalisisClienteEntidad analisisCliente) {
        int ultimoFolio = obtenerUltimoFolioDesdeBD();

        // Verificar que no se sobrepase el máximo de un entero
        if (ultimoFolio < Integer.MAX_VALUE) {
            int nuevoFolio = ultimoFolio + 1;
            analisisCliente.setFolio(nuevoFolio);
        } else {
            throw new RuntimeException("Se ha alcanzado el límite máximo de folios");
        }
    }

    /**
     * Obtiene el último folio registrado en la base de datos.
     *
     * @return El último folio registrado o 0 si no existen registros previos.
     */
    private int obtenerUltimoFolioDesdeBD() {
        Integer ultimoFolio = null; // Declarar la variable antes del bloque try

        try {
            ultimoFolio = analisisDAO.obtenerUltimoFolio(); // Método en el DAO que obtiene el último folio
        } catch (PersistenciaException ex) {
            Logger.getLogger(AnalisisClienteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (ultimoFolio != null) ? ultimoFolio : 0; // Si no hay registros, empezar desde 0
    }

}

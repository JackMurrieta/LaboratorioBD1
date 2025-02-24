/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.AnalisisClienteDTO;
import Entidades.AnalisisClienteEntidad;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Análisis de Cliente. Proporciona métodos para la gestión de análisis realizados a clientes en la base de datos.
 *
 * @author Jack Murrieta
 */
public interface IAnalisisClientes {

    /**
     * Genera un nuevo análisis para un cliente y lo almacena en la base de datos.
     *
     * @param analisisCliente Objeto {@code AnalisisClienteEntidad} con los datos del análisis.
     * @return El objeto {@code AnalisisClienteEntidad} almacenado con su ID generado.
     * @throws PersistenciaException Si ocurre un error al guardar el análisis en la base de datos.
     */
    AnalisisClienteEntidad generarUnAnalisisCliente(AnalisisClienteEntidad analisisCliente) throws PersistenciaException;

    /**
     * Lista los análisis asociados a un cliente específico.
     *
     * @param idCliente ID del cliente para buscar sus análisis.
     * @return Lista de objetos {@code AnalisisClienteEntidad} correspondientes al cliente.
     * @throws PersistenciaException Si ocurre un error en la consulta a la base de datos.
     */
    List<AnalisisClienteEntidad> listarAnalisisPorCliente(int idCliente) throws PersistenciaException;

    /**
     * Obtiene el último folio registrado en los análisis de clientes.
     *
     * @return Último número de folio registrado.
     * @throws PersistenciaException Si ocurre un error al obtener el folio.
     */
    Integer obtenerUltimoFolio() throws PersistenciaException;
}

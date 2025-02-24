/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.EditarClienteDTO;
import DTOS.GuardarClienteDTO;
import Entidades.ClienteEntidad;
import Entidades.LaboratorioEntidad;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Cliente. Permite realizar operaciones CRUD en la base de datos.
 *
 * @author Jack Murrieta
 */
public interface IClienteDAO {

    /**
     * Obtiene la lista de todos los clientes registrados en la base de datos.
     *
     * @return Lista de objetos {@code ClienteEntidad}.
     * @throws PersistenciaException Si ocurre un error al obtener los clientes.
     */
    List<ClienteEntidad> buscarClientes() throws PersistenciaException;

    /**
     * Obtiene la lista de clientes asociados a un laboratorio específico.
     *
     * @param laboratorio ID del laboratorio.
     * @return Lista de objetos {@code ClienteEntidad} asociados al laboratorio.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    List<ClienteEntidad> buscarClientesPorLaboratorio(int laboratorio) throws PersistenciaException;

    /**
     * Guarda un nuevo cliente en la base de datos.
     *
     * @param cliente Objeto {@code GuardarClienteDTO} con la información del cliente.
     * @return El objeto {@code ClienteEntidad} guardado con su ID generado.
     * @throws PersistenciaException Si ocurre un error al guardar el cliente.
     */
    ClienteEntidad guardar(GuardarClienteDTO cliente) throws PersistenciaException;

    /**
     * Guarda un cliente en la base de datos dentro de una transacción.
     *
     * @param cliente Objeto {@code GuardarClienteDTO} con la información del cliente.
     * @return El objeto {@code ClienteEntidad} guardado con su ID generado.
     * @throws PersistenciaException Si ocurre un error durante la transacción.
     */
    ClienteEntidad guardarConTransaccion(GuardarClienteDTO cliente) throws PersistenciaException;

    /**
     * Edita la información de un cliente existente en la base de datos.
     *
     * @param cliente Objeto {@code ClienteEntidad} con la información actualizada.
     * @return El objeto {@code ClienteEntidad} actualizado.
     * @throws PersistenciaException Si ocurre un error al editar el cliente.
     */
    ClienteEntidad editar(ClienteEntidad cliente) throws PersistenciaException;

    /**
     * Elimina un cliente de la base de datos.
     *
     * @param id ID del cliente a eliminar.
     * @return El objeto {@code ClienteEntidad} eliminado.
     * @throws PersistenciaException Si ocurre un error al eliminar el cliente.
     */
    ClienteEntidad eliminar(int id) throws PersistenciaException;

    /**
     * Busca un cliente en la base de datos por su ID.
     *
     * @param id ID del cliente a buscar.
     * @return El objeto {@code ClienteEntidad} si se encuentra en la base de datos.
     * @throws PersistenciaException Si ocurre un error o el cliente no existe.
     */
    ClienteEntidad buscarPorId(int id) throws PersistenciaException;
}

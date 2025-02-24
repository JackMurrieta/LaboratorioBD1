/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.ClienteDTO;
import DTOS.EditarClienteDTO;
import DTOS.GuardarClienteDTO;
import DTOS.TablaClienteDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la gestión de clientes en el sistema.
 * Proporciona métodos para buscar, registrar, editar y eliminar clientes.
 * 
 * @author Jack Murrieta
 */
public interface IClienteNegocio {
    
    /**
     * Recupera la lista de todos los clientes registrados en el sistema.
     * 
     * @return Una lista de objetos {@link TablaClienteDTO} con la información de los clientes.
     * @throws NegocioException Si ocurre un error durante la búsqueda.
     */
    List<TablaClienteDTO> buscarClientes() throws NegocioException;
    
    /**
     * Recupera la lista de clientes asociados a un laboratorio específico.
     * 
     * @param id Identificador del laboratorio.
     * @return Una lista de objetos {@link TablaClienteDTO} con los clientes del laboratorio especificado.
     * @throws NegocioException Si ocurre un error durante la búsqueda.
     */
    List<TablaClienteDTO> buscarClientesPorLaboratorio(int id) throws NegocioException;

    /**
     * Registra un nuevo cliente en el sistema después de validar su información.
     * 
     * @param cliente Objeto {@link GuardarClienteDTO} con los datos del cliente a registrar.
     * @return Un objeto {@link ClienteDTO} con los datos del cliente registrado.
     * @throws NegocioException Si ocurre un error al guardar el cliente.
     */
    ClienteDTO guardar(GuardarClienteDTO cliente) throws NegocioException;

    /**
     * Edita la información de un cliente existente después de validarla.
     * 
     * @param id Identificador del cliente a editar.
     * @param cliente Objeto {@link ClienteDTO} con los datos actualizados del cliente.
     * @return Un objeto {@link ClienteDTO} con los datos del cliente editado.
     * @throws NegocioException Si ocurre un error durante la edición.
     */
    ClienteDTO editar(int id, ClienteDTO cliente) throws NegocioException;

    /**
     * Elimina un cliente del sistema con base en su identificador.
     * 
     * @param id Identificador del cliente a eliminar.
     * @return Un objeto {@link ClienteDTO} con los datos del cliente eliminado.
     * @throws NegocioException Si ocurre un error al eliminar el cliente.
     */
    ClienteDTO eliminar(int id) throws NegocioException;

    /**
     * Busca un cliente en el sistema por su identificador único.
     * 
     * @param id Identificador del cliente.
     * @return Un objeto {@link ClienteDTO} con los datos del cliente encontrado.
     * @throws NegocioException Si el cliente no existe o hay un error en la búsqueda.
     */
    ClienteDTO buscarPorId(int id) throws NegocioException;
 
}

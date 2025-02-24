/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.ClienteDTO;
import DTOS.EditarClienteDTO;
import DTOS.GuardarClienteDTO;
import DTOS.TablaClienteDTO;
import Entidades.ClienteEntidad;
import Persistencia.IClienteDAO;
import Persistencia.PersistenciaException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Clase que gestiona la lógica de negocio relacionada con los clientes. Se encarga de la validación y conversión de datos entre las entidades y los DTOs.
 *
 * @author Jack Murrieta
 */
public class ClienteNegocio implements IClienteNegocio {

    private IClienteDAO clienteDAO;
    ClienteDTO clienteDTO;

    /**
     * Constructor que inicializa el DAO de cliente.
     *
     * @param clienteDAO DAO de cliente para la comunicación con la capa de persistencia.
     */
    public ClienteNegocio(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    /**
     * Busca y obtiene todos los clientes registrados.
     *
     * @return Lista de clientes en formato DTO para la vista de tabla.
     * @throws NegocioException Si ocurre un error en la consulta de clientes.
     */
    @Override
    public List<TablaClienteDTO> buscarClientes() throws NegocioException {
        try {

            List<ClienteEntidad> clientesEntidadLista = this.clienteDAO.buscarClientes(); //2
            return this.convertirTablaClientesDTO(clientesEntidadLista);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    /**
     * Busca clientes asociados a un laboratorio específico.
     *
     * @param id Identificador del laboratorio.
     * @return Lista de clientes relacionados con el laboratorio.
     * @throws NegocioException Si ocurre un error en la consulta.
     */
    @Override
    public List<TablaClienteDTO> buscarClientesPorLaboratorio(int id) throws NegocioException {
        try {
            //ReglasDeNegocioParaBuscarAlumnos("Hola"); //1
            List<ClienteEntidad> ClientesEntidadLista = clienteDAO.buscarClientesPorLaboratorio(id); //2
            return convertirTablaClientesDTO(ClientesEntidadLista);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }

    }

    /**
     * Convierte una lista de entidades Cliente en una lista de DTOs de tabla.
     *
     * @param clientes Lista de entidades de clientes.
     * @return Lista de DTOs de clientes para la tabla.
     */
    private List<TablaClienteDTO> convertirTablaClientesDTO(List<ClienteEntidad> clientes) {

        if (clientes == null) {
            return null;
        }
        List<TablaClienteDTO> clientesDTO = new ArrayList<>();
        for (ClienteEntidad item : clientes) {
            TablaClienteDTO dato = new TablaClienteDTO(
                    item.getId(),
                    item.getNombres(),
                    item.getApellidoPaterno(),
                    item.getApellidoMaterno(),
                    item.getFechaNacimiento()
            );
            clientesDTO.add(dato);
        }

        return clientesDTO;
    }

    /**
     * Valida la información de un cliente antes de guardarlo en la base de datos.
     *
     * @param nombres Nombre del cliente.
     * @param apellidoP Apellido paterno del cliente.
     * @param apellidoM Apellido materno del cliente.
     * @throws NegocioException Si los datos no cumplen con las reglas de negocio.
     */
    private void validarInformacionGuardarCliente(String nombres, String apellidoP, String apellidoM) throws NegocioException {
        // expresiones regulares
        String validaXNombres = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{2,49}(\\s[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{2,49})*$";
        String validaApellidos = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{1,29}(\\s[A-ZÁÉÍÓÚÑ][a-záéíóúñ]{1,29})*$";

        // Validar cada campo
        //.trim para quitar los espacios vacios y no se ejecute la excepcion
        validarCampo(nombres.trim(), validaXNombres, "Nombre inválido");
        validarCampo(apellidoP.trim(), validaApellidos, "Apellido Paterno inválido");
        validarCampo(apellidoM.trim(), validaApellidos, "Apellido Materno inválido");
        // Validar que no contengan palabras prohibidas
        validarSinGroserias(nombres, "Nombre contiene palabras prohibidas");
        validarSinGroserias(apellidoP, "Apellido Paterno contiene palabras prohibidas");
        validarSinGroserias(apellidoM, "Apellido Materno contiene palabras prohibidas");
    }

    /**
     * Valida si un campo cumple con un patrón regex específico.
     *
     * @param campo El valor del campo a validar.
     * @param regex Expresión regular que debe cumplir el campo.
     * @param mensajeError Mensaje de error si el campo no cumple con la validación.
     * @throws NegocioException Si el campo no coincide con el patrón proporcionado.
     */
    private void validarCampo(String campo, String regex, String mensajeError) throws NegocioException {
        if (campo == null || !Pattern.compile(regex).matcher(campo).matches()) {
            throw new NegocioException(mensajeError);
        }
    }

    /**
     * Verifica si un campo contiene palabras ofensivas o groserías.
     *
     * @param campo El texto que se va a validar.
     * @param mensajeError Mensaje de error en caso de que el texto contenga groserías.
     * @throws NegocioException Si el campo contiene alguna palabra prohibida.
     */
    // validar si tiene grocerias
    private void validarSinGroserias(String campo, String mensajeError) throws NegocioException {
        String grocerias = "(?i).*\\b(puto|puta|joto|cabrón|pendejo|chingado|mierda|maldito|culero)\\b.*";
        if (campo != null && Pattern.compile(grocerias).matcher(campo).matches()) {
            throw new NegocioException(mensajeError);
        }
    }

    /**
     * Aplica las reglas de negocio para validar la información antes de guardar un cliente.
     *
     * @param cliente El objeto {@link GuardarClienteDTO} que contiene la información del cliente.
     * @throws NegocioException Si el cliente es nulo o si algún campo obligatorio está vacío o inválido.
     */
    private void reglasDeNegocioGuardarCliente(GuardarClienteDTO cliente) throws NegocioException {
        if (cliente == null) {
            throw new NegocioException("El cliente no puede ser nulo.");
        }

        // Validar que los campos obligatorios no estén vacíos
        if (cliente.getNombres() == null || cliente.getNombres().trim().isEmpty()) {
            throw new NegocioException("El nombre del cliente es obligatorio.");
        }
        if (cliente.getApellidoPaterno() == null || cliente.getApellidoPaterno().trim().isEmpty()) {
            throw new NegocioException("El apellido paterno es obligatorio.");
        }
        if (cliente.getApellidoMaterno() == null || cliente.getApellidoMaterno().trim().isEmpty()) {
            throw new NegocioException("El apellido materno es obligatorio.");
        }
        if (cliente.getFechaNacimiento() == null || cliente.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new NegocioException("La fecha de nacimiento excede al dia de hoy");
        }
    }

    /**
     * Convierte una entidad Cliente a un DTO.
     *
     * @param cliente Entidad de cliente.
     * @return Cliente convertido a DTO.
     */
    public ClienteDTO convertirClienteDTO(ClienteEntidad cliente) {
        if (cliente == null) {
            return null;
        }
        int id = cliente.getId();
        String nombres = cliente.getNombres();
        String apellidoP = cliente.getApellidoPaterno();
        String apellidoM = cliente.getApellidoMaterno();
        LocalDate fechaNacimiento = cliente.getFechaNacimiento();
        ClienteDTO clienteDTO = new ClienteDTO(id, nombres, apellidoP, apellidoM, fechaNacimiento);
        return clienteDTO;

    }

    /**
     * Guarda un cliente en la base de datos después de validarlo.
     *
     * @param cliente DTO con la información del cliente a registrar.
     * @return Cliente registrado en formato DTO.
     * @throws NegocioException Si la validación o la persistencia falla.
     */
    @Override
    public ClienteDTO guardar(GuardarClienteDTO cliente) throws NegocioException {
        try {
            validarInformacionGuardarCliente(cliente.getNombres(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno());
            reglasDeNegocioGuardarCliente(cliente);
            ClienteEntidad clienteEntidad = clienteDAO.guardar(cliente);
            // pasar entidad a un clienteDTO
            return convertirClienteDTO(clienteEntidad);

        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }

    }

    private void reglasDeNegocioEditarCliente(EditarClienteDTO cliente) throws NegocioException {
        if (cliente == null) {
            throw new NegocioException("El cliente no puede ser nulo.");
        }

        // Validar que los campos obligatorios no estén vacíos
        if (cliente.getNombres() == null || cliente.getNombres().trim().isEmpty()) {
            throw new NegocioException("El nombre del cliente es obligatorio.");
        }
        if (cliente.getApellidoPaterno() == null || cliente.getApellidoPaterno().trim().isEmpty()) {
            throw new NegocioException("El apellido paterno es obligatorio.");
        }
        if (cliente.getApellidoMaterno() == null || cliente.getApellidoMaterno().trim().isEmpty()) {
            throw new NegocioException("El apellido materno es obligatorio.");
        }
        if (cliente.getFechaNacimiento() == null || cliente.getFechaNacimiento().isAfter(LocalDate.now())) {
            throw new NegocioException("La fecha de nacimiento excede al dia de hoy");
        }

    }

    /**
     * Edita la información de un cliente existente.
     *
     * @param id Identificador del cliente a editar.
     * @param cliente DTO con los nuevos datos del cliente.
     * @return Cliente actualizado en formato DTO.
     * @throws NegocioException Si el cliente no existe o la actualización falla.
     */
    @Override
    public ClienteDTO editar(int id, ClienteDTO cliente) throws NegocioException {
        try {

            ClienteEntidad clienteExistente = clienteDAO.buscarPorId(id);
            if (clienteExistente == null) {
                throw new NegocioException("Cliente no encontrado con el ID: " + id);
            }

            ClienteEntidad clienteActualizado = new ClienteEntidad(
                    id,
                    cliente.getNombres(),
                    cliente.getApellidoPaterno(),
                    cliente.getApellidoMaterno(),
                    cliente.getFechaNacimiento()
            );

            ClienteEntidad clienteEditado = clienteDAO.editar(clienteActualizado);

            return convertirClienteDTO(clienteEditado);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al editar el alumno: " + ex.getMessage());
        }
    }

    /**
     * Elimina un cliente de la base de datos.
     *
     * @param id Identificador del cliente a eliminar.
     * @return Cliente eliminado en formato DTO.
     * @throws NegocioException Si la eliminación falla.
     */
    @Override
    public ClienteDTO eliminar(int id) throws NegocioException {
        try {
            // Intentar eliminar el cliente
            ClienteEntidad clienteEntidad = clienteDAO.eliminar(id);

            // Si el cliente no existe, retornar null
            if (clienteEntidad == null) {
                return null;
            }

            // Convertir a DTO antes de retornar
            return convertirClienteDTO(clienteEntidad);

        } catch (PersistenciaException ex) {
            throw new NegocioException("Cliente no se eliminó: " + ex.getMessage());
        }

    }

    /**
     * Busca un cliente por su ID en la base de datos.
     *
     * @param id Identificador del cliente.
     * @return Cliente encontrado en formato DTO.
     * @throws NegocioException Si el cliente no se encuentra.
     */
    @Override
    public ClienteDTO buscarPorId(int id) throws NegocioException {
        try {
            ClienteEntidad clienteEntidad = clienteDAO.buscarPorId(id);
            if (clienteEntidad == null) {
                throw new NegocioException("Id no se encuentra en la base de datos");
            }
            return convertirClienteDTO(clienteEntidad);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Cliente no se encontro");
        }
    }

}

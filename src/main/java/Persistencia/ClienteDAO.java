/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.EditarClienteDTO;
import DTOS.GuardarClienteDTO;
import Entidades.ClienteEntidad;
import Entidades.LaboratorioEntidad;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO para la gestión de clientes en la base de datos. Implementa la interfaz IClienteDAO.
 *
 * Proporciona métodos para realizar operaciones CRUD sobre los clientes, incluyendo búsqueda, inserción, actualización y eliminación.
 *
 * @author Jack Murrieta
 */
public class ClienteDAO implements IClienteDAO {

    private IConexionBD conexionBD;

    /**
     * Constructor que recibe una instancia de la conexión a la base de datos.
     *
     * @param conexion Objeto que maneja la conexión con la base de datos.
     */
    public ClienteDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }

    /**
     * Busca todos los clientes registrados en la base de datos.
     *
     * @return Lista de clientes encontrados.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    @Override
    public List<ClienteEntidad> buscarClientes() throws PersistenciaException {
        try {
            String consultaSQL = """
                                 SELECT
                                 	idCliente,
                                 	nombres,
                                 	apellidoPaterno,
                                 	apellidoMaterno, 
                                 	fechaNacimiento,
                                        idLaboratorio
                                 	
                                 FROM clientes;                                 
                                 """;
            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
            ResultSet resultado = preparedStatement.executeQuery();

            List<ClienteEntidad> clienteEntidadLista = null;
            while (resultado.next()) {
                if (clienteEntidadLista == null) {
                    clienteEntidadLista = new ArrayList<>();
                }

                clienteEntidadLista.add(this.convertirClienteEntidad(resultado));
            }

            resultado.close();
            preparedStatement.close();
            conexion.close();

            return clienteEntidadLista;
        } catch (SQLException ex) {
            throw new PersistenciaException(ex.getMessage());
        }
    }

    /**
     * Busca clientes filtrando por su laboratorio de pertenencia.
     *
     * @param laboratorio ID del laboratorio.
     * @return Lista de clientes asociados al laboratorio.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    @Override
    public List<ClienteEntidad> buscarClientesPorLaboratorio(int laboratorio) throws PersistenciaException {
        try {
            String consultaSQL = """
                                 SELECT * From Clientes WHERE idLaboratorio=?;                                 
                                 """;
            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement preparedStatement = conexion.prepareStatement(consultaSQL);
            preparedStatement.setInt(1, laboratorio);
            ResultSet resultado = preparedStatement.executeQuery();

            List<ClienteEntidad> ClientesEntidadLista = null;
            while (resultado.next()) {
                if (ClientesEntidadLista == null) {
                    ClientesEntidadLista = new ArrayList<>();
                }

                ClientesEntidadLista.add(this.convertirClienteEntidad(resultado));
            }

            resultado.close();
            preparedStatement.close();
            conexion.close();

            return ClientesEntidadLista;
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new PersistenciaException(ex.getMessage());
        }

    }

    /**
     * Convierte un registro de la base de datos en un objeto ClienteEntidad.
     *
     * @param resultado ResultSet obtenido de la consulta.
     * @return Objeto ClienteEntidad con los datos del cliente.
     * @throws SQLException Si ocurre un error al acceder a los datos.
     */
    //CONVERTIR CLIENTE A ENTIDAD 
    private ClienteEntidad convertirClienteEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("idCliente");
        String nombres = resultado.getString("nombres");
        String apellidoPaterno = resultado.getString("apellidoPaterno");
        String apellidoMaterno = resultado.getString("apellidoMaterno");
        // pasar la fecha a localDate
        Date sqlDate = resultado.getDate("fechaNacimiento");
        LocalDate fechaNacimiento = sqlDate.toLocalDate();
        int idLaboratorio = resultado.getInt("idLaboratorio");
        return new ClienteEntidad(id, nombres, apellidoPaterno, apellidoMaterno, fechaNacimiento, idLaboratorio);
    }

    /**
     * Guarda un nuevo cliente en la base de datos.
     *
     * @param cliente DTO con los datos del cliente a guardar.
     * @return ClienteEntidad con los datos del cliente guardado.
     * @throws PersistenciaException Si ocurre un error en la inserción.
     */
    @Override
    public ClienteEntidad guardar(GuardarClienteDTO cliente) throws PersistenciaException {
        try {
            ClienteEntidad clienteEntidad;
            Connection conexion = this.conexionBD.crearConexion();
            String insertCliente = """
                                    INSERT INTO `Clientes` (`nombres`,
                                                           `apellidoPaterno`,
                                                           `apellidoMaterno`,
                                                           `fechaNacimiento`, 
                                                            `idLaboratorio`
                                                            )
                                                   VALUES (?, ? , ? , ?,?);
                                    """;

            PreparedStatement preparedStatement = conexion.prepareStatement(insertCliente, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, cliente.getNombres());
            preparedStatement.setString(2, cliente.getApellidoPaterno());
            preparedStatement.setString(3, cliente.getApellidoMaterno());
            preparedStatement.setDate(4, Date.valueOf(cliente.getFechaNacimiento()));
            //El laboratorio se introducire en DTO donde sera LabEntidad quien lo tendra
            preparedStatement.setInt(5, cliente.getIdLaboratorio());

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("La inserción del cliente falló, no se pudo insertar el registro.");
            }

            // obtener id generado
            ResultSet resultado = preparedStatement.getGeneratedKeys();
            if (resultado.next()) {
                int idCliente = (resultado.getInt(1));

                resultado.close();
                preparedStatement.close();
                conexion.close();
                return buscarPorId(idCliente);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new PersistenciaException("Ocurrió un error al leer la base de datos, inténtelo de nuevo y si el error persiste comuníquese con el encargado del sistema.");
        }
        // regresa un nulo

        return null;
    }

    @Override
    public ClienteEntidad guardarConTransaccion(GuardarClienteDTO cliente) throws PersistenciaException {
        return null;
    }

    /**
     * Actualiza la información de un cliente en la base de datos.
     *
     * @param cliente ClienteEntidad con los datos actualizados.
     * @return ClienteEntidad con la información actualizada desde la base de datos.
     * @throws PersistenciaException Si ocurre un error en la actualización o el cliente no existe.
     */
    @Override
    public ClienteEntidad editar(ClienteEntidad cliente) throws PersistenciaException {
        try {
            ClienteEntidad clienteEntidad;
            ;
            String updateSQL = """
                             UPDATE Clientes
                             SET nombres = ?,
                             apellidoPaterno = ?,
                             apellidoMaterno = ?,
                             fechaNacimiento=?
                             WHERE idCliente = ?;
                             """;
            PreparedStatement prepararConsulta = this.conexionBD.crearConexion().prepareStatement(updateSQL);
            prepararConsulta.setString(1, cliente.getNombres());
            prepararConsulta.setString(2, cliente.getApellidoPaterno());
            prepararConsulta.setString(3, cliente.getApellidoMaterno());
            //getFecha = LocalDate
            prepararConsulta.setDate(4, Date.valueOf(cliente.getFechaNacimiento()));
            prepararConsulta.setInt(5, cliente.getId());

            int filasAfectadas = prepararConsulta.executeUpdate();
            prepararConsulta.close();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se pudo actualizar cliente");
            }

            return buscarPorId(cliente.getId());

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al editar alumno" + ex.getMessage());
        }

    }

    /**
     * Elimina un cliente de la base de datos según su ID.
     *
     * @param id Identificador del cliente a eliminar.
     * @return ClienteEntidad con la información del cliente eliminado.
     * @throws PersistenciaException Si ocurre un error al eliminar o si el cliente no existe.
     */

    @Override
    public ClienteEntidad eliminar(int id) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            String consultaSQL = """
                             DELETE FROM Clientes
                             WHERE idCliente = ?;
                             """;
            try (PreparedStatement prepararConsulta = conexion.prepareStatement(consultaSQL)) {
                prepararConsulta.setInt(1, id);
                ClienteEntidad eliminado = buscarPorId(id);
                int filasAfectadas = prepararConsulta.executeUpdate(); // Se usa executeUpdate()

                if (filasAfectadas == 0) {
                    throw new PersistenciaException("No se encontró un cliente con el ID proporcionado.");
                }
                return eliminado; // retorna el Cliente eliminado en la BD
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar el cliente: " + e.getMessage());
        }
    }

    /**
     * Busca un cliente por su ID.
     *
     * @param id ID del cliente a buscar.
     * @return ClienteEntidad con los datos encontrados, o null si no existe.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    @Override
    public ClienteEntidad buscarPorId(int id) throws PersistenciaException {

        try {
            Connection conexion = this.conexionBD.crearConexion();
            String consulta = "SELECT * FROM clientes WHERE idCliente = ?;"; // Se usa 'idCliente' como el nombre correcto de la columna en la base de datos
            PreparedStatement preparedStatement = conexion.prepareStatement(consulta);
            preparedStatement.setInt(1, id);

            ResultSet resultado = preparedStatement.executeQuery();
            if (resultado.next()) {
                // Crear la entidad ClienteEntidad con los datos obtenidos
                ClienteEntidad cliente = new ClienteEntidad(
                        resultado.getInt("idCliente"), // Asegúrate de que el campo sea 'idCliente' y no solo 'id'
                        resultado.getString("nombres"),
                        resultado.getString("apellidoPaterno"), // Asegúrate de que el nombre de la columna sea 'apellidoPaterno'
                        resultado.getString("apellidoMaterno"), // Asegúrate de que el nombre de la columna sea 'apellidoMaterno'
                        resultado.getDate("fechaNacimiento").toLocalDate(), // Convertir la fecha de SQL a LocalDate
                        resultado.getInt("idLaboratorio") // Asignar el idLaboratorio correctamente
                );

                resultado.close();
                preparedStatement.close();
                conexion.close();
                return cliente;
            }

            resultado.close();
            preparedStatement.close();
            conexion.close();
            return null; // Si no se encuentra el cliente, retornamos null

        } catch (SQLException ex) {
            throw new PersistenciaException("Error al buscar el cliente: " + ex.getMessage());
        }
    }

}

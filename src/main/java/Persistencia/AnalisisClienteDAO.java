/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.AnalisisClienteDTO;
import Entidades.AnalisisClienteEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase de acceso a datos para la entidad AnalisisClienteEntidad. Se encarga de gestionar la persistencia de los análisis de clientes en la base de datos.
 *
 * @author Jack Murrieta
 */
public class AnalisisClienteDAO implements IAnalisisClientes {

    private IConexionBD conexion;

    /**
     * Constructor que inicializa la conexión a la base de datos.
     *
     * @param conexion Objeto de conexión a la base de datos.
     */
    public AnalisisClienteDAO(IConexionBD conexion) {
        this.conexion = conexion;
    }

    /**
     * Inserta un nuevo análisis de cliente en la base de datos.
     *
     * @param analisisCliente Objeto AnalisisClienteEntidad con los datos del análisis a registrar.
     * @return AnalisisClienteEntidad con los datos insertados y su ID generado.
     * @throws PersistenciaException Si ocurre un error al insertar el análisis en la base de datos.
     */
    @Override
    public AnalisisClienteEntidad generarUnAnalisisCliente(AnalisisClienteEntidad analisisCliente) throws PersistenciaException {

        String sql = "INSERT INTO AnalisisClientes (folio, fechaYhoraCaptura, idCliente) VALUES (?, ?, ?)";
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, analisisCliente.getFolio());
            stmt.setTimestamp(2, Timestamp.valueOf(analisisCliente.getFechaYhoraCaptura()));
            stmt.setInt(3, analisisCliente.getIdCliente());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se pudo insertar el analisisCliente en BD");
            }
            //obtener id generado de analisisCliente
            int idCliente = analisisCliente.getIdCliente();
            ResultSet resultado = stmt.getGeneratedKeys();
            if (resultado.next()) {
                int idAnalisisCliente = resultado.getInt(1);
                resultado.close();
                stmt.close();
                return buscarAnalisisClienteID(idAnalisisCliente, idCliente);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebaAnalisisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Convierte un resultado de consulta SQL en un objeto AnalisisClienteEntidad.
     *
     * @param resultado ResultSet con los datos obtenidos de la base de datos.
     * @return Objeto AnalisisClienteEntidad con los datos convertidos.
     * @throws SQLException Si ocurre un error al extraer los datos del ResultSet.
     */
    private AnalisisClienteEntidad convertirAnalisisCliente(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("idAnalisisCliente");
        int folio = resultado.getInt("folio");
        // Obtener el Timestamp desde el ResultSet
        Timestamp timestamp = resultado.getTimestamp("fechaYHoraCaptura");
        // Convertir a LocalDateTime
        LocalDateTime fechaYhoraCaptura = timestamp.toLocalDateTime();
        int idCliente = resultado.getInt("idCliente");
        return new AnalisisClienteEntidad(id, folio, fechaYhoraCaptura, idCliente);
    }

    /**
     * Busca un análisis de cliente en la base de datos por su ID y el ID del cliente.
     *
     * @param idAnalisisCliente Identificador del análisis de cliente.
     * @param idCliente Identificador del cliente asociado al análisis.
     * @return AnalisisClienteEntidad con los datos encontrados o null si no existe.
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    public AnalisisClienteEntidad buscarAnalisisClienteID(int idAnalisisCliente, int idCliente) throws PersistenciaException {
        AnalisisClienteEntidad analisisEncontrado = null;
        try {
            String sql = "SELECT * FROM AnalisisClientes WHERE idAnalisisCliente = ? AND idCliente= ?";
            Connection connection = conexion.crearConexion();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idAnalisisCliente);
            stmt.setInt(2, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // convertir Analisis en entidad
                    return analisisEncontrado = convertirAnalisisCliente(rs);
                }
                connection.close();
                stmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException("No se encontro el analisis del cliente en la BD");
        }
        return analisisEncontrado;

    }

    /**
     * Obtiene una lista de todos los análisis de un cliente en la base de datos.
     *
     * @param idCliente Identificador del cliente cuyos análisis se desean obtener.
     * @return Lista de AnalisisClienteEntidad con los análisis encontrados.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */

    @Override
    public List<AnalisisClienteEntidad> listarAnalisisPorCliente(int idCliente) throws PersistenciaException {
        try {
            String sql = "SELECT * FROM AnalisisClientes WHERE idCliente = ?";

            Connection conexion = this.conexion.crearConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idCliente);
            ResultSet rs = pstmt.executeQuery();

            List<AnalisisClienteEntidad> listaAnalisisCliente = null;
            while (rs.next()) {
                if (listaAnalisisCliente == null) {
                    listaAnalisisCliente = new ArrayList<>();
                }
                listaAnalisisCliente.add(convertirAnalisisCliente(rs));
            }
            rs.close();
            conexion.close();
            pstmt.close();
            return listaAnalisisCliente;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Obtiene el último número de folio registrado en la base de datos.
     *
     * @return El último folio registrado o 0 si no hay registros.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    public Integer obtenerUltimoFolio() throws PersistenciaException {
        String sql = "SELECT MAX(folio) AS ultimoFolio FROM AnalisisClientes";
        try (Connection conexion = this.conexion.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(sql); ResultSet resultado = stmt.executeQuery()) {

            if (resultado.next()) {
                return resultado.getInt("ultimoFolio"); // Retorna el último folio encontrado
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al obtener el último folio de la BD");
        }
        return 0; // Si no hay registros, se empieza desde 0
    }

}

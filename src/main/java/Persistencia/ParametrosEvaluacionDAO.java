/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTOS.ParametrosDTO;
import Entidades.ParametrosEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que maneja la persistencia de los parámetros de evaluación en la base de datos.
 * Implementa la interfaz {@code IParametrosEvaluacionDAO}.
 * Se encarga de realizar operaciones CRUD sobre la tabla ParametrosEvaluacion.
 * 
 * @author Jack Murrieta
 */
public class ParametrosEvaluacionDAO implements IParametrosEvaluacionDAO {

    private IConexionBD conexionBD;
    /**
     * Constructor que recibe una conexión a la base de datos.
     * 
     * @param conexionBD Objeto que maneja la conexión con la base de datos.
     */
    public ParametrosEvaluacionDAO(IConexionBD conexionBD) {
        this.conexionBD = new ConexionBD();
    }
    /**
     * Registra una lista de parámetros de evaluación asociados a una prueba de análisis en la base de datos.
     * 
     * @param parametros Lista de parámetros a registrar.
     * @param idPruebaAnalisis Identificador de la prueba de análisis asociada.
     * @return Lista de parámetros registrados con sus respectivos IDs generados.
     * @throws PersistenciaException Si ocurre un error en la operación de persistencia.
     */
    @Override
    public List<ParametrosEntidad> registrarParametros(List<ParametrosEntidad> parametros, int idPruebaAnalisis) throws PersistenciaException {
        String sql = "INSERT INTO parametrosevaluacion (nombre, rango, idPruebaAnalisis) VALUES (?, ?, ?)";
        List<ParametrosEntidad> parametrosRegistrados = new ArrayList<>();

        try (Connection conexion = this.conexionBD.crearConexion()) {
            conexion.setAutoCommit(false); // Iniciar transacción

            try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                for (ParametrosEntidad parametro : parametros) {
                    stmt.setString(1, parametro.getNombre());
                    stmt.setString(2, parametro.getRango());
                    stmt.setInt(3, idPruebaAnalisis);
                    stmt.executeUpdate();

                    ResultSet resultado = stmt.getGeneratedKeys();
                    if (resultado.next()) {
                        int idParametroE = resultado.getInt(1);
                        parametro.setIdParametroEvaluacion(idParametroE); // Asignar el ID generado
                        parametro.setIdPruebaAnalisis(idPruebaAnalisis);  // Asociar a la prueba de análisis
                        parametrosRegistrados.add(parametro);
                    }
                    resultado.close();
                }

                conexion.commit(); // Confirmar la transacción

            } catch (SQLException e) {
                conexion.rollback(); // Revertir en caso de error
                throw new PersistenciaException("Error al insertar los parámetros: " + e.getMessage());
            } finally {
                conexion.setAutoCommit(true); // Restaurar el estado original
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al conectar con la base de datos: " + e.getMessage());
        }

        return parametrosRegistrados;
    }
        /**
     * Registra un solo parámetro de evaluación en la base de datos.
     * 
     * @param parametro Objeto {@code ParametrosEntidad} que representa el parámetro a registrar.
     * @return El parámetro registrado con su ID asignado o {@code null} si no se pudo registrar.
     */

    @Override
    public ParametrosEntidad registrarParametro(ParametrosEntidad parametro) {
        String sql = "INSERT INTO parametrosevaluacion (nombre, rango, idPruebaAnalisis) VALUES (?, ?, ?)";
        try (Connection conexion = this.conexionBD.crearConexion(); PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, parametro.getNombre());
            stmt.setString(2, parametro.getRango());
            stmt.setInt(3, parametro.getIdPruebaAnalisis());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se pudo insertar el parámetro.");
            }

            // Obtener ID generado
            ResultSet resultado = stmt.getGeneratedKeys();
            if (resultado.next()) {
                int idParametroE = resultado.getInt(1);
                resultado.close();
                return obtenerPruebaAnalisis(idParametroE, parametro.getIdPruebaAnalisis());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebaAnalisisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

        /**
     * Busca un parámetro de evaluación por su ID y el ID de la prueba de análisis.
     * 
     * @param idParametro Identificador del parámetro de evaluación.
     * @param idPruebaAnalisis Identificador de la prueba de análisis asociada.
     * @return El parámetro encontrado o {@code null} si no existe.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */

    private ParametrosEntidad obtenerPruebaAnalisis(int idParametro, int idPruebaAnalisis) throws PersistenciaException {

        ParametrosEntidad paramEncontrado = null;
        try {
            String sql = "SELECT * FROM ParametrosEvaluacion WHERE idParametroEvaluacion = ? AND idPruebaAnalisis= ?";
            Connection connection = conexionBD.crearConexion();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idParametro);
            stmt.setInt(2, idPruebaAnalisis);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // convertir parametro en entidad
                    return paramEncontrado = convertirParamEntidad(rs);
                }
                connection.close();
                stmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException("No se encontro la PruebaAnalisis en la BD");
        }
        return paramEncontrado;
    }

        /**
     * Elimina un parámetro de evaluación de una prueba de análisis.
     * 
     * @param idParam Identificador del parámetro a eliminar.
     * @param idPrueba Identificador de la prueba de análisis asociada.
     * @return El parámetro eliminado o {@code null} si no se encontró.
     * @throws PersistenciaException Si ocurre un error durante la eliminación.
     */
    @Override
    public ParametrosEntidad eliminarParametroEnPrueba(int idParam, int idPrueba) throws PersistenciaException {
        try (Connection conexion = this.conexionBD.crearConexion()) {
            String consultaSQL = """
                             DELETE FROM ParametrosEvaluacion WHERE idParametroEvaluacion = ? AND idPruebaAnalisis= ?
                             """;
            try (PreparedStatement prepararConsulta = conexion.prepareStatement(consultaSQL)) {
                prepararConsulta.setInt(1, idParam);
                prepararConsulta.setInt(2, idPrueba);
                ParametrosEntidad eliminado = obtenerPruebaAnalisis(idParam, idPrueba);
                int filasAfectadas = prepararConsulta.executeUpdate(); // Se usa executeUpdate()

                if (filasAfectadas == 0) {
                    throw new PersistenciaException("No se encontró un parametro Evaluacion en la BD.");
                }
                return eliminado; // retorna el paramEliminado  en la BD
            }

        } catch (SQLException e) {
            throw new PersistenciaException("Error al eliminar el parametro de la prueba: " + e.getMessage());
        }

    }
    
        /**
     * Convierte un {@code ResultSet} en una instancia de {@code ParametrosEntidad}.
     * 
     * @param resultado Resultado de una consulta SQL.
     * @return Objeto {@code ParametrosEntidad} con los datos extraídos.
     * @throws SQLException Si ocurre un error al acceder a los datos del resultado.
     */
    private ParametrosEntidad convertirParamEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("idParametroEvaluacion");
        String nombre = resultado.getString("nombre");
        String rango = resultado.getString("rango");
        int idPrueba = resultado.getInt("idPruebaAnalisis");
        return new ParametrosEntidad(id, nombre, rango, idPrueba);

    }
    /**
     * Obtiene la lista de parámetros de evaluación asociados a una prueba de análisis específica.
     *
     * @param idPruebaAnalisis Identificador de la prueba de análisis.
     * @return Lista de parámetros asociados a la prueba. Retorna {@code null} si ocurre un error o no hay parámetros.
     */
    @Override
    public List<ParametrosEntidad> parametrosEnUnaPrueba(int idPruebaAnalisis) {
        try {
            String sql = "SELECT * FROM ParametrosEvaluacion WHERE idPruebaAnalisis = ?";

            Connection conexion = this.conexionBD.crearConexion();
            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setInt(1, idPruebaAnalisis);
            ResultSet rs = pstmt.executeQuery();

            List<ParametrosEntidad> listaParametros = null;
            while (rs.next()) {
                if (listaParametros == null) {
                    listaParametros = new ArrayList<>();
                }
                listaParametros.add(convertirParamEntidad(rs));
            }
            rs.close();
            conexion.close();
            pstmt.close();
            return listaParametros;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

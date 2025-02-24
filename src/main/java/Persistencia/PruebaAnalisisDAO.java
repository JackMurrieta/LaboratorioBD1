/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import DTOS.PruebaAnalisisDTO;
import Entidades.PruebaAnalisisEntidad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Jack Murrieta
 */

/**
 * Clase que implementa la interfaz IPruebaAnalisisDAO para gestionar
 * operaciones en la base de datos relacionadas con la entidad PruebaAnalisis.
 */
public class PruebaAnalisisDAO implements IPruebaAnalisisDAO {
    private IConexionBD conexion;  // Usar IConexionBD en lugar de Connection

      /**
     * Constructor que recibe una conexión a la base de datos.
     * 
     * @param conexionBD Objeto de tipo IConexionBD para establecer la conexión.
     */
    // Modificar el constructor para que reciba IConexionBD
    public PruebaAnalisisDAO(IConexionBD conexionBD) {
        this.conexion = conexionBD;
    }

    /**
     * Registra una nueva prueba de análisis en la base de datos.
     * 
     * @param prueba Objeto PruebaAnalisisEntidad con los datos de la prueba a registrar.
     * @return La prueba registrada con su ID generado, o null si ocurrió un error.
     */
   @Override
    public PruebaAnalisisEntidad registrar(PruebaAnalisisEntidad prueba) {
        
        String sql = "INSERT INTO PruebasAnalisis (nombre, idCategoria, idLaboratorio) VALUES (?, ?, ?)";
        try {
            Connection conexion = this.conexion.crearConexion();
            PreparedStatement stmt = conexion.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, prueba.getNombre());
            stmt.setInt(2, prueba.getIdCategoria());
            stmt.setInt(3, prueba.getIdLaboratorio());

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas == 0) {
                throw new PersistenciaException("No se pudo insertar la Prueba Analisis");
            }
            //obtener id generado de pruebaAnalisis
            int idLab = prueba.getIdLaboratorio();
            ResultSet resultado = stmt.getGeneratedKeys();
            if (resultado.next()) {
                int idPrueba = resultado.getInt(1);
                resultado.close();
                stmt.close();
                return buscarPorId(idPrueba, idLab);
                
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (PersistenciaException ex) {
            Logger.getLogger(PruebaAnalisisDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

 /**
     * Busca una prueba de análisis por su ID en la base de datos.
     * 
     * @param idPrueba ID de la prueba de análisis a buscar.
     * @param idLaboratorio ID del laboratorio asociado a la prueba.
     * @return La entidad de prueba de análisis encontrada o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la búsqueda.
     */
 @Override
    public PruebaAnalisisEntidad buscarPorId(int idPrueba,int idLaboratorio) throws PersistenciaException {

        PruebaAnalisisEntidad pruebaEncontrada = null;
        try {
            String sql = "SELECT * FROM PruebasAnalisis WHERE idPruebaAnalisis = ? AND idLaboratorio= ?";
            Connection connection = conexion.crearConexion();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, idPrueba);
            stmt.setInt(2, idLaboratorio);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // convertir Prueba en entidad
                    return pruebaEncontrada = convertirPruebaAnalisisEntidad(rs);
                }
                connection.close();
                stmt.close();
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException("No se encontro la PruebaAnalisis en la BD");
        }
        return pruebaEncontrada;
    }
   
     /**
     * Convierte un ResultSet en una entidad PruebaAnalisisEntidad.
     * 
     * @param resultado ResultSet con los datos de la prueba de análisis.
     * @return Una instancia de PruebaAnalisisEntidad con los datos obtenidos.
     * @throws SQLException Si ocurre un error al leer el ResultSet.
     */
   private PruebaAnalisisEntidad convertirPruebaAnalisisEntidad(ResultSet resultado) throws SQLException{
       int id = resultado.getInt("idPruebaAnalisis");
       String nombre = resultado.getString("nombre");
       int idCategoria = resultado.getInt("idCategoria");
       int idLaboratorio = resultado.getInt("idLaboratorio");
       return new PruebaAnalisisEntidad(id, nombre, idCategoria, idLaboratorio);

   } 

    /**
     * Lista todas las pruebas de análisis de un laboratorio específico.
     * 
     * @param idLaboratorio ID del laboratorio del cual se listarán las pruebas.
     * @return Lista de pruebas de análisis asociadas al laboratorio.
     * @throws PersistenciaException Si ocurre un error al listar las pruebas.
     */
    @Override
    public List<PruebaAnalisisEntidad> listarPruebasAnalisis(int idLaboratorio) throws PersistenciaException {
        List<PruebaAnalisisEntidad> listaPruebas = new ArrayList<>();

        String sql = "SELECT * FROM PruebasAnalisis WHERE idLaboratorio = ?";

        try (Connection connection = conexion.crearConexion(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, idLaboratorio);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    listaPruebas.add(convertirPruebaAnalisisEntidad(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistenciaException("Error al listar las pruebas del laboratorio en la BD");
        }

        return listaPruebas;
    }

}


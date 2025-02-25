/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 * Clase de acceso a datos para la entidad CategoriaEntidad. Implementa las operaciones para obtener información de la base de datos.
 *
 * @author Jack Murrieta
 */
import Entidades.CategoriaEntidad;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class CategoriasDAO implements ICategoriasDAO {

    private IConexionBD conexionBD;

    /**
     * Constructor que inicializa el acceso a la base de datos.
     *
     * @param conexionBD Objeto de conexión a la base de datos.
     */
    public CategoriasDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Obtiene una lista con todas las categorías almacenadas en la base de datos.
     *
     * @return Lista de objetos CategoriaEntidad con los datos de cada categoría.
     */
    @Override
    public List<CategoriaEntidad> obtenerCategorias() {
        List<CategoriaEntidad> categorias = new ArrayList<>();
        String query = "SELECT * FROM Categorias";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement statement = connection.prepareStatement(query); ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                categorias.add(convertirCategoriaEntidad(resultSet));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CategoriasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categorias;
    }

    /**
     * Obtiene una categoría específica según su identificador.
     *
     * @param idCategoria Identificador de la categoría a buscar.
     * @return Objeto CategoriaEntidad si se encuentra en la base de datos, de lo contrario, retorna null.
     */
    @Override
    public CategoriaEntidad obtenerCategoriaPorId(int idCategoria) {
        CategoriaEntidad categoria = null;
        String query = "SELECT * FROM Categorias WHERE idCategoria = ?";

        try (Connection connection = conexionBD.crearConexion(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, idCategoria);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    categoria = convertirCategoriaEntidad(resultSet);
                }
                resultSet.close();

            }
            connection.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(CategoriasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return categoria;
    }

    /**
     * Convierte un objeto ResultSet en una instancia de CategoriaEntidad.
     *
     * @param resultado ResultSet con los datos de la categoría.
     * @return Objeto CategoriaEntidad con los datos extraídos del ResultSet.
     * @throws SQLException Si ocurre un error al acceder a los datos.
     */
    private CategoriaEntidad convertirCategoriaEntidad(ResultSet resultado) throws SQLException {
        int id = resultado.getInt("idCategoria");
        String nombre = resultado.getString("nombre");
        return new CategoriaEntidad(id, nombre);

    }

        

}


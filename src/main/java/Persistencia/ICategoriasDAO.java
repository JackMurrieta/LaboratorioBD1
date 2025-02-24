/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.CategoriaEntidad;
import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define las operaciones de acceso a datos para la entidad Categoría.
 * Permite obtener información sobre las categorías almacenadas en la base de datos.
 * 
 * @author Jack Murrieta
 */
public interface ICategoriasDAO {

    /**
     * Obtiene la lista de todas las categorías registradas en la base de datos.
     * 
     * @return Lista de objetos {@code CategoriaEntidad}.
     * @throws SQLException Si ocurre un error en la consulta a la base de datos.
     */
    List<CategoriaEntidad> obtenerCategorias() throws SQLException;

    /**
     * Obtiene una categoría específica a partir de su ID.
     * 
     * @param idCategoria ID de la categoría a buscar.
     * @return Objeto {@code CategoriaEntidad} si se encuentra en la base de datos.
     * @throws SQLException Si ocurre un error en la consulta o la categoría no existe.
     */
    CategoriaEntidad obtenerCategoriaPorId(int idCategoria) throws SQLException;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.CategoriaDTO;
import Entidades.CategoriaEntidad;
import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio relacionadas con las categorías.
 * Proporciona métodos para obtener todas las categorías y buscar una categoría específica por su ID.
 * 
 * @author Jack Murrieta
 */
public interface ICategoriasNegocio {

    /**
     * Convierte una lista de entidades de categorías en una lista de objetos DTO.
     * 
     * @param categorias Lista de objetos {@link CategoriaEntidad} que se convertirán a DTO.
     * @return Una lista de objetos {@link CategoriaDTO} con la información de las categorías.
     * @throws NegocioException Si ocurre un error durante la conversión o recuperación de datos.
     */
    List<CategoriaDTO> obtenerCategorias(List<CategoriaEntidad> categorias) throws NegocioException;

    /**
     * Obtiene la información de una categoría específica con base en su identificador.
     * 
     * @param idCategoria Identificador único de la categoría a buscar.
     * @return Un objeto {@link CategoriaDTO} con los datos de la categoría encontrada.
     * @throws NegocioException Si la categoría no existe o hay un error en la búsqueda.
     */
    CategoriaDTO obtenerCategoriaPorId(int idCategoria) throws NegocioException;
}


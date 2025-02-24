/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.CategoriaDTO;
import Entidades.CategoriaEntidad;
import Negocio.NegocioException;
import Persistencia.ICategoriasDAO;
import Persistencia.PersistenciaException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que maneja la lógica de negocio relacionada con las categorías. Implementa la interfaz {@link ICategoriasNegocio}.
 *
 * @author Usuario
 */
public class CategoriasNegocio implements ICategoriasNegocio {

    private final ICategoriasDAO categoriasDAO;

    /**
     * Constructor que inicializa el DAO de categorías.
     *
     * @param categoriasDAO Objeto que permite el acceso a la base de datos para operaciones de categorías.
     */
    public CategoriasNegocio(ICategoriasDAO categoriasDAO) {
        this.categoriasDAO = categoriasDAO;
    }

    /**
     * Convierte una lista de entidades de categorías en una lista de DTOs.
     *
     * @param categorias Lista de entidades de categoría obtenidas desde la base de datos.
     * @return Lista de objetos {@link CategoriaDTO} con la información de las categorías.
     * @throws NegocioException Si ocurre un error en la conversión.
     */
    @Override
    public List<CategoriaDTO> obtenerCategorias(List<CategoriaEntidad> categorias) throws NegocioException {
        if (categorias == null) {
            return null;
        }
        List<CategoriaDTO> categoriasDTO = new ArrayList<>();
        for (CategoriaEntidad item : categorias) {
            CategoriaDTO dato = new CategoriaDTO(
                    item.getIdCategoria(),
                    item.getNombre()
            );
            categoriasDTO.add(dato);
        }

        return categoriasDTO;
    }

    /**
     * Obtiene una categoría por su ID desde la base de datos y la convierte en un DTO.
     *
     * @param idCategoria ID de la categoría a buscar.
     * @return Un objeto {@link CategoriaDTO} con la información de la categoría.
     * @throws NegocioException Si no se encuentra la categoría o si ocurre un error en la consulta.
     */
    @Override
    public CategoriaDTO obtenerCategoriaPorId(int idCategoria) throws NegocioException {
        CategoriaDTO categoriaDTO = null;
        try {
            CategoriaEntidad categoria = categoriasDAO.obtenerCategoriaPorId(idCategoria);
            if (categoria == null) {
                throw new NegocioException("No se encontró la categoría con ID: " + idCategoria);
            }
            return categoriaDTO = convertirCategoriaDTO(categoria);
        } catch (SQLException ex) {
            Logger.getLogger(CategoriasNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categoriaDTO;
    }

    /**
     * Convierte una entidad de categoría en un DTO para su uso en la capa de negocio.
     *
     * @param categoria Objeto {@link CategoriaEntidad} obtenido de la base de datos.
     * @return Un objeto {@link CategoriaDTO} con la información de la categoría.
     */
    public CategoriaDTO convertirCategoriaDTO(CategoriaEntidad categoria) {
        if (categoria == null) {
            return null;
        }
        int id = categoria.getIdCategoria();
        String nombre = categoria.getNombre();
        CategoriaDTO categoriaDTO = new CategoriaDTO(id, nombre);
        return categoriaDTO;

    }
}

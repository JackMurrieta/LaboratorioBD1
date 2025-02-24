/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.ParametrosDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la gestión de parámetros de evaluación
 * en una prueba de análisis. Permite registrar, eliminar y listar parámetros asociados a una prueba.
 * 
 * @author Jack Murrieta
 */
public interface IParametrosEvaluacionNegocio {
    
    /**
     * Registra un nuevo parámetro de evaluación en una prueba de análisis.
     * 
     * @param parametro Objeto {@link ParametrosDTO} con la información del parámetro a registrar.
     * @return Un objeto {@link ParametrosDTO} con los datos del parámetro registrado.
     * @throws NegocioException Si ocurre un error durante el registro del parámetro.
     */
    ParametrosDTO registrarParametro(ParametrosDTO parametro) throws NegocioException;

    /**
     * Elimina un parámetro de evaluación de una prueba de análisis específica.
     * 
     * @param idParam Identificador del parámetro a eliminar.
     * @param idPrueba Identificador de la prueba de análisis a la que pertenece el parámetro.
     * @return Un objeto {@link ParametrosDTO} con los datos del parámetro eliminado.
     * @throws NegocioException Si ocurre un error al eliminar el parámetro.
     */
    ParametrosDTO eliminarParametroEnPrueba(int idParam, int idPrueba) throws NegocioException;

    /**
     * Obtiene una lista de parámetros de evaluación asociados a una prueba de análisis.
     * 
     * @param idPrueba Identificador de la prueba de análisis.
     * @return Una lista de objetos {@link ParametrosDTO} con los parámetros encontrados.
     * @throws NegocioException Si ocurre un error al recuperar los parámetros.
     */
    List<ParametrosDTO> parametrosEnUnaPrueba(int idPrueba) throws NegocioException;

    /**
     * Registra múltiples parámetros de evaluación en una prueba de análisis.
     * 
     * @param parametrosDTO Lista de objetos {@link ParametrosDTO} con los parámetros a registrar.
     * @param idPruebaAnalisis Identificador de la prueba de análisis a la que se asociarán los parámetros.
     * @return Una lista de objetos {@link ParametrosDTO} con los parámetros registrados.
     * @throws NegocioException Si ocurre un error al registrar los parámetros.
     */
    List<ParametrosDTO> registrarParametros(List<ParametrosDTO> parametrosDTO, int idPruebaAnalisis) throws NegocioException;
}


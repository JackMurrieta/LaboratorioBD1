/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.ParametrosDTO;
import Entidades.ParametrosEntidad;
import java.util.List;

/**
 * Interfaz que define los métodos para gestionar los parámetros de evaluación 
 * asociados a pruebas de análisis en la base de datos.
 * Proporciona funcionalidades para registrar, eliminar y listar parámetros.
 * 
 * @author oribi
 */
public interface IParametrosEvaluacionDAO {

    /**
     * Registra un nuevo parámetro de evaluación en la base de datos.
     * 
     * @param parametro Objeto {@code ParametrosEntidad} que contiene la información del parámetro a registrar.
     * @return El objeto {@code ParametrosEntidad} registrado con su ID asignado.
     * @throws PersistenciaException Si ocurre un error al insertar el parámetro en la base de datos.
     */
    ParametrosEntidad registrarParametro(ParametrosEntidad parametro) throws PersistenciaException;

    /**
     * Elimina un parámetro de evaluación asociado a una prueba específica.
     * 
     * @param idParam Identificador del parámetro de evaluación a eliminar.
     * @param idPrueba Identificador de la prueba de análisis a la que pertenece el parámetro.
     * @return El objeto {@code ParametrosEntidad} eliminado.
     * @throws PersistenciaException Si el parámetro no se encuentra en la base de datos o ocurre un error al eliminarlo.
     */
    ParametrosEntidad eliminarParametroEnPrueba(int idParam, int idPrueba) throws PersistenciaException;

    /**
     * Obtiene una lista de todos los parámetros de evaluación asociados a una prueba de análisis.
     * 
     * @param idPrueba Identificador de la prueba de análisis de la cual se quieren obtener los parámetros.
     * @return Una lista de objetos {@code ParametrosEntidad} que representan los parámetros encontrados,
     *         o {@code null} si no hay parámetros registrados.
     */
    List<ParametrosEntidad> parametrosEnUnaPrueba(int idPrueba);

    /**
     * Registra múltiples parámetros de evaluación asociados a una prueba de análisis en la base de datos.
     * 
     * @param parametros Lista de objetos {@code ParametrosEntidad} que contienen la información de los parámetros a registrar.
     * @param idPruebaAnalisis Identificador de la prueba de análisis a la que se asociarán los parámetros.
     * @return Una lista de objetos {@code ParametrosEntidad} con los parámetros registrados y sus IDs asignados.
     * @throws PersistenciaException Si ocurre un error al insertar los parámetros en la base de datos.
     */
    List<ParametrosEntidad> registrarParametros(List<ParametrosEntidad> parametros, int idPruebaAnalisis) throws PersistenciaException;
}


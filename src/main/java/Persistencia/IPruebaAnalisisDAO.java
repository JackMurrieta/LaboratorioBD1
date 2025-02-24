/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

/**
 * Interfaz que define los métodos para la gestión de pruebas de análisis en la base de datos.
 * Permite registrar, listar y buscar pruebas de análisis por su identificador.
 * 
 * @author oribi
 */
import DTOS.PruebaAnalisisDTO;
import Entidades.PruebaAnalisisEntidad;
import java.sql.Connection;
import java.util.List;

public interface IPruebaAnalisisDAO {

    /**
     * Registra una nueva prueba de análisis en la base de datos.
     *
     * @param prueba Objeto {@code PruebaAnalisisEntidad} que contiene la información de la prueba a registrar.
     * @return La entidad {@code PruebaAnalisisEntidad} registrada con su ID asignado, o {@code null} si no se pudo registrar.
     */
    PruebaAnalisisEntidad registrar(PruebaAnalisisEntidad prueba);

    /**
     * Lista todas las pruebas de análisis asociadas a un laboratorio específico.
     *
     * @param idLaboratorio Identificador del laboratorio del cual se desean obtener las pruebas de análisis.
     * @return Una lista de objetos {@code PruebaAnalisisEntidad} que representan las pruebas del laboratorio.
     * @throws PersistenciaException Si ocurre un error en la consulta a la base de datos.
     */
    List<PruebaAnalisisEntidad> listarPruebasAnalisis(int idLaboratorio) throws PersistenciaException;

    /**
     * Busca una prueba de análisis en la base de datos por su identificador y el laboratorio al que pertenece.
     *
     * @param idPrueba Identificador de la prueba de análisis a buscar.
     * @param idLaboratorio Identificador del laboratorio al que pertenece la prueba de análisis.
     * @return Un objeto {@code PruebaAnalisisEntidad} si la prueba es encontrada, de lo contrario {@code null}.
     * @throws PersistenciaException Si ocurre un error en la consulta a la base de datos o si no se encuentra la prueba.
     */
    PruebaAnalisisEntidad buscarPorId(int idPrueba, int idLaboratorio) throws PersistenciaException;
}



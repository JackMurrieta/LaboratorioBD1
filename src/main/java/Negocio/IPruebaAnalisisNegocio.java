/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;
import DTOS.PruebaAnalisisDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de negocio para la gestión de pruebas de análisis. Proporciona métodos para registrar, listar y obtener pruebas de análisis desde la capa de negocio.
 *
 * @author oribi
 */
public interface IPruebaAnalisisNegocio {

    /**
     * Registra una nueva prueba de análisis en el sistema.
     *
     * @param pruebaDTO Objeto {@link PruebaAnalisisDTO} que contiene la información de la prueba a registrar.
     * @return Un objeto {@link PruebaAnalisisDTO} con la prueba registrada y su ID generado.
     * @throws NegocioException Si ocurre un error durante el registro de la prueba.
     */
    public PruebaAnalisisDTO registrarPrueba(PruebaAnalisisDTO pruebaDTO) throws NegocioException;

    /**
     * Obtiene una lista de todas las pruebas de análisis registradas en un laboratorio específico.
     *
     * @param idLaboratorio Identificador del laboratorio del cual se listarán las pruebas.
     * @return Una lista de objetos {@link PruebaAnalisisDTO} con las pruebas registradas.
     * @throws NegocioException Si ocurre un error al obtener la lista de pruebas.
     */
    public List<PruebaAnalisisDTO> listarPruebas(int idLaboratorio) throws NegocioException;

    /**
     * Obtiene los detalles de una prueba de análisis específica.
     *
     * @param idPrueba Identificador de la prueba de análisis.
     * @param idLab Identificador del laboratorio al que pertenece la prueba.
     * @return Un objeto {@link PruebaAnalisisDTO} con los detalles de la prueba encontrada, o {@code null} si no se encuentra la prueba.
     * @throws NegocioException Si ocurre un error al buscar la prueba.
     */
    public PruebaAnalisisDTO obtenerPrueba(int idPrueba, int idLab) throws NegocioException;
}

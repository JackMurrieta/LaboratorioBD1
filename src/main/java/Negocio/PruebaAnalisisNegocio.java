/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 * Clase que maneja la lógica de negocio para la gestión de pruebas de análisis. Se encarga de la comunicación entre la capa de persistencia y la capa de presentación. Convierte los datos entre entidades y DTOs.
 *
 * @author oribi
 */
import DTOS.PruebaAnalisisDTO;
import Entidades.PruebaAnalisisEntidad;
import Persistencia.IConexionBD;
import Persistencia.IPruebaAnalisisDAO;
import Persistencia.PersistenciaException;
import Persistencia.PruebaAnalisisDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PruebaAnalisisNegocio implements IPruebaAnalisisNegocio {

    private IPruebaAnalisisDAO pruebaDAO;
    private IConexionBD conexionBD;

    /**
     * Constructor que inicializa la conexión a la base de datos y el DAO de pruebas de análisis.
     *
     * @param conexionBD Objeto que representa la conexión a la base de datos.
     */
    public PruebaAnalisisNegocio(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
        this.pruebaDAO = new PruebaAnalisisDAO(conexionBD); // Pasamos IConexionBD al DAO
    }

    /**
     * Registra una nueva prueba de análisis en la base de datos.
     *
     * @param pruebaDTO Objeto DTO que contiene los datos de la prueba de análisis a registrar.
     * @return PruebaAnalisisDTO con los datos de la prueba registrada, incluyendo su ID generado.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    @Override
    public PruebaAnalisisDTO registrarPrueba(PruebaAnalisisDTO pruebaDTO) throws NegocioException {
        // Convertimos DTO a entidad antes de enviarlo al DAO
        PruebaAnalisisEntidad prueba = new PruebaAnalisisEntidad(
                0, // ID se generará en BD
                pruebaDTO.getNombre(),
                pruebaDTO.getIdCategoria(),
                pruebaDTO.getIdLaboratorio()
        );
        // Insertamos la prueba en la BD
        PruebaAnalisisEntidad pruebaRegistrada = pruebaDAO.registrar(prueba);

        if (pruebaRegistrada == null) {
            throw new NegocioException("No se pudo registrar la prueba de análisis.");
        }
        return obtenerPrueba(pruebaRegistrada.getIdPruebaAnalisis(), pruebaRegistrada.getIdLaboratorio());
    }

    /**
     * Lista todas las pruebas de análisis registradas en un laboratorio específico.
     *
     * @param idLaboratorio Identificador del laboratorio del cual se listarán las pruebas.
     * @return Lista de objetos PruebaAnalisisDTO con las pruebas encontradas.
     * @throws NegocioException Si ocurre un error al obtener la lista de pruebas.
     */
    @Override
    public List<PruebaAnalisisDTO> listarPruebas(int idLaboratorio) throws NegocioException {
        try {
            List<PruebaAnalisisEntidad> pruebas = pruebaDAO.listarPruebasAnalisis(idLaboratorio);
            List<PruebaAnalisisDTO> dtos = new ArrayList<>();

            for (PruebaAnalisisEntidad p : pruebas) {
                dtos.add(new PruebaAnalisisDTO(
                        p.getIdPruebaAnalisis(),
                        p.getNombre(),
                        p.getIdCategoria(),
                        p.getIdLaboratorio()
                ));
            }
            return dtos;

        } catch (PersistenciaException e) {
            Logger.getLogger(PruebaAnalisisNegocio.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Error al listar las pruebas de análisis.");
        }
    }

    /**
     * Obtiene una prueba de análisis específica a partir de su ID y el ID del laboratorio asociado.
     *
     * @param idPrueba Identificador de la prueba de análisis.
     * @param idLab Identificador del laboratorio al que pertenece la prueba.
     * @return PruebaAnalisisDTO con los datos de la prueba encontrada, o null si no existe.
     * @throws NegocioException Si ocurre un error al obtener la prueba de análisis.
     */
    @Override
    public PruebaAnalisisDTO obtenerPrueba(int idPrueba, int idLab) throws NegocioException {
        try {
            PruebaAnalisisEntidad p = pruebaDAO.buscarPorId(idPrueba, idLab);
            if (p == null) {
                return null;
            }

            return new PruebaAnalisisDTO(
                    p.getIdPruebaAnalisis(),
                    p.getNombre(),
                    p.getIdCategoria(),
                    p.getIdLaboratorio()
            );

        } catch (PersistenciaException e) {
            Logger.getLogger(PruebaAnalisisNegocio.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Error al obtener la prueba de análisis.");
        }
    }

}


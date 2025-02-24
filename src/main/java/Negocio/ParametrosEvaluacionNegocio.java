/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import DTOS.ParametrosDTO;
import Entidades.ParametrosEntidad;
import Persistencia.IConexionBD;
import Persistencia.IParametrosEvaluacionDAO;
import Persistencia.ParametrosEvaluacionDAO;
import Persistencia.PersistenciaException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Clase que maneja la lógica de negocio para la gestión de parámetros de evaluación. Se encarga de la conversión entre DTOs y entidades, además de interactuar con la capa de persistencia.
 *
 * @author oribi
 */
public class ParametrosEvaluacionNegocio implements IParametrosEvaluacionNegocio {

    private IConexionBD conexionBD;
    private IParametrosEvaluacionDAO parametrosDAO;

    /**
     * Constructor que inicializa la conexión con el DAO de parámetros de evaluación.
     *
     * @param parametrosDAO Objeto que representa el DAO de parámetros de evaluación.
     */
    public ParametrosEvaluacionNegocio(IParametrosEvaluacionDAO parametrosDAO) {
        this.parametrosDAO = parametrosDAO;
    }

    /**
     * Registra una lista de parámetros de evaluación para una prueba específica.
     *
     * @param parametrosDTO Lista de objetos DTO con la información de los parámetros.
     * @param idPruebaAnalisis Identificador de la prueba de análisis asociada.
     * @return Lista de objetos ParametrosDTO con los parámetros registrados.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    @Override
    public List<ParametrosDTO> registrarParametros(List<ParametrosDTO> parametrosDTO, int idPruebaAnalisis) throws NegocioException {
        try {
            // Convertir DTO a Entidad
            List<ParametrosEntidad> entidades = parametrosDTO.stream()
                    .map(dto -> new ParametrosEntidad(dto.getNombre(), dto.getRango(), idPruebaAnalisis))
                    .collect(Collectors.toList());

            // Llamar al DAO para guardar en la BD
            List<ParametrosEntidad> entidadesGuardadas = parametrosDAO.registrarParametros(entidades, idPruebaAnalisis);

            // Convertir Entidad a DTO y retornar
            return entidadesGuardadas.stream()
                    .map(ent -> new ParametrosDTO(ent.getIdParametroEvaluacion(), ent.getNombre(), ent.getRango(), ent.getIdPruebaAnalisis()))
                    .collect(Collectors.toList());

        } catch (PersistenciaException e) {
            throw new NegocioException("No se pudieron registrar los parámetros: " + e.getMessage());
        }
    }

    /**
     * Registra un solo parámetro de evaluación en la base de datos.
     *
     * @param parametro Objeto DTO con la información del parámetro a registrar.
     * @return Objeto ParametrosDTO con los datos del parámetro registrado.
     * @throws NegocioException Si ocurre un error durante el registro.
     */
    public ParametrosDTO registrarParametro(ParametrosDTO parametro) throws NegocioException {
        try {
            // Convertimos DTO a Entidad
            ParametrosEntidad entidad = new ParametrosEntidad(
                    parametro.getNombre(),
                    parametro.getRango(),
                    parametro.getIdPruebaAnalisis()
            );

            // Registramos el parámetro en la BD
            ParametrosEntidad registrado = parametrosDAO.registrarParametro(entidad);
            if (registrado == null) {
                throw new NegocioException("No se pudo registrar el parámetro.");
            }

            // Convertimos Entidad a DTO para devolverlo
            return new ParametrosDTO(
                    registrado.getIdParametroEvaluacion(),
                    registrado.getNombre(),
                    registrado.getRango(),
                    registrado.getIdPruebaAnalisis()
            );

        } catch (NegocioException ex) {
            Logger.getLogger(ParametrosEvaluacionNegocio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistenciaException ex) {
            Logger.getLogger(ParametrosEvaluacionNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Elimina un parámetro de evaluación asociado a una prueba específica.
     *
     * @param idParam Identificador del parámetro de evaluación a eliminar.
     * @param idPrueba Identificador de la prueba de análisis asociada.
     * @return Objeto ParametrosDTO con la información del parámetro eliminado.
     * @throws NegocioException Si ocurre un error al eliminar el parámetro.
     */
    @Override
    public ParametrosDTO eliminarParametroEnPrueba(int idParam, int idPrueba) throws NegocioException {
        try {
            ParametrosEntidad eliminado = parametrosDAO.eliminarParametroEnPrueba(idParam, idPrueba);
            if (eliminado == null) {
                throw new NegocioException("No se encontró el parámetro a eliminar.");
            }

            // Convertimos Entidad a DTO
            return new ParametrosDTO(
                    eliminado.getIdParametroEvaluacion(),
                    eliminado.getNombre(),
                    eliminado.getRango(),
                    eliminado.getIdPruebaAnalisis()
            );

        } catch (PersistenciaException e) {
            Logger.getLogger(NegocioException.class.getName()).log(Level.SEVERE, null, e);
            throw new NegocioException("Error al eliminar el parámetro.");
        }
    }

    /**
     * Obtiene la lista de parámetros de evaluación asociados a una prueba específica.
     *
     * @param idPrueba Identificador de la prueba de análisis.
     * @return Lista de objetos ParametrosDTO con los parámetros de evaluación encontrados.
     * @throws NegocioException Si ocurre un error al obtener los parámetros.
     */
    @Override
    public List<ParametrosDTO> parametrosEnUnaPrueba(int idPrueba) throws NegocioException {
        List<ParametrosEntidad> parametros = parametrosDAO.parametrosEnUnaPrueba(idPrueba);
        List<ParametrosDTO> dtos = new ArrayList<>();
        if (parametros != null) {
            for (ParametrosEntidad p : parametros) {
                dtos.add(new ParametrosDTO(
                        p.getIdParametroEvaluacion(),
                        p.getNombre(),
                        p.getRango(),
                        p.getIdPruebaAnalisis()
                ));
            }
        }
        return dtos;
    }
}

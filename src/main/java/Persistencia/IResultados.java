/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import DTOS.AnalisisClienteDTO;
import DTOS.ResultadoDTO;
import Entidades.ResultadoEntidad;
import Entidades.ResultadoPorCliente;
import java.util.List;

/**
 * Interfaz que define los métodos para la gestión de resultados en el sistema.
 * Proporciona operaciones para crear y recuperar resultados asociados a clientes.
 * 
 * @author Jack Murrieta
 */
public interface IResultados {
        /**
     * Crea un nuevo resultado en la base de datos.
     * 
     * @param resultado Objeto de tipo {@code ResultadoDTO} que contiene la información del resultado a registrar.
     * @return Un objeto {@code ResultadoEntidad} que representa el resultado registrado.
     * @throws PersistenciaException Si ocurre un error en la operación de persistencia.
     */
    public ResultadoEntidad crearResultado(ResultadoDTO resultado)throws PersistenciaException;
    
    
    /**
     * Obtiene la lista de resultados asociados a un cliente específico.
     * 
     * @param idAnalisisCliente Identificador del análisis del cliente cuyos resultados se desean consultar.
     * @return Una lista de objetos {@code ResultadoPorCliente} con los resultados del cliente.
     * @throws PersistenciaException Si ocurre un error en la consulta de los datos.
     */
    public List<ResultadoPorCliente> ResultadosPorCliente(int idAnalisisCliente) throws PersistenciaException;
    
    
    
}

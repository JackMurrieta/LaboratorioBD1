/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Negocio;

import DTOS.AnalisisClienteDTO;
import Entidades.AnalisisClienteEntidad;

/**
 * Interfaz que define las operaciones de negocio relacionadas con el análisis de clientes.
 * Permite generar un nuevo análisis de cliente y convertirlo en un DTO para su manipulación.
 * 
 * @author Jack Murrieta
 */
public interface IAnalisisClienteNegocio {
    
    /**
     * Genera un análisis de cliente a partir de una entidad y lo convierte en un objeto DTO.
     * 
     * @param analisisCliente Objeto {@link AnalisisClienteEntidad} con los datos del análisis a registrar.
     * @return Un objeto {@link AnalisisClienteDTO} con los datos del análisis generado.
     * @throws NegocioException Si ocurre un error en el proceso de generación del análisis.
     */
    AnalisisClienteDTO generarAnalisisCliente(AnalisisClienteEntidad analisisCliente) throws NegocioException;
}

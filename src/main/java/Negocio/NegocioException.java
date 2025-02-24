/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 * Excepción personalizada para manejar errores en la capa de negocio. Se utiliza para indicar problemas relacionados con la lógica de negocio y la gestión de datos en la aplicación.
 *
 * Extiende {@link Exception} para representar errores controlados que deben ser manejados en las capas superiores.
 *
 * @author Jack Murrieta
 */
public class NegocioException extends Exception {

    /**
     * Constructor de la excepción que recibe un mensaje descriptivo del error.
     *
     * @param message Mensaje detallado sobre la causa de la excepción.
     */
    public NegocioException(String message) {
        super(message);
    }
    
    
}

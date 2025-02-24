/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

/**
 * Excepción personalizada para errores relacionados con la persistencia de datos.
 * Se utiliza para manejar errores en las operaciones de acceso a la base de datos.
 * 
 * @author oribi
 */
public class PersistenciaException extends Exception {

        /**
     * Constructor que crea una excepción de persistencia con un mensaje específico.
     * 
     * @param message Mensaje descriptivo del error.
     */
    public PersistenciaException(String message) {
        super(message);
    }

}
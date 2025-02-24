/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz que define la conexión a la base de datos.
 * Proporciona un método para establecer una conexión con la base de datos.
 * 
 * @author oribi
 */
public interface IConexionBD {

    /**
     * Crea y devuelve una conexión a la base de datos.
     * 
     * @return Un objeto {@code Connection} para interactuar con la base de datos.
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    Connection crearConexion() throws SQLException;
}

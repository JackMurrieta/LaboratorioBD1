/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión con la base de datos MySQL. Implementa la interfaz {@code IConexionBD}.
 *
 * Proporciona un método para establecer una conexión con la base de datos utilizando las credenciales configuradas.
 *
 * @author oribi
 */
public class ConexionBD implements IConexionBD {

    /**
     * Usuario de la base de datos.
     */
    private static final String USUARIO = "root";

    /**
     * Contraseña del usuario de la base de datos.
     */
    private static final String CONTRASEÑA = "1234";

    /**
     * Dirección del servidor de la base de datos (localhost por defecto).
     */
    private static final String SERVIDOR = "127.0.0.1";

    /**
     * Nombre de la base de datos a la que se conectará.
     */
    private static final String BASE_DE_DATOS = "LaboratoriosBD";

    /**
     * URL de conexión a la base de datos.
     */
    private static final String URL = "jdbc:mysql://" + SERVIDOR + "/" + BASE_DE_DATOS;

    /**
     * Establece una conexión con la base de datos MySQL.
     *
     * @return Un objeto {@code Connection} activo si la conexión es exitosa.
     * @throws SQLException Si ocurre un error al establecer la conexión.
     */
    @Override
    public Connection crearConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.LaboratorioEntidad;
import Entidades.UsuarioEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jack Murrieta
 */
public class UsuarioDAO {
    private IConexionBD conexionBD;

    public UsuarioDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    private UsuarioEntidad convertirUsuarioEntidad(ResultSet resultado) throws SQLException {
        int idUsuario = resultado.getInt("idUsuario");
        String user = resultado.getString("user");
        String contrasena = resultado.getString("contraseña");
        String rol = resultado.getString("rol");
        int idLab = resultado.getInt("idLaboratorio");
        return new UsuarioEntidad(idUsuario, user, contrasena, rol, idLab);

    }

    public UsuarioEntidad buscarUsuario(String user, String contrasena) {
        UsuarioEntidad usuario = null;
        Connection conexion;
        try {
            conexion = this.conexionBD.crearConexion();

            String codigoSQL = """
                       SELECT 
                           idUsuario, 
                           user, 
                           contraseña, 
                           rol,
                           idLaboratorio
                       FROM Usuarios 
                       WHERE user = ? AND contraseña = ?
                       """;

            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setString(1, user);
            preparedStatement.setString(2, contrasena); // Enviamos la contraseña en hash

            ResultSet resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                usuario = convertirUsuarioEntidad(resultado);
            }

            resultado.close();
            preparedStatement.close();
            conexion.close();
            return usuario;

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

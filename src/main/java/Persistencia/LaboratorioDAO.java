/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.LaboratorioEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que implementa la interfaz ILaboratorioDAO para manejar la persistencia de laboratorios.
 * Proporciona métodos para buscar laboratorios en la base de datos.
 * 
 *
 * @author Jack Murieta
 */
public class LaboratorioDAO implements ILaboratorioDAO {
    private IConexionBD conexionBD;

      /**
     * Constructor que inicializa la conexión con la base de datos.
     * 
     * @param conexion Objeto de tipo IConexionBD para gestionar la conexión con la base de datos.
     */
    public LaboratorioDAO(IConexionBD conexion) {
        this.conexionBD = conexion;
    }
        /**
     * Busca un laboratorio en la base de datos por su identificador único.
     * 
     * @param id Identificador del laboratorio a buscar.
     * @return Un objeto {@code LaboratorioEntidad} si se encuentra en la base de datos, de lo contrario retorna {@code null}.
     * @throws SQLException Si ocurre un error en la consulta SQL.
     */

    @Override
    public LaboratorioEntidad buscarLaboratorioPorid(int id) throws SQLException {
        try {
            LaboratorioEntidad lab = null;
            Connection conexion = this.conexionBD.crearConexion();

            String codigoSQL = """
                               SELECT
                                    idLaboratorio,
                                    nombre,
                                    direccion
                               FROM Laboratorios
                               WHERE idLaboratorio = ?
                               """;

            PreparedStatement preparedStatement = conexion.prepareStatement(codigoSQL);
            preparedStatement.setInt(1, id);

            ResultSet resultado = preparedStatement.executeQuery();
            while (resultado.next()) {
                lab = this.convertirLaboratorioEntidad(resultado);
            }

            resultado.close();
            preparedStatement.close();
            conexion.close();

            return lab;
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No se encuentra ese laboratorio en la BD");
        }
        return null;

    }
     /**
     * Convierte un resultado de consulta SQL en un objeto {@code LaboratorioEntidad}.
     * 
     * @param resultado Conjunto de resultados de la consulta SQL.
     * @return Un objeto de tipo {@code LaboratorioEntidad}.
     * @throws SQLException Si ocurre un error al acceder a los datos.
     */
    //CONVERTIR LAB A ENTIDAD 
    private LaboratorioEntidad convertirLaboratorioEntidad(ResultSet resultado) throws SQLException {
        int idLaboratorio = resultado.getInt("idLaboratorio");
        String nombre = resultado.getString("nombre");
        String direccion = resultado.getString("direccion");
        return new LaboratorioEntidad(idLaboratorio, nombre,direccion);
        
    }
    
}

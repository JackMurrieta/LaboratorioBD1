/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistencia;

import Entidades.LaboratorioEntidad;
import java.sql.SQLException;

/**
 * Interfaz que define las operaciones para gestionar los laboratorios en la base de datos.
 * Permite buscar laboratorios por su identificador.
 * 
 * @author Jack Murrieta
 */
public interface ILaboratorioDAO {

    /**
     * Busca un laboratorio en la base de datos a partir de su identificador único.
     * 
     * @param id Identificador del laboratorio a buscar.
     * @return Un objeto {@code LaboratorioEntidad} si se encuentra el laboratorio,
     *         o {@code null} si no existe.
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    LaboratorioEntidad buscarLaboratorioPorid(int id) throws SQLException;
}
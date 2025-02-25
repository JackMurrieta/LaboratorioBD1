/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Presentacion;

/**
 *
 * @author Jack Murrieta
 */
public class LaboratorioSession {
      private static LaboratorioSession instancia;
    private int idLaboratorio;

    // Constructor privado para evitar instanciación externa
    private LaboratorioSession() {}

    // Método para obtener la única instancia
    public static LaboratorioSession getInstance() {
        if (instancia == null) {
            instancia = new LaboratorioSession();
        }
        return instancia;
    }

    // Getter y Setter para idLaboratorio
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
    }
}
   

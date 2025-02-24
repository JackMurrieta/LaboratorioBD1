/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOS;

/**
 * DTO para representar un resultado de análisis.
 * Contiene información sobre los resultados de los parámetros evaluados en un análisis.
 * 
 * @author Jack Murrieta
 */
public class ResultadoDTO {
    private int idResultado; // Identificador del resultado de análisis
    private String resultadoParametro; // Valor del resultado del parámetro evaluado
    private int idParametroEvaluacion; // ID del parámetro de evaluación al que pertenece el resultado
    private int idAnalisisCliente; // ID del análisis realizado al cliente

    /**
     * Constructor vacío de ResultadoDTO.
     */
    public ResultadoDTO() {
    }

    /**
     * Constructor para guardar un nuevo resultado de análisis sin ID asignado.
     * 
     * @param resultadoParametro Valor del resultado del parámetro evaluado
     * @param idParametroEvaluacion ID del parámetro de evaluación
     * @param idAnalisisCliente ID del análisis del cliente al que pertenece el resultado
     */
    public ResultadoDTO(String resultadoParametro, int idParametroEvaluacion, int idAnalisisCliente) {
        this.resultadoParametro = resultadoParametro;
        this.idParametroEvaluacion = idParametroEvaluacion;
        this.idAnalisisCliente = idAnalisisCliente;
    }

    /**
     * Constructor con todos los parámetros, incluyendo el ID del resultado.
     * 
     * @param idResultado Identificador único del resultado de análisis
     * @param resultadoParametro Valor del resultado del parámetro evaluado
     * @param idParametroEvaluacion ID del parámetro de evaluación
     * @param idAnalisisCliente ID del análisis del cliente al que pertenece el resultado
     */
    public ResultadoDTO(int idResultado, String resultadoParametro, int idParametroEvaluacion, int idAnalisisCliente) {
        this.idResultado = idResultado;
        this.resultadoParametro = resultadoParametro;
        this.idParametroEvaluacion = idParametroEvaluacion;
        this.idAnalisisCliente = idAnalisisCliente;
    }

    /**
     * Obtiene el ID del resultado de análisis.
     * 
     * @return ID del resultado
     */
    public int getIdResultado() {
        return idResultado;
    }

    /**
     * Establece el ID del resultado de análisis.
     * 
     * @param idResultado Nuevo ID del resultado
     */
    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    /**
     * Obtiene el valor del resultado del parámetro evaluado.
     * 
     * @return Valor del resultado del parámetro
     */
    public String getResultadoParametro() {
        return resultadoParametro;
    }

    /**
     * Establece el valor del resultado del parámetro evaluado.
     * 
     * @param resultadoParametro Nuevo valor del resultado
     */
    public void setResultadoParametro(String resultadoParametro) {
        this.resultadoParametro = resultadoParametro;
    }

    /**
     * Obtiene el ID del parámetro de evaluación asociado al resultado.
     * 
     * @return ID del parámetro de evaluación
     */
    public int getIdParametroEvaluacion() {
        return idParametroEvaluacion;
    }

    /**
     * Establece el ID del parámetro de evaluación asociado al resultado.
     * 
     * @param idParametroEvaluacion Nuevo ID del parámetro de evaluación
     */
    public void setIdParametroEvaluacion(int idParametroEvaluacion) {
        this.idParametroEvaluacion = idParametroEvaluacion;
    }

    /**
     * Obtiene el ID del análisis del cliente al que pertenece el resultado.
     * 
     * @return ID del análisis del cliente
     */
    public int getIdAnalisisCliente() {
        return idAnalisisCliente;
    }

    /**
     * Establece el ID del análisis del cliente al que pertenece el resultado.
     * 
     * @param idAnalisisCliente Nuevo ID del análisis del cliente
     */
    public void setIdAnalisisCliente(int idAnalisisCliente) {
        this.idAnalisisCliente = idAnalisisCliente;
    }

    /**
     * Devuelve una representación en cadena del objeto ResultadoDTO.
     * 
     * @return Cadena con los datos del resultado de análisis
     */
    @Override
    public String toString() {
        return "ResultadoDTO{" +
               "idResultado=" + idResultado +
               ", resultadoParametro='" + resultadoParametro + '\'' +
               ", idParametroEvaluacion=" + idParametroEvaluacion +
               ", idAnalisisCliente=" + idAnalisisCliente +
               '}';
    }
}




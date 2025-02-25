/*
 * Clase que representa un resultado de análisis de un cliente, almacenando información
 * sobre el parámetro evaluado y su valor correspondiente.
 */
package Entidades;

/**
 * Representa una entidad que almacena los resultados de un análisis clínico realizado a un cliente. Contiene información sobre el resultado del parámetro evaluado, el identificador del análisis y el identificador del parámetro evaluado.
 *
 * @author Jack Murrieta
 */
public class ResultadoEntidad {

    private int idResultado;
    private String resultadoParametro;
    private int idParametroEvaluacion;
    private int idAnalisisCliente;

    /**
     * Constructor para crear un resultado sin ID, utilizado al guardar un nuevo resultado en la base de datos.
     *
     * @param resultadoParametro Valor del resultado obtenido en la evaluación.
     * @param idParametroEvaluacion Identificador del parámetro evaluado.
     * @param idAnalisisCliente Identificador del análisis al que pertenece el resultado.
     */
    public ResultadoEntidad(String resultadoParametro, int idParametroEvaluacion, int idAnalisisCliente) {
        this.resultadoParametro = resultadoParametro;
        this.idParametroEvaluacion = idParametroEvaluacion;
        this.idAnalisisCliente = idAnalisisCliente;
    }

    /**
     * Constructor que inicializa un resultado con todos sus atributos, incluyendo su ID.
     *
     * @param idResultado Identificador único del resultado.
     * @param resultadoParametro Valor del resultado obtenido en la evaluación.
     * @param idParametroEvaluacion Identificador del parámetro evaluado.
     * @param idAnalisisCliente Identificador del análisis al que pertenece el resultado.
     */
    public ResultadoEntidad(int idResultado, String resultadoParametro, int idParametroEvaluacion, int idAnalisisCliente) {
        this.idResultado = idResultado;
        this.resultadoParametro = resultadoParametro;
        this.idParametroEvaluacion = idParametroEvaluacion;
        this.idAnalisisCliente = idAnalisisCliente;
    }

    /**
     * Obtiene el identificador único del resultado.
     *
     * @return ID del resultado.
     */
    public int getIdResultado() {
        return idResultado;
    }

    /**
     * Establece el identificador del resultado.
     *
     * @param idResultado ID del resultado.
     */
    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    /**
     * Obtiene el valor del resultado obtenido en la evaluación.
     *
     * @return Valor del resultado.
     */
    public String getResultadoParametro() {
        return resultadoParametro;
    }

    /**
     * Establece el valor del resultado obtenido en la evaluación.
     *
     * @param resultadoParametro Valor del resultado.
     */
    public void setResultadoParametro(String resultadoParametro) {
        this.resultadoParametro = resultadoParametro;
    }

    /**
     * Obtiene el identificador del parámetro evaluado.
     *
     * @return ID del parámetro evaluado.
     */
    public int getIdParametroEvaluacion() {
        return idParametroEvaluacion;
    }

    /**
     * Establece el identificador del parámetro evaluado.
     *
     * @param idParametroEvaluacion ID del parámetro evaluado.
     */
    public void setIdParametroEvaluacion(int idParametroEvaluacion) {
        this.idParametroEvaluacion = idParametroEvaluacion;
    }

    /**
     * Obtiene el identificador del análisis al que pertenece el resultado.
     *
     * @return ID del análisis de cliente.
     */
    public int getIdAnalisisCliente() {
        return idAnalisisCliente;
    }

    /**
     * Establece el identificador del análisis al que pertenece el resultado.
     *
     * @param idAnalisisCliente ID del análisis de cliente.
     */
    public void setIdAnalisisCliente(int idAnalisisCliente) {
        this.idAnalisisCliente = idAnalisisCliente;
    }

    /**
     * Retorna una representación en cadena del objeto con sus atributos.
     *
     * @return Representación en cadena de los datos del resultado.
     */
    @Override
    public String toString() {
        return "ResultadoEntidad{"
                + "idResultado=" + idResultado
                + ", resultadoParametro='" + resultadoParametro + '\''
                + ", idParametroEvaluacion=" + idParametroEvaluacion
                + ", idAnalisisCliente=" + idAnalisisCliente
                + '}';
    }
}

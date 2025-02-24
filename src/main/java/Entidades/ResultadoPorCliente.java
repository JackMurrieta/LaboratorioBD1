/*
 * Clase que representa los resultados de un análisis de cliente.
 * Contiene información de la prueba realizada, los datos del cliente y los resultados obtenidos.
 */
package Entidades;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que almacena la información de los resultados de un análisis clínico por cliente.
 * Puede representar tanto una prueba completa como los resultados individuales de los parámetros evaluados.
 *@author Jack Murrieta
 */
public class ResultadoPorCliente {
    
    private String nombrePrueba;
    private int folioAnalisis;
    private String nombreCliente;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private List<ResultadoPorCliente> resultados;
    private int idResultado;
    private String resultadoParametro;
    private String parametro;
    private String rango;

    /**
     * Constructor que inicializa un resultado de análisis con la información de la prueba y el cliente.
     * 
     * @param nombrePrueba Nombre de la prueba realizada.
     * @param folioAnalisis Folio del análisis correspondiente.
     * @param nombreCliente Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     */
    public ResultadoPorCliente(String nombrePrueba, int folioAnalisis, String nombreCliente, 
                               String apellidoPaterno, String apellidoMaterno) {
        this.nombrePrueba = nombrePrueba;
        this.folioAnalisis = folioAnalisis;
        this.nombreCliente = nombreCliente;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.resultados = new ArrayList<>();
    }

    /**
     * Constructor que inicializa un resultado individual con los detalles de la prueba y del cliente.
     * 
     * @param idResultado Identificador del resultado.
     * @param resultadoParametro Resultado obtenido para un parámetro específico.
     * @param parametro Nombre del parámetro analizado.
     * @param rango Rango de referencia para el parámetro.
     * @param folioAnalisis Folio del análisis al que pertenece el resultado.
     * @param nombreCliente Nombre del cliente.
     * @param apellidoPaterno Apellido paterno del cliente.
     * @param apellidoMaterno Apellido materno del cliente.
     */
    public ResultadoPorCliente(int idResultado, String resultadoParametro, String parametro, String rango, 
                               int folioAnalisis, String nombreCliente, String apellidoPaterno, String apellidoMaterno) {
        this.idResultado = idResultado;
        this.resultadoParametro = resultadoParametro;
        this.parametro = parametro;
        this.rango = rango;
        this.folioAnalisis = folioAnalisis;
        this.nombreCliente = nombreCliente;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Agrega un resultado a la lista de resultados del análisis.
     * 
     * @param resultado Objeto {@link ResultadoPorCliente} que representa un resultado individual.
     */
    public void agregarResultado(ResultadoPorCliente resultado) {
        this.resultados.add(resultado);
    }

    // Getters

    /**
     * Obtiene el nombre de la prueba realizada.
     * 
     * @return Nombre de la prueba.
     */
    public String getNombrePrueba() {
        return nombrePrueba;
    }

    /**
     * Obtiene el folio del análisis.
     * 
     * @return Folio del análisis.
     */
    public int getFolioAnalisis() {
        return folioAnalisis;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Obtiene el apellido paterno del cliente.
     * 
     * @return Apellido paterno del cliente.
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Obtiene el apellido materno del cliente.
     * 
     * @return Apellido materno del cliente.
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Obtiene la lista de resultados del análisis.
     * 
     * @return Lista de resultados.
     */
    public List<ResultadoPorCliente> getResultados() {
        return resultados;
    }

    /**
     * Obtiene el identificador del resultado.
     * 
     * @return ID del resultado.
     */
    public int getIdResultado() {
        return idResultado;
    }

    /**
     * Obtiene el valor del resultado para un parámetro específico.
     * 
     * @return Resultado del parámetro.
     */
    public String getResultadoParametro() {
        return resultadoParametro;
    }

    /**
     * Obtiene el nombre del parámetro analizado.
     * 
     * @return Nombre del parámetro.
     */
    public String getParametro() {
        return parametro;
    }

    /**
     * Obtiene el rango de referencia del parámetro analizado.
     * 
     * @return Rango de referencia del parámetro.
     */
    public String getRango() {
        return rango;
    }

    /**
     * Retorna una representación en cadena del objeto con sus atributos.
     * 
     * @return Representación en cadena de los datos del resultado por cliente.
     */
    @Override
    public String toString() {
        return "ResultadoPorCliente{" +
                "nombrePrueba='" + nombrePrueba + '\'' +
                ", folioAnalisis=" + folioAnalisis +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", idResultado=" + idResultado +
                ", resultadoParametro='" + resultadoParametro + '\'' +
                ", parametro='" + parametro + '\'' +
                ", rango='" + rango + '\'' +
                ", resultados=" + resultados +
                '}';
    }
}

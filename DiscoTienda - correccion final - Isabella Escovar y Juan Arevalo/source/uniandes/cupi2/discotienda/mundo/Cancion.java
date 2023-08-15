/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Cancion.java,v 1.9 2006/08/10 20:04:47 da-romer Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_discotienda 
 * Autor: Nicolás López - 06/12/2005 
 * Autor: Jorge Villalobos - 29/07/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.discotienda.mundo;

import java.io.Serializable;

/**
 * Es la clase que representa a una canción en MP3 que hace parte de un disco. <br>
 * <b>inv: </b> <br>
 * nombre != null, nombre != "" <br>
 * minutos >= 0 <br>
 * 0 <= segundos < 60 <br>
 * minutos + segundos > 0 <br>
 * tamano > 0 <br>
 * calidad > 0 <br>
 * precio > 0 <br>
 * unidadesVendidas >= 0
 */
public class Cancion implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indicador de versión para la serialización
     */
    private static final long serialVersionUID = 200L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el nombre de la canción
     */
    private String nombre;

    /**
     * Es la duración en minutos de la canción
     */
    private int minutos;

    /**
     * Es la duración en segundos de la canción
     */
    private int segundos;

    /**
     * El tamaño en megabytes de la canción
     */
    private double tamano;

    /**
     * Es la calidad del mp3 en kbps p.e. 96 kbps, 128 kbps
     */
    private int calidad;

    /**
     * Es el precio de la canción;
     */
    private double precio;

    /**
     * El número de veces que se ha vendido esta canción
     */
    private int unidadesVendidas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva canción con los datos suministrados
     * @param nombreC el nombre de la canción - nombreC != null, nombreC != ""
     * @param minutosC el número de minutos de duración de la canción - minutosC >= 0
     * @param segundosC el número de segundos de duración de la canción - segundosC >= 0 && segundosC < 60, minutos + segundos > 0
     * @param precioC es el precio de la canción - precioC > 0
     * @param tamanoC es el tamaño de la canción en MB - tamanoC > 0
     * @param calidadC es la calidad de la canción en Kbps - calidadC > 0
     * @param cantidad es el número de veces que se ha vendido esta canción - cantidad >= 0
     */
    public Cancion( String nombreC, int minutosC, int segundosC, double precioC, double tamanoC, int calidadC, int cantidad )
    {
        nombre = nombreC;
        minutos = minutosC;
        segundos = segundosC;
        precio = precioC;
        tamano = tamanoC;
        calidad = calidadC;
        unidadesVendidas = cantidad;

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el nombre de la canción
     * @return Nombre de la canción
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna la duración en minutos de la canción
     * @return Duración en minutos de la canción
     */
    public int darMinutos( )
    {
        return minutos;
    }

    /**
     * Retorna la duración en segundos de la canción
     * @return Duración en segundos de la canción
     */
    public int darSegundos( )
    {
        return segundos;
    }

    /**
     * Retorna el precio de la canción
     * @return Precio de la canción
     */
    public double darPrecio( )
    {
        return precio;
    }

    /**
     * Retorna el tamaño de la canción
     * @return Tamaño de la canción
     */
    public double darTamano( )
    {
        return tamano;
    }

    /**
     * Retorna la calidad de la canción
     * @return Calidad de la canción
     */
    public int darCalidad( )
    {
        return calidad;
    }

    /**
     * Retorna el número de unidades vendidas
     * @return Número de unidades vendidas
     */
    public int darUnidadesVendidas( )
    {
        return unidadesVendidas;
    }

    /**
     * Aumenta en uno la cantidad de unidades vendidas
     */
    public void vender( )
    {
        unidadesVendidas++;
    }

    /**
     * Indica si la canción tiene el nombre que llega como parámetro
     * @param nombreCancion nombre de una canción - nombreCancion != null
     * @return True si la canción tiene el nombre que llega como parámetro
     */
    public boolean equals( String nombreCancion )
    {
        return nombre.equalsIgnoreCase( nombreCancion );
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase: <br>
     * nombre != null, nombre != "" <br>
     * minutos >= 0 <br>
     * 0 <= segundos < 60 <br>
     * minutos + segundos > 0 <br>
     * tamano > 0 <br>
     * calidad > 0 <br>
     * precio > 0 <br>
     * unidadesVendidas >= 0
     */
    private void verificarInvariante( )
    {
        assert nombre != null && !nombre.equals( "" ) : "El nombre es inválido";
        assert minutos >= 0 : "Los minutos deben ser un valor positivo";
        assert 0 <= segundos && segundos < 60 : "Los segundos deben ser un valor entre 0 y 60";
        assert minutos + segundos > 0 : "La canción debe tener una duración positiva";
        assert tamano > 0 : "El tamaño debe ser un valor positivo";
        assert calidad > 0 : "La calidad debe ser un valor positivo";
        assert precio > 0 : "El precio debe ser un valor positivo";
        assert unidadesVendidas >= 0 : "El número de unidades vendidas debe ser un entero positivo";
    }
}

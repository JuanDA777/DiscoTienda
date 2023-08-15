/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: ArchivoVentaException.java,v 1.2 2006/08/10 20:04:47 da-romer Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License versión 2.1
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_discotienda
 * Autor: Mario Sánchez - 7/07/2006
 * Autor: Jorge Villalobos - 30/07/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.discotienda.mundo;

/**
 * Esta excepción sirve para indicar que hubo un problema procesando el archivo de ventas
 */
public class ArchivoVentaException extends Exception
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Número de canciones que se pudieron vender a pesar del error
     */
    private int cancionesVendidas;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye la excepción con una causa del error y la cantidad de canciones vendidas a pesar del error
     * @param causa El mensaje que describe el problema que se presentó
     * @param ventas La cantidad de canciones vendidas a pesar del error
     */
    public ArchivoVentaException( String causa, int ventas )
    {
        super( causa );
        cancionesVendidas = ventas;
    }

    /**
     * Retorna la cantidad de canciones vendidas a pesar del error
     * @return La cantidad de canciones vendidas a pesar del error
     */
    public int darCancionesVendidas( )
    {
        return cancionesVendidas;
    }
}

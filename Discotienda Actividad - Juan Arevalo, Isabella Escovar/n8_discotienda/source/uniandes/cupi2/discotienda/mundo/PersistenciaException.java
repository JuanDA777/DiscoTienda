/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PersistenciaException.java,v 1.3 2006/08/10 20:04:47 da-romer Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_discotienda 
 * Autor: Mario Sánchez - 26/01/2006 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.discotienda.mundo;

/**
 * Esta excepción se lanza cuando se presenta un error al leer o escribir el archivo con la información del estado del modelo del mundo. <br>
 * El mensaje asociado con la excepción debe describir el problema que se presentó.
 */
public class PersistenciaException extends Exception
{
    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Construye la excepción con el mensaje que se pasa como parámetro y que describe la causa del problema
     * @param causa el mensaje que describe el problema
     */
    public PersistenciaException( String causa )
    {
        super( causa );
    }
}

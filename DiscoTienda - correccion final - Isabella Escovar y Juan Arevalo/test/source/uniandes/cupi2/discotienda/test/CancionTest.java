/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: CancionTest.java,v 1.4 2006/08/10 20:04:56 da-romer Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_discotienda 
 * Autor: Nicolás López - 06/12/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.discotienda.test;

import junit.framework.TestCase;
import uniandes.cupi2.discotienda.mundo.Cancion;

/**
 * Esta es la clase que sirve para verificar la clase Cancion
 */
public class CancionTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la canción sobre la que se realizan las pruebas
     */
    private Cancion cancion1;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye una canción para hacer las pruebas
     */
    private void setupEscenario1( )
    {
        cancion1 = new Cancion( "CancionPrueba", 1, 20, 1.5, 2.0, 96, 2 );
    }

    /**
     * Verifica los métodos que retornan datos de la canción <b> Métodos a probar: </b> <br>
     * darNombre, darMinutos, darSegundos, darPrecio,darTamano, darCalidad, darUnidadesVendidas . <br>
     * <b> Objetivo: </b> Probar que los métodos que retornan datos de la canción retornan la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el nombre de la canción es X. Al pedir el nombre de la canción debe ser igual a X. <br>
     * 2. Se sabe que la duración en segundos de la canción es X. Al pedir la duración en segundos de la canción debe ser igual a X. <br>
     * 3. Se sabe que la duración en minutos de la canción es X. Al pedir la duración en minutos de la canción debe ser igual a X. <br>
     * 4. Se sabe que el precio de la canción es X. Al pedir el precio de la canción debe ser igual a X. <br>
     * 5. Se sabe que el tamaño de la canción es X. Al pedir el tamaño de la canción debe ser igual a X. <br>
     * 6. Se sabe que la calidad de la canción es X. Al pedir la calidad de la canción se debe ser igual a X. <br>
     * 7. Se sabe que el número de unidades vendidas de una canción es X. Al pedir el número de unidades vendidas de la canción debe ser igual a X.
     */
    public void testDatos( )
    {
        setupEscenario1( );

        assertEquals( "El nombre de la canción está mal", "CancionPrueba", cancion1.darNombre( ) );
        assertEquals( "Los minutos de la canción está mal", 1, cancion1.darMinutos( ) );
        assertEquals( "Los segundos de la canción está mal", 20, cancion1.darSegundos( ) );
        assertEquals( "El precio de la canción está mal", "1.5", Double.toString( cancion1.darPrecio( ) ) );
        assertEquals( "El tamaño de la canción está mal", "2.0", Double.toString( cancion1.darTamano( ) ) );
        assertEquals( "La calidad de la canción está mal", 96, cancion1.darCalidad( ) );
        assertEquals( "El número de unidades vendidas de la canción está mal", 2, cancion1.darUnidadesVendidas( ) );
    }

    /**
     * Verifica que el método incrementarUnidadesVendidas efectivamente afecte el valor retornado por el método darUnidadesVendidas <b> Métodos a probar: </b> <br>
     * vender. <br>
     * <b> Objetivo: </b> Probar que el método vender() es capaz de incrementar correctamente el número de unidades vendidas de la canción. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el número de unidades vendidas de la canción es X. Al vender la canción una vez y pedir el número de unidades vendidas de la canción éste debe ser igual
     * a X+1. <br>
     */
    public void testIncrementarUnidadesVendidas( )
    {
        setupEscenario1( );

        int unidadesVendidas = cancion1.darUnidadesVendidas( );
        int numeroIteraciones = ( int )Math.random( ) * 10000;
        for( int i = 0; i < numeroIteraciones; i++ )
        {
            unidadesVendidas++;
            cancion1.vender( );
            assertEquals( "El número de unidades vendidas no es correcto", unidadesVendidas, cancion1.darUnidadesVendidas( ) );
        }
    }

}

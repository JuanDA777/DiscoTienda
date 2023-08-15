/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DiscoTest.java,v 1.7 2006/08/10 20:04:56 da-romer Exp $ 
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_discotienda 
 * Autor: Nicolás López - 06/12/2005 
 * Autor: Mario Sánchez - 26/01/2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.discotienda.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import uniandes.cupi2.discotienda.mundo.*;

/**
 * Esta es la clase que sirve para verificar la clase Disco
 */
public class DiscoTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el disco sobre el que se realizan las pruebas
     */
    private Disco disco1;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye un disco sin canciones
     */
    private void setupEscenario1( )
    {
        disco1 = new Disco( "Mi disco1", "artistaPrueba", "Latino", "prueba.jpg" );
    }

    /**
     * Construye un disco con algunas unas canciones
     */
    private void setupEscenario2( )
    {
        disco1 = new Disco( "Mi disco1", "artistaPrueba", "Latino", "./data/imagenes/prueba.jpg" );

        Cancion c1 = new Cancion( "C1", 1, 20, 1.50, 2, 96, 2 );
        Cancion c2 = new Cancion( "C2", 1, 20, 3.45, 2, 96, 2 );
        Cancion c3 = new Cancion( "C3", 1, 20, 78.10, 2, 96, 2 );
        try
        {
            disco1.agregarCancion( c1 );
            disco1.agregarCancion( c2 );
            disco1.agregarCancion( c3 );
        }
        catch( ElementoExisteException e )
        {
            e.printStackTrace( );
        }
    }

    /**
     * Prueba que las canciones se agreguen correctamente. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarCancion. <br>
     * <b> Objetivo: </b> Probar que el método agregarCancion() es capaz de agregar canciones de forma correcta a la tienda. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar una canción que no existe en un disco, esta debe ser adicionada al disco. <br>
     * 2. Al agregar una canción que existe en un disco se debe arrojar una excepción indicándolo.
     */
    public void testAgregarCancion( )
    {
        setupEscenario1( );

        Cancion c1 = new Cancion( "Cancion1", 1, 20, 1.50, 2, 96, 0 );
        Cancion c2 = new Cancion( "Cancion1", 2, 40, 3.45, 2, 96, 0 );
        try
        {
            disco1.agregarCancion( c1 );
        }
        catch( ElementoExisteException e )
        {
            fail( );
        }
        try
        {
            disco1.agregarCancion( c2 );
            fail( );
        }
        catch( ElementoExisteException e )
        {
            assertTrue( true );
        }
    }

    /**
     * Verifica los métodos que retornan datos del disco1. <br>
     * <b> Métodos a probar: </b> <br>
     * darNombreDisco, darArtista, darGenero, darImagen. <br>
     * <b> Objetivo: </b> Probar que los métodos que dan información de un disco retornan la información correcta. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el nombre de un disco es X. Al pedir el nombre del disco éste debe ser igual a X. <br>
     * 2. Se sabe que el del artista de un disco es X. Al pedir el artista del disco éste debe ser igual a X. <br>
     * 3. Se sabe que el nombre del género de un disco es X. Al pedir el género del disco éste debe ser igual a X. <br>
     * 4. Se sabe que la imagen de un disco es X. Al pedir la imagen del disco éste debe ser igual a X.
     */
    public void testDatos( )
    {
        setupEscenario1( );

        assertEquals( "El nombre del disco1 está mal", "Mi disco1", disco1.darNombreDisco( ) );
        assertEquals( "El artista del disco1 está mal", "artistaPrueba", disco1.darArtista( ) );
        assertEquals( "El género del disco1 está mal", "Latino", disco1.darGenero( ) );
        assertEquals( "La imagen del disco1 está mal", "prueba.jpg", disco1.darImagen( ) );
    }

    /**
     * Verifica el método que calcula el precio de un disco. <br>
     * <b> Métodos a probar: </b> <br>
     * darPrecioDisco. <br>
     * <b> Objetivo: </b> Probar que el método darPrecioDisco() calcula correctamente el valor del precio del disco de acuerdo a las canciones que este tiene. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Se sabe que el precio de un disco es X. Al pedir el precio del disco éste debe ser igual a X.
     */
    public void testCalcularPrecio( )
    {
        setupEscenario2( );

        assertEquals( "El cálculo del precio del disco1 está mal", "83.05", Double.toString( disco1.darPrecioDisco( ) ) );
    }

    /**
     * Verifica el método darCancion.<br>
     * Se busca una canción que esté dentro del disco. <br>
     * <b> Métodos a probar: </b> <br>
     * darCancion. <br>
     * <b> Objetivo: </b> Probar que el método darCancion() retorne una canción que existe en el disco. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al pedir una canción que existe en el disco, ésta debe ser retornada.
     */
    public void testDarCancionOk( )
    {
        setupEscenario2( );

        Cancion c = disco1.darCancion( "C2" );
        assertNotNull( "La canción C2 se debería haber encontrado", c );
    }

    /**
     * Verifica el método darCancion.<br>
     * Se busca una canción que no esté dentro del disco, esperando que retorne null. <br>
     * <b> Métodos a probar: </b> <br>
     * darCancion. <br>
     * <b> Objetivo: </b> Probar que el método darCancion() no retorne una canción que no existe en el disco. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al pedir una canción que no existe en el disco se debe obtener null.
     */
    public void testDarCancionError( )
    {
        setupEscenario2( );

        Cancion c = disco1.darCancion( "C125" );
        assertNull( "La canción C125 no se debería haber encontrado", c );
    }

    /**
     * Verifica el método darNombresCanciones, que debería retornar los nombres de las 3 canciones que están en el disco. Este método se verifica usando el escenario 2. <br>
     * <b> Métodos a probar: </b> <br>
     * darNombresCanciones. <br>
     * <b> Objetivo: </b> Probar que el método darNombresCanciones() retornen los nombres de todas las canciones que hay en el disco. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al pedir el arreglo con los nombres de las canciones de un disco, dicho arreglo debe contener todos los nombres de las canciones existentes.
     */
    public void testDarNombresCanciones( )
    {
        setupEscenario2( );

        ArrayList nombres = disco1.darNombresCanciones( );
        assertEquals( "El número de nombres es incorrecto", 3, nombres.size( ) );

        String nombre1 = ( String )nombres.get( 0 );
        String nombre2 = ( String )nombres.get( 1 );
        String nombre3 = ( String )nombres.get( 2 );

        assertEquals( "El nombre de la canción no es el esperado", "C1", nombre1 );
        assertEquals( "El nombre de la canción no es el esperado", "C2", nombre2 );
        assertEquals( "El nombre de la canción no es el esperado", "C3", nombre3 );
    }

}

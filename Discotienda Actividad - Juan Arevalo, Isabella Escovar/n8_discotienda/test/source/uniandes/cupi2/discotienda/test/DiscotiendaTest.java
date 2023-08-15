/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *$Id: DiscotiendaTest.java,v 1.11 2007/04/10 12:21:44 p-marque Exp $ 
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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import uniandes.cupi2.discotienda.mundo.Cancion;
import uniandes.cupi2.discotienda.mundo.ElementoExisteException;
import uniandes.cupi2.discotienda.mundo.Disco;
import uniandes.cupi2.discotienda.mundo.Discotienda;
import uniandes.cupi2.discotienda.mundo.ArchivoVentaException;

/**
 * Esta es la clase que sirve para verificar la clase Discotienda
 */
public class DiscotiendaTest extends TestCase
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es la discotienda sobre la que se realizan las pruebas
     */
    private Discotienda discotienda1;

    /**
     * Es la discotienda sobre la que se realizan las pruebas para saber si se salvó bien un archivo
     */
    private Discotienda discotienda2;

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Construye una discotienda vacía
     */
    private void setupEscenario1( )
    {
        try
        {
            File archivo = new File( "./test/data/discotienda.dat" );
            if( archivo.exists( ) )
            {
                archivo.delete( );
            }

            discotienda1 = new Discotienda( "./test/data/discotienda.dat" );
        }
        catch( Exception e )
        {
            fail( "No debería haber problemas cargando el archivo:" + e.getMessage( ) );
        }
    }

    /**
     * Construye una discotienda con tres discos (disco1, disco2 y disco3), cada uno con 3 canciones
     */
    private void setupEscenario2( )
    {
        try
        {
            File archivo = new File( "./test/data/discotienda.dat" );
            if( archivo.exists( ) )
            {
                archivo.delete( );
            }

            discotienda1 = new Discotienda( "./test/data/discotienda.dat" );
            discotienda1.agregarDisco( "disco1", "artista1", "genero1", "imagen1" );
            discotienda1.agregarCancionADisco( "disco1", "cancion1", 1, 1, 1, 1, 1 );
            discotienda1.agregarCancionADisco( "disco1", "cancion2", 2, 2, 2, 2, 2 );
            discotienda1.agregarCancionADisco( "disco1", "cancion3", 3, 3, 3, 3, 3 );

            discotienda1.agregarDisco( "disco2", "artista2", "genero2", "imagen2" );
            discotienda1.agregarCancionADisco( "disco2", "cancion1", 1, 1, 1, 1, 1 );
            discotienda1.agregarCancionADisco( "disco2", "cancion2", 2, 2, 2, 2, 2 );
            discotienda1.agregarCancionADisco( "disco2", "cancion3", 3, 3, 3, 3, 3 );

            discotienda1.agregarDisco( "disco3", "artista3", "genero3", "imagen3" );
            discotienda1.agregarCancionADisco( "disco3", "cancion1", 1, 1, 1, 1, 1 );
            discotienda1.agregarCancionADisco( "disco3", "cancion2", 2, 2, 2, 2, 2 );
            discotienda1.agregarCancionADisco( "disco3", "cancion3", 3, 3, 3, 3, 3 );

        }
        catch( Exception e )
        {
            fail( "No debería haber problemas cargando el archivo:" + e.getMessage( ) );
        }
    }

    /**
     * Verifica el método de creación de la clase Discotienda.<br>
     * Se espera que la discotienda esté vacía. <br>
     * <b> Métodos a probar: </b> <br>
     * Discotienda (constructor), darDiscos. <br>
     * <b> Objetivo: </b> Probar que el método Discotienda() sea capaz de crear una tienda vacía (sin discos). <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al crear una discotienda esta debe quedar sin discos. <br>
     */
    public void testDiscotienda( )
    {
        setupEscenario1( );

        ArrayList discos = discotienda1.darDiscos( );
        assertEquals( "El número de discos es incorrecto", 0, discos.size( ) );
    }

    /**
     * Verifica el método que retorna un disco de la discotienda.<br>
     * Se verifica lo que sucede cuando se busca un disco que existe en la discotienda. <br>
     * <b> Métodos a probar: </b> <br>
     * darDisco. <br>
     * <b> Objetivo: </b> Probar que el método darDisco() sea capaz de encontrar un disco existente. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un disco existente en la tienda, este debe ser retornado.
     */
    public void testDarDiscoOk( )
    {
        setupEscenario2( );

        Disco disco = discotienda1.darDisco( "disco1" );
        assertNotNull( "No se encontró el disco", disco );
        assertEquals( "El nombre del disco retornado no es el esperado", "disco1", disco.darNombreDisco( ) );
    }

    /**
     * Verifica el método que retorna un disco de la discotienda.<br>
     * Se verifica lo que sucede cuando se busca un disco que NO existe en la discotienda. <br>
     * <b> Métodos a probar: </b> <br>
     * darDisco. <br>
     * <b> Objetivo: </b> Probar que el método darDisco() no encuentre disco que no existe en la tienda. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al buscar un disco que no existe en la tienda se debe obtener null.
     */
    public void testDarDiscoError( )
    {
        setupEscenario2( );

        Disco disco = discotienda1.darDisco( "disco4" );
        assertNull( "Se encontró un disco que no debería existir en la discotienda", disco );
    }

    /**
     * Verifica el método que agrega un disco a la discotienda para el caso en el que no hay error.<br>
     * En este caso los datos del disco que se agrega son correctos. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarDisco. <br>
     * <b> Objetivo: </b> Probar que el método agregarDisco() sea capaz de agregar un disco en la tienda. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar un disco cuyo nombre no pertenece a otro disco existente en la tienda, este debe ser adicionado. <br>
     * 2. Al buscar un disco previamente agregado este debe ser encontrado.
     */
    public void testAgregarDiscoOk( )
    {
        setupEscenario2( );

        try
        {
            // Se agrega el disco
            discotienda1.agregarDisco( "Mi disco de prueba", "artistaPrueba", "Latino", "./data/imagenes/prueba.jpg" );
            assertEquals( "El disco no fue agregado correctamente a la discotienda", 4, discotienda1.darDiscos( ).size( ) );

            // Se verifica que el disco haya quedado agregado correctamente
            Disco disco = discotienda1.darDisco( "Mi disco de prueba" );
            assertNotNull( "No se encontró el disco", disco );
            assertEquals( "El nombre del disco retornado no es el esperado", "Mi disco de prueba", disco.darNombreDisco( ) );
        }
        catch( ElementoExisteException e )
        {
            fail( "El disco debería haberse agregado correctamente, sin generar una excepción: " + e.getMessage( ) );
        }
    }

    /**
     * Verifica el método que agrega un disco a la discotienda para el caso en el que hay un error.<br>
     * En este caso se intenta agregar un disco con un nombre repetido. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarDisco. <br>
     * <b> Objetivo: </b> Probar que el método agregarDisco() arroje excepción cuando se intente registrar un disco con un nombre correspondiente a otro disco existente en la
     * discotienda. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al tratar de agregar un disco cuyo nombre pertenece a otro disco existente en la tienda se debe arrojar excepción. <br>
     * 2. Al tratar de agregar un disco cuyo nombre pertenece a otro disco existente en la tienda no deben cambiar el número de discos de la tienda.
     */
    public void testAgregarDiscoError( )
    {
        setupEscenario2( );

        int numeroDiscos = discotienda1.darDiscos( ).size( );
        try
        {
            // Se agrega el disco y se espera que esto genere una excepción
            discotienda1.agregarDisco( "disco1", "artistaPrueba", "Rock", "./data/imagenes/prueba.jpg" );
            fail( "El disco no debería haberse agregado porque ya hay otro disco con el mismo nombre" );
        }
        catch( ElementoExisteException e )
        {
            // Verificar que no haya cambiado la discotienda
            int numeroDiscos2 = discotienda1.darDiscos( ).size( );
            assertEquals( "Cambió el número de discos en la discotienda", numeroDiscos, numeroDiscos2 );
        }
    }

    /**
     * Verifica el método que agrega una canción a un disco de la discotienda.<br>
     * Este caso verifica que se pueda agregar una canción si los datos son correctos. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarCancionADisco. <br>
     * <b> Objetivo: </b> Probar que el método agregarCancionADisco() sea capaz de agregar una canción al disco. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al agregar una canción al disco cuyo nombre no corresponde a otra canción esta debe ser adicionada.<br>
     * 2. Al buscar una canción de un disco previamente agregada, esta debe ser encontrada.
     */
    public void testAgregarCancionADiscoOk( )
    {
        setupEscenario2( );

        try
        {
            discotienda1.agregarCancionADisco( "disco1", "cancion4", 4, 4, 4, 4, 4 );

            Disco disco = discotienda1.darDisco( "disco1" );
            assertNotNull( "No se encontró el disco", disco );
            assertEquals( "La canción no fue agregada al disco", 4, disco.darNombresCanciones( ).size( ) );

            Cancion c = disco.darCancion( "cancion4" );
            assertNotNull( "No se encontró la cancion", c );
            assertEquals( "La canción no fue agregada correctamente al disco", "cancion4", c.darNombre( ) );
        }
        catch( ElementoExisteException e )
        {
            fail( "La canción debería haberse agregado correctamente: " + e.getMessage( ) );
        }
    }

    /**
     * Verifica el método que agrega una canción a un disco de la discotienda.<br>
     * Este caso verifica que no se pueda agregar una canción si el nombre de la canción está repetido. <br>
     * <b> Métodos a probar: </b> <br>
     * agregarCancionADisco. <br>
     * <b> Objetivo: </b> Probar que el método agregarCancionADisco() arroje excepción al agregar una canción al disco cuyo nombre está repetido. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al tratar de agregar una canción al disco cuyo nombre está repetido, se debe arrojar excepción.<br>
     * 2. Al tratar de agregar una canción al disco cuyo nombre está repetido, el número de canciones no debe cambiar.
     */
    public void testAgregarCancionADiscoError( )
    {
        setupEscenario2( );

        Disco disco = discotienda1.darDisco( "disco1" );
        int numCanciones = disco.darNombresCanciones( ).size( );

        try
        {
            discotienda1.agregarCancionADisco( "disco1", "cancion2", 1, 20, 78.10, 2, 96 );
            fail( "La canción no debería haberse agregado porque el nombre está repetido y se debería generar una excepción" );
        }
        catch( ElementoExisteException e )
        {
            // Verificar que no haya cambiado el disco
            int numCanciones2 = disco.darNombresCanciones( ).size( );
            assertEquals( "Cambió el número de canciones en el disco", numCanciones, numCanciones2 );
        }
    }

    /**
     * Verifica el método salvarDiscotienda.<br>
     * La prueba se realiza creando una nueva discotienda, agregando algunos discos y salvando la información.<br>
     * A continuación se carga esta información en una nueva discotienda y se comparan ambas para verificar que la información se haya salvado correctamente.
     * @throws Exception Se lanza esta excepción si hay un problema en la lectura o escritura de los archivos <b> Métodos a probar: </b> <br>
     *         salvarDiscotienda, Discotienda (constructor). <br>
     *         <b> Objetivo: </b> Probar que el método salvarDiscotienda() sea capaz de guardar la información de la discotienda correctamente. <br>
     *         <b> Resultados esperados: </b> <br>
     *         1. Al salvar una discotienda y crear otra discotienda a partir del archivo en el que se salvo la primera, ambas discotiendas deben ser iguales (tener la misma
     *         información). <br>
     */
    public void testSalvarDiscotienda( ) throws Exception
    {
        // Generar un número aleatorio para el nombre del archivo
        Date fecha = new Date( );
        long tiempo = fecha.getTime( );
        String archivo = "./test/data/discotienda" + tiempo + ".dat";

        // Crear la discotienda que va a usar el archivo
        try
        {
            discotienda1 = new Discotienda( archivo );
        }
        catch( Exception e )
        {
            fail( "no se pudo cargar el archivo de prueba" );
        }

        // Meter información aleatoria en la discotienda
        generarInformacion( discotienda1 );

        // Salvar la información de la discotienda
        discotienda1.salvarDiscotienda( );

        // Construir una nueva discotienda con los mismos datos
        discotienda2 = new Discotienda( archivo );

        // Comparar las dos discotiedas
        compararDiscotiendas( discotienda1, discotienda2 );

        // Eliminar el archivo de prueba temporal
        File archivoPrueba2 = new File( archivo );
        archivoPrueba2.delete( );
    }

    /**
     * Verifica que el método validarEmail reconozca como válidos varios emails sin errores. <br>
     * <b> Métodos a probar: </b> <br>
     * validarEmail. <br>
     * <b> Objetivo: </b> Probar que el método validarEmail() sea capaz de validar correctamente los emails. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al validar un email que es correcto se debe obtener True.<br>
     */
    public void testValidarEmailOk( )
    {
        setupEscenario1( );

        assertTrue( "El email indicado es válido", discotienda1.validarEmail( "pe-rojas@uniedu.edu.tx" ) );
        assertTrue( "El email indicado es válido", discotienda1.validarEmail( "abc.def@cupi2.edu" ) );
        assertTrue( "El email indicado es válido", discotienda1.validarEmail( "qwerty@freemail.com" ) );
        assertTrue( "El email indicado es válido", discotienda1.validarEmail( "mail@correo.com.mm" ) );
    }

    /**
     * Verifica que el método validarEmail reconozca como inválidos varios emails con errores. <br>
     * <b> Métodos a probar: </b> <br>
     * validarEmail. <br>
     * <b> Objetivo: </b> Probar que el método validarEmail() sea capaz de validar correctamente los emails. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al validar un email que no es correcto se debe obtener False.<br>
     */
    public void testValidarEmailError( )
    {
        setupEscenario1( );

        assertFalse( "El email está incompleto", discotienda1.validarEmail( "pe-rojas" ) );
        assertFalse( "El email está incompleto", discotienda1.validarEmail( "abc.def@" ) );
        assertFalse( "El email está incompleto", discotienda1.validarEmail( "qwerty@freemail" ) );
        assertFalse( "El email está incompleto y termina con un punto", discotienda1.validarEmail( "qwerty@freemail." ) );
    }

    /**
     * Verifica el método venderCancion. <br>
     * Se espera que el número de unidades vendidas de la canción se incremente y que se genere una factura con el formato correcto. <br>
     * <b> Métodos a probar: </b> <br>
     * venderCancion. <br>
     * <b> Objetivo: </b> Probar que el método venderCancion() sea capaz de generar la factura e incrementar el número de unidades vendidas de la canción. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al vender una canción se debe generar una factura con el formato e información correctos.<br>
     * 2. Al vender una canción se debe incrementar en uno el número de unidades vendidas de la canción.
     */
    public void testVenderCancion( )
    {
        setupEscenario2( );

        Disco disco = discotienda1.darDisco( "disco2" );
        Cancion cancion = disco.darCancion( "cancion2" );
        int unidadesVendidas = cancion.darUnidadesVendidas( );
        try
        {
            String nombreArchivoFactura = discotienda1.venderCancion( disco, cancion, "prueba@prueba.com", "./test/data/factura/" );
            assertNotNull( "El nombre del archivo no debe ser null", nombreArchivoFactura );

            File archivoFactura = new File( "./test/data/factura/" + nombreArchivoFactura );
            assertTrue( "El archivo debe existir", archivoFactura.exists( ) );

            // Revisar el contenido del archivo
            BufferedReader br = new BufferedReader( new FileReader( archivoFactura ) );

            // Título
            String titulo = br.readLine( );
            assertNotNull( "La línea no es la esperada", titulo );

            // Fecha
            String fecha = br.readLine( );
            assertNotNull( "La segunda línea debe tener la fecha", fecha );
            assertTrue( "La línea no tiene el formato esperado", fecha.startsWith( "Fecha:" ) );
            Date fechaHoy = new Date( );
            String strFecha = fechaHoy.toString( ).substring( 0, 10 );
            assertTrue( "La fecha de la factura no es la fecha de hoy", fecha.indexOf( strFecha ) != -1 );

            // Email
            String email = br.readLine( );
            assertNotNull( "La segunda línea debe tener el email", email );
            assertTrue( "La línea no tiene el formato esperado - " + email, email.startsWith( "Email:" ) );
            assertTrue( "El email no es el esperado", email.indexOf( "prueba@prueba.com" ) != -1 );

            // Canción, línea 1
            String cancion1 = br.readLine( );
            assertNotNull( "La tercera línea debe tener el nombre y el artista de la canción", cancion1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion1, cancion1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion1.indexOf( "cancion2 - artista2" ) != -1 );

            // Canción, línea 2
            String cancion2 = br.readLine( );
            assertNotNull( "La cuarta línea debe tener el nombre del disco", cancion2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion2, cancion2.trim( ).indexOf( "disco2" ) == 0 );

            // Número de canciones
            String numCanciones = br.readLine( );
            assertNotNull( "La quinta línea debe tener el número de canciones", numCanciones );
            assertTrue( "La línea no tiene el formato esperado - " + numCanciones, numCanciones.startsWith( "No de Canciones:" ) );
            assertTrue( "El número de canciones no es el esperado", numCanciones.indexOf( "1" ) != -1 );

            // Total
            String total = br.readLine( );
            assertNotNull( "La sexta línea debe tener el valor total", total );
            assertTrue( "La línea no tiene el formato esperado - " + total, total.startsWith( "Valor Total:" ) );
            assertTrue( "El valor total no es el esperado", total.indexOf( "2,00" ) != -1 );

            int nuevasUnidadesVendidas = cancion.darUnidadesVendidas( );
            assertEquals( "El número de unidades vendidas de la canción no aumentó correctamente", unidadesVendidas + 1, nuevasUnidadesVendidas );
        }
        catch( IOException e )
        {
            fail( "No debería producirse esta excepción: " + e.getMessage( ) );
        }
    }

    /**
     * Verifica el método cargarPedido<br>
     * Se espera que el número de unidades vendidas de las canciones se incremente y que se genere una factura con el formato correcto. <br>
     * <b> Métodos a probar: </b> <br>
     * venderListaCanciones. <br>
     * <b> Objetivo: </b> Probar que el método venderListaCanciones() sea capaz de generar la factura e incrementar el número de unidades vendidas de la canciones. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al vender un grupo de canciones se debe generar una factura con el formato e información correctos.<br>
     * 2. Al vender un grupo de canciones se debe incrementar en uno el número de unidades vendidas de cada canción del grupo.
     */
    public void testCargarPedido( )
    {
        setupEscenario2( );
        File archivoPedido = new File( "./test/data/pedido.txt" );
        try
        {
            String nombreArchivoFactura = discotienda1.venderListaCanciones( archivoPedido, "./test/data/factura/" );
            assertNotNull( "El nombre del archivo no debe ser null", nombreArchivoFactura );

            File archivoFactura = new File( "./test/data/factura/" + nombreArchivoFactura );
            assertTrue( "El archivo debe existir", archivoFactura.exists( ) );

            // Revisar el contenido del archivo
            BufferedReader br = new BufferedReader( new FileReader( archivoFactura ) );

            // Título
            String titulo = br.readLine( );
            assertNotNull( "La línea no es la esperada", titulo );

            // Fecha
            String fecha = br.readLine( );
            assertNotNull( "La segunda línea debe tener la fecha", fecha );
            assertTrue( "La línea no tiene el formato esperado", fecha.startsWith( "Fecha:" ) );
            Date fechaHoy = new Date( );
            String strFecha = fechaHoy.toString( ).substring( 0, 10 );
            assertTrue( "La fecha de la factura no es la fecha de hoy", fecha.indexOf( strFecha ) != -1 );

            // Email
            String email = br.readLine( );
            assertNotNull( "La segunda línea debe tener el email", email );
            assertTrue( "La línea no tiene el formato esperado - " + email, email.startsWith( "Email:" ) );
            assertTrue( "El email no es el esperado", email.indexOf( "prueba@prueba.com" ) != -1 );

            // Canción 1, línea 1
            String cancion1_1 = br.readLine( );
            assertNotNull( "La tercera línea debe tener el nombre y el artista de la canción", cancion1_1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion1_1, cancion1_1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion1_1.indexOf( "cancion2 - artista1" ) != -1 );

            // Canción 1, línea 2
            String cancion1_2 = br.readLine( );
            assertNotNull( "La cuarta línea debe tener el nombre del disco", cancion1_2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion1_2, cancion1_2.trim( ).indexOf( "disco1" ) == 0 );

            // Canción 2, línea 1
            String cancion2_1 = br.readLine( );
            assertNotNull( "La quinta línea debe tener el nombre y el artista de la canción", cancion2_1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion2_1, cancion2_1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion2_1.indexOf( "cancion3 - artista1" ) != -1 );

            // Canción 2, línea 2
            String cancion2_2 = br.readLine( );
            assertNotNull( "La sexta línea debe tener el nombre del disco", cancion2_2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion2_2, cancion2_2.trim( ).indexOf( "disco1" ) == 0 );

            // Canción 3, línea 1
            String cancion3_1 = br.readLine( );
            assertNotNull( "La séptima línea debe tener el nombre y el artista de la canción", cancion3_1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion3_1, cancion3_1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion3_1.indexOf( "cancion2 - artista2" ) != -1 );

            // Canción 3, línea 2
            String cancion3_2 = br.readLine( );
            assertNotNull( "La octava línea debe tener el nombre del disco", cancion3_2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion3_2, cancion3_2.trim( ).indexOf( "disco2" ) == 0 );

            // Número de canciones
            String numCanciones = br.readLine( );
            assertNotNull( "La novena línea debe tener el número de canciones", numCanciones );
            assertTrue( "La línea no tiene el formato esperado - " + numCanciones, numCanciones.startsWith( "No de Canciones:" ) );
            assertTrue( "El número de canciones no es el esperado", numCanciones.indexOf( "3" ) != -1 );

            // Total
            String total = br.readLine( );
            assertNotNull( "La décima línea debe tener el valor total", total );
            assertTrue( "La línea no tiene el formato esperado - " + total, total.startsWith( "Valor Total:" ) );
            assertTrue( "El valor total no es el esperado", total.indexOf( "7,00" ) != -1 );

            Disco disco1 = discotienda1.darDisco( "disco1" );
            Cancion cancion1 = disco1.darCancion( "cancion2" );
            assertEquals( "El número de unidades vendidas de la canción no aumentó correctamente", 1, cancion1.darUnidadesVendidas( ) );

            Cancion cancion2 = disco1.darCancion( "cancion3" );
            assertEquals( "El número de unidades vendidas de la canción no aumentó correctamente", 1, cancion2.darUnidadesVendidas( ) );

            Disco disco2 = discotienda1.darDisco( "disco2" );
            Cancion cancion3 = disco2.darCancion( "cancion2" );
            assertEquals( "El número de unidades vendidas de la canción no aumentó correctamente", 1, cancion3.darUnidadesVendidas( ) );

        }
        catch( IOException e )
        {
            fail( "No debería producirse esta excepción: " + e.getMessage( ) );
        }
        catch( ArchivoVentaException e )
        {
            fail( "No debería producirse esta excepción: " + e.getMessage( ) );
        }
    }

    /**
     * Verifica que el método cargarPedido haga las verificaciones correctas para validar la información del pedido. <br>
     * El archivo utilizado tiene un formato incorrecto para las canciones. <br>
     * <b> Métodos a probar: </b> <br>
     * venderListaCanciones. <br>
     * <b> Objetivo: </b> Probar que el método venderListaCanciones() genere la factura discriminando correctamente las canciones que fueron vendidas y las que no por causas
     * del formato incorrecto de las líneas del archivo. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al tratar de vender un grupo de canciones con un archivo de pedidos con un formato incorrecto se deben agregar en la lista de canciones no vendidas las canciones de
     * la linea correspondiente.
     */
    public void testCargarPedidoError1( )
    {
        setupEscenario2( );
        File archivoPedido = new File( "./test/data/pedido1.txt" );
        try
        {
            String nombreArchivoFactura = discotienda1.venderListaCanciones( archivoPedido, "./test/data/factura/" );
            File archivoFactura = new File( "./test/data/factura/" + nombreArchivoFactura );

            // Revisar el contenido del archivo
            BufferedReader br = new BufferedReader( new FileReader( archivoFactura ) );

            // Título
            String titulo = br.readLine( );
            assertNotNull( "La línea no es la esperada", titulo );

            // Fecha
            String fecha = br.readLine( );
            assertNotNull( "La segunda línea debe tener la fecha", fecha );
            assertTrue( "La línea no tiene el formato esperado", fecha.startsWith( "Fecha:" ) );
            Date fechaHoy = new Date( );
            String strFecha = fechaHoy.toString( ).substring( 0, 10 );
            assertTrue( "La fecha de la factura no es la fecha de hoy", fecha.indexOf( strFecha ) != -1 );

            // Email
            String email = br.readLine( );
            assertNotNull( "La segunda línea debe tener el email", email );
            assertTrue( "La línea no tiene el formato esperado - " + email, email.startsWith( "Email:" ) );
            assertTrue( "El email no es el esperado", email.indexOf( "prueba@prueba.com" ) != -1 );

            // Canción 1, línea 1
            String cancion1_1 = br.readLine( );
            assertNotNull( "La tercera línea debe tener el nombre y el artista de la canción", cancion1_1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion1_1, cancion1_1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion1_1.indexOf( "cancion3 - artista1" ) != -1 );

            // Canción 1, línea 2
            String cancion1_2 = br.readLine( );
            assertNotNull( "La cuarta línea debe tener el nombre del disco", cancion1_2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion1_2, cancion1_2.trim( ).indexOf( "disco1" ) == 0 );

            // Canción 2, línea 1
            String cancion2_1 = br.readLine( );
            assertNotNull( "La quinta línea debe tener el nombre y el artista de la canción", cancion2_1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion2_1, cancion2_1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion2_1.indexOf( "cancion2 - artista2" ) != -1 );

            // Canción 2, línea 2
            String cancion2_2 = br.readLine( );
            assertNotNull( "La sexta línea debe tener el nombre del disco", cancion2_2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion2_2, cancion2_2.trim( ).indexOf( "disco2" ) == 0 );

            // Número de canciones
            String numCanciones = br.readLine( );
            assertNotNull( "La novena línea debe tener el número de canciones", numCanciones );
            assertTrue( "La línea no tiene el formato esperado - " + numCanciones, numCanciones.startsWith( "No de Canciones:" ) );
            assertTrue( "El número de canciones no es el esperado", numCanciones.indexOf( "2" ) != -1 );

            // Total
            String total = br.readLine( );
            assertNotNull( "La décima línea debe tener el valor total", total );
            assertTrue( "La línea no tiene el formato esperado - " + total, total.startsWith( "Valor Total:" ) );
            assertTrue( "El valor total no es el esperado", total.indexOf( "5,00" ) != -1 );

            // Canciones no encontradas
            String lineaVacia = br.readLine( );
            assertEquals( "La línea no tiene el formato esperado", "", lineaVacia );

            String tituloNoEncontradas = br.readLine( );
            assertTrue( "La línea no tiene el formato esperado", tituloNoEncontradas.startsWith( "Canciones no encontradas" ) );

            String noEncontradas = br.readLine( );
            assertTrue( "La línea no tiene el formato esperado", noEncontradas.startsWith( "disco1@artista1#cancion2" ) );

        }
        catch( IOException e )
        {
            fail( "No debería producirse esta excepción: " + e.getMessage( ) );
        }
        catch( ArchivoVentaException e )
        {
            fail( "No debería producirse esta excepción: " + e.getMessage( ) );
        }
    }

    /**
     * Verifica que el método cargarPedido haga las verificaciones correctas para validar la información del pedido<br>
     * El archivo utilizado tiene canciones que no existen en la discotienda. <br>
     * <b> Métodos a probar: </b> <br>
     * venderListaCanciones. <br>
     * <b> Objetivo: </b> Probar que el método venderListaCanciones() genere la factura discriminando correctamente las canciones que fueron vendidas y las que no por causa de
     * no encontrar la canción. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al vender un grupo de canciones, alguna de las cuales no existe en ningún disco de la discotienda, se debe generar una factura discrimimando las canciones vendidas y
     * las no vendidas.
     */
    public void testCargarPedidoError2( )
    {
        setupEscenario2( );
        File archivoPedido = new File( "./test/data/pedido2.txt" );
        try
        {
            String nombreArchivoFactura = discotienda1.venderListaCanciones( archivoPedido, "./test/data/factura/" );
            File archivoFactura = new File( "./test/data/factura/" + nombreArchivoFactura );
            // Revisar el contenido del archivo
            BufferedReader br = new BufferedReader( new FileReader( archivoFactura ) );

            // Título
            String titulo = br.readLine( );
            assertNotNull( "La línea no es la esperada", titulo );

            // Fecha
            String fecha = br.readLine( );
            assertNotNull( "La segunda línea debe tener la fecha", fecha );
            assertTrue( "La línea no tiene el formato esperado", fecha.startsWith( "Fecha:" ) );
            Date fechaHoy = new Date( );
            String strFecha = fechaHoy.toString( ).substring( 0, 10 );
            assertTrue( "La fecha de la factura no es la fecha de hoy", fecha.indexOf( strFecha ) != -1 );

            // Email
            String email = br.readLine( );
            assertNotNull( "La segunda línea debe tener el email", email );
            assertTrue( "La línea no tiene el formato esperado - " + email, email.startsWith( "Email:" ) );
            assertTrue( "El email no es el esperado", email.indexOf( "prueba@prueba.com" ) != -1 );

            // Canción 1, línea 1
            String cancion1_1 = br.readLine( );
            assertNotNull( "La tercera línea debe tener el nombre y el artista de la canción", cancion1_1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion1_1, cancion1_1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion1_1.indexOf( "cancion2 - artista1" ) != -1 );

            // Canción 1, línea 2
            String cancion1_2 = br.readLine( );
            assertNotNull( "La cuarta línea debe tener el nombre del disco", cancion1_2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion1_2, cancion1_2.trim( ).indexOf( "disco1" ) == 0 );

            // Canción 2, línea 1
            String cancion2_1 = br.readLine( );
            assertNotNull( "La quinta línea debe tener el nombre y el artista de la canción", cancion2_1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion2_1, cancion2_1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion2_1.indexOf( "cancion2 - artista2" ) != -1 );

            // Canción 2, línea 2
            String cancion2_2 = br.readLine( );
            assertNotNull( "La sexta línea debe tener el nombre del disco", cancion2_2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion2_2, cancion2_2.trim( ).indexOf( "disco2" ) == 0 );

            // Número de canciones
            String numCanciones = br.readLine( );
            assertNotNull( "La novena línea debe tener el número de canciones", numCanciones );
            assertTrue( "La línea no tiene el formato esperado - " + numCanciones, numCanciones.startsWith( "No de Canciones:" ) );
            assertTrue( "El número de canciones no es el esperado", numCanciones.indexOf( "2" ) != -1 );

            // Total
            String total = br.readLine( );
            assertNotNull( "La décima línea debe tener el valor total", total );
            assertTrue( "La línea no tiene el formato esperado - " + total, total.startsWith( "Valor Total:" ) );
            assertTrue( "El valor total no es el esperado", total.indexOf( "4,00" ) != -1 );

            // Canciones no encontradas
            String lineaVacia = br.readLine( );
            assertEquals( "La línea no tiene el formato esperado", "", lineaVacia );

            String tituloNoEncontradas = br.readLine( );
            assertTrue( "La línea no tiene el formato esperado", tituloNoEncontradas.startsWith( "Canciones no encontradas" ) );

            String noEncontradas = br.readLine( );
            assertTrue( "La línea no tiene el formato esperado", noEncontradas.startsWith( "disco1#artista1#cancion5" ) );
        }
        catch( IOException e )
        {
            fail( "No debería producirse esta excepción: " + e.getMessage( ) );
        }
        catch( ArchivoVentaException e )
        {
            fail( "No debería producirse esta excepción: " + e.getMessage( ) );
        }
    }

    /**
     * Verifica que el método cargarPedido haga las verificaciones correctas para validar la información del pedido. <br>
     * El archivo utilizado tiene discos que no existen en la discotienda. <br>
     * <b> Métodos a probar: </b> <br>
     * venderListaCanciones. <br>
     * <b> Objetivo: </b> Probar que el método venderListaCanciones() genere la factura discriminando correctamente las canciones que fueron vendidas y las que no por causa de
     * no encontrar el disco al que pertenece la canción. <br>
     * <b> Resultados esperados: </b> <br>
     * 1. Al vender un grupo de canciones, alguna de las cuales no existe en ningún disco de la discotienda, se debe generar una factura discrimimando las canciones vendidas y
     * las no vendidas.
     */
    public void testCargarPedidoError3( )
    {
        setupEscenario2( );
        File archivoPedido = new File( "./test/data/pedido2.txt" );
        try
        {
            String nombreArchivoFactura = discotienda1.venderListaCanciones( archivoPedido, "./test/data/factura/" );
            File archivoFactura = new File( "./test/data/factura/" + nombreArchivoFactura );
            // Revisar el contenido del archivo
            BufferedReader br = new BufferedReader( new FileReader( archivoFactura ) );

            // Título
            String titulo = br.readLine( );
            assertNotNull( "La línea no es la esperada", titulo );

            // Fecha
            String fecha = br.readLine( );
            assertNotNull( "La segunda línea debe tener la fecha", fecha );
            assertTrue( "La línea no tiene el formato esperado", fecha.startsWith( "Fecha:" ) );
            Date fechaHoy = new Date( );
            String strFecha = fechaHoy.toString( ).substring( 0, 10 );
            assertTrue( "La fecha de la factura no es la fecha de hoy", fecha.indexOf( strFecha ) != -1 );

            // Email
            String email = br.readLine( );
            assertNotNull( "La segunda línea debe tener el email", email );
            assertTrue( "La línea no tiene el formato esperado - " + email, email.startsWith( "Email:" ) );
            assertTrue( "El email no es el esperado", email.indexOf( "prueba@prueba.com" ) != -1 );

            // Canción 1, línea 1
            String cancion1_1 = br.readLine( );
            assertNotNull( "La tercera línea debe tener el nombre y el artista de la canción", cancion1_1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion1_1, cancion1_1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion1_1.indexOf( "cancion2 - artista1" ) != -1 );

            // Canción 1, línea 2
            String cancion1_2 = br.readLine( );
            assertNotNull( "La cuarta línea debe tener el nombre del disco", cancion1_2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion1_2, cancion1_2.trim( ).indexOf( "disco1" ) == 0 );

            // Canción 2, línea 1
            String cancion2_1 = br.readLine( );
            assertNotNull( "La quinta línea debe tener el nombre y el artista de la canción", cancion2_1 );
            assertTrue( "La línea no tiene el formato esperado - " + cancion2_1, cancion2_1.startsWith( "Canción:" ) );
            assertTrue( "El contenido de la línea no es el esperado", cancion2_1.indexOf( "cancion2 - artista2" ) != -1 );

            // Canción 2, línea 2
            String cancion2_2 = br.readLine( );
            assertNotNull( "La sexta línea debe tener el nombre del disco", cancion2_2 );
            assertTrue( "El contenido de la línea no es el esperado - " + cancion2_2, cancion2_2.trim( ).indexOf( "disco2" ) == 0 );

            // Número de canciones
            String numCanciones = br.readLine( );
            assertNotNull( "La novena línea debe tener el número de canciones", numCanciones );
            assertTrue( "La línea no tiene el formato esperado - " + numCanciones, numCanciones.startsWith( "No de Canciones:" ) );
            assertTrue( "El número de canciones no es el esperado", numCanciones.indexOf( "2" ) != -1 );

            // Total
            String total = br.readLine( );
            assertNotNull( "La décima línea debe tener el valor total", total );
            assertTrue( "La línea no tiene el formato esperado - " + total, total.startsWith( "Valor Total:" ) );
            assertTrue( "El valor total no es el esperado", total.indexOf( "4,00" ) != -1 );

            // Canciones no encontradas
            String lineaVacia = br.readLine( );
            assertEquals( "La línea no tiene el formato esperado", "", lineaVacia );

            String tituloNoEncontradas = br.readLine( );
            assertTrue( "La línea no tiene el formato esperado", tituloNoEncontradas.startsWith( "Canciones no encontradas" ) );

            String noEncontradas = br.readLine( );
            assertTrue( "La línea no tiene el formato esperado", noEncontradas.startsWith( "disco1#artista1#cancion5" ) );

        }
        catch( IOException e )
        {
            fail( "No debería producirse esta excepción: " + e.getMessage( ) );
        }
        catch( ArchivoVentaException e )
        {
            fail( "No debería producirse esta excepción: " + e.getMessage( ) );
        }
    }

    // -----------------------------------------------------------------
    // Métodos Auxiliares
    // -----------------------------------------------------------------

    /**
     * Este método se encarga de verificar que dos discotiendas sean iguales.<br>
     * El método revisa que las discotiendas tengan los mismos discos y que cada disco sea igual canción por canción al que hay en la otra discotienda.<br>
     * No existe ninguna condición que indique que las discotiendas deben tener los discos ordenados de la misma manera.
     * @param discotienda1 La primera discotienda para comparar
     * @param discotienda2 La segunda discotienda para comparar
     */
    private void compararDiscotiendas( Discotienda discotienda1, Discotienda discotienda2 )
    {
        // Comparar que haya el mismo número de discos
        ArrayList discos1 = discotienda1.darDiscos( );
        ArrayList discos2 = discotienda2.darDiscos( );
        assertEquals( "El número de discos es diferente", discos1.size( ), discos2.size( ) );

        for( int i = 0; i < discos1.size( ); i++ )
        {
            // Verificar que los mismos discos estén en las dos discotiendas
            String nombre_disco = ( String )discos1.get( i );
            Disco d1 = discotienda1.darDisco( nombre_disco );
            Disco d2 = discotienda2.darDisco( nombre_disco );
            assertNotNull( "La segunda discotienda no contenía al disco " + nombre_disco, d2 );

            // Comparar que haya el mismo número de canciones en los dos discos
            ArrayList canciones_d1 = d1.darNombresCanciones( );
            ArrayList canciones_d2 = d2.darNombresCanciones( );
            assertEquals( "El número de canciones es diferente", canciones_d1.size( ), canciones_d2.size( ) );
            for( int j = 0; j < canciones_d1.size( ); j++ )
            {
                // Verificar que las mismas canciones estén en los dos discos
                String nombre_cancion = ( String )canciones_d1.get( j );
                Cancion c1 = d1.darCancion( nombre_cancion );
                Cancion c2 = d2.darCancion( nombre_cancion );
                assertNotNull( "El disco " + nombre_disco + "de la segunda discotienda no contenía la canción " + nombre_cancion, d2 );

                assertEquals( "Los atributos de las dos canciones no son idénticos", c1.darCalidad( ), c2.darCalidad( ), 0 );
                assertEquals( "Los atributos de las dos canciones no son idénticos", c1.darMinutos( ), c2.darMinutos( ), 0 );
                assertEquals( "Los atributos de las dos canciones no son idénticos", c1.darNombre( ), c2.darNombre( ) );
                assertEquals( "Los atributos de las dos canciones no son idénticos", c1.darPrecio( ), c2.darPrecio( ), 0 );
                assertEquals( "Los atributos de las dos canciones no son idénticos", c1.darSegundos( ), c2.darSegundos( ), 0 );
                assertEquals( "Los atributos de las dos canciones no son idénticos", c1.darTamano( ), c2.darTamano( ), 0 );
            }
        }
    }

    /**
     * Este método genera información aleatoria para meter en la discotienda
     * @param discotienda La discotienda donde se va a meter la información
     */
    private void generarInformacion( Discotienda discotienda )
    {
        int numeroDiscos = ( int ) ( Math.random( ) * 10 );
        int numeroCanciones = ( int ) ( Math.random( ) * 20 );

        try
        {
            for( int i = 0; i < numeroDiscos; i++ )
            {
                String nombreDisco = "disco_" + i;
                discotienda.agregarDisco( nombreDisco, "random", "música aleatoria", "random.jpg" );

                for( int j = 0; j < numeroCanciones; j++ )
                {
                    String nombreCancion = "cancion_" + j;
                    discotienda.agregarCancionADisco( nombreDisco, nombreCancion, 1, 2, 3, 4, 5 );
                }
            }
        }
        catch( ElementoExisteException e )
        {
            fail( "Debería haberse podido agregar el disco o la canción: " + e.getMessage( ) );
        }
    }
}

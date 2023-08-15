/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Disco.java,v 1.10 2006/08/10 20:04:47 da-romer Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_discotienda 
 * Autor: Nicolás López - 06/12/2005
 * Autor: Mario Sánchez - 26/01/2005
 * Autor: Jorge Villalobos - 29/07/2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.discotienda.mundo;

import java.io.*;
import java.util.*;

/**
 * Es la clase que representa un disco. <br>
 * <b>inv: </b> <br>
 * canciones != null <br>
 * nombreDisco != null && nombreDisco != "" <br>
 * artista != null && artista != "" <br>
 * genero != null && genero != "" <br>
 * imagen != null && imagen != "" <br>
 * No hay dos canciones con el mismo nombre <br>
 * El precio del disco es igual a la suma de los precios de todas las canciones que incluye
 */
public class Disco implements Serializable
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Indicador de versión para la serialización
     */
    private static final long serialVersionUID = 100L;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es el vector con las canciones del disco
     */
    private ArrayList canciones;

    /**
     * Es el título del disco
     */
    private String nombreDisco;

    /**
     * Es el nombre del artista del disco
     */
    private String artista;

    /**
     * Es el género del disco
     */
    private String genero;

    /**
     * Nombre del archivo que contiene la imagen asociada con el disco. Dicho archivo debe encontrarse en el directorio ./data/imagenes
     */
    private String imagen;

    /**
     * Precio total del disco
     */
    private double precioTotal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye un nuevo Disco con los datos suministrados y sin canciones
     * @param nombreDiscoD es el nombreDisco del disco - nombreDiscoD != null, nombreDiscoD != ""
     * @param artistaD es el nombre del artista del disco - artistaD != null, artistaD != ""
     * @param generoD es el género del disco del disco - generoD != null, generoD != ""
     * @param imagenD es la imagen del disco - imagenD != null, imagenD != ""
     */
    public Disco( String nombreDiscoD, String artistaD, String generoD, String imagenD )
    {
        canciones = new ArrayList( );
        nombreDisco = nombreDiscoD;
        artista = artistaD;
        genero = generoD;
        imagen = imagenD;
        precioTotal = 0;

        verificarInvariante( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna una canción del disco dado su nombre.
     * @param nombreC el nombre de la canción a buscar - nombreC != null
     * @return la canción cuyo nombre es igual al nombre dado. Si no se encontró retorna null.
     */
    public Cancion darCancion( String nombreC )
    {
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            if( c.equals( nombreC ) )
                return c;
        }
        return null;
    }

    /**
     * Agrega una canción al disco. <br>
     * <b>post: </b> La canción c ha sido agregada al disco
     * @param c la nueva canción que se va a agregar al disco
     * @throws ElementoExisteException si ya existía una canción con el mismo nombre
     */
    public void agregarCancion( Cancion c ) throws ElementoExisteException
    {
        if( darCancion( c.darNombre( ) ) != null )
            throw new ElementoExisteException( "La canción " + c.darNombre( ) + " ya existe en el disco" );

        canciones.add( c );
        precioTotal += c.darPrecio( );

        verificarInvariante( );
    }

    /**
     * Retorna el artista del disco
     * @return Artista del disco
     */
    public String darArtista( )
    {
        return artista;
    }

    /**
     * Retorna un vector con los nombres de las canciones del disco
     * @return Vector con los nombres de las canciones
     */
    public ArrayList darNombresCanciones( )
    {
        ArrayList nombresCanciones = new ArrayList( );
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            nombresCanciones.add( c.darNombre( ) );
        }
        return nombresCanciones;
    }

    /**
     * Retorna el género del disco
     * @return Género del disco
     */
    public String darGenero( )
    {
        return genero;
    }

    /**
     * Retorna el nombre del disco
     * @return Nombre del disco
     */
    public String darNombreDisco( )
    {
        return nombreDisco;
    }

    /**
     * Retorna el nombre del archivo que contiene la imagen del disco
     * @return Nombre del archivo que contiene la imagen del disco
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Retorna el precio total del disco
     * @return Precio total del disco
     */
    public double darPrecioDisco( )
    {
        return precioTotal;
    }

    /**
     * Indica si el disco tiene el nombre que llega como parámetro
     * @param nombre es el nombre de un disco - nombre != null
     * @return True si el disco tiene el nombre que llega como parámetro
     */
    public boolean equals( String nombre )
    {
        return nombreDisco.equalsIgnoreCase( nombre );
    }

    // -----------------------------------------------------------------
    // Invariante
    // -----------------------------------------------------------------

    /**
     * Verifica el invariante de la clase: <br>
     * canciones != null <br>
     * nombreDisco != null && nombreDisco != "" <br>
     * artista != null && artista != "" <br>
     * genero != null && genero != "" <br>
     * imagen != null && imagen != "" <br>
     * No hay dos canciones con el mismo nombre <br>
     * El precio del disco es igual a la suma de los precios de todas las canciones que incluye
     */
    private void verificarInvariante( )
    {
        assert canciones != null : "La lista de canciones es nula";
        assert nombreDisco != null && !nombreDisco.equals( "" ) : "El nombre del disco es inválido";
        assert artista != null && !artista.equals( "" ) : "El nombre del artista es inválido";
        assert genero != null && !genero.equals( "" ) : "El nombre del género es inválido";
        assert imagen != null && !imagen.equals( "" ) : "El nombre del archivo con la imagen es inválido";

        assert !buscarCancionesConElMismoNombre( ) : "Hay dos canciones con el mismo nombre";
        assert precioTotal == recalcularPrecioDisco( ) : "Hay un error en el cálculo del precio total del disco";
    }

    /**
     * Recalcula el precio de un disco sumando los precios de las canciones que contiene
     * @return Precio total del disco
     */
    private double recalcularPrecioDisco( )
    {
        double acumPrecioTotal = 0;
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c = ( Cancion )canciones.get( i );
            acumPrecioTotal = acumPrecioTotal + c.darPrecio( );
        }
        return acumPrecioTotal;
    }

    /**
     * Este método sirve para revisar si hay canciones repetidas dentro del disco.
     * @return Retorna true si hay una canción que aparece repetida dentro de la lista de canciones. Retorna false en caso contrario.
     */
    private boolean buscarCancionesConElMismoNombre( )
    {
        for( int i = 0; i < canciones.size( ); i++ )
        {
            Cancion c1 = ( Cancion )canciones.get( i );
            for( int j = i + 1; j < canciones.size( ); j++ )
            {
                Cancion c2 = ( Cancion )canciones.get( j );
                if( c1.equals( c2.darNombre( ) ) )
                    return true;
            }
        }
        return false;
    }
    
    
}

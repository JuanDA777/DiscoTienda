/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoCrearDisco.java,v 1.4 2006/08/10 20:08:30 da-romer Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_discotienda 
 * Autor: Nicolás López - 06/12/2005 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.discotienda.interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Es el diálogo para crear un nuevo disco
 */
public class DialogoCrearDisco extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazDiscotienda principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el panel con los datos para crear el nuevo disco
     */
    private PanelCrearDisco panelDatos;

    /**
     * Es el panel con los botones para guardar el disco
     */
    private PanelBotonesDisco panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearDisco( InterfazDiscotienda id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearDisco( );
        panelBotones = new PanelBotonesDisco( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Disco" );
        pack( );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Guarda el disco
     */
    public void crearDisco( )
    {
        boolean parametersOk = true;
        String artista = panelDatos.darArtista( );
        String titulo = panelDatos.darTitulo( );
        String genero = panelDatos.darGenero( );
        String imagen = panelDatos.darImagen( );

        if( ( artista.equals( "" ) || titulo.equals( "" ) ) || ( genero.equals( "" ) || imagen.equals( "" ) ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Todos los campos deben ser llenados para crear el disco" );
        }
        if( parametersOk )
        {
            boolean ok = principal.crearDisco( titulo, artista, genero, imagen );
            if( ok )
                dispose( );
        }
    }
}

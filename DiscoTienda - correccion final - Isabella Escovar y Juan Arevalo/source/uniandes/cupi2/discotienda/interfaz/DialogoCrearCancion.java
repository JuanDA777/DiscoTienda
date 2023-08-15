/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoCrearCancion.java,v 1.5 2006/08/10 20:08:30 da-romer Exp $
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
 * Es el diálogo para crear una nuevo canción
 */
public class DialogoCrearCancion extends JDialog
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
     * Es el panel con los datos para crear la nueva canción
     */
    private PanelCrearCancion panelDatos;

    /**
     * Es el panel con los botones para guardar la canción
     */
    private PanelBotonesCancion panelBotones;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo
     * 
     * @param id es una referencia a la clase principal de la interfaz
     */
    public DialogoCrearCancion( InterfazDiscotienda id )
    {
        super( id, true );
        principal = id;

        panelDatos = new PanelCrearCancion( );
        panelBotones = new PanelBotonesCancion( this );

        getContentPane( ).add( panelDatos, BorderLayout.CENTER );
        getContentPane( ).add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Crear Canción" );
        pack( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Guarda la canción
     */
    public void crearCancion( )
    {
        boolean parametersOk = true;
        double precio = 0;
        int calidad = 0;
        double tamano = 0;
        int minutos = 0;
        int segundos = 0;
        String nombre = panelDatos.darNombre( );
        if( nombre.equals( "" ) )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Debe ingresar el nombre de la canción " );
        }
        try
        {
            precio = Double.parseDouble( panelDatos.darPrecio( ) );
            if( precio < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "El precio ingresado no es un valor válido" );
            }
        }
        catch( Exception e )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "El precio ingresado no es un valor válido" );
        }

        try
        {
            calidad = Integer.parseInt( panelDatos.darCalidad( ) );
            if( calidad < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "La calidad ingresada no es un valor válido" );
            }
        }
        catch( Exception e )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "La calidad ingresada no es un valor válido" );
        }

        try
        {
            tamano = Double.parseDouble( panelDatos.darTamano( ) );
            if( tamano < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "El tamaño ingresado no es un valor válido" );
            }
        }
        catch( Exception e )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "El tamaño ingresado no es un valor válido" );
        }

        try
        {
            minutos = Integer.parseInt( panelDatos.darMinutos( ) );
            if( minutos < 0 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "Los minutos ingresados no son un valor válido" );
            }
        }
        catch( Exception e )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Los minutos ingresados nos son un valor válido" );
        }

        try
        {
            segundos = Integer.parseInt( panelDatos.darSegundos( ) );
            if( segundos < 0 || segundos >= 60 )
            {
                parametersOk = false;
                JOptionPane.showMessageDialog( this, "Los segundos ingresados no son un valor válido" );
            }
        }
        catch( Exception e )
        {
            parametersOk = false;
            JOptionPane.showMessageDialog( this, "Los segundos ingresados nos son un valor válido" );
        }

        if( parametersOk )
        {
            boolean ok = principal.crearCancion( nombre, minutos, segundos, precio, tamano, calidad );

            if( ok )
                dispose( );
        }
    }
}

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelBotonesCancion.java,v 1.3 2006/08/10 20:08:30 da-romer Exp $
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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Es el panel con los botones para agregar una nueva canción
 */
public class PanelBotonesCancion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para crear una canción
     */
    private static final String CREAR_CANCION = "CrearCancion";

    /**
     * El comando para cancelar la creación de una canción
     */
    private static final String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia al dialogo al que pertenece este panel
     */
    private DialogoCrearCancion ventana;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el boton que sirve para agregar una nueva canción
     */
    private JButton botonAgregarCancion;

    /**
     * Es el botón que sirve para cerrar el diálogo sin guardar los cambios
     */
    private JButton botonCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param dcc es una referencia al diálogo que contiene a este panel
     */
    public PanelBotonesCancion( DialogoCrearCancion dcc )
    {

        ventana = dcc;

        botonAgregarCancion = new JButton( "Crear" );
        botonAgregarCancion.setActionCommand( CREAR_CANCION );
        botonAgregarCancion.addActionListener( this );
        add( botonAgregarCancion );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );
        add( botonCancelar );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Ejecuta las acciones asociadas a los eventos
     * @param evento es el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( CREAR_CANCION.equals( comando ) )
        {
            ventana.crearCancion( );
        }
        else if( CANCELAR.equals( comando ) )
        {
            ventana.dispose( );
        }

    }

}

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelPedido.java,v 1.3 2006/08/10 20:04:35 da-romer Exp $
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_discotienda 
 * Autor: Mario Sánchez - 07-Jul-2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.discotienda.interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Es el panel donde se carga un pedido
 */
public class PanelPedido extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para el botón para cargar un pedido
     */
    private static final String CARGAR_PEDIDO = "CargarPedido";

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
     * El botón usado para cargar un pedido
     */
    private JButton btnPedido;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     * @param ventanaPrincipal es una referencia a la ventana principal de la interfaz
     */
    public PanelPedido( InterfazDiscotienda ventanaPrincipal )
    {
        principal = ventanaPrincipal;
        setBorder( new TitledBorder( "Pedidos" ) );

        btnPedido = new JButton( "Cargar Pedido" );
        btnPedido.setActionCommand( CARGAR_PEDIDO );
        btnPedido.addActionListener( this );
        add( btnPedido );
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

        if( CARGAR_PEDIDO.equals( comando ) )
        {
            principal.cargarPedido( );
        }
    }

}

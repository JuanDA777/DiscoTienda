/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelDiscos.java,v 1.4 2006/08/10 20:04:35 da-romer Exp $
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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.discotienda.mundo.Disco;

/**
 * Es el panel con los detalles de un disco
 */
public class PanelDiscos extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando para el combo box con los discos
     */
    private static final String CAMBIAR_DISCO = "CambiarDisco";

    /**
     * Comando para el botón para agregar un disco
     */
    private static final String AGREGAR_DISCO = "AgregarDisco";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazDiscotienda principal;

    /**
     * Es el disco que actualmente se presenta en el panel
     */
    private Disco disco;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el comboBox con la lista de discos
     */
    private JComboBox comboDiscos;

    /**
     * Es la etiqueta "Artista"
     */
    private JLabel etiquetaTituloArtista;

    /**
     * Es el campo con el artista del disco
     */
    private JTextField txtArtista;

    /**
     * Es la etiqueta "Genero"
     */
    private JLabel etiquetaTituloGenero;

    /**
     * Es el campo con el género del disco
     */
    private JTextField txtGenero;

    /**
     * Es la etiqueta con el precio del disco
     */
    private JLabel etiquetaTituloPrecio;

    /**
     * Es el campo con el precio del disco completo
     */
    private JTextField txtPrecio;

    /**
     * Es el botón para mostrar el diálogo para agregar un nuevo disco
     */
    private JButton botonAgregarDisco;

    /**
     * Es el campo que muestra la imágen del disco
     */
    private JLabel etiquetaImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel para la información de un disco de la discotienda
     * @param ventanaPrincipal es una referencia a la clase principal de la interfaz
     * @param discos unna lista con los nombres de los discos que se tienen en la discotienda
     */
    public PanelDiscos( InterfazDiscotienda ventanaPrincipal, ArrayList discos )
    {
        principal = ventanaPrincipal;

        setLayout( new BorderLayout( ) );

        comboDiscos = new JComboBox( discos.toArray( ) );
        comboDiscos.setEditable( false );
        comboDiscos.addActionListener( this );
        comboDiscos.setActionCommand( CAMBIAR_DISCO );
        add( comboDiscos, BorderLayout.NORTH );

        JPanel panelDatosDisco = new JPanel( );
        add( panelDatosDisco, BorderLayout.CENTER );

        panelDatosDisco.setLayout( new GridLayout( 6, 1, 0, 5 ) );

        etiquetaTituloArtista = new JLabel( "Artista: " );
        txtArtista = new JTextField( 10 );
        txtArtista.setEditable( false );
        txtArtista.setFont( txtArtista.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosDisco.add( etiquetaTituloArtista );
        panelDatosDisco.add( txtArtista );

        etiquetaTituloGenero = new JLabel( "Género: " );
        txtGenero = new JTextField( 10 );
        txtGenero.setEditable( false );
        txtGenero.setFont( txtGenero.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosDisco.add( etiquetaTituloGenero );
        panelDatosDisco.add( txtGenero );

        etiquetaTituloPrecio = new JLabel( "Precio: " );
        txtPrecio = new JTextField( 10 );
        txtPrecio.setEditable( false );
        txtPrecio.setFont( txtPrecio.getFont( ).deriveFont( Font.PLAIN ) );
        panelDatosDisco.add( etiquetaTituloPrecio );
        panelDatosDisco.add( txtPrecio );

        panelDatosDisco.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        etiquetaImagen = new JLabel( );
        etiquetaImagen.setPreferredSize( new Dimension( 200, 200 ) );
        etiquetaImagen.setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "" ) ) );
        add( etiquetaImagen, BorderLayout.EAST );

        botonAgregarDisco = new JButton( "Agregar Disco" );
        botonAgregarDisco.setActionCommand( AGREGAR_DISCO );
        botonAgregarDisco.addActionListener( this );
        add( botonAgregarDisco, BorderLayout.SOUTH );

        setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Discos" ) ) );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cambia el disco que se muestra en el panel
     * @param d el nuevo disco a mostrar en el panel
     */
    public void cambiarDisco( Disco d )
    {
        disco = d;
        if( disco != null )
        {
            etiquetaImagen.setIcon( new ImageIcon( disco.darImagen( ) ) );

            txtArtista.setText( disco.darArtista( ) );
            txtGenero.setText( disco.darGenero( ) );
            txtPrecio.setText( Double.toString( disco.darPrecioDisco( ) ) );
        }
        else
        {
            setBorder( new CompoundBorder( new EmptyBorder( 5, 5, 5, 5 ), new TitledBorder( "Detalles del Disco" ) ) );
        }
    }

    /**
     * Actualiza la información en el panel con la lista de discos
     * @param discos la lista de discos a desplegar
     */
    public void refrescarDiscos( ArrayList discos )
    {
        comboDiscos.removeAllItems( );

        for( int i = 0; i < discos.size( ); i++ )
        {
            comboDiscos.addItem( discos.get( i ) );
        }
    }

    /**
     * Ejecuta las acciones asociadas a los eventos
     * @param evento es el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( AGREGAR_DISCO.equals( comando ) )
        {
            principal.mostrarDialogoAgregarDisco( );
        }
        else if( CAMBIAR_DISCO.equals( comando ) )
        {
            String nombreDisco = ( String )comboDiscos.getSelectedItem( );
            principal.cambiarDiscoSeleccionado( nombreDisco );
        }
    }

}

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelCrearDisco.java,v 1.5 2006/08/10 20:08:30 da-romer Exp $
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

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * Es el panel donde se ingresan los datos para un nuevo disco
 */
public class PanelCrearDisco extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * El comando para el botón Explorar
     */
    private static final String EXPLORAR = "Explorar";

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------
    /**
     * Es la etiqueta "Título"
     */
    private JLabel etiquetaTitulo;

    /**
     * Es el campo de texto para ingresar el título del nuevo disco
     */
    private JTextField txtTitulo;

    /**
     * Es la etiqueta "Artista"
     */
    private JLabel etiquetaArtista;

    /**
     * Es el campo de texto para ingresar el artista del nuevo disco
     */
    private JTextField txtArtista;

    /**
     * Es la etiqueta "Género"
     */
    private JLabel etiquetaGenero;

    /**
     * Es el campo de texto para ingresar el género del nuevo disco
     */
    private JTextField txtGenero;

    /**
     * Es la etiqueta "Imagen"
     */
    private JLabel etiquetaImagen;

    /**
     * Es el campo de texto para ingresar la imagen del nuevo disco
     */
    private JTextField txtImagen;

    /**
     * Es el botón usado para buscar la imagen
     */
    private JButton btnExplorar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel creando las etiquetas y los campos de texto necesarios para crear un nuevo disco
     */
    public PanelCrearDisco( )
    {
        setLayout( new GridLayout( 5, 2, 5, 5 ) );

        etiquetaTitulo = new JLabel( "Título: " );
        etiquetaTitulo.setFont( etiquetaTitulo.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaTitulo );

        txtTitulo = new JTextField( 2 );
        add( txtTitulo );

        etiquetaArtista = new JLabel( "Artista: " );
        etiquetaArtista.setFont( etiquetaArtista.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaArtista );

        txtArtista = new JTextField( 2 );
        add( txtArtista );

        etiquetaGenero = new JLabel( "Género: " );
        etiquetaGenero.setFont( etiquetaGenero.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaGenero );

        txtGenero = new JTextField( 2 );
        add( txtGenero );

        etiquetaImagen = new JLabel( "Imagen: " );
        etiquetaImagen.setFont( etiquetaImagen.getFont( ).deriveFont( Font.PLAIN ) );
        add( etiquetaImagen );

        txtImagen = new JTextField( 2 );
        add( txtImagen );

        add( new JLabel( ) );

        btnExplorar = new JButton( "Explorar" );
        btnExplorar.setActionCommand( EXPLORAR );
        btnExplorar.addActionListener( this );
        add( btnExplorar );

        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Da el valor del campo de texto con el título del disco
     * @return El texto con el título
     */
    public String darTitulo( )
    {
        return txtTitulo.getText( );
    }

    /**
     * Da el valor del campo de texto con el artista del disco
     * @return El texto con el artista
     */
    public String darArtista( )
    {
        return txtArtista.getText( );
    }

    /**
     * Da el valor del campo de texto con el género del disco
     * @return El texto con el género
     */
    public String darGenero( )
    {
        return txtGenero.getText( );
    }

    /**
     * Da el valor del campo de texto con la imagen del disco
     * 
     * @return El texto de la imagen
     */
    public String darImagen( )
    {
        return txtImagen.getText( );
    }

    /**
     * Ejecuta una acción cuando se hace click sobre un botón
     * @param evento el evento del click sobre un botón
     */
    public void actionPerformed( ActionEvent evento )
    {
        String comando = evento.getActionCommand( );

        if( EXPLORAR.equals( comando ) )
        {
            JFileChooser fc = new JFileChooser( "./data/imagenes" );
            fc.setDialogTitle( "Imagen del Disco" );
            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                File archivo = fc.getSelectedFile( );
                String strArchivo = archivo.getAbsolutePath( );
                String strCarpetaImagenes = new File( "data/imagenes" ).getAbsolutePath( );

                if( strArchivo.startsWith( strCarpetaImagenes ) )
                {
                    txtImagen.setText( "data/imagenes/" + archivo.getName( ) );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "La imagen debe estar en la carpeta " + strCarpetaImagenes );
                }
            }
        }
    }
}

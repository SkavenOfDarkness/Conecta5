/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import static javax.swing.SwingConstants.RIGHT;

/**
 *
 * @author Lluis
 */
public class Conecta5 extends JFrame implements MouseListener {

    Tablero tablero;
    
    //Inicialización variables menú
    private JMenuBar jmb;
    private JMenu jmInicio;
    private JMenu jmAyuda;
    private JMenuItem jmiJugar, jmiPausa, jmiCancelar, jmiFinalizar;
    
    //Inicialización variables nombres jugadores
    private static final String nombreJugador1 = "Jugador 1";
    private static final String nombreJugador2 = "Jugador 2";
    
    //
    private JLabel nombre1, nombre2;
    
    //Variable que mantiene al jugador actual, true --> jugador 1, false --> jugador 2
    boolean jugador = true;
    
    //Programa principal, llama al constructor del juego y hace visible la ventana
    public static void main(String[] args) {
        Conecta5 juego = new Conecta5();
        juego.setVisible(true);
    }
    
    public Conecta5() {
        setSize((40*15)+300,(40*15)+55);
        setTitle("Conecta 5");      
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        //Asignamos componentes del menú
        jmb = new JMenuBar();
        jmInicio = new JMenu();
        jmAyuda = new JMenu();
        jmiJugar = new JMenuItem();
        jmiPausa = new JMenuItem();
        jmiCancelar = new JMenuItem();
        jmiFinalizar = new JMenuItem();
        
        //Creamos el tableto
        tablero = new Tablero();
        
        //Agregamos el escuchador al tablero para el ratón
        tablero.addMouseListener(this);
        
        //Agregamos objetos al panel
        getContentPane().setLayout(null);
        getContentPane().add(jmb);
        
        //Agregamos funcionalidades al menú
        jmiJugar.setText("Jugar");
        jmiJugar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmiJugarActionPerformed(evt);
            }
        });
        
        jmiPausa.setText("Pausa");
        jmiPausa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmiPausaActionPerformed(evt);
            }   
        });
        
        jmiCancelar.setText("Cancelar");
        jmiCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmiCancelarActionPerformed(evt);
            }   
        });
        
        jmiFinalizar.setText("Finalizar");
        jmiFinalizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                jmiFinalizarActionPerformed(evt);
            }   
        });
        
        //Ponemos nombre a las opciones de la barra de navegación y las agregamos
        jmInicio.setText("Inicio");
        jmInicio.add(jmiJugar);
        jmInicio.add(jmiPausa);
        jmInicio.add(jmiCancelar);
        jmInicio.add(jmiFinalizar);
        jmAyuda.setText("Ayuda");
        jmb.add(jmInicio);
        jmb.add(jmAyuda);
        setJMenuBar(jmb);
    }
    
    private void jmiJugarActionPerformed(ActionEvent evt) {
        getContentPane().add(tablero);
        tablero.setBounds(0, 0, 700, 700);
        nombre1 = new JLabel(nombreJugador1);
        nombre2 = new JLabel(nombreJugador2);
        getContentPane().add(nombre1);
        nombre1.setBounds(650, 0, 100, 50);
        getContentPane().add(nombre2);
        nombre2.setBounds(650, 50, 100, 50);
    }
    
    private void jmiPausaActionPerformed(ActionEvent evt) {
        
    }
    
    private void jmiCancelarActionPerformed(ActionEvent evt) {
        
    }
    
    private void jmiFinalizarActionPerformed(ActionEvent evt) {
        System.exit(0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int i, j;
        //Permite que en caso de que se pulse fuera del tablero no ocurra nada
        if((e.getButton() == MouseEvent.BUTTON1) && (e.getX() < tablero.getMAXIMO()) && (e.getY() < tablero.getMAXIMO())) {
            j = e.getX()/40;
            i = e.getY()/40;
            if (!tablero.empty(i, j)) {
                if(jugador) {
                    tablero.Pon(Pieza.ROJA, i, j);
                    Juego.Logica(tablero, i, j);
                    repaint();
                    jugador = false;
                }
                else {
                    tablero.Pon(Pieza.AZUL, i, j);
                    Juego.Logica(tablero, i, j);
                    repaint();
                    jugador = true;
                }
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

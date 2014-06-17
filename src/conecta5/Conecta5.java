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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
    private static  String nombreJugador1;
    private static  String nombreJugador2;
    public int ContadorFichas  = 0;
    
    
    //JLabel que contine el nombre de los jugadores y la puntuación
    private JLabel nombre1, nombre2, puntuacion, background;
  
    //Variable que mantiene al jugador actual, true --> jugador 1, false --> jugador 2
    private boolean jugador = true;
    //Variuable que permite saber si el juego esta en funcionamiento o no
    private boolean jugando = false;
    
    //Programa principal, llama al constructor del juego y hace visible la ventana
    public static void main(String[] args) {
        Conecta5 juego = new Conecta5();
        juego.setVisible(true);
    }
    
    public Conecta5() {
        setSize((40*15)+300,(40*15)+60);
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
                Sonido.sonido("partida_pausada");
                jmiPausaActionPerformed(evt);
                Sonido.sonido("reanudacion_partida");   
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
        if(!jugando){
            //Creamos el tableto
            tablero = new Tablero();

            //Agregamos el escuchador al tablero para el ratón
            tablero.addMouseListener(this);
            
            //Lista de los nombres para elegir
            String[] listaNombres = { "Javier", "Luis", "Antonio","Jose","Adolfo","Pepe","Jesus"};
            
            //Petición mediante panel del nombre de los usuarios
            nombreJugador1 = (String)JOptionPane.showInputDialog(null, "Seleccione nombre jugador1" , "NOMBRES", JOptionPane.QUESTION_MESSAGE, null, listaNombres, listaNombres[0]);
            nombreJugador2 = (String)JOptionPane.showInputDialog(null, "Seleccione nombre jugador2" , "NOMBRES", JOptionPane.QUESTION_MESSAGE, null, listaNombres, listaNombres[0]);
            
            //Comprobacion en caso de pulsar cancelar
            if(nombreJugador1==null){
                nombreJugador1= "Jugador 1";
            }
            if(nombreJugador2==null){
                nombreJugador2= "Jugador 2";
            }
            
            //Necesario para pintar los componentes de nombre
            repaint();
           

            
            getContentPane().add(tablero);
            tablero.setBounds(0, 0, 700, 700);
            //añadir fotos de las ficha de cada jugador          
            nombre1 = new JLabel(nombreJugador1);
            nombre2 = new JLabel(nombreJugador2);
            puntuacion = new JLabel ("Movimientos: "+Integer.toString(ContadorFichas));
            nombre1.setIcon(new ImageIcon(Pieza.BLANCA));
            nombre2.setIcon(new ImageIcon(Pieza.NEGRA));

            getContentPane().add(nombre1);
            nombre1.setBounds(650, 0, 150, 50);
            getContentPane().add(nombre2);
            nombre2.setBounds(650, 50, 150, 50);
            getContentPane().add(puntuacion);
            puntuacion.setBounds(650, 100, 100, 50);
            
            background = new JLabel(); 
            background.setIcon(new ImageIcon("img/background.png"));
            getContentPane().add(background);
            background.setBounds(0, 0, 600, 600);
            
            //Variable que se encarga de saber si estamos jugando o no
            jugando = true;
        }
    }
    
    private void jmiPausaActionPerformed(ActionEvent evt) {
        if(jugando) {              
            JOptionPane.showMessageDialog(null, "Pulse aceptar para seguir jugando", "PAUSA", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void jmiCancelarActionPerformed(ActionEvent evt) {
        if(jugando) {
            /*La opcion YES_NO_OPTION devuelve:
                                            0 al pulsar si
                                            1 al pulsar no
                                            -1 al pulsar la curz*/
            int opcion = JOptionPane.showConfirmDialog(null, "Desea cancelar la partida?", "Cancelando", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opcion == 0) {
                Sonido.sonido("partida_cancelada");
                limpiarTablero();
            }
        }
    }
    
    private void jmiFinalizarActionPerformed(ActionEvent evt) {      
        try {
            Sonido.sonido("finalizar");
            //Sistema de pausa para la reproduccion de sonido antes de cerrar el programa
            Thread.sleep(4000);
            System.exit(0);
        } catch (InterruptedException ex) {
            Logger.getLogger(Conecta5.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    tablero.Pon(Pieza.BLANCA, i, j);
                    tablero.getT(i, j).setColor("BLANCA");
                    jugador = false;
                    ContadorFichas++;
                    puntuacion.setText("Movimientos: "+Integer.toString(ContadorFichas));
                    repaint();
                    //Nos ha de devolver un true o un false
                    if(Juego.Logica(tablero, i, j)) {
                        System.out.println("nombre ganador: " + nombreJugador1);                     
                        Sonido.sonido(nombreJugador1);
                        JOptionPane.showMessageDialog(null,nombreJugador1 + " ha ganado", "WINNER", JOptionPane.INFORMATION_MESSAGE);
                        limpiarTablero();
                    } 
                    
                }
                else {
                    tablero.Pon(Pieza.NEGRA, i, j);
                    tablero.getT(i, j).setColor("NEGRA");
                    jugador = true;
                    ContadorFichas++;
                    puntuacion.setText("Movimientos: "+Integer.toString(ContadorFichas));
                    repaint();
                    //Nos ha de devolver un true o un false
                    if(Juego.Logica(tablero, i, j)) {
                        System.out.println("nombre ganador: " +nombreJugador2);
                        Sonido.sonido(nombreJugador2);
                        JOptionPane.showMessageDialog(null,nombreJugador2 +  " ha ganado", "WINNER", JOptionPane.INFORMATION_MESSAGE);
                        limpiarTablero();
                    }
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
    
    public void limpiarTablero(){
                getContentPane().remove(nombre1);
                getContentPane().remove(nombre2);
                getContentPane().remove(puntuacion);
                getContentPane().remove(background);
                getContentPane().remove(tablero);
                getContentPane().revalidate();
                getContentPane().repaint();
                ContadorFichas = 0;
                jugador = true;
                jugando = false;
    }
    
}

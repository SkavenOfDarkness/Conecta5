/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

/**
 *
 * @author Lluis
 */
public class Conecta5 extends JFrame implements MouseListener {

    Tablero tablero;
    //Variable que mantiene al jugador actual, true --> jugador 1, false --> jugador 2
    boolean jugador = true;
    
    //Programa principal, llama al constructor del juego y hace visible la ventana
    public static void main(String[] args) {
        Conecta5 juego = new Conecta5();
        juego.setVisible(true);
    }
    
    public Conecta5() {
        super("Conecta 5");
        initComponents();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        tablero = new Tablero();
//        tablero.Pon(Pieza.ROJA, 0, 0);
//        tablero.Pon(Pieza.AZUL, 1, 0);
        tablero.addMouseListener(this);
        this.getContentPane().add(tablero);
        this.setSize(tablero.getPreferredSize());
        this.pack();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int x = 0, y = 0;
        Component comp = null;
        if(e.getButton() == MouseEvent.BUTTON1) {
            x = e.getX()/54;
            y = e.getY()/54;
            comp = e.getComponent();
            if(jugador) {
                tablero.Pon(Pieza.ROJA, y, x);
                repaint();
                jugador = false;
            }
            else {
                tablero.Pon(Pieza.AZUL, y, x);
                repaint();
                jugador = true;
            }
        }
//        System.out.println("X: " + x + " | Y: " + y + "         " + comp);
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

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
        int i, j;
        
        if((e.getButton() == MouseEvent.BUTTON1) && (e.getX() < tablero.getMAXIMO()) && (e.getY() < tablero.getMAXIMO())) {
            j = e.getX()/40;
            i = e.getY()/40;
            if (!tablero.empty(i, j)) {
                if(jugador) {
                    tablero.Pon(Pieza.ROJA, i, j);
                    repaint();
                    jugador = false;
                }
                else {
                    tablero.Pon(Pieza.AZUL, i, j);
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

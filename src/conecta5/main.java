/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import javax.swing.JFrame;

/**
 *
 * @author Lluis
 */
public class main extends JFrame {

    /**
     * @param args the command line arguments
     */
    Tablero tablero;
    
    public main() {
        super("Conecta 5");
        tablero = new Tablero();
        tablero.Pon(Pieza.ROJA, 0, 0);
        tablero.Pon(Pieza.ROJA, 0, 1);
        tablero.Pon(Pieza.ROJA, 0, 2);
        tablero.Pon(Pieza.AZUL, 0, 3);
        tablero.Pon(Pieza.AZUL, 1, 0);
        this.getContentPane().add(tablero);
        this.setSize(tablero.getPreferredSize());
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {
        main c5 = new main();
        c5.setVisible(true);
    }
    
}

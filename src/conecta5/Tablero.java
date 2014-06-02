/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author skaven
 */
public class Tablero extends JPanel { 
    private static final int TAMANO = 15;
    private static final int MAXIMO = 40*15;
    private static final int LADO = MAXIMO / TAMANO;
    private final Casilla t[][];
    
    public Tablero() {
        t = new Casilla[TAMANO][TAMANO];
        int y = 0;
        for (int i = 0; i < TAMANO; i++) {
            int x = 0;
            for (int j = 0; j < TAMANO; j++) {
                Rectangle2D.Float r = new Rectangle2D.Float(x, y, LADO, LADO);
                t[i][j] = new Casilla(r);
                x += LADO;
            }
            y += LADO;
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (int i = 0; i < TAMANO; i++) {
            for (int j = 0; j < TAMANO; j++) {                
                t[i][j].paintComponent(g);
            }
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(MAXIMO, MAXIMO);
    }

    void Pon(String s, int i, int j) {
        t[i][j].setPieza(new Pieza(s));
    }

    public boolean empty(int i, int j) {
        return t[i][j].isOcupada();
    } 

    /**
     *
     * @return
     */
    public int getMAXIMO() {
        return MAXIMO;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author skaven
 */
public class Casilla {
    private Rectangle2D.Float cas;
    private Boolean ocupada;
    private Pieza pieza;
    
    public Casilla(Rectangle2D.Float c) {
        this.cas = c;
        this.ocupada = false;
        this.pieza = null;
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.draw(this.cas);
        if(this.ocupada) {
            this.pieza.paintComponent(g, this.cas.x, this.cas.y);
        }
    }
    
    void setPieza(Pieza p) {
        this.ocupada = true;
        this.pieza = p;
    }

    public Boolean isOcupada() {
        return ocupada;
    }
}

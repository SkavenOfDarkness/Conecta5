/*
 * Clase casilla 
 */

package conecta5;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Casilla {
    private final Rectangle2D.Float cas;
    private Boolean ocupada;
    private Pieza pieza;
    private String color;
    
    public Casilla(Rectangle2D.Float c) {
        this.cas = c;
        this.ocupada = false;
        this.pieza = null;
        this.color = null;
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

    public void setColor(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
     @Override
    public String toString() {
        return "Casilla{" + "cas=" + cas + ", ocupada=" + ocupada + ", pieza=" + pieza + ", color=" + color + '}';
    }
}

/*
 * Clase pieza
 */

package conecta5;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

class Pieza {
    // Declaracion de las imagenes 
    public static final String BLANCA = "img/blanca.png";
    public static final String NEGRA = "img/negro.png";    
    private BufferedImage img;
    
    public Pieza(String s) {
        try {
            img = ImageIO.read(new File(s));
        } catch (IOException ex) {
            Logger.getLogger(Pieza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void paintComponent(Graphics g, float x, float y) {
        g.drawImage(img, (int)x, (int)y, null);
    }
}

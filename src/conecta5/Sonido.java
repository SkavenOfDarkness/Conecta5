/*
 * Clase sonido
 */
package conecta5;

import java.applet.Applet;
import java.applet.AudioClip;

public class Sonido {
    //Metodo de reproducción de sonido segun parametro.
    public static  void sonido(String args){
        //Descomentar para evaluar en consola el archivo que se reproduce
        //System.out.println("sonidos/"+args+".wav");
        AudioClip archivo = Applet.newAudioClip(Sonido.class.getResource("sonidos/"+args+".wav"));
        try{
            archivo.play();
        }
        catch(Exception ex){
            System.err.println( ex.getMessage() );
        }
    }   
}

    


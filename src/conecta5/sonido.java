/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta5;

import java.applet.Applet;
import java.applet.AudioClip;


/**
 *
 * @author Javier
 */
public class sonido {
   //pasarlo a la funcion de abajo 
    public static final AudioClip Sfinalizar = Applet.newAudioClip(sonido.class.getResource("sonidos/finalizar.wav"));
    public static final AudioClip Spausar = Applet.newAudioClip(sonido.class.getResource("sonidos/partida_pausada.wav"));
    public static final AudioClip Scancelar = Applet.newAudioClip(sonido.class.getResource("sonidos/partida_cancelada.wav"));
    public static final AudioClip Sreanudar = Applet.newAudioClip(sonido.class.getResource("sonidos/reanudacion_partida.wav"));
    //public static final AudioClip SGanador = Applet.newAudioClip(sonido.class.getResource("sonidos/ganador.wav"));
    //private static Clip clip;

    public static  void sonido(String args){
      System.out.println("sonidos/"+args+".wav");
      AudioClip archivo = Applet.newAudioClip(sonido.class.getResource("sonidos/"+args+".wav"));
        try{
            /* clip=AudioSystem.getClip();
             clip.open(localizar.);
             clip.start();*/
            archivo.play();

           }
           catch(Exception ex){
                System.err.println( ex.getMessage() );
           }
        }   
    //FIN DE CODIGO PARA EJECUTAR POR PARAMETROS EL FICHERO DESEHADO
    }

    


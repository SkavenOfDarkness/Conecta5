/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conecta5;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

/**
 *
 * @author Javier
 */
public class sonido {
   
    public static final AudioClip Sfinalizar = Applet.newAudioClip(sonido.class.getResource("sonidos/finalizar.wav"));
    public static final AudioClip Spausar = Applet.newAudioClip(sonido.class.getResource("sonidos/partida_pausada.wav"));
    public static final AudioClip Scancelar = Applet.newAudioClip(sonido.class.getResource("sonidos/partida_cancelada.wav"));
    public static final AudioClip Sreanudar = Applet.newAudioClip(sonido.class.getResource("sonidos/reanudacion_partida.wav"));
    public static final AudioClip SGanador = Applet.newAudioClip(sonido.class.getResource("sonidos/ganador.wav"));
    
    public static final AudioClip Sadolfo = Applet.newAudioClip(sonido.class.getResource("sonidos/reanudacion_partida.wav"));
    public static final AudioClip Santonio = Applet.newAudioClip(sonido.class.getResource("sonidos/reanudacion_partida.wav"));
    public static final AudioClip Sjavier = Applet.newAudioClip(sonido.class.getResource("sonidos/reanudacion_partida.wav"));
    public static final AudioClip Sjesus = Applet.newAudioClip(sonido.class.getResource("sonidos/reanudacion_partida.wav"));
    public static final AudioClip Sjose = Applet.newAudioClip(sonido.class.getResource("sonidos/reanudacion_partida.wav"));
    public static final AudioClip Sluis = Applet.newAudioClip(sonido.class.getResource("sonidos/reanudacion_partida.wav"));
    public static final AudioClip Spepe = Applet.newAudioClip(sonido.class.getResource("sonidos/reanudacion_partida.wav"));
 
    
    //CODIGO PARA EJECUTAR POR PARAMETRO EL FICHERO DESEHADO
    
    private static Clip clip;
    //paquete donde se encuentran los archivos de sonido WAV
    private static final String path="sonidos/";
 
    public  void sonido(String args){
      InputStream localizar = getClass().getResourceAsStream( path +  args +".wav" );
        try{
                clip=AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(localizar) );
                clip.start();
           }
           catch(Exception ex){
                System.err.println( ex.getMessage() );
           }
        }
    //FIN DE CODIGO PARA EJECUTAR POR PARAMETROS EL FICHERO DESEHADO
    }

    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Javier
 */
public class GanadorInOut {
    //private static final int TAMANOOBJ = (29 * 2) + (9 * 2) + 4; //Fecha + Nombre + Puntuacion
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private RandomAccessFile f;
    Ganador g = new Ganador();
    //private final String nombre = "PUNTUACIONES.dat";
    //File arxiu = new File(nombre);
    
    public GanadorInOut(String nombre){
        try {
            f = new RandomAccessFile(nombre, "rw");
            
//        try {
//            
//            f = new RandomAccessFile(arxiu, "rw");
//            f.close();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
//        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Escribir(Ganador g){
        try {           
            f.seek(f.length());
            //f = new RandomAccessFile(arxiu, "rw");
            //writeSring(g.getFecha().toString());
            System.out.println(g.getPuntuacion());
            int p = g.getPuntuacion();
            f.writeChars(Integer.toString(p));
            f.writeChars(g.getFecha().toString());
            f.writeChars(g.getNombre());

            //f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    public String Lectura(){
        String Resultado, fecha = "", nom = "";
            int puntuacion = 0;
        try {
            f = new RandomAccessFile(arxiu, "r");
            long numreg = f.length() / TAMANOOBJ;
            for (int i = 0; i < numreg; i++) {
                for (int j = 1; j < (29 * 2); j++) {
                    fecha = fecha + f.readChar();
                }
                for (int j = 1; j < (9 * 2); j++) {
                    nom = nom + f.readChar();
                }
                puntuacion = f.readInt();
            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        Resultado = nom + " - " + puntuacion;
        return Resultado;
    } 

    private void writeSring(String str, int dmi) {
        try {
            StringBuilder buffer = new StringBuilder();
            if(str!=null){
                buffer.append(str);
            }
            buffer.setLength(dmi);
            f.writeChars(buffer.toString());
        } catch (IOException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void close() throws Exception{
        f.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Javier
 */
public class FixeroGanadores {
    private static final int TAMANOOBJ = (29 * 2) + (9 * 2) + 4; //Fecha + Nombre + Puntuacion
    private RandomAccessFile f;
    private String nombre = "PUNTUACIONES.dat";
    
    public FixeroGanadores(){
        try {
            File arxiu = new File(nombre);
            f = new RandomAccessFile(arxiu, "rw");
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FixeroGanadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FixeroGanadores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Escribir(Ganador g){
        try {
            File arxiu = new File(nombre);
            f = new RandomAccessFile(arxiu, "rw");
            f.writeChars(g.getFecha().toString());
            f.writeChars(g.getNombre());
            f.writeInt(g.getPuntuacion());
            f.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FixeroGanadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FixeroGanadores.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public String Lectura(){
        String Resultado, fecha = "", nom = "";
            int puntuacion = 0;
        try {
            File arxiu = new File(nombre);
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
            Logger.getLogger(FixeroGanadores.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FixeroGanadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        Resultado = nom + " - " + puntuacion;
        return Resultado;
    } 
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import java.io.BufferedReader;
import java.io.File;

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
    // public static final int DIM = 3 + (9 * 2)+ (29 * 2); //Puntuacion + Nombre + Fecha
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    private RandomAccessFile f;
    Ganador g = new Ganador();
    public int posicion;
    //private final String nombre = "PUNTUACIONES.dat";

    
    public GanadorInOut(String nombre){
        try {
            f = new RandomAccessFile(nombre, "rw");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void Escribir(Ganador g){
        try {           
            f.seek(f.length());
            System.out.println(g.getPuntuacion());
            f.writeChars(g.getPuntuacion());
            f.writeChars(g.getNombre());
            f.writeChars(g.getFecha());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    public String Lectura(){
        String puntu, nom, fe, result = "";
        try {
            puntu = readString(3);
            result = puntu;
            f.close();
        } catch (IOException ex) {
            result = "No hay records";
        }
        return result;
    }
    
    private String readString(int dim) {
        char campo[] = new char[dim];
        for (int i = 0; i < dim; i++) {
            try {
                campo[i] = f.readChar();
            } catch (IOException ex) {
                
            }
        }
        return new String(campo).replace('\0', ' ');
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
    
    public void ordena() {
        try {
            long numreg = f.length() / Ganador.DIM;
            String Puntu,Nom,Fecha;
            Ganador gMin, p;
            int jmin;
            for (int i = 0; i < numreg - 1; i++) {
                f.seek(i * Ganador.DIM);
                Puntu = readString(3);
                Nom = readString(9);
                Fecha = readString(29);
                gMin = new Ganador(Puntu, Nom, Fecha);
                jmin = i;
                for (int j = i + 1; j < numreg; j++) {
                    f.seek(j * Ganador.DIM);
                    Puntu = readString(3);
                    Nom = readString(9);
                    Fecha = readString(29);
                    p = new Ganador(Puntu, Nom, Fecha);
                    if (p.menor(gMin)) {
                        gMin = p;
                        jmin = j;
                    }
                }
                f.seek(i * Ganador.DIM);
                Puntu = readString(3);
                Nom = readString(9);
                Fecha = readString(29);
                p = new Ganador(Puntu, Nom, Fecha);
                f.seek(i * Ganador.DIM);
                writeSring(gMin.Puntuacion, 3);
                writeSring(gMin.Nombre, 9);
                writeSring(gMin.fecha, 29);
                f.seek(jmin * Ganador.DIM);
                writeSring(p.Puntuacion, 3);
                writeSring(p.Nombre, 9);
                writeSring(p.fecha, 29);
            }
            
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    
    public void posicion(Ganador g) {
        try {
            long numreg = f.length() / Ganador.DIM;
            String p, n, fe;
            f.seek(0);
            for (int i = 0; i < numreg; i++) {
                p = readString(3);
                n = readString(9);
                fe = readString(29);
                if(fe.equals(g.fecha)) {
                    posicion = i;
                }
            }
            f.close();
        } catch (IOException ex) {
            Logger.getLogger(GanadorInOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

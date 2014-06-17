/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package conecta5;

import java.util.Date;

/**
 *
 * @author Javier
 */
public class Ganador {
    private Date fecha;
    private String Nombre;
    private int Puntuacion;
    
    public Ganador(){
    }
    
    public Ganador(String n, int p){
        fecha = new Date();
        if(n.length() < 9) {
            for (int i = n.length(); i < 10; i++) {
                n = n + " ";
            }
            Nombre = n;
        }
        else {
            Nombre = n;
        }
        Puntuacion = p;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getPuntuacion() {
        return Puntuacion;
    }
}

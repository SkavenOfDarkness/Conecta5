/*
 * Clase Ganador genera el objeto Ganador 
 */

package conecta5;

import java.util.Date;

public class Ganador {
    public String fecha;
    public String Nombre, pp;
    public String Puntuacion;
    public static final int DIM = (3 * 2) + (9 * 2)+ (29 * 2); //Puntuacion + Nombre + Fecha
    
    public Ganador(){
    }
    
    public Ganador(String n, int p){
        fecha = new Date().toString();
        if(n.length() < 9) {
            for (int i = n.length(); i < 9; i++) {
                n = n + " ";
            }
            Nombre = n;
        }
        else {
            Nombre = n;
        }
        pp = Integer.toString(p);
        if(pp.length() < 3) {
            for (int i = pp.length(); i < 3; i++) {
                pp = "0" + pp;
            }
            Puntuacion = pp;
        }
        else {
            Puntuacion = pp;
        }
    }

    public Ganador(String p, String nom, String fecha) {
        this.Puntuacion = p;
        this.Nombre = nom;
        this.fecha = fecha;
    }
    
    public String getFecha() {
        return fecha;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getPuntuacion() {
        return Puntuacion;
    }
    
    boolean menor(Ganador p) {
        return Integer.parseInt(this.Puntuacion) < Integer.parseInt(p.Puntuacion);
    }
}



package conecta5;

/**
 *
 * @author Javier & Luis
 */
public class Juego {
//public static Casilla table[][] = new Casilla[15][15];
    public static int ContadorAzul = 0, ContadorRojo = 0, GlobalContadorV = 0, GlobalContadorH = 0;
    
    
    public static void Logica(Tablero ta, int i, int j){     
        //Limpia pantalla
        for (int k = 0; k < 5; k++) {
            System.out.println("");
        } 
        //Fin limpieza pantalla
        
        String colorActual = ta.getT(i, j).getColor();  
        
        //vertical comprobación
            for (int ii = 0; ii < 15; ii++) {                  
                System.err.println("i " +ii + " j " +j + " field color "+ ta.getT(ii, j).getColor());
                if((ta.getT(ii, j).getColor() == null) ||  !(colorActual.equalsIgnoreCase(ta.getT(ii, j).getColor()))){
                   GlobalContadorV = 0;
                }
                else if (colorActual.equalsIgnoreCase(ta.getT(ii, j).getColor())){
                   GlobalContadorV++;
                   System.err.println("Contador Global suma (Vertical): " +GlobalContadorV);                   
                }
            }
        //Fin comprobacion vertical 
            
        //horizontal comprobación
            for(int jj = 0; jj < 15; jj++){
                System.err. println("i " + i + " j " + jj + " field color "+ ta.getT(i, jj).getColor());
                if ((ta.getT(i,jj).getColor() == null) || !(colorActual.equalsIgnoreCase(ta.getT(i, jj).getColor()))){
                    GlobalContadorH = 0;
                }
                else if (colorActual.equalsIgnoreCase(ta.getT(i, jj).getColor())){
                    GlobalContadorH++;
                    System.err.println("Contador Global suma (Horizontal): " +GlobalContadorH);
                }
            }
        //Fin comprobacion  horizontal
            
            // i columna y j fila
        //DiagonalI-D
            
            //FALLO EN COMBPROBACION EN LAS ULTIMAS FILAS
            int ii = i, jj = j;
            //Ir a punto de inicio de busqueda de la diagonal
            while(ii > 0 && jj > 0){
                ii--;
                jj--;
            };
            //Recorrido diagonal desde punto de anicio.
            if (ii == 0){
                //Recorremos mirando el limite del array
                for (int k = 0; k < 15-j; k++) {
                    if ((ta.getT(ii,jj).getColor() == null) || !(colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor()))){
                        GlobalContadorH = 0;
                    }
                    else if (colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor())){
                        GlobalContadorH++;
                        System.err.println("Contador Global suma (Diagonal): " +GlobalContadorH);
                    }
                    ii++;
                    jj++;
                    
                }
            }
            else if (jj == 0){
                //Recorremos mirando el limite del array
                for (int f = 0; f < 15-i; f++) {
                  if ((ta.getT(ii,jj).getColor() == null) || !(colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor()))){
                        GlobalContadorH = 0;
                    }
                    else if (colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor())){
                        GlobalContadorH++;
                        System.err.println("Contador Global suma (Diasgonal): " +GlobalContadorH);
                    }
                    ii++;
                    jj++;  
                }
            };
            
           
        
        //Fin DiagonalI-D
            
        //DiagonalD-I
        //Fin DiagonaD-I
            
            
            
   }
}
    




/*
 * Clase para la aplicación de la lógica del juego
 */

package conecta5;

public class Juego {
    private static int Contador5 = 0;
    public static boolean Logica(Tablero ta, int i, int j){     
        //Limpia pantalla (Utilizar en caso de DEBUG y descomentar todos los prints)
//        for (int k = 0; k < 5; k++) {
//            System.out.println("");
//        } 
        //Fin limpieza pantalla
        // i columna y j fila
        String colorActual = ta.getT(i, j).getColor();  
        //////////////////////////
        //vertical comprobación//
        /////////////////////////
        Contador5 = 0;
        //Utilizamos como referencia la columna y recorrido la fila
        for (int ii = 0; ii < 15; ii++) {                  
//                System.err.println("i " +ii + " j " +j + " field color "+ ta.getT(ii, j).getColor());
            if((ta.getT(ii, j).getColor() == null) ||  !(colorActual.equalsIgnoreCase(ta.getT(ii, j).getColor()))){
               Contador5 = 0;
            }
            else if (colorActual.equalsIgnoreCase(ta.getT(ii, j).getColor())){
               Contador5++;
//                   System.err.println("Contador Global suma (Vertical): " +Contador5);
               if(Contador5 == 5) {
                   return true;
               }
            }
        }
        //Fin comprobacion vertical 

        ////////////////////////////
        //horizontal comprobación//
        ///////////////////////////
        Contador5 = 0;
        //Utilizamos como referencia la fila y recorrido la columna
        for(int jj = 0; jj < 15; jj++){
//                System.err. println("i " + i + " j " + jj + " field color "+ ta.getT(i, jj).getColor());
            if ((ta.getT(i,jj).getColor() == null) || !(colorActual.equalsIgnoreCase(ta.getT(i, jj).getColor()))){
                Contador5 = 0;
            }
            else if (colorActual.equalsIgnoreCase(ta.getT(i, jj).getColor())){
                Contador5++;
//                    System.err.println("Contador Global suma (Horizontal): " +Contador5);
                if(Contador5 == 5) {
                   return true;
               }
            }
        }
        //Fin comprobacion  horizontal

        ////////////////
        //Diagonal I-D//       
        ///////////////
        int ii = i, jj = j;
        //Ir a punto de inicio de busqueda de la diagonal I-D
        while(ii > 0 && jj > 0){
            ii--;
            jj--;               
        }
        //Recorrido diagonal desde punto de inicio.
        //Diagonal inferior
        if (ii == 0){
            Contador5 = 0;
            //Varialble para delimitar recorrido
            int delimitanteJ=jj;
            //Recorremos mirando el limite del array
            for (int k = 0; k < 15-delimitanteJ; k++,ii++,jj++) {
                //Comprobación que el color sea null o diferente del de ese momento.
                if ((ta.getT(ii,jj).getColor() == null) || !(colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor()))){
                    Contador5 = 0;
                }
                //Comprobación que el color concuerda con el de ese momento
                else if (colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor())){
                    Contador5++;
//                        System.err.println("Contador Global suma (Diagonal I-D): " +Contador5);
                    if(Contador5 == 5) {
                        return true;
                    }
                } 
            }
        }
        //Diagonal superior
        else if (jj == 0){
            Contador5 = 0;
            int delimitanteI=ii;
            //Recorremos mirando el limite del array
            //Se recorre quitando la fila
            for (int f = 0; f < 15-delimitanteI; f++,ii++,jj++) {
                if ((ta.getT(ii,jj).getColor() == null) || !(colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor()))){
                    Contador5 = 0;
                }
                else if (colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor())){
                    Contador5++;
//                        System.err.println("Contador Global suma (Diasgonal I-D): " +Contador5);
                    if(Contador5 == 5) {
                        return true;
                    }
                }
            }
        }  
        //Fin DiagonalI-D

        ////////////////
        //DiagonalD-I//
        ///////////////
        ii = i;
        jj = j;
        //Ir a punto de inicio de busqueda de la diagonal D-I
        while(ii < 14 && jj > 0){
           ii++;
           jj--;               
        }

        //Recorrido diagonal desde punto de inicio.
        //Diagonal inferior
        if (ii == 14){
            Contador5 = 0;
            //Varialble para delimitar recorrido
            int delimitanteJ=jj;
            //Recorremos mirando el limite del array
            for (int k = 0; k < 15-delimitanteJ; k++,ii--,jj++) {
                //Comprobación que el color sea null o diferente del de ese momento.
                if ((ta.getT(ii,jj).getColor() == null) || !(colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor()))){
                    Contador5 = 0;
//                        System.out.println("Contador Global se reseta a 0 (Diagonal D-I)" + Contador5);
                }
                //Comprobación que el color concuerda con el de ese momento
                else if (colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor())){
                    Contador5++;
//                        System.err.println("Contador Global suma (Diagonal D-I): " +Contador5);
                    if(Contador5 == 5) {
                        return true;
                    }
                } 
            }
        }
        //Diagonal auperior
        else if (jj == 0){
            Contador5 = 0;
            int delimitanteI=ii;
            //Recorremos mirando el limite del array
            //Se recorre quitando la fila
            for (int f = 0; f <= delimitanteI; f++,ii--,jj++) {
                if ((ta.getT(ii,jj).getColor() == null) || !(colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor()))){
                    Contador5 = 0;
//                        System.out.println("Contador Global se reseta a 0 (Diagonal D-I)"+ Contador5);
                }
                else if (colorActual.equalsIgnoreCase(ta.getT(ii, jj).getColor())){
                    Contador5++;
//                       System.err.println("Contador Global suma (Diasgonal D-I): " +Contador5);
                   if(Contador5 == 5) {
                        return true;
                    }
                }
            }
        }   
        //Fin DiagonaD-I
        //En caso de no encontrar cinco fichas seguidas devuelve un false
        return false;
   }
}
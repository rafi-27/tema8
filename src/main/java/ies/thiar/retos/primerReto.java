package ies.thiar.retos;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class primerReto {

    private int[][] tablero;

    public static void main(String[] args) {
        crearTablero(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));

        
    }


    /**
     * Funcion crearTablero(int alto, int ancho, int minas)
     */

     private static void crearTablero(int alto, int ancho, int cantidadMinas){
        if (alto<0 || ancho<0) {
            System.err.println("Error alto o ancho incorrecto.");
        }
        if (cantidadMinas<0) {
            System.err.println("cantidad incorrecta de minas.");
        }
        //Crea una matriz de alto por ancho y.
        int[][] matriz = new int[alto][ancho];
        //coloca aleatoriamente el numero de minas una mina se representa con un -1 las demas 0
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                    if (cantidadMinas != 0) {
                    int posicion = ThreadLocalRandom.current().nextInt(0,2);
                    if (posicion == 1) {
                        matriz[i][j]=-1;   
                    }
                    }
                    cantidadMinas--;
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+"     ");
            }
            System.out.println();
        }
     }
}

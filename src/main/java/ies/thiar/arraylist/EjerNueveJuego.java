package ies.thiar.arraylist;

import java.util.ArrayList;

public class EjerNueveJuego {
    //Reglas del juegos
    /**
     * 0 – casilla vacía
     * 1 – casilla ocupada por un bloque de color rojo
     * 2 – casilla ocupada por un bloque de color verde
     * 3 – casilla ocupada por un bloque de color azul
     */

    public static void main(String[] args) {
        //Ejecuto: 8*5
        int[][] tableroDos = new int[8][5];
        //tableroDos = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,3},{0,2,2,0,3},{2,2,1,1,3},{0,3,2,2,1},{1,3,2,2,1},{3,3,1,2,1}};
        int[][] tablero={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,3},{0,2,2,0,3},{2,2,1,1,3},{0,3,2,2,1},{1,3,2,2,1},{3,3,1,2,1}};
        lineas(tablero);
    }




     public static ArrayList<Integer>lineas(int[][] matriz){
        /**
         * Implementa el método lineas que recibe como parámetro una matriz de números
         * enteros que representa el tablero de un juego y retorna como resultado un ArrayList con las filas donde se haya producido una “línea”.
         * Cada elemento de la matriz del tablero tendrá un número entero que representa si es
         * está ocupada por un bloque o no.
         */

        ArrayList<Integer>nueva=new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[0][i]!=0) {
                //nums+=matriz[0][i];
                nueva.add(i);
            }
        }
        return nueva;
     }
}

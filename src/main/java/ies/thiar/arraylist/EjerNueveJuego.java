package ies.thiar.arraylist;

import java.util.ArrayList;

public class EjerNueveJuego {
    // Reglas del juegos
    /**
     * 0 – casilla vacía
     * 1 – casilla ocupada por un bloque de color rojo
     * 2 – casilla ocupada por un bloque de color verde
     * 3 – casilla ocupada por un bloque de color azul
     */

    public static void main(String[] args) {
        // Ejecuto: 8*5
        int[][] tablero = { { 2, 2, 3, 1, 2 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 3 }, { 0, 2, 2, 0, 3 },
                { 2, 2, 1, 1, 3 }, { 0, 3, 2, 2, 1 }, { 1, 3, 2, 2, 1 }, { 3, 3, 1, 2, 1 } };
        System.out.println(lineas(tablero));
    }

    public static ArrayList<Integer> lineas(int[][] matriz) {
        /**
         * Implementa el método lineas que recibe como parámetro una matriz de números
         * enteros que representa el tablero de un juego y retorna como resultado un
         * ArrayList con las filas donde se haya producido una “línea”.
         * Cada elemento de la matriz del tablero tendrá un número entero que representa
         * si es
         * está ocupada por un bloque o no.
         */

        ArrayList<Integer> nueva = new ArrayList<>();
        for (int i = 0; i < matriz.length; i++) {
            boolean siHayMayor = true;
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == 0) {
                    siHayMayor=false;
                    break;
                }
            }
            if (siHayMayor) {
                nueva.add(i+1);
            }
        }
        return nueva;
    }
}
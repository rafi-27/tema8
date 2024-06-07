package ies.thiar.pruebas;

import java.util.concurrent.ThreadLocalRandom;

public class EjerPosible {
    public static void main(String[] args) {
        int alto = 5;
        int ancho = 5;

        int[][] matriz = new int[alto][ancho];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j] = ThreadLocalRandom.current().nextInt(1, 101);
            }
        }

        // for (int i = 0; i < matriz.length; i++) {
        // for (int j = 0; j < matriz[0].length; j++) {
        // System.out.printf("%5d",matriz[i][j]);
        // }
        // System.out.println(" x");
        // }

        int maximoUno = -999999;
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            maximoUno=-99999;
            for (int j = 0; j < matriz[0].length; j++) {
                suma += matriz[i][j];
                if (matriz[i][j]>maximoUno) {
                    maximoUno=matriz[i][j];
                }
                System.out.printf("%5d", matriz[i][j]);
            }
            //System.out.println(" " + suma);
            System.out.println(" " + maximoUno);
        }

        int maximoDos = -999999;
        for (int i = 0; i < matriz.length; i++) {
            int suma = 0;
            maximoDos=-99999;
            for (int j = 0; j < matriz[0].length; j++) {
                suma += matriz[j][i];
                if (matriz[j][i]>maximoDos) {
                    maximoDos=matriz[j][i];
                }
                //System.out.printf("%5d", matriz[i][j]);
            }
            //System.out.printf("%5d", suma);
            System.out.printf("%5d",maximoDos);
        }

    }
}

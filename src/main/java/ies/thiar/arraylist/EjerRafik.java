package ies.thiar.arraylist;

import java.util.concurrent.ThreadLocalRandom;

public class EjerRafik {
    public static void main(String[] args) {

        int[][] tresEnRaya = new int[3][3];

        for (int i = 0; i < tresEnRaya.length; i++) {
            for (int j = 0; j < tresEnRaya[0].length; j++) {
                tresEnRaya[i][j] = ThreadLocalRandom.current().nextInt(0, 2);
            }
        }

        // Creamos los contadores:
        int lineasCeros = 0;
        int lineasUno = 0;
        for (int i = 0; i < tresEnRaya.length; i++) {
            if (tresEnRaya[i][0] == 0 && tresEnRaya[i][1] == 0 && tresEnRaya[i][2] == 0) {
                lineasCeros++;
            }
            if (tresEnRaya[i][0] == 1 && tresEnRaya[i][1] == 1 && tresEnRaya[i][2] == 1) {
                lineasUno++;
            }
        }
        for (int j = 0; j < tresEnRaya[0].length; j++) {
            if (tresEnRaya[0][j] == 0 && tresEnRaya[1][j] == 0 && tresEnRaya[2][j] == 0) {
                lineasCeros++;
            }
            if (tresEnRaya[0][j] == 1 && tresEnRaya[1][j] == 1 && tresEnRaya[2][j] == 1) {
                lineasUno++;
            }
        }
        //Diagonal:
        if (tresEnRaya[0][0] == 0 && tresEnRaya[1][1] == 0 && tresEnRaya[2][2] == 0) {
            lineasCeros++;
        }
        if (tresEnRaya[0][2] == 0 && tresEnRaya[1][1] == 0 && tresEnRaya[2][0] == 0) {
            lineasCeros++;
        }

        if (tresEnRaya[0][0] == 1 && tresEnRaya[1][1] == 1 && tresEnRaya[2][2] == 1) {
            lineasUno++;
        }
        if (tresEnRaya[0][2] == 1 && tresEnRaya[1][1] == 1 && tresEnRaya[2][0] == 1) {
            lineasUno++;
        }
        
        for (int i = 0; i < tresEnRaya.length; i++) {
            for (int j = 0; j < tresEnRaya[0].length; j++) {
                System.out.print(tresEnRaya[i][j]);
            }
            System.out.println();
        }

        System.out.println("Hay ceros " + lineasCeros);
        System.out.println("Hay unos " + lineasUno);
    }
}
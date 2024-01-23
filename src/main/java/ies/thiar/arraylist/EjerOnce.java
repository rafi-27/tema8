package ies.thiar.arraylist;

import java.util.concurrent.ThreadLocalRandom;

public class EjerOnce {
    public static void main(String[] args) {
        int[][] tresEnRaya = new int[3][3];

        for (int i = 0; i < tresEnRaya.length; i++) {
            for (int j = 0; j < tresEnRaya[0].length; j++) {
                tresEnRaya[i][j] = ThreadLocalRandom.current().nextInt(0,2);
            }
        }

        //Creamos los contadores:
        int contUno = 0;
        int contCero = 0;

        //Por columnas:
        if (tresEnRaya[0][0] == 0 && tresEnRaya[1][0] == 0 && tresEnRaya[2][0] == 0) {
            contCero++;
        }
        
        if (tresEnRaya[0][1] == 0 && tresEnRaya[1][1] == 0 && tresEnRaya[2][1] == 0) {
            contCero++;
        }

        if (tresEnRaya[0][2] == 0 && tresEnRaya[1][2] == 0 && tresEnRaya[2][2] == 0) {
            contCero++;
        }

        if (tresEnRaya[0][0] == 1 && tresEnRaya[1][0] == 1 && tresEnRaya[2][0] == 1) {
            contUno++;
        }
        
        if (tresEnRaya[0][1] == 1 && tresEnRaya[1][1] == 1 && tresEnRaya[2][1] == 1) {
            contUno++;
        }

        if (tresEnRaya[0][2] == 1 && tresEnRaya[1][2] == 1 && tresEnRaya[2][2] == 1) {
            contUno++;
        }

        //Por filas:
        if (tresEnRaya[0][0] == 0 && tresEnRaya[0][1] == 0 && tresEnRaya[0][2] == 0) {
            contCero++;
        }

        if (tresEnRaya[1][0] == 0 && tresEnRaya[1][1] == 0 && tresEnRaya[1][2] == 0) {
            contCero++;
        }

        if (tresEnRaya[2][0] == 0 && tresEnRaya[2][1] == 0 && tresEnRaya[2][2] == 0) {
            contCero++;
        }

        if (tresEnRaya[0][0] == 1 && tresEnRaya[0][1] == 1 && tresEnRaya[0][2] == 1) {
            contUno++;
        }

        if (tresEnRaya[1][0] == 1 && tresEnRaya[1][1] == 1 && tresEnRaya[1][2] == 1) {
            contUno++;
        }

        if (tresEnRaya[2][0] == 1 && tresEnRaya[2][1] == 1 && tresEnRaya[2][2] == 1) {
            contUno++;
        }

        //Diagonal:
        if (tresEnRaya[0][0] == 0 && tresEnRaya[1][1] == 0 && tresEnRaya[2][2] == 0) {
            contCero++;
        }
        if (tresEnRaya[0][2] == 0 && tresEnRaya[1][1] == 0 && tresEnRaya[2][0] == 0) {
            contCero++;
        }

        if (tresEnRaya[0][0] == 1 && tresEnRaya[1][1] == 1 && tresEnRaya[2][2] == 1) {
            contUno++;
        }
        if (tresEnRaya[0][2] == 1 && tresEnRaya[1][1] == 1 && tresEnRaya[2][0] == 1) {
            contUno++;
        }
        for (int i = 0; i < tresEnRaya.length; i++) {
            for (int j = 0; j < tresEnRaya.length; j++) {
                System.out.print(tresEnRaya[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("Lineas 0: "+contCero);
        System.out.println("Lineas 1: "+contUno);
        
        if (contCero>contUno) {
            System.out.println("Ha ganado el Cero con "+contCero+" movimientos correctos.");
        }else if (contUno > contCero) {
            System.out.println("Ha ganado el Uno con "+contUno+" movimientos correctos.");    
        } else{
            System.out.println("Empate!");
        }
    }
}

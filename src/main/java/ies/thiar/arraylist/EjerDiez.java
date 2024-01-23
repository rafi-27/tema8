package ies.thiar.arraylist;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class EjerDiez {
    //(i % 5 == 0)

    public static void main(String[] args) {
        multiplosDeNumeros(5, 5);
    }




    public static void multiplosDeNumeros(int filas, int columnas){
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = new int[filas][columnas];

        ArrayList<Integer>almacen = new ArrayList<>();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                matriz[i][j]=ThreadLocalRandom.current().nextInt(1,21);
            }
        }

        System.out.println("Introduce el numero v (ha de estar entre 1-20): ");
        int numero = teclado.nextInt();

        int cont=0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j]%numero==0) {
                    cont++;
                }
            }
            almacen.add(cont);
            cont=0;
        }

        int conti = 1;
        for (int i = 0; i < almacen.size(); i++) {
            System.out.println("Fila "+conti+ ": "+almacen.get(i));
            conti++;
        }
        teclado.close();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}
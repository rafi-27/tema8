package ies.thiar.vectores;

import java.util.Scanner;

public class Ejer9 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        /**
         * 9. Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores
         * enteros aleatorios entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N
         * y mostrará en qué posiciones del array aparece N. 
         */

         int[] numeros = new int[100];

         for (int i = 0; i < numeros.length; i++) {
            numeros[i]=(int) (1 + Math.random()*10);
         }

         //numero comprendido entre el 1 y el 10:
         int numeroN = teclado.nextInt();

         while (numeroN<0 || numeroN > 10) {
            System.out.println("Numero comprendido entre el 1 y 10");
            numeroN = teclado.nextInt();
         }

         for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]==numeroN) {
                System.out.println("El numero "+numeroN+" se encuentra en los indices: "+i);
            }
         }
        teclado.close();
    }
}

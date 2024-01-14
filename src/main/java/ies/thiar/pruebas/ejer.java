package ies.thiar.pruebas;

import java.util.Scanner;

public class ejer {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        /**
         * Programa Java que lea por teclado 10 números enteros y los guarde en un array. A
         * continuación calcula y muestra por separado la media de los valores positivos y la de los valores negativos.
         */



         int[] numeros = new int[10];

         for (int i = 0; i < numeros.length; i++) {
            numeros[i]=teclado.nextInt();
         }

         int sumaPosis=0;
         int sumaNega=0;

         for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]>0) {
                sumaPosis+=numeros[i];
            }

            if (numeros[i]<0) {
                sumaNega+=numeros[i];
            }
         }

         System.out.println("suma de los positivos: "+sumaPosis+" suma negativos: "+sumaNega);


         teclado.close();
    }
}

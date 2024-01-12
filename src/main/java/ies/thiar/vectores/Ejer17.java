package ies.thiar.vectores;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer17 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        /**
         * 17. Crea un programa que pida al usuario 20 valores enteros e introduzca los 10
         * primeros en un array y los 10 últimos en otro array. Por último, comparará ambos
         * arrays y le dirá al usuario si son iguales o no.
         */

        int[] primerArray=new int[10];
        int[] segundoArray=new int[10];

        for (int i = 0; i < primerArray.length; i++) {
            System.out.println("Primer array");
            System.out.println("Indice: "+i);
            primerArray[i]=teclado.nextInt();
        }

        for (int i = 0; i < segundoArray.length; i++) {
            System.out.println("Segundo array");
            System.out.println("Indice: "+i);
            segundoArray[i]=teclado.nextInt();
        }
        Arrays.sort(primerArray);
        Arrays.sort(segundoArray);
        System.out.println(Arrays.equals(primerArray, segundoArray)?"Son iguales":"No son iguales");
        teclado.close();
    }
}

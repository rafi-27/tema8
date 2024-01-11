package ies.thiar;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Ejer18 {
    public static void main(String[] args) {
        /**
         * Crea un programa que cree un array de tamaño 30 y lo rellene con valores aleatorios
         * entre 0 y 9. Luego ordena los valores del array y los mostrará por pantalla.
         */
        
         int[] numeros = new int[30];

         for (int i = 0; i < numeros.length; i++) {
            numeros[i]=ThreadLocalRandom.current().nextInt(0,10);
         }

         Arrays.sort(numeros);
         
         for (int i : numeros) {
            System.out.print(i+",");
         }
    }
}

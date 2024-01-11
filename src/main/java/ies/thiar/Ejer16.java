package ies.thiar;

import java.util.Arrays;

public class Ejer16 {
    public static void main(String[] args) {
        /**
         * 16. Crea un programa que cree un array de enteros e introduzca la siguiente secuencia
         * de valores: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, etc. hasta introducir 10 diez veces, y luego
         * la muestre por pantalla. En esta ocasión has de utilizar Arrays.fill().
         */

         int[] secuenciaValores = new int[53];

         for (int i = 1; i <= 10; i++) {
             for (int j = 1; j <= i; j++) {
                Arrays.fill(secuenciaValores,i); 
                 System.out.print(secuenciaValores[i]+",");
             }
         }
    }
}
package ies.thiar.vectores;


public class Ejer11 {
    public static void main(String[] args) {
        /**
         * 11. Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá
         * en el primer array todos los valores del 1 al 100. Por último, deberá copiar todos los
         * valores del primer array al segundo array en orden inverso, y mostrar ambos por
         * pantalla.
         */

         int[] original = new int[101];
         int[] copia = new int[101];

         for (int i = 0; i < original.length; i++) {
            original[i]=i;
            System.out.println(original[i]);
         }

         for (int i = original.length-1; i > 0; i--) {
            copia[i]=i;
            System.out.println(copia[i]);
         }

    }
}
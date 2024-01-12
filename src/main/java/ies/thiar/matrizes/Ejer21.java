package ies.thiar.matrizes;

public class Ejer21 {
    public static void main(String[] args) {
        /**
         * Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del
         * 1 al 25 y luego muestre la matriz por pantalla.
         */

         int[][] numeros = new int[5][5];

         for (int i = 0; i < numeros.length; i++) {
            numeros[i][i]=00;
         }

         for (int i = 0; i < numeros.length; i++) {
            System.out.println("Indice: "+i+" "+numeros[i][i]);
            
         }


    }
}

package ies.thiar.matrices;

public class Ejer21 {
    public static void main(String[] args) {
        /**
         * Crea un programa que cree una matriz de tamaño 5x5 que almacene los números del
         * 1 al 25 y luego muestre la matriz por pantalla.
         */

         int[][] numeros = new int[5][5];
         int cont=1;
         for (int i = 0; i < numeros[0].length; i++) {
            for (int j = 0; j < numeros.length; j++) {
               numeros[i][j]=cont;
               System.out.print(numeros[i][j]+" ");
               cont++;
            }
            System.out.println();
         }
    }
}
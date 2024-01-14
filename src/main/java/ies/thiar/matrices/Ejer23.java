package ies.thiar.matrices;

import java.util.Scanner;

public class Ejer23 {
    public static void main(String[] args) {
        /**
         * Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por
         * teclado) e introduzca en ella NxM valores (también introducidos por teclado). Luego
         * deberá recorrer la matriz y al final mostrar por pantalla cuántos valores son mayores
         * que cero, cuántos son menores que cero y cuántos son igual a cero.
         */

         matrizCeros(5, 2);

         
    }

    public static void matrizCeros(int numN, int numM){
        Scanner teclado = new Scanner(System.in);
        int[][] matriz = new int[numN][numM];

        System.out.println("Lontitud matriz: "+matriz.length+" filas y "+matriz[0].length+" columnas.");
        int contCeros=0;
        int contMayorCeros=0;
        int contMenorCeros=0;

        for (int i = 0; i < matriz.length; i++) {
            System.out.println("Fila numero: "+i);
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("Dato numero: "+i+"."+j);
                matriz[i][j]=teclado.nextInt();
            }
        }
        teclado.close();

        System.out.println();
        System.out.println("Aqui el resultado: ");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j]==0) {
                    contCeros++;
                }
                if (matriz[i][j]>0) {
                    contMayorCeros++;
                }
                if (matriz[i][j]<0) {
                    contMenorCeros++;
                }
            }
        }
        
        System.out.println("Hay "+contCeros+" iguales a cero,"+" mas grandes que cero hay "+contMayorCeros+", y menores a cero hay "+contMenorCeros);
        
        
        //for (int i = 0; i < matriz.length; i++) {
          //  for (int j = 0; j < matriz[0].length; j++) {
            //    System.out.println("Indice del array: "+i+"."+j);
              //  System.out.println(matriz[i][j]);
            //}
        //}
    }
}
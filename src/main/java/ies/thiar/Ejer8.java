package ies.thiar;

import java.util.Scanner;

public class Ejer8 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        /**
         * 8. Crea un programa que cree un array con 100 números reales aleatorios entre 0.0 y 1.0,
         * utilizando Math.random(), y luego le pida al usuario un valor real R. Por último,
         * mostrará cuántos valores del array son igual o superiores a R.
         */

         double[] numeros = new double[100];
        
        int contSupeiror=0;

         for (int i = 0; i < numeros.length; i++) {
            numeros[i] = Math.random();
        }
        
        double random = Math.random();
        System.out.println(random);

        System.out.println("Escribe un numero real: ");
        double numeroReal = teclado.nextDouble();
        //double numeroReal = random;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] >= numeroReal) {
                contSupeiror++;
            }
        }

        System.out.println("Hay superiores o iguales hay: "+contSupeiror);
        teclado.close();
    }
}
package ies.thiar.vectores;

import java.util.Scanner;

public class Ejer10 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        /**
         * 10. Crea un programa para realizar cálculos relacionados con la altura (en metros) de
         * personas. Pedirá un valor N y luego almacenará en un array N alturas introducidas por
         * teclado. Luego mostrará la altura media, máxima y mínima así como cuántas personas
         * miden por encima y por debajo de la media.
         */

         System.out.println("Valor del array: ");
         int personas = teclado.nextInt();
         double[] alturas = new double[personas];

         double media=0.0;
         double maxima=0.0;
         double minima=999999;

         int contPorEncima=0;
         int contPorDebajo=0;

         for (int i = 0; i < alturas.length; i++) {
            System.out.println("Indice: "+i+" indica la altura: ");
            alturas[i]=teclado.nextDouble();
            media+=alturas[i];
            if (alturas[i]>maxima) {
                maxima=alturas[i];
            }
            if (alturas[i]<minima) {
                minima=alturas[i];
            }
         }

         //sumar la media:

         media/=personas;
         
         for (int i = 0; i < alturas.length; i++) {
            if (alturas[i]>media) {
                contPorEncima++;
            }else{
                contPorDebajo++;
            }
         }

         System.out.println("Altura media: "+media);
         System.out.println("Altura maxima: "+maxima+" y la minima ha sido de "+minima);
         System.out.println("Por encima de la altura promedio hay "+contPorEncima+" y por debajo hay "+contPorDebajo);
    teclado.close();
    }
}

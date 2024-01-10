package ies.thiar;

import java.util.Scanner;

public class Ejer3 {
    public static void main(String[] args) {
        /**Crea un programa que pida diez números reales por teclado, 
         * los almacene en un array, y 
         * luego lo recorra para averiguar el máximo y mínimo y mostrarlos por pantalla. */
        Scanner teclado = new Scanner(System.in);

        float[] numeros = new float[10];
        
        float maximo=-99999999;
        float minimo=99999999;


        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce 10 numeros: ");
            numeros[i] = teclado.nextFloat();
        }

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]>maximo) {
                maximo = numeros[i];
            }
            if (numeros[i]<minimo) {
                minimo = numeros[i];
            }
        }
        
        System.out.println("El maximo es "+maximo+" y el minimo es "+minimo);
        teclado.close();
    }
}
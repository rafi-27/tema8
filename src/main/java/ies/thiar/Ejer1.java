package ies.thiar;

import java.util.Scanner;

public class Ejer1 {
    public static void main(String[] args) {
        //Ejercicio que pide 10 numeros por teclado y los almacene y printea:
        Scanner teclado = new Scanner(System.in);
        
        float[] numeros = new float[10];


        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce 10 numeros: ");
            numeros[i]=teclado.nextFloat();
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Indice: "+i+" tiene el valor "+numeros[i]);
        }




    }
}

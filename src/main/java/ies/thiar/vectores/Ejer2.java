package ies.thiar.vectores;

import java.util.Scanner;

public class Ejer2 {
    public static void main(String[] args) {
        // Ejercicio que pide 10 numeros por teclado y los almacene y los sume:
        Scanner teclado = new Scanner(System.in);

        float[] numeros = new float[10];
        float suma=0;
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce 10 numeros: ");
            numeros[i] = teclado.nextFloat();
            suma+=numeros[i];
        }
        System.out.println("La suma total es de: "+suma);
    teclado.close();
    }
}
package ies.thiar;

import java.util.Scanner;

public class Ejer5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //Pide 20 numeros los almacene y luego los recorra para dividir entre 20 para sacar
        //la media.

        int[] numeros = new int[20];
        int media=0;

        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Indice: "+i);
            numeros[i]=teclado.nextInt();
            media+=numeros[i];
        }
        media/=20;
        System.out.println("La media es de: "+media);
        teclado.close();
    }
}

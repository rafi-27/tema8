package ies.thiar;

import java.util.concurrent.ThreadLocalRandom;

public class Ejer20 {
    public static void main(String[] args) {
        /**
         * Crea un programa que cree un array de tamaño 1000 y lo rellene con valores enteros
         * aleatorios entre 0 y 99. Luego pedirá por teclado un valor N y se mostrará por pantalla
         * si N existe en el array, además de cuantas veces.
         */

        arrayMilNumeros(33);
    }


    public static void arrayMilNumeros(int valorN){
        int[] numeros = new int[1000];

        for (int i = 0; i < numeros.length; i++) {
            numeros[i]=ThreadLocalRandom.current().nextInt(0,100);
        }

        int cont=0;
        boolean valorEncontrado=false;

        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]==valorN) {
                valorEncontrado=true;
                cont++;
            }
        }

        System.out.println("El numero: "+valorN+(valorEncontrado?" existe":" no existe")+((valorEncontrado)?" aparecio "+cont+" veces":""));
    }
}

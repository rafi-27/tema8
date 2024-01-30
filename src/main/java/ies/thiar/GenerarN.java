package ies.thiar;

import java.util.concurrent.ThreadLocalRandom;

public class GenerarN {
    public static void main(String[] args) {
        /**
         * Generamos 1.000.000 de numeros entre 1 y 49.
         * Mostramos los 6 numeros que mas han aparecido de veces.
         */

        //iniciar una variable para almacenar los 6 numeros va a ser un array:

        int[] numeroElegido = new int[6];
        
        for (int i = 0; i < 1000000; i++) {
            numeroElegido[i]+= ThreadLocalRandom.current().nextInt(1,50);
        }

        for (int i = 0; i < numeroElegido.length; i++) {
            System.out.println(i);
        }

    }
}

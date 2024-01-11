package ies.thiar;

import java.util.Arrays;
import java.util.Scanner;

public class Ejer19 {
    public static void main(String[] args) {
        /**
         * Necesitamos crear un programa para mostrar el ranking de puntuaciones de un
         * torneo de ajedrez con 8 jugadores. Se le pedirá al usuario que introduzca las
         * puntuaciones de todos los jugadores (habitualmente valores entre 1000 y 2800, de
         * tipo entero) y luego muestre las puntuaciones en orden descendente (de la más alta a
         * la más baja).
         */
        puntuaciones(5);
    }

    public static void puntuaciones(int cantidad){
        Scanner teclado = new Scanner(System.in);
        int[] puntuaciones = new int[cantidad];
        
        for (int i = 0; i < puntuaciones.length; i++) {
            int numero;
            System.out.println("Puntuaciones van de 1000 a 2800, indice: "+i);
            numero=teclado.nextInt();
            if (numero>1000 && numero<2800) {
                puntuaciones[i]=numero;
            }else{
                if (numero>2800) {
                    System.err.println("Numero superior al limite.");
                }else if (numero<1000) {
                    System.err.println("Numero inferior al limite.");
                }
            }
        }
        
        Arrays.sort(puntuaciones);
        System.out.println("Puntuaciones en orden Descendente:");
        for (int i = puntuaciones.length-1; i < puntuaciones.length; i--) {
            System.out.println(puntuaciones[i]);
        }
        teclado.close();
    }
}
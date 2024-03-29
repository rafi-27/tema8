package ies.thiar.vectores;

public class Ejer13 {
    public static void main(String[] args) {
        SecuenciaAritmetica(1, 2, 10);

    }

    public static void SecuenciaAritmetica(int numerV, int numerI, int valoresN){
        /**
         * 13. Crea un programa que permita al usuario almacenar una secuencia aritmética en un
         * array y luego mostrarla. Una secuencia aritmética es una serie de números que
         * comienza por un valor inicial V, y continúa con incrementos de I. Por ejemplo, con V=1
         * e I=2, la secuencia sería 1, 3, 5, 7, 9… Con V=7 e I=10, la secuencia sería 7, 17, 27, 37…
         * El programa solicitará al usuario V, I además de N (nº de valores a crear).
         */
        int[] aritmetica = new int[valoresN];

        for (int i = 0; i < aritmetica.length; i++) {
            aritmetica[i]=numerV;
            numerV+=numerI;
        }
        for (int i : aritmetica) {
            System.out.println(i);
        }
    }
}
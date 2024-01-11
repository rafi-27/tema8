package ies.thiar;

public class Ejer13 {
    public static void main(String[] args) {
        SecuenciaAritmetica(1, 2, 9);

    }

    public static void SecuenciaAritmetica(int numerV, int numerI, int valoresN){
        int[] aritmetica = new int[valoresN];

        for (int i = numerV; i < aritmetica.length; i++) {
            System.out.print(aritmetica[i]+" ");
            aritmetica[i]+=numerI;
        }





    }
}